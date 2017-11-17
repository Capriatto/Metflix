package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Permite manejar las sesiones 
 * @author Juan
 *
 */

@SessionScoped
@ManagedBean
public class SesionBean {
	private String nombre_usuario, clave;
	private boolean autenticado;
	
	/**
	 * permite inicializar el estado de la sesion
	 */
	public SesionBean() {
		autenticado=false;
	}
	
	
	public String autenticar() {
		// TODO: hacer peticion al EJB
		return "/pages/menu";
	}
	
	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public boolean isAutenticado() {
		return autenticado;
	}

	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}

	


}
