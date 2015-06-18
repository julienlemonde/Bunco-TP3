
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
	private ArrayList<De> ListeDeDees;
	private int position = 0;
	
	/**
	 * Constructeur
	 * @param nombreDeDees Nombre de des necessaire pour le jeu
	 * @param nombreDeFaceParDee Nombre de face necessaire par des.
	 */
	public IterateurDe(int nombreDeDees, int nombreDeFaceParDee){
		this.ListeDeDees = new ArrayList<De>();
		for (int i = 0; i < nombreDeDees; i++) {
			this.ListeDeDees.add(i, (new De(nombreDeFaceParDee)));
		}
	}
	/**
	 * Brasse tous les des a jouer de la liste
	 */
	public void BrasserTousLesDees(){
		int backupPosition = this.position;
		this.position = 0;
		this.ListeDeDees.get(this.position).brasser();
		while (this.hasNext()){
			this.next().brasser();
		}
		this.position = backupPosition;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		boolean hasNext = true;
		if(this.position < 0 || this.position >= ListeDeDees.size() -1){
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
		return ListeDeDees.get(this.position);
	}
	public De GetDeActuelle(){
		return this.ListeDeDees.get(this.position);
	}
}
	
