/******************************************************
Cours:  LOG121
Session: E2015
Projet: Laboratoire #3
Étudiant(e)s: Julien Lemonde, Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal
Professeur : Francis Cardinal
Nom du fichier: De.java
Date créé: 2015-06-18
*******************************************************
Description de la classe
Classe qui gere les des a jouer individuellement
**Fait parti du framework de jeu
*******************************************************
*@author Julien Lemonde, Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal
2015-06-01 Version initiale
*******************************************************/ 

import java.util.Random;

public class De{
	private int nbFaces;
	private int faceDuDessus = 1;
	public De(int nombreDeFaces)
	{
		this.nbFaces = nombreDeFaces;
	}
	public void brasser(){
		Random hasard = new Random();
		this.faceDuDessus = hasard.nextInt(this.nbFaces) + 1;
	}
	public int GetFaceDessus(){
		return this.faceDuDessus;
	}
	
}
