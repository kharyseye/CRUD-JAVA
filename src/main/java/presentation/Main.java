package presentation;
import java.util.List;

import dao.ProduitdaoImpl;
import metier.Produit;

public class Main {

	public static void main(String[] args) {
		ProduitdaoImpl dao = new ProduitdaoImpl();
		Produit p1 = dao.add(new Produit("Souris", 5000, 100));
		Produit p2 = dao.add(new Produit("tapis-Souris", 2000, 100));
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		
		System.out.println("Chercher des produits");
		List<Produit> prod = dao.produitparmc("%H%");
		for(Produit p:prod) {
			System.out.println(p.toString());
			
		}


	}

}
