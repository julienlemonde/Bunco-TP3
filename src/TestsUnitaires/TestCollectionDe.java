package TestsUnitaires;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Framework.CollectionDes;
import Framework.De;
import Framework.IterateurDe;

public class TestCollectionDe {
	private CollectionDes collectionTest;
	
	private De DeTest1;
	private De DeTest2;
	private De DeInvalide;
	
	@Before
	public void creationDuJeu(){
		collectionTest = new CollectionDes();
		DeTest1 = new De(6);
		DeTest2 = new De(6);
		collectionTest.ajouterDe(DeTest1);
		collectionTest.ajouterDe(DeTest2);
		collectionTest.ajouterPlusieursDesIdentiques(3, 6);
	}
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
	@Test(expected=IllegalArgumentException.class)
	public void joueurInvalideTest(){
		collectionTest.ajouterDe(DeInvalide);
	}
}
