package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ModelEmployeeSale {
	private ModelConnectDB modelConnect = new ModelConnectDB();
	
	public ResultSet searchClient(String dni) {
		  try {
		    Connection connect = modelConnect.connectDB();
		    String sql = "SELECT firstname,lastname,address,telephone FROM client WHERE dni = ?";
		    PreparedStatement statement = connect.prepareStatement(sql);
		    statement.setString(1, dni);

		    ResultSet resultSet = statement.executeQuery();

		    if (resultSet.next()) {
		      return resultSet;
		    } else {
		      return null;
		    }
		  } catch (Exception e) {
		    e.printStackTrace();
		    return null; 
		  } 
		}
	
	  public void addClient(String firstname,String lastname,String address,String telephone,String dni) {
			try {
				 Connection connect = modelConnect.connectDB();
				String sql = "INSERT INTO client (dni,firstname,lastname,address,telephone) VALUES(?,?,?,?,?)";
				PreparedStatement sta = connect.prepareStatement(sql);
				sta.setString(1, dni);
				sta.setString(2,firstname);
				sta.setString(3,lastname);
				sta.setString(4,address);
				sta.setString(5,telephone);
				sta.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}
		  }
	  
		public ResultSet searchProduct(String barcode) {
			  try {
			    Connection connect = modelConnect.connectDB();
			    String sql = "SELECT * FROM product WHERE barcode = ?";
			    PreparedStatement statement = connect.prepareStatement(sql);
			    statement.setString(1, barcode);

			    ResultSet resultSet = statement.executeQuery();

			    if (resultSet.next()) {
			      return resultSet;
			    } else {
			      return null;
			    }
			  } catch (Exception e) {
			    e.printStackTrace();
			    return null; 
			  } 
			}
	  
	
}
