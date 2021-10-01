package Lektion_4.Opgave3;

import java.util.Comparator;

public class StuderendeComparator implements Comparator<Studerende> {
	
	public StuderendeComparator() {
		//tom
	}
	
	public int compare(Studerende s1, Studerende s2) {
		int compare = s1.getNavn().compareTo(s2.getNavn());
		return compare;
	}

}
