package com.ilp03.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ilp03.entity.Customer;
import com.ilp03.entity.Ticket;

public class CustomerDAO {

	public static ArrayList<Customer> getCustomerDetails(Connection connection, int inputCustomerId) throws SQLException
	{
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		PreparedStatement preparedStatement= connection.prepareStatement("select * from customer where customer_id=?;");
		preparedStatement.setInt(1, inputCustomerId);
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next())
		{
			int customerId = resultSet.getInt(1);
			String customerName = resultSet.getString(2);
			long customerPhone = resultSet.getLong(3);
			String customerMail = resultSet.getString(4);
			String customerAddress = resultSet.getString(5);
			
			Customer customer = new Customer(customerId, customerName, customerPhone, customerMail, customerAddress);
			customerList.add(customer);
		}
		return customerList;
	}
	
	public static boolean isValidCustomerId(Connection connection, int inputCustomerId) throws SQLException
	{
		boolean found = false;
		PreparedStatement preparedStatement= connection.prepareStatement("select * from customer where customer_id=?;");
		preparedStatement.setInt(1, inputCustomerId);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next())
		{
			found = true;
		}
		resultSet.close();
		return found;
	}
}
