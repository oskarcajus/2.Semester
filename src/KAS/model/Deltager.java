package KAS.model;

public class Deltager extends Person {
	
	private boolean erForedragsholder;
	private Firma firma;
	private Ledsager ledsager;
	
	
	
	public Deltager(String navn, String adresse, int alder, String tlfNr, boolean erMand, boolean erForedragsholder) {
		super(navn, adresse, alder, tlfNr, erMand);
		this.erForedragsholder = erForedragsholder;
	}

	
	public boolean getErForedragsholder() {
		return this.erForedragsholder;
	}
	
	public void setErForedragsholder(boolean erForedragsholder) {
		this.erForedragsholder = erForedragsholder;
	}
	
	public void setFirma(Firma firma) {
		this.firma = firma;
	}
	public void setLedsager(Ledsager ledsager) {
		this.ledsager = ledsager;
	}
	public Ledsager getLedsager() {
		return this.ledsager;
	}
	
//	public String toString() {
//		return this.getNavn();
//		
//	}
	
	
	
}
