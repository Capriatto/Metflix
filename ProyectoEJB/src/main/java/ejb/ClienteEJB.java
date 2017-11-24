package ejb;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.edu.uniquindio.com.Cliente;
import co.edu.uniquindio.com.Compra_pelicula;
import co.edu.uniquindio.com.Consulta_tecnica;
import co.edu.uniquindio.com.Empleado;
import excepciones.ElementoRegistradorException;
import excepciones.InformacionRepetidaException;
import excepciones.PersonaNoEncontradaException;

/**
 * Session Bean implementation class administradorEJB
 */
@Stateless
@LocalBean
public class ClienteEJB implements ClienteEJBRemote {
	EntityManager em;
	/**
	 * Default constructor.
	 */
	public ClienteEJB() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Metodo que permite registrar un cliente en la base de datos
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
		if (entityManager.find(Cliente.class, cedula) != null) {
			throw new ElementoRegistradorException(" ya fue registrado");
		}
		if (buscarClienteId(cedula) != null) {
			throw new InformacionRepetidaException("Usuario ya existe");
		} else {
			Cliente cliente = new Cliente();
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
	
	
	
	
	
	/**
	 * Permite buscar un cliente por su nombre de usuario
	 * 
	 * @param usuario
	 *            Nombre del usuario
	 * @return el usuario encontrado
	 */
	public Cliente buscarCliente(String usuario) {
		try {
			TypedQuery<Cliente> query = entityManager.createNamedQuery(Cliente.CREDENCIALES, Cliente.class);
			query.setParameter("usuario", usuario);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public Cliente buscarClienteId(String id) {
		try {
			TypedQuery<Cliente> query = entityManager.createNamedQuery(Cliente.GET_ALL, Cliente.class);
			query.setParameter("cedula", id);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	

	/**
	 * Metodo que permite registrar una consulta técnica en la base de datos
	 * 
	 * @param id
	 * @param consulta
	 * @param estado
	 * @param f_consulta_tecnica
	 * @param cliente
	 * @param empleado
	 * @return
	 */
	public boolean registroConsultaTecnica(String consulta, int estado, Date f_consulta_tecnica,
		Cliente cliente, Empleado empleado) {
		Consulta_tecnica consulta_tec = new Consulta_tecnica();
		consulta_tec.setConsulta(consulta);
		consulta_tec.setEstado(estado);
		consulta_tec.setF_consultatecnica(f_consulta_tecnica);
		consulta_tec.setCliente_id(cliente);
		consulta_tec.setEmpleado_id(empleado);
		entityManager.persist(consulta_tec);
		return true;

	}

	/**
	 * Permite hacer el cambio de contraseña a los clientes
	 * 
	 * @param usuario
	 * @param contraseñaNueva
	 * @throws InformacionRepetidaException
	 */

	public boolean cambioContrasena(String usuario, String contrasenaNueva) throws InformacionRepetidaException {

		Cliente cliente =buscarCliente(usuario);

		if (cliente.getContrasena().equals(contrasenaNueva)) {
			throw new InformacionRepetidaException("Ah colocado la contraseña actual");
		} else {
			cliente.setContrasena(contrasenaNueva);
			entityManager.persist(cliente);
			return true;
		}
	}

	/**
	 * Metodo que permite registrar una compra de una pelicula
	 * 
	 * @param id
	 * @param F_COMPRA
	 * @param CLIENTE_ID_cedula
	 * @return devuelve true si la compra fue registrada con exito
	 * @throws InformacionRepetidaException
	 */
	public boolean registroCompraPelicula(int id, Date F_COMPRA, Cliente CLIENTE_ID_cedula)
			throws InformacionRepetidaException {
		if (buscarCompra(id) != null) {
			throw new InformacionRepetidaException("Id compra ya fue asignada previamente");
		} else {
			Compra_pelicula compra = new Compra_pelicula();
			compra.setId(id);
			compra.setF_compra(F_COMPRA);
			compra.setCliente_id(CLIENTE_ID_cedula);
			entityManager.persist(compra);
			return true;
		}
	}

	/**
	 * Permite buscar un empleado por su nombre de usuario
	 * 
	 * @param usuario
	 *            Nombre del usuario
	 * @return el usuario encontrado
	 */
	private Compra_pelicula buscarCompra(int id) {
		try {
			TypedQuery<Compra_pelicula> query = entityManager.createNamedQuery(Compra_pelicula.GET_VENTA,
					Compra_pelicula.class);
			query.setParameter("idCompra", id);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	/**
	 * Metodo para recuperar la contrasenia de un empleado
	 * 
	 * @param cedula
	 * @return
	 * @throws PersonaNoEncontradaException
	 */

	public String recuperarContrasenia(String cedula) throws PersonaNoEncontradaException {
		Empleado empleado = new Empleado();

		if (entityManager.find(Empleado.class, cedula) != null) {
			System.out.println("Persona no encontrada");
		}

		empleado = entityManager.find(Empleado.class, cedula);

		return empleado.getContrasena();

	}


}
