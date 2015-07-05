package TestsUnitaires;

import static org.junit.Assert.*;
import org.junit.*;

import Bunco.JeuBunco;
import Bunco.StrategieBunco;
import Framework.CollectionJoueurs;
import Framework.IterateurDe;
import Framework.IterateurJoueur;
import Framework.Joueur;

public class TestStrategie {
	private StrategieBunco strategieTest;
	private JeuBunco jeuTest;
	private IterateurDe deTest;
	
	/**
	 * Creation d'une strategieBunco et d'un jeu Bunco a deux joueurs
	 * Obligatoire pour pouvoir tester la strategie
	 */
	@Before
	public void necessairePourTester(){
		strategieTest = new StrategieBunco();
		jeuTest = new JeuBunco(2);
	}
	/**
	 * Test pour verifier que le jeu fonctionne de la bonne facon selon les regles du 
	 * Bunco. Si ce test ne fonctionne pas, le jeu ne fonctionne donc pas de la facon
	 * qu'il faudrait
	 */
	@Test
	public void scoreEtRejouerLancerTest(){
		for (int i = 1; i <= 6; i++) {
			//Preparer le jeu pour le lancement des Des
			deTest = jeuTest.getTousLesDes().creerIterateur();
			jeuTest.setTourActuel(i);
			jeuTest.getTousLesDes().BrasserTousLesDees();
			
			//calculer le score avec un joueur bidon
			Joueur joueurTemp = new Joueur(1);
			boolean rejouerLeTour = this.strategieTest.calculerScoreTour(jeuTest, joueurTemp);
			
			//flags pour la verification
			int scoreCeTour = 0;
			int BuncoCompte = 0;
			boolean bunco = false;
			
			//tableau des resultats
			int[] tableauDesResultat = new int[3];
			//Parcourir tous les des (3)
			for (int j = 0; j < tableauDesResultat.length; j++) {
				tableauDesResultat[j]= deTest.GetDeActuelle().GetFaceDessus();
				deTest.next();
				//verifier si les des egale le numero du tour
				if(tableauDesResultat[j]==i){
					scoreCeTour++;
					BuncoCompte++;
					//si trois Des egale numero du tour  = Bunco!
					if(BuncoCompte == 3){
						bunco = true;
					}
				}
			}
			//si les trois des sont pareilles
			if(tableauDesResultat[0] == tableauDesResultat[1] && tableauDesResultat[1] == tableauDesResultat[2]){
				//si trois pareil mais pas un Bunco
				if(!bunco){
					assertTrue(joueurTemp.getNombreDePoints()== 5 && rejouerLeTour);
				}
				//si un bunco
				else{
					assertTrue(joueurTemp.getNombreDePoints()== 21 && !(rejouerLeTour));
				}
			}
			//si les trois ne sont pas pareil
			else{
				//si au moins un point
				if(scoreCeTour > 0){
					assertTrue(joueurTemp.getNombreDePoints()== scoreCeTour && rejouerLeTour);
				}
				//si aucun point
				else{
					assertTrue(joueurTemp.getNombreDePoints()== 0 && !(rejouerLeTour));
				}
			}
		}
	}
	/**
	 * Test pour verifier que le vainqueur est bel et bien celui qui a le plus de point
	 */
	@Test
	public void vainqueurTest(){
		for (int i = 0; i < 2; i++) {
			Joueur joueurTemp = new Joueur(i);
			joueurTemp.setPointageDuJoueur(100-i);
			this.jeuTest.getTousLesJoueurs().ajouterJoueur(joueurTemp);
		}
		CollectionJoueurs leaderBoard = this.strategieTest.calculerLeVainqueur(jeuTest);
		IterateurJoueur leaderBoardIterateur = leaderBoard.creerIterateur();
		for (int i = 0; i < leaderBoard.getNombreDeJoueurDansLaCollection(); i++) {
			Joueur joueurAcomparer = leaderBoardIterateur.GetJoueurActuelle();
			if(leaderBoardIterateur.hasNext()){
				leaderBoardIterateur.next();
				assertTrue(joueurAcomparer.aPlusDePointQue(leaderBoardIterateur.GetJoueurActuelle()) || joueurAcomparer.compareTo(leaderBoardIterateur.GetJoueurActuelle())==0);
			}
		}
		
	}
	
}
