package ejb;

import java.util.Date;

import javax.ejb.Remote;

import co.edu.uniquindio.com.Cliente;
import co.edu.uniquindio.com.Empleado;
import excepciones.ElementoRegistradorException;
import excepciones.InformacionRepetidaException;

/**
 * Interfaz que determina los metodos de acceso del EJB de Cliente.
 **/
@Remote
public interface ClienteEJBRemote {
	String JNDI = "java:global/ProyectoEAR-Metflix/ProyectoEJB/ClienteEJB!ejb.ClienteEJBRemote";

	/**
	 * Metodo que permite registrar un empleado
	 * @param cedula
	 * @param apellido
	 * @param contrasena
	 * @param correo
	 * @param estado
	 * @param nombre
	 * @param usuario
	 * @return
	 * @throws ElementoRegistradorException
	 * @throws InformacionRepetidaException
	 */
	public boolean registroCliente(String cedula, String apellido, String contrasena, String correo, int estado,
			String nombre, String usuario) throws ElementoRegistradorException, InformacionRepetidaException;
	
	
	
	/**
	 * Permite hacer el cambio de contraseña a los clientes
	 * 
	 * @param usuario
	 * @param contraseñaNueva
	 * @throws InformacionRepetidaException
	 */

	public boolean cambioContrasena(String usuario, String contraseñaNueva) throws InformacionRepetidaException;

	/**
	 * Permite registrar una consulta tecnica en una base de datos
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
			Cliente cliente, Empleado empleado);

	/**
	 * Permite registrar una compra de película en una base de datos
	 * 
	 * @param id
	 * @param F_COMPRA
	 * @param CLIENTE_ID_cedula
	 * @return
	 * @throws InformacionRepetidaException
	 */
	public boolean registroCompraPelicula(int id, Date F_COMPRA, Cliente CLIENTE_ID_cedula)
			throws InformacionRepetidaException;

	/**
	 * Metodo para buscar un cliente
	 * 
	 * @param usuario
	 * @return
	 */
	public Cliente buscarCliente(String usuario);
	
	public Cliente buscarClienteId(String id);
}
