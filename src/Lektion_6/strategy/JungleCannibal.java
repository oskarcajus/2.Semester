package Lektion_6.strategy;

import java.util.ArrayList;
import java.util.List;

import observer.Observable;
import observer.Observer;

public class JungleCannibal implements Observable
{
    private int health;
    private List<Observer> observers = new ArrayList<Observer>();

    public JungleCannibal(int health)
    {
        this.health = health;
    }

    public int getHealth()
    {
        return health;
    }

    public void dealDamage(int healthDamage) throws JungleCannibalException
    {
        if (health > 0)
        {
            this.health -= healthDamage;
            
            if (health <= 0) {
            	notifyObservers();
            }
        }
        else
        {
            throw new JungleCannibalException("This cannibal is dead");
            
        }
    }

    public void biteStudent(AcademicStudent academicStudent) throws AcademicStudentException, JungleCannibalException
    {
        if (health >= 0)
        {
            academicStudent.bite(5);
        }
        else
        {
            throw new JungleCannibalException("This cannibal is dead");
        }
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
		for (Observer o : this.observers) {
			o.update();
		}
		
	}


}
