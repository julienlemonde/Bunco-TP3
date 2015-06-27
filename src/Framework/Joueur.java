/******************************************************
Cours:  LOG121
Session: E2015
Projet: TP3-Bunco
Étudiant(e)s: Alexandre Malo, 
			  Marc-Antoine Hebert, 
			  Jean-Michel Coupal,
			  Julien Lemonde

Professeur : Francis Cardinal
Nom du fichier: Joueur.java
Date créé: 2015-06-18
*******************************************************
@author Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal, Julien Lemonde
@date 2015-06-18
*******************************************************/

package Framework;

public class Joueur implements Comparable<Joueur>{
	private int numeroDuJoueur;
	private int nombreDePoints;
	/**
	 * Constructeur pour creer un nouveau joueur
	 * @param num Le numero d'identification du joueur
	 */
	public Joueur(int num){
		this.numeroDuJoueur = num;
		this.nombreDePoints = 0;
	}
	/**
	 * Accesseur du numero d'identification du joueur
	 * @return Le numero du joueur
	 */
	public int getNumJoueur(){
		return this.numeroDuJoueur;
	}
	/**
	 * Accesseur du nombre de point du joueur
	 * @return Le nombre de point du joueur
	 */
	public int getNombreDePoints(){
		return this.nombreDePoints;
	}
	/**
	 * Methode pour comparer deux joueur ensemble
	 * @param joueurAComparer Le joueur a comparer
	 * @return La difference de point entre les deux
	 */
	public int compareTo(Joueur joueurAComparer) {
		int toReturn = this.getNombreDePoints() - joueurAComparer.getNombreDePoints();
		if(joueurAComparer.getNombreDePoints() > this.getNombreDePoints()){
			toReturn = joueurAComparer.getNombreDePoints() - this.getNombreDePoints();
		}
		return toReturn;
	}
	/**
	 * Methode pour voir quel joueur a plus de point que l'autre
	 * @param joueurAComparer Le joueur a comparer
	 * @return True si le joueur actuel a plus de point que celui entre en parametre
	 */
	public boolean aPlusDePointQue(Joueur joueurAComparer){
		boolean aPlusDePoint = false;
		if(this.getNombreDePoints() > joueurAComparer.getNombreDePoints()){
			aPlusDePoint = true;
		}
		return aPlusDePoint;
	}
	/**
	 * Methode pour verifier si le pointage du joueur est egal a un nombre
	 * @param nombreAVerifier Le nombre de point a verifier
	 * @return Retourne TRUE si les deux sont egaux
	 */
	public boolean nombreDePointEgaleA(int nombreAVerifier){
		boolean estLeMemeNombre = false;
		if(this.getNombreDePoints() == nombreAVerifier){
			estLeMemeNombre = true;
		}
		return estLeMemeNombre;
	}
	/**
	 * Mutateur pour setter le pointage du joueur
	 * @param points Le nombre de point a mettre au joueur. Ce n'est pas une addition
	 */
	public void setPointageDuJoueur(int points){
		this.nombreDePoints = points;
	}
	/**
	 * Methode pour ajouter des points au pointage du joueur
	 * @param pointsAAjouter Nombre de point a ajouter
	 */
	public void ajouterCesPointsAuPointage(int pointsAAjouter){
		this.nombreDePoints += pointsAAjouter;
	}
}
