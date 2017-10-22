package ejb;


import java.sql.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.edu.uniquindio.com.Cliente;
import co.edu.uniquindio.com.Compra_pelicula;
import co.edu.uniquindio.com.Consulta_tecnica;
import co.edu.uniquindio.com.Empleado;
import excepciones.InformacionRepetidaException;

/**
 * Session Bean implementation class administradorEJB
 */
@Stateless
@LocalBean
public class ClienteEJB implements ClienteEJBRemote{

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
		
	 /** Metodo que permite registrar una consulta técnica en la base de datos
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
	
	/**
	 * Permite hacer el cambio de contraseña a los clientes
	 * @param usuario
	 * @param contraseñaNueva
	 * @throws InformacionRepetidaException
	 */

	public boolean cambioContrasena(String usuario, String contrasenaNueva)throws InformacionRepetidaException{
		
		Cliente cliente = buscarEmpleadoPorNombreUsuario(usuario);
		
		if (cliente.getContrasena().equals(contrasenaNueva)) {
			throw new InformacionRepetidaException("Ah colocado la contraseña actual");
		}else {
		cliente.setContrasena(contrasenaNueva);
		entityManager.persist(cliente);
		return true;
		}
	}
	
	/**
	 * Metodo que permite registrar una compra de una pelicula
	 * 
	 * @param id
	 * @param F_COMPRA
	 * @param CLIENTE_ID_cedula
	 * @return devuelve true si la compra fue registrada con exito
	 * @throws InformacionRepetidaException
	 */
	public boolean registroCompraPelicula(int id, Date F_COMPRA, Cliente CLIENTE_ID_cedula)
			throws InformacionRepetidaException {
		if (buscarCompra(id) != null) {
			throw new InformacionRepetidaException("Id compra ya fue asignada previamente");
		} else {
			Compra_pelicula compra = new Compra_pelicula();
			compra.setId(id);
			compra.setF_compra(F_COMPRA);
			compra.setCliente_id(CLIENTE_ID_cedula);
			entityManager.persist(compra);
			return true;
		}
	}

	/**
	 * Permite buscar un empleado por su nombre de usuario
	 * 
	 * @param usuario
	 *            Nombre del usuario
	 * @return el usuario encontrado
	 */
	private Compra_pelicula buscarCompra(int id) {
		try {
			TypedQuery<Compra_pelicula> query = entityManager.createNamedQuery(Compra_pelicula.GET_VENTA,
					Compra_pelicula.class);
			query.setParameter("idCompra", id);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
