package co.edu.uniquindio.com;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import static javax.persistence.InheritanceType.JOINED;

/**
 * Esta entidad representa a la clase (Entidad) Persona.
 *
 */
@Entity
@Inheritance(strategy = JOINED)
public class Persona implements Serializable {

	@Id
	@Column(name = "cedula", length = 10) // identificacion de tipo cadena con maximo 10 caracteres
	private String cedula;
	@Column(name = "nombre", length = 30) // nombre de tipo cadena con maximo 30 caracteres
	private String nombre;
	@Column(name = "apellido", length = 30) // apellido de tipo cadena con maximo 30 caracteres
	private String apellido;
	@Column(name = "usuario", length = 15) // usuario para login de tipo string
	private String usuario;
	@Column(name = "contrasena", length = 8) // contrasena para login de tipo string
	private String contrasena;
	@Column(name = "correo", length = 40) // correo electronico de tipo string
	private String correo;
	@Column(name = "estado") // estado de la persona en el sistema de tipo int
	private int estado;
	@ElementCollection
	private List<String> telefono; // telefono(s) de la persona de tipo lista
	private static final long serialVersionUID = 1L; // campo generado por la implementacion de serializable (usado para
														// la des-serializacion)

	/*
	 * Metodo constructor de la clase(Entidad) Persona
	 */
	protected Persona() {

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
		result = prime * result + ((cedula == null) ? 0 : cedula.hashCode());
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
		Persona other = (Persona) obj;
		if (cedula == null) {
			if (other.cedula != null)
				return false;
		} else if (!cedula.equals(other.cedula))
			return false;
		return true;
	}

	/*
	 * Metodo get del atributo cedula, devuelve un string
	 */
	public String getCedula() {
		return cedula;
	}

	/*
	 * Metodo set del atributo cedula
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
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
	 * Metodo get del atributo apellido, devuelve un String
	 */
	public String getApellido() {
		return apellido;
	}

	/*
	 * Metodo set del atributo apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/*
	 * Metodo get del atributo usuario, devuelve un String
	 */
	public String getUsuario() {
		return usuario;
	}

	/*
	 * Metodo set del atributo usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/*
	 * Metodo get del atributo contrasena, devuelve un String
	 */
	public String getContrasena() {
		return contrasena;
	}

	/*
	 * Metodo set del atributo constrasena
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	/*
	 * Metodo get del atributo correo, devuelve un String
	 */
	public String getCorreo() {
		return correo;
	}

	/*
	 * Metodo set del atributo correo
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
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
