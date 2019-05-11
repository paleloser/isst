package es.upm.dit.isst.gdpr.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.upm.dit.isst.gdpr.dao.NotificacionDAO;
import es.upm.dit.isst.gdpr.dao.NotificacionDAOImplementation;
import es.upm.dit.isst.gdpr.model.Anotacion;
import es.upm.dit.isst.gdpr.model.Notificacion;

class TestNotificacionDAOImplementation {
	NotificacionDAO ndao = NotificacionDAOImplementation.getInstance();
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
		Collection<Notificacion> col = ndao.readAll();
		for(Notificacion n : col) {
			ndao.delete(n);
		}
	}

	@Test
	void testCreate() {
		Notificacion n = new Notificacion();
		n.setId(1024);
		ndao.create(n);
		assertNotNull(ndao.read(1024));
	}

	@Test
	void testRead() {
		Notificacion n1 = new Notificacion();
		n1.setId(1024);
		ndao.create(n1);
		Notificacion n2 = ndao.read(1024);
		assertNotNull(n2);
	}

	@Test
	void testUpdate() {
		Notificacion n1 = new Notificacion();
		n1.setContenido("Hi:D");
		ndao.create(n1);
		n1.setContenido("ByeD:");
		ndao.update(n1);
		ArrayList<Notificacion> nots = (ArrayList<Notificacion>) ndao.readAll();
		int anot = nots.get(0).getId();
		assertEquals("ByeD:",ndao.read(anot).getContenido());
	}

	@Test
	void testDelete() {
		Notificacion n1 = new Notificacion();
		n1.setId(1024);
		ndao.create(n1);
		ndao.delete(n1);
		assertEquals(0,ndao.readAll().size());
	}

	@Test
	void testReadAll() {
		Notificacion n1 = new Notificacion();
		n1.setId(1024);
		ndao.create(n1);
		Notificacion n2 = new Notificacion();
		n2.setId(2048);
		ndao.create(n2);
		assertEquals(2,ndao.readAll().size());
	}
}
