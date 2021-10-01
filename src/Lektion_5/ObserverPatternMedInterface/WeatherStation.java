package Lektion_5.ObserverPatternMedInterface;

import java.util.ArrayList;
import java.util.List;


public class WeatherStation implements Observable {
	private double temperature;
	private double airPressure;

	private List<Observer> observers = new ArrayList<Observer>();

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
		notifyObservers();
	}

	public ArrayList<Observer> getObservers() {
		return new ArrayList<Observer>(this.observers);
	}

	public void registerObserver(Observer observer) {
		if (!this.observers.contains(observer)) {
			this.observers.add(observer);
		}
	}

	public void removeObserver(Observer observer) {
		if (this.observers.contains(observer)) {
			this.observers.remove(observer);
		}
	}
		
	public void notifyObservers() {
		for (Observer observer : this.observers) {
			observer.update(this.temperature, this.airPressure);
		}
		
	}



}
