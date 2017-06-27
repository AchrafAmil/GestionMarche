package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.DBAccess;
import view.Inscription;

public class InscriptionController {

	Inscription viewCallback;
	
	public InscriptionController(Inscription viewCallback) {
		this.viewCallback = viewCallback;
	}

	public class ViderButtonListener implements ActionListener{
		
		
		public ViderButtonListener() {
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			viewCallback.loginField.setText("");
			viewCallback.nameField.setText("");
			viewCallback.passwordField.setText("");
			viewCallback.serviceField.setText("");
			viewCallback.bG.clearSelection();
		}
	}
	
	public class ValiderButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String role = (viewCallback.rdbtnEmployer.isSelected())?		"EMPLOYE":
									((viewCallback.rdbtnDirecteur.isSelected())?		"DIRECTEUR":
										((viewCallback.rdbtnChef.isSelected())?		"CHEF":""));
			if(role.equals("")){
				JOptionPane.showMessageDialog(viewCallback.panel, "Veuillez choisir un role.");
				return;
			}
			if((viewCallback.loginField.getText().length()
					*viewCallback.passwordField.getText().length()
					*viewCallback.nameField.getText().length()
					*viewCallback.serviceField.getText().length())==0){
				JOptionPane.showMessageDialog(viewCallback.panel, "Veuillez remplir tous les champs.");
				return;
			}
				
			
			try {
							
				DBAccess.query("INSERT INTO utilisateur (login,password,nom,service,role)"
				+"VALUES ('"+viewCallback.loginField.getText()+"','"+viewCallback.passwordField.getText()+"','"+viewCallback.nameField.getText()
				+"','"+viewCallback.serviceField.getText()+"','"+role+"');");
				
				// user added successfully, let's close that window.
				viewCallback.frmInscription.dispose();
				
			} catch (SQLException e1) {
				String errorMsg = "Données incorrectes! ";
				if(e1.getMessage().toUpperCase().contains("DUPLICATE"))
					errorMsg = "Login déjà utilisé.";
				JOptionPane.showMessageDialog(viewCallback.panel, errorMsg);
				e1.printStackTrace();
			}
			
		}
	}
	
}
