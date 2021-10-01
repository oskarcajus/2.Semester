package Lektion_1.Opgave1;

public class Main {
	
	public static int factorial(int n) {
		
		if (n == 0) {
			return 1;
		}
		else {
			return n * factorial(n - 1);
		}
		
	}

}
