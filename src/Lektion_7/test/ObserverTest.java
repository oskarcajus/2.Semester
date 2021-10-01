package Lektion_7.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import observer.JungleVulture;
import observer.StudentParent;
import strategy.AcademicStudent;
import strategy.AcademicStudentException;
import strategy.JungleCannibal;
import strategy.JungleCannibalException;
import strategy.ModulusGun;

@TestMethodOrder(OrderAnnotation.class)
class ObserverTest
{
    private AcademicStudent student1;
    private AcademicStudent student2;
    private JungleCannibal cannibal;

    private StudentParent parent;
    private JungleVulture vulture;

    @BeforeEach
    void setUp() throws Exception
    {
        // --------------------------------------------------
        // ARRANGE
        // --------------------------------------------------

        this.student1 = new AcademicStudent("Store Klaus", 100);
        this.student2 = new AcademicStudent("Lille Klaus", 50);
        this.cannibal = new JungleCannibal(50);

        this.parent = new StudentParent();
        this.vulture = new JungleVulture();
    }

    @Test
    @Order(1)
    void test_studentParent_isObserving() throws AcademicStudentException, JungleCannibalException
    {
        // --------------------------------------------------
        // ARRANGE
        // --------------------------------------------------

        student1.setParent(parent);
        student2.setParent(parent);

        student1.registerObserver(parent);
        student2.registerObserver(parent);

        int expectedNumberOfChildren = 2;

        assertEquals(expectedNumberOfChildren, parent.getNumberOfChildren());

        // --------------------------------------------------
        // ACT & ASSERT (Student 1)
        // --------------------------------------------------

        while (student1.getHealth() > 0)
        {
            cannibal.biteStudent(student1);
        }
        expectedNumberOfChildren--;

        assertEquals(expectedNumberOfChildren, parent.getNumberOfChildren());

        // --------------------------------------------------
        // ACT & ASSERT (Student 2)
        // --------------------------------------------------

        while (student2.getHealth() > 0)
        {
            cannibal.biteStudent(student2);
        }
        expectedNumberOfChildren--;

        assertEquals(expectedNumberOfChildren, parent.getNumberOfChildren());
    }

    @Test
    @Order(2)
    void test_jungleVulture_isObserving() throws AcademicStudentException, JungleCannibalException
    {
        // --------------------------------------------------
        // ARRANGE
        // --------------------------------------------------

        // student1.registerObserver(vulture);
        // student2.registerObserver(vulture);
        // cannibal.registerObserver(vulture);

        student2.setWeapon(new ModulusGun());

        int expectedNumberOfMeals = 0;

        assertEquals(expectedNumberOfMeals, vulture.getNumberOfMeals());

        // --------------------------------------------------
        // ACT & ASSERT (Student)
        // --------------------------------------------------

        while (student1.getHealth() > 0)
        {
            cannibal.biteStudent(student1);
        }
        expectedNumberOfMeals++;

        assertEquals(expectedNumberOfMeals, vulture.getNumberOfMeals());

        // --------------------------------------------------
        // ACT & ASSERT (Cannibal)
        // --------------------------------------------------

        while (cannibal.getHealth() > 0)
        {
            student2.useWeapon(cannibal);
        }
        expectedNumberOfMeals++;

        assertEquals(expectedNumberOfMeals, vulture.getNumberOfMeals());
    }
}
