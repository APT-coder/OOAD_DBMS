package com.ilp03.service;

import java.sql.SQLException;

public interface TicketService {

	public void getAllTicketDetails(int choiceSub, int customerId);
	public int checkTicketId() throws SQLException;
}
