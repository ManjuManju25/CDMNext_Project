package Javaxlxs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

import CDMNext.StepDefinations.login;
import CDMNext.util.CommonFunctionality;

public class ReadExcel {
	public static void getTheData(String ExpectedTitle) throws IOException {

		File file = CommonFunctionality.theNewestFile;
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		if (file.exists()) {
			XSSFSheet sheet = wb.getSheetAt(0);
			String sheetName = sheet.getSheetName();
			// login.Log4j.info(sheetName);
			if (sheetName.equalsIgnoreCase(ExpectedTitle)) {
				login.Log4j.info("The tab name is " + sheetName);

			} else {
				Assert.fail("The tab name doesn't match to " + sheetName);
			}

		} else {
			Assert.fail(file + " doesn't exist");
		}
		fis.close();
	}

}
