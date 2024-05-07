package com.ilp03.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.ilp03.dao.ConnectionDAO;
import com.ilp03.dao.CustomerDAO;
import com.ilp03.dao.TicketDAO;
import com.ilp03.entity.Customer;
import com.ilp03.entity.Ticket;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public int checkCustomerId() throws SQLException
	{
		Connection connection = ConnectionDAO.getConnection();
		int check = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter customer id : ");
		int customerId = scanner.nextInt();
		if(CustomerDAO.isValidCustomerId(connection, customerId))
		{
			check = customerId;
		}
		return check;
	}

	@Override
	public void displayCustomerDetails(int customerId) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = ConnectionDAO.getConnection();
		ArrayList<Customer> customerList = null;
		try {
			customerList = CustomerDAO.getCustomerDetails(connection, customerId);
			System.out.println("CustomerID\tCustomer Name\tCustomer Phone\tCustomer Mail\t\tCustomer Address");
			for(Customer customer : customerList)
			{
				System.out.println(customer.getCustomerId()+"\t\t"+customer.getCustomerName()
				+"\t"+customer.getCustomerPhone()+"\t"+customer.getCustomerMail()
				+"\t"+customer.getCustomerAddress());
			}
			ConnectionDAO.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
