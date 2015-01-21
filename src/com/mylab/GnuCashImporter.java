package com.mylab;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GnuCashImporter {
	
	static Statement stmt = null;
    
	public static void main(String[] args) {
        
    	System.out.println("Hello, World");
 
		try {
			Class.forName("org.postgresql.Driver"); 
		} catch (ClassNotFoundException e) { 
			System.out.println("Where is your PostgreSQL JDBC Driver? "	+ "Include in your library path!");
			e.printStackTrace();
			return; 
		}
 
		System.out.println("PostgreSQL JDBC Driver Registered!");
 
		Connection connection = null;
 
		connection = PostgresConnection.getConnection();

		import_accounts(connection);
 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}

	private static void import_accounts(Connection connection) {
	    try {
	    	stmt = connection.createStatement();
	    	String sql = "SELECT * FROM accounts;";
	    	stmt = connection.createStatement();
	    	ResultSet rs = stmt.executeQuery(sql);
	    	while (rs.next()) {	
	    		System.out.println(rs.getString("guid") + " " +
	    				rs.getString("name") + " " +
	    				rs.getString("account_type") + " " +
	    				rs.getString("commodity_guid") + " " +
	    				rs.getInt("commodity_scu") +" " +
	    				rs.getInt("non_std_scu") + " " +
	    				rs.getString("parent_guid") + " " +
	    				rs.getString("code") +" " +
	    				rs.getString("description") + " " +
	    				rs.getInt("hidden") + " " +
	    				rs.getInt("placeholder"));
            }
	    	stmt.close();
	    	sql = "SELECT * FROM books;";
	    	stmt = connection.createStatement();
	    	rs = stmt.executeQuery(sql);
	    	while (rs.next()) {	
	    		System.out.println(rs.getString("guid") + " " +
	    				rs.getString("root_account_guid") + " " +
	    				rs.getString("root_template_guid"));
	    	}
	    	stmt.close();
	    	sql = "SELECT * FROM books;";
	    	stmt = connection.createStatement();
	    	rs = stmt.executeQuery(sql);
	    	while (rs.next()) {	
	    		System.out.println(rs.getString("guid") + " " +
	    				rs.getString("root_account_guid") + " " +
	    				rs.getString("root_template_guid"));
	    	}
	    	stmt.close();
	    	Accounts.fill_accounts();
	    	Billterms.fill_billterms();
	    	Books.fill_books();
	    	Budget_amounts.fill_budget_amounts();
	    	Budgets.fill_budgets();
	    	Commodities.fill_commodities();
	    	Customers.fill_customers(connection);
	    	Employees.fill_employees();
	    	Entries.fill_entries();
	    	//fill_gnclock();
	    	Invoices.fill_invoices();
	    	Jobs.fill_jobs();
	    	Lots.fill_lots();
	    	Orders.fill_orders();
	    	Prices.fill_prices();
	    	Recurrences.fill_recurrences();
	    	Schedxactions.fill_schedxactions();
	    	Slots.fill_slots();
	    	Splits.fill_splits();
	    	Taxtable_entries.taxtable_entries();
	    	Taxtables.fill_taxtables();
	    	Transactions.fill_transactions();
	    	Vendors.fill_vendors();
	    	//fill_versions();
	    	connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("Bye");
	}
}
