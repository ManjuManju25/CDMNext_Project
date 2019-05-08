package CDMNext.StepDefinations;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.asserts.SoftAssert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SeriesTab {
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
	public WebElement ul_element = null;
	Boolean refresh = false;
	String text;
	List<String> seriesText = null;
	SoftAssert s_assert = new SoftAssert();
	Boolean newInsight = false;
	// create object of Actions class
	Actions action = new Actions(login.driver);
	// create instance of JavaScriptExecutor
	JavascriptExecutor jse = (JavascriptExecutor) login.driver;

	@Given("^User enters seriesID \"([^\"]*)\"$")
	public void user_enters_seriesID(String arg1) throws Throwable {
		DatabasesTab.ResetMethod();
		searchData = arg1;
		login.Log4j.info("Searching with " + searchData);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).clear();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys(searchData);
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unselect"))).isDisplayed()) {
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unselect"))).click();
		}

	}

	@When("^User right click on any series$")
	public void user_right_click_on_any_series() throws Throwable {
		WebElement rightClickElement;
		int j = 0;
		login.Log4j.info("Clicking on  Series tab ");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		ul_element = null;
		try {
			Thread.sleep(3000);
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
			rightClickElement = login.driver.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
			// contextClick() method to do right click on the element
			action.contextClick(rightClickElement).build().perform();
			Thread.sleep(3000);
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
				Thread.sleep(3000);
				login.driver.findElement(By.xpath("//span[@title='" + arg1 + "']")).click();
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("clipboard"))).isDisplayed()) {
					Thread.sleep(2000);
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
				try {
					if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unexpected_popup_close")))
							.isDisplayed()) {
						Thread.sleep(1500);
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unexpected_popup_close")))
								.click();
					}
				} catch (NoSuchElementException e) {

				}
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Chart_title"))).isDisplayed()) {
					login.Log4j.info("Chart visual is created for " + arg1 + " right click option");
					DatabasesTab.DeleteVisual();
					DatabasesTab.DeleteSeries();
				} else {
					Assert.fail("Chart visual is not created");
				}

			} else if (arg1.equals("View as Map")) {
				login.driver.findElement(By.xpath("//span[@title='" + arg1 + "']")).click();
				Thread.sleep(3000);
				try {
					if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unexpected_popup_close")))
							.isDisplayed()) {
						Thread.sleep(1500);
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unexpected_popup_close")))
								.click();
					}
				} catch (NoSuchElementException e) {

				}
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Chart_title"))).isDisplayed()) {
					login.Log4j.info("Map visual is created " + arg1 + " right click option");
					DatabasesTab.DeleteVisual();
					DatabasesTab.DeleteSeries();
				} else {
					Assert.fail("Map visual is not created");
				}

			} else if (arg1.equals("View as Table")) {
				login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();
				Thread.sleep(3000);
				try {
					if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unexpected_popup_close")))
							.isDisplayed()) {
						Thread.sleep(1500);
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unexpected_popup_close")))
								.click();
					}
				} catch (NoSuchElementException e) {

				}

				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("table_title"))).isDisplayed()) {
					login.Log4j.info("Table visual is created for right click option on series level");
					DatabasesTab.DeleteVisual();
					DatabasesTab.DeleteSeries();
				} else {
					Assert.fail("Table visual is not created");
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
				WebElement copylink = login.driver.findElement(By.xpath("//span[@title='" + arg1 + "']"));
				copylink.click();
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("copylink_popup"))).isDisplayed()) {
					login.Log4j.info("URL link(s) is copied");
					Thread.sleep(2000);
					login.robot = new Robot();
					login.robot.keyPress(KeyEvent.VK_CONTROL);
					login.robot.keyPress(KeyEvent.VK_T);
					login.robot.keyRelease(KeyEvent.VK_CONTROL);
					login.robot.keyRelease(KeyEvent.VK_T);
					Thread.sleep(2000);
					// Store all currently open tabs in tabs
					ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
					// Navigate to New Tab
					login.driver.switchTo().window(tabs2.get(1));
					login.robot.keyPress(KeyEvent.VK_RIGHT);
					login.robot.keyPress(KeyEvent.VK_SHIFT);
					login.robot.keyRelease(KeyEvent.VK_RIGHT);
					login.robot.keyRelease(KeyEvent.VK_SHIFT);
					Thread.sleep(2000);
					login.robot.keyPress(KeyEvent.VK_CONTROL);
					login.robot.keyPress(KeyEvent.VK_V);
					login.robot.keyRelease(KeyEvent.VK_CONTROL);
					login.robot.keyRelease(KeyEvent.VK_V);
					Thread.sleep(2000);
					login.robot.keyPress(KeyEvent.VK_ENTER);
					String url = login.driver.getCurrentUrl();
					login.robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(10000);
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
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Backbutton")))
						.isDisplayed()) {
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

	@When("^Click on \\(i\\) icon$")
	public void click_on_i_icon() throws Throwable {
		WebElement ele;
		login.Log4j.info("Clicking on  Series tab ");
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
					sname = ele.getText();
					element = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--info-icon-i']"));
					Thread.sleep(1000);
					action.moveToElement(element).click().build().perform();
					// Until the element is not visible keep scrolling
					//jse.executeScript("arguments[0].scrollIntoView(true);", element);
					ssp_window_should_be_displayed();
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

			if (login.driver.findElement(By.xpath("//div[@class='series-preview--header ui-draggable-handle']//div[@class='single-series-preview--title ']"))
					.isDisplayed()) {
				login.Log4j.info("SSP window is displayed");
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
			} else {
				Assert.fail("SSP window is not displayed");
			}
		} catch (NoSuchElementException e) {
			//Assert.fail("WebElement is null");
		}
	}

	@When("^Click on \"([^\"]*)\"$")
	public void click_on(String arg1) throws Throwable {
		switch (arg1) {
		case "All insights":
			login.driver.navigate().refresh();
			// login.driver.getCurrentUrl();
			Thread.sleep(20000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).clear();
			if (login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).isDisplayed()) {
				Thread.sleep(10000);
				login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();
				login.Log4j.info("Clicking on " + arg1);
			} else {
				Assert.fail(arg1 + " is not displayed");

			}
			break;
		case "Apply filter":
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//div[contains(text(),'" + arg1 + "')]")).click();
			login.Log4j.info("Clicking on " + arg1);
			break;
		case "Copy link(s)":
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copylinks"))).click();
			login.Log4j.info("Clicking on " + arg1);
			break;
		case "Footnotes":
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@class='items-wrapper']//span[contains(text(),'" + arg1 + "')]"))
					.click();
			login.Log4j.info("Clicking on " + arg1);
			break;
		case "Expand":
			 Thread.sleep(5000);
			 login.driver.findElement(By.xpath("//span[contains(text(),'Collapse')]")).click();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();
			login.Log4j.info("Clicking on " + arg1);
			break;
		case "Collapse":
			Thread.sleep(5000);
			login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();
			login.Log4j.info("Clicking on " + arg1);
			break;
		case "See our Search help":
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//li[contains(text(), '" + arg1 + "')]")).click();
			login.Log4j.info("Clicking on " + arg1);
			break;
		case "our help desk team":
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();
			login.Log4j.info("Clicking on " + arg1);
			break;
		case "Unselect":
			Thread.sleep(3000);
			if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TopButton"))).isDisplayed()) {
				Thread.sleep(3000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TopButton"))).click();
				login.Log4j.info("Clicking on Top button");
			}
			if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unselect"))).isDisplayed()) {
				Thread.sleep(4000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unselect"))).click();
				login.Log4j.info("Clicking on Unselect");
			}
			break;

		case "Add":
			login.Log4j.info("Clicking on " + arg1 + " icon ");
			Thread.sleep(2000);
			login.driver
					.findElement(
							By.xpath("//div[@class='items-wrapper']//li[1]//span[contains(text(),'" + arg1 + "')]"))
					.click();
			// login.driver.findElement(By.xpath("//div[@class='items-wrapper']//li[1]//span[@title='Add
			// series (A)']")).click();
			break;

		case "Add and replace":
			Thread.sleep(2000);
			login.Log4j.info("Clicking on " + arg1 + " icon ");
			login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();
			break;
		case "Add and group":
			Thread.sleep(2000);
			login.Log4j.info("Clicking on " + arg1 + " icon ");
			login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();
			break;
		case "Add to new insight":
			Thread.sleep(2000);
			login.Log4j.info("Clicking on " + arg1 + " icon ");
			login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();
			break;
		case "Add to existing insight":
			Thread.sleep(2000);
			login.Log4j.info("Clicking on " + arg1 + " icon ");
			login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();
			break;
		case "Open":
			Thread.sleep(2000);
			try {
				// login.Log4j.info("Clicking on Refresh ");
				// login.driver.findElement(By.xpath("//button[contains(text(),'Refresh')]")).click();
				login.Log4j.info("Clicking on " + arg1 + " icon ");
				Thread.sleep(4000);
				login.driver.findElement(By.xpath(
						"//div[@class='insights-search-modal-header-btns']//span[contains(text(),'" + arg1 + "')]"))
						.click();

			} catch (Exception e) {
				login.Log4j.info("Clicking on " + arg1 + " icon ");
				Thread.sleep(4000);
				login.driver
						.findElement(
								By.xpath("//div[@class='modal-icon-button']//span[contains(text(),'" + arg1 + "')]"))
						.click();
			}

			break;
		case "×":
			login.Log4j.info("Clicking on " + arg1 + " icon ");
			Thread.sleep(3000);
			login.driver
					.findElement(By.xpath(
							"//div[@class='modal-header sphere-modal__header']//div[contains(text(),'" + arg1 + "')]"))
					.click();
			break;
		case "Cancel":
			Thread.sleep(2000);
			login.Log4j.info("Clicking on " + arg1 + " icon ");
			if (login.driver.findElement(By.xpath("//button[contains(text(),'" + arg1 + "')]")).isDisplayed()) {
				Thread.sleep(1000);
				login.driver.findElement(By.xpath("//button[contains(text(),'" + arg1 + "')]")).click();
				login.Log4j.info("Confirmation popup is closed");
			} else {
				Assert.fail("Confirmation popup is not closed");
			}
			break;
		case "Ok":
			Thread.sleep(2000);
			login.Log4j.info("Clicking on " + arg1 + " icon ");
			login.driver.findElement(By.xpath("//button[contains(text(),'" + arg1 + "')]")).click();
			break;
		case "Show related data":
			Thread.sleep(2000);
			element = login.driver.findElement(By.xpath("//div[@class='series-item--country country-information']"));
			action.moveToElement(element).click().build().perform();
			Thread.sleep(2000);
			login.Log4j.info("Clicking on " + arg1 + " icon ");
			element = login.driver.findElement(By.xpath("//div[@title='" + arg1 + "']"));
			Thread.sleep(2000);
			action.moveToElement(element).click().build().perform();
			break;
		case "Hide related data":
			login.Log4j.info("Clicking on " + arg1 + " icon ");
			element = login.driver.findElement(By.xpath("//div[@title='" + arg1 + "']"));
			Thread.sleep(2000);
			action.moveToElement(element).click().build().perform();
			break;
		case "Read More":
			Thread.sleep(4000);
			login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();
			login.Log4j.info("Clicking on " + arg1 + " icon ");
			break;
		case "View as Chart. Type `c`":
			// Thread.sleep(3000);
			// element=login.driver.findElement(By.xpath("//li[1]//span[@class='series-item-information--additional-info-field
			// series-item-information--additional-info-field__dates']"));
			// action.moveToElement(element).build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//li[1]//span[@title='" + arg1 + "']")).click();
			break;
		case "More actions":
			login.Log4j.info("Clicking on " + arg1);
			Thread.sleep(3000);
			login.driver.findElement(By.xpath("//li[5]//span[@title='" + arg1 + "']")).click();
			break;
		case "Unselect all":
			Thread.sleep(3000);
			login.Log4j.info("Clicking on " + arg1);
			login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();
			break;
		case "Add to insights":
			login.Log4j.info("Clicking on " + arg1);
			Thread.sleep(3000);
			login.driver.findElement(By.xpath("//button[contains(text(),'" + arg1 + "')]")).click();
			break;
		case "Databases":
			login.Log4j.info("Clicking on " + arg1);
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("DatabasesTab_Active"))).click();
			break;
		default:
			login.Log4j.info("Clicking on " + arg1);
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();
		}
	}

	@Then("^The \"([^\"]*)\" popup should be appeared$")
	public void the_popup_should_be_appeared(String arg1) throws Throwable {
		switch (arg1) {
		case "Insight Explorer":
			if (login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).isDisplayed()) {
				login.Log4j.info(arg1 + " popup is appeared");
				Thread.sleep(3000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Downloadclose"))).click();
			} else {
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Downloadclose"))).click();
				Assert.fail(arg1 + " popup is not appeared");
			}
			break;
		case "Selected series added to insights:":
			Thread.sleep(2000);
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("first_insight")));
			ele.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_to_insights"))).click();
			Thread.sleep(2000);
			element = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("growl_message_popup")));
			String confirm_msg = element.getText();
			String[] confirmarr = confirm_msg.split("\n");
			login.Log4j.info(confirmarr[0]);
			Assert.assertEquals(confirmarr[0], arg1);
			login.Log4j.info(confirmarr[0] + " is displayed");
			break;
		default:
		}
	}

	@And("^Select indicator \"([^\"]*)\" as \"([^\"]*)\"$")
	public void select_indicator_as(String arg1, String arg2) throws Throwable {
		indicator.add(arg2);
		if (refresh == false) {
			Thread.sleep(3000);
			login.driver.navigate().refresh();
			System.out.println("Refresh :" + login.driver.getCurrentUrl());
			Thread.sleep(5000);
			WebElement ClearSearchInput = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Clear_Search_Input")));
			action.moveToElement(ClearSearchInput).click().build().perform();
			SearchTest.ClearSelection();
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
			Thread.sleep(3000);
			login.driver.findElement(By.xpath("//ul//span[contains(text(),'" + arg1 + "')]")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//tr[@title='" + arg2 + "']")).click();
		} else {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("indicator_filter"))).click();
			login.Log4j.info("Selecting indicator " + arg1 + " as " + arg2);
			Thread.sleep(3000);
			login.driver.findElement(By.xpath("//ul//span[contains(text(),'" + arg1 + "')]")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//tr[@title='" + arg2 + "']")).click();
		}
	}

	@Then("^Result should be displayed as per selection$")
	public void result_should_be_displayed_as_per_selection() throws Throwable {
		WebElement tooltip;
		login.Log4j.info("Clicking on  Series tab ");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		ul_element = null;
		try {
			ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
			AssertJUnit.assertNotNull(ul_element);
			List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
			login.Log4j.info("List size is :" + li_All.size());
			if (li_All.size() > 0) {
				for (int i = 0; i < li_All.size(); i++) {
					login.Log4j.info(i);
					login.Log4j.info(li_All.size());
					Thread.sleep(4000);
					int j = i + 1;
					checkbox = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
					action.moveToElement(checkbox).click().build().perform();
					Thread.sleep(1000);
					element = login.driver.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
					action.moveToElement(element).build().perform();
					Thread.sleep(1000);
					tooltip = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text")));
					// Until the element is not visible keep scrolling
					//in rc.9 it should be uncomment(below line)				
					//jse.executeScript("arguments[0].scrollIntoView(true);", element);
					text = tooltip.getText();
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
		element = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("series_count")));
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
		if (!login.driver.findElement(By.xpath(login.LOCATORS.getProperty("selected_field"))).isDisplayed()) {
			login.Log4j.info("Selected option is get Reset");
		} else {
			Assert.fail("Selected option isn't get Reset");
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
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//span[@title='" + arg1 + "']")).click();
		login.Log4j.info("Selecting " + arg2 + " filter");
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//tr[@title='" + arg2 + "']")).click();

	}

	@Then("^User verify corresponding results for selected filter$")
	public void user_verify_corresponding_results_for_selected_filter() throws Throwable {
		login.Log4j.info("Clicking on  Series tab ");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		ul_element = null;
		try {
			ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
			AssertJUnit.assertNotNull(ul_element);
			List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
			login.Log4j.info("List size is :" + li_All.size());
			if (li_All.size() > 0) {
				for (int i = 0; i < li_All.size(); i++) {
					login.Log4j.info(i);
					login.Log4j.info(li_All.size());
					Thread.sleep(5000);
					int j = i + 1;
					checkbox = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
					action.moveToElement(checkbox).click().build().perform();
					element = login.driver.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
					action.moveToElement(element).build().perform();
					// Until the element is not visible keep scrolling
					//jse.executeScript("arguments[0].scrollIntoView(true);", element);
					if (filter.equalsIgnoreCase("Key only")) {
						if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("key_icon"))).isDisplayed()) {
							login.Log4j.info(filter + " series are exists");
						} else {
							Assert.fail(filter + " series doesnot exists");
						}
					} else if (filter.equalsIgnoreCase("With release schedule")) {
						Thread.sleep(2000);
						element.click();
						if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("with_Release")))
								.isDisplayed()) {
							login.Log4j.info(filter + " series are exists");
							Thread.sleep(2000);
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
						} else {
							Thread.sleep(2000);
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
							Assert.fail(filter + " series doesnot exists");
						}
					} else if (filter.equalsIgnoreCase("Forecast")) {
						Thread.sleep(2000);
						element.click();
						Thread.sleep(2000);
						WebElement timepoints = login.driver
								.findElement(By.xpath(login.LOCATORS.getProperty("forecast_timepoints")));
						String Orange = "rgb(255, 165, 0)";
						String appOrange = timepoints.getCssValue("fill");
						// String appOrange =timepoints.getAttribute("fill");
						login.Log4j.info(appOrange);

						if (Orange.equals(appOrange)) {
							login.Log4j.info(filter + " series are exists");
							Thread.sleep(1500);
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();

						} else {
							Thread.sleep(2000);
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
							Assert.fail(filter + " series doesnot exists");
						}

					} else {
						Thread.sleep(3000);
						element.click();
						if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("with_suggestion")))
								.isDisplayed()) {
							login.Log4j.info(filter + " are exists");
							Thread.sleep(2000);
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
						} else {
							Thread.sleep(2000);
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
							Assert.fail(filter + " doesnot exists");
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

	@When("^User Mouse hover on \"([^\"]*)\" icon$")
	public void user_Mouse_hover_on_icon(String arg1) throws Throwable {
		MousehoverIcon = arg1;
		login.Log4j.info("Clicking on  Series tab ");
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		Thread.sleep(3000);
		element = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Title_of_the_series")));
		stext = element.getText();
		login.Log4j.info(stext);
		Thread.sleep(2000);
		WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("series_item_info")));
		action.moveToElement(ele1).build().perform();
		login.Log4j.info("Clicking on " + arg1 + " icon");
		Thread.sleep(3000);
		login.driver
				.findElement(By.xpath("//div[@class='series-list-item--action-icons']//span[@title='" + arg1 + "']"))
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
				dbase = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("markit_purchasing_db")));
			} else if (Filters.searchData.equals("122834404")) {
				dbase = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OECD-MainEconomic_db")));
			} else if (Filters.searchData.equals("377030917")) {
				dbase = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OECD_EconomicOutlook")));
			} else if (Filters.searchData.equals("295755902")) {
				dbase = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OECD_productivity")));
			}

		} else if (db.equals("Global Database")) {
			dbase = login.driver.findElement(By.xpath("//div[@class='title']//span[contains(text(),'" + db + "')]"));

		} else {
			dbase = login.driver.findElement(By.xpath("//span[@class='name']//span[contains(text(),'" + db + "')]"));

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
		if(Filters.searchData.equals("295755902")) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_left"))).click();
		}
	}

	@Then("^User can see the Chart Visual in the right pannel$")
	public void user_can_see_the_Chart_Visual_in_the_right_pannel() throws Throwable {
        Thread.sleep(5000);
		WebElement ctitle = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Chart_title")));
		String ctext = ctitle.getText();
		login.Log4j.info(stext);
		login.Log4j.info(ctext);
		if (stext.equals(ctext)) {
			login.Log4j.info("Chart visual is created for Mouse hover icon");
		} else {
			Assert.fail("Chart visual is not created for Mouse hover icon");
		}
	}

	@Then("^Footnotes window should be open$")
	public void footnotes_window_should_be_open() throws Throwable {
		WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("footnotes_title")));
		String ftext = ele.getText();
		login.Log4j.info(ftext);
		if (ftext.contains(stext) == true) {
			login.Log4j.info("Footnotes window is appeared for series level when mouse hovered");
			Thread.sleep(1500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("close_footnotes"))).click();

		} else {
			Thread.sleep(1500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("close_footnotes"))).click();
			Assert.fail("Footnotes window is not appeared");
		}
	}

	@And("^Click on drop down icon next to \\+$")
	public void click_on_drop_down_icon_next_to() throws Throwable {
		WebElement addSeries_dropdown;
		int j = 0;
		login.Log4j.info("Clicking on  Series tab ");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		Thread.sleep(3000);
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
					// action.moveToElement(checkbox).click().build().perform();
					checkbox.click();
					copiedSeries = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
					SeriesNames = copiedSeries.getText();
					login.Log4j.info(SeriesNames);
					Copy.add(SeriesNames);
					Thread.sleep(2000);
					// login.Log4j.info(Copy);
				}
			} else {
				Assert.fail("Sorry,No results were found ");
			}

			Thread.sleep(2000);
			addSeries_dropdown = login.driver
					.findElement(By.xpath("//li[" + j + "]//div[@class='add-to-data-selection--toggle']"));
			action.moveToElement(addSeries_dropdown).click().build().perform();
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
			mouseHoverElement = login.driver
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

	@When("^Click on \\+ icon on series$")
	public void click_on_icon_on_series() throws Throwable {
		WebElement addIcon;
		int j = 0;
		login.Log4j.info("Clicking on  Series tab ");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
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
				}
			} else {
				Assert.fail("Sorry,No results were found ");
			}
			login.Log4j.info(j);
			Thread.sleep(3000);
			addIcon = login.driver.findElement(By.xpath("//li[" + j + "]//div[@class='add-to-data-selection--icon']"));
			Thread.sleep(1000);
			addIcon.click();
		} catch (NoSuchElementException e) {
			Assert.fail("WebElement is null " + e.getMessage());
		}
	}

	@Then("^The series should be added to Data tab$")
	public void the_series_should_be_added_to_Data_tab() throws Throwable {
		Thread.sleep(2000);
		List<WebElement> ele = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Series_Name")));
		for (int i = 0; i < ele.size(); i++) {
			WebElement element = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_Name")));
			String sname = element.getText();
			if (Copy.contains(sname) == true) {
				login.Log4j.info("The selected series are added to the series tab");
			} else {
				Assert.fail("The selected series are not added to the series tab");
			}
		}
		DatabasesTab.DeleteSeries();
	}

	@Then("^Highlighted visual series should be replaced new series$")
	public void highlighted_visual_series_should_be_replaced_new_series() throws Throwable {
		WebElement ele;
		try {
			if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unexpected_popup_close")))
					.isDisplayed()) {
				Thread.sleep(1500);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unexpected_popup_close"))).click();
			}
		} catch (NoSuchElementException e) {

		}
		Thread.sleep(2000);
		List<WebElement> elements = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("highcharts_legend")));
		for (int i = 0; i < elements.size(); i++) {
			int j = i + 1;
			ele = login.driver.findElement(By.xpath(
					"//div[@class='highcharts-legend']//div[" + j + "]//span//div//span[@class='series-edit--title']"));
			String text = ele.getText();
			login.Log4j.info(text);
			if (Copy.contains(text) == true) {
				login.Log4j.info("Highlighted visual series replaced with new series");

			} else {
				login.Log4j.info("Highlighted visual series not replaced with new series");
			}
		}
		DatabasesTab.DeleteVisual();
		DatabasesTab.DeleteSeries();
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
			String str = confirmPopup.getText();
			login.Log4j.info("Confirmation message is " + str);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("confirm_popup_untitle_insight"))).click();
			login.robot = new Robot();
			// Store all currently open tabs in tabs
			ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
			// Navigate to New Tab
			login.driver.switchTo().window(tabs2.get(1));
			Thread.sleep(10000);
			List<WebElement> series = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("list_of_series")));
			login.Log4j.info("Size of the list is :" + series.size());
			for (int i = 0; i < series.size(); i++) {
				int j = i + 1;
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
			DatabasesTab.DeleteSeries();
			login.driver.close();
			login.driver.switchTo().window(tabs2.get(0));

		} else {
			Assert.fail("Confirmation notification is not displayed with insight name(link)");
		}
	}

	@Then("^New insight should be created and the series should be added to the insight$")
	public void new_insight_should_be_created_and_the_series_should_be_added_to_the_insight() throws Throwable {
		Thread.sleep(2000);
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
			Thread.sleep(10000);
			List<WebElement> series = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("list_of_series")));
			login.Log4j.info("Size o the list is :" + series.size());
			for (int i = 0; i < series.size(); i++) {
				int j = i + 1;
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
			DatabasesTab.DeleteSeries();
			login.driver.close();
			login.driver.switchTo().window(tabs2.get(0));
		} else {
			Assert.fail("Confirmation notification is not displayed with 'Go to new Insight name(link)'");
		}
	}

	@Then("^Verify the selected series count$")
	public void verify_the_selected_series_count() throws Throwable {
		login.Log4j.info("Clicking on  Series tab ");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		Thread.sleep(3000);
		ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
		login.Log4j.info("List size is :" + li_All.size());
		int list = li_All.size();
		if (li_All.size() > 0) {
			for (int i = 0; i < li_All.size(); i++) {
				Thread.sleep(2000);
				int j = i + 1;
				WebElement checkbox = login.driver
						.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
				checkbox.click();
				// Until the element is not visible keep scrolling
				//jse.executeScript("arguments[0].scrollIntoView(true);", checkbox);
			}
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_selection")));
			String count = ele.getText();
			int SeriesCount = Integer.parseInt(count);
			login.Log4j.info("Selected series count is :" + SeriesCount);
			if (list == SeriesCount) {
				login.Log4j.info("Selected series count is shown correctly");
				
			} else {
				Assert.fail("Selected series count is not shown correctly");
			}
		}
	}

	@When("^Hover the mouse on any filter and click on Pin$")
	public void hover_the_mouse_on_any_filter_and_click_on_Pin() throws Throwable {
		login.Log4j.info("Clicking on Pin");
		element = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("filter_by_indicator")));
		Thread.sleep(2000);
		action.moveToElement(element).click().build().perform();
	}

	@Then("^filter should be pined/unpined the filter to left panel$")
	public void filter_should_be_pined_unpined_the_filter_to_left_panel() throws Throwable {

		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unpin"))).isDisplayed()) {
			login.Log4j.info("Filter is pinned to left");
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unpin"))).click();
			login.Log4j.info("Clicking on Unpin");
		} else {
			Assert.fail("Filter is not pinned");
		}
	}

	public void PasteIntoExcel(List<String> string) throws Throwable {
		XSSFWorkbook wb = new XSSFWorkbook();
		File file = new File(System.getProperty("user.dir") + "\\" + "Sample.xlsx");
		FileOutputStream fileOut = new FileOutputStream(file);

		if (file.exists()) {
			try {
				wb = (XSSFWorkbook) WorkbookFactory.create(file);
			} catch (Exception e) {
				// e.printStackTrace();
			}
			XSSFSheet sheet = wb.createSheet("Copy");
		} else {
			wb = new XSSFWorkbook();
			XSSFSheet sheet = wb.createSheet("sheet1");
		}
		XSSFSheet sheet = wb.getSheet("Copy");
		int rownum = 0;
		int columnCount = 0;
		for (String str : string) {
			Row row = sheet.createRow(rownum++);
			Cell cell = row.createCell(columnCount);
			cell.setCellValue(str);
		}
		str1 = sheet.getRow(0).getCell(0).getStringCellValue();
		str2 = sheet.getRow(1).getCell(0).getStringCellValue();
		if (Copy.contains(str1) == true && Copy.contains(str2) == true) {
			login.Log4j.info("Selected series are copied to Excel");
		} else {
			Assert.fail("Selected series are not copied to Excel");
		}
		wb.write(fileOut);
		fileOut.close();
	}

}
