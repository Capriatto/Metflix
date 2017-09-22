package co.edu.uniquindio.com;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Esta entidad representa a la clase (Entidad) Pelicula.
 * 
 * @author Juan Sebastian Ocampo Ospina
 * @author German Felipe Valencia Hurtado
 * @author Carlos Alberto Lopez Mazo
 */
@Entity
@NamedQueries({ @NamedQuery(name = Pelicula.GET_ALL, query = "SELECT pelicula FROM Pelicula pelicula") })
public class Pelicula implements Serializable {

	@Id
	@Column(name = "id") // identificador de Pelicula de tipo integer
	private int id_pelicula;
	@Column(name = "nombre", length = 30) // nombre de la pelicula de tipo String
	private String nombre;
	@Column(name = "descripcion") // descripcion de la pelicula de tipo String
	private String descripcion;
	@Column(name = "anio_lanzamiento")
	@Temporal(TemporalType.DATE) // anio lanzamiento de la pelicula de tipo Date
	private Date anio_lanzamiento;
	@Column(name = "precio") // precio de la pelicula de tipo double
	private double precio;
	@Column(name = "estado") // estado de la pelicula de tipo boolean
	private int estado;
	@ElementCollection
	private List<String> idioma; // idioma(s) de la pelicula de tipo lista
	@ElementCollection
	private List<String> categoria; // categoria(s) de la pelicula de tipo lista
	private static final long serialVersionUID = 1L;
	
	public static final String GET_ALL = "pelicula_GetAll"; //named query


	/*
	 * Metodo constructor de la clase(Entidad) Pelicula
	 */
	public Pelicula() {
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
		result = prime * result + id_pelicula;
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
		Pelicula other = (Pelicula) obj;
		if (id_pelicula != other.id_pelicula)
			return false;
		return true;
	}

	/*
	 * Metodo get del atributo id, devuelve un entero
	 */
	public int getId() {
		return id_pelicula;
	}

	/*
	 * Metodo set del atributo id
	 */
	public void setId(int id_pelicula) {
		this.id_pelicula = id_pelicula;
	}

	/*
	 * Metodo get del atributo nombre, devuelve un String
	 */
	public String getNombre() {
		return nombre;
	}

	/*
	 * Metodo set del atributo nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/*
	 * Metodo get del atributo descripcion, devuelve un String
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/*
	 * Metodo set del atributo descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/*
	 * Metodo get del atributo anio_lanzamiento, devuelve un Date
	 */
	public Date getAnio_lanzamiento() {
		return anio_lanzamiento;
	}

	/*
	 * Metodo set del atributo anio_lanzamiento
	 */
	public void setAnio_lanzamiento(Date anio_lanzamiento) {
		this.anio_lanzamiento = anio_lanzamiento;
	}

	/*
	 * Metodo get del atributo precio, devuelve un double
	 */
	public double getPrecio() {
		return precio;
	}

	/*
	 * Metodo set del atributo precio
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/*
	 * Metodo get del atributo idioma, devuelve una lista
	 */
	public List<String> getIdioma() {
		return idioma;
	}

	/*
	 * Metodo set del atributo idioma
	 */
	public void setIdioma(List<String> idioma) {
		this.idioma = idioma;
	}

	/*
	 * Metodo get del atributo categoria, devuelve una lista
	 */
	public List<String> getCategoria() {
		return categoria;
	}

	/*
	 * Metodo set del atributo categoria
	 */
	public void setCategoria(List<String> categoria) {
		this.categoria = categoria;
	}

	/*
	 * Metodo get del atributo estado, devuelve un entero
	 */
	public int getEstado() {
		return estado;
	}

	/*
	 * Metodo set del atributo estado
	 */
	public void setEstado(int estado) {
		this.estado = estado;
	}

}
