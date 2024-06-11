package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.ModelUser;
import view.ViewAdmin;
import view.ViewEmployee;
import view.ViewLogin;

public class ControllerLogin implements ActionListener {

	ViewLogin viewLogin = new ViewLogin();
	ModelUser modelUser; 
	
	public ControllerLogin(ViewLogin viewLogin) {
		this.viewLogin = viewLogin;
		this.viewLogin.getSubmitBtn().addActionListener((ActionListener) this);
		modelUser = new ModelUser();
	}
	
	
	public void showScreen() {
		viewLogin.setSize(300,400);
		viewLogin.setDefaultCloseOperation(3);
		viewLogin.setLocationRelativeTo(null);
		viewLogin.setResizable(false);
		viewLogin.setVisible(true);
	}
	
	public void verifyUser() throws SQLException {
		String username = viewLogin.getUsernameTxt().getText();
		String password = viewLogin.getPasswordTxt().getText();
		ResultSet data = (ResultSet) modelUser.userVerify(username, password);
		String [] user = new String[3]; 
		
		
		while(data.next()) {		
			user[0] = data.getString(1);
			user[1] = data.getString(2);
			user[2] = data.getString(3);
		}
		
		if(user[0] == null) {
			JOptionPane.showMessageDialog(null, "Sorry. User not Found");
			clearInputs();
			return;
		}
		
		if(user[2].equals("admin")) {
			viewLogin.dispose();
			JOptionPane.showMessageDialog(null, "Welcome Admin");
			ViewAdmin viewAdmin = new ViewAdmin();
			ControllerViewAdmin controllerAdmin = new ControllerViewAdmin(viewAdmin);
			controllerAdmin.showScreen();
		}else if(user[2].equals("employee")) {
			viewLogin.dispose();
			JOptionPane.showMessageDialog(null, "Welcome Employee");
			ViewEmployee viewEmployee = new ViewEmployee();
			ControllerViewEmployee controllerEmployee = new ControllerViewEmployee(viewEmployee);
			controllerEmployee.showScreen();
			
		}
	}
	
	public void clearInputs() {
		viewLogin.getUsernameTxt().setText("");
		viewLogin.getPasswordTxt().setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == viewLogin.getSubmitBtn()) {
			try {
				verifyUser();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	


	
}