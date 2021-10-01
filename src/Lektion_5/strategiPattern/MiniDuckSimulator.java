package Lektion_5.strategiPattern;

public class MiniDuckSimulator {
	public static void main(String[] args) {
//		Duck mallard = new MallardDuck();
//		mallard.performQack();
//		mallard.performFly();
		
		Duck model = new ModelDuck();
		model.performFly();
		model.setFlyBehaviour(new FlyRocketPowered());
		model.performFly();
	}
}
