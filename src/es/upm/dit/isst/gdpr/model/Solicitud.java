package es.upm.dit.isst.gdpr.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Solicitud implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Usuario investigador;
	
	private Usuario miembroCDE;
	
	@Lob
	private byte[] investigacion;
	
	private Map<String, String[]> form;
	private int estado;
	
	private String fecha;
	private String titulo;

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

	public Solicitud() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	
}
