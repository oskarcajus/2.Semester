package Lektion_7.observer;

import strategy.AcademicStudent;

public class StudentParent implements ObserverI
{
    private int numberOfChildren;

    public void raiseNumberOfChildren()
    {
        numberOfChildren += 1;
    }

    public int getNumberOfChildren()
    {
        return numberOfChildren;
    }

    @Override
    public String toString()
    {
        return "Parent (children: " + numberOfChildren + ")";
    }

    @Override
    public void update(SubjectI subject)
    {
        if (subject instanceof AcademicStudent)
        {
            int health = ((AcademicStudent) subject).getHealth();
            if (health <= 0)
            {
                numberOfChildren--;
            }
        }
    }

}
