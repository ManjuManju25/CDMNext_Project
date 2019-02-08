package CDMNext.StepDefinations;

import java.io.File;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.asserts.SoftAssert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Mnemonics {
	public String mnemonictxt;
	public String[] series_id = null;
	public String ssp;

	@Given("^User enters Mnemonic$")
	public void user_enters_Mnemonic() throws Throwable {
		login.Log4j.info("Searching with Mnemonic....");
	}

	@Then("^User should get Mnemonic Code and Series_id in SSP window$")
	public void user_should_get_Mnemonic_Code_and_Series_id_in_SSP_window() throws Throwable {

		Thread.sleep(10000);
		WebElement element;
		SoftAssert s_assert = new SoftAssert();
		// Create an object of File class to open xlsx file
		File src = new File(System.getProperty("user.dir") + "\\" + "MnemonicsSheet2.xlsx");
		// Create an object of FileInputStream class to read excel file
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		int rowcount = sheet1.getLastRowNum();
		login.Log4j.info("Total number of rows present in the sheet: " + rowcount);
		int colcount = sheet1.getRow(1).getLastCellNum();
		login.Log4j.info("Total number of columns present in the sheet: " + colcount);
		// Row row = sheet1.getRow(0);
		// login.Log4j.info(row.getLastCellNum());

		for (int i = 1; i <= rowcount; i++) {
			Row currentRow = sheet1.getRow(i);
			XSSFCell cell = sheet1.getRow(i).getCell(0);
			String testID = "";
			// login.Log4j.info("Test case id is " + "<" + testID + ">");
			XSSFCell cell2 = sheet1.getRow(i).getCell(1);
			String seriesid = "";
			// login.Log4j.info("Series id is " + seriesid);
			XSSFCell cell3 = sheet1.getRow(i).getCell(2);
			Cell status = currentRow.createCell(3);
			String mnemonic = "";
			if (cell3.getCellType() == cell.CELL_TYPE_STRING) {
				mnemonic = cell3.getStringCellValue();
			} else if (cell.getNumericCellValue() == cell.CELL_TYPE_NUMERIC
					|| cell2.getNumericCellValue() == cell.CELL_TYPE_NUMERIC) {
				testID = cell.getStringCellValue();
				seriesid = cell2.getStringCellValue();
			}
			login.Log4j.info("Entering Mnemonic as " + mnemonic);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).clear();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys(mnemonic);
			login.Log4j.info("Clicking on  Series tab ");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
			// create object of Actions class
			Actions mouseOver = new Actions(login.driver);
			WebElement ul_element = null;
			try {
				ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
				AssertJUnit.assertNotNull(ul_element);
				List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
				login.Log4j.info("List size is :" + li_All.size());
				if (li_All.size() > 0) {
					Thread.sleep(2000);
					element = login.driver.findElement(By.xpath("//div[@class='series-item--name']"));
					mouseOver.moveToElement(element).click().build().perform();
					List<WebElement> seriesinfo = login.driver
							.findElements(By.xpath("//div[@class='main-series-information--series-id']"));

					for (WebElement mnemonicText : seriesinfo) {
						ssp = mnemonicText.getText();
						// login.Log4j.info(ssi);

						if (ssp.contains(mnemonic) == true && ssp.contains(seriesid) == true) {
							login.Log4j.info(mnemonic + " AND " + seriesid + " exists in " + "\n" + ssp);
							Thread.sleep(2000);
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
							login.Log4j.info("Closing... SSP window");
							// Cell status = currentRow.createCell(3);
							status.setCellValue("PASS");

						} else {
							if (ssp.contains(mnemonic) != true) {
								Thread.sleep(3000);
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
								login.Log4j.info("Closing... SSP window");
								// Cell status = currentRow.createCell(3);
								status.setCellValue("FAIL");
								// status.setCellValue(mnemonic + " does not exists in " + ssp);
								// s_assert.fail(mnemonic + " does not exists in " + ssp);
							} else {
								Thread.sleep(3000);
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
								login.Log4j.info("Closing... SSP window");
								// Cell status = currentRow.createCell(3);
								status.setCellValue(seriesid + "  does not exists in " + ssp);
								// s_assert.fail(series_id + " does not exists in " + ssp);
							}
						}
					}

				} else {
					Assert.fail("Sorry, no results were found here. ");
				}
			} catch (NoSuchElementException e) {
				Assert.fail( e.getMessage());
			}
		}
		// close the input stream
		fis.close();
		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream(src);
		//// write data in the excel file
		wb.write(fileOut);
		// close output stream
		fileOut.close();

	}

	@Given("^Series_id  is \"([^\"]*)\"$")
	public void series_id_is(String arg1) throws Throwable {
		series_id = arg1.split(";");

	}

	@Given("^User enters Mnemonic \"([^\"]*)\"$")
	public void user_enters_Mnemonic(String arg1) throws Throwable {
		mnemonictxt = arg1;
		login.Log4j.info("Searching with " + mnemonictxt);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).clear();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys(mnemonictxt);
	}

	@Then("^User should get Mnemonic Code and Series_id in SSI window$")
	public void user_should_get_Mnemonic_Code_and_Series_id_in_SSI_window() throws Throwable {
		WebElement element;
		Boolean MnemonicSearch = false;
		login.Log4j.info("Clicking on  Series tab ");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		// create object of Actions class
		Actions mouseOver = new Actions(login.driver);
		Thread.sleep(2000);
		WebElement ul_element = null;
		try {
			ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
			AssertJUnit.assertNotNull(ul_element);
			List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
			login.Log4j.info("List size is :" + li_All.size());

			if (li_All.size() > 0) {
				for (int i = 0; i < li_All.size(); i++) {

					if (li_All.size() == 1) {
						Thread.sleep(2000);
						element = login.driver.findElement(By.xpath("//div[@class='series-item--name']"));
						mouseOver.moveToElement(element).click().build().perform();
						Thread.sleep(3000);
						List<WebElement> seriesinfo = login.driver
								.findElements(By.xpath(login.LOCATORS.getProperty("sid_srcode_mnemonic")));
						for (WebElement mnemonicText : seriesinfo) {
							String ssi = mnemonicText.getText();
							// login.Log4j.info(ssi);
							if ((series_id.length) == 1 && ssi.contains(mnemonictxt) == true
									&& ssi.contains(series_id[0]) == true) {
								login.Log4j.info(mnemonictxt + " AND " + series_id[0] + " exists in " + "\n" + ssi);
								Thread.sleep(2000);
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
								login.Log4j.info("Closing... SSI window");
								MnemonicSearch = true;

							}
							/*
							 * } else if ((series_id.length) == 2 && ssi.contains(mnemonictxt) == true &&
							 * ssi.contains(series_id[0]) == true || ssi.contains(series_id[1]) == true) {
							 * login.Log4j.info(mnemonictxt + " AND " + series_id[0] + " OR " + series_id[1]
							 * + " exists in " + "\n" + ssi); Thread.sleep(2000);
							 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction")))
							 * .click(); login.Log4j.info("Closing... SSI window"); MnemonicSearch = true; }
							 */
							if (MnemonicSearch == false) {
								if (ssi.contains(mnemonictxt) != true) {
									Thread.sleep(3000);
									login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction")))
											.click();
									login.Log4j.info("Closing... SSI window");
									Assert.fail(mnemonictxt + "  does not exists in " + "\n" +ssi);
								} else {
									Thread.sleep(3000);
									login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction")))
											.click();
									login.Log4j.info("Closing... SSI window");
									Assert.fail(series_id[0] + "  does not exists in " + "\n" + ssi);
								}
							}
						}
					} else if (li_All.size() == 2) {
						Thread.sleep(2000);
						int j = i + 1;
						element = login.driver
								.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
						mouseOver.moveToElement(element).click().build().perform();
						Thread.sleep(3000);
						List<WebElement> seriesinfo = login.driver
								.findElements(By.xpath(login.LOCATORS.getProperty("sid_srcode_mnemonic")));
						for (WebElement mnemonicText : seriesinfo) {
							String ssi = mnemonicText.getText();
							// login.Log4j.info(ssi);
							if ((series_id.length) == 2 && ssi.contains(mnemonictxt) == true
									&& ssi.contains(series_id[0]) == true || ssi.contains(series_id[1]) == true) {
								login.Log4j.info(mnemonictxt + " AND " + series_id[0] + " OR " + series_id[1]
										+ " exists in " + "\n" + ssi);
								Thread.sleep(2000);
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
								login.Log4j.info("Closing... SSI window");
								MnemonicSearch = true;
							}
							if (MnemonicSearch == false) {
								if (ssi.contains(mnemonictxt) != true) {
									Thread.sleep(3000);
									login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction")))
											.click();
									login.Log4j.info("Closing... SSI window");
									Assert.fail(mnemonictxt + "  does not exists in "+ "\n" + ssi);
								} else {
									Thread.sleep(3000);
									login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction")))
											.click();
									login.Log4j.info("Closing... SSI window");
									Assert.fail(series_id[0] + " OR " + series_id[1] + "  does not exists in " + "\n" + ssi);
								}

							}
						}

					} else {
						Assert.fail("List size is more than 2");
					}
			 }
			} else {
				Assert.fail("Sorry, no results were found here. ");
			}
		} catch (NoSuchElementException e) {
			Assert.fail("Sorry, no results were found here. ");

		}

	}

}
