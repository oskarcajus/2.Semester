package Lektion_6.observer;

import strategy.JungleCannibal;

public class JungleVulture implements Observer
{
    private int numberOfMeals;

    public JungleVulture()
    {
        this.numberOfMeals = 0;
    }

    public int getNumberOfMeals()
    {
        return numberOfMeals;
    }

	@Override
	public void update() {
		numberOfMeals++;
		
	}
    
}
