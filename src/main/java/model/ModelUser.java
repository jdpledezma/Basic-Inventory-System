package model;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

public class ModelUser {
	private String username;
	private String password;
	private String userType;
	private ModelConnectDB modelConnect = new ModelConnectDB();
	
	public ModelUser(String username, String password, String userType) {
		this.username = username;
		this.password = password;
		this.userType = userType;
	}
	public ModelUser() {
		
	}
	
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	

	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public ResultSet userVerify(String username,String password) {
		try {
			Connection connect = modelConnect.connectDB();
			String sql = "SELECT username,password,usertype FROM user Where username = ? and password = ?";
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet resultS = statement.executeQuery();
			return resultS;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean searchUser(String username) {
		  try {
		    Connection connect = modelConnect.connectDB();
		    String sql = "SELECT username FROM user WHERE username = ?";
		    PreparedStatement statement = connect.prepareStatement(sql);
		    statement.setString(1, username);

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
	
	public boolean deleteUser(String username) {
		  try {
			  Connection connect = modelConnect.connectDB();
			  String sql = "DELETE FROM user where username = ?";
			  PreparedStatement sta = connect.prepareStatement(sql);
			  sta.setString(1, username);
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
	
	
	public ResultSet getAllUsers() {		 
		ResultSet result = null;
	    try {
	        Connection connect = modelConnect.connectDB();
	        String sql = "SELECT * FROM user";
	        PreparedStatement sta = connect.prepareStatement(sql);
	        result = sta.executeQuery();
	      
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null; 
	    }

	    return result;
	  }
	
	  public void addUser(String username,String password,String userType) {
			try {
				 Connection connect = modelConnect.connectDB();
				String sql = "INSERT INTO user (id,username,password,usertype) VALUES(?,?,?,?)";
				PreparedStatement sta = connect.prepareStatement(sql);
				sta.setInt(1, 0);
				sta.setString(2,username);
				sta.setString(3,password);
				sta.setString(4,userType.toLowerCase());
				sta.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}
		  }
	  
	  public boolean editUser(String username, String password, String userType, String userID) throws SQLException {
		    try (Connection connect = modelConnect.connectDB()) {
		        String sql = "UPDATE user SET username = ?, password = ?, usertype = ? WHERE id = ?";
		        PreparedStatement statement = connect.prepareStatement(sql);

		        statement.setString(1, username);
		        statement.setString(2, password);
		        statement.setString(3, userType.toLowerCase());
		        statement.setString(4, userID); 

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

	  
	  public ResultSet getUser(String username) {
		    try {
		    	Connection connect = modelConnect.connectDB();
		    	String sql = "SELECT  id , username, password, usertype FROM user WHERE username = ?";
	            PreparedStatement statement = connect.prepareStatement(sql);
	            statement.setString(1, username);
	            return statement.executeQuery();
		    } catch (Exception e) {
		        e.printStackTrace();
		        return null; 
		    }
		}
	  
	
	
	
}