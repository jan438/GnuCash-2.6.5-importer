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

public class Customers {
	
	static Connection conn;
	
	private static String guid;
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
	public static String getNotes() {
		return notes;
	}
	public static void setNotes(String inotes) {
		notes = inotes;
	}
	public static int getActive() {
		return active;
	}
	public static void setActive(int iactive) {
		active = iactive;
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
	public static long getCredit_num() {
		return credit_num;
	}
	public static void setCredit_num(long icredit_num) {
		credit_num = icredit_num;
	}
	public static long getCredit_denom() {
		return credit_denom;
	}
	public static void setCredit_denom(long icredit_denom) {
		credit_denom = icredit_denom;
	}
	public static String getCurrency() {
		return currency;
	}
	public static void setCurrency(String icurrency) {
		currency = GnuCashImporter.currencies.get(icurrency);
	}
	public static int getTax_override() {
		return tax_override;
	}
	public static void setTax_override(int itax_override) {
		tax_override = itax_override;
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
	public static String getShipaddr_name() {
		return shipaddr_name;
	}
	public static void setShipaddr_name(String ishipaddr_name) {
		shipaddr_name = ishipaddr_name;
	}
	public static String getShipaddr_addr1() {
		return shipaddr_addr1;
	}
	public static void setShipaddr_addr1(String ishipaddr_addr1) {
		shipaddr_addr1 = ishipaddr_addr1;
	}
	public static String getShipaddr_addr2() {
		return shipaddr_addr2;
	}
	public static void setShipaddr_addr2(String ishipaddr_addr2) {
		shipaddr_addr2 = ishipaddr_addr2;
	}
	public static String getShipaddr_addr3() {
		return shipaddr_addr3;
	}
	public static void setShipaddr_addr3(String ishipaddr_addr3) {
		shipaddr_addr3 = ishipaddr_addr3;
	}
	public static String getShipaddr_addr4() {
		return shipaddr_addr4;
	}
	public static void setShipaddr_addr4(String ishipaddr_addr4) {
		shipaddr_addr4 = ishipaddr_addr4;
	}
	public static String getShipaddr_phone() {
		return shipaddr_phone;
	}
	public static void setShipaddr_phone(String ishipaddr_phone) {
		shipaddr_phone = ishipaddr_phone;
	}
	public static String getShipaddr_fax() {
		return shipaddr_fax;
	}
	public static void setShipaddr_fax(String ishipaddr_fax) {
		shipaddr_fax = ishipaddr_fax;
	}
	public static String getShipaddr_email() {
		return shipaddr_email;
	}
	public static void setShipaddr_email(String ishipaddr_email) {
		shipaddr_email = ishipaddr_email;
	}
	public static String getTerms() {
		return terms;
	}
	public static void setTerms(int iterms) {
		terms = GnuCashImporter.terms.get(iterms);
	}
	public static int getTax_included() {
		return tax_included;
	}
	public static void setTax_included(int itax_included) {
		tax_included = itax_included;
	}
	public static String getTaxtable() {
		return taxtable;
	}
	public static void setTaxtable(String itaxtable) {
		taxtable = GnuCashImporter.taxes.get(itaxtable);
	}
	public static void fill_customers(Connection iconn) {
		  conn = iconn;
	      System.out.println("Reading records from the spreadsheet...");
	      readAccounts();
	}
	
	private static void insert_into_table() {
		PreparedStatement preparedStatement = null;
		System.out.println("Inserting records into the customers table...");
	    try {
			String sql = "INSERT INTO customers (guid, name, id, notes, active, discount_num, discount_denom, credit_num, credit_denom, currency, tax_override, addr_name, addr_addr1, addr_addr2, addr_addr3, addr_addr4, addr_phone, addr_fax, addr_email, shipaddr_name, shipaddr_addr1, shipaddr_addr2, shipaddr_addr3, shipaddr_addr4, shipaddr_phone, shipaddr_fax, shipaddr_email, terms, tax_included, taxtable) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			preparedStatement = conn.prepareStatement(sql);			 
			preparedStatement.setString(1, GenerateUUID.getUUID());
			preparedStatement.setString(2, getName());
			preparedStatement.setString(3, getId());
			preparedStatement.setString(4, getNotes()); 
			preparedStatement.setInt(5, getActive()); 
			preparedStatement.setLong(6, getDiscount_num()); 
			preparedStatement.setLong(7, getDiscount_denom()); 
			preparedStatement.setLong(8, getCredit_num());
			preparedStatement.setLong(9, getCredit_denom());
			preparedStatement.setString(10, getCurrency());
			preparedStatement.setInt(11, getTax_override());
			preparedStatement.setString(12, getAddr_name());
			preparedStatement.setString(13, getAddr_addr1());
			preparedStatement.setString(14, getAddr_addr2());
			preparedStatement.setString(15, getAddr_addr3());
			preparedStatement.setString(16, getAddr_addr4());
			preparedStatement.setString(17, getAddr_phone());
			preparedStatement.setString(18, getAddr_fax());
			preparedStatement.setString(19, getAddr_email());
			preparedStatement.setString(20, getShipaddr_name());
			preparedStatement.setString(21, getShipaddr_addr1());
			preparedStatement.setString(22, getShipaddr_addr2());
			preparedStatement.setString(23, getShipaddr_addr3());
			preparedStatement.setString(24, getShipaddr_addr4());
			preparedStatement.setString(25, getShipaddr_phone());
			preparedStatement.setString(26, getShipaddr_fax());
			preparedStatement.setString(27, getShipaddr_email());
			preparedStatement.setString(28, getTerms());
			preparedStatement.setInt(29, getTax_included());
			preparedStatement.setString(30, getTaxtable());
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
	    System.out.println("Inserted records into the customers table...");
	}
	public static void readAccounts() {
		try {
			FileInputStream file = new FileInputStream(new File("/home/jan/git/GnuCash-2.6.5-importer/SnelStartCustomerExport0001.xlsx"));

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
								setNotes(cell.getStringCellValue());
			 		 		}
			 		 		break;
		        	case 4 :if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
        						setActive((int) cell.getNumericCellValue());
        			 		}
        					break;        					
		        	case 5 :if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
								setDiscount_num((long) cell.getNumericCellValue());
			 				}
			 				break;
		        	case 6 :if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
		        				setDiscount_denom((long) cell.getNumericCellValue());
	 		 				}
	 		 				break;
		        	case 7 :if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
								setCredit_num((long) cell.getNumericCellValue());
			 				}
		        			break;
        			case 8 :if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
        						setCredit_denom((long) cell.getNumericCellValue());
        					}
        					break;
        			case 9 :if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
        						setCurrency(cell.getStringCellValue());
        					}
        					break;
        			case 10:if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
								setTax_override((int) cell.getNumericCellValue());
							}
							break;
		        	case 11:if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
        						setAddr_name(cell.getStringCellValue());
        					}
        					break;
		        	case 12:if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
								setAddr_addr1(cell.getStringCellValue());
			 				}
			 				break;
		        	case 13:if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
								setAddr_addr2(cell.getStringCellValue());
	 		 				}
	 		 				break;
		        	case 14:if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
								setAddr_addr3(cell.getStringCellValue());
			 				}
							break;
		        	case 15:if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
								setAddr_addr4(cell.getStringCellValue());
	 						}
	 						break;
		        	case 16:if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
								setAddr_phone(cell.getStringCellValue());
		 					}
		 					break;
		        	case 17:if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
								setAddr_fax(cell.getStringCellValue());
	 						}
        					break;
		        	case 18:if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
								setAddr_email(cell.getStringCellValue());
							}
							break;
		        	case 19:if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
								setShipaddr_name(cell.getStringCellValue());
							}
							break;
		        	case 20:if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
								setShipaddr_addr1(cell.getStringCellValue());
							}
							break;
		        	case 21:if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
								setShipaddr_addr2(cell.getStringCellValue());
							}
							break;
		        	case 22:if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
								setShipaddr_addr3(cell.getStringCellValue());
	 						}
	 						break;
		        	case 23:if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
								setShipaddr_addr4(cell.getStringCellValue());
		 					}
		 					break;
		        	case 24:if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
								setShipaddr_phone(cell.getStringCellValue());
	 						}
							break;
		        	case 25:if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
								setShipaddr_fax(cell.getStringCellValue());
							}
							break;
		        	case 26:if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
								setShipaddr_email(cell.getStringCellValue());
 							}
 							break;
		        	case 27:if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
								setTerms((int) cell.getNumericCellValue());
							}
							break;
		        	case 28:if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
								setTax_included((int) cell.getNumericCellValue());
							}
							break;
		        	case 29:if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
								setTaxtable(cell.getStringCellValue());
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
