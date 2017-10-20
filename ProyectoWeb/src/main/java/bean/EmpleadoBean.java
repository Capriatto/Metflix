package bean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

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
public class EmpleadoBean {

	private String cedula, apellido, contrasena, correo, nombre, usuario;
	private int estado;
	@EJB
	private AdministradorEJB administradorEJB;

	/**
	 * Metodo constructor
	 */
	public EmpleadoBean() {

	}

	/**
	 * Metodo que permite registrar un empleado nuevo en la aplicacion
	 * 
	 * @return
	 */
	public void registrarEmpleado() {
		try {
			if (administradorEJB.registroEmpleado(cedula, apellido, contrasena, correo, estado, nombre, usuario)) {
				cedula = "";
				apellido = "";
				contrasena = "";
				correo = "";
				estado = 0;
				nombre = "";
				usuario = "";
				Util.mostrarMensaje(FacesMessage.SEVERITY_INFO, "registro Exitoso");
			}
		} catch (ElementoRegistradorException e) {
			e.printStackTrace();
		} catch (InformacionRepetidaException e) {
			e.printStackTrace();
		}
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getContraseña() {
		return contrasena;
	}

	public void setContraseña(String contraseña) {
		this.contrasena = contraseña;
	}

	public String getCorrreo() {
		return correo;
	}

	public void setCorrreo(String corrreo) {
		this.correo = corrreo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
}
