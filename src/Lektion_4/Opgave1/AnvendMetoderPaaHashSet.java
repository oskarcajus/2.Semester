package Lektion_4.Opgave1;

import java.util.HashSet;

public class AnvendMetoderPaaHashSet {

	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<>();
		
		hs.add(34);
		hs.add(12);
		hs.add(23);
		hs.add(45);
		hs.add(67);
		hs.add(34);
		hs.add(98);
		
		for (Integer i : hs) {
			System.out.print(i + ", ");
		}
		System.out.println();
		
		hs.add(23);
		
		for (Integer i : hs) {
			System.out.print(i + ", ");
		}
		System.out.println();
		
		hs.remove(67);
		
		for (Integer i : hs) {
			System.out.print(i + ", ");
		}
		System.out.println();
		
		System.out.println("Størrelsen på HashSettet: " + hs.size());

	}

}
