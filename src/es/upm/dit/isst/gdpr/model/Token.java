package es.upm.dit.isst.gdpr.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Token implements Serializable {

  
	@Id 
	private String id;

  private Boolean valido;
  
	@ManyToOne(targetEntity = Usuario.class)
  private Usuario emitidoPor;

  public Token() {

  }

  public void setId(String id) {
    this.id = id;
  }

  /**
   * @param valido the valido to set
   */
  public void setValido(Boolean valido) {
    this.valido = valido;
  }

  /**
   * @param emitidoPor the emitidoPor to set
   */
  public void setEmitidoPor(Usuario emitidoPor) {
    this.emitidoPor = emitidoPor;
  }

  public String getId() {
    return this.id;
  }

  /**
   * @return the valido
   */
  public Boolean getValido() {
    return valido;
  }

  /**
   * @return the emitidoPor
   */
  public Usuario getEmitidoPor() {
    return emitidoPor;
  }

}
