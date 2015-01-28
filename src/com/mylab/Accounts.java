package com.mylab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Accounts {
	@SuppressWarnings("resource")
	public static void insert_business_accounts(Connection connection) {
		PreparedStatement preparedStatement = null;
		System.out.println("Inserting records into the accounts table...");
		try {   
			String root_uuid = null;
			String commodity_uuid = null;
			String activa_uuid = null;
			String passiva_uuid = null;
			String BTW_uuid = GenerateUUID.getUUID();
			GnuCashImporter.setBTW(BTW_uuid);
			String selectSQL = "select * from accounts where name = ?";		 
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, "Root Account");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				root_uuid = rs.getString("guid");
				commodity_uuid = rs.getString("commodity_guid");
				System.out.println("guid Root: " + root_uuid + " commodity_guid " + commodity_uuid);
			}
			preparedStatement.setString(1, "Huidige Activa");
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
			// Insert into accounts guid "Accounts Receivable" ASSET commodity_guid 100 0 activa_uuid 0 0 
			// Insert into accounts guid "Accounts Payable" LIABILITY commodity_guid 100 0 passiva_uuid 0 0 
			String sql = "INSERT INTO accounts (guid, name, account_type, commodity_guid, commodity_scu, non_std_scu, parent_guid, code, description, hidden, placeholder) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);			 
			preparedStatement.setString(1, GenerateUUID.getUUID());
			preparedStatement.setString(2, "Accounts Receivable");
			preparedStatement.setString(3, "ASSET");
			preparedStatement.setString(4, commodity_uuid);
			preparedStatement.setInt(5, 100);
			preparedStatement.setInt(6, 0);
			preparedStatement.setString(7, activa_uuid);
			preparedStatement.setString(8, "");
			preparedStatement.setString(9, "Accounts Receivable");
			preparedStatement.setInt(10, 0);
			preparedStatement.setInt(11, 0);
			System.out.println(sql);
			preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement(sql);			 
			preparedStatement.setString(1, GenerateUUID.getUUID());
			preparedStatement.setString(2, "Accounts Payable");
			preparedStatement.setString(3, "LIABILITY");
			preparedStatement.setString(4, commodity_uuid);
			preparedStatement.setInt(5, 100);
			preparedStatement.setInt(6, 0);
			preparedStatement.setString(7, passiva_uuid);
			preparedStatement.setString(8, "");
			preparedStatement.setString(9, "Accounts Payable");
			preparedStatement.setInt(10, 0);
			preparedStatement.setInt(11, 0);
			System.out.println(sql);
			preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement(sql);			 
			preparedStatement.setString(1, GenerateUUID.getUUID());
			preparedStatement.setString(2, "Debiteuren");
			preparedStatement.setString(3, "RECEIVABLE");
			preparedStatement.setString(4, commodity_uuid);
			preparedStatement.setInt(5, 100);
			preparedStatement.setInt(6, 0);
			preparedStatement.setString(7, activa_uuid);
			preparedStatement.setString(8, "Debiteuren");
			preparedStatement.setString(9, "Klanten");
			preparedStatement.setInt(10, 0);
			preparedStatement.setInt(11, 0);
			System.out.println(sql);
			preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement(sql);			 
			preparedStatement.setString(1, GenerateUUID.getUUID());
			preparedStatement.setString(2, "Crediteuren");
			preparedStatement.setString(3, "PAYABLE");
			preparedStatement.setString(4, commodity_uuid);
			preparedStatement.setInt(5, 100);
			preparedStatement.setInt(6, 0);
			preparedStatement.setString(7, passiva_uuid);
			preparedStatement.setString(8, "Crediteuren");
			preparedStatement.setString(9, "Leveranciers");
			preparedStatement.setInt(10, 0);
			preparedStatement.setInt(11, 0);
			System.out.println(sql);
			preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement(sql);			 
			preparedStatement.setString(1, BTW_uuid);
			preparedStatement.setString(2, "BTW");
			preparedStatement.setString(3, "PAYABLE");
			preparedStatement.setString(4, commodity_uuid);
			preparedStatement.setInt(5, 100);
			preparedStatement.setInt(6, 0);
			preparedStatement.setString(7, passiva_uuid);
			preparedStatement.setString(8, "BTW");
			preparedStatement.setString(9, "BTW verzameld");
			preparedStatement.setInt(10, 0);
			preparedStatement.setInt(11, 0);
			System.out.println(sql);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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
		System.out.println("Inserted records into the accounts table...");
	}	
}