package Lektion_2.Opgave1;

import java.util.ArrayList;

public class MainApp {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
//		System.out.println(ligeTal(list));
		System.out.println(ligeTalRemove(list, 0));
		
	}
	
	public static int ligeTal(ArrayList<Integer> list) {
		
		int antalLigeTal = 0;
		if (list.size() == 0) {
			return antalLigeTal;
		}
		
		else {
			
			if (list.get(0) % 2 == 0) {
				antalLigeTal++;
				list.remove(0);
				return antalLigeTal += ligeTal(list);
			}
			else {
				list.remove(0);
				return ligeTal(list);
			}
			
		}
		
	}
	//Hjælpemetode
	private static int ligeTalHj(ArrayList<Integer> list, int index) {
		
		int antalLigeTal = 0;
		if (index == list.size()) {
			return antalLigeTal;
		}
		
		else {
			
			if (list.get(index) % 2 == 0) {
				antalLigeTal++;
				return antalLigeTal += ligeTalHj(list, index + 1);
			}
			else {
				return ligeTalHj(list, index + 1);
			}
		}
	}
	
	
	private static int ligeTalRemove(ArrayList<Integer> list, int index) {
		return ligeTalHj(list, index);
	}
	
}
