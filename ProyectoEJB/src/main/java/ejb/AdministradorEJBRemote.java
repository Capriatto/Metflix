package ejb;

import javax.ejb.Remote;

import co.edu.uniquindio.com.Empleado;
import excepciones.ElementoRegistradorException;
import excepciones.InformacionRepetidaException;
import excepciones.PersonaNoEncontradaException;

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

	/**
	 * Buscar un empleado por cedula
	 * 
	 * @param usuario
	 * @return
	 */
	public Empleado buscarEmpleadoPorNombreUsuario(String cedula)
			throws ElementoRegistradorException, InformacionRepetidaException;

	/**
	 * Metodo que elimina un empleado
	 * 
	 * @param cedula
	 * @return
	 */
	public boolean elimiarEmpleado(String cedula, int estado) throws ElementoRegistradorException, InformacionRepetidaException;

	/**
	 * Metodo que permite actualizar la informacion de un empleado
	 * 
	 * @param cedula
	 * @param puesto
	 * @param salario
	 * @return
	 */
	public boolean modificarEmpleado(String cedula, String puesto, double salario)
			throws ElementoRegistradorException, InformacionRepetidaException;
	
	/**
	 * Metodo que permite recuperar constraseña de un empleado
	 * @param cedula
	 * @return
	 */
	public String recuperarContrasenia(String cedula)throws ElementoRegistradorException,InformacionRepetidaException;
		

}
