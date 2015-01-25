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

public class Billterms {

	static Connection conn;

	static String guid;
	static String name;
	static String description;
	static int refcount;
	static int invisible;
	static String parent;
	static String type;
	static int duedays;
	static int discountdays;
	static long discount_num;
	static long discount_denom;
	static int cutoff;

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
	public static void fill_billterms(Connection iconn) {
		conn = iconn;
		System.out.println("Reading records from the spreadsheet...");
		readBillterms();
	}		
	private static void insert_into_table() {
		PreparedStatement preparedStatement = null;
		System.out.println("Inserting records into the billterms table...");
		try {     
			String sql = "INSERT INTO billterms (guid, name, description, refcount, invisible, parent, type, duedays, discountdays, discount_num, discount_denom, cutoff) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			preparedStatement = conn.prepareStatement(sql);			 
			preparedStatement.setString(1, GenerateUUID.getUUID());
			preparedStatement.setString(2, getName());
			preparedStatement.setString(3, getDescription());
			preparedStatement.setInt(4, getRefcount());
			preparedStatement.setInt(5, getInvisible());
			preparedStatement.setString(6, getParent());
			preparedStatement.setString(7, getType());
			preparedStatement.setInt(8, getDuedays());
			preparedStatement.setInt(9, getDiscountdays());
			preparedStatement.setLong(10, getDiscount_num());
			preparedStatement.setLong(11, getDiscount_denom());
			preparedStatement.setInt(12, getCutoff());
			System.out.println(sql);
			preparedStatement.executeUpdate();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {	 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("Inserted records into the billterms table...");
	}
	public static void readBillterms() {
		try {
			FileInputStream file = new FileInputStream(new File("/home/marijke/GnuCash-2.6.5-importer/GnuCash-2.6.5-importer/SnelStartTermsExport0001.xlsx"));

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
						setDescription(cell.getStringCellValue());
					}
					break;
					case 3 :if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						setRefcount((int) cell.getNumericCellValue());
					}
					break;				
					case 4 :if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						setInvisible((int) cell.getNumericCellValue());
					}
					break;				
					case 5 :if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						setParent(cell.getStringCellValue());
					}
					break;
					case 6 :if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						setType(cell.getStringCellValue());
					}
					break;				
					case 7: if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						setDuedays((int) cell.getNumericCellValue());
					}
					break;
					case 8: if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						setDiscountdays((int) cell.getNumericCellValue());
					}
					break;
					case 9: if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						setDiscount_num((long) cell.getNumericCellValue());
					}
					break;
					case 10: if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						setDiscount_denom((long) cell.getNumericCellValue());
					}
					break;
					case 11: if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						setCutoff((int) cell.getNumericCellValue());
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
	public static String getDescription() {
		return description;
	}
	public static void setDescription(String idescription) {
		description = idescription;
	}
	public static int getRefcount() {
		return refcount;
	}
	public static void setRefcount(int irefcount) {
		refcount = irefcount;
	}
	public static int getInvisible() {
		return invisible;
	}
	public static void setInvisible(int iinvisible) {
		invisible = iinvisible;
	}
	public static String getParent() {
		return parent;
	}
	public static void setParent(String iparent) {
		parent = iparent;
	}
	public static String getType() {
		return type;
	}
	public static void setType(String itype) {
		type = itype;
	}
	public static int getDuedays() {
		return duedays;
	}
	public static void setDuedays(int iduedays) {
		duedays = iduedays;
	}
	public static int getDiscountdays() {
		return discountdays;
	}
	public static void setDiscountdays(int idiscountdays) {
		discountdays = idiscountdays;
	}
	public static long getDiscount_num() {
		return discount_num;
	}
	public static void setDiscount_num(long idiscount_num) {
		discount_num = idiscount_num;
	}
	public static long getDiscount_denom() {
		return discount_denom;
	}
	public static void setDiscount_denom(long idiscount_denom) {
		discount_denom = idiscount_denom;
	}
	public static int getCutoff() {
		return cutoff;
	}
	public static void setCutoff(int icutoff) {
		cutoff = icutoff;
	}
}


