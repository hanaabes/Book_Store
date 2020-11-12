
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import com.mysql.jdbc.ResultSet;

import connexionBD.Mycnx;

public class Commande {
	
	
	 private Vector<LigneC> lc = new Vector<LigneC>();
     private static Mycnx connect;
     
     //les attributs 
		private String ref;
		private  double prixttc;
		private Date datecommande;
		 
	//constructeur 
		public Commande(String r, double d , Date date){
		    
		    this.prixttc= d;
		    this.ref=r;
		    this.datecommande=date;
		}
		
    // les getters + les setters
	    public Date getDatecommande() {
			return datecommande;
		}

		public void setDatecommande(Date datecommande) {
			this.datecommande = datecommande;
		}

		public double getPrixttc() {
			return prixttc;
		}

		public String getRef() {
			return ref;
		}



		public void setRef(String ref) {
			this.ref = ref;
		}

		public void setPrixttc(double prix) {
			this.prixttc = prix;
		}
		
		// les méthodes d'affichage
		
		
		public String toString() 
		{
			return "Commande [ref=" + ref + ", \t prixttc=" + prixttc + ", \t datecommande=" + datecommande + "]";
		}
		
		
		 public void afficher()
		 {
			 for(int i=0; i<lc.size(); i++)
			 {
				 System.out.println(lc.elementAt(i));
			 }
			 System.out.println(" la commande de ref "+getRef()+"ayant un montant total egal à"+calculerttc()+"\n la date de commande :"+getDatecommande());
		   }
		 
         // calculer le total des achats
		
		public double calculerttc(){
		    double ttc=0;
		    for(int i=0; i<lc.size(); i++)
		    {
		    	ttc+=lc.elementAt(i).calculer(lc.elementAt(i).getLivre(),lc.elementAt(i).getQuantite());}
		    
		    return ttc ;
           }		

		
		 
		 public void ajouter_ligneCo(LigneC d)
		 {
			 
			 {lc.addElement(d);}
			 
		 }
		 
		//lancer la cnx au bd
			private static void lancerConnection() throws ClassNotFoundException, SQLException {
				
					connect = new Mycnx();}
			
			//l'ajout dans la base de donnes
			
		public static int ajouterCommande(Commande c ) {
				try {
					lancerConnection();
					String requete = " INSERT INTO `order`(`ref_Order`,`prix_ttc`,`date_order`) VALUES('"+c.getRef()+"', '"+c.getPrixttc() +"',' " +c.getDatecommande()+ "')";
				
					Mycnx.exeucterReqMiseAJour(requete);
					return 1;
				} catch (Exception e) {
					System.out.println(e.getMessage());
					return 0;
				}
			}
		
		//l'affichage à partir de la base de données de tous les commandes
		
		public static Vector<Commande> tousCommande() {
			Vector<Commande> tc = new Vector<Commande>();
			try {
				lancerConnection();
				String requete = "SELECT * FROM `order`";
				ResultSet rss = (ResultSet) Mycnx.exeucterReqConsult(requete);
				while(rss.next()) {
					tc.addElement(new Commande(rss.getString(1), rss.getDouble(2), rss.getDate(3)));
				}
				
				for(int i=0;i<tc.size();i++)
				{
					 System.out.println(tc.elementAt(i));
				}
				return tc;
			} catch(Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
		}
		 
		 
		 
		 }



