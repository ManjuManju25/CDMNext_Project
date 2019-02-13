package CDMNext.StepDefinations;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.AssertJUnit;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DatabasesTab {
	public String Db;
	Boolean database = false;
	public WebElement footnote;
	public String dbstr;
	public String beforeDb;
	ArrayList<String> tabs2;
	public WebElement footnoteDb;
	public String str;
	public WebElement cross_icon;
	String[] dbarr;
	String[] DataBase;
	Boolean closeVar = false;
	public String countryVar;
	static int afterFilter;
	static int beforeFilter;
	public WebElement rightClickElement;
	public String Before_set_lang;
	public String After_set_lang;
	public String dbase;
	public WebElement copy_link;
	public WebElement ele;
	public WebElement checkbox;
	Robot robot;
	// create object of Actions class
	public static final Actions action = new Actions(login.driver);
	// create instance of JavaScriptExecutor
	public static final JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	SoftAssert s_assert = new SoftAssert();

	@Given("^Click on All Databases dropdown$")
	public void click_on_All_Databases_dropdown() throws Throwable {
		// SearchTest.ClearSelection();
		AlldbClear();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).clear();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_Databases"))).click();
		login.Log4j.info("Clicking on All databases tab ");
	}

	@And("^Select database as \"([^\"]*)\"$")
	public void select_database_as(String arg1) throws Throwable {

		DataBase = arg1.split(",");
		for (String dblist : DataBase) {
			Thread.sleep(2000);
			login.Log4j.info("Selecting " + dblist);
			List<WebElement> checkbox = login.driver.findElements(By.xpath("//div//span[contains(text(),'" + dblist
					+ "')]/preceding-sibling::label/span[@class='input-control--indicator']"));
			if (checkbox.size() > 0) {

				login.driver.findElement(By.xpath("//div//span[contains(text(),'" + dblist
						+ "')]/preceding-sibling::label/span[@class='input-control--indicator']")).click();
			} else {
				login.driver.findElement(By.xpath("//span[contains(text(),'" + dblist + "')]")).click();
			}

		}

	}

	@Then("^Result should be loaded only for selected database$")
	public void result_should_be_loaded_only_for_selected_database() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Databases"))).click();
		dbarr = DataBase[0].split(" ");
		if (DataBase[0].equals("India Premium Database")) {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("DB_level_1"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("GDP"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("table-level"))).click();
			Thread.sleep(2000);
			DatabaseValidation();
			if (database == true) {
				login.Log4j.info("Results is shown correctly for selected " + DataBase[0]);

			} else if (database == false) {
				Assert.fail("Results is not shown correctly for selected " + DataBase[0]);
			}

		}
	}

	@And("^Select database as Daily Database$")
	public void select_database_as_Daily_Database() throws Throwable {
		AlldbClear();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Daily_db"))).click();
		login.Log4j.info("Clicking on Database level");
		database = true;
	}

	@And("^Expand till series level$")
	public void expand_till_series_level() throws Throwable {
		Thread.sleep(2000);
		if (database == true) {
			login.driver
					.findElement(By.xpath(
							"//div[@class='database-node tree-node open']//div[3]//div[1]//div[@class='toggle']"))
					.click();
			login.Log4j.info("Clicking on Topic level");
			Thread.sleep(2000);
			login.driver
					.findElement(
							By.xpath("//div[@class='tree-node open']//div[@class='child-container']//div[1]//div[1]"))
					.click();
			login.Log4j.info("Clicking on Section level");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(
					"//div[@class='tree-node open']//div[@class='child-container']//div[1]//div[@class='tree-node']//div[@class='toggle']"))
					.click();
			login.Log4j.info("Clicking on Table level");
		} else {
			login.driver.findElement(By.xpath("//div[@class='child-container']//div[2]//div[1]//div[@class='toggle']"))
					.click();
			login.Log4j.info("Clicking on Topic level");
			Thread.sleep(2000);
			login.driver
					.findElement(
							By.xpath("//div[@class='child-container']//div[2]//div[1]//div[1]//div[@class='toggle']"))
					.click();
			login.Log4j.info("Clicking on Section level");
			Thread.sleep(2000);
			login.driver
					.findElement(By.xpath(
							"//div[@class='child-container']//div[2]//div[1]//div[1]//div[1]//div[@class='toggle']"))
					.click();
			login.Log4j.info("Clicking on Table level");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(
					"//div[@class='child-container']//div[2]//div[1]//div[1]//div[1]//div[1]//div[@class='toggle']"))
					.click();
			login.Log4j.info("Clicking on Series level");
		}

	}

	@Then("^Should able to expand all the DB/Topic/section/table under Databases tab$")
	public void should_able_to_expand_all_the_DB_Topic_section_table_under_Databases_tab() throws Throwable {
		Thread.sleep(2000);
		checkbox = login.driver.findElement(By.xpath(
				"//div[@class='child-container']//div[1]//ul//a//div[@class='series-list-item--checkbox-wrapper']//span"));
		if (checkbox.isDisplayed()) {
			checkbox.click();
			login.Log4j.info("DB/Topic/section/table level under Databases tab is expanded");
		} else {
			login.Log4j.info("DB/Topic/section/table level under Databases tab is not expanded");
		}
	}

	@And("^Select Global database$")
	public void select_global_database() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='child-container']//div[2]//div[@class='toggle']")).click();
		login.Log4j.info("Clicking on Global Database");
	}

	@And("^Click on Collapse option$")
	public void click_on_Collapse_option() throws Throwable {
		login.Log4j.info("Clicking on Collapse option");
	}

	@Then("^Opened data tree should be collapsed$")
	public void opened_data_tree_should_be_collapsed() throws Throwable {
		Thread.sleep(2000);
		WebElement collapse;
		collapse = login.driver.findElement(By.xpath("//span[contains(text(),'Collapse')]"));
		if (collapse.isEnabled()) {
			collapse.click();
			login.Log4j.info("Open data tree is collapsed");
		} else {
			AssertJUnit.fail("Open data tree is not collapse");
		}
	}

	@And("^Select any number of series$")
	public void select_any_number_of_series() throws Throwable {
		Thread.sleep(3000);
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
					Thread.sleep(2000);
					int j = i + 1;
					checkbox = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
					checkbox.click();
					// Until the element is not visible keep scrolling
					jse.executeScript("arguments[0].scrollIntoView(true);", checkbox);
				}
			}
		} catch (NoSuchElementException e) {
			AssertJUnit.fail(e.getMessage());
		}

	}

	@Then("^Selected series should be unselected$")
	public void selected_series_should_be_unselected() throws Throwable {
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unselect"))).isEnabled()) {
			login.Log4j.info("The selected series are got unselected");
		} else {
			AssertJUnit.fail("The selected series are not unselected");
		}
	}

	@Given("^Hover the mouse on any Database$")
	public void hover_the_mouse_on_any_Database() throws Throwable {
		Thread.sleep(3000);
		WebElement db;
		login.driver
				.findElement(By
						.xpath("//div[@class='search-presentation-tabs--visible']//span[contains(text(),'Databases')]"))
				.click();
		Actions action = new Actions(login.driver);
		db = login.driver.findElement(By.xpath("//div[@class='child-container']//div[1]//div[2]"));
		ele = login.driver.findElement(
				By.xpath("//div[@class='child-container']//div[1]//div[@class='title']//span[@class='name']//span[1]"));
		dbstr = ele.getText();
		login.Log4j.info("Database is " + dbstr);
		Thread.sleep(1000);
		action.moveToElement(db).build().perform();
	}

	@Then("^Footnotes icon should be displayed$")
	public void footnotes_icon_should_be_displayed() throws Throwable {
		Thread.sleep(2000);
		footnote = login.driver
				.findElement(By.xpath("//div[@class='child-container']//div[1]//span//i[@title='Open footnote']"));
		if (footnote.isDisplayed()) {
			login.Log4j.info("footnote icon is enabled when mouse hover on the databse");
		} else {
			AssertJUnit.fail("footnote icon is not enabled when mouse hover on the databse");
		}
	}

	@When("^Click on footnote's icon$")
	public void click_on_footnote_s_icon() throws Throwable {
		footnote.click();
		login.Log4j.info("Clicking on footnote icon");
	}

	@Then("^Footnotes should be opened for related DB$")
	public void footnotes_should_be_opened_for_related_DB() throws Throwable {
		// Thread.sleep(2000);
		footnoteDb = login.driver.findElement(
				By.xpath("//div[@class='footnotes--main-actions']//div[@class='footnotes-bread-crumb--title']"));
		Thread.sleep(2000);
		str = footnoteDb.getText();
		login.Log4j.info(str);
		if (str.contains(dbstr) == true) {
			login.Log4j.info("Footnotes is displayed for mouse hover action on DB level");
			Thread.sleep(1500);
			login.driver.findElement(By.xpath("//div[@title='Close']")).click();
		} else {
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//div[@title='Close']")).click();
			AssertJUnit.fail("Footnotes is not displayed for mouse hover action on DB level");
		}
	}

	@Given("^Right click on any Database$")
	public void right_click_on_any_Database() throws Throwable {
		Thread.sleep(3000);
		WebElement dbele;
		dbele = login.driver
				.findElement(By.xpath("//div[@class='child-container']//div[2]//div[2]//span[@class='name-text']"));
		dbstr = dbele.getText();
		login.Log4j.info("dbele is " + dbstr);
		Actions act = new Actions(login.driver);
		rightClickElement = login.driver.findElement(By.xpath("//div[@class='child-container']//div[2]//div[2]"));
		// contextClick() method to do right click on the element
		act.contextClick(rightClickElement).build().perform();
	}

	@When("^Paste it in new tab$")
	public void paste_it_in_new_tab() throws Throwable {
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
			tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
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
			robot.keyRelease(KeyEvent.VK_ENTER);

		}
	}

	@Then("^The selected DB should be highlighted$")
	public void the_selected_DB_should_be_highlighted() throws Throwable {
		Thread.sleep(10000);
		WebElement highlightddb = login.driver
				.findElement(By.xpath("//div[@class='database-node tree-node open highlight']"));
		if (highlightddb.isDisplayed()) {
			login.Log4j.info("The selected DB is highlighted for right click action Copy link(s)");
		} else {
			AssertJUnit.fail("The selected DB is not highlighted for right click action Copy link(s)");
		}
		login.driver.close();
		login.driver.switchTo().window(tabs2.get(0));
	}

	@Then("^Footnotes should be opened for selected DB$")
	public void footnotes_should_be_opened_for_selected_DB() throws Throwable {
		footnoteDb = login.driver.findElement(
				By.xpath("//div[@class='footnotes--main-actions']//div[@class='footnotes-bread-crumb--title']"));
		str = footnoteDb.getText();
		login.Log4j.info(str);
		if (str.contains(dbstr) == true) {
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//div[@title='Close']")).click();
			login.Log4j.info("Footnotes is displayed for right click action on DB level");

		} else {
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//div[@title='Close']")).click();
			AssertJUnit.fail("Footnotes is not displayed for right click action on DB level");
		}
	}

	@And("^Click on x icon to remove DB$")
	public void click_on_x_icon_to_remove_DB() throws Throwable {
		cross_icon = login.driver
				.findElement(By.xpath("//div[@class='icon--red-cross database-selector--clear-icon']"));
		Thread.sleep(1000);
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
		Thread.sleep(2000);
		login.driver
				.findElement(By
						.xpath("//div[@class='search-presentation-tabs--visible']//span[contains(text(),'Databases')]"))
				.click();
		Thread.sleep(5000);
		List<WebElement> multidb = login.driver
				.findElements(By.xpath("//div[@class='child-container']//div[@class='database-node tree-node']"));
		login.Log4j.info("Size of database selection is " + multidb.size());
		for (int i = 0; i < multidb.size(); i++) {
			login.Log4j.info(DataBase[0]);
			login.Log4j.info(DataBase[1]);
			login.Log4j.info(DataBase[2]);
			login.Log4j.info(i);
			Thread.sleep(3000);
			if (DataBase[i].equalsIgnoreCase("China Premium Database")) {
				dbarr = DataBase[i].split(" ");
				login.driver.findElement(By.xpath("//div[@class='child-container']//div[3]//div[1]")).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath("//div[@class='child-container']//div[3]/div[1]//div[1]")).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(
						"//div[@class='child-container']//div[3]//div[@class='child-container']//div[1]//div[3]//div[1]//div[@class='toggle']"))
						.click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(
						"//div[@class='child-container']//div[3]//div[@class='child-container']//div[1]//div[3]//div[1]//div[3]//div[1]//div[@class='toggle']"))
						.click();
				DatabaseValidation();
				if (database == true) {
					login.Log4j.info("Results is shown correctly for selected " + DataBase[i]);

				} else if (database == false) {
					Assert.fail("Results is not shown correctly for selected " + DataBase[i]);
				}

			} else if (DataBase[i].equalsIgnoreCase("Brazil Premium Database")) {
				dbarr = DataBase[i].split(" ");
				login.driver.findElement(By.xpath("//div[@class='child-container']//div[1]//div[1]")).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath("//div[@class='child-container']//div[1]//div[1]//div[1]")).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(
						"//div[@class='child-container']//div[1]//div[@class='child-container']//div[1]//div[3]//div[2]//div[@class='toggle']"))
						.click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(
						"//div[@class='child-container']//div[1]//div[@class='child-container']//div[1]//div[3]//div[2]//div[3]//div[1]//div[@class='toggle']"))
						.click();
				DatabaseValidation();
				if (database == true) {
					login.Log4j.info("Results is shown correctly for selected " + DataBase[i]);

				} else if (database == false) {
					Assert.fail("Results is not shown correctly for selected " + DataBase[i]);
				}

			} else {
				dbarr = DataBase[i].split(" ");
				login.driver.findElement(By.xpath("//div[@class='child-container']//div[2]//div[1]")).click();
				Thread.sleep(2000);
				login.driver.findElement(By
						.xpath("//div[@class='child-container']//div[2]/div[@class='child-container']//div[1]//div[1]"))
						.click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(
						"//div[@class='child-container']//div[2]/div[@class='child-container']//div[1]//div[3]//div[1]//div[@class='toggle']"))
						.click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(
						"//div[@class='child-container']//div[2]//div[@class='child-container']//div[1]//div[3]//div[1]//div[3]//div[1]//div[@class='toggle']"))
						.click();
				DatabaseValidation();
				if (database == true) {
					login.Log4j.info("Results is shown correctly for selected " + DataBase[i]);
				} else if (database == false) {
					Assert.fail("Results is not shown correctly for selected " + DataBase[i]);
				}

			}
		}

	}

	@Given("^Click on \"([^\"]*)\" option$")
	public void click_on_option(String arg1) throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).clear();
		if (login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).isDisplayed()) {
			Thread.sleep(5000);
			login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();
			login.Log4j.info("Clicking on " + arg1);
		} else {
			Assert.fail(arg1 + " is not displayed");
		}

	}

	@When("^Click on Close$")
	public void click_on_Close() throws Throwable {
		Thread.sleep(2000);
		WebElement close_icon = login.driver.findElement(By.xpath("//div[@ui='$close']"));
		if (close_icon.isDisplayed()) {
			Thread.sleep(1000);
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
			Assert.fail("Insight Explorer popup is not closed");
		}
	}

	@And("^Select filter \"([^\"]*)\" as \"([^\"]*)\"$")
	public void select_filter_as(String arg1, String arg2) throws Throwable {
		countryVar = arg2;
		Thread.sleep(2000);
		AlldbClear();
		if (arg1.equals("Region")) {
			login.Log4j.info("clicking on " + arg1);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("region_filter"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//tr[@title='" + arg2 + "']")).click();

		}
	}

	@Then("^Result should be displayed as per the filters applied$")
	public void result_should_be_displayed_as_per_the_filters_applied() throws Throwable {
		WebElement element;
		WebElement topButton;
		WebElement collapseTree;

		login.driver
				.findElement(By
						.xpath("//div[@class='search-presentation-tabs--visible']//span[contains(text(),'Databases')]"))
				.click();
		Thread.sleep(2000);
		login.driver
				.findElement(
						By.xpath("//div[@class='child-container']//div[@class='database-node tree-node'][2]/div[1]"))
				.click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='database-node tree-node open']//div[3]//div[1]//div[1]"))
				.click();
		Thread.sleep(2000);
		login.driver
				.findElement(By
						.xpath("//div[@class='database-node tree-node open']//div[3]//div[1]//div[3]//div[1]//div[1]"))
				.click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(
				"//div[@class='database-node tree-node open']//div[3]//div[1]//div[3]//div[1]//div[3]//div[@class='tree-node'][6]//div[@class='toggle']"))
				.click();
		WebElement ul_element = login.driver.findElement(By.xpath("//ul[@class='search-series-list scrollable']"));
		List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
		login.Log4j.info("List size is :" + li_All.size());
		for (int i = 0; i < li_All.size(); i++) {
			Thread.sleep(3000);
			login.Log4j.info(i);
			login.Log4j.info(li_All.size());
			int j = i + 1;
			try {
				element = login.driver.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
				element.click();
				// Until the element is not visible keep scrolling
				jse.executeScript("arguments[0].scrollIntoView(true);", element);
			} catch (NoSuchElementException e) {
				login.Log4j.error("Series name is null");
				int k = j + 1;
				element = login.driver.findElement(By.xpath("//li[" + k + "]//div[@class='series-item--name']"));
				element.click();
				// Until the element is not visible keep scrolling
				jse.executeScript("arguments[0].scrollIntoView(true);", element);
			} finally {
				WebElement region = login.driver.findElement(By.xpath(
						"//div[@class='main-series-information--field']//div[@class='main-series-information--field-value']//div[1]//div[1]"));
				String rgnstr = region.getText();
				login.Log4j.info(countryVar);
				login.Log4j.info(rgnstr);
				if (countryVar.equalsIgnoreCase(rgnstr) == true) {
					login.Log4j.info("Results has shown correctly for applied region filter is " + countryVar);
					Thread.sleep(1000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
				} else {
					login.Log4j.info("Results has not shown correctly for applied region filter is " + countryVar);
					Thread.sleep(1000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
				}
			}
		}
		topButton = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TopButton")));
		collapseTree = login.driver.findElement(By.xpath("//span[@title='Collapse tree']"));
		if (topButton.isDisplayed()) {
			Thread.sleep(2000);
			topButton.click();
		}
		if (collapseTree.isDisplayed()) {
			Thread.sleep(2000);
			collapseTree.click();
		}
	}

	@When("^Click on x icon$")
	public void click_on_x_icon() throws Throwable {
		AfterMethod();
		login.Log4j.info("After applied filter series count is " + afterFilter);
		login.driver.findElement(By.xpath(
				"//div[@class='dropdown-filters-list']//div[3]//span[2]//span[@class='select-field--cross-icon']"))
				.click();
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
			Assert.fail("The applied filter has not been removed");
		}

	}

	@Then("^The \"([^\"]*)\" popup should be opened$")
	public void the_popup_should_be_opened(String arg1) throws Throwable {
		Thread.sleep(2000);
		WebElement keywrd_search_tips_popup = login.driver
				.findElement(By.xpath("//h4[contains(text(), '" + arg1 + "')]"));
		if (keywrd_search_tips_popup.isDisplayed()) {
			login.Log4j.info(arg1 + " popup is displayed");
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		} else {
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			Assert.fail(arg1 + " popup is not displayed");
		}

	}

	@Then("^User should redirect to \"([^\"]*)\"$")
	public void user_should_redirect_to(String arg1) throws Throwable {
		Thread.sleep(2000);
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
		} else {
			Assert.fail("User is unable to redirect to " + arg1);
		}

		login.driver.close();
		login.driver.switchTo().window(tabs2.get(0));
	}

	public void DatabaseValidation() throws InterruptedException {
		WebElement element;
		WebElement ul_element = login.driver.findElement(By.xpath("//ul[@class='search-series-list scrollable']"));
		List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
		login.Log4j.info("List size is :" + li_All.size());
		for (int i = 0; i < li_All.size(); i++) {
			Thread.sleep(3000);
			login.Log4j.info(i);
			login.Log4j.info(li_All.size());
			int j = i + 1;
			try {
				element = login.driver.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
				element.click();
				// Until the element is not visible keep scrolling
				jse.executeScript("arguments[0].scrollIntoView(true);", element);
			} catch (NoSuchElementException e) {
				login.Log4j.error("Series name is null");
				int k = j + 1;
				element = login.driver.findElement(By.xpath("//li[" + k + "]//div[@class='series-item--name']"));
				element.click();
				// Until the element is not visible keep scrolling
				jse.executeScript("arguments[0].scrollIntoView(true);", element);
			} finally {
				WebElement region = login.driver.findElement(By.xpath(
						"//div[@class='main-series-information--field']//div[@class='main-series-information--field-value']//div[1]//div[1]"));
				String rgnstr = region.getText();
				login.Log4j.info(dbarr[0]);
				login.Log4j.info(rgnstr);
				if (rgnstr.contains(dbarr[0]) == true) {
					database = true;
					HTML_Report.strTCResult = "PASS";
					Thread.sleep(1000);
					login.driver.findElement(By.xpath("//div[@class='movable-modal--close']")).click();
				} else {
					database = false;
					HTML_Report.strTCResult = "FAIL";
					Thread.sleep(1000);
					login.driver.findElement(By.xpath("//div[@class='movable-modal--close']")).click();
				}
			}
		}
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TopButton"))).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[@title='Collapse tree']")).click();
	}

	@Then("^The data tree should be expanded$")
	public void the_data_tree_should_be_expanded() throws Throwable {
		Thread.sleep(2000);
		WebElement data_tree_ele = login.driver.findElement(
				By.xpath("//div[@class='database-node tree-node open']//div[1]//div[1]//div[3]//div[1]//div[2]"));
		if (data_tree_ele.isDisplayed()) {
			Actions act = new Actions(login.driver);
			Thread.sleep(1000);
			act.moveToElement(data_tree_ele).build().perform();
			login.Log4j.info("The data tree is expanded");
		} else {
			Assert.fail("The data tree is not expanded");
		}
	}

	@Then("^The data tree should be collapsed$")
	public void the_data_tree_should_be_collapsed() throws Throwable {
		login.Log4j.info("The data tree is collapsed");
	}

	@Then("^\"([^\"]*)\" message should be displayed$")
	public void message_should_be_displayed(String arg1) throws Throwable {
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath("//p[contains(text(),'" + arg1 + "')]"));
		String noResults = ele.getText();
		// login.Log4j.info(noResults);
		// Assert.assertEquals(true, ele.isDisplayed());
		// Assert.assertEquals(noResults, arg1," is displayed for invalid Keyword");
		if (ele.isDisplayed()) {
			login.Log4j.info(noResults + "is displayed for invalid Keyword ");
		} else {
			Assert.fail(noResults + "is not displayed for invalid Keyword ");
		}

	}

	@Given("^Right click on any database$")
	public void right_click_on_any_database() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).clear();
		rightClickElement = login.driver
				.findElement(By.xpath("//div[@class='child-container']//div[1]//span[@class='name-text']"));
		String str = rightClickElement.getText();
		login.Log4j.info(str);
		Thread.sleep(4000);
		// contextClick() method to do right click on the element
		action.contextClick(rightClickElement).build().perform();
	}

	@Then("^\"([^\"]*)\" options should be available$")
	public void options_should_be_available(String arg1) throws Throwable {
		String[] array = arg1.split(",");
		Thread.sleep(2000);
		WebElement ul_element = login.driver.findElement(By.cssSelector(".context-menu"));
		String rightClick_str = ul_element.getText();
		login.Log4j.info(rightClick_str);
		if (array.length == 3) {
			if (rightClick_str.contains(array[0]) == true && rightClick_str.contains(array[1]) == true
					&& rightClick_str.contains(array[2]) == true) {
				login.Log4j.info(array[0] + " AND " + array[1] + " AND " + array[2]
						+ " options available for right click option for DB level");

			} else {
				Assert.fail(array[0] + " AND" + array[1] + " AND" + array[2]
						+ " options not available for right click option for DB level");
			}
		} else if (array.length == 2) {
			if (rightClick_str.contains(array[0]) == true && rightClick_str.contains(array[1]) == true) {
				login.Log4j.info(
						array[0] + " AND " + array[1] + " options available for right click option for topic level");

			} else {
				Assert.fail(
						array[0] + " AND" + array[1] + " options not available for right click option for topic level");
			}
		}

	}

	@And("^After loaded the results ,click on Remove for search keyword$")
	public void after_loaded_the_results_click_on_Remove_for_search_keyword() throws Throwable {
		AfterMethod();
		login.Log4j.info("After search with keyword,the series count is: " + afterFilter);

	}

	@Then("^The result should be loaded without search$")
	public void the_result_should_be_loaded_without_search() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.className("search-input-field-wrap-inner")).click();
		BeforeMethod();
		login.Log4j.info("Before searching with keyword,the series count is : " + beforeFilter);
		if (beforeFilter > afterFilter) {
			login.Log4j.info("The result is loaded without search");
		} else {
			Assert.fail("The result is not loaded without search");
		}

	}

	@And("^Right click on \"([^\"]*)\"$")
	public void right_click_on(String arg1) throws Throwable {
		dbase = arg1;
		switch (arg1) {
		case "World Trend Plus":
			Thread.sleep(2000);
			rightClickElement = login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]"));
			Before_set_lang = rightClickElement.getText();
			break;
		case "Russia Premium Database":
			Thread.sleep(2000);
			rightClickElement = login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]"));
			Before_set_lang = rightClickElement.getText();
			break;
		case "Indonesia Premium Database":
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@data-node-model-id='INDONESIA']//div[@class='toggle']")).click();
			Thread.sleep(2000);
			ele = login.driver.findElement(By.xpath(
					"//div[@data-node-model-id='INDONESIA']//div[@class='child-container']//div[1]//span[@class='name-text']"));
			Before_set_lang = ele.getText();
			rightClickElement = login.driver.findElement(
					By.xpath("//div[@data-node-model-id='INDONESIA']//span[contains(text(),'" + arg1 + "')]"));
			break;
		case "Global Database":
			Thread.sleep(2000);
			WebElement obj = login.driver.findElement(By.xpath("//li[1]//div[@class='series-item--name']"));
			Before_set_lang = obj.getText();
			rightClickElement = login.driver.findElement(
					By.xpath("//div[@data-node-model-id='GLOBAL']//span[contains(text(),'" + arg1 + "')]"));
			break;
		default:
			Assert.fail("Doesn't exist in given databse list");
		}
		login.Log4j.info("Before_set_lang is " + Before_set_lang);
		Thread.sleep(4000);
		// contextClick() method to do right click on the element
		action.contextClick(rightClickElement).build().perform();

	}

	@And("^Set language as \"([^\"]*)\"$")
	public void set_language_as(String arg1) throws Throwable {
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath("//span[contains(text(),'Set language')]"));
		Thread.sleep(2000);
		action.moveToElement(ele).click().build().perform();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li[1]")).click();

	}

	@Then("^The Databases language should be changed to selected language$")
	public void the_Databases_language_should_be_changed_to_selected_language() throws Throwable {
		Thread.sleep(3000);
		WebElement dbele;

		if (dbase.equalsIgnoreCase("World Trend Plus")) {
			dbele = login.driver.findElement(By.xpath(
					"//div[@class='child-container']//div[@data-node-model-id='WORLD']//span[@class='name-text']"));
			After_set_lang = dbele.getText();
			login.Log4j.info("After_set_lang is " + After_set_lang);
			database = true;
			// After validation changing set language as English
			Thread.sleep(2000);
			action.contextClick(dbele).build().perform();

		} else if (dbase.equalsIgnoreCase("Russia Premium Database")) {
			dbele = login.driver.findElement(By.xpath(
					"//div[@class='child-container']//div[@data-node-model-id='RUSSIA']//span[@class='name-text']"));
			After_set_lang = dbele.getText();
			login.Log4j.info("After_set_lang is " + After_set_lang);
			database = true;
			// After validation changing set language as English
			action.contextClick(dbele).build().perform();

		} else if (dbase.equalsIgnoreCase("Global Database")) {
			dbele = login.driver.findElement(By.xpath("//li[1]//div[@class='series-item--name']"));
			After_set_lang = dbele.getText();
			login.Log4j.info("After_set_lang is " + After_set_lang);
			database = true;
			// After validation changing set language as English
			action.contextClick(rightClickElement).build().perform();

		} else {
			dbele = login.driver.findElement(By.xpath(
					"//div[@data-node-model-id='INDONESIA']//div[@class='child-container']//div[1]//span[@class='name-text']"));
			After_set_lang = dbele.getText();
			login.Log4j.info("After_set_lang is " + After_set_lang);
			database = true;
			// After validation changing set language as English
			Thread.sleep(2000);
			action.contextClick(rightClickElement).build().perform();

		}
		SetLangugeEnglish();
		if (database == true && !Before_set_lang.equals(After_set_lang) == true) {
			login.Log4j.info(Before_set_lang + " is changed as " + After_set_lang);
		} else {
			Assert.fail("The Databases language is not changed to selected language");
		}
		if (login.driver.findElement(By.xpath("//span[@title='Collapse tree']")).isDisplayed()) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//span[@title='Collapse tree']")).click();
		}

	}

	@And("^Mouse hover on any topic level of data$")
	public void mouse_hover_on_any_topic_level_of_data() throws Throwable {
		// mouse hover on Global key series Database topic level
		Thread.sleep(3000);
		login.driver
				.findElement(
						By.xpath("//div[@class='child-container']//div[@class='database-node tree-node'][3]/div[1]"))
				.click();
		Thread.sleep(2000);
		ele = login.driver.findElement(
				By.xpath("//div[@class='child-container']//div[@class='title']//span[contains(text(),'Albania')]"));

	}

	@Then("^\"([^\"]*)\" should be available$")
	public void should_be_available(String arg1) throws Throwable {
		str = ele.getText();
		login.Log4j.info(str);
		action.moveToElement(ele).click().build().perform();
		if (arg1.equalsIgnoreCase("Copy link(s)")) {
			copy_link = login.driver.findElement(By.xpath(
					"//div[@class='database-node tree-node open']//div[3]//div[@class='tree-node active']//span[@class='actions']//i[1]//i"));
			copy_link.click();
			login.Log4j.info("Clicking on " + arg1);

		} else if (arg1.equalsIgnoreCase("Footnotes")) {
			footnote = login.driver.findElement(By.xpath(
					"//div[@class='database-node tree-node open']//div[3]//div[@class='tree-node active']//span[@class='actions']//i[2]"));
			login.Log4j.info("Clicking on " + arg1);
		}
	}

	@Then("^The selected topic should be highleted$")
	public void the_selected_topic_should_be_highleted() throws Throwable {
		Thread.sleep(10000);
		WebElement highlightd_topic = login.driver.findElement(By.xpath("//div[@class='tree-node open highlight']"));
		if (highlightd_topic.isDisplayed()) {
			login.Log4j.info("The selected topic is highlighted for mouse hover action Copy link(s)");
		} else {
			AssertJUnit.fail("The selected topic is not highlighted for mouse hover action Copy link(s)");
		}
		login.driver.close();
		login.driver.switchTo().window(tabs2.get(0));
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[@title='Collapse tree']")).click();
	}

	@When("^click on it$")
	public void click_on_it() throws Throwable {
		if (footnote.isDisplayed()) {
			Thread.sleep(1000);
			footnote.click();
		}
	}

	@Then("^Footnotes should be open for related topic$")
	public void footnotes_should_be_open_for_related_topic() throws Throwable {
		Thread.sleep(2000);
		ele = login.driver.findElement(By.className("footnotes-modal--name"));
		String footenote_text = ele.getText();
		login.Log4j.info(footenote_text);
		if (footenote_text.contains(str)) {
			login.Log4j.info("Footnotes opened for related topic");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@title='Close']"));
		} else {
			login.driver.findElement(By.xpath("//div[@title='Close']"));
			Assert.fail("Footnotes not opened for related topic");
		}
	}

	public static void AlldbClear() throws InterruptedException {
		List<WebElement> clearIcon = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Alldb_clearIcon")));
		if (clearIcon.size() > 0) {
			if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Alldb_clearIcon"))).isDisplayed()) {
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Alldb_clearIcon"))).click();
			}
		}
	}

	@And("^Right click on any topic level of data$")
	public void right_click_on_any_topic_level_of_data() throws Throwable {
		mouse_hover_on_any_topic_level_of_data();
		Thread.sleep(5000);
		action.contextClick(ele).build().perform();
	}

	@And("^\"([^\"]*)\" option should be available$")
	public void option_should_be_available(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Copy link(s)")) {
			copy_link = login.driver.findElement(By.xpath("//div[@class='items-wrapper']//li[1]"));
			Thread.sleep(1000);
			copy_link.click();
			login.Log4j.info("Clicking on " + arg1);
		} else if (arg1.equalsIgnoreCase("Footnotes")) {
			footnote = login.driver.findElement(By.xpath("//div[@class='items-wrapper']//li[2]"));
			Thread.sleep(1000);
			footnote.click();
			login.Log4j.info("Clicking on " + arg1);
		}

	}

	public static void AfterMethod() throws InterruptedException {
		Thread.sleep(2000);
		WebElement SeriesCount = login.driver.findElement(By.cssSelector(".series-series-count"));
		String after_apply_filter = SeriesCount.getText();
		String[] count = after_apply_filter.split(" ");
		String newStr = count[0].replaceAll(",", "");
		afterFilter = Integer.parseInt(newStr);
	}

	public static void BeforeMethod() throws InterruptedException {
		Thread.sleep(2000);
		WebElement SeriesCount = login.driver.findElement(By.cssSelector(".series-series-count"));
		String before_apply_filter = SeriesCount.getText();
		String[] count1 = before_apply_filter.split(" ");
		String newStr = count1[0].replaceAll(",", "");
		beforeFilter = Integer.parseInt(newStr);
	}

	public void SetLangugeEnglish() throws InterruptedException {
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath("//span[contains(text(),'Set language')]"));
		Thread.sleep(2000);
		action.moveToElement(ele).click().build().perform();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li[2]")).click();
	}
}
