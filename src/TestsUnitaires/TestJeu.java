package TestsUnitaires;

import Bunco.JeuBunco;

import static org.junit.Assert.*;

import org.junit.*;

public class TestJeu {
	private JeuBunco jeuTest;
	private JeuBunco jeuInvalide;
	
	/**
	 * Creation d'un jeu de type Bunco avec 5 joueurs pour le tester
	 */
	@Before
	public void creationDuJeu(){
		jeuTest = new JeuBunco(5);
	}
	/**
	 * Test pour verifier que le nombre de tour est egal a 6 pour un jeu Bunco
	 */
	@Test
	public void nombreDeToursTest(){
		assertTrue(jeuTest.getNombreDeTours() == 6);
	}
	/**
	 * Test pour verifier le changement de tour pour etre sur qu'il n'y a jamais de probleme
	 */
	@Test
	public void tourActuelTest(){
		jeuTest.setTourActuel(1);
		for (int i = 1; i <= jeuTest.getNombreDeTours(); i++) {
			assertTrue(jeuTest.getTourActuel() == i);
			jeuTest.setTourActuel(jeuTest.getTourActuel() + 1);
		}
	}
	/**
	 * Test de creation de jeu Bunco avec un parametre illegal pour s'assurer que 
	 * le jeu ne plante pas
	 */
	@Test
	public void jeuInvalideTest(){
		jeuInvalide = new JeuBunco(-5);
		jeuInvalide.DemarrerLeJeu();
	}
}
