package es.upm.dit.isst.gdpr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Anotacion implements Serializable {

  
	@Id 
	private String id;
	
  @ManyToOne(targetEntity = Solicitud.class)
  private Solicitud solicitud;

  private String contenido;
  private Date dia;
  private boolean atendida;

  public Anotacion() {

  }

  public void setId(String id) {
    this.id = id;
  }

  public String getId() {
    return this.id;
  }

  public Solicitud getSolicitud() {
    return solicitud;
  }

  public void setSolicitud(Solicitud solicitud) {
    this.solicitud = solicitud;
  }

  public String getContenido() {
    return contenido;
  }

  public void setContenido(String contenido) {
    this.contenido = contenido;
  }

  public Date getDate() {
    return this.dia;
  }

  public void setDate(Date dia) {
    this.dia = dia;
  }

  /**
   * @param atendida the atendida to set
   */
  public void setAtendida(boolean atendida) {
    this.atendida = atendida;
  }

  /**
   * @return the dia
   */
  public Date getDia() {
    return dia;
  }

  /**
   * @return the atendida
   */
  public boolean isAtendida() {
    return atendida;
  }
}
