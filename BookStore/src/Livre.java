
import java.sql.SQLException;
import java.util.Vector;
import java.sql.Date;


import com.mysql.jdbc.ResultSet;
import connexionBD.Mycnx;

public class Livre {
	
//les attributs 
private String titre_liv;
private String author_liv;
private Date releaseDate ;
private String ref_liv; // la référence d'un produit  
private double prix_liv; // prix par unité 
private int quantité_liv; // quantité de stock
private String caracteristique; // qq caracteristique du produit 

private static Mycnx connect;

//constrecteur 
public Livre(String refl,String t, String a, double prixl, int q, Date d ) {
	this.ref_liv=refl;
	this.prix_liv=prixl;
	this.quantité_liv=q;
	this.titre_liv=t;
	this.author_liv=a;
	this.releaseDate=d;
	
}
//lancer la connection a la bd
private static void lancerConnection() throws ClassNotFoundException, SQLException {
	
	connect = new Mycnx();}

//getters+setters
public String getTitre_liv() {
	return titre_liv;
}

public void setTitre_liv(String titre_liv) {
	this.titre_liv = titre_liv;
}

public String getAuthor_liv() {
	return author_liv;
}

public void setAuthor_liv(String author_liv) {
	this.author_liv = author_liv;
}

public Date getReleaseDate() {
	return releaseDate;
}

public void setReleaseDate(Date releaseDate) {
	this.releaseDate = releaseDate;
}

public String getRef_liv() {
	return ref_liv;
}

public void setRef_liv(String ref_liv) {
	this.ref_liv = ref_liv;
}

public double getPrix_liv() {
	return prix_liv;
}

public void setPrix_liv(double prix_liv) {
	this.prix_liv = prix_liv;
}

public int getQuantité_liv() {
	return quantité_liv;
}

public void setQuantité_liv(int quantité_liv) {
	this.quantité_liv = quantité_liv;
}

public String getCaracteristique() {
	return caracteristique;
}

public void setCaracteristique(String caracteristique) {
	this.caracteristique = caracteristique;
}

// methode d'affichage

public String toString() {
	return "Livre [titre_liv=" + titre_liv + ", \t author_liv=" + author_liv + ", \t releaseDate=" + releaseDate
			+ ", \t ref_liv=" + ref_liv + ",\t prix_liv=" + prix_liv + ", \t quantité_liv=" + quantité_liv + "]";
}


//ajout de livre dans la base de données

public static int ajouterlivre_bd(Livre l ) {
	try {
		lancerConnection();
		String requete = "INSERT INTO book (ref_Book,titel_book,author_book,price_book,stock_quantity,relaseDate) values ('"+l.getRef_liv()+"', '"+l.getTitre_liv() +"',' " +l.getAuthor_liv() +"',' "+l.getPrix_liv()+"',' "+l.getQuantité_liv()+"',' "+l.getReleaseDate()+"')";
		
		Mycnx.exeucterReqMiseAJour(requete);
		return 1;
	} catch (Exception e) {
		System.out.println(e.getMessage());
		return 0;
	}
}

//modifier un livre de la bd

public static int modifierlivre_bd(Livre l1) {
	try {
		lancerConnection();
		String requete = "UPDATE book SET price_book =" +l1.getPrix_liv()+"stock_quantity =" +l1.getQuantité_liv()+" WHERE ref_Book = " + l1.getRef_liv();
		Mycnx.exeucterReqMiseAJour(requete);
		return 1;
	} catch (Exception e) {
		System.out.println(e.getMessage());
		return 0;
	}
}
//afficher tous les livres 
public static Vector<Livre> touslivres() {
	Vector<Livre> tl = new Vector<Livre>();
	try {
		lancerConnection();
		String requete = "SELECT * FROM book";
		ResultSet rs = (ResultSet) Mycnx.exeucterReqConsult(requete);
		while(rs.next()) {
			tl.addElement(new Livre(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4),rs.getInt(5),rs.getDate(6)));
		}
		
		for(int i=0;i<tl.size();i++)
		{
			 System.out.println(tl.elementAt(i));
		}
		return tl;
	} catch(Exception e) {
		System.out.println(e.getMessage());
		return null;
	}
}

//supprimer tous les livres 
public static int suppttlivres() {
	try {
		lancerConnection();
		String requete = "DELETE FROM book" ;
		return Mycnx.exeucterReqMiseAJour(requete);
	} catch(Exception ex) {
		System.out.println(ex.getMessage());
		return 0;
	}
}
//supprimer un livre 
public static int supplivre(String l1) {
	try {
		lancerConnection();
		String requete = "DELETE FROM book where ref_Book="+l1 ;
		return Mycnx.exeucterReqMiseAJour(requete);
	} catch(Exception ex) {
		System.out.println(ex.getMessage());
		return 0;
	}
}

}
