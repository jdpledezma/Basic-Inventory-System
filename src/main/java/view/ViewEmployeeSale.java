package view;

import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewEmployeeSale extends JFrame{
	private JButton addProductBtn,deleteProductBtn,searchProductBtn,billBtn,searchBtn,addClientBtn;
	private JLabel titleView,titleScreenSale,clientDni,clientFirstName,clientLastName,clientAddress,clientTelephone,dataProducts,codeProduct,nameProduct,stockProduct,priceProduct,cantityProduct, totalProduct;
	private JTextField clientDniTxt,clientFirstNameTxt,clientLastNameTxt,clientAddressTxt,clientTelephoneTxt,codeProductTxt,nameProductTxt,stockProductTxt,priceProductTxt,cantityProductTxt, totalProductTxt;
	private Font titleFonts = new Font("Dialog", Font.BOLD,18), labelFont = new Font("Dialog", Font.BOLD,14);
	private DefaultTableModel tableModelProducts;
	private JTable tableProducts;
	private JScrollPane scrollPaneProducts;
	
	public ViewEmployeeSale() {
		getContentPane().setLayout(null);
		titleScreenSale = new JLabel("Sales data");
		titleScreenSale.setBounds(35,10,150,35);
		titleScreenSale.setFont(titleFonts);
		
		clientDni = new JLabel("Client DNI");
		clientFirstName = new JLabel("First Name ");
		clientLastName = new JLabel("Last Name ");
		clientAddress = new JLabel("Address Client ");
		clientTelephone = new JLabel("Telephone Client");
		dataProducts = new JLabel("Data Products");
		codeProduct = new JLabel("Code Product");
		nameProduct = new JLabel("Name Product");
		stockProduct = new JLabel("Stock");
		priceProduct = new JLabel("Price");
		cantityProduct = new JLabel("Cantity");
		totalProduct = new JLabel("Total");
		
		addProductBtn = new JButton("Add");
		deleteProductBtn = new JButton("Delete");
		searchProductBtn = new JButton("Search");
		billBtn = new JButton("Bill");
		searchBtn = new JButton("Search"); 
		addClientBtn = new JButton("Add");
		
		clientDni.setBounds(45,45,150,35);
		clientDni.setFont(labelFont);
		clientFirstName.setBounds(175,45,150,35);
		clientFirstName.setFont(labelFont);
		clientLastName.setBounds(315,45,150,35);
		clientLastName.setFont(labelFont);
		clientAddress.setBounds(435,45,150,35);
		clientAddress.setFont(labelFont);
		clientTelephone.setBounds(565,45,150,35);
		clientTelephone.setFont(labelFont);
		dataProducts.setBounds(25,145,150,35);
		dataProducts.setFont(labelFont);
		codeProduct.setBounds(25,180,130,25);
		nameProduct.setBounds(25, 250, 125, 25);
		stockProduct.setBounds(210, 180, 125, 25);
		priceProduct.setBounds(310, 180, 125, 25);
		cantityProduct.setBounds(190,285,125,25);
		totalProduct.setBounds(390,285,125,25);
		
		
		clientDniTxt = new JTextField();
		clientFirstNameTxt = new JTextField();
		clientLastNameTxt = new JTextField();
		clientAddressTxt = new JTextField();
		clientTelephoneTxt = new JTextField();
		codeProductTxt = new JTextField();
		nameProductTxt = new JTextField();
		stockProductTxt = new JTextField();
		priceProductTxt = new JTextField();
		cantityProductTxt = new JTextField();
		totalProductTxt = new JTextField();
		
		
		clientFirstNameTxt.setEditable(false);
		clientLastNameTxt.setEditable(false);
		clientAddressTxt.setEditable(false);
		clientTelephoneTxt.setEditable(false);
		codeProductTxt.setEditable(false);
		nameProductTxt.setEditable(false);
		stockProductTxt.setEditable(false);
		priceProductTxt.setEditable(false);
		cantityProductTxt.setEditable(false);
		totalProductTxt.setEditable(false);
		
		clientDniTxt.setBounds(25,80,120,25);
		clientFirstNameTxt.setBounds(160,80,120,25);
		clientLastNameTxt.setBounds(295,80,120,25);
		clientAddressTxt.setBounds(430,80,120,25);
		clientTelephoneTxt.setBounds(565, 80, 120, 25);
		codeProductTxt.setBounds(25,215,150,25);
		nameProductTxt.setBounds(25,285,150,25);
		stockProductTxt.setBounds(190,215,80,25);
		priceProductTxt.setBounds(290,215,80,25); 
		cantityProductTxt.setBounds(255,285,125,25);
		totalProductTxt.setBounds(445,285,125,25);
		
		addProductBtn.setBounds(600,145,100,25);
		deleteProductBtn.setBounds(600,180,100,25);
		searchProductBtn.setBounds(600,215,100,25);
		billBtn.setBounds(600,285,100,25);
		searchBtn.setBounds(25,115,100,25);
		addClientBtn.setBounds(130,115,100,25);
		
		tableModelProducts = new DefaultTableModel();
		
		tableProducts = new JTable(tableModelProducts) {
        	public boolean isCellEditable ( int row, int col){
                return false;
            }
        };
        
        String[] scrollPaneProductsTitle = {"Name", "Code", "Price", "Stock", "Cantity"};
        scrollPaneProducts = new JScrollPane(tableProducts);
        scrollPaneProducts.setBounds(25, 340, 540, 200);
        
        for(String titles : scrollPaneProductsTitle) {
        	tableModelProducts.addColumn(titles);
        }
		
        getContentPane().add(clientDni);
        getContentPane().add(titleScreenSale);
        getContentPane().add(clientFirstName);
        getContentPane().add(clientLastName);
        getContentPane().add(clientAddress);
        getContentPane().add(clientTelephone);
        getContentPane().add(clientDniTxt);
        getContentPane().add(clientFirstNameTxt);
        getContentPane().add(clientLastNameTxt);
        getContentPane().add(clientAddressTxt);
        getContentPane().add(clientTelephoneTxt);
        getContentPane().add(dataProducts);
        getContentPane().add(codeProduct);
        getContentPane().add(codeProductTxt);
        getContentPane().add(nameProduct);
        getContentPane().add(nameProductTxt);
        getContentPane().add(stockProduct);
        getContentPane().add(stockProductTxt);
        getContentPane().add(priceProduct);
        getContentPane().add(priceProductTxt);
        getContentPane().add(cantityProduct);
        getContentPane().add(cantityProductTxt);
        getContentPane().add(totalProduct);
        getContentPane().add(totalProductTxt);
        getContentPane().add(addProductBtn);
        getContentPane().add(deleteProductBtn);
        getContentPane().add(scrollPaneProducts);
        getContentPane().add(billBtn);
        getContentPane().add(searchBtn);
        getContentPane().add(addClientBtn);
        getContentPane().add(searchProductBtn);
	}

	public JButton getAddProductBtn() {
		return addProductBtn;
	}

	public void setAddProductBtn(JButton addProductBtn) {
		this.addProductBtn = addProductBtn;
	}

	public JButton getDeleteProductBtn() {
		return deleteProductBtn;
	}

	public void setDeleteProductBtn(JButton deleteProductBtn) {
		this.deleteProductBtn = deleteProductBtn;
	}

	public JButton getBillBtn() {
		return billBtn;
	}

	public void setBillBtn(JButton billBtn) {
		this.billBtn = billBtn;
	}

	public JButton getSearchBtn() {
		return searchBtn;
	}

	public void setSearchBtn(JButton searchBtn) {
		this.searchBtn = searchBtn;
	}

	public JButton getAddClientBtn() {
		return addClientBtn;
	}
	
	

	public JButton getSearchProductBtn() {
		return searchProductBtn;
	}

	public void setSearchProductBtn(JButton searchProductBtn) {
		this.searchProductBtn = searchProductBtn;
	}

	public void setAddClientBtn(JButton addClientBtn) {
		this.addClientBtn = addClientBtn;
	}

	public JLabel getTitleView() {
		return titleView;
	}

	public void setTitleView(JLabel titleView) {
		this.titleView = titleView;
	}

	public JLabel getTitleScreenSale() {
		return titleScreenSale;
	}

	public void setTitleScreenSale(JLabel titleScreenSale) {
		this.titleScreenSale = titleScreenSale;
	}

	public JLabel getClientDni() {
		return clientDni;
	}

	public void setClientDni(JLabel clientDni) {
		this.clientDni = clientDni;
	}

	public JLabel getClientFirstName() {
		return clientFirstName;
	}

	public void setClientFirstName(JLabel clientFirstName) {
		this.clientFirstName = clientFirstName;
	}

	public JLabel getClientLastName() {
		return clientLastName;
	}

	public void setClientLastName(JLabel clientLastName) {
		this.clientLastName = clientLastName;
	}

	public JLabel getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(JLabel clientAddress) {
		this.clientAddress = clientAddress;
	}

	public JLabel getClientTelephone() {
		return clientTelephone;
	}

	public void setClientTelephone(JLabel clientTelephone) {
		this.clientTelephone = clientTelephone;
	}

	public JLabel getDataProducts() {
		return dataProducts;
	}

	public void setDataProducts(JLabel dataProducts) {
		this.dataProducts = dataProducts;
	}

	public JLabel getCodeProduct() {
		return codeProduct;
	}

	public void setCodeProduct(JLabel codeProduct) {
		this.codeProduct = codeProduct;
	}

	public JLabel getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(JLabel nameProduct) {
		this.nameProduct = nameProduct;
	}

	public JLabel getStockProduct() {
		return stockProduct;
	}

	public void setStockProduct(JLabel stockProduct) {
		this.stockProduct = stockProduct;
	}

	public JLabel getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(JLabel priceProduct) {
		this.priceProduct = priceProduct;
	}

	public JLabel getCantityProduct() {
		return cantityProduct;
	}

	public void setCantityProduct(JLabel cantityProduct) {
		this.cantityProduct = cantityProduct;
	}

	public JLabel getTotalProduct() {
		return totalProduct;
	}

	public void setTotalProduct(JLabel totalProduct) {
		this.totalProduct = totalProduct;
	}

	public JTextField getClientDniTxt() {
		return clientDniTxt;
	}

	public void setClientDniTxt(JTextField clientDniTxt) {
		this.clientDniTxt = clientDniTxt;
	}

	public JTextField getClientFirstNameTxt() {
		return clientFirstNameTxt;
	}

	public void setClientFirstNameTxt(JTextField clientFirstNameTxt) {
		this.clientFirstNameTxt = clientFirstNameTxt;
	}

	public JTextField getClientLastNameTxt() {
		return clientLastNameTxt;
	}

	public void setClientLastNameTxt(JTextField clientLastNameTxt) {
		this.clientLastNameTxt = clientLastNameTxt;
	}

	public JTextField getClientAddressTxt() {
		return clientAddressTxt;
	}

	public void setClientAddressTxt(JTextField clientAddressTxt) {
		this.clientAddressTxt = clientAddressTxt;
	}

	public JTextField getClientTelephoneTxt() {
		return clientTelephoneTxt;
	}

	public void setClientTelephoneTxt(JTextField clientTelephoneTxt) {
		this.clientTelephoneTxt = clientTelephoneTxt;
	}

	public JTextField getCodeProductTxt() {
		return codeProductTxt;
	}

	public void setCodeProductTxt(JTextField codeProductTxt) {
		this.codeProductTxt = codeProductTxt;
	}

	public JTextField getNameProductTxt() {
		return nameProductTxt;
	}

	public void setNameProductTxt(JTextField nameProductTxt) {
		this.nameProductTxt = nameProductTxt;
	}

	public JTextField getStockProductTxt() {
		return stockProductTxt;
	}

	public void setStockProductTxt(JTextField stockProductTxt) {
		this.stockProductTxt = stockProductTxt;
	}

	public JTextField getPriceProductTxt() {
		return priceProductTxt;
	}

	public void setPriceProductTxt(JTextField priceProductTxt) {
		this.priceProductTxt = priceProductTxt;
	}

	public JTextField getCantityProductTxt() {
		return cantityProductTxt;
	}

	public void setCantityProductTxt(JTextField cantityProductTxt) {
		this.cantityProductTxt = cantityProductTxt;
	}

	public JTextField getTotalProductTxt() {
		return totalProductTxt;
	}

	public void setTotalProductTxt(JTextField totalProductTxt) {
		this.totalProductTxt = totalProductTxt;
	}

	public Font getTitleFonts() {
		return titleFonts;
	}

	public void setTitleFonts(Font titleFonts) {
		this.titleFonts = titleFonts;
	}

	public Font getLabelFont() {
		return labelFont;
	}

	public void setLabelFont(Font labelFont) {
		this.labelFont = labelFont;
	}

	public DefaultTableModel getTableModelProducts() {
		return tableModelProducts;
	}

	public void setTableModelProducts(DefaultTableModel tableModelProducts) {
		this.tableModelProducts = tableModelProducts;
	}

	public JTable getTableProducts() {
		return tableProducts;
	}

	public void setTableProducts(JTable tableProducts) {
		this.tableProducts = tableProducts;
	}

	public JScrollPane getScrollPaneProducts() {
		return scrollPaneProducts;
	}

	public void setScrollPaneProducts(JScrollPane scrollPaneProducts) {
		this.scrollPaneProducts = scrollPaneProducts;
	}
	
	
	
}
