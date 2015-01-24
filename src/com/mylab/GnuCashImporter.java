package com.mylab;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class GnuCashImporter {
	
	static Statement stmt = null;
	static Map<String,String> currencies = new HashMap<String,String>();
	static Map<String,String> credits = new HashMap<String,String>();
	static Map<String,String> taxes = new HashMap<String,String>();
	static Map<Integer,String> terms = new HashMap<Integer,String>();
	
	public static void main(String[] args) {
        
    	System.out.println("Hello, World");
 
    	currencies.put("EUR (euro)","ec61a1e3e3b87210d616b00fae7cb0b1");
    	currencies.put("USD (US-dollar)","de8c75f5541315dc52bf69af5cd44bb9");
    	credits.put("Creditkaart","3ca333c52826fd2085aa6a2e8f602f42");
    	credits.put("Kredietlijn","716f55cdf6b95b291be9a78f8aefb36d");
    	taxes.put("Hoog","d0fca9efae5d7508e5220820c4daf512");
    	taxes.put("Laag","507ad93ecb73228fa77c91bfce8f2573");
    	taxes.put("Nul","6deb36a0983f1c3bfe4afc849db38a41");
		terms.put(1,"425286eb4f83b2e5f59d8972b31efaff");
		terms.put(2,"0e4fd62bcac46061d218e2ff3fb04cf4");
		
		
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

		import_employees(connection);
 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}

	private static void import_employees(Connection connection) {
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
/*	    	Accounts.fill_accounts();
	    	Billterms.fill_billterms();
	    	Books.fill_books();
	    	Budget_amounts.fill_budget_amounts();
	    	Budgets.fill_budgets();
	    	Commodities.fill_commodities();*/
	    	Customers.fill_customers(connection);
	    	Employees.fill_employees(connection);
/*	    	Entries.fill_entries();
	    	fill_gnclock();
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
	    	Transactions.fill_transactions();    */
	    	Vendors.fill_vendors(connection);
	    	//fill_versions();
	    	connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("Bye");
	}
}
