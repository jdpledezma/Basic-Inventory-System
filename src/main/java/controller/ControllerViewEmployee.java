package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ViewEmployee;
import view.ViewEmployeeSale;

public class ControllerViewEmployee implements ActionListener{
	ViewEmployee viewEmployee = new ViewEmployee();
	
	public ControllerViewEmployee(ViewEmployee viewEmployee) {
		this.viewEmployee = viewEmployee;
		this.viewEmployee.getSaleBtn().addActionListener(this);
	}
	
	public void showScreen() {
		viewEmployee.setTitle("Menu Employees");
		viewEmployee.setSize(820,600);
		viewEmployee.setLocationRelativeTo(null);
		viewEmployee.setDefaultCloseOperation(3);
		viewEmployee.setResizable(false);
		viewEmployee.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == viewEmployee.getSaleBtn()) {
			ViewEmployeeSale viewEmployeeSale = new ViewEmployeeSale();
			ControllerViewEmployeeSale controllerViewEmployeeSale = new ControllerViewEmployeeSale(viewEmployeeSale);
			controllerViewEmployeeSale.showScreen();
		}
		
	}
	
}
