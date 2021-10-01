package Lektion_6.strategy;

public class LethalVirus implements Weapon {
	
	private int virusDamage;
	
	public LethalVirus()
    {
        this.virusDamage = 10;
    }

    public int getVirusDamage()
    {
        return virusDamage;
    }

	@Override
	public void dealDamage(JungleCannibal enemy) throws JungleCannibalException {
		enemy.dealDamage(virusDamage);
		
	}
}
