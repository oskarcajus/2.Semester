package Lektion_7.strategy;

public interface JungleCannibalComponent {

	    public void dealDamage(int healthDamage) throws JungleCannibalException;

	    public void biteStudent(AcademicStudent academicStudent) throws AcademicStudentException, JungleCannibalException;

		public int getHealth();

		public int getBiteDamage();
}
