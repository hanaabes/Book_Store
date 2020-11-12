
import java.sql.SQLException;

import connexionBD.Mycnx;

public class LigneC {
	
	private static Mycnx connect;
	
	// les attributs 
private String IdLigneCommande; 
private int quantite; //quantité d'achat 
private Livre livre;
private String id_l;


    // constructeur

public LigneC(String iD, int q ,String id_l )
{
	this.IdLigneCommande=iD;
	this.quantite=q;
	this.id_l =livre.getRef_liv();
	
	}

   //getters + setters 

public String getIdLigneCommande() {
	return IdLigneCommande;
}
public void setIdLigneCommande(String idLigneCommande) {
	IdLigneCommande = idLigneCommande;
}
public int getQuantite() {
	return quantite;
}
public void setQuantite(int quantite) {
	this.quantite = quantite;
}

public Livre getLivre() {
	return livre;
}

public void setLivre(Livre livre) {
	this.livre = livre;
}

// les methodes 

//methode de calcule d'un achat 
public double calculer(Livre l, int quantite)
{
    double sum;
    sum= this.quantite* l.getPrix_liv();
    return sum;
}

//methode d'affichage
public String toString() {
	return "LigneC [IdLigneCommande=" + IdLigneCommande + ", quantite=" + quantite + ", livre=" + livre + "]";
}
//lancer la cnx au bd
	private static void lancerConnection() throws ClassNotFoundException, SQLException {
		
			connect = new Mycnx();}
	
//ajouter une ligne de command
	
	public static int ajouterligne_commande(String id,int quantite_achat,Livre l ) {
		try {
			lancerConnection();
			String requete = "INSERT INTO command_ligne (Id_commandligne, purchase_quantity,book_cl) values ('"+id+"', '"+quantite_achat +"',' " +l.getRef_liv()+"')";
			Mycnx.exeucterReqMiseAJour(requete);
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}
 
}