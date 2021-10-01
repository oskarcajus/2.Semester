package Lektion_2.Opgave2;

public class MainApp {

	public static void main(String[] args) {
		
		

	}
	
	public static boolean palindrom(char[] tekst, int left, int right) {
		if (right - left <= 1) {
			return true;
		}
		else if (tekst[left] != tekst[right]) {
			return false;
		}
		return palindrom(tekst, left + 1, right - 1);
	}

}
