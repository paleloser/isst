package es.upm.dit.isst.gdpr.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Solicitud implements Serializable{
	
	@Id
	private int id;
	
	@ManyToOne
	private Usuario investigador;
	
	private Usuario miembroCDE;
	
	@Lob
	private byte[] investigacion;
	
	private byte[] form;
	private int estado;

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

	public byte[] getForm() {
		return form;
	}

	public void setForm(byte[] form) {
		this.form = form;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	
}
