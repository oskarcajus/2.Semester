package Lektion_8.forsikring;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class BilForsikringTest {
	
	//init
	private BilForsikring bf;
	private int grundPræmie;
	
	
	@BeforeEach
	public void setup() {
		grundPræmie = 1000;
		bf = new BilForsikring();
		bf.setGrundpaemie(grundPræmie);
	}

	@Test
	@Order(1)
	void TC_1_testBeregnPraemie_mand_18_0() {
		double præmie = bf.beregnPraemie(18, false, 0);
		
		assertEquals(præmie, 1250);
	}
	
	@Test
	@Order(2)
	void TC_2_testBeregnPraemie_kvinde_18_0() {
		double præmie = bf.beregnPraemie(18, true, 0);
		
		assertEquals(præmie, 1187.5);
	}
	
	@Test
	@Order(3)
	void TC_3_testBeregnPraemie_mand_30_3() {
		double præmie = bf.beregnPraemie(30, false, 3);
		
		assertEquals(præmie, 850);
	}
	
	@Test
	@Order(4)
	void TC_4_testBeregnPraemie_mand_30_5() {
		double præmie = bf.beregnPraemie(30, false, 5);
		
		assertEquals(præmie, 850);
	}
	
	@Test
	@Order(5)
	void TC_5_testBeregnPraemie_mand_30_6() {
		double præmie = bf.beregnPraemie(30, false, 6);
		
		assertEquals(præmie, 750);
	}
	
	@Test
	@Order(6)
	void TC_6_testBeregnPraemie_mand_30_8() {
		double præmie = bf.beregnPraemie(30, false, 8);
		
		assertEquals(præmie, 750);
	}
	
	@Test
	@Order(7)
	void TC_7_testBeregnPraemie_mand_30_9() {
		double præmie = bf.beregnPraemie(30, false, 9);
		
		assertEquals(præmie, 650);
	}
	
	@Test
	@Order(8)
	void TC_8_testBeregnPraemie_mand_17_0() throws RuntimeException {
		assertThrows(RuntimeException.class, () -> bf.beregnPraemie(17, false, 0));
		
	}
	
	@Test
	@Order(9)
	void TC_9_testBeregnPraemie_kvinde_26_7() {
		double præmie = bf.beregnPraemie(26, true, 7);
		System.out.println(præmie);
		
		assertEquals(præmie, 712.5);
		
	}
	
	@Test
	@Order(10)
	void TC_10_testBeregnPraemie_mand_20_3() {
		assertThrows(RuntimeException.class, () -> bf.beregnPraemie(20, false, 3));
	}
	

}
