package Lektion_7.strategy;

import adapter.Hunger;
import adapter.Person;

public class HungerAsWeaponAdapter implements WeaponI {
	private Hunger hunger;
	
	public HungerAsWeaponAdapter(Hunger hunger) {
		this.hunger = hunger;
	}
	
	public Hunger getHunger() {
		return hunger;
	}

	public void setHunger(Hunger hunger) {
		this.hunger = hunger;
	}

	@Override
	public void dealDamageTo(JungleCannibalComponent enemy) throws JungleCannibalException {
		Person p = new Person();
		p.setHealth(((Person) enemy).getHealth());
		hunger.starvePerson(p);
		int healthdiff = ((Person) enemy).getHealth() - p.getHealth();
		
		enemy.dealDamage(healthdiff);
	}

	@Override
	public int getDamage() {
		// TODO Auto-generated method stub
		return -1;
	}

}
