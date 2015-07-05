/******************************************************
Cours:  LOG121
Session: E2015
Projet: TP3-Bunco
Étudiant(e)s: Alexandre Malo, 
			  Marc-Antoine Hebert, 
			  Jean-Michel Coupal,
			  Julien Lemonde

Professeur : Francis Cardinal
Nom du fichier: Main.java
Date créé: 2015-06-18
*******************************************************
@author Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal, Julien Lemonde
@date 2015-06-18
*******************************************************/ 
package Bunco;
import Framework.CollectionJoueurs;
import Framework.IterateurJoueur;


public class Main {

	public static void main(String[] args) {
		
		//Jeu du bunco. On cree le jeu et on joue
		JeuBunco jeubuncotest = new JeuBunco(3);
		CollectionJoueurs gagnants = jeubuncotest.DemarrerLeJeu();
		System.out.println("BiG WINNER !: " + gagnants.getJoueurAvecPlusGrandScore(false).getNumJoueur());
		
		IterateurJoueur leaderBoard = gagnants.creerIterateur();
		for (int i = 0; i < gagnants.getNombreDeJoueurDansLaCollection(); i++) {
			System.out.println((i+1) +"e place: Joueur #"+leaderBoard.GetJoueurActuelle().getNumJoueur());
			leaderBoard.next();
		}
		
		
		
	}

}
