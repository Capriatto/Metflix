/**
 * 
 */
package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

/**
 * @author carlos alberto
 *
 */
@ManagedBean
public class MenuBean {

	@ManagedProperty("#{sesionBean.nombreUsuario")
	private String nombreUsuario;
	@ManagedProperty("#{sesionBean.clave}")
	private String clave;
	
	public MenuBean() {

		
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
	
	
}
