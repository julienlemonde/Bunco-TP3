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
package Default;
import Framework.IStrategie;
import Framework.IterateurDe;
import Framework.IterateurJoueur;
import Framework.Jeu;
import Framework.Joueur;

public class StrategieBunco implements IStrategie{
	
	
	
	@Override
	public Joueur calculerLeVainqueur(Jeu jeu) {
		// TODO Auto-generated method stub
		IterateurJoueur joueurActuel = jeu.getTousLesJoueurs().creerIterateur();
		Joueur gagnantTemporaire = joueurActuel.GetJoueurActuelle(); 
		for (int i = 1; i <= jeu.getTousLesJoueurs().getNombreDeJoueurDansLaCollection(); i++) {
			if(joueurActuel.next().aPlusDePointQue(gagnantTemporaire)){
				gagnantTemporaire = joueurActuel.GetJoueurActuelle();
			}
		}
		return gagnantTemporaire;
	}

	@Override
	public void calculerScoreTour(Jeu jeu) {
		// TODO Auto-generated method stub
		System.out.println("Tour No #" + jeu.getTourActuel() + "---------------------------------");
		IterateurJoueur joueurActuel = jeu.getTousLesJoueurs().creerIterateur();
		int joueurIndex = 1;
		while(joueurIndex <= jeu.getTousLesJoueurs().getNombreDeJoueurDansLaCollection()){
			boolean rejouerTour = true;
			while(rejouerTour == true){
				rejouerTour = true;
				jeu.getTousLesDes().BrasserTousLesDees();
				IterateurDe deDuJeuBunco = jeu.getTousLesDes().creerIterateur();
				int buncoDes = 0;
				int scoreBrasser = 0;
				int troisPareille = 0;
				int aRefaire = deDuJeuBunco.GetDeActuelle().GetFaceDessus();
				int numeroDuDes = 1;
				while(numeroDuDes <= 3){
					System.out.println("De: " + deDuJeuBunco.GetDeActuelle().GetFaceDessus());
					if(deDuJeuBunco.GetDeActuelle().faceDuDessusEgaleA(jeu.getTourActuel())){
						buncoDes ++;
						scoreBrasser = buncoDes;
						if(buncoDes == 3){
							scoreBrasser = 21;
						}
					}
					else if (aRefaire == deDuJeuBunco.GetDeActuelle().GetFaceDessus()){
						troisPareille ++;
						if(troisPareille == 3){
							scoreBrasser = 5;
						}
					}
					deDuJeuBunco.next();
					numeroDuDes ++;
				}
				if(scoreBrasser == 21 || scoreBrasser == 0){
					rejouerTour = false;
				}
				System.out.println("Joueur NO " + joueurActuel.GetJoueurActuelle().getNumJoueur() + " Score: " + scoreBrasser);
				joueurActuel.GetJoueurActuelle().ajouterCesPointsAuPointage(scoreBrasser);
			}
			System.out.println("Score apres ce tour pour joueur " + joueurActuel.GetJoueurActuelle().getNumJoueur() + " : " + joueurActuel.GetJoueurActuelle().getNombreDePoints());
			joueurActuel.next();
			joueurIndex ++;
			
		}
	}
	
}
