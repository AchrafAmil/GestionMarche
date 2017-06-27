package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * THIS IS THE MEAN PORTAL FOR OUR APPLICATION MODEL.
 * 
 * HOW TO USE :
 * 		CONFIGURE DB:
 * 			You should have MySQL Connector J (JAVA ODBC). Add the jar file to your project as external library.
 * 			You should have the same DB we're using. Look at README for more details.
 * 			Change DB_LOGIN and DB_PASSWORD to fit your own DB credentials.
 * 
 * 		READ FROM DB :
*	  		call getUsers() or getProjects() to get all the data you will need to show (to pass to the View)
*	  			those two methods will get you an object oriented representation of the current database.
*
*		WRITE TO DB :
*			call query(String your_SQL_query) to do whatever changes you want to do to the database.
*           YOU WILL NEED TO RECALL getUsers() and getProjects() after each writing to get the new state of the database.
 * 
 * 
 * ENJOY RESPONSIBLY, MADE WITH LOVE BY ENSAK STUDENTS.
 */

public class DBAccess {

	private static final String DB_LOGIN = "root";
	private static final String DB_PASSWORD = "t0p0fthet0p";
	
	protected static Connection con;
	public static Utilisateur session;
	
	public static void setupConnection() throws SQLException{
		con =
				 DriverManager.getConnection("jdbc:mysql://localhost/gestion_marche?" +
				 "user="+DB_LOGIN+"&password="+DB_PASSWORD+"&autoReconnect=true&useSSL=false");
	}
	
	
	public static List<Utilisateur> getUsers() throws SQLException{
		if(con==null)
			setupConnection();
		
		ResultSet result = 
				con.createStatement().executeQuery("SELECT * FROM utilisateur");
		List<Utilisateur> users = new ArrayList<>();
		
		while(result.next())
			users.add(new Utilisateur(result));
		
		return users;
		
	}
	
	public static List<Projet> getProjects() throws SQLException{
		if(con==null)
			setupConnection();
		
		ResultSet result = 
				con.createStatement().executeQuery("SELECT * FROM projet");
		List<Projet> projects = new ArrayList<>();
		
		while(result.next())
			projects.add(new Projet(result));
		
		return projects;
		
	}
	
	public static boolean query(String q) throws SQLException{
		if(con==null)
			setupConnection();
		return con.createStatement().execute(q);
	}

	public static Utilisateur login(String login, String password) throws SQLException{
		if(con==null)
			setupConnection();
		
		ResultSet result = 
				con.createStatement().executeQuery("SELECT * FROM utilisateur WHERE login='"+login+"' AND password='"+password+"';");
		
		if(!result.next()) //empty query result
			return null; 
		
		return new Utilisateur(result.getInt("utilisateur_id"), result.getString("nom"), result.getString("login"),
				result.getString("password"), result.getString("service"), Utilisateur.role(result.getString("role")));
	}
	
	public static void validerPertinence(Projet p, boolean valider) throws SQLException{
		query("UPDATE projet SET validation_pertinence='"+
				(valider? "VALIDE":"NON_VALIDE")	
				+"' WHERE projet_id='"+p.getId()+"' ;");
	}
	
	public static void validerBudget(Projet p, boolean valider) throws SQLException{
		query("UPDATE projet SET validation_budget='"+
				(valider? "VALIDE":"NON_VALIDE")	
				+"' WHERE projet_id='"+p.getId()+"' ;");
	}
	
	
	/* NO MAIN METHOD IS MEANT TO BE DECLARED AT A MODEL CLASS, THIS IS JUST A DUMMY TEST OF OUR DB */
	
	public static void main(String[] args) {
		
		try {
			
			System.out.println(getUsers().toString());
			System.out.println(getProjects().toString());
			
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			 System.out.println("SQLState: " + ex.getSQLState());
			 System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		
		
		
		

	}

}
