package es.upm.dit.isst.gdpr.model;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.FetchType;
import java.util.Collection;

@Entity
public class Usuario implements Serializable {
	
	@Id
	private String userName;
	
	private String email;
	private String password;
	private String DNI;
	private String name;
	private String surname;
	private String cdi;
	private boolean mcde;
	
	@OneToMany(mappedBy = "investigador") @LazyCollection(LazyCollectionOption.FALSE)
	private Collection<Solicitud> misSolicitudes;               //Solicitudes que me pertenecen como investigador
	
	@OneToMany(mappedBy = "miembroCDE")@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<Solicitud> solicitudes;                   //Solicitudes a revisar como miembroCDE
	
	@OneToMany(mappedBy = "userName")@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<Especialidades> especialidades;            //Especialidades como miembroCDE
	
	
	@OneToMany(mappedBy = "email", fetch = FetchType.EAGER)
	private Collection<Notificacion> notificaciones;
	
	public Usuario() {}
	
	
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
	
	public void setNotificaciones (Collection<Notificacion> notificaciones){
		this.notificaciones = notificaciones;
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
	
	public Collection<Notificacion> getNotificaciones (){
		return notificaciones;
	}
}