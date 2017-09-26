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
import co.edu.uniquindio.com.Calificacion_pelicula;
import co.edu.uniquindio.com.Cliente;
import co.edu.uniquindio.com.Compra_pelicula;
import co.edu.uniquindio.com.Consulta_tecnica;
import co.edu.uniquindio.com.Empleado;
import co.edu.uniquindio.com.Pelicula;
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
	 * Metodo que permite consultar todos las credenciales de una {@link Persona} registrada.
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"cliente.json","Persona.json" })
	public void getUsuario() {
		Query query = entityManager.createNamedQuery(Cliente.GET_CREDENTIALS);
		query.setParameter("usuario","capriatto93");
		query.setParameter("contrasena","12345");
		Cliente cliente = (Cliente) query.getSingleResult();
		System.out.println("• ----- Punto 3 guia 8 - usuario  (dados usuario y contraseña)----");
		System.out.println(cliente.getCedula()+" - "+cliente.getNombre()+" "+cliente.getApellido());
	}
	
	/**
	 * Metodo que permite consultar todos los {@link Administrador} registrados.
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "Administrador.json", "Persona.json" })
	public void getAdministrador() {
		Query query = entityManager.createNamedQuery(Administrador.GET_ALL);
		query = query.setMaxResults(2);
		List<Administrador> lista = query.getResultList();
		System.out.println("• ----- Punto 6 guia 8 Probando Set Max Results (2) ----");
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(
					lista.get(i).getNombre() + " " + lista.get(i).getApellido() + " " + lista.get(i).getSueldo());
		}
	}
	

	/**
	 * Metodo que permite consultar todas las {@link Pelicula} compradas en 2017.
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "pelicula.json", "compra_pelicula.json", "compra_pelicula_pelicula_ids.json" })
	public void getPeliculasCompradas2017() {
		Query query = entityManager.createNamedQuery(Compra_pelicula.COMPRADAS_2017);
		List lista = query.getResultList();
		System.out.println("• ----- Punto 8 guia 8 consulta usando WHERE, BETWEEN Y AND  ----");
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
	}
	
	/**
	 * Metodo que permite consultar todos los {@link Empleado} registrados.
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "Empleado.json", "Persona.json" })
	public void getEmpleado() {
		Query query = entityManager.createNamedQuery(Empleado.GET_ALL);
		query = query.setFirstResult(1);
		List<Empleado> lista = query.getResultList();
		System.out.println("• ----- Punto 7 guia 8 Probando Set First Result (1) ----");
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(
					lista.get(i).getNombre() + " " + lista.get(i).getApellido() + " " + lista.get(i).getSueldo());
		}
	}
	
	/**
	 * Metodo que permite consultar las {@link Pelicula} Peores calificadas (calificaciones menores a 3).
	 * punto 10 (a) de guia 8
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"cliente.json", "persona.json", "pelicula.json", "pelicula_calificacion.json"})
	public void getPeoresCalificaciones() {
		Query query = entityManager.createNamedQuery(Calificacion_pelicula.GET_PEORESCALIFICACIONES);
		System.out.println("-----Punto 10a guia 8 Peliculas peor calificadas (menor a 3)----");
		List lista = query.getResultList();
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(i+"). "+lista.get(i));
		}
		
	}
	
	/**
	 * Metodo que permite consultar las {@link Empleado} del puesto de ventas.
	 * punto 10 (b) de guia 8
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"empleado.json", "persona.json"})
	public void getEmpleadosVentas() {
		Query query = entityManager.createNamedQuery(Empleado.GET_PUESTOVENTAS);
		System.out.println("-----Punto 10b guia 8 Empleados del puesto de ventas----");
		List<Empleado> lista = query.getResultList();
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(i+"). "+lista.get(i).getNombre()+" "+lista.get(i).getApellido());
		}
		
	}
	
	/**
	 * Metodo que permite consultar las {@link Empleado} del puesto de ventas.
	 * punto 10 (c) de guia 8
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"consulta_tecnica.json"})
	public void getConsultasEstado2() {
		Query query = entityManager.createNamedQuery(Consulta_tecnica.GET_CONSULTAS2);
		System.out.println("•-----Punto 10c guia 8 Consultas Tecnicas estado 2----");
		List<Consulta_tecnica> lista = query.getResultList();
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(i+"). "+lista.get(i).getConsulta());
		}
		
	}


	/**
	 * Metodo que permite consultar el {@link Cliente}. que ha realizado una compra
	 * guia 9 punto 4
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "compra_pelicula.json", "cliente.json", "persona.json"})
	public void getclinteCompraPelicula() {
		Query query = entityManager.createNamedQuery(Compra_pelicula.CLIENTE_COMPRA);
		query.setParameter("idCompra",1);
		List<Pelicula> lista = query.getResultList();
		System.out.println("-----Punto 4 guia 9 Probando cliente que ha comprado pelicula (1) ----");
		System.out.println(lista);
	}
	
	

	/**
	 * método que dado el ID de una compra permita obtener todas las Películas
	 * incluidas en esa compra, guia 9 punto 5
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "compra_pelicula.json", "compra_pelicula_pelicula_ids.json", "pelicula.json", "cliente.json", "Persona.json" })
	public void getPeliculasCompra() {
		Query query = entityManager.createNamedQuery(Compra_pelicula.GET_PELICULASENCOMPRA);
		query.setParameter("idCompra", 1);
		List<Pelicula> pelicula = query.getResultList();
		System.out.println("• -----Punto 5 guia 9 Probando obtener peliculas dado un Id de compra----");
		for (int i = 0; i < pelicula.size(); i++) {
			System.out.println(pelicula.get(i));
		}
	}
	
	/**
	 * método que permite obtener todas las consultas técnicas, incluso si no tienen un empleado asignado.
	 *  guia 9 punto 7   LEFT JOIN
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "consulta_tecnica.json", "empleado.json", "cliente.json", "persona.json"})
	public void getPersonasTelefono() {
		Query query = entityManager.createNamedQuery(Consulta_tecnica.GET_SINEMPLEADOASIGNADO);
		List lista = query.getResultList();
		System.out.println("• -----Punto 7 guia 9 usando Left Join para traer consultas técnicas aunque no tengan empleado asignado----");
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
	}

//	/**
//	 * método que dado el ID de una pelicula permita obtener todas las compras en
//	 * las que ha sido incluida, guia 9 punto 6
//	 */
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "compra_pelicula.json", "compra_pelicula_pelicula_ids.json", "cliente.json", "Persona.json" })
//	public void getCompras() {
//		Query query = entityManager.createNamedQuery(Compra_pelicula.GET_COMPRAPELICULAS);
//		query.setParameter("idPelicula", 1);
//		List<Compra_pelicula> lista = query.getResultList();
//		System.out.println("----- Probando compras en las que una pelicula fue incluida----");
//		for (int i = 0; i < lista.size(); i++) {
//			System.out.println(lista.get(i).getId());
//		}
//	}

}
