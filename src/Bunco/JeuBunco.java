/******************************************************
Cours:  LOG121
Session: E2015
Projet: TP3-Bunco
Étudiant(e)s: Alexandre Malo, 
			  Marc-Antoine Hebert, 
			  Jean-Michel Coupal,
			  Julien Lemonde

Professeur : Francis Cardinal
Nom du fichier: JeuBunco.java
Date créé: 2015-06-18
*******************************************************
@author Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal, Julien Lemonde
@date 2015-06-18
*******************************************************/ 
package Bunco;

import Framework.IterateurJoueur;
import Framework.Jeu;

public class JeuBunco extends Jeu{
	/**
	 * Constructeur du jeu Bunco. Le constructeur utilise le constructeur super qui est
	 * de la classe jeu 
	 * @param nbDeJoueurs On indique le nombre de joueur
	 */
	public JeuBunco(int nbDeJoueurs){
		super(nbDeJoueurs);
		super.strategieDuJeuEnCours = new StrategieBunco();
		super.tousLesDes.ajouterPlusieursDesIdentiques(3, 6);
		super.setNombreDeTours(6);
	}
	
	
}
