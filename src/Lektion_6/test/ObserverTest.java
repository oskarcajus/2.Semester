package Lektion_6.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import observer.StudentParent;
import strategy.AcademicStudent;
import strategy.AcademicStudentException;
import strategy.JungleCannibal;
import strategy.JungleCannibalException;

@TestMethodOrder(OrderAnnotation.class)
class ObserverTest
{
    private StudentParent parent;
    private AcademicStudent student1;
    private AcademicStudent student2;
    private JungleCannibal cannibal;

    @BeforeEach
    void setUp() throws Exception
    {
        this.parent = new StudentParent();
        this.student1 = new AcademicStudent("Store Klaus", 100);
        this.student2 = new AcademicStudent("Lille Klaus", 50);
        this.cannibal = new JungleCannibal(50);
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

        // --------------------------------------------------
        // ACT & ASSERT
        // --------------------------------------------------

        assertEquals(2, parent.getNumberOfChildren());

        for (int expected = 100; expected >= 5; expected = expected - 5)
        {
            cannibal.biteStudent(student1);
        }

        assertEquals(1, parent.getNumberOfChildren());

        for (int expected = 50; expected >= 5; expected = expected - 5)
        {
            cannibal.biteStudent(student2);
        }

        assertEquals(0, parent.getNumberOfChildren());
    }
}
