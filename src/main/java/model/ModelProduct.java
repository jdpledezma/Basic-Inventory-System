package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ModelProduct {
	private String barcode,name,price,stock,cantity;
	private ModelConnectDB modelConnect = new ModelConnectDB();
	
	
	public ModelProduct() {
		
	} 
public ModelProduct(String barcode,String name,String price,String stock, String cantity) {
		this.barcode = barcode;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.cantity = cantity;
	} 
	
	
	
	

	public ResultSet getAllCategory() {		 
		ResultSet result = null;
	    try {
	        Connection connect = modelConnect.connectDB();
	        String sql = "SELECT id,name FROM category ORDER BY name LIMIT 10";
	        PreparedStatement sta = connect.prepareStatement(sql);
	        result = sta.executeQuery();
	      
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null; 
	    }

	    return result;
	  }
	
	public ResultSet getAllProducts() {		 
		ResultSet result = null;
	    try {
	        Connection connect = modelConnect.connectDB();
	        String sql = "SELECT * FROM product";
	        PreparedStatement sta = connect.prepareStatement(sql);
	        result = sta.executeQuery();
	      
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null; 
	    }

	    return result;
	  }
	
	public boolean searchProduct(String barcode) {
		  try {
		    Connection connect = modelConnect.connectDB();
		    String sql = "SELECT * FROM product WHERE barcode = ?";
		    PreparedStatement statement = connect.prepareStatement(sql);
		    statement.setString(1, barcode);

		    ResultSet resultSet = statement.executeQuery();

		    if (resultSet.next()) {
		      return true;
		    } else {
		      return false;
		    }
		  } catch (Exception e) {
		    e.printStackTrace();
		    return false; 
		  } 
		}

	
	public void addProduct(String name, String barcode, String price, String stock, String category) {
		  try {
		    Connection connect = modelConnect.connectDB();
		    int stock_int = Integer.parseInt(stock);
		    String sql = "INSERT INTO product (name, barcode, price, stock, category) VALUES (?, ?, ?, ?, ?)";
		    PreparedStatement sta = connect.prepareStatement(sql);
		    sta.setString(1, name);
		    sta.setString(2, barcode);
		    sta.setString(3, price);
		    sta.setInt(4, stock_int);
		    sta.setString(5, category);
		    sta.executeUpdate();
		  } catch (Exception e) {
		    e.printStackTrace();
		  }
		}
	
	public boolean deleteProduct(String barcode) {
		  try {
			  Connection connect = modelConnect.connectDB();
			  String sql = "DELETE FROM product where barcode = ?";
			  PreparedStatement sta = connect.prepareStatement(sql);
			  sta.setString(1, barcode);
			  int rowsUpdate = sta.executeUpdate();
			  if(rowsUpdate > 0) {
				  return true;
			  }else {
				  return false;
			  }
			  
		  }catch(Exception e) {
			  e.printStackTrace();
			  return false;
		  }
	  }
	
	public boolean editProduct(String name, String barcode, String price, String stock, String category) throws SQLException {
	    try (Connection connect = modelConnect.connectDB()) {
	        String sql = "UPDATE product SET name = ?, price = ?, stock = ?, category = ? WHERE barcode = ?";
	        PreparedStatement statement = connect.prepareStatement(sql);

	        statement.setString(1, name);
	        statement.setString(2, price);
	        statement.setString(3, stock);
	        statement.setString(4, category);
	        statement.setString(5, barcode); 

	        int rowsUpdated = statement.executeUpdate();

	        if (rowsUpdated > 0) {
	            return true;
	        } else {
	            return false;
	        }
	    } catch (SQLException e) {
	        throw e;
	    }
	}

	
	
	
	public ResultSet getAllProductsWithCategory() throws SQLException {
	    ResultSet result = null;
	    try (Connection connect = modelConnect.connectDB()) {
	      String sql = "SELECT p.id AS product_id, p.name AS product_name, c.name AS category_name " +
	                   "FROM products p " +
	                   "INNER JOIN categories c ON p.category_id = c.id;";
	      PreparedStatement statement = connect.prepareStatement(sql);
	      result = statement.executeQuery();
	    } catch (SQLException e) {
	      throw e; 
	    }
	    return result;
	  }
	
	  public ResultSet getProduct(String barcode) {
		    try {
		    	Connection connect = modelConnect.connectDB();
		    	String sql = "SELECT  name,barcode,price,stock,category FROM product WHERE barcode = ?";
	            PreparedStatement statement = connect.prepareStatement(sql);
	            statement.setString(1, barcode);
	            return statement.executeQuery();
		    } catch (Exception e) {
		        e.printStackTrace();
		        return null; 
		    }
		}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public ModelConnectDB getModelConnect() {
		return modelConnect;
	}
	public void setModelConnect(ModelConnectDB modelConnect) {
		this.modelConnect = modelConnect;
	}
	public String getCantity() {
		return cantity;
	}
	public void setCantity(String cantity) {
		this.cantity = cantity;
	}
	
	
	  
	  
	
}
