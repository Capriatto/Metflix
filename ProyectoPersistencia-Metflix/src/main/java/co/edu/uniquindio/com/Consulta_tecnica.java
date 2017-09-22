package co.edu.uniquindio.com;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Esta entidad representa a la clase (Entidad) consulta_tecnica.
 * 
 * @author Juan Sebastian Ocampo Ospina
 * @author German Felipe Valencia Hurtado
 * @author Carlos Alberto Lopez Mazo
 */
@Entity
@NamedQueries({ @NamedQuery(name = Consulta_tecnica.GET_ALL, query = "SELECT consulta_tecnica FROM consulta_tecnica consulta_tecnica") })
public class Consulta_tecnica implements Serializable {

	@Id
	@Column(name = "id") // identificador de la clase consulta_tecnica de tipo integer
	private String id;
	@Temporal(TemporalType.TIMESTAMP) // fecha de la consulta de tipo Timestamp
	private Date f_consultatecnica;
	@Column(name = "consulta") // consulta de tipo String
	private String consulta;
	@Column(name = "estado") // estado de la consulta de tipo int
	private int estado;
	@ManyToOne
	private Empleado empleado_id; // relacion muchos a uno con la clase(Entidad) Empleado
	@ManyToOne
	private Cliente cliente_id; // ralacion muchos a uno con la clase(Entidad) Cliente

	private static final long serialVersionUID = 1L; // campo generado por la implementacion de serializable (usado para
														// la des-serializacion)

	public static final String GET_ALL = "comprapelicula_GetAll"; //named query

	/*
	 * Metodo constructor de la clase(Entidad) consulta_tecnica
	 */
	public Consulta_tecnica() {
		super();
	}

	/*
	 * Este metodo permite la comparacion de entidades por medio de su token hash
	 * 
	 * @see java.lang.Object#hashCode()
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/*
	 * Este metodo permite la comparacion de entidades por su tipo y nombre
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta_tecnica other = (Consulta_tecnica) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/*
	 * Metodo get del atributo id, devuelve un entero
	 */
	public String getId() {
		return id;
	}

	/*
	 * Metodo set del atributo id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/*
	 * Metodo get del atributo f_consultatecnica, devuelve un Timestamp
	 */
	public Date getF_consultatecnica() {
		return f_consultatecnica;
	}

	/*
	 * Metodo set del atributo F_consultatecnica
	 */
	public void setF_consultatecnica(Date f_consultatecnica) {
		this.f_consultatecnica = f_consultatecnica;
	}

	/*
	 * Metodo get del atributo consulta, devuelve un String
	 */
	public String getConsulta() {
		return consulta;
	}

	/*
	 * Metodo set del atributo Consulta
	 */
	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}

	/*
	 * Metodo get del atributo estado, devuelve un entero
	 */
	public int getEstado() {
		return estado;
	}

	/*
	 * Metodo set del atributo Estado
	 */
	public void setEstado(int estado) {
		this.estado = estado;
	}

	/*
	 * Metodo get del atributo empleado_id, devuelve un objeto de tipo Empleado
	 */
	public Empleado getEmpleado_id() {
		return empleado_id;
	}

	/*
	 * Metodo set del atributo Empleado_id
	 */
	public void setEmpleado_id(Empleado empleado_id) {
		this.empleado_id = empleado_id;
	}

	/*
	 * Metodo get del atributo cliente_id, devuelve un objeto de tipo Cliente
	 */
	public Cliente getCliente_id() {
		return cliente_id;
	}

	/*
	 * Metodo set del atributo Cliente_id
	 */
	public void setCliente_id(Cliente cliente_id) {
		this.cliente_id = cliente_id;
	}

}
