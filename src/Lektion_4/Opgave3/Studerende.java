package Lektion_4.Opgave3;

import java.util.ArrayList;
import java.util.List;

public class Studerende implements Comparable<Studerende> {
	private int studieNr;
	private String navn;
	private List<Integer> karakterer = new ArrayList<Integer>();
	
	public Studerende(int studieNr, String navn, ArrayList<Integer> karakterer) {
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

	public ArrayList<Integer> getKarakter() {
		return new ArrayList<Integer>(karakterer);
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

	@Override
	public int compareTo(Studerende s) {
		int compare = Integer.compare(this.studieNr, s.studieNr);
		return compare;
	}


	
	
	

}
