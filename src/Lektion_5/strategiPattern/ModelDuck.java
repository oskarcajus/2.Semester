package Lektion_5.strategiPattern;

public class ModelDuck extends Duck{
	
	public ModelDuck() {
		flyBehaviour = new FlyNoWay();
		
		
	}

	@Override
	public void display() {
		System.out.println("I'm a model Duck");
	}
}
