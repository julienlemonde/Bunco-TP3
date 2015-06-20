package Default;

import Framework.Jeu;
import Framework.Joueur;

public class JeuBunco extends Jeu{
	private int nbDeJoueurs;
	public JeuBunco(int nbDeJoueurs){
		this.nbDeJoueurs = nbDeJoueurs;
		super.strategieDuJeuEnCours = new StrategieBunco();
		super.tousLesDes.ajouterPlusieursDesIdentiques(3, 6);
		for (int i = 1; i <= nbDeJoueurs; i++) {
			Joueur joueurAAjouter = new Joueur(i);
			super.tousLesJoueurs.ajouterJoueur(joueurAAjouter);
		}
		super.setNombreDeTours(6);
	}
	public Joueur jouerAuBunco(){
		for (int i = 1; i <= super.getNombreDeTours(); i++) {
			jouerLeTour(i);
		}
		super.calculerLeVainqueur();
		return super.getGagnant();
	}
	public void jouerLeTour(int numeroDuTour){
		super.setTourActuel(numeroDuTour);
		super.calculerScoreTour();
	}
}
