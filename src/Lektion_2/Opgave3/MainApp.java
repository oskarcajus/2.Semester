package Lektion_2.Opgave3;

import java.util.ArrayList;
import java.util.Collections;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public static int talN(int n) {
		
		Integer[] arrayN = { 2, 1, 5 };
		ArrayList<Integer> listN = new ArrayList<Integer>();
		Collections.addAll(listN, arrayN);
		
		return talN(n, 2, listN);
	}
	
	//Hjælpemetode
	private static int talN(int n, int nLast, ArrayList<Integer> listN) {
		
		if (n <= nLast) {
			return listN.get(n);		
		}
		nLast++;
		
		int N;
		
		if (nLast % 2 == 0) {
			N = 2 * listN.get(nLast - 3) + listN.get(nLast - 1);
		}
		else {
			N = listN.get(nLast - 1) + listN.get(nLast - 2) + (3 * listN.get(nLast - 3));
		}
		listN.add(N);
		
		return talN(n, nLast, listN);
	}

}
