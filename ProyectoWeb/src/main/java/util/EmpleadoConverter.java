package util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import co.edu.uniquindio.com.Empleado;
import ejb.AdministradorEJB;
import ejb.AdministradorEJBRemote;
import excepciones.ElementoRegistradorException;
import excepciones.InformacionRepetidaException;

@FacesConverter("empleadoConverter")
public class EmpleadoConverter implements Converter{

	private AdministradorEJBRemote administradorEJB;
	
	public EmpleadoConverter() {
		try {
			administradorEJB = (AdministradorEJBRemote) InitialContext.doLookup(AdministradorEJBRemote.JNDI);
		} catch (NamingException e) {
			// TODO: handle exception
		}
	}
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent componente, String id) {

		if (id != null && !id.equals("")) {
			try {
				return (Empleado) administradorEJB.buscarEmpleadoPorNombreUsuario(id);
			} catch (ElementoRegistradorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InformacionRepetidaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent componente, Object value) {
		if (value != null) {
			return ((Empleado)value).getCedula();
		}
		return null;
	}

	
	
}
