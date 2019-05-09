package es.upm.dit.isst.gdpr.dao;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.query.Query;

import es.upm.dit.isst.gdpr.model.Notificacion;

public class NotificacionDAOImplementation implements NotificacionDAO{
	
	private static NotificacionDAOImplementation NDI = null;
	private NotificacionDAOImplementation() {}
	public static NotificacionDAOImplementation getInstance() {
		if ( NDI == null )
			NDI = new NotificacionDAOImplementation();
		return NDI;
	}
	@Override
	public void create(Notificacion notificacion) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
      Calendar date = Calendar.getInstance();
      Date today = date.getTime();
			notificacion.setDate(today);
			notificacion.setTipo(notificacion.getTipo() == null ? "" : notificacion.getTipo());
			session.save(notificacion);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public void delete(Notificacion notificacion) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(notificacion);
			session.getTransaction().commit();
		} catch(Exception e) {
			System.out.print(e);
		}finally {
			session.close();
		}
	}
	
	@Override
	public Notificacion read(int id) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			Notificacion not = session.load(Notificacion.class,  id);
			session.getTransaction().commit();
			return not;
		} catch(Exception e) {
			System.out.print(e);
			return null;
		}finally {
			session.close();
		}
	}
	
	@Override
	public void update(Notificacion notificacion) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(notificacion);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Notificacion> readAll() {
		Session session = SessionFactoryService.get().openSession();
		Collection<Notificacion> nots = null;
		try {
			session.beginTransaction();
			nots = session.createQuery("from Notificacion").list();
			session.getTransaction().commit();
			
		} catch(Exception e) {
			System.out.print(e);
		}finally {
			session.close();
		}
		return nots;
	}

	@Override
	public Collection<Notificacion> readAllOrderedByDate() {
		Session session = SessionFactoryService.get().openSession();
		Collection<Notificacion> nots = null;
		try {
			session.beginTransaction();
			Query query = session.createQuery("from Notificacion order by date");
			nots = query.list();
			System.out.println("//////////////////////////////////////////////////////////////////// " + nots.size());
			session.getTransaction().commit();
			
		} catch(Exception e) {
			System.out.print(e);
		}finally {
			session.close();
		}
		return nots;
	}
}
