

public class Produit {
	
	
private String ref_P; // la r�f�rence d'un produit  
private double prix_P; // prix par unit� 
private int quantit�_P; // quantit� de stock
private String caracteristique; // qq caracteristique du produit 


 // constructeur

Produit(String refp, double prixp , int q, String car)
{
	this.ref_P=refp;
	this.prix_P=prixp;
	this.quantit�_P=q;
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

public int getQuantit�_P() {
	return quantit�_P;
}

public void setQuantit�_P(int quantit�_P) {
	this.quantit�_P = quantit�_P;
}

public String getCaracteristique() {
	return caracteristique;
}

public void setCaracteristique(String caracteristique) {
	this.caracteristique = caracteristique;
	

}
public String toString() {
	return "Produit [ref_P=" + ref_P + ", prix_P=" + prix_P + ", quantit�_P=" + quantit�_P + ", caracteristique="
			+ caracteristique + "]";
}



}
