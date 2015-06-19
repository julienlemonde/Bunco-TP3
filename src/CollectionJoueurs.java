import java.util.ArrayList;
import java.util.Iterator;


public class CollectionJoueurs implements ListeAIterer{
	
	private ArrayList<Joueur> collectionDeJoueurs;
	
	public CollectionJoueurs(){
		this.collectionDeJoueurs = new ArrayList<Joueur>();
	}
	
	public void ajouterJoueur(Joueur joueur){
		this.collectionDeJoueurs.add(joueur);
	}
	
	
	@Override
	public IterateurJoueur creerIterateur() {
		// TODO Auto-generated method stub
		return new IterateurJoueur(collectionDeJoueurs);
	}

}
