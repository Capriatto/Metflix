package bean;

import javax.annotation.ManagedBean;

@ManagedBean
public class HolaMundoBean {
	String mensaje = "Hola Mundo";

	public String getMensaje() {
		return mensaje;
	}
}
