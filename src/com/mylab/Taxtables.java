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
		// Laag	6
		// Nul	0
		PreparedStatement preparedStatement = null;
		String uuid_deb_hoog = GenerateUUID.getUUID();
		String uuid_deb_laag = GenerateUUID.getUUID();
		String uuid_deb_nul = GenerateUUID.getUUID();
		String uuid_deb_marge = GenerateUUID.getUUID();
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
			System.out.println("Inserting records into the taxtables and taxtable_entries tables...");
			sql = "INSERT INTO taxtables (guid, name, refcount, invisible, parent) VALUES (?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);			 
			preparedStatement.setString(1, uuid_deb_hoog);
			preparedStatement.setString(2, "Hoog");
			preparedStatement.setLong(3, 0);
			preparedStatement.setInt(4, 0);
			preparedStatement.setString(5, "");
			System.out.println(sql);
			preparedStatement.executeUpdate();
			GnuCashImporter.taxes.put("Hoog",uuid_deb_hoog);
			preparedStatement = connection.prepareStatement(sql);			 
			preparedStatement.setString(1, uuid_deb_laag);
			preparedStatement.setString(2, "Laag");
			preparedStatement.setLong(3, 0);
			preparedStatement.setInt(4, 0);
			preparedStatement.setString(5, "");
			System.out.println(sql);
			preparedStatement.executeUpdate();
			GnuCashImporter.taxes.put("Laag",uuid_deb_laag);
			preparedStatement = connection.prepareStatement(sql);			 
			preparedStatement.setString(1, uuid_deb_nul);
			preparedStatement.setString(2, "Nul");
			preparedStatement.setLong(3, 0);
			preparedStatement.setInt(4, 0);
			preparedStatement.setString(5, "");
			System.out.println(sql);
			preparedStatement.executeUpdate();
			GnuCashImporter.taxes.put("Nul",uuid_deb_nul);
			preparedStatement = connection.prepareStatement(sql);			 
			preparedStatement.setString(1, uuid_deb_marge);
			preparedStatement.setString(2, "Marge");
			preparedStatement.setLong(3, 0);
			preparedStatement.setInt(4, 0);
			preparedStatement.setString(5, "");
			System.out.println(sql);
			preparedStatement.executeUpdate();
			GnuCashImporter.taxes.put("Marge",uuid_deb_marge);
			sql = "INSERT INTO taxtable_entries (id, taxtable, account, amount_num, amount_denom, type) VALUES (nextval('taxtable_entries_id_seq1'),?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);			 
			preparedStatement.setString(1, uuid_deb_hoog);
			preparedStatement.setString(2, GnuCashImporter.getBTW());
			preparedStatement.setLong(3, 2100000);
			preparedStatement.setLong(4, 100000);
			preparedStatement.setInt(5, 2);
			System.out.println(sql);
			preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement(sql);			 
			preparedStatement.setString(1, uuid_deb_laag);
			preparedStatement.setString(2, GnuCashImporter.getBTW());
			preparedStatement.setLong(3, 600000);
			preparedStatement.setLong(4, 100000);
			preparedStatement.setInt(5, 2);
			System.out.println(sql);
			preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement(sql);			 
			preparedStatement.setString(1, uuid_deb_nul);
			preparedStatement.setString(2, GnuCashImporter.getBTW());
			preparedStatement.setLong(3, 0);
			preparedStatement.setLong(4, 100000);
			preparedStatement.setInt(5, 2);
			System.out.println(sql);
			preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement(sql);			 
			preparedStatement.setString(1, uuid_deb_marge);
			preparedStatement.setString(2, GnuCashImporter.getBTW());
			preparedStatement.setLong(3, 0);
			preparedStatement.setLong(4, 100000);
			preparedStatement.setInt(5, 1);
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
