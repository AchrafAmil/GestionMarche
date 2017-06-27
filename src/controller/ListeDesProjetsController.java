package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import controller.ListeDesProjetsController.NouveaProjetButtonListener;
import model.DBAccess;
import model.Projet;
import view.Inscription;
import view.ListeDesProjets;
import view.NouveauProjet;

public class ListeDesProjetsController {
	
	ListeDesProjets viewCallback;
	DefaultTableModel tableModel;

	public ListeDesProjetsController(ListeDesProjets viewCallback) {
		this.viewCallback = viewCallback;
		tableModel =  (DefaultTableModel) viewCallback.getTable().getModel();
		fillTable();
		viewCallback.getTable().addMouseListener((new ListeDesProjetsSelectionListener()));

        viewCallback.btnNouveauProjet.addActionListener(new NouveaProjetButtonListener());
			
	}

	public void fillTable(){
		clearTable();
		List<Projet> projets;
		try {
			projets = DBAccess.getProjects();
			for(Projet p : projets){
				addRow(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void clearTable(){
		if (tableModel.getRowCount() > 0) {
		    for (int i = tableModel.getRowCount() - 1; i > -1; i--) {
		    	tableModel.removeRow(i);
		    }
		}
	}
	
	public void addRow(Projet p){
		tableModel.addRow(new Object[]{p.getNom(), p.getUtilisateur().getNom(), p.getObjectif(), p.getBudget()+""});
	}

	
	
	public class ListeDesProjetsSelectionListener extends MouseAdapter{
		
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			if (e.getClickCount() == 2) { // check if a double click
				System.out.println(viewCallback.getTable().getValueAt(viewCallback.getTable().getSelectedRow(), 0).toString());
			     }
		}
    }
	
	public class NouveaProjetButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			NouveauProjet projetWindow = new NouveauProjet();
			projetWindow.setVisible(true);
			projetWindow.addWindowListener(new WindowListener() {
				@Override
	            public void windowClosing(WindowEvent e)
	            {
	                System.out.println("Closing");
	                e.getWindow().dispose();
	            }
				@Override
				public void windowOpened(WindowEvent e) {

	                System.out.println("opened");
					
				}
				
				@Override
				public void windowIconified(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowDeiconified(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowDeactivated(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowClosed(WindowEvent e) {

	                System.out.println("Closed");
	                fillTable();
					
				}
				
				@Override
				public void windowActivated(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}
	}
	
	
	

}
