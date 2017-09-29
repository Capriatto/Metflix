package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.edu.uniquindio.com.Empleado;
import excepciones.ElementoRegistradorException;
import excepciones.InformacionRepetidaException;

/**
 * Session Bean implementation class administradorEJB
 */
@Stateless
@LocalBean
public class AdministradorEJB {

    /**
     * Default constructor. 
     */
    public AdministradorEJB() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext
    private EntityManager entityManager;
    
    public boolean registroEmpleado(String cedula,String nombre,String email,String clave,int edad,
    		String nombreUsuario)throws ElementoRegistradorException,InformacionRepetidaException{
    	if(entityManager.find(Empleado.class,cedula)!=null) {
    		throw new ElementoRegistradorException("Empleado ya fue registrado");
    	}
    	if(buscarEmpleadoPorNombreUsuario(nombreUsuario)!=null) {
    		throw new InformacionRepetidaException("Usuario ya existe");
    	}else
    	{
    	Empleado empleado = new Empleado();
    	//setear
    	
    	entityManager.persist(empleado);
    	return true;
    	}    	
    }

	private Empleado buscarEmpleadoPorNombreUsuario(String nombreUsuario) {
		try {
			TypedQuery<Empleado> query= entityManager.createNamedQuery(Empleado.CREDENCIALES,Empleado.class);
			query.setParameter("nombreUsuario", nombreUsuario);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
