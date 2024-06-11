package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;



public class ViewAdmin extends JFrame{
	private JPanel leftPanel, rigthTopPanel;
	private JLabel titleView, firstText=  new JLabel(), secondText = new JLabel(), thirdText = new JLabel();
	private JLabel sectionTitle = new JLabel();
	private JSeparator separator,separatorSection;
	private JButton ProductsBtn, CategoryBtn,UserBtn, SuppliersBtn,ExitBtn;
	private ImageIcon InventoryIcon, UserIcon,HomeIcon,ExitIcon;
	private Font sectionTitleFont;
	private JLabel firstName = new JLabel("First Name");
	private JLabel lastName = new JLabel("Last Name");
	private JLabel bornDate = new JLabel("Born Date");
	private JLabel telephone = new JLabel("Telephone");
	private JLabel address = new JLabel("Address");
	private JLabel dni = new JLabel("Identify");
	private JTextField firstNameTxt = new JTextField(), usernameTxt = new JTextField(), passwordTxt = new JTextField();
	private JTextField lastNameTxt = new JTextField();
	private JDateChooser calendary = new JDateChooser(),inputSupplier = new JDateChooser();
	private JTextField telephoneTxt = new JTextField();
	private JTextField addressTxt = new JTextField();
	private JTextField dniTxt = new JTextField();
	private JButton clearInputs = new JButton("Clear");
	private JTextField searchUser = new JTextField();
	private JButton searchBtn = new JButton();
	private JLabel searchLabel = new JLabel("Search with identify");
	private DefaultTableModel tableModelUser = new DefaultTableModel(),tableModelProducts = new DefaultTableModel(),tableModelCategory = new DefaultTableModel(),tableModelSuppliers = new DefaultTableModel();
	private JScrollPane scrollPaneUser = new JScrollPane(), scrollPaneProducts,scrollPaneCategory,scrollPaneSuppliers;
	private JTable tableUser = new JTable(), tableProducts,tableCategory,tableSupplier;
	private Font font = new Font("Dialog",Font.BOLD,18);
	private JComboBox userTypeCombo = new JComboBox(),categoryProductCombo;
	private JFrame screenUser = new JFrame(), screenProducts = new JFrame(),screenCategory = new JFrame(),screenSuppliers =  new JFrame();
	private JPanel userPanel = new JPanel(),productsPanel = new JPanel(),categoryPanel = new JPanel(),suppliersPanel = new JPanel(),homePanel = new JPanel();
	private JLabel nameProduct,barcodeProduct,priceProduct,stockProduct,categoryProduct,searchProduct, nameCategory,nameSupplier,supplierInput,supplierCategory;
	private JTextField nameCategoryTxt,nameSupplierTxt,categorySupplierTxt; 
	private JButton addCategoryBtn, editCategoryBtn, deleteCategoryBtn, addSupplierBtn, editSupplierBtn, deleteSupplierBtn;
	
	public ViewAdmin(){
		getContentPane().setLayout(null);
		
		leftPanel = new JPanel();
		leftPanel.setBounds(0, 0, 270, 600);
		leftPanel.setBackground(Color.DARK_GRAY);
		leftPanel.setLayout(null);
		
		Font titleFont = new Font("Dialog", Font.BOLD,26);
		titleView = new JLabel();
		titleView.setText("Welcome");
		titleView.setBounds(65, 35, 150, 25);
		titleView.setForeground(Color.white);
		titleView.setFont(titleFont);
		
		separator = new JSeparator();
		separator.setForeground(Color.white);
		separator.setBounds(0, 85, 270, 5);
	
		ProductsBtn = new JButton("Products");
		ProductsBtn.setBackground(Color.white);
		ProductsBtn.setBounds(45, 180, 180, 50);
		
		CategoryBtn = new JButton("Category");
		CategoryBtn.setBackground(Color.white);
		CategoryBtn.setBounds(45, 240, 180, 50);
		
		UserBtn = new JButton("Users");
		UserBtn.setBackground(Color.white);
		UserBtn.setBounds(45, 300, 180, 50);
		
		ExitBtn = new JButton("Exit");
		ExitBtn.setBackground(Color.white);
		ExitBtn.setBounds(45, 360, 180, 50);
		
		rigthTopPanel = new JPanel();
		rigthTopPanel.setBounds(270,0,630,87);
		rigthTopPanel.setBackground(Color.LIGHT_GRAY);
		rigthTopPanel.setLayout(null);
		
		
		Font fontNameCompany = new Font("Dialog",Font.BOLD,22);
		JLabel nameCompany = new JLabel("Inventory Management System");
		nameCompany.setFont(fontNameCompany);
		
		
		nameCompany.setBounds(75,30,500,25);
		
		leftPanel.add(titleView);
		leftPanel.add(separator);
		leftPanel.add(ProductsBtn);
		leftPanel.add(CategoryBtn);
		leftPanel.add(UserBtn);
		leftPanel.add(ExitBtn);
		
		rigthTopPanel.add(nameCompany);
		
		homePanel.setBounds(270,85, 630, 550);
		homePanel.setBackground(Color.BLACK);
		sectionTitle.setText("Home");
		sectionTitle.setBounds(15,20,150,40);
		Font sectionTitleFont = new Font("Dialog", Font.BOLD,16);
		sectionTitle.setFont(sectionTitleFont);
		separatorSection = new JSeparator();
		separatorSection.setBounds(0, 60, 630, 10);
		separatorSection.setForeground(Color.LIGHT_GRAY);
		
		homePanel.add(sectionTitle);
		homePanel.add(separatorSection);
		homePanel.add(firstText);
		homePanel.add(secondText);
		homePanel.add(thirdText);
		
		
		getContentPane().add(leftPanel);
		getContentPane().add(rigthTopPanel);
		getContentPane().add(homePanel);
		getContentPane().setBackground(Color.white);
	}
	
	public void screenProducts() {
		
		
	}
	
	public void screenUser() {
			
			
		
	}
	
	public void screenCategory() {
			
	}
	
	public void screenSuppliers() {
		
	}
	

	public JPanel getLeftPanel() {
		return leftPanel;
	}

	public void setLeftPanel(JPanel leftPanel) {
		this.leftPanel = leftPanel;
	}

	public JPanel getRigthTopPanel() {
		return rigthTopPanel;
	}

	public void setRigthTopPanel(JPanel rigthTopPanel) {
		this.rigthTopPanel = rigthTopPanel;
	}
	
	
	public JLabel getTitleView() {
		return titleView;
	}

	public void setTitleView(JLabel titleView) {
		this.titleView = titleView;
	}

	public JSeparator getSeparator() {
		return separator;
	}

	public void setSeparator(JSeparator separator) {
		this.separator = separator;
	}
	

	public JLabel getFirstText() {
		return firstText;
	}

	public void setFirstText(JLabel firstText) {
		this.firstText = firstText;
	}

	public JLabel getSecondText() {
		return secondText;
	}

	public void setSecondText(JLabel secondText) {
		this.secondText = secondText;
	}

	public JLabel getThirdText() {
		return thirdText;
	}

	public void setThirdText(JLabel thirdText) {
		this.thirdText = thirdText;
	}

	public JButton getProductsBtn() {
		return ProductsBtn;
	}
	


	public JButton getSuppliersBtn() {
		return SuppliersBtn;
	}

	public void setSuppliersBtn(JButton suppliersBtn) {
		SuppliersBtn = suppliersBtn;
	}

	public DefaultTableModel getTableModelProducts() {
		return tableModelProducts;
	}

	public void setTableModelProducts(DefaultTableModel tableModelProducts) {
		this.tableModelProducts = tableModelProducts;
	}

	public JScrollPane getScrollPaneProducts() {
		return scrollPaneProducts;
	}

	public void setScrollPaneProducts(JScrollPane scrollPaneProducts) {
		this.scrollPaneProducts = scrollPaneProducts;
	}

	public JTable getTableProducts() {
		return tableProducts;
	}

	public void setTableProducts(JTable tableProducts) {
		this.tableProducts = tableProducts;
	}

	public JComboBox getCategoryProductCombo() {
		return categoryProductCombo;
	}

	public void setCategoryProductCombo(JComboBox categoryProductCombo) {
		this.categoryProductCombo = categoryProductCombo;
	}

	public JFrame getScreenProducts() {
		return screenProducts;
	}

	public void setScreenProducts(JFrame screenProducts) {
		this.screenProducts = screenProducts;
	}

	public JFrame getScreenCategory() {
		return screenCategory;
	}

	public void setScreenCategory(JFrame screenCategory) {
		this.screenCategory = screenCategory;
	}

	public JFrame getScreenSuppliers() {
		return screenSuppliers;
	}

	public void setScreenSuppliers(JFrame screenSuppliers) {
		this.screenSuppliers = screenSuppliers;
	}

	public JPanel getProductsPanel() {
		return productsPanel;
	}

	public void setProductsPanel(JPanel productsPanel) {
		this.productsPanel = productsPanel;
	}

	public JLabel getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(JLabel nameProduct) {
		this.nameProduct = nameProduct;
	}

	public JLabel getBarcodeProduct() {
		return barcodeProduct;
	}

	public void setBarcodeProduct(JLabel barcodeProduct) {
		this.barcodeProduct = barcodeProduct;
	}

	public JLabel getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(JLabel priceProduct) {
		this.priceProduct = priceProduct;
	}

	public JLabel getStockProduct() {
		return stockProduct;
	}

	public void setStockProduct(JLabel stockProduct) {
		this.stockProduct = stockProduct;
	}

	public JLabel getCategoryProduct() {
		return categoryProduct;
	}

	public void setCategoryProduct(JLabel categoryProduct) {
		this.categoryProduct = categoryProduct;
	}

	public JLabel getSearchProduct() {
		return searchProduct;
	}

	public void setSearchProduct(JLabel searchProduct) {
		this.searchProduct = searchProduct;
	}
	
	
	
	
	public JDateChooser getInputSupplier() {
		return inputSupplier;
	}

	public void setInputSupplier(JDateChooser inputSupplier) {
		this.inputSupplier = inputSupplier;
	}

	public DefaultTableModel getTableModelUser() {
		return tableModelUser;
	}

	public void setTableModelUser(DefaultTableModel tableModelUser) {
		this.tableModelUser = tableModelUser;
	}

	public DefaultTableModel getTableModelCategory() {
		return tableModelCategory;
	}

	public void setTableModelCategory(DefaultTableModel tableModelCategory) {
		this.tableModelCategory = tableModelCategory;
	}

	public DefaultTableModel getTableModelSuppliers() {
		return tableModelSuppliers;
	}

	public void setTableModelSuppliers(DefaultTableModel tableModelSuppliers) {
		this.tableModelSuppliers = tableModelSuppliers;
	}

	public JScrollPane getScrollPaneUser() {
		return scrollPaneUser;
	}

	public void setScrollPaneUser(JScrollPane scrollPaneUser) {
		this.scrollPaneUser = scrollPaneUser;
	}

	public JScrollPane getScrollPaneCategory() {
		return scrollPaneCategory;
	}

	public void setScrollPaneCategory(JScrollPane scrollPaneCategory) {
		this.scrollPaneCategory = scrollPaneCategory;
	}

	public JScrollPane getScrollPaneSuppliers() {
		return scrollPaneSuppliers;
	}

	public void setScrollPaneSuppliers(JScrollPane scrollPaneSuppliers) {
		this.scrollPaneSuppliers = scrollPaneSuppliers;
	}

	public JTable getTableUser() {
		return tableUser;
	}

	public void setTableUser(JTable tableUser) {
		this.tableUser = tableUser;
	}

	public JTable getTableCategory() {
		return tableCategory;
	}

	public void setTableCategory(JTable tableCategory) {
		this.tableCategory = tableCategory;
	}

	public JTable getTableSupplier() {
		return tableSupplier;
	}

	public void setTableSupplier(JTable tableSupplier) {
		this.tableSupplier = tableSupplier;
	}

	public JPanel getCategoryPanel() {
		return categoryPanel;
	}

	public void setCategoryPanel(JPanel categoryPanel) {
		this.categoryPanel = categoryPanel;
	}

	public JPanel getSuppliersPanel() {
		return suppliersPanel;
	}

	public void setSuppliersPanel(JPanel suppliersPanel) {
		this.suppliersPanel = suppliersPanel;
	}

	public JLabel getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(JLabel nameCategory) {
		this.nameCategory = nameCategory;
	}

	public JLabel getNameSupplier() {
		return nameSupplier;
	}

	public void setNameSupplier(JLabel nameSupplier) {
		this.nameSupplier = nameSupplier;
	}

	public JLabel getSupplierInput() {
		return supplierInput;
	}

	public void setSupplierInput(JLabel supplierInput) {
		this.supplierInput = supplierInput;
	}

	public JLabel getSupplierCategory() {
		return supplierCategory;
	}

	public void setSupplierCategory(JLabel supplierCategory) {
		this.supplierCategory = supplierCategory;
	}

	public JTextField getNameCategoryTxt() {
		return nameCategoryTxt;
	}

	public void setNameCategoryTxt(JTextField nameCategoryTxt) {
		this.nameCategoryTxt = nameCategoryTxt;
	}

	public JTextField getNameSupplierTxt() {
		return nameSupplierTxt;
	}

	public void setNameSupplierTxt(JTextField nameSupplierTxt) {
		this.nameSupplierTxt = nameSupplierTxt;
	}

	public JTextField getCategorySupplierTxt() {
		return categorySupplierTxt;
	}

	public void setCategorySupplierTxt(JTextField categorySupplierTxt) {
		this.categorySupplierTxt = categorySupplierTxt;
	}

	public JButton getAddCategoryBtn() {
		return addCategoryBtn;
	}

	public void setAddCategoryBtn(JButton addCategoryBtn) {
		this.addCategoryBtn = addCategoryBtn;
	}

	public JButton getEditCategoryBtn() {
		return editCategoryBtn;
	}

	public void setEditCategoryBtn(JButton editCategoryBtn) {
		this.editCategoryBtn = editCategoryBtn;
	}

	public JButton getDeleteCategoryBtn() {
		return deleteCategoryBtn;
	}

	public void setDeleteCategoryBtn(JButton deleteCategoryBtn) {
		this.deleteCategoryBtn = deleteCategoryBtn;
	}

	public JButton getAddSupplierBtn() {
		return addSupplierBtn;
	}

	public void setAddSupplierBtn(JButton addSupplierBtn) {
		this.addSupplierBtn = addSupplierBtn;
	}

	public JButton getEditSupplierBtn() {
		return editSupplierBtn;
	}

	public void setEditSupplierBtn(JButton editSupplierBtn) {
		this.editSupplierBtn = editSupplierBtn;
	}

	public JButton getDeleteSupplierBtn() {
		return deleteSupplierBtn;
	}

	public void setDeleteSupplierBtn(JButton deleteSupplierBtn) {
		this.deleteSupplierBtn = deleteSupplierBtn;
	}


	public void setProductsBtn(JButton productsBtn) {
		ProductsBtn = productsBtn;
	}

	public JButton getCategoryBtn() {
		return CategoryBtn;
	}

	public void setCategoryBtn(JButton categoryBtn) {
		CategoryBtn = categoryBtn;
	}

	public JLabel getFirstName() {
		return firstName;
	}

	public void setFirstName(JLabel firstName) {
		this.firstName = firstName;
	}

	public JLabel getLastName() {
		return lastName;
	}

	public void setLastName(JLabel lastName) {
		this.lastName = lastName;
	}

	public JLabel getBornDate() {
		return bornDate;
	}

	public void setBornDate(JLabel bornDate) {
		this.bornDate = bornDate;
	}

	public JLabel getTelephone() {
		return telephone;
	}

	public void setTelephone(JLabel telephone) {
		this.telephone = telephone;
	}

	public JLabel getAddress() {
		return address;
	}

	public void setAddress(JLabel address) {
		this.address = address;
	}

	public JLabel getDni() {
		return dni;
	}

	public void setDni(JLabel dni) {
		this.dni = dni;
	}

	public JTextField getFirstNameTxt() {
		return firstNameTxt;
	}

	public void setFirstNameTxt(JTextField firstNameTxt) {
		this.firstNameTxt = firstNameTxt;
	}

	public JTextField getUsernameTxt() {
		return usernameTxt;
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

	public JTextField getLastNameTxt() {
		return lastNameTxt;
	}

	public void setLastNameTxt(JTextField lastNameTxt) {
		this.lastNameTxt = lastNameTxt;
	}

	public JDateChooser getCalendary() {
		return calendary;
	}

	public void setCalendary(JDateChooser calendary) {
		this.calendary = calendary;
	}

	public JTextField getTelephoneTxt() {
		return telephoneTxt;
	}

	public void setTelephoneTxt(JTextField telephoneTxt) {
		this.telephoneTxt = telephoneTxt;
	}

	public JTextField getAddressTxt() {
		return addressTxt;
	}

	public void setAddressTxt(JTextField addressTxt) {
		this.addressTxt = addressTxt;
	}

	public JTextField getDniTxt() {
		return dniTxt;
	}

	public void setDniTxt(JTextField dniTxt) {
		this.dniTxt = dniTxt;
	}

	public JButton getClearInputs() {
		return clearInputs;
	}

	public void setClearInputs(JButton clearInputs) {
		this.clearInputs = clearInputs;
	}

	public JTextField getSearchUser() {
		return searchUser;
	}

	public void setSearchUser(JTextField searchUser) {
		this.searchUser = searchUser;
	}

	public JButton getSearchBtn() {
		return searchBtn;
	}

	public void setSearchBtn(JButton searchBtn) {
		this.searchBtn = searchBtn;
	}

	public JLabel getSearchLabel() {
		return searchLabel;
	}

	public void setSearchLabel(JLabel searchLabel) {
		this.searchLabel = searchLabel;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public JComboBox getUserTypeCombo() {
		return userTypeCombo;
	}

	public void setUserTypeCombo(JComboBox userTypeCombo) {
		this.userTypeCombo = userTypeCombo;
	}

	public JFrame getScreenUser() {
		return screenUser;
	}

	public void setScreenUser(JFrame screenUser) {
		this.screenUser = screenUser;
	}


	public JPanel getUserPanel() {
		return userPanel;
	}

	public void setUserPanel(JPanel userPanel) {
		this.userPanel = userPanel;
	}

	public JPanel getHomePanel() {
		return homePanel;
	}

	public void setHomePanel(JPanel homePanel) {
		this.homePanel = homePanel;
	}

	public JButton getUserBtn() {
		return UserBtn;
	}

	public void setUserBtn(JButton userBtn) {
		UserBtn = userBtn;
	}

	public JButton getExitBtn() {
		return ExitBtn;
	}

	public void setExitBtn(JButton exitBtn) {
		ExitBtn = exitBtn;
	}

	public ImageIcon getInventoryIcon() {
		return InventoryIcon;
	}

	public void setInventoryIcon(ImageIcon inventoryIcon) {
		InventoryIcon = inventoryIcon;
	}

	public ImageIcon getUserIcon() {
		return UserIcon;
	}

	public void setUserIcon(ImageIcon userIcon) {
		UserIcon = userIcon;
	}

	public ImageIcon getHomeIcon() {
		return HomeIcon;
	}

	public void setHomeIcon(ImageIcon homeIcon) {
		HomeIcon = homeIcon;
	}

	public ImageIcon getExitIcon() {
		return ExitIcon;
	}

	public void setExitIcon(ImageIcon exitIcon) {
		ExitIcon = exitIcon;
	}

	public JLabel getSectionTitle() {
		return sectionTitle;
	}

	public void setSectionTitle(JLabel sectionTitle) {
		this.sectionTitle = sectionTitle;
	}

	public JSeparator getSeparatorSection() {
		return separatorSection;
	}

	public void setSeparatorSection(JSeparator separatorSection) {
		this.separatorSection = separatorSection;
	}

	public Font getSectionTitleFont() {
		return sectionTitleFont;
	}

	public void setSectionTitleFont(Font sectionTitleFont) {
		this.sectionTitleFont = sectionTitleFont;
	}
	
	
	
	
	
	
}
