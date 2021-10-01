package Lektion_5.ObserverPatternMedInterface;

public class Display implements Observer {
	
	private double temperature;
	private double airPressure;
	
	public Display() {}
	
	public void update(double temp, double ap) {
		this.temperature = temp;
		this.airPressure = ap;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getAirPressure() {
		return airPressure;
	}

	public void setAirPressure(double airPressure) {
		this.airPressure = airPressure;
	}


}
