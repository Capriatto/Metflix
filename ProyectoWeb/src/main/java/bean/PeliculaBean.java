package bean;

import java.sql.Date;
import java.text.ParseException;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.swing.JOptionPane;

import co.edu.uniquindio.com.Pelicula;
import ejb.AdministradorEJB;
import excepciones.ElementoRegistradorException;
import excepciones.InformacionRepetidaException;

/**
 * Permite gestionar las operaciones de los empleados
 * 
 * @author German
 *
 */
@ManagedBean
@SessionScoped
public class PeliculaBean {

	private Date añoLanzamiento;
	private String descripcion, nombre;
	private double precio;

	@EJB
	private AdministradorEJB administradorEJB;

	/**
	 * Metodo constructor
	 */
	public PeliculaBean() {

	}

	/**
	 * Metodo que permite registrar un empleado nuevo en la aplicacion
	 * 
	 * @return
	 * @throws ParseException 
	 */
	public String registrarPelicula() throws ParseException {
		try {
			if (administradorEJB.registroPelicula(añoLanzamiento, descripcion, 1, nombre, precio)) {
				Util.mostrarMensaje(FacesMessage.SEVERITY_INFO, "registro Exitoso");
				return "/pages/infoCliente";
			}
		} catch (ElementoRegistradorException e) {
			e.printStackTrace();
		} catch (InformacionRepetidaException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void limpiar() {
		añoLanzamiento=null;
		descripcion="";
		nombre="";
		precio=0;
	}

	// ----------------------------Proyecto web ultima entrega--------------------//
	//8.Buscar peliculas y muestra informacion
	
		/**
		 * Metodo que permite buscar una pelicula
		 * 
		 * @param cedula
		 * @return
		 */
		public String consultarPelicula(String nombre) {
			if (administradorEJB.buscarPeliculaPorNombre(nombre)!= null) {
				Pelicula pelicula=administradorEJB.buscarPeliculaPorNombre(nombre);
				añoLanzamiento=(Date) pelicula.getAnio_lanzamiento();
				descripcion=pelicula.getDescripcion();
				nombre=pelicula.getNombre();
				precio=pelicula.getPrecio();
				Util.mostrarMensaje(FacesMessage.SEVERITY_INFO, "Busqueda Exitosa");
				return "/pages/infoPelicula";
			}
			return null;
		}

		
	
	
	//4.Comprar Peliculas, confirmar por correo.
	
	//5.Calificar Peliculas
	
	//6.Ver Peliculas Recomendadas
	
	//7.Ver informacion de peliculas
	

	
	

	
	//------------------Metodo GET y SET------------------------//
		public Date getAñoLanzamiento() {
			return añoLanzamiento;
		}

		public void setAñoLanzamiento(Date añoLanzamiento) {
			this.añoLanzamiento = añoLanzamiento;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public double getPrecio() {
			return precio;
		}

		public void setPrecio(double precio) {
			this.precio = precio;
		}

		public AdministradorEJB getAdministradorEJB() {
			return administradorEJB;
		}

		public void setAdministradorEJB(AdministradorEJB administradorEJB) {
			this.administradorEJB = administradorEJB;
		}
	
	
	//----------------------------------------------------------//

}
