package es.upm.dit.isst.gdpr.dao;

import java.util.Collection;
import org.hibernate.Session;
import es.upm.dit.isst.gdpr.model.Usuario;

public class UsuarioDAOImplementation implements UsuarioDAO{
	
	private static UsuarioDAOImplementation UDI = null;
	private UsuarioDAOImplementation() {}
	public static UsuarioDAOImplementation getInstance() {
		if ( UDI == null )
			UDI = new UsuarioDAOImplementation();
		return UDI;
	}
	@Override
	public void create(Usuario usuario) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(usuario);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public void delete(Usuario usuario) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(usuario);
			session.getTransaction().commit();
		} catch(Exception e) {
			System.out.print(e);
		}finally {
			session.close();
		}
	}
	
	@Override
	public Usuario read(String userName) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			Usuario us = session.load(Usuario.class,  userName);
			session.getTransaction().commit();
			return us;
		} catch(Exception e) {
			System.out.print(e);
			return null;
		}finally {
			session.close();
		}
	}
	
	@Override
	public void update(Usuario usuario) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(usuario);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Usuario> readAll() {
		Session session = SessionFactoryService.get().openSession();
		Collection<Usuario> uss = null;
		try {
			session.beginTransaction();
			uss = session.createQuery("from Usuario").list();
			session.getTransaction().commit();
		} catch(Exception e) {
			System.out.print(e);
		}finally {
			session.close();
		}
		return uss;
	}
}
