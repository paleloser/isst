package es.upm.dit.isst.gdpr.dao;

import java.util.Collection;
import es.upm.dit.isst.gdpr.model.Notificacion;

public interface NotificacionDAO {
	public void create(Notificacion notificacion);
	public Notificacion read(int id);
	public void update(Notificacion notificacion);
	public void delete(Notificacion notificacion);
	public Collection<Notificacion> readAll();
}
