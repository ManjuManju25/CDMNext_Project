package CDMNext.StepDefinations;

import java.io.File;

import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
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
	public static String mnemonic = "";
	public String series_id;
	public String ssp;
	public String testID;
	//Boolean MnemonicSearch = false;

	@Given("^User enters Mnemonic$")
	public void user_enters_Mnemonic() throws Throwable {
		/*File src = new File(System.getProperty("user.dir") + "\\" + "MnemonicsQA1.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		DataFormatter formatter = new DataFormatter();
		int rowcount = sheet1.getLastRowNum();
		login.Log4j.info("Total num of rows is" + rowcount);
		for (int i = 1; i < rowcount; i++) {
			testID=formatter.formatCellValue(sheet1.getRow(i).getCell(0));
			login.Log4j.info("Test cases id from Excel is " + "<"+testID+">");
		    series_id = formatter.formatCellValue(sheet1.getRow(i).getCell(1));
			login.Log4j.info("Series id from Excel is " + series_id);
		    mnemonic = formatter.formatCellValue(sheet1.getRow(i).getCell(2));
			login.Log4j.info("Mnemonic from Excel is " + mnemonic);
			Thread.sleep(3000);
			List<WebElement> reset = login.driver.findElements(By.xpath("//span[contains(text(),'Reset')]"));
			if (reset.size() > 0) {
				if (login.driver.findElement(By.xpath("//span[contains(text(),'Reset')]")).isDisplayed()) {
					login.driver.findElement(By.xpath("//span[contains(text(),'Reset')]")).click();
					login.Log4j.info("Clicking on Reset button");
				}
			}
			login.Log4j.info("Searching with " + mnemonic);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).clear();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys(mnemonic);
			user_should_get_Mnemonic_Code_and_Series_id_in_SSP_window();
		}

		fis.close();*/
		login.Log4j.info("Searching with Mnemonic....");
	}

/*	@Then("^User should get Mnemonic Code and Series_id in SSP window$")
	public void user_should_get_Mnemonic_Code_and_Series_id_in_SSP_window() throws Throwable {
		WebElement element;
		SoftAssert s_assert = new SoftAssert();
		File src = new File(System.getProperty("user.dir") + "\\" + "MnemonicsQA1.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		DataFormatter formatter = new DataFormatter();
		int rowcount = sheet1.getLastRowNum();
		//login.Log4j.info("Total num of rows is " + rowcount);
		for (int i = 1; i < rowcount; i++) {
			testID=formatter.formatCellValue(sheet1.getRow(i).getCell(0));
			login.Log4j.info("Test case id  is " + "<"+testID+">");
		    series_id = formatter.formatCellValue(sheet1.getRow(i).getCell(1));
			login.Log4j.info("Series id is " + series_id);
		    mnemonic = formatter.formatCellValue(sheet1.getRow(i).getCell(2));
			//login.Log4j.info("Mnemonic is " + mnemonic);
			Thread.sleep(3000);
			List<WebElement> reset = login.driver.findElements(By.xpath("//span[contains(text(),'Reset')]"));
			if (reset.size() > 0) {
				if (login.driver.findElement(By.xpath("//span[contains(text(),'Reset')]")).isDisplayed()) {
					login.driver.findElement(By.xpath("//span[contains(text(),'Reset')]")).click();
					login.Log4j.info("Clicking on Reset button");
				}
			}
			login.Log4j.info("Entering Mnemonic as " + mnemonic);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).clear();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys(mnemonic);
		    login.Log4j.info("Clicking on  Series tab ");
		    login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		    // create object of Actions class
		    Actions mouseOver = new Actions(login.driver);
		    List<WebElement> series = login.driver.findElements(By.xpath("//div[@class='series-item--name']"));
		    login.Log4j.info("Series size is " + series.size());
		    if (series.size() > 0) {
			   Thread.sleep(2000);
			   element = login.driver.findElement(By.xpath("//div[@class='series-item--name']"));
			    mouseOver.moveToElement(element).click().build().perform();
			     List<WebElement> seriesinfo = login.driver
					.findElements(By.xpath("//div[@class='main-series-information--series-id']"));
			    for (WebElement mnemonicText : seriesinfo) {
				  ssp = mnemonicText.getText();
				  // login.Log4j.info(ssi);
				  String[] attrList=ssp.split("\n");
				  String sid=attrList[0];
				  String Mncode=attrList[2];
				  login.Log4j.info("sid is "+attrList[0]);
				  login.Log4j.info("Mnemonic code is "+attrList[2]);
				  String Mncode=null;
				   try {
				     Mncode=attrList[2];
				    }catch(ArrayIndexOutOfBoundsException e) {
					
				   }
				 if (ssp.contains(mnemonic) == true && ssp.contains(series_id) == true) {
					login.Log4j.info(mnemonic + " AND " + series_id + " exists in " + "\n" + ssp);
					Thread.sleep(2000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
					login.Log4j.info("Closing... SSP window");
					
				  } else {

					if (ssp.contains(mnemonic) != true) {
						Thread.sleep(3000);
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
						login.Log4j.info("Closing... SSP window");
						//s_assert.assertNotEquals(Mncode, mnemonic, "  does not exists ");
						//s_assert.assertEquals(Mncode, mnemonic, "  does not exists " );
						s_assert.fail(mnemonic + "  does not exists in " + ssp);
					} else {
						Thread.sleep(3000);
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
						login.Log4j.info("Closing... SSP window");
						//MnemonicSearch = false;
						//Assert.assertEquals(series_id, true);
						//s_assert.assertEquals(sid, series_id, "  does not exists ");
						s_assert.fail(series_id + "  does not exists in " + ssp);
					}
				}
			}

		} else {
			Assert.fail("Sorry, no results were found here. ");
		}
	}
		fis.close();
	}*/
	

	@Given("^Series_id  is \"([^\"]*)\"$")
	public void series_id_is(String arg1) throws Throwable {
		series_id=arg1;
		login.Log4j.info(series_id);
	}
	@Given("^User enters Mnemonic \"([^\"]*)\"$")
	public void user_enters_Mnemonic(String arg1) throws Throwable {
	    mnemonic=arg1;
	    login.Log4j.info("Searching with " + mnemonic);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).clear();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys(mnemonic);
	}

	@Then("^User should get Mnemonic Code and Series_id in SSI window$")
	public void user_should_get_Mnemonic_Code_and_Series_id_in_SSI_window() throws Throwable {
		WebElement element;
		WebElement checkbox;
		login.Log4j.info("Clicking on  Series tab ");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		// create instance of JavaScriptExecutor
		JavascriptExecutor jse = (JavascriptExecutor) login.driver;
		// create object of Actions class
		Actions mouseOver = new Actions(login.driver);

		WebElement ul_element = null;
		try {
			ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
			AssertJUnit.assertNotNull(ul_element);
			List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
			login.Log4j.info("List size is :" + li_All.size());

			if (li_All.size() > 0) {
				for (int i = 0; i < li_All.size(); i++) {

					login.Log4j.info(i);
					login.Log4j.info(li_All.size());
					Thread.sleep(1000);
					int j = i + 1;
					checkbox = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
					mouseOver.moveToElement(checkbox).click().build().perform();
					Thread.sleep(2000);
					element = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--info-icon-i']"));
					mouseOver.moveToElement(element).click().build().perform();
					// Until the element is not visible keep scrolling
					jse.executeScript("arguments[0].scrollIntoView(true);", element);
					Thread.sleep(3000);
					List<WebElement> seriesinfo = login.driver
							.findElements(By.xpath(login.LOCATORS.getProperty("sid_srcode_mnemonic")));
					for (WebElement mnemonicText : seriesinfo) {
						String ssi = mnemonicText.getText();
						 //login.Log4j.info(ssi);
						if (ssi.contains(mnemonic) == true && ssi.contains(series_id) == true) {
							login.Log4j.info(mnemonic + " AND "+ series_id + " exists in " + "\n" + ssi);
							Thread.sleep(2000);
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
							login.Log4j.info("Closing... SSI window");
						} else {
							if(ssi.contains(mnemonic) != true) {
							  Thread.sleep(3000);
							  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
							  login.Log4j.info("Closing... SSI window");
							  Assert.fail(mnemonic + "  does not exists in " + ssi);
							} else {
								  Thread.sleep(3000);
								  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
								  login.Log4j.info("Closing... SSI window");
								  Assert.fail(series_id + "  does not exists in " + ssi);
							}
						}
						   
					}
				}
			} else {
				Assert.fail("List size is null");
			}
		} catch (NoSuchElementException e) {
			Assert.fail("Sorry, no results were found here. " + e.getMessage());
			
		}
		
	}


}
