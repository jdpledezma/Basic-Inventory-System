package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ModelUser;
import view.ViewAdmin;
import view.ViewAdminCategory;
import view.ViewAdminProducts;
import view.ViewAdminSuppliers;
import view.ViewAdminUser;
import view.ViewLogin;

public class ControllerViewAdmin implements ActionListener {
	ViewAdmin viewAdmin = new ViewAdmin();
	ModelUser modelUser;
	
	public ControllerViewAdmin(ViewAdmin viewAdmin) {
		this.viewAdmin = viewAdmin;
		modelUser = new ModelUser();
		this.viewAdmin.getProductsBtn().addActionListener(this);
		this.viewAdmin.getUserBtn().addActionListener(this);
		this.viewAdmin.getExitBtn().addActionListener(this);
		this.viewAdmin.getCategoryBtn().addActionListener(this);
	
	}
	
	public void showScreen() throws SQLException {
		viewAdmin.setTitle("Menu Admin");
		viewAdmin.setSize(820,600);
		viewAdmin.setLocationRelativeTo(null);
		viewAdmin.setDefaultCloseOperation(3);
		viewAdmin.setResizable(false);
		viewAdmin.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == viewAdmin.getProductsBtn()){
			ViewAdminProducts viewAdminProducts = new ViewAdminProducts();
			ControllerViewAdminProducts controllerViewAdminProducts = new ControllerViewAdminProducts(viewAdminProducts);
			try {
				controllerViewAdminProducts.showScreen();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == viewAdmin.getUserBtn()) {
			ViewAdminUser viewAdminUser = new ViewAdminUser();
			ControllerViewAdminUser controllerViewAdminUser = new ControllerViewAdminUser(viewAdminUser);
			try {
				controllerViewAdminUser.showScreen();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		if(e.getSource() == viewAdmin.getCategoryBtn()) {
			ViewAdminCategory viewAdminCategory = new ViewAdminCategory();
			ControllerViewAdminCategory controllerViewAdminCategory = new ControllerViewAdminCategory(viewAdminCategory);
			try {
				controllerViewAdminCategory.showScreen();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == viewAdmin.getSuppliersBtn()) {
			ViewAdminSuppliers viewAdminSuppliers = new ViewAdminSuppliers();
			ControllerViewAdminSuppliers controllerViewAdminSuppliers = new ControllerViewAdminSuppliers(viewAdminSuppliers);
			controllerViewAdminSuppliers.showScreen();
		}
		
		if(e.getSource() == viewAdmin.getExitBtn()) {
			viewAdmin.dispose();
			ViewLogin viewLogin = new ViewLogin();
			ControllerLogin controllerLogin = new ControllerLogin(viewLogin);
			controllerLogin.showScreen();
		}
	}

}
