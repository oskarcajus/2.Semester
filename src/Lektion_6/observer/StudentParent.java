package Lektion_6.observer;

public class StudentParent implements Observer
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
	public void update() {
		numberOfChildren--;
		
	}
}
