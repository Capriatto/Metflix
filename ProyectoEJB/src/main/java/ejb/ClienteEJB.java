package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.edu.uniquindio.com.Cliente;
import excepciones.InformacionRepetidaException;

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
