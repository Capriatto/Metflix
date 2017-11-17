//package bean;
//
//
//
//
//import java.util.Date;
//
//import javax.ejb.EJB;
//import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
//
//import co.edu.uniquindio.com.Empleado;
//import ejb.AdministradorEJB;
//import excepciones.ElementoRegistradorException;
//import excepciones.InformacionRepetidaException;
//
///**
// * Permite gestionar las operaciones de los empleados
// * 
// * @author German
// *
// */
//@ManagedBean
//@SessionScoped
//public class RegistroPeliculaBean {
//
//	private String nombre, descripcion;
//	private Date anio_lanzamiento;
//	private double precio;
//	
//	
//	
//	@EJB
//	private AdministradorEJB administradorEJB;
//
//	/**
//	 * Metodo constructor
//	 */
//	public RegistroPeliculaBean() {
//
//	}
//
//	
//	public String registrarPelicula() {
//		try {
//			if (administradorEJB.registroPelicula(anio_lanzamiento, descripcion, 1, nombre, precio){
//				Util.mostrarMensaje(FacesMessage.SEVERITY_INFO, "registro Exitoso");
//				return "/pages/infoEmpleado";
//			}
//		} catch (ElementoRegistradorException e) {
//			e.printStackTrace();
//		} catch (InformacionRepetidaException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	public void limpiarEmpleado() {
//
//		nombre="";
//		anio_lanzamiento=null;
//		descripcion="";
//	    precio=0.0;
//	}
//
//
//	
//}
