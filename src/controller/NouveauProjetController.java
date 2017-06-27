package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JOptionPane;

import model.DBAccess;
import view.Inscription;
import view.NouveauProjet;

public class NouveauProjetController {
	

	NouveauProjet viewCallback;

	public NouveauProjetController(NouveauProjet viewCallback) {
		this.viewCallback = viewCallback;
	}
	

	public class ValiderButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			if((viewCallback.nom_projet.getText().length()
					*viewCallback.objectif.getText().length()
					*viewCallback.budget.getText().length())==0){
				JOptionPane.showMessageDialog(viewCallback.getContentPane(), "Veuillez remplir tous les champs.");
				return;
			}
				
			
			try {
							
				DBAccess.query("INSERT INTO projet (nom, objectif, materiel_requis, licences_logiciels, budget, utilisateur_id)"
				+"VALUES ('"+viewCallback.nom_projet.getText()
				+"','"+viewCallback.objectif.getText()
				+"','"+viewCallback.materiel.getText()
				+"','"+viewCallback.licence.getText()
				+"','"+Integer.parseInt(viewCallback.budget.getText())
				+"','"+((DBAccess.session==null)? 1:DBAccess.session.getId())+"');");
				
				// project added successfully, let's close that window.
				viewCallback.dispose();
				
				
				
			} catch (SQLException e1) {
				String errorMsg = "Données incorrectes! ";
				if(e1.getMessage().toUpperCase().contains("DUPLICATE"))
					errorMsg = "Login déjà utilisé.";
				JOptionPane.showMessageDialog(viewCallback.getContentPane(), errorMsg);
				e1.printStackTrace();
			}catch (NumberFormatException nfe){
				JOptionPane.showMessageDialog(viewCallback.getContentPane(), "Budget incorrect.");
				nfe.printStackTrace();
			}
			
			
			
		}
	}

}
