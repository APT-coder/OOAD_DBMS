package com.ilp03.utility;

import java.sql.SQLException;
import java.util.Scanner;

import com.ilp03.service.CustomerServiceImpl;
import com.ilp03.service.EmployeeServiceImpl;
import com.ilp03.service.TicketServiceImpl;

public class TicketUtility {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		TicketServiceImpl ticketServiceImpl = new TicketServiceImpl();
		Scanner scanner = new Scanner(System.in);
		char goToMainMenu = 'y';
		int choice;
		do
		{
			System.out.println("+-------------------------------------------------+");
			System.out.println("|      Customer Service through Ticketing         |");
			System.out.println("+-------------------------------------------------+");
			System.out.println("| 1. Login as Customer                            |");
			System.out.println("| 2. Login as Employee                            |");
			System.out.println("| 3. Exit                                         |");
			System.out.println("+-------------------------------------------------+");
			System.out.println("\nChoose an option :- ");
			choice = scanner.nextInt();
			scanner.nextLine();
			System.out.println("+-------------------------------------------------+");
			switch(choice)
			{
				case 1:
				{
		            CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
					int customerId = customerServiceImpl.checkCustomerId();
					char goToSubMenu = 'y';
					if (customerId != 0) 
		            {
		                System.out.println("\nLogin successful as customer "+customerId+"\n");
						do
						{
			                System.out.println("+-------------------------------------------------+");
			    			System.out.println("|                Customer Options                 |");
			    			System.out.println("+-------------------------------------------------+");
			    			System.out.println("| 1. Display tickets in progress                  |");
			    			System.out.println("| 2. Display all tickets                          |");
			    			System.out.println("| 3. View account details                         |");
			    			System.out.println("| 4. Exit                                         |");
			    			System.out.println("+-------------------------------------------------+");
			    			System.out.println("\nChoose an option :- ");
			    			int choiceSub = scanner.nextInt();
			    			scanner.nextLine();
			    			System.out.println("+-------------------------------------------------+");
			    			switch(choiceSub)
			    			{
				    			case 1:
				    			case 2:
				    				ticketServiceImpl.getAllTicketDetails(choiceSub, customerId);
				    				break;
				    			case 3:
				    			{
				    				customerServiceImpl.displayCustomerDetails(customerId);
				    			}break;
				    			case 4:
				    			{
				    				System.exit(0);
				    			}break;
			    			}
			    			System.out.println("+-------------------------------------------------+");
			    			System.out.println("\nGo back to Customer Menu : (y/n)");
			    			goToSubMenu = scanner.next().charAt(0);
						}while(goToSubMenu == 'y');
		            }
					else 
		            {
		                System.out.println("\nCustomer id does not exist");
		            }
				}break;
				case 2:
				{
					EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
					int employeeId = employeeServiceImpl.checkEmployeeId();
					char goToSubMenu = 'y';
					if (employeeId != 0) 
		            {
		                System.out.println("\nLogin successful as employee "+employeeId+"\n");
		                do
		                {
		                	System.out.println("+-------------------------------------------------+");
			    			System.out.println("|                Employee Options                 |");
			    			System.out.println("+-------------------------------------------------+");
			    			System.out.println("| 1. Add new issue                                |");
			    			System.out.println("| 2. Create a ticket                              |");
			    			System.out.println("| 3. View employee details                        |");
			    			System.out.println("| 4. Exit                                         |");
			    			System.out.println("+-------------------------------------------------+");
			    			System.out.println("\nChoose an option :- ");
			    			int choiceSub = scanner.nextInt();
			    			scanner.nextLine();
			    			System.out.println("+-------------------------------------------------+");
			    			switch(choiceSub)
			    			{
				    			case 1:
				    			{
				    				employeeServiceImpl.createNewIssue(employeeId);
				    			}break;
				    			case 2:
				    			{
				    				employeeServiceImpl.createNewTicket(employeeId);
				    			}break;
				    			case 3:
				    			{
				    				employeeServiceImpl.displayEmployeeDetails(employeeId);
				    			}break;
				    			case 4:
				    			{
				    				System.exit(0);
				    			}break;
			    			}
			    			System.out.println("+-------------------------------------------------+");
			    			System.out.println("\nGo back to Employee Menu : (y/n)");
			    			goToSubMenu = scanner.next().charAt(0);
		                }while(goToSubMenu == 'y');
		            }
					else
					{
						System.out.println("\nEmployee id does not exist\n");
					}
				}break;
				case 3:
				{
					System.out.println("\nProgram terminated successfully\n");
					System.exit(0);
				}break;
			}
			System.out.println("+-------------------------------------------------+");
			System.out.println("\nGo back to Main Menu : (y/n)");
			goToMainMenu = scanner.next().charAt(0);
		}while(goToMainMenu == 'y');	
	}
}