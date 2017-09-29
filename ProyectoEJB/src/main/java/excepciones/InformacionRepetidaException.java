package excepciones;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class InformacionRepetidaException
 */
@Stateless
@LocalBean
public class InformacionRepetidaException extends Exception{
		 private static final long serialVersionUID=1;
    /**
     * Default constructor. 
     */
    public InformacionRepetidaException(String mensaje) {
    	super(mensaje);
        // TODO Auto-generated constructor stub
    }

}
