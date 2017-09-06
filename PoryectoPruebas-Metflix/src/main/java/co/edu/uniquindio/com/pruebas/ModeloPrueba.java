package co.edu.uniquindio.com.pruebas;

import java.util.ArrayList;
//import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import co.edu.uniquindio.com.*;

@RunWith(Arquillian.class)
/*
 * Clase que nos permitira la creacion de las tablas en la BD. hace uso de la
 * clase arquillian
 */
public class ModeloPrueba {
	/*
	 * Atributo de clase que nos permitira la geston de las entidades.
	 */
	@PersistenceContext
	private EntityManager entityManager;

	/*
	 * Metodo para la crecion del archivo de empaquetado de java.
	 */
	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap.create(WebArchive.class, "test.war").addPackage(Persona.class.getPackage())
				.addAsResource("persistenceForTest.xml", "META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	/*
	 * Metodo que obliga la creacion de las tablas en la BD cuando se ejecuta la
	 * clase.
	 */

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "persona.json", "administrador.json" })
	public void findTest() {
		Administrador persona = entityManager.find(Administrador.class, "1");
		System.out.println(persona);
		Assert.assertEquals("valencia@gmail.com", persona.getCorreo());
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "persona.json", "empleado.json", "consulta_tecnica.json", "cliente.json" })
	public void persistTest() {
		Empleado empleado = new Empleado();
		empleado.setCedula("4");
		empleado.setNombre("Sebas ocampo");
		empleado.setCorreo("ocampo@mail.com");
		empleado.setContrasena("12345");
		Consulta_tecnica consulta = entityManager.find(Consulta_tecnica.class, "1");
		ArrayList<Consulta_tecnica> consultas = new ArrayList<Consulta_tecnica>();
		consultas.add(consulta);
		entityManager.persist(empleado);
	}
}
