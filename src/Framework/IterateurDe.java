package Framework;

/******************************************************
Cours:  LOG121
Session: E2015
Projet: Laboratoire #3
Étudiant(e)s: Julien Lemonde, Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal
Professeur : Francis Cardinal
Nom du fichier: IterateurDe.java
Date créé: 2015-06-18
*******************************************************
Description de la classe
Classe qui creer un iterateur pour gerer les des a jouer
(Peu importe le nombre de de)
**Fait parti du framework de jeu
*******************************************************
*@author Julien Lemonde, Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal
2015-06-01 Version initiale
*******************************************************/ 

import java.util.ArrayList;

public class IterateurDe implements java.util.Iterator<De>{
	private De[] TableauDes;
	private int position = 0;
	
	/**
	 * Constructeur
	 * @param nombreDeDees Nombre de des necessaire pour le jeu
	 * @param nombreDeFaceParDee Nombre de face necessaire par des.
	 */
	public IterateurDe(ArrayList<De> listeDeDes){
		this.TableauDes = new De[listeDeDes.size()];
		for (int i = 0; i < listeDeDes.size(); i++) {
			this.TableauDes[i] = listeDeDes.get(i);
		}
	}
	/**
	 * Brasse tous les des a jouer de la liste
	 */

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		boolean hasNext = true;
		if(this.position < 0 || this.position >= this.TableauDes.length -1){
			hasNext = false;
		}
		return hasNext;
	}

	@Override
	public De next() {
		// TODO Auto-generated method stub
		if(this.hasNext()){
			this.position ++;
		}
		else{
			this.position = 0;
		}
		return this.TableauDes[this.position];
	}
	public De GetDeActuelle(){
		return this.TableauDes[this.position];
	}
}
	
