package Lektion_6.strategy;

import java.util.ArrayList;
import java.util.List;

import observer.Observable;
import observer.Observer;
import observer.StudentParent;

public class AcademicStudent implements Observable
{
	private String name;
    private int health;
    private StudentParent parent;
    private Weapon weapon;
    private List<Observer> observers = new ArrayList<Observer>();

    public AcademicStudent(String name, int health) {
    	this.health = health;
		this.name = name;
	}

    public int getHealth()
    {
        return health;
    }

    public void bite(int healthDamage) throws AcademicStudentException
    {
    	if (health > 0) {
    		this.health -= healthDamage;
    		
    		if (health <= 0) {
    			notifyObservers();
    			throw new AcademicStudentException("The student named " + name + " does no longer exist");
    		}
    	}
    }

    public void setParent(StudentParent parent)
    {
        this.parent = parent;
        registerObserver(parent);

        parent.raiseNumberOfChildren();
    }

    public StudentParent getParent()
    {
        return parent;
    }

    public void setWeapon(Weapon weapon)
    {
        this.weapon = weapon;
    }

    public void useWeapon(JungleCannibal enemy) throws JungleCannibalException
    {
        this.weapon.dealDamage(enemy);
    }

    @Override
    public String toString()
    {
        return name + " (health: " + health + ")";
    }

	@Override
	public void registerObserver(Observer o) {
		if (!this.observers.contains(o)) {
			this.observers.add(o);
		}
		
	}

	@Override
	public void removeObserver(Observer o) {
		this.observers.remove(o);
		
	}

	@Override
	public void notifyObservers() {
		for (Observer o : this.observers)  {
			o.update();
		}
		
	}
    
    
}
