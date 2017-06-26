package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Commentaire {

	private int id;
	private Utilisateur utilisateur;	// used id
	private String text;
	private Priorite priorite;
	
	public Commentaire(int id, Utilisateur utilisateur, String text, Priorite priorite) {
		super();
		this.id = id;
		this.utilisateur = utilisateur;
		this.text = text;
		this.priorite = priorite;
	}

	public Commentaire(ResultSet result) throws SQLException{
		this.id = result.getInt("commentaire_id");
		int utilisateur_id = result.getInt("utilisateur_id");
		ResultSet u =
				DBAccess.con.createStatement().executeQuery("SELECT * FROM utilisateur WHERE utilisateur_id="+utilisateur_id);
		u.next();
		this.utilisateur = new Utilisateur(u);
		this.text = result.getString("text");
		this.priorite = priorite(result.getString("priorite"));
		
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public Priorite getPriorite() {
		return priorite;
	}


	public void setPriorite(Priorite priorite) {
		this.priorite = priorite;
	}
	
	
	

	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", utilisateur_id=" + utilisateur + ", text=" + text + ", priorite="
				+ priorite + "]";
	}




	enum Priorite {
		URGENT, QUOTIDIEN, INFORMATIF
	}
	
	public static Priorite priorite(String p){
		switch(p){
		case "URGENT":
			return Priorite.URGENT;
		case "QUOTIDIEN":
			return Priorite.QUOTIDIEN;
		case "INFORMATIF":
			return Priorite.INFORMATIF;
		default:
			return Priorite.QUOTIDIEN;
		}
	}
	
	
	
}
