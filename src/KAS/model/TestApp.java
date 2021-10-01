package KAS.model;

import java.time.LocalDateTime;

import controller.Controller;

public class TestApp {

	public static void main(String[] args) {
		
//		Konference k1 = new Konference("Hav og Himmel", "Adresse", 1500.00, LocalDateTime.of(2020, 12, 10, 10, 10), LocalDateTime.of(2020, 12, 13, 10, 10), "En konference om hav og himmel");
//		Udflugt u1 = Controller.createUdflugt(k1, "Byrundtur, Odense", 125, true, LocalDateTime.of(2020, 12, 10, 10, 10), LocalDateTime.of(2020, 12, 10, 10, 10));
//		Udflugt u2 = Controller.createUdflugt(k1, "Egeskov", 75, false, LocalDateTime.of(2020, 12, 10, 10, 10), LocalDateTime.of(2020, 12, 10, 10, 10));
//		Udflugt u3 = Controller.createUdflugt(k1, "Trapholt Museum, Kolding", 200, true, LocalDateTime.of(2020, 12, 10, 10, 10), LocalDateTime.of(2020, 12, 10, 10, 10));
//		
//		Hotel h1 = new Hotel("Den hvide svane", "Adresse", 1050, 1250);
//		Facilitet f1 = h1.createFacilitet("WIFI", 50);
//		
//		Hotel h2 = new Hotel("Høtel Phønix", "Adresse", 700, 800);
//		h2.createFacilitet("Bad", 200);
//		h2.createFacilitet("WIFI", 75);
//		
//		Hotel h3 = new Hotel("Pension Tusindfryd", "Adresse", 500, 600);
//		h3.createFacilitet("Morgenmad", 100);
//		
//		
//		Deltager d1 = new Deltager("Finn madsen", "Adresse", 70, "+4578431481", true, false); //4500 OK
//		Deltager d2 = new Deltager("Niels Petersen", "Adresse", 70, "+4578431481", true, false); //6600
//		Deltager d3 = new Deltager("Peter sommer", "Adresse", 70, "+4578431481", true, false); //7375
//		Deltager d4 = new Deltager("Lone Jensen", "Adresse", 70, "+4578431481", false, true); //2800
//		
//		//Finn
//		Registrering r1 = Controller.createRegistrering(k1, LocalDateTime.of(2020, 12, 10, 10, 10), LocalDateTime.of(2020, 12, 13, 10, 10), d1);
//		System.out.println(r1.samletPris());
//		
//		//Niels
//		Registrering r2 = Controller.createRegistrering(k1, LocalDateTime.of(2020, 12, 10, 10, 10), LocalDateTime.of(2020, 12, 13, 10, 10), d2);
//		r2.setHotel(h1);
//		System.out.println(r2.samletPris());
//		
//		//Peter
//		Registrering r3 = Controller.createRegistrering(k1, LocalDateTime.of(2020, 12, 10, 10, 10), LocalDateTime.of(2020, 12, 13, 10, 10), d3);
//		Ledsager l1 = Controller.createLedsager("Mie Sommer");
//		Controller.addLedsagerToDeltager(l1, d3);
//		Controller.addHotelToRegistrering(r3, h1);
//		Controller.addFacilitetToRegistrering(r3, f1);
//		Controller.addUdflugtToRegistrering(r3, u2);
//		Controller.addUdflugtToRegistrering(r3, u3);
//		System.out.println(r3.samletPris());
//		
//		//Lone
//		Registrering r4 = Controller.createRegistrering(k1, LocalDateTime.of(2020, 12, 10, 10, 10), LocalDateTime.of(2020, 12, 13, 10, 10), d4);
//		Ledsager l2 = Controller.createLedsager("Jan Madsen");
//		Controller.addLedsagerToDeltager(l2, d4);
//		Controller.addHotelToRegistrering(r4, h1);
//		Controller.addFacilitetToRegistrering(r4, f1);
//		Controller.addUdflugtToRegistrering(r4, u1);
//		Controller.addUdflugtToRegistrering(r4, u2);
//		System.out.println(r4.samletPris());
		
	}

}
