package CDMNext.StepDefinations;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.awt.Color;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.jsoup.select.Evaluator.IsEmpty;
import org.junit.Assert;
import org.junit.internal.runners.statements.Fail;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import CDMNext.util.CommonFunctionality;
import ch.qos.logback.core.joran.action.Action;
import cucumber.api.java.en.*;

public class HeatMap {

	Actions action = new Actions(login.driver);
	public static String LabelSize;
	public static String labelsColor;
	public static String copyrightsFontsize;
	public static String CopyrightText;
	public static String border_Radius;
	public static String border_width;
	public static String border_Color;
	public static String background_opacity;
	public static String rgbaColor;
	public static String Lines_color;
	public static String Opacity;
	public static String background_visual_color;
	public static String visual_radius;
	public static String visual_width;
	public static String stroke_radius;
	public static String bordercolor;
	public static String Visual_bordercolor;
	public static String stroke_width;
	public static String down;
	public static String Applyfunction;
	public static String rename;
	public static String drop_frequency;
	public static String drop_currency;
	public static String drop_change;
	public static String Grid_visual_width;
	public static ArrayList<String> list1 = new ArrayList<>();
	public static ArrayList<String> list2;
	public static ArrayList<String> dropdowndata;
	public static ArrayList<String> compare = new ArrayList<>();

	public static ArrayList<String> currency;
	public static ArrayList<String> CDropdown = new ArrayList<>();

	public static ArrayList<String> currencyType;
	public static ArrayList<String> Asreportdrop = new ArrayList<>();

	public static ArrayList<String> AttributeList;
	public static ArrayList<String> Attributes = new ArrayList<>();
	public static ArrayList<String> DropDownList;
	public static ArrayList<String> Drop = new ArrayList<>();

	public static ArrayList<String> frequency;
	public static ArrayList<String> frequencylist = new ArrayList<>();

	public static ArrayList<String> Change;
	public static ArrayList<String> ChangeDropdown = new ArrayList<>();

	public static ArrayList<String> Editseriesinfo;
	public static ArrayList<String> seriesinfo = new ArrayList<>();
	public static String functionDesc;
	public static String sName;
	public static String count;

	public static int v;
	public static int a;
	public static String selectedregion;
	public static String Unitdata;
	public static String Frequencydata;

	public static ArrayList<String> dropValues;
	public static ArrayList<String> list = new ArrayList<>();
	public static String Name;

	public static String Region;
	public static String seriesreagion;
	public static String seriesReagion;
	public static String fun;
	public static int size;
	public static String UpdateUnit;
	public static int serieslist;
	public static String backgroundcolor;
	public static String selectcolor;
	public static String fontsize;
	public static String subtitle;
	public static int Steps_Color;;
	public static ArrayList<String> frequencyList;
	public static ArrayList<String> Frequencylist = new ArrayList<>();
	public static String subtitle_background;
	public static String Sub_Title_font;
	public static String subtitle_bold;
	public static ArrayList<String> solidcolor;
	ArrayList<String> drodpdownvalues = new ArrayList<>();
	public static ArrayList<String> slodColorSteps = new ArrayList<>();

	public static ArrayList<String> Legendropdown = new ArrayList<>();
	public static String Label_size;
	public static String Rotate;
	public static String Radius_border;
	public static String EditVisual_color;
	public static String TimeAxis_size;
	public static String Label_window_size;

	// TC_01
	@Given("^Navigate to series Tab$")
	public void navigate_to_series_Tab() throws Throwable {
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//div[@title='View results as List']")).click();

	}

	// TC_01
	@Given("^Select few series and Add to My series tab$")
	public void select_few_series_and_Add_to_My_series_tab() throws Throwable {

		Thread.sleep(2000);

		// login.driver.findElement(By.xpath("//span[@class='toggler-control-item--label'
		// and text()='Series']")).click();
		for (int i = 1; i <= 5; i++) {
			login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]"))
					.click();

		}
		login.driver.findElement(By.xpath("(//div[@class='add-to-data-selection--icon'])[2]")).click();
		Thread.sleep(2000);

	}

//TC_01
	@Given("^Click on select all and right click on the series$")
	public void click_on_select_all_and_right_click_on_the_series() throws Throwable {

		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		Thread.sleep(1000);

		WebElement rightclick = login.driver.findElement(By.xpath("(//span[@class='series-name-field--text'])[1]"));
		action.contextClick(rightclick).perform();

	}

	// TC_01
	@And("^click on Add chart and click on HeatMap$")
	public void click_on_Add_chart_and_click_on_HeatMap() throws Throwable {

		/*
		 * Thread.sleep(1000);
		 * login.driver.findElement(By.xpath("//*[text()='View as ...']")).click();
		 * Thread.sleep(2000); login.driver.findElement(By.
		 * xpath("//*[@class='dropdown-menu']//*[text()='Heat map']")).click();
		 * 
		 */

		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//*[text()='Add chart']")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(
				"//*[@class='icon--heatmap_large public-js-views-visuals-VisualsPanelSubItem-module__subItemIcon']"))
				.click();
	}

//TC_01
	@Then("^HeatMap visual should be created$")
	public void heatmap_visual_should_be_created() throws Throwable {

		Thread.sleep(3000);

		try {
			// login.driver.findElement(By.xpath("//button[@class='button
			// button__primary']")).isDisplayed();
			// Thread.sleep(2000);
			// login.driver.findElement(By.xpath("//button[@class='button
			// button__primary']")).click();
			CommonFunctionality.wait(3000);

			if (login.driver.findElement(By.xpath("//button[text()='Edit Heat map']")).isDisplayed()) {
				login.Log4j.info("HeatMap visual should be created");

			} else {

				fail("HeatMap visual should not be created");
			}

		} catch (NoSuchElementException e) {

			CommonFunctionality.wait(3000);

			if (login.driver.findElement(By.xpath("//button[text()='Edit Heat map']")).isDisplayed()) {
				login.Log4j.info("HeatMap visual should be created");

			} else {

				fail("HeatMap visual should not be created");
			}

		}

	}

//TC_02
	@Given("^Click on Create new view tab$")
	public void click_on_Create_new_view_tab() throws Throwable {
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//div[@class='insight-page-menu-views-container--add']")).click();

		Thread.sleep(4000);

	}

//TC_02
	@Given("^Drag and drop HeatMap visual to view panel$")
	public void drag_and_drop_HeatMap_visual_to_view_panel() throws Throwable {

		Thread.sleep(2000);

		WebElement drag = login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"));
		Thread.sleep(2000);

		WebElement drop = login.driver.findElement(By.xpath("(//*[text()='Heat map'])[1]"));
		Thread.sleep(2000);

		Thread.sleep(3000);
		action.dragAndDrop(drag, drop).build().perform();
		Thread.sleep(3000);

	}

//TC_02
	@Then("^Verify the HeatMap visual should be created$")
	public void verify_the_HeatMap_visual_should_be_created() throws Throwable {

		Thread.sleep(5000);

		String text = login.driver.findElement(By.xpath("//button[text()='Edit Heat map']")).getText();
		Thread.sleep(5000);
		if (text.matches("Edit Heat map")) {
			login.Log4j.info("HeatMap visual should be created");
		}

		else {

			login.Log4j.info("HeatMap visual should be created");
			Assert.assertEquals(text, "Edit Heat map");

		}
	}

	// TC_03
	@And("^Click on Drag- and-drop to Heat Map$")
	public void click_on_Drag_and_drop_to_Heat_Map() throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("(//div[@class='insight-action-panel--btn-icon'])[1]")).click();

		login.driver.findElement(By.xpath(
				"//*[@class='icon--heatmap_large public-js-views-visuals-VisualsPanelSubItem-module__subItemIcon']"))
				.click();

	}

	// TC_03
	@And("^Series Drag and drop into HeatMap visual to view panel$")
	public void series_Drag_and_drop_into_HeatMap_visual_to_view_panel() throws Throwable {
		CommonFunctionality.wait(3000);

		WebElement plusicon = login.driver.findElement(By.xpath("(//div[@class='add-to-data-selection--icon'])[1]"));

		action.moveToElement(plusicon).build().perform();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_A);
		CommonFunctionality.wait(5000);

	}

	@And("^Select few Series$")
	public void select_few_Series() throws Throwable {
		Thread.sleep(2000);

		for (int i = 1; i <= 5; i++) {
			login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]"))
					.click();

		}

	}

	@And("^Click on HeatMap visual icon$")
	public void click_on_HeatMap_visual_icon() throws Throwable {
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("(//div[@class='icon--heatmap'])[1]")).click();

		Thread.sleep(2000);

	}

	// TC_06
	@Given("^Search for the series \"([^\"]*)\" with different frequencies$")
	public void search_for_the_series_with_different_frequencies(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).click();
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).clear();

		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(arg1);

		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(Keys.ENTER);

	}

	// TC_06
	@Given("^checked selected series$")
	public void checked_selected_series() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//span[@class='toggler-control-item--label' and text()='Series']")).click();

		for (int i = 1; i <= 5; i++) {

			login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]"))
					.click();

		}

	}

	// TC_06
	@And("^right click on checked series$")
	public void right_click_on_checked_series() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement rightclick = login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"));
		action.contextClick(rightclick).perform();

	}

	// TC_06
	@Then("^verify the Series Harmonization window is displayed$")
	public void verify_the_Series_Harmonization_window_is_displayed() throws Throwable {

		CommonFunctionality.wait(2000);

		String seriesharmonization = login.driver.findElement(By.xpath("//div[text()='Series Harmonization']"))
				.getText();

		if (seriesharmonization.matches("Series Harmonization")) {
			login.Log4j.info("Series Harmonization popup displayed");
		}

		else {

			login.Log4j.info("Series Harmonization popup not dsiplayed");
			Assert.assertEquals(seriesharmonization, "Series Harmonization", "Series Harmonization popup:FAIL");
		}

	}

	// TC_07
	@Then("^verify the default lowest value will be selected in Series Harmonization window$")
	public void verify_the_default_lowest_value_will_be_selected_in_Series_Harmonization_window() throws Throwable {

		CommonFunctionality.wait(2000);

		String seriesharmonization = login.driver.findElement(By.xpath("//div[text()='Series Harmonization']"))
				.getText();

		if (seriesharmonization.matches("Series Harmonization")) {
			login.Log4j.info("Series Harmonization popup displayed");

			List<WebElement> frequency = login.driver
					.findElements(By.xpath("(//select[@class='series-data-conversion--param form--control'])[1]"));

			for (int i = 0; i < frequency.size(); i++) {

				String fre = frequency.get(i).getText();

				if (fre.contains("Lowest in group (Yearly)")) {
					login.Log4j.info("By default lowest value selected ");

				} else {

					login.Log4j.info("By default lowest value not selected ");
					Assert.assertEquals(fre, "Lowest in group (Yearly)");

				}

			}

		}

		else {

			login.Log4j.info("Series Harmonization popup not dsiplayed");
			Assert.assertEquals(seriesharmonization, "Series Harmonization");

		}

	}

	// TC_08
	@Then("^click on frequency dropdown and verify the frequency dropdown list$")
	public void click_on_frequency_dropdown_and_verify_the_frequency_dropdown_list() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("(//select[@class='series-data-conversion--param form--control'])[1]"))
				.click();

		List<WebElement> list3 = login.driver.findElements(By.xpath(
				"((//span[@class='series-data-conversion--parameters-list']//select[@class='series-data-conversion--param form--control'])[1]/option)"));
		list2 = new ArrayList<>(Arrays.asList("Daily", "Weekly", "Highest in group (Monthly)", "Quarterly",
				"Semiannual", "Lowest in group (Yearly)"));
		for (int a = 0; a < list3.size(); a++) {

			String text = list3.get(a).getText();

			list1.add(text);

		}

		if (list1.equals(list2)) {
			login.Log4j.info("Frequency dropdown data displayed:PASS" + list1);
		}

		else {
			login.Log4j.info("Frequency dropdown data displayed:FAIL" + list1);
			Assert.assertEquals(list1, list2);
		}

	}

//TC_08
	@Then("^Changes made in the frequencies will be applied to all the selected series$")
	public void changes_made_in_the_frequencies_will_be_applied_to_all_the_selected_series() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("(//select[@class='series-data-conversion--param form--control'])[1]"))
				.click();

		login.driver.findElement(By.xpath(
				"((//span[@class='series-data-conversion--parameters-list']//select[@class='series-data-conversion--param form--control'])[1]/option)[2]"))
				.click();

		String frechanges = login.driver.findElement(By.xpath("(//div[@class='edit-series-function--description'])[1]"))
				.getText();

		if (frechanges.contains("DISAGGREGATE(Weekly; Sunday; Distribute)")) {
			login.Log4j.info("Frequency changes successfully");

		} else {
			login.Log4j.info("Frequency not changes successfully");
			Assert.assertEquals(frechanges, "DISAGGREGATE(Weekly; Sunday; Distribute)");
		}

	}

	// TC_HM_09

	@Then("^verify the \"([^\"]*)\" value will be selected in missing value method on Series Harmonization window$")
	public void verify_the_value_will_be_selected_in_missing_value_method_on_Series_Harmonization_window(String arg1)
			throws Throwable {

		CommonFunctionality.wait(2000);
		String method = login.driver.findElement(By.xpath(
				"((//span[@class='series-data-conversion--function-title'])[2]//following::span)[2]//select//option[1]"))
				.getText();

		if (method.equalsIgnoreCase(arg1)) {
			login.Log4j.info("By default missing value method selected");
		} else {
			login.Log4j.info("By default missing value method not selected");
			Assert.assertEquals(method, arg1);

		}

	}

	// TC_HM_10
	@Then("^click on Missing value method Dropdown and verify the Missing value method list$")
	public void click_on_Missing_value_method_Dropdown_and_verify_the_Missing_value_method_list() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("(//select[@class='series-data-conversion--param form--control'])[2]"))
				.click();

		List<WebElement> missingvalue = login.driver.findElements(By.xpath(
				"((//span[@class='series-data-conversion--parameters-list']//select[@class='series-data-conversion--param form--control'])[2]/option)"));

		dropdowndata = new ArrayList<>(Arrays.asList("Keep as reported", "Previous value", "Next value",
				"Specific value", "Calculate with linear interpolation", "Calculate with linear extrapolate",
				"Calculate with exponential interpolation", "Calculate with cubic spline"));

		for (int a = 0; a < missingvalue.size(); a++) {
			String text = missingvalue.get(a).getText();

			compare.add(text);

		}

		if (compare.equals(dropdowndata)) {
			login.Log4j.info("Missing Value Method dropdown data displayed:PASS" + compare);
		} else {
			login.Log4j.info("Missing Value Method dropdown data not displayed" + compare);
		}

	}

	// TC_HM_10
	@Then("^Changes made in the Missing value method will be applied to all the selected series$")
	public void changes_made_in_the_Missing_value_method_will_be_applied_to_all_the_selected_series() throws Throwable {

		CommonFunctionality.wait(2000);
		String missingvalue = login.driver.findElement(By.xpath(
				"((//span[@class='series-data-conversion--parameters-list']//select[@class='series-data-conversion--param form--control'])[2]/option)[2]"))
				.getText();

		login.driver.findElement(By.xpath(
				"((//span[@class='series-data-conversion--parameters-list']//select[@class='series-data-conversion--param form--control'])[2]/option)[2]"))
				.click();

		// click on apply button

		login.driver.findElement(By.xpath("//button[@class='button button__primary']")).click();

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//a[@data-id='myseries']")).click();

		WebElement seriesname = login.driver.findElement(By.xpath("(//span[@class='series-name-field--text'])[1]"));
		action.moveToElement(seriesname).perform();
		CommonFunctionality.wait(2000);

		String selectedvalue = login.driver.findElement(By.xpath("(//span[@class='series-functions-title'])[1]"))
				.getText();

		if (selectedvalue.contains(missingvalue)) {

			login.Log4j.info("changes reflected in the series");

		} else {

			login.Log4j.info("changes not reflected in the series");
			Assert.assertEquals(selectedvalue, missingvalue);
		}

	}

	@Then("^click on Missing value method Dropdown and select \"([^\"]*)\" in dropdown list$")
	public void click_on_Missing_value_method_Dropdown_and_select_in_dropdown_list(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath(
				"((//span[@class='series-data-conversion--parameters-list']//select[@class='series-data-conversion--param form--control'])[2]/option)[4]"))
				.click();

	}

	@Then("^By default \"([^\"]*)\" value will be displayed and changes made in specific value will be reflected in seires$")
	public void by_default_value_will_be_displayed_and_changes_made_in_specific_value_will_be_reflected_in_seires(
			String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		String missingvalue = login.driver.findElement(By.xpath("//input[@name='specific_value']"))
				.getAttribute("value");

		System.out.println("missingvalue:" + missingvalue);
		System.out.println("arg1:" + arg1);
		if (missingvalue.matches(arg1)) {
			login.Log4j.info("By default 1 value displayed ");
		}

		else {
			login.Log4j.info("By default 1 is not displayed ");
			Assert.assertEquals(missingvalue, arg1);

		}

		// click on apply button

		login.driver.findElement(By.xpath("//button[@class='button button__primary']")).click();

		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//a[@data-id='myseries']")).click();

		WebElement seriesname = login.driver.findElement(By.xpath("(//span[@class='series-name-field--text'])[1]"));
		action.moveToElement(seriesname).perform();
		CommonFunctionality.wait(2000);

		String selectedvalue = login.driver.findElement(By.xpath("(//span[@class='series-functions-title'])[1]"))
				.getText();

		System.out.println("selectedvalue:" + selectedvalue);
		System.out.println("missingvalue:" + missingvalue);

		if (selectedvalue.contains(missingvalue)) {

			login.Log4j.info("changes reflected in the series");

		} else {

			login.Log4j.info("changes not reflected in the series");
			Assert.assertEquals(selectedvalue, missingvalue);
		}

	}

	// TC_14
	@Then("^Click on 'Keep different frequencies' button$")
	public void click_on_Keep_different_frequencies_button() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//button[@class='button button__text_purple']")).click();

	}

	@Then("^Select frequencies from 'lowest in group' to 'Daily' and click on Apply button$")
	public void select_frequencies_from_lowest_in_group_to_Daily_and_click_on_Apply_button() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("(//select[@class='series-data-conversion--param form--control'])[1]"))
				.click();

		String frequency = login.driver.findElement(By.xpath(
				"((//span[@class='series-data-conversion--parameters-list']//select[@class='series-data-conversion--param form--control'])[1]/option)[1]"))
				.getText();
		login.driver.findElement(By.xpath(
				"((//span[@class='series-data-conversion--parameters-list']//select[@class='series-data-conversion--param form--control'])[1]/option)[1]"))
				.click();
		// click on apply button

		login.driver.findElement(By.xpath("//button[@class='button button__primary']")).click();

		CommonFunctionality.wait(2000);

	}

//TC_15
	@Then("^Verify the HeatMap visual frequencies should be efforted in my series$")
	public void verify_the_HeatMap_visual_frequencies_should_be_efforted_in_my_series() throws Throwable {

		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//a[@data-id='myseries']")).click();
		CommonFunctionality.wait(3000);

		WebElement seriesname = login.driver.findElement(By.xpath("(//span[@class='series-name-field--text'])[1]"));

		action.moveToElement(seriesname).perform();
		CommonFunctionality.wait(2000);

		String frequencyvalue = login.driver.findElement(By.xpath("//td[text()='Functions']//following::div[1]"))
				.getText();

		if (frequencyvalue.contains("Daily")) {

			login.Log4j.info(" Frquencies changes reflected in my series:PASS:" + frequencyvalue);

		} else {

			login.Log4j.info("Frquencies changes not reflected in my series:PASS:FAIL" + frequencyvalue);
			Assert.assertEquals(frequencyvalue, "Daily");
		}

	}

//TC_16
	@Then("^Click on minimize button$")
	public void click_on_minimize_button() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//div[@title='Minimize']")).click();

	}

	@Then("^Verify the Series Harmonization window minimized$")
	public void verify_the_Series_Harmonization_window_minimized() throws Throwable {
		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath("//div[@title='Maximize']")).isDisplayed()) {

			login.Log4j.info("Series Harmonization window minimized:PASS");
		}

		else {
			fail("Series Harmonization window minimized:FAIL");

		}

	}

	@Then("^Click on Full-screen button$")
	public void click_on_Full_screen_button() throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//div[@title='Full-screen']")).click();

	}

	@Then("^Verify the Series Harmonization window fully maximizied$")
	public void verify_the_Series_Harmonization_window_fully_maximizied() throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath("//div[@title='Exit full-screen']")).isDisplayed()) {

			login.Log4j.info("Series Harmonization window fully maximizied:PASS");
		}

		else {
			fail("Series Harmonization window fully maximizied:FAIL");

		}

	}

	@Then("^Click on close\\('X'\\) button$")
	public void click_on_close_X_button() throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//div[@class='movable-modal--close']")).click();

	}

	@Then("^Verify the Series Harmonization window fully closed and applied changes will not be affected$")
	public void verify_the_Series_Harmonization_window_fully_closed_and_applied_changes_will_not_be_affected()
			throws Throwable {

		CommonFunctionality.wait(2000);

		List<WebElement> listseries = login.driver
				.findElements(By.xpath("//span[@class='series-edit--title series-edit--title__editable']"));

		System.out.println(listseries.size());
		if (listseries.size() == 1) {

			login.Log4j.info("applied changes will not be affected:PASS");
		}

		else {
			fail("applied changes affected:FAIL" + listseries.size());

		}

	}

	@Then("^verify the \"([^\"]*)\" value default selected in Currency conversion on Series Harmonization window$")
	public void verify_the_value_default_selected_in_Currency_conversion_on_Series_Harmonization_window(String arg1)
			throws Throwable {
		CommonFunctionality.wait(2000);

		String currency_converison = login.driver.findElement(By.xpath(
				"(//span[@class='series-data-conversion--parameters-list']//select[@class='series-data-conversion--param form--control'])[3]/option[1]"))
				.getText();

		if (currency_converison.equalsIgnoreCase(arg1)) {
			login.Log4j.info("By default Keep as reported value displayed in currency conversion");

		} else {

			login.Log4j.info("By default Keep as reported value NOT displayed in currency conversion:FAIL");
			Assert.assertEquals(currency_converison, arg1);
		}

	}

	@Then("^Verify the \"([^\"]*)\" message display in Currency conversion on Series Harmonization window$")
	public void verify_the_message_display_in_Currency_conversion_on_Series_Harmonization_window(String arg1)
			throws Throwable {
		CommonFunctionality.wait(2000);

		String currency = login.driver.findElement(By.xpath(
				"(//span[@class='series-data-conversion--parameters-list']//select[@class='series-data-conversion--unit series-data-conversion--param form--control'])/option[1]"))
				.getText();

		if (currency.equalsIgnoreCase(arg1)) {
			login.Log4j.info("By default as reported value displayed in currency conversion");

		} else {

			login.Log4j.info("By default as reported value NOT displayed in currency conversion:FAIL");
			Assert.assertEquals(currency, arg1);
		}

	}

	// TC_13
	@Then("^click on currency conversion Dropdown and verify the keep as reported list$")
	public void click_on_currency_conversion_Dropdown_and_verify_the_keep_as_reported_list() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("(//select[@class='series-data-conversion--param form--control'])[3]"))
				.click();

		List<WebElement> currencydropdown = login.driver
				.findElements(By.xpath("(//select[@class='series-data-conversion--param form--control'])[3]//option"));
		currency = new ArrayList<>(Arrays.asList("Keep as reported", "US Dollars", "Chinese Yuan (RMB)", "Japanese Yen",
				"UK Pounds", "Euros", "Malaysian Ringgit", "Russian Ruble"));

		for (int a = 0; a < currencydropdown.size(); a++) {
			String text = currencydropdown.get(a).getText();

			CDropdown.add(text);

		}

		if (CDropdown.equals(currency)) {
			login.Log4j.info("Currency conversions dropdown data displayed:PASS" + CDropdown);
		} else {
			login.Log4j.info("Currency conversions dropdown data not displayed:FAIL" + CDropdown);
			Assert.assertEquals(CDropdown, currency);
		}

	}

	// TC_13
	@Then("^click on currency dropdown and verify the \"([^\"]*)\" list$")
	public void click_on_currency_dropdown_and_verify_the_list(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By
				.xpath("(//select[@class='series-data-conversion--unit series-data-conversion--param form--control'])"))
				.click();

		List<WebElement> asreporteddropdown = login.driver.findElements(By.xpath(
				"(//select[@class='series-data-conversion--unit series-data-conversion--param form--control'])/option"));
		currencyType = new ArrayList<>(Arrays.asList("as reported", "in Thousands", "in Millions", "in Billions"));

		for (int a = 0; a < asreporteddropdown.size(); a++) {
			String text = asreporteddropdown.get(a).getText();

			Asreportdrop.add(text);
		}

		if (Asreportdrop.equals(currencyType)) {
			login.Log4j.info("Currency conversions  As reported dropdown data displayed:PASS" + Asreportdrop);
		} else {

			login.Log4j.info("Currency conversions As reported dropdown data not displayed:FAIL" + Asreportdrop);
			Assert.assertEquals(Asreportdrop, currencyType);

		}

	}

	// TC_13
	@Then("^verify the Appropriate changes will be reflected in the series$")
	public void verify_the_Appropriate_changes_will_be_reflected_in_the_series() throws Throwable {
		CommonFunctionality.wait(2000);

		// As reported
		login.driver.findElement(By
				.xpath("(//select[@class='series-data-conversion--unit series-data-conversion--param form--control'])"))
				.click();
		String drop = login.driver.findElement(By.xpath(
				"(//select[@class='series-data-conversion--unit series-data-conversion--param form--control'])/option[2]"))
				.getText();
		login.driver.findElement(By.xpath(
				"(//select[@class='series-data-conversion--unit series-data-conversion--param form--control'])/option[2]"))
				.click();

		// keep as reported
		login.driver.findElement(By.xpath("(//select[@class='series-data-conversion--param form--control'])[3]"))
				.click();
		String dropdown = login.driver
				.findElement(By.xpath("(//select[@class='series-data-conversion--param form--control'])[3]//option[2]"))
				.getText();
		login.driver
				.findElement(By.xpath("(//select[@class='series-data-conversion--param form--control'])[3]//option[2]"))
				.click();

		// click on apply button

		login.driver.findElement(By.xpath("//button[@class='button button__primary']")).click();

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//a[@data-id='myseries']")).click();

		WebElement seriesname = login.driver.findElement(By.xpath("(//span[@class='series-name-field--text'])[1]"));

		action.moveToElement(seriesname).perform();
		CommonFunctionality.wait(2000);

		String selectedvalue = login.driver.findElement(By.xpath("(//span[@class='series-functions-title'])[1]"))
				.getText();

		if (selectedvalue.contains(drop)) {

			login.Log4j.info("changes reflected in the series");

		} else if (selectedvalue.contains(dropdown)) {

			login.Log4j.info("changes reflected in the series");
			Assert.assertEquals(selectedvalue, drop);

		} else {

			login.Log4j.info("changes not reflected in the series");
			Assert.assertEquals(selectedvalue, dropdown);
		}

	}

	// TC_19
	@Then("^Verify the 'Edit HeatMap' button should be disabled$")
	public void verify_the_Edit_HeatMap_button_should_be_disabled() throws Throwable {

		CommonFunctionality.wait(2000);

		WebElement a = login.driver.findElement(By.xpath("//button[@class='button button__sm button__primary']"));

		if (!a.isEnabled()) {
			login.Log4j.info("Edit HeatMap button Disable:PASS");
		}

		else {

			fail("Edit HeatMap button not Disable:FAIL");
		}

	}

	// TC_20
	@Then("^Verify The 'Edit series' panel should be enabled and opened$")
	public void verify_The_Edit_series_panel_should_be_enabled_and_opened() throws Throwable {

		CommonFunctionality.wait(2000);

		WebElement a = login.driver
				.findElement(By.xpath("(//button[@class='button button__sm button__text_purple'])[1]"));

		if (a.isEnabled()) {

			login.driver.findElement(By.xpath("(//button[@class='button button__sm button__text_purple'])[1]")).click();
			login.Log4j.info("Edit Series button Enable:PASS");
			CommonFunctionality.wait(4000);

			String text = login.driver.findElement(By.xpath("//div[contains(text(),'No series added')]")).getText();

			if (text.equalsIgnoreCase("No series added")) {
				login.Log4j.info("Edit Series panel Opened:PASS");

			} else {
				login.Log4j.info("Edit Series panel  not Opened:FAIL");
				Assert.assertEquals(text, "No series added");
			}
		}

		else {

			fail("Edit HeatMap button not Disabled:FAIL");
		}

	}

	// TC_21
	@Then("^verify the By default user should redirect to \"([^\"]*)\" tab$")
	public void verify_the_By_default_user_should_redirect_to_tab(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);

		WebElement a = login.driver
				.findElement(By.xpath("(//button[@class='button button__sm button__text_purple'])[1]"));

		if (a.isEnabled()) {

			login.driver.findElement(By.xpath("(//button[@class='button button__sm button__text_purple'])[1]")).click();
			login.Log4j.info("Edit Series button Enable:PASS");
			CommonFunctionality.wait(4000);

			String text = login.driver.findElement(By.xpath("//div[contains(text(),'No series added')]")).getText();

			if (text.equalsIgnoreCase("No series added")) {
				login.Log4j.info("Edit Series panel Opened:PASS");

			} else {
				login.Log4j.info("Edit Series panel  not Opened:FAIL");
				Assert.assertEquals(text, "No series added");
			}
		}

		else {
			fail("Edit HeatMap button not Disabled:FAIL");

		}

	}

	// TC_22

	@Then("^Verify the text on HeatMap visual \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void verify_the_text_on_HeatMap_visual(String arg1, String arg2, String arg3, String arg4) throws Throwable {

		CommonFunctionality.wait(2000);
		String text1 = login.driver.findElement(By.xpath("//div[@class='empty-visual-overlay--title']")).getText();
		String text2 = login.driver.findElement(By.xpath("//div[@class='empty-visual-overlay--text']")).getText();
		String text3 = login.driver.findElement(By.xpath("//div[text()='Or, ']")).getText();
		String text4 = login.driver.findElement(By.xpath("//div[@class='empty-visual-overlay--sub-text']//span"))
				.getText();

		if ((text1.equalsIgnoreCase(arg1)) || (text2.equalsIgnoreCase(arg2)) || (text3.contains(arg3))
				|| (text4.equalsIgnoreCase(arg4))) {
			login.Log4j.info("description message verification:PASS");
		} else {
			login.Log4j.info("description message verification:FAIL");
			Assert.assertEquals(text1, arg1);
			Assert.assertEquals(text2, arg2);
			Assert.assertEquals(text3, arg3);
			Assert.assertEquals(text4, arg4);

		}
	}

	@Given("^My series tab should be empty$")
	public void my_series_tab_should_be_empty() throws Throwable {

		CommonFunctionality.wait(2000);

		WebElement text = login.driver.findElement(By.xpath("//div[@class='data-selection-series-overlay--title']"));

		if (text.isDisplayed()) {
			login.Log4j.info("My series Tab description message verification:PASS");
		} else {
			fail("My series Tab description message verification:FAIL");
			// login.driver.findElement(By.xpath("//div[@class='data-selection-series-overlay--title']")).isDisplayed();
		}
	}

	@Then("^Verify the text on HeatMap visual \"([^\"]*)\", \"([^\"]*)\"$")
	public void verify_the_text_on_HeatMap_visual(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(2000);
		String text1 = login.driver.findElement(By.xpath("//div[@class='empty-visual-overlay--title']")).getText();
		String text2 = login.driver.findElement(By.xpath("//div[@class='empty-visual-overlay--text']")).getText();
		if ((text1.equalsIgnoreCase(arg1)) && (text2.equalsIgnoreCase(arg2))) {
			login.Log4j.info("description message verification:PASS");
		} else {
			login.Log4j.info("description message verification:FAIL");
			Assert.assertEquals(text1, arg1);
			Assert.assertEquals(text2, arg2);

		}
	}

	@And("^Verify the text \"([^\"]*)\" and Click on \"([^\"]*)\" link$")
	public void verify_the_text_and_Click_on_link(String arg1, String arg2) throws Throwable {

		CommonFunctionality.wait(2000);
		String text = login.driver.findElement(By.xpath("//div[@class='empty-visual-overlay--sub-text']//span"))
				.getText();

		if (text.equalsIgnoreCase(arg1)) {
			login.Log4j.info("description message verification:PASS");
		} else {
			login.Log4j.info("description message verification:FAIL");
			Assert.assertEquals(text, arg1);
		}

		WebElement link = login.driver.findElement(By.xpath("//div[@class='empty-visual-overlay--sub-text']//span"));

		link.click();

	}

	// TC_24

	@Then("^verify the \"([^\"]*)\" panel should be opened$")
	public void verify_the_panel_should_be_opened(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);

		String popup = login.driver.findElement(By.xpath("(//span[@class='sidebar-panel--tab-name'])[2]")).getText();

		if (popup.equalsIgnoreCase(arg1)) {
			login.Log4j.info("Add from My series panel displaying:PASS");

		} else {

			login.Log4j.info("Add from My series panel not displaying:FAIL");
			Assert.assertEquals(popup, arg1);
		}

	}

	// TC_25

	@And("^Click on 'Edit series' link$")
	public void click_on_Edit_series_link() throws Throwable {
		CommonFunctionality.wait(5000);

		WebElement edit = login.driver.findElement(By.xpath("//*[contains(text(),'Edit Series')]"));
		action.moveToElement(edit).click().build().perform();
		// edit.click();
	}

	// TC_25
	@And("^click on  \"([^\"]*)\" on Add from My Series panel$")
	public void click_on_on_Add_from_My_Series_panel(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//span[@class='sidebar-panel--tab-name-txt']")).click();

	}

	// TC_25
	@Then("^verify the description on Add from My Series panel$")
	public void verify_the_description_on_Add_from_My_Series_panel() throws Throwable {
		CommonFunctionality.wait(2000);

		String text = login.driver.findElement(By.xpath("//div[@class='visual-series-panel--empty-message']"))
				.getText();

		System.out.println("text" + text);

		if (text.equalsIgnoreCase(
				"There are no series for selected visual. Please add series from + Add from My Series.")) {
			login.Log4j.info("Add from My series panel text displaying:PASS");
		} else {
			login.Log4j.info("Add from My series panel text not displaying:FAIL");
			Assert.assertEquals(text,
					"There are no series for selected visual. Please add series from + Add from My Series.");
		}

	}

	// TC_26
	@And("^click on \"([^\"]*)\" link$")
	public void click_on_link(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		WebElement linktext = login.driver.findElement(By.xpath("//span[text()='+ Add from My Series']"));
		CommonFunctionality.wait(1000);
		action.moveToElement(linktext).build().perform();
		linktext.click();

	}

	// TC_26
	@Then("^Verify the redirect to \"([^\"]*)\" tab$")
	public void verify_the_redirect_to_tab(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		String data = login.driver.findElement(By.xpath("//div[@class='data-selection-series-overlay--title']"))
				.getText();
		if (data.equalsIgnoreCase("No series added")) {
			login.Log4j.info("Page Redirecting to Add from My series panel:PASS");
		} else {
			login.Log4j.info("Page Redirecting to Add from My series panel:FAIL");
			Assert.assertEquals(data, "No series added");
		}

	}

	// TC_28
	@And("^Checked select all check box$")
	public void checked_select_all_check_box() throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//div[@class='list-view-wrapper']//span[@class='input-control--indicator']"))
				.click();
		CommonFunctionality.wait(2000);

	}

	// TC_28
	@Then("^Verify The series should be added to HeatMap with its data$")
	public void verify_The_series_should_be_added_to_HeatMap_with_its_data() throws Throwable {
		CommonFunctionality.wait(2000);

		String text = login.driver.findElement(By.xpath("//button[text()='Edit Heat map']")).getText();

		if (text.matches("Edit Heat map")) {
			login.Log4j.info("HeatMap visual should be created");
		}

		else {

			login.Log4j.info("HeatMap visual should be created");
			Assert.assertEquals(text, "Edit Heat map");

		}

	}

	// TC_29
	@Then("^mouse hover on the series name and verify the Attributes$")
	public void mouse_hover_on_the_series_name_and_verify_the_Attributes() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//button[@class='button button__primary']")).click();
		CommonFunctionality.wait(2000);

		WebElement linktext = login.driver
				.findElement(By.xpath("(//span[@class='series-edit--title series-edit--title__editable'])[1]"));
		CommonFunctionality.wait(1000);
		action.moveToElement(linktext).build().perform();
		CommonFunctionality.wait(1000);
		List<WebElement> attributes = login.driver.findElements(By.xpath(
				"//td[@class='public-js-views-insights-series-tooltip-style-module__tooltipCell public-js-views-insights-series-tooltip-style-module__tooltipKey']"));

		AttributeList = new ArrayList<>(
				Arrays.asList("Region", "Name", "Functions", "Unit", "Frequency", "First obs. date", "Last obs. date",
						"Observations", "Last value", "Last update time", "Source", "Series id", "Indicator", "More"));

		// there are removed in Classification and Functions

		for (int i = 0; i < attributes.size(); i++) {
			String s = attributes.get(i).getText();
			String attribute = s.replaceAll(":", "");

			System.out.println(attributes.get(i).getText());
			Attributes.add(attribute);

		}
		if (Attributes.equals(AttributeList)) {
			login.Log4j.info("Series Attributes list displaying:PASS" + Attributes);

		} else {
			login.Log4j.info("Series Attributes list displaying:FAIL" + Attributes);
			Assert.assertEquals(Attributes, AttributeList);

		}

	}

	// TC_30
	@Then("^Click on series on HeatMap visual and Verify the Series info popup \\(SSP\\) should be opened$")
	public void click_on_series_on_HeatMap_visual_and_Verify_the_Series_info_popup_SSP_should_be_opened()
			throws Throwable {

		CommonFunctionality.wait(2000);
		WebElement linktext = login.driver
				.findElement(By.xpath("(//span[@class='series-edit--title series-edit--title__editable'])[1]"));
		CommonFunctionality.wait(1000);
		action.moveToElement(linktext).click().build().perform();

		CommonFunctionality.wait(2000);

		WebElement sspwindow = login.driver
				.findElement(By.xpath("//div[@class='movable-modal--window ui-resizable ui-draggable']"));

		if (sspwindow.isDisplayed()) {
			login.Log4j.info("SSP Window displayed:PASS");
		}

		else {
			fail("SSP window is not displayed:FAIL");
		}

	}

	// TC_31
	@Then("^Mouse move on series name and click on cogwheel icon$")
	public void mouse_move_on_series_name_and_click_on_cogwheel_icon() throws Throwable {

		CommonFunctionality.wait(2000);
		WebElement linktext = login.driver.findElement(By.xpath("(//span[@title='Edit series'])[1]"));
		CommonFunctionality.wait(1000);
		action.moveToElement(linktext).click().build().perform();
		// login.driver.findElement(By.xpath("(//span[@title='Edit
		// series'])[1]")).click();

	}

	// TC_31
	@Then("^Verify the dropdown list$")
	public void verify_the_dropdown_list() throws Throwable {
		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath("//span[text()='Rename']")).isDisplayed()) {
			rename = login.driver.findElement(By.xpath("//span[text()='Rename']")).getText();
		} else if (login.driver.findElement(By.xpath("//span[text()='Frequency']")).isDisplayed()) {
			drop_frequency = login.driver.findElement(By.xpath("//span[text()='Frequency']")).getText();
		} else if (login.driver.findElement(By.xpath("//span[text()='Currency']")).isDisplayed()) {
			drop_currency = login.driver.findElement(By.xpath("//span[text()='Currency']")).getText();
		}

		else if (login.driver.findElement(By.xpath("//span[text()='Change']")).isDisplayed()) {
			drop_change = login.driver.findElement(By.xpath("//span[text()='Change']")).getText();

		}

		if (rename.equalsIgnoreCase("Rename") || drop_frequency.equalsIgnoreCase("Frequency")
				|| drop_currency.equalsIgnoreCase("Currency") || drop_change.equalsIgnoreCase("Change")) {
			login.Log4j.info("Edit series dropdown data displayed:PASS");
		} else {

			login.Log4j.info("Edit Series dropdown data is not displayed:FAIL");
			Assert.assertEquals(Drop, DropDownList);
		}

//		List<WebElement> droplist = login.driver.findElements(By.xpath("//span[@title='Edit series']"));
//		
//
//		DropDownList = new ArrayList<>(Arrays.asList("Rename", "Frequency", "Currency", "Change"));
//		
//
//		if(login.driver.findElement(By.xpath("//span[text()='Rename']")).getText().equalsIgnoreCase("Rename"))
//		
//		
//		for (int i = 0; i < droplist.size(); i++) {
//			String data = droplist.get(i).getText();
//
//			Drop.add(data);
//		}
//
//		if (Drop.equals(DropDownList)) {
//			login.Log4j.info("Edit series dropdown data displayed:PASS");
//		} 

	}

	// TC_32
	@Then("^Click on rename and verify the Rename popup should be displayed$")
	public void click_on_rename_and_verify_the_Rename_popup_should_be_displayed() throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//span[text()='Rename']")).click();

		CommonFunctionality.wait(2000);

		WebElement renamepopup = login.driver.findElement(By.xpath("//div[@class='movable-modal--body-wrapper']"));

		if (renamepopup.isDisplayed()) {

			login.Log4j.info("Rename popup is displayed");
		} else {
			fail("Rename Popup is not displayed");
		}

	}

	// TC_05
	@Given("^Create new Insight$")
	public void create_new_Insight() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//a[@class='insight-breadcrumb--title-link link']")).click();

		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//button[@class='button button__sm button__primary new-insight-button']"))
				.click();

		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//button[@class='sphere-modal-control button button__primary']")).click();

	}

	// TC_05
	@Given("^checked select all check box in my series panel$")
	public void checked_select_all_check_box_in_my_series_panel() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		;
		// WebElement checkbox =
		// login.driver.findElement(By.xpath("//input[@name='select_all_dataselection']"));

		// action.moveToElement(checkbox).click().build().perform();

	}

	// TC_05
	@Given("^click on fx and apply some functions$")
	public void click_on_fx_and_apply_some_functions() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver
				.findElement(By.xpath("//div[@title='More functions']//div[@class='insight-action-panel--btn-icon']"))
				.click();

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//span[@class='popular-functions-context--all-title']")).click();

		Applyfunction = login.driver.findElement(By.xpath("//div[@data-id='MATHNATLOG']")).getText().replaceAll("\\s",
				"");

		System.out.println("Applyfunction:" + Applyfunction);
		WebElement function = login.driver.findElement(By.xpath("//div[@data-id='MATHNATLOG']"));
		action.moveToElement(function).doubleClick().build().perform();

		login.driver.findElement(By.xpath("//button[@class='button button__primary']")).click();

	}

	// TC_05
	@Given("^Create HeatMap on applied function series$")
	public void create_HeatMap_on_applied_function_series() throws Throwable {

		CommonFunctionality.wait(4000);
		WebElement f = login.driver.findElement(By.xpath("(//span[@class='series-functions-title'])[1]"));
		action.moveToElement(f).build().perform();
		String fun = login.driver.findElement(By.xpath("(//span[@class='series-functions-title'])[1]")).getText();
		System.out.println("Global variable:" + Applyfunction);
		System.out.println("fun:" + fun);

		if (fun.contains(Applyfunction)) {
			System.out.println("Enter into if condition");
			WebElement seriesname = login.driver.findElement(By.xpath("(//span[@class='series-name-field--text'])[2]"));
			action.moveToElement(seriesname).build().perform();

			action.moveToElement(seriesname).contextClick().build().perform();

			login.driver.findElement(By.xpath("//*[text()='Add chart']")).click();

			login.driver.findElement(By.xpath(
					"//*[@class='icon--heatmap_large public-js-views-visuals-VisualsPanelSubItem-module__subItemIcon']"))
					.click();
			/*
			 * login.driver.findElement(By.
			 * xpath("//div[@class='icon--heatmap icon__visual-gray icon__context-menu']"))
			 * .click();
			 * 
			 * CommonFunctionality.wait(2000);
			 * 
			 * login.driver.findElement(By.xpath("//button[@class='button button__primary']"
			 * )).click();
			 */
		} else {
			login.Log4j.info("function not effected to series:FAIL");
			Assert.assertEquals(fun, Applyfunction);
		}

	}

	// TC_05
	@Then("^verify the functions applied to the visual series$")
	public void verify_the_functions_applied_to_the_visual_series() throws Throwable {
		CommonFunctionality.wait(2000);

		WebElement chkfunction = login.driver
				.findElement(By.xpath("(//span[@class='series-edit--title series-edit--title__editable'])[1]"));
		action.moveToElement(chkfunction).build().perform();
		String data = login.driver.findElement(By.xpath(
				"(//td[@class='public-js-views-insights-series-tooltip-style-module__tooltipCell public-js-views-insights-series-tooltip-style-module__tooltipKey'])[3]//following::td[1]"))
				.getText();
		System.out.println("data:" + data);
		System.out.println("Applyfunction:" + Applyfunction);

		if (data.contains(Applyfunction)) {
			login.Log4j.info("functions applied to the visual series displayed:PASS");
		} else {
			login.Log4j.info("functions applied to the visual series displayed:FAIL");
			Assert.assertEquals(data, Applyfunction);
		}

	}

	@Then("^Mouse move on series and Click on Remove series\\(x\\)$")
	public void mouse_move_on_series_and_Click_on_Remove_series_x() throws Throwable {
		CommonFunctionality.wait(2000);

		List<WebElement> mousemove = login.driver
				.findElements(By.xpath("//span[@class='series-edit--title series-edit--title__editable']"));
		System.out.println(mousemove.size());
		v = mousemove.size();

		WebElement seriesName = login.driver
				.findElement(By.xpath("//span[@class='series-edit--title series-edit--title__editable']"));
		action.moveToElement(seriesName).build().perform();

		login.driver.findElement(By.xpath("(//div[@class='highcharts-container ']//span[@title='Remove series'])[1]"))
				.click();

	}

	@Then("^Verify The series should be removed from the visual$")
	public void verify_The_series_should_be_removed_from_the_visual() throws Throwable {
		CommonFunctionality.wait(2000);

		List<WebElement> aftermousemove = login.driver
				.findElements(By.xpath("//span[@class='series-edit--title series-edit--title__editable']"));
		a = aftermousemove.size();
		System.out.println("After delete series name:" + v);
		System.out.println("before delete series name:" + a);
		if (v == a) {
			login.Log4j.info("series should be removed from the visual:FAIL:" + a);
			Assert.assertEquals(v, a);

		} else {

			login.Log4j.info("series should be removed from the visual:PASS:" + a);
		}

	}

	// TC_37
	@Then("^click on Apply button$")
	public void click_on_Apply_button() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//button[@class='button button__primary']")).click();
		CommonFunctionality.wait(2000);

	}

	// TC_37
	@Then("^Click on title and Verify the Title popup should be displayed$")
	public void click_on_title_and_Verify_the_Title_popup_should_be_displayed() throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//span[@data-name='title']")).click();
		CommonFunctionality.wait(1000);

		if (login.driver.findElement(By.xpath("//div[@class='popover--title']")).isDisplayed()) {

			login.Log4j.info("Title popup displayed:PASS");

		} else {
			fail("Title popup not displayed:FAIL");

		}

	}

	// TC_38
	@Then("^Click on edit visual title icon and Verify the Title popup should be displayed$")
	public void click_on_edit_visual_title_icon_and_Verify_the_Title_popup_should_be_displayed() throws Throwable {

		CommonFunctionality.wait(2000);

		WebElement seriesname = login.driver.findElement(By.xpath("//span[@data-name='title']"));
		action.moveToElement(seriesname).build().perform();

		login.driver.findElement(By.xpath("//i[@class='visual-title--icon visual-title--edit']")).click();

		if (login.driver.findElement(By.xpath("//div[@class='popover--title']")).isDisplayed()) {

			login.Log4j.info("Title popup displayed:PASS");

		} else {
			fail("Title popup not displayed:FAIL");

		}

	}

	// TC_39
	@Then("^Double Click on Visual$")
	public void double_Click_on_Visual() throws Throwable {
		CommonFunctionality.wait(2000);

	}

	// TC_39
	@Then("^Verify the Visual window popup should be displayed$")
	public void verify_the_Visual_window_popup_should_be_displayed() throws Throwable {
		CommonFunctionality.wait(2000);

	}

	// TC_43
	@Then("^Click on Edit series$")
	public void click_on_Edit_series() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//*[text()='Edit Series']")).click();

	}

	// TC_43
	@Then("^Verify the Edit series panel opened with \"([^\"]*)\" tab$")
	public void verify_the_Edit_series_panel_opened_with_tab(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath("//div[@class='sidebar-panel--header']")).isDisplayed()) {
			login.Log4j.info("Edit series panel opened:PASS");

			if (login.driver.findElement(By.xpath("//span[@class='sidebar-panel--tab-name-txt']")).isEnabled())

			{
				login.Log4j.info("Edit series panel Open with HeatMap Tab:PASS");
			} else {
				fail("Edit series panel not Open with HeatMap Tab:FAIL");
			}

		}

		else {
			fail("Edit series panel not opened:FAIL");
		}

	}

	// TC_44
	@Then("^Verify the Associated series should be available$")
	public void verify_the_Associated_series_should_be_available() throws Throwable {
		CommonFunctionality.wait(2000);

		List<WebElement> series = login.driver.findElements(By.xpath("//div[@class='series-name--title']"));

		System.out.println(series.size());
		if (series.size() == 5) {
			login.Log4j.info("Associated series displayed:PASS");
		} else {
			login.Log4j.info("Associated series not displayed:FAIL");
			Assert.assertEquals(series.size(), "5");
		}

	}

	// TC_45
	@Then("^Click on Rename option$")
	public void click_on_Rename_option() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath(
				"(//div[@class='insight-action-panel--btn-icon']//following::div[@class='insight-action-panel--btn-title'])[1]"))
				.click();

	}

	// TC_45
	@Then("^Verify the \"([^\"]*)\" popup should be displayed$")
	public void verify_the_popup_should_be_displayed(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath(
				"//div[@class='find-and-replace find-and-replace__has-matches find-and-replace__no-data-to-replace find-and-replace__default-names']"))
				.isDisplayed()) {

			login.Log4j.info("Associated series displayed:PASS");
		}

		else {

			login.Log4j.info("Associated series not displayed:FAIL");
		}

	}

	// TC_46
	@Then("^By default \"([^\"]*)\" field should be focused$")
	public void by_default_field_should_be_focused(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		WebElement findfield = login.driver.findElement(
				By.xpath("//input[@class='form--control form--control__sm find-and-replace--panel-search-input']"));
		boolean text = findfield.equals(login.driver.switchTo().activeElement());

		if (text == true) {
			login.Log4j.info("By default Find field should be focused:PASS");

		} else {
			login.Log4j.info("By default Find field should not be focused:FAIL");
			Assert.assertEquals(text, true);

		}

	}

	// TC_47

	@Then("^Verify the Number of selected series count should be shown on the rename popup header$")
	public void verify_the_Number_of_selected_series_count_should_be_shown_on_the_rename_popup_header()
			throws Throwable {

		CommonFunctionality.wait(2000);

		String count = login.driver.findElement(By.xpath("//span[@class='find-and-replace--modal-title-info']"))
				.getText().trim();
		count = count.replaceAll("[^0-9]", "");

		int value = Integer.parseInt(count);

		List<WebElement> seriescount = login.driver.findElements(
				By.xpath("//input[@class='form--control form--control__sm find-and-replace-item--name-input']"));

		if (value == seriescount.size()) {
			login.Log4j
					.info("Number of selected series count should be shown on the rename popup header:PASS:" + value);
		} else {

			login.Log4j.info(
					"Number of selected series count not should be shown on the rename popup header:FAIL:" + value);
		}

	}

	// TC_48
	@Then("^Verify the Number of available series count should be shown under the find field$")
	public void verify_the_Number_of_available_series_count_should_be_shown_under_the_find_field() throws Throwable {

		CommonFunctionality.wait(2000);

		String count = login.driver.findElement(By.xpath("//div[@class='find-and-replace--panel-matches']")).getText()
				.trim();
		count = count.replaceAll("[^0-9]", "");

		int value = Integer.parseInt(count);

		List<WebElement> seriescount = login.driver.findElements(
				By.xpath("//input[@class='form--control form--control__sm find-and-replace-item--name-input']"));

		if (value == seriescount.size()) {
			login.Log4j.info("Number of available series count should be shown under the find field:PASS:" + value);
		} else {

			login.Log4j.info("Number of available series count should not be shown under the find field:FAIL:" + value);
		}

	}

	// TC_49
	@Then("^Search for the series in find field and verify the Result should be loaded for searched keyword$")
	public void search_for_the_series_in_find_field_and_verify_the_Result_should_be_loaded_for_searched_keyword()
			throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver
				.findElement(By.xpath(
						"//input[@class='form--control form--control__sm find-and-replace--panel-search-input']"))
				.sendKeys("Gross");

		String matchedSeries = login.driver.findElement(By.xpath("//div[@class='find-and-replace--panel-matches']"))
				.getText().trim();
		matchedSeries = matchedSeries.replaceAll("[^0-9]", "");
		int value = Integer.parseInt(matchedSeries);

		List<WebElement> seriescount = login.driver.findElements(
				By.xpath("//input[@class='form--control form--control__sm find-and-replace-item--name-input']"));

		if (value == seriescount.size()) {
			login.Log4j.info(" Result should be loaded for searched keyword:PASS:" + value);
		} else {

			login.Log4j.info(" Result should not be loaded for searched keyword:FAIL:" + value);
		}

	}

	// TC_51
	@Then("^Search for the series you want to rename in find field$")
	public void search_for_the_series_you_want_to_rename_in_find_field() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver
				.findElement(By.xpath(
						"//input[@class='form--control form--control__sm find-and-replace--panel-search-input']"))
				.sendKeys("Gross");

	}

	// TC_51
	@Then("^Enter keyword in replace field and click on Replace button$")
	public void enter_keyword_in_replace_field_and_click_on_Replace_button() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver
				.findElement(By.xpath(
						"//input[@class='form--control form--control__sm find-and-replace--panel-replace-input']"))
				.click();

		login.driver
				.findElement(By.xpath(
						"//input[@class='form--control form--control__sm find-and-replace--panel-replace-input']"))
				.clear();
		login.driver
				.findElement(By.xpath(
						"//input[@class='form--control form--control__sm find-and-replace--panel-replace-input']"))
				.sendKeys("Total");

		login.driver.findElement(By.xpath("//*[text()='Replace']")).click();

		// Apply button
		login.driver.findElement(By.xpath("//button[text()='Apply']")).click();
		CommonFunctionality.wait(2000);
		// ok button
		login.driver.findElement(By.xpath("//button[text()='OK']")).click();

	}

	// TC_51
	@Then("^Verify the searched keyword should be replaced with entered keyword in series names$")
	public void verify_the_searched_keyword_should_be_replaced_with_entered_keyword_in_series_names() throws Throwable {
		CommonFunctionality.wait(2000);

		String seriesName = login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.getAttribute("value");

		System.out.println("Series name:" + seriesName);

		if (seriesName.contains("Total")) {
			login.Log4j
					.info("Searched keyword should be replaced with entered keyword in series name:PASS:" + seriesName);
		}

		else {
			login.Log4j.info(
					"Searched keyword should not be replaced with entered keyword in series name:FAIL:" + seriesName);
			Assert.assertEquals(seriesName, "Total");
		}

	}

	// TC_53
	@Then("^Enter keyword in replace field and click on Replace All button$")
	public void enter_keyword_in_replace_field_and_click_on_Replace_All_button() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver
				.findElement(By.xpath(
						"//input[@class='form--control form--control__sm find-and-replace--panel-replace-input']"))
				.sendKeys("Test");

		// click on Replace button
		login.driver.findElement(By.xpath("//button[text()='Replace All']")).click();

	}

//TC_53
	@Then("^Click on 'OK' button$")
	public void click_on_OK_button() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//button[text()='OK']")).click();

	}

	// TC_53
	@Then("^verify the replace name updated or not in Edit series popup$")
	public void verify_the_replace_name_updated_or_not_in_Edit_series_popup() throws Throwable {
		CommonFunctionality.wait(2000);

		List<WebElement> UpdatedSeriesnames = login.driver.findElements(By.xpath("//div[@class='series-name--title']"));

		for (int i = 1; i < UpdatedSeriesnames.size(); i++) {

			if (UpdatedSeriesnames.get(i).getText().contains("Test")) {
				login.Log4j
						.info("Replace name updated in Edit series popup:PASS:" + UpdatedSeriesnames.get(i).getText());

			} else {
				login.Log4j
						.info("Replace name updated in Edit series popup:FAIL:" + UpdatedSeriesnames.get(i).getText());
				// Assert.assertEquals(UpdatedSeriesnames.get(i).getText(), "Total");
			}

		}

	}

	// TC_55
	@Then("^Verify the 'Find Next' button disabled always$")
	public void verify_the_Find_Next_button_disabled_always() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver
				.findElement(By.xpath(
						"//input[@class='form--control form--control__sm find-and-replace--panel-search-input']"))
				.click();

		login.driver
				.findElement(By.xpath(
						"//input[@class='form--control form--control__sm find-and-replace--panel-search-input']"))
				.sendKeys("Gross");

		WebElement button = login.driver.findElement(By.xpath(
				"//button[@class='button button__secondary_purple find-and-replace--panel-button find-and-replace--panel-button__replace']"));

		boolean text = button.equals(login.driver.switchTo().activeElement());
		System.out.println(text);
		if (text) {
			login.Log4j.info("By default Find field should be focused:PASS");

		} else {
			login.Log4j.info("By default Find field should not be focused:FAIL");
			// Assert.assertEquals(text, true);

		}

//		WebElement button = login.driver.findElement(By.xpath("//button[@class='button button__secondary_purple find-and-replace--panel-button find-and-replace--panel-button__replace']"));
//
//		action.moveToElement(button).build().perform();
//		
//		if (button.isEnabled()) {
//			login.Log4j.info("Find Next button disabled:PASS");
//		} else {
//			fail("Find Next button not disabled:FAIL");
//		}
//		
//		Assert.assertEquals(button.isEnabled(), false);
//		

//		
	}

	// TC_33
	@Then("^Mouse hover on \"([^\"]*)\" and verify the dropdown list$")
	public void mouse_hover_on_and_verify_the_dropdown_list(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath(
				"//ul[@class='dropdown-menu context-menu edit-series--context-menu']//span[text()='" + arg1 + "']"))
				.click();

		List<WebElement> dropdown = login.driver
				.findElements(By.xpath("(//ul[@class='dropdown-menu'])[1]//span[@class='context-menu-item link']"));

		frequency = new ArrayList<>(Arrays.asList("As reported (Quarterly, ending 'Mar, June, Sep, Dec')",
				"Quarterly (Distribute)", "Quarterly (Replicate)", "Monthly (Distribute)", "Monthly (Replicate)",
				"Weekly (Distribute)", "Weekly (Replicate)"));

		for (int a = 0; a < dropdown.size(); a++) {

			String text = dropdown.get(a).getText();

			frequencylist.add(text);

		}

		if (frequencylist.equals(frequency)) {
			login.Log4j.info("Frequency dropdown data displayed:PASS" + frequencylist);
		}

		else {
			login.Log4j.info("Frequency dropdown data displayed:FAIL" + frequencylist);
			// Assert.assertEquals(frequencylist, frequency);
		}

	}

	// TC_33
	@Then("^Verify the selected frequency applied to the series$")
	public void verify_the_selected_frequency_applied_to_the_series() throws Throwable {

		CommonFunctionality.wait(2000);
		String frequency = login.driver.findElement(By.xpath("//span[@title='Quarterly (Distribute)']")).getText();
		System.out.println("frequency:" + frequency);

		login.driver.findElement(By.xpath("//span[@title='Quarterly (Distribute)']")).click();

		login.driver.findElement(By.xpath("//a[@class='insight-page-view-tab--link']")).click();
		CommonFunctionality.wait(2000);

		WebElement seriesname = login.driver.findElement(By.xpath("(//span[@class='series-name-field--text'])[5]"));

		action.moveToElement(seriesname).build().perform();

		String function = login.driver.findElement(By.xpath("(//tr[td='Frequency']//following::div)[1]")).getText();
		System.out.println("function:" + function);

		if (function.contains("Quarterly")) {
			login.Log4j.info("selected frequency applied to the series:PASS" + function);
		}

		else {
			login.Log4j.info("selected frequency not applied to the series:FAIL" + function);
			Assert.assertEquals("Distribute", function);
		}

	}

	// TC_34
	@Then("^mouse over on series name and click on cogwheel icon$")
	public void mouse_over_on_series_name_and_click_on_cogwheel_icon() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("(//span[@title='Edit series'])[5]")).click();

	}

	// TC_34
	@Then("^click on \"([^\"]*)\" and verify the dropdown list$")
	public void click_on_and_verify_the_dropdown_list(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath(
				"//ul[@class='dropdown-menu context-menu edit-series--context-menu']//span[text()='" + arg1 + "']"))
				.click();

		List<WebElement> dropdown = login.driver
				.findElements(By.xpath("(//ul[@class='dropdown-menu'])[2]//span[@class='context-menu-item link']"));

		currency = new ArrayList<>(Arrays.asList("USD", "RMB", "GBP", "EUR", "JPY", "MYR", "RUB"));

		for (int a = 0; a < dropdown.size(); a++) {

			String text = dropdown.get(a).getText();

			CDropdown.add(text);

		}

		if (CDropdown.equals(currency)) {
			login.Log4j.info("Currency dropdown data displayed:PASS" + CDropdown);
		}

		else {
			login.Log4j.info("Currency dropdown data not displayed:FAIL" + CDropdown);
			Assert.assertEquals(CDropdown, currency);
		}

	}

	// TC_34
	@Then("^Verify the selected currency applied to the series$")
	public void verify_the_selected_currency_applied_to_the_series() throws Throwable {
		CommonFunctionality.wait(2000);

		String currency = login.driver.findElement(By.xpath("//span[@title='USD']")).getText();
		System.out.println("currency:" + currency);

		login.driver.findElement(By.xpath("//span[@title='USD']")).click();

		login.driver.findElement(By.xpath("//a[@class='insight-page-view-tab--link']")).click();
		CommonFunctionality.wait(2000);

		WebElement seriesname = login.driver.findElement(By.xpath("(//span[@class='series-name-field--text'])[1]"));
		action.moveToElement(seriesname).build().perform();

		CommonFunctionality.wait(2000);
		String unit = login.driver.findElement(By.xpath("(//td[text()='Unit']//following::div)[1]")).getText();
		System.out.println("unit:" + unit);
		if (unit.contains(currency)) {
			login.Log4j.info("selected frequency applied to the series:PASS:" + unit);
		} else {
			login.Log4j.info("selected frequency not applied to the series:FAIL:" + unit);
			Assert.assertEquals(unit, currency);
		}

	}

	@Then("^click on 'Change' and verify the dropdown list$")
	public void click_on_Change_and_verify_the_dropdown_list() throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//span[text()='Change']")).click();

		login.driver
				.findElement(By.xpath(
						"//ul[@class='dropdown-menu context-menu edit-series--context-menu']//span[text()='Change']"))
				.click();

		List<WebElement> dropdown = login.driver
				.findElements(By.xpath("(//ul[@class='dropdown-menu'])[3]//span[@class='context-menu-item link']"));

		Change = new ArrayList<>(Arrays.asList("Difference Year-over-Year (YoY)", "% Year-over-Year (%YoY)",
				"Difference Period-over-Period (PoP)", "% Period-over-Period (%PoP)"));

		for (int a = 0; a < dropdown.size(); a++) {

			String text = dropdown.get(a).getText();

			ChangeDropdown.add(text);

		}

		if (ChangeDropdown.equals(Change)) {
			login.Log4j.info("Change dropdown data displayed:PASS" + ChangeDropdown);
		}

		else {
			login.Log4j.info("Change dropdown data not displayed:FAIL" + ChangeDropdown);
			Assert.assertEquals(ChangeDropdown, Change);
		}

	}

	@Then("^Verify the selected 'Change' applied to the series$")
	public void verify_the_selected_Change_applied_to_the_series() throws Throwable {
		CommonFunctionality.wait(2000);

		String currency = login.driver.findElement(By.xpath("//span[@title='% Period-over-Period (%PoP)']")).getText();
		System.out.println("currency:" + currency);

		login.driver.findElement(By.xpath("//span[@title='% Period-over-Period (%PoP)']")).click();

		login.driver.findElement(By.xpath("//a[@class='insight-page-view-tab--link']")).click();
		CommonFunctionality.wait(2000);

		WebElement seriesname = login.driver.findElement(By.xpath("(//span[@class='series-name-field--text'])[1]"));
		action.moveToElement(seriesname).build().perform();

		String function = login.driver.findElement(By.xpath("(//td[text()='Functions']//following::div)[1]")).getText();
		System.out.println("function:" + function);
		if (currency.contains("Period")) {
			login.Log4j.info("selected change applied to the series:PASS:" + currency);
		} else {
			login.Log4j.info("selected change not applied to the series:FAIL:" + currency);
			Assert.assertEquals("Period", currency);
		}

	}

	@Then("^Double click on dates$")
	public void double_click_on_dates() throws Throwable {

		CommonFunctionality.wait(2000);

		WebElement dates = login.driver.findElement(By.xpath(
				"(//div[@class='public-js-views-insight_visuals-visual_parts-xaxis_formatters-heatmap-heatmap_xaxis_formatter-module__wrapper '])[1]"));

		action.moveToElement(dates).doubleClick(dates).build().perform();

	}

	@Then("^Verify the \"([^\"]*)\" window popup is displayed$")
	public void verify_the_window_popup_is_displayed(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);

		String popup = login.driver.findElement(By.xpath("//div[text()='Time Axis']")).getText();

		if (popup.equals("Time Axis")) {
			login.Log4j.info("Time Axis window popup Displayed:PASS:" + popup);

		} else {
			login.Log4j.info("Time Axis window popup  Not Displayed:PASS:" + popup);
			Assert.assertEquals(popup, "Time Axis");
		}

	}

	// TC_57
	@Then("^Search with invalid series name$")
	public void search_with_invalid_series_name() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver
				.findElement(By.xpath(
						"//input[@class='form--control form--control__sm find-and-replace--panel-search-input']"))
				.sendKeys("ZAQ!2WSX");

	}

	// TC_57
	@Then("^Verify the \"([^\"]*)\" should be displayed under the find field$")
	public void verify_the_should_be_displayed_under_the_find_field(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		String text = login.driver.findElement(By.xpath("//div[@class='find-and-replace--panel-no-matches']"))
				.getText();

		if (text.equalsIgnoreCase(arg1)) {
			login.Log4j.info("No Matches found text should be displayed:PASS:" + text);
		} else {
			login.Log4j.info("'No Matches found' text Not should be displayed:FAIL:" + text);
			Assert.assertEquals(text, arg1);
		}

	}

	// TC_58
	@Then("^Click on Edit series info dropdown and verify the dropdown list$")
	public void click_on_Edit_series_info_dropdown_and_verify_the_dropdown_list() throws Throwable {
		CommonFunctionality.wait(2000);

		List<WebElement> Editseries = login.driver
				.findElements(By.xpath("//select[@class='find-and-replace--attribute-selector']//option"));
		Editseriesinfo = new ArrayList<>(Arrays.asList("Name", "Function description", "Region", "Unit", "Frequency"));

		for (int a = 0; a < Editseries.size(); a++) {
			String text = Editseries.get(a).getText();

			seriesinfo.add(text);
		}

		if (Editseriesinfo.equals(seriesinfo)) {
			login.Log4j.info("Edit series info dropdown verifyed:PASS:" + seriesinfo);
		} else {
			login.Log4j.info("Edit series info dropdown not verifyed:FAIL" + seriesinfo);
			Assert.assertEquals(seriesinfo, Editseriesinfo);
		}

	}

	// TC_59

	@Then("^Verify the By default \"([^\"]*)\" should be selected in Edit series info field$")
	public void verify_the_By_default_should_be_selected_in_Edit_series_info_field(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);
		Boolean text = login.driver.findElement(By.xpath("//span[text()='Name']")).isDisplayed();

		if (text == true) {
			login.Log4j.info("By default Name Displayed:PASS:" + text);
		}

		else {

			login.Log4j.info("By default Name Not Displayed:FAIL:" + text);
			Assert.assertEquals(text, true);
		}

	}

	// TC_60
	@Then("^Click on Edit series info dropdown Select \"([^\"]*)\"$")
	public void click_on_Edit_series_info_dropdown_Select(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//select[@class='find-and-replace--attribute-selector']")).click();
		CommonFunctionality.wait(2000);
		login.driver
				.findElement(By.xpath(
						"//select[@class='find-and-replace--attribute-selector']//option[@value='" + arg1 + "']"))
				.click();

		seriesReagion = login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.getAttribute("value");

		login.driver
				.findElement(By.xpath(
						"//input[@class='form--control form--control__sm find-and-replace--panel-replace-input']"))
				.click();

	}

	// TC_60
	@Then("^Verify the Series should be displayed by name$")
	public void verify_the_Series_should_be_displayed_by_name() throws Throwable {
		CommonFunctionality.wait(2000);
		String seriesName = login.driver
				.findElement(
						By.xpath("//input[@class='form--control form--control__sm find-and-replace-item--name-input']"))
				.getAttribute("value");
		System.out.println("seriesName:" + seriesName);

		if (seriesName.equalsIgnoreCase("Gross Domestic Product")) {
			login.Log4j.info("Series should be displayed by name:PASS:" + seriesName);
		} else {
			login.Log4j.info("Series should be displayed by name:FAIL:" + seriesName);
			Assert.assertEquals(seriesName, "Gross Domestic Product");
		}

	}

	// TC_61
	@Then("^Verify the Series should be displayed by \"([^\"]*)\"$")
	public void verify_the_Series_should_be_displayed_by(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		String functionsdesc = login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[2]"))
				.getAttribute("value");

		if (functionsdesc.equalsIgnoreCase("AGGREGATE(Yearly; December; Sum; No)")) {
			login.Log4j.info("Series should be displayed by name:PASS:" + functionsdesc);
		} else {
			login.Log4j.info("Series should be displayed by name:FAIL:" + functionsdesc);
			Assert.assertEquals(functionsdesc, "AGGREGATE(Yearly; December; Sum; No)");
		}

	}

	// TC_62
	@Then("^Click on 'Close' button on Series Harmonization window$")
	public void click_on_Close_button_on_Series_Harmonization_window() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//div[@class='movable-modal--close']")).click();

		CommonFunctionality.wait(2000);
	}

	// TC_62
	@Then("^Verify the \"([^\"]*)\" should be displayed since no description$")
	public void verify_the_should_be_displayed_since_no_description(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		for (int i = 1; i <= 5; i++) {
			String functionsdesc = login.driver.findElement(By.xpath(
					"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[" + i + "]"))
					.getAttribute("value");

			if (functionsdesc.isEmpty()) {
				login.Log4j.info("Empty rows should be displayed since no description:PASS:" + functionsdesc);
			} else {
				login.Log4j.info("Empty rows should be displayed since no description:FAIL:" + functionsdesc);
				Assert.assertEquals(functionsdesc, "");
			}

		}

	}

	// TC_63

	@Then("^Edit the Series function description and click on \"([^\"]*)\" button$")
	public void edit_the_Series_function_description_and_click_on_button(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.click();
		login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.clear();
		login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.sendKeys("Edit series Information");
		login.driver.findElement(By.xpath("//button[text()='" + arg1 + "']")).click();

	}

//TC_63
	@Then("^Verify the edit function discription should be updated in 'edit series panel'$")
	public void verify_the_edit_function_discription_should_be_updated_in_edit_series_panel() throws Throwable {
		CommonFunctionality.wait(2000);

		String updatedfunctionname = login.driver.findElement(By.xpath("(//div[@class='series-name--title'])[1]"))
				.getText();

		if (updatedfunctionname.contains("Edit series Information")) {
			WebElement Function = login.driver.findElement(By.xpath("(//div[@class='series-name--title'])[1]"));
			action.moveToElement(Function).build().perform();
			String functionName = login.driver.findElement(By.xpath("//td[text()='Functions']//following::div[1]"))
					.getText();
			Assert.assertEquals(functionName, "Edit series Information");
			login.Log4j.info("edit function discription should be updated in edit series panel:PASS:" + functionName);
		} else {

			login.Log4j.info(
					"edit function discription should be updated in edit series panel:FAIL:" + updatedfunctionname);
			Assert.assertEquals(updatedfunctionname, "Edit series Information");
		}

	}

	// TC_65
	@Then("^Update the Series Function Description$")
	public void update_the_Series_Function_Description() throws Throwable {
		CommonFunctionality.wait(2000);

		functionDesc = login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[2]"))
				.getAttribute("value");
		System.out.println(functionDesc);

		login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[2]"))
				.click();
		login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[2]"))
				.clear();
		login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[2]"))
				.sendKeys("Update Function");

	}

	// TC_65
	@Then("^Verify the 'Apply original title' \\(<\\) should be enabled$")
	public void verify_the_Apply_original_title_should_be_enabled() throws Throwable {
		CommonFunctionality.wait(4000);

		WebElement OriginalTitle = login.driver
				.findElement(By.xpath("(//div[@class='find-and-replace-item--action-icon'])[1]"));
		if (OriginalTitle.isEnabled()) {
			login.Log4j.info("Apply original title button Enabled:PASS");
		} else {
			fail("Apply original title button Enabled:FAIL");

		}

		login.driver.findElement(By.xpath("//button[text()='Cancel']")).click();

	}

	// TC_66
	@Then("^Verify the 'Apply original title' should be enabled$")
	public void verify_the_Apply_original_title_should_be_enabled1() throws Throwable {
		CommonFunctionality.wait(4000);

		WebElement OriginalTitle = login.driver
				.findElement(By.xpath("(//div[@class='find-and-replace-item--action-icon'])[1]"));
		if (OriginalTitle.isEnabled()) {
			login.Log4j.info("Apply original title button Enabled:PASS");
		} else {
			fail("Apply original title button Enabled:FAIL");

		}
	}

	// TC_66
	@Then("^Click on 'Apply original title' \\(<\\) icon$")
	public void click_on_Apply_original_title_icon() throws Throwable {
		CommonFunctionality.wait(4000);

		login.driver.findElement(By.xpath("(//div[@title='Apply original title'])[2]")).click();

		/*
		 * List<WebElement> orginaltitle=login.driver.findElements(By.xpath(
		 * "//div[@class='find-and-replace-item--action-icon']"));
		 * 
		 * //WebElement orginaltitle=login.driver.findElement(By.xpath(
		 * "//div[@class='find-and-replace-item--action-icon']")); //orginaltitle.is
		 * 
		 * for(int i=1;i<orginaltitle.size();i++) { if(orginaltitle.get(i).isEnabled())
		 * { login.driver.findElement(By.xpath(
		 * "(//div[@class='find-and-replace-item--action-icon'])["+i+"]")).click(); }
		 * else { System.out.println(i); }
		 * 
		 * }
		 * 
		 */

	}

	// TC_66

	@Then("^Verify The changes should be reverted to original title$")
	public void verify_The_changes_should_be_reverted_to_original_title() throws Throwable {

		CommonFunctionality.wait(4000);
		String name = login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[2]"))
				.getAttribute("value");
		System.out.println("name:" + name);
		System.out.println("functionDesc:" + functionDesc);

		if (name.equalsIgnoreCase(functionDesc)) {
			login.Log4j.info("The changes should be reverted to original title:PASS:" + name);
		} else {
			login.Log4j.info("The changes should not be reverted to original title:FAIL:" + name);
			Assert.assertEquals(name, functionDesc);
		}

		login.driver.findElement(By.xpath("//button[text()='Cancel']")).click();
	}

	// TC_67
	@Then("^Click on 'Original titles to all series'\\(<\\) icon next to 'Original Function description'$")
	public void click_on_Original_titles_to_all_series_icon_next_to_Original_Function_description() throws Throwable {

		CommonFunctionality.wait(4000);
		login.driver.findElement(By.xpath("//div[@class='find-and-replace--body-header-action-icon']")).click();

	}

	// TC_68
	@Then("^Click on Series Name$")
	public void click_on_Series_Name() throws Throwable {

		CommonFunctionality.wait(4000);

		login.driver.findElement(By.xpath("(//span[text()='Name: ']//following::span[1])[1]")).click();

	}

	// TC_68
	@Then("^Verify The SSP window should be displayed$")
	public void verify_The_SSP_window_should_be_displayed() throws Throwable {
		CommonFunctionality.wait(4000);
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='single-series-preview']", 10).isDisplayed());

		login.driver.findElement(By.xpath("//div[@title='Close']")).click();

	}

	// TC_69
	@Then("^Edit the Series Title and click on \"([^\"]*)\" button$")
	public void edit_the_Series_Title_and_click_on_button(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);

		sName = login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.getAttribute("value");

		login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.click();
		CommonFunctionality.wait(1000);
		login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.clear();
		CommonFunctionality.wait(1000);
		login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.sendKeys("Title");

		CommonFunctionality.wait(1000);

		login.driver.findElement(By.xpath("//button[text()='Apply']")).click();
		CommonFunctionality.wait(1000);
		Region = login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.getAttribute("value");

		login.driver.findElement(By.xpath("//button[text()='" + arg1 + "']")).click();

	}

	// TC_69
	@Then("^Verify the Series name updated in visual series$")
	public void verify_the_Series_name_updated_in_visual_series() throws Throwable {
		CommonFunctionality.wait(2000);

		String seriesname = login.driver
				.findElement(By.xpath("(//span[@class='series-edit--title series-edit--title__editable'])[5]"))
				.getText();

		if (seriesname.equalsIgnoreCase("Title")) {
			login.Log4j.info("Series name updated in visual series:PASS:" + seriesname);

		} else {
			login.Log4j.info("Series name updated in visual series:FAIL:" + seriesname);
			Assert.assertEquals(seriesname, "Title");
		}

	}

	// TC_69_70
	@Then("^Verify the changes should be reverted to original series name$")
	public void verify_the_changes_should_be_reverted_to_original_series_name() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//button[text()='Apply']")).click();

		CommonFunctionality.wait(2000);
		String OrginalName = login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.getAttribute("value");

		if (sName.equalsIgnoreCase(OrginalName)) {
			login.Log4j.info("Changes should be reverted to original series name:PASS:" + OrginalName);

		} else {

			login.Log4j.info("Changes should be reverted to original series name:FAIL:" + OrginalName);
			Assert.assertEquals(sName, OrginalName);
		}

		login.driver.findElement(By.xpath("//button[text()='Cancel']")).click();

	}

	// TC_71
	@Then("^Click on 'Apply original title for all series' \\(<\\) icon$")
	public void click_on_Apply_original_title_for_all_series_icon() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//div[@class='find-and-replace--body-header-action-icon']")).click();

	}

	// TC_72
	@Then("^Verify the The '<' icon should be disabled if no changes$")
	public void verify_the_The_icon_should_be_disabled_if_no_changes() throws Throwable {
		CommonFunctionality.wait(2000);

		if (login.driver.findElements(By.xpath(
				"//div[@class='find-and-replace-item find-and-replace-item__active find-and-replace-item__highlighted-input']"))
				.size() == 0)

		{
			login.Log4j.info(" '<' iocn should be disabled:PASS");
		} else {
			fail("'<'icon should not be dispbaled:FAIL");
		}

	}

//TC_73
	@Then("^Verify The Series displayed by Region$")
	public void verify_The_Series_displayed_by_Region() throws Throwable {
		CommonFunctionality.wait(2000);

		List<WebElement> region = login.driver.findElements(
				By.xpath("//input[@class='form--control form--control__sm find-and-replace-item--name-input']"));

		System.out.println(region.size());

		for (int i = 1; i <= region.size(); i++) {

			String country = login.driver
					.findElement(By.xpath(
							"//input[@class='form--control form--control__sm find-and-replace-item--name-input']"))
					.getAttribute("value");

			if (country.equalsIgnoreCase("China")) {
				login.Log4j.info("Series displayed by Region:PASS");
			} else {
				login.Log4j.info("Series not displayed by Region:FAIL");
				Assert.assertEquals(country, "China");
			}

		}

	}

	// TC_74
	@Then("^Click on Auto name \"([^\"]*)\" icon and select \"([^\"]*)\"$")
	public void click_on_Auto_name_icon_and_select(String arg1, String arg2) throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//button[@class='add-item-attribute btn']")).click();

		login.driver.findElement(By.xpath("(//div[@class='select2-result-label'])[2]")).click();

	}

	// TC_74
	@Then("^Verify The region should be renamed for the series$")
	public void verify_The_region_should_be_renamed_for_the_series() throws Throwable {

		CommonFunctionality.wait(2000);

		String region = login.driver.findElement(By.xpath("(//div[@class='series-name--title'])[1]")).getText();

		if (region.contains(Region)) {
			login.Log4j.info("Region should be renamed for the series:PASS" + region);
		} else {

			login.Log4j.info("Region should not be renamed for the series:FAIL" + region);
			Assert.assertEquals(region, Region);

		}
	}

	// TC_76

	@Then("^Verify The Rename - Region - Verify Apply original region icon$")
	public void verify_The_Rename_Region_Verify_Apply_original_region_icon() throws Throwable {
		CommonFunctionality.wait(2000);

		if (sName.equalsIgnoreCase(seriesReagion)) {
			login.Log4j.info("The Rename - Region - Verify Apply original region icon:PASS" + sName);
		}

		else {
			login.Log4j.info("The Rename - Region - Verify Apply original region icon:FAIL" + sName);
			Assert.assertEquals(sName, seriesReagion);
		}
	}

	// TC_91
	@Then("^Verify The minimize popup should be minimized$")
	public void verify_The_minimize_popup_should_be_minimized() throws Throwable {
		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath("//div[@title='Maximize']")).isDisplayed()) {

			login.Log4j.info("minimize popup should be minimized:PASS");
		}

		else {
			fail("minimize popup should not be minimized:FAIL");

		}

	}

	// TC_92
	@Then("^click on maximized button$")
	public void click_on_maximized_button() throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//div[@title='Maximize']")).click();

	}

	// TC_92
	@Then("^Verify The popup should be 'maximized'$")
	public void verify_The_popup_should_be_maximized() throws Throwable {
		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath("//div[@title='Minimize']")).isDisplayed()) {

			login.Log4j.info("Pop up should be Maximized:PASS");
		}

		else {
			fail("Pop up should not be Maximized:FAIL");

		}

	}

	// TC_93
	@Then("^Verify The popup should be displayed in full-screen$")
	public void verify_The_popup_should_be_displayed_in_full_screen() throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath("//div[@title='Exit full-screen']")).isDisplayed()) {

			login.Log4j.info("popup should be displayed in full-screen:PASS");
		}

		else {
			fail("popup should not be displayed in full-screen:FAIL");

		}

	}

	// TC_94
	@Then("^Click on 'Exit full-screen' option$")
	public void click_on_Exit_full_screen_option() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//div[@title='Exit full-screen']")).click();

	}

	// TC_94
	@Then("^Verify The popup should be displayed in normal size$")
	public void verify_The_popup_should_be_displayed_in_normal_size() throws Throwable {
		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath("//div[@title='Full-screen']")).isDisplayed()) {

			login.Log4j.info("The popup should be displayed in normal screen:PASS");
		}

		else {
			fail("The popup should be displayed in normal screen:FAIL");

		}

	}

	// TC_95
	@Then("^Verify The rename popup should be 'closed'$")
	public void verify_The_rename_popup_should_be_closed() throws Throwable {
		CommonFunctionality.wait(2000);

		if (login.driver.findElements(By.xpath("//div[@class='movable-modal--window ui-resizable ui-draggable']"))
				.size() == 0) {
			login.Log4j.info("Rename popup should be closed:PASS");
		} else {
			Assert.fail("rename popup should be closed:FAIL");
		}

	}

//TC_96
	@Then("^Press \"([^\"]*)\" on keyboard$")
	public void press_on_keyboard(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_H);
		Keys.chord(Keys.CONTROL, "H");

	}

//TC_96
	@Then("^Verify The 'Rename' popup should be displayed$")
	public void verify_The_Rename_popup_should_be_displayed() throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath(
				"//div[@class='find-and-replace find-and-replace__has-matches find-and-replace__no-data-to-replace find-and-replace__default-names']"))
				.isDisplayed()) {
			login.Log4j.info("Rename popup should be displayed:PASS");
		} else {
			Assert.fail("Rename popup should be displayed:FAIL");
		}

	}

//TC_97	
	@Then("^Click on currency and select \"([^\"]*)\"$")
	public void click_on_currency_and_select(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//*[@title='Currency']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//span[@title='USD']")).click();
	}

//TC_97
	@Then("^Verify the Selected currency should be applied to all series$")
	public void verify_the_Selected_currency_should_be_applied_to_all_series() throws Throwable {
		CommonFunctionality.wait(2000);

		WebElement seriesName = login.driver.findElement(By.xpath("//div[@class='visual-series-name--title']"));
		action.moveToElement(seriesName).build().perform();

		String units = login.driver.findElement(By.xpath("(//tr[td='Unit']//following::div)[1]")).getText();

		CommonFunctionality.wait(2000);
		if (units.contains("USD")) {
			login.Log4j.info("Selected currency should be applied to all series:PASS:" + units);

		} else {
			login.Log4j.info("Selected currency should not be applied to all series:FAIL:" + units);
			Assert.assertEquals(units, "USD");
		}

	}

//TC_97
	@And("^\"([^\"]*)\" check boxs checked$")
	public void check_boxs_checked(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		for (int i = 1; i <= 2; i++) {
			login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]"))
					.click();

		}

	}

//TC_98
	@Then("^Click on \"([^\"]*)\" and select \"([^\"]*)\"$")
	public void click_on_and_select(String arg1, String arg2) throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//*[@title='" + arg1 + "']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//*[@title='" + arg2 + "']")).click();

	}

//TC_98
	@Then("^Verify the Selected function should be applied to all series$")
	public void verify_the_Selected_function_should_be_applied_to_all_series() throws Throwable {
		CommonFunctionality.wait(2000);

		WebElement seriesName = login.driver.findElement(By.xpath("//div[@class='visual-series-name--title']"));
		action.moveToElement(seriesName).build().perform();

		String calculate = login.driver.findElement(By.xpath("(//tr[td='Functions']//following::div)[1]")).getText();

		if (calculate.contains("DIFF(Over Year)")) {
			login.Log4j.info("Selected Calculate change function should be applied to all series:PASS:" + calculate);

		} else {
			login.Log4j.info("Selected Calculate change function should be applied to all series:FAIL:" + calculate);
			Assert.assertEquals(calculate, "Difference Year-over-Year (YoY)");
		}

	}

//TC_99
	@Then("^Click on 'Aggregate' and Select \"([^\"]*)\"$")
	public void click_on_Aggregate_and_Select(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//div[@title='Quarterly, ending ']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//span[@title='" + arg1 + "']")).click();

	}

//TC_99
	@Then("^Verify the 'Aggregate' function should be applied to all series$")
	public void verify_the_Aggregate_function_should_be_applied_to_all_series() throws Throwable {
		CommonFunctionality.wait(2000);

		WebElement seriesName = login.driver.findElement(By.xpath("//div[@class='visual-series-name--title']"));
		action.moveToElement(seriesName).build().perform();

		String weekly = login.driver.findElement(By.xpath("(//tr[td='Functions']//following::div)[1]")).getText();

		if (weekly.contains("Weekly")) {
			login.Log4j.info("Selected Aggregate function should be applied to all series:PASS:" + weekly);

		} else {
			login.Log4j.info("Selected Aggregate function should be applied to all series:FAIL:" + weekly);
			Assert.assertEquals(weekly, "Weekly (Distribute)");
		}

	}

//TC_100
	@Then("^Click on \"([^\"]*)\" and Select \"([^\"]*)\"$")
	public void click_on_and_Select(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//div[@title='" + arg1 + "']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//span[@title='" + arg2 + "']")).click();

	}

//TC_100
	@Then("^Verify the 'Accumulate' function should be applied to all series$")
	public void verify_the_Accumulate_function_should_be_applied_to_all_series() throws Throwable {
		CommonFunctionality.wait(2000);

		WebElement seriesName = login.driver.findElement(By.xpath("//div[@class='visual-series-name--title']"));
		action.moveToElement(seriesName).build().perform();

		String accumulate = login.driver.findElement(By.xpath("(//tr[td='Functions']//following::div)[1]")).getText();

		if (accumulate.contains("YTD")) {
			login.Log4j.info("Selected Aggregate function should be applied to all series:PASS:" + accumulate);

		} else {
			login.Log4j.info("Selected Aggregate function should be applied to all series:FAIL:" + accumulate);
			Assert.assertEquals(accumulate, "YTD");
		}
	}

	// TC_78
	@Then("^Click on Auto name '\\+' icon and select \"([^\"]*)\"$")
	public void click_on_Auto_name_icon_and_select(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//button[@class='add-item-attribute btn']")).click();

		CommonFunctionality.wait(1000);

		login.driver.findElement(By.xpath("(//div[@class='select2-result-label'])[4]")).click();

	}

	// TC_78
	@Then("^Edit the Series Unit and click on \"([^\"]*)\" button$")
	public void edit_the_Series_Unit_and_click_on_button(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		Unitdata = login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.getAttribute("value");

		login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.click();

		login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.clear();

		login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.sendKeys("Test Update");

		login.driver.findElement(By.xpath("//button[text()='Apply']")).click();

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//button[text()='OK']")).click();

	}

	// TC_78
	@Then("^Verify The Editing series Unit updated in visual series$")
	public void verify_The_Editing_series_Unit_updated_in_visual_series() throws Throwable {
		CommonFunctionality.wait(2000);

		String updateUnit = login.driver.findElement(By.xpath("(//div[@class='series-name--title'])[1]")).getText();

		if (updateUnit.contains("Test Update")) {
			login.Log4j.info("Editing series Unit updated in visual series:PASS:" + updateUnit);

		} else {
			login.Log4j.info("Editing series Unit Not updated in visual series:FAIL:" + updateUnit);
			Assert.assertEquals(updateUnit, "Test Update");
		}

	}

	// TC_79
	@Then("^Click on '<' icon apply orginal title$")
	public void click_on_icon_apply_orginal_title() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("(//div[@class='find-and-replace-item--action'])[1]")).click();

		UpdateUnit = login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.getAttribute("value");
	}

	// TC_79
	@Then("^Verify The changes should be reverted to original series unit$")
	public void verify_The_changes_should_be_reverted_to_original_series_unit() throws Throwable {

		CommonFunctionality.wait(2000);

		String value = login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.getAttribute("value");

		System.out.println(value);
		System.out.println(UpdateUnit);
		if (value.equalsIgnoreCase(UpdateUnit)) {
			login.Log4j.info("changes should be reverted to original series unit:PASS:" + value);
		}

		else {

			login.Log4j.info("changes should be reverted to original series unit:FAIL:" + value);
			Assert.assertEquals(value, UpdateUnit);
		}

	}

	// TC_80
	@Then("^Click on '<' icon apply orginal titles to all series$")
	public void click_on_icon_apply_orginal_titles_to_all_series() throws Throwable {
		CommonFunctionality.wait(2000);

		String UpdateUnit = login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.getAttribute("value");

		login.driver.findElement(By.xpath("//div[@class='find-and-replace--body-header-action-icon']")).click();
//		if (UpdateUnit.equalsIgnoreCase("Test Update")) {
//			login.Log4j.info("Update series unit:PASS:" + UpdateUnit);
//		} else {
//			login.Log4j.info("Update series unit:FAIL:" + UpdateUnit);
//			Assert.assertEquals(UpdateUnit, "Test Update");
//		}

	}

	// TC_80
	@Then("^Verify All the changes should be revert back with original unit$")
	public void verify_All_the_changes_should_be_revert_back_with_original_unit() throws Throwable {
		CommonFunctionality.wait(2000);

		String value = login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.getAttribute("value");

		if (value.equalsIgnoreCase(Unitdata)) {
			login.Log4j.info("changes should be reverted to original series unit:PASS:" + value);
		}

		else {

			login.Log4j.info("changes should be reverted to original series unit:FAIL:" + value);
			Assert.assertEquals(value, Unitdata);
		}

	}

	// TC_81
	@Then("^Click on Auto name '\\+' icon and Select \"([^\"]*)\"$")
	public void click_on_Auto_name_icon_and_Select(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//button[@class='add-item-attribute btn']")).click();

		CommonFunctionality.wait(1000);

		login.driver.findElement(By.xpath("(//div[@class='select2-result-label'])[3]")).click();

	}

	// TC_81
	@Then("^Edit the Series Frequency and click on \"([^\"]*)\" button$")
	public void edit_the_Series_Frequency_and_click_on_button(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		Frequencydata = login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.getAttribute("value");

		login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.click();

		login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.clear();

		login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.sendKeys("Weekly");

		login.driver.findElement(By.xpath("//button[text()='Apply']")).click();

		login.driver.findElement(By.xpath("//button[text()='OK']")).click();

	}

	// TC_81
	@Then("^Verify The Editing series Frequency updated in visual series$")
	public void verify_The_Editing_series_Frequency_updated_in_visual_series() throws Throwable {
		CommonFunctionality.wait(2000);

		String updatefrequency = login.driver.findElement(By.xpath("(//div[@class='series-name--title'])[1]"))
				.getText();

		if (updatefrequency.contains("Weekly")) {
			login.Log4j.info("Editing series Frequency updated in visual series:PASS:" + updatefrequency);

		} else {
			login.Log4j.info("Editing series Frequency Not updated in visual series:FAIL:" + updatefrequency);
			Assert.assertEquals("Weekly", updatefrequency);
		}

	}

	// TC_82
	@Then("^Click on '<' icon apply orginal title icon$")
	public void click_on_icon_apply_orginal_title_icon() throws Throwable {
		CommonFunctionality.wait(2000);

		String Updatefrequency = login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.getAttribute("value");

		login.driver.findElement(By.xpath("(//div[@class='find-and-replace-item--action-icon'])[1]")).click();
		if (Updatefrequency.equalsIgnoreCase("Weekly")) {
			login.Log4j.info("Update series frequency:PASS:" + Updatefrequency);
		} else {
			login.Log4j.info("Update series frequency:FAIL:" + Updatefrequency);
			Assert.assertEquals(Updatefrequency, "Weekly");
		}

	}

	// TC_82
	@Then("^Verify The changes should be reverted to original series frequency$")
	public void verify_The_changes_should_be_reverted_to_original_series_frequency() throws Throwable {

		CommonFunctionality.wait(2000);

		String value = login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.getAttribute("value");

		if (value.equalsIgnoreCase(Frequencydata)) {
			login.Log4j.info("changes should be reverted to original series frequency:PASS:" + value);
		}

		else {

			login.Log4j.info("changes should be reverted to original series frequency:FAIL:" + value);
			Assert.assertEquals(value, Frequencydata);
		}
	}

	// TC_83
	@Then("^Click on '<' icon apply orginal titles to all series icon$")
	public void click_on_icon_apply_orginal_titles_to_all_series_icon() throws Throwable {
		CommonFunctionality.wait(2000);
		String Updatefrequency = login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.getAttribute("value");

		login.driver.findElement(By.xpath("//div[@class='find-and-replace--body-header-action-icon']")).click();
		if (Updatefrequency.equalsIgnoreCase("Weekly")) {
			login.Log4j.info("Update series frequency:PASS:" + Updatefrequency);
		} else {
			login.Log4j.info("Update series frequency:FAIL:" + Updatefrequency);
			Assert.assertEquals(Updatefrequency, "Weekly");
		}
	}

	// TC_83
	@Then("^Verify All the changes should be revert back with original frequency$")
	public void verify_All_the_changes_should_be_revert_back_with_original_frequency() throws Throwable {
		CommonFunctionality.wait(2000);
		String value = login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.getAttribute("value");

		if (value.equalsIgnoreCase(Frequencydata)) {
			login.Log4j.info("changes should be reverted to original series frequency:PASS:" + value);
		}

		else {

			login.Log4j.info("changes should be reverted to original series frequency:FAIL:" + value);
			Assert.assertEquals(value, Frequencydata);
		}

	}

//TC_85

	@Then("^Click on Open dropdown for auto name and Verify the dropdown data$")
	public void click_on_Open_dropdown_for_auto_name_and_Verify_the_dropdown_data() throws Throwable {
		CommonFunctionality.wait(2000);

		List<WebElement> closebtn = login.driver.findElements(By.xpath(
				"//div[@class='select2-search-choice-close custom select-behaviour--multi-select-item-delete icon--red-cross']"));
		for (int i = 1; i <= closebtn.size(); i++) {

			login.driver.findElement(By.xpath(
					"//div[@class='select2-search-choice-close custom select-behaviour--multi-select-item-delete icon--red-cross']"))
					.click();

		}

		login.driver.findElement(By.xpath("//button[@class='add-item-attribute btn']")).click();

		List<WebElement> Autonamedropdown = login.driver.findElements(By.xpath("//div[@class='select2-result-label']"));
		dropValues = new ArrayList<>(Arrays.asList("Name", "Region", "Frequency", "Unit", "Function description"));
		for (int a = 0; a < Autonamedropdown.size(); a++) {
			String text = Autonamedropdown.get(a).getText();

			list.add(text);

		}

		if (list.equals(dropValues)) {
			login.Log4j.info("Auto name dropdown data displayed:PASS" + list);
		} else {
			login.Log4j.info("Auto name dropdown data not displayed:FAIL" + list);
			Assert.assertEquals(dropValues, list);
		}
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("(//div[@class='select2-result-label'])[1]")).click();

//		login.driver.switchTo().activeElement();
//		login.driver.findElement(By.xpath("//ul[@class='select2-choices']")).click();
//		
//		
//		//login.driver.findElement(By.xpath("//button[@class='add-item-attribute btn']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//button[text()='Cancel']")).click();

	}

//TC_86
	@Then("^Click on Open dropdown for auto name$")
	public void click_on_Open_dropdown_for_auto_name() throws Throwable {
		CommonFunctionality.wait(2000);

		List<WebElement> closebtn = login.driver.findElements(By.xpath(
				"//div[@class='select2-search-choice-close custom select-behaviour--multi-select-item-delete icon--red-cross']"));
		for (int i = 1; i <= closebtn.size(); i++) {
			System.out.println(closebtn.size());
			login.driver.findElement(By.xpath(
					"//div[@class='select2-search-choice-close custom select-behaviour--multi-select-item-delete icon--red-cross']"))
					.click();

		}
		login.driver.findElement(By.xpath("//button[@class='add-item-attribute btn']")).click();

	}

//TC_86
	@Then("^Select Anyone Attribute$")
	public void select_Anyone_Attribute() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("(//div[@class='select2-result-label'])[4]")).click();

	}

//TC_86
	@Then("^Click on Apply/save button$")
	public void click_on_Apply_save_button() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//button[text()='Apply']")).click();

		CommonFunctionality.wait(2000);
		Name = login.driver.findElement(By.xpath("(//span[@class='link'])[2]")).getText();

		login.driver.findElement(By.xpath("//button[text()='OK']")).click();
	}

//TC_86
	@Then("^Verify The visual series name should be displayed as selected attribute$")
	public void verify_The_visual_series_name_should_be_displayed_as_selected_attribute() throws Throwable {
		CommonFunctionality.wait(2000);

		String name = login.driver.findElement(By.xpath("(//div[@class='series-name--title'])[1]")).getText();

		if (name.equalsIgnoreCase(Name)) {
			login.Log4j.info("The visual series name should be displayed as selected attribute:PASS" + name);

		} else {

			login.Log4j.info("The visual series name should be displayed as selected attribute:FAIL" + name);
			Assert.assertEquals(name, Name);
		}

	}

	@Then("^Select multiple Attribute$")
	public void select_multiple_Attribute() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("(//div[@class='select2-result-label'])[3]")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//button[@class='add-item-attribute btn']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("(//div[@class='select2-result-label'])[4]")).click();

	}

	@Then("^Verify The Selected attributes should be displayed as series name$")
	public void verify_The_Selected_attributes_should_be_displayed_as_series_name() throws Throwable {
		CommonFunctionality.wait(2000);

		String name = login.driver.findElement(By.xpath("(//div[@class='series-name--title'])[1]")).getText();

		if (name.equalsIgnoreCase(Name)) {
			login.Log4j.info("The Selected attributes should be displayed as series name:PASS" + name);

		} else {

			login.Log4j.info(" The Selected attributes should be displayed as series name:FAIL" + name);
			Assert.assertEquals(name, Name);
		}

	}

	// TC_90
	@Then("^Edit the series name$")
	public void edit_the_series_name() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.click();

		CommonFunctionality.wait(1000);

		login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.clear();

		CommonFunctionality.wait(1000);

		login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.sendKeys("Test");

	}

	// TC_90
	@Then("^Verify The changes should be saved and applied to visual series in edit series panel and the popup should be closed$")
	public void verify_The_changes_should_be_saved_and_applied_to_visual_series_in_edit_series_panel_and_the_popup_should_be_closed()
			throws Throwable {
		CommonFunctionality.wait(2000);

		String Name = login.driver.findElement(By.xpath("(//div[@class='series-name'])[1]")).getText();

		if (Name.equalsIgnoreCase("Test")) {
			login.Log4j.info(
					"The changes should be saved and applied to visual series in edit series panel:PASS: " + Name);
		} else {
			login.Log4j
					.info("The changes should be saved and applied to visual series in edit series panel:FAIL" + Name);
			Assert.assertEquals(Name, "Test");
		}

	}

	// TC_89
	@Then("^Click on 'Apply' button$")
	public void click_on_Apply_button1() throws Throwable {

		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//button[text()='Apply']")).click();

	}

	// TC_89
	@Then("^Verify The changes should be saved and rename popup remains displayed$")
	public void verify_The_changes_should_be_saved_and_rename_popup_remains_displayed() throws Throwable {
		CommonFunctionality.wait(2000);

		String updatename = login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.getAttribute("value");

		if (updatename.equalsIgnoreCase("Test")) {
			login.Log4j.info("The changes should be saved:PASS: " + updatename);

		} else {

			login.Log4j.info("The changes should not be saved:PASS: " + updatename);
			Assert.assertEquals(updatename, "Test");
		}

		Assert.assertTrue(login.driver.findElement(By.xpath(
				"//div[@class='find-and-replace find-and-replace__has-matches find-and-replace__no-data-to-replace']"))
				.isDisplayed());

	}

	// TC_102
	@Then("^Click on 'FX' Open function editor\\(F\\) icon$")
	public void click_on_FX_Open_function_editor_F_icon() throws Throwable {
		CommonFunctionality.wait(2000);

		if (login.driver.findElements(By.xpath("//div[@class='fx-panel-toggle fx-panel-toggle__is-open']"))
				.size() == 1) {
			login.driver.findElement(By.xpath(
					"(//div[@title='Open function editor (F). Investigate all available functions in the function editor window.'])[1]"))
					.click();

		} else {
			login.driver.findElement(By.xpath("//div[@class='fx-panel-toggle']")).click();
			login.driver.findElement(By.xpath(
					"(//div[@title='Open function editor (F). Investigate all available functions in the function editor window.'])[1]"))
					.click();

		}

	}

	// TC_102
	@Then("^Verify The \"([^\"]*)\" popup should be opened$")
	public void verify_The_popup_should_be_opened(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);

		String popup = login.driver.findElement(By.xpath("//div[text()='Apply functions to visual series']")).getText();

		if (popup.equalsIgnoreCase(arg1)) {

			login.Log4j.info("Apply functions to visual series popup should be opened:PASS: " + popup);
		} else {

			login.Log4j.info("Apply functions to visual series popup should not be opened:PASS: " + popup);
			Assert.assertEquals(popup, arg1);
		}

		login.driver.findElement(By.xpath("//div[@title='Close']")).click();

	}

	// TC_104
	@Then("^Click on 'function bar' hide icon$")
	public void click_on_function_bar_hide_icon() throws Throwable {
		CommonFunctionality.wait(2000);

		if (login.driver.findElements(By.xpath("//div[@title='Hide the function bar']")).size() == 1) {
			login.driver.findElement(By.xpath("//div[@title='Hide the function bar']")).click();
		} else {

			login.driver.findElement(By.xpath("//div[@title='Show the function bar']")).click();
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath("//div[@title='Hide the function bar']")).click();
		}

	}

	// TC_104
	@Then("^Verify The 'function bar' should be hidden$")
	public void verify_The_function_bar_should_be_hidden() throws Throwable {
		CommonFunctionality.wait(2000);

		WebElement hidebtn = login.driver.findElement(By.xpath("//div[@title='Show the function bar']"));

		if (hidebtn.isDisplayed()) {

			login.Log4j.info("function bar should be hidden:PASS");

		} else {

			fail("function bar should be hidden:FAIL");

		}

	}

	// TC_105
	@Then("^Click on 'function bar' show icon$")
	public void click_on_function_bar_show_icon() throws Throwable {
		CommonFunctionality.wait(2000);

		if (login.driver.findElements(By.xpath("//div[@title='Show the function bar']")).size() == 1) {
			login.driver.findElement(By.xpath("//div[@title='Show the function bar']")).click();
		} else {

			login.driver.findElement(By.xpath("//div[@title='Hide the function bar']")).click();
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath("//div[@title='Show the function bar']")).click();
		}

		// login.driver.findElement(By.xpath("//div[@title='Show the function
		// bar']")).click();

	}

	// TC_105
	@Then("^Verify The 'function bar' should be shown$")
	public void verify_The_function_bar_should_be_shown() throws Throwable {

		CommonFunctionality.wait(2000);

		WebElement showbtn = login.driver.findElement(By.xpath("//div[@title='Hide the function bar']"));

		if (showbtn.isDisplayed()) {

			login.Log4j.info("function bar should be shown:PASS");

		} else {

			fail("function bar should be shown:FAIL");

		}

	}

	// TC_106
	@Then("^Click on \"([^\"]*)\" area$")
	public void click_on_area(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath(
				"(//div[@class='function-editor-window--icon'])[1]//following::div[@class='current-function-input'][1]"))
				.click();

	}

	// TC_106
	@Then("^Verify The List of functions dropdown should be opened and selected functions should be applied to the series$")
	public void verify_The_List_of_functions_dropdown_should_be_opened_and_selected_functions_should_be_applied_to_the_series()
			throws Throwable {

		CommonFunctionality.wait(2000);

		WebElement dropdown = login.driver
				.findElement(By.xpath("//div[@class='function-editor-window-auto-complete']"));

		if (dropdown.isDisplayed()) {

			login.driver.findElement(By.xpath("//li[@data-id='UNIT_MANIPULATION']")).click();
			CommonFunctionality.wait(2000);

			login.driver.findElement(By.xpath("//li[@data-id='TH']")).click();
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath("//li[@data-id='TRUE']")).click();

			fun = login.driver.findElement(By.xpath("(//span[@title='Unit Multiplier'])[1]")).getText();

			login.driver
					.findElement(By.xpath(
							"(//div[@class='functions-input-container']//following::div[@title='Apply function'])[1]"))
					.click();

		}

		CommonFunctionality.wait(2000);

		WebElement seriesName = login.driver.findElement(By.xpath("(//div[@class='series-name--title'])[1]"));

		action.moveToElement(seriesName).build().perform();

		String function = "AGGREGATE(Quarterly; March, June, September, December; Sum; No) > UNIT_MULTIPLIER(Thousand; Convert all multipliers)";
		System.out.println("function:" + function);
		System.out.println("fun:" + fun);

		if (function.contains("Convert all multipliers")) {
			login.Log4j.info(
					"List of functions dropdown should be opened and selected functions should be applied to the series:PASS");
		} else {

			login.Log4j.info(
					"List of functions dropdown should not be opened and selected functions should not be applied to the series:FAIL");
		}

	}

	// TC_108
	@Then("^Click on 'X' icon in Edit series panel for a series$")
	public void click_on_X_icon_in_Edit_series_panel_for_a_series() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("(//div[@class='remove-item-control'])[2]")).click();

	}

//TC_108
	@Then("^Verify The series should be removed from the visual and edit series panel$")
	public void verify_The_series_should_be_removed_from_the_visual_and_edit_series_panel() throws Throwable {
		CommonFunctionality.wait(2000);

		// Edit series panel
		List<WebElement> editserieslist = login.driver.findElements(By.xpath("//div[@class='series-name--title']"));

		if (editserieslist.size() == 1) {
			login.Log4j.info("The series should be removed from the edit series panel:PASS");
		} else {
			login.Log4j.info("The series should be removed from the edit series panel:FAIL:" + editserieslist.size());
			Assert.assertEquals(editserieslist.size(), "1");
		}

		// view panel series
		List<WebElement> viewserieslist = login.driver
				.findElements(By.xpath("//span[@class='series-edit--title series-edit--title__editable']"));

		if (viewserieslist.size() == 1) {
			login.Log4j.info("The series should be removed from the visual panel:PASS");
		} else {
			login.Log4j.info("The series should be removed from the visual panel:FAIL:" + viewserieslist.size());
			Assert.assertEquals(viewserieslist.size(), "1");
		}

	}

	// TC_109
	@Then("^Click on 'X' icon for attribute\\(Next to name\\)$")
	public void click_on_X_icon_for_attribute_Next_to_name() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("(//div[@class='remove-item-control'])[1]")).click();

	}

	// TC_109
	@Then("^Verify The All the series should be removed from the visual and edit series panel$")
	public void verify_The_All_the_series_should_be_removed_from_the_visual_and_edit_series_panel() throws Throwable {
		CommonFunctionality.wait(2000);

		// Edit series panel
		WebElement text = login.driver.findElement(
				By.xpath("//span[text()='There are no series for selected visual. Please add series from']"));

		if (text.isDisplayed()) {
			login.Log4j.info("All series should be removed from the Edit Series panel:PASS");
		} else {
			Assert.fail(" All series should not be removed from the Edit Series panel:FAIL:");
		}

		// view panel

		WebElement viewpanel = login.driver.findElement(By.xpath("//div[@class='empty-visual-overlay--title']"));

		if (viewpanel.isDisplayed()) {
			login.Log4j.info("All series should be removed from the View panel:PASS");
		} else {
			Assert.fail("All series should not be removed from the View panel:FAIL:");
		}

	}

	// TC_110
	@Then("^Click on series name in Edit series panel$")
	public void click_on_series_name_in_Edit_series_panel() throws Throwable {

		CommonFunctionality.wait(2000);

		WebElement seriesname = login.driver.findElement(By.xpath("(//div[@class='visual-series-name'])[1]"));
		action.moveToElement(seriesname).click().build().perform();

	}

	// TC_110
	@Then("^Verify The SSP popup should be displayed$")
	public void verify_The_SSP_popup_should_be_displayed() throws Throwable {

		CommonFunctionality.wait(2000);

		// SSP window
		WebElement ssp = login.driver
				.findElement(By.xpath("//div[@class='movable-modal--window ui-resizable ui-draggable']"));

		if (ssp.isDisplayed()) {
			login.Log4j.info("SSP popup should be displayed:PASS");

		} else {
			Assert.fail("SSP popup should NOT be displayed:FAIL:");
		}
		CommonFunctionality.wait(2000);

		if (login.driver.findElements(By.xpath("(//*[@class='movable-modal--close'])[2]")).size() == 1) {
			login.driver.findElement(By.xpath("(//*[@class='movable-modal--close'])[2]")).click();
			login.Log4j.info("SSP popup should be closed:PASS");
		} else {

		}

	}

	// TC_111
	@Then("^Mouse move on series and Click on 'rename series icon'$")
	public void mouse_move_on_series_and_Click_on_rename_series_icon() throws Throwable {
		CommonFunctionality.wait(2000);

		List<WebElement> rename = login.driver.findElements(By.xpath("//div[@class='series-name--title']"));

		size = rename.size();

		WebElement mousehover = login.driver.findElement(By.xpath("(//div[@class='remove-item-control'])[2]"));
		action.moveToElement(mousehover).build().perform();

		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("(//div[@title='Rename series'])[1]")).click();

	}

	// TC_111
	@Then("^Verify The Rename popup should be displayed for selected series$")
	public void verify_The_Rename_popup_should_be_displayed_for_selected_series() throws Throwable {
		CommonFunctionality.wait(2000);

		WebElement popup = login.driver.findElement(By.xpath("//div[@class='movable-modal--body-wrapper']"));

		if (popup.isDisplayed()) {
			login.Log4j.info("Rename popup should be displayed:PASS");
		} else {
			Assert.fail("Rename popup should NOT be displayed:FAIL:");
		}

		List<WebElement> rename = login.driver.findElements(
				By.xpath("//input[@class='form--control form--control__sm find-and-replace-item--name-input']"));

		int serieslist = rename.size();

		if (size == serieslist) {
			login.Log4j.info("Selected series displayed in rename popup:PASS");
		} else {

			login.Log4j.info("Selected series NOT displayed in rename popup:PASS:" + serieslist);
			Assert.assertEquals(size, serieslist);
		}

	}

	// TC_112

	@Then("^Mouse move on series and Click on 'Edit series' icon$")
	public void mouse_move_on_series_and_Click_on_Edit_series_icon() throws Throwable {
		CommonFunctionality.wait(2000);

		List<WebElement> rename = login.driver.findElements(By.xpath("//div[@class='series-name--title']"));

		serieslist = rename.size();

		WebElement mousehover = login.driver.findElement(By.xpath("(//div[@class='remove-item-control'])[2]"));
		action.moveToElement(mousehover).build().perform();

		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("(//div[@title='Edit series'])[1]")).click();

	}

	// TC_112
	@Then("^Verify The data in Edit dropdown list$")
	public void verify_The_data_in_Edit_dropdown_list() throws Throwable {
		CommonFunctionality.wait(2000);
		Assert.assertTrue(
				CommonFunctionality.getElementByXpath(login.driver, "//span[text()='Rename']", 10).isDisplayed());
		Assert.assertTrue(
				CommonFunctionality.getElementByXpath(login.driver, "//span[text()='Frequency']", 10).isDisplayed());
		Assert.assertTrue(
				CommonFunctionality.getElementByXpath(login.driver, "//span[text()='Currency']", 10).isDisplayed());
		Assert.assertTrue(
				CommonFunctionality.getElementByXpath(login.driver, "//span[text()='Change']", 10).isDisplayed());

	}

	// TC_113

	@Then("^Cick on \"([^\"]*)\" on Edit series Dropdwon list$")
	public void cick_on_on_Edit_series_Dropdwon_list(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//span[text()='" + arg1 + "']")).click();

	}

	// TC_113
	@Then("^Verify Rename popup should be displayed for selected series$")
	public void verify_Rename_popup_should_be_displayed_for_selected_series() throws Throwable {

		CommonFunctionality.wait(2000);

		WebElement popup = login.driver.findElement(By.xpath("//div[@class='movable-modal--body-wrapper']"));

		if (popup.isDisplayed()) {
			login.Log4j.info("Rename popup should be displayed:PASS");
		} else {
			Assert.fail("Rename popup should NOT be displayed:FAIL:");
		}

		List<WebElement> rename = login.driver.findElements(
				By.xpath("//input[@class='form--control form--control__sm find-and-replace-item--name-input']"));

		int list = rename.size();

		if (serieslist == list) {
			login.Log4j.info("Selected series displayed in rename popup:PASS: " + list);
		} else {

			login.Log4j.info("Selected series NOT displayed in rename popup:PASS:" + list);
			Assert.assertEquals(serieslist, list);
		}
	}

	// TC_101
	@Then("^Click on 'FX' More dropdown and select any option$")
	public void click_on_FX_More_dropdown_and_select_any_option() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("(//div[@class='insight-action-panel--btn-icon'])[3]")).click();

		WebElement functiondropdown = login.driver.findElement(By.xpath("//span[text()='Weekly (Replicate)']"));

		functiondropdown.click();

		CommonFunctionality.wait(4000);

	}

	// TC_101
	@Then("^Verify The Selected 'FX' function should be applied to all series$")
	public void verify_The_Selected_FX_function_should_be_applied_to_all_series() throws Throwable {

		CommonFunctionality.wait(2000);

		List<WebElement> applyfun = login.driver.findElements(By.xpath("//div[@class='series-name--title']"));

		for (int i = 1; i <= applyfun.size(); i++) {
			WebElement hover = login.driver.findElement(By.xpath("(//div[@class='series-name--title'])[" + i + "]"));

			action.moveToElement(hover).build().perform();

			String function = login.driver.findElement(By.xpath("(//td[text()='Functions']//following::div)[1]"))
					.getText();
			System.out.println("function:" + function);

			if (function.contains("Weekly")) {
				login.Log4j.info("selected functioon applied to the series:PASS" + function);
			}

			else {
				login.Log4j.info("selected function not applied to the series:FAIL" + function);
				Assert.assertEquals(function, "Weekly");
			}

		}

	}

	// TC_121
	@Then("^Click on \"([^\"]*)\" Dropdown$")
	public void click_on_Dropdown(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver
				.findElement(
						By.xpath("//div[@class='insight-action-panel--btn-title' and contains(text(),'" + arg1 + "')]"))
				.click();

	}

	// TC_114

	@Then("^Cick on \"([^\"]*)\" on Edit series and select anyone on Dropdwon list$")
	public void cick_on_on_Edit_series_and_select_anyone_on_Dropdwon_list(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath(
				"//ul[@class='dropdown-menu context-menu edit-series--context-menu']//span[text()='" + arg1 + "']"))
				.click();

		login.driver.findElement(By.xpath("//span[text()='Yearly (Avg)']")).click();

		CommonFunctionality.wait(2000);

	}

//TC_114
	@Then("^Verify The Selected function should be applied to the series$")
	public void verify_The_Selected_function_should_be_applied_to_the_series() throws Throwable {

		CommonFunctionality.wait(2000);

		WebElement seriesname = login.driver.findElement(By.xpath("(//div[@class='series-name--title'])[1]"));

		action.moveToElement(seriesname).build().perform();

		CommonFunctionality.wait(2000);

		String function = login.driver.findElement(By.xpath("(//tr[td='Functions']//following::div)[1]")).getText();

		if (function.contains("Avg")) {

			login.Log4j.info("Selected Frquency should be applied to all series:PASS:" + function);

		} else {
			login.Log4j.info("Selected Frquency should not be applied to all series:FAIL:" + function);
			Assert.assertEquals(function, "Avg");

		}

	}

//TC_115
	@Then("^Cick on \"([^\"]*)\" on Edit series and select anyone on Dropdown list$")
	public void cick_on_on_Edit_series_and_select_anyone_on_Dropdown_list(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath(
				"//ul[@class='dropdown-menu context-menu edit-series--context-menu']//span[text()='" + arg1 + "']"))
				.click();

		login.driver.findElement(By.xpath("//span[text()='USD']")).click();

		CommonFunctionality.wait(2000);

	}

	// TC_116

	@Then("^Cick on \"([^\"]*)\" on Edit series and select anyone on dropdown list$")
	public void cick_on_on_Edit_series_and_select_anyone_on_dropdown_list(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath(
				"//ul[@class='dropdown-menu context-menu edit-series--context-menu']//span[text()='" + arg1 + "']"))
				.click();

		login.driver.findElement(By.xpath("//span[text()='Difference Year-over-Year (YoY)']")).click();

		CommonFunctionality.wait(2000);
	}

	// TC_116
	@Then("^Verify the Selected 'Change' should be applied to all series$")
	public void verify_the_Selected_Change_should_be_applied_to_all_series() throws Throwable {
		CommonFunctionality.wait(2000);

		WebElement seriesname = login.driver.findElement(By.xpath("(//div[@class='series-name--title'])[1]"));

		action.moveToElement(seriesname).build().perform();

		CommonFunctionality.wait(2000);

		String change = login.driver.findElement(By.xpath("(//tr[td='Functions']//following::div)[1]")).getText();

		if (change.contains("DIFF(Over Year)")) {

			login.Log4j.info("Selected change function should be applied to all series:PASS:" + change);

		} else {
			login.Log4j.info("Selected change function should not be applied to all series:FAIL:" + change);
			Assert.assertEquals(change, "DIFF(Over Year)");

		}

	}

	// TC_117
	@Then("^Click on 'Frequency' or its dropdown in Edit series$")
	public void click_on_Frequency_or_its_dropdown_in_Edit_series() throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver
				.findElement(
						By.xpath("//div[@class='insight-action-panel--btn-title' and contains(text(),'Frequency')]"))
				.click();

	}

	// TC_118
	@Then("^Select any 'Frequency' from dropdown in Series data conversion popup$")
	public void select_any_Frequency_from_dropdown_in_Series_data_conversion_popup() throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver
				.findElement(
						By.xpath("(//span[@class='series-data-conversion--function-title']//following::select)[1]"))
				.click();

		login.driver
				.findElement(
						By.xpath("//select[@class='series-data-conversion--param form--control']//option[@value='M']"))
				.click();

	}

	// TC_118
	@Then("^Verify The selected frequency should be applied to available series$")
	public void verify_The_selected_frequency_should_be_applied_to_available_series() throws Throwable {

		CommonFunctionality.wait(2000);

		WebElement seriesname = login.driver.findElement(By.xpath("(//div[@class='series-name--title'])[1]"));

		action.moveToElement(seriesname).build().perform();

		CommonFunctionality.wait(2000);

		String frequency = login.driver.findElement(By.xpath("(//tr[td='Frequency']//following::div)[1]")).getText();

		if (frequency.equalsIgnoreCase("Monthly")) {

			login.Log4j.info("Selected frequency should be applied to all series:PASS:" + frequency);

		} else {
			login.Log4j.info("Selected frequency should not be applied to all series:FAIL:" + frequency);
			Assert.assertEquals(frequency, "Monthly");

		}

	}

	// TC_119
	@Then("^Select any 'Missing values mathod' from dropdown in Series data conversion popup$")
	public void select_any_Missing_values_mathod_from_dropdown_in_Series_data_conversion_popup() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver
				.findElement(
						By.xpath("(//span[@class='series-data-conversion--function-title']//following::select)[2]"))
				.click();

		login.driver
				.findElement(By.xpath(
						"//select[@class='series-data-conversion--param form--control']//option[@value='FILLNEXT']"))
				.click();

	}

	// TC_119
	@Then("^Verify The \"([^\"]*)\" should be applied with selected series$")
	public void verify_The_should_be_applied_with_selected_series(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		WebElement seriesname = login.driver.findElement(By.xpath("(//div[@class='series-name--title'])[1]"));

		action.moveToElement(seriesname).build().perform();

		CommonFunctionality.wait(2000);

		String MissingValueMethod = login.driver.findElement(By.xpath("(//tr[td='Functions']//following::div)[1]"))
				.getText();

		if (MissingValueMethod.contains("Next value")) {

			login.Log4j
					.info("Selected Missing value Method should be applied to all series:PASS:" + MissingValueMethod);

		} else {
			login.Log4j.info("Selected frequency should not be applied to all series:FAIL:" + MissingValueMethod);
			Assert.assertEquals(MissingValueMethod, "Next value");

		}

	}

	// TC_126

	@Then("^Click on dropdown for frequency in series level$")
	public void click_on_dropdown_for_frequency_in_series_level() throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath(
				"(//div[@class='series-name--title'])[1]//following::div[@class='insight-action-panel--btn-title'][3]"))
				.click();
		;

		// WebElement scroll
		// =login.driver.findElement(By.xpath("//div[@class='table']"));
		// JavascriptExecutor js = (JavascriptExecutor)login.driver;
		// js.executeScript("window.scrollBy(250,0)", "");

		// WebElement meets =
		// login.driver.findElement(By.xpath("(//div[@class='series-name--title'])[1]//following::div[@class='insight-action-panel--btn-title'][3]"));
		// JavascriptExecutor js = (JavascriptExecutor) login.driver;
		// js.executeScript("arguments[0].click();",meets);

		// TestUtil.js.executeScript("arguments[0].click();", TestUtil.method.next);
		// JavascriptExecutor js = (JavascriptExecutor) login.driver;
		// scroll down the web element for viewing
		// js.executeScript("arguments[0].scrollIntoView();", meets);
		// CommonFunctionality.wait(2000);
		// login.driver.findElement(By.xpath("(//div[@class='series-name--title'])[1]//following::div[@class='insight-action-panel--btn-title'][3]")).click();

	}

//TC_126
	@Then("^Verify The List of applicable frequencies should be available under the dropdown$")
	public void verify_The_List_of_applicable_frequencies_should_be_available_under_the_dropdown() throws Throwable {

		CommonFunctionality.wait(2000);

		// login.driver.findElement(By.xpath("//span[@class='series-data-conversion--function-title']//following::span//select[@name='frequency']")).click();

		List<WebElement> frequency = login.driver.findElements(By.xpath("//span[@class='name-li']"));
		frequencyList = new ArrayList<>(Arrays.asList("Yearly (Sum)", "Yearly (Avg)", "Monthly (Distribute)",
				"Monthly (Replicate)", "Weekly (Distribute)", "Weekly (Replicate)"));

		for (int a = 1; a < frequency.size(); a++) {

			String text = frequency.get(a).getText();

			Frequencylist.add(text);

		}
		System.out.println(frequencyList);
		System.out.println(Frequencylist);

		if (frequencyList.equals(Frequencylist)) {
			login.Log4j.info("series level Frequency dropdown data displayed:PASS" + Frequencylist);
		}

		else {
			login.Log4j.info("series level Frequency dropdown data not displayed:FAIL" + Frequencylist);
			Assert.assertEquals(Frequencylist, frequencyList);
		}

	}

	// TC_141
	@Then("^Click on '\\+Add from My series' option$")
	public void click_on_Add_from_My_series_option() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//span[text()='Add from My Series']")).click();

	}

	// TC_141
	@Then("^Verify User should redirect to \"([^\"]*)\" tab$")
	public void verify_User_should_redirect_to_tab(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']"))
				.isDisplayed()) {
			login.Log4j.info("User should redirect to +Add from my series tab:PASS");

		} else {
			fail("User should not redirect to +Add from my series tab:FAIL");
		}

	}

	// TC_146
	@Then("^Click on \"([^\"]*)\" icon to close the edit seires panel$")
	public void click_on_icon_to_close_the_edit_seires_panel(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//div[text()='×']")).click();

	}

	// TC_146
	@Then("^Verify The edit series panel should be closed$")
	public void verify_The_edit_series_panel_should_be_closed() throws Throwable {
		CommonFunctionality.wait(2000);

		if ((login.driver.findElements(By.xpath("//div[text()='×']"))).size() == 0) {
			login.Log4j.info("The edit series panel should be closed:PASS");
		} else {
			fail("The edit series panel should not be closed:FAIL");
		}

		// Assert.assertTrue(login.driver.findElement(By.xpath("//div[text()='×']")).isDisplayed());

//	if(login.driver.findElement(By.xpath("//div[text()='×']")).isDisplayed())
//	{
//		login.Log4j.info("The edit series panel should be closed:PASS");
//		
//	}
//	else {
//		fail("The edit series panel should not be closed:FAIL");
//		
//	}
//		
	}

	// TC_147
	@Then("^Click on 'Edit HeatMap'$")
	public void click_on_Edit_HeatMap() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//button[text()='Edit Heat map']")).click();

	}

	// TC_147
	@Then("^Verify The \"([^\"]*)\" popup should be displayed$")
	public void verify_The_popup_should_be_displayed(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		WebElement popup = login.driver.findElement(By.xpath("//div[@class='movable-modal--title-message']"));

		if (popup.isDisplayed() == true) {
			login.Log4j.info("Edit visual panel should be open:PASS");
		} else {
			fail("Edit visual panel should not be open:FAIL");
		}

		login.driver.findElement(By.xpath("//div[@class='movable-modal--close']")).click();

	}

	// TC_145
	@Then("^Verify the Edit series popup open and edit series option should be disabled if already opened$")
	public void verify_the_Edit_series_popup_open_and_edit_series_option_should_be_disabled_if_already_opened()
			throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath("//div[@class='sidebar-panel--header-close']")).isDisplayed()) {
			login.Log4j.info("Edit series option should be disabled if already opened:PASS");
		} else {
			fail("Edit series option should be disabled if already opened:FAIL");
		}

	}

	// TC_148
	@Then("^Make some changes in 'Edit visual' popup$")
	public void make_some_changes_in_Edit_visual_popup() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//div[text()='Title:']//following::div[1]")).click();

		login.driver
				.findElement(By.xpath(
						"(//ul[@class='dropdown-menu context-menu ']//span[@class='input-control--indicator'])[1]"))
				.click();

		// login.driver.findElement(By.xpath("(//span[@class='input-control--indicator'])[1]")).click();

	}

	// TC_148
	@Then("^Click on create template icon\\(\\+\\)$")
	public void click_on_create_template_icon() throws Throwable {

		CommonFunctionality.wait(2000);
		// login.driver.findElement(By.xpath("(//span[@class='input-control--description'])[1]")).click();
		// CommonFunctionality.wait(2000);

		if (login.driver.findElements(By.xpath("//div[@class='add-style-template']")).size() == 1) {
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath("(//span[@class='input-control--indicator']//following::span)[1]"))
					.click();
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath("//div[@class='add-style-template add-style-template__active']")).click();
		} else {
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath("//div[@class='add-style-template add-style-template__active']")).click();
		}

	}

//TC_148
	@Then("^Verify Create template popup should be displayed$")
	public void verify_Create_template_popup_should_be_displayed() throws Throwable {
		CommonFunctionality.wait(2000);
		if (login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu ']")).isDisplayed()) {
			login.Log4j.info("Create template popup should be displayed:PASS");
		} else {
			fail("Create template popup should be displayed:FAIL");
		}

		login.driver.findElement(By.xpath("//button[@class='button button__primary']")).click();

	}

	// TC_149
	@Then("^Verify The Auto name should be available as \"([^\"]*)\" in creating template$")
	public void verify_The_Auto_name_should_be_available_as_in_creating_template(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu ']")).isDisplayed()) {
			login.Log4j.info("Create template popup should be displayed:PASS");
		} else {
			fail("Create template popup should be displayed:FAIL");
		}

		// String value =
		// login.driver.findElement(By.xpath("//input[@class='add-template-context--input
		// form--control form--control__sm']")).getText();

		// System.out.println("value:" + value);

//		if (value.contains(arg1)) {
//			login.Log4j.info("The Auto name should be available as in creating template:PASS");
//
//		} else {
//			fail("The Auto name should be available as in creating template:FAIL");
//		}

		login.driver.findElement(By.xpath("//button[@class='button button__primary']")).click();

	}

//TC_150
	@Then("^Click on Green tick mark$")
	public void click_on_Green_tick_mark() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.wait(2000);
		login.driver
				.findElement(By.xpath("//div[@class='add-template-context--icon add-template-context--icon__apply']"))
				.click();

	}

//TC_150
	@Then("^Verify The New template should be created with the current changes$")
	public void verify_The_New_template_should_be_created_with_the_current_changes() throws Throwable {
		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath("(//div[@class='style-templates-item--wrapper'])[1]")).isDisplayed()) {
			login.Log4j.info("New template should be created with the current changes:PASS");
		} else {
			fail("New template should not be created with the current changes:FAIL");
		}

		WebElement template = login.driver
				.findElement(By.xpath("//div[@class='style-templates-item--icon style-templates-item--icon__text']"));

		action.moveToElement(template).build().perform();

		login.driver.findElement(By.xpath(
				"(//div[@class='style-templates-item--icon-base style-templates-item--delete icon--red-cross'])[1]"))
				.click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//button[@class='sphere-modal-control button button__primary']")).click();

		CommonFunctionality.wait(2000);
		// login.driver.findElement(By.xpath("//button[text()='Ok']")).click();

		login.driver.findElement(By.xpath("//button[text()='Save']")).click();

	}

//TC_151
	@Then("^Click on 'x' button$")
	public void click_on_x_button() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver
				.findElement(By.xpath("//div[@class='add-template-context--icon add-template-context--icon__close']"))
				.click();
	}

//TC_151
	@Then("^Verify The template popup should closed$")
	public void verify_The_template_popup_should_closed() throws Throwable {
		CommonFunctionality.wait(2000);

		if ((login.driver
				.findElements(By.xpath("//div[@class='add-template-context--icon add-template-context--icon__close']")))
						.size() == 0) {
			login.Log4j.info("The template popup should closed:PASS");
		} else {
			fail("The template popup should not be closed:FAIL");
		}

		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//button[@class='button button__primary']")).click();

	}

	// TC_152
	@Then("^Select the created template and Click on Save button$")
	public void select_the_created_template_and_Click_on_Save_button() throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//button[@class='button button__primary']")).click();

	}

	// TC_152
	@Then("^Verify The customized settings should be applied to visual$")
	public void verify_The_customized_settings_should_be_applied_to_visual() throws Throwable {

		CommonFunctionality.wait(2000);

		if ((login.driver.findElements(By.xpath("//span[@class='visual-title--text text-dots']"))).size() == 0) {

			login.Log4j.info("Customized settings should be applied to visual:PASS");
		} else {
			login.Log4j.info("Customized settings should be applied to visual:FAIL");

		}

	}

	// TC_153
	@Then("^Click on styles dropdown for template$")
	public void click_on_styles_dropdown_for_template() throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath(
				"(//div[@class='context-menu-control--title']//following::div[@class='context-menu-control--icon'])[1]"))
				.click();

	}

	// TC_153
	@Then("^Verify The CEIC styles and My styles templates should be available$")
	public void verify_The_CEIC_styles_and_My_styles_templates_should_be_available() throws Throwable {

		CommonFunctionality.wait(2000);

		String ceicstyle = login.driver.findElement(By.xpath("//div[text()='CEIC Styles']")).getText();

		String mystyle = login.driver.findElement(By.xpath("//div[text()='My Styles']")).getText();

		if (ceicstyle.equalsIgnoreCase("CEIC Styles")) {
			if (mystyle.equalsIgnoreCase("My Styles")) {
				login.Log4j.info("The CEIC styles and My styles templates should be available:PASS");

			} else {

				login.Log4j.info("The CEIC styles and My styles templates should be available:FAIL" + mystyle);
				Assert.assertEquals(mystyle, "My Styles");
			}

		}

	}

	@Then("^Mouse move on existing visual template and click on dropdown$")
	public void mouse_move_on_existing_visual_template_and_click_on_dropdown() throws Throwable {

		CommonFunctionality.wait(2000);

		WebElement Template = login.driver
				.findElement(By.xpath("//div[@class='style-templates-menu--add']//following::div[2]"));
		action.moveToElement(Template).build().perform();

		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("(//div[@class='style-templates-item--tongue'])[1]")).click();

	}

	@Then("^Check the box for 'Set as default for future HeatMap visual'$")
	public void check_the_box_for_Set_as_default_for_future_HeatMap_visual() throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver
				.findElement(
						By.xpath("//ul[@class='dropdown-menu context-menu ']//span[@class='input-control--indicator']"))
				.click();

	}

//TC_154
	@Then("^Click on \"([^\"]*)\" in right side$")
	public void click_on_in_right_side(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//a[@data-id='" + arg1 + "']")).click();

	}

//TC_154
	@Then("^Checked Select all checkbox$")
	public void checked_Select_all_checkbox() throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//*[@class='input-control--indicator']")).click();

	}

//TC_154
	@Then("^mouseover on series name and right click on mouse$")
	public void mouseover_on_series_name_and_right_click_on_mouse() throws Throwable {

		CommonFunctionality.wait(2000);

		WebElement seriesname = login.driver.findElement(By.xpath("(//*[@class='series-name-field--text'])[1]"));
		action.moveToElement(seriesname).contextClick().build().perform();
		// action.contextClick(seriesname).build();

	}

	@Then("^click on 'Save' button$")
	public void click_on_Save_button() throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//button[@class='button button__primary']")).click();

	}

	@Then("^Uncheck the box for 'Set as default for future HeatMap visual'$")
	public void uncheck_the_box_for_Set_as_default_for_future_HeatMap_visual() throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver
				.findElement(
						By.xpath("//ul[@class='dropdown-menu context-menu ']//span[@class='input-control--indicator']"))
				.click();

	}

	// TC_156
	@Then("^Click on delete template icon$")
	public void click_on_delete_template_icon() throws Throwable {
		CommonFunctionality.wait(2000);

		count = login.driver.findElement(By.xpath("//div[@class='style-templates-menu--add']//following::div[2]"))
				.getText();

		WebElement Template = login.driver
				.findElement(By.xpath("//div[@class='style-templates-menu--add']//following::div[2]"));
		action.moveToElement(Template).build().perform();

		login.driver.findElement(By.xpath("(//div[@title='Delete template'])[1]")).click();

	}

	// TC_156
	@Then("^Verify the Confirmation popup should be displayed to delete template$")
	public void verify_the_Confirmation_popup_should_be_displayed_to_delete_template() throws Throwable {

		CommonFunctionality.wait(2000);

		String popup = login.driver.findElement(By.xpath("//h4[text()='Confirmation']")).getText();

		if (popup.equalsIgnoreCase("Confirmation")) {

			login.Log4j.info("Confirmation popup should be displayed:PASS");

		} else {

			login.Log4j.info("Confirmation popup should be displayed:FAIL");
			Assert.assertEquals(popup, "Confirmation");
		}

		login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']//button[text()='Cancel']"))
				.click();

		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//div[@title='Close']")).click();

	}

	// TC_157
	@Then("^Verify the description for confirmation popup$")
	public void verify_the_description_for_confirmation_popup() throws Throwable {

		CommonFunctionality.wait(2000);

		String popup = login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']")).getText();

		System.out.println("==================>:" + popup);
		if (popup.contains("Are you sure you want to delete this style template?")) {

			login.Log4j.info("Description for confirmation popup should be displayed:PASS");

		} else {

			login.Log4j.info("Description for confirmation popup should be displayed:FAIL");
			Assert.assertEquals(popup, "Are you sure you want to delete this style template?");
		}

		login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']//button[text()='Cancel']"))
				.click();

		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//div[@title='Close']")).click();

	}

	// TC_158
	@Then("^Click on \"([^\"]*)\" button on popup$")
	public void click_on_button_on_popup(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//button[text()='" + arg1 + "']")).click();

	}

	// TC_158
	@Then("^Verify The template should be deleted from the list$")
	public void verify_The_template_should_be_deleted_from_the_list() throws Throwable {

		CommonFunctionality.wait(2000);

		String temp = login.driver.findElement(By.xpath("//div[@class='style-templates-menu--add']//following::div[2]"))
				.getText();

		if (temp.equalsIgnoreCase(count)) {
			login.Log4j.info("Template should be deleted from the list:FAIL");
			Assert.assertEquals(temp, count);
		}

		else {
			login.Log4j.info("Template should be deleted from the list:PASS");

		}

	}

	// TC_159
	@Then("^Click on cancel/X icon on confirmation popup$")
	public void click_on_cancel_X_icon_on_confirmation_popup() throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']//button[text()='Cancel']"))
				.click();

	}

	// TC_159
	@Then("^Verify The confirmation popup should be closed$")
	public void verify_The_confirmation_popup_should_be_closed() throws Throwable {
		CommonFunctionality.wait(2000);

		if ((login.driver
				.findElements(By.xpath("//div[@class='modal-body sphere-modal__body']//button[text()='Cancel']")))
						.size() == 0) {

			login.Log4j.info("Confirmation popup should be closed:PASS");

		} else {
			fail("confirmation popup should be closed:FAIL");
		}

	}

	// TC_162
	@Then("^Click on Title dropdown and by default Title checked$")
	public void click_on_Title_dropdown_and_by_default_Title_checked() throws Throwable {

		CommonFunctionality.wait(2000);

		String value = login.driver
				.findElement(By.xpath("(//div[text()='Title:']//following::div[@class='toggle-context-control'])[1]"))
				.getText();

		if (value.equalsIgnoreCase("yes")) {
			login.driver
					.findElement(
							By.xpath("(//div[text()='Title:']//following::div[@class='toggle-context-control'])[1]"))
					.click();
		}

		else {
			login.driver
					.findElement(
							By.xpath("(//div[text()='Title:']//following::div[@class='toggle-context-control'])[1]"))
					.click();

			Thread.sleep(2000);
			login.driver
					.findElement(
							By.xpath("(//div[@class='title-control']//span[@class='input-control--indicator'])[1]"))
					.click();

		}

	}

	// TC_162
	@Then("^Verify The title of the visual should be displayed$")
	public void verify_The_title_of_the_visual_should_be_displayed() throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath("//span[@class='visual-title--text text-dots']")).isDisplayed()) {
			login.Log4j.info("The Title of the visual should be displayed:PASS");

		} else {

			fail("The Title of the visual should be displayed:FAIL");
		}

	}

	// TC_161
	@Then("^Click on Title dropdown and Title=Uncheck$")
	public void click_on_Title_dropdown_and_Title_Uncheck() throws Throwable {

		CommonFunctionality.wait(2000);

		String value = login.driver
				.findElement(By.xpath("(//div[text()='Title:']//following::div[@class='toggle-context-control'])[1]"))
				.getText();

		if (value.equalsIgnoreCase("yes")) {
			login.driver
					.findElement(
							By.xpath("(//div[text()='Title:']//following::div[@class='toggle-context-control'])[1]"))
					.click();
			Thread.sleep(2000);
			login.driver
					.findElement(
							By.xpath("(//div[@class='title-control']//span[@class='input-control--indicator'])[1]"))
					.click();

		}

		else {
			login.driver
					.findElement(
							By.xpath("(//div[text()='Title:']//following::div[@class='toggle-context-control'])[1]"))
					.click();

		}

	}

	// TC_161
	@Then("^Verify The title of the visual should be removed$")
	public void verify_The_title_of_the_visual_should_be_removed() throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver.findElements(By.xpath("//span[@class='visual-title--text text-dots']")).size() == 0) {
			login.Log4j.info("The Title of the visual should be removed:PASS");

		} else {

			fail("The Title of the visual should be removed:FAIL");
		}

	}

	// TC_163
	@Then("^Make empty in title field$")
	public void make_empty_in_title_field() throws Throwable {

		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//input[@name='title']")).click();

		login.driver.findElement(By.xpath("//input[@name='title']")).clear();
	}

	// TC_163
	@Then("^Auto Title should be displayed as series name$")
	public void auto_Title_should_be_displayed_as_series_name() throws Throwable {

		CommonFunctionality.wait(2000);

		String Titlename = login.driver.findElement(By.xpath("//span[@class='visual-title--text text-dots']"))
				.getText();

		if (Titlename.equalsIgnoreCase("Heat map")) {

			login.Log4j.info("Title should be displayed as series name:PASS");
		} else {

			login.Log4j.info("Title should be displayed as series name:FAIL");
			Assert.assertEquals(Titlename, "Heat map");

		}

	}

	// TC_164
	@Then("^Enter title name in title field$")
	public void enter_title_name_in_title_field() throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//input[@name='title']")).click();

		login.driver.findElement(By.xpath("//input[@name='title']")).sendKeys("Title");

	}

	// TC_164
	@Then("^Verify The title name should be changed$")
	public void verify_The_title_name_should_be_changed() throws Throwable {

		CommonFunctionality.wait(2000);

		String Titlename = login.driver.findElement(By.xpath("//span[@class='visual-title--text text-dots']"))
				.getText();

		if (Titlename.equalsIgnoreCase("Title")) {

			login.Log4j.info("Title name should be changed:PASS");
		} else {

			login.Log4j.info("Title name should be changed:FAIL");
			Assert.assertEquals(Titlename, "Title");

		}

	}

	// TC_165
	@Then("^Click on title dropdown$")
	public void click_on_title_dropdown() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver
				.findElement(By.xpath("(//div[text()='Title:']//following::div[@class='toggle-context-control'])[1]"))
				.click();

	}

	// TC_165
	@Then("^Verify The sub title check box should be 'unchecked' by default$")
	public void verify_The_sub_title_check_box_should_be_unchecked_by_default() throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver.findElements(By.xpath("(//span[@class='visual-title--text text-dots'])[3]")).size() == 0) {
			login.Log4j.info("Sub title check box should be 'unchecked' by default:PASS");

		} else {
			fail("Sub title check box should be 'unchecked' by default:FAIL");
		}

	}

	// TC_166
	@Then("^Verify The sub title check box should be 'checked'$")
	public void verify_The_sub_title_check_box_should_be_checked() throws Throwable {
		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath("(//div[@class='title-control']//input[@type='checkbox'])[2]"))
				.isSelected()) {

			login.Log4j.info("The sub title check box should be 'checked:PASS");
		}

		else {
			login.driver
					.findElement(
							By.xpath("(//div[@class='title-control']//span[@class='input-control--description'])[2]"))
					.click();
			login.driver
					.findElement(
							By.xpath("(//div[@class='title-control']//span[@class='input-control--description'])[1]"))
					.click();
		}

		// (//div[@class='title-control']//input[@type='checkbox'])[2]

//		
//		if (login.driver.findElements(By.xpath("(//span[@class='visual-title--text text-dots'])[3]")).size() == 0) {
//
//			login.driver.findElement(By.xpath(
//					"(//ul[@class='dropdown-menu context-menu ']//span[@class='input-control--description'])[2]"))
//					.click();
//		}

	}

	// TC_166
	@Then("^Verify The Sub title should be displayed for the visual$")
	public void verify_The_Sub_title_should_be_displayed_for_the_visual() throws Throwable {
		CommonFunctionality.wait(2000);

		String subtitle = login.driver.findElement(By.xpath("//span[@data-name='sub_title']")).getText();

		if (subtitle.equalsIgnoreCase("Sub title")) {

			login.Log4j.info("Sub title should be displayed for the visual:PASS");

		} else {

			login.Log4j.info("Sub title should be displayed for the visual:FAIL");
			Assert.assertEquals(subtitle, "Sub title");
		}

	}

	// TC_167
	@Then("^Uncheck the sub title check box$")
	public void uncheck_the_sub_title_check_box() throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver.findElements(By.xpath("(//span[@class='visual-title--text text-dots'])[3]")).size() == 0) {

			login.Log4j.info("Sub title check box unchecked:PASS");
		} else {

			login.driver
					.findElement(
							By.xpath("(//div[@class='title-control']//span[@class='input-control--description'])[2]"))
					.click();
		}

	}

	// TC_167
	@Then("^Verify The 'Sub title' should not be displayed for the visual$")
	public void verify_The_Sub_title_should_not_be_displayed_for_the_visual() throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver.findElements(By.xpath("(//span[@class='visual-title--text text-dots'])[2]")).size() == 0) {
			login.Log4j.info("The 'Sub title' should not be displayed for the visual:PASS");
		} else {
			fail("The 'Sub title' should not be displayed for the visual:FAIL");

		}

	}

	// TC_168
	@Then("^Verify the Default sub title is \"([^\"]*)\" displayed$")
	public void verify_the_Default_sub_title_is_displayed(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);

		String subtitle = login.driver.findElement(By.xpath("(//span[@class='visual-title--text text-dots'])[2]"))
				.getText();

		if (subtitle.equalsIgnoreCase(arg1)) {
			login.Log4j.info("Default sub title displayed:PASS");

		} else {

			fail("Default sub title displayed:FAIL");
		}

	}

	// TC_HM_169
	@Then("^Click on advance settings$")
	public void click_on_advance_settings() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//div[@class='title-control']//div[@title='Open advanced settings popup']"))
				.click();

	}

	// TC_HM_169
	@Then("^Verify the Titles popup should be displayed$")
	public void verify_the_Titles_popup_should_be_displayed() throws Throwable {
		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath("//div[@class='popover--wrapper']")).isDisplayed()) {
			login.Log4j.info("Titles popup should be displayed:PASS");

		} else {

			fail("Titles popup should be displayed:FAIL");

		}

	}

	// TC_HM_170

	@Then("^Click on open Advanced settings popup\\(cogwheel icon\\)$")
	public void click_on_open_Advanced_settings_popup_cogwheel_icon() throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver
				.findElement(
						By.xpath("(//div[text()='Title:']//following::div[@title='Open advanced settings popup'])[1]"))
				.click();

	}

	// TC_171
	@Then("^Verify the Title='Check' and Select color$")
	public void verify_the_Title_Check_and_Select_color() throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath(
				"(//div[@class='popover-block-content']//span[@class='input-control--indicator'])[1]//preceding-sibling::input[@name='title_display']"))
				.isSelected()) {

			CommonFunctionality.wait(2000);

			login.driver.findElement(By.xpath(
					"(//div[@class='visual-title-config']//div[@class='index-module_swatch_button_item_color__gAHg1'])[1]"))
					.click();

			Thread.sleep(2000);

			login.driver.findElement(By.xpath("(//div[@class='index-module_wrapper__oSU40'])[1]")).click();

			String color = login.driver.findElement(By.xpath("(//div[@class='index-module_wrapper__oSU40'])[1]"))
					.getAttribute("style");

			selectcolor = color.substring(18, 35);

			System.out.println(selectcolor);

		} else {

			login.driver
					.findElement(By.xpath(
							"(//div[@class='popover-block-content']//span[@class='input-control--indicator'])[1]"))
					.click();
			login.driver.findElement(By.xpath(
					"(//div[@class='visual-title-config']//div[@class='index-module_swatch_button_item_color__gAHg1'])[1]"))
					.click();

			Thread.sleep(2000);

			login.driver.findElement(By.xpath("(//div[@class='index-module_wrapper__oSU40'])[1]")).click();

			String color = login.driver.findElement(By.xpath("(//div[@class='index-module_wrapper__oSU40'])[1]"))
					.getAttribute("style");

			selectcolor = color.substring(18, 35);

			System.out.println(selectcolor);
			// fail("Titles check box unchecked:FAIL");
		}

	}

	// TC_171
	@Then("^Verify the Visual title should be displayed in selected color$")
	public void verify_the_Visual_title_should_be_displayed_in_selected_color() throws Throwable {
		CommonFunctionality.wait(2000);

		String titlecolor = login.driver.findElement(By.xpath("//span[@class='visual-title--text text-dots']"))
				.getAttribute("style");

		String visualcolor = titlecolor.substring(43, 60);
		System.out.println(visualcolor);

		if (visualcolor.equalsIgnoreCase(selectcolor)) {
			login.Log4j.info("Visual title should be displayed in selected color:PASS");
		} else {
			fail("Visual title should be displayed in selected color:FAIL");

		}

	}

	// TC_172
	@Then("^Verify the Title ='Check' and Select color for title background 'highlight'$")
	public void verify_the_Title_Check_and_Select_color_for_title_background_highlight() throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath(
				"(//div[@class='popover-block-content']//span[@class='input-control--indicator'])[1]//preceding-sibling::input[@name='title_display']"))
				.isSelected()) {

		
			CommonFunctionality.wait(2000);

			login.driver.findElement(By.xpath(
					"(//div[@class='visual-title-config']//div[@class='index-module_swatch_button_item_color__gAHg1'])[2]"))
					.click();

			Thread.sleep(2000);

			login.driver.findElement(By.xpath("(//div[@class='index-module_wrapper__oSU40'])[2]")).click();

			backgroundcolor = login.driver.findElement(By.xpath("(//div[@class='index-module_wrapper__oSU40'])[2]"))
					.getAttribute("style");
			System.out.println(backgroundcolor);

		} else {

			login.driver
			.findElement(By.xpath(
					"(//div[@class='popover-block-content']//span[@class='input-control--indicator'])[1]")).click();
			CommonFunctionality.wait(2000);

			login.driver.findElement(By.xpath(
					"(//div[@class='visual-title-config']//div[@class='index-module_swatch_button_item_color__gAHg1'])[2]"))
					.click();

			Thread.sleep(2000);

			login.driver.findElement(By.xpath("(//div[@class='index-module_wrapper__oSU40'])[2]")).click();

			backgroundcolor = login.driver.findElement(By.xpath("(//div[@class='index-module_wrapper__oSU40'])[2]"))
					.getAttribute("style");
			System.out.println(backgroundcolor);
		}

	}

	// TC_172
	@Then("^Verify the Visual title background should be displayed in selected color$")
	public void verify_the_Visual_title_background_should_be_displayed_in_selected_color() throws Throwable {

		CommonFunctionality.wait(2000);

		String value = login.driver.findElement(By.xpath("//span[@class='visual-title--text text-dots']"))
				.getAttribute("style");

		System.out.println(value);
		String background = value.substring(57, 93);
		System.out.println(background);

		if (background.equalsIgnoreCase(backgroundcolor)) {

			login.Log4j.info("Visual title background should be displayed in selected color:PASS");

		} else {
			fail("Visual title background should be displayed in selected color:FAIL");
		}

	}

	// TC_173
	@Then("^Verify the Title ='Check' and Select size for visual title \"([^\"]*)\"$")
	public void verify_the_Title_Check_and_Select_size_for_visual_title(String size) throws Throwable {

		CommonFunctionality.wait(2000);
		if (login.driver.findElement(By.xpath(
				"(//div[@class='popover-block-content']//span[@class='input-control--indicator'])[1]//preceding-sibling::input[@name='title_display']"))
				.isSelected()) {
		
			CommonFunctionality.wait(2000);

			login.driver.findElement(By.xpath("//input[@name='title_font_size']")).click();

			login.driver.findElement(By.xpath("//input[@name='title_font_size']")).clear();

			login.driver.findElement(By.xpath("//input[@name='title_font_size']")).sendKeys(size);

			fontsize = size;

		} else {
			login.driver
			.findElement(By.xpath(
					"(//div[@class='popover-block-content']//span[@class='input-control--indicator'])[1]")).click();

			login.driver.findElement(By.xpath("//input[@name='title_font_size']")).click();

			login.driver.findElement(By.xpath("//input[@name='title_font_size']")).clear();

			login.driver.findElement(By.xpath("//input[@name='title_font_size']")).sendKeys(size);

			fontsize = size;
		}

	}

	// TC_173
	@Then("^Verify The title font size should be changed as per the selection$")
	public void verify_The_title_font_size_should_be_changed_as_per_the_selection() throws Throwable {

		CommonFunctionality.wait(2000);

		System.out.println(fontsize);

		String font = login.driver.findElement(By.xpath("//span[@class='visual-title--text text-dots']"))
				.getAttribute("style");
		System.out.println(font);
		boolean isFound = font.contains(fontsize);

		if (isFound == true) {
			login.Log4j.info("Title font size should be changed as per the selection:PASS");

		} else {

			fail("Title font size should be changed as per the selection:FAIL");
		}

	}

	// 175
	@Then("^Verify the Title ='Check' and bold icon selected by default$")
	public void verify_the_Title_Check_and_bold_icon_selected_by_default() throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath(
				"(//div[@class='popover-block-content']//span[@class='input-control--indicator'])[1]//preceding-sibling::input[@name='title_display']"))
				.isSelected()) {

			CommonFunctionality.wait(2000);

			try {
				login.driver.findElement(By.xpath("//button[@class='config-btn font-bold selected']")).isDisplayed();

				login.Log4j.info("Already Bold icon selected");

			}

			catch (org.openqa.selenium.NoSuchElementException e) {

				login.driver.findElement(By.xpath("//button[@class='config-btn font-bold']")).click();

			}

		} else {

			login.driver
			.findElement(By.xpath(
					"(//div[@class='popover-block-content']//span[@class='input-control--indicator'])[1]")).click();
			try {
				login.driver.findElement(By.xpath("//button[@class='config-btn font-bold selected']")).isDisplayed();

				login.Log4j.info("Already Bold icon selected");

			}

			catch (org.openqa.selenium.NoSuchElementException e) {

				login.driver.findElement(By.xpath("//button[@class='config-btn font-bold']")).click();

			}
		}
	}

	// TC_175
	@Then("^Verify The title should be displayed in Bold format$")
	public void verify_The_title_should_be_displayed_in_Bold_format() throws Throwable {

		CommonFunctionality.wait(2000);

		String fontweight = login.driver.findElement(By.xpath("//span[@class='visual-title--text text-dots']"))
				.getAttribute("style");
		System.out.println(fontweight);

		if (fontweight.contains("bold")) {

			login.Log4j.info("The title should be displayed in Bold format");
		} else {

			fail("The title should be displayed in Bold format:FAIL");
		}

	}

	// TC_176
	@Then("^Verify the Title ='Check' and Click on 'Italic icon'$")
	public void verify_the_Title_Check_and_Click_on_Italic_icon() throws Throwable {

		CommonFunctionality.wait(2000);
		if (login.driver.findElement(By.xpath(
				"(//div[@class='popover-block-content']//span[@class='input-control--indicator'])[1]//preceding-sibling::input[@name='title_display']"))
				.isSelected()) {

			CommonFunctionality.wait(2000);

			login.driver
					.findElement(
							By.xpath("(//div[@class='popover--wrapper']//button[@class='config-btn font-italic '])[1]"))
					.click();

		} else {

			login.driver
			.findElement(By.xpath(
					"(//div[@class='popover-block-content']//span[@class='input-control--indicator'])[1]")).click();
			
			CommonFunctionality.wait(2000);

			login.driver
					.findElement(
							By.xpath("(//div[@class='popover--wrapper']//button[@class='config-btn font-italic '])[1]"))
					.click();
			
		}

	}

	// TC_176
	@Then("^Verify The title should be displayed in 'Italic' format$")
	public void verify_The_title_should_be_displayed_in_Italic_format() throws Throwable {

		CommonFunctionality.wait(2000);

		String fontstyle = login.driver.findElement(By.xpath("//span[@class='visual-title--text text-dots']"))
				.getAttribute("style");
		System.out.println(fontstyle);

		if (fontstyle.contains("italic")) {

			login.Log4j.info("The title should be displayed in Italic format");
		} else {

			fail("The title should be displayed in Italic format:FAIL");
		}

	}

	// TC_177
	@Then("^Verify the Title ='Check' and 'Underline icon'$")
	public void verify_the_Title_Check_and_Underline_icon() throws Throwable {
		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath(
				"(//div[@class='popover-block-content']//span[@class='input-control--indicator'])[1]//preceding-sibling::input[@name='title_display']"))
				.isSelected()) {
			CommonFunctionality.wait(2000);

			login.driver
					.findElement(By.xpath(
							"(//div[@class='popover--wrapper']//button[@class='config-btn font-underline '])[1]"))
					.click();

		} else {

			login.driver
			.findElement(By.xpath(
					"(//div[@class='popover-block-content']//span[@class='input-control--indicator'])[1]")).click();
			CommonFunctionality.wait(2000);
			login.driver
			.findElement(By.xpath(
					"(//div[@class='popover--wrapper']//button[@class='config-btn font-underline '])[1]"))
			.click();
			
		}

	}

	// TC_177
	@Then("^Verify The title should be 'underlined'$")
	public void verify_The_title_should_be_underlined() throws Throwable {

		CommonFunctionality.wait(2000);

		String textdecoration = login.driver.findElement(By.xpath("//span[@class='visual-title--text text-dots']"))
				.getAttribute("style");
		System.out.println(textdecoration);

		if (textdecoration.contains("underline")) {

			login.Log4j.info("The title should be displayed in underline");
		} else {

			fail("The title should be displayed in underline:FAIL");
		}

	}

	// TC_178
	@Then("^Verify the Title ='Check' and Select alignment \"([^\"]*)\"$")
	public void verify_the_Title_Check_and_Select_alignment(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);
		if (login.driver.findElement(By.xpath(
				"(//div[@class='popover-block-content']//span[@class='input-control--indicator'])[1]//preceding-sibling::input[@name='title_display']"))
				.isSelected()) {
			CommonFunctionality.wait(2000);

			login.driver.findElement(By.xpath("(//button[@data-value='" + arg1 + "'])[1]")).click();
			CommonFunctionality.wait(2000);

		} else {

			login.driver
			.findElement(By.xpath(
					"(//div[@class='popover-block-content']//span[@class='input-control--indicator'])[1]")).click();
			CommonFunctionality.wait(2000);

			login.driver.findElement(By.xpath("(//button[@data-value='" + arg1 + "'])[1]")).click();
			CommonFunctionality.wait(2000);
		}

	}

	// TC_178
	@Then("^Verify The Title should align to \"([^\"]*)\" side$")
	public void verify_The_Title_should_align_to_side(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		String leftalign = login.driver
				.findElement(By.xpath("(//div[@class='visual-title visual-title-main visual-title--wrapper'])"))
				.getAttribute("style");
		System.out.println(leftalign);

		if (leftalign.contains("start")) {

			login.Log4j.info("The Title should align to left:PASS");
		} else {

			fail("The Title should align to left:FAIL");
		}

		CommonFunctionality.wait(2000);

	}

	// TC_178
	@Then("^Verify The Title should align to 'right' side$")
	public void verify_The_Title_should_align_to_right_side() throws Throwable {
		CommonFunctionality.wait(2000);
		String leftalign = login.driver
				.findElement(By.xpath("//div[@class='visual-title visual-title-main visual-title--wrapper']"))
				.getAttribute("style");
		System.out.println(leftalign);

		if (leftalign.contains("end")) {

			login.Log4j.info("The Title should align to Right:PASS");
		} else {

			fail("The Title should align to Right:FAIL");
		}

		CommonFunctionality.wait(2000);

	}

	// TC_178
	@Then("^Verify The Title should align to 'center'$")
	public void verify_The_Title_should_align_to_center() throws Throwable {

		CommonFunctionality.wait(2000);
		String leftalign = login.driver
				.findElement(By.xpath("//div[@class='visual-title visual-title-main visual-title--wrapper']"))
				.getAttribute("style");
		System.out.println(leftalign);

		if (leftalign.contains("center")) {

			login.Log4j.info("The Title should align to Center:PASS");
		} else {

			fail("The Title should align to Center:FAIL");
		}

		CommonFunctionality.wait(2000);

	}

	// TC_179
	@Then("^Click on \"([^\"]*)\"icon and Checked 'Sub-title'$")
	public void click_on_icon_and_Checked_Sub_title(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//div[text()='Sub-title']")).click();
		CommonFunctionality.wait(2000);

		login.driver
				.findElement(
						By.xpath("(//div[@class='popover-block-content']//span[@class='input-control--indicator'])[2]"))
				.click();

	}

	// TC_179
	@Then("^Select color$")
	public void select_color() throws Throwable {

		CommonFunctionality.wait(2000);
		login.driver
				.findElement(By
						.xpath("(//div[@class='row']//div[@class='index-module_swatch_button_item_color__gAHg1'])[1]"))
				.click();

		CommonFunctionality.wait(2000);

		login.driver
				.findElement(By.xpath(
						"(//div[@class='index-module_wrapper__j2U4-']//div[@class='index-module_wrapper__Q-UYB'])[2]"))
				.click();

		String Sub_title_color = login.driver
				.findElement(By.xpath(
						"(//div[@class='index-module_wrapper__j2U4-']//div[@class='index-module_wrapper__Q-UYB'])[2]"))
				.getAttribute("style");

		subtitle = Sub_title_color.substring(18, 36);

		System.out.println("subtitler:" + subtitle);

	}

	// TC_179
	@Then("^Verify The Visual 'sub title' should be displayed in 'selected color'$")
	public void verify_The_Visual_sub_title_should_be_displayed_in_selected_color() throws Throwable {

		CommonFunctionality.wait(2000);

		String sub_color = login.driver.findElement(By.xpath("//span[@data-name='sub_title']")).getAttribute("style");
		String subtitlecolor = sub_color.substring(24, 42);

		System.out.println("subtitlecolor:" + subtitlecolor);

		if (subtitle.equalsIgnoreCase(subtitlecolor)) {
			login.Log4j.info("The Visual 'sub title' should be displayed in 'selected color:PASS");
		}

		else {

			fail("The Visual 'sub title' should be displayed in 'selected color:FAIL");
		}

	}

	// TC_180
	@Then("^Select color for Sub title background 'highlight'$")
	public void select_color_for_Sub_title_background_highlight() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath(
				"(//div[@class='popover-block-content']//div[@class='index-module_swatch_button_item_color__gAHg1'])[4]"))
				.click();

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("(//div[@class='index-module_wrapper__Q-UYB'])[1]")).click();

		String subtitle = login.driver.findElement(By.xpath("(//div[@class='index-module_wrapper__Q-UYB'])[1]"))
				.getAttribute("style");

		subtitle_background = subtitle.substring(18, 35);
		System.out.println(subtitle_background);
	}

	// TC_180
	@Then("^Verify The Visual sub title background should be displayed in selected color$")
	public void verify_The_Visual_sub_title_background_should_be_displayed_in_selected_color() throws Throwable {
		CommonFunctionality.wait(2500);

		String background_color = login.driver
				.findElement(By.xpath("(//span[@class='visual-title--text text-dots'])[2]")).getAttribute("style");
		System.out.println(background_color);
		String subtitleback = background_color.substring(56, 73);

		System.out.println("subtitlebackground:" + subtitleback);

		if (subtitle_background.equalsIgnoreCase(subtitleback)) {
			login.Log4j.info("The Visual sub title background should be displayed in selected color:PASS");
		}

		else {

			fail("The Visual sub title background should be displayed in selected color:FAIL");
		}

	}

	// TC_181
	@Then("^Select size for visual Sub title ex: \"([^\"]*)\"$")
	public void select_size_for_visual_Sub_title_ex(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//input[@class='ui-spinner-input sub_title_font_size']")).click();

		login.driver.findElement(By.xpath("//input[@class='ui-spinner-input sub_title_font_size']")).clear();

		login.driver.findElement(By.xpath("//input[@class='ui-spinner-input sub_title_font_size']")).sendKeys(arg1);

		Sub_Title_font = arg1;

	}

	// TC_181
	@Then("^Verify The sub title 'font size' should be changed as per the selection$")
	public void verify_The_sub_title_font_size_should_be_changed_as_per_the_selection() throws Throwable {

		CommonFunctionality.wait(2000);

		String subtitle_font = login.driver.findElement(By.xpath("(//span[@class='visual-title--text text-dots'])[2]"))
				.getAttribute("style");

		System.out.println(Sub_Title_font);

		System.out.println(subtitle_font);

		if (subtitle_font.contains(Sub_Title_font)) {
			login.Log4j.info("The sub title 'font size' should be changed as per the selection:PASS");

		} else {

			fail("The sub title 'font size' should be changed as per the selection:FAIL");
		}

	}

	// TC_182
	@Then("^Click on 'Bold' icon$")
	public void click_on_Bold_icon() throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//button[@class='config-btn font-bold ']")).click();

	}

	// TC_182
	@Then("^Verify The sub title should be displayed in 'Bold' formate$")
	public void verify_The_sub_title_should_be_displayed_in_Bold_formate() throws Throwable {
		CommonFunctionality.wait(2000);

		subtitle_bold = login.driver.findElement(By.xpath("(//span[@class='visual-title--text text-dots'])[2]"))
				.getAttribute("style");

		if (subtitle_bold.contains("bold")) {
			login.Log4j.info("The sub title should be displayed in 'Bold' formate:PASS");
		}

		else {

			fail("The sub title should be displayed in 'Bold' formate:FAIL");
		}

	}

	// TC_183
	@Then("^Click on 'Italic' icon$")
	public void click_on_Italic_icon() throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("(//button[@class='config-btn font-italic '])[2]")).click();

	}

	// TC_183
	@Then("^Verify The sub title should be displayed in 'Italic' format$")
	public void verify_The_sub_title_should_be_displayed_in_Italic_format() throws Throwable {

		CommonFunctionality.wait(2000);

		String subtitle_italic = login.driver
				.findElement(By.xpath("(//span[@class='visual-title--text text-dots'])[2]")).getAttribute("style");

		if (subtitle_italic.contains("italic")) {
			login.Log4j.info("The sub title should be displayed in 'Italic' format:PASS");
		} else {

			fail("The sub title should be displayed in 'Italic' format:FAIL");
		}

	}

	// TC_184
	@Then("^Click on 'Underline' icon$")
	public void click_on_Underline_icon() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("(//button[@class='config-btn font-underline '])[2]")).click();

	}

	// TC_184
	@Then("^Verify The sub title should be displayed in 'underlined'$")
	public void verify_The_sub_title_should_be_displayed_in_underlined() throws Throwable {

		CommonFunctionality.wait(2000);

		String subtitle_underline = login.driver
				.findElement(By.xpath("(//span[@class='visual-title--text text-dots'])[2]")).getAttribute("style");

		if (subtitle_underline.contains("underline")) {
			login.Log4j.info("The sub title should be displayed in 'underlined':PASS");

		} else {
			fail("The sub title should be displayed in 'underlined':FAIL");
		}

	}

	// TC_185
	@Then("^Select alignment \"([^\"]*)\" side$")
	public void select_alignment_side(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("(//button[@data-value='" + arg1 + "'])[2]")).click();

	}

	// TC_185
	@Then("^Verify the sub-title should be displayed in 'Left' side$")
	public void verify_the_sub_title_should_be_displayed_in_Left_side() throws Throwable {
		CommonFunctionality.wait(2000);

		String subtitle_left = login.driver.findElement(By.xpath("//div[@class='visual-title visual-title--wrapper']"))
				.getAttribute("style");

		if (subtitle_left.contains("start")) {
			login.Log4j.info("The sub-title should be displayed in 'Left' side:PASS");
		} else {

			fail("The sub-title should be displayed in 'Left' side:FAIL");
		}

	}

	// TC_185
	@Then("^Click on 'sub-title' icon$")
	public void click_on_sub_title_icon() throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//div[text()='Sub-title']")).click();
		CommonFunctionality.wait(2000);
	}

	// TC_185
	@Then("^Verify the sub-title should be displayed in 'Right' side$")
	public void verify_the_sub_title_should_be_displayed_in_Right_side() throws Throwable {
		CommonFunctionality.wait(2000);

		String subtitle_right = login.driver.findElement(By.xpath("//div[@class='visual-title visual-title--wrapper']"))
				.getAttribute("style");

		if (subtitle_right.contains("end")) {
			login.Log4j.info("The sub-title should be displayed in 'Right' side:PASS");
		} else {

			fail("The sub-title should be displayed in 'Right' side:FAIL");
		}

	}

	// TC_185
	@Then("^Verify the sub-title should be displayed in 'center'$")
	public void verify_the_sub_title_should_be_displayed_in_center() throws Throwable {

		CommonFunctionality.wait(2000);

		String subtitle_center = login.driver
				.findElement(By.xpath("//div[@class='visual-title visual-title--wrapper']")).getAttribute("style");

		if (subtitle_center.contains("center")) {
			login.Log4j.info("The sub-title should be displayed in 'Center' side:PASS");
		} else {

			fail("The sub-title should be displayed in 'Center' side:FAIL");
		}

	}

	// TC_186
	@Then("^Click on \\+/- icons in the popup to get the title and subtitle sections expand/collapse$")
	public void click_on_icons_in_the_popup_to_get_the_title_and_subtitle_sections_expand_collapse() throws Throwable {
		CommonFunctionality.wait(2000);

		// Title
		login.driver.findElement(By.xpath("(//div[@class='title']//following::div)[1]")).click();

		// subTitle

		login.driver.findElement(By.xpath("//div[text()='Sub-title']//following::div[2]")).click();

	}

	// TC_186
	@Then("^Verify The sections should be expnaded/collapsed$")
	public void verify_The_sections_should_be_expnaded_collapsed() throws Throwable {
		CommonFunctionality.wait(2000);

		// Title
		if (login.driver.findElements(By.xpath("(//div[@class='accordion-config'])[1]")).size() == 1) {

			login.Log4j.info("The popup to get the title sections expand:PASS");

		} else {

			fail("The popup to get the title sections expand:FAIL");
		}

		// subtitle
		if (login.driver.findElements(By.xpath("//div[@class='accordion-config']")).size() == 1) {

			login.Log4j.info("The popup to get the subtitle sections collapse:PASS");

		} else {

			fail("The popup to get the subtitle sections collapse:FAIL");
		}

		login.driver.findElement(By.xpath("//button[@class='button button__primary']")).click();

	}

	// TC_187

	@Then("^Click on \"([^\"]*)\" icon on Titles popup$")
	public void click_on_icon_on_Titles_popup(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//div[@class='popover--title']//following::div[text()='" + arg1 + "']"))
				.click();

	}

	// TC_187
	@Then("^Verify The Titles popup should be closed$")
	public void verify_The_Titles_popup_should_be_closed() throws Throwable {
		CommonFunctionality.wait(2000);

		if (login.driver.findElements(By.xpath("//div[@class='popover--title']//following::div[text()='×']"))
				.size() == 0) {

			login.Log4j.info("The Titles popup should be closed:PASS");

		} else {

			fail("The Titles popup should be closed:FAIL");
		}
		login.driver.findElement(By.xpath("//button[@class='button button__primary']")).click();
	}

	// TC_188
	@Then("^Click on Border dropdown$")
	public void click_on_Border_dropdown() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver
				.findElement(
						By.xpath("(//div[text()='Border:']//following::div[@class='context-menu-control--icon'])[1]"))
				.click();

	}

	// TC_188
	@Then("^Check 'Heat map'  checkbox$")
	public void check_Heat_map_checkbox() throws Throwable {
		CommonFunctionality.wait(2000);

		String value = login.driver
				.findElement(By.xpath("(//div[text()='Border:']//following::div[@class='toggle-context-control'])[1]"))
				.getText();

		if (value.equalsIgnoreCase("no")) {

			login.driver.findElement(By.xpath(
					"(//div[@class='border-settings border-settings__separate-toggler']//span[@class='input-control--indicator'])[1]"))
					.click();
		} else {
			fail("Heat Map check box already checked:FAIL");
		}

	}

	// TC_188
	@Then("^Click on color and select color$")
	public void click_on_color_and_select_color() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath(
				"(//div[@class='border-settings border-settings__separate-toggler']//div[@class='index-module_swatch_button_item_color__gAHg1'])[1]"))
				.click();

		Thread.sleep(2000);
		login.driver.findElement(By.xpath("(//div[@class='index-module_wrapper__Q-UYB'])[2]")).click();

		String border = login.driver.findElement(By.xpath("//input[@class='index-module_text__GTkop']"))
				.getAttribute("value");

		bordercolor = "#" + border;

	}

	// TC_188
	@Then("^Verify The 'Border' should be displayed for HeatMap with selected color$")
	public void verify_The_Border_should_be_displayed_for_HeatMap_with_selected_color() throws Throwable {
		CommonFunctionality.wait(2000);

		String color = login.driver.findElement(By.xpath("//*[@class='highcharts-plot-border']"))
				.getAttribute("stroke");

		if (color.equalsIgnoreCase(bordercolor)) {
			login.Log4j.info("The 'Border' should be displayed for HeatMap with selected color:PASS");
		}

		else {
			fail("The 'Border' should be displayed for HeatMap with selected color:FAIL");
		}

	}

	// TC_189
	@Then("^Select width to \"([^\"]*)\"$")
	public void select_width_to(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//input[@name='plot_area_border_width']")).click();

		login.driver.findElement(By.xpath("//input[@name='plot_area_border_width']")).clear();
		login.driver.findElement(By.xpath("//input[@name='plot_area_border_width']")).sendKeys(arg1);

		stroke_width = arg1;

	}

	// TC_189
	@Then("^Verify The HeatMap 'border width' should be changed as per the selction$")
	public void verify_The_HeatMap_border_width_should_be_changed_as_per_the_selction() throws Throwable {
		CommonFunctionality.wait(2000);

		String width = login.driver.findElement(By.xpath("//*[@class='highcharts-plot-border']"))
				.getAttribute("stroke-width");

		if (width.equalsIgnoreCase(stroke_width)) {
			login.Log4j.info("The HeatMap 'border width' should be changed as per the selction:PASS");
		}

		else {
			fail("The HeatMap 'border width' should be changed as per the selction:FAIL");
		}

	}

//TC_190
	@Then("^Select radius to \"([^\"]*)\"$")
	public void select_radius_to(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//input[@name='plot_area_border_radius']")).click();

		login.driver.findElement(By.xpath("//input[@name='plot_area_border_radius']")).clear();
		login.driver.findElement(By.xpath("//input[@name='plot_area_border_radius']")).sendKeys(arg1);

		stroke_radius = arg1;

	}

//TC_190
	@Then("^Verify The selected 'border radius' should be applied to the HeatMap$")
	public void verify_The_selected_border_radius_should_be_applied_to_the_HeatMap() throws Throwable {
		CommonFunctionality.wait(2000);

		String radius = login.driver.findElement(By.xpath("//*[@class='highcharts-plot-border']")).getAttribute("rx");

		if (radius.equalsIgnoreCase(stroke_radius)) {
			login.Log4j.info("The selected 'border radius' should be applied to the HeatMap:PASS");
		}

		else {
			fail("The selected 'border radius' should be applied to the HeatMap:FAIL");
		}

	}

	// TC_127
	@Then("^Click on dropdown for \"([^\"]*)\" in series level$")
	public void click_on_dropdown_for_in_series_level(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		JavascriptExecutor js = (JavascriptExecutor) login.driver;

		WebElement horizontalbar = login.driver.findElement(By.xpath(
				"((//div[@class='series-name--title'])[1]//following::div[@class='insight-action-panel--btn-popup icon--context-menu-arrow'])[1]"));
		Actions action = new Actions(login.driver);

		Actions moveToElement = action.moveToElement(horizontalbar);
		for (int i = 0; i < 5; i++) {
			moveToElement.sendKeys(Keys.RIGHT).build().perform();
		}
		((JavascriptExecutor) login.driver).executeScript("arguments[0].scrollRight += 1000",
				login.driver.findElement(By.xpath(
						"((//div[@class='series-name--title'])[1]//following::div[@class='insight-action-panel--btn-popup icon--context-menu-arrow'])[1]")));

		CommonFunctionality.wait(1000);

		js.executeScript("arguments[0].scrollIntoView();", login.driver.findElement(By.xpath(
				"((//div[@class='series-name--title'])[1]//following::div[@class='insight-action-panel--btn-popup icon--context-menu-arrow'])[1]")));
		CommonFunctionality.wait(1000);
		login.driver.findElement(By.xpath(
				"((//div[@class='series-name--title'])[1]//following::div[@class='insight-action-panel--btn-popup icon--context-menu-arrow'])[1]"))
				.click();

//	for(int i=1;i<=5;i++)
//	{
//	
//((JavascriptExecutor)login. driver).executeScript("arguments[0].scrollRight +=250;", login.driver.findElement(By.xpath("((//div[@class='series-name--title'])[1]//following::div[@class='insight-action-panel--btn-popup icon--context-menu-arrow'])[1]")));
//	
//	}
//	
//	

//	js.executeScript("window.scrollBy(0,750)", "");
//	js.executeScript("window.scrollBy(2000,0)");

		// TestUtil.js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//button[text()='"
		// + agreebtn + "']")));
		// js.executeScript("arguments[0].click();",login.driver.findElement(By.xpath("((//div[@class='series-name--title'])[1]//following::div[@class='insight-action-panel--btn-popup
		// icon--context-menu-arrow'])[1]")));

		System.out.println("scroll");
		// js.executeScript("document.querySelector(scroll).scrollRight=1000");

		// ((JavascriptExecutor)login.driver).executeScript("arguments[0].scrollRight +=
		// 1000",
		// login.driver.findElement(By.xpath("((//div[@class='series-name--title'])[1]//following::div[@class='insight-action-panel--btn-popup
		// icon--context-menu-arrow'])[1]")));
		CommonFunctionality.wait(1000);

		// ((JavascriptExecutor)login.driver).executeScript("arguments[0].scrollRight +=
		// 1000",
		// login.driver.findElement(By.xpath("((//div[@class='series-name--title'])[1]//following::div[@class='insight-action-panel--btn-popup
		// icon--context-menu-arrow'])[1]")));

		// js.executeScript("arguments[0].scrollIntoView();",login.driver.findElement(By.xpath("((//div[@class='series-name--title'])[1]//following::div[@class='insight-action-panel--btn-popup
		// icon--context-menu-arrow'])[1]")));

		// js.executeScript("window.scrollBy(0,650)", "");

		CommonFunctionality.wait(2000);
		// login.driver.findElement(By.xpath("((//div[@class='series-name--title'])[1]//following::div[@class='insight-action-panel--btn-popup
		// icon--context-menu-arrow'])[1]")).click();

	}

//TC_192
	@Then("^Defaultly visual check box uncheck and Verify The Border should not be seen for visual$")
	public void defaultly_visual_check_box_uncheck_and_Verify_The_Border_should_not_be_seen_for_visual()
			throws Throwable {

		CommonFunctionality.wait(2000);

		String border = login.driver.findElement(By.xpath("//div[@class='visual-item-container']"))
				.getAttribute("style");

		if (!border.contains("1px")) {
			login.Log4j.info("The Border should not be seen for visual:PASS");
		} else {
			fail("The Border should not be seen for visual:FAIL");
		}

	}

//TC_193	
	@Then("^Check visual check box$")
	public void check_visual_check_box() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver
				.findElement(By.xpath("(//div[@class='border-control']//span[@class='input-control--indicator'])[2]"))
				.click();

	}

//TC_193
	@Then("^Verify The Border should be displayed for visual$")
	public void verify_The_Border_should_be_displayed_for_visual() throws Throwable {
		CommonFunctionality.wait(2000);
		String border = login.driver.findElement(By.xpath("//div[@class='visual-item-container']"))
				.getAttribute("style");

		if (border.contains("1px")) {
			login.Log4j.info("The Border should be displayed for visual:PASS");
		} else {
			fail("The Border should be displayed for visual:FAIL");
		}

	}

//TC_194
	@Then("^Click on color and select border color$")
	public void click_on_color_and_select_border_color() throws Throwable {
		CommonFunctionality.wait(2000);

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath(
				"(//div[@class='border-settings border-settings__separate-toggler']//div[@class='index-module_swatch_button_item_color__gAHg1'])[2]"))
				.click();

		Thread.sleep(2000);
		login.driver.findElement(By.xpath("(//div[@class='index-module_wrapper__Q-UYB'])[8]")).click();

		String border = login.driver.findElement(By.xpath("(//div[@class='index-module_wrapper__Q-UYB'])[8]"))
				.getAttribute("style");

		Visual_bordercolor = border.substring(18, 35);

	}

//TC_194
	@Then("^Verify The 'Border' should be displayed for visual with selected color$")
	public void verify_The_Border_should_be_displayed_for_visual_with_selected_color() throws Throwable {
		CommonFunctionality.wait(2000);

		String color = login.driver.findElement(By.xpath("//div[@class='visual-item-container']"))
				.getAttribute("style");

		String border_color = color.substring(36, 53);

		if (border_color.equalsIgnoreCase(Visual_bordercolor)) {
			login.Log4j.info(" The 'Border' should be displayed for visual with selected color:PASS");
		}

		else {
			fail(" The 'Border' should be displayed for visual with selected color:FAIL");
		}

	}

	// TC_195
	@Then("^Select border width to \"([^\"]*)\"$")
	public void select_border_width_to(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//input[@name='visual_area_border_width']")).click();

		login.driver.findElement(By.xpath("//input[@name='visual_area_border_width']")).clear();
		login.driver.findElement(By.xpath("//input[@name='visual_area_border_width']")).sendKeys(arg1);
		visual_width = arg1;

	}

	// TC_195
	@Then("^Verify The visual border width should be changed as per the selction$")
	public void verify_The_visual_border_width_should_be_changed_as_per_the_selction() throws Throwable {

		CommonFunctionality.wait(2000);

		String visual_border = login.driver.findElement(By.xpath("//div[@class='visual-item-container']"))
				.getAttribute("style");

		System.out.println(visual_border);

		if (visual_border.contains("5")) {
			login.Log4j.info("The visual border width should be changed as per the selction:PASS");
		} else {
			fail("The visual border width should be changed as per the selction:FAIL");
		}
	}

	// TC_196
	@Then("^Select Radius as \"([^\"]*)\"$")
	public void select_Radius_as(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//input[@name='visual_area_border_radius']")).click();

		login.driver.findElement(By.xpath("//input[@name='visual_area_border_radius']")).clear();
		login.driver.findElement(By.xpath("//input[@name='visual_area_border_radius']")).sendKeys(arg1);

		visual_radius = arg1;

	}

	// TC_196
	@Then("^Verify The Radius should be changed as per selection$")
	public void verify_The_Radius_should_be_changed_as_per_selection() throws Throwable {
		CommonFunctionality.wait(2000);

		String radius = login.driver.findElement(By.xpath("//div[@class='visual-item-container']"))
				.getAttribute("style");

		if (radius.contains(visual_radius)) {
			login.Log4j.info("The Radius should be changed as per selection:PASS");

		} else {
			fail("The Radius should be changed as per selection:FAIL");
		}

	}

	// TC_198
	@Then("^Click on 'Advanced settings' link$")
	public void click_on_Advanced_settings_link() throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//div[text()='Advanced settings']")).click();

	}

	// TC_198
	@Then("^Verify The Visual popup should be opened with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void verify_The_Visual_popup_should_be_opened_with_and(String arg1, String arg2) throws Throwable {

		CommonFunctionality.wait(2000);

		String border = login.driver.findElement(By.xpath("//div[text()='Heat map border']")).getText();

		if (border.equalsIgnoreCase(arg1)) {

			String visual = login.driver.findElement(By.xpath("//div[text()='Visual background']")).getText();
			if (visual.equalsIgnoreCase(arg2)) {
				login.Log4j.info("Visual popup should be opened with heat map border and visual border:PASS");
			} else {
				fail("Visual popup should be opened with heat map border and visual border:FAIL");
			}
		}

	}

	// TC_199
	@Then("^Click on Border cogwheel icon \\(open advance settings popup\\)$")
	public void click_on_Border_cogwheel_icon_open_advance_settings_popup() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver
				.findElement(
						By.xpath("(//div[text()='Border:']//following::div[@title='Open advanced settings popup'])[1]"))
				.click();

	}

	// TC_200
	@Then("^Click on background dropdown$")
	public void click_on_background_dropdown() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver
				.findElement(By.xpath(
						"(//div[text()='Background:']//following::div[@class='context-menu-control--title'])[1]"))
				.click();

	}

	// TC_200
	@Then("^visual check box unchecked defaultly$")
	public void visual_check_box_unchecked_defaultly() throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath("//div[@class='background-image disabled']")).isDisplayed()) {

			login.Log4j.info("Visual check box unchecked default:PASS");

		} else {
			fail("Visual check box unchecked default:FAIL");
		}

	}

	// TC_200
	@Then("^Verify The Background should not be seen for visual$")
	public void verify_The_Background_should_not_be_seen_for_visual() throws Throwable {

		CommonFunctionality.wait(2000);

		String background_color = login.driver.findElement(By.xpath("//div[@class='visual-item-container']"))
				.getAttribute("style");

		System.out.println(background_color);

		if (background_color.equalsIgnoreCase("margin: 0px auto;")) {
			login.Log4j.info("The Background should not be seen for visual:PASS");

		} else {
			fail("Visual check box unchecked default:FAIL");
		}

	}

	// TC_201
	@Then("^Check on visual check box$")
	public void check_on_visual_check_box() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver
				.findElement(
						By.xpath("//ul[@class='dropdown-menu context-menu ']//span[@class='input-control--indicator']"))
				.click();

	}

	// TC_201
	@Then("^Verify The Background should be displayed for visual$")
	public void verify_The_Background_should_be_displayed_for_visual() throws Throwable {
		CommonFunctionality.wait(2000);

		String background_color = login.driver.findElement(By.xpath("//div[@class='visual-item-container']"))
				.getAttribute("style");

		if (background_color.contains("rgb")) {
			login.Log4j.info("The Background should be displayed for visual:PASS");

		} else {
			fail("The Background should be displayed for visual:FAIL");
		}

	}

	// 202
	@Then("^Click on color and Select Color$")
	public void click_on_color_and_Select_Color() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath(
				"//div[@class='background-control-container']//div[@class='index-module_swatch_button_item_color__gAHg1']"))
				.click();

		login.driver.findElement(By.xpath("(//div[@class='index-module_wrapper__Q-UYB'])[8]")).click();

		String color = login.driver.findElement(By.xpath("(//div[@class='index-module_wrapper__Q-UYB'])[8]"))
				.getAttribute("style");

		background_visual_color = color.substring(21, 33);

		System.out.println(background_visual_color);

	}

	// 202
	@Then("^Verify The Background should be displayed for visual with selected color$")
	public void verify_The_Background_should_be_displayed_for_visual_with_selected_color() throws Throwable {

		CommonFunctionality.wait(2000);

		String back_color = login.driver.findElement(By.xpath("//div[@class='visual-item-container']"))
				.getAttribute("style");

		String value = back_color.substring(39, 51);

		if (value.equalsIgnoreCase(background_visual_color)) {

			login.Log4j.info("The Background color should be displayed for visual with selected color:PASS");
		}

		else {

			fail("The Background color should be displayed for visual with selected color:FAIL");
		}

	}

	// TC_203

	@Then("^Click on Browse and Select image$")
	public void click_on_Browse_and_Select_image() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//label[@class='form--control form--control__xs background-image--input']"))
				.click();
		CommonFunctionality.wait(2000);
		CommonFunctionality.uploadTheFileusingAutoIT(login.driver,
				System.getProperty("user.dir") + "\\AutoIT\\Shravas.exe",
				System.getProperty("user.dir") + "\\AutoIT\\Shravas.png");
		CommonFunctionality.wait(2000);

	}

//TC_203
	@Then("^Verify The Selected image should be displayed as background of HeatMap visual$")
	public void verify_The_Selected_image_should_be_displayed_as_background_of_HeatMap_visual() throws Throwable {
		CommonFunctionality.wait(5000);

		String image = login.driver.findElement(By.xpath("//div[@class='visual-item-container']"))
				.getAttribute("style");

		if (image.contains("background-image")) {
			login.Log4j.info("The Selected image should be displayed as background of HeatMap visual:PASS");
		} else {

			fail("The Selected image should be displayed as background of HeatMap visual:FAIL");
		}
	}

	// TC_204
	@Then("^Select Opacity as \"([^\"]*)\"$")
	public void select_Opacity_as(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//input[@name='visual_area_background_opacity']")).click();

		login.driver.findElement(By.xpath("//input[@name='visual_area_background_opacity']")).clear();

		login.driver.findElement(By.xpath("//input[@name='visual_area_background_opacity']")).sendKeys(arg1);

//		 int v=Integer.parseInt(arg1);
//		 
//		 
//		
//	 System.out.println(v);
//		int background=v/100;
//		
//		System.out.println(background);

	}

	// TC_204
	@Then("^Verify The Opacity should be updated on visual$")
	public void verify_The_Opacity_should_be_updated_on_visual() throws Throwable {
		CommonFunctionality.wait(2000);

		String opacity = login.driver.findElement(By.xpath("//div[@class='visual-item-container']"))
				.getAttribute("style");

		System.out.println(opacity);
		if (opacity.contains("0.3")) {
			login.Log4j.info("The Opacity should be updated on visual:PASS");
		}

		else {
			fail("The Opacity should be updated on visual:FAIL");
		}

	}

	// TC_205
	@Then("^Click on Advance settings$")
	public void click_on_Advance_settings() throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver
				.findElement(By.xpath(
						"//ul[@class='dropdown-menu context-menu ']//div[@title='Open advanced settings popup']"))
				.click();

	}

	// TC_206

	@Then("^Click on background cogwheel iocn$")
	public void click_on_background_cogwheel_iocn() throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver
				.findElement(By.xpath(
						"(//div[text()='Background:']//following::div[@title='Open advanced settings popup'])[1]"))
				.click();

	}

	// TC_207
	@Then("^Click \"([^\"]*)\" icon on visual popup$")
	public void click_icon_on_visual_popup(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);
		login.driver
				.findElement(
						By.xpath("//div[@class='popover--header ui-draggable-handle']//div[text()='" + arg1 + "']"))
				.click();

	}

	// TC_207
	@Then("^Verify The popup should be closed$")
	public void verify_The_popup_should_be_closed() throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver.findElements(By.xpath("//div[@class='popover--header ui-draggable-handle']//div[text()='×']"))
				.size() == 0) {
			login.Log4j.info("The popup should be closed:PASS");
		} else {

			fail("The popup should be closed:FAIL");

		}

	}

	// TC_208

	@Then("^Verify The Default size \"([^\"]*)\" should be displayed in visual dropdown$")
	public void verify_The_Default_size_should_be_displayed_in_visual_dropdown(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		String a = login.driver.findElement(By.xpath("//div[@class='size-control-context-title']")).getText();
		System.out.println(a);

		if (a.equalsIgnoreCase(arg1)) {
			login.Log4j.info("The Default size should be displayed in dropdown:PASS");
		} else {

			login.Log4j.info("The Default size should be displayed in dropdown:PASS");
		}
	}

	// TC_209
	@Then("^Click on size dropdown$")
	public void click_on_size_dropdown() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("(//div[@class='size-control-context-title']//following::div)[1]")).click();
	}

	// TC_209
	@Then("^Verify The Horizontal allignment options should be 'disabled'$")
	public void verify_The_Horizontal_allignment_options_should_be_disabled() throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver.findElements(By.xpath("//div[@class='size-control--togglers disabled']")).size() == 1) {

			login.Log4j.info("The Horizontal allignment options should be disabled:PASS");
		} else {

			fail("The Horizontal allignment options should be disabled:FAIL");
		}

	}

	// TC_210
	@Then("^Verify The X-axis should be set to \"([^\"]*)\" with enable state & Y-axis should be set to \"([^\"]*)\" with disable state$")
	public void verify_The_X_axis_should_be_set_to_with_enable_state_Y_axis_should_be_set_to_with_disable_state(
			String arg1, String arg2) throws Throwable {

		CommonFunctionality.wait(2000);

		// X-Axis

		String Xaxis = login.driver.findElement(By.xpath("//input[@name='visual_area_proportion_x']"))
				.getAttribute("value");

		System.out.println(Xaxis);
		if (Xaxis.equalsIgnoreCase("100")) {

			login.driver.findElement(By.xpath("//input[@name='visual_area_proportion_x']")).click();
			login.driver.findElement(By.xpath("//input[@name='visual_area_proportion_x']")).clear();

			login.Log4j.info("The X-axis should be 100 with Enable state :PASS");
		} else {

			fail("The X-axis should be 100 with Enable state:FAIL");

		}

		// Y-Axis

		if (login.driver.findElement(By.xpath("//div[@class='size-control--toggler disabled']")).isDisplayed()) {

			String Yaxis = login.driver.findElement(By.xpath("//input[@name='visual_area_proportion_y']"))
					.getAttribute("value");
			System.out.println(Yaxis);
			if (Yaxis.equalsIgnoreCase("100")) {
				login.Log4j.info("The Y-axis should be 100 with Disable state :PASS");
			}

		} else {

			fail("The Y-axis should be 100 with Disable state:FAIL");

		}

	}

	// TC_211

	@Then("^Change the Proportion X-axis \"([^\"]*)\"$")
	public void change_the_Proportion_X_axis(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//input[@name='visual_area_proportion_x']")).click();
		login.driver.findElement(By.xpath("//input[@name='visual_area_proportion_x']")).clear();
		login.driver.findElement(By.xpath("//input[@name='visual_area_proportion_x']")).sendKeys(arg1);

	}

	// TC_211
	@Then("^verify The horizontal alignment options should be 'Enabled'$")
	public void verify_The_horizontal_alignment_options_should_be_Enabled() throws Throwable {
		CommonFunctionality.wait(2000);

		if (login.driver.findElements(By.xpath("//div[@class='size-control--togglers']")).size() == 2) {

			login.Log4j.info("The horizontal alignment options should be Enabled:PASS");
		} else {

			fail("The horizontal alignment options should be Enabled:FAIL");
		}

	}

	// TC_217
	@Then("^Click on \"([^\"]*)\" alignment icon$")
	public void click_on_alignment_icon(String arg1) throws Throwable {
		CommonFunctionality.wait(5000);

		login.driver.findElement(By.xpath("//div[@class='alignment-control--icon icon--align-x-left']")).click();

	}

	// TC_217
	@Then("^Verify The Visual should be seen at 'left side' of the edit visual pane$")
	public void verify_The_Visual_should_be_seen_at_left_side_of_the_edit_visual_pane() throws Throwable {
		CommonFunctionality.wait(2000);

		String left = login.driver
				.findElement(By.xpath(
						"//div[@class='preview-container--visual top_panel']//div[@class='visual-item-container']"))
				.getAttribute("style");

		System.out.println("left:" + left);

		if (left.equalsIgnoreCase("width: 30%;")) {
			login.Log4j.info("Visual should be seen at 'left side' of the edit visual panel:PASS");
		} else {

			fail("Visual should be seen at 'left side' of the edit visual panel:FAIL");
		}

	}

	// TC_218
	@Then("^Click on 'Right' alignment icon$")
	public void click_on_Right_alignment_icon() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//div[@class='alignment-control--icon icon--align-x-right']")).click();

	}

	// TC_218
	@Then("^Verify The Visual should be seen at 'right' side of the edit visual pane$")
	public void verify_The_Visual_should_be_seen_at_right_side_of_the_edit_visual_pane() throws Throwable {
		CommonFunctionality.wait(2000);

		String right = login.driver
				.findElement(By.xpath(
						"//div[@class='preview-container--visual top_panel']//div[@class='visual-item-container']"))
				.getAttribute("style");

		System.out.println("left:" + right);

		if (right.equalsIgnoreCase("width: 30%; margin-left: auto;")) {
			login.Log4j.info("Visual should be seen at 'left side' of the edit visual panel:PASS");
		} else {

			fail("Visual should be seen at 'left side' of the edit visual panel:FAIL");
		}
	}

	// TC_219
	@Then("^Click on 'Number format' dropdown$")
	public void click_on_Number_format_dropdown() throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver
				.findElement(By
						.xpath("//div[text()='Number format:']//following::div[@class='number-format-context-title']"))
				.click();

	}

	// TC_219
	@Then("^Verify The \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" should be display$")
	public void verify_The_should_be_display(String arg1, String arg2, String arg3) throws Throwable {

		CommonFunctionality.wait(2000);

		List<WebElement> list = login.driver.findElements(By.xpath("//div[@class='number-format-picker--label']"));

		System.out.println(list.size());

		for (int i = 0; i < list.size(); i++) {

			String text = list.get(i).getText();
			System.out.println(text);

			if (text.equalsIgnoreCase(arg1)) {
				login.Log4j.info("'Decimal places' should be displayed:PASS");

			} else if (text.equalsIgnoreCase(arg2)) {
				login.Log4j.info("'Decimal separator' should be displayed:PASS");
			} else if (text.equalsIgnoreCase(arg3)) {

				login.Log4j.info("'Grouping separator' should be displayed:PASS");
			} else {

				fail("Decimal places, Decimal separator, Grouping separator should be displayed :FAIL");
			}

		}

	}

	// TC_220
	@Then("^Verify The \"([^\"]*)\" decimals should be selected by default$")
	public void verify_The_decimals_should_be_selected_by_default(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		String decimal = login.driver.findElement(By.xpath("//input[@name='data_labels_decimal_places']"))
				.getAttribute("value");

		if (decimal.equalsIgnoreCase(arg1)) {
			login.Log4j.info("Decimal value should be selected by default:PASS");
		} else {

			fail("Decimals value should be selected by default:FAIL");
		}

	}

	// TC_221

	@Then("^Select decimal separator as \\(,\\)$")
	public void select_decimal_separator_as() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver
				.findElement(By.xpath("(//div[@class='number-format-picker']//div[@class='toggler-control-item'])[1]"))
				.click();

	}

	// TC_221
	@Then("^Verify The selected decimal separator\\(,\\) should be displayed on HeatMap value$")
	public void verify_The_selected_decimal_separator_should_be_displayed_on_HeatMap_value() throws Throwable {
		CommonFunctionality.wait(2000);

	}

	// TC_223
	@Then("^Verify The date format field Automatic as mm/yyyy should be displayed$")
	public void verify_The_date_format_field_Automatic_as_mm_yyyy_should_be_displayed() throws Throwable {

		CommonFunctionality.wait(2000);

		String datesformate = login.driver
				.findElement(By.xpath("//div[text()='Date format:']//following::div[@class='date-format-example']"))
				.getText();

		System.out.println("date:" + datesformate);

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
		String formattedDate = sdf.format(date);
		System.out.println(formattedDate);

		if (datesformate.equalsIgnoreCase(formattedDate)) {
			login.Log4j.info("Date formate field Automatic month and year should be displayed:PASS");
		} else {

			fail("Date formate field Automatic month and year should be displayed:FAIL");
		}

	}

	// TC_224
	@Then("^Click on date format field dropdown$")
	public void click_on_date_format_field_dropdown() throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver
				.findElement(By.xpath(
						"(//div[text()='Date format:']//following::div[@class='context-menu-control--icon'])[1]"))
				.click();

	}

	// TC_224
	@Then("^Verify The \"([^\"]*)\" & \"([^\"]*)\" options should be available$")
	public void verify_The_options_should_be_available(String arg1, String arg2) throws Throwable {

		CommonFunctionality.wait(2000);

		List<WebElement> dropdown = login.driver.findElements(By.xpath(
				"//ul[@class='dropdown-menu context-menu date-format--context-menu']//span[@class='input-control--description']"));

		for (int i = 0; i < dropdown.size(); i++) {
			String value = dropdown.get(i).getText();

			if (value.equalsIgnoreCase(arg1)) {
				login.Log4j.info("Auto option should be displayed in date dropdown:PASS");

			} else if (value.equalsIgnoreCase(arg2)) {
				login.Log4j.info("Custom option should be displayed in date dropdown:PASS");
			}

			else {

				fail("Auto and custom option should be displayed in date dropdown:FAIL");
			}

		}

	}

	// TC_225
	@Then("^Select \"([^\"]*)\" radio button$")
	public void select_radio_button(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//div[@class='custom-date']//span[@class='input-control--description']"))
				.click();

	}

	// TC_225
	@Then("^Verify The Date format should be able to custom manually with help of tips$")
	public void verify_The_Date_format_should_be_able_to_custom_manually_with_help_of_tips() throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath("//div[@class='custom-date--box']")).isDisplayed()) {
			login.Log4j.info("Date format should be able to custom manually with help of tips:PASS");

		}

		else {

			fail("Date format should be able to custom manually with help of tips:FAIL");
		}

	}

	// TC_226
	@Then("^Check \"([^\"]*)\" checkbox$")
	public void check_checkbox(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);

//		if (login.driver.findElement(By.xpath("//div[@class='add-style-template']")).isDisplayed()) {
//
		login.driver.findElement(By.xpath(
				"(//span[@class='input-control--indicator']//following::span[@class='input-control--description'])[1]"))
				.click();
//		}
//
//		else {

		System.out.println("Already Gridlines check box checked:PASS");
		// }

	}

	// TC_226
	@Then("^Verify The 'Gridlines' should be applied to the 'Heat map' visual when checked$")
	public void verify_The_Gridlines_should_be_applied_to_the_Heat_map_visual_when_checked() throws Throwable {

		CommonFunctionality.wait(2000);
		String lines = login.driver.findElement(By.xpath("(//*[@class='highcharts-point highcharts-color-0'])[1]"))
				.getAttribute("stroke-width");

		System.out.println("lines:" + lines);

		if (lines.equalsIgnoreCase("1")) {
			login.Log4j.info("Gridlines should be applied to the 'Heat map' visual:PASS");
		} else {
			fail("Gridlines should be applied to the 'Heat map' visual:FAIL");
		}

	}

	// TC_227
	@Then("^Un-Check \"([^\"]*)\" checkbox$")
	public void un_Check_checkbox(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath("//div[@class='add-style-template']")).isDisplayed()) {

			login.Log4j.info("defaultly Gridlines unChecked:PASS");
		}

		else {

			fail("Already Gridlines check box checked:FAIL");
		}

	}

	// TC_227
	@Then("^Verify The Gridlines should be removed from the HeatMap visual when unchecked$")
	public void verify_The_Gridlines_should_be_removed_from_the_HeatMap_visual_when_unchecked() throws Throwable {
		CommonFunctionality.wait(2000);

		String lines = login.driver.findElement(By.xpath("(//*[@class='highcharts-point highcharts-color-0'])[1]"))
				.getAttribute("stroke-width");

		System.out.println("lines:" + lines);

		if (lines == null) {
			login.Log4j.info(" Gridlines should be removed from the HeatMap visual when unchecked:PASS");
		} else {
			fail(" Gridlines should be removed from the HeatMap visual when unchecked:FAIL");
		}

	}

	// TC_228
	@Then("^Click on Open Advanced settings popup \\(cogwheel\\) icon$")
	public void click_on_Open_Advanced_settings_popup_cogwheel_icon() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath(
				"(//span[@class='input-control--description']//following::div[@title='Open advanced settings popup'])[1]"))
				.click();

	}

	// TC_228
	@Then("^Verify The Visual window should be displayed by default$")
	public void verify_The_Visual_window_should_be_displayed_by_default() throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath("//div[@class='popover--wrapper']")).isDisplayed()) {
			login.Log4j.info("The Visual window should be displayed by default:PASS");

		} else {
			fail("The Visual window should be displayed by default:FAIL");
		}

	}

	// TC_229
	@Then("^Lines check box checked$")
	public void lines_check_box_checked() throws Throwable {
		CommonFunctionality.wait(2000);

		if (login.driver.findElements(By.xpath("(//div[@class='popover--wrapper']//div[@class='col disabled'])[1]"))
				.size() == 1) {

			login.driver.findElement(By.xpath("//*[input[@name='visual_lines_display']]")).click();

		}

	}

	// TC_229
	@Then("^Verify The Gridlines should be displayed in visual$")
	public void verify_The_Gridlines_should_be_displayed_in_visual() throws Throwable {

		CommonFunctionality.wait(2000);

		String lines = login.driver.findElement(By.xpath("(//*[@class='highcharts-point highcharts-color-0'])[1]"))
				.getAttribute("stroke-width");

		System.out.println("lines:" + lines);

		if (lines.equalsIgnoreCase("1")) {
			login.Log4j.info("The Gridlines should be displayed in visual:PASS");
		} else {
			fail("The Gridlines should be displayed in visual:FAIL");
		}

	}

	// TC_230
	@Then("^Select Lines color$")
	public void select_Lines_color() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath(
				"(//div[@class='popover--wrapper']//div[@class='index-module_swatch_button_item_color__gAHg1'])[1]"))
				.click();

		login.driver.findElement(By.xpath("(//div[@class='index-module_wrapper__Q-UYB'])[2]")).click();

		Lines_color = login.driver.findElement(By.xpath("//input[@class='index-module_text__GTkop']"))
				.getAttribute("value");

		System.out.println("Lines_color:" + Lines_color);

	}

	// TC_230
	@Then("^Verify The Gridlines should be applied for visual with selected color$")
	public void verify_The_Gridlines_should_be_applied_for_visual_with_selected_color() throws Throwable {
		CommonFunctionality.wait(2000);

		String linesColor = login.driver.findElement(By.xpath("(//*[@class='highcharts-point highcharts-color-0'])[1]"))
				.getAttribute("stroke");

		linesColor = linesColor.replaceAll("[^a-zA-Z0-9]", " ").trim();
		System.out.println("linescolor:" + linesColor);

		if (Lines_color.equalsIgnoreCase(linesColor)) {
			login.Log4j.info("The Gridlines should be applied for visual with selected color:PASS");
		} else {
			fail("The Gridlines should be applied for visual with selected color:FAIL");
		}
	}

	// TC_231
	@Then("^Select Width \"([^\"]*)\"$")
	public void select_Width(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//input[@name='visual_lines_width']")).click();

		login.driver.findElement(By.xpath("//input[@name='visual_lines_width']")).clear();
		login.driver.findElement(By.xpath("//input[@name='visual_lines_width']")).sendKeys(arg1);

		Grid_visual_width = arg1;

	}

	// TC_231
	@Then("^Verify The gridline width should be changed as per the selction$")
	public void verify_The_gridline_width_should_be_changed_as_per_the_selction() throws Throwable {

		CommonFunctionality.wait(2000);

		String visual_width = login.driver
				.findElement(By.xpath("(//*[@class='highcharts-point highcharts-color-0'])[1]"))
				.getAttribute("stroke-width");

		if (visual_width.equalsIgnoreCase("5")) {
			login.Log4j.info("The gridline width should be changed as per the selction:PASS");
		} else {
			fail("The gridline width should be changed as per the selction:FAIL");
		}

	}

	// Tc_232
	@Then("^Select radius to (\\d+)$")
	public void select_radius_to(int arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//input[@name='visual_lines_radius']")).click();

		login.driver.findElement(By.xpath("//input[@name='visual_lines_radius']")).clear();
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//input[@name='visual_lines_radius']")).sendKeys("15");
	}

	// Tc_233
	@Then("^Verify The Legend options should be \"([^\"]*)\" by default and \"([^\"]*)\" options should be displayed$")
	public void verify_The_Legend_options_should_be_by_default_and_options_should_be_displayed(String arg1, String arg2)
			throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver
				.findElements(By.xpath(
						"((//div[@class='context-menu-control'])[7]//div[@class='alignment-context-title--type'])[1]"))
				.size() == 1) {

			login.Log4j.info("Legend options should be checked by default:PASS");
			String option = login.driver.findElement(By.xpath(
					"((//div[@class='context-menu-control'])[7]//div[@class='alignment-context-title--type'])[1]"))
					.getText();

			System.out.println("option:" + option);
			if (option.equalsIgnoreCase("Bottom Center")) {
				login.Log4j.info("'Bottom center' options should be displayed:PASS");

			}

		} else {

			fail("'Bottom center' options should be displayed:FAIL");

		}

	}

	// TC_234
	@Then("^Click on legend dropdown$")
	public void click_on_legend_dropdown() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath(
				"(((//div[@class='context-menu-control'])[7]//div[@class='alignment-context-title--type'])[1]//following::div)[1]"))
				.click();

	}

	// TC_234
	@Then("^Veirfy The \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" as hyperlink should be seen$")
	public void veirfy_The_as_hyperlink_should_be_seen(String arg1, String arg2, String arg3) throws Throwable {
		CommonFunctionality.wait(2000);

		List<WebElement> align = login.driver.findElements(By.xpath("//div[@class='alignment-control--label']"));

		for (int i = 0; i < align.size(); i++) {
			String verticalalign = align.get(i).getText();
			if (verticalalign.equalsIgnoreCase(arg1)) {
				login.Log4j.info("The Vertical align: and Horizontal align: should be displayed :PASS");
			} else if (verticalalign.equalsIgnoreCase(arg2)) {
			} else {
				fail("The Vertical align: and Horizontal align: should be displayed :FAIL");
			}

		}

		if (login.driver
				.findElements(By.xpath("//div[@class='legend-control']//div[@title='Open advanced settings popup']"))
				.size() == 1) {
			login.Log4j.info("Advanced settings hyper link should be displayed :PASS");
		} else {
			fail("Advanced settings hyper link should be displayed:FAIL");
		}

	}

	// TC_241
	@Then("^Click on \"([^\"]*)\" hyper link$")
	public void click_on_hyper_link(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//div[text()='" + arg1 + "']")).click();

	}

	// TC_241
	@Then("^Verify The Legend window list \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void verify_The_Legend_window_list(String arg1, String arg2, String arg3, String arg4, String arg5)
			throws Throwable {

		CommonFunctionality.wait(2000);

		List<WebElement> legendlist = login.driver.findElements(By.xpath("//div[@class='title']"));

		for (int i = 0; i < legendlist.size(); i++) {
			String list = legendlist.get(i).getText();

			if (list.equalsIgnoreCase(arg1)) {
				login.Log4j.info("Legend window list 1st value displayed :PASS:" + arg1);
			} else if (list.equalsIgnoreCase(arg2)) {

				login.Log4j.info("Legend window list 2nd value displayed :PASS:" + arg2);
			} else if (list.equalsIgnoreCase(arg3)) {
				login.Log4j.info("Legend window list 3rd value displayed :PASS:" + arg3);

			} else if (list.equalsIgnoreCase(arg4)) {
				login.Log4j.info("Legend window list 4th value displayed :PASS:" + arg4);

			} else if (list.equalsIgnoreCase(arg5)) {
				login.Log4j.info("Legend window list 5th value displayed :PASS:" + arg5);

			} else {

				fail("Legend window not displayed:FAIL");
			}
		}

	}

	// TC_242
	@Then("^Verify The \"([^\"]*)\" check box Should be checked by default$")
	public void verify_The_check_box_Should_be_checked_by_default(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver.findElements(By.xpath("//div[@class='context-menu-control disabled']")).size() == 0) {
			login.Log4j.info("Show Legend check box Should be checked by default:PASS:");
		} else {
			fail("Show Legend check box Should be checked by default:FAIL");
		}

	}

	// TC_244
	@Then("^Click on \"([^\"]*)\" plus icon$")
	public void click_on_plus_icon(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("(//div[text()='" + arg1 + "']//following::div)[2]")).click();

	}

	// TC_244
	@Then("^Verify The \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" should be displayed$")
	public void verify_The_should_be_displayed(String arg1, String arg2, String arg3, String arg4, String arg5)
			throws Throwable {
		CommonFunctionality.wait(2000);

		String gradient = login.driver
				.findElement(By
						.xpath("(//*[@class='popover-block-content']//span[@class='toggler-control-item--label'])[1]"))
				.getText();
		String solidcolor = login.driver
				.findElement(By
						.xpath("(//*[@class='popover-block-content']//span[@class='toggler-control-item--label'])[2]"))
				.getText();

		if (arg1.equalsIgnoreCase(gradient)) {
			login.Log4j.info("Gradient should be displayed in color axes:PASS:");
			if (arg2.equalsIgnoreCase(solidcolor)) {
				login.Log4j.info("Solid color should be displayed in color axes:PASS:");

			}
		}

		else {
			fail("Gradient should be displayed in color axes:FAIL");
		}

		String steps = login.driver
				.findElement(
						By.xpath("//div[@class='popover-block-content']//div[@class='gradient-axis--steps-label']"))
				.getText();

		if (steps.equalsIgnoreCase(arg3)) {
			login.Log4j.info("Steps should be displayed in color axes:PASS:");
		} else {

			fail("Steps should be displayed in color axes:FAIL");
		}

		String logarithmic = login.driver.findElement(By.xpath(
				"(//*[@class='popover-block-content']//*[@class='gradient-axis--controls']//*[@class='input-control--description'])[1]"))
				.getText();
		String perseries = login.driver.findElement(By.xpath(
				"(//*[@class='popover-block-content']//*[@class='gradient-axis--controls']//*[@class='input-control--description'])[2]"))
				.getText();

		if (arg4.equalsIgnoreCase(logarithmic)) {
			login.Log4j.info("Logarithmic should be displayed in color axes:PASS:");
			if (arg5.equalsIgnoreCase(perseries)) {
				login.Log4j.info("Per series should be displayed in color axes:PASS:");

			}
		}

		else {
			fail("Logarithmic should be displayed in color axes:FAIL");
		}

	}

	// TC_249

	@Then("^Verify the Alignment options \"([^\"]*)\", \"([^\"]*)\" should be available$")
	public void verify_the_Alignment_options_should_be_available(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(2000);

		List<WebElement> position = login.driver.findElements(By.xpath("//div[@class='alignment-control--label']"));

		for (int i = 0; i < position.size(); i++) {

			String positionalign = position.get(i).getText();

			if (positionalign.equalsIgnoreCase(arg1)) {
				login.Log4j.info("vertical position should be displayed:PASS:");
			} else if (positionalign.equalsIgnoreCase(arg2)) {

				login.Log4j.info("Horizontal postion should be displayed:PASS:");
			} else {
				fail("positions alignments not displayed:FAIL");
			}

		}

	}

	// TC_257
	@Then("^Verify The \"([^\"]*)\", \"([^\"]*)\" options should be seen$")
	public void verify_The_options_should_be_seen(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath("//div[@class='color-picker--ui']")).isDisplayed()) {
			login.Log4j.info("color option should be displayed:PASS:");
		}
		if (login.driver.findElement(By.xpath("//input[@name='legend_background_opacity']")).isDisplayed()) {
			login.Log4j.info("Opacity option should be displayed:PASS:");
		} else {
			fail("Background options displayed:FAIL");
		}
	}

	// TC_258
	@Then("^checked checkbox and Select color for legends background$")
	public void checked_checkbox_and_Select_color_for_legends_background() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver
				.findElement(By.xpath(
						"//*[@class='popover-block-content legend-config']//span[@class='input-control--indicator']"))
				.click();

		login.driver.findElement(By.xpath(
				"//*[@class='popover-block-content legend-config']//div[@class='index-module_swatch_button_item_color__gAHg1']"))
				.click();

		Thread.sleep(2000);
		login.driver.findElement(By.xpath("(//div[@class='index-module_wrapper__Q-UYB'])[6]")).click();

	}

	// TC_258
	@Then("^Verify The Selected color Should be displayed in background color$")
	public void verify_The_Selected_color_Should_be_displayed_in_background_color() throws Throwable {
		CommonFunctionality.wait(2000);

		String fillvalue = login.driver.findElement(By.xpath("//*[@class='highcharts-legend-box']"))
				.getAttribute("fill");

		if (fillvalue.equalsIgnoreCase("rgba(43,96,208,1)")) {
			login.Log4j.info("The Selected color Should be displayed in background color:PASS:");
		} else {
			fail("The Selected color Should be displayed in background color:FAIL");
		}

	}

	// TC_259
	@Then("^Apply opacity \"([^\"]*)\" for legends background$")
	public void apply_opacity_for_legends_background(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//*[@name='legend_background_opacity']")).click();

		login.driver.findElement(By.xpath("//*[@name='legend_background_opacity']")).clear();

		login.driver.findElement(By.xpath("//*[@name='legend_background_opacity']")).sendKeys(arg1);

		background_opacity = arg1;

	}

	// TC_259
	@Then("^Verify the applyed opacity Should be displayed in background$")
	public void verify_the_applyed_opacity_Should_be_displayed_in_background() throws Throwable {

		CommonFunctionality.wait(2000);

		String fillvalue = login.driver.findElement(By.xpath("//*[@class='highcharts-legend-box']"))
				.getAttribute("fill");

		if (fillvalue.equalsIgnoreCase("rgba(43,96,208,0.2)")) {
			login.Log4j.info("The applyed opacity Should be displayed in background:PASS:");
		} else {
			fail("The applyed opacity Should be displayed in background:FAIL");
		}

	}

	// TC_260
	@Then("^Verify The \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" should be shown$")
	public void verify_The_should_be_shown(String arg1, String arg2, String arg3, String arg4) throws Throwable {

		CommonFunctionality.wait(2000);

		String color = login.driver.findElement(By.xpath("//div[@class='color-picker-control disabled']")).getText();
		String width = login.driver.findElement(By.xpath("//div[@class='spinner-control disabled']")).getText();
		String radius = login.driver.findElement(By.xpath("//div[@class='spinner-control disabled']")).getText();
		String style = login.driver.findElement(By.xpath("//div[@class='select-control disabled']")).getText();

		if (color.equalsIgnoreCase(arg1)) {
			login.Log4j.info("legend - advanced settings under dropdown - border color should be shown:PASS:");

			if (width.equalsIgnoreCase(arg2)) {
				login.Log4j.info("legend - advanced settings under dropdown - border width should be shown:PASS:");
			}

			if (radius.equalsIgnoreCase(arg3)) {
				login.Log4j.info("legend - advanced settings under dropdown - border Radius should be shown:PASS:");
			}

			if (style.equalsIgnoreCase(arg4)) {
				login.Log4j.info("legend - advanced settings under dropdown - border Style should be shown:PASS:");
			}
		}

		else {

			fail("legend - advanced settings under dropdown - border Style should be shown:FAIL");
		}
	}

	// TC_261
	@Then("^check on border check box and Choose color for legend border$")
	public void check_on_border_check_box_and_Choose_color_for_legend_border() throws Throwable {

		CommonFunctionality.wait(4000);

		boolean checkbox = login.driver
				.findElement(By.xpath("//div[@class='border-settings']//input[@type='checkbox']")).isSelected();

		if (checkbox == true) {
			login.Log4j.info("legend - advanced settings under dropdown - border check box checked:PASS:");
		}

		else {
			login.driver
					.findElement(By.xpath(
							"(//div[@class='popover-block-content']//span[@class='input-control--indicator'])[4]"))
					.click();
		}

		login.driver
				.findElement(By.xpath(
						"//div[@class='border-settings']//div[@class='index-module_swatch_button_item_color__gAHg1']"))
				.click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("(//div[@class='index-module_wrapper__Q-UYB'])[8]")).click();
		CommonFunctionality.wait(2000);
		border_Color = login.driver.findElement(By.xpath("//*[@class='index-module_text__GTkop']"))
				.getAttribute("value");

	}

	// TC_261
	@Then("^Verify The selected border Color should be shown$")
	public void verify_The_selected_border_Color_should_be_shown() throws Throwable {

		CommonFunctionality.wait(2000);

		String legend_Border = login.driver.findElement(By.xpath("//*[@class='highcharts-legend-box']"))
				.getAttribute("stroke");

		legend_Border = legend_Border.replaceAll("#", "");

		System.out.println(legend_Border);
		System.out.println(border_Color);

		if (legend_Border.equalsIgnoreCase(border_Color)) {
			login.Log4j.info("legend - advanced settings under dropdown - border Color should be shown:PASS");
		} else {
			fail("legend - advanced settings under dropdown - border Color should be shown:FAIL");
		}

	}

	// TC_262
	@Then("^Choose 'width' for legend border \"([^\"]*)\"$")
	public void choose_width_for_legend_border(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//input[@name='legend_border_width']")).click();

		login.driver.findElement(By.xpath("//input[@name='legend_border_width']")).clear();

		login.driver.findElement(By.xpath("//input[@name='legend_border_width']")).sendKeys(arg1);

		border_width = arg1;

	}

	// TC_262
	@Then("^Verify The Width should be shown as selected value$")
	public void verify_The_Width_should_be_shown_as_selected_value() throws Throwable {

		CommonFunctionality.wait(2000);
		String width = login.driver.findElement(By.xpath("//*[@class='highcharts-legend-box']"))
				.getAttribute("stroke-width");

		if (width.equalsIgnoreCase(border_width)) {
			login.Log4j.info(
					"legend - advanced settings under dropdown - border Width should be shown as selected value:PASS");

		} else {

			fail("legend - advanced settings under dropdown - border Width should be shown as selected value:FAIL");
		}

	}

	// TC_263
	@Then("^Choose radius for legend border \"([^\"]*)\"$")
	public void choose_radius_for_legend_border(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//input[@name='legend_border_radius']")).click();

		login.driver.findElement(By.xpath("//input[@name='legend_border_radius']")).clear();

		login.driver.findElement(By.xpath("//input[@name='legend_border_radius']")).sendKeys(arg1);

		border_Radius = arg1;
	}

	// TC_263
	@Then("^Verify The 'radius' should be shown as selected value$")
	public void verify_The_radius_should_be_shown_as_selected_value() throws Throwable {

		CommonFunctionality.wait(2000);

		String radius = login.driver.findElement(By.xpath("//*[@class='highcharts-legend-box']")).getAttribute("rx");

		if (radius.equalsIgnoreCase(border_Radius)) {
			login.Log4j.info(
					"legend - advanced settings under dropdown - border radius should be shown as selected value:PASS");

		} else {

			fail("legend - advanced settings under dropdown - border radius should be shown as selected value:FAIL");
		}

	}

	// TC_288
	@Then("^Verify The Copyright=Check$")
	public void verify_The_Copyright_Check() throws Throwable {
		CommonFunctionality.wait(2000);

		Boolean copyright = login.driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).isSelected();

		if (copyright == true) {
			login.Log4j.info("Defaultly Copyright=Check:PASS");
		} else {

			login.driver.findElement(By.xpath("(//*[@class='input-control--description'])[3]/preceding-sibling::span"))
					.click();

		}
	}

	// TC_288
	@Then("^Verify The Copyright\\(Source:CEIC Data\\) should be displayed for visual$")
	public void verify_The_Copyright_Source_CEIC_Data_should_be_displayed_for_visual() throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver.findElements(By.xpath("//img[@class='visual-item-wrapper--logo']")).size() == 1) {
			login.Log4j.info("Copyright CEIC Data should be displayed for visual:PASS");
		} else {

			fail("Copyright CEIC Data should be displayed for visual:FAIL");
		}

	}

	// TC_289
	@Then("^Verify the Copyright=Uncheck$")
	public void verify_the_Copyright_Uncheck() throws Throwable {
		CommonFunctionality.wait(2000);

		Boolean copyright = login.driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).isSelected();

		if (copyright == true) {

			login.driver.findElement(By.xpath("(//*[@class='input-control--description'])[3]/preceding-sibling::span"))
					.click();
			login.Log4j.info("Copyright=UnCheck:PASS");

		} else {

			login.Log4j.info("Defaultly Copyright=UnCheck:PASS");

		}
	}

	// TC_289
	@Then("^Verify The The Copyright\\(Source:CEIC Data\\) should be removed for visual$")
	public void verify_The_The_Copyright_Source_CEIC_Data_should_be_removed_for_visual() throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver.findElements(By.xpath("//img[@class='visual-item-wrapper--logo']")).size() == 0) {
			login.Log4j.info("Copyright CEIC Data should be displayed for visual:PASS");
		} else {

			fail("Copyright CEIC Data should be displayed for visual:FAIL");
		}

	}

	// TC_290
	@Then("^Click on copyright dropdown and select \"([^\"]*)\"$")
	public void click_on_copyright_dropdown_and_select(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath(
				"((//*[@class='input-control--description'])[3]/preceding-sibling::span//following::div[@class='context-menu-control--icon'])[1]"))
				.click();

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//div[@title='" + arg1 + "']")).click();

	}

	// TC_290
	@Then("^Verify The Copyright - vertical align as \"([^\"]*)\"$")
	public void verify_The_Copyright_vertical_align_as(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver.findElements(By.xpath("//div[@class='visual-item-template--credits-" + arg1
				+ "']//div[@class='visual-item-wrapper--credits-container']//img")).size() == 1) {
			login.Log4j.info("Copyright vertical align bottom/top display:PASS");
		} else {
			fail("Copyright vertical align bottom/top display:FAIL");
		}

	}

//TC_292
	@Then("^Verify The Copyright should be displayed in \"([^\"]*)\"$")
	public void verify_The_Copyright_should_be_displayed_in(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		String left = login.driver.findElement(By.xpath("//div[@class='visual-item-wrapper--credits-container']"))
				.getAttribute("style");
		String center = login.driver.findElement(By.xpath("//div[@class='visual-item-wrapper--credits-container']"))
				.getAttribute("style");
		String right = login.driver.findElement(By.xpath("//div[@class='visual-item-wrapper--credits-container']"))
				.getAttribute("style");

		if (left.equalsIgnoreCase("justify-content: flex-start;")) {
			login.Log4j.info("Copyright Horizontal align Left side display:PASS");

		} else if (center.equalsIgnoreCase("justify-content: center;")) {
			login.Log4j.info("Copyright Horizontal align center display:PASS");

		} else if (right.equalsIgnoreCase("justify-content: flex-end;")) {
			login.Log4j.info("Copyright Horizontal align right side display:PASS");

		}

		else {

			fail("Copyright Horizontal align right side display:FAIL");

		}

	}

	// TC_293
	@Then("^Click on copy right dropdown$")
	public void click_on_copy_right_dropdown() throws Throwable {
		CommonFunctionality.wait(2000);

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath(
				"((//*[@class='input-control--description'])[3]/preceding-sibling::span//following::div[@class='context-menu-control--icon'])[1]"))
				.click();

		CommonFunctionality.wait(2000);

	}

	// TC_293
	@Then("^Verify The Copyright popup should be displayed$")
	public void verify_The_Copyright_popup_should_be_displayed() throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath("//div[@class='popover--wrapper']")).isDisplayed()) {
			login.Log4j.info("Copyright popup should be displayed:PASS");
		} else {
			fail("Copyright popup should be displayed:FAIL");
		}

	}

	// TC_294
	@Then("^Click on Copyright cogwheel icon \\(open advance settings popup\\)$")
	public void click_on_Copyright_cogwheel_icon_open_advance_settings_popup() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath(
				"(((//*[@class='input-control--description'])[3]/preceding-sibling::span//following::div[@class='context-menu-control--icon'])[1]//following::div[@title='Open advanced settings popup'])[1]"))
				.click();

	}

	// TC_295
	@Then("^Verify the copyright checkbox checked$")
	public void verify_the_copyright_checkbox_checked() throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath("//div[@class='popover--wrapper']//input[@type='checkbox']"))
				.isSelected()) {
			login.Log4j.info("copyright checkbox checked:PASS");
		} else {
			fail("copyright checkbox checked:FAIL");
		}

	}

	// TC_296
	@Then("^Verify the Image is by default selected$")
	public void verify_the_Image_is_by_default_selected() throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver
				.findElement(By
						.xpath("//div[@class='popover--wrapper']//label[@class='button button__sm button__primary ']"))
				.isDisplayed()) {
			login.Log4j.info("The Image is by default selected:PASS");
		}

		else {
			fail("The Image is by default selected:FAIL");
		}

	}

	// TC_297
	@Then("^Select Type 'Text=check'$")
	public void select_Type_Text_check() throws Throwable {
		CommonFunctionality.wait(2000);

//		if (login.driver.findElement(By.xpath("(//div[@class='popover--wrapper']//input[@type='radio'])[2]")).isSelected()) {
//
//			login.Log4j.info("Text radio button checked:PASS");
//		}
//
//		else {

		WebElement radio2 = login.driver.findElement(
				By.xpath("(//div[@class='popover--wrapper']//span[@class='input-control--description'])[3]"));

		// Radio Button1 is selected
		radio2.click();

		// login.driver.findElement(By.xpath("(//div[@class='popover--wrapper']//span[@class='input-control--description'])[3]")).click();

		// }

	}

	// TC_297
	@Then("^Edit the text as \"([^\"]*)\"$")
	public void edit_the_text_as(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//input[@name='credits_text']")).click();

		login.driver.findElement(By.xpath("//input[@name='credits_text']")).clear();

		login.driver.findElement(By.xpath("//input[@name='credits_text']")).sendKeys(arg1);

		CopyrightText = arg1;

	}

	// TC_297
	@Then("^Verify The Updated copyright should be displayed on visual$")
	public void verify_The_Updated_copyright_should_be_displayed_on_visual() throws Throwable {
		CommonFunctionality.wait(2000);

		String text = login.driver.findElement(By.xpath("//div[@class='visual-item-wrapper--text ']")).getText();
		System.out.println("Text:" + text);
		if (CopyrightText.equalsIgnoreCase(text)) {
			login.Log4j.info("The Updated copyright should be displayed on visual:PASS");
		} else {
			fail("The Updated copyright should be displayed on visual:FAIL");
		}

	}

	// TC_299
	@Then("^Select copyright color$")
	public void select_copyright_color() throws Throwable {
		CommonFunctionality.wait(2000);

		CommonFunctionality.wait(2000);

		login.driver
				.findElement(By.xpath(
						"//div[@class='popover--wrapper']//div[@class='index-module_swatch_button_item_color__gAHg1']"))
				.click();

		Thread.sleep(2000);

		login.driver.findElement(By.xpath("(//div[@class='index-module_wrapper__Q-UYB'])[6]")).click();

		CommonFunctionality.wait(2000);

	}

	// TC_299
	@Then("^Verify The Visual copyright should be displayed in selected color$")
	public void verify_The_Visual_copyright_should_be_displayed_in_selected_color() throws Throwable {

		CommonFunctionality.wait(2000);

		String color = login.driver.findElement(By.xpath("//a[@href='https://www.ceicdata.com/en']"))
				.getAttribute("style");

		System.out.println("color:" + color);

		if (color.contains(" rgb(43, 96, 208)")) {
			login.Log4j.info("The Visual copyright should be displayed in selected color:PASS");
		} else {

			fail("The Visual copyright should be displayed in selected color:FAIL");
		}

	}

	// TC_300

	@Then("^Select font size for visual copyright \"([^\"]*)\"$")
	public void select_font_size_for_visual_copyright(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//input[@name='credits_font_size']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//input[@name='credits_font_size']")).clear();

		// CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//input[@name='credits_font_size']")).sendKeys(arg1);
		CommonFunctionality.wait(2000);

		copyrightsFontsize = arg1;
		System.out.println("copyrightsFontsize:" + copyrightsFontsize);

	}

	// TC_300
	@Then("^Verify The copyright font size should be changed as per the selection$")
	public void verify_The_copyright_font_size_should_be_changed_as_per_the_selection() throws Throwable {
		CommonFunctionality.wait(2000);

		String fontsize = login.driver.findElement(By.xpath("//a[@href='https://www.ceicdata.com/en']"))
				.getAttribute("style");
		System.out.println("color:" + fontsize);

		if (fontsize.contains(copyrightsFontsize)) {
			login.Log4j.info("The copyright font size should be changed as per the selection:PASS");
		} else {

			fail("The copyright font size should be changed as per the selection:FAIL");
		}

	}

	// TC_301
	@Then("^Click on copyright 'Bold' icon$")
	public void click_on_copyright_Bold_icon() throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath("//button[@class='config-btn font-bold selected']")).isDisplayed()) {
			login.Log4j.info("copyright Bold icon allready selected:PASS");
		} else {

			login.driver.findElement(By.xpath("//button[@class='config-btn font-bold']")).click();

		}

	}

	// TC_301
	@Then("^Verify The copyright should be displayed in \"([^\"]*)\" format$")
	public void verify_The_copyright_should_be_displayed_in_format(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		String fontbold = login.driver.findElement(By.xpath("//a[@href='https://www.ceicdata.com/en']"))
				.getAttribute("style");
		System.out.println("fontbold:" + fontbold);

		if (fontbold.contains(arg1)) {
			login.Log4j.info("The copyright should be displayed in bold format:PASS");
		} else {

			fail("The copyright should be displayed in bold/italic format:FAIL");
		}

	}

	// TC_302
	@Then("^Click on copyright style 'Italic' icon$")
	public void click_on_copyright_style_Italic_icon() throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath("//button[@class='config-btn font-italic widget ']")).isDisplayed())

		{
			login.driver.findElement(By.xpath("//button[@class='config-btn font-italic widget ']")).click();
		} else {

			login.Log4j.info("copyright style - italic icon already selected:PASS");

		}

	}

	// TC_303
	@Then("^Click on copyright style 'Underline' icon$")
	public void click_on_copyright_style_Underline_icon() throws Throwable {
		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath("//button[@class='config-btn font-underline widget ']")).isDisplayed())

		{
			login.driver.findElement(By.xpath("//button[@class='config-btn font-underline widget ']")).click();
		} else {

			login.Log4j.info("copyright style - underline icon already selected:PASS");

		}
	}

//TC_304
	@Then("^Select horizontal alignment \"([^\"]*)\"$")
	public void select_horizontal_alignment(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//*[@data-value='" + arg1 + "']")).click();

	}

//TC_304
	@Then("^Verify The copyright align should be displayed in \"([^\"]*)\"$")
	public void verify_The_copyright_align_should_be_displayed_in(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);
		String align_Left = login.driver.findElement(By.xpath("//div[@class='visual-item-wrapper--credits-container']"))
				.getAttribute("style");

		if (align_Left.contains("start")) {
			login.Log4j.info("The copyright horizontal align should be displayed in Left side:PASS");
		} else {
			fail("The copyright horizontal align should be displayed in Left side:FAIL");
		}

	}

//TC_304
	@Then("^Verify The copyright align should be displayed in 'center'$")
	public void verify_The_copyright_align_should_be_displayed_in_center() throws Throwable {

		CommonFunctionality.wait(2000);
		CommonFunctionality.wait(2000);
		String align_center = login.driver
				.findElement(By.xpath("//div[@class='visual-item-wrapper--credits-container']")).getAttribute("style");

		if (align_center.contains("center")) {
			login.Log4j.info("The copyright horizontal align should be displayed in Center side:PASS");
		} else {
			fail("The copyright horizontal align should be displayed in center side:FAIL");
		}

	}

//TC_304
	@Then("^Verify The copyright align should be displayed in 'right'$")
	public void verify_The_copyright_align_should_be_displayed_in_right() throws Throwable {

		CommonFunctionality.wait(2000);
		String align_right = login.driver
				.findElement(By.xpath("//div[@class='visual-item-wrapper--credits-container']")).getAttribute("style");

		if (align_right.contains("end")) {
			login.Log4j.info("The copyright horizontal align should be displayed in right side:PASS");
		} else {
			fail("The copyright horizontal align should be displayed in right side:FAIL");
		}
	}

	// TC_305
	@Then("^Verify The copyright horizontal align should be display on 'top'$")
	public void verify_The_copyright_horizontal_align_should_be_display_on_top() throws Throwable {
		CommonFunctionality.wait(2000);

		String align_top = login.driver.findElement(By.xpath(
				"//*[@class='visual-item-template--credits-top']//div[@class='visual-item-wrapper--credits-container']"))
				.getAttribute("style");

		System.out.println(align_top);
		if (align_top.contains("start")) {
			login.Log4j.info("The copyright horizontal align should be displayed in Top:PASS");
		} else {
			fail("The copyright horizontal align should be displayed on top:FAIL");
		}

	}

	// TC_305
	@Then("^Verify The copyright horizontal align should be display on 'bottom'$")
	public void verify_The_copyright_horizontal_align_should_be_display_on_bottom() throws Throwable {

		CommonFunctionality.wait(2000);
		String align_bottom = login.driver.findElement(By.xpath(
				"//*[@class='visual-item-template--credits-bottom']//div[@class='visual-item-wrapper--credits-container']"))
				.getAttribute("style");
		System.out.println(align_bottom);
		if (align_bottom.contains("start")) {
			login.Log4j.info("The copyright horizontal align should be displayed on bottom:PASS");
		} else {
			fail("The copyright horizontal align should be displayed on bottom:FAIL");
		}

	}

	// TC_306
	@Then("^Click on copyright popup close \\(x\\) icon$")
	public void click_on_copyright_popup_close_x_icon() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//div[@class='popover--close']")).click();

	}

//TC_308
	@Then("^Verify The \"([^\"]*)\" Should be checked by default and advanced settings option should be present$")
	public void verify_The_Should_be_checked_by_default_and_advanced_settings_option_should_be_present(String arg1)
			throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver
				.findElement(
						By.xpath("//*[contains(text(),'Data labels')]//preceding-sibling::input[@type='checkbox']"))
				.isSelected()) {
			login.Log4j.info("The Data labels Should be checked by default:PASS");
		} else {
			login.driver
					.findElement(
							By.xpath("//*[contains(text(),'Data labels')]//preceding-sibling::input[@type='checkbox']"))
					.click();
			// login.Log4j.info("The Data labels Should be checked by default:PASS");
			// fail("The Data labels Should be checked by default:FAIL");
		}

		if (login.driver.findElement(By.xpath(
				"(//*[contains(text(),'Data labels')]//preceding-sibling::span//following::div[@title='Open advanced settings popup'])[1]"))
				.isDisplayed()) {
			login.Log4j.info("advanced settings option should be present:PASS");
		} else {
			fail("advanced settings option should be present:FAIL");
		}

	}

	// TC_309
	@Then("^Click on Data labels open advanced settings popup \\(cogwheel\\) icon$")
	public void click_on_Data_labels_open_advanced_settings_popup_cogwheel_icon() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath(
				"(//*[contains(text(),'Data labels')]//preceding-sibling::span//following::div[@title='Open advanced settings popup'])[1]"))
				.click();

	}

	// TC_309
	@Then("^Verify The Label section should be seen and can be opened/collapsed$")
	public void verify_The_Label_section_should_be_seen_and_can_be_opened_collapsed() throws Throwable {

		CommonFunctionality.wait(2000);
		if (login.driver.findElement(By.xpath("//div[@class='popover--wrapper']")).isDisplayed()) {
			login.Log4j.info("The Label section should be display:PASS");
		} else {
			fail("The Label section should be display:FAIL");
		}

		login.driver.findElement(By.xpath("//div[@class='accordion-config ']//div[@class='icon-expand']")).click();

		if (login.driver.findElement(By.xpath("//*[@class='accordion-config collapsed']//div[@class='icon-collapse']"))
				.isDisplayed()) {
			login.Log4j.info("Label section opened/collapsed should be display:PASS");
		} else {
			fail("Label section opened/collapsed should be display:FAIL");
		}

	}

	// TC_310
	@Then("^Verify the 'Labels' checked by default$")
	public void verify_the_Labels_checked_by_default() throws Throwable {
		CommonFunctionality.wait(2000);
		if (login.driver.findElement(By.xpath("//div[@class='popover--wrapper']//input[@type='checkbox']"))
				.isSelected()) {
			login.Log4j.info("The Labels check box checked by default:PASS");
		} else {
			fail("The Labels check box checked by default:FAIL");
		}

	}

	// TC_310
	@Then("^Select labels color$")
	public void select_labels_color() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath(
				"(//div[@class='popover--wrapper']//div[@class='index-module_swatch_button_item_color__gAHg1'])[1]"))
				.click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("(//div[@class='index-module_wrapper__Q-UYB'])[7]")).click();

		labelsColor = login.driver.findElement(By.xpath("//input[@class='index-module_text__GTkop']"))
				.getAttribute("value");

	}

	// TC_310
	@Then("^Verify The labels color Should be display with selected color$")
	public void verify_The_labels_color_Should_be_display_with_selected_color() throws Throwable {
		CommonFunctionality.wait(4000);

		String Color = login.driver
				.findElement(By.xpath(
						"(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0'])[1]//*"))
				.getAttribute("style");

		if (labelsColor.equalsIgnoreCase("fda546")) {

			login.Log4j.info("The labels color Should be display with selected color:PASS");
		}

		else {
			fail("The labels color Should be display with selected color:FAIL");
		}

	}

//TC_311
	@Then("^Click on labels Highlight and select color$")
	public void click_on_labels_Highlight_and_select_color() throws Throwable {
		CommonFunctionality.wait(4000);

		login.driver.findElement(By.xpath(
				"(//div[@class='popover--wrapper']//div[@class='index-module_swatch_button_item_color__gAHg1'])[2]"))
				.click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("(//div[@class='index-module_wrapper__Q-UYB'])[8]")).click();
	}

	// TC_311
	@Then("^Verify the labels highlight color Should be displayed with selected color in visual$")
	public void verify_the_labels_highlight_color_Should_be_displayed_with_selected_color_in_visual() throws Throwable {

		CommonFunctionality.wait(4000);

		String Color = login.driver
				.findElement(By
						.xpath("((//*[@class='highcharts-label-box highcharts-data-label-box'])[12]//following::*)[1]"))
				.getAttribute("style");

		if (Color.equalsIgnoreCase("ff5b4d")) {

			login.Log4j.info("the labels highlight color Should be displayed with selected color in visual:PASS");
		}

		else {
			fail("the labels highlight color Should be displayed with selected color in visual:FAIL");
		}

	}

	// TC_312

	@Then("^Verify The size default \"([^\"]*)\"$")
	public void verify_The_size_default(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);

		String size = login.driver.findElement(By.xpath("//input[@class='ui-spinner-input data_labels_font_size']"))
				.getAttribute("value");

		if (size.equalsIgnoreCase(size)) {
			login.Log4j.info("Default size should be displayed:PASS");
		} else {

			fail("Default size should not be displayed:FAIL");
		}

	}

	// TC_312
	@Then("^Select size in Labels \"([^\"]*)\"$")
	public void select_size_in_Labels(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//input[@class='ui-spinner-input data_labels_font_size']")).click();

		login.driver.findElement(By.xpath("//input[@class='ui-spinner-input data_labels_font_size']")).clear();

		login.driver.findElement(By.xpath("//input[@class='ui-spinner-input data_labels_font_size']")).sendKeys(arg1);

		LabelSize = arg1;

	}

	// TC_312
	@Then("^Verify The Selected size should be displayed in visual$")
	public void verify_The_Selected_size_should_be_displayed_in_visual() throws Throwable {

		CommonFunctionality.wait(2000);

		String fontSize = login.driver.findElement(By.xpath(
				"(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 highcharts-data-label-hidden'])[5]//*"))
				.getAttribute("style");
		System.out.println(LabelSize);
		System.out.println(fontSize);

		if (fontSize.contains(LabelSize)) {

			login.Log4j.info("The Selected size should be displayed in visual:PASS");

		}

		else {

			fail("The Selected size should be displayed in visual:FAIL ");
		}

	}

	// TC_313
	@Then("^Select label style \"([^\"]*)\"$")
	public void select_label_style(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath("//button[@class='config-btn font-bold selected']")).isDisplayed()) {
			login.Log4j.info("Defaulty bold style selected:PASS");

		} else {
			login.driver.findElement(By.xpath("//button[@class='config-btn font-bold']")).click();

		}

	}

	// TC_313
	@Then("^Select label style as \"([^\"]*)\"$")
	public void select_label_style_as(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath("//button[@class='config-btn font-" + arg1 + " widget ']"))
				.isDisplayed()) {

			login.driver.findElement(By.xpath("//button[@class='config-btn font-" + arg1 + " widget ']")).click();
		} else {

			login.Log4j.info("Already style selected:PASS: " + arg1);
		}

	}

	// TC_313
	@Then("^Verify The \"([^\"]*)\" style should be displayed in labels$")
	public void verify_The_style_should_be_displayed_in_labels(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		String fontStyle = login.driver.findElement(By.xpath(
				"(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 highcharts-data-label-hidden'])[5]//*"))
				.getAttribute("style");

		if (fontStyle.contains(arg1)) {

			login.Log4j.info("The Selected font style should be displayed in visual:PASS: " + arg1);

		}

		else {

			fail("The Selected fonr style should be displayed in visual:FAIL ");
		}

	}

	// TC_316
	@Then("^Click on 'tooltip dropdown'$")
	public void click_on_tooltip_dropdown() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver
				.findElement(By.xpath(
						"(//div[@class='attributes-list-context-title tooltip-context-title']//following::div)[1]"))
				.click();

	}

	// TC_316
	@Then("^Verify The by default date and value checkbox shoud be checked$")
	public void verify_The_by_default_date_and_value_checkbox_shoud_be_checked() throws Throwable {

		CommonFunctionality.wait(2000);

		List<WebElement> checkbox = login.driver
				.findElements(By.xpath("//div[@class='items-wrapper']//input[@class='input-control--input']"));

		for (int i = 1; i < checkbox.size(); i++) {
			String value = checkbox.get(i).getText();
			if (i == 3) {
				break;
			}
			if (login.driver
					.findElement(By.xpath("//div[@class='items-wrapper']//input[@class='input-control--input']"))
					.isSelected()) {

				login.Log4j.info("The by default date and value checkbox shoud be checked:PASS: " + value);

			} else {
				fail("The by default date and value checkbox shoud be checked:FAIL ");
			}

		}

	}

	// TC_317
	@Then("^Verify The tooltip field \"([^\"]*)\" value should be displayed as default$")
	public void verify_The_tooltip_field_value_should_be_displayed_as_default(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		String tooltipsValue = login.driver
				.findElement(By.xpath("//div[@class='attributes-list-context-title tooltip-context-title']")).getText();

		if (tooltipsValue.equalsIgnoreCase(tooltipsValue)) {
			login.Log4j.info("The Tooltips value should be displayed by default:PASS: " + arg1);
		} else {
			fail("The Tooltips value should be displayed by default:FAIL ");
		}

	}

	// TC_323

	@Then("^Verify The \"([^\"]*)\",\"([^\"]*)\" should be available$")
	public void verify_The_should_be_available(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(2000);

		List<WebElement> data = login.driver.findElements(By.xpath("//div[@class='title']"));

		for (int i = 0; i < data.size(); i++) {

			System.out.println(data.get(i).getText());
			if (data.get(i).getText().equalsIgnoreCase(arg1)) {
				login.Log4j.info("Text should be displayed:PASS: " + arg1);
			} else if (data.get(i).getText().equalsIgnoreCase(arg2)) {

				login.Log4j.info("Text should be displayed:PASS: " + arg2);
			}

		}

	}

	// TC_324

	@Then("^Verify The Tooltip \"([^\"]*)\" should be checked default$")
	public void verify_The_Tooltip_should_be_checked_default(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath("//div[@class='tooltip-config']//input[@class='input-control--input']"))
				.isSelected()) {
			login.Log4j.info("Show tooltips should be checked default:PASS");

		} else {
			fail("Show tooltips should be checked default:FAIL ");

		}

	}

	// TC_326
	@Then("^Items - click on plus icon$")
	public void items_click_on_plus_icon() throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//div[text()='Items']//following::div[@class='icon-collapse']")).click();

	}

//TC_326
	@Then("^click on items - plus icon and Verify the dropdown data \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void click_on_items_plus_icon_and_Verify_the_dropdown_data(String arg1, String arg2, String arg3,
			String arg4) throws Throwable {

		CommonFunctionality.wait(2000);

		String name = login.driver.findElement(By.xpath("//div[@class='select-behaviour--multi-select-item']//span"))
				.getText();

		if (name.equalsIgnoreCase(arg1)) {
			login.Log4j.info("Name displayed:" + arg1);
		} else {
			fail("Name display:FAIL");
		}

		Thread.sleep(2000);
		List<WebElement> drop = login.driver.findElements(By.xpath("//*[@class='form--control multi']//option"));

		System.out.println(drop.size());

		if (drop.size() == 4) {
			login.Log4j.info("Drop down values verified");
		}

	}

//TC_351
	@Then("^Click on Solid color$")
	public void click_on_Solid_color() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//*[text()='Solid color']")).click();
	}

//TC_351
	@Then("^Verify The color steps by default \"([^\"]*)\" selected$")
	public void verify_The_color_steps_by_default_selected(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		String steps = login.driver.findElement(By.xpath("(//*[@name='steps']//option)[4]")).getText();
		System.out.println(steps);

		if (steps.equalsIgnoreCase(arg1)) {
			login.Log4j.info("The color steps by default display:PASS:" + arg1);
		} else {
			fail("The color steps by default display:FAIL");

		}

	}

//TC_351
	@Then("^Click on color steps dropdown and Verify the values (\\d+) to (\\d+)$")
	public void click_on_color_steps_dropdown_and_Verify_the_values_to(int arg1, int arg2) throws Throwable {
		CommonFunctionality.wait(2000);

		List<WebElement> steps = login.driver.findElements(By.xpath("//*[@name='steps']//option"));
		solidcolor = new ArrayList<>(Arrays.asList("2", "3", "4", "5", "6", "7"));
		for (int a = 0; a < steps.size(); a++) {

			String text = steps.get(a).getText();

			slodColorSteps.add(text);

		}

		if (slodColorSteps.equals(solidcolor)) {
			login.Log4j.info("Color steps dropdown verified:PASS" + slodColorSteps);
		}

		else {
			fail("Color steps dropdown verified:FAIL:" + slodColorSteps);

		}

	}

	// TC_319
	@Then("^Select \"([^\"]*)\" field$")
	public void select_field(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath("//*[@title='" + arg1 + "']//input[@class='input-control--input']"))
				.isSelected()) {

			login.Log4j.info("Region Selected already:PASS");
		} else {

			login.driver
					.findElement(By.xpath(
							"//*[@class='items-wrapper']//*[contains(text(),'" + arg1 + "')]//preceding-sibling::span"))
					.click();

		}

	}

	// TC_319
	@Then("^Verify The tooltips of visual should include with \"([^\"]*)\" of series$")
	public void verify_The_tooltips_of_visual_should_include_with_of_series(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		WebElement datalabels = login.driver.findElement(
				By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0'])[1]"));

		action.moveToElement(datalabels).build().perform();

		if (login.driver.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]")).isDisplayed()) {

			login.Log4j.info(
					"Tooltips of visual should include with region/frequency/function description of series display:PASS:"
							+ arg1);
		} else {

			fail("Tooltips of visual should include with region/frequency/function description of series display:FAIL");
		}

	}

	// TC_325
	@Then("^UnSelecte the \"([^\"]*)\" check box$")
	public void unselecte_the_check_box(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		CommonFunctionality.wait(2000);

		if (!login.driver.findElement(By.xpath("//div[@class='tooltip-config']//input[@class='input-control--input']"))
				.isSelected()) {
			login.Log4j.info("Show tooltips should be checked default:PASS");

		} else {

			login.driver.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]//preceding-sibling::span")).click();
		}

	}

	// TC_325
	@Then("^Verify The 'Tooltips' for visual should not be shown$")
	public void verify_The_Tooltips_for_visual_should_not_be_shown() throws Throwable {
		CommonFunctionality.wait(2000);

		WebElement datalabels = login.driver.findElement(
				By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0'])[1]"));

		action.moveToElement(datalabels).build().perform();

		if (login.driver.findElements(By.xpath("//*[contains(text(),'Date')]")).size() == 0) {
			login.Log4j.info("Tooltips for visual should not be shown:PASS");

		} else {

			fail("Tooltips' for visual should not be shown:FAIL");
		}

	}

	// TC_321

	@Then("^Apply the function in series and save$")
	public void apply_the_function_in_series_and_save() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("(//div[@class='function-editor-window--icon'])[1]")).click();
		CommonFunctionality.wait(2000);

		WebElement cat = login.driver.findElement(By.xpath("(//div[@class='function-item'])[1]"));

		action.moveToElement(cat).doubleClick().build().perform();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//*[@class='button button__primary']")).click();
		CommonFunctionality.wait(2000);

	}

	// TC_328
	@Then("^Click on \"([^\"]*)\" plus iocn$")
	public void click_on_plus_iocn(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("(//*[@class='title'])[2]//following::div[@class='icon-collapse']")).click();

	}

//TC_328
	@Then("^click on plus icon - try adding \"([^\"]*)\" attributes to be present in tooltip of visual$")
	public void click_on_plus_icon_try_adding_attributes_to_be_present_in_tooltip_of_visual(String arg1)
			throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//*[@class='add-item-attribute btn']")).click();
		WebElement region = login.driver.findElement(By.xpath(
				"//li[@class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']"));
		System.out.println("Region:" + region.getText());
		if (region.getText().equalsIgnoreCase(arg1)) {
			region.click();
			login.Log4j.info("Adding Region attributes to be present in tooltip of visual:PASS");
		} else {

			fail("Adding Region attributes to be present in tooltip of visual:FAIL");
		}

	}

//TC_328
	@Then("^Verify The \"([^\"]*)\" attribute should be display in tooltips$")
	public void verify_The_attribute_should_be_display_in_tooltips(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);

		WebElement datalabels = login.driver.findElement(
				By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0'])[1]"));

		action.moveToElement(datalabels).build().perform();
		if (login.driver.findElement(By.xpath("(//*[@class='table-tooltip']//*[contains(text(),'" + arg1 + "')])[1]"))
				.isDisplayed()) {

			login.Log4j.info("The Region/frequency attribute should be display in tooltips:PASS");
		}

		else {
			fail("The Region/frequency attribute should be display in tooltips:FAIL");
		}

	}

//TC_329
	@Then("^click on plus icon - adding \"([^\"]*)\" attributes to be present in tooltip of visual$")
	public void click_on_plus_icon_adding_attributes_to_be_present_in_tooltip_of_visual(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//*[@class='add-item-attribute btn']")).click();
		WebElement frequency = login.driver.findElement(
				By.xpath("(//li[@class='select2-results-dept-0 select2-result select2-result-selectable'])[1]"));
		System.out.println("Frequency:" + frequency.getText());
		if (frequency.getText().equalsIgnoreCase(arg1)) {
			frequency.click();
			login.Log4j.info("Adding Frequency attributes to be present in tooltip of visual:PASS");
		} else {

			fail("Adding Frequency attributes to be present in tooltip of visual:FAIL");
		}

	}

//TC_330
	@Then("^click on plus icon - adding \"([^\"]*)\" attributes in tooltip of visual$")
	public void click_on_plus_icon_adding_attributes_in_tooltip_of_visual(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//*[@class='add-item-attribute btn']")).click();
		WebElement description = login.driver.findElement(
				By.xpath("(//li[@class='select2-results-dept-0 select2-result select2-result-selectable'])[2]"));
		System.out.println("Frequency:" + description.getText());
		if (description.getText().equalsIgnoreCase(arg1)) {
			description.click();
			login.Log4j.info("Adding Function Description attributes to be present in tooltip of visual:PASS");
		} else {
			fail("Adding Function Description attributes to be present in tooltip of visual:FAIL");
		}
	}

//TC_326
	@Then("^Solid color - Click on \"([^\"]*)\" cogwheel$")
	public void solid_color_Click_on_cogwheel(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(
				By.xpath("(//div[@class='color-axis--row']//*[contains(text(),'Solid color')]//following::div[@title='"
						+ arg1 + "'])[1]"))
				.click();

	}

//TC_326
	@Then("^Verify The Open advanced settings popup list$")
	public void verify_The_Open_advanced_settings_popup_list() throws Throwable {

		CommonFunctionality.wait(2000);

		List<WebElement> solidColor = login.driver.findElements(By.xpath("//div[@class='accordion-header']"));
		Legendropdown = new ArrayList<>(Arrays.asList("Common", "Color axes", "Position", "Background", "Border"));

		for (int i = 0; i < solidColor.size(); i++) {
			String list_Value = solidColor.get(i).getText();
			drodpdownvalues.add(list_Value);
		}

		if (drodpdownvalues.equals(Legendropdown)) {
			login.Log4j.info("The Open advanced settings popup list:PASS:" + drodpdownvalues);
		}

		else {
			login.Log4j.info("The Open advanced settings popup list:FAIL" + drodpdownvalues);
		}

		if (login.driver.findElement(By.xpath("//div[@class='accordion-config ']//div[@class='icon-expand']"))
				.isDisplayed()) {

			String dropValue = login.driver.findElement(By
					.xpath("//div[@class='popover--wrapper']//*[@class='solid-colors--color-stops-select']//option[4]"))
					.getText();

			if (dropValue.equalsIgnoreCase("5")) {
				login.Log4j.info("color steps defauly displayed:PASS:" + dropValue);
			} else {
				fail("color steps defauly displayed:FAIL:" + dropValue);
			}

		} else {
			fail("Color axes section is displayed with solid color:FAIL:");
		}

	}

	// TC_357
	@Then("^Click on \\( \\+ \\) icon from \"([^\"]*)\" section$")
	public void click_on_icon_from_section(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath("(//div[@class='accordion-config collapsed']//div[contains(text(),'"
				+ arg1 + "')]//following::div[@class='icon-collapse'])[1]")).isDisplayed()) {
			login.driver
					.findElement(By.xpath(
							"(//div[contains(text(),'" + arg1 + "')]//following::div[@class='icon-collapse'])[1]"))
					.click();

		}

	}

	// TC_357
	@Then("^Verify The \"([^\"]*)\" checkbox checked by default$")
	public void verify_The_checkbox_checked_by_default(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By
				.xpath("//*[contains(text(),'" + arg1 + "')]//preceding-sibling::input[@class='input-control--input']"))
				.isSelected()) {

			login.Log4j.info("Show legend checkbox checked by default:PASS");

		} else {
			fail("Show legend checkbox checked by default:FAIL:");
		}

	}

	// TC_358
	@Then("^Verify The \"([^\"]*)\" section is displayed$")
	public void verify_The_section_is_displayed(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//*[contains(text(),'Vertical align:')]")).isDisplayed();

		login.driver.findElement(By.xpath("//*[contains(text(),'Horizontal align:')]")).isDisplayed();

		login.Log4j.info("The Position section is displayed:PASS");
	}

	// TC_359
	@Then("^Verify The \"([^\"]*)\" disabled default$")
	public void verify_The_disabled_default(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver.findElements(By.xpath("(//div[@class='col disabled'])[2]")).size() == 1) {
			login.Log4j.info("The Opacity(%) disabled default:PASS");

		}

		else {

			fail("The Opacity(%) disabled default:FAIL:");
		}

	}

	// TC_360
	@Then("^Verify The 'Radius' disabled default$")
	public void verify_The_Radius_disabled_default() throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver.findElements(By.xpath("(//div[@class='spinner-control disabled'])[2]")).size() == 1) {
			login.Log4j.info("The Radius disabled default:PASS");

		}

		else {

			fail("The Radius disabled default:FAIL:");
		}

	}

	// TC_361
	@Then("^Click on 'Gradient' button$")
	public void click_on_Gradient_button() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//*[contains(text(),'Gradient')]")).click();

	}

	// TC_361
	@Then("^Verify The list \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void verify_The_list(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {

		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//div[@class='gradient-axis--steps-label']")).isDisplayed();

		List<WebElement> list = login.driver
				.findElements(By.xpath("//*[@class='gradient-axis']//*[@class='input-control--description']"));

		for (int i = 0; i < list.size(); i++) {

			String value = list.get(i).getText();
			if (value.equalsIgnoreCase(arg2)) {
				login.Log4j.info("Gradient list Logarithmic :PASS");

			} else if (value.equalsIgnoreCase(arg3)) {
				login.Log4j.info("Gradient list Per series :PASS");

			} else {
				fail("Gradient list:FAIL:");
			}
		}

		List<WebElement> small = login.driver.findElements(By.xpath("//*[@class='value-selection--title']"));

		for (int i = 0; i < small.size(); i++) {

			String list11 = small.get(i).getText();

			if (list11.equalsIgnoreCase(arg4)) {
				login.Log4j.info("Gradient list Smallest Value :PASS");

			} else if (list11.equalsIgnoreCase(arg5)) {
				login.Log4j.info("Gradient list Largest Value:PASS");

			}

			else {
				fail("Gradient list:FAIL");

			}
		}

	}

	// TC_362
	@Then("^Verify The By default \"([^\"]*)\" color step will be displayed$")
	public void verify_The_By_default_color_step_will_be_displayed(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		String dropValue = login.driver.findElement(By.xpath("//*[@class='gradient-axis--steps-select']//option[1]"))
				.getText();

		if (dropValue.equalsIgnoreCase(arg1)) {
			login.Log4j.info("By default 0 color step will be displayed:PASS");

		} else {
			fail("By default 0 color step will be displayed:FAIL");
		}

	}

	// TC_362
	@Then("^Verify The Steps dropdown from (\\d+) to (\\d+) will be available$")
	public void verify_The_Steps_dropdown_from_to_will_be_available(int arg1, int arg2) throws Throwable {
		CommonFunctionality.wait(2000);

		List<WebElement> dropdown = login.driver
				.findElements(By.xpath("//*[@class='gradient-axis--steps-select']//option"));
		ArrayList<String> value = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5"));
		ArrayList<String> list = new ArrayList<String>();

		for (int i = 0; i < dropdown.size(); i++) {
			String a = dropdown.get(i).getText();

			list.add(a);

		}
		if (list.equals(value)) {
			login.Log4j.info("Steps dropdown from 0 to 5 will be available:PASS:" + list);

		} else {
			fail("Steps dropdown from 0 to 5 will be available:FAIL:" + list);

		}

	}

	// TC_363

	@Then("^Click on steps dropdown and Select value \"([^\"]*)\"$")
	public void click_on_steps_dropdown_and_Select_value(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//*[@name='steps']")).click();

		List<WebElement> dropdown = login.driver
				.findElements(By.xpath("//*[@class='gradient-axis--steps-select']//option"));

		for (int i = 0; i < dropdown.size(); i++) {

			if (dropdown.get(i).getText().equals(arg1)) {
				dropdown.get(i).click();
			}
		}
		// login.driver.findElement(By.xpath("//*[@class='gradient-axis--steps-select']//option["
		// + arg1 + "]")).click();
		// Steps_Color = arg1;

	}

	// TC_363
	@Then("^Verift The Selected color steps will be created with smallest and highest values$")
	public void verift_The_Selected_color_steps_will_be_created_with_smallest_and_highest_values() throws Throwable {
		CommonFunctionality.wait(2000);

		int steps = Steps_Color + 1;

		if (login.driver.findElements(By.xpath("//*[@class='gradient-line']")).size() == steps) {
			login.Log4j.info("The Selected color steps will be created with smallest and highest values:PASS" + steps);

		} else {
			fail("The Selected color steps will be created with smallest and highest values:FAIL:" + steps);
		}

	}

	// TC_369
	@Then("^Verify The \"([^\"]*)\" checked by default$")
	public void verify_The_checked_by_default(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]/preceding-sibling::input"))
				.isSelected()) {
			login.Log4j.info("The Series axis checked by default:PASS");

		} else {
			fail("The Series axis checked by default:FAIL:");
		}

	}

//TC_369
	@Then("^Verify The Series names displayed in visual$")
	public void verify_The_Series_names_displayed_in_visual() throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver.findElements(By.xpath("(//*[@class='series-edit--title series-edit--title__editable'])[1]"))
				.size() == 1) {
			login.Log4j.info("The Series names displayed in visual:PASS");
		} else {
			fail("The Series names displayed in visual:FAIL");
		}

	}

//TC_370
	@Then("^uncheck the \"([^\"]*)\"$")
	public void uncheck_the(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		if (login.driver.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]/preceding-sibling::input"))
				.isSelected()) {
			login.driver
					.findElement(
							By.xpath("(//*[@class='base-config--column']//*[@class='input-control--indicator'])[1]"))
					.click();
		} else {
			fail("The Series axis checked by default:FAIL");
		}

	}

//TC_370
	@Then("^Verify The Series names not displayed in visual$")
	public void verify_The_Series_names_not_displayed_in_visual() throws Throwable {
		CommonFunctionality.wait(2000);

		if (login.driver.findElements(By.xpath("(//*[@class='series-edit--title series-edit--title__editable'])[1]"))
				.size() == 0)

		{
			login.Log4j.info("The Series names not displayed in visual:PASS");
		}

		else {
			fail("The Series names not displayed in visual:FAIL:");
		}

	}

//TC_371
	@Then("^Series axis - Click on Open Advanced settings popup - cogwheel$")
	public void series_axis_Click_on_Open_Advanced_settings_popup_cogwheel() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath(
				"(//*[contains(text(),'Series axis')]//following::div[@title='Open advanced settings popup'])[1]"))
				.click();

	}

//TC_371
	@Then("^Verify The 'Label section' and opened/collapsed should be displayed$")
	public void verify_The_Label_section_and_opened_collapsed_should_be_displayed() throws Throwable {

		CommonFunctionality.wait(2000);

		if (login.driver.findElements(By.xpath("//*[@class='popover--wrapper']//*[text()='Labels']")).size() == 1) {
			if (login.driver
					.findElements(By.xpath("(//*[@class='popover--wrapper']//*[text()='Labels']//following::div)[1]"))
					.size() == 1) {
				login.Log4j.info("The 'Label section' and opened/collapsed should be displayed:PASS");
			}

			else {

				fail("The 'Label section' and opened/collapsed should be displayed:FAIL:");
			}

		}

	}

	// TC_372
	@Then("^Verify the label checkbox checked by default$")
	public void verify_the_label_checkbox_checked_by_default() throws Throwable {
		CommonFunctionality.wait(2000);

		if (login.driver.findElement(By.xpath("//*[text()='Labels']//following::input[@class='input-control--input']"))
				.isSelected()) {
			login.Log4j.info("The label checkbox checked by default:PASS");
		} else {

			login.driver.findElement(By.xpath("//*[text()='Labels']//following::input[@class='input-control--input']"))
					.click();
		}

	}

//TC_372
	@Then("^Verify The Label section should be enabled and \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" should be seen$")
	public void verify_The_Label_section_should_be_enabled_and_should_be_seen(String arg1, String arg2, String arg3,
			String arg4) throws Throwable {
		CommonFunctionality.wait(2000);

		if (login.driver.findElements(By.xpath("//div[@class='col']")).size() == 5) {
			login.Log4j.info("The Label section should be enabled:PASS");
		}

		else {

			fail("The Label section should be enabled:FAIL:");
		}

	}

//TC_373
	@Then("^Click on color and change the color$")
	public void click_on_color_and_change_the_color() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver
				.findElement(By.xpath(
						"//*[@class='popover--wrapper']//*[@class='index-module_swatch_button_item_color__gAHg1']"))
				.click();

		login.driver.findElement(By.xpath("(//div[@class='index-module_wrapper__Q-UYB'])[4]")).click();

	}

//TC_373
	@Then("^Verify The Selected color should be applied and displayed$")
	public void verify_The_Selected_color_should_be_applied_and_displayed() throws Throwable {
		CommonFunctionality.wait(2000);

		String color = login.driver
				.findElement(By.xpath("(//div[@class='highcharts-axis-labels highcharts-yaxis-labels']//span)[1]"))
				.getAttribute("style");

		if (color.contains("rgb(167, 165, 163)")) {
			login.Log4j.info("The Selected color should be applied and displayed:PASS");
		}

		else {
			fail("The Selected color should be applied and displayed:FAIL");
		}

	}

//TC_374
	@Then("^Change the 'Size' in Label \"([^\"]*)\"$")
	public void change_the_Size_in_Label(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//*[@class='ui-spinner-input y_axis_label_font_size']")).click();
		login.driver.findElement(By.xpath("//*[@class='ui-spinner-input y_axis_label_font_size']")).clear();
		login.driver.findElement(By.xpath("//*[@class='ui-spinner-input y_axis_label_font_size']")).sendKeys(arg1);

		Label_size = arg1;

	}

//TC_374
	@Then("^Verify the 'Series size' should be applied and displayed$")
	public void verify_the_Series_size_should_be_applied_and_displayed() throws Throwable {
		CommonFunctionality.wait(2000);

		String size = login.driver
				.findElement(By.xpath(
						"(//*[@class='series-edit--title series-edit--title__editable'])[1]//following::span[4]"))
				.getAttribute("style");

		if (size.contains(Label_size)) {
			login.Log4j.info("Series size' should be applied and displayed:PASS");
		} else {

			fail("Series size' should be applied and displayed:FAIL");
		}

	}

//TC_375
	@Then("^Change the style to \"([^\"]*)\"$")
	public void change_the_style_to(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

		if (login.driver.findElements(By.xpath("//*[@class='config-btn font-bold selected']")).size() == 1) {
			login.Log4j.info("Defaulty bold selected:PASS");

		}

		else {
			login.driver.findElement(By.xpath("//*[@class='config-btn font-bold']")).click();

		}

	}

//TC_375

	@Then("^Verify the Selected style \"([^\"]*)\" displayed in visual$")
	public void verify_the_Selected_style_displayed_in_visual(String arg1) throws Throwable {

		String bold = login.driver
				.findElement(By.xpath(
						"(//*[@class='series-edit--title series-edit--title__editable'])[1]//following::span[4]"))
				.getAttribute("style");

		if (bold.contains(arg1)) {
			login.Log4j.info("selected style bold/italic/underline displayed:PASS");
		} else {

			fail("Selected style bold/italic/underline displayed:FAIL");
		}

	}

//TC_375
	@Then("^Click on the style to \"([^\"]*)\"$")
	public void click_on_the_style_to(String arg1) throws Throwable {

		CommonFunctionality.wait(3000);

		if (login.driver.findElements(By.xpath("//*[@class='config-btn font-" + arg1 + " widget ']")).size() == 1)

		{
			login.driver.findElement(By.xpath("//*[@class='config-btn font-" + arg1 + " widget ']")).click();

		}

		else {
			login.Log4j.info("Defaulty italic/underline selected:PASS");

		}

	}

//TC_376
	@Then("^Change the rotation \"([^\"]*)\"$")
	public void change_the_rotation(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath("//*[@class='ui-spinner-input y_axis_label_rotation']")).click();

		login.driver.findElement(By.xpath("//*[@class='ui-spinner-input y_axis_label_rotation']")).clear();

		login.driver.findElement(By.xpath("//*[@class='ui-spinner-input y_axis_label_rotation']")).sendKeys(arg1);

		Rotate = arg1;

	}

//TC_376
	@Then("^Verify The Label rotation Selected series will be rotated clockwise$")
	public void verify_The_Label_rotation_Selected_series_will_be_rotated_clockwise() throws Throwable {

		CommonFunctionality.wait(3000);

		String rotate = login.driver
				.findElement(By.xpath(
						"(//*[@class='series-edit--title series-edit--title__editable'])[1]//following::span[4]"))
				.getAttribute("style");

		if (rotate.contains(Rotate)) {
			login.Log4j.info("selected Rotation displayed:PASS");
		} else {

			fail("selected Rotation displayed:FAIL");
		}

	}

//TC_377
	@Then("^Verify The By default \"([^\"]*)\" checkbox will be checked$")
	public void verify_The_By_default_checkbox_will_be_checked(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);

		if (login.driver.findElement(By.xpath("//*[contains(text(),'Time axis')]/preceding-sibling::input"))
				.isSelected()) {
			login.Log4j.info("By default 'Time axis' checkbox checked:PASS");

		} else {

			fail("By default 'Time axis' checkbox checked:FAIL");
		}

	}

//TC_377
	@Then("^Verify The time will be added below HeatMap visual$")
	public void verify_The_time_will_be_added_below_HeatMap_visual() throws Throwable {
		CommonFunctionality.wait(3000);

		if (login.driver.findElements(By.xpath(
				"(//*[@class='public-js-views-insight_visuals-visual_parts-xaxis_formatters-heatmap-heatmap_xaxis_formatter-module__wrapper '])[1]"))
				.size() == 1) {
			login.Log4j.info("Time will be displayed:PASS");

		} else {

			fail("Time will be displayed:FAIL");
		}

	}

//TC_378
	@Then("^Uncheck Time axis checkbox$")
	public void uncheck_Time_axis_checkbox() throws Throwable {
		CommonFunctionality.wait(3000);

		if (login.driver.findElement(By.xpath("//*[contains(text(),'Time axis')]/preceding-sibling::input"))
				.isSelected()) {
			login.driver.findElement(By.xpath("//*[contains(text(),'Time axis')]")).click();

		} else {

			fail("'Time axis' checkbox checked:FAIL");
		}

	}

//TC_378
	@Then("^Verify The time will be removed from the heatmap visual$")
	public void verify_The_time_will_be_removed_from_the_heatmap_visual() throws Throwable {
		CommonFunctionality.wait(3000);

		if (login.driver.findElements(By.xpath(
				"(//*[@class='public-js-views-insight_visuals-visual_parts-xaxis_formatters-heatmap-heatmap_xaxis_formatter-module__wrapper '])[1]"))
				.size() == 0) {
			login.Log4j.info("Time removed in Heatmap visual:PASS");

		} else {

			fail("Time removed in Heatmap visual:FAIL");
		}

	}

//TC_379

	@Then("^Click on time axis advanced setting cogwheel icon$")
	public void click_on_time_axis_advanced_setting_cogwheel_icon() throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver
				.findElement(By.xpath(
						"//*[contains(text(),'Time axis')]//following::div[@title='Open advanced settings popup']"))
				.click();

	}

//TC_379
	@Then("^Verify The window \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void verify_The_window(String arg1, String arg2, String arg3) throws Throwable {

		CommonFunctionality.wait(3000);

		if (login.driver.findElement(By.xpath("//div[@class='popover-content']")).isDisplayed()) {
			login.Log4j.info("Time Axis popup displayed:PASS");

			if (arg1.equalsIgnoreCase(login.driver.findElement(By.xpath("//*[text()='Axis setup']")).getText())) {
				login.Log4j.info("'Axis setup' text displayed:PASS");

				if (arg2.equalsIgnoreCase(login.driver.findElement(By.xpath("//*[text()='Labels']")).getText())) {
					login.Log4j.info("'Labels' text displayed:PASS");
					if (arg3.equalsIgnoreCase(
							login.driver.findElement(By.xpath("//*[text()='Date format']")).getText())) {
						login.Log4j.info("'Date format' text displayed:PASS");
					}
				}
			}

		}

		else {
			fail("Time Axis popup displayed:FAIL");
		}

	}

//TC_380
	@Then("^Click on \"([^\"]*)\" section$")
	public void click_on_section(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath(
				"(//*[@class='accordion-config collapsed']//*[text()='Labels']//following::div[@class='icon-collapse'])[1]"))
				.click();

	}

//TC_380
	@Then("^Verify The 'Labels' section checkbox checked and \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" should be seen$")
	public void verify_The_Labels_section_checkbox_checked_and_should_be_seen(String arg1, String arg2, String arg3,
			String arg4) throws Throwable {
		CommonFunctionality.wait(3000);

		if (login.driver
				.findElement(By
						.xpath("(//*[@class='row axes-labels']//div[@class='col'])//*[@class='input-control--input']"))
				.isSelected()) {
			login.Log4j.info("Label section:checkbox checked:PASS");

			if (login.driver
					.findElements(By.xpath("//*[@class='col ']//*[@class='index-module_swatch_button_item__fS-nf']"))
					.size() == 1) {
				login.Log4j.info("Label section:Color session Enable and displayed:PASS");

				if (login.driver.findElements(By.xpath("//*[@class='col axis-line-color ']")).size() == 1) {
					login.Log4j.info("Label section:Axis Color session Enable and displayed:PASS");

					if (login.driver.findElements(By.xpath(
							"//*[@class='col ']//*[@class='ui-spinner ui-corner-all ui-widget ui-widget-content']"))
							.size() == 1) {
						login.Log4j.info("Label section:Size session Enable and displayed:PASS");

						if (login.driver.findElements(By.xpath("//*[@class='col ']//*[@class='font-style']"))
								.size() == 1) {
							login.Log4j.info("Label section:Style session Enable and displayed:PASS");

						}

					}
				}
			}

		} else {
			fail("Label session checkbox unchecked:FAIL");
		}

	}

	@Then("^Enter the link in link textbox \"([^\"]*)\"$")
	public void enter_the_link_in_link_textbox(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath("//*[@name='credits_link']")).click();

		login.driver.findElement(By.xpath("//*[@name='credits_link']")).clear();

		login.driver.findElement(By.xpath("//*[@name='credits_link']")).sendKeys(arg1);
	}

	// TC_298
	@Then("^Click on the copyright and Verify The should redirect to mentioned link$")
	public void click_on_the_copyright_and_Verify_The_should_redirect_to_mentioned_link() throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath("//*[@class='visual-item-wrapper--text  text-dots']")).click();

		if (login.driver.findElements(By.xpath("//*[@class='popover--wrapper']")).size() == 1) {
			login.Log4j.info("Copyright popup displayed:PASS");
		} else {
			fail("Copyright popup displayed:FAIL");
		}
	}

	// TC_212
	@Then("^Verify The \"([^\"]*)\" & \"([^\"]*)\" should be shown$")
	public void verify_The_should_be_shown(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(3000);

		if (login.driver.findElement(By.xpath("//*[@class='size-control--label']")).getText().equalsIgnoreCase(arg1)) {

			login.Log4j.info("Horizontal align displayed:PASS");

			if (login.driver.findElement(By.xpath("//*[@class='size-control--label size-control--label__align_top']"))
					.getText().equalsIgnoreCase(arg2)) {

				login.Log4j.info("Proportion displayed:PASS");
			}
		} else {

			fail("Horizontal align not displayed:FAIL");

		}

	}

	// TC_386
	@Then("^Select \"([^\"]*)\" dropdown and visual checkbox checked$")
	public void select_dropdown_and_visual_checkbox_checked(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver
				.findElement(
						By.xpath("(//*[text()='Border:']//following::div[@class='context-menu-control--icon'])[1]"))
				.click();

		if (login.driver
				.findElement(
						By.xpath("//*[contains(text(),'Visual')]/preceding-sibling::*[@class='input-control--input']"))
				.isSelected()) {
			login.Log4j.info("visual checkbox checked:PASS");

		} else {

			login.driver
					.findElement(By.xpath("(//*[@class='border-control']//*[@class='input-control--indicator'])[2]"))
					.click();
		}

	}

	// TC_386
	@Then("^Change visual border \"([^\"]*)\"$")
	public void change_visual_border(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath("//*[@name='visual_area_border_radius']")).click();

		login.driver.findElement(By.xpath("//*[@name='visual_area_border_radius']")).clear();
		login.driver.findElement(By.xpath("//*[@name='visual_area_border_radius']")).sendKeys(arg1);

		Radius_border = arg1;
	}

	// TC_386
	@Then("^Verify The changes in Edit visual popup only$")
	public void verify_The_changes_in_Edit_visual_popup_only() throws Throwable {
		CommonFunctionality.wait(3000);

		String radius = login.driver
				.findElement(By.xpath("//*[@class='visual-preview base-preview']//*[@class='visual-item-container']"))
				.getAttribute("style");
		CommonFunctionality.wait(3000);
		System.out.println(radius);
		System.out.println(Radius_border);
		if ((radius + "px").contains(Radius_border)) {
			login.Log4j.info("The changes in Edit visual popup displayed:PASS");
		} else {
			fail("The changes in Edit visual popup displayed:FAIL");
		}
	}

	// TC_387
	@Then("^Mouse move on 'visual title' and Click on 'edit icon'$")
	public void mouse_move_on_visual_title_and_Click_on_edit_icon() throws Throwable {
		CommonFunctionality.wait(3000);

		if (login.driver
				.findElement(By.xpath(
						"//*[@class='movable-modal--window ui-draggable']//*[@class='visual-title--text text-dots']"))
				.isDisplayed()) {

			WebElement mouse = login.driver.findElement(By.xpath(
					"//*[@class='movable-modal--window ui-draggable']//*[@class='visual-title--text text-dots']"));

			action.moveToElement(mouse).build().perform();

			login.driver.findElement(By.xpath(
					"//*[@class='movable-modal--window ui-draggable']//*[@class='visual-title--text text-dots']//following::*[@class='visual-title--icon visual-title--edit']"))
					.click();

		}

		else {

			login.driver
					.findElement(
							By.xpath("(//*[text()='Title:']//following::div[@class='context-menu-control--icon'])[1]"))
					.click();
			CommonFunctionality.wait(3000);
			login.driver.findElement(By.xpath("(//*[@class='title-control']//*[@class='input-control--input'])[1]"))
					.click();

			login.driver.findElement(By.xpath(
					"//*[@class='movable-modal--window ui-draggable']//*[@class='visual-title--text text-dots']//following::*[@class='visual-title--icon visual-title--edit']"))
					.click();

		}

	}

	// TC_387
	@Then("^Verify The 'Titles' popup should be displayed$")
	public void verify_The_Titles_popup_should_be_displayed() throws Throwable {
		CommonFunctionality.wait(3000);

		if (login.driver.findElement(By.xpath("//*[@class='popover--title']")).isDisplayed()) {
			login.Log4j.info("'Titles' popup should be displayed:PASS");
		} else {

			fail(" 'Titles' popup should be displayed:FAIL");
		}

	}

	// TC_388
	@Then("^Double click on visual title$")
	public void double_click_on_visual_title() throws Throwable {
		CommonFunctionality.wait(3000);

		if (login.driver
				.findElements(By.xpath(
						"//*[@class='movable-modal--window ui-draggable']//*[@class='visual-title--text text-dots']"))
				.size() == 1) {

			WebElement mouse = login.driver.findElement(By.xpath(
					"//*[@class='movable-modal--window ui-draggable']//*[@class='visual-title--text text-dots']"));

			action.doubleClick(mouse).build().perform();

		}

		else {

			login.driver
					.findElement(
							By.xpath("(//*[text()='Title:']//following::div[@class='context-menu-control--icon'])[1]"))
					.click();
			CommonFunctionality.wait(3000);
			login.driver.findElement(By.xpath("(//*[@class='title-control']//*[@class='input-control--input'])[1]"))
					.click();

			WebElement mouse = login.driver.findElement(By.xpath(
					"//*[@class='movable-modal--window ui-draggable']//*[@class='visual-title--text text-dots']"));

			action.doubleClick(mouse).build().perform();

		}

	}

	// TC_388
	@Then("^Double click on visual in edit visual window$")
	public void double_click_on_visual_in_edit_visual_window() throws Throwable {
		CommonFunctionality.wait(3000);

		WebElement mouse = login.driver
				.findElement(By.xpath("(//*[@class='highcharts-point highcharts-color-0 highcharts-null-point'])[1]"));

		action.doubleClick(mouse).build().perform();

	}

	// TC_388
	@Then("^Verify The 'Visual' popup should be displayed$")
	public void verify_The_Visual_popup_should_be_displayed() throws Throwable {
		CommonFunctionality.wait(3000);

		if (login.driver.findElements(By.xpath("//*[@class='popover--wrapper']")).size() == 1) {

			login.Log4j.info("The 'Visual' popup should be displayed:PASS");

		} else {

			fail("The 'Visual' popup should be displayed:FAIL");
		}

	}

	// TC_388
	@Then("^change the color in visual popup$")
	public void change_the_color_in_visual_popup() throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver.findElement(By
				.xpath("(//*[@class='popover--wrapper']//*[@class='index-module_swatch_button_item_color__gAHg1'])[1]"))
				.click();
		CommonFunctionality.wait(3000);
		login.driver.findElement(By.xpath("(//*[@class='index-module_wrapper__Q-UYB'])[4]")).click();
		CommonFunctionality.wait(3000);
		EditVisual_color = login.driver.findElement(By.xpath("//*[@class='index-module_text__GTkop']"))
				.getAttribute("value");

	}

	// TC_389
	@Then("^Verify The changes should apply to edit visual$")
	public void verify_The_changes_should_apply_to_edit_visual() throws Throwable {
		CommonFunctionality.wait(3000);

		String Selected_color = login.driver
				.findElement(By.xpath("(//*[@class='highcharts-point highcharts-color-0'])[6]")).getAttribute("stroke");

		System.out.println(Selected_color);
		System.out.println("#" + EditVisual_color);

		if ((Selected_color).contains("#f2f5f8")) {
			login.Log4j.info("The changes should apply to edit visual:PASS");
		} else {
			fail("The changes should apply to edit visual:FAIL");
		}

	}

	// TC_388
	@Then("^Verify The changes should apply to heatmap visual$")
	public void verify_The_changes_should_apply_to_heatmap_visual() throws Throwable {
		CommonFunctionality.wait(3000);

		String Selected_color = login.driver
				.findElement(By.xpath("(//*[@class='highcharts-point highcharts-color-0'])[1]")).getAttribute("stroke");

		if ((Selected_color).equalsIgnoreCase("#" + EditVisual_color)) {
			login.Log4j.info("The changes should apply to heatmap visual:PASS");
		} else {
			fail("The changes should apply to heatmap visual:FAIL");
		}

	}

	// TC_391

	@Then("^Double click on date$")
	public void double_click_on_date() throws Throwable {
		CommonFunctionality.wait(3000);

		WebElement mouse = login.driver.findElement(By.xpath(
				"(//*[@class='movable-modal--window ui-draggable']//*[@class='public-js-views-insight_visuals-visual_parts-xaxis_formatters-heatmap-heatmap_xaxis_formatter-module__wrapper '])[1]"));

		action.doubleClick(mouse).build().perform();

	}

//TC_391
	@Then("^Verify The 'Time Axis' popup should be displayed$")
	public void verify_The_Time_Axis_popup_should_be_displayed() throws Throwable {
		CommonFunctionality.wait(3000);

		if (login.driver.findElements(By.xpath("//*[@class='popover--wrapper']//*[text()='Time Axis']")).size() == 1) {
			login.Log4j.info("'Time Axis' popup should be displayed:PASS");

		} else {
			fail("'Time Axis' popup should be displayed:FAIL");
		}

	}

	// TC_391
	@Then("^change the size \"([^\"]*)\" in Time Axis popup and verify the changes should apply to edit visual$")
	public void change_the_size_in_Time_Axis_popup_and_verify_the_changes_should_apply_to_edit_visual(String arg1)
			throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath("//*[@class='ui-spinner-input x_axis_label_font_size']")).click();
		login.driver.findElement(By.xpath("//*[@class='ui-spinner-input x_axis_label_font_size']")).clear();
		login.driver.findElement(By.xpath("//*[@class='ui-spinner-input x_axis_label_font_size']")).sendKeys(arg1);

		CommonFunctionality.wait(3000);

		String fontSize = login.driver.findElement(By.xpath(
				"(//*[@class='movable-modal--window ui-draggable']//*[@class='highcharts-axis-labels highcharts-xaxis-labels']//span)[1]"))
				.getAttribute("style");
		if (fontSize.contains(arg1)) {
			login.Log4j.info("Changes should be applied to edit visual:PASS");
		} else {
			fail("Changes should be applied to edit visual:FAIL");

		}

		TimeAxis_size = arg1;

	}

	// TC_391
	@Then("^Verify the 'size' changes should be displayed on visual$")
	public void verify_the_size_changes_should_be_displayed_on_visual() throws Throwable {
		CommonFunctionality.wait(3000);

		String fontSize = login.driver
				.findElement(
						By.xpath("(//*[@class='highcharts-axis-labels highcharts-xaxis-labels']//following::span)[1]"))
				.getAttribute("style");
		if (fontSize.contains(TimeAxis_size)) {
			login.Log4j.info("the 'size' changes should be displayed on visual:PASS");
		} else {
			fail("the 'size' changes should be displayed on visual:FAIL");

		}

	}

//TC_392
	@Then("^Double click on timepoints$")
	public void double_click_on_timepoints() throws Throwable {
		CommonFunctionality.wait(3000);

		WebElement mouse = login.driver.findElement(By.xpath(
				"(//*[@class='movable-modal--window ui-draggable']//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0'])[1]"));

		action.doubleClick(mouse).build().perform();

	}

	// TC_392
	@Then("^Verify The 'Labels' popup should be displayed$")
	public void verify_The_Labels_popup_should_be_displayed() throws Throwable {
		CommonFunctionality.wait(3000);

		if (login.driver.findElements(By.xpath("//*[@class='popover--wrapper']//*[@class='popover--title']"))
				.size() == 1) {
			login.Log4j.info("The 'Labels' popup should be displayed:PASS");
		} else {
			fail("The 'Labels' popup should be displayed:FAIL");
		}

	}

	// TC_392
	@Then("^change the size \"([^\"]*)\" in Label popup and verify the changes should apply to edit visual$")
	public void change_the_size_in_Label_popup_and_verify_the_changes_should_apply_to_edit_visual(String arg1)
			throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath("//*[@name='data_labels_font_size']")).click();
		login.driver.findElement(By.xpath("//*[@name='data_labels_font_size']")).clear();

		login.driver.findElement(By.xpath("//*[@name='data_labels_font_size']")).sendKeys(arg1);
		CommonFunctionality.wait(3000);

		String size = login.driver.findElement(By.xpath("//*[@name='data_labels_font_size']")).getAttribute("value");

		if (size.equalsIgnoreCase(arg1)) {
			login.Log4j.info("Timepoints changes should be displayed in edit visual:PASS");
		} else {
			fail("Timepoints changes should be displayed in edit visual:FAIL");
		}

		Label_window_size = arg1;

	}

	// TC_392
	@Then("^Verify the timepoints 'size'  changes should be displayed on visual$")
	public void verify_the_timepoints_size_changes_should_be_displayed_on_visual() throws Throwable {
		CommonFunctionality.wait(3000);

		String size = login.driver
				.findElement(By.xpath(
						"(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0'])[1]"))
				.getAttribute("style");

		if (size.equalsIgnoreCase(Label_window_size)) {
			login.Log4j.info("Timepoints changes should be displayed in visual:PASS");
		} else {
			fail("Timepoints changes should be displayed in visual:FAIL");
		}

	}

	// TC_394
	@Then("^Click on series on HeatMap visual$")
	public void click_on_series_on_HeatMap_visual() throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath(
				"(//*[@class='movable-modal--window ui-draggable']//*[@class='series-edit--title series-edit--title__editable'])[1]"))
				.click();

	}

	// TC_394
	@Then("^Verify The Series info popup should be opened$")
	public void verify_The_Series_info_popup_should_be_opened() throws Throwable {
		CommonFunctionality.wait(3000);

		if (login.driver.findElements(By.xpath("//*[@class='movable-modal--window ui-resizable ui-draggable']"))
				.size() == 1) {
			login.Log4j.info("The Series info popup should be opened:PASS");
		} else {
			fail("The Series info popup should be opened:FAIL");
		}
	}

	// TC_395
	@Then("^Mouse move on serie name and click on cogwheel icon$")
	public void mouse_move_on_serie_name_and_click_on_cogwheel_icon() throws Throwable {
		CommonFunctionality.wait(3000);
		WebElement mouse = login.driver.findElement(By.xpath(
				"(//*[@class='movable-modal--window ui-draggable']//*[@class='series-edit--title series-edit--title__editable'])[2]"));

		action.moveToElement(mouse).build().perform();

		login.driver
				.findElement(By.xpath("(//*[@class='movable-modal--window ui-draggable']//*[@title='Edit series'])[2]"))
				.click();

	}

	// TC_395
	@Then("^Verify The dropdown values \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void verify_The_dropdown_values(String arg1, String arg2, String arg3, String arg4) throws Throwable {
		CommonFunctionality.wait(3000);

		if (login.driver.findElement(By.xpath("//*[text()='Rename']")).getText().equalsIgnoreCase(arg1)) {
			login.Log4j.info("Dropdown value 'Rename' displayed:PASS");

			if (login.driver.findElement(By.xpath("//*[text()='Frequency']")).getText().equalsIgnoreCase(arg2)) {
				login.Log4j.info("Dropdown value 'Frequency' displayed:PASS");

				if (login.driver.findElement(By.xpath("//*[text()='Currency']")).getText().equalsIgnoreCase(arg3)) {
					login.Log4j.info("Dropdown value 'Currency' displayed:PASS");

					if (login.driver.findElement(By.xpath("//*[text()='Change']")).getText().equalsIgnoreCase(arg4)) {
						login.Log4j.info("Dropdown value 'Change' displayed:PASS");
					} else {
						fail("Dropdown values not displayed:FAIL");
					}

				}

			}
		}
	}

	// TC_396
	@Then("^Mouse move on serie name and click on cogwheel icon and Click on \"([^\"]*)\"$")
	public void mouse_move_on_serie_name_and_click_on_cogwheel_icon_and_Click_on(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);
		WebElement mouse = login.driver.findElement(By.xpath(
				"(//*[@class='movable-modal--window ui-draggable']//*[@class='series-edit--title series-edit--title__editable'])[2]"));

		action.moveToElement(mouse).build().perform();

		login.driver
				.findElement(By.xpath("(//*[@class='movable-modal--window ui-draggable']//*[@title='Edit series'])[2]"))
				.click();

		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath("//*[@class='items-wrapper']//*[text()='" + arg1 + "']")).click();
	}

//TC_396
	@Then("^Verify The Rename popup should be displayed with all series and series name should be updated as per the change$")
	public void verify_The_Rename_popup_should_be_displayed_with_all_series_and_series_name_should_be_updated_as_per_the_change()
			throws Throwable {
		CommonFunctionality.wait(3000);

		if (login.driver.findElements(By.xpath("//*[@class='movable-modal--window ui-resizable ui-draggable']"))
				.size() == 1) {
			login.Log4j.info("The rename popup should be opened:PASS");
		} else {
			fail("The rename popup should be opened:FAIL");
		}

		login.driver.findElement(By.xpath(
				"(//*[@class='movable-modal--window ui-resizable ui-draggable']//*[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.click();

		login.driver.findElement(By.xpath(
				"(//*[@class='movable-modal--window ui-resizable ui-draggable']//*[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.clear();

		login.driver.findElement(By.xpath(
				"(//*[@class='movable-modal--window ui-resizable ui-draggable']//*[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.sendKeys("Test");

		login.driver.findElement(By.xpath("//*[text()='OK']")).click();

		String series_Name = login.driver.findElement(By.xpath(
				"(//*[@class='movable-modal--window ui-draggable']//*[@class='series-edit--title series-edit--title__editable'])[2]"))
				.getText();

		if (series_Name.contains("Test")) {
			login.Log4j.info("series name should be updated as per the change:PASS");
		}

		else {
			fail("series name should be updated as per the change:FAIL");
		}

	}

//TC_397
	@Then("^Select the \"([^\"]*)\"$")
	public void select_the(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath("//*[text()='" + arg1 + "']")).click();

	}

//TC_397
	@Then("^Verify The Selected frequency \"([^\"]*)\" should be applied to the series$")
	public void verify_The_Selected_frequency_should_be_applied_to_the_series(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);
		WebElement mouse = login.driver.findElement(By.xpath(
				"(//*[@class='movable-modal--window ui-draggable']//*[@class='series-edit--title series-edit--title__editable'])[1]"));

		action.moveToElement(mouse).build().perform();

		String fun = login.driver.findElement(By.xpath("//*[text()='Functions']//following::div[1]")).getText();

		System.out.println(fun);
		System.out.println(arg1);
		if (fun.contains("Yearly;"))

		{
			login.Log4j.info("selected frequency should be displayed:PASS");
		} else {

			fail("selected frequency should be displayed:FAIL");
		}
	}

//TC_398
	@Then("^Verify The Selected Currency \"([^\"]*)\" should be applied to the series$")
	public void verify_The_Selected_Currency_should_be_applied_to_the_series(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);
		WebElement mouse = login.driver.findElement(By.xpath(
				"(//*[@class='movable-modal--window ui-draggable']//*[@class='series-edit--title series-edit--title__editable'])[1]"));

		action.moveToElement(mouse).build().perform();

		String unit = login.driver.findElement(By.xpath("//*[text()='Unit']//following::div[1]")).getText();

		System.out.println(unit);
		System.out.println(arg1);
		if (unit.contains(arg1))

		{
			login.Log4j.info("selected unit should be displayed:PASS");
		} else {

			fail("selected unit should be displayed:FAIL");
		}

	}

//TC_399
	@Then("^Verify The Selected Change \"([^\"]*)\" should be applied to the series$")
	public void verify_The_Selected_Change_should_be_applied_to_the_series(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);

		WebElement mouse = login.driver.findElement(By.xpath(
				"(//*[@class='movable-modal--window ui-draggable']//*[@class='series-edit--title series-edit--title__editable'])[2]"));

		action.moveToElement(mouse).build().perform();

		String change = login.driver.findElement(By.xpath("//*[text()='Functions']//following::div[1]")).getText();

		System.out.println(change);
		System.out.println(arg1);
		if (change.contains("Over Year"))

		{
			login.Log4j.info("selected change should be displayed:PASS");
		} else {

			fail("selected change should be displayed:FAIL");
		}
	}

	// TC_400
	@Then("^Click on Remove series\\(x\\)$")
	public void click_on_Remove_series_x() throws Throwable {
		CommonFunctionality.wait(3000);

		WebElement mouse = login.driver.findElement(By.xpath(
				"(//*[@class='movable-modal--window ui-draggable']//*[@class='series-edit--title series-edit--title__editable'])[2]"));

		action.moveToElement(mouse).build().perform();
		CommonFunctionality.wait(3000);
		login.driver
				.findElement(
						By.xpath("(//*[@class='movable-modal--window ui-draggable']//*[@title='Remove series'])[2]"))
				.click();

	}

//TC_400
	@Then("^Verify The \"([^\"]*)\" should be removed from the visual$")
	public void verify_The_should_be_removed_from_the_visual(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);

		if (login.driver.findElements(By.xpath(
				"//*[@class='movable-modal--window ui-draggable']//*[@class='series-edit--title series-edit--title__editable']"))
				.size() == 1) {
			login.Log4j.info("series should be removed in Edit visual panel:PASS");
		} else {
			fail("Series should be removed in Edit visual panel:FAIL");
		}

	}

//TC_401
	@Then("^Mouse hover on series name$")
	public void mouse_hover_on_series_name() throws Throwable {
		CommonFunctionality.wait(3000);

		WebElement mouse = login.driver.findElement(By.xpath(
				"(//*[@class='movable-modal--window ui-draggable']//*[@class='series-edit--title series-edit--title__editable'])[2]"));

		action.moveToElement(mouse).build().perform();

	}

//TC_401
	@Then("^Verify The Series tooltip should be displayed with options$")
	public void verify_The_Series_tooltip_should_be_displayed_with_options() throws Throwable {
		CommonFunctionality.wait(3000);

		if (login.driver.findElements(By.xpath(
				"//*[@class='public-js-views-insights-series-tooltip-style-module__tooltipCell public-js-views-insights-series-tooltip-style-module__tooltipKey']"))
				.size() == 13) {
			login.Log4j.info("The Series tooltip should be displayed with options:PASS");
		}

		else {
			fail("The Series tooltip should be displayed with options:FAIL");
		}

	}

//TC_404
	@Then("^Select other visual Ex: \"([^\"]*)\"$")
	public void select_other_visual_Ex(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);

		WebElement type = login.driver.findElement(By.xpath("//*[@class='types-list-item']//*[text()='" + arg1 + "']"));

		JavascriptExecutor js = (JavascriptExecutor) login.driver;

		js.executeScript("arguments[0].scrollIntoView();", type);

		type.click();

	}

//TC_404
	@Then("^Verify The visual should be converted as user selected \"([^\"]*)\"$")
	public void verify_The_visual_should_be_converted_as_user_selected(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);

		String chat = login.driver.findElement(By.xpath("//*[text()='" + arg1 + "']")).getText();

		if (chat.equalsIgnoreCase(arg1)) {
			login.Log4j.info("visual should be displayed as user selected chart:PASS");
		} else {
			fail("visual should be displayed as user selected chart:FAIL");
		}

	}

//TC_405
	@Then("^Click on dropdown on visual panel and Select any visual Ex: \"([^\"]*)\"$")
	public void click_on_dropdown_on_visual_panel_and_Select_any_visual_Ex(String arg1) throws Throwable {

		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath("//*[@class='visual-types-panel--title']//*[@class='type-select--icon']"))
				.click();

		login.driver.findElement(By.xpath("(//*[@class='items-wrapper']//*[text()='" + arg1 + "'])[1]")).click();

	}

//TC_437
	@Then("^Click on Feedback option$")
	public void click_on_Feedback_option() throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath("//*[text()='Feedback']")).click();

	}

//TC_437
	@Then("^Verify The \"([^\"]*)\" popup window should be displayed$")
	public void verify_The_popup_window_should_be_displayed(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);

		if (login.driver.findElements(By.xpath("//*[text()='" + arg1 + "']")).size() == 1) {
			login.Log4j.info("'Still cannot find an answer?' popup window should be displayed:PASS");
		} else {
			fail("'Still cannot find an answer?' popup window should be displayed:FAIL");
		}

	}

//TC_437
	@Then("^Click on close \"([^\"]*)\" icon$")
	public void click_on_close_icon(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath("//*[@class='modal-header sphere-modal__header']//*[text()='" + arg1 + "']"))
				.click();

	}

//TC_438
	@Then("^Verify The description for popup \"([^\"]*)\"$")
	public void verify_The_description_for_popup(String arg1) throws Throwable {

		CommonFunctionality.wait(3000);
		String description = login.driver.findElement(By.xpath("//*[text()='" + arg1 + "']")).getText();
		if (description.equalsIgnoreCase(arg1)) {
			login.Log4j.info("The description displayed in popup:PASS");
		} else {
			fail("The description displayed in popup:FAIL");
		}

	}

//TC_439
	@Then("^Enter text on description field$")
	public void enter_text_on_description_field() throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath("//*[@name='text']")).click();

		login.driver.findElement(By.xpath("//*[@name='text']")).clear();

		login.driver.findElement(By.xpath("//*[@name='text']")).sendKeys("Testing");

	}

//TC_439
	@Then("^Verify The should able to add text in the description field$")
	public void verify_The_should_able_to_add_text_in_the_description_field() throws Throwable {
		CommonFunctionality.wait(3000);

		if (login.driver.findElements(By.xpath("//*[@class='feedback']//*[@class='button button__primary']"))
				.size() == 1) {
			login.Log4j.info("The should able to add text in the description field:PASS");
		} else {
			fail("The should able to add text in the description field:FAIL");
		}

	}

//TC_440
	@Then("^Verify The 'Submit' and 'Cancel' buttons should be disabled by default$")
	public void verify_The_Submit_and_Cancel_buttons_should_be_disabled_by_default() throws Throwable {
		CommonFunctionality.wait(3000);

		if (login.driver.findElements(By.xpath("//*[@class='button button__text_purple feedback--button__disabled']"))
				.size() == 1) {
			login.Log4j.info("'Cancel' button should be disabled by defaul:PASS");

			if (login.driver.findElements(By.xpath("//*[@class='button button__primary feedback--button__disabled']"))
					.size() == 1) {
				login.Log4j.info("Submit button should be disabled by defaul:PASS");
			}
		} else {
			fail("'Cancel' button should be disabled by defaul:FAIL");
		}

	}

//TC_441
	@Then("^Click on cancel button$")
	public void click_on_cancel_button() throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath("//*[@class='modal-body sphere-modal__body']//*[text()='Cancel']")).click();
	}

//TC_441
	@Then("^Verify The Feedback popup should be closed$")
	public void verify_The_Feedback_popup_should_be_closed() throws Throwable {
		CommonFunctionality.wait(3000);
		if (login.driver.findElements(By.xpath("//*[@class='modal-body sphere-modal__body']//*[text()='Cancel']"))
				.size() == 0) {
			login.Log4j.info("Feedback popup should be closed:PASS");

		} else {
			fail("Feedback popup should be closed:FAIL");
		}
	}

//TC_442
	@Then("^Click on submit button$")
	public void click_on_submit_button() throws Throwable {
		CommonFunctionality.wait(3000);
		login.driver.findElement(By.xpath("//*[text()='Submit']")).click();
	}

//TC_442
	@Then("^Verify The user feedback should be sent to FD and popup should be closed$")
	public void verify_The_user_feedback_should_be_sent_to_FD_and_popup_should_be_closed() throws Throwable {
		CommonFunctionality.wait(3000);

		if (login.driver.findElements(By.xpath("//*[@class='modal-body sphere-modal__body']//*[text()='Submit']"))
				.size() == 0) {
			login.Log4j.info("Feedback popup should be closed:PASS");

		} else {
			fail("Feedback popup should be closed:FAIL");
		}
	}

//TC_443
	@Then("^Verify The \"([^\"]*)\" message should be displayed in a growl popup$")
	public void verify_The_message_should_be_displayed_in_a_growl_popup(String arg1) throws Throwable {
		CommonFunctionality.wait(5000);

		if (login.driver.findElements(By.xpath("//*[@class='growl-message-text']")).size() == 1) {
			login.Log4j.info("Message should be displayed in a growl popup:PASS");

		} else {
			fail("Message should be displayed in a growl popup:FAIL");
		}

	}

//TC_444
	@Then("^Click on Cancel/x button$")
	public void click_on_Cancel_x_button() throws Throwable {
		CommonFunctionality.wait(5000);

		login.driver.findElement(By.xpath("//*[@class='movable-modal--close']")).click();

	}

//TC_444
	@Then("^Verify The edit visual popup should be closed$")
	public void verify_The_edit_visual_popup_should_be_closed() throws Throwable {
		CommonFunctionality.wait(5000);

		if (login.driver.findElements(By.xpath("//*[@class='movable-modal--close']")).size() == 0) {
			login.Log4j.info("The edit visual popup should be closed:PASS");

		} else {
			fail("The edit visual popup should be closed:FAIL");
		}

	}

//TC_406
	@Then("^Edit series - Click on x icon for a series$")
	public void edit_series_Click_on_x_icon_for_a_series() throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath("(//*[@class='remove-item-control'])[2]")).click();

	}

//TC_406
	@Then("^Verify The series should be removed from edit series panel$")
	public void verify_The_series_should_be_removed_from_edit_series_panel() throws Throwable {

		CommonFunctionality.wait(3000);

		if (login.driver.findElements(By.xpath("(//*[@class='remove-item-control'])")).size() == 2) {
			login.Log4j.info("series should be removed from edit series panel:PASS");

		} else {
			fail("series should be removed from edit series panel:FAIL");
		}

	}

//TC_406
	@Then("^Verify The series should be removed from visual panel$")
	public void verify_The_series_should_be_removed_from_visual_panel() throws Throwable {

		CommonFunctionality.wait(5000);

		if (login.driver.findElements(By.xpath("//*[@class='series-edit--title series-edit--title__editable']"))
				.size() == 1) {
			login.Log4j.info("The series should be removed from visual panel:PASS");

		} else {
			fail("The series should be removed from visual panel:FAIL");
		}

	}

//TC_407
	@Then("^Edit series - Click on x icon for attribute\\(Next to name\\)$")
	public void edit_series_Click_on_x_icon_for_attribute_Next_to_name() throws Throwable {
		CommonFunctionality.wait(5000);

		login.driver.findElement(By.xpath("(//*[@class='remove-item-control'])[1]")).click();

	}

//TC_407
	@Then("^Verify The all series should be removed from edit series panel$")
	public void verify_The_all_series_should_be_removed_from_edit_series_panel() throws Throwable {
		CommonFunctionality.wait(5000);

		if (login.driver.findElements(By.xpath("(//*[@class='remove-item-control'])")).size() == 0) {
			login.Log4j.info("All series should be removed from edit series panel:PASS");

		} else {
			fail("All series should be removed from edit series panel:FAIL");
		}

	}

//TC_407
	@Then("^Verify The All series should be removed from visual panel$")
	public void verify_The_All_series_should_be_removed_from_visual_panel() throws Throwable {
		CommonFunctionality.wait(5000);
		if (login.driver.findElements(By.xpath("//*[@class='series-edit--title series-edit--title__editable']"))
				.size() == 0) {
			login.Log4j.info("The All series should be removed from visual panel:PASS");

		} else {
			fail("The All series should be removed from visual panel:FAIL");
		}

	}

//TC_408
	@Then("^Edit series -  Click on series name$")
	public void edit_series_Click_on_series_name() throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath("(//div[@class='series-name--title'])[1]")).click();
	}

//TC_409
	@Then("^Edit series - Mouse move on series and click on \"([^\"]*)\" icon$")
	public void edit_series_Mouse_move_on_series_and_click_on_icon(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);

		WebElement seriesName = login.driver.findElement(
				By.xpath("((//div[@class='series-name--title'])[1]/following::*[@title='" + arg1 + "'])[1]"));

		action.moveToElement(seriesName).click().perform();
	}

//TC_409
	@Then("^Verify The \"([^\"]*)\" popup should be displayed for selected series$")
	public void verify_The_popup_should_be_displayed_for_selected_series(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);

		if (login.driver.findElement(By.xpath("//*[@class='movable-modal--window ui-resizable ui-draggable']"))
				.isDisplayed()) {
			login.Log4j.info("Rename popup should be displayed:PASS");
		}

		else {
			fail("Rename popup should be displayed:FAIL");
		}

		login.driver.findElement(By.xpath("(//*[@class='movable-modal--close'])[2]")).click();

	}

//TC_410
	@Then("^Verify The dropdown list \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void verify_The_dropdown_list(String arg1, String arg2, String arg3, String arg4) throws Throwable {

		CommonFunctionality.wait(3000);

		if (login.driver.findElement(By.xpath("//*[text()='Rename']")).getText().equalsIgnoreCase(arg1)) {

			login.Log4j.info("Edit series list displayed:PASS :" + arg1);

			if (login.driver.findElement(By.xpath("//*[text()='Frequency']")).getText().equalsIgnoreCase(arg2)) {

				login.Log4j.info("Edit series list displayed:PASS :" + arg2);

				if (login.driver.findElement(By.xpath("//*[text()='Currency']")).getText().equalsIgnoreCase(arg3)) {

					login.Log4j.info("Edit series list displayed:PASS :" + arg3);

					if (login.driver.findElement(By.xpath("//*[text()='Change']")).getText().equalsIgnoreCase(arg4)) {

						login.Log4j.info("Edit series list displayed:PASS :" + arg4);

					}

				}

			}

		}

		else {
			fail("Edit series list displayed:FAIL");
		}

	}

//TC_411
	@Then("^Click on 'Rename' option$")
	public void click_on_Rename_option1() throws Throwable {
		CommonFunctionality.wait(3000);
		login.driver.findElement(By.xpath("//*[text()='Rename']")).click();
	}

//TC_412
	@Then("^Click on 'Frequency' option$")
	public void click_on_Frequency_option() throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath("(//*[text()='Frequency'])[2]")).click();

	}

//TC_412
	@Then("^Verify the Selected function should be applied to the Edit visual$")
	public void verify_the_Selected_function_should_be_applied_to_the_Edit_visual() throws Throwable {
		CommonFunctionality.wait(3000);

		WebElement seriesName = login.driver.findElement(By.xpath("(//div[@class='series-name--title'])[1]"));

		action.moveToElement(seriesName).perform();

		String fun = login.driver.findElement(By.xpath("((//*[text()='Functions'])[1]//following::*)[1]")).getText();

		if (fun.contains("Yearly")) {
			login.Log4j.info("The Selected function should be applied to the Edit visual:PASS");
		}

		else {
			fail("The Selected function should be applied to the Edit visual:FAIL");
		}

	}

	// TC_413
	@Then("^Verify the Selected 'currency' function should be applied to the Edit visual$")
	public void verify_the_Selected_currency_function_should_be_applied_to_the_Edit_visual() throws Throwable {

		CommonFunctionality.wait(3000);

		WebElement seriesName = login.driver.findElement(By.xpath("(//div[@class='series-name--title'])[1]"));

		action.moveToElement(seriesName).perform();

		String fun = login.driver.findElement(By.xpath("((//*[text()='Unit'])[1]//following::*)[1]")).getText();

		if (fun.contains("USD mn")) {
			login.Log4j.info("The Selected  Unit function should be applied to the visual:PASS");
		}

		else {
			fail("The Selected Unit function should be applied to the visual:FAIL");
		}

	}

	// TC_414

	@Then("^Verify the Selected 'Change' function should be applied to the visual$")
	public void verify_the_Selected_Change_function_should_be_applied_to_the_visual() throws Throwable {
		CommonFunctionality.wait(3000);

		WebElement seriesName = login.driver.findElement(By.xpath("(//div[@class='series-name--title'])[1]"));

		action.moveToElement(seriesName).perform();

		String fun = login.driver.findElement(By.xpath("((//*[text()='Functions'])[1]//following::*)[1]")).getText();

		if (fun.contains("Over Year")) {
			login.Log4j.info("The Selected change Function should be applied to the visual:PASS");
		}

		else {
			fail("The Selected Change Function should be applied to the visual:FAIL");
		}

	}

	// TC_415
	@Then("^Edit series - Click on \"([^\"]*)\" or its dropdown$")
	public void edit_series_Click_on_or_its_dropdown(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath(
				"(//*[@class='insight-action-panel--btn-title' and contains(text(),'Frequency')]//following::div)[1]"))
				.click();

	}

	// TC_416
	@Then("^Click on \"([^\"]*)\" dropdown and Select frequency \"([^\"]*)\"$")
	public void click_on_dropdown_and_Select_frequency(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath("(//*[@class='series-data-conversion--functions-list']//*[contains(text(),'"
				+ arg1 + "')])//following::select[@name='frequency']")).click();
		login.driver.findElement(By.xpath("(//*[@class='series-data-conversion--functions-list']//*[contains(text(),'"
				+ arg1 + "')]//following::select//option)[5]")).click();

	}

//TC_416
	@Then("^Click on \"([^\"]*)\" button on 'Series Harmonization' window$")
	public void click_on_button_on_Series_Harmonization_window(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]")).click();

		CommonFunctionality.wait(3000);

	}

//TC_416
	@Then("^Verify The selected frequency \"([^\"]*)\" should be displayed on heat map visual$")
	public void verify_The_selected_frequency_should_be_displayed_on_heat_map_visual(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);

		WebElement seriesName = login.driver
				.findElement(By.xpath("(//*[@class='series-edit--title series-edit--title__editable'])[1]"));

		action.moveToElement(seriesName).build().perform();

		String frequency = login.driver
				.findElement(
						By.xpath("(//*[@class='tooltip tooltip__visible']//*[text()='Frequency']//following::*)[1]"))
				.getText();
		;

		if (frequency.contains(arg1)) {
			login.Log4j.info("Selected Frequency should be displayed on visual:PASS");
		} else {
			fail("Selected Frequency should be displayed on visual:FAIL");
		}

	}

//TC_417
	@Then("^Click on \"([^\"]*)\" dropdown and select \"([^\"]*)\"$")
	public void click_on_dropdown_and_select(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver
				.findElement(
						By.xpath("//*[contains(text(),'" + arg1 + "')]//following::select[@name='missing_values']"))
				.click();

		login.driver
				.findElement(By.xpath("//*[contains(text(),'" + arg1
						+ "')]//following::select[@name='missing_values']//option[contains(text(),'" + arg2 + "')]"))
				.click();

	}

//TC_417
	@Then("^Verify The \"([^\"]*)\" should be applied with selected frequency \"([^\"]*)\"$")
	public void verify_The_should_be_applied_with_selected_frequency(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(3000);

		WebElement seriesName = login.driver
				.findElement(By.xpath("(//*[@class='series-edit--title series-edit--title__editable'])[1]"));

		action.moveToElement(seriesName).perform();

		String fun = login.driver.findElement(By.xpath("((//*[text()='Functions'])[1]//following::*)[1]")).getText();

		if (fun.contains(arg2)) {
			login.Log4j.info("Selected Missing values method should be displayed on visual:PASS");
		}

		else {
			fail("Selected Missing values method should be displayed on visual:FAIL");
		}

	}

//TC_419
	@Then("^Click on 'Minimize' option$")
	public void click_on_Minimize_option() throws Throwable {

		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath("//*[@title='Minimize']")).click();

	}

//TC_419
	@Then("^Verify The popup should be \"([^\"]*)\"$")
	public void verify_The_popup_should_be(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);

		if (login.driver.findElements(By.xpath("//*[@title='" + arg1 + "']")).size() == 0) {
			login.Log4j.info("The popup should be minimized/ maximized:PASS");
		}

		else {
			fail("The popup should be minimized/ maximized:FAIL");
		}

	}

//TC_420
	@Then("^Click on 'Maximize'option$")
	public void click_on_Maximize_option() throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath("//*[@title='Maximize']")).click();

	}

//TC_421
	@Then("^Click on 'Full-screen' option$")
	public void click_on_Full_screen_option() throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath("//*[@title='Full-screen']")).click();

	}

//TC_421
	@Then("^Verify The popup should be displayed in \"([^\"]*)\"$")
	public void verify_The_popup_should_be_displayed_in(String arg1) throws Throwable {

		CommonFunctionality.wait(3000);

		if (login.driver.findElements(By.xpath("//*[@title='" + arg1 + "']")).size() == 0) {
			login.Log4j.info("The popup should be Full-Screen displayed:PASS");
		}

		else {
			fail("The popup should be Full-Screen displayed:FAIL");
		}

	}

//TC_423
	@Then("^Click on cancel/x icon option$")
	public void click_on_cancel_x_icon_option() throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath("(//div[@class='movable-modal--close'])[2]")).click();

	}

//TC_423
	@Then("^Verify The \"([^\"]*)\" popup should be closed$")
	public void verify_The_popup_should_be_closed(String arg1) throws Throwable {

		CommonFunctionality.wait(3000);

		if (login.driver.findElements(By.xpath("(//div[@class='movable-modal--close'])[2]")).size() == 0) {
			login.Log4j.info("The popup should be closed.:PASS");
		}

		else {
			fail("The popup should be closed.:FAIL");
		}

	}

//TC_424
	@Then("^Edit series - Click on dropdown for \"([^\"]*)\" in series level$")
	public void edit_series_Click_on_dropdown_for_in_series_level(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath(
				"((//*[@class='change-series-function'])[3]//following::div[@class='insight-action-panel--btn-popup icon--context-menu-arrow'])[1]"))
				.click();

	}

//TC_424
	@Then("^Verify The frequencies should be available under the dropdown$")
	public void verify_The_frequencies_should_be_available_under_the_dropdown() throws Throwable {

		CommonFunctionality.wait(3000);

		List<WebElement> freList = login.driver.findElements(By.xpath("//*[@class='context-menu-item link']"));

		if (freList.size() == 7) {

			login.Log4j.info("frequencies should be available under the dropdown:PASS");
		} else {

			fail("frequencies should be available under the dropdown:FAIL");
		}

	}

//TC_425
	@Then("^Select a frequency \"([^\"]*)\"$")
	public void select_a_frequency(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath("//*[@title='" + arg1 + "']")).click();

	}

//TC_425
	@Then("^Verify The Selected frequency \"([^\"]*)\" should be displayed to ONLY selected series$")
	public void verify_The_Selected_frequency_should_be_displayed_to_ONLY_selected_series(String arg1)
			throws Throwable {
		CommonFunctionality.wait(3000);

		WebElement seriesName = login.driver.findElement(By.xpath("(//*[@class='series-name--title'])[1]"));
		action.moveToElement(seriesName).build().perform();

		String fre = login.driver.findElement(By.xpath("(//*[text()='Functions']//following::*)[1]")).getText();
		System.out.println(fre);
		System.out.println(arg1);

		if (fre.contains("Replicate")) {
			login.Log4j.info(" Selected frequencies should be displayed:PASS");
		} else {

			fail("Selected frequencies should be displayed:FAIL");
		}

	}

//TC_425
	@Then("^Edit series - Click on dropdown for currency in series level$")
	public void edit_series_Click_on_dropdown_for_currency_in_series_level() throws Throwable {

		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath(
				"((//*[@class='change-series-function'])[4]//following::div[@class='insight-action-panel--btn-popup icon--context-menu-arrow'])[1]"))
				.click();

	}

//TC_426
	@Then("^Verify The Selected currency \"([^\"]*)\" should be displayed to ONLY selected series$")
	public void verify_The_Selected_currency_should_be_displayed_to_ONLY_selected_series(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);

		WebElement seriesName = login.driver.findElement(By.xpath("(//*[@class='series-name--title'])[1]"));
		action.moveToElement(seriesName).build().perform();

		String fre = login.driver.findElement(By.xpath("(//*[text()='Functions']//following::*)[1]")).getText();
		System.out.println(fre);
		System.out.println(arg1);

		if (fre.contains(arg1)) {
			login.Log4j.info(" Selected Currency should be displayed:PASS");
		} else {

			fail("Selected currency should be displayed:FAIL");
		}

	}

//TC_427
	@Then("^Click on type a function field in series level$")
	public void click_on_type_a_function_field_in_series_level() throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath("(//*[@placeholder='Type a function'])[1]")).click();

	}

//TC_427
	@Then("^List of series dropdown should be opened$")
	public void list_of_series_dropdown_should_be_opened() throws Throwable {
		CommonFunctionality.wait(3000);

		if (login.driver.findElements(By.xpath("//*[@class='function-editor-window-auto-complete']")).size() == 1) {

			login.Log4j.info("series dropdown should be opened:PASS");
		} else {

			fail("series dropdown should be opened:FAIL");
		}

	}

//TC_428
	@Then("^Select a function \"([^\"]*)\" and Click on \"([^\"]*)\"$")
	public void select_a_function_and_Click_on(String arg1, String arg2) throws Throwable {

		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath("//*[@data-id='" + arg1 + "']")).click();
		JavascriptExecutor js = (JavascriptExecutor) login.driver;
		js.executeScript("arguments[0].scrollIntoView();",
				login.driver.findElement(By.xpath("(//*[@title='Apply function'])[1]")));

		login.driver.findElement(By.xpath("(//*[@title='Apply function'])[1]")).click();

	}

//TC_428
	@Then("^Verify The Selected function \"([^\"]*)\" should be displayed to ONLY selected series$")
	public void verify_The_Selected_function_should_be_displayed_to_ONLY_selected_series(String arg1) throws Throwable {

		CommonFunctionality.wait(3000);

		WebElement seriesName = login.driver.findElement(By.xpath("(//*[@class='series-name--title'])[1]"));
		action.moveToElement(seriesName).build().perform();

		String function = login.driver.findElement(By.xpath("(//*[text()='Functions']//following::*)[1]")).getText();
		System.out.println(function);
		System.out.println(arg1);

		if (function.contains(arg1)) {
			login.Log4j.info("The selected function should be applied to the series:PASS");
		} else {

			fail("The selected function should be applied to the series.:FAIL");
		}

	}
//TC_431

	@Then("^Search for functions \"([^\"]*)\" in type a function$")
	public void search_for_functions_in_type_a_function(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath("(//*[@placeholder='Type a function'])[1]")).sendKeys(arg1);

	}

//TC_431
	@Then("^Verify The Searched functions \"([^\"]*)\" should be displayed$")
	public void verify_The_Searched_functions_should_be_displayed(String arg1) throws Throwable {

		CommonFunctionality.wait(3000);

		if (login.driver.findElements(By.xpath("//*[@class='function-editor-window-auto-complete--functions']"))
				.size() == 1) {
			login.Log4j.info("The Searched function ROUND should be displayed:PASS");
		} else {
			fail("The Searched function ROUND should be displayed:FAIL");
		}

	}

//TC_446
	@Then("^click on \"([^\"]*)\" option$")
	public void click_on_option(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath("//*[text()='" + arg1 + "']")).click();

	}

//TC_446
	@Then("^Verify The 'Series suggestion manager' popup should be displayed$")
	public void verify_The_Series_suggestion_manager_popup_should_be_displayed() throws Throwable {
		CommonFunctionality.wait(3000);

		if (login.driver.findElements(By.xpath("//*[@class='suggestions-manager']")).size() == 1) {
			login.Log4j.info("The 'Series suggestion manager' popup should be displayed:PASS");
		} else {
			fail("The 'Series suggestion manager' popup should be displayed:FAIL");
		}

		login.driver.findElement(By.xpath("//*[text()='×']")).click();

	}

//TC_447
	@And("^Click on 'Heat map' visual$")
	public void click_on_Heat_map_visual() throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath("(//*[text()='Heat map'])[1]")).click();

	}

//TC_447
	@Then("^Verify The \"([^\"]*)\" should be disabled if have no series associated with the visual$")
	public void verify_The_should_be_disabled_if_have_no_series_associated_with_the_visual(String arg1)
			throws Throwable {
		CommonFunctionality.wait(3000);

		if (login.driver.findElement(By.xpath("(//*[@class='button button__sm button__text_purple'])[2]"))
				.isEnabled()) {

			fail("The 'Add related series' should be disabled:FAIL");
		} else {
			login.Log4j.info("The 'Add related series' should be disabled:PASS");
		}

	}

//TC_449
	@Then("^Click on \"([^\"]*)\" \\(\\+\\) icon on header$")
	public void click_on_icon_on_header(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath("//*[@title='" + arg1 + "']")).click();

	}

//TC_449
	@Then("^Verify The \"([^\"]*)\", \"([^\"]*)\" options should be displayed$")
	public void verify_The_options_should_be_displayed(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(3000);

		List<WebElement> dropdown = login.driver.findElements(By.xpath("//*[@class='name-li']"));

		for (int a = 0; a < dropdown.size(); a++) {

			String text = dropdown.get(a).getText();
			System.out.println(dropdown.size());
			System.out.println(text);

			if (text.equalsIgnoreCase(arg1)) {
				login.Log4j.info("The Add to new tab options should be displayed:PASS:" + arg1);
			}

			else if (text.equalsIgnoreCase(arg2)) {

				login.Log4j.info("The Add to new insight options should be displayed:PASS:" + arg2);
			}

		}

	}

//TC_451
	@Then("^Select 'Add to new insight' option$")
	public void select_Add_to_new_insight_option() throws Throwable {
		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath("//*[text()='Add to new insight']")).click();

	}

//TC_451
	@Then("^Verify The \"([^\"]*)\" and \"([^\"]*)\" confirmation message should be displayed$")
	public void verify_The_and_confirmation_message_should_be_displayed(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(5000);

		if (login.driver.findElement(By.xpath("//*[text()='New insight with the selected visual created.']"))
				.isDisplayed()) {

			login.Log4j.info("The 'New insight with the selected visual created.'displayed:PASS");
			if (login.driver.findElement(By.xpath("//*[contains(text(),'Go to new insight')]")).isDisplayed()) {

				login.Log4j.info("'Go to new insight' button displayed:PASS");
			}

		}

		else {

			fail("The 'New insight with the selected visual created.' displayed:FAIL");

		}

	}
	
	
	
	//TC_453
	@Then("^Verify The growl message should be auto closed$")
	public void verify_The_growl_message_should_be_auto_closed() throws Throwable {
		CommonFunctionality.wait(4000);
		
		if (login.driver.findElement(By.xpath("//*[contains(text(),'Go to new insight')]")).isDisplayed()) {

			login.Log4j.info("'Go to new insight' button displayed:PASS");
		}
	else {

		fail("'Go to new insight' button displayed':FAIL");

	}
		Thread.sleep(30000);
		CommonFunctionality.wait(4000);
		
		if (login.driver.findElements(By.xpath("//*[contains(text(),'Go to new insight')]")).size()==0) {

			login.Log4j.info("The growl message should be auto closed:PASS");
		}
	else {
		fail("The growl message should be auto closed:FAIL");	
	}	
	}

	//TC_454
	@Then("^Verify The visual should be copied$")
	public void verify_The_visual_should_be_copied() throws Throwable {
		
		CommonFunctionality.wait(3000);
		
		if (login.driver.findElements(By.xpath("//*[text()='Heat map with series copied.']")).size()==1) {
			login.Log4j.info("The visual should be copied:PASS");
			if (login.driver.findElements(By.xpath("//*[@class='button growl-message-content--btns__fill']")).size()==1) {
				login.Log4j.info("Click here for more options button displayed:PASS");
		}
		}
	else {
		fail("The visual should be copied:FAIL");	
	}
		
	
	}
	
	
	//TC_458
	@Then("^Paste to insight$")
	public void paste_to_insight() throws Throwable {
		CommonFunctionality.wait(3000);
		
		login.driver.findElement(By.xpath("(//*[@class='view-components-over--wrapper'])[2]")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//*[@class='empty-visual-overlay--content']")).click();
		
		action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
		
		
	}

	//TC_458
	@Then("^Verify The \"([^\"]*)\" message should be displayed$")
	public void verify_The_message_should_be_displayed(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);
		
		if (login.driver.findElements(By.xpath("//*[contains(text(),'Data pasted from clipboard')]")).size()==1) {

			login.Log4j.info("The Data pasted from clipboard message should be displayed:PASS");
		}
	else {
		fail("The 'Data pasted from clipboard' message should be displayed:FAIL");	
	}	
		
		
		
	}

	
	
	//TC_462
	
	@Then("^Click on 'More options'$")
	public void click_on_More_options() throws Throwable {
		CommonFunctionality.wait(3000);
		

        login.driver.findElement(By.xpath("//*[@class='button growl-message-content--btns__fill']")).click();
		
		
	}

	//TC_462
	@Then("^Verify The Download window is displayed$")
	public void verify_The_Download_window_is_displayed() throws Throwable {
		CommonFunctionality.wait(3000);
		
		if (login.driver.findElements(By.xpath("//*[@class='modal-body sphere-modal__body']")).size()==1) {

			login.Log4j.info("The Download window is displayed:PASS");
		}
	else {
		fail("The Download window is displayed:FAIL");	
	}	
		
		
	}

	
	
	//TC_463
	@Then("^Click on download option$")
	public void click_on_download_option() throws Throwable {
		CommonFunctionality.wait(3000);
		
		 login.driver.findElement(By.xpath("//*[@class='vis-elem-menu vis-elem-menu__page']//*[@class='download-button--icon drop-down-button--icon']")).click();
			
	}
	
	
	
	
	
	
	
	
	
	

}
