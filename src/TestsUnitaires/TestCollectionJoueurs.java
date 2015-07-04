package TestsUnitaires;

import Framework.CollectionJoueurs;
import Framework.IterateurJoueur;
import Framework.Joueur;

import static org.junit.Assert.*;

import org.junit.*;

public class TestCollectionJoueurs {
	private CollectionJoueurs collectionTest;
	
	private Joueur joueurTest1;
	private Joueur joueurTest2;
	private Joueur joueurInvalide;
	
	@Before
	public void creationDuJeu(){
		collectionTest = new CollectionJoueurs();
		joueurTest1 = new Joueur(1);
		joueurTest2 = new Joueur(2);
		collectionTest.ajouterJoueur(joueurTest1);
		collectionTest.ajouterJoueur(joueurTest2);
		joueurTest1.setPointageDuJoueur(100);
		joueurTest2.setPointageDuJoueur(200);
	}
	@Test
	public void nombreDeJoueursDansCollectionTest(){
		assertTrue(collectionTest.getNombreDeJoueurDansLaCollection() == 2);
	}
	@Test
	public void leaderboardTest(){
		CollectionJoueurs leaderboard = collectionTest.getLeaderBoard();
		IterateurJoueur leaderboardIterateur =leaderboard.creerIterateur();
		assertTrue(leaderboardIterateur.GetJoueurActuelle().aPlusDePointQue(leaderboardIterateur.next()));
	}
	@Test(expected=IllegalArgumentException.class)
	public void joueurInvalideTest(){
		collectionTest.ajouterJoueur(joueurInvalide);
	}
}
