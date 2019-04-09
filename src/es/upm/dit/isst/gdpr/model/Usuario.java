package es.upm.dit.isst.gdpr.model;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import java.util.Collection;

@Entity
public class Usuario implements Serializable {
	
	@Id
	private int id;
	
	private String email;
	private String password;
	private String DNI;
	private String userName;
	private String name;
	private String surname;
	private String cdi;
	private boolean mcde;
	
	@OneToMany(mappedBy = "investigador", fetch = FetchType.EAGER)
	private Collection<Solicitud> misSolicitudes;
	
	@OneToMany(mappedBy = "miembroCde", fetch = FetchType.EAGER)
	private Collection<Solicitud> solicitudes;
	
	@OneToMany(mappedBy = "id", fetch = FetchType.EAGER)
	private Collection<Especialidades> especialidades;
	
	@OneToMany(mappedBy = "id", fetch = FetchType.EAGER)
	private Collection<EspecialidadesSolicitud> especialidadesSolicitud;
	
	@OneToMany(mappedBy = "email", fetch = FetchType.EAGER)
	private Collection<Notificacion> notificaciones;
	
	public Usuario() {}
	
	public void setId (int id){
		this.id =id;
	}
	public void setEmail (String email){
		this.email = email;
	}
	public void setPassword (String password){
		this.password = password;
	}
	public void setDNI (String DNI){
		this.DNI = DNI;
	}
	public void setUserName (String userName){
		this.userName = userName;
	}
	public void setName (String name){
		this.name = name;
	}
	public void setSurname (String surname){
		this.surname = surname;
	}
	public void setCdi (String cdi){
		this.cdi = cdi;
	}
	public void setMcde (boolean mcde){
		this.mcde = mcde;
	}
	public void setMisSolicitudes (Collection<Solicitud> misSolicitudes){
		this.misSolicitudes = misSolicitudes;
	}
	public void setSolicitudes (Collection<Solicitud> solicitudes){
		this.solicitudes = solicitudes;
	}
	public void setEspecialidades (Collection<Especialidades> especialidades){
		this.especialidades = especialidades;
	}
	public void setEspecialidadesSolicitud (Collection<EspecialidadesSolicitud> especialidades){
		this.especialidadesSolicitud = especialidadesSolicitud;
	}
	public void setNotificaciones (Collection<Notificacion> notificaciones){
		this.notificaciones = notificaciones;
	}
	
	public int getId (){
		return id;
	}
	public String getEmail (){
		return email;
	}
	public String setPassword (){
		return password;
	}
	public String setDNI (){
		return DNI;
	}
	public String setUserName (){
		return userName;
	}
	public String setName (){
		return name;
	}
	public String setSurname (){
		return surname;
	}
	public String setCdi (){
		return cdi;
	}
	public boolean setMcde (){
		return mcde;
	}
	public Collection<Solicitud> setMisSolicitudes (){
		return misSolicitudes;
	}
	public Collection<Solicitud> setSolicitudes (){
		return solicitudes;
	}
	public Collection<Especialidades> getEspecialidades (){
		return especialidades;
	}
	public Collection<EspecialidadesSolicitud> getEspecialidadesSolicitud (){
		return especialidadesSolicitud;
	}
	public Collection<Notificacion> getNotificaciones (){
		return notificaciones;
	}
}