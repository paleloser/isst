package es.upm.dit.isst.gdpr.dao;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.Session;

import es.upm.dit.isst.gdpr.model.Anotacion;
import es.upm.dit.isst.gdpr.model.Solicitud;

public class AnotacionDAOImplementation implements AnotacionDAO {

  private static AnotacionDAOImplementation instancia = null;

  public static AnotacionDAOImplementation getInstance() {
    if (instancia == null)
      instancia = new AnotacionDAOImplementation();
    return instancia;
  }

  private AnotacionDAOImplementation() {
  }

  @Override
  public void create(Anotacion anotacion) {

    Session session = SessionFactoryService.get().openSession();
    try {

      session.beginTransaction();
      String id = UUID.randomUUID().toString();
      Calendar date = Calendar.getInstance();
      Date today = date.getTime();
      anotacion.setDate(today);
      anotacion.setId(id);
      session.save(anotacion);
      session.getTransaction().commit();

    } catch (Exception e) {
      System.out.print(e);

    } finally {

      session.close();
    }

  }

  @Override
  public Anotacion read(String titulo) {

    Session session = SessionFactoryService.get().openSession();
    Anotacion Anotacion = null;
    try {

      session.beginTransaction();
      Anotacion = session.load(Anotacion.class, titulo);
      session.getTransaction().commit();

    } catch (Exception e) {
      System.out.print(e);

    } finally {

      session.close();
    }

    return Anotacion;
  }

  @Override
  public void update(Anotacion anotacion) {

    Session session = SessionFactoryService.get().openSession();
    try {

      session.beginTransaction();
      session.saveOrUpdate(anotacion);
      session.getTransaction().commit();

    } catch (Exception e) {
      System.out.print(e);

    } finally {

      session.close();
    }

  }

  @Override
  public void delete(Anotacion anotacion) {

    Session session = SessionFactoryService.get().openSession();
    try {

      session.beginTransaction();
      session.delete(anotacion);
      session.getTransaction().commit();

    } catch (Exception e) {
      System.out.print(e);

    } finally {

      session.close();
    }
  }

  @Override
  public Collection<Anotacion> readAll() {

    Session session = SessionFactoryService.get().openSession();
    Collection<Anotacion> solicitudes = null;
    try {

      session.beginTransaction();
      solicitudes = session.createQuery("from Anotacion").list();
      session.getTransaction().commit();

    } catch (Exception e) {
      System.out.print(e);

    } finally {

      session.close();
    }
    return solicitudes;
  }

  public Collection<Anotacion> readAllBySolicitud(Solicitud solicitud) {
    Session session = SessionFactoryService.get().openSession();
    Collection<Anotacion> solicitudes = null;
    try {

      session.beginTransaction();
      
      Query query = session.createQuery("from Anotacion where solicitud_titulo = :titulo");
      query.setParameter("titulo", solicitud.getTitulo());
      solicitudes = query.list();
      
      session.getTransaction().commit();

    } catch (Exception e) {
      System.out.print(e);

    } finally {

      session.close();
    }
    return solicitudes;
  }

}
