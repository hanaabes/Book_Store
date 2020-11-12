

public class Utilisateur {
	
	
	private String iD_U;
	private String Nom_U;
	private String prenom_U;
	private String adresse_U;
	private String mdp_U;
	private String numtel_U;
	int nbCU =0; //nombre de commande par utilisateur 
	int nbCUMax = 50 ; // nombre de commande par utilisateur maximal 
	Commande [] co =new Commande [nbCUMax];
	// constructeur
	
	Utilisateur(String i,String n,String p,String a,String m,String num)
	{
		this.iD_U=i;
		this.Nom_U=n;
		this.prenom_U=p;
		this.adresse_U=a;
		this.mdp_U=m;
		this.numtel_U=num;
		
	}
	
	//getters + setters 
	
	public String getiD_U() {
		return iD_U;
	}
	public void setiD_U(String iD_U) {
		this.iD_U = iD_U;
	}
	public String getNom_U() {
		return Nom_U;
	}
	public void setNom_U(String nom_U) {
		Nom_U = nom_U;
	}
	public String getPrenom_U() {
		return prenom_U;
	}
	public void setPrenom_U(String prenom_U) {
		this.prenom_U = prenom_U;
	}
	public String getAdresse_U() {
		return adresse_U;
	}
	public void setAdresse_U(String adresse_U) {
		this.adresse_U = adresse_U;
	}
	public String getMdp_U() {
		return mdp_U;
	}
	public void setMdp_U(String mdp_U) {
		this.mdp_U = mdp_U;
	}
	public String getNumtel_U() {
		return numtel_U;
	}
	public void setNumtel_U(String numtel_U) {
		this.numtel_U = numtel_U;
	}
	
	// affichage

	public String toString() {
		return "Utilisateur [iD_U=" + iD_U + ", Nom_U=" + Nom_U + ", prenom_U=" + prenom_U + ", adresse_U=" + adresse_U
				+ ", mdp_U=" + mdp_U + ", numtel_U=" + numtel_U + "]";
	}
	
	public void Ajouter_C(Commande k)
	{ if(nbCU<nbCUMax)
	 {this.co[nbCU]=k ;
	 nbCU++;}}
}
