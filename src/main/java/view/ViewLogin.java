package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;


public class ViewLogin extends JFrame {
	private JTextField usernameTxt;
    private  JPasswordField passwordTxt;
    private JButton submitBtn;
    private JDialog dialog = new JDialog();

    public ViewLogin(){
        Font font = new Font("Dialog",Font.BOLD,18);
        Font fontUserPass = new Font("Dialog",Font.BOLD,15);

        JLabel titleLogin = new JLabel("Welcome to the Registry",SwingConstants.CENTER);
        titleLogin.setBounds(0,5,300,50);
        titleLogin.setFont(font);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(0,25,300,400);
        mainPanel.setLayout(null);

        JLabel username = new JLabel("Username");
        username.setBounds(110,0,150,100);
        username.setFont(fontUserPass);

        usernameTxt = new JTextField(5);
        usernameTxt.setBounds(80,70,150,50);

        JLabel password = new JLabel("Password");
        password.setBounds(110,90,100,100);
        password.setFont(fontUserPass);

        passwordTxt = new JPasswordField(5);
        passwordTxt.setBounds(80,160,150,50);

        submitBtn = new JButton("Submit");
        submitBtn.setBounds(100,230,100,30);

        mainPanel.add(username);
        mainPanel.add(usernameTxt);
        mainPanel.add(password);
        mainPanel.add(passwordTxt);
        mainPanel.add(submitBtn);


        getContentPane().setLayout(null);
        getContentPane().add(titleLogin);
        getContentPane().add(mainPanel);
    }

    public void successMessage(String title){

        dialog.setLayout(new FlowLayout());

        JLabel information = new JLabel(String.valueOf(SwingConstants.CENTER));
        information.setText("Wait a seconds...");
        dialog.add(information);

        dialog.setTitle(title);
        dialog.setSize(400,150);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    public void exitMessages(){
        dialog.dispose();
    }

    public void errorMessage(String title){

        dialog.setLayout(new BorderLayout());

        JLabel information = new JLabel(String.valueOf(SwingConstants.CENTER));
        information.setText("Credentials Invalid or User not Found");
        dialog.add(information);

        dialog.setTitle(title);
        dialog.setSize(400,150);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    public JTextField getUsernameTxt() {
        return usernameTxt;
    }

    public void setUsernameTxt(JTextField usernameTxt) {
        this.usernameTxt = usernameTxt;
    }

    public JPasswordField getPasswordTxt() {
        return passwordTxt;
    }

    public void setPasswordTxt(JPasswordField passwordTxt) {
        this.passwordTxt = passwordTxt;
    }

    public JButton getSubmitBtn() {
        return submitBtn;
    }

    public void setSubmitBtn(JButton submitBtn) {
        this.submitBtn = submitBtn;
    }
}
