package com.ilp03.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.ilp03.dao.ConnectionDAO;
import com.ilp03.dao.CustomerSupportDAO;
import com.ilp03.dao.EmployeeDAO;
import com.ilp03.dao.TicketDAO;
import com.ilp03.entity.Customer;
import com.ilp03.entity.CustomerSupport;
import com.ilp03.entity.Employee;
import com.ilp03.entity.Ticket;

public class TicketServiceImpl implements TicketService {

	@Override
	public void getAllTicketDetails(int choiceSub, int customerId) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionDAO.getConnection();
		ArrayList<Ticket> ticketList = null;
		Scanner scanner = new Scanner(System.in);
		String status = null;
		if(choiceSub == 1)
		{
			status = "In Progress";
		}
		try {
			ticketList = TicketDAO.getTicketDetails(connection, customerId, status);
			System.out.println("TicketID\tSupportEmployeeID\tSupportEmployeeName\tDate created\tDate Modified\tPriority\tStatus\tAssignedByEmpId\tAssignedByEmpName\tAssigneeEmpId\tAssigneeEmpName");
			for(Ticket ticket : ticketList)
			{
				System.out.println(ticket.getTicketId()+"\t"+ticket.getCreatedByEmployee().getEmployeeId()
						+"\t\t\t"+ticket.getCreatedByEmployee().getEmployeeName()+"\t\t\t"
						+ticket.getCreatedOn()+"\t"+ticket.getUpdatedOn()+"\t"+ticket.getTicketPriority()
						+"\t\t"+ticket.getTicketStatus()+"\t"+ticket.getAssignedByEmployee().getEmployeeId()
						+"\t\t"+ticket.getAssignedByEmployee().getEmployeeName()
						+"\t\t\t"+ticket.getAssignedToEmployee().getEmployeeId()
						+"\t\t"+ticket.getAssignedToEmployee().getEmployeeName());
			}
			ConnectionDAO.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public int checkTicketId() throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = ConnectionDAO.getConnection();
		int check = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter ticket id : ");
		int ticketId = scanner.nextInt();
		if(TicketDAO.isValidTicketId(connection, ticketId))
		{
			check = ticketId;
		}
		return check;
	}
}
