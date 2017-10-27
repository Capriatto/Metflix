package co.edu.uniquindio.com;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Esta entidad representa a la clase (Entidad) Cliente.
 * 
 * @author Juan Sebastian Ocampo Ospina
 * @author German Felipe Valencia Hurtado
 * @author Carlos Alberto Lopez Mazo
 */ 
@Entity
@NamedQueries({ @NamedQuery(name = Cliente.GET_ALL, query = "SELECT cliente FROM Cliente cliente where cliente.cedula=:cedula and cliente.estado=1"),
	@NamedQuery(name = Cliente.CREDENCIALES, query = "SELECT cliente FROM Cliente cliente,Persona persona where persona.usuario=:usuario"),
	

@NamedQuery(name = Cliente.GET_CREDENTIALS, query = "SELECT c FROM Cliente c, Persona p WHERE c.usuario=:usuario AND c.contrasena=:contrasena AND c.cedula=p.cedula")
		 })
public class Cliente extends Persona implements Serializable {

	@Temporal(TemporalType.TIMESTAMP) // fecha de registro del ciente de tipo date
	private Date f_registro;
	@Temporal(TemporalType.DATE) // fecha de nacimiento del cliente de tipo date
	private Date f_nacimiento;
	@ElementCollection
	private List<String> telefono; // telefono(s) del cliente de tipo string

	private static final long serialVersionUID = 1L; // campo generado por la implementacion de serializable (usado para
														// la des-serializacion)

	public static final String GET_ALL = "cliente_GetAll"; // named query
	public static final String CREDENCIALES = "cliente_GetCredenciales"; // named query
	public static final String GET_CREDENTIALS = "persona_GetCredenciales"; //named query


	/*
	 * Metodo constructor de la clase(Entidad) Cliente
	 */
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
