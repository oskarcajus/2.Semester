package Lektion_7.strategy;

import java.util.ArrayList;

public class MusketerCannibal implements JungleCannibalComponent {
	private ArrayList<JungleCannibalComponent> cannibaler = new ArrayList<>();
	
	
	public MusketerCannibal(ArrayList<JungleCannibalComponent> jcList) {
		this.cannibaler = jcList;
		
	}

	public int getHealth() {
		int health = 0;
		for (JungleCannibalComponent jc : this.cannibaler) {
			health += jc.getHealth();
		}
		return health;
	}
	
	public void dealDamage(int healthDamage) throws JungleCannibalException
    {
        if (this.getHealth() <= 0)
        {
            throw new JungleCannibalException("This Musketeercannibal is dead");
        }
        else
        {
            for (JungleCannibalComponent jc : this.cannibaler) {
            	jc.dealDamage(healthDamage);
            }
        }
    }

	@Override
	public void biteStudent(AcademicStudent academicStudent) throws AcademicStudentException, JungleCannibalException
    {
        if (this.getHealth() <= 0)
        {
            throw new JungleCannibalException("This cannibal is dead  (can be eaten by vultures)");
        }
        else
        {
        	for (JungleCannibalComponent jc : this.cannibaler) {
        		academicStudent.bite(jc.getBiteDamage());
        	}
            
        }
    }

	@Override
	public int getBiteDamage() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
