package com.ilp03.service;

import java.sql.SQLException;

public interface EmployeeService {

	public int checkEmployeeId() throws SQLException;
	public void displayEmployeeDetails(int employeeIdId) throws SQLException;
	public void createNewTicket(int employeeId) throws SQLException;
	public void createNewIssue(int employeeId) throws SQLException;
}
