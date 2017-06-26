package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Projet {
	
	private int id;
	private String objectif;
	private String materiel_requis;
	private String licences_logiciels;
	private Date date;
	private int budget; // en MAD
	private List<Tache> taches;
	int utilisateur_id; // used id
	
	public Projet(int id, String objectif, String materiel_requis, String licences_logiciels, Date date, int budget,
			List<Tache> taches, int utilisateur_id) {
		super();
		this.id = id;
		this.objectif = objectif;
		this.materiel_requis = materiel_requis;
		this.licences_logiciels = licences_logiciels;
		this.date = date;
		this.budget = budget;
		if(taches!=null)
			this.taches = taches;
		else
			this.taches = new ArrayList<>();
		this.utilisateur_id = utilisateur_id;
	}
	
	public Projet(ResultSet result) throws SQLException{
		this.id = result.getInt("projet_id");
		this.objectif = result.getString("objectif");
		this.materiel_requis = result.getString("materiel_requis");
		this.licences_logiciels = result.getString("licences_logiciels");
		this.date = result.getDate("date");
		this.budget = result.getInt("budget");
		this.utilisateur_id = result.getInt("utilisateur_id");
		this.taches = new ArrayList<>();
		ResultSet t =
				DBAccess.con.createStatement().executeQuery("SELECT * FROM tache WHERE projet_id="+this.id);
		while(t.next())
			this.taches.add(new Tache(t));
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getObjectif() {
		return objectif;
	}
	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}
	public String getMateriel_requis() {
		return materiel_requis;
	}
	public void setMateriel_requis(String materiel_requis) {
		this.materiel_requis = materiel_requis;
	}
	public String getlicences_logiciels() {
		return licences_logiciels;
	}
	public void setlicences_logiciels(String licences_logiciels) {
		this.licences_logiciels = licences_logiciels;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	public List<Tache> getTaches() {
		return taches;
	}
	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}
	public int getFrom() {
		return utilisateur_id;
	}
	public void setFrom(int from) {
		this.utilisateur_id = from;
	}

	@Override
	public String toString() {
		return "Projet [id=" + id + ", objectif=" + objectif + ", materiel_requis=" + materiel_requis
				+ ", licences_logiciels=" + licences_logiciels + ", date=" + date + ", budget=" + budget + ", taches="
				+ taches + ", utilisateur_id=" + utilisateur_id + "]";
	}
	
	
	
	
}
