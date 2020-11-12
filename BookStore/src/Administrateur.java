import java.util.Vector;

public class Administrateur extends Utilisateur  {
	
	
	Administrateur(String i, String n, String p, String a, String m, String num) {
		super(i, n, p, a, m, num);
	}
	public static Vector<Produit> produits = new Vector<Produit>(); // tableau des produits 

public void ajouter_Produit(Produit p1)
{
	produits.addElement(p1);
	}

public void Supprimer_Produit(Produit p2) 
{
	produits.remove(p2);
	}

public void modifier_Produit(Produit p1,String car , double p, int q, String r)

{ if (produits.contains(p1))
	
	p1.setCaracteristique(car);
	p1.setPrix_P(p);
	p1.setQuantité_P(q);
	p1.setRef_P(r);
	
}

public void afficher_ttProduits()

{ for(int i=0;i<produits.size();i++)
{
	 System.out.println(produits.elementAt(i));
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
