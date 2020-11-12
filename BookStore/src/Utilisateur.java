import java.sql.SQLException;
import java.util.Vector;

import com.mysql.jdbc.ResultSet;

import connexionBD.Mycnx;

public class Utilisateur {
	
private static Mycnx connect;
	
	// les attributs  

	private String iD_U;
	private String Nom_U;
	private String prenom_U;
	private String adresse_U;
	private String mdp_U;
	private String numtel_U;
	int nbCU =0; //nombre de commande par utilisateur 
	int nbCUMax = 50 ; // nombre de commande par utilisateur maximal 
	Commande [] co =new Commande [nbCUMax];
	
	//lancer la cnx au bd
	private static void lancerConnection() throws ClassNotFoundException, SQLException {
		
			connect = new Mycnx();}
	
	// constructeur
	public Utilisateur(String i,String m,String n,String p,String a,String num)
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
		return "Utilisateur [iD_U=" + iD_U + ", \t Nom_U=" + Nom_U + ", \t prenom_U=" + prenom_U + ", \t adresse_U=" + adresse_U
				+ ", \t mdp_U=" + mdp_U + ", \t numtel_U=" + numtel_U + "]";
	}
	
	public void Ajouter_C(Commande k)
	{ if(nbCU<nbCUMax)
	 {this.co[nbCU]=k ;
	 nbCU++;}}
	
	//les methodes avec la base donne

	public  int ajouterutilisateur_bd(Utilisateur u ) {
		try {
			lancerConnection();
			String requete = "INSERT INTO user (Id_user, password_user, user_name, firstname_user, adress_user, numberphone_user) values ('"+u.getiD_U()+"', '"+u.getMdp_U() +"',' " +u.getNom_U() +"',' "+u.getPrenom_U()+"',' "+u.getAdresse_U()+"',' "+u.getNumtel_U()+"')";
			
			Mycnx.exeucterReqMiseAJour(requete);
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

	public  int modifierutilisateur_bd(Utilisateur u1) {
		try {
			lancerConnection();
			String requete = "UPDATE user SET password_user=" +u1.getMdp_U()+ " user_name = " + u1.getNom_U() +" firstname_user=" +u1.getPrenom_U()+"adress_user =" +u1.getAdresse_U()+"numberphone_user ="+u1.getNumtel_U()+" WHERE Id_user = " + u1.getiD_U();
			Mycnx.exeucterReqMiseAJour(requete);
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

	//afficher tous les utilisateurs 

	public static  Vector<Utilisateur> toutUtilisateur() {
		Vector<Utilisateur> tU = new Vector<Utilisateur>();
		try {
			lancerConnection();
			String requete = "SELECT * FROM user";
			ResultSet rs = (ResultSet) Mycnx.exeucterReqConsult(requete);
			while(rs.next()) {
				tU.addElement(new Utilisateur(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6)));
			}
			for(int i=0;i<tU.size();i++)
			{
				 System.out.println(tU.elementAt(i));
			}
			
			return tU;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	//supprimer un utilisateur
	public  int suppUtilisateur(Utilisateur e) {
		try {
			lancerConnection();
			String requete = "DELETE FROM user WHERE Id_user ="+e.getiD_U() ;
			return Mycnx.exeucterReqMiseAJour(requete);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			return 0;
		}
	}
	
	

}