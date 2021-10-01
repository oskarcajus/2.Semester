package Lektion_5.strategiPattern;

public abstract class Duck{
	
	FlyBehaviour flyBehaviour;
	QuackBehaviour quackBehaviour;
	
	public Duck() {
		
	}
	
	public abstract void display();
	
	public void performFly() {
		flyBehaviour.fly();
	}
	
	public void performQack() {
		quackBehaviour.quack();
	}
	
	public void swim() {
		System.out.println("all ducks float, even decoys!");
	}
	
	public void setFlyBehaviour(FlyBehaviour fb) {
		flyBehaviour = fb;
	}
	
	public void setQuackBehaviour(QuackBehaviour qb) {
		quackBehaviour = qb;
	}

}
