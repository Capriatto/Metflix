package ejb;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.uniquindio.com.Administrador;

/**
 * Session Bean implementation class SetupEJB
 */
@Singleton
@LocalBean
@Startup
public class SetupEJB {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public SetupEJB() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void realizarConfiguracion() {
		long contarAdmin = entityManager.createNamedQuery(Administrador.GET_CONTAR_ADMINISTRADORES, Long.class)
				.getSingleResult();
		System.out.println(String.format("El numero admin es: %s", contarAdmin));
		if (contarAdmin == 0) {
			Administrador admin = new Administrador();
			admin.setCedula("122");
			admin.setNombre("Juan");
			admin.setApellido("Ocampo");
			admin.setUsuario("jsocampo");
			admin.setCorreo("Correo@.com");
			admin.setEstado(1);
			admin.setContrasena("passs");
			admin.setSueldo(750000);

			entityManager.persist(admin);
		}
	}

}
