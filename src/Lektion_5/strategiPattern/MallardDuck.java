package Lektion_5.strategiPattern;

public class MallardDuck extends Duck{
	
	public MallardDuck() {
		flyBehaviour = new FlyRocketPowered();
		
		
	}

	@Override
	public void display() {
		System.out.println("I'm a model Duck");
	}
}
