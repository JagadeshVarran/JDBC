package ConnectionManager;

import java.sql.*;
public class ConnectionManager
{
	//Create connection object
	Connection con = null;
	
	public Connection establishmentConnection() throws ClassNotFoundException,SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testing","root","root");
				 return con;
	}
	public void closeconnection() throws SQLException
	{
		con.close();
	}
		
	}
