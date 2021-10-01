package Lektion_7.strategy;

public class LethalVirus implements WeaponI
{
    private int patienceDamage;

    public LethalVirus()
    {
        this.patienceDamage = 10;
    }

    public int getPatienceDamage()
    {
        return patienceDamage;
    }

    @Override
    public void dealDamageTo(JungleCannibalComponent enemy) throws JungleCannibalException
    {
        enemy.dealDamage(patienceDamage);
    }

    @Override
    public int getDamage()
    {
        return patienceDamage;
    }

}
