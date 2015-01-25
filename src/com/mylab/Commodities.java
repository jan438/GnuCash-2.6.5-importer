package com.mylab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Commodities {
	public static void insert_USD(Connection connection) {
		PreparedStatement preparedStatement = null;
		System.out.println("Inserting records into the commodities table...");
		try {     
			String sql = "INSERT INTO commodities (guid, namespace, mnemonic, fullname, cusip, fraction, quote_flag, quote_source, quote_tz) VALUES (?,?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);			 
			preparedStatement.setString(1, GenerateUUID.getUUID());
			preparedStatement.setString(2, "CURRENCY");
			preparedStatement.setString(3, "USD");
			preparedStatement.setString(4, "US-dollar");
			preparedStatement.setString(5, "840");
			preparedStatement.setInt(6, 100);
			preparedStatement.setInt(7, 0);
			preparedStatement.setString(8, "currency");
			preparedStatement.setString(9, "");
			System.out.println(sql);
			preparedStatement.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {	 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Inserted records into the commodities table...");

	}
}
