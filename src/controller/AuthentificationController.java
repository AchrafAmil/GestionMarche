package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.DBAccess;
import model.Utilisateur;
import view.Authentification;
import view.Inscription;
import view.ListeDesProjets;

public class AuthentificationController {
	
	Authentification viewCallback;
	
	public AuthentificationController(Authentification viewCallback) {
		this.viewCallback = viewCallback;
	}

	public class LoginButtonListener implements ActionListener{
		
		JTextField loginCallback;
		JPasswordField passCallback;
		JPanel panel;
		
		public LoginButtonListener(JTextField login, JPasswordField pass, JPanel panel) {
			loginCallback = login;
			passCallback = pass;
		}
		
		public void actionPerformed(ActionEvent arg0) {
			try {
				Utilisateur user = 
						DBAccess.login(loginCallback.getText(), passCallback.getText());
				if (user==null){
					JOptionPane.showMessageDialog(panel, "Login/Password incorrect(s)");
					return;
				}

				DBAccess.session = user;
			
				(new ListeDesProjets()).setVisible(true);
				
				viewCallback.dispose();

				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public class SinscrireButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			(new Inscription()).frmInscription.setVisible(true);
		}
	}
}
