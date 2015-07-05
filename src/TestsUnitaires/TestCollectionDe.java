package TestsUnitaires;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Framework.CollectionDes;
import Framework.De;
import Framework.IterateurDe;

public class TestCollectionDe{
	private CollectionDes collectionTest;
	
	private De DeTest1;
	private De DeTest2;
	private De DeInvalide;
	
	/**
	 * Creation de la collection de jeu afin de la tester
	 * Initialition des variables
	 * On test avec 2 des differents et 3 des identiques
	 */
	@Before
	public void creationDuJeu(){
		collectionTest = new CollectionDes();
		DeTest1 = new De(6);
		DeTest2 = new De(6);
		collectionTest.ajouterDe(DeTest1);
		collectionTest.ajouterDe(DeTest2);
		collectionTest.ajouterPlusieursDesIdentiques(3, 6);
	}
	
	/**
	 * Test pour verifier que la collection contient reellement 5 des
	 */
	@Test
	public void nombreDeDesDansCollectionTest(){
		IterateurDe iterateurTestDe = collectionTest.creerIterateur();
		int nbDeDesSupposementACinq = 1;
		while(iterateurTestDe.hasNext()){
			iterateurTestDe.next();
			nbDeDesSupposementACinq++;
		}
		assertTrue(nbDeDesSupposementACinq == 5);
	}
	/**
	 * Test pour verifier un ajout d'un de vide
	 * @throws IllegalArgumentException quand le de n'est pas valide
	 */
	@Test(expected=IllegalArgumentException.class)
	public void deInvalideTest(){
		collectionTest.ajouterDe(DeInvalide);
	}
}
