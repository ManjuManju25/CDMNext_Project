package Javaxlxs;
import java.io.Closeable;
import java.io.File;

import java.io.FileFilter;
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap; 
import java.util.Iterator; 
import java.util.Map; 
import java.util.Set;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.poi.ss.usermodel.Cell; 
import org.apache.poi.ss.usermodel.Row; 
import org.apache.poi.xssf.usermodel.XSSFSheet; 
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import CDMNext.StepDefinations.Latestfiledownload;
import CDMNext.StepDefinations.login; 


public class xlxs {
	//public static void main(String[] args) 
	public static void writexlxs()
	{
		try { 
			//File excel = new File("C://temp/Employee.xlsx"); 
			//File excel = new File("C://Users//Admin//Documents//Cucumber_Project//Cucumber_Project//securities-cucumber-3c396d71c6ca//Download.xlsx"); 	
			System.out.print("Entered in xlsx*****");
			File excel = new File("C:\\Users\\Admin\\Documents\\Cucumber_Project\\Cucumber_Project\\securities-cucumber-3c396d71c6ca\\Download.xlsx"); 
			FileInputStream fis = new FileInputStream(excel); 
		XSSFWorkbook book = new XSSFWorkbook(fis); 
		XSSFSheet sheet = book.getSheetAt(0);
		Iterator<Row> itr = sheet.iterator();
		// Iterating over Excel file in Java 
		
		while (itr.hasNext()) 
		{
			Row row = itr.next();

		// Iterating over each column of Excel file 
		Iterator<Cell> cellIterator = row.cellIterator(); 
		while (cellIterator.hasNext()) {

			Cell cell = cellIterator.next();
			switch (cell.getCellType()) 
			{
			case Cell.CELL_TYPE_STRING: 
				System.out.print(cell.getStringCellValue() + "\t"); 
				break; 
			case Cell.CELL_TYPE_NUMERIC: 
				System.out.print(cell.getNumericCellValue() + "\t"); 
				break; case Cell.CELL_TYPE_BOOLEAN: 
				System.out.print(cell.getBooleanCellValue() + "\t");
				break; 
				default: 
			}
		}
        System.out.println("");
    }
		
		// writing data into XLSX file 
		Map<String, Object[]> newData = new HashMap<String, Object[]>();
		
		
		File theNewestFile = null;
	    File dir = new File(System.getProperty("user.home") + "\\Downloads");
	    String ext="pdf";
	    FileFilter fileFilter = new WildcardFileFilter("*." + ext);
	    File[] files = dir.listFiles(fileFilter);
	    
	    if (files.length > 0) {
	        /** The newest file comes first **/
	        Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
	        theNewestFile = files[0];
	    //}

	    //return theNewestFile;
	    login.Log4j.info("****************> THE SUCCESFULLY DOWNLOADED INSIGHTS  - >***************");
		String x = (double) theNewestFile.length() / 1024 + "  kb";
		
			   //String z="FAIL";
			   //System.out.println("The Downloaded Insight Fail"+ theNewestFile + " - Status : " + z );
		   //}
	   
	    if (theNewestFile.exists()){
	    	 String y="PASS";
	  login.Log4j.info("The Downloaded Insight are - " + theNewestFile +   " - Size : " +  x  +   " - Status : " + y );
	  
	    }else{
	    	 String z="FAIL";
			   System.out.println("The Downloaded Insight Fail"+ theNewestFile + " - Status : " + z );
			   return;
		   //}
	    }
	          String y="PASS";
	        String key=theNewestFile.getName();
	        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	       newData.put(key,new Object[]{timeStamp,key,x,y});
	    }
		
		//Latestfiledownload.lastFileModified();
		/*
		File file = new File("C:\\Users\\Admin\\Downloads");
		File[] files = file.listFiles();
		String y = "FAIL";
		
		for (File currentfile : files) {
			String x = (double) currentfile.length() / 1024 + "  kb";
			String key=currentfile.getName();
			if(currentfile.exists()){
				 y = "PASS";
			login.Log4j.info("The Downloaded Insight are - " + currentfile.getName() +   " - Size : " +  x  +   " - Status : " + y );
			newData.put(key,new Object[]{key,x,y});
			
		}
			else{
				//String y = "FAIL";
				login.Log4j.info("The Downloaded Insight are - " + currentfile.getName() +   " - Size : " +  x  +   " - Status : " + y );
			}
			//login.Log4j.info("The Downloaded Insight are - " + currentfile.getName() +   " - Size : " +  x  +   " - PASS" );
			
			//(currentfile.getName(), x);
			//login.Log4j.info("Size : " + x + "PASSED");
			//System.out.println("Size : " + x);
		}
	*/
		
		
		
		Set<String> newRows = newData.keySet(); 
		int rownum = sheet.getLastRowNum();

		for (String key : newRows) 
		{ 
			Row row = sheet.createRow(rownum++);
			Object[] objArr = newData.get(key);
			int cellnum = 0;
			for (Object obj : objArr) 
			{ 
				Cell cell = row.createCell(cellnum++); 
				if (obj instanceof String) 
				{
					cell.setCellValue((String) obj); 
					}
				else if (obj instanceof Boolean) 
				{
					cell.setCellValue((Boolean) obj); 
					} 
				else if (obj instanceof Date) 
				{ cell.setCellValue((Date) obj); 
				
				} 
				else if (obj instanceof Double) 
				{
					cell.setCellValue((Double) obj); 
					} 
				} 
			}
		// open an OutputStream to save written data into Excel file

		FileOutputStream os = new FileOutputStream(excel); 
		book.write(os); 
		System.out.println("Writing on Excel file Finished ...");

		// Close workbook, OutputStream and Excel file to prevent leak 
		os.close(); 
		((Closeable) book).close(); 
		fis.close(); 

		} 
		catch (FileNotFoundException fe) 
		{ 
			fe.printStackTrace();
			} 
		catch (IOException ie) 
		{ 
			ie.printStackTrace();
			} 
		}

	//private static Object currentfile(String name, String x) {
		// TODO Auto-generated method stub
		//return null;
	//} 
	
	
	}

		
		

			
		
	