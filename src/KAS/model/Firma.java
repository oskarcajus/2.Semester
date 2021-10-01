package KAS.model;

import java.util.ArrayList;

public class Firma {
	private String navn;
	private String adresse;
	private String tlfNr;
	
	//Associering-link til deltager
	private ArrayList<Deltager> deltagere;
	
	public Firma(String navn, String adresse, String tlfNr, ArrayList<Deltager> deltagere) {
		this.navn = navn;
		this.adresse = adresse;
		this.tlfNr = tlfNr;
		this.deltagere = deltagere;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTlfNr() {
		return tlfNr;
	}

	public void setTlfNr(String tlfNr) {
		this.tlfNr = tlfNr;
	}
	
	//Deltager ---------------------------
	public ArrayList<Deltager> getDeltagere() {
		return new ArrayList<Deltager>(deltagere);
	}
	
	public Deltager addDeltager(Deltager deltager) {
		if (!this.deltagere.contains(deltager)) {
			this.deltagere.add(deltager);
			deltager.setFirma(this);
		}
		return deltager;
		
	}
	
	public void removeDeltager(Deltager deltager) {
		if (this.deltagere.contains(deltager)) {
			this.deltagere.remove(deltager);
			deltager.setFirma(null);
		}
	}

	
	
	
}
