
public class Main {

	public static void main(String[] args) {
		
		
		//Faire trois des a 6 faces
		IterateurDe test = new IterateurDe(3, 6);
		//tous les brasser
		test.BrasserTousLesDees();
		
		//print les resultats
		System.out.println(test.GetDeActuelle().GetFaceDessus());
		while(test.hasNext()){
			System.out.println(test.next().GetFaceDessus());
		}
		
	}

}
