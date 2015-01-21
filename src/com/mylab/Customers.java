package com.mylab;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class Customers {
	
	private UUID guid;
	private static String name;
	private static String id;
	private static String notes;
	private static int active;
	private static long discount_num;
	private static long discount_denom;
	private static long credit_num;
	private static long credit_denom;
	private static String currency;
	private static int tax_override;
	private static String addr_name;
	private static String addr_addr1;
	private static String addr_addr2;
	private static String addr_addr3;
	private static String addr_addr4;
	private static String addr_phone;
	private static String addr_fax;
	private static String addr_email; 
	private static String shipaddr_name;
	private static String shipaddr_addr1;
	private static String shipaddr_addr2;
	private static String shipaddr_addr3;
	private static String shipaddr_addr4;
	private static String shipaddr_phone;
	private static String shipaddr_fax;
	private static String shipaddr_email;
	private static String terms;
	private static int tax_included;
	private static String taxtable;

	public UUID getGuid() {
		return guid;
	}
	public void setGuid(UUID guid) {
		this.guid = guid;
	}
	public static String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public static String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public static int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public static long getDiscount_num() {
		return discount_num;
	}
	public void setDiscount_num(long discount_num) {
		this.discount_num = discount_num;
	}
	public static long getDiscount_denom() {
		return discount_denom;
	}
	public void setDiscount_denom(long discount_denom) {
		this.discount_denom = discount_denom;
	}
	public static long getCredit_num() {
		return credit_num;
	}
	public void setCredit_num(long credit_num) {
		this.credit_num = credit_num;
	}
	public static long getCredit_denom() {
		return credit_denom;
	}
	public void setCredit_denom(long credit_denom) {
		this.credit_denom = credit_denom;
	}
	public static String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public static int getTax_override() {
		return tax_override;
	}
	public void setTax_override(int tax_override) {
		this.tax_override = tax_override;
	}
	public static String getAddr_name() {
		return addr_name;
	}
	public void setAddr_name(String addr_name) {
		this.addr_name = addr_name;
	}
	public static String getAddr_addr1() {
		return addr_addr1;
	}
	public void setAddr_addr1(String addr_addr1) {
		this.addr_addr1 = addr_addr1;
	}
	public static String getAddr_addr2() {
		return addr_addr2;
	}
	public void setAddr_addr2(String addr_addr2) {
		this.addr_addr2 = addr_addr2;
	}
	public static String getAddr_addr3() {
		return addr_addr3;
	}
	public void setAddr_addr3(String addr_addr3) {
		this.addr_addr3 = addr_addr3;
	}
	public static String getAddr_addr4() {
		return addr_addr4;
	}
	public void setAddr_addr4(String addr_addr4) {
		this.addr_addr4 = addr_addr4;
	}
	public static String getAddr_phone() {
		return addr_phone;
	}
	public void setAddr_phone(String addr_phone) {
		this.addr_phone = addr_phone;
	}
	public static String getAddr_fax() {
		return addr_fax;
	}
	public void setAddr_fax(String addr_fax) {
		this.addr_fax = addr_fax;
	}
	public static String getAddr_email() {
		return addr_email;
	}
	public void setAddr_email(String addr_email) {
		this.addr_email = addr_email;
	}
	public static String getShipaddr_name() {
		return shipaddr_name;
	}
	public void setShipaddr_name(String shipaddr_name) {
		this.shipaddr_name = shipaddr_name;
	}
	public static String getShipaddr_addr1() {
		return shipaddr_addr1;
	}
	public void setShipaddr_addr1(String shipaddr_addr1) {
		this.shipaddr_addr1 = shipaddr_addr1;
	}
	public static String getShipaddr_addr2() {
		return shipaddr_addr2;
	}
	public void setShipaddr_addr2(String shipaddr_addr2) {
		this.shipaddr_addr2 = shipaddr_addr2;
	}
	public static String getShipaddr_addr3() {
		return shipaddr_addr3;
	}
	public void setShipaddr_addr3(String shipaddr_addr3) {
		this.shipaddr_addr3 = shipaddr_addr3;
	}
	public static String getShipaddr_addr4() {
		return shipaddr_addr4;
	}
	public void setShipaddr_addr4(String shipaddr_addr4) {
		this.shipaddr_addr4 = shipaddr_addr4;
	}
	public static String getShipaddr_phone() {
		return shipaddr_phone;
	}
	public void setShipaddr_phone(String shipaddr_phone) {
		this.shipaddr_phone = shipaddr_phone;
	}
	public static String getShipaddr_fax() {
		return shipaddr_fax;
	}
	public void setShipaddr_fax(String shipaddr_fax) {
		this.shipaddr_fax = shipaddr_fax;
	}
	public static String getShipaddr_email() {
		return shipaddr_email;
	}
	public void setShipaddr_email(String shipaddr_email) {
		this.shipaddr_email = shipaddr_email;
	}
	public static String getTerms() {
		return terms;
	}
	public void setTerms(String terms) {
		this.terms = terms;
	}
	public static int getTax_included() {
		return tax_included;
	}
	public void setTax_included(int tax_included) {
		this.tax_included = tax_included;
	}
	public static String getTaxtable() {
		return taxtable;
	}
	public void setTaxtable(String taxtable) {
		this.taxtable = taxtable;
	}
	public static void fill_customers(Connection conn) {
		  Statement stmt;
	      System.out.println("Inserting records into the customers table...");
	      try {
			stmt = conn.createStatement();
			String sql = "INSERT INTO Registration " + "VALUES (" + 
			UUID.randomUUID() + "," +
			getName() + "," +
			getId() + "," +
			getNotes() + "," + 
			getActive() + "," + 
			getDiscount_num() + "," + 
			getDiscount_denom() + "," + 
			getCredit_num() + "," +
			getCredit_denom() + "," +
			getCurrency() + "," +
			getTax_override() + "," +
			getAddr_name() + "," +
			getAddr_addr1() + "," +
			getAddr_addr2() + "," +
			getAddr_addr3() + "," +
			getAddr_addr4() + "," +
			getAddr_phone() + "," +
			getAddr_fax() + "," +
			getAddr_email() + "," +
			getShipaddr_name() + "," +
			getShipaddr_addr1() + "," +
			getShipaddr_addr2() + "," +
			getShipaddr_addr3() + "," +
			getShipaddr_addr4() + "," +
			getShipaddr_phone() + "," +
			getShipaddr_fax() + "," +
			getShipaddr_email() + "," +
			getTerms() + "," +
			getTax_included() + "," +
			getTaxtable() + ")";
	      stmt.executeUpdate(sql);
	      stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("Inserted records into the customers table...");
	}
	public static void read_customers(Connection conn) {
		
	}


}
