package CDMNext.StepDefinations;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class Cvision {

	static WebDriverWait wait = new WebDriverWait(login.driver, 200);
	JavascriptExecutor js = (JavascriptExecutor) login.driver;
	public static String date_text;
	public static String date_type;
	public static String send = "Shravas";
	public static String legand_tooltip;
	public static String text_series1;
	public static String text_series2;
	public static String text1;
	public static String text2;
	public static String frequency;
	public static String start_format_datepicker;
	public static String end_format_datepicker;
	public static String drill_text;
	public static String comparables_text1;
	public static String comparables_text2;
	public static String comparables_text3;
	public static String table_text;
	public static String series_text;
	public static String country_code;
	public static String start_date;
	public static String end_date;
	public static String footnotes_text;
	public static String comparable_table_title;
	public static String comparable_series_title;
	public static String start_date_chart;
	public static String end_date_chart;
	public static String series_title_function;
	public static String start_date_inside_chart;
	public static String end_date_inside_chart;
	public static String chart_from_date;
	public static String chart_to_date;
	public static String type_chart;
	public static String chart_option;
	public static String title_ssp;
	public static String sort = "Recently Updated";
	public static String zebra_text;
	public static String default_text;
	public static String frequency_text;
	public static String change_text;
	public static String title_text;
	public static String indicators_in_tooltip;
	public static String footnotes_contents;
	public static String mail;
	public static String modal_text;
	public static String prefix;
	public static String prefix_edit;
	public static String name_edit;
	public static String first_name;
	public static String last_name;
	public static String email;
	public static String preference_popup;
	public static List<WebElement> functions;
	public static List<String> filter = new ArrayList<>();
	public static WebElement spinner;
	public WebElement expand;
	public int selected_regions;
	public int all_regions;
	public WebElement stroke;
	public WebElement axis;
	public WebElement checkbox;
	public WebElement ele;
	public WebElement observations;
	public WebElement fullscreen;
	public WebElement halfscreen;
	public WebElement ok_button;
	public boolean disabled;
	public static List<WebElement> negative_color;
	public static String[] sourcearr;
	public boolean button;
	public boolean chart_checkbox;
	public boolean chart_checkbox1;
	public boolean chart_checkbox2;
	public boolean chart_checkbox3;
	public boolean chart_checkbox4;
	public boolean chart_checkbox5;
	public static String values_list;
	public int m;
	public static String text;
	public static String var;
	public String[] frequencyarray = null;
	public String result;

	@And("^Resetting the filters$")
	public void resetting_the_filters() throws Throwable {
		CommonFunctionality.wait(3000);
		if (login.driver.findElements(By.xpath("//*[contains(@style,'display: none;') and contains(text(),'Reset')]"))
				.size() > 0) {
			System.out.println("===No filter applied====");
			CommonFunctionality.wait(1000);
		} else {
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(text(),'Reset') and not(@visibility='hidden')]", 4)
					.click();
			// CommonFunctionality.getElementByProperty(login.driver, "Search", 4).click();
			CommonFunctionality.getElementByProperty(login.driver, "Search", 4).clear();
			CommonFunctionality.getElementByProperty(login.driver, "Search", 4).sendKeys(Keys.ENTER);
			CommonFunctionality.wait(500);
		}
	}

	@And("^Reset the values in \"([^\"]*)\" tab$")
	public void reset_the_values_in_tab(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Databases")) {
			try {
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'" + arg1 + "')]", 4)
						.click();
			} catch (Exception e) {
				CommonFunctionality.getElementByProperty(login.driver, "Databases", 4).click();
			}
			CommonFunctionality.getElementByProperty(login.driver, "Search", 4).clear();
			CommonFunctionality.getElementByProperty(login.driver, "Search", 4).sendKeys(Keys.ENTER);
		} else {
			CommonFunctionality.wait(3000);
			CommonFunctionality.webDriverwait_keyvalue("Series_new");
			CommonFunctionality.getElementByProperty(login.driver, "Series_new", 4).click();
			CommonFunctionality.getElementByProperty(login.driver, "Search", 4).clear();
			CommonFunctionality.getElementByProperty(login.driver, "Search", 4).sendKeys(Keys.ENTER);
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Add to myseries$")
	public void add_to_myseries() throws Throwable {
		CommonFunctionality.wait(3000);
		String id = "359237987";
		CommonFunctionality.webDriverwait_keyvalue("Series_tab");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_tab"))).click();
		CommonFunctionality.webDriverwait_keyvalue("Series_new");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_new"))).click();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys(Keys.chord(Keys.CONTROL, "a"),
				id);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys(Keys.ENTER);
		CommonFunctionality.webDriverwait_keyvalue("Series_checkbox");
		WebElement series_cb = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_checkbox")));
		new Actions(login.driver).moveToElement(series_cb).pause(2000).click().build().perform();
		WebElement series_add = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_to_myseries")));
		new Actions(login.driver).moveToElement(series_add).pause(2000).click().build().perform();
	}

	@And("^Click on \"([^\"]*)\" button from search$")
	public void click_on_button(String arg1) throws Throwable {
		WebElement filter = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='search-input--toggle-filters']", 8);
		filter.click();
	}

	@And("^Select \"([^\"]*)\" tab in header$")
	public void select_tab_in_header(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'" + arg1 + "')]", 4).click();
		CommonFunctionality.wait(1000);
	}

	@SuppressWarnings("deprecation")
	@And("^Capture the \"([^\"]*)\" tooltip indicator value$")
	public void capture_the_tooltip_indicator_value(String arg1) throws Throwable {
		WebElement first_series = CommonFunctionality.getElementByProperty(login.driver, "One_series_from_seriesList",
				4);
		new Actions(login.driver).moveToElement(first_series).pause(2000).build().perform();
		indicators_in_tooltip = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]/following-sibling::*", 4)
				.getText();
	}

	@And("^Click to create an empty visual$")
	public void click_to_create_an_empty_visual() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Create_new_view", 4).click();
	}

	@SuppressWarnings("deprecation")
	@And("^Click on empty \"([^\"]*)\" visual$")
	public void click_on_empty_visual(String arg1) throws Throwable {
		WebElement visual = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='view-components-over--visual-title' and contains(text(),'" + arg1 + "')]//..", 4);
		new Actions(login.driver).moveToElement(visual).pause(2000).click().build().perform();
		CommonFunctionality.wait(500);
	}

	@And("^Observe the \"([^\"]*)\" button$")
	public void observe_the_button(String arg1) throws Throwable {
		disabled = login.driver
				.findElement(By.xpath("//button[contains(@class,'button__sm') and text()='" + arg1 + "']")).isEnabled();
	}

	@SuppressWarnings("deprecation")
	@And("^Select few series$")
	public void select_few_series() throws Throwable {
		CommonFunctionality.webDriverwait_keyvalue("Series_tab");
		CommonFunctionality.getElementByProperty(login.driver, "Series_tab", 4).click();
		CommonFunctionality.webDriverwait_keyvalue("Series_new");
		CommonFunctionality.getElementByProperty(login.driver, "Series_new", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "Search", 4).click();
		CommonFunctionality.click_on_search_close();
		CommonFunctionality.getElementByProperty(login.driver, "Search", 4).sendKeys(Keys.ENTER);
		CommonFunctionality.webDriverwait_keyvalue("Series_checkbox");
		WebElement series_cb = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_checkbox")));
		new Actions(login.driver).moveToElement(series_cb).pause(2000).click().build().perform();
	}

	@And("^Select my series tab$")
	public void select_my_series_tab() throws Throwable {
		CommonFunctionality.webDriverwait_keyvalue("Series_tab");
		CommonFunctionality.getElementByProperty(login.driver, "Series_tab", 4).click();
	}

	@SuppressWarnings("deprecation")
	@And("^Search for the series with SID \"([^\"]*)\"$")
	public void search_for_the_series_with_SID(String arg1) throws Throwable {
		Thread.sleep(5000);
		CommonFunctionality.webDriverwait_keyvalue("Series_tab");
		CommonFunctionality.getElementByProperty(login.driver, "Series_tab", 4).click();
		CommonFunctionality.webDriverwait_keyvalue("Series_new");
		CommonFunctionality.getElementByProperty(login.driver, "Series_new", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "Search", 4).clear();
		CommonFunctionality.getElementByProperty(login.driver, "Search", 4).sendKeys(Keys.chord(Keys.CONTROL, "a"),
				arg1);
		CommonFunctionality.getElementByProperty(login.driver, "Search", 4).sendKeys(Keys.ENTER);
		CommonFunctionality.wait(500);
		if (arg1.equals("384681617;385320997")) {
			List<WebElement> list = login.driver.findElements(By.xpath("//ul[@class='search-series-list']/li"));
			for (int i = 1; i <= list.size(); i++) {
				WebElement series = login.driver
						.findElement(By.xpath("//ul[@class='search-series-list']/li[" + i + "]/div/a/div[2]/span/*"));
				new Actions(login.driver).moveToElement(series).pause(3000).click().build().perform();
			}
		} else {
			WebElement series_cb = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_checkbox")));
			new Actions(login.driver).moveToElement(series_cb).pause(3000).click().build().perform();
		}
	}

	@And("^Get the text for first (\\d+) series$")
	public void get_the_text_for_first_series(int arg1) throws Throwable {
		text_series1 = CommonFunctionality
				.getElementByXpath(login.driver,
						"//ul[@class='search-series-list']/li[1]/div/a/div[3]/div[1]/div/div/div[1]/div[2]", 4)
				.getText();
		text_series2 = CommonFunctionality
				.getElementByXpath(login.driver,
						"//ul[@class='search-series-list']/li[2]/div/a/div[3]/div[1]/div/div/div[1]/div[2]", 4)
				.getText();
	}

	@And("^Search for the series in db tab with SID \"([^\"]*)\"$")
	public void search_for_the_series_in_db_tab_with_SID(String arg1) throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Databases", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "Search", 4).sendKeys(Keys.chord(Keys.CONTROL, "a"),
				arg1);
		CommonFunctionality.getElementByProperty(login.driver, "Search", 4).sendKeys(Keys.ENTER);
	}

	@SuppressWarnings("deprecation")
	@And("^Select (\\d+) series and click on \"([^\"]*)\" option$")
	public void select_series_and_click_on_option(int arg1, String arg2) throws Throwable {
		WebElement first_series = CommonFunctionality.getElementByXpath(login.driver,
				"//ul[@class='search-series-list']/li[contains(@class,'series-list-item__first-item')]", 4);
		if (!(first_series.getAttribute("class").contains("series-list-item__selected"))) {
			WebElement first = CommonFunctionality.getElementByProperty(login.driver, "First_series_item_in_series", 4);
			new Actions(login.driver).moveToElement(first).pause(2000).click().build().perform();
		}
		WebElement second_series = CommonFunctionality.getElementByProperty(login.driver,
				"Second_series_item_in_series", 4);
		new Actions(login.driver).moveToElement(second_series).pause(2000).click().build().perform();
		WebElement actions = CommonFunctionality.getElementByProperty(login.driver, "Series_actions", 4);
		new Actions(login.driver).moveToElement(actions).pause(2000).build().perform();
		if (arg2.equalsIgnoreCase("Chart")) {
			WebElement chart;
			try {
				chart = CommonFunctionality.getElementByProperty(login.driver, "View_as_chart_in_series", 4);
			} catch (Exception e) {
				chart = CommonFunctionality.getElementByXpath(login.driver,
						"(//*[contains(@class,'series-item-information--additional-info-field__dates')])[1]", 4);
			}
			new Actions(login.driver).moveToElement(chart).pause(2000).click().build().perform();
		} else if (arg2.equalsIgnoreCase("A")) {
			new Actions(login.driver).sendKeys("a").pause(2000).build().perform();
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Select a series on right$")
	public void select_a_series_on_right() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement series = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_checkbox_right")));
		new Actions(login.driver).pause(2000).moveToElement(series).pause(2000).click().build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Click on any series from series tab$")
	public void click_on_any_series_from_series_tab() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Series", 4).click();
		WebElement hovor_series = CommonFunctionality.getElementByProperty(login.driver, "One_series_from_seriesList",
				4);
		new Actions(login.driver).moveToElement(hovor_series).pause(3000).build().perform();
	}

	@And("^Observe the \"([^\"]*)\" for popup$")
	public void observe_the_for_popup(String arg1) throws Throwable {
		modal_text = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'movable-modal--window')]//*[@class='" + arg1 + "']", 4).getText();
	}

	@SuppressWarnings("deprecation")
	@And("^Click on functions wizard from right panel series$")
	public void click_on_functions_wizard_from_right_panel_series() throws Throwable {
		WebElement one_series = CommonFunctionality.getElementByProperty(login.driver, "One_series_from_myserieslist",
				8);
		new Actions(login.driver).pause(1000).moveToElement(one_series).pause(2000).perform();
		WebElement apply_functions = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@title,'Apply Function')]", 8);
		new Actions(login.driver).moveToElement(apply_functions).pause(3000).click().build().perform();
	}

	@And("^Select all series from myseries and click on \"([^\"]*)\" option$")
	public void select_all_series_from_myseries_and_click_on_option(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		boolean select_all = login.driver.findElement(By.xpath("//input[@name='select_all_dataselection']"))
				.isSelected();
		if (select_all != true) {
			new Actions(login.driver)
					.moveToElement(login.driver.findElement(By.xpath("//input[@name='select_all_dataselection']")))
					.click().build().perform();
			WebElement relate = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(text(),'" + arg1 + "')] | //*[contains(@title,'" + arg1 + "')]", 4);
			js.executeScript("arguments[0].click();", relate);
		}
	}

	@And("^click on 'fx' to open 'All functions' popup$")
	public void click_on_fx_to_open_All_functions_popup() throws Throwable {
		// CommonFunctionality.webDriverwait_keyvalue("fx");
		WebElement toolbar = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'fx-panel-toggle')]", 4);
		if (!(toolbar.getAttribute("class").contains("fx-panel-toggle__is-open"))) {
			toolbar.click();
		}
		WebElement function = CommonFunctionality.getElementByProperty(login.driver, "fx", 4);
		js.executeScript("arguments[0].click();", function);
		CommonFunctionality.webDriverwait_keyvalue("function_wizard");
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("function_wizard"))).isDisplayed()) {
			System.out.println("Functions wizard is displaying");
		}
	}

	@And("^Enter \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" function$")
	public void enter_function(String arg1, String arg2, String arg3) throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Functions_input_field", 4).click();
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByProperty(login.driver, "Functions_input_field", 4).sendKeys(arg1);
		CommonFunctionality.getElementByProperty(login.driver, "Functions_input_field", 4).sendKeys(Keys.ENTER);
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByProperty(login.driver, "Functions_input_field", 4).sendKeys(arg2);
		CommonFunctionality.getElementByProperty(login.driver, "Functions_input_field", 4).sendKeys(Keys.ENTER);
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByProperty(login.driver, "Functions_input_field", 4).sendKeys(arg3);
		CommonFunctionality.getElementByProperty(login.driver, "Functions_input_field", 4).sendKeys(Keys.ENTER);
		CommonFunctionality.wait(500);
		series_title_function = "[" + arg1 + "(" + arg2 + "; " + arg3 + ")]";
	}

	@And("^choose \"([^\"]*)\" function$")
	public void choose_function(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'search-functions-input')]", 4)
				.sendKeys(arg1);
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'search-functions-input')]", 4)
				.sendKeys(Keys.ENTER);
		try {
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[@data-id='" + arg1 + "' and @class='function-item']", 4)
					.click();
		} catch (Exception e) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),' " + arg1 + "')]", 4).click();
		}
	}

	@And("^click on \"([^\"]*)\" in functions search$")
	public void click_on_in_functions_search(String arg1) throws Throwable {
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[@class='function-wizard-sidebar']//following::*[contains(text(),'" + arg1 + "')] ", 4)
				.click();
	}

	@SuppressWarnings("deprecation")
	@And("^Click the series title which matching applied function name$")
	public void click_the_series_title_which_matching_applied_function_name() throws Throwable {
		String title = CommonFunctionality.getElementByClassName(login.driver, "series-functions-title", 4).getText();
		if (title.contains(series_title_function)) {
			WebElement function = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='series-functions-title']/preceding-sibling::span", 4);
			new Actions(login.driver).moveToElement(function).pause(2000).click().build().perform();
		}
	}

	@And("^Verify the title in SSP Window$")
	public void verify_the_title_in_SSP_Window() throws Throwable {
		CommonFunctionality.wait(500);
		title_ssp = CommonFunctionality.getElementByClassName(login.driver, "single-series-preview--title", 4)
				.getText();
	}

	@And("^Click \"([^\"]*)\" > \"([^\"]*)\"$")
	public void click(String arg1, String arg2) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'header-menu') and contains(text(),'" + arg1 + "')]", 4).click();
		CommonFunctionality.wait(200);
		if (arg2.equalsIgnoreCase("View") || arg2.equalsIgnoreCase("Open") || arg2.equalsIgnoreCase("New")) {
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(@class,'header-menu')]//following-sibling::*[text()='" + arg2 + "']", 4)
					.click();
			CommonFunctionality.wait(1000);
		} else {
			try {
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'header-menu') and contains(text(),'" + arg2 + "')]", 4).click();
			} catch (Exception e) {
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'header-menu') and contains(text(),'" + arg2 + "')]", 4);
			}
		}
	}

	@And("^Click on \"([^\"]*)\" tab in popup$")
	public void click_on_tab_in_popup(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 4).click();
	}

	@SuppressWarnings("deprecation")
	@And("^Click on the insight point$")
	public void click_on_the_insight_point() throws Throwable {
		WebElement help = CommonFunctionality.getElementByProperty(login.driver, "highcharts_point_insight", 4);
		new Actions(login.driver).moveToElement(help).pause(2000).click().build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Mouse over to \"([^\"]*)\"$")
	public void mouse_over_to(String arg1) throws Throwable {
		WebElement help = CommonFunctionality.getElementByClassName(login.driver, "" + arg1 + "--wrapper", 4);
		new Actions(login.driver).moveToElement(help).pause(2000).build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Mouse over to \"([^\"]*)\" from insights$")
	public void mouse_over_to_from_insights(String arg1) throws Throwable {
		WebElement help = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='insight-preview--views']//*[@class='" + arg1 + "--wrapper']", 4);
		new Actions(login.driver).moveToElement(help).pause(2000).build().perform();
	}

	@And("^Collapse the footnotes$")
	public void collapse_the_footnotes() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "footnotes_contents_collapse", 4).click();
		CommonFunctionality.wait(500);
	}

	@SuppressWarnings("deprecation")
	@And("^Hover on to the \"([^\"]*)\"$")
	public void hover_on_to_the(String arg1) throws Throwable {
		WebElement footnotes = CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg1 + "']", 4);
		new Actions(login.driver).moveToElement(footnotes).pause(2000).build().perform();
		footnotes_contents = footnotes.getAttribute("title");
	}

	@And("^Click \"([^\"]*)\" option from empty list$")
	public void click_option_from_empty_list(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg1 + "']", 4).click();
	}

	@And("^Click \"([^\"]*)\" button in images wizard$")
	public void click_button_in__images_wizard(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg1 + "']", 4).click();
	}

	@And("^Click \"([^\"]*)\" button to upload images$")
	public void click_button_to_upload_images(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@aria-label='" + arg1 + "']", 4).click();
		CommonFunctionality.wait(500);
		CommonFunctionality.fileUpload(login.driver, System.getProperty("user.dir") + "\\Images\\Shravas.png");
	}

	@And("^Click on \"([^\"]*)\" tab in insights$")
	public void click_on_tab_in_insights(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='insights-group-item--title' and text()='" + arg1 + "']", 4).click();
	}

	@And("^Click \"([^\"]*)\" to create a new insight$")
	public void click_to_create_a_new_insight(String arg1) throws Throwable {
		WebElement new_insight = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'sphere-modal__content')]//button[text()='" + arg1 + "']", 4);
		js.executeScript("arguments[0].click();", new_insight);
	}

	@SuppressWarnings("deprecation")
	@And("^Click on one ingisht under EMIS insight$")
	public void click_on_one_ingisht_under_EMIS_insight() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "EMIS_Insight_Landingpage", 8).click();
		WebElement title = CommonFunctionality.getElementByClassName(login.driver, "insight-icon-item--bottom-panel",
				4);
		new Actions(login.driver).moveToElement(title).pause(2000).build().perform();
		WebElement preview = CommonFunctionality.getElementByProperty(login.driver, "EMIS_Insight", 4);
		new Actions(login.driver).moveToElement(preview).pause(3000)
				.click(login.driver
						.findElement(By.xpath("(//*[contains(@class,'button__ghost') and text()='View'])[1]")))
				.build().perform();
	}

	@And("^Click on the insight button \"([^\"]*)\"$")
	public void click_on_the_insight_button(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'sphere-modal__content')]//*[text()='" + arg1 + "']", 4).click();
	}

	@And("^Open notification panel$")
	public void open_notification_panel() throws Throwable {
		WebElement notification = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='user-panel']//*[@class='user-notifications--icon']", 4);
		new Actions(login.driver).moveToElement(notification).click().build().perform();
	}

	@And("^Open preference dropdown$")
	public void open_preference_dropdown() throws Throwable {
		WebElement preferences = CommonFunctionality.getElementByClassName(login.driver, "account-avatar--container",
				4);
		new Actions(login.driver).moveToElement(preferences).click().build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Click on \"([^\"]*)\" from preferences$")
	public void click_on_from_preferences(String arg1) throws Throwable {
		new Actions(login.driver).moveToElement(login.driver.findElement(By.xpath("//*[text()='Change password']")))
				.pause(1000).build().perform();
		WebElement pencil_icon = CommonFunctionality.getElementByClassName(login.driver, "" + arg1 + "", 4);
		new Actions(login.driver).moveToElement(pencil_icon).pause(2000).click().build().perform();
	}

	@And("^Choose \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" from preferences$")
	public void choose_from_preferences(String arg1, String arg2, String arg3) throws Throwable {
		prefix = CommonFunctionality.getElementByXpath(login.driver,
				"//*[text()='" + arg1 + "']//following-sibling::*//*[@class='select2-chosen']", 4).getText();
		first_name = CommonFunctionality
				.getElementByXpath(login.driver, "//*[text()='" + arg2 + "']//following-sibling::*", 4)
				.getAttribute("value");
		last_name = CommonFunctionality
				.getElementByXpath(login.driver, "//*[text()='" + arg3 + "']//following-sibling::*", 4)
				.getAttribute("value");
	}

	@And("^Click \"([^\"]*)\" button in preferences$")
	public void click_button_in_preferences(String arg1) throws Throwable {
		boolean enabled = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='profile-modal--buttons']//*[text()='" + arg1 + "']", 4)
				.isEnabled();
		if (enabled == true) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='profile-modal--buttons']//*[text()='" + arg1 + "']", 4).click();
		}
	}

	@And("^Click on edit in \"([^\"]*)\" from preferences$")
	public void click_on_edit_in_from_preferences(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']/following::span[1]", 4).click();
		CommonFunctionality.getElementByXpath(login.driver,
				"(//ul[@class='select2-results']//*[@class='select2-result-label'])[5]", 4).click();
		prefix_edit = CommonFunctionality
				.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']/following::span[1]", 4).getText();
	}

	@And("^Click on edit in \"([^\"]*)\" from preferences option$")
	public void click_on_edit_in_from_preferences_option(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']/following-sibling::input", 4)
				.clear();
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']/following-sibling::input", 4)
				.sendKeys("Shravas");
	}

	@And("^Click on edit in \"([^\"]*)\" from user preferences$")
	public void click_on_edit_in_from_user_preferences(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']/following-sibling::input", 4)
				.clear();
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']/following-sibling::input", 4)
				.sendKeys("Shravas");
	}

	@And("^Close the dialog popup$")
	public void close_the_dialog_popup() throws Throwable {
		if (login.driver.findElements(By.className("movable-modal--close")).size() > 0) {
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		}
	}

	@And("^Check for the popup window in preferences$")
	public void check_for_the_popup_window_in_preferences() throws Throwable {
		preference_popup = CommonFunctionality.getElementByClassName(login.driver, "movable-modal--title-message", 4)
				.getText();
	}

	@SuppressWarnings("deprecation")
	@And("^Click on \"([^\"]*)\" icon to share insight$")
	public void click_on_icon_to_share_insight(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		WebElement share_icon = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'insight-share-button__gray') and contains(@title,'" + arg1 + "')]", 4);
		new Actions(login.driver).moveToElement(share_icon).pause(1000).click().build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Hover on \"([^\"]*)\" button in insight preview$")
	public void hover_on_button_in_insight_preview(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		try {
			ok_button = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'sphere-modal__content')]//*[text()='" + arg1 + "']", 4);
		} catch (Exception e) {
			ok_button = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'sphere-modal__content')]//*[text()=\"" + arg1 + "\"]", 4);
		}
		new Actions(login.driver).moveToElement(ok_button).pause(1000).build().perform();
	}

	@And("^Select Users to share$")
	public void select_Users_to_share() throws Throwable {
		mail = "ceicsuresh13@gmail.com";
		CommonFunctionality
				.getElementByXpath(login.driver, "//input[@placeholder='Select people you want to invite']", 4)
				.sendKeys(mail);
		CommonFunctionality
				.getElementByXpath(login.driver, "//input[@placeholder='Select people you want to invite']", 4)
				.sendKeys(Keys.DOWN, Keys.RETURN);
	}

	@And("^Select Users to share for second time$")
	public void select_Users_to_share_for_second_time() throws Throwable {
		String mail2 = "sud_kul@yahoo.com";
		CommonFunctionality
				.getElementByXpath(login.driver, "//input[@placeholder='Select people you want to invite']", 4)
				.sendKeys(mail2);
		CommonFunctionality
				.getElementByXpath(login.driver, "//input[@placeholder='Select people you want to invite']", 4)
				.sendKeys(Keys.DOWN, Keys.RETURN);
	}

	@And("^Click on \"([^\"]*)\" button to share$")
	public void click_on_button_to_share(String arg1) throws Throwable {
		boolean save = login.driver
				.findElement(By.xpath("//*[contains(@class,'sphere-modal__body')]//button[text()='" + arg1 + "']"))
				.isEnabled();
		if (save == true) {
			System.out.println("Save button is selected for sharing insight");
			login.driver
					.findElement(By.xpath("//*[contains(@class,'sphere-modal__body')]//button[text()='" + arg1 + "']"))
					.click();
		} else {
			System.out.println("Save button is disabled for sharing insight. Hence unable to share");
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Right click on Insight name and click on \"([^\"]*)\"$")
	public void right_click_on_Insight_name_and_click_on(String arg1) throws Throwable {
		WebElement right_click = CommonFunctionality.getElementByProperty(login.driver, "First_insightname_from_list",
				4);
		new Actions(login.driver).moveToElement(right_click).pause(2000).contextClick().build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='items-wrapper']//*[@title='" + arg1 + "']", 4)
				.click();
		CommonFunctionality.wait(100);
	}

	@And("^Highlight the functions and check for the tooltips$")
	public void highlight_the_functions_and_check_for_the_tooltips() throws Throwable {
		functions = login.driver.findElements(By.xpath("//*[@class='popular-functions-context--function-item']"));
		System.out.println("Total Functions displayed are: " + functions.size());
	}

	@And("^Check for the function buttons$")
	public void check_for_the_function_buttons() throws Throwable {
		if (CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'All functions')]", 8)
				.isDisplayed()) {
			System.out.println("Functions wizard is opened");
		}
	}

	@And("^User has selected \"([^\"]*)\" frequency unit$")
	public void user_has_selected_frequency_unit(String arg1) throws Throwable {
		var = arg1;
		try {
			frequency = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='search-filter-container']//*[contains(text(),'" + var + "')]", 4).getText();
		} catch (Exception e) {
			List<String> texts = Arrays.asList(var);
			String values = String.join(";", texts);
			values_list = values;
		}
	}

	@And("^Check the display day-unit date picker$")
	public void check_for_display_dayunit_date_picker() throws Throwable {
		CommonFunctionality.wait(2000);
		start_format_datepicker = CommonFunctionality
				.getElementByXpath(login.driver, "(//*[@class='highcharts-label highcharts-range-input']/*[2])[1]", 4)
				.getText();
		CommonFunctionality.wait(500);
		end_format_datepicker = CommonFunctionality
				.getElementByXpath(login.driver, "(//*[@class='highcharts-label highcharts-range-input']/*[2])[2]", 4)
				.getText();
	}

	@SuppressWarnings("deprecation")
	@And("^Hover to click on create \"([^\"]*)\"$")
	public void hover_to_click_on_create(String arg1) throws Throwable {
		WebElement one_series;
		try {
			one_series = CommonFunctionality.getElementByProperty(login.driver, "First_series_item", 8);
		} catch (Exception e) {
			one_series = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[@class='series-list-item-data']//following-sibling::*[@class='series-item-information'])[1]",
					4);
		}
		new Actions(login.driver).moveToElement(one_series).pause(1000).build().perform();
		WebElement visual = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='series-representation--list']/div/ul/li[1]/div/a/div[3]/div[2]/span[contains(@title,'"
						+ arg1
						+ "')] | //*[contains(@class,'tree-series-list')]/ul/li[1]/div/a/div[3]/div[2]/span[contains(@title,'"
						+ arg1 + "')]",
				4);
		new Actions(login.driver).moveToElement(visual).pause(2000).click().build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Click on more actions$")
	public void click_on_more_actions() throws Throwable {
		WebElement one_series = CommonFunctionality.getElementByProperty(login.driver, "Series_item_information", 8);
		new Actions(login.driver).moveToElement(one_series).pause(1000).build().perform();
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='series-representation--list']/div/ul/li[1]/div/a/div[3]/div[2]/span[contains(@title,'More actions')] | //*[contains(@class,'tree-series-list')]/ul/li[1]/div/a/div[3]/div[2]/span[contains(@title,'More actions')]",
				4).click();
	}

	@SuppressWarnings("deprecation")
	@And("^Click on more actions to create \"([^\"]*)\"$")
	public void click_on_more_actions_to_create(String arg1) throws Throwable {
		WebElement one_series;
		try {
			one_series = CommonFunctionality.getElementByProperty(login.driver, "Series_item_information", 8);
		} catch (Exception e) {
			one_series = CommonFunctionality.getElementByProperty(login.driver, "Series_item_information_hover", 8);
		}
		new Actions(login.driver).moveToElement(one_series).pause(1000).build().perform();
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='series-representation--list']/div/ul/li[1]/div/a/div[3]/div[2]/span[contains(@title,'More actions')] | //*[contains(@class,'tree-series-list')]/ul/li[1]/div/a/div[3]/div[2]/span[contains(@title,'More actions')]",
				4).click();
		CommonFunctionality.wait(500);
		WebElement visual = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='series-representation--list']/div/ul/li[1]/div/a/div[3]/div[2]/span[contains(@title,'View as "
						+ arg1 + "')] | //span[contains(text(),'" + arg1 + "')]",
				4);
		new Actions(login.driver).moveToElement(visual).pause(1000).click().build().perform();
	}

	@And("^Choose \"([^\"]*)\" > \"([^\"]*)\"$")
	public void choose(String arg1, String arg2) throws Throwable {
		WebElement view = login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]"));
		new Actions(login.driver).moveToElement(view).build().perform();
		CommonFunctionality.webDriverwait_locator("//span[contains(text(),'" + arg2 + "')]", "xpath");
		login.driver.findElement(By.xpath("//span[contains(text(),'" + arg2 + "')]")).click();
		try {
			if (arg2.equalsIgnoreCase("Histogram")) {
				CommonFunctionality.webDriverwait_locator("//button[contains(text(),'Ok')]", "xpath");
				CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 4).click();
			}
		} catch (NoSuchElementException e) {
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Open a \"([^\"]*)\" visual$")
	public void open_a_visual(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		WebElement visual = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='series-representation--list']/div/ul/li[1]/div/a/div[3]/div[2]/span[contains(@title,'View as "
						+ arg1
						+ "')] | //*[@class='series-representation--list']/div/ul/li[1]/div/a/div[3]/div[2]/span[contains(@title,'Chart')]",
				4);
		new Actions(login.driver).moveToElement(visual).pause(1000).click().build().perform();
		CommonFunctionality.wait(1000);
	}

	@And("^Click on \"([^\"]*)\" visual$")
	public void click_on_visual(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Add related series") || arg1.equalsIgnoreCase("Edit Table")) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'left-controls')]//button[text()='" + arg1 + "']", 4).click();
			CommonFunctionality.wait(500);
		} else {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'left-controls')]//button[text()='" + arg1 + " Chart']", 4).click();
			CommonFunctionality.wait(500);
		}
	}

	@And("^check the \"([^\"]*)\" and \"([^\"]*)\" options$")
	public void check_the_and_options(String arg1, String arg2) throws Throwable {
		chart_checkbox4 = login.driver
				.findElement(By.xpath(
						"//*[text()='" + arg1 + "' and @class='input-control--description']/preceding::input[1]"))
				.isSelected();
		if (chart_checkbox4 == false) {
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[text()='" + arg1 + "' and @class='input-control--description']/preceding::span[1]", 4)
					.click();
		}
		chart_checkbox5 = login.driver
				.findElement(By.xpath(
						"//*[text()='" + arg2 + "' and @class='input-control--description']/preceding::input[1]"))
				.isSelected();
		if (chart_checkbox5 == false) {
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[text()='" + arg2 + "' and @class='input-control--description']/preceding::span[1]", 4)
					.click();
		}
	}

	@And("^Uncheck the \"([^\"]*)\" and \"([^\"]*)\" options$")
	public void uncheck_the_and_options(String arg1, String arg2) throws Throwable {
		text1 = arg1;
		text2 = arg2;
		chart_checkbox = login.driver.findElement(By.xpath(
				"//*[text()='" + text1 + "' and @class='input-control--description']/preceding::input[1] | //*[text()='"
						+ text1 + "' and @class='table-properties-context-title']/preceding::input[1]"))
				.isSelected();
		if (chart_checkbox == true) {
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[text()='" + text1
									+ "' and @class='input-control--description']/preceding::span[1] | //*[text()='"
									+ text1 + "' and @class='table-properties-context-title']/preceding::span[1]",
							4)
					.click();
		}
		chart_checkbox1 = login.driver.findElement(By.xpath(
				"//*[text()='" + text2 + "' and @class='input-control--description']/preceding::input[1] | //*[text()='"
						+ text2 + "' and @class='table-properties-context-title']/preceding::input[1]"))
				.isSelected();
		if (chart_checkbox1 == true) {
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[text()='" + text2
									+ "' and @class='input-control--description']/preceding::span[1] | //*[text()='"
									+ text2 + "' and @class='table-properties-context-title']/preceding::span[1]",
							4)
					.click();
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Create a new template$")
	public void create_a_new_template() throws Throwable {
		WebElement add_template = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'add-style-template')]", 4);
		if (add_template.getAttribute("class").contains("add-style-template__active")) {
			add_template.click();
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='add-template-context--wrapper']//*[contains(@class,'add-template-context--input')]", 4)
					.sendKeys(send);
			new Actions(login.driver).pause(2000).sendKeys(Keys.ENTER).perform();
			if (login.driver.findElements(By.className("sphere-modal__content")).size() > 0) {
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']", 4).click();
			}
		}
	}

	@And("^Create a new template and \"([^\"]*)\" and click \"([^\"]*)\" icon$")
	public void create_a_new_template_and_and_click_icon(String arg1, String arg2) throws Throwable {
		WebElement add_template = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'add-style-template')]", 4);
		if (arg1.equalsIgnoreCase("Template popup") && arg2.equalsIgnoreCase("Cancel")) {
			if (add_template.getAttribute("class").contains("add-style-template__active")) {
				login.Log4j.info("Add Custom template icon is Enabled and Displayed");
				add_template.click();
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='add-template-context--wrapper']//*[contains(@class,'add-template-context--input')]",
						4).sendKeys(send);
				WebElement cancel = CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='add-template-context--wrapper']//*[contains(@class,'add-template-context--icon__close')]",
						4);
				new Actions(login.driver).moveToElement(cancel).click().build().perform();
				login.Log4j.info(arg2 + " icon is clicked");
			}
		} else {
			fail("Add template popup is not enabled");
		}
	}

	@And("^\"([^\"]*)\" the newly created template$")
	public static void the_newly_created_template(String arg1) throws Throwable {
		List<WebElement> deleting_template = login.driver.findElements(By.xpath("//*[@title='" + arg1 + "']"));
		WebElement close = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@title='" + arg1 + "']/ancestor::div[1]", 4);
		for (WebElement delete : deleting_template) {
			if (close.getAttribute("title").contains(send)) {
				delete.click();
				if (login.driver.findElements(By.xpath("//*[contains(@class,'modal-content')]//*[text()='Ok']"))
						.size() > 0) {
					CommonFunctionality
							.getElementByXpath(login.driver, "//*[contains(@class,'modal-content')]//*[text()='Ok']", 4)
							.click();
				}
				/*
				 * if(login.driver.findElements(By.className("movable-modal--close")).size()>0)
				 * { CommonFunctionality.getElementByClassName(login.driver,
				 * "movable-modal--close", 4).click(); }
				 */
				break;
			}
		}
	}

	@And("Close the model box$")
	public void close_the_model_box() throws Throwable {
		if (login.driver.findElements(By.className("movable-modal--close")).size() > 0) {
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		}
		CommonFunctionality.Views_list();
	}

	@And("^\"([^\"]*)\" the newly created customized template$")
	public void the_newly_created_customized_template(String arg1) throws Throwable {
		List<WebElement> deleting_template = login.driver.findElements(By.xpath("//*[@title='" + arg1 + "']"));
		WebElement close = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@title='" + arg1 + "']/ancestor::div[1]", 4);
		for (WebElement delete : deleting_template) {
			if (close.getAttribute("title").contains(send)) {
				delete.click();
				if (login.driver.findElements(By.xpath("//*[contains(@class,'modal-content')]//*[text()='Ok']"))
						.size() > 0) {
					CommonFunctionality
							.getElementByXpath(login.driver, "//*[contains(@class,'modal-content')]//*[text()='Ok']", 4)
							.click();
				}
				if (login.driver.findElements(By.className("movable-modal--close")).size() > 0) {
					CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
				}
				break;
			}
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Clicking on the hiding template from the style template dropdown$")
	public void clicking_on_the_hiding_template_from_the_style_template_dropdown() throws Throwable {
		WebElement dropdown = CommonFunctionality.getElementByProperty(login.driver, "Style_template_arrow_icon", 4);
		new Actions(login.driver).moveToElement(dropdown).pause(1000).click().build().perform();
		title_text = CommonFunctionality.getElementByProperty(login.driver, "CEIC_template_styles", 4)
				.getAttribute("title");
		
		WebElement ceic = CommonFunctionality.getElementByProperty(login.driver, "CEIC_template_styles", 4);
		new Actions(login.driver).moveToElement(ceic).click().build().perform();
		CommonFunctionality.wait(1000);
		new Actions(login.driver).moveToElement(dropdown).pause(1000).click().build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Choose \"([^\"]*)\" > \"([^\"]*)\" > \"([^\"]*)\" > \"([^\"]*)\" >$")
	public void choose(String arg1, String arg2, String arg3, String arg4) throws Throwable {
		boolean checkbox = login.driver
				.findElement(By.xpath(
						"//*[contains(text(),'" + arg1 + "')]//preceding::*[@class='input-control--indicator'][1]"))
				.isSelected();
		if (checkbox == true) {
			login.driver
					.findElement(By.xpath(
							"//*[contains(text(),'" + arg1 + "')]//preceding::*[@class='input-control--indicator'][1]"))
					.click();
		}

		WebElement advanced = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'" + arg1 + "')]//following::*[contains(@title,'" + arg2 + "')][1]", 4);
		js.executeScript("arguments[0].click();", advanced);
		CommonFunctionality.wait(1000);
		WebElement format = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='popover--wrapper']//*[contains(text(),'" + arg3 + "') and not(@class='popover--title')]",
				4);
		if (!(arg3.equals("Labels") || arg3.equalsIgnoreCase("Attributes"))) {
			js.executeScript("arguments[0].click();", format);
		}
		if (arg3.equals("Date format")) {
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[@class='popover-block-content']//following::*[@class='context-menu-control--icon']", 4)
					.click();
		}
		/*
		 * if(arg3.equalsIgnoreCase("Attributes")) {
		 * CommonFunctionality.getElementByXpath(login.driver,
		 * "//*[@class='popover--wrapper']//*[contains(text(),'"+
		 * arg3+"') and not(@class='popover--title')]", 4); }
		 */
		CommonFunctionality.wait(200);
		WebElement radio = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'--context-menu')]//*[text()='" + arg4
						+ "']//preceding-sibling::*[@class='input-control--indicator'] | //*[text()='" + arg4
						+ "']//preceding-sibling::*[@class='input-control--indicator']",
				4);
		new Actions(login.driver).moveToElement(radio).pause(2000).click().build().perform();
		if (arg4.equalsIgnoreCase("Attributes")) {
			WebElement attrib = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='popover--wrapper']",
					4);
			new Actions(login.driver).moveToElement(attrib).perform();
		}
		CommonFunctionality.wait(500);
		if (arg4.equals("Auto")) {
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[@class='popover-block-content']//following::*[@class='context-menu-control--icon']", 4)
					.click();
		}
		if (arg3.equals("Date format")) {
			date_type = CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[@class='popover--wrapper']//*[@class='context-menu-control--title']/div[1]", 4)
					.getText();
			String date_format = CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[@class='popover-block-content']//following::*[@class='date-format-example']", 4)
					.getText();
			if (date_format.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")) {
				System.out.println("The date format is Custom and the date format example is " + date_format);
			} else if (date_format.matches("([0-9]{2})/([0-9]{4})")) {
				System.out.println("The date format is Auto and the date format example is " + date_format);
			}
			if (login.driver.findElements(By.xpath("//*[@class='popover--wrapper']//*[@class='popover--close']"))
					.size() > 0 && arg4.equals("Auto")) {
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='popover--wrapper']//*[@class='popover--close']", 4).click();
			} else if (login.driver.findElements(By.xpath("//*[@class='popover--wrapper']//*[@class='popover--close']"))
					.size() > 0 && arg4.equals("Specific")) {
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='popover--wrapper']//*[@class='popover--close']", 4).click();
			}
		}
		if (arg4.equals("Specific")) {
			spinner = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='data-labels-control--option' and @js-specific-last-observations='']//following::*[contains(@class,'spinner-control')]",
					4);
		}
		if (arg4.equals("Attributes")) {
			expand = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'accordion-config')]", 4);
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Choose options \"([^\"]*)\" > \"([^\"]*)\"$")
	public void choose_options(String arg1, String arg2) throws Throwable {
		boolean checkbox = login.driver
				.findElement(By
						.xpath("//*[contains(text(),'" + arg1 + "')]//preceding::*[@class='input-control--input'][1]"))
				.isSelected();
		if (checkbox == true) {
			WebElement click = login.driver.findElement(By
					.xpath("//*[contains(text(),'" + arg1 + "')]//preceding::*[@class='input-control--indicator'][1]"));
			new Actions(login.driver).moveToElement(click).pause(2000).doubleClick().build().perform();
			new Actions(login.driver).moveToElement(click).pause(2000).click().build().perform();
		}
		CommonFunctionality.wait(500);
		/*
		 * if (checkbox==false) { login.driver.findElement(By.xpath(
		 * "//*[contains(text(),'" + arg1 +
		 * "')]//preceding::*[@class='input-control--input'][1]")).click(); }
		 */
		if (arg2.equals("Rows")) {
			zebra_text = CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(text(),'" + arg1 + "')]//following::*[contains(@class,'title--text')][1]", 4)
					.getText();
		}
	}

	@And("^Clicking \"([^\"]*)\" option$")
	public void clicking_option(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		WebElement enable = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'sphere-modal__body')]//*[contains(text(),'" + arg1
						+ "')] | //*[contains(@class,'movable-modal--body')]//*[contains(text(),'" + arg1 + "')]",
				4);
		js.executeScript("arguments[0].click();", enable);
	}

	@And("^Perform \"([^\"]*)\" operation$")
	public void perform_operation(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'download-button') and contains(@title,'" + arg1 + "')]", 4).click();
	}

	@And("^Click \"([^\"]*)\" button$")
	public void click_button(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//button[text()='" + arg1 + "']", 4).click();
	}

	@And("^Click on the button \"([^\"]*)\"$")
	public void click_on_the_button(String arg1) throws Throwable {
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[contains(@class,'installation-download-button')]//*[contains(text(),'" + arg1 + "')]", 4)
				.click();
	}

	@And("^check \"([^\"]*)\" button$")
	public void check_button(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		button = CommonFunctionality.getElementByXpath(login.driver, "//button[text()='" + arg1 + "']", 4).isEnabled();
		if (button == true) {
			login.Log4j.info(arg1 + " button is enabled");
		} else {
			login.Log4j.info(arg1 + " button is not enabled");
		}
	}

	@And("^click on \"([^\"]*)\" option under annotations$")
	public void click_on_option_under_annotations(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='annotations-menu']//*[contains(@class,'" + arg1 + "')]", 4).click();
	}

	@SuppressWarnings("deprecation")
	@And("^Click on \"([^\"]*)\" option from annotation selection$")
	public void click_on_option_from_annotation_selection(String arg1) throws Throwable {
		WebElement annotation_option = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='name-li' and text()='" + arg1 + "']", 4);
		new Actions(login.driver).moveToElement(annotation_option).pause(2000).click().build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^hover on to \"([^\"]*)\"$")
	public void hover_on_to(String arg1) throws Throwable {
		WebElement hover = CommonFunctionality.getElementByClassName(login.driver, "annotation-cursor--layout", 4);
		new Actions(login.driver).moveToElement(hover).pause(3000).build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Hover the \"([^\"]*)\"$")
	public void hover_the(String arg1) throws Throwable {
		WebElement title = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='" + arg1 + "']", 4);
		new Actions(login.driver).moveToElement(title).pause(2000).build().perform();
	}

	@And("^Customize popup is opened and Click on \"([^\"]*)\" option$")
	public void customize_popup_is_opened_and_Click_on_option(String arg1) throws Throwable {
		WebElement custom = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'sphere-modal__body')]", 4);
		if (custom.isDisplayed()) {
			System.out.println("Customize popup is displayed");
		}
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'" + arg1 + "')]/following::*[@class='select2-arrow']", 4).click();
	}

	@And("^Click \"([^\"]*)\" option from dropdown$")
	public void click_option_from_dropdown(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='select2-results']//following::*[text()='" + arg1 + "']", 4).click();
		CommonFunctionality.wait(500);
		String update = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='select2-chosen' and text()='" + arg1 + "']", 4).getText();
		assertEquals(arg1, update);
	}

	@SuppressWarnings("deprecation")
	@And("^Press \"([^\"]*)\" button in keyboard$")
	public void press_button_in_keyboard(String arg1) throws Throwable {
		new Actions(login.driver).pause(2000).sendKeys(Keys.ESCAPE).perform();
		login.Log4j.info(arg1 + " operation is performed");
	}

	@SuppressWarnings("deprecation")
	@And("^Press \"([^\"]*)\" button in the keyboard$")
	public void press_button_in_the_keyboard(String arg1) throws Throwable {
		new Actions(login.driver).pause(2000).sendKeys(Keys.ENTER).perform();
	}

	@And("^Check for \"([^\"]*)\" and \"([^\"]*)\" controls$")
	public void check_for_and_controls(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(2000);
		halfscreen = CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg1 + "']", 4);
		if (halfscreen.isDisplayed()) {
			halfscreen.click();
		}
		CommonFunctionality.wait(2000);
		fullscreen = CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg2 + "']", 4);
		if (fullscreen.isDisplayed()) {
			fullscreen.click();
		}
	}

	@And("^Click on \"([^\"]*)\" icon from SSP window$")
	public void click_on_icon_from_SSP_window(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 4).click();
	}

	@And("^Get date from chart$")
	public void get_date_from_chart() throws Throwable {
		CommonFunctionality.wait(500);
		chart_from_date = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(@class,'highcharts-range-input')][1]/*[2]", 4).getText();
		CommonFunctionality.wait(500);
		chart_to_date = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(@class,'highcharts-range-input')][2]/*[2]", 4).getText();
		CommonFunctionality.wait(500);
	}

	@And("^Select type as \"([^\"]*)\"$")
	public void select_type_as(String arg1) throws Throwable {
		type_chart = arg1;
		List<WebElement> chart_type = login.driver.findElements(By.className("types-list-item--title"));
		for (WebElement chart : chart_type) {
			String chart_text = chart.getText();
			if (chart_text.equals(type_chart)) {
				WebElement type = CommonFunctionality.getElementByXpath(login.driver,
						"//*[text()='" + type_chart + "']/ancestor::*[2]", 4);
				new Actions(login.driver).moveToElement(type).click().build().perform();
				CommonFunctionality
						.getElementByXpath(login.driver, "//*[text()='" + type_chart + "']/ancestor::*[2]", 4).click();
				break;
			}
		}
	}

	@And("^Check \"([^\"]*)\" option$")
	public void check_option(String arg1) throws Throwable {
		chart_option = arg1;
		if (arg1.equals("Move to right")) {
			axis = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'table--column__auto-width')]/following::*[contains(@title,'" + arg1 + "')]",
					4);
			axis.click();
		} else if (arg1.equals("Move to left")) {
			axis = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'table--column__auto-width')]/following::*[contains(@title,'" + arg1 + "')]",
					4);
		} else {
			stroke = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'insight-action-panel--btn') and contains(@title,'chart " + arg1 + "')]", 4);
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Select all series from the table$")
	public void select_all_series_from_the_table() throws Throwable {
		String a = "Empty";
		String b = "International Monetary Fund";
		String c = "World Bank";
		List<WebElement> li = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("Table_exclude_empty_series")));
		List<WebElement> li_empty = login.driver
				.findElements(By.xpath("//ul[@class='search-series-list']/li[(contains(@data-id,'0_'))]"));
		WebElement list = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'insight-page-view-tab--link') and contains(text(),'My Series')][1]", 4);
		for (int i = 1; i <= li.size() + li_empty.size(); i++) {
			WebElement series;
			try {
				series = CommonFunctionality.getElementByXpath(login.driver,
						"//ul[@class='search-series-list']/li[" + i + "]//*[@class='series-item--name']", 4);
				new Actions(login.driver).moveToElement(series).pause(1000).build().perform();
			} catch (Exception e) {
				series = CommonFunctionality.getElementByXpath(login.driver,
						"//ul[@class='search-series-list']/li[(contains(@data-id,'0_'))][" + i
								+ "] | //ul[@class='search-series-list']/li[(contains(@data-id,'0_'))]",
						4);
				js.executeScript("arguments[0].scrollIntoView(true);", series);
				new Actions(login.driver).moveToElement(series).pause(1000).build().perform();
			}

			String text;
			try {
				text = CommonFunctionality
						.getElementByXpath(login.driver, "//*[contains(text(),'Source:')]//following-sibling::*", 4)
						.getText();
			} catch (Exception e) {
				text = "Empty";
			}
			new Actions(login.driver).moveToElement(list).pause(500).build().perform();
			if (!(text.contains(a) || text.contains(b) || text.contains(c) || text.isEmpty())) {
				fail("Verification Failed");
			}
		}
		login.Log4j.info("1st Comparables tab source has been verified");
	}

	@And("^Also Expand \"([^\"]*)\"$")
	public void also_Expand(String arg1) throws Throwable {
		WebElement table = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'" + arg1 + "')]/preceding::div[1]", 4);
		WebElement table1 = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'Afghanistan: Production')]//following::div[11]", 4);
		if (login.driver.findElements(By.xpath("//*[contains(text(),'" + arg1 + "')]/preceding::div[1]")).size() > 0) {
			js.executeScript("arguments[0].click();", table);
		} else {
			js.executeScript("arguments[0].click();", table1);
		}
	}

	@And("^Then Expand \"([^\"]*)\"$")
	public void then_Expand(String arg1) throws Throwable {
		WebElement table = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'" + arg1 + "')]/preceding::div[1]", 4);
		WebElement table1 = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'Afghanistan: Production')]//following::div[19]", 4);
		if (login.driver.findElements(By.xpath("//*[contains(text(),'" + arg1 + "')]/preceding::div[1]")).size() > 0) {
			js.executeScript("arguments[0].click();", table);
		} else {
			js.executeScript("arguments[0].click();", table1);
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Select all series from the table2$")
	public void select_all_series_from_the_table2() throws Throwable {
		String a = "Empty";
		String b = "International Monetary Fund";
		String c = "World Bank";
		List<WebElement> li = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("Table_exclude_empty_series_next_db")));
		List<WebElement> li2_empty = login.driver
				.findElements(By.xpath("(//ul[@class='search-series-list'])[2]/li[(contains(@data-id,'0_'))]"));
		WebElement list = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'insight-page-view-tab--link') and contains(text(),'My Series')][1]", 4);
		for (int i = 1; i <= li.size() + li2_empty.size(); i++) {
			WebElement series;
			try {
				series = CommonFunctionality.getElementByXpath(login.driver,
						"(//ul[@class='search-series-list'])[2]/li[" + i + "]//*[@class='series-item--name']", 4);
				new Actions(login.driver).moveToElement(series).pause(1000).build().perform();
			} catch (Exception e) {
				series = CommonFunctionality.getElementByXpath(login.driver,
						"(//ul[@class='search-series-list'])[2]/li[(contains(@data-id,'0_'))]", 4);
				js.executeScript("arguments[0].scrollIntoView(true);", series);
				new Actions(login.driver).moveToElement(series).pause(1000).build().perform();
			}
			String text;
			try {
				text = CommonFunctionality
						.getElementByXpath(login.driver, "//*[contains(text(),'Source:')]//following-sibling::*", 4)
						.getText();
			} catch (Exception e) {
				text = "Empty";
			}
			new Actions(login.driver).moveToElement(list).pause(200).build().perform();
			if (!(text.contains(a) || text.contains(b) || text.contains(c) || text.isEmpty())) {
				fail("Verification Failed");
			}
		}
		login.Log4j.info("2nd Comparables tab source has been verified");
	}

	@SuppressWarnings("deprecation")
	@And("^Select all series from the table3$")
	public void select_all_series_from_the_table3() throws Throwable {
		String a = "Empty";
		String b = "International Monetary Fund";
		String c = "World Bank";
		List<WebElement> li = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("Table_exclude_empty_series_third_table")));
		List<WebElement> li3_empty = login.driver
				.findElements(By.xpath("(//ul[@class='search-series-list'])[2]/li[(contains(@data-id,'0_'))]"));
		WebElement list = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'insight-page-view-tab--link') and contains(text(),'My Series')][1]", 4);
		for (int i = 1; i <= li.size() + li3_empty.size(); i++) {
			WebElement series;
			try {
				series = CommonFunctionality.getElementByXpath(login.driver,
						"(//ul[@class='search-series-list'])[3]/li[" + i + "]//*[@class='series-item--name']", 4);
				new Actions(login.driver).moveToElement(series).pause(1000).build().perform();
			} catch (Exception e) {
				series = CommonFunctionality.getElementByXpath(login.driver,
						"(//ul[@class='search-series-list'])[3]/li[(contains(@data-id,'0_'))]", 4);
				js.executeScript("arguments[0].scrollIntoView(true);", series);
				new Actions(login.driver).moveToElement(series).pause(1000).build().perform();
			}
			String text;
			try {
				text = CommonFunctionality
						.getElementByXpath(login.driver, "//*[contains(text(),'Source:')]//following-sibling::*", 4)
						.getText();
			} catch (Exception e) {
				text = "Empty";
			}
			new Actions(login.driver).moveToElement(list).pause(200).build().perform();
			if (!(text.contains(a) || text.contains(b) || text.contains(c) || text.isEmpty())) {
				fail("Verification Failed");
			}
		}
		login.Log4j.info("3rd Comparables tab source has been verified");
	}

	/*
	 * @And("^Click \"([^\"]*)\" type$") public void click_type(String arg1) throws
	 * Throwable {
	 * 
	 * }
	 */

	@SuppressWarnings("deprecation")
	@And("^Set the range as \"([^\"]*)\" to \"([^\"]*)\"$")
	public void set_the_range_as_to(String arg1, String arg2) throws Throwable {
		start_date_chart = arg1;
		end_date_chart = arg2;
		CommonFunctionality.wait(2000);
		WebElement start = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'highcharts-range-input')][1]/*[2]", 4);
		new Actions(login.driver).moveToElement(start).pause(2000).click().sendKeys(Keys.chord(Keys.CONTROL, "a"))
				.build().perform();
		new Actions(login.driver).moveToElement(start).pause(2000).sendKeys(start_date_chart).build().perform();
		List<WebElement> allday = login.driver.findElements(By.xpath("//*[@class='table-condensed']//td"));
		for (WebElement day : allday) {
			String date = day.getText();
			if (date.equalsIgnoreCase("1")) {
				day.click();
				break;
			}
		}
		new Actions(login.driver).sendKeys(Keys.TAB).build().perform();
		WebElement end = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'highcharts-range-input')][2]/*[2]", 4);
		new Actions(login.driver).moveToElement(end).pause(2000).click().sendKeys(Keys.chord(Keys.CONTROL, "a")).build()
				.perform();
		new Actions(login.driver).moveToElement(end).pause(2000).sendKeys(end_date_chart).build().perform();
		List<WebElement> endday = login.driver.findElements(By.xpath("//*[@class='table-condensed']//td"));
		for (WebElement day : endday) {
			String date = day.getText();
			if (date.equalsIgnoreCase("1")) {
				day.click();
				break;
			}
		}
		new Actions(login.driver).sendKeys(Keys.TAB).build().perform();
	}

	@And("^Check Time axis> Time within period$")
	public void check_time_axis_time_within_period() throws Throwable {
		CommonFunctionality.wait(500);
		start_date_inside_chart = CommonFunctionality
				.getElementByXpath(login.driver, "(//*[contains(@class,'highcharts-range-input')])[3]/*[2]", 4)
				.getText();
		CommonFunctionality.wait(500);
		end_date_inside_chart = CommonFunctionality
				.getElementByXpath(login.driver, "(//*[contains(@class,'highcharts-range-input')])[4]/*[2]", 4)
				.getText();
	}

	@And("^Select (\\d+) series from drilldown series list$")
	public void select_series_from_drilldown_series_list(int arg1) throws Throwable {
		List<WebElement> drill_list = login.driver.findElements(By.className("legend-drilldown"));
		WebElement drill_listing = login.driver.findElement(By.className("legend-drilldown"));
		if (arg1 != drill_list.size()) {
			for (WebElement drill : drill_list) {
				drill_text = CommonFunctionality
						.getElementByProperty(login.driver, "series_list_names_in_drill_dropdown", 4).getText();
				drill.click();
				CommonFunctionality.wait(1000);
				break;
			}
		} else {
			drill_listing.click();
			drill_text = CommonFunctionality.getElementByClassName(login.driver, "single-series-preview--title ", 4)
					.getText();
		}
	}

	@And("^Perform download with timeframe \"([^\"]*)\": \"([^\"]*)\" to \"([^\"]*)\"$")
	public void perform_download_with_timeframe_to(String arg1, String arg2, String arg3) throws Throwable {
		start_date = arg2;
		end_date = arg3;
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']", 4).click();
		WebElement start = CommonFunctionality.getElementByXpath(login.driver,
				"//input[contains(@class,'input-date-start')]", 4);
		new Actions(login.driver).moveToElement(start).click().sendKeys(Keys.chord(Keys.CONTROL, "a")).build()
				.perform();
		new Actions(login.driver).moveToElement(start).sendKeys(arg2).build().perform();
		new Actions(login.driver).sendKeys(Keys.TAB).build().perform();
		if (login.driver.findElements(By.xpath("//*[contains(@class,'button__primary') and text()='Ok']")).size() > 0) {
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(@class,'button__primary') and text()='Ok']", 4)
					.click();
		}
		WebElement end = CommonFunctionality.getElementByXpath(login.driver,
				"//input[contains(@class,'input-date-end')]", 4);
		new Actions(login.driver).moveToElement(end).click().sendKeys(Keys.chord(Keys.CONTROL, "a")).build().perform();
		new Actions(login.driver).moveToElement(end).sendKeys(arg3).build().perform();
		new Actions(login.driver).sendKeys(Keys.ENTER).build().perform();
		date_text = CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[contains(@class,'modal-window__active')]//*[contains(@class,'sphere-modal__body')]", 4)
				.getText();
		if (login.driver.findElements(By.xpath("//*[contains(@class,'button__primary') and text()='Ok']")).size() > 0) {
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(@class,'button__primary') and text()='Ok']", 4)
					.click();
		}
	}

	@And("^Click \"([^\"]*)\" > \"([^\"]*)\" > \"([^\"]*)\" > \"([^\"]*)\"$")
	public void click(String arg1, String arg2, String arg3, String arg4) throws Throwable {
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']//preceding::div[@class='toggle'][1]", 4)
				.click();
		CommonFunctionality.wait(100);
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[text()='" + arg2 + "']//preceding::div[@class='toggle'][1]", 4)
				.click();
		CommonFunctionality.wait(100);
		WebElement open = CommonFunctionality.getElementByXpath(login.driver, "//div[@data-node-model-id='TP2958827']",
				4);
		if (open.getAttribute("class").contains("open")) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[@data-node-model-id='SC2966087']//div[1]", 4)
					.click();
		}
		CommonFunctionality.wait(100);
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg4 + "')]", 4).click();
		if (arg2.equals("CEIC Leading Indicator")) {
			footnotes_text = CommonFunctionality
					.getElementByClassName(login.driver, "footnotes--unavailable-message", 4).getText();
		}
	}

	@And("^Check for observations$")
	public void check_for_observations() throws Throwable {
		CommonFunctionality.wait(500);
		observations = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='popover--body']//*[text()='Last observations']//following::div[contains(@class,'spinner-control')]",
				4);
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='popover-content']//*[@class='popover--close']", 2)
				.click();
	}

	@SuppressWarnings("deprecation")
	@And("^Hovor first series from series list$")
	public void hovor_first_series_from_series_list() throws Throwable {
		WebElement hovor_series = CommonFunctionality.getElementByProperty(login.driver, "One_series_from_seriesList",
				4);
		new Actions(login.driver).moveToElement(hovor_series).pause(3000).build().perform();
	}

	@And("^Check if comparables tab is displayed by default$")
	public void check_if_comparables_tab_is_displayed_by_default() throws Throwable {
		CommonFunctionality.wait(500);
		WebElement comparable = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'Comparables')]", 4);
		if (comparable.isDisplayed()) {
			System.out.println("Comparable tab is displayed");
		}
	}

	@And("^Clear the values in search$")
	public void clear_the_values_in_search() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).clear();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		CommonFunctionality.wait(5000);
	}

	@And("^Right click on any series level of data from series$")
	public void right_click_on_any_series_level_of_data_from_series() throws Throwable {
		CommonFunctionality.webDriverwait_keyvalue("Series_new");
		CommonFunctionality.getElementByProperty(login.driver, "Series_new", 4).click();
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_new"))).click();
		WebElement ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
		for (int i = 0; i < li_All.size(); i++) {
			m = i + 1;
			checkbox = login.driver
					.findElement(By.xpath("//li[" + m + "]//div[@class='series-list-item--checkbox-wrapper']"));
			checkbox.click();
			ele = login.driver.findElement(By.xpath("//li[" + m + "]//div[@class='series-item--name']"));
			if (i == 4) {
				break;
			}
		}
	}

	@And("^Go to \"([^\"]*)\" > \"([^\"]*)\" > \"([^\"]*)\" > \"([^\"]*)\" > \"([^\"]*)\"$")
	public void go_to(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
		CommonFunctionality.UnselectMethod();
		CommonFunctionality.CollapseTreeMethod();
		CommonFunctionality.wait(4000);
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]/preceding::div[1]", 4)
				.click();
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg2 + "')]/preceding::div[1]", 4)
				.click();
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg3 + "')]/preceding::div[1]", 4)
				.click();
		CommonFunctionality.wait(1000);
		comparables_text1 = CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[contains(text(),'" + arg3
								+ "')]//following::*[@class='comparable-tree-series-list--empty-message'][1]",
						4)
				.getText();
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg4 + "')]/preceding::div[1]", 4)
				.click();
		CommonFunctionality.wait(1000);
		comparables_text2 = CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[contains(text(),'" + arg4
								+ "')]//following::*[@class='comparable-tree-series-list--empty-message'][1]",
						4)
				.getText();
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg5 + "')]/preceding::div[1]", 4)
				.click();
		CommonFunctionality.wait(1000);
		comparables_text3 = CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[contains(text(),'" + arg5
								+ "')]//following::*[@class='comparable-tree-series-list--empty-message'][1]",
						4)
				.getText();
		CommonFunctionality.wait(1000);
	}

	@And("^Expand \"([^\"]*)\" > \"([^\"]*)\" > \"([^\"]*)\" > \"([^\"]*)\" > \"([^\"]*)\"$")
	public void expand(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
		CommonFunctionality.UnselectMethod();
		CommonFunctionality.CollapseTreeMethod();
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'" + arg1 + "')]//preceding::div[@class='toggle'][1]", 4).click();
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'" + arg2 + "')]//preceding::div[@class='toggle'][1]", 4).click();
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'" + arg3 + "')]/preceding::div[@class='toggle'][1]", 4).click();
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'" + arg4 + "')]/preceding::div[@class='toggle'][1]", 4).click();
		CommonFunctionality.wait(1000);
		if (login.driver.findElements(By.xpath("//*[contains(text(),'" + arg5 + "')]/preceding::div[1]")).size() > 0) {
			login.driver.findElement(By.xpath("//*[contains(text(),'" + arg5 + "')]/preceding::div[1]")).click();
		} else {
			login.driver
					.findElement(By.xpath("//*[contains(text(),'Afghanistan: National Accounts')]//following::div[3]"))
					.click();
		}
		CommonFunctionality.wait(1000);
	}

	@And("^Clicking the database \"([^\"]*)\"$")
	public void clicking_the_database(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]/preceding::div[1]", 4)
				.click();
	}

	@SuppressWarnings("deprecation")
	@And("^Hover on icon$")
	public void hover_on_icon() throws Throwable {
		WebElement ele = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='child-container']/div[2]/div[3]/div[1]/div[3]/div[1]/div[3]/div[1]/div[3]/div[1]/div[2]/a/span/span[1]",
				4);
		new Actions(login.driver).moveToElement(ele).pause(2000).build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Click on table level$")
	public void click_on_table_level() throws Throwable {
		table_text = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'Afghanistan: National Accounts')]//following::*[@class='name-text'][1]", 4)
				.getText();
		WebElement ele = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='child-container']/div[2]/div[3]/div[1]/div[3]/div[1]/div[3]/div[1]/div[3]/div[1]/div[2]/a/span/span[1]",
				4);
		new Actions(login.driver).moveToElement(ele).pause(2000).build().perform();
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='child-container']/div[2]/div[3]/div[1]/div[3]/div[1]/div[3]/div[1]/div[3]/div[1]/div[2]/span[2]/span[1]",
				4).click();
		CommonFunctionality.wait(500);
		comparable_table_title = CommonFunctionality.getElementByClassName(login.driver, "active-comparable--title", 4)
				.getText();
	}

	@SuppressWarnings("deprecation")
	@And("^Click on series level$")
	public void click_on_series_level() throws Throwable {
		series_text = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'Afghanistan: National Accounts')]//following::div[@class='series-item--name'][1]",
				4).getText();
		WebElement ele = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='child-container']/div[2]/div[3]/div[1]/div[3]/div[1]/div[3]/div[1]/div[3]/div[1]/div[3]/div/ul/li[1]/div/a/div[3]/div[1]/div/div/div[2]/div/span[3]",
				4);
		new Actions(login.driver).moveToElement(ele).pause(2000).build().perform();
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='child-container']/div[2]/div[3]/div[1]/div[3]/div[1]/div[3]/div[1]/div[3]/div[1]/div[3]/div/ul/li[1]/div/a/div[3]/div[2]/span[1]",
				4).click();
		CommonFunctionality.wait(500);
		comparable_series_title = CommonFunctionality.getElementByClassName(login.driver, "active-comparable--title", 4)
				.getText();
	}

	@And("^Check if the result displays only for the selected regions$")
	public void check_if_the_result_displays_only_for_the_selected_regions() throws Throwable {
		CommonFunctionality.wait(500);
		List<WebElement> region = login.driver.findElements(By.xpath("//*[contains(@class,'country-information')]"));
		for (WebElement reg : region) {
			String text = reg.getText();
			assertEquals(text, frequency);
		}
	}

	@And("^Click on expand control$")
	public void click_on_expand_control() throws Throwable {
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='toggle'])[1]", 4).click();
	}

	@And("^Click on select all control$")
	public void click_on_select_all_control() throws Throwable {
		CommonFunctionality.wait(500);
		WebElement check = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='comparables--header']//*[@class='input-control'] | //*[@class='comparables--header']//*[@class='input-control ']",
				4);
		new Actions(login.driver).moveToElement(check).click().build().perform();
	}

	@And("^\"([^\"]*)\" should display result of all region$")
	public void should_display_result_of_all_region(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		List<WebElement> sel_reg = login.driver.findElements(By.xpath("//*[contains(@class,'country-information')]"));
		selected_regions = sel_reg.size();
		if (CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 4)
				.isDisplayed()) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 4).click();
			CommonFunctionality.wait(500);
			List<WebElement> all_reg = login.driver
					.findElements(By.xpath("//*[contains(@class,'country-information')]"));
			all_regions = all_reg.size();
		}
	}

	@And("^Expand World Trend Plus$")
	public void expand_World_Trend_Plus() throws Throwable {
		CommonFunctionality.CollapseTreeMethod();
		Thread.sleep(5000);
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
				"//div[@class='database-node tree-node open']//div[@class='child-container']//div[@class='tree-node open']//div[3]//div[1]//div[1] | //*[contains(text(),'National Accounts')]//preceding::div[@class='toggle'][1]"))
				.click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(
				"//div[@class='database-node tree-node open']//div[@class='child-container']//div[@class='tree-node open']//div[3]//div[1]//div[@class='child-container']//div[@class='tree-node'][1]//div[@class='toggle']"))
				.click();
	}

	@And("^Click on \"([^\"]*)\" tab in left panel$")
	public void click_on_tab_in_left_panel(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='series-tab ui-sortable-handle']//*[contains(text(),'" + arg1 + "')]", 4).click();
	}

	@And("^Right click on any series level of data from DB tab$")
	public void right_click_on_any_series_level_of_data_from_db_tab() throws Throwable {
		CommonFunctionality.UnselectMethod();
		expand_World_Trend_Plus();
		WebElement ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
		for (int i = 0; i < li_All.size(); i++) {
			m = i + 1;
			checkbox = login.driver
					.findElement(By.xpath("//li[" + m + "]//div[@class='series-list-item--checkbox-wrapper']"));
			checkbox.click();
			ele = login.driver.findElement(By.xpath("//li[" + m + "]//div[@class='series-item--name']"));
			if (i == 1) {
				break;
			}
		}
	}

	@And("^Click on closing active comparatable icon and \"([^\"]*)\" tab$")
	public void click_on_closing_active_comparatable_icon_and_tab(String arg1) throws Throwable {
		if (login.driver.findElements(By.className("active-comparable--icon")).size() > 0) {
			CommonFunctionality.getElementByClassName(login.driver, "active-comparable--icon", 4).click();
		}
		List<WebElement> databases = login.driver
				.findElements(By.xpath("//*[contains(@class,'series-tab')]//*[contains(text(),'" + arg1 + "')]"));
		for (WebElement data : databases) {
			if (!(data.getAttribute("class").contains("hidden"))) {
				data.click();
				break;
			}
		}
	}

	@And("^Click on cross icon indicator in comparable tab$")
	public void click_on_cross_icon_indicator_in_comparable_tab() throws Throwable {
		CommonFunctionality.getElementByClassName(login.driver, "active-comparable--icon", 4).click();
	}

	@And("^Check for the font color of negative timepoints in table$")
	public void check_for_the_font_color_of_negative_timepoints_in_table() throws Throwable {
		negative_color = login.driver
				.findElements(By.xpath("//*[@class='cells' and contains(@style,'color:#ff3a56')]"));
	}

	@SuppressWarnings("deprecation")
	@And("^Check the legend icon at visual and edit visual for series$")
	public void check_the_legend_icon_at_visual_and_edit_visual_for_series() throws Throwable {
		CommonFunctionality.wait(1000);
		WebElement legand = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='preview-container']//following::*[@class='series-edit--title']", 4);
		js.executeScript("arguments[0].scrollIntoView(true);", legand);
		new Actions(login.driver).moveToElement(legand).pause(500).build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Check the legend icon at visual and edit visual$")
	public void check_the_legend_icon_at_visual_and_edit_visual() throws Throwable {
		CommonFunctionality.wait(500);
		WebElement legand = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='preview-container']//following::*[@class='series-edit--title']", 4);
		js.executeScript("arguments[0].scrollIntoView(true);", legand);
		new Actions(login.driver).moveToElement(legand).pause(500).build().perform();
		WebElement series = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='preview-container']//following::*[@title='Edit series']", 4);
		new Actions(login.driver).moveToElement(series).pause(500).click().build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Check the legend icon at visual and remove visual$")
	public void check_the_legend_icon_at_visual_and_remove_visual() throws Throwable {
		CommonFunctionality.wait(500);
		WebElement legand = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='preview-container']//following::*[@class='series-edit--title']", 4);
		js.executeScript("arguments[0].scrollIntoView(true);", legand);
		new Actions(login.driver).moveToElement(legand).pause(500).build().perform();
		WebElement series = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='preview-container']//following::*[@title='Remove series']", 4);
		new Actions(login.driver).moveToElement(series).pause(500).click().build().perform();
	}

	@And("^Click \"([^\"]*)\" text from cogwheel$")
	public void click_text_from_cogwheel(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='name-li' and text()='" + arg1 + "']", 4)
				.click();
	}

	@And("^Click \"([^\"]*)\" from the drop down$")
	public void click_from_the_drop_down(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Yearly (Sum)")) {
			frequency_text = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='context-menu-item link' and @title='" + arg1 + "']", 4).getAttribute("title");
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='context-menu-item link' and @title='" + arg1 + "']", 4).click();
		} else {
			change_text = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='context-menu-item link' and @title='" + arg1 + "']", 4).getAttribute("title");
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='context-menu-item link' and @title='" + arg1 + "']", 4).click();
		}
	}

	@And("^Select date format as \"([^\"]*)\"$")
	public void select_date_format_as(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByXpath(login.driver, "//input[@class='form--control form--control__xs']", 4)
				.clear();
		CommonFunctionality.getElementByXpath(login.driver, "//input[@class='form--control form--control__xs']", 4)
				.sendKeys(arg1);
		CommonFunctionality.wait(200);
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='popover--wrapper']//*[@class='context-menu-control--icon']", 4).click();
		if (login.driver.findElements(By.xpath("//*[@class='popover--wrapper']//*[@class='popover--close']"))
				.size() > 0) {
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='popover--wrapper']//*[@class='popover--close']", 4)
					.click();
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Hover on the series \"([^\"]*)\" in legend$")
	public void hover_on_the_series_in_legend(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement legand = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("series_legand")));
		new Actions(login.driver).moveToElement(legand).pause(3000).build().perform();
		legand_tooltip = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]//following-sibling::*", 4)
				.getText();
	}

	@SuppressWarnings("deprecation")
	@And("^Double click on attribute in the table$")
	public void double_click_on_attribute_in_the_table() throws Throwable {
		WebElement table = CommonFunctionality.getElementByProperty(login.driver, "First_attribute_in_table", 4);
		new Actions(login.driver).moveToElement(table).click().build().perform();
		new Actions(login.driver).moveToElement(table).pause(2000).click().build().perform();
	}

	// TC_Cvision_15211_01
	@Then("^Accumulate-QTD, YTD;Calculate change- YOY,%YOY,POP,%POP;Currency - USD, RMB, GBP, JPY, RUB, MYR, EUR;Aggregate - Sum, Avg & frequency dropdown$")
	public void accumulate_QTD_YTD_Calculate_change_YOY_YOY_POP_POP_Currency_USD_RMB_GBP_JPY_RUB_MYR_EUR_Aggregate_Sum_Avg_frequency_dropdown()
			throws Throwable {
		List<WebElement> function_category = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("Function_category_title")));
		for (WebElement category : function_category) {
			String category_text = category.getText();
			if (category_text.contains("Accumulate") || category_text.contains("Calculate change")
					|| category_text.contains("Currency") || category_text.contains("Aggregate")) {
				System.out.println(category_text + " category is present");
			} else {
				Assert.fail("Verification Failed");
			}
		}
		List<WebElement> function_items = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("Function_items")));
		for (WebElement functions : function_items) {
			String function_text = functions.getText();
			if (function_text.contains("YTD") || function_text.contains("QTD") || function_text.contains("YoY")
					|| function_text.contains("%YoY") || function_text.contains("PoP") || function_text.contains("%PoP")
					|| function_text.contains("USD") || function_text.contains("RMB") || function_text.contains("GBP")
					|| function_text.contains("JPY") || function_text.contains("RUB") || function_text.contains("MYR")
					|| function_text.contains("EUR") || function_text.contains("SUM")
					|| function_text.contains("Average") || function_text.contains("Yearly")
					|| function_text.contains("Quarterly") || function_text.contains("Monthly")) {
				System.out.println(function_text + " is present");
			} else {
				Assert.fail("Verification Failed");
			}
		}
		login.Log4j.info("All functions are present inside functions pop up");
		CommonFunctionality.DeleteSeries();
	}

	/*
	 * // TC_Cvision_15211_02
	 * 
	 * @SuppressWarnings("deprecation")
	 * 
	 * @Then("^Tooltips should display for each functions methods$") public void
	 * tooltips_should_display_for_each_functions_methods() throws Throwable {
	 * List<WebElement> function_tooltip = login.driver .findElements(By.xpath(
	 * "//*[@class='popular-functions-context--function-item']")); for (int i = 0; i
	 * < function_tooltip.size(); i++) { new
	 * Actions(login.driver).pause(2000).moveToElement((WebElement)
	 * function_tooltip).pause(2000).build() .perform(); String tooltip =
	 * ((WebElement) function_tooltip).getAttribute("title"); if
	 * (!(tooltip.isEmpty()) || (tooltip.isEmpty()) && functions.size() >= 15) {
	 * login.Log4j.info("The tooltip displayed for function is: " + tooltip); } else
	 * { Assert.fail("Verification failed"); } } CommonFunctionality.DeleteSeries();
	 * }
	 */

	// TC_Cvision_15402_01 or TC_Cvision_15402_02
	@Then("^\"([^\"]*)\" date format has to reflect on the \"([^\"]*)\" visual$")
	public void date_format_has_to_reflect_on_the_visual(String arg1, String arg2) throws Throwable {
		String date_series = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='highcharts-axis-labels highcharts-xaxis-labels ']/*[1]", 4).getText();
		if (date_series.matches("([0-9]{4})/([0-9]{2})/([0-9]{2})") && date_type.contains(arg1)) {
			login.Log4j.info(
					date_type + " date format is reflected on the " + arg2 + " visual and is same as editing format");
		} else if (date_series.matches("([0-9]{2})/([0-9]{4})") && date_type.contains(arg1)) {
			login.Log4j.info(
					date_type + " date format is reflected on the " + arg2 + " visual and is same as editing format");
		} else {
			Assert.fail("Verification failed");
		}
		CommonFunctionality.Views_list();
	}

	// TC_Cvision_16283_01 to TC_Cvision_16283_12
	@Then("^Series selected should be removed$")
	public void series_selected_should_be_removed() throws Throwable {
		if (login.driver.findElements(By.className("growl-message-close")).size() > 0) {
			login.driver.findElement(By.className("growl-message-close")).click();
		}
		if (login.driver
				.findElements(By.xpath("//*[text()='Series Harmonization']//following::*[contains(text(),'Apply')]"))
				.size() > 0) {
			login.driver
					.findElement(By.xpath("//*[text()='Series Harmonization']//following::*[contains(text(),'Apply')]"))
					.click();
		}
		CommonFunctionality.wait(1000);
		List<WebElement> unchecks = login.driver
				.findElements(By.xpath("//*[contains(@class,'series-list-item--checkbox')]//ancestor::li[1]"));
		for (WebElement uncheck : unchecks) {
			if (!(uncheck).getAttribute("class").contains("series-list-item__selected")) {
			} else {
				fail("Verification failed");
			}
		}
		login.Log4j.info("Selected series has been removed");
		CommonFunctionality.Views_list();
	}

	// TC_Cvision_15335
	@Then("^Tooltip should display as in search series$")
	public void tooltip_should_display_as_in_search_series() throws Throwable {
		String series = CommonFunctionality.getElementByProperty(login.driver, "One_series_from_seriesList", 8)
				.getText();
		if (series.contains(legand_tooltip)) {
			login.Log4j.info("Same Tooltip is displayed in series and the tooltip is " + legand_tooltip);
			CommonFunctionality.Views_list();
		} else {
			fail("Verification failed");
		}
	}

	@Then("^Verify for annual series - just annual date picker$")
	public void verify_for_annual_series_just_annual_datepicker() throws Throwable {
		if (start_format_datepicker.matches("([0-9]{4})") && end_format_datepicker.matches("([0-9]{4})")
				&& (frequency.contains("Yearly"))) {
			login.Log4j.info("Date format is " + frequency);
			CommonFunctionality.Views_list();
		} else {
			fail("Verification failed");
		}
	}

	@Then("^Verify for semi annual series - month and yr date picker$")
	public void verify_for_semi_annual_series_month_and_yr_datepicker() throws Throwable {
		if (start_format_datepicker.matches("([0-9]{4})-([0-9]{2})")
				&& end_format_datepicker.matches("([0-9]{4})-([0-9]{2})") && (frequency.contains("Semiannually"))) {
			login.Log4j.info("Date format is " + frequency);
			CommonFunctionality.Views_list();
		} else {
			fail("Verification failed");
		}
	}

	@Then("^Verify for quarterly series - month and yr date picker$")
	public void verify_for_quarterly_series_month_and_yr_datepicker() throws Throwable {
		if (start_format_datepicker.matches("([0-9]{4})-([0-9]{2})")
				&& end_format_datepicker.matches("([0-9]{4})-([0-9]{2})") && (frequency.contains("Quarterly"))) {
			login.Log4j.info("Date format is " + frequency);
			CommonFunctionality.Views_list();
		} else {
			fail("Verification failed");
		}
	}

	@Then("^Verify for monthly series - month and yr date picker$")
	public void verify_for_monthly_series_month_and_yr_datepicker() throws Throwable {
		if (start_format_datepicker.matches("([0-9]{4})-([0-9]{2})")
				&& end_format_datepicker.matches("([0-9]{4})-([0-9]{2})") && (frequency.contains("Monthly"))) {
			login.Log4j.info("Date format is " + frequency);
			CommonFunctionality.Views_list();
		} else {
			Assert.fail("Verification failed");
		}
	}

	@Then("^Verify for weekly series - day, month and yr date picker$")
	public void verify_for_weekly_series_day_month_and_yr_datepicker() throws Throwable {
		if (start_format_datepicker.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})")
				&& end_format_datepicker.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})")
				&& (frequency.contains("Weekly"))) {
			login.Log4j.info("Date format is " + frequency);
			CommonFunctionality.Views_list();
		} else {
			Assert.fail("Verification failed");
		}
	}

	@Then("^Verify for daily series - day, month and yr date picker$")
	public void verify_for_daily_series_day_month_and_yr_datepicker() throws Throwable {
		if (start_format_datepicker.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})")
				&& end_format_datepicker.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})") && (frequency.contains("Daily"))) {
			login.Log4j.info("Date format is " + frequency);
			CommonFunctionality.Views_list();
		} else {
			Assert.fail("Verification failed");
		}
	}

	@Then("^Verify that the date picker should display day,month and yr$")
	public void verify_that_the_datepicker_should_display_day_month_and_yr() throws Throwable {
		if (start_format_datepicker.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})")
				&& end_format_datepicker.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})")
				&& (values_list.contains("Daily;Quarterly;Yearly"))) {
			login.Log4j.info("Date picker is displaying the frquency of: " + values_list);
			CommonFunctionality.Views_list();
		} else {
			Assert.fail("Verification failed");
		}
	}

	@Then("^Verify that the date picker should display month and yr$")
	public void verify_that_the_datepicker_should_display_month_and_yr() throws Throwable {
		if (start_format_datepicker.matches("([0-9]{4})-([0-9]{2})")
				&& end_format_datepicker.matches("([0-9]{4})-([0-9]{2})") && (values_list.contains("Monthly;Yearly"))) {
			login.Log4j.info("Date picker is displaying the frquency of: " + values_list);
			CommonFunctionality.Views_list();
		} else {
			Assert.fail("Verification failed");
		}
	}

	@Then("^The indicator is not available for selected countries$")
	public void the_indicator_is_not_available_for_selectedcountries() throws Throwable {
		String comparables_text = "The indicator is not available for selected countries. See all countries";
		if (comparables_text1.contains(comparables_text) && comparables_text2.contains(comparables_text)
				&& comparables_text3.contains(comparables_text)) {
			login.Log4j.info("The text is: " + comparables_text);
		} else {
			Assert.fail("Verification failed");
		}
	}

	@Then("^Tab should display without being hidden$")
	public void tab_should_display_without_being_hidden() throws Throwable {
		List<WebElement> comparables = login.driver
				.findElements(By.xpath("//*[contains(@class,'series-tab')]//*[contains(text(),'Comparables')]"));
		for (WebElement comp : comparables) {
			if (!(comp.getAttribute("class").contains("hidden"))) {
				login.Log4j.info("Comparables tab is displayed without hidden");
				break;
			}
		}
	}

	@Then("^Tooltip as \"([^\"]*)\" should display for table$")
	public void tooltip_as_should_display_for_table(String arg1) throws Throwable {
		String tooltip_display = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(@class,'cross-country-button')]", 4)
				.getAttribute("title");
		if (tooltip_display.equals(arg1)) {
			login.Log4j.info("Cross country tooltip for table is displayed and its verified");
		} else {
			fail("Verification Failed");
		}
	}

	@SuppressWarnings("deprecation")
	@Then("^Tooltip as \"([^\"]*)\" should display for series$")
	public void tooltip_as_should_display_for_series(String arg1) throws Throwable {
		WebElement tooltip = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='child-container']/div[2]/div[3]/div[1]/div[3]/div[1]/div[3]/div[1]/div[3]/div[1]/div[3]/div/ul/li[1]/div/a/div[3]/div[1]/div/div/div[2]/div/span[3]",
				4);
		new Actions(login.driver).moveToElement(tooltip).pause(2000).build().perform();
		String tooltip_display = CommonFunctionality
				.getElementByXpath(login.driver, "(//*[contains(@class,'cross-country-button')])[2]", 4)
				.getAttribute("title");
		if (tooltip_display.equals(arg1)) {
			login.Log4j.info("Cross country tooltip for series is displayed and its verified");
		} else {
			fail("Verification Failed");
		}
	}

	@Then("^Respective indicator of table should open in comparable tab$")
	public void respective_indicator_of_table_should_open_in_comparable_tab() throws Throwable {
		if (table_text.contains(comparable_table_title)) {
			login.Log4j.info("Respective indicator of table is opened in comparable tab and its verified");
		} else {
			fail("Verification Failed");
		}
	}

	@Then("^Respective indicator of series should open in comparable tab$")
	public void respective_indicator_of_series_should_open_in_comparable_tab() throws Throwable {
		if (series_text.contains(comparable_series_title)) {
			login.Log4j.info("Respective indicator of series is opened in comparable tab and its verified");
		} else {
			fail("Verification Failed");
		}
	}

	@Then("^Default tree should be shown$")
	public void default_tree_should_be_shown() throws Throwable {
		WebElement default_tree = CommonFunctionality.getElementByProperty(login.driver, "All_insights", 4);
		if (default_tree.isDisplayed()) {
			login.Log4j.info("Default tree is displayed and its verified");
		} else {
			fail("Verification Failed");
		}
	}

	@Then("^\"([^\"]*)\" should display for region selection$")
	public void should_display_for_region_selection(String arg1) throws Throwable {
		if (CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 4)
				.isDisplayed()) {
			login.Log4j.info(arg1 + " is displayed for selected region");
		} else {
			fail("Verification failed");
		}
	}

	@Then("^Indicators for all countries should display$")
	public void indicators_for_all_countries_should_display() throws Throwable {
		if (selected_regions != all_regions) {
			login.Log4j
					.info("Indicators for all countries is displayed and the count of indicators are: " + all_regions);
		} else {
			fail("Verification failed");
		}
	}

	@Then("^Icon to change to expanded state$")
	public void icon_to_change_to_expanded_state() throws Throwable {
		CommonFunctionality.wait(1000);
		WebElement expand;
		try {
			expand = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[@class='toggle']/preceding::*[contains(@class,'tree-node data-set-node')])[1]", 4);
		} catch (Exception e) {
			expand = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[@class='toggle']/preceding::*[contains(@class,'tree-node data-set-node')])[1]", 4);
		}
		if (expand.getAttribute("class").contains("open")) {
			login.Log4j.info("Table icon is changed to expanded state");
		} else {
			fail("Verification failed");
		}
	}

	@Then("^\"([^\"]*)\" selected icon to display$")
	public void selected_icon_to_display(String arg1) throws Throwable {
		try {
			if (CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[@class='comparables--header']//following::*[@name='select_all_series']", 4)
					.isSelected()) {
				login.Log4j.info("The checkbox is selected and " + arg1 + " selected icon is displayed");
			} else {
				fail("Verification failed");
			}
		} catch (Exception e) {
			WebElement partial = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='comparables--header']//*[contains(@class,'input-control') and @title='']", 4);
			if (partial.getAttribute("class").contains("partially-selected")) {
				login.Log4j.info("The checkbox is partially selected and " + arg1 + " selected icon is displayed");
			} else if (!(partial.isSelected())) {
				login.Log4j.info("The checkbox is unselected and " + arg1 + " selected icon is displayed");
			} else {
				fail("Verification failed");
			}
		}
	}

	@Then("^The filter should be without country code \"([^\"]*)\"$")
	public void the_filter_should_be_without_country_code(String arg1) throws Throwable {
		country_code = arg1;
		if (!(comparable_table_title.contains(country_code)) && table_text.contains(country_code)) {
			login.Log4j.info("The filter text in comparables tab is without country code " + country_code);
		} else {
			fail("Verification Failed");
		}
	}

	@Then("^\"([^\"]*)\" to be present and its \"([^\"]*)\"$")
	public void to_be_present_and_its(String arg1, String arg2) throws Throwable {
		if (CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='preview-container']//following::*[contains(@class,'series-item--icon') and @title='" + arg2
						+ "']",
				4).isDisplayed()) {
			login.Log4j.info(arg1 + " is displayed and its verified");
			if (login.driver
					.findElements(
							By.xpath("//*[contains(@class,'movable-modal__full-screen')]/div[2]/div[1]/div[2]/div"))
					.size() > 0) {
				CommonFunctionality
						.getElementByXpath(login.driver,
								"//*[contains(@class,'movable-modal__full-screen')]/div[2]/div[1]/div[2]/div", 4)
						.click();
			}
			CommonFunctionality.wait(500);
			CommonFunctionality.Views_list();
		} else {
			fail("Verification failed");
		}
	}

	@Then("^\"([^\"]*)\" be selected by default$")
	public void be_selected_by_default(String arg1) throws Throwable {
		if (!(spinner.getAttribute("class").contains("disabled"))) {
			login.Log4j.info(arg1 + " is selected by default and its verified");
			if (login.driver.findElements(By.xpath("//*[@class='popover--wrapper']//*[@class='popover--close']"))
					.size() > 0) {
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='popover--wrapper']//*[@class='popover--close']", 4).click();
			}
			if (login.driver
					.findElements(
							By.xpath("//*[contains(@class,'movable-modal__full-screen')]/div[2]/div[1]/div[2]/div"))
					.size() > 0) {
				CommonFunctionality
						.getElementByXpath(login.driver,
								"//*[contains(@class,'movable-modal__full-screen')]/div[2]/div[1]/div[2]/div", 4)
						.click();
				if (login.driver.findElements(By.xpath("//button[text()='Ok']")).size() > 0) {
					CommonFunctionality.getElementByXpath(login.driver, "//button[text()='Ok']", 4).click();
				}
			}
			CommonFunctionality.wait(500);
			CommonFunctionality.Views_list();
		} else {
			fail("Verification failed");
		}
	}

	@Then("^The Message \"([^\"]*)\" should be displayed$")
	public void the_Message_should_be_displayed(String arg1) throws Throwable {
		if (date_text.contains(arg1)) {
			login.Log4j.info(
					"The download message is: " + arg1 + " for the timerange from " + start_date + " to " + end_date);
			if (login.driver.findElements(By.className("sphere-modal__close")).size() > 0) {
				CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
			}
			CommonFunctionality.DeleteSeries();
		} else {
			fail("Verification failed");
		}
	}

	@Then("^The Message \"([^\"]*)\" be displayed$")
	public void the_Message_be_displayed(String arg1) throws Throwable {
		if (footnotes_text.contains(arg1)) {
			login.Log4j.info("The message is: " + arg1);
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Close"))).size() > 0) {
				CommonFunctionality.getElementByProperty(login.driver, "Close", 4).click();
			}
		} else {
			fail("Verification failed");
		}
	}

	@Then("^\"([^\"]*)\" method should be checked$")
	public void method_should_be_checked(String arg1) throws Throwable {
		try {
			boolean check = login.driver.findElement(By.xpath("//*[contains(text(),'" + arg1
					+ "')]//preceding-sibling::*[@class='input-control--indicator']")) != null;
			if (check == true) {
				login.Log4j.info(arg1 + " method is checked by default");
				try {
					CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
				} catch (Exception e) {
					CommonFunctionality.getElementByProperty(login.driver, "Close", 4).click();
				}
				CommonFunctionality.DeleteSeries();
			} else {
				fail("Verification Failed");
			}
		} catch (Exception e) {
			boolean check = login.driver.findElement(By.xpath("//*[contains(text(),'" + arg1
					+ "')]//following::*[@class='input-control--indicator'][1]")) != null;
			if (check == true) {
				login.Log4j.info(arg1 + " method is checked by default");
				CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
				CommonFunctionality.DeleteSeries();
			} else {
				fail("Verification Failed");
			}
		}
	}

	@Then("^\"([^\"]*)\" button should be enabled for user to cancel the operation at any time$")
	public void button_should_be_enabled_for_user_to_cancel_the_operation_at_any_time(String arg1) throws Throwable {
		if (arg1 == "Cancel") {
			if (button == true) {
				CommonFunctionality.wait(2000);
				CommonFunctionality.getElementByXpath(login.driver, "//button[text()='Cancel']", 8).click();
			}
		}
		if (login.driver.findElements(By.className("movable-modal--body")).size() == 0) {
			login.Log4j.info(arg1 + " button is enabled for users to cancel the operation at any time");
			CommonFunctionality.DeleteSeries();
		} else {
			fail("Verification Failed");
		}
	}

	@SuppressWarnings("deprecation")
	@Then("^\"([^\"]*)\" tooltip should present$")
	public void tooltip_should_present(String arg1) throws Throwable {
		WebElement annotation_tooltip = CommonFunctionality.getElementByProperty(login.driver, "Annotation_tooltip", 4);
		new Actions(login.driver).moveToElement(annotation_tooltip).pause(3000).build().perform();
		String annotation_tooltip1 = CommonFunctionality.getElementByProperty(login.driver, "Annotation_tooltip", 4)
				.getText();
		if (annotation_tooltip.getAttribute("class").contains("annotation-cursor--tooltip__show")) {
			if (annotation_tooltip1.equals(arg1)) {
				login.Log4j.info(arg1 + " is the tooltip visible and its verified");
				if (login.driver.findElements(By.className("movable-modal--close")).size() > 0) {
					CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
				}
				CommonFunctionality.Views_list();
			}
		} else {
			fail("Verification failed");
		}
	}

	@SuppressWarnings("deprecation")
	@Then("^\"([^\"]*)\" options should present$")
	public void options_should_present(String arg1) throws Throwable {
		String a = "Date";
		String b = "Color";
		String c = "Thickness";
		String d = "LineType";
		String e = "Remove";
		WebElement annotation_tooltip = CommonFunctionality.getElementByProperty(login.driver, "Annotation_tooltip", 4);
		new Actions(login.driver).moveToElement(annotation_tooltip).pause(3000).click().build().perform();
		if (CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'date-marker-editor--date')]", 4)
				.isDisplayed()) {
			System.out.println("Date option is present");
		}
		if (CommonFunctionality.getElementByClassName(login.driver, "date-marker-editor--color", 4).isDisplayed()) {
			System.out.println("Color option is present");
		}
		if (CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(@class,'date-marker-editor--thickness')]", 4)
				.isDisplayed()) {
			System.out.println("Thickness option is present");
		}
		if (CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(@class,'date-marker-editor--line-type')]", 4)
				.isDisplayed()) {
			System.out.println("Line Type option is present");
		}
		if (CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'date-marker-editor--remove')]", 4)
				.isDisplayed()) {
			System.out.println("Remove option is present");
		}
		if (arg1.contains(a) && arg1.contains(b) && arg1.contains(c) && arg1.contains(d) && arg1.contains(e)) {
			login.Log4j.info(arg1 + " options are present");
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Unexpected_confirmation_popup")))
					.size() > 0) {
				CommonFunctionality.getElementByProperty(login.driver, "Unexpected_confirmation_popup", 4).click();
			}
			CommonFunctionality.Views_list();
		} else {
			fail("Verification failed");
		}
	}

	@Then("^Both should be available$")
	public void both_should_be_available() throws Throwable {
		CommonFunctionality.wait(2000);
		if (fullscreen.isDisplayed()) {
			fullscreen.click();
		} else {
			fail("Full screen is not visible");
		}
		CommonFunctionality.wait(2000);
		if (halfscreen.isDisplayed()) {
			halfscreen.click();
		} else {
			fail("Minimize button is not visible");
		}
		login.Log4j.info("Minimize and maximize options are present in video controls");
		CommonFunctionality.wait(3000);
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
	}

	@Then("^The new visual should save the changes$")
	public void the_new_visual_should_save_the_changes() throws Throwable {
		chart_checkbox2 = login.driver
				.findElement(By.xpath(
						"//*[text()='" + text1 + "' and @class='input-control--description']/preceding::input[1]"))
				.isSelected();
		chart_checkbox3 = login.driver
				.findElement(By.xpath(
						"//*[text()='" + text2 + "' and @class='input-control--description']/preceding::input[1]"))
				.isSelected();
		if ((chart_checkbox != chart_checkbox2) && (chart_checkbox1 != chart_checkbox3)) {
			login.Log4j.info(text1 + " and " + text2 + " checkbox Changes is affecting in new visual");
			// check_the_and_options("Zoom", "Slider");
			// clicking_option("Save");
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			CommonFunctionality.Views_list();
		} else {
			fail("Verification failed");
		}
	}

	@Then("^The popup name has to be \"([^\"]*)\"$")
	public void the_popup_name_has_to_be(String arg1) throws Throwable {
		String popup_name = CommonFunctionality.getElementByClassName(login.driver, "suggestions-manager--name", 4)
				.getText();
		if (popup_name.equalsIgnoreCase(arg1)) {
			login.Log4j.info("The popup name is: " + arg1);
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			CommonFunctionality.Views_list();
		} else {
			fail("Verification failed");
		}
	}

	@Then("^\"([^\"]*)\" and \"([^\"]*)\" options should \"([^\"]*)\" display$")
	public void and_options_should_display(String arg1, String arg2, String arg3) throws Throwable {
		if (login.driver.findElements(By.className("suggestions-panel--selection-manage")).size() == 0
				&& login.driver.findElements(By.className("suggestions-panel--selection-manage")).size() == 0) {
			login.Log4j.info(arg1 + " and " + arg2 + " options are " + arg3 + " displayed");
			CommonFunctionality.getElementByProperty(login.driver, "Close", 4).click();
			CommonFunctionality.DeleteSeries();
		} else {
			fail("Verification failed");
		}
	}

	@Then("^Preserve \"([^\"]*)\" option should \"([^\"]*)\" display$")
	public void preserve_option_should_display(String arg1, String arg2) throws Throwable {
		if (login.driver
				.findElements(
						By.xpath("//*[text()='" + arg1 + "']/ancestor::label[contains(@class,'input-control__sm')]"))
				.size() == 0) {
			login.Log4j.info("Preserve " + arg1 + " option is " + arg2 + " displayed");
			CommonFunctionality.getElementByProperty(login.driver, "Close", 4).click();
			CommonFunctionality.DeleteSeries();
		} else {
			fail("Verification failed");
		}
	}

	@Then("^Verify for \"([^\"]*)\" and \"([^\"]*)\"$")
	public void verify_for_and(String arg1, String arg2) throws Throwable {
		String obs = CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[contains(text(),'" + arg1 + ":')and contains(@class,'series-tooltip-table--key')]", 8)
				.getText();
		String cla = CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[contains(text(),'" + arg2 + ":')and contains(@class,'series-tooltip-table--key')]", 4)
				.getText();
		String obs1 = obs.substring(0, obs.length() - 1);
		String cla1 = cla.substring(0, cla.length() - 1);
		if (obs1.equals(arg1) && cla1.equals(arg2)) {
			login.Log4j.info("The " + arg1 + " and " + arg2
					+ " is displayed on tooltip for the series and it has been verified");
		} else {
			fail("Verification failed");
		}
	}

	@Then("^\"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" icons should be in hidden state\\.$")
	public void icons_should_be_in_hidden_state(String arg1, String arg2, String arg3, String arg4) throws Throwable {
		WebElement collapse = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='single-series-preview--series-actions']/ancestor::div[contains(@class,'single-series-preview--modal')]",
				4);
		// WebElement movable = CommonFunctionality.getElementByXpath(login.driver,
		// "//*[contains(@class,'single-series-preview--modal')]//*[contains(@class,'movable-modal--window')]",
		// 4);
		if (collapse.getAttribute("class").contains("movable-modal__collapsed")) {
			if (!(CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@title,'" + arg1 + "')]", 4)
					.isDisplayed())
					&& (!(CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@title,'" + arg2 + "')]", 4)
							.isDisplayed())
							&& (!(CommonFunctionality
									.getElementByXpath(login.driver, "//*[contains(@title,'" + arg3 + "')]", 4)
									.isDisplayed())
									&& (!(CommonFunctionality.getElementByXpath(login.driver,
											"(//*[contains(@title,'" + arg4 + "')])[2]", 4).isDisplayed()))))) {
				assertEquals(false, true);
			} else {
				login.Log4j
						.info("Icons: " + arg1 + " , " + arg2 + " , " + arg3 + " , " + arg4 + " are in hidden state");
			}
		} else {
			fail("Verification failed");
		}
	}

	@Then("^Smart tooltip should popup$")
	public void smart_tooltip_should_popup() throws Throwable {
		WebElement tool = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'tooltip')]", 1);
		if (tool.getAttribute("class").contains("tooltip__visible")) {
			if (CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-tooltip-table']", 1)
					.isDisplayed()) {
				login.Log4j.info("Smart tooltip is poped up and it has been verified");
				CommonFunctionality.getElementByProperty(login.driver, "Close", 4).click();
			}
		} else {
			fail("Verification failed");
		}
	}

	@Then("^\"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" actions should be possible$")
	public void actions_should_be_possible(String arg1, String arg2, String arg3, String arg4) throws Throwable {
		WebElement add;
		try {
			add = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[@class='single-series-preview--series-actions']//*[contains(@title,'" + arg1 + "')])[2]", 4);
		} catch (Exception e) {
			add = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='single-series-preview--series-actions']//*[contains(@title,'" + arg1 + "')]", 4);
		}
		if (add.isDisplayed()) {
		}
		try {
			CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='add-to-data-selection--toggle'])[3]", 4)
					.click();
		} catch (Exception e) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='add-to-data-selection--toggle']", 4)
					.click();
		}
		CommonFunctionality.wait(500);
		if (CommonFunctionality.getElementByClassName(login.driver, "items-wrapper", 4).isDisplayed()) {
			login.Log4j.info(arg1 + " functionality is working");
			try {
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='single-series-preview--series-actions']//*[contains(@title,'" + arg1 + "')]", 4)
						.click();
			} catch (Exception e) {
				CommonFunctionality.getElementByXpath(login.driver,
						"(//*[@class='single-series-preview--series-actions']//*[contains(@title,'" + arg1 + "')])[2]",
						4).click();
			}
		} else {
			fail(arg1 + " Verification failed");
		}
		try {
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@title,'" + arg2 + "')]", 4).click();
		} catch (Exception e) {
			CommonFunctionality.getElementByXpath(login.driver, "(//*[contains(@title,'" + arg2 + "')])[2]", 4).click();
		}
		List<WebElement> minimize;
		try {
			minimize = login.driver.findElements(By.xpath("(//*[@title='Minimize'])[2]"));
		} catch (Exception e) {
			minimize = login.driver.findElements(By.xpath("//*[@title='Minimize']"));
		}
		for (WebElement minimized : minimize) {
			minimized.click();
		}
		if (login.driver.findElements(By.xpath("//*[@title='Minimize']")).size() > 0) {
			login.driver.findElement(By.xpath("//*[@title='Minimize']")).click();
		}
		CommonFunctionality.wait(2000);
		String highcharts = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='highcharts-title']//*[@class='text-dots']", 4).getText();
		if (highcharts.contains(drill_text)) {
			login.Log4j.info(arg2 + " functionality is working");
		} else {
			fail(arg2 + " Verification failed");
		}
		List<WebElement> maximize;
		try {
			maximize = login.driver.findElements(By.xpath("(//*[@title='Maximize'])[2]"));
		} catch (Exception e) {
			maximize = login.driver.findElements(By.xpath("//*[@title='Maximize']"));
		}
		for (WebElement maximized : maximize) {
			js.executeScript("arguments[0].click();", maximized);
		}
		/*
		 * if(login.driver.findElements(By.xpath("//*[@title='Maximize']")).size()>0) {
		 * login.driver.findElement(By.xpath("//*[@title='Maximize']")).click(); }
		 */
		try {
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@title,'" + arg3 + "')]", 4).click();
		} catch (Exception e) {
			CommonFunctionality.getElementByXpath(login.driver, "(//*[contains(@title,'" + arg3 + "')])[2]", 4).click();
		}
		CommonFunctionality.wait(500);
		String copied = CommonFunctionality.getElementByClassName(login.driver, "download-modal-title__title", 4)
				.getText();
		if (copied.contains("Copy")) {
			login.Log4j.info(arg3 + " functionality is working");
		} else {
			fail(arg3 + " Verification failed");
		}
		if (login.driver.findElements(By.className("sphere-modal__close")).size() > 0) {
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		}
		try {
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(@class,'download-button__modal') and contains(@title,'" + arg4 + "')]", 4)
					.click();
		} catch (Exception e) {
			CommonFunctionality.getElementByXpath(login.driver,
					"(//*[contains(@class,'download-button__modal') and contains(@title,'" + arg4 + "')])[2]", 4)
					.click();
		}
		CommonFunctionality.wait(500);
		String download = CommonFunctionality.getElementByClassName(login.driver, "download-modal-title__title", 4)
				.getText();
		if (download.contains("Download")) {
			login.Log4j.info(arg4 + " functionality is working");
		} else {
			fail(arg4 + " Verification failed");
		}
		if (login.driver.findElements(By.className("sphere-modal__close")).size() > 0) {
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		}
		List<WebElement> close;
		try {
			close = login.driver.findElements(By.xpath("(//*[@class='movable-modal--close'])[2]"));
		} catch (Exception e) {
			close = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Close")));
		}
		for (WebElement closing : close) {
			closing.click();
		}
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Close"))).size() > 0) {
			CommonFunctionality.getElementByProperty(login.driver, "Close", 4).click();
		}
		CommonFunctionality.Views_list();
		login.Log4j.info(
				arg1 + " , " + arg2 + " , " + arg3 + " and " + arg4 + " actions are possible and it has been verified");
	}

	@SuppressWarnings("deprecation")
	@Then("^Country names should be series names$")
	public void country_names_should_be_series_names() throws Throwable {
		CommonFunctionality.wait(3000);
		String region_legand = CommonFunctionality.getElementByProperty(login.driver, "legand_region", 4).getText();
		String region2_legand = CommonFunctionality.getElementByProperty(login.driver, "legand_region2", 4).getText();
		WebElement region1 = CommonFunctionality.getElementByProperty(login.driver, "legand_region", 4);
		WebElement region2 = CommonFunctionality.getElementByProperty(login.driver, "legand_region2", 4);
		WebElement title = CommonFunctionality.getElementByClassName(login.driver, "highcharts-title", 4);
		new Actions(login.driver).moveToElement(region1).pause(2000).build().perform();
		String region_legand_text = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'Region:')]//following-sibling::*", 4).getText();
		new Actions(login.driver).moveToElement(title).pause(2000).build().perform();
		new Actions(login.driver).moveToElement(region2).pause(2000).build().perform();
		String region_legand2_text = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'Region:')]//following-sibling::*", 4).getText();
		if (region_legand.equals(region_legand_text) && region2_legand.equals(region_legand2_text)) {
			login.Log4j.info("The country names are displaying as series names and it has been verified");
		} else {
			fail("Verification failed");
		}
		CommonFunctionality.Views_list();
	}

	@Then("^Chart title has to be series name$")
	public void chart_title_has_to_be_series_name() throws Throwable {
		CommonFunctionality.wait(3000);
		String title = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='highcharts-title']//*[@class='text-dots']", 4).getText();
		if (title.equals(text_series1) && (title.equals(text_series2))) {
			login.Log4j.info("The chart title is displaying as series names and it has been verified");
		} else {
			fail("Verification failed");
		}
		CommonFunctionality.Views_list();
	}

	@Then("^The series is not displayed$")
	public void the_series_is_not_displayed() throws Throwable {
		CommonFunctionality.wait(4000);
		String count = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='series-series-count--toggle']//span", 8).getText();
		int result = Integer.parseInt(count);
		if (result == 0) {
			login.Log4j.info("The series is displayed for internal users");
		} else {
			fail("Verification Failed");
		}
	}

	@Then("^The series is displayed for internal users$")
	public void the_series_is_displayed_for_internal_users() throws Throwable {
		CommonFunctionality.wait(4000);
		String count = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='series-series-count--toggle']//span", 8).getText();
		int result = Integer.parseInt(count);
		if (result != 0) {
			login.Log4j.info("The series is displayed for internal users");
		} else {
			fail("Verification Failed");
		}
	}

	@Then("^(\\d+) observations are found$")
	public void observations_are_found(int arg1) throws Throwable {
		CommonFunctionality.wait(200);
		String observation = CommonFunctionality
				.getElementByClassName(login.driver, "series-changes-time-line--observations-count", 4).getText();
		char character = observation.charAt(0);
		int count = Character.getNumericValue(character);
		if (count == arg1) {
			login.Log4j.info(arg1 + " observations have been found");
			CommonFunctionality.getElementByProperty(login.driver, "Close", 4).click();
		} else {
			fail("Verification Failed");
		}
	}

	@Then("^Check the order \"([^\"]*)\" , \"([^\"]*)\"$")
	public void check_the_order(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(1000);
		String world = CommonFunctionality
				.getElementByXpath(login.driver, "(//*[contains(@class,'header-menu-products--title')])[2]", 4)
				.getText();
		if (world.equalsIgnoreCase(arg1)) {
			login.Log4j.info(arg1 + " is in place 1");
		} else {
			fail("Verification Failed");
		}
		String global = CommonFunctionality
				.getElementByXpath(login.driver, "(//*[contains(@class,'header-menu-products--title')])[3]", 4)
				.getText();
		if (global.equalsIgnoreCase(arg2)) {
			login.Log4j.info(arg2 + " is in place 2");
		} else {
			fail("Verification Failed");
		}
	}

	@Then("^\"([^\"]*)\" timepoints should be in \"([^\"]*)\" color in SSP$")
	public void timepoints_should_be_in_color_in_SSP(String arg1, String arg2) throws Throwable {
		List<WebElement> color = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Negative_timepoints")));
		int count = color.size();
		System.out.println("Total " + arg1 + " timepoints: " + count);
		for (WebElement red : color) {
			if (red.getAttribute("fill").contains("#ff3a56") || red.getAttribute("fill").contains("#2B60D0")) {
				CommonFunctionality.wait(1000);
			} else {
				fail("Verification Failed");
			}
		}
		login.Log4j.info(arg1 + " timepoints are displaying in " + arg2 + " color");
		CommonFunctionality.getElementByProperty(login.driver, "Close", 4).click();
		CommonFunctionality.DeleteSeries();
	}

	@Then("^Check the order of premium database \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\"$")
	public void check_the_order_of_premium_database(String arg1, String arg2, String arg3, String arg4, String arg5)
			throws Throwable {
		CommonFunctionality.wait(500);
		String premium1 = CommonFunctionality
				.getElementByXpath(login.driver, "(//*[contains(@class,'premium-database--title')])[1]", 4).getText();
		if (premium1.equalsIgnoreCase(arg1)) {
			login.Log4j.info(arg1 + " is in place 3");
		} else {
			fail("Verification Failed");
		}
		String premium2 = CommonFunctionality
				.getElementByXpath(login.driver, "(//*[contains(@class,'premium-database--title')])[2]", 4).getText();
		if (premium2.equalsIgnoreCase(arg2)) {
			login.Log4j.info(arg2 + " is in place 4");
		} else {
			fail("Verification Failed");
		}
		String premium3 = CommonFunctionality
				.getElementByXpath(login.driver, "(//*[contains(@class,'premium-database--title')])[3]", 4).getText();
		if (premium3.equalsIgnoreCase(arg3)) {
			login.Log4j.info(arg3 + " is in place 5");
		} else {
			fail("Verification Failed");
		}
		String premium4 = CommonFunctionality
				.getElementByXpath(login.driver, "(//*[contains(@class,'premium-database--title')])[4]", 4).getText();
		if (premium4.equalsIgnoreCase(arg4)) {
			login.Log4j.info(arg4 + " is in place 6");
		} else {
			fail("Verification Failed");
		}
		String premium5 = CommonFunctionality
				.getElementByXpath(login.driver, "(//*[contains(@class,'premium-database--title')])[5]", 4).getText();
		if (premium5.equalsIgnoreCase(arg5)) {
			login.Log4j.info(arg5 + " is in place 7");
		} else {
			fail("Verification Failed");
		}
		login.Log4j.info(arg1 + " , " + arg2 + " , " + arg3 + " , " + arg4 + " , " + arg5 + " is in given input order");
	}

	@SuppressWarnings("unused")
	@Then("^Negative timepoints should be in red color$")
	public void negative_timepoints_should_be_in_red_color() throws Throwable {
		for (WebElement negative : negative_color) {
			CommonFunctionality.wait(1000);
			String text_color = CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='cells' and contains(@style,'color:#ff3a56')]", 4)
					.getCssValue("color");
			String actual = Color.fromString(text_color).asHex();
			// verify with Actual value with Expected value
			String expected = "#ff3a56";
			assertEquals(actual, expected);
		}
		login.Log4j.info("Negative timepoints are displaying in Red color");
		CommonFunctionality.Views_list();
	}

	@Then("^The time within period should sync with chart \"([^\"]*)\" period\\.$")
	public void the_time_within_period_should_sync_with_chart_period(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		if (start_date_chart.equals(start_date_inside_chart) && (end_date_chart.equals(end_date_inside_chart))) {
			login.Log4j.info("The time within period is syncned with chart " + arg1 + " period");
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			CommonFunctionality.Views_list();
		} else {
			fail("Verification failed");
		}
	}

	@Then("^Time within period should sync with chart \"([^\"]*)\" period$")
	public void time_within_period_should_sync_with_chart_period(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		if (chart_from_date.equals(start_date_inside_chart) && (chart_to_date.equals(end_date_inside_chart))) {
			login.Log4j.info("The time within period is syncned with chart " + arg1 + " period");
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			CommonFunctionality.Views_list();
		} else {
			fail("Verification failed");
		}
	}

	@Then("^Stroke options to be in disabled state$")
	public void stroke_options_to_be_in_disabled_state() throws Throwable {
		if (stroke.getAttribute("class").contains("insight-action-panel--btn__disabled")) {
			login.Log4j.info("Stroke option is in disabled state for " + type_chart);
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Unexpected_confirmation_popup")))
					.size() > 0) {
				CommonFunctionality.getElementByProperty(login.driver, "Unexpected_confirmation_popup", 4).click();
			}
			CommonFunctionality.Views_list();
		} else {
			fail("Verification failed");
		}
	}

	@Then("^Choosen series should shift to \"([^\"]*)\" axis$")
	public void choosen_series_should_shift_to_axis(String arg1) throws Throwable {
		if (axis.getAttribute("class").contains("series-axis--button__selected") && chart_option.contains(arg1)) {
			login.Log4j.info("Choosen series is shifted to " + arg1 + " axis");
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(@class,'movable-modal__active')]//*[@class='movable-modal--close']", 4)
					.click();
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Unexpected_confirmation_popup")))
					.size() > 0) {
				CommonFunctionality.getElementByProperty(login.driver, "Unexpected_confirmation_popup", 4).click();
			}
			CommonFunctionality.Views_list();
		} else {
			fail("Verification failed");
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Then("^The results to be sorted based on country$")
	public void the_results_to_be_sorted_based_on_country() throws Throwable {
		CommonFunctionality.wait(2000);
		// Locating select tag web element
		List<WebElement> country_list = login.driver.findElements(
				By.xpath("//*[@class='series-item--main-info']//*[contains(@class,'series-item--country')]"));
		// Creating a list to store country names
		List list = new ArrayList();
		// Storing country names in a list
		for (WebElement country : country_list) {
			list.add(country.getText());
		}
		// Creating a temporary list to sort country names
		List tempList = new ArrayList(list);
		// Sort list in ascending order
		Collections.sort(tempList);
		boolean ifSortedAscending = list.equals(tempList);
		if (ifSortedAscending) {
			login.Log4j.info("The results are sorted based on country");
		} else {
			fail("Verification failed");
		}
	}

	@SuppressWarnings("deprecation")
	@Then("^\"([^\"]*)\" attributes checkbox$")
	public void attributes_checkbox(String arg1) throws Throwable {
		if (!(expand.getAttribute("class").contains("collapsed"))) {
			List<WebElement> checkboxes = login.driver.findElements(By
					.xpath("//div[contains(@class,'table-properties-control--items')]/div/div[2]/div[1]/label/input"));
			for (WebElement checkbox : checkboxes) {
				boolean checked = checkbox.isSelected();
				if (checked == false) {
					new Actions(login.driver).moveToElement(checkbox).pause(2000).click().build().perform();
					// TC_15341_03
					for (int i = 1; i <= checkboxes.size(); i++) {
						String attribute_text = CommonFunctionality
								.getElementByProperty(login.driver, "Label_text_in_table", 4).getText();
						String text_compare = CommonFunctionality.getElementByXpath(login.driver,
								"//div[contains(@class,'table-properties-control--items')]/div[" + i + "]/div/div[2]",
								4).getText();
						if (attribute_text.contains(text_compare)) {
							login.Log4j.info(arg1 + " Selected");
						} else {
							fail("Verification failed");
						}
					}
				}
			}
			if (login.driver.findElements(By.className("popover--close")).size() > 0) {
				CommonFunctionality.getElementByClassName(login.driver, "popover--close", 4).click();
			}
		}
	}

	@Then("^The title should be \"([^\"]*)\"$")
	public void the_title_should_be(String arg1) throws Throwable {
		String ask_question_title = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(@class,'modal-title sphere-modal__title')]", 4)
				.getText();
		CommonFunctionality.wait(500);
		if (ask_question_title.contains(arg1) && ask_question_title.contains(title_ssp)) {
			login.Log4j.info("The title is " + arg1 + " '" + title_ssp + "'");
			if (login.driver.findElements(By.className("sphere-modal__close")).size() > 0) {
				CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
			}
			CommonFunctionality.getElementByProperty(login.driver, "Close", 4).click();
		} else {
			fail("Verification failed");
		}
	}

	@Then("^Ascending and descending icon should not displayed for \"([^\"]*)\"$")
	public void ascending_and_descending_icon_should_not_displayed_for(String arg1) throws Throwable {
		WebElement icon = CommonFunctionality.getElementByProperty(login.driver, "Right_panel_dropdown_icon", 4);
		if (icon.getAttribute("class").contains("sort-select-title__asc-hidden sort-select-title__desc-hidden")
				&& arg1.equalsIgnoreCase(sort)) {
			login.Log4j.info("Ascending and descending icon is not displayed for " + arg1);
			CommonFunctionality.DeleteSeries();
		} else {
			fail("Verification failed");
		}
	}

	@Then("^Should redirect to \"([^\"]*)\" and from there user should download the builds$")
	public void should_redirect_to_and_from_there_user_should_download_the_builds(String arg1) throws Throwable {
		// click_on_button("Download CDMNext Add-in");
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'installation-download-button')]//*[contains(text(),'Download CDMNext Add-in')]",
				4).click();
		ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs2.get(1));
		String url = login.driver.getCurrentUrl();
		Assert.assertTrue(login.driver.findElement(By.id("loginform")).isDisplayed());
		String user = CommonFunctionality.getElementByClassName(login.driver, "big-txt-3", 4).getText();
		login.driver.close();
		login.driver.switchTo().window(tabs2.get(0));
		if (login.driver.findElements(By.className("sphere-modal__close")).size() > 0) {
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		}
		if (url.contains(arg1) && user.equalsIgnoreCase("Username")) {
			login.Log4j.info("Redirecting to " + arg1 + " and from there user should download the build");
		} else {
			fail("Verification failed");
		}
	}

	@Then("^Should enable only \"([^\"]*)\" coloring when selected zebra checkbox$")
	public void should_enable_only_coloring_when_selected_zebra_checkbox(String arg1) throws Throwable {
		assertEquals(arg1, zebra_text);
		login.Log4j.info(arg1 + " option is only enabled when " + arg1 + " coloring is reselected in zebra checkbox");
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal__body')]//*[text()='Ok']"))
				.size() > 0) {
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(@class,'sphere-modal__body')]//*[text()='Ok']", 4)
					.click();
		}
		CommonFunctionality.Views_list();
	}

	/**
	 * @throws Throwable
	 */
	@Then("^The new template should be created in the beginning of the list$")
	public static void the_new_template_should_be_created_in_the_beginning_of_the_list() throws Throwable {
		/*String new_template = CommonFunctionality
				.getElementByXpath(login.driver, "(//*[contains(@class,'style-templates-item__active')][1]", 10)
				.getAttribute("title");*/
		String new_template = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'style-templates-item__active')][1]"))).getAttribute("title");
		if (new_template.equals(send)) {
			login.Log4j.info("The new template is created in the beginning of the list");
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal__body')]//*[text()='Ok']"))
					.size() > 0) {
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'sphere-modal__body')]//*[text()='Ok']", 4).click();
			}
			CommonFunctionality.Views_list();
		} else {
			fail("Verification Failed");
		}
	}

	@Then("^The popup should be closed$")
	public void the_popup_should_be_closed() throws Throwable {
		if (login.driver.findElements(By.className("add-template-context")).size() == 0) {
			login.Log4j.info("The add template icon popup is not displayed as it is closed");
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal__body')]//*[text()='Ok']"))
					.size() > 0) {
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'sphere-modal__body')]//*[text()='Ok']", 4).click();
			}
			CommonFunctionality.Views_list();
		} else {
			fail("Verification Failed");
		}
	}

	@Then("^The new visual should be created with selected template style$")
	public void the_new_visual_should_be_created_with_selected_template_style() throws Throwable {
		chart_checkbox2 = login.driver.findElement(By.xpath(
				"//*[text()='" + text1 + "' and @class='input-control--description']/preceding::input[1] | //*[text()='"
						+ text1 + "' and @class='table-properties-context-title']/preceding::input[1]"))
				.isSelected();
		chart_checkbox3 = login.driver.findElement(By.xpath(
				"//*[text()='" + text2 + "' and @class='input-control--description']/preceding::input[1] | //*[text()='"
						+ text1 + "' and @class='table-properties-context-title']/preceding::input[1]"))
				.isSelected();
		if ((chart_checkbox != chart_checkbox2) && (chart_checkbox1 != chart_checkbox3)) {
			login.Log4j.info(text1 + " and " + text2
					+ " checkbox Changes is affecting in new visual as the new visual is creating with selected template style");
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			CommonFunctionality.Views_list();
		} else {
			fail("Verification failed");
		}
	}

	@Then("^\"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\" should be displayed$")
	public void and_should_be_displayed(String arg1, String arg2, String arg3) throws Throwable {
		List<WebElement> values = login.driver.findElements(By.xpath("//*[@class='items-wrapper']/li/span"));
		for (WebElement value : values) {
			String text = value.getAttribute("title");
			if (!(text.contains(arg3) || text.contains(arg2) || text.contains(arg1) || text.isEmpty())) {
				fail("Verification Failed");
			}
		}
		login.Log4j.info(arg1 + ", " + arg2 + ", " + arg3 + " options are displayed");
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		CommonFunctionality.Views_list();
	}

	@Then("^\"([^\"]*)\" option should display$")
	public void option_should_display(String arg1) throws Throwable {
		String text = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'movable-modal--window')]//*[@class='find-and-replace--modal-title']//span[1]", 4)
				.getText();
		String text_omit_last = text.substring(0, text.length() - 1);
		if (arg1.equalsIgnoreCase(text_omit_last)) {
			login.Log4j.info(arg1 + " popup is displayed");
			CommonFunctionality.getElementByProperty(login.driver, "Close", 4).click();
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			CommonFunctionality.Views_list();
		} else {
			fail("Verification failed");
		}
	}

	@Then("^The selected \"([^\"]*)\" is applied to the table$")
	public void the_selected_is_applied_to_the_table(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		String title_text = CommonFunctionality.getElementByProperty(login.driver, "series_edit_title", 4).getText();
		String frequency_1 = frequency_text.substring(0, 6);
		if (title_text.contains(frequency_1)) {
			login.Log4j.info("Selected " + arg1 + " value is displayed in preview title");
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']"))
					.size() > 0) {
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']", 4).click();
			}
			CommonFunctionality.Views_list();
		} else {
			fail("Verification failed");
		}
	}

	@Then("^The selected \"([^\"]*)\" is applied to the table visual$")
	public void the_selected_is_applied_to_the_table_visual(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		String title_text = CommonFunctionality.getElementByProperty(login.driver, "series_edit_title", 4).getText();
		String change_1 = change_text.substring(0, 4);
		if (title_text.matches(".*(?i)" + change_1 + ".*")) {
			login.Log4j.info("Selected " + arg1 + " value is displayed in preview title");
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']"))
					.size() > 0) {
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']", 4).click();
			}
			CommonFunctionality.Views_list();
		} else {
			fail("Verification failed");
		}
	}

	@Then("^The series should be removed from the visual$")
	public void the_series_should_be_removed_from_the_visual() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("series_edit_title"))).size() == 0) {
			login.Log4j.info("Selected series is removed from table visual in preview title");
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']"))
					.size() > 0) {
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']", 4).click();
			}
			CommonFunctionality.Views_list();
		} else {
			fail("Verification failed");
		}
	}

	@Then("^Selected template should be visible in the template Menu$")
	public void selected_template_should_be_visible_in_the_template_menu() throws Throwable {
		String style = login.driver.findElement(By
				.xpath("//*[@class='style-templates-menu--items']//*[contains(@class,'style-templates-item__active')]"))
				.getAttribute("title");
		assertEquals(title_text, style);
		login.Log4j.info("Selected template is visible in the template menu");
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']"))
				.size() > 0) {
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']", 4)
					.click();
		}
		CommonFunctionality.Views_list();
	}

	@Then("^\"([^\"]*)\" should not be available for empty visual$")
	public void should_not_be_available_for_empty_visual(String arg1) throws Throwable {
		if (disabled != true) {
			login.Log4j.info(arg1 + " is not available for empty visual");
			CommonFunctionality.Views_list();
		} else {
			fail("Verification failed");
		}
	}

	@SuppressWarnings("deprecation")
	@Then("^\"([^\"]*)\" should be shown on tooltip$")
	public void should_be_shown_on_tooltip(String arg1) throws Throwable {
		List<WebElement> tooltips = login.driver
				.findElements(By.xpath("//*[@class='highcharts-point' and not(@fill='#05999a')]"));
		for (int i = 1; i <= tooltips.size(); i++) {
			WebElement indicator_value = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='highcharts-point' and not(@fill='#05999a')][" + i + "]", 4);
			new Actions(login.driver).moveToElement(indicator_value).pause(2000).build().perform();
			/*
			 * WebElement indicator_value1 =
			 * CommonFunctionality.getElementByProperty(login.driver,
			 * "indicator_value_in_tooltip", 4); new
			 * Actions(login.driver).moveToElement(indicator_value1).pause(2000).build().
			 * perform();
			 */
			String tooltip_text = indicator_value.getText();
			if (tooltip_text.contains(indicators_in_tooltip)) {
				login.Log4j.info(arg1 + " is shown on tooltip");
			} else {
				fail("Verification failed");
			}
		}
		CommonFunctionality.Views_list();
	}

	@Then("^Histogram methodology info should be displayed in tooltip$")
	public void histogram_methodology_info_should_be_displayed_in_tooltip() throws Throwable {
		WebElement tooltip = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@id='hidden-input']//following::*[contains(@class,'help-button--tooltip tooltip__visible')]", 4);
		if (tooltip.isDisplayed()) {
			login.Log4j.info("Histogram methodology info is displayed in tooltip");
			if (login.driver.findElements(By.className("insight-preview--close")).size() > 0) {
				CommonFunctionality.getElementByClassName(login.driver, "insight-preview--close", 4).click();
			}
			CommonFunctionality.Views_list();
		} else {
			fail("Verification failed");
		}
	}

	@Then("^\"([^\"]*)\" tooltip should be displayed$")
	public void tooltip_should_be_displayed(String arg1) throws Throwable {
		assertEquals(arg1, footnotes_contents);
		login.Log4j.info(arg1 + " tooltip is displayed");
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
	}

	@Then("Shadow should be applied to notification panel$")
	public void shadow_should_be_applied_to_notification_panel() throws Throwable {
		if (login.driver.findElements(By.className("growl-message-text")).size() > 0) {

		} else {
			fail("Verification Failed");
		}
	}

	@Then("^Verify the uploaded image comes under iframe$")
	public void verify_the_uploaded_image_comes_under_iframe() throws Throwable {
		login.driver.switchTo().frame("mce_0_ifr");
		WebElement img_title = CommonFunctionality.getElementByXpath(login.driver, "//body[@id='tinymce']//img", 4);
		if (img_title.getAttribute("title").equals("Shravas.png")) {
			login.Log4j.info("The image has been uploaded successfully without any errors");
			login.driver.switchTo().defaultContent();
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='vis-elem-menu--item ' and @title='Delete']", 4)
					.click();
			if (login.driver.findElements(By.xpath("//*[contains(@class,'modal-content')]//*[text()='Ok']"))
					.size() > 0) {
				CommonFunctionality
						.getElementByXpath(login.driver, "//*[contains(@class,'modal-content')]//*[text()='Ok']", 4)
						.click();
			}
			List<WebElement> views = login.driver.findElements(
					By.xpath("//*[contains(@class,'insight-page-view-tab') and contains(text(),'View')]"));
			if (views.size() > 0) {
				for (WebElement view : views) {
					new Actions(login.driver).contextClick(view).build().perform();
					CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Delete view')]", 8)
							.click();
				}
			}
		} else {
			fail("Verification failed");
		}
	}

	@Then("^The message should be \"([^\"]*)\"$")
	public void the_message_should_be(String arg1) throws Throwable {
		String growl_message = CommonFunctionality.getElementByClassName(login.driver, "growl-message-text", 4)
				.getText();
		assertEquals(growl_message, arg1);
		login.Log4j.info("The message is " + arg1);
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
	}

	@Then("^\"([^\"]*)\" label should be displayed under the spinner$")
	public void label_should_be_displayed_under_the_spinner(String arg1) throws Throwable {
		if (login.driver.findElements(By.className("blocker--message")).size() > 0) {
			String block_message = CommonFunctionality.getElementByClassName(login.driver, "blocker--message", 4)
					.getText();
			if (block_message.equalsIgnoreCase(arg1)) {
				login.Log4j.info(arg1 + " label is displayed under the spinner");
			} else {
				fail("Label is not displayed");
			}
			CommonFunctionality.getElementByClassName(login.driver, "insight-preview--close", 4).click();
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		} else {
			fail("Verification Failed");
		}
	}

	@Then("^\"([^\"]*)\" message for non data visual should be displayed$")
	public void message_for_non_data_visual_should_be_displayed(String arg1) throws Throwable {
		if (login.driver.findElements(By.className("growl-message-text")).size() > 0) {
			String growl_message = CommonFunctionality.getElementByClassName(login.driver, "growl-message-text", 4)
					.getText();
			if (growl_message.contains(arg1)) {
				login.Log4j.info(arg1 + " message is displayed");
			} else {
				fail("Label is not displayed");
			}
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='vis-elem-menu--item ' and @title='Delete']", 4)
					.click();
			List<WebElement> views = login.driver.findElements(
					By.xpath("//*[contains(@class,'insight-page-view-tab') and contains(text(),'View')]"));
			if (views.size() > 0) {
				for (WebElement view : views) {
					new Actions(login.driver).contextClick(view).build().perform();
					CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Delete view')]", 8)
							.click();
				}
			}
		} else {
			fail("Verification Failed");
		}
	}

	@Then("^Share \"([^\"]*)\" popup should display every time share insight$")
	public void share_popup_should_display_every_time_share_insight(String arg1) throws Throwable {
		if (CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[contains(@class,'sphere-modal__content')]//*[contains(text(),'" + arg1 + "')]", 4)
				.isDisplayed()) {
			login.Log4j.info(arg1 + " popup is displaying for sharing insight");
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		} else {
			fail("Verification Failed");
		}
	}

	@Then("^The title for \"([^\"]*)\"$")
	public void the_title_for(String arg1) throws Throwable {
		WebElement display = CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg1 + "']", 4);
		if (display.isDisplayed()) {
			login.Log4j.info("The Insight is shared");
		} else {
			fail("Verification Failed");
		}
	}

	@Then("^The description should be \"([^\"]*)\"$")
	public void the_description_should_be(String arg1) throws Throwable {
		String description_text = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(@class,'sphere-modal__body')]", 4).getText();
		if (description_text.contains(arg1)) {
			login.Log4j.info("The description is " + arg1);
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		} else {
			fail("Verification Failed");
		}
	}

	@Then("^The \"([^\"]*)\" button is clickable$")
	public void the_button_is_clickable(String arg1) throws Throwable {
		boolean button = ok_button.isEnabled();
		if (button == true) {
			ok_button.click();
			if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal__content')]")).size() == 0) {
				login.Log4j.info("The " + arg1 + " button is clickable and working as expected");
			} else {
				fail(arg1 + " button is not clickable");
			}
		} else {
			fail("Verification Failed");
		}
	}

	@Then("^The share process should be declined$")
	public void the_share_process_should_be_declined() throws Throwable {
		List<WebElement> list_of_mail = login.driver.findElements(By.xpath("//*[contains(@class,'share-user-email')]"));
		for (WebElement mails : list_of_mail) {
			String mail_id = mails.getText();
			if (!(mail_id.equals(mail))) {
				login.Log4j.info("The Sharing process is declined and its verified successfully");
			} else {
				fail("Verification Failed");
			}
		}
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
	}

	@Then("^The confirmation popup should be displayed only for first time share$")
	public void the_confirmation_popup_should_be_displayed_only_for_first_time_share() throws Throwable {
		if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal__content')]")).size() == 0) {
			login.Log4j.info("The confirmation popup should be displayed only for first time share");
		} else {
			fail("Verification Failed");
		}
	}

	@SuppressWarnings("deprecation")
	@Then("^Tooltip only displayed when hover the mouse on series name$")
	public void tooltip_only_displayed_when_hover_the_mouse_on_series_name() throws Throwable {
		List<WebElement> country_list = login.driver
				.findElements(By.xpath("//*[contains(@class,'country-information')]"));
		for (int i = 1; i <= country_list.size(); i++) {
			WebElement country = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[contains(@class,'country-information')])[" + i + "]", 4);
			new Actions(login.driver).moveToElement(country).pause(3000).build().perform();
			if (!(login.driver
					.findElements(
							By.xpath("//*[@id='hidden-input']//following::*[contains(@class,'tooltip__visible')]"))
					.size() == 0)) {
				fail("Verification Failed");
			}
		}
		login.Log4j.info(
				"Tooltip is not displayed for country names and which is only displayed when hover the mouse on series name");
	}

	@Then("^The non data visuals should not create with series$")
	public void the_non_data_visuals_should_not_create_with_series() throws Throwable {
		WebElement selected = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='input-control--indicator']//*[@class='icon']//following::*[contains(@class,'list-container')]",
				4);
		if (selected.getAttribute("class").contains("without-data")) {
			login.Log4j.info("The non data visuals should not create with series");
			List<WebElement> views = login.driver.findElements(
					By.xpath("//*[contains(@class,'insight-page-view-tab') and contains(text(),'View')]"));
			if (views.size() > 0) {
				for (WebElement view : views) {
					new Actions(login.driver).contextClick(view).build().perform();
					CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Delete view')]", 8)
							.click();
				}
			}
		} else {
			fail("Verification Failed");
		}
	}

	@Then("^The title of the pop up should be \"([^\"]*)\"$")
	public void the_title_of_the_pop_up_should_be(String arg1) throws Throwable {
		assertEquals(modal_text, arg1);
		login.Log4j.info("The Title of the popup is: " + arg1);
		CommonFunctionality.getElementByProperty(login.driver, "Close", 4).click();
		CommonFunctionality.Views_list();
	}

	@Then("^The message in the pop up should be \"([^\"]*)\"$")
	public void the_message_in_the_pop_up_should_be(String arg1) throws Throwable {
		assertEquals(modal_text, arg1);
		login.Log4j.info("The message in the popup is: " + arg1);
		CommonFunctionality.getElementByProperty(login.driver, "Close", 4).click();
		CommonFunctionality.Views_list();
	}

	@Then("^The notification panel is opened and \"([^\"]*)\" tab is default$")
	public void the_notification_panel_is_opened_and_tab_is_default(String arg1) throws Throwable {
		WebElement active = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'tabs__tab-item')]", 4);
		if (active.getAttribute("class").contains("active") && active.getText().equals(arg1)) {
			login.Log4j.info("The notification panel is opened and " + arg1 + " tab is default");
		} else {
			fail("Verification failed");
		}
	}

	@SuppressWarnings("deprecation")
	@Then("^The style template should be saved$")
	public void the_style_template_should_be_saved() throws Throwable {
		List<WebElement> all = login.driver.findElements(By.xpath(
				"//*[@class='style-templates-item--wrapper']//preceding-sibling::*[contains(@class,'style-templates-item')]"));
		for (WebElement one_element : all) {
			if (one_element.getAttribute("title").contains(send)) {
				// WebElement active = CommonFunctionality.getElementByXpath(login.driver,
				// "//*[contains(@title,'Attributes')]", 4);
				new Actions(login.driver).moveToElement(one_element).pause(2000).build().perform();
				// new
				// Actions(login.driver).moveToElement(active).pause(2000).click().build().perform();
				login.Log4j.info("The newly created style template is saved and it has been verified successfully");
				break;
			} else {
				fail("Verification failed");
			}
		}
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal__content')]")).size() > 0) {
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']", 4)
					.click();
		}
		CommonFunctionality.Views_list();
	}

	@Then("^Prefix,First name and Last name should be displayed$")
	public void prefix_First_name_and_Last_name_should_be_displayed() throws Throwable {
		String prefix1 = CommonFunctionality.getElementByClassName(login.driver, "profile-menu--prefix", 4).getText();
		String name_prefix = prefix1.substring(0, prefix1.length() - 1);
		String name_preference = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='profile-menu--prefix']//following-sibling::span", 4)
				.getText();
		filter.add(name_preference);
		var = name_preference;
		sourcearr = var.split(" ");
		if (!(prefix.equalsIgnoreCase(name_prefix))) {
			fail("Verification Failed");
		}
		for (String list : sourcearr) {
			if (!(list.contains(first_name) || list.contains(last_name))) {
				fail("Nmae not displayed");
			}
		}
		login.Log4j.info("User prefix, First name and Last name is displayed in user preferences");
	}

	@Then("^\"([^\"]*)\" popup should be displayed$")
	public void popup_should_be_displayed(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase(preference_popup)) {
			login.Log4j
					.info(arg1 + " title in the popup is displayed inside preferences option and it has been verified");
		} else {
			fail("Verification Failed");
		}
	}

	@Then("^The updated prefix should show under preference$")
	public void the_updated_prefix_should_show_under_preference() throws Throwable {
		String prefix1 = CommonFunctionality.getElementByClassName(login.driver, "profile-menu--prefix", 4).getText();
		String name_prefix = prefix1.substring(0, prefix1.length() - 1);
		if (prefix_edit.equalsIgnoreCase(name_prefix)) {
			login.Log4j.info("The updated prefix is shown under preference option and its verified");
		} else {
			fail("Verification Failed");
		}
	}
}