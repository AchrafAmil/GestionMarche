package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.AuthentificationController;
import model.DBAccess;
import model.Utilisateur;

public class Authentification extends JFrame {

	private JPanel contentPane;
	private JTextField txtAuthentification;
	private JTextField loginField;
	private JPasswordField passwordField;
	private AuthentificationController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentification frame = new Authentification();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Authentification() {
		controller = new AuthentificationController(this);
		setTitle("Authentification");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 5, 414, 74);
		panel.setToolTipText("");
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		txtAuthentification = new JTextField();
		txtAuthentification.setForeground(new Color(255, 255, 255));
		txtAuthentification.setFont(new Font("Britannic Bold", Font.PLAIN, 38));
		txtAuthentification.setBackground(SystemColor.activeCaption);
		txtAuthentification.setEditable(false);
		txtAuthentification.setText("  Authentification");
		panel.add(txtAuthentification);
		txtAuthentification.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblLogin.setBounds(30, 129, 78, 28);
		contentPane.add(lblLogin);
		
		loginField = new JTextField();
		loginField.setBounds(118, 134, 293, 20);
		contentPane.add(loginField);
		loginField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblPassword.setBounds(30, 168, 78, 16);
		contentPane.add(lblPassword);
		
		JLabel lblEntrerVotreLogin = new JLabel("Entrer votre login et password");
		lblEntrerVotreLogin.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 16));
		lblEntrerVotreLogin.setBounds(20, 90, 299, 20);
		contentPane.add(lblEntrerVotreLogin);
		
		JButton btnSinscrire = new JButton("S'inscrire");
		btnSinscrire.addActionListener((controller.new SinscrireButtonListener()) );
		btnSinscrire.setFont(new Font("Cambria", Font.BOLD, 18));
		btnSinscrire.setBounds(283, 212, 141, 38);
		contentPane.add(btnSinscrire);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(118, 167, 293, 20);
		contentPane.add(passwordField);
		
		JButton btnSeConnecter = new JButton("Se Connecter");
		btnSeConnecter.setFont(new Font("Cambria", Font.BOLD, 18));
		btnSeConnecter.addActionListener( (controller.new LoginButtonListener(loginField, passwordField, contentPane)) );
		btnSeConnecter.setBounds(118, 212, 155, 38);
		contentPane.add(btnSeConnecter);
	}
}
