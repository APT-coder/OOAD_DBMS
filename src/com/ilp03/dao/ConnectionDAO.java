package com.ilp03.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {

	public static Connection getConnection()
	{
		String connectionString = "jdbc:mysql://localhost:3306/customer_service_ticketing?useSSL=false";
		String userName = "root";
		String userPassword = "rootASW";
		
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(connectionString, userName, userPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeConnection(Connection connection)
	{
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
