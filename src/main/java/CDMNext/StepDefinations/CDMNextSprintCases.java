package CDMNext.StepDefinations;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class CDMNextSprintCases {

	WebDriverWait wait = new WebDriverWait(login.driver, 100);
	JavascriptExecutor js = (JavascriptExecutor) login.driver;
	SoftAssert sa = new SoftAssert();
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
	public static String first_name_edit;
	public static String last_name_edit;
	public static String first_name;
	public static String last_name;
	public static String existing_token;
	public static String few_attributes;
	public static String separator_value;
	public static String space;
	public WebElement Comparables_text1;
	public WebElement Comparables_text2;
	public WebElement Comparables_text3;
	public WebElement title_checkbox_webElement;
	public WebElement email;
	public WebElement preference_checkbox;
	public static String attributes;
	public static String preference_popup;
	public static String separated_first_name;
	public static String separated_last_name;
	public static String edited_first_name = "CEIC";
	public static String edited_last_name = "Shravas";
	public static String error_message;
	public static String language;
	public static String dateformat;
	public static String updated_language;
	public static String updated_date;
	public static String valid_date = "MM/DD/YYYY";
	public static String invalid_date = "mm/dd/yyyy";
	public static String valid_date_format;
	public static String decimal_seperator;
	public static String grouping_seperator;
	public static String entire_data;
	public static String full_data;
	public static String full_data1;
	public static String final_api;
	public static String New_Insight_Name;
	public static String first_search_keyword;
	public static String act;
	public static String exp;
	public static String second_search_keyword;
	public static String none;
	public int decimal_places;
	public int decimal_place_separator;
	public int grouping_place_seperator;
	public int attributes_table_count_before;
	public static List<WebElement> functions;
	public static List<String> filter = new ArrayList<>();
	public static WebElement spinner;
	public WebElement expand;
	public int selected_regions;
	public int all_regions;
	public int decimalPlaces;
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
	public int download_title;
	public static String[] sourcearr;
	public boolean button;
	public boolean checkbox_prefer;
	public boolean chart_checkbox;
	public boolean chart_checkbox1;
	public boolean chart_checkbox2;
	public boolean chart_checkbox3;
	public boolean chart_checkbox4;
	public boolean chart_checkbox5;
	public boolean preference_checkbox1;
	public boolean replacement_not_show;
	public boolean replacement_not_show_updated;
	public static String values_list;
	public int m;
	public int suggestion;
	public static String text;
	public static String var;
	public String[] frequencyarray = null;
	public String result;

	@And("^Resetting the filters$")
	public void resetting_the_filters() throws Throwable {
		if (login.driver.findElements(By.xpath("//*[contains(@style,'display: none;') and contains(text(),'Reset')]"))
				.size() > 0) {
			System.out.println("===No filter applied====");
			CommonFunctionality.wait(1000);
		} else {
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(text(),'Reset') and not(@visibility='hidden')]", 4)
					.click();
			CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).clear();
			CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
			CommonFunctionality.wait(500);
		}
	}

	@And("^Refresh page$")
	public void refreshe_page() throws Throwable {
		CommonFunctionality.wait(500);
		login.driver.navigate().refresh();
	}

	@And("^Check for keeping_insight popup$")
	public void check_for_keeping_insight_popup() throws Throwable {
		CommonFunctionality.closing_if_any_opened_modal_popup(login.driver, "movable-modal--close",
				"//*[contains(@class,'modal-content')]//*[text()='Some changes have not been saved.']",
				"//*[@class='sphere-modal-controls']//*[text()='Ok']");
		SSPWindow ssp = new SSPWindow();
		ssp.close_the_replacement_popup_if_appeared();
	}

	@SuppressWarnings("deprecation")
	@And("^Reset the values in \"([^\"]*)\" tab$")
	public void reset_the_values_in_tab(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Databases")) {
			CommonFunctionality.wait(3000);
			WebElement database = CommonFunctionality.getElementByXpath(login.driver,
					"//span[contains(text(),'" + arg1 + "')]", 8);
			new Actions(login.driver).moveToElement(database).pause(2000).click().build().perform();
			CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).clear();
			CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		} else {
			CommonFunctionality.wait(5000);
			WebElement other = CommonFunctionality.getElementByProperty(login.driver, "Series_new", 8);
			new Actions(login.driver).moveToElement(other).pause(2000).click().build().perform();
			CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).clear();
			CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Add to myseries$")
	public void add_to_myseries() throws Throwable {
		CommonFunctionality.wait(6000);
		String id = "359237987";
		CommonFunctionality.webDriverwait_keyvalue("Series_tab");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_tab"))).click();
		CommonFunctionality.webDriverwait_keyvalue("Series_new");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_new"))).click();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).clear();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(id);
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		CommonFunctionality.webDriverwait_keyvalue("Series_checkbox");
		WebElement series_cb = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_checkbox")));
		new Actions(login.driver).moveToElement(series_cb).pause(3000).click().build().perform();
		WebElement series_add = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_to_myseries")));
		new Actions(login.driver).moveToElement(series_add).pause(3000).click().build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Add Replacement series to myseries$")
	public void add_Replacement_series_to_myseries() throws Throwable {
		CommonFunctionality.wait(2000);
		String id = "253736802";
		CommonFunctionality.webDriverwait_keyvalue("Series_tab");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_tab"))).click();
		CommonFunctionality.webDriverwait_keyvalue("Series_new");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_new"))).click();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).clear();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(id);
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
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
		CommonFunctionality.wait(3000);
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'" + arg1 + "')]", 8).click();
		CommonFunctionality.wait(1000);
	}

	@SuppressWarnings("deprecation")
	@And("^Capture the \"([^\"]*)\" tooltip indicator value$")
	public void capture_the_tooltip_indicator_value(String arg1) throws Throwable {
		WebElement first_series = CommonFunctionality.getElementByProperty(login.driver, "One_series_from_seriesList",
				8);
		new Actions(login.driver).moveToElement(first_series).pause(4000).build().perform();
		indicators_in_tooltip = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]/following-sibling::*", 8)
				.getText();
	}

	@And("^Click to create an empty visual$")
	public void click_to_create_an_empty_visual() throws Throwable {
		CommonFunctionality.wait(3000);
		CommonFunctionality.getElementByProperty(login.driver, "Create_new_view", 8).click();
		CommonFunctionality.wait(3000);
	}

	@And("^Navigating back and refresh button$")
	public void navigating_back_and_refresh_button() throws Throwable {
		if (login.driver.findElements(By.xpath("//*[contains(@class,'insight-breadcrumb--title-block')]"))
				.size() == 0) {
			login.driver.navigate().back();
			CommonFunctionality.wait(2000);
			login.driver.navigate().refresh();
			CommonFunctionality.wait(2000);
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Click on empty \"([^\"]*)\" visual$")
	public void click_on_empty_visual(String arg1) throws Throwable {
		WebElement visual = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='view-components-over--visual-title' and contains(text(),'" + arg1 + "')]//..", 8);
		new Actions(login.driver).moveToElement(visual).pause(4000).click().build().perform();
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
		CommonFunctionality.ResetMethod();
		CommonFunctionality.wait(5000);
		//CommonFunctionality.webDriverwait_keyvalue("Series_tab");
		//WebElement series = CommonFunctionality.getElementByProperty(login.driver, "Series_tab", 8);
		//new Actions(login.driver).moveToElement(series).pause(5000).click().build().perform();
		/*CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).clear();
		// CommonFunctionality.getElementByClassName(login.driver, "search-input-text",
		// 4).sendKeys(Keys.ENTER);
		CommonFunctionality.wait(4000);
		CommonFunctionality.webDriverwait_keyvalue("Series_new");
		CommonFunctionality.getElementByProperty(login.driver, "Series_new", 8).click();
		//CommonFunctionality.webDriverwait_keyvalue("Series_checkbox");
		WebElement series_cb = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_checkbox")));
		WebElement selected = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='search-series-list']/*[1]", 8);
		if (!(selected.getAttribute("class").contains("series-list-item__selected"))) {
			new Actions(login.driver).moveToElement(series_cb).pause(4000).click().build().perform();
		}*/
		WebDriverWait wait = new WebDriverWait(login.driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[@value='LIST']")))).click();
		for (int i = 1; i <= 4; i++) {
			CommonFunctionality.getElementByXpath(login.driver,
					"(//span[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]", 8).click();

		}
	}

	@And("^Select my series tab$")
	public void select_my_series_tab() throws Throwable {
		CommonFunctionality.webDriverwait_keyvalue("Series_tab");
		CommonFunctionality.getElementByProperty(login.driver, "Series_tab", 8).click();
	}
	
	
	@And("^Search for  series with SID \"([^\"]*)\"$")
	public void search_for_series_with_SID(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		//CommonFunctionality.getElementByProperty(login.driver, "Series_tab", 8).click();
		login.driver.findElement(By.xpath("//span[@value='LIST']")).click();
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByProperty(login.driver, "Series_new", 8).click();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).clear();
		login.driver.navigate().refresh();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(arg1);
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		try {
			WebElement apply=	login.driver.findElement(By.xpath("//button[normalize-space(text())='Start new'] "));
			apply.click();
		}
		catch(Exception e) {
			System.out.println("pop up not appeared");
		}
		
		List<WebElement> list1 = login.driver.findElements(By.xpath("//*[@class='series-item--main-info']"));
		
		for (int i = 1; i <= list1.size(); i++) {
			/*WebElement series = login.driver
					.findElement(By.xpath("//div[@class='search-series-list']/*[" + i + "]/div/a/div[2]"));*/
			
			WebElement series = login.driver
					.findElement(By.xpath("//div[@class='series-list-item--information']/*[" + i + "]"));
			
			System.out.println("=seriesqqw"+series);
			
			new Actions(login.driver).moveToElement(series).pause(3000).build().perform();
			login.driver.findElement(By.xpath("//*[@class='add-to-data-selection--icon']")).click();
		}
	}
	@And("^click on More dropdown and select continuos checkbox\\.$")
	public void click_on_More_dropdown_and_select_continuos_checkbox() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'More')]")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//span[@title='With historical extension of continuous series']//span[@class='text-dots']")).click();
	    
	}

	
	
	
	
	
	
	
	
	
	
	

	@SuppressWarnings("deprecation")
	@And("^Search for the series with SID \"([^\"]*)\"$")
	public void search_for_the_series_with_SID(String arg1) throws Throwable {
		//CommonFunctionality.webDriverwait_keyvalue("Series_tab");
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//span[text()='Series']")).click();
		//CommonFunctionality.getElementByProperty(login.driver, "Series_tab", 8).click();
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByProperty(login.driver, "Series_new", 8).click();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).clear();
		login.driver.navigate().refresh();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(arg1);
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		CommonFunctionality.wait(4000);
		if (arg1.equals("9380901;9385301") || arg1.equals("230795002;230795102")) {
			List<WebElement> list = login.driver.findElements(By.xpath("//div[@class='series-item--main-info']"));
			for (int i = 1; i <= list.size(); i++) {
				CommonFunctionality.wait(2000);
				WebElement series = login.driver
						.findElement(By.xpath("//div[@class='series-item--main-info']/*[" + i + "]"));
				new Actions(login.driver).moveToElement(series).pause(3000).build().perform();
			}
		}
		if (arg1.equals("210698402;206954202")) {
			List<WebElement> list = login.driver.findElements(By.xpath("//div[@class='search-series-list']/*"));
			for (int i = 1; i <= list.size(); i++) {
				WebElement series = login.driver
						.findElement(By.xpath("//div[@class='search-series-list']/*[" + i + "]/div/a/div[2]/span/*"));
				new Actions(login.driver).moveToElement(series).pause(3000).click().build().perform();
			}
		}
		if (arg1.equals("210698402;35709701")) {
			List<WebElement> list = login.driver.findElements(By.xpath("//div[@class='search-series-list']/*"));
			for (int i = 1; i <= list.size(); i++) {
				WebElement series = login.driver
						.findElement(By.xpath("//div[@class='search-series-list']/*[" + i + "]/div/a/div[2]/span/*"));
				new Actions(login.driver).moveToElement(series).pause(3000).click().build().perform();
			}
		}
		if (arg1.equals("210698402;387139827")) {
			List<WebElement> list = login.driver.findElements(By.xpath("//div[@class='search-series-list']/*"));
			for (int i = 1; i <= list.size(); i++) {
				WebElement series = login.driver
						.findElement(By.xpath("//div[@class='search-series-list']/*[" + i + "]/div/a/div[2]/span/*"));
				new Actions(login.driver).moveToElement(series).pause(3000).click().build().perform();
			}
		}
		if (arg1.equals("384681617;385320997")) {
			List<WebElement> list = login.driver.findElements(By.xpath("//div[@class='search-series-list']/*"));
			for (int i = 1; i <= list.size(); i++) {
				WebElement series = login.driver
						.findElement(By.xpath("//div[@class='search-series-list']/*[" + i + "]/div/a/div[2]"));
				new Actions(login.driver).moveToElement(series).pause(3000).build().perform();
			}
		}
		if (arg1.equals("447238447;447238437")) {
			List<WebElement> list = login.driver.findElements(By.xpath("//div[@class='search-series-list']/*"));
			for (int i = 1; i <= list.size(); i++) {
				WebElement series = login.driver
						.findElement(By.xpath("//div[@class='search-series-list']/*[" + i + "]/div/a/div[2]"));
				new Actions(login.driver).moveToElement(series).pause(3000).click().build().perform();
			}
			
		}
		
		if (arg1.equals("304366404")) {
			login.driver.navigate().refresh();
			/*WebElement Search=login.driver.findElement(By.xpath("//input[@placeholder='Search']"));
			Search.click();
			Search.sendKeys("304366404",Keys.ENTER);*/
			
			
			List<WebElement> list = login.driver.findElements(By.xpath("//*[@class='series-item--main-info']"));
			for (int i = 1; i <= list.size(); i++) {
				WebElement series = login.driver
						.findElement(By.xpath("//div[@class='series-item--name']"));
				new Actions(login.driver).moveToElement(series).pause(3000).build().perform();
			}
			
		}
			
		
		
		
		
		
		
		
		
		if (arg1.equalsIgnoreCase("63929901;63928901")) {
			List<WebElement> list1 = login.driver.findElements(By.xpath("//div[@class='search-series-list']/*"));
			for (int i = 1; i <= list1.size(); i++) {
				WebElement series = login.driver
						.findElement(By.xpath("//div[@class='search-series-list']/*[" + i + "]/div/a/div[2]"));
				new Actions(login.driver).moveToElement(series).pause(3000).build().perform();
			}
		}
		if (arg1.equalsIgnoreCase("51287302;383440717")) {
			List<WebElement> list1 = login.driver.findElements(By.xpath("//div[@class='search-series-list']/*"));
			for (int i = 1; i <= list1.size(); i++) {
				WebElement series = login.driver
						.findElement(By.xpath("//div[@class='search-series-list']/*[" + i + "]/div/a/div[2]"));
				new Actions(login.driver).moveToElement(series).pause(3000).build().perform();
			}
		}
		if (arg1.equalsIgnoreCase("68941402;68945002")) {
			List<WebElement> list1 = login.driver.findElements(By.xpath("//div[@class='search-series-list']/*"));
			for (int i = 1; i <= list1.size(); i++) {
				WebElement series = login.driver
						.findElement(By.xpath("//div[@class='search-series-list']/*[" + i + "]/div/a/div[2]/span"));
				new Actions(login.driver).moveToElement(series).pause(3000).build().perform();
			}
		}
		if (arg1.equalsIgnoreCase("305183101;305188001")) {
			List<WebElement> list3 = login.driver.findElements(By.xpath("//div[@class='search-series-list']/*"));
			for (int i = 1; i <= list3.size(); i++) {
				WebElement series = login.driver
						.findElement(By.xpath("//div[@class='search-series-list']/*[" + i + "]/div/a/div[2]"));
				new Actions(login.driver).moveToElement(series).pause(3000).build().perform();
			}
		}
		if (arg1.equalsIgnoreCase("1355101; 353749717")) {
			List<WebElement> list5 = login.driver.findElements(By.xpath("//div[@class='search-series-list']/*"));
			for (int i = 1; i <= list5.size(); i++) {
				WebElement series = login.driver
						.findElement(By.xpath("//div[@class='search-series-list']/*[" + i + "]/div/a/div[2]/span/*"));
				new Actions(login.driver).moveToElement(series).pause(3000).click().build().perform();
			}
		}
		if (arg1.equalsIgnoreCase("9380901;9380801") || arg1.equalsIgnoreCase("1692001;7873401")) {
			List<WebElement> list2 = login.driver.findElements(By.xpath("//div[@class='search-series-list']/*"));
			for (int i = 1; i <= list2.size(); i++) {
				WebElement series = login.driver
						.findElement(By.xpath("//div[@class='search-series-list']/*[" + i + "]/div/a/div[2]"));
				new Actions(login.driver).moveToElement(series).pause(1000).build().perform();
			}
		}
		if (arg1.equalsIgnoreCase("398155157;398155397")) {
			List<WebElement> list3 = login.driver.findElements(By.xpath("//div[@class='search-series-list']/*"));
			for (int i = 1; i <= list3.size(); i++) {
				WebElement series = login.driver
						.findElement(By.xpath("//div[@class='search-series-list']/*[" + i + "]/div/a/div[2]"));
				new Actions(login.driver).moveToElement(series).pause(3000).build().perform();
			}
		}
		if (arg1.equalsIgnoreCase("299442804;299501402")) {
			List<WebElement> list_new = login.driver.findElements(By.xpath("//div[@class='search-series-list']/*"));
			for (int i = 1; i <= list_new.size(); i++) {
				WebElement series = login.driver
						.findElement(By.xpath("//div[@class='search-series-list']/*[" + i + "]/div/a/div[2]"));
				new Actions(login.driver).moveToElement(series).pause(3000).build().perform();
			}
		}
		if (arg1.equalsIgnoreCase("1355101;353749717")) {
			List<WebElement> list4 = login.driver.findElements(By.xpath("//div[@class='search-series-list']/*"));
			for (int i = 1; i <= list4.size(); i++) {
				WebElement series = login.driver
						.findElement(By.xpath("//div[@class='search-series-list']/*[" + i + "]/div/a/div[2]"));
				new Actions(login.driver).moveToElement(series).pause(3000).build().perform();
			}
		}
		if (arg1.equalsIgnoreCase("181804102;116315408")) {
			List<WebElement> list5 = login.driver.findElements(By.xpath("//div[@class='search-series-list']/*"));
			for (int i = 1; i <= list5.size(); i++) {
				WebElement series = login.driver
						.findElement(By.xpath("//div[@class='search-series-list']/*[" + i + "]/div/a/div[2]"));
				new Actions(login.driver).moveToElement(series).pause(3000).build().perform();
			}
		}
		if (arg1.equalsIgnoreCase("2121901;2121101")) {
			List<WebElement> list2 = login.driver.findElements(By.xpath("//div[@class='search-series-list']/*"));
			for (int i = 1; i <= list2.size(); i++) {
				WebElement series = login.driver
						.findElement(By.xpath("//div[@class='search-series-list']/*[" + i + "]/div/a/div[2]"));
				new Actions(login.driver).moveToElement(series).pause(3000).build().perform();
			}
		}
		if (arg1.equalsIgnoreCase("385345667") || arg1.equals("389705827") || arg1.equalsIgnoreCase("32189801")
				|| arg1.equalsIgnoreCase("253736802")) {
			//List<WebElement> list1 = login.driver.findElements(By.xpath("//div[@class='search-series-list']/*"));
			List<WebElement> list1 = login.driver.findElements(By.xpath("//*[@class='series-item--main-info']"));
			
			for (int i = 1; i <= list1.size(); i++) {
				/*WebElement series = login.driver
						.findElement(By.xpath("//div[@class='search-series-list']/*[" + i + "]/div/a/div[2]"));*/
				
				WebElement series = login.driver
						.findElement(By.xpath("//div[@class='series-list-item--information']/*[" + i + "]"));
				
				System.out.println("=seriesqqw"+series);
				
				new Actions(login.driver).moveToElement(series).pause(3000).build().perform();
				
			}
		}
		
		/*if (!arg1.equals("315926001")) {
			WebElement series_cb = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_checkbox")));
			new Actions(login.driver).moveToElement(series_cb).pause(4000).click().build().perform();
		}*/
		 

	}

	@And("^click on add icon$")
	public void click_on_add_icon() throws Throwable {
		login.driver.findElement(By.xpath("//*[@class='add-to-data-selection--icon']")).click();
	   
	}
	
	
	
	
	
	@And("^Enter \"([^\"]*)\" values$")
	public void enter_values(String arg1) throws Throwable {
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[text()='Grouping separator']//following::*[contains(text(),\"" + arg1 + "\")][1]", 4)
				.click();
		if (arg1.equalsIgnoreCase("Space")) {
			space = " ";
		}
		if (arg1.equalsIgnoreCase("None")) {
			none = "";
		}
	}

	@And("^Get the text for first (\\d+) series$")
	public void get_the_text_for_first_series(int arg1) throws Throwable {
		/*text_series1 = CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[@class='search-series-list']/*[1]/div/a/div[3]/div[1]/div/div/div[1]/div[2]", 8)
				.getText();*/
		text_series1=login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]")).getText();
		text_series2=login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[2]")).getText();
		
		/*text_series2 = CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[@class='search-series-list']/*[2]/div/a/div[3]/div[1]/div/div/div[1]/div[2]", 8)
				.getText();*/
	}

	@And("^Click on the download button in header$")
	public void click_on_the_download_button_in_header() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'button__download-btn')]", 8).click();
		CommonFunctionality.wait(1000);
	}

	@And("^Click on the download button in popup$")
	public void click_on_the_download_button_in_popup() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='sphere-modal-controls']//*[contains(@class,'button__download-btn')]", 8).click();
		CommonFunctionality.wait(3000);
	}

	@And("^Search for the series in db tab with SID \"([^\"]*)\"$")
	public void search_for_the_series_in_db_tab_with_SID(String arg1) throws Throwable {
		WebElement data = CommonFunctionality.getElementByProperty(login.driver, "Data", 8);
		if (data.isDisplayed()) {
			data.click();
		}
		CommonFunctionality.getElementByProperty(login.driver, "Databases", 8).click();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).clear();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(arg1);
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
	}

	@And("^Search for the series in series tab with SID \"([^\"]*)\"$")
	public void search_for_the_series_in_series_tab_with_SID(String arg1) throws Throwable {
		WebElement data = CommonFunctionality.getElementByProperty(login.driver, "Data", 8);
		if (data.isDisplayed()) {
			data.click();
		}
		CommonFunctionality.getElementByProperty(login.driver, "Series_new", 8).click();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).clear();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(arg1);
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
	}

	@SuppressWarnings("deprecation")
	@And("^Select (\\d+) series and click on \"([^\"]*)\" option$")
	public void select_series_and_click_on_option(int arg1, String arg2) throws Throwable {
		for (int i = 1; i <= 2; i++) {
			CommonFunctionality.getElementByXpath(login.driver,
					"(//span[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]", 8).click();
			CommonFunctionality.wait(2000);
			
			
		}
		WebElement FirstSeries=login.driver.findElement(By.xpath("//div[@class='series-item--main-info']"));
		new Actions(login.driver).moveToElement(FirstSeries).pause(4000).build().perform();
		if((arg2.equalsIgnoreCase("Chart"))) {
		WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("More_actions")));
		CommonFunctionality.action.moveToElement(ele1).pause(2).click().build().perform();
		//login.driver.findElement(By.xpath("//span[@title='More actions']")).click();
		 WebElement View_Chart=login.driver.findElement(By.xpath("//span[normalize-space()='Add chart']"));
		 new Actions(login.driver).moveToElement(View_Chart).pause(2000).build().perform();
		 login.driver.findElement(By.xpath("//div[contains(@class,'icon--chart-line_large')]")).click();
		try {
			WebElement apply=	login.driver.findElement(By.xpath("//button[normalize-space(text())='Apply'] "));
			apply.click();
		}
		catch(Exception e) {
			System.out.println("pop up not appeared");
		}
	
		
		
		}		else if (arg2.equalsIgnoreCase("A")) {
				
				new Actions(login.driver).sendKeys("a").pause(4000).build().perform();
			
			
		}
		/*WebElement first_series = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='search-series-list']/*[contains(@class,'series-list-item__first-item')]", 8);
		if (!(first_series.getAttribute("class").contains("series-list-item__selected"))) {
			WebElement first = CommonFunctionality.getElementByProperty(login.driver, "First_series_item_in_series", 8);
			new Actions(login.driver).moveToElement(first).pause(4000).click().build().perform();
		}
		WebElement second_series = CommonFunctionality.getElementByProperty(login.driver,
				"Second_series_item_in_series", 8);
		new Actions(login.driver).moveToElement(second_series).pause(4000).click().build().perform();
		login.driver.findElement(By.xpath("(//span[@class='view-chart-icon menu-icon'])[2]")).click();/*
		
		/*WebElement actions = CommonFunctionality.getElementByProperty(login.driver, "Series_actions", 8);
		new Actions(login.driver).moveToElement(actions).pause(4000).build().perform();
		if (arg2.equalsIgnoreCase("Chart")) {
			WebElement chart;
			try {
				chart = CommonFunctionality.getElementByProperty(login.driver, "View_as_chart_in_series", 8);
				
			} catch (Exception e) {
				chart = CommonFunctionality.getElementByXpath(login.driver,
						"(//*[contains(@class,'series-item-information--additional-info-field__dates')])[1]", 8);
			}
			CommonFunctionality.wait(4000);
			js.executeScript("arguments[0].click();", chart);
		} else if (arg2.equalsIgnoreCase("A")) {
			new Actions(login.driver).sendKeys("a").pause(4000).build().perform();
		}
*/	
		
		
		
	}

	@SuppressWarnings("deprecation")
	@And("^Select a series on right$")
	public void select_a_series_on_right() throws Throwable {
		CommonFunctionality.wait(6000);
		WebElement series = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_checkbox_right")));
		new Actions(login.driver).pause(2000).moveToElement(series).pause(2000).click().build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Click on any series from series tab$")
	public void click_on_any_series_from_series_tab() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Series_new", 4).click();
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
	
	@And("^Click on functions wizard option  from right panel series$")
	public void click_on_functions_wizard_option_from_right_panel_series() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement one_series=login.driver.findElement(By.xpath("//*[@class='series-item--name']"))	;
		
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
		WebElement selected = login.driver.findElement(By.xpath("//input[@name='select_all_dataselection']"));
		if (arg1.equals("fx")) {
			if (select_all != true) {
				js.executeScript("arguments[0].click();", selected);
				WebElement functions = CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@title,'More') and @class='insight-action-panel--btn']", 4);
				js.executeScript("arguments[0].click();", functions);
			}
		}
		if (arg1.equalsIgnoreCase("Copy the series")) {
			if (select_all != true) {
				js.executeScript("arguments[0].click();", selected);
				new Actions(login.driver)
						.moveToElement(
								CommonFunctionality.getElementByXpath(login.driver, "//*[@data-action='copy']", 4))
						.perform();
			}
		} else {
			if (select_all != true) {
				js.executeScript("arguments[0].click();", selected);
				WebElement relate = CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(text(),'" + arg1 + "')] | //*[contains(@title,'" + arg1 + "')]", 4);
				if (relate.isEnabled()) {
					js.executeScript("arguments[0].click();", relate);
				} else {
					sa.fail("Not enabled");
				}
			}
		}

	
		}

	@And("^click on 'fx' to open 'All functions' popup$")
	public void click_on_fx_to_open_All_functions_popup() throws Throwable {
		WebElement toolbar = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='function-editor-window--icon']", 4);
		//if (!(toolbar.getAttribute("class").contains("fx-panel-toggle__is-open"))) {
			toolbar.click();
		//}
		WebElement function = CommonFunctionality.getElementByClassName(login.driver, "function-editor-window--icon",
				4);
		js.executeScript("arguments[0].click();", function);
		if (login.driver.findElement(By.xpath("//*[@class='function-wizard']")).isDisplayed()) {
			System.out.println("Functions wizard is displaying");
		}
	}

	@And("^Enter \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" function$")
	public void enter_function(String arg1, String arg2, String arg3) throws Throwable {
		//CommonFunctionality.getElementByProperty(login.driver, "Functions_input_field", 4).click();
		CommonFunctionality.wait(3000);
		WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Functions_input_field")));
		js.executeScript("arguments[0].click();", ele1);
		Thread.sleep(3000);
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
		
		
		/*CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'search-functions-input')]", 4)
				.sendKeys(arg1);
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'search-functions-input')]", 4)
				.sendKeys(Keys.ENTER);*/
		
		
		if (arg1.equalsIgnoreCase("UPDATE")) {
			WebElement Agreegate=login.driver.findElement(By.xpath("//*[@data-id='AGGREGATE']"));
			js.executeScript("arguments[0].scrollIntoView(true);", Agreegate);
			WebElement Update=login.driver.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]"));
			js.executeScript("arguments[0].click();", Update);
		} else {
			CommonFunctionality.wait(3000);
			WebElement Mul=login.driver.findElement(By.xpath("//div[@data-id='MULTIPLY']"));
			js.executeScript("arguments[0].scrollIntoView(true);", Mul);
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath("//div[@data-id='AGGREGATE']")).click();
			WebElement Accumulate=login.driver.findElement(By.xpath("//*[@data-id='MATHRECPROCAL']"));
			js.executeScript("arguments[0].scrollIntoView(true);", Accumulate);
			WebElement HPFilter=login.driver.findElement(By.xpath("//*[@data-id='" + arg1 + "']"));
			js.executeScript("arguments[0].scrollIntoView(true);", HPFilter);
			js.executeScript("arguments[0].click();", HPFilter);			
		}
	}

	@And("^click on \"([^\"]*)\" in functions search$")
	public void click_on_in_functions_search(String arg1) throws Throwable {
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[@class='function-wizard-sidebar']//following::*[contains(text(),'" + arg1 + "')] ", 4)
				.click();
	}

	@And("^Check for \"([^\"]*)\" popup$")
	public void check_for_popup(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Download")) {
			List<WebElement> download = login.driver.findElements(By.className("download-modal-title__title"));
			download_title = download.size();
		}
	}

	@And("^Click on Download button in header$")
	public void click_on_Download_button_in_header() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'button__download-btn')]", 4).click();
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
		CommonFunctionality.wait(2000);
		title_ssp = CommonFunctionality.getElementByClassName(login.driver, "series-preview-modal-header--link", 4)
				.getText();
	}

	@And("^Navigating to back$")
	public void navigating_to_back() throws Throwable {
		login.driver.navigate().back();
	}

	@And("^Click on my insights$")
	public void click_on_my_insights() throws Throwable {
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='My insights']", 4).click();
		//CommonFunctionality.getElementByXpath(login.driver, "//*[text()='My insights']", 8).click();
		
	}

	@And("^Click on Created tab under Myinsights$")
	public void click_on_Created_tab_under_Myinsights() throws Throwable {
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='tabs__tabs-box']//*[text()='Created']", 4)
				.click();
	}

	@SuppressWarnings("deprecation")
	@And("^Click \"([^\"]*)\" > \"([^\"]*)\"$")
	public void click(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(2000);
		if (arg1.equalsIgnoreCase("File")) {
			CommonFunctionality.wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Open File menu']")));
			WebElement file = CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Open File menu']", 4);
			new Actions(login.driver).moveToElement(file).pause(1000).click().build().perform();
		}
		if (arg1.equalsIgnoreCase("Help")) {
			CommonFunctionality.wait(3000);
			WebElement help = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='data-manager']//*[contains(@class,'data-manager--title')] | //div[@class='help-title']",
					8);
			new Actions(login.driver).moveToElement(help).pause(2000).click().build().perform();
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg2 + "')]", 4).click();
		}
		if (arg2.equalsIgnoreCase("View") || arg2.equalsIgnoreCase("New")) {
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(@class,'items-wrapper')]//following-sibling::*[text()='" + arg2 + "']", 4)
					.click();
			CommonFunctionality.wait(1000);
		}
		if (arg2.equalsIgnoreCase("Open")) {
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(@class,'items-wrapper')]//following-sibling::*[text()='Open Recent']", 4)
					.click();
			CommonFunctionality.wait(1000);
			CommonFunctionality.getElementByXpath(login.driver, "//ul[@class='dropdown-menu']//li[1]/*[1]/*[2]", 15)
					.click();
		}
	}

	@And("^Click on \"([^\"]*)\" tab in popup$")
	public void click_on_tab_in_popup(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		//CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 4).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//*[contains(text(),'" + arg1 + "')]")))).click();
	}

	@SuppressWarnings("deprecation")
	@And("^Click on Attributes from the table list$")
	public void click_on_Attributes_from_the_table_list() throws Throwable {
		CommonFunctionality.wait(3000);
		WebElement double_click = CommonFunctionality.getElementByXpath(login.driver,
				"(//*[@class='visual-table-container']//th)[1]", 4);
		new Actions(login.driver).moveToElement(double_click).pause(4000).doubleClick().build().perform();
	}

	@And("^Check the count of attributes in table$")
	public void check_the_count_of_attributes_in_table() throws Throwable {
		List<WebElement> attributes_list = login.driver.findElements(By.className("hor-vertical-header"));
		attributes_table_count_before = attributes_list.size();
	}

	@And("^Select attributes checkbox$")
	public void select_attributes_checkbox() throws Throwable {
		CommonFunctionality.wait(3000);
		title_checkbox_webElement = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'Title')]/following::*[contains(@class,'input-control__sm')][1]", 4);
	}

	@And("^Click title attribute checkbox$")
	public void click_title_attribute_checkbox() throws Throwable {
		new Actions(login.driver).moveToElement(title_checkbox_webElement).click().build().perform();
	}

	@And("^Double click title attribute checkbox$")
	public void double_click_title_attribute_checkbox() throws Throwable {
		new Actions(login.driver).moveToElement(title_checkbox_webElement).doubleClick().build().perform();
	}

	@And("^Select few attributes \"([^\"]*)\"$")
	public void select_few_attributes(String arg1) throws Throwable {
		few_attributes = arg1;
		boolean attributes_element = login.driver.findElement(By.xpath(
				"//*[contains(text(),'" + few_attributes + "')]/following::*[contains(@class,'input-control__sm')][1]"))
				.isSelected();
		if (attributes_element == false) {
			new Actions(login.driver).moveToElement(login.driver.findElement(By.xpath("//*[contains(text(),'"
					+ few_attributes + "')]/following::*[contains(@class,'input-control__sm')][1]"))).click().build()
					.perform();
			attributes = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + few_attributes
					+ "')]/following::*[contains(@class,'input-control__sm')][1]/preceding::*[@class='table-property-item--label-text'][1]",
					4).getText();
		}
	}

	@And("^Click the new insight option$")
	public void click_the_new_insight_option() throws Throwable {
		if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal__content')]//*[text()='Continue']"))
				.size() > 0) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'sphere-modal__content')]//*[text()='Continue']", 4).click();
		}
	}

	@And("^Click on the insight point$")
	public void click_on_the_insight_point() throws Throwable {
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "className", "span[data-name='title']");
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
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
		new Actions(login.driver)
				.moveToElement(
						CommonFunctionality.getElementByXpath(login.driver, "(//span[@data-name='title'])[2]", 4))
				.pause(2000).click().build().perform();
		// CommonFunctionality.getElementByClassName(login.driver,
		// "sphere-modal__close", 4).click();
		WebElement help = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='insight-preview--views']//*[@class='" + arg1 + "--wrapper']", 4);
		new Actions(login.driver).moveToElement(help).pause(2000).build().perform();
	}

	@And("^Collapse the footnotes$")
	public void collapse_the_footnotes() throws Throwable {
		CommonFunctionality.getElementBycssSelector(login.driver, ".footnotes--collapse-sidebar", 4).click();
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
		CommonFunctionality.getElementByXpath(login.driver, "//div[contains(text(),'"+arg1+"')]", 4).click();
		/*WebElement View_Chart=login.driver.findElement(By.xpath("//span[normalize-space()='Add chart']"));
		 new Actions(login.driver).moveToElement(View_Chart).pause(2000).build().perform();
		 login.driver.findElement(By.xpath("//div[contains(@class,'icon--table-vertical_large')]")).click();
		 try {
				WebElement apply=	login.driver.findElement(By.xpath("//*[contains(text(),'Apply')]"));
				apply.click();
			}
			catch(Exception e) {
				System.out.println("pop up not appeared");
			}*/
			
	}
	
	@And("^Click \"([^\"]*)\"  from empty list$")
	public void click_from_empty_list(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement View_asTable=login.driver.findElement(By.xpath("//div[@title='"+ arg1+"']"));
		View_asTable.click();
		
	    
	}
	
	
	

	@And("^Click \"([^\"]*)\" button in images wizard$")
	public void click_button_in__images_wizard(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg1 + "']", 4).click();
	}

	@And("^Click \"([^\"]*)\" button to upload images$")
	public void click_button_to_upload_images(String arg1) throws Throwable {
		CommonFunctionality.wait(4000);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@aria-label='" + arg1 + "']", 4).click();
		CommonFunctionality.wait(2000);
		CommonFunctionality.uploadTheFileusingAutoIT(login.driver,
				System.getProperty("user.dir") + "\\AutoIT\\Shravas.exe",
				System.getProperty("user.dir") + "\\AutoIT\\Shravas.png");
		CommonFunctionality.wait(2000);
	}

	@And("^Click on \"([^\"]*)\" tab in insights$")
	public void click_on_tab_in_insights(String arg1) throws Throwable {
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//div[@class='search-presentation-tabs--visible']//*[contains(text(),'" + arg1 + "')]", 4)
				.click();
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
		CommonFunctionality.wait(5000);
		
		WebElement ele=CommonFunctionality.getElementByProperty(login.driver, "EMIS_Insight_Landingpage", 8);
		js.executeScript("arguments[0].click();", ele);
		
		CommonFunctionality.wait(5000);
		WebElement title = CommonFunctionality.getElementByXpath(login.driver,
				"(//*[@class='insight-grid-item--bottom-panel'])[1]", 4);
		new Actions(login.driver).moveToElement(title).pause(3000).build().perform();
		CommonFunctionality.wait(1000);
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[@class='insights-view--grid']/*[1]//*[@class='insight-grid-item--buttons']/*[1]", 4)
				.click();
	}

	@And("^Click on the insight button \"([^\"]*)\"$")
	public void click_on_the_insight_button(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'sphere-modal__content')]//*[text()='" + arg1 + "']", 4).click();
	}

	@SuppressWarnings("deprecation")
	@And("^Open notification panel$")
	public void open_notification_panel() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement notification = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='user-panel']//*[@class='user-notifications--icon']", 4);
		new Actions(login.driver).moveToElement(notification).pause(1000).click().build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Open preference dropdown$")
	public void open_preference_dropdown() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement preferences;
		try {
			preferences = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@title='View and edit profile information']", 8);
		} catch (Exception e) {
			preferences = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='account-avatar--container'] | //*[@class='account-avatar--image']", 8);
		}
		new Actions(login.driver).moveToElement(preferences).pause(3000).click().build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Click on \"([^\"]*)\" from preferences$")
	public void click_on_from_preferences(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		if (arg1.equalsIgnoreCase("edit-avatar--edit-btn")) {
			new Actions(login.driver).moveToElement(login.driver.findElement(By.xpath("//*[@class='account-avatar']")))
					.pause(1000).build().perform();
			WebElement image = CommonFunctionality.getElementByClassName(login.driver, "" + arg1 + "", 4);
			new Actions(login.driver).moveToElement(image).pause(2000).click().build().perform();
		} else if (arg1.equalsIgnoreCase("Change password")) {
			if (login.driver.findElements(By.xpath("//*[text()='" + arg1 + "']")).size() > 0) {
				CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']", 4).click();
			}
		} else {
			new Actions(login.driver)
					.moveToElement(login.driver.findElement(By.xpath("//*[contains(@class,'profile-menu--email')]")))
					.pause(1000).build().perform();
			WebElement pencil_icon = CommonFunctionality.getElementByClassName(login.driver, "" + arg1 + "", 4);
			new Actions(login.driver).moveToElement(pencil_icon).pause(2000).click().build().perform();
		}
	}

	@And("^Click on the Upload button to upload \"([^\"]*)\"$")
	public void click_Upload_button_to_upload(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Image")) {
			CommonFunctionality.wait(2000);
			CommonFunctionality.uploadTheFileusingAutoIT(login.driver,
					System.getProperty("user.dir") + "\\AutoIT\\Shravas.exe",
					System.getProperty("user.dir") + "\\AutoIT\\Shravas.png");
			CommonFunctionality.wait(2000);
		} else if (arg1.equalsIgnoreCase("Large Image")) {
			CommonFunctionality.wait(2000);
			CommonFunctionality.uploadTheFileusingAutoIT(login.driver,
					System.getProperty("user.dir") + "\\AutoIT\\Technology.exe",
					System.getProperty("user.dir") + "\\AutoIT\\Technology.jpg");
			CommonFunctionality.wait(2000);
		} else if (arg1.equalsIgnoreCase("Videos")) {
			CommonFunctionality.wait(2000);
			CommonFunctionality.uploadTheFileusingAutoIT(login.driver,
					System.getProperty("user.dir") + "\\AutoIT\\Typing.exe",
					System.getProperty("user.dir") + "\\AutoIT\\Typing.mp4");
			CommonFunctionality.wait(2000);
		} else if (arg1.equalsIgnoreCase("File")) {
			CommonFunctionality.wait(2000);
			CommonFunctionality.uploadTheFileusingAutoIT(login.driver,
					System.getProperty("user.dir") + "\\AutoIT\\Empty_File.exe",
					System.getProperty("user.dir") + "\\AutoIT\\Empty_File.txt");
			CommonFunctionality.wait(2000);
		}
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

	@And("^\"([^\"]*)\" popup should be closed$")
	public void popup_should_be_closed(String arg1) throws Throwable {
		if (login.driver.findElements(By.className("movable-modal--close")).size() == 0) {
			login.Log4j.info(arg1 + " popup is closed successfully");
		} else {
			fail(arg1 + " popup is NOT closed");
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Right Click the selected series to \"([^\"]*)\"$")
	public void right_click_the_selected_series_to(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);
		WebElement one = CommonFunctionality.getElementByProperty(login.driver, "One_series_from_myserieslist", 8);
		CommonFunctionality.wait(2000);
		new Actions(login.driver).moveToElement(one).pause(6000).contextClick().build().perform();
		CommonFunctionality.wait(3000);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='name-li' and text()='" + arg1 + "']", 8)
				.click();
	}

	@And("^Check the checkbox for \"([^\"]*)\"$")
	public void check_the_checkbox_for(String arg1) throws Throwable {
		preference_checkbox1 = login.driver
				.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]/preceding-sibling::input")).isSelected();
	}

	@And("^Click \"([^\"]*)\" button in preferences$")
	public void click_button_in_preferences(String arg1) throws Throwable {
		WebElement button = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='profile-modal--buttons']//*[text()='" + arg1 + "']", 4);
		js.executeScript("arguments[0].click();", button);
	}

	@And("^Click on edit in \"([^\"]*)\" from preferences$")
	public void click_on_edit_in_from_preferences(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']/following::span[1]", 4).click();
		CommonFunctionality.getElementByXpath(login.driver,
				"(//ul[@class='select2-results']//*[@class='select2-result-label'])[4]", 4).click();
		prefix_edit = CommonFunctionality
				.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']/following::span[1]", 4).getText();
	}

	@And("^Click on edit in \"([^\"]*)\" from preferences option$")
	public void click_on_edit_in_from_preferences_option(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']/following-sibling::input", 4)
				.clear();
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']/following-sibling::input", 4)
				.sendKeys("CDMNext");
	}

	@And("^Click on edit in \"([^\"]*)\" from preferences options$")
	public void click_on_edit_in_from_preferences_options(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']/following-sibling::input", 4)
				.clear();
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']/following-sibling::input", 4)
				.sendKeys("Insights");
	}

	@And("^Click on edit in \"([^\"]*)\" from preferences dropdown$")
	public void click_on_edit_in_from_preferences_dropdown(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("First Name")) {
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']/following-sibling::input", 4).clear();
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']/following-sibling::input", 4)
					.sendKeys(edited_first_name);
		} else {
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']/following-sibling::input", 4).clear();
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']/following-sibling::input", 4)
					.sendKeys(edited_last_name);
		}
	}

	@And("^Click on edit in \"([^\"]*)\" option from preferences$")
	public void click_on_edit_in_option_from_preferences(String arg1) throws Throwable {
		email = login.driver.findElement(By.xpath("//*[text()='" + arg1 + "']/following-sibling::input"));
	}

	@And("^Getting the value in \"([^\"]*)\" from user preferences$")
	public void getting_the_value_in_from_user_preferences(String arg1) throws Throwable {
		first_name_edit = CommonFunctionality
				.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']/following-sibling::input", 4)
				.getAttribute("value");
	}

	@And("^Getting the value in \"([^\"]*)\" from user preference option$")
	public void getting_the_value_in_from_user_preference_option(String arg1) throws Throwable {
		last_name_edit = CommonFunctionality
				.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']/following-sibling::input", 4)
				.getAttribute("value");
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

	@And("^Enter the password \"([^\"]*)\" as \"([^\"]*)\"$")
	public void enter_the_password_as(String arg1, String arg2) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']/following-sibling::input", 4)
				.sendKeys(arg2);
	}

	@And("^Select \"([^\"]*)\" as language$")
	public void select_as_language(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='languages-menu']//*[contains(text(),'" + arg1 + "')]", 4)
				.click();
	}

	@And("^Capture the Selected language$")
	public void capture_the_Selected_language() throws Throwable {
		CommonFunctionality.wait(5000);
		language = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='languages-menu']//*[contains(@class,'active')]", 4)
				.getText();
	}

	@And("^Wait for the language to update$")
	public void wait_for_the_language_to_update() throws Throwable {
		CommonFunctionality.wait(20000);
	}

	@And("^Clicking on \"([^\"]*)\" option in preference$")
	public void clicking_on_option_in_preference(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		if (arg1.equalsIgnoreCase("Date format")) {
			CommonFunctionality.getElementByProperty(login.driver, "Date_format_in_preferences", 4).click();
			CommonFunctionality.wait(3000);
			dateformat = CommonFunctionality.getElementByClassName(login.driver, "date-format-example", 4).getText();
		} else if (arg1.equalsIgnoreCase("Number format")) {
			CommonFunctionality.getElementByProperty(login.driver, "Number_format_in_preferences", 12).click();
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Clicking on \"([^\"]*)\" option under user preference be \"([^\"]*)\"$")
	public void clicking_on_option_under_user_preference_be(String arg1, String arg2) throws Throwable {
		WebElement preference_drop = CommonFunctionality.getElementByXpath(login.driver,
				"//*[text()='" + arg1 + "']/following::div[2]", 4);
		if (arg2.equalsIgnoreCase("ON")) {
			CommonFunctionality.wait(3000);
			if (preference_drop.getAttribute("class").contains("bootstrap-switch-on")) {
				new Actions(login.driver)
						.moveToElement(login.driver.findElement(By.className("shortcuts-settings--wrapper"))).perform();
			} else {
				new Actions(login.driver)
						.moveToElement(login.driver.findElement(
								By.xpath("//*[@class='shortcuts-settings--wrapper']/following-sibling::div")))
						.pause(2000).click().build().perform();
			}
		} else if (arg2.equalsIgnoreCase("OFF")) {
			CommonFunctionality.wait(3000);
			if (preference_drop.getAttribute("class").contains("bootstrap-switch-off")) {
				new Actions(login.driver)
						.moveToElement(login.driver.findElement(By.className("shortcuts-settings--wrapper"))).perform();
			} else {
				new Actions(login.driver)
						.moveToElement(login.driver.findElement(
								By.xpath("//*[@class='shortcuts-settings--wrapper']/following-sibling::div")))
						.pause(2000).click().build().perform();
			}
		}
	}

	@And("^Clicking on \"([^\"]*)\" option under user preference$")
	public void clicking_on_option_under_user_preference(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']", 4).click();
	}

	@Then("^The \"([^\"]*)\" dialog box should be open$")
	public void the_dialog_box_should_be_open(String arg1) throws Throwable {
		if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal-dialog')]//*[text()='" + arg1 + "']"))
				.size() > 0) {
			System.out.println("The " + arg1 + " dialog box is opened");
		} else {
			fail("Verification Failed");
		}
	}

	@And("^Click on \"([^\"]*)\" button from CEIC API access$")
	public void click_on_button_from_CEIC_API_access(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Verify Key ")) {
			WebElement button = login.driver
					.findElement(By.xpath("//*[@class='api-manager--buttons']//*[text()='" + arg1 + "']"));
			CommonFunctionality.getElementByClassName(login.driver, "api-manager--input", 4).clear();
			CommonFunctionality.getElementByClassName(login.driver, "api-manager--input", 4).sendKeys(final_api);
			if (!(button.getAttribute("class").contains("disabled"))) {
				button.click();
			}
		}
		if (arg1.equalsIgnoreCase("Cancel")) {
			WebElement button = login.driver
					.findElement(By.xpath("//*[@class='api-manager--buttons']//*[text()='Verify Key ']"));
			CommonFunctionality.getElementByClassName(login.driver, "api-manager--input", 4).sendKeys(
					"dLqP2gucYVN1wQUSlz8zPNqHhnAOMReHKyWAiR7vd7SvJuBPQGbycFvjcySlNZfqtGoznlcJbZS47Nj4OU0GzvlIAfeT07EyLL8yBYJmqWoKrhmchKOq4GNGi09fSpmx");
			if (!(button.getAttribute("class").contains("disabled"))) {
				button.click();
			}
		}
	}

	@And("^Click on \"([^\"]*)\" from the application$")
	public void click_on_from_the_application(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']", 4).click();
		CommonFunctionality.wait(2000);
	}

	@And("^Click on \"([^\"]*)\" help button from CEIC API access$")
	public void click_on_help_button_from_CEIC_API_access(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='api-manager--doc-link' and text()='" + arg1 + "']", 12)
				.click();
		CommonFunctionality.wait(2000);
	}

	@SuppressWarnings("deprecation")
	@And("^Click on Generate new key button from CEIC API access$")
	public void click_on_Generate_new_key_button_from_CEIC_API_access() throws Throwable {
		CommonFunctionality.wait(3000);
		boolean button = login.driver.findElement(By.xpath("//*[contains(@class,'api-manager--generate-button')]"))
				.isEnabled();
		if (button == true) {
			WebElement generate = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'api-manager--generate-button')]", 8);
			new Actions(login.driver).moveToElement(generate).pause(4000).click().build().perform();
		}
	}

	@And("^CEIC Help dialog box is opened$")
	public void CEIC_Help_dialog_box_is_opened() throws Throwable {
		if (CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[contains(@class,'sphere-modal-dialog')]//*[text()='Applications Help']", 4)
				.isDisplayed()) {
			System.out.println("CEIC API Help dialog box is displayed");
		} else {
			fail("Verification failed");
		}
	}

	@And("^Click on close button of CEIC API access dialog box$")
	public void click_on_close_button_of_CEIC_API_access_dialog_box() throws Throwable {
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
	}

	@And("^Click on Copy button from CEIC API access$")
	public void click_on_Copy_button_from_CEIC_API_access() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='api-manager--copy-button']", 8).click();
	}

	@And("^Copied API key is stored into a string$")
	public void copied_API_key_is_stored_into_a_string() throws Throwable {
		CommonFunctionality.wait(200);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		final_api = (String) clipboard.getData(DataFlavor.stringFlavor);
	}

	@SuppressWarnings("deprecation")
	@And("^Clicking on \"([^\"]*)\" option under user preference to be \"([^\"]*)\"$")
	public void clicking_on_option_under_user_preference_to_be(String arg1, String arg2) throws Throwable {
		
		if (arg2.equalsIgnoreCase("Uncheck")) {
			CommonFunctionality.wait(1000);
			checkbox_prefer = login.driver
					.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]/preceding-sibling::input[@type='checkbox']")).isSelected();							
			if (checkbox_prefer == true) {
				new Actions(login.driver)
						.moveToElement(login.driver
								.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]/preceding-sibling::span")))
						.pause(2000).click().build().perform();
			}
		} else if (arg2.equalsIgnoreCase("Check")) {
			checkbox_prefer = login.driver
					.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]/preceding-sibling::input")).isSelected();
							
			if (checkbox_prefer == false) {
				new Actions(login.driver)
						.moveToElement(login.driver
								.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]/preceding-sibling::span")))
						.pause(2000).click().build().perform();
			}
		}
	}
	@And("^Try to delete the visual$")
	public void try_to_delete_the_visual() throws Throwable {
	   CommonFunctionality.getElementByXpath(login.driver, "//*[@class='vis-elem-menu vis-elem-menu__page'] //*[@title='Delete']", 10).click();
	}

	@Then("^Delete visual confirmation message should not be displayed to users while deleting visual$")
	public void delete_visual_confirmation_message_should_not_be_displayed_to_users_while_deleting_visual() throws Throwable {
	   if(login.driver.findElements(By.xpath("//*[@class='modal-window modal-window__active'] //*[contains(text(),'Ask me to confirm visual deletion')]")).size() == 0 ) {
		   login.Log4j.info("Confirmation message is not displayed for delete visual");
	   } else {
		   Assert.fail("Confirmation pop up is dispalyed");
	   }
	}
	@And("^Perform any Keyboard operation$")
	public void perform_any_Keyboard_operation() throws Throwable {
		new Actions(login.driver).sendKeys(Keys.chord("a")).perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Clicking on \"([^\"]*)\" option under user preference as \"([^\"]*)\"$")
	public void clicking_on_option_under_user_preference_as(String arg1, String arg2) throws Throwable {
		if (arg2.equalsIgnoreCase("Uncheck")) {
			preference_checkbox = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(text(),'" + arg1 + "')]/preceding-sibling::span", 4);
			if (preference_checkbox.isSelected()) {
				new Actions(login.driver).moveToElement(preference_checkbox).pause(2000).click().build().perform();
			}
		} else if (arg2.equalsIgnoreCase("Check")) {
			preference_checkbox = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(text(),'" + arg1 + "')]/preceding-sibling::span", 4);
			if (preference_checkbox.isSelected()) {
				new Actions(login.driver).moveToElement(preference_checkbox).pause(2000).click().build().perform();
			}
		}
	}

	@And("^Click on \"([^\"]*)\" in format$")
	public void click_on_in_format(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Grouping separator")) {
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]//following::label[1]", 12)
					.click();
		}
	}

	@And("^Click on \"([^\"]*)\" in format and enter value as (\\d+)$")
	public void click_on_in_format_and_enter_value_as(String arg1, int arg2) throws Throwable {
		separator_value = Integer.toString(arg2);
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]/following::input[1]", 12)
				.click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]/following::input[1]", 12)
				.clear();
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]/following::input[1]", 12)
				.sendKeys(separator_value);
	}

	@SuppressWarnings("unused")
	@And("^Get Text on \"([^\"]*)\" in format$")
	public void get_Text_on_in_format(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Grouping separator")) {
			String dec = CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]/following::span[1]", 4)
					.getText();
		} else {
			CommonFunctionality.wait(2000);
			String dec = CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]//following::input[1]", 4)
					.getAttribute("aria-valuenow");
			decimal_places = Integer.parseInt(dec);
		}
	}

		@And("^Get Value of \"([^\"]*)\" in Preference$")
	public void get_Value_of_in_Preference(String arg1) throws Throwable {
		//added
			
			
		
		
		
		if (arg1.equalsIgnoreCase("Decimal separator")) {
			
			CommonFunctionality.getElementByProperty(login.driver, "Number_format_in_values_axis", 4).click();
			
			System.out.println("Number format dropdown is displayed");
			decimal_seperator = CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(text(),'" + arg1
									+ "')]//following::*[contains(@class,'toggler-control-item__selected')]/span",
							4)
					.getText();
			System.out.println("=====decimal======"+decimal_seperator);
		} else if (arg1.equalsIgnoreCase("Grouping separator")) {
			grouping_seperator = CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(text(),'" + arg1
									+ "')]//following::*[contains(@class,'toggler-control-item__selected')]/span",
							4)
					.getText();
		}
	}

	@And("^The checkbox should be unchecked for \"([^\"]*)\"$")
	public void the_checkbox_should_be_unchecked(String arg1) throws Throwable {
		if (preference_checkbox1 == false) {
			login.Log4j.info("The check box " + arg1 + " is unselected in preferences");
		} else {
			fail("Verification Failed");
		}
	}

	@And("^Check for Replacement Suggestion Popup$")
	public void check_for_Replacement_Suggestion_Popup() throws Throwable {
		List<WebElement> suggestion_list = login.driver
				.findElements(By.xpath("//*[contains(@class,'movable-modal--window')]"));
		suggestion = suggestion_list.size();
	}

	@And("^Getting the text of first search keyword$")
	public void getting_the_text_of_first_search_keyword() throws Throwable {
		first_search_keyword = CommonFunctionality.getElementByClassName(login.driver, "series-series-count--number", 4)
				.getText();
		first_search_keyword=first_search_keyword.replace(",", "");
//	 act=first_search_keyword.substring(0,4);
	 

	// System.out.println("==act====="+act);
		System.out.println("==first_search_keyword====="+first_search_keyword);
	}

	@And("^Getting the text of next search keyword$")
	public void getting_the_text_of_next_search_keyword() throws Throwable {
		second_search_keyword = CommonFunctionality
				.getElementByClassName(login.driver, "series-series-count--number", 4).getText();
		second_search_keyword=second_search_keyword.replace(",", "");
		System.out.println("second"+second_search_keyword);
		// exp=	second_search_keyword.substring(0,5);
		
	}

	@And("^Perform Download operation$")
	public void perform_Download_operation() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'button__download-btn')]", 4).click();
		CommonFunctionality.wait(2000);
		if (login.driver.findElements(By.xpath("//*[@class='sphere-modal-controls']//*[text()='Copy to Clipboard']"))
				.size() > 0) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='sphere-modal-controls']//*[contains(text(),'Download')]", 4).click();
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Check \"([^\"]*)\" Checkbox in replacement popup$")
	public void check_Checkbox_in_replacement_popup(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		replacement_not_show = login.driver
				.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]/preceding-sibling::input")).isSelected();
		if (replacement_not_show == false) {
			new Actions(login.driver)
					.moveToElement(login.driver
							.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]/preceding-sibling::span")))
					.pause(1000).click().build().perform();
		}
		if (replacement_not_show == true) {
			System.out.println("The " + arg1 + " Checkbox is checked");
		}
		replacement_not_show_updated = login.driver
				.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]/preceding-sibling::input")).isSelected();
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='series-changes-summary--footer']//*[text()='Dismiss']", 4)
				.click();
	}

	@And("^Enter \"([^\"]*)\" custom date$")
	public void enter_custom_date(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Valid")) {
			CommonFunctionality.getElementByProperty(login.driver, "Custom_field_value", 4).clear();
			CommonFunctionality.getElementByProperty(login.driver, "Custom_field_value", 4).sendKeys(valid_date);
			valid_date_format = CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='custom-date-format']//*[@class='format-example']", 4)
					.getText();
		} else if (arg1.equalsIgnoreCase("Invalid")) {
			CommonFunctionality.getElementByProperty(login.driver, "Custom_field_value", 4).clear();
			CommonFunctionality.getElementByProperty(login.driver, "Custom_field_value", 4).sendKeys(invalid_date);
		} else {
			CommonFunctionality.getElementByProperty(login.driver, "Custom_field_value", 4)
					.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Click \"([^\"]*)\" format date option$")
	public void click_format_date_option(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Auto")) {
			WebElement auto = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'date-format--context-menu')]//*[contains(text(),'" + arg1
							+ "')]/preceding::span[1]",
					4);
			new Actions(login.driver).moveToElement(auto).pause(2000).click().build().perform();
		} else if (arg1.equalsIgnoreCase("Custom")) {
			WebElement custom = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'date-format--context-menu')]//*[contains(text(),'" + arg1
							+ "')]/preceding::span[1]",
					4);
			new Actions(login.driver).moveToElement(custom).pause(2000).click().build().perform();
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Open SSP for the selected series$")
	public void open_SSP_for_the_selected_series() throws Throwable {
		WebElement one = CommonFunctionality.getElementByProperty(login.driver, "One_series_from_seriesList", 4);
		new Actions(login.driver).moveToElement(one).pause(2000).click().build().perform();
	}

	@And("^Select Updated date format in SSP$")
	public void select_Updated_date_format_in_SSP() throws Throwable {
		updated_date = CommonFunctionality
				.getElementByClassName(login.driver, "series-changes-time-line--last-update-date", 4).getText();
		if (!(dateformat.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")
				|| dateformat.matches("([0-9]{2})-([0-9]{2})-([0-9]{4})")
				|| dateformat.matches("([0-9]{2}).([0-9]{2}).([0-9]{4})")
				|| dateformat.matches("([0-9]{2})/([0-9]{3})/([0-9]{4})")
						&& updated_date.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")
				|| updated_date.matches("([0-9]{2})-([0-9]{2})-([0-9]{4})")
				|| updated_date.matches("([0-9]{2}).([0-9]{2}).([0-9]{4})")
				|| updated_date.matches("([0-9]{2})/([0-9]{3})/([0-9]{4})"))) {
			fail("Verification Failed");
		}
	}

	@And("^Capture the Timepoint value inside \"([^\"]*)\" tab$")
	public void capture_the_Timepoint_value_inside_tab(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Data")) {
			entire_data = CommonFunctionality.getElementByProperty(login.driver, "data_in_data_tab", 4).getText();
			int integer = entire_data.indexOf(decimal_seperator);
			decimalPlaces = entire_data.length() - integer - 1;
		} else if (arg1.equalsIgnoreCase("SSP")) {
			full_data = CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(text(),'2018')]//following-sibling::span", 4)
					.getText();
			int seperator = full_data.indexOf(decimal_seperator);
			decimal_place_separator = full_data.length() - seperator - 1;
		} else if (arg1.equalsIgnoreCase("Group")) {
			full_data = CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(text(),'2018')]//following-sibling::span", 4)
					.getText();
			String data = full_data.split(grouping_seperator)[1];
			grouping_place_seperator = full_data.length() - data.length();
		}
	}

	@And("^Capture the Timepoint value inside Group tab$")
	public void capture_the_Timepoint_value_inside_Group_tab() throws Throwable {
		full_data1 = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'2018')]//following-sibling::span", 4).getText();
	}

	@SuppressWarnings("deprecation")
	@And("^Click on \"([^\"]*)\" icon to share insight$")
	public void click_on_icon_to_share_insight(String arg1) throws Throwable {
		CommonFunctionality.wait(4000);
		WebElement open_file_menu = CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Open File menu']",
				4);
		new Actions(login.driver).moveToElement(open_file_menu).pause(3000).click().build().perform();
		WebElement share;
		try {
			share = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='items-wrapper']//*[text()='Share']", 4);
		} catch (Exception e) {
			share = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='items-wrapper']//*[text()='Shared']", 4);
		}
		new Actions(login.driver).moveToElement(share).pause(3000).click().build().perform();
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

	@SuppressWarnings("deprecation")
	@And("^Select Users to share$")
	public void select_Users_to_share() throws Throwable {
		mail = "ceicsuresh11@gmail.com";
		WebElement mailing = CommonFunctionality.getElementByXpath(login.driver,
				"//input[@placeholder='Select people you want to invite']", 4);
		new Actions(login.driver).moveToElement(mailing).click().sendKeys(mail).pause(3000).sendKeys(Keys.BACK_SPACE)
				.build().perform();
		WebElement result = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@data-id='aa793e1f-743b-48ec-b6c9-374ae724cbcf']", 4);
		js.executeScript("arguments[0].scrollIntoView(true);", result);
		new Actions(login.driver).moveToElement(result).pause(2000).click().build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Select Users to share for second time$")
	public void select_Users_to_share_for_second_time() throws Throwable {
		String mail2 = "ceicsuresh10@gmail.com";
		WebElement mailing = CommonFunctionality.getElementByXpath(login.driver,
				"//input[@placeholder='Select people you want to invite']", 8);
		new Actions(login.driver).moveToElement(mailing).click().sendKeys(mail2).pause(2000).sendKeys(Keys.BACK_SPACE)
				.build().perform();
		WebElement result = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@data-id='2b66f4f5-d0b1-415e-91eb-9aa9b7587fb5']", 4);
		js.executeScript("arguments[0].scrollIntoView(true);", result);
		new Actions(login.driver).moveToElement(result).pause(1000).click().build().perform();
	}

	@And("^Click on \"([^\"]*)\" button to share$")
	public void click_on_button_to_share(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		boolean save = login.driver
				.findElement(By.xpath("//*[contains(@class,'sphere-modal__body')]//button[text()='" + arg1 + "']"))
				.isEnabled();
		if (save == true) {
			WebElement saving = CommonFunctionality.getElementByXpath(login.driver, "//button[text()='" + arg1 + "']",
					4);
			js.executeScript("arguments[0].click();", saving);
			System.out.println("Save button is clicked");
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Right click on Insight name and click on \"([^\"]*)\"$")
	public void right_click_on_Insight_name_and_click_on(String arg1) throws Throwable {
		WebElement right_click = CommonFunctionality.getElementByXpath(login.driver,
				"(//*[@title='Share Insight']/following::*[contains(@class,'insight-table-item--title-link')])[1]", 4);
		new Actions(login.driver).moveToElement(right_click).pause(2000).contextClick().build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='items-wrapper']//*[@title='" + arg1 + "']", 4)
				.click();
		CommonFunctionality.wait(100);
	}

	@And("^Highlight the functions and check for the tooltips$")
	public void highlight_the_functions_and_check_for_the_tooltips() throws Throwable {
		CommonFunctionality.wait(500);
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
			List<String> texts = Arrays.asList(var);
			String values = String.join(";", texts);
			values_list = values;
		} catch (Exception e) {
			frequency = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='search-filter-container']//*[contains(text(),'" + var + "')]", 4).getText();
		}
	}

	@And("^Check the display day-unit date picker$")
	public void check_for_display_dayunit_date_picker() throws Throwable {
		CommonFunctionality.wait(3000);
		start_format_datepicker = CommonFunctionality
				.getElementByXpath(login.driver, "(//*[contains(@class,'highcharts-xaxis-labels')]/*[2])[1]", 4)
				.getText();
		CommonFunctionality.wait(1000);
		end_format_datepicker = CommonFunctionality
				.getElementByXpath(login.driver, "(//*[contains(@class,'highcharts-xaxis-labels')]/*[1])[1]", 4)
				.getText();
	}

	@SuppressWarnings("deprecation")
	@And("^Hover to click on create \"([^\"]*)\"$")
	public void hover_to_click_on_create(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);
		WebElement one_series;
		try {
			one_series = CommonFunctionality.getElementByProperty(login.driver, "First_series_item", 8);
		} catch (Exception e) {
			one_series = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[@class='series-list-item-data']//following-sibling::*[@class='series-item-information'])[1] | //*[contains(@class,'search-series-list')]/*[2]/div/a/div[3]/div[2]/span[2]",
					4);
		}
		new Actions(login.driver).moveToElement(one_series).pause(3000).build().perform();
		CommonFunctionality.wait(3000);
		WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("More_actions")));
		CommonFunctionality.action.moveToElement(ele1).pause(2).click().build().perform();
		CommonFunctionality.wait(2000);
		 WebElement View_Chart=login.driver.findElement(By.xpath("//span[normalize-space()='Add chart']"));
		 new Actions(login.driver).moveToElement(View_Chart).pause(2000).build().perform();
		 login.driver.findElement(By.xpath("//div[contains(@class,'icon--chart-line_large')]")).click();
		
	}

	@SuppressWarnings("deprecation")
	@And("^Click on more actions$")
	public void click_on_more_actions() throws Throwable {
		CommonFunctionality.wait(5000);
		//commented existing code
		WebElement one_series;
		try {
			/*one_series = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[contains(@class,'series-item--country')])[1]", 4);*/
			/*one_series = CommonFunctionality.getElementByXpath(login.driver,
					"//div[@class='series-item--country country-information']", 4);*/
			one_series = CommonFunctionality.getElementByXpath(login.driver,
					"//div[@class='series-item--main-info']", 4);
			new Actions(login.driver).moveToElement(one_series).pause(3000).build().perform();	
			
			
			
		} catch (Exception e) {
			one_series = CommonFunctionality.getElementByProperty(login.driver, "Series_item_information_hover", 8);
		}
		//new Actions(login.driver).moveToElement(one_series).pause(6000).click().build().perform();
		//CommonFunctionality.action.moveToElement(one_series).pause(10000).build().perform();
		/*CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'search-series-list')]/*[1]//*[@title='More actions']", 4).click();*/
		
	//	WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("More_actions")));
		WebElement ele1 =login.driver.findElement(By.xpath("//span[@title='More actions']"));
		CommonFunctionality.action.moveToElement(ele1).click().build().perform();
		CommonFunctionality.wait(2000);
		 WebElement View_Chart=login.driver.findElement(By.xpath("//span[normalize-space()='Add chart']"));
		 new Actions(login.driver).moveToElement(View_Chart).pause(2000).build().perform();
		 login.driver.findElement(By.xpath("//div[contains(@class,'icon--chart-line_large')]")).click();
		
		try {
			WebElement apply=	login.driver.findElement(By.xpath("//button[normalize-space(text())='Apply'] "));
			apply.click();
		}
		catch(Exception e) {
			System.out.println("pop up not appeared");
		}
		
		
	}
		@And("^Click on more actions dropdown$")
	public void click_on_more_actions_dropdown() throws Throwable {
		//actual code is checkboxes.size() changed to index 4
		CommonFunctionality.wait(2000);
		List<WebElement> checkboxes = login.driver
				.findElements(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']"));
		
		for(int i=1;i<=1;i++) {
			CommonFunctionality.wait(3000);
			//checkboxes.get(i).click();
			login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])["+ i +"]")).click();
			CommonFunctionality.wait(2000);
		}
		WebElement FirstSeries=login.driver.findElement(By.xpath("(//div[@class='series-list-item-data'])[1]"));
		new Actions(login.driver).moveToElement(FirstSeries).pause(1000).build().perform();
		/*WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("More_actions")));
		CommonFunctionality.action.moveToElement(ele1).pause(2).click().build().perform();*/
		CommonFunctionality.wait(2000);
		WebElement ele=login.driver.findElement(By.xpath("//span[@title='More actions']"));
		js.executeScript("arguments[0].click();", ele);
		
		
	    
	}
	
		@And("^create a chart$")
		public void create_a_chart() throws Throwable {
			 WebElement View_Chart=login.driver.findElement(By.xpath("//span[normalize-space()='Add chart']"));
			 new Actions(login.driver).moveToElement(View_Chart).pause(2000).build().perform();
			 login.driver.findElement(By.xpath("//div[contains(@class,'icon--chart-line_large')]")).click();
			 try {
					WebElement apply=	login.driver.findElement(By.xpath("//*[contains(text(),'Apply')]"));
					apply.click();
				}
				catch(Exception e) {
					System.out.println("pop up not appeared");
				}
			 
		}


	
	
	

	@SuppressWarnings("deprecation")
		@And("^Click on more actions to create \"([^\"]*)\"$")
	public void click_on_more_actions_to_create(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		//original code commented actually checkboxes.size is there
		List<WebElement> checkboxes = login.driver
				.findElements(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']"));
		
		for(int i=1;i<=2;i++) {
			CommonFunctionality.wait(3000);
			//checkboxes.get(i).click();
			login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])["+i+"]")).click();
			CommonFunctionality.wait(2000);
		}
		
		
		WebElement FirstSeries=login.driver.findElement(By.xpath("(//div[@class='series-item--main-info'])[1]/following::span[@title='More actions'][2]"));
		
		new Actions(login.driver).moveToElement(FirstSeries).pause(3000).build().perform();
		
		
		WebElement Nore_actions=login.driver.findElement(By.xpath("//span[@title='More actions']"));
		js.executeScript("arguments[0].click();", Nore_actions);
		 WebElement View_Chart=login.driver.findElement(By.xpath("//span[normalize-space()='Add chart']"));
		 new Actions(login.driver).moveToElement(View_Chart).pause(2000).build().perform();
		 login.driver.findElement(By.xpath("//div[contains(@class,'icon--chart-line_large')]")).click();
		
		
		 
	   
		
		/*CommonFunctionality.wait(500);
		WebElement visual = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='search-series-list']/*[1]/div/a/div[3]/div[2]/span[contains(@title,'View as " + arg1
						+ "')] | //span[contains(text(),'" + arg1 + "')]",
				4);
		new Actions(login.driver).moveToElement(visual).pause(5000).click().build().perform();*/
		
		
		if (arg1.equalsIgnoreCase("View as Map")) {
			new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='dropdown-menu']//*[text()='World']", 4)).pause(500).click().build().perform();
		}
	}
	
	@And("^create a chart for the above series\\.$")
	public void create_a_chart_for_the_above_series() throws Throwable {
      WebElement FirstSeries=login.driver.findElement(By.xpath("(//div[@class='series-item--main-info'])[1]/following::span[@title='More actions']"));
	  new Actions(login.driver).moveToElement(FirstSeries).pause(3000).build().perform();
		
		
		WebElement Nore_actions=login.driver.findElement(By.xpath("//span[@title='More actions']"));
		js.executeScript("arguments[0].click();", Nore_actions);
		 WebElement View_Chart=login.driver.findElement(By.xpath("//span[normalize-space()='Add chart']"));
		 new Actions(login.driver).moveToElement(View_Chart).pause(2000).build().perform();
		 login.driver.findElement(By.xpath("//div[contains(@class,'icon--chart-line_large')]")).click();
		
		
	    
	}

	
	
	
	@And("^Add few series to myseries tab$")
	public void add_few_series_to_myseries_tab() throws Throwable {
		CommonFunctionality.wait(2000);
		
		for(int i=1;i<=2;i++) {
			CommonFunctionality.wait(3000);
			login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])["+ i +"]")).click();
			
			
		}
	}
	
	
	
	@And("^Click on more actions and create \"([^\"]*)\"$")
	public void click_on_more_actions_and_create(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		//original code commented actually checkboxes.size is there
		List<WebElement> checkboxes = login.driver
				.findElements(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']"));
		
		for(int i=1;i<=2;i++) {
			Thread.sleep(3000);
			login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])["+ i +"]")).click();
			//checkboxes.get(i).click();
			CommonFunctionality.wait(3000);
		}
		
		
		
		WebElement FirstSeries=login.driver.findElement(By.xpath("(//div[@class='series-list-item-data'])[1]"));
		new Actions(login.driver).moveToElement(FirstSeries).pause(1000).build().perform();
	WebElement More_actions=	login.driver.findElement(By.xpath("//span[@title='More actions']"));
	js.executeScript("arguments[0].click();", More_actions);

		
	 WebElement View_Chart=login.driver.findElement(By.xpath("//span[normalize-space()='Add chart']"));
	 new Actions(login.driver).moveToElement(View_Chart).pause(2000).build().perform();
	 login.driver.findElement(By.xpath("//div[contains(@class,'icon--table-vertical_large')]")).click();
	
		
		/*CommonFunctionality.wait(500);
		WebElement visual = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='search-series-list']/*[1]/div/a/div[3]/div[2]/span[contains(@title,'View as " + arg1
						+ "')] | //span[contains(text(),'" + arg1 + "')]",
				4);
		new Actions(login.driver).moveToElement(visual).pause(5000).click().build().perform();*/
		
		
		if (arg1.equalsIgnoreCase("View as Map")) {
			new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='dropdown-menu']//*[text()='World']", 4)).pause(500).click().build().perform();
		}

		
		
	   
	}

	
	@And("^Create a Map\\.$")
	public void create_a_Map() throws Throwable {
		CommonFunctionality.wait(2000);
		//original code commented actually checkboxes.size is there
		List<WebElement> checkboxes = login.driver
				.findElements(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']"));
		
		for(int i=1;i<=2;i++) {
			CommonFunctionality.wait(3000);
			//checkboxes.get(i).click();
			login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])["+ i +"]")).click();
			
			
		}
		
		
		
		WebElement FirstSeries=login.driver.findElement(By.xpath("(//div[@class='series-list-item-data'])[1]"));
		new Actions(login.driver).moveToElement(FirstSeries).pause(1000).build().perform();
	WebElement More_actions=	login.driver.findElement(By.xpath("//span[@title='More actions']"));
	js.executeScript("arguments[0].click();", More_actions);

		
	 WebElement View_Chart=login.driver.findElement(By.xpath("//span[normalize-space()='Add chart']"));
	 new Actions(login.driver).moveToElement(View_Chart).pause(2000).build().perform();
	 login.driver.findElement(By.xpath("//div[contains(@class,'icon--map-filled_large')]")).click();
	 
		

	    
	}

	
	
	
	
	
	
	
	
	
	
		@And("^Click on more actions to create(\\d+) \"([^\"]*)\"$")
	public void click_on_more_actions_to_create(int arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(2000);
		//original code commented actually checkboxes.size is there
		/*List<WebElement> checkboxes = login.driver
				.findElements(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']"));
		
		for(int i=0;i<checkboxes.size();i++) {
			CommonFunctionality.wait(2000);
			checkboxes.get(i).click();
			CommonFunctionality.wait(2000);
		}*/
		
		
     WebElement FirstSeries=login.driver.findElement(By.xpath("(//*[@class='release-schedule--tree']//*[@class='series-item--main-info'])[1]/following::span[@title='More actions'][2]"));
		
		new Actions(login.driver).moveToElement(FirstSeries).pause(3000).build().perform();
		
		
		WebElement Nore_actions=login.driver.findElement(By.xpath("//span[@title='More actions']"));
		js.executeScript("arguments[0].click();", Nore_actions);
		
		
		
		
		/*WebElement FirstSeries=login.driver.findElement(By.xpath("(//div[@class='series-item--main-info'])[1]"));
		new Actions(login.driver).moveToElement(FirstSeries).pause(1000).build().perform();
		login.driver.findElement(By.xpath("//span[@title='More actions']")).click();*/
		
		WebElement View_Chart=login.driver.findElement(By.xpath("//span[normalize-space()='Add chart']"));
		 new Actions(login.driver).moveToElement(View_Chart).pause(2000).build().perform();
		 login.driver.findElement(By.xpath("//div[contains(@class,'icon--chart-line_large')]")).click();
		 try {
				WebElement apply=	login.driver.findElement(By.xpath("//*[contains(text(),'Apply')]"));
				apply.click();
			}
			catch(Exception e) {
				System.out.println("pop up not appeared");
			} 
	   
		
		//CommonFunctionality.wait(500);
		/*WebElement visual = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='search-series-list']/*[1]/div/a/div[3]/div[2]/span[contains(@title,'View as " + arg2
						+ "')] | //span[contains(text(),'" + arg2 + "')]",
				4);
		new Actions(login.driver).moveToElement(visual).pause(5000).click().build().perform();*/
		
		
		
		
		
		
		
		
	    
	}
	
		
	
	
	
	
	
	
	
	
	@And("^Click on more actions=>\"([^\"]*)\"$")
	public void click_on_more_actions(String arg1) throws Throwable {
		WebElement FirstSeries=login.driver.findElement(By.xpath("(//div[@class='series-item--main-info'])[1]"));
		new Actions(login.driver).moveToElement(FirstSeries).pause(1000).build().perform();
		login.driver.findElement(By.xpath("//span[@title='More actions']")).click();
		WebElement View_Chart=login.driver.findElement(By.xpath("//span[normalize-space()='Add chart']"));
		 new Actions(login.driver).moveToElement(View_Chart).pause(2000).build().perform();
		 login.driver.findElement(By.xpath("//div[contains(@class,'icon--table-vertical_large')]")).click();
		 try {
				WebElement apply=	login.driver.findElement(By.xpath("//*[contains(text(),'Apply')]"));
				apply.click();
			}
			catch(Exception e) {
				System.out.println("pop up not appeared");
			}
			
		 
	   
		
		/*CommonFunctionality.wait(500);
		WebElement visual = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='search-series-list']/*[1]/div/a/div[3]/div[2]/span[contains(@title,'View as " + arg1
						+ "')] | //span[contains(text(),'" + arg1 + "')]",
				4);
		new Actions(login.driver).moveToElement(visual).pause(5000).click().build().perform();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//button[normalize-space(text())='Apply']")).click();*/
		if (arg1.equalsIgnoreCase("View as Map")) {
			new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='dropdown-menu']//*[text()='World']", 4)).pause(500).click().build().perform();
		}
	    
	}


	
	
	@And("^Click on more actions to create=>View as chart\\.$")
	public void click_on_more_actions_to_create_View_as_chart() throws Throwable {
		
		CommonFunctionality.wait(2000);
		WebElement Serieslist = login.driver.findElement(
				By.xpath("//div[@class='series-list-item-data']/div[@class='series-list-item--information'][1]"));
		new Actions(login.driver).moveToElement(Serieslist).pause(3000).build().perform();
	    WebElement ele1 = login.driver.findElement(By.xpath("//div[@class='series-list-item--action-icons']/span[@title='More actions']//*[name()='svg']//*[local-name()='use'][1]"));
		CommonFunctionality.action.moveToElement(ele1).pause(2000).click().build().perform();
	    //js. executeScript("arguments[0]. click();", ele1);
		CommonFunctionality.wait(2000);
		 WebElement View_Chart=login.driver.findElement(By.xpath("//span[normalize-space()='Add chart']"));
		 new Actions(login.driver).moveToElement(View_Chart).pause(2000).build().perform();
		 login.driver.findElement(By.xpath("//div[contains(@class,'icon--chart-line_large')]")).click();
		try {
			WebElement apply=	login.driver.findElement(By.xpath("//*[contains(text(),'Apply')]"));
			apply.click();
		}
		catch(Exception e) {
			System.out.println("pop up not appeared");
		}
		
		
		
	}

	@And("^Clicking on \"([^\"]*)\" button in SSP$")
	public void clicking_on_button_in_SSP(String arg1) throws Throwable {
		if (login.driver
				.findElements(By.xpath("//*[contains(@class,'single-series-preview-operations--manage-replacements')]"))
				.size() > 0) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'single-series-preview-operations--manage-replacements')]", 4).click();
		}
	}

	@And("^Closing the replacement button$")
	public void clicking_on_replacement_button() throws Throwable {
		CommonFunctionality.wait(2000);
		List<WebElement> close = login.driver.findElements(By.className("movable-modal--close"));
		for (WebElement single_close : close) {
			CommonFunctionality.wait(3000);
			single_close.click();
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Create new and Save the Insight$")
	public void save_the_Insight() throws Throwable {
		WebElement title = CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Open File menu']", 4);
		new Actions(login.driver).moveToElement(title).pause(1000).click().build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='items-wrapper']//*[text()='New']", 4).click();
		New_Insight_Name = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='form--control']", 4)
				.getAttribute("value");
		CommonFunctionality.wait(500);
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='sphere-modal-controls']//*[text()='Create insight']", 4)
				.click();
		CommonFunctionality.wait(5000);
	}

	@SuppressWarnings("deprecation")
	@And("^Click Refresh button in settings changed$")
	public void click_Refresh_button_in_settings_changed() throws Throwable {
		CommonFunctionality.wait(4000);
		if (login.driver.findElements(By.cssSelector(".growl-message.growl-warning")).size() > 0) {
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[text()='Refresh']", 4))
					.pause(500).click().build().perform();
		}
		check_for_keeping_insight_popup();
	}

	
	@And("^create a Histogram\\.$")
	public void create_a_Histogram() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement Add_chart=login.driver.findElement(By.xpath("//span[normalize-space(text())='Add chart']"));
		new Actions(login.driver).moveToElement(Add_chart).pause(1000).build().perform();
		login.driver.findElement(By.xpath("//div[contains(@class,'icon--histogram_large')]")).click();
		
		
	}
	
	
	@And("^Choose \"([^\"]*)\" > \"([^\"]*)\"$")
	public void choose(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(500);
		WebElement view = login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]"));
		new Actions(login.driver).moveToElement(view).build().perform();
		CommonFunctionality.webDriverwait_locator("//span[contains(text(),'" + arg2 + "')]", "xpath");
		login.driver.findElement(By.xpath("//span[contains(text(),'" + arg2 + "')]")).click();
		if (arg2.equalsIgnoreCase("Pie")) {
			if (login.driver
					.findElements(By.xpath("//*[contains(@class,'sphere-modal__content')]//*[text()='Confirmation']"))
					.size() > 0) {
				CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 4).click();
			}
		}
		
		
		if (arg2.equalsIgnoreCase("Histogram")) {
			if (login.driver
					.findElements(By.xpath("//*[contains(@class,'sphere-modal__content')]//*[text()='Confirmation']"))
					.size() > 0) {
				CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 4).click();
			}
		}
		if (arg2.equalsIgnoreCase("Heat map")) {
			if (login.driver
					.findElements(By.xpath(
							"//*[contains(@class,'movable-modal--window')]//*[@class='button button__text_purple']"))
					.size() > 0) {
				CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			}
		}
	}

	@SuppressWarnings("deprecation")


	public void open_a_visual(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		WebElement visual = CommonFunctionality
				.getElementByXpath(login.driver,
						"//ul[@class='dropdown-menu context-menu ']//span[contains(@title,'View as " + arg1
								+ "')] | //ul[@class='dropdown-menu context-menu ']//span[contains(@title,'Chart')]",
						4);
		new Actions(login.driver).moveToElement(visual).pause(1000).click().build().perform();
		CommonFunctionality.wait(1000);
	}

	@And("^Click on Edit series visual$")
	public void click_on_Edit_series_visual() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'left-controls')]//button[text()='Edit Series']", 4).click();
		CommonFunctionality.wait(500);
	}

	@And("^Click on \"([^\"]*)\" visual$")
	public void click_on_visual(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		if (arg1.equalsIgnoreCase("Add related series") || arg1.equalsIgnoreCase("Edit Series")) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'left-controls')]//button[text()='" + arg1 + "']", 4).click();
			CommonFunctionality.wait(500);
		}
		if (arg1.equalsIgnoreCase("Save period")) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'visual-save-zoom') and text()='" + arg1 + "']", 4).click();
		} else {
			try {
				CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 4).click();
			} catch (Exception e) {
				//
			}
			CommonFunctionality.wait(1000);
			WebElement chart = CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(@class,'left-controls')]//button[text()='" + arg1
									+ "'] | //*[contains(@class,'left-controls')]//button[text()='" + arg1 + " Chart'] | //*[contains(@class,'left-controls')]//button[text()='" + arg1 + " Pie']",
							4);
			new Actions(login.driver).moveToElement(chart).click().build().perform();
			CommonFunctionality.wait(1000);
		}
	}

	@And("^create HeatMap\\.$")
	public void create_HeatMap() throws Throwable {
		CommonFunctionality.wait(2000);
		//original code commented actually checkboxes.size is there
		List<WebElement> checkboxes = login.driver
				.findElements(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']"));
		
		for(int i=0;i<=2;i++) {
			Thread.sleep(6000);
			checkboxes.get(i).click();
			CommonFunctionality.wait(3000);
		}
		
		
		
		WebElement FirstSeries=login.driver.findElement(By.xpath("(//div[@class='series-list-item-data'])[1]"));
		new Actions(login.driver).moveToElement(FirstSeries).pause(1000).build().perform();
	WebElement More_actions=	login.driver.findElement(By.xpath("//span[@title='More actions']"));
	js.executeScript("arguments[0].click();", More_actions);

		
	 WebElement View_Chart=login.driver.findElement(By.xpath("//span[normalize-space()='Add chart']"));
	 new Actions(login.driver).moveToElement(View_Chart).pause(2000).build().perform();
	 login.driver.findElement(By.xpath("//div[contains(@class,'icon--heatmap_large')]")).click();
	
		

	    
	}
	
	@And("^Create Pie\\.$")
	public void create_Pie() throws Throwable {
		CommonFunctionality.wait(2000);
		//original code commented actually checkboxes.size is there
		List<WebElement> checkboxes = login.driver
				.findElements(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']"));
		
		for(int i=1;i<=2;i++) {
			Thread.sleep(3000);
			//checkboxes.get(i).click();
			login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])["+ i +"]")).click();
			
			CommonFunctionality.wait(3000);
		}
		
		
		
		WebElement FirstSeries=login.driver.findElement(By.xpath("(//div[@class='series-list-item-data'])[1]"));
		new Actions(login.driver).moveToElement(FirstSeries).pause(1000).build().perform();
	WebElement More_actions=	login.driver.findElement(By.xpath("//span[@title='More actions']"));
	js.executeScript("arguments[0].click();", More_actions);

		
	 WebElement View_Chart=login.driver.findElement(By.xpath("//span[normalize-space()='Add chart']"));
	 new Actions(login.driver).moveToElement(View_Chart).pause(2000).build().perform();
	 login.driver.findElement(By.xpath("//div[contains(@class,'icon--pie_chart-pie_large')]")).click();
	 
		

	   
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
		// text1 = arg1;
		text2 = arg2;
		/*
		 * chart_checkbox = login.driver.findElement(By.xpath( "//*[text()='" + text2 +
		 * "' and @class='input-control--description']/preceding::input[1] | //*[text()='"
		 * + text2 +
		 * "' and @class='table-properties-context-title']/preceding::input[1]"))
		 * .isSelected(); if (chart_checkbox == true) { CommonFunctionality
		 * .getElementByXpath(login.driver, "//*[text()='" + text1 +
		 * "' and @class='input-control--description']/preceding::span[1] | //*[text()='"
		 * + text1 +
		 * "' and @class='table-properties-context-title']/preceding::span[1]", 4)
		 * .click(); }
		 */
		CommonFunctionality.wait(500);
		chart_checkbox1 = login.driver.findElement(By.xpath("//*[contains(text(),'" + text2
				+ "') and @class='input-control--description']/preceding::input[1] | //*[contains(text(),'" + text2
				+ "') and @class='table-properties-context-title']/preceding::input[1]")).isSelected();
		if (chart_checkbox1 == true) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(text(),'" + text2
							+ "') and @class='input-control--description']/preceding::span[1] | //*[contains(text(),'"
							+ text2 + "') and @class='table-properties-context-title']/preceding::span[1]",
					4).click();
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

	@SuppressWarnings("deprecation")
	@And("^Create a new template and \"([^\"]*)\"$")
	public void create_a_new_template_and(String arg1) throws Throwable {
		WebElement add_template = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'add-style-template')]", 4);
		if (arg1.equalsIgnoreCase("Template popup")) {
			if (add_template.getAttribute("class").contains("add-style-template__active")) {
				add_template.click();
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='add-template-context--wrapper']//*[contains(@class,'add-template-context--input')]",
						4).sendKeys(send);
				new Actions(login.driver).pause(2000).sendKeys(Keys.ENTER).perform();
				if (login.driver.findElements(By.className("sphere-modal__content")).size() > 0) {
					CommonFunctionality.getElementByXpath(login.driver,
							"//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']", 4).click();
				}
			}
		} else if (arg1.equalsIgnoreCase("Set as default for future Table visual")
				|| arg1.equalsIgnoreCase("Set as default for future Chart visual")) {
			if (add_template.getAttribute("class").contains("add-style-template__active")) {
				add_template.click();
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='add-template-context--wrapper']//*[contains(@class,'add-template-context--input')]",
						4).sendKeys(send);
				new Actions(login.driver).pause(2000).sendKeys(Keys.ENTER).perform();
				if (login.driver.findElements(By.className("sphere-modal__content")).size() > 0) {
					CommonFunctionality.getElementByXpath(login.driver,
							"//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']", 4).click();
				}
			}
			List<WebElement> titles = login.driver.findElements(By.className("style-templates-item--icon"));
			for (WebElement title : titles) {
				String name = title.getAttribute("title");
				if (name.equalsIgnoreCase(send)) {
					WebElement active = CommonFunctionality.getElementByClassName(login.driver,
							"style-templates-item--icon", 4);
					new Actions(login.driver).moveToElement(active).pause(2000).build().perform();
					CommonFunctionality.getElementByClassName(login.driver, "style-templates-item--tongue", 4).click();
					WebElement set = CommonFunctionality.getElementByXpath(login.driver,
							"//*[contains(text(),'" + arg1 + "')]/preceding-sibling::span", 4);
					boolean select = CommonFunctionality.getElementByXpath(login.driver,
							"//*[contains(text(),'" + arg1 + "')]/preceding-sibling::span", 4).isSelected();
					if (select != true) {
						new Actions(login.driver).moveToElement(set).pause(2000).click().build().perform();
					} else {
						System.out.println("The checkbox is checked already");
					}
					break;
				}
			}
		} else {
			fail("Verification Failed");
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
		CommonFunctionality.Views_list();
	}

	@SuppressWarnings("deprecation")
	@And("^Clicking on the hiding template from the style template dropdown$")
	public void clicking_on_the_hiding_template_from_the_style_template_dropdown() throws Throwable {
		WebElement dropdown = CommonFunctionality.getElementByProperty(login.driver, "Style_template_arrow_icon", 4);
		new Actions(login.driver).moveToElement(dropdown).pause(1000).click().build().perform();
		CommonFunctionality.wait(2000);
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
						"//*[contains(@title,'" + arg1 + "')]"))
				.isSelected();
		if (checkbox == false) {
			login.driver
					.findElement(By.xpath(
							"//*[contains(@title,'" + arg1 + "')]"))
					.click();
		} 
		WebElement advanced = null;
		if (arg4.equalsIgnoreCase("Specific")) {
			advanced = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[contains(@title,'" + arg1 + "')]//following::*[contains(@title,'" + arg2 + "')][1])[1]", 4);
		} else {
			advanced = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[contains(@title,'" + arg1 + "')]//following::*[contains(@title,'" + arg2 + "')][1])", 4);
		}
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
		CommonFunctionality.wait(200);
		WebElement radio = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'--context-menu')]//*[contains(text(),'" + arg4
						+ "')]//preceding-sibling::*[@class='input-control--indicator'] | //*[contains(text(),'" + arg4
						+ "')]//preceding-sibling::*[@class='input-control--indicator']",
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
		}
		CommonFunctionality.wait(500);
		if (arg2.equals("Rows")) {
			zebra_text = CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(text(),'" + arg1 + "')]//following::*[contains(@class,'title--text')][1]", 4)
					.getText();
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Clicking \"([^\"]*)\" option$")
	public void clicking_option(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		if (arg1.equalsIgnoreCase("All functions")) {
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//*[@class='popular-functions-context']//span[contains(text(),'" + arg1 + "')]", 4))
					.pause(500).click().build().perform();
		} else {
			WebElement enable = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'sphere-modal__body')]//*[contains(text(),'" + arg1
							+ "')] | //*[contains(@class,'movable-modal--body')]//*[contains(text(),'" + arg1 + "')]",
					4);
			js.executeScript("arguments[0].click();", enable);
			CommonFunctionality.wait(6000);
		}
	}

	@And("^Perform \"([^\"]*)\" operation$")
	public void perform_operation(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'download-button') and contains(@title,'" + arg1 + "')]", 4).click();
	}

	@And("^Click \"([^\"]*)\" button$")
	public void click_button(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		if (arg1.equalsIgnoreCase("All functions")) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 4).click();
		} else {
			CommonFunctionality.Hidden_Webelements(login.driver, "//button[contains(text(),'" + arg1 + "')]");
		}
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
		/*CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='annotations-menu']//*[contains(@class,'" + arg1 + "')]", 4).click();*/
		login.driver.findElement(By.xpath("//div[text()='Annotations']/following::div[@class='annotations-context-menu--arrow']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//span[text()='Horizontal']")).click();
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
	//	WebElement hover = CommonFunctionality.getElementByClassName(login.driver, "annotation-cursor--layout", 4);
		CommonFunctionality.wait(2000);
		WebElement hover = login.driver.findElement(By.xpath("//div[@class='annotation-cursor--layout']"));
		new Actions(login.driver).moveToElement(hover).pause(5000).build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Hover the \"([^\"]*)\"$")
	public void hover_the(String arg1) throws Throwable {
		WebElement title = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'" + arg1 + "')]",
				4);
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
		sa.assertEquals(arg1, update);
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
		CommonFunctionality.wait(5000);
		halfscreen = CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg1 + "']", 4);
		if (halfscreen.isDisplayed()) {
			new Actions(login.driver).moveToElement(halfscreen).build().perform();
			halfscreen.click();
		}
		CommonFunctionality.wait(2000);
		fullscreen = CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg2 + "']", 4);
		if (fullscreen.isDisplayed()) {
			CommonFunctionality.wait(4000);
			new Actions(login.driver).moveToElement(fullscreen).build().perform();
			fullscreen.click();
		}
	}

	@And("^Click on \"([^\"]*)\" icon from SSP window$")
	public void click_on_icon_from_SSP_window(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 4).click();
		CommonFunctionality.wait(3000);
	}

	@And("^Get date from chart$")
	public void get_date_from_chart() throws Throwable {
		CommonFunctionality.wait(500);
		chart_from_date = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[2]", 4)
				.getText();
		CommonFunctionality.wait(500);
		chart_to_date = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[1]", 4)
				.getText();
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

	@SuppressWarnings("deprecation")
	@And("^Select type as Column chart$")
	public void select_type_as_Column_chart() throws Throwable {
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[@class='type-select']/*[2]", 4))
				.pause(500).click().build().perform();
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
				"div[class='items-wrapper'] span[title='Column']", 4)).pause(500).build().perform();
		CommonFunctionality
				.getElementByXpath(login.driver, "(//div[@class='items-wrapper']//span[@title='Column'])[2]", 4)
				.click();
	}

	@And("^Check \"([^\"]*)\" option$")
	public void check_option(String arg1) throws Throwable {
		chart_option = arg1;
		if (arg1.equals("Move to right")) {
			/*axis = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'table--column__auto-width')]/following::*[contains(@title,'" + arg1 + "')]",
					4);*/
			CommonFunctionality.wait(2000);
			axis=login.driver.findElement(By.xpath("(//div[@title='Move to right'])[4]"));
			CommonFunctionality.wait(2000);
			axis.click();
		} else if (arg1.equals("Move to left")) {
			/*axis = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'table--column__auto-width')]/following::*[contains(@title,'" + arg1 + "')]",
					4);*/
			CommonFunctionality.wait(2000);
			axis=login.driver.findElement(By.xpath("(//div[@title='Move to left'])[4]"));
			axis.click();
			
		} else {
			stroke = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'insight-action-panel--btn') and contains(@title,'chart " + arg1 + "')]", 4);
		}
	}

	
	
	@And("^Check \"([^\"]*)\" axis option$")
	public void check_axis_option(String arg1) throws Throwable {
		chart_option = arg1;
		if (arg1.equals("Move to right")) {
			/*axis = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'table--column__auto-width')]/following::*[contains(@title,'" + arg1 + "')]",
					4);*/
			CommonFunctionality.wait(2000);
			axis=login.driver.findElement(By.xpath("(//div[@title='Move to right'])[1]"));
			CommonFunctionality.wait(2000);
			axis.click();
		} else if (arg1.equals("Move to left")) {
			/*axis = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'table--column__auto-width')]/following::*[contains(@title,'" + arg1 + "')]",
					4);*/
			CommonFunctionality.wait(2000);
			axis=login.driver.findElement(By.xpath("(//div[@title='Move to left'])[1]"));
			axis.click();
			
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
				.findElements(By.xpath("//ul[contains(@class,'search-series-list')]/li[(contains(@data-id,'0_'))]"));
		WebElement list = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'insight-page-view-tab--link') and contains(text(),'My Series')][1]", 4);
		for (int i = 1; i <= li.size() + li_empty.size(); i++) {
			WebElement series;
			try {
				series = CommonFunctionality.getElementByXpath(login.driver,
						"//ul[contains(@class,'search-series-list')]/li[" + i
								+ "]//*[contains(@class,'series-item--name')]",
						4);
				new Actions(login.driver).moveToElement(series).pause(1000).build().perform();
			} catch (Exception e) {
				series = CommonFunctionality.getElementByXpath(login.driver,
						"//ul[contains(@class,'search-series-list')]/li[(contains(@data-id,'0_'))][" + i
								+ "] | //ul[contains(@class,'search-series-list')]/li[(contains(@data-id,'0_'))]",
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
				"//*[contains(text(),'" + arg1 + "')]/preceding::div[@class='toggle'][1]", 4);
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
		List<WebElement> li2_empty = login.driver.findElements(
				By.xpath("(//ul[contains(@class,'search-series-list')])[2]/li[(contains(@data-id,'0_'))]"));
		WebElement list = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'insight-page-view-tab--link') and contains(text(),'My Series')][1]", 4);
		for (int i = 1; i <= li.size() + li2_empty.size(); i++) {
			WebElement series;
			try {
				series = CommonFunctionality.getElementByXpath(login.driver,
						"(//ul[contains(@class,'search-series-list')])[2]/li[" + i
								+ "]//*[contains(@class,'series-item--name')]",
						4);
				new Actions(login.driver).moveToElement(series).pause(1000).build().perform();
			} catch (Exception e) {
				series = CommonFunctionality.getElementByXpath(login.driver,
						"(//ul[contains(@class,'search-series-list')])[2]/li[(contains(@data-id,'0_'))]", 4);
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
		List<WebElement> li3_empty = login.driver.findElements(
				By.xpath("(//ul[contains(@class,'search-series-list')])[2]/li[(contains(@data-id,'0_'))]"));
		WebElement list = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'insight-page-view-tab--link') and contains(text(),'My Series')][1]", 4);
		for (int i = 1; i <= li.size() + li3_empty.size(); i++) {
			WebElement series;
			try {
				series = CommonFunctionality.getElementByXpath(login.driver,
						"(//ul[contains(@class,'search-series-list')])[3]/li[" + i
								+ "]//*[contains(@class,'series-item--name')]",
						4);
				new Actions(login.driver).moveToElement(series).pause(1000).build().perform();
			} catch (Exception e) {
				series = CommonFunctionality.getElementByXpath(login.driver,
						"(//ul[contains(@class,'search-series-list')])[3]/li[(contains(@data-id,'0_'))]", 4);
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

	@SuppressWarnings("deprecation")
	@And("^Set the range as \"([^\"]*)\" to \"([^\"]*)\"$")
	public void set_the_range_as_to(String arg1, String arg2) throws Throwable {
		start_date_chart = arg1;
		end_date_chart = arg2;
		CommonFunctionality.wait(4000);
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//div[contains(@class,'header-picker_header-module__calendar_icon')]", 4))
				.pause(500).click().build().perform();
		WebElement start = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'picker-body-period_picker-module__input') and @placeholder='From']", 4);
		new Actions(login.driver).moveToElement(start).click().pause(500)
				.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)).build().perform();
		new Actions(login.driver).sendKeys(start_date_chart).pause(1000).sendKeys(Keys.ENTER).build().perform();
		WebElement end = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'picker-body-period_picker-module__input') and @placeholder='To']", 4);
		new Actions(login.driver).moveToElement(end).click().pause(500)
				.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)).build().perform();
		new Actions(login.driver).sendKeys(end_date_chart).pause(1000).sendKeys(Keys.ENTER).build().perform();
	}

	@And("^Check Time axis> Time within period$")
	public void check_time_axis_time_within_period() throws Throwable {
		CommonFunctionality.wait(2000);
		start_date_inside_chart = CommonFunctionality.getElementByXpath(login.driver,
				"(//*[@class='highcharts-axis-labels highcharts-xaxis-labels'])[2]/*[1]", 4).getText();
		CommonFunctionality.wait(2000);
		end_date_inside_chart = CommonFunctionality.getElementByXpath(login.driver,
				"(//*[@class='highcharts-axis-labels highcharts-xaxis-labels'])[2]/*[5]", 4).getText();
	}

	@SuppressWarnings("deprecation")
	@And("^Select (\\d+) series from drilldown series list$")
	public void select_series_from_drilldown_series_list(int arg1) throws Throwable {
		List<WebElement> drill_list = login.driver.findElements(By.className("legend-drilldown"));
		WebElement drill_listing = login.driver.findElement(By.className("legend-drilldown"));
		if (arg1 != drill_list.size()) {
			for (WebElement drill : drill_list) {
				drill_text = CommonFunctionality
						.getElementByXpath(login.driver, "(//*[contains(@class,'series-edit--title')])[1]", 8)
						.getText();
				CommonFunctionality.wait(5000);
				new Actions(login.driver).moveToElement(drill).pause(3000).click().build().perform();
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
		CommonFunctionality.getElementBycssSelector(login.driver, "div[data-tab='series']", 4).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']", 4).click();
		CrossSection.Select_the_Start_Date_and_End_Date(arg2, arg3);
		// CommonFunctionality.getElementByXpath(login.driver,
		// "//*[contains(@class,'sphere-modal-controls--right')]//*[contains(text(),'Download')]",
		// 4).click();
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
		login.driver.findElement(By.xpath("//div[@class='tree-node']//span[contains(text(),'CEIC Leading Indicator')]")).click();
		footnotes_text = login.driver.findElement(By.xpath("//div[@class='footnotes--info']")).getText();
		System.out.println("=footnote===="+footnotes_text);
		/*CommonFunctionality.wait(100);
		WebElement open = CommonFunctionality.getElementByXpath(login.driver, "//div[@data-node-model-id='TP2958827']",
				4);
		if (open.getAttribute("class").contains("open")) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[@data-node-model-id='SC2966087']//div[1]", 4)
					.click();*/
		}
		/*CommonFunctionality.wait(100);
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg4 + "')]", 8).click();
		if (arg2.equals("CEIC Leading Indicator")) {
			CommonFunctionality.wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.className("footnotes--info")));
			footnotes_text = CommonFunctionality.getElementByClassName(login.driver, "footnotes--info", 4).getText();
			System.out.println("=footnote===="+footnotes_text);
		}
*/	
		

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
		CommonFunctionality.wait(3000);
		WebElement hovor_series = CommonFunctionality.getElementByProperty(login.driver, "One_series_from_seriesList",
				8);
		new Actions(login.driver).moveToElement(hovor_series).pause(4000).build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Hovor first series from db list$")
	public void hovor_first_series_from_db_list() throws Throwable {
		CommonFunctionality.wait(5000);
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='Databases']", 4).click();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).clear();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys("205424302");
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		CommonFunctionality.wait(10000);
		if (login.driver.findElements(By.xpath("//span[text()='Matches only']")).size() > 0) {
			CommonFunctionality.getElementByXpath(login.driver, "//span[text()='Matches only']", 4).click();
		}
		WebElement hovor_series = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='series-item--name'])[1]", 8);
		new Actions(login.driver).moveToElement(hovor_series).pause(1000).build().perform();
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
		CommonFunctionality.wait(2000);
	}

	@And("^Right click on any series level of data from series$")
	public void right_click_on_any_series_level_of_data_from_series() throws Throwable {
		CommonFunctionality.webDriverwait_keyvalue("Series_new");
		CommonFunctionality.getElementByProperty(login.driver, "Series_new", 4).click();
		// WebElement ul_element =
		// login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		List<WebElement> li_All = login.driver
				.findElements(By.xpath("//*[@class='search-series-list']/*//*[@class='series-item--name']"));
		for (int i = 0; i < li_All.size(); i++) {
			m = i + 1;
			checkbox = login.driver.findElement(By.xpath(
					"//*[@class='search-series-list']/*[" + m + "]//div[@class='series-list-item--checkbox-wrapper']"));
			checkbox.click();
			ele = login.driver.findElement(
					By.xpath("//*[@class='search-series-list']/*[" + m + "]//div[@class='series-item--name']"));
			if (i == 4) {
				break;
			}
		}
	}

	@And("^Go to \"([^\"]*)\" > \"([^\"]*)\" > \"([^\"]*)\" > \"([^\"]*)\" > \"([^\"]*)\"$")
	public void go_to(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
		CommonFunctionality.UnselectMethod();
		CommonFunctionality.CollapseTreeMethod();
		CommonFunctionality.wait(2000);
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]/../../../../child::div[1]", 4)
				.click();
		CommonFunctionality.wait(1000);
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'" + arg2 + "')]/../../../../child::div[1]", 4)
				.click();
		CommonFunctionality.wait(1000);
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'" + arg3 + "')]/../../../../child::div[1]", 4)
				.click();
		CommonFunctionality.wait(1000);
		/*Comparables_text1 = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'" + arg3 + "')]//following::div[contains(@class,'comparable-tree-series-list')]",
				4);*/
		Comparables_text1 = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'" + arg3 + "')]",
				4);
		CommonFunctionality.wait(1000);
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'" + arg4 + "')]/../../../../child::div[1]", 4)
				.click();
		CommonFunctionality.wait(1000);
		/*Comparables_text2 = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'" + arg4 + "')]//following::div[contains(@class,'comparable-tree-series-list')]",
				4);*/
		Comparables_text2 = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'" + arg4 + "')]",
				4);
		CommonFunctionality.wait(1000);
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'" + arg5 + "')]/../../../../child::div[1]", 4)
				.click();
		CommonFunctionality.wait(1000);
		/*Comparables_text3 = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'" + arg5 + "')]//following::div[contains(@class,'comparable-tree-series-list')]",
				4);*/
		Comparables_text3 = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'" + arg5 + "')]",
				4);
	}

	@And("^Expand \"([^\"]*)\" > \"([^\"]*)\" > \"([^\"]*)\" > \"([^\"]*)\" > \"([^\"]*)\"$")
	public void expand(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
		// CommonFunctionality.UnselectMethod();
		// CommonFunctionality.CollapseTreeMethod();
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'" + arg1 + "')]//preceding::div[@class='toggle'][1]", 4).click();
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'" + arg2 + "')]//preceding::div[@class='toggle'][1]", 4).click();
		CommonFunctionality.wait(1000);
		if (arg3.equalsIgnoreCase("Table: Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia")) {
			CommonFunctionality.wait(1000);
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(text(),'" + arg2 + "')]//following::div[@class='toggle'][1]", 4).click();
		} else {
			WebElement table = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(text(),'" + arg3 + "')]/preceding::div[@class='toggle'][1]", 4);
			js.executeScript("arguments[0].scrollIntoView(true);", table);
			js.executeScript("arguments[0].click();", table);
		}
		CommonFunctionality.wait(1000);
		if (arg4.equalsIgnoreCase("Real GDP: YoY: Quarterly: sa: Australia")) {
			CommonFunctionality.wait(1000);
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(text(),'" + arg2 + "')]//following::div[@class='toggle'][1]", 4).click();
		} else {
			WebElement series = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(text(),'" + arg4 + "')]/preceding::div[@class='toggle'][1]", 4);
			//js.executeScript("arguments[0].scrollIntoView(true);", series);
			js.executeScript("arguments[0].click();", series);
		}
		CommonFunctionality.wait(1000);
		if (arg5.equalsIgnoreCase("Table: Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia")) {
			CommonFunctionality.wait(1000);
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(text(),'" + arg2 + "')]//following::div[@class='toggle'][1]", 4).click();
		} else {
			if (login.driver.findElements(By.xpath("//*[contains(text(),'" + arg5 + "')]/preceding::div[@class='toggle'][1]"))
					.size() > 0) {
				login.driver.findElement(By.xpath("//*[contains(text(),'" + arg5 + "')]/preceding::div[@class='toggle'][1]")).click();
			} else {
				login.driver
						.findElement(
								By.xpath("//*[contains(text(),'Afghanistan: National Accounts')]//following::div[3]"))
						.click();
			}
			CommonFunctionality.wait(1000);
		}
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
		CommonFunctionality.wait(3000);
		WebElement ele = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='child-container']/div[2]/div[3]/div[1]/div[3]/div[1]/div[3]/div[1]/div[3]/div[1]/div[2]/a/span/span[1]",
				8);
		new Actions(login.driver).moveToElement(ele).pause(7000).build().perform();
		CommonFunctionality.wait(3000);
	}

	@SuppressWarnings("deprecation")
	@And("^Click on table level$")
	public void click_on_table_level() throws Throwable {
		CommonFunctionality.wait(3000);
		table_text = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'Afghanistan: National Accounts')]//following::*[@class='name-text'][1]", 8)
				.getText();
		System.out.println("==table==="+table_text);
		/*WebElement ele = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='child-container']/div[2]/div[3]/div[1]/div[3]/div[1]/div[3]/div[1]/div[3]/div[1]/div[2]/a/span/span[1]",
				4);*/
		
		WebElement ele=login.driver.findElement(By.xpath("//span[normalize-space(text())='Table AF.IMF.IFS: Gross Domestic Product: by Expenditure: Annual']"));
		new Actions(login.driver).moveToElement(ele).pause(4000).build().perform();
		/*CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='child-container']/div[2]/div[3]/div[1]/div[3]/div[1]/div[3]/div[1]/div[3]/div[1]/div[2]/span[2]/span[1]",
				4).click();*/
		
		CommonFunctionality.getElementByXpath(login.driver,"(//div[@class='add-to-data-selection--icon'])[1]" ,4).click();
		
		
		CommonFunctionality.wait(1000);
		/*comparable_table_title = CommonFunctionality.getElementByClassName(login.driver, "active-comparable--title", 4)
				.getText();*/
		
		comparable_table_title=login.driver.findElement(By.xpath("//span[normalize-space(text())='Table AF.IMF.IFS: Gross Domestic Product: by Expenditure: Annual']")).getText();                     
		System.out.println("====comparable===="+comparable_table_title);
	}

	@SuppressWarnings("deprecation")
	@And("^Click on series level$")
	public void click_on_series_level() throws Throwable {
		CommonFunctionality.wait(3000);
		/*series_text = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'Afghanistan: National Accounts')]//following::div[@class='series-item--name'][1]",
				8).getText();
		*/
		series_text=login.driver.findElement(By.xpath("//*[contains(text(),'Afghanistan: National Accounts')]//following::div[@class='series-item--name'][1]")).getText();
		System.out.println("==series_text====="+series_text);
		
		/*WebElement country = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'series-item--country')]", 4);*/
		Thread.sleep(5000);
		
		//WebDriverWait wait = new WebDriverWait(login.driver, 60);
		//WebElement country=	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//*[contains(@class,'series-item--country')]/following-sibling::div"))));
		//WebElement country=login.driver.findElement(By.xpath("//*[contains(@class,'series-item--country')]/following-sibling::div"));
		WebElement country=login.driver.findElement(By.xpath("//*[@class='name-text']/following::div[@class='series-item--name']"));
		new Actions(login.driver).moveToElement(country).pause(5000).build().perform();
		/*CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='child-container']/div[2]/div[3]/div[1]/div[3]/div[1]/div[3]/div[1]/div[3]/div[1]/div[3]/div/ul/*[1]/div/a/div[3]/div",
				4).click();*/
		
		CommonFunctionality.getElementByXpath(login.driver,"(//div[@class='add-to-data-selection--icon'])[1]" ,4).click();
		CommonFunctionality.wait(1000);
		comparable_series_title = CommonFunctionality.getElementByXpath(login.driver, "//span[normalize-space(text())='Table AF.IMF.IFS: Gross Domestic Product: by Expenditure: Annual']", 8)
				.getText();
	}

	@And("^Check if the result displays only for the selected regions$")
	public void check_if_the_result_displays_only_for_the_selected_regions() throws Throwable {
		CommonFunctionality.wait(1000);
		List<WebElement> region = login.driver.findElements(By.xpath("//*[contains(@class,'country-information')]"));
		for (WebElement reg : region) {
			String text = reg.getText();
			sa.assertEquals(text, values_list);
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Click on \"([^\"]*)\" option in layout$")
	public void click_on_option_in_layout(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']", 4).click();
		CommonFunctionality.wait(2000);
		WebElement grid = CommonFunctionality.getElementByXpath(login.driver, "//*[@title='View as a grid']", 4);
		js.executeScript("arguments[0].click()", grid);
		WebElement title_name = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'bottom-panel-title') and @title='" + New_Insight_Name + "']", 4);
		new Actions(login.driver).moveToElement(title_name).pause(1000).build().perform();
		CommonFunctionality.wait(1000);
		WebElement custom = CommonFunctionality.getElementByXpath(login.driver, "//a[contains(text(),'Customize')]", 4);
		new Actions(login.driver).moveToElement(custom).pause(1000).click().build().perform();
	}

	@And("^Click on expand control$")
	public void click_on_expand_control() throws Throwable {
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='toggle'])[1]", 4).click();
	}

	@And("^Click on select all control$")
	public void click_on_select_all_control() throws Throwable {
		CommonFunctionality.wait(1000);
		/*WebElement check = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='comparables--header']//*[@class='input-control'] | //*[contains(@class,'comparables--header')]//*[@class='input-control--indicator']",
				4);*/
		WebElement check=login.driver.findElement(By.xpath("(//span[@class='input-control--indicator'])[6]"));
		new Actions(login.driver).moveToElement(check).pause(2000).click().build().perform();
	}

	@And("^\"([^\"]*)\" should display result of all region$")
	public void should_display_result_of_all_region(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		List<WebElement> sel_reg = login.driver.findElements(By.xpath("//*[contains(@class,'country-information')]"));
		selected_regions = sel_reg.size();
		if (CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 4)
				.isDisplayed()) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 4).click();
			CommonFunctionality.wait(2000);
			List<WebElement> all_reg = login.driver
					.findElements(By.xpath("//*[contains(@class,'country-information')]"));
			all_regions = all_reg.size();
		}
	}

	@And("^Expand World Trend Plus$")
	public void expand_World_Trend_Plus() throws Throwable {
		CommonFunctionality.CollapseTreeMethod();
		Thread.sleep(5000);
		//login.driver.findElement(By.xpath("//div[@class='tree-container']//div[@data-node-model-id='WORLD']//div[1]")).click();
		login.driver.findElement(By.xpath("//div[@data-node-model-id='WORLD']/div[1]")).click();
		
		
		
		Thread.sleep(2000);
		//login.driver.findElement(By.xpath("//div[@class='tree-container']//div[@data-node-model-id='WORLD']//div[3]//div[1]//div[1]")).click();
		login.driver.findElement(By.xpath("//div[@data-node-model-id='WORLD']/div[1]//following::div[@data-node-model-id='WORLD&&ALL']/div[1]")).click();
		Thread.sleep(2000);
		//login.driver.findElement(By.xpath("//div[@class='database-node tree-node open']//div[@class='child-container']//div[@class='tree-node'][1]//div[1]")).click();
		login.driver.findElement(By.xpath("//div[@class='database-node tree-node open']//div[@class='child-container']//following::div[@class='tree-node']/div")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='database-node tree-node open']//div[@class='child-container']//div[@class='tree-node open']//div[3]//div[1]//div[1] | //*[contains(text(),'National Accounts')]//preceding::div[@class='toggle'][1]")).click();
		Thread.sleep(2000);
		//login.driver.findElement(By.xpath("//div[@class='database-node tree-node open']//div[@class='child-container']//div[@class='tree-node open']//div[3]//div[1]//div[@class='child-container']//div[@class='tree-node'][1]//div[@class='toggle']")).click();
		login.driver.findElement(By.xpath("//div[@class='database-node tree-node open']/following::div[@class='tree-node']/div")).click();
	}

	@And("^Click on \"([^\"]*)\" tab in left panel$")
	public void click_on_tab_in_left_panel(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Databases") || arg1.equalsIgnoreCase("Series")) {
			CommonFunctionality.wait(8000);
			CommonFunctionality.webDriverwait_locator("//*[contains(@class,'series-tab')]//*[contains(text(),'Data')]",
					"xpath");
			CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath",
					"//*[contains(@class,'series-tab')]//*[contains(text(),'Data')]");
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'toggler-control__light_purple')]//*[contains(text(),'" + arg1 + "')]", 4)
					.click();
		} else {
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[@class='series-tab ui-sortable-handle']//*[contains(text(),'" + arg1 + "')]", 4)
					.click();
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Select (\\d+) series and click on chart option$")
	public void select_series_and_click_on_chart_option(int arg1) throws Throwable {
		//CommonFunctionality.getElementBycssSelector(login.driver, "*[title='View results as List']", 4).click();
		CommonFunctionality.wait(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[@value='LIST']")))).click();
		for (int i = 0; i < arg1; i++) {
			//WebElement series_unselected = CommonFunctionality.getElementByXpath(login.driver,"//*[contains(@class,'search-series-list')]/*[" + i + "]", 4);
			//WebElement series = CommonFunctionality.getElementByXpath(login.driver,
				//	"//*[contains(@class,'search-series-list')]/*[" + i + "]/div/a/div[2]", 4);
			
			List<WebElement> series = login.driver.findElements(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']"));
			CommonFunctionality.wait(2000);
			//if (!series_unselected.getAttribute("class").contains("series-list-item__selected")) {
				CommonFunctionality.wait(2000);
				series.get(i).click();
				
			//}
			
		}
		//commented code as functionality changed for View Visuals=eg:chart
		/*WebElement actions = CommonFunctionality.getElementByXpath(login.driver,
				"(//*[contains(@class,'series-item--name')])[" + arg1 + "]", 8);
		new Actions(login.driver).moveToElement(actions).pause(500).build().perform();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"(//*[contains(@class,'view-chart-icon')])[" + arg1 + "]", 8))
				.click().build().perform();*/
		WebElement First_Series = login.driver.findElement(By.xpath("(//div[@class='series-list-item--information'])[1]"));
		new Actions(login.driver).moveToElement(First_Series).pause(2000).build().perform();
		
		
		WebElement More_Actions=login.driver.findElement(By.xpath("//span[@title='More actions']"));
		 js. executeScript("arguments[0]. click();", More_Actions);
		 WebElement View_Chart=login.driver.findElement(By.xpath("//span[normalize-space()='Add chart']"));
		 new Actions(login.driver).moveToElement(View_Chart).pause(2000).build().perform();
		 login.driver.findElement(By.xpath("//div[contains(@class,'icon--chart-line_large')]")).click();
		
		
		
		
	}

	@And("^Right click on any series level of data from DB tab$")
	public void right_click_on_any_series_level_of_data_from_db_tab() throws Throwable {
		CommonFunctionality.UnselectMethod();
		expand_World_Trend_Plus();
		// WebElement ul_element =
		// login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		List<WebElement> li_All = login.driver.findElements(By.xpath("//*[@class='search-series-list']/*"));
		for (int i = 0; i < li_All.size(); i++) {
			m = i + 1;
			checkbox = login.driver.findElement(By.xpath(
					"//*[@class='search-series-list']/*[" + m + "]//div[@class='series-list-item--checkbox-wrapper']"));
			CommonFunctionality.wait(2000);
			checkbox.click();
			CommonFunctionality.wait(2000);
			ele = login.driver.findElement(
					By.xpath("//*[@class='search-series-list']/*[" + m + "]//div[@class='series-item--name']"));
			if (i == 4) {
				break;
			}
		}
	}

	@And("^Click on closing active comparatable icon and \"([^\"]*)\" tab$")
	public void click_on_closing_active_comparatable_icon_and_tab(String arg1) throws Throwable {
		if (login.driver.findElements(By.className("active-comparable--icon")).size() > 0) {
			CommonFunctionality.getElementByClassName(login.driver, "active-comparable--icon", 4).click();
			CommonFunctionality.wait(5000);
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='search-presentation-tabs--visible']//*[contains(text(),'Data')]", 4).click();
			List<WebElement> databases = login.driver.findElements(By.xpath(
					"//*[contains(@class,'toggler-control__sm toggler-control__light_purple')]//*[contains(text(),'"
							+ arg1 + "')]"));
			for (WebElement data : databases) {
				if (!(data.getAttribute("class").contains("hidden"))) {
					data.click();
					break;
				}
			}
			login.driver.navigate().refresh();
		}
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='search-presentation-tabs--visible']//*[contains(text(),'Data')]", 4).click();
		List<WebElement> databases = login.driver.findElements(By
				.xpath("//*[contains(@class,'toggler-control__sm toggler-control__light_purple')]//*[contains(text(),'"
						+ arg1 + "')]"));
		for (WebElement data : databases) {
			if (!(data.getAttribute("class").contains("hidden"))) {
				data.click();
				break;
			}
		}
	}

	@And("^Click on cross icon indicator in comparable tab$")
	public void click_on_cross_icon_indicator_in_comparable_tab() throws Throwable {
		CommonFunctionality.wait(500);
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
				"//*[@class='preview-container']//following::*[contains(@class,'series-edit--title')]", 4);
		js.executeScript("arguments[0].scrollIntoView(true);", legand);
		new Actions(login.driver).moveToElement(legand).pause(500).build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Check the legend icon at visual and edit visual$")
	public void check_the_legend_icon_at_visual_and_edit_visual() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement legand = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='preview-container']//following::*[contains(@class,'series-edit--title')]", 4);
		js.executeScript("arguments[0].scrollIntoView(true);", legand);
		new Actions(login.driver).moveToElement(legand).pause(1000).build().perform();
		WebElement series = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='preview-container']//following::*[@title='Edit series']", 4);
		new Actions(login.driver).moveToElement(series).pause(1000).click().build().perform();
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
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='name-li' and contains(text(),'" + arg1 + "')]", 4)
				.click();
	}

	@And("^Login back to application$")
	public void login_back_to_application() throws Throwable {
		login.driver.get(login.CONFIG.getProperty("testsiteURL"));
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("input_username"))).clear();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("input_username")))
				.sendKeys(login.CONFIG.getProperty("username"));
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("input_password"))).clear();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("input_password"))).sendKeys("Ceic@1234567");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("btnLogin"))).click();
	}

	@And("^Click \"([^\"]*)\" from the drop down$")
	public void click_from_the_drop_down(String arg1) throws Throwable {
		if (arg1.contains("Weekly (Distribute)") || arg1.equalsIgnoreCase("Yearly (Sum)")
				|| arg1.equalsIgnoreCase("Monthly (Distribute)")) {
			frequency_text = CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[@class='context-menu-item link' and contains(@title,'" + arg1 + "')]", 4)
					.getAttribute("title");
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='context-menu-item link' and contains(@title,'" + arg1 + "')]", 4).click();
		} else {
			change_text = CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[@class='context-menu-item link' and contains(@title,'" + arg1 + "')]", 4)
					.getAttribute("title");
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='context-menu-item link' and contains(@title,'" + arg1 + "')]", 4).click();
		}
	}

	@And("^Select date format as \"([^\"]*)\"$")
	public void select_date_format_as(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByXpath(login.driver,
				"//input[contains(@class,'custom-date-format--input')] | //input[@class='form--control form--control__xs']",
				4).clear();
		CommonFunctionality.getElementByXpath(login.driver,
				"//input[contains(@class,'custom-date-format--input')] | //input[@class='form--control form--control__xs']",
				4).sendKeys(Keys.chord(Keys.CONTROL, "a"), arg1);
		CommonFunctionality.wait(3000);
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
		System.out.println("======="+legand);
		new Actions(login.driver).moveToElement(legand).pause(3000).build().perform();
		 legand_tooltip = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 4).getText();
		System.out.println("==legand_Tooltip===="+legand_tooltip);
	}

	@SuppressWarnings("deprecation")
	@And("^Double click on attribute in the table$")
	public void double_click_on_attribute_in_the_table() throws Throwable {
		WebElement table = CommonFunctionality.getElementByProperty(login.driver, "First_attribute_in_table", 4);
		new Actions(login.driver).moveToElement(table).click().build().perform();
		new Actions(login.driver).moveToElement(table).pause(2000).click().build().perform();
	}

	// TC_Cvision_15211_01
	@SuppressWarnings("deprecation")
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
				sa.fail("Verification Failed");
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
				sa.fail("Verification Failed");
			}
		}
		login.Log4j.info("All functions are present inside functions pop up");
		WebElement preferences = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@title='View and edit profile information']", 8);
		new Actions(login.driver).moveToElement(preferences).pause(3000).click().build().perform();
		new Actions(login.driver).moveToElement(preferences).pause(3000).click().build().perform();
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
		String date_series = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[1]", 4)
				.getText();
		if (date_series.matches("([0-9]{4})/([0-9]{2})/([0-9]{2})") && date_type.contains(arg1)) {
			login.Log4j.info(
					date_type + " date format is reflected on the " + arg2 + " visual and is same as editing format");
		} else if (date_series.matches("([0-9]{2})/([0-9]{4})") && date_type.contains(arg1)) {
			login.Log4j.info(
					date_type + " date format is reflected on the " + arg2 + " visual and is same as editing format");
		} else {
			CommonFunctionality.Views_list();
			sa.fail("Verification failed");
		}
		CommonFunctionality.Views_list();
	}

	// TC_Cvision_16283_01 to TC_Cvision_16283_12
	@Then("^Series selected should be removed$")
	public void series_selected_should_be_removed() throws Throwable {
		/*
		 * if (login.driver.findElements(By.className("growl-message-close")).size() >
		 * 0) { login.driver.findElement(By.className("growl-message-close")).click(); }
		 */
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
		
		WebElement ele= login.driver.findElement(By.xpath("//span[@class='series-edit--title series-edit--title__editable']"));
		
		new Actions(login.driver).moveToElement(ele).pause(4000).build().perform();
		
		String tooltip=login.driver.findElement(By.xpath("(//span[@class='series-edit--title series-edit--title__editable'])[1]")).getText();
		
		if (series.contains(tooltip)) {
			login.Log4j.info("Same Tooltip is displayed in series and the tooltip is " + legand_tooltip);
			CommonFunctionality.Views_list();
		} else {
			fail("Verification failed");
	
		}
	
	
	}
	
	

	@Then("^Verify for annual series - just annual date picker$")
	public void verify_for_annual_series_just_annual_datepicker() throws Throwable {
		if (start_format_datepicker.matches("([0-9]{4})") && end_format_datepicker.matches("([0-9]{4})")
				&& (values_list.contains("Yearly"))) {
			login.Log4j.info("Date format is " + values_list);
			CommonFunctionality.Views_list();
		} else {
			fail("Verification failed");
		}
	}

	@Then("^Verify for semi annual series - month and yr date picker$")
	public void verify_for_semi_annual_series_month_and_yr_datepicker() throws Throwable {
		if (start_format_datepicker.matches("([0-9]{2})/([0-9]{4})")
				&& end_format_datepicker.matches("([0-9]{2})/([0-9]{4})") && (values_list.contains("Semiannually"))) {
			login.Log4j.info("Date format is " + values_list);
			CommonFunctionality.Views_list();
		} else {
			fail("Verification failed");
		}
	}

	@Then("^Verify for quarterly series - month and yr date picker$")
	public void verify_for_quarterly_series_month_and_yr_datepicker() throws Throwable {
		if (start_format_datepicker.matches("([0-9]{2})/([0-9]{4})")
				&& end_format_datepicker.matches("([0-9]{2})/([0-9]{4})") && (values_list.contains("Quarterly"))) {
			login.Log4j.info("Date format is " + values_list);
			CommonFunctionality.Views_list();
		} else {
			fail("Verification failed");
		}
	}

	@Then("^Verify for monthly series - month and yr date picker$")
	public void verify_for_monthly_series_month_and_yr_datepicker() throws Throwable {
		if (start_format_datepicker.matches("([0-9]{2})/([0-9]{4})")
				&& end_format_datepicker.matches("([0-9]{2})/([0-9]{4})") && (values_list.contains("Monthly"))) {
			login.Log4j.info("Date format is " + values_list);
			CommonFunctionality.Views_list();
		} else {
			CommonFunctionality.Views_list();
			sa.fail("Verification failed");
		}
	}

	@Then("^Verify for weekly series - day, month and yr date picker$")
	public void verify_for_weekly_series_day_month_and_yr_datepicker() throws Throwable {
		if (start_format_datepicker.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")
				&& end_format_datepicker.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")
				&& (values_list.contains("Weekly"))) {
			CommonFunctionality.wait(5000);
			login.Log4j.info("Date format is " + values_list);
			CommonFunctionality.Views_list();
		} else {
			CommonFunctionality.Views_list();
			sa.fail("Verification failed");
		}
	}

	@Then("^Verify for daily series - day, month and yr date picker$")
	public void verify_for_daily_series_day_month_and_yr_datepicker() throws Throwable {
		if (start_format_datepicker.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")
				&& end_format_datepicker.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")
				&& (values_list.contains("Daily"))) {
			login.Log4j.info("Date format is " + values_list);
			CommonFunctionality.Views_list();
		} else {
			CommonFunctionality.Views_list();
			sa.fail("Verification failed");
		}
	}

	@Then("^Verify that the date picker should display day,month and yr$")
	public void verify_that_the_datepicker_should_display_day_month_and_yr() throws Throwable {
		if (start_format_datepicker.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")
				&& end_format_datepicker.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")
				&& (values_list.contains("Daily;Quarterly;Yearly"))) {
			login.Log4j.info("Date picker is displaying the frquency of: " + values_list);
			CommonFunctionality.Views_list();
		} else {
			CommonFunctionality.Views_list();
			sa.fail("Verification failed");
		}
	}

	@Then("^Verify that the date picker should display month and yr$")
	public void verify_that_the_datepicker_should_display_month_and_yr() throws Throwable {
		if (start_format_datepicker.matches("([0-9]{2})/([0-9]{4})")
				&& end_format_datepicker.matches("([0-9]{2})/([0-9]{4})") && (values_list.contains("Monthly;Yearly"))) {
			login.Log4j.info("Date picker is displaying the frquency of: " + values_list);
			CommonFunctionality.Views_list();
		} else {
			CommonFunctionality.Views_list();
			sa.fail("Verification failed");
		}
	}

	@Then("^The indicator is not available for selected countries$")
	public void the_indicator_is_not_available_for_selectedcountries() throws Throwable {
		// String comparables_text = "The indicator is not available for selected
		// countries.";
		sa.assertEquals(Comparables_text1.isDisplayed(), true);
		sa.assertEquals(Comparables_text2.isDisplayed(), true);
		sa.assertEquals(Comparables_text3.isDisplayed(), true);
		login.Log4j.info("Series is displayed for particular filtered region");
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

	@SuppressWarnings("deprecation")
	@And("^Setting the date format values in preferences$")
	public void setting_the_date_format_values_in_preferences() throws Throwable {
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
				"div[title='View and edit profile information']", 4)).pause(500).click().build().perform();
		clicking_on_option_in_preference("Date format");
		click_format_date_option("Auto");
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='automatic-date-format']//*[contains(@class,'form--control__xs')][1]//span[2]", 4))
				.pause(500).click().build().perform();
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//div[contains(@class,'automatic-date-format--dropdown')]//div[text()='MM/DD/YYYY']", 4)
				.click();
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
				"div[title='View and edit profile information']", 4)).pause(500).click().build().perform();
	}

	@Then("^Tooltip as \"([^\"]*)\" should display for table$")
	public void tooltip_as_should_display_for_table(String arg1) throws Throwable {
		String tooltip_display = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(@class,'cross-country-button')]", 8)
				.getAttribute("title");
		if (tooltip_display.equals(arg1)) {
			login.Log4j.info("Cross country tooltip for table is displayed and its verified");
		} else {
			CommonFunctionality.CollapseTreeMethod();
			sa.fail("Verification Failed");
		}
		CommonFunctionality.CollapseTreeMethod();
	}

	@SuppressWarnings("deprecation")
	@Then("^Tooltip as \"([^\"]*)\" should display for series$")
	public void tooltip_as_should_display_for_series(String arg1) throws Throwable {
		/*WebElement tooltip = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'series-item--country')]", 4);*/
		WebElement tooltip = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='series-item--main-info']", 4);
		
		new Actions(login.driver).moveToElement(tooltip).pause(4000).build().perform();
		String tooltip_display = CommonFunctionality
				.getElementByXpath(login.driver, "(//*[contains(@class,'cross-country-button')])[2]", 4)
				.getAttribute("title");
		if (tooltip_display.equals(arg1)) {
			login.Log4j.info("Cross country tooltip for series is displayed and its verified");
		} else {
			sa.fail("Verification Failed");
		}
	}

	@Then("^Respective indicator of table should open in comparable tab$")
	public void respective_indicator_of_table_should_open_in_comparable_tab() throws Throwable {
		if (table_text.contains(comparable_table_title)) {
			login.Log4j.info("Respective indicator of table is opened in comparable tab and its verified");
		} else {
			sa.fail("Verification Failed");
		}
	}

	@Then("^Respective indicator of series should open in comparable tab$")
	public void respective_indicator_of_series_should_open_in_comparable_tab() throws Throwable {
		if (series_text.contains(comparable_series_title)) {
			login.Log4j.info("Respective indicator of series is opened in comparable tab and its verified");
		} else {
			sa.fail("Verification Failed");
		}
	}

	@Then("^Default tree should be shown$")
	public void default_tree_should_be_shown() throws Throwable {
		if (login.driver.findElements(By.className("tree-container")).size() != 0) {
			login.Log4j.info("Default tree is displayed and its verified");
		} else {
			sa.fail("Verification Failed");
		}
	}

	@Then("^\"([^\"]*)\" should display for region selection$")
	public void should_display_for_region_selection(String arg1) throws Throwable {
		if (CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 4)
				.isDisplayed()) {
			login.Log4j.info(arg1 + " is displayed for selected region");
		} else {
			sa.fail("Verification failed");
		}
	}

	@Then("^Indicators for all countries should display$")
	public void indicators_for_all_countries_should_display() throws Throwable {
		CommonFunctionality.wait(2000);
		if (selected_regions != all_regions) {
			login.Log4j
					.info("Indicators for all countries is displayed and the count of indicators are: " + all_regions);
		} else {
			sa.fail("Verification failed");
		}
	}

	@Then("^Icon to change to expanded state$")
	public void icon_to_change_to_expanded_state() throws Throwable {
		CommonFunctionality.wait(1000);
		WebElement expand;
		try {
			/*expand = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[@class='toggle']/preceding::*[contains(@class,'tree-node data-set-node')])[1]", 4)*/;
					expand = CommonFunctionality.getElementByXpath(login.driver,
							"(//*[@class='toggle']/preceding::*[contains(@class,'tree-node ')])[4]", 4);
		} catch (Exception e) {
			expand = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[@class='toggle']/preceding::*[contains(@class,'tree-node ')])[4]", 4);
		}
		if (expand.getAttribute("class").contains("open")) {
			login.Log4j.info("Table icon is changed to expanded state");
		} else {
			sa.fail("Verification failed");
		}
	}

	@Then("^\"([^\"]*)\" selected icon to display$")
	public void selected_icon_to_display(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Partially")) {
			/*WebElement partial = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'comparables--header')]//following-sibling::*[contains(@class,'input-control__sm')]",
					4);*/
			WebElement partial = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'input-control__sm')]",
					4);
			//if (partial.getAttribute("class").contains("input-control__partly")) {
				if(partial.getAttribute("class").contains("input-control__sm")) {
				login.Log4j.info("The checkbox is partially selected and " + arg1 + " selected icon is displayed");
			}
		} else {
			/*boolean selected = login.driver.findElement(By.xpath(
					"//*[contains(@class,'comparables--header')]//following-sibling::*[contains(@class,'input-control')]/input"))
					.isSelected();*/
			boolean selected = login.driver.findElement(By.xpath("(//span[@class='input-control--indicator'])[6]")).isSelected();
			
			if (selected == true) {
				login.Log4j.info("The checkbox is fully selected and " + arg1 + " selected icon is displayed");
			} else if (selected == false) {
				login.Log4j.info("The checkbox is unselected and " + arg1 + " selected icon is displayed");
			} else {
				sa.fail("Verification failed");
			}
		}
	}

	@Then("^The filter should be without country code \"([^\"]*)\"$")
	public void the_filter_should_be_without_country_code(String arg1) throws Throwable {
		country_code = arg1;
		if (!(comparable_table_title.contains(country_code)) && table_text.contains(country_code)) {
			login.Log4j.info("The filter text in comparables tab is without country code " + country_code);
		} else {
			sa.fail("Verification Failed");
		}
	}

	@Then("^\"([^\"]*)\" to be present and its \"([^\"]*)\"$")
	public void to_be_present_and_its(String arg1, String arg2) throws Throwable {
		if (CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='preview-container']//following::*[contains(@class,'series-item--icon') and @title='" + arg2
						+ "']",
				4).isDisplayed()) {
			login.Log4j.info(arg1 + " is displayed and its verified");
			CommonFunctionality.Hidden_Webelements_handling(login.driver, "className", "movable-modal--close");
			CommonFunctionality.wait(500);
			CommonFunctionality.Views_list();
		} else {
			CommonFunctionality.Views_list();
			sa.fail("Verification failed");
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
			CommonFunctionality.Views_list();
			sa.fail("Verification failed");
		}
	}

	@Then("^The Message \"([^\"]*)\" should be displayed$")
	public void the_Message_should_be_displayed(String arg1) throws Throwable {
		String date[] = date_text.split("\n");
		assertEquals(date[0], arg1);
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		login.Log4j
				.info("The download message is: " + arg1 + " for the timerange from " + start_date + " to " + end_date);
		CommonFunctionality.DeleteSeries();
	}

	@Then("^The Message \"([^\"]*)\" be displayed$")
	public void the_Message_be_displayed(String arg1) throws Throwable {
		assertEquals(footnotes_text, arg1);
		login.Log4j.info("The message is: " + footnotes_text);
		CommonFunctionality.getElementByProperty(login.driver, "Close", 4).click();
	}

	@Then("^\"([^\"]*)\" method should be checked$")
	public void method_should_be_checked(String arg1) throws Throwable {
		
		try {
			boolean check = login.driver
					.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]//preceding-sibling::input"))
					.isSelected();
			if (check == true) {
				login.Log4j.info(arg1 + " method is checked by default");
				try {
					CommonFunctionality.Hidden_Webelements_handling(login.driver, "className", "movable-modal--close");
				} catch (Exception e) {
					CommonFunctionality.getElementByProperty(login.driver, "Close", 4).click();
				}
				CommonFunctionality.DeleteSeries();
			} else {
				CommonFunctionality.DeleteSeries();
				sa.fail("Verification Failed");
			}
		} catch (Exception e) {
			boolean check = login.driver
					.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]//following::input[1]")).isSelected();
			if (check == true) {
				login.Log4j.info(arg1 + " method is checked by default");
				//CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
				WebElement close=login.driver.findElement(By.xpath("//div[@class='movable-modal--close']"));
				js.executeScript("arguments[0].click();", close);
				
				CommonFunctionality.DeleteSeries();
			} else {
				//CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
				WebElement close=login.driver.findElement(By.xpath("//div[@class='movable-modal--close']"));
				js.executeScript("arguments[0].click();", close);
				CommonFunctionality.DeleteSeries();
				sa.fail("Verification Failed");
			}
		}
	}

	@Then("^\"([^\"]*)\" button should be enabled for user to cancel the operation at any time$")
	public void button_should_be_enabled_for_user_to_cancel_the_operation_at_any_time(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		
		if (button == true) {
			CommonFunctionality.wait(2000);
			WebElement Cancel=login.driver.findElement(By.xpath("//button[text()='Cancel']"));
			js.executeScript("arguments[0].click();", Cancel);
		}
		if (login.driver.findElements(By.className("movable-modal--body")).size() == 0) {
			login.Log4j.info(arg1 + " button is enabled for users to cancel the operation at any time");
			CommonFunctionality.DeleteSeries();
		} else {
			CommonFunctionality.DeleteSeries();
			sa.fail("Verification Failed");
		}
	}

	@SuppressWarnings("deprecation")
	@Then("^\"([^\"]*)\" tooltip should present$")
	public void tooltip_should_present(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);
		WebElement annotation_tooltip = CommonFunctionality.getElementByProperty(login.driver, "Annotation_tooltip", 4);
		new Actions(login.driver).moveToElement(annotation_tooltip).pause(4000).build().perform();
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
			if (login.driver.findElements(By.className("movable-modal--close")).size() > 0) {
				CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			}
			CommonFunctionality.Views_list();
			sa.fail("Verification failed");
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
		new Actions(login.driver).moveToElement(annotation_tooltip).pause(4000).click().build().perform();
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
			CommonFunctionality.Hidden_Webelements_handling(login.driver, "className", "movable-modal--close");
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Unexpected_confirmation_popup")))
					.size() > 0) {
				CommonFunctionality.getElementByProperty(login.driver, "Unexpected_confirmation_popup", 4).click();
			}
			CommonFunctionality.Views_list();
		} else {
			CommonFunctionality.Hidden_Webelements_handling(login.driver, "className", "movable-modal--close");
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Unexpected_confirmation_popup")))
					.size() > 0) {
				CommonFunctionality.getElementByProperty(login.driver, "Unexpected_confirmation_popup", 4).click();
			}
			CommonFunctionality.Views_list();
			sa.fail("Verification failed");
		}
	}

	@Then("^Both should be available$")
	public void both_should_be_available() throws Throwable {
		/*CommonFunctionality.wait(2000);
		if (fullscreen.isDisplayed()) {
			fullscreen.click();
		} else {
			sa.fail("Full screen is not visible");
		}
		CommonFunctionality.wait(2000);
		if (halfscreen.isDisplayed()) {
			halfscreen.click();
		} else {
			sa.fail("Minimize button is not visible");
		}*/
		login.Log4j.info("Minimize and maximize options are present in video controls");
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
	}

	@Then("^The new visual should save the changes$")
	public void the_new_visual_should_save_the_changes() throws Throwable {
		/*
		 * chart_checkbox2 = login.driver .findElement(By.xpath( "//*[text()='" + text1
		 * + "' and @class='input-control--description']/preceding::input[1]"))
		 * .isSelected();
		 */
		chart_checkbox3 = login.driver.findElement(By.xpath(
				"//*[contains(text(),'" + text2 + "') and @class='input-control--description']/preceding::input[1]"))
				.isSelected();
		if (chart_checkbox1 != chart_checkbox3) {
			login.Log4j.info("The checkbox Changes is affecting in new visual");
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
				&& login.driver.findElements(By.className("suggestions-panel--selection-replace")).size() == 0) {
			login.Log4j.info(arg1 + " and " + arg2 + " options are " + arg3 + " displayed");
			CommonFunctionality.Hidden_Webelements_handling(login.driver, "className", "movable-modal--close");
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
				"//div[contains(@class,'single-series-preview--modal')]", 4);
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
		CommonFunctionality.wait(2000);
		WebElement tool = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'tooltip')]", 4);
		if (tool.getAttribute("class").contains("tooltip__visible")) {
			if (login.driver.findElements(By.xpath("//*[@class='series-tooltip-table']")).size() > 0) {
				login.Log4j.info("Smart tooltip is poped up and it has been verified");
				CommonFunctionality.getElementByProperty(login.driver, "Close", 4).click();
			}
		} else {
			fail("Verification failed");
		}
	}

	// @SuppressWarnings("deprecation")
	@Then("^\"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" actions should be possible$")
	public void actions_should_be_possible(String arg1, String arg2, String arg3, String arg4) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"(//*[@class='tabs__tabs-box'])[2]//following::*[@js-add-container=\"\"]", 4).click();
		WebElement dropdownList = CommonFunctionality.getElementByXpath(login.driver,
				"//ul[contains(@class,'dropdown-menu') and contains(@style,'display: block;')]", 4);
		if (dropdownList.isDisplayed()) {
			CommonFunctionality.wait(500);
			System.out.println("Add series options are present");
			CommonFunctionality.getElementByXpath(login.driver,
					"(//*[@class='tabs__tabs-box'])[2]//following::*[@js-add-container=\"\"]", 4).click();
		} else {
			sa.fail("Add series options verification failed");
		}
		CommonFunctionality.getElementByXpath(login.driver,
				"(//*[@class='tabs__tabs-box'])[2]//following::*[@js-visual-container=\"\"]", 4).click();
		WebElement dropdown = CommonFunctionality.getElementByXpath(login.driver,
				"//ul[contains(@class,'dropdown-menu') and contains(@style,'display: block;')]", 4);
		if (dropdown.isDisplayed()) {
			System.out.println("View as options are present");
		} else {
			sa.fail("View as options are not present");
		}
		WebElement chart = CommonFunctionality.getElementByXpath(login.driver, "//div[contains(@class,'icon--chart-line_large')]", 4);
		if (chart.isDisplayed()) {
			System.out.println("Chart Option is present");
		} else {
			sa.fail("Chart option are not present");
		}
		WebElement map = CommonFunctionality.getElementByXpath(login.driver, "//div[contains(@class,'icon--map-filled_large')]", 4);
		if (map.isDisplayed()) {
			System.out.println("Map Option is present");
		} else {
			sa.fail("Map option not present");
		}
		WebElement table = CommonFunctionality.getElementByXpath(login.driver, "//div[contains(@class,'icon--table-vertical_large')]", 4);
		if (table.isDisplayed()) {
			System.out.println("Table Option is present");
		} else {
			sa.fail("Table option not present");
		}
		WebElement pie = CommonFunctionality.getElementByXpath(login.driver, "//div[contains(@class,'icon--pie_chart-pie_large')]", 4);
		if (pie.isDisplayed()) {
			System.out.println("Pie Option is present");
		} else {
			sa.fail("Pie option not present");
		}
		WebElement heatmap = CommonFunctionality.getElementByXpath(login.driver, "//div[contains(@class,'icon--heatmap_large')]", 4);
		if (heatmap.isDisplayed()) {
			System.out.println("Heat map Option is present");
		} else {
			sa.fail("Heat map option not present");
		}
		WebElement histogram = CommonFunctionality.getElementByXpath(login.driver, "//div[contains(@class,'icon--histogram_large')]", 4);
		if (histogram.isDisplayed()) {
			System.out.println("Histogram Option is present");
		} else {
			sa.fail("Histogram option not present");
		}
		CommonFunctionality.getElementByXpath(login.driver,
				"(//*[@class='tabs__tabs-box'])[2]//following::*[@js-visual-container=\"\"]", 4).click();
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
		login.Log4j.info("All options have been verified and displayed in Drill down series of SSP window");
		login.driver.findElement(By.xpath("(//*[@class='movable-modal--close'])[2]")).click();
		CommonFunctionality.wait(500);
		login.driver.findElement(By.xpath("//*[@class='movable-modal--close']")).click();
		login.Log4j.info(
				arg1 + ", " + arg2 + ", " + arg3 + " and " + arg4 + " actions are possible and it has been verified");
	}

	@SuppressWarnings("deprecation")
	@Then("^Country names should be series names$")
	public void country_names_should_be_series_names() throws Throwable {
		CommonFunctionality.wait(3000);
		String region_legand = CommonFunctionality.getElementByProperty(login.driver, "legand_region", 4).getText();
		System.out.println("region 1 is " +region_legand);
		String region2_legand = CommonFunctionality.getElementByProperty(login.driver, "legand_region2", 4).getText();
		System.out.println("region 2 is " +region2_legand);
		WebElement region1 = CommonFunctionality.getElementByProperty(login.driver, "legand_region", 4);
		new Actions(login.driver).moveToElement(region1).pause(2000).build().perform();
		WebElement region2 = CommonFunctionality.getElementByProperty(login.driver, "legand_region2", 4);
		new Actions(login.driver).moveToElement(region2).pause(2000).build().perform();
		WebElement title = CommonFunctionality.getElementBycssSelector(login.driver, "span[data-name='title']", 4);
		new Actions(login.driver).moveToElement(title).pause(2000).build().perform();
		//new Actions(login.driver).moveToElement(region1).pause(2000).build().perform();
		
		String region_legand_text = CommonFunctionality
				.getElementByXpath(login.driver, "(//div[@class='legend-item'])[1]/span[1]", 4).getText();
		//new Actions(login.driver).moveToElement(title).pause(2000).build().perform();
		new Actions(login.driver).moveToElement(region2).pause(2000).build().perform();
		String region_legand2_text = CommonFunctionality
				.getElementByXpath(login.driver, "(//div[@class='legend-item'])[2]/span[1]", 4).getText();
		
		if (region_legand.equals(region_legand_text) && region2_legand.equals(region_legand2_text)) {
		
			login.Log4j.info("The country names are displaying as series names and it has been verified");
		} else {
			CommonFunctionality.Views_list();
			sa.fail("Verification failed");
		}
		CommonFunctionality.Views_list();
	}

	@Then("^Chart title has to be series name$")
	public void chart_title_has_to_be_series_name() throws Throwable {
		CommonFunctionality.wait(3000);
		String title = CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[@class='highcharts-title']//*[@class='text-dots'] | //span[@data-name='title']", 4)
				.getText();
		if (title.equals(text_series1) && (title.equals(text_series2))) {
			login.Log4j.info("The chart title is displaying as series names and it has been verified");
		} else {
			CommonFunctionality.Views_list();
			sa.fail("Verification failed");
		}
		CommonFunctionality.Views_list();
	}

	@Then("^The series is not displayed$")
	public void the_series_is_not_displayed() throws Throwable {
		 CommonFunctionality.wait(2000);
		String count = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='series-series-count--toggle']//span", 8).getText();
		int result = Integer.parseInt(count);
		login.Log4j.info("The series is not displayed for external users");
		sa.assertEquals(result, 0);
	}

	@Then("^All attributes should be applied to table visual$")
	public void all_attributes_should_be_applied_to_table_visual() throws Throwable {
		boolean attributes_element_all = login.driver
				.findElement(By.xpath("//*[text()='" + few_attributes + "']/following::input[1]")).isSelected();
		CommonFunctionality.getElementByClassName(login.driver, "popover--close", 4).click();
		List<WebElement> attrib_count = login.driver.findElements(By.className("hor-vertical-header"));
		int attributes_table_count_after = attrib_count.size();
		if (attributes_table_count_after != attributes_table_count_before && attributes_element_all == true) {
			login.Log4j.info("The selected attributes are applied to table visual");
		} else {
			CommonFunctionality.Views_list();
			sa.fail("Verification Failed");
		}
		CommonFunctionality.Views_list();
	}

	@Then("^\"([^\"]*)\" attributes should be selected$")
	public void all_attributes_should_be_selected(String arg1) throws Throwable {
		boolean title_checkbox = login.driver.findElement(By.xpath("//*[text()='Title']//following::input[1]"))
				.isSelected();
		CommonFunctionality.wait(3000);
		if (arg1.equalsIgnoreCase("All")) {
			if (!(title_checkbox_webElement.getAttribute("class").contains("input-control__partly"))
					&& title_checkbox == true) {
				CommonFunctionality.wait(500);
				// CommonFunctionality.getElementByProperty(login.driver, "Series_tab",
				// 8).click();
				login.Log4j
						.info(arg1 + " attributes are selected and applied to table visual and it has been verified");
			} else {
				sa.fail("Verification Failed");
			}
		} else if (arg1.equalsIgnoreCase("None")) {
			if (!(title_checkbox_webElement.getAttribute("class").contains("input-control__partly"))
					&& title_checkbox == false) {
				// CommonFunctionality.getElementByProperty(login.driver, "Series_tab",
				// 8).click();
				login.Log4j
						.info(arg1 + " attributes are selected and applied to table visual and it has been verified");
			} else {
				sa.fail("Verification Failed");
			}
		} else if (arg1.equalsIgnoreCase("Partial")) {
			if (title_checkbox_webElement.getAttribute("class").contains("input-control__partly")) {
				login.Log4j
						.info(arg1 + " attributes are selected and applied to table visual and it has been verified");
			} else {
				sa.fail("Verification Failed");
			}
		}
		CommonFunctionality.getElementByClassName(login.driver, "popover--close", 8).click();
		CommonFunctionality.Views_list();
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
			sa.fail("Verification Failed");
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
			CommonFunctionality.getElementByProperty(login.driver, "Close", 4).click();
			sa.fail("Verification Failed");
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
			sa.fail("Verification Failed");
		}
		String global = CommonFunctionality
				.getElementByXpath(login.driver, "(//*[contains(@class,'header-menu-products--title')])[3]", 4)
				.getText();
		if (global.equalsIgnoreCase(arg2)) {
			login.Log4j.info(arg2 + " is in place 2");
		} else {
			sa.fail("Verification Failed");
		}
	}

	@Then("^\"([^\"]*)\" timepoints should be in \"([^\"]*)\" color in SSP$")
	public void timepoints_should_be_in_color_in_SSP(String arg1, String arg2) throws Throwable {
		List<WebElement> color = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Negative_timepoints")));
		System.out.println("=color==="+color);
		int count = color.size();
		System.out.println("Total " + arg1 + " timepoints: " + count);
		for (WebElement red : color) {
			System.out.println("res"+red);
			CommonFunctionality.wait(4000);
		//	System.out.println("=====before======="+red.getAttribute("fill").contains("#ff3a56"));
			WebElement TimePoints=login.driver.findElement(By.xpath("(//*[@fill='#e74c3c'])[1]"));
			if(TimePoints.isDisplayed()) {
			new Actions(login.driver).moveToElement(TimePoints).pause(4000).build().perform();
			}
			else {
				System.out.println("timepoints not displayed");
			}
			/*if (red.getAttribute("fill").contains("#ff3a56") || red.getAttribute("fill").contains("#2B60D0")) {
				System.out.println("=====inside======="+red.getAttribute("fill").contains("#ff3a56"));
			//if (red.getAttribute("fill").contains("#e74c3c") || red.getAttribute("fill").contains("#2B60D0")) {
			
				CommonFunctionality.wait(1000);
			} else {
				sa.fail("Verification Failed");
			}*/
		}
		login.Log4j.info(arg1 + " timepoints are displaying in " + arg2 + " color");
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "className", "movable-modal--close");
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
			sa.assertEquals(actual, expected);
		}
		login.Log4j.info("Negative timepoints are displaying in Red color");
		CommonFunctionality.Views_list();
	}

	@Then("^The time within period should sync with chart \"([^\"]*)\" period\\.$")
	public void the_time_within_period_should_sync_with_chart_period(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);
		if (SSPWindow.datefrom.equals(start_date_inside_chart) && (SSPWindow.dateto.equals(end_date_inside_chart))) {
			login.Log4j.info("The time within period is syncned with chart " + arg1 + " period");
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			CommonFunctionality.Views_list();
		} else {
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			CommonFunctionality.Views_list();
			sa.fail("Verification failed");
		}
	}

	@Then("^Time within period should sync with chart \"([^\"]*)\" period$")
	public void time_within_period_should_sync_with_chart_period(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		String start_date = CommonFunctionality.getElementByXpath(login.driver,
				"(//*[@class='highcharts-axis-labels highcharts-xaxis-labels'])[2]/*[2]", 4).getText();
		String end_date = CommonFunctionality.getElementByXpath(login.driver,
				"(//*[@class='highcharts-axis-labels highcharts-xaxis-labels'])[2]/*[1]", 4).getText();
		if (chart_from_date.equals(start_date) && (chart_to_date.equals(end_date))) {
			login.Log4j.info("The time within period is syncned with chart " + arg1 + " period");
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			CommonFunctionality.Views_list();
		} else {
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			CommonFunctionality.Views_list();
			sa.fail("Verification failed");
		}
	}

	@Then("^Stroke options to be in disabled state$")
	public void stroke_options_to_be_in_disabled_state() throws Throwable {
		if (stroke.getAttribute("class").contains("insight-action-panel--btn__disabled")) {
			login.Log4j.info("Stroke option is in disabled state and has been verified successfully");
			CommonFunctionality.Hidden_Webelements(login.driver, "//*[@class='movable-modal--close']");
			if (login.driver.findElements(By.cssSelector(".modal-content.sphere-modal__content")).size() > 0) {
				CommonFunctionality
						.getElementBycssSelector(login.driver, ".sphere-modal-controls--right .button__primary", 4)
						.click();
			}
			CommonFunctionality.Views_list();
		} else {
			CommonFunctionality.Views_list();
			sa.fail("Verification failed");
		}
	}

	@Then("^Choosen series should shift to \"([^\"]*)\" axis$")
	public void choosen_series_should_shift_to_axis(String arg1) throws Throwable {
	/*	WebElement Left_axis=login.driver.findElement(By.xpath("(//div[@class='series-axis--button series-axis--button__left series-axis--button__selected'])[2]"));
		if(Left_axis.isDisplayed()) {
	login.Log4j.info("Choosen series is shifted to " + arg1 + " axis");*/
		//if (axis.getAttribute("class").contains("series-axis--button__selected") && chart_option.contains(arg1)) {
		WebElement Right_axis=login.driver.findElement(By.xpath("(//div[@class='series-axis--button series-axis--button__right series-axis--button__selected'])[2]"));
			if(Right_axis.isDisplayed()) {
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
			/*WebElement Left_axis=login.driver.findElement(By.xpath("(//div[@class='series-axis--button series-axis--button__left series-axis--button__selected'])[2]"));
			if(Left_axis.isDisplayed()) {
		login.Log4j.info("Choosen series is shifted to " + arg1 + " axis");*/
			
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(@class,'movable-modal__active')]//*[@class='movable-modal--close']", 4)
					.click();
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Unexpected_confirmation_popup")))
					.size() > 0) {
				CommonFunctionality.getElementByProperty(login.driver, "Unexpected_confirmation_popup", 4).click();
			}
			CommonFunctionality.Views_list();
			sa.fail("Verification failed");
		}
		}
	
	
	
	@Then("^Choosen axis should shift to \"([^\"]*)\" axis$")
	public void choosen_axis_series_should_shift_to_axis(String arg1) throws Throwable {
	/*	WebElement Left_axis=login.driver.findElement(By.xpath("(//div[@class='series-axis--button series-axis--button__left series-axis--button__selected'])[2]"));
		if(Left_axis.isDisplayed()) {
	login.Log4j.info("Choosen series is shifted to " + arg1 + " axis");*/
		//if (axis.getAttribute("class").contains("series-axis--button__selected") && chart_option.contains(arg1)) {
		WebElement axis=login.driver.findElement(By.xpath("//*[@class='highcharts-scrollbar-thumb']"));
		Dimension  size=axis.getSize();
		System.out.println("height "+size.getHeight() +"Width is "+size.getWidth());
		if(arg1.equalsIgnoreCase("left")) {
					
			assertEquals(42, size.getWidth());
			
		}
		else if(arg1.equalsIgnoreCase("right")) {
			
			assertEquals(42, size.getWidth());	
		}
			
		}
		
	

	@Then("^The results to be sorted based on country$")
	public void the_results_to_be_sorted_based_on_country() throws Throwable {
		// Check the alphabetical sorting
		ArrayList<String> obtainedList = new ArrayList<>();
		List<WebElement> elementList = login.driver.findElements(
				By.xpath("//*[@class='series-item--main-info']//*[contains(@class,'series-item--country')]"));
		// Collection of elements to be sorted
		for (WebElement we : elementList) {
			CommonFunctionality.wait(100);
			String text = we.getText();
			obtainedList.add(text);
		}
//		ArrayList<String> sortedList = new ArrayList<>();
//		// Collection of sorted elements
//		for (String s : obtainedList) {
//			sortedList.add(s);
//		}
		login.Log4j.info(obtainedList);
		// Collections framework to sort web elements
		 Collections.sort(obtainedList);
		 login.Log4j.info(obtainedList);
		// Comparison of array lists
		assertTrue(obtainedList.equals(obtainedList));
		login.Log4j.info("The results are sorted based on country");
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
							sa.fail("Verification failed");
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
			if (login.driver.findElements(By.className("sphere-modal__close")).size() > 0) {
				CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
			}
			CommonFunctionality.getElementByProperty(login.driver, "Close", 4).click();
			sa.fail("Verification failed");
		}
	}

	@Then("^Ascending and descending icon should not displayed for \"([^\"]*)\"$")
	public void ascending_and_descending_icon_should_not_displayed_for(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);
		WebElement icon = CommonFunctionality.getElementByProperty(login.driver, "Right_panel_dropdown_icon", 4);
		if (icon.getAttribute("class").contains("sort-select-title__asc-hidden sort-select-title__desc-hidden")
				&& arg1.equalsIgnoreCase(sort)) {
			login.Log4j.info("Ascending and descending icon is not displayed for " + arg1);
			CommonFunctionality.DeleteSeries();
		} else {
			CommonFunctionality.DeleteSeries();
			sa.fail("Verification failed");
		}
	}

	@Then("^User should download the builds$")
	public boolean user_should_download_the_builds() throws Throwable {
		CommonFunctionality.wait(1000);
		String href1 = CommonFunctionality
				.getElementBycssSelector(login.driver, ".installation-download-button__button", 4).getAttribute("href");
		String split[] = href1.split("cdmplugin/");
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'installation-download-button')]//*[contains(text(),'Download CDMNext Addin')]", 4)
				.click();
		CommonFunctionality.wait(5000);
		if (login.driver.findElements(By.className("sphere-modal__close")).size() > 0) {
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		}
//		CommonFunctionality.wait(5000);
		String downloadFilepath = System.getProperty("user.home") + "\\Downloads";

		// String downloadPath = System.getProperty("user.home") + "\\Downloads";
		File dir = new File(downloadFilepath);
		File[] dirContents = dir.listFiles();
		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().contains(split[1])) {
				dirContents[i].delete();
				login.Log4j.info("File has been downloaded and its verified");
				return true;
			}
		}
		Assert.fail("Download verification failed");
		return false;
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

	@Then("^The new template should be created in the beginning of the list$")
	public void the_new_template_should_be_created_in_the_beginning_of_the_list() throws Throwable {
		String new_template = CommonFunctionality
				.getElementByXpath(login.driver, "(//*[contains(@class,'style-templates-item')])[1]", 4)
				.getAttribute("title");
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
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal__body')]//*[text()='Ok']"))
					.size() > 0) {
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'sphere-modal__body')]//*[text()='Ok']", 4).click();
			}
			CommonFunctionality.Views_list();
			sa.fail("Verification Failed");
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
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal__body')]//*[text()='Ok']"))
					.size() > 0) {
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'sphere-modal__body')]//*[text()='Ok']", 4).click();
			}
			CommonFunctionality.Views_list();
			sa.fail("Verification Failed");
		}
	}

	@Then("^The new visual should be created with selected template style$")
	public void the_new_visual_should_be_created_with_selected_template_style() throws Throwable {
		/*
		 * chart_checkbox2 = login.driver.findElement(By.xpath( "//*[text()='" + text1 +
		 * "' and @class='input-control--description']/preceding::input[1] | //*[text()='"
		 * + text1 +
		 * "' and @class='table-properties-context-title']/preceding::input[1]"))
		 * .isSelected();
		 */
		chart_checkbox3 = login.driver.findElement(By.xpath("//*[contains(text(),'" + text2
				+ "') and @class='input-control--description']/preceding::input[1] | //*[contains(text(),'" + text1
				+ "') and @class='table-properties-context-title']/preceding::input[1]")).isSelected();
		if (chart_checkbox1 != chart_checkbox3) {
			login.Log4j.info(text2
					+ " checkbox Changes is affecting in new visual as the new visual is creating with selected template style");
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			CommonFunctionality.Views_list();
		} else {
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			CommonFunctionality.Views_list();
			fail("Verification failed");
		}
	}

	@Then("^\"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\" should be displayed$")
	public void and_should_be_displayed(String arg1, String arg2, String arg3, String arg4) throws Throwable {
		List<WebElement> values = login.driver.findElements(By.xpath("//*[@class='items-wrapper']/li/span[1]"));
		for (WebElement value : values) {
			String text = value.getAttribute("title");
			if (!(text.contains(arg3) || text.contains(arg2) || text.contains(arg1) || text.contains(arg4))) {
				CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
				CommonFunctionality.Views_list();
				sa.fail("Verification Failed");
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
			CommonFunctionality.getElementByProperty(login.driver, "Close", 4).click();
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			sa.fail("Verification failed");
		}
	}

	@Then("^The selected \"([^\"]*)\" is applied to the table$")
	public void the_selected_is_applied_to_the_table(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		//String title_text = CommonFunctionality.getElementByProperty(login.driver, "series_edit_title", 4).getText();
		String title_text=login.driver.findElement(By.xpath("//*[@class='series-edit--title']")).getText();
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
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']"))
					.size() > 0) {
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']", 4).click();
			}
			CommonFunctionality.Views_list();
			sa.fail("Verification failed");
		}
	}

	@Then("^The selected \"([^\"]*)\" is applied to the table visual$")
	public void the_selected_is_applied_to_the_table_visual(String arg1) throws Throwable {
		CommonFunctionality.wait(5000);
		
		String title_text = CommonFunctionality.getElementByProperty(login.driver, "series_edit_title", 4).getText();
		CommonFunctionality.wait(3000);
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
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']"))
					.size() > 0) {
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']", 4).click();
			}
			CommonFunctionality.Views_list();
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
		}else {
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']"))
					.size() > 0) {
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']", 4).click();
			}
			CommonFunctionality.Views_list();
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
			CommonFunctionality.Views_list();
			fail("Verification failed");
		}
	}

	@SuppressWarnings("deprecation")
	@Then("^\"([^\"]*)\" should be shown on tooltip$")
	public void should_be_shown_on_tooltip(String arg1) throws Throwable {
		List<WebElement> tooltips = login.driver
				.findElements(By.xpath("//*[@class='highcharts-point' and not(@fill='#05999a')]"));
		for (int i = 1; i < tooltips.size(); i++) {
			CommonFunctionality.wait(1000);
			WebElement indicator_value = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'highcharts-markers')]//*[@class='highcharts-point' and not(@fill='#05999a')]["
							+ i + "]",
					4);
			new Actions(login.driver).moveToElement(indicator_value).pause(500).build().perform();
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
				CommonFunctionality.Views_list();
				sa.fail("Verification failed");
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
		} else {
			if (login.driver.findElements(By.className("insight-preview--close")).size() > 0) {
				CommonFunctionality.getElementByClassName(login.driver, "insight-preview--close", 4).click();
			}
			CommonFunctionality.Views_list();
			sa.fail("Verification failed");
		}
		if (login.driver.findElements(By.className("insight-preview--close")).size() > 0) {
			CommonFunctionality.getElementByClassName(login.driver, "insight-preview--close", 4).click();
		}
		CommonFunctionality.Views_list();
	}

	@Then("^\"([^\"]*)\" tooltip should be displayed$")
	public void tooltip_should_be_displayed(String arg1) throws Throwable {
		login.Log4j.info(arg1 + " tooltip is displayed");
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		assertEquals(arg1, footnotes_contents);
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
		// ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("mce_0_ifr"));
		//login.driver.switchTo().frame("mce_0_ifr");
		CommonFunctionality.wait(8000);
		//WebElement img_title = CommonFunctionality.getElementByXpath(login.driver, "//body[@id='tinymce']//img", 4);
		WebElement img_title = CommonFunctionality.getElementByXpath(login.driver, "(//img[@title='Shravas.png'])[1]", 4);
		
		if (img_title.getAttribute("title").equals("Shravas.png")) {
			login.Log4j.info("The image has been uploaded successfully without any errors");
			login.driver.switchTo().defaultContent();
			if (login.driver.findElements(By.xpath("//*[@class='vis-elem-menu--item ' and @title='Delete']"))
					.size() > 0) {
				CommonFunctionality
						.getElementByXpath(login.driver, "//*[@class='vis-elem-menu--item ' and @title='Delete']", 4)
						.click();
			}
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
			sa.fail("Verification failed");
		}
	}

	@Then("^The message should be \"([^\"]*)\"$")
	public void the_message_should_be(String arg1) throws Throwable {
		String growl_message = CommonFunctionality.getElementByClassName(login.driver, "growl-message-text", 4)
				.getText();
		login.Log4j.info("The message is " + arg1);
		if (login.driver.findElements(By.className("sphere-modal__close")).size() > 0) {
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		}
		assertEquals(growl_message, arg1);
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
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='insight-preview--header']//*[@class='insight-preview--close']", 4).click();
			// CommonFunctionality.getElementByClassName(login.driver,
			// "sphere-modal__close", 4).click();
		} else {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='insight-preview--header']//*[@class='insight-preview--close']", 4).click();
			// CommonFunctionality.getElementByClassName(login.driver,
			// "sphere-modal__close", 4).click();
			sa.fail("Verification Failed");
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
				CommonFunctionality.Views_list();
				sa.fail("Label is not displayed");
			}
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='vis-elem-menu--item ' and @title='Delete']", 4)
					.click();
			CommonFunctionality.wait(2000);
			if (login.driver.findElements(By.xpath("//*[contains(@class,'modal-dialog')]//*[text()='Ok']"))
					.size() > 0) {
				CommonFunctionality
						.getElementByXpath(login.driver, "//*[contains(@class,'modal-dialog')]//*[text()='Ok']", 4)
						.click();
			}
			CommonFunctionality.Views_list();
		}
	}

	@Then("^Share \"([^\"]*)\" popup should display every time share insight$")
	public void share_popup_should_display_every_time_share_insight(String arg1) throws Throwable {
		if (CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[contains(@class,'sphere-modal__content')]//*[contains(text(),'" + arg1 + "')]", 4)
				.isDisplayed()) {
			login.Log4j.info(arg1 + " popup is displaying for sharing insight");
			// CommonFunctionality.getElementByClassName(login.driver,
			// "sphere-modal__close", 4).click();
			CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='sphere-modal__close'])[2]", 4).click();
		} else {
			CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='sphere-modal__close'])[2]", 4).click();
			fail("Verification Failed");
		}
	}

	@Then("^The title for \"([^\"]*)\"$")
	public void the_title_for(String arg1) throws Throwable {
		the_share_process_should_be_declined();
	}

	@Then("^The description should be \"([^\"]*)\"$")
	public void the_description_should_be(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		String description_text = CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[@class='modal-window modal-window__active']//*[contains(@class,'sphere-modal__body')]", 4)
				.getText();
		if (description_text.contains(arg1)) {
			login.Log4j.info("The description is " + arg1);
			// CommonFunctionality.getElementByClassName(login.driver,
			// "sphere-modal__close", 4).click();
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[@class='modal-window modal-window__active']//*[@class='sphere-modal__close']", 4)
					.click();
		} else {
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[@class='modal-window modal-window__active']//*[@class='sphere-modal__close']", 4)
					.click();
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
				CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
				fail("Verification Failed");
			}
		}
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
	}

	@Then("^The confirmation popup should be displayed only for first time share$")
	public void the_confirmation_popup_should_be_displayed_only_for_first_time_share() throws Throwable {
		CommonFunctionality.wait(4000);
		if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal__content')]")).size() > 0) {
			fail("The confirmation popup is displayed for second time share and it has been verified");
		} else {
			login.Log4j.info("Confirmation popup is displayed only for first time share insight");
		}
	}

	@Then("^Both the series results should be same$")
	public void both_the_series_results_should_be_same() throws Throwable {
		
		CommonFunctionality.wait(2000);	
		Integer actual = Integer.parseInt(first_search_keyword);
		Integer expected = Integer.parseInt(second_search_keyword);
		assertEquals(actual, expected);
		login.Log4j.info("Both the names are fetching the same result and it has been verified successfully");
	}

	@SuppressWarnings("deprecation")
	@Then("^Tooltip only displayed when hover the mouse on series name$")
	public void tooltip_only_displayed_when_hover_the_mouse_on_series_name() throws Throwable {
		@SuppressWarnings("unused")
		List<WebElement> country_list = login.driver
				.findElements(By.xpath("//*[contains(@class,'country-information')]"));
		for (int i = 1; i <= 2; i++) {
			WebElement country = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[contains(@class,'country-information')])[" + i + "]", 4);
			new Actions(login.driver).moveToElement(country).pause(3000).build().perform();
			if (!(login.driver
					.findElements(
							By.xpath("//*[@id='hidden-input']//following::*[contains(@class,'tooltip__visible')]"))
					.size() == 0)) {
				sa.fail("Verification Failed");
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
					if (login.driver.findElements(By.xpath("//*[contains(text(),'Ok')]")).size() > 0) {
						CommonFunctionality.Hidden_Webelements(login.driver, "//*[contains(text(),'Ok')]");
					}
				}
			}
		} else {
			sa.fail("Verification Failed");
		}
	}

	@Then("^The title of the pop up should be \"([^\"]*)\"$")
	public void the_title_of_the_pop_up_should_be(String arg1) throws Throwable {
		login.Log4j.info("The Title of the popup is: " + arg1);
		CommonFunctionality.getElementByProperty(login.driver, "Close", 4).click();
		CommonFunctionality.Views_list();
		assertEquals(modal_text, arg1);
	}

	@Then("^The message in the pop up should be \"([^\"]*)\"$")
	public void the_message_in_the_pop_up_should_be(String arg1) throws Throwable {
		login.Log4j.info("The message in the popup is: " + arg1);
		CommonFunctionality.getElementByProperty(login.driver, "Close", 4).click();
		CommonFunctionality.Views_list();
		assertEquals(modal_text, arg1);
	}

	@Then("^The notification panel is opened$")
	public void the_notification_panel_is_opened() throws Throwable {
		WebElement active = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='tabs__tab-item active']",
				4);
		if (login.driver.findElements(By.cssSelector(".user-notifications--alert.user-notifications--alert__show"))
				.size() > 0) {
			if (active.getText().contains("Notifications")) {
			} else {
				sa.fail("Verification failed");
			}
		} else {
			if (active.getText().contains("What's new")) {
			} else {
				sa.fail("Verification Failed");
			}
		}
		login.Log4j.info("The notification panel is opened and " + active.getText() + " tab is default");
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
				CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
				if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal__content')]")).size() > 0) {
					CommonFunctionality.getElementByXpath(login.driver,
							"//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']", 4).click();
				}
				CommonFunctionality.Views_list();
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
		Pattern pattern = Pattern.compile("  *");
		Matcher matcher = pattern.matcher(name_preference);
		if (matcher.find()) {
			separated_first_name = name_preference.substring(0, matcher.start());
			separated_last_name = name_preference.substring(matcher.end());
		}
		if (separated_first_name.equalsIgnoreCase(first_name) && separated_last_name.equalsIgnoreCase(last_name)) {
			login.Log4j.info("First name and Last name is displayed");
		} else {
			fail("Verification Failed");
		}
		if (!(prefix.equalsIgnoreCase(name_prefix))) {
			fail("Verification Failed");
		}
		login.Log4j.info("User prefix, First name and Last name is displayed in user preferences");
	}

	/*
	 * @Then("^\"([^\"]*)\" popup should be displayed$") public void
	 * popup_should_be_displayed(String arg1) throws Throwable { if
	 * (arg1.equalsIgnoreCase(preference_popup)) { login.Log4j .info(arg1 +
	 * " title in the popup is displayed inside preferences option and it has been verified"
	 * ); } else { fail("Verification Failed"); } }
	 */

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

	@Then("^The updated \"([^\"]*)\" should show under preference$")
	public void the_updated_should_show_under_preference(String arg1) throws Throwable {
		String name_preference = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(@class,'profile-menu--name')]//span[2]", 4).getText();
		Pattern pattern = Pattern.compile("  *");
		Matcher matcher = pattern.matcher(name_preference);
		if (matcher.find()) {
			separated_first_name = name_preference.substring(0, matcher.start());
			separated_last_name = name_preference.substring(matcher.end());
		}
		if (arg1.equalsIgnoreCase("First Name")) {
			if (separated_first_name.equalsIgnoreCase(first_name_edit)) {
				login.Log4j.info("The updated " + arg1 + " is displayed and it has been verified");
			} else {
				fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("Last Name")) {
			if (separated_last_name.equalsIgnoreCase(last_name_edit)) {
				login.Log4j.info("The updated " + arg1 + " is displayed and it has been verified");
			} else {
				fail("Verification Failed");
			}
		}
	}

	@Then("^\"([^\"]*)\" ID should be pre-exist in non editable mode$")
	public void id_should_be_pre_exist_in_non_editable_mode(String arg1) throws Throwable {
		Assert.assertTrue(email.getAttribute("disabled").equals("true"), "Read Only");
		login.Log4j.info(arg1 + " field is pre-exist in non editable mode");
	}

	@Then("^The user changes should \"([^\"]*)\"$")
	public void the_user_changes_should(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Save")) {
			assertEquals(edited_first_name, first_name_edit);
			login.Log4j.info("The User changes are " + arg1 + "d and it has been verified");
		} else if (arg1.equalsIgnoreCase("Not Save")) {
			assertNotEquals(edited_last_name, last_name_edit);
			login.Log4j.info("The User changes are " + arg1 + "d and it has been verified");
		} else {
			fail("Verification failed");
		}
	}

	@Then("^The image should upload successfully$")
	public void the_image_should_upload_successfully() throws Throwable {
		WebElement upload = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'account-avatar__small')]//img", 4);
		Assert.assertTrue(upload.getAttribute("class").contains("account-avatar--image"), "Uploaded");
		login.Log4j.info(" The User uploaded image has been uploaded successfully");
	}

	@Then("^\"([^\"]*)\" error message should be displayed$")
	public void error_message_should_be_displayed(String arg1) throws Throwable {
		WebElement account = CommonFunctionality.getElementByClassName(login.driver, "account-popup", 4);
		if (login.driver.findElements(By.className("growl-message-text")).size() > 0) {
			error_message = CommonFunctionality.getElementByClassName(login.driver, "growl-message-text", 4).getText();
		}
		assertEquals(true, account.isDisplayed());
		assertEquals(error_message, arg1);
		login.Log4j.info(arg1 + " error message is displayed");
	}

	@Then("^\"([^\"]*)\" popup should appear$")
	public void popup_should_appear(String arg1) throws Throwable {
		WebElement modal_window = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='movable-modal--window']", 4);
		String popup_text = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='movable-modal--window']//*[text()='" + arg1 + "']", 4)
				.getText();
		assertEquals(popup_text, arg1);
		assertEquals(true, modal_window.isDisplayed());
		login.Log4j.info(arg1 + " popup is appeared and it has been verified");
	}

	@Then("^\"([^\"]*)\" message needs to appear$")
	public void message_needs_to_appear(String arg1) throws Throwable {
		if (login.driver.findElements(By.className("growl-message-text")).size() > 0) {
			error_message = CommonFunctionality.getElementByClassName(login.driver, "growl-message-text", 4).getText();
		}
		assertEquals(error_message, arg1);
		login.Log4j.info(arg1 + " message is displaying and it has been verified successfully");
		// CommonFunctionality.getElementByClassName(login.driver,
		// "movable-modal--close", 4).click();
	}

	@Then("^Click on \"([^\"]*)\" from preferences menu$")
	public void click_on_from_preferences_menu(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Change password")) {
			if (login.driver.findElements(By.xpath("//*[text()='" + arg1 + "']")).size() > 0) {
				CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']", 4).click();
				login.Log4j.info("Cancel button has been verified");
			}
		} else {
			fail("Verification Failed");
		}
	}

	@Then("^The UI should contains \"([^\"]*)\" for language \"([^\"]*)\"$")
	public void the_UI_should_contains(String arg1, String arg2) throws Throwable {
		updated_language = CommonFunctionality.getElementByProperty(login.driver, "language_text_in_front_end", 4)
				.getText();
		if (language.equals(arg2) && updated_language.equals(arg1)) {
			login.Log4j.info("The UI is rendering with language " + arg2);
		} else {
			fail("Verification Failed");
		}
	}

	@Then("^\"([^\"]*)\" data format should be updated in the application$")
	public void data_format_should_be_updated_in_the_application(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Auto")) {
			if (updated_date.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")
					|| updated_date.matches("([0-9]{2})-([0-9]{2})-([0-9]{4})")
					|| updated_date.matches("([0-9]{2}).([0-9]{2}).([0-9]{4})")
					|| updated_date.matches("([0-9]{2})/([0-9]{3})/([0-9]{4})")) {
				login.Log4j.info("The " + arg1 + " date format is updated in the application");
				CommonFunctionality.getElementByProperty(login.driver, "Close", 4).click();
			} else {
				CommonFunctionality.getElementByProperty(login.driver, "Close", 4).click();
				sa.fail("Verification Failed");
			}
		} else if (arg1.equalsIgnoreCase("Custom")) {
			if (updated_date.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")
					&& valid_date_format.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")) {
				login.Log4j.info("The " + arg1 + " date format is updated in the application");
				CommonFunctionality.getElementByProperty(login.driver, "Close", 4).click();
			} else {
				CommonFunctionality.getElementByProperty(login.driver, "Close", 4).click();
				sa.fail("Verification Failed");
			}
		}
	}

	@Then("^\"([^\"]*)\" message should display in \"([^\"]*)\" color$")
	public void message_should_display_in_color(String arg1, String arg2) throws Throwable {
		String error_message_date = CommonFunctionality.getElementByProperty(login.driver, "format_error", 4).getText();
		String text_color = CommonFunctionality.getElementByProperty(login.driver, "format_error", 4)
				.getCssValue("color");
		String actual_color = Color.fromString(text_color).asHex();
		String expected_color = "#ef5350";
		assertEquals(actual_color, expected_color);
		assertEquals(error_message_date, arg1);
		login.Log4j.info(arg1 + " error message is displayed in " + arg2 + " color");
	}

	@Then("^Decimal places should be as per the selection in \"([^\"]*)\" tab$")
	public void decimal_places_should_be_as_per_the_selection_in_tab(String arg1) throws Throwable {
		assertEquals(decimal_places, decimalPlaces);
		login.Log4j.info("Decimal places are appearing as per the selection in " + arg1 + " tab");
		CommonFunctionality.getElementByProperty(login.driver, "Close", 4).click();
		CommonFunctionality.DeleteSeries();
	}

	@Then("^Check the data in the insight for \"([^\"]*)\"$")
	public void check_the_data_in_the_insight_for(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Decimal separator")) {
			if (decimal_places == decimal_place_separator) {
				login.Log4j.info("The data is displaying as per selected Number format for " + arg1);
				CommonFunctionality.getElementByProperty(login.driver, "Close", 4).click();
			} else {
				CommonFunctionality.getElementByProperty(login.driver, "Close", 4).click();
				sa.fail("Verification Failed");
			}
		} else {
			get_Value_of_in_Preference("Grouping separator");
			search_for_the_series_with_SID("384226477");
			open_SSP_for_the_selected_series();
			login.driver.findElement(By.xpath("//*[@class='tabs__tabs-box']//*[contains(text(),'Data')]")).click();
			capture_the_Timepoint_value_inside_Group_tab();
			if (full_data1.contains(grouping_seperator) || full_data1.contains(space) || full_data1.contains(none)) {
				login.Log4j.info("The data is displaying as per selected Number format for " + arg1);
				CommonFunctionality.getElementByProperty(login.driver, "Close", 4).click();
			} else {
				CommonFunctionality.getElementByProperty(login.driver, "Close", 4).click();
				sa.fail("Verification Failed");
			}
		}
	}

	@Then("^\"([^\"]*)\" window should be \"([^\"]*)\" and the count is (\\d+)$")
	public void window_should_be_and_the_count_is(String arg1, String arg2, int arg3) throws Throwable {
		if (download_title == arg3) {
			login.Log4j.info("Download settings window is " + arg2 + " and it has been verified");
			if (login.driver.findElements(By.className("sphere-modal__close")).size() > 0) {
				CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
			}
			CommonFunctionality.DeleteSeries();
		} else {
			if (login.driver.findElements(By.className("sphere-modal__close")).size() > 0) {
				CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
			}
			CommonFunctionality.DeleteSeries();
			fail("Verification Failed");
		}
	}

	@Then("^The \"([^\"]*)\" should \"([^\"]*)\" displayed to the user$")
	public void the_should_displayed_to_the_user(String arg1, String arg2) throws Throwable {
		if (arg2.equalsIgnoreCase("be")) {
			if (preference_checkbox1 == true && suggestion > 0) {
				login.Log4j.info("The " + arg1 + " is displayed to the user");
			} else {
				if (login.driver.findElements(By.className("movable-modal--close")).size() > 0) {
					CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
				}
				CommonFunctionality.DeleteSeries();
				sa.fail("Verification Failed");
			}
			if (login.driver.findElements(By.className("movable-modal--close")).size() > 0) {
				CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			}
			CommonFunctionality.DeleteSeries();
		} else {
			if (preference_checkbox1 == false && suggestion == 0) {
				login.Log4j.info("The " + arg1 + " is not displayed to the user");
			} else {
				if (login.driver.findElements(By.className("movable-modal--close")).size() > 0) {
					CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
				}
				CommonFunctionality.DeleteSeries();
				sa.fail("Verification Failed");
			}
			if (login.driver.findElements(By.className("movable-modal--close")).size() > 0) {
				CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			}
			CommonFunctionality.DeleteSeries();
		}
	}

	@Then("^The \"([^\"]*)\" should not be displayed to the user and should be unchecked under preference as well$")
	public void the_should_not_be_displayed_to_the_user_and_should_be_unchecked_under_preference_as_well(String arg1)
			throws Throwable {
		if (preference_checkbox1 == false && replacement_not_show_updated == true) {
			login.Log4j
					.info("The " + arg1 + " is not displayed to the user and its unchecked under preference as well");
		} else {
			CommonFunctionality.DeleteSeries();
			sa.fail("Verification Failed");
		}
		CommonFunctionality.DeleteSeries();
	}

	@Then("^The Series \"([^\"]*)\" removed in search panel after done actions$")
	public void the_Series_removed_in_search_panel_after_done_actions(String arg1) throws Throwable {
		WebElement uncheck = login.driver
				.findElement(By.xpath("//*[contains(@class,'series-list-item--checkbox')]//ancestor::li[1]"));
		if (arg1.equalsIgnoreCase("has not")) {
			if (uncheck.getAttribute("class").contains("series-list-item__selected")) {
				login.Log4j.info("Selected series " + arg1 + " been removed");
			} else {
				CommonFunctionality.Views_list();
				sa.fail("Verification failed");
			}
			CommonFunctionality.wait(2000);
			CommonFunctionality.Views_list();
		} else if (arg1.equalsIgnoreCase("has")) {
			if (!(uncheck.getAttribute("class").contains("series-list-item__selected"))) {
				login.Log4j.info("Selected series " + arg1 + " been removed");
			} else {
				CommonFunctionality.Views_list();
				sa.fail("Verification failed");
			}
			CommonFunctionality.Views_list();
		}
	}

	@Then("^Pagination option \"([^\"]*)\" visible$")
	public void pagination_option_visible(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("should")) {
			if (preference_checkbox1 == false
					&& login.driver.findElements(By.className("search-series-pagination-count")).size() > 0) {
				login.Log4j.info(
						"Series tab is displayed with only number of series selected in the results per page dropdown");
			} else {
				sa.fail("Verification failed");
			}
			// CommonFunctionality.DeleteSeries();
		}
		if (arg1.equalsIgnoreCase("should not")) {
			if (preference_checkbox1 == true
					&& login.driver.findElements(By.className("search-series-pagination-count")).size() == 0) {
				login.Log4j.info("Series are displayed as list and more series can be viewed by scrolling bar");
			} else {
				sa.fail("Verification failed");
			}
			// CommonFunctionality.DeleteSeries();
		}
	}

	@Then("^The \"([^\"]*)\" action \"([^\"]*)\" possible$")
	public void the_action_possible(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement keyboard = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'list-view-wrapper')]", 4);
		if (arg2.equalsIgnoreCase("should")) {
			if (!(keyboard.getAttribute("class").contains("list-view-wrapper__empty-selection"))) {
				login.Log4j.info("The " + arg1 + " action " + arg2 + " possible");
			} else {
				CommonFunctionality.DeleteSeries();
				sa.fail("Verification Failed");
			}
		}
		if (arg2.equalsIgnoreCase("should not")) {
			if (keyboard.getAttribute("class").contains("list-view-wrapper__empty-selection")) {
				login.Log4j.info("The " + arg1 + " action " + arg2 + " possible");
			} else {
				CommonFunctionality.DeleteSeries();
				sa.fail("Verification Failed");
			}
		}
		CommonFunctionality.DeleteSeries();
	}

	@Then("^The \"([^\"]*)\" dialog box should open$")
	public void the_dialog_box_should_open(String arg1) throws Throwable {
		if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal-dialog')]//*[text()='" + arg1 + "']"))
				.size() > 0) {
			login.Log4j.info("The " + arg1 + " dialog box is opened and it has been verified");
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		} else {
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
			sa.fail("Verification Failed");
		}
	}

	@Then("^The \"([^\"]*)\" message in dialog box should display$")
	public void the_message_in_dialog_box_should_display(String arg1) throws Throwable {
		String description = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(@class,'api-manager--info__generated-key')]", 4)
				.getText();
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		assertEquals(arg1, description);
		login.Log4j.info("The " + arg1 + " description is displayed and it has been verified");
	}

	@Then("^The \"([^\"]*)\" dialog box should open and \"([^\"]*)\" is default$")
	public void the_dialog_box_should_open_and_is_default(String arg1, String arg2) throws Throwable {
		WebElement add_in = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'tabs__tab-item') and text()='" + arg2 + "']", 4);
		if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal-dialog')]//*[text()='" + arg1 + "']"))
				.size() > 0) {
			if (add_in.getAttribute("class").contains("active")) {
				login.Log4j.info("The " + arg2 + " tab is active by default");
			} else {
				CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
				sa.fail("Verification Failed");
			}
			login.Log4j.info("The " + arg1 + " dialog box is opened and it has been verified");
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		} else {
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
			sa.fail("Verification Failed");
		}
	}

	@Then("^Paste the token \"([^\"]*)\" to \"([^\"]*)\" button$")
	public void paste_the_token_to_button(String arg1, String arg2) throws Throwable {
		WebElement button = login.driver
				.findElement(By.xpath("//*[@class='api-manager--buttons']//*[text()='Verify Key ']"));
		existing_token = arg1;
		if (arg2.equalsIgnoreCase("Enable Verify Key")) {
			CommonFunctionality.getElementByClassName(login.driver, "api-manager--input", 4).sendKeys(existing_token);
			if (!(button.getAttribute("class").contains("disabled"))) {
				login.Log4j.info(
						"The token is pasted successfully and verified as the Verify key button has been enabled");
				CommonFunctionality.wait(2000);
				CommonFunctionality.getElementByClassName(login.driver, "api-manager--input", 4).clear();
				CommonFunctionality.wait(500);
				CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
			} else {
				CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
				sa.fail("Verification Failed");
			}
		}
		if (arg2.equalsIgnoreCase("Disable Verify Key")) {
			if (button.getAttribute("class").contains("disabled")) {
				login.Log4j.info("The Verify Key button has been disabled and its verified");
				CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
			} else {
				CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
				sa.fail("Verification Failed");
			}
		}
	}

	@Then("^The \"([^\"]*)\" message should come in \"([^\"]*)\" color$")
	public void the_message_should_come_in_color(String arg1, String arg2) throws Throwable {
		if (arg1.equalsIgnoreCase("The key is valid")) {
			String color = login.driver.findElement(By.className("api-manager--valid-message")).getCssValue("color");
			String hex = Color.fromString(color).asHex();
			login.Log4j.info("The key is valid and verified and success message is displaying in green color");
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
			assertEquals(arg2, hex);
		}
		if (arg1.equalsIgnoreCase("The key is invalid")) {
			String color = login.driver.findElement(By.className("api-manager--invalid-message")).getCssValue("color");
			String hex = Color.fromString(color).asHex();
			login.Log4j.info("The key is invalid and verified and error message is displaying in red color");
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
			assertEquals(arg2, hex);
		}
	}

	@Then("^The new token key should be generated$")
	public void the_new_token_key_should_be_generated() throws Throwable {
		WebElement copy = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='api-manager--copy-button']",
				4);
		if (copy.isDisplayed()) {
			login.Log4j.info("The new token key is generated and has been verified");
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		} else {
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
			sa.fail("Verification Failed");
		}
	}

	@Then("^Copied message should display$")
	public void copied_message_should_display() throws Throwable {
		if (login.driver
				.findElements(By.xpath("//*[@class='growl-messages-container']//*[@class='growl-message-text']"))
				.size() > 0) {
			login.Log4j.info("The API key copied message is displaying and has been verified");
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		} else {
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
			sa.fail("Verification Failed");
		}
	}

	@Then("^The \"([^\"]*)\" message should be displayed$")
	public void the_message_should_be_displayed(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("API key copied to clipboard")) {
			String expected = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='growl-messages-container']//*[@class='growl-message-text']", 4).getText();
			login.Log4j.info("The " + arg1 + " information is displaying after coping the new API key");
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
			assertEquals(arg1, expected);
		} else {
			String expected = CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='visual-series-panel--empty-message']", 4).getText();
			assertEquals(arg1, expected);
		}
	}

	@Then("^The description of CEIC API access popup should be \"([^\"]*)\"$")
	public void the_description_of_CEIC_API_access_popup_should_be(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);
		String description = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(@class,'api-manager--info__generated-key')]", 4)
				.getText();
		login.Log4j.info("The " + arg1 + " description is displaying after generating the new API key");
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		assertEquals(description, arg1);
	}

	@Then("^The default tab should be \"([^\"]*)\"$")
	public void the_default_tab_should_be(String arg1) throws Throwable {
		WebElement active = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'tabs__tab-item') and text()='" + arg1 + "']", 4);
		if (active.getAttribute("class").contains("active")) {
			login.Log4j.info("The active tab is " + arg1 + " by default");
		} else {
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
			sa.fail("Verification Failed");
		}
		try {
			CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='sphere-modal__close'])[2]", 4).click();
		} catch (Exception e) {
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		}
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
	}

	@Then("^The popup should be cancelled$")
	public void the_popup_should_be_cancelled() throws Throwable {
		if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal__content')]")).size() == 0) {
			login.Log4j.info("The popup is closed and its verified");
		} else {
			fail("Verification Failed");
		}
	}

	@Then("^Preference dropdown should be closed$")
	public void preference_dropdown_should_be_closed() throws Throwable {
		CommonFunctionality.wait(2000);
		if (login.driver.findElements(By.className("account-popup")).size() == 0) {
			login.Log4j.info("The preference drop down is closed and its verified");
		} else {
			fail("Verification Failed");
		}
	}

	@Then("^The application should be logged out$")
	public void the_application_should_be_logged_out() throws Throwable {
		if (login.driver.findElements(By.xpath("//h2[@class='content-block-header' and text()='Registered user']"))
				.size() > 0) {
			login.Log4j.info("The application is logged out and its verified");
		} else {
			fail("Verification Failed");
		}
	}

	@Then("^Open the link in a new tab and verify$")
	public void open_the_link_in_a_new_tab_and_verify() throws Throwable {
		String API_URL = "https://api-stage.ceicdata.com/stage/series/387188357?format=json&token=" + final_api;
		((JavascriptExecutor) login.driver).executeScript("window.open('" + API_URL + "')");
		CommonFunctionality.wait(2000);
		// ----------------- Code for reading data from json format -----------------
		URL link = new URL(API_URL);
		String readLine = null;
		HttpURLConnection conection = (HttpURLConnection) link.openConnection();
		conection.setRequestMethod("GET");
		conection.connect();
		int responseCode = conection.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader br = new BufferedReader(new InputStreamReader(conection.getInputStream()));
			StringBuffer response = new StringBuffer();
			while ((readLine = br.readLine()) != null) {
				response.append(readLine);
			}
			br.close();
			String data = response.toString();
			// ------------------- Till Here -----------------------------------------
			if (data.contains("387188357") && responseCode == 200) {
				login.Log4j.info(
						"The new generated API key is copied to clipboard and parsing it to the given url and has been verified successfully");
			} else {
				sa.fail("Verification failed");
			}
			ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
			login.driver.switchTo().window(newTab.get(1)).close();
			CommonFunctionality.wait(2000);
			login.driver.switchTo().window(newTab.get(0));
			CommonFunctionality.wait(2000);
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		}
	}

	@Then("^\"([^\"]*)\" popup should be displayed$")
	public void popup_should_be_displayed(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase(preference_popup)) {
			login.Log4j
					.info(arg1 + " title in the popup is displayed inside preferences option and it has been verified");
		} else if (arg1.equals("The function cannot be applied to selected series")) {
			String popupTxt_for_invalidFunc = CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='modal-title sphere-modal__title text-dots']", 30)
					.getText();
			if (popupTxt_for_invalidFunc.equalsIgnoreCase(arg1)) {
				login.Log4j.info("Verification pass");
				CommonFunctionality
						.getElementByXpath(login.driver,
								"//*[@class='modal-window modal-window__active']//*[@class='sphere-modal__close']", 20)
						.click();
			} else {
				fail("Verification Failed");
			}
		} else if (arg1.equalsIgnoreCase("Still cannot find an answer?")) {
			String cant_find_ans_popup = CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='modal-title sphere-modal__title text-dots']", 30)
					.getText();
			if (cant_find_ans_popup.equalsIgnoreCase(arg1)) {
				login.Log4j.info("Still cannot find an answer? popUp is displayed");
				CommonFunctionality
						.getElementByXpath(login.driver,
								"//*[@class='modal-window modal-window__active']//*[@class='sphere-modal__close']", 20)
						.click();
			} else {
				fail("Verification Failed");
			}
		} else if (arg1.equals("Copyright")) {
			String copy_right = CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='popover--wrapper']//*[@class='popover--title']", 30)
					.getText();
			if (copy_right.equalsIgnoreCase(arg1)) {
				login.Log4j.info("Copyright popUp is displayed");
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='popover--wrapper']//*[@class='popover--close']", 20).click();
			} else {
				fail("Verification Failed");
			}
		} else {
			fail("Verification Failed");
		}
	}

	@Then("^Tooltips should display for each functions methods$")
	public void tooltips_should_display_for_each_functions_methods() throws Throwable {
		for (int i = 0; i < functions.size(); i++) {
			new Actions(login.driver).pause(500).moveToElement(functions.get(i)).build().perform();
			CommonFunctionality.wait(300);
			if (login.driver.findElement(By.xpath("//div[@class='tooltip tooltip__visible']")).isDisplayed()) {
				login.Log4j.info("tooltip is displayed for function : " + functions.get(i).getText());
			} else {
				fail("tooltip is not displayed for function: " + functions.get(i).getText());
			}

		}
	}
}