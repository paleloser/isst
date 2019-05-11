package es.upm.dit.isst.gdpr.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.upm.dit.isst.gdpr.dao.AnotacionDAO;
import es.upm.dit.isst.gdpr.dao.AnotacionDAOImplementation;
import es.upm.dit.isst.gdpr.model.Anotacion;
import es.upm.dit.isst.gdpr.model.Notificacion;

class TestAnotacionDAOImplementation {
	AnotacionDAO adao = AnotacionDAOImplementation.getInstance();
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
		Collection<Anotacion> col=adao.readAll();
		for(Anotacion a : col) {
			adao.delete(a);
		}
	}

	@Test
	void testCreate() {
		Anotacion a = new Anotacion();
		a.setContenido("asdf");
		adao.create(a);
		ArrayList<Anotacion> anots = (ArrayList<Anotacion>) adao.readAll();
		String anot = anots.get(0).getId();
		assertNotNull(adao.read(anot));
	}

	@Test
	void testRead() {
		Anotacion a1 = new Anotacion();
		a1.setContenido("asdf");
		adao.create(a1);
		ArrayList<Anotacion> anots = (ArrayList<Anotacion>) adao.readAll();
		String anot = anots.get(0).getId();
		assertNotNull(adao.read(anot));
	}

	@Test
	void testUpdate() {
		Anotacion a1 = new Anotacion();
		a1.setContenido("Hi:D");
		adao.create(a1);
		a1.setContenido("ByeD:");
		adao.update(a1);
		ArrayList<Anotacion> anots = (ArrayList<Anotacion>) adao.readAll();
		String anot = anots.get(0).getId();
		assertEquals("ByeD:",adao.read(anot).getContenido());
	}

	@Test
	void testDelete() {
		Anotacion a1 = new Anotacion();
		a1.setId("a1");
		adao.create(a1);
		adao.delete(a1);
		assertEquals(0,adao.readAll().size());
	}

	@Test
	void testReadAll() {
		Anotacion a1 = new Anotacion();
		a1.setContenido("asdf");
		adao.create(a1);
		Anotacion a2 = new Anotacion();
		a1.setContenido("fdsa");
		adao.create(a2);
		assertEquals(2,adao.readAll().size());
	}
}
