package model;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ModelShoppingCart {
	private ArrayList<ModelProduct> products;
	ModelConnectDB connect = new ModelConnectDB();
	
	public ModelShoppingCart() {
	this.products = new ArrayList<>();	
	}
	
	public void addProduct(ModelProduct product) {
		if(products.contains(product)) {
			ModelProduct existProduct = (ModelProduct) products.stream()
					.filter(p -> p.equals(product))
					.findFirst()
					.get();
			int newCantity = Integer.parseInt(product.getCantity());
			int oldCantity = Integer.parseInt(existProduct.getCantity());
			String finalNewCantity = String.valueOf(oldCantity + newCantity);
			if(newCantity > Integer.parseInt(existProduct.getStock())) {
				System.out.println("Error");
				return;
			}
			existProduct.setCantity(finalNewCantity);
		}else {
			products.add(product);
		}
	}
	
	public void updateStockBD(ArrayList<ModelProduct> cart) {
		try {
			for(ModelProduct product : cart) {
				String barcode = product.getBarcode();
				int cantityProduct = Integer.parseInt(product.getCantity());
				   String updateQuery = "UPDATE product SET stock = stock - ? WHERE barcode = ?";
		            PreparedStatement updateStatement = connect.connectDB().prepareStatement(updateQuery);
		            updateStatement.setInt(1, cantityProduct);
		            updateStatement.setString(2, barcode );
		            updateStatement.executeUpdate();
			}
		}catch(Exception e) {
			
		}
	}
	
	public void deleteProduct(ModelProduct product) {
		products.remove(product);
	}
	
	public void updateCantity(ModelProduct product, int newCantity) {
			product.setCantity(String.valueOf(newCantity));
	} 
	
	public void updateStock(ModelProduct product) {
		int cantity = Integer.parseInt(product.getCantity());
		int stock =Integer.parseInt(product.getStock());
		if(cantity > stock) {
			System.out.println("Error");
		}
		
		String result = String.valueOf(stock-cantity); 
		product.setStock(result);
	}
	
	public double calculateTotal() {
		double total = 0;
		for(ModelProduct product : products) {
			total += Double.parseDouble(product.getCantity()) *  Double.parseDouble(product.getPrice());
		}
		return total;
	}

	public ArrayList<ModelProduct> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<ModelProduct> products) {
		this.products = products;
	}
	
	
	
}
