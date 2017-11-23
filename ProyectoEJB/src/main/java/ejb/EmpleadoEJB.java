package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.edu.uniquindio.com.Empleado;

@Stateless
@LocalBean
public class EmpleadoEJB {

	public EmpleadoEJB() {

	}

	@PersistenceContext
	private EntityManager entityManager;
	

	
}
