package Lektion_1.Opgave2;

public class Main {

	public static int power(int n, int p) {
		if (p == 0) {
			return 1;
		}

		else {
			return n * power(n, p - 1);
		}
	}

	public static int power2(int n, int p) {
		if (p == 0) {
			return 1;
		}

		else {
			if (p % 2 == 1) {
				return n * power2(n, p - 1);
			} else {
				return power2(n * n, p / 2);
			}
		}
	}

}
