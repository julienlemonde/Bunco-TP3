package Default;

import Framework.Jeu;
import Framework.Joueur;

public class JeuBunco extends Jeu{
	private int nbDeJoueurs;
	public JeuBunco(int nbDeJoueurs){
		super(nbDeJoueurs);
		super.strategieDuJeuEnCours = new StrategieBunco();
		super.tousLesDes.ajouterPlusieursDesIdentiques(3, 6);
		super.setNombreDeTours(6);
	}
}
