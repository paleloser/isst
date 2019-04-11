package es.upm.dit.isst.gdpr.dao;

import java.util.Collection;
import org.hibernate.Session;
import es.upm.dit.isst.gdpr.model.EspecialidadesSolicitud;

public class EspecialidadesSolicitudDAOImplementation implements EspecialidadesSolicitudDAO{
	
	private static EspecialidadesSolicitudDAOImplementation ESDI = null;
	private EspecialidadesSolicitudDAOImplementation() {}
	public static EspecialidadesSolicitudDAOImplementation getInstance() {
		if ( ESDI == null )
			ESDI = new EspecialidadesSolicitudDAOImplementation();
		return ESDI;
	}
	@Override
	public void create(EspecialidadesSolicitud especialidades) {
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
	public void delete(EspecialidadesSolicitud especialidades) {
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
	public EspecialidadesSolicitud read(String titulo) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			EspecialidadesSolicitud esps = session.load(EspecialidadesSolicitud.class,  titulo);
			session.getTransaction().commit();
			return esps;
		} catch(Exception e) {
			System.out.print(e);
			return null;
		}finally {
			session.close();
		}
	}
	
	@Override
	public void update(EspecialidadesSolicitud especialidades) {
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
	public Collection<EspecialidadesSolicitud> readAll() {
		Session session = SessionFactoryService.get().openSession();
		Collection<EspecialidadesSolicitud> espss = null;
		try {
			session.beginTransaction();
			espss = session.createQuery("from EspecialidadesSolicitud").list();
			session.getTransaction().commit();
		} catch(Exception e) {
			System.out.print(e);
		}finally {
			session.close();
		}
		return espss;
	}
}
