package CDMNext.StepDefinations;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class PieVisual {
	EmptyView EV = new EmptyView();
	CDMNextSprintCases cv = new CDMNextSprintCases();
	Commentary commentary = new Commentary();
	SeriesTab st = new SeriesTab();
	Histogram hs = new Histogram();
	DatabasesTab db = new DatabasesTab();
	WebElement insert_pie;
	WebElement destination;
	String BeforeSelect_date, expectedDate, SearchKeyword, ReplaceKeyword,ExpectedSname,arg;
	public static String sname;
	WebElement SeriesCount;
	static String Visual_Title_txt;
	List<WebElement> Series_list_EditSeriesPanel;
	List<WebElement> Series_list_pieVisual;
	WebDriverWait wait = new WebDriverWait(login.driver, 2000);
	JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	@SuppressWarnings("deprecation")
	@And("^Select different frequency series \"([^\"]*)\" and click on \"([^\"]*)\" icon$")
	public void select_different_frequency_series_and_click_on_icon(String arg1, String arg2) throws Throwable {
		// CommonFunctionality.webDriverwait_keyvalue("Series_tab");
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_tab"))).click();
		CommonFunctionality.webDriverwait_keyvalue("Series_new");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_new"))).click();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).clear();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(arg1);
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		CommonFunctionality.wait
				.until(ExpectedConditions.invisibilityOfElementLocated(By.className("blocker--loader")));
		List<WebElement> total_count = login.driver.findElements(
				By.xpath("//ul[@class='search-series-list']//div[contains(@class,'series-search-list-item')]"));
		for (int i = 1; i <= total_count.size(); i++) {
			WebElement unselect_check = CommonFunctionality.getElementByXpath(login.driver,
					"//ul[@class='search-series-list']//div[contains(@class,'series-search-list-item')][" + i + "]", 4);
			WebElement series = CommonFunctionality.getElementByXpath(login.driver,
					"(//div[@class='series-list-item--checkbox-wrapper']//span[contains(@class,'series-list-item--checkbox')])["
							+ i + "]",
					4);
			if (!(unselect_check.getAttribute("class").contains("series-list-item__selected"))) {
				new Actions(login.driver).moveToElement(series).pause(100).click().build().perform();
			}
		}
		if (arg2.equalsIgnoreCase("Pie")) {
			cv.click_on_more_actions();
			new Actions(login.driver).moveToElement(
					CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'View as ...')]", 4))
					.build().perform();
			new Actions(login.driver)
					.moveToElement(
							CommonFunctionality.getElementBycssSelector(login.driver, "span[title='" + arg2 + "']", 4))
					.pause(1000).click().build().perform();
		}
	}

	@And("^Hovor on Insert Pie$")
	public void hovor_on_Insert_Pie() throws Throwable {
		insert_pie = CommonFunctionality.getElementByXpath(login.driver, "//div[@data-title='Pie']", 4);
		destination = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='view-components-over--visual-title' and text()='Pie']", 4);
	}

	@SuppressWarnings("deprecation")
	@And("^\"([^\"]*)\" the Insert pie option$")
	public void the_Insert_pie_option(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Drag and Drop")) {
			new Actions(login.driver).moveToElement(insert_pie).pause(100).clickAndHold(insert_pie)
					.dragAndDrop(insert_pie, destination).build().perform();
		}
	}

	@And("^Make the changes in series harmonization popup$")
	public void make_the_changes_in_series_harmonization_popup() throws Throwable {
		CommonFunctionality.wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Series Harmonization']")));
		Select select = new Select(
				CommonFunctionality.getElementByXpath(login.driver, "//select[@name='currency']", 4));
		select.selectByValue("USD");
		Select select1 = new Select(CommonFunctionality.getElementByXpath(login.driver, "//select[@name='unit']", 4));
		select1.selectByValue("NA");
		CommonFunctionality.getElementBycssSelector(login.driver, ".movable-modal--window .button__primary", 4).click();
	}

	@And("^Make the changes in the series harmonization popup$")
	public void make_the_changes_in_the_series_harmonization_popup() throws Throwable {
		CommonFunctionality.wait(500);
		Select select = new Select(
				CommonFunctionality.getElementByXpath(login.driver, "//select[@name='currency']", 4));
		select.selectByValue("");
		Select select1 = new Select(CommonFunctionality.getElementByXpath(login.driver, "//select[@name='unit']", 4));
		select1.selectByValue("NA");
	}

	@Then("^The Window should be maximized$")
	public void the_Window_should_be_maximized() throws Throwable {
		click_on_minus_icon_again();
		the_Window_should_get_maximized();
	}

	@And("^Click on minus icon again$")
	public void click_on_minus_icon_again() throws Throwable {
		CommonFunctionality.wait(300);
		CommonFunctionality.getElementBycssSelector(login.driver, "div[title='Minimize']", 4).click();
		CommonFunctionality.wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[title='Maximize']")));
		CommonFunctionality.getElementBycssSelector(login.driver, "div[title='Maximize']", 4).click();
	}

	@Then("^The Window should get maximized$")
	public void the_Window_should_get_maximized() throws Throwable {
		String maximize = CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='movable-modal--actions']/div[1]", 4)
				.getAttribute("title");
		assertEquals(maximize, "Minimize");
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		System.out.println("The window is maximized");
		CommonFunctionality.Views_list();
	}

	@Then("^Verify viewing \"([^\"]*)\" of frequency conversion popup$")
	public void verify_viewing_of_frequency_conversion_popup(String arg1) throws Throwable {
		verify_viewing_of_data_currency_conversion_popup(arg1);
	}

	@Then("^Verify viewing \"([^\"]*)\" of data currency conversion popup$")
	public void verify_viewing_of_data_currency_conversion_popup(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Full-screen")) {
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--action-icon__expand", 4).click();
			String full_screen = CommonFunctionality
					.getElementByXpath(login.driver,
							"//div[@class='movable-modal--action-icon__expand']/ancestor::div[2]", 4)
					.getAttribute("title");
			assertEquals(full_screen, "Exit full-screen");
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		}
		if (arg1.equalsIgnoreCase("Exit full-screen")) {
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--action-icon__expand", 4).click();
			CommonFunctionality.getElementBycssSelector(login.driver, ".movable-modal--action-icon__full-size", 4)
					.click();
			String full_screen = CommonFunctionality
					.getElementByXpath(login.driver,
							"//div[@class='movable-modal--action-icon__expand']/ancestor::div[2]", 4)
					.getAttribute("title");
			assertEquals(full_screen, "Full-screen");
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		}
		if (arg1.equalsIgnoreCase("Closing")) {
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			List<WebElement> close = login.driver.findElements(By.cssSelector(".movable-modal--window"));
			assertEquals(close.size(), 0);
		}
		System.out.println("The " + arg1 + " action is performed");
		CommonFunctionality.Views_list();
	}

	@Then("^Verify default values of data currency conversion popup$")
	public void verify_default_values_of_data_currency_conversion_popup() throws Throwable {
		CommonFunctionality.wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Series Harmonization']")));
		String select = CommonFunctionality
				.getElementByXpath(login.driver, "//select[@name='missing_values']/option[1]", 4).getText();
		assertEquals(select, "Keep as reported");
		String select1 = CommonFunctionality.getElementByXpath(login.driver, "//select[@name='currency']/option[1]", 4)
				.getText();
		assertEquals(select1, "Keep as reported");
		String select2 = CommonFunctionality.getElementByXpath(login.driver, "//select[@name='unit']/option[1]", 4)
				.getText();
		String b = select2.replaceAll(" ", "");
		assertEquals(b, "asreported");
		CommonFunctionality.getElementBycssSelector(login.driver, ".movable-modal--window .button__primary", 4).click();
		CommonFunctionality.Views_list();
		System.out.println("The default values in data currency conversion popup has been verified successfully");
	}

	@Then("^Verify the function applied in frequency conversion popup$")
	public void verify_the_function_applied_in_frequency_conversion_popup() throws Throwable {
		CommonFunctionality.wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Series Harmonization']")));
		Select select = new Select(
				CommonFunctionality.getElementByXpath(login.driver, "//select[@name='frequency']", 4));
		select.selectByValue("M");
		String agg = CommonFunctionality.getElementByClassName(login.driver, "edit-series-function--description", 4)
				.getText();
		String split1[] = agg.split(Pattern.quote("("));
		assertEquals(split1[0], "AGGREGATE");
		select.selectByValue("D");
		String disagg = CommonFunctionality.getElementByClassName(login.driver, "edit-series-function--description", 4)
				.getText();
		String split[] = disagg.split(Pattern.quote("("));
		assertEquals(split[0], "DISAGGREGATE");
		CommonFunctionality.getElementBycssSelector(login.driver, ".movable-modal--window .button__primary", 4).click();
		CommonFunctionality.Views_list();
		System.out.println("The functions in frequency conversion popup has been verified successfully");
	}

	@Then("^The number of days should able to select in a functions End dropdown$")
	public void the_number_of_days_should_able_to_select_in_a_functions_End_dropdown() throws Throwable {
		CommonFunctionality.wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Series Harmonization']")));
		CommonFunctionality.getElementByClassName(login.driver, "edit-series-function--icon", 4).click();
		String text = CommonFunctionality.getElementBycssSelector(login.driver,
				"div[argument='end'] .function-parameter--body .select2-chosen", 4).getText();
		assertEquals(text, "December");
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='function-data--info']//*[@argument='end']//*[@class='select2-container function-parameter--select']",
				4).click();
		List<WebElement> li_all = login.driver.findElements(By.xpath("//ul[@class='select2-results']/li"));
		if (li_all.size() != 0) {
			for (WebElement li : li_all) {
				String text1 = li.getText();
				System.out.println(text1);
				String split[] = text1.split(" ");
				if (!split[0].equals("Last")) {
					assertEquals(split[0], "Day");
				}
			}
		} else {
			fail("Failed");
		}
		login.Log4j.info("The number of days is selectable in frequency end dropdown");
		// new
		// Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
		// "(//*[@class='function-data--info']//*[contains(text(),'Last day of
		// month')]/following::span[1])[1]",
		// 4)).click().build().perform();
		// CommonFunctionality.getElementBycssSelector(login.driver,
		// ".edit-series-function--icon", 4).click();
		CommonFunctionality.getElementBycssSelector(login.driver, ".movable-modal--window .button__primary", 4).click();
		CommonFunctionality.Views_list();
	}

	@Then("^The message should appear$")
	public void the_message_should_appear() throws Throwable {
		String actual = "1 of 1 series has a negative value or doesn't have a value in the selected period and it cannot be included in Pie";
		CommonFunctionality.wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.className("growl-message-text")));
		String text = CommonFunctionality.getElementByClassName(login.driver, "growl-message-text", 4).getText();
		assertEquals(actual, text);
		CommonFunctionality.Views_list();
		System.out.println("The negative values has been verified");
	}

	@SuppressWarnings("deprecation")
	@Then("^Should be able to open frequency conversion popup with all the available options present$")
	public void should_be_able_to_open_frequency_conversion_popup_with_all_the_available_options_present()
			throws Throwable {
		CommonFunctionality.wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Series Harmonization']")));
		CommonFunctionality
				.getElementBycssSelector(login.driver, ".series-data-conversion--buttons .button__text_purple", 4)
				.click();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, ".legend-item--attention", 4))
				.pause(500).build().perform();
		String tooltip = CommonFunctionality.getElementBycssSelector(login.driver, ".tooltip__visible", 4).getText();
		if (!tooltip.contains("Convert it to any other frequency to visualize.")) {
			fail("Verification Failed");
		}
		CommonFunctionality.getElementBycssSelector(login.driver, ".tooltip__visible .link", 4).click();
		List<WebElement> popup = login.driver.findElements(By.xpath("//*[text()='Series Harmonization']"));
		assertEquals(popup.size(), 1);
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		CommonFunctionality.Views_list();
		System.out.println("Should able to open frequency conversion popup with all available options present");
	}

	@Then("^The Edit series panel should be opened with \"([^\"]*)\" tab$")
	public void the_Edit_series_panel_should_be_opened_with_tab(String arg1) throws Throwable {
		CommonFunctionality.wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Series Harmonization']")));
		CommonFunctionality
				.getElementBycssSelector(login.driver, ".series-data-conversion--buttons .button__text_purple", 4)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='Edit Series']", 4).click();
		if (CommonFunctionality
				.getElementByXpath(login.driver, "//*[text()='Pie' and @class='sidebar-panel--tab-name-txt']", 4)
				.isDisplayed()) {
			System.out.println("The " + arg1 + " is displayed");
		} else {
			fail("Verification Failed");
		}
		ArrayList<String> right = new ArrayList<String>();
		List<WebElement> series_all = login.driver.findElements(By.cssSelector(".series-edit--title__editable"));
		for (int i = series_all.size(); i >= 1; i--) {
			String series = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[contains(@class,'series-edit--title__editable')])[" + i + "]", 4).getText();
			right.add(series);
		}
		ArrayList<String> left = new ArrayList<String>();
		List<WebElement> series_all1 = login.driver.findElements(By.cssSelector(".series-name--title"));
		for (int i = 1; i <= series_all1.size(); i++) {
			String series1 = CommonFunctionality
					.getElementByXpath(login.driver, "(//*[@class='series-name--title'])[" + i + "]", 4).getText();
			left.add(series1);
		}
		assertEquals(right.toArray(), left.toArray());
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Rename')]", 4).click();
		List<WebElement> rename = login.driver.findElements(By.className("find-and-replace--modal-title"));
		assertEquals(1, rename.size());
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		CommonFunctionality.Views_list();
		System.out.println("The Edit series options are verified");
	}

	@SuppressWarnings("deprecation")
	@Then("^US currency should be applicable for series in visual pie$")
	public void us_currency_should_be_applicable_for_series_in_visual_pie() throws Throwable {
		CommonFunctionality.wait
				.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()='Series Harmonization']")));
		List<WebElement> series = login.driver.findElements(By.cssSelector(".series-edit--title__editable"));
		for (int i = 1; i <= series.size(); i++) {
			WebElement series_one = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[contains(@class,'series-edit--title__editable')])[" + i + "]", 4);
			new Actions(login.driver).moveToElement(series_one).pause(100).build().perform();
			String actual = CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(text(),'Functions:')]/following-sibling::*", 4)
					.getText();
			String split[] = actual.split("\\(");
			String next_split = split[1];
			String final_split;
			if (next_split.contains(";")) {
				final_split = next_split.substring(0, 11);
			} else {
				final_split = next_split.substring(0, 9);
			}
			String expected = final_split.substring(0, final_split.length() - 1);
			if (!expected.contains("US Dollars")) {
				fail("Verification Failed");
			}
		}
		CommonFunctionality.Views_list();
		login.Log4j.info("US currency is applicable for series in visual pie");
	}

	@Then("^Pie visual should be created with frequency conversion window popped up$")
	public void pie_visual_should_be_created_with_frequency_conversion_window_popped_up() throws Throwable {
		CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@class='movable-modal--header']//div[text()='Series Harmonization']")));
		List<WebElement> model = login.driver
				.findElements(By.xpath("//*[@class='movable-modal--header']//div[text()='Series Harmonization']"));
		assertEquals(model.size(), 1);
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		CommonFunctionality.Views_list();
		login.Log4j
				.info("The Pie visual is created with frequency conversion window popped up and verified successfully");
	}

	@Then("^Pie visual should add to view area by \"([^\"]*)\"$")
	public void chart_visual_should_add_to_view_area_by(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("DragandDrop")) {
			if (CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(@class,'empty-visual-overlay__empty-selection')]//*[text()='Pie']", 4)
					.isDisplayed()) {
				login.Log4j.info("The Pie visual is added to view area by " + arg1);
			} else {
				fail(arg1 + " is not working");
			}
			CommonFunctionality.Views_list();
		}
	}

	@Then("^Frequency conversion window should be popped for selecting other than weekly frequency in same window$")
	public void frequency_conversion_window_should_be_popped_for_selecting_other_than_weekly_frequency_in_same_window()
			throws Throwable {
		CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@class='movable-modal--header']//div[text()='Series Harmonization']")));
		List<WebElement> frequency = login.driver.findElements(By.xpath("//select[@name='frequency']/option"));
		assertEquals(6, frequency.size());
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		CommonFunctionality.Views_list();
		login.Log4j.info(
				"The Pie visual is created with frequency conversion window popped up and the replacement frequency dropdown count is "
						+ frequency.size());
	}

	@Then("^The Data conversion window should get closed$")
	public void the_Data_conversion_window_should_get_closed() throws Throwable {
		CommonFunctionality.wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Series Harmonization']")));
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Cancel')]", 4).click();
		List<WebElement> close = login.driver.findElements(By.xpath("//*[text()='Series Harmonization']"));
		assertEquals(close.size(), 0);
		CommonFunctionality.Views_list();
		login.Log4j.info("The Data conversion window is getting closed");

	}

	@And("^Create a Pie visual$")
	public void create_a_Pie_visual() throws Throwable {
		EV.click_on_View_tab();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@data-title='Pie']", 4).click();
		CommonFunctionality.wait(500);
	}

	@And("^Select series with same filter and different units \"([^\"]*)\"$")
	public void select_series_with_same_filter_and_different_units(String arg1) throws Throwable {
		SelectSeries(arg1);
	}

	@And("^Select series with different filter and units \"([^\"]*)\"$")
	public void select_series_with_different_filter_and_units(String arg1) throws Throwable {
		SelectSeries(arg1);
	}

	@And("^Select Currency conversion as \"([^\"]*)\" and with \"([^\"]*)\"$")
	public void select_Currency_conversion_as_and_with(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Series Harmonization']")));
		Select select = new Select(
				CommonFunctionality.getElementByXpath(login.driver, "//select[@name='currency']", 4));
		Select select1 = new Select(CommonFunctionality.getElementByXpath(login.driver, "//select[@name='unit']", 4));
		// select currency
		if (arg1.equalsIgnoreCase("US Dolllars")) {
			select.selectByValue("USD");

		} else if (arg1.equalsIgnoreCase("Chinese Yuan (RMB)")) {
			select.selectByValue("RMB");
		} else if (arg1.equalsIgnoreCase("Japanese Yen")) {
			select.selectByValue("JPY");
		} else if (arg1.equalsIgnoreCase("UK Pounds")) {
			select.selectByValue("GBP");
		} else if (arg1.equalsIgnoreCase("Euros")) {
			select.selectByValue("EUR");
		} else if (arg1.equalsIgnoreCase("Malaysian Ringgit")) {
			select.selectByValue("MYR");
		} else if (arg1.equalsIgnoreCase("Russian Ruble")) {
			select.selectByValue("RUB");
		}
		// select unit
		if (arg2.equalsIgnoreCase("as reported")) {
			select1.selectByValue("NA");
		} else if (arg2.equalsIgnoreCase("in Thousands")) {

			select1.selectByValue("TH");
		} else if (arg2.equalsIgnoreCase("in Millions")) {

			select1.selectByValue("MN");
		} else if (arg2.equalsIgnoreCase("in Billions")) {

			select1.selectByValue("BN");
		}
		CommonFunctionality.getElementBycssSelector(login.driver, ".movable-modal--window .button__primary", 4).click();
	}

	@Then("^\"([^\"]*)\" currency should get converted as \"([^\"]*)\" in visual pie$")
	public void currency_should_get_converted_as_in_visual_pie(String arg1, String arg2) throws Throwable {
		CurrencyConversion_method(arg1, arg2);
	}

	@And("^Click on minus icon$")
	public void click_on_minus_icon() throws Throwable {
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementBycssSelector(login.driver, "div[title='Minimize']", 4).click();
	}

	@Then("^The Window should be minimized$")
	public void the_Window_should_be_minimized() throws Throwable {

		CommonFunctionality.wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[title='Maximize']")));

		String minimize = CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='movable-modal--actions']/div[1]", 4)
				.getAttribute("title");
		assertEquals(minimize, "Maximize");
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		System.out.println("The window is minimized");
		CommonFunctionality.Views_list();
	}

	@Then("^The following options should be available$")
	public void the_following_options_should_be_available(List<String> list) throws Throwable {
		List<WebElement> optionsPresented = login.driver
				.findElements(By.xpath("//*[@class='series-data-conversion--functions-list']/*/*[1]"));
		SeriesDataConversionFunctionsList(list, optionsPresented);
	}

	@Then("^The following frequencies should be available$")
	public void the_following_frequencies_should_be_available(List<String> listOfFrequencies) throws Throwable {
		List<WebElement> ActualFrequencies = login.driver.findElements(By.xpath("//select[@name='frequency']/option"));
		SeriesDataConversionFunctionsList(listOfFrequencies, ActualFrequencies);
	}

	@Then("^The following missing values method should be available$")
	public void the_following_missing_values_method_should_be_available(List<String> listOfMissingValues)
			throws Throwable {
		List<WebElement> ActualMissingValues = login.driver
				.findElements(By.xpath("//select[@name='missing_values']/option"));
		SeriesDataConversionFunctionsList(listOfMissingValues, ActualMissingValues);
	}

	@Then("^The following Currency conversion options should be available$")
	public void the_following_Currency_conversion_options_should_be_available(List<String> ListOfCurrencyConversion)
			throws Throwable {
		List<WebElement> ActualCurrencyConversion = login.driver
				.findElements(By.xpath("//select[@name='currency']/option"));
		SeriesDataConversionFunctionsList(ListOfCurrencyConversion, ActualCurrencyConversion);
	}

	@Then("^The following Currency multiples of conversion options should be available$")
	public void the_following_Currency_multiples_of_conversion_options_should_be_available(
			List<String> ListOfConversionUnits) throws Throwable {
		List<WebElement> ActualDataConversionUnits = login.driver
				.findElements(By.xpath("//select[@name='unit']/option"));
		SeriesDataConversionFunctionsList(ListOfConversionUnits, ActualDataConversionUnits);
	}

	@Then("^The following arguments should be available$")
	public void the_following_arguments_should_be_available(List<String> Arguments) throws Throwable {

		ArrayList<String> list = new ArrayList<>();
		List<WebElement> Function_Arguments = login.driver
				.findElements(By.xpath("//*[@class='function-data--description function-data--parameters']/*"));
		for (int i = 0; i < Function_Arguments.size(); i++) {
			list.add(Function_Arguments.get(i).getAttribute("argument"));
		}
		for (String expeted : Arguments) {
			if (list.contains(expeted.toLowerCase())) {
				login.Log4j.info(expeted + " is presented");
			} else {
				fail(expeted + " is not presented");
			}
		}
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		CommonFunctionality.Views_list();
	}

	@And("^Click on Functions dropdown$")
	public void click_on_Functions_dropdown() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='change-series-function']", 5).click();
	}

	@And("^Click on edit series function icon$")
	public void click_on_edit_series_function_icon() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='edit-series-function--icon']", 5).click();
	}

	/*
	 * @Then("^The following months should be available$") public void
	 * the_following_months_should_be_available(List<String> EndDropdownlist) throws
	 * Throwable {
	 * 
	 * CommonFunctionality.getElementByXpath(login.driver,
	 * "//*[@class='function-data--info']//*[@argument='end']//*[@class='select2-container function-parameter--select']"
	 * , 4).click(); List<WebElement> li_all =
	 * login.driver.findElements(By.xpath("//ul[@class='select2-results']/li"));
	 * SeriesDataConversionFunctionsList(EndDropdownlist,li_all); }
	 */
	@Then("^The below \"([^\"]*)\" dropdown options should be available$")
	public void the_below_dropdown_options_should_be_available(String arg1, List<String> DropdownList)
			throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='function-data--info']//*[@argument='" + arg1
				+ "']//*[@class='select2-container function-parameter--select']", 4).click();
		List<WebElement> li_all = login.driver.findElements(By.xpath("//ul[@class='select2-results']/li"));
		SeriesDataConversionFunctionsList(DropdownList, li_all);
	}

	@Then("^Should create pie chart with different freq by disabling highest frequency$")
	public void should_create_pie_chart_with_different_freq_by_disabling_highest_frequency() throws Throwable {
		CommonFunctionality.wait(300);
		WebElement higherFrequency_ele = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='highcharts-legend']/*[1]/*[1]/*[1]", 8);
		WebElement lowerFrequency_ele = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='highcharts-legend']/*[1]/*[1]/*[2]", 8);
		if (higherFrequency_ele.getAttribute("class").contains("highcharts-legend-item-hidden")) {
			new Actions(login.driver).pause(300)
					.moveToElement(login.driver.findElement(
							By.xpath("(//*[@class='series-edit--title series-edit--title__editable'])[1]")))
					.build().perform();
			String tooltipText = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text")))
					.getText();
			String[] lines = tooltipText.split("\n");
			String freq = null;
			for (String Tooltip : lines) {
				// String str=null;
				if (Tooltip.contains("Frequency:")) {
					freq = Tooltip;
					break;
				}
			}
			String[] frequency = freq.split("Frequency: ");
			if (frequency[1].contains("Weekly")) {
				login.Log4j.info("Higher frequency series is disabled");
			} else {
				fail("Higher frequency series is not disabled");
			}
		}
		// mousehover on visual title (moving the cursor position before mouse hover on
		// 2nd legend item)
		new Actions(login.driver).pause(200)
				.moveToElement(login.driver.findElement(By.xpath("//*[@data-name='title']"))).build().perform();
		if (!lowerFrequency_ele.getAttribute("class").contains("highcharts-legend-item-hidden")) {
			CommonFunctionality.wait(500);
			new Actions(login.driver).pause(300)
					.moveToElement(login.driver.findElement(
							By.xpath("(//*[@class='series-edit--title series-edit--title__editable'])[2]")))
					.build().perform();
			String tooltipText = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text")))
					.getText();
			String[] lines = tooltipText.split("\n");
			String freq = null;
			for (String Tooltip : lines) {
				// String str=null;
				if (Tooltip.contains("Frequency:")) {
					freq = Tooltip;
					break;
				}
			}
			String[] frequency = freq.split("Frequency: ");
			if (frequency[1].contains("Annual")) {
				login.Log4j.info("Lower frequency series is enabled");
			} else {
				fail("Lower frequency series is not enabled");
			}
		}
		CommonFunctionality.Views_list();
	}

	@And("^Create a pie visual with series id's \"([^\"]*)\"$")
	public void create_a_pie_visual_with_series_id_s(String arg1) throws Throwable {
		SelectSeries(arg1);
		CommonFunctionality.wait(1500);
		if(arg1.equalsIgnoreCase("16240301")) {
		 sname = CommonFunctionality.getElementByXpath(login.driver,"//*[@class='series-item--name']", 10).getText();
		}
		SeriesCount = login.driver.findElement(By.xpath("//*[@class='series-series-count--number']"));
		login.Log4j.info(SeriesCount.getText());
		create_a_Pie_visual();
		CommonFunctionality.wait(1000);
		Visual_Title_txt = login.driver.findElement(By.xpath("//*[@data-name='title']")).getText();
	}

	@And("^Click on date field$")
	public void click_on_date_field() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'datepicker-input-wrapper--icon')]", 6)
				.click();
	}

	@Then("^Date popup should be displayed$")
	public void date_popup_should_be_displayed() throws Throwable {
		CommonFunctionality.wait(200);
		Boolean date_popup = login.driver
				.findElement(By.xpath("//*[contains(@class,'datepicker datepicker-dropdown dropdown-menu')]"))
				.isDisplayed();
		if (date_popup == true) {
			login.Log4j.info("Date popup is displayed");
		} else {
			fail("Date popup is not displayed");
		}

	}

	@Then("^Select date as \"([^\"]*)\"$")
	public void select_date_as(String arg1) throws Throwable {
		expectedDate = arg1;
		BeforeSelect_date = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='datepicker-input-wrapper']/*[1]", 6).getText();
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='datepicker-years']//*[contains(text(),'" + arg1 + "')]", 6).click();

	}

	@Then("^Selected date should be applied to the visual$")
	public void selected_date_should_be_applied_to_the_visual() throws Throwable {
		List<WebElement> highchart_labels = login.driver
				.findElements(By.xpath("//*[@class='highcharts-label-box highcharts-data-label-box']"));
		System.out.println("Total labels are: " + highchart_labels.size());
		for (int i = 1; i <= highchart_labels.size(); i++) {
			WebElement ele = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[@class='highcharts-label-box highcharts-data-label-box'])[" + i + "]", 4);
			new Actions(login.driver).moveToElement(ele).pause(50).build().perform();
			String date = CommonFunctionality.getElementByXpath(login.driver,
					"//div[contains(@class,'highcharts-label highcharts-tooltip')]//span/*[1]/*[1]//div[@class='table-tooltip--cell text-dots']",
					4).getText();
			if (!date.equals(expectedDate)) {
				fail("Selected date is not applied to the visual");
			}
		}
		login.Log4j.info("Selected date is applied to the visual");
		CommonFunctionality.Views_list();
	}

	@And("^Click on Exclamatory icon of the series which are disabled in pie visual$")
	public void click_on_Exclamatory_icon_of_the_series_which_are_disabled_in_pie_visual() throws Throwable {
		WebElement exclamatoryEle = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='legend-item--marker legend-item--attention']", 6);
		new Actions(login.driver).pause(150).moveToElement(exclamatoryEle).build().perform();
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'Convert it to any other frequency')]", 6)
				.click();
	}

	@And("^Select frequency as \"([^\"]*)\"$")
	public void select_frequency_as(String arg1) throws Throwable {
		CommonFunctionality.wait(300);
		Select select = new Select(
				CommonFunctionality.getElementByXpath(login.driver, "//select[@name='frequency']", 4));
		select.selectByValue("D");
		CommonFunctionality.getElementBycssSelector(login.driver, ".movable-modal--window .button__primary", 4).click();
	}

	@Then("^Should be able to turn all series frequency into desired frequency$")
	public void should_be_able_to_turn_all_series_frequency_into_desired_frequency() throws Throwable {
		CommonFunctionality.wait(300);
		List<WebElement> legend_items = login.driver
				.findElements(By.xpath("//*[@class='series-edit--title series-edit--title__editable']"));
		if (login.driver.findElements(By.xpath("//*[@class='legend-item--marker legend-item--attention']"))
				.size() == 0) {
			for (int i = 0; i < legend_items.size(); i++) {
				new Actions(login.driver).pause(300).moveToElement(legend_items.get(i)).build().perform();
				String tooltipText = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text")))
						.getText();
				String[] lines = tooltipText.split("\n");
				String freq = null;
				for (String Tooltip : lines) {
					// String str=null;
					if (Tooltip.contains("Frequency:")) {
						freq = Tooltip;
						break;
					}
				}
				String[] frequency = freq.split("Frequency: ");
				if (!frequency[1].contains("Daily")) {
					fail("Verification failed");
				}
				// mousehover on visual title (moving the cursor position before mouse hover on
				// 2nd legend item)
				new Actions(login.driver).pause(200)
						.moveToElement(login.driver.findElement(By.xpath("//*[@data-name='title']"))).build().perform();
			}
			login.Log4j.info("Both series having same frequency");
			CommonFunctionality.Views_list();
		}
	}

	@And("^Double click on timepoints$")
	public void double_click_on_timepoints() throws Throwable {
		WebElement ele = CommonFunctionality.getElementByXpath(login.driver,
				"(//*[@class='highcharts-label-box highcharts-data-label-box'])[1]", 4);
		new Actions(login.driver).pause(300).doubleClick(ele).build().perform();
	}

	@Then("^The label color should update as Orange$")
	public void the_label_color_should_update_as_Orange() throws Throwable {
		CommonFunctionality.wait(500);
		String backgroundColor = CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1']", 20)
				.getCssValue("background-color");
		commentary.ColorValidation(backgroundColor);
		CommonFunctionality.DeleteVisual();
	}

	@Then("^The Labels popup should be displayed$")
	public void the_Labels_popup_should_be_displayed() throws Throwable {
		CommonFunctionality.wait(300);

		String Title_txt = CommonFunctionality.getElementByClassName(login.driver, "popover--title", 4).getText();
		if (Title_txt.equals("Labels")) {
			login.Log4j.info("Labels popup is displayed");
		} else {
			Assert.fail("Labels popup is NOT displayed");
		}
	}

	@Then("^Number of selected series count should be displayed on the rename popup header$")
	public void number_of_selected_series_count_should_be_displayed_on_the_rename_popup_header() throws Throwable {
		hs.number_of_selected_series_count_should_be_shown_on_the_rename_popup_header(SeriesCount);
	}

	@Then("^Number of available series count should be shown under the find field$")
	public void number_of_available_series_count_should_be_shown_under_the_find_field() throws Throwable {
		WebElement NumOfMatches = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='find-and-replace--panel-matches']", 5);
		if (NumOfMatches.isDisplayed()) {
			login.Log4j.info(NumOfMatches.getText());
			String[] numberOfItems = NumOfMatches.getText().split(" ");
			if (SeriesCount.getText().equals(numberOfItems[0])) {
				login.Log4j.info("Number of available series count shown under the find field");
				CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 4).click();
				CommonFunctionality.Views_list();
			}
		} else {
			Assert.fail("The total number of matches result is not displayedd");
		}
	}

	@And("^Enter the keyword you want to rename$")
	public void enter_the_keyword_you_want_to_rename() throws Throwable {
		SearchKeyword = "GDP";
		CommonFunctionality.wait(200);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='find-and-replace--panel-search-box']/*[1]", 6)
				.sendKeys(SearchKeyword);
	}

	@And("^Enter the keyword you want to replace with$")
	public void enter_the_keyword_you_want_to_replace_with() throws Throwable {
		ReplaceKeyword = "Gold";
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(@class,'find-and-replace--panel-replace-input')]", 5)
				.sendKeys(ReplaceKeyword);
	}

	@Then("^All the available series should be replaced with the keyword$")
	public void all_the_available_series_should_be_replaced_with_the_keyword() throws Throwable {
		// the_keyword_should_be_replaced_for_selected_series();
		CommonFunctionality.wait(1000);
		List<WebElement> list = login.driver.findElements(By.xpath("//*[@class='find-and-replace-item--name']//input"));
		for (int i = 0; i < list.size(); i++) {
			String ReplacedSeries = list.get(i).getAttribute("value");
			login.Log4j.info(ReplacedSeries);
			if (!ReplacedSeries.contains(ReplaceKeyword)) {
				Assert.fail("Verification is failed");
			}
		}
		login.Log4j.info("All the available series replaced with the keyword");
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 4).click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='sphere-modal-controls']//button[contains(text(),'Ok')]", 5).click();
		CommonFunctionality.Views_list();

	}

	@And("^Add series to the my series tab and Apply function$")
	public void add_series_to_the_my_series_tab_and_Apply_function() throws Throwable {
		st.user_enters_seriesID("7872901;7874601");
		st.click_on_icon_on_series();
		hs.apply_function_for_a_series();
	}

	@Then("^The function toolbar should be hidden$")
	public void the_function_toolbar_should_be_hidden() throws Throwable {
		// verify if function tool bar is hidden
		CommonFunctionality.wait(400);
		WebElement function_panel = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='visual-series-panel--function-editor']/*", 5);
		if (function_panel.getAttribute("class").contains("series-functions-panel__fx-closed")) {
			login.Log4j.info("The function toolbar is hidden");
			st.click_on("Show the function bar");
		} else {
			fail("The function toolbar is not hidden");
		}

	}

	@Then("^The function toolbar should be shown$")
	public void the_function_toolbar_should_be_shown() throws Throwable {
		// verify if function tool bar is hidden or not
		WebElement function_panel = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='visual-series-panel--function-editor']/*", 5);
		if (!function_panel.getAttribute("class").contains("series-functions-panel__fx-closed")) {
			login.Log4j.info("The function toolbar is shown");
		} else {
			fail("The function toolbar is not shown");
		}
	}

	@Then("^Selected color should be applied to the series$")
	public void selected_color_should_be_applied_to_the_series() throws Throwable {
		CommonFunctionality.wait(1000);
		String background_color = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='visual-series-color']/*[1]/*[1]", 6)
				.getCssValue("background-color");
		commentary.ColorValidation(background_color);
	}

	@And("^Click on \"([^\"]*)\" icon before name attribute$")
	public void click_on_icon_before_name_attribute(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		// List of series on edit series panel before click on Delete series icon
		Series_list_EditSeriesPanel = login.driver.findElements(By.xpath("//*[@class='series-name--title']"));
		// List of series in pie visual
		Series_list_pieVisual = login.driver
				.findElements(By.xpath("//*[@class='series-edit--title series-edit--title__editable']"));
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='table--cell table--header-cell']/*[@title='" + arg1 + "']", 6).click();
	}

	@Then("^All the series should be removed from the visual and edit series panel$")
	public void all_the_series_should_be_removed_from_the_visual_and_edit_series_panel() throws Throwable {
		CommonFunctionality.wait(1000);
		// List of series on edit series panel after click on Delete series icon
		List<WebElement> Expected_list1 = login.driver.findElements(By.xpath("//*[@class='series-name--title']"));
		// List of series in pie visual after click on Delete series icon
		List<WebElement> Expected_list2 = login.driver
				.findElements(By.xpath("//*[@class='series-edit--title series-edit--title__editable']"));
		if (Expected_list1.size() == 0 && Expected_list2.size() == 0) {

			if (!(Series_list_EditSeriesPanel.size() == Expected_list1.size())
					&& !(Series_list_pieVisual.size() == Expected_list2.size())) {
				login.Log4j.info("All the series has been removed from the edit series panel and visual");
			} else {
				fail("All the series has not been removed from the edit series panel and visual");
			}
		} else {
			fail("Verification failed");
		}

	}

	@And("^Click on x icon to close the edit seires panel$")
	public void click_on_x_icon_to_close_the_edit_seires_panel() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='sidebar-panel--header-close']", 6).click();
	}

	@Then("^The edit series panel should be closed$")
	public void the_edit_series_panel_should_be_closed() throws Throwable {
		CommonFunctionality.wait(300);
		// if edit series panel is not closed
		if (login.driver.findElements(By.xpath("//*[@class='sidebar-panel sidebar-panel__opened']")).size() == 0) {
			login.Log4j.info("The edit series panel is closed");
		} else {
			fail("The edit series panel is not closed");
		}
	}

	@And("^Make any changes in edit visual$")
	public void make_any_changes_in_edit_visual() throws Throwable {
		CommonFunctionality.wait(1000);
		// unselect legend check box option
		Boolean isChecked = login.driver
				.findElement(By.xpath(
						"//*[@title='Legend. Configure the settings of the chart legend.']//input[@type='checkbox']"))
				.isSelected();
		if (isChecked == true) {
			new Actions(login.driver).moveToElement(login.driver.findElement(By.xpath(
					"//*[@title='Legend. Configure the settings of the chart legend.']//span[@class='input-control--indicator']")))
					.click().perform();
		} else {
			// Assert.fail("Show check box is not selected");
		}
	}

	@And("^UnCheck Legend option$")
	public void uncheck_Legend_option() throws Throwable {
		make_any_changes_in_edit_visual();
	}

	@Then("^\"([^\"]*)\" popup should be diaplayed$")
	public void popup_should_be_diaplayed(String confirmation) throws Throwable {
		CommonFunctionality.wait(1000);
		Assert.assertEquals(
				login.driver.findElement(By.xpath("//*[@class='modal-title sphere-modal__title text-dots']")).getText()
						.contains(confirmation),
				true);

		// Close confirmation popup
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 10).click();
		db.click_on_icon("Delete template");
		st.click_on("Ok");
	}

	@And("^Check Pie for \"([^\"]*)\"$")
	public void check_Pie_for(String arg1) throws Throwable {
		hs.CheckHistogram(arg1);
	}

	@Then("^The pie border \"([^\"]*)\" should be updated to \"([^\"]*)\"$")
	public void the_pie_border_should_be_updated_to(String arg1, String arg2) throws Throwable {
		Thread.sleep(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//button[text()='Save']", 6).click();
		if (arg1.equals("Width")) {
			String ActualWidth;
			ActualWidth = login.driver.findElement(By.xpath("//*[@class='highcharts-plot-border']"))
					.getCssValue("stroke-width");
			login.Log4j.info(ActualWidth);
			commentary.FontSizeValidation(ActualWidth, arg2);
		}

		CommonFunctionality.Views_list();
	}

	@And("^Select Radius as (\\d+)$")
	public void select_Radius_as(int radius) throws Throwable {
		CommonFunctionality.wait(500);
		String BorderRadius = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='spinner-control']//*[contains(@name,'border_radius')]", 6)
				.getAttribute("aria-valuenow");

		int length = radius - Integer.parseInt(BorderRadius);

		for (int i = 1; i <= length; i++) {
			Thread.sleep(300);

			login.driver
					.findElement(By.xpath(
							"(//*[@class='border-settings--container']//button[contains(@class,'ui-spinner-up')])[2]"))
					.click();

		}
	}

	@Then("^Radius should be updated to (\\d+) on pie$")
	public void radius_should_be_updated_to_on_pie(int arg1) throws Throwable {
		Thread.sleep(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//button[text()='Save']", 6).click();
		Thread.sleep(2000);
		String ActualRadius = login.driver.findElement(By.xpath("//*[@class='highcharts-plot-border']"))
				.getCssValue("rx");
		login.Log4j.info(ActualRadius);
		if (ActualRadius.contains(Integer.toString(arg1))) {
			login.Log4j.info("PASS");
		} else {
			Assert.fail("Verification is failed");
		}
		CommonFunctionality.Views_list();
	}
	@And("^Create Pie empty visual$")
	public void create_Pie_empty_visual() throws Throwable {
		create_a_Pie_visual();
	}

	@And("^Redirect to MySeries tab > Select a series$")
	public void redirect_to_MySeries_tab_Select_a_series() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@data-page='myseries']/*", 6).click();
		List<WebElement> series_list = login.driver.findElements(By.xpath("//*[@class='series-name-wrapper ']"));
		for (int i = 0; i < series_list.size();) {
			int j = i + 1;
			CommonFunctionality.wait(300);
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-name-wrapper '][" + j + "]/*[1]", 6)
					.click();
			ExpectedSname = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='series-name-wrapper '][" + j + "]//*[@class='series-name-field--series-name']", 6)
					.getText();
			break;
		}
	}

	@Then("^The selected series should be displayed in Table tab$")
	public void the_selected_series_should_be_displayed_in_Table_tab() throws Throwable {
		//select view tab
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='View 1']", 6).click();
		//Click on edit series
		hs.click_on_Edit_series_option();
		//select Table tab in edit series panel
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='data-selection-panel']//*[text()='Table']", 6).click();
		String ActualSName = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='table-series--name ']/*[2]", 6).getText();
		if(ActualSName.equalsIgnoreCase(ExpectedSname)) {
			login.Log4j.info("The selected series displayed in Table tab");
		} else {
			fail("The selected series not displayed in Table tab");
		}
		
	    
	}

	@And("^Select more than (\\d+) series and try to create Pie visual$")
	public void select_more_than_series_and_try_to_create_Pie_visual(int arg1) throws Throwable {
		WebElement SeriesTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(login.LOCATORS.getProperty("Series"))));
		SeriesTab.click();
		CommonFunctionality.wait(2000);
		List<WebElement> ListOfSeries = login.driver.findElements(By.xpath("//*[@class='series-item--name']"));
		List<WebElement> checkBox = login.driver.findElements(By.xpath("//div[@class='series-list-item--checkbox-wrapper']"));
		if (ListOfSeries.size() > 0) {
			for (int i = 0; i < ListOfSeries.size(); i++) {
				Thread.sleep(800);
				new Actions(login.driver).moveToElement(checkBox.get(i)).click().build().perform();
				// Until the element is not visible keep scrolling
				jse.executeScript("arguments[0].scrollIntoView(true);", ListOfSeries.get(i));
				if(i == 22) {
					break;
				}
			}
		} else {
			fail("No search elements found here");
		}
		create_a_Pie_visual();
	}

	@Then("^Pie should allow max (\\d+) series$")
	public void pie_should_allow_max_series(int arg1) throws Throwable {
		CommonFunctionality.wait(400);
		Boolean confirmation_popup = login.driver.findElement(By.xpath("//*[text()='Confirmation']")).isDisplayed();
		if(confirmation_popup == true) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[text()='Ok']", 6).click();
			CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Close']", 6).click();
		}
		List<WebElement> visualCreatedWith_maxNumSeries = login.driver.findElements(By.xpath("//*[@class='legend-item']"));
		if(visualCreatedWith_maxNumSeries.size() == arg1) {
			login.Log4j.info("Pie visual created with max no.of series");
		} else {
			fail("Failed to create a pie visual with max no.of series");
		}
	}
	@Then("^By default checked sort by should be applied$")
	public void by_default_checked_sort_by_should_be_applied() throws Throwable {
	   Boolean checked = login.driver.findElement(By.xpath("//*[text()='Checked']")).isDisplayed();
	   if(checked == true) {
		   login.Log4j.info("By default checked option is appliedd");
	   } else {
		   fail("By default checked option is not applied");
	   }
	}
	@And("^Create a new pie visual$")
	public void create_a_new_pie_visual() throws Throwable {
		CommonFunctionality.ResetMethod();
		create_a_pie_visual_with_series_id_s("16240301");
	}

	@Then("^The Pie should be created with the format of previous template selection$")
	public void the_Pie_should_be_created_with_the_format_of_previous_template_selection() throws Throwable {
		//if Legend checkbox off
		CommonFunctionality.wait(2000);
//		Boolean Series = login.driver
//				.findElement(By.xpath("(//*[@class='highcharts-axis-labels highcharts-xaxis-labels'])[1]"))
//				.isDisplayed();
		
		
		if (login.driver
				.findElements(By.xpath("//*[@class='visual-item']//*[@class='series-edit--title series-edit--title__editable']")).size() == 0                          ) {
			login.Log4j.info("Legend items has been removed from the visual");
		} else {
			Assert.fail("Legend items has not been removed from the visual");
		}
	}
	@And("^Mouse move on existing visual templates$")
	public void mouse_move_on_existing_visual_templates() throws Throwable {
		 arg = "NewTemplate";
		 WebElement add_template = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'add-style-template')]", 8);
			
			try {
				//if add icon is active
				if (add_template.getAttribute("class").contains("add-style-template__active")) {
					add_template.click();
					hs.enter_new_template_name_as(arg);
					hs.click_on_green_tick_mark();
					//if template already exists with the same name
					try {
						CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 20).click();
					} catch(Exception e) {
						
					}
				
					make_any_changes_in_edit_visual();
					
				} else {
					make_any_changes_in_edit_visual();
					add_template.click();
					hs.enter_new_template_name_as(arg);
					hs.click_on_green_tick_mark();
					//if template already exists with the same name
					try {
						CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 20).click();
					} catch(Exception e) {
						
					}
					
				}
			} catch(Exception e) {
				
			}	
						
		WebElement template = CommonFunctionality.getElementByXpath(login.driver, "(//*[@title='" + arg + "'])[2]", 20);
		new Actions(login.driver).pause(500).moveToElement(template).build().perform();
	}
	@Then("^The pie should be created with default format template$")
	public void the_pie_should_be_created_with_default_format_template() throws Throwable {
		CommonFunctionality.wait(2000);
	
		if (!(login.driver
				.findElements(By.xpath("//*[@class='visual-item']//*[@class='series-edit--title series-edit--title__editable']")).size() == 0)                          ) {
			login.Log4j.info("Legend items shown on the visual");
		} else {
			Assert.fail("Legend items not shown on the visual");
		}
//		st.click_on("Edit Pie");
//		db.click_on_icon("Delete template");
//		CommonFunctionality.getElementByXpath(login.driver,"//*[@class='modal-window modal-window__active']//*[contains(text(),'Ok')]", 20).click();
//		st.click_on("Save");
	}
	void SeriesDataConversionFunctionsList(List<String> ExpectedfunctionsList, List<WebElement> ActualfunctionsList)
			throws Exception {
		int j = 0;
		for (String expectedStr : ExpectedfunctionsList) {
			for (int i = j; i < ActualfunctionsList.size();) {
				if (ActualfunctionsList.get(i).getText().contains(expectedStr)) {
					login.Log4j.info(expectedStr + " is presented");

				} else {
					fail(expectedStr + " is not presented");
				}
				j = i + 1;
				break;
			}
		}
		// CommonFunctionality.wait(500);
		// CommonFunctionality.getElementByXpath(login.driver,
		// "//*[contains(@class,'movable-modal__active')]//*[@class='movable-modal--close']",
		// 4).click();
		// CommonFunctionality.Views_list();
	}

	void CurrencyConversion_method(String currency, String unit) throws Exception {
		CommonFunctionality.wait
				.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()='Series Harmonization']")));
		List<WebElement> series = login.driver.findElements(By.cssSelector(".series-edit--title__editable"));
		for (int i = 1; i <= series.size(); i++) {
			WebElement series_one = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[contains(@class,'series-edit--title__editable')])[" + i + "]", 4);
			new Actions(login.driver).moveToElement(series_one).pause(100).build().perform();
			String actual = CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(text(),'Functions:')]/following-sibling::*", 4)
					.getText();
			if (!actual.contains(currency) && !actual.contains(unit)) {
				fail("Verification Failed");
			}
			/*
			 * if (currency.equalsIgnoreCase("Chinese Yuan (RMB)")) { String split[] =
			 * actual.split("; "); login.Log4j.info(split[0]); login.Log4j.info(split[1]); }
			 * else { String split[] = actual.split("\\("); login.Log4j.info(split[1]);
			 * String[] next_split = split[1].split("\\)"); login.Log4j.info(next_split[0]);
			 * String[] final_split = next_split[0].split("; "); if
			 * (actual.contains(currency) && actual.contains(unit)) {
			 * fail("Verification Failed"); } }
			 */

		}
		login.Log4j.info(currency + " is converted " + unit + " for series in visual pie");
		CommonFunctionality.Views_list();

	}

	void SelectSeries(String sid) throws Exception {
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(sid);
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		CommonFunctionality.wait(6000);
		CommonFunctionality.webDriverwait_keyvalue("Series");
		CommonFunctionality.getElementByProperty(login.driver, "Series", 8).click();
		CommonFunctionality.wait(3000);

		List<WebElement> list2 = login.driver.findElements(
				By.xpath("//ul[@class='search-series-list']//*[contains(@class,'series-search-list-item')]"));
		for (int i = 1; i <= list2.size(); i++) {
			WebElement series = login.driver.findElement(
					By.xpath("//ul[@class='search-series-list']//*[contains(@class,'series-search-list-item')][" + i
							+ "]/div/a/div[2]/span/*"));
			new Actions(login.driver).moveToElement(series).pause(1000).click().build().perform();
		}
	}
}
