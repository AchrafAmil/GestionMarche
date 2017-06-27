package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import model.DBAccess;
import model.Utilisateur;
import model.Projet.Etat;
import model.Utilisateur.Role;
import view.DetailProjet;
import view.NouveauProjet;

public class DetailProjetController {
	
	DetailProjet viewCallback;

	public DetailProjetController(DetailProjet viewCallback) {
		this.viewCallback = viewCallback;
		if(DBAccess.session.getRole()==Role.EMPLOYE){
			this.viewCallback.lblValidationDePertinence.setVisible(false);
			this.viewCallback.btnValiderPertinence.setVisible(false);
			this.viewCallback.btnRefuserPertinence.setVisible(false);
		}else{
			this.viewCallback.btnValiderPertinence.addActionListener(new ValiderListener());
			this.viewCallback.btnRefuserPertinence.addActionListener(new refuserListener());
			if(DBAccess.session.getRole()==Role.CHEF){
				if(viewCallback.p.getValidationPertinence()==Etat.EN_ATTENTE){
					this.viewCallback.lblValidationDePertinence.setText("Valider la pertinence?");
				}else{
					this.viewCallback.lblValidationDePertinence.setText(
							"Pertinence: "+viewCallback.p.getValidationPertinence().toString());
					this.viewCallback.btnValiderPertinence.setVisible(false);
					this.viewCallback.btnRefuserPertinence.setVisible(false);
				}
				
			}else{

				if(viewCallback.p.getValidationPertinence()==Etat.VALIDE){
					if(viewCallback.p.getValidationBudget()==Etat.EN_ATTENTE){
						this.viewCallback.lblValidationDePertinence.setText("Valider le budget?");
					}else{
						this.viewCallback.lblValidationDePertinence.setText(
								"Budget: "+viewCallback.p.getValidationBudget().toString());
						this.viewCallback.btnValiderPertinence.setVisible(false);
						this.viewCallback.btnRefuserPertinence.setVisible(false);
					}
				}else{
					this.viewCallback.lblValidationDePertinence.setText(
							"Pertinence: "+viewCallback.p.getValidationPertinence().toString());
					this.viewCallback.btnValiderPertinence.setVisible(false);
					this.viewCallback.btnRefuserPertinence.setVisible(false);
				}
				
			}
		}
	}
	
	public class ValiderListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(DBAccess.session.getRole().equals(Utilisateur.Role.CHEF))
				try {
					DBAccess.validerPertinence(viewCallback.p, true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			else
				if(DBAccess.session.getRole().equals(Utilisateur.Role.DIRECTEUR))
					try {
						DBAccess.validerBudget(viewCallback.p, true);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
			viewCallback.dispose();
		}
	}
	
	public class refuserListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(DBAccess.session.getRole().equals(Utilisateur.Role.CHEF))
				try {
					DBAccess.validerPertinence(viewCallback.p, false);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			else
				if(DBAccess.session.getRole().equals(Utilisateur.Role.DIRECTEUR))
					try {
						DBAccess.validerBudget(viewCallback.p, false);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
			viewCallback.dispose();
		}
	}

}
