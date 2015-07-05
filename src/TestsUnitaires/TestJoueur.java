package TestsUnitaires;

import static org.junit.Assert.*;

import org.junit.*;

import Framework.Joueur;

public class TestJoueur {
	private Joueur joueurTestNumero1;
	private Joueur joueurTestNumero2;
	private Joueur joueurInvalideTest;
	
	/**
	 * Creation de deux joueurs afin de tester differente methode relative aux joueurs
	 */
	@Before
	public void creationDesJoueurs(){
		joueurTestNumero1 = new Joueur(1);
		joueurTestNumero2 = new Joueur(2);
	}
	/**
	 * Test pour verifier que la methode compareTo fonctionne dans les deux sens.
	 * Verifie aussi que la methode aPlusDePointQue fonctionne correctement
	 */
	@Test
	public void joueurDifferenceTest(){
		joueurTestNumero1.setPointageDuJoueur(75);
		joueurTestNumero2.setPointageDuJoueur(50);
		assertTrue(joueurTestNumero1.compareTo(joueurTestNumero2)== 25);
		assertTrue(joueurTestNumero2.compareTo(joueurTestNumero1)== 25);
		assertTrue(joueurTestNumero1.aPlusDePointQue(joueurTestNumero2));
	}
	/**
	 * Test pour verifier que les methodes nombreDePointEgaleA et compareTo fonctionne
	 * en cas d'egalite entre les joueurs.
	 */
	@Test
	public void JoueurEgaleTest(){
		joueurTestNumero1.setPointageDuJoueur(100);
		joueurTestNumero2.setPointageDuJoueur(100);
		//Test les deux methodes possible pour une egalite
		assertTrue(joueurTestNumero1.compareTo(joueurTestNumero2)== 0);
		assertTrue(joueurTestNumero1.nombreDePointEgaleA(joueurTestNumero2.getNombreDePoints()));
	}
	/**
	 * Test les differentes methodes avec des parametres illegaux afin de
	 * voir comment ils reagissent.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void JoueurNullTest(){
		joueurTestNumero1.setPointageDuJoueur(10);
		joueurTestNumero1.compareTo(null);
		joueurTestNumero1.aPlusDePointQue(null);
		joueurInvalideTest = new Joueur(-1);
		joueurInvalideTest.setPointageDuJoueur(-5);
		joueurInvalideTest.compareTo(joueurTestNumero1);
		assertTrue(joueurInvalideTest.compareTo(joueurTestNumero1)==15);
	}
	
	
}