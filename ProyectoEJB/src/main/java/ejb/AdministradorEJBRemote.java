package ejb;

import javax.ejb.Remote;

import excepciones.ElementoRegistradorException;
import excepciones.InformacionRepetidaException;

/**
 * Interfaz que determina los metodos de acceso del EJB de administrador.
 * 
 * @author German
 *
 */
@Remote
public interface AdministradorEJBRemote {
	String JNDI = "java:global/ProyectoEAR-Metflix/ProyectoEJB/AdministradorEJB!ejb.AdministradorEJBRemote";

	/**
	 * Permite registrar un empleado en la base de datos
	 * 
	 * @param Empleado
	 *            Empleado a ser agregado.
	 * @throws ElementoRegistradorException
	 *             Al momento de intentar agregar un elemento ya existe
	 * @throws InformacionRepetidaException
	 *             Al momento de agregar informacion que ya pertenece a un empleado
	 */
	public boolean registroEmpleado(String cedula, String apellido, String contrasena, String correo, int estado,
			String nombre, String usuario) throws ElementoRegistradorException, InformacionRepetidaException;
}
