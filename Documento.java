package co.edu.analisis;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
/*
Esta entidad representa el documento de identidad colombiano
*/
@Entity
public class Documento implements Serializable {
	/*
	 *Enumerador que representa el sexo del portador del documento. 
	 */
	public enum Sexo { //atributo genero con opciones masculino y femenino.
		M, F
	}

	@Id
	@Column(name = "Id", length = 15) // identificacion de tipo cadena con maximo 15 caracteres
	private String id;
	@Column(name = "Nombre", length = 50)// nombre de tipo cadena con maximo 50 caracteres
	private String nombre;
	@Column(name = "Apellido", length = 50) // apellido de tipo cadena con maximo 50 caracteres
	private String apellido;
	@Temporal(TemporalType.DATE) //fecha de nacimiento tipo Date 
	private java.util.Date fnacimiento;
	@Temporal(TemporalType.DATE) // fecha expedicion del documento de identidad de tipo Date
	private java.util.Date fexpedicion;
	@Column(name = "Estatura", length = 4) // estatura de tipo flotante con maximo 4 digitos
	private float estatura;
	@Column(name = "RH", length = 2) // tipo de sangre de tipo cadena con maximo 2 caracteres
	private String rh;
	@Column(name = "Sexo", nullable = false) // genero de tipo enum con restriccion no null 
	private Sexo sexo;

	private static final long serialVersionUID = 1L; // campo generado por la implementacion de serializable (usado para la des-serializacion)

	/*Metodo util para la comparacion de entidades, este metodo complementa al equals y retorna un entero*/	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	/*
	 *Metodo que ayuda a comparar si dos objetos(Entidades) son del mismo tipo y si su nombre coincide, retorna un boolean.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Documento other = (Documento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	/*
	 * Metodo constructor de la clase(Entidad) Documento
	 * */
	public Documento() {
		super();
	}
	/*
	 * Metodo get del campo Id, retorna un String.
	 * */
	public String getId() {
		return id;
	}
	
	/*
	 * Metodo set del campo Id.
	 * */
	public void setId(String id) {
		this.id = id;
	}
	
	/*
	 * Metodo get del campo Nombre, retorna un String.
	 * */
	public String getNombre() {
		return nombre;
	}
	
	/*
	 * Metodo set del campo Nombre.
	 * */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/*
	 * Metodo get del campo Apellido, retorna un String.
	 * */
	public String getApellido() {
		return apellido;
	}
	
	/*
	 * Metodo set del campo Apellido.
	 * */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	/*
	 * Metodo get del campo Fnacimiento, retorna un Date.
	 * */
	public java.util.Date getFnacimiento() {
		return fnacimiento;
	}
	
	/*
	 * Metodo set del campo Fnacimiento.
	 * */
	public void setFnacimiento(java.util.Date fnacimiento) {
		this.fnacimiento = fnacimiento;
	}
	
	/*
	 * Metodo get del campo Fexpedicion, retorna un Date.
	 * */
	public java.util.Date getFexpedicion() {
		return fexpedicion;
	}
	
	/*
	 * Metodo set del campo Fexpedicion.
	 * */
	public void setFexpedicion(java.util.Date fexpedicion) {
		this.fexpedicion = fexpedicion;
	}
	
	/*
	 * Metodo get del campo Estatura, retorna un float.
	 * */
	public float getEstatura() {
		return estatura;
	}
	
	/*
	 * Metodo set del campo Estatura.
	 * */
	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}
	
	/*
	 * Metodo get del campo Rh, retorna un String.
	 * */
	public String getRh() {
		return rh;
	}
	
	/*
	 * Metodo set del campo Rh, retorna un String.
	 * */
	public void setRh(String rh) {
		this.rh = rh;
	}
	
	/*
	 * Metodo get del campo Sexo, retorna un enumerador.
	 * */
	public Sexo getSexo() {
		return sexo;
	}
	
	/*
	 * Metodo set del campo Sexo.
	 * */
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

}
