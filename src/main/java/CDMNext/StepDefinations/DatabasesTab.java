package CDMNext.StepDefinations;

import org.testng.Assert;
import org.testng.AssertJUnit;

import org.testng.asserts.SoftAssert;

import CDMNext.util.CommonFunctionality;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DatabasesTab {
	List<String> arrlist = new ArrayList<>();
	List<String> ExpectedTableName = new ArrayList<>();
	public String Db, ExpectedResult;
	String db_name;
	public static String series_name;
	public static String Change, Applied_currency;
	Boolean database = false;
	public WebElement footnote;
	public String dbstr;
	public String beforeDb;
	ArrayList<String> tabs2;
	public String str;
	public static String MinimizeVar, MaximizeVar, FullScreenVar, Exit_fullScreen;
	Dimension dimension;
	String visual;
	public String Validationstr;
	public WebElement cross_icon;
	String[] dbarr;
	String[] DataBase;
	Boolean closeVar = false;
	public String countryVar;
	static int afterFilter;
	static int beforeFilter;
	public WebElement rightClickElement;
	public static String Before_set_lang,ActualColor;
	public String After_set_lang;
	public static String dbase;
	public WebElement copy_link;
	public WebElement ele;
	public WebElement AddIcon;
	public WebElement checkbox;
	// String sname;
	String BeforeReplace;
	String Clipboard_data;
	String MouseHoverAction;
	String beforeReplace_sname1;
	String beforeReplace_sname2;
	String afterReplace_sname1;
	String afterReplace_sname2;
	// int SeriesCount;
	int insightVar;
	int beforeUnselct;
	int m;
	Dimension BeforeMiniAndMaximize_dimension;
	String tableName;
	String result = "fail";
	// String insight_name;
	Robot robot;
	SoftAssert s_assert = new SoftAssert();
	List<String> listOne = new ArrayList<String>();
	List<String> listTwo = new ArrayList<String>();
	Filters filter = new Filters();
	Actions action = new Actions(login.driver);
	JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	WebDriverWait wait = new WebDriverWait(login.driver, 2000);
	SeriesTab st = new SeriesTab();
	int selected_table_size;
	public int i;
	String copied_link;
	static String function;

	@Given("^Click on More filter$")
	public void click_on_More_filter() throws Throwable {
		CommonFunctionality.wait(15000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MoreFilter"))).click();
		CommonFunctionality.wait(10000);
	}

	@And("^Select database as \"([^\"]*)\"$")
	public void select_database_as(String arg1) throws Throwable {
		DataBase = arg1.split(",");
		String dbName;
		for (String dblist : DataBase) {
			CommonFunctionality.wait(1000);
			login.Log4j.info("Selecting " + dblist);
			// List<WebElement> checkbox =
			// login.driver.findElements(By.xpath("//div//span[contains(text(),'" + dblist
			// + "')]/preceding-sibling::label/span[@class='input-control--indicator']"));
			List<WebElement> AllDb = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("DatabasesList")));
			for (int i = 0; i < AllDb.size(); i++) {
				WebElement dbEle = AllDb.get(i);
				dbName = dbEle.getText();
				if (dblist.equalsIgnoreCase(dbName)) {
					dbEle.click();
					break;
				}

			}
		}
	}

	@Then("^Result should be loaded only for selected database$")
	public void result_should_be_loaded_only_for_selected_database() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Databases_Tab", 8).click();
		dbarr = DataBase[0].split(" ");
		if (DataBase[0].equals("India Premium Database")) {
			CommonFunctionality.wait(3000);
			CommonFunctionality.getElementByProperty(login.driver, "DB_level_1", 8).click();
			CommonFunctionality.wait(3000);
			CommonFunctionality.getElementByProperty(login.driver, "GDP", 8).click();
			CommonFunctionality.wait(3000);
			CommonFunctionality.getElementByProperty(login.driver, "table-level", 8).click();
			DatabaseValidation();
			if (database == true) {
				login.Log4j.info("Results is shown correctly for selected " + DataBase[0]);

			} else if (database == false) {
				AssertJUnit.fail("Results is not shown correctly for selected " + DataBase[0]);
			}
		}
	}

	@And("^Select database as Daily Database$")
	public void select_database_as_Daily_Database() throws Throwable {
		// CommonFunctionality.TopMethod();
		// CommonFunctionality.ResetMethod();
		// CommonFunctionality.CollapseTreeMethod();
		CommonFunctionality.getElementByProperty(login.driver, "Databases_Tab", 8).click();
		CommonFunctionality.wait(3000);
		CommonFunctionality.getElementByProperty(login.driver, "Daily_db", 10).click();
		login.Log4j.info("Clicking on Database level");
		database = true;
	}

	@And("^Expand till series level$")
	public void expand_till_series_level() throws Throwable {

		if (database == true) {
			CommonFunctionality.getElementByProperty(login.driver,
					"Expand2ndLevel", 4).click();
			login.Log4j.info("Clicking on Topic level");
			CommonFunctionality.getElementByProperty(login.driver,
					"Expand3rdLevel", 4)
					.click();
			login.Log4j.info("Clicking on Section level");
			Thread.sleep(1200);
			ele = login.driver.findElement(By.xpath(
					"(//div[@class='tree-node'])[1]//*[@class='name-text']"));
			tableName = ele.getText();
			CommonFunctionality.getElementByProperty(login.driver,
					"Expand4thLevel",
					4).click();
			login.Log4j.info("Clicking on Table level");

		} else {
			CommonFunctionality.wait(2000);
			CommonFunctionality.getElementByProperty(login.driver,
					"Global_AllRegions", 4).click();
			login.Log4j.info("Clicking on Topic level");
			CommonFunctionality.wait(2000);
			CommonFunctionality.getElementByProperty(login.driver,
					"SelectNationalAccounts", 4).click();
			login.Log4j.info("Clicking on Section level");
			CommonFunctionality.wait(2000);
			CommonFunctionality
					.getElementByProperty(login.driver,
							"SelectGrossDomesticProduct", 4)
					.click();
			login.Log4j.info("Clicking on Table level");
			CommonFunctionality.wait(2000);
			CommonFunctionality.getElementByProperty(login.driver,
					"firstTable_level", 4)
					.click();
			login.Log4j.info("Clicking on Series level");
		}

	}

	@Then("^Should able to expand all the DB/Topic/section/table under Databases tab$")
	public void should_able_to_expand_all_the_DB_Topic_section_table_under_Databases_tab() throws Throwable {
		Thread.sleep(2000);
		checkbox = login.driver.findElement(By.xpath(
				"//div[contains(@class,'series-list-item series-list-item__found-by-search')]//*[@class='series-list-item--checkbox-wrapper']/*"));
		if (checkbox.isDisplayed()) {
			checkbox.click();
			login.Log4j.info("DB/Topic/section/table level under Databases tab is expanded");
		} else {
			login.Log4j.info("DB/Topic/section/table level under Databases tab is not expanded");
		}
	}

	@And("^Select Global database$")
	public void select_global_database() throws Throwable {
		CommonFunctionality.CollapseTreeMethod();
		try {
			CommonFunctionality.getElementByProperty(login.driver, "MatchesOnly", 8).click();
		} catch (Exception e) {

		}
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("GlobalDB"))))
				.click();
		login.Log4j.info("Clicking on Global Database");
	}

	@And("^Click on Collapse all option$")
	public void click_on_Collapse_all_option() throws Throwable {
		login.Log4j.info("Clicking on Collapse all option");
	}

	@Then("^Opened data tree should be collapsed$")
	public void opened_data_tree_should_be_collapsed() throws Throwable {
		Thread.sleep(2000);
		WebElement collapse;
		collapse = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CollapseTree")));
		if (collapse.isEnabled()) {
			collapse.click();
			login.Log4j.info("Open data tree is collapsed");
		} else {
			Assert.fail("Open data tree is not collapse");
		}
	}

	@And("^Select any number of series$")
	public void select_any_number_of_series() throws Throwable {
		login.Log4j.info("Clicking on  Series tab ");
		CommonFunctionality.getElementByProperty(login.driver, "Series", 8).click();

		try {
			Thread.sleep(3000);
			List<WebElement> li_All = login.driver
					.findElements(By.xpath(login.LOCATORS.getProperty("Checkbox")));
			login.Log4j.info("List size is :" + li_All.size());
			if (li_All.size() > 0) {
				for (int i = 0; i < li_All.size(); i++) {
					CommonFunctionality.wait(100);
					li_All.get(i).click();
					// Until the element is not visible keep scrolling
					WebElement comparables = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='search-presentation-tabs--visible']//*[contains(text(),'Comparables')]", 4);
					action.pause(50).moveToElement(comparables).build().perform();
					 jse.executeScript("arguments[0].scrollIntoView(true);", li_All.get(i));
				}
			} else {
				Assert.fail("list size is zero");
			}
		} catch (NoSuchElementException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Selected series should be unselected$")
	public void selected_series_should_be_unselected() throws Throwable {
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unselect"))).isEnabled()) {
			login.Log4j.info("The selected series are got unselected");
		} else {
			Assert.fail("The selected series are not unselected");
		}
	}

	@Given("^Hover the mouse on any Database$")
	public void hover_the_mouse_on_any_Database() throws Throwable {
//		login.driver.navigate().refresh();
		CommonFunctionality.getElementByProperty(login.driver, "Databases_Tab", 5).click();
		CommonFunctionality.wait(3000);
		ele = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("GlobalDB_Text")));
		action.moveToElement(ele).build().perform();
	}

	@Then("^Footnotes icon should be displayed$")
	public void footnotes_icon_should_be_displayed() throws Throwable {
		Thread.sleep(2000);
		footnote = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("MouseHoverGlobalDB_footNotes")));
		if (footnote.isDisplayed()) {
			login.Log4j.info("footnote icon is enabled when mouse hover on the databse");
		} else {
			Assert.fail("footnote icon is not enabled when mouse hover on the databse");
		}
	}

	@When("^Click on footnote's icon$")
	public void click_on_footnote_s_icon() throws Throwable {
		CommonFunctionality.wait(2000);
		footnote.click();
		login.Log4j.info("Clicking on footnote icon");
	}

	@Then("^Footnotes should be opened for related \"([^\"]*)\"$")
	public void footnotes_should_be_opened_for_related(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.footnoteDb = login.driver.findElement(By.className("footnotes-modal--name"));
		str = CommonFunctionality.footnoteDb.getText();
		login.Log4j.info(str);
		Validationstr = ele.getText();
		login.Log4j.info(Validationstr);
		if (str.contains(Validationstr) == true) {
			login.Log4j.info("Footnotes is displayed on " + arg1 + " level");
			CommonFunctionality.wait(1500);
			login.driver.findElement(By.className("movable-modal--close")).click();
		} else {
			CommonFunctionality.wait(1000);
			login.driver.findElement(By.className("movable-modal--close")).click();
			Assert.fail("Footnotes is not displayed on " + arg1 + " level");
		}
		
	}

	@Given("^Right click on any Database$")
	public void right_click_on_any_Database() throws Throwable {

		CommonFunctionality.getElementByProperty(login.driver, "Databases_Tab", 5).click();
		// Right clicking on Global Database
		CommonFunctionality.wait(3000);
		ele = CommonFunctionality.getElementByProperty(login.driver,
				"GlobalDB_Text", 8);
		ExpectedResult = ele.getText();
		// rightClickElement =
		// login.driver.findElement(By.xpath("//div[@class='child-container']//div[2]//div[2]//span[@class='name-text']"));
		// contextClick() method to do right click on the element
		action.contextClick(ele).build().perform();
	}

	@When("^Paste it in new tab$")
	public void paste_it_in_new_tab() throws Throwable {
		CommonFunctionality.wait(2000);
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_T);
		CommonFunctionality.wait(2000);
		// Store all currently open tabs in tabs
		tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
		// Navigate to New Tab
		login.driver.switchTo().window(tabs2.get(1));
		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		CommonFunctionality.wait(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		CommonFunctionality.wait(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		/*
		 * tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
		 * jse.executeScript("window.open('');"); CommonFunctionality.wait(3000);
		 * jse.executeScript("arguments[0].value='"+Keys.chord(Keys.CONTROL, "v")+"'",
		 * ele);
		 */
	}

	@Then("^The selected \"([^\"]*)\" should be highlighted$")
	public void the_selected_should_be_highlighted(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		try {
			WebElement highlightdtext = CommonFunctionality.getElementByProperty(login.driver,
					"HighlightedEle",
					20);
			if (highlightdtext.isDisplayed()) {
				CommonFunctionality.wait(500);
				String actualText = CommonFunctionality.getElementByProperty(login.driver,
						"HighlightedEle_text",
						20).getText();
				if (ExpectedResult.equalsIgnoreCase(actualText)) {
					login.Log4j.info("The selected " + arg1 + " is highlighted for right click /mouse hover actions");
				} else {
					AssertJUnit
							.fail("The selected " + arg1 + " is not highlighted for right click /mouse hover actions");
				}
			}
			login.driver.close();
			login.driver.switchTo().window(tabs2.get(0));

		} catch (Exception e) {
			login.driver.close();
			login.driver.switchTo().window(tabs2.get(0));
			AssertJUnit.fail(e.getMessage());
		}
	}

	@And("^Click on x icon to remove DB$")
	public void click_on_x_icon_to_remove_DB() throws Throwable {
		CommonFunctionality.wait(2000);
		cross_icon = login.driver.findElement(By.xpath("//*[@class='dropdown-search-filter-title--cross']"));
		CommonFunctionality.wait(300);
		cross_icon.click();
	}

	@Then("^Selected database shold be removed$")
	public void selected_database_shold_be_removed() throws Throwable {
		if (!cross_icon.isDisplayed()) {
			login.Log4j.info("Selected database has been removed");
		} else {
			login.Log4j.info("Selected database has not been removed");
		}
	}

	@Then("^User can see the results for multiple database selection$")
	public void user_can_see_the_results_for_multiple_database_selection() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Databases_Tab", 4).click();
		CommonFunctionality.wait(2000);
		List<WebElement> multidb = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("ListOfDB_DatabasesTab")));
		login.Log4j.info("Size of database selection is " + multidb.size());
		if (multidb.size() > 0) {
			try {
				if (multidb.size() == 3) {

					for (int i = 0; i < multidb.size(); i++) {
						// login.Log4j.info(DataBase[0]);
						// login.Log4j.info(DataBase[1]);
						// login.Log4j.info(DataBase[2]);
						login.Log4j.info(i);
						Thread.sleep(700);
						if (DataBase[i].equalsIgnoreCase("China Premium Database")) {
							dbarr = DataBase[i].split(" ");
							CommonFunctionality.getElementByProperty(login.driver, "SelectCN_db", 8).click();
							CommonFunctionality.getElementByProperty(login.driver, "SelectNationalAccounts", 8).click();
							CommonFunctionality.wait(2000);
							CommonFunctionality.getElementByProperty(login.driver, "SelectGrossDomesticProduct", 8)
									.click();
							CommonFunctionality.wait(2000);
							CommonFunctionality.getElementByProperty(login.driver, "firstTable_level", 8).click();

						} else if (DataBase[i].equalsIgnoreCase("Brazil Premium Database")) {
							dbarr = DataBase[i].split(" ");
							BrazilPremiumDb();
							CommonFunctionality.wait(500);
							CommonFunctionality
									.getElementByProperty(login.driver, "firstTable_level", 20)
									.click();

						} else if (DataBase[i].equalsIgnoreCase("Russia Premium Database")) {
							dbarr = DataBase[i].split(" ");
							CommonFunctionality.getElementByProperty(login.driver, "SelectRussiaDB", 20).click();
							CommonFunctionality.wait(2000);
							CommonFunctionality
									.getElementByProperty(login.driver, "SelectNationalAccounts_RussiaDB", 20).click();
							CommonFunctionality.wait(2000);
							CommonFunctionality.getElementByProperty(login.driver, "SelectGDP_RussiaDB", 8).click();
							CommonFunctionality.wait(2000);
							CommonFunctionality.getElementByProperty(login.driver, "GDP_firstTableLevel", 30).click();
						}

						DatabaseValidation();
						if (database == true) {
							login.Log4j.info("Results is shown correctly for selected " + DataBase[i]);
							// CommonFunctionality.TopMethod();
						} else if (database == false) {
							AssertJUnit.fail("Results is not shown correctly for selected " + DataBase[i]);
						}
					}

				} else {
					login.Log4j.info("dbsize is more than 3");
				}
			} catch (Exception e) {
				AssertJUnit.fail(e.getMessage());
			}
		} else {
			Assert.fail("Database level is not displayed");
		}

	}

	@Given("^Click on \"([^\"]*)\" option$")
	public void click_on_option(String arg1) throws Throwable {
		/*
		 * Thread.sleep(2000);
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).
		 * clear(); if (login.driver.findElement(By.xpath("//span[contains(text(),'" +
		 * arg1 + "')]")).isDisplayed()) { Thread.sleep(3000);
		 * login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 +
		 * "')]")).click(); login.Log4j.info("Clicking on " + arg1); } else {
		 * AssertJUnit.fail(arg1 + " is not displayed"); }
		 */
		if (arg1.equals("Rename") || arg1.equalsIgnoreCase("Feedback") || arg1.equals("+ Add more from My Series")) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 5).click();

		} else if (arg1.equalsIgnoreCase("Minimize") || arg1.equalsIgnoreCase("Maximize")
				|| arg1.equalsIgnoreCase("Full-screen") || arg1.equalsIgnoreCase("Exit full-screen")) {
			MinimizeVar = MaximizeVar = FullScreenVar = Exit_fullScreen = arg1;
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='movable-modal--header']/*[2]//*[@class='movable-modal--action' and @title = '" + arg1
							+ "']",
					6).click();
		} else if (arg1.equalsIgnoreCase("Add to Watchlist")) {
			series_name = login.driver
					.findElement(By.xpath(
							"//ul[@class='search-series-list scrollable']/*[1]//div[@class='series-item--name']"))
					.getText();
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//div[@class='items-wrapper']//span[@title='" + arg1 + "']", 4))
					.pause(2000).click().build().perform();

		} else {
			login.driver.switchTo().defaultContent();
			CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg1 + "']", 6).click();
		}

	}

	@When("^Click on Close$")
	public void click_on_Close() throws Throwable {
		wait(2000);
		WebElement close_icon = login.driver.findElement(By.xpath("//div[@ui='$close']"));
		if (close_icon.isDisplayed()) {
			wait(2000);
			close_icon.click();
			login.Log4j.info("Clicking on Closing icon");
			closeVar = true;
		} else {
			closeVar = false;
		}
	}

	@Then("^The Insight Explorer popup should be closed$")
	public void the_Insight_Explorer_popup_should_be_closed() throws Throwable {

		if (closeVar == true) {
			login.Log4j.info("Insight Explorer popup is closed");
		} else {
			AssertJUnit.fail("Insight Explorer popup is not closed");
		}
	}

	/*
	 * @And("^Select filter \"([^\"]*)\" as \"([^\"]*)\"$") public void
	 * select_filter_as(String arg1, String arg2) throws Throwable { countryVar =
	 * arg2; Thread.sleep(2000); CommonFunctionality.AlldbClear(); if
	 * (arg1.equals("Region")) { login.Log4j.info("clicking on " + arg1);
	 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty("region_filter")
	 * )).click(); Thread.sleep(2000);
	 * login.driver.findElement(By.xpath("//tr[@title='" + arg2 + "']")).click();
	 * 
	 * } }
	 */

	@Then("^Result should be displayed as per the filters applied$")
	public void result_should_be_displayed_as_per_the_filters_applied() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Databases_Tab", 4).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Matches only')]", 4).click();
		// WebElement element = null;

		CommonFunctionality
				.getElementByProperty(login.driver, "Expand_AllRegion", 4)
				.click();
		CommonFunctionality.getElementByProperty(login.driver, "Expand_Japan", 10)
				.click();
		CommonFunctionality
				.getElementByProperty(login.driver, "Expand_JapanNationalAccounts", 10)
				.click();
		CommonFunctionality.getElementByProperty(login.driver,
				"Expand_firstTable", 10).click();
		CommonFunctionality.wait(1500);
		//WebElement ul_element = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("UL")));
		List<WebElement> li_sname = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("ListOfSeries_DatabasesTab")));
		login.Log4j.info("List size is :" + li_sname.size());
		for (int i = 0; i < li_sname.size(); i++) {
			CommonFunctionality.wait(2000);
			login.Log4j.info(i);
			login.Log4j.info(li_sname.size());
			int j = i + 1;
			try {
				li_sname.get(i).click();
			} catch (NoSuchElementException e) {
				login.Log4j.error("Series name is null");
				j = j + 1;
				li_sname.get(j).click();

			} finally {
				WebElement region = login.driver
						.findElement(By.xpath("//div[@class='main-series-information--field-value']//div[1]//div[1]"));
				String rgnstr = region.getText();
				login.Log4j.info(Filters.var);
				login.Log4j.info(rgnstr);
				if (Filters.var.equalsIgnoreCase(rgnstr) == true) {
					login.Log4j.info("Results has shown correctly for applied region filter is " + rgnstr);
					CommonFunctionality.wait(1000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
				} else {
					CommonFunctionality.wait(1000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
					Assert.fail("Results has not shown correctly for applied region filter is " + rgnstr);

				}
			}
			// Until the element is not visible keep scrolling
			jse.executeScript("arguments[0].scrollIntoView(true);", li_sname.get(i));
		}
		// CommonFunctionality.TopMethod();
		// CommonFunctionality.CollapseTreeMethod();
		// CommonFunctionality.ResetMethod();
	}

	@When("^Click on x icon$")
	public void click_on_x_icon() throws Throwable {
		AfterMethod();
		login.Log4j.info("After applied filter series count is " + afterFilter);
		CommonFunctionality.wait(1500);
		cross_icon = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RemoveAppliedFilter_crossIcon")));
		cross_icon.click();
		login.Log4j.info("Removing filter.... ");
	}

	@Then("^The applied filters should be removed$")
	public void the_applied_filters_should_be_removed() throws Throwable {
		BeforeMethod();
		login.Log4j.info("Before apply filter the series count is " + beforeFilter);
		List<WebElement> reset = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Reset")));
		if (reset.size() > 0 && beforeFilter > afterFilter) {
			login.Log4j.info("The applied filter has been removed");
		} else {
			AssertJUnit.fail("The applied filter has not been removed");
		}
		/*
		 * if (!cross_icon.isDisplayed()) {
		 * login.Log4j.info("The applied filter has been removed"); } else {
		 * login.Log4j.info("The applied filter has not been removed"); }
		 */
	}

	@Then("^The \"([^\"]*)\" popup should be opened$")
	public void the_popup_should_be_opened(String arg1) throws Throwable {
		CommonFunctionality.wait(4000);
		if (arg1.equalsIgnoreCase("Apply functions to visual series")) {
			String Movable_modal_title_msg = CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='movable-modal--title-message']", 8).getText();
			if (Movable_modal_title_msg.equals(arg1)) {
				login.Log4j.info("The" + arg1 + " popup is opened");
				// CommonFunctionality.getElementByXpath(login.driver,
				// "//*[@class='movable-modal--close']", 8).click();
				// CommonFunctionality.Views_list();
			} else {
				Assert.fail(arg1 + " popup is not opened");
			}
		} else if (arg1.equals("Keyword search tips")) {
			WebElement keywrd_search_tips_popup = login.driver
					.findElement(By.xpath("//h4[contains(text(), '" + arg1 + "')]"));
			if (keywrd_search_tips_popup.isDisplayed()) {
				login.Log4j.info(arg1 + " popup is displayed");
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']", 8).click();

			} else {
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']", 8).click();
				AssertJUnit.fail(arg1 + " popup is not displayed");
			}
		}
	}

	@Then("^User should redirect to \"([^\"]*)\"$")
	public void user_should_redirect_to(String arg1) throws Throwable {
		CommonFunctionality.wait(4000);
		robot = new Robot();
		// Store all currently open tabs in tabs
		tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
		// Navigate to New Tab
		login.driver.switchTo().window(tabs2.get(1));
		robot.keyPress(KeyEvent.VK_ENTER);
		String Currenturl = login.driver.getCurrentUrl();
		robot.keyRelease(KeyEvent.VK_ENTER);
		login.Log4j.info("Current url is " + Currenturl);
		if (Currenturl.equals(arg1)) {
			login.Log4j.info("User is able to redirect to " + arg1);
			Thread.sleep(1000);
			login.driver.close();
			login.driver.switchTo().window(tabs2.get(0));
		} else {
			Thread.sleep(1000);
			login.driver.close();
			login.driver.switchTo().window(tabs2.get(0));
			AssertJUnit.fail("User is unable to redirect to " + arg1);
		}

	}

	public void DatabaseValidation() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> li_All = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("ListOfSeries_DatabasesTab")));
		login.Log4j.info("List size is :" + li_All.size());

		for (int i = 0; i < li_All.size(); i++) {
			Thread.sleep(1000);
			login.Log4j.info(i);
			login.Log4j.info(li_All.size());
			int j = i + 1;
			try {
				li_All.get(i).click();

			} catch (NoSuchElementException e) {
				login.Log4j.error("Series name is null");
				j = j + 1;
				li_All.get(j).click();

			} finally {
				// WebElement region = null;

				WebElement region = CommonFunctionality.getElementByProperty(login.driver, "RegionTextInSSPwindow", 10);
				String rgnstr = region.getText();
				login.Log4j.info(dbarr[0]);
				login.Log4j.info(rgnstr);
				if (rgnstr.contains(dbarr[0]) == true) {
					database = true;
					CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
				} else {
					database = false;
					CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
				}
				// Until the element is not visible keep scrolling
				jse.executeScript("arguments[0].scrollIntoView(true);", li_All.get(i));

			}

		}

		CommonFunctionality.TopMethod();
		CommonFunctionality.CollapseTreeMethod();
	}

	@Then("^The data tree should be expanded$")
	public void the_data_tree_should_be_expanded() throws Throwable {
		CommonFunctionality.wait(2000);
		if (login.driver.findElement(By.xpath("//*[@title='Collapse tree']")).isDisplayed()) {
			login.Log4j.info("The data tree is expanded");
		} else {
			AssertJUnit.fail("The data tree is not expanded");
		}
	}

	@Then("^The data tree should be collapsed$")
	public void the_data_tree_should_be_collapsed() throws Throwable {
		CommonFunctionality.wait(3000);
		if (login.driver.findElement(By.xpath("//*[@title='Expand tree']")).isDisplayed()) {
			login.Log4j.info("The data tree is collapsed");
		} else {
			Assert.fail("The data tree is not collapsed");
		}

	}

	@Then("^\"([^\"]*)\" message should be displayed$")
	public void message_should_be_displayed(String arg1) throws Throwable {
		// Thread.sleep(2000);

		if (arg1.equalsIgnoreCase("Sorry, no results were found here.")) {
			login.Log4j.info("Clicking on  Series tab ");
			CommonFunctionality.getElementByProperty(login.driver, "Series", 10).click();
			CommonFunctionality.wait(5000);
			ele = login.driver.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]"));
			String noResults = ele.getText();
			if (ele.isDisplayed()) {
				login.Log4j.info(noResults + "is displayed for invalid Keyword ");
			} else {
				AssertJUnit.fail(noResults + "is not displayed for invalid Keyword ");
			}
		} else if (arg1.equalsIgnoreCase("URL link copied.")) {
			CommonFunctionality.ValidateGrowlText(arg1);

		} else if (arg1.equalsIgnoreCase("Commentary copied.") || arg1.equalsIgnoreCase("Data pasted from clipboard")
				|| arg1.equalsIgnoreCase("Attachments copied.")) {
			CommonFunctionality.wait(2000);
			CommonFunctionality.ValidateGrowlText(arg1);
			CommonFunctionality.DeleteVisual();
		} else {
			// upload pdf format for histogram
			ele = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='growl-message-text']", 8);
			String GrowlText = ele.getText();
			login.Log4j.info(GrowlText);
			if (GrowlText.trim().equalsIgnoreCase(
					"Selected file is not accepted. You can select any file of this types: image/jpeg, image/jpg, image/png, image/gif")) {
				login.Log4j.info(GrowlText + " is displayed for pdf format");
			} else {
				Assert.fail(GrowlText + " is not displayed for pdf format");
			}
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
			CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 6).click();
			// CommonFunctionality.Views_list();
		}

	}

	@Given("^Right click on any database$")
	public void right_click_on_any_database() throws Throwable {
		
		rightClickElement = CommonFunctionality.getElementByProperty(login.driver,
				"GlobalDB_Text", 8);
		String str = rightClickElement.getText();
		login.Log4j.info(str);
		// contextClick() method to do right click on the element
		action.pause(1000).contextClick(rightClickElement).build().perform();
	}

	@Then("^\"([^\"]*)\" options should be available$")
	public void options_should_be_available(String arg1) throws Throwable {
		String[] array = arg1.split(",");
				
		WebElement ul_element = CommonFunctionality.getElementBycssSelector(login.driver, ".context-menu", 8);
		String rightClick_str = ul_element.getText();
		login.Log4j.info(rightClick_str);
		if (array.length == 7) {
			if (rightClick_str.contains(array[0]) == true && rightClick_str.contains(array[1]) == true
					&& rightClick_str.contains(array[2]) == true && rightClick_str.contains(array[3]) == true && rightClick_str.contains(array[4]) == true && rightClick_str.contains(array[5]) == true && rightClick_str.contains(array[6]) == true ) {
				login.Log4j.info(array[0] + " AND " + array[1] + " AND " + array[2]+ " AND " + array[3]+ " AND " + array[4]+ " AND " + array[5]+ " AND " + array[6]
						+ " options available for right click option for DB level");

			} else {
				AssertJUnit.fail(array[0] + " AND" + array[1] + " AND" + array[2]+ " AND " + array[3]+ " AND " + array[4]+ " AND " + array[5]+ " AND " + array[6]
						+ " options not available for right click option for DB level");
			}
		} else if (array.length == 6) {
			if (rightClick_str.contains(array[0]) == true && rightClick_str.contains(array[1]) == true && rightClick_str.contains(array[2]) == true && rightClick_str.contains(array[3]) == true && rightClick_str.contains(array[4]) == true && rightClick_str.contains(array[5]) == true ) {
				login.Log4j.info(array[0] + " AND " + array[1] + " AND " + array[2]+ " AND " + array[3]+ " AND " + array[4]+ " AND " + array[5]
						+ " options available for right click option for DB level");

			} else {
				AssertJUnit.fail(array[0] + " AND" + array[1] + " options not available for right click option ");
			}
		} else {
			Assert.fail("List of Right click options size is not matched");
		}
		// CommonFunctionality.CollapseTreeMethod();

	}

	@And("^After loaded the results ,click on Remove for search keyword$")
	public void after_loaded_the_results_click_on_Remove_for_search_keyword() throws Throwable {
		AfterMethod();
		login.Log4j.info("After search with keyword,the series count is: " + afterFilter);

	}

	@Then("^The result should be loaded without search$")
	public void the_result_should_be_loaded_without_search() throws Throwable {

		/*
		 * WebElement searchInputButton = login.driver.findElement(By.
		 * className("search-input-field--item search-input-button"));
		 * action.moveToElement(searchInputButton).build().perform();
		 * CommonFunctionality.getElementByClassName(login.driver,
		 * "search-input-field-wrap-inner--clear-button" ,4).click();
		 */
		CommonFunctionality.ResetMethod();
		BeforeMethod();
		login.Log4j.info("Before searching with keyword,the series count is : " + beforeFilter);
		if (beforeFilter > afterFilter) {
			login.Log4j.info("The result is loaded without search");
		} else {
			AssertJUnit.fail("The result is not loaded without search");
		}
		CommonFunctionality.ExpandLeft();
	}

	@And("^Right click on \"([^\"]*)\"$")
	public void right_click_on(String arg1) throws Throwable {
		try {
			CommonFunctionality.getElementByProperty(login.driver, "collapse_databriefings", 10).click();
		} catch (Exception e) {

		}
		CommonFunctionality.getElementByProperty(login.driver, "Databases_Tab", 10).click();
		dbase = arg1;
		switch (arg1) {
		case "World Trend Plus":
			// login.driver.navigate().refresh();
			Thread.sleep(5000);
			rightClickElement = login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]"));
			Before_set_lang = rightClickElement.getText();
			break;
		case "Russia Premium Database":
			// login.driver.navigate().refresh();
			Thread.sleep(5000);
			rightClickElement = login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]"));
			Before_set_lang = rightClickElement.getText();
			break;
		case "Indonesia Premium Database":
			// login.driver.navigate().refresh();
			Thread.sleep(5000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_IndonesiaPremiumDB"))).click();
			Thread.sleep(2000);
			ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
					"Indonesia_NationalAccount")));
			Before_set_lang = ele.getText();
			rightClickElement = login.driver.findElement(
					By.xpath("//div[@data-node-model-id='INDONESIA']//span[contains(text(),'" + arg1 + "')]"));
			break;
		case "Global Database":
			CommonFunctionality.wait(2000);
			WebElement obj = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("GlobalDB_1stSeries")));
			Before_set_lang = obj.getText();
			rightClickElement = login.driver.findElement(
					By.xpath("//div[@data-node-model-id='GLOBAL']//span[contains(text(),'" + arg1 + "')]"));
			break;
		default:
			AssertJUnit.fail("Doesn't exist in given databse list");
		}
		login.Log4j.info("Before_set_lang is " + Before_set_lang);
		CommonFunctionality.wait(2000);
		// contextClick() method to do right click on the element
		action.pause(200).contextClick(rightClickElement).build().perform();

	}

	@SuppressWarnings("deprecation")
	@And("^\"([^\"]*)\" as \"([^\"]*)\"$")
	public void as(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(2000);
		ele = login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]"));
		action.pause(2000).moveToElement(ele).click().build().perform();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'" + arg2 + "')]")).click();

	}

	@SuppressWarnings("deprecation")
	@Then("^The Databases language should be changed to selected language$")
	public void the_Databases_language_should_be_changed_to_selected_language() throws Throwable {

		WebElement dbele;
		CommonFunctionality.wait(1000);
		if (dbase.equalsIgnoreCase("World Trend Plus")) {
			dbele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("WTD_DB")));
			After_set_lang = dbele.getText();
			login.Log4j.info("After_set_lang is " + After_set_lang);
			database = true;
			// After validation changing set language as English
			action.pause(2000).contextClick(dbele).build().perform();

		} else if (dbase.equalsIgnoreCase("Russia Premium Database")) {
			dbele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
					"Russia_DB")));
			After_set_lang = dbele.getText();
			login.Log4j.info("After_set_lang is " + After_set_lang);
			database = true;
			// After validation changing set language as English
			action.pause(1500).contextClick(dbele).build().perform();

		} else if (dbase.equalsIgnoreCase("Global Database")) {
			dbele = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("GlobalDB_1stSeries")));
			After_set_lang = dbele.getText();
			login.Log4j.info("After_set_lang is " + After_set_lang);
			database = true;
			// After validation changing set language as English
			action.pause(1500).contextClick(rightClickElement).build().perform();

		} else {
			// login.driver.findElement(By.xpath("//div[@data-node-model-id='INDONESIA']//div[@class='toggle']")).click();
			dbele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
					"Indonesia_NationalAccount")));
			After_set_lang = dbele.getText();
			login.Log4j.info("After_set_lang is " + After_set_lang);
			database = true;
			// After validation changing set language as English
			CommonFunctionality.wait(2000);
			WebElement rightClickEle = login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
					"IndonesiaDB")));
			action.pause(2000).contextClick(rightClickEle).build().perform();
		}
		SetLangugeEnglish();
		if (database == true && !Before_set_lang.equals(After_set_lang) == true) {
			login.Log4j.info(Before_set_lang + " is changed as " + After_set_lang);
		} else {
			AssertJUnit.fail("The Databases language is not changed to selected language");
		}
		// CommonFunctionality.CollapseTreeMethod();
	}

	@And("^Mouse hover on any topic level of data$")
	public void mouse_hover_on_any_topic_level_of_data() throws Throwable {
		// CommonFunctionality.CollapseTreeMethod();
		// mouse hover on Global key series Database topic level
		CommonFunctionality.getElementByProperty(login.driver,
				"Expand_GlobalKeySeriesDB", 10).click();
		CommonFunctionality.wait(1000);
		ele = CommonFunctionality.getElementByProperty(login.driver,
				"GlobalKeyDB_Afganistan", 10);
		ExpectedResult = ele.getText();

	}

	@SuppressWarnings("deprecation")
	@Then("^\"([^\"]*)\" should be available$")
	public void should_be_available(String arg1) throws Throwable {

		MouseHoverAction = arg1;
		action.pause(1000).moveToElement(ele).click().build().perform();
		CommonFunctionality.wait(2000);
		switch (arg1) {
		case "Copy link(s)":
			
			copy_link = login.driver.findElement(
					By.xpath("//div[3]//*[@class='tree-node active']//*[@class='actions']//*[@title='Copy link(s)']"));
			CommonFunctionality.wait(2000);
			copy_link.click();
			login.Log4j.info("Clicking on " + arg1);
			break;
		case "Footnotes":
			footnote = login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
					"FootNotes_topicLevel")));
			login.Log4j.info("Clicking on " + arg1);
			break;
		case "+":
			AddIcon = login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
					"AddIcon_TableLevel")));
			login.Log4j.info("Clicking on " + arg1);

			break;
		default:

		}
	}


	@When("^click on it$")
	public void click_on_it() throws Throwable {
		if (MouseHoverAction.equals("Footnotes")) {
			if (footnote.isDisplayed()) {
				Thread.sleep(1000);
				footnote.click();
			}
		} else if (MouseHoverAction.equals("+")) {
			if (AddIcon.isDisplayed()) {
				Thread.sleep(1000);
				AddIcon.click();
			}
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Right click on any topic level of data$")
	public void right_click_on_any_topic_level_of_data() throws Throwable {
		// login.driver.navigate().refresh();
		mouse_hover_on_any_topic_level_of_data();
		action.pause(1000).contextClick(ele).build().perform();
	}

	@And("^\"([^\"]*)\" option should be available$")
	public void option_should_be_available(String arg1) throws Throwable {
		MouseHoverAction = arg1;
		if (arg1.equalsIgnoreCase("Copy link(s)")) {
			copy_link = login.driver
					.findElement(By.xpath("//div[@class='items-wrapper']//span[@title='" + arg1 + "']"));
			Thread.sleep(2000);
			copy_link.click();
			login.Log4j.info("Clicking on " + arg1);
		} else if (arg1.equalsIgnoreCase("Footnotes")) {
			footnote = login.driver.findElement(By.xpath("//div[@class='items-wrapper']//span[@title='" + arg1 + "']"));
			login.Log4j.info("Clicking on " + arg1);
		}
	}

	@And("^Mouse hover on any Section level of data$")
	public void mouse_hover_on_any_Section_level_of_data() throws Throwable {
		// CommonFunctionality.CollapseTreeMethod();
		// mouse hover on Markit Purchasing Managers' Index for section level
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Expand_GlobalPurchasingManagersIndexDB"))))
				.click();
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByProperty(login.driver,
				"Expand_GlobalPurchasingManagersIndexDB_topicLevel", 8).click();
		CommonFunctionality.wait(500);
		ele = CommonFunctionality.getElementByProperty(login.driver,
				"MouseHover_GPM_sectionLevel", 8);
		ExpectedResult = ele.getText();

	}

	@SuppressWarnings("deprecation")
	@And("^Right click on any section level of data$")
	public void right_click_on_any_section_level_of_data() throws Throwable {
		mouse_hover_on_any_Section_level_of_data();
		action.pause(1000).contextClick(ele).build().perform();
	}

	@Then("^The link should be copied$")
	public void the_link_should_be_copied() throws Throwable {
		Thread.sleep(2000);
		Clipboard_data = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
		if (Clipboard_data != null) {
			login.Log4j.info(Clipboard_data);
			login.Log4j.info("The entire database link is copied to clipboard");
		} else {
			login.Log4j.info("The entire database link is not copied to clipboard");
		}
	}

	@And("^Select multiple tables$")
	public void select_multiple_tables() throws Throwable {
		// mouse hover on China Premium Database for table level
		// CommonFunctionality.UnselectMethod();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Databases_Tab"))).click();
		wait = new WebDriverWait(login.driver, 5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(login.LOCATORS.getProperty("Expand_ChinaDB")))).click();
		CommonFunctionality.wait(2000);
		login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty(
						"Expand_ChinaTopicLevel")))
				.click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
				"Expand_chinaSectionLevel")))
				.click();
		CommonFunctionality.wait(2000);
		/*List<WebElement> tableLevel = login.driver.findElements(By.xpath(
				"//div[@class='child-container']//div[@data-node-model-id='CN']//div[1]//div[1]//div[3]//div//div[@class='title']"));
		login.Log4j.info("Total number of tables " + tableLevel.size());
		for (int i = 0; i < tableLevel.size(); i++) {
			login.Log4j.info(i);
			int j = i + 1;
			wait(1500);
			checkbox = login.driver.findElement(By.xpath(
					"//div[@class='child-container']//div[@data-node-model-id='CN']//div[1]//div[1]//div[3]//div[" + j
							+ "]//div[@class='title']//span[@class='svg-checkbox']"));
			checkbox.click();
			wait(500);
			ele = login.driver.findElement(By.xpath("//*[contains(@class,'open last-open-node')]/*[3]/*[" + j
					+ "]//*[@class='name']//*[@class='name-text']"));
			ExpectedTableName.add(ele.getText());
			if (i == 2) {
				ele = login.driver.findElement(By.xpath(
						"//div[@class='child-container']//div[@data-node-model-id='CN']//div[1]//div[1]//div[3]//div["
								+ j + "]//div[@class='title']"));
				action.moveToElement(ele).build().perform();
				selected_table_size = j;
				break;
			}
		}*/
		
		for (int i = 13; i < 16; i++) {
			login.Log4j.info(i);
			
			CommonFunctionality.wait(1500);
			checkbox = login.driver.findElement(By.xpath(
					"//*[@class='database-representation--tree']/*[1]/*[1]/*[1]/*[1]/*[1]/*[1]/*["+ i +"]//span[@class='svg-checkbox']"));
			checkbox.click();
			CommonFunctionality.wait(500);
			ele = login.driver.findElement(By.xpath("//*[@class='database-representation--tree']/*[1]/*[1]/*[1]/*[1]/*[1]/*[1]/*["+ i +"]//*[@class='name-text']"));
			ExpectedTableName.add(ele.getText());
			if (i == 15) {
				ele = login.driver.findElement(By.xpath(
						"//*[@class='database-representation--tree']/*[1]/*[1]/*[1]/*[1]/*[1]/*[1]/*["+ i +"]//div[@class='title']"));
				action.moveToElement(ele).build().perform();
				selected_table_size = 16 - 13;
				break;
			}
		}
	}

	@Then("^The links should be generated for selected tables$")
	public void the_links_should_be_generated_for_selected_tables() throws Throwable {
		ele = login.driver.findElement(By.xpath("//div[@class='growl-message-text']"));
		String linkCopied = ele.getText();
		login.Log4j.info(linkCopied);
		// AssertJUnit.assertEquals(true, ele.isDisplayed());
		String selected_tableCount = String.valueOf(selected_table_size);

		if (linkCopied.contains(selected_tableCount)) {
			login.Log4j.info("Links are generated for selected multiple tables");
		} else {
			Assert.fail("Links are not generated for selected multiple tables");
		}
		// CommonFunctionality.CollapseTreeMethod();
	}

	@Then("^Multiple table's link should be copied to clipboard and open respective \"([^\"]*)\" should be highlighted when run links one by one in browser$")
	public void multiple_table_s_link_should_be_copied_to_clipboard_and_open_respective_should_be_highlighted_when_run_links_one_by_one_in_browser(
			String arg1) throws Throwable {
		// Create instance of Clipboard class
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Clipboard_data = (String) clipboard.getData(DataFlavor.stringFlavor);
		login.Log4j.info(Clipboard_data);
		String[] textArea = Clipboard_data.split("\\n");
		int j = 0;
		if (selected_table_size == textArea.length) {
			for (String line : textArea) {
				login.Log4j.info(line);
				// Set the String to Enter
				StringSelection stringSelection = new StringSelection(line);
				// Copy the String to Clipboard
				clipboard.setContents(stringSelection, null);
				paste_it_in_new_tab();

				try {
					WebElement highlightdtext = CommonFunctionality.getElementByXpath(login.driver,
							"//*[contains(@class,'full-expanded open highlight') or contains(@class,'last-open-node highlight')]",
							20);
					if (highlightdtext.isDisplayed()) {

						String actualText = CommonFunctionality.getElementByXpath(login.driver,
								"//*[contains(@class,'full-expanded open highlight') or contains(@class,'last-open-node highlight')]/*[2]//*[@class='name-text']",
								20).getText();
						for (int i = j; i < ExpectedTableName.size();) {
							login.Log4j.info(ExpectedTableName.get(i));
							if (ExpectedTableName.get(i).equalsIgnoreCase(actualText)) {
								login.Log4j.info("The selected " + arg1
										+ " is highlighted for right click /mouse hover actions");
								j = i + 1;
								break;
							} else {
								AssertJUnit.fail("The selected " + arg1
										+ " is not highlighted for right click /mouse hover actions");
							}

						}
					}
					login.driver.close();
					login.driver.switchTo().window(tabs2.get(0));
					// CommonFunctionality.CollapseTreeMethod();

				} catch (Exception e) {
					login.driver.close();
					login.driver.switchTo().window(tabs2.get(0));
					AssertJUnit.fail(e.getMessage());
				}

			}
		} else {
			Assert.fail("size is mismatched");
		}
	}

	@Then("^The entire table should be added to my series$")
	public void the_entire_table_should_be_added_to_my_series() throws Throwable {
		login.Log4j.info(Validationstr);
		Thread.sleep(5000);
		WebElement tableName = login.driver.findElement(By.className("group-name"));
		Thread.sleep(3000);
		String actualStr = tableName.getText();
		login.Log4j.info(actualStr);
		AssertJUnit.assertEquals(actualStr, Validationstr);
	
	}


	@And("^Click on dropdown next to \\+ icon$")
	public void click_on_dropdown_next_to_icon() throws Throwable {
		ele.click();
		Thread.sleep(2000);
		robot = new Robot(); // creating table
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_T);
		Thread.sleep(1000);
		WebElement dropDown_icon = login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
				"DropDown_icon")));
		dropDown_icon.click();

	}

	@Then("^The dropdown should be opened with these items \"([^\"]*)\"$")
	public void the_dropdown_should_be_opened_with_these_items(String arg1) throws Throwable {
		String[] dropdownStr = arg1.split(",");
		Thread.sleep(3000);
		WebElement dropdownList = login.driver.findElement(By.className("items-wrapper"));
		String dropdownText = dropdownList.getText();
		login.Log4j.info(dropdownText);
		if (dropdownText.contains(dropdownStr[0]) == true && dropdownText.contains(dropdownStr[1]) == true
				&& dropdownText.contains(dropdownStr[2]) == true && dropdownText.contains(dropdownStr[3]) == true
				&& dropdownText.contains(dropdownStr[4]) == true) {
			login.Log4j.info(dropdownStr[0] + " AND " + dropdownStr[1] + " AND " + dropdownStr[2] + " AND "
					+ dropdownStr[3] + " AND " + dropdownStr[4] + " are available in dropdown on table level");
			CommonFunctionality.DeleteVisual();
			CommonFunctionality.DeleteSeries();
		} else {
			AssertJUnit.fail(dropdownStr[0] + " AND " + dropdownStr[1] + " AND " + dropdownStr[2] + " AND "
					+ dropdownStr[3] + " AND " + dropdownStr[4] + " are not available in dropdown on table level");
		}
	}

	
	@And("^Click on dropdown icon$")
	public void click_on_dropdown_icon() throws Throwable {
		// Thread.sleep(5000);
		ele.click();
		WebElement dropdown = null;
		login.Log4j.info("Clicking on dropdown icon");
		try {
			// Clicking on drop down on table level for Brazil premium db
			dropdown = login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
					"DropDown_icon")));

		} catch (Exception e) {
			// Clicking on drop down on table level for China premium db
			dropdown = login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
					"DropDown_icon")));
		}
		Thread.sleep(1000);
		dropdown.click();

	}

	@SuppressWarnings("deprecation")
	@And("^Select \"([^\"]*)\" option$")
	public void select_option(String arg1) throws Throwable {
		// Thread.sleep(5000);
		login.Log4j.info("Clicking on dropdown icon");
		try {
			ele.click();
			// clicking on dropdown for table level
			WebElement dropdown = login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
					"DropDown_icon")));
			dropdown.click();
		} catch (Exception e) {
			// clicking on dropdown for series level
			Thread.sleep(1000);
			ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
					"DropDownIcon_SeriesLevel")));
			action.moveToElement(ele).pause(1000).click().build().perform();

		}
		login.Log4j.info("Clicking on " + arg1);
		Thread.sleep(3000);
		login.driver
				.findElement(By.xpath("//div[@class='items-wrapper']//li[1]//span[contains(text(),'" + arg1 + "')]"))
				.click();
	}

@And("^Select \"([^\"]*)\" option at series level$")
public void select_option_at_series_level(String arg1) throws Throwable {
	login.Log4j.info("Clicking on dropdown icon");
	Thread.sleep(1000);
	ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
			"DropDownIcon_SeriesLevel")));
	action.moveToElement(ele).pause(1000).click().build().perform();
	login.Log4j.info("Clicking on " + arg1);
	Thread.sleep(3000);
	login.driver
			.findElement(By.xpath("//div[@class='items-wrapper']//li[1]//span[contains(text(),'" + arg1 + "')]"))
			.click();

}
	@Given("^Create a visual and Mouse hover on any table$")
	public void create_a_visual_and_Mouse_hover_on_any_table() throws Throwable {
		mouse_hover_on_any_table_level();
		Thread.sleep(2000);
		// check the table
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SelectTable")))
				.click();
		robot = new Robot();
		// creating table
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_T);
		CommonFunctionality.SeriesHormonizationWindowClose();
		Thread.sleep(3000);
		// Reading the series from the created table before replacing with the other
		// table
		WebElement element = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TableSname1")));
		beforeReplace_sname1 = element.getText();
		login.Log4j.info("Before Replacement series1: " + beforeReplace_sname1);
		WebElement element1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TableSname2")));
		beforeReplace_sname2 = element1.getText();
		login.Log4j.info("Before Replacement series2: " + beforeReplace_sname2);
		CommonFunctionality.CollapseTreeMethod();
		// Replacing the table
		MoreFilterNotApplied_BRAZILPremiumDB();
	
		ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
				"BrazilDB_TableNAme")));
		

	}

	@Then("^The selected table data should be replaced with existing data on the visual$")
	public void the_selected_table_data_should_be_replaced_with_existing_data_on_the_visual() throws Throwable {
		// Getting series from the replaced table
		Thread.sleep(3000);
		WebElement element = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TableSname1")));
		afterReplace_sname1 = element.getText();
		login.Log4j.info("After Replacement series1: " + afterReplace_sname1);
		WebElement element1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TableSname2")));
		afterReplace_sname2 = element1.getText();
		login.Log4j.info("After Replacement series2: " + afterReplace_sname2);
		if (!beforeReplace_sname1.equals(afterReplace_sname1) == true
				&& !beforeReplace_sname2.equals(afterReplace_sname2) == true) {
			login.Log4j.info("The selected table data replaced with existing data for Add and replace");
			CommonFunctionality.Views_list();
		} else {
			AssertJUnit.fail("The selected table data not replaced with existing data for Add and replace");
		}
		
	}

	@Then("^Selected table should be added as group in My series$")
	public void selected_table_should_be_added_as_group_in_My_series() throws Throwable {
		the_entire_table_should_be_added_to_my_series();
	}

	@Then("^The new insight should be created with selected data$")
	public void the_new_insight_should_be_created_with_selected_data() throws Throwable {
		Thread.sleep(1000);
		WebElement growl_popup = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("confirm_popup")));
		if (growl_popup.isDisplayed()) {
			login.Log4j.info("Growl popup is displayed");
		} else {
			AssertJUnit.fail("Growl popup is not displayed");
		}
	}

	@Then("^Confirmation message should be displayed as below \"([^\"]*)\"$")
	public void confirmation_message_should_be_displayed_as_below(String arg1) throws Throwable {
		Thread.sleep(2000);
		ele = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("growl_message_popup")));
		String confirm_msg = ele.getText();
		String[] confirmarr = confirm_msg.split("\n");
		login.Log4j.info(confirmarr[0]);
		AssertJUnit.assertEquals(confirmarr[0], arg1);
		login.Log4j.info(confirmarr[0] + " is displayed");

	}

	@Then("^The insight should be opened and added series should be available in My series$")
	public void the_insight_should_be_opened_and_added_series_should_be_available_in_My_series() throws Throwable {
		Thread.sleep(300);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("confirm_popup_new_insight"))).click();
		robot = new Robot();
		// Store all currently open tabs in tabs
		tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
		// Navigate to New Tab
		login.driver.switchTo().window(tabs2.get(1));
		Thread.sleep(3000);
		the_entire_table_should_be_added_to_my_series();
		login.driver.close();
		login.driver.switchTo().window(tabs2.get(0));
	}

	@Then("^The \"([^\"]*)\" button should be disabled by default and enable after any insight selection$")
	public void the_button_should_be_disabled_by_default_and_enable_after_any_insight_selection(String arg1)
			throws Throwable {
		Thread.sleep(2000);
		if (!login.driver.findElement(By.xpath("//button[contains(text(),'Add to insights')]")).isEnabled()) {
			login.Log4j.info(arg1 + " is disabled by default");
		} else {
			AssertJUnit.fail(arg1 + " is not disabled by default");
		}
		WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("second_insight")));
		ele.click();
		Thread.sleep(2000);
		if (login.driver.findElement(By.xpath("//button[contains(text(),'Add to insights')]")).isEnabled()) {
			login.Log4j.info(arg1 + " is enabled after insight selection");
		} else {
			AssertJUnit.fail(arg1 + " is not enabled after insight selection");
		}
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Downloadclose"))).click();
	}

	@Then("^The data should be added to My series for selected insight$")
	public void the_data_should_be_added_to_My_series_for_selected_insight() throws Throwable {
		/*
		 * Thread.sleep(2000); WebElement ele =
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty("second_insight"
		 * ))); ele.click(); Thread.sleep(2000); login.driver.findElement(By.
		 * xpath("//button[contains(text(),'Add to insights')]")).click();
		 */
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("confirm_popup_highlighted_insight")))
				.click();
		// login.Log4j.info(ele.getText());
		robot = new Robot();
		// Store all currently open tabs in tabs
		tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
		// Navigate to New Tab
		login.driver.switchTo().window(tabs2.get(1));
		Thread.sleep(3000);
		CommonFunctionality.ContinueSameInsight();
		the_entire_table_should_be_added_to_my_series();
		login.driver.close();
		login.driver.switchTo().window(tabs2.get(0));

	}

		@And("^Mouse hover on any table level$")
	public void mouse_hover_on_any_table_level() throws Throwable {
		// CommonFunctionality.ResetMethod();
		// mouse hover on China Premium Database for table level
		// CommonFunctionality.CollapseTreeMethod();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Databases_Tab"))).click();
		login.Log4j.info("mouse hovering on table level");

		try {
			CommonFunctionality.getElementByProperty(login.driver,
					"Expand_ChinaDB", 4).click();
			CommonFunctionality.getElementByProperty(login.driver,
					"Expand_ChinaTopicLevel", 4)
					.click();
			WebElement ele1 = CommonFunctionality.getElementByProperty(login.driver,
					"Expand_chinaSectionLevel",	4);
			ele1.click();
			
			//jse.executeScript("arguments[0].scrollIntoView(true);", ele1);
			ele = CommonFunctionality.getElementByProperty(login.driver,
					"ChinaDB_TableText",
					4);
			ExpectedResult = Validationstr = ele.getText();

		} catch (NoSuchElementException e) {
			CommonFunctionality.getElementByXpath(login.driver,
					"Expand_ChinaDB", 4).click();
		}
	}

	@And("^Select a table$")
	public void select_a_table() throws Throwable {
	
		mouse_hover_on_any_table_level();
	}

	@And("^Select multiple insights$")
	public void select_multiple_insights() throws Throwable {
		Thread.sleep(2000);
		insightVar = 0;
		List<WebElement> insights_list = login.driver.findElements(By.xpath(
				"//ul[@class='dropdown-menu']//li//*[@class='checkbox-control']//*[@class='input-control--description']"));
		login.Log4j.info(insights_list.size());
		for (int i = 0; i < insights_list.size(); i++) {
			Thread.sleep(800);
			int j = i + 1;
			insights_list.get(j).click();
			insightVar++;
			// login.Log4j.info(insightVar);
			if (i == 2) {
				break;
			}
		}
	}

	@Then("^The number of selected insights count should be shown on popup header$")
	public void the_number_of_selected_insights_count_should_be_shown_on_popup_header() throws Throwable {
		ele = login.driver.findElement(By.xpath("//span[@class='insights-search-modal-header--txt-counter']"));
		String str = ele.getText();
		login.Log4j.info(str);
		String str1 = str.replaceAll("\\(", "").replaceAll("\\)", "");
		String[] arr = str1.split("");
		int insightCount = Integer.parseInt(arr[0]);
		login.Log4j.info(insightCount);
		if (insightCount == insightVar) {
			login.Log4j.info("The number of selected insights count shown on popup header");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();

		} else {
			AssertJUnit.fail("The number of selected insights count is not shown on popup header");

		}
	}

	@Then("^\"([^\"]*)\" page should be opened in new tab$")
	public void page_should_be_opened_in_new_tab(String arg1) throws Throwable {
		tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs2.get(1));
		Thread.sleep(2000);
		if (login.driver.findElement(By.xpath("//div[contains(text(),'" + arg1 + "')]")).isDisplayed()) {
			login.Log4j.info("Insight Explorer page is opened ");
		} else {
			AssertJUnit.fail("Insight Explorer page is not opened");
		}
		login.driver.close();
		login.driver.switchTo().window(tabs2.get(0));
		// CollapseTreeMethod();
	}

	@Then("^The insight explorer popup should be closed$")
	public void the_insight_explorer_popup_should_be_closed() throws Throwable {

		try {
			if (!login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).isEnabled()) {
				login.Log4j.info("Insight explorer popup is closed ");
			}
		} catch (NoSuchElementException e) {
			login.Log4j.info("Insight explorer popup is closed ");
		}
		// CollapseTreeMethod();
	}

	@And("^Right click on any table level$")
	public void right_click_on_any_table_level() throws Throwable {
		// CommonFunctionality.CollapseTreeMethod();
		// CommonFunctionality.ResetMethod();
		// CommonFunctionality.SeriesHormonizationWindowClose();
		MoreFilterNotApplied_BRAZILPremiumDB();
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
				"BrazilDB_TableNAme")));
		ExpectedResult = tableName = ele.getText();
		Thread.sleep(2000);
		action.contextClick(ele).build().perform();
	}

		@And("^Select \"([^\"]*)\"$")
	public void select(String arg1) throws Throwable {
		visual = arg1;
		if (arg1.equals("Unselect all")) {
			// Thread.sleep(2000);
			// login.driver.findElement(By.xpath(
			// "//div[@class='child-container']//div[@data-node-model-id='BRAZIL']//div[1]//div[1]//div[3]//div[1]//div[@class='title']//span[@class='svg-checkbox']"))
			// .click();
			Thread.sleep(2000);
			try {
				WebElement count = login.driver.findElement(By.xpath("//span[@class='search-input--selected-count']"));
				beforeUnselct = Integer.parseInt(count.getText());
				login.Log4j.info(beforeUnselct);
				// action.contextClick(ele).build().perform();
				Thread.sleep(3000);
				login.Log4j.info(arg1);
				login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();
			} catch (NumberFormatException e) {
				login.Log4j.info(e.getMessage());
			}

		} else if (arg1.equalsIgnoreCase("Pie") || arg1.equalsIgnoreCase("Heat map")
				|| arg1.equalsIgnoreCase("Histogram")) {
			// Thread.sleep(2000);
			// action.contextClick(ele).build().perform();
			Thread.sleep(2000);
			// Mouse Hovering on View As
			WebElement viewAs = login.driver.findElement(By.xpath("//span[contains(text(),'View as ...')]"));
			action.moveToElement(viewAs).build().perform();
			Thread.sleep(2000);
			login.Log4j.info("Clicking on " + arg1);
			login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();
			try {
				if (arg1.equalsIgnoreCase("Histogram")) {
					Thread.sleep(1000);
					login.driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
				}
			} catch (NoSuchElementException e) {

			}

		} else if (arg1.equalsIgnoreCase("View as Chart") || arg1.equalsIgnoreCase("View as Map")
				|| arg1.equalsIgnoreCase("View as Table")) {
		
			Thread.sleep(3000);
			login.Log4j.info("Clicking on " + arg1);
			login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();
		} else if (arg1.equals("Download")) {
			
			Thread.sleep(3000);
			CommonFunctionality.SelectedSeriessCount();
			login.Log4j.info("Clicking on " + arg1);
			login.driver.findElement(By.xpath("//span[@title='" + arg1 + "']")).click();
		} else if (arg1.equals("Copy selected links") || arg1.equals("Footnotes") || arg1.equals("Show Dataset")
				|| arg1.equals("Copy") || arg1.equals("Copy data") || arg1.equals("Series Info")
				|| arg1.equals("See in Database")) {
	
			Thread.sleep(300);
			if (arg1.equals("See in Database")) {
				ele = login.driver.findElement(By.xpath("//div[@class='items-wrapper']//span[@title='" + arg1 + "']"));
				action.moveToElement(ele).build().perform();
				login.Log4j.info("Clicking on " + arg1);
				// when show database have multiple db's
				Thread.sleep(1000);
				List<WebElement> li_element = login.driver
						.findElements(By.xpath("//li[@class='dropdown-submenu active-menu-item']//ul"));
				// login.Log4j.info(li_element.size());
				if (li_element.size() > 0) {
					for (int i = 0; i < li_element.size(); i++) {
						int j = i + 1;
						Thread.sleep(1000);
						WebElement ele = login.driver.findElement(
								By.xpath("//li[@class='dropdown-submenu active-menu-item']//ul//li[" + j + "]"));
						WebElement element = login.driver.findElement(By.xpath(
								"//li[@class='dropdown-submenu active-menu-item']//ul//li[" + j + "]//span//span//b"));
						CommonFunctionality.db_name = element.getText();
						login.Log4j.info(CommonFunctionality.db_name);
						ele.click();
						if (j == 1) {
							break;
						}
					}
				}
			} else {
				CommonFunctionality.SelectedSeriessCount();
				login.driver.findElement(By.xpath("//div[@class='items-wrapper']//span[@title='" + arg1 + "']"))
						.click();
				login.Log4j.info("Clicking on " + arg1);
			}
		}
		if (arg1.equals("Pin to left")) {
			Thread.sleep(500);
			WebElement ele = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]",
					5);
			new Actions(login.driver).doubleClick(ele).build().perform();

		}
		if (arg1.equals("Total Usage")) {
			PopularSeriesMethod();
			Thread.sleep(2000);
			if (login.driver.findElement(By.xpath("//span[contains(text(),'Total Usage')]")).isDisplayed()) {
				TotalUsageValidation();
			} else {
				login.driver.findElement(By.xpath(
						"//div[@class='dashboard-filter']//div[@class='dashboard-filter-item'][1]//span[@class='dropdown--icon']"))
						.click();
				login.driver.findElement(By.xpath("//div[@title='Total Usage']")).click();
				TotalUsageValidation();
			}
		}
		if (arg1.equalsIgnoreCase("Insert row before") || arg1.equalsIgnoreCase("Insert row after")
				|| arg1.equalsIgnoreCase("Delete row") || arg1.equalsIgnoreCase("Row properties")
				|| arg1.equalsIgnoreCase("Cut row") || arg1.equalsIgnoreCase("Copy row")
				|| arg1.equalsIgnoreCase("Paste row before") || arg1.equalsIgnoreCase("Insert column before")
				|| arg1.equalsIgnoreCase("Insert column after") || arg1.equalsIgnoreCase("Delete column")) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 10).click();
		}
		if (arg1.equals("Name") || arg1.equals("Function description")) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='find-and-replace--attribute-selector']//option[contains(text(),'" + arg1 + "')]", 20)
					.click();
		} else if (arg1.equals("Region") || arg1.equals("Unit") || arg1.equals("Frequency")) {

			try {
				function = "Yearly (Sum)";
				CommonFunctionality.getElementByXpath(login.driver, "//ul//li//*[contains(text(),'" + arg1 + "')]", 6)
						.click();
				CommonFunctionality.getElementByXpath(login.driver, "//ul//li//*[@title='Yearly (Sum)']", 6).click();
			} catch (Exception e) {
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='multi-select-config']//ul//li[@class='select2-search-field']", 20).click();
				CommonFunctionality.getElementByXpath(login.driver,
						"//ul[@class='select2-results']//div[contains(text(),'" + arg1 + "')]", 20).click();
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='find-and-replace--attribute-selector']//option[contains(text(),'" + arg1 + "')]",
						20).click();
			}

		}
		if (arg1.equals("Rename")) {
			CommonFunctionality.getElementByXpath(login.driver, "//ul//li//*[contains(text(),'" + arg1 + "')]", 6)
					.click();
		}
		if (arg1.equals("Change")) {
			Change = arg1;
			CommonFunctionality.getElementByXpath(login.driver, "//ul//li//*[contains(text(),'" + arg1 + "')]", 6)
					.click();
			CommonFunctionality.getElementByXpath(login.driver, "//ul//li//*[@title='% Year-over-Year (%YoY)']", 6)
					.click();
		}
		if (arg1.equals("Color")) {
			CommonFunctionality.getElementByXpath(login.driver, "//ul//li//*[contains(text(),'" + arg1 + "')]", 6)
					.click();
			WebElement ColorEle = CommonFunctionality.getElementByProperty(login.driver, "BlueColor", 20);
			ActualColor = ColorEle.getCssValue("background-color");
			ColorEle.click();
		}
		if (arg1.equals("Currency")) {
			CommonFunctionality.getElementByXpath(login.driver, "//ul//li//*[contains(text(),'" + arg1 + "')]", 6)
					.click();
			Applied_currency = CommonFunctionality
					.getElementByXpath(login.driver, "//ul[@class='dropdown-menu']//li//*[@title='RMB']", 6).getText();
			CommonFunctionality.getElementByXpath(login.driver, "//ul[@class='dropdown-menu']//li//*[@title='RMB']", 6)
					.click();
		}
		if (arg1.equals("Matches only") || arg1.equals("Select All")
				|| arg1.equalsIgnoreCase("Keep different frequencies")) {
			CommonFunctionality.wait(2000);
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 10).click();
		}
		if (arg1.equalsIgnoreCase("Rename view") || arg1.equalsIgnoreCase("Duplicate view")
				|| arg1.equalsIgnoreCase("Clear view") || arg1.equalsIgnoreCase("Delete view")
				|| arg1.equalsIgnoreCase("Delete all views") || arg1.equalsIgnoreCase("Copy view")
				|| arg1.equalsIgnoreCase("Delete all views") || arg1.equalsIgnoreCase("Paste visual")) {
			CommonFunctionality.wait(1000);
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='items-wrapper']/li/span[@title='" + arg1 + "']", 20)
					.click();
		}
		if (arg1.equals("State Administrative")) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 6).click();
		}
		if (arg1.equalsIgnoreCase("Add Forecasts") || arg1.equalsIgnoreCase("Replace the current series")
				|| arg1.equalsIgnoreCase("Calculate series") || arg1.equalsIgnoreCase("General Election")) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg1 + "']", 6).click();
		}
		if (arg1.equalsIgnoreCase("State Administrative")) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[@title=' " + arg1 + "']", 6).click();
		}

	}

	@Then("^\"([^\"]*)\" should be created with series in views panel$")
	public void should_be_created_with_series_in_views_panel(String arg1) throws Throwable {
		CommonFunctionality.SeriesHormonizationWindowClose();
		Thread.sleep(2000);
		if (arg1.equalsIgnoreCase("Table")) {
			ele = login.driver.findElement(By
					.xpath("//*[@class='visual-title visual-title--wrapper']//span[contains(text(),'" + arg1 + "')]"));
		} else if (arg1.equalsIgnoreCase("Histogram")) {
			ele = login.driver.findElement(By.xpath("( //*[@class='visual-title--text text-dots'])[1]"));

		} else {
			ele = login.driver.findElement(
					By.xpath("(//*[contains(@class,'visual-title--wrapper')])[1]//*[contains(text(),'" + arg1 + "')]"));
		}

		String VisualTitle = ele.getText();
		login.Log4j.info(VisualTitle);
		// Thread.sleep(2000);
		if (arg1.equalsIgnoreCase(VisualTitle)) {
			login.Log4j.info(arg1 + " visual is created");
			CommonFunctionality.Views_list();
		} else if (!arg1.equalsIgnoreCase(VisualTitle)) {
			login.Log4j.info(tableName);
			if (tableName.contains(VisualTitle)) {
				login.Log4j.info(arg1 + " visual is created");
				CommonFunctionality.Views_list();
			}
		} else {
			AssertJUnit.fail(arg1 + " visual is not created");
		}
		// UnselectMethod();
	}

	@And("^Right click on any table level and select more than max series$")
	public void right_click_on_any_table_level_and_select_more_than_max_series() throws Throwable {
		//CommonFunctionality.CollapseTreeMethod();
		MoreFilterNotApplied_BRAZILPremiumDB();
		//select any table which have more than 20 series
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
				"SelectSecondTable_BrazilDB")));
		Thread.sleep(2000);
		action.contextClick(ele).build().perform();
	}

	@Then("^\"([^\"]*)\" window should be displayed$")
	public void window_should_be_displayed(String arg1) throws Throwable {
		ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Confirmation")));
		String Confirm_popup = ele.getText();
		if (arg1.equalsIgnoreCase(Confirm_popup)) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closebuttoninpopup"))).click();
			login.Log4j.info("Confirmation window is displayed");
		} else {
			AssertJUnit.fail("Confirmation window is not displayed");
		}

	}

	@Then("^Confirmation window should display with \"([^\"]*)\"$")
	public void confirmation_window_should_display_with(String arg1) throws Throwable {
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]"));
		String Confirm_msg = ele.getText();

		if (Confirm_msg.contains(arg1)) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closebuttoninpopup"))).click();
			login.Log4j.info(Confirm_msg + " is displayed");
		} else {
			AssertJUnit.fail(Confirm_msg + " is not displayed");
		}
	}

	@Then("^\"([^\"]*)\" visual should be created with max series$")
	public void visual_should_be_created_with_max_series(String arg1) throws Throwable {
		Thread.sleep(5000);
		ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ChartTitleName")));
		String VisualTitle = ele.getText();
		login.Log4j.info("Chart title is " + VisualTitle);
		Thread.sleep(2000);
		if (arg1.equalsIgnoreCase(VisualTitle)) {
			login.Log4j.info(arg1 + " visual is created");
			CommonFunctionality.Views_list();
		} else if (ele.isDisplayed()) {
			login.Log4j.info(arg1 + " visual is created");
			CommonFunctionality.Views_list();
		} else {
			AssertJUnit.fail(arg1 + " visual is not created");
		}
	}

	@Then("^Download window should be appeared with selected series count$")
	public void download_window_should_be_appeared_with_selected_series_count() throws Throwable {
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Downloadpopup")));
		String downloadTitle = ele.getText();
		login.Log4j.info(downloadTitle);
		String countStr = String.valueOf(CommonFunctionality.SeriesCount);
		login.Log4j.info(countStr);
		if (downloadTitle.contains(countStr)) {
			// if (downloadTitle.substring(SeriesCount) != null) {
			login.Log4j.info("Download window is displayed with selected series count");
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Downloadclose"))).click();

		} else {
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Downloadclose"))).click();
			AssertJUnit.fail("Download window is not displayed with selected series count");
		}
		// TC-158,159[closing search selection window]

		try {
			close_search_selection_window();
		} catch (Exception e) {

		}
		// CommonFunctionality.UnselectMethod();
	}

	@Then("^All the series under the table should be shown$")
	public void all_the_series_under_the_table_should_be_shown() throws Throwable {
		Thread.sleep(2000);
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Backbutton"))).isDisplayed()) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Backbutton"))).click();
			login.Log4j.info("Show Dataset is working for table level");
		} else {
			AssertJUnit.fail("Show Dataset is not working for table level");
		}
	}

	@And("^Clear the applied filters$")
	public void clear_the_applied_filters() throws Throwable {
		CommonFunctionality.ResetMethod();
	}

	@And("^Select Matches only$")
	public void select_Matches_only() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MatchesOnly"))).click();
	}

	@And("^Expand till table level$")
	public void expand_till_table_level() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ExpandAllRegions_GolbalDB")))
				.click();
		login.Log4j.info("Clicking on Topic level");
		Thread.sleep(2000);
		login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty(
						"ExpandAfganistan_GlobalDB")))
				.click();
		login.Log4j.info("Clicking on Section level");
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
				"ExpandAfganistan_NationalAccounts_GlobalDB")))
				.click();

	}

	@Then("^\"([^\"]*)\" icon should be displayed in table level$")
	public void icon_should_be_displayed_in_table_level(String arg1) throws Throwable {

		Thread.sleep(2000);
		List<WebElement> table_list = login.driver.findElements(
				By.xpath("//div[contains(@class,'open last-open-node')]//following::*[contains(@style,'padding-left')][1]//*[contains(@class,'status-icon')]"));
		login.Log4j.info("List of tables : " + table_list.size());
	if(table_list.size() > 0) {
		for (int i = 0; i < table_list.size(); i++) {
			//int j = i + 1;
			ele = login.driver.findElement(
					By.xpath("//div[contains(@class,'open last-open-node')]//following::*[contains(@style,'padding-left')][1]//div[@class='tree-node']"));
			String newStr = ele.getText();
			login.Log4j.info(newStr);
			if (newStr.contains(arg1)) {
				Thread.sleep(3000);
				// clicking on series level
				login.driver.findElement(By.xpath(
						"//div[contains(@class,'open last-open-node')]//following::*[contains(@style,'padding-left')][1]//div[@class='tree-node']//div[@class='toggle']"))
						.click();
				login.Log4j.info(arg1 + " icon is displaying for table level");
				break;
			} else {
				AssertJUnit.fail(arg1 + " icon is not displaying for table level");
			}
		}
	}else {
		Assert.fail("Table size is zero");
	}
		Thread.sleep(2000);
		//WebElement ul_element = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("UL")));
		List<WebElement> li_All = login.driver
				.findElements(By.xpath("//div[@unselectable='on']//span[@class='status-icon--sign']"));
		login.Log4j.info("List size is :" + li_All.size());
		for (int i = 0; i < li_All.size(); i++) {
			Thread.sleep(3000);
			login.Log4j.info(i);
			login.Log4j.info(li_All.size());
			// int j = i + 1;
			try {
				ele = li_All.get(i);

			} catch (NoSuchElementException e) {
				login.Log4j.error("Series name is null");
				int j = i + 1;
				ele = li_All.get(j);

			} finally {
				// Until the element is not visible keep scrolling
				// jse.executeScript("arguments[0].scrollIntoView(true);", ele);
				String New_icon = ele.getText();
				if (New_icon.equalsIgnoreCase(arg1) == true) {
					login.Log4j.info(arg1 + " icon is shown for series level");
				} else {
					AssertJUnit.fail(arg1 + " icon is not shown for series level");

				}
			}
		}
		// CommonFunctionality.TopMethod();
		// CommonFunctionality.ResetMethod();
		// CommonFunctionality.CollapseTreeMethod();

	}

	@SuppressWarnings("deprecation")
	@And("^Press A on keyboard$")
	public void press_A_on_keyboard() throws Throwable {
		CommonFunctionality.TopMethod();
		checkbox = CommonFunctionality.getElementByProperty(login.driver,
				"ChinaDB_Table_checkBox",
				20);
		action.pause(300).moveToElement(checkbox).click().build().perform();
		robot = new Robot();
		// Adding table to Myseries
		robot.keyPress(KeyEvent.VK_A);
		CommonFunctionality.wait(200);
		robot.keyRelease(KeyEvent.VK_A);
	}

	@SuppressWarnings("deprecation")
	@And("^Drag and drop to my series/visual$")
	public void drag_and_drop_to_my_series_visual() throws Throwable {
		Thread.sleep(3000);
		Validationstr = ele.getText();
		WebElement Myseries = login.driver.findElement(By.className("data-selection-series-overlay--content"));
		action.pause(500).dragAndDrop(ele, Myseries).build().perform();
	}

	@And("^Click on series name$")
	public void click_on_series_name() throws Throwable {
		Thread.sleep(2000);
		try {
			CommonFunctionality.getElementByXpath(login.driver, "//div[@class='series-name--title']", 6).click();

		} catch (Exception e) {
			// Clicking on series name in edit series window for histogram & pie visual
			try {
				// close rename popup if it is opened
				CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 20).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='series-name--title']", 6).click();
			} catch (Exception e1) {
				CommonFunctionality.getElementByProperty(login.driver, "Series_item_name", 6).click();
			}
		}

	}

	@Then("^Series information popup should be opened$")
	public void series_information_popup_should_be_opened() throws Throwable {
		Validationstr = ele.getText();
		login.Log4j.info(Validationstr);
		Thread.sleep(3000);
		ele = login.driver.findElement(By.className("series-preview-modal-header--link"));
		String ssp_text = ele.getText();
		login.Log4j.info(ssp_text);
		if (Validationstr.contains(ssp_text)) {
			login.Log4j.info("Series information popup is opened");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@class='movable-modal--close']")).click();
		} else {

			Assert.fail("Series information popup is not opened");
		}
		// CollapseTreeMethod();
	}

	@SuppressWarnings("deprecation")
	@And("^Click on \"([^\"]*)\" icon$")
	public void click_on_icon(String arg1) throws Throwable {
		if (arg1.equals("Show related data")) {
			ele = login.driver.findElement(By.xpath("//div[@class='series-item--country country-information']"));
			action.moveToElement(ele).pause(2000).click().build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@title='Show related data']")).click();
			String expected = "DATASETS";
			ele = login.driver.findElement(By.xpath("//div[@class='related-series-information-portlet--title']"));
			String actual = ele.getText();
			login.Log4j.info(actual);
			if (actual.equals(expected)) {
				login.Log4j.info("Related data is displayed ");
				Thread.sleep(2000);
				login.driver.findElement(By.xpath("//div[@title='Hide related data']")).click();
				result = "pass";
			} else {
				AssertJUnit.fail("Related data is not displayed ");
				result = "fail";
			}
			CommonFunctionality.CollapseTreeMethod();
		} else if (arg1.equals("Delete template")) {
			/*
			 * ele = login.driver.findElement( By.
			 * xpath("//div[@class='style-templates-item--icon style-templates-item--icon__text']"
			 * )); action.moveToElement(ele).pause(1000).perform(); CommonFunctionality
			 * .getElementByXpath(login.driver,
			 * "//div[@class='style-templates-item--delete icon--red-cross']", 10) .click();
			 */
			List<WebElement> deleting_template = login.driver.findElements(
					By.xpath("//*[@class='style-templates-item--wrapper']//*[@title='" + Histogram.NewTemplate + "']"));

			for (int i = 0; i < deleting_template.size(); i++) {
				if (deleting_template.get(i).getAttribute("title").contains(Histogram.NewTemplate)) {
					action.moveToElement(deleting_template.get(i)).pause(1000).perform();
					CommonFunctionality
							.getElementByXpath(login.driver,
									"//*[@title='" + Histogram.NewTemplate + "']//*[@title='" + arg1 + "']", 10)
							.click();
					break;
				}
			}

		} else if (arg1.equalsIgnoreCase("Open advanced settings popup")) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@title,'Source. Configure displaying of the source')]/*[3]/*[@title='" + arg1 + "']",
					20).click();
		} else if (arg1.equalsIgnoreCase("Rename series") || arg1.equalsIgnoreCase("Edit series")) {
			WebElement Delete_series_icon = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'visual-series-list--remove-row')]", 20);
			new Actions(login.driver).moveToElement(Delete_series_icon).perform();
			CommonFunctionality.wait(500);
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='visual-series-name']//*[@title='" + arg1 + "']", 20)
					.click();
		} else if (arg1.equalsIgnoreCase("Copy")) {
			CommonFunctionality.wait(500);
			CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg1 + "']", 20).click();
		} else if (arg1.equalsIgnoreCase("Copy link")) {
			CommonFunctionality.wait(2000);
			CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg1 + "']", 20).click();
			CommonFunctionality.wait(1000);
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Clipboard clipboard = toolkit.getSystemClipboard();
			copied_link = (String) clipboard.getData(DataFlavor.stringFlavor);
		}

	}

	@Then("^Related data should be displayed under the dropdown$")
	public void related_data_should_be_displayed_under_the_dropdown() throws Throwable {
		login.Log4j.info(result);
	}

	@SuppressWarnings("deprecation")
	@And("^Click on Show related data icon$")
	public void click_on_Show_related_data_icon() throws Throwable {
		str = CommonFunctionality
				.getElementByXpath(login.driver,
						"//ul[@class='search-series-list scrollable']/*[1]//div[@class='series-item--name']", 8)
				.getText();
		ele = CommonFunctionality.getElementByXpath(login.driver,
				"//ul[@class='search-series-list scrollable']/*[1]//div[@class='series-item--country country-information']",
				8);
		action.pause(500).moveToElement(ele).click().build().perform();
		try {
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//ul[@class='search-series-list scrollable']/*[1]//div[@title='Show related data']", 20)
					.click();
		} catch (Exception e) {

		}

	}

	@And("^Click on datalinks under datasets$")
	public void click_on_datalinks_under_datasets() throws Throwable {
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='series-data-set--table-name']", 20).click();
	}

	@Then("^Should redirect to respective datasets$")
	public void should_redirect_to_respective_datasets() throws Throwable {
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath("//span[@class='insight-discovery--popup-title']"));
		String tname = ele.getText();

		if (tname.equalsIgnoreCase(tableName)) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@class='insight-discovery--popup-back-button']")).click();
			login.Log4j.info("It is redirected to respective DB");
		} else {
			AssertJUnit.fail("It is not redirected");
		}
		try {
			// Close replacement window
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 4).click();
		} catch (Exception e) {

		}
		// CommonFunctionality.CollapseTreeMethod();

	}

	@And("^Expand World Trend Plus till series level$")
	public void expand_World_Trend_Plus_till_series_level() throws Throwable {
		// CommonFunctionality.CollapseTreeMethod();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("WTD"))))
				.click();
		CommonFunctionality.getElementByProperty(login.driver, "WTD_All", 8).click();
		CommonFunctionality.wait(1200);
		CommonFunctionality.getElementByProperty(login.driver, "Expand3rdLevel", 8).click();
		CommonFunctionality.wait(1200);
		CommonFunctionality.getElementByProperty(login.driver, "Expand4thLevel", 8).click();
		CommonFunctionality.wait(1200);
		CommonFunctionality.getElementByProperty(login.driver, "Expand5thLevel", 8).click();

	}

	@Then("^\"([^\"]*)\" should be displayed if available for the series$")
	public void should_be_displayed_if_available_for_the_series(String arg1) throws Throwable {
		Thread.sleep(2000);
		try {
			ele = login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]"));
			if (ele.isDisplayed()) {
				login.Log4j.info(arg1 + " is displayed");
			}
		} catch (NoSuchElementException e) {
			login.Log4j.info(arg1 + " is not available");
		}
	}

	@Then("^Should open related footnotes$")
	public void should_open_related_footnotes() throws Throwable {
		Thread.sleep(3000);
		ele = login.driver.findElement(By.className("footnotes-modal--title"));
		String footnote_title = ele.getText();
		if (footnote_title.contains(str)) {
			login.Log4j.info("Footnote is opened");
			Thread.sleep(2000);
			login.driver.findElement(By.className("movable-modal--close")).click();
		} else {
			AssertJUnit.fail("Footnote is not opened");
		}
	}

	@And("^Click on any insights under insights section$")
	public void click_on_any_insights_under_insights_section() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Open File menu']", 20).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Open Recent')]", 30).click();
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//ul[@class='dropdown-menu']//li//*[@class='recent-insight-sub-menu-item-view'][1]", 25)
				.click();
		click_on_Show_related_data_icon();
		try {
			ele = login.driver.findElement(By.xpath(
					"//div[@class='related-series-data--body']//div[@class='related-series-information-portlet'][2]"));
		} catch (Exception e) {
			// when INSIGHTS not available under show related data
			// create a new insight with adding series to my series tab
			CommonFunctionality
					.getElementByXpath(login.driver, "(//*[@class='add-to-data-selection--title'])[1]/*[1]", 15)
					.click();
			CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Open File menu']", 10).click();
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'New')]", 10).click();
			CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Create insight')]", 10)
					.click();
			login.driver.navigate().refresh();
			select_database_as_Daily_Database();
			expand_till_series_level();
			click_on_Show_related_data_icon();
			ele = login.driver.findElement(By.xpath(
					"//div[@class='related-series-data--body']//div[@class='related-series-information-portlet'][2]"));
		}
		jse.executeScript("arguments[0].scrollIntoView(true);", ele);
		Thread.sleep(1000);
		List<WebElement> listOfInsights = login.driver
				.findElements(By.xpath("//*[contains(@class,'insight-table-item--title-wrapper')]//a"));
		for (int i = 0; i < listOfInsights.size();) {
			CommonFunctionality.wait(300);
			listOfInsights.get(i).click();
			break;
		}

	}

	@Then("^Insights should be opened in preview mode$")
	public void insights_should_be_opened_in_preview_mode() throws Throwable {
		Thread.sleep(2000);
		if (login.driver.findElement(By.xpath("//*[@class='insight-preview--title text-dots']")).isDisplayed()) {
			CommonFunctionality.getElementByClassName(login.driver, "insight-preview--close", 4).click();
			login.Log4j.info("Insight is opened in preview mode");
		} else {
			AssertJUnit.fail("Insight is NOT opened in preview mode");
		}
		CommonFunctionality.DeleteVisual();
	}

	@And("^Click on share under insights section$")
	public void click_on_share_under_insights_section() throws Throwable {
		CommonFunctionality.wait(500);
		List<WebElement> ShareInsight = login.driver.findElements(By.xpath("//*[@title='Share Insight']"));
		for (int i = 0; i < ShareInsight.size();) {
			ShareInsight.get(i).click();
			break;
		}

	}

	@Then("^Share popup should be opened if have permission to share$")
	public void share_popup_should_be_opened_if_have_permission_to_share() throws Throwable {
		Thread.sleep(2000);
		if (login.driver.findElement(By.xpath("//h4[@class='modal-title sphere-modal__title text-dots']"))
				.isDisplayed()) {
			CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']", 4).click();
			login.Log4j.info("Share popup is opened");
		} else {
			AssertJUnit.fail("Share popup is not opened");
		}

	}

	@And("^Click on add to favourite under insights section$")
	public void click_on_add_to_favourite_under_insights_section() throws Throwable {
		// When INSIGHTS has multiple insights
		// ele = CommonFunctionality.getElementByXpath(login.driver,
		// "//div[@class='related-series-data--body']//div[@class='related-series-information-portlet'][2]",4);
		// jse.executeScript("arguments[0].scrollIntoView(true);", ele);
		Thread.sleep(2000);
		// List<WebElement> listOfInsights =
		// login.driver.findElements(By.xpath("//*[contains(@class,'insight-table-item--title-wrapper')]"));
		List<WebElement> listOfInsights = login.driver
				.findElements(By.xpath("//*[contains(@class,'insight-table-item--title-wrapper')]//a"));
		List<WebElement> favoriteIcon = login.driver.findElements(By.xpath("//*[@title='Add to favorite']"));
		for (int i = 0; i < listOfInsights.size();) {
			favoriteIcon.get(i).click();
			CommonFunctionality.wait(500);
			listOfInsights.get(i).click();
			break;
		}
	}

	@Then("^The insights should be added to favorite list$")
	public void the_insights_should_be_added_to_favorite_list() throws Throwable {
		CommonFunctionality.wait(500);
		Boolean remove_from_faviourite = login.driver
				.findElement(By.xpath("//*[@class='insight-preview--header']//*[@title='Remove from favorite']"))
				.isDisplayed();
		if (remove_from_faviourite == true) {
			CommonFunctionality.wait(1000);
			login.driver
					.findElement(By.xpath("//*[@class='insight-preview--header']//*[@title='Remove from favorite']"))
					.click();
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='insight-preview--close']", 10).click();
			login.Log4j.info("The insight is added to favorite");
			CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Hide related data']", 20).click();
		} else {
			CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Hide related data']", 20).click();
			Assert.fail("The insight is not added to favorite");
		}

	}

	@Then("^The related data dropdown should be collapsed$")
	public void the_related_data_dropdown_should_be_collapsed() throws Throwable {
		Thread.sleep(2000);
		if (login.driver.findElement(By.xpath("//div[@title='Show related data']")).isDisplayed()) {
			login.Log4j.info("The related data dropdown is collapsed");
		}
	}

	@And("^Mouse hover on any series level$")
	public void mouse_hover_on_any_series_level() throws Throwable {
		
		// Mouse hovering on Brazil Premium Database for series level
		MoreFilterNotApplied_BRAZILPremiumDB();
		Thread.sleep(2000);
		ele = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("ExpandTable_BrazilDB")));
		ele.click();
		//jse.executeScript("arguments[0].scrollIntoView(true);", ele);
		Thread.sleep(2000);
		ele = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("BrazilDB_mouseHoverOnSeries")));
		CommonFunctionality.sname = ele.getText();
		login.Log4j.info(CommonFunctionality.sname);
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
				"BrazilDB_SelectSeries")))
				.click();
		
	}

	@Then("^Chart should be created with the series$")
	public void chart_should_be_created_with_the_series() throws Throwable {
		CommonFunctionality.wait(2500);
		ele = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("ChartTitleName")));
		String chartTitle = ele.getText();
		login.Log4j.info(chartTitle);
		login.Log4j.info(CommonFunctionality.sname);
		CommonFunctionality.Views_list();
		AssertJUnit.assertEquals(CommonFunctionality.sname, chartTitle);
		login.Log4j.info("chart is created for series level");
		
	}

	@Then("^The series should be selected in search panel although visual created$")
	public void the_series_should_be_selected_in_search_panel_although_visual_created() throws Throwable {
		Thread.sleep(4000);
		if (login.driver.findElement(By.xpath("//span[@class='search-input--preview-selection']")).isDisplayed()) {
			login.Log4j.info("The selected series is displayed");
			CommonFunctionality.Views_list();
		} else {
			AssertJUnit.fail("The selected series is not displayed");
		}
	}

	@And("^Click on Footnote icon$")
	public void click_on_Footnote_icon() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
				"FootNoteIcon_seriesLevel")))
				.click();
	}



	@And("^Mouse hover on any series level of data$")
	public void mouse_hover_on_any_series_level_of_data() throws Throwable {
		// here need to add replacement method
		expand_World_Trend_Plus_till_series_level();
		Thread.sleep(2000);
		// WebElement ul_element =
		// login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		List<WebElement> li_All = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("ListOfSeries_DatabasesTab")));
		login.Log4j.info("List size is :" + li_All.size());
		for (int i = 0; i < li_All.size(); i++) {
			int j = i + 1;
			Thread.sleep(2000);
			ele = login.driver.findElement(By.xpath("(//*[@class='database-representation--tree']//div[@class='series-list-item--checkbox-wrapper'])[" + j + "]"));
			ele.click();
			if (i == 4) {
				/*
				 * Thread.sleep(2000); ele = login.driver.findElement(By.xpath("//li[" + j +
				 * "]//span[@class='series-item-information--additional-info-field series-item-information--additional-info-field__dates']"
				 * )); action.moveToElement(ele).build().perform();
				 */
				break;
			}
		}
	}

	@Then("^The selected series should be unselected$")
	public void the_selected_series_should_be_unselected() throws Throwable {
		Thread.sleep(2000);
		// CommonFunctionality.TopMethod();
		if (!login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unselect"))).isDisplayed()) {
			login.Log4j.info("The selected series got unselected");
		} else {
			AssertJUnit.fail("The selected series are not unselected");
		}
		Thread.sleep(2000);
		String download_button_isDisabled = login.driver
				.findElement(
						By.xpath(login.LOCATORS.getProperty("DownloadButton")))
				.getAttribute("disabled");
		login.Log4j.info(download_button_isDisabled);
		if (download_button_isDisabled.equals("true")) {
			login.Log4j.info("The download button is disabled");
		} else {
			Assert.fail("The download button is not disabled");
		}
		// CommonFunctionality.SelectedSeriesClear();

	}

	@Then("^Visual should be created with \"([^\"]*)\"$")
	public void visual_should_be_created_with(String arg1) throws Throwable {

		CommonFunctionality.ChartSuggestionPopUp();
		CommonFunctionality.SeriesHormonizationWindowClose();
		Thread.sleep(2000);
		if (login.driver.findElement(By.xpath("//button[contains(text(),'" + arg1 + "')]")).isDisplayed()) {
			login.Log4j.info("Selected visual is created ");
			
		} else {
			AssertJUnit.fail("Selected visual is not created ");
		}
	}

	@And("^Select any recent insight from the dropdown$")
	public void select_any_recent_insight_from_the_dropdown() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver,
				"SelectRecenInsight",
				15).click();
	}

	@And("^Mouse hover on any series level and select more than max series$")
	public void mouse_hover_on_any_series_level_and_select_more_than_max_series() throws Throwable {
		WebElement element = null;
		CommonFunctionality.getElementByProperty(login.driver, "Databases_Tab", 4).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SelectRussiaDB"))).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand2ndLevel"))).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
				"Expand3rdLevel")))
				.click();
		//Expand Table which is having more than 30 series
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(
				"(//div[@class='tree-node'])[12]/*[1]"))
				.click();
		Thread.sleep(2000);
		// WebElement ul_element =
		// login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		List<WebElement> li_All = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("ListOfSeries_DatabasesTab")));
		login.Log4j.info("List size is :" + li_All.size());
		for (int i = 1; i < 32; i++) {
			//int j = i + 1;
			try {
				Thread.sleep(3000);
				ele = login.driver.findElement(By.xpath("(//*[@class='database-representation--tree']//div[@class='series-list-item--checkbox-wrapper'])[" + i + "]"));
				ele.click();
				element = login.driver.findElement(By.xpath("(//*[@class='database-representation--tree']//*[@class='series-item--country country-information'])[" + i +"]"));
				// jse.executeScript("arguments[0].scrollIntoView(true);", element);
				if (i == 32) {
					Thread.sleep(1000);
					login.driver.findElement(By.xpath("//*[@class='database-representation--tree']//*[contains(@class,'series-search-list-item__active')]//*[@title='More actions']")).click();
					break;
				}
			} catch (NoSuchElementException e) {
				login.Log4j.error("Series name is null");
				//j = j + 1;
				i = i + 1;
				ele = login.driver.findElement(By.xpath("(//*[@class='database-representation--tree']//*[@class='series-item--country country-information'])[" + i +"]"));
				// ele.click();
				// Until the element is not visible keep scrolling
				// jse.executeScript("arguments[0].scrollIntoView(true);", element);

				if (i == 32) {
					Thread.sleep(1000);
					login.driver.findElement(By.xpath("//*[@class='database-representation--tree']//*[contains(@class,'series-search-list-item__active')]//*[@title='More actions']")).click();
					break;
				}
			}
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
		}
	}

	@Then("^Confirmation window should be displayed and proceed with max series if click on \"([^\"]*)\" button$")
	public void confirmation_window_should_be_displayed_and_proceed_with_max_series_if_click_on_button(String arg1)
			throws Throwable {
		Thread.sleep(2000);
		login.Log4j.info("Clicking on " + arg1 + " icon ");
		login.driver.findElement(By.xpath("//button[contains(text(),'" + arg1 + "')]")).click();
		try {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@title='Close']")).click();
		} catch (Exception e) {

		}
	}

	@Then("^Selected series should be copied$")
	public void selected_series_should_be_copied() throws Throwable {
		Thread.sleep(1000);
		if (login.driver.findElement(By.xpath("//div[@class='growl-message-text']")).isDisplayed()) {
			login.Log4j.info("Selected series are copied");
		} else {
			AssertJUnit.fail("Selected series are not copied");
		}
	}

	@And("^Click on More actions$")
	public void click_on_More_actions() throws Throwable {
		Thread.sleep(2000);
		login.driver
				.findElement(By.xpath("//*[@class='database-representation--tree']//*[contains(@class,'series-search-list-item__active')]//span[@title='More actions']"))
				.click();
		login.Log4j.info("Clicking on More actions");
	}

	@And("^Paste in application$")
	public void paste_in_application() throws Throwable {

		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//div[@data-action='paste']")).click();
	}

	@Then("^Copied series should be pasted$")
	public void copied_series_should_be_pasted() throws Throwable {
		Thread.sleep(3000);
		ele = login.driver.findElement(By.xpath("//span[@class='series-name-field--series-name']"));
		String actual = ele.getText();
		AssertJUnit.assertEquals(actual, CommonFunctionality.sname);
		login.Log4j.info("Copied series are pasted");
		// CommonFunctionality.DeleteSeries();
	}

	@Then("^The message should be in growl popup as \"([^\"]*)\"$")
	public void the_message_should_be_in_growl_popup_as(String arg1) throws Throwable {
		Thread.sleep(1000);
		if (login.driver.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]")).isEnabled()) {
			login.Log4j.info(arg1 + " is displayed in growl popup");
		} else {
			AssertJUnit.fail(arg1 + " is not displayed in growl popup");
		}
	}

	@Then("^The download popup should be opened$")
	public void the_download_popup_should_be_opened() throws Throwable {
		Thread.sleep(2000);

		if (login.driver.findElement(By.xpath("//div[@class='download-modal-title']")).isDisplayed()) {
			Thread.sleep(2000);
			login.Log4j.info(" Download popup is opened");
			login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		} else {
			AssertJUnit.fail("Download popup is not opened");
		}
	}

	@Then("^URL should be generated for selected series$")
	public void url_should_be_generated_for_selected_series() throws Throwable {
		Thread.sleep(1000);
		ele = login.driver.findElement(By.xpath("//div[@class='growl-message-text']"));
		String urlCopied = ele.getText();
		login.Log4j.info("Growl text: " + urlCopied);
		if (ele.isDisplayed()) {
			login.Log4j.info(urlCopied);
		} else {
			AssertJUnit.fail("URL is not generated");
		}
	}

	@Then("^The Series information popup should be opened in untitled insight for selected series$")
	public void the_Series_information_popup_should_be_opened_in_untitled_insight_for_selected_series()
			throws Throwable {

		if (CommonFunctionality.getElementByClassName(login.driver, "series-preview-modal-header--link", 4)
				.isDisplayed()) {
			ele = CommonFunctionality.getElementByClassName(login.driver, "series-preview-modal-header--link", 4);
			String actual = ele.getText();
			login.Log4j.info(actual);
			AssertJUnit.assertEquals(actual, CommonFunctionality.sname);
			login.Log4j.info("SSP window is opened");
			Thread.sleep(2000);
			login.driver.close();
			login.driver.switchTo().window(tabs2.get(0));
		} else {
			Assert.fail("SSP window is not displayed");
		}

	}

	@And("^Paste in clipboard and take url one by one$")
	public void paste_in_clipboard_and_take_url_one_by_one() throws Throwable {
		SessionId session = ((ChromeDriver) login.driver).getSessionId();
		System.out.println(session);
		// Create instance of Clipboard class
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Clipboard_data = (String) clipboard.getData(DataFlavor.stringFlavor);
		// login.Log4j.info(Clipboard_data);
		String[] textArea = Clipboard_data.split("\\n");
		login.Log4j.info(textArea.length);

		for (String line : textArea) {
			login.Log4j.info(line); // Set the String to Enter
			StringSelection stringSelection = new StringSelection(line); // Copy the String to Clipboard
			clipboard.setContents(stringSelection, null);

			String parent_window = login.driver.getWindowHandle();
			System.out.println("Parent Window Handle is: " + login.driver.getWindowHandle());
			System.out.println("Page Title is: " + login.driver.getTitle());
			jse.executeScript("window.open('" + line + "');");
			CommonFunctionality.wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			Set<String> allWindows_1 = login.driver.getWindowHandles();
			System.out.println("Total Windows: " + allWindows_1.size());
			for (String hand1 : allWindows_1) {
				if (!parent_window.equals(hand1)) {
					login.driver.switchTo().window(hand1);
					CommonFunctionality.wait.until(ExpectedConditions.titleContains("CDMNext"));
					System.out.println("After expected condition");
					String first_child_window = login.driver.getWindowHandle();
					System.out.println("First Child Window Handle is: " + first_child_window);
					System.out.println("First Child Window Page Title is: " + login.driver.getTitle());
					the_SSP_window_should_be_opened();
					login.driver.close();
				}
				login.driver.switchTo().window(parent_window);
			}
		}
	}

	@Then("^The SSP window should be opened$")
	public void the_SSP_window_should_be_opened() throws Throwable {
		try {
			Thread.sleep(3000);
			ele = login.driver.findElement(By.className("series-preview-modal-header--link"));
			String stitle = ele.getText();
			login.Log4j.info(stitle);
			if (ele.isDisplayed()) {
				Thread.sleep(1500);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
				login.Log4j.info("SSP window is opened");
			} else {
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
				Assert.fail("SSP window is not opened");
			}
		} catch (Exception e) {

		}
	}

	@And("^Click on Back button$")
	public void click_on_Back_button() throws Throwable {
		Thread.sleep(2000);
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Backbutton"))).isDisplayed()) {
			login.Log4j.info("Clicking on Back button");
			Thread.sleep(2000);
			login.driver.findElement(By.className("insight-discovery--popup-back-button")).click();
		}
	}

	@Then("^Should redirect to database tab$")
	public static void should_redirect_to_database_tab() throws Throwable {
		Thread.sleep(2000);
		if (login.driver.findElement(By.className("series-tab--text")).isDisplayed()) {
			login.Log4j.info("Redirected to database tab");
		}
	}

	@Then("^The dropdown should be closed$")
	public void the_dropdown_should_be_closed() throws Throwable {
		Thread.sleep(2000);
		List<WebElement> moreActions_dropdown = login.driver.findElements(By.xpath("//div[@class='items-wrapper']"));
		login.Log4j.info(moreActions_dropdown.size());
		if (moreActions_dropdown.size() == 0) {
			login.Log4j.info("Dropdown is closed");
		} else {
			AssertJUnit.fail("Dropdown is not closed");
		}
	}

	@And("^Click on \\+ icon for a series$")
	public void click_on_icon_for_a_series() throws Throwable {
		try {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(
					"//a[@class='insight-page-view-tab--link']//div[@class='insight-page-view-tab--link-ghost']"))
					.click();
			CommonFunctionality.DeleteSeries();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(
					"//ul[@class='search-series-list scrollable']/*[1]//div[@class='add-to-data-selection--icon']"))
					.click();
		} catch (Exception e) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
					"AddIcon_seriesLevel_RussiaDB")))
					.click();
		}
	}

	@Then("^The series should be added to my series$")
	public void the_series_should_be_added_to_my_series() throws Throwable {
		String actual = null;
		try {
			ele = login.driver.findElement(By.id("current-title"));

		} catch (Exception e) {
			ele = login.driver.findElement(By.className("series-name-field--series-name"));
		}
		actual = ele.getText();
		// login.Log4j.info(sname);
		login.Log4j.info(actual);
		if (actual.contains(CommonFunctionality.sname)) {
			login.Log4j.info("series added to my series");
		} else {
			Assert.fail("series not added to my series");
		}
		// CommonFunctionality.DeleteSeries();
	}

	@And("^Click on View tab on right side$")
	public void click_on_View_tab_on_right_side() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CreateViewTab"))).click();
	}

	@And("^Click on \\+ icon$")
	public void click_on_icon() throws Throwable {
		Thread.sleep(2000);
		login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty(
						"AddIcon_seriesLevel_RussiaDB")))
				.click();
	}

	/*
	 * @Then("^Chart should be created with selected seires$") public void
	 * chart_should_be_created_with_selected_seires() throws Throwable {
	 * Thread.sleep(3000); ele =
	 * login.driver.findElement(By.xpath("//div[@class='visual-title--wrapper']"));
	 * String actual = ele.getText(); AssertJUnit.assertEquals(actual,
	 * CommonFunctionality.sname); login.Log4j.info("Chart is created");
	 * CommonFunctionality.Views_list(); }
	 */
	@And("^Create a visual and select visual$")
	public void create_a_visual_and_select_visual() throws Throwable {
		Thread.sleep(2000);
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).clear();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		login.Log4j.info("Clicking on  Series tab ");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		Thread.sleep(4000);
		WebElement checkBox = login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
				"SelectFirstSeries")));
		checkBox.click();
		ele = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("FirstSNAME")));
		BeforeReplace = ele.getText();
		login.Log4j.info(BeforeReplace);
		Thread.sleep(1000);
		login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("ViewAsChart")))
				.click();

	}

	@And("^Select a series and Click on dropdown icon$")
	public void select_a_series_and_Click_on_dropdown_icon() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Databases_Tab"))).click();
		mouse_hover_on_any_series_level();
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
				"DropDownIcon_SeriesLevel")));
		action.moveToElement(ele).click().perform();

	}

	@Then("^The selected series should be replaced with existing series on the visual$")
	public void the_selected_series_should_be_replaced_with_existing_series_on_the_visual() throws Throwable {
		Thread.sleep(3000);
		if (!BeforeReplace.equals(CommonFunctionality.sname) == true) {
			login.Log4j.info("The selected series replaced with existing series");
		} else {
			AssertJUnit.fail("The selected series not replaced with existing series");
		}
	
	}

	@Then("^Selected series should be added as group in My series$")
	public void selected_series_should_be_added_as_group_in_My_series() throws Throwable {
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath("//span[@class='group-name']"));
		str = ele.getText();
		login.Log4j.info(str);
		if (str.contains("Group")) {
			login.Log4j.info("Selected series added to My series tab as group");
		} else {
			AssertJUnit.fail("Selected series not added to My series tab as group");
		}
	

	}

	@Then("^The new insight should be created with selected series$")
	public void the_new_insight_should_be_created_with_selected_series() throws Throwable {
		CommonFunctionality.wait(500);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("confirm_popup_new_insight"))).click();
		robot = new Robot();
		// Store all currently open tabs in tabs
		ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
		// Navigate to New Tab
		login.driver.switchTo().window(tabs2.get(1));
		the_series_should_be_added_to_my_series();
		login.driver.close();
		login.driver.switchTo().window(tabs2.get(0));

	}

	@Then("^The series should be added to My series tab for selected insight$")
	public void the_series_should_be_added_to_My_series_tab_for_selected_insight() throws Throwable {
		/*
		 * Thread.sleep(5000); WebElement ele =
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty("second_insight"
		 * ))); ele.click(); Thread.sleep(2000); login.driver.findElement(By.
		 * xpath("//button[contains(text(),'Add to insights')]")).click();
		 */
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//li//a[@class='growl-message--link growl-message--link__highlighted']"))
				.click();
		// login.Log4j.info(ele.getText());
		login.robot = new Robot();
		// Store all currently open tabs in tabs
		ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
		// Navigate to New Tab
		login.driver.switchTo().window(tabs2.get(1));
		Thread.sleep(2000);
		CommonFunctionality.ContinueSameInsight();
		the_series_should_be_added_to_my_series();
		login.driver.close();
		login.driver.switchTo().window(tabs2.get(0));
		try {
			close_search_selection_window();
		} catch (Exception e) {

		}

	}

	@Then("^Open the insights and verify the series in My series$")
	public void open_the_insights_and_verify_the_series_in_My_series() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//*[@title='Open File menu']")).click();
		Thread.sleep(1500);
		login.driver.findElement(By.xpath("//*[contains(text(),'Open Recent')]")).click();
		insightVar = 0;
		Thread.sleep(2000);
		List<WebElement> insights_list = login.driver
				.findElements(By.xpath("//*[@class='recent-insight-sub-menu-item-view']"));
		login.Log4j.info(insights_list.size());
		for (int i = 0; i < insights_list.size(); i++) {
			Thread.sleep(1000);
			// int j = i + 1;
			insights_list.get(i).click();
			// ele = login.driver.findElement(By.xpath("//div[@class='insight-icon-item']["
			// + j + "]"));
			// action.moveToElement(ele).build().perform();
			// Thread.sleep(2000);
			// login.driver.findElement(By.linkText("Open")).click();
			login.robot = new Robot();
			// Store all currently open tabs in tabs
			ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
			// Navigate to New Tab
			login.driver.switchTo().window(tabs2.get(1));
			CommonFunctionality.getElementByProperty(login.driver, "Series_tab", 10).click();
			List<WebElement> series_list = login.driver
					.findElements(By.xpath("//*[@class='list-container']//*[@class='series-name-field-title']"));
			login.Log4j.info(series_list.size());
			for (int k = 0; k < series_list.size(); k++) {
				int l = k + 1;
				Thread.sleep(1000);
				ele = login.driver
						.findElement(By.xpath("//*[@class='list-container']//*[contains(@class,'webix_cell')][" + l
								+ "]//*[@class='series-name-field-title']"));
				str = ele.getText();
				login.Log4j.info(str);
				login.Log4j.info(CommonFunctionality.sname);
				if (str.equalsIgnoreCase(CommonFunctionality.sname)) {
					login.Log4j.info("Selected series added to My series");
					break;
				} else {
					AssertJUnit.fail("Selected series not added to My series");
				}
			}
			CommonFunctionality.DeleteSeries();
			login.driver.close();
			login.driver.switchTo().window(tabs2.get(0));
			insightVar++;
			// login.Log4j.info(insightVar);
			if (i == 2) {
				login.driver.findElement(By.xpath("//*[@class='sphere-modal__close']")).click();
				break;

			}
		}
		// CommonFunctionality.DeleteSeries();
	}

	@And("^Select a series$")
	public void select_a_series() throws Throwable {
		CommonFunctionality.UnselectMethod();
		select_database_as_Daily_Database();
		expand_till_series_level();
		CommonFunctionality.wait(1000);
		ele = login.driver.findElement(By.xpath("//div[@class='series-item--name']"));
		CommonFunctionality.sname = ele.getText();
		login.Log4j.info(CommonFunctionality.sname);

	}

	@And("^Create new view pannel$")
	public void create_new_view_pannel() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-page-menu-views-container--add']", 4)
				.click();
	}

	@And("^Drag and drop to any visual template$")
	public void drag_and_drop_to_any_visual_template() throws Throwable {
		Thread.sleep(3000);
		WebElement Myseries = login.driver.findElement(By
				.xpath("//div[@class='main-view-container droppable']//div[@class='view-components-over--visual'][1]"));
		action.dragAndDrop(ele, Myseries).build().perform();
	}

	@Then("^Respective visual should be created as per the series drop$")
	public void respective_visual_should_be_created_as_per_the_series_drop() throws Throwable {
		/*
		 * CommonFunctionality.wait(2000); ele =
		 * login.driver.findElement(By.xpath("//div[@class='text-dots']")); String
		 * actual = ele.getText(); login.Log4j.info(CommonFunctionality.sname);
		 * login.Log4j.info(actual); AssertJUnit.assertEquals(actual,
		 * CommonFunctionality.sname); login.Log4j.info("Visual is created ");
		 * CommonFunctionality.Views_list();
		 */
		chart_should_be_created_with_the_series();
	}

	@And("^Create a visual with series/empty$")
	public void create_a_visual_with_series_empty() throws Throwable {
		create_new_view_pannel();
		Thread.sleep(2000);
		login.driver
				.findElement(By.xpath(
						"//div[@class='main-view-container droppable']//div[@class='view-components-over--visual'][2]"))
				.click();
	}

	@SuppressWarnings("deprecation")
	@And("^Drag and drop on visual$")
	public void drag_and_drop_on_visual() throws Throwable {
		st.user_enters_seriesID("28496901");
		CommonFunctionality.getElementByProperty(login.driver, "Series", 20).click();
		Thread.sleep(2000);
		WebElement ele = login.driver.findElement(By.xpath("//div[@class='series-item--name']"));
		CommonFunctionality.sname = ele.getText();
		login.Log4j.info(CommonFunctionality.sname);
		// WebElement dest = login.driver
		// .findElement(By.xpath("//*[@class='empty-visual-overlay--icon-block']"));
		// WebElement dest =
		// CommonFunctionality.getElementByXpath(login.driver,"//*[text()='Drag series
		// here' and @class='empty-visual-overlay--text']",20);
		WebElement dest = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='empty-visual-overlay--content']", 20);
		// new Actions(login.driver).dragAndDrop(ele, dest).perform();
		new Actions(login.driver).moveToElement(ele).pause(500).dragAndDrop(ele, dest).build().perform();
	}

	@Then("^The series should be added to the visual$")
	public void the_series_should_be_added_to_the_visual() throws Throwable {
		respective_visual_should_be_created_as_per_the_series_drop();
	}

	@And("^Click on 'A' on keyboard$")
	public void click_on_A_on_keyboard() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='series-list-item--checkbox-wrapper']")).click();
		Thread.sleep(1000);
		robot = new Robot();
		// Adding series to Myseries
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
	}

	@And("^Select some series$")
	public void select_some_series() throws Throwable {
	
		CommonFunctionality.getElementByProperty(login.driver, "Databases_Tab", 5).click();
		expand_World_Trend_Plus_till_series_level();
		Thread.sleep(2000);
		// WebElement ul_element =
		// login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		// List<WebElement> li_All =
		// ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
		List<WebElement> li_All = login.driver.findElements(
				By.xpath("//*[contains(@style,'padding-left')]/*[@unselectable='on']//*[@class='series-item--name']"));
		login.Log4j.info("List size is :" + li_All.size());
		for (i = 0; i < li_All.size(); i++) {
			m = i + 1;
			Thread.sleep(1000);
			ele = login.driver.findElement(By.xpath("(//*[contains(@style,'padding-left')]/*[@unselectable='on'])[" + m
					+ "]//div[@class='series-list-item--checkbox-wrapper']"));
			ele.click();

			if (i == 4) {
				// Thread.sleep(1000);
				// just_double_click_on_series();
				break;
			}
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Just double click on series$")
	public void just_double_click_on_series() throws Throwable {
		// WebElement element =
		// login.driver.findElement(By.xpath("//li[5]//div[@class='series-item--status-icons']"));
		action.pause(1500).doubleClick(ele).build().perform();
	}

	@Then("^The selected series should be added to My series/visuals$")
	public void the_selected_series_should_be_added_to_My_series_visuals() throws Throwable {
		Thread.sleep(3000);
		ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SelectedSeriesCount_myseries")));
		str = ele.getText();
		String[] series_panel_count = str.split(" ");
		int Added_series_Count = Integer.parseInt(series_panel_count[0]);
		// No.of series selected
		// login.Log4j.info(m);
		// No.of series added to my series
		login.Log4j.info(Added_series_Count);
		if (Added_series_Count == m || CommonFunctionality.SeriesCount == Added_series_Count) {
			login.Log4j.info("Selected series added to My series");

		} else {
			CommonFunctionality.DeleteSeries();
			AssertJUnit.fail("Selected series not added to My series");

		}
		
	}

	@And("^Expand search panel$")
	public void expand_search_panel() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
				"ExpanSearchPanel")))
				.click();
	}

	@And("^Click on My series$")
	public void click_on_My_series() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.cssSelector(".view-selection--btn__active")).click();
	}

	@And("^Select series in any database$")
	public void select_series_in_any_database() throws Throwable {
		//CommonFunctionality.UnselectMethod();
		expand_World_Trend_Plus_till_series_level();
		Thread.sleep(2000);
		// WebElement ul_element =
		// login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		List<WebElement> li_All = login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("ListOfSeries_DatabasesTab")));
		login.Log4j.info("List size is :" + li_All.size());
		for (int i = 0; i < li_All.size(); i++) {
			m = i + 1;
			Thread.sleep(1500);
			ele = login.driver.findElement(By.xpath("(//*[@class='database-representation--tree']//div[@class='series-list-item--checkbox-wrapper'])[" + m + "]"));
			ele.click();

			if (i == 4) {
				break;
			}
		}
	}

	@And("^Click on any visual type$")
	public void click_on_any_visual_type() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='view-selection--content']//div[@title='Insert Chart'][1]"))
				.click();
	}

	@Then("^The selected series should be added to visuals$")
	public void the_selected_series_should_be_added_to_visuals() throws Throwable {
		Thread.sleep(3000);
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Chart_created"))).isEnabled()) {
			login.Log4j.info("The selected series added to visual");
		} else {
			AssertJUnit.fail("The selected series not added to visual");
		}
		
	}

	@And("^Right click on any series level of data$")
	public void right_click_on_any_series_level_of_data() throws Throwable {
		//CommonFunctionality.UnselectMethod();
		expand_World_Trend_Plus_till_series_level();
		CommonFunctionality.RightClickOnAnySeries();

	}

	@And("^Right click on any series level and select more than max series$")
	public void right_click_on_any_series_level_and_select_more_than_max_series() throws Throwable {
		WebElement element = null;
		CommonFunctionality.UnselectMethod();
		select_global_database();
		expand_till_table_level();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
				"Expand5thLevel")))
				.click();
		Thread.sleep(2000);
		// WebElement ul_element =
		// login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		List<WebElement> li_All = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("ListOfSeries_DatabasesTab")));
		login.Log4j.info("List size is :" + li_All.size());
		for (int i = 0; i < li_All.size(); i++) {
			int j = i + 1;
			login.Log4j.info(j);
			try {
				Thread.sleep(3000);
				ele = login.driver.findElement(By.xpath("(//*[@class='database-representation--tree']//div[@class='series-list-item--checkbox-wrapper'])[" + j + "]"));
				ele.click();
				element = li_All.get(i);
				if (i == 32) {
					Thread.sleep(1000);
					action.contextClick(element).build().perform();
					break;
				}
			} catch (NoSuchElementException e) {
				login.Log4j.error("Series name is null");
				j = j + 1;
				// login.Log4j.info(j);
				ele = login.driver.findElement(By.xpath("(//*[@class='database-representation--tree']//div[@class='series-list-item--checkbox-wrapper'])[" + j + "]"));
				Thread.sleep(2000);
				// ele.click();
				element = li_All.get(j);
				// Until the element is not visible keep scrolling
				// CommonFunctionality.jse.executeScript("arguments[0].scrollIntoView(true);",
				// element);
				// Thread.sleep(2000);
				// action.contextClick(element).build().perform();
				if (i == 32) {
					Thread.sleep(1000);
					action.contextClick(element).build().perform();
					break;
				}
			}
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
		}
	}

	@Then("^Copied series should be pasted to my series tab$")
	public void copied_series_should_be_pasted_to_my_series_tab() throws Throwable {
		the_selected_series_should_be_added_to_My_series_visuals();
	}

	@SuppressWarnings("deprecation")
	@And("^Right click on any series$")
	public void right_click_on_any_series() throws Throwable {
		 select_a_series();
		// CommonFunctionality.CollapseTreeMethod();
		 CommonFunctionality.action.contextClick(ele).build().perform();
		/*CommonFunctionality.getElementByProperty(login.driver, "Daily_db", 4).click();
		login.Log4j.info("Clicking on Database level");
		CommonFunctionality.wait(2000);
		login.driver
				.findElement(By.xpath(
						"//div[contains(@class,'database-node tree-node')]//div[3]//div[1]//div[@class='toggle']"))
				.click();
		login.Log4j.info("Clicking on Topic level");
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(
				"//div[@class='tree-node full-expanded open' or contains(@class,' last-open-node')]/*[3]/*[1]/*[1]"))
				.click();
		login.Log4j.info("Clicking on Section level");

		ele = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='tree-node open']//div[@class='child-container']//div[1][@class='tree-node']//span[@class='name-text']",
				5);
		tableName = ele.getText();
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='tree-node open']//div[@class='child-container']//div[1]//div[@class='tree-node']//div[@class='toggle']",
				5).click();
		login.Log4j.info("Clicking on Table level");
		ele = login.driver.findElement(By.xpath("//div[@class='series-item--name']"));
		CommonFunctionality.sname = ele.getText();
		login.Log4j.info(CommonFunctionality.sname);
		action.pause(500).contextClick(ele).build().perform();*/
	}

	@And("^Select series with separators$")
	public void select_series_with_separators() throws Throwable {
		// Expanding Globaldb till series level
		
		CommonFunctionality
				.getElementByProperty(login.driver, "GlobalDB", 4)
				.click();
		CommonFunctionality.getElementByProperty(login.driver,
				"Expand_AllRegion", 4)
				.click();
		CommonFunctionality.getElementByProperty(login.driver,
				"ExpandAfganistan_GlobalDB",
				4).click();
		CommonFunctionality.getElementByProperty(login.driver,
				"ExpandAfganistan_NationalAccounts_GlobalDB",
				4).click();
		CommonFunctionality.getElementByProperty(login.driver,
				"Expand5thLevel",
				4).click();
		Thread.sleep(2000);
		List<WebElement> listOfSeries = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("ListOfSeries_DatabasesTab")));
		login.Log4j.info(listOfSeries.size());
		for (int i = 0; i < listOfSeries.size(); i++) {
			int j = i + 1;
			Thread.sleep(1500);
			checkbox = login.driver
					.findElement(By.xpath("(//*[@class='database-representation--tree']//div[@class='series-list-item--checkbox-wrapper'])[ " + j + "]"));
			checkbox.click();
			
			try {
				ele = listOfSeries.get(i);
				str = ele.getText();
				arrlist.add(str);

			} catch (NoSuchElementException e) {
				
				add_to_my_series();
				break;

			}

		}
	}

	@And("^Add to my series$")
	public void add_to_my_series() throws Throwable {
		Thread.sleep(2000);
		robot = new Robot();
		// Adding series to Myseries
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);

	}

	@Then("^Selected series and separators should be added to my series$")
	public void selected_series_and_separators_should_be_added_to_my_series() throws Throwable {
		Thread.sleep(3000);
		ele = null;
		List<WebElement> Series_list = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("ListOfSeries_Myseries")));
		// login.Log4j.info(Series_list.size());
		for (int i = 0; i < Series_list.size(); i++) {
			Thread.sleep(1000);
			Series_list.get(i).click();
			int j = i + 1;
			try {
			ele = login.driver.findElement(By.xpath(
					"//div[@class='webix_column list-series-name webix_first webix_last']/*[" + j + "]//*[@class='series-name-field']"));
			String str1 = ele.getText();
			login.Log4j.info(arrlist);
			login.Log4j.info(str1);
			if (arrlist.contains(str1) == true) {
				login.Log4j.info("selected series added");
			}
			}catch(Exception e) {
			if (login.driver.findElement(By.xpath("//div[@class='webix_column list-series-name webix_first webix_last']/*[" + j + "]//div[@class='series-name-wrapper separator-row ']"))
					.isDisplayed()) {
				Thread.sleep(1000);
				login.driver.findElement(By.xpath(
						"//div[@class='webix_column list-series-name webix_first webix_last']/*[" + j + "]//span[@class='table-container--checkbox svg-checkbox input-control__grey']"))
						.click();
				login.Log4j.info("PASS");
			} else {
				Assert.fail("FAIL");
			}
			}
		}
		

	}

	@Then("^Selected series count should be shown correctly$")
	public void selected_series_count_should_be_shown_correctly() throws Throwable {
		Thread.sleep(3000);
		ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SearchInputSelectedCount")));
		str = ele.getText();
		int series_count = Integer.parseInt(str);
		login.Log4j.info(series_count);
		int selected_series = m;
		login.Log4j.info(selected_series);
		if (selected_series == series_count) {
			login.Log4j.info("Selected series count shown correctly");
		} else {
			AssertJUnit.fail("Selected series count not shown correctly");
		}

	}

	@And("^Select a table and add to my series$")
	public void select_a_table_and_add_to_my_series() throws Throwable {
	
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SelectRussiaDB"))).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SelectNationalAccounts_RussiaDB"))).click();
		Thread.sleep(2000);
		login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("Expand3rdLevel")))
				.click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
				"Expand4thLevel")))
				.click();
		Thread.sleep(1000);
		robot = new Robot();
		// Adding table to Myseries
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand5thLevel"))).click();
		Thread.sleep(2000);
		List<WebElement> listOfSeries = login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("ListOfSeries_DatabasesTab")));
		login.Log4j.info(listOfSeries.size());
		for (int i = 0; i < listOfSeries.size(); i++) {
			Thread.sleep(300);
			str = listOfSeries.get(i).getText();
			// login.Log4j.info(str);
			listOne.add(str);
			login.Log4j.info(listOne);
		}
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("AddTableToMySeries"))).click();
	}

	@Then("^The series in the table should be ordered as in the table in search panel$")
	public void the_series_in_the_table_should_be_ordered_as_in_the_table_in_search_panel() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ExpandTable_InMySeriesTab")))
				.click();

		List<WebElement> listOfSeries = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("Series_Name")));
		login.Log4j.info(listOfSeries.size());
		for (int i = 0; i < listOfSeries.size(); i++) {
			str = listOfSeries.get(i).getText();
			login.Log4j.info(str);
			listTwo.add(str);
		}
		// Validating the series order in the table
		boolean result = Arrays.equals(listOne.toArray(), listTwo.toArray());
		login.Log4j.info(result);
		Assert.assertEquals(listOne.toArray(), listTwo.toArray());
		
	}

	@And("^Select some series from series level$")
	public void select_some_series_from_series_level() throws Throwable {
		select_series_in_any_database();
	}

	@And("^Click on selected series count$")
	public void click_on_selected_series_count() throws Throwable {
		Thread.sleep(3000);
		ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SearchInputSelectedCount")));
		str = ele.getText();
		CommonFunctionality.SeriesCount = Integer.parseInt(str);
		Thread.sleep(2000);
		login.Log4j.info("Clicking on selected series count");
		// ele =
		// login.driver.findElement(By.xpath("//span[@class='search-input--preview-selection']"));
		ele.click();
		Thread.sleep(1000);
		WebElement element = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SearchSelection")));
		BeforeMiniAndMaximize_dimension = element.getSize();
	}

	@Then("^\"([^\"]*)\" panel should be opened$")
	public void panel_should_be_opened(String arg1) throws Throwable {
		if (arg1.equals("Add from My Series")) {
			CommonFunctionality.wait(3000);
			String ExpectedTxt = login.driver
					.findElement(By.xpath("//*[@class='sidebar-panel--tab sidebar-panel--tab__active']")).getText();
			if (arg1.equals(ExpectedTxt)) {
				login.Log4j.info(arg1 + " panel is opened");
				// CommonFunctionality.getElementByXpath(login.driver,
				// "//*[@class='sidebar-panel--header-close']", 5).click();
				// CommonFunctionality.Views_list();
			} else {
				Assert.fail(arg1 + " panel is not opened");
			}

		} else {
			Thread.sleep(3000);
			ele = login.driver.findElement(By.className("search-selection-header--title"));
			String SearchSelectionTxt = ele.getText();
			login.Log4j.info(str);
			if (SearchSelectionTxt.contains(arg1) == true) {
				login.Log4j.info(arg1 + " pop up is opened");
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_searchPanel"))).click();
			} else {
				AssertJUnit.fail(arg1 + " pop up is not opened");
			}
		}
	}

	@And("^Click on series$")
	public void click_on_series() throws Throwable {
		Thread.sleep(3000);
		List<WebElement> list = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("SearchSelection_ListOfSeries")));
		// login.Log4j.info(list.size());
		for (int i = 0; i < list.size(); i++) {
			
			Thread.sleep(4000);
			ele = list.get(i);
			ele.click();
			ssp_window_should_be_opened();
		}
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_searchPanel"))).click();
	}

	@Then("^SSP window should be opened$")
	public void ssp_window_should_be_opened() throws Throwable {
		try {
			Thread.sleep(1500);
			if (login.driver.findElement(By.className("series-preview-modal-header--link")).isDisplayed()) {
				login.Log4j.info("SSP window is opened");
				Thread.sleep(1000);
				login.driver.findElement(By.xpath(
						"//div[@class='movable-modal single-series-preview--modal movable-modal__draggable movable-modal__active']//div[@title='Close']"))
						.click();
			} else {
				AssertJUnit.fail("SSP window is not opened");
			}
		} catch (Exception e) {

		}
	}

	/*
	 * @And("^Observe the series count in Series Selection window$") public void
	 * observe_the_series_count_in_Series_Selection_window() throws Throwable {
	 * Thread.sleep(2000); ele = login.driver.findElement(By.
	 * xpath("//div[@class='single-series-preview--title ']")); str = ele.getText();
	 * login.Log4j.info(str); String[] arr = str.split(" ");
	 * login.Log4j.info(arr[2]); CommonFunctionality.SeriesCount =
	 * Integer.parseInt(arr[2].replaceAll("\\(", ""));
	 * login.Log4j.info(CommonFunctionality.SeriesCount);
	 * 
	 * }
	 */

	@Then("^Series count should be match with available series in Series Selection window$")
	public void series_count_should_be_match_with_available_series_in_selection_window() throws Throwable {
		Thread.sleep(2000);
		List<WebElement> series_list = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("SearchSelection_ListOfSeries")));
		login.Log4j.info(series_list.size());
		if (CommonFunctionality.SeriesCount == series_list.size()) {
			login.Log4j.info("Series count does match with available series");
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_searchPanel"))).click();
		} else {
			AssertJUnit.fail("Series count doesn't match with available series");
		}
	}

	@And("^Click on \\+icon on series$")
	public void click_on_icon_on_series() throws Throwable {
		Thread.sleep(3000);
		ele = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("LastSeriesInSearchSelection")));
		str = ele.getText();
		ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
				"SearchPanel_AddIcon")));
		action.moveToElement(ele).click().build().perform();
		login.Log4j.info("Clicking on + icon on series");

	}

	@And("^Click on \\+icon on header$")
	public void click_on_icon_on_header() throws Throwable {
		Thread.sleep(1200);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
				"SearchSelectionHeader_AddIcon")))
				.click();
		login.Log4j.info("Clicking on + icon on header");

	}

	@And("^Click on dropdown icon next to \\+$")
	public void click_on_dropdown_icon_next_to() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
				"SearchSelection_dropdownIcon")))
				.click();
		login.Log4j.info("Clicking on dropdown icon");
	}

	@Then("^The series should be added to My series panel$")
	public void the_series_should_be_added_to_My_series_panel() throws Throwable {

		ele = CommonFunctionality.getElementByProperty(login.driver, "SelectedSeriesCount_myseries", 4);
		str = ele.getText();
		String[] series_panel_count = str.split(" ");
		int Added_series_Count = Integer.parseInt(series_panel_count[0]);
		// No.of series added to my series
		login.Log4j.info(Added_series_Count);
		if (Added_series_Count == CommonFunctionality.SeriesCount) {
			login.Log4j.info("Selected series added to My series");

		} else {
			AssertJUnit.fail("Selected series not added to My series");

		}
		
	}

	@Then("^The series should add to My series panel$")
	public void the_series_should_add_to_My_series_panel() throws Throwable {
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("seriesList")));
		String mySeries_sname = ele.getText();
		if (str.equalsIgnoreCase(mySeries_sname)) {
			login.Log4j.info("PASS");
		} else {
			Assert.fail("The series is not added to My series panel ");
		}
		
	}

	@And("^Select any series$")
	public void select_any_series() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Databases_Tab"))).click();
		select_a_series();
		login.driver.findElement(By.xpath("//div[@class='series-list-item--checkbox-wrapper']")).click();

	}

	@And("^Close search selection window$")
	public void close_search_selection_window() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
	}

	@Then("^New insight should be created with selected series in my series$")
	public void new_insight_should_be_created_with_selected_series_in_my_series() throws Throwable {
		CommonFunctionality.wait(400);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("confirm_popup_new_insight"))).click();
		robot = new Robot();
		// Store all currently open tabs in tabs
		ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
		// Navigate to New Tab
		login.driver.switchTo().window(tabs2.get(1));
		Thread.sleep(5000);
		the_series_should_be_added_to_My_series_panel();
		login.driver.close();
		login.driver.switchTo().window(tabs2.get(0));
		// close_search_selection_window();
	}

	@And("^Click on \"([^\"]*)\" icon on header$")
	public void click_on_icon_on_header(String arg1) throws Throwable {
		visual = arg1;
		login.Log4j.info("Clickig on " + arg1);
		Thread.sleep(3000);
		if (arg1.equals("Maximize")) {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SearchPanel_FullScreen"))).click();

		} else {
			login.driver.findElement(By.xpath("//div[@title='" + arg1 + "']")).click();

		}
	}

	@And("^Click on close icon$")
	public void click_on_close_icon() throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(
				"//div[@class='search-selection']/*/*[1]//span[@class='series-item--icon series-item--icon__delete']"))
				.click();
	}

	@Then("^The window should be \"([^\"]*)\"$")
	public void the_window_should_be(String arg1) throws Throwable {
		Thread.sleep(3000);
		ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SearchSelection")));
		dimension = ele.getSize();
		if (arg1.equals("minimized")) {
			login.Log4j.info("After " + arg1 + " dimension is  :" + dimension);
			login.Log4j.info("Before minimize dimension is :" + BeforeMiniAndMaximize_dimension);
			if (!BeforeMiniAndMaximize_dimension.equals(dimension)) {
				login.Log4j.info("The window is " + arg1);
			} else {
				AssertJUnit.fail("The window is not " + arg1);
			}
		} else if (arg1.equals("maximized")) {
			login.Log4j.info("Before maximize dimension is :" + BeforeMiniAndMaximize_dimension);
			login.Log4j.info("After maximized dimension is  :" + dimension);
			if (!BeforeMiniAndMaximize_dimension.equals(dimension)) {
				login.Log4j.info("The window is maximized");
			} else {
				AssertJUnit.fail("The window is not maximized");
			}
		}
		Thread.sleep(3000);
		close_search_selection_window();
	}

	/*
	 * @Then("^The window should be maximized$") public void
	 * the_window_should_be_maximized() throws Throwable { Thread.sleep(3000); ele =
	 * login.driver.findElement(By.xpath("//div[@class='search-selection']"));
	 * dimension = ele.getSize(); login.Log4j.info("After minimize dimension is  :"
	 * + dimension); if (!BeforeMinimize_dimension.equals(dimension)) {
	 * login.Log4j.info("The window is maximized"); } else {
	 * AssertJUnit.fail("The window is not maximized"); } }
	 */

	@And("^Click on Exit full-screen icon$")
	public void click_on_Exit_full_screen_icon() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SearchPanel_ExiFullScreen"))).click();
		login.Log4j.info("Clicking on Exit full-screen");
	}

	@Then("^The popup should be displayed in normal size$")
	public void the_popup_should_be_displayed_in_normal_size() throws Throwable {
		Dimension After_ExitFull_screen_dimension;
		Thread.sleep(3000);
		ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SearchSelection")));
		After_ExitFull_screen_dimension = ele.getSize();
		login.Log4j.info(After_ExitFull_screen_dimension);
		if (BeforeMiniAndMaximize_dimension.equals(After_ExitFull_screen_dimension)) {
			login.Log4j.info("The popup is displayed in normal size");
		} else {
			AssertJUnit.fail("The popup is not displayed in normal size");
		}
		Thread.sleep(3000);
		close_search_selection_window();
	}

	@And("^Mouse hover on any series$")
	public void mouse_hover_on_any_series() throws Throwable {
		Thread.sleep(2000);
		ele = login.driver.findElement(
				By.xpath("//div[@class='movable-modal--body-wrapper']/*[1]//div[@class='series-item--name']"));
		str = ele.getText();
		Thread.sleep(1000);
		action.moveToElement(ele).build().perform();
		login.Log4j.info("Mouse hovering on series");
	}

	@Then("^Series count should be reduced as per the series deletion$")
	public void series_count_should_be_reduced_as_per_the_series_deletion() throws Throwable {
		Thread.sleep(2000);
		// after remove one series observe the series count
		ele = login.driver.findElement(By.className("search-selection-header--title"));
		str = ele.getText();
		login.Log4j.info(str);
		String[] arr = str.split(" ");
		login.Log4j.info(arr[2]);
		int AfterRemoveSeries_Count = Integer.parseInt(arr[2].replaceAll("\\(", ""));
		login.Log4j.info(AfterRemoveSeries_Count);
		Assert.assertNotEquals(CommonFunctionality.SeriesCount, AfterRemoveSeries_Count);
		login.Log4j.info("The series count is reduced");
		close_search_selection_window();
	}

	@Then("^The series should be removed from the popup$")
	public void the_series_should_be_removed_from_the_popup() throws Throwable {
		Thread.sleep(3000);
		List<WebElement> seriesList = login.driver
				.findElements(By.xpath("//div[@class='search-selection']//div[@class='series-item--name']"));
		for (int i = 0; i < seriesList.size(); i++) {
			int j = i + 1;
			Thread.sleep(3000);
			ele = login.driver.findElement(
					By.xpath("//div[@class='search-selection']/*/*[" + j + "]//div[@class='series-item--name']"));
			String str1 = ele.getText();
			if (!str1.equals(str)) {
				login.Log4j.info("The series is removed from the popup as per the deletion");
				break;
			} else {
				AssertJUnit.fail("The series is not removed from the popup as per the deletion");
			}
		}

		close_search_selection_window();
	}

	@Then("^The window should be closed$")
	public void the_window_should_be_closed() throws Throwable {
		Thread.sleep(2000);
		try {
			if (!login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SearchSelection_Window"))).isDisplayed()) {

			}
		} catch (NoSuchElementException e) {
			login.Log4j.info("The window is closed");
		}
	}

	@Then("^\"([^\"]*)\" icon should be displayed for series$")
	public void icon_should_be_displayed_for_series(String arg1) throws Throwable {
		Thread.sleep(2000);
		login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("Expand5thLevel")))
				.click();
		Thread.sleep(2000);
		//WebElement ul_element = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("UL")));
		List<WebElement> ListOfSeries = login.driver.
				findElements(By.xpath("//div[@unselectable='on']//span[@class='status-icon--sign']"));
		login.Log4j.info("List size is :" + ListOfSeries.size());

		for (int i = 0; i < ListOfSeries.size(); i++) {

			login.Log4j.info(i);
			// login.Log4j.info(ListOfSeries.size());
			// int j = i + 1;
			Thread.sleep(2000);
			if (arg1.equals("NEW")) {
				try {
					ele = ListOfSeries.get(i);
					// action.moveToElement(ele).build().perform();

				} catch (NoSuchElementException e) {
					login.Log4j.error("Series name is null");
					int j = i + 1;
					ele = ListOfSeries.get(j);
					// action.moveToElement(ele).build().perform();

				} finally {
					// Until the element is not visible keep scrolling
					// jse.executeScript("arguments[0].scrollIntoView(true);", ele);
					// String New_icon = ele.getText();
					try {
						String New_icon = ele.getText();
						if (New_icon.equalsIgnoreCase(arg1) == true) {
							login.Log4j.info(arg1 + " label is shown for series level");
						}
					} catch (NullPointerException e) {
						CommonFunctionality.ResetMethod();
						AssertJUnit.fail(arg1 + " label is not shown for series level");

					}
				}
			} else if (arg1.equals("k")) {
				try {
					ele = ListOfSeries.get(i);
					// action.moveToElement(ele).build().perform();

				} catch (NoSuchElementException e) {
					login.Log4j.error("Series name is null");
					int j = i + 1;
					ele = ListOfSeries.get(j);
					// action.moveToElement(ele).build().perform();

				} finally {
					// Until the element is not visible keep scrolling
					// jse.executeScript("arguments[0].scrollIntoView(true);", ele);
					try {
						String Key_icon = ele.getText();
						if (Key_icon.equalsIgnoreCase(arg1) == true) {
							login.Log4j.info(arg1 + " icon is shown for series level");
						}
					} catch (NullPointerException e) {
						CommonFunctionality.ResetMethod();
						AssertJUnit.fail(arg1 + " icon is not shown for series level");

					}
				}
			} else if (arg1.equals("f")) {
				try {
					ele = ListOfSeries.get(i);
					// action.moveToElement(ele).build().perform();

				} catch (NoSuchElementException e) {
					login.Log4j.error("Series name is null");
					int j = i + 1;
					ele = ListOfSeries.get(j);
					// action.moveToElement(ele).build().perform();

				} finally {
					// Until the element is not visible keep scrolling
					// jse.executeScript("arguments[0].scrollIntoView(true);", ele);
					try {
						String forecast_icon = ele.getText();
						if (forecast_icon.equalsIgnoreCase(arg1) == true) {
							login.Log4j.info(arg1 + " icon is shown for series level");
						}
					} catch (NullPointerException e) {
						CommonFunctionality.ResetMethod();
						AssertJUnit.fail(arg1 + " icon is not shown for series level");

					}
				}
			} else if (arg1.equals("s")) {
				try {
					ele = ListOfSeries.get(i);
					// action.moveToElement(ele).build().perform();

				} catch (NoSuchElementException e) {
					login.Log4j.error("Series name is null");
					int j = i + 1;
					ele = ListOfSeries.get(j);
					// action.moveToElement(ele).build().perform();

				} finally {
					// Until the element is not visible keep scrolling
					// jse.executeScript("arguments[0].scrollIntoView(true);", ele);
					try {
						String rebased_icon = ele.getText();
						if (rebased_icon.equalsIgnoreCase(arg1) == true) {
							login.Log4j.info(arg1 + " icon is shown for series level");
						}
					} catch (NullPointerException e) {
						CommonFunctionality.ResetMethod();
						AssertJUnit.fail(arg1 + " icon is not shown for series level");

					}
				}
			}
		}
		// CommonFunctionality.TopMethod();
		// CommonFunctionality.ResetMethod();
		// CommonFunctionality.CollapseTreeMethod();

	}

	@And("^Database tab should be loaded as default tab for the insight$")
	public void database_tab_should_be_loaded_as_default_tab_for_the_insight() throws Throwable {
		Thread.sleep(3000);
		String SearchTxt;
		ele = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Databases")));
		if (ele.isDisplayed()) {
			SearchTxt = ele.getText();
			login.Log4j.info(SearchTxt);
			if (SearchTxt.equals("Databases")) {
				login.Log4j.info("Database tab is loaded as default tab");
			} else {
				Assert.fail("Database tab is not loaded as default tab");
			}

		}
		/*
		 * String color = login.driver .findElement(By.className(
		 * "toggler-control-item toggler-control-item__selected"))
		 * .getCssValue("color"); login.Log4j.info("RGB_Color: " + color); String hex =
		 * Color.fromString(color).asHex(); System.out.println("Actual hex value is :" +
		 * hex); // verify with Actual hex value with Expected hex value String expected
		 * = "#069a9a"; Assert.assertEquals(hex, expected);
		 */

	}

	@And("^Make View pannel as fullscreen$")
	public void make_View_pannel_as_fullscreen() throws Throwable {
		Thread.sleep(5000);
		login.driver
				.findElement(
						By.xpath(login.LOCATORS.getProperty("ExpandViewPanelToRight")))
				.click();
	}

	@And("^Right click on any of the series$")
	public void right_click_on_any_of_the_series() throws Throwable {
		CommonFunctionality.UnselectMethod();
		expand_World_Trend_Plus_till_series_level();
		// WebElement ul_element =
		// login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		CommonFunctionality.getElementByXpath(login.driver,
				"(//*[@class='database-representation--tree']//div[@class='series-list-item--checkbox-wrapper'])[1]",
				6).click();
		ele = login.driver.findElement(
				By.xpath("(//*[@class='database-representation--tree']//div[@class='series-item--name'])[1]"));
		CommonFunctionality.sname = ele.getText();
		Thread.sleep(1000);
		action.contextClick(ele).build().perform();
	}

	@Then("^Search panel should be exapanded and Databases tab should be loaded$")
	public void search_panel_should_be_exapanded_and_Databases_tab_should_be_loaded() throws Throwable {
		database_tab_should_be_loaded_as_default_tab_for_the_insight();
		login.Log4j.info("Search pannel is expanded and Databases tab is loaded");
	}

	@And("^Create a \"([^\"]*)\" insight$")
	public static void create_a_insight(String arg1) throws Throwable {
		
		CommonFunctionality.wait(1500);
		WebElement file = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("File_dropdown")));
		file.click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='items-wrapper']//*[contains(text(),'" + arg1 + "')]", 15)
				.click();
		CommonFunctionality.getElementByProperty(login.driver, "Create_insight", 15).click();

	}

	static void AfterMethod() throws InterruptedException {
		Thread.sleep(2000);
		WebElement SeriesCount = login.driver.findElement(By.cssSelector(".series-series-count--number"));
		String after_apply_filter = SeriesCount.getText();
		login.Log4j.info(after_apply_filter);
		String[] count = after_apply_filter.split(" ");
		String newStr = count[0].replaceAll(",", "");
		afterFilter = Integer.parseInt(newStr);
	}

	static void BeforeMethod() throws InterruptedException {
		Thread.sleep(2000);
		WebElement SeriesCount = login.driver.findElement(By.cssSelector(".series-series-count--number"));
		String before_apply_filter = SeriesCount.getText();
		login.Log4j.info(before_apply_filter);
		String[] count1 = before_apply_filter.split(" ");
		String newStr = count1[0].replaceAll(",", "");
		beforeFilter = Integer.parseInt(newStr);
	}

	void SetLangugeEnglish() throws InterruptedException {
		CommonFunctionality.wait(2000);
		ele = login.driver.findElement(By.xpath("//span[contains(text(),'Set language')]"));
		CommonFunctionality.action.moveToElement(ele).click().build().perform();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li[2]")).click();
	}

	static void BrazilPremiumDb() throws InterruptedException {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Databases_Tab"))).click();
		// Right clicking on Brazil Premium Database for table level
		CommonFunctionality.getElementByProperty(login.driver, "SelectBrazilDB", 20).click();
		CommonFunctionality.wait(5000);
		CommonFunctionality.getElementByProperty(login.driver, "SelectNationalAccountsFromBrazilDB", 4).click();
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByProperty(login.driver, "SelectGrossDomesticProduct", 6).click();
		CommonFunctionality.wait(2000);
	}
static void MoreFilterNotApplied_BRAZILPremiumDB() {
	CommonFunctionality.getElementByProperty(login.driver, "SelectBrazilDB", 20).click();
	CommonFunctionality.wait(5000);
	CommonFunctionality.getElementByProperty(login.driver, "SelectTopicLevel_BrazilDB", 4).click();
	CommonFunctionality.wait(4000);
	CommonFunctionality.getElementByProperty(login.driver, "SelectSectionLevel_BrazilDB", 6).click();
	CommonFunctionality.wait(2000);
}
	void PopularSeriesMethod() throws InterruptedException {

		ele = CommonFunctionality.wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Popular Series')]")));
		CommonFunctionality.jse.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

	void TotalUsageValidation() throws InterruptedException {
		Thread.sleep(1500);
		login.driver.findElement(By.xpath(
				"//div[@class='all-representation--content']//div[@class='popular-series all-item']//div[contains(text(),'View more')]"))
				.click();
		WebElement popularity = CommonFunctionality.wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Popularity')]")));
		if (popularity.isDisplayed()) {
			login.Log4j.info("PASS");
		} else {
			Assert.fail("Popularity is not displayed");
		}
	}

}
