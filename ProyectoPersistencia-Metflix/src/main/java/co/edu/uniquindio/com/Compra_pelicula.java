package co.edu.uniquindio.com;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Esta entidad representa a la clase (Entidad) Compra_pelicula.
 *
 */
@Entity
public class Compra_pelicula implements Serializable {
	   
	@Id
	@Column(name="id") // identificador de la clase compra_pelicula de tipo integer
	private int id;
	@Temporal(TemporalType.TIMESTAMP)  // fecha_compra de la pelicula de tipo Timestamp
	private Date f_compra;
	@ManyToOne
	private Pelicula pelicula_id; // relacion muchos a uno con la clase(Entidad) Pelicula
	@ManyToOne
	private Cliente cliente_id; // relación muchos a uno con la clase(Entidad) Cliente
	private static final long serialVersionUID = 1L; 
	
	/*
	 * Metodo constructor de la clase(Entidad) compra_pelicula
	 * */
	public Compra_pelicula() {
		super();
	}
	
	/*
	 * Este metodo permite la comparacion de entidades por medio de su token hash
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
		Compra_pelicula other = (Compra_pelicula) obj;
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
	 * Metodo get del atributo f_compra, devuelve un Timestamp
	 */
	public Date getF_compra() {
		return f_compra;
	}
	/*
	 * Metodo set del atributo f_compra
	 */
	public void setF_compra(Date f_compra) {
		this.f_compra = f_compra;
	}
	/*
	 * Metodo get del atributo Pelicula, devuelve un objeto de tipo Pelicula
	 */
	public Pelicula getPelicula_id() {
		return pelicula_id;
	}
	/*
	 * Metodo set del atributo pelicula_id
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
	 * Metodo set del atributo cliente_id
	 */
	public void setCliente_id(Cliente cliente_id) {
		this.cliente_id = cliente_id;
	}
	

	
	
}
