package Delegados;

import javax.naming.InitialContext;

import co.edu.uniquindio.com.Empleado;
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
	 * 
	 * @return
	 */
	public static AdministradorDelegado getInstancia() {
		return instancia;
	}

	/**
	 * Metodo delegado para el registro de empleado
	 */
	public boolean registroEmpleado(String cedula, String apellido, String contrasena, String correo, int estado,
			String nombre, String usuario) throws ElementoRegistradorException, InformacionRepetidaException {
		return adminEJB.registroEmpleado(cedula, apellido, contrasena, correo, estado, nombre, usuario);
	}

	/**
	 * Metodo delegado para buscar empleado por nombre de usuario
	 */
	public Empleado buscarEmpleadoPorNombreUsuario(String cedula)
			throws ElementoRegistradorException, InformacionRepetidaException {
		return adminEJB.buscarEmpleadoPorNombreUsuario(cedula);
	}

	/**
	 * Metodo delegado para eliminar un empleado
	 */
	public boolean elimiarEmpleado(String cedula, int estado) throws ElementoRegistradorException, InformacionRepetidaException {
		return adminEJB.elimiarEmpleado(cedula, estado);
	}

	/**
	 * Metodo delegado para modificar un empleado
	 */
	public boolean modificarEmpleado(String cedula, String puesto, double salario)
			throws ElementoRegistradorException, InformacionRepetidaException {
		return adminEJB.modificarEmpleado(cedula, puesto, salario);
	}

}
