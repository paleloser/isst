package es.upm.dit.isst.gdpr.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class EspecialidadesSolicitud implements Serializable {
	
	@Id
	@ManyToOne
	private int id;
	
	private boolean TAM;
	private boolean TAICC;
	private boolean TI;
	private boolean TIC;
	private boolean D;
	private boolean DM;
	
	public EspecialidadesSolicitud() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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