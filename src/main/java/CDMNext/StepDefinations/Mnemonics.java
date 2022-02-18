
package CDMNext.StepDefinations;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;

import CDMNext.util.CommonFunctionality;
//import org.testng.asserts.SoftAssert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Mnemonics {
	public static String mnemonictxt;
	public String[] series_id = null;
	public String ssp;
	WebDriverWait wait = new WebDriverWait(login.driver, 1000);

	@Given("^User enters Mnemonic$")
	public void user_enters_Mnemonic() throws Throwable {
		login.Log4j.info("Searching with Mnemonic....");
	}

	@SuppressWarnings("unused")
	@Then("^User should get Mnemonic Code and Series_id in SSP window$")
	public void user_should_get_Mnemonic_Code_and_Series_id_in_SSP_window() throws Throwable {

		// Create an object of File class to open xlsx file
		File src = new File(System.getProperty("user.dir") + "\\" + "MnemonicsQA2.xlsx");
		// Create an object of FileInputStream class to read excel file
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(2);
		int rowcount = sheet1.getLastRowNum();
		login.Log4j.info("Total number of rows present in the sheet: " + rowcount);
		int colcount = sheet1.getRow(1).getLastCellNum();
		login.Log4j.info("Total number of columns present in the sheet: " + colcount);
		// Row row = sheet1.getRow(0);
		// login.Log4j.info(row.getLastCellNum());
		int testID = 0;
		int seriesid = 0;
		FileOutputStream fileOut = null;
		for (int i = 1; i <= rowcount; i++) {
			Row currentRow = sheet1.getRow(i);
			XSSFCell cell = sheet1.getRow(i).getCell(0);
			// int testID;
			// login.Log4j.info("Test case id is " + "<" + testID + ">");
			XSSFCell cell2 = sheet1.getRow(i).getCell(1);
			// int seriesid;
			// login.Log4j.info("Series id is " + seriesid);
			XSSFCell cell3 = sheet1.getRow(i).getCell(2);
			Cell status = currentRow.createCell(3);
			String mnemonic = "";
			if (cell3.getCellType() == Cell.CELL_TYPE_STRING) {
				mnemonic = cell3.getStringCellValue();
			}
			if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell2.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				testID = (int) cell.getNumericCellValue();
				seriesid = (int) cell2.getNumericCellValue();
			}
			login.Log4j.info("Entering Mnemonic as " + mnemonic);
			CommonFunctionality.ResetMethod();
			// CommonFunctionality.getElementByProperty(login.driver,"Search",2).clear();
			CommonFunctionality.getElementByProperty(login.driver, "Search", 4).sendKeys(mnemonic);
			login.Log4j.info("Clicking on  Series tab ");
			CommonFunctionality.getElementByProperty(login.driver, "Series", 4).click();
			WebElement ul_element = null;
			try {
				Thread.sleep(1000);
				ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
				AssertJUnit.assertNotNull(ul_element);
				List<WebElement> li_All = ul_element.findElements(By.xpath("//li//div[@class='series-item--name']"));
				login.Log4j.info("List size is :" + li_All.size());
				Boolean MnemonicSearch = false;
				if (li_All.size() > 0) {
					for (int j = 0; j < li_All.size(); j++) {
						li_All.get(j).click();
						// ValidationMethod(seriesid,mnemonic,status);
						Thread.sleep(500);
						WebElement seriesinfo = login.driver
								.findElement(By.xpath("//div[@class='main-series-information--series-id']"));
						ssp = seriesinfo.getText();
						login.Log4j.info(ssp);
						login.Log4j.info(seriesid);
						if (ssp.contains(mnemonic) == true && ssp.contains(String.valueOf(seriesid)) == true) {
							login.Log4j.info(mnemonic + " AND " + seriesid + " exists in " + "\n" + ssp);
							CommonFunctionality.getElementByProperty(login.driver, "closeAction", 4).click();
							login.Log4j.info("Closing... SSP window");
							// Cell status = currentRow.createCell(3);
							status.setCellValue("PASS");
							MnemonicSearch = true;
							break;
						} else {
							CommonFunctionality.getElementByProperty(login.driver, "closeAction", 4).click();
						}
					}
					if (MnemonicSearch == false) {

						if (ssp.contains(mnemonic) != true) {
							CommonFunctionality.getElementByProperty(login.driver, "closeAction", 4).click();
							login.Log4j.info("Closing... SSP window");
							// Cell status = currentRow.createCell(3);
							status.setCellValue("FAIL");
							// status.setCellValue(mnemonic + " does not exists in " + ssp);
							// s_assert.fail(mnemonic + " does not exists in " + ssp);
						} else {
							CommonFunctionality.getElementByProperty(login.driver, "closeAction", 4).click();
							login.Log4j.info("Closing... SSP window");
							// Cell status = currentRow.createCell(3);
							status.setCellValue(seriesid + "  does not exists in " + ssp);
							// s_assert.fail(series_id + " does not exists in " + ssp);
						}
					}
				} else {
					status.setCellValue("Sorry, no results were found here.");
					// Assert.fail("Sorry, no results were found here. ");
				}
			} catch (Exception e) {

				// Assert.fail(e.getMessage());
			}
		}
		// close the input stream
		fis.close();
		// Write the output to a file
		fileOut = new FileOutputStream(src);
		//// write data in the excel file
		wb.write(fileOut);
		// close output stream
		fileOut.close();
	}

	@Given("^Series_id  is \"([^\"]*)\"$")
	public void series_id_is(String arg1) throws Throwable {
		series_id = arg1	
				.split(";");

	}

	@Given("^User enters Mnemonic \"([^\"]*)\"$")
	public void user_enters_Mnemonic(String arg1) throws Throwable {
		mnemonictxt = arg1;
		CommonFunctionality.ResetMethod();
		login.Log4j.info("Searching with " + mnemonictxt);
		CommonFunctionality.getElementByProperty(login.driver, "Search", 4).sendKeys(mnemonictxt);
		CommonFunctionality.getElementByProperty(login.driver, "Search", 4).sendKeys(Keys.ENTER);
	}

	@Then("^User should get Mnemonic Code and Series_id in SSI window$")
	public void user_should_get_Mnemonic_Code_and_Series_id_in_SSI_window() throws Throwable {
		// WebElement element;
		String TooltipInfo = null;
		Boolean MnemonicSearch = false;
		login.Log4j.info("Clicking on  Series tab ");
		CommonFunctionality.getElementByProperty(login.driver, "Series", 4).click();
		//WebElement ul_element = null;
		try {
			Thread.sleep(5000);
//			ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
//			AssertJUnit.assertNotNull(ul_element);
			List<WebElement> li_All = login.driver.findElements(By.xpath("//div[@class='series-item--name']"));
			login.Log4j.info("List size is :" + li_All.size());

			for (int i = 0; i < li_All.size(); i++) {

				if (li_All.size() == 1) {
					CommonFunctionality.wait(500);
					new Actions(login.driver).pause(400).moveToElement(li_All.get(i)).perform();
					CommonFunctionality.wait(800);
					WebElement tooltip = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text")));
					TooltipInfo = tooltip.getText();
					//login.Log4j.info("Title information is \n" + TooltipInfo);

					if (TooltipInfo.contains(mnemonictxt) == true && TooltipInfo.contains(series_id[0]) == true) {
						login.Log4j.info(mnemonictxt + " AND " + series_id[0] + " exists in " + "\n" + TooltipInfo);
						MnemonicSearch = true;

					}

					if (MnemonicSearch == false) {
						if (TooltipInfo.contains(mnemonictxt) != true) {

							Assert.fail(mnemonictxt + "  does not exists in " + "\n" + TooltipInfo);
						} else {
							Assert.fail(series_id[0] + "  does not exists in " + "\n" + TooltipInfo);
						}	
						
					}

				} else if (li_All.size() == 2) {
					
					new Actions(login.driver).pause(400).moveToElement(li_All.get(i)).perform();
					CommonFunctionality.wait(800);
					WebElement tooltip = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text")));
					TooltipInfo = tooltip.getText();

					if ((series_id.length) == 2 && TooltipInfo.contains(mnemonictxt) == true

							&& TooltipInfo.contains(series_id[0]) == true
							|| TooltipInfo.contains(series_id[1]) == true) {
						login.Log4j.info(mnemonictxt + " AND " + series_id[0] + " OR " + series_id[1] + " exists in "
								+ "\n" + TooltipInfo);
						MnemonicSearch = true;
					}
					if (MnemonicSearch == false) {
						if (TooltipInfo.contains(mnemonictxt) != true) {
							Assert.fail(mnemonictxt + "  does not exists in " + "\n" + TooltipInfo);
						} else {
							Assert.fail(series_id[0] + " OR " + series_id[1] + "  does not exists in " + "\n"
									+ TooltipInfo);
						}

					}

				} else {
					Assert.fail("List size is more than 2");
				}
			}
		} catch (NoSuchElementException e) {
			Assert.fail("Sorry, no results were found here. ");

		}
		
					
					/*li_All.get(i).click();

					try {
						WebElement seriesinfo = CommonFunctionality.getElementByProperty(login.driver,
								"sid_srcode_mnemonic", 8);
						String ssi = seriesinfo.getText();
						// login.Log4j.info(ssi);
						// WebElement sr_code = login.driver
						// .findElement(By.xpath(login.LOCATORS.getProperty("//div[@class='main-series-information--series-id']//div[2]")));
						// String sr_code1 = sr_code.getText();
						// login.Log4j.info(sr_code1);
						if (ssi != null) {
							if (ssi.contains(mnemonictxt) == true 	
									) {
								login.Log4j.info(mnemonictxt + " AND " + series_id[0] + " exists in " + "\n" + ssi);
								CommonFunctionality.getElementByProperty(login.driver, "closeAction", 6).click();
								login.Log4j.info("Closing... SSI window");
								
								MnemonicSearch = true;

							}

							if (MnemonicSearch == false) {
								if (ssi.contains(mnemonictxt) != true) {
									
									CommonFunctionality.getElementByProperty(login.driver, "closeAction", 6).click();
									login.Log4j.info("Closing... SSI window");
									Assert.fail(mnemonictxt + "  does not exists in " + "\n" + ssi);
								} else {
									CommonFunctionality.getElementByProperty(login.driver, "closeAction", 6).click();
									login.Log4j.info("Closing... SSI window");
									Assert.fail(series_id[0] + "  does not exists in " + "\n" + ssi);
								}
							}

						}
					} catch (Exception e) {
						CommonFunctionality.getElementByProperty(login.driver, "closeAction", 6).click();
						Assert.fail("SSP window is blank");
					}

				} else if (li_All.size() == 2) {
					li_All.get(i).click();

					try {

						WebElement seriesinfo = CommonFunctionality.getElementByProperty(login.driver,
								"sid_srcode_mnemonic", 8);
						// wait.until(ExpectedConditions.visibilityOf(seriesinfo));
						String ssi = seriesinfo.getText();
						if (ssi != null) {
							// login.Log4j.info(ssi);
							if ((series_id.length) == 2 && ssi.contains(mnemonictxt) == true

									&& ssi.contains(series_id[0]) == true || ssi.contains(series_id[1]) == true) {
								login.Log4j.info(mnemonictxt + " AND " + series_id[0] + " OR " + series_id[1]
										+ " exists in " + "\n" + ssi);
								CommonFunctionality.getElementByProperty(login.driver, "closeAction", 6).click();
								login.Log4j.info("Closing... SSI window");
								MnemonicSearch = true;
							}
							if (MnemonicSearch == false) {
								if (ssi.contains(mnemonictxt) != true) {
									CommonFunctionality.getElementByProperty(login.driver, "closeAction", 6).click();
									login.Log4j.info("Closing... SSI window");
									Assert.fail(mnemonictxt + "  does not exists in " + "\n" + ssi);
								} else {
									CommonFunctionality.getElementByProperty(login.driver, "closeAction", 6).click();

									login.Log4j.info("Closing... SSI window");
									Assert.fail(series_id[0] + " OR " + series_id[1] + "  does not exists in " + "\n"
											+ ssi);
								}

							}
						}
					} catch (Exception e) {
						CommonFunctionality.getElementByProperty(login.driver, "closeAction", 4).click();
						Assert.fail("SSP window is blank");
					}

				} else {
					Assert.fail("List size is more than 2");
				}
			}

		} catch (NoSuchElementException e) {
			Assert.fail("Sorry, no results were found here. ");

		}*/

}

	void ValidationMethod(int seriesid, String mnemonic, Cell status) throws InterruptedException {
		Thread.sleep(500);
		List<WebElement> seriesinfo = login.driver
				.findElements(By.xpath("//div[@class='main-series-information--series-id']"));

		for (WebElement mnemonicText : seriesinfo) {
			ssp = mnemonicText.getText();
			login.Log4j.info(ssp);
			login.Log4j.info(seriesid);
			if (ssp.contains(mnemonic) == true && ssp.contains(String.valueOf(seriesid)) == true) {
				login.Log4j.info(mnemonic + " AND " + seriesid + " exists in " + "\n" + ssp);
				CommonFunctionality.getElementByProperty(login.driver, "closeAction", 4).click();
				login.Log4j.info("Closing... SSP window");
				// Cell status = currentRow.createCell(3);
				status.setCellValue("PASS");

			} else {
				if (ssp.contains(mnemonic) != true) {
					CommonFunctionality.getElementByProperty(login.driver, "closeAction", 4).click();
					login.Log4j.info("Closing... SSP window");
					// Cell status = currentRow.createCell(3);
					status.setCellValue("FAIL");
					// status.setCellValue(mnemonic + " does not exists in " + ssp);
					// s_assert.fail(mnemonic + " does not exists in " + ssp);
				} else {
					CommonFunctionality.getElementByProperty(login.driver, "closeAction", 4).click();
					login.Log4j.info("Closing... SSP window");
					// Cell status = currentRow.createCell(3);
					status.setCellValue(seriesid + "  does not exists in " + ssp);
					// s_assert.fail(series_id + " does not exists in " + ssp);
				}
			}
		}
	}

}

