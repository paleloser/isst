package es.upm.dit.isst.gdpr.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.upm.dit.isst.gdpr.dao.SolicitudDAO;
import es.upm.dit.isst.gdpr.dao.SolicitudDAOImplementation;
import es.upm.dit.isst.gdpr.model.Solicitud;

class solicitudDAOImplementationTest {

	@BeforeEach
	void setUp() throws Exception {
		SolicitudDAO sdao = SolicitudDAOImplementation.getInstance();
		ArrayList<Solicitud> sols = (ArrayList<Solicitud>) sdao.readAll();
		for(Solicitud sol: sols) {
			sdao.delete(sol);
		}
		Solicitud sol = new Solicitud();
		sol.setEstado(2);
		sol.setFecha("PRUEBA2");
		sol.setTitulo("PRUEBA");
		sdao.create(sol);
	}

	@AfterEach
	void tearDown() throws Exception {
		SolicitudDAO sdao = SolicitudDAOImplementation.getInstance();
		ArrayList<Solicitud> sols = (ArrayList<Solicitud>) sdao.readAll();
		for(Solicitud sol: sols) {
			sdao.delete(sol);
		}
	}

	@Test
	void testCreate() {
		SolicitudDAO sdao = SolicitudDAOImplementation.getInstance();
		Solicitud sol = sdao.read("PRUEBA");
		assertEquals("PRUEBA",sol.getTitulo());
		assertEquals("PRUEBA2",sol.getFecha());
	}

	@Test
	void testRead() {
		SolicitudDAO sdao = SolicitudDAOImplementation.getInstance();
		Solicitud sol = sdao.read("PRUEBA");
		assertEquals("PRUEBA",sol.getTitulo());
		assertEquals("PRUEBA2",sol.getFecha());
	}

	@Test
	void testUpdate() {
		SolicitudDAO sdao = SolicitudDAOImplementation.getInstance();
		Solicitud sol = sdao.read("PRUEBA");
		sol.setFecha("PRUEBA3");
		sdao.update(sol);
		assertEquals("PRUEBA",sdao.read("PRUEBA").getTitulo());
		assertEquals("PRUEBA3",sdao.read("PRUEBA").getFecha());
	}

	@Test
	void testDelete() {
		SolicitudDAO sdao = SolicitudDAOImplementation.getInstance();
		Solicitud sol = new Solicitud();
		sol.setTitulo("PRUEBADELETE");
		int tamanoAntesDeCrear = sdao.readAll().size();
		sdao.create(sol);
		assertEquals(tamanoAntesDeCrear+1,sdao.readAll().size());
		sdao.delete(sol);
		assertEquals(tamanoAntesDeCrear,sdao.readAll().size());
	}

	@Test
	void testReadAll() {
		Solicitud sol = new Solicitud();
		sol.setEstado(1);
		sol.setFecha("PRUEBA5");
		sol.setTitulo("PRUEBA6");
		SolicitudDAO sdao = SolicitudDAOImplementation.getInstance();
		sdao.create(sol);
		ArrayList<Solicitud> sols = (ArrayList<Solicitud>) sdao.readAll();
		assertEquals(2, sols.size());
		

		
	}

}
