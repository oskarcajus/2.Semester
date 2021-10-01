package Lektion_7.strategy;

import java.util.HashSet;

import observer.ObserverI;
import observer.StudentParent;
import observer.SubjectI;

public class AcademicStudent implements SubjectI
{
    private String name;
    private int health;
    private StudentParent parent;
    private WeaponI weapon;

    private HashSet<ObserverI> observers;

    public AcademicStudent(String name, int health)
    {
        this.name = name;
        this.health = health;
        this.observers = new HashSet<ObserverI>();
    }

    public int getHealth()
    {
        return health;
    }

    public void setParent(StudentParent parent)
    {
        this.parent = parent;

        parent.raiseNumberOfChildren();
    }

    public StudentParent getParent()
    {
        return parent;
    }

    public void setWeapon(WeaponI weapon)
    {
        this.weapon = weapon;
    }

    public void useWeapon(JungleCannibalComponent enemy) throws JungleCannibalException
    {
        weapon.dealDamageTo(enemy);
    }

    public void bite(int healthDamage) throws AcademicStudentException
    {
        if (health <= 0)
        {
            throw new AcademicStudentException("This student was eaten (bone leftovers can be eaten by vultures)");
        }
        else
        {
            this.health -= healthDamage;
            notifyObservers();
        }
    }

    public void registerObserver(ObserverI observer)
    {
        observers.add(observer);
    }

    public ObserverI removeObserver(ObserverI observer)
    {
        if (observers.remove(observer))
        {
            return observer;
        }
        return null;
    }

    public void notifyObservers()
    {
        for (ObserverI observer : observers)
        {
            observer.update(this);
        }
    }

    @Override
    public String toString()
    {
        return name + " (health: " + health + ")";
    }
}
