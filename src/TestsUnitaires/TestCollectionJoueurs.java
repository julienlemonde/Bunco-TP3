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
	
	/**
	 * Creation du jeu afin de le tester
	 * Initialition des variables
	 * On test avec 2 joueurs et on donne un pointage de 100 et 200
	 */
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
	/**
	 * Test pour verifier qu'il y a bel et bien 2 joueurs dans la collection
	 */
	@Test
	public void nombreDeJoueursDansCollectionTest(){
		assertTrue(collectionTest.getNombreDeJoueurDansLaCollection() == 2);
	}
	/**
	 * Test pour verifier que le classement fonctionne de la bonne facon.
	 * Celui avec le plus de point en premier
	 */
	@Test
	public void leaderboardTest(){
		CollectionJoueurs leaderboard = collectionTest.getLeaderBoard();
		IterateurJoueur leaderboardIterateur =leaderboard.creerIterateur();
		assertTrue(leaderboardIterateur.GetJoueurActuelle().aPlusDePointQue(leaderboardIterateur.next()));
	}
	/**
	 * Test pour verifier un ajout d'un joueur vide
	 * @throws IllegalArgumentException quand le joueur n'est pas valide
	 */
	@Test(expected=IllegalArgumentException.class)
	public void joueurInvalideTest(){
		collectionTest.ajouterJoueur(joueurInvalide);
	}
}
