package Lektion_7.strategy;

import adapter.Person;

public class JungleCannibalToPersonAdapter {
	private JungleCannibal jungleCannibal;
	
	public JungleCannibalToPersonAdapter(JungleCannibal jungleCannibal) {
		this.jungleCannibal = jungleCannibal;
	}
	
	public JungleCannibal getJungleCannibal() {
		return this.jungleCannibal;
	}
	

}
