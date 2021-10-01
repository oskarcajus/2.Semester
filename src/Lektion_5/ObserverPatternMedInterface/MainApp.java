package Lektion_5.ObserverPatternMedInterface;

public class MainApp {

	public static void main(String[] args) {
		// WeatherStation (Obserserable)
		WeatherStation ws = new WeatherStation();

		// Display (Observers)
		Display d1 = new Display();
		Display d2 = new Display();
		Display d3 = new Display();
		Display d4 = new Display();

		// Add Display(Observer) til WeatherStation(Observable)
		ws.registerObserver(d1);
		ws.registerObserver(d2);
		ws.registerObserver(d3);
		ws.registerObserver(d4);

		// Giv WeatherStation temperatur og airpressure
		// setTempAndAP kalder samtidigt display.update() på Display objekterne
		ws.setTempAndAP(23, 112);

		System.out.println("Temperaturen hos WeatherStation er: " + ws.getTemp());
		System.out.println("AirPressure hos WeatherStation er: " + ws.getAP());
		System.out.println("---------------------");

		// Print alle displays
		System.out.println("Temperatur og AirPressure for displays er nu:");
		for (int i = 0; i < ws.getObservers().size(); i++) {
			System.out.println("Display " + (i + 1) + ":");
			System.out.println("Temperature: " + ((Display) ws.getObservers().get(i)).getTemperature());
			System.out.println("AirPressure: " + ((Display) ws.getObservers().get(i)).getAirPressure());
			System.out.println("--");
		}

		System.out.println();
		System.out.println("-----------------------------------------");

		// Opdater WeatherStation med ny temperatur og airpressure
		// setTempAndAP kalder samtidigt display.update() på Display objekterne
		ws.setTempAndAP(55, 400);

		System.out.println("Temperaturen hos WeatherStation er: " + ws.getTemp());
		System.out.println("AirPressure hos WeatherStation er: " + ws.getAP());
		System.out.println("---------------------");

		// Print alle displays
		System.out.println("Temperatur og AirPressure for displays er nu:");
		for (int i = 0; i < ws.getObservers().size(); i++) {
			System.out.println("Display " + (i + 1) + ":");
			System.out.println("Temperature: " + ((Display) ws.getObservers().get(i)).getTemperature());
			System.out.println("AirPressure: " + ((Display) ws.getObservers().get(i)).getAirPressure());
			System.out.println("--");
		}

	}

}
