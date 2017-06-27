package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Projet {
	
	private int id;
	private String nom;
	private String objectif;
	private String materielRequis;
	private String licencesLogiciels;
	private Date date;
	private int budget; // en MAD
	private Etat validationPertinence ;
	private Etat validationBudget ;
	private List<Tache> taches;
	private Utilisateur utilisateur; // used id
	
	
	
	public Projet(int id,String nom, String objectif, String materiel_requis, String licences_logiciels, Date date, int budget,
			Etat validation_pertinence, Etat validation_budget, List<Tache> taches, Utilisateur utilisateur) {
		super();
		this.id = id;
		this.nom = nom;
		this.objectif = objectif;
		this.materielRequis = materiel_requis;
		this.licencesLogiciels = licences_logiciels;
		this.date = date;
		this.budget = budget;
		this.validationPertinence = validation_pertinence;
		this.validationBudget = validation_budget;
		if(taches!=null)
			this.taches = taches;
		else
			this.taches = new ArrayList<>();
		this.utilisateur = utilisateur;
	}
	
	public Projet(ResultSet result) throws SQLException{
		this.id = result.getInt("projet_id");
		this.nom = result.getString("nom");
		this.objectif = result.getString("objectif");
		this.materielRequis = result.getString("materiel_requis");
		this.licencesLogiciels = result.getString("licences_logiciels");
		this.date = result.getDate("date");
		this.budget = result.getInt("budget");
		this.validationPertinence = etat(result.getString("validation_pertinence"));
		this.validationBudget = etat(result.getString("validation_budget"));
		ResultSet u =
				DBAccess.con.createStatement().executeQuery("SELECT * FROM utilisateur WHERE utilisateur_id="
							+result.getInt("utilisateur_id"));
		u.next();
		this.utilisateur = new Utilisateur(u);
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
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getObjectif() {
		return objectif;
	}
	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}
	public String getMaterielRequis() {
		return materielRequis;
	}
	public void setMaterielRequis(String materielRequis) {
		this.materielRequis = materielRequis;
	}
	public String getLicencesLogiciels() {
		return licencesLogiciels;
	}
	public void setLicencesLogiciels(String licencesLogiciels) {
		this.licencesLogiciels = licencesLogiciels;
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
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	@Override
	public String toString() {
		return "Projet [id=" + id + ", objectif=" + objectif + ", materiel_requis=" + materielRequis
				+ ", licences_logiciels=" + licencesLogiciels + ", date=" + date + ", budget=" + budget
				+ ", validationPertinence=" + validationPertinence + ", validationBudget=" + validationBudget
				+ ", taches=" + taches + ", utilisateur_id=" + utilisateur + "]";
	}







	public enum Etat {
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
