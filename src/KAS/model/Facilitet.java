package KAS.model;

public class Facilitet {

	private String name;
	private double pris;

	public Facilitet(String name, double pris) {
		this.name = name;
		this.pris = pris;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPris() {
		return pris;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}

	public String toString() {
		return this.name;
	}

}
