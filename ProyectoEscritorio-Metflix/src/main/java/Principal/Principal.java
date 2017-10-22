package Principal;

import Delegados.AdministradorDelegado;
import co.edu.uniquindio.com.Empleado;
import excepciones.ElementoRegistradorException;
import excepciones.InformacionRepetidaException;

/**
 * Clase que permite controlar los metodos de la capa de negocio
 * 
 * @author German
 *
 */
public class Principal {
	private static final Principal instancia = new Principal();
	private AdministradorDelegado administradorDelegado = new AdministradorDelegado().getInstancia();

	public static Principal getInstancia() {
		return instancia;
	}

	/**
	 * Metodo para registar empleado
	 * 
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
	public boolean registroEmpleado(String cedula, String apellido, String contrasena, String correo, int estado,
			String nombre, String usuario) throws ElementoRegistradorException, InformacionRepetidaException {
		return administradorDelegado.registroEmpleado(cedula, apellido, contrasena, correo, estado, nombre, usuario);
	}

	/**
	 * Metodo para buscar empleado
	 * 
	 * @param cedula
	 * @return
	 * @throws ElementoRegistradorException
	 * @throws InformacionRepetidaException
	 */
	public Empleado buscarEmpleadoPorNombreUsuario(String cedula)
			throws ElementoRegistradorException, InformacionRepetidaException {
		return administradorDelegado.buscarEmpleadoPorNombreUsuario(cedula);
	}

	/**
	 * Metodo para eliminar un empleado
	 */
	public boolean elimiarEmpleado(String cedula) throws ElementoRegistradorException, InformacionRepetidaException {
		return administradorDelegado.elimiarEmpleado(cedula);
	}

	/**
	 * Metodo para modificar un empleado
	 */
	public boolean modificarEmpleado(String cedula, String puesto, double salario)
			throws ElementoRegistradorException, InformacionRepetidaException {
		return administradorDelegado.modificarEmpleado(cedula, puesto, salario);
	}

	public Principal() {

	}

	public static void main(String[] args) {

	}

}
