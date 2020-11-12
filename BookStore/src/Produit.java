

public class Produit {
	
	
private String ref_P; // la référence d'un produit  
private double prix_P; // prix par unité 
private int quantité_P; // quantité de stock
private String caracteristique; // qq caracteristique du produit 


 // constructeur

Produit(String refp, double prixp , int q, String car)
{
	this.ref_P=refp;
	this.prix_P=prixp;
	this.quantité_P=q;
	this.caracteristique=car;
	
	}

// getters et setters

public String getRef_P() {
	return ref_P;
}


public void setRef_P(String ref_P) {
	this.ref_P = ref_P;
}

public double getPrix_P() {
	return prix_P;
}

public void setPrix_P(double prix_P) {
	this.prix_P = prix_P;
}

public int getQuantité_P() {
	return quantité_P;
}

public void setQuantité_P(int quantité_P) {
	this.quantité_P = quantité_P;
}

public String getCaracteristique() {
	return caracteristique;
}

public void setCaracteristique(String caracteristique) {
	this.caracteristique = caracteristique;
	

}
public String toString() {
	return "Produit [ref_P=" + ref_P + ", prix_P=" + prix_P + ", quantité_P=" + quantité_P + ", caracteristique="
			+ caracteristique + "]";
}



}
