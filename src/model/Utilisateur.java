package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Utilisateur {

	private int id;
	
	private String nom;
	
	private String login;
	
	private String password;
	
	private String service;
	
	private Role role;

	
	public Utilisateur(int id, String nom, String login, String password, String service, Role role) {
		super();
		this.id = id;
		this.nom = nom;
		this.login = login;
		this.password = password;
		this.service = service;
		this.role = role;
	}


	public Utilisateur(ResultSet result) throws SQLException{
		this.id = result.getInt("utilisateur_id");
		this.nom = result.getString("nom");
		this.login = result.getString("login");
		this.password = result.getString("password");
		this.service = result.getString("service");
		this.role = role(result.getString("role"));
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

	
	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getService() {
		return service;
	}




	public void setService(String service) {
		this.service = service;
	}




	public Role getRole() {
		return role;
	}




	public void setRole(Role role) {
		this.role = role;
	}




	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", service=" + service + ", role=" + role + "]";
	}




	enum Role {
		EMPLOYE, CHEF, DIRECTEUR
	}
	
	public static Role role(String r){
		switch(r){
			case "EMPLOYE":
				return Role.EMPLOYE;
			case "CHEF":
				return Role.CHEF;
			case "DIRECTEUR":
				return Role.DIRECTEUR;
			default:
				return Role.EMPLOYE;
		}
	}
	
	
}
