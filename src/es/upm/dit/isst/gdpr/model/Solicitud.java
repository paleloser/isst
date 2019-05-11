package es.upm.dit.isst.gdpr.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Solicitud implements Serializable{
	
	@Id 
	private String titulo;
	
	@ManyToOne(targetEntity = Usuario.class)
	private Usuario investigador;
	@ManyToOne(targetEntity = Usuario.class)
	private Usuario miembroCDE;
	
	@Lob
	private byte[] investigacion;
	
	@ElementCollection
	private Map<String, String[]> form;
	
	private int estado;
	private String fecha;
	private String hmac;

	@Lob
	private byte[] certificado;
	
	public Solicitud() {
		
	}
	

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha2) {
		this.fecha = fecha2;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	

	public Usuario getInvestigador() {
		return investigador;
	}

	public void setInvestigador(Usuario investigador) {
		this.investigador = investigador;
	}

	public Usuario getMiembroCDE() {
		return miembroCDE;
	}

	public void setMiembroCDE(Usuario miembroCDE) {
		this.miembroCDE = miembroCDE;
	}

	public byte[] getInvestigacion() {
		return investigacion;
	}

	public void setInvestigacion(byte[] investigacion) {
		this.investigacion = investigacion;
	}

	public Map<String, String[]> getForm() {
		return form;
	}

	public void setForm(Map<String, String[]> form) {
		this.form = form;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	/**
	 * @param hmac the hmac to set
	 */
	public void setHmac(String hmac) {
		this.hmac = hmac;
	}

	/**
	 * @return the hmac
	 */
	public String getHmac() {
		return hmac;
	}

	/**
	 * @return the certificado
	 */
	public byte[] getCertificado() {
		return certificado;
	}

	/**
	 * @param certificado the certificado to set
	 */
	public void setCertificado(byte[] certificado) {
		this.certificado = certificado;
	}
}
