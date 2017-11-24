package bean;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import co.edu.uniquindio.com.Cliente;
import co.edu.uniquindio.com.Empleado;
import ejb.ClienteEJB;

@ManagedBean
@SessionScoped
public class ConsultaTecnicaBean {
	private String consulta;
	private int estado;
	Cliente cliente;
	Empleado empleado;
	
	
	@EJB
	private ClienteEJB clienteEJB;
	
	public String registrarConsultaTecnica() {
		try {
			if(clienteEJB.registroConsultaTecnica(consulta, estado, new Date(), cliente, empleado)) {
				Util.mostrarMensaje(FacesMessage.SEVERITY_INFO, "registro Exitoso");
				return "/pages/ingresar";
			}else {
				System.out.println("No se pudo registrar");
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
