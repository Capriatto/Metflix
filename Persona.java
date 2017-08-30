package co.edu.analisis;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Esta entidad representa a la clase (Entidad) Persona.
 *
 */
@Entity
public class Persona implements Serializable {
	/*
	 * atributo Genero de tipo enumerador.  
	 * */
	private enum Genero{
		MASCULINO,
		FEMENINO
	}
	   
	@Id
	@Column(name="cedulaPersona", length=10) // identificacion de tipo cadena con maximo 10 caracteres
	private String cedula;
	@Column(name="nombrePersona", length=30) // nombre de tipo cadena con maximo 30 caracteres
	private String nombre;
	@Column(name="apellidoPersona", length=30) // apellido de tipo cadena con maximo 30 caracteres
	private String apellido;
	private static final long serialVersionUID = 1L; // campo generado por la implementacion de serializable (usado para la des-serializacion)
	@Column(name="generoPersona") // genero de tipo enum.
	private Genero genero;
	@ElementCollection
	private List<String> telefono; // telefonos de la persona, atributo de tipo lista.
	

	
	/*
	 * Metodo constructor de la clase(Entidad) Persona
	 * */
	public Persona() {
		super();
	}  
	/*
	 * Metodo get del campo cedula, retorna un String.
	 * */
	public String getCedula() {
		return this.cedula;
	}
	
	/*
	 * Metodo set del campo cedula.
	 * */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	} 
	/*
	 * Metodo get del campo nombre, retorna un String.
	 * */
	public String getNombre() {
		return this.nombre;
	}
	/*
	 * Metodo set del campo nombre.
	 * */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	} 
	/*
	 * Metodo get del campo apellido, retorna un String.
	 * */
	public String getApellido() {
		return this.apellido;
	}
	/*
	 * Metodo set del campo apellido.
	 * */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	/*
	 * Metodo get del campo genero, retorna un enum.
	 * */
	public Genero getGenero() {
		return genero;
	}
	
	/*
	 * Metodo set del campo genero.
	 * */
	public void setGenero(Genero genero) {
		this.genero = genero;
	}

   
}
