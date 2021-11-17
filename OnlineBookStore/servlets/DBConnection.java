package servlets;
import java.sql.*;
import java.util.ResourceBundle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection con;
	
	private DBConnection(){};
	
	static {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try {
			
			String url       = "jdbc:mysql://localhost:3307/onlinebookstore";
		    String username      = "root";
		    String password  = "secret";
		    
		    con = DriverManager.getConnection(url, username, password);
		
		}
		catch (SQLException e) {

			e.printStackTrace();
		
		}
		
		
	}//End of static block
	
	public static Connection getCon()
	{
		return con;
	}
}
