package KAS.model;

import java.util.ArrayList;

public class Hotel {
	private String name;
	private String adresse;
	private double prisEnkeltVærelse;
	private double prisDobbeltVærelse;

	// Komposition-link til Facilitet
	private ArrayList<Facilitet> faciliteter = new ArrayList<Facilitet>();

	// Associering-link til Registrering
	private ArrayList<Registrering> registreringer = new ArrayList<Registrering>();

	// Mange-mange associering til konference
	private ArrayList<Konference> konferencer = new ArrayList<Konference>();

	public Hotel(String name, String adresse, double prisEnkeltVærelse, double prisDobbeltVærelse) {
		this.name = name;
		this.adresse = adresse;
		this.prisEnkeltVærelse = prisEnkeltVærelse;
		this.prisDobbeltVærelse = prisDobbeltVærelse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public double getPrisEnkeltVærelse() {
		return prisEnkeltVærelse;
	}

	public void setPrisEnkeltVærelse(double prisEnkeltVærelse) {
		this.prisEnkeltVærelse = prisEnkeltVærelse;
	}

	public double getPrisDobbeltVærelse() {
		return prisDobbeltVærelse;
	}

	public void setPrisDobbeltVærelse(double prisDobbeltVærelse) {
		this.prisDobbeltVærelse = prisDobbeltVærelse;
	}

	// Facilitet -------------------------------------
	public ArrayList<Facilitet> getFaciliteter() {
		return new ArrayList<Facilitet>(faciliteter);
	}

	public Facilitet createFacilitet(String name, double pris) {
		Facilitet facilitet = new Facilitet(name, pris);
		this.faciliteter.add(facilitet);
		return facilitet;
	}

	public void removeFacilitet(Facilitet facilitet) {
		if (this.faciliteter.contains(facilitet)) {
			this.faciliteter.remove(facilitet);
		}
	}

	// Konference ------------------------------------
	public ArrayList<Konference> getKonferencer() {
		return new ArrayList<Konference>(konferencer);
	}

	public Konference addKonference(Konference konference) {
		if (!this.konferencer.contains(konference)) {
			this.konferencer.add(konference);
			konference.addHotel(this);
		}
		return konference;
	}

	public void removeKonference(Konference konference) {
		if (this.konferencer.contains(konference)) {
			this.konferencer.remove(konference);
			konference.removeHotel(this);
		}
	}

	// Registering ----------------------------------------------
	public ArrayList<Registrering> getRegistreringer() {
		return new ArrayList<Registrering>(registreringer);
	}

	public Registrering addRegistrering(Registrering registrering) {
		if (!this.registreringer.contains(registrering)) {
			this.registreringer.add(registrering);
			registrering.setHotel(this);
		}
		return registrering;
	}

	public void removeRegistrering(Registrering registrering) {
		if (this.registreringer.contains(registrering)) {
			this.registreringer.remove(registrering);
			registrering.setHotel(null);
		}
	}

	public String toString() {
		return this.name;
	}

}
