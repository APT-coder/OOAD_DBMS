package com.ilp03.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ilp03.entity.CustomerSupport;

public class CustomerSupportDAO {

	public static int addNewIssue(Connection connection, CustomerSupport customerSupport) throws SQLException
	{
		PreparedStatement preparedStatement = null;
		preparedStatement= connection.prepareStatement("insert into customer_support\r\n"
				+ "(emp_id,cust_id,issue_title,issue_desc,issue_id) values(?,?,?,?,?);\r\n");
		
		preparedStatement.setInt(1, customerSupport.getEmployee().getEmployeeId());
		preparedStatement.setInt(2, customerSupport.getCustomer().getCustomerId());
		preparedStatement.setString(3, customerSupport.getCustomerServiceIssueTitle());
		preparedStatement.setString(4, customerSupport.getCustomerServiceIssueDescription());
		preparedStatement.setInt(5, customerSupport.getCustomerServiceIssueId());
		
		preparedStatement.executeUpdate();
		return customerSupport.getCustomerServiceIssueId();
	}
}
