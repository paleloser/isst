package es.upm.dit.isst.gdpr.dao;

import java.util.Collection;

import es.upm.dit.isst.gdpr.model.Solicitud;

public interface SolicitudDAO {
	
	public void create(Solicitud solicitud);
	
	public Solicitud read(String titulo);
	
	public void update(Solicitud solicitud);
	
	public void delete(Solicitud solicitud);
	
	public Collection<Solicitud> readAll();

}
