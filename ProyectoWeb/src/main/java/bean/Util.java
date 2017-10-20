package bean;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public final class Util {
	public static void mostrarMensaje(Severity tipo, String mensaje) {
		FacesMessage facesmsg=new FacesMessage(tipo, mensaje, mensaje);
		FacesContext.getCurrentInstance().addMessage(null,facesmsg);
	}
}
