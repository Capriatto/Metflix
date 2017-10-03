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
	 * Permite hacer el cambio de contrase�a a los clientes
	 * @param usuario
	 * @param contrase�aNueva
	 * @throws InformacionRepetidaException
	 */
	public boolean cambioContrasena(String usuario, String contrase�aNueva) throws InformacionRepetidaException;
}
