package co.edu.uniquindio.com.pruebas;

import java.util.ArrayList;

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

import co.edu.uniquindio.com.Administrador;
import co.edu.uniquindio.com.Consulta_tecnica;
import co.edu.uniquindio.com.Empleado;
import co.edu.uniquindio.com.Persona;

@RunWith(Arquillian.class)
/**
 * Clase que permite la creacion de pruebas unitarias por medio de junit
 * 
 * @author Juan Sebastian Ocampo Ospina
 * @author German Felipe Valencia Hurtado
 * @author Carlos Alberto Lopez Mazo
 *
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

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "persona.json", "empleado.json", "cliente.json" })
	public void mergeTest() {
		Empleado miEmpleado = entityManager.find(Empleado.class, "2");
		miEmpleado.setPuesto("soporte");
		entityManager.merge(miEmpleado);
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "persona.json", "administrador.json" })
	public void removeTest() {

		Administrador persona = entityManager.find(Administrador.class, "1");
		entityManager.remove(persona);
		
		Administrador persona1 = entityManager.find(Administrador.class, "1");				
		Assert.assertNull(persona1);
		
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "persona.json" })
	public void QueryTest() {
		String usuario = null;
		String contrasena = null;
		Persona persona = entityManager.find(Persona.class, "3");
		usuario = persona.getUsuario();
		Assert.assertNotNull(usuario);
		contrasena = persona.getContrasena();
		Assert.assertNotNull(contrasena);
	}

}
