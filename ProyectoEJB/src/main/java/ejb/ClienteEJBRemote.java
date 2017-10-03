package ejb;

import java.sql.Date;

import javax.ejb.Remote;

import co.edu.uniquindio.com.Cliente;
import co.edu.uniquindio.com.Empleado;

/**
 * Interfaz que determina los metodos de acceso del EJB de Cliente.
 * 
 * @author German
 *
 */
@Remote
public interface ClienteEJBRemote {
	
	/**
	 * Permite registrar un cliente en la base de datos
	 * @param id
	 * @param consulta
	 * @param estado
	 * @param f_consulta_tecnica
	 * @param cliente
	 * @param empleado
	 * @return
	 */
	public boolean registroConsultaTecnica(String id, String consulta, int estado, Date f_consulta_tecnica, Cliente cliente,
		    Empleado empleado);
	
	
}


