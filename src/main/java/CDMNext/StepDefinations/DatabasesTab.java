package CDMNext.StepDefinations;

import org.testng.Assert;
import org.testng.AssertJUnit;
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
	int afterFilter;

	@Given("^Click on All Databases dropdown$")
	public void click_on_All_Databases_dropdown() throws Throwable {
		Thread.sleep(3000);
		// SearchTest.ClearSelection();
		AlldbClear();
		login.driver.findElement(By.xpath("//span[contains(text(),'All databases')]")).click();
		login.Log4j.info("Clicking on All databases tab ");
	}

	@And("^Select database as \"([^\"]*)\"$")
	public void select_database_as(String arg1) throws Throwable {
		// Db = arg1;
		// Thread.sleep(2000);
		// dbarr = Db.split(" ");
		// login.driver.findElement(By.xpath("//div//span[contains(text(),'" + arg1 +
		// "')]/preceding-sibling::label/span[@class='input-control--indicator']")).click();
		// login.Log4j.info("Selecting " + Db);

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
		login.driver
				.findElement(By
						.xpath("//div[@class='search-presentation-tabs--visible']//span[contains(text(),'Databases')]"))
				.click();
		dbarr = DataBase[0].split(" ");
		if (DataBase[0].equals("India Premium Database")) {
			login.driver.findElement(By.xpath("//div[@class='child-container']//div[1]//div[1]")).click();
			Thread.sleep(2000);
			login.driver
					.findElement(By.xpath(
							"//div[@class='child-container']//div[1]//div[@class='child-container']//div[1]//div[1]"))
					.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(
					"//div[@class='child-container']//div[1]//div[@class='child-container']//div[1]//div[3]//div[1]//div[@class='toggle']"))
					.click();
			Thread.sleep(2000);
			DatabaseValidation();
			if (database == true) {
				HTML_Report.execRemarks = "Results is shown correctly for selected " + DataBase[0];
				login.Log4j.info("Results is shown correctly for selected " + DataBase[0]);

			} else if (database == false) {
				HTML_Report.execRemarks = "Results is not shown correctly for selected " + DataBase[0];
				Assert.fail("Results is not shown correctly for selected " + DataBase[0]);
			}

		}
	}

	@And("^Select database as Daily Database$")
	public void select_database_as_Daily_Database() throws Throwable {
		Thread.sleep(3000);
		AlldbClear();
		login.driver.findElement(By.xpath("//div[@class='child-container']//div[5]//div[@class='toggle']")).click();
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
		WebElement checkbox = login.driver.findElement(By.xpath(
				"//div[@class='child-container']//div[1]//ul//a//div[@class='series-list-item--checkbox-wrapper']//span"));
		if (checkbox.isDisplayed()) {
			HTML_Report.strTCResult = "PASS";
			checkbox.click();
			login.Log4j.info("DB/Topic/section/table level under Databases tab is expanded");
			HTML_Report.execRemarks = "DB/Topic/section/table level under Databases tab is expanded";
		} else {
			HTML_Report.strTCResult = "FAIL";
			login.Log4j.info("DB/Topic/section/table level under Databases tab is not expanded");
			HTML_Report.execRemarks = "DB/Topic/section/table level under Databases tab is not expanded";
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
			HTML_Report.strTCResult = "PASS";
			collapse.click();
			login.Log4j.info("Open data tree is collapsed");
			HTML_Report.execRemarks = "Open data tree is collapsed";
		} else {
			HTML_Report.strTCResult = "FAIL";
			AssertJUnit.fail("Open data tree is not collapse");
			HTML_Report.execRemarks = "Open data tree is not collapse";
		}

	}

	@And("^Select any number of series$")
	public void select_any_number_of_series() throws Throwable {
		Thread.sleep(3000);
		WebElement checkbox;
		login.Log4j.info("Clicking on  Series tab ");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		// create instance of JavaScriptExecutor
		JavascriptExecutor jse = (JavascriptExecutor) login.driver;
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

	@And("^Click on Unselect$")
	public void click_on_Unselect() throws Throwable {
		Thread.sleep(2000);
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TopButton"))).isDisplayed()) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TopButton"))).click();
			login.Log4j.info("Clicking on Top button");
		}
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unselect"))).isDisplayed()) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unselect"))).click();
			login.Log4j.info("Clicking on Unselect");
		}

	}

	@Then("^Selected series should be unselected$")
	public void selected_series_should_be_unselected() throws Throwable {
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unselect"))).isEnabled()) {
			HTML_Report.strTCResult = "PASS";
			login.Log4j.info("The selected series are got unselected");
			HTML_Report.execRemarks = "The selected series are got unselected";
		} else {
			HTML_Report.strTCResult = "FAIL";
			HTML_Report.execRemarks = "The selected series are not unselected";
			AssertJUnit.fail("The selected series are not unselected");
		}

	}

	@Given("^Hover the mouse on any Database$")
	public void hover_the_mouse_on_any_Database() throws Throwable {
		Thread.sleep(3000);
		WebElement db;
		WebElement ele;
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
		action.moveToElement(db).build().perform();
	}

	@Then("^Footnotes icon should be displayed$")
	public void footnotes_icon_should_be_displayed() throws Throwable {
		Thread.sleep(2000);
		footnote = login.driver
				.findElement(By.xpath("//div[@class='child-container']//div[1]//span//i[@title='Open footnote']"));
		if (footnote.isDisplayed()) {
			HTML_Report.strTCResult = "PASS";
			login.Log4j.info("footnote icon is enabled when mouse hover on the databse");
			HTML_Report.execRemarks = "footnote icon is enabled when mouse hover on the databse";
		} else {
			HTML_Report.strTCResult = "FAIL";
			AssertJUnit.fail("footnote icon is not enabled when mouse hover on the databse");
			HTML_Report.execRemarks = "footnote icon is not enabled when mouse hover on the databse";
		}
	}

	@When("^Click on footnote's icon$")
	public void click_on_footnote_s_icon() throws Throwable {
		footnote.click();
		login.Log4j.info("Clicking on footnote icon");
	}

	@Then("^Footnotes should be opened for related DB$")
	public void footnotes_should_be_opened_for_related_DB() throws Throwable {
		Thread.sleep(2000);
		footnoteDb = login.driver.findElement(
				By.xpath("//div[@class='footnotes--main-actions']//div[@class='footnotes-bread-crumb--title']"));
		str = footnoteDb.getText();
		login.Log4j.info(str);
		if (str.contains(dbstr) == true) {
			HTML_Report.strTCResult = "PASS";
			login.Log4j.info("Footnotes is displayed for mouse hover action on DB level");
			HTML_Report.execRemarks = "Footnotes is displayed for mouse hover action on DB level";
		} else {
			HTML_Report.strTCResult = "FAIL";
			HTML_Report.execRemarks = "Footnotes is not displayed for mouse hover action on DB level";
			AssertJUnit.fail("Footnotes is not displayed for mouse hover action on DB level");
		}
		login.driver.findElement(By.xpath("//div[@title='Close']")).click();

	}

	@Given("^Right click on any Database$")
	public void right_click_on_any_Database() throws Throwable {
		Thread.sleep(3000);
		WebElement rightClickElement;
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

	@When("^Paste in new tab$")
	public void paste_in_new_tab() throws Throwable {
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
			HTML_Report.strTCResult = "PASS";
			HTML_Report.execRemarks = "The selected DB is highlighted";
			login.Log4j.info("The selected DB is highlighted for right click action Copy link(s)");
		} else {
			HTML_Report.strTCResult = "FAIL";
			HTML_Report.execRemarks = "The selected DB is not highlighted";
			AssertJUnit.fail("The selected DB is not highlighted for right click action Copy link(s)");
		}
		login.driver.close();
		login.driver.switchTo().window(tabs2.get(0));
	}

	@Then("^Footnotes should be opened for selected DB$")
	public void footnotes_should_be_opened_for_selected_DB() throws Throwable {
		Thread.sleep(2000);
		footnoteDb = login.driver.findElement(
				By.xpath("//div[@class='footnotes--main-actions']//div[@class='footnotes-bread-crumb--title']"));
		str = footnoteDb.getText();
		login.Log4j.info(str);
		if (str.contains(dbstr) == true) {
			HTML_Report.strTCResult = "PASS";
			login.Log4j.info("Footnotes is displayed for right click action on DB level");
			HTML_Report.execRemarks = "Footnotes is displayed for right click action on DB level";
		} else {
			HTML_Report.strTCResult = "FAIL";
			HTML_Report.execRemarks = "Footnotes is not displayed for right click action on DB level";
			AssertJUnit.fail("Footnotes is not displayed for right click action on DB level");
		}
		login.driver.findElement(By.xpath("//div[@title='Close']")).click();

	}

	@And("^Click on x icon to remove DB$")
	public void click_on_x_icon_to_remove_DB() throws Throwable {
		Thread.sleep(2000);
		cross_icon = login.driver
				.findElement(By.xpath("//div[@class='icon--red-cross database-selector--clear-icon']"));
		cross_icon.click();
	}

	@Then("^Selected database shold be removed$")
	public void selected_database_shold_be_removed() throws Throwable {
		if (!cross_icon.isDisplayed()) {
			HTML_Report.strTCResult = "PASS";
			HTML_Report.execRemarks = "Selected database has been removed";
			login.Log4j.info("Selected database has been removed");
		} else {
			HTML_Report.strTCResult = "FAIL";
			HTML_Report.execRemarks = "Selected database has not been removed";
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
		Thread.sleep(3000);
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
					HTML_Report.execRemarks = "Results is shown correctly for selected " + DataBase[i];
					login.Log4j.info("Results is shown correctly for selected " + DataBase[i]);

				} else if (database == false) {
					HTML_Report.execRemarks = "Results is not shown correctly for selected " + DataBase[i];
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
					HTML_Report.execRemarks = "Results is shown correctly for selected " + DataBase[i];
					login.Log4j.info("Results is shown correctly for selected " + DataBase[i]);

				} else if (database == false) {
					HTML_Report.execRemarks = "Results is not shown correctly for selected " + DataBase[i];
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
					HTML_Report.execRemarks = "Results is shown correctly for selected " + DataBase[i];
					login.Log4j.info("Results is shown correctly for selected " + DataBase[i]);
				} else if (database == false) {
					HTML_Report.execRemarks = "Results is not shown correctly for selected " + DataBase[i];
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
			HTML_Report.strTCResult = "FAIL";
			HTML_Report.execRemarks = arg1 + " is not displayed";
			Assert.fail(arg1 + " is not displayed");
		}

	}

	@When("^Click on Close$")
	public void click_on_Close() throws Throwable {
		Thread.sleep(2000);
		WebElement close_icon = login.driver.findElement(By.xpath("//div[@ui='$close']"));
		if (close_icon.isDisplayed()) {
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
			HTML_Report.strTCResult = "PASS";
			HTML_Report.execRemarks = "Insight Explorer popup is closed";
			login.Log4j.info("Insight Explorer popup is closed");
		} else {
			HTML_Report.strTCResult = "FAIL";
			HTML_Report.execRemarks = "Insight Explorer popup is not closed";
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
				"//div[@class='database-node tree-node open']//div[3]//div[1]//div[3]//div[1]//div[3]//div[@class='tree-node'][2]//div[@class='toggle']"))
				.click();
		WebElement element;
		// create instance of JavaScriptExecutor
		JavascriptExecutor jse = (JavascriptExecutor) login.driver;
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
					HTML_Report.strTCResult = "PASS";
					HTML_Report.execRemarks = "Results has shown correctly for applied region filter is " + countryVar;
					login.Log4j.info("Results has shown correctly for applied region filter is " + countryVar);
					Thread.sleep(1000);
					login.driver.findElement(By.xpath("//div[@class='movable-modal--close']")).click();
				} else {
					HTML_Report.strTCResult = "FAIL";
					HTML_Report.execRemarks = "Results has not shown correctly for applied region filter is "
							+ countryVar;
					login.Log4j.info("Results has not shown correctly for applied region filter is " + countryVar);
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

	@When("^Click on x icon$")
	public void click_on_x_icon() throws Throwable {
		Thread.sleep(2000);
		WebElement SeriesCount = login.driver.findElement(By.xpath(
				"//div[@class='series-series-count search-input--series-indicator series-series-count__with-copy']"));
		String after_apply_filter = SeriesCount.getText();
		String[] count = after_apply_filter.split(" ");
		String newStr = count[0].replaceAll(",", "");
		afterFilter = Integer.parseInt(newStr);
		login.Log4j.info("After applied filter series count is " + afterFilter);
		login.driver.findElement(By.xpath(
				"//div[@class='dropdown-filters-list']//div[3]//span[2]//span[@class='select-field--cross-icon']"))
				.click();
		login.Log4j.info("Removing filter.... ");

	}

	@Then("^The applied filters should be removed$")
	public void the_applied_filters_should_be_removed() throws Throwable {
		Thread.sleep(2000);
		WebElement SeriesCount = login.driver.findElement(By.xpath(
				"//div[@class='series-series-count search-input--series-indicator series-series-count__with-copy']"));
		String before_apply_filter = SeriesCount.getText();
		String[] count1 = before_apply_filter.split(" ");
		String newStr = count1[0].replaceAll(",", "");
		int beforeFilter = Integer.parseInt(newStr);
		login.Log4j.info("Before apply filter the series count is " + beforeFilter);
		List<WebElement> reset = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Reset")));
		if (reset.size() > 0 && beforeFilter > afterFilter) {
			login.Log4j.info("The applied filter has been removed");
		} else {
			Assert.fail("The applied filter has not been removed");
		}

	}

	public void DatabaseValidation() throws InterruptedException {
		WebElement element;
		// create instance of JavaScriptExecutor
		JavascriptExecutor jse = (JavascriptExecutor) login.driver;
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

	public static void AlldbClear() throws InterruptedException {
		List<WebElement> clearIcon = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Alldb_clearIcon")));
		if (clearIcon.size() > 0) {
			if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Alldb_clearIcon"))).isDisplayed()) {
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Alldb_clearIcon"))).click();
			}
		}
	}

}
