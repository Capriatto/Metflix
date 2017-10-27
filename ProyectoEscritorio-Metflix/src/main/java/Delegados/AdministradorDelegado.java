package Delegados;

import java.sql.Date;
import java.text.ParseException;

import javax.naming.InitialContext;

import co.edu.uniquindio.com.Administrador;
import co.edu.uniquindio.com.Cliente;
import co.edu.uniquindio.com.Empleado;
import co.edu.uniquindio.com.Pelicula;
import ejb.AdministradorEJBRemote;
import excepciones.ElementoRegistradorException;
import excepciones.InformacionRepetidaException;
import excepciones.PersonaNoEncontradaException;
/**
 * @author Juan Sebastian Ocampo Ospina
 * @author German Felipe Valencia Hurtado
 * @author Carlos Alberto Lopez Mazo
 */
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

	/////////////////// CRUD EMPLEADO/////////////////////////////
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
	public boolean eliminarEmpleado(String cedula, int estado)
			throws ElementoRegistradorException, InformacionRepetidaException {
		return adminEJB.eliminarEmpleado(cedula, estado);
	}

	/**
	 * Metodo delegado para modificar un empleado
	 */
	public boolean modificarEmpleado(String cedula, String puesto, double salario)
			throws ElementoRegistradorException, InformacionRepetidaException {
		return adminEJB.modificarEmpleado(cedula, puesto, salario);
	}

	/**
	 * Metodo delegado para recuperar constraseña
	 */
	public String recuperarContrasenia(String cedula)
			throws ElementoRegistradorException, InformacionRepetidaException {
		return adminEJB.recuperarContrasenia(cedula);
	}

	///////////////////////// CRUD PELICULA//////////////////////////////

	/**
	 * Metodo delegado para registrar pelicula
	 */
	public boolean registroPelicula(Date añoLanzamiento, String descripcion, int estado, String nombre,
			double precio) throws ElementoRegistradorException, InformacionRepetidaException, ParseException {
		return adminEJB.registroPelicula(añoLanzamiento, descripcion, estado, nombre, precio);
	}

	/**
	 * Metodo delegado para buscar pelicula
	 */
	public Pelicula buscarPeliculaPorNombre(String nombre) {
		return adminEJB.buscarPeliculaPorNombre(nombre);
	}

	/**
	 * Metodo delegado para modificar pelicula
	 */
	public boolean modificarPelicula(String añoLanzamiento, String descripcion, int estado, String nombre,
			double precio) throws ParseException {
		return adminEJB.modificarPelicula(añoLanzamiento, descripcion, estado, nombre, precio);
	}

	/**
	 * Metodo delegado para eliminar pelicula
	 */
	public boolean eliminarPelicula(String nombre, int estado) {
		return adminEJB.eliminarPelicula(nombre, estado);
	}

	
	public Administrador buscarAdministrador(String cedula)
			throws ElementoRegistradorException, InformacionRepetidaException {
		return adminEJB.buscarAdministrador(cedula);
	}

	
}
