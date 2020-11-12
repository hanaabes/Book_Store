import java.util.Vector;

public class Commande {

		private String ref;
		private  double prixttc;
		
        private Vector<LigneC> lc = new Vector<LigneC>();
		
		
		//constructeur 
		
		Commande(String r, double d){
		    
		    this.prixttc= d;
		    this.ref=r;
		}
		

	//getters + setters
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



		
		// les methodes 
		
		public double calculerttc(){
		    double ttc=0;
		    for(int i=0; i<lc.size(); i++)
		    {
		    	ttc+=lc.elementAt(i).calculer(lc.elementAt(i).getProduit(),lc.elementAt(i).getQuantite());}
		    
		    return ttc ;
           }		

		 public void afficher()
		 {
			 for(int i=0; i<lc.size(); i++)
			 {
				 System.out.println(lc.elementAt(i));
			 }
			 System.out.println(" la commande de ref "+getRef()+"ayant un montant total egal à"+calculerttc()+"\n");
		   }
		 
		 
		 public void ajouter_ligneCo(LigneC d)
		 {
			 
			 {lc.addElement(d);}
			 
		 }
		 }




