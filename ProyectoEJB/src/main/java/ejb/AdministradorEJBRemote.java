package ejb;

import excepciones.ElementoRegistradorException;
import excepciones.InformacionRepetidaException;

public interface AdministradorEJBRemote {
	public boolean registroEmpleado(String cedula,String nombre,String email,String clave,int edad,
    		String nombreUsuario)throws ElementoRegistradorException,InformacionRepetidaException;
	
}
