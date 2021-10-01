package Lektion_7.adapter;

public class Hunger {

	public void starvePerson(Person person) {

		int health = person.getHealth() / 2;

		person.setHealth(health);
	};
}
