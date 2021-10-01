package Lektion_4.Opgave2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Studerende {
	private int studieNr;
	private String navn;
	private HashSet<Integer> karakterer = new HashSet<Integer>();
	
	public Studerende(int studieNr, String navn, HashSet<Integer> karakterer) {
		this.studieNr = studieNr;
		this.navn = navn;
		this.karakterer = karakterer;
	}

	public int getStudieNr() {
		return studieNr;
	}

	public void setStudieNr(int studieNr) {
		this.studieNr = studieNr;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public HashSet<Integer> getKarakter() {
		return new HashSet<Integer>(karakterer);
	}
	
	public int sumKarakterer() {
		int sum = 0;
		for (Integer i : this.karakterer) {
			sum += i;
		}
		return sum;
	}
	
	public double gennemsnitKarakter() {
		double gennemsnit = 0;
		gennemsnit = sumKarakterer() / this.karakterer.size();
		
		return gennemsnit;
	}
	
	public int addKarakter(int karakter) {
		this.karakterer.add(karakter);
		return karakter;
	}
	
	public String toString() {
		return this.navn;
	}


	
	
	

}
