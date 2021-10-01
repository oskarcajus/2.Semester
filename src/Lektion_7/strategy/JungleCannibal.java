package Lektion_7.strategy;


public class JungleCannibal implements JungleCannibalComponent
{
    private int health;
    private int biteDamage;

    public JungleCannibal(int health)
    {
        this.health = health;
        this.biteDamage = 5;
    }

    public int getHealth()
    {
        return health;
    }
    
    public int getBiteDamage() {
    	return this.biteDamage;
    }

    public void dealDamage(int healthDamage) throws JungleCannibalException
    {
        if (health <= 0)
        {
            throw new JungleCannibalException("This cannibal is dead");
        }
        else
        {
            this.health -= healthDamage;
        }
    }

    public void biteStudent(AcademicStudent academicStudent) throws AcademicStudentException, JungleCannibalException
    {
        if (health <= 0)
        {
            throw new JungleCannibalException("This cannibal is dead  (can be eaten by vultures)");
        }
        else
        {
            academicStudent.bite(biteDamage);
        }
    }

    @Override
    public String toString()
    {
        return "Cannibal (health: " + health + ")";
    }
}
