package KAS.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Registrering {
	private LocalDateTime ankomst;
	private LocalDateTime afrejse;

	// Komposition-link til konference
	private Konference konference;

	// Association-link til hotel
	private Hotel hotel;

	// Association-link til deltager
	private Deltager deltager;

	// Association-link til facilitet
	private ArrayList<Facilitet> faciliteter = new ArrayList<Facilitet>();

	// Association-link til udflugt
	private ArrayList<Udflugt> udflugter = new ArrayList<Udflugt>();

	public Registrering(LocalDateTime ankomst, LocalDateTime afrejse) {
		this.ankomst = ankomst;
		this.afrejse = afrejse;
	}

	public LocalDateTime getAnkomst() {
		return ankomst;
	}

	public void setAnkomst(LocalDateTime ankomst) {
		this.ankomst = ankomst;
	}

	public LocalDateTime getAfrejse() {
		return afrejse;
	}

	public void setAfrejse(LocalDateTime afrejse) {
		this.afrejse = afrejse;
	}

	public Konference getKonference() {
		return konference;
	}

	public void setKonference(Konference konference) {
		this.konference = konference;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Deltager getDeltager() {
		return deltager;
	}

	public void setDeltager(Deltager deltager) {
		this.deltager = deltager;
	}

	// Faciltet ----------------------------------
	public ArrayList<Facilitet> getFaciliteter() {
		return new ArrayList<Facilitet>(faciliteter);
	}

	public Facilitet addFacilitet(Facilitet facilitet) {
		if (!this.faciliteter.contains(facilitet)) {
			this.faciliteter.add(facilitet);
		}
		return facilitet;
	}

	public void removeFacilitet(Facilitet facilitet) {
		if (this.faciliteter.contains(facilitet)) {
			this.faciliteter.remove(facilitet);
		}
	}

	// Udflugt ---------------------------------------
	public ArrayList<Udflugt> getUdflugter() {
		return new ArrayList<Udflugt>(udflugter);
	}

	public Udflugt addUdflugt(Udflugt udflugt) {
		if (!this.udflugter.contains(udflugt)) {
			this.udflugter.add(udflugt);
			udflugt.addRegistrering(this);
		}
		return udflugt;
	}

	public void removeUdflugt(Udflugt udflugt) {
		if (this.udflugter.contains(udflugt)) {
			this.udflugter.remove(udflugt);
		}
	}

	public Ledsager getLedsager() {
		Ledsager ledsager = null;
		if (this.deltager.getLedsager() != null) {
			ledsager = this.deltager.getLedsager();
		}
		return ledsager;
	}

	public int getAntalDage() {
		int dage = 0;
		dage = (int) ChronoUnit.DAYS.between(ankomst, afrejse);
		return dage;
	}

	public int getAntalOvernatninger() {
		return getAntalDage() - 1;
	}

	// Priser hjælpemetoder --------------------------------------
	public double getPrisUdflugt() {
		double pris = 0;
		if (this.udflugter.size() != 0) {

			for (Udflugt u : udflugter) {
				pris += u.getPris();
			}
		}
		return pris;
	}

	public double getRabatForedragsholder() {
		double rabat = 0;
		if (this.deltager.getErForedragsholder()) {
			rabat = this.konference.getPrisPrDag() * this.getAntalDage();
		}
		return rabat;
	}

	public double getPrisKonference() {
		double pris = 0;
		if (!deltager.getErForedragsholder() && deltager != null) {
			pris = this.konference.getPrisPrDag() * this.getAntalDage();
		} else {
			pris = 0;
		}
		return pris;
	}

	public double getPrisHotel() {
		double pris = 0;

		if (this.hotel != null) {
			if (deltager.getLedsager() != null) {
				pris = hotel.getPrisDobbeltVærelse() * ((double) this.getAntalOvernatninger());
			} else if (deltager.getLedsager() == null) {
				pris = hotel.getPrisEnkeltVærelse() * ((double) this.getAntalOvernatninger());
			}
		}

		return pris;
	}

	public double getPrisFacilitet() {
		double pris = 0;

		if (this.faciliteter != null) {
			for (Facilitet f : faciliteter) {
				pris += f.getPris() * (this.getAntalOvernatninger());
			}
		}

		return pris;
	}

	public double samletPris() {
		double pris = 0;

		double konferencePris = getPrisKonference();
		double udflugtPris = getPrisUdflugt();
		double hotelPris = getPrisHotel();
		double facilitetPris = getPrisFacilitet();

		pris = konferencePris + udflugtPris + hotelPris + facilitetPris;

		return pris;
	}

	public String toString() {
		return this.konference.getNavn();
	}

}
