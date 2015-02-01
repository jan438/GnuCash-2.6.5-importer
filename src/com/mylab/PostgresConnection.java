package com.mylab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection {
	static Connection conn = null;
	public static Connection getConnection() {
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/gnucash", "postgres","");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn; 
	}
}
