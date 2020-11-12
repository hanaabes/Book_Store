import java.sql.SQLException;
import java.sql.Date;
import java.util.Vector;
import com.mysql.jdbc.ResultSet;

import connexionBD.Mycnx;

public class Administrateur extends Utilisateur  {
	
	public static Vector<Livre> l = new Vector<Livre>(); // tableau de livre
	
	
	public Administrateur(String i, String n, String p, String a, String m, String num) {
		super(i, n, p, a, m, num);
	}
	// Les Méthodes effectuées par l'administrateur
	
	// gere les livres 
public void ajouter_livre(Livre l1)
{
	l.addElement(l1);
	}

public void Supprimer_livre(Livre l2) 
{
	l.remove(l2);
	}

public void modifier_livre(Livre l1,String car , double p, int q, String r,String t, String a ,Date d)

{ if (l.contains(l1))
	
	l1.setCaracteristique(car);
l1.setAuthor_liv(a);
l1.setPrix_liv(p);
l1.setQuantité_liv(q);
l1.setRef_liv(r);
l1.setReleaseDate(d);
l1.setTitre_liv(t);
	
}

public void afficher_ttlivres()

{ for(int i=0;i<l.size();i++)
{
	 System.out.println(l.elementAt(i));
}}
 


// gerer les utilisateurs 

 public static Vector<Utilisateur> utilisateurs = new Vector<Utilisateur>();

public void ajouter_u(Utilisateur u1)
{utilisateurs.addElement(u1);}

public void supprimer_u(Utilisateur u2)

{
	if (utilisateurs.contains(u2))
	utilisateurs.remove(u2);}

public void modifier_u(Utilisateur u3, String i ,String n , String p ,String a , String m, String num)
{
	 if (utilisateurs.contains(u3))
		
	 u3.setiD_U(i);
	 u3.setNom_U(n);
	 u3.setPrenom_U(p);
	 u3.setAdresse_U(a);
	 u3.setMdp_U(m);
	 u3.setNumtel_U(num);
	}

public void afficher_ttUtilisateurs()

{ for(int i=0;i<utilisateurs.size();i++)
{
 System.out.println(utilisateurs.elementAt(i));
}}

}
