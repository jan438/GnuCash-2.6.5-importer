package com.mylab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterUUIDs {

	@SuppressWarnings("resource")
	public static void register_UUIDs(Connection connection) {
		PreparedStatement preparedStatement = null;
		String uuid, fullname;
		String selectSQL = "select * from commodities where mnemonic = ?";		 
		try {
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, "USD");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				uuid = rs.getString("guid");
				fullname = rs.getString("fullname");
				System.out.println("guid : " + uuid + " USD (" + fullname + ")");
				GnuCashImporter.currencies.put("USD (" + fullname + ")", uuid);
			}
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, "EUR");
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				uuid = rs.getString("guid");
				fullname = rs.getString("fullname");
				System.out.println("guid : " + uuid + " EUR (" + fullname + ")");
				GnuCashImporter.currencies.put("EUR (" + fullname + ")", uuid);
			}
			selectSQL = "select * from accounts where name = ?";		 
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, "Creditkaart");
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				uuid = rs.getString("guid");
				System.out.println("guid : " + uuid + " Creditkaart");
				GnuCashImporter.credits.put("Creditkaart" ,uuid);
			}
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, "Kredietlijn");
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				uuid = rs.getString("guid");
				System.out.println("guid : " + uuid + " Kredietlijn");
				GnuCashImporter.credits.put("Kredietlijn" ,uuid);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}		
	}
}


