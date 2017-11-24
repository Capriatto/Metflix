package bean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.swing.JOptionPane;

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
				return "/pages/empleado/infoEmpleado";
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

	// 3.Recuperar contraseña metodo en adminsitradorbean.
	

	
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
