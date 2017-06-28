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
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 0, 0));
		panel.setBackground(new Color(0, 139, 139));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Nouveau Projet", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel.setBounds(102, 32, 671, 397);
		contentPane.add(panel);
		panel.setLayout(null);
		lblNomDuProjet.setForeground(new Color(255, 255, 255));
		lblNomDuProjet.setFont(new Font("Candara", Font.BOLD, 19));
		lblNomDuProjet.setBounds(23, 39, 128, 38);
		
		panel.add(lblNomDuProjet);
		nom_projet.setBackground(new Color(255, 255, 255));
		nom_projet.setForeground(new Color(0, 0, 0));
		nom_projet.setFont(new Font("Cambria", Font.PLAIN, 18));
		nom_projet.setBounds(180, 48, 457, 29);
		nom_projet.setColumns(10);
		
		panel.add(nom_projet);
		lblObjectif.setForeground(new Color(255, 255, 255));
		lblObjectif.setFont(new Font("Candara", Font.BOLD, 19));
		lblObjectif.setBounds(23, 79, 128, 38);
		
		panel.add(lblObjectif);
		objectif.setForeground(new Color(0, 0, 0));
		objectif.setBackground(new Color(255, 255, 255));
		objectif.setFont(new Font("Cambria", Font.PLAIN, 18));
		objectif.setColumns(10);
		objectif.setBounds(180, 88, 457, 29);
		
		panel.add(objectif);
		lblMatrielRequis.setForeground(new Color(255, 255, 255));
		lblMatrielRequis.setBackground(new Color(255, 255, 255));
		lblMatrielRequis.setFont(new Font("Candara", Font.BOLD, 19));
		lblMatrielRequis.setBounds(23, 141, 128, 38);
		
		panel.add(lblMatrielRequis);
		
		materiel = new JTextArea();
		materiel.setForeground(new Color(0, 0, 0));
		materiel.setBackground(new Color(255, 255, 255));
		materiel.setFont(new Font("Cambria", Font.PLAIN, 18));
		materiel.setBounds(180, 128, 457, 61);
		panel.add(materiel);
		
		JLabel lblLicencesLogiciels = new JLabel("Licences Logiciels");
		lblLicencesLogiciels.setForeground(new Color(255, 255, 255));
		lblLicencesLogiciels.setFont(new Font("Candara", Font.BOLD, 19));
		lblLicencesLogiciels.setBounds(23, 217, 150, 38);
		panel.add(lblLicencesLogiciels);
		
		licence = new JTextArea();
		licence.setForeground(new Color(0, 0, 0));
		licence.setBackground(new Color(255, 255, 255));
		licence.setFont(new Font("Cambria", Font.PLAIN, 18));
		licence.setBounds(180, 206, 457, 61);
		panel.add(licence);
		
		JLabel lblEstimationBudget = new JLabel("Budget Estim\u00E9");
		lblEstimationBudget.setForeground(new Color(255, 255, 255));
		lblEstimationBudget.setBackground(new Color(255, 255, 255));
		lblEstimationBudget.setFont(new Font("Candara", Font.BOLD, 19));
		lblEstimationBudget.setBounds(23, 273, 150, 38);
		panel.add(lblEstimationBudget);
		
		budget = new JTextField();
		budget.setBackground(new Color(255, 255, 255));
		budget.setForeground(new Color(0, 0, 0));
		budget.setFont(new Font("Calibri", Font.PLAIN, 18));
		budget.setColumns(10);
		budget.setBounds(180, 278, 457, 29);
		panel.add(budget);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setBounds(250, 342, 183, 38);
		btnNewButton.addActionListener(controller.new ValiderButtonListener());
		panel.add(btnNewButton);
		
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBackground(new Color(255, 255, 255));
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NouveauProjet.this.dispose();
			}
		});
		btnAnnuler.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 18));
		btnAnnuler.setBounds(451, 342, 183, 38);
		panel.add(btnAnnuler);
	}
}
