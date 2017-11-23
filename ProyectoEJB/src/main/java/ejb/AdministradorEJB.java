package ejb;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.edu.uniquindio.com.Administrador;
import co.edu.uniquindio.com.Cliente;
import co.edu.uniquindio.com.Compra_pelicula;
import co.edu.uniquindio.com.Empleado;
import co.edu.uniquindio.com.Pelicula;
import excepciones.ElementoRegistradorException;
import excepciones.InformacionRepetidaException;
import excepciones.PersonaNoEncontradaException;

/**
 * Session Bean implementation class administradorEJB
 */
@Stateless
@LocalBean
public class AdministradorEJB implements AdministradorEJBRemote {

	/**
	 * Default constructor.
	 */
	public AdministradorEJB() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Carga lista de empleados
	 * @return
	 */
	public List<Empleado> generarListaEmpleados(){
		return entityManager.createNamedQuery(Empleado.GET_TODOS, Empleado.class).getResultList();
	}

	@PersistenceContext
	private EntityManager entityManager;

	/////////////////// CRUD EMPLEADO///////////////////////////////////////

	/**
	 * Metodo que permite registrar un empleado en la base de datos
	 * 
	 * @param cedula
	 * @param apellido
	 * @param contrasena
	 * @param correo
	 * @param estado
	 * @param nombre
	 * @param usuario
	 * @return devuelve true si el empleado fue registrado con exito
	 * @throws ElementoRegistradorException
	 * @throws InformacionRepetidaException
	 */
	public boolean registroEmpleado(String cedula, String apellido, String contrasena, String correo, int estado,
			String nombre, String usuario) throws ElementoRegistradorException, InformacionRepetidaException {
		if (entityManager.find(Empleado.class, cedula) != null) {
			throw new ElementoRegistradorException("Empleado ya fue registrado");
		}
		if (buscarEmpleadoPorNombreUsuario(cedula) != null) {
			throw new InformacionRepetidaException("Usuario ya existe");
		} else {
			Empleado empleado = new Empleado();
			empleado.setCedula(cedula);
			empleado.setApellido(apellido);
			empleado.setContrasena(contrasena);
			empleado.setCorreo(correo);
			empleado.setEstado(estado);
			empleado.setNombre(nombre);
			empleado.setUsuario(usuario);
			entityManager.persist(empleado);
			return true;
		}
	}

	/**
	 * Permite buscar un empleado por su id
	 * 
	 * @param cedula
	 *            cedula empleado
	 * @return el usuario encontrado
	 */
	public Empleado buscarEmpleadoPorNombreUsuario(String cedula) {
		try {
			TypedQuery<Empleado> query = entityManager.createNamedQuery(Empleado.GET_ALL, Empleado.class);
			query.setParameter("cedula", cedula);
			return query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("Empleado no econtrado");
			return null;
		}
	}
	

	/**
	 * Permite buscar un cliente por su id
	 * 
	 * @param cedula
	 *            cedula cliente
	 * @return el usuario encontrado
	 */
	public Cliente buscarCliente(String cedula) {
		try {
			TypedQuery<Cliente> query = entityManager.createNamedQuery(Cliente.GET_ALL, Cliente.class);
			query.setParameter("cedula", cedula);
			return query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("cliente no encontrado");
			return null;
		}
	}
	
	/**
	 * Permite buscar un administrador por su id
	 * 
	 * @param cedula
	 *            cedula admin
	 * @return el usuario encontrado
	 */
	public Administrador buscarAdministrador(String cedula) {
		try {
			TypedQuery<Administrador> query = entityManager.createNamedQuery(Administrador.GET_ALL, Administrador.class);
			query.setParameter("cedula", cedula);
			return query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("Adminstrador no encontrado");
			return null;
		}
	}

	/**
	 * Metodo que permite eliminar un empleado.
	 * 
	 * @param cedula
	 * @return
	 */
	public boolean eliminarEmpleado(String cedula, int estado) {
		if (buscarEmpleadoPorNombreUsuario(cedula) != null) {
			try {

				Empleado empleado = entityManager.find(Empleado.class, cedula);
				empleado.setEstado(estado);
				entityManager.merge(empleado);
				return true;
			} catch (NoResultException e) {
				System.out.println("Empleado no econtrado");
				return false;
			}
		}
		return false;
	}

	/**
	 * Metodo que permite modificar la informacion de un empleado
	 */
	public boolean modificarEmpleado(String cedula, String puesto, double salario) {
		if (buscarEmpleadoPorNombreUsuario(cedula) != null) {
			try {
				Empleado empleado = entityManager.find(Empleado.class, cedula);
				if(!puesto.equals(""))
					empleado.setPuesto(puesto);
				if(salario!=0.0)
					empleado.setSueldo(salario);
				entityManager.merge(empleado);
				return true;
			} catch (NoResultException e) {
				return false;
			}
		}
		return false;
	}

	/**
	 * Metodo para recuperar la contrasenia de un empleado
	 * 
	 * @param cedula
	 * @return
	 * @throws PersonaNoEncontradaException
	 */

	public String recuperarContrasenia(String cedula) {
		Empleado empleado = new Empleado();
		if (entityManager.find(Empleado.class, cedula) != null) {
			System.out.println("Empleado no encontrado");
		}
		empleado = entityManager.find(Empleado.class, cedula);
		return empleado.getContrasena();
	}
	
	/**
	 * Metodo para recuperar constraseña administrador
	 * @param cedula
	 * @return
	 */
	public String recuperarContraseniaAdmin(String cedula) {
		Administrador admin= new Administrador();
		if (entityManager.find(Administrador.class, cedula) != null) {
			System.out.println("Empleado no encontrado");
		}
		admin = entityManager.find(Administrador.class, cedula);
		return admin.getContrasena();
	}
	
	

	////////////////////// CRUD PELICULA/////////////////////////////////////

	/**
	 * Metodo para registrar una pelicula
	 * 
	 * @param id
	 * @param añoLanzamiento
	 * @param descripcion
	 * @param estado
	 * @param nombre
	 * @param precio
	 * @return
	 * @throws ElementoRegistradorException
	 * @throws InformacionRepetidaException
	 * @throws ParseException
	 */
	public boolean registroPelicula(Date añoLanzamiento, String descripcion, int estado, String nombre,
			double precio) throws ElementoRegistradorException, InformacionRepetidaException, ParseException {
		if (buscarPeliculaPorNombre(nombre) != null) {
			throw new ElementoRegistradorException("Pelicula ya fue registrada");
		}
		if (buscarPeliculaPorNombre(nombre) != null) {
			throw new InformacionRepetidaException("Pelicula ya existe");
		} else {
			String fecha = String.valueOf(añoLanzamiento);
			Date año;
			DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			año = (Date) formato.parse(fecha);
			Pelicula pelicula = new Pelicula();
			pelicula.setAnio_lanzamiento(año);
			pelicula.setDescripcion(descripcion);
			pelicula.setEstado(estado);
			pelicula.setNombre(nombre);
			pelicula.setPrecio(precio);
			entityManager.persist(pelicula);
			return true;
		}
	}

	/**
	 * Metodo para buscar pelicula
	 * 
	 * @param id
	 * @return
	 */
	public Pelicula buscarPeliculaPorNombre(String nombre) {
		try {
			TypedQuery<Pelicula> query = entityManager.createNamedQuery(Pelicula.GET_ALL, Pelicula.class);
			query.setParameter("nombre", nombre);
			return query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("Pelicula no econtrada");
			return null;
		}
	}

	/**
	 * Metodo que permite modificar la informacion de una pelicula
	 * 
	 * @throws ParseException
	 */
	public boolean modificarPelicula(Date añoLanzamiento, String descripcion, int estado, String nombre,
			double precio)throws ElementoRegistradorException, InformacionRepetidaException, ParseException {
		if (buscarPeliculaPorNombre(nombre) != null) {
			try {
				Pelicula pelicula = buscarPeliculaPorNombre(nombre);				
				pelicula.setAnio_lanzamiento(añoLanzamiento);
				pelicula.setDescripcion(descripcion);				
				pelicula.setPrecio(precio);
				entityManager.merge(pelicula);
				return true;
			} catch (NoResultException e) {
				System.out.println("Proceso no compleatado");
				return false;
			}
		}
		return false;
	}

	/**
	 * Metodo que permite eliminar una pelicula.
	 * 
	 * @param cedula
	 * @return
	 */
	public boolean eliminarPelicula(String nombre, int estado) {
		if (buscarPeliculaPorNombre(nombre) != null) {
			try {

				Pelicula pelicula = buscarPeliculaPorNombre(nombre);
				pelicula.setEstado(estado);
				entityManager.merge(pelicula);
				return true;
			} catch (NoResultException e) {
				System.out.println("Pelicula no econtrada");
				return false;
			}
		}
		return false;
	}
	
	/**
	 * Metodo que retorna las compras realizadas en un periodo dado
	 * 
	 * @param id
	 * @return
	 */
	public long peliculasCompradasEntreFechas(Date desde, Date hasta) {
		try {
		    TypedQuery<Long> query = entityManager.createNamedQuery(Compra_pelicula.GET_PELICULASRANGOFECHAS, Long.class);
			query.setParameter("desde", desde);
			query.setParameter("hasta", hasta);
			return (Long)query.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * Metodo que retorna las peliculas con determinada calificacion
	 * 
	 * @param id
	 * @return
	 */
	public List<Pelicula> peliculasPorCalificacion(int calificacion) {
		TypedQuery<Pelicula> query = entityManager.createNamedQuery(Pelicula.GET_PELICULASCALIFICADAS, Pelicula.class );
		query.setParameter("calificacion", calificacion);
		List<Pelicula> res = query.getResultList(); 
		return res;
	}
	
	
	
	//-----------------------------------------CRUD CLIENTE-----------------------------//
	
	
	//---------------------Registro Cliente------------------------//
	/**
	 * Metodo que permite registrar un Cliente en la base de datos
	 * 
	 * @param cedula
	 * @param apellido
	 * @param contrasena
	 * @param correo
	 * @param estado
	 * @param nombre
	 * @param usuario
	 * @return devuelve true si el empleado fue registrado con exito
	 * @throws ElementoRegistradorException
	 * @throws InformacionRepetidaException
	 */
	public boolean registroCliente(String cedula, String apellido, String contrasena, String correo, int estado,
			String nombre, String usuario) throws ElementoRegistradorException, InformacionRepetidaException {
		if (entityManager.find(Empleado.class, cedula) != null) {
			throw new ElementoRegistradorException("Cliente ya fue registrado");
		}
		if (buscarEmpleadoPorNombreUsuario(cedula) != null) {
			throw new InformacionRepetidaException("Usuario ya existe");
		} else {
			Cliente cliente = new  Cliente();
			cliente.setCedula(cedula);
			cliente.setApellido(apellido);
			cliente.setContrasena(contrasena);
			cliente.setCorreo(correo);
			cliente.setEstado(estado);
			cliente.setNombre(nombre);
			cliente.setUsuario(usuario);
			entityManager.persist(cliente);
			return true;
		}
	}
	
	//---------------------------------------------------------------------//
	
}
