package TestsUnitaires;

import static org.junit.Assert.*;

import org.junit.*;

import Framework.De;

public class TestDe {
	private De deTestNumero1;
	private De deTestNumero2;
	private De deInvalideTest;
	
	/**
	 * Creation d'un de afin de le tester
	 * Initialition des variables
	 * On test avec 2 des de 6 faces
	 */
	@Before
	public void creationDesDes(){
		deTestNumero1 = new De(6);
		deTestNumero2 = new De(6);
	}
	/**
	 * Test pour verifier que la methode compareTo des des fonctionnes
	 */
	@Test
	public void deDifferenceTest(){
		//Brasse le de 1 jusqu'a ce qu'on optient 3
		while(deTestNumero1.GetFaceDessus() != 3){
			deTestNumero1.brasser();
		}
		//Brasse le de 2 jusqu'a ce qu'on optient 6
		while(deTestNumero2.GetFaceDessus() != 6){
			deTestNumero2.brasser();
		}
		//Compare avec chaque de et la difference entre les deux doit donner 3
		assertTrue(deTestNumero1.compareTo(deTestNumero2)== 3);
		assertTrue(deTestNumero2.compareTo(deTestNumero1)== 3);
	}
	/**
	 * Test pour verifier que la methode facedudessusEgale fonctionne
	 * Test aussi que la methode compareTo donne zero lorsque le des sont egaux 
	 */
	@Test
	public void deEgaleTest(){
		while(deTestNumero1.GetFaceDessus() != deTestNumero1.GetFaceDessus()){
			deTestNumero1.brasser();
		}
		//Test les deux methodes possibles pour verifier si les des sont egaux
		assertTrue(deTestNumero1.compareTo(deTestNumero2)== 0);
		assertTrue(deTestNumero1.faceDuDessusEgaleA(deTestNumero2.GetFaceDessus()));
	}
	/**
	 * Test pour verifier qu'il n'y a pas d'erreur lorsqu'un de est null ou avec des
	 * valeurs non compris dans le nombre de face
	 */
	@Test(expected=IllegalArgumentException.class)
	public void deNullTest(){
		deTestNumero1.brasser();
		deTestNumero1.compareTo(null);
		deInvalideTest = new De(-5);
		deInvalideTest.brasser();
		assertTrue(deInvalideTest.faceDuDessusEgaleA(1));
	}
	/**
	 * Test pour verifier qu'il n'y a aucune valeur illegal sur 1000 lancés.
	 */
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
