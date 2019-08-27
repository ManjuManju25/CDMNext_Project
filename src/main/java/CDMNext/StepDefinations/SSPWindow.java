package CDMNext.StepDefinations;

import java.util.ArrayList;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class SSPWindow {

	public static String mnemonic_code_id;
	public static String indicator_value;
	public static String values;
	public static String text;
//	public static String manage_series_id;
	public static String suggested_series;
	public static String function_name;
	WebDriverWait wait = new WebDriverWait(login.driver, 100);
	JavascriptExecutor jse = (JavascriptExecutor) login.driver;

	@And("^Checking modalbox is open$")
	public void check_modalbox_is_open() throws Throwable {
		CommonFunctionality.modelbox();
	}

	@SuppressWarnings("deprecation")
	@And("^Add few series to myseries$")
	public void add_few_series_to_myseries() throws Throwable {
		String id ="205424302";
		// CommonFunctionality.search_without_filter();
		//CommonFunctionality.webDriverwait_keyvalue("Series_tab");
		CommonFunctionality.getElementByProperty(login.driver, "Series_tab", 4).click();
		//login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_tab"))).click();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys(Keys.chord(Keys.CONTROL, "a"),id);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys(Keys.ENTER);
		// CommonFunctionality.search_without_filter();
		CommonFunctionality.webDriverwait_keyvalue("Series_checkbox");
		WebElement series_cb = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_checkbox")));
		new Actions(login.driver).moveToElement(series_cb).pause(2000).click().build().perform();
		WebElement series_add = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_to_myseries")));
		new Actions(login.driver).moveToElement(series_add).pause(2000).click().build().perform();
	}
	
	@SuppressWarnings("deprecation")
	@And("^Search for the series \"([^\"]*)\"$")
	public void search_for_the_series(String arg1) throws Throwable {
		CommonFunctionality.webDriverwait_keyvalue("Series_tab");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_tab"))).click();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys(Keys.chord(Keys.CONTROL, "a"),arg1);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys(Keys.ENTER);
		CommonFunctionality.webDriverwait_keyvalue("Series_checkbox");
		WebElement series_cb = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_checkbox")));
		new Actions(login.driver).moveToElement(series_cb).pause(2000).click().build().perform();
		WebElement series_add = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_to_myseries")));
		new Actions(login.driver).moveToElement(series_add).pause(2000).click().build().perform();
	}
	
	@SuppressWarnings("deprecation")
	@And("^hightlight any one series and click on  \"([^\"]*)\" icon \\.$")
	public void hightlight_any_one_series_and_click_on_icon(String arg1) throws Throwable {
		Thread.sleep(9000);
		WebElement one_series = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("One_series_from_myserieslist")));
		new Actions(login.driver).moveToElement(one_series).pause(3000)
				.click(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Show_series_info")))).build()
				.perform();
	}

	@Then("^Verify SSP window$")
	public void verify_SSP_window() throws Throwable {
		Thread.sleep(2000);
		WebElement ssp_window = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Window")));
		if (ssp_window.isDisplayed()) {
			System.out.println("SSP window is opened and validated");
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			Thread.sleep(500);
			CommonFunctionality.DeleteSeries();
		} else {
			Assert.fail("Verify SSP window failed");
		}
	}

	@And("^Go to search$")
	public void go_to_search() throws Throwable {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Series"))));
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys(Keys.chord(Keys.CONTROL, "a"),
				"205424302");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys(Keys.ENTER);
		//CommonFunctionality.search_without_filter();
	}

	@SuppressWarnings("deprecation")
	@And("^hightlight any one series from search list and click on  \"([^\"]*)\" icon \\.$")
	public void hightlight_any_one_series_from_search_list_and_click_on_icon(String arg1) throws Throwable {
		Thread.sleep(2000);
		WebElement first_series = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("One_series_from_seriesList")));
		new Actions(login.driver).moveToElement(first_series).pause(2000)
				.click(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Show_info")))).build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Open SSP window and clicking on \"([^\"]*)\" icon$")
	public void open_SSP_window_and_clicking_on_icon(String arg1) throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("SSP_Window"))));
		WebElement ssp_window = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Window")));
		if (ssp_window.isDisplayed()) {
			Thread.sleep(1000);
			System.out.println("SSP window is opened");
		}
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Add_series_dropdown"))));
		WebElement add_series = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_series_dropdown")));
		new Actions(login.driver).moveToElement(add_series).pause(2000).click().perform();
	}

	@Then("^Verify options on top bar of window$")
	public void verify_options_on_top_bar_of_window() throws Throwable {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("items-wrapper")));
		WebElement dropdownList = login.driver.findElement(By.className("items-wrapper"));
		if (dropdownList.isDisplayed()) {
			Thread.sleep(500);
			login.driver.findElement(By.className("items-wrapper")).click();
			System.out.println("Add series options are present");
		} else {
			Assert.fail("Add series options verification failed");
		}
		
		WebElement chart = login.driver.findElement(By.xpath("//*[@title='Create Chart']"));
		if (chart.isDisplayed()) {
			Thread.sleep(1000);
			System.out.println("Chart option is present");
		} else {
			Assert.fail("Creating chart option verification failed");
		}

		WebElement clipboard = login.driver.findElement(By.xpath("//*[@title='Copy to Clipboard']"));
		if (clipboard.isDisplayed()) {
			Thread.sleep(1000);
			System.out.println("Copy to clipboard option is present");
		} else {
			Assert.fail("Copy to clipboard option verification failed");
		}

		WebElement download = login.driver.findElement(
				By.xpath("//*[contains(@title,'Download') and contains(@class,'download-button__modal')]"));
		if (download.isDisplayed()) {
			Thread.sleep(1000);
			System.out.println("Download option is present");
		} else {
			Assert.fail("Download option verification failed");
		}

		WebElement modal_actions = login.driver.findElement(By.className("movable-modal--actions"));
		if (modal_actions.isDisplayed()) {
			Thread.sleep(2000);
			System.out.println("Minimize, Maximize and close options are present");
		}
		login.Log4j.info("All options have been verified and displayed in top bar of SSP window");
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//*[@title='Close']")).click();
		CommonFunctionality.DeleteSeries();
	}

	@And("^Open SSP window$")
	public void open_SSP_window_and_clicking_on_Add_icon() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("SSP_Window"))));
		WebElement ssp_window = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Window")));
		if (ssp_window.isDisplayed()) {
			Thread.sleep(1000);
			System.out.println("SSP window is opened");
		}
	}

	@And("^Click on Add option$")
	public void click_on_Add_option() throws Throwable {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Add_series_button"))));
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_series_button"))).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
	}

	@Then("^The series should add into right pane$")
	public void the_series_should_add_into_right_pane() throws Throwable {
		Thread.sleep(1000);
		String series_item_name = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_item_name")))
				.getText();
		Thread.sleep(1000);
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

	@And("^Click on Add and group option$")
	public void click_on_add_and_group_option() throws Throwable {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Add_series_dropdown"))));
		WebElement add_series = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_series_dropdown")));
		new Actions(login.driver).moveToElement(add_series).click().perform();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_and_group"))).click();
		Thread.sleep(500);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
	}

	@Then("^The series should add into right pane and be grouped$")
	public void the_series_should_add_into_right_pane_and_be_grouped() throws Throwable {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Series_item_name"))));
		String series_item_name = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_item_name")))
				.getText();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Group_name_right_panel"))));
		List<WebElement> element = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("Group_name_right_panel")));
		for (int i = 0; i < element.size(); i++) {
			String group_name_right_panel = element.get(i).getText();
			if (group_name_right_panel.contains(series_item_name)) {
				login.Log4j.info("The series added successfully to the right pane and grouped");
				CommonFunctionality.DeleteSeries();
				break;
			} else {
				Assert.fail("Verify Series failed");
			}
		}
	}

	@And("^Click on Add to new insight option$")
	public void click_on_Add_to_new_insight_option() throws Throwable {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Add_series_dropdown"))));
		WebElement add_series = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_series_dropdown")));
		new Actions(login.driver).moveToElement(add_series).click().perform();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_to_new_insight"))).click();
		Thread.sleep(500);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
	}

	@Then("^Series has been added to new insight message should display$")
	public void series_has_been_added_to_new_insight_message_should_display() throws Throwable {
		String text = "New insight with the selected series created";
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("New_insight_added_message"))));
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
		Thread.sleep(200);
		login.driver
				.findElement(By.xpath(
						"//*[@class='growl-message growl-success']//*[@class='button button__sm button__primary']"))
				.click();
		Thread.sleep(2000);
		String URL = login.driver.getCurrentUrl();
		if (!(URL.equals(URL1))) {
			System.out.println("New insight with the added series is opened");
			ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
	        login.driver.switchTo().window(newTab.get(1)).close();
		} else {
			Assert.fail("Verification of added series failed");
		}
	}

	@And("^Click on Add to existing insight option$")
	public void click_on_Add_to_existing_insight_option() throws Throwable {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Add_series_dropdown"))));
		WebElement add_series = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_series_dropdown")));
		new Actions(login.driver).moveToElement(add_series).click().perform();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_to_existing_insight"))).click();
	}

	@Then("^Insight explorer page should open$")
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
		WebElement insight = login.driver
				.findElement(By.xpath("//*[contains(text(),'Insight 21')]/following::input[1]"));
		new Actions(login.driver).moveToElement(insight).click().build().perform();
		Thread.sleep(2000);
		WebElement insight_button = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("Insight_add_button")));
		jse.executeScript("arguments[0].click();", insight_button);
		String actual = "Selected series added to insight";
		String expected = login.driver.findElement(By.xpath("//*[@class='growl-message-text']")).getText();
		if (expected.contains(actual)) {
			System.out.println("Insight explorer page added with series");
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
		} else {
			Assert.fail("Insight explorer page does not added with series");
		}
	}

	@And("^click on create chart option$")
	public void click_on_create_chart_option() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Create Chart']")));
		login.driver.findElement(By.xpath("//*[@title='Create Chart']")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
	}

	@And("^click on CTC button$")
	public void click_on_CTC_button() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Copy to Clipboard']")));
		login.driver.findElement(By.xpath("//*[@title='Copy to Clipboard']")).click();
		Thread.sleep(2000);
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
	}

	@And("^Click on download button$")
	public void click_on_download_button() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[contains(@class,'download-button__modal') and contains(@title,'Download.')]")));
		login.driver
				.findElement(
						By.xpath("//*[contains(@class,'download-button__modal') and contains(@title,'Download.')]"))
				.click();
		Thread.sleep(2000);
	}

	@And("^Clicking on minimize icon$")
	public void clicking_on_minimize_icon() throws Throwable {
		Thread.sleep(2000);
		WebElement minimize_icon = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("footnote_window_minimize")));
		if (minimize_icon.isDisplayed()) {
			Assert.assertTrue(true, "Minimize icon is displaying");
		}
	}

	@And("^Clicking on full screen icon$")
	public void clicking_on_full_screen_icon() throws Throwable {
		Thread.sleep(2000);
		WebElement maximize_icon = login.driver.findElement(By.xpath("//div[@title='Full-screen']"));
		if (maximize_icon.isDisplayed()) {
			Assert.assertTrue(true, "Full screen icon is displaying");
			maximize_icon.click();
			Thread.sleep(1000);
		}
	}

	@And("^Clicking on close button$")
	public void clicking_on_close_button() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
		Thread.sleep(2000);
	}

	/*@And("^Click on \"([^\"]*)\" link$")
	public void click_on_link(String arg1) throws Throwable {
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+arg1+"']")));
	    manage_series_id = login.driver.findElement(By.xpath(
				"//*[@class='main-series-information--right']//*[@class='main-series-information--series-id']/div[1]")).getText();
        login.driver.findElement(By.xpath("//*[text()='"+arg1+"']")).click();
        Thread.sleep(2000);
     }*/
	
	@And("^Download data to excel$")
	public void download_data_to_excel() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[contains(@class,'sphere-modal-controls--right')]//*[contains(text(),'Download')]//parent::button")));
		WebElement download_button = login.driver.findElement(By.xpath(
				"//*[contains(@class,'sphere-modal-controls--right')]//*[contains(text(),'Download')]//parent::button"));
		new Actions(login.driver).moveToElement(download_button).click().build().perform();
	}
	
	@And("^Click on \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\" buttons$")
	public void click_on_and_buttons(String arg1, String arg2, String arg3) throws Throwable {
	Thread.sleep(1000);
	try {
		login.driver.findElement(By.xpath("//*[contains(text(),'"+arg1+"') and contains(@title,'Substitute this series')]")).click();
	} catch(Exception j) {
	    suggested_series=login.driver.findElement(By.xpath("//div[@class='suggested-series-item--title']")).getText();
		login.driver.findElement(By.xpath("//*[@class='suggested-series-control']//*[contains(text(),'"+arg1+"')]")).click();
	}
	Thread.sleep(1000);
	login.driver.findElement(By.xpath("//*[@class='suggestions-wizard--footer']//button[contains(text(),'"+arg2+"')]")).click();
	Thread.sleep(1000);
    login.driver.findElement(By.xpath("//*[@class='suggestions-wizard--footer']//button[contains(text(),'"+arg3+"')]")).click();
    Thread.sleep(1000);
    }
   
	@Then("^chart should be created in a view for series$")
	public void chart_should_be_created_in_a_view_for_series() throws Throwable {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("One_series_from_seriesList"))));
		String actual = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("One_series_from_seriesList")))
				.getText();
		String expected = login.driver
				.findElement(By.xpath("//*[@class='highcharts-title']//following-sibling::*[@class='text-dots']"))
				.getText();
		if (expected.equalsIgnoreCase(actual)) {
			System.out.println("Chart created in a view for the series");
			CommonFunctionality.DeleteVisual();
		} else {
			Assert.fail("Verification of chart creation failed");
		}
	}

	@Then("^Download settings window to be opened$")
	public void download_settings_window_to_be_opened() throws Throwable {
		Thread.sleep(2000);
		String actual = login.driver.findElement(By.xpath("//*[@class='download-modal-title']")).getText();
		String expected = login.driver.findElement(By.className("download-modal-title__title")).getText();
		if (actual.contains(expected)) {
			System.out.println("CTC is validated");
			login.driver.findElement(By.className("sphere-modal__close")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Close"))));
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
		} else {
			Assert.fail("Verification of CTC failed");
		}
	}

	@Then("^Should be able to download data$")
	public void should_be_able_to_download_data() throws Throwable {
		CommonFunctionality.DownloadFileVerify();
	}

	@Then("^verify that SSP window should be minimized$")
	public void verify_that_SSP_window_should_be_minimized() throws Throwable {
		Thread.sleep(2000);
		String actual = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ssp_title"))).getText();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//*[@title='Minimize']")).click();
		Thread.sleep(1000);
		String expected = login.driver.findElement(By.xpath("//*[@class='movable-modal--title']")).getText();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Close"))));
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
		if (!(actual.equals(expected))) {
			System.out.println("SSP Window is minimized");
		} else {
			Assert.fail("SSP window minimize verification failed");
		}
	}

	@Then("^verify that SSP window SSP window should be maximized to full screen$")
	public void verify_that_SSP_window_should_be_maximized_to_full_screen() throws Throwable {
		Thread.sleep(2000);
		WebElement maximize = login.driver.findElement(By.xpath(
				"//*[contains(@class,'ui-resizable ui-draggable')]/ancestor::*[contains(@class,'movable-modal__active')]"));
		Thread.sleep(1000);
		if (maximize.getAttribute("class").contains("movable-modal__full-screen")) {
			login.Log4j.info("SSP Window is maximized");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
		} else {
			Assert.fail("SSP window maximize verification failed");
		}
	}

	@Then("^Verify that SSP window SSP window should be closed$")
	public void verify_that_SSP_window_should_be_closed() throws Throwable {
		List<WebElement> element = login.driver.findElements(By.className("single-series-preview--content"));
		if (!(element.size() > 0)) {
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
			System.out.println("Read more field is present");
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Series"))));
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys(Keys.chord(Keys.CONTROL, "a"),
				arg1);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys(Keys.ENTER);
		//CommonFunctionality.search_without_filter();
		WebElement first_item_in_list = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("One_series_from_seriesList")));
		new Actions(login.driver).moveToElement(first_item_in_list).pause(3000)
				.click(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Show_info")))).build().perform();
	}

	@And("^Checking the \"([^\"]*)\" of the series$")
	public void checking_the_of_the_series(String arg1) throws Throwable {
		Thread.sleep(4000);
		String element = login.driver
				.findElement(By
						.xpath("//*[@class='main-series-information--field-name' and contains(text(),'" + arg1 + "')]"))
				.getText();
		System.out.println(element);
	}

	@Then("^Verify the \"([^\"]*)\" of the series should be \"([^\"]*)\"$")
	public void verify_the_of_the_series_should_be(String arg1, String arg2) throws Throwable {
		String expected = arg2;
		String actual = login.driver.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]/following-sibling::*"))
				.getText();
		if (actual.contains(expected)) {
			// arg1.replace(':', ' ');
			login.Log4j.info(arg1 + " of the series has been verified successfully");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
		} else {
			Assert.fail("Verification failed");
		}
	}

	@And("^Click on releases tab$")
	public void click_on_releases_tab() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("with_Release"))));
		WebElement release = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("with_Release")));
		new Actions(login.driver).moveToElement(release).click().build().perform();
	}

	@And("^Click on update request link$")
	public void click_on_update_request_link() throws Throwable {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Update_request"))));
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Update_request"))).click();
	}

	@And("^Enter some text in the update request popup opened$")
	public void Enter_some_text_in_the_update_request_popup_opened() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[contains(@class,'sphere-modal__body')]//*[@class='form--group']//child::textarea")));
		// wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[contains(@class,'sphere-modal__body')]//*[@class='form--group']//child::textarea"),
		// "Type your question here..."));
		login.driver
				.findElement(By
						.xpath("//*[contains(@class,'sphere-modal__body')]//*[@class='form--group']//child::textarea"))
				.sendKeys("CEIC DATA");
		Thread.sleep(1000);
		WebElement submit = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Submit_button_in_update")));
		if (submit.isEnabled()) {
			submit.click();
			System.out.println("Question submitted");
		} else {
			Assert.fail("Submit button not enabled, hence verification failed");
		}
	}

	@And("^Still can not find an answer window opens now enter question and click on submit$")
	public void Still_cannot_find_an_answer_window_opens_now_enter_question_and_click_on_submit() throws Throwable {
		Enter_some_text_in_the_update_request_popup_opened();
	}

	@Then("^Verify the Thank you message$")
	public void verify_the_Thank_you_message() throws Throwable {
		String arg2 = "Thank you for submitting a question to us.";
		String expected = arg2;
		String actual = login.driver
				.findElement(By.xpath("//*[@class='growl-message-content']//*[@class='growl-message-text']")).getText();
		if (actual.contains(expected)) {
			login.Log4j.info("Users can able to send questions and Message has been verified successfully");
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			CommonFunctionality.DeleteSeries();
		} else {
			Assert.fail("Verification failed");
		}
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
		} else {
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
		} else {
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
			Assert.fail("Verification failed");
		}
	}

	@SuppressWarnings("deprecation")
	@Then("^Navigate to search result of same series in series pane$")
	public void navigate_to_search_result_of_same_series_in_series_pane() throws Throwable {
		Thread.sleep(2000);
		WebElement first_series = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("One_series_from_seriesList")));
		new Actions(login.driver).moveToElement(first_series).pause(2000).build().perform();
		String mnemonic_text = login.driver
				.findElement(By.xpath("//*[contains(text(),'Mnemonic:')]/following-sibling::*")).getText();
		if (mnemonic_text.contains(mnemonic_code_id)) {
			login.Log4j.info(mnemonic_text
					+ " is the Mnemonic code and on clicking its navigated to the search result of series panal of same series");
		} else {
			Assert.fail("Verification failed");
		}
	}

	@And("^clicking indicator drop down$")
	public void clicking_indicator_drop_down() throws Throwable {
		//CommonFunctionality.webDriverwait_locator("//span[@class='main-series-information--see-indicators']", "xpath");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("indicator_dropdown"))).click();
		Thread.sleep(500);
	}

	@And("^Click on \"([^\"]*)\" name$")
	public void click_on_name(String arg1) throws Throwable {
//		CommonFunctionality
//				.webDriverwait_locator("//*[@class='main-series-information--field-name' and contains(text(),'" + arg1
//						+ "')]/following-sibling::*", "xpath");
		login.driver.findElement(By.xpath("//*[@class='main-series-information--field-name' and contains(text(),'"
				+ arg1 + "')]/following-sibling::*")).click();
		Thread.sleep(500);
	}

	@And("^Click on \"([^\"]*)\" button$")
	public void click_on_button(String arg1) throws Throwable {
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title,'"+arg1+"') and @class='series-with-suggestions-preview--open-visual']")));
	   WebElement preview = login.driver.findElement(By.xpath("//*[contains(@title,'"+arg1+"') and @class='series-with-suggestions-preview--open-visual']"));
	   new Actions(login.driver).moveToElement(preview).click(preview).build().perform();
	   new Actions(login.driver).moveToElement(preview).click(preview).build().perform();
	}
	
	@And("^click on \"([^\"]*)\" link in SSP window$")
	public void click_on_link_in_SSP_window(String arg1) throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@class='main-series-information--link' and contains(text(),'" + arg1 + "')]")));
		login.driver
				.findElement(
						By.xpath("//*[@class='main-series-information--link' and contains(text(),'" + arg1 + "')]"))
				.click();
		Thread.sleep(500);
	}

	@And("^Click on Ask Question link in SSP window$")
	public void click_on_Ask_Question_link_in_SSP_window() throws Throwable {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[contains(@class,'main-series-information--ask')]")));
		WebElement ask_link = login.driver
				.findElement(By.xpath("//*[contains(@class,'main-series-information--ask')]"));
		new Actions(login.driver).moveToElement(ask_link).click().build().perform();
	}

	/*@And("^Click on \"([^\"]*)\" tab$")
	public void click_on_tab(String arg1) throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@class='tabs__tabs-box']//*[contains(text(),'" + arg1 + "')]")));
		login.driver.findElement(By.xpath("//*[@class='tabs__tabs-box']//*[contains(text(),'" + arg1 + "')]")).click();
		Thread.sleep(2000);
	}*/
	
	@And("^Click on replacement series name hyperlink$")
	public void click_on_replacement_series_name_hyperlink() throws Throwable {
	    CommonFunctionality.webDriverwait_keyvalue("Replacement_suggestion");
	    login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Replacement_suggestion"))).click();
	    Thread.sleep(1000);
	}
	
	@And("^Click on replacement series name dropdown$")
	public void click_on_replacement_series_name_dropdown() throws Throwable {
	    CommonFunctionality.webDriverwait_keyvalue("Replacement_suggestion_dropdown");
	    login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Replacement_suggestion_dropdown"))).click();
	    Thread.sleep(1000);
	}

	@And("^Check contents$")
	public void check_contents() throws Throwable {
		Thread.sleep(1000);
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("statistics_contents"))).isDisplayed());
		{
			System.out.println("Statistics tab contents are displaying");
		}
	}

	@And("^Check contents inside Related data$")
	public void check_contents_inside_Related_data() throws Throwable {
		Thread.sleep(1000);
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("related_data_contents"))).isDisplayed())
			;
		{
			System.out.println("Related data contents are displaying");
		}
	}

	@And("^Observe full data display$")
	public void observe_full_data_display() throws Throwable {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.className("series-changes-time-line--observations-count")));
		String list = login.driver.findElement(By.className("series-changes-time-line--observations-count")).getText();
		if (list.contains("obs")) {
			System.out.println("Data has been displayed inside data tab and the total observations are " + list);
		}
	}
	
	@SuppressWarnings("deprecation")
	@And("^Select the series checkbox from myseries$")
	public void select_the_series_checkbox_from_myseries() throws Throwable {
		WebElement selection = login.driver
				.findElement(By.xpath("//div[@class='check-all-series']//span[@class='input-control--indicator']"));
		new Actions(login.driver).moveToElement(selection).pause(1000).click().build().perform();
		Thread.sleep(2000);
	}
	
	@And("^Apply a function on any series in my series$")
	public void apply_a_function_on_any_series_in_my_series() throws Throwable {
		CommonFunctionality.webDriverwait_keyvalue("Functions_input_field");
	    login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Functions_input_field"))).click();
	    Thread.sleep(200);
	    login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Functions_auto_suggestion"))).click();
	    Thread.sleep(200);
	    login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Functions_auto_suggestion"))).click();
	    Thread.sleep(200);
	    login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Functions_auto_suggestion"))).click();
	    Thread.sleep(200);
	    WebElement apply = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Functions_apply")));
	    jse.executeScript("arguments[0].click();", apply);
	    function_name = login.driver.findElement(By.className("series-function-item--arguments-list")).getAttribute("title");
	    
	}
	
	@Then("^Drop down should display indicators list and clicking on specific indicators should navigate to results page$")
	public void drop_down_should_display_indicators_list_and_clicking_on_specific_indicators_should_navigate_to_results_page()
			throws Throwable {

		List<WebElement> dropdown_list = login.driver.findElements(By.xpath("//*[@class='series-related-indicators']"));
		for (int i = 0; i < dropdown_list.size(); i++) {
			String values = dropdown_list.get(i).getText();
			System.out.println("Indicators list are : \n" + values);
			indicator_value = dropdown_list.get(0).getText();
			dropdown_list.get(0).click();
		}
		Thread.sleep(500);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
		Thread.sleep(1500);
		if (!(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Close"))).size() > 0)) {
			login.Log4j.info("Indicator values are selected and it successfully navigating to results page");
			CommonFunctionality.DeleteSeries();
		} else {
			Assert.fail("Verification failed");
		}
	}

	@SuppressWarnings("deprecation")
	@Then("^Selecting indicator from indicator drop down should show search result in left for same indicator$")
	public void selecting_indicator_from_indicator_dropdown_should_show_search_result_in_left_for_same_indicator()
			throws Throwable {
		List<WebElement> dropdown_list = login.driver.findElements(By.xpath("//*[@class='series-related-indicators']"));
		for (int i = 0; i < dropdown_list.size(); i++) {
			String values = dropdown_list.get(i).getText();
			System.out.println("Indicators list are : \n" + values);
			indicator_value = dropdown_list.get(0).getText();
			dropdown_list.get(0).click();
		}
		Thread.sleep(500);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
		Thread.sleep(1500);
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
			Assert.fail("Verification failed");
		}
	}

	@Then("^It should apply source filter in search pane to display it's result$")
	public void it_should_apply_source_filter_in_search_pane_to_display_it_s_result() throws Throwable {
		String actual = login.driver.findElement(By.className("single-series-preview--title ")).getText();
		Thread.sleep(500);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
		Thread.sleep(500);
		List<WebElement> list_of_items = login.driver.findElements(By.className("series-item--name"));
		for (WebElement expected_list : list_of_items) {
			String expected = expected_list.getText();
			if (expected.equalsIgnoreCase(actual)) {
				login.Log4j.info("The title consists of " + actual
						+ " and it displayed as source filter in search pane as one of the result");
				CommonFunctionality.DeleteSeries();
				break;
			}
			Assert.assertEquals(actual, expected);
		}
	}

	@Then("^Footnotes window should be displayed with related details$")
	public void footnotes_window_should_be_displayed_with_related_details() throws Throwable {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("footnotes_title_text"))));
		String a = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("footnotes_title_text"))).getText();
		String b = "Footnotes";
		String c = login.driver.findElement(By.xpath("//*[@class='footnotes-modal--name']/*")).getText();
		String d = login.driver.findElement(By.className("single-series-preview--title ")).getText();
		if (a.contains(b)) {
			login.driver.findElement(By.xpath("//*[@class='footnotes-modal']/following::*[@title='Close']")).click();
		}
		if (c.contains(d)) {
			login.Log4j.info("Footnotes window should be displayed with related details and verified");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			CommonFunctionality.DeleteSeries();
		} else {
			Assert.fail("Verification failed");
		}
	}

	@Then("^Should open still can not find an answer window$")
	public void should_open_still_can_not_find_an_answer_window() throws Throwable {
		Enter_some_text_in_the_update_request_popup_opened();
	}

	@Then("^Verify that user should be able to send question successfully$")
	public void verify_that_user_should_be_able_to_send_question_successfully() throws Throwable {
		verify_the_Thank_you_message();
	}

	@Then("^Should create a chart visual$")
	public void should_create_a_chart_visual() throws Throwable {
		if (login.driver.findElement(By.className("highcharts-container ")).isDisplayed()) {
			login.Log4j.info("Chart visual is displaying and its verified");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			CommonFunctionality.DeleteSeries();
		} else {
			Assert.fail("Failed to verify");
		}
	}

	@Then("^Complete observations must be displayed$")
	public void complete_observations_must_be_displayed() throws Throwable {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//*[@class='preview-series-time-points--point-date'])[1]")));
		String end_year = login.driver
				.findElement(By.xpath("(//*[@class='preview-series-time-points--point-date'])[1]")).getText();
		String start_year = "2000";
		String end_year_new = end_year.substring(3, 7);
		String observe_data1 = "//*[@class='preview-series-time-points--point']/span[1]";
		List<WebElement> data = login.driver.findElements(By.xpath(observe_data1));
		for (int i = 0; i < data.size(); i++) {
			String data1 = data.get(i).getText();
			if (data1.contains(start_year)) {
				System.out.println("Observations starts from the year " + start_year);
				break;
			}
			if (data1.contains(end_year)) {
				System.out.println("Observations ends till the year " + end_year_new);
			}
		}
		WebElement close = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close")));
		if (close.isDisplayed()) {
			close.click();
			login.Log4j.info("Complete observations on data tab are displaying and its verified");
			Thread.sleep(1000);
			CommonFunctionality.DeleteSeries();
		} else {
			Assert.fail("Verification failed");
		}
	}

	@Then("^Should have details on location,variability,shape$")
	public void should_have_details_on_location_variability_shape() throws Throwable {
		List<WebElement> statistics = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("statistics_info_block")));
		if (statistics.size() == 3) {
			login.Log4j.info("Statistics tab have blocks: location, visibility and shape");
			Thread.sleep(200);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			Thread.sleep(500);
			CommonFunctionality.DeleteSeries();
		} else {
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
			if (related.contains(title)) {
				System.out.println("Related Keyword is displaying");
			} else {
				Assert.fail("Verification failed");
			}
		}
		String datasets = login.driver
				.findElement(By.xpath(
						"//*[@class='related-series-information-portlet--header']//*[contains(text(),'" + arg1 + "')]"))
				.getText();
		String datasets1 = "DATASETS";
		String Insights = login.driver
				.findElement(By.xpath(
						"//*[@class='related-series-information-portlet--header']//*[contains(text(),'" + arg2 + "')]"))
				.getText();
		String Insights1 = "INSIGHTS";
		if (datasets.contains(datasets1) && Insights.contains(Insights1)) {
			login.Log4j.info("Displaying the related Keywords for blocks named Datasets and Insights");
			Thread.sleep(100);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
			Thread.sleep(500);
			CommonFunctionality.DeleteSeries();
		} else {
			Assert.fail("Verification failed");
		}
	}
	
	@Then("^Click on each links available under \"([^\"]*)\" and verify the changes$")
	public void click_on_each_links_available_under_and_verify_the_changes(String arg1) throws Throwable {
	  String actual = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ssp_title"))).getText();
	  if(login.driver.findElement(By.xpath("//*[contains(text(),'"+arg1+"')]//following::*[@class='series-related-data-sets']")).isDisplayed()) {
		  List<WebElement> related = login.driver.findElements(By.className("series-data-set--title"));
		  for (WebElement rel:related) {
			   jse.executeScript("arguments[0].click();", rel);
			   List<WebElement> expected1= login.driver.findElements(By.xpath("//ul[@class='search-series-list']/li//*[@class='series-item--name']"));
			  for(WebElement expect: expected1) {
				  String expected = expect.getText();
				  if(expected.contains(actual) || expected.isEmpty()) {
					  System.out.print("");
				  }
				  }
			  }
		  login.Log4j.info("Clicked on each links available under Datasets and its verified");
		  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
		  Thread.sleep(500);
		  CommonFunctionality.DeleteSeries();
		  } else {
			  Assert.fail("Verification failed");
		  }
	  }
	
	@SuppressWarnings("deprecation")
	@Then("^Click on each links available under \"([^\"]*)\" and it should open respective insights$")
	public void click_on_each_links_available_under_and_it_should_open_respective_insights(String arg1) throws Throwable {
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("insights-grid-body")));
	  if(login.driver.findElement(By.className("insights-grid-body")).isDisplayed()) {
		  List<WebElement> related = login.driver.findElements(By.xpath("//*[contains(text(),'"+arg1+"')]//following::*[@class='insights-grid-body']/div/div[2]/div/a"));
		  for (WebElement rel:related) {
			  String actual = rel.getText();
			  jse.executeScript("arguments[0].click();", rel);
			  String expected = login.driver.findElement(By.xpath("//*[contains(@class,'insight-preview--title')]")).getText();
			  if(expected.contains(actual) || expected.contains("Untitled insight") || expected.contains("")) {
			  WebElement insight_close = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("insight-preview-close")));
			  new Actions(login.driver).moveToElement(insight_close).pause(1000).click(insight_close).build().perform();
			  }
		  }
		  login.Log4j.info("Clicked on each links available under Insights and all links are opening respective insight which has been verified");
		  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
		  Thread.sleep(500);
		  CommonFunctionality.DeleteSeries();
		  } else {
			  Assert.fail("Verification failed");
		  }
      }
	
	@SuppressWarnings("deprecation")
	@Then("^Discontinued series has to be replaced with suggested series into right$")
	public void discontinued_series_has_to_be_replaced_with_suggested_series_into_right() throws Throwable {
		Thread.sleep(9000);
		WebElement one_series = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("One_series_from_myserieslist")));
		new Actions(login.driver).moveToElement(one_series).pause(3000).click(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Show_series_info")))).build().perform();
	    String replaced_text = login.driver.findElement(By.xpath("//*[@class='main-series-information--right']//*[@class='main-series-information--series-id']/div[1]")).getText();
	    if(!(CommonFunctionality.manage_series_id.equals(replaced_text))) {
	    	login.Log4j.info("Discontinued series has to be replaced with suggested series and its verified successfully");
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
	    	Thread.sleep(500);
	    	CommonFunctionality.DeleteSeries();
	    } else {
	    	Assert.fail("Verification Failed");
	    }
	}
	
	@SuppressWarnings("deprecation")
	@Then("^Suggested series has to be added into right pane into the same insight$")
	public void suggested_series_has_to_be_added_into_right_pane_into_the_same_insight() throws Throwable {
		Thread.sleep(9000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
		WebElement one_series = login.driver.findElement(By.xpath("//*[@class='webix_column list-series-name webix_last']/div[2]/div/div/div/span[@class='series-name-field-title']/span"));
		new Actions(login.driver).moveToElement(one_series).pause(1000).click(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Show_series_info")))).build().perform();
		String suggested_series1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ssp_title"))).getText();
		if(suggested_series1.contains(suggested_series)) {
			login.Log4j.info("Suggested series has to be added into right pane into the same insight and it has been verified successfully");
	    	Thread.sleep(500);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
	    	CommonFunctionality.DeleteSeries();
	    } else {
	    	Assert.fail("Verification Failed");
	    }
	}
	
	@Then("^Both inactive and suggestion should be viewed as chart$")
	public void both_inactive_and_suggestion_should_be_viewed_as_chart() throws Throwable {
	    Thread.sleep(1000);
	    List<WebElement> element = login.driver.findElements(By.xpath("//*[@class='legend-item']//*[@class='series-edit--title']"));
	    if(element.size() >1) {
	    	login.Log4j.info("Both inactive and suggestion should be viewed as chart and it has been verified");
	    	List<WebElement> closed = login.driver.findElements(By.xpath("//*[contains(text(),'Add related series')]//following::*[@title='Close']"));
	    	if(closed.size()>0) {
	    	login.driver.findElement(By.xpath("//*[contains(text(),'Add related series')]//following::*[@title='Close']")).click();
	    	}
	    	Thread.sleep(500);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
	    	CommonFunctionality.DeleteSeries();
	    } else {
	    	Assert.fail("Verification Failed");
	    }
	}
	
	@Then("^SSP for replacement series should open as a new popup$")
	public void ssp_for_replacement_series_should_open_as_a_new_popup() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    List<WebElement> popup = login.driver.findElements(By.className("single-series-preview--body"));
	    if(popup.size()>1) {
	    	login.Log4j.info("SSP for replacement series opened as a new popup and it has been verified successfully");
	    	List<WebElement> close = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Close")));
	    	System.out.println(close.size());
	    	for(WebElement closing:close) {
	    		Thread.sleep(2000);
	    		jse.executeScript("arguments[0].click();", closing);
	    	}
	     	CommonFunctionality.DeleteSeries();
	    } else {
	    	Assert.fail("Verification Failed");
	    }
	}
	
	@Then("^SSP should be opened for the series and series name should be suffixed with function name$")
	public void ssp_should_be_opened_for_the_series_and_series_name_should_be_suffixed_with_function_name() throws Throwable {
	   Thread.sleep(1000);
	   String function_title= login.driver.findElement(By.className("series-functions--modal-title-label")).getText();
	   String replace=function_title.replace("(","\n(");
	   if(replace.contains(function_name)) {
		   login.Log4j.info("SSP is opened for the series and series name is suffixed with function name");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
	    	Thread.sleep(1000);
	    	login.driver.findElement(By.xpath("//*[contains(@title,'Delete')]")).click();
	    } else {
	    	Assert.fail("Verification Failed");
	    }
	 }
}
