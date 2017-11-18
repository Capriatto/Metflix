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
	private String nombreUsuario, clave;
	private boolean autenticado;
	
	/**
	 * permite inicializar el estado de la sesion
	 */
	public SesionBean() {
		autenticado=false;
		autenticar();
	}
	
	
	public String autenticar() {
		// TODO: hacer peticion al EJB
		return "/pages/Menu";
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
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
