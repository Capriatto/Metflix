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
public class AdministradorEJB {

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
		if (buscarEmpleadoPorNombreUsuario(usuario) != null) {
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
	 * Permite buscar un empleado por su nombre de usuario
	 * 
	 * @param usuario
	 *            Nombre del usuario
	 * @return el usuario encontrado
	 */
	private Empleado buscarEmpleadoPorNombreUsuario(String usuario) {
		try {
			TypedQuery<Empleado> query = entityManager.createNamedQuery(Empleado.CREDENCIALES, Empleado.class);
			query.setParameter("usuario", usuario);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
