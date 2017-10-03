package ejb;

import javax.ejb.Remote;

import excepciones.ElementoRegistradorException;
import excepciones.InformacionRepetidaException;

/**
 * Interfaz que determina los metodos de acceso del EJB del cliente.
 * 
 * @author German
 *
 */
@Remote
public interface ClienteEJBRemote {
	/**
	 * Permite hacer el cambio de contraseña a los clientes
	 * @param usuario
	 * @param contraseñaNueva
	 * @throws InformacionRepetidaException
	 */
	public boolean cambioContrasena(String usuario, String contraseñaNueva) throws InformacionRepetidaException;
}
