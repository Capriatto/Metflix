package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import excepciones.ElementoRegistradorException;

/**
 * Session Bean implementation class administradorEJB
 */
@Stateless
@LocalBean
public class administradorEJB {

    /**
     * Default constructor. 
     */
    public administradorEJB() {
        // TODO Auto-generated constructor stub
    }
    
    public boolean registroEmpleado(String cedula,String nombre,String email,String clave,int edad,
    		String nombreUsuario)throws ElementoRegistradorException{
    	return true;
    }

}
