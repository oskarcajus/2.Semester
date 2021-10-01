package Lektion_5.strategiPattern;

public class MainApp {

	public static void main(String[] args) {
		Duck d1 = new ModelDuck();
		
		d1.flyBehaviour.fly();
		
		Duck d2 = new MallardDuck();
		
		d2.flyBehaviour.fly();
		
		d2.setFlyBehaviour(new FlyNoWay());
		
		d2.flyBehaviour.fly();
	}
}
