package com.ilp03.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ilp03.entity.Customer;
import com.ilp03.entity.Employee;

public class EmployeeDAO {
	
	public static boolean isValidEmployeeId(Connection connection, int inputEmployeeId) throws SQLException
	{
		boolean found = false;
		PreparedStatement preparedStatement= connection.prepareStatement("select * from employee where emp_id=?;");
		preparedStatement.setInt(1, inputEmployeeId);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next())
		{
			found = true;
		}
		resultSet.close();
		return found;
	}
}
