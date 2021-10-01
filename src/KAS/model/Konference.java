package KAS.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Konference {
	private String navn;
	private String adresse;
	private double prisPrDag;
	private LocalDateTime startDato;
	private LocalDateTime slutDato;
	private String beskrivelse;

	// Mange-mange associering til hotel
	private ArrayList<Hotel> hoteller = new ArrayList<Hotel>();

	// Kompostion til udflugt
	private ArrayList<Udflugt> udflugter = new ArrayList<Udflugt>();

	// Komposition til registrering
	private ArrayList<Registrering> registreringer = new ArrayList<Registrering>();

	public Konference(String navn, String adresse, double prisPrDag, LocalDateTime startDato, LocalDateTime slutDato,
			String beskrivelse) {
		this.navn = navn;
		this.adresse = adresse;
		this.prisPrDag = prisPrDag;
		this.startDato = startDato;
		this.slutDato = slutDato;
		this.beskrivelse = beskrivelse;
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

	public double getPrisPrDag() {
		return prisPrDag;
	}

	public void setPrisPrDag(double prisPrDag) {
		this.prisPrDag = prisPrDag;
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

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}

	//Udflugt -----------------------------------
	public ArrayList<Udflugt> getUdflugter() {
		return new ArrayList<Udflugt>(udflugter);
	}
	
	public Udflugt createUdflugt(String navn, double pris, boolean medFrokost, LocalDateTime startDato,
			LocalDateTime slutDato) {
		Udflugt udflugt = new Udflugt(navn, pris, medFrokost, startDato, slutDato);
		this.udflugter.add(udflugt);
		udflugt.setKonference(this);
		return udflugt;
	}

	public void removeUdflugt(Udflugt udflugt) {
		if (this.udflugter.contains(udflugt)) {
			this.udflugter.remove(udflugt);
			udflugt.setKonference(null);
		}
	}
	
	public void addLedsagerToUdflugt(Ledsager ledsager, Udflugt udflugt) {
		udflugt.addLedsager(ledsager);
	}
	
	public void removeLedsagerFromUdflugt(Ledsager ledsager, Udflugt udflugt) {
		udflugt.removeLedsager(ledsager);
	}
	
	//Hotel --------------------------------------
	public ArrayList<Hotel> getHoteller() {
		return new ArrayList<Hotel>(hoteller);
	}
	
	public void addHotel(Hotel hotel) {
		if (!this.hoteller.contains(hotel)) {
			this.hoteller.add(hotel);
			hotel.addKonference(this);
		}
	}

	public void removeHotel(Hotel hotel) {
		if (this.hoteller.contains(hotel)) {
			this.hoteller.remove(hotel);
			hotel.removeKonference(this);
		}
	}
	
	//Registrering -----------------------------------
	public ArrayList<Registrering> getRegistreringer() {
		return new ArrayList<Registrering>(registreringer);
	}

	public Registrering createRegistrering(LocalDateTime ankomst, LocalDateTime afrejse) {
		Registrering registrering = new Registrering(ankomst, afrejse);
		registrering.setKonference(this);
		this.registreringer.add(registrering);
		return registrering;
	}
	
	
	public void removeRegistrering(Registrering registrering) {
		if (this.registreringer.contains(registrering)) {
			this.registreringer.remove(registrering);
			registrering.setKonference(null);
		}
	}

	public String toString() {
		return this.navn;
	}
	
	
	
	
}
