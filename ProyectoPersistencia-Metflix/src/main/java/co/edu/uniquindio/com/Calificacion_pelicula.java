package co.edu.uniquindio.com;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Esta entidad representa a la clase (Entidad) Calificacion_pelicula.
 * 
 * @author Juan Sebastian Ocampo Ospina
 * @author German Felipe Valencia Hurtado
 * @author Carlos Alberto Lopez Mazo
 *
 */
@Entity
public class Calificacion_pelicula implements Serializable {

	@Id
	@Column(name = "id") // identificador del administrador de tipo integer
	private int id;
	@Column(name = "calificacion") // calificacion de la pelicula de tipo integer
	private int calificacion;
	@Column(name = "resena") // reseña de la pelicula de tipo String
	private String resena;
	@ManyToOne
	private Pelicula pelicula_id;// relacion con entidad Pelicula
	@ManyToOne
	private Cliente cliente_id; // relacion con entidad Cliente
	private static final long serialVersionUID = 1L;

	/*
	 * Metodo constructor de la clase(Entidad) calificacion_pelicula
	 */
	public Calificacion_pelicula() {
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
		result = prime * result + id;
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
		Calificacion_pelicula other = (Calificacion_pelicula) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/*
	 * Metodo get del atributo id, devuelve un entero
	 */
	public int getId() {
		return id;
	}

	/*
	 * Metodo set del atributo id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/*
	 * Metodo get del atributo calificacion, devuelve un entero
	 */
	public int getCalificacion() {
		return calificacion;
	}

	/*
	 * Metodo set del atributo calificacion
	 */
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	/*
	 * Metodo get del atributo resena, devuelve un String
	 */
	public String getResena() {
		return resena;
	}

	/*
	 * Metodo set del atributo resena
	 */
	public void setResena(String resena) {
		this.resena = resena;
	}

	/*
	 * Metodo get del atributo pelicula_id, devuelve un objeto de tipo Pelicula
	 */
	public Pelicula getPelicula_id() {
		return pelicula_id;
	}

	/*
	 * Metodo set del atributo Pelicula
	 */
	public void setPelicula_id(Pelicula pelicula_id) {
		this.pelicula_id = pelicula_id;
	}

	/*
	 * Metodo get del atributo cliente_id, devuelve un objeto de tipo Cliente
	 */
	public Cliente getCliente_id() {
		return cliente_id;
	}

	/*
	 * Metodo set del atributo Cliente
	 */
	public void setCliente_id(Cliente cliente_id) {
		this.cliente_id = cliente_id;
	}

}
