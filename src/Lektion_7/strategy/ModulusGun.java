package Lektion_7.strategy;

public class ModulusGun implements WeaponI
{
    public int bulletDamage;

    public ModulusGun()
    {
        this.bulletDamage = 5;
    }

    public int getBulletDamage()
    {
        return bulletDamage;
    }

    @Override
    public void dealDamageTo(JungleCannibalComponent enemy) throws JungleCannibalException
    {
        enemy.dealDamage(bulletDamage);
    }

    @Override
    public int getDamage()
    {
        return bulletDamage;
    }

}
