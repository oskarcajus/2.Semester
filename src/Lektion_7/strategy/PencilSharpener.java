package Lektion_7.strategy;

public class PencilSharpener implements WeaponI
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
    public void dealDamageTo(JungleCannibalComponent enemy) throws JungleCannibalException
    {
        enemy.dealDamage(cuttingDamage);
    }

    @Override
    public int getDamage()
    {
        return cuttingDamage;
    }
}
