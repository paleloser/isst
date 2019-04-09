package es.upm.dit.isst.gdpr.dao;

import java.util.Collection;
import es.upm.dit.isst.gdpr.model.EspecialidadesSolicitud;

public interface EspecialidadesSolicitudDAO {
	public void create(EspecialidadesSolicitud especialidades);
	public EspecialidadesSolicitud read(int id);
	public void update(EspecialidadesSolicitud especialidades);
	public void delete(EspecialidadesSolicitud especialidades);
	public Collection<EspecialidadesSolicitud> readAll();
}
