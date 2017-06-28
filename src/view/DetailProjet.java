package view;

import java.awt.EventQueue;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import java.awt.SystemColor;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import controller.DetailProjetController;
import model.Projet;

import javax.swing.UIManager;
import java.awt.Color;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DetailProjet extends JFrame {

	private JPanel contentPane;
	
	public Projet p;
	
	private DetailProjetController controller;
	private final JLabel lblNomDuProjet = new JLabel("Nom du projet");
	private final JLabel lblNomEmployer = new JLabel("Nom Employer");
	private final JTextField nom_projet = new JTextField();
	private final JTextField nom_employer = new JTextField();
	private final JLabel lblObjectif = new JLabel("Objectif");
	private final JTextField objectif = new JTextField();
	private final JLabel lblMatrielRequis = new JLabel("Mat\u00E9riel Requis");
	private JTextField duree;
	private JTextField budget;
	public final JLabel lblValidationDePertinence = new JLabel("Validation de pertinence");
	public final JButton btnValiderPertinence = new JButton("Valider");
	public final JButton btnRefuserPertinence = new JButton("Refuser");

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetailProjet frame = new DetailProjet(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public DetailProjet(Projet p) {
		this.p = p;
		setTitle("D\u00E9tail du Projet S\u00E9lectionn\u00E9");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setForeground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Detail Projet", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel.setBounds(112, 36, 671, 394);
		contentPane.add(panel);
		panel.setLayout(null);
		lblNomDuProjet.setForeground(new Color(255, 255, 255));
		lblNomDuProjet.setFont(new Font("Candara", Font.BOLD, 19));
		lblNomDuProjet.setBounds(13, 39, 128, 38);
		
		panel.add(lblNomDuProjet);
		nom_projet.setBackground(new Color(255, 255, 255));
		nom_projet.setEditable(false);
		nom_projet.setBounds(161, 44, 457, 29);
		nom_projet.setColumns(10);
		nom_projet.setText(p.getNom());
		
		panel.add(nom_projet);
		lblNomEmployer.setForeground(new Color(255, 255, 255));
		lblNomEmployer.setFont(new Font("Candara", Font.BOLD, 19));
		lblNomEmployer.setBounds(13, 79, 128, 38);
		
		panel.add(lblNomEmployer);
		nom_employer.setBackground(new Color(255, 255, 255));
		nom_employer.setEditable(false);
		nom_employer.setColumns(10);
		nom_employer.setBounds(161, 84, 457, 29);
		nom_employer.setText(p.getUtilisateur().getNom() +" ("+p.getUtilisateur().getLogin()+")");
		
		panel.add(nom_employer);
		lblObjectif.setForeground(new Color(255, 255, 255));
		lblObjectif.setFont(new Font("Candara", Font.BOLD, 19));
		lblObjectif.setBounds(13, 113, 128, 38);
		
		panel.add(lblObjectif);
		objectif.setBackground(new Color(255, 255, 255));
		objectif.setEditable(false);
		objectif.setColumns(10);
		objectif.setBounds(161, 124, 457, 29);
		objectif.setText(p.getObjectif());
		
		panel.add(objectif);
		lblMatrielRequis.setForeground(new Color(255, 255, 255));
		lblMatrielRequis.setFont(new Font("Candara", Font.BOLD, 19));
		lblMatrielRequis.setBounds(13, 155, 128, 38);
		
		panel.add(lblMatrielRequis);
		
		JTextArea materiel = new JTextArea();
		materiel.setBackground(Color.WHITE);
		materiel.setEditable(false);
		materiel.setBounds(43, 189, 260, 61);
		panel.add(materiel);
		materiel.setText(p.getMaterielRequis());
		
		JLabel lblLicencesLogiciels = new JLabel("Licences Logiciels");
		lblLicencesLogiciels.setForeground(new Color(255, 255, 255));
		lblLicencesLogiciels.setFont(new Font("Candara", Font.BOLD, 19));
		lblLicencesLogiciels.setBounds(342, 155, 155, 38);
		panel.add(lblLicencesLogiciels);
		
		JTextArea licence = new JTextArea();
		licence.setBackground(new Color(255, 255, 255));
		licence.setEditable(false);
		licence.setBounds(370, 189, 248, 61);
		panel.add(licence);
		licence.setText(p.getLicencesLogiciels());
		
		JLabel lblDure = new JLabel("Cree le");
		lblDure.setForeground(new Color(255, 255, 255));
		lblDure.setFont(new Font("Candara", Font.BOLD, 19));
		lblDure.setBounds(13, 261, 128, 38);
		panel.add(lblDure);
		
		duree = new JTextField();
		duree.setBackground(new Color(255, 255, 255));
		duree.setEditable(false);
		duree.setColumns(10);
		duree.setBounds(107, 266, 196, 29);
		panel.add(duree);
		duree.setText(p.getDate().toGMTString());
		
		JLabel lblEstimationBudget = new JLabel("Budget Estim\u00E9");
		lblEstimationBudget.setForeground(new Color(255, 255, 255));
		lblEstimationBudget.setFont(new Font("Candara", Font.BOLD, 19));
		lblEstimationBudget.setBounds(342, 261, 150, 38);
		panel.add(lblEstimationBudget);
		
		budget = new JTextField();
		budget.setBackground(new Color(255, 255, 255));
		budget.setEditable(false);
		budget.setColumns(10);
		budget.setBounds(468, 266, 150, 29);
		panel.add(budget);
		budget.setText(p.getBudget()+" MAD");
		lblValidationDePertinence.setForeground(new Color(255, 255, 255));
		
		lblValidationDePertinence.setFont(new Font("Candara", Font.BOLD, 19));
		lblValidationDePertinence.setBounds(32, 338, 223, 20);
		
		panel.add(lblValidationDePertinence);
		btnValiderPertinence.setFont(new Font("Calibri", Font.BOLD, 19));
		btnValiderPertinence.setForeground(new Color(255, 255, 255));
		btnValiderPertinence.setBackground(new Color(46, 139, 87));
		btnValiderPertinence.setBounds(265, 328, 139, 38);
		
		panel.add(btnValiderPertinence);
		btnRefuserPertinence.setFont(new Font("Calibri", Font.BOLD, 19));
		btnRefuserPertinence.setForeground(new Color(255, 255, 255));
		btnRefuserPertinence.setBackground(new Color(255, 0, 0));
		btnRefuserPertinence.setBounds(414, 328, 139, 38);
		
		panel.add(btnRefuserPertinence);
		
		controller = new DetailProjetController(this);
	}
}