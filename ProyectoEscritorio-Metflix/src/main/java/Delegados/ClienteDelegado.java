/**
 * 
 */
package Delegados;

import java.sql.Date;

import javax.naming.InitialContext;

import co.edu.uniquindio.com.Cliente;
import co.edu.uniquindio.com.Empleado;
import ejb.ClienteEJBRemote;
import excepciones.ElementoRegistradorException;
import excepciones.InformacionRepetidaException;

/**
 * @author Juan Sebastian Ocampo Ospina
 * @author German Felipe Valencia Hurtado
 * @author Carlos Alberto Lopez Mazo
 */
public class ClienteDelegado implements ClienteEJBRemote {
	private ClienteEJBRemote clienteEJB;
	private static final ClienteDelegado instancia = new ClienteDelegado();

	/**
	 * Constructor de clase
	 */
	public ClienteDelegado() {
		try {
			clienteEJB = (ClienteEJBRemote) new InitialContext().lookup(ClienteEJBRemote.JNDI);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que permite generar solo una instacia del delegado
	 * 
	 * @return
	 */
	public static ClienteDelegado getInstancia() {
		return instancia;
	}

	@Override
	public boolean cambioContrasena(String usuario, String contraseñaNueva) throws InformacionRepetidaException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registroConsultaTecnica(String id, String consulta, int estado, Date f_consulta_tecnica,
			Cliente cliente, Empleado empleado) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registroCompraPelicula(int id, Date F_COMPRA, Cliente CLIENTE_ID_cedula)
			throws InformacionRepetidaException {
		// TODO Auto-generated method stub
		return false;
	}

	
	public Cliente buscarCliente(String usuario) {
		// TODO Auto-generated method stub
		return clienteEJB.buscarCliente(usuario);
	}

	
	public boolean registroCliente(String cedula, String apellido, String contrasena, String correo, int estado,
			String nombre, String usuario) throws ElementoRegistradorException, InformacionRepetidaException {
		// TODO Auto-generated method stub
		return clienteEJB.registroCliente(cedula, apellido, contrasena, correo, estado, nombre, usuario);
	}

	
	public Cliente buscarClienteId(String id) {
		// TODO Auto-generated method stub
		return clienteEJB.buscarClienteId(id);
	}

}
