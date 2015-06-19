import java.util.ArrayList;


public class CollectionDes implements ListeAIterer{
	
	private ArrayList<De> collectionDeDes;
	
	public CollectionDes(){
		this.collectionDeDes = new ArrayList<De>();
	}
	public void ajouterDe(De de){
		this.collectionDeDes.add(de);
	}
	public void ajouterPlusieursDesIdentiques(int combienDeDesAAjouter, int combienDeFacesParDes){
		for (int i = 0; i < combienDeDesAAjouter; i++) {
			this.collectionDeDes.add(new De(combienDeFacesParDes));
		}
	}
	public void BrasserTousLesDees(){
		for (De de : collectionDeDes) {
			de.brasser();
		}
	}
	@Override
	public IterateurDe creerIterateur(){
		return new IterateurDe(this.collectionDeDes);
	}
	
}
