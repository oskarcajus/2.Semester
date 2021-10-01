package Lektion_3.Opgave1;

import java.util.ArrayList;

public class MainApp {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(5);
		list.add(10);
		list.add(7);
		list.add(4);
		
		System.out.println(summerListe(list, 0, 4));

	}
	
	public static int summerListe(ArrayList<Integer> list, int l, int h) {
		
		if (l == h) {
			return list.get(l);
		}
		
		else {
			int m = (l + h) / 2;
			int max1 = summerListe(list, l, m);
			int max2 = summerListe(list, m + 1, h);
			return max1 + max2;
		}
		
		
	}

}
