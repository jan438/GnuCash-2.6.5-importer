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

public class Vendors {
		
		static Connection conn;
		
		private static String guid;
		private static String name;
		private static String id;
		private static String notes;
		private static String currency;
		private static int active;
		private static int tax_override;
		private static String addr_name;
		private static String addr_addr1;
		private static String addr_addr2;
		private static String addr_addr3;
		private static String addr_addr4;
		private static String addr_phone;
		private static String addr_fax;
		private static String addr_email; 
		private static String terms;
		private static String tax_included;
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
		public static String getCurrency() {
			return currency;
		}
		public static void setCurrency(String icurrency) {
			switch (icurrency) {
			case "USD (US-dollar)" : currency = "bad16cc43a76d8af252f7e657db12258";
								     break;
			case "EUR (euro)" :      currency = "5145eeb060de08ebd599894926d12838";
		       						 break;
			default                : currency = "5145eeb060de08ebd599894926d12838";
		       						 break;
			}
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
		public static String getTerms() {
			return terms;
		}
		public static void setTerms(int iterms) {
			switch (iterms) {
				case 1 : terms = "4b18732ca655c3d0bc90523103f10c80";
					 	 break;
				case 2 : terms = "f5e9f5fd48c7487894d4d51c0ab5693e";
					 	 break;
				default: terms = "4b18732ca655c3d0bc90523103f10c80";
				         break;
		    		
			}
		}
		public static String getTax_included() {
			return tax_included;
		}
		public static void setTax_included(String itax_included) {
			tax_included = itax_included;
		}
		public static String getTaxtable() {
			return taxtable;
		}
		public static void setTaxtable(String itaxtable) {		
			switch (itaxtable) {
			case "Hoog" : taxtable = "e6668e9fc634bf37359f6dbec85a029e";
						  break;
			case "Laag" : taxtable = "e5d6f32651e050e9ea8055cb278b2eab";
		       			  break;
			case "Nul" :  taxtable = "ca23009fb72496e2437032aa7ce1c45c";
				 		  break;
			default    :  taxtable = "e6668e9fc634bf37359f6dbec85a029e";
		       			  break;
			}
		}
		public static void fill_vendors(Connection iconn) {
			  conn = iconn;
		      System.out.println("Reading records from the spreadsheet...");
		      readVendors();
		}		
		private static void insert_into_table() {
			PreparedStatement preparedStatement = null;
			System.out.println("Inserting records into the vendors table...");
		    try {
		    	//                                   1    2     3    4      5        6        7             8            9          10          11         12           13          14        15        16       17        18
				String sql = "INSERT INTO vendors (guid, name, id, notes, currency, active, tax_override, addr_name, addr_addr1, addr_addr2, addr_addr3, addr_addr4, addr_phone, addr_fax, addr_email, terms, tax_inc, tax_table) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				preparedStatement = conn.prepareStatement(sql);			 
				preparedStatement.setString(1, GenerateUUID.getUUID());
				preparedStatement.setString(2, getName());
				preparedStatement.setString(3, getId());
				preparedStatement.setString(4, getNotes()); 
				preparedStatement.setString(5, getCurrency());
				preparedStatement.setInt(6, getActive()); 
				preparedStatement.setInt(7, getTax_override());
				preparedStatement.setString(8, getAddr_name());
				preparedStatement.setString(9, getAddr_addr1());
				preparedStatement.setString(10, getAddr_addr2());
				preparedStatement.setString(11, getAddr_addr3());
				preparedStatement.setString(12, getAddr_addr4());
				preparedStatement.setString(13, getAddr_phone());
				preparedStatement.setString(14, getAddr_fax());
				preparedStatement.setString(15, getAddr_email());
				preparedStatement.setString(16, getTerms());
				preparedStatement.setString(17, getTax_included());
				preparedStatement.setString(18, getTaxtable());
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
		    System.out.println("Inserted records into the vendors table...");
		}
		public static void readVendors() {
			try {
				FileInputStream file = new FileInputStream(new File("/home/marijke/GnuCash-2.6.5-importer/GnuCash-2.6.5-importer/SnelStartVendorExport0001.xlsx"));

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
	        			case 4 :if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
    								setCurrency(cell.getStringCellValue());
    							}
    							break;
			        	case 5 :if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
	        						setActive((int) cell.getNumericCellValue());
	        			 		}
	        					break;        					
	        			case 6:if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
									setTax_override((int) cell.getNumericCellValue());
								}
								break;
			        	case 7: if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
	        						setAddr_name(cell.getStringCellValue());
	        					}
	        					break;
			        	case 8: if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
									setAddr_addr1(cell.getStringCellValue());
				 				}
				 				break;
			        	case 9 :if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
									setAddr_addr2(cell.getStringCellValue());
		 		 				}
		 		 				break;
			        	case 10:if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
									setAddr_addr3(cell.getStringCellValue());
				 				}
								break;
			        	case 11:if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
									setAddr_addr4(cell.getStringCellValue());
		 						}
		 						break;
			        	case 12:if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
									setAddr_phone(cell.getStringCellValue());
			 					}
			 					break;
			        	case 13:if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
									setAddr_fax(cell.getStringCellValue());
		 						}
	        					break;
			        	case 14:if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
									setAddr_email(cell.getStringCellValue());
								}
								break;
			        	case 15:if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
									setTerms((int) cell.getNumericCellValue());
								}
								break;
			        	case 16:if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
									setTax_included(cell.getStringCellValue());
								}
								break;
			        	case 17:if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
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
