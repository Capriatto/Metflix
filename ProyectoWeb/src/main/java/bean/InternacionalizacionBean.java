package bean;

import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 * Permite cambiar el idioma dentro de la aplicacion
 * 
 * @author German
 * @version 1.0
 */
@ManagedBean
public class InternacionalizacionBean {
	/**
	 * Constructor por defecto
	 */

	public InternacionalizacionBean() {

	}
	
	/**
	 * Permite cambiar el idioma de la app
	 */
	public void cambiarIdioma() {
		if(FacesContext.getCurrentInstance().getViewRoot().getLocale().getLanguage().equals("es")) {
			FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("en"));
		}else {
			FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("es"));
		}		
				
	}
}
