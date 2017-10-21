package Principal;

import Delegados.AdministradorDelegado;
import excepciones.ElementoRegistradorException;
import excepciones.InformacionRepetidaException;

public class Principal {
	private static final Principal instancia = new Principal();
	private AdministradorDelegado administradorDelegado = new AdministradorDelegado().getInstancia();

	public static Principal getInstancia() {
		return instancia;
	}

	public boolean registroEmpleado(String cedula, String apellido, String contrasena, String correo, int estado,
			String nombre, String usuario) throws ElementoRegistradorException, InformacionRepetidaException {
		return administradorDelegado.registroEmpleado(cedula, apellido, contrasena, correo, estado, nombre, usuario);
	}

	public Principal() {

	}

	public static void main(String[] args) {

	}

}
