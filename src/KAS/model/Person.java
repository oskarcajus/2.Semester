package KAS.model;

public abstract class Person {
	private String navn;
	private String adresse;
	private int alder;
	private String tlfNr;
	private boolean erMand;
	
	
	public Person(String navn, String adresse, int alder, String tlfNr, boolean erMand) {
		this.navn = navn;
		this.alder = alder;
		this.adresse = adresse;
		this.tlfNr = tlfNr;
		this.erMand = erMand;
	}

	public String getNavn() {
		return this.getNavn();
	}
	
	public void setNavn(String navn) {
		this.navn = navn;
	}
	public int getAlder() {
		return this.getAlder();
	}
	
	public void setAlder(int alder) {
		this.alder = alder;
	}	
	
	public String getAdresse() {
		return this.getAdresse();
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}	
	
	public String getTlfNr() {
		return this.getTlfNr();
	}
	
	public void setTlfNr(String tlfNr) {
		this.tlfNr = tlfNr;
	}	
	
	public boolean isErMand() {
		return this.isErMand();
	}
	
	public void setName(boolean erMand) {
		this.erMand = erMand;
	}
	
	
	
}
