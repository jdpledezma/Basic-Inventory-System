package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ModelConnectDB {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String database = "systema_inventario";
	private String host = "localhost";
	private String port = "3306";
	private String username = "jadape";
	private String password = "jadape.21";
	private String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
	
	protected Connection connectDB() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,username,password);
			return con;
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
	
}
