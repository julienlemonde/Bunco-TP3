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
	public Joueur getJoueurAvecPlusGrandScore(){
		Joueur joueurGagnant = this.collectionDeJoueurs.get(0);
		for (Joueur joueur : this.collectionDeJoueurs) {
			if(joueur.aPlusDePointQue(joueurGagnant)){
				joueurGagnant = joueur;
			}
		}
		return joueurGagnant;
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
