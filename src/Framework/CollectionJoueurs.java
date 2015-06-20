package Framework;
import java.util.ArrayList;


public class CollectionJoueurs implements ListeAIterer{
	
	private ArrayList<Joueur> collectionDeJoueurs;
	
	public CollectionJoueurs(){
		this.collectionDeJoueurs = new ArrayList<Joueur>();
	}
	
	public void ajouterJoueur(Joueur joueur){
		this.collectionDeJoueurs.add(joueur);
	}
	public Joueur getJoueurAvecPlusGrandScore(){
		Joueur joueurGagnant = this.collectionDeJoueurs.get(0);
		for (Joueur joueur : this.collectionDeJoueurs) {
			if(joueur.aPlusDePointQue(joueurGagnant)){
				joueurGagnant = joueur;
			}
		}
		return joueurGagnant;
	}
	
	@Override
	public IterateurJoueur creerIterateur() {
		// TODO Auto-generated method stub
		return new IterateurJoueur(collectionDeJoueurs);
	}
	public int getNombreDeJoueurDansLaCollection(){
		return collectionDeJoueurs.size();
	}
}
