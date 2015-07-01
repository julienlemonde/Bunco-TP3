/******************************************************
Cours:  LOG121
Session: E2015
Projet: TP3-Bunco
Étudiant(e)s: Alexandre Malo, 
			  Marc-Antoine Hebert, 
			  Jean-Michel Coupal,
			  Julien Lemonde

Professeur : Francis Cardinal
Nom du fichier: CollectionJoueurs.java
Date créé: 2015-06-18
*******************************************************
@author Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal, Julien Lemonde
@date 2015-06-18
*******************************************************/ 
package Framework;
import java.util.ArrayList;


public class CollectionJoueurs implements ListeAIterer{
	
	private ArrayList<Joueur> collectionDeJoueurs;
	
	/**
	 * Constructeur pour creer une Liste de joueur 
	 */
	public CollectionJoueurs(){
		this.collectionDeJoueurs = new ArrayList<Joueur>();
	}
	/**
	 * Methode pour ajouter un joueur a la collection
	 * @param joueur
	 */
	public void ajouterJoueur(Joueur joueur){
		this.collectionDeJoueurs.add(joueur);
	}
	/**
	 * Methode pour retourner le joueur ayant le plus grand pointage dans la liste
	 * @return Le joueur ayant le plus de point dans la collection
	 */
	public Joueur getJoueurAvecPlusGrandScore(boolean enleverCeJoueurDeLaCollection){
		Joueur joueurGagnant = this.collectionDeJoueurs.get(0);
		int indexDuGagnant = 0;
		for (int i = 0; i < this.collectionDeJoueurs.size(); i++) {
			if(this.collectionDeJoueurs.get(i).aPlusDePointQue(joueurGagnant)){
				joueurGagnant = this.collectionDeJoueurs.get(i);
				indexDuGagnant = i;
			}
		}
		if(enleverCeJoueurDeLaCollection){
			this.collectionDeJoueurs.remove(indexDuGagnant);
		}
		return joueurGagnant;
	}
	public CollectionJoueurs getLeaderBoard(){
		CollectionJoueurs collectionEnOrdreDeScore = new CollectionJoueurs();
		CollectionJoueurs collectionTemp = new CollectionJoueurs();
		for (int i = 0; i < this.getNombreDeJoueurDansLaCollection(); i++) {
			collectionTemp.ajouterJoueur(this.collectionDeJoueurs.get(i));
		}
		while(collectionTemp.getNombreDeJoueurDansLaCollection() != 0){
			collectionEnOrdreDeScore.ajouterJoueur(collectionTemp.getJoueurAvecPlusGrandScore(true));
		}
		return collectionEnOrdreDeScore;
	}
	
	/**
	 * Methode pour creer un iterateurdeJoueur pour la collection de joueur
	 */
	public IterateurJoueur creerIterateur() {
		return new IterateurJoueur(collectionDeJoueurs);
	}
	/**
	 * Accesseur pour avoir le nombre de joueur de la collection
	 * @return Le nombre de joueur dans la collection
	 */
	public int getNombreDeJoueurDansLaCollection(){
		return collectionDeJoueurs.size();
	}
}
