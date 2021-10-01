package Lektion_6.strategy;

public class ModulusGun implements Weapon {
	
	public int modulusDamage;

	    public ModulusGun()
	    {
	        this.modulusDamage = 5;
	    }

	    public int getModulusDamage()
	    {
	        return modulusDamage;
	    }

		@Override
		public void dealDamage(JungleCannibal enemy) throws JungleCannibalException {
			enemy.dealDamage(modulusDamage);
			
		}
}
