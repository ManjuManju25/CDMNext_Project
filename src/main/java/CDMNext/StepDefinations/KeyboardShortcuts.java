package CDMNext.StepDefinations;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class KeyboardShortcuts {
	Histogram hs = new Histogram();
	Robot rb;
	// Create object of the Actions class
	Actions actions = new Actions(login.driver);
	WebElement ele, db;
	WebElement checkbox;
	DatabasesTab dbase = new DatabasesTab();
	String before_replace_titleText;
	String activeElement;

	@And("^Select series from My Seris tab$")
	public void select_series_from_My_Seris_tab() throws Throwable {
		hs.add_series_to_the_my_series_tab();

	}

	@And("^Press \"([^\"]*)\" on KB$")
	public void press_on_KB(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		switch (arg1) {
		case "Delete":
			DeleteSeries();
			break;
		case "D":
			// Create Robot class
			rb = new Robot();
			// Press D keyboard key
			rb.keyPress(KeyEvent.VK_D);
			break;
		case "Ctrl+X":
			cutSeries();
			break;
		case "Ctrl+C":
			copySeries();
			break;
		case "Ctrl+V":
			copySeries();
			CommonFunctionality.wait(500);
			pasteSeries();
		case "Ctrl+Z":
			CommonFunctionality.wait(500);
			actions.keyDown(Keys.CONTROL);
			actions.sendKeys("z");
			actions.keyUp(Keys.CONTROL);
			actions.build().perform();
			break;
		case "Ctrl+Y":
			CommonFunctionality.wait(500);
			actions.keyDown(Keys.CONTROL);
			actions.sendKeys("y");
			actions.keyUp(Keys.CONTROL);
			actions.build().perform();
			break;
		case "Ctrl+H":
			CommonFunctionality.wait(500);
			actions.keyDown(Keys.CONTROL);
			actions.sendKeys("h");
			actions.keyUp(Keys.CONTROL);
			actions.build().perform();
			break;
		case "Esc":
			CommonFunctionality.wait(500);
			actions.sendKeys(Keys.ESCAPE).build().perform();
			break;
		case "C":
			CommonFunctionality.wait(200);
			rb = new Robot();
			rb.keyPress(KeyEvent.VK_C);
			break;
		case "M":
			CommonFunctionality.wait(200);
			rb = new Robot();
			rb.keyPress(KeyEvent.VK_M);
			break;
		case "T":
			CommonFunctionality.wait(200);
			rb = new Robot();
			rb.keyPress(KeyEvent.VK_T);
			break;
		case "S":
			CommonFunctionality.wait(200);
			rb = new Robot();
			rb.keyPress(KeyEvent.VK_S);
			break;
		case "V":
			CommonFunctionality.wait(200);
			rb = new Robot();
			rb.keyPress(KeyEvent.VK_V);
			break;
		case "Spacebar":
			CommonFunctionality.wait(300);
			actions.sendKeys(Keys.SPACE).build().perform();
			break;
		case "R":
			CommonFunctionality.wait(500);
			rb = new Robot();
			rb.keyPress(KeyEvent.VK_R);
			break;
		case "F":
			CommonFunctionality.wait(500);
			rb = new Robot();
			rb.keyPress(KeyEvent.VK_F);
			break;
		case "L":
			// before perform keyboard action
			activeElement = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-tab active']", 15)
					.getText();
			CommonFunctionality.wait(500);
			rb = new Robot();
			rb.keyPress(KeyEvent.VK_L);
			break;
		case "Shift+?":
			CommonFunctionality.wait(500);
			actions.keyDown(Keys.SHIFT);
			actions.sendKeys("?");
			actions.keyUp(Keys.SHIFT);
			actions.build().perform();
			break;
		case "Shift+A":
			CommonFunctionality.wait(500);
			actions.keyDown(Keys.SHIFT);
			actions.sendKeys("A");
			actions.keyUp(Keys.SHIFT);
			actions.build().perform();
			break;
		default:
		}
	}

	@Then("^The selected series should be deleted$")
	public void the_selected_series_should_be_deleted() throws Throwable {
		CommonFunctionality.wait(1000);
		if (login.driver.findElements(By.xpath("//*[@class='series-name-wrapper ']")).size() == 0) {
			login.Log4j.info("The selected series is deleted for KB DELETE");
		} else {
			Assert.fail("The selected series not deleted");
		}
	}

	@And("^Select Visual$")
	public void select_Visual() throws Throwable {
		hs.create_a_Histogram_visual_without_selecting_series();
		login.Log4j.info("Clicking on  Series tab ");
		CommonFunctionality.wait(10000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		CommonFunctionality.wait(4000);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='add-to-data-selection--icon']", 30).click();
	}

	@Then("^The selected series should be cut$")
	public void the_selected_series_should_be_cut() throws Throwable {
		CommonFunctionality.wait(500);
		WebElement ele = login.driver.findElement(By.xpath("//div[@class='growl-message-text']"));
		String GrowlText = ele.getText();
		login.Log4j.info(GrowlText);
		if (GrowlText.equals("All series cut.")) {
			login.Log4j.info(GrowlText);
		} else {
			Assert.fail("The seclected series doesn't cut");
		}
	}

	@Then("^The selected series should be copied to  clipboard$")
	public void the_selected_series_should_be_copied_to_clipboard() throws Throwable {
		Thread.sleep(2000);
		String Clipboard_data = (String) Toolkit.getDefaultToolkit().getSystemClipboard()
				.getData(DataFlavor.stringFlavor);
		login.Log4j.info(Clipboard_data);
		if (Clipboard_data.equalsIgnoreCase("All series copied.")) {
			login.Log4j.info("The selected series is copied to clipboard");
		} else {
			login.Log4j.info("The selected series is not copied to clipboard");
		}

	}

	@Then("^The data should be pasted$")
	public void the_data_should_be_pasted() throws Throwable {
		CommonFunctionality.wait(500);
		WebElement ele = login.driver.findElement(By.xpath("//div[@class='growl-message-text']"));
		String GrowlText = ele.getText();
		login.Log4j.info(GrowlText);
		CommonFunctionality.wait(1000);
		List<WebElement> listOfSeries = login.driver.findElements(By.xpath("//*[@class='series-name-wrapper ']"));
		if (GrowlText.equals("Data pasted from clipboard") && listOfSeries.size() == 1) {
			login.Log4j.info(GrowlText);
		} else {
			Assert.fail("The seclected series is pasted");
		}
	}

	@And("^Delete the selected series$")
	public void delete_the_selected_series() throws Throwable {
		DeleteSeries();
	}

	@Then("^The deleted series should be displayed$")
	public void the_deleted_series_should_be_displayed() throws Throwable {
		CommonFunctionality.wait(1000);
		if (login.driver.findElements(By.xpath("//*[@class='series-name-wrapper ']")).size() != 0) {
			login.Log4j.info("The deleted series is rollback");
		} else {
			Assert.fail("The deleted series not displayed");
		}
	}

	@And("^Add series to the Data tab$")
	public void add_series_to_the_Data_tab() throws Throwable {
		hs.add_series_to_the_my_series_tab();
	}

	@Then("^The added series should not be displayed$")
	public void the_added_series_should_not_be_displayed() throws Throwable {
		the_selected_series_should_be_deleted();
	}

	@Then("^Download should be closed$")
	public void download_should_be_closed() throws Throwable {
		if (login.driver.findElements(By.xpath("//*[@class='modal-window insight-download modal-window__active']"))
				.size() == 0) {
			login.Log4j.info("Download popup is closed");

		} else {
			Assert.fail("Download popup is not closed");
		}

	}

	@And("^Type keyword on search field$")
	public void type_keyword_on_search_field() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Search", 10).sendKeys("Madras");
	}

	@Then("^Search should be done for entered keywords$")
	public void search_should_be_done_for_entered_keywords() throws Throwable {

	}

	@And("^Select the series$")
	public void select_the_series() throws Throwable {
		Thread.sleep(6000);
		login.Log4j.info("Clicking on  Series tab ");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		//WebElement ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		//List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
		List<WebElement> li_All = login.driver.findElements(By.xpath("//*[@class='series-item--name']"));
		login.Log4j.info("List size is :" + li_All.size());
		for (int i = 0; i < li_All.size();) {
			Thread.sleep(1500);
			int j = i + 1;
			WebElement checkbox = login.driver
					.findElement(By.xpath("(//div[@class='series-representation--list']//div[@class='series-list-item--checkbox-wrapper'])[" + j + "]"));
			checkbox.click();
			break;
		}
	}

	@Then("^The search panel should be expaned/collapsed$")
	public void the_search_panel_should_be_expaned_collapsed() throws Throwable {
		Boolean searchExpand = login.driver
				.findElement(By.xpath("//*[@class='search-input search-input__full-screen']")).isDisplayed();
		if (searchExpand == true) {
			login.Log4j.info("Search panel is expanded");
		} else {
			Assert.fail("Search panel is not expanded");
		}
	}

	@Then("^The View panel should be expaned/collapsed$")
	public void the_View_panel_should_be_expaned_collapsed() throws Throwable {
		CommonFunctionality.wait(500);

		if (login.driver
				.findElements(By.xpath("//*[@class='insights-expander-circle insights-expander-circle--right hide']"))
				.size() == 1) {
			login.Log4j.info("View panel is expanded");
		} else {
			Assert.fail("View panel is not expanded");
		}
	}

	@And("^Expand any databse$")
	public void expand_any_databse() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[text()='Databases']", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "Daily_db", 10).click();
		login.Log4j.info("Clicking on Database level");
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[@data-node-model-id='DAILY']/following::*[@class='toggle'][1]", 4).click();
		CommonFunctionality.wait(500);
		CommonFunctionality
				.getElementByProperty(login.driver,
						"Expand3rdLevel", 4)
				.click();
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByProperty(login.driver,
				"Expand4thLevel",
				4).click();
	}

	@Then("^Press left arrow key on KB$")
	public void press_left_arrow_key_on_KB() throws Throwable {
		WebElement ele = CommonFunctionality.getElementByProperty(login.driver,
				"Deposit_rates", 10);
		ele.click();
		actions.sendKeys(ele, Keys.ARROW_LEFT).build().perform();

	}

	@Then("^The data trees should be collapsed$")
	public void the_data_trees_should_be_collapsed() throws Throwable {

		if (login.driver.findElements(By.xpath(
				"//*[@class='database-representation--link button button__sm button__text_purple database-representation--link__hidden']"))
				.size() == 1) {
			login.Log4j.info("Data tree is collapsed");
		} else {
			Assert.fail("Data tree is not collapsed");
		}
	}

	@And("^Go to any database$")
	public void go_to_any_database() throws Throwable {
		CommonFunctionality.wait(5000);
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[text()='Databases']", 10).click();
		CommonFunctionality.wait(2000);
		db = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-node-model-id='DAILY']/*[2]",
				10);
		db.click();

	}

	@SuppressWarnings("deprecation")
	@And("^Press right arrow key on KB$")
	public void press_right_arrow_key_on_KB() throws Throwable {
		actions.pause(300).sendKeys(db, Keys.ARROW_RIGHT).build().perform();
	}

	@And("^Add some series to the Data tab$")
	public void add_some_series_to_the_Data_tab() throws Throwable {
		Thread.sleep(3000);
		login.Log4j.info("Clicking on  Series tab ");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		//WebElement ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
//		List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
		List<WebElement> li_All = login.driver.findElements(By.xpath("//div[@class='series-representation--list']/*//*[@class='series-item--name']"));
		login.Log4j.info("List size is :" + li_All.size());
		for (int i = 0; i < li_All.size(); i++) {
			Thread.sleep(800);
			int j = i + 1;
			WebElement checkbox = login.driver
					.findElement(By.xpath("//*[@class='series-representation--list']/*[1]/*[1]/*[1]/*[1]/*[1]/*[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
			checkbox.click();
			if (j == 5) {
				CommonFunctionality.wait(500);
				WebElement addIcon = login.driver
						.findElement(By.xpath("//*[@class='series-representation--list']/*[1]/*[1]/*[1]/*[1]/*[1]/*[" + j + "]//div[@class='add-to-data-selection--icon']"));
				Thread.sleep(500);
				addIcon.click();
				break;
			}
		}
	}

	@And("^Press \"([^\"]*)\" for select all series$")
	public void press_for_select_all_series(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		actions.keyDown(Keys.CONTROL);
		actions.sendKeys("a");
		actions.keyUp(Keys.CONTROL);
		actions.build().perform();
	}

	@Then("^All the series in data tab should be selected$")
	public void all_the_series_in_data_tab_should_be_selected() throws Throwable {
		CommonFunctionality.wait(2000);
		Boolean series_panel_selected = login.driver.findElement(By.xpath("//*[@class='series-panel--selected']"))
				.isDisplayed();
		WebElement selected = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='input-control--indicator']//*[@class='icon']//following::*[contains(@class,'list-container')]",
				4);
		if (selected.getAttribute("class").contains("all-selected") && series_panel_selected == true) {
			login.Log4j.info("All the series in My series tab is selected");
		} else {
			Assert.fail("All the series in My series tab is not selected");
		}
	}

	@And("^Select any series from Data tab$")
	public void select_any_series_from_Data_tab() throws Throwable {
		CommonFunctionality.wait(1000);
		checkbox = login.driver.findElement(By.xpath(
				"//*[contains(@class,'webix_column list-series-name webix_first')]/*[1]//*[@class='series-name-wrapper ']/*[1]"));
		checkbox.click();

	}

	@Then("^The separator should be added in next to the selected series$")
	public void the_separator_should_be_added_in_next_to_the_selected_series() throws Throwable {
		Boolean seperateRow = login.driver.findElement(By.xpath("//*[@class='series-name-wrapper separator-row ']"))
				.isDisplayed();
		if (seperateRow == true) {
			login.Log4j.info("The seperator is added");
		} else {
			Assert.fail("The seperator is not added");
		}
	}

	@Then("^The selected series should be added to Data tab$")
	public void the_selected_series_should_be_added_to_Data_tab() throws Throwable {
		CommonFunctionality.wait(1000);
		List<WebElement> seriesList = login.driver.findElements(
				By.xpath("//*[@class='webix_column list-series-name webix_last']//*[@class='series-name-wrapper ']"));
		if (seriesList.size() == dbase.i) {
			login.Log4j.info("The selected series added to Data tab");
		} else {
			Assert.fail("The selected series not added to Data tab");
		}
	}

	@And("^Select any series from the series tab$")
	public void select_any_series_from_the_series_tab() throws Throwable {
		CommonFunctionality.wait(500);
		before_replace_titleText = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='title']", 4)
				.getText();
		//CommonFunctionality.ResetMethod();
		CommonFunctionality.getElementByProperty(login.driver, "Search", 8).sendKeys("5190001");
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		CommonFunctionality.wait(5000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='series-representation--list']/*//*[contains(@class,'svg-checkbox')]", 30).click();
	}

	@Then("^The visual should be replaced the series with selected series$")
	public void the_visual_should_be_replaced_the_series_with_selected_series() throws Throwable {
		String After_replacement = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='title']", 8)
				.getText();
		if (!before_replace_titleText.equals(After_replacement)) {
			login.Log4j.info("The visual is replaced the series with selected series");
		} else {
			Assert.fail("Verification failed");
		}
	}

	@Then("^The function editor should be poped up$")
	public void the_function_editor_should_be_poped_up() throws Throwable {
		CommonFunctionality.wait(500);
		Boolean FunctionEditor = login.driver.findElement(By.xpath("//*[contains(text(),'Apply functions')]"))
				.isDisplayed();
		if (FunctionEditor == true) {
			login.Log4j.info("The function editor popup is opened");
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 4).click();
		} else {
			Assert.fail("The function editor popup is not opened");
		}

	}

	@Then("^The Data tab should be Swich to list/table mode$")
	public void the_Data_tab_should_be_Swich_to_list_table_mode() throws Throwable {
		String currentActiveElement = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='series-tab active']", 15).getText();
		if (!activeElement.equalsIgnoreCase(currentActiveElement)) {
			login.Log4j.info("The data tab switched to list/table mode ");
		} else {
			Assert.fail("The data tab not switched to list/table mode");
		}
	}

	@Then("^The \"([^\"]*)\" panel should be opened$")
	public void the_panel_should_be_opened(String arg1) throws Throwable {
		String keyboardPopup_titleText = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='modal-title sphere-modal__title text-dots']", 15)
				.getText();
		if (keyboardPopup_titleText.equalsIgnoreCase(arg1)) {
			login.Log4j.info(arg1 + " panel is opened");
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='sphere-modal__close']", 15).click();
		} else {
			Assert.fail(arg1 + " panel is not opened");
		}
	}

	@Then("^The Find and Replace popup should be displayed$")
	public void the_Find_and_Replace_popup_should_be_displayed() throws Throwable {
		if (CommonFunctionality.getElementByXpath(login.driver, "//*[@class='find-and-replace--modal-title']", 15)
				.getText().contains("Rename:")) {
			login.Log4j.info("Finad and Rename popup is displayed");
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 15).click();
		} else {
			Assert.fail("Find and Rename popup is not displayed");
		}
	}

	@Then("^New visual should be created$")
	public void new_visual_should_be_created() throws Throwable {
		String visual = login.driver.findElement(By.xpath("//*[@data-name='title']")).getText();
		if (!visual.isEmpty()) {
			login.Log4j.info("New visual is crated");
		} else {
			Assert.fail("Visual is not created");
		}
	}

	@SuppressWarnings("deprecation")
	void cutSeries() throws InterruptedException {
		ele = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='check-all-series']//span[@class='input-control--indicator']", 4);
		new Actions(login.driver).moveToElement(ele).pause(500).click().build().perform();
		actions.keyDown(Keys.CONTROL);
		actions.sendKeys("x");
		actions.keyUp(Keys.CONTROL);
		actions.build().perform();
	}

	@SuppressWarnings("deprecation")
	void copySeries() throws Exception {
		ele = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='check-all-series']//span[@class='input-control--indicator']", 4);
		new Actions(login.driver).moveToElement(ele).pause(500).click().build().perform();
		actions.keyDown(Keys.CONTROL);
		actions.sendKeys("c");
		actions.keyUp(Keys.CONTROL);
		actions.build().perform();
	}

	void pasteSeries() {
		actions.keyDown(Keys.CONTROL);
		actions.sendKeys("v");
		actions.keyUp(Keys.CONTROL);
		actions.build().perform();
	}

	void DeleteSeries() throws Exception {
		ele = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='check-all-series']//span[@class='input-control--indicator']", 4);
		new Actions(login.driver).moveToElement(ele).pause(500).click().build().perform();
		new Actions(login.driver).pause(100).sendKeys(Keys.DELETE).build().perform();
	}
}
