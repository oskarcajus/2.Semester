package Lektion_4.Opgave2;

import java.util.HashSet;
import java.util.Random;

public class MainApp {

	public static void main(String[] args) {
		HashSet<Integer> karakter1 = new HashSet<>();
		HashSet<Integer> karakter2 = new HashSet<>();
		HashSet<Integer> karakter3 = new HashSet<>();
		HashSet<Integer> karakter4 = new HashSet<>();
		HashSet<Integer> karakter5 = new HashSet<>();
		
		Random rand = new Random();
		
		for (int i = 0; i < 10; i++) {
			karakter1.add(rand.nextInt(12));
		}
		for (int i = 0; i < 10; i++) {
			karakter2.add(rand.nextInt(12));
		}
		for (int i = 0; i < 10; i++) {
			karakter3.add(rand.nextInt(12));
		}
		for (int i = 0; i < 10; i++) {
			karakter4.add(rand.nextInt(12));
		}
		for (int i = 0; i < 10; i++) {
			karakter5.add(rand.nextInt(12));
		}
		
		
		//SKole
		Skole skole1 = new Skole("Superskolen");
		
		//Studerende
		Studerende student1 = new Studerende(39201, "Oskar", karakter1);
		Studerende student2 = new Studerende(231, "Thomas", karakter2);
		Studerende student3 = new Studerende(15, "Søren", karakter3);
		Studerende student4 = new Studerende(2367, "Hej", karakter4);
		Studerende student5 = new Studerende(39050, "OK", karakter5);
		
		//Add s til skole
		skole1.addStuderende(student1);
		skole1.addStuderende(student2);
		skole1.addStuderende(student3);
		skole1.addStuderende(student4);
		skole1.addStuderende(student5);
		
		System.out.println(skole1.gennemsnit());
		
		System.out.println(skole1.findStuderende(2));
		
		

	}

}
