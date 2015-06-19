import java.util.Iterator;


public class Main {

	public static void main(String[] args) {
		
		//
		//	Prouver que a date tout marche
		//
		
		//Nouvelle collection de des
		CollectionDes collectionde = new CollectionDes();
		
		//Ajouter 3 des de 6 faces
		collectionde.ajouterPlusieursDesIdentiques(3, 6);
		
		
		//Brasser tous les des
		collectionde.BrasserTousLesDees();

		
		//creer l'iterateur de cette collection
		IterateurDe iterateurDe = collectionde.creerIterateur();
		
		//print les resultats
		System.out.println((iterateurDe.GetDeActuelle()).GetFaceDessus());
		while(iterateurDe.hasNext()){
			System.out.println(((iterateurDe.next())).GetFaceDessus());
		}
		
		
		//Creation d'un joueur
		Joueur joueur1 = new Joueur(1100);
		Joueur joueur2 = new Joueur(1200);
		Joueur joueur3 = new Joueur(1300);
		
		//Creation de la collection de joueur et ajout des joueurs
		CollectionJoueurs collectionjoueur = new CollectionJoueurs();
		collectionjoueur.ajouterJoueur(joueur1);
		collectionjoueur.ajouterJoueur(joueur2);
		collectionjoueur.ajouterJoueur(joueur3);
		
		//Creation de l'iterateur joueurs
		IterateurJoueur iterateurJoueur = collectionjoueur.creerIterateur();
		
		//print les num de joueurs
		System.out.println(iterateurJoueur.GetJoueurActuelle().getNumJoueur());
		while(iterateurJoueur.hasNext()){
			System.out.println(iterateurJoueur.next().getNumJoueur());
		}
		
		
	}

}
