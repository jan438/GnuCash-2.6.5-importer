package com.mylab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Taxtables {
	/**
	 * @param connection
	 */
	@SuppressWarnings({ "resource" })
	public static void fill_taxtables(Connection connection) {
		// Hoog	21
		// Laag    6
		// Nul	0
		PreparedStatement preparedStatement = null;
		String uuid_deb_hoog = GenerateUUID.getUUID();
		String uuid_deb_laag = GenerateUUID.getUUID();
		String uuid_deb_nul = GenerateUUID.getUUID();
//		String uuid_cre_hoog = GenerateUUID.getUUID();
//		String uuid_cre_laag = GenerateUUID.getUUID();
//		String uuid_cre_nul = GenerateUUID.getUUID();
//		String uuid_ar = null;
		String uuid_debiteuren = null;
		String uuid_crediteuren = null;

		try {
			String sql = "select * from accounts where name = ?";		 
			preparedStatement = connection.prepareStatement(sql);			 
			preparedStatement.setString(1, "Debiteuren");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				uuid_debiteuren = rs.getString("guid");
				System.out.println("guid Debiteuren: " + uuid_debiteuren);
			}
			preparedStatement = connection.prepareStatement(sql);			 
			preparedStatement.setString(1, "Crediteuren");
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				uuid_crediteuren = rs.getString("guid");
				System.out.println("guid Crediteuren: " + uuid_crediteuren);
			}
			System.out.println("Inserting records into the commodities table...");
			sql = "INSERT INTO taxtables (guid, name, refcount, invisible, parent) VALUES (?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);			 
			preparedStatement.setString(1, uuid_deb_hoog);
			preparedStatement.setString(2, "Hoog");
			preparedStatement.setLong(3, 0);
			preparedStatement.setInt(4, 0);
			preparedStatement.setString(5, "");
			System.out.println(sql);
			preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement(sql);			 
			preparedStatement.setString(1, uuid_deb_laag);
			preparedStatement.setString(2, "Laag");
			preparedStatement.setLong(3, 0);
			preparedStatement.setInt(4, 0);
			preparedStatement.setString(5, "");
			System.out.println(sql);
			preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement(sql);			 
			preparedStatement.setString(1, uuid_deb_nul);
			preparedStatement.setString(2, "Nul");
			preparedStatement.setLong(3, 0);
			preparedStatement.setInt(4, 0);
			preparedStatement.setString(5, "");
			System.out.println(sql);
			preparedStatement.executeUpdate();
			sql = "INSERT INTO taxtable_entries (id, taxtable, account, amount_num, amount_denom, type) VALUES (?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);			 
			preparedStatement.setInt(1, 1);
			preparedStatement.setString(2, uuid_deb_hoog);
			preparedStatement.setString(3, GnuCashImporter.getBTW());
			preparedStatement.setLong(4, 2100000);
			preparedStatement.setLong(5, 100000);
			preparedStatement.setInt(6, 2);
			System.out.println(sql);
			preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement(sql);			 
			preparedStatement.setInt(1, 2);
			preparedStatement.setString(2, uuid_deb_laag);
			preparedStatement.setString(3, GnuCashImporter.getBTW());
			preparedStatement.setLong(4, 600000);
			preparedStatement.setLong(5, 100000);
			preparedStatement.setInt(6, 2);
			System.out.println(sql);
			preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement(sql);			 
			preparedStatement.setInt(1, 3);
			preparedStatement.setString(2, uuid_deb_nul);
			preparedStatement.setString(3, GnuCashImporter.getBTW());
			preparedStatement.setLong(4, 0);
			preparedStatement.setLong(5, 100000);
			preparedStatement.setInt(6, 2);
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
		System.out.println("Inserted records into the taxtable and taxtable_entries table...");	
	}
}
