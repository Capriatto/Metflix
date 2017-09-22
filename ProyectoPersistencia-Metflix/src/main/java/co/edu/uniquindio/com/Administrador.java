package co.edu.uniquindio.com;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Esta entidad representa el usuario administrador de Metflix
 * 
 * @author Juan Sebastian Ocampo Ospina
 * @author German Felipe Valencia Hurtado
 * @author Carlos Alberto Lopez Mazo
 */
@Entity
@NamedQueries({ @NamedQuery(name = Administrador.GET_ALL, query = "SELECT administrador FROM Administrador administrador") })
public class Administrador extends Persona implements Serializable {
	@Column(name = "sueldo") // sueldo del administrador de tipo double
	private double sueldo;

	private static final long serialVersionUID = 1L; // campo generado por la implementacion de serializable (usado para
														// la des-serializacion)

	public static final String GET_ALL = "persona_GetAll"; //named query

	/*
	 * Metodo constructor de la clase(Entidad) Administrador
	 */
	public Administrador() {
		super();
	}

	/*
	 * Metodo get del atributo sueldo, devuelve un double
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

}
