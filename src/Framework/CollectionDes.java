/******************************************************
Cours:  LOG121
Session: E2015
Projet: TP3-Bunco
Étudiant(e)s: Alexandre Malo, 
			  Marc-Antoine Hebert, 
			  Jean-Michel Coupal,
			  Julien Lemonde

Professeur : Francis Cardinal
Nom du fichier: CollectionDes.java
Date créé: 2015-06-18
*******************************************************
@author Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal, Julien Lemonde
@date 2015-06-18
*******************************************************/ 
package Framework;
import java.util.ArrayList;


public class CollectionDes implements ListeAIterer{
	
	private ArrayList<De> collectionDeDes;
	
	/**
	 * Constructeur de CollectionDes qui va creer une Liste de dee
	 */
	public CollectionDes(){
		this.collectionDeDes = new ArrayList<De>();
	}
	/**
	 * Methode pour ajouter un De a la collection
	 * @param de On lui indique quel de il faut ajouter
	 */
	public void ajouterDe(De de){
		this.collectionDeDes.add(de);
	}
	/**
	 * Methode pour ajouter plusieurs des identiques a la fois
	 * @param combienDeDesAAjouter Le nombre de des a ajouter
	 * @param combienDeFacesParDes Combien de face le des contients
	 */
	public void ajouterPlusieursDesIdentiques(int combienDeDesAAjouter, int combienDeFacesParDes){
		for (int i = 0; i < combienDeDesAAjouter; i++) {
			this.collectionDeDes.add(new De(combienDeFacesParDes));
		}
	}
	/**
	 * Methode pour brasser tous les des en meme temps
	 */
	public void BrasserTousLesDees(){
		for (De de : collectionDeDes) {
			de.brasser();
		}
	}
	/**
	 * Methode pour creer un iterateur de collection de de
	 */
	public IterateurDe creerIterateur(){
		return new IterateurDe(this.collectionDeDes);
	}
	
}
