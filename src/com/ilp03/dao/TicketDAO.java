package com.ilp03.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ilp03.entity.CustomerSupport;
import com.ilp03.entity.Employee;
import com.ilp03.entity.Ticket;

public class TicketDAO {

	public static ArrayList<Ticket> getTicketDetails(Connection connection, int inputCustomerId, String status) throws SQLException
	{
		ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
		PreparedStatement preparedStatement = null;
		if(status != null)
		{
				preparedStatement= connection.prepareStatement("SELECT  *\r\n"
					+ "FROM ticket t \r\n"
					+ "JOIN customer_support cs ON t.ticket_id = cs.issue_id \r\n"
					+ "JOIN employee e_emp ON cs.emp_id = e_emp.emp_id \r\n"
					+ "JOIN employee e_assigner ON t.assigned_by = e_assigner.emp_id \r\n"
					+ "JOIN employee e_assignee ON t.assignee_emp = e_assignee.emp_id \r\n"
					+ "JOIN customer c ON cs.cust_id = c.customer_id \r\n"
					+ "WHERE cs.cust_id = ? AND t.status = ?;\r\n");
				preparedStatement.setString(2, status);
		}
		else
		{
			preparedStatement= connection.prepareStatement("SELECT * \r\n"
					+ "FROM ticket t \r\n"
					+ "JOIN customer_support cs ON t.ticket_id = cs.issue_id \r\n"
					+ "JOIN employee e_emp ON cs.emp_id = e_emp.emp_id \r\n"
					+ "JOIN employee e_assigner ON t.assigned_by = e_assigner.emp_id \r\n"
					+ "JOIN employee e_assignee ON t.assignee_emp = e_assignee.emp_id \r\n"
					+ "JOIN customer c ON cs.cust_id = c.customer_id \r\n"
					+ "WHERE cs.cust_id = ?;\r\n");
		}
		preparedStatement.setInt(1, inputCustomerId);
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next())
		{
			int createdByEmpId = resultSet.getInt(3);
			String createdByEmpName = resultSet.getString("e_emp.emp_name");
			Employee createdByEmployee = new Employee(createdByEmpId, createdByEmpName);
			
			int assignedByEmpId = resultSet.getInt(8);
			String assignedByEmpName = resultSet.getString("e_assigner.emp_name");
			Employee assignedByEmployee = new Employee(assignedByEmpId, assignedByEmpName);
			
			int assigneeEmpId = resultSet.getInt(9);
			String assigneeEmpName = resultSet.getString("e_assignee.emp_name");
			Employee assigneeEmployee = new Employee(assigneeEmpId, assigneeEmpName);
			
			int ticketId = resultSet.getInt(2);
			Date createdOn = resultSet.getDate(4);
			Date modifiedOn = resultSet.getDate(5);
			String priority = resultSet.getString(6);
			String ticketStatus = resultSet.getString(7);
			Ticket ticket = new Ticket(ticketId, createdByEmployee, createdOn, modifiedOn, priority, ticketStatus, assignedByEmployee, assigneeEmployee);
			
			ticketList.add(ticket);
		}
		resultSet.close();
		return ticketList;
	}
	
	public static void addNewTicket(Connection connection, Ticket ticket) throws SQLException
	{
		PreparedStatement preparedStatement = null;
		preparedStatement= connection.prepareStatement("insert into ticket \r\n"
				+ "(ticket_id,created_by,priority,status,assigned_by,assignee_emp) \r\n"
				+ "values(?,?,?,?,?,?);");
		preparedStatement.setInt(1, ticket.getTicketId());
		preparedStatement.setInt(2, ticket.getCreatedByEmployee().getEmployeeId());
		preparedStatement.setString(3, ticket.getTicketPriority());
		preparedStatement.setString(4, ticket.getTicketStatus());
		preparedStatement.setInt(5, ticket.getAssignedByEmployee().getEmployeeId());
		preparedStatement.setInt(6, ticket.getAssignedToEmployee().getEmployeeId());
		
		preparedStatement.executeUpdate();
	}
	
	public static boolean isValidTicketId(Connection connection, int inputTicketId) throws SQLException
	{
		boolean found = false;
		PreparedStatement preparedStatement= connection.prepareStatement("select * from customer_support where issue_id=?;");
		preparedStatement.setInt(1, inputTicketId);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next())
		{
			PreparedStatement preparedStatementSub= connection.prepareStatement("select * from ticket where ticket_id=?;");
			preparedStatementSub.setInt(1, inputTicketId);
			ResultSet resultSetSub = preparedStatementSub.executeQuery();
			if(!resultSetSub.next())
			{
				found = true;
			}
			resultSetSub.close();
		}
		resultSet.close();
		return found;
	}
}
