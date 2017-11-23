package bean;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import co.edu.uniquindio.com.Empleado;
import ejb.AdministradorEJB;


/**
 * Permite registrar una consulta tecnica
 * @author carlos alberto
 * @version 1.0
 */

@ManagedBean
public class ConsultaTecnicaBean {
	private List<Empleado> empleados;
	private Empleado empleado;
	
	@EJB
	private AdministradorEJB administradorEJB;
	
	public ConsultaTecnicaBean() {
		
	}
	
	
	/**
	 * Permite inicializar los elementos basicos para una lista
	 */
	@PostConstruct
	private void inicializar() {
		empleados = administradorEJB.generarListaEmpleados();
		empleado = empleados.size() > 0 ? empleados.get(0): null;
	}

	/**
	 * permite registrar una consulta tecnica
	 * @return registra una consulta tecnica
	 */
	public String registro() {
		
		System.out.println(String.format("El empleado seleccionado es: %s", empleado));
		
		return "pages/cliente/infoConsultaTecnica";
	}
	
	public List<Empleado> getEmpleados() {
		return empleados;
	}


	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}


	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	

}
