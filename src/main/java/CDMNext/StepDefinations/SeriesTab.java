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
	public String sname;
	public String str1;
	public String str2;
	public String filter;
	public String seriesName;
	public String db="null";
	public String MousehoverIcon;
	public WebElement dbase;
    public String stext;
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
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("copy_popup_text")))
						.isDisplayed()) {
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
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Chart_title"))).isDisplayed()) {
					login.Log4j.info("Chart visual is created for " + arg1 + " right click option");
				} else {
					Assert.fail("Chart visual is not created");
				}
			} else if (arg1.equals("View as Map")) {
				login.driver.findElement(By.xpath("//span[@title='" + arg1 + "']")).click();
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Chart_title"))).isDisplayed()) {
					login.Log4j.info("Map visual is created " + arg1 + " right click option");
										
				} else {
					Assert.fail("Map visual is not created");
				}

			} else if (arg1.equals("View as Table")) {
				login.driver.findElement(By.xpath("//span[@title='" + arg1 + "']")).click();
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("table_title"))).isDisplayed()) {
					login.Log4j.info("Table visual is created for right click option on series level");
				} else {
					Assert.fail("Table visual is not created");
				}
			} else if (arg1.equals("Download")) {
				login.driver.findElement(By.xpath("//span[@title='" + arg1 + "']")).click();
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("download"))).isDisplayed()) {
					Thread.sleep(2000);
					login.Log4j.info("Download window is appeared for right click option on series level " + arg1);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("download_popup"))).click();
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
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("show_dataset_validateTxt"))).isDisplayed()) {
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
			Thread.sleep(1000);
			
			if (login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).isDisplayed()) {
				Thread.sleep(5000);
				login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();
				login.Log4j.info("Clicking on " + arg1);
			}

		} else if (arg1.equals("Apply filter")) {
			login.driver.findElement(By.xpath("//div[contains(text(),'" + arg1 + "')]")).click();
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
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("download_popup"))).click();
		} else {
			Assert.fail(arg1 + " popup is not appeared");
		}
	}

	@And("^Select indicator \"([^\"]*)\" as \"([^\"]*)\"$")
	public void select_indicator_as(String arg1, String arg2) throws Throwable {
		indicator.add(arg2);
		login.Log4j.info("indicator size is " + indicator.size());
		login.Log4j.info(indicator);

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
		String tltip;

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
					element = login.driver.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--content']"));
					mouseOver.moveToElement(element).build().perform();
					// Until the element is not visible keep scrolling
					jse.executeScript("arguments[0].scrollIntoView(true);", element);
					tltip = element.getAttribute("title");
					String[] linesplit = tltip.split("\n");
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
						if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("key_icon")))
								.isDisplayed()) {
							login.Log4j.info(filter + " series are exists");
						} else {
							Assert.fail(filter + " series doesnot exists");
						}
					} else if (filter.equalsIgnoreCase("With release schedule")) {
						Thread.sleep(3000);
						ele.click();
						if (login.driver
								.findElement(By.xpath(login.LOCATORS.getProperty("with_Release"))).isDisplayed()) {
							login.Log4j.info(filter + " series are exists");
							Thread.sleep(2000);
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
						} else {
							Assert.fail(filter + " series doesnot exists");
						}
					} else if (filter.equalsIgnoreCase("Forecast")) {
						Thread.sleep(3000);
						ele.click();
						WebElement timepoints = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("forecast_timepoints")));
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
						if (login.driver.findElement(By
								.xpath(login.LOCATORS.getProperty("with_suggestion"))).isDisplayed()) {
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
		MousehoverIcon=arg1;
		login.Log4j.info("Clicking on  Series tab ");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		Thread.sleep(3000);
		Actions action=new Actions(login.driver);
		WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("series_name")));
		action.moveToElement(ele1).build().perform();
		 stext=ele1.getText();
		login.Log4j.info("Clicking on "+ arg1+ " icon");
		login.driver.findElement(By.xpath("//div[@class='series-list-item--action-icons']//span[@title='"+ arg1 +"']")).click();
		
		
	}

	@Then("^User can selects \"([^\"]*)\"$")
	public void user_can_selects(String arg1) throws Throwable {
		db=arg1;
		Thread.sleep(2000);
		login.Log4j.info(" Clicking on "+arg1);
		login.driver.findElement(By.xpath("//span//b[contains(text(),'" + arg1 + "')]")).click();
		
   	}

	@Then("^User can see the selected database in Databases tab$")
	public void user_can_see_the_selected_database_in_Databases_tab() throws Throwable {
		Thread.sleep(5000);
		login.Log4j.info(db);
		login.Log4j.info(Filters.searchData);
		JavascriptExecutor jse = (JavascriptExecutor) login.driver; 
		if(db.equals("null")) {
		
			if(Filters.searchData.equals("400841827")) {
				dbase=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("markit_purchasing_db")));
			} else if(Filters.searchData.equals("122834404")) {
				dbase=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OECD-MainEconomic_db")));
			} else if(Filters.searchData.equals("377030917")) {
				dbase=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OECD_EconomicOutlook")));
			} else if(Filters.searchData.equals("295755902")) {
				dbase=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OECD_productivity")));
			}
		  
		} else if(db.equals("Global Database")) {
			  dbase=login.driver.findElement(By.xpath("//span[contains(text(),'"+db+"')]"));

		}else {
			dbase=login.driver.findElement(By.xpath("//span[@class='name']//span[contains(text(),'"+db+"')]"));

		}
		  // Until the element is not visible keep scrolling
		   jse.executeScript("arguments[0].scrollIntoView(true);", dbase);
		   String txt=dbase.getText();
		   login.Log4j.info(txt);
 	        if (txt.equals(db)) {
				login.Log4j.info(db+" is displayed for "+MousehoverIcon+" icon when mouse hovered");
				
			} else if(txt.equals("Markit Purchasing Managers' Index")) {
				login.Log4j.info(txt+" is displayed for "+MousehoverIcon+" icon when mouse hovered");
				
			} else if(txt.equals("OECD - Main Economic Indicators")) {
				login.Log4j.info(txt+" is displayed for "+MousehoverIcon+" icon when mouse hovered");
			} else if(txt.equals("OECD - Economic Outlook")) {
				login.Log4j.info(txt+" is displayed for "+MousehoverIcon+" icon when mouse hovered");
			} else if(txt.equals("OECD - Productivity")) {
				login.Log4j.info(txt+" is displayed for "+MousehoverIcon+" icon when mouse hovered");
	        } else {
				Assert.fail(db+" is not displayed for " +MousehoverIcon+ " icon");
			}

	   
	}
	@Then("^User can see the Chart Visual in the right pannel$")
	public void user_can_see_the_Chart_Visual_in_the_right_pannel() throws Throwable {
		//login.driver.findElement(By.xpath("//div[@class='insight-activity-close']")).click();
	    Thread.sleep(2000);
	    login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OK_button"))).click();
		 WebElement ctitle=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Chart_title")));
	    String ctext=ctitle.getText();
	    login.Log4j.info(ctext);
	    if(stext.equals(ctext)) {
	    	login.Log4j.info("Chart visual is created for Mouse hover icon");
	    } else {
	    	Assert.fail("Chart visual is not created for Mouse hover icon");
	    }
	}
	@Then("^Footnotes window should be open$")
	public void footnotes_window_should_be_open() throws Throwable {
		WebElement ele=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("footnotes")));
		String ftext=ele.getText();
		login.Log4j.info(ftext);
		if (ftext.contains(stext)==true) {
			login.Log4j.info("Footnotes window is appeared for series level when mouse hovered");
			Thread.sleep(1500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("close_footnotes"))).click();
		} else {
			Assert.fail("Footnotes window is not appeared");
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
