package co.edu.uniquindio.com.pruebas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.glassfish.admin.rest.results.GetResultList;
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
import co.edu.uniquindio.com.Compra_pelicula;
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

	/**
	 * Metodo que permite generar las tablas en la base de datos.
	 */
	@Test
	public void generacionTest() {
	}

	/**
	 * Metodo que permite realizar prueba de busqueda de un registro
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "persona.json", "administrador.json" })
	public void findTest() {
		Administrador persona = entityManager.find(Administrador.class, "1");
		Assert.assertEquals("valencia@gmail.com", persona.getCorreo());
	}

	/**
	 * Metodo que permite realizar prueba de persistencia de un registro
	 */
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

	/**
	 * Metodo que permite realizar prueba de actualizacion de un registro
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "persona.json", "empleado.json", "cliente.json" })
	public void mergeTest() {
		Empleado miEmpleado = entityManager.find(Empleado.class, "2");
		miEmpleado.setPuesto("soporte");
		entityManager.merge(miEmpleado);
	}

	/**
	 * Metodo que permite realizar prueba de eliminacion de un registro
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "persona.json", "administrador.json" })
	public void removeTest() {

		Administrador persona = entityManager.find(Administrador.class, "1");
		entityManager.remove(persona);

		Administrador persona1 = entityManager.find(Administrador.class, "1");
		Assert.assertNull(persona1);

	}

	/**
	 * Metodo que permite realizar prueba de consulta de un registro
	 */
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

	/**
	 * Metodo que permite consultar todos los {@link Administrador} registrados.
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "Administrador.json","Persona.json"})
	public void getAdministrador() {
		Query query = entityManager.createNamedQuery(Administrador.GET_ALL);
		query = query.setMaxResults(2);
		List<Administrador> lista = query.getResultList();
		System.out.println("----- Probando Set Max Results (2) ----");
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getNombre()+" "+lista.get(i).getApellido()+" "+lista.get(i).getSueldo());
		}
	}
	
	/**
	 * Metodo que permite consultar todos los {@link Empleado} registrados.
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "Empleado.json","Persona.json"})
	public void getEmpleado() {
		Query query = entityManager.createNamedQuery(Empleado.GET_ALL);
		query = query.setFirstResult(1);
		List<Empleado> lista = query.getResultList();
		System.out.println("----- Probando Set First Result (1) ----");
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getNombre()+" "+lista.get(i).getApellido()+" "+lista.get(i).getSueldo());
		}
	}
	
	/**
	 * Metodo que permite consultar los clientes que han comprado una pelicula{@link Clientes}.
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "compra_pelicula.json","cliente.json","Persona.json"})
	public void getclinteCompraPelicula() {
		Query query = entityManager.createNamedQuery(Compra_pelicula.CLIENTE_COMPRA);
		query.setParameter("idCompra", 1);
		query = query.setFirstResult(1);		
		List<Compra_pelicula> lista = query.getResultList();
		System.out.println("----- Probando cliente que ha comprado pelicula (1) ----");
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getCliente_id());
		}
	}

}
