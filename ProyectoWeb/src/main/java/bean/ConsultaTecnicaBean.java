package bean;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import co.edu.uniquindio.com.Cliente;
import co.edu.uniquindio.com.Empleado;
import ejb.AdministradorEJB;
import ejb.ClienteEJB;

@ManagedBean
@SessionScoped
public class ConsultaTecnicaBean {
	private String consulta;
	private int estado;
	private Date f_consultatecnica;
	Cliente cliente;
	Empleado empleado;
	
	
	@EJB
	private ClienteEJB clienteEJB;
	
	public String registrarConsultaTecnica() {
		if(clienteEJB.registroConsultaTecnica(consulta, estado, new Date(), cliente, empleado)) {
			
		}
		return null;
	}
	
	

}
