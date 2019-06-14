package CDMNext.StepDefinations;

import static org.testng.AssertJUnit.assertTrue;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Assert;

import org.testng.AssertJUnit;
import org.testng.asserts.SoftAssert;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DatabasesTab {
	// List<String> insights_title = new ArrayList<>();
	public String Db;
	Boolean database = false;
	public WebElement footnote;
	public String dbstr;
	public String beforeDb;
	ArrayList<String> tabs2;
	public WebElement footnoteDb;
	public String str;
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
	public String Before_set_lang;
	public String After_set_lang;
	public String dbase;
	public WebElement copy_link;
	public WebElement ele;
	public WebElement AddIcon;
	public WebElement checkbox;
	String sname;
	String BeforeReplace;
	String Clipboard_data;
	WebDriverWait wait;
	String MouseHoverAction;
	String beforeReplace_sname1;
	String beforeReplace_sname2;
	String afterReplace_sname1;
	String afterReplace_sname2;
	int SeriesCount;
	int insightVar;
	int beforeUnselct;
	int m;
	Dimension BeforeMinimize_dimension;
	String tableName;
	String result = "fail";
	// String insight_name;
	Robot robot;
	static Actions action = new Actions(login.driver);
	// create instance of JavaScriptExecutor
	JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	SoftAssert s_assert = new SoftAssert();
	List<String> listOne = new ArrayList<String>();
	List<String> listTwo = new ArrayList<String>();

	@Given("^Click on All Databases dropdown$")
	public void click_on_All_Databases_dropdown() throws Throwable {
		// SearchTest.ClearSelection();
		AlldbClear();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).clear();
		Thread.sleep(2000);
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
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Databases_Tab"))).click();
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
				AssertJUnit.fail("Results is not shown correctly for selected " + DataBase[0]);
			}
		}
	}

	@And("^Select database as Daily Database$")
	public void select_database_as_Daily_Database() throws Throwable {

		Thread.sleep(5000);
		TopMethod();
		AlldbClear();
		CollapseTreeMethod();
		Thread.sleep(10000);
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
			ele = login.driver.findElement(By.xpath(
					"//div[@class='tree-node open']//div[@class='child-container']//div[1][@class='tree-node']//span[@class='name-text']"));
			tableName = ele.getText();
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
		CollapseTreeMethod();
		Thread.sleep(15000);
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
			Assert.fail("Open data tree is not collapse");
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
		login.driver.navigate().refresh();
		Thread.sleep(7000);
		WebElement db;
		login.driver
				.findElement(By
						.xpath("//div[@class='search-presentation-tabs--visible']//span[contains(text(),'Databases')]"))
				.click();
		db = login.driver.findElement(By.xpath("//div[@class='child-container']//div[1]//div[2]"));
		ele = login.driver.findElement(
				By.xpath("//div[@class='child-container']//div[1]//div[@class='title']//span[@class='name']//span[1]"));
		action.moveToElement(ele).build().perform();
	}

	@Then("^Footnotes icon should be displayed$")
	public void footnotes_icon_should_be_displayed() throws Throwable {
		Thread.sleep(2000);
		footnote = login.driver
				.findElement(By.xpath("//div[@class='child-container']//div[1]//span[@title='Open footnote']"));
		if (footnote.isDisplayed()) {
			login.Log4j.info("footnote icon is enabled when mouse hover on the databse");
		} else {
			Assert.fail("footnote icon is not enabled when mouse hover on the databse");
		}
	}

	@When("^Click on footnote's icon$")
	public void click_on_footnote_s_icon() throws Throwable {
		Thread.sleep(2000);
		footnote.click();
		login.Log4j.info("Clicking on footnote icon");
	}

	@Then("^Footnotes should be opened for related \"([^\"]*)\"$")
	public void footnotes_should_be_opened_for_related(String arg1) throws Throwable {
		footnoteDb = login.driver.findElement(By.className("footnotes-modal--name"));
		Thread.sleep(2000);
		str = footnoteDb.getText();
		login.Log4j.info(str);
		Validationstr = ele.getText();
		login.Log4j.info(Validationstr);
		if (str.contains(Validationstr) == true) {
			login.Log4j.info("Footnotes is displayed on " + arg1 + " level");
			Thread.sleep(1500);
			login.driver.findElement(By.className("movable-modal--close")).click();
		} else {
			Thread.sleep(1000);
			login.driver.findElement(By.className("movable-modal--close")).click();
			Assert.fail("Footnotes is not displayed on " + arg1 + " level");
		}
		// CollapseTreeMethod();
	}

	@Given("^Right click on any Database$")
	public void right_click_on_any_Database() throws Throwable {
		// Right clicking on Global Database
		Thread.sleep(3000);
		ele = login.driver
				.findElement(By.xpath("//div[@class='child-container']//div[2]//div[2]//span[@class='name-text']"));
		rightClickElement = login.driver.findElement(By.xpath("//div[@class='child-container']//div[2]//div[2]"));
		// contextClick() method to do right click on the element
		action.contextClick(rightClickElement).build().perform();
	}

	@When("^Paste it in new tab$")
	public void paste_it_in_new_tab() throws Throwable {
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

	@Then("^The selected \"([^\"]*)\" should be highlighted$")
	public void the_selected_should_be_highlighted(String arg1) throws Throwable {
		Thread.sleep(25000);
		WebElement highlightdtext = null;
		try {
			if (arg1.equalsIgnoreCase("DB")) {
				highlightdtext = login.driver
						.findElement(By.xpath("//div[@class='database-node tree-node open highlight']"));

			} else if (arg1.equals("topic") == true || arg1.equals("section") == true || arg1.equals("table") == true) {
				highlightdtext = login.driver.findElement(By.xpath("//div[@class='tree-node open highlight']"));
			}
			if (highlightdtext.isDisplayed()) {
				login.Log4j.info(
						"The selected " + arg1 + " is highlighted for right click action/mouse hover Copy link(s)");
			} else {
				AssertJUnit.fail(
						"The selected " + arg1 + " is not highlighted for right click action/mouse hover Copy link(s)");
			}
			login.driver.close();
			login.driver.switchTo().window(tabs2.get(0));
			Thread.sleep(2000);
			CollapseTreeMethod();

		} catch (Exception e) {
			login.driver.close();
			login.driver.switchTo().window(tabs2.get(0));
			Thread.sleep(2000);
			TopMethod();
			Thread.sleep(2000);
			CollapseTreeMethod();
			AssertJUnit.fail(e.getMessage());
		}
	}

	@And("^Click on x icon to remove DB$")
	public void click_on_x_icon_to_remove_DB() throws Throwable {
		cross_icon = login.driver
				.findElement(By.xpath("//div[@class='icon--red-cross database-selector--clear-icon']"));
		Thread.sleep(3000);
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
		if (multidb.size() > 0) {
			try {
				if (multidb.size() == 3) {

					for (int i = 0; i < multidb.size(); i++) {
						login.Log4j.info(DataBase[0]);
						login.Log4j.info(DataBase[1]);
						login.Log4j.info(DataBase[2]);
						login.Log4j.info(i);
						Thread.sleep(3000);
						if (DataBase[i].equalsIgnoreCase("China Premium Database")) {
							dbarr = DataBase[i].split(" ");
							login.driver
									.findElement(By.xpath(
											"//div[@class='child-container']//div[@data-node-model-id='CN']//div[1]"))
									.click();
							Thread.sleep(2000);
							login.driver.findElement(By.xpath("//div[@class='child-container']//div[3]/div[1]//div[1]"))
									.click();
							Thread.sleep(2000);
							login.driver.findElement(By.xpath(
									"//div[@class='child-container']//div[3]//div[@class='child-container']//div[1]//div[3]//div[1]//div[@class='toggle']"))
									.click();
							Thread.sleep(2000);
							login.driver.findElement(By.xpath(
									"//div[@class='child-container']//div[3]//div[@class='child-container']//div[1]//div[3]//div[1]//div[3]//div[1]//div[@class='toggle']"))
									.click();

						} else if (DataBase[i].equalsIgnoreCase("Brazil Premium Database")) {
							dbarr = DataBase[i].split(" ");
							login.driver.findElement(By.xpath(
									"//div[@class='child-container']//div[@data-node-model-id='BRAZIL']//div[1]"))
									.click();
							Thread.sleep(2000);
							login.driver
									.findElement(By.xpath("//div[@class='child-container']//div[1]//div[1]//div[1]"))
									.click();
							Thread.sleep(2000);
							login.driver.findElement(By.xpath(
									"//div[@class='child-container']//div[1]//div[@class='child-container']//div[1]//div[3]//div[2]//div[@class='toggle']"))
									.click();
							Thread.sleep(2000);
							login.driver.findElement(By.xpath(
									"//div[@class='child-container']//div[1]//div[@class='child-container']//div[1]//div[3]//div[2]//div[3]//div[1]//div[@class='toggle']"))
									.click();

						} else if (DataBase[i].equalsIgnoreCase("Russia Premium Database")) {
							dbarr = DataBase[i].split(" ");
							login.driver.findElement(By.xpath(
									"//div[@class='child-container']//div[@data-node-model-id='RUSSIA']//div[1]"))
									.click();
							Thread.sleep(2000);
							login.driver.findElement(By.xpath(
									"//div[@class='child-container']//div[2]/div[@class='child-container']//div[1]//div[1]"))
									.click();
							Thread.sleep(2000);
							login.driver.findElement(By.xpath(
									"//div[@class='child-container']//div[2]/div[@class='child-container']//div[1]//div[3]//div[1]//div[@class='toggle']"))
									.click();
							Thread.sleep(2000);
							login.driver.findElement(By.xpath(
									"//div[@class='child-container']//div[2]//div[@class='child-container']//div[1]//div[3]//div[1]//div[3]//div[4]//div[@class='toggle']"))
									.click();
						}
						DatabaseValidation();
						if (database == true) {
							login.Log4j.info("Results is shown correctly for selected " + DataBase[i]);
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
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).clear();
		if (login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).isDisplayed()) {
			Thread.sleep(5000);
			login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();
			login.Log4j.info("Clicking on " + arg1);
		} else {
			AssertJUnit.fail(arg1 + " is not displayed");
		}
	}

	@When("^Click on Close$")
	public void click_on_Close() throws Throwable {
		Thread.sleep(2000);
		WebElement close_icon = login.driver.findElement(By.xpath("//div[@ui='$close']"));
		if (close_icon.isDisplayed()) {
			Thread.sleep(2000);
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
		WebElement element = null;
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
		WebElement ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
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

			} catch (NoSuchElementException e) {
				login.Log4j.error("Series name is null");
				int k = j + 1;
				element = login.driver.findElement(By.xpath("//li[" + k + "]//div[@class='series-item--name']"));
				element.click();

			} finally {
				// Until the element is not visible keep scrolling
				jse.executeScript("arguments[0].scrollIntoView(true);", element);
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
					Thread.sleep(1000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
					Assert.fail("Results has not shown correctly for applied region filter is " + countryVar);

				}
			}
		}
		TopMethod();
		CollapseTreeMethod();
		ResetMethod();
	}

	@When("^Click on x icon$")
	public void click_on_x_icon() throws Throwable {
		AfterMethod();
		login.Log4j.info("After applied filter series count is " + afterFilter);
		Thread.sleep(1500);
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
			AssertJUnit.fail("The applied filter has not been removed");
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
			AssertJUnit.fail(arg1 + " popup is not displayed");
		}
	}

	@Then("^User should redirect to \"([^\"]*)\"$")
	public void user_should_redirect_to(String arg1) throws Throwable {
		Thread.sleep(4000);
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
			Thread.sleep(2000);
			login.driver.close();
			login.driver.switchTo().window(tabs2.get(0));
		} else {
			Thread.sleep(2000);
			login.driver.close();
			login.driver.switchTo().window(tabs2.get(0));
			AssertJUnit.fail("User is unable to redirect to " + arg1);
		}

//		login.driver.close();
//		login.driver.switchTo().window(tabs2.get(0));
		login.driver.navigate().refresh();
		Thread.sleep(5000);
		WebElement ClearSearchInput = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("Clear_Search_Input")));
		action.moveToElement(ClearSearchInput).click().build().perform();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_right"))).click();
	}

	public void DatabaseValidation() throws InterruptedException {
		WebElement element = null;
		Thread.sleep(3000);
		WebElement ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
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

			} catch (NoSuchElementException e) {
				login.Log4j.error("Series name is null");
				int k = j + 1;
				element = login.driver.findElement(By.xpath("//li[" + k + "]//div[@class='series-item--name']"));
				element.click();

			} finally {
				// Until the element is not visible keep scrolling
				jse.executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(2000);
				// WebElement region = null;

				WebElement region = login.driver.findElement(By.xpath(
						"//div[@class='main-series-information--field']//div[@class='main-series-information--field-value']//div[1]//div[1]"));
				String rgnstr = region.getText();
				login.Log4j.info(dbarr[0]);
				login.Log4j.info(rgnstr);
				if (rgnstr.contains(dbarr[0]) == true) {
					database = true;
					Thread.sleep(1000);
					login.driver.findElement(By.xpath("//div[@class='movable-modal--close']")).click();
				} else {
					database = false;
					Thread.sleep(1000);
					login.driver.findElement(By.xpath("//div[@class='movable-modal--close']")).click();
				}

			}

		}

		TopMethod();
		CollapseTreeMethod();
	}

	@Then("^The data tree should be expanded$")
	public void the_data_tree_should_be_expanded() throws Throwable {
		Thread.sleep(2000);
		if (login.driver.findElement(By.xpath("//span[contains(text(),'Collapse')]")).isDisplayed()) {
			login.Log4j.info("The data tree is expanded");
		} else {
			AssertJUnit.fail("The data tree is not expanded");
		}
	}

	@Then("^The data tree should be collapsed$")
	public void the_data_tree_should_be_collapsed() throws Throwable {
		Thread.sleep(3000);
		if (login.driver.findElement(By.xpath("//span[contains(text(),'Expand')]")).isDisplayed()) {
			login.Log4j.info("The data tree is collapsed");
		} else {
			Assert.fail("The data tree is not collapsed");
		}

	}

	@Then("^\"([^\"]*)\" message should be displayed$")
	public void message_should_be_displayed(String arg1) throws Throwable {
		Thread.sleep(2000);
		if (arg1.equalsIgnoreCase("Sorry, no results were found here.")) {
			ele = login.driver.findElement(By.xpath("//p[contains(text(),'" + arg1 + "')]"));
			String noResults = ele.getText();
			if (ele.isDisplayed()) {
				login.Log4j.info(noResults + "is displayed for invalid Keyword ");
			} else {
				AssertJUnit.fail(noResults + "is not displayed for invalid Keyword ");
			}
		} else if (arg1.equalsIgnoreCase("1 URL link(s) copied.")) {
			ele = login.driver.findElement(By.xpath("//div[@class='growl-message-text']"));
			String linkCopied = ele.getText();
			login.Log4j.info(linkCopied);
			if (ele.isDisplayed()) {
				login.Log4j.info(linkCopied + " message is displayed");
			} else {
				AssertJUnit.fail(linkCopied + "is not displayed  ");
			}
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
				AssertJUnit.fail(array[0] + " AND" + array[1] + " AND" + array[2]
						+ " options not available for right click option for DB level");
			}
		} else if (array.length == 2) {
			if (rightClick_str.contains(array[0]) == true && rightClick_str.contains(array[1]) == true) {
				login.Log4j.info(array[0] + " AND " + array[1] + " options available for right click option ");

			} else {
				AssertJUnit.fail(array[0] + " AND" + array[1] + " options not available for right click option ");
			}
		}
		CollapseTreeMethod();
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
			AssertJUnit.fail("The result is not loaded without search");
		}
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_left"))).click();
	}

	@And("^Right click on \"([^\"]*)\"$")
	public void right_click_on(String arg1) throws Throwable {
		dbase = arg1;
		switch (arg1) {
		case "World Trend Plus":
			login.driver.navigate().refresh();
			Thread.sleep(5000);
			rightClickElement = login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]"));
			Before_set_lang = rightClickElement.getText();
			break;
		case "Russia Premium Database":
			login.driver.navigate().refresh();
			Thread.sleep(5000);
			rightClickElement = login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]"));
			Before_set_lang = rightClickElement.getText();
			break;
		case "Indonesia Premium Database":
			login.driver.navigate().refresh();
			Thread.sleep(5000);
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
			AssertJUnit.fail("Doesn't exist in given databse list");
		}
		login.Log4j.info("Before_set_lang is " + Before_set_lang);
		Thread.sleep(4000);
		// contextClick() method to do right click on the element
		action.contextClick(rightClickElement).build().perform();

	}

	@And("^\"([^\"]*)\" as \"([^\"]*)\"$")
	public void as(String arg1, String arg2) throws Throwable {
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]"));
		Thread.sleep(2000);
		action.moveToElement(ele).click().build().perform();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'" + arg2 + "')]")).click();

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
			AssertJUnit.fail("The Databases language is not changed to selected language");
		}
		CollapseTreeMethod();
	}

	@And("^Mouse hover on any topic level of data$")
	public void mouse_hover_on_any_topic_level_of_data() throws Throwable {
		CollapseTreeMethod();
		// mouse hover on Global key series Database topic level
		Thread.sleep(20000);
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
		MouseHoverAction = arg1;
		action.moveToElement(ele).click().build().perform();
		switch (arg1) {
		case "Copy link(s)":
			copy_link = login.driver.findElement(By.xpath(
					"//div[@class='database-node tree-node open']//div[3]//div[@class='tree-node active']//span[@class='actions']//span[1]"));
			copy_link.click();
			login.Log4j.info("Clicking on " + arg1);
			break;
		case "Footnotes":
			footnote = login.driver.findElement(By.xpath(
					"//div[@class='database-node tree-node open']//div[3]//div[@class='tree-node active']//span[@class='actions']//span[2]"));
			login.Log4j.info("Clicking on " + arg1);
			break;
		case "+":
			AddIcon = login.driver.findElement(By.xpath(
					"//div[@class='child-container']//div[@data-node-model-id='CN']//div[1]//div[1]//div[3]//div[1]//div[@class='title']//div[@class='add-to-data-selection--icon']"));
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
		login.driver.navigate().refresh();
		mouse_hover_on_any_topic_level_of_data();
		Thread.sleep(5000);
		action.contextClick(ele).build().perform();
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
		CollapseTreeMethod();
		// mouse hover on Markit Purchasing Managers' Index for section level
		Thread.sleep(15000);
		login.driver
				.findElement(
						By.xpath("//div[@class='child-container']//div[@class='database-node tree-node'][4]/div[1]"))
				.click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(
				"//div[@class='database-node tree-node open']//div[@class='child-container']//div[1]//div[@class='toggle']"))
				.click();
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath(
				"//div[@class='tree-node open']//div[@class='child-container']//div[1]//span[@class='name-text']"));
	}

	@And("^Right click on any section level of data$")
	public void right_click_on_any_section_level_of_data() throws Throwable {
		mouse_hover_on_any_Section_level_of_data();
		Thread.sleep(5000);
		action.contextClick(ele).build().perform();
	}

	/*
	 * @And("^Mouse hover on any table level of data$") public void
	 * mouse_hover_on_any_table_level_of_data() throws Throwable { // creating new
	 * insight Thread.sleep(5000);
	 * login.driver.findElement(By.xpath("//span[contains(text(),'File')]")).click()
	 * ; Thread.sleep(2000);
	 * login.driver.findElement(By.xpath("//span[contains(text(),'New')]")).click();
	 * Thread.sleep(2000); login.driver.findElement(By.
	 * xpath("//button[contains(text(),'Create insight')]")).click();
	 * Thread.sleep(2000); login.driver .findElement(By.xpath(
	 * "//div[@class='view-selection--header']//div[@class='panel-expander panel-expander__left']"
	 * )) .click(); mouse_hover_on_any_table_level();
	 * 
	 * }
	 */

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
		UnselectMethod();
		wait = new WebDriverWait(login.driver, 5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='child-container']//div[@data-node-model-id='CN']//div[1]"))).click();
		Thread.sleep(2000);
		login.driver
				.findElement(By.xpath("//div[@class='child-container']//div[@data-node-model-id='CN']//div[1]//div[1]"))
				.click();
		Thread.sleep(2000);
		login.driver
				.findElement(By.xpath(
						"//div[@class='child-container']//div[@data-node-model-id='CN']//div[1]//div[1]//div[1]"))
				.click();
		Thread.sleep(2000);
		List<WebElement> tableLevel = login.driver.findElements(By.xpath(
				"//div[@class='child-container']//div[@data-node-model-id='CN']//div[1]//div[1]//div[3]//div//div[@class='title']"));
		login.Log4j.info("Total number of tables " + tableLevel.size());
		for (int i = 0; i < tableLevel.size(); i++) {
			login.Log4j.info(i);
			int j = i + 1;
			Thread.sleep(5000);
			checkbox = login.driver.findElement(By.xpath(
					"//div[@class='child-container']//div[@data-node-model-id='CN']//div[1]//div[1]//div[3]//div[" + j
							+ "]//div[@class='title']//span[@class='svg-checkbox']"));
			Thread.sleep(2000);
			checkbox.click();
			if (i == 2) {
				ele = login.driver.findElement(By.xpath(
						"//div[@class='child-container']//div[@data-node-model-id='CN']//div[1]//div[1]//div[3]//div["
								+ j + "]//div[@class='title']"));
				action.moveToElement(ele).build().perform();
				break;
			}
		}
	}

	@Then("^The links should be generated for selected tables$")
	public void the_links_should_be_generated_for_selected_tables() throws Throwable {
		ele = login.driver.findElement(By.xpath("//div[@class='growl-message-text']"));
		String linkCopied = ele.getText();
		login.Log4j.info(linkCopied);
		AssertJUnit.assertEquals(true, ele.isDisplayed());
		CollapseTreeMethod();
	}

	@Then("^Multiple table's link should be copied to clipboard and open respective \"([^\"]*)\" should be highlighted when run links one by one in browser$")
	public void multiple_table_s_link_should_be_copied_to_clipboard_and_open_respective_should_be_highlighted_when_run_links_one_by_one_in_browser(
			String arg1) throws Throwable {
		// Create instance of Clipboard class
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Clipboard_data = (String) clipboard.getData(DataFlavor.stringFlavor);
		login.Log4j.info(Clipboard_data);
		String[] textArea = Clipboard_data.split("\\n");
		for (String line : textArea) {
			login.Log4j.info(line);
			// Set the String to Enter
			StringSelection stringSelection = new StringSelection(line);
			// Copy the String to Clipboard
			clipboard.setContents(stringSelection, null);
			paste_it_in_new_tab();
			the_selected_should_be_highlighted(arg1);
			UnselectMethod();
		}
	}

	@Then("^The entire table should be added to my series$")
	public void the_entire_table_should_be_added_to_my_series() throws Throwable {
		login.Log4j.info(Validationstr);
		Thread.sleep(5000);
		WebElement tableName = login.driver.findElement(By.className("group-name"));
		Thread.sleep(5000);
		String actualStr = tableName.getText();
		login.Log4j.info(actualStr);
		AssertJUnit.assertEquals(actualStr, Validationstr);
		Thread.sleep(2000);
		DeleteSeries();
		Thread.sleep(2000);
		CollapseTreeMethod();

	}

	@And("^Click on dropdown next to \\+ icon$")
	public void click_on_dropdown_next_to_icon() throws Throwable {
		login.driver.findElement(By.xpath(
				"//div[@class='child-container']//div[@data-node-model-id='CN']//div[1]//div[1]//div[3]//div[1]//div[@class='title']//span[@class='svg-checkbox']"))
				.click();

		Thread.sleep(2000);
		robot = new Robot(); // creating table
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_T);

		Thread.sleep(10000);
		login.driver.findElement(By.xpath(
				"//div[@class='child-container']//div[@data-node-model-id='CN']//div[1]//div[1]//div[3]//div[1]//div[@class='title']//div[@class='add-to-data-selection--title']//div[2]"))
				.click();
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
			DeleteVisual();
			DeleteSeries();
		} else {
			AssertJUnit.fail(dropdownStr[0] + " AND " + dropdownStr[1] + " AND " + dropdownStr[2] + " AND "
					+ dropdownStr[3] + " AND " + dropdownStr[4] + " are not available in dropdown on table level");
		}
	}

	@And("^Click on dropdown icon$")
	public void click_on_dropdown_icon() throws Throwable {
		Thread.sleep(5000);
		WebElement dropdown = login.driver.findElement(By.xpath(
				"//div[@class='child-container']//div[@data-node-model-id='CN']//div[1]//div[1]//div[3]//div[1]//div[@class='title']//div[@class='add-to-data-selection--title']//div[2]"));
		action.moveToElement(dropdown).click().build().perform();
		login.Log4j.info("Clicking on dropdown icon");
	}

	@And("^Select \"([^\"]*)\" option$")
	public void select_option(String arg1) throws Throwable {
		Thread.sleep(5000);
		login.Log4j.info("Clicking on dropdown icon");
		try {
			// clicking on dropdown for table level
			WebElement dropdown = login.driver.findElement(By.xpath(
					"//div[@class='child-container']//div[@data-node-model-id='CN']//div[1]//div[1]//div[3]//div[1]//div[@class='title']//div[@class='add-to-data-selection--title']//div[2]"));
			action.moveToElement(dropdown).click().build().perform();
		} catch (Exception e) {
			// clicking on dropdown for series level
			Thread.sleep(3000);
			ele = login.driver.findElement(By.xpath("//ul//li[1]//div[@class='add-to-data-selection--toggle']"));
			action.moveToElement(ele).click().build().perform();

		}
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
		login.driver.findElement(By.xpath(
				"//div[@class='child-container']//div[@data-node-model-id='CN']//div[1]//div[1]//div[3]//div[3]//div[@class='title']//span[@class='svg-checkbox']"))
				.click();
		robot = new Robot();
		// creating table
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_T);
		Thread.sleep(3000);
		WebElement element = login.driver
				.findElement(By.xpath("//tr[@class=' heading']//th[2]//span[@class='series-edit--title']"));
		beforeReplace_sname1 = element.getText();
		login.Log4j.info(beforeReplace_sname1);
		WebElement element1 = login.driver
				.findElement(By.xpath("//tr[@class=' heading']//th[3]//span[@class='series-edit--title']"));
		beforeReplace_sname2 = element1.getText();
		login.Log4j.info(beforeReplace_sname2);
		ele = login.driver.findElement(By.xpath(
				"//div[@class='child-container']//div[@data-node-model-id='CN']//div[1]//div[1]//div[3]//div[1]//div[@class='title']"));
		action.moveToElement(ele).build().perform();

	}

	@Then("^The selected table data should be replaced with existing data on the visual$")
	public void the_selected_table_data_should_be_replaced_with_existing_data_on_the_visual() throws Throwable {
		Thread.sleep(3000);
		WebElement element = login.driver
				.findElement(By.xpath("//tr[@class=' heading']//th[2]//span[@class='series-edit--title']"));
		afterReplace_sname1 = element.getText();
		login.Log4j.info(afterReplace_sname1);
		WebElement element1 = login.driver
				.findElement(By.xpath("//tr[@class=' heading']//th[3]//span[@class='series-edit--title']"));
		afterReplace_sname2 = element1.getText();
		login.Log4j.info(afterReplace_sname2);
		if (!beforeReplace_sname1.equals(afterReplace_sname1) == true
				&& !beforeReplace_sname2.equals(afterReplace_sname2) == true) {
			login.Log4j.info("The selected table data replaced with existing data for Add and replace");
			DeleteVisual();
			DeleteSeries();
		} else {
			AssertJUnit.fail("The selected table data replaced with existing data for Add and replace");
		}
		CollapseTreeMethod();
	}

	@Then("^Selected table should be added as group in My series$")
	public void selected_table_should_be_added_as_group_in_My_series() throws Throwable {
		the_entire_table_should_be_added_to_my_series();
	}

	@Then("^The new insight should be created with selected data$")
	public void the_new_insight_should_be_created_with_selected_data() throws Throwable {
		Thread.sleep(1000);
		WebElement growl_popup = login.driver.findElement(By.xpath("//div[@class='growl-message growl-success']"));
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
				.findElement(By.xpath("//div[@class='growl-message growl-success']//div[@class='growl-message-text']"));
		String confirm_msg = ele.getText();
		String[] confirmarr = confirm_msg.split("\n");
		login.Log4j.info(confirmarr[0]);
		AssertJUnit.assertEquals(confirmarr[0], arg1);
		login.Log4j.info(confirmarr[0] + " is displayed");

	}

	@Then("^The insight should be opened and added series should be available in My series$")
	public void the_insight_should_be_opened_and_added_series_should_be_available_in_My_series() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("confirm_popup_new_insight"))).click();
		login.robot = new Robot();
		// Store all currently open tabs in tabs
		ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
		// Navigate to New Tab
		login.driver.switchTo().window(tabs2.get(1));
		Thread.sleep(10000);
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
		WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("first_insight")));
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
		Thread.sleep(2000);
		WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("first_insight")));
		ele.click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//button[contains(text(),'Add to insights')]")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//li//a[@class='growl-message--link growl-message--link__highlighted']"))
				.click();
		// login.Log4j.info(ele.getText());
		login.robot = new Robot();
		// Store all currently open tabs in tabs
		ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
		// Navigate to New Tab
		login.driver.switchTo().window(tabs2.get(1));
		Thread.sleep(10000);
		the_entire_table_should_be_added_to_my_series();
		login.driver.close();
		login.driver.switchTo().window(tabs2.get(0));

	}

	@And("^Mouse hover on any table level$")
	public void mouse_hover_on_any_table_level() throws Throwable {
		// mouse hover on China Premium Database for table level
		CollapseTreeMethod();
		login.Log4j.info("mouse hovering on table level");
		Thread.sleep(20000);
		try {
			login.driver.findElement(By.xpath("//div[@class='child-container']//div[@data-node-model-id='CN']//div[1]"))
					.click();
			Thread.sleep(2000);
			login.driver
					.findElement(
							By.xpath("//div[@class='child-container']//div[@data-node-model-id='CN']//div[1]//div[1]"))
					.click();
			Thread.sleep(2000);
			login.driver
					.findElement(By.xpath(
							"//div[@class='child-container']//div[@data-node-model-id='CN']//div[1]//div[1]//div[1]"))
					.click();
			Thread.sleep(2000);
			ele = login.driver.findElement(By.xpath(
					"//div[@class='child-container']//div[@data-node-model-id='CN']//div[1]//div[1]//div[3]//div[1]//div[@class='title']//span[@class='name-text']"));
			Thread.sleep(2000);
			Validationstr = ele.getText();
		} catch (NoSuchElementException e) {
			login.driver.findElement(By.xpath("//div[@class='child-container']//div[@data-node-model-id='CN']//div[1]"))
					.click();
		}
	}

	@And("^Select multiple insights$")
	public void select_multiple_insights() throws Throwable {
		Thread.sleep(2000);
		insightVar = 0;
		List<WebElement> insights_list = login.driver.findElements(By.className("insight-icon-item"));
		login.Log4j.info(insights_list.size());
		for (int i = 0; i < insights_list.size(); i++) {
			Thread.sleep(2000);
			int j = i + 1;
			/*
			 * ele=login.driver.findElement(By.xpath("//div[@class='insight-icon-item']["+ j
			 * +"]//div[@class='link link__medium insight-icon-item--bottom-panel-title']"))
			 * ; insight_name=ele.getAttribute("title"); login.Log4j.info(insight_name);
			 * insights_title.add(insight_name);
			 */
			login.driver.findElement(By.xpath("//div[@class='insight-icon-item'][" + j + "]")).click();
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
		ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs2.get(1));
		Thread.sleep(5000);
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
		CollapseTreeMethod();
		ResetMethod();
		try {
			if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unexpected_popup_close")))
					.isDisplayed()) {
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unexpected_popup_close"))).click();
			}
		} catch (NoSuchElementException e) {

		}
		// Right clicking on Brazil Premium Database for table level
		Thread.sleep(20000);
		login.driver.findElement(By.xpath("//div[@class='child-container']//div[@data-node-model-id='BRAZIL']//div[1]"))
				.click();
		Thread.sleep(2000);
		login.driver
				.findElement(
						By.xpath("//div[@class='child-container']//div[@data-node-model-id='BRAZIL']//div[1]//div[1]"))
				.click();
		Thread.sleep(2000);
		login.driver
				.findElement(By.xpath(
						"//div[@class='child-container']//div[@data-node-model-id='BRAZIL']//div[1]//div[1]//div[1]"))
				.click();
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath(
				"//div[@class='child-container']//div[@data-node-model-id='BRAZIL']//div[1]//div[1]//div[3]//div[1]//div[@class='title']//span[@class='name-text']"));
		tableName = ele.getText();
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
			// Thread.sleep(2000);
			// action.contextClick(ele).build().perform();
			Thread.sleep(3000);
			login.Log4j.info("Clicking on " + arg1);
			login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();
		} else if (arg1.equals("Download")) {
			// Thread.sleep(2000);
			// action.contextClick(ele).build().perform();
			Thread.sleep(3000);
			try {
				WebElement count = login.driver.findElement(By.xpath("//span[@class='search-input--selected-count']"));
				SeriesCount = Integer.parseInt(count.getText());
				login.Log4j.info(SeriesCount);
			} catch (NumberFormatException e) {
				login.Log4j.info(e.getMessage());
			}
			login.Log4j.info("Clicking on " + arg1);
			login.driver.findElement(By.xpath("//span[@title='" + arg1 + "']")).click();
		} else if (arg1.equals("Copy link(s)") || arg1.equals("Footnotes") || arg1.equals("Show Dataset")
				|| arg1.equals("Copy") || arg1.equals("Copy data") || arg1.equals("Series Info")
				|| arg1.equals("Show Database")) {
			// Thread.sleep(2000);
			// action.contextClick(ele).build().perform();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath("//div[@class='items-wrapper']//span[@title='" + arg1 + "']")).click();
			login.Log4j.info("Clicking on " + arg1);
		}
	}

	@Then("^The selected data should be unselected$")
	public void the_selected_data_should_be_unselected() throws Throwable {
		Thread.sleep(2000);
		WebElement count = null;
		count = login.driver.findElement(By.xpath("//span[@class='search-input--selected-count']"));
		if (!count.isDisplayed()) {
			login.Log4j.info("The selected data is unselected");
		} else {
			AssertJUnit.fail("The selected data is not unselected");
		}
	}

	@Then("^\"([^\"]*)\" should be created with series in views panel$")
	public void should_be_created_with_series_in_views_panel(String arg1) throws Throwable {
		Thread.sleep(5000);
		if (arg1.equalsIgnoreCase("Table")) {
			ele = login.driver.findElement(By.xpath(
					"//div[@class='visual-title visual-select-area visual-title--wrapper']//span[contains(text(),'"
							+ arg1 + "')]"));
		} else if (arg1.equalsIgnoreCase("Histogram")) {
			ele = login.driver.findElement(By.xpath("//div[@class='text-dots']"));

		} else {
			ele = login.driver.findElement(
					By.xpath("//div[@class='visual-title--wrapper']//div[contains(text(),'" + arg1 + "')]"));
		}

		String VisualTitle = ele.getText();
		login.Log4j.info(VisualTitle);
		Thread.sleep(2000);
		if (arg1.equalsIgnoreCase(VisualTitle)) {
			login.Log4j.info(arg1 + " visual is created");
			Thread.sleep(5000);
			DeleteVisual();
			DeleteSeries();
		} else if (!arg1.equalsIgnoreCase(VisualTitle)) {
			login.Log4j.info(tableName);
			if (tableName.contains(VisualTitle)) {
				login.Log4j.info(arg1 + " visual is created");
				Thread.sleep(3000);
				DeleteVisual();
				DeleteSeries();
			}

		} else {
			AssertJUnit.fail(arg1 + " visual is not created");
		}
		// UnselectMethod();
	}

	@And("^Right click on any table level and select more than max series$")
	public void right_click_on_any_table_level_and_select_more_than_max_series() throws Throwable {
		CollapseTreeMethod();
		// Right clicking on Brazil Premium Database for table level
		Thread.sleep(20000);
		login.driver.findElement(By.xpath("//div[@class='child-container']//div[@data-node-model-id='BRAZIL']//div[1]"))
				.click();
		Thread.sleep(2000);
		login.driver
				.findElement(
						By.xpath("//div[@class='child-container']//div[@data-node-model-id='BRAZIL']//div[1]//div[1]"))
				.click();
		Thread.sleep(2000);
		login.driver
				.findElement(By.xpath(
						"//div[@class='child-container']//div[@data-node-model-id='BRAZIL']//div[1]//div[1]//div[1]"))
				.click();
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath(
				"//div[@class='child-container']//div[@data-node-model-id='BRAZIL']//div[1]//div[1]//div[3]//div[2]//div[@class='title']"));
		Thread.sleep(2000);
		action.contextClick(ele).build().perform();
	}

	@Then("^\"([^\"]*)\" window should be displayed$")
	public void window_should_be_displayed(String arg1) throws Throwable {
		ele = login.driver.findElement(By.xpath("//h4[contains(text(),'Confirmation')]"));
		String Confirm_popup = ele.getText();
		if (arg1.equalsIgnoreCase(Confirm_popup)) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@class='sphere-modal__close'] ")).click();
			login.Log4j.info("Confirmation window is displayed");
		} else {
			AssertJUnit.fail("Confirmation window is not displayed");
		}

	}

	@Then("^Confirmation window should display with \"([^\"]*)\"$")
	public void confirmation_window_should_display_with(String arg1) throws Throwable {
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath("//div[contains(text(),'" + arg1 + "')]"));
		String Confirm_msg = ele.getText();

		if (Confirm_msg.contains(arg1)) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@class='sphere-modal__close'] ")).click();
			login.Log4j.info(Confirm_msg + " is displayed");
		} else {
			AssertJUnit.fail(Confirm_msg + " is not displayed");
		}
	}

	@Then("^\"([^\"]*)\" visual should be created with max series$")
	public void visual_should_be_created_with_max_series(String arg1) throws Throwable {
		Thread.sleep(5000);
		ele = login.driver.findElement(By.xpath("//div[@class='visual-title--wrapper']"));
		String VisualTitle = ele.getText();
		login.Log4j.info("Chart title is " + VisualTitle);
		Thread.sleep(2000);
		if (arg1.equalsIgnoreCase(VisualTitle)) {
			login.Log4j.info(arg1 + " visual is created");
			Thread.sleep(3000);
			DeleteVisual();
			DeleteSeries();
		} else if (ele.isDisplayed()) {
			login.Log4j.info(arg1 + " visual is created");
			Thread.sleep(3000);
			DeleteVisual();
			DeleteSeries();
		} else {
			AssertJUnit.fail(arg1 + " visual is not created");
		}
	}

	@Then("^Download window should be appeared with selected series count$")
	public void download_window_should_be_appeared_with_selected_series_count() throws Throwable {
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath("//div[@class='download-modal-title']"));
		String downloadTitle = ele.getText();
		login.Log4j.info(downloadTitle);
		String countStr = String.valueOf(SeriesCount);
		login.Log4j.info(countStr);
		if (downloadTitle.contains(countStr)) {
			// if (downloadTitle.substring(SeriesCount) != null) {
			login.Log4j.info("Download window is displayed with selected series count");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();

		} else {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			AssertJUnit.fail("Download window is not displayed with selected series count");
		}
		// TC-158,159[closing search selection window]
		Thread.sleep(3000);
		try {
			close_search_selection_window();
		} catch (Exception e) {

		}
	}

	@Then("^All the series under the table should be shown$")
	public void all_the_series_under_the_table_should_be_shown() throws Throwable {
		Thread.sleep(2000);
		if (login.driver.findElement(By.xpath("//div[@class='insight-discovery--popup-back-button']")).isDisplayed()) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@class='insight-discovery--popup-back-button']")).click();
			login.Log4j.info("Show Dataset is working for table level");
		} else {
			AssertJUnit.fail("Show Dataset is not working for table level");
		}
	}

	@And("^Expand till table level$")
	public void expand_till_table_level() throws Throwable {
		login.driver.findElement(By.xpath("//div[@class='child-container']//div[2]//div[1]//div[@class='toggle']"))
				.click();
		login.Log4j.info("Clicking on Topic level");
		Thread.sleep(2000);
		login.driver
				.findElement(By.xpath("//div[@class='child-container']//div[2]//div[1]//div[1]//div[@class='toggle']"))
				.click();
		login.Log4j.info("Clicking on Section level");
		Thread.sleep(2000);
		login.driver
				.findElement(By
						.xpath("//div[@class='child-container']//div[2]//div[1]//div[1]//div[1]//div[@class='toggle']"))
				.click();
		login.Log4j.info("Clicking on Table level");
	}

	@Then("^\"([^\"]*)\" icon should be displayed in table level$")
	public void icon_should_be_displayed_in_table_level(String arg1) throws Throwable {
		Thread.sleep(5000);
		List<WebElement> table_list = login.driver.findElements(
				By.xpath("//div[@class='child-container']//div[2]//div[1]//div[1]//div[1]//div[@class='tree-node']"));
		login.Log4j.info("List of tables : " + table_list.size());
		for (int i = 0; i < table_list.size(); i++) {
			int j = i + 1;
			ele = login.driver.findElement(
					By.xpath("//div[@class='child-container']//div[2]//div[1]//div[1]//div[1]//div[@class='tree-node']["
							+ j + "]"));
			String newStr = ele.getText();
			login.Log4j.info(newStr);
			if (newStr.contains(arg1)) {
				Thread.sleep(3000);
				login.driver.findElement(By.xpath(
						"//div[@class='child-container']//div[2]//div[1]//div[1]//div[1]//div[@class='tree-node']//div[@class='toggle']"))
						.click();
				login.Log4j.info(arg1 + " icon is displaying for table level");
				break;
			} else {
				AssertJUnit.fail(arg1 + " icon is not displaying for table level");
			}
		}
		Thread.sleep(2000);
		WebElement ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
		login.Log4j.info("List size is :" + li_All.size());
		for (int i = 0; i < li_All.size(); i++) {
			Thread.sleep(3000);
			login.Log4j.info(i);
			login.Log4j.info(li_All.size());
			int j = i + 1;
			try {
				ele = login.driver
						.findElement(By.xpath("//li[" + j + "]//span[@class='status-icon status-icon__new']"));

			} catch (NoSuchElementException e) {
				login.Log4j.error("Series name is null");
				int k = j + 1;
				ele = login.driver
						.findElement(By.xpath("//li[" + k + "]//span[@class='status-icon status-icon__new']"));

			} finally {
				// Until the element is not visible keep scrolling
				// jse.executeScript("arguments[0].scrollIntoView(true);", ele);
				String New_icon = ele.getText();
				if (New_icon.equalsIgnoreCase(arg1) == true) {
					login.Log4j.info(arg1 + " icon for series level is shown");
				} else {
					AssertJUnit.fail(arg1 + " icon for series level is not shown");

				}
			}
		}
		TopMethod();
		ResetMethod();
		CollapseTreeMethod();
	}

	@And("^Press A on keyboard$")
	public void press_A_on_keyboard() throws Throwable {
		Validationstr = ele.getText();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//a[@data-id='myseries']")).click();
		Thread.sleep(2000);
		try {
			login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@data-action='delete']")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
			login.driver
					.findElement(By.xpath(
							"//div[@class='child-container']//div[@class='tree-node'][1]//span[@class='svg-checkbox']"))
					.click();
		} catch (Exception e) {

		}
		Thread.sleep(2000);
		robot = new Robot();
		// Adding table to Myseries
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
	}

	@And("^Drag and drop to my series/visual$")
	public void drag_and_drop_to_my_series_visual() throws Throwable {
		Thread.sleep(3000);
		Validationstr = ele.getText();
		WebElement Myseries = login.driver
				.findElement(By.xpath("//div[@class='data-selection-series-overlay--content']"));
		action.dragAndDrop(ele, Myseries).build().perform();
	}

	@And("^Click on series name$")
	public void click_on_series_name() throws Throwable {
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath("//div[@class='series-item--name']"));
		ele.click();
	}

	@Then("^Series information popup should be opened$")
	public void series_information_popup_should_be_opened() throws Throwable {
		Validationstr = ele.getText();
		login.Log4j.info(Validationstr);
		Thread.sleep(3000);
		ele = login.driver.findElement(By.xpath(
				"//div[@class='series-preview--header ui-draggable-handle']//div[@class='single-series-preview--title ']"));
		String ssp_text = ele.getText();
		login.Log4j.info(ssp_text);
		if(Validationstr.equals(ssp_text)) {
		//AssertJUnit.assertEquals(ssp_text, Validationstr);
		  login.Log4j.info("Series information popup is opened");
		  Thread.sleep(3000);
		  login.driver.findElement(By.xpath("//div[@class='movable-modal--close']")).click();
		}else {
			
			Assert.fail("Series information popup is not opened");
		}
		// CollapseTreeMethod();
	}

	@And("^Click on \"([^\"]*)\" icon$")
	public void click_on_icon(String arg1) throws Throwable {
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath("//div[@class='series-item--country country-information']"));
		action.moveToElement(ele).click().build().perform();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@title='Show related data']")).click();
		String expected = "DATASETS";
		ele = login.driver.findElement(By.xpath("//div[@class='related-series-information-portlet--title']"));
		String actual = ele.getText();
		login.Log4j.info(actual);
		if (actual.equals(expected)) {
			login.Log4j.info("Related data is displayed ");
			Thread.sleep(4000);
			login.driver.findElement(By.xpath("//div[@title='Hide related data']")).click();
			result = "pass";
		} else {
			AssertJUnit.fail("Related data is not displayed ");
			result = "fail";
		}
		CollapseTreeMethod();
	}

	@Then("^Related data should be displayed under the dropdown$")
	public void related_data_should_be_displayed_under_the_dropdown() throws Throwable {
		login.Log4j.info(result);
	}

	@And("^Click on Show related data icon$")
	public void click_on_Show_related_data_icon() throws Throwable {
		Thread.sleep(3000);
		ele = login.driver.findElement(By.xpath("//li[1]//div[@class='series-item--name']"));
		str = ele.getText();
		ele = login.driver.findElement(By.xpath("//li[1]//div[@class='series-item--country country-information']"));
		action.moveToElement(ele).click().build().perform();
		Thread.sleep(2000);
		try {
			login.driver.findElement(By.xpath("//div[@title='Hide related data']")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//li[1]//div[@title='Show related data']")).click();
			login.Log4j.info("Clicking on Show related data icon");
		} catch (NoSuchElementException e) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//li[1]//div[@title='Show related data']")).click();
			login.Log4j.info("Clicking on Show related data icon");
		}
	}

	@And("^Click on datalinks under datasets$")
	public void click_on_datalinks_under_datasets() throws Throwable {
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath("//div[@class='series-data-set--table-name']"));
		ele.click();
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
		CollapseTreeMethod();
	}

	@And("^Expand World Trend Plus till series level$")
	public void expand_World_Trend_Plus_till_series_level() throws Throwable {
		CollapseTreeMethod();
		Thread.sleep(20000);
		login.driver.findElement(By.xpath("//div[@class='tree-container']//div[@data-node-model-id='WORLD']//div[1]"))
				.click();
		Thread.sleep(2000);
		login.driver
				.findElement(By.xpath(
						"//div[@class='tree-container']//div[@data-node-model-id='WORLD']//div[3]//div[1]//div[1]"))
				.click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(
				"//div[@class='database-node tree-node open']//div[@class='child-container']//div[@class='tree-node'][1]//div[1]"))
				.click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(
				"//div[@class='database-node tree-node open']//div[@class='child-container']//div[@class='tree-node open']//div[3]//div[1]//div[1]"))
				.click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(
				"//div[@class='database-node tree-node open']//div[@class='child-container']//div[@class='tree-node open']//div[3]//div[1]//div[@class='child-container']//div[@class='tree-node'][1]//div[@class='toggle']"))
				.click();
	}

	@Then("^\"([^\"]*)\" should be displayed if available for the series$")
	public void should_be_displayed_if_available_for_the_series(String arg1) throws Throwable {
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]"));
		if (ele.isDisplayed()) {
			login.Log4j.info(arg1 + " is displayed");
		} else {
			AssertJUnit.fail(arg1 + " is not displayed");
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
		try {
			if (!login.driver.findElement(By.xpath(
					"//div[@class='related-series-data--body']//div[@class='related-series-information-portlet'][2]"))
					.isDisplayed()) {

			} else {
				login.Log4j.info("Related insight is displayed");
			}
		} catch (NoSuchElementException e) {
			login.driver.findElement(By.xpath("//a[@data-id='myseries']")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//ul//div[@class='add-to-data-selection--icon']")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//span[contains(text(),'File')]")).click();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath("//span[contains(text(),'New')]")).click();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath("//button[contains(text(),'Create insight')]")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[contains(text(),'View as')]")).click();
			select_database_as_Daily_Database();
			expand_till_series_level();
			click_on_Show_related_data_icon();
		}
	}

	@Then("^Insights should be opened in preview mode$")
	public void insights_should_be_opened_in_preview_mode() throws Throwable {
		Thread.sleep(3000);
		ele = login.driver.findElement(By.xpath(
				"//div[@class='related-series-data--body']//div[@class='related-series-information-portlet'][2]"));
		jse.executeScript("arguments[0].scrollIntoView(true);", ele);
		Thread.sleep(3000);
		ele = login.driver.findElement(By.xpath("//a[@class='link insights-grid-row--title-link']"));
		String expected = ele.getText();
		login.Log4j.info(expected);
		ele.click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//div[@class='related-insights--toggle']")).click();
		Thread.sleep(3000);
		ele = login.driver.findElement(By.xpath("//div[@class='related-insight-item--title']"));
		String actual = ele.getText();
		login.Log4j.info(actual);
		// Assert.assertEquals(actual, expected);
		if (actual.equalsIgnoreCase(expected)) {
			Thread.sleep(2000);
			login.Log4j.info("Insights is opened in preview mode");
			login.driver.findElement(By.xpath("//div[@class='insight-preview--close']")).click();
		} else {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@class='insight-preview--close']")).click();
		}
		try {
			DeleteVisual();
			DeleteSeries();
		} catch (Exception e) {

		}
	}

	@And("^Click on share under insights section$")
	public void click_on_share_under_insights_section() throws Throwable {
		Thread.sleep(3000);
		ele = login.driver.findElement(By.xpath(
				"//div[@class='related-series-data--body']//div[@class='related-series-information-portlet'][2]"));
		jse.executeScript("arguments[0].scrollIntoView(true);", ele);
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//div[@class='insights-grid']//div[@class='insight-share-button--wrapper']"))
				.click();
	}

	@Then("^Share popup should be opened if have permission to share$")
	public void share_popup_should_be_opened_if_have_permission_to_share() throws Throwable {
		Thread.sleep(3000);
		if (login.driver.findElement(By.name("name")).isDisplayed()) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			login.Log4j.info("Share popup is opened");
		} else {
			AssertJUnit.fail("Share popup is not opened");
		}

	}

	@And("^Click on add to favourite under insights section$")
	public void click_on_add_to_favourite_under_insights_section() throws Throwable {
		Thread.sleep(3000);
		ele = login.driver.findElement(By.xpath(
				"//div[@class='related-series-data--body']//div[@class='related-series-information-portlet'][2]"));
		jse.executeScript("arguments[0].scrollIntoView(true);", ele);
		ele = login.driver.findElement(By.xpath("//a[@class='link insights-grid-row--title-link']"));
		str = ele.getText();
		login.Log4j.info(str);
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//div[@class='insight-item-actions insights-grid-row--actions']//div[@title='Add to favorite']")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'File')]")).click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Open')]")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@title='Insights marked by star as favourite']")).click();

	}

	@Then("^The insights should be added to favorite list$")
	public void the_insights_should_be_added_to_favorite_list() throws Throwable {
		Thread.sleep(3000);
		String actual = null;
		List<WebElement> insights_list = login.driver
				.findElements(By.xpath("//div[@class='link link__medium insight-icon-item--bottom-panel-title']"));
		login.Log4j.info(insights_list.size());
		for (int i = 0; i < insights_list.size(); i++) {
			int j = i + 1;
			Thread.sleep(5000);
			ele = login.driver.findElement(By.xpath("//div[@class='insight-icon-item'][" + j
					+ "]//div[@class='link link__medium insight-icon-item--bottom-panel-title']"));
			actual = ele.getText();
			login.Log4j.info(actual);
			if (str.equals(actual) == true) {
				Thread.sleep(3000);
				WebElement mouseHover = login.driver
						.findElement(By.xpath("//div[@class='insight-icon-item--preview']"));
				action.moveToElement(mouseHover).build().perform();
				Thread.sleep(3000);
				login.driver
						.findElement(By.xpath(
								"//div[@class='insight-favorite insight-favorite__active insight-favorite__green']"))
						.click();
//				Thread.sleep(2000);
//				login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
				login.Log4j.info("The insight is added to favorite");
				break;
			}
		}
		if (str.equalsIgnoreCase(actual) != true) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			AssertJUnit.fail("The insight is not added to favorite");
		}else {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
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
		login.driver.navigate().refresh();
		CollapseTreeMethod();
		UnselectMethod();
		// Mouse hovering on Brazil Premium Database for series level
		Thread.sleep(20000);
		login.driver.findElement(By.xpath("//div[@data-node-model-id='BRAZIL']//div[1]")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@data-node-model-id='BRAZIL']//div[1]//div[1]")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@data-node-model-id='BRAZIL']//div[1]//div[1]//div[1]")).click();
		Thread.sleep(2000);
		login.driver
				.findElement(By.xpath(
						"//div[@data-node-model-id='BRAZIL']//div[1]//div[1]//div[3]//div[1]//div[@class='toggle']"))
				.click();
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath("//li[1]//div[@class='series-item--name']"));
		sname = ele.getText();
		login.Log4j.info(sname);
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//li[1]//div[@class='series-list-item--checkbox-wrapper']")).click();
		Thread.sleep(3000);
		WebElement ele1 = login.driver.findElement(By.xpath(
				"//li[1]//span[@class='series-item-information--additional-info-field series-item-information--additional-info-field__dates']"));
		action.moveToElement(ele1).build().perform();
	}

	@Then("^Chart should be created with the series$")
	public void chart_should_be_created_with_the_series() throws Throwable {
		Thread.sleep(5000);
		ele = login.driver.findElement(By.xpath("//div[@class='text-dots']"));
		String chartTitle = ele.getText();
		login.Log4j.info(chartTitle);
		AssertJUnit.assertEquals(sname, chartTitle);
		login.Log4j.info("chart is created for series level");
		DeleteVisual();
		DeleteSeries();

	}

	@Then("^The series should be selected in search panel although visual created$")
	public void the_series_should_be_selected_in_search_panel_although_visual_created() throws Throwable {
		Thread.sleep(4000);
		if (login.driver.findElement(By.xpath("//span[@class='search-input--preview-selection']")).isDisplayed()) {
			login.Log4j.info("The selected series is displayed");
			DeleteVisual();
			DeleteSeries();
		} else {
			AssertJUnit.fail("The selected series is not displayed");
		}
	}

	@And("^Click on Footnote icon$")
	public void click_on_Footnote_icon() throws Throwable {
		Thread.sleep(3000);
		login.driver
				.findElement(
						By.xpath("//li[1]//div[@class='series-list-item-data']//div[2]//span[@title='Open footnote']"))
				.click();
	}

	@And("^Mouse hover on any series level of data$")
	public void mouse_hover_on_any_series_level_of_data() throws Throwable {
		//UnselectMethod();
		expand_World_Trend_Plus_till_series_level();
		Thread.sleep(2000);
		WebElement ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
		login.Log4j.info("List size is :" + li_All.size());
		for (int i = 0; i < li_All.size(); i++) {
			int j = i + 1;
			Thread.sleep(3000);
			ele = login.driver
					.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
			ele.click();
			if (i == 4) {
				Thread.sleep(2000);
				ele = login.driver.findElement(By.xpath("//li[" + j
						+ "]//span[@class='series-item-information--additional-info-field series-item-information--additional-info-field__dates']"));
				action.moveToElement(ele).build().perform();
				break;
			}
		}
	}

	@Then("^The selected series should be unselected$")
	public void the_selected_series_should_be_unselected() throws Throwable {
		Thread.sleep(3000);
		if (!login.driver.findElement(By.xpath("//div[contains(text(),'Unselect')]")).isDisplayed()) {
			login.Log4j.info("The selecetd series are unselected");
		} else {
			AssertJUnit.fail("The selected series are not unselected");
		}
	}

	@Then("^Visual should be created with \"([^\"]*)\"$")
	public void visual_should_be_created_with(String arg1) throws Throwable {
		Thread.sleep(3000);
		try {
			if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unexpected_popup_close")))
					.isDisplayed()) {
				Thread.sleep(1500);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unexpected_popup_close"))).click();
			}
		} catch (NoSuchElementException e) {

		}
		Thread.sleep(2000);
		if (login.driver.findElement(By.xpath("//button[contains(text(),'" + arg1 + "')]")).isDisplayed()) {
			login.Log4j.info("Visual is created for " + visual);
			DeleteVisual();
			DeleteSeries();
		} else {
			AssertJUnit.fail("Visual is not created for " + visual);
		}
	}

	@And("^Mouse hover on any series level and select more than max series$")
	public void mouse_hover_on_any_series_level_and_select_more_than_max_series() throws Throwable {
		WebElement element = null;
		UnselectMethod();
		//expand_World_Trend_Plus_till_series_level();
		login.driver.findElement(By.xpath(
				"//div[@data-node-model-id='RUSSIA']//div[1]"))
				.click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(
				"//div[@data-node-model-id='RUSSIA']//div[1]//div[@class='toggle']"))
				.click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(
				"//div[@data-node-model-id='RUSSIA']//div[1]//div[@class='child-container']//div[1]//div[@class='toggle']"))
				.click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(
				"//div[@data-node-model-id='RUSSIA']//div[1]//div[@class='child-container']//div[1]//div[3]//div[2]//div[@class='toggle']"))
				.click();
		Thread.sleep(2000);
		WebElement ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
		login.Log4j.info("List size is :" + li_All.size());
		for (int i = 0; i < li_All.size(); i++) {
			int j = i + 1;
			int k = 0;
			try {
				Thread.sleep(3000);
				ele = login.driver
						.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
				ele.click();
				element = login.driver.findElement(By.xpath("//li[" + j
						+ "]//span[@class='series-item-information--additional-info-field series-item-information--additional-info-field__dates']"));
				jse.executeScript("arguments[0].scrollIntoView(true);", element);
				if (i == 22) {
					Thread.sleep(2000);
					action.moveToElement(element).build().perform();
					Thread.sleep(2000);
					login.driver.findElement(By.xpath("//li[" + j + "]//span[@title='More actions']")).click();
					break;
				}
			} catch (NoSuchElementException e) {
				login.Log4j.error("Series name is null");
				k = j + 1;
				ele = login.driver
						.findElement(By.xpath("//li[" + k + "]//div[@class='series-list-item--checkbox-wrapper']"));
				ele.click();
				element = login.driver.findElement(By.xpath("//li[" + k
						+ "]//span[@class='series-item-information--additional-info-field series-item-information--additional-info-field__dates']"));
				// Until the element is not visible keep scrolling
				jse.executeScript("arguments[0].scrollIntoView(true);", element);
				// Thread.sleep(2000);
				// action.moveToElement(element).build().perform();
				// Thread.sleep(2000);
				// login.driver.findElement(By.xpath("//li[" + k + "]//span[@title='More
				// actions']")).click();

				if (i == 22) {
					Thread.sleep(2000);
					action.moveToElement(element).build().perform();
					Thread.sleep(2000);
					login.driver.findElement(By.xpath("//li[" + k + "]//span[@title='More actions']")).click();
					break;
				}
			}
		}
	}

	@Then("^Confirmation window should be displayed and proceed with max series if click on \"([^\"]*)\" button$")
	public void confirmation_window_should_be_displayed_and_proceed_with_max_series_if_click_on_button(String arg1)
			throws Throwable {
		Thread.sleep(2000);
		login.Log4j.info("Clicking on " + arg1 + " icon ");
		login.driver.findElement(By.xpath("//button[contains(text(),'" + arg1 + "')]")).click();
		try {
			Thread.sleep(5000);
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
		login.driver.findElement(By.xpath("//li[1]//span[@title='More actions']")).click();
		login.Log4j.info("Clicking on More actions");
	}

	@And("^Paste in application$")
	public void paste_in_application() throws Throwable {
		/*
		 * try { Thread.sleep(2000); login.driver.findElement(By.xpath(
		 * "//a[@class='insight-page-view-tab--link']//div[@class='insight-page-view-tab--link-ghost']"
		 * )) .click(); Thread.sleep(3000); ele =
		 * login.driver.findElement(By.xpath("//span[@class='input-control--indicator']"
		 * )); action.moveToElement(ele).click().build().perform(); Thread.sleep(2000);
		 * login.driver.findElement(By.xpath("//div[@data-action='delete']")).click();
		 * Thread.sleep(2000);
		 * login.driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click()
		 * ; Thread.sleep(5000);
		 * login.driver.findElement(By.xpath("//div[@data-action='paste']")).click(); }
		 * catch (Exception e) { Thread.sleep(5000);
		 * login.driver.findElement(By.xpath("//div[@data-action='paste']")).click(); }
		 */
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@data-action='paste']")).click();
	}

	@Then("^Copied series should be pasted$")
	public void copied_series_should_be_pasted() throws Throwable {
		Thread.sleep(3000);
		ele = login.driver.findElement(By.xpath("//span[@class='series-name-field--series-name']"));
		String actual = ele.getText();
		AssertJUnit.assertEquals(actual, sname);
		login.Log4j.info("Copied series are pasted");
		DeleteSeries();
	}

	@Then("^The message should be in growl popup as \"([^\"]*)\"$")
	public void the_message_should_be_in_growl_popup_as(String arg1) throws Throwable {
		Thread.sleep(1000);
		if (login.driver
				.findElement(By.xpath("//div[@class='growl-message-text'][contains(text(),'Selected series copied.')]"))
				.isEnabled()) {
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
			login.Log4j.info("URL is generated");
		} else {
			AssertJUnit.fail("URL is not generated");
		}
	}

	@Then("^The Series information popup should be opened in untitled insight for selected series$")
	public void the_Series_information_popup_should_be_opened_in_untitled_insight_for_selected_series()
			throws Throwable {
		Thread.sleep(10000);
		ele = login.driver.findElement(By.xpath("//div[@class='single-series-preview--title ']"));
		String actual = ele.getText();
		login.Log4j.info(actual);
		AssertJUnit.assertEquals(actual, sname);
		login.Log4j.info("SSP window is opened");
		Thread.sleep(2000);
		login.driver.close();
		login.driver.switchTo().window(tabs2.get(0));

	}

	@And("^Paste in clipboard and take url one by one$")
	public void paste_in_clipboard_and_take_url_one_by_one() throws Throwable {
		// Create instance of Clipboard class
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Clipboard_data = (String) clipboard.getData(DataFlavor.stringFlavor);
		login.Log4j.info(Clipboard_data);
		String[] textArea = Clipboard_data.split("\\n");
		for (String line : textArea) {
			login.Log4j.info(line);
			// Set the String to Enter
			StringSelection stringSelection = new StringSelection(line);
			// Copy the String to Clipboard
			clipboard.setContents(stringSelection, null);
			paste_it_in_new_tab();
			the_Series_information_popup_should_be_opened();
		}
	}

	@Then("^The Series information popup should be opened$")
	public void the_Series_information_popup_should_be_opened() throws Throwable {
		try {
			Thread.sleep(10000);
			ele = login.driver.findElement(By.xpath("//div[@class='single-series-preview--title ']"));
			String stitle = ele.getText();
			login.Log4j.info(stitle);
			if (ele.isDisplayed()) {
				login.Log4j.info("SSP window is opened");
			} else {
				AssertJUnit.fail("SSP window is not opened");
			}
		} catch (Exception e) {

		}
		Thread.sleep(2000);
		login.driver.close();
		login.driver.switchTo().window(tabs2.get(0));
	}

	@Then("^The SSP window should be opened$")
	public void the_SSP_window_should_be_opened() throws Throwable {
		Thread.sleep(3000);
		ele = login.driver.findElement(By.xpath("//div[@class='single-series-preview--title ']"));
		String stitle = ele.getText();
		login.Log4j.info(stitle);
		if (ele.isDisplayed()) {
			Thread.sleep(3000);
			login.driver.findElement(By.xpath("//div[@class='movable-modal--close']")).click();
			login.Log4j.info("SSP window is opened");
		}else {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@class='movable-modal--close']")).click();
			Assert.fail("SSP window is not opened");
		}
	}

	@And("^Click on Back button$")
	public void click_on_Back_button() throws Throwable {
		Thread.sleep(2000);
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Bck_btn"))).isDisplayed()) {
			login.Log4j.info("Clicking on Back button");
			Thread.sleep(2000);
			login.driver.findElement(By.className("insight-discovery--popup-back-button")).click();
		}
	}

	@Then("^Should redirect to database tab$")
	public void should_redirect_to_database_tab() throws Throwable {
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
			DeleteSeries();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//li[1]//div[@class='add-to-data-selection--icon']")).click();
		} catch (Exception e) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//li[1]//div[@class='add-to-data-selection--icon']")).click();
		}
	}

	@Then("^The series should be added to my series$")
	public void the_series_should_be_added_to_my_series() throws Throwable {
		Thread.sleep(3000);
		ele = login.driver.findElement(By.xpath("//span[@class='series-name-field--series-name']"));
		String actual = ele.getText();
		login.Log4j.info(sname);
		login.Log4j.info(actual);
		AssertJUnit.assertEquals(actual, sname);
		login.Log4j.info("series added to my series");
		DeleteSeries();
	}

	@And("^Click on View tab on right side$")
	public void click_on_View_tab_on_right_side() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='insight-page-menu-views-container--add-ghost']")).click();
	}

	@And("^Click on \\+ icon$")
	public void click_on_icon() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//li[1]//div[@class='add-to-data-selection--icon']")).click();
	}

	@Then("^Chart should be created with selected seires$")
	public void chart_should_be_created_with_selected_seires() throws Throwable {
		Thread.sleep(3000);
		ele = login.driver.findElement(By.xpath("//div[@class='visual-title--wrapper']"));
		String actual = ele.getText();
		AssertJUnit.assertEquals(actual, sname);
		login.Log4j.info("Chart is created");
		DeleteVisual();
		DeleteSeries();
		/*
		 * Thread.sleep(3000); ele = login.driver.findElement(By.xpath(
		 * "//div[@class='insight-page-menu-views-container--view-tabs ui-sortable']//a[@class='insight-page-view-tab--link insight-page-view-tab--link__active']"
		 * )); action.contextClick(ele).build().perform(); Thread.sleep(3000);
		 * login.driver.findElement(By.xpath("//span[contains(text(),'Delete view')]")).
		 * click(); Thread.sleep(3000);
		 * login.driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click()
		 * ;
		 */
	}

	/*
	 * @And("^Click on dropdown icon for series level$") public void
	 * click_on_dropdown_icon_for_series_level() throws Throwable {
	 * Thread.sleep(3000); ele = login.driver.findElement(By.xpath(
	 * "//ul//li[1]//div[@class='add-to-data-selection--title']"));
	 * action.moveToElement(ele).click().build().perform(); }
	 */

	@And("^Create a visual and select visual$")
	public void create_a_visual_and_select_visual() throws Throwable {
		Thread.sleep(3000);
		login.Log4j.info("Clicking on  Series tab ");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath("//li[1]//div[@class='series-item--name']"));
		BeforeReplace = ele.getText();
		login.Log4j.info(BeforeReplace);
		Thread.sleep(3000);
		WebElement ele1 = login.driver.findElement(By.xpath(
				"//li[1]//span[@class='series-item-information--additional-info-field series-item-information--additional-info-field__dates']"));
		action.moveToElement(ele1).build().perform();
		login.driver.findElement(By.xpath("//li[1]//span[@title='View as Chart. Type `c`']")).click();

	}

	@And("^Select a series and Click on dropdown icon$")
	public void select_a_series_and_Click_on_dropdown_icon() throws Throwable {
		Thread.sleep(3000);
		login.driver
				.findElement(By
						.xpath("//div[@class='search-presentation-tabs--visible']//span[contains(text(),'Databases')]"))
				.click();
		mouse_hover_on_any_series_level();
		Thread.sleep(3000);
		ele = login.driver.findElement(By.xpath("//ul//li[1]//div[@class='add-to-data-selection--toggle']"));
		action.moveToElement(ele).click().build().perform();

	}

	@Then("^The selected series should be replaced with existing series on the visual$")
	public void the_selected_series_should_be_replaced_with_existing_series_on_the_visual() throws Throwable {
		Thread.sleep(3000);
		if (!BeforeReplace.equals(sname) == true) {
			login.Log4j.info("The selected series replaced with existing series");
		} else {
			AssertJUnit.fail("The selected series not replaced with existing series");
		}
		DeleteVisual();
		DeleteSeries();
	}

	@Then("^Selected series should be added as group in My series$")
	public void selected_series_should_be_added_as_group_in_My_series() throws Throwable {
		Thread.sleep(3000);
		ele = login.driver.findElement(By.xpath("//span[@class='group-name']"));
		str = ele.getText();
		login.Log4j.info(str);
		if (str.contains("Group")) {
			login.Log4j.info("Selected series added to My series tab as group");
		} else {
			AssertJUnit.fail("Selected series not added to My series tab as group");
		}
		DeleteSeries();
	}

	@Then("^The new insight should be created with selected series$")
	public void the_new_insight_should_be_created_with_selected_series() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("confirm_popup_new_insight"))).click();
		login.robot = new Robot();
		// Store all currently open tabs in tabs
		ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
		// Navigate to New Tab
		login.driver.switchTo().window(tabs2.get(1));
		Thread.sleep(10000);
		the_series_should_be_added_to_my_series();
		login.driver.close();
		login.driver.switchTo().window(tabs2.get(0));
	}

	@Then("^The series should be added to My series tab for selected insight$")
	public void the_series_should_be_added_to_My_series_tab_for_selected_insight() throws Throwable {
		Thread.sleep(5000);
		WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("first_insight")));
		ele.click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//button[contains(text(),'Add to insights')]")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//li//a[@class='growl-message--link growl-message--link__highlighted']"))
				.click();
		// login.Log4j.info(ele.getText());
		login.robot = new Robot();
		// Store all currently open tabs in tabs
		ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
		// Navigate to New Tab
		login.driver.switchTo().window(tabs2.get(1));
		Thread.sleep(10000);
		the_series_should_be_added_to_my_series();
		login.driver.close();
		login.driver.switchTo().window(tabs2.get(0));
		Thread.sleep(3000);
		// TC_DB_155
		try {
			close_search_selection_window();
		} catch (Exception e) {

		}
		//
	}

	@Then("^Open the insights and verify the series in My series$")
	public void open_the_insights_and_verify_the_series_in_My_series() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//span[contains(text(),'File')]")).click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Open')]")).click();
		Thread.sleep(3000);
		insightVar = 0;
		List<WebElement> insights_list = login.driver.findElements(By.className("insight-icon-item"));
		login.Log4j.info(insights_list.size());
		for (int i = 0; i < insights_list.size(); i++) {
			Thread.sleep(2000);
			int j = i + 1;
			ele = login.driver.findElement(By.xpath("//div[@class='insight-icon-item'][" + j + "]"));
			action.moveToElement(ele).build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.linkText("OPEN")).click();
			login.robot = new Robot();
			// Store all currently open tabs in tabs
			ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
			// Navigate to New Tab
			login.driver.switchTo().window(tabs2.get(1));
			Thread.sleep(5000);
			List<WebElement> series_list = login.driver
					.findElements(By.xpath("//div[@class='list-container']//span[@class='series-name-field-title']"));
			login.Log4j.info(series_list.size());
			for (int k = 0; k < series_list.size(); k++) {
				int l = k + 1;
				Thread.sleep(2000);
				ele = login.driver.findElement(By.xpath("//div[@class='list-container']//div[@class='webix_cell'][" + l
						+ "]//span[@class='series-name-field-title']"));
				str = ele.getText();
				login.Log4j.info(str);
				login.Log4j.info(sname);
				if (str.equalsIgnoreCase(sname)) {
					login.Log4j.info("Selected series added to My series");
					break;
				} else {
					AssertJUnit.fail("Selected series not added to My series");
				}
			}
			DeleteSeries();
			login.driver.close();
			login.driver.switchTo().window(tabs2.get(0));
			insightVar++;
			// login.Log4j.info(insightVar);
			if (i == 2) {
				login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
				break;

			}
		}
		DeleteSeries();
	}

	@And("^Select a series$")
	public void select_a_series() throws Throwable {
		select_database_as_Daily_Database();
		expand_till_series_level();
		ele = login.driver.findElement(By.xpath("//div[@class='series-item--name']"));
		sname = ele.getText();
		login.Log4j.info(sname);
	}

	@And("^Create new view pannel$")
	public void create_new_view_pannel() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='insight-page-menu-views-container--add-ghost']")).click();
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
		Thread.sleep(5000);
		ele = login.driver.findElement(By.xpath("//div[@class='text-dots']"));
		String actual = ele.getText();
		login.Log4j.info(sname);
		login.Log4j.info(actual);
		AssertJUnit.assertEquals(actual, sname);
		login.Log4j.info("Visual is created ");
		DeleteVisual();
		DeleteSeries();
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

	@And("^Drag and drop on visual$")
	public void drag_and_drop_on_visual() throws Throwable {
		Thread.sleep(3000);
		WebElement Myseries = login.driver.findElement(By.xpath("//div[@class='empty-visual-overlay--text']"));
		action.dragAndDrop(ele, Myseries).build().perform();
	}

	@Then("^The series should be added to the visual$")
	public void the_series_should_be_added_to_the_visual() throws Throwable {
		respective_visual_should_be_created_as_per_the_series_drop();
	}

	@And("^Click on 'A' on keyboard$")
	public void click_on_A_on_keyboard() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='series-list-item--checkbox-wrapper']")).click();
		Thread.sleep(2000);
		robot = new Robot();
		// Adding series to Myseries
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
	}

	@And("^Select some series$")
	public void select_some_series() throws Throwable {
		UnselectMethod();
		expand_World_Trend_Plus_till_series_level();
		Thread.sleep(2000);
		WebElement ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
		login.Log4j.info("List size is :" + li_All.size());
		for (int i = 0; i < li_All.size(); i++) {
			m = i + 1;
			Thread.sleep(3000);
			ele = login.driver
					.findElement(By.xpath("//li[" + m + "]//div[@class='series-list-item--checkbox-wrapper']"));
			ele.click();

			if (i == 4) {
				Thread.sleep(1000);
				just_double_click_on_series();
				break;
			}
		}
	}

	@And("^Just double click on series$")
	public void just_double_click_on_series() throws Throwable {
		// WebElement element =
		// login.driver.findElement(By.xpath("//li[5]//div[@class='series-item--status-icons']"));
		action.doubleClick(ele).click().build().perform();
	}

	@Then("^The selected series should be added to My series/visuals$")
	public void the_selected_series_should_be_added_to_My_series_visuals() throws Throwable {
		Thread.sleep(3000);
		ele = login.driver.findElement(By.xpath("//span[@class='series-panel--count']"));
		str = ele.getText();
		String[] series_panel_count = str.split(" ");
		int Added_series_Count = Integer.parseInt(series_panel_count[0]);
		// No.of series selected
		login.Log4j.info(m);
		// No.of series added to my series
		login.Log4j.info(Added_series_Count);
		if (Added_series_Count == m) {
			login.Log4j.info("Selected series added to My series");

		} else {
			AssertJUnit.fail("Selected series not added to My series");

		}
		DeleteSeries();
	}

	@And("^Expand search panel$")
	public void expand_search_panel() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(
				"//div[@class='insight-search-header--expander']//div[@class='panel-expander--icon panel-expander--icon__right']"))
				.click();
	}

	@And("^Click on My series$")
	public void click_on_My_series() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.cssSelector(".view-selection--btn__active")).click();
	}

	@And("^Select series in any database$")
	public void select_series_in_any_database() throws Throwable {
		UnselectMethod();
		expand_World_Trend_Plus_till_series_level();
		Thread.sleep(2000);
		WebElement ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
		login.Log4j.info("List size is :" + li_All.size());
		for (int i = 0; i < li_All.size(); i++) {
			m = i + 1;
			Thread.sleep(3000);
			ele = login.driver
					.findElement(By.xpath("//li[" + m + "]//div[@class='series-list-item--checkbox-wrapper']"));
			ele.click();

			if (i == 4) {
				Thread.sleep(2000);
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
		if (login.driver.findElement(By.xpath("//button[contains(text(),'Edit Chart')]")).isEnabled()) {
			login.Log4j.info("The selected series added to visual");
		} else {
			AssertJUnit.fail("The selected series not added to visual");
		}
		DeleteVisual();
		DeleteSeries();
	}

	@And("^Right click on any series level of data$")
	public void right_click_on_any_series_level_of_data() throws Throwable {
		UnselectMethod();
		expand_World_Trend_Plus_till_series_level();
		Thread.sleep(2000);
		WebElement ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
		login.Log4j.info("List size is :" + li_All.size());
		for (int i = 0; i < li_All.size(); i++) {
			// int j = i + 1;
			m = i + 1;
			Thread.sleep(3000);
			checkbox = login.driver
					.findElement(By.xpath("//li[" + m + "]//div[@class='series-list-item--checkbox-wrapper']"));
			checkbox.click();
			ele = login.driver.findElement(By.xpath("//li[" + m + "]//div[@class='series-item--name']"));
			if (i == 4) {
				Thread.sleep(2000);
				action.contextClick(ele).build().perform();
				break;
			}
		}
	}

	@And("^Right click on any series level and select more than max series$")
	public void right_click_on_any_series_level_and_select_more_than_max_series() throws Throwable {
		WebElement element = null;
		UnselectMethod();
		expand_World_Trend_Plus_till_series_level();
		Thread.sleep(2000);
		WebElement ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
		login.Log4j.info("List size is :" + li_All.size());
		for (int i = 0; i < li_All.size(); i++) {
			int j = i + 1;
			int k = 0;
			try {
				Thread.sleep(3000);
				ele = login.driver
						.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
				ele.click();
				element = login.driver.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
				jse.executeScript("arguments[0].scrollIntoView(true);", element);
				if (i == 22) {
					Thread.sleep(2000);
					action.contextClick(element).build().perform();
					break;
				}
			} catch (NoSuchElementException e) {
				login.Log4j.error("Series name is null");
				k = j + 1;
				ele = login.driver
						.findElement(By.xpath("//li[" + k + "]//div[@class='series-list-item--checkbox-wrapper']"));
				ele.click();
				element = login.driver.findElement(By.xpath("//li[" + k + "]//div[@class='series-item--name']"));
				// Until the element is not visible keep scrolling
				jse.executeScript("arguments[0].scrollIntoView(true);", element);
				// Thread.sleep(2000);
				// action.contextClick(element).build().perform();
				if (i == 22) {
					Thread.sleep(2000);
					action.contextClick(element).build().perform();
					break;
				}
			}
		}
	}

	@Then("^Copied series should be pasted to my series tab$")
	public void copied_series_should_be_pasted_to_my_series_tab() throws Throwable {
		the_selected_series_should_be_added_to_My_series_visuals();
	}

	@And("^Right click on any series$")
	public void right_click_on_any_series() throws Throwable {
		select_a_series();
		Thread.sleep(2000);
		action.contextClick(ele).build().perform();
	}

	@And("^Select series with separators$")
	public void select_series_with_separators() throws Throwable {
		// Expanding Globaldb till series level
		UnselectMethod();
		CollapseTreeMethod();
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("//div[@data-node-model-id='GLOBAL']//div[@class='toggle']")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(
				"//div[@data-node-model-id='GLOBAL']//div[@class='child-container']//div[1]//div[@class='toggle']"))
				.click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(
				"//div[@data-node-model-id='GLOBAL']//div[@class='child-container']//div[1]//div[1]//div[@class='toggle']"))
				.click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(
				"//div[@data-node-model-id='GLOBAL']//div[@class='child-container']//div[1]//div[1]//div[1]//div[@class='toggle']"))
				.click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(
				"//div[@data-node-model-id='GLOBAL']//div[@class='child-container']//div[1]//div[1]//div[1]//div[2]//div[@class='toggle']"))
				.click();
		Thread.sleep(2000);
		List<WebElement> listOfSeries = login.driver.findElements(By.xpath("//ul[@class='search-series-list']//li"));
		login.Log4j.info(listOfSeries.size());
		for (int i = 0; i < listOfSeries.size(); i++) {
			int j = i + 1;
			Thread.sleep(3000);
			checkbox = login.driver
					.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
			checkbox.click();
			try {
				ele = login.driver.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
				str = ele.getText();

			} catch (NoSuchElementException e) {
				WebElement separator = login.driver
						.findElement(By.xpath("//a[@class='series-list-item--container series-list-item--separator']"));
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
		List<WebElement> Series_list = login.driver
				.findElements(By.xpath("table-container--checkbox svg-checkbox input-control__grey"));
		login.Log4j.info(Series_list.size());
		for (int i = 0; i < Series_list.size(); i++) {
			checkbox = login.driver.findElement(By.xpath(""));

		}
	}

	@Then("^Selected series count should be shown correctly$")
	public void selected_series_count_should_be_shown_correctly() throws Throwable {
		Thread.sleep(3000);
		ele = login.driver.findElement(By.xpath("//span[@class='search-input--selected-count']"));
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
		UnselectMethod();
		CollapseTreeMethod();
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("//div[@data-node-model-id='RUSSIA']//div[1]")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@data-node-model-id='RUSSIA']//div[3]//div[1]//div[1]")).click();
		Thread.sleep(2000);
		login.driver
				.findElement(By.xpath("//div[@data-node-model-id='RUSSIA']//div[3]//div[1]//div[3]//div[1]//div[1]"))
				.click();
		Thread.sleep(5000);
		ele = login.driver.findElement(By.xpath(
				"//div[@data-node-model-id='RUSSIA']//div[3]//div[1]//div[3]//div[1]//div[@class='tree-node'][27]//div[@class='title']//span[@class='svg-checkbox']"));
		jse.executeScript("arguments[0].scrollIntoView(true);", ele);
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(
				"//div[@data-node-model-id='RUSSIA']//div[3]//div[1]//div[3]//div[1]//div[@class='tree-node'][28]//div[@class='title']//span[@class='svg-checkbox']"))
				.click();
		Thread.sleep(2000);
		robot = new Robot();
		// Adding table to Myseries
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='tree-node active']//div[@class='toggle']")).click();
		Thread.sleep(3000);
		List<WebElement> listOfSeries = login.driver.findElements(By.xpath("//ul[@class='search-series-list']//li"));
		login.Log4j.info(listOfSeries.size());
		for (int i = 0; i < listOfSeries.size(); i++) {
			int j = i + 1;
			Thread.sleep(2000);
			ele = login.driver.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
			str = ele.getText();
			login.Log4j.info(str);
			listOne.add(str);
		}
	}

	@Then("^The series in the table should be ordered as in the table in search panel$")
	public void the_series_in_the_table_should_be_ordered_as_in_the_table_in_search_panel() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//div[@class='webix_tree_close']")).click();
		List<WebElement> listOfSeries = login.driver.findElements(By.xpath("//span[@class='series-name-field-title']"));
		login.Log4j.info(listOfSeries.size());
		for (int i = 0; i < listOfSeries.size(); i++) {
			int j = i + 1;
			Thread.sleep(2000);
			ele = login.driver.findElement(By.xpath(
					"//div[@class='webix_column list-series-name webix_last']//div[@class='webix_cell new-series-item']["
							+ j + "]//span[@class='series-name-field-title']"));
			str = ele.getText();
			login.Log4j.info(str);
			listTwo.add(str);
		}
		// Validating the series order in the table
		boolean result = Arrays.equals(listOne.toArray(), listTwo.toArray());
		login.Log4j.info(result);
		DeleteSeries();
	}

	@And("^Select some series from series level$")
	public void select_some_series_from_series_level() throws Throwable {
		select_series_in_any_database();
	}

	@And("^Click on selected series count$")
	public void click_on_selected_series_count() throws Throwable {
		Thread.sleep(5000);
		login.Log4j.info("Clicking on selected series count");
		ele = login.driver.findElement(By.xpath("//span[@class='search-input--preview-selection']"));
		ele.click();
		WebElement element = login.driver.findElement(By.xpath("//div[@class='search-selection']"));
		BeforeMinimize_dimension = element.getSize();
		login.Log4j.info("Before minimize dimension is :" + BeforeMinimize_dimension);

	}

	@Then("^\"([^\"]*)\" panel should be opened$")
	public void panel_should_be_opened(String arg1) throws Throwable {
		Thread.sleep(3000);
		ele = login.driver.findElement(By.xpath("//div[@class='single-series-preview--title ']"));
		str = ele.getText();
		login.Log4j.info(str);
		if (str.contains(arg1) == true) {
			login.Log4j.info(arg1 + " is opened");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@title='Close']")).click();
		} else {
			AssertJUnit.fail(arg1 + " is not opened");
		}
	}

	@And("^Click on series$")
	public void click_on_series() throws Throwable {
		Thread.sleep(3000);
		List<WebElement> list = login.driver.findElements(By.xpath("//div[@class='movable-modal--body-wrapper']//li"));
		for (int i = 0; i < list.size(); i++) {
			int j = i + 1;
			Thread.sleep(4000);
			ele = login.driver.findElement(By.xpath(
					"//div[@class='movable-modal--body-wrapper']//li[" + j + "]//div[@class='series-item--name']"));
			ele.click();
			ssp_window_should_be_opened();
		}
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@title='Close']")).click();
	}

	@Then("^SSP window should be opened$")
	public void ssp_window_should_be_opened() throws Throwable {
		Thread.sleep(1000);
		if (login.driver.findElement(By.xpath("//div[@class='series-preview--header ui-draggable-handle']"))
				.isDisplayed()) {
			login.Log4j.info("SSP window is opened");
			Thread.sleep(1000);
			login.driver
					.findElement(
							By.xpath("//div[@class='movable-modal--header ui-draggable-handle']//div[@title='Close']"))
					.click();
		} else {
			AssertJUnit.fail("SSP window is not opened");
		}
	}

	@And("^Observe the series count in Series Selection window$")
	public void observe_the_series_count_in_Series_Selection_window() throws Throwable {
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath("//div[@class='single-series-preview--title ']"));
		str = ele.getText();
		login.Log4j.info(str);
		String[] arr = str.split(" ");
		login.Log4j.info(arr[2]);
		SeriesCount = Integer.parseInt(arr[2].replaceAll("\\(", ""));
		login.Log4j.info(SeriesCount);

	}

	@Then("^Series count should be match with available series$")
	public void series_count_should_be_match_with_available_series() throws Throwable {
		Thread.sleep(2000);
		List<WebElement> series_list = login.driver
				.findElements(By.xpath("//div[@class='movable-modal--body-wrapper']//li"));
		login.Log4j.info(series_list.size());
		if (SeriesCount == series_list.size()) {
			login.Log4j.info("Series count does match with available series");
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//div[@title='Close']")).click();
		} else {
			AssertJUnit.fail("Series count doesn't match with available series");
		}
	}

	@And("^Click on \\+icon on series$")
	public void click_on_icon_on_series() throws Throwable {
		Thread.sleep(3000);
		ele = login.driver.findElement(
				By.xpath("//div[@class='search-selection']//li[5]//div[@class='add-to-data-selection--icon']"));
		action.moveToElement(ele).click().build().perform();
		login.Log4j.info("Clicking on + icon on series");
	}

	@And("^Click on \\+icon on header$")
	public void click_on_icon_on_header() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(
				"//div[@class='single-series-preview--series-action']//div[@class='add-to-data-selection--icon']"))
				.click();
		login.Log4j.info("Clicking on + icon on header");
	}

	@And("^Click on dropdown icon next to \\+$")
	public void click_on_dropdown_icon_next_to() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(
				"//div[@class='single-series-preview--series-action']//div[1]//div[@class='add-to-data-selection--toggle']"))
				.click();
		login.Log4j.info("Clicking on dropdown icon");
	}

	@Then("^The series should be added to My series panel$")
	public void the_series_should_be_added_to_My_series_panel() throws Throwable {
		Thread.sleep(3000);
		ele = login.driver.findElement(By.xpath("//span[@class='series-panel--count']"));
		str = ele.getText();
		String[] series_panel_count = str.split(" ");
		int Added_series_Count = Integer.parseInt(series_panel_count[0]);
		// No.of series added to my series
		login.Log4j.info(Added_series_Count);
		if (Added_series_Count == SeriesCount) {
			login.Log4j.info("Selected series added to My series");

		} else {
			AssertJUnit.fail("Selected series not added to My series");

		}
		DeleteSeries();
	}

	@And("^Select any series$")
	public void select_any_series() throws Throwable {
		Thread.sleep(3000);
		login.driver
				.findElement(By
						.xpath("//div[@class='search-presentation-tabs--visible']//span[contains(text(),'Databases')]"))
				.click();
		select_a_series();
		login.driver.findElement(By.xpath("//div[@class='series-list-item--checkbox-wrapper']")).click();

	}

	@And("^Close search selection window$")
	public void close_search_selection_window() throws Throwable {
		Thread.sleep(1500);
		login.driver.findElement(By.xpath("//div[@class='movable-modal--close']")).click();
	}

	@Then("^New insight should be created with selected series in my series$")
	public void new_insight_should_be_created_with_selected_series_in_my_series() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("confirm_popup_new_insight"))).click();
		login.robot = new Robot();
		// Store all currently open tabs in tabs
		ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
		// Navigate to New Tab
		login.driver.switchTo().window(tabs2.get(1));
		Thread.sleep(10000);
		the_series_should_be_added_to_My_series_panel();
		login.driver.close();
		login.driver.switchTo().window(tabs2.get(0));
		Thread.sleep(3000);
		close_search_selection_window();
	}

	@And("^Click on \"([^\"]*)\" icon on header$")
	public void click_on_icon_on_header(String arg1) throws Throwable {

		login.Log4j.info("Clickig on " + arg1);
		Thread.sleep(3000);
		if (arg1.equals("Maximize")) {
			login.driver.findElement(By.xpath("//div[@title='Full-screen']")).click();

		} else {
			login.driver.findElement(By.xpath("//div[@title='" + arg1 + "']")).click();

		}
	}

	@And("^Click on close icon$")
	public void click_on_close_icon() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//li[1]//span[@title='Remove series']")).click();
	}

	@Then("^The window should be \"([^\"]*)\"$")
	public void the_window_should_be(String arg1) throws Throwable {
		Thread.sleep(3000);
		ele = login.driver.findElement(By.xpath("//div[@class='search-selection']"));
		dimension = ele.getSize();
		login.Log4j.info("After " + arg1 + " dimension is  :" + dimension);
		if (!BeforeMinimize_dimension.equals(dimension)) {
			login.Log4j.info("The window is " + arg1);
		} else {
			AssertJUnit.fail("The window is not " + arg1);
		}
		Thread.sleep(3000);
		close_search_selection_window();
	}

	@Then("^The window should be maximized$")
	public void the_window_should_be_maximized() throws Throwable {
		Thread.sleep(3000);
		ele = login.driver.findElement(By.xpath("//div[@class='search-selection']"));
		dimension = ele.getSize();
		login.Log4j.info("After minimize dimension is  :" + dimension);
		if (!BeforeMinimize_dimension.equals(dimension)) {
			login.Log4j.info("The window is maximized");
		} else {
			AssertJUnit.fail("The window is not maximized");
		}
	}

	@And("^Click on Exit full-screen icon$")
	public void click_on_Exit_full_screen_icon() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//div[@title='Exit full-screen']")).click();
		login.Log4j.info("Clicking on Exit full-screen");
	}

	@Then("^The popup should be displayed in normal size$")
	public void the_popup_should_be_displayed_in_normal_size() throws Throwable {
		Dimension After_ExitFull_screen_dimension;
		Thread.sleep(3000);
		ele = login.driver.findElement(By.xpath("//div[@class='search-selection']"));
		After_ExitFull_screen_dimension = ele.getSize();
		login.Log4j.info(After_ExitFull_screen_dimension);
		if (BeforeMinimize_dimension.equals(After_ExitFull_screen_dimension)) {
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
				By.xpath("//div[@class='movable-modal--body-wrapper']//li[1]//div[@class='series-item--name']"));
		str = ele.getText();
		Thread.sleep(2000);
		action.moveToElement(ele).build().perform();
		login.Log4j.info("Mouse hovering on series");
	}

	@Then("^Series count should be reduced as per the series deletion$")
	public void series_count_should_be_reduced_as_per_the_series_deletion() throws Throwable {
		Thread.sleep(2000);
		// after remove one series observe the series count
		ele = login.driver.findElement(By.xpath("//div[@class='single-series-preview--title ']"));
		str = ele.getText();
		login.Log4j.info(str);
		String[] arr = str.split(" ");
		login.Log4j.info(arr[2]);
		int AfterRemoveSeries_Count = Integer.parseInt(arr[2].replaceAll("\\(", ""));
		login.Log4j.info(AfterRemoveSeries_Count);
		Assert.assertNotEquals(SeriesCount, AfterRemoveSeries_Count);
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
					By.xpath("//div[@class='search-selection']//li[" + j + "]//div[@class='series-item--name']"));
			String str1 = ele.getText();
			if (!str1.equals(str)) {
				login.Log4j.info("The series is removed from the popup as per the deletion");
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
			if (!login.driver.findElement(By.xpath("//div[@class='movable-modal--header']")).isDisplayed()) {

			}
		} catch (NoSuchElementException e) {
			login.Log4j.info("The window is closed");
		}
	}

	@Then("^\"([^\"]*)\" icon should be displayed for series$")
	public void icon_should_be_displayed_for_series(String arg1) throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(
				"//div[@class='child-container']//div[2]//div[1]//div[1]//div[1]//div[@class='tree-node'][1]//div[@class='toggle']"))
				.click();
		Thread.sleep(2000);
		WebElement ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		List<WebElement> ListOfSeries = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
		login.Log4j.info("List size is :" + ListOfSeries.size());

		for (int i = 0; i < ListOfSeries.size(); i++) {
			Thread.sleep(3000);
			login.Log4j.info(i);
			login.Log4j.info(ListOfSeries.size());
			int j = i + 1;
			if (arg1.equals("NEW")) {
				try {
					ele = login.driver
							.findElement(By.xpath("//li[" + j + "]//span[@class='status-icon status-icon__new']"));
					action.moveToElement(ele).build().perform();

				} catch (NoSuchElementException e) {
					login.Log4j.error("Series name is null");
					int k = j + 1;
					ele = login.driver
							.findElement(By.xpath("//li[" + k + "]//span[@class='status-icon status-icon__new']"));
					action.moveToElement(ele).build().perform();

				} finally {
					// Until the element is not visible keep scrolling
					// jse.executeScript("arguments[0].scrollIntoView(true);", ele);
					String New_icon = ele.getText();
					if (New_icon.equalsIgnoreCase(arg1) == true) {
						login.Log4j.info(arg1 + " label is shown for series level");
					} else {
						AssertJUnit.fail(arg1 + " label is not shown for series level");

					}
				}
			} else if (arg1.equals("k")) {
				try {
					ele = login.driver
							.findElement(By.xpath("//li[" + j + "]//span[@class='status-icon status-icon__key']"));
					action.moveToElement(ele).build().perform();

				} catch (NoSuchElementException e) {
					login.Log4j.error("Series name is null");
					int k = j + 1;
					ele = login.driver
							.findElement(By.xpath("//li[" + k + "]//span[@class='status-icon status-icon__key']"));
					action.moveToElement(ele).build().perform();

				} finally {
					// Until the element is not visible keep scrolling
					// jse.executeScript("arguments[0].scrollIntoView(true);", ele);
					String Key_icon = ele.getText();
					if (Key_icon.equalsIgnoreCase(arg1) == true) {
						login.Log4j.info(arg1 + " icon is shown for series level");
					} else {
						AssertJUnit.fail(arg1 + " icon is not shown for series level");

					}
				}
			} else if (arg1.equals("f")) {
				try {
					ele = login.driver.findElement(
							By.xpath("//li[" + j + "]//span[@class='status-icon status-icon__has-forecast']"));
					action.moveToElement(ele).build().perform();

				} catch (NoSuchElementException e) {
					login.Log4j.error("Series name is null");
					int k = j + 1;
					ele = login.driver.findElement(
							By.xpath("//li[" + k + "]//span[@class='status-icon status-icon__has-forecast']"));
					action.moveToElement(ele).build().perform();

				} finally {
					// Until the element is not visible keep scrolling
					// jse.executeScript("arguments[0].scrollIntoView(true);", ele);
					String forecast_icon = ele.getText();
					if (forecast_icon.equalsIgnoreCase(arg1) == true) {
						login.Log4j.info(arg1 + " icon is shown for series level");
					} else {
						AssertJUnit.fail(arg1 + " icon is not shown for series level");

					}
				}
			} else if (arg1.equals("s")) {
				try {
					ele = login.driver.findElement(
							By.xpath("//li[" + j + "]//span[@class='status-icon status-icon__has-replacements']"));
					action.moveToElement(ele).build().perform();

				} catch (NoSuchElementException e) {
					login.Log4j.error("Series name is null");
					int k = j + 1;
					ele = login.driver.findElement(
							By.xpath("//li[" + k + "]//span[@class='status-icon status-icon__has-replacements']"));
					action.moveToElement(ele).build().perform();

				} finally {
					// Until the element is not visible keep scrolling
					// jse.executeScript("arguments[0].scrollIntoView(true);", ele);
					String rebased_icon = ele.getText();
					if (rebased_icon.equalsIgnoreCase(arg1) == true) {
						login.Log4j.info(arg1 + " icon is shown for series level");
					} else {
						AssertJUnit.fail(arg1 + " icon is not shown for series level");

					}
				}
			}
		}
		TopMethod();
		ResetMethod();
		CollapseTreeMethod();
	}

	@And("^Database tab should be loaded as default tab for the insight$")
	public void database_tab_should_be_loaded_as_default_tab_for_the_insight() throws Throwable {
		Thread.sleep(3000);
		String color = login.driver
				.findElement(By.xpath(
						"//div[@class='search-presentation-tabs--visible']//span[@title='View results as Tree']"))
				.getCssValue("color");
		login.Log4j.info("RGB_Color: " + color);
		String hex = Color.fromString(color).asHex();
		System.out.println("Actual hex value is :" + hex);
		// verify with Actual hex value with Expected hex value
		String expected = "#069a9a";
		Assert.assertEquals(hex, expected);

	}

	@And("^Make View pannel as fullscreen$")
	public void make_View_pannel_as_fullscreen() throws Throwable {
		Thread.sleep(10000);
		login.driver
				.findElement(By.xpath(
						"//div[@class='insight-page--right']//div[@class='panel-expander panel-expander__right']"))
				.click();
	}

	@Then("^Search panel should be expanded and Databases tab should be loaded$")
	public void search_panel_should_be_expanded_and_Databases_tab_should_be_loaded() throws Throwable {
		database_tab_should_be_loaded_as_default_tab_for_the_insight();
		login.Log4j.info("Search pannel is expanded and Databases tab is loaded");
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("logout_dropdown"))).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("logout"))).click();

	}

	@And("^Select \"([^\"]*)\" from More filter$")
	public void select_from_More_filter(String arg1) throws Throwable {
		/*
		 * Thread.sleep(10000);
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty("input_username"
		 * ))) .sendKeys("ceicsuresh@gmail.com"); Thread.sleep(2000);
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty("input_password"
		 * ))).sendKeys("Ceic@123"); Thread.sleep(1000);
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty("btnLogin"))).
		 * click();
		 */
		Thread.sleep(20000);
		WebElement unsubscribed_db_beforeApplyFilter = login.driver.findElement(
				By.xpath("//div[@class='child-container']//div[@class='unsubscribed-series database-node tree-node']"));
		str = unsubscribed_db_beforeApplyFilter.getText();
		if (unsubscribed_db_beforeApplyFilter.isDisplayed()) {
			login.Log4j.info("Unsubscribed db is :" + str);
		}
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//span[@title='More']")).click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();

	}

	@Then("^Unsubscribed database should not be shown in database tab$")
	public void unsubscribed_database_should_not_be_shown_in_database_tab() throws Throwable {
		Thread.sleep(5000);
		List<WebElement> unsubscribed_db_AfterApplyFilter = login.driver.findElements(
				By.xpath("//div[@class='child-container']//div[@class='unsubscribed-series database-node tree-node']"));
		if (unsubscribed_db_AfterApplyFilter.size() != 0) {
			// If list size is non-zero, element is present
			Assert.fail("Element present");
		} else {
			// Else if size is 0, then element is not present
			System.out.println("Unsubscribed database is not shown");
		}
		ResetMethod();

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

	public void UnselectMethod() throws InterruptedException {
		Thread.sleep(2000);
		WebElement unselect = login.driver.findElement(By.xpath("//div[contains(text(),'Unselect')]"));
		if (unselect.isDisplayed()) {
			unselect.click();
		}
	}

	public void CollapseTreeMethod() throws InterruptedException {
		Thread.sleep(2000);
		try {
			WebElement collapseTree = login.driver.findElement(By.xpath("//span[@title='Collapse tree']"));
			if (collapseTree.isDisplayed()) {
				collapseTree.click();
				login.Log4j.info("Clicking on collapseTree");
			}
		} catch (Exception e) {

		}
	}

	public static void TopMethod() throws InterruptedException {
		Thread.sleep(3000);
		WebElement topButton = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TopButton")));
		if (topButton.isDisplayed()) {
			topButton.click();
			login.Log4j.info("Clicking on Top button");
		}
	}

	public static void DeleteVisual() throws InterruptedException {
		// Deleting visual
		Thread.sleep(3000);
		WebElement ele = login.driver.findElement(By.xpath(
				"//div[@class='insight-page-menu-views-container--view-tabs ui-sortable']//a[@class='insight-page-view-tab--link insight-page-view-tab--link__active']"));
		action.contextClick(ele).build().perform();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Delete view')]")).click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
	}

	public static void DeleteSeries() throws InterruptedException {
		try {
			// Deleting series from My Series tab
			Thread.sleep(3000);
			WebElement ele = login.driver
					.findElement(By.xpath("//div[@class='check-all-series']//span[@class='input-control--indicator']"));
			action.moveToElement(ele).click().build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@data-action='delete']")).click();
		} catch (Exception e) {

		}
	}

	public static void ResetMethod() throws InterruptedException {
		List<WebElement> reset = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Reset")));
		try {
			if (reset.size() > 0) {
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).isDisplayed()) {
					Thread.sleep(2000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
					login.Log4j.info("Clicking on Reset button");
				}
			}
		} catch (Exception e) {

		}
	}
}
