package TestsUnitaires;

import Bunco.JeuBunco;

import static org.junit.Assert.*;

import org.junit.*;

public class TestJeu {
	private JeuBunco jeuTest;
	
	@Before
	public void creationDuJeu(){
		jeuTest = new JeuBunco(5);
	}
	@Test
	public void test2(){
	}
}
