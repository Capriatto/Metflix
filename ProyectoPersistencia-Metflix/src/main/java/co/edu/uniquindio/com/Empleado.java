package co.edu.uniquindio.com;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Esta entidad representa a la clase (Entidad) Empleado.
 * 
 * @author Juan Sebastian Ocampo Ospina
 * @author German Felipe Valencia Hurtado
 * @author Carlos Alberto Lopez Mazo
 */
@Entity
@NamedQueries({ @NamedQuery(name = Empleado.GET_ALL, query = "SELECT empleado FROM Empleado empleado"),
				@NamedQuery(name = Empleado.GET_PUESTOVENTAS, query = "SELECT empleado FROM Empleado empleado where empleado.puesto='ventas'")	
})
public class Empleado extends Persona implements Serializable {

	@Column(name = "sueldo") // sueldo del Empleado de tipo double
	private double sueldo;
	@Column(name = "puesto", length = 30) // puesto del Empleado de tipo String
	private String puesto;

	private static final long serialVersionUID = 1L; // campo generado por la implementacion de serializable (usado para
														// la des-serializacion)

	public static final String GET_ALL = "empleado_GetAll"; //named query
	
	public static final String GET_PUESTOVENTAS = "empleado_GetEmpleadosVentas"; //named query


	/*
	 * Metodo constructor de la clase(Entidad) Empleado
	 */
	public Empleado() {
		super();
	}

	/*
	 * Metodo get del atributo sueldo, devuelve double
	 */
	public double getSueldo() {
		return sueldo;
	}

	/*
	 * Metodo set del atributo sueldo
	 */
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	/*
	 * Metodo get del atributo puesto, devuelve un String
	 */
	public String getPuesto() {
		return puesto;
	}

	/*
	 * Metodo set del atributo puesto
	 */
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

}
