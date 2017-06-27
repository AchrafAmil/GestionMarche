package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.DBAccess;
import model.Projet;
import view.ListeDesProjets;

public class ListeDesProjetsController {
	
	ListeDesProjets viewCallback;
	DefaultTableModel tableModel;

	public ListeDesProjetsController(ListeDesProjets viewCallback) {
		this.viewCallback = viewCallback;
		tableModel =  (DefaultTableModel) viewCallback.getTable().getModel();
		List<Projet> projets;
		try {
			projets = DBAccess.getProjects();
			for(Projet p : projets){
				addRow(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		viewCallback.getTable().addMouseListener((new ListeDesProjetsSelectionListener()));
		
		
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
	
	
	

}
