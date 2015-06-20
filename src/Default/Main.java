package Default;
import java.util.Iterator;

import Framework.CollectionDes;
import Framework.CollectionJoueurs;
import Framework.De;
import Framework.IterateurDe;
import Framework.IterateurJoueur;
import Framework.Joueur;


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
			De deTemp = iterateurDe.next();
			System.out.println((deTemp).GetFaceDessus());
			//Tester la methode faceDuDessusEgaleA(int i)
			if(deTemp.faceDuDessusEgaleA(6)){
				System.out.println("Nous avons Un 6 ici!!");
			}
		}
		
		//Creation d'un joueur
		Joueur joueur1 = new Joueur(1100);
		Joueur joueur2 = new Joueur(1200);
		Joueur joueur3 = new Joueur(1300);
		joueur1.setPointageDuJoueur(11);
		joueur2.setPointageDuJoueur(10);
		joueur3.setPointageDuJoueur(10);
		
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
			Joueur joueurTemp = iterateurJoueur.next();
			System.out.println(joueurTemp.getNumJoueur());
			if(joueurTemp.nombreDePointEgaleA(10)){
				System.out.println("Supposer avoir 2");
			}
		}
		//Tester si le joueur gagnant est retournee
		System.out.println("Gagnant:");
		System.out.println(collectionjoueur.getJoueurAvecPlusGrandScore().getNumJoueur());
		
		System.out.println(" :");
		System.out.println(" :");
		System.out.println(" :");
		System.out.println(" :");
		
		JeuBunco jeubuncotest = new JeuBunco(3);
		jeubuncotest.jouerLeTour(1);
		
		
	}

}