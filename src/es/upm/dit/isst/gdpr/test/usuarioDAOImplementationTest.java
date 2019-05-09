package es.upm.dit.isst.gdpr.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.upm.dit.isst.gdpr.dao.SolicitudDAO;
import es.upm.dit.isst.gdpr.dao.SolicitudDAOImplementation;
import es.upm.dit.isst.gdpr.dao.UsuarioDAO;
import es.upm.dit.isst.gdpr.dao.UsuarioDAOImplementation;
import es.upm.dit.isst.gdpr.model.Solicitud;
import es.upm.dit.isst.gdpr.model.Usuario;

class usuarioDAOImplementationTest {

	@BeforeEach
	void setUp() throws Exception {
		UsuarioDAO udao = UsuarioDAOImplementation.getInstance();
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) udao.readAll();
		for(Usuario usu: usuarios) {
			udao.delete(usu);
		}
		Usuario usu = new Usuario();
		usu.setDNI("1234");
		usu.setEmail("prueba@prueba");
		usu.setMcde(true);
		udao.create(usu);
	}

	@AfterEach
	void tearDown() throws Exception {
		UsuarioDAO udao = UsuarioDAOImplementation.getInstance();
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) udao.readAll();
		for(Usuario usu: usuarios) {
			udao.delete(usu);
		}
	}

	@Test
	void testCreate() {
		UsuarioDAO udao = UsuarioDAOImplementation.getInstance();
		Usuario usu = udao.read("prueba@prueba");
		assertEquals("prueba@prueba",usu.getEmail());
		assertEquals("1234",usu.getDNI());
		assertEquals(true,usu.getMcde());
	}

	@Test
	void testDelete() {
		UsuarioDAO udao = UsuarioDAOImplementation.getInstance();
		Usuario usu = new Usuario();
		usu.setEmail("PRUEBADELETE");
		int tamanoAntesDeCrear = udao.readAll().size();
		udao.create(usu);
		assertEquals(tamanoAntesDeCrear+1,udao.readAll().size());
		udao.delete(usu);
		assertEquals(tamanoAntesDeCrear,udao.readAll().size());
	}

	@Test
	void testRead() {
		UsuarioDAO udao = UsuarioDAOImplementation.getInstance();
		Usuario usu = udao.read("prueba@prueba");
		assertEquals("prueba@prueba",usu.getEmail());
		assertEquals("1234",usu.getDNI());
		assertEquals(true,usu.getMcde());
	}

	@Test
	void testUpdate() {
		UsuarioDAO udao = UsuarioDAOImplementation.getInstance();
		Usuario usu = udao.read("prueba@prueba");
		usu.setDNI("5678");
		udao.update(usu);
		assertEquals("prueba@prueba",udao.read("prueba@prueba").getEmail());
		assertEquals("5678",udao.read("prueba@prueba").getDNI());
	}

	@Test
	void testReadAll() {
		Usuario usu = new Usuario();
		usu.setDNI("9012");
		usu.setEmail("PRUEBAREADALL");
		UsuarioDAO udao = UsuarioDAOImplementation.getInstance();
		udao.create(usu);
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) udao.readAll();
		assertEquals(2, usuarios.size());
	}

}
