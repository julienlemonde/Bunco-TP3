package TestsUnitaires;

import Bunco.JeuBunco;

import static org.junit.Assert.*;

import org.junit.*;

public class TestJeu {
	private JeuBunco jeuTest;
	private JeuBunco jeuInvalide;
	
	@Before
	public void creationDuJeu(){
		jeuTest = new JeuBunco(5);
	}
	@Test
	public void nombreDeToursTest(){
		assertTrue(jeuTest.getNombreDeTours() == 6);
	}
	@Test
	public void tourActuelTest(){
		jeuTest.setTourActuel(1);
		for (int i = 1; i <= jeuTest.getNombreDeTours(); i++) {
			assertTrue(jeuTest.getTourActuel() == i);
			jeuTest.setTourActuel(jeuTest.getTourActuel() + 1);
		}
	}
	@Test
	public void jeuInvalideTest(){
		jeuInvalide = new JeuBunco(-5);
		jeuInvalide.DemarrerLeJeu();
	}
}
