package bean;

import javax.annotation.ManagedBean;
/**
 * permite mejorar la informacion del archivo xhtml de saludo
 * @author German
 * @version 1.0
 *
 */
@ManagedBean
public class HolaMundoBean {
	 private String mensaje = "Hola Mundo 2";

	public String getMensaje() {
		return mensaje;
	}
}
