package co.edu.uniquindio.com.pruebas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.uniquindio.com.Administrador;
import co.edu.uniquindio.com.Compra_pelicula;
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
public class ModeloPrueba2 {
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
	 * Metodo que permite consultar las {@link Pelicula} compradas en el año 2017.
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "Pelicula.json","Compra_pelicula.json", "compra_pelicula_pelicula_ids.json"})
	public void getPeliculasCompradas() {
		System.out.println("----- Obtener películas compradas en el año 2017 ----");
		Query query = entityManager.createNamedQuery(Compra_pelicula.COMPRADAS_PRIMERTRIMESTRE);
		List lista = query.getResultList();
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(i+")."+lista.get(i));
		}
	}
	
	
	

}
