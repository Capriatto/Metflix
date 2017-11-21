package bean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.swing.JOptionPane;

import co.edu.uniquindio.com.Empleado;
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
public class EmpleadoBean {

	private String cedula, apellido, contrasena, correo, nombre, usuario;

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
	public String registrarEmpleado() {
		try {
			if (administradorEJB.registroEmpleado(cedula, apellido, contrasena, correo, 1, nombre, usuario)) {
				Util.mostrarMensaje(FacesMessage.SEVERITY_INFO, "registro Exitoso");
				return "/pages/infoEmpleado";
			}
		} catch (ElementoRegistradorException e) {
			e.printStackTrace();
		} catch (InformacionRepetidaException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void limpiarEmpleado() {
		cedula = "";
		apellido = "";
		contrasena = "";
		correo = "";
		nombre = "";
		usuario = "";
	}

	// ----------------------------Proyecto web ultima entrega--------------------//
	// 1.Ver los datos de los clientes
	/**
	 * Metodo que permite buscar un cliente.
	 * 
	 * @param cedula
	 * @return
	 */
	public String consultarCliente(String cedula) {
		if (administradorEJB.buscarCliente(cedula) != null) {
			Util.mostrarMensaje(FacesMessage.SEVERITY_INFO, "Busqueda Exitosa");
			return "/pages/infoCliente";
		}
		return null;
	}

	// 2.Consulta tecnica por parte de los Clientes--------- Ocampo---------
	public void consultaTecnica() {

	}

	// 3.Recuperar contraseña
	public void recuperarConstrasenaEmpleado(String cedula) {
		if (!cedula.equals("")) {
			if (administradorEJB.buscarEmpleadoPorNombreUsuario(cedula) != null) {
				String de = "admonmetflix1@gmail.com";
				String clave = "administrador1";
				String para = administradorEJB.buscarEmpleadoPorNombreUsuario(cedula).getCorreo();
				String mensaje = "Saludos\nSegun solicitud realizada, "
						+ "te recordamos tu clave de acceso a la plataforma METFLIX.\n\nClave:"
						+ administradorEJB.recuperarContrasenia(cedula);
				String asunto = "Contraseña Plataforma METFLIX";
				EmailSenderService.getInstancia().enviarcorreo(de, clave, para, mensaje, asunto);
				JOptionPane.showMessageDialog(null,
						"Un correo electrónico le ha sido enviado con su contraseña.", "Contraseña enviada!",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null,
						"No hemos podido recuperar su contraseña.\nNo se encontró el usuario con cédula: " + cedula,
						"Error!", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"Todos los campos son obligatorios.\nPor favor rellene los campos faltantes para recuperar su contraseña.",
					"Error al recuperar contraseña!", JOptionPane.ERROR_MESSAGE);
		}
	}

	
	//------------------Metodo GET y SET------------------------//
	
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
	
	//----------------------------------------------------------//

}
