package TestsUnitaires;

import static org.junit.Assert.*;
import org.junit.*;

import Bunco.JeuBunco;
import Bunco.StrategieBunco;
import Framework.De;
import Framework.IterateurDe;
import Framework.Joueur;

public class TestStrategie {
	private StrategieBunco strategieTest;
	private JeuBunco jeuTest;
	private IterateurDe deTest;
	
	@Before
	public void necessairePourTester(){
		strategieTest = new StrategieBunco();
		jeuTest = new JeuBunco(2);
	}
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
	
}
