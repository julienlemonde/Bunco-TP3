/******************************************************
Cours:  LOG121
Session: E2015
Projet: TP3-Bunco
Étudiant(e)s: Alexandre Malo, 
			  Marc-Antoine Hebert, 
			  Jean-Michel Coupal,
			  Julien Lemonde

Professeur : Francis Cardinal
Nom du fichier: IterateurDe.java
Date créé: 2015-06-18
*******************************************************
@author Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal, Julien Lemonde
@date 2015-06-18
*******************************************************
Description de la classe
Classe qui creer un iterateur pour gerer les des a jouer
(Peu importe le nombre de de)
**Fait parti du framework de jeu
*******************************************************/

package Framework;
import java.util.ArrayList;

public class IterateurDe implements java.util.Iterator<De>{
	private De[] TableauDes;
	private int position = 0;
	
	/**
	 * Contructeur de l'iterateur de des
	 * @param listeDeDes On entre une liste de Des
	 */
	public IterateurDe(ArrayList<De> listeDeDes){
		this.TableauDes = new De[listeDeDes.size()];
		for (int i = 0; i < listeDeDes.size(); i++) {
			this.TableauDes[i] = listeDeDes.get(i);
		}
	}
	/**
	 * Verifie s'il y a un autre de apres celui courant
	 *@return Retourne True s'il ne s'agit pas du dernier
	 */
	public boolean hasNext() {
		// TODO Auto-generated method stub
		boolean hasNext = true;
		if(this.position < 0 || this.position >= this.TableauDes.length -1){
			hasNext = false;
		}
		return hasNext;
	}

	/**
	 * Methode pour selectionner le prochain de dans l'iteration
	 */
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
	/**
	 * Methode pour savoir quel de est le courant
	 * @return Le de a la position courante
	 */
	public De GetDeActuelle(){
		return this.TableauDes[this.position];
	}
	/**
	 * Methode pour supprimer un de
	 */
	public void remove() {
		// TODO Auto-generated method stub
		
	}
}
	
