package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ViewAdminUser extends JFrame {
	
	private JPanel userPanel = new JPanel();
	private JLabel sectionTitle = new JLabel();
	private JSeparator separator,separatorSection;
	private DefaultTableModel tableModelUser = new DefaultTableModel();
	private JScrollPane scrollPaneUser = new JScrollPane();
	private JTable tableUser = new JTable();
	private JLabel username = new JLabel("Username"),password = new JLabel("Password"), userType = new JLabel("User type"), id = new JLabel("ID");
	private JTextField usernameTxt = new JTextField(), passwordTxt = new JTextField(), IDtxt = new JTextField();
	private JComboBox userTypeCombo = new JComboBox();
	private JButton addBtn = new JButton(),editBtn = new JButton(),deleteBtn = new JButton(),searchBtn = new JButton();
	
	public ViewAdminUser() {
		userPanel.setBackground(Color.white);
		userPanel.setBounds(0, 0, 630, 550);
		userPanel.setLayout(null);
		
		sectionTitle.setText("Users");
		sectionTitle.setBounds(15,20,150,40);
		Font sectionTitleFont = new Font("Dialog", Font.BOLD,16);
		sectionTitle.setFont(sectionTitleFont);
		separatorSection = new JSeparator();
		separatorSection.setBounds(0, 60, 630, 10);
		separatorSection.setForeground(Color.LIGHT_GRAY);
		
		tableModelUser.setColumnCount(0); 
    	tableUser = new JTable(tableModelUser) {
        	public boolean isCellEditable ( int row, int col){
                return false;
            }
        };
        
        scrollPaneUser = new JScrollPane(tableUser);
        scrollPaneUser.setBounds(30,180,490,200);
		
        String[] columnTitles = {"ID","Username","Password","User Type"}; 
        for(String titles: columnTitles) {
			  tableModelUser.addColumn(titles);
		  }
  
        id.setBounds(65,75,150,50);
        IDtxt.setBounds(50, 125, 50,25);
        IDtxt.setEditable(false);
        
		username.setBounds(135,75,150,50);
		usernameTxt.setBounds(115,125,120,25);
		
		password.setBounds(270,75,150,50);
		passwordTxt.setBounds(250,125,120,25);
		
		
		userTypeCombo.addItem("Admin");
		userTypeCombo.addItem("Employee");
		
		userType.setBounds(395, 75, 150, 50);
		userTypeCombo.setBounds(385,125,130,25);
	
        addBtn = new JButton("Add");
        addBtn.setBounds(30,400, 105,25);
        
        deleteBtn= new JButton("Delete");
        deleteBtn.setBounds(160,400, 105,25);
		
        editBtn= new JButton("Edit");
        editBtn.setBounds(290,400, 105,25);
        
        searchBtn = new JButton("Search");
        searchBtn.setBounds(415,400,105,25);
        
        userPanel.add(sectionTitle);
        userPanel.add(separatorSection);
        userPanel.add(id);
        userPanel.add(IDtxt);
        userPanel.add(username);
        userPanel.add(usernameTxt);
        userPanel.add(password);
        userPanel.add(passwordTxt);
        userPanel.add(userType);
        userPanel.add(userTypeCombo);
        userPanel.add(scrollPaneUser);
        userPanel.add(addBtn);
        userPanel.add(deleteBtn);
        userPanel.add(editBtn);
        userPanel.add(searchBtn);
      
        getContentPane().add(userPanel);
   
	}

	public JPanel getUserPanel() {
		return userPanel;
	}

	public void setUserPanel(JPanel userPanel) {
		this.userPanel = userPanel;
	}

	public JLabel getSectionTitle() {
		return sectionTitle;
	}

	public void setSectionTitle(JLabel sectionTitle) {
		this.sectionTitle = sectionTitle;
	}

	public JSeparator getSeparator() {
		return separator;
	}

	public void setSeparator(JSeparator separator) {
		this.separator = separator;
	}

	public JSeparator getSeparatorSection() {
		return separatorSection;
	}

	public void setSeparatorSection(JSeparator separatorSection) {
		this.separatorSection = separatorSection;
	}

	public DefaultTableModel getTableModelUser() {
		return tableModelUser;
	}

	public void setTableModelUser(DefaultTableModel tableModelUser) {
		this.tableModelUser = tableModelUser;
	}

	public JScrollPane getScrollPaneUser() {
		return scrollPaneUser;
	}

	public void setScrollPaneUser(JScrollPane scrollPaneUser) {
		this.scrollPaneUser = scrollPaneUser;
	}

	public JTable getTableUser() {
		return tableUser;
	}

	public void setTableUser(JTable tableUser) {
		this.tableUser = tableUser;
	}

	public JLabel getUsername() {
		return username;
	}

	public void setUsername(JLabel username) {
		this.username = username;
	}

	public JLabel getPassword() {
		return password;
	}

	public void setPassword(JLabel password) {
		this.password = password;
	}

	public JLabel getUserType() {
		return userType;
	}

	public void setUserType(JLabel userType) {
		this.userType = userType;
	}

	public JTextField getUsernameTxt() {
		return usernameTxt;
	}
	
	

	public JLabel getId() {
		return id;
	}

	public void setId(JLabel id) {
		this.id = id;
	}

	public JTextField getIDtxt() {
		return IDtxt;
	}

	public void setIDtxt(JTextField iDtxt) {
		IDtxt = iDtxt;
	}

	public void setUsernameTxt(JTextField usernameTxt) {
		this.usernameTxt = usernameTxt;
	}

	public JTextField getPasswordTxt() {
		return passwordTxt;
	}

	public void setPasswordTxt(JTextField passwordTxt) {
		this.passwordTxt = passwordTxt;
	}

	public JComboBox getUserTypeCombo() {
		return userTypeCombo;
	}

	public void setUserTypeCombo(JComboBox userTypeCombo) {
		this.userTypeCombo = userTypeCombo;
	}

	public JButton getAddBtn() {
		return addBtn;
	}

	public void setAddBtn(JButton addBtn) {
		this.addBtn = addBtn;
	}

	public JButton getEditBtn() {
		return editBtn;
	}

	public void setEditBtn(JButton editBtn) {
		this.editBtn = editBtn;
	}

	public JButton getDeleteBtn() {
		return deleteBtn;
	}

	public void setDeleteBtn(JButton deleteBtn) {
		this.deleteBtn = deleteBtn;
	}

	public JButton getSearchBtn() {
		return searchBtn;
	}

	public void setSearchBtn(JButton searchBtn) {
		this.searchBtn = searchBtn;
	}
	
	
	
	
	
}
