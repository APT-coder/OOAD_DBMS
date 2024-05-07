package com.ilp03.service;

import java.sql.SQLException;

public interface CustomerService {

	public int checkCustomerId() throws SQLException;
	public void displayCustomerDetails(int customerId) throws SQLException;
}
