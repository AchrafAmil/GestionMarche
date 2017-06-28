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
		frmInscription.getContentPane().setBackground(new Color(0, 128, 128));
		frmInscription.setTitle("Inscription");
		frmInscription.setBounds(350, 100, 650, 450);
		frmInscription.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmInscription.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Formlaire d'inscription", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		panel.setBounds(10, 11, 614, 389);
		frmInscription.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel.setBounds(20, 34, 73, 31);
		panel.add(lblNewLabel);
		lblService.setBounds(20, 125, 73, 31);
		panel.add(lblService);
		lblService.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 19));
		
		JLabel label = new JLabel("Service");
		label.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 20));
		label.setBounds(20, 76, 73, 31);
		panel.add(label);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 19));
		lblLogin.setBounds(20, 174, 73, 31);
		panel.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 19));
		lblPassword.setBounds(20, 216, 87, 31);
		panel.add(lblPassword);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Cambria", Font.PLAIN, 18));
		nameField.setBounds(104, 34, 488, 31);
		panel.add(nameField);
		nameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Cambria", Font.PLAIN, 18));
		passwordField.setBounds(104, 216, 488, 31);
		panel.add(passwordField);
		
		loginField = new JTextField();
		loginField.setFont(new Font("Cambria", Font.PLAIN, 18));
		loginField.setColumns(10);
		loginField.setBounds(104, 174, 488, 31);
		panel.add(loginField);
		
		rdbtnDirecteur = new JRadioButton("Directeur");
		rdbtnDirecteur.setBackground(new Color(255, 255, 255));
		rdbtnDirecteur.setFont(new Font("Cambria", Font.PLAIN, 16));
		rdbtnDirecteur.setBounds(133, 129, 109, 23);
		panel.add(rdbtnDirecteur);
		
		rdbtnChef = new JRadioButton("Chef de Service");
		rdbtnChef.setBackground(new Color(255, 255, 255));
		rdbtnChef.setFont(new Font("Cambria", Font.PLAIN, 16));
		rdbtnChef.setBounds(273, 129, 131, 23);
		panel.add(rdbtnChef);
		
		rdbtnEmployer = new JRadioButton("Employe");
		rdbtnEmployer.setBackground(new Color(255, 255, 255));
		rdbtnEmployer.setFont(new Font("Cambria", Font.PLAIN, 16));
		rdbtnEmployer.setBounds(462, 129, 109, 23);
		panel.add(rdbtnEmployer);
		
		bG = new ButtonGroup();
		bG.add(rdbtnEmployer);
		bG.add(rdbtnChef);
		bG.add(rdbtnDirecteur);
		
		serviceField = new JTextField();
		serviceField.setFont(new Font("Cambria", Font.PLAIN, 18));
		serviceField.setColumns(10);
		serviceField.setBounds(104, 77, 488, 31);
		panel.add(serviceField);
		
		JButton btnVider = new JButton("Vider");
		btnVider.setBackground(new Color(47, 79, 79));
		btnVider.setFont(new Font("Cambria Math", Font.BOLD, 18));
		btnVider.setForeground(Color.WHITE);
		btnVider.setBounds(345, 295, 169, 40);
		btnVider.addActionListener(controller.new ViderButtonListener());
		panel.add(btnVider);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setForeground(Color.WHITE);
		btnValider.setBackground(new Color(46, 139, 87));
		btnValider.setFont(new Font("Cambria", Font.BOLD, 18));
		btnValider.setBounds(133, 295, 169, 41);
		btnValider.addActionListener(controller.new ValiderButtonListener());
		panel.add(btnValider);
		
		
	}
}
