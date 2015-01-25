package com.mylab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Taxtables {
	public static void fill_taxtables(Connection connection) {

		PreparedStatement preparedStatement = null;
		String root_uuid;
		String commodity_uuid;
		String activa_uuid;
		String passiva_uuid;
		String selectSQL = "select * from accounts where name = ?";		 
		try {
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, "Root Account");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				root_uuid = rs.getString("guid");
				commodity_uuid = rs.getString("commodity_guid");
				System.out.println("guid Root: " + root_uuid + " commodity_guid " + commodity_uuid);
			}
			preparedStatement.setString(1, "Activa");
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				activa_uuid = rs.getString("guid");
				commodity_uuid = rs.getString("commodity_guid");
				System.out.println("guid Activa: " + activa_uuid + " commodity_guid " + commodity_uuid);
			}
			preparedStatement.setString(1, "Passiva");
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				passiva_uuid = rs.getString("guid");
				commodity_uuid = rs.getString("commodity_guid");
				System.out.println("guid Passiva: " + passiva_uuid + " commodity_guid " + commodity_uuid);
			}
			// Insert into accounts "Accounts Receivable" ASSET  
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}		
	}
}
