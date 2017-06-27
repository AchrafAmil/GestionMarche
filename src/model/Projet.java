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
	private Etat validationPertinence ;
	private Etat validationBudget ;
	private List<Tache> taches;
	int utilisateur_id; // used id
	
	
	
	public Projet(int id, String objectif, String materiel_requis, String licences_logiciels, Date date, int budget,
			Etat validation_pertinence, Etat validation_budget, List<Tache> taches, int utilisateur_id) {
		super();
		this.id = id;
		this.objectif = objectif;
		this.materiel_requis = materiel_requis;
		this.licences_logiciels = licences_logiciels;
		this.date = date;
		this.budget = budget;
		this.validationPertinence = validation_pertinence;
		this.validationBudget = validation_budget;
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
		this.validationPertinence = etat(result.getString("validation_pertinence"));
		this.validationBudget = etat(result.getString("validation_budget"));
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
	
	public Etat getValidationPertinence() {
		return validationPertinence;
	}

	public void setValidationPertinence(Etat validationPertinence) {
		this.validationPertinence = validationPertinence;
	}

	public Etat getValidationBudget() {
		return validationBudget;
	}

	public void setValidationBudget(Etat validationBudget) {
		this.validationBudget = validationBudget;
	}

	public List<Tache> getTaches() {
		return taches;
	}
	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}
	public int getUtilisateurId() {
		return utilisateur_id;
	}
	public void setUtilisateurId(int from) {
		this.utilisateur_id = from;
	}


	@Override
	public String toString() {
		return "Projet [id=" + id + ", objectif=" + objectif + ", materiel_requis=" + materiel_requis
				+ ", licences_logiciels=" + licences_logiciels + ", date=" + date + ", budget=" + budget
				+ ", validationPertinence=" + validationPertinence + ", validationBudget=" + validationBudget
				+ ", taches=" + taches + ", utilisateur_id=" + utilisateur_id + "]";
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
