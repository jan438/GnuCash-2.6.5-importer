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
	static Map<String,String> terms = new HashMap<String,String>();
	
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
		
		try {
			
			connection = PostgresConnection.getConnection();

			Commodities.insert_USD(connection);

			Accounts.insert_business_accounts(connection);

			Billterms.fill_billterms(connection);

			RegisterUUIDs.register_UUIDs(connection);

			Taxtables.fill_taxtables(connection);

			Customers.fill_customers(connection);
			Employees.fill_employees(connection);
			Vendors.fill_vendors(connection);           
			
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Bye");
	}
}
