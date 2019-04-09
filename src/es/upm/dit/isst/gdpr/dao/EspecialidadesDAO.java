package es.upm.dit.isst.gdpr.dao;

import java.util.Collection;
import es.upm.dit.isst.gdpr.model.Especialidades;

public interface EspecialidadesDAO {
	public void create(Especialidades especialidades);
	public Especialidades read(int id);
	public void update(Especialidades especialidades);
	public void delete(Especialidades especialidades);
	public Collection<Especialidades> readAll();
}
