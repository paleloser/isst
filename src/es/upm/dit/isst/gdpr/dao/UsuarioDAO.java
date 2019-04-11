package es.upm.dit.isst.gdpr.dao;

import java.util.Collection;
import es.upm.dit.isst.gdpr.model.Usuario;

public interface UsuarioDAO {
	public void create(Usuario usuario);
	public Usuario read(String userName);
	public void update(Usuario usuario);
	public void delete(Usuario usuario);
	public Collection<Usuario> readAll();
}
