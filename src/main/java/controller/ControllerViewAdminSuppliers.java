package controller;

import model.ModelSupplier;
import view.ViewAdminSuppliers;

public class ControllerViewAdminSuppliers {
	ViewAdminSuppliers viewAdminSuppliers = new ViewAdminSuppliers();
	ModelSupplier modelSupplier;
	
	public ControllerViewAdminSuppliers(ViewAdminSuppliers viewAdminSuppliers) {
		this.viewAdminSuppliers = viewAdminSuppliers;
		modelSupplier = new ModelSupplier();
	}
	
	public void showScreen() {
		viewAdminSuppliers.setSize(570,450);
		viewAdminSuppliers.setDefaultCloseOperation(2);
		viewAdminSuppliers.setLocationRelativeTo(null);
		viewAdminSuppliers.setResizable(false);
		viewAdminSuppliers.setVisible(true);
	}
	

	
	
}
