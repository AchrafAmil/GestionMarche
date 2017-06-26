package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import model.Commentaire.Priorite;

public class Tache {

	private int id;
	private int num;
	private String description;
	private Date deadline;
	private int duree; // nombre de jours
	private Etat etat;
	private List<Commentaire> commentaires;
		
	public Tache(int id, int num, String description, Date deadline, int duree, Etat etat,
			List<Commentaire> commentaires) {
		super();
		this.id = id;
		this.num = num;
		this.description = description;
		this.deadline = deadline;
		this.duree = duree;
		this.etat = etat;
		if(commentaires!=null)
			this.commentaires = commentaires;
		else
			this.commentaires = new ArrayList<>();
	}

	public Tache(ResultSet result) throws SQLException{
		this.id = result.getInt("tache_id");
		this.num = result.getInt("num");
		this.description = result.getString("description");
		this.deadline = result.getDate("deadline");
		this.duree = result.getInt("duree");
		this.etat = etat(result.getString("etat"));
		this.commentaires = new ArrayList<>();
		ResultSet coms =
				DBAccess.con.createStatement().executeQuery("SELECT * FROM commentaire WHERE tache_id="+this.id);
		while(coms.next())
			this.commentaires.add(new Commentaire(coms));
	}
	
	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public int getNum() {
		return num;
	}




	public void setNum(int num) {
		this.num = num;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public Date getDeadline() {
		return deadline;
	}




	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}




	public int getDuree() {
		return duree;
	}




	public void setDuree(int duree) {
		this.duree = duree;
	}




	public Etat getEtat() {
		return etat;
	}




	public void setEtat(Etat etat) {
		this.etat = etat;
	}




	public List<Commentaire> getCommentaires() {
		return commentaires;
	}




	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	@Override
	public String toString() {
		return "Tache [id=" + id + ", num=" + num + ", description=" + description + ", deadline=" + deadline
				+ ", duree=" + duree + ", etat=" + etat + ", commentaires=" + commentaires + "]";
	}




	enum Etat {
		EN_ATTENTE, VALIDE, NON_VALIDE
	}
	

	public static Etat etat(String e){
		switch(e){
		case "EN_ATTENTE":
			return Etat.EN_ATTENTE;
		case "VALIDE":
			return Etat.VALIDE;
		case "NON_VALIDE":
			return Etat.NON_VALIDE;
		default:
			return Etat.EN_ATTENTE;
		}
	}
	
	
}
