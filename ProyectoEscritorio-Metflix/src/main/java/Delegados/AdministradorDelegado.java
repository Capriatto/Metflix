package Delegados;

import javax.naming.InitialContext;

import ejb.AdministradorEJBRemote;
import excepciones.ElementoRegistradorException;
import excepciones.InformacionRepetidaException;

public class AdministradorDelegado implements AdministradorEJBRemote {
	private AdministradorEJBRemote adminEJB;
	private static final AdministradorDelegado instancia = new AdministradorDelegado();

	/**
	 * Metodo Constructor, permite auditar metodos nuevos en el EJB de administrador
	 */
	public AdministradorDelegado() {
		try {
			adminEJB = (AdministradorEJBRemote) new InitialContext().lookup(AdministradorEJBRemote.JNDI);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que permite generar solo una instacia del delegado
	 * @return
	 */
	public static AdministradorDelegado getInstancia() {
		return instancia;
	}

	public boolean registroEmpleado(String cedula, String apellido, String contrasena, String correo, int estado,
			String nombre, String usuario) throws ElementoRegistradorException, InformacionRepetidaException {
		return adminEJB.registroEmpleado(cedula, apellido, contrasena, correo, estado, nombre, usuario);
	}

	

}
