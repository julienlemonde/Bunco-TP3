package TestsUnitaires;

import static org.junit.Assert.*;

import org.junit.*;

import Framework.De;

public class TestDe {
	private De deTestNumero1;
	private De deTestNumero2;
	private De deInvalideTest;
	
	@Before
	public void creationDesDes(){
		deTestNumero1 = new De(6);
		deTestNumero2 = new De(6);
	}
	@Test
	public void deDifferenceTest(){
		while(deTestNumero1.GetFaceDessus() != 3){
			deTestNumero1.brasser();
		}
		while(deTestNumero2.GetFaceDessus() != 6){
			deTestNumero2.brasser();
		}
		assertTrue(deTestNumero1.compareTo(deTestNumero2)== 3);
		assertTrue(deTestNumero2.compareTo(deTestNumero1)== 3);
	}
	@Test
	public void deEgaleTest(){
		while(deTestNumero1.GetFaceDessus() != deTestNumero1.GetFaceDessus()){
			deTestNumero1.brasser();
		}
		assertTrue(deTestNumero1.compareTo(deTestNumero2)== 0);
		assertTrue(deTestNumero1.faceDuDessusEgaleA(deTestNumero2.GetFaceDessus()));
	}
	@Test(expected=IllegalArgumentException.class)
	public void deNullTest(){
		deTestNumero1.brasser();
		deTestNumero1.compareTo(null);
		deInvalideTest = new De(-5);
		deInvalideTest.brasser();
		assertTrue(deInvalideTest.faceDuDessusEgaleA(1));
	}
	@Test
	public void resultatDuBrassageValide(){
		boolean deEstValide = true;
		int i = 1000;
		while(i > 0){
			deTestNumero1.brasser();
			if(deTestNumero1.GetFaceDessus() > 6 || deTestNumero1.GetFaceDessus() < 1){
				deEstValide = false;
				assertTrue(deEstValide);
			}
			i--;
		}
	}
	
	
}
