/******************************************************
Cours:  LOG121
Session: E2015
Projet: TP3-Bunco
Étudiant(e)s: Alexandre Malo, 
			  Marc-Antoine Hebert, 
			  Jean-Michel Coupal,
			  Julien Lemonde

Professeur : Francis Cardinal
Nom du fichier: IterateurJoueur.java
Date créé: 2015-06-18
*******************************************************
@author Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal, Julien Lemonde
@date 2015-06-18
*******************************************************/

package Framework;
import java.util.ArrayList;
import java.util.Iterator;


public class IterateurJoueur implements Iterator<Joueur>{
	
	private Joueur[] TableauJoueurs;
	private int position = 0;
	
	public IterateurJoueur(ArrayList<Joueur> listeDeJoueurs) {
		this.TableauJoueurs = new Joueur[listeDeJoueurs.size()];
		for (int i = 0; i < listeDeJoueurs.size(); i++) {
			this.TableauJoueurs[i] = listeDeJoueurs.get(i);
		}
	}
	
	@Override
	public boolean hasNext() {
		boolean hasNext = true;
		if(this.position < 0 || this.position >= this.TableauJoueurs.length -1){
			hasNext = false;
		}
		return hasNext;
	}

	@Override
	public Joueur next() {
		if(this.hasNext()){
			this.position ++;
		}
		else{
			this.position = 0;
		}
		return this.TableauJoueurs[this.position];
	}
	public Joueur GetJoueurActuelle(){
		return this.TableauJoueurs[this.position];
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
	
	
}
