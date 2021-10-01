package Lektion_7.strategy;

public interface WeaponI
{
    void dealDamageTo(JungleCannibalComponent enemy) throws JungleCannibalException;

    int getDamage();
}