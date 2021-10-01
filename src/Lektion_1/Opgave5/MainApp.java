package Lektion_1.Opgave5;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int sfd(int a, int b) {
		if (b <= a && b % a == 0) {
			return a;
		}
		else if (a < b) {
			return sfd(b, a);
		}
		else {
			return sfd(b, a % b);
		}
	}

}