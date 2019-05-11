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
	private String email;
	private String password;
	private String DNI;
	private String name;
	private String surname;
	private String cdi;          //Centro investigacion
	private boolean mcde;	     //isMemberCDE
	
	@OneToMany(mappedBy = "investigador") @LazyCollection(LazyCollectionOption.FALSE)
	private Collection<Solicitud> misSolicitudes;               //Solicitudes que me pertenecen como investigador
	
	@OneToMany(mappedBy = "miembroCDE")@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<Solicitud> solicitudes;                   //Solicitudes a revisar como miembroCDE
	
	// @OneToMany(mappedBy = "email")@LazyCollection(LazyCollectionOption.FALSE)
	// private Collection<Especialidades> especialidades;            //Especialidades como miembroCDE

	private String especialidades;
	
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
	public void setEspecialidades (String especialidades){
		this.especialidades = especialidades;
	}
	
	public String getEmail (){
		return email;
	}
	public String getPassword (){
		return password;
	}
	public String getDNI (){
		return DNI;
	}
	public String getName (){
		return name;
	}
	public String getSurname (){
		return surname;
	}
	public String getCdi (){
		return cdi;
	}
	public boolean getMcde (){
		return mcde;
	}
	public Collection<Solicitud> getMisSolicitudes (){
		return misSolicitudes;
	}
	public Collection<Solicitud> getSolicitudes (){
		return solicitudes;
	}
	public String getEspecialidades (){
		return especialidades;
	}
}