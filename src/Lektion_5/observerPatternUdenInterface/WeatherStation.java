package Lektion_5.observerPatternUdenInterface;

import java.util.ArrayList;
import java.util.List;

import ObserverPatternMedInterface.Observable;

public class WeatherStation {
	private double temperature;
	private double airPressure;

	private List<Display> displays = new ArrayList<Display>();

	public WeatherStation() {
	}

	public double getTemp() {
		return this.temperature;
	}

	public double getAP() {
		return this.airPressure;
	}

	// Push
	public void setTempAndAP(double temp, double ap) {
		this.temperature = temp;
		this.airPressure = ap;
		for (Display display : this.displays) {
			display.update(this.temperature, this.airPressure);
		}
	}
	
	public void notifyObservers() {
		for (Display display : this.displays) {
			display.update(this.temperature, this.airPressure);
		}
	}

	public ArrayList<Display> getDisplays() {
		return new ArrayList<Display>(this.displays);
	}
	
	public void registerObserver(Display display) {
		if (!this.displays.contains(display)) {
			this.displays.add(display);
		}
	}
	
	public void removeObserver(Display display) {
		if (this.displays.contains(display)) {
			this.displays.remove(display);
		}
	}
	
}
