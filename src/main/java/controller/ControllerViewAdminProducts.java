package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.itextpdf.text.DocumentException;

import model.BarCodeGenerator;
import model.ModelPDF;
import model.ModelProduct;
import view.ViewAdminProducts;

public class ControllerViewAdminProducts implements ActionListener {
	ViewAdminProducts viewAdminProducts = new ViewAdminProducts();
	ModelProduct modelProduct;
	BarCodeGenerator barCodeGenerator = new BarCodeGenerator();
	private static String outputFilePath;
	
	public ControllerViewAdminProducts(ViewAdminProducts viewAdminProducts) {
		this.viewAdminProducts = viewAdminProducts;
		modelProduct = new ModelProduct();
		this.viewAdminProducts.getAddProductBtn().addActionListener(this);
		this.viewAdminProducts.getEditProductBtn().addActionListener(this);
		this.viewAdminProducts.getSearchProductBtn().addActionListener(this);
		this.viewAdminProducts.getDeleteProductBtn().addActionListener(this);
	}
	
	public void showScreen() throws SQLException {
		renderTable();
		chargeCategory();
		viewAdminProducts.setSize(690,500);
		viewAdminProducts.setDefaultCloseOperation(2);
		viewAdminProducts.setResizable(false);
		viewAdminProducts.setLocationRelativeTo(null);
		viewAdminProducts.setVisible(true);
	}
	
	public void renderTable() throws SQLException {
		String[] products = new String[6];
		viewAdminProducts.getTableModelProducts().setRowCount(0);; 
		ResultSet data = (ResultSet) modelProduct.getAllProducts();
		  while(data.next()) {
			  products[0] = data.getString(2);
			  products[1] = data.getString(3);
			  products[2] = data.getString(4);
			  products[3] = data.getString(5);
			  products[4] = data.getString(6);
			  viewAdminProducts.getTableModelProducts().addRow(products);  
		  }
		  
		  viewAdminProducts.getTableProducts().setModel(viewAdminProducts.getTableModelProducts());
	}
	
	public void chargeCategory() throws SQLException {
		ResultSet data = modelProduct.getAllCategory();
		while(data.next()) {
			String categoryName = data.getString("name");
			String categoryId = data.getString("id");
			viewAdminProducts.getCategoryProductCombo().addItem(categoryName);
		}
	}
	
	public void addProduct() throws SQLException, IOException, DocumentException {
		String name = viewAdminProducts.getNameProductTxt().getText();
		String barcode = viewAdminProducts.getBarcodeProductTxt().getText();
		String price = viewAdminProducts.getPriceProductTxt().getText();
		String stock = viewAdminProducts.getStockProductTxt().getText();
		String category = (String) viewAdminProducts.getCategoryProductCombo().getSelectedItem();
		
		boolean product_check = modelProduct.searchProduct(barcode);
		
		if(name.isEmpty() || barcode.isEmpty() || price.isEmpty() || stock.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Sorry. Complete the fields");
			return;
		}
		
		if(product_check) {
			JOptionPane.showMessageDialog(null, "Sorry. Product Already registered");
			return;
		}else {
			modelProduct.addProduct(name, barcode, price,stock,category);
			JOptionPane.showMessageDialog(null, "Product Registered");
			barCodeGenerator.generateCode(barcode,name);
			renderTable();
		}
		
	}
	
	public void editProduct() throws SQLException {
		String name = viewAdminProducts.getNameProductTxt().getText();
		String barcode = viewAdminProducts.getBarcodeProductTxt().getText();
		String price = viewAdminProducts.getPriceProductTxt().getText();
		String stock = viewAdminProducts.getStockProductTxt().getText();
		String category = (String) viewAdminProducts.getCategoryProductCombo().getSelectedItem();
		
		if(name.isEmpty() || barcode.isEmpty() || price.isEmpty() || stock.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Sorry. Complete the fields");
			return;
		}
		modelProduct.editProduct(name,barcode,price,stock,category);
		JOptionPane.showMessageDialog(null, "Product Update");
		renderTable();
	
	}
	
	public void getProduct() {
		try {
	    String barcode = viewAdminProducts.getSearchProductTxt().getText();
	    if(barcode.isEmpty()) {
	    	JOptionPane.showMessageDialog(null, "Complete Search Field");
	    	return;
	    }
	    ResultSet user = modelProduct.getProduct(barcode);
	    if(user.next()) {
	    	viewAdminProducts.getNameProductTxt().setText(user.getString("name"));
	    	viewAdminProducts.getBarcodeProductTxt().setText(user.getString("barcode"));
	    	viewAdminProducts.getPriceProductTxt().setText(user.getString("price"));
	    	viewAdminProducts.getStockProductTxt().setText(user.getString("stock"));
	    	viewAdminProducts.getCategoryProductCombo().setSelectedItem(user.getString("category"));
	    }else {
	    	JOptionPane.showMessageDialog(null, "Sorry.User Not Found");
	    }
	    	
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    
	}
	
	public void deleteProduct() throws SQLException {
		String barcode = viewAdminProducts.getBarcodeProductTxt().getText();
		boolean user_check = modelProduct.searchProduct(barcode);
		if(user_check) {
			modelProduct.deleteProduct(barcode);
			JOptionPane.showMessageDialog(null, "Product Deleted");
			renderTable();
		}else {
			JOptionPane.showMessageDialog(null, "Sorry. User Not found");
		}
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == viewAdminProducts.getAddProductBtn()) {
			try {
				addProduct();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (DocumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
		
		if(e.getSource() == viewAdminProducts.getEditProductBtn()) {
			try {
				editProduct();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == viewAdminProducts.getDeleteProductBtn()) {
			try {
				deleteProduct();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == viewAdminProducts.getSearchProductBtn()) {
			getProduct();
		}
		
		
	}

}
