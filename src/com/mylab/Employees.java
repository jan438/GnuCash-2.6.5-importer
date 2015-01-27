package com.mylab;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Employees {
			
	static Connection conn;
			
	private static String guid;
	private static String name;
	private static String id;
	private static String language;
	private static String acl;
	private static int active;
	private static String currency;
	private static String creditcard;
	private static long workday_num;
	private static long workday_denom;
	private static long rate_num;
	private static long rate_denom;
	private static String addr_name;
	private static String addr_addr1;
	private static String addr_addr2;
	private static String addr_addr3;
	private static String addr_addr4;
	private static String addr_phone;
	private static String addr_fax;
	private static String addr_email; 

	public static String getGuid() {
		return guid;
	}
	public static void setGuid(String iguid) {
		guid = iguid;
	}
	public static String getName() {
		return name;
	}
	public static void setName(String iname) {
		name = iname;
	}
	public static String getId() {
		return id;
	}
	public static void setId(String iid) {
		id = iid;
	}
	public static String getLanguage() {
		return language;
	}
	public static void setLanguage(String ilanguage) {
		language = ilanguage;
	}
	public static int getActive() {
		return active;
	}
	public static void setActive(int iactive) {
		active = iactive;
	}
	public static String getCurrency() {
		return currency;
	}
	public static void setCurrency(String icurrency) {
		currency = GnuCashImporter.currencies.get(icurrency);
	}
	public static String getAcl() {
		return acl;
	}
	public static void setAcl(String iacl) {
		acl = iacl;
	}
	public static long getWorkday_num() {
		return workday_num;
	}
	public static void setWorkday_num(long iworkday_num) {
		workday_num = iworkday_num;
	}
	public static String getCreditcard() {
		return creditcard;
	}
	public static void setCreditcard(String icreditcard) {
		creditcard = GnuCashImporter.credits.get(icreditcard);
	}
	public static long getWorkday_denom() {
		return workday_denom;
	}
	public static void setWorkday_denom(long iworkday_denom) {
		workday_denom = iworkday_denom;
	}
	public static long getRate_num() {
		return rate_num;
	}
	public static void setRate_num(long irate_num) {
		rate_num = irate_num;
	}
	public static long getRate_denom() {
		return rate_denom;
	}
	public static void setRate_denom(long irate_denom) {
		rate_denom = irate_denom;
	}
	public static String getAddr_name() {
		return addr_name;
	}
	public static void setAddr_name(String iaddr_name) {
		addr_name = iaddr_name;
	}
	public static String getAddr_addr1() {
		return addr_addr1;
	}
	public static void setAddr_addr1(String iaddr_addr1) {
		addr_addr1 = iaddr_addr1;
	}
	public static String getAddr_addr2() {
		return addr_addr2;
	}
	public static void setAddr_addr2(String iaddr_addr2) {
		addr_addr2 = iaddr_addr2;
	}
	public static String getAddr_addr3() {
		return addr_addr3;
	}
	public static void setAddr_addr3(String iaddr_addr3) {
		addr_addr3 = iaddr_addr3;
	}
	public static String getAddr_addr4() {
		return addr_addr4;
	}
	public static void setAddr_addr4(String iaddr_addr4) {
		addr_addr4 = iaddr_addr4;
	}
	public static String getAddr_phone() {
		return addr_phone;
	}
	public static void setAddr_phone(String iaddr_phone) {
		addr_phone = iaddr_phone;
	}
	public static String getAddr_fax() {
		return addr_fax;
	}
	public static void setAddr_fax(String iaddr_fax) {
		addr_fax = iaddr_fax;
	}
	public static String getAddr_email() {
		return addr_email;
	}
	public static void setAddr_email(String iaddr_email) {
		addr_email = iaddr_email;
	}
	public static void fill_employees(Connection iconn) {
		conn = iconn;
		System.out.println("Reading records from the spreadsheet...");
		readEmployees();
	}		
	private static void insert_into_table() {
		PreparedStatement preparedStatement = null;
		System.out.println("Inserting records into the employees table...");
		try {     
			String sql = "INSERT INTO employees (guid, username, id, language, acl, active, currency, ccard_guid, workday_num, workday_denom, rate_num, rate_denom, addr_name, addr_addr1, addr_addr2, addr_addr3, addr_addr4, addr_phone, addr_fax, addr_email) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			preparedStatement = conn.prepareStatement(sql);			 
			preparedStatement.setString(1, GenerateUUID.getUUID());
			preparedStatement.setString(2, getName());
			preparedStatement.setString(3, getId());
			preparedStatement.setString(4, getLanguage());
			preparedStatement.setString(5, getAcl());
			preparedStatement.setInt(6, getActive());
			preparedStatement.setString(7, getCurrency());
			preparedStatement.setString(8, getCreditcard());
			preparedStatement.setLong(9, getWorkday_num());
			preparedStatement.setLong(10, getWorkday_denom());
			preparedStatement.setLong(11, getRate_num());
			preparedStatement.setLong(12, getRate_denom());
			preparedStatement.setString(13, getAddr_name());
			preparedStatement.setString(14, getAddr_addr1());
			preparedStatement.setString(15, getAddr_addr2());
			preparedStatement.setString(16, getAddr_addr3());
			preparedStatement.setString(17, getAddr_addr4());
			preparedStatement.setString(18, getAddr_phone());
			preparedStatement.setString(19, getAddr_fax());
			preparedStatement.setString(20, getAddr_email());
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
		System.out.println("Inserted records into the vendors table...");
	}
	public static void readEmployees() {
		try {
			FileInputStream file = new FileInputStream(new File("/home/jan/git/GnuCash-2.6.5-importer/SnelStartEmployeeExport0001.xlsx"));

			//Create Workbook instance holding reference to .xlsx file
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			//Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			//Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				int column = 0;
				//For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (column) {
					case 0 :if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						setGuid(cell.getStringCellValue());
					}
					break;
					case 1 :if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						setName(cell.getStringCellValue());
					}
					break;
					case 2 :if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						setId(cell.getStringCellValue());
					}
					break;
					case 3 :if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						setLanguage(cell.getStringCellValue());
					}
					break;				
					case 4 :if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						setAcl(cell.getStringCellValue());
					}
					break;				
					case 5 :if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						setActive((int) cell.getNumericCellValue());
					}
					break;
					case 6 :if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						setCurrency(cell.getStringCellValue());
					}
					break;				
					case 7: if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						setCreditcard(cell.getStringCellValue());
					}
					break;
					case 8: if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						setWorkday_num((long) cell.getNumericCellValue());
					}
					break;
					case 9: if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						setWorkday_denom((long) cell.getNumericCellValue());
					}
					break;
					case 10: if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						setRate_num((long) cell.getNumericCellValue());
					}
					break;
					case 11: if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						setRate_denom((long) cell.getNumericCellValue());
					}
					break;
					case 12: if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						setAddr_name(cell.getStringCellValue());
					}
					break;
					case 13: if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						setAddr_addr1(cell.getStringCellValue());
					}
					break;
					case 14 :if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						setAddr_addr2(cell.getStringCellValue());
					}
					break;
					case 15:if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						setAddr_addr3(cell.getStringCellValue());
					}
					break;
					case 16:if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						setAddr_addr4(cell.getStringCellValue());
					}
					break;
					case 17:if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						setAddr_phone(cell.getStringCellValue());
					}
					break;
					case 18:if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						setAddr_fax(cell.getStringCellValue());
					}
					break;
					case 19:if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						setAddr_email(cell.getStringCellValue());
					}
					break;
					}
					column++;
				}
				System.out.println("");
				insert_into_table();
			}
			file.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

