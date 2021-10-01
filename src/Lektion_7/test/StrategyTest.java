package Lektion_7.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import adapter.Hunger;
import strategy.AcademicStudent;
import strategy.AcademicStudentException;
import strategy.HungerAsWeaponAdapter;
import strategy.JungleCannibal;
import strategy.JungleCannibalComponent;
import strategy.JungleCannibalException;
import strategy.LethalVirus;
import strategy.ModulusGun;
import strategy.MusketerCannibal;
import strategy.PencilSharpener;

@TestMethodOrder(OrderAnnotation.class)
class StrategyTest
{
    private AcademicStudent student1;
    private AcademicStudent student2;
    private JungleCannibal cannibal;
    private JungleCannibal cannibal2;
    private JungleCannibal cannibal3;
    private JungleCannibal cannibal4;
    private JungleCannibal cannibal5;
    private JungleCannibal cannibal6;
    private JungleCannibal cannibal7;
    private MusketerCannibal musketerCannibal;
    private MusketerCannibal mc2;
    
    private ArrayList<JungleCannibalComponent> jcList = new ArrayList<>();
    private ArrayList<JungleCannibalComponent> jcList2 = new ArrayList<>();

    @BeforeEach
    void setUp() throws Exception
    {
        // --------------------------------------------------
        // ARRANGE
        // --------------------------------------------------

        this.student1 = new AcademicStudent("Store Klaus", 100);
        this.student2 = new AcademicStudent("Lille Klaus", 50);
        this.cannibal = new JungleCannibal(100);
        this.cannibal2 = new JungleCannibal(100);
        this.cannibal3 = new JungleCannibal(100);
        this.cannibal4 = new JungleCannibal(100);
        this.cannibal5 = new JungleCannibal(100);
        this.cannibal6 = new JungleCannibal(100);
        this.cannibal7 = new JungleCannibal(100);
        
        jcList.add(cannibal2);
        jcList.add(cannibal3);
        jcList.add(cannibal4);
        
        this.musketerCannibal = new MusketerCannibal(jcList);
        
        jcList2.add(musketerCannibal);
        jcList2.add(cannibal6);
        jcList2.add(cannibal7);
        
        
        this.mc2 = new MusketerCannibal(jcList2);
        
        
    }

//    @Test
//    @Order(1)
//    void test_jungleCannibal_canBiteStudent() throws AcademicStudentException, JungleCannibalException
//    {
//        // --------------------------------------------------
//        // ACT & ASSERT (Student 1)
//        // --------------------------------------------------
//
//        int expectedHealth = 100;
//
//        while (expectedHealth > 0)
//        {
//            cannibal.biteStudent(student1);
//
//            expectedHealth = expectedHealth - 5;
//
//            assertEquals(expectedHealth, student1.getHealth());
//        }
//        assertThrows(AcademicStudentException.class, () -> {
//            cannibal.biteStudent(student1);
//        });
//
//        // --------------------------------------------------
//        // ACT & ASSERT (Student 2)
//        // --------------------------------------------------
//
//        expectedHealth = 50;
//
//        while (expectedHealth > 0)
//        {
//            cannibal.biteStudent(student2);
//
//            expectedHealth = expectedHealth - 5;
//
//            assertEquals(expectedHealth, student2.getHealth());
//        }
//        assertThrows(AcademicStudentException.class, () -> {
//            cannibal.biteStudent(student2);
//        });
//    }
//
//    @Test
//    @Order(2)
//    void test_academicStudent_canUseWeapon_lethalVirus() throws JungleCannibalException
//    {
//        // --------------------------------------------------
//        // ARRANGE
//        // --------------------------------------------------
//
//        LethalVirus virus = new LethalVirus();
//
//        student1.setWeapon(virus);
//
//        // --------------------------------------------------
//        // ACT & ASSERT
//        // --------------------------------------------------
//
//        int expectedHealth = 50;
//
//        while (expectedHealth > 0)
//        {
//            student1.useWeapon(cannibal);
//
//            expectedHealth = expectedHealth - 10;
//
//            assertEquals(expectedHealth, cannibal.getHealth());
//        }
//        assertThrows(JungleCannibalException.class, () -> {
//            student1.useWeapon(cannibal);
//        });
//    }
//
//    @Test
//    @Order(3)
//    void test_academicStudent_canUseWeapon_modulusGun() throws JungleCannibalException
//    {
//        // --------------------------------------------------
//        // ARRANGE
//        // --------------------------------------------------
//
//        ModulusGun gun = new ModulusGun();
//
//        student1.setWeapon(gun);
//
//        // --------------------------------------------------
//        // ACT & ASSERT
//        // --------------------------------------------------
//
//        int expectedHealth = 50;
//
//        while (expectedHealth > 0)
//        {
//            student1.useWeapon(cannibal);
//
//            expectedHealth = expectedHealth - 5;
//
//            assertEquals(expectedHealth, cannibal.getHealth());
//        }
//        assertThrows(JungleCannibalException.class, () -> {
//            student1.useWeapon(cannibal);
//        });
//    }
//
//    @Test
//    @Order(4)
//    void test_academicStudent_canUseWeapon_pencilSharpener() throws JungleCannibalException
//    {
//        // --------------------------------------------------
//        // ARRANGE
//        // --------------------------------------------------
//
//        PencilSharpener sharpener = new PencilSharpener();
//
//        student1.setWeapon(sharpener);
//
//        // --------------------------------------------------
//        // ACT & ASSERT
//        // --------------------------------------------------
//
//        int expectedHealth = 50;
//
//        while (expectedHealth > 0)
//        {
//            student1.useWeapon(cannibal);
//
//            expectedHealth = expectedHealth - 1;
//
//            assertEquals(expectedHealth, cannibal.getHealth());
//        }
//        assertThrows(JungleCannibalException.class, () -> {
//            student1.useWeapon(cannibal);
//        });
//    }
//    
    @Test
    @Order(1)
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

        int expectedHealth = musketerCannibal.getHealth();

        while (expectedHealth > 100)
        {
            student1.useWeapon((JungleCannibalComponent) musketerCannibal);
            expectedHealth = expectedHealth - 30;

            assertEquals(expectedHealth, musketerCannibal.getHealth());
        }
//        assertThrows(JungleCannibalException.class, () -> {
//            student1.useWeapon((JungleCannibalComponent) musketerCannibal);
//        });
//        System.out.println(cannibal.getHealth());
    }
    
    @Test
    @Order(7)
    void test_academicStudent_canUseWeapon_lethalVirus_onmusketeers() throws JungleCannibalException
    {
        // --------------------------------------------------
        // ARRANGE
        // --------------------------------------------------
    	LethalVirus virus = new LethalVirus();

        student1.setWeapon(virus);

        // --------------------------------------------------
        // ACT & ASSERT
        // --------------------------------------------------

        int actualHealth = mc2.getHealth();
        int expectedHealth = 500;
        
        assertEquals(expectedHealth, actualHealth);
        
        while (expectedHealth > 50)
        {
            student1.useWeapon((JungleCannibalComponent) mc2);
            expectedHealth = expectedHealth - 50;

            assertEquals(expectedHealth, mc2.getHealth());
        }
    }
    
//    @Test
//  @Order(2)
//  void test_jungleCannibal_canBiteStudent() throws AcademicStudentException, JungleCannibalException
//  {
//      // --------------------------------------------------
//      // ACT & ASSERT (Student 1)
//      // --------------------------------------------------
//
//      int expectedHealth = 100;
//
//      while (expectedHealth > 50)
//      {
//          musketerCannibal.biteStudent(student1);
//
//          expectedHealth = expectedHealth - 15;
//          
//          assertEquals(expectedHealth, student1.getHealth());
//          System.out.println(student1.getHealth());
//      }
//      assertThrows(AcademicStudentException.class, () -> {
//          cannibal.biteStudent(student1);
//      });
      

      // --------------------------------------------------
      // ACT & ASSERT (Student 2)
      // --------------------------------------------------

//      expectedHealth = 50;
//
//      while (expectedHealth > 0)
//      {
//    	  musketerCannibal.biteStudent(student2);
//
//          expectedHealth = expectedHealth - 15;
//
//          assertEquals(expectedHealth, student2.getHealth());
//          System.out.println(student2.getHealth());
//      }
//      assertThrows(AcademicStudentException.class, () -> {
//          cannibal.biteStudent(student2);
//      });
//  }
}
