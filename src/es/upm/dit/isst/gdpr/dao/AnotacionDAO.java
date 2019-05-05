package es.upm.dit.isst.gdpr.dao;

import java.util.Collection;

import es.upm.dit.isst.gdpr.model.Anotacion;

public interface AnotacionDAO {
  public void create(Anotacion anotacion);
  public Anotacion read(String titulo);
  public void update(Anotacion anotacion);
  public void delete(Anotacion anotacion);
  public Collection<Anotacion> readAll();
}
