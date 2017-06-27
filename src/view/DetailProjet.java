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
	
	private JMenuBar menuBar = new JMenuBar();
	private JMenuItem nouveau = new JMenuItem("Nouveau");
	private JMenuItem projet = new JMenuItem("Liste projets");
	private JMenuItem tache = new JMenuItem("T\u00E2ches");
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
		setTitle("Extra Project Informations");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		menuBar.setBounds(0, 0, 561, 24);
		contentPane.add(menuBar);
		
		
		menuBar.setForeground(Color.LIGHT_GRAY);
		menuBar.setBackground(Color.LIGHT_GRAY);
		menuBar.setBorderPainted(false);
		
		
		projet.setHorizontalAlignment(SwingConstants.LEFT);
		projet.setBackground(SystemColor.activeCaption);
		projet.setFont(new Font("Calibri", Font.BOLD, 15));
		menuBar.add(projet);
		
		
		nouveau.setHorizontalAlignment(SwingConstants.LEFT);
		nouveau.setBackground(SystemColor.activeCaption);
		nouveau.setFont(new Font("Calibri", Font.BOLD, 15));
		menuBar.add(nouveau);
		
		
		tache.setHorizontalAlignment(SwingConstants.LEFT);
		tache.setBackground(SystemColor.activeCaption);
		tache.setFont(new Font("Calibri", Font.BOLD, 15));
		menuBar.add(tache);
		
		JMenuItem deconnexion = new JMenuItem("Se d\u00E9connecter");
		menuBar.add(deconnexion);
		deconnexion.setHorizontalAlignment(SwingConstants.LEFT);
		deconnexion.setBackground(SystemColor.activeCaption);
		deconnexion.setFont(new Font("Calibri", Font.BOLD, 15));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Detail Projet", TitledBorder.LEFT, TitledBorder.TOP, null, SystemColor.desktop));
		panel.setBounds(31, 35, 823, 394);
		contentPane.add(panel);
		panel.setLayout(null);
		lblNomDuProjet.setFont(new Font("Calibri", Font.BOLD, 17));
		lblNomDuProjet.setBounds(13, 39, 128, 38);
		
		panel.add(lblNomDuProjet);
		nom_projet.setEditable(false);
		nom_projet.setBounds(134, 48, 248, 20);
		nom_projet.setColumns(10);
		nom_projet.setText(p.getNom());
		
		panel.add(nom_projet);
		lblNomEmployer.setFont(new Font("Calibri", Font.BOLD, 17));
		lblNomEmployer.setBounds(429, 39, 112, 38);
		
		panel.add(lblNomEmployer);
		nom_employer.setEditable(false);
		nom_employer.setColumns(10);
		nom_employer.setBounds(551, 48, 248, 20);
		nom_employer.setText(p.getUtilisateur().getNom() +" ("+p.getUtilisateur().getLogin()+")");
		
		panel.add(nom_employer);
		lblObjectif.setFont(new Font("Calibri", Font.BOLD, 17));
		lblObjectif.setBounds(13, 88, 128, 38);
		
		panel.add(lblObjectif);
		objectif.setEditable(false);
		objectif.setColumns(10);
		objectif.setBounds(134, 97, 248, 20);
		objectif.setText(p.getObjectif());
		
		panel.add(objectif);
		lblMatrielRequis.setFont(new Font("Calibri", Font.BOLD, 17));
		lblMatrielRequis.setBounds(13, 137, 128, 38);
		
		panel.add(lblMatrielRequis);
		
		JTextArea materiel = new JTextArea();
		materiel.setBackground(Color.WHITE);
		materiel.setEditable(false);
		materiel.setBounds(134, 128, 248, 61);
		panel.add(materiel);
		materiel.setText(p.getMaterielRequis());
		
		JLabel lblLicencesLogiciels = new JLabel("Licences Logiciels");
		lblLicencesLogiciels.setFont(new Font("Calibri", Font.BOLD, 17));
		lblLicencesLogiciels.setBounds(424, 137, 128, 38);
		panel.add(lblLicencesLogiciels);
		
		JTextArea licence = new JTextArea();
		licence.setEditable(false);
		licence.setBounds(552, 144, 248, 61);
		panel.add(licence);
		licence.setText(p.getLicencesLogiciels());
		
		JLabel lblDure = new JLabel("Crée le");
		lblDure.setFont(new Font("Calibri", Font.BOLD, 17));
		lblDure.setBounds(13, 220, 128, 38);
		panel.add(lblDure);
		
		duree = new JTextField();
		duree.setEditable(false);
		duree.setColumns(10);
		duree.setBounds(134, 229, 248, 20);
		panel.add(duree);
		duree.setText(p.getDate().toGMTString());
		
		JLabel lblEstimationBudget = new JLabel("Budget Estim\u00E9");
		lblEstimationBudget.setFont(new Font("Calibri", Font.BOLD, 17));
		lblEstimationBudget.setBounds(424, 220, 150, 38);
		panel.add(lblEstimationBudget);
		
		budget = new JTextField();
		budget.setEditable(false);
		budget.setColumns(10);
		budget.setBounds(551, 229, 248, 20);
		panel.add(budget);
		budget.setText(p.getBudget()+" MAD");
		
		lblValidationDePertinence.setFont(new Font("Calibri", Font.BOLD, 17));
		lblValidationDePertinence.setBounds(305, 287, 223, 20);
		
		panel.add(lblValidationDePertinence);
		btnValiderPertinence.setFont(new Font("Calibri", Font.BOLD, 15));
		btnValiderPertinence.setForeground(new Color(255, 255, 255));
		btnValiderPertinence.setBackground(new Color(46, 139, 87));
		btnValiderPertinence.setBounds(265, 328, 99, 29);
		
		panel.add(btnValiderPertinence);
		btnRefuserPertinence.setFont(new Font("Calibri", Font.BOLD, 15));
		btnRefuserPertinence.setForeground(new Color(255, 255, 255));
		btnRefuserPertinence.setBackground(new Color(255, 0, 0));
		btnRefuserPertinence.setBounds(429, 328, 99, 29);
		
		panel.add(btnRefuserPertinence);
		
		controller = new DetailProjetController(this);
	}
}