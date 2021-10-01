package Lektion_6.strategy;

public class PencilSharpener implements Weapon
{
    public int cuttingDamage;

    public PencilSharpener()
    {
        this.cuttingDamage = 1;
    }

    public int getCuttingDamage()
    {
        return cuttingDamage;
    }

	@Override
	public void dealDamage(JungleCannibal enemy) throws JungleCannibalException {
		enemy.dealDamage(cuttingDamage);
		
	}

   
}
