package es.upm.dit.isst.gdpr.dao;

import java.util.Collection;
import org.hibernate.Session;
import es.upm.dit.isst.gdpr.model.Especialidades;

public class EspecialidadesDAOImplementation implements EspecialidadesDAO{
	
	private static EspecialidadesDAOImplementation EDI = null;
	private EspecialidadesDAOImplementation() {}
	public static EspecialidadesDAOImplementation getInstance() {
		if ( EDI == null )
			EDI = new EspecialidadesDAOImplementation();
		return EDI;
	}
	@Override
	public void create(Especialidades especialidades) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(especialidades);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public void delete(Especialidades especialidades) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(especialidades);
			session.getTransaction().commit();
		} catch(Exception e) {
			System.out.print(e);
		}finally {
			session.close();
		}
	}
	
	@Override
	public Especialidades read(int id) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			Especialidades esp = session.load(Especialidades.class,  id);
			session.getTransaction().commit();
			return esp;
		} catch(Exception e) {
			System.out.print(e);
			return null;
		}finally {
			session.close();
		}
	}
	
	@Override
	public void update(Especialidades especialidades) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(especialidades);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Especialidades> readAll() {
		Session session = SessionFactoryService.get().openSession();
		Collection<Especialidades> esps = null;
		try {
			session.beginTransaction();
			esps = session.createQuery("from Especialidades").list();
			session.getTransaction().commit();
		} catch(Exception e) {
			System.out.print(e);
		}finally {
			session.close();
		}
		return esps;
	}
}
