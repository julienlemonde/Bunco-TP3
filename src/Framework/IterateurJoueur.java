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
		// TODO Auto-generated method stub
		boolean hasNext = true;
		if(this.position < 0 || this.position >= this.TableauJoueurs.length -1){
			hasNext = false;
		}
		return hasNext;
	}

	@Override
	public Joueur next() {
		// TODO Auto-generated method stub
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
	
	
}
