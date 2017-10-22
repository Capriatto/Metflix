package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.edu.uniquindio.com.Empleado;
import excepciones.ElementoRegistradorException;
import excepciones.InformacionRepetidaException;

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

	@PersistenceContext
	private EntityManager entityManager;

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
			TypedQuery<Empleado> query = entityManager.createNamedQuery(Empleado.CREDENCIALES, Empleado.class);
			query.setParameter("cedula", cedula);
			return query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("Empleado no econtrado");
			return null;
		}
	}

	/**
	 * Metodo que permite eliminar un empleado.
	 * 
	 * @param cedula
	 * @return
	 */
	public boolean elimiarEmpleado(String cedula) {
		if (buscarEmpleadoPorNombreUsuario(cedula) != null) {
			try {
				TypedQuery<Empleado> query = entityManager.createNamedQuery(Empleado.REMOVER, Empleado.class);
				query.setParameter("cedula", cedula);
				return true;
			} catch (NoResultException e) {
				System.out.println("Empleado no econtrado");
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Metodo que permite modificar la informacion de un empleado
	 */
	public boolean modificarEmpleado(String cedula, String puesto, double salario) {
		if (buscarEmpleadoPorNombreUsuario(cedula) != null) {
			try {
				TypedQuery<Empleado> query = entityManager.createNamedQuery(Empleado.MODIFICAR, Empleado.class);
				query.setParameter("cedula", cedula);
				query.setParameter("puesto", puesto);
				query.setParameter("salario", salario);
				return true;
			} catch (NoResultException e) {
				System.out.println("Empleado no econtrado");
				return false;
			}
		}
		return false;
	}
	
}
