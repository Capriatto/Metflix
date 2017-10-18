package bean;

import javax.faces.bean.ManagedBean;

/**
 * permite mejorar la informacion del archivo xhtml de saludo
 * 
 * @author German
 * @version 1.0
 *
 */
@ManagedBean
public class HolaMundoBean {
	private static final String mensaje = "Hola Mundo 2";

	public String getMensaje() {
		return mensaje;
	}
}
