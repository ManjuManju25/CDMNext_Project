package CDMNext.StepDefinations;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;

import Javaxlxs.File_delete;

public class CompareExcel {

    public static void  Excel(){
        try {
            // get input excel files
        	//Exceldatacompare obj= new Exceldatacompare();
        	 String x=Exceldatacompare.testcase_num;
        	System.out.println(x);
            FileInputStream excellFile1 = new FileInputStream(
            //FileInputStream excellFile1 = new FileInputStream(
                    //"C:\\Users\\Admin\\Documents\\Cucumber_Project\\Cucumber_Project\\securities-cucumber-3c396d71c6ca\\Testdata\\" +x+ ".xlsx");
            		System.getProperty("user.dir")  + "\\Testdata\\" +x+ ".xlsx");
            FileInputStream excellFile2 = new FileInputStream(
           // FileInputStream excellFile2 = new FileInputStream(
                   // "C:\\Users\\Admin\\Downloads\\Untitled insight.xlsx");
            		System.getProperty("user.home") + "\\Downloads\\Untitled insight.xlsx");
            // Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook TestData = new XSSFWorkbook(excellFile1);
            XSSFWorkbook ActualData = new XSSFWorkbook(excellFile2);

            // Get first/desired sheet from the workbook
            XSSFSheet Testdatasheet1 = TestData.getSheetAt(0);
            XSSFSheet ActualDatasheet1 = ActualData.getSheetAt(0);

            // Compare sheets
            if(compareTwoSheets(Testdatasheet1, ActualDatasheet1)) {
                System.out.println("\n\nThe two excel sheets are Equal");
            } else {
                System.out.println("\n\nThe two excel sheets are Not Equal");
            }
            
            //close files
            excellFile1.close();
            excellFile2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }

    // Compare Two Sheets
    public static boolean compareTwoSheets(XSSFSheet Testdatasheet1, XSSFSheet ActualDatasheet1) throws InterruptedException {
    	
    		
    	
        int firstRow1 = Testdatasheet1.getFirstRowNum();
        int lastRow1 = ActualDatasheet1.getLastRowNum();
        boolean equalSheets = true;
        for(int i=firstRow1; i <= lastRow1; i++) {
        	
        	 
            System.out.println("\n\nComparing Row "+i);
            
            XSSFRow Testdatarows = Testdatasheet1.getRow(i);
            XSSFRow Actualdatarows = ActualDatasheet1.getRow(i);
            if(!compareTwoRows(Testdatarows, Actualdatarows)) {
                equalSheets = false;
                System.out.println("Row "+i+" - Not Equal");
                break;
            } else {
                System.out.println("Row "+i+" - Equal");
            }
        }
        return equalSheets;
    }

    // Compare Two Rows
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
               equalRows = false;
               File_delete.delete();
               user_signout();
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
    	
    	
    	
    }

    private static void user_signout() throws InterruptedException {
		// TODO Auto-generated method stub
    	Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='insight-series-container']/div/div/div/div/label/span")).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[6]")).click();
		
	}

	// Compare Two Cells
    public static boolean compareTwoCells(XSSFCell Testdata_cell, XSSFCell Actual_cell) {
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
