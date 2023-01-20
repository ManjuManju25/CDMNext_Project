package CDMNext.StepDefinations;

import static org.junit.Assert.fail;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SSPWindow {

	public static String mnemonic_code_id;
	public static String indicator_value;
	public static String values;
	public static String text;
	public static String manage_series_id;
	public static String suggested_series;
	public static String b;
	public static String function_name;
	public static String percentage;
	public static String datefrom;
	public static String dateto;
	public static String obs_date;
	public static String start_ytd;
	public static String end_ytd;
	public static String start_1y;
	public static String end_1y;
	public static String start_3y;
	public static String end_3y;
	public static String start_5y;
	public static String end_5y;
	public static Date start_All;
	public static Date end_All;
	public static String expected;
	public static String thanks_message;
	public static String add_to_recent_insight;
	WebDriverWait wait = new WebDriverWait(login.driver, 120);
	JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	CDMNextSprintCases cv = new CDMNextSprintCases();

	
	
	
	@And("^Clicking on \"([^\"]*)\" dropdown option in preference$")
	public void clicking_on_dropdown_option_in_preference(String arg1) throws Throwable {
	   
		Thread.sleep(2000);
		
		if (arg1.equalsIgnoreCase("Date format")) {
			CommonFunctionality.getElementByProperty(login.driver, "Date_format_in_preferences", 4).click();
		
			
		}
		
		
	}

	
	
	
	
	
	
	
	
	@And("^Check for prerequesties$")
	public void check_for_prerequesties() throws Throwable {
		CommonFunctionality.closing_if_any_opened_modal_popup(login.driver, "movable-modal--close", "//*[contains(@class,'modal-content')]//*[text()='Some changes have not been saved.']", "//*[@class='sphere-modal-controls']//*[text()='Ok']");  
		close_the_replacement_popup_if_appeared();
		if (login.driver.findElements(By.xpath("//*[@class='movable-modal--window']//*[text()='Do you want to keep your insight?']")) .size() > 0)
		{
		  CommonFunctionality.getElementByXpath(login.driver,"//*[@class='movable-modal--window']//*[text()='Start new']",4).click();
		  System.out.println("Start new option is selected in unsaved insight work pop-up display");
		}
		//CommonFunctionality.Views_list();
	}
	
	@And("^Refreshing the page$")
	public void refreshing_the_page() throws Throwable {
		CommonFunctionality.modelbox();
		login.driver.navigate().refresh();
	}
	
	@SuppressWarnings("deprecation")
	@And("^Add few series to myseries$")
	public void add_few_series_to_myseries() throws Throwable {
		
		CommonFunctionality.wait(4000);
		String id = "279629203";
		CommonFunctionality.webDriverwait_keyvalue("Series_tab");
		WebElement my_series = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series")));
		new Actions(login.driver).moveToElement(my_series).pause(500).click().build().perform();
		CommonFunctionality.wait(500);
		WebElement series = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_new")));
		new Actions(login.driver).moveToElement(series).pause(500).click().build().perform();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).clear();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(id);
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		CommonFunctionality.webDriverwait_keyvalue("Series_checkbox");
		WebElement series_cb = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_checkbox")));
		new Actions(login.driver).moveToElement(series_cb).pause(2000).click().build().perform();
		WebElement series_add = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_to_myseries")));
		new Actions(login.driver).moveToElement(series_add).pause(2000).click().build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Search for the series \"([^\"]*)\"$")
	public void search_for_the_series(String arg1) throws Throwable {
		Thread.sleep(4000);
		//Myseries.delete_series();
		try {
			
		
		CommonFunctionality.webDriverwait_keyvalue("Series_tab");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_tab"))).click();
		Thread.sleep(500);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_new"))).click();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).clear();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(arg1);
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		WebElement series_cb = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_checkbox")));
		new Actions(login.driver).moveToElement(series_cb).pause(2000).click().build().perform();
		WebElement series_add = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_to_myseries")));
		new Actions(login.driver).moveToElement(series_add).pause(2000).click().build().perform();
	}
	 catch (org.openqa.selenium.StaleElementReferenceException ex) {
		 
		 CommonFunctionality.webDriverwait_keyvalue("Series_tab");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_tab"))).click();
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_new"))).click();
			CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).clear();
			CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(arg1);
			CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
			WebElement series_cb = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_checkbox")));
			new Actions(login.driver).moveToElement(series_cb).pause(2000).click().build().perform();
			WebElement series_add = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_to_myseries")));
			new Actions(login.driver).moveToElement(series_add).pause(2000).click().build().perform();
		
	}
	}

	@SuppressWarnings("deprecation")
	@And("^hightlight any one series and click on  \"([^\"]*)\" icon \\.$")
	public void hightlight_any_one_series_and_click_on_icon(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		try {
		WebElement one_series = login.driver.findElement(By.xpath("//*[@class='series-name-wrapper ']//*[@class='series-name-field-title']"));
		new Actions(login.driver).moveToElement(one_series).pause(3000).click(login.driver.findElement(By.xpath("//*[@class='series-name-wrapper ']//*[@class='series-name-field-title']"))).build().perform();
		} catch (StaleElementReferenceException e) {
		WebElement one_series = login.driver.findElement(By.xpath("//*[@class='series-name-wrapper ']//*[@class='series-name-field-title']"));
		new Actions(login.driver).moveToElement(one_series).pause(3000).click(login.driver.findElement(By.xpath("//*[@class='series-name-wrapper ']//*[@class='series-name-field-title']"))).build().perform();
		}
	}

	@And("^Check the percentage change value$")
	public void check_the_percentage_change_value() throws Throwable {
		CommonFunctionality.wait(500);
		String text = login.driver.findElement(By.xpath(
				"//*[contains(@class,'change__positive')]//following-sibling::*[@class='series-changes-time-line--change-left']//div[2]"))
				.getAttribute("title");
		percentage = text + " %";
		System.out.println(percentage);
	}

	@Then("^Verify if the percentage change value displayed is correct$")
	public void verify_if_the_percentage_change_value_displayed_is_correct() throws Throwable {
		//CommonFunctionality.wait(3000);
		String percentage1 = "13.05";
		if ((percentage.contains(percentage1))) {
			login.Log4j.info("The percentage change value displayed correctly");
			CommonFunctionality.wait(4000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			Thread.sleep(200);
			CommonFunctionality.DeleteSeries();
		} else {
			Assert.fail("Verify SSP window failed");
		}
	}

	@Then("^Verify SSP window$")
	public void verify_SSP_window() throws Throwable {
		CommonFunctionality.wait(500);
		WebElement ssp_window = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Window")));
		if (ssp_window.isDisplayed()) {
			System.out.println("SSP window is opened and validated");
			CommonFunctionality.getElementByProperty(login.driver, "Close", 8).click();
			CommonFunctionality.DeleteSeries();
		} else {
			CommonFunctionality.getElementByProperty(login.driver, "Close", 8).click();
			CommonFunctionality.DeleteSeries();
			Assert.fail("Verify SSP window failed");
		}
		System.out.println("============================");
	}

	@SuppressWarnings("deprecation")
	@And("^Go to search$")
	public void go_to_search() throws Throwable {
		CommonFunctionality.wait(2000);
		//CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).clear();
		//CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Series_new"))));
		WebElement series = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_new")));
		new Actions(login.driver).moveToElement(series).pause(2000).click().build().perform();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).clear();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys("279629203");
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}

	@SuppressWarnings("deprecation")
	@And("^hightlight any one series from search list and click on  \"([^\"]*)\" icon \\.$")
	public void hightlight_any_one_series_from_search_list_and_click_on_icon(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);
		
		WebElement first_series = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("One_series_from_seriesList")));
		new Actions(login.driver).moveToElement(first_series).pause(2000).click(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("One_series_from_seriesList")))).build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Open SSP window and clicking on \"([^\"]*)\" icon$")
	public void open_SSP_window_and_clicking_on_icon(String arg1) throws Throwable {
		CommonFunctionality.webDriverwait_keyvalue("SSP_Window");
		CommonFunctionality.wait(4000);
		WebElement ssp_window = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Window")));
		if (ssp_window.isDisplayed()) {
			Thread.sleep(1000);
			System.out.println("SSP window is opened");
		}
		WebElement add_series = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_series_dropdown")));
		new Actions(login.driver).moveToElement(add_series).pause(2000).click().build().perform();
		// WebElement dropdown =
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_series_dropdown_arrow")));
		// new
		// Actions(login.driver).moveToElement(dropdown).pause(2000).click().build().perform();
	}

	@And("^Open SSP Window$")
	public void open_SSP_Window() throws Throwable {
		CommonFunctionality.webDriverwait_keyvalue("SSP_Window");
		WebElement ssp_window = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Window")));
		if (ssp_window.isDisplayed()) {
			Thread.sleep(1000);
			System.out.println("SSP window is opened");
		}
	}

	@SuppressWarnings("deprecation")
	@Then("^Verify options on top bar of window$")
	public void verify_options_on_top_bar_of_window() throws Throwable {
		WebElement dropdownList = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'dropdown-menu')]", 4);
		if (dropdownList.isDisplayed()) {
			CommonFunctionality.wait(500);
			System.out.println("Add series options are present");
			WebElement dropdown = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_series_dropdown")));
			new Actions(login.driver).moveToElement(dropdown).pause(2000).click().build().perform();
		} else {
			Assert.fail("Add series options verification failed");
		}

		WebElement view = CommonFunctionality.getElementByXpath(login.driver, "//*[@js-visual-container=\"\"]", 4);
		new Actions(login.driver).moveToElement(view).pause(2000).click().build().perform();
		WebElement dropdown = CommonFunctionality.getElementByXpath(login.driver,
				"//ul[contains(@class,'dropdown-menu')]", 4);
		if (dropdown.isDisplayed()) {
			System.out.println("View as options are present");
		} else {
			Assert.fail("View as options are not present");
		}
		WebElement chart = CommonFunctionality.getElementByXpath(login.driver, "//div[contains(@class,'icon--chart-line_large')]", 4);
		if (chart.isDisplayed()) {
			System.out.println("Chart Option is present");
		} else {
			Assert.fail("Chart option are not present");
		}
		WebElement map = CommonFunctionality.getElementByXpath(login.driver, "//div[contains(@class,'icon--map-filled_large')]", 4);
		if (map.isDisplayed()) {
			System.out.println("Map Option is present");
		} else {
			Assert.fail("Map option not present");
		}
		WebElement table = CommonFunctionality.getElementByXpath(login.driver, "//div[contains(@class,'icon--table-vertical_large')]", 4);
		if (table.isDisplayed()) {
			System.out.println("Table Option is present");
		} else {
			Assert.fail("Table option not present");
		}
		WebElement pie = CommonFunctionality.getElementByXpath(login.driver, "//div[contains(@class,'icon--pie_chart-pie_large')]", 4);
		if (pie.isDisplayed()) {
			System.out.println("Pie Option is present");
		} else {
			Assert.fail("Pie option not present");
		}
		WebElement heatmap = CommonFunctionality.getElementByXpath(login.driver, "//div[contains(@class,'icon--heatmap_large')]", 4);
		if (heatmap.isDisplayed()) {
			System.out.println("Heat map Option is present");
		} else {
			Assert.fail("Heat map option not present");
		}
		WebElement histogram = CommonFunctionality.getElementByXpath(login.driver, "//div[contains(@class,'icon--histogram_large')]", 4);
		if (histogram.isDisplayed()) {
			System.out.println("Histogram Option is present");
		} else {
			Assert.fail("Histogram option not present");
		}
		new Actions(login.driver).moveToElement(view).pause(500).click().build().perform();

		WebElement watch = CommonFunctionality.getElementByXpath(login.driver, "//*[@js-watch-container=\"\"]", 4);
		if (watch.isDisplayed()) {
			System.out.println("Watch Option is present");
		} else {
			Assert.fail("Watch option verification failed");
		}

		WebElement download = CommonFunctionality.getElementByXpath(login.driver, "//*[@js-download-container=\"\"]",
				4);
		if (download.isDisplayed()) {
			CommonFunctionality.wait(1000);
			System.out.println("Download option is present");
		} else {
			Assert.fail("Download option verification failed");
		}

		WebElement modal_actions = CommonFunctionality.getElementByClassName(login.driver, "movable-modal--actions", 4);
		if (modal_actions.isDisplayed()) {
			System.out.println("Minimize, Maximize and close options are present");
		} else {
			Assert.fail("Movable options verification failed");
		}
		login.Log4j.info("All options have been verified and displayed in top bar of SSP window");
		login.driver.findElement(By.className("movable-modal--close")).click();
		CommonFunctionality.DeleteSeries();
	}

	@And("^Open SSP window$")
	public void open_SSP_window_and_clicking_on_Add_icon() throws Throwable {
		CommonFunctionality.wait(1000);
		CommonFunctionality.webDriverwait_keyvalue("SSP_Window");
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Window"))).isDisplayed()) {
			CommonFunctionality.wait(1000);
			System.out.println("SSP window is opened and displayed");
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Click on Add option$")
	public void click_on_Add_option() throws Throwable {
		Thread.sleep(2000);
		WebElement add_series = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_series_dropdown")));
		new Actions(login.driver).moveToElement(add_series).pause(2000).click().build().perform();
		CommonFunctionality.getElementBycssSelector(login.driver, ".items-wrapper span[title='Add']", 4).click();
		CommonFunctionality.wait(6000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
	}

	@Then("^The series should add into right pane$")
	public void the_series_should_add_into_right_pane() throws Throwable {
		CommonFunctionality.wait(1000);
		String series_item_name = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_item_name")))
				.getText();
		CommonFunctionality.wait(1000);
		List<WebElement> element = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("Series_item_name_right_panel")));
		for (int i = 0; i < element.size(); i++) {
			String series_item_name_right_panel = element.get(i).getText();
			if (series_item_name_right_panel.equalsIgnoreCase(series_item_name)) {
				login.Log4j.info("The series added successfully to the right pane");
				CommonFunctionality.DeleteSeries();
				break;
			} else {
				Assert.fail("Verify Series failed");
			}
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Click on Add and group option$")
	public void click_on_add_and_group_option() throws Throwable {
		WebElement add_series = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_series_dropdown")));
		new Actions(login.driver).moveToElement(add_series).pause(2000).click().build().perform();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_and_group"))).click();
		CommonFunctionality.wait(4000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
	}

	@Then("^The series should add into right pane and \"([^\"]*)\"$")
	public void the_series_should_add_into_right_pane_and(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
	    String text = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-name-wrapper']//following-sibling::*[@class='group-name']", 4).getText();
	    String expected[] = text.split("\\:");
	    assertEquals(expected[0], arg1);
	    login.Log4j.info("The series added successfully to the right pane and grouped");
		CommonFunctionality.DeleteSeries();
	}

	@SuppressWarnings("deprecation")
	@And("^Click on Add to new insight option$")
	public void click_on_Add_to_new_insight_option() throws Throwable {
		WebElement add_series = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_series_dropdown")));
		new Actions(login.driver).moveToElement(add_series).pause(2000).click().build().perform();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_to_new_insight"))).click();
	}

	@And("^Series has been added to new insight message should display$")
	public void series_has_been_added_to_new_insight_message_should_display() throws Throwable {
		String text = "New insight with the selected series created";
		CommonFunctionality.webDriverwait_keyvalue("New_insight_added_message");
		String insight_msg = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("New_insight_added_message")))
				.getText();
		if (insight_msg.contains(text)) {
			System.out.println("New Insight has been added successfully");
		} else {
			Assert.fail("Verification of new insight failed");
		}
	}

	@Then("^Clicking on the insight name should open the new insight with the added series$")
	public void clicking_on_the_insight_name_should_open_the_new_insight_with_the_added_series() throws Throwable {
		String URL1 = "Untitled-insight/myseries";
		CommonFunctionality.wait(500);
		login.driver
				.findElement(By.xpath(
						"//*[@class='growl-message growl-success']//*[@class='button growl-message-content--btns__fill']"))
				.click();
		CommonFunctionality.wait(2000);
		String URL = login.driver.getCurrentUrl();
		if (!(URL.equals(URL1))) {
			System.out.println("New insight with the added series is opened");
			ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
			login.driver.switchTo().window(newTab.get(1)).close();
			Thread.sleep(10000);
			login.driver.switchTo().window(newTab.get(0));
			Thread.sleep(8000);
			if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Close"))).size()>0) {
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			}
		} else {
			Assert.fail("Verification of added series failed");
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Click on Add to recent insight option$")
	public void click_on_Add_to_recent_insight_option() throws Throwable {
		WebElement add_series = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_series_dropdown")));
		new Actions(login.driver).moveToElement(add_series).pause(2000).click().build().perform();
		CommonFunctionality.wait(2000);
		WebElement insight = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_to_existing_insight")));
		new Actions(login.driver).moveToElement(insight).pause(2000).click().build().perform();
		CommonFunctionality.wait(4000);
	}

	@And("^Click on sub dropdown option$")
	public void click_on_sub_dropdown_option() throws Throwable {
		if (CommonFunctionality.getElementByXpath(login.driver, "//h4[text()='Add to recent insight']", 4)
				.isDisplayed()) {
			System.out.println("Add to recent insight option is available");
		}
	}

	@And("^Insight explorer page should open$")
	public void insight_explorer_page_should_open() throws Throwable {
		String title = "Insight Explorer";
		String title1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Insight_modal_title"))).getText();
		if (title1.contains(title)) {
			System.out.println("Insights Page opened");
		} else {
			Assert.fail("Verification of insights page failed");
		}
	}

	@Then("^Any insight could be selected for the series to be added$")
	public void any_insight_could_be_selected_for_the_series_to_be_added() throws Throwable {
		WebElement insight = login.driver.findElement(By.xpath(
				"//*[contains(@class,'insights-list__insight-panel')]//*[contains(text(),'Insight')]//following::*[@class='input-control--indicator']"));
		new Actions(login.driver).moveToElement(insight).click().build().perform();
		CommonFunctionality.wait(2000);
		WebElement insight_button = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("Insight_add_button")));
		jse.executeScript("arguments[0].click();", insight_button);
		String actual = "Selected series added to insight";
		String expected = login.driver.findElement(By.xpath("//*[@class='growl-message-text']")).getText();
		CommonFunctionality.wait(2000);
		if (expected.contains(actual)) {
			if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Close"))).size()>0) {
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			}
			System.out.println("Insight explorer page added with series");
		} else {
			if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Close"))).size()>0) {
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			}
			Assert.fail("Insight explorer page does not added with series");
		}
		
	}

	@Then("^Any insight could be selected for the series to add$")
	public void any_insight_could_be_selected_for_the_series_to_add() throws Throwable {
		CommonFunctionality.wait(2000);
		List<WebElement> insights_all = login.driver.findElements(By.className("input-control--description"));
		for (WebElement insight : insights_all) {
			add_to_recent_insight = insight.getText();
			new Actions(login.driver).moveToElement(insight).click().build().perform();
			break;
		}
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='Apply']", 4).click();
		String expected = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='growl-message--link growl-message--link__highlighted'] | //*[@class='growl-message growl-success']//*[@class='button growl-message-content--btns__fill']", 4)
				.getText();
		if (expected.contains(add_to_recent_insight)) {
			login.Log4j.info("Add to existing insight has been verified");
		} else {
			if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Close"))).size()>0) {
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			}
			Assert.fail("Insight verification failed");
		}
		CommonFunctionality.wait(2000);
		
		
		login.driver.findElement(By.xpath("//div[@class='growl-message-close']")).click();
		CommonFunctionality.wait(2000);
		
		if(login.driver.findElements(By.xpath("//div[@class='movable-modal--close']")).size()>0) {
			Thread.sleep(3000);
			
			login.driver.findElement(By.xpath("//div[@class='movable-modal--action-icon movable-modal--action-icon__toggle']")).click();
			
			
			//login.driver.findElement(By.xpath("//div[@class='movable-modal--close']")).click();
		}else {
			fail();
		}
		
	}

	@SuppressWarnings("deprecation")
	@And("^click on create chart option$")
	public void click_on_create_chart_option() throws Throwable {
		WebElement view = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'preview-series-data-actions--button__visual')]", 4);
		new Actions(login.driver).moveToElement(view).pause(500).click().build().perform();
		WebElement chart = CommonFunctionality.getElementByXpath(login.driver, "//div[contains(@class,'icon--chart-line_large')]", 4);
		if (chart.isDisplayed()) {
			System.out.println("Chart Option is present");
			chart.click();
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
	}

	@And("^click on CTC button$")
	public void click_on_CTC_button() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[contains(@class,'preview-series-data-actions--button__action') and @js-copy-container=\"\"]")));
		login.driver.findElement(By.xpath(
				"//*[contains(@class,'preview-series-data-actions--button__action') and @js-copy-container=\"\"]"))
				.click();
		CommonFunctionality.wait(2000);
	}

	@And("^Click on download button$")
	public void click_on_download_button() throws Throwable {
		CommonFunctionality.webDriverwait_locator(
				"//*[@class='single-series-preview--content']//*[contains(@title,'Download') and contains(@class,'download-button')]",
				"xpath");
		login.driver.findElement(By.xpath(
				"//*[@class='single-series-preview--content']//*[contains(@title,'Download') and contains(@class,'download-button')]"))
				.click();
		CommonFunctionality.wait(2000);
	}

	@And("^Clicking on minimize icon$")
	public void clicking_on_minimize_icon() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement minimize_icon = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("footnote_window_minimize")));
		if (minimize_icon.isDisplayed()) {
			assertTrue(true, "Minimize icon is displaying");
			minimize_icon.click();
		}
	}

	@And("^Clicking on full screen icon$")
	public void clicking_on_full_screen_icon() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement maximize_icon = login.driver.findElement(By.xpath("//div[@title='Full-screen']"));
		if (maximize_icon.isDisplayed()) {
			assertTrue(true, "Full screen icon is displaying");
			maximize_icon.click();
			CommonFunctionality.wait(1000);
		}
	}

	@And("^Clicking on close button$")
	public void clicking_on_close_button() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
		CommonFunctionality.wait(2000);
	}

	@And("^click on \"([^\"]*)\" suggestions subscription link$")
	public void click_on_suggestions_subscription_link(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);
		try {
			Thread.sleep(2000);
		manage_series_id = login.driver.findElement(By.xpath("//*[@class='main-series-information--right']//*[@class='main-series-information--series-id']/div[1]")).getText();
		login.driver.findElement(By.xpath("//span[@class='single-series-preview-operations--manage-replacements button button__sm button__special']")).click();
		
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			manage_series_id = login.driver.findElement(By.xpath("//*[@class='main-series-information--right']//*[@class='main-series-information--series-id']/div[1]")).getText();
			login.driver.findElement(By.xpath("//span[@class='single-series-preview-operations--manage-replacements button button__sm button__special']")).click();
		}
		CommonFunctionality.wait(3000);
	}

	@And("^Download data to excel$")
	public void download_data_to_excel() throws Throwable {
		if(login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal-controls--right')]//*[contains(text(),'Download')]//parent::button")).size()>0) {
		  login.driver.findElement(By.xpath("//*[contains(@class,'sphere-modal-controls--right')]//*[contains(text(),'Download')]//parent::button")).click();
	}
	}

	@And("^Click on \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\" buttons$")
	public void click_on_and_buttons(String arg1, String arg2, String arg3) throws Throwable {
		CommonFunctionality.wait(3000);
		try {
			login.driver
					.findElement(By.xpath(
							"//*[contains(text(),'" + arg1 + "') and contains(@title,'Substitute this series')]"))
					.click();
		} catch (Exception j) {
			suggested_series = login.driver.findElement(By.xpath("//div[@class='suggested-series-item--title']"))
					.getText();
			login.driver
					.findElement(By.xpath("//*[@class='suggested-series-control']//*[contains(text(),'" + arg1 + "')]"))
					.click();
		}
		CommonFunctionality.wait(3000);
		login.driver
				.findElement(
						By.xpath("//*[@class='suggestions-wizard--footer']//button[contains(text(),'" + arg2 + "')]"))
				.click();
		CommonFunctionality.wait(3000);
		login.driver
				.findElement(
						By.xpath("//*[@class='suggestions-wizard--footer']//button[contains(text(),'" + arg3 + "')]"))
				.click();
		CommonFunctionality.wait(3000);
	}

	@Then("^chart should be created in a view for series$")
	public void chart_should_be_created_in_a_view_for_series() throws Throwable {
		CommonFunctionality.webDriverwait_keyvalue("One_series_from_seriesList");
		String actual = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("One_series_from_seriesList")))
				.getText();
		String expected = login.driver.findElement(By.cssSelector(".highcharts-title .text-dots , span[data-name='title']")).getText();
		if (expected.equalsIgnoreCase(actual)) {
			login.Log4j.info("Chart created in a view for the series");
			CommonFunctionality.wait(500);
			List<WebElement> visuals = login.driver.findElements(By.xpath(
					"//*[contains(@class,'insight-page-view-tab') and contains(text(),'View')] | //*[contains(@class,'insight-page-view-tab') and contains(text(),'Sheet')]"));
			if (visuals.size() > 0) {
				for (WebElement visual : visuals) {
					new Actions(login.driver).contextClick(visual).build().perform();
					login.driver.findElement(By.xpath("//span[contains(text(),'Delete view')]")).click();
					login.driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
				}
			}
			CommonFunctionality.DeleteSeries();
		} else {
			Assert.fail("Verification of chart creation failed");
		}
	}

	
	@And("^click on Download button$")
	public void click_on_Download_button() throws Throwable {
		CommonFunctionality.wait(2000);
		
		login.driver.findElement(By.xpath("(//span[@class='download-button--text drop-down-button--label'])[2]")).click();
		
	}


	
	
	
	
	
	
	
	
	@Then("^Download settings window to be opened$")
	public void download_settings_window_to_be_opened() throws Throwable {
		CommonFunctionality.wait(2000);
		String actual = login.driver.findElement(By.xpath("//*[@class='download-modal-title']")).getText();
		String expected = login.driver.findElement(By.className("download-modal-title__title")).getText();
		if (actual.contains(expected)) {
			login.Log4j.info("CTC is validated");
			login.driver.findElement(By.className("sphere-modal__close")).click();
			CommonFunctionality.webDriverwait_keyvalue("Close");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
		} else {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			Assert.fail("Verification of CTC failed");
		}
	}

	@Then("^Should be able to download data$")
	public void should_be_able_to_download_data() throws Throwable {
		
		CommonFunctionality.DownloadFileVerify("ssp_title", "Close");
		
		
		
		
	}

	@Then("^verify that SSP window should be minimized$")
	public void verify_that_SSP_window_should_be_minimized() throws Throwable {
		CommonFunctionality.wait(2000);
		if (login.driver.findElements(By.xpath("//*[@title='Minimize']")).size() == 0) {
			login.Log4j.info("SSP Window is minimized as expected");
		} else {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			Assert.fail("SSP window minimize verification failed");
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
	}

	@Then("^verify that SSP window SSP window should be maximized to full screen$")
	public void verify_that_SSP_window_should_be_maximized_to_full_screen() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement maximize = login.driver.findElement(By.xpath(
				"//*[contains(@class,'ui-resizable ui-draggable')]/ancestor::*[contains(@class,'movable-modal__active')]"));
		CommonFunctionality.wait(1000);
		if (maximize.getAttribute("class").contains("movable-modal__full-screen")) {
			login.Log4j.info("SSP Window is maximized to full screen");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
		} else {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			Assert.fail("SSP window maximize verification failed");
		}
	}

	@Then("^Verify that SSP window SSP window should be closed$")
	public void verify_that_SSP_window_should_be_closed() throws Throwable {
		List<WebElement> element = login.driver.findElements(By.className("single-series-preview--content"));
		if (element.size() == 0) {
			login.Log4j.info("SSP Window is Closed successfully");
		} else {
			Assert.fail("SSP window close verification failed");
		}
	}

	@Then("^Verify attributes such as Region,frequency,unit,indicator,source and read more$")
	public void verify_attributes_such_as_region_frequency_unit_indicator_source_and_readmore() throws Throwable {
		String a = "Region";
		String b = "Frequency";
		String c = "Unit";
		String d = "Indicator";
		String e = "Source";
		List<WebElement> element = login.driver.findElements(
				By.xpath("//*[@class='main-series-information']//*[@class='main-series-information--field-name']"));
		int count = element.size();
		for (int i = 0; i < count; i++) {
			String text = element.get(i).getText();
			if (text.contains(a) || text.contains(b) || text.contains(c) || text.contains(d) || text.contains(e)) {
				System.out.println(text + " field is present");
			} else {
				Assert.fail("The fields are not validated properly");
			}
		}
		String more = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Read_more"))).getText();
		if (more.contains("Read More")) {
			System.out.println("Read more: field is present");
			login.Log4j.info("All the fields are present");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			CommonFunctionality.DeleteSeries();
		} else {
			Assert.fail("The Read more field is not validated properly");
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Open SSP for the series \"([^\"]*)\"$")
	public void open_SSP_for_the_series(String arg1) throws Throwable {
		try {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).clear();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_new"))).click();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).clear();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(arg1);
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		CommonFunctionality.wait(2000);
		WebElement first_item_in_list = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("One_series_from_seriesList")));
		new Actions(login.driver).moveToElement(first_item_in_list).pause(3000).click(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("One_series_from_seriesList")))).build().perform();
	} catch (org.openqa.selenium.StaleElementReferenceException ex) {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).clear();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_new"))).click();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).clear();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(arg1);
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		CommonFunctionality.wait(2000);
		WebElement first_item_in_list = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("One_series_from_seriesList")));
		new Actions(login.driver).moveToElement(first_item_in_list).pause(3000).click(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("One_series_from_seriesList")))).build().perform();
	}
	}

	@And("^Checking the \"([^\"]*)\" of the series$")
	public void checking_the_of_the_series(String arg1) throws Throwable {
		CommonFunctionality.wait(4000);
		String element = login.driver
				.findElement(By
						.xpath("//*[@class='main-series-information--field-name' and contains(text(),'" + arg1 + "')]"))
				.getText();
		System.out.println(element);
	}

	@Then("^Verify the \"([^\"]*)\" of the series should be \"([^\"]*)\"$")
	public void verify_the_of_the_series_should_be(String arg1, String arg2) throws Throwable {
		
		String expected = arg2;
		String actual = login.driver.findElement(By.xpath("(//*[contains(text(),'"+arg1+"')]//following::div//span)[1]")).getText();
		                                                   
		if (actual.contains(expected)) {
			login.Log4j.info(arg1 + " of the series has been verified successfully");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
		} else {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			Assert.fail("Verification failed");
			
		}
	}
	
	@Then("^Verify the \"([^\"]*)\"of the series should be \"([^\"]*)\"$")
	public void verify_the_of_the_series_should_be11(String arg1, String arg2) throws Throwable {
	   
		String expected = arg2;
		String actual = login.driver.findElement(By.xpath("(//*[contains(text(),'"+arg1+"')]//following::div[@class='main-series-information--field-value'])[1]")).getText();
		                                                   
		if (actual.contains(expected)) {
			login.Log4j.info(arg1 + " of the series has been verified successfully");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
		} else {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			Assert.fail("Verification failed");
		}
		
		
	}

	@Then("^verify the \"([^\"]*)\" of the series should be \"([^\"]*)\"$")
	public void verify_the_of_the_series_should_be1(String arg1, String arg2) throws Throwable {
	   
		String expected = arg2;
		String actual = login.driver.findElement(By.xpath("(//*[contains(text(),'"+arg1+"')]//following::div[@class='main-series-information--field-value'])[1]")).getText();
		                                                   
		if (actual.contains(expected)) {
			login.Log4j.info(arg1 + " of the series has been verified successfully");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
		} else {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			Assert.fail("Verification failed");
		}
	}
	
	
	
	
	
	
	
	
	
	

	@And("^Click on releases tab$")
	public void click_on_releases_tab() throws Throwable {
		CommonFunctionality.webDriverwait_keyvalue("with_Release");
		WebElement release = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("with_Release")));
		new Actions(login.driver).moveToElement(release).click().build().perform();
	}

	@And("^Click on update request link$")
	public void click_on_update_request_link() throws Throwable {
		login.driver.findElement(By.xpath("//div[contains(text(),'Ask question')]")).click();
	}

	@And("^Enter some text in the update request popup opened$")
	public void Enter_some_text_in_the_update_request_popup_opened() throws Throwable {
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'sphere-modal__body')]//*[@class='form--group']//child::textarea")));
		login.driver.findElement(By.xpath("//*[contains(@class,'sphere-modal__body')]//*[@class='form--group']//child::textarea")).sendKeys("CEIC DATA");
		CommonFunctionality.wait(1000);
		WebElement submit = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Submit_button_in_update")));
		if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Submit_button_in_update"))).size()==1)
		{
			submit.click();
		
		//WebElement submit = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Submit_button_in_update")));
		//if (submit.isEnabled()) {
			//submit.click();
			System.out.println("Submit button is enabled");
			thanks_message = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'growl-message')]//*[@class='growl-message-text']", 4).getText();
			CommonFunctionality.wait(6000);
			new Actions(login.driver).moveToElement(login.driver.findElement(By.className("movable-modal--close"))).click().build().perform();
			login.Log4j.info("Question submitted and model box closed");
		} else {
			new Actions(login.driver).moveToElement(login.driver.findElement(By.className("movable-modal--close"))).click().build().perform();
			Assert.fail("Submit button not enabled, hence verification failed");
		}
		CommonFunctionality.DeleteSeries();
	}

	@And("^Click on chart tab$")
	public void click_on_chart_tab() throws Throwable {
		login.driver.findElement(By.xpath("//*[@class='tabs__tabs-box']//*[text()='Chart']")).click();
		CommonFunctionality.wait(500);
	}

	@And("^Enter from and to dates$")
	public void enter_from_and_to_dates() throws Throwable {
		CommonFunctionality.wait(3000);
		in_Chart_tab_click_on_timeframe_date_field_and_change_date();
	}

	@And("^In Chart tab click on timeframe date field and change date$")
	public void in_Chart_tab_click_on_timeframe_date_field_and_change_date() throws Throwable {
		if(login.driver.findElements(By.xpath("//*[@class='tabs__tabs-box']//*[text()='Chart']")).size()>0) {
		login.driver.findElement(By.xpath("//*[@class='tabs__tabs-box']//*[text()='Chart']")).click();
		}
		CommonFunctionality.wait(500);
		//login.driver.findElement(By.xpath("//*[@class='dropdown--button public-js-views-insight_visuals-chart-parts-range_controls-picker-date_picker_dropdown-module__date_picker_header']")).click();
		login.driver.findElement(By.xpath("//div[@class='dropdown--button EDzxdNZQTfFpBn0qqmR7']")).click();		
		WebElement from_date = login.driver.findElement(By.xpath("//input[@placeholder='From']"));
		from_date.click();
		from_date.clear();
		from_date.sendKeys("2010");
		from_date.sendKeys(Keys.ENTER);
		CommonFunctionality.wait(2000);
		datefrom = login.driver.findElement(By.xpath("//*[@class='highcharts-axis-labels highcharts-xaxis-labels']")).getText();
		System.out.println("Chart values are updated based on " + datefrom + " as start date");
		CommonFunctionality.wait(500);
		
		
		
		login.driver.findElement(By.xpath("//span[text()='No end date']")).click();
		CommonFunctionality.wait(500);
		
		WebElement to_date = login.driver.findElement(By.xpath("//input[@placeholder='To']"));
		
		to_date.click();
		to_date.clear();
		to_date.sendKeys("2012");
		to_date.sendKeys(Keys.ENTER);
		CommonFunctionality.wait(2000);
		dateto = login.driver.findElement(By.xpath("//*[@class='highcharts-axis-labels highcharts-xaxis-labels']")).getText();
		System.out.println("Chart values are updated based on " + dateto + " as end date");
		CommonFunctionality.wait(500);
	}

	@And("^Select \"([^\"]*)\" tab$")
	public void select_tab(String arg1) throws Throwable {
		CommonFunctionality.wait(4000);
		/*if (arg1.equalsIgnoreCase("views")) {
			login.driver.findElement(By.xpath("//*[@data-tab='views']")).click();
		} else {
			String tab = arg1.toLowerCase();
			try {
				login.driver
				.findElement(By.xpath(
						"//*[@data-tab='" + tab + "']"))
				.click();
			} catch (org.openqa.selenium.StaleElementReferenceException ex) {
				
				login.driver
						.findElement(By.xpath(
								"//*[@data-tab='" + tab + "']"))
						.click();
			}
		}
		CommonFunctionality.wait(3000);*/
		//code removed
		login.driver.findElement(By.xpath("//*[text()='"+ arg1 +"'] | //*[@data-tab='" + arg1 + "']")).click();
		
		
	}

	@And("^Select \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" tabs$")
	public void select_tabs(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
		CommonFunctionality.wait(3000);
		login.driver.findElement(By.xpath("//*[@class='zoom-button button button__sm']//*[contains(text(),'"+arg1+"')]")).click();
		CommonFunctionality.wait(3000);
		String ytd_start = login.driver.findElement(By.xpath("//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[1]")).getText();
		String ytd_end = login.driver
				.findElement(By.xpath("//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[1]")).getText();
		start_ytd = ytd_start.substring(4);
		end_ytd = ytd_end.substring(4);
		start_ytd = ytd_start.substring(6, 10);
		end_ytd = ytd_end.substring(6, 10);
		
		
		
		login.driver.findElement(By.xpath("//*[@class='zoom-button button button__sm']//*[contains(text(),'"+arg2+"')]"))
				.click();
		CommonFunctionality.wait(5000);
		String y1_start = login.driver
				.findElement(By.xpath("//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[2]")).getText();
		String y1_end = login.driver
				.findElement(By.xpath("//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[1]")).getText();
		start_1y = y1_start.substring(6, 10);
		end_1y = y1_end.substring(6, 10);
		login.driver.findElement(By.xpath("//*[@class='zoom-button button button__sm']//*[contains(text(),'"+arg3+"')]"))
				.click();
		CommonFunctionality.wait(5000);
		String y3_start = login.driver
				.findElement(By.xpath("//*[contains(@class,'highcharts-xaxis-labels')]/*[2]")).getText();
		String y3_end = login.driver
				.findElement(By.xpath("//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[1]")).getText();
		start_3y = y3_start.substring(6, 10);
		end_3y = y3_end.substring(6, 10);
		login.driver.findElement(By.xpath("//*[@class='zoom-button button button__sm']//*[contains(text(),'"+arg4+"')]"))
				.click();
		CommonFunctionality.wait(5000);
		String y5_start = login.driver
				.findElement(By.xpath("//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[2]")).getText();
		String y5_end = login.driver
				.findElement(By.xpath("//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[1]")).getText();
		start_5y = y5_start.substring(6, 10);
		end_5y = y5_end.substring(6, 10);
		login.driver.findElement(By.xpath("//*[@class='zoom-button button button__sm']//*[contains(text(),'"+arg5+"')]"))
				.click();
		CommonFunctionality.wait(5000);
		String All_start = login.driver
				.findElement(By.xpath("//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[2]")).getText();
		String All_end = login.driver
				.findElement(By.xpath("//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[1]")).getText();
		start_All = new SimpleDateFormat("dd/mm/yyyy").parse(All_start);
		end_All = new SimpleDateFormat("dd/mm/yyyy").parse(All_end);
	}

	@Then("^Last (\\d+) year data to be plotted in chart visual$")
	public void last_year_data_to_be_plotted_in_chart_visual(int arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		String from = login.driver
				.findElement(By.xpath("//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[2]")).getText();
		String to = login.driver
				.findElement(By.xpath("//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[1]")).getText();
		String A = from.substring(6, 10);
		String B = to.substring(6, 10);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
		CommonFunctionality.DeleteSeries();
		int C = Integer.parseInt(A);
		int D = Integer.parseInt(B);
		if (Math.abs(D - C) == arg1) {
			login.Log4j.info("Last " + arg1 + " year data is plotted in chart visual");
			} else {
			Assert.fail("Verification failed");
		}
	}

	@Then("^Last (\\d+) year, (\\d+) year, (\\d+) year, \"([^\"]*)\" data to be plotted in chart visual$")
	public void last_year_year_year_data_to_be_plotted_in_chart_visual(int arg1, int arg2, int arg3, String arg4) throws Throwable {
		CommonFunctionality.wait(2000);
		if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Close"))). size() > 0) {
		  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click(); 
		  CommonFunctionality.DeleteSeries();
		 }
		int A = Integer.parseInt(start_ytd);
		int B = Integer.parseInt(end_ytd);
		if ((B == A) || (B < A)) {
			System.out.println("Chart has been verified with YTD data");
		} else {
			Assert.fail("Verification Failed");
		}
		int C = Integer.parseInt(start_1y);
		int D = Integer.parseInt(end_1y);
		if (Math.abs(D - C) == arg1) {
			System.out.println("Chart has been verified with " + arg1 + " year data");
		} else {
			Assert.fail("Verification Failed");
		}
		int E = Integer.parseInt(start_3y);
		int F = Integer.parseInt(end_3y);
		if (Math.abs(F - E) == arg2) {
			System.out.println("Chart has been verified with " + arg2 + " year data");
		} else {
			Assert.fail("Verification Failed");
		}
		int G = Integer.parseInt(start_5y);
		int H = Integer.parseInt(end_5y);
		if (Math.abs(H - G) == arg3) {
			System.out.println("Chart has been verified with " + arg3 + " year data");
		} else {
			Assert.fail("Verification Failed");
		}
		if (!(start_All.equals(end_All))) {
			System.out.println("Chart has been verified with " + arg4 + " data");
		} else {
			Assert.fail("Verification Failed");
		}
		//CommonFunctionality.Views_list();
	}

	@Then("^Recently updated timepoints within (\\d+) days should highlight in blue color$")
	public void recently_updated_timepoints_within_days_should_highlight_in_blue_color(int arg1) throws Throwable {
		CommonFunctionality.wait(5000);
		try {
			
			
			login.driver.findElement(By.xpath("(//*[@class='preview-series-data']//*[@class='tabs__tab-item'])[1]")).click();
			
			
			String text_color = login.driver.findElement(By.xpath("(//*[@class='preview-series-time-points--point-value'])[1]")).getCssValue("color");
			String actual = Color.fromString(text_color).asHex();
			System.out.println("Recently update timepoints:" + actual);
			// verify with Actual value with Expected value
			String excepted = "#3498db";
			System.out.println("Recently timepoints:" + excepted);
			Assert.assertEquals(excepted, actual);
			login.driver.findElement(By.xpath("//*[@class='movable-modal--close']")).click();
			
			
			
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			
			
			
login.driver.findElement(By.xpath("(//*[@class='preview-series-data']//*[@class='tabs__tab-item'])[1]")).click();
			
			
			String text_color = login.driver.findElement(By.xpath("(//*[@class='preview-series-time-points--point-value'])[1]")).getCssValue("color");
			String actual = Color.fromString(text_color).asHex();
			System.out.println("Recently update timepoints:" + actual);
			// verify with Actual value with Expected value
			String excepted = "#3498db";
			System.out.println("Recently timepoints:" + excepted);
			Assert.assertEquals(excepted, actual);
			login.driver.findElement(By.xpath("//*[@class='movable-modal--close']")).click();
			
			
		}
		
		
		
		//login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
		
		
		
		
		
			
			
	}
			
	/*		
			
			
		//	get the data from dataTab
			login.driver.findElement(By.xpath("(//*[@class='preview-series-time-points--point-value'])[1]")).getCssValue(add_to_recent_insight);
			
			
			
			
		List<WebElement> color = login.driver.findElements(By.xpath("//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden')]"));
		int len = color.size();
		WebElement blue = login.driver.findElement(By.xpath("//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden')]["+len+"]"));
			if (blue.getAttribute("fill").contains("#2B60D0")) {
				System.out.println("Recently updated timepoints within " + arg1 + " days is highlighting in blue color");
			} else {
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
				Assert.fail("Verification Failed");
			}
		} catch (StaleElementReferenceException e) {
			List<WebElement> color = login.driver.findElements(By.xpath("//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden')]"));
			int len = color.size();
			WebElement blue = login.driver.findElement(By.xpath("//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden')]["+len+"]"));
				if (blue.getAttribute("fill").contains("#2B60D0")) {
					System.out.println("Recently updated timepoints within " + arg1 + " days is highlighting in blue color");
				} else {
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
					Assert.fail("Verification Failed");
				}
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
	}
	*/

	@Then("^Forecast timepoints should be highlighted in orange color$")
	public void forecast_timepoints_should_be_highlighted_in_orange_color() throws Throwable {
		CommonFunctionality.wait(3000);
		
		
		try {
			
			login.driver.findElement(By.xpath("(//*[@class='preview-series-data']//*[@class='tabs__tab-item'])[1]")).click();
			
		String text_color = login.driver
				.findElement(By.xpath("(//*[@class='preview-series-time-points--point-value'])[1]"))
				.getCssValue("color");
		String actual = Color.fromString(text_color).asHex();
		System.out.println("forecast timepoints:" + actual);
		// verify with Actual value with Expected value
		String excepted = "#f39c12";
		System.out.println("forecast timepoints:" + excepted);
		Assert.assertEquals(excepted, actual);
		login.driver.findElement(By.xpath("//*[@class='movable-modal--close']")).click();
		}
		
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			login.driver.findElement(By.xpath("(//*[@class='preview-series-data']//*[@class='tabs__tab-item'])[1]")).click();
			String text_color = login.driver
					.findElement(By.xpath("(//*[@class='preview-series-time-points--point-value'])[1]"))
					.getCssValue("color");
			String actual = Color.fromString(text_color).asHex();
			System.out.println("forecast timepoints:" + actual);
			// verify with Actual value with Expected value
			String excepted = "#ffa500";
			System.out.println("forecast timepoints:" + excepted);
			Assert.assertEquals(excepted, actual);
			login.driver.findElement(By.xpath("//*[@class='movable-modal--close']")).click();
		}
		
		
		
		
		
		
		
		
		
		
	}
		
		
		
		
		
		
		/*
		
		try {
		List<WebElement> color = login.driver.findElements(By.xpath("//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden')]"));
		int len = color.size();
		int len2 = color.size()-1;
		WebElement orange = login.driver.findElement(By.xpath("//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden')]["+len+"]"));
		WebElement orange2 = login.driver.findElement(By.xpath("//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden')]["+len2+"]"));
		if(orange.getAttribute("fill").contains("#FFA500")) {
				System.out.println("Forecast timepoints is highlighting in orange color");
			} else {
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
				Assert.fail("Verification Failed");
			}
		if(orange2.getAttribute("fill").contains("#FFA500")) {
			System.out.println("Forecast timepoints is highlighting in orange color");
		} else {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			Assert.fail("Verification Failed");
		}
		} catch (StaleElementReferenceException e) {
			List<WebElement> color = login.driver.findElements(By.xpath("//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden')]"));
			int len = color.size();
			int len2 = color.size()-1;
			WebElement orange = login.driver.findElement(By.xpath("//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden')]["+len+"]"));
			WebElement orange2 = login.driver.findElement(By.xpath("//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden')]["+len2+"]"));
			if(orange.getAttribute("fill").contains("#FFA500")) {
					System.out.println("Forecast timepoints is highlighting in orange color");
				} else {
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
					Assert.fail("Verification Failed");
				}
			if(orange2.getAttribute("fill").contains("#FFA500")) {
				System.out.println("Forecast timepoints is highlighting in orange color");
			} else {
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
				Assert.fail("Verification Failed");
			}
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
	}
*/
	@Then("^Should have lst (\\d+) obs$")
	public void should_have_lst_obs(int arg1) throws Throwable {
		CommonFunctionality.wait(3000);
		List<WebElement> obs = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("timeframe_observation")));
		if (obs.size() == 24) {
			login.Log4j.info("The series have " + arg1 + " observations and it has been verified");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			CommonFunctionality.DeleteSeries();
		} else {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			CommonFunctionality.DeleteSeries();
			Assert.fail("Verification failed");
		}
	}

	@Then("^Complete data for the series has to be plotted in chart visual$")
	public void complete_data_for_the_series_has_to_be_plotted_in_chart_visual() throws Throwable {
		String from = login.driver
				.findElement(By.xpath("//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[2]")).getText();
		String to = login.driver
				.findElement(By.xpath("//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[1]")).getText();
		String A = from.substring(6, 10);
		String B = to.substring(6, 10);
		if (!(B.equals(A))) {
			login.Log4j.info("Complete data for the series has to be plotted in chart visual");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			CommonFunctionality.DeleteSeries();
		} else {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			CommonFunctionality.DeleteSeries();
			Assert.fail("Verification failed");
		}
	}

	@Then("^Should display chart for timepoints within that timeframe range$")
	public void should_display_chart_for_timepoints_within_that_timeframe_range() throws Throwable {
		String start = login.driver
				.findElement(By.xpath("//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[1]")).getText();
		if (start.contains(datefrom)) {
			System.out.println("Start date has been verified successfully");
			CommonFunctionality.wait(500);
		} else {
			Assert.fail("Verification failed");
		}
		String end = login.driver
				.findElement(By.xpath("//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[5]")).getText();
		if (end.contains(dateto)) {
			System.out.println("End date has been verified successfully");
			if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Close"))).size()>0) {
			CommonFunctionality.Hidden_Webelements_handling(login.driver, "className", "movable-modal--close");
			}
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_tab"))).click();
			CommonFunctionality.DeleteSeries();
			if(login.driver.findElements(By.xpath("//*[text()='Delete series']")).size()>0) {
				login.driver.findElement(By.xpath("//*[text()='Ok']")).click();
			}
		} else {
			if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Close"))).size()>0) {
				CommonFunctionality.Hidden_Webelements_handling(login.driver, "className", "movable-modal--close");
			}
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_tab"))).click();
			CommonFunctionality.DeleteSeries();
			if(login.driver.findElements(By.xpath("//*[text()='Delete series']")).size()>0) {
				login.driver.findElement(By.xpath("//*[text()='Ok']")).click();
			}
			Assert.fail("Verification failed");
		}
	}
	
	@And("^Close the replacement popup if appeared$")
	public void close_the_replacement_popup_if_appeared() throws Throwable {
		if(login.driver.findElements(By.xpath("//*[contains(@class,'movable-modal--title')]//*[text()='Latest changes in your Insight']")).size()>0) {
			boolean check = login.driver.findElement(By.xpath("//*[text()='Do not show again']/preceding-sibling::input")).isSelected();
			if (check == false) {
				new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[text()='Do not show again']/preceding-sibling::span", 4)).click().build().perform();
			    }
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'button__secondary_purple') and text()='Dismiss']", 4).click();
		}
	}

	@Then("^chart visual should update for the dates entered$")
	public void chart_visual_should_update_for_the_dates_entered() throws Throwable {
		should_display_chart_for_timepoints_within_that_timeframe_range();
	}

	@And("^Still can not find an answer window opens now enter question and click on submit$")
	public void Still_cannot_find_an_answer_window_opens_now_enter_question_and_click_on_submit() throws Throwable {
		Enter_some_text_in_the_update_request_popup_opened();
	}

	@Then("^Verify the Thank you message$")
	public void verify_the_Thank_you_message() throws Throwable {
		String arg2 = "Thank you for submitting a question to us.";
		String expected = arg2;
		if (thanks_message.contains(expected)) {
			login.Log4j.info("Users can able to send questions and Message has been verified successfully");
			CommonFunctionality.wait(500);
		} else {
			Assert.fail("Verification failed");
		}
		// CommonFunctionality.DeleteSeries();
	}

	@And("^Click on the mnemonic hyperlink$")
	public void click_on_mnemonic_hyperlink() throws Throwable {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@class='main-series-information--series-id']//div//span")));
		mnemonic_code_id = login.driver
				.findElement(By.xpath("//*[@class='main-series-information--series-id']//div//span")).getText();
		System.out.println(mnemonic_code_id);
		login.driver.findElement(By.xpath("//*[@class='main-series-information--series-id']//div//span")).click();
		Thread.sleep(1000);
		
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
	}

	@Then("^Verify the Series id should be \"([^\"]*)\"$")
	public void verify_the_Series_id_should_be(String arg1) throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@class='main-series-information--right']//*[@class='main-series-information--series-id']/div[1]")));
		String id = login.driver.findElement(By.xpath(
				"//*[@class='main-series-information--right']//*[@class='main-series-information--series-id']/div[1]"))
				.getText();
		if (id.contains(arg1)) {
			login.Log4j.info(arg1 + " is the series id and it has been verified successfully");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			CommonFunctionality.DeleteSeries();
		} else {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			CommonFunctionality.DeleteSeries();
			Assert.fail("Verification failed");
		}
	}

	@Then("^SR code has to be \"([^\"]*)\"$")
	public void sr_code_has_to_be(String arg1) throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@class='main-series-information--right']//*[@class='main-series-information--series-id']/div[2]")));
		String SR = login.driver.findElement(By.xpath(
				"//*[@class='main-series-information--right']//*[@class='main-series-information--series-id']/div[2]"))
				.getText();
		if (SR.contains(arg1)) {
			login.Log4j.info(arg1 + " is the SR code and it has been verified successfully");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			CommonFunctionality.wait(3000);
			CommonFunctionality.DeleteSeries();
		} else {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			CommonFunctionality.wait(3000);
			CommonFunctionality.DeleteSeries();
			Assert.fail("Verification failed");
		}
	}

	@Then("^Mnemonic code should be \"([^\"]*)\"$")
	public void mnemonic_code_should_be(String arg1) throws Throwable {
		String Mnemonic = login.driver
				.findElement(By.xpath("//*[@class='main-series-information--series-id']//div//span")).getText();
		if (Mnemonic.contains(arg1)) {
			login.Log4j.info(arg1 + " is the Mnemonic code and it has been verified successfully");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
		} else {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			Assert.fail("Verification failed");
		}
	}

	@Then("^Respective remarks of series should display$")
	public void respective_remarks_of_series_should_display() throws Throwable {
		CommonFunctionality.wait(1000);
		String original = "Remarks:";
		String remarks = login.driver.findElement(By.xpath("//*[normalize-space(text())='Remarks:']")).getText();
		System.out.println("========Remarks========="+remarks);
		//String values = login.driver.findElement(By.xpath("//*[@class='main-series-information--remark-item'][2]")).getText();
		//String values1 = login.driver.findElement(By.xpath("//*[@class='main-series-information--remark-item'][3]")).getText();
		if (remarks.contains(original)) {
			//System.out.println(values + "\r" + values1);
			login.Log4j.info("Respective remarks of series is displaying and it has been verified");
			CommonFunctionality.wait(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			CommonFunctionality.DeleteSeries();
		} else {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			CommonFunctionality.DeleteSeries();
			Assert.fail("Verification Failed");
		}
	}

	@SuppressWarnings("deprecation")
	@Then("^Navigate to search result of same series in series pane$")
	public void navigate_to_search_result_of_same_series_in_series_pane() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement first_series = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("One_series_from_seriesList")));
		
		new Actions(login.driver).moveToElement(first_series).pause(2000).build().perform();
		String mnemonic_text = login.driver.findElement(By.xpath("//*[contains(text(),'Mnemonic')]/following-sibling::*")).getText();
		if (mnemonic_text.contains(mnemonic_code_id)) {
			login.Log4j.info(mnemonic_text
					+ " is the Mnemonic code and on clicking its navigated to the search result of series panal of same series");
		} else {
			Assert.fail("Verification failed");
		}
	}

	@And("^clicking indicator drop down$")
	public void clicking_indicator_drop_down() throws Throwable {
		CommonFunctionality.webDriverwait_keyvalue("indicator_dropdown");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("indicator_dropdown"))).click();
		CommonFunctionality.wait(500);
	}

	@And("^Click on \"([^\"]*)\" name$")
	public void click_on_name(String arg1) throws Throwable {
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='main-series-information--field-name'])[4]//following::span[2]")));
		//login.driver.findElement(By.xpath("(//div[@class='main-series-information--field-name'])[4]//following::span[2]")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='main-series-information--field-name'])[4]//following::div[@class='main-series-information--field-value main-series-information--link']")));
		login.driver.findElement(By.xpath("(//div[@class='main-series-information--field-name'])[4]//following::div[@class='main-series-information--field-value main-series-information--link']")).click();
		
		
		
		
		CommonFunctionality.wait(500);
	}

	@And("^Click on \"([^\"]*)\" button$")
	public void click_on_button(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		if(arg1.equalsIgnoreCase("Preview")) {
		CommonFunctionality.webDriverwait_locator(
				"//*[contains(@title,'" + arg1 + "') and @class='series-with-suggestions-preview--open-visual']",
				"xpath");
		WebElement preview = login.driver.findElement(By.xpath(
				"//*[contains(@title,'" + arg1 + "') and @class='series-with-suggestions-preview--open-visual']"));
		new Actions(login.driver).moveToElement(preview).click(preview).build().perform();
		//new Actions(login.driver).moveToElement(preview).click(preview).build().perform();
		} else if(arg1.equalsIgnoreCase("Search")) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='modal-window modal-window__active']//*[contains(text(),'" + arg1 + "')]", 10).click();
		} else if(arg1.equalsIgnoreCase("Cancel")) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Close']", 10).click();
		} else if(arg1.equalsIgnoreCase("Save")) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'movable-modal__active')]//*[contains(text(),'" + arg1 + "')]", 10).click();
		} else if(arg1.equalsIgnoreCase("Next") || arg1.equalsIgnoreCase("Previous")) {
			CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'" + arg1 + "')]", 10).click();
		} else if(arg1.equalsIgnoreCase("Apply")) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 10).click();
			
		} else if(arg1.equalsIgnoreCase("Download")) {
			CommonFunctionality.getElementByXpath(login.driver, "//button//*[contains(text(),'" + arg1 + "')]", 10).click();
		}
	}

	@And("^click on \"([^\"]*)\" link in SSP window$")
	public void click_on_link_in_SSP_window(String arg1) throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@class='main-series-information--link' and contains(text(),'" + arg1 + "')]")));
		login.driver
				.findElement(
						By.xpath("//*[@class='main-series-information--link' and contains(text(),'" + arg1 + "')]"))
				.click();
		CommonFunctionality.wait(500);
	}

	@And("^Click on Ask Question link in SSP window$")
	public void click_on_Ask_Question_link_in_SSP_window() throws Throwable {
		CommonFunctionality.wait(1000);
		login.driver.findElement(By.xpath("//*[contains(text(),'Ask question')]")).click();
	}

	@And("^Click on \"([^\"]*)\" tab$")
	public void click_on_tab(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Related Insights")) {
			CommonFunctionality.wait(5000);
			login.driver
					.findElement(By.xpath("//*[contains(@class,'operations--related') and @js-related-insights=\"\"]"))
					.click();
		} else {
			login.driver
					.findElement(By.xpath("//*[@class='tabs__tabs-box']//*[contains(text(),'" + arg1
							+ "')] | //*[contains(@class,'operations--related') and @js-related-datasets=\"\"]"))
					.click();
		}
	}

	@And("^Click on replacement series name hyperlink$")
	public void click_on_replacement_series_name_hyperlink() throws Throwable {
		CommonFunctionality.webDriverwait_keyvalue("Replacement_suggestion");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Replacement_suggestion"))).click();
		CommonFunctionality.wait(1000);
	}

	@And("^Click on replacement series name dropdown$")
	public void click_on_replacement_series_name_dropdown() throws Throwable {
		CommonFunctionality.webDriverwait_keyvalue("Replacement_suggestion_dropdown");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Replacement_suggestion_dropdown"))).click();
		CommonFunctionality.wait(1000);
	}

	@And("^Check contents$")
	public void check_contents() throws Throwable {
		CommonFunctionality.wait(1000);
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("statistics_contents"))).isDisplayed())
			;
		{
			System.out.println("Statistics tab contents are displaying");
		}
	}

	@And("^Check contents inside Related data$")
	public void check_contents_inside_Related_data() throws Throwable {
		CommonFunctionality.wait(1000);
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("related_data_contents"))).isDisplayed())
			;
		{
			System.out.println("Related data contents are displaying for selected series");
		}
	}

	@And("^Check contents inside Related insight$")
	public void check_contents_inside_Related_insight() throws Throwable {
		if (login.driver.findElement(By.className("insights-view--table")).isDisplayed()) {
			System.out.println("Related Insights are displaying for selected series");
		}
	}

	@And("^Observe full data display$")
	public void observe_full_data_display() throws Throwable {
		CommonFunctionality.webDriverwait_locator("series-changes-time-line--observations-count", "className");
		String list = login.driver.findElement(By.className("series-changes-time-line--observations-count")).getText();
		if (list.contains("obs")) {
			System.out.println("Data has been displayed inside data tab and the total observations are " + list);
		}
		obs_date = login.driver.findElement(By.className("series-changes-time-line--observations-dates")).getText();
	}

	@And("^Close the filter button$")
	public void close_the_filter_button() throws Throwable {
		cv.resetting_the_filters();
		CommonFunctionality.wait(1000);
	}

	@SuppressWarnings("deprecation")
	@And("^Select the series checkbox from myseries$")
	public void select_the_series_checkbox_from_myseries() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement selection = login.driver
				.findElement(By.xpath("//div[@class='check-all-series']//span[@class='input-control--indicator']"));
		new Actions(login.driver).moveToElement(selection).pause(3000).click().build().perform();
		CommonFunctionality.wait(2000);
	}

	@And("^Apply a function on any series in my series$")
	public void apply_a_function_on_any_series_in_my_series() throws Throwable {
		CommonFunctionality.wait(3000);
		
		try {
		
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='functions-input-container']//following-sibling::*[@class='current-function-input--field']",
				4).click();
		CommonFunctionality.wait(200);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Functions_auto_suggestion"))).click();
		CommonFunctionality.wait(200);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Functions_auto_suggestion"))).click();
		CommonFunctionality.wait(200);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Functions_auto_suggestion"))).click();
		CommonFunctionality.wait(200);
		WebElement apply = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Functions_apply")));
		jse.executeScript("arguments[0].click();", apply);
		
		//String a = login.driver.findElement(By.xpath("//*[@class='series-name-field--series-name']")).getText();
		//System.out.println(a);
		 b = login.driver.findElement(By.xpath("//*[@class='series-functions-title']")).getText();
		System.out.println("b value print"+b);
		
		
		//function_name="("+a+""+b+")";
		//System.out.println(function_name);
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='functions-input-container']//following-sibling::*[@class='current-function-input--field']",
					4).click();
			CommonFunctionality.wait(200);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Functions_auto_suggestion"))).click();
			CommonFunctionality.wait(200);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Functions_auto_suggestion"))).click();
			CommonFunctionality.wait(200);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Functions_auto_suggestion"))).click();
			CommonFunctionality.wait(200);
			WebElement apply = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Functions_apply")));
			jse.executeScript("arguments[0].click();", apply);
			
			//String a = login.driver.findElement(By.xpath("//*[@class='series-name-field--series-name']")).getText();
			//System.out.println(a);
			 b = login.driver.findElement(By.xpath("//*[@class='series-functions-title']")).getText();
			System.out.println("b value print"+b);
			
			//function_name="("+a+""+b+")";
			//System.out.println(function_name);
		}
		
		//String a = login.driver.findElement(By.className("series-function-item--name")).getText();
		//String c = login.driver.findElement(By.xpath("//*[@class='function-argument-item'][1]")).getText();
		//String d = login.driver.findElement(By.xpath("//*[@class='function-argument-item'][2]")).getText();
		//function_name = a + "(" + c + "; " + d + ")";
	}

	@Then("^Drop down should display indicators list and clicking on specific indicators should navigate to results page$")
	public void drop_down_should_display_indicators_list_and_clicking_on_specific_indicators_should_navigate_to_results_page()
			throws Throwable {
		List<WebElement> dropdown_list = login.driver.findElements(By.xpath("//*[@class='series-related-filters']"));
		for (int i = 0; i < dropdown_list.size(); i++) {
			String values = dropdown_list.get(i).getText();
			System.out.println("Indicators list are : \n" + values);
			indicator_value = dropdown_list.get(0).getText();
			dropdown_list.get(0).click();
		}
		CommonFunctionality.wait(500);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
		CommonFunctionality.wait(1500);
		if (!(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Close"))).size() > 0)) {
			login.Log4j.info("Indicator values are selected and it successfully navigating to results page");
			CommonFunctionality.DeleteSeries();
		} else {
			CommonFunctionality.DeleteSeries();
			Assert.fail("Verification failed");
		}
	}

	@SuppressWarnings("deprecation")
	@Then("^Selecting indicator from indicator drop down should show search result in left for same indicator$")
	public void selecting_indicator_from_indicator_dropdown_should_show_search_result_in_left_for_same_indicator()
			throws Throwable {
		List<WebElement> dropdown_list = login.driver.findElements(By.xpath("//*[@class='series-related-filters']"));
		for (int i = 0; i < dropdown_list.size(); i++) {
			String values = dropdown_list.get(i).getText();
			System.out.println("Indicators list are : \n" + values);
			indicator_value = dropdown_list.get(0).getText();
			dropdown_list.get(0).click();
		}
		CommonFunctionality.wait(500);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
		CommonFunctionality.wait(1500);
		WebElement first_series = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("One_series_from_seriesList")));
		new Actions(login.driver).moveToElement(first_series).pause(2000).build().perform();
		String expected = login.driver.findElement(By.xpath("//*[contains(text(),'Indicator')]/following-sibling::*"))
				.getText();
		if (indicator_value.contains(expected)) {
			login.Log4j
					.info(expected + " indicator is selected and it successfully navigating to search result in left");
			CommonFunctionality.DeleteSeries();
		} else {
			CommonFunctionality.DeleteSeries();
			Assert.fail("Verification failed");
		}
	}

	@SuppressWarnings("deprecation")
	@Then("^It should apply source filter in search pane to display it's result$")
	public void it_should_apply_source_filter_in_search_pane_to_display_it_s_result() throws Throwable {
		CommonFunctionality.wait(2000);
		String actual = login.driver.findElement(By.xpath("((//div[@class='main-series-information--field-name'])[4]//following::div)[1]")).getText();
		System.out.println("===Printact==="+actual);
		CommonFunctionality.wait(500);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
		CommonFunctionality.wait(500);
		WebElement first_series = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("One_series_from_seriesList")));
		new Actions(login.driver).moveToElement(first_series).pause(2000).build().perform();
		
		//String expected = login.driver.findElement(By.xpath("//*[contains(text(),'Source')]/following-sibling::*")).getText();
		
		//String expected = login.driver.findElement(By.xpath("(//*[contains(text(),'Source:')]//following::div[@class='main-series-information--field-value main-series-information--link'])")).getText();
		
		Thread.sleep(2000);
		String expected = login.driver.findElement(By.xpath("(//*[contains(text(),'Source')]//following::div)[1]")).getText();
		
		
		System.out.println(expected);
		System.out.println(actual);
		
		Assert.assertEquals(expected, actual);
		login.Log4j.info("The title consists of "+actual+" and it displayed as source filter in search pane as one of the result");
		CommonFunctionality.DeleteSeries();
		}

	@Then("^Footnotes window should be displayed with related details$")
	public void footnotes_window_should_be_displayed_with_related_details() throws Throwable {
		
		Thread.sleep(5000);
		//CommonFunctionality.webDriverwait_keyvalue("footnotes_title_text");
		
		
		if(login.driver.findElements(By.xpath("//div[@class='footnotes-bread-crumbs']")).size()==1)	
		{
			System.out.println("Footnotes window should be displayed");
		}
		
		else {
			Assert.fail();
		}
		
		
		
		
		
		
		
	/*	String a = login.driver.findElement(By.xpath("//div[contains(text(),'Footnotes')]")).getText();
		String b = "Footnotes";
		if (a.contains(b)) {
			Thread.sleep(5000);
			login.driver.findElement(By.xpath("//*[@class='footnotes-modal']/following::*[@title='Close']")).click();
		}
		else {
			Assert.fail();
		}
		*/
		
		
	/*	String a = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("footnotes_title_text"))).getText();
		String b = "Footnotes";
		String c = login.driver.findElement(By.xpath("//*[@class='footnotes-modal--name']/*")).getText();
		String d = login.driver.findElement(By.className("series-preview-modal-header--link")).getText();
		
		if (a.contains(b)) {
			login.driver.findElement(By.xpath("//*[@class='footnotes-modal']/following::*[@title='Close']")).click();
		}
		if (c.contains(d)) {
			login.Log4j.info("Footnotes window is displayed with related details and it has been verified");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			CommonFunctionality.DeleteSeries();
		} else {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			CommonFunctionality.DeleteSeries();
			Assert.fail("Verification failed");
		}*/
	}

	@Then("^Should open still can not find an answer window$")
	public void should_open_still_can_not_find_an_answer_window() throws Throwable {
		
		//Enter_some_text_in_the_update_request_popup_opened();
		
		
		if(login.driver.findElements(By.xpath("//div[@class='modal-body sphere-modal__body']")).size()==1)
		{
			System.out.println("Answer window should be display");
		}
		
		
		
		
	}

	@Then("^Verify that user should be able to send question successfully$")
	public void verify_that_user_should_be_able_to_send_question_successfully() throws Throwable {
		verify_the_Thank_you_message();
	}

	@Then("^Should create a chart visual$")
	public void should_create_a_chart_visual() throws Throwable {
		if (login.driver.findElements(By.xpath("//*[@class='highcharts-container ']")).size() > 0) {
			login.Log4j.info("Chart visual is displaying and its verified");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			CommonFunctionality.DeleteSeries();
		} else {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			CommonFunctionality.DeleteSeries();
			Assert.fail("Failed to verify");
		}
	}

	@Then("^Complete observations must be displayed$")
	public void complete_observations_must_be_displayed() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("preview-series-time-points--point")));
		String obs1 = obs_date.substring(0, 7);
		String obs2 = obs_date.substring(10, 17);
		List<WebElement> data_list = login.driver.findElements(By.className("preview-series-time-points--point"));
		for (WebElement dates : data_list) {
			String date = dates.getText();
			if (date.contains(obs1)) {
				System.out.println("The observation date starts from the year: " + obs1);
			} else if (date.contains(obs2)) {
				System.out.println("The observation ends in the year: " + obs2);
			}
		}
		WebElement close = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close")));
		if (close.isDisplayed()) {
			close.click();
			login.Log4j.info("Complete observations on data tab are displaying and its verified");
			CommonFunctionality.wait(300);
			CommonFunctionality.DeleteSeries();
		} else {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close")));
			CommonFunctionality.DeleteSeries();
			Assert.fail("Verification failed");
		}
	}

	@Then("^Should have details on location,variability,shape$")
	public void should_have_details_on_location_variability_shape() throws Throwable {
		List<WebElement> statistics = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("statistics_info_block")));
		for (int i = 0; i < statistics.size(); i++) {
			String details = statistics.get(i).getText();
			if (details.contains("Min")) {
				System.out.println("Statistics tab consists of text " + details + " which represents Location block");
			} else if (details.contains("Variance")) {
				System.out.println("Statistics tab consists of text " + details + " which represents Visibility block");
			} else if (details.contains("Skewness")) {
				System.out.println("Statistics tab consists of text " + details + " which represents Shape block");
			}
		}
		WebElement close = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close")));
		if (close.isDisplayed()) {
			login.Log4j.info("Statistics tab have blocks: Location, Visibility and Shape");
			close.click();
			CommonFunctionality.wait(500);
			CommonFunctionality.DeleteSeries();
		} else {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close")));
			CommonFunctionality.DeleteSeries();
			Assert.fail("Verification failed");
		}
	}

	@Then("^Should display related keyword of that series and have \"([^\"]*)\" and \"([^\"]*)\" details$")
	public void should_display_related_keyword_of_that_series_and_have_and_details(String arg1, String arg2)
			throws Throwable {
		String title = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ssp_title"))).getText();
		List<WebElement> relate = login.driver.findElements(By.className("series-data-set--table-name"));
		for (WebElement ssp : relate) {
			String related = ssp.getText();
			if (!(related.contains(title))) {
				Assert.fail("Verification failed");
			}
		}
		login.Log4j.info("The Series is displaying related keyword of that series and having " + arg1 + " and " + arg2
				+ " details");
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		CommonFunctionality.DeleteSeries();
	}

	@Then("^Click on first link available under \"([^\"]*)\" and verify the changes$")
	public void click_on_first_link_available_under_and_verify_the_changes(String arg1) throws Throwable {
		if (login.driver
				.findElement(By
						.xpath("//*[contains(text(),'" + arg1 + "')]//following::*[@class='series-related-data-sets']"))
				.isDisplayed()) {
			List<WebElement> related = login.driver
					.findElements(By.xpath("(//*[@class='series-data-set--table-name'])[1]"));
			for (WebElement rel : related) {
				CommonFunctionality.wait(1000);
				String actual = login.driver.findElement(By.xpath("(//*[@class='series-data-set--table-name'])[1]"))
						.getText();
				rel.click();
				CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Minimize']", 4).click();
				String expected = login.driver.findElement(By.xpath("//*[@class='insight-discovery--popup-title']"))
						.getText();
				CommonFunctionality.getElementByClassName(login.driver, "insight-discovery--popup-back-button", 4)
						.click();
				if (!(expected.contains(actual))) {
					Assert.fail("Related Datasets verification Failed");
				}
			}
			login.Log4j.info("Clicked on first link available under Datasets and its verified");
			CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Maximize']", 4).click();
		}
	}

	@Then("^Click on second link available under \"([^\"]*)\" and verify the changes$")
	public void click_on_second_link_available_under_and_verify_the_changes(String arg1) throws Throwable {
		if (login.driver
				.findElement(By
						.xpath("//*[contains(text(),'" + arg1 + "')]//following::*[@class='series-related-data-sets']"))
				.isDisplayed()) {
			List<WebElement> related = login.driver
					.findElements(By.xpath("(//*[@class='series-data-set--table-name'])[2]"));
			for (WebElement rel : related) {
				CommonFunctionality.wait(1000);
				String actual = login.driver.findElement(By.xpath("(//*[@class='series-data-set--table-name'])[2]"))
						.getText();
				rel.click();
				CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Minimize']", 4).click();
				String expected = login.driver.findElement(By.xpath("//*[@class='insight-discovery--popup-title']"))
						.getText();
				CommonFunctionality.getElementByClassName(login.driver, "insight-discovery--popup-back-button", 4)
						.click();
				if (!(expected.contains(actual))) {
					Assert.fail("Related Datasets verification Failed");
				}
			}
			login.Log4j.info("Clicked on second link available under Datasets and its verified");
			CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Maximize']", 4).click();
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			CommonFunctionality.DeleteSeries();
		}
	}
	
	@And("^Check the data available under \"([^\"]*)\" and it should open respective insights$")
	public void check_the_data_available_under_and_it_should_open_respective_insights(String arg1) throws Throwable {
		if (login.driver.findElements(By.className("insights-view--table")).size() > 0) {
			System.out.println("Related Insights are displaying for selected series");
		}
	}

	@And("^Check the data of first insight$")
	public void check_the_data_of_first_insight() throws Throwable {
		List<WebElement> insights = login.driver
				.findElements(By.xpath("(//*[contains(@class,'insight-table-item--title-link')])[1]"));
		for (WebElement insight : insights) {
			String actual = insight.getText();
			insight.click();
			CommonFunctionality.wait(1000);
			/*if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal__content')]//*[text()='Continue']"))
					.size() > 0) {
				CommonFunctionality.getElementByXpath(login.driver,"//*[contains(@class,'sphere-modal__content')]//*[text()='Continue']", 4).click();
			}*/
			//CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			String expected = CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(@class,'insight-preview--title')]", 4)
					.getText();
			if (actual.equalsIgnoreCase(expected)) {
				login.Log4j.info("Clicked on first Insight and it is opening in respective insight");
			} else {
				CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
				CommonFunctionality.DeleteSeries();
				Assert.fail("Verification for Insights failed");
			}
			CommonFunctionality.getElementByClassName(login.driver, "insight-preview--close", 4).click();
		}
	}


	public void check_the_data_of_second_insight() throws Throwable {
		//CommonFunctionality.getElementByXpath(login.driver, "//*[@js-related-insights='']", 4).click();
		List<WebElement> insights = login.driver
				.findElements(By.xpath("(//*[contains(@class,'insight-table-item--title-link')])[2]"));
		for (WebElement insight : insights) {
			String actual = insight.getText();
			insight.click();
			CommonFunctionality.wait(1000);
			/*if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal__content')]//*[text()='Continue']"))
					.size() > 0) {
				CommonFunctionality.getElementByXpath(login.driver,"//*[contains(@class,'sphere-modal__content')]//*[text()='Continue']", 4).click();
			}*/
			//CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			String expected = CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(@class,'insight-preview--title')]", 4)
					.getText();
			if (actual.equalsIgnoreCase(expected)) {
				login.Log4j.info("Clicked on second Insight and it is opening in respective insight");
			} else {
				CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
				CommonFunctionality.DeleteSeries();
				Assert.fail("Verification for Insights failed");
			}
			CommonFunctionality.getElementByClassName(login.driver, "insight-preview--close", 4).click();
		}
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		if (login.driver.findElements(By.xpath("//*[@class='movable-modal--window']//*[text()='Do you want to keep your insight?']")) .size() > 0)
		{
		  CommonFunctionality.getElementByXpath(login.driver,"//*[@class='movable-modal--window']//*[text()='Start new']",4).click();
		}
		CommonFunctionality.DeleteSeries();
	}

	@SuppressWarnings("deprecation")
	@Then("^The discontinued series has to be replaced with suggested series into right$")
	public void the_discontinued_series_has_to_be_replaced_with_suggested_series_into_right() throws Throwable {
		CommonFunctionality.wait(9000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
		WebElement one_series = login.driver
				.findElement(By.xpath("//*[@class='series-name-wrapper ']//*[@class='series-name-field-title']"));
		new Actions(login.driver).moveToElement(one_series).pause(4000)
				.click(login.driver.findElement(By.xpath("//*[@class='series-name-wrapper ']//*[@class='series-name-field-title']"))).build()
				.perform();
		CommonFunctionality.wait(200);
		String replaced_text = login.driver.findElement(By.xpath(
				"//*[@class='main-series-information--right']//*[@class='main-series-information--series-id']/div[1]"))
				.getText();
		if (!(manage_series_id.equals(replaced_text))) {
			login.Log4j
					.info("Discontinued series has to be replaced with suggested series and its verified successfully");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			CommonFunctionality.wait(500);
			CommonFunctionality.DeleteSeries();
		} else {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			CommonFunctionality.DeleteSeries();
			Assert.fail("Verification Failed");
		}
	}

	@SuppressWarnings("deprecation")
	@Then("^Suggested series has to be added into right pane into the same insight$")
	public void suggested_series_has_to_be_added_into_right_pane_into_the_same_insight() throws Throwable {
		CommonFunctionality.wait(9000);
		close_the_replacement_popup_if_appeared();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
	/*	WebElement one_series = login.driver.findElement(By.xpath(
				"//*[@class='webix_column list-series-name webix_last']/div[2]/div/div/div/span[@class='series-name-field-title']/span"));
		new Actions(login.driver).moveToElement(one_series).pause(3000)
				.click(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("One_series_from_myserieslist")))).build()
				.perform();*/
		WebElement one_series = login.driver.findElement(By.xpath(
				"(//*[@class='series-name-field--text'])[2]"));
		new Actions(login.driver).moveToElement(one_series).pause(3000)
		.click(login.driver.findElement(By.xpath("//*[@class='series-name-wrapper ']//*[@class='series-name-field-title']"))).build()
		.perform();
		
		String suggested_series1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ssp_title")))
				.getText();
		if (suggested_series1.contains(suggested_series)) {
			login.Log4j.info(
					"Suggested series has to be added into right pane into the same insight and it has been verified successfully");
			CommonFunctionality.wait(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			CommonFunctionality.DeleteSeries();
		} else {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			CommonFunctionality.DeleteSeries();
			Assert.fail("Verification Failed");
		}
	}

	@Then("^Both inactive and suggestion should be viewed as chart$")
	public void both_inactive_and_suggestion_should_be_viewed_as_chart() throws Throwable {
		CommonFunctionality.wait(1000);
		List<WebElement> element = login.driver
				.findElements(By.xpath("//*[contains(@class,'legend-item')]//*[contains(@class,'series-edit--title')]"));
		if (element.size() > 1) {
			login.Log4j.info("Both inactive and suggestion should be viewed as chart and it has been verified");
			List<WebElement> closed = login.driver
					.findElements(By.xpath("//*[contains(text(),'Add related series')]//following::*[@title='Close']"));
			if (closed.size() > 0) {
				login.driver
						.findElement(
								By.xpath("//*[contains(text(),'Add related series')]//following::*[@title='Close']"))
						.click();
			}
			CommonFunctionality.wait(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			CommonFunctionality.DeleteSeries();
		} else {
			CommonFunctionality.wait(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			CommonFunctionality.DeleteSeries();
			Assert.fail("Verification Failed");
		}
	}

	@Then("^SSP for replacement series should open as a new popup$")
	public void ssp_for_replacement_series_should_open_as_a_new_popup() throws Throwable {
		List<WebElement> popup = login.driver.findElements(By.className("single-series-preview--body"));
		if (popup.size() > 1) {
			login.Log4j.info("SSP for replacement series opened as a new popup and it has been verified successfully");
			List<WebElement> close = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Close")));
			for (WebElement closing : close) {
				jse.executeScript("arguments[0].click();", closing);
			}
			CommonFunctionality.DeleteSeries();
		} else {
			Assert.fail("Verification Failed");
		}
	}

	@Then("^SSP should be opened for the series and series name should be suffixed with function name$")
	public void ssp_should_be_opened_for_the_series_and_series_name_should_be_suffixed_with_function_name()
			throws Throwable {
		CommonFunctionality.wait(1000);
		String function_title = login.driver.findElement(By.xpath("//*[@class='series-functions--modal-title-label']")).getText();
		System.out.println("function_title:"+function_title);
		System.out.println("b value:"+b);
		//String value = b.replaceAll("[\\[\\]\\(\\)]", "");
		
System.out.println("function_title========>:"+function_title);
//System.out.println("value B========>:"+b);
		
		if (function_title.contains(b)) {
			login.Log4j.info("SSP is opened for the series and series name is suffixed with function name");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			CommonFunctionality.wait(200);
			// login.driver.findElement(By.xpath("//*[contains(@title,'Delete')]")).click();
			CommonFunctionality.DeleteSeries();
		} else {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			CommonFunctionality.DeleteSeries();
			Assert.fail("Verification Failed");
		}
	}

	@Then("^Manage suggestions option is not present$")
	public void manage_suggestions_option_is_not_present() throws Throwable {
		CommonFunctionality.wait(1000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Manage_suggestions"))).size() == 0) {
			login.Log4j.info("Manage suggestions option is not displayed and it has been verified");
			CommonFunctionality.wait(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			CommonFunctionality.DeleteSeries();
		} else {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			CommonFunctionality.DeleteSeries();
			Assert.fail("Verification Failed");
		}
	}
}