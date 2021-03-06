/******************************************************
Cours:  LOG121
Session: E2015
Projet: TP3-Bunco
Étudiant(e)s: Alexandre Malo, 
			  Marc-Antoine Hebert, 
			  Jean-Michel Coupal,
			  Julien Lemonde

Professeur : Francis Cardinal
Nom du fichier: StrategieBunco.java
Date créé: 2015-06-18
*******************************************************
@author Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal, Julien Lemonde
@date 2015-06-18
*******************************************************/ 
package Bunco;
import Framework.CollectionJoueurs;
import Framework.IStrategie;
import Framework.IterateurDe;
import Framework.Jeu;
import Framework.Joueur;

public class StrategieBunco implements IStrategie{
	
	
	
	@Override
	/**
	 * Classe pour calcule le Vainqueur du jeu bunco
	 * @return Retour un joueur gagnant
	 */
	public CollectionJoueurs calculerLeVainqueur(Jeu jeu) {
		return jeu.getTousLesJoueurs().getLeaderBoard();
	}

	/**
	 * Methode pour calculer le pointage de chaque joueur par tour
	 *@param Un type de jeu dans ce cas, il s'agit de la strategie bunco donc le jeu entree est de type bunco
	 *
	 */
	public boolean calculerScoreTour(Jeu jeu, Joueur joueurActuel) {
		boolean rejouerTour = true;
		IterateurDe deDuJeuBunco = jeu.getTousLesDes().creerIterateur();
		int buncoDes = 0;
		int scoreBrasser = 0;
		int troisPareille = 0;
		int aRefaire = deDuJeuBunco.GetDeActuelle().GetFaceDessus();
		int numeroDuDes = 1;
		while(numeroDuDes <= 3){
			System.out.println("De: " + deDuJeuBunco.GetDeActuelle().GetFaceDessus());
			//Si le de actuel est egale au numero de tour
			if(deDuJeuBunco.GetDeActuelle().faceDuDessusEgaleA(jeu.getTourActuel())){
				buncoDes ++;
				scoreBrasser = buncoDes;
				//Si les 3 des sont egales au tour = BUNCO
				if(buncoDes == 3){
					scoreBrasser = 21;
				}
			}
			//Si les 3 des sont egaux mais sans etre le numero du tour
			else if (aRefaire == deDuJeuBunco.GetDeActuelle().GetFaceDessus()){
				troisPareille ++;
				if(troisPareille == 3){
					scoreBrasser = 5;
				}
			}
			deDuJeuBunco.next();
			numeroDuDes ++;
		}
		//Si le joueur a fait un bunco ou aucun point, on ne rejoue pas sont tour
		if(scoreBrasser == 21 || scoreBrasser == 0){
			rejouerTour = false;
		}
		System.out.println("Joueur NO " + joueurActuel.getNumJoueur() + " Score: " + scoreBrasser);
		joueurActuel.ajouterCesPointsAuPointage(scoreBrasser);
		return rejouerTour;
	}
}
	

