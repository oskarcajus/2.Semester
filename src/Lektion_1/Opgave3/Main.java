package Lektion_1.Opgave3;

public class Main {
	
	public static int product(int a, int b) {
		if (a == 0) {
			return 0;
		}
		else {
			return product(a - 1, b) + b;
		}
	}
	
}
