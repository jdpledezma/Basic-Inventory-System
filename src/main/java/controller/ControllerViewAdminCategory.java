package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.ModelCategory;
import view.ViewAdminCategory;

public class ControllerViewAdminCategory implements ActionListener{
	ViewAdminCategory viewAdminCategory = new ViewAdminCategory();
	ModelCategory modelCategory;
	
	public ControllerViewAdminCategory (ViewAdminCategory viewAdminCategory ) {
		this.viewAdminCategory = viewAdminCategory;
		modelCategory = new ModelCategory();
		this.viewAdminCategory.getAddCategoryBtn().addActionListener(this);
		this.viewAdminCategory.getDeleteCategoryBtn().addActionListener(this);
	}
	
	public void renderTable() throws SQLException {
		String[] category = new String[2];
		viewAdminCategory.getTableModelCategory().setRowCount(0);; 
		ResultSet data = (ResultSet) modelCategory.getAllCategory();
		  while(data.next()) {
			  category[0] = data.getString(1);
			  category[1] = data.getString(2);
			  viewAdminCategory.getTableModelCategory().addRow(category);  
		  }
		  
		  viewAdminCategory.getTableCategory().setModel(viewAdminCategory.getTableModelCategory());
	}
	
	public void showScreen() throws SQLException {
		renderTable();
		viewAdminCategory.setSize(500,370);
		viewAdminCategory.setDefaultCloseOperation(2);
		viewAdminCategory.setLocationRelativeTo(null);
		viewAdminCategory.setResizable(false);
		viewAdminCategory.setVisible(true);
	}
	
	public void addCategory() throws SQLException {
		String name = viewAdminCategory.getNameCategoryTxt().getText();
		boolean category_check = modelCategory.searchCategory(name);
		if(category_check) {
			JOptionPane.showMessageDialog(null, "Sorry. Category Already registered");
		}
		modelCategory.addCategory(name);
		JOptionPane.showMessageDialog(null, "Category Added.");
		renderTable();
	}
	
	public void deleteCategory() throws SQLException {
		String name = viewAdminCategory.getNameCategoryTxt().getText();
		boolean user_check = modelCategory.searchCategory(name);
		if(user_check) {
			modelCategory.deleteCategory(name);
			JOptionPane.showMessageDialog(null, "Category Deleted");
			renderTable();
		}else {
			JOptionPane.showMessageDialog(null, "Sorry. Category Not found");
		}
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == viewAdminCategory.getAddCategoryBtn()) {
			try {
				addCategory();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == viewAdminCategory.getDeleteCategoryBtn()) {
			try {
				deleteCategory();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

}
