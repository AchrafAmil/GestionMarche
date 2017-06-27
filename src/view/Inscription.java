package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import controller.InscriptionController;
import model.DBAccess;

import javax.swing.UIManager;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;

public class Inscription {

	public JPanel panel;
	public JFrame frmInscription;
	final JLabel lblService = new JLabel("R\u00F4le");
	public JTextField nameField;
	public JPasswordField passwordField;
	public ButtonGroup bG;
	public JTextField loginField;
	public JTextField serviceField;
	private InscriptionController controller = new InscriptionController(this);
	public JRadioButton rdbtnDirecteur;
	public JRadioButton rdbtnChef;
	public JRadioButton rdbtnEmployer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inscription window = new Inscription();
					window.frmInscription.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Inscription() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInscription = new JFrame();
		frmInscription.setTitle("Inscription");
		frmInscription.setBounds(100, 100, 450, 300);
		frmInscription.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmInscription.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Formlaire d'inscription", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		panel.setBounds(10, 11, 414, 236);
		frmInscription.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 28, 73, 31);
		panel.add(lblNewLabel);
		lblService.setBounds(10, 90, 73, 31);
		panel.add(lblService);
		lblService.setFont(new Font("Calibri", Font.PLAIN, 17));
		
		JLabel label = new JLabel("Service");
		label.setFont(new Font("Calibri", Font.PLAIN, 17));
		label.setBounds(10, 57, 73, 31);
		panel.add(label);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblLogin.setBounds(10, 123, 73, 31);
		panel.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblPassword.setBounds(10, 155, 73, 31);
		panel.add(lblPassword);
		
		nameField = new JTextField();
		nameField.setBounds(93, 34, 298, 20);
		panel.add(nameField);
		nameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(93, 161, 298, 20);
		panel.add(passwordField);
		
		loginField = new JTextField();
		loginField.setColumns(10);
		loginField.setBounds(93, 129, 298, 20);
		panel.add(loginField);
		
		rdbtnDirecteur = new JRadioButton("Directeur");
		rdbtnDirecteur.setBounds(90, 95, 109, 23);
		panel.add(rdbtnDirecteur);
		
		rdbtnChef = new JRadioButton("Chef");
		rdbtnChef.setBounds(195, 95, 99, 23);
		panel.add(rdbtnChef);
		
		rdbtnEmployer = new JRadioButton("Employé");
		rdbtnEmployer.setBounds(296, 95, 109, 23);
		panel.add(rdbtnEmployer);
		
		bG = new ButtonGroup();
		bG.add(rdbtnEmployer);
		bG.add(rdbtnChef);
		bG.add(rdbtnDirecteur);
		
		serviceField = new JTextField();
		serviceField.setColumns(10);
		serviceField.setBounds(93, 62, 298, 20);
		panel.add(serviceField);
		
		JButton btnVider = new JButton("Vider");
		btnVider.setBackground(SystemColor.activeCaption);
		btnVider.setFont(new Font("Cambria Math", Font.BOLD, 18));
		btnVider.setForeground(Color.WHITE);
		btnVider.setBounds(304, 192, 89, 31);
		btnVider.addActionListener(controller.new ViderButtonListener());
		panel.add(btnVider);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setForeground(Color.WHITE);
		btnValider.setBackground(SystemColor.activeCaption);
		btnValider.setFont(new Font("Cambria", Font.BOLD, 18));
		btnValider.setBounds(185, 192, 99, 31);
		btnValider.addActionListener(controller.new ValiderButtonListener());
		panel.add(btnValider);
		
		
	}
}
