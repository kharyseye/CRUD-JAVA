package Model;

import java.util.ArrayList;
import java.util.List;

import metier.Produit;

public class ProduitModel {
	private String motcle;
	private List<Produit> produit = new ArrayList<Produit>();
	
	public String getMotcle() {
		return motcle;
	}
	public void setMotcle(String motcle) {
		this.motcle = motcle;
	}
	public List<Produit> getProduit() {
		return produit;
	}
	public void setProduit(List<Produit> produit) {
		this.produit = produit;
	}
	
	
	

	
}
