package CDMNext.StepDefinations;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;
import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.*;
import test.ant.AntSystemPropertySet;

public class SprintCases_4_5 {
	/*public String NotificationText;
	JavascriptExecutor js = (JavascriptExecutor) login.driver;
	Actions action = new Actions(login.driver);
	WebDriverWait wait = new WebDriverWait(login.driver, 30);
	public String firstObsdate;
	public String lastobsdate;
	public String LastUpdateTime;
	public String seriesids;
	public String indicatorname;
	public String windowsversion;
	public String Title;
	public static String format;
	public String a;

	
	// TC_18788_01
	
	// TC_16831_01
	@Given("^click on frequency dropdown$")
	public void click_on_frequency_dropdown() throws Throwable {
		Thread.sleep(1000);

		login.driver.findElement(By.xpath("//span[contains(text(),'Frequency')]")).click();

		Thread.sleep(1000);
	}

	// TC_16831_01
	@Then("^check the frequency order as \"([^\"]*)\"$")
	public void check_the_frequency_order_as(String arg1) throws Throwable {
		Thread.sleep(3000);

		List<String> sname = new ArrayList<>();

		for (int i = 2; i <= 9; i++) {

			String frequencyOrder = login.driver.findElement(By.xpath("(//span[@class='text-dots'])[" + i + "]"))
					.getText();
			System.out.println("frequencyOrder:" + frequencyOrder);
			sname.add(frequencyOrder);
			System.out.println("static values:" + arg1);
		}

		String ordername[] = arg1.split(",");

		int count = ordername.length;
		System.out.println(count);
		System.out.println(sname.size());

		int countvalue = 0;

		for (String dropdown : ordername) {
			if (sname.contains(dropdown)) {
				countvalue++;
			}

		}
	}

	// TC_18782_01
	
	

	

	// TC_18868_01
	@Then("^color of the icon should take the color of the labels in the header$")
	public void color_of_the_icon_should_take_the_color_of_the_labels_in_the_header() throws Throwable {
		Thread.sleep(1000);

		String lableColor = login.driver.findElement(By.xpath("(//*[@class='zoom-button--text'])[2]"))
				.getCssValue("background-color");
		System.out.println(lableColor);

	}

	// TC_14534_01
	@Given("^Add this series into my series \"([^\"]*)\"$")
	public void add_this_series_into_my_series(String arg1) throws Throwable {
		Thread.sleep(5000);

		try {
			// click on series tab
			login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
			Thread.sleep(2000);
			// Enter series id in search bar
			login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(arg1);

			login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(Keys.ENTER);

			Thread.sleep(1000);
			// click on +icon
			login.driver.findElement(By.xpath("//*[@class='add-to-data-selection--icon']")).click();
			System.out.println("Exit from try block");
		}

		catch (org.openqa.selenium.StaleElementReferenceException ex) {
			System.out.println("Enter into catch block");
			// click on series tab
			login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();

			// Enter series id in search bar
			login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(arg1);

			login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(Keys.ENTER);

			// click on +icon
			login.driver.findElement(By.xpath("//*[@class='add-to-data-selection--icon']")).click();
		}

	}

	// TC_14534_01
	@Given("^click on series name and SSP popup open$")
	public void click_on_series_name_and_SSP_popup_open() throws Throwable {
		Thread.sleep(1000);

		WebElement we = login.driver.findElement(By.xpath("//span[contains(text(),'GDP: SNA 1993: 2000p')]"));
		action.moveToElement(we).pause(500).build().perform();

		login.driver.findElement(By.xpath("//span[contains(text(),'GDP: SNA 1993: 2000p')]")).click();

		if (login.driver.findElements(By.xpath("//div[contains(text(),'13132401')]")).size() == 1) {

			System.out.println("SSP popup Should be open");
		}

		else {
			Assert.fail();
		}
	}

	// TC_14534_01
	@Given("^click on Manage button$")
	public void click_on_Manage_button() throws Throwable {

		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Manage')]")).click();
	}

	// TC_14534_01
	@Then("^The Popup should be open$")
	public void the_Popup_should_be_open() throws Throwable {

		Thread.sleep(1000);

		if (login.driver.findElements(By.xpath("//span[contains(text(),'Manage')]")).size() == 1) {
			System.out.println("Add Related series popup should be display");
		}

		else {
			Assert.fail();
		}
		System.out.println("======================>32");

	}

	// TC_19208_01
	@Given("^Click on indicator tab$")
	public void click_on_indicator_tab() throws Throwable {

		Thread.sleep(1000);

		login.driver.findElement(By.xpath("//*[contains(text(),'Indicator')]")).click();

	}

	// TC_19208_01
	@Then("^Top indicators should be displayed in a panel$")
	public void top_indicators_should_be_displayed_in_a_panel() throws Throwable {

		Thread.sleep(2000);

		if (login.driver.findElements(By.xpath("//div[contains(text(),'Popular')]")).size() == 1) {

			System.out.println("Top indicators should be displayed in a panel");
		} else {
			Assert.fail();
		}

	}

	// TC_19208_02
	@Then("^'top indicators' selected by default and First category should always selected$")
	public void top_indicators_selected_by_default_and_First_category_should_always_selected() throws Throwable {

		Thread.sleep(1000);

		if (login.driver.findElements(By.xpath("//div[contains(text(),'Popular')]")).size() == 1) {

			System.out.println("Top indicators' selected by default and First category should always selected");
		} else {
			Assert.fail();
		}
	}

	// TC_18480_01
	
	// TC_18207_01
	@Given("^click on Datasets tab$")
	public void click_on_Datasets_tab() throws Throwable {
		Thread.sleep(1000);

		login.driver.findElement(By.xpath("//span[contains(text(),'Datasets')]")).click();

	}

	// TC_18207_01
	@Given("^click on more button$")
	public void click_on_more_button() throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//span[contains(text(),'More')]")).click();
		Thread.sleep(3000);

	}

	// TC_18207_01
	@Given("^checked \"([^\"]*)\" and click on Apply filter button$")
	public void checked_and_click_on_Apply_filter_button(String arg1) throws Throwable {
		Thread.sleep(2000);

		WebElement statusicon = login.driver.findElement(By.xpath("//*[@title='With suggestions for rebased/discontinued series']"));
		js.executeScript("arguments[0].scrollIntoView(true);", statusicon);
		login.driver.findElement(By.xpath("//*[@title='With suggestions for rebased/discontinued series']")).click();

		// click on apply filter
		login.driver.findElement(By.xpath("//div[contains(text(),'Apply filter')]")).click();

	}

	// TC_18207_01
	@Given("^Scroll down datasets list$")
	public void scroll_down_datasets_list() throws Throwable {

	}

	// TC_18207_01
	@Given("^Click \"([^\"]*)\" on the bottom of list$")
	public void click_on_the_bottom_of_list(String arg1) throws Throwable {

		Thread.sleep(2000);

		WebElement Loadmore = login.driver.findElement(
				By.xpath("//*[@class='button button__sm button__text_purple button__block nodes-list--more-button']"));
		js.executeScript("arguments[0].scrollIntoView(true);", Loadmore);

		login.driver
				.findElement(By.xpath(
						"//*[@class='button button__sm button__text_purple button__block nodes-list--more-button']"))
				.click();

	}

	// TC_18207_01
	@Then("^verify Load more button should work and load series$")
	public void verify_Load_more_button_should_work_and_load_series() throws Throwable {

		// if(Loadmore=="Loadmore")

		WebElement Loadmore = login.driver.findElement(
				By.xpath("//*[@class='button button__sm button__text_purple button__block nodes-list--more-button']"));
		js.executeScript("arguments[0].scrollIntoView(true);", Loadmore);
		Thread.sleep(2000);
		System.out.println("verifyed Load more button should work and load series");

	}

	// TC_18708_01
	@And("^attributes check on tables$")
	public void attributes_check_on_tables() throws Throwable {
		Thread.sleep(2000);

		// First Obs. Date
		firstObsdate = login.driver.findElement(By.xpath("//th[contains(text(),'First Obs. Date')]")).getText();
		System.out.println("firstObsdate:" + firstObsdate);

		// Lastobsdate
		lastobsdate = login.driver.findElement(By.xpath("//th[contains(text(),'Last Obs. Date')]")).getText();
		System.out.println("lastobsdate:" + lastobsdate);

		// Last Update Time
		LastUpdateTime = login.driver.findElement(By.xpath("//th[contains(text(),'Last Update Time')]")).getText();
		System.out.println("LastUpdateTime:" + LastUpdateTime);

	}

	// TC_18708_01
	@Then("^verify First Obs\\. Date, Last Obs\\. Date and Last Update time$")
	public void verify_First_Obs_Date_Last_Obs_Date_and_Last_Update_time() throws Throwable {
		Thread.sleep(2000);

		if (firstObsdate.equals("First Obs. Date") && lastobsdate.equals("Last Obs. Date")
				&& LastUpdateTime.equals("Last Update Time"))

		{
			System.out.println("Attributes are verified");
		} else {
			Assert.fail();
		}

	}

	// TC_19499_01
	@And("^add a single quote in first name and last name$")
	public void add_a_single_quote_in_first_name_and_last_name() throws Throwable {
		Thread.sleep(2000);
		// click on first name
		login.driver.findElement(By.name("first_name")).click();
		Thread.sleep(1000);
		// enter first name
		login.driver.findElement(By.name("first_name")).sendKeys("'");

		// click on last name
		login.driver.findElement(By.name("last_name")).click();

		// enter last name
		login.driver.findElement(By.name("last_name")).sendKeys("'");

	}

	// TC_19499_01
	@Then("^Should be able to save first name and last name with single quote$")
	public void should_be_able_to_save_first_name_and_last_name_with_single_quote() throws Throwable {
		Thread.sleep(2000);

		String firstndLastname = login.driver.findElement(By.xpath("//div[@class='profile-menu--name text-dots']"))
				.getText();

		System.out.println("firstndLastname:" + firstndLastname);
		if (firstndLastname.contains("'")) {
			System.out.println("Should be able to save first name and last name with single quote");
		} else {
			Assert.fail();
		}

	}

	// TC_19277_01
	@Given("^Add series into my series as \"([^\"]*)\"$")
	public void add_series_into_my_series_as(String seriesid) throws Throwable {
		Thread.sleep(2000);
		CommonFunctionality.DeleteSeries();

		// click on search bar
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).click();

		// Enter data into search
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(seriesid);

		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		seriesids = login.driver.findElement(By.xpath("//input[@class='search-input-text']")).getText();
		System.out.println(seriesids);
		login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();

		Thread.sleep(1000);

		for (int i = 1; i <= 2; i++) {
			login.driver.findElement(By.xpath("(//*[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]"))
					.click();
		}

		// click on +icon
		login.driver.findElement(By.xpath("(//div[@class='add-to-data-selection--icon'])[1]")).click();

	}

	// TC_19277_01
	@Given("^Search series with series ID in my series filter$")
	public void search_series_with_series_ID_in_my_series_filter() throws Throwable {

		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//input[@class='form--control']")).click();

		login.driver.findElement(By.xpath("//input[@class='form--control']")).sendKeys("353687487;374827357");

		login.driver.findElement(By.xpath("//input[@class='form--control']")).sendKeys(Keys.ENTER);
		// login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();

	}

	// TC_19277_01
	@Then("^related series should be searched$")
	public void related_series_should_be_searched() throws Throwable {
		Thread.sleep(1000);
		// after search series display

		if (login.driver.findElements(By.xpath("//span[@class='series-name-field--series-name']")).size() == 2) {

			System.out.println("related series should be searched");

		} else {
			Assert.fail();
		}

	}

	// TC_18779_01
	@And("^make changes to copyright parameters$")
	public void make_changes_to_copyright_parameters() throws Throwable {
		Thread.sleep(1000);

		if (login.driver.findElements(By.xpath("//div[@class='add-style-template add-style-template__active']"))
				.size() == 0) {

			// click on copyright
			login.driver.findElement(By.xpath("//div[@class='alignment-context-title--type']")).click();

			// click on Top
			login.driver.findElement(By.xpath("//div[@class='alignment-control--icon icon--align-y-top']")).click();

			// click on left

			login.driver.findElement(By.xpath("//div[@class='alignment-control--icon icon--align-x-left']")).click();
		}

		else {
			Assert.fail();
		}

	}

	// TC_18779_01
	@Then("^Save template icon should be enabled$")
	public void save_template_icon_should_be_enabled() throws Throwable {
		Thread.sleep(2000);

		if (login.driver.findElements(By.xpath("//div[@class='add-style-template add-style-template__active']"))
				.size() == 1) {

			System.out.println("Save template icon should be enabled");
		} else {
			Assert.fail();
		}

		login.driver.findElement(By.xpath("//button[@class='button button__primary']")).click();

	}

	// TC_19487_01
	@And("^create group in same name in series$")
	public void create_group_in_same_name_in_series() throws Throwable {

		Thread.sleep(2000);

		WebElement sname = login.driver.findElement(By.xpath("//span[@class='series-name-field--series-name']"));
		action.moveToElement(sname).pause(500).build().perform();
		action.contextClick(sname).build().perform();

		// click on Group name
		login.driver.findElement(By.xpath("//span[@class='name-li'][contains(text(),'Group')]")).click();
		login.driver.findElement(By.xpath("//div[@class='insight-series-rename--button insight-series-rename--button__cancel']")).click();

		Thread.sleep(2000);
		WebElement sname1 = login.driver.findElement(By.xpath("//span[@class='group-name']"));
		action.moveToElement(sname1).pause(500).build().perform();
		action.contextClick(sname1).build().perform();
		action.moveToElement(login.driver.findElement(By.xpath("//span[@class='name-li'][contains(text(),'Group')]"))).build().perform();

		login.driver.findElement(By.xpath("//input[@class='add-to-context-manage--search']")).sendKeys(Keys.ENTER);

	}

	// TC_19487_01
	@And("^Select a series and click on Group and mouse hover on group name$")
	public void select_a_series_and_click_on_Group_and_mouse_hover_on_group_name() throws Throwable {
		Thread.sleep(1000);

		// get the series name
		String seriesname = login.driver.findElement(By.xpath("//*[@class='group-name']")).getText();
		System.out.println("seriesname:" + seriesname);

		// right click on group series name
		WebElement sname = login.driver.findElement(By.xpath("//*[@class='group-name']"));
		action.moveToElement(sname).pause(500).build().perform();
		action.contextClick(sname).build().perform();

		// mouseover on the group
		WebElement group = login.driver.findElement(By.xpath("//span[@class='name-li'][contains(text(),'Group')]"));
		action.moveToElement(group).pause(500).build().perform();

		// mouse over on the add to group popup
		WebElement addto = login.driver.findElement(By.xpath("(//span[@class='input-control--description'])[7]"));
		action.moveToElement(addto).pause(500).build().perform();
		// addto.click();

	}

	// TC_19487_01
	@Then("^verify Tooltip should displayed with full group name$")
	public void verify_Tooltip_should_displayed_with_full_group_name() throws Throwable {

		String fullsname = login.driver.findElement(By.xpath("(//span[@class='input-control--description'])[7]"))
				.getText();
		System.out.println("fullsname:" + fullsname);
		System.out.println("Enter into final scenario");

	}

	// TC_14772_01

	@Given("^Search \"([^\"]*)\" in search panel$")
	public void search_in_search_panel(String arg1) throws Throwable {

		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//*[@class='search-input-text']")).click();

		login.driver.findElement(By.xpath("//*[@class='search-input-text']")).sendKeys(arg1);
		Thread.sleep(500);
		login.driver.findElement(By.xpath("//div[@class='search-suggestions-key']")).click();

	}

	// TC_14772_01
	@Then("^Result should be displayed for EU search$")
	public void result_should_be_displayed_for_EU_search() throws Throwable {
		Thread.sleep(2000);

		try {
			login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
			// 1st series in series list
			WebElement mouseover = login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"));
			action.moveToElement(mouseover).pause(500).build().perform();
			login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]")).click();

			String region = login.driver
					.findElement(By.xpath("//div[@class='series-location-panel-item main-series-information--link']"))
					.getText();

			System.out.println("Region:" + region);

			if (region.equals("European Union")) {
				System.out.println("Result should be displayed for EU search");
			} else {
				Assert.fail();
			}

		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
			// 1st series in series list
			WebElement mouseover = login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"));
			action.moveToElement(mouseover).pause(500).build().perform();
			login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]")).click();

			String region = login.driver
					.findElement(By.xpath("//div[@class='series-location-panel-item main-series-information--link']"))
					.getText();

			System.out.println("Region:" + region);

			if (region.equals("European Union")) {
				System.out.println("Result should be displayed for EU search");
			} else {
				Assert.fail();
			}

		}

	}

	// TC_18842_01
	@Given("^click on Analysis tab$")
	public void click_on_Analysis_tab() throws Throwable {
		Thread.sleep(3000);

		login.driver.findElement(By.xpath("(//*[contains(text(),'Analysis')])[1]")).click();

	}

	// TC_18842_01
	@Given("^click on CEIC insights and click on '\\+ icon on india'$")
	public void click_on_CEIC_insights_and_click_on_icon_on_india() throws Throwable {
		Thread.sleep(1000);

		// click on CEIC Insights
		login.driver.findElement(By.xpath("//*[contains(text(),'CEIC Insights')]")).click();

		// click on india +icon

		login.driver.findElement(By.xpath("(//div[@class='toggle'])[4]")).click();

	}

	// TC_18842_01
	@Given("^click on GDP nowcast insight$")
	public void click_on_GDP_nowcast_insight() throws Throwable {
		Thread.sleep(1000);

		login.driver.findElement(By.xpath("(//*[contains(text(),'GDP Nowcast')])[1]")).click();

	}

	// TC_18842_01
	@Then("^GDP Nowcast should open insight in preview mode\\.View as grid mode$")
	public void gdp_Nowcast_should_open_insight_in_preview_mode_View_as_grid_mode() throws Throwable {
		Thread.sleep(1000);

		if (login.driver.findElements(By.xpath("//*[@class='insight-preview--actions']")).size() == 1) {
			System.out.println("GDP Nowcast should open insight in preview mode.view as grid mode");
		}

		else {
			Assert.fail();
		}
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//*[@class='insight-preview--close']")).click();

	}

	// TC_18842_01
	@Then("^GDP Nowcast should open insight in preview mode\\.View as table mode$")
	public void gdp_Nowcast_should_open_insight_in_preview_mode_View_as_table_mode() throws Throwable {
		Thread.sleep(1000);
		// click on CEIC Insights
		login.driver.findElement(By.xpath("//*[contains(text(),'CEIC Insights')]")).click();

		// click on Table view

		login.driver.findElement(By.xpath("//div[@class='insights-view-modes--item insights-view-modes--item__table']"))
				.click();
		Thread.sleep(500);
		// click on GDP nowcast insight
		login.driver.findElement(By.xpath("(//*[contains(text(),'GDP Nowcast')])[1]")).click();

		if (login.driver.findElements(By.xpath("//*[@class='insight-preview--actions']")).size() == 1) {
			System.out.println("GDP Nowcast should open insight in preview mode.View as table mode");
		}

		else {
			Assert.fail();
		}

		login.driver.findElement(By.xpath("//*[@class='insight-preview--close']")).click();
	}

	// TC_18729_02
	@Given("^click on Notification icon in right side panel top$")
	public void click_on_Notification_icon_in_right_side_panel_top() throws Throwable {
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//*[@class='user-notifications--icon']")).click();

	}

	// TC_18729_02
	@Given("^Scroll down and click on 'See all insights'$")
	public void scroll_down_and_click_on_See_all_insights() throws Throwable {
		Thread.sleep(2000);

		WebElement seeallinsights = login.driver.findElement(By.xpath("//a[@class='link link__arrowed']"));
		js.executeScript("arguments[0].scrollIntoView(true);", seeallinsights);
		Thread.sleep(500);
		seeallinsights.click();

	}

	// TC_18729_02
	@Then("^Should be open under Analysis tab Monthly product updates$")
	public void should_be_open_under_Analysis_tab_Monthly_product_updates() throws Throwable {
		Thread.sleep(4000);

		if (login.driver.findElements(By.xpath("//*[contains(text(),'Monthly Product Updates')]")).size() == 1) {

			System.out.println("Should be open under Analysis tab Monthly product updates");

		}

		else {
			Assert.fail();
		}

	}

	// TC_19383_01
	@And("^click on insert Attachment$")
	public void click_on_insert_Attachment() throws Throwable {

		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='icon--attachments']")).click();

	}

	// TC_19383_01
	@Then("^order is 'Uploads and links' and default tab is Uploads$")
	public void order_is_Uploads_and_links_and_default_tab_is_Uploads() throws Throwable {
		Thread.sleep(2000);

		// First name
		String Firstname = login.driver.findElement(By.xpath("//div[@class='tabs__tab-item active']")).getText();
		Firstname.equals("uploads");

		// 2nd name

		String secondname = login.driver.findElement(By.xpath("//div[contains(text(),'Links')]")).getText();
		secondname.equals("Links");

		// default tab is Uploads

		if (login.driver.findElements(By.xpath("//div[contains(text(),'Drop files here to upload, or click')]"))
				.size() == 1) {

			System.out.println("default tab is Uploads");

		}

		else {
			Assert.fail();
		}

	}
	
	// TC_18834_01
	@Given("^Click on series tab$")
	public void click_on_series_tab() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();

	}

	// TC_18834_01
	@Then("^User should land to series tab instead of database$")
	public void user_should_land_to_series_tab_instead_of_database() throws Throwable {

		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath("(//div[@class='series-item--main-info'])[1]")).size() == 1) {
			System.out.println("User should land to series tab instead of database");
		}

		else {
			Assert.fail();
		}

	}

	// TC_19169_01
	@And("^'webinars and events' tab check under notification panel$")
	public void webinars_and_events_tab_check_under_notification_panel() throws Throwable {

		Thread.sleep(2000);

		if (login.driver.findElements(By.xpath("//div[contains(text(),'Webinars & Events')]")).size() == 1) {
			login.driver.findElement(By.xpath("//div[contains(text(),'Webinars & Events')]")).click();
		}

		else {
			Assert.fail();
		}

	}

	// TC_19169_01
	@Then("^verify 'webinars and events' tab should be displayed$")
	public void verify_webinars_and_events_tab_should_be_displayed() throws Throwable {
		Thread.sleep(2000);

		if (login.driver.findElements(By.xpath("//div[contains(text(),'Webinars & Events')]")).size() == 1) {
			System.out.println("verify 'webinars and events' tab should be displayed");
		} else {
			Assert.fail();
		}

	}

	// TC_19215_01
	@And("^'whats new' tab check under notification panel$")
	public void whats_new_tab_check_under_notification_panel() throws Throwable {
		Thread.sleep(2000);

		if (login.driver.findElements(By.xpath("//*[@class='tabs__tab-item active']")).size() == 1) {
			System.out.println("whats new'tab should be displayed under notification panel");
		} else {
			Assert.fail();
		}

	}

	// TC_19215_01
	@And("^Scroll down and click on 'See all Webinars'$")
	public void scroll_down_and_click_on_See_all_Webinars() throws Throwable {

		Thread.sleep(2000);

		WebElement webinarslink = login.driver.findElement(By.xpath("//a[contains(text(),'See all webinars')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", webinarslink);

		Thread.sleep(2000);
		webinarslink.click();
		

	}

	// TC_19215_01
	@Then("^verify 'Webinars & Events' tab should be opened$")
	public void verify_Webinars_Events_tab_should_be_opened() throws Throwable {

		Thread.sleep(2000);

		if (login.driver.findElements(By.xpath("//*[@class='webinars-list']")).size() == 1) {
			System.out.println("webinars and Events tab should be displayed");
		} else {
			Assert.fail();
		}

	}

	// TC_18458_01
	@And("^click on rename$")
	public void click_on_rename() throws Throwable {

		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[contains(text(),'Rename')]")).click();

	}

	// TC_18458_01
	@And("^Change name for Group and click on 'Ok' button$")
	public void change_name_for_Group_and_click_on_Ok_button() throws Throwable {
		Thread.sleep(2000);

		// click on group name
		login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.click();
		// clear the data in text box
		login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.clear();

		login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.sendKeys("Test");

		// click on Ok button
		login.driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();

	}

	// TC_18458_01
	@And("^Click on arrow icon for 'Original Name'$")
	public void click_on_arrow_icon_for_Original_Name() throws Throwable {
		Thread.sleep(2000);

		// click on original name Arrow

		login.driver.findElement(By.xpath("//*[@class='find-and-replace--body-header-action-icon']")).click();
		Thread.sleep(2000);
		String grouptextbox = login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.getText();

		System.out.println("Group Textbox data" + grouptextbox);

		if (grouptextbox.equals("Test")) {
			System.out.println("Group text box title without Empty ");
		}

	}

	// TC_18458_01
	@Then("^verify the apply button disable under rename popup$")
	public void verify_the_apply_button_disable_under_rename_popup() throws Throwable {

		Thread.sleep(2000);

		Thread.sleep(2000);
		WebElement e = login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]"));

		boolean actualValue = e.isEnabled();

		if (actualValue)
			System.out.println("Button is enabled");
		else
			System.out.println("Button is disabled");

		Thread.sleep(2000);

	}

	// TC_19208_03

	@And("^Select any category in left panel$")
	public void select_any_category_in_left_panel() throws Throwable {

		Thread.sleep(2000);

		login.driver.findElement(By.xpath("(//*[@class='text-dots'])[7]")).click();

		indicatorname = login.driver.findElement(By.xpath("(//*[@class='text-dots'])[7]")).getText();
		System.out.println("Indicatorname:" + indicatorname);

	}

	// TC_19208_03
	@Then("^any category is selected on the left side, the header with associated indicators should be presented on the right side with the \"([^\"]*)\" control$")
	public void any_category_is_selected_on_the_left_side_the_header_with_associated_indicators_should_be_presented_on_the_right_side_with_the_control(
			String arg1) throws Throwable {
		Thread.sleep(2000);

		String rightsideind = login.driver.findElement(By.xpath("//*[@class='filter--title-label']")).getText();

		System.out.println("Right side Indicator name:" + rightsideind);

		// if(indicatorname==rightsideind)
		if (indicatorname.equals(rightsideind)) {
			System.out.println("selected Left side indicator == Right side indicator");
		} else {
			Assert.fail();
		}

		login.driver.findElement(By.xpath("//span[contains(text(),'Select All')]")).click();

		if (login.driver.findElements(By.xpath("//span[contains(text(),'Unselect All')]")).size() == 1) {
			System.out.println("All filters are selected");
		}

		else {
			System.out.println();
		}

	}

	// TC_18729_01
	@And("^click '\\+' icon on monthly product updates$")
	public void click_icon_on_monthly_product_updates() throws Throwable {
		Thread.sleep(2000);

		// click + icon on monthly product updates

		login.driver.findElement(By.xpath("(//div[@class='toggle'])[10]")).click();
		Thread.sleep(1000);

	}

	// TC_18729_01
	@And("^click '\\+' icon on what's new$")
	public void click_icon_on_what_s_new() throws Throwable {
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("(//div[@class='toggle'])[12]")).click();

	}

	// TC_18729_01
	@Then("^Check 'CEIC monthly newsletter'under analysis$")
	public void check_CEIC_monthly_newsletter_under_analysis() throws Throwable {
		Thread.sleep(2000);

		String subdata = login.driver.findElement(By.xpath("(//div[@class='child-container'])[4]")).getText();
		subdata = subdata.replaceAll("[0-9]", "");
		subdata = subdata.trim();
		System.out.println(subdata);

		System.out.println("=====================================");

		ArrayList<String> value = new ArrayList<String>();
		value.add("API & Integrations");
		value.add("Brazil Premium Database");
		value.add("CDMNext");
		value.add("China Premium Database");
		value.add("Global Database");
		value.add("India Premium Database");
		value.add("Indonesia Premium Database");
		value.add("Russia Premium Database");
		value.add("World Trend Plus");
		System.out.println("Static value:" + value);

		int i = 0;
		for (String newdata : value) {

			if (subdata.contains(newdata)) {
				i++;

			}
		}

		if (value.size() == i) {
			System.out.println("satisfied");
		}

	}

	// TC_19161_01
	@Given("^click on \\+ icon in right side panel$")
	public void click_on_icon_in_right_side_panel() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//*[@class='insight-page-menu-views-container--add']")).click();

	}

	// TC_19161_01
	@Given("^Create commentary visual$")
	public void create_commentary_visual() throws Throwable {

		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//*[@class='icon--text']")).click();
		Thread.sleep(5000);

	}

	// TC_19161_01
	@Given("^add some test in commentary panel$")
	public void add_some_test_in_commentary_panel() throws Throwable {
		Thread.sleep(2000);
		System.out.println("Enter into add some test");
		
		login.driver.switchTo().frame(0);
//===========================================================================
		
		
		
		
		login.driver.findElement(By.xpath("//*[@class='mce-content-body ']")).click();
		login.driver.findElement(By.xpath("//*[@class='mce-content-body ']")).sendKeys("Welcome to shravas");

		Thread.sleep(1000);
		login.driver.switchTo().defaultContent();
		
		
		
	}

	// TC_19161_01
	@Given("^click on visual dropdown and click on background$")
	public void click_on_visual_dropdown_and_click_on_background() throws Throwable {
		Thread.sleep(2000);
		WebElement mouseover=login.driver.findElement(By.xpath("//span[contains(text(),'Visual')]"));
		
		action.moveToElement(mouseover).pause(500).perform();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Visual')]")).click();
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//div[contains(text(),'Background')]")).click();
	}

	// TC_19161_01
	@Given("^visual check box checked and select color$")
	public void visual_check_box_checked_and_select_color() throws Throwable {
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//*[contains(text(),'Visual')]/preceding-sibling::span")).click();

		// click on color

		login.driver.findElement(By.xpath("//div[@class='background-control--options']//div[@class='sp-preview']")).click();


		// select color
		login.driver.findElement(By.xpath("//div[@class='sp-container sp-light sp-buttons-disabled sp-palette-buttons-disabled sp-initial-disabled color-picker-selection']//span[@title='#34224a']")).click();
		                                   //(//*[@class='sp-thumb-inner'])[13]

		// click on cross mark
		login.driver.findElement(By.xpath("//*[@class='popover--close']")).click();

	}

	// TC_19161_01
	@Then("^The color should applied to whole visual area$")
	public void the_color_should_applied_to_whole_visual_area() throws Throwable {
		Thread.sleep(2000);

		// click on top
		login.driver.findElement(By.xpath("//*[@class='visual-top-panel--content']")).click();

		// whole visual area
		String color = login.driver
				.findElement(By.xpath("//*[@class='visual-item-template visual-select-area text-template']"))
				.getCssValue("background-color");

		System.out.println("Background color:" + color);
		
		
				String actual = Color.fromString(color).asHex();
		System.out.println(" Actual Back_color:" + actual);
		// verify with Actual value with Expected value
		String excepted = "#ffffff";
		System.out.println(" Excepted color:" + excepted);
		Assert.assertEquals(excepted, actual);
		//login.driver.findElement(By.xpath("//*[@class='movable-modal--close']")).click();
		

	}

	// TC_18707_01
	@And("^double click on any one attribute on table$")
	public void double_click_on_any_one_attribute_on_table() throws Throwable {
		Thread.sleep(2000);
		try {
			WebElement attribute = login.driver.findElement(By.xpath("//th[contains(text(),'India')]"));
			action.doubleClick(attribute).build().perform();
		}

		catch (org.openqa.selenium.StaleElementReferenceException ex) {
			WebElement attribute = login.driver.findElement(By.xpath("//th[contains(text(),'India')]"));
			action.doubleClick(attribute).build().perform();
		}

	}

	// TC_18707_01
	@And("^'Series Remarks and Suggestions' check box checked$")
	public void series_Remarks_and_Suggestions_check_box_checked() throws Throwable {
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("(//*[@class='input-control--indicator'])[1]")).click();

		// close the popup
		login.driver.findElement(By.xpath("//*[@class='popover--close']")).click();

	}

	// TC_18707_01
	@And("^click on Download button in right side header$")
	public void click_on_Download_button_in_right_side_header() throws Throwable {

		Thread.sleep(2000);
		if (login.driver.findElements(By.xpath("//*[contains(text(),'Series Remarks')]")).size() == 1) {
			if (login.driver.findElements(By.xpath("//*[contains(text(),'Suggestions')]")).size() == 1) {
				System.out.println("Series Remarks and Suggestions' attribute should be display");
			}
		}

		else {
			Assert.fail();
		}

		login.driver.findElement(By.xpath("(//*[contains(text(),'Download')])[1]")).click();

		login.driver.findElement(By.xpath(
				"//*[@class='sphere-modal-control button insight-download__modal-button button button__download-btn']"))
				.click();

		Thread.sleep(10000);

	}

	// TC_18707_01
	@Then("^'Series Remarks and Suggestions' attributes should displayed to table visual and should displayed in download table$")
	public void series_Remarks_and_Suggestions_attributes_should_displayed_to_table_visual_and_should_displayed_in_download_table()
			throws Throwable {
		Thread.sleep(10000);
		WebElement table = login.driver.findElement(By.xpath("//th[contains(text(),'[COVID-19-IMPACT]')]"));

		WebElement table1 = login.driver.findElement(By.xpath("//th[contains(text(),'Series Remarks')]"));

		WebElement table2 = login.driver
				.findElement(By.xpath("//tr[@class=' heading']//*[contains(text(),'Suggestions')]"));

		WebElement table3 = login.driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div[1]/table[1]/thead[1]/tr[18]/th[2]"));

	System.out.println(table3.getText().toString());
		
		//System.getProperty("user.dir")  + "\\Testdata\\" +x+ ".xlsx");
		
		//String excelFilepath = ("user.dir")+"//Import of Goods and Services.xlsx";
		//String excelFilepath = ("user.home")+"//Downloads//Import of Goods and Services.xlsx";
		
		String excelFilepath = "C://Users//tbemineni//Downloads//Import of Goods and Services.xlsx";
		
		// File file = new File(System.getProperty("user.home") + "\\Downloads\\Seriesname.xlsx");
		//FileInputStream file = new FileInputStream(excelFilepath);
		
		FileInputStream file = new FileInputStream(excelFilepath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Table");

		int rows = sheet.getLastRowNum();
		System.out.println(rows);
		// int cols=sheet.getRow(1).getLastCellNum();

		for (int r = 0; r <= rows; r++) {

			//System.out.println("starting from for loop");
			String tableval = sheet.getRow(r).getCell(0).getStringCellValue();

			if (tableval.equalsIgnoreCase(table1.getText().toString())) {

				if (table.getText().toString().equalsIgnoreCase(sheet.getRow(r).getCell(1).getStringCellValue())) {

					System.out.println("Series Remarks attribute should displayed to Download Excel visual");

				}

			}

			else if (tableval.equalsIgnoreCase(table2.getText().toString())) {

				if (table3.getText().toString().equalsIgnoreCase(sheet.getRow(r).getCell(1).getStringCellValue())) {

					System.out.println("Suggestions'attribute should displayed to Download Excel visual");

					break;

				}

			}

		}

	}

	// TC_18786_01
	@Given("^click on menu icon in left side panel$")
	public void click_on_menu_icon_in_left_side_panel() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='help-title--icon']")).click();

	}

	// TC_18786_01
	@Given("^click on Excel Add-in$")
	public void click_on_Excel_Add_in() throws Throwable {

		Thread.sleep(1000);

		login.driver.findElement(By.xpath("//*[contains(text(),'Excel Add')]")).click();

	}

	// TC_18786_01
	@Given("^Check 'Select Microsoft Windows Version'$")
	public void check_Select_Microsoft_Windows_Version() throws Throwable {
		Thread.sleep(1000);

		WebElement data = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Windows 10 (64 Bit)')]")));
		String value = data.getText().toString();
		windowsversion = value.toLowerCase();
		System.out.println("Select Microsoft Windows Version:" + windowsversion);

	}

	// TC_18786_01
	@Then("^Windows (\\d+) \\((\\d+) Bit\\) should select by default$")
	public void windows_Bit_should_select_by_default(int arg1, int arg2) throws Throwable {

		String os = System.getProperty("os.name").toLowerCase();
		// System.out.println(os.toUpperCase());
		String excepted = os + " (64 bit)";
		System.out.println(excepted);

		// System.out.println(os+" (64 Bit)");

		if (windowsversion.equals(excepted)) {
			System.out.println("Windows 10 (64 Bit)should select by default");
		} else {
			Assert.fail();
		}

	}

	// TC_18757_01
	@Given("^create image visual$")
	public void create_image_visual() throws Throwable {
		Thread.sleep(2000);

		// click on + icon
		login.driver.findElement(By.xpath("//*[@class='insight-page-menu-views-container--add']")).click();

		Thread.sleep(1000);
		// insert image
		login.driver.findElement(By.xpath("//*[@class='icon--image']")).click();
		

		// upload image
		login.driver.findElement(By.xpath(
				"//div[@class='mce-container mce-flow-layout-item mce-first mce-btn-group']//div[@class='mce-widget mce-btn mce-first']"))
				.click();
		

	}

	// TC_18757_01
	@Given("^upload image visual$")
	public void upload_image_visual() throws Throwable {
		Thread.sleep(5000);
		 Robot robot = new Robot();
		 robot.setAutoDelay(2000);
		   
	       StringSelection selection = new StringSelection("C:\\Users\\tbemineni\\Desktop\\.metadata\\workspace\\.metadata\\CDMNEXT Application\\Cucumber_project\\Cucumber_project\\AutoIT\\download.jpg");
	       Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);

	       robot.setAutoDelay(1000);

	       robot.keyPress(KeyEvent.VK_CONTROL);
	       robot.keyPress(KeyEvent.VK_V);

	       robot.keyRelease(KeyEvent.VK_CONTROL);
	       robot.keyRelease(KeyEvent.VK_V);

	       robot.setAutoDelay(1000);

	       robot.keyPress(KeyEvent.VK_ENTER);
	       robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(30000);
		
		//login.driver.findElement(By.xpath("//*[@class='mce-ico mce-i-alignright']")).click();
		
		Thread.sleep(5000);
		
		
		//login.driver.switchTo().frame(login.driver.findElement(By.xpath("//div[@id='mceu_162']//iframe[@id='mce_2_ifr']")));
		
		login.driver.switchTo().frame(0);
		
		// click on upload image
	//	WebElement img = login.driver.findElement(By.xpath("//body[@id='tinymce']//img[@src='/api/insight/82e187fa-333f-42d8-8852-0c97cad46852/text_visual_image/4c79cf1d-cf04-49c9-95dd-e5d44da7a4fc']"));
		
		//js.executeScript("arguments[0].click()", null)
		Thread.sleep(5000);
		
		js.executeScript("arguments[0].click();",login.driver.findElement(By.xpath("//body[@id='tinymce']//img" )));
		
		
		login.driver.switchTo().defaultContent();
		
		
		
		//wait.until(ExpectedConditions.visibilityOf(img)).click();
		// action.moveToElement(img).click(img).perform();
	}

	// TC_18757_01
	@Then("^select Fit to width$")
	public void select_Fit_to_width() throws Throwable {
		Thread.sleep(7000);

		// login.driver.findElement(By.cssSelector(".mce-content-body:nth-child(2)
		// p:nth-child(1) > img:nth-child(1)")).click();
		// WebElement
		// imgover=login.driver.findElement(By.cssSelector(".mce-content-body:nth-child(2)
		// p:nth-child(1) > img:nth-child(1)"));
		// action.moveToElement(imgover).pause(500).click().perform();

		// WebElement
		// imgover=login.driver.findElement(By.xpath("/html[1]/body[1]/p[1]/img[1]"));
		// action.moveToElement(imgover).doubleClick().perform();
		// action.doubleClick(imgover).build().perform();

		Thread.sleep(5000);

		login.driver.findElement(By.xpath("//*[contains(text(),'Original size')]")).click();

		login.driver.findElement(By.xpath("//*[contains(text(),'Fit to width')]")).click();

		
		login.driver.switchTo().frame(0);
		
		
		
		
		
		if(login.driver.findElements(By.xpath("//p//img[@width='100%']")).size()==1)
		{
			System.out.println("select Fit to width");
		}
		
		else {
			Assert.fail();
		}
		
		login.driver.switchTo().defaultContent();
		
		
		

	}

	// TC_18480_01
	
	// TC_18480_01
	

	// TC_18480_01
	@Given("^Login to User (\\d+) account and click on notification panel$")
	public void login_to_User_account_and_click_on_notification_panel(int arg1) throws Throwable {
		Thread.sleep(2000);

		WebElement signout = login.driver.findElement(By.xpath("//span[contains(text(),'Sign out')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", signout);
		Thread.sleep(1000);
		signout.click();
		
		
		
		if(login.driver.findElements(By.xpath("//button[contains(text(),'Delete and sign out')]")).size()==1)
		{
		
			login.driver.findElement(By.xpath("//button[contains(text(),'Delete and sign out')]")).click();
		Thread.sleep(1000);
		login.driver.findElement(By.name("user_id")).sendKeys("venkat.test@gmail.com");
		login.driver.findElement(By.name("password")).sendKeys("Ceic@123");
		login.driver.findElement(By.xpath("//button[@class='btn']")).click();

		Thread.sleep(2000);
		WebElement notification = login.driver.findElement(By.xpath("//*[@class='user-notifications--icon']"));
		action.moveToElement(notification).perform();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//*[@class='user-notifications--icon']")).click();

		}
		else
		{
			
			Thread.sleep(3000);
			login.driver.findElement(By.name("user_id")).sendKeys("venkat.test@gmail.com");
			login.driver.findElement(By.name("password")).sendKeys("Ceic@123");
			login.driver.findElement(By.xpath("//button[@class='btn']")).click();

			Thread.sleep(2000);
			WebElement notification = login.driver.findElement(By.xpath("//*[@class='user-notifications--icon']"));
			action.moveToElement(notification).perform();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//*[@class='user-notifications--icon']")).click();

			
			
			
		}
		

	}

	// TC_18480_01
	

	// TC_18480_01
	/*@Then("^\"([^\"]*)\" should be loaded in new browser tab$")
	public void should_be_loaded_in_new_browser_tab(String arg1) throws Throwable {

		// It will return the parent window name as a String
		String parent = login.driver.getWindowHandle();
		Set<String> s = login.driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1 = s.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				login.driver.switchTo().window(child_window);
				System.out.println(login.driver.switchTo().window(child_window).getTitle());
				System.out.println(login.driver.getCurrentUrl());
				Title = login.driver.getCurrentUrl();
			}
		}

		if (Title.equals(arg1)) {
			System.out.println("should be loaded in new browser tab");
		} else {
			Assert.fail();
		}

	}

	// TC_18879_01
	@And("^Verify Customize button for insight$")
	public void verify_Customize_button_for_insight() throws Throwable {
		Thread.sleep(2000);
		// Test Nowcast close
		login.driver.findElement(By.xpath("//*[@class='insight-preview--close']")).click();

		// mouse over on the series
		WebElement mouseover = login.driver.findElement(By.xpath("//*[@class='insight-grid-item--thumbnail-box']"));
		action.moveToElement(mouseover).pause(500).build().perform();

	}

	// TC_18879_01
	@Then("^Customize button should not available$")
	public void customize_button_should_not_available() throws Throwable {
		Thread.sleep(2000);

		if (login.driver.findElements(By.xpath("//*[contains(text(),'Customize')]")).size() == 0) {
			System.out.println("Customize button should not available");
		}

		else {
			Assert.fail();
		}

	}

	// TC_18934_01
	@And("^Add table and text$")
	public void add_table_and_text() throws Throwable {
		Thread.sleep(2000);

		// click on table dropdown
		login.driver.findElement(By.xpath("(//*[@class='mce-caret'])[1]")).click();

		// mouse over the table
		WebElement table = login.driver.findElement(By.xpath(
				"//*[@class='mce-menu-item mce-menu-item-expand mce-menu-item-normal mce-stack-layout-item mce-first']"));
		action.moveToElement(table).pause(500).build().perform();

		login.driver.findElement(By.xpath("//a[@id='mcegrid1']")).click();

		// login.driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).sendKeys("Hello");

	}

	// TC_18934_01
	@And("^click on table properties$")
	public void click_on_table_properties() throws Throwable {

		Thread.sleep(2000);

		// click on table dropdown
		login.driver.findElement(By.xpath("(//*[@class='mce-caret'])[1]")).click();

		login.driver.findElement(By.xpath("(//*[contains(text(),'Table properties')])[2]")).click();

	}

	// TC_18934_01
	@And("^click on class dropdown and select CDMNext table$")
	public void click_on_class_dropdown_and_select_CDMNext_table() throws Throwable {
		Thread.sleep(2000);
		WebElement dropdown = login.driver.findElement(By.xpath("(//*[@class='mce-caret'])[11]"));
		action.moveToElement(dropdown).pause(500).build().perform();

		login.driver.findElement(By.xpath("(//*[@class='mce-caret'])[11]")).click();

		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//*[contains(text(),'CDMNext table')]")).click();

	}

	// TC_18934_01
	@And("^click on Ok button$")
	public void click_on_Ok_button() throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Ok')]")).click();

	}

	// TC_18934_01
	@Then("^CDMNext table format should be apply$")
	public void cdmnext_table_format_should_be_apply() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//*[@class='visual-top-panel--content']")).click();

		String color = login.driver.findElement(By.xpath("//tbody/tr[1]")).getCssValue("background-color");
		System.out.println(color);

	}

	// TC_18940_01
	@And("^click on first series name$")
	public void click_on_first_series_name() throws Throwable {

		Thread.sleep(5000);

		login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();

		Thread.sleep(1000);

		login.driver.findElement(By.xpath("(//*[@class='series-item--name'])[1]")).click();

	}

	// TC_18940_01
	@And("^click on data under SSP window$")
	public void click_on_data_under_SSP_window() throws Throwable {

		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='tabs__tab-item'])[1]")))
				.click();

	}

	// TC_18940_01
	@Then("^forecast timepoints should be in green color$")
	public void forecast_timepoints_should_be_in_orange_color() throws Throwable {

		Thread.sleep(2000);

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

	// TC_18940_01
	@Then("^click on second series name$")
	public void click_on_second_series_name() throws Throwable {
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("(//*[@class='series-item--name'])[2]")).click();

	}

	@Then("^Negative timepoints should be red color$")
	public void negative_timepoints_should_be_red_color() throws Throwable {
		Thread.sleep(2000);

		String text_color = login.driver
				.findElement(By.xpath("(//*[@class='preview-series-time-points--point-value'])[2]"))
				.getCssValue("color");
		String actual = Color.fromString(text_color).asHex();
		System.out.println("Negative timepoints:" + actual);
		// verify with Actual value with Expected value
		String excepted = "#e74c3c";
		System.out.println("Negative timepoints:" + excepted);
		Assert.assertEquals(excepted, actual);
		login.driver.findElement(By.xpath("//*[@class='movable-modal--close']")).click();

	}*/

}
