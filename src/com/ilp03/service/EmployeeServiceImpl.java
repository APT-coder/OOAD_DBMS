package com.ilp03.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.ilp03.dao.ConnectionDAO;
import com.ilp03.dao.CustomerDAO;
import com.ilp03.dao.CustomerSupportDAO;
import com.ilp03.dao.EmployeeDAO;
import com.ilp03.dao.TicketDAO;
import com.ilp03.entity.Customer;
import com.ilp03.entity.CustomerSupport;
import com.ilp03.entity.Employee;
import com.ilp03.entity.Ticket;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public int checkEmployeeId() throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = ConnectionDAO.getConnection();
		int check = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter employee id : ");
		int employeeId = scanner.nextInt();
		if(EmployeeDAO.isValidEmployeeId(connection, employeeId))
		{
			check = employeeId;
		}
		return check;
	}

	@Override
	public void displayEmployeeDetails(int employeeId) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void createNewIssue(int employeeId) throws SQLException
	{
        CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
        Connection connection = ConnectionDAO.getConnection();
        Scanner scanner = new Scanner(System.in);
		int customerId = customerServiceImpl.checkCustomerId();
		if (customerId != 0) 
        {
			System.out.println("Enter issue title : ");
			String issueTitle = scanner.nextLine();
			System.out.println("Enter issue description : ");
			String issueDesc = scanner.nextLine();
			System.out.println("Enter issue id : ");
			int issueId = scanner.nextInt();
			scanner.nextLine();
			Employee createdByEmployee = new Employee(employeeId);
			Customer customer = new Customer(customerId);
			CustomerSupport customerSupport = new CustomerSupport(createdByEmployee, customer, issueTitle, issueDesc, issueId);
			CustomerSupportDAO.addNewIssue(connection, customerSupport);
			
			System.out.println("\nNew issue for customer id "+customerId+" added successfully by employee id "+employeeId+" \n");
        }
		else 
        {
            System.out.println("\nCustomer ID does not exist\n");
        }
	}
	
	@Override
	public void createNewTicket(int employeeId) throws SQLException
	{
        TicketServiceImpl ticketServiceImpl = new TicketServiceImpl();
        Connection connection = ConnectionDAO.getConnection();
        Scanner scanner = new Scanner(System.in);
		int ticketId = ticketServiceImpl.checkTicketId();
		if (ticketId != 0) 
        {
			System.out.println("Enter ticket priority : ");
			String ticketPriority = scanner.nextLine();
			System.out.println("Enter ticket status : ");
			String ticketStatus = scanner.nextLine();
			System.out.println("Enter assigner employee id : ");
			int assignedBy = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter assigned employee id : ");
			int assignedTo = scanner.nextInt();
			scanner.nextLine();
			
			Employee createdByEmployee = new Employee(employeeId);
			Employee assignedByEmployee = new Employee(assignedBy);
			Employee assignedToEmployee = new Employee(assignedTo);
			Ticket ticket = new Ticket(ticketId, createdByEmployee, ticketPriority, ticketStatus, assignedByEmployee, assignedToEmployee);
			TicketDAO.addNewTicket(connection, ticket);
			
			System.out.println("\nNew ticket with id "+ticketId+" added successfully\n");
        }
		else 
        {
            System.out.println("\nTicket ID already exists !\n");
        }
	}
}
