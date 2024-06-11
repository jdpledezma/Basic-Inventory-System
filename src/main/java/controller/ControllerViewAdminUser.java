package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.ModelUser;
import view.ViewAdminUser;

public class ControllerViewAdminUser implements ActionListener{
	ViewAdminUser viewAdminUser = new ViewAdminUser();
	ModelUser modelUser;
	
	public ControllerViewAdminUser(ViewAdminUser viewAdminUser ) {
		this.viewAdminUser = viewAdminUser;
		modelUser = new ModelUser();
		this.viewAdminUser.getAddBtn().addActionListener(this);
		this.viewAdminUser.getDeleteBtn().addActionListener(this);
		this.viewAdminUser.getEditBtn().addActionListener(this);
		this.viewAdminUser.getSearchBtn().addActionListener(this);
	}
	
	public void showScreen() throws SQLException {
		renderTable();
		viewAdminUser.setSize(550,550);
		viewAdminUser.setDefaultCloseOperation(2);
		viewAdminUser.setLocationRelativeTo(null);
		viewAdminUser.setResizable(false);
		viewAdminUser.setVisible(true);
	}
	
	public void renderTable() throws SQLException{
		String[] user = new String[7];
		viewAdminUser.getTableModelUser().setRowCount(0);
		ResultSet data = (ResultSet) modelUser.getAllUsers();
		  while(data.next()) {
			  user[0] = data.getString(1);
			  user[1] = data.getString(2);
			  user[2] = data.getString(3);
			  user[3] = data.getString(4);
			  viewAdminUser.getTableModelUser().addRow(user);  
		  }
		  
		  viewAdminUser.getTableUser().setModel(viewAdminUser.getTableModelUser());
	}
	
	public void addUser() throws SQLException {
		String username = viewAdminUser.getUsernameTxt().getText();
		String password = viewAdminUser.getPasswordTxt().getText();
		String usertype = (String) viewAdminUser.getUserTypeCombo().getSelectedItem();
		boolean user_check = modelUser.searchUser(username);
		
		if(username.isEmpty() || password.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Sorry. Complete the fields");
			return;
		}
		
		if(user_check) {
			JOptionPane.showMessageDialog(null, "Sorry. User Already registered");
			return;
		}else {
			modelUser.addUser(username, password, usertype);
			JOptionPane.showMessageDialog(null, "User Registered");
			renderTable();
		}
	}
	
	public void deleteUser() throws SQLException {
		String username = viewAdminUser.getUsernameTxt().getText();
		boolean user_check = modelUser.searchUser(username);
		if(user_check) {
			modelUser.deleteUser(username);
			JOptionPane.showMessageDialog(null, "User Deleted");
			renderTable();
		}else {
			JOptionPane.showMessageDialog(null, "Sorry. User Not found");
		}
	}
	
	public void editUser() throws SQLException {
		String username = viewAdminUser.getUsernameTxt().getText();
		String password = viewAdminUser.getPasswordTxt().getText();
		String usertype = (String) viewAdminUser.getUserTypeCombo().getSelectedItem();
		String ID = viewAdminUser.getIDtxt().getText();
		
		if(username.isEmpty() || password.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Sorry. Complete the fields");
			return;
		}
		modelUser.editUser(username, password, usertype,ID);
		JOptionPane.showMessageDialog(null, "User Update");
		renderTable();
	
	}
	
	public void getUser() {
		try {
	    String username = viewAdminUser.getUsernameTxt().getText();
	    if(username.isEmpty()) {
	    	JOptionPane.showMessageDialog(null, "Complete Search Field");
	    	return;
	    }
	    ResultSet user = modelUser.getUser(username);
	    if(user.next()) {
	    	viewAdminUser.getIDtxt().setText(user.getString("id"));
	    	viewAdminUser.getPasswordTxt().setText(user.getString("password"));
	    }else {
	    	JOptionPane.showMessageDialog(null, "Sorry.User Not Found");
	    }
	    	
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == viewAdminUser.getAddBtn()) {
			try {
				addUser();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource() == viewAdminUser.getEditBtn()) {
			try {
				editUser();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		
		if(e.getSource() == viewAdminUser.getDeleteBtn()) {
			try {
				deleteUser();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource() == viewAdminUser.getSearchBtn()) {
			getUser();
		}
	}

}
