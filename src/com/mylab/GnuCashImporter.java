package com.mylab;

import org.postgresql.Driver;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GnuCashImporter {
	
	static Statement stmt = null;
    
	private static void fill_accounts() {
    	
    };
	private static void fill_billterms() {
		
	};
	private static void fill_books() {
		
	};
	private static void fill_budget_amounts() {
		
	};
	private static void fill_budgets() {
		
	};
	private static void fill_commodities() {
		
	};
	private static void fill_customers() {
		
	};
	private static void fill_employees() {
		
	};
	private static void fill_entries() {
		
	};
	private static void fill_gnclock() {
		
	};
	private static void fill_invoices() {
		
	};
	private static void fill_jobs() {
		
	};
	private static void fill_lots() {
		
	};
	private static void fill_orders() {
		
	};
	private static void fill_prices() {
		
	};
	private static void fill_recurrences() {
		
	};
	private static void fill_schedxactions() {
		
	};
	private static void fill_slots() {
		
	};
	private static void fill_splits() {
		
	};
	private static void fill_taxtable_entries() {
		
	};
	private static void fill_taxtables() {
		
	};
	private static void fill_transactions() {
		
	};
	private static void fill_vendors() {
		
	};
	private static void fill_versions() {
		
	};

	public static void main(String[] args) {
        
    	System.out.println("Hello, World");
		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");
 
		try {
 
			Class.forName("org.postgresql.Driver");
 
		} catch (ClassNotFoundException e) {
 
			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;
 
		}
 
		System.out.println("PostgreSQL JDBC Driver Registered!");
 
		Connection connection = null;
 
		try {
 
			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/gnucash", "postgres","");
			import_accounts(connection);
 
		} catch (SQLException e) {
 
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
 
		}
 
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
	    	fill_accounts();
	    	fill_billterms();
	    	fill_books();
	    	fill_budget_amounts();
	    	fill_budgets();
	    	fill_commodities();
	    	fill_customers();
	    	fill_employees();
	    	fill_entries();
	    	fill_gnclock();
	    	fill_invoices();
	    	fill_jobs();
	    	fill_lots();
	    	fill_orders();
	    	fill_prices();
	    	fill_recurrences();
	    	fill_schedxactions();
	    	fill_slots();
	    	fill_splits();
	    	fill_taxtable_entries();
	    	fill_taxtables();
	    	fill_transactions();
	    	fill_vendors();
	    	fill_versions();
	    	connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("Bye");
	}
}
