package CDMNext.StepDefinations;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
//import java.util.NoSuchElementException;
import java.util.regex.Pattern;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import CDMNext.util.CommonFunctionality;
import Javaxlxs.File_delete;
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
	String BeforeSelect_date, expectedDate, SearchKeyword, ReplaceKeyword, ExpectedSname, arg, Appliedfunction;
	public static String sname,BackgroundColor,BorderColor,LabelColor,HighlightColor;
	WebElement SeriesCount;
	static String Visual_Title_txt;
	List<WebElement> Series_list_EditSeriesPanel;
	List<WebElement> Series_list_pieVisual;
	WebDriverWait wait = new WebDriverWait(login.driver, 2000);
	JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	Map map = new Map();

	@SuppressWarnings("deprecation")
	@And("^Select different frequency series \"([^\"]*)\" and click on \"([^\"]*)\" icon$")
	public void select_different_frequency_series_and_click_on_icon(String arg1, String arg2) throws Throwable {
	
		// CommonFunctionality.webDriverwait_keyvalue("Series_tab");
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_tab"))).click();
		CommonFunctionality.webDriverwait_keyvalue("Series_new");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_new"))).click();
		// CommonFunctionality.getElementByClassName(login.driver, "search-input-text",
		// 4).clear();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(arg1);
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		CommonFunctionality.wait
				.until(ExpectedConditions.invisibilityOfElementLocated(By.className("blocker--loader")));
		List<WebElement> total_count = login.driver.findElements(
				By.xpath("//*[@class='series-representation--list']//div[contains(@class,'series-search-list-item')]"));
		for (int i = 0; i < total_count.size(); i++) {
//			WebElement unselect_check = CommonFunctionality.getElementByXpath(login.driver,
//					"//*[@class='search-series-list']//div[contains(@class,'series-search-list-item')][" + i + "]", 4);
			int j = i + 1;
			WebElement unselect_check = total_count.get(i);
			WebElement series = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[@class='series-representation--list']//div[@class='series-list-item--checkbox-wrapper']//span[contains(@class,'series-list-item--checkbox')])["
							+ j + "]",
					4);
			if (!(unselect_check.getAttribute("class").contains("series-list-item__selected"))) {
				new Actions(login.driver).moveToElement(series).pause(100).click().build().perform();
			}
		}
		if (arg2.equalsIgnoreCase("Pie")) {
			cv.click_on_more_actions();
			new Actions(login.driver).moveToElement(
					CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Add chart')]", 4))
					.build().perform();
			new Actions(login.driver)
					.moveToElement(
							CommonFunctionality.getElementByProperty(login.driver, "PieIcon", 4))
					.pause(1000).click().build().perform();
		} else if(arg2.equals("Map")) {
			EmptyView.click_on_View_tab();
			CommonFunctionality.wait(500);
			map.click_on_Map_visual_icon();
			CommonFunctionality.wait(500);
		}
	}

	@And("^Hovor on Insert Pie$")
	public void hovor_on_Insert_Pie() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "AddChart", 4).click();
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
		
		Select frequency = new Select(login.driver.findElement(By.name("frequency")));
		frequency.selectByValue("W");
		CommonFunctionality.getElementByClassName(login.driver, "edit-series-function--icon", 4).click();
		/*String text = CommonFunctionality.getElementBycssSelector(login.driver,
				"div[argument='end'] .function-parameter--body .select2-chosen", 4).getText();
		assertEquals(text, "December");*/
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='function-data--info']//*[@argument='end']//*[@class='select2-container function-parameter--select']",
				4).click();
		List<WebElement> listOfDays = login.driver.findElements(By.xpath("//ul[@class='select2-results']/li"));
		if (listOfDays.size() != 0) {
			for (int i = 1 ; i < listOfDays.size() ; ){
				String text1 = listOfDays.get(i).getText();
				System.out.println(text1);
				listOfDays.get(i).click();
				String selected_day = CommonFunctionality.getElementByXpath(login.driver, "//*[@argument='end']//*[@class='select2-chosen']", 10).getText();
				if(selected_day.equalsIgnoreCase(text1)) {
					login.Log4j.info("The number of days is selectable in frequency end dropdown");
				} else {
					fail("verification failed");
				}
				
				break;
			}
		} else {
			fail("Failed");
		}
	
		// new
		// Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
		// "(//*[@class='function-data--info']//*[contains(text(),'Last day of
		// month')]/following::span[1])[1]",
		// 4)).click().build().perform();
		// CommonFunctionality.getElementBycssSelector(login.driver,
		// ".edit-series-function--icon", 4).click();
	//	CommonFunctionality.getElementBycssSelector(login.driver, ".movable-modal--window .button__primary", 4).click();
		//CommonFunctionality.Views_list();
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
		CommonFunctionality.wait(2000);
		List<WebElement> series_all = login.driver.findElements(By.cssSelector(".series-edit--title__editable"));
		// for (int i = series_all.size(); i >= 1; i--) {
		for (int i = 1; i <= series_all.size(); i++) {
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
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Rename']", 4).click();
		List<WebElement> rename = login.driver.findElements(By.className("find-and-replace--modal-title"));
		assertEquals(1, rename.size());
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		CommonFunctionality.Views_list();
		System.out.println("The Edit series options are verified");
	}

	@Then("^US currency should be applicable for series in visual pie$")
	public void us_currency_should_be_applicable_for_series_in_visual_pie() throws Throwable {
		CommonFunctionality.wait
				.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()='Series Harmonization']")));
		List<WebElement> series = login.driver.findElements(By.cssSelector(".series-edit--title__editable"));
		for (int i = 1; i <= series.size(); i++) {
			WebElement series_one = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[contains(@class,'series-edit--title__editable')])[" + i + "]", 4);
			
		/*	new Actions(login.driver).moveToElement(series_one).pause(100).build().perform();
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
			}*/
			String actual = series_one.getText();
			if (!actual.contains("US Dollars")) {
				fail("Verification Failed");
			}
			
		}
			
		//CommonFunctionality.Views_list();
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
		// CommonFunctionality.Views_list();
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
		EmptyView.click_on_View_tab();
		CommonFunctionality.getElementByProperty(login.driver, "AddChart", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "PieIcon", 4).click();
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
		List<WebElement> optionsPresented = login.driver.findElements(By.xpath(
				"//*[@class='series-data-conversion--functions-list']/*/*[1] | //*[@class='chart-legend-config']/*//*[@class='title']"));
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
				.findElements(By.xpath("//*[@class='function-data--description function-data--parameters']//*[@class='function-parameter--title']"));
		for (int i = 0; i < Function_Arguments.size(); i++) {
			list.add(Function_Arguments.get(i).getText());
		}
		for (String expected : Arguments) {
			if (list.contains(expected)) {
				login.Log4j.info(expected + " is presented");
			} else {
				fail(expected + " is not presented");
			}
		}
		//CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		//CommonFunctionality.Views_list();
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
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'function-data--info')]//*[@argument='" + arg1
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
			String series1 = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[@class='series-edit--title series-edit--title__editable'])[1]", 8).getText();
			/*new Actions(login.driver).pause(300)
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
			String[] frequency = freq.split("Frequency: ");*/
			if (series1.contains("Weekly")) {
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
			String series2 = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[@class='series-edit--title series-edit--title__editable'])[1]", 8).getText();
			/*new Actions(login.driver).pause(300)
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
			String[] frequency = freq.split("Frequency: ");*/
			if (series2.contains("Annual")) {
				login.Log4j.info("Lower frequency series is enabled");
			} else {
				fail("Lower frequency series is not enabled");
			}
		}
		//CommonFunctionality.Views_list();
	}

	@And("^Create a pie visual with series id's \"([^\"]*)\"$")
	public void create_a_pie_visual_with_series_id_s(String arg1) throws Throwable {
		SelectSeries(arg1);
		CommonFunctionality.wait(1500);
		if (arg1.equalsIgnoreCase("16240301")) {
			sname = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-item--name']", 10)
					.getText();
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

	@And("^Click on date filed in edit visual$")
	public void click_on_date_filed_in_edit_visual() throws Throwable {
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[@class='visual-configuration']//*[contains(@class,'datepicker-input-wrapper--icon')]", 6)
				.click();
	}

	@Then("^Select date as \"([^\"]*)\" in edit visual popup$")
	public void select_date_as_in_edit_visual_popup(String arg1) throws Throwable {
		expectedDate = arg1;
		
		try {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='datepicker-years']//*[contains(text(),'" + arg1 + "')]", 6).click();
		} catch (Exception e) {
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='datepicker-years']//*[@class='prev-arrow']", 6)
					.click();
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='datepicker-years']//*[contains(text(),'" + arg1 + "')]", 6).click();
		}
//		CommonFunctionality.getElementByXpath(login.driver,
//				"//*[@class='datepicker-years']//*[contains(text(),'" + arg1 + "')]", 6).click();
	}

	@Then("^Selected date should be applied to the edit visual$")
	public void selected_date_should_be_applied_to_the_edit_visual() throws Throwable {
		CommonFunctionality.wait(500);
		List<WebElement> highchart_labels = login.driver.findElements(By.xpath(
				"//*[@class='visual-configuration']//*[@class='highcharts-label-box highcharts-data-label-box']"));
		System.out.println("Total labels are: " + highchart_labels.size());
		for (int i = 1; i <= highchart_labels.size(); i++) {
			WebElement ele = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[@class='visual-configuration']//*[@class='highcharts-label-box highcharts-data-label-box'])["
							+ i + "]",
					4);
			new Actions(login.driver).moveToElement(ele).pause(50).build().perform();
			String date = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'movable-modal__active')]//*[contains(@class,'highcharts-label highcharts-data-label')]//following::*[@class='table-tooltip']/*[1]/*[2]",
					4).getText();
			if (!date.contains(expectedDate)) {
				fail("Selected date is not applied to the visual");
			}
		}
		login.Log4j.info("Selected date is applied to the visual");

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
		try {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='datepicker-years']//*[contains(text(),'" + arg1 + "')]", 6).click();
		} catch (Exception e) {
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='datepicker-years']//*[@class='prev-arrow']", 6)
					.click();
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='datepicker-years']//*[contains(text(),'" + arg1 + "')]", 6).click();
		}

	}

	@Then("^Selected date should be applied to the visual$")
	public void selected_date_should_be_applied_to_the_visual() throws Throwable {
		CommonFunctionality.wait(500);
		List<WebElement> highchart_labels = login.driver
				.findElements(By.xpath("//*[@class='highcharts-label-box highcharts-data-label-box']"));
		System.out.println("Total labels are: " + highchart_labels.size());
		for (int i = 1; i < highchart_labels.size(); i++) {
			WebElement ele = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[@class='highcharts-label-box highcharts-data-label-box'])[" + i + "]", 8);
			new Actions(login.driver).moveToElement(ele).pause(50).build().perform();
			String date = CommonFunctionality.getElementByXpath(login.driver,
					"//div[contains(@class,'highcharts-label highcharts-tooltip')]//span/*[1]/*[1]//div[@class='table-tooltip--cell table-tooltip--cell__cut text-dots']",
					4).getText();
			if (!date.contains(expectedDate)) {
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
		CommonFunctionality.wait(3000);
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
				"(//div[@class='preview-container']//div[@class='visual-item-container']//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0'])[5]//*", 4);
		new Actions(login.driver).pause(300).doubleClick(ele).build().perform();
	}

	@Then("^The label color should update as Orange$")
	public static void the_label_color_should_update_as_Orange() throws Throwable {
		CommonFunctionality.wait(500);
		String backgroundColor = CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1']", 20)
				.getCssValue("background-color");
		Commentary.ColorValidation(backgroundColor, Commentary.ActualColor);
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

	@And("^Double click on timepoints in the edit visual$")
	public void double_click_on_timepoints_in_the_edit_visual() throws Throwable {
		WebElement ele = CommonFunctionality.getElementByXpath(login.driver,
				"(//*[@class='visual-configuration']//*[@class='highcharts-label-box highcharts-data-label-box'])[1]",
				4);
		new Actions(login.driver).pause(300).doubleClick(ele).build().perform();
	}

	@Then("^The label color should update as Orange in the edit visual$")
	public void the_label_color_should_update_as_Orange_in_the_edit_visual() throws Throwable {
		CommonFunctionality.wait(500);
		String backgroundColor = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='visual-configuration']//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0']",
				20).getCssValue("background-color");
		Commentary.ColorValidation(backgroundColor, Commentary.ActualColor);
		CommonFunctionality.DeleteVisual();

	}

	@And("^Click on Series$")
	public void click_on_Series() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-name--title']", 6).click();
	}

	@And("^Click on cogwheel icon$")
	public void click_on_cogwheel_icon() throws Throwable {
		
		WebElement mousehoverLegend = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='visual-configuration']//*[@class='legend-item--marker'] | //*[@class='visual-configuration']//*[contains(@class,'legend-item--hide-series')]", 6);
		jse.executeScript("arguments[0].scrollIntoView(true);", mousehoverLegend);
		new Actions(login.driver).pause(500).moveToElement(mousehoverLegend).perform();
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[@class='visual-configuration']//*[@class='legend-item ']//*[@title='Edit series']", 20)
				.click();
	}

	@And("^Click on Remove series$")
	public void click_on_Remove_series() throws Throwable {
		WebElement mousehoverLegend = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='visual-configuration']//*[@class='legend-item--marker'] | //*[@class='visual-configuration']//*[contains(@class,'legend-item--hide-series')]", 6);
		jse.executeScript("arguments[0].scrollIntoView(true);", mousehoverLegend);
		new Actions(login.driver).pause(500).moveToElement(mousehoverLegend).perform();
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[@class='visual-configuration']//*[@class='legend-item ']//*[@title='Remove series']", 8)
				.click();
	}

	@Then("^The series should be removed from the edit visual$")
	public void the_series_should_be_removed_from_the_edit_visual() throws Throwable {
		CommonFunctionality.wait(500);
		if (login.driver.findElements(By.xpath(
				"//*[@class='visual-configuration']//*[@class='series-edit--title series-edit--title__editable']"))
				.size() == 0) {
			login.Log4j.info("Selected series is removed from table visual in preview title");
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']"))
					.size() > 0) {
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']", 4).click();
			}
		}
	}

	@Then("^Number of selected series count should be displayed on the rename popup header$")
	public void number_of_selected_series_count_should_be_displayed_on_the_rename_popup_header() throws Throwable {
		CommonFunctionality.wait(1300);
		WebElement str = login.driver.findElement(By.xpath("//*[@class='find-and-replace--modal-title-info']"));
		login.Log4j.info(str.getText());
		login.Log4j.info(SeriesCount.getText());
		if (str.getText().contains(SeriesCount.getText())) {
			login.Log4j.info("Number of selected series count is shown on the rename popup header");
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 6).click();
			CommonFunctionality.Views_list();
		} else {
			Assert.fail("Number of selected series count is not shown on the rename popup header");
		}
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
		CommonFunctionality.wait(800);
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='sphere-modal-controls']//button[contains(text(),'Ok')]", 5).click();
		//CommonFunctionality.Views_list();

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
				.getElementByXpath(login.driver, "//*[@class='visual-series-color']/*[1]/*[1]/*", 6)
				.getCssValue("background-color");
		try {
		Commentary.ColorValidation(background_color,Histogram.TitleColor);
		}catch(NullPointerException e) {
			Commentary.ColorValidation(background_color,DatabasesTab.ActualColor);
		}
	}
	/*
	 * @Then("^Selected color should be applied to the series in the edit visual$")
	 * public void
	 * selected_color_should_be_applied_to_the_series_in_the_edit_visual() throws
	 * Throwable { CommonFunctionality.wait(1000); String background_color =
	 * CommonFunctionality .getElementByXpath(login.driver,
	 * "//*[@class='visual-series-color']/*[1]/*[1]", 6)
	 * .getCssValue("background-color"); String ExpectedColor =
	 * Color.fromString(background_color).asHex(); login.Log4j.info(ExpectedColor);
	 * Assert.assertEquals(hs.function, ExpectedColor); }
	 */

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
		CommonFunctionality.wait(500);
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
						"//*[@title='Legend. Configure the settings of the chart legend.']//input[@type='checkbox'] | //*[@title='Legend. Configure the settings of the map legend.']//input[@type='checkbox']"))
				.isSelected();
		if (isChecked == true) {
			new Actions(login.driver).moveToElement(login.driver.findElement(By.xpath(
					"//*[@title='Legend. Configure the settings of the chart legend.']//input[@type='checkbox'] | //*[@title='Legend. Configure the settings of the map legend.']//input[@type='checkbox']")))
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
			CommonFunctionality.wait(2000);
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
		// select view tab
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='View 1']", 6).click();
		// Click on edit series
		hs.click_on_Edit_series_option();
		// select Table tab in edit series panel
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='data-selection-panel']//*[@class='toggler-control-wrapper']/*/*[2]", 6)
				.click();
		String ActualSName = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='table-series--name  ']/*[2]", 6).getText();
		if (ActualSName.equalsIgnoreCase(ExpectedSname)) {
			login.Log4j.info("The selected series displayed in Table tab");
		} else {
			fail("The selected series not displayed in Table tab");
		}

	}

	@And("^Select more than (\\d+) series and try to create Pie visual$")
	public void select_more_than_series_and_try_to_create_Pie_visual(int arg1) throws Throwable {
		WebElement SeriesTab = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(login.LOCATORS.getProperty("Series"))));
		SeriesTab.click();
		CommonFunctionality.wait(2000);
		List<WebElement> ListOfSeries = login.driver.findElements(By.xpath("//*[@class='series-item--name']"));
		List<WebElement> checkBox = login.driver
				.findElements(By.xpath("//div[@class='series-list-item--checkbox-wrapper']"));
		if (ListOfSeries.size() > 0) {
			for (int i = 0; i < ListOfSeries.size(); i++) {
				Thread.sleep(800);
				new Actions(login.driver).moveToElement(checkBox.get(i)).click().build().perform();
				// Until the element is not visible keep scrolling
				jse.executeScript("arguments[0].scrollIntoView(true);", ListOfSeries.get(i));
				if (i == 22) {
					break;
				}
			}
		} else {
			fail("No search elements found here");
		}
		create_a_Pie_visual();
		try {
			// if series hormonization popup is opened
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Apply')]", 6).click();
		} catch (Exception e) {
			//
		}
	}

	@Then("^Pie should allow max (\\d+) series$")
	public void pie_should_allow_max_series(int arg1) throws Throwable {
		CommonFunctionality.wait(400);
		Boolean confirmation_popup = login.driver.findElement(By.xpath("//*[text()='Confirmation']")).isDisplayed();
		if (confirmation_popup == true) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[text()='Ok']", 6).click();
			CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Close']", 6).click();
		}
		List<WebElement> visualCreatedWith_maxNumSeries = login.driver
				.findElements(By.xpath("//*[@class='legend-item']"));
		if (visualCreatedWith_maxNumSeries.size() == arg1) {
			login.Log4j.info("Pie visual created with max no.of series");
		} else {
			fail("Failed to create a pie visual with max no.of series");
		}
	}

	@Then("^By default checked sort by should be applied$")
	public void by_default_checked_sort_by_should_be_applied() throws Throwable {
		Boolean checked = login.driver.findElement(By.xpath("//*[text()='Checked']")).isDisplayed();
		if (checked == true) {
			login.Log4j.info("By default checked option is applied");
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
		// if Legend checkbox off
		CommonFunctionality.wait(2000);
		// Boolean Series = login.driver
		// .findElement(By.xpath("(//*[@class='highcharts-axis-labels
		// highcharts-xaxis-labels'])[1]"))
		// .isDisplayed();

		if (login.driver
				.findElements(By.xpath(
						"//*[@class='visual-item']//*[@class='series-edit--title series-edit--title__editable']"))
				.size() == 0) {
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
			// if add icon is active
			if (add_template.getAttribute("class").contains("add-style-template__active")) {
				add_template.click();
				hs.enter_new_template_name_as(arg);
				hs.click_on_green_tick_mark();
				// if template already exists with the same name
				try {
					CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 20).click();
				} catch (Exception e) {

				}

				make_any_changes_in_edit_visual();

			} else {
				make_any_changes_in_edit_visual();
				add_template.click();
				hs.enter_new_template_name_as(arg);
				hs.click_on_green_tick_mark();
				// if template already exists with the same name
				try {
					CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 20).click();
				} catch (Exception e) {

				}

			}
		} catch (Exception e) {

		}

		WebElement template = CommonFunctionality.getElementByXpath(login.driver, "(//*[@title='" + arg + "'])[2]", 20);
		new Actions(login.driver).pause(500).moveToElement(template).build().perform();
	}

	@Then("^The pie should be created with default format template$")
	public void the_pie_should_be_created_with_default_format_template() throws Throwable {
		CommonFunctionality.wait(2000);
		if (!(login.driver
				.findElements(By.xpath(
						"//*[@class='visual-item']//*[@class='series-edit--title series-edit--title__editable']"))
				.size() == 0)) {
			login.Log4j.info("Legend items shown on the visual");
		} else {
			Assert.fail("Legend items not shown on the visual");
		}
		// st.click_on("Edit Pie");
		// db.click_on_icon("Delete template");
		// CommonFunctionality.getElementByXpath(login.driver,"//*[@class='modal-window
		// modal-window__active']//*[contains(text(),'Ok')]", 20).click();
		// st.click_on("Save");
	}

	@And("^Expand the Title section$")
	public void expand_the_Title_section() throws Throwable {

		if (CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='visual-title-config']//*[@data-id='title']", 8)
				.getAttribute("class").contains("collapsed")) {
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='visual-title-config']//*[@data-id='title']/*/*[3]", 8)
					.click();
		}
	}

	@And("^Collapse the Title section$")
	public void collapse_the_Title_section() throws Throwable {
		if (!CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='visual-title-config']//*[@data-id='title']", 8)
				.getAttribute("class").contains("collapsed")) {
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='visual-title-config']//*[@data-id='title']/*/*[2]", 8)
					.click();
		}
	}

	@Then("^The Sub-title section should be expnaded$")
	public void the_Sub_title_section_should_be_expnaded() throws Throwable {
		CommonFunctionality.wait(500);
		if (!login.driver.findElement(By.xpath("//*[@class='popover--body']/*[1]/*[2]")).getAttribute("class")
				.contains("collapsed")) {
			login.Log4j.info("The section is expandedd");

		} else {
			Assert.fail("The section is not expanded");
		}
	}

	@Then("^The Sub-title section should be collapsed$")
	public void the_Sub_title_section_should_be_collapsed() throws Throwable {
		CommonFunctionality.wait(500);
		if (login.driver.findElement(By.xpath("//*[@class='popover--body']/*[1]/*[2]")).getAttribute("class")
				.contains("collapsed")) {
			login.Log4j.info("The section is collapsed");

		} else {
			Assert.fail("The section is not collapsed");
		}
	}

	@And("^Expand the Sub-title section$")
	public void expand_the_Sub_title_section() throws Throwable {
		if (CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='visual-title-config']//*[@data-id='sub_title']", 8)
				.getAttribute("class").contains("collapsed")) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='visual-title-config']//*[@data-id='sub_title']/*/*[3]", 8).click();
		}
	}

	@And("^Collapse the Sub-title section$")
	public void collapse_the_Sub_title_section() throws Throwable {
		if (!CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='visual-title-config']//*[@data-id='sub_title']", 8)
				.getAttribute("class").contains("collapsed")) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='visual-title-config']//*[@data-id='sub_title']/*/*[2]", 8).click();
		}
	}

	@And("^Select vertical align as \"([^\"]*)\" and save$")
	public void select_vertical_align_as_and_save(String arg1) throws Throwable {

		if (arg1.equalsIgnoreCase("Top")) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[@data-value='" + arg1 + "']", 8).click();
		} else if (arg1.equalsIgnoreCase("Bottom")) {
			try {
				st.click_on("Edit Pie");
			} catch (Exception e) {
				try {
					st.click_on("Edit Table");
				}catch(Exception e1) {
					st.click_on("Edit Map");
				}
			}
			hs.check("Copyright");
			hs.open_drop_down_for("Copyright");
			CommonFunctionality.getElementByXpath(login.driver, "//*[@data-value='" + arg1 + "']", 8).click();

		}
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'movable-modal__active')]//button[contains(text(),'Save')]", 40).click();

	}

	@Then("^The copyright should be displayed in top$")
	public void the_copyright_should_be_displayed_in_top() throws Throwable {
		CommonFunctionality.wait(2000);
		boolean ceicLogo_top = login.driver.findElement(By.xpath(
				"//*[@class='visual-item-template--credits-top']//*[@class='visual-item-wrapper--credits-image']"))
				.isDisplayed();
		if (ceicLogo_top == true) {
			login.Log4j.info("Copyright logo is displayed on top");
		} else {
			Assert.fail("Copyright logo is not displayed on top");
		}
	}

	@Then("^The copyright should be displayed in bottom$")
	public void the_copyright_should_be_displayed_in_bottom() throws Throwable {
		CommonFunctionality.wait(2000);
		boolean ceicLogo_top = login.driver.findElement(By.xpath(
				"//*[@class='visual-item-template--credits-bottom']//*[@class='visual-item-wrapper--credits-image']"))
				.isDisplayed();
		if (ceicLogo_top == true) {
			login.Log4j.info("Copyright logo is displayed on bottom");
		} else {
			Assert.fail("Copyright logo is not displayed on bottom");
		}
	}

	@Then("^The middle align option should be disabled since cannot show in the middle of the table$")
	public void the_middle_align_option_should_be_disabled_since_cannot_show_in_the_middle_of_the_table()
			throws Throwable {
		CommonFunctionality.wait(1000);
		if (CommonFunctionality.getElementByXpath(login.driver, "//*[@data-value='middle']", 10).getAttribute("class")
				.contains("hide")) {
			login.Log4j.info("The middle option is disabled");
		} else {
			fail("The middle option is not disabled");
		}
	}

	@And("^Select Horizontal alignment of copyright to \"([^\"]*)\" and save$")
	public void select_Horizontal_alignment_of_copyright_to_and_save(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		if (arg1.equalsIgnoreCase("left")) {
			login.driver.findElement(By.xpath("//*[@data-value='" + arg1 + "']")).click();
		} else if (arg1.equalsIgnoreCase("center") || arg1.equalsIgnoreCase("right")) {
			try {
				st.click_on("Edit Pie");
			} catch (Exception e) {
				try {
				st.click_on("Edit Table");
				}catch(Exception e1) {
					st.click_on("Edit Map");
				}
			}
			hs.check("Copyright");
			hs.open_drop_down_for("Copyright");
			CommonFunctionality.getElementByXpath(login.driver, "//*[@data-value='" + arg1 + "']", 8).click();
		}
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'movable-modal__active')]//button[contains(text(),'Save')]", 40).click();
	}

	@And("^Open date dropdown$")
	public void open_date_dropdown() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@title,'Tooltips.')]//*[@class='context-menu-control--icon']", 40).click();
	}

	@Then("^The following list of dates format should be opened$")
	public void the_following_list_of_dates_format_should_be_opened(List<String> date_format_list) throws Throwable {
		CommonFunctionality.wait(500);
		List<String> list = new ArrayList<>();
		List<WebElement> listOfDateFormats = login.driver.findElements(By.xpath(
				"//*[@class='items-wrapper']//*[@class='checkbox-control']//*[@class='input-control--description']"));
		for (int i = 0; i < listOfDateFormats.size(); i++) {
			list.add(listOfDateFormats.get(i).getText());

		}
		Assert.assertEquals(date_format_list, list);
		System.out.println("The list of date formats are available " + date_format_list);
	}

	@Then("^\"([^\"]*)\" value should be displayed as default$")
	public void value_should_be_displayed_as_default(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		if (CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[contains(@title,'Tooltips.')]//*[contains(@class,'attributes-list-context-title')]", 8)
				.getText().equalsIgnoreCase(arg1)) {
			login.Log4j.info(arg1 + " value is displayed as default ");
		} else {
			fail(arg1 + " value is not displayed as default");
		}
	}

	@And("^Select \"([^\"]*)\" field$")
	public void select_field(String arg1) throws Throwable {

		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='dropdown-menu context-menu ']/*[3]//*[@title='" + arg1 + "']", 8).click();
	}

	@Then("^The Tooltip default value should be changed to \"([^\"]*)\" and tooltips of visual should include with \"([^\"]*)\" of series$")
	public void the_Tooltip_default_value_should_be_changed_to_and_tooltips_of_visual_should_include_with_of_series(
			String arg1, String arg2) throws Throwable {

		CommonFunctionality.wait(500);
		if (CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[contains(@title,'Tooltips.')]//*[contains(@class,'attributes-list-context-title')]", 8)
				.getText().equalsIgnoreCase(arg1)) {
			login.Log4j.info("The tooltip default value is changed to " + arg1);
		} else {
			fail("The tooltip default value is not changed");
		}
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'movable-modal__active')]//button[contains(text(),'Save')]", 40).click();
		CommonFunctionality.wait(1000);
		WebElement mouseHoverVisual = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='highcharts-point highcharts-color-0']", 10);
		new Actions(login.driver).moveToElement(mouseHoverVisual).pause(500).build().perform();
		String text = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='table-tooltip']/*[3]/*[1]", 4)
				.getText();
		if (arg2.equalsIgnoreCase("Function description")) {
			if (arg2.contains(text)) {
				login.Log4j.info("The selected attribute " + text + " is displayed in the tooltip of the visual");
			}
		} else if (!arg2.equalsIgnoreCase("Function description")) {
			if (text.contains(arg2)) {
				login.Log4j.info("The selected attribute " + text + " is displayed in the tooltip of the visual");

			}
		} else {
			fail("Verification failed");
		}
	}

	@Then("^The following items should be available$")
	public void the_following_items_should_be_available(List<String> list) throws Throwable {
		List<WebElement> List_of_options = null;
		CommonFunctionality.wait(1000);
		List_of_options = login.driver.findElements(By.xpath("//div[@class='popover--wrapper']//*[@class='title']"));
		if (List_of_options.size() > 0) {
			for (int i = 0; i < List_of_options.size(); i++) {
				String str = List_of_options.get(i).getText();
				if (list.contains(str.trim())) {
					login.Log4j.info(str.trim() + " is displayed");
				} else {
					Assert.fail(str.trim() + " is not displayed");
				}
			}
		} else {
			Assert.fail("list size is zero");

		}
	}

	@Then("^\"([^\"]*)\" should be checked by default$")
	public void should_be_checked_by_default(String arg1) throws Throwable {
		CommonFunctionality.wait(1500);
		if (arg1.equalsIgnoreCase("Show tooltips")) {
			boolean show_tooltip_checkbox = login.driver
					.findElement(By.xpath("//*[@class='chart-tooltip-config']/*[1]/*[3]//*[@type='checkbox']"))
					.isSelected();
			if (show_tooltip_checkbox == true) {
				login.Log4j.info(arg1 + " is checked by default");
			} else {
				fail(arg1 + " is not checked by default");
			}
		} else if (arg1.equalsIgnoreCase("Legend")) {
			boolean legend_checkbox = login.driver
					.findElement(By.xpath("//*[contains(@title,'" + arg1 + "')]//input[@type='checkbox']"))
					.isSelected();
			if (legend_checkbox == true) {
				login.Log4j.info(arg1 + " is checked by default");
			} else {
				fail(arg1 + " is not checked by default");
			}
			if (login.driver.findElements(By.xpath("(//div[@class='highcharts-legend']//*[@class='legend-item'])[2]"))
					.size() == 0) {
				login.Log4j.info("Legend option is displayed at the bottom of the visual");
			} else {
				fail("verification failed");
			}
		} else if (arg1.equalsIgnoreCase("Show legend")) {
			boolean show_legend_checkbox = login.driver
					.findElement(By.xpath("//*[contains(@class,'legend-config')]/*[1]/*[3]/*[1]//input[@type='checkbox']"))
					.isSelected();
			if (show_legend_checkbox == true) {
				login.Log4j.info(arg1 + " is checked by default");
			} else {
				fail(arg1 + " is not checked by default");
			}
		} else if (arg1.equalsIgnoreCase("Data labels")) {
			boolean datalabel_checkbox = login.driver
					.findElement(By.xpath("//*[contains(@title,'" + arg1 + "')]//input[@type='checkbox']"))
					.isSelected();
			if (datalabel_checkbox == true) {
				login.Log4j.info(arg1 + " is checked by default");
			} else {
				fail(arg1 + " is not checked by default");
			}
		}
		if (arg1.equalsIgnoreCase("Show labels")) {
			boolean show_label_checkbox = login.driver
					.findElement(By.xpath("//*[@class='data-labels-config']/*[1]/*[3]//*[@type='checkbox']"))
					.isSelected();
			if (show_label_checkbox == true) {
				login.Log4j.info(arg1 + " is checked by default");
			} else {
				fail(arg1 + " is not checked by default");
			}
		}

	}

	@And("^Tooltips for visual should not be shown$")
	public void tooltips_for_visual_should_not_be_shown() throws Throwable {
		CommonFunctionality.wait(1000);
		WebElement mouseHoverVisual = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='highcharts-point highcharts-color-0']", 10);
		new Actions(login.driver).moveToElement(mouseHoverVisual).pause(500).build().perform();
		if (login.driver.findElements(By.xpath("//*[@class='table-tooltip']")).size() == 0) {
			login.Log4j.info("Tooltip is not displayed");
		} else {
			fail("verification failed");
		}
	}

	@Then("^The following list of items should be opened$")
	public void the_following_list_of_items_should_be_opened(List<String> items) throws Throwable {
		CommonFunctionality.wait(200);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='select2-choices']", 20).click();
		CommonFunctionality.wait(500);
		List<WebElement> listOfItems = login.driver
				.findElements(By.xpath("//*[@class='select2-results']//li//*[@class='select2-result-label']"));
		for (int i = 0; i < listOfItems.size(); i++) {
			if (items.contains(listOfItems.get(i).getText())) {
				login.Log4j.info(listOfItems.get(i).getText() + " is displayed");
			} else {
				fail("verification failed");
			}
		}
	}

	@Then("^\"([^\"]*)\" attribute should get added in tooltips$")
	public void attribute_should_get_added_in_tooltips(String arg1) throws Throwable {
		WebElement mouseHoverVisual = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='highcharts-point highcharts-color-0']", 10);
		new Actions(login.driver).moveToElement(mouseHoverVisual).pause(500).build().perform();
		String text = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='table-tooltip']/*[3]/*[1]", 4)
				.getText();
		if (arg1.equalsIgnoreCase("Function description")) {
			if (arg1.contains(text)) {
				login.Log4j.info("The selected attribute " + text + " get added in the tooltip of the visual");
			}
		} else if (!arg1.equalsIgnoreCase("Function description")) {
			if (text.contains(arg1)) {
				login.Log4j.info("The selected attribute " + text + " get added in the tooltip of the visual");

			}
		}
	}

	@Then("^\"([^\"]*)\" should be displayed in selected color$")
	public void should_be_displayed_in_selected_color(String arg1) throws Throwable {
		WebElement mouseHoverVisual = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='highcharts-point highcharts-color-0']", 10);
		new Actions(login.driver).moveToElement(mouseHoverVisual).pause(500).build().perform();
		String TooltipText_color = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='table-tooltip']", 4)
				.getCssValue("color");
		Commentary.ColorValidation(TooltipText_color,Histogram.ActualColor);
	}

	@Then("^Size of tooltips should get changed as \"([^\"]*)\"$")
	public void size_of_tooltips_should_get_changed_as(String arg1) throws Throwable {
		WebElement mouseHoverVisual = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='highcharts-point highcharts-color-0']", 10);
		new Actions(login.driver).moveToElement(mouseHoverVisual).pause(500).build().perform();
		String Tooltip_font_size = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='table-tooltip']", 4)
				.getCssValue("font-size");
		commentary.FontSizeValidation(Tooltip_font_size, arg1);

	}

	@Then("^Size of legend should get changed as \"([^\"]*)\"$")
	public void size_of_legend_should_get_changed_as(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		String legend_font_size = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='series-edit--title series-edit--title__editable']", 4)
				.getCssValue("font-size");
		commentary.FontSizeValidation(legend_font_size, arg1);
	}

	@Then("^Legend text should turn into \"([^\"]*)\" format$")
	public void legend_text_should_turn_into_format(String font_style) throws Throwable {
		if (font_style.equals("Italic")) {
			String Actualformat = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='series-edit--title series-edit--title__editable']", 10).getCssValue("font-style");
			login.Log4j.info(Actualformat);
			if (font_style.equalsIgnoreCase(Actualformat)) {
				login.Log4j.info("The legend is displayed in " + Actualformat + " format");
			} else {
				Assert.fail("The legend is not displayed in " + Actualformat + " format");
			}
		} else if (font_style.equalsIgnoreCase("underline")) {
			CommonFunctionality.wait(1000);
			String Actualformat = null;
//			Actualformat = CommonFunctionality.getElementByXpath(login.driver,
//					"//*[@class='series-edit--title series-edit--title__editable']", 30).getCssValue("text-decoration");
			
				Actualformat = CommonFunctionality.getElementByXpath(login.driver,
						"(//*[@class='highcharts-legend highcharts-no-tooltip']//*[contains(@class,'highcharts-legend-item')]/*[1])[2]", 30).getCssValue("text-decoration");
						login.Log4j.info(Actualformat);
			if (Actualformat.toUpperCase().contains(font_style.toUpperCase())) {
				login.Log4j.info("The legend is displayed in " + Actualformat + " format");
			} else {
				Assert.fail("The legend is not displayed in " + Actualformat + " format");
			}
		}
	}

	@Then("^The series suggestion manager popup should be displayed$")
	public void the_series_suggestion_manager_popup_should_be_displayed() throws Throwable {
		CommonFunctionality.wait(1000);
		WebElement series_suggestion_name = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='suggestions-manager--name']", 10);
		if (series_suggestion_name.getText().equalsIgnoreCase("Add related series")) {
			login.Log4j.info("The series suggestion manager is displayed");
		} else {
			fail("The series suggestion manager is not displayed");
		}
	}

	@And("^Select a region as \"([^\"]*)\"$")
	public void select_a_region_as(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByClassName(login.driver, "select2-chosen", 10).click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='select2-results']//li//*[contains(text(),'" + arg1 + "')]", 10).click();
	}

	@Then("^The related series should be added to the visual$")
	public void the_related_series_should_be_added_to_the_visual() throws Throwable {
		WebElement ele = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='visual-indicators--category visual-indicators--category__macro']/*[2]//*[@class='visual-indicator--title']",
				10);
		String indicator_title_text = ele.getText();
		new Actions(login.driver).pause(500).moveToElement(ele).perform();
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[@class='visual-indicators--category visual-indicators--category__macro']/*[2]/*[2]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'movable-modal__active')]//*[@class='movable-modal--close']", 10).click();
		CommonFunctionality.wait(500);
		ArrayList<String> listOfLegendItems = new ArrayList<>();
		List<WebElement> list = login.driver
				.findElements(By.xpath("//*[@class='series-edit--title series-edit--title__editable']"));
		for (int i = 0; i < list.size(); i++) {
			listOfLegendItems.add(list.get(i).getText());
		}
		if (listOfLegendItems.contains(indicator_title_text)
				|| listOfLegendItems.contains("Consumer Price Index: YoY: Monthly: Albania")) {
			login.Log4j.info("The related series is displayed in the visual");
		} else {
			fail("The relatedd series not displayed in the visual");
		}

	}

	@Then("^Applied functions with created pie chart should be downloaded$")
	public void applied_functions_with_created_pie_chart_should_be_downloaded() throws Throwable {
		CommonFunctionality.wait(30000);
		Commentary.format = "xlsx";
		CommonFunctionality.getTheNewestFile(Commentary.format);
		File file = CommonFunctionality.theNewestFile;
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFCell columnTxt;
		XSSFCell function;
		int rowcount = sheet.getLastRowNum();
		login.Log4j.info("Total number of rows present in the sheet: " + rowcount);
		int colcount = sheet.getRow(1).getLastCellNum();
		login.Log4j.info("Total number of columns present in the sheet: " + colcount);
		if (file.exists()) {
			for (int i = 0; i < colcount; i++) {
				columnTxt = sheet.getRow(0).getCell(i);

				if (columnTxt.toString().equalsIgnoreCase("Function Description")) {
					function = sheet.getRow(2).getCell(i);
					if (function.toString().toUpperCase().contains(Appliedfunction)) {
						login.Log4j.info("Applied function is downloaded");
						break;
					} else {
						fail("Applied function IS NOT downloaded");
					}

				}
			}

		} else {
			Assert.fail(file + " doesn't exist");
		}

		fis.close();
		File_delete.delete();
	}

	@Then("^Tooltip text should turn into \"([^\"]*)\" format$")
	public void tooltip_text_should_turn_into_format(String font_style) throws Throwable {
		CommonFunctionality.wait(1000);
		WebElement mouseHoverVisual = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='highcharts-point highcharts-color-0']", 10);
		new Actions(login.driver).moveToElement(mouseHoverVisual).pause(500).build().perform();
		if (font_style.equals("Bold")) {
			String fontWeight = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='table-tooltip']", 10)
					.getCssValue("font-weight");

			login.Log4j.info(fontWeight);
			Assert.assertTrue(Integer.parseInt(fontWeight) == 700);

		} else if (font_style.equals("Italic")) {
			String Actualformat = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='table-tooltip']", 10)
					.getCssValue("font-style");
			login.Log4j.info(Actualformat);
			if (font_style.equalsIgnoreCase(Actualformat)) {
				login.Log4j.info("The text in tooltip is displayed in " + Actualformat + " format");
			} else {
				Assert.fail("The text in tooltip is not displayed in " + Actualformat + " format");
			}
		} else if (font_style.equalsIgnoreCase("underline")) {
			CommonFunctionality.wait(1000);
			String Actualformat = CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[@class='highcharts-label highcharts-tooltip highcharts-color-0']/span", 30)
					.getCssValue("text-decoration");
			login.Log4j.info(Actualformat);
			if (Actualformat.toUpperCase().contains(font_style.toUpperCase())) {
				login.Log4j.info("The text in tooltip is displayed in " + Actualformat + " format");
			} else {
				Assert.fail("The text in tooltip is not displayed in " + Actualformat + " format");
			}
		} else if (font_style.equalsIgnoreCase("Unbold")) {
			String fontWeight = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='table-tooltip']", 10)
					.getCssValue("font-weight");

			login.Log4j.info(fontWeight);
			Assert.assertNotEquals(Integer.parseInt(fontWeight), 700, "Tooltip text is displayed in unbold format");
		} else if (font_style.equals("NonItalic")) {
			String Actualformat = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='table-tooltip']", 10)
					.getCssValue("font-style");
			login.Log4j.info(Actualformat);
			if (!font_style.equalsIgnoreCase(Actualformat)) {
				login.Log4j.info("The text in tooltip is displayed in " + Actualformat + " format");
			} else {
				Assert.fail("The text in tooltip is not displayed in " + Actualformat + " format");
			}
		} else if (font_style.equalsIgnoreCase("Nonunderlined")) {
			CommonFunctionality.wait(1000);
			String Actualformat = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='table-tooltip']", 30)
					.getCssValue("text-decoration");
			login.Log4j.info(Actualformat);
			if (!Actualformat.toUpperCase().contains(font_style.toUpperCase())) {
				login.Log4j.info("The text in tooltip is displayed in " + Actualformat + " format");
			} else {
				Assert.fail("The text in tooltip is not displayed in " + Actualformat + " format");
			}
		}
	}

	@And("^Click on same$")
	public void click_on_same() throws Throwable {
		CommonFunctionality.wait(500);
		login.Log4j.info(Histogram.TooltiptextFormat);
		if (Histogram.TooltiptextFormat.equalsIgnoreCase("Bold")) {
			login.driver.findElement(By.name("tooltip_font_weight")).click();
		} else if (Histogram.TooltiptextFormat.equalsIgnoreCase("Italic")) {
			login.driver.findElement(By.name("tooltip_font_style")).click();
		} else if (Histogram.TooltiptextFormat.equalsIgnoreCase("Underline")) {
			login.driver.findElement(By.name("tooltip_font_underline")).click();
		}
	}

	@Then("^Border of tooltip should be applied with selected color$")
	public void border_of_tooltip_should_be_applied_with_selected_color() throws Throwable {
		WebElement mouseHoverVisual = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='highcharts-point highcharts-color-0']", 10);
		new Actions(login.driver).moveToElement(mouseHoverVisual).pause(500).build().perform();
		String Tooltip_border_color = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='highcharts-label-box highcharts-tooltip-box']", 10)
				.getCssValue("stroke");
		Commentary.ColorValidation(Tooltip_border_color,Commentary.ActualColor);

	}

	@Then("^The tooltp border width should be changed as \"([^\"]*)\"$")
	public void the_tooltp_border_width_should_be_changed_as(String arg1) throws Throwable {
		WebElement mouseHoverVisual = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='highcharts-point highcharts-color-0']", 10);
		new Actions(login.driver).moveToElement(mouseHoverVisual).pause(500).build().perform();
		String Tooltip_border_width = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='highcharts-label-box highcharts-tooltip-box']", 10)
				.getCssValue("stroke-width");
		login.Log4j.info(Tooltip_border_width);
		commentary.FontSizeValidation(Tooltip_border_width, arg1);
	}

	@Then("^X axis should be set to \"([^\"]*)\" with enable state & Y axis should be set to \"([^\"]*)\" with disable state$")
	public void x_axis_should_be_set_to_with_enable_state_Y_axis_should_be_set_to_with_disable_state(String arg1,
			String arg2) throws Throwable {
		CommonFunctionality.wait(1000);
		String Xaxis = CommonFunctionality.getElementByXpath(login.driver, "//*[@name='visual_area_proportion_x']", 10)
				.getAttribute("aria-valuenow");
		String Yaxis = CommonFunctionality.getElementByXpath(login.driver, "//*[@name='visual_area_proportion_y']", 10)
				.getAttribute("aria-valuenow");
		WebElement XaxisEle = CommonFunctionality.getElementByXpath(login.driver,
				"//ul[@class='dropdown-menu context-menu ']//li/*[1]/*[2]/*[2]/*[1]", 10);
		WebElement YaxisEle = CommonFunctionality.getElementByXpath(login.driver,
				"//ul[@class='dropdown-menu context-menu ']//li/*[1]/*[2]/*[2]/*[2]", 10);

		if (Xaxis.equals(arg1) && !XaxisEle.getAttribute("class").contains("disabled")) {
			login.Log4j.info("Xaxis value is " + arg1 + " it is in enable state");
		} else {
			login.Log4j.info("Xaxis verification is failed");
		}
		if (Yaxis.equals(arg2) && YaxisEle.getAttribute("class").contains("disabled")) {
			login.Log4j.info("Yaxis value is " + arg2 + " it is in disable state");
		} else {
			login.Log4j.info("Yaxis verification is failed");
		}
	}

	@And("^Click on legend dropdown$")
	public void click_on_legend_dropdown() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@title,'Legend')]/*[2]/*/*[2]", 10).click();
	}

	@Then("^The following legend options should be available$")
	public void the_following_legend_options_should_be_available(List<String> legendOptions) throws Throwable {
		CommonFunctionality.wait(500);
		List<WebElement> list = login.driver
				.findElements(By.xpath("//*[@class='alignment-control--label' or (@class='link-popup-control link')]"));
		for (int i = 0; i < legendOptions.size(); i++) {
			String[] str = list.get(i).getText().split(":");
			if (legendOptions.contains(str[0])) {
				login.Log4j.info(list.get(i).getText() + " is displayed");
			} else {
				fail("Verification failed");
			}
		}
	}

	@Then("^The Selected \"([^\"]*)\" should reflect in the pie visual legand$")
	public void the_Selected_should_reflect_in_the_pie_visual_legand(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Color")) {
			String color = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-edit--title series-edit--title__editable']", 4)
					.getCssValue("color");
			String color_hex = Color.fromString(color).asHex();
			String SelectedColor = Color.fromString(Histogram.ActualColor).asHex();
			assertEquals(color_hex, SelectedColor);
			login.Log4j.info("The selected " + arg1 + " is reflecting in pie visual");

		} else if(arg1.equalsIgnoreCase("Border color")) {
			String bordercolor = CommonFunctionality
					.getElementBycssSelector(login.driver, "rect.highcharts-legend-box", 4).getAttribute("stroke");
			String bordercolor_hex = Color.fromString(bordercolor).asHex();
			String SelectedColor = Color.fromString(BorderColor).asHex();
			assertEquals(bordercolor_hex, SelectedColor);
			login.Log4j.info("The selected " + arg1 + " is reflecting in chart visual");
		}
	}
	@And("^Select border color for legend$")
	public void select_border_color_for_legend() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,	"//*[contains(@class,'legend-config')]/*[6]//*[@class='color-picker-control']/*[1]", 10).click();
		WebElement ColorEle = CommonFunctionality.getElementByProperty(login.driver, "BlueColor", 20);
		BorderColor = ColorEle.getCssValue("background-color");
		ColorEle.click();
	}


	@And("^Check legend \"([^\"]*)\"$")
	public void check_legend(String arg1) throws Throwable {
		if (arg1.equals("Title")) {
			CommonFunctionality.wait(1000);
			Boolean isChecked = login.driver.findElement(By.xpath(
					"//*[@class='accordion-config']//div[@class='popover-block-content legend-config']//input[@type='checkbox']"))
					.isSelected();
			if (isChecked == false) {
				login.driver.findElement(By.xpath(
						"//*[@class='accordion-config']//div[@class='popover-block-content legend-config']//span[@class='input-control--indicator']"))
						.click();
			}
		}
	}

	@Then("^Legend \"([^\"]*)\" should be displayed in selected color$")
	public void legend_should_be_displayed_in_selected_color(String arg1) throws Throwable {
		String fontColor = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='highcharts-label highcharts-legend-title']/*", 4).getCssValue("color");
		Commentary.ColorValidation(fontColor,Histogram.ActualColor);
	}
	@And("^Select background color for legend$")
	public void select_background_color_for_legend() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,	"//*[contains(@class,'legend-config')]/*[5]//*[@class='color-picker--ui']/*", 10).click();
		WebElement ColorEle = CommonFunctionality.getElementByProperty(login.driver, "BlueColor", 20);
		BackgroundColor = ColorEle.getCssValue("background-color");
		ColorEle.click();
	}

	@Then("^The Selected \"([^\"]*)\" should reflect in the visual legand$")
	public void the_Selected_should_reflect_in_the_visual_legand(String arg1) throws Throwable {
		String bgcolor = CommonFunctionality.getElementBycssSelector(login.driver, "rect.highcharts-legend-box", 4)
				.getAttribute("fill");
		String bgcolor_hex = Color.fromString(bgcolor).asHex();
		String SelectedColor =  Color.fromString(BackgroundColor).asHex();
		assertEquals(bgcolor_hex, SelectedColor);
		login.Log4j.info("The selected " + arg1 + " is reflecting in chart visual");
	}

	@Then("^By default title options are disabled$")
	public void by_default_title_options_are_disabled() throws Throwable {
		CommonFunctionality.wait(300);
		if (login.driver
				.findElement(By
						.xpath("//*[@class='accordion-config']//*[@class='popover-block-content legend-config']/*[2]"))
				.getAttribute("class").contains("disabled")) {
			login.Log4j.info("Title options are disabled by default");
		} else {
			fail("Title options are not disabled by default");
		}
	}

	@Then("^Should enable the legend options$")
	public void should_enable_the_legend_options() throws Throwable {
		CommonFunctionality.wait(300);
		if (!login.driver
				.findElement(By
						.xpath("//*[@class='accordion-config']//*[@class='popover-block-content legend-config']/*[2]"))
				.getAttribute("class").contains("disabled")) {
			login.Log4j.info("Title options are enabled after checking title check box");
		} else {
			fail("Title options are not enabled by checking title checkbox");
		}
	}

	@And("^Click on Advanced settings icon$")
	public void click_on_Advanced_settings_icon() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@title,'Legend. ')]/*[3]", 4).click();
	}

	@And("^Click on Advanced settings icon for Data labels$")
	public void click_on_Advanced_settings_icon_for_Data_labels() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@title,'Data labels.')]/*[2]", 4).click();
	}

	@And("^Select attributes \"([^\"]*)\" and \"([^\"]*)\"$")
	public void select_attributes_and(String arg1, String arg2) throws Throwable {
		String arg = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='select2-choices']//li//span", 4)
				.getText();
		if (arg.equalsIgnoreCase(arg2)) {
			// no need to select
		} else {
			CommonFunctionality.getElementByXpath(login.driver, "//button[@class='add-item-attribute btn']", 4).click();
			CommonFunctionality.getElementByXpath(login.driver,
					"//ul[@class='select2-results']//li//*[contains(text(),'" + arg2 + "')]", 4).click();
		}
		CommonFunctionality.getElementByXpath(login.driver, "//button[@class='add-item-attribute btn']", 4).click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//ul[@class='select2-results']//li//*[contains(text(),'" + arg1 + "')]", 4).click();

		CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[@class='visual-configuration-controls--right']//button[contains(text(),'Save')]", 40)
				.click();
	}

	@Then("^Selected attributes should be displayed along with percentage attribute for visual$")
	public void selected_attributes_should_be_displayed_along_with_percentage_attribute_for_visual() throws Throwable {
		String name = " Net Lending to Individuals: sa";
		String percentage = "100.00 %";
		String AtualResult = CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0']/*[2]", 4)
				.getText();
		if (AtualResult.contains(name) && AtualResult.contains(percentage)) {
			login.Log4j.info("Selected attributes name and percentage are displayed in the visual");
		} else {
			fail("Selected attributes name and percentage are not displayed");
		}

	}
	@And("^Select the color for Labels$")
	public void select_the_color_for_Labels() throws Throwable {
		WebElement ColorEle = CommonFunctionality.getElementByProperty(login.driver, "OrangeColor", 20);
		LabelColor = ColorEle.getCssValue("background-color");
		ColorEle.click();
	}

	@Then("^Selected color should be applied for visuals$")
	public void selected_color_should_be_applied_for_visuals() throws Throwable {
		CommonFunctionality.wait(500);
		String color_text = login.driver.findElement(By.xpath(
				"//*[@class='highcharts-data-labels highcharts-series-0 highcharts-pie-series highcharts-tracker']/*[2]/*[2]"))
				.getCssValue("color");
		String ExpectedColor = Color.fromString(color_text).asHex();
		login.Log4j.info(ExpectedColor);
		String SelectedColor = Color.fromString(LabelColor).asHex();
		Assert.assertEquals(SelectedColor, ExpectedColor);
	}
	@And("^Select the Highlight color for label$")
	public void select_the_Highlight_color_for_label() throws Throwable {
		
		WebElement ColorEle = CommonFunctionality.getElementByProperty(login.driver, "OrangeColor", 20);
		HighlightColor = ColorEle.getCssValue("background-color");
		ColorEle.click();
	}

	@Then("^Selected highlight color for labels should be shown$")
	public void selected_highlight_color_for_labels_should_be_shown() throws Throwable {
		CommonFunctionality.wait(500);
		String background_color = login.driver.findElement(By.xpath(
				"//*[@class='highcharts-data-labels highcharts-series-0 highcharts-pie-series highcharts-tracker']/*[2]"))
				.getCssValue("background-color");
		String ExpectedColor = Color.fromString(background_color).asHex();
		login.Log4j.info(ExpectedColor);
		String SelectedColor = Color.fromString(HighlightColor).asHex();
		Assert.assertEquals(SelectedColor, ExpectedColor);
	}

	@Then("^The Selected \"([^\"]*)\" should be applied$")
	public void the_Selected_should_be_applied(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		String fontsize = login.driver.findElement(By.xpath(
				"//*[@class='highcharts-data-labels highcharts-series-0 highcharts-pie-series highcharts-tracker']/*[2]/*[2]"))
				.getCssValue("font-size");
		String font_size_text[] = fontsize.split("px");
		Integer expected = Integer.valueOf(font_size_text[0]);
		Integer actual = Integer.valueOf(ChartVisual.data_labels_font_size);
		assertEquals(actual, expected);
	}

	@Then("^The Selected \"([^\"]*)\" should be updated$")
	public void the_Selected_should_be_updated(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		WebElement fontstyle = login.driver.findElement(By.xpath(
				"//*[@class='highcharts-data-labels highcharts-series-0 highcharts-pie-series highcharts-tracker']/*[2]/*[2]"));
		String font_bold = fontstyle.getCssValue("font-weight");
		String font_italic = fontstyle.getCssValue("font-style");
		String font_underline = fontstyle.getCssValue("text-decoration");
		assertTrue(font_bold.equals("bold") || font_bold.equals("700"));
		assertTrue(font_italic.equals("italic"));
		assertTrue(font_underline.contains("underline"));
	}

	@Then("^\"([^\"]*)\" should be default position$")
	public void should_be_default_position(String arg1) throws Throwable {
		String ExpectedPosition = null;
		try {
			ExpectedPosition = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='data-labels-config']//*[@class='select-control']/*[1]/*[1]/*[1]", 6).getText();
		} catch (Exception e) {
			ExpectedPosition = CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='pie-data-labels-container']/*[4]/*[2]", 6).getText();
		}
		if (ExpectedPosition.equalsIgnoreCase(arg1)) {
			login.Log4j.info(arg1 + " is displayed by default");
		} else {
			fail(arg1 + " is not displayed by default");
		}
	}

	@Then("^Change its position to \"([^\"]*)\"$")
	public void change_its_position_to(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		try {
			// in advanced settings icon
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='data-labels-config']//*[@class='select-control']/*[1]/*[1]", 6).click();
		} catch (Exception e) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='pie-data-labels-container']/*[4]/*[2]", 6)
					.click();
		}
		CommonFunctionality.getElementByXpath(login.driver,
				"//ul[@class='select2-results']//li//*[contains(text(),'" + arg1 + "')]", 6).click();
	}

	@Then("^Position \"([^\"]*)\" should be displayed$")
	public void position_should_be_displayed(String arg1) throws Throwable {
		String ExpectedPosition = null;
		CommonFunctionality.wait(500);
		try {
			// in advanced setting icon
			ExpectedPosition = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='data-labels-config']//*[@class='select-control']/*[1]/*[1]/*[1]", 6).getText();

		} catch (Exception e) {

			ExpectedPosition = CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='pie-data-labels-container']/*[4]/*[2]", 6).getText();
		}
		if (ExpectedPosition.equalsIgnoreCase(arg1)) {
			login.Log4j.info(arg1 + " is displayed after changing position");
		} else {
			fail(arg1 + " is not displayed after changing position");
		}

	}

	@Then("^The Selected Decimal seperator and Grouping seperator should be updated with selected input$")
	public void the_Selected_Decimal_seperator_and_Grouping_seperator_should_be_updated_with_selected_input()
			throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement timepoints = login.driver.findElement(By
				.xpath("//*[@class='highcharts-series highcharts-series-0 highcharts-pie-series highcharts-tracker']"));
		new Actions(login.driver).moveToElement(timepoints).pause(100).perform();
		String tooltip_text = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='highcharts-label highcharts-tooltip highcharts-color-0']/span", 10).getText();
		String lines[] = tooltip_text.split("[\\,\\.] ?");
		String split_by_comma[] = lines[0].split(",");
		if (ChartVisual.data_format_grouping_separator.equals("Space") && ChartVisual.data_format_separator.equals(".")
				|| ChartVisual.data_format_grouping_separator.equals("Space")
						&& ChartVisual.data_format_separator.equals(",")) {
			if (!split_by_comma[0].matches(".*\\s.*")) {
				fail("Verification Failed");
			}
		} else {
			if (!tooltip_text.contains(ChartVisual.data_format_separator)
					&& !tooltip_text.contains(ChartVisual.data_format_grouping_separator)) {
				fail("Verification failed");
			}

		}

		login.Log4j.info(
				"The Selected Decimal seperator and Grouping seperator has been updated in Pie visual timepoints and verified successfully");
	}

	@Then("^The Selected \"([^\"]*)\" should be updated with selected input$")
	public void the_Selected_should_be_updated_with_selected_input(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement timepoints = login.driver.findElement(By
				.xpath("//*[@class='highcharts-series highcharts-series-0 highcharts-pie-series highcharts-tracker']"));
		new Actions(login.driver).moveToElement(timepoints).pause(100).perform();
		String text = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='highcharts-label highcharts-tooltip highcharts-color-0']/span", 4).getText();
		String lines[] = text.split("\\r?\\n");
		String next_lines[] = lines[1].split("\\s+");
		login.Log4j.info(next_lines[2]);
		String decimal_places[] = next_lines[2].split("\\.");
		int length_of_digits = decimal_places[1].length();
		assertEquals(length_of_digits, ChartVisual.chart_decimal_places);
		WebElement title = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'visual-title--text') and @data-name='title']", 4);
		new Actions(login.driver).moveToElement(title).pause(2).build().perform();

		login.Log4j.info(
				"The Selected " + arg1 + " has been updated in pie visual timepoints and it's verified successfully");

	}

	@And("^Uncheck copyright attribute$")
	public void uncheck_copyright_attribute() throws Throwable {
		hs.Uncheck_Copyright();
	}

	@Then("^The copyright logo should be removed in the edit visual popup$")
	public void the_copyright_logo_should_be_removed_in_the_edit_visual_popup() throws Throwable {
		CommonFunctionality.wait(2000);
		if (login.driver
				.findElements(By
						.xpath("//*[@class='preview-container']//*[@class='visual-item-wrapper--credits-image']//img"))
				.size() == 0) {
			login.Log4j.info("CEIC logo is removed in the edit visual popup");
		} else {
			Assert.fail("CEIC logo is not removed in the edit visual popup");
		}
	}

	@Then("^The Pie visual should be created in vew tab on current insight$")
	public void the_Pie_visual_should_be_created_in_vew_tab_on_current_insight() throws Throwable {

		List<WebElement> views = login.driver
				.findElements(By.xpath("//*[contains(@class,'insight-page-view-tab') and contains(text(),'View')]"));
		if (views.size() > 1) {
			CommonFunctionality.wait(1000);
			String titileTxt = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@data-name='title']",
					15).getText();
			if (Visual_Title_txt.equalsIgnoreCase(titileTxt)) {
				login.Log4j.info("The Pie visual is created in view tab");
			} else {
				Assert.fail("The Pie visual is not created in view tab");
			}
		}

	}

	@Then("^The new insight should be opened and added visual should be available in My visual$")
	public void the_new_insight_should_be_opened_and_added_visual_should_be_available_in_My_visual() throws Throwable {
		createdVisualInNewTab(Visual_Title_txt);
	}

	@Then("^Pie visual and related series should be downloaded in excel$")
	public void pie_visual_and_related_series_should_be_downloaded_in_excel() throws Throwable {
		CommonFunctionality.getTheNewestFile(Commentary.format);
		File_delete.delete();
	}

	@Then("^Pie visual should be downloaded in PDF format$")
	public void pie_visual_should_be_downloaded_in_PDF_format() throws Throwable {
		CommonFunctionality.getTheNewestFile(Commentary.format);
		File_delete.delete();
	}

	@Then("^Pie visual should be downloaded in PNG format$")
	public void pie_visual_should_be_downloaded_in_PNG_format() throws Throwable {
		CommonFunctionality.getTheNewestFile(Commentary.format);
		File_delete.delete();
	}

	@Then("^Pie visual should be downloaded in JPG format$")
	public void pie_visual_should_be_downloaded_in_JPG_format() throws Throwable {
		CommonFunctionality.getTheNewestFile(Commentary.format);
		File_delete.delete();
	}

	@Then("^Pie visual should be pasted$")
	public void pie_visual_should_be_pasted() throws Throwable {
		String ExpectedTitle = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='title']", 10)
				.getText();
		if (Visual_Title_txt.equals(ExpectedTitle)) {
			login.Log4j.info("Pie visual is pasted");
		} else {
			Assert.fail("Pie visual is not pasted");
		}
	}

	@Then("^Pie chart should be cut$")
	public void pie_chart_should_be_cut() throws Throwable {
		commentary.commentary_should_be_cut();
	}

	@Then("^Pie chart should be deleted$")
	public void pie_chart_should_be_deleted() throws Throwable {
		commentary.commentary_should_be_deleted();
	}

	@And("^Select Pie$")
	public void select_Pie() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@data-action='download_visual']/*[1]", 30).click();
	}

	@Then("^Download popup should be displayed with Pie tab selection$")
	public void download_popup_should_be_displayed_with_Pie_tab_selection() throws Throwable {
		CommonFunctionality.wait(2000);
		if (login.driver
				.findElement(By.xpath(
						"//*[@class='modal-window insight-download modal-window__active']//*[@data-tab='visual']"))
				.getText().contains("Pie")) {
			login.Log4j.info("Verification is pass");
		} else {
			Assert.fail("Download popup not displayed with pie tab selection");
		}
	}

	@And("^Apply any function inside the download window$")
	public void apply_any_function_inside_the_download_window() throws Throwable {
		Appliedfunction = "SUM";
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='More functions']", 30).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@data-id='SUM']", 30).click();
	}

	@Then("^Applied functions should be shown in the header of download window$")
	public void applied_functions_should_be_shown_in_the_header_of_download_window() throws Throwable {
		CommonFunctionality.wait(300);
		String downloadWindow_headerText_function = CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[@class='download-modal-title']//*[@class='series-functions--modal-title-label']", 30)
				.getText();
		String[] function = downloadWindow_headerText_function.split(";");
		login.Log4j.info(function[2]);
		String[] fun = function[2].split("\\)");
		if (fun[0].trim().equalsIgnoreCase(Appliedfunction)) {
			login.Log4j.info("Applied functions has been shown in the header of download window");
		} else {
			fail("Applied functions has not been shown in the header of download window");
		}
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
			/*new Actions(login.driver).moveToElement(series_one).pause(100).build().perform();
			String actual = CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(text(),'Functions:')]/following-sibling::*", 4)
					.getText();*/
			String actual = series_one.getText();
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

	static void SelectSeries(String sid) throws Exception {
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(sid);
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		CommonFunctionality.wait(6000);
		CommonFunctionality.webDriverwait_keyvalue("Series_Tab");
		CommonFunctionality.getElementByProperty(login.driver, "Series_Tab", 8).click();
		CommonFunctionality.wait(5000);

		List<WebElement> list2 = login.driver.findElements(
				By.xpath("//*[@class='series-representation--list']//*[@class='series-list-item--checkbox-wrapper']/*"));
		for (int i = 0; i < list2.size(); i++) {
			
			new Actions(login.driver).moveToElement(list2.get(i)).pause(500).click().build().perform();
		}
	}
	static void createdVisualInNewTab(String ExpectedText) throws Exception {
		ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs2.get(1));
		CommonFunctionality.getElementByXpath(login.driver, "//a[@title='View 1']", 10).click();

		String ActualText = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='title']", 15)
				.getText();
		if (ActualText.equals(ExpectedText)) {
			login.Log4j.info(ExpectedText +" visual is created in new insiaght");
		} else {
			Assert.fail(ExpectedText + " visual is not created in new insight");
		}

		CommonFunctionality.DeleteVisual();
		login.driver.close();
		login.driver.switchTo().window(tabs2.get(0));
	}
}
