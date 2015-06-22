/******************************************************
Cours:  LOG121
Session: E2015
Projet: TP3-Bunco
Étudiant(e)s: Alexandre Malo, 
			  Marc-Antoine Hebert, 
			  Jean-Michel Coupal,
			  Julien Lemonde

Professeur : Francis Cardinal
Nom du fichier: Jeu.java
Date créé: 2015-06-18
*******************************************************
@author Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal, Julien Lemonde
@date 2015-06-18
*******************************************************/

package Framework;

public class Jeu {
	private int nbTours;
	private int tourActuel;
	private Joueur gagnant;
	protected IStrategie strategieDuJeuEnCours;
	protected CollectionDes tousLesDes = new CollectionDes();
	protected CollectionJoueurs tousLesJoueurs = new CollectionJoueurs();
	
	public Jeu(int nbJoueurs){
		for (int i = 1; i <= nbJoueurs; i++) {
			Joueur joueurAAjouter = new Joueur(i);
			this.tousLesJoueurs.ajouterJoueur(joueurAAjouter);
		}
	}
	
	public void calculerScoreTour(){
		strategieDuJeuEnCours.calculerScoreTour(this);
	}
	public Joueur calculerLeVainqueur(){
		return strategieDuJeuEnCours.calculerLeVainqueur(this);
	}
	public void setNombreDeTours(int nbTours){
		this.nbTours = nbTours;
	}
	public int getNombreDeTours(){
		return this.nbTours;
	}
	protected void setGagnant(Joueur leGagnant){
		this.gagnant = leGagnant;
	}
	protected Joueur getGagnant(){
		return this.gagnant;
	}
	public CollectionJoueurs getTousLesJoueurs(){
		return (this.tousLesJoueurs);
	}
	public CollectionDes getTousLesDes(){
		return (this.tousLesDes);
	}
	public int getTourActuel(){
		return this.tourActuel;
	}
	public void setTourActuel(int tourActuel){
		this.tourActuel = tourActuel;
	}
	public Joueur DemarrerLeJeu(){
		for (int i = 1; i <= this.getNombreDeTours(); i++) {
			jouerLeTour(i);
		}
		this.setGagnant(this.calculerLeVainqueur());
		return this.getGagnant();
	}
	public void jouerLeTour(int numeroDuTour){
		this.setTourActuel(numeroDuTour);
		this.calculerScoreTour();
	}
}
