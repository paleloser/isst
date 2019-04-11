package es.upm.dit.isst.gdpr.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Especialidades implements Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	

	@ManyToOne(targetEntity = Usuario.class)
	private String userName;
	private boolean TAM;    //Tecnologias Agroforestales y Medioambientales
	private boolean TAICC;  //Tecnologias de la Arquitectura e Ingenieria de caminos y civil
	private boolean TI;     //Tecnologias Industriales
	private boolean TIC;    //Tecnologias de la Informacion y de las Comunicaciones
	private boolean D;      //Deporte
	private boolean DM;     //Diseño y Moda
	
	public Especialidades() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean getTAM() {
		return TAM;
	}

	public void setTAM(boolean tAM) {
		TAM = tAM;
	}

	public boolean getTAICC() {
		return TAICC;
	}

	public void setTAICC(boolean tAICC) {
		TAICC = tAICC;
	}

	public boolean getTI() {
		return TI;
	}

	public void setTI(boolean tI) {
		TI = tI;
	}

	public boolean getTIC() {
		return TIC;
	}

	public void setTIC(boolean tIC) {
		TIC = tIC;
	}

	public boolean getD() {
		return D;
	}

	public void setD(boolean d) {
		D = d;
	}

	public boolean getDM() {
		return DM;
	}

	public void setDM(boolean dM) {
		DM = dM;
	}
	
	
}