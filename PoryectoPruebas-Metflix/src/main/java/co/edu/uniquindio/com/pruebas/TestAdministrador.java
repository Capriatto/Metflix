package co.edu.uniquindio.com.pruebas;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.uniquindio.com.Persona;
import ejb.AdministradorEJB;
import excepciones.ElementoRegistradorException;
import excepciones.InformacionRepetidaException;

@RunWith(Arquillian.class)
public class TestAdministrador {
	@EJB
	private AdministradorEJB administrador;

	@Deployment
	public static Archive<?> createDeploymentPackage() {
		return ShrinkWrap.create(JavaArchive.class).addClass(AdministradorEJB.class)
				.addPackage(Persona.class.getPackage())
				.addAsResource("persistenceForTest.xml", "META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "persona.json" })
	public void registrarEmpleadoTest() {
		String cedula="12234";
		String apellido="Valencia";
		String contrasena="0000";
		String correo="aaa@algo.com";
		int estado=1;
		String nombre="carlos";
		String usuario="cavh1100";
		
		try {
			Assert.assertTrue(administrador.registroEmpleado(cedula, apellido, contrasena, correo, estado, nombre, usuario));
		} catch (ElementoRegistradorException e) {
			System.out.println("error, empleado ya registrado");
			Assert.fail("empleado repetido");
		}catch (InformacionRepetidaException e) {
			System.out.println("error, usuario ya existe");
			Assert.fail("Nombre usuario repetido");
		}
	}
}
