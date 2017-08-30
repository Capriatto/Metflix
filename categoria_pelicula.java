package co.edu.analisis;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Esta entidad representa a la clase (Entidad) Pelicula.
 *
 */
@Entity
public class categoria_pelicula implements Serializable {
	   
	@Id
	@Column(name="id_categoria_pelicula") 
	private int id_categoria_pelicula;
	@Column(name="nombre", length=30) 
	private String nombre;
	@ManyToOne
	private Pelicula pelicula_id;
	private static final long serialVersionUID = 1L; 
	
	/*
	 * Metodo constructor de la clase(Entidad) Persona
	 * */
	public categoria_pelicula() {
		super();
	}

	public int getId_categoria_pelicula() {
		return id_categoria_pelicula;
	}

	public void setId_categoria_pelicula(int id_categoria_pelicula) {
		this.id_categoria_pelicula = id_categoria_pelicula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Pelicula getPelicula_id() {
		return pelicula_id;
	}

	public void setPelicula_id(Pelicula pelicula_id) {
		this.pelicula_id = pelicula_id;
	} 
	
	
	
}
