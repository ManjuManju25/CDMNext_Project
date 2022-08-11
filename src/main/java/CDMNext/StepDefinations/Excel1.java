package CDMNext.StepDefinations;

import static org.junit.Assert.fail;
import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import CDMNext.util.CommonFunctionality;
import Javaxlxs.File_delete;

public class Excel1 {
	
	
		public void enter_the_Testdata_as(String args,String arg1) throws Throwable {
			
			
			Crosssection_Excelverify(login.driver,args,arg1);
		}
		public static void Crosssection_Excelverify(WebDriver driver, String Excel1, String Excel2) throws Throwable {
			Thread.sleep(20000);
			String path1 = "C:\\Users\\tbemineni\\Desktop\\New folder\\Cucumber_project\\Testdata\\"+Excel1+".xlsx";
			String path2 = "C:\\Users\\tbemineni\\Downloads\\"+Excel2+".xlsx";
			
			FileInputStream excellFile1 = new FileInputStream(path1);
			FileInputStream excellFile2 = new FileInputStream(path2);
			XSSFWorkbook TestData = new XSSFWorkbook(excellFile1);
			XSSFWorkbook ActualData = new XSSFWorkbook(excellFile2);
			XSSFSheet Testdatasheet1 = TestData.getSheetAt(0);
			XSSFSheet ActualDatasheet1 = ActualData.getSheetAt(0);
			XSSFRow Testdatarows = Testdatasheet1.getRow(1);
			XSSFRow Actualdatarows = ActualDatasheet1.getRow(1);
			if (compareTwoSheets(Testdatasheet1, ActualDatasheet1)) {
				login.Log4j.info("The two excel sheets are Equal");
			} else {
				fail("The two excel sheets are not Equal");
			}
			excellFile1.close();
			excellFile2.close();
			Files.deleteIfExists(Paths.get(path2));
		}

		public static boolean CompareComments(XSSFRow Testdatarows, XSSFRow Actualdatarows) throws Throwable {
			if ((Testdatarows == null) && (Actualdatarows == null)) {
				return true;
			} else if ((Testdatarows == null) || (Actualdatarows == null)) {
				return false;
			}
			boolean equallinks = true;
			int firstcommentCell = Testdatarows.getFirstCellNum();
			int lastcommentCell = Testdatarows.getLastCellNum();
			for (int i = firstcommentCell; i < lastcommentCell; i++) {
				XSSFCell Testdatacommentcell = Testdatarows.getCell(i);
				XSSFCell Actualdatacommentcell = Actualdatarows.getCell(i);
				String Testdatacomment = Testdatacommentcell.toString();
				System.out.println(Testdatacomment);
				System.out.println();
				Thread.sleep(1000);
				String Actualdatacomment = Actualdatacommentcell.toString();
				System.out.println(Actualdatacomment );
				if (Testdatacomment != null && Actualdatacomment != null) {
					assertEquals(Testdatacomment, Actualdatacomment);
				}
			}
			return equallinks;
		}
		public static boolean compareTwoSheets(XSSFSheet Testdatasheet1, XSSFSheet ActualDatasheet1)
				throws InterruptedException {
			int firstRow1 = Testdatasheet1.getFirstRowNum();
			int lastRow1 = ActualDatasheet1.getLastRowNum();
			boolean equalSheets = true;
			for (int i = 1; i <= lastRow1; i++) {
				System.out.println("Comparing Row " + i);
				XSSFRow Testdatarows = Testdatasheet1.getRow(i);
				XSSFRow Actualdatarows = ActualDatasheet1.getRow(i);
				if (compareTwoRows(Testdatarows, Actualdatarows)) {
					equalSheets = true;
					System.err.println("Row " + i + " -  Equal");
				} else {
					System.out.println("Row " + i + " - Not Equal");
				}
			}
			return equalSheets;
		}
		public static boolean compareTwoRows(XSSFRow Testdatarows, XSSFRow Actualdatarows) throws InterruptedException {
	    	
    		
	    	
	        if((Testdatarows == null) && (Actualdatarows == null)) {
	            return true;
	        } else if((Testdatarows == null) || (Actualdatarows == null)) {
	            return false;
	        }
	      
	        int firstCell1 = Testdatarows.getFirstCellNum();
	        int lastCell1 = Testdatarows.getLastCellNum();
	        boolean equalRows = true;
	        
	        // Compare all cells in a row
	        for(int i=firstCell1; i <= lastCell1-1; i++) {
	            XSSFCell Testdata_cell = Testdatarows.getCell(i);
	            XSSFCell Actual_cell = Actualdatarows.getCell(i);
	       
	            if(!compareTwoCells(Testdata_cell, Actual_cell)) {
	               equalRows =false;
	               Assert.fail( "Data verification failed in Downloaded Excel:-"  + Testdata_cell +  "' <> '" + Actual_cell + "'");
	              // Assert.fail( "Cell "+i+" - Not Equal" +"; Value of Testdata_cell is \"" +Testdata_cell + "\" - Value of Actual_cell is \"" +Actual_cell + "\""); 
	       		 
	               System.err.println("       Cell "+i+" - Not Equal" +"; Value of Testdata_cell is \"" +Testdata_cell + "\" - Value of Actual_cell is \"" +Actual_cell + "\"");
	                //System.out.println("       Cell "+i+" - NOt Equal");
	               //break;
	            } else  {
	                //System.out.println("       Cell "+i+" - Equal");
	                System.out.println("       Cell "+i+" - Equal" +"; Value of Testdata_cell is \"" +Testdata_cell + "\" - Value of Actual_cell is \"" +Actual_cell + "\"");
	               //System.out.println("Actual data"+Actual_cell.getStringCellvalue());
	            	//System.out.println("Actual data"+Actual_cell.getStringCellValue());
	            }									
	        }
	        return equalRows; 
	    	
	    	
	    	
	    } public static boolean compareTwoCells(XSSFCell Testdata_cell, XSSFCell Actual_cell) {
	        if((Testdata_cell == null) && (Actual_cell == null)) {
	            return true;
	        } else if((Testdata_cell == null) || (Actual_cell == null)) {
	            return false;
	        }
	        
	        boolean equalCells = false;
	        int type1 = Testdata_cell.getCellType();
	        int type2 = Actual_cell.getCellType();
	        if (type1 == type2) {
	            if (Testdata_cell.getCellStyle().equals(Actual_cell.getCellStyle())) {
	            	
	                // Compare cells based on its type
	                switch (Testdata_cell.getCellType()) {
	                case HSSFCell.CELL_TYPE_FORMULA:
	                    if (Testdata_cell.getCellFormula().equals(Actual_cell.getCellFormula())) {
	                        equalCells = true;
	                    }
	                    break;
	                case HSSFCell.CELL_TYPE_NUMERIC:
	                    if (Testdata_cell.getNumericCellValue() == Actual_cell
	                            .getNumericCellValue()) {
	                        equalCells = true;
	                    }
	                    break;
	                case HSSFCell.CELL_TYPE_STRING:
	                	
	                    if (Testdata_cell.getStringCellValue().equals(Actual_cell
	                            .getStringCellValue())) {
	                        equalCells = true;
	                    }
	                    break;     	
	                case HSSFCell.CELL_TYPE_BLANK:
	                    if (Actual_cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
	                        equalCells = true;
	                    }
	                    break;
	                case HSSFCell.CELL_TYPE_BOOLEAN:
	                    if (Testdata_cell.getBooleanCellValue() == Actual_cell
	                            .getBooleanCellValue()) {
	                        equalCells = true;
	                    }
	                    break;
	                case HSSFCell.CELL_TYPE_ERROR:
	                    if (Testdata_cell.getErrorCellValue() == Actual_cell.getErrorCellValue()) {
	                        equalCells = true;
	                    }
	                    break;
	                default:
	                    if (Testdata_cell.getStringCellValue().equals(
	                    		Actual_cell.getStringCellValue())) {
	                    	//System.out.println("Testdata"+ Testdata_cell.getStringCellValue());
	                    	//System.out.println("Actual data"+Actual_cell.getStringCellValue());
	                        equalCells = true;
	                    }
	                    break;
	                }
	            } else {
	                return false;
	            }
	        } else {
	            return false;
	        }
	        return equalCells;
	    }
  
		
	}



