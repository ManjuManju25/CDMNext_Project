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
	List<String> seriesText = null;
	SoftAssert s_assert = new SoftAssert();
	Boolean newInsight = false;

	@Given("^User enters seriesID \"([^\"]*)\"$")
	public void user_enters_seriesID(String arg1) throws Throwable {

		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unselect"))).isDisplayed()) {
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unselect"))).click();
		}
		searchData = arg1;
		login.Log4j.info("Searching with " + searchData);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).clear();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys(searchData);

	}

	@When("^User right click on any series$")
	public void user_right_click_on_any_series() throws Throwable {
		WebElement rightClickElement;
		WebElement checkbox;
		int j = 0;
		login.Log4j.info("Clicking on  Series tab ");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		Thread.sleep(3000);
		Actions action = new Actions(login.driver);
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
					Thread.sleep(1500);
					j = i + 1;
					checkbox = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
					action.moveToElement(checkbox).click().build().perform();
					copiedSeries = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
					// action.moveToElement(copiedSeries).build().perform();
					SeriesNames = copiedSeries.getText();
					login.Log4j.info(SeriesNames);
					Copy.add(SeriesNames);
					// login.Log4j.info(Copy);

				}
			} else {
				Assert.fail("Sorry,No results were found ");
			}
			rightClickElement = login.driver.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
			// contextClick() method to do right click on the element
			action.contextClick(rightClickElement).build().perform();
		} catch (NoSuchElementException e) {
			Assert.fail("WebElement is null " + e.getMessage());
		}
	}

	@Then("^User can able to see \"([^\"]*)\" option from dropdown menu$")
	public void user_can_able_to_see_option_from_dropdown_menu(String arg1) throws Throwable {
		Thread.sleep(3000);
		WebElement checkbox;
		checkbox = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Checkbox")));
		login.Log4j.info("Clicking on " + arg1);
		try {
			if (arg1.equals("Unselect all")) {
				login.driver.findElement(By.xpath("//span[@title='" + arg1 + "']")).click();
				if (!checkbox.isSelected()) {
					login.Log4j.info("The Selected series are got unselected ");
				} else {
					Assert.fail("The Selected series are not get unselected ");
				}
			} else if (arg1.equalsIgnoreCase("Copy")) {
				login.driver.findElement(By.xpath("//span[@title='" + arg1 + "']")).click();
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("copy_popup_text"))).isDisplayed()) {
					PasteIntoExcel(Copy);
				}
			} else if (arg1.equals("Copy data")) {
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
				Thread.sleep(3000);
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
				Thread.sleep(2000);
				if(login.driver.findElement(By.xpath("//div[@title='Close']")).isDisplayed()) {
					Thread.sleep(1000);
				login.driver.findElement(By.xpath("//div[@title='Close']")).click();
				}
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Chart_title"))).isDisplayed()) {
					login.Log4j.info("Chart visual is created for " + arg1 + " right click option");
				} else {
					Assert.fail("Chart visual is not created");
				}
			} else if (arg1.equals("View as Map")) {
				login.driver.findElement(By.xpath("//span[@title='" + arg1 + "']")).click();
				Thread.sleep(2000);
				if(login.driver.findElement(By.xpath("//div[@title='Close']")).isDisplayed()) {
					Thread.sleep(1000);
				login.driver.findElement(By.xpath("//div[@title='Close']")).click();
				}
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Chart_title"))).isDisplayed()) {
					login.Log4j.info("Map visual is created " + arg1 + " right click option");

				} else {
					Assert.fail("Map visual is not created");
				}

			} else if (arg1.equals("View as Table")) {
				Thread.sleep(2000);
				if(login.driver.findElement(By.xpath("//div[@title='Close']")).isDisplayed()) {
					Thread.sleep(1000);
				login.driver.findElement(By.xpath("//div[@title='Close']")).click();
				}
				login.driver.findElement(By.xpath("//span[@title='" + arg1 + "']")).click();
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("table_title"))).isDisplayed()) {
					login.Log4j.info("Table visual is created for right click option on series level");
				} else {
					Assert.fail("Table visual is not created");
				}
			} else if (arg1.equals("Download")) {
				login.Log4j.info("m in download");
				login.driver.findElement(By.xpath("//span[@title='" + arg1 + "']")).click();
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Downloadicon"))).isDisplayed()) {
					Thread.sleep(2000);
					login.Log4j.info("Download window is appeared for right click option on series level " + arg1);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Downloadclose"))).click();
				} else {
					Assert.fail("Download window is not appeared");
				}
			} else if (arg1.equals("Footnotes")) {
				login.driver.findElement(By.xpath("//span[@title='" + arg1 + "']")).click();
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("footnotes"))).isDisplayed()) {
					login.Log4j.info("Footnotes window is appeared");
					Thread.sleep(1500);
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
					Robot robot = new Robot();
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
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("show_dataset_validateTxt")))
						.isDisplayed()) {
					login.Log4j.info("Dataset is displayed for given SeriesID");
					Thread.sleep(2000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Back_button"))).click();

				} else {
					Assert.fail("Dataset is not displayed for given SeriesID");
				}
			} else if (arg1.equals("Show Database")) {
				login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();
				Thread.sleep(2000);
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
		Thread.sleep(2000);
		WebElement checkbox;
		WebElement element;
		WebElement ele;
		login.Log4j.info("Clicking on  Series tab ");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		Thread.sleep(1000);
		// create instance of JavaScriptExecutor
		JavascriptExecutor jse = (JavascriptExecutor) login.driver;
		// create object of Actions class
		Actions action = new Actions(login.driver);
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
					Thread.sleep(1500);
					int j = i + 1;
					checkbox = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
					action.moveToElement(checkbox).click().build().perform();
					Thread.sleep(1000);
					ele = login.driver.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
					sname = ele.getText();
					element = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--info-icon-i']"));
					action.moveToElement(element).click().build().perform();
					// Until the element is not visible keep scrolling
					jse.executeScript("arguments[0].scrollIntoView(true);", element);
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

			if (login.driver.findElement(By.xpath("//div[@class='table-row']//span[contains(text(),'" + sname + "')]"))
					.isDisplayed()) {
				login.Log4j.info("SSP window is displayed");
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
			} else {
				Assert.fail("SSP window is not displayed");
			}
		} catch (NoSuchElementException e) {

		}
	}

	@When("^Click on \"([^\"]*)\"$")
	public void click_on(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("All insights")) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).clear();
			if (login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).isDisplayed()) {
				Thread.sleep(5000);
				login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();
				login.Log4j.info("Clicking on " + arg1);
			} else {
				Assert.fail(arg1 + " is not displayed");

			}

		} else if (arg1.equals("Apply filter")) {
			login.driver.findElement(By.xpath("//div[contains(text(),'" + arg1 + "')]")).click();
			login.Log4j.info("Clicking on " + arg1);

		} else if (arg1.equals("Copy link(s)")) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();
			login.Log4j.info("Clicking on " + arg1);

		} else if (arg1.equals("Footnotes")) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@class='items-wrapper']//span[contains(text(),'" + arg1 + "')]"))
					.click();
			login.Log4j.info("Clicking on " + arg1);
		} else {
			login.Log4j.info("Clicking on " + arg1);
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();

		}
	}

	@Then("^The \"([^\"]*)\" popup should be appeared$")
	public void the_popup_should_be_appeared(String arg1) throws Throwable {

		if (login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).isDisplayed()) {
			login.Log4j.info(arg1 + " popup is appeared");
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Downloadclose"))).click();
		} else {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Downloadclose"))).click();
			Assert.fail(arg1 + " popup is not appeared");
		}
		//Thread.sleep(2000);
		/*login.driver
				.findElement(
						By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]"))
				.click();*/
	}

	@And("^Select indicator \"([^\"]*)\" as \"([^\"]*)\"$")
	public void select_indicator_as(String arg1, String arg2) throws Throwable {
		indicator.add(arg2);
		login.Log4j.info("indicator size is " + indicator.size());
		login.Log4j.info(indicator);
		/*if (newInsight == false) {
			login.driver.findElement(By.xpath("//span[contains(text(),'File')]")).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//span[contains(text(),'New')]")).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//button[contains(text(),'Create insight')]")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(
					"//div[@class='view-selection']//div[@class='panel-expander--icon panel-expander--icon__left']"))
					.click();
			newInsight = true;
		}*/
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).clear();
		SearchTest.ClearSelection();
		List<WebElement> crossIcon = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("frieghtTraffic_crossIcon")));
		login.Log4j.info("obj size is " + crossIcon.size());
		if (crossIcon.size() > 0) {
			login.Log4j.info("Selecting indicator " + arg1 + " as " + arg2);
			Thread.sleep(3000);
			login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//td[contains(text(),'" + arg2 + "')]")).click();
		} else {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("indicator_filter"))).click();
			login.Log4j.info("Selecting indicator " + arg1 + " as " + arg2);
			Thread.sleep(3000);
			login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//td[contains(text(),'" + arg2 + "')]")).click();
		}

	}

	@Then("^Result should be displayed as per selection$")
	public void result_should_be_displayed_as_per_selection() throws Throwable {
		Thread.sleep(2000);
		WebElement element;
		WebElement checkbox;
		String text;
		WebElement tooltip;

		login.Log4j.info("Clicking on  Series tab ");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		Thread.sleep(5000);
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
					Thread.sleep(1500);
					int j = i + 1;
					checkbox = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
					mouseOver.moveToElement(checkbox).click().build().perform();
					Thread.sleep(1000);
					element = login.driver.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
					mouseOver.moveToElement(element).build().perform();
					Thread.sleep(500);
					tooltip = login.driver.findElement(
							By.xpath("//div[@class='tooltip tooltip__visible']//table[@class='series-tooltip-table']"));
					// Until the element is not visible keep scrolling
					jse.executeScript("arguments[0].scrollIntoView(true);", element);
					text = tooltip.getText();
					String[] linesplit = text.split("\n");
					// String indicatorFilter = linesplit[14];
					// login.Log4j.info(indicatorFilter);
					for (String str : linesplit) {
						if (str.contains("Indicator")) {
							if (indicator.size() == 2) {
								// login.Log4j.info(indicator.get(0));
								// login.Log4j.info(indicator.get(1));
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
		Thread.sleep(5000);
		int i = 0;
		WebElement element = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("series_count")));
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
		Thread.sleep(2000);
		// login.Log4j.info(Filters.var);
		if (!login.driver.findElement(By.xpath(login.LOCATORS.getProperty("selected_field"))).isDisplayed()) {
			login.Log4j.info("Selected option is get Reset");
		} else {
			Assert.fail("Selected option isn't get Reset");
		}
	}

	@Then("^User can select \"([^\"]*)\" as \"([^\"]*)\"$")
	public void user_can_select_as(String arg1, String arg2) throws Throwable {

		if (login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).isDisplayed()) {
			Actions action = new Actions(login.driver);
			WebElement ele = login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]"));
			action.moveToElement(ele).build().perform();
			Thread.sleep(2000);
			login.Log4j.info("Selecting " + arg2);
			login.driver
					.findElement(By.xpath(
							"//li[@class='dropdown-submenu active-menu-item']//b[contains(text(),'" + arg2 + "')]"))
					.click();
			Thread.sleep(5000);
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
		Thread.sleep(3000);
		login.Log4j.info("clicking on " + arg1);
		login.driver.findElement(By.xpath("//span[@title='" + arg1 + "']")).click();
		Thread.sleep(2000);
		login.Log4j.info("Selecting " + arg2 + " filter");
		login.driver.findElement(By.xpath("//tr[@title='" + arg2 + "']")).click();

	}

	@Then("^User verify corresponding results for selected filter$")
	public void user_verify_corresponding_results_for_selected_filter() throws Throwable {
		WebElement checkbox;
		WebElement element;
		login.Log4j.info("Clicking on  Series tab ");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		Thread.sleep(1000);
		// create instance of JavaScriptExecutor
		JavascriptExecutor jse = (JavascriptExecutor) login.driver;
		// create object of Actions class
		Actions action = new Actions(login.driver);
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
					Thread.sleep(1500);
					int j = i + 1;
					checkbox = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
					action.moveToElement(checkbox).click().build().perform();
					element = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item-data']"));
					action.moveToElement(element).build().perform();
					WebElement ele = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
					// Until the element is not visible keep scrolling
					jse.executeScript("arguments[0].scrollIntoView(true);", element);

					if (filter.equalsIgnoreCase("Key only")) {
						if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("key_icon"))).isDisplayed()) {
							login.Log4j.info(filter + " series are exists");
						} else {
							Assert.fail(filter + " series doesnot exists");
						}
					} else if (filter.equalsIgnoreCase("With release schedule")) {
						Thread.sleep(3000);
						ele.click();
						if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("with_Release")))
								.isDisplayed()) {
							login.Log4j.info(filter + " series are exists");
							Thread.sleep(2000);
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
						} else {
							Assert.fail(filter + " series doesnot exists");
						}
					} else if (filter.equalsIgnoreCase("Forecast")) {
						Thread.sleep(3000);
						ele.click();
						WebElement timepoints = login.driver
								.findElement(By.xpath(login.LOCATORS.getProperty("forecast_timepoints")));
						String Orange = "rgb(255, 165, 0)";
						String appOrange = timepoints.getCssValue("fill");
						// String appOrange =timepoints.getAttribute("fill");
						login.Log4j.info(appOrange);

						if (Orange.equals(appOrange)) {
							login.Log4j.info(filter + " series are exists");
							Thread.sleep(2000);
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
						} else {
							Assert.fail(filter + " series doesnot exists");
						}
					} else {
						Thread.sleep(3000);
						ele.click();
						if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("with_suggestion")))
								.isDisplayed()) {
							login.Log4j.info(filter + " are exists");
							Thread.sleep(2000);
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
						} else {
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
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		Thread.sleep(3000);
		Actions action = new Actions(login.driver);
		WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("series_name")));
		action.moveToElement(ele1).build().perform();
		stext = ele1.getText();
		login.Log4j.info("Clicking on " + arg1 + " icon");
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
		Thread.sleep(5000);
		login.Log4j.info(db);
		login.Log4j.info(Filters.searchData);
		JavascriptExecutor jse = (JavascriptExecutor) login.driver;
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
			dbase = login.driver.findElement(By.xpath("//span[contains(text(),'" + db + "')]"));

		} else {
			dbase = login.driver.findElement(By.xpath("//span[@class='name']//span[contains(text(),'" + db + "')]"));

		}
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

	}

	@Then("^User can see the Chart Visual in the right pannel$")
	public void user_can_see_the_Chart_Visual_in_the_right_pannel() throws Throwable {

		// login.driver.findElement(By.xpath("//div[@class='insight-activity-close']")).click();
		Thread.sleep(2000);
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OK_button"))).click();
		WebElement ctitle = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Chart_title")));
		String ctext = ctitle.getText();
		login.Log4j.info(ctext);
		if (stext.equals(ctext)) {
			login.Log4j.info("Chart visual is created for Mouse hover icon");
		} else {
			Assert.fail("Chart visual is not created for Mouse hover icon");
		}

	}

	@Then("^Footnotes window should be open$")
	public void footnotes_window_should_be_open() throws Throwable {
		WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("footnotes")));
		String ftext = ele.getText();
		login.Log4j.info(ftext);
		if (ftext.contains(stext) == true) {
			login.Log4j.info("Footnotes window is appeared for series level when mouse hovered");
			Thread.sleep(1500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("close_footnotes"))).click();

		} else {
			Assert.fail("Footnotes window is not appeared");
		}

	}

	@And("^Click on drop down icon next to \\+$")
	public void click_on_drop_down_icon_next_to() throws Throwable {
		WebElement checkbox;
		WebElement addSeries_dropdown;
		int j = 0;
		login.Log4j.info("Clicking on  Series tab ");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		Thread.sleep(3000);
		Actions action = new Actions(login.driver);
		WebElement ul_element = null;
		try {
			ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
			AssertJUnit.assertNotNull(ul_element);
			List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
			login.Log4j.info("List size is :" + li_All.size());
			if (li_All.size() > 0) {
				for (int i = 0; i < li_All.size(); i++) {
					j = i + 1;
					checkbox = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
					action.moveToElement(checkbox).click().build().perform();
					copiedSeries = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
					// action.moveToElement(copiedSeries).build().perform();
					SeriesNames = copiedSeries.getText();
					login.Log4j.info(SeriesNames);
					Copy.add(SeriesNames);
					// login.Log4j.info(Copy);

				}
			} else {
				Assert.fail("Sorry,No results were found ");
			}

			if (Filters.searchData.equalsIgnoreCase("5724301;5958801") == true) {
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(
						"//div[@class='insight-page-menu-views']//div[@class='insight-page-menu-views-container ui-sortable']//span[@class='insight-page-menu-item-title']"))
						.click();
				login.driver.findElement(By.xpath("//span[@class='highcharts-title']")).click();
			} else {
				login.driver.findElement(By.xpath("//a[contains(text(),'My Series')]")).click();
			}

			addSeries_dropdown = login.driver
					.findElement(By.xpath("//li[" + j + "]//div[@class='add-to-data-selection--toggle']"));
			action.moveToElement(addSeries_dropdown).click().build().perform();
		} catch (NoSuchElementException e) {
			Assert.fail("WebElement is null " + e.getMessage());
		}

	}

	@And("^Click on Add$")
	public void click_on_Add() throws Throwable {
		Thread.sleep(2000);
		login.Log4j.info("Clicking on Add icon ");
		login.driver.findElement(By.xpath("//span[@title='Add series (A)']")).click();
	}

	@And("^Select \"([^\"]*)\"$")
	public void select(String arg1) throws Throwable {
		Thread.sleep(2000);
		login.Log4j.info("Clicking on " + arg1 + " from drop down");
		login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();
	}

	@When("^User Mouse hover on Add series icon$")
	public void user_Mouse_hover_on_Add_series_icon() throws Throwable {
		WebElement mouseHoverElement;
		WebElement checkbox;
		int j = 0;
		login.Log4j.info("Clicking on  Series tab ");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		Thread.sleep(1000);
		Actions action = new Actions(login.driver);
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

	@And("^Apply \"([^\"]*)\"$")
	public void apply(String arg1) throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[@class='context-menu-item link   ']//span[contains(text(),'Add')]"))
				.click();
	}

	@Then("^Series should be highlighted under My series tab\\.$")
	public void series_should_be_highlighted_under_My_series_tab() throws Throwable {

	}

	@When("^Click on \\+ icon on series$")
	public void click_on_icon_on_series() throws Throwable {
		WebElement checkbox;
		WebElement addIcon;
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
					j = i + 1;
					checkbox = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
					checkbox.click();
					copiedSeries = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
					SeriesNames = copiedSeries.getText();
					login.Log4j.info(SeriesNames);
					Copy.add(SeriesNames);
				}
			} else {
				Assert.fail("Sorry,No results were found ");
			}
			addIcon = login.driver
					.findElement(By.xpath("//li[" + j + "]//div[@class='add-to-data-selection--toggle']"));
			addIcon.click();
		} catch (NoSuchElementException e) {
			Assert.fail("WebElement is null " + e.getMessage());
		}

	}

	@Then("^The series should be added to Data tab$")
	public void the_series_should_be_added_to_Data_tab() throws Throwable {
		Thread.sleep(2000);
		/*
		 * WebElement ele =
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty("sname")));
		 * WebElement ele1 =
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty("sname1")));
		 * String gdp = ele.getText(); String nominal_gdp = ele1.getText(); if
		 * (Copy.contains(gdp) == true && Copy.contains(nominal_gdp) == true) {
		 * login.Log4j.info("The selected series are added to the series tab");
		 * 
		 * } else { Assert.fail("The selected series are not added to the series tab");
		 * }
		 */
		List<WebElement> elements = login.driver.findElements(
				By.xpath("//div[@class='webix_ss_center_scroll']//div[2]//div//div[@class='table-series-title']"));
		int var = 0;
		for (int i = 0; i < elements.size(); i++) {
			int j = i + 1;
			WebElement ele = login.driver.findElement(By.xpath("//div[@class='webix_ss_center_scroll']//div[2]//div["
					+ j + "]//div//div[@class='table-series-title']"));
			String text = ele.getText();
			if (Copy.contains(text) == true) {
				var = var + 1;

			}

		}
		if (Copy.size() == var) {
			login.Log4j.info("The selected series are added to the series tab");
		} else {
			Assert.fail("The selected series are not added to the series tab");
		}

	}

	@Then("^Highlighted visual series should be replaced new series$")
	public void highlighted_visual_series_should_be_replaced_new_series() throws Throwable {
		Thread.sleep(2000);
		WebElement ele;
		List<WebElement> elements = login.driver.findElements(
				By.xpath("//div[@class='highcharts-legend']//div//span//div//span[@class='series-edit--title']"));
		for (int i = 0; i < elements.size(); i++) {
			int j = i + 1;
			ele = login.driver.findElement(By.xpath(
					"//div[@class='highcharts-legend']//div[" + j + "]//span//div//span[@class='series-edit--title']"));
			String text = ele.getText();
			if (Copy.contains(text) == true) {
				login.Log4j.info("Highlighted visual series replaced with new series");

			} else {
				login.Log4j.info("Highlighted visual series not replaced with new series");
			}

		}
		Thread.sleep(2000);
		if(login.driver.findElement(By.xpath("//div[@title='Close']")).isDisplayed()) {
			Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@title='Close']")).click();
		}
		/*
		 * WebElement ele = login.driver .findElement(By.
		 * xpath("//div[@class='legend-item']//span[contains(text(),'Consumer Price Index')]"
		 * )); String var = ele.getText(); WebElement ele1 = login.driver
		 * .findElement(By.
		 * xpath("//div[@class='legend-item']//span[contains(text(),'Imports cif')]"));
		 * String var1 = ele1.getText();
		 * 
		 * if (Copy.contains(var) == true && Copy.contains(var1) == true) { login.Log4j.
		 * info("Highlighted visual series should be replaced with new series");
		 * 
		 * } else {
		 * Assert.fail("Highlighted visual series are not replaced with new series"); }
		 */

	}

	@Then("^Choose any existing insights to add this series$")
	public void choose_any_existing_insights_to_add_this_series() throws Throwable {
		Thread.sleep(2000);
		login.Log4j.info("Clicking on existing insight");
		WebElement ele = login.driver.findElement(By.xpath("//div[@class='insight-icon-item'][1]"));
		insightName = ele.getText();
		// login.Log4j.info("insight name is" + insightName);
		ele.click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//button[contains(text(),'Add to insights (1)')]")).click();
	}

	@Then("^The series should be added to selected insight$")
	public void the_series_should_be_added_to_selected_insight() throws Throwable {
		Thread.sleep(1000);
		WebElement ele;
		confirmPopup = login.driver.findElement(By.xpath("//div[@class='growl-message-text']"));
		if (confirmPopup.isDisplayed()) {
			String str = confirmPopup.getText();
			login.Log4j.info("Confirmation message is " + str);
			login.driver.findElement(By.xpath("//div[@class='growl-message-text']//a[contains(text(),'Untitled insight')]"))
					.click();
			Robot robot = new Robot();
			// Store all currently open tabs in tabs
			ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
			// Navigate to New Tab
			login.driver.switchTo().window(tabs2.get(1));
			Thread.sleep(10000);
			List<WebElement> series = login.driver
					.findElements(By.xpath("//div[@class='webix_cell']//div[@class='name-block two-rows-item ']"));
			login.Log4j.info("Size of the list is :" + series.size());
			for (int i = 0; i < series.size(); i++) {
				int j = i + 1;
				ele = login.driver.findElement(By.xpath("//div[@class='webix_column list-series-name webix_last']/div["
						+ j + "]/div/div/div/span[1]/span"));
				String str1 = ele.getText();
				Series.add(str1);
			}
			if (Series.contains("Gross Domestic Product (GDP)") == true
					&& Series.contains("Nominal GDP: USD mn: sa") == true) {
				login.Log4j.info("The selected series are added to the existing insight");
			} else {
				Assert.fail("The selected series are not added to the existing insight");
			}
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
		confirmPopup = login.driver.findElement(By.xpath("//div[@class='growl-message-text']"));
		if (confirmPopup.isDisplayed()) {
			login.Log4j.info("Confirmation notification is displayed with 'Go to new insight' link");
			login.Log4j.info("Clicking on Go to new insight");
			login.driver
					.findElement(
							By.xpath("//div[@class='growl-message-text']//a[contains(text(),'Go to new insight')]"))
					.click();
			Robot robot = new Robot();
			// Store all currently open tabs in tabs
			ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
			// Navigate to New Tab
			login.driver.switchTo().window(tabs2.get(1));
			Thread.sleep(10000);
			List<WebElement> series = login.driver
					.findElements(By.xpath("//div[@class='webix_cell']//div[@class='name-block two-rows-item ']"));
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
			login.driver.close();
			login.driver.switchTo().window(tabs2.get(0));
		} else {
			Assert.fail("Confirmation notification is not displayed with 'Go to new Insight name(link)'");
		}
	}

	@Then("^Verify the selected series count$")
	public void verify_the_selected_series_count() throws Throwable {
		Thread.sleep(2000);
		login.Log4j.info("Clicking on  Series tab ");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		WebElement ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
		login.Log4j.info("List size is :" + li_All.size());
		int list = li_All.size();
		// create instance of JavaScriptExecutor
		JavascriptExecutor jse = (JavascriptExecutor) login.driver;
		if (li_All.size() > 0) {
			for (int i = 0; i < li_All.size(); i++) {
				Thread.sleep(1500);
				int j = i + 1;
				WebElement checkbox = login.driver
						.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
				checkbox.click();
				// Until the element is not visible keep scrolling
				jse.executeScript("arguments[0].scrollIntoView(true);", checkbox);
			}
			WebElement ele = login.driver.findElement(
					By.xpath("//span[@class='search-input--preview-selection']//span[contains(text(),'3')]"));
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
		Thread.sleep(2000);
		Actions act = new Actions(login.driver);
		login.Log4j.info("Clicking on Pin");
		WebElement element = login.driver.findElement(
				By.xpath("//span[@title='Filter series by indicator']//div[@class='dnd-filter--wrapper']"));
		act.moveToElement(element).click().build().perform();

	}

	@Then("^filter should be pined/unpined the filter to left panel$")
	public void filter_should_be_pined_unpined_the_filter_to_left_panel() throws Throwable {
		Thread.sleep(3000);
		if (login.driver.findElement(By.xpath("//i[@title='Unpin from left']")).isDisplayed()) {
			login.Log4j.info("Filter is pinned to left");
			login.driver.findElement(By.xpath("//i[@title='Unpin from left']")).click();
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
			login.Log4j.info("Selected series are copied into Excel");
		} else {
			Assert.fail("Selected series are not copied into Excel");
		}
		wb.write(fileOut);
		fileOut.close();

	}

}
