package co.edu.uniquindio.com;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/*
Esta entidad representa a la clase (Entidad) Cliente. 
*/
@Entity
public class Cliente extends Persona implements Serializable{
	
	@Temporal(TemporalType.TIMESTAMP)// fecha de registro del ciente de tipo date
	private Date f_registro;
	@Temporal(TemporalType.DATE)// fecha de nacimiento del cliente de tipo date
	private Date f_nacimiento;
	@ElementCollection
	private List<String> telefono; // telefono(s) del cliente de tipo string
	


	private static final long serialVersionUID = 1L; // campo generado por la implementacion de serializable (usado para la des-serializacion)
	
	
	/*
	 * Metodo constructor de la clase(Entidad) Cliente
	 * */
	public Cliente() {
		super();
	}
	
	/*
	 * Metodo get del atributo f_registro, devuelve un timestamp
	 */
	public Date getF_registro() {
		return f_registro;
	}

	/*
	 * Metodo set del atributo f_registro
	 */
	public void setF_registro(Date f_registro) {
		this.f_registro = f_registro;
	}

	/*
	 * Metodo get del atributo f_nacimiento, devuelve un Date
	 */
	public Date getF_nacimiento() {
		return f_nacimiento;
	}

	/*
	 * Metodo set del atributo f_nacimiento
	 */
	public void setF_nacimiento(Date f_nacimiento) {
		this.f_nacimiento = f_nacimiento;
	}

	/*
	 * Metodo get del atributo telefono, devuelve una lista
	 */
	public List<String> getTelefono() {
		return telefono;
	}

	/*
	 * Metodo set del atributo telefono
	 */
	public void setTelefono(List<String> telefono) {
		this.telefono = telefono;
	}


	
}
