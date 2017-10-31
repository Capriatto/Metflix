package Principal;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import Delegados.AdministradorDelegado;
import Delegados.ClienteDelegado;
import co.edu.uniquindio.com.Administrador;
import co.edu.uniquindio.com.Cliente;
import co.edu.uniquindio.com.Empleado;
import co.edu.uniquindio.com.Pelicula;
import excepciones.ElementoRegistradorException;
import excepciones.InformacionRepetidaException;
import excepciones.PersonaNoEncontradaException;

/**
 * Clase que permite controlar los metodos de la capa de negocio
 * 
 * @author German
 *
 */
public class Principal {
	private static final Principal instancia = new Principal();
	private AdministradorDelegado administradorDelegado = new AdministradorDelegado().getInstancia();
	private ClienteDelegado clienteDelegado = new ClienteDelegado().getInstancia();

	public static Principal getInstancia() {
		return instancia;
	}

	/////////////////////// CRUD EMPLEADO////////////////

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
	public boolean eliminarEmpleado(String cedula, int estado)
			throws ElementoRegistradorException, InformacionRepetidaException {
		return administradorDelegado.eliminarEmpleado(cedula, estado);
	}

	/**
	 * Metodo para modificar un empleado
	 */
	public boolean modificarEmpleado(String cedula, String puesto, double salario)
			throws ElementoRegistradorException, InformacionRepetidaException {
		return administradorDelegado.modificarEmpleado(cedula, puesto, salario);
	}

	/**
	 * Metodo para recuperar contraseña empleado
	 * 
	 * @param cedula
	 * @return
	 * @throws PersonaNoEncontradaException
	 * @throws InformacionRepetidaException
	 * @throws ElementoRegistradorException
	 */
	public String recuperarContrasenia(String cedula)
			throws ElementoRegistradorException, InformacionRepetidaException {
		return administradorDelegado.recuperarContrasenia(cedula);
	}
	
	
	/**
	 *Metodo para buscar un administrador
	 * @param cedula
	 * @return
	 * @throws ElementoRegistradorException
	 * @throws InformacionRepetidaException
	 */
	public Administrador buscarAdministrador(String cedula)
			throws ElementoRegistradorException, InformacionRepetidaException {
		return administradorDelegado.buscarAdministrador(cedula);
	}
	
	/**
	 * Metodo para recuperar constraseña de un admin
	 * @param cedula
	 * @return
	 */
	public String recuperarContraseniaAdmin(String cedula) {
		return administradorDelegado.recuperarContraseniaAdmin(cedula);
	}

	///////////////////// CRUD PELICULA////////////////////////////
	/**
	 * Metodo delegado para registrar pelicula
	 */
	public boolean registroPelicula(Date añoLanzamiento, String descripcion, int estado, String nombre, double precio)
			throws ElementoRegistradorException, InformacionRepetidaException, ParseException {
		return administradorDelegado.registroPelicula(añoLanzamiento, descripcion, estado, nombre, precio);
	}

	/**
	 * Metodo delegado para buscar pelicula
	 */
	public Pelicula buscarPeliculaPorNombre(String nombre) {
		return administradorDelegado.buscarPeliculaPorNombre(nombre);
	}

	/**
	 * Metodo delegado para modificar pelicula
	 */
	public boolean modificarPelicula(Date añoLanzamiento, String descripcion, int estado, String nombre,
			double precio) throws ElementoRegistradorException, InformacionRepetidaException, ParseException {
		return administradorDelegado.modificarPelicula(añoLanzamiento, descripcion, estado, nombre, precio);
	}

	/**
	 * Metodo delegado para eliminar pelicula
	 */
	public boolean eliminarPelicula(String nombre, int estado) {
		return administradorDelegado.eliminarPelicula(nombre, estado);
	}
	
	/**
	 * Metodo delegado para obtener películas compradas en un rango de fechas.
	 */
	public long peliculasCompradasEntreFechas(Date desde, Date hasta) {
		return administradorDelegado.peliculasCompradasEntreFechas(desde, hasta);
	}

	/**
	 * Metodo delegado para obtener películas por su calificación
	 */
	public List<Pelicula> peliculasPorCalificacion(int calificacion) {
		return administradorDelegado.peliculasPorCalificacion(calificacion);
	}

	/////////////////////////////////////////////////////////////////////////////////

	//////////////////////////////// CRUD CLIENTE//////////////////////////////

	public Cliente buscarCliente(String user) throws ElementoRegistradorException, InformacionRepetidaException {
		return clienteDelegado.buscarCliente(user);
	}

	public boolean registroCliente(String cedula, String apellido, String contrasena, String correo, int estado,
			String nombre, String usuario) throws ElementoRegistradorException, InformacionRepetidaException {
		return clienteDelegado.registroCliente(cedula, apellido, contrasena, correo, estado, nombre, usuario);
	}
	
	public Cliente buscarClienteId(String id) {
		return clienteDelegado.buscarClienteId(id);
	}

	public Principal() {
	}

	public static void main(String[] args) {
	}

}
