package Lektion_4.Opgave2_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Skole {
	private String navn;
	private Map<Integer, Studerende> studerende = new HashMap<Integer, Studerende>();
	
	public Skole (String navn) {
		this.navn = navn;
	}
	
	public String getNavn() {
		return this.navn;
	}
	
	public HashMap<Integer, Studerende> getStuderende() {
		return new HashMap<Integer, Studerende>(this.studerende);
	}
	
	public Studerende addStuderende(int studieNr, Studerende studerende) {
		this.studerende.put(studieNr, studerende);
		return studerende;
	}
	
	
	public Studerende removeStuderende(int studieNr) {
		Studerende studRemoved = null;
		if (this.studerende.containsKey(studieNr)) {
			studRemoved = this.studerende.remove(studieNr);
		}
		return studRemoved;
	}
	
	public double gennemsnit() {
		double karakterGennemsnitSum = 0;
		for (Integer key : this.studerende.keySet()) {
			karakterGennemsnitSum += this.studerende.get(key).gennemsnitKarakter();
			
		}
		return karakterGennemsnitSum / this.studerende.size();
	}
	
	public Studerende findStuderende(int studieNr) {
		for (Integer key : this.studerende.keySet()) {
			if (key == studieNr) {
				return this.studerende.get(key);
			}
		}
		return null;
	}
	
	public String toString() {
		return this.navn;
	}
}
