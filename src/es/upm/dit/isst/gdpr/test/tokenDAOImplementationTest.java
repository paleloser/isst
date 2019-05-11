package es.upm.dit.isst.gdpr.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.upm.dit.isst.gdpr.dao.TokenDAO;
import es.upm.dit.isst.gdpr.dao.TokenDAOImplementation;
import es.upm.dit.isst.gdpr.dao.UsuarioDAO;
import es.upm.dit.isst.gdpr.dao.UsuarioDAOImplementation;
import es.upm.dit.isst.gdpr.model.Token;
import es.upm.dit.isst.gdpr.model.Usuario;

class tokenDAOImplementationTest {

	@BeforeEach
	void setUp() throws Exception {
		
		TokenDAO tdao = TokenDAOImplementation.getInstance();
		ArrayList<Token> tokens = (ArrayList<Token>) tdao.readAll();
		for(Token tok: tokens) {
			tdao.delete(tok);
		}
		Token token = new Token();
		Usuario us = new Usuario();
		us.setEmail("PRUEBA");
		UsuarioDAOImplementation.getInstance().create(us);
		token.setValido(true);
		token.setEmitidoPor(us);
		tdao.create(token);
	}

	@AfterEach
	void tearDown() throws Exception {
		
		TokenDAO tdao = TokenDAOImplementation.getInstance();
		ArrayList<Token> tokens = (ArrayList<Token>) tdao.readAll();
		for(Token token: tokens) {
			tdao.delete(token);
		}
		UsuarioDAO udao = UsuarioDAOImplementation.getInstance();
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) udao.readAll();
		for(Usuario usu: usuarios) {
			udao.delete(usu);
		}
	}

	@Test
	void testCreate() {
		TokenDAO tdao = TokenDAOImplementation.getInstance();
		ArrayList<Token> tokens = (ArrayList<Token>) tdao.readAll();
		Token token = tokens.get(0);
		Usuario usu = UsuarioDAOImplementation.getInstance().read("PRUEBA");
		assertEquals("PRUEBA",usu.getEmail());
		assertEquals(true,token.getValido());
	}

	@Test
	void testRead() {
		TokenDAO tdao = TokenDAOImplementation.getInstance();
		ArrayList<Token> tokens = (ArrayList<Token>) tdao.readAll();
		Token token = tokens.get(0);
		Usuario usu = UsuarioDAOImplementation.getInstance().read("PRUEBA");
		assertEquals("PRUEBA",usu.getEmail());
		assertEquals(true,token.getValido());
	}

	@Test
	void testUpdate() {
		TokenDAO tdao = TokenDAOImplementation.getInstance();
		ArrayList<Token> tokens = (ArrayList<Token>) tdao.readAll();
		Token token = tokens.get(0);
		token.setValido(false);
		tdao.update(token);
		ArrayList<Token> tokens2 = (ArrayList<Token>) tdao.readAll();
		Token token2 = tokens.get(0);
		assertEquals(false,token2.getValido());
		assertEquals("PRUEBA",token2.getEmitidoPor().getEmail());
	}

	@Test
	void testDelete() {
		TokenDAO tdao = TokenDAOImplementation.getInstance();
		Token token = new Token();
		token.setId("PRUEBADELETE");
		int tamanoAntesDeCrear = tdao.readAll().size();
		tdao.create(token);
		assertEquals(tamanoAntesDeCrear+1,tdao.readAll().size());
		tdao.delete(token);
		assertEquals(tamanoAntesDeCrear,tdao.readAll().size());
	}

	@Test
	void testReadAll() {
		Token token = new Token();
		token.setId("5678");
		token.setValido(true);
		TokenDAO tdao = TokenDAOImplementation.getInstance();
		tdao.create(token);
		ArrayList<Token> tokens = (ArrayList<Token>) tdao.readAll();
		assertEquals(2, tokens.size());
	}

}
