package ejb;

import java.sql.Date;
import java.text.ParseException;

import javax.ejb.Remote;

import co.edu.uniquindio.com.Empleado;
import co.edu.uniquindio.com.Pelicula;
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

	///////////////////// CRUD EMPLEADO//////////////////////////////

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
	public boolean eliminarEmpleado(String cedula, int estado)
			throws ElementoRegistradorException, InformacionRepetidaException;

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
	 * 
	 * @param cedula
	 * @return
	 */
	public String recuperarContrasenia(String cedula) throws ElementoRegistradorException, InformacionRepetidaException;

	///////////////////////// CRUD PELICULA///////////////////////////

	/**
	 * Metodo que permite registrar una pelicula
	 * @param id
	 * @param añoLanzamiento
	 * @param descripcion
	 * @param estado
	 * @param nombre
	 * @param precio
	 * @return
	 * @throws ElementoRegistradorException
	 * @throws InformacionRepetidaException
	 * @throws ParseException
	 */
	public boolean registroPelicula(Date añoLanzamiento, String descripcion, int estado, String nombre,
			double precio) throws ElementoRegistradorException, InformacionRepetidaException, ParseException;
	
	/**
	 * Metodo que permite buscar una pelicula
	 * @param id
	 * @return
	 */
	public Pelicula buscarPeliculaPorNombre(String nombre);
	
	/**
	 * Metodo que permite actualizar una pelicula
	 * @param id
	 * @param añoLanzamiento
	 * @param descripcion
	 * @param estado
	 * @param nombre
	 * @param precio
	 * @return
	 * @throws ParseException
	 */
	public boolean modificarPelicula(String añoLanzamiento, String descripcion, int estado, String nombre,
			double precio) throws ParseException;
	
	/**
	 * Metodo que permite eliminar una pelicula
	 * @param id
	 * @param estado
	 * @return
	 */
	public boolean eliminarPelicula(String nombre, int estado);
	

}
