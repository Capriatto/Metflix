package co.edu.uniquindio.com;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
/**
 * Esta entidad representa a la clase (Entidad) Empleado.
 *
 */
@Entity
public class Empleado extends Persona  implements Serializable  {
	
	
	@Column(name = "sueldo") // sueldo del Empleado de tipo double 
	private double sueldo;
	@Column(name = "puesto", length=30) // puesto del Empleado de tipo String
	private String puesto;
	@OneToOne


	private static final long serialVersionUID = 1L; // campo generado por la implementacion de serializable (usado para la des-serializacion)
	
	
	/*
	 * Metodo constructor de la clase(Entidad) Empleado
	 * */
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
