package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelCategory {
	private ModelConnectDB modelConnect = new ModelConnectDB();
	
	public ModelCategory() {
		
	}
	
	public boolean searchCategory(String name) {
		  try {
		    Connection connect = modelConnect.connectDB();
		    String sql = "SELECT id,name FROM category WHERE name = ?";
		    PreparedStatement statement = connect.prepareStatement(sql);
		    statement.setString(1, name);

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
	
	public ResultSet getAllCategory() {		 
		ResultSet result = null;
	    try {
	        Connection connect = modelConnect.connectDB();
	        String sql = "SELECT * FROM category";
	        PreparedStatement sta = connect.prepareStatement(sql);
	        result = sta.executeQuery();
	      
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null; 
	    }

	    return result;
	  }
	
	 public void addCategory(String name) {
			try {
				 Connection connect = modelConnect.connectDB();
				String sql = "INSERT INTO category (id,name) VALUES(?,?)";
				PreparedStatement sta = connect.prepareStatement(sql);
				sta.setInt(1, 0);
				sta.setString(2,name);
				sta.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}
		  }
	 
	 public boolean deleteCategory(String name) {
		  try {
			  Connection connect = modelConnect.connectDB();
			  String sql = "DELETE FROM category where name = ?";
			  PreparedStatement sta = connect.prepareStatement(sql);
			  sta.setString(1, name);
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
	 
	 public ResultSet getCategory(String name) {
		    try {
		    	Connection connect = modelConnect.connectDB();
		    	String sql = "SELECT  id , name FROM category WHERE name = ?";
	            PreparedStatement statement = connect.prepareStatement(sql);
	            statement.setString(1, name);
	            return statement.executeQuery();
		    } catch (Exception e) {
		        e.printStackTrace();
		        return null; 
		    }
		}
	  
	  
	
	
}
