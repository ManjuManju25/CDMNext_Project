package CDMNext.StepDefinations;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
//import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.asserts.SoftAssert;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SeriesTab {
	Robot robot;
	public static String searchData;
	String[] sid = null;
	List<String> indicator = new ArrayList<>();
	public String Tooltip;
	public WebElement Showdatabase;
	public static String SeriesCopied;
	public static WebElement copiedSeries;
	public String SeriesNames;
	List<String> Copy = new ArrayList<>();
	List<String> Series = new ArrayList<>();
	public String sname;
	public String str1;
	public String str2;
	public String filter;
	public String seriesName;
	public String db = "null";
	public String MousehoverIcon;
	public WebElement dbase;
	public String stext;
	public String insightName;
	public WebElement confirmPopup;
	public WebElement checkbox;
	public WebElement element;
	public WebElement ele;
	public WebElement ul_element = null;
	Boolean refresh = false;
	String text;
	int matched_insightsCount;
	List<String> seriesText = null;
	SoftAssert s_assert = new SoftAssert();
	Boolean newInsight = false;
	WebDriverWait wait = new WebDriverWait(login.driver, 2000);
	 Actions action = new Actions(login.driver);
	 JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	
	@Given("^User enters seriesID \"([^\"]*)\"$")
	public void user_enters_seriesID(String arg1) throws Throwable {
		//login.driver.navigate().refresh();
		CommonFunctionality.ResetMethod();
		CommonFunctionality.UnselectMethod();
		searchData = arg1;
		login.Log4j.info("Searching with " + searchData);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).clear();
		Thread.sleep(1500);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys(searchData);
		//CommonFunctionality.UnselectMethod();

	}

	@When("^User right click on any series$")
	public void user_right_click_on_any_series() throws Throwable {
		WebElement rightClickElement;
		int j = 0;
		login.Log4j.info("Clicking on Series tab ");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Series"))));
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		ul_element = null;
		try {
			Thread.sleep(2000);
			ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
			AssertJUnit.assertNotNull(ul_element);
			List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
			login.Log4j.info("List size is :" + li_All.size());
			if (li_All.size() > 0) {
				for (int i = 0; i < li_All.size(); i++) {
					Thread.sleep(1500);
					j = i + 1;
					checkbox = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
					action.moveToElement(checkbox).click().build().perform();
					copiedSeries = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
					SeriesNames = copiedSeries.getText();
					login.Log4j.info(SeriesNames);
					Copy.add(SeriesNames);
					// login.Log4j.info(Copy);
				}
			} else {
				Assert.fail("Sorry,No results were found ");
			}
			Thread.sleep(2000);
			rightClickElement =login.driver.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
			// contextClick() method to do right click on the element
			action.contextClick(rightClickElement).build().perform();
//			Thread.sleep(3000);
		} catch (NoSuchElementException e) {
			Assert.fail("WebElement is null " + e.getMessage());
		}
	}

	@Then("^User can able to see \"([^\"]*)\" option from dropdown menu$")
	public void user_can_able_to_see_option_from_dropdown_menu(String arg1) throws Throwable {
		checkbox = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Checkbox")));
		login.Log4j.info("Clicking on " + arg1);
		try {
			if (arg1.equals("Unselect all")) {
				login.driver.findElement(By.xpath("//span[@title='" + arg1 + "']")).click();
				if (!checkbox.isSelected()) {
					login.Log4j.info("The Selected series are unselected ");
				} else {
					Assert.fail("The Selected series are not unselected ");
				}
			} else if (arg1.equalsIgnoreCase("Copy")) {
				login.driver.findElement(By.xpath("//span[@title='" + arg1 + "']")).click();
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("copy_popup_text"))).isDisplayed()) {
					PasteIntoExcel(Copy);
				}
			} else if (arg1.equals("Copy data")) {
				CommonFunctionality.wait(2000);
				login.driver.findElement(By.xpath("//span[@title='" + arg1 + "']")).click();
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("clipboard"))).isDisplayed()) {
					CommonFunctionality.wait(2000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("clipboard"))).click();
					Thread.sleep(2000);
					String data = (String) Toolkit.getDefaultToolkit().getSystemClipboard()
							.getData(DataFlavor.stringFlavor);
					login.Log4j.info(data);
					if (data != null) {
						login.Log4j.info("The selected series are copied into CTC for " + arg1 + " option");
					} else {
						login.Log4j.info("The selected series are not copied into CTC for " + arg1 + " option");
					}
				}
			} else if (arg1.equalsIgnoreCase("Series Info")) {
				login.driver.findElement(By.xpath("//span[@title='" + arg1 + "']")).click();
				List<WebElement> element = login.driver
						.findElements(By.xpath(login.LOCATORS.getProperty("series_info")));
				for (WebElement Seriesinfo : element) {
					String ssi = Seriesinfo.getText();
					login.Log4j.info(ssi);
					sid = searchData.split(";");
					if (ssi.contains(sid[0]) == true || ssi.contains(sid[1]) == true) {
						login.Log4j.info(arg1 + " window is appeared ");
						Thread.sleep(2000);
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
					} else {
						Assert.fail(arg1 + " window is not appeared ");
						Thread.sleep(1000);
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
					}
				}

			} else if (arg1.equals("View as Chart")) {
				login.driver.findElement(By.xpath("//span[@title='" + arg1 + "']")).click();
				CommonFunctionality.SeriesHormonizationWindowClose();
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("VisualTitle_txt"))).isDisplayed()) {
					login.Log4j.info("Chart visual is created for " + arg1 + " right click option");
					CommonFunctionality.Views_list();
					/*
					 * try { Thread.sleep(1000);
					 * login.driver.findElement(By.xpath("//button[contains(text(),'Refresh')]")).
					 * click(); }catch(Exception e) { // }
					 */
					
				} else {
					Assert.fail("Chart visual is not created");
				}

			} else if (arg1.equals("View as Map")) {
				login.driver.findElement(By.xpath("//span[@title='" + arg1 + "']")).click();
				CommonFunctionality
				.getElementByXpath(login.driver, "//ul[@class='dropdown-menu']//li//*[@title='China']", 15)
				.click();
				CommonFunctionality.SeriesHormonizationWindowClose();
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("VisualTitle_txt"))).isDisplayed()) {
					login.Log4j.info("Map visual is created " + arg1 + " right click option");
					CommonFunctionality.Views_list();
					
				} else {
					Assert.fail("Map visual is not created");
				}

			} else if (arg1.equals("View as Table")) {
				login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();
			//	Thread.sleep(3000);
				CommonFunctionality.SeriesHormonizationWindowClose();
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("table_title"))).isDisplayed()) {
					login.Log4j.info("Table visual is created for right click option on series level");
					CommonFunctionality.Views_list();
					
				} else {
					Assert.fail("Table visual is not created");
				}
			} else if (arg1.equals("View as Pie")) {
				login.driver.findElement(By.xpath("//span[@title='View as ...']")).click();
				//Thread.sleep(3000);
				login.driver.findElement(By.xpath("//span[@title='Pie']")).click();
				CommonFunctionality.SeriesHormonizationWindowClose();
				if (login.driver.findElement(By.xpath("//div[@class='text-dots']")).isDisplayed()) {
					login.Log4j.info(arg1 + " visual is created for right click option on series level");
					CommonFunctionality.Views_list();
					
				} else {
					Assert.fail(arg1 + " visual is not created");
				}
			} else if (arg1.equals("View as Heat map")) {
				login.driver.findElement(By.xpath("//span[@title='View as ...']")).click();
				//Thread.sleep(3000);
				login.driver.findElement(By.xpath("//span[@title='Heat map']")).click();
				if (login.driver.findElement(By.xpath("//div[@class='text-dots']")).isDisplayed()) {
					login.Log4j.info(arg1 + " visual is created for right click option on series level");
					CommonFunctionality.Views_list();
					
				} else {
					Assert.fail(arg1 + " visual is not created");
				}
			} else if (arg1.equals("View as Histogram")) {
				login.driver.findElement(By.xpath("//span[@title='View as ...']")).click();
				//Thread.sleep(3000);
				login.driver.findElement(By.xpath("//span[@title='Histogram']")).click();
				if (login.driver.findElement(By.xpath("//div[@class='text-dots']")).isDisplayed()) {
					login.Log4j.info(arg1 + " visual is created for right click option on series level");
					CommonFunctionality.Views_list();
					
				} else {
					Assert.fail(arg1 + " visual is not created");
				}
			} else if (arg1.equals("Download")) {
				login.driver.findElement(By.xpath("//span[@title='" + arg1 + "']")).click();
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Downloadicon"))).isDisplayed()) {
					Thread.sleep(3000);
					login.Log4j.info("Download window is appeared for right click option on series level " + arg1);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Downloadclose"))).click();
				} else {
					Assert.fail("Download window is not appeared");
				}
			} else if (arg1.equals("Footnotes")) {
				login.driver.findElement(By.xpath("//span[@title='" + arg1 + "']")).click();
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("footnotes_title"))).isDisplayed()) {
					login.Log4j.info("Footnotes window is appeared");
					Thread.sleep(2000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("close_footnotes"))).click();
				} else {
					Assert.fail("Footnotes window is not appeared");
				}
			} else if (arg1.equals("Copy link(s)")) {
				WebElement copylink =login.driver.findElement(By.xpath("//span[@title='" + arg1 + "']"));
				copylink.click();
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("copylink_popup"))).isDisplayed()) {
					login.Log4j.info("URL link(s) is copied");
					Thread.sleep(2000);
					robot = new Robot();
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_T);
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_T);
					Thread.sleep(2000);
					// Store all currently open tabs in tabs
					ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
					// Navigate to New Tab
					login.driver.switchTo().window(tabs2.get(1));
					robot.keyPress(KeyEvent.VK_RIGHT);
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyRelease(KeyEvent.VK_RIGHT);
					robot.keyRelease(KeyEvent.VK_SHIFT);
					Thread.sleep(2000);
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_V);
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_V);
					Thread.sleep(2000);
					robot.keyPress(KeyEvent.VK_ENTER);
					String url = login.driver.getCurrentUrl();
					robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(5000);
					WebElement ssp = null;
					try {
						ssp = login.driver.findElement(By.xpath("//span[contains(text(),'" + SeriesNames + "')]"));
						if (ssp.isDisplayed()) {
							login.Log4j.info("SSP window is displayed for Copy link(s) option");
							Thread.sleep(2000);
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
						} else {
							Assert.fail("SSP window is not displayed for Copy link(s) option");
						}
					} catch (Exception e) {
						String[] seriesId = searchData.split(";");
						for (String str : seriesId) {
							if (url.contains(str) == true) {
								login.Log4j.info(
										"Selected links are copied" + " OR " + str + " exists in current url \n" + url);
							} else {
								login.Log4j.info("Selected links are not copied");
							}
						}
					}
					login.driver.close();
					login.driver.switchTo().window(tabs2.get(0));

				} else {
					Assert.fail("URL link(s) is not copied");
				}
			} else if (arg1.equals("Show Dataset")) {
				login.driver.findElement(By.xpath("//span[@title='" + arg1 + "']")).click();
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Backbutton"))).isDisplayed()) {
					login.Log4j.info("Dataset is displayed for given SeriesID");
					Thread.sleep(2000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Backbutton"))).click();

				} else {
					Assert.fail("Dataset is not displayed for given SeriesID");
				}
			} else if (arg1.equals("Show Database")) {
				login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();

				if (login.driver.findElement(By.xpath("//div[contains(text(),'" + SeriesNames + "')]")).isDisplayed()) {
					Thread.sleep(1000);
					login.driver.findElement(By.xpath("//div[contains(text(),'" + SeriesNames + "')]")).click();
					if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Related_Data"))).isDisplayed()) {
						Thread.sleep(1000);
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Related_Data"))).click();
						List<WebElement> datasets = login.driver
								.findElements(By.xpath(login.LOCATORS.getProperty("Related_Data_text")));
						for (WebElement list : datasets) {
							Filters.showdata = list.getText();
							login.Log4j.info("Database is displayed for selected series");
							Thread.sleep(1000);
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
						}
					} else {
						login.Log4j.info("Database is not displayed  for selected series");
					}
				}
			}
		} catch (Exception e) {

		}
	}
	
	@SuppressWarnings("deprecation")
	@When("^Click on Show Series Info icon$")
	public void click_on_Show_Series_Info_icon() throws Throwable {
	  //	WebElement ele;
		login.Log4j.info("Clicking on  Series tab ");
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		ul_element = null;
		try {
			Thread.sleep(2000);
			ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
			AssertJUnit.assertNotNull(ul_element);
			List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
			login.Log4j.info("List size is :" + li_All.size());
			List<WebElement> sName = login.driver.findElements(By.xpath("//li//*[@class='series-item--name']"));
			if (li_All.size() > 0) {
				for (int i = 0; i < li_All.size(); i++) {
					login.Log4j.info(i);
					login.Log4j.info(li_All.size());
					int j = i + 1;
					action.pause(800).moveToElement(sName.get(i)).build().perform();
					CommonFunctionality.wait(500);
					element =login. driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--info-icon-i']"));
					element.click();
					ssp_window_should_be_displayed();
					jse.executeScript("arguments[0].scrollIntoView(true);", sName.get(i));
				}
				
			} else {
				Assert.fail("Sorry,No results were found ");
			}

		} catch (NoSuchElementException e) {
			Assert.fail("WebElement is null " + e.getMessage());
		}
	}

	@Then("^SSP window should be displayed$")
	public void ssp_window_should_be_displayed() throws Throwable {

		try {
			if (login.driver.findElement(By.xpath("//div[@class='series-preview-modal-header--title ']//span")).isDisplayed()) {
				login.Log4j.info("SSP window is displayed");
				CommonFunctionality.getElementByProperty(login.driver,"closeAction",4).click();
			} else {
				CommonFunctionality.getElementByProperty(login.driver,"closeAction",4).click();
				Assert.fail("SSP window is not displayed");
			}
		} catch (NoSuchElementException e) {
			// Assert.fail("WebElement is null");
		}
	}
	@And("^Click on \"([^\"]*)\" filter$")
	public void click_on_filter(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'" + arg1 + "')]"))).click();
	}

	@SuppressWarnings("deprecation")
	@When("^Click on \"([^\"]*)\"$")
	public void click_on(String arg1) throws Throwable {
		login.Log4j.info("Clicking on " + arg1);
		switch (arg1) {
		case "All insights":
			login.driver.navigate().refresh();
			// login.driver.getCurrentUrl();
			Thread.sleep(5000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).clear();
			if (login.driver.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]")).isDisplayed()) {
				Thread.sleep(4000);
				login.driver.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]")).click();
				login.Log4j.info("Clicking on " + arg1);
			} else {
				Assert.fail(arg1 + " is not displayed");

			}
			break;
		case "Apply filter":
			CommonFunctionality.getElementByXpath(login.driver,"//*[contains(text(),'" + arg1 + "')]",4).click();
			break;
		case "Copy link(s)":
			CommonFunctionality.getElementByProperty(login.driver,"Copylinks",8).click();
			break;
		case "Copy":
			CommonFunctionality.getElementByXpath(login.driver,"//*[@title='" + arg1 + "']",4).click();
			break;
		case "Footnotes":
			CommonFunctionality.getElementByXpath(login.driver,"//div[@class='items-wrapper']//span[contains(text(),'" + arg1 + "')]",4)
					.click();
			break;
		case "Expand all":
			CommonFunctionality.getElementByXpath(login.driver,"//*[@title='Collapse tree']",10).click();
//			CommonFunctionality.getElementByXpath(login.driver,
//					"//*[@class='database-representation--state-actions']/*[2]//*[contains(text(),'" + arg1 + "')]",4)
//					.click();
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@title='Expand tree']",8)
					.click();
			break;
		case "Collapse all":
			CommonFunctionality.getElementByProperty(login.driver, "Databases_Tab", 15).click();
			login.Log4j.info("Clicking on Matches only");
			CommonFunctionality.getElementByXpath(login.driver,"//*[contains(text(),'Matches only')]",12).click();
//			CommonFunctionality.getElementByXpath(login.driver,"//*[contains(text(),'" + arg1 + "')]",6).click();
			CommonFunctionality.getElementByXpath(login.driver,"//*[@title='Collapse tree']",10).click();
			break;
		case "See our Search help":
			CommonFunctionality.getElementByXpath(login.driver,"//li[contains(text(), '" + arg1 + "')]",8).click();
			break;
		case "our help desk team":
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(login.LOCATORS.getProperty("Series")))).click();
			CommonFunctionality.getElementByXpath(login.driver,"//*[contains(text(),'" + arg1 + "')]",4).click();
			break;
		case "Unselect":
			Thread.sleep(2000);
			if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TopButton"))).isDisplayed()) {
				CommonFunctionality.getElementByProperty(login.driver,"TopButton",4).click();
			}
			CommonFunctionality.UnselectMethod();
			break;

		case "Add":
			
			CommonFunctionality.getElementByXpath(login.driver,
					"//div[@class='items-wrapper']//li[1]//span[contains(text(),'" + arg1 + "')]", 15).click();
			// login.driver.findElement(By.xpath("//div[@class='items-wrapper']//li[1]//span[@title='Add
			// series (A)']")).click();
			break;

		case "Add and replace":
			CommonFunctionality.getElementByXpath(login.driver,"//*[contains(text(),'" + arg1 + "')]",10).click();
			break;
		case "Add and group":
			CommonFunctionality.getElementByXpath(login.driver,"//*[contains(text(),'" + arg1 + "')]",4).click();
			break;
		case "Add to new insight":
			CommonFunctionality.getElementByXpath(login.driver,"//*[contains(text(),'" + arg1 + "')]",4).click();
			break;
		case "Add to recent insight":
			CommonFunctionality.getElementByXpath(login.driver,"//*[contains(text(),'" + arg1 + "')]",4).click();
			break;
		case "Open":
			Thread.sleep(2000);
			try {
				// login.Log4j.info("Clicking on Refresh ");
				// login.driver.findElement(By.xpath("//button[contains(text(),'Refresh')]")).click();
				CommonFunctionality.getElementByXpath(login.driver,
						"//div[@class='insights-search-modal-header-btns']//span[contains(text(),'" + arg1 + "')]",4)
						.click();

			} catch (Exception e) {
				CommonFunctionality.getElementByXpath(login.driver,"//div[@class='modal-icon-button']//span[contains(text(),'" + arg1 + "')]",4)
						.click();
			}

			break;
		case "×":
			CommonFunctionality.getElementByXpath(login.driver,
							"//div[@class='modal-header sphere-modal__header']//div[contains(text(),'" + arg1 + "')]",4)
					.click();
			break;
		case "Cancel":
			Thread.sleep(2000);
			if (login.driver.findElement(By.xpath("//*[@class='sphere-modal-controls']//*[contains(text(),'" + arg1 + "')]")).isDisplayed()) {
				CommonFunctionality.getElementByXpath(login.driver,"//*[@class='sphere-modal-controls']//*[contains(text(),'" + arg1 + "')]",4).click();
				login.Log4j.info("Confirmation popup is closed");
			} else {
				Assert.fail("Confirmation popup is not closed");
			}
			break;
		case "Ok":
			CommonFunctionality.wait(500);
			CommonFunctionality.getElementByXpath(login.driver,"//*[@class='sphere-modal-controls']//button[contains(text(),'" + arg1 + "')]",6).click();
			break;
		case "Show related data":
//			Thread.sleep(2000);
			try {
				// It executes when list size is 1[tc _ @SeriesTab_77]
				element = CommonFunctionality.getElementByXpath(login.driver,"//div[@class='series-item--name']",6);
				str1 = element.getText();
			} catch (Exception e) {

			}
			element = login.driver.findElement(By.xpath("//div[@class='series-item--country country-information']"));
			action.pause(500).moveToElement(element).click().build().perform();
			Thread.sleep(1500);
			element = login.driver.findElement(By.xpath("//*[@title='" + arg1 + "']"));
			action.pause(1000).moveToElement(element).click().build().perform();
			break;
		case "Hide related data":
			Thread.sleep(2000);
			element = login.driver.findElement(By.xpath("//*[@title='" + arg1 + "']"));
			action.pause(1000).moveToElement(element).click().build().perform();
			break;
		case "Read More":
			Thread.sleep(4000);
			CommonFunctionality.getElementByXpath(login.driver,"//*[contains(text(),'" + arg1 + "')]",10).click();
			break;
		case "View as Chart. Type `c`":
			// Thread.sleep(3000);
			// element=login.driver.findElement(By.xpath("//li[1]//span[@class='series-item-information--additional-info-field
			// series-item-information--additional-info-field__dates']"));
			// action.moveToElement(element).build().perform();
			CommonFunctionality.getElementByXpath(login.driver,"//li[1]//span[@title='" + arg1 + "']",10).click();
			break;
		case "More actions":
			CommonFunctionality.getElementByXpath(login.driver,"//li[5]//span[@title='" + arg1 + "']",10).click();
			break;
		case "Unselect all":
			CommonFunctionality.getElementByXpath(login.driver,"//*[contains(text(),'" + arg1 + "')]",10).click();
			break;
		case "Add to insights":
			CommonFunctionality.getElementByXpath(login.driver,"//button[contains(text(),'" + arg1 + "')]",10).click();
			break;
		case "Databases":
			CommonFunctionality.getElementByProperty(login.driver,"DatabasesTab_Active",15).click();
			break;
		case "Download":
			try {
				//download button in page
			   CommonFunctionality.getElementByXpath(login.driver,
					"//button[contains(@class,'button__download-btn')]//*[contains(text(),'" + arg1 + "')]",15)
					.click();
			} catch(Exception e) {
				//download button in download popup
				  CommonFunctionality.getElementByXpath(login.driver,
							"(//button[contains(@class,'button__download-btn')])[3]//*[contains(text(),'" + arg1 + "')]",15)
							.click();
			  }
			break;
		case "Search without any filters":
			CommonFunctionality.getElementByXpath(login.driver,"//*[contains(text(),'" + arg1 + "')]",15).click();
			break;
		case "Go to new insight":
			CommonFunctionality.getElementByXpath(login.driver,"//*[@class='growl-message-nav--button']//a",15).click();
			break;
		case "delete":
			login.driver.switchTo().defaultContent();
			CommonFunctionality.getElementByXpath(login.driver,"//*[@data-action='" + arg1 + "']",10).click();
				break;
		case "Table properties":
			CommonFunctionality.getElementByXpath(login.driver,"//*[contains(text(),'" + arg1 + "')]",15).click();
			break;
		case "Delete table":
			CommonFunctionality.getElementByXpath(login.driver,"//*[contains(text(),'" + arg1 + "')]",15).click();
			break;
		case "Cell":
			CommonFunctionality.getElementByXpath(login.driver,"//*[contains(@class,'mce-menu-item-expand')]//*[contains(text(),'" + arg1 + "')]",15).click();
			break;
		case "Cell properties":
			CommonFunctionality.getElementByXpath(login.driver,"//*[contains(text(),'" + arg1 + "')]",15).click();
			break;
		case "Merge cells":
			CommonFunctionality.getElementByXpath(login.driver,"//*[contains(text(),'" + arg1 + "')]",15).click();
			break;
		case "Split cell":
			CommonFunctionality.getElementByXpath(login.driver,"//*[contains(text(),'" + arg1 + "')]",15).click();
			break;
		case "Row":
			CommonFunctionality.getElementByXpath(login.driver,"//*[contains(@class,'mce-menu-item-expand')]//*[contains(text(),'" + arg1 + "')]",15).click();
			break;
		case "Column":
			CommonFunctionality.getElementByXpath(login.driver,"//*[contains(@class,'mce-menu-item-expand')]//*[contains(text(),'" + arg1 + "')]",15).click();
			break;
		case "Bullet list":
			 CommonFunctionality.getElementByXpath(login.driver, "//*[@aria-label='" + arg1 + "']", 15).click();
			 break;
		case "Numbered list":
			 CommonFunctionality.getElementByXpath(login.driver, "//*[@aria-label='" + arg1 + "']", 15).click();
			 break;
		case "Increase indent":
			login.driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "a");
			login.driver.switchTo().defaultContent();
			 CommonFunctionality.getElementByXpath(login.driver, "//*[@aria-label='" + arg1 + "']", 15).click();
			 break;
		case "Bold":
			login.driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "a");
			login.driver.switchTo().defaultContent();
			 CommonFunctionality.getElementByXpath(login.driver, "//*[@aria-label='" + arg1 + "']", 15).click();
			 break;
		case "Italic":
			login.driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "a");
			login.driver.switchTo().defaultContent();
			 CommonFunctionality.getElementByXpath(login.driver, "//*[@aria-label='" + arg1 + "']", 15).click();
			 break;
		case "Upload image":
			 CommonFunctionality.getElementByXpath(login.driver, "//*[@aria-label='" + arg1 + "']", 15).click();
			 break;
		case "Insert Commentary":
			CommonFunctionality.wait(500);
			CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg1 + "']", 20).click();
			try {
				Boolean CommentaryTitle = login.driver.findElement(By.xpath("//*[@data-name='title']")).isDisplayed();
				if(CommentaryTitle == true) {
					login.Log4j.info("Attachments visual is created");
				}
			} catch(Exception e) {
				CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg1 + "']", 20).click();
			}
			 break;
		case "+ Add from My Series":
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='link']", 6).click();
			break;
		case "Add from My Series":
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 5).click();
			break;
		case "Replace All":
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='find-and-replace--panel-buttons']//*[contains(text(),'" + arg1 + "')]", 5).click();
			break;
		case "Apply":
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 8).click();
			break;
		case "Frequency":
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='visual-series-list']//*[contains(text(),'" + arg1 + "')]", 8).click();
			break;
		case "Apply function":
			CommonFunctionality.wait(1000);
			ele = login.driver.findElement(By.xpath("//*[@class='series-functions series-functions__has-functions-to-apply']//*[@class='series-functions-panel--icon series-functions-panel--icon__apply']"));
			CommonFunctionality.wait(500);
			jse.executeScript("arguments[0].scrollIntoView(true);", ele);
			//CommonFunctionality.wait(500);
			ele.click();
			break;
		case "Edit Histogram":
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 8).click();
			break;
		case "Advanced settings":
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 8).click();
			break;
		case "Open advanced settings popup":
			CommonFunctionality.getElementByXpath(login.driver, "//div[@class='style-container--controls']//div[2]//div[3]//div[@title='" + arg1 + "']", 8).click();
			break;
		case "All Region":
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'" + arg1 + "')]"))).click();
			break;
		case "Save":
			CommonFunctionality.wait(1500);
			CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'" + arg1 + "')]", 20).click();
			break;
		default:
			CommonFunctionality.getElementByXpath(login.driver,"//*[contains(text(),'" + arg1 + "')]",4).click();
		}
	}

	@Then("^The \"([^\"]*)\" popup should be appeared$")
	public void the_popup_should_be_appeared(String arg1) throws Throwable {
		switch (arg1) {
		case "Insight Explorer":
			if (login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).isDisplayed()) {
				login.Log4j.info(arg1 + " popup is appeared");
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Downloadclose"))).click();
			} else {
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Downloadclose"))).click();
				Assert.fail(arg1 + " popup is not appeared");
			}
			break;
		case "Selected series added to insights:":
			/*Thread.sleep(800);
			WebElement ele =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("second_insight")));
			ele.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_to_insights"))).click();*/
			Thread.sleep(1000);
			element = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("growl_message_popup")));
			String confirm_msg = element.getText();
			String[] confirmarr = confirm_msg.split("\n");
			login.Log4j.info(confirmarr[0]);
			Assert.assertEquals(confirmarr[0], arg1);
			login.Log4j.info(confirmarr[0] + " is displayed");
			CommonFunctionality.DeleteSeries();
			break;
		case "Titles":
			if (CommonFunctionality.getElementByClassName(login.driver, "popover--title", 4).isDisplayed()) {
				login.Log4j.info("Title popup is displayed");
			} else {
				Assert.fail("Title popUp is not displayed");
			}
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
			CommonFunctionality.Views_list();
			break;
		default:
		}
	}

	@And("^Select indicator \"([^\"]*)\" as \"([^\"]*)\"$")
	public void select_indicator_as(String arg1, String arg2) throws Throwable {
		indicator.add(arg2);
		if (refresh == false) {
			CommonFunctionality.Create_New_Insight();
			CommonFunctionality.ResetMethod();
			refresh = true;
		}
		login.Log4j.info("indicator size is " + indicator.size());
		login.Log4j.info(indicator);
		Thread.sleep(2000);
		List<WebElement> crossIcon = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("frieghtTraffic_crossIcon")));
		login.Log4j.info("obj size is " + crossIcon.size());
		if (crossIcon.size() > 0) {
			login.Log4j.info("Selecting indicator " + arg1 + " as " + arg2);
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//*[@class='filter-list categories-list']//*[contains(text(),'" + arg1 + "')]")).click();
			login.driver.findElement(By.xpath("//*[@class='filters-category--children']//*[contains(text(),'" + arg2 + "')]")).click();
		} else {
			CommonFunctionality.getElementByProperty(login.driver,"indicator_filter",5).click();
			login.Log4j.info("Selecting indicator " + arg1 + " as " + arg2);
			Thread.sleep(5000);
			ele = login.driver.findElement(By.xpath("//*[@class='filter-list categories-list']//*[contains(text(),'" + arg1 + "')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);",ele);
			ele.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//*[@class='filters-category--children']//*[contains(text(),'" + arg2 + "')]")).click();
		}
	}

	@Then("^Result should be displayed as per selection$")
	public void result_should_be_displayed_as_per_selection() throws Throwable {
		WebElement tooltip;
		login.Log4j.info("Clicking on  Series tab ");
		CommonFunctionality.getElementByProperty(login.driver,"Series",4).click();
		ul_element = null;
		try {
			Thread.sleep(3000);
			ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
			AssertJUnit.assertNotNull(ul_element);
			List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
			login.Log4j.info("List size is :" + li_All.size());
			if (li_All.size() > 0) {
				for (int i = 0; i < li_All.size(); i++) {
					login.Log4j.info(i);
					login.Log4j.info(li_All.size());
					Thread.sleep(2000);
					int j = i + 1;
//					checkbox = login.driver
//							.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
//					CommonFunctionality.action.moveToElement(checkbox).click().build().perform();
//					Thread.sleep(1000);
					element = login.driver.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
					action.moveToElement(element).build().perform();
					Thread.sleep(500);
					tooltip = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text")));
					text = tooltip.getText();
					// Until the element is not visible keep scrolling
					jse.executeScript("arguments[0].scrollIntoView(true);", element);
					String[] linesplit = text.split("\n");

					for (String str : linesplit) {
						if (str.contains("Indicator")) {
							if (indicator.size() == 2) {
								// login.Log4j.info(indicator.get(0));
								// login.Log4j.info(indicator.get(1));
								// login.Log4j.info(str);
								if (str.toUpperCase().contains((indicator.get(0)).toUpperCase()) == true) {
									login.Log4j.info(indicator.get(0) + " does exists in " + str);
								} else if (str.toUpperCase().contains((indicator.get(1)).toUpperCase()) == true) {
									login.Log4j.info(indicator.get(1) + " does exists in " + str);
								} else {
									Assert.fail(indicator.get(0) + " OR " + indicator.get(1) + " does not exists in "
											+ str);
								}
							}
						}
					}
				}
			} else {
				Assert.fail("Sorry,No results were found ");
			}
		} catch (NoSuchElementException e) {
			Assert.fail("WebElement is null " + e.getMessage());

		}
	}

	@Then("^Series count should be matched with displayed result$")
	public void series_count_should_be_matched_with_displayed_result() throws Throwable {
		int i = 0;
		Thread.sleep(3000);
		element =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("series_count")));
		String Count = element.getText();
		login.Log4j.info("Count is " + Count);
		String newStr = Count.replaceAll(",", "");
		int SeriesCount = Integer.parseInt(newStr);
		login.Log4j.info("Series Count is " + SeriesCount);
		if (SeriesCount > i) {
			// Integer seriesCount=Integer.valueOf(Count);
			login.Log4j.info("Series Count is displayed");
		} else {
			Assert.fail("Series Count is Zero");
		}
	}

	@Then("^Selected options should be reset to default$")
	public void selected_options_should_be_reset_to_default() throws Throwable {
		// login.Log4j.info(Filters.var);
		Thread.sleep(2000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("selected_filter"))).size() == 0) {
			login.Log4j.info("Selected option got Reset");
		} else {
			Assert.fail("Selected option doesn't get Reset");
		}
	}

	@Then("^User can select \"([^\"]*)\" as \"([^\"]*)\"$")
	public void user_can_select_as(String arg1, String arg2) throws Throwable {

		if (login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).isDisplayed()) {
			WebElement ele = login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]"));
			action.moveToElement(ele).build().perform();
			login.Log4j.info("Selecting " + arg2);
			Thread.sleep(2000);
			login.driver
					.findElement(By.xpath(
							"//li[@class='dropdown-submenu active-menu-item']//b[contains(text(),'" + arg2 + "')]"))
					.click();
			login.Log4j.info(SeriesNames);
			if (login.driver.findElement(By.xpath("//div[contains(text(),'" + SeriesNames + "')]")).isDisplayed()) {
				Thread.sleep(2000);
				login.driver.findElement(By.xpath("//div[contains(text(),'" + SeriesNames + "')]")).click();
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Related_Data"))).isDisplayed()) {
					Thread.sleep(1000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Related_Data"))).click();
					List<WebElement> datasets = login.driver
							.findElements(By.xpath(login.LOCATORS.getProperty("Related_Data_text")));
					for (WebElement list : datasets) {
						Filters.showdata = list.getText();

						if (Filters.showdata.toUpperCase().contains(arg2.toUpperCase()) == true) {
							login.Log4j.info("The selected " + arg1 + " as " + arg2 + " does exists in DATASETS");
							Thread.sleep(1000);
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();

						} else {
							Assert.fail("The selected " + arg1 + " as " + arg2 + " does not exists in DATASETS");
							Thread.sleep(1000);
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();

						}
					}
				}
			}
		}
	}

	@And("^User has selects \"([^\"]*)\" as \"([^\"]*)\"$")
	public void user_has_selects_as(String arg1, String arg2) throws Throwable {
		filter = arg2;
		login.Log4j.info("clicking on " + arg1);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='dropdown-search-filter']//*[contains(text(),'" + arg1 + "')]")))
				.click();
		login.Log4j.info("Selecting " + arg2 + " filter");
		CommonFunctionality.wait(2000);
		
		List<WebElement> MoreFilters = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//*[@class='filter-list']//*[@class='filter-item']//*[@class='text-dots']")));
		login.Log4j.info("Size :"+ MoreFilters.size());
		for (int i = 0; i < MoreFilters.size(); i++) {
			CommonFunctionality.wait(2000);
			WebElement ele = MoreFilters.get(i);
			String MorefilterTxt = ele.getText();
			login.Log4j.info(MorefilterTxt);
//			login.Log4j.info(arg2);
			if (MorefilterTxt.contains(arg2)) {
				CommonFunctionality.wait(1000);
				jse.executeScript("arguments[0].scrollIntoView(true);", ele);
				ele.click();
				break;
			}
		}
	}

	@Then("^\"([^\"]*)\" should be displayed$")
	public void should_be_displayed(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("new series")) {
			login.Log4j.info("Clicking on  Series tab ");
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
			ul_element = null;
			try {
				CommonFunctionality.wait(5000);
				ul_element = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.cssSelector(login.LOCATORS.getProperty("UL"))));
				AssertJUnit.assertNotNull(ul_element);
				List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
				login.Log4j.info("List size is :" + li_All.size());
				if (li_All.size() > 0) {
					for (int i = 0; i < li_All.size(); i++) {
						login.Log4j.info(i);
						login.Log4j.info(li_All.size());
						Thread.sleep(2500);
						int j = i + 1;
						/*
						 * checkbox = login.driver .findElement(By.xpath("//li[" + j +
						 * "]//div[@class='series-list-item--checkbox-wrapper']"));
						 * CommonFunctionality.action.moveToElement(checkbox).click().build().perform();
						 * Thread.sleep(1000);
						 */
						element = login.driver
								.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
						action.moveToElement(element).build().perform();
						Thread.sleep(1000);
						WebElement tooltip = login.driver
								.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text")));
						String TooltipInfo = tooltip.getText();
						// Until the element is not visible keep scrolling
						jse.executeScript("arguments[0].scrollIntoView(true);", element);

						if (TooltipInfo.contains(arg1)) {
							login.Log4j.info(arg1 + "  are exists");
						} else {
							Assert.fail(arg1 + "  doesnot exists");
						}
					}
				}
			} catch (Exception e) {
				Assert.fail(e.getMessage());
			}
		} else if (arg1.equalsIgnoreCase("Row properties")) {
			CommonFunctionality.wait(1200);
			if (login.driver
					.findElement(By.xpath("(//div[@role='application']//*[contains(text(),'" + arg1 + "')])[2]"))
					.isDisplayed()) {
				login.Log4j.info(arg1 + " popUp is displayed");
			}
		} else if (arg1.equals("Tooltip")) {
			CommonFunctionality.wait(600);
			String Tooltip_popup = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='popover--title']", 10).getText();
			if(Tooltip_popup.equals(arg1)) {
				login.Log4j.info(arg1+ " popup is displayed");
			} else {
				Assert.fail(arg1 + " popup is not displayed");
			}
			 CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
			CommonFunctionality.Views_list();

		}

	}

	@Then("^User verify corresponding results for selected filter$")
	public void user_verify_corresponding_results_for_selected_filter() throws Throwable {
		CommonFunctionality.wait(1500);
		login.Log4j.info("Clicking on  Series tab ");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		ul_element = null;
		try {
			CommonFunctionality.wait(2000);
			ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
			AssertJUnit.assertNotNull(ul_element);
			List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
			List<WebElement> statusIcon = ul_element.findElements(By.xpath("//li//*[@class='series-item--status-icons']//*[@class='status-icon status-icon__has-forecast']"));
			login.Log4j.info("List size is :" + li_All.size());
			if (li_All.size() > 0) {
				for (int i = 0; i < li_All.size(); i++) {
					login.Log4j.info(i);
					login.Log4j.info(li_All.size());
					Thread.sleep(2000);
					int j = i + 1;
					/*checkbox = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
					CommonFunctionality.action.moveToElement(checkbox).click().build().perform();
					Thread.sleep(1000);*/
					element = login.driver.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
					
					if (filter.equalsIgnoreCase("With release schedule")) {
						Thread.sleep(1000);
						element.click();
						if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("with_Release")))
								.isDisplayed()) {
							login.Log4j.info(filter + " series are exists");
							CommonFunctionality.getElementByProperty(login.driver, "closeAction",4).click();
						} else {
							CommonFunctionality.getElementByProperty(login.driver, "closeAction",4).click();
							Assert.fail(filter + " series doesnot exists");
						}
					} else if (filter.equalsIgnoreCase("Forecast")) {
						String Status_icon = statusIcon.get(i).getText();
						if(Status_icon.equalsIgnoreCase("F")) {
							login.Log4j.info("Forecast series are displayed");
						} else {
							Assert.fail("Forecast series are not displayed");
						}
						Thread.sleep(700);
						element.click();
						Thread.sleep(1500);
						WebElement timepoints = login.driver
								.findElement(By.xpath(login.LOCATORS.getProperty("forecast_timepoints")));
						String Orange = "rgb(255, 165, 0)";
						String appOrange = timepoints.getCssValue("fill");
						// String appOrange =timepoints.getAttribute("fill");
						login.Log4j.info(appOrange);

						if (Orange.equals(appOrange)) {
							login.Log4j.info(filter + " series are exists");
							Thread.sleep(700);
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();

						} else {
							Thread.sleep(700);
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
							Assert.fail(filter + " series doesnot exists");
						}

					} else {
						Thread.sleep(2000);
						element.click();
						String SearchTxt = login.driver.findElement(By.xpath("//div[contains(@class,'series-changes-time-line--status series')]")).getText();
						if (SearchTxt.equals("Rebased") || SearchTxt.equals("Discontinued")) {
							login.Log4j.info(filter + " are exists");
							CommonFunctionality.getElementByProperty(login.driver, "closeAction",4).click();
						} else {
							CommonFunctionality.getElementByProperty(login.driver, "closeAction",4).click();
							Assert.fail(filter + " doesnot exists");
						}
					}
					// Until the element is not visible keep scrolling
					jse.executeScript("arguments[0].scrollIntoView(true);", element);
				}
				try {
					//TC22
					//Remove Popularity
					CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='custom-select-title--reset icon--red-cross'])[1]", 4).click();
				} catch (Exception e) {
					
				}

			} else {
				Assert.fail("Sorry,No results were found ");
			}

		} catch (NoSuchElementException e) {
			Assert.fail("WebElement is null " + e.getMessage());
		}
	}

	@SuppressWarnings("deprecation")
	@When("^User Mouse hover on \"([^\"]*)\" icon$")
	public void user_Mouse_hover_on_icon(String arg1) throws Throwable {
		MousehoverIcon = arg1;
		login.Log4j.info("Clicking on  Series tab ");
		CommonFunctionality.getElementByProperty(login.driver , "Series" , 20).click();
		CommonFunctionality.wait(5000);
		element =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Title_of_the_series")));
		stext = element.getText();
		login.Log4j.info(stext);
		CommonFunctionality.wait(2000);
		WebElement ele1 =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("series_item_info")));
		action.pause(500).moveToElement(ele1).build().perform();
		login.Log4j.info("Clicking on " + arg1 + " icon");
		CommonFunctionality.getElementByXpath(login.driver,"//div[@class='series-list-item--action-icons']//span[@title='" + arg1 + "']" ,4)
				.click();
	}

	@Then("^User can selects \"([^\"]*)\"$")
	public void user_can_selects(String arg1) throws Throwable {
		db = arg1;
		Thread.sleep(2000);
		login.Log4j.info(" Clicking on " + arg1);
		login.driver.findElement(By.xpath("//span//b[contains(text(),'" + arg1 + "')]")).click();

	}

	@Then("^User can see the selected database in Databases tab$")
	public void user_can_see_the_selected_database_in_Databases_tab() throws Throwable {
		login.Log4j.info(db);
		login.Log4j.info(Filters.searchData);
		if (db.equals("null")) {

			if (Filters.searchData.equals("400841827")) {
				dbase =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("markit_purchasing_db")));
			} else if (Filters.searchData.equals("122834404")) {
				dbase = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OECD-MainEconomic_db")));
			} else if (Filters.searchData.equals("377030917")) {
				dbase = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OECD_EconomicOutlook")));
			} else if (Filters.searchData.equals("295755902")) {
				dbase =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OECD_productivity")));
			}

		} else if (db.equals("Global Database")) {
			dbase = login.driver.findElement(By.xpath("//div[@class='title']//span[contains(text(),'" + db + "')]"));

		} else {
			dbase =login.driver.findElement(By.xpath("//span[@class='name']//span[contains(text(),'" + db + "')]"));

		}
		Thread.sleep(5000);
		// Until the element is not visible keep scrolling
		jse.executeScript("arguments[0].scrollIntoView(true);", dbase);
		String txt = dbase.getText();
		login.Log4j.info(txt);
		if (txt.equals(db)) {
			login.Log4j.info(db + " is displayed for " + MousehoverIcon + " icon when mouse hovered");

		} else if (txt.equals("Markit Purchasing Managers' Index")) {
			login.Log4j.info(txt + " is displayed for " + MousehoverIcon + " icon when mouse hovered");

		} else if (txt.equals("OECD - Main Economic Indicators")) {
			login.Log4j.info(txt + " is displayed for " + MousehoverIcon + " icon when mouse hovered");
		} else if (txt.equals("OECD - Economic Outlook")) {
			login.Log4j.info(txt + " is displayed for " + MousehoverIcon + " icon when mouse hovered");
		} else if (txt.equals("OECD - Productivity")) {
			login.Log4j.info(txt + " is displayed for " + MousehoverIcon + " icon when mouse hovered");
		} else {
			Assert.fail(db + " is not displayed for " + MousehoverIcon + " icon");
		}
		if (Filters.searchData.equals("295755902")) {
			CommonFunctionality.ExpandLeft();
			
	    }
		CommonFunctionality.UnselectMethod();
	}

	@Then("^User can see the Chart Visual in the right pannel$")
	public void user_can_see_the_Chart_Visual_in_the_right_pannel() throws Throwable {
		CommonFunctionality.ChartSuggestionPopUp();
		CommonFunctionality.SeriesHormonizationWindowClose();
		Thread.sleep(3000);
		WebElement ctitle = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Chart_title")));
		String ctext = ctitle.getText();
		login.Log4j.info(stext);
		login.Log4j.info(ctext);
		if (stext.equals(ctext)) {
			login.Log4j.info("Chart visual is created for Mouse hover icon");
		} else {
			Assert.fail("Chart visual is not created for Mouse hover icon");
		}
		CommonFunctionality.Views_list();
	}

	@Then("^Footnotes window should be open$")
	public void footnotes_window_should_be_open() throws Throwable {
		Thread.sleep(2000);
		WebElement ele =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("footnotes_title")));
		String ftext = ele.getText();
		login.Log4j.info(ftext);
		if (ftext.contains(stext) == true) {
			login.Log4j.info("Footnotes window is appeared for series level when mouse hovered");
			CommonFunctionality.getElementByProperty(login.driver, "close_footnotes",4).click();

		} else {
			CommonFunctionality.getElementByProperty(login.driver, "close_footnotes",4).click();
			Assert.fail("Footnotes window is not appeared");
		}
	}

@And("^Create any visual$")
public void create_any_visual() throws Throwable {
	login.Log4j.info("Clicking on  Series tab ");
	CommonFunctionality.getElementByProperty(login.driver, "Series" ,20).click();
	CommonFunctionality.wait(1000);
	WebElement ele = login.driver.findElement(By.xpath("//li[1]//*[@class='series-item--name']"));
	new Actions(login.driver).contextClick(ele).perform();
	CommonFunctionality.getElementByXpath(login.driver,"//*[contains(text(),'View as Chart')]",10).click();
}
	@SuppressWarnings("deprecation")
	@And("^Click on drop down icon next to \\+$")
	public void click_on_drop_down_icon_next_to() throws Throwable {
		WebElement addSeries_dropdown;
		int j = 0;
		login.Log4j.info("Clicking on  Series tab ");
		CommonFunctionality.getElementByProperty(login.driver, "Series" ,20).click();
		try {
			// highliting visual for add and replace function after refresh
			CommonFunctionality.getElementByXpath(login.driver,"//div[@class='visual-item-wrapper']",10).click();
		} catch (Exception e) {
		}
		Thread.sleep(2000);
		WebElement ul_element = null;
		try {
			ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
			AssertJUnit.assertNotNull(ul_element);
			List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
			login.Log4j.info("List size is :" + li_All.size());
			List<WebElement> sName = login.driver.findElements(By.xpath("//li//*[@class='series-item--name']"));
			if (li_All.size() > 0) {
				for (int i = 0; i < li_All.size(); i++) {
					j = i + 1;
					CommonFunctionality.wait(700);
					SeriesNames = sName.get(i).getText();
					login.Log4j.info(SeriesNames);
					Copy.add(SeriesNames);
					CommonFunctionality.wait(200);
					checkbox = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
					checkbox.click();
					
					if(j == li_All.size()) {
						action.pause(300).moveToElement(sName.get(i)).build().perform();
						CommonFunctionality.wait(500);
						addSeries_dropdown = login.driver
								.findElement(By.xpath("//li[" + j + "]//div[@class='add-to-data-selection--toggle']"));
						addSeries_dropdown.click();
					}
				}
			} else {
				Assert.fail("Sorry,No results were found ");
			}

			/*Thread.sleep(2000);
			addSeries_dropdown = login.driver
					.findElement(By.xpath("//li[" + j + "]//div[@class='add-to-data-selection--toggle']"));
			action.moveToElement(addSeries_dropdown).click().build().perform();*/
		} catch (NoSuchElementException e) {
			Assert.fail("WebElement is null " + e.getMessage());
		}
	}

	@When("^User Mouse hover on Add series icon$")
	public void user_Mouse_hover_on_Add_series_icon() throws Throwable {
		WebElement mouseHoverElement;
		int j = 0;
		login.Log4j.info("Clicking on  Series tab ");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		Thread.sleep(1000);
		WebElement ul_element = null;
		try {
			ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
			AssertJUnit.assertNotNull(ul_element);
			List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
			login.Log4j.info("List size is :" + li_All.size());
			if (li_All.size() > 0) {
				for (int i = 0; i < li_All.size(); i++) {
					Thread.sleep(1500);
					j = i + 1;
					checkbox = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
				action.moveToElement(checkbox).click().build().perform();
					copiedSeries = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
					SeriesNames = copiedSeries.getText();
					login.Log4j.info(SeriesNames);
					Copy.add(SeriesNames);
					// login.Log4j.info(Copy);
				}
			} else {
				Assert.fail("Sorry,No results were found ");
			}
			mouseHoverElement =login.driver
					.findElement(By.xpath("//li[" + j + "]//div[@class='add-to-data-selection--toggle']"));
			action.moveToElement(mouseHoverElement).click().build().perform();
		} catch (NoSuchElementException e) {
			Assert.fail("WebElement is null " + e.getMessage());
		}
	}

	/*
	 * @And("^Apply \"([^\"]*)\"$") public void apply(String arg1) throws Throwable
	 * { Thread.sleep(2000); login.driver.findElement(By.
	 * xpath("//span[@class='context-menu-item link   ']//span[contains(text(),'Add')]"
	 * )) .click(); }
	 */

	@SuppressWarnings("deprecation")
	@When("^Click on \\+ icon on series$")
	public void click_on_icon_on_series() throws Throwable {
		WebElement addIcon;
		int j = 0;
		login.Log4j.info("Clicking on  Series tab ");
		CommonFunctionality.getElementByProperty(login.driver, "Series", 20).click();
		WebElement ul_element = null;
		try {
			Thread.sleep(3000);
			ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
			AssertJUnit.assertNotNull(ul_element);
			List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
			login.Log4j.info("List size is :" + li_All.size());
			List<WebElement> sName = login.driver.findElements(By.xpath("//li//*[@class='series-item--name']"));
			if (li_All.size() > 0) {
				for (int i = 0; i < li_All.size(); i++) {
					j = i + 1;
					CommonFunctionality.wait(1000);
					SeriesNames = sName.get(i).getText();
					Copy.add(SeriesNames);
					login.Log4j.info(SeriesNames);
					checkbox = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
					checkbox.click();							
					if(j == li_All.size()) {
						action.pause(300).moveToElement(sName.get(i)).build().perform();
						CommonFunctionality.wait(800);
						addIcon = login.driver.findElement(By.xpath("//li[" + j + "]//div[@class='add-to-data-selection--icon']"));
						Thread.sleep(800);
						addIcon.click();
					}
				}
			} else {
				Assert.fail("Sorry,No results were found ");
			}
			/*login.Log4j.info(j);
			Thread.sleep(3000);
			addIcon = login.driver.findElement(By.xpath("//li[" + j + "]//div[@class='add-to-data-selection--icon']"));
			Thread.sleep(1000);
			addIcon.click();*/
		} catch (NoSuchElementException e) {
			Assert.fail("WebElement is null " + e.getMessage());
		}
	}

	@Then("^The series should be added to Data tab$")
	public void the_series_should_be_added_to_Data_tab() throws Throwable {
		Thread.sleep(2000);
		List<WebElement> ele = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Series_Name")));
		for (int i = 0; i < ele.size(); i++) {
			CommonFunctionality.wait(1000);
			WebElement element = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_Name")));
			String sname = element.getText();
			if (Copy.contains(sname) == true) {
				login.Log4j.info("The selected series are added to the series tab");
			} else {
				Assert.fail("The selected series are not added to the series tab");
			}
		}
		CommonFunctionality.DeleteSeries();
	}

	@Then("^Highlighted visual series should be replaced new series$")
	public void highlighted_visual_series_should_be_replaced_new_series() throws Throwable {
		
		CommonFunctionality.SeriesHormonizationWindowClose();
		Thread.sleep(2000);
		List<WebElement> elements = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("highcharts_legend")));
		if (elements.size() > 0) {
			for (int i = 0; i < elements.size(); i++) {
				// int j = i + 1;
				// ele = login.driver.findElement(By.xpath(
				// "//div[@class='highcharts-legend']//div[" + j +
				// "]//span//div//span[@class='series-edit--title']"));
				String text = elements.get(i).getText();
				login.Log4j.info(text);
				if (Copy.contains(text) == true) {
					login.Log4j.info("Highlighted visual series replaced with new series");

				} else {
					login.Log4j.info("Highlighted visual series not replaced with new series");
				}
			}
		} else {
			Assert.fail("Size is " + elements.size());
		}
		CommonFunctionality.Views_list();	
	}

	@Then("^Choose any existing insights to add this series$")
	public void choose_any_existing_insights_to_add_this_series() throws Throwable {
		login.Log4j.info("Selecting existing insight");
		WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("first_insight")));
		insightName = ele.getText();
		// login.Log4j.info("insight name is" + insightName);
		ele.click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_to_insight"))).click();
	}

	@Then("^The series should be added to selected insight$")
	public void the_series_should_be_added_to_selected_insight() throws Throwable {
		WebElement ele;
		confirmPopup = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("confirm_popup")));
		if (confirmPopup.isDisplayed()) {
			Thread.sleep(1000);
			String str = confirmPopup.getText();
			login.Log4j.info("Confirmation message is " + str);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("confirm_popup_highlighted_insight"))).click();
			login.robot = new Robot();
			// Store all currently open tabs in tabs
			ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
			// Navigate to New Tab
			login.driver.switchTo().window(tabs2.get(1));
			CommonFunctionality.ContinueSameInsight();
			Thread.sleep(5000);
			List<WebElement> series = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("list_of_series")));
			login.Log4j.info("Size of the list is :" + series.size());
			for (int i = 0; i < series.size(); i++) {
				int j = i + 1;
				Thread.sleep(1000);
				ele = login.driver.findElement(By.xpath("//div[@class='webix_column list-series-name webix_last']/div["
						+ j + "]/div/div/div/span[1]/span"));
				String str1 = ele.getText();
				// Series.add(str1);
				if (Copy.contains(str1) == true) {
					login.Log4j.info("The selected series are added to the existing insight");
				} else {
					Assert.fail("The selected series are not added to the existing insight");
				}
			}
			CommonFunctionality.DeleteSeries();
			login.driver.close();
			login.driver.switchTo().window(tabs2.get(0));

		} else {
			Assert.fail("Confirmation notification is not displayed with insight name(link)");
		}
	}

	@Then("^New insight should be created and the series should be added to the insight$")
	public void new_insight_should_be_created_and_the_series_should_be_added_to_the_insight() throws Throwable {
		Thread.sleep(7000);
		WebElement ele;
		confirmPopup = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("confirm_popup")));
		if (confirmPopup.isDisplayed()) {
			login.Log4j.info("Confirmation notification is displayed with 'Go to new insight' link");
			login.Log4j.info("Clicking on Go to new insight");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("confirm_popup_new_insight"))).click();
			login.robot = new Robot();
			// Store all currently open tabs in tabs
			ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
			// Navigate to New Tab
			login.driver.switchTo().window(tabs2.get(1));
			Thread.sleep(3000);
			List<WebElement> series = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("list_of_series")));
			login.Log4j.info("Size o the list is :" + series.size());
			for (int i = 0; i < series.size(); i++) {
				int j = i + 1;
				Thread.sleep(1000);
				ele = login.driver.findElement(By.xpath("//div[@class='webix_column list-series-name webix_last']/div["
						+ j + "]/div/div/div/span[1]/span"));
				String str = ele.getText();
				login.Log4j.info(str);
				if (Copy.contains(str) == true) {
					login.Log4j.info("The selected series are added to the new insight");
				} else {
					Assert.fail("The selected series are not added to the new insight");
				}
			}
			CommonFunctionality.DeleteSeries();
			login.driver.close();
			login.driver.switchTo().window(tabs2.get(0));
		} else {
			Assert.fail("Confirmation notification is not displayed with 'Go to new Insight name(link)'");
		}
	}

	@Then("^Verify the selected series count$")
	public void verify_the_selected_series_count() throws Throwable {
		login.Log4j.info("Clicking on  Series tab ");
		CommonFunctionality.getElementByProperty(login.driver, "Series" , 4).click();
		Thread.sleep(3000);
		ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
		login.Log4j.info("List size is :" + li_All.size());
		int list = li_All.size();
		if (li_All.size() > 0) {
			for (int i = 0; i < li_All.size(); i++) {
				CommonFunctionality.wait(700);
				int j = i + 1;
				WebElement checkbox = login.driver
						.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
				checkbox.click();
			}
			CommonFunctionality.wait(2000);
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_selection")));
			String count = ele.getText();
			int SeriesCount = Integer.parseInt(count);
			login.Log4j.info("Selected series count is :" + SeriesCount);
			if (list == SeriesCount) {
				login.Log4j.info("Selected series count is shown correctly");
				CommonFunctionality.UnselectMethod();
			} else {
				Assert.fail("Selected series count is not shown correctly");
			}
			
		}
	}
	@And("^Click on any filter$")
	public void click_on_any_filter() throws Throwable {
		CommonFunctionality.ExpandRight();
	   Thread.sleep(1500);
	   login.driver.findElement(By.xpath("//*[contains(text(),'Frequency')]")).click();
	}
	
	/*@When("^Hover the mouse on any filter and click on Pin$")
	public void hover_the_mouse_on_any_filter_and_click_on_Pin() throws Throwable {
		login.Log4j.info("Clicking on Pin");
		element = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("filter_by_indicator")));
		Thread.sleep(2000);
		action.moveToElement(element).click().build().perform();
	}*/

	@Then("^filter should be pined/unpined the filter to left panel$")
	public void filter_should_be_pined_unpined_the_filter_to_left_panel() throws Throwable {
		
		if (CommonFunctionality.getElementByProperty(login.driver,"unpin",4).isDisplayed()) {
			login.Log4j.info("Filter is pinned to left");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unpin"))).click();
			login.Log4j.info("Clicking on Unpin");
		} else {
			Assert.fail("Filter is not pinned");
		}
	}

	@And("^Open \"([^\"]*)\" tab$")
	public void open_tab(String arg1) throws Throwable {
		 login.driver.navigate().refresh();
		//CommonFunctionality.TopMethod();
		try {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(
					"//div[@class='dropdown--button']//div[@class='icon--red-cross database-selector--clear-icon']"))
					.click();
		} catch (Exception e) {

		}
		CommonFunctionality.ExpandRight();
		CommonFunctionality.ResetMethod();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).clear();
	//		WebElement ClearSearchInput = login.driver
//				.findElement(By.xpath(login.LOCATORS.getProperty("Clear_Search_Input")));
//		CommonFunctionality.action.moveToElement(ClearSearchInput).click().build().perform();
		login.Log4j.info("Clicking on  Series tab ");
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
	}

	@Then("^\"([^\"]*)\" symbol to be displayed for \"([^\"]*)\"$")
	public void symbol_to_be_displayed_for(String arg1, String arg2) throws Throwable {
		Thread.sleep(3000);
		ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
		login.Log4j.info("List size is :" + li_All.size());

		if (li_All.size() > 0) {
			for (int i = 0; i < li_All.size(); i++) {
				Thread.sleep(1500);
				int j = i + 1;
				WebElement checkbox = login.driver
						.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
				checkbox.click();
				Thread.sleep(500);
				element = login.driver.findElement(By.xpath("//li[" + j
						+ "]//div[@class='series-item--status-icons']//span[contains(text(),'" + arg1 + "')]"));
				String strLabel = element.getText();
				// Until the element is not visible keep scrolling
				jse.executeScript("arguments[0].scrollIntoView(true);", checkbox);
				login.Log4j.info(strLabel);
				if (strLabel.equalsIgnoreCase(arg1)) {
					login.Log4j.info(arg1 + " is displayed for " + arg2);
				} else {
					Assert.fail(arg1 + " is not displayed for " + arg2);
				}
			}
		}
	}

	@Then("^Search results should include series only from world trend plus DB$")
	public void search_results_should_include_series_only_from_world_trend_plus_DB() throws Throwable {
		WebElement ele;
		login.Log4j.info("Clicking on  Series tab ");
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		ul_element = null;
		try {
			Thread.sleep(2000);
			ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
			AssertJUnit.assertNotNull(ul_element);
			List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
			login.Log4j.info("List size is :" + li_All.size());
			if (li_All.size() > 0) {
				for (int i = 0; i < li_All.size(); i++) {
					login.Log4j.info(i);
					login.Log4j.info(li_All.size());
					int j = i + 1;
					Thread.sleep(3000);
					ele = login.driver.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
					action.moveToElement(ele).build().perform();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
							"//li[" + j + "]//*[@title='Open footnote']")))
							.click();
					Thread.sleep(1200);
					element = login.driver.findElement(By.xpath("//div[@class='footnotes-bread-crumbs']//div[@class='footnotes-bread-crumb'][1]"));
					str1 = element.getText();
					// login.Log4j.info(str1);
					// login.Log4j.info(Filters.Alldb_db);
					// Until the element is not visible keep scrolling
					jse.executeScript("arguments[0].scrollIntoView(true);", ele);

					if (Filters.Alldb_db.equals(str1)) {
						login.Log4j.info("Search results displayed from World Trend Plus db");
						Thread.sleep(1000);
						login.driver.findElement(By.xpath(
								"//div[@class='movable-modal movable-modal__draggable movable-modal__active']//div[@title='Close']"))
								.click();
						
					} else {
						Thread.sleep(1000);
						login.driver.findElement(By.xpath(
								"//div[@class='movable-modal movable-modal__draggable movable-modal__active']//div[@title='Close']"))
								.click();
						Assert.fail("Search results not displayed from World Trend Plus db");
					}
				}
			} else {
				Assert.fail("Sorry,No results were found ");
			}

		} catch (NoSuchElementException e) {
			Assert.fail("WebElement is null " + e.getMessage());
		}
	}

	@And("^Click on open icon of All insight$")
	public void click_on_open_icon_of_All_insight() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//div[@class='insights-search-count--open-icon']")).click();
		login.Log4j.info("Clicking on open icon of All insight");
	}

	@And("^Click on cogwheel$")
	public void click_on_cogwheel() throws Throwable {
		Thread.sleep(10000);
		login.driver.findElement(By.className("search-presentation-tabs--drop-down-title")).click();
		login.Log4j.info("Clicking on cog wheel");
	}

	@Then("^\"([^\"]*)\" popup should be display$")
	public void popup_should_be_display(String arg1) throws Throwable {
		Thread.sleep(3000);
		element = login.driver.findElement(By.xpath("//h4[contains(text(),'" + arg1 + "')]"));
		str1 = element.getText();
		if (str1.equals(arg1)) {
			login.Log4j.info(arg1 + " popup is displayed");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		} else {
			Assert.fail(arg1 + " popup is not displayed");
		}
	}

	@And("^Enter keyword \"([^\"]*)\"$")
	public void enter_keyword(String arg1) throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).clear();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys(arg1);
	}

	@And("^Click on x Matched Insights hyperlink$")
	public void click_on_x_Matched_Insights_hyperlink() throws Throwable {
		Thread.sleep(3000);
		element = login.driver.findElement(By.xpath("//span[@class='insights-search-count--count']"));
		str1 = element.getText();
		matched_insightsCount = Integer.parseInt(str1);
		login.Log4j.info(matched_insightsCount);
		login.driver.findElement(By.xpath("//div[@class='insights-search-count--message']")).click();
	}

	@Then("^Insights explorer modal window should open with x number of insights listed$")
	public void insights_explorer_modal_window_should_open_with_x_number_of_insights_listed() throws Throwable {
		Thread.sleep(3000);
		element = login.driver.findElement(
				By.xpath("//div[@class='insights-groups']//div[6]//span[@class='insights-group-item--count']"));
		str2 = element.getText();
		login.Log4j.info(str2);
		str1 = str2.replaceAll("\\(", "").replaceAll("\\)", "");
		int insightsCount = Integer.parseInt(str1);
		login.Log4j.info(insightsCount);
		if (matched_insightsCount == insightsCount) {
			login.Log4j.info("Insights explorer modal window opened with " + insightsCount + " number of insights");
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		} else {
			Assert.fail("Insights explorer modal window not opened with " + insightsCount + " number of insights");
		}
	}

	@And("^Select series$")
	public void select_series() throws Throwable {
		Thread.sleep(3000);
		login.Log4j.info("Clicking on  Series tab ");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
		login.Log4j.info("List size is :" + li_All.size());
		for (int i = 0; i < li_All.size(); i++) {
			Thread.sleep(1500);
			int j = i + 1;
			checkbox = login.driver
					.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
			checkbox.click();
		}
	}

	@Then("^\"([^\"]*)\" window should be appeared for selected series$")
	public void window_should_be_appeared_for_selected_series(String arg1) throws Throwable {
		Thread.sleep(3000);
		element = login.driver.findElement(By.xpath("//div[@class='download-modal-title']"));
		str2 = element.getText();
		if (str2.contains(arg1)) {
			login.Log4j.info(arg1 + " window is appeared ");
			Thread.sleep(1500);
			login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		} else {
			Assert.fail(arg1 + " window is not appeared ");
		}
	}

	
	@And("^Select series and Click on More actions$")
	public void select_series_and_Click_on_More_actions() throws Throwable {
		Thread.sleep(3000);
		login.Log4j.info("Clicking on  Series tab ");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
		login.Log4j.info("List size is :" + li_All.size());
		for (int i = 0; i < li_All.size(); i++) {
			Thread.sleep(2000);
			int j = i + 1;
			checkbox = login.driver
					.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
			checkbox.click();
			copiedSeries = login.driver.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
			SeriesNames = copiedSeries.getText();
			login.Log4j.info(SeriesNames);
			Copy.add(SeriesNames);

			if (i == 1 || i == 0 && li_All.size() == 1 ) {
				ele = login.driver.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
//				element = login.driver.findElement(By.xpath("//li[" + j + "]//div[@class='series-item-information']"));
//				CommonFunctionality.action.moveToElement(element).pause(1000).build().perform();
				Thread.sleep(700);
				login.driver.findElement(By.xpath("//li[" + j + "]//span[@title='More actions']")).click();
			}
		}
	}

	@Then("^Footnotes should be opened for selected series$")
	public void footnotes_should_be_opened_for_selected_series() throws Throwable {
		WebElement footnoteTitle = login.driver.findElement(By.className("footnotes-modal--name"));
		Thread.sleep(2000);
		String str = footnoteTitle.getText();
		login.Log4j.info(str);
		String Validationstr = ele.getText();
		login.Log4j.info(Validationstr);
		if (str.contains(Validationstr) == true) {
			login.Log4j.info("Footnotes is displayed for selected series ");
			Thread.sleep(1500);
			login.driver.findElement(By.className("movable-modal--close")).click();
		} else {
			Thread.sleep(1000);
			login.driver.findElement(By.className("movable-modal--close")).click();
			Assert.fail("Footnotes is not displayed for selected series ");
		}
	}

	@Then("^Navigate to the series from db tab$")
	public void navigate_to_the_series_from_db_tab() throws Throwable {
		Thread.sleep(5000);
		CommonFunctionality.TopMethod();
		WebElement collapse_all = login.driver.findElement(By.xpath("//*[@title='Collapse tree']//*[@class='database-representation--link-text']"));
		CommonFunctionality.jse.executeScript("arguments[0].scrollIntoView(true);", collapse_all);
		Thread.sleep(2000);
		str1 = collapse_all.getText();
		if (str1.equals("Collapse all")) {
			login.Log4j.info("Series tab is navigated to the db tab");
		} else {
			Assert.fail("Series tab is not navigated to the db tab");
		}
	}

	@Then("^Series should be pasted in excel as refreshable links$")
	public void series_should_be_pasted_in_excel_as_refreshable_links() throws Throwable {

		PasteIntoExcel(Copy);

	}

	@And("^Scroll down and set showing results as \"([^\"]*)\" per page$")
	public void scroll_down_and_set_showing_results_as_per_page(String arg1) throws Throwable {
//		login.driver.navigate().refresh();
//		Thread.sleep(5000);
//		WebElement SearchIcon = login.driver
//				.findElement(By.xpath("//div[@class='search-input-field--item search-input-button']"));
//		action.moveToElement(SearchIcon).build().perform();
		
//   	    WebElement ClearSearchInput = login.driver
//  				.findElement(By.xpath(login.LOCATORS.getProperty("Clear_Search_Input")));
//   	    ClearSearchInput.click();
//		action.moveToElement(ClearSearchInput).click().build().perform();
		//login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).clear();
		Thread.sleep(3000);
		login.Log4j.info("Clicking on  Series tab ");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		Thread.sleep(3000);
		element = login.driver.findElement(By.xpath("//div[@class='search-series-pagination-count']//select"));
	    jse.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		element.click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//*[@value='" + arg1 + "']")).click();
	}

	@Then("^\"([^\"]*)\" results should display in a page$")
	public void results_should_display_in_a_page(String arg1) throws Throwable {
		Thread.sleep(3000);
		int SeriesCount = Integer.parseInt(arg1);
		ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
		login.Log4j.info("List size is :" + li_All.size());
		
		if(li_All.size() == SeriesCount) {
			login.Log4j.info(arg1 + " series are displayed as per the selection");
			Thread.sleep(2000);
			element = login.driver.findElement(By.className("search-series-pagination-count"));
			element.click();
			Thread.sleep(1500);
			login.driver.findElement(By.xpath("//*[@value='20']")).click();
		}
		else {
			Assert.fail(arg1 + " series are not displayed as per the selection");
		}
			
		/*if (li_All.size() > 0) {
			for (int i = 0; i < li_All.size(); i++) {
				Thread.sleep(2000);
				int j = i + 1;
				WebElement checkbox = login.driver
						.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
				checkbox.click();
				jse.executeScript("arguments[0].scrollIntoView(true);", checkbox);
			}

			Thread.sleep(2000);
			WebElement ele = login.driver.findElement(By.xpath("//span[@class='search-input--selected-count']"));
			String count = ele.getText();
			int SeriesCount = Integer.parseInt(count);
			int resultsPer_page = Integer.parseInt(arg1);
			login.Log4j.info("Selected series count is :" + SeriesCount);
			if (resultsPer_page == SeriesCount) {
				login.Log4j.info(arg1 + " series are displayed as per the selection");

			} else {
				Assert.fail(arg1 + " series are not displayed as per the selection");
			}*/
			/*Thread.sleep(2000);
			element = login.driver.findElement(By.xpath("//div[@class='search-series-pagination-count']"));
			element.click();
			Thread.sleep(1500);
			login.driver.findElement(By.xpath("//*[@value='20']")).click();*/
		}

	@And("^Click on Series tab$")
	public void click_on_Series_tab() throws Throwable {
		Thread.sleep(2000);
		login.Log4j.info("Clicking on  Series tab ");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
	}

	@Then("^\"([^\"]*)\" and \"([^\"]*)\" should be available$")
	public void and_should_be_available(String arg1, String arg2) throws Throwable {
		String[] strArr = arg1.split(",");
		Thread.sleep(3000);
		element = login.driver.findElement(By.xpath("//div[@class='related-series-data--content']"));
		str1 = element.getText();
		if (str1.contains(strArr[0]) && str1.contains(strArr[1]) && str1.contains(arg2)) {
			login.Log4j
					.info(strArr[0] + " ," + strArr[1] + " and " + arg2 + " displayed for show related data dropdown ");

		} else {
			Assert.fail("Show related data dropdown is not expanded");

		}
		login.driver.findElement(By.xpath("//*[@class='expand-series-control expand-series-control__open']")).click();
	}

	@Then("^Status has to be \"([^\"]*)\"$")
	public void status_has_to_be(String arg1) throws Throwable {
		Thread.sleep(3000);
		if (login.driver.findElement(By.xpath("//div[contains(text(),'" + arg1 + "')]")).isDisplayed()) {
			login.Log4j.info("Status is " + arg1);
		} else {
			Assert.fail("Status is not " + arg1);
		}
		login.driver.findElement(By.xpath("//*[@class='expand-series-control expand-series-control__open']")).click();
	}
	

	@Then("^Read more should open footnotes of the respective series$")
	public void read_more_should_open_footnotes_of_the_respective_series() throws Throwable {
		Thread.sleep(5000);
		ele = login.driver.findElement(By.className("footnotes-modal--title"));
		String footnote_title = ele.getText();
		if (footnote_title.contains(str1)) {
			login.Log4j.info("Footnote is opened");
			CommonFunctionality.getElementByClassName(login.driver,"movable-modal--close",12).click();
		} else {
			AssertJUnit.fail("Footnote is not opened");
		}
		CommonFunctionality.getElementByXpath(login.driver,"//*[@class='expand-series-control expand-series-control__open']",10).click();
	}

	@Then("^Respective dataset to be opened when click on each datasets link$")
	public void respective_dataset_to_be_opened_when_click_on_each_datasets_link() throws Throwable {
		int i;
		Thread.sleep(3000);
		List<WebElement> dataset_links = login.driver.findElements(By.xpath(
				"//div[@class='related-series-information-portlet'][1]//div[@class='related-series-information-portlet--container']//li"));
		login.Log4j.info("DATASETS link size: " + dataset_links.size());
		for (i = 0; i < dataset_links.size(); i++) {
			int j = i + 1;
			Thread.sleep(4000);
			login.driver.findElement(By.xpath(
					"//div[@class='related-series-information-portlet'][1]//div[@class='related-series-information-portlet--container']//li["
							+ j + "]/div[@class='series-data-set--title']"))
					.click();
			
			if (login.driver.findElement(By.xpath("//div[@class='insight-discovery--popup-back-button']"))
					.isDisplayed()) {
				Thread.sleep(2000);
				login.driver.findElement(By.xpath("//div[@class='insight-discovery--popup-back-button']")).click();

			}
		}
		if (dataset_links.size() == i) {
			login.driver.findElement(By.xpath("//*[@class='expand-series-control expand-series-control__open']")).click();
			login.Log4j.info("Respective dataset is opened when click on each datasets link");
		} else {
			Assert.fail("Respective dataset is not opened when click on each datasets link");
		}
	}

	@And("^Clear search input$")
	public void clear_search_input() throws Throwable {
		//login.driver.navigate().refresh();
		//CommonFunctionality.ExpandRight();
		CommonFunctionality.ResetMethod();
		
	}

	@Then("^Verify the search results$")
	public void verify_the_search_results() throws Throwable {
		login.Log4j.info("Clicking on  Series tab ");
		CommonFunctionality.getElementByProperty(login.driver,"Series",10).click();
		CommonFunctionality.getElementByXpath(login.driver,"//div[@class='series-item--name']",10).click();
		if (Filters.searchData.equals("SR495594")) {
			element = login.driver.findElement(By.xpath("//div[@class='main-series-information--series-id']//div[2]"));
			String SR_code = element.getText();
			if (SR_code.contains(Filters.searchData)) {
				login.Log4j.info(Filters.searchData + " exists in " + SR_code);
				Thread.sleep(1000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
			} else {
				Assert.fail(Filters.searchData + " doesn't exists in " + SR_code);
			}
		} else if (Filters.searchData.equals("CN.GDP.NM.YTD-RMB-BN-Q")) {
			element = login.driver.findElement(By.xpath("//div[@class='main-series-information--series-id']//div[3]"));
			String Mnemonic_code = element.getText();
			if (Mnemonic_code.contains(Filters.searchData)) {
				login.Log4j.info(Filters.searchData + " exists in " + Mnemonic_code);
				Thread.sleep(1000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
			} else {
				Assert.fail(Filters.searchData + " doesn't exists in " + Mnemonic_code);
			}
		}
	}
	@Then("^Should display the rebased series$")
	public void should_display_the_rebased_series() throws Throwable {
		login.Log4j.info("Clicking on  Series tab ");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Series"))))
				.click();
		CommonFunctionality.wait(2000);
		ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		List<WebElement> listOfSeries = ul_element.findElements(By.xpath("//li//div[@class='series-item--name']"));
		login.Log4j.info("List size is :" + listOfSeries.size());
		for (int i = 0; i < listOfSeries.size(); i++) {
			listOfSeries.get(i).click();
			CommonFunctionality.wait(500);
			if (login.driver
					.findElement(
							By.xpath("//*[@class='series-changes-time-line--header']//*[contains(text(),'" + Filters.var + "')]"))
					.isDisplayed()) {
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='movable-modal single-series-preview--modal movable-modal__draggable movable-modal__active']//div[@class='movable-modal--close']", 20).click();
//				wait.until(ExpectedConditions
//						.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("closeAction")))).click();
				login.Log4j.info("Rebased series exists");
			} else {
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='movable-modal single-series-preview--modal movable-modal__draggable movable-modal__active']//div[@class='movable-modal--close']", 20).click();
				Assert.fail("Rebased doesn't exists");
			}
		}
	}
	@And("^Choose \"([^\"]*)\" under \"([^\"]*)\" option$")
	public void choose_under_option(String arg1, String arg2) throws Throwable {
	    CommonFunctionality.getElementByXpath(login.driver, "(//*[contains(text(),'" + arg2 + "')])[1]", 4).click();
	    CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 4).click();
	}

	  void PasteIntoExcel(List<String> string) throws Throwable {
		XSSFSheet sheet;
		XSSFWorkbook wb = new XSSFWorkbook();
		File file = new File(System.getProperty("user.dir") + "\\" + "Sample.xlsx");
		FileOutputStream fileOut = new FileOutputStream(file);

		if (file.exists()) {
			try {
				wb = (XSSFWorkbook) WorkbookFactory.create(file);
			} catch (Exception e) {
				// e.printStackTrace();
			}
			sheet = wb.createSheet("Copy");
		} else {
			wb = new XSSFWorkbook();
			sheet = wb.createSheet("sheet1");
		}
		sheet = wb.getSheet("Copy");
		int rownum = 0;
		int columnCount = 0;
		for (String str : string) {
			Row row = sheet.createRow(rownum++);
			Cell cell = row.createCell(columnCount);
			cell.setCellValue(str);
		}
		int rowcount = sheet.getLastRowNum();
		for (int i = 0; i <= rowcount; i++) {
			String str = sheet.getRow(i).getCell(0).getStringCellValue();
			if (Copy.contains(str)) {
				login.Log4j.info(str + " copied to Excel");
			} else {
				Assert.fail("Selected series are not copied to Excel");
			}
		}
		wb.write(fileOut);
		fileOut.close();
	}

}
