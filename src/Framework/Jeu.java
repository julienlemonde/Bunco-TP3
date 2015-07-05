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

public abstract class Jeu {
	private int nbTours;
	private int tourActuel;
	private Joueur joueurActuel;
	protected IStrategie strategieDuJeuEnCours;
	protected CollectionDes tousLesDes = new CollectionDes();
	protected CollectionJoueurs tousLesJoueurs = new CollectionJoueurs();
	
	/**
	 * Constructeur d'un jeu quelconque
	 * @param nbJoueurs Indique le nombre de joueur a jouer au jeu
	 */
	public Jeu(int nbJoueurs){
		if(nbJoueurs < 0){
			nbJoueurs = 0;
		}
		for (int i = 1; i <= nbJoueurs; i++) {
			Joueur joueurAAjouter = new Joueur(i);
			this.tousLesJoueurs.ajouterJoueur(joueurAAjouter);
			this.setTourActuel(1);
		}
	}
	/**
	 * Methode qui calcule le pointage d'un tour du jeu
	 * ce pointage est calculer dans la strategie du jeu de type IStrategie
	 */
	public boolean calculerScoreTour(){
		this.getTousLesDes().BrasserTousLesDees();
		return strategieDuJeuEnCours.calculerScoreTour(this, this.joueurActuel);
	}
	/**
	 * Methode pour calculer le vainqueur du jeu
	 * @return Le gagant du jeu en cours
	 */
	public CollectionJoueurs calculerLeVainqueur(){
		return strategieDuJeuEnCours.calculerLeVainqueur(this);
	}
	/**
	 * Mutateur pour changer le nombre total de tour du jeu
	 * @param nbTours Le nombre de tour desire
	 */
	public void setNombreDeTours(int nbTours){
		this.nbTours = nbTours;
	}
	/**
	 * Accesseur du nombre de tour total
	 * @return Le de tour du jeu
	 */
	public int getNombreDeTours(){
		return this.nbTours;
	}
	/**
	 * Accesseur de la collection de joueur du jeu
	 * @return Une collection de tous les joueurs
	 */
	public CollectionJoueurs getTousLesJoueurs(){
		return (this.tousLesJoueurs);
	}
	/**
	 * Accesseur de la collection de des
	 * @return Tous les des du jeu
	 */
	public CollectionDes getTousLesDes(){
		return (this.tousLesDes);
	}
	/**
	 * Accesseur du tour actuel
	 * @return Le numero du tour actuek
	 */
	public int getTourActuel(){
		return this.tourActuel;
	}
	/**
	 * Mutateur pour choisir le numero, il doit etre plus petit que le nombre total 
	 * @param tourActuel Le numero du tour desire
	 */
	public void setTourActuel(int tourActuel){
		if(tourActuel <= this.getNombreDeTours())
		this.tourActuel = tourActuel;
	}
	/**
	 * Methode pour demarrer le jeu quelconque pour chaque joueur et selon le nombre de tour
	 * choisi
	 * @return Le gagnant du jeu
	 */
	public CollectionJoueurs DemarrerLeJeu(){
		while(this.getTourActuel() <= this.getNombreDeTours()){
			this.jouerLeTourComplet(this.getTourActuel());
			this.tourActuel ++;
		}
		return this.getTousLesJoueurs().getLeaderBoard();
	}
	/**
	 * Methode pour joueur un tour a la fois pour tous les joueurs a la fois
	 * @param numeroDuTour Numero du tour qui doit etre jouer
	 */
	public void jouerLeTourComplet(int numeroDuTour){
		this.setTourActuel(numeroDuTour);
		IterateurJoueur joueurActuel = this.tousLesJoueurs.creerIterateur();
		int joueurIndex = 1;
		while(joueurIndex <= this.tousLesJoueurs.getNombreDeJoueurDansLaCollection()){
			this.joueurActuel = joueurActuel.GetJoueurActuelle();
			boolean rejouerTour = true;
			while(rejouerTour == true){
				rejouerTour = this.calculerScoreTour();
			}
			joueurActuel.next();
			joueurIndex ++;
		}
	}
}
