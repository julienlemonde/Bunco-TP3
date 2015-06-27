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
package Default;

import Framework.Jeu;

public class JeuBunco extends Jeu{
	public JeuBunco(int nbDeJoueurs){
		super(nbDeJoueurs);
		super.strategieDuJeuEnCours = new StrategieBunco();
		super.tousLesDes.ajouterPlusieursDesIdentiques(3, 6);
		super.setNombreDeTours(6);
	}
}
