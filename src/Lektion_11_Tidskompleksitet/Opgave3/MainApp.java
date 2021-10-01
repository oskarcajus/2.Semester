package Lektion_11_Tidskompleksitet.Opgave3;

public class MainApp {

	public static void main(String[] args) {
		int[] inputTal = {5, 10, 5, 6, 4, 9, 8};
		
		
		double[] result = prefixAverage(inputTal);
		
		for (double d : result) {
			System.out.println(d);
		}
	}

	
	public static double[] prefixAverage(int[] inputTal) {
		double[] resultArray = new double[inputTal.length];
		double sum = 0;
		
		for (int i = 0; i < inputTal.length; i++) {
			sum = sum + inputTal[i];
			resultArray[i] = sum / (i + 1);
		}
			
		return resultArray;
		
		
		
	}
}
