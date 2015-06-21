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
	public Joueur(int num){
		this.numeroDuJoueur = num;
		this.nombreDePoints = 0;
	}
	public int getNumJoueur(){
		return this.numeroDuJoueur;
	}
	public int getNombreDePoints(){
		return this.nombreDePoints;
	}
	@Override
	public int compareTo(Joueur joueurAComparer) {
		int toReturn = this.getNombreDePoints() - joueurAComparer.getNombreDePoints();
		if(joueurAComparer.getNombreDePoints() > this.getNombreDePoints()){
			toReturn = joueurAComparer.getNombreDePoints() - this.getNombreDePoints();
		}
		return toReturn;
	}
	public boolean aPlusDePointQue(Joueur joueurAComparer){
		boolean aPlusDePoint = false;
		if(this.getNombreDePoints() > joueurAComparer.getNombreDePoints()){
			aPlusDePoint = true;
		}
		return aPlusDePoint;
	}
	public boolean nombreDePointEgaleA(int nombreAVerifier){
		boolean estLeMemeNombre = false;
		if(this.getNombreDePoints() == nombreAVerifier){
			estLeMemeNombre = true;
		}
		return estLeMemeNombre;
	}
	public void setPointageDuJoueur(int points){
		this.nombreDePoints = points;
	}
	public void ajouterCesPointsAuPointage(int pointsAAjouter){
		this.nombreDePoints += pointsAAjouter;
	}
}
