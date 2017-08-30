package co.edu.analisis;

import java.io.Serializable;
import java.lang.String;
import java.sql.Date;

import javax.persistence.*;

/**
 * Esta entidad representa a la clase (Entidad) Pelicula.
 *
 */
@Entity
public class Pelicula implements Serializable {
	   
	@Id
	@Column(name="id_pelicula") 
	private int id_pelicula;
	@Column(name="nombre", length=30) 
	private String nombre;
	@Column(name="descripcion") 
	private String descripcion;
	@Column(name="anio_lanzamiento")
	private Date anio_lanzamiento;
	@Column(name="precio")
	private double precio;
	@Column(name="estado")
	private boolean estado;
	
	private static final long serialVersionUID = 1L; 

	
	/*
	 * Metodo constructor de la clase(Entidad) Persona
	 * */
	public Pelicula() {
		super();
	}  
	
	
	public int getId_pelicula() {
		return id_pelicula;
	}
	

	public void setId_pelicula(int id_pelicula) {
		this.id_pelicula = id_pelicula;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Date getAnio_lanzamiento() {
		return anio_lanzamiento;
	}


	public void setAnio_lanzamiento(Date anio_lanzamiento) {
		this.anio_lanzamiento = anio_lanzamiento;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
   
}
