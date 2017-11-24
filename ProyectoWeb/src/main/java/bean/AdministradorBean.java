package bean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.swing.JOptionPane;

import co.edu.uniquindio.com.Persona;
import ejb.AdministradorEJB;
import ejb.EmailSenderService;
import excepciones.ElementoRegistradorException;
import excepciones.InformacionRepetidaException;

/**
 * Permite gestionar las operaciones de los empleados
 * 
 * @author German
 *
 */
@ManagedBean
public class AdministradorBean {

	private String cedula, apellido, contrasena, correo, nombre, usuario;
	private int estado;
	@EJB
	private AdministradorEJB administradorEJB;

	/**
	 * Metodo constructor
	 */
	public AdministradorBean() {

	}

	/**
	 * Metodo que permite registrar un empleado nuevo en la aplicacion
	 * 
	 * @return
	 */
	public void registrarEmpleado() {
		try {
			if (administradorEJB.registroEmpleado(cedula, apellido, contrasena, correo, estado, nombre, usuario)) {
				Util.mostrarMensaje(FacesMessage.SEVERITY_INFO, "registro Exitoso");
			}
		} catch (ElementoRegistradorException e) {
			e.printStackTrace();
		} catch (InformacionRepetidaException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Metodo para recuperar constraseña de una persona
	 * @param cedula
	 */
	public void recuperar(String cedula) {
		Persona persona = administradorEJB.buscarPersona(cedula);

		if (persona != null) {
			String de = "admonmetflix1@gmail.com";
			String clave = "administrador1";
			String para = persona.getCorreo();
			String mensaje = "Saludos\nSegun solicitud realizada, "
					+ "te recordamos tu clave de acceso a la plataforma METFLIX.\n\nClave:"
					+ administradorEJB.recuperarContrasenia(cedula);
			String asunto = "Contraseña Plataforma METFLIX";
			EmailSenderService.getInstancia().enviarcorreo(de, clave, para, mensaje, asunto);
			
		} else {
		
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
