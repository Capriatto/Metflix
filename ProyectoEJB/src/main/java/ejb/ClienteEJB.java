package ejb;


import java.sql.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.uniquindio.com.Cliente;
import co.edu.uniquindio.com.Consulta_tecnica;
import co.edu.uniquindio.com.Empleado;

/**
 * Session Bean implementation class administradorEJB
 */
@Stateless
@LocalBean
public class ClienteEJB {

	/**
	 * Default constructor.
	 */
	public ClienteEJB() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Metodo que permite registrar una consulta técnica en la base de datos
	 * @param id
	 * @param consulta
	 * @param estado
	 * @param f_consulta_tecnica
	 * @param cliente
	 * @param empleado
	 * @return
	 */
	public boolean registroConsultaTecnica(String id, String consulta, int estado, Date f_consulta_tecnica, Cliente cliente,
		    Empleado empleado) {
			Consulta_tecnica consulta_tec = new Consulta_tecnica();
			consulta_tec.setId(id);
			consulta_tec.setConsulta(consulta);
			consulta_tec.setEstado(estado);
			consulta_tec.setF_consultatecnica(f_consulta_tecnica);
			consulta_tec.setCliente_id(cliente);
			consulta_tec.setEmpleado_id(empleado);;
			entityManager.persist(consulta_tec);
			return true;
		
	}

}
