package view;

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

import controller.NouveauProjetController;

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

public class NouveauProjet extends JFrame {

	private JPanel contentPane;
	
	private NouveauProjetController controller = new NouveauProjetController(this);
	
	public JMenuBar menuBar = new JMenuBar();
	public JMenuItem nouveau = new JMenuItem("Nouveau");
	public JMenuItem projet = new JMenuItem("Liste projets");
	public JMenuItem tache = new JMenuItem("T\u00E2ches");
	public final JLabel lblNomDuProjet = new JLabel("Nom du projet");
	public final JTextField nom_projet = new JTextField();
	public final JLabel lblObjectif = new JLabel("Objectif");
	public final JTextField objectif = new JTextField();
	public final JLabel lblMatrielRequis = new JLabel("Mat\u00E9riel Requis");
	public JTextField budget;
	public JTextArea materiel;
	public JTextArea licence;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NouveauProjet frame = new NouveauProjet();
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
	public NouveauProjet() {
		setTitle("Nouveau Projet");
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
		panel.setBorder(new TitledBorder(null, "Nouveau Projet", TitledBorder.LEFT, TitledBorder.TOP, null, SystemColor.desktop));
		panel.setBounds(31, 35, 823, 394);
		contentPane.add(panel);
		panel.setLayout(null);
		lblNomDuProjet.setFont(new Font("Calibri", Font.BOLD, 17));
		lblNomDuProjet.setBounds(13, 39, 128, 38);
		
		panel.add(lblNomDuProjet);
		nom_projet.setBounds(134, 48, 248, 20);
		nom_projet.setColumns(10);
		
		panel.add(nom_projet);
		lblObjectif.setFont(new Font("Calibri", Font.BOLD, 17));
		lblObjectif.setBounds(414, 39, 128, 38);
		
		panel.add(lblObjectif);
		objectif.setColumns(10);
		objectif.setBounds(552, 48, 248, 20);
		
		panel.add(objectif);
		lblMatrielRequis.setFont(new Font("Calibri", Font.BOLD, 17));
		lblMatrielRequis.setBounds(13, 107, 128, 38);
		
		panel.add(lblMatrielRequis);
		
		materiel = new JTextArea();
		materiel.setBounds(134, 114, 248, 61);
		panel.add(materiel);
		
		JLabel lblLicencesLogiciels = new JLabel("Licences Logiciels");
		lblLicencesLogiciels.setFont(new Font("Calibri", Font.BOLD, 17));
		lblLicencesLogiciels.setBounds(414, 107, 128, 38);
		panel.add(lblLicencesLogiciels);
		
		licence = new JTextArea();
		licence.setBounds(552, 114, 248, 61);
		panel.add(licence);
		
		JLabel lblEstimationBudget = new JLabel("Budget Estim\u00E9");
		lblEstimationBudget.setFont(new Font("Calibri", Font.BOLD, 17));
		lblEstimationBudget.setBounds(192, 207, 150, 38);
		panel.add(lblEstimationBudget);
		
		budget = new JTextField();
		budget.setColumns(10);
		budget.setBounds(315, 216, 248, 20);
		panel.add(budget);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setBounds(223, 306, 135, 57);
		btnNewButton.addActionListener(controller.new ValiderButtonListener());
		panel.add(btnNewButton);
		
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NouveauProjet.this.dispose();
			}
		});
		btnAnnuler.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 18));
		btnAnnuler.setBounds(470, 306, 135, 57);
		panel.add(btnAnnuler);
	}
}
