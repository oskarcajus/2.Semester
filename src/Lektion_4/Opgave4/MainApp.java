package Lektion_4.Opgave4;

import java.util.ArrayList;
import java.util.HashMap;

public class MainApp {

	public static void main(String[] args) {
		HashMap<String, Integer> hs = new HashMap<String, Integer>();
		hs.put("Harry Potter og de vises sten", 7);
		hs.put("Harry Potter og de vises sten", 4);
		hs.put("Min Søsters børn i Afrika", 5);
		hs.put("Harry Potter og de vises sten", 1);
		hs.put("Løvernes konge", 2);
		hs.put("Junglebogen", 3);
		
		
		HashMap<String, ArrayList<Integer>> samlet = new HashMap<String, ArrayList<Integer>>();	
		
		String previous = "";
		//Resultaterne skal over i et nyt hashmap -->
		
		for (String key : hs.keySet()) {
			int count = 0;
			int sum = 0;
			if (key.equals(previous)) {
				count++;
				sum += hs.get(key);
			}
			else {
				key = previous;
				count = 1;
				sum = hs.get(key);
			}
			
		}
		
		
	}
	
	

}
