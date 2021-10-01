package KAS.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import model.*;
import storage.Storage;

public class Controller {
//    private Hotel hotel;
//    private Firma firma;
//    private Deltager deltager;
//    private Konference konference;

	public static Hotel createHotel(String navn, String adresse, double prisForEnkeltVærelse,
			double prisForDobbeltVærelse) {
		Hotel hotel = new Hotel(navn, adresse, prisForEnkeltVærelse, prisForDobbeltVærelse);
		Storage.addHotel(hotel);
		return hotel;
	}

	public static Hotel removeHotel(Hotel hotel) {
		Storage.removeHotel(hotel);
		return hotel;
	}

	public static ArrayList<Hotel> getHoteller() {
		return Storage.getHoteller();
	}

	public static Facilitet createFacilitet(Hotel hotel, String navn, double pris) {
		Facilitet facilitet = hotel.createFacilitet(navn, pris);

		return facilitet;
	}

	public static Facilitet removeFacilitet(Hotel hotel, Facilitet facilitet) {
		hotel.removeFacilitet(facilitet);
		return facilitet;
	}

	public static ArrayList<Facilitet> getFaciliteter(Hotel hotel) {
		ArrayList<Facilitet> list = new ArrayList<>();
		for (Facilitet f : hotel.getFaciliteter()) {
			list.add(f);
		}
		return list;
	}

	public static Konference createKonference(String navn, String adresse, double prisPrDag, LocalDateTime startDato,
			LocalDateTime slutDato, String beskrivelse) {
		Konference konference = new Konference(navn, adresse, prisPrDag, startDato, slutDato, beskrivelse);
		Storage.addKonference(konference);
		return konference;
	}

	public static Konference removeKonference(Konference konference) {
		Storage.removeKonference(konference);
		return konference;
	}

	public static ArrayList<Konference> getKonferencer() {
		return Storage.getKonferencer();
	}

	public static Udflugt createUdflugt(Konference konference, String navn, double pris, boolean medFrokost,
			LocalDateTime startDato, LocalDateTime slutDato) {
		Udflugt udflugt = konference.createUdflugt(navn, pris, medFrokost, startDato, slutDato);
		return udflugt;
	}

	public static Udflugt removeUdflugt(Konference konference, Udflugt udflugt) {
		konference.removeUdflugt(udflugt);
		return udflugt;
	}

	public static ArrayList<Udflugt> getUdflugter() {
		ArrayList<Udflugt> list = new ArrayList<>();
		for (Konference k : Storage.getKonferencer()) {
			for (Udflugt u : k.getUdflugter()) {
				list.add(u);
			}
		}
		return list;
	}

	public static Firma createFirma(String navn, String adresse, String tlfNr, ArrayList<Deltager> deltagere) {
		Firma firma = new Firma(navn, adresse, tlfNr, deltagere);
		Storage.addFirma(firma);
		return firma;
	}

	public static Deltager createDeltager(String navn, String adresse, int alder, String tlfNr, boolean erMand,
			boolean erForedragsholder) {
		Deltager deltager = new Deltager(navn, adresse, alder, tlfNr, erMand, erForedragsholder);
		Storage.addDeltager(deltager);
		return deltager;
	}

	public Deltager removeDeltager(Deltager deltager) {
		Storage.removeDeltager(deltager);
		return deltager;
	}

	public static Ledsager createLedsager(String navn) {
		return new Ledsager(navn);
	}

	public static void removeLedsager(Deltager deltager) {
		// removeLedsager(ledsager)
	}

	public static void addDeltagerToFirma(Deltager deltager, Firma firma) {
		firma.addDeltager(deltager);
	}

	public static void removeDeltagerFromFirma(Deltager deltager, Firma firma) {
		if (firma != null) {
			firma.removeDeltager(deltager);
		} else {
			System.out.println("Deltager ikke fundet.");
		}
	}

	public static void addLedsagerToDeltager(Ledsager ledsager, Deltager deltager) {
		deltager.setLedsager(ledsager);
	}

	public static void removeLedsagerFromDeltager(Deltager deltager) {
		if (deltager != null) {
			deltager.setLedsager(null);
		}
	}

	public static Registrering createRegistrering(Konference konference, LocalDateTime ankomst, LocalDateTime afrejse) {
		Registrering registrering = konference.createRegistrering(ankomst, afrejse);
		return registrering;
	}

	public static void addFacilitetToRegistrering(Registrering registrering, Facilitet facilitet) {
		if (!registrering.getFaciliteter().contains(facilitet)) {
			registrering.addFacilitet(facilitet);
		}
	}

	public static void addHotelToRegistrering(Registrering registrering, Hotel hotel) {
		registrering.setHotel(hotel);
	}

	public static void addUdflugtToRegistrering(Registrering registrering, Udflugt udflugt) {
		if (!registrering.getUdflugter().contains(udflugt)) {
			registrering.addUdflugt(udflugt);
		}
	}

	public static void addDeltagerToRegistrering(Registrering registrering, Deltager deltager) {
		registrering.setDeltager(deltager);
	}

	public static void removeRegistrering(Konference konference, Registrering registrering) {
		konference.removeRegistrering(registrering);
	}

	public static void initStorage() {
		Konference k1 = createKonference("Hav og Himmel", "Adresse", 1500.00, LocalDateTime.of(2020, 12, 10, 10, 10),
				LocalDateTime.of(2020, 12, 13, 10, 10), "En konference om hav og himmel");
		Udflugt u1 = createUdflugt(k1, "Byrundtur, Odense", 125, true, LocalDateTime.of(2020, 12, 10, 10, 10),
				LocalDateTime.of(2020, 12, 10, 10, 10));
		Udflugt u2 = createUdflugt(k1, "Egeskov", 75, false, LocalDateTime.of(2020, 12, 10, 10, 10),
				LocalDateTime.of(2020, 12, 10, 10, 10));
		Udflugt u3 = createUdflugt(k1, "Trapholt Museum, Kolding", 200, true, LocalDateTime.of(2020, 12, 10, 10, 10),
				LocalDateTime.of(2020, 12, 10, 10, 10));

		Hotel h1 = createHotel("Den hvide svane", "Adresse", 1050, 1250);
		Facilitet f1 = h1.createFacilitet("WIFI", 50);

		Hotel h2 = createHotel("Høtel Phønix", "Adresse", 700, 800);
		h2.createFacilitet("Bad", 200);
		h2.createFacilitet("WIFI", 75);

		Hotel h3 = createHotel("Pension Tusindfryd", "Adresse", 500, 600);
		h3.createFacilitet("Morgenmad", 100);
	}
}