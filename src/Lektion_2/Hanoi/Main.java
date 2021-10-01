package Lektion_2.Hanoi;

public class Main {

	public static int hanoiFlyt(int n, int start, int end) {
		int træk = 0;

		if (n == 1) {
			return 1;
			
		}

		else {


			// Midterpinden
			int other = 6 - (start + end);

			træk += hanoiFlyt(n - 1, start, other);
			træk++;
			træk += hanoiFlyt(n - 1, other, end);
			
			return træk;
		}

	}

}
