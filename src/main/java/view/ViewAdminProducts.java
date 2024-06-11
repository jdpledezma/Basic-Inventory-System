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

public class ViewAdminProducts extends JFrame {
	
	private JPanel productsPanel = new JPanel();
	private JLabel sectionTitle = new JLabel();
	private JSeparator separator,separatorSection;
	private JLabel nameProduct,barcodeProduct,priceProduct,stockProduct,categoryProduct,searchProduct;
	private JTextField nameProductTxt, barcodeProductTxt, priceProductTxt,stockProductTxt, searchProductTxt;
	private JComboBox categoryProductCombo = new JComboBox();
	private JButton addProductBtn, editProductBtn, deleteProductBtn, searchProductBtn;
	private DefaultTableModel tableModelProducts = new DefaultTableModel();
	private JTable tableProducts = new JTable();
	private JScrollPane scrollPaneProducts = new JScrollPane();
	
	public ViewAdminProducts() {
		productsPanel.setBounds(0, 0, 630, 550);
		productsPanel.setLayout(null);
		productsPanel.setBackground(Color.white);
		sectionTitle.setText("Products");
		sectionTitle.setBounds(15,20,150,40);
		Font sectionTitleFont = new Font("Dialog", Font.BOLD,16);
		sectionTitle.setFont(sectionTitleFont);
		separatorSection = new JSeparator();
		separatorSection.setBounds(0, 60, 680, 10);
		separatorSection.setForeground(Color.LIGHT_GRAY);
		
		productsPanel.add(sectionTitle);
		productsPanel.add(separatorSection);
		
		nameProduct = new JLabel("Name Product");
		barcodeProduct = new JLabel("Code Product");
		priceProduct = new JLabel("Price Product");
		stockProduct = new JLabel("Stock Product");
		categoryProduct = new JLabel("Category Product");
		searchProduct = new JLabel("Search");
		
		nameProductTxt = new JTextField();
		barcodeProductTxt = new JTextField();
		priceProductTxt = new JTextField();
		stockProductTxt = new JTextField();
		categoryProductCombo = new JComboBox();
		searchProductTxt = new JTextField();
		
		addProductBtn = new JButton("Add");
		editProductBtn = new JButton("Edit");
		deleteProductBtn = new JButton("Delete");
		searchProductBtn = new JButton("Search");
		
		nameProduct.setBounds(25,80,150,25);
		barcodeProduct.setBounds(165,80,150,25);
		priceProduct.setBounds(295,80,150,25);
		stockProduct.setBounds(425,80,150,25);
		categoryProduct.setBounds(545,80,200,25);
		
		nameProductTxt.setBounds(15,120,130,25);
		barcodeProductTxt.setBounds(155,120,120,25);
		priceProductTxt.setBounds(285,120,120,25);
		stockProductTxt.setBounds(415,120,120,25);
		categoryProductCombo.setBounds(545,120,120,25);
		
		
		
		
		tableProducts = new JTable(tableModelProducts) {
        	public boolean isCellEditable ( int row, int col){
                return false;
            }
        };
        String[] scrollPaneProductsTitle = {"Name", "Code", "Price", "Stock", "Category"};
        scrollPaneProducts = new JScrollPane(tableProducts);
        scrollPaneProducts.setBounds(15, 160, 650, 200);
        
        for(String titles : scrollPaneProductsTitle) {
        	tableModelProducts.addColumn(titles);
        }
       
        addProductBtn.setBounds(70,390,100,30);
        editProductBtn.setBounds(180,390,100,30);
        deleteProductBtn.setBounds(290,390,100,30);
        searchProductBtn.setBounds(400,390,100,30);
        searchProduct.setBounds(535,365,100,25);
        searchProductTxt.setBounds(510,390,100,30);
        
        
		productsPanel.add(nameProduct);
		productsPanel.add(barcodeProduct);
		productsPanel.add(priceProduct);
		productsPanel.add(stockProduct);
		productsPanel.add(categoryProduct);
		productsPanel.add(nameProductTxt);
		productsPanel.add(barcodeProductTxt);
		productsPanel.add(priceProductTxt);
		productsPanel.add(stockProductTxt);
		productsPanel.add(categoryProductCombo);
		productsPanel.add(scrollPaneProducts);
		productsPanel.add(addProductBtn);
		productsPanel.add(editProductBtn);
		productsPanel.add(deleteProductBtn);
		productsPanel.add(searchProductBtn);
		productsPanel.add(searchProduct);
		productsPanel.add(searchProductTxt);
		getContentPane().add(productsPanel);
	
	}

	public JPanel getProductsPanel() {
		return productsPanel;
	}

	public void setProductsPanel(JPanel productsPanel) {
		this.productsPanel = productsPanel;
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

	public JTextField getNameProductTxt() {
		return nameProductTxt;
	}

	public void setNameProductTxt(JTextField nameProductTxt) {
		this.nameProductTxt = nameProductTxt;
	}

	public JTextField getBarcodeProductTxt() {
		return barcodeProductTxt;
	}

	public void setBarcodeProductTxt(JTextField barcodeProductTxt) {
		this.barcodeProductTxt = barcodeProductTxt;
	}

	public JTextField getPriceProductTxt() {
		return priceProductTxt;
	}

	public void setPriceProductTxt(JTextField priceProductTxt) {
		this.priceProductTxt = priceProductTxt;
	}

	public JTextField getStockProductTxt() {
		return stockProductTxt;
	}

	public void setStockProductTxt(JTextField stockProductTxt) {
		this.stockProductTxt = stockProductTxt;
	}

	public JTextField getSearchProductTxt() {
		return searchProductTxt;
	}

	public void setSearchProductTxt(JTextField searchProductTxt) {
		this.searchProductTxt = searchProductTxt;
	}

	public JComboBox getCategoryProductCombo() {
		return categoryProductCombo;
	}

	public void setCategoryProductCombo(JComboBox categoryProductCombo) {
		this.categoryProductCombo = categoryProductCombo;
	}

	public JButton getAddProductBtn() {
		return addProductBtn;
	}

	public void setAddProductBtn(JButton addProductBtn) {
		this.addProductBtn = addProductBtn;
	}

	public JButton getEditProductBtn() {
		return editProductBtn;
	}

	public void setEditProductBtn(JButton editProductBtn) {
		this.editProductBtn = editProductBtn;
	}

	public JButton getDeleteProductBtn() {
		return deleteProductBtn;
	}

	public void setDeleteProductBtn(JButton deleteProductBtn) {
		this.deleteProductBtn = deleteProductBtn;
	}

	public JButton getSearchProductBtn() {
		return searchProductBtn;
	}

	public void setSearchProductBtn(JButton searchProductBtn) {
		this.searchProductBtn = searchProductBtn;
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
