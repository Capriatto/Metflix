package ejb;


import java.sql.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.uniquindio.com.Cliente;
<<<<<<< HEAD
import excepciones.InformacionRepetidaException;
=======
import co.edu.uniquindio.com.Consulta_tecnica;
import co.edu.uniquindio.com.Empleado;
>>>>>>> 129d4c275910c575d6acfaa177b6b2016a87588e

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
<<<<<<< HEAD
	 * Permite buscar un cliente por su nombre de usuario
	 * 
	 * @param usuario
	 *            Nombre del usuario
	 * @return el usuario encontrado
	 */
	private Cliente buscarEmpleadoPorNombreUsuario(String usuario) {
		try {
			TypedQuery<Cliente> query = entityManager.createNamedQuery(Cliente.CREDENCIALES, Cliente.class);
			query.setParameter("usuario", usuario);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
=======
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
		
>>>>>>> 129d4c275910c575d6acfaa177b6b2016a87588e
	}
	
	/**
	 * Permite hacer el cambio de contraseña a los clientes
	 * @param usuario
	 * @param contraseñaNueva
	 * @throws InformacionRepetidaException
	 */

	private boolean cambioContrasena(String usuario, String contrasenaNueva)throws InformacionRepetidaException{
		
		Cliente cliente = buscarEmpleadoPorNombreUsuario(usuario);
		
		if (cliente.getContrasena().equals(contrasenaNueva)) {
			throw new InformacionRepetidaException("Ah colocado la contraseña actual");
		}else {
		cliente.setContrasena(contrasenaNueva);
		entityManager.persist(cliente);
		return true;
		}
	}
}
