import java.util.Scanner;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
	
	public static Administrateur A1; // un seul admin
	public static Utilisateur U;
	
	public static void ajouterUtilisateur()
	{
		Scanner S = new Scanner(System.in);
		System.out.println("Donner l'identifiant de l'utilisateur  :");
		String id = S.nextLine();
		System.out.println("Donner le mot de passe  :");
		String mdp = S.nextLine();
		System.out.println("Donner le nom :");
		String n = S.nextLine();
		System.out.println("Donner le prenom :");
		String p = S.nextLine();
		System.out.println("Donner l'adresse :");
		String adr = S.nextLine();
		System.out.println("Donner le numéro téléphonique  :");
		String numt = S.nextLine();
		
		
		 U = new Utilisateur(id,mdp,n,p,adr,numt);
		// ajouter l'utilisateur  dans la base:
		U.ajouterutilisateur_bd(U);
	}
	public static void ajouterCommande()
	{
		Scanner ac = new Scanner(System.in);
		System.out.println("Donner l'idantifiant de la commande  :");
		String idc = ac.nextLine();
		System.out.println("Donner le prix total:");
		double ttc = ac.nextDouble();
		System.out.println("Donner la date de commande /n nb:la forme de date(AAAA-MM-DD):");
		
		System.out.println("Donner l'annee");
		
		 int an= ac.nextInt();
		 System.out.println("Donner le mois");
		 int m= ac.nextInt();
		 System.out.println("Donner le jour");
		 int j= ac.nextInt();
		
		Date date =new Date(an,m,j);
		
		
		Commande c=new Commande(idc, ttc, date);
		
		// ajouter cette commande dans la base:
				c.ajouterCommande(c);
			
	}
	public static void ajouterLivre() 
	
	{Scanner S = new Scanner(System.in);
	System.out.println("Donner l'identifiant de livre  :");
	String id_l = S.nextLine();
	System.out.println("Donner le titre  :");
	String t = S.nextLine();
	System.out.println("Donner le nom de l'auteur:");
	String n = S.nextLine();
	System.out.println("Donner le prix unitaire de livre :");
	double p = S.nextDouble();
	System.out.println("Donner la quantité de stock:");
	int q = S.nextInt();
	System.out.println("Donner la date de realisation /n nb:la forme de date(AAAA-MM-DD):");
	System.out.println("Donner l'annee");
	 int a= S.nextInt();
	 System.out.println("Donner le mois");
	 int m= S.nextInt();
	 System.out.println("Donner le jour");
	 int j= S.nextInt();
	
	Date d =new Date(a,m,j);
	
	
	 Livre l= new Livre(id_l,t,n,p,q,d);
	// ajouter livre dans la base:
	l.ajouterlivre_bd(l);
}

	public static void supprimer_livre()
	{
		Scanner ac = new Scanner(System.in);
		System.out.println("Donner l'idantifiant de livre   :");
		String idL = ac.nextLine();
		Livre.supplivre(idL);
		
	}
	public static void ajouter_ligneCommande(Commande O)
	{
		// on affiche tous les Books:
		System.out.println("Liste des livres :");
		Livre.touslivres();
		
		Scanner s = new Scanner(System.in);
		System.out.println("Choisir Id livre :");
		String Id_liv = s.nextLine();
		
		System.out.println("Choisir Id de cette ligne de commande :");
		String id_Lc = s.nextLine();
		System.out.println("Donner Quantite :");
		int quantite = s.nextInt();
		
		// creer une instance de type LineOrder:
		LigneC lc = new LigneC(id_Lc, quantite,Id_liv );
		Livre l = null;
		// ajouter cette instance dans la base:
		
		LigneC.ajouterligne_commande(id_Lc, quantite, l);
	}
	
	
		   public static void main(String[] args)
		   {

	     Scanner s = new Scanner(System.in);
	     
	     System.out.println("bienvenu dans notre application console, Merci de choisir votre mode d'utilisation:\n");
	     System.out.println("tapez : 1 pour un administrateur \t OU \t 2 pour un simple utilisateur ");
	     int session = s.nextInt();
			      if(session ==1)
			      {  
			    	  System.out.println("Bienvenu Admin \n");
			    	  
			     A1 = new Administrateur("admin1", "AA", "bb", "Rue y", "56", "+21654000"); //creation d'un admin
			    	    System.out.println("*** Menu Administrateur ***");
			    		System.out.println("1. Créer un utilisateur");
			    		System.out.println("2. Afficher la liste des utilisateurs");
			    		System.out.println("3. Ajouter un livre");
			    		System.out.println("4. Supprimer tous les livres ");
			    		System.out.println("5. Supprimer un livre ");
			    		System.out.println("6. Afficher la liste des livres ");
			    		System.out.println("7. Modifier un livre ");
			    	  
			    		Scanner c = new Scanner(System.in);
			    		System.out.println("Taper votre choix:");
			    		int choix = c.nextInt();
			    		switch(choix)
			    		{
			    		case 1: ajouterUtilisateur();break;
			    		case 2: Utilisateur.toutUtilisateur();break;
			    		case 3:ajouterLivre();break; //
			    		case 4:Livre.suppttlivres(); break;
			    		case 5:supprimer_livre();break; 
			    		case 6:Livre.touslivres();break;
			    		
			    		}
		   	  
			      }
			      else if(session ==2)
			    	  
			      {  
			    	  System.out.println("BienVenu");
			      
			      
			      
			         System.out.println("*** Menu Utilisateur ***");
			         
			         System.out.println("1. Crée une commande"); // y compris les lignes de order
			         System.out.println("2. Afficher la liste des commandes ");
			         
			     	Scanner a = new Scanner(System.in);
		    		System.out.println("Taper votre choix:");
		    		int choixU = a.nextInt();
		    		switch(choixU)
		    		{
		    		case 1: ajouterCommande(); break;
		    		case 2: Commande.tousCommande(); break;
		    		}
			  
		   }
			      
			      else  System.out.println("au revoir ");
		       
		    }


	}

