package excepciones;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class ElementoRegistradorException
 */
@Stateless
@LocalBean
public class ElementoRegistradorException extends Exception{
private static final long serialVersionUID=1;
    /**
     * Default constructor. 
     */
    public ElementoRegistradorException() {
        // TODO Auto-generated constructor stub
    }

}
