package connexionBD;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	

	public class Mycnx {
		
		    public static Connection c =null;
		   
		    public Mycnx() throws ClassNotFoundException, SQLException
		    
		    {
		    	
		    	Class.forName("com.mysql.jdbc.Driver");
		    
		    	   String url = "jdbc:mysql://localhost:3306/bookstore_db";
		    	
		    	   c =  DriverManager.getConnection(url,"root","root");
		           if(c==null) {
		        	   System.out.println("erreur dans la cnx");
		           }
		           else {
		        	  
		        		   System.out.println("bienvenu") ;
		        		   }
		         
		           
		    }
		    public static int exeucterReqMiseAJour(String requete) throws SQLException {
		    	PreparedStatement pstmt=c.prepareStatement(requete);
				return pstmt.executeUpdate();
		    }
		    
		    public static ResultSet exeucterReqConsult(String requete) throws SQLException {
		    	PreparedStatement pstmt=c.prepareStatement(requete);
				return pstmt.executeQuery();
		    }
	}




