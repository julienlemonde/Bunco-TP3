/******************************************************
Cours:  LOG121
Session: E2015
Projet: TP3-Bunco
Étudiant(e)s: Alexandre Malo, 
			  Marc-Antoine Hebert, 
			  Jean-Michel Coupal,
			  Julien Lemonde

Professeur : Francis Cardinal
Nom du fichier: De.java
Date créé: 2015-06-18
*******************************************************
@author Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal, Julien Lemonde
@date 2015-06-18
*******************************************************
Description de la classe
Classe qui gere les des a jouer individuellement
**Fait parti du framework de jeu
*******************************************************/ 

package Framework;
import java.util.Random;

public class De implements Comparable<De>{
	private int nbFaces;
	private int faceDuDessus = 1;
	/**
	 * Contrusteur d'un de
	 * @param nombreDeFaces Nombre de face que le de doit avoit
	 */
	public De(int nombreDeFaces)
	{
		if(nombreDeFaces < 1){
			this.nbFaces = 1;
		}
		else{
			this.nbFaces = nombreDeFaces;
		}
	}
	/**
	 * Methode pour brasser les des. Genere un nombre au hasard entre 1 et le nombre de face
	 */
	public void brasser(){
		Random hasard = new Random();
		this.faceDuDessus = hasard.nextInt(this.nbFaces) + 1;
	}
	/**
	 * Accesseur de la face qui se retrouve au dessus du de
	 * @return Le nombre de la face sur le dessus
	 */
	public int GetFaceDessus(){
		return this.faceDuDessus;
	}
	
	/**
	 * Methode pour comparer le resultat de deux des
	 */
	public int compareTo(De DeAComparer) throws IllegalArgumentException{
		int toReturn = 0;
		if(DeAComparer != null){
			toReturn = this.GetFaceDessus() - DeAComparer.GetFaceDessus();
			if(DeAComparer.GetFaceDessus() > this.GetFaceDessus()){
				toReturn = DeAComparer.GetFaceDessus() - this.GetFaceDessus();
			}
		}
		else{
			throw new IllegalArgumentException();
		}
		return toReturn;
	}
	/**
	 * Methode pour comparer le de est egal a un certain nombre
	 * @param nombreAVerifier Le nombre a tester
	 * @return Retourne true si le de est egal au nombre en parametre
	 */
	public boolean faceDuDessusEgaleA(int nombreAVerifier){
		boolean estLeMemeNombre = false;
		if(this.GetFaceDessus() == nombreAVerifier){
			estLeMemeNombre = true;
		}
		return estLeMemeNombre;
	}
	
}
