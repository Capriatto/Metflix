package bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ejb.AdministradorEJB;

@ManagedBean
@SessionScoped
public class ConsultaTecnicaBean {
	@EJB
	private AdministradorEJB administradorEJB;
	
	public ConsultaTecnicaBean() {
	}
	
	

}
