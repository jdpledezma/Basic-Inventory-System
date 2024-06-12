package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JOptionPane;

import model.ModelEmployeeSale;
import model.ModelPDF;
import model.ModelProduct;
import model.ModelShoppingCart;
import view.ViewEmployee;
import view.ViewEmployeeSale;

public class ControllerViewEmployeeSale implements ActionListener {
	ViewEmployeeSale viewEmployeeSale = new ViewEmployeeSale();
	ModelEmployeeSale modelEmployeeSale; ModelShoppingCart cartShopping;
	ModelPDF modelPDF;
	public ControllerViewEmployeeSale(ViewEmployeeSale viewEmployeeSale){
		this.viewEmployeeSale = viewEmployeeSale;
		modelEmployeeSale = new ModelEmployeeSale();
		cartShopping = new ModelShoppingCart();
		modelPDF = new ModelPDF();
		this.viewEmployeeSale.getSearchBtn().addActionListener(this);
		this.viewEmployeeSale.getAddClientBtn().addActionListener(this);
		this.viewEmployeeSale.getSearchProductBtn().addActionListener(this);
		this.viewEmployeeSale.getAddProductBtn().addActionListener(this);
		this.viewEmployeeSale.getBillBtn().addActionListener(this);
		this.viewEmployeeSale.getDeleteProductBtn().addActionListener(this);
	}
	
	public void showScreen() {
		renderTable();
		viewEmployeeSale.setTitle("Sale Data");
		viewEmployeeSale.setSize(750,600);
		viewEmployeeSale.setLocationRelativeTo(null);
		viewEmployeeSale.setDefaultCloseOperation(2);
		viewEmployeeSale.setResizable(false);
		viewEmployeeSale.setVisible(true);
	}

	public void renderTable() {
		ArrayList<ModelProduct> cart = cartShopping.getProducts();
		viewEmployeeSale.getTableModelProducts().setRowCount(0);

		String[] product = new String[5];
		for (ModelProduct p : cart) {
			boolean productFound = false;
			for (int i = 0; i < viewEmployeeSale.getTableModelProducts().getRowCount(); i++) {
				String existingBarcode = (String) viewEmployeeSale.getTableModelProducts().getValueAt(i, 1);
				if (existingBarcode.equals(p.getBarcode())) {
					productFound = true;
					int existingQuantity = Integer.parseInt((String) viewEmployeeSale.getTableModelProducts().getValueAt(i, 4));
					int existingStock = Integer.parseInt((String) viewEmployeeSale.getTableModelProducts().getValueAt(i, 3));
					int newQuantity = existingQuantity + Integer.parseInt(p.getCantity());
					viewEmployeeSale.getTableModelProducts().setValueAt(String.valueOf(newQuantity), i, 4);
					viewEmployeeSale.getTableModelProducts().setValueAt(String.valueOf(existingStock - Integer.parseInt(p.getCantity())), i, 3);
					break;
				}
			}

			if (!productFound) {
				product[0] = p.getName();
				product[1] = p.getBarcode();
				product[2] = p.getPrice();
				product[3] = p.getStock();
				product[4] = String.valueOf(p.getCantity());
				viewEmployeeSale.getTableModelProducts().addRow(product);
			}
		}

		double totalPrice = cartShopping.calculateTotal();
		viewEmployeeSale.getTotalProductTxt().setText(String.valueOf(totalPrice));
	}




	public void searchUser() throws SQLException {
		String dni = viewEmployeeSale.getClientDniTxt().getText();
		ResultSet clientCheck = modelEmployeeSale.searchClient(dni);
		
		if(clientCheck != null) {
				System.out.println(clientCheck.getString(1));
				viewEmployeeSale.getClientFirstNameTxt().setText(clientCheck.getString(1));
				viewEmployeeSale.getClientLastNameTxt().setText(clientCheck.getString(2));
				viewEmployeeSale.getClientAddressTxt().setText(clientCheck.getString(3));
				viewEmployeeSale.getClientTelephoneTxt().setText(clientCheck.getString(4));
				viewEmployeeSale.getClientFirstNameTxt().setEditable(false);
				viewEmployeeSale.getClientLastNameTxt().setEditable(false);
				viewEmployeeSale.getClientAddressTxt().setEditable(false);
				viewEmployeeSale.getClientTelephoneTxt().setEditable(false);
				viewEmployeeSale.getCodeProductTxt().setEditable(true);
				viewEmployeeSale.getCantityProductTxt().setEditable(true);
		
		}else {
			JOptionPane.showMessageDialog(null, "Sorry. User Not Found");
			viewEmployeeSale.getClientFirstNameTxt().setText("");
			viewEmployeeSale.getClientLastNameTxt().setText("");
			viewEmployeeSale.getClientAddressTxt().setText("");
			viewEmployeeSale.getClientTelephoneTxt().setText("");
			viewEmployeeSale.getClientFirstNameTxt().setEditable(true);
			viewEmployeeSale.getClientLastNameTxt().setEditable(true);
			viewEmployeeSale.getClientAddressTxt().setEditable(true);
			viewEmployeeSale.getClientTelephoneTxt().setEditable(true);
		}		
	}
	
	public void getProduct() {
		try {
	    String barcode = viewEmployeeSale.getCodeProductTxt().getText();
	    if(barcode.isEmpty()) {
	    	JOptionPane.showMessageDialog(null, "Complete Search Field");
	    	return;
	    }
	    ResultSet product = modelEmployeeSale.searchProduct(barcode);
	    if(product != null) {
	    	viewEmployeeSale.getNameProductTxt().setText(product.getString("name"));
	    	viewEmployeeSale.getStockProductTxt().setText(product.getString("stock"));
	    	viewEmployeeSale.getPriceProductTxt().setText(product.getString("price"));
	    }else {
	    	JOptionPane.showMessageDialog(null, "Sorry.Product Not Found");
	    }
	    	
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    
	}
	
	public void addProductCart() {
		String name = viewEmployeeSale.getNameProductTxt().getText();
		String barcode = viewEmployeeSale.getCodeProductTxt().getText();
		String price = viewEmployeeSale.getPriceProductTxt().getText();
		String stock = viewEmployeeSale.getStockProductTxt().getText();
		String cantity = viewEmployeeSale.getCantityProductTxt().getText();
		if(cantity.isEmpty()){
			JOptionPane.showMessageDialog(null, "Please, Select the Cantity");
			return;
		}
		ModelProduct product = new ModelProduct();
		product.setBarcode(barcode);
		product.setName(name);
		product.setPrice(price);
		product.setStock(stock);
		product.setCantity(cantity);
		
		if(Integer.parseInt(cantity) > Integer.parseInt(stock)) {
			JOptionPane.showMessageDialog(null, "Sorry.Item not available");
			return;
		}
		
		cartShopping.addProduct(product);
		cartShopping.updateStock(product);
		renderTable();
		viewEmployeeSale.getNameProductTxt().setText("");
		viewEmployeeSale.getCodeProductTxt().setText("");
		viewEmployeeSale.getPriceProductTxt().setText("");
		viewEmployeeSale.getStockProductTxt().setText("");
		viewEmployeeSale.getCantityProductTxt().setText("");
	}

	public void deleteProductCart() {
		String codeProduct = viewEmployeeSale.getCodeProductTxt().getText();

		if (codeProduct.isEmpty() || cartShopping.getProducts().isEmpty()) {
			System.out.println("Please enter a product code or add products to your cart first.");
			return;
		}

		String barcode = codeProduct; // Modify if barcode is an integer or other type

		ArrayList<ModelProduct> products = cartShopping.getProducts();
		boolean productRemoved = false;
		for (int i = 0; i < products.size(); i++) {
			ModelProduct product = products.get(i);
			if (product.getBarcode().equals(barcode)) {
				int newCantity = Integer.parseInt(product.getCantity()) - 1;
				product.setCantity(String.valueOf(newCantity));
				if (product.getCantity().equals("0")) {
					products.remove(i);
				}
				productRemoved = true;
				System.out.println("Removed 1 item of product with code " + barcode + " from cart.");
				renderTable();
				break;
			}
		}

		// 4. Handle no product found
		if (!productRemoved) {
			System.out.println("Product with code " + barcode + " not found in cart.");
		}
	}
	
	public void addUser() {
		String firstname = viewEmployeeSale.getClientFirstNameTxt().getText();
		String lastname = viewEmployeeSale.getClientLastNameTxt().getText();
		String address = viewEmployeeSale.getClientAddressTxt().getText();
		String telephone = viewEmployeeSale.getClientTelephoneTxt().getText();
		String dni = viewEmployeeSale.getClientDniTxt().getText();
		
		if(firstname.isEmpty() || lastname.isEmpty() || address.isEmpty() || telephone.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Sorry. Complete the fields");
		}
		modelEmployeeSale.addClient(firstname, lastname, address, telephone,dni);
		JOptionPane.showMessageDialog(null, "Client Registered");
		viewEmployeeSale.getClientFirstNameTxt().setText("");
		viewEmployeeSale.getClientLastNameTxt().setText("");
		viewEmployeeSale.getClientAddressTxt().setText("");
		viewEmployeeSale.getClientTelephoneTxt().setText("");
		viewEmployeeSale.getClientFirstNameTxt().setText("");
		viewEmployeeSale.getClientLastNameTxt().setText("");
		viewEmployeeSale.getClientAddressTxt().setText("");
		viewEmployeeSale.getClientTelephoneTxt().setText("");
		viewEmployeeSale.getNameProductTxt().setText("");
		viewEmployeeSale.getCodeProductTxt().setText("");
		viewEmployeeSale.getPriceProductTxt().setText("");
		viewEmployeeSale.getStockProductTxt().setText("");
		viewEmployeeSale.getCantityProductTxt().setText("");
		viewEmployeeSale.getClientDniTxt().setText("");

	}
	
	public void bill() {
		String nameClient = viewEmployeeSale.getClientFirstNameTxt().getText();
		String dniClient = viewEmployeeSale.getClientDniTxt().getText();
		ArrayList<ModelProduct> cartBill = cartShopping.getProducts();
		LocalDateTime dateNow = LocalDateTime.now(); 
		Double total = cartShopping.calculateTotal();
		String newPdfFile = "/home/jadape/Documentos/eclipse-workspace/BasicSystemInventory/src/main/java/resource/bill.pdf";
		modelPDF.generateBill(dniClient,nameClient,total,dateNow,newPdfFile,cartBill);
		viewEmployeeSale.getClientFirstNameTxt().setText("");
		viewEmployeeSale.getClientLastNameTxt().setText("");
		viewEmployeeSale.getClientAddressTxt().setText("");
		viewEmployeeSale.getClientTelephoneTxt().setText("");
		viewEmployeeSale.getClientFirstNameTxt().setText("");
		viewEmployeeSale.getClientLastNameTxt().setText("");
		viewEmployeeSale.getClientAddressTxt().setText("");
		viewEmployeeSale.getClientTelephoneTxt().setText("");
		viewEmployeeSale.getClientDniTxt().setText("");
		cartShopping.getProducts().clear();
		JOptionPane.showMessageDialog(null, "Invoice Made Correctly ");
			modelPDF.openPDF(newPdfFile);
		renderTable();
	};
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == viewEmployeeSale.getSearchBtn()) {
			try {
				searchUser();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == viewEmployeeSale.getAddClientBtn()) {
			addUser();
		}
		
		if(e.getSource() == viewEmployeeSale.getSearchProductBtn()) {
			getProduct();
		}
		
		if(e.getSource() == viewEmployeeSale.getAddProductBtn()) {
			addProductCart();
		}
		
		if(e.getSource() == viewEmployeeSale.getDeleteProductBtn()) {
			deleteProductCart();
		}
		
		if(e.getSource() == viewEmployeeSale.getBillBtn()) {

			ArrayList<ModelProduct> cart = cartShopping.getProducts();
			bill();
			cartShopping.updateStockBD(cart);
			}
			

		}
	}


