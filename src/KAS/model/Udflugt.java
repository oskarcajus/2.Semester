package KAS.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Udflugt {
	private String navn;
	private double pris;
	private boolean medFrokost;
	private LocalDateTime startDato;
	private LocalDateTime slutDato;
	
	//Komposition-link til konference
	private Konference konference;
	
	//Associering-link til deltagerens ledsager
	private ArrayList<Ledsager> ledsagere = new ArrayList<Ledsager>();
	
	//Associering-link til registrering
	private ArrayList<Registrering> registreringer  = new ArrayList<Registrering>();

	public Udflugt(String navn, double pris, boolean medFrokost, LocalDateTime startDato, LocalDateTime slutDato) {
		this.navn = navn;
		this.pris = pris;
		this.medFrokost = medFrokost;
		this.startDato = startDato;
		this.slutDato = slutDato;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public double getPris() {
		return pris;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}

	public boolean isMedFrokost() {
		return medFrokost;
	}

	public void setMedFrokost(boolean medFrokost) {
		this.medFrokost = medFrokost;
	}

	public LocalDateTime getStartDato() {
		return startDato;
	}

	public void setStartDato(LocalDateTime startDato) {
		this.startDato = startDato;
	}

	public LocalDateTime getSlutDato() {
		return slutDato;
	}

	public void setSlutDato(LocalDateTime slutDato) {
		this.slutDato = slutDato;
	}
	
	//Konference -----------------------------------
	public Konference getKonference() {
		return this.konference;
	}
	
	public void setKonference(Konference konference) {
		this.konference = konference;
	}
	
	//Ledsager --------------------------------------
	public ArrayList<Ledsager> getLedsagere() {
		return new ArrayList<Ledsager>(ledsagere);
	}
	
	public Ledsager addLedsager(Ledsager ledsager) {
		if (!this.ledsagere.contains(ledsager)) {
			this.ledsagere.add(ledsager);
		}
		return ledsager;
	}
	
	public Ledsager removeLedsager(Ledsager ledsager) {
		if (this.ledsagere.contains(ledsager)) {
			this.ledsagere.remove(ledsager);
		}
		return ledsager;
	}

	//Registrering ------------------------------------
	public ArrayList<Registrering> getRegistreringer() {
		return new ArrayList<Registrering>(registreringer);
	}
	
	public Registrering addRegistrering(Registrering registrering) {
		if (!this.registreringer.contains(registrering)) {
			this.registreringer.add(registrering);
			registrering.addUdflugt(this);
		}
		return registrering;
	}
	
	public void removeRegistrering(Registrering registrering) {
		if (!this.registreringer.contains(registrering)) {
			this.registreringer.add(registrering);
			registrering.removeUdflugt(this);
		}
	}
	
	@Override
	public String toString() {
		return this.navn + ", kr. " + this.pris;
	}

	
}
