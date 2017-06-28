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
import javax.swing.SwingConstants;

public class Authentification extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
		setBounds(350, 100, 650, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(150, 34, 350, 345);
		contentPane.add(panel);
		panel.setLayout(null);
		
		loginField = new JTextField();
		loginField.setBounds(30, 117, 287, 28);
		panel.add(loginField);
		loginField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		loginField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(30, 158, 95, 26);
		panel.add(lblPassword);
		lblPassword.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 20));
		
		JButton btnSeConnecter = new JButton("Se Connecter");
		btnSeConnecter.setForeground(new Color(255, 255, 255));
		btnSeConnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSeConnecter.setBounds(98, 240, 154, 31);
		panel.add(btnSeConnecter);
		btnSeConnecter.setBackground(new Color(32, 178, 170));
		btnSeConnecter.setFont(new Font("Cambria", Font.BOLD, 18));
		
		JButton btnSinscrire = new JButton("S'inscrire");
		btnSinscrire.setForeground(new Color(255, 255, 255));
		btnSinscrire.setBounds(98, 282, 154, 31);
		panel.add(btnSinscrire);
		btnSinscrire.setBackground(new Color(0, 128, 128));
		btnSinscrire.addActionListener((controller.new SinscrireButtonListener()) );
		btnSinscrire.setFont(new Font("Cambria", Font.BOLD, 18));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(30, 183, 287, 28);
		panel.add(passwordField);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSeConnecter.addActionListener( (controller.new LoginButtonListener(loginField, passwordField, contentPane)) );
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(30, 95, 69, 26);
		panel.add(lblLogin);
		lblLogin.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 20));
		
		
		JLabel lblAuthentification = new JLabel("Authentification");
		lblAuthentification.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 35));
		lblAuthentification.setBounds(45, 27, 257, 39);
		panel.add(lblAuthentification);
	}
}
