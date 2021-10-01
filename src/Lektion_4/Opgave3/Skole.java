package Lektion_4.Opgave3;

import java.util.ArrayList;
import java.util.List;

public class Skole {
	private String navn;
	private List<Studerende> studerende = new ArrayList<Studerende>();
	
	public Skole (String navn) {
		this.navn = navn;
	}
	
	public String getNavn() {
		return this.navn;
	}
	
	public ArrayList<Studerende> getStuderende() {
		return new ArrayList<Studerende>(this.studerende);
	}
	
	public Studerende addStuderende(Studerende studerende) {
		this.studerende.add(studerende);
		return studerende;
	}
	
	
	public Studerende removeStuderende(Studerende studerende) {
		if (this.studerende.contains(studerende)) {
			this.studerende.remove(studerende);
		}
		return studerende;
	}
	
	public double gennemsnit() {
		double karakterGennemsnitSum = 0;
		for (Studerende s : this.studerende) {
			karakterGennemsnitSum += s.gennemsnitKarakter();
			
		}
		return karakterGennemsnitSum / this.studerende.size();
	}
	
	public Studerende findStuderende(int studieNr) {
		for (Studerende s : this.studerende) {
			if (s.getStudieNr() == studieNr) {
				return s;
			}
		}
		return null;
	}
	
	public String toString() {
		return this.navn;
	}
}
