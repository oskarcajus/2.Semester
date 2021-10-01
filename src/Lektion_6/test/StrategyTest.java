package Lektion_6.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import strategy.AcademicStudent;
import strategy.AcademicStudentException;
import strategy.JungleCannibal;
import strategy.JungleCannibalException;
import strategy.LethalVirus;
import strategy.ModulusGun;
import strategy.PencilSharpener;

@TestMethodOrder(OrderAnnotation.class)
class StrategyTest
{
    private AcademicStudent student1;
    private AcademicStudent student2;
    private JungleCannibal cannibal;

    @BeforeEach
    void setUp() throws Exception
    {
        this.student1 = new AcademicStudent("Store Klaus", 100);
        this.student2 = new AcademicStudent("Lille Klaus", 50);
        this.cannibal = new JungleCannibal(50);
    }

    @Test
    @Order(1)
    void test_jungleCannibal_canBiteStudent() throws AcademicStudentException, JungleCannibalException
    {
        // --------------------------------------------------
        // ACT & ASSERT (Student 1)
        // --------------------------------------------------

        assertEquals(100, student1.getHealth());

        for (int expected = 95; expected >= 5; expected = expected - 5)
        {
            cannibal.biteStudent(student1);

            assertEquals(expected, student1.getHealth());
        }
        assertThrows(AcademicStudentException.class, () -> {
            cannibal.biteStudent(student1);
        });

        // --------------------------------------------------
        // ACT & ASSERT (Student 2)
        // --------------------------------------------------

        assertEquals(50, student2.getHealth());

        for (int expected = 45; expected >= 5; expected = expected - 5)
        {
            cannibal.biteStudent(student2);

            assertEquals(expected, student2.getHealth());
        }
        assertThrows(AcademicStudentException.class, () -> {
            cannibal.biteStudent(student2);
        });
    }

    @Test
    @Order(2)
    void test_academicStudent_canUseWeapon_pencilSharpener() throws JungleCannibalException
    {
        // --------------------------------------------------
        // ARRANGE
        // --------------------------------------------------

        PencilSharpener sharpener = new PencilSharpener();

        student1.setWeapon(sharpener);

        // --------------------------------------------------
        // ACT & ASSERT
        // --------------------------------------------------

        assertEquals(1, sharpener.getCuttingDamage());

        assertEquals(50, cannibal.getHealth());

        for (int expected = 49; expected >= 0; expected--)
        {
            student1.useWeapon(cannibal);

            assertEquals(expected, cannibal.getHealth());
        }
        assertThrows(JungleCannibalException.class, () -> {
            student1.useWeapon(cannibal);
        });
    }
    
    @Test
    @Order(3)
    void test_academicStudent_canUseWeapon_modulusGun() throws JungleCannibalException
    {
        // --------------------------------------------------
        // ARRANGE
        // --------------------------------------------------

        ModulusGun gun = new ModulusGun();

        student1.setWeapon(gun);

        // --------------------------------------------------
        // ACT & ASSERT
        // --------------------------------------------------

        assertEquals(5, gun.getModulusDamage());

        assertEquals(50, cannibal.getHealth());

        for (int expected = 45; expected >= 0; expected = expected - gun.getModulusDamage())
        {
            student1.useWeapon(cannibal);

            assertEquals(expected, cannibal.getHealth());
        }
        assertThrows(JungleCannibalException.class, () -> {
            student1.useWeapon(cannibal);
        });
    }
    
    @Test
    @Order(4)
    void test_academicStudent_canUseWeapon_lethalVirus() throws JungleCannibalException
    {
        // --------------------------------------------------
        // ARRANGE
        // --------------------------------------------------

        LethalVirus virus = new LethalVirus();

        student1.setWeapon(virus);

        // --------------------------------------------------
        // ACT & ASSERT
        // --------------------------------------------------

        assertEquals(10, virus.getVirusDamage());

        assertEquals(50, cannibal.getHealth());

        for (int expected = 40; expected >= 0; expected = expected - virus.getVirusDamage())
        {
            student1.useWeapon(cannibal);

            assertEquals(expected, cannibal.getHealth());
        }
        assertThrows(JungleCannibalException.class, () -> {
            student1.useWeapon(cannibal);
        });
    }

}
