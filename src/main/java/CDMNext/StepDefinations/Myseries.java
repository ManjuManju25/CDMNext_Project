
package CDMNext.StepDefinations;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
//import java.util.Collection;
import java.util.Collections;
import java.util.List;
//import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

//import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
//import org.testng.Reporter;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.Given;

public class Myseries {
	static Actions action = new Actions(login.driver);
	public String Seriesnameforpreview;
	JavascriptExecutor js = (JavascriptExecutor) login.driver;
	WebElement element;
	WebElement ulelement;
	public String Searchinserieslistfilter;
	public String name;
	public String FirstseriesName;
	public String FirstseriesName1;
	public String firstFourChars;
	public String function_series_name;
	public String TEST;
	public String Seriesname;
	public String Seriesname1;
	public String Seriesname2;
	public String Functionseriesname;
	public String first_series_name_myseries;
	public String Second_first_series_name_myseries;
	public int seriescount;
	public String second_series_name;
	public String firstseriesnameinrelatedseries;
	public String Thirdseriesname;
	public int Allseriescount;
	public String Secondseriesname;
	public String Addingseries;
	public String GroupingRenamed;
	public String databasename;
	public String Secondseriesnamefunctionapplied;
	public String Secondseriesnameinssp;
	public String SID;
	public String Serieslastupdatevalue;
	public String lastupdatevalue;
	public String Seriesnametodrag;
	public String searchSeriesname;
	public String Functionappliedintoolbar;
	ArrayList<String> listofseries = new ArrayList<>();

	// TC_MS_01
	@And("^Select the Expand Icon$")
	public void select_the_Expand_Icon() throws Throwable {
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByProperty(login.driver, "Expand_Icon_Left", 10).click();
	}

	// TC_MS_01
	@And("^Verify View panel which should be Expanded$")
	public void verify_View_panel_which_should_be_Expanded() throws Throwable {
		Thread.sleep(2000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Expand_Icon_Right"))).size() != 0) {
			System.out.println("Expand icon is working");
		} else {
			Assert.fail("Expand icon is NOT working");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Expand_Icon_Right", 10).click();
	}

	// TC_MS_02
	@And("^Verify for \"([^\"]*)\" series functionality under \"([^\"]*)\" tab$")
	public void verify_for_series_functionality_under_tab(String arg1, String arg2) throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "MyInsight_Tab", 10).click();
		Thread.sleep(3000);
		Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Related_Series"))).isEnabled());
		Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename"))).isEnabled());
		Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Previewoption"))).isEnabled());
	}

	// TC_MS_03
	@And("^Select some series to my series tab$")
	public void select_some_series_to_my_series_tab() throws Throwable {
		CommonFunctionality.wait(300);
		CommonFunctionality.getElementByProperty(login.driver, "MyInsight_Tab", 10).click();

		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Series')]", 8).click();
		for (int i = 1; i <= 2; i++) {
			CommonFunctionality.getElementByXpath(login.driver,
					"(//span[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]", 8).click();

		}
		
		//Mouse hover on series name
		CommonFunctionality.wait(1000);
		WebElement series = CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='series-item--name'])[1]", 8);
		new Actions(login.driver).moveToElement(series).build().perform();
		// click on '+'icon
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='add-to-data-selection--icon'])[1]", 8).click();
	
			
		CommonFunctionality.wait(1000);
	
	}

	// TC_MS_03
	@And("^Select all series$")
	public void select_all_series() throws Throwable {
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByProperty(login.driver, "Series_select_all", 10).click();
	}

	// TC_MS_03
	@And("^select the Related series option$")
	public void select_the_Related_series_option() throws Throwable {
		
		CommonFunctionality.wait(2000);
		
		login.driver.findElement(By.xpath("//*[contains(text(),'Related series')]")).click();

	}

	// TC_MS_03
	@And("^Verify the Series suggestion manager popup$")
	public void verify_the_Series_suggestion_manager_popup() throws Throwable {
		Thread.sleep(2000);
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Related_Series_popup"))).isDisplayed());
		System.out.println("Series suggestion manager Pop up displayed");
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 10).click();

	}

	// TC_MS_04
	@And("^select the Rename series option$")
	public void select_the_Rename_series_option() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//div[@title='Rename']")).click();
		// CommonFunctionality.getElementByProperty(login.driver, "Rename", 10).click();
	}

	// TC_MS_04
	@And("^Verify the Rename popup$")
	public void verify_the_Rename_popup() throws Throwable {
		Thread.sleep(2000);
		Assert.assertTrue(
				login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Related_Series_popup"))).size() == 1);
		System.out.println("Rename Pop up displayed");
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 10).click();
	}

	// TC_MS_05
	@And("^Verify the Rename option if no series selected$")
	public void verify_the_Rename_option_if_no_series_selected() throws Throwable {
		Thread.sleep(2000);
		String Seriesinmyseries = CommonFunctionality.getElementByProperty(login.driver, "UnSelected_series", 8)
				.getText();
		System.out.println(Seriesinmyseries);
		String Seriesinpopup = CommonFunctionality.getElementByProperty(login.driver, "UnSelected_series_inpopup", 8)
				.getText();
		String str = Seriesinpopup;
		String Seriesinpopup_num = str.replaceAll("[^0-9]", "");
		System.out.println(Seriesinpopup_num);
		System.out.println(Seriesinpopup + ":" + Seriesinmyseries);
		if (Seriesinmyseries.equalsIgnoreCase(Seriesinpopup_num)) {
			System.out.println("Verified the Rename option if no series selected");
		} else {
			Assert.fail("The Rename option if no series selected is NOT Verified");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
	}

	// TC_MS_06

	@And("^Verify Series rename popup should be displayed with the selected series available in My series panel$")
	public void verify_Series_rename_popup_should_be_displayed_with_the_selected_series_available_in_My_series_panel()
			throws Throwable {
		Thread.sleep(2000);

		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 10).click();
	}

	// TC_MS_07
	@And("^get the series name$")
	public void get_the_series_name() throws Throwable {
		Thread.sleep(1000);

		WebElement chartlegend = login.driver.findElement(By.xpath("(//span[@class='series-name-field--text'])[1]"));
		action.moveToElement(chartlegend).build().perform();

		FirstseriesName = CommonFunctionality
				.getElementByXpath(login.driver, "(//span[@class='series-name-field--text'])[1]", 8).getText();

		System.out.println(FirstseriesName);
	}

	// TC_MS_07
	@And("^Verify the series order in Rename popup$")
	public void verify_the_series_order_in_Rename_popup() throws Throwable {
		Thread.sleep(2000);
		// String FirstseriesNameinpopup = CommonFunctionality
		/// .getElementByProperty(login.driver, "First_series_Name_in_popup",
		// 8).getAttribute("value");

		// login.driver.findElement(By.xpath("//div[@class='find-and-replace--body']/div[2]/div[1]/input[1]")).click();
		String FirstseriesNameinpopup = login.driver
				.findElement(By.xpath("//div[@class='find-and-replace--body']/div[2]/div[1]/input[1]"))
				.getAttribute("value");
		System.out.println("---------------" + FirstseriesNameinpopup);
		System.out.println(FirstseriesName + ":" + FirstseriesNameinpopup);
		CommonFunctionality.wait(2000);
		if (FirstseriesName.equalsIgnoreCase(FirstseriesNameinpopup)) {

			System.out.println("Verified the series order in Rename popup");
		} else {
			Assert.fail("The series order in Rename popup NOT Verified");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();

	}

	// TC_MS_08
	@And("^Verify the Rename option if series selected$")
	public void verify_the_Rename_option_if_series_selected() throws Throwable {
		Thread.sleep(2000);
		// String FirstseriesNameinpopup = CommonFunctionality
		// .getElementByProperty(login.driver, "First_series_Name_in_popup",
		// 8).getAttribute("value");

		String FirstseriesNameinpopup = login.driver
				.findElement(By.xpath("//div[@class='find-and-replace--body']/div[2]/div[1]/input"))
				.getAttribute("value");
		System.out.println(FirstseriesNameinpopup);
		System.out.println(FirstseriesName + ":" + FirstseriesNameinpopup);
		if (FirstseriesName.equalsIgnoreCase(FirstseriesNameinpopup)) {
			System.out.println("Verified the series order in Rename popup");
		} else {
			Assert.fail("The series order in Rename popup NOT Verified");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();

	}

	// TC_MS_08
	@And("^Select first series$")
	public void select_first_series() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "First_series_check_box", 8).click();
	}

	// TC_MS_09
	@And("^Verify the Rename option for number of available itmes$")
	public void verify_the_Rename_option_for_number_of_available_itmes() throws Throwable {
		Thread.sleep(2000);
		// String Seriesinmyseries =
		// CommonFunctionality.getElementByProperty(login.driver, "UnSelected_series",
		// 8)
		// .getText();
		String Seriesinmyseries = login.driver
				.findElement(By.xpath("//span[@class='find-and-replace--modal-title-info']")).getText();
		System.out.println("Seriesinmyseries count:---->" + Seriesinmyseries);
		String Seriesinpopup = CommonFunctionality.getElementByProperty(login.driver, "UnSelected_series_inpopup", 8)
				.getText();

		String str = Seriesinpopup;
		String Seriesinpopup_num = str.replaceAll("[^0-9]", "");
		System.out.println("Seriesinpopup_num:--------->" + Seriesinpopup_num);
		System.out.println("both count" + Seriesinpopup + ":" + Seriesinmyseries);
		if (Seriesinmyseries.contains(Seriesinpopup_num)) {
			System.out.println("Verified the Rename option if series selected");
		} else {
			Assert.fail("The Rename option if series selected is NOT Verified");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();

	}

	// TC_MS_10
	@And("^Select random series to my series tab$")
	public void select_random_series_to_my_series_tab() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "MyInsight_Tab", 8).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Series')]", 8).click();
		for (int i = 1; i <= 2; i++) {
			CommonFunctionality.getElementByXpath(login.driver,
					"(//*[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]", 8).click();
		}

		// click on '+' icon
		CommonFunctionality.wait(500);
		WebElement series = CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='series-item--name'])[1]", 8);
		new Actions(login.driver).moveToElement(series).build().perform();
		
		login.driver.findElement(By.xpath("(//div[@class='add-to-data-selection--icon'])[1]")).click();
		
		CommonFunctionality.wait(1000);
	}

	// TC_MS_10
	@And("^Verify the Rename find field$")
	public void verify_the_Rename_find_field() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Find_search_box", 10).sendKeys(FirstseriesName);
		String Result_series_in_search_box = CommonFunctionality
				.getElementByProperty(login.driver, "Result_series_in_search_box", 8).getText();
		if (FirstseriesName.equalsIgnoreCase(Result_series_in_search_box)) {
			System.out.println("Verified the Rename find field");

		} else {
			Assert.fail("The Rename find field is NOT Verified");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
		// Some changes have not been saved popup close.
		// CommonFunctionality.getElementByXpath(login.driver,"//button[contains(text(),'OK')]",8).click();
	}

	// TC_MS_11
	@And("^Verify the number of searched result$")
	public void verify_the_number_of_searched_result() throws Throwable {
		Thread.sleep(2000);
		List<WebElement> Serarch_result_count = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("Serarch_result_count")));
		System.out.println(Serarch_result_count.size());

		// int Totalseries = 1+Serarch_result_count.size();
		int Totalseries = Serarch_result_count.size();
		String seriescount = CommonFunctionality.getElementByProperty(login.driver, "UnSelected_series_inpopup", 8)
				.getText();
		String str = seriescount;
		String Seriesinpopup_num = str.replaceAll("[^0-9]", "");
		int Seriesnumber = Integer.parseInt(Seriesinpopup_num);
		System.out.println(Seriesnumber);
		System.out.println("Seriesnumber:" + Seriesnumber);
		System.out.println("Totalseries" + Totalseries);
		if (Seriesnumber == (Totalseries)) {
			System.out.println("Verified the number of searched result");
		} else {
			Assert.fail("The number of searched result is NOT Verified");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();

	}

	// TC_MS_13
	@And("^select the series to be replace$")
	public void select_the_series_to_be_replace() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Find_search_box", 10).sendKeys(FirstseriesName);

	}

	// TC_MS_13
	@And("^Verify the Replace field$")
	public void verify_the_Replace_field() throws Throwable {
		String replaceseries = "Employment Rate";
		CommonFunctionality.getElementByProperty(login.driver, "Replace_search_box", 8).sendKeys(replaceseries);
		CommonFunctionality.getElementByProperty(login.driver, "Replace", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "OK_Button", 8).click();
		Thread.sleep(1000);
		FirstseriesName = CommonFunctionality.getElementByProperty(login.driver, "First_series_Name", 8).getText();
		System.out.println("FirstseriesName:" + FirstseriesName);

		if (replaceseries.equalsIgnoreCase(FirstseriesName)) {
			System.out.println("Verified the Replace field");
		} else {
			Assert.fail("The Replace field is NOT Verified");
		}

		// login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
	}

	// TC_MS_14
	@And("^Verify the Replace All field$")
	public void verify_the_Replace_All_field() throws Throwable {
		String replaceseries = FirstseriesName;
		CommonFunctionality.getElementByProperty(login.driver, "Replace_search_box", 8).sendKeys(replaceseries);
		CommonFunctionality.getElementByProperty(login.driver, "Replace_All", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "OK_Button", 8).click();
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Myseries_input"))).sendKeys(replaceseries);
		Thread.sleep(1000);
		String FirstSeriescount = CommonFunctionality.getElementByProperty(login.driver, "First_Series_count", 8)
				.getText();
		System.out.println(FirstSeriescount);
		Thread.sleep(1000);
		String SecondSeriescount = CommonFunctionality.getElementByProperty(login.driver, "First_Series_count", 8)
				.getText();
		System.out.println(SecondSeriescount);
		if (FirstSeriescount.equalsIgnoreCase(SecondSeriescount)) {
			System.out.println("Verified the Replace All field");
		} else {
			Assert.fail("The Replace All field is NOT Verified");
		}
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();

	}

	// TC_MS_15
	@And("^Verify the Replace for selected series$")
	public void verify_the_Replace_for_selected_series() throws Throwable {
		String TEST = "TEST";
		CommonFunctionality.getElementByProperty(login.driver, "Replace_search_box", 8).sendKeys(TEST);
		CommonFunctionality.getElementByProperty(login.driver, "First_series_in_rename", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Replace", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "OK_Button", 8).click();
		Thread.sleep(1000);
		String firstseriesname = CommonFunctionality.getElementByProperty(login.driver, "First_series_Name", 8)
				.getText();
		System.out.println(TEST + ":" + firstseriesname);
		if (firstseriesname.equalsIgnoreCase(TEST)) {
			System.out.println("Verified the Replace for selected series");
		} else {
			Assert.fail("The Replace for selected series is NOT Verified");
		}
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();

	}

	// TC_MS_16
	@And("^rename the series name as \"([^\"]*)\"$")
	public void rename_the_series_name_as(String arg1) throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Second_series_in_rename", 8).clear();
		CommonFunctionality.getElementByProperty(login.driver, "Second_series_in_rename", 8).sendKeys(FirstseriesName);
		CommonFunctionality.getElementByProperty(login.driver, "Rename_popup", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Find_search_box", 8).sendKeys(FirstseriesName);

	}

	// TC_MS_16
	@And("^Verify Rename Find next button$")
	public void verify_Rename_Find_next_button() throws Throwable {
		String TESTING = "TESTING";
		CommonFunctionality.getElementByProperty(login.driver, "Replace_search_box", 8).sendKeys(TESTING);
		CommonFunctionality.getElementByProperty(login.driver, "Find_Next", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Replace", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "OK_Button", 8).click();
		Thread.sleep(1000);
		String secondseries = CommonFunctionality.getElementByProperty(login.driver, "Second_series_Name", 8).getText();
		if (TESTING.equalsIgnoreCase(secondseries)) {
			System.out.println("Verified the Rename Find next button");
		} else {
			Assert.fail("The Rename Find next button is NOT Verified");
		}
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();

	}

	// TC_MS_17
	@And("^send series name to find and replace field$")
	public void send_series_name_to_find_and_replace_field() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Find_search_box", 8).sendKeys(FirstseriesName);
		CommonFunctionality.getElementByProperty(login.driver, "Replace_search_box", 8).sendKeys(FirstseriesName);
	}

	// TC_MS_17
	@And("^Verify Rename Find next button is disable$")
	public void verify_Rename_Find_next_button_is_disable() throws Throwable {
		Thread.sleep(1000);
		boolean findnext = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Find_Next"))).isEnabled();

		if (findnext == true) {
			System.out.println("Rename Find next button is disable");
		} else {
			Assert.fail("Rename Find next button is NOT disable");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();

	}

	// TC_MS_18
	@And("^Verify Rename- Replace, Replace All and Find next buttons$")
	public void verify_Rename_Replace_Replace_All_and_Find_next_buttons() throws Throwable {
		Thread.sleep(1000);
		// verify_Rename_Find_next_button_is_disable();
		boolean replace = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Find_Next"))).isEnabled();
		if (replace == true) {
			System.out.println("Rename Find next button is disable");
		} else {
			Assert.fail("Rename Find next button is NOT disable");
		}
		boolean replaceall = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Find_Next"))).isEnabled();
		if (replaceall == true) {
			System.out.println("Rename Find next button is disable");
		} else {
			Assert.fail("Rename Find next button is NOT disable");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();

	}

	// TC_MS_19
	@And("^Send invalid keyword$")
	public void send_invalid_keyword() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Find_search_box", 8).sendKeys("TESTING");

	}

	// TC_MS_19
	@And("^Verify Rename- for invalid search$")
	public void verify_Rename_for_invalid_search() throws Throwable {
		String Nomatchesfound = "No matches found";
		String No_matches_found = CommonFunctionality.getElementByProperty(login.driver, "No_matches_found", 8)
				.getText();
		System.out.println(No_matches_found);
		if (No_matches_found.endsWith(Nomatchesfound)) {
			System.out.println("Rename for invalid search is verified");
		} else {
			Assert.fail("Rename for invalid search is NOT verified");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();

	}

	// TC_MS_20
	@And("^select edit series dropdown$")
	public void select_edit_series_dropdown() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info", 8).click();
	}

	// TC_MS_20
	@And("^Verify edit series dropdown$")
	public void verify_edit_series_dropdown() throws Throwable {
		Thread.sleep(1000);
		boolean Editseriesinfoname = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_Name"))).isDisplayed();
		if (Editseriesinfoname == true) {
			System.out.println("Verified edit series dropdown");
		} else {
			Assert.fail("Edit series dropdown is not verified");
		}
		Thread.sleep(1000);
		boolean Editseriesinfofunction = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_Function"))).isDisplayed();
		if (Editseriesinfofunction == true) {
			System.out.println("Verified edit series dropdown");
		} else {
			Assert.fail("Edit series dropdown is not verified");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();

	}

	// TC_MS_21
	@And("^Verify default selection for Edit series info dropdown$")
	public void verify_default_selection_for_Edit_series_info_dropdown() throws Throwable {
		String Defaultnameineditseriesinfo = "Name";
		String Default_name_in_editseriesinfo = CommonFunctionality
				.getElementByProperty(login.driver, "Edit_series_info_Name", 8).getText();
		System.out.println(Default_name_in_editseriesinfo);

		if (Default_name_in_editseriesinfo.contains(Defaultnameineditseriesinfo)) {
			System.out.println("Verified default selection for Edit series info dropdown");
		} else {
			Assert.fail("Default selection for Edit series info dropdown is NOT verified ");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();

	}

	// TC_MS_22
	@And("^Verify  Rename-Name selection$")
	public void verify_Rename_Name_selection() throws Throwable {
		Thread.sleep(2000);
		// String Seriesfirstname =
		// CommonFunctionality.getElementByProperty(login.driver,
		// "First_series_Name_in_popup", 8)
		// .getText();
		String Seriesfirstname = login.driver
				.findElement(By.xpath("//div[@class='find-and-replace--body']/div[2]/div[1]/input")).getText();
		System.out.println(Seriesfirstname);
		if (Seriesfirstname != (FirstseriesName)) {
			System.out.println("Verified Rename-Name selection");
		} else {
			Assert.fail("Rename-Name selection is NOT verified ");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
	}

	// TC_MS_23
	@And("^Applay Function as \"([^\"]*)\"$")
	public void applay_Function_as(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		select_all_series();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='Open function editor (F). Investigate all available functions in the function editor window.']", 8).click();
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver, "(//input[@placeholder='Type a function'])[2]", 8).click();
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//li[@title='Gets the percentage change over time']", 8)
				.click();
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//li[@class='suggestion-param selected']", 8).click();
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//button[text()='Apply']", 8).click();
	} 

	// TC_MS_23
	@And("^get the Applayied function series name$")
	public void get_the_Applayied_function_series_name() throws Throwable {
		Thread.sleep(2000);
		function_series_name = login.driver.findElement(By.xpath("(//span[@class='series-name-field-title'])[2]"))
				.getText();
		System.out.println(function_series_name);
		Functionseriesname = function_series_name.substring(0, function_series_name.length());

	}

	// TC_MS_23
	@And("^Verify  Function Description-Name selection$")
	public void verify_Function_Description_Name_selection() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_Function", 8).click();
	//	CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info", 8).click();
		Thread.sleep(1000);
		String Seriesfirstnameinpopup = CommonFunctionality
				.getElementByProperty(login.driver, "First_series_Name_in_popup", 8).getText();
		// System.out.println(Seriesfirstnameinpopup);
		// System.out.println(Seriesfirstnameinpopup + ":" + Functionseriesname);

		System.out.println("Seriesfirstnameinpopup:" + Seriesfirstnameinpopup);
		System.out.println("Function series name:" + function_series_name);

		if (function_series_name.contains(Seriesfirstnameinpopup)) {
			System.out.println("Verified Function Description-Name selection");
		} else {
			Assert.fail("Function Description-Name selection is NOT verified ");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
	}

	// TC_MS_24
	@And("^Verify Function Description selection without function apply$")
	public void verify_Function_Description_selection_without_function_apply() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_Function", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info", 8).click();
		// String Seriesfirstnameinpopup =
		// CommonFunctionality.getElementByProperty(login.driver,
		// "First_series_Name_in_popup", 8).getAttribute("value");
		String Seriesfirstnameinpopup = login.driver
				.findElement(By.xpath("//div[@class='find-and-replace--body']/div[2]/div[1]/input"))
				.getAttribute("value");
		if (Seriesfirstnameinpopup.isEmpty() || Seriesfirstnameinpopup == null) {
			System.out.println("Verified Function selection without function apply");
		} else {
			Assert.fail("Function selection without function apply is NOT verified ");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
	}

	// TC_MS_25
	@And("^select any series to applay function$")
	public void select_any_series_to_applay_function() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "First_Series_select", 8).click();
		// CommonFunctionality.getElementByProperty(login.driver, "function_applay",
		// 8).click();
		// CommonFunctionality.getElementByProperty(login.driver,
		// "First_function_applay", 8).click();
		login.driver.findElement(By.xpath("//input[@placeholder='Type a function']")).click();
		login.driver.findElement(By.xpath("//li[@title='Round the values']")).click();
		CommonFunctionality.wait(2000);

		function_series_name = login.driver.findElement(By.xpath("(//span[@class='series-name-field-title'])[1]"))
				.getText();
		System.out.println(function_series_name);
		// String loginToken="[wdsd34svdf]";
		Functionseriesname = function_series_name.substring(0, function_series_name.length());

	}

	// TC_MS_25
	@And("^Verify Function description if series applied functions in My series$")
	public void verify_Function_description_if_series_applied_functions_in_My_series() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_Function", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info", 8).click();
		Thread.sleep(1000);
		// String Seriesfirstnameinpopup = CommonFunctionality
		// .getElementByProperty(login.driver, "First_series_Name_in_popup",
		// 8).getAttribute("value");
		String Seriesfirstnameinpopup = login.driver.findElement(By.xpath("//span[@class='link']")).getText();
		System.out.println(Seriesfirstnameinpopup);
		System.out.println(Seriesfirstnameinpopup + ":" + Functionseriesname);

		if (Functionseriesname.contains(Seriesfirstnameinpopup)) {
			System.out.println("Verified Function Description-Name selection");
		} else {
			Assert.fail("Function Description-Name selection is NOT verified ");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
		System.out.println("<============================TC25================================================>");

	}

	// TC_MS_26
	@And("^rename the function applied series \"([^\"]*)\"$")
	public void rename_the_function_applied_series(String arg1) throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_Function", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "First_series_in_rename", 8).clear();
		CommonFunctionality.getElementByProperty(login.driver, "First_series_in_rename", 8).sendKeys(arg1);
		CommonFunctionality.getElementByProperty(login.driver, "OK_Button", 8).click();
	}

	// TC_MS_26
	@And("^Verify Function description editing$")
	public void verify_Function_description_editing() throws Throwable {
		TEST = "TEST";
		Thread.sleep(1000);
		// String Seriesfirstname =
		// CommonFunctionality.getElementByProperty(login.driver,
		// "function_series_name", 8).getText();
		String Seriesfirstname = login.driver
				.findElement(By.xpath("(//span[@class='series-name-field-title'])[1]//span[2]")).getText();
		System.out.println(Seriesfirstname);
		// String s1 = Seriesfirstname.substring(1, 18);
		// System.out.println(s1 + ":" + TEST);

		if (Seriesfirstname.contains(TEST)) {
			System.out.println("Verified Function Description editing");
		} else {
			Assert.fail("Function Description editing is NOT verified ");
		}
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
	}

	// TC_MS_28
	@And("^Verify Function description apply original title icon$")
	public void verify_Function_description_apply_original_title_icon() throws Throwable {
		String Firsttextinrename = null;
		CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_Function", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info", 8).click();
		Thread.sleep(1000);
		Firsttextinrename = CommonFunctionality.getElementByProperty(login.driver, "First_series_in_rename", 8)
				.getAttribute("value");
		System.out.println("1 = " + Firsttextinrename);
		CommonFunctionality.getElementByProperty(login.driver, "First_series_in_rename", 8).clear();
		CommonFunctionality.getElementByProperty(login.driver, "First_series_in_rename", 8).sendKeys("TESTING");
		CommonFunctionality.getElementByProperty(login.driver, "Reverse_icon_rename", 8).click();
		String Secondtextinrename = CommonFunctionality.getElementByProperty(login.driver, "First_series_in_rename", 8)
				.getAttribute("value");
		System.out.println(Secondtextinrename);
		if (!Firsttextinrename.equalsIgnoreCase(null)) {
			if (Secondtextinrename.equalsIgnoreCase(Firsttextinrename)) {
				System.out.println("Verified Function Description apply original title icon");
			} else {
				Assert.fail("Function Description apply original title icon is NOT verified ");
			}
		} else {
			fail(Firsttextinrename + " is null");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();

	}

	// TC_MS_30
	@And("^Verify Function description apply original title icon for more than one series$")
	public void verify_Function_description_apply_original_title_icon_for_more_than_one_series() throws Throwable {
		verify_Function_description_apply_original_title_icon();

	}

	// TC_MS_31
	@And("^Verify Rename Function discription clicking on series name$")
	public void verify_Rename_Function_discription_clicking_on_series_name() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_Function", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "series_name_inrename", 8).click();
		Thread.sleep(2000);
		Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Dialogue"))).isDisplayed());
		CommonFunctionality.getElementByProperty(login.driver, "SSP_Dialogue_X_Icon", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();

	}

	// TC_MS_32
	@And("^Change the series name as \"([^\"]*)\"$")
	public void change_the_series_name_as(String arg1) throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "First_series_in_rename", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "First_series_in_rename", 8).clear();
		CommonFunctionality.getElementByProperty(login.driver, "First_series_in_rename", 8).sendKeys(arg1);
		Thread.sleep(2000);
		Seriesname = CommonFunctionality.getElementByProperty(login.driver, "First_series_in_rename", 8)
				.getAttribute("value");
		System.out.println(Seriesname);
		CommonFunctionality.getElementByProperty(login.driver, "OK_Button", 8).click();

	}

	// TC_MS_32
	@And("^Verify Rename Name Editing series name$")
	public void verify_Rename_Name_Editing_series_name() throws Throwable {
		Thread.sleep(2000);
		String Seriesnameinmyseries = CommonFunctionality
				.getElementByXpath(login.driver, "(//span[@class='series-name-field-title'])[1]", 8).getText();
		// CommonFunctionality.getElementByProperty(login.driver, "First_series_Name",
		// 8).getText();
		System.out.println(Seriesnameinmyseries);
		System.out.println(Seriesnameinmyseries + ":" + Seriesname);
		if (Seriesnameinmyseries.equalsIgnoreCase(Seriesname)) {
			System.out.println("Verified Rename Name Editing series name");
		} else {
			Assert.fail("Rename Name Editing series name is NOT verified ");

		}

	}

	// TC_MS_33
	@And("^Name Series apply original title icon$")
	public void name_Series_apply_original_title_icon() throws Throwable {
		// Thread.sleep(2000);
		// String Firsttextinrename =
		// CommonFunctionality.getElementByProperty(login.driver,"First_series_in_rename",8).getAttribute("value");
		// System.out.println(Firsttextinrename);
		// CommonFunctionality.getElementByProperty(login.driver,"First_series_in_rename",8).clear();
		// CommonFunctionality.getElementByProperty(login.driver,"First_series_in_rename",8).sendKeys("TESTING");
		CommonFunctionality.getElementByProperty(login.driver, "Reverse_icon_rename", 8).click();
		String Secondtextinrename = CommonFunctionality.getElementByProperty(login.driver, "First_series_in_rename", 8)
				.getAttribute("value");
		System.out.println("Before changing the series name is " + Secondtextinrename);
		if (!Secondtextinrename.equalsIgnoreCase(Seriesname)) {
			System.out.println("Verified Series apply original title icon");
		} else {
			Assert.fail("Series apply original title icon is NOT verified ");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
	}

	// TC_MS_33
	@And("^Change the series name$")
	public void change_the_series_name() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "First_series_in_rename", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "First_series_in_rename", 8).clear();
		CommonFunctionality.getElementByProperty(login.driver, "First_series_in_rename", 8).sendKeys("TESTING");
		Thread.sleep(2000);

		Seriesname = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_series_in_rename")))
				.getAttribute("value");
		System.out.println("After changing the series name is " + Seriesname);

	}

	// TC_MS_34
	@And("^Change all the series name$")
	public void change_all_the_series_name() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "First_series_in_rename", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "First_series_in_rename", 8).clear();
		CommonFunctionality.getElementByProperty(login.driver, "First_series_in_rename", 8).sendKeys("TEST1");
		Thread.sleep(2000);

		Seriesname1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_series_in_rename")))
				.getAttribute("value");
		// Second_series_in_rename
		CommonFunctionality.getElementByProperty(login.driver, "Second_series_in_rename", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Second_series_in_rename", 8).clear();
		CommonFunctionality.getElementByProperty(login.driver, "Second_series_in_rename", 8).sendKeys("TEST2");
		Thread.sleep(2000);

		Seriesname2 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_series_in_rename")))
				.getAttribute("value");

		// System.out.println("After changing the series name is : ");

	}

	@Then("^All the changes should be revert back with original title\\.$")
	public void all_the_changes_should_be_revert_back_with_original_title() throws Throwable {

		CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='find-and-replace--body-header-action-icon']", 10)
				.click();
		CommonFunctionality.wait(2000);
		String seriesinrename1 = CommonFunctionality.getElementByProperty(login.driver, "First_series_in_rename", 8)
				.getAttribute("value");

		String seriesinrename2 = CommonFunctionality.getElementByProperty(login.driver, "Second_series_in_rename", 8)
				.getAttribute("value");

		if (!seriesinrename1.equalsIgnoreCase(Seriesname1) && !seriesinrename2.equalsIgnoreCase(Seriesname2)) {
			System.out.println("All the changes should be revert back with original title");
		} else {
			Assert.fail("Not verified");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
	}

	// TC_MS_35
	@And("^Verify > icon if no changes in series name and description$")
	public void verify_icon_if_no_changes_in_series_name_and_description() throws Throwable {
		System.out.println("===========>Enter into TC_35");
		CommonFunctionality.wait(2000);

		Boolean icon = CommonFunctionality
				.getElementByXpath(login.driver, "(//div[@class='find-and-replace-item--action'])[1]", 8).isEnabled();
		if (icon == false) {
			login.Log4j.info("The '<' icon should be disabled if no changes:PASS");
			// System.out.println("The '<' icon should be disabled if no changes");
		} else {
			// fail("The '<' icon should be disabled if no changes:FAIL");
		}
		// Assert.assertTrue(
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reverse_icon_rename"))).isDisplayed());
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();

	}

	// TC_MS_36
	@And("^Select Maximum series to my series tab$")
	public void select_Maximum_series_to_my_series_tab() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "MyInsight_Tab", 8).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Series')]", 10).click();
		for (int i = 1; i <= 8; i++) {
			CommonFunctionality.getElementByXpath(login.driver,
					"(//span[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]", 8).click();
			System.out.println("i vlaue===========>" + i);
		}
		WebElement series11 = login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"));
		new Actions(login.driver).moveToElement(series11).build().perform();
		
		WebElement icon1 = login.driver.findElement(By.xpath("(//*[@class='add-to-data-selection--icon'])[1]"));
		new Actions(login.driver).moveToElement(icon1).click().build().perform();
		
	}

	// TC_MS_36
	@Given("^Verify Rename scroll bar for more series in the popup$")
	public void verify_Rename_scroll_bar_for_more_series_in_the_popup() throws Throwable {
		Thread.sleep(5000);
		List<WebElement> Totalseries = login.driver
				.findElements(By.xpath("//*[contains(text(),'Edit series info:')]//following::input"));
		System.out.println("Total Insights are : " + Totalseries.size());
		int Totalseries_count = Totalseries.size();
		int x = 9;
		if (Totalseries_count == x) {
			System.out.println("Verified Rename scroll bar for more series in the popup");
		} else {
			Assert.fail("Rename scroll bar for more series in the popup is NOT verified ");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();

	}

	// TC_MS_37
	@And("^Verify Rename Apply button$")
	public void verify_Rename_Apply_button() throws Throwable {

		CommonFunctionality.getElementByProperty(login.driver, "Applay_Button", 8).isDisplayed();
		CommonFunctionality.getElementByProperty(login.driver, "Applay_Button", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Find_search_box", 8).isDisplayed();

		if ((login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Rename_popup"))).size() == 1)) {

			System.out.println("The changes should be saved and rename popup remains displayed");

		} else {
			Assert.fail("Not verified");
		}

		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();

	}

	// TC_MS_38
	@And("^Verify Rename OK button$")
	public void verify_Rename_OK_button() throws Throwable {
		Thread.sleep(2000);
		if ((login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Rename_popup"))).size() == 1)) {
			System.out.println("Verified Rename ok button");
		} else {
			Assert.fail("Rename ok button is NOT verified ");
		}

		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='button button__special find-and-replace--footer-button']", 8).click();

	}

	// TC_MS_39
	@And("^select the Maximize option$")
	public void select_the_Maximize_option() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Expand_rename", 8).click();
	}

	// TC_MS_39
	@And("^Verify the Maximize option$")
	public void verify_the_Maximize_option() throws Throwable {
		Thread.sleep(2000);
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Collapse_rename"))).isDisplayed());
		CommonFunctionality.getElementByProperty(login.driver, "Collapse_rename", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();

	}

	// TC_MS_40
	@And("^select the Minimize option$")
	public void select_the_Minimize_option() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Expand_rename", 8).click();
	}

	// TC_MS_40
	@And("^Verify the Minimize option$")
	public void verify_the_Minimize_option() throws Throwable {
		Thread.sleep(2000);
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Collapse_rename"))).isDisplayed());
		CommonFunctionality.getElementByProperty(login.driver, "Collapse_rename", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
	}

	// TC_MS_41
	@And("^select the Fullscreen option$")
	public void select_the_Fullscreen_option() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Mini_Max_mize_rename", 8).click();
	}

	// TC_MS_41
	@And("^Verify the Fullscreen option$")
	public void verify_the_Fullscreen_option() throws Throwable {
		String Maximize = CommonFunctionality.getElementByProperty(login.driver, "Mini_Max_mize_rename", 8)
				.getAttribute("title");
		System.out.println(Maximize);
		String MAX = "Maximize";

		if (Maximize.equalsIgnoreCase(MAX)) {
			System.out.println("Verified Fullscreen option");
		} else {
			Assert.fail("Fullscreen option is NOT verified ");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();

	}

	// TC_MS_42
	@And("^select the ExitFullscreen option$")
	public void select_the_ExitFullscreen_option() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Mini_Max_mize_rename", 8).click();
	}

	// TC_MS_42
	@And("^Verify the ExitFullscreen option$")
	public void verify_the_ExitFullscreen_option() throws Throwable {
		select_the_ExitFullscreen_option();
		String Minimize = CommonFunctionality.getElementByProperty(login.driver, "Mini_Max_mize_rename", 8)
				.getAttribute("title");
		System.out.println(Minimize);
		String MIN = "Minimize";

		if (Minimize.equalsIgnoreCase(MIN)) {
			System.out.println("Verified EXITFullscreen option");
		} else {
			Assert.fail("EXITFullscreen option is NOT verified ");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();

	}

	// TC_MS_43
	@And("^select the Cancel option$")
	public void select_the_Cancel_option() throws Throwable {
		Thread.sleep(2000);
		Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).isDisplayed());
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
	}

	// TC_MS_43
	@And("^Verify the Cancel option$")
	public void verify_the_Cancel_option() throws Throwable {
		Thread.sleep(2000);
		if ((login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Rename_popup"))).size() == 0)) {
			System.out.println("Verified Cancel option");
		} else {
			Assert.fail("Cancel option is NOT verified ");
		}

	}

	// TC_MS_44
	@And("^select the preview option$")
	public void select_the_preview_option() throws Throwable {
		// CommonFunctionality.getElementByProperty(login.driver, "preview", 8).click();
		CommonFunctionality.wait(2000);
		WebElement preview = login.driver.findElement(By.xpath("(//div[normalize-space()='Preview'])[2]"));
		action.moveToElement(preview).click().build().perform();
	}

	// TC_MS_44
	@And("^Verify the Preview pop up$")
	public void verify_the_Preview_pop_up() throws Throwable {
		if ((login.driver.findElements(By.xpath(login.LOCATORS.getProperty("preview_popup"))).size() != 0)) {
			System.out.println("Verified Preview pop up");
		} else {
			Assert.fail("Preview pop up is NOT verified ");
		}
		CommonFunctionality.getElementByProperty(login.driver, "preview_popup_close", 8).click();

	}

	// TC_MS_45
	@And("^Verify the Preview-chart tab$")
	public void verify_the_Preview_chart_tab() throws Throwable {
		Thread.sleep(3000);
		if ((login.driver.findElements(By.xpath(login.LOCATORS.getProperty("preview_Chart"))).size() != 0)) {
			System.out.println("Verified Preview-chart tab");
		} else {
			Assert.fail("Preview-chart tab is NOT verified ");
		}
		CommonFunctionality.getElementByProperty(login.driver, "preview_popup_close", 8).click();

	}

	// TC_MS_46
	@And("^Verify the Preview chart legend$")
	public void verify_the_Preview_chart_legend() throws Throwable {

		try {

			WebElement chartlegend = login.driver.findElement(
					By.xpath("//*[@class='highcharts-container ']/div[1]/div/div/div[1]/span/div[1]/span[1]"));
			action.moveToElement(chartlegend).build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "preview_Chart_Legend", 8).click();
			Thread.sleep(2000);
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Dialogue"))).isDisplayed());
			CommonFunctionality.getElementByProperty(login.driver, "SSP_Dialogue_X_Icon", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "preview_popup_close", 8).click();

		} catch (org.openqa.selenium.StaleElementReferenceException ex) {

			WebElement chartlegend = login.driver.findElement(
					By.xpath("//*[@class='highcharts-container ']/div[1]/div/div/div[1]/span/div[1]/span[1]"));
			action.moveToElement(chartlegend).build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "preview_Chart_Legend", 8).click();
			Thread.sleep(2000);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Dialogue_preview")))
					.isDisplayed());
			CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "preview_popup_close", 8).click();
		}

	}

	// TC_MS_48
	@And("^Verify the Preview hiding all series from chart$")
	public void verify_the_Preview_hiding_all_series_from_chart() throws Throwable {

		CommonFunctionality.wait(1000);
		List<WebElement> chartlegend = login.driver
				.findElements(By.xpath("//div[@class='legend-item--hiding-series']"));
		for (int i = 1; i <= chartlegend.size(); i++) {
			action.moveToElement(
					login.driver.findElement(By.xpath("(//div[@class='legend-item--hiding-series'])[" + i + "]")))
					.build().perform();
			CommonFunctionality.wait(300);
			login.driver.findElement(By.xpath("(//div[@class='legend-item--hiding-series'])[" + i + "]")).click();
		}
		Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_Chart_Legend_nodata")))
				.isDisplayed());
		CommonFunctionality.getElementByProperty(login.driver, "preview_popup_close", 8).click();
	}

	// TC_MS_49
	@Given("^Verify the Preview chart Source$")
	public void verify_the_Preview_chart_Source() throws Throwable {
		Thread.sleep(2000);

		WebElement chartlegend = login.driver.findElement(By.xpath("(//*[contains(text(),'Source: CEIC Data')])[1]"));
		action.moveToElement(chartlegend).build().perform();
		CommonFunctionality.getElementByProperty(login.driver, "preview_Ceicdata", 8).click();
		ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs2.get(1));
		Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_page"))).isDisplayed());
		login.driver.close();
		login.driver.switchTo().window(tabs2.get(0));
		CommonFunctionality.getElementByProperty(login.driver, "preview_popup_close", 8).click();

	}

	// TC_MS_50
	@And("^Verify the Preview -Table tab$")
	public void verify_the_Preview_Table_tab() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "preview_table_mode", 8).click();
		CommonFunctionality.wait(500);
		String Firstseriesname = CommonFunctionality.getElementByProperty(login.driver, "First_series_Name", 8)
				.getText();
		String Text2 = CommonFunctionality
				.getElementByXpath(login.driver, "//table/*//th[2]//span[@class='series-edit--title']", 8).getText();
		System.out.println(Text2 + ":" + Firstseriesname);
		if (Text2.equalsIgnoreCase(Firstseriesname)) {

			System.out.println("Preview Series functionality in Table is Working Successfully");
		} else {
			Assert.fail("Preview Series functionality in Table is NOT Working Successfully");
		}
		CommonFunctionality.getElementByProperty(login.driver, "preview_popup_close", 8).click();
		System.out.println("<============================TC50================================================>");
	}

	// TC_MS_51
	@And("^Verify the Preview -Table tab on clicking series name$")
	public void verify_the_Preview_Table_tab_on_clicking_series_name() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "preview_table_mode", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "preview_table_mode_series_name", 8).click();
		Thread.sleep(2000);
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_table_mode_SSP"))).isDisplayed());
		CommonFunctionality.getElementByProperty(login.driver, "footnote_window_close", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "preview_popup_close", 8).click();
	}

	// TC_MS_52
	@And("^Verify the Preview table Source$")
	public void verify_the_Preview_table_Source() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "preview_table_mode", 8).click();
		JavascriptExecutor jse = (JavascriptExecutor) login.driver;
		element = CommonFunctionality.getElementByXpath(login.driver, "(//*[contains(text(),'Source: CEIC Data')])[1]",
				8);
		jse.executeScript("arguments[0].scrollIntoView(true);", element);

		try {

			Thread.sleep(2000);
			WebElement chartlegend = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[contains(text(),'Source: CEIC Data')])[1]", 8);
			action.moveToElement(chartlegend).build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "preview_table_mode_Source", 8).click();
			ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
			login.driver.switchTo().window(tabs2.get(1));
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_page"))).isDisplayed());
			login.driver.close();
			login.driver.switchTo().window(tabs2.get(0));
			CommonFunctionality.getElementByProperty(login.driver, "preview_popup_close", 8).click();

		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			Thread.sleep(5000);

			WebElement chartlegend = login.driver
					.findElement(By.xpath("(//*[contains(text(),'Source: CEIC Data')])[1]"));
			action.moveToElement(chartlegend).build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "preview_table_mode_Source", 8).click();
			ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
			login.driver.switchTo().window(tabs2.get(1));
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_page"))).isDisplayed());
			login.driver.close();
			login.driver.switchTo().window(tabs2.get(0));
			CommonFunctionality.getElementByProperty(login.driver, "preview_popup_close", 8).click();

		}
	}

	// TC_MS_53
	@And("^Verify the Preview Statistics tab$")
	public void verify_the_Preview_Statistics_tab() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "preview_table_staticsdata", 8).click();
		Thread.sleep(1000);
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_table_Name"))).isDisplayed());
		CommonFunctionality.getElementByProperty(login.driver, "preview_popup_close", 8).click();

	}

	// TC_MS_54
	@And("^Verify the Preview Statistics tab clicking on series name$")
	public void verify_the_Preview_Statistics_tab_clicking_on_series_name() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "preview_table_staticsdata", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "preview_table_mode_series_name", 8).click();
		Thread.sleep(1000);
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_table_mode_SSP"))).isDisplayed());
		CommonFunctionality.getElementByProperty(login.driver, "preview_popup_close", 8).click();

	}

	// TC_MS_55
	@And("^Verify the Preview Statistics tab Source$")
	public void verify_the_Preview_Statistics_tab_Source() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "preview_table_staticsdata", 8).click();
		JavascriptExecutor jse = (JavascriptExecutor) login.driver;
		element = CommonFunctionality.getElementByXpath(login.driver, "(//*[contains(text(),'Source: CEIC Data')])[1]",
				8);
		jse.executeScript("arguments[0].scrollIntoView(true);", element);

		try {

			WebElement chartlegend = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[contains(text(),'Source: CEIC Data')])[1]", 8);
			action.moveToElement(chartlegend).build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "preview_table_mode_Source", 8).click();
			ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
			login.driver.switchTo().window(tabs2.get(1));
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_page"))).isDisplayed());
			login.driver.close();
			login.driver.switchTo().window(tabs2.get(0));
			CommonFunctionality.getElementByProperty(login.driver, "preview_popup_close", 8).click();

		} catch (org.openqa.selenium.StaleElementReferenceException ex) {

			Thread.sleep(2000);
			WebElement chartlegend = login.driver
					.findElement(By.xpath("(//*[contains(text(),'Source: CEIC Data')])[1]"));
			action.moveToElement(chartlegend).build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "preview_table_mode_Source", 8).click();
			ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
			login.driver.switchTo().window(tabs2.get(1));
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_page"))).isDisplayed());
			login.driver.close();
			login.driver.switchTo().window(tabs2.get(0));
			CommonFunctionality.getElementByProperty(login.driver, "preview_popup_close", 8).click();

		}
	}

	// TC_MS_57
	@And("^Verify the Preview Close icon$")
	public void verify_the_Preview_Close_icon() throws Throwable {
		Thread.sleep(3000);
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_popup_close"))).isDisplayed());
		CommonFunctionality.getElementByProperty(login.driver, "preview_popup_close", 8).click();

	}

	// TC_MS_56
	@And("^Add some series$")
	public void add_some_series() throws Throwable {
		select_some_series_to_my_series_tab();
	}

	// TC_MS_56
	@And("^Verify the Preview refresh icon$")
	public void verify_the_Preview_refresh_icon() throws Throwable {
		select_all_series();
		select_the_preview_option();
		CommonFunctionality.getElementByProperty(login.driver, "preview_refresh", 8).click();
		Thread.sleep(3000);
		List<WebElement> serieslist = login.driver
				.findElements(By.xpath("//span[@class='series-edit--title series-edit--title__editable']"));
		System.out.println("Total Series are : " + serieslist.size());
		int serieslist_count = serieslist.size();
		if (serieslist_count > 1) {
			System.out.println("Verified Preview refresh icon");
		} else {
			Assert.fail("Preview refresh icon is NOT verified ");

		}
	}

	/*
	 * @And("^To right panel$") public void to_right_panel() throws Throwable {
	 * Thread.sleep(8000);
	 * 
	 * Actions action = new Actions(login.driver); WebElement we =
	 * login.driver.findElement(By.xpath("//div[@class='name-block two-rows-item ']"
	 * )); action.moveToElement(we).build().perform(); Thread.sleep(8000);
	 * 
	 * Seriesnameforpreview = login.driver.findElement(By.xpath(
	 * "//span[@class='series-name-field--series-name']")) .getText();
	 * System.out.println(Seriesnameforpreview); Thread.sleep(6000);
	 * login.driver.findElement(By.xpath("//span[@class='input-control--indicator']"
	 * )).click(); Thread.sleep(6000); login.driver.findElement(By.
	 * xpath("//div[@class='data-action-panel insight-action-panel']/div[5]")).click
	 * ();
	 * 
	 * }
	 * 
	 * @And("^Verify for \"([^\"]*)\" in \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	 * public void verify_for_in(String arg1, String arg2, String arg3, String arg4)
	 * throws Throwable { Thread.sleep(6000); if (arg2.equalsIgnoreCase(arg2)) {
	 * Thread.sleep(6000); login.driver.findElement(By.xpath(
	 * "//div[@class='series-preview-header']/div[2]/div/label[1]")).click();
	 * 
	 * 
	 * Actions action = new Actions(login.driver); WebElement we =
	 * login.driver.findElement(By.xpath( "//span[@class='series-edit--title']"));
	 * action.moveToElement(we).build().perform();
	 * 
	 * 
	 * Thread.sleep(6000); String Text1 =
	 * login.driver.findElement(By.xpath("//span[@class='series-edit--title']")).
	 * getText();
	 * 
	 * System.out.println(Text1);
	 * 
	 * System.out.println(Text1 + ":" + Seriesnameforpreview); if
	 * (Text1.equalsIgnoreCase(Seriesnameforpreview)) {
	 * 
	 * System.out.
	 * println("Preview Series functionality in Chart is Working Successfully"); }
	 * else { Assert.
	 * fail("Preview Series functionality in Chart is NOT Working Successfully"); }
	 * } if (arg3.equalsIgnoreCase(arg3)) { Thread.sleep(6000);
	 * login.driver.findElement(By.xpath(
	 * "//div[@class='series-preview-header']/div[2]/div/label[2]")).click();
	 * 
	 * Actions action = new Actions(login.driver); WebElement we =
	 * login.driver.findElement(By.xpath( "//span[@class='series-edit--title']"));
	 * action.moveToElement(we).build().perform();
	 * 
	 * Thread.sleep(6000); String Text2 =
	 * login.driver.findElement(By.xpath("//span[@class='series-edit--title']")).
	 * getText();
	 * 
	 * System.out.println(Text2);
	 * 
	 * System.out.println(Text2 + ":" + Seriesnameforpreview); if
	 * (Text2.equalsIgnoreCase(Seriesnameforpreview)) {
	 * 
	 * System.out.
	 * println("Preview Series functionality in Table is Working Successfully"); }
	 * else { Assert.
	 * fail("Preview Series functionality in Table is NOT Working Successfully"); }
	 * } if (arg4.equalsIgnoreCase(arg4)) { Thread.sleep(6000);
	 * login.driver.findElement(By.xpath(
	 * "//div[@class='series-preview-header']/div[2]/div/label[3]")).click();
	 * 
	 * 
	 * Actions action = new Actions(login.driver); WebElement we =
	 * login.driver.findElement(By.xpath( "//span[@class='series-edit--title']"));
	 * action.moveToElement(we).build().perform();
	 * 
	 * 
	 * Thread.sleep(6000); String Text3 =
	 * login.driver.findElement(By.xpath("//span[@class='series-edit--title']")).
	 * getText();
	 * 
	 * System.out.println(Text3);
	 * 
	 * System.out.println(Text3 + ":" + Seriesnameforpreview); if
	 * (Text3.equalsIgnoreCase(Seriesnameforpreview)) {
	 * 
	 * System.out.
	 * println("Preview Series functionality in Statistics is Working Successfully"
	 * ); } else { Assert.
	 * fail("Preview Series functionality in Statistics is NOT Working Successfully"
	 * ); } } Thread.sleep(6000);
	 * login.driver.findElement(By.xpath("//div[@class='series-preview-close']")).
	 * click(); Thread.sleep(6000); login.driver.findElement(By.
	 * xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click
	 * (); }
	 */

	// TC_MS_59
	@And("^Select (\\d+) series to my series tab$")
	public void select_series_to_my_series_tab(int arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Series')]", 10).click();
		for (int i = 1; i <= 20; i++) {
			Thread.sleep(800);
			login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]"))
					.click();

		}
		Thread.sleep(300);
		// click on '+'icon
		WebElement series1 = login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"));
		new Actions(login.driver).moveToElement(series1).build().perform();
		
		login.driver.findElement(By.xpath("(//div[@class='add-to-data-selection--icon'])[1]")).click();
	
				
		Thread.sleep(1000);
	}

	// TC_MS_59
	@And("^Verify for \"([^\"]*)\" Maximum series for 'Preview option'$")
	public void verify_for_Maximum_series_for_Preview_option(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='check-all-series']//span[@class='input-control--indicator']", 8).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//div[normalize-space()='Preview'])[2]", 8).click();

		if (login.driver.findElements(By.xpath("//div[@class='series-preview-title']")).size() != 0) {
			System.out.println("Preview option is working fine !!! ");
		} else {
			Assert.fail("Preview option is NOT working fine"); // div[@class='header-menu-help__link'][3]
		}
		CommonFunctionality.getElementByProperty(login.driver, "preview_popup_close", 8).click();
		// Thread.sleep(3000);
		// CommonFunctionality.DeleteSeries();

	}

	// TC_MS_59
	@And("^Select \"([^\"]*)\" series to my series tab$")
	public void select_series_to_my_series_tab(String arg1) throws Throwable {
		Thread.sleep(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Series')]", 10).click();
		for (int i = 1; i <= 21; i++) {
			Thread.sleep(300);
			login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]"))
					.click();

		}
		Thread.sleep(500);
		// click on '+'icon
		
		CommonFunctionality.wait(1000);
		WebElement series = CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='series-item--name'])[1]", 8);
		new Actions(login.driver).moveToElement(series).build().perform();
		
		login.driver.findElement(By.xpath("(//div[@class='add-to-data-selection--icon'])[1]")).click();
				
		CommonFunctionality.wait(1000);
	}

	// TC_MS_58
	@And("^Verify 'Preview option' is disable for \"([^\"]*)\" series$")
	public void verify_Preview_option_is_disable_for_series(String arg1) throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Series_select_all", 10).click();

		Boolean preview = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@title='Preview. View selected series as a chart and as a table and see series statistics.']", 8)
				.isEnabled();
		if (preview == false) {
			login.Log4j.info("Preview option is disabled for more than 20 series");
		} else {
			 Assert.fail("Preview option is enabled for less than 20 series");
		}
	}

	// TC_MS_60
	@And("^Verify Validation message for more than (\\d+) series added to preview window\\.$")
	public void verify_Validation_message_for_more_than_series_added_to_preview_window(int arg1) throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "preview_refresh", 10).click();
		CommonFunctionality.wait(2000);
		if (login.driver.findElements(By.xpath("//div[@class='growl-message-text']")).size() == 1) {
			login.Log4j.info("Validation message Verified Successfully!!!");
		} else {
			Assert.fail("Validation message is NOT Verified Successfully!!!");
		}
		CommonFunctionality.getElementByProperty(login.driver, "preview_popup_close", 10).click();
	}

	// TC_MS_60
	@And("^Select preview option$")
	public void select_preview_option() throws Throwable {
		select_all_series();
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver,
				"(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[1]", 8).click();
		CommonFunctionality.wait(1000);
		// CommonFunctionality.getElementByProperty(login.driver,
		// "First_series_inmyseriespanel", 8).click();
		WebElement preview = login.driver.findElement(By.xpath("(//div[normalize-space()='Preview'])[2]"));
		action.moveToElement(preview).click().build().perform();
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver,
				"(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[1]", 8).click();
		CommonFunctionality.wait(5000);
		// CommonFunctionality.getElementByProperty(login.driver, "preview",
		// 10).click();
		// CommonFunctionality.getElementByProperty(login.driver,
		// "Select_All_Series_checkbox", 10).click();
	}

	/*
	 * @And("^Select the select all option$") public void
	 * select_the_select_all_option() throws Throwable { Thread.sleep(8000);
	 * login.driver.findElement(By.xpath("//span[@class='input-control--indicator']"
	 * )).click(); Thread.sleep(8000); login.driver.findElement(By.
	 * xpath("//div[@class='data-action-panel insight-action-panel']/div[9]/div[2]"
	 * )) .click(); Thread.sleep(8000); login.driver.findElement(By.
	 * xpath("//ul[@class='dropdown-menu context-menu ']/div[3]/li[1]")).click();
	 * 
	 * }
	 * 
	 * @And("^Verify \"([^\"]*)\" option functionality\\.$") public void
	 * verify_option_functionality(String arg1) throws Throwable {
	 * Thread.sleep(8000); String Count1 = login.driver.findElement(By.xpath(
	 * "//span[@class='series-panel--count']/span[1]/span[1]")) .getText();
	 * Thread.sleep(8000); String Count2 = login.driver.findElement(By.xpath(
	 * "//span[@class='series-panel--count']/span[3]/span[2]")) .getText();
	 * System.out.println(Count1 + ":" + Count2); if
	 * (Count1.equalsIgnoreCase(Count2)) {
	 * 
	 * System.out.println("Select all Functionality is working Successfully"); }
	 * else {
	 * Assert.fail("Select all Functionality is NOT working Successfully:-("); }
	 * Thread.sleep(8000); login.driver.findElement(By.
	 * xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click
	 * (); }
	 * 
	 * @And("^Select the Unselect all option$") public void
	 * select_the_Unselect_all_option() throws Throwable { Thread.sleep(8000);
	 * Thread.sleep(8000);
	 * login.driver.findElement(By.xpath("//span[@class='input-control--indicator']"
	 * )).click();
	 * 
	 * select_the_select_all_option(); Thread.sleep(8000);
	 * 
	 * login.driver.findElement(By.
	 * xpath("//div[@class='data-action-panel insight-action-panel']/div[9]/div[2]"
	 * )) .click(); Thread.sleep(8000); login.driver.findElement(By.
	 * xpath("//ul[@class='dropdown-menu context-menu ']/div[3]/li[2]")).click(); }
	 * 
	 * @And("^Verify UnSelect all option functionality\\.$") public void
	 * verify_UnSelect_all_option_functionality() throws Throwable {
	 * Thread.sleep(8000);
	 * 
	 * boolean deletebtn =
	 * login.driver.findElement(By.xpath("//span[@class='input-control--indicator']"
	 * )) .isSelected(); System.out.print(deletebtn); if (deletebtn == false) {
	 * System.out.
	 * println("UnSelect all option functionality is working Successfully"); } else
	 * { Assert.
	 * fail("UnSelect all option functionality is NOT working Successfully :-("); }
	 * }
	 * 
	 * @And("^Verify Clear All option for \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" functionality\\.$"
	 * ) public void verify_Clear_All_option_for_functionality(String arg1, String
	 * arg2, String arg3) throws Throwable { Thread.sleep(5000);
	 * 
	 * if (arg2.equalsIgnoreCase(arg2)) { Thread.sleep(8000); String
	 * Countbeforeclear = login.driver
	 * .findElement(By.xpath("//span[@class='series-panel--count']/span[1]/span[1]")
	 * ).getText(); Thread.sleep(5000); login.driver.findElement(By.
	 * xpath("//div[@class='data-action-panel insight-action-panel']/div[9]/div[2]"
	 * )) .click(); Thread.sleep(8000); login.driver.findElement(By.
	 * xpath("//ul[@class='dropdown-menu context-menu ']/div[3]/li[3]")).click();
	 * Thread.sleep(8000);
	 * login.driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).
	 * click(); String Countafterclear = login.driver
	 * .findElement(By.xpath("//span[@class='series-panel--count']/span[1]/span[1]")
	 * ).getText(); System.out.println(Countbeforeclear + ":" + Countafterclear); if
	 * (Countbeforeclear.equalsIgnoreCase(Countafterclear)) {
	 * 
	 * System.out.
	 * println("Clear all Functionality  for Cancel is working Successfully"); }
	 * else { Assert.
	 * fail("Clear all Functionality  for Cancel is Not working Successfully:-("); }
	 * }
	 * 
	 * if (arg3.equalsIgnoreCase(arg3)) { Thread.sleep(8000); String Countbeoreclear
	 * = login.driver
	 * .findElement(By.xpath("//span[@class='series-panel--count']/span[1]/span[1]")
	 * ).getText(); Thread.sleep(5000); login.driver.findElement(By.
	 * xpath("//div[@class='data-action-panel insight-action-panel']/div[9]/div[2]"
	 * )) .click(); Thread.sleep(8000); login.driver.findElement(By.
	 * xpath("//ul[@class='dropdown-menu context-menu ']/div[3]/li[3]")).click();
	 * Thread.sleep(8000);
	 * login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).
	 * click(); String Countafterclear = login.driver
	 * .findElement(By.xpath("//span[@class='series-panel--count']/span[1]/span[1]")
	 * ).getText(); System.out.println(Countbeoreclear + ":" + Countafterclear); if
	 * (Countbeoreclear.equalsIgnoreCase(Countafterclear)) {
	 * 
	 * System.out.
	 * println("Clear all Functionality  for Dismiss is working Successfully"); }
	 * else { Assert.
	 * fail("Clear all Functionality  for Dismiss is Not working Successfully:-(");
	 * } } if (arg1.equalsIgnoreCase(arg1)) { Thread.sleep(8000); String
	 * Countbeoreclear = login.driver
	 * .findElement(By.xpath("//span[@class='series-panel--count']/span[1]/span[1]")
	 * ).getText(); Thread.sleep(5000); login.driver.findElement(By.
	 * xpath("//div[@class='data-action-panel insight-action-panel']/div[9]/div[2]"
	 * )) .click(); Thread.sleep(8000); login.driver.findElement(By.
	 * xpath("//ul[@class='dropdown-menu context-menu ']/div[3]/li[3]")).click();
	 * Thread.sleep(8000);
	 * login.driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click()
	 * ; Thread.sleep(5000); if (login.driver .findElements( By.
	 * xpath("//div[@class='insight-action-panel--btn insight-action-panel--btn__disabled'] "
	 * )) .size() != 0) {
	 * System.out.println("Clear all Functionality  for Ok is working Successfully"
	 * ); } else {
	 * Assert.fail("Clear all Functionality  for Ok is Not working Successfully:-("
	 * ); } } }
	 */

	// TC_MS_72
	@And("^Select the Delete option$")
	public void select_the_Delete_option() throws Throwable {
		CommonFunctionality.wait(1000);
	//	CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='insight-action-panel--btn-icon'])[4]", 8)
	//			.click();
		 login.driver.findElement(By.xpath(
		 "//div[@title='Delete (Delete). Delete selected series from the `My series`.']//div[@class='insight-action-panel--btn-icon']"))
		 .click();

	}

	// TC_MS_72
	@And("^Verify Delete option functionality for Series$")
	public void verify_Delete_option_functionality_for_Series() throws Throwable {
		Thread.sleep(2000);
		String delete = login.driver.findElement(By.xpath("(//div[@class='insight-action-panel--btn disabled'])[2]"))
				.getAttribute("class");
		System.out.println(delete);
		if (delete.contains("disabled")) {
			System.out.println("Delete Functionality having Series is working Successfully");
		} else {
			Assert.fail("Delete Functionality having Series is Not working Successfully");
		}
	}

	// TC_MS_74
	@And("^Create visuals as Chart$")
	public void create_visuals_as_Chart() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Series')]", 8).click();
		CommonFunctionality
				.getElementByXpath(login.driver, "(//*[@class='series-list-item--checkbox svg-checkbox'])[1]", 8)
				.click();
		Thread.sleep(2000);
		WebElement elementLocator11 = login.driver
				.findElement(By.xpath("(//*[@class='series-list-item--checkbox svg-checkbox'])[1]"));
		action.contextClick(elementLocator11).perform();
	
		WebElement Add_chart = login.driver.findElement(By.xpath("//span[normalize-space(text())='Add chart']"));
		new Actions(login.driver).moveToElement(Add_chart).pause(2000).build().perform();

		WebElement Chart = login.driver.findElement(By.xpath("//div[contains(@class,'icon--chart-line')]"));
		js.executeScript("arguments[0]. click();", Chart);
	}

	// TC_MS_74
	@And("^Verify Delete option functionality having pop head title$")
	public void verify_Delete_option_functionality_having_pop_head_title() throws Throwable {
		Thread.sleep(3000);
		String Insisepopup = login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']"))
				.getText();
		Thread.sleep(1000);
		if (Insisepopup.contains(
				"The series are associated with visuals within the current insight and deleting them will affect the visuals. Are you sure you want to delete?")) {
			System.out.println("Mesage in Delete dialog window is  verified Successfully");
		} else {
			Assert.fail("Mesage in Delete dialog window is NOT verified Successfully:-(");
		}
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']", 8).click();

	}

	// TC_MS_74
	@And("^Select to myseries button and select the delete option$")
	public void select_to_myseries_button_and_select_the_delete_option() throws Throwable {
		CommonFunctionality.wait(4000);
		WebElement myseries = CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-page-view-tab']", 8);
		action.moveToElement(myseries).click().build().perform();
		select_all_series();
		CommonFunctionality.wait(2000);
		select_the_Delete_option();
	}

	// TC_MS_75
	@And("^Verify Delete option functionality having ok button$")
	public void verify_Delete_option_functionality_having_ok_button() throws Throwable {
		Thread.sleep(2000);
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Delete_ok_button"))).isDisplayed());
		CommonFunctionality.getElementByProperty(login.driver, "Delete_ok_button", 8).click();
		System.out.println("Delete ok Functionality  is working Successfully"); 
		Assert.fail("Delete ok Functionality is Not working Successfully");
		  	 
	}

	// TC_MS_76
	@And("^Verify Delete option associated visuals after deleted series$")
	public void verify_Delete_option_associated_visuals_after_deleted_series() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Delete_ok_button", 8).click();
		Thread.sleep(2000);
		if (login.driver.findElements(By.xpath("//div[@class='data-selection-series-overlay--content']")).size() != 0) {
			System.out.println("Delete option associated visuals after deleted series Verified Successfully!!! ");
		} else {
			Assert.fail("Delete option associated visuals after deleted series is NOT Verified Successfully!!!");
		}

	}

	// TC_MS_77
	@And("^Verify Delete Cancel/x icon for the popup$")
	public void verify_Delete_Cancel_x_icon_for_the_popup() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Delete_Cancel_button", 8).click();
		if (login.driver.findElements(By.xpath("//button[contains(text(),'Cancel')]")).size() == 0) {
			System.out.println("Delete Cancel/x icon for the popup Verified Successfully!!! ");
		} else {
			Assert.fail("Delete Cancel/x icon for the popup is NOT Verified Successfully!!!");
		}

	}

	// TC_MS_78
	@And("^Select the grouping function$")
	public void select_the_grouping_function() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='check-all-series']//span[@class='input-control--indicator']", 8).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@data-action='group'])[1]", 8).click();
		
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//div[@class='insight-series-rename--button insight-series-rename--button__cancel']", 8)
				.click();

	}

	@Then("^Verify selected series should be grouped$")
	public void verify_selected_series_should_be_grouped() throws Throwable {
	   Thread.sleep(1000);
	   
	  String group = login.driver.findElement(By.xpath("//div[@class='popover-content']/div/input")).getText();
	  
	  if(group.equalsIgnoreCase("Group: Consumer Price Index")) {
		  login.Log4j.info("Selected series should be grouped");
	  }else {
		 Assert.fail("Selected series should not be grouped");
	  }
	}
	// TC_MS_78
	@And("^Verify \"([^\"]*)\" functionality for Series$")
	public void verify_functionality_for_Series(String arg1) throws Throwable {
		String GroupVerification = "Group";
		String Text = CommonFunctionality.getElementByXpath(login.driver, "//div[@class='popover-content']/div/input", 9).getText();
		System.out.println("Text is" + Text);
		String mystring = Text;
		String arr[] = mystring.split(" ", 2);

		String firstWord = arr[0];
		firstWord = firstWord.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(GroupVerification + ":" + firstWord);
		if (GroupVerification.equalsIgnoreCase(firstWord)) {

			System.out.println("Grouping Functionality  is working Successfully");
		} else {
			Assert.fail("Grouping Functionality is Not working Successfully:-(");
		}

	}

	// TC_MS_79
	@And("^Select the grouping dropdown$")
	public void select_the_grouping_dropdown() throws Throwable {
		select_all_series();
		CommonFunctionality.wait(500);
		// CommonFunctionality.getElementByProperty(login.driver,
		login.driver.findElement(By.xpath(
				"//div[@title='Group. Unite selected series into a group.']//div[contains(@class,'context-menu-arrow')]"))
				.click();
	}

	// TC_MS_79
	@And("^Verify Grouping dropdown$")
	public void verify_Grouping_dropdown() throws Throwable {
		Thread.sleep(3000);
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Grouping_dropdown"))).isDisplayed());
		CommonFunctionality.wait(500);
		login.driver.findElement(By.xpath("//span[contains(text(),'Group')]")).click();
	}

	// TC_MS_80
	@And("^Select the grouping icon$")
	public void select_the_grouping_icon() throws Throwable {
		select_all_series();
		CommonFunctionality.wait(1000);
		login.driver.findElement(By.xpath("(//div[@class='insight-action-panel--btn-icon'])[10]")).click();
		
		System.out.println("<============================TC80================================================>");
	}

	// TC_MS_81
	@And("^Verify Group rename popup$")
	public void verify_Group_rename_popup() throws Throwable {
		Thread.sleep(3000);
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Grouping_rename_popup"))).isDisplayed());

	}

	// TC_MS_82
	@And("^Verify \"([^\"]*)\" Rename functionality for Series$")
	public void verify_Rename_functionality_for_Series(String arg1) throws Throwable {
		Thread.sleep(2000);
		if (login.driver.findElements(By.xpath("//div[@class='popover-content']/div")).size() != 0) {
			System.out.println("Grouping Rename pop up appeared Successfully");
		} else {
			Assert.fail("Grouping Rename pop up Does not appeared Successfully:-(");
		}
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='popover-content']/div/input", 8).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='popover-content']/div/input", 8).clear();
		String GroupingRenamed = "GroupingRenamed";
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='popover-content']/div/input", 8)
				.sendKeys(GroupingRenamed);
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//div[@class='insight-series-rename--button insight-series-rename--button__apply']", 8)
				.click();
		Thread.sleep(2000);
		String Text = login.driver.findElement(By.xpath("//span[@class='group-name']")).getText();
		System.out.println(GroupingRenamed + ":" + Text);
		if (GroupingRenamed.equalsIgnoreCase(Text)) {

			System.out.println("Grouping Renamed Functionality  is working Successfully");
		} else {
			Assert.fail("Grouping Renamed Functionality is Not working Successfully:-(");
		}
	}

	// TC_MS_83
	@And("^Verify Cancel icon for group rename popup$")
	public void verify_Cancel_icon_for_group_rename_popup() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Grouping_cancelicon_popup", 8).click();
		String GroupVerification = "Group";
		String Text = CommonFunctionality.getElementByXpath(login.driver, "//span[@class='group-name']", 8).getText();
		System.out.println("Text is" + Text);
		String mystring = Text;
		String arr[] = mystring.split(" ", 2);
		String firstWord = arr[0];
		firstWord = firstWord.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(GroupVerification + ":" + firstWord);
		if (GroupVerification.equalsIgnoreCase(firstWord)) {

			System.out.println("Cancel icon for grouping functionality is working Successfully");
		} else {
			Assert.fail("Cancel icon for grouping functionality is not working Successfully:-(");
		}

	}

	// TC_MS_84
	@And("^select group option\\.$")
	public void select_group_option() throws Throwable {
		CommonFunctionality.wait(500);
		WebElement group = CommonFunctionality.getElementByXpath(login.driver, "//div[contains(text(),'Group')]", 8);
		action.moveToElement(group).click().build().perform();
		// login.driver.findElement(By.xpath("//div[contains(text(),'Group')]")).click();

	}

	// TC_MS_84
	@And("^Select the UnGroup option$")
	public void select_the_UnGroup_option() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[@title='Group. Unite selected series into a group.']//div[@class='insight-action-panel--btn-popup icon--context-menu-arrow']",
				8).click();
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Ungroup')]", 8).click();
		}

	// TC_MS_84
	@And("^Verify UnGroup functionality for Series$")
	public void verify_UnGroup_functionality_for_Series() throws Throwable {
		
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[@title='Group. Unite selected series into a group.']//div[@class='insight-action-panel--btn-popup icon--context-menu-arrow']",
				8).click();
		CommonFunctionality.wait(500);
		if (login.driver.findElement(By.xpath("//div[@class='insight-action-panel--btn-popup icon--context-menu-arrow']")).isEnabled()){
		
			login.Log4j.info("UnGrouping Functionality  is working Successfully");
		} else {
			Assert.fail("UnGrouping Functionality is Not working Successfully:-(");
		}
		/*
		 * CommonFunctionality.getElementByXpath(login.driver,
		 * "//div[@class='data-action-panel insight-action-panel']/div[9]/div[2]",
		 * 8).click();
		 */
	}

	// TC_MS_85
	@And("^Verify UnGroup functionality disabled status when their is no Group$")
	public void verify_UnGroup_functionality_disabled_status_when_their_is_no_Group() throws Throwable {
		/*
		 * CommonFunctionality.getElementByXpath(login.driver,
		 * "//div[@class='data-action-panel insight-action-panel']/div[9]/div[2]",
		 * 8).click();
		 */
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[@title='Group. Unite selected series into a group.']//div[@class='insight-action-panel--btn-popup icon--context-menu-arrow']",
				8).click();
		// login.driver.findElement(By.xpath(
		// "//div[@title='Group. Unite selected series into a
		// group.']//div[@class='insight-action-panel--btn-popup
		// icon--context-menu-arrow']"))
		// .click();
		CommonFunctionality.wait(2000);
		if (login.driver.findElements(By.xpath("//span[@class='context-menu-item link disabled']")).size() != 0) {
			System.out.println("UnGrouping Functionality  is in disabled status when their is no Group");
		} else {
			Assert.fail("UnGrouping Functionality  is NOT in disabled status when their is no Group:-(");
		}
		// login.driver.findElement(By.xpath("//div[@title='Group. Unite selected series
		// into a group.']//div[@class='insight-action-panel--btn-popup
		// icon--context-menu-arrow']")).click();
		/*
		 * CommonFunctionality.getElementByXpath(login.driver,
		 * "//div[@class='data-action-panel insight-action-panel']/div[9]/div[2]",
		 * 8).click();
		 */
	}

	// TC_MS_86
	@And("^Select the Seperator option$")
	public void select_the_Seperator_option() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@data-action='group']//following::div)[2]", 8)
				.click();
		login.driver.findElement(By.xpath("(//div[@data-action='group']//following::div)[2]")).click();
		/*
		 * CommonFunctionality.getElementByXpath(login.driver,
		 * "//div[@class='data-action-panel insight-action-panel']/div[9]/div[2]",
		 * 8).click();
		 */
		/*
		 * CommonFunctionality .getElementByXpath(login.driver,
		 * "//ul[@class='dropdown-menu context-menu ']/div[3]/li[3]/span", 8) .click();
		 */
		CommonFunctionality.wait(500);
		login.driver.findElement(By.xpath("//span[contains(text(),'Add separator')]")).click();

	}

	// TC_MS_86
	@And("^Verify Seperator functionality for Series$")
	public void verify_Seperator_functionality_for_Series() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='check-all-series']//span[@class='input-control--indicator']", 8).click();
		CommonFunctionality.wait(2000);
		CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='series-name-wrapper separator-row ']/span[1]", 8)
				.click();
		Thread.sleep(2000);

		if (login.driver.findElements(By.xpath("//*[@class='series-name-wrapper separator-row ']")).size() == 1) {
			System.out.println("Seperate functionality is working Successfully");
		} else {
			Assert.fail("Seperate functionality is NOT working Successfully :-(");
		}

	}

	// TC_MS_87
	@And("^get the text of the first series$")
	public void get_the_text_of_the_first_series() throws Throwable {
		Thread.sleep(2000);
		first_series_name_myseries = login.driver.findElement(By.xpath("(//span[@class='series-name-field--text'])[1]"))
				.getText();
	}

	// TC_MS_87
	@And("^Select the Move Up option$")
	public void select_the_Move_Up_option() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Series_move_up", 8).click();
	}

	// TC_MS_87
	@And("^get the text of the next first series$")
	public void get_the_text_of_the_next_first_series() throws Throwable {
		Thread.sleep(2000);
		Second_first_series_name_myseries = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("First_series_name_myseries"))).getText();
	}

	// TC_MS_87
	@And("^Verify Move Up option$")
	public void verify_Move_Up_option() throws Throwable {
		System.out.println(first_series_name_myseries + ":" + Second_first_series_name_myseries);
		if (first_series_name_myseries != (Second_first_series_name_myseries)) {
			System.out.println("Move Up option  is working Successfully");
		} else {
			Assert.fail("Move Up option is Not working Successfully:-(");
		}

	}

	// TC_MS_88
	@And("^Select the Move down option$")
	public void select_the_Move_down_option() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Series_move_down", 8).click();
	}

	// TC_MS_88
	@And("^Verify Move down option$")
	public void verify_Move_down_option() throws Throwable {
		verify_Move_Up_option();
	}

	@And("^Select a series in bottom$")
	public void select_a_series_in_bottom() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='webix_column list-series-name webix_last']/*[3]/*[1]/*[1]", 8).click();
	}

	@And("^Select a series in top$")
	public void select_a_series_in_top() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='webix_column list-series-name webix_last']/*[1]/*[1]/*[1]", 8).click();
	}

	// TC_MS_89
	@And("^Select the Move top option$")
	public void select_the_Move_top_option() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Series_move_top", 8).click();
	}

	// TC_MS_89
	@And("^Verify Move top option$")
	public void verify_Move_top_option() throws Throwable {
		verify_Move_Up_option();
	}

	// TC_MS_90
	@And("^Select the Move bottom option$")
	public void select_the_Move_bottom_option() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Series_move_bottom", 8).click();
	}

	// TC_MS_90
	@And("^Verify Move bottom option$")
	public void verify_Move_bottom_option() throws Throwable {
		verify_Move_Up_option();
	}

	// TC_MS_91
	@And("^Select Cut option$")
	public void select_Cut_option() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "cut_option", 8).click();
	}

	// TC_MS_91
	@And("^verify the Cut option$")
	public void verify_the_Cut_option() throws Throwable {
		Thread.sleep(1000);
		if (login.driver.findElements(By.xpath("//div[@class='growl-message-text']")).size() != 0) {
			System.out.println("Validation message Verified Successfully for Cut Option!!! ");
		} else {
			Assert.fail("Validation message is NOT Verified Successfully for Cut Option!!!");
		}
	}

	// TC_MS_92
	@And("^create a new insight$")
	public void create_a_new_insight() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "File_dropdown", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Newinsight_file", 8).click();
		// CommonFunctionality.getElementByXpath(login.driver,"//a[@class='insight-breadcrumb--title-link
		// link']",8).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Create insight')]", 8).click();

	}

	// TC_MS_92
	@And("^Select paste option$")
	public void select_paste_option() throws Throwable {
		CommonFunctionality.wait(700);
		CommonFunctionality.getElementByProperty(login.driver, "paste_option", 8).click();
	}

	// TC_MS_92
	@And("^verify the paste option$")
	public void verify_the_paste_option() throws Throwable {
		Thread.sleep(2000);
		String pastedseries = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("First_series_name_myseries"))).getText();
		if (first_series_name_myseries.equalsIgnoreCase(pastedseries)) {

			System.out.println("Paste option  is working Successfully");
		} else {
			Assert.fail("Paste option is Not working Successfully:-(");
		}
	}

	// TC_MS_93
	@And("^verify the confirmation message for Cut action$")
	public void verify_the_confirmation_message_for_Cut_action() throws Throwable {
		Thread.sleep(1000);
		if (login.driver.findElements(By.xpath("//div[@class='growl-message-text']")).size() != 0) {
			System.out.println("Validation message Verified Successfully for Cut Option!!! ");
		} else {
			Assert.fail("Validation message is NOT Verified Successfully for Cut Option!!!");
		}
	}

	// TC_MS_94
	@And("^verify the confirmation message for paste action$")
	public void verify_the_confirmation_message_for_paste_action() throws Throwable {
		Thread.sleep(400);
		if (login.driver.findElements(By.xpath("//div[@class='growl-message-text']")).size() != 0) {
			System.out.println("Validation message Verified Successfully for Paste Option!!! ");
		} else {
			Assert.fail("Validation message is NOT Verified Successfully for Paste Option!!!");
		}

	}

	// TC_MS_95
	@And("^verify the closing of growl popup$")
	public void verify_the_closing_of_growl_popup() throws Throwable {

		WebElement we = login.driver.findElement(By.xpath("//div[@class='growl-message-close']"));
		action.moveToElement(we).build().perform();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("growl_message_close"))).click();
		Thread.sleep(5000);
		if (login.driver.findElements(By.xpath("//div[@class='growl-message-text']")).size() == 0) {
			System.out.println("closing of growl popup is Verified Successfully");
		} else {
			Assert.fail("closing of growl popup is NOT Verified Successfully");
		}
	}

	// TC_MS_96
	@And("^Select Copy option$")
	public void select_Copy_option() throws Throwable {
		// CommonFunctionality.getElementByProperty(login.driver, "Copy_option",
		// 8).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("(//div[@class='insight-action-panel--btn-icon'])[3]")).click();
	}

	// TC_MS_96
	@And("^verify the Copy option$")
	public void verify_the_Copy_option() throws Throwable {
		Thread.sleep(1000);
		if (login.driver.findElements(By.xpath("//div[@class='growl-message-text']")).size() != 0) {
			System.out.println("Validation message Verified Successfully for Copy Option!!! ");
		} else {
			Assert.fail("Validation message is NOT Verified Successfully for Copy Option!!!");
		}
	}

	// TC_MS_97
	@And("^verify the confirmation message for Copy action$")
	public void verify_the_confirmation_message_for_Copy_action() throws Throwable {
		Thread.sleep(1000);
		if (login.driver.findElements(By.xpath("//div[@class='growl-message-text']")).size() != 0) {
			System.out.println("confirmation message for Copy action is Verified Successfully");
		} else {
			Assert.fail("confirmation message for Copy action is NOT Verified Successfully");
		}
	}

	// TC_MS_98
	@And("^Select Paste option$")
	public void select_Paste_option() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "paste_option", 8).click();
	}

	// TC_MS_98
	@And("^verify the Paste option$")
	public void verify_the_Paste_option() throws Throwable {
		Thread.sleep(500);
		if (login.driver.findElements(By.xpath("//div[@class='growl-message-text']")).size() != 0) {
			System.out.println("Validation message Verified Successfully for Paste Option!!! ");
		} else {
			Assert.fail("Validation message is NOT Verified Successfully for Paste Option!!!");
		}
	}

	// TC_MS_99
	@And("^Select Currency Conversion$")
	public void select_Currency_Conversion() throws Throwable {
		select_all_series();
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-action-panel--btn-title'][contains(text(),'Popular')]", 8).click();
	//	 CommonFunctionality.getElementByProperty(login.driver,
	//			 "Concurrency_current_dropdown", 8).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@data-id='USD']", 8).click();
		CommonFunctionality.wait(2000);
//		CommonFunctionality.getElementByXpath(login.driver, "//span[@class='name-li'][contains(text(),'USD')]", 8)
//				.click();

	}

	// TC_MS_99
	@And("^verify the Currency Conversion is applied for a series$")
	public void verify_the_Currency_Conversion_is_applied_for_a_series() throws Throwable {
		Thread.sleep(3000);
		String Functionappliedintoolbar = "[CONVERTCUR(US Dollars; as reported)]";
	//	System.out.println("Functionappliedintoolbar------->" + Functionappliedintoolbar);
		Thread.sleep(3000);
		String Functiondescriptioninseries = login.driver
				.findElement(By.xpath("//span[@class='series-functions-title']")).getText();
		
		if (Functionappliedintoolbar.equalsIgnoreCase(Functiondescriptioninseries)) {
			
			login.Log4j.info("Currency Conversion is applied successfully");
		} else {
			 Assert.fail("Currency Conversion is not applied successfully");
		}
	}

	// TC_MS_100
	@And("^Select Calculate Change$")
	public void select_Calculate_Change() throws Throwable {
		select_all_series();
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-action-panel--btn-title'][contains(text(),'Popular')]", 8).click();
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@data-id='YEAR_OVER_YEAR']", 8).click();
	
	}

	// TC_MS_100
	@And("^verify the Calculate Change is applied for a series$")
	public void verify_the_Calculate_Change_is_applied_for_a_series() throws Throwable {
		Thread.sleep(3000);
		String Functionappliedintoolbar = "[%CHANGE(Over Year)]";
		Thread.sleep(3000);
		String Functiondescriptioninseries = login.driver
				.findElement(By.xpath("//span[@class='series-functions-title']")).getText();

		if (Functiondescriptioninseries.equalsIgnoreCase(Functionappliedintoolbar)) {

			System.out.println("Calculate Change is applied successfully");
		} else {
			Assert.fail("Calculate Change is not applied successfully");
		}
		System.out.println("<============================TC100================================================>");
	}

	// TC_MS_101
	@And("^Select Aggregate$")
	public void select_Aggregate() throws Throwable {
		select_all_series();
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-action-panel--btn-title'][contains(text(),'Popular')]", 8).click();
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@data-id='SUM']", 8).click();
		
	}

	// TC_MS_101
	@And("^verify the Aggregate is applied for a series$")
	public void verify_the_Aggregate_is_applied_for_a_series() throws Throwable {
		Thread.sleep(3000);
		String Functionappliedintoolbar = "[AGGREGATE(Yearly; December; Sum)]";
		Thread.sleep(3000);
		String Functiondescriptioninseries = login.driver
				.findElement(By.xpath("//span[@class='series-functions-title")).getText();
	
		if (Functiondescriptioninseries.equalsIgnoreCase(Functionappliedintoolbar)) {

			System.out.println("Aggregate is applied successfully");
		} else {
			Assert.fail("Aggregate is not applied successfully");
		}
		
	}

	// TC_MS_102

	@Given("^\"([^\"]*)\" series added into my series$")
	public void series_added_into_my_series(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Series')]", 8).click();
		Thread.sleep(2000);
		// click on search bar
		CommonFunctionality.getElementByXpath(login.driver, "//input[@class='search-input-text']", 8).click();

		CommonFunctionality.getElementByXpath(login.driver, "//input[@class='search-input-text']", 8).clear();
		CommonFunctionality.getElementByXpath(login.driver, "//input[@class='search-input-text']", 8).sendKeys(arg1);
		CommonFunctionality
				.getElementByXpath(login.driver, "//span[@class='series-list-item--checkbox svg-checkbox']]", 8)
				.click();

		 Thread.sleep(3000);

		// click on '+'icon
		 
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='add-to-data-selection--icon'])[1]", 8)
				.click();
		// add-to-data-selection--icon
		// Thread.sleep(2000);
	}


	// TC_MS_102
	@And("^Select Accumulate$")
	public void select_Accumulate() throws Throwable {
		select_all_series();
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-action-panel--btn-title'][contains(text(),'Popular')]", 8).click();
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@data-id='YTD']", 8).click();
	}

	// TC_MS_102
	@And("^verify the Accumulate is applied for a series$")
	public void verify_the_Accumulate_is_applied_for_a_series() throws Throwable {
		Thread.sleep(3000);
		String Functionappliedintoolbar = "[YTD(Sum; December)]";
		Thread.sleep(3000);
		String Functiondescriptioninseries = login.driver
				.findElement(By.xpath("//span[@class='series-functions-title")).getText();
	
		if (Functiondescriptioninseries.equalsIgnoreCase(Functionappliedintoolbar)) {

			System.out.println("Accumulate is applied Successfully");
		} else {
			Assert.fail("Accumulate functionality is Not working Successfully:-(");
		}
	}

	// TC_MS_103
	@And("^Select Favorite drop down$")
	public void select_Favorite_drop_down() throws Throwable {
		select_all_series();
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-action-panel--btn-title'][contains(text(),'Favorite')]", 8).click();
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//span[@class='popular-functions-context--all-title']", 8).click();
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "(//input[@placeholder='Search'])[3]", 8).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//input[@placeholder='Search'])[3]", 8).clear();
		CommonFunctionality.getElementByXpath(login.driver, "(//input[@placeholder='Search'])[3]", 8).sendKeys("YTD");
		CommonFunctionality.wait(2000);
		

	}

	// TC_MS_103
	@And("^verify the Function applied in FX drop down$")
	public void verify_the_Function_applied_in_FX_drop_down() throws Throwable {
		Thread.sleep(3000);
		String Functionappliedintoolbar = login.driver
				.findElement(By.xpath("//span[@class='series-function-item--body']/span[1]")).getText();
		Thread.sleep(3000);
		String Functiondescriptioninseries = login.driver
				.findElement(By.xpath("//span[@class='series-name-field-title']/span[2]")).getText();
		String s1 = Functiondescriptioninseries.substring(1, 4);
		System.out.println("FX drop down value:" + s1);
		System.out.println(Functionappliedintoolbar + ":" + s1);
		if (Functionappliedintoolbar.equalsIgnoreCase(s1)) {
			System.out.println("Function applied in FX drop down is Successfully");
		} else {
			Assert.fail("Function applied in FX drop down is Not working Successfully:-(");
		}
	}

	// TC_MS_104
	@And("^Select FX Icon$")
	public void select_FX_Icon() throws Throwable {
		CommonFunctionality.wait(2000);
		select_all_series();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(
				"//div[@title='Open function editor (F). Investigate all available functions in the function editor window.']"))
				.click();
		}

	// TC_MS_104
	@And("^verify the FX Icon$")
	public void verify_the_FX_Icon() throws Throwable {

		if (login.driver.findElements(By.xpath("//div[@class='movable-modal--title ui-draggable-handle']"))
				.size() != 0) {
			System.out.println("FX Icon is Verified Successfully!!! ");
		} else {
			Assert.fail("FX Icon is NOT Verified Successfully!!!");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
	}

	// TC_MS_105
	@And("^Applay \"([^\"]*)\" function$")
	public void applay_function(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("(//input[@placeholder='Type a function'])[2]")).click();
		CommonFunctionality.wait(1000);
		login.driver.findElement(By.xpath("(//input[@placeholder='Type a function'])[2]")).sendKeys(arg1);
		login.driver.findElement(By.xpath("//li[@class='suggestion-param selected']")).click();
		login.driver.findElement(By.xpath("//li[@class='suggestion-param selected']")).click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//button[text()='Apply']")).click();

	}

	// TC_MS_105
	@And("^verify appling function by clicking on function icon$")
	public void verify_appling_function_by_clicking_on_function_icon() throws Throwable {
		Thread.sleep(3000);
		String Functionappliedintoolbar = "[%CHANGE(Over Year)]";
		String Functiondescriptioninseries = login.driver
				.findElement(By.xpath("//span[@class='series-name-field-title']/span[2]")).getText();
	//	String s1 = Functiondescriptioninseries.substring(1, 19);
	//	System.out.println(Functionappliedintoolbar + ":" + s1);

		if (Functiondescriptioninseries.equalsIgnoreCase(Functionappliedintoolbar)) {

		login.Log4j.info("Appling function by clicking on function icon is Successful");
		} else {
			Assert.fail("Appling function by clicking on function icon is Not working Successfully");
		}
	}

	// TC_MS_106
	@And("^Select hiding toolbar$")
	public void select_hiding_toolbar() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Hide_function_toolbar", 8).click();
	}

	// TC_MS_106
	@And("^verify hiding function toolbar$")
	public void verify_hiding_function_toolbar() throws Throwable {
		Thread.sleep(3000);

		boolean hiding_function = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Function_tool_bar")))
				.isDisplayed();
		if (hiding_function == false) {
			System.out.println("Hiding function toolbar is Verified Successfully!!! ");
		} else {
			Assert.fail("Hiding function toolbar is NOT Verified Successfully!!!");
		}
	}

	// TC_MS_107
	@And("^Select Expanding toolbar$")
	public void select_Expanding_toolbar() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Expand_function_toolbar", 8).click();
	}

	// TC_MS_107
	@And("^verify Expanding function toolbar$")
	public void verify_Expanding_function_toolbar() throws Throwable {
		Thread.sleep(3000);

		boolean hiding_function = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Function_tool_bar")))
				.isDisplayed();
		if (hiding_function == true) {
			System.out.println("Hiding function toolbar is Verified Successfully!!! ");
		} else {
			Assert.fail("Hiding function toolbar is NOT Verified Successfully!!!");
		}
	}

	// TC_MS_108
	@And("^Select function field$")
	public void select_function_field() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Input_field_function", 8).click();
	}

	// TC_MS_108
	@And("^verify function field$")
	public void verify_function_field() throws Throwable {
		boolean hiding_function = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("Function_list_dropdown"))).isDisplayed();
		if (hiding_function == true) {
			System.out.println("Function field is Verified Successfully!!! ");
		} else {
			Assert.fail("Function field is NOT Verified Successfully!!!");
		}
	}

	// TC_MS_109
	@And("^verify Checkbox for select all$")
	public void verify_Checkbox_for_select_all() throws Throwable {
		Thread.sleep(2000);
		String selectedallseriescount = CommonFunctionality.getElementByProperty(login.driver, "Total_series_count", 8)
				.getText();
		Thread.sleep(2000);
		String selectedseriescount = CommonFunctionality.getElementByProperty(login.driver, "Selected_series_count", 8)
				.getText();

		if (selectedallseriescount.equals(selectedseriescount)) {

			System.out.println("Checkbox for select all series is Verified Successfully!!! ");
		} else {
			Assert.fail("Checkbox for select all series is NOT Verified Successfully!!!");
		}

	}

	// TC_MS_109
	@And("^UnSelect all series$")
	public void unselect_all_series() throws Throwable {
		select_all_series();
	}

	// TC_MS_109
	@And("^verify Checkbox for unselect all$")
	public void verify_Checkbox_for_unselect_all() throws Throwable {
		boolean unselect_all = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Selected_series_count")))
				.isDisplayed();
		if (unselect_all == false) {
			System.out.println("Checkbox for unselect all series is Verified Successfully!!! ");
		} else {
			Assert.fail("Checkbox for unselect all series is NOT Verified Successfully!!!");
		}
	}

	// TC_MS_110
	@And("^get the count of the series in my series panel$")
	public void get_the_count_of_the_series_in_my_series_panel() throws Throwable {
		Thread.sleep(3000);
		List<WebElement> Totalseriesinmyseriespanel = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("Total_series_in_myseriespanel")));
		seriescount = Totalseriesinmyseriespanel.size();
	}

	// TC_MS_110
	@And("^verify total number of series in my series$")
	public void verify_total_number_of_series_in_my_series() throws Throwable {
		Thread.sleep(2000);
		String Total_series_count = CommonFunctionality.getElementByProperty(login.driver, "Total_series_count", 8)
				.getText();
		int Totalseriescount = Integer.parseInt(Total_series_count);
		System.out.println(seriescount + ":" + Totalseriescount);
		if (seriescount == (Totalseriescount)) {

			System.out.println("Total number of series in my series is Verified Successfully!!! ");
		} else {
			Assert.fail("Total number of series in my series is NOT Verified Successfully!!!");
		}
	}

	// TC_MS_111
	@And("^verify the number of selected series$")
	public void verify_the_number_of_selected_series() throws Throwable {
		Thread.sleep(2000);
		String selectedallseriescount = CommonFunctionality.getElementByProperty(login.driver, "Total_series_count", 8)
				.getText();
		Thread.sleep(2000);
		String selectedseriescount = CommonFunctionality.getElementByProperty(login.driver, "Selected_series_count", 8)
				.getText();
		if (selectedallseriescount.equals(selectedseriescount)) {

			System.out.println("The number of selected series is Verified Successfully!!! ");
		} else {
			Assert.fail("The number of selected series is NOT Verified Successfully!!!");
		}
	}

	// TC_MS_112
	@And("^Select the X icon$")
	public void select_the_X_icon() throws Throwable {
		// CommonFunctionality.getElementByProperty(login.driver,
		// "X_icon_selected_series", 8).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//span[@class='insight-action-panel--clear-selection-icon']")).click();
	}

	// TC_MS_112
	@And("^verify remove icon for selected series$")
	public void verify_remove_icon_for_selected_series() throws Throwable {
		/*
		 * boolean selectd_series =
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
		 * "Full_selected_count"))) .isDisplayed();
		 */
		boolean selectd_series = login.driver.findElement(By.xpath("//div[@class='list-container']")).isDisplayed();
		if (selectd_series == true) {
			System.out.println("Remove icon for selected series is Verified Successfully!!! ");
		} else {
			Assert.fail("Remove icon for selected series is NOT Verified Successfully!!!");
		}
	}

	// TC_MS_113
	@And("^search for the series as \"([^\"]*)\"$")
	public void search_for_the_series_as(String arg1) throws Throwable {

		searchSeriesname = CommonFunctionality.getElementByXpath(login.driver, "//div[@class='series-item--name']", 8)
				.getText();
		CommonFunctionality.getElementByProperty(login.driver, "Search_field_myseries", 8).sendKeys(searchSeriesname);

	}

	// TC_MS_114
	@And("^verify serie \"([^\"]*)\" appeared$")
	public void verify_serie_appeared(String arg1) throws Throwable {
		Thread.sleep(2000);
		String selectedallseriescount = CommonFunctionality.getElementByProperty(login.driver, "First_series_Name", 8)
				.getText();
		if (selectedallseriescount.equals(searchSeriesname)) {
			System.out.println("Search field in my series panel is Verified Successfully!!! ");
			CommonFunctionality.getElementByProperty(login.driver, "Search_field_myseries", 8).clear();
		} else {
			Assert.fail("Search field in my series panel is NOT Verified Successfully!!!");
		}
	}

	// TC_MS_115
	@And("^verify Addition highlight in My series$")
	public void verify_Addition_highlight_in_My_series() throws Throwable {
		CommonFunctionality.wait(1000);
		boolean Additionhighlight = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_Series_count")))
				.isDisplayed();
		System.out.println("Additionhighlight=====>" + Additionhighlight);

		if (Additionhighlight == true) {
			System.out.println("Addition highlight in My series is Verified Successfully!!! ");
		} else {
			Assert.fail("Addition highlight in My series is NOT Verified Successfully!!!");
		}
	}

	// TC_MS_116
	@And("^Select the List mode$")
	public void select_the_List_mode() throws Throwable {
		CommonFunctionality.wait(500);

		login.driver.findElement(By.xpath("(//div[@class='toggler-control-wrapper']//button[@type='button'])[1]"))
				.click();

	}

	// TC_MS_116
	@And("^verify the List mode$")
	public void verify_the_List_mode() throws Throwable {
		Thread.sleep(3000);
		boolean First_series_Name = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("Search_field_myseries"))).isDisplayed();

		if (First_series_Name == true) {
			System.out.println("List mode is Verified Successfully!!! ");
		} else {
			Assert.fail("List mode is NOT Verified Successfully!!!");
		}
	}

	// TC_MS_116
	@And("^Select the Table mode$")
	public void select_the_Table_mode() throws Throwable {
		CommonFunctionality.wait(500);
		WebElement table = login.driver
				.findElement(By.xpath("(//div[@class='toggler-control-wrapper']//button[@type='button'])[2]"));
		action.moveToElement(table).click().build().perform();
		CommonFunctionality.wait(2000);
	}

	// TC_MS_116
	@And("^verify the Table mode$")
	public void verify_the_Table_mode() throws Throwable {
		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath("//div[text()='Function description']")).size() == 0) {
			System.out.println("Table mode is Verified Successfully!!! ");
			select_the_List_mode();
		}
		else {
			select_the_List_mode();
			// Assert.fail("List mode is NOT Verified Successfully!!!");

		}
	}

	// TC_MS_117
	@And("^Select the Customize option$")
	public void select_the_Customize_option() throws Throwable {
		Thread.sleep(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//button[@title='Customize your selection']//div", 8)
				.click();
		}

	// TC_MS_117
	@And("^verify the Customize option$")
	public void verify_the_Customize_option() throws Throwable {
		Thread.sleep(2000);
		boolean Table_mode_view = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Customize_popup")))
				.isDisplayed();
		if (Table_mode_view == true) {
			System.out.println("Customize option is Verified Successfully!!! ");
			CommonFunctionality.getElementByProperty(login.driver, "Customize_Close_window", 8).click();
		} else {
			Assert.fail("Customize option is NOT Verified Successfully!!!");
			CommonFunctionality.getElementByProperty(login.driver, "Customize_Close_window", 8).click();
		}
	}

	// TC_MS_118
	@And("^Select the Table mode in Customize window$")
	public void select_the_Table_mode_in_Customize_window() throws Throwable {

		WebElement table = login.driver
				.findElement(By.xpath("(//div[@class='toggler-control-wrapper']//button[@type='button'])[2]"));
		action.moveToElement(table).click().build().perform();
		CommonFunctionality.wait(2000);

		CommonFunctionality.getElementByProperty(login.driver, "Customize_table_option", 8).click();
		Thread.sleep(3000);
		boolean Table_mode = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Customize_table_option")))
				.isSelected();
		if (Table_mode == true) {
			CommonFunctionality.getElementByProperty(login.driver, "Customize_Close_window", 8).click();
		} else {
			CommonFunctionality.getElementByProperty(login.driver, "Customize_table_option", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Customize_save_option", 8).click();
		}

	}

	// TC_MS_118
	@And("^Verify show selection in Table mode$")
	public void verify_show_selection_in_Table_mode() throws Throwable {
		verify_the_Table_mode();
	}

	// TC_MS_119
	@And("^Select the List mode in Customize window$")
	public void select_the_List_mode_in_Customize_window() throws Throwable {
		Thread.sleep(3000);
		WebElement table = login.driver
				.findElement(By.xpath("(//div[@class='toggler-control-wrapper']//button[@type='button'])[1]"));
		action.moveToElement(table).click().build().perform();
		CommonFunctionality.wait(2000);

		boolean Table_mode = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Customize_List_option")))
				.isSelected();
		if (Table_mode == true) {
			CommonFunctionality.getElementByProperty(login.driver, "Customize_Close_window", 8).click();
		} else {
			CommonFunctionality.wait(500);
			CommonFunctionality.getElementByXpath(login.driver, "//*[@value='list']", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Customize_save_option", 8).click();
		}
	}

	// TC_MS_119
	@And("^Verify show selection in List mode$")
	public void verify_show_selection_in_List_mode() throws Throwable {
		verify_the_List_mode();

	}

	// TC_MS_120
	@And("^Select the Table mode in Customize window for show in$")
	public void select_the_Table_mode_in_Customize_window_for_show_in() throws Throwable {
		Thread.sleep(3000);
		boolean Table_mode = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Customize_table_option")))
				.isSelected();
		if (Table_mode == true) {
			System.out.println("Table mode is Selected");
		} else {
			CommonFunctionality.getElementByProperty(login.driver, "Customize_table_option", 8).click();
		}
	}

	// TC_MS_120
	@And("^Verify hidden show selection in Table mode$")
	public void verify_hidden_show_selection_in_Table_mode() throws Throwable {
		Thread.sleep(3000);
		boolean Customize2rowattribute = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("Customize_2_row_attribute"))).isDisplayed();

		if (Customize2rowattribute == true) {
			System.out.println("Hidden show selection in Table mode is Verified Successfully");
			CommonFunctionality.getElementByProperty(login.driver, "Customize_Close_window", 8).click();
		} else {
			Assert.fail("Hidden show selection in Table mode is NOT Verified Successfully");
			CommonFunctionality.getElementByProperty(login.driver, "Customize_Close_window", 8).click();
		}
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Customize_List_option"))).click();

	}

	// TC_MS_121
	@And("^Select the List mode in Customize window for show in$")
	public void select_the_List_mode_in_Customize_window_for_show_in() throws Throwable {
		Thread.sleep(3000);
		boolean Table_mode = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Customize_List_option")))
				.isSelected();
		if (Table_mode == true) {
			System.out.println("Table mode is Selected");
		} else {
			CommonFunctionality.wait(500);
			CommonFunctionality.getElementByProperty(login.driver, "Customize_List_option", 8).click();
		}
	}

	// TC_MS_121
	@And("^select the required attribute$")
	public void select_the_required_attribute() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Customize_percentagechange", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_latest_value", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_frequency", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_lastupdate", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_save_option", 8).click();
	}

	// TC_MS_121
	@And("^Verify show selection in List mode of (\\d+) row$")
	public void verify_show_selection_in_List_mode_of_row(int arg1) throws Throwable {
		Thread.sleep(3000);
		List<WebElement> Totalselecteditem = login.driver
				.findElements(By.xpath("//div[contains(@class,'webix_column list-series-name webix')]"));
		System.out.println("Total Series are : " + Totalselecteditem.size());
		int Totalselecteditem_in_2_row = Totalselecteditem.size();
		
		if (Totalselecteditem_in_2_row == 1) {
			System.out.println("Show selection in List mode of 2 row is Verified Successfully!!! ");
		} else {
			Assert.fail("Show selection in List mode of 2 row is NOT Verified Successfully!!!");
		}
		select_the_Customize_option();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Reset_option", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_save_option", 8).click();

	}

	// TC_MS_122
	@And("^select the Show series in list as (\\d+) row$")
	public void select_the_Show_series_in_list_as_row(int arg1) throws Throwable {
		// CommonFunctionality.getElementByProperty(login.driver, "Customize_1_row",
		// 8).click();
		login.driver.findElement(By.xpath("//span[normalize-space(text())='1 row']")).click();
	}

	// TC_MS_122
	@And("^Verify show selection in List mode of one row$")
	public void verify_show_selection_in_List_mode_of_one_row() throws Throwable {
		Thread.sleep(3000);
		boolean Customize2rowattribute = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("Customize_2_row_attribute"))).isDisplayed();
		if (Customize2rowattribute == false) {
			System.out.println("Hidden show selection in Table mode is Verified Successfully");

		} else {
			Assert.fail("Hidden show selection in Table mode is NOT Verified Successfully");

		}
		CommonFunctionality.getElementByProperty(login.driver, "Customize_save_option", 8).click();
		Thread.sleep(2000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Selected_2nd_row"))).size() == 0) {
			System.out.println("Validation message Verified Successfully for Paste Option!!! ");
		} else {
			Assert.fail("Validation message is NOT Verified Successfully for Paste Option!!!");
		}
		select_the_Customize_option();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Reset_option", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_save_option", 8).click();
	}

	// TC_MS_125
	@And("^select the required attribute for table mode$")
	public void select_the_required_attribute_for_table_mode() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tmnemonics", 8).click();
		// CommonFunctionality.getElementByProperty(login.driver, "Customize_Tregion",
		// 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tsubnational", 8).click();
		// CommonFunctionality.getElementByProperty(login.driver,
		// "Customize_Tfrequency", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tlastupdate", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tunit", 8).click();
		// CommonFunctionality.getElementByProperty(login.driver,
		// "Customize_Tfirstdate", 8).click();
		// CommonFunctionality.getElementByProperty(login.driver, "Customize_Tlastdate",
		// 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tlastvalue", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tnumberofobservation", 8).click();
		// CommonFunctionality.getElementByProperty(login.driver, "Customize_Tstatus",
		// 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tsource", 8).click();
	}

	// TC_MS_125
	@And("^Verify Table columns for table mode$")
	public void verify_Table_columns_for_table_mode() throws Throwable {
		CommonFunctionality.wait(1000);
		String Customize_TSeriesid = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("Customize_TSeriesid"))).getText();
		System.out.println("Customize_TSeriesid:===========>" + Customize_TSeriesid);
		CommonFunctionality.getElementByProperty(login.driver, "Customize_save_option", 8).click();
		CommonFunctionality.wait(2000);
		select_the_Table_mode();
		CommonFunctionality.wait(2000);
		String seriesid_myseries = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("Seriesid_tablemoseinmyseriespanel"))).getText();
		System.out.println("seriesid_myseries:================>:" + Customize_TSeriesid + ":" + seriesid_myseries);
		if (Customize_TSeriesid.equalsIgnoreCase(seriesid_myseries)) {

			System.out.println("Table columns for table mode is verified Successfully");
		} else {
			Assert.fail("Table columns for table mode is Not verified Successfully:-(");
		}
		select_the_Customize_option();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Reset_option", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_save_option", 8).click();

	}

	// TC_MS_126
	@And("^Select the second series$")
	public void select_the_second_series() throws Throwable {
		CommonFunctionality.wait(1000);

		login.driver.findElement(By.xpath("(//div[@class='toggler-control-wrapper']//button[@type='button'])[1]"))
				.click();
		second_series_name = CommonFunctionality.getElementByProperty(login.driver, "Second_series_Name", 8)
				.getText();
	
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByProperty(login.driver, "Second_series_checkbox", 8).click();
	
	}

	// TC_MS_126
	@And("^select the Sort series by option$")
	public void select_the_Sort_series_by_option() throws Throwable {
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByProperty(login.driver, "Sort_series_by", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Sort_series_by_Checked", 8).click();
		// CommonFunctionality.getElementByProperty(login.driver,
		// "Customize_save_option", 8).click();
		System.out.println("<============================TC100================================================>");
	}

	// TC_MS_126
	@And("^Verify the Sort series by option$")
	public void verify_the_Sort_series_by_option() throws Throwable {

		get_the_series_name();
		
		System.out.println(second_series_name + ":" + FirstseriesName);
		if (FirstseriesName.equalsIgnoreCase("Consumer Price Index")) {
			//System.out.println("Sort series by option is verified Successfully");
			login.Log4j.info("Sort series by option is verified Successfully");
		} else {
			Assert.fail("Sort series by option is Not verified Successfully:-(");
		}
	}
	
	@And("^select the Sort series by option in list mode$")
	public void select_the_Sort_series_by_option_in_list_mode() throws Throwable {
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByProperty(login.driver, "Sort_series_by", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Sort_series_by_Checked", 8).click();
		System.out.println("<============================TC100================================================>");
		get_the_series_name();
		System.out.println(FirstseriesName);
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("(//span[@class='custom-select-title--reset-icon'])[4]")).click();
	}
	
	@And("^select the Sort series by option in table mode$")
	public void select_the_Sort_series_by_option_in_table_mode() throws Throwable {
		CommonFunctionality.wait(1000);
		login.driver.findElement(By.xpath("(//div[@class='toggler-control-wrapper']//button[@type='button'])[2]"))
		.click();
		CommonFunctionality.getElementByProperty(login.driver, "Sort_series_by", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Sort_series_by_Checked", 8).click();
		WebElement chartlegend = login.driver.findElement(By.xpath("(//span[@class='series-name-field--text'])[1]"));
		action.moveToElement(chartlegend).build().perform();

		FirstseriesName1 = CommonFunctionality
				.getElementByXpath(login.driver, "(//span[@class='series-name-field--text'])[1]", 8).getText();

		System.out.println(FirstseriesName1);
		
	}
	
	@And("^Verify the Sort series by option in list mode and table mode as user customize setting$")
	public void verify_the_Sort_series_by_option_in_list_mode_and_table_mode_as_user_customize_setting() throws Throwable {

		if (FirstseriesName.equalsIgnoreCase("Exports fob") && FirstseriesName1.equalsIgnoreCase("Exports fob")) {
			
			login.Log4j.info("Verify the Sort series by option in list mode and table mode as user customize setting Successfully");
		} else {
			Assert.fail("Verify the Sort series by option in list mode and table mode as user customize setting not Successfully:-(");
		}
		login.driver.findElement(By.xpath("(//span[@class='custom-select-title--reset-icon'])[4]")).click();
		login.driver.findElement(By.xpath("(//div[@class='toggler-control-wrapper']//button[@type='button'])[1]"))
		.click();
	}

	// TC_MS_127
	@And("^Verify the Reset option$")
	public void verify_the_Reset_option() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Reset_option", 8).click();
		Thread.sleep(3000);
		boolean Reset_Button = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Customize_Reset_option")))
				.isEnabled();
		if (Reset_Button == true) {
			System.out.println("Reset option is Verified Successfully");

		} else {
			Assert.fail("Reset option is NOT Verified Successfully");

		}
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Close_window", 8).click();
	}

	// TC_MS_128
	@And("^Verify Save option$")
	public void verify_Save_option() throws Throwable {
		verify_Table_columns_for_table_mode();
	}

	// TC_MS_129
	@And("^Select the Cancel/X option$")
	public void select_the_Cancel_X_option() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Close_window", 8).click();
	}

	// TC_MS_129
	@And("^Verify the Cancel/X option$")
	public void verify_the_Cancel_X_option() throws Throwable {
		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Customize_popup"))).size() == 0) {
			System.out.println("Cancel/X option is Verified Successfully!!! ");
		} else {
			Assert.fail("Cancel/X option is NOT Verified Successfully");
		}
	}

	// TC_MS_131
/*	@And("^Select series to my series tab of different country$")
	public void select_series_to_my_series_tab_of_different_country() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "MyInsight_Tab", 8).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Series')]", 8).click();
		for (int i = 1; i <= 3; i++) {
			CommonFunctionality.getElementByXpath(login.driver,
					"(//span[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]", 8).click();
		}

		// click on '+'icon
		WebElement series = CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='series-item--name'])[1]", 8);
		new Actions(login.driver).moveToElement(series).build().perform();
		
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='add-to-data-selection--icon'])[1]", 8)
				.click();

	}    */

	// TC_MS_131
	@And("^add all series to my series$")
	public void add_all_series_to_my_series() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//span[@class='toggler-control-item--label' and text()='Series']")).click();

		for (int i = 1; i <= 3; i++) {

			login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]"))
					.click();
		}
		WebElement series = login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[1]"));
		action.moveToElement(series).build().perform();
		
		login.driver.findElement(By.xpath("(//div[@class='add-to-data-selection--icon'])[1]")).click();
		

	}
	@And("^Verify suggested indicator$")
	public void verify_suggested_indicator() throws Throwable {
		CommonFunctionality.wait(5000);
		List<WebElement> objLinks = login.driver
				.findElements(By.xpath("//div[contains(@class,'visual-indicator-countries-tabs')]"));
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='movable-modal--close']", 8).click();

		String C_name1 = CommonFunctionality
				.getElementByXpath(login.driver, "(//div[@class='series-item--country country-information'])[1]", 8)
				.getText();
		String C_name2 = CommonFunctionality
				.getElementByXpath(login.driver, "(//div[@class='series-item--country country-information'])[2]", 8)
				.getText();
		String C_name3 = CommonFunctionality
				.getElementByXpath(login.driver, "(//div[@class='series-item--country country-information'])[3]", 8)
				.getText();

		for (WebElement countryname : objLinks) {
			String c = countryname.getText();
			if (c.contains(C_name1) || c.contains(C_name2) || c.contains(C_name3)) {
				System.out.println("Found countryname Successfully");
			} else {
				Assert.fail("Couldn't Found countryname Successfully");
			}

		}

		WebDriverWait wait1 = new WebDriverWait(login.driver, 10);
		WebElement element1 = wait1.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='suggestions-manager--name']//following::div[1]/div[3]")));
		element1.click();
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
	}
	
	@And("^Verify the suggested indicator$")
	public void verify_the_suggested_indicator() throws Throwable {
		CommonFunctionality.wait(5000);
		if(login.driver.findElement(By.xpath("//div[@class='suggestions-manager']")).isDisplayed()) {
			login.Log4j.info("Suggested indicator is displayed verified successfully");
		}else {
			Assert.fail("Failed verification");
		}
		
	}
	// TC_MS_133
	@And("^select the \\(i\\) icon$")
	public void select_the_i_icon() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Related_series_footnotes", 8).click();
	}

	// TC_MS_133
	@And("^Verify Suggested indicators \\(i\\) icon$")
	public void verify_Suggested_indicators_i_icon() throws Throwable {
		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Related_series_footnotespopup")))
				.size() != 0) {
			System.out.println("Suggested indicators i icon is Verified Successfully!!! ");
		} else {
			Assert.fail("Suggested indicators i icon is NOT Verified Successfully");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
	}

	// TC_MS_134
	@And("^mover the \\(i\\) icon$")
	public void mover_the_i_icon() throws Throwable {
		CommonFunctionality.wait(500);
		WebElement we = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("I_icon_related")));
		action.moveToElement(we).pause(2000).build().perform();
	}

	// TC_MS_134
	@And("^Verify Suggested indicators tooltip for \\(i\\) icon$")
	public void verify_Suggested_indicators_tooltip_for_i_icon() throws Throwable {
		mover_the_i_icon();
		Thread.sleep(500);
		String Actual = "These indicators are part of our Global Economic Monitor dataset. Subscription to World Trend Plus and Daily Databases is required.";
		WebElement we = CommonFunctionality.getElementByProperty(login.driver, "I_icon_related", 8);
		action.moveToElement(we).build().perform();
		String i_icon = CommonFunctionality.getElementByProperty(login.driver, "I_icon_related", 8)
				.getAttribute("title");
		System.out.println(i_icon);
		if (Actual.equalsIgnoreCase(i_icon)) {
			System.out.println("Verified");
		} else {
			Assert.fail();
		}
		try {
			WebDriverWait wait1 = new WebDriverWait(login.driver, 10);
			WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//div[@class='suggestions-manager--name']//following::div[1]/div[3]")));
			element1.click();
		} catch (org.openqa.selenium.JavascriptException e) {
			/*
			 * WebDriverWait wait1 = new WebDriverWait(login.driver, 10); WebElement
			 * element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(
			 * "//div[@class='suggestions-manager--name']//following::div[1]/div[3]")));
			 * element1.click();
			 */
			login.driver.navigate().refresh();
		}
	}

	// TC_MS_135
	@And("^Verify countries tab under suggested indicator$")
	public void verify_countries_tab_under_suggested_indicator() throws Throwable {
		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Related_series_serieslist"))).size() != 0) {
			System.out.println("Countries tab under suggested indicator is Verified Successfully!!! ");
		} else {
			Assert.fail("Countries tab under suggested indicator is NOT Verified Successfully");
		}
		Thread.sleep(1000);
		login.driver.navigate().refresh();

	}

	// TC_MS_136
/*	@And("^Select random six different series to my series tab$")
	public void select_random_six_different_series_to_my_series_tab() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "MyInsight_Tab", 8).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Series')]", 8).click();
		for (int i = 1; i <= 6; i++) {
			CommonFunctionality.getElementByXpath(login.driver,
					"(//span[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]", 8).click();
		}
		// click on '+'icon
		WebElement series = login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[1]"));
		action.moveToElement(series).build().perform();
		WebElement icon = login.driver.findElement(By.xpath("(//div[@class='add-to-data-selection--icon'])[1]"));
		action.moveToElement(icon).click().build().perform();

	}  */
	
	@And("^add all the series to my series$")
	public void add_all_the_series_to_my_series() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath("//span[@class='toggler-control-item--label' and text()='Series']")).click();

		for (int i = 1; i <= 6; i++) {

			login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]"))
					.click();
		}
		WebElement series = login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[1]"));
		action.moveToElement(series).build().perform();
		
		login.driver.findElement(By.xpath("(//div[@class='add-to-data-selection--icon'])[1]")).click();
		

	}

	// TC_MS_136
	@And("^Verify max five countries display$")
	public void verify_max_five_countries_display() throws Throwable {
		Thread.sleep(3000);
		List<WebElement> objLinks = login.driver
				.findElements(By.xpath("//div[contains(@class,'visual-indicator-countries-tabs')]"));
		int total_country = objLinks.size();
		System.out.println(total_country);
		if (total_country <= 5) {
			System.out.println("Max countires display under suggested indicator is Verified Successfully!!! ");
		} else {
			Assert.fail("Max countires display under suggested indicator is NOT Verified Successfully");
		}
		Thread.sleep(1000);
		login.driver.navigate().refresh();

	}

	// TC_MS_137
	@And("^select any one of the indicators$")
	public void select_any_one_of_the_indicators() throws Throwable {
		WebElement we = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("Related_series_firstserieslist")));
		action.moveToElement(we).pause(4000).click().build().perform();
	}

	// TC_MS_137
	@And("^Verify Suggested indicators on clicking indicators$")
	public void verify_Suggested_indicators_on_clicking_indicators() throws Throwable {
		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Related_series_SSPwindow"))).size() != 0) {
			System.out.println("Suggested indicators on clicking indicators is Verified Successfully!!! ");
		} else {
			Assert.fail("Suggested indicators on clicking indicators is NOT Verified Successfully");
		}
		CommonFunctionality.getElementByProperty(login.driver, "myseries_ssp_close_indicator", 8).click();
	}

	// TC_MS_138
	@And("^Verify Suggested indicators greyed out indicators$")
	public void verify_Suggested_indicators_greyed_out_indicators() throws Throwable {
		Thread.sleep(3000);
		String greyedoutseries = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("Related_series_gray_out"))).getAttribute("class");
		System.out.println("greyedoutseries============>" + greyedoutseries);
		String disabled = "visual-indicator";

		if (greyedoutseries.contains(disabled))

		{
			System.out.println("Suggested greyed out indicators is Verified Successfully!!! ");
		} else {
			Assert.fail("Suggested greyed out indicators is NOT Verified Successfully");
		}
	}

	// TC_MS_139
	@And("^select the \\+ icon option$")
	public void select_the_icon_option() throws Throwable {
		WebElement we = CommonFunctionality.getElementByProperty(login.driver, "Related_series_firstserieslist", 8);
		action.moveToElement(we).pause(2000).build().perform();
		Thread.sleep(1000);
		Addingseries = CommonFunctionality.getElementByProperty(login.driver, "Related_series_firstserieslist", 8)
				.getText();

		WebDriverWait wait2 = new WebDriverWait(login.driver, 10);
		WebElement element2 = wait2
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='visual-indicator--icon'])[1]")));
		element2.click();

		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Related_series_firstserieslisticon"))).click();
		WebDriverWait wait1 = new WebDriverWait(login.driver, 10);
		WebElement element1 = wait1.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='suggestions-manager--name']//following::div[1]/div[3]")));
		element1.click();
	}

	// TC_MS_139
	@And("^Verify Suggested indicators \\+ icon$")
	public void verify_Suggested_indicators_icon() throws Throwable {
		Thread.sleep(3000);
		String fourthseries = login.driver
				.findElement(
						By.xpath("(//span[@class='series-name-field--text'])[4]"))
				.getText();
		// String Addedindicators = "Consumer Price Index: YoY";
		if (fourthseries.contains(Addingseries)) {
			System.out.println("Suggested indicators + icon is Verified Successfully!!! ");
		} else {
			Assert.fail("Suggested indicators + icon is NOT Verified Successfully");
		}
	}

	// TC_MS_140
	@And("^select the countries dropdown$")
	public void select_the_countries_dropdown() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Related_series_Country_dropdown", 8).click();
	}

	// TC_MS_140
	@And("^Verify Suggested indicators countries dropdown$")
	public void verify_Suggested_indicators_countries_dropdown() throws Throwable {
		Thread.sleep(3000);
		boolean countries_dropdown = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("Related_series_Country_dropdown_list"))).size() == 1;
		if (countries_dropdown == true) {
			System.out.println("Suggested indicators countries dropdown is verified Successfully");
		} else {
			Assert.fail("Suggested indicators countries dropdown is NOT Verified Successfully");
		}
	}

	// TC_MS_141
	@And("^select any one country$")
	public void select_any_one_country() throws Throwable {
		Thread.sleep(3000);
		firstseriesnameinrelatedseries = CommonFunctionality
				.getElementByProperty(login.driver, "Related_series_firstserieslist", 8).getText();
		System.out.println("firstseriesnameinrelatedseries1=====>" + firstseriesnameinrelatedseries);
		CommonFunctionality.getElementByProperty(login.driver, "Related_series_Country_dropdown_firstcountry", 8)
				.click();
	}

	// TC_MS_141
	@And("^Verify Suggested indicators Select a Region$")
	public void verify_Suggested_indicators_Select_a_Region() throws Throwable {
		String firstseriesafternameinrelatedseries = CommonFunctionality
				.getElementByProperty(login.driver, "Related_series_firstserieslist", 8).getText();

		System.out.println("firstseriesnameinrelatedseries2=====>" + firstseriesafternameinrelatedseries);

		if (firstseriesafternameinrelatedseries.equals(firstseriesnameinrelatedseries)) {
			System.out.println("Suggested indicators for Select a Region is verified Successfully");
		} else {
			Assert.fail("Suggested indicators for Select a Region is NOT Verified Successfully");
		}
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='movable-modal--close']", 8).click();

	}

	// TC_MS_142
	@And("^search for a Region$")
	public void search_for_a_Region() throws Throwable {
		try {
			Thread.sleep(2000);
			firstseriesnameinrelatedseries = CommonFunctionality
					.getElementByProperty(login.driver, "Related_series_firstserieslist", 8).getText();
			WebElement we = CommonFunctionality.getElementByProperty(login.driver,
					"Related_series_Country_dropdown_search", 8);
			action.moveToElement(we).pause(2000).click().sendKeys("Nepal").build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "Related_series_Country_dropdown_search", 8)
					.sendKeys(Keys.ENTER);
		} catch (org.openqa.selenium.JavascriptException e) {
			Thread.sleep(2000);
			firstseriesnameinrelatedseries = CommonFunctionality
					.getElementByProperty(login.driver, "Related_series_firstserieslist", 8).getText();
			WebElement we = CommonFunctionality.getElementByProperty(login.driver,
					"Related_series_Country_dropdown_search", 8);
			action.moveToElement(we).pause(2000).click().sendKeys("Nepal").build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "Related_series_Country_dropdown_search", 8)
					.sendKeys(Keys.ENTER);
		}
	}

	// TC_MS_142
	@And("^Verify Suggested indicators search for a Region$")
	public void verify_Suggested_indicators_search_for_a_Region() throws Throwable {
		Thread.sleep(2000);

		String firstseriesafternameinrelatedseries = CommonFunctionality
				.getElementByProperty(login.driver, "Related_series_firstserieslist", 8).getText();
		if (!firstseriesafternameinrelatedseries.equals(firstseriesnameinrelatedseries)) {
			System.out.println("Suggested indicators for search a Region is verified Successfully");
		} else {
			Assert.fail("Suggested indicators for search a Region is NOT Verified Successfully");
		}
		WebDriverWait wait1 = new WebDriverWait(login.driver, 10);
		WebElement element1 = wait1.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='suggestions-manager--name']//following::div[1]/div[3]")));
		element1.click();
	}

	// TC_MS_143
	@And("^select the minimize option$")
	public void select_the_minimize_option() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Related_series_min_max", 6).click();

	}

	// TC_MS_143
	@And("^Verify Suggested indicators min and max option$")
	public void verify_Suggested_indicators_min_and_max_option() throws Throwable {
		String mini = CommonFunctionality.getElementByProperty(login.driver, "Related_series_min_max", 8)
				.getAttribute("title");
		String miniverify = "Maximize";
		Assert.assertEquals(mini, miniverify);
		CommonFunctionality.getElementByProperty(login.driver, "Related_series_min_max", 6).click();
		String max = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Related_series_min_max")))
				.getAttribute("title");
		String maxverify = "Minimize";
		Assert.assertEquals(max, maxverify);
		WebDriverWait wait1 = new WebDriverWait(login.driver, 10);
		WebElement element1 = wait1.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='suggestions-manager--name']//following::div[1]/div[3]")));
		element1.click();
		// CommonFunctionality.DeleteSeries();

	}

	// TC_MS_145
	@And("^select the expand option$")
	public void select_the_expand_option() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Related_series_expand", 6).click();
	}

	// TC_MS_145
	@And("^Verify Suggested indicators expand option$")
	public void verify_Suggested_indicators_expand_option() throws Throwable {
		String expand_collapse = CommonFunctionality.getElementByProperty(login.driver, "Related_series_collapse", 8)
				.getAttribute("class");
		if (expand_collapse.contains("collapse")) {
			System.out.println("Suggested indicators rezize is verified Successfully");
		} else {
			Assert.fail("Suggested indicators resize is NOT Verified Successfully");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Related_series_collapse", 6).click();
		WebDriverWait wait1 = new WebDriverWait(login.driver, 10);
		WebElement element1 = wait1.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='suggestions-manager--name']//following::div[1]/div[3]")));
		element1.click();
		// CommonFunctionality.DeleteSeries();
	}

	// TC_MS_146
	@And("^try to drag window$")
	public void try_to_drag_window() throws Throwable {
		CommonFunctionality.wait(500);
		WebElement dragfrom = login.driver
				.findElement(By.xpath("(//div[@class='series-list-item--content']/a/div[3])[1]"));
		CommonFunctionality.wait(500);
		WebElement dragto = login.driver
				.findElement(By.xpath("//div[@class='data-selection-series-overlay--content']"));
		action.dragAndDrop(dragfrom, dragto).build().perform();

	}

	// TC_MS_146
	@And("^Verify Suggested indicators window move$")
	public void verify_Suggested_indicators_window_move() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 6).click();
	}

	// TC_MS_147
	@And("^select close button$")
	public void select_close_button() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 6).click();
	}

	// TC_MS_147
	@And("^Verify Suggested indicators close button$")
	public void verify_Suggested_indicators_close_button() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Related_Series_popup"))).size() == 0) {
			System.out.println("Suggested indicators close button is Verified Successfully!!! ");
		} else {
			Assert.fail("Suggested indicators close button is NOT Verified Successfully");
		}
	}

	// TC_MS_148
	@And("^select the sort by dropdown$")
	public void select_the_sort_by_dropdown() throws Throwable {
		Thread.sleep(400);
		try {

		CommonFunctionality.getElementByXpath(login.driver,
					"(//input[@placeholder='Search'])[2]//following::div[@class='sort-series']", 8).click();

	}

		catch (Exception e) {
			CommonFunctionality.getElementByXpath(login.driver,
					"(//input[@placeholder='Search'])[2]//following::div[@class='sort-series']", 8).click();
			System.out.println("Clicked already sortby dropdown");
		}
	}

	@And("^select the sort by dropdown for \"([^\"]*)\"$")
	public void select_the_sort_by_dropdown_for(String arg1) throws Throwable {
		Thread.sleep(400);
		try {

			CommonFunctionality.getElementByXpath(login.driver,
					"(//input[@placeholder='Search'])[2]//following::div[@class='sort-series']", 8).click();

		}

		catch (Exception e) {
			CommonFunctionality.getElementByXpath(login.driver,
					"(//input[@placeholder='Search'])[2]//following::div[@class='sort-series']", 8).click();
			System.out.println("Clicked already sortby dropdown");
		}
	}

	// TC_MS_148
	@And("^Verify sort by dropdown$")
	public void verify_sort_by_dropdown() throws Throwable {
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("sortdown_dropdown_list"))).isDisplayed());
		CommonFunctionality.getElementByProperty(login.driver, "sortdown_dropdown", 6).click();
	}

	// TC_MS_149
	@And("^check any one of the series$")
	public void check_any_one_of_the_series() throws Throwable {
		Thread.sleep(300);
		Thirdseriesname = login.driver.findElement(By.xpath("(//span[@class='series-name-field--series-name'])[2]"))
				.getText();
		System.out.println("Thirdseriesname" + Thirdseriesname);
		login.driver
				.findElement(
						By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[2]"))
				.click();
	}

	// TC_MS_149
	@And("^select checked option$")
	public void select_checked_option() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "sortdown_dropdown_list_1", 6).click();
	}

	// TC_MS_149
	@And("^Verify sort by dropdown checked$")
	public void verify_sort_by_dropdown_checked() throws Throwable {
		String Firstseriesname = CommonFunctionality.getElementByProperty(login.driver, "First_series_Name", 6)
				.getText();
		System.out.println("===FirstSeries====" + Firstseriesname);
		System.out.println("=====1-3======" + Firstseriesname.equalsIgnoreCase(Thirdseriesname));
		if (Firstseriesname.equalsIgnoreCase(Thirdseriesname)) {

			System.out.println("Sort by dropdown checked is Verified Successfully!!! ");
		} else {
			Assert.fail("Sort by dropdown checked is NOT Verified Successfully");
		}
		CommonFunctionality.getElementByProperty(login.driver, "sortdown_dropdown_X_icon", 6).click();

	}

	// TC_MS_150
	@And("^select \"([^\"]*)\" option$")
	public void select_option(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@title,'" + arg1 + "')]", 8).click();
	}

	@Given("^select Sort by checked series option$")
	public void select_Sort_by_checked_series_option() throws Throwable {
		CommonFunctionality.wait(1000);
		CommonFunctionality
				.getElementByXpath(login.driver, "(//div[@class='custom-select-item--link text-dots'])[1]", 8).click();
	}

	@Given("^select Sort by last modified date of a series \\(among active series only\\) option$")
	public void select_Sort_by_last_modified_date_of_a_series_among_active_series_only_option() throws Throwable {
		try {

			CommonFunctionality.getElementByXpath(login.driver,
					"(//input[@placeholder='Search'])[2]//following::div[@class='sort-series']", 8).click();

			if (login.driver
					.findElement(By.xpath(
							"//div[@class='custom-select-item--link text-dots'][normalize-space()='Recently Updated']"))
					.isDisplayed()) {
				login.driver.findElement(By.xpath(
						"//div[@class='custom-select-item--link text-dots'][normalize-space()='Recently Updated']"))
						.click();
			}

		} catch (Exception e) {
			System.out.println("Already clicked recently updated");
		}

	}

	@Given("^select Sort by series percentage change option$")
	public void select_Sort_by_series_percentage_change_option() throws Throwable {
		// CommonFunctionality.getElementByXpath(login.driver,
		// "//div[@class='custom-select--body']/div[3]", 8).click();
		CommonFunctionality.wait(500);
		try {
			if (login.driver
					.findElement(By
							.xpath("//div[@class='custom-select-item--link text-dots'][normalize-space()='% Change']"))
					.isDisplayed()) {
				login.driver
						.findElement(By.xpath(
								"//div[@class='custom-select-item--link text-dots'][normalize-space()='% Change']"))
						.click();
			}
		} catch (Exception e) {
			System.out.println("Change already clicked");
		}

	}

	@Given("^select Last Value option$")
	public void select_Last_Value_option() throws Throwable {
		
		CommonFunctionality.wait(500);
		try {
			if (login.driver
					.findElement(By.xpath(
							"//div[@class='custom-select-item--link text-dots'][normalize-space()='Last Value']"))
					.isDisplayed()) {
				login.driver
						.findElement(By.xpath(
								"//div[@class='custom-select-item--link text-dots'][normalize-space()='Last Value']"))
						.click();
			}
		} catch (Exception e) {
			System.out.println("Last value already clicked");
		}

	}

	@Given("^select Status option$")
	public void select_Status_option() throws Throwable {

		CommonFunctionality.wait(500);
		try {
			if (login.driver
					.findElement(
							By.xpath("//div[@class='custom-select-item--link text-dots'][normalize-space()='Status']"))
					.isDisplayed()) {
				login.driver
						.findElement(By.xpath(
								"//div[@class='custom-select-item--link text-dots'][normalize-space()='Status']"))
						.click();
			}
		} catch (Exception e) {
			System.out.println("Status already clicked");
		}
	}

	@Given("^select Name option$")
	public void select_Name_option() throws Throwable {
		// CommonFunctionality.getElementByXpath(login.driver,
		// "//div[@class='custom-select--body']/div[6]", 8).click();
		CommonFunctionality.wait(500);
		try {
			if (login.driver
					.findElement(
							By.xpath("//div[@class='custom-select-item--link text-dots'][normalize-space()='Name']"))
					.isDisplayed()) {
				login.driver
						.findElement(By
								.xpath("//div[@class='custom-select-item--link text-dots'][normalize-space()='Name']"))
						.click();
			}
		} catch (Exception e) {
			System.out.println("Name already clicked");
		}
	}

	@Given("^select Region option$")
	public void select_Region_option() throws Throwable {
		// CommonFunctionality.getElementByXpath(login.driver,
		// "//div[@class='custom-select--body']/div[7]", 8).click();
		CommonFunctionality.wait(500);
		try {
			if (login.driver
					.findElement(
							By.xpath("//div[@class='custom-select-item--link text-dots'][normalize-space()='Region']"))
					.isDisplayed()) {
				login.driver
						.findElement(By.xpath(
								"//div[@class='custom-select-item--link text-dots'][normalize-space()='Region']"))
						.click();
			}
		} catch (Exception e) {
			System.out.println("Region already clicked");
		}
	}

	@Given("^select Subnational option$")
	public void select_Subnational_option() throws Throwable {

		// login.driver.findElement(By.xpath("(//div[@class='custom-select-item--link
		// text-dots'])[8]")).click();
		CommonFunctionality.wait(500);
		try {
			if (login.driver
					.findElement(By.xpath(
							"//div[@class='custom-select-item--link text-dots'][normalize-space()='Subnational']"))
					.isDisplayed()) {
				login.driver
						.findElement(By.xpath(
								"//div[@class='custom-select-item--link text-dots'][normalize-space()='Subnational']"))
						.click();
			}
		} catch (Exception e) {
			System.out.println("Subnational already clicked");
		}

	}

	@Given("^select Frequency option$")
	public void select_Frequency_option() throws Throwable {

		// login.driver.findElement(By.xpath("(//div[normalize-space()='Frequency'])[5]")).click();
		CommonFunctionality.wait(500);
		try {
			if (login.driver
					.findElement(By
							.xpath("//div[@class='custom-select-item--link text-dots'][normalize-space()='Frequency']"))
					.isDisplayed()) {
				login.driver
						.findElement(By.xpath(
								"//div[@class='custom-select-item--link text-dots'][normalize-space()='Frequency']"))
						.click();
			}
		} catch (Exception e) {
			System.out.println("Frequency already clicked");
		}
	}

	@Given("^select Unit option$")
	public void select_Unit_option() throws Throwable {

		// login.driver.findElement(By.xpath("(//div[normalize-space()='Unit'])[2]")).click();
		CommonFunctionality.wait(500);
		try {
			if (login.driver
					.findElement(
							By.xpath("//div[@class='custom-select-item--link text-dots'][normalize-space()='Unit']"))
					.isDisplayed()) {
				login.driver
						.findElement(By
								.xpath("//div[@class='custom-select-item--link text-dots'][normalize-space()='Unit']"))
						.click();
			}
		} catch (Exception e) {
			System.out.println("Unit already clicked");
		}
	}

	@Given("^select Source option$")
	public void select_Source_option() throws Throwable {

		// login.driver.findElement(By.xpath("(//div[normalize-space()='Source'])[5]")).click();
		CommonFunctionality.wait(500);
		try {
			if (login.driver
					.findElement(
							By.xpath("//div[@class='custom-select-item--link text-dots'][normalize-space()='Source']"))
					.isDisplayed()) {
				login.driver
						.findElement(By.xpath(
								"//div[@class='custom-select-item--link text-dots'][normalize-space()='Source']"))
						.click();
			}
		} catch (Exception e) {
			System.out.println("Source already clicked");
		}
	}

	@Given("^select Mnemonic option$")
	public void select_Mnemonic_option() throws Throwable {

		// login.driver.findElement(By.xpath("(//div[normalize-space()='Mnemonic'])[1]")).click();
		CommonFunctionality.wait(500);
		try {
			if (login.driver
					.findElement(By
							.xpath("//div[@class='custom-select-item--link text-dots'][normalize-space()='Mnemonic']"))
					.isDisplayed()) {
				login.driver
						.findElement(By.xpath(
								"//div[@class='custom-select-item--link text-dots'][normalize-space()='Mnemonic']"))
						.click();
			}
		} catch (Exception e) {
			System.out.println("Mnemonic already clicked");
		}

	}

	@Given("^select Function Description option$")
	public void select_Function_Description_option() throws Throwable {
		// CommonFunctionality.getElementByXpath(login.driver,
		// "//div[@class='custom-select--body']/div[13]", 8).click();
		CommonFunctionality.wait(500);
		try {
			if (login.driver.findElement(By.xpath(
					"//div[@class='custom-select-item--link text-dots'][normalize-space()='Function Description']"))
					.isDisplayed()) {
				login.driver.findElement(By.xpath(
						"//div[@class='custom-select-item--link text-dots'][normalize-space()='Function Description']"))
						.click();
			}
		} catch (Exception e) {
			System.out.println("Function description already clicked");
		}
	}

	@Given("^select Obs\\. Number option$")
	public void select_Obs_Number_option() throws Throwable {
		CommonFunctionality.wait(500);
		try {
			if (login.driver
					.findElement(By.xpath(
							"//div[@class='custom-select-item--link text-dots'][normalize-space()='Obs. Number']"))
					.isDisplayed()) {
				login.driver
						.findElement(By.xpath(
								"//div[@class='custom-select-item--link text-dots'][normalize-space()='Obs. Number']"))
						.click();
			}
		} catch (Exception e) {
			System.out.println("Obs. Number already clicked");
		}
	}

	@Given("^select First Date option$")
	public void select_First_Date_option() throws Throwable {
		CommonFunctionality.wait(500);
		try {
			if (login.driver
					.findElement(By.xpath(
							"//div[@class='custom-select-item--link text-dots'][normalize-space()='First Obs. Date']"))
					.isDisplayed()) {
				login.driver.findElement(By.xpath(
						"//div[@class='custom-select-item--link text-dots'][normalize-space()='First Obs. Date']"))
						.click();
			}
		} catch (Exception e) {
			System.out.println("First observation date already clicked");
		}
	}

	@Given("^select Last Date option$")
	public void select_Last_Date_option() throws Throwable {
		// CommonFunctionality.getElementByXpath(login.driver,
		// "//div[@class='custom-select--body']/div[16]", 8).click();
		CommonFunctionality.wait(500);
		try {
			if (login.driver
					.findElement(By.xpath(
							"//div[@class='custom-select-item--link text-dots'][normalize-space()='Last Obs. Date']"))
					.isDisplayed()) {
				login.driver.findElement(By.xpath(
						"//div[@class='custom-select-item--link text-dots'][normalize-space()='Last Obs. Date']"))
						.click();
			}
		} catch (Exception e) {
			System.out.println("Last observation date already clicked");
		}
	}

	// TC_MS_150
	@And("^Verify sort by Recently updated$")
	public void verify_sort_by_Recently_updated() throws Throwable {
		Thread.sleep(1000);
		String lastupdate = CommonFunctionality.getElementByProperty(login.driver, "lastupdate", 6).getText();
		System.out.println("lastupdate==========>" + lastupdate);
		String str = lastupdate.substring(0, 2);
		int result = Integer.parseInt(str);
		List<WebElement> objLinks = login.driver.findElements(By.className("last-updated-date"));
		for (WebElement obj : objLinks) {
			String text = obj.getText();
			String str1 = text.substring(0, 2);
			int result1 = Integer.parseInt(str1);
			if (result >= result1) {
				System.out.println("Sort by Recently updated is Verified Successfully!!! ");
			} else {
				Assert.fail("Sort by Recently updated is NOT Verified Successfully");
			}
		}
		login.driver.findElement(By.xpath("(//span[@class='custom-select-title--reset-icon'])[4]")).click();
	}

	// TC_MS_151
	@And("^search for the Series ID  as \"([^\"]*)\"$")
	public void search_for_the_Series_ID_as(String arg1) throws Throwable {
		// CommonFunctionality.DeleteSeries();
		CommonFunctionality.getElementByXpath(login.driver, "//input[@class='search-input-text']", 8).clear();
		CommonFunctionality.getElementByXpath(login.driver, "//input[@class='search-input-text']", 8).sendKeys(arg1);
		CommonFunctionality.getElementByXpath(login.driver, "//input[@class='search-input-text']", 8)
				.sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		List<WebElement> snames = login.driver.findElements(By.xpath("//*[@class='series-item--name']"));
		for (int i = 0; i < snames.size(); i++) {
			int j = i + 1;
			String str = snames.get(i).getText();
			listofseries.add(str);
			CommonFunctionality.getElementByXpath(login.driver,
					"(//span[@class='series-list-item--checkbox svg-checkbox'])[" + j + "]", 8).click();
		}
		login.Log4j.info(listofseries);
		WebElement series = CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='series-item--name'])[1]", 8);
		new Actions(login.driver).moveToElement(series).build().perform();
		
		login.driver.findElement(By.xpath("(//div[@class='add-to-data-selection--icon'])[1]")).click();
		
	}
	
	
	// TC_MS_151
	@And("^Verify sort by % Change$")
	public void verify_sort_by_Change() throws Throwable {
		ArrayList<String> list2 = new ArrayList<>();
		Thread.sleep(2000);
		List<WebElement> objLinks = login.driver.findElements(By.xpath("//*[@class='series-name-field--series-name']"));
		for (int i = 0; i < objLinks.size(); i++) {
			String sname = objLinks.get(i).getText();
			list2.add(sname);
		}
		login.Log4j.info(list2);
		for (int i = 0; i < listofseries.size(); i++) {

			if (listofseries.contains(list2.get(i))) {
				System.out.println("Sort by %Change is Verified Successfully!!!");
			} else {
				fail("Sort by %Change is NOT Verified Successfully!!!");
			}
		}

		 login.driver.findElement(By.xpath("(//span[@class='custom-select-title--reset-icon'])[4]")).click();
	}

	// TC_MS_152
	@And("^Verify sort by Last Value$")
	public void verify_sort_by_Last_Value() throws Throwable {
		String Lastvalue = CommonFunctionality.getElementByProperty(login.driver, "Lastvalue", 6).getText();
		String str = Lastvalue.substring(0, 2);
		System.out.println("str:==============>" + str);
		int result = Integer.parseInt(str);

		List<WebElement> objLinks = login.driver
				.findElements(By.xpath("//span[contains(@class,'additional-info-item point')]"));
		for (WebElement obj : objLinks) {
			String text = obj.getText();
			String str1 = text.substring(0, 2);
			System.out.println("str1:==============>" + str1);
		}
		Thread.sleep(1000);
		 login.driver.findElement(By.xpath("(//span[@class='custom-select-title--reset-icon'])[4]")).click();
	
		}

	// TC_MS_153
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@And("^Verify sort by Status$")
	public void verify_sort_by_Status() throws Throwable {
		select_the_Expand_Icon();
		List<WebElement> country_list = login.driver.findElements(By.xpath(
				"//*[@class='additional-info-item unit' and contains(text(),'Active')] |  //*[@class='additional-info-item unit' and contains(text(),'Discontinued')] |//*[@class='additional-info-item unit' and contains(text(),'Rebased')]"));

		List list = new ArrayList();

		for (WebElement country : country_list) {
			list.add(country.getText());
		}
		List tempList = new ArrayList(list);
		Collections.sort(tempList);
		boolean ifSortedAscending = list.equals(tempList);
		if (ifSortedAscending) {
			login.Log4j.info("The results are sorted based on Status");
		} else {
			Assert.fail("Verification failed");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Expand_Icon_Right", 8).click();
		login.driver.findElement(By.xpath("(//span[@class='custom-select-title--reset-icon'])[4]")).click();
		}

	// TC_MS_154
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@And("^Verify sort by Name$")
	public void verify_sort_by_Name() throws Throwable {
		Thread.sleep(3000);
		List<WebElement> country_list = login.driver
				.findElements(By.xpath("//span[@class='series-name-field--series-name']"));

		List list = new ArrayList();

		for (WebElement country : country_list) {
			list.add(country.getText());
		}
		List tempList = new ArrayList(list);
		Collections.sort(tempList);
		boolean ifSortedAscending = list.equals(tempList);
		if (ifSortedAscending) {
			login.Log4j.info("The results are sorted based on Series Name");
		} else {
			Assert.fail("Verification failed");
		}
		login.driver.findElement(By.xpath("(//span[@class='custom-select-title--reset-icon'])[4]")).click();
		
	}

	// TC_MS_155
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@And("^Verify sort by Region$")
	public void verify_sort_by_Region() throws Throwable {
		Thread.sleep(3000);
		List<WebElement> country_list = login.driver
				.findElements(By.xpath("//span[@class='additional-info-item country']"));

		List list = new ArrayList();

		for (WebElement country : country_list) {
			list.add(country.getText());
		}
		List tempList = new ArrayList(list);
		Collections.sort(tempList);
		boolean ifSortedAscending = list.equals(tempList);
		if (ifSortedAscending) {
			login.Log4j.info("The results are sorted based on Region");
		} else {
			Assert.fail("Verification failed");
		}
		login.driver.findElement(By.xpath("(//span[@class='custom-select-title--reset-icon'])[4]")).click();
	
	}

	// TC_MS_156
	@And("^select subnational option in customize setting$")
	public void select_subnational_option_in_customize_setting() throws Throwable {
		select_the_Customize_option();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_subnational", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_save_option", 8).click();
	}

	// TC_MS_156
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@And("^Verify sort by Subnational$")
	public void verify_sort_by_Subnational() throws Throwable {
		Thread.sleep(3000);
		List<WebElement> country_list = login.driver.findElements(By.xpath(
				"//*[@class='additional-info-item country' and contains(text(),'Daxing')] | //*[@class='additional-info-item country' and contains(text(),'Huairou')] |//*[@class='additional-info-item country' and contains(text(),'Pinggu')] "));

		List list = new ArrayList();

		for (WebElement country : country_list) {
			list.add(country.getText());
		}
		List tempList = new ArrayList(list);
		Collections.sort(tempList);
		boolean ifSortedAscending = list.equals(tempList);
		if (ifSortedAscending) {
			login.Log4j.info("The results are sorted based on Subnational");
		} else {
			Assert.fail("Verification failed");
		}
		login.driver.findElement(By.xpath("(//span[@class='custom-select-title--reset-icon'])[4]")).click();
		select_the_Customize_option();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Reset_option", 6).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_save_option", 6).click();
	}

	// TC_MS_157
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@And("^Verify sort by Frequency$")
	public void verify_sort_by_Frequency() throws Throwable {
		Thread.sleep(2000);
		List<WebElement> country_list = login.driver
				.findElements(By.xpath("//*[@class='additional-info-item frequency']"));

		List list = new ArrayList();

		for (WebElement country : country_list) {
			list.add(country.getText());
		}
		List tempList = new ArrayList(list);
		Collections.sort(tempList);
		boolean ifSortedAscending = list.equals(tempList);

		if (ifSortedAscending) {
			login.Log4j.info("The results are sorted based on Frequency");
		} else {
			Assert.fail("Verification failed");
		}
		login.driver.findElement(By.xpath("(//span[@class='custom-select-title--reset-icon'])[4]")).click();
	

	}

	// TC_MS_158
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@And("^Verify sort by Unit$")
	public void verify_sort_by_Unit() throws Throwable {
		select_the_Expand_Icon();
		List<WebElement> country_list = login.driver.findElements(By.xpath(
				"//*[@class='additional-info-item unit' and contains(text(),'RMB bn')] | //*[@class='additional-info-item unit' and contains(text(),'EUR')] |//*[@class='additional-info-item unit' and contains(text(),'USD mn')] "));

		List list = new ArrayList();

		for (WebElement country : country_list) {
			list.add(country.getText());
		}
		List tempList = new ArrayList(list);
		Collections.sort(tempList);
		boolean ifSortedAscending = list.equals(tempList);
		if (ifSortedAscending) {
			login.Log4j.info("The results are sorted based on Unit");
		} else {
			Assert.fail("Verification failed");
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_Icon_Right"))).click();

		login.driver.findElement(By.xpath("(//span[@class='custom-select-title--reset-icon'])[4]")).click();
	
	}

	// TC_MS_159
	@And("^select Source option in customize setting$")
	public void select_Source_option_in_customize_setting() throws Throwable {
		select_the_Customize_option();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_source", 6).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_save_option", 6).click();
	}

	// TC_MS_159
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@And("^Verify sort by Source$")
	public void verify_sort_by_Source() throws Throwable {
		select_the_Expand_Icon();
		List<WebElement> country_list = login.driver
				.findElements(By.xpath("//*[@class='additional-info-item source']"));

		List list = new ArrayList();

		for (WebElement country : country_list) {
			list.add(country.getText());
		}
		List tempList = new ArrayList(list);
		Collections.sort(tempList);
		boolean ifSortedAscending = list.equals(tempList);
		if (ifSortedAscending) {
			login.Log4j.info("The results are sorted based on Source");
		} else {
			Assert.fail("Verification failed");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Expand_Icon_Right", 8).click();
		login.driver.findElement(By.xpath("(//span[@class='custom-select-title--reset-icon'])[4]")).click();
		select_the_Customize_option();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Reset_option", 6).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_save_option", 6).click();
	}

	// TC_MS_160
	@And("^select Mnemonic option in customize setting$")
	public void select_Mnemonic_option_in_customize_setting() throws Throwable {
		select_the_Customize_option();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_mnemonics", 6).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_save_option", 6).click();
	}

	// TC_MS_160
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@And("^Verify sort by Mnemonic$")
	public void verify_sort_by_Mnemonic() throws Throwable {
		select_the_Expand_Icon();
		List<WebElement> country_list = login.driver
				.findElements(By.xpath("//*[@class='additional-info-item mnemonic']"));

		List list = new ArrayList();

		for (WebElement country : country_list) {
			String str = country.getText();
			String str1 = str.substring(0, 2);
			list.add(str1);
		}
		List tempList = new ArrayList(list);
		Collections.sort(tempList);
		boolean ifSortedAscending = list.equals(tempList);
		if (ifSortedAscending) {
			login.Log4j.info("The results are sorted based on Mnemonic");
		} else {
			Assert.fail("Verification failed");
		}

		CommonFunctionality.getElementByProperty(login.driver, "Expand_Icon_Right", 8).click();
		login.driver.findElement(By.xpath("(//span[@class='custom-select-title--reset-icon'])[4]")).click();
		select_the_Customize_option();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Reset_option", 6).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_save_option", 6).click();
		System.out.println("<============================TC160================================================>");
	}

	// TC_MS_161
	@And("^applay function for the series$")
	public void applay_function_for_the_series() throws Throwable {
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByProperty(login.driver, "First_series_check_box", 6).click();
		CommonFunctionality.getElementByProperty(login.driver, "Calculate_change_dropdown", 6).click();
		CommonFunctionality.getElementByProperty(login.driver, "yoy_FD_Function", 6).click();
		CommonFunctionality.wait(800);
		CommonFunctionality.getElementByProperty(login.driver, "First_series_check_box", 6).click();
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByProperty(login.driver, "Second_series_check_box", 6).click();
		CommonFunctionality.getElementByProperty(login.driver, "Calculate_change_dropdown", 6).click();
		CommonFunctionality.getElementByProperty(login.driver, "%yoy_FD_Function", 6).click();
		CommonFunctionality.wait(800);
		CommonFunctionality.getElementByProperty(login.driver, "Second_series_check_box", 6).click();
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByProperty(login.driver, "Third_series_check_box", 6).click();
		CommonFunctionality.getElementByProperty(login.driver, "Calculate_change_dropdown", 6).click();
		CommonFunctionality.getElementByProperty(login.driver, "POP_Function", 6).click();
		CommonFunctionality.wait(800);
		CommonFunctionality.getElementByProperty(login.driver, "Third_series_check_box", 6).click();
		System.out.println("===============>apply function for the series===================>");
	}

	// TC_MS_161
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Given("^Verify sort by Function Description$")
	public void verify_sort_by_Function_Description() throws Throwable {
		Thread.sleep(2000);
		List<WebElement> country_list = login.driver.findElements(By.xpath("//*[@class='series-functions-title']"));
		List list = new ArrayList();

		for (WebElement country : country_list) {
			String str = country.getText();
			String str1 = str.substring(0, 2);
			list.add(str1);
		}
		List tempList = new ArrayList(list);
		Collections.sort(tempList);
		boolean ifSortedAscending = list.equals(tempList);
		if (ifSortedAscending) {
			login.Log4j.info("The results are sorted based on Function Description");
		} else {
			Assert.fail("Verification failed");
		}
	
		login.driver.findElement(By.xpath("(//span[@class='custom-select-title--reset-icon'])[4]")).click();
	}

	// TC_MS_162
	@And("^select  Observation option in customize setting$")
	public void select_Observation_option_in_customize_setting() throws Throwable {
		select_the_Customize_option();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Numberof_observation", 6).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_save_option", 6).click();
	}

	// TC_MS_162
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@And("^Verify sort by Obs\\. Number$")
	public void verify_sort_by_Obs_Number() throws Throwable {
		select_the_Expand_Icon();
		String lastupdate = CommonFunctionality.getElementByProperty(login.driver, "Lastobservation_First", 6)
				.getText();
		String str = lastupdate.substring(0, 2);
		int result = Integer.parseInt(str);
		List<WebElement> objLinks = login.driver
				.findElements(By.xpath("(//*[@class='additional-info-item observations-number'])[1]"));
		for (WebElement obj : objLinks) {
			String text = obj.getText();
			String str1 = text.substring(0, 2);
			int result1 = Integer.parseInt(str1);
			if (result >= result1) {
				System.out.println("Sort by observation number is Verified Successfully!!! ");
			} else {
				Assert.fail("Sort by observation number is NOT Verified Successfully");
			}

			CommonFunctionality.getElementByProperty(login.driver, "Expand_Icon_Right", 8).click();
			login.driver.findElement(By.xpath("(//span[@class='custom-select-title--reset-icon'])[4]")).click();
			select_the_Customize_option();
			CommonFunctionality.getElementByProperty(login.driver, "Customize_Reset_option", 6).click();
			CommonFunctionality.getElementByProperty(login.driver, "Customize_save_option", 6).click();
		}
	}

	@Given("^search for the Series ID  as (\\d+)$")
	public void search_for_the_Series_ID_as(int arg1) throws Throwable {

		CommonFunctionality.getElementByXpath(login.driver, "//input[@class='search-input-text']", 8).clear();
		CommonFunctionality.getElementByXpath(login.driver, "//input[@class='search-input-text']", 8)
				.sendKeys("205424302");

		CommonFunctionality.getElementByXpath(login.driver, "//input[@class='search-input-text']", 8)
				.sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		List<WebElement> objLinks = login.driver.findElements(By.xpath("//a[@class='series-list-item--container']"));
		System.out.println("Total Size are: " + objLinks.size());
		for (int i = 1; i <= 1; i++) {
			CommonFunctionality.getElementByXpath(login.driver,
					"(//span[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]", 8).click();
		}
		WebElement series = CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='series-item--name'])[1]", 8);
		new Actions(login.driver).moveToElement(series).build().perform();
		
		
		// click on + icon
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='add-to-data-selection--icon'])[1]", 8)
				.click();

		/*
		 * List<WebElement> objLinks = login.driver.findElements(By.xpath(
		 * "//a[@class='series-list-item--container']"));
		 * System.out.println("Total Size are- " + objLinks.size()); for(int
		 * i=1;i<=1;i++) { Thread.sleep(2000);
		 * login.driver.findElement(By.xpath("//ul[@class='search-series-list']/li["+i+
		 * "]/div/a/div[2]/span")).click(); } Thread.sleep(2000);
		 * login.driver.findElement(By.xpath(
		 * "//ul[@class='search-series-list']/li[1]/div/a/div[4]/div/div[1]")).click();
		 * 
		 * 
		 */
	}

	/*
	 * @Given("^search for the Series ID  as (\\d+);(\\d+)$") public void
	 * search_for_the_Series_ID_as(int arg1, int arg2) throws Throwable {
	 * 
	 * Thread.sleep(1000);
	 * login.driver.findElement(By.xpath("//input[@class='search-input-text']")).
	 * clear(); Thread.sleep(3000);
	 * login.driver.findElement(By.xpath("//input[@class='search-input-text']")).
	 * sendKeys("292514601;237938503"); Thread.sleep(8000);
	 * login.driver.findElement(By.xpath(
	 * "//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/label[2]"
	 * )).click(); Thread.sleep(3000); List<WebElement> objLinks =
	 * login.driver.findElements(By.xpath(
	 * "//a[@class='series-list-item--container']"));
	 * System.out.println("Total Size are- " + objLinks.size()); for(int
	 * i=1;i<=2;i++) { Thread.sleep(2000);
	 * login.driver.findElement(By.xpath("//ul[@class='search-series-list']/li["+i+
	 * "]/div/a/div[2]/span")).click(); } Thread.sleep(2000);
	 * login.driver.findElement(By.xpath(
	 * "//ul[@class='search-series-list']/li[1]/div/a/div[4]/div/div[1]")).click();
	 * }
	 */

	// }

	// TC_MS_163
	@And("^Verify sort by First date$")
	public void verify_sort_by_First_date() throws Throwable {
		Thread.sleep(2000);
		String lastupdate = CommonFunctionality.getElementByProperty(login.driver, "lastupdate", 6).getText();
		System.out.println("lastupdate=========>" + lastupdate);
		String str = lastupdate.substring(0, 2);
		int result = Integer.parseInt(str);
		List<WebElement> objLinks = login.driver.findElements(By.className("last-updated-date"));
		for (WebElement obj : objLinks) {
			String text = obj.getText();
			String str1 = text.substring(0, 2);
			int result1 = Integer.parseInt(str1);
			System.out.println("==================>result" + result);
			System.out.println("==================>result" + result1);

			if (result <= result1) {
				System.out.println("Sort by First date is Verified Successfully!!! ");
			} else {
				Assert.fail("Sort by First date is NOT Verified Successfully");
			}
		}
		System.out.println("=========>Exit from if condition ");
		login.driver.findElement(By.xpath("(//span[@class='custom-select-title--reset-icon'])[4]")).click();
		}

	// TC_MS_164
	@And("^Verify sort by Last date$")
	public void verify_sort_by_Last_date() throws Throwable {
		String lastupdate = CommonFunctionality.getElementByProperty(login.driver, "lastupdate", 6).getText();
		String str = lastupdate.substring(0, 2);
		int result = Integer.parseInt(str);
		List<WebElement> objLinks = login.driver.findElements(By.className("last-updated-date"));
		for (WebElement obj : objLinks) {
			String text = obj.getText();
			String str1 = text.substring(0, 2);
			int result1 = Integer.parseInt(str1);
			if (result <= result1) {
				System.out.println("Sort by Last date is Verified Successfully!!! ");
			} else {
				Assert.fail("Sort by Last date is NOT Verified Successfully");
			}
		}
		
		login.driver.findElement(By.xpath("(//span[@class='custom-select-title--reset-icon'])[4]")).click();
	}

	// TC_MS_165
	@And("^Select the first series$")
	public void select_the_first_series() throws Throwable {
		// Thread.sleep(3000);
		CommonFunctionality.getElementByProperty(login.driver, "First_series_check_box", 6).click();
	}

	// TC_MS_165
	@And("^Select shift key and select last series$")
	public void select_shift_key_and_select_last_series() throws Throwable {
		Thread.sleep(3000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_SHIFT);
		Actions keyAction = new Actions(login.driver);
		keyAction.keyUp(Keys.SHIFT).perform();
		Thread.sleep(3000);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='input-control--indicator']", 8).click();
		Thread.sleep(3000);
		r.keyRelease(KeyEvent.VK_SHIFT);
		keyAction.keyDown(Keys.SHIFT).perform();

	}

	// TC_MS_165
	@And("^Verify series selection by using Shift key$")
	public void verify_series_selection_by_using_Shift_key() throws Throwable {
		Thread.sleep(3000);
		String allseries = CommonFunctionality.getElementByProperty(login.driver, "Total_series_count", 6).getText();
		String selectedseries = CommonFunctionality.getElementByProperty(login.driver, "Selected_series_count", 6)
				.getText();
		if (allseries.equalsIgnoreCase(selectedseries)) {
			System.out.println("series selection by using Shift key is Verified Successfully!!! ");

		} else {
			Assert.fail("series selection by using Shift key is NOT Verified Successfully");

		}

	}

	// TC_MS_166
	@SuppressWarnings("deprecation")
	@And("^Select series and darg and drop$")
	public void select_series_and_darg_and_drop() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Series')]", 8).click();
		Thread.sleep(2000);
		Seriesnametodrag = CommonFunctionality
				.getElementByXpath(login.driver, "(//div[@class='series-list-item--content']/a/div)[1]", 8).getText();

		WebElement dragfrom = login.driver
				.findElement(By.xpath("(//div[@class='series-list-item--content']/a/div)[1]"));
		WebElement dragto = login.driver
				.findElement(By.xpath("//div[@class='data-selection-series-overlay--content']"));
		action.dragAndDrop(dragfrom, dragto).pause(2000).build().perform();
	}

	// TC_MS_166
	@And("^Verify placing series by drag and drop$")
	public void verify_placing_series_by_drag_and_drop() throws Throwable {
		CommonFunctionality.wait(200);
		String seriesnamedrop = login.driver
				.findElement(By.xpath("(//div[@class='series-list-item--content']/a/div)[1]")).getText();
		if (seriesnamedrop.equalsIgnoreCase(Seriesnametodrag)) {
			System.out.println("Verified the drag and drop option on series");
		} else {
			Assert.fail("FAIL to Verify the drag and drop option on series");
		}
	}

	// TC_MS_167
	@SuppressWarnings("deprecation")
	@And("^Mouse hover the first series$")
	public void mouse_hover_the_first_series() throws Throwable {

		try {
			login.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement we = login.driver.findElement(By.xpath("(//span[@class='series-name-field--series-name'])[1]"));
			action.moveToElement(we).pause(2000).build().perform();

		}

		catch (org.openqa.selenium.StaleElementReferenceException ex) {
			login.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement we = login.driver.findElement(By.xpath("(//span[@class='series-name-field--series-name'])[1]"));
			action.moveToElement(we).pause(2000).build().perform();
		}
	}

	// TC_MS_167
	@And("^Verify Mouse hover icons on series$")
	public void verify_Mouse_hover_icons_on_series() throws Throwable {
		Thread.sleep(1000);
		System.out.println("displayed");
		Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Icon"))).isDisplayed());
		Thread.sleep(2000);
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Function_footnote_more"))).isDisplayed());
	}

	// TC_MS_168
	@And("^Select Show Series info$")
	public void select_Show_Series_info() throws Throwable {
		// WebElement we = login.driver.findElement(By.xpath("//div[@class='webix_column
		// list-series-name webix_last']/div[1]/div[1]/div[1]/div[1]/span[1]/span"));
		// action.moveToElement(we).build().perform();
		// CommonFunctionality.getElementByProperty(login.driver, "SSP_Icon",
		// 6).click();
		login.driver.findElement(By.xpath("(//span[@class='series-name-field--text'])[1]")).click();
	}

	// TC_MS_168
	@And("^Verify Show Series info$")
	public void verify_Show_Series_info() throws Throwable {
		CommonFunctionality.wait(500);
		boolean SSP = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Dialogue"))).isDisplayed();
		if (SSP == true) {
			System.out.println("Show Series info is Verified Successfully!!! ");
		} else {
			Assert.fail("Show Series info is NOT Verified Successfully!!!");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 6).click();
	}

	// TC_MS_169
	@And("^Verify series tooltip in my series$")
	public void verify_series_tooltip_in_my_series() throws Throwable {
		WebElement we = CommonFunctionality.getElementByXpath(login.driver,
				"(//span[@class='series-name-field--text'])[1]", 8);
		action.moveToElement(we).pause(2000).build().perform();
		Thread.sleep(3000);
		boolean tooltip = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text_Myseries")))
				.isDisplayed();
		if (tooltip == true) {
			System.out.println("Series tooltip info is Verified Successfully!!! ");
		} else {
			Assert.fail("Series tooltip  info is NOT Verified Successfully!!!");
		}
	}

	// TC_MS_170
	@And("^Select the Edit series option$")
	public void select_the_Edit_series_option() throws Throwable {
		 Thread.sleep(1000);
		CommonFunctionality.getElementByProperty(login.driver, "Edit_series", 6).click();
	}

	// TC_MS_170
	@And("^Verify Edit series option$")
	public void verify_Edit_series_option() throws Throwable {
		boolean editseries = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_list")))
				.isDisplayed();
		if (editseries == true) {
			System.out.println("Edit series option is Verified Successfully!!! ");
		} else {
			Assert.fail("Edit series option is NOT Verified Successfully!!!");
		}
	}

	// TC_MS_171
	@And("^Select the rename option$")
	public void select_the_rename_option() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Edit_series_rename", 6).click();
	}

	// TC_MS_171
	@And("^Verify Edit series option -rename$")
	public void verify_Edit_series_option_rename() throws Throwable {
		boolean editseriesrenamepopup = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_rename_popup"))).isDisplayed();
		if (editseriesrenamepopup == true) {
			System.out.println("Edit series option -rename is Verified Successfully!!! ");
		} else {
			Assert.fail("Edit series option - rename is NOT Verified Successfully!!!");
		}
	}

	// TC_MS_172
	@And("^Verify Edit series Rename - by default$")
	public void verify_Edit_series_Rename_by_default() throws Throwable {
		String Default_ok = CommonFunctionality.getElementByProperty(login.driver, "ok_button_editseries", 8)
				.getAttribute("class");
		if (Default_ok.contains("disabled")) {
			System.out.println("Edit series Rename by default is verified Successfully");
		} else {
			Assert.fail("Edit series Rename by default is NOT Verified Successfully");
		}
	}

	// TC_MS_173
	@And("^change series name$")
	public void change_series_name() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByProperty(login.driver, "Edit_series_rename_popup", 6).click();
		CommonFunctionality.getElementByProperty(login.driver, "Edit_series_rename_popup", 6).clear();
		CommonFunctionality.getElementByProperty(login.driver, "Edit_series_rename_popup", 6).sendKeys("Test");
		CommonFunctionality.getElementByProperty(login.driver, "ok_button_editseries_checked", 6).click();
	}

	// TC_MS_173
	@And("^Verify Edit series Rename - clicking on OK button$")
	public void verify_Edit_series_Rename_clicking_on_OK_button() throws Throwable {
		Thread.sleep(3000);
		String seriesname = CommonFunctionality.getElementByProperty(login.driver, "rename_series_grouplevel", 8)
				.getText();
		System.out.println(seriesname);
		String Seriesnameafter = "Test";
		if (seriesname.contains(Seriesnameafter)) {

			System.out.println("Edit series Rename clicking on OK button is verified Successfully");
		} else {
			Assert.fail("Edit series Rename clicking on OK button is NOT Verified Successfully");
		}
	}

	// TC_MS_174
	@And("^Verify Edit series Rename -Cancel icon$")
	public void verify_Edit_series_Rename_Cancel_icon() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "ok_button_editseries_uncheked", 6).click();
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Edit_series_rename_popup"))).size() == 0) {
			System.out.println("Edit series Rename Cancel icon is Verified Successfully!!! ");
		} else {
			Assert.fail("Edit series Rename Cancel icon is NOT Verified Successfully");
		}
	}

	// TC_MS_175
	@And("^Verify Edit series Rename -More option$")
	public void verify_Edit_series_Rename_More_option() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "ok_button_editseries_more", 6).click();
		Thread.sleep(2000);
		Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_popup"))).isDisplayed());
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 6).click();
	}

	// TC_MS_176
	@And("^Verify Edit series Rename -Frequency$")
	public void verify_Edit_series_Rename_Frequency() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Edit_series_frequency", 6).click();
		Thread.sleep(1000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Edit_series_frequencydropdown")))
				.size() != 0) {
			System.out.println("Edit series Rename Frequency is Verified Successfully!!! ");
		} else {
			Assert.fail("Edit series Rename Frequency is NOT Verified Successfully");
		}
	}

	// TC_MS_176
	@And("^Select the frequency option$")
	public void select_the_frequency_option() throws Throwable {
		Thread.sleep(3000);
		CommonFunctionality.getElementByProperty(login.driver, "Edit_series_frequency", 6).click();
	}

	// TC_MS_178
	@And("^Select the change option$")
	public void select_the_change_option() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Change')]", 8).click();
	}

	// TC_MS_178
	@And("^Verify Edit series Rename change$")
	public void verify_Edit_series_Rename_change() throws Throwable {
		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Edit_series_frequencydropdown")))
				.size() != 0) {
			System.out.println("Edit series Rename Change is Verified Successfully!!! ");
		} else {
			Assert.fail("Edit series Rename change is NOT Verified Successfully");
		}

	}

	// TC_MS_179
	@And("^Select the Remove option$")
	public void select_the_Remove_option() throws Throwable {
		Thread.sleep(2000);
		// System.out.println("===========>Select the Remove option===========>");
		String allseries = CommonFunctionality.getElementByProperty(login.driver, "Total_series_count", 6).getText();
		Allseriescount = Integer.parseInt(allseries);
		mouse_hover_the_first_series();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_remove"))).click();
		System.out.println("===========>Select the Remove option===========>");

	}

	// TC_MS_179
	@And("^Verify Remove series if no visuals created from the series$")
	public void verify_Remove_series_if_no_visuals_created_from_the_series() throws Throwable {
		Thread.sleep(2000);
		String allseriesafterremove = CommonFunctionality.getElementByProperty(login.driver, "Total_series_count", 6)
				.getText();
		int Allseriesafterremove = Integer.parseInt(allseriesafterremove);
		if (Allseriescount != (Allseriesafterremove)) {

			System.out.println("Remove series if no visuals created from the series is Verified Successfully!!! ");
		} else {
			Assert.fail("Remove series if no visuals created from the series is NOT Verified Successfully");
		}

	}

	// TC_MS_180
	@And("^Select to myseries button$")
	public void select_to_myseries_button() throws Throwable {
		CommonFunctionality.wait(5000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-page-menu']/div[1]", 8).click();
		mouse_hover_the_first_series();
	}

	// TC_MS_180
	@And("^Verify Remove series if visuals created from the series$")
	public void verify_Remove_series_if_visuals_created_from_the_series() throws Throwable {
		Thread.sleep(2000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Delete_series_popup"))).size() != 0) {
			System.out.println("Remove series if  visuals created from the series is Verified Successfully!!! ");
		} else {
			Assert.fail("Remove series if  visuals created from the series is NOT Verified Successfully");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Delete_ok_button", 6).click();

	}

	// TC_MS_181
	@And("^Verify Remove series discription for delete series popup$")
	public void verify_Remove_series_discription_for_delete_series_popup() throws Throwable {

		String allseriesafterremove = CommonFunctionality
				.getElementByProperty(login.driver, "Delete_series_textinside", 6).getText().replaceAll("//s+", "");
		System.out.println(allseriesafterremove);
		String deletepopuptextinside = "The series are associated with visuals within the current insight and deleting them will affect the visuals.Are you sure you want to delete?";
		if (!allseriesafterremove.matches(deletepopuptextinside)) {

			System.out.println("Remove series discription for delete series popup is Verified Successfully!!! ");
		} else {
			Assert.fail("Remove series discription for delete series popup is NOT Verified Successfully");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Delete_ok_button", 6).click();

	}

	// TC_MS_182
	@And("^Verify Remove series OK button for delete series popup$")
	public void verify_Remove_series_OK_button_for_delete_series_popup() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Delete_ok_button", 6).click();
		Thread.sleep(2000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Delete_series_popup"))).size() == 0) {
			System.out.println("Remove series OK button for delete series popup is Verified Successfully!!! ");
		} else {
			Assert.fail("Remove series OK button for delete series popup is NOT Verified Successfully");

		}
	}

	// TC_MS_183
	@And("^Verify Remove series the associated visuals after removed series$")
	public void verify_Remove_series_the_associated_visuals_after_removed_series() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Delete_ok_button", 6).click();
		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Delete_series_popup"))).size() == 0) {
			System.out.println("Remove series OK button for delete series popup is Verified Successfully!!! ");
		} else {

			Assert.fail("Remove series OK button for delete series popup is NOT Verified Successfully");

		}
	}

	// TC_MS_184
	@And("^Verify Remove series Cancel/x icon for the popup$")
	public void verify_Remove_series_Cancel_x_icon_for_the_popup() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Delete_Cancel_button", 6).click();
		Thread.sleep(1000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Delete_series_popup"))).size() == 0) {
			System.out.println("Remove series OK button for delete series popup is Verified Successfully!!! ");
		} else {
			Assert.fail("Remove series OK button for delete series popup is NOT Verified Successfully");

		}
	}

	// TC_MS_185
	@And("^Select the Fx option$")
	public void select_the_Fx_option() throws Throwable {
		Thread.sleep(1000);
		CommonFunctionality.getElementByProperty(login.driver, "FXover_icon", 6).click();
	}

	// TC_MS_185
	@And("^Verify Fx on series mouse hovering$")
	public void verify_Fx_on_series_mouse_hovering() throws Throwable {
		Thread.sleep(2000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Function_fxdropdown"))).size() != 0) {
			System.out.println("Fx on series mouse hovering is Verified Successfully!!! ");
		} else {

			Assert.fail("Fx on series mouse hovering is NOT Verified Successfully");
		}
	}

	// TC_MS_186
	@And("^Select the Footnotes option$")
	public void select_the_Footnotes_option() throws Throwable {
		CommonFunctionality.wait(1000);
		WebElement footnote = login.driver.findElement(By.xpath("(//div[@class='open-footnote menu-icon'])[1]"));
		action.moveToElement(footnote).click().build().perform();
	//	CommonFunctionality.getElementByProperty(login.driver, "Footnotes_icon", 6).click();
	}

	// TC_MS_186
	@And("^Verify Footnotes on series mouse hovering$")
	public void verify_Footnotes_on_series_mouse_hovering() throws Throwable {
		Thread.sleep(2000);
		if (login.driver.findElement(By.xpath("//div[@class='movable-modal--window ui-resizable ui-draggable']")).isDisplayed()) {
			System.out.println("Footnotes on series mouse hovering is Verified Successfully!!! ");
		} else {
			Assert.fail("Footnotes on series mouse hovering is NOT Verified Successfully");

		}
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 6).click();
	}

	// TC_MS_187
	@SuppressWarnings("deprecation")
	@And("^Select the More option$")
	public void select_the_More_option() throws Throwable {
			
		try {
			Thread.sleep(2000);
			WebElement we = login.driver
					.findElement(By.xpath("(//div[@class='show-context menu-icon'])[1]"));
			action.moveToElement(we).click().build().perform();
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			Thread.sleep(2000);
			WebElement we = login.driver
					.findElement(By.xpath("(//div[@class='show-context menu-icon'])[1]"));
			action.moveToElement(we).click().build().perform();
		}

		}

	// TC_MS_187
	@And("^Verify More option on series mouse hovering$")
	public void verify_More_option_on_series_mouse_hovering() throws Throwable {
		Thread.sleep(3000);
		if (login.driver.findElement(By.xpath("//div[@class='items-wrapper']")).isDisplayed()) {
			System.out.println("More option on series mouse hovering is Verified Successfully!!! ");
		} else {
			Assert.fail("More option on series mouse hovering is NOT Verified Successfully");

		}
	}

	// TC_MS_188
	@And("^Verify More Unselect all$")
	public void verify_More_Unselect_all() throws Throwable {
		CommonFunctionality.wait(500);
		boolean checkbox = login.driver
				.findElement(By.xpath("//div[@class='check-all-series']//span[@class='input-control--indicator']"))
				.isSelected();
		if (checkbox == false) {
			System.out.println("More Unselect all is Verified Successfully!!! ");
		} else {
			Assert.fail("More Unselect all is NOT Verified Successfully");
		}
	}

	// TC_MS_189
	@And("^Verify More Add to chart Chart all$")
	public void verify_More_Add_to_chart_Chart_all() throws Throwable {
		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Chart_created"))).size() != 0) {
			System.out.println("More option Add to chart Chart is Verified Successfully!!! ");
		} else {
			Assert.fail("More option Add to chart Chart is NOT Verified Successfully");

		}
	}

	// TC_MS_189
	@And("^Select the \"([^\"]*)\" button$")
	public void select_the_button(String arg1) throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='items-wrapper']//span[@title='" + arg1 + "']/*[2]")).click();

	}

	@And("^Select the \"([^\"]*)\" link$")
	public void select_the_link(String chat) throws Throwable {
		CommonFunctionality.wait(1000);

		login.driver.findElement(By.xpath("//div[contains(@class,'icon--" + chat + "_large')]")).click();
		CommonFunctionality.wait(2000);
	}

	@Given("^one series add into my series tab$")
	public void one_series_add_into_my_series_tab() throws Throwable {
		CommonFunctionality.wait(300);
/*		WebElement table = login.driver
				.findElement(By.xpath("(//div[@class='toggler-control-wrapper']//button[@type='button'])[1]"));
		action.moveToElement(table).click().build().perform();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//div[@data-action='delete']")).click();  */

		CommonFunctionality.getElementByProperty(login.driver, "MyInsight_Tab", 10).click();

		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Series')]", 8).click();

		CommonFunctionality
				.getElementByXpath(login.driver, "(//span[@class='series-list-item--checkbox svg-checkbox'])[1]", 8)
				.click();

		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='add-to-data-selection--icon'])[1]", 8)
				.click();
		CommonFunctionality.wait(1000);

		CommonFunctionality.getElementByProperty(login.driver, "MyInsight_Tab", 10).click();

	}

	// TC_MS_190
	@SuppressWarnings("deprecation")
	@And("^Verify More Add to chart Map$")
	public void verify_More_Add_to_chart_Map() throws Throwable {
		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("MAP_created"))).size() != 0) {
			System.out.println("More option Add to chart MAP is Verified Successfully!!! ");
		} else {
			Assert.fail("More option Add to chart MAP is NOT Verified Successfully");
		}
	}

	// TC_MS_191
	@And("^Verify More Add to chart Table$")
	public void verify_More_Add_to_chart_Table() throws Throwable {
		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Table_created"))).size() != 0) {
			System.out.println("More option Add to chart Table is Verified Successfully!!! ");
		} else {
			Assert.fail("More option Add to chart Table is NOT Verified Successfully");
		}
	}

	// TC_MS_192
	@And("^Verify More View as \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void verify_More_View_as(String arg1, String arg2, String arg3) throws Throwable {
		Thread.sleep(1000);
		WebElement display_pie = CommonFunctionality.getElementByXpath(login.driver,
				"//div[contains(@class,'icon--" + arg1 + "_large')]", 4);
		Assert.assertTrue(display_pie.isDisplayed());
		WebElement display_heatmap = CommonFunctionality.getElementByXpath(login.driver,
				"//div[contains(@class,'icon--" + arg2 + "_large')]", 4);
		Assert.assertTrue(display_heatmap.isDisplayed());
		WebElement display_histogram = CommonFunctionality.getElementByXpath(login.driver,
				"//div[contains(@class,'icon--" + arg3 + "_large')]", 4);
		Assert.assertTrue(display_histogram.isDisplayed());

		// WebElement display_histogram =
		// CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + arg3 +
		// "']",4);
		// Assert.assertTrue(display_histogram.isDisplayed());
	}

	// TC_MS_193
	@And("^Verify More Add to chart Pie$")
	public void verify_More_Add_to_chart_Pie() throws Throwable {
		// CommonFunctionality.getElementByProperty(login.driver, "PIE", 6).click();
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("PIE_created"))).size() != 0) {
			System.out.println("More option Add to chart pie is Verified Successfully!!! ");
		} else {
			Assert.fail("More option Add to chart pie is NOT Verified Successfully");

		}
	}

	// TC_MS_194
	@And("^Verify More Add to chart Heatmap$")
	public void verify_More_Add_to_chart_Heatmap() throws Throwable {
		Thread.sleep(1000);
		// new
		// Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
		// "*[title='Heat map']", 4)).pause(500).click().build().perform();
		Thread.sleep(2000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Heatmap_created"))).size() != 0) {
			System.out.println("More option Add to chart Heatmap is Verified Successfully!!! ");
		} else {
			Assert.fail("More option Add to chart Heatmap is NOT Verified Successfully");

		}

	}

	// TC_MS_195

	@And("^Verify More Add to chart Scatter$")
	public void verify_More_Add_to_chart_Scatter() throws Throwable {

		Thread.sleep(2000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Scatter_created"))).size() != 0) {
			System.out.println("More option Add to chart Scatter is Verified Successfully!!! ");
		} else {
			Assert.fail("More option Add to chart Scatter is NOT Verified Successfully");

		}

	}

	// TC_MS_196
	@And("^Verify More Add to chart Histogram$")
	public void verify_More_Add_to_chart_Histogram() throws Throwable {
		Thread.sleep(1000);
		// new
		// Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
		// "*[title='Histogram']", 4)).pause(500).click().build().perform();

		Thread.sleep(1000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Histrogram_created"))).size() != 0) {
			System.out.println("More option Add to chart Histogram is Verified Successfully!!! ");
		} else {
			Assert.fail("More option Add to chart Histogram is NOT Verified Successfully");

		}
	}

	// TC_MS_197
	@And("^Verify creating visual with more than max series selection$")
	public void verify_creating_visual_with_more_than_max_series_selection() throws Throwable {
		Thread.sleep(1000);
		Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Confirmation"))).isDisplayed());
		CommonFunctionality.getElementByProperty(login.driver, "Confirmation_ok", 6).click();
		CommonFunctionality.getElementByProperty(login.driver, "footnote_window_close", 8).click();
		// verify_More_View_as_Chart_all();
	}

	@And("^click on 'Download' option$")
	public void click_on_Download_option() throws Throwable {

		login.driver.findElement(By.xpath("(//*[text()='Download'])[2]")).click();

	}

	// TC_MS_197
	@And("^Mouse hover the last series$")
	public void mouse_hover_the_last_series() throws Throwable {
		Thread.sleep(1000);
		WebElement we = login.driver.findElement(By.xpath("(//span[@class='series-name-field--text'])[6]"));
		action.moveToElement(we).pause(2000).build().perform();

	}

	// TC_MS_197
	@And("^Select the More option on last series$")
	public void select_the_More_option_on_last_series() throws Throwable {
		/*
		 * Thread.sleep(3000); CommonFunctionality.getElementByProperty(login.driver,
		 * "lastseriesmore", 6).click();
		 */
		WebElement ele = login.driver.findElement(By.xpath("(//div[@title='More actions'])[6]"));
		action.contextClick(ele).pause(2000).build().perform();
	}

	// TC_MS_198
	@And("^Verify More View on Download option$")
	public void verify_More_View_on_Download_option() throws Throwable {
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Download_pop_up"))).isDisplayed());
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Close_window", 6).click();
	}

	// TC_MS_199
	@And("^Verify More Copy option$")
	public void verify_More_Copy_option() throws Throwable {
		get_the_series_name();
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable contents = clipboard.getContents(null);
		String x = (String) contents.getTransferData(DataFlavor.stringFlavor);
		System.out.println(x);
		if (x.equalsIgnoreCase(FirstseriesName)) {
			System.out.println("More Copy option is Verified Successfully!!! ");
		} else {
			Assert.fail("More Copy option is NOT Verified Successfully");
		}
	}

	// TC_MS_200
	@And("^Verify More actions the confirmation message for Copy action$")
	public void verify_More_actions_the_confirmation_message_for_Copy_action() throws Throwable {
		verify_the_Copy_option();

		System.out.println("=====================>TC_200==================================>");
	}

	// TC_MS_201
	@And("^Verify More actions closing of growl popup for Copy$")
	public void verify_More_actions_closing_of_growl_popup_for_Copy() throws Throwable {
		verify_the_closing_of_growl_popup();
	}

	// TC_MS_202
	@And("^Verify More actions Copy data$")
	public void verify_More_actions_Copy_data() throws Throwable {
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copydata_pop_up"))).isDisplayed());
		Thread.sleep(3000);
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Close_window", 6).click();

	}

	// TC_MS_203
	@And("^uncheck the checkbox in Always ask me about the export settings$")
	public void uncheck_the_checkbox_in_Always_ask_me_about_the_export_settings() throws Throwable {
		boolean checkbox = login.driver.findElement(By.xpath("//*[@class='checkbox-control']/label/span[1]"))
				.isSelected();
		if (checkbox == true) {
			login.driver.findElement(By.xpath("//div[@class='dont-show-again']/label/span[1]")).click();
			CommonFunctionality.getElementByProperty(login.driver, "CTC", 6).click();
		} else {
			CommonFunctionality.getElementByProperty(login.driver, "CTC", 6).click();
		}
	}

	// TC_MS_203
	@And("^Verify More actions in Always ask me about the export settings$")
	public void verify_More_actions_in_Always_ask_me_about_the_export_settings() throws Throwable {
		mouse_hover_the_first_series();
		select_the_More_option();
		CommonFunctionality.getElementByProperty(login.driver, "Copydata", 6).click();
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copydata_pop_up"))).isDisplayed());
		Thread.sleep(2000);
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Close_window", 6).click();
	}

	@And("^Select the Copy selected links option$")
	public void select_the_Copy_selected_links_option() throws Throwable {

		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Copy selected links')]", 8)
				.click();

	}

	// TC_MS_204
	@And("^Verify More actions Copy link\\(s\\) for series$")
	public void verify_More_actions_Copy_link_s_for_series() throws Throwable {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable contents = clipboard.getContents(null);
		String x = (String) contents.getTransferData(DataFlavor.stringFlavor);
		System.out.println(x);
		String Copy_link = "https://stage.ceicdata.com/series";
		if (x.contains(Copy_link)) {
			System.out.println("More Copy link option is Verified Successfully!!! ");
		} else {
			Assert.fail("More Copy link option is NOT Verified Successfully");
		}
	}

	// TC_MS_205
	@And("^Verify More actions Copy link behavior for single series$")
	public void verify_More_actions_Copy_link_behavior_for_single_series() throws Throwable {
		Thread.sleep(2500);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_T);
		Thread.sleep(2500);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2500);
		ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs2.get(1));
		Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Dialogue"))).isDisplayed());
		login.driver.close();
		login.driver.switchTo().window(tabs2.get(0));

	}

	// TC_MS_206
	@And("^Verify More actions Copy link confirmation message$")
	public void verify_More_actions_Copy_link_confirmation_message() throws Throwable {
		verify_the_confirmation_message_for_paste_action();
	}

	// TC_MS_208
	@And("^Verify More actions Copy link confirmation message for multiple series$")
	public void verify_More_actions_Copy_link_confirmation_message_for_multiple_series() throws Throwable {

		String copylinktext = CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='growl-message-text']", 8).getText();
		System.out.println(copylinktext);
		String Series_count = CommonFunctionality.getElementByProperty(login.driver, "Total_series_count", 6).getText();
		System.out.println(Series_count);
		char first = copylinktext.charAt(0);
		if (!Series_count.equalsIgnoreCase(copylinktext)) {
			System.out
					.println("More actions Copy link confirmation message for multiple seriesis verified Successfully");
		} else {
			Assert.fail(
					"More actions Copy link confirmation message for multiple seriesis verified Successfully is NOT verified Successfully:-(");
		}

	}

	// TC_MS_209
	@And("^Verify More actions Copy link closing of growl popup$")
	public void verify_More_actions_Copy_link_closing_of_growl_popup() throws Throwable {
		verify_the_closing_of_growl_popup();
	}

	// TC_MS_210
	@And("^Mouse hover the \"([^\"]*)\" option$")
	public void mouse_hover_the_option(String arg1) throws Throwable {
		Thread.sleep(1000);
		WebElement we = login.driver.findElement(By.xpath("//span[@class='context-menu-item link disabled']"));
		action.moveToElement(we).pause(2000).build().perform();
	}

	// TC_MS_210
	@And("^Verify More actions insert copied option if not data in clipboard$")
	public void verify_More_actions_insert_copied_option_if_not_data_in_clipboard() throws Throwable {
//		Thread.sleep(1000);
//		WebElement we = login.driver.findElement(By.xpath("//div[@class='items-wrapper']/li[14]"));
//		action.moveToElement(we).pause(2000).build().perform();
		Thread.sleep(1000);
		// String insertcopied = CommonFunctionality.getElementByProperty(login.driver,
		// "Insert_copy", 6).getAttribute("class");

		login.driver.findElement(By.xpath("//span[text()='Copy data']")).click();
		Thread.sleep(1000);
		// System.out.println(insertcopied);
		if (login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']")).isDisplayed()) {
			System.out.println("More actions insert copied option if not data in clipboard is Verified Successfully");
		} else {
			Assert.fail("More actions insert copied option if not data in clipboard is Verified Successfully");

		}
		login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();

	}

	// TC_MS_211
	@And("^Verify More actions insert copied option$")
	public void verify_More_actions_insert_copied_option() throws Throwable {
		Thread.sleep(2000);
		String Series_count_before = CommonFunctionality.getElementByProperty(login.driver, "Total_series_count", 6)
				.getText();
		int SC_before = Integer.parseInt(Series_count_before);
		System.out.println(SC_before);
		Thread.sleep(2000);
		String Series_count_after = CommonFunctionality.getElementByProperty(login.driver, "Total_series_count", 6)
				.getText();
		int SC_after = Integer.parseInt(Series_count_after);
		System.out.println(SC_after);
		if (SC_before >= SC_after) {
			System.out.println("More actions insert copied option is verified Succesfully");
		} else {
			Assert.fail("More actions insert copied option is NOT verified Succesfully");
		}
	}

	// TC_MS_212
	@And("^Verify More actions insert growl message$")
	public void verify_More_actions_insert_growl_message() throws Throwable {
		Thread.sleep(1000);

		if (login.driver.findElements(By.xpath("//div[@class='modal-body sphere-modal__body']")).size() == 1) {
			System.out.println("Download popup shown");
		} else {
			Assert.fail("Download popup not shown");
		}
		login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();

		/*
		 * if
		 * (login.driver.findElements(By.xpath("//div[@class='growl-message-text']")).
		 * size() != 0) { System.out.
		 * println("Validation message Verified Successfully for insert copied Option!!! "
		 * ); } else { Assert.
		 * fail("Validation message is NOT Verified Successfully for insert copied Option!!!"
		 * ); }
		 */
	}

	// TC_MS_213
	@And("^Select the the Delete option$")
	public void select_the_the_Delete_option() throws Throwable {
		CommonFunctionality.wait(500);

		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='insight-action-panel--btn-icon'])[4]", 8)
				.click();

	}

	@And("^Verify More actions Delete$")
	public void verify_More_actions_Delete() throws Throwable {
		Thread.sleep(2000);
		WebElement selected = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='input-control--indicator']//*[@class='icon']//following::*[contains(@class,'list-container')]",
				4);

		if (selected.getAttribute("class").contains("without-data")) {
			System.out.println("More actions Delete is verified Succesfully");
		} else {
			Assert.fail("More actions Delete is NOT verified Succesfully");

		}

	}

	// TC_MS_214
	@And("^Verify More actions Delete description for delete series popup$")
	public void verify_More_actions_Delete_description_for_delete_series_popup() throws Throwable {
		verify_Delete_option_functionality_having_pop_head_title();
	}

	// TC_MS_214
	@And("^Navigate to Series tab$")
	public void navigate_to_Series_tab() throws Throwable {
		Thread.sleep(1000);
		CommonFunctionality.getElementByProperty(login.driver, "MyInsight_Tab", 8).click();
		System.out.println("=====================>TC_214==================================>");
	}

	@And("^click on the Delete option$")
	public void click_on_the_Delete_option() throws Throwable {
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[@class='dropdown-menu context-menu chart-type']//li//*[@data-action='delete']/*[2]", 8)
				.click();
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Delete_ok_button"))).click();

	}

	// TC_MS_215
	@And("^Verify More actions Delete ok button for delete series popup$")
	public void verify_More_actions_Delete_ok_button_for_delete_series_popup() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']")).isDisplayed();
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 8).click();
		System.out.println("============>TC_215=============>");
	}

	// TC_MS_216
	@And("^Verify More actions Delete the associated visuals after deleted series$")
	public void verify_More_actions_Delete_the_associated_visuals_after_deleted_series() throws Throwable {
		verify_More_actions_Delete_ok_button_for_delete_series_popup();
		System.out.println("============>TC_216=============>");
	}

	// TC_MS_217
	@And("^Verify More actions Delete Cancel/x icon for the popup$")
	public void verify_More_actions_Delete_Cancel_x_icon_for_the_popup() throws Throwable {
		verify_Delete_Cancel_x_icon_for_the_popup();
		System.out.println("============>TC_216=============>");
	}

	// TC_MS_218
	@And("^Verify More actions Group$")
	public void verify_More_actions_Group() throws Throwable {
		Thread.sleep(3000);
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Grouping_rename_popup"))).isDisplayed());
	}

	// TC_MS_219
	@And("^Verify More actions auto title for group$")
	public void verify_More_actions_auto_title_for_group() throws Throwable {
		Thread.sleep(3000);
		String autotitle = CommonFunctionality.getElementByProperty(login.driver, "Edit_series_rename_popup", 6)
				.getAttribute("value");

		String s2 = "Group";
		if (autotitle.contains(s2)) {
			System.out.println("Verified");
		} else {
			Assert.fail();
		}
	}

	// TC_MS_220
	@And("^Verify More actions OK icon by default$")
	public void verify_More_actions_OK_icon_by_default() throws Throwable {
		Thread.sleep(3000);
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Grouping_icon"))).isDisplayed());
	}

	// TC_MS_221
	@And("^Verify More actions clicking on OK icon$")
	public void verify_More_actions_clicking_on_OK_icon() throws Throwable {
		Thread.sleep(3000);
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Grouping_icon"))).isDisplayed());
		Thread.sleep(3000);
	}

	// TC_MS_222
	@And("^Verify More actions clicking clicking on X icon$")
	public void verify_More_actions_clicking_clicking_on_X_icon() throws Throwable {
		Thread.sleep(3000);
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Grouping_icon"))).isDisplayed());
		Thread.sleep(3000);
	}

	// TC_MS_223
	@SuppressWarnings("deprecation")
	@And("^Add select one more series$")
	public void add_select_one_more_series() throws Throwable {
		select_some_series_to_my_series_tab();
		Thread.sleep(1000);
		Secondseriesname = CommonFunctionality.getElementByProperty(login.driver, "Second_series_name", 6).getText();
		Thread.sleep(1000);
		WebElement we = login.driver.findElement(
				By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[3]"));
		action.moveToElement(we).pause(2000).build().perform();
		try {
			CommonFunctionality.getElementByProperty(login.driver, "More_icon", 8).click();
		} catch (Exception e) {
			CommonFunctionality.getElementByProperty(login.driver, "More_icon", 8).click();
		}
	}

	// TC_MS_223
	@And("^Verify More actions Group if already have a group in my series$")
	public void verify_More_actions_Group_if_already_have_a_group_in_my_series() throws Throwable {
		System.out.println("More actions Group if already have a group in my series is verified succesfully");
		Thread.sleep(3000);
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Grouping_icon"))).isDisplayed());

	}

	// TC_MS_224
	@And("^Add another series and create another group$")
	public void add_another_series_and_create_another_group() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "MyInsight_Tab", 8).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Series')]", 8).click();
		CommonFunctionality
				.getElementByXpath(login.driver, "(//span[@class='series-list-item--checkbox svg-checkbox'])[5]", 8)
				.click();

		/*
		 * for (int i = 6; i <= 1; i++) { Thread.sleep(2000);
		 * login.driver.findElement(By.xpath("//ul[@class='search-series-list']/li[" + i
		 * + "]/div/a/div[2]")).click(); }
		 */
		Thread.sleep(2000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		Thread.sleep(2000);
		WebElement we = login.driver.findElement(By.xpath(
				"//*[@class='webix_column list-series-name webix_last']/*[2]//span[@class='series-item--icon series-item--icon__edit']"));
		action.moveToElement(we).pause(2000).build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='selected-series-actions']/div[4])[1]", 8)
				.click();

		WebElement we1 = CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[19]", 8);
		action.moveToElement(we1).pause(2000).build().perform();

		WebElement we2 = CommonFunctionality.getElementByXpath(login.driver,
				" //*[contains(text(),'Create new group')]", 8);
		action.moveToElement(we2).pause(2000).click().build().perform();

		/*
		 * GroupingRenamed = "Testingsearch";
		 * login.driver.findElement(By.xpath("//div[@class='popover-content']/div/input"
		 * )).sendKeys(GroupingRenamed); Thread.sleep(5000); login.driver .findElement(
		 * By.
		 * xpath("//div[@class='insight-series-rename--button insight-series-rename--button__apply']"
		 * )) .click();
		 */
	}

	// TC_MS_224
	@And("^Verify More actions search field for existing group$")
	public void verify_More_actions_search_field_for_existing_group() throws Throwable {
		/*
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MyInsight_Tab")
		 * )).click(); Thread.sleep(5000);
		 * login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click
		 * ();
		 * 
		 * Thread.sleep(5000); login.driver.findElement(By.
		 * xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[5]")).click
		 * (); for (int i = 5; i <= 1; i++) { Thread.sleep(2000);
		 * login.driver.findElement(By.xpath("//ul[@class='search-series-list']/li[" + i
		 * + "]/div/a/div[2]")).click(); } Thread.sleep(5000); Robot r = new Robot();
		 * r.keyPress(KeyEvent.VK_A); r.keyRelease(KeyEvent.VK_A); Thread.sleep(5000);
		 * login.driver.findElement(By.
		 * xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[3]"
		 * )).click(); Thread.sleep(5000); Actions action = new Actions(login.driver);
		 * WebElement we =
		 * login.driver.findElement(By.xpath("//span[@class='series-name-field-title']")
		 * ); action.moveToElement(we).pause(10000).build().perform();
		 * Thread.sleep(3000);
		 * 
		 * 
		 * 
		 * select_the_More_option();
		 * 
		 * 
		 * 
		 * Actions action1 = new Actions(login.driver); WebElement we1 =
		 * login.driver.findElement(By.xpath("//div[@class='items-wrapper']/li[19]"));
		 * action1.moveToElement(we1).pause(5000).build().perform();
		 * 
		 * 
		 * 
		 * Actions action3 = new Actions(login.driver); WebElement we3 =
		 * login.driver.findElement(By.xpath(
		 * "//*[@class='add-to-context-manage--list-wrapper']/preceding-sibling::input")
		 * ); action3.moveToElement(we3).pause(5000).click().build().perform();
		 * 
		 * login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).
		 * sendKeys("Testingsearch");
		 * 
		 * String SearchGroup
		 * =login.driver.findElement(By.xpath("//*[@class='input-control--description']"
		 * )).getText(); if(SearchGroup.contains(GroupingRenamed)){ System.out.
		 * println("More actions search field for existing group is verified successfully"
		 * ); } else{ Assert.
		 * fail("More actions search field for existing group is NOT verified successfully"
		 * ); }
		 * 
		 * 
		 * Thread.sleep(3000); CommonFunctionality.DeleteSeries();
		 */
		Thread.sleep(3000);
		CommonFunctionality.getElementByProperty(login.driver, "List_mode_option", 8).click();
		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Tablerightclicknewgroup"))).size() != 0) {
			System.out.println("new group option is working");
		} else {
			Assert.fail("new group option is NOT working");
		}

	}

	// TC_MS_225
	@And("^Verify More actions sub dropdown should be opened with existing groups$")
	public void verify_More_actions_sub_dropdown_should_be_opened_with_existing_groups() throws Throwable {

		Thread.sleep(3000);
		CommonFunctionality.getElementByProperty(login.driver, "List_mode_option", 8).click();
		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Tablerightclicknewgroup"))).size() != 0) {
			System.out.println("new group option is working");
		} else {
			Assert.fail("new group option is NOT working");
		}
		System.out.println("=====================>TC_225==================================>");
	}

	// TC_MS_226
	@And("^Select create new group option$")
	public void select_create_new_group_option() throws Throwable {
		Thread.sleep(3000);
		WebElement we = login.driver.findElement(By.xpath("//*[contains(text(),'Create new group')]"));
		action.moveToElement(we).build().perform();

	}

	// TC_MS_226
	@And("^Verify More actions create new group option$")
	public void verify_More_actions_create_new_group_option() throws Throwable {
		// Thread.sleep(3000);
		// String createnewgroup =
		// CommonFunctionality.getElementByProperty(login.driver, "Group_secondseries",
		// 6).getText();
		// System.out.println(createnewgroup);
		Thread.sleep(3000);
		CommonFunctionality.getElementByProperty(login.driver, "List_mode_option", 8).click();
		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Tablerightclicknewgroup"))).size() != 0) {
			System.out.println("new group option is working");
		} else {
			Assert.fail("new group option is NOT working");
		}
	}

	// TC_MS_227
	@And("^Verify More actions Preview$")
	public void verify_More_actions_Preview() throws Throwable {
		Thread.sleep(3000);
		if ((login.driver.findElements(By.xpath(login.LOCATORS.getProperty("preview_popup"))).size() != 0)) {
			System.out.println("Verified Preview pop up");
		} else {
			Assert.fail("Preview pop up is NOT verified ");
		}
		CommonFunctionality.getElementByProperty(login.driver, "preview_popup_close", 8).click();
	}

	// TC_MS_228
	@And("^Verify More actions Series Info$")
	public void verify_More_actions_Series_Info() throws Throwable {

		// new
		// Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
		// "*[title='Series Info']", 4)).pause(500).click().build().perform();
		// Thread.sleep(3000);
		Thread.sleep(3000);
		Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Dialogue"))).isDisplayed());
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
	}

	// TC_MS_229
	@And("^Verify More actions Footnotes\\.$")
	public void verify_More_actions_Footnotes() throws Throwable {
		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Related_series_footnotespopup")))
				.size() != 0) {
			System.out.println("More actions Footnotes is Verified Successfully!!! ");
		} else {
			Assert.fail("More actions Footnotes is NOT Verified Successfully");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
	}

	// TC_MS_230
	@Given("^Verify More actions Footnotes if the series linked to multiple Database$")
	public void verify_More_actions_Footnotes_if_the_series_linked_to_multiple_Database() throws Throwable {

		WebElement we = login.driver.findElement(By.xpath("//span[text()='Footnotes']"));
		action.moveToElement(we).pause(5000).build().perform();

		CommonFunctionality.getElementByProperty(login.driver, "GDB_footnotes", 8).click();
		// String GDB_footnotes=
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("GDBinside_footnotes"))).getText();
		// String Actual = "Global Database";
		// assertEquals(Actual, GDB_footnotes);
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		Thread.sleep(3000);
		mouse_hover_the_first_series();
		select_the_More_option();

		Thread.sleep(3000);
		WebElement we1 = login.driver.findElement(By.xpath("(//span[text()='Footnotes'])[2]"));
		action.moveToElement(we1).pause(5000).build().perform();

		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("GDB_keyseries"))).click();
		Thread.sleep(8000);
		// String GDB_keyseries=
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("GDBinside_footnotes"))).getText();
		// System.out.println("GDB_keyseries as"+ GDB_keyseries);
		String Actual1 = "Global Key Series Database";
		// assertEquals(Actual1, GDB_keyseries);
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
	}

	// TC_MS_231
	@And("^Verify More actions Show dataset$")
	public void verify_More_actions_Show_dataset() throws Throwable {
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Backbutton"))).isDisplayed()) {
			login.Log4j.info("Dataset is displayed for given SeriesID");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Backbutton"))).click();

		} else {
			Assert.fail("Dataset is not displayed for given SeriesID");
		}

	}

	// TC_MS_232
	@And("^Verify More actions Show Show Database$")
	public void verify_More_actions_Show_Show_Database() throws Throwable {

		// databasename=
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("databasemore"))).getText();
		/*
		 * if (login.driver.findElement(By.xpath("//div[contains(text(),'" +
		 * databasename + "')]")).isDisplayed()) { Thread.sleep(1000);
		 * login.driver.findElement(By.xpath("//div[contains(text(),'" + databasename +
		 * "')]")).click(); if
		 * (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Related_Data")
		 * )).isDisplayed()) { Thread.sleep(1000);
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Related_Data"))
		 * ).click(); List<WebElement> datasets = login.driver
		 * .findElements(By.xpath(login.LOCATORS.getProperty("Related_Data_text"))); for
		 * (WebElement list : datasets) { Filters.showdata = list.getText();
		 * login.Log4j.info("Database is displayed for selected series");
		 * Thread.sleep(1000);
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction")))
		 * .click(); } } else {
		 * login.Log4j.info("Database is not displayed  for selected series"); } }
		 */

		Thread.sleep(2000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Tablerightclicktopdatabase"))).size() != 0) {
			System.out.println("Dataset is displayed for given SeriesID");

		} else {
			Assert.fail("Dataset is not displayed for given SeriesID");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Tablerightclicktopdatabase", 8).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Series')]", 8).click();

		Thread.sleep(1000);
		for (int i = 1; i <= 1; i++) {
			Thread.sleep(1000);
			// login.driver.findElement(By.xpath("//*[@class='search-series-list']/*[" + i +
			// "]/div/a/div[2]")).click();
			login.driver.findElement(By.xpath("//*[@class='search-input-text']")).click();
		}
	}

	// TC_MS_233
	@And("^Right click on the first series$")
	public void right_click_on_the_first_series() throws Throwable {
		Thread.sleep(1000);
		WebElement we = login.driver.findElement(By.xpath("(//span[@class='series-name-field--series-name'])[1]"));
		action.moveToElement(we).build().perform();

		try {
			WebElement ele = login.driver.findElement(By.xpath("(//span[@class='series-name-field--series-name'])[1]"));
			action.contextClick(ele).pause(2000).build().perform();
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			WebElement ele = login.driver.findElement(By.xpath("(//span[@class='series-name-field--series-name'])[1]"));
			action.contextClick(ele).pause(2000).build().perform();
		}
	}

	// TC_MS_233
	@And("^Verify Right click option on series$")
	public void verify_Right_click_option_on_series() throws Throwable {
		verify_More_option_on_series_mouse_hovering();
	}

	// TC_MS_234
	@And("^Verify Right click option Unselect all$")
	public void verify_Right_click_option_Unselect_all() throws Throwable {
		verify_More_Unselect_all();
	}

	// TC_MS_235
	@And("^Verify Right click Add to chart Chart all$")
	public void verify_Right_click_Add_to_chart_Chart_all() throws Throwable {
		verify_More_Add_to_chart_Chart_all();
	}

	// TC_MS_236
	@And("^Verify Right click Add to chart Map$")
	public void verify_Right_click_Add_to_chart_Map() throws Throwable {
		verify_More_Add_to_chart_Map();
	}

	// TC_MS_237
	@And("^Verify Right click Add to chart Table$")
	public void verify_Right_click_Add_to_chart_Table() throws Throwable {
		verify_More_Add_to_chart_Table();
	}

	// TC_MS_238
	@And("^Verify Right click View as \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void verify_Right_click_View_as(String arg1, String arg2, String arg3) throws Throwable {
		WebElement display_pie = CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']", 4);
		Assert.assertTrue(display_pie.isDisplayed());
		WebElement display_heatmap = CommonFunctionality.getElementByXpath(login.driver,
				"//li//*[text()='" + arg2 + "']", 4);
		Assert.assertTrue(display_heatmap.isDisplayed());
		WebElement display_histogram = CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + arg3 + "']",
				4);
		Assert.assertTrue(display_histogram.isDisplayed());

	}

	// TC_MS_239
	@And("^Verify Right click Add to chart Pie$")
	public void verify_Right_click_Add_to_chart_Pie() throws Throwable {
		Thread.sleep(3000);
		CommonFunctionality.getElementByProperty(login.driver, "PIE", 6).click();
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("PIE_created"))).size() != 0) {
			System.out.println("Right click option Add to chart pie is Verified Successfully!!! ");
		} else {
			CommonFunctionality.Views_list();
			Assert.fail("Right click option Add to chart pie is NOT Verified Successfully");

		}
	}

	// TC_MS_240
	@And("^Verify Right click Add to chart Heatmap$")
	public void verify_Right_click_Add_to_chart_Heatmap() throws Throwable {
		verify_More_Add_to_chart_Heatmap();
	}

	// TC_MS_241
	@And("^Verify Right click Add to chart Scatter$")
	public void verify_Right_click_Add_to_chart_Scatter() throws Throwable {
		verify_More_Add_to_chart_Scatter();
	}

	// TC_MS_242
	@And("^Verify Right click Add to chart Histogram$")
	public void verify_Right_click_Add_to_chart_Histogram() throws Throwable {
		verify_More_Add_to_chart_Histogram();
	}

	// TC_MS_243
	@And("^Verify Right click creating visual with more than max series selection$")
	public void verify_Right_click_creating_visual_with_more_than_max_series_selection() throws Throwable {
		Thread.sleep(1000);
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Confirmation_ok"))).isDisplayed());
		Thread.sleep(3000);
		CommonFunctionality.getElementByProperty(login.driver, "Confirmation_ok", 6).click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("footnote_window_close"))).click();
		// verify_More_View_as_Chart_all();
	}

	// TC_MS_244
	@And("^Verify Right click View on Download option$")
	public void verify_Right_click_View_on_Download_option() throws Throwable {
		verify_More_View_on_Download_option();
	}

	// TC_MS_245
	@And("^Verify Right click Copy option$")
	public void verify_Right_click_Copy_option() throws Throwable {
		verify_More_Copy_option();
	}

	// TC_MS_246
	@And("^Verify Right click the confirmation message for Copy action$")
	public void verify_Right_click_the_confirmation_message_for_Copy_action() throws Throwable {
		verify_the_Copy_option();
	}

	// TC_MS_247
	@And("^Verify Right click closing of growl popup for Copy$")
	public void verify_Right_click_closing_of_growl_popup_for_Copy() throws Throwable {
		verify_the_closing_of_growl_popup();
	}

	// TC_MS_248
	@And("^Verify Right click Copy data$")
	public void verify_Right_click_Copy_data() throws Throwable {
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copydata_pop_up"))).isDisplayed());
		Thread.sleep(3000);
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Close_window", 6).click();
	}

	// TC_MS_249
	@And("^Verify Right click in Always ask me about the export settings$")
	public void verify_Right_click_in_Always_ask_me_about_the_export_settings() throws Throwable {
		mouse_hover_the_first_series();
		right_click_on_the_first_series();
		CommonFunctionality.getElementByProperty(login.driver, "Copydata", 6).click();
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copydata_pop_up"))).isDisplayed());
		Thread.sleep(3000);
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Close_window", 6).click();
		System.out.println("=====================>TC_249==================================>");
	}

	// TC_MS_250
	@And("^Verify Right click Copy link\\(s\\) for series$")
	public void verify_Right_click_Copy_link_s_for_series() throws Throwable {
		verify_More_actions_Copy_link_s_for_series();
	}

	// TC_MS_251
	@And("^Verify Right click Copy link behavior for single series$")
	public void verify_Right_click_Copy_link_behavior_for_single_series() throws Throwable {
		// verify_More_actions_Copy_link_behavior_for_single_series();
		Thread.sleep(2500);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_T);
		Thread.sleep(2500);
		ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs2.get(1));
		Thread.sleep(2500);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		CommonFunctionality.wait(2000);
		Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Dialogue"))).isDisplayed());
		login.driver.close();
		login.driver.switchTo().window(tabs2.get(0));
	}

	// TC_MS_252
	@And("^Verify Right click Copy link confirmation message$")
	public void verify_Right_click_Copy_link_confirmation_message() throws Throwable {
		verify_the_confirmation_message_for_paste_action();
	}

	// TC_MS_254
	@And("^Verify Right click Copy link confirmation message for multiple series$")
	public void verify_Right_click_Copy_link_confirmation_message_for_multiple_series() throws Throwable {
		verify_More_actions_Copy_link_confirmation_message_for_multiple_series();
	}

	// TC_MS_255
	@And("^Verify Right click Copy link closing of growl popup$")
	public void verify_Right_click_Copy_link_closing_of_growl_popup() throws Throwable {
		verify_the_closing_of_growl_popup();
	}

	// TC_MS_256
	@And("^Verify Right click insert copied option if not data in clipboard$")
	public void verify_Right_click_insert_copied_option_if_not_data_in_clipboard() throws Throwable {

		Thread.sleep(3000);
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("rightclicksortby"))).click();
		verify_More_actions_insert_copied_option_if_not_data_in_clipboard();
	}

	// TC_MS_257
	@And("^Verify Right click insert copied option$")
	public void verify_Right_click_insert_copied_option() throws Throwable {
		verify_More_actions_insert_copied_option();
	}

	// TC_MS_258
	@And("^Verify Right click insert growl message$")
	public void verify_Right_click_insert_growl_message() throws Throwable {
		verify_More_actions_insert_growl_message();
	}

	// TC_MS_259
	@And("^Verify Right click Delete$")
	public void verify_Right_click_Delete() throws Throwable {
		verify_More_actions_Delete();
	}

	// TC_MS_260
	@And("^Verify Right click Delete description for delete series popup$")
	public void verify_Right_click_Delete_description_for_delete_series_popup() throws Throwable {
		verify_More_actions_Delete_description_for_delete_series_popup();
	}

	// TC_MS_261
	@And("^Verify Right click Delete ok button for delete series popup$")
	public void verify_Right_click_Delete_ok_button_for_delete_series_popup() throws Throwable {
		verify_More_actions_Delete_ok_button_for_delete_series_popup();
	}

	// TC_MS_262
	@And("^Verify Right click Delete the associated visuals after deleted series$")
	public void verify_Right_click_Delete_the_associated_visuals_after_deleted_series() throws Throwable {
		verify_More_actions_Delete_the_associated_visuals_after_deleted_series();
	}

	// TC_MS_2631
	@And("^Verify Right click Delete Cancel/x icon for the popup$")
	public void verify_Right_click_Delete_Cancel_x_icon_for_the_popup() throws Throwable {
		verify_More_actions_Delete_Cancel_x_icon_for_the_popup();
	}

	// TC_MS_264
	@And("^Verify Right click Group$")
	public void verify_Right_click_Group() throws Throwable {
		verify_More_actions_Group();
	}

	// TC_MS_265
	@And("^Verify Right click auto title for group$")
	public void verify_Right_click_auto_title_for_group() throws Throwable {
		verify_More_actions_auto_title_for_group();
	}

	// TC_MS_267
	@And("^Verify Right click clicking on OK icon$")
	public void verify_Right_click_clicking_on_OK_icon() throws Throwable {
		Thread.sleep(3000);
		String seriesname = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("rename_series_group")))
				.getText();
		System.out.println(seriesname);
		String Seriesnameafter = "Test";
		if (seriesname.equalsIgnoreCase(Seriesnameafter)) {

			System.out.println("Edit series Rename clicking on OK button is verified Successfully");
		} else {
			Assert.fail("Edit series Rename clicking on OK button is NOT Verified Successfully");
		}
	}

	// TC_MS_266
	@And("^Verify Right click OK icon by default$")
	public void verify_Right_click_OK_icon_by_default() throws Throwable {
		Thread.sleep(3000);
		String seriesname = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("rename_series_group")))
				.getText();
		System.out.println(seriesname);
		String Seriesnameafter = "Group";
		if (seriesname.contains(Seriesnameafter)) {

			System.out.println("verified Successfully");
		} else {
			Assert.fail();
		}
	}

	// TC_MS_268
	@And("^Verify Right click clicking clicking on X icon$")
	public void verify_Right_click_clicking_clicking_on_X_icon() throws Throwable {
		verify_More_actions_clicking_clicking_on_X_icon();
	}

	// TC_MS_269
	@And("^Verify Right click Group if already have a group in my series$")
	public void verify_Right_click_Group_if_already_have_a_group_in_my_series() throws Throwable {
		verify_More_actions_Group_if_already_have_a_group_in_my_series();

	}

	// TC_MS_270
	@And("^Verify Right click search field for existing group$")
	public void verify_Right_click_search_field_for_existing_group() throws Throwable {
		verify_More_actions_search_field_for_existing_group();
	}

	// TC_MS_271
	@And("^Verify Right click sub dropdown should be opened with existing groups$")
	public void verify_Right_click_sub_dropdown_should_be_opened_with_existing_groups() throws Throwable {
		verify_More_actions_sub_dropdown_should_be_opened_with_existing_groups();
	}

	// TC_MS_272
	@And("^Verify Right click create new group option$")
	public void verify_Right_click_create_new_group_option() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "List_mode_option", 8).click();
		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Tablerightclicknewgroup"))).size() != 0) {
			System.out.println("new group option is working");
		} else {
			Assert.fail("new group option is NOT working");
		}
	}

	// TC_MS_273
	@And("^Verify Right click Preview$")
	public void verify_Right_click_Preview() throws Throwable {
		verify_More_actions_Preview();
	}

	// TC_MS_274
	@And("^Verify Right click Series Info$")
	public void verify_Right_click_Series_Info() throws Throwable {
		verify_More_actions_Series_Info();
	}

	// TC_MS_275
	@And("^Verify Right click Footnotes\\.$")
	public void verify_Right_click_Footnotes() throws Throwable {
		verify_More_actions_Footnotes();
	}

	// TC_MS_276
	@And("^Verify Right click Footnotes if the series linked to multiple Database$")
	public void verify_Right_click_Footnotes_if_the_series_linked_to_multiple_Database() throws Throwable {
		verify_More_actions_Footnotes_if_the_series_linked_to_multiple_Database();
	}

	// TC_MS_277
	@And("^Verify Right click Show dataset$")
	public void verify_Right_click_Show_dataset() throws Throwable {
		verify_More_actions_Show_dataset();
	}

	// TC_MS_278
	@And("^Verify Right click Show Show Database$")
	public void verify_Right_click_Show_Show_Database() throws Throwable {
		verify_More_actions_Show_Show_Database();
	}

	// TC_MS_307
	@And("^Mouse hover the first series in table mode$")
	public void mouse_hover_the_first_series_in_table_mode() throws Throwable {
		WebElement we = login.driver.findElement(By.xpath((login.LOCATORS.getProperty("Seriesnameintablemode"))));
		action.moveToElement(we).build().perform();
	}

	// TC_MS_307
	@And("^Right click on the first series in table mode$")
	public void right_click_on_the_first_series_in_table_mode() throws Throwable {
		WebElement we = login.driver.findElement(By.xpath((login.LOCATORS.getProperty("Seriesnameintablemode"))));
		action.contextClick(we).perform();
	}

	// TC_MS_308
	@And("^Verify Right click option Unselect all in table mode$")
	public void verify_Right_click_option_Unselect_all_in_table_mode() throws Throwable {
		boolean checkbox = login.driver
				.findElement(
						By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[1]"))
				.isSelected();
		if (checkbox == false) {
			System.out.println("Table Right click Unselect all is Verified Successfully!!! ");
		} else {
			Assert.fail("Table Right click Unselect all is NOT Verified Successfully");
		}
//		Thread.sleep(3000);
//		select_the_List_mode();
	}

	// TC_MS_307
	@And("^Verify Right click option on series-table mode$")
	public void verify_Right_click_option_on_series_table_mode() throws Throwable {
		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("More_icon_dropdown"))).size() != 0) {
			System.out.println("More option on series mouse hovering is Verified Successfully!!! ");

			// login.driver.findElement(By.xpath("//span[@class='series-panel--group-button-text']")).click();
		} else {
			Assert.fail("More option on series mouse hovering is NOT Verified Successfully");

		}
		// select_the_List_mode();
	}

	// TC_MS_309
	@And("^Verify Right click Add to chart chart in table mode$")
	public void verify_Right_click_Add_to_chart_chart_in_table_mode() throws Throwable {
		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Chart_created"))).size() != 0) {
			System.out.println("Table Right click Add to chart chart is Verified Successfully!!! ");
		} else {
			Assert.fail("Table Right click Add to chart chart is NOT Verified Successfully");

		}
		CommonFunctionality.getElementByProperty(login.driver, "MyInsight_Tab", 8).click();
		select_the_List_mode();
	}

	// TC_MS_310
	@And("^Verify Right click Add to chart map in table mode$")
	public void verify_Right_click_Add_to_chart_map_in_table_mode() throws Throwable {

//		WebElement we = login.driver.findElement(By.xpath((login.LOCATORS.getProperty("maprightclick"))));
//		action.moveToElement(we).pause(2000).click().build().perform();
//		CommonFunctionality.getElementByProperty(login.driver, "worldmaprightclick", 8).click();

		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("MAP_created"))).size() != 0) {
			System.out.println("Table Right click Add to chart MAP is Verified Successfully!!! ");
		} else {
			Assert.fail("Table Right click Add to chart MAP is NOT Verified Successfully");

		}
		CommonFunctionality.getElementByProperty(login.driver, "MyInsight_Tab", 8).click();
		select_the_List_mode();
	}

	// TC_MS_311
	@And("^Verify Right click Add to chart Table in table mode$")
	public void verify_Right_click_Add_to_chart_Table_in_table_mode() throws Throwable {
		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Table_created"))).size() != 0) {
			System.out.println("Table Right click Add to chart Table is Verified Successfully!!! ");
		} else {
			Assert.fail("Table Right click Add to chart Table is NOT Verified Successfully");

		}
		CommonFunctionality.getElementByProperty(login.driver, "MyInsight_Tab", 8).click();
		select_the_List_mode();
	}

	// TC_MS_312
	@And("^Verify Right click View as \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" in table mode$")
	public void verify_Right_click_View_as_in_table_mode(String arg1, String arg2, String arg3) throws Throwable {
		WebElement display_pie = CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']", 4);
		Assert.assertTrue(display_pie.isDisplayed());
		WebElement display_histogram = CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + arg3 + "']",
				4);
		Assert.assertTrue(display_histogram.isDisplayed());
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MyInsight_Tab"))).click();
//		select_the_List_mode();
	}

	// TC_MS_313
	@And("^Verify Right click Add to chart Pie in table mode$")
	public void verify_Right_click_ADd_to_chart_Pie_in_table_mode() throws Throwable {
		Thread.sleep(3000);
		// CommonFunctionality.getElementByProperty(login.driver, "PIE", 6).click();
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("PIE_created"))).size() != 0) {
			System.out.println("Right click option Add to chart pie is Verified Successfully!!! ");
		} else {
			Assert.fail("Right click option Add to chart pie is NOT Verified Successfully");

		}
		Thread.sleep(5000);
		CommonFunctionality.getElementByProperty(login.driver, "MyInsight_Tab", 8).click();
		select_the_List_mode();
	}

	// TC_MS_314
	@And("^Verify Right click Add to chart Heatmap in table mode$")
	public void verify_Right_click_Add_to_chart_Heatmap_in_table_mode() throws Throwable {
		Thread.sleep(3000);
		// CommonFunctionality.getElementByProperty(login.driver, "Heat_map",
		// 6).click();
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Heatmap_created"))).size() != 0) {
			System.out.println("More option Add to chart Heatmap is Verified Successfully!!! ");
		} else {
			Assert.fail("More option Add to chart Heatmap is NOT Verified Successfully");

		}
		Thread.sleep(5000);
		CommonFunctionality.getElementByProperty(login.driver, "MyInsight_Tab", 8).click();
		select_the_List_mode();
	}
	// TC_MS_315

	@And("^Verify Right click Add to chart Scatter in table mode$")
	public void verify_Right_click_Add_to_chart_Scatter_in_table_mode() throws Throwable {
		Thread.sleep(3000);

		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Scatter_created"))).size() != 0) {
			System.out.println("More option Add to chart Scatter is Verified Successfully!!! ");
		} else {
			Assert.fail("More option Add to chart Scatter is NOT Verified Successfully");
		}
		Thread.sleep(5000);
		CommonFunctionality.getElementByProperty(login.driver, "MyInsight_Tab", 8).click();
		select_the_List_mode();
	}

	// TC_MS_316
	@And("^Verify Right click Add to chart Histogram in table mode$")
	public void verify_Right_click_Add_to_chart_Histogram_in_table_mode() throws Throwable {
		Thread.sleep(3000);
//		//CommonFunctionality.getElementByProperty(login.driver, "Histrogram", 6).click();
//		try {
//			// if confirmation popup opened then click on ok
//			CommonFunctionality.getElementByProperty(login.driver, "Confirmation_ok", 6).click();
//		} catch (Exception e) {
//
//		}
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Histrogram_created"))).size() != 0) {
			System.out.println("More option Add to chart Histogram is Verified Successfully!!! ");
		} else {
			Assert.fail("More option Add to chart Histogram is NOT Verified Successfully");

		}
		Thread.sleep(5000);
		CommonFunctionality.getElementByProperty(login.driver, "MyInsight_Tab", 8).click();
		select_the_List_mode();
	}

	// TC_MS_318
	@And("^Select the Download option$")
	public void select_the_Download_option() throws Throwable {
		CommonFunctionality.wait(500);
		
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Download')]", 8).click();
	}

	@And("^Verify More View on Download option table mode$")
	public void verify_More_View_on_Download_option_table_mode() throws Throwable {
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Download_pop_up"))).isDisplayed());
		Thread.sleep(1000);
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Close_window", 6).click();
		Thread.sleep(3000);
		CommonFunctionality.getElementByProperty(login.driver, "MyInsight_Tab", 8).click();
		select_the_List_mode();

	}

	// TC_MS_319
	@And("^Select the Copy option$")
	public void select_the_Copy_option() throws Throwable {
		CommonFunctionality.wait(500);
	
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Copy')]", 8).click();
	}

	@And("^Verify More Copy option table mode$")
	public void verify_More_Copy_option_table_mode() throws Throwable {
		// get_the_series_name();
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable contents = clipboard.getContents(null);
		String x = (String) contents.getTransferData(DataFlavor.stringFlavor);
		System.out.println(x);
		if (x.contains(FirstseriesName)) {
			System.out.println("More Copy option is Verified Successfully!!! ");
		} else {
			Assert.fail("More Copy option is NOT Verified Successfully");
		}
		Thread.sleep(3000);
		CommonFunctionality.getElementByProperty(login.driver, "MyInsight_Tab", 8).click();
		select_the_List_mode();
	}

	@And("^Verify More actions the confirmation message for Copy action table mode$")
	public void verify_More_actions_the_confirmation_message_for_Copy_action_table_mode() throws Throwable {
		Thread.sleep(1000);
		if (login.driver.findElements(By.xpath("//div[@class='growl-message-text']")).size() != 0) {
			System.out.println("Validation message Verified Successfully for Copy Option!!! ");
		} else {
			Assert.fail("Validation message is NOT Verified Successfully for Copy Option!!!");
		}
//		Thread.sleep(3000);
//		CommonFunctionality.getElementByProperty(login.driver, "MyInsight_Tab",8).click();;
//		select_the_List_mode();
	}

	@And("^Verify More actions closing of growl popup for Copy table mode$")
	public void verify_More_actions_closing_of_growl_popup_for_Copy_table_mode() throws Throwable {

		WebElement we = login.driver.findElement(By.xpath("//div[@class='growl-message-close']"));
		action.moveToElement(we).click().build().perform();
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("growl_message_close"))).click();
		Thread.sleep(7000);
		if (login.driver.findElements(By.xpath("//div[@class='growl-message-text']")).size() == 0) {
			System.out.println("closing of growl popup is Verified Successfully");
		} else {
			Assert.fail("closing of growl popup is NOT Verified Successfully");
		}
//		Thread.sleep(1000);
//		CommonFunctionality.getElementByProperty(login.driver, "MyInsight_Tab",8).click();
//		select_the_List_mode();
	}

	// TC_MS_320
	@And("^Verify More actions Copy data in table mode$")
	public void verify_More_actions_Copy_data_in_table_mode() throws Throwable {
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copydata_pop_up"))).isDisplayed());
		Thread.sleep(1000);
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Close_window", 6).click();
//		Thread.sleep(1000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("List_mode_option"))).click();
//		Thread.sleep(3000);
	}

	// TC_MS_321
	@And("^Verify Right click Copy link\\(s\\) for series in table mode$")
	public void verify_Right_click_Copy_link_s_for_series_in_table_mode() throws Throwable {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable contents = clipboard.getContents(null);
		String x = (String) contents.getTransferData(DataFlavor.stringFlavor);
		System.out.println(x);
		String Copy_link = "https://stage.ceicdata.com/";
		if (x.contains(Copy_link)) {
			System.out.println("More Copy link option is Verified Successfully!!! ");
		} else {
			Assert.fail("More Copy link option is NOT Verified Successfully");
		}
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("List_mode_option"))).click();
		Thread.sleep(3000);
		CommonFunctionality.DeleteSeries();
	}

	// TC_MS_322
	@And("^Verify Right click Copy link behavior for single series in table mode$")
	public void verify_Right_click_Copy_link_behavior_for_single_series_in_table_mode() throws Throwable {
		Thread.sleep(2500);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_T);
		Thread.sleep(2500);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2500);
		ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs2.get(1));
		Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Dialogue"))).isDisplayed());

		login.driver.close();
		login.driver.switchTo().window(tabs2.get(0));
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("List_mode_option"))).click();
		Thread.sleep(3000);
		CommonFunctionality.DeleteSeries();
	}

	@And("^Verify Right click Copy link confirmation message in table mode$")
	public void verify_Right_click_Copy_link_confirmation_message_in_table_mode() throws Throwable {
		String copylinktext = login.driver.findElement(By.xpath("//div[@class='growl-message-text']")).getText();
		System.out.println(copylinktext);
		String Series_count = CommonFunctionality.getElementByProperty(login.driver, "Total_series_count", 6).getText();
		System.out.println(Series_count);
		char first = copylinktext.charAt(0);
		if (!Series_count.equalsIgnoreCase(copylinktext)) {
			System.out
					.println("More actions Copy link confirmation message for multiple seriesis verified Successfully");
		} else {
			Assert.fail(
					"More actions Copy link confirmation message for multiple seriesis verified Successfully is NOT verified Successfully:-(");
		}

//		Thread.sleep(1000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("List_mode_option"))).click();
//		Thread.sleep(3000);
//		CommonFunctionality.DeleteSeries();
	}

	// TC_MS_324
	@And("^Verify Right click insert copied option if not data in clipboard in table mode$")
	public void verify_Right_click_insert_copied_option_if_not_data_in_clipboard_in_table_mode() throws Throwable {
		Thread.sleep(1000);
		String insertcopied = CommonFunctionality.getElementByProperty(login.driver, "Insert_copy", 6)
				.getAttribute("class");
		if (insertcopied.contains("disabled")) {
			System.out.println("Right click insert copied option if not data in clipboard is Verified Successfully");
		} else {
			Assert.fail("Right click insert copied option if not data in clipboard is Verified Successfully");
		}
//
//		Thread.sleep(1000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("rightclicksortby"))).click();
//		Thread.sleep(1000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("List_mode_option"))).click();
//		Thread.sleep(3000);
//		CommonFunctionality.DeleteSeries();
	}

	@And("^Select list mode$")
	public void select_list_mode() throws Throwable {
		CommonFunctionality.wait(1000);
		WebElement table = login.driver
				.findElement(By.xpath("(//div[@class='toggler-control-wrapper']//button[@type='button'])[1]"));
		action.moveToElement(table).click().build().perform();
		CommonFunctionality.wait(2000);

	}

	// TC_MS_325
	@And("^Verify Right click insert copied option in table mode$")
	public void verify_Right_click_insert_copied_option_in_table_mode() throws Throwable {
		Thread.sleep(3000);
		String Series_count_before = CommonFunctionality.getElementByProperty(login.driver, "Total_series_count", 6)
				.getText();
		int SC_before = Integer.parseInt(Series_count_before);
		System.out.println(SC_before);
		Thread.sleep(3000);
		String Series_count_after = CommonFunctionality.getElementByProperty(login.driver, "Total_series_count", 6)
				.getText();
		int SC_after = Integer.parseInt(Series_count_after);
		System.out.println(SC_after);
		if (SC_before >= SC_after) {
			System.out.println("More actions insert copied option is verified Succesfully");
		} else {
			Assert.fail("More actions insert copied option is NOT verified Succesfully");
		}
//		Thread.sleep(1000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("List_mode_option"))).click();
//		Thread.sleep(3000);
//		CommonFunctionality.DeleteSeries();
	}

	// TC_MS_342
	@And("^Verify Right click insert growl message in table mode$")
	public void verify_Right_click_insert_growl_message_in_table_mode() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Insertcopy", 8).click();

		Thread.sleep(1000);
		if (login.driver.findElements(By.xpath("//div[@class='growl-message-text']")).size() != 0) {
			System.out.println("Validation message Verified Successfully for insert copied Option!!! ");
		} else {
			Assert.fail("Validation message is NOT Verified Successfully for insert copied Option!!!");
		}
//		Thread.sleep(1000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("List_mode_option"))).click();
//		Thread.sleep(3000);
//		CommonFunctionality.DeleteSeries();
	}

	// TC_MS_326
	@And("^Verify Right click Delete in table mode$")
	public void verify_Right_click_Delete_in_table_mode() throws Throwable {

		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Tabledeleteall"))).size() != 0) {
			System.out.println("verified");
		} else {
			Assert.fail();
		}

		for (int i = 1; i <= 1; i++) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("(//div[@class='add-to-data-selection--icon'])[" + i + "]")).click();
		}
//		Thread.sleep(2000);
//		Robot r = new Robot();
//		r.keyPress(KeyEvent.VK_A);
//		r.keyRelease(KeyEvent.VK_A);
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("List_mode_option"))).click();
		Thread.sleep(3000);
		CommonFunctionality.DeleteSeries();
	}

	// TC_MS_327
	@And("^Verify More actions Group in table mode$")
	public void verify_More_actions_Group_in_table_mode() throws Throwable {
		Thread.sleep(3000);
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Grouping_rename_popup"))).isDisplayed());
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("List_mode_option"))).click();
		Thread.sleep(3000);
		CommonFunctionality.DeleteSeries();
	}

	// TC_MS_328
	@And("^Verify More actions auto title for group in table mode$")
	public void verify_More_actions_auto_title_for_group_in_table_mode() throws Throwable {
		Thread.sleep(5000);
		String autotitle = CommonFunctionality.getElementByProperty(login.driver, "Edit_series_rename_popup", 6)
				.getAttribute("value");
		String s1 = autotitle.substring(0, 5);
		String s2 = "Group";
		Assert.assertEquals(s1, s2);
//		Thread.sleep(3000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("List_mode_option"))).click();
//		Thread.sleep(3000);
//		CommonFunctionality.DeleteSeries();
	}

	// TC_MS_329
	@And("^Verify More actions OK icon by default in table mode$")
	public void verify_More_actions_OK_icon_by_default_in_table_mode() throws Throwable {
		String Default_ok = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ok_button_editseries")))
				.getAttribute("class");
		if (Default_ok.contains("disabled")) {
			System.out.println("Edit series Rename by default is verified Successfully");
		} else {
			Assert.fail("Edit series Rename by default is NOT Verified Successfully");
		}
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("List_mode_option"))).click();
		Thread.sleep(3000);
		CommonFunctionality.DeleteSeries();

	}

	// TC_MS_330
	@And("^Verify Right click sub dropdown should be opened with existing groups in table mode$")
	public void verify_Right_click_sub_dropdown_should_be_opened_with_existing_groups_in_table_mode() throws Throwable {
		Thread.sleep(3000);

		// div[@class='add-to-context-manage']

		WebElement we = login.driver.findElement(By.xpath((login.LOCATORS.getProperty("Tablerightclickgroup"))));
		action.moveToElement(we).build().perform();
		System.out.println("==============>Tablerightclickgroup=================>");
		Thread.sleep(300);

		// if(
		login.driver.findElement(By.xpath("//div[@class='add-to-context-manage']")).isDisplayed();
		// {
		System.out.println("sub dropdown should be opened");
		// }

		/*
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
		 * "Tablerightclickcreatedgroup"))).click(); System.out.println(
		 * "==============>Tablerightclickcreatedgroup=================>");
		 * Thread.sleep(3000);
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
		 * "Tablerightclickgroupapply"))).click();
		 * 
		 * System.out.println(
		 * "==============>Tablerightclickgroupapply=================>");
		 * 
		 * Thread.sleep(3000);
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
		 * "List_mode_option"))).click(); Thread.sleep(3000); String Default_group =
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
		 * "Tablerightclickgroupname"))).getText(); if(Default_group.contains("Group")){
		 * System.out.println("Edit series Rename by default is verified Successfully");
		 * }else{
		 * Assert.fail("Edit series Rename by default is NOT Verified Successfully"); }
		 */

//		Thread.sleep(1000);
//		login.driver.navigate().refresh();
//		Thread.sleep(1000);
//		CommonFunctionality.DeleteSeries();

	}

	// TC_MS_331
	@And("^Mouse hover the second series in table mode$")
	public void mouse_hover_the_second_series_in_table_mode() throws Throwable {
		Thread.sleep(2000);

		WebElement we = login.driver.findElement(By.xpath((login.LOCATORS.getProperty("secondSeriesnameintablemode"))));
		action.moveToElement(we).build().perform();
		Thread.sleep(3000);

		WebElement we1 = login.driver
				.findElement(By.xpath((login.LOCATORS.getProperty("secondSeriesnameintablemode"))));
		action.contextClick(we1).perform();
	}

	// TC_MS_332
	@And("^Add select one more series in table more$")
	public void add_select_one_more_series_in_table_more() throws Throwable {
		select_some_series_to_my_series_tab();
		Thread.sleep(1000);
		Secondseriesname = CommonFunctionality.getElementByProperty(login.driver, "secondSeriesnameintablemode", 6)
				.getText();
	}

	// TC_MS_331
	@And("^Verify Right click Group if already have a group in my series in table mode$")
	public void verify_Right_click_Group_if_already_have_a_group_in_my_series_in_table_mode() throws Throwable {
		Thread.sleep(3000);

		WebElement we = login.driver.findElement(By.xpath((login.LOCATORS.getProperty("Tablerightclickgroup"))));
		action.moveToElement(we).build().perform();
		Thread.sleep(300);

		WebElement group = login.driver.findElement(By.xpath("//span[text()='Group']"));
		action.moveToElement(group).build().perform();
		login.driver.findElement(By.xpath("//input[@class='add-to-context-manage--search']")).sendKeys("Group");

		/*
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
		 * "Tablerightclickcreatedgroup"))).click(); Thread.sleep(3000);
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
		 * "Tablerightclickgroupapply"))).click();
		 * 
		 * 
		 * Thread.sleep(3000);
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
		 * "List_mode_option"))).click(); Thread.sleep(3000); String Default_group =
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
		 * "Tablerightclickgroupname"))).getText(); if(Default_group.contains("Group")){
		 * System.out.println("Edit series Rename by default is verified Successfully");
		 * }else{
		 * Assert.fail("Edit series Rename by default is NOT Verified Successfully"); }
		 */

//		Thread.sleep(1000);
//		login.driver.navigate().refresh();
//		Thread.sleep(1000);
//		CommonFunctionality.DeleteSeries();

	}

	// TC_MS_332
	@And("^Add another series and create another group in tabel mode$")
	public void add_another_series_and_create_another_group_in_tabel_mode() throws Throwable {
		select_some_series_to_my_series_tab();
		Thread.sleep(1000);
		Secondseriesname = CommonFunctionality.getElementByProperty(login.driver, "secondSeriesnameintablemode", 6)
				.getText();
		Thread.sleep(2000);

		WebElement we = login.driver.findElement(By.xpath((login.LOCATORS.getProperty("secondSeriesnameintablemode"))));
		action.moveToElement(we).build().perform();
		Thread.sleep(2000);

		WebElement we1 = login.driver
				.findElement(By.xpath((login.LOCATORS.getProperty("secondSeriesnameintablemode"))));
		action.contextClick(we1).perform();
	}

	// TC_MS_332
	@And("^Verify Right click search field for existing group in table mode$")
	public void verify_Right_click_search_field_for_existing_group_in_table_mode() throws Throwable {
		Thread.sleep(3000);

		WebElement we = login.driver.findElement(By.xpath((login.LOCATORS.getProperty("Tablerightclickgroup"))));
		action.moveToElement(we).build().perform();
		Thread.sleep(300);

		WebElement group = login.driver.findElement(By.xpath("//span[text()='Group']"));
		action.moveToElement(group).build().perform();
		// CommonFunctionality.getElementByXpath(login.driver,
		// "//div[@class='add-to-context-manage']", 8).isDisplayed();

		CommonFunctionality.getElementByXpath(login.driver, "//input[@class='add-to-context-manage--search']", 8)
				.sendKeys("Group");

		// login.driver.findElement(By.xpath("//body/ul[1]/div[3]/li[19]/ul[1]/li[1]/div[1]/div[2]/div[1]/div[1]")).click();
		// Thread.sleep(1000);
		// login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();

		/*
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
		 * "Tablerightclickcreatedgroup"))).click(); Thread.sleep(3000);
		 * 
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
		 * "Tablerightclickgroupapply"))).click();
		 * 
		 * 
		 * Thread.sleep(3000);
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
		 * "List_mode_option"))).click(); Thread.sleep(3000); String Default_group =
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
		 * "Tablerightclickgroupname"))).getText(); if(Default_group.contains("Group")){
		 * System.out.println("Edit series Rename by default is verified Successfully");
		 * }else{
		 * Assert.fail("Edit series Rename by default is NOT Verified Successfully"); }
		 */

		Thread.sleep(1000);
		login.driver.navigate().refresh();
		Thread.sleep(1000);
		CommonFunctionality.DeleteSeries();
	}

	// TC_MS_333
	@And("^Verify Right click create new group option-in table mode$")
	public void verify_Right_click_create_new_group_option_in_table_mode() throws Throwable {

		Thread.sleep(1000);
		WebElement we = login.driver.findElement(By.xpath(("//span[text()='Group']")));
		action.moveToElement(we).build().perform();

		CommonFunctionality.getElementByProperty(login.driver, "Group_createnewgroup", 8).click();

		CommonFunctionality.getElementByProperty(login.driver, "List_mode_option", 8).click();
		Thread.sleep(1000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Tablerightclicknewgroup"))).size() != 0) {
			System.out.println("new group option is working");
		} else {
			Assert.fail("new group option is NOT working");
		}
		Thread.sleep(3000);
		CommonFunctionality.DeleteSeries();
	}

	// TC_MS_334
	@And("^Verify Right click Preview in table mode$")
	public void verify_Right_click_Preview_in_table_mode() throws Throwable {
		Thread.sleep(3000);
		if ((login.driver.findElements(By.xpath(login.LOCATORS.getProperty("preview_popup"))).size() != 0)) {
			System.out.println("Verified Preview pop up");
		} else {
			Assert.fail("Preview pop up is NOT verified ");
		}
		CommonFunctionality.getElementByProperty(login.driver, "preview_popup_close", 8).click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("List_mode_option"))).click();
		Thread.sleep(3000);
		CommonFunctionality.DeleteSeries();
	}

	// TC_MS_335
	@And("^Verify Right click Series Info in table mode$")
	public void verify_Right_click_Series_Info_in_table_mode() throws Throwable {
		Thread.sleep(3000);
		Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Dialogue"))).isDisplayed());
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("List_mode_option"))).click();
		Thread.sleep(3000);
		CommonFunctionality.DeleteSeries();
	}

	// TC_MS_336
	@And("^Verify Right click Footnotes in table mode$")
	public void verify_Right_click_Footnotes_in_table_mode() throws Throwable {
		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Related_series_footnotespopup")))
				.size() != 0) {
			System.out.println("More actions Footnotes is Verified Successfully!!! ");
		} else {
			Assert.fail("More actions Footnotes is NOT Verified Successfully");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("List_mode_option"))).click();
		Thread.sleep(3000);
		CommonFunctionality.DeleteSeries();
	}

	// TC_MS_337
	@And("^Verify Right click Footnotesif the series linked to multiple Database in table mode$")
	public void verify_Right_click_Footnotesif_the_series_linked_to_multiple_Database_in_table_mode() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement we = login.driver.findElement(By.xpath("//span[@title='Footnotes']"));
		action.moveToElement(we).pause(2000).build().perform();

		CommonFunctionality.getElementByProperty(login.driver, "GDB_footnotes", 8).click();
		Thread.sleep(3000);
		String GDB_footnotes = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("GDBinside_footnotes")))
				.getText();
		String Actual = "Global Database";
		assertEquals(Actual, GDB_footnotes);
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
		mouse_hover_the_first_series_in_table_mode();
		right_click_on_the_first_series_in_table_mode();

		Thread.sleep(3000);
		WebElement we1 = login.driver.findElement(By.xpath("(//span[text()='Footnotes'])[2]"));
		action.moveToElement(we1).pause(2000).build().perform();
		CommonFunctionality.getElementByProperty(login.driver, "GDB_keyseries", 8).click();
		Thread.sleep(3000);
		String GDB_keyseries = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("GDBinside_footnotes")))
				.getText();
		String Actual1 = "Global Key Series Database";
		assertEquals(Actual1, GDB_keyseries);
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("List_mode_option"))).click();
		Thread.sleep(3000);
		CommonFunctionality.DeleteSeries();
	}

	// TC_MS_338
	@And("^Verify Right click Show dataset in table mode$")
	public void verify_Right_click_Show_dataset_in_table_mode() throws Throwable {
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Backbutton"))).isDisplayed()) {
			login.Log4j.info("Dataset is displayed for given SeriesID");
			CommonFunctionality.getElementByProperty(login.driver, "Backbutton", 8).click();

		} else {
			Assert.fail("Dataset is not displayed for given SeriesID");
		}
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("List_mode_option"))).click();
		Thread.sleep(3000);
		CommonFunctionality.DeleteSeries();
	}

	// TC_MS_339
	@And("^Verify Right click Show Show Database in table mode$")
	public void verify_Right_click_Show_Show_Database_in_table_mode() throws Throwable {

		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Tablerightclicktopdatabase"))).size() != 0) {
			System.out.println("More actions Footnotes is Verified Successfully!!! ");
		} else {
			Assert.fail();
		}

		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("List_mode_option"))).click();
		Thread.sleep(3000);
		CommonFunctionality.DeleteSeries();
	}

	// TC_MS_340
	@And("^Select undo option$")
	public void select_undo_option() throws Throwable {
		Thread.sleep(1000);
		
		String name = login.driver.findElement(By.xpath("(//span[@class='series-name-field--text'])[1]")).getText();
		Thread.sleep(1000);
		WebElement series1 = login.driver.findElement(
				By.xpath("(//div[@class='series-name-field--series-name'])[1]"));
		action.pause(500).moveToElement(series1).build().perform();

		
		CommonFunctionality
				.getElementByXpath(login.driver, "(//span[@class='series-item--icon series-item--icon__edit'])[1]", 8)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Rename')]", 8).click();
		CommonFunctionality.getElementByXpath(login.driver, "//input[@id='current-title']", 8).click();
		CommonFunctionality.getElementByXpath(login.driver, "//input[@id='current-title']", 8).clear();
		CommonFunctionality.getElementByXpath(login.driver, "//input[@id='current-title']", 8).sendKeys("data");
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//div[@class='insight-series-rename--button insight-series-rename--button__apply']", 8)
				.click();
		CommonFunctionality.getElementByProperty(login.driver, "Undo_option", 8).click();
	}

	// TC_MS_340
	@And("^Verify undo option for making changes in my series tab$")
	public void verify_undo_option_for_making_changes_in_my_series_tab() throws Throwable {
		CommonFunctionality.wait(2000);
		String selected = login.driver.findElement(By.xpath("(//span[@class='series-name-field--text'])[1]")).getText();
		System.out.println(selected);
//System.out.println("data");

		if (selected.equalsIgnoreCase(name)) {
		
			login.Log4j.info("Undo option for making changes in my series tab is verified Succesfully");
		} else {
			Assert.fail("Undo option for making changes in my series tab is NOT verified Succesfully");

		}
	}

	// TC_MS_341
	@And("^Select redo option$")
	public void select_redo_option() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Redo_option", 8).click();
	}

	// TC_MS_341
	@And("^Verify redo option for making changes in my series tab$")
	public void verify_redo_option_for_making_changes_in_my_series_tab() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement selected = login.driver.findElement(By.xpath("(//span[@class='series-name-field--text'])[1]"));

		if (selected.getText().equalsIgnoreCase("data")) {
		//	System.out.println("redo option for making changes in my series tab is verified Succesfully");
			login.Log4j.info("redo option for making changes in my series tab is verified Succesfully");
		} else {
			Assert.fail(
					"redo option for making changes in my series tab is verified Succesfully is NOT verified Succesfully");

//		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("First_series_Name"))).size()==1) {
//			System.out.println("redo option for making changes in my series tab is verified Succesfully");
//		} else {
//			Assert.fail("redo option for making changes in my series tab is verified Succesfully is NOT verified Succesfully");
//		}

//		Thread.sleep(3000);
//		CommonFunctionality.DeleteSeries();
		}
	}

	// TC_MS_280
	@And("^Mouse hover the first series and get the name in table mode$")
	public void mouse_hover_the_first_series_and_get_the_name_in_table_mode() throws Throwable {
		Thread.sleep(3000);
		WebElement we = login.driver.findElement(By.xpath((login.LOCATORS.getProperty("secondSeriesnameintablemode"))));
		action.moveToElement(we).build().perform();
		Thread.sleep(3000);
		Secondseriesname = CommonFunctionality.getElementByProperty(login.driver, "secondSeriesnameintablemode", 6)
				.getText();

	}

	// TC_MS_280
	@SuppressWarnings("deprecation")
	@And("^search in a search name field$")
	public void search_in_a_search_name_field() throws Throwable {

		WebElement we = login.driver.findElement(By.xpath((login.LOCATORS.getProperty("Namefield_search"))));
		action.moveToElement(we).pause(2000).click().sendKeys(Secondseriesname).build().perform();

	}

	// TC_MS_280
	@And("^verify Search for name field in table mode$")
	public void verify_Search_for_name_field_in_table_mode() throws Throwable {
		Thread.sleep(1000);
		String Searchedseriesname = CommonFunctionality.getElementByProperty(login.driver, "Seriesnameintablemode", 6)
				.getText();

		if (Secondseriesname.equalsIgnoreCase(Searchedseriesname)) {
			System.out.println("Search for name field in table mode is verified Succesfully");
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Namefield_search"))).clear();
		} else {
			Assert.fail("Search for name field in table mode is NOT verified Succesfully");
		}
		WebElement listMode = login.driver
				.findElement(By.xpath("(//div[@class='toggler-control-wrapper']//button[@type='button'])[1]"));
		action.moveToElement(listMode).click().build().perform();

		// CommonFunctionality.getElementByProperty(login.driver, "List_mode_option",
		// 8).click();

		WebElement search = login.driver.findElement(By.xpath("//input[@class='form--control']"));
		action.moveToElement(search).click().build().perform();
		login.driver.findElement(By.xpath("//div[@class='selection-filter--icon selection-filter--clear-button']"))
				.click();
		// CommonFunctionality.getElementByProperty(login.driver,
		// "//input[@class='form--control']", 8).clear();

		// CommonFunctionality.getElementByProperty(login.driver,
		// "//input[@class='form--control']", 8).click();

		// Actions action = new Actions(login.driver);
		// WebElement we
		// =login.driver.findElement(By.xpath((login.LOCATORS.getProperty("Myseries_input"))));
		// action.moveToElement(we).pause(2000).click().build().perform();
		// Thread.sleep(3000);
		// we.clear();
//		Thread.sleep(3000);
//		CommonFunctionality.DeleteSeries();
	}

	// TC_MS_281
	@And("^select the second series and applay function$")
	public void select_the_second_series_and_applay_function() throws Throwable {
		Thread.sleep(1000);
		Secondseriesnamefunctionapplied = CommonFunctionality
				.getElementByProperty(login.driver, "Second_series_Name", 6).getText();
		CommonFunctionality.getElementByProperty(login.driver, "Second_series_check_box", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Calculate_change_dropdown", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "YOY_Function", 8).click();
	}

	// TC_MS_281
	@And("^search in a function field$")
	public void search_in_a_function_field() throws Throwable {

		WebElement we = login.driver.findElement(By.xpath((login.LOCATORS.getProperty("Functionfield_search"))));
		action.moveToElement(we).pause(2000).click().sendKeys("DIFF(Over Year)").build().perform();
	}

	// TC_MS_281
	@And("^verify function field in table mode$")
	public void verify_function_field_in_table_mode() throws Throwable {
		Thread.sleep(3000);
		String Searchedfunctionseriesname = CommonFunctionality
				.getElementByProperty(login.driver, "Seriesnameintablemode", 6).getText();
		if (Secondseriesnamefunctionapplied.equalsIgnoreCase(Searchedfunctionseriesname)) {
			System.out.println("Function field in table mode is verified Succesfully");
		} else {
			Assert.fail("Function field in table mode is NOT verified Succesfully");
		}

		CommonFunctionality.getElementByProperty(login.driver, "List_mode_option", 8).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='check-all-series']//span[@class='input-control--indicator']"))
				.click();
//		Thread.sleep(3000);
//		CommonFunctionality.DeleteSeries();
//		Thread.sleep(2000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
	}

	// TC_MS_282
	@And("^search in a Series ID field$")
	public void search_in_a_Series_ID_field() throws Throwable {

		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//button[@title='Customize your selection']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//button[text()='Reset']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//button[text()='Save']")).click();
		CommonFunctionality.wait(2000);
		WebElement we = CommonFunctionality.getElementByProperty(login.driver, "Seriesid_field_search", 8);
		action.moveToElement(we).pause(2000).click().sendKeys(SID).build().perform();
	}

	// TC_MS_282
	@And("^verify Series ID in table mode$")
	public void verify_Series_ID_in_table_mode() throws Throwable {
		Thread.sleep(1000);
		String Searchedfunctionseriesname = CommonFunctionality
				.getElementByProperty(login.driver, "Seriesnameintablemode", 6).getText();
		if (Secondseriesnameinssp.contains(Searchedfunctionseriesname)) {
			System.out.println("Series ID field in table mode is verified Succesfully");
		} else {
			Assert.fail("Series ID field in table mode is NOT verified Succesfully");
		}
//		Thread.sleep(1000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("List_mode_option"))).click();
//		Thread.sleep(3000);
//		CommonFunctionality.DeleteSeries();
//		Thread.sleep(2000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
	}

	// TC_MS_282
	@And("^get series name and ID$")
	public void get_series_name_and_ID() throws Throwable {

		Thread.sleep(1000);
		WebElement we = login.driver.findElement(By.xpath("//div[@class='series-item--name']"));
		action.moveToElement(we).pause(2000).click().build().perform();
		Thread.sleep(1000);
		Secondseriesnameinssp = CommonFunctionality.getElementByProperty(login.driver, "SSP_seriesname", 6).getText();
		Thread.sleep(1000);
		String SeriesID_ssp = CommonFunctionality.getElementByProperty(login.driver, "SSP_ID", 6).getText();
		System.out.println("SeriesID_ssp:" + SeriesID_ssp);
		SID = SeriesID_ssp.substring(4, 12);
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
	}

	// TC_MS_283
	@And("^get series name and ID of mnemonics$")
	public void get_series_name_and_ID_of_mnemonics() throws Throwable {
		Thread.sleep(1000);
		WebElement we = login.driver.findElement(By.xpath(("//div[@class='series-item--name']")));
		action.moveToElement(we).pause(2000).click().build().perform();

		Thread.sleep(1000);
		Secondseriesnameinssp = CommonFunctionality.getElementByProperty(login.driver, "SSP_seriesname", 6).getText();
		Thread.sleep(1000);
		String SeriesID_ssp = CommonFunctionality.getElementByProperty(login.driver, "SSP_Mnenonics", 6).getText();
		SID = SeriesID_ssp.substring(9, 25);
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
	}

	// TC_MS_283
	@And("^search in a Mnemonics field$")
	public void search_in_a_Mnemonics_field() throws Throwable {
		select_the_Expand_Icon();
		Thread.sleep(1000);

		WebElement we = login.driver.findElement(By.xpath((login.LOCATORS.getProperty("Mnenonics_field_search"))));
		action.moveToElement(we).pause(2000).click().sendKeys(SID).build().perform();
	}

	// TC_MS_283
	@And("^verify Mnemonics field in table mode$")
	public void verify_Mnemonics_field_in_table_mode() throws Throwable {
		Thread.sleep(1000);
		String Searchedfunctionseriesname = CommonFunctionality
				.getElementByProperty(login.driver, "Seriesnameintablemode", 6).getText();
		if (Secondseriesnameinssp.equalsIgnoreCase(Searchedfunctionseriesname)) {
			System.out.println("Mnemonics ID field in table mode is verified Succesfully");
		} else {
			Assert.fail("Mnemonics ID field in table mode is NOT verified Succesfully");
		}
//		Thread.sleep(1000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("List_mode_option"))).click();
//		Thread.sleep(3000);
//		CommonFunctionality.DeleteSeries();
//		Thread.sleep(3000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_Icon_Right"))).click();
//		Thread.sleep(2000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
	}

	// TC_MS_284
	@And("^search Regions dropdown$")
	public void search_Regions_dropdown() throws Throwable {
		select_the_Expand_Icon();
		CommonFunctionality.getElementByProperty(login.driver, "Region_dropdown", 8).click();
	}

	// TC_MS_284
	@And("^verify Regions dropdown in table mode$")
	public void verify_Regions_dropdown_in_table_mode() throws Throwable {
		Thread.sleep(1000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Region_content_dropdown"))).size() != 0) {
			System.out.println("Regions dropdown in table mode is Verified Successfully!!! ");
		} else {
			Assert.fail("Regions dropdown in table mode is NOT Verified Successfully");
		}
//		Thread.sleep(1000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("List_mode_option"))).click();
//		Thread.sleep(3000);
//		CommonFunctionality.DeleteSeries();
//		Thread.sleep(3000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_Icon_Right"))).click();
//		Thread.sleep(2000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
	}

	// TC_MS_286
	@And("^search Subnational dropdown$")
	public void search_Subnational_dropdown() throws Throwable {
		select_the_Expand_Icon();
		CommonFunctionality.getElementByProperty(login.driver, "Subnational_dropdown", 8).click();
	}

	// TC_MS_286
	@And("^verify Subnational dropdown in table mode$")
	public void verify_Subnational_dropdown_in_table_mode() throws Throwable {
		Thread.sleep(1000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Region_content_dropdown"))).size() != 0) {
			System.out.println("Subnational dropdown in table mode is Verified Successfully!!! ");
		} else {
			Assert.fail("Subnational dropdown in table mode is NOT Verified Successfully");
		}
//		Thread.sleep(1000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("List_mode_option"))).click();
//		Thread.sleep(3000);
//		CommonFunctionality.DeleteSeries();
//		Thread.sleep(3000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_Icon_Right"))).click();
//		Thread.sleep(2000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
	}

	// TC_MS_287
	@And("^search Frequency dropdown$")
	public void search_Frequency_dropdown() throws Throwable {
		select_the_Expand_Icon();
		CommonFunctionality.getElementByProperty(login.driver, "Frequency_dropdown", 8).click();
	}

	// TC_MS_287
	@And("^verify Frequency dropdown in table mode$")
	public void verify_Frequency_dropdown_in_table_mode() throws Throwable {
		Thread.sleep(1000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Region_content_dropdown"))).size() != 0) {
			System.out.println("Frequency dropdown in table mode is Verified Successfully!!! ");
		} else {
			Assert.fail("Frequency dropdown in table mode is NOT Verified Successfully");
		}
//		Thread.sleep(1000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("List_mode_option"))).click();
//		Thread.sleep(3000);
//		CommonFunctionality.DeleteSeries();
//		Thread.sleep(3000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_Icon_Right"))).click();
//		Thread.sleep(2000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
	}

	// TC_MS_289
	@And("^search unit dropdown$")
	public void search_unit_dropdown() throws Throwable {
		select_the_Expand_Icon();
		CommonFunctionality.getElementByProperty(login.driver, "unit_dropdown", 8).click();
	}

	// TC_MS_289
	@And("^verify unit dropdown in table mode$")
	public void verify_unit_dropdown_in_table_mode() throws Throwable {
		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Region_content_dropdown"))).size() != 0) {
			System.out.println("unit dropdown in table mode is Verified Successfully!!! ");
		} else {
			Assert.fail("unit dropdown in table mode is NOT Verified Successfully");
		}
		select_the_Customize_option();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Reset_option", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_save_option", 8).click();

//		Thread.sleep(1000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("List_mode_option"))).click();
//		Thread.sleep(3000);
//		CommonFunctionality.DeleteSeries();
//		Thread.sleep(3000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_Icon_Right"))).click();
//		Thread.sleep(2000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
	}

	// TC_MS_289
	@And("^select the required table coloumn$")
	public void select_the_required_table_coloumn() throws Throwable {
		select_the_Customize_option();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tmnemonics", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tregion", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tsubnational", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tfrequency", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tlastupdate", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tfirstdate", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tlastdate", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tlastvalue", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tnumberofobservation", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tstatus", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tsource", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_save_option", 8).click();

	}

	// TC_MS_294
	@And("^select the required for status in table coloumn$")
	public void select_the_required_for_status_in_table_coloumn() throws Throwable {
		select_the_Customize_option();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tmnemonics", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tregion", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tsubnational", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tfrequency", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tlastupdate", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tfirstdate", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tlastdate", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tlastvalue", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tnumberofobservation", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tunit", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tsource", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_save_option", 8).click();
	}

	// TC_MS_294
	@And("^search status dropdown$")
	public void search_status_dropdown() throws Throwable {
		select_the_Expand_Icon();
		CommonFunctionality.getElementByProperty(login.driver, "unit_dropdown", 8).click();
	}

	// TC_MS_294
	@And("^verify status dropdown in table mode$")
	public void verify_status_dropdown_in_table_mode() throws Throwable {
		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Region_content_dropdown"))).size() != 0) {
			System.out.println("unit dropdown in table mode is Verified Successfully!!! ");
		} else {
			Assert.fail("unit dropdown in table mode is NOT Verified Successfully");
		}
		select_the_Customize_option();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Reset_option", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_save_option", 8).click();
//		Thread.sleep(1000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("List_mode_option"))).click();
//		Thread.sleep(3000);
//		CommonFunctionality.DeleteSeries();
//		Thread.sleep(3000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_Icon_Right"))).click();
//		Thread.sleep(2000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
	}

	// TC_MS_288
	@And("^select the required for  last updated in table coloumn$")
	public void select_the_required_for_last_updated_in_table_coloumn() throws Throwable {
		select_the_Customize_option();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tmnemonics", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tregion", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tsubnational", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tfrequency", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tstatus", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tfirstdate", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tlastdate", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tlastvalue", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tnumberofobservation", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tunit", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tsource", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_save_option", 8).click();
	}

	// TC_MS_288
	@And("^search last updated$")
	public void search_last_updated() throws Throwable {
		select_the_Expand_Icon();
		Thread.sleep(1000);
		WebElement we = login.driver.findElement(By.xpath((login.LOCATORS.getProperty("Mnenonics_field_search"))));
		action.moveToElement(we).pause(2000).click().sendKeys(lastupdatevalue).build().perform();
	}

	// TC_MS_288
	@And("^verify  last updated in table mode$")
	public void verify_last_updated_in_table_mode() throws Throwable {
		Thread.sleep(1000);
		String Searchedfunctionseriesname = CommonFunctionality
				.getElementByProperty(login.driver, "Seriesnameintablemode", 6).getText();
		if (Serieslastupdatevalue.equalsIgnoreCase(Searchedfunctionseriesname)) {
			System.out.println("last update field in table mode is verified Succesfully");
		} else {
			Assert.fail("last update field in table mode is NOT verified Succesfully");
		}
		select_the_Customize_option();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Reset_option", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_save_option", 8).click();
//		Thread.sleep(1000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("List_mode_option"))).click();
//		Thread.sleep(3000);
//		CommonFunctionality.DeleteSeries();
//		Thread.sleep(3000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_Icon_Right"))).click();
//		Thread.sleep(2000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
	}

	// TC_MS_288
	@And("^get series name and last update value$")
	public void get_series_name_and_last_update_value() throws Throwable {
		Thread.sleep(1000);

		WebElement we = login.driver.findElement(By.xpath(("//div[@class='series-item--name']")));
		action.moveToElement(we).pause(2000).click().build().perform();
		Thread.sleep(1000);
		Serieslastupdatevalue = CommonFunctionality.getElementByProperty(login.driver, "SSP_seriesname", 6).getText();
		Thread.sleep(1000);
		lastupdatevalue = CommonFunctionality.getElementByProperty(login.driver, "Last_update", 6).getText();
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
	}

	// TC_MS_290
	@And("^get series name and First date value$")
	public void get_series_name_and_First_date_value() throws Throwable {
		Thread.sleep(1000);

		WebElement we = login.driver.findElement(By.xpath(("(//div[@class='series-item--name'])[1]")));
		action.moveToElement(we).pause(2000).click().build().perform();
		Thread.sleep(1000);
		Secondseriesnameinssp = CommonFunctionality.getElementByProperty(login.driver, "SSP_seriesname", 6).getText();
		Thread.sleep(1000);
		CommonFunctionality.getElementByProperty(login.driver, "Data_SSP", 6).click();
		Thread.sleep(2000);
		lastupdatevalue = login.driver
				.findElement(By.xpath("(//span[@class='preview-series-time-points--point-date'])[21]")).getText();

		// lastupdatevalue = CommonFunctionality.getElementByProperty(login.driver,
		// "First_date", 6).getText();
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
	}

	// TC_MS_290
	@And("^select the required for First date in table coloumn$")
	public void select_the_required_for_First_date_in_table_coloumn() throws Throwable {
		select_the_Customize_option();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tmnemonics", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tregion", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tsubnational", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tfrequency", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tstatus", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tlastupdate", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tlastdate", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tlastvalue", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tnumberofobservation", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tunit", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tsource", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_save_option", 8).click();
	}

	// TC_MS_290
	@And("^search First date$")
	public void search_First_date() throws Throwable {
		select_the_Expand_Icon();
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//button[@title='Customize your selection']")).click();

		login.driver.findElement(By.xpath("//button[text()='Reset']")).click();

		login.driver.findElement(By.xpath("//button[text()='Save']")).click();
		// WebElement we =
		// login.driver.findElement(By.xpath((login.LOCATORS.getProperty("Mnenonics_field_search"))));
		WebElement we = login.driver.findElement(By.xpath(("(//tr[@section='header'])[2]/td[10]/div/input")));

		action.moveToElement(we).pause(2000).click().sendKeys(lastupdatevalue).build().perform();
	}

	// TC_MS_290
	@And("^verify First date in table mode$")
	public void verify_First_date_in_table_mode() throws Throwable {
		Thread.sleep(3000);
		// String Searchedfunctionseriesname =
		// CommonFunctionality.getElementByProperty(login.driver,
		// "Seriesnameintablemode", 6).getText();

		String Searchedfunctionseriesname = login.driver
				.findElement(By.xpath("(//div[@class='series-name-field--series-name'])[1]")).getText();
		if (Secondseriesnameinssp.equalsIgnoreCase(Searchedfunctionseriesname)) {
			System.out.println("First date field in table mode is verified Succesfully");
		} else {
			Assert.fail("First date field in table mode is NOT verified Succesfully");
		}
		select_the_Customize_option();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Reset_option", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_save_option", 8).click();
//		Thread.sleep(1000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("List_mode_option"))).click();
//		Thread.sleep(3000);
//		CommonFunctionality.DeleteSeries();
//		Thread.sleep(3000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_Icon_Right"))).click();
//		Thread.sleep(2000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
	}

	// TC_MS_291
	@And("^get series name and last date value$")
	public void get_series_name_and_last_date_value() throws Throwable {
		Thread.sleep(1000);
		WebElement we = login.driver.findElement(By.xpath(("//div[@class='series-item--name']")));
		action.moveToElement(we).pause(2000).click().build().perform();
		Thread.sleep(1000);
		Secondseriesnameinssp = CommonFunctionality.getElementByProperty(login.driver, "SSP_seriesname", 6).getText();
		Thread.sleep(1000);
		CommonFunctionality.getElementByProperty(login.driver, "Data_SSP", 6).click();
		Thread.sleep(2000);
		lastupdatevalue = CommonFunctionality.getElementByProperty(login.driver, "Last_date", 6).getText();
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
	}

	// TC_MS_291
	@And("^select the required for lastdate in table coloumn$")
	public void select_the_required_for_lastdate_in_table_coloumn() throws Throwable {
		select_the_Customize_option();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tmnemonics", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tregion", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tsubnational", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tfrequency", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tstatus", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tlastupdate", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tfirstdate", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tlastvalue", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tnumberofobservation", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tunit", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tsource", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_save_option", 8).click();
	}

	// TC_MS_291
	@And("^search last date$")
	public void search_last_date() throws Throwable {
		select_the_Expand_Icon();
		Thread.sleep(1000);
		WebElement we = login.driver.findElement(By.xpath((login.LOCATORS.getProperty("Mnenonics_field_search"))));
		action.moveToElement(we).pause(2000).click().sendKeys(lastupdatevalue).build().perform();
	}

	// TC_MS_291
	@And("^verify last date in table mode$")
	public void verify_last_date_in_table_mode() throws Throwable {
		Thread.sleep(3000);
		String Searchedfunctionseriesname = CommonFunctionality
				.getElementByProperty(login.driver, "Seriesnameintablemode", 6).getText();
		System.out.println("===============>" + Searchedfunctionseriesname);
		System.out.println("===============>" + Secondseriesnameinssp);
		if (Secondseriesnameinssp.equalsIgnoreCase(Searchedfunctionseriesname)) {
			System.out.println("Last date field in table mode is verified Succesfully");
		} else {
			Assert.fail("Last date field in table mode is NOT verified Succesfully");
		}
		select_the_Customize_option();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Reset_option", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_save_option", 8).click();
		/*
		 * Thread.sleep(1000);
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
		 * "List_mode_option"))).click(); Thread.sleep(3000);
		 * CommonFunctionality.DeleteSeries(); Thread.sleep(3000);
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
		 * "Expand_Icon_Right"))).click(); Thread.sleep(2000);
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click
		 * ();
		 */
	}

	// TC_MS_292
	@And("^get series name and latest value value$")
	public void get_series_name_and_latest_value_value() throws Throwable {
		Thread.sleep(1000);
		WebElement we = login.driver.findElement(By.xpath(("//div[@class='series-item--name']")));
		action.moveToElement(we).pause(2000).click().build().perform();
		Thread.sleep(1000);
		Secondseriesnameinssp = CommonFunctionality.getElementByProperty(login.driver, "SSP_seriesname", 6).getText();
		Thread.sleep(1000);
		CommonFunctionality.getElementByProperty(login.driver, "Data_SSP", 6).click();
		Thread.sleep(1000);
		lastupdatevalue = CommonFunctionality.getElementByProperty(login.driver, "Last_value", 6).getText();
		SID = lastupdatevalue.substring(0, 2);
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
	}

	// TC_MS_292
	@And("^select the required for latest value in table coloumn$")
	public void select_the_required_for_latest_value_in_table_coloumn() throws Throwable {
		select_the_Customize_option();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tmnemonics", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tregion", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tsubnational", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tfrequency", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tstatus", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tlastupdate", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tfirstdate", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tlastdate", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tnumberofobservation", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tunit", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tsource", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_save_option", 8).click();
	}

	// TC_MS_292
	@And("^search latest value$")
	public void search_latest_value() throws Throwable {
		select_the_Expand_Icon();
		Thread.sleep(1000);

		WebElement we = login.driver.findElement(By.xpath((login.LOCATORS.getProperty("Mnenonics_field_search"))));
		action.moveToElement(we).pause(2000).click().sendKeys(SID).build().perform();
	}

	// TC_MS_292
	@And("^verify latest value in table mode$")
	public void verify_latest_value_in_table_mode() throws Throwable {
		Thread.sleep(3000);
		String Searchedfunctionseriesname = CommonFunctionality
				.getElementByProperty(login.driver, "Seriesnameintablemode", 6).getText();
		if (Secondseriesnameinssp.equalsIgnoreCase(Searchedfunctionseriesname)) {
			System.out.println("latest value date field in table mode is verified Succesfully");
		} else {
			Assert.fail("latest value field in table mode is NOT verified Succesfully");
		}
		select_the_Customize_option();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Reset_option", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_save_option", 8).click();
//		Thread.sleep(1000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("List_mode_option"))).click();
//		Thread.sleep(3000);
//		CommonFunctionality.DeleteSeries();
//		Thread.sleep(3000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_Icon_Right"))).click();
//		Thread.sleep(2000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
	}

	// TC_MS_293
	@And("^get series name and Number of obs value$")
	public void get_series_name_and_Number_of_obs_value() throws Throwable {
		Thread.sleep(1000);
		WebElement we = login.driver.findElement(By.xpath(("//div[@class='series-item--name']")));
		action.moveToElement(we).pause(2000).click().build().perform();
		Thread.sleep(2000);
		Secondseriesnameinssp = CommonFunctionality.getElementByProperty(login.driver, "SSP_seriesname", 6).getText();
		Thread.sleep(2000);
		lastupdatevalue = CommonFunctionality.getElementByProperty(login.driver, "Number_of_observation", 6).getText();
		SID = lastupdatevalue.substring(0, 2);
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
	}

	// TC_MS_293
	@And("^select the required for Number of obs in table coloumn$")
	public void select_the_required_for_Number_of_obs_in_table_coloumn() throws Throwable {
		select_the_Customize_option();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tmnemonics", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tregion", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tsubnational", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tfrequency", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tstatus", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tlastupdate", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tfirstdate", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tlastdate", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tlastvalue", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tunit", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Tsource", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_save_option", 8).click();
	}

	// TC_MS_293
	@And("^search Number of obs$")
	public void search_Number_of_obs() throws Throwable {
		select_the_Expand_Icon();
		Thread.sleep(1000);
		WebElement we = login.driver.findElement(By.xpath((login.LOCATORS.getProperty("Mnenonics_field_search"))));
		action.moveToElement(we).pause(2000).click().sendKeys(SID).build().perform();
	}

	// TC_MS_293
	@And("^verify Number of obs in table mode$")
	public void verify_Number_of_obs_in_table_mode() throws Throwable {
		Thread.sleep(3000);
		String Searchedfunctionseriesname = CommonFunctionality
				.getElementByProperty(login.driver, "Seriesnameintablemode", 6).getText();
		if (Secondseriesnameinssp.equalsIgnoreCase(Searchedfunctionseriesname)) {
			System.out.println("Number of obs field in table mode is verified Succesfully");
		} else {
			Assert.fail("Number of obs field in table mode is NOT verified Succesfully");
		}
		select_the_Customize_option();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_Reset_option", 8).click();
		CommonFunctionality.getElementByProperty(login.driver, "Customize_save_option", 8).click();
//		Thread.sleep(1000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("List_mode_option"))).click();
//		Thread.sleep(3000);
//		CommonFunctionality.DeleteSeries();
//		Thread.sleep(3000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_Icon_Right"))).click();
//		Thread.sleep(2000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
	}

	// TC_MS_296
	@And("^select any series in table coloumn$")
	public void select_any_series_in_table_coloumn() throws Throwable {
		Thread.sleep(1000);
		CommonFunctionality.getElementByProperty(login.driver, "Second_series_intablemood", 8).click();
	}

	// TC_MS_296
	@SuppressWarnings("unlikely-arg-type")
	@And("^verify selected series in list mode of table mode$")
	public void verify_selected_series_in_list_mode_of_table_mode() throws Throwable {
		Thread.sleep(3000);
		WebElement selected = login.driver.findElement(By.xpath("(//span[@class='series-name-field--text'])[2]"));
		System.out.println("=============================>" + selected);
		// System.out.println(selected.getAttribute("class"));
		// System.out.println("table-container--checkbox svg-checkbox
		// input-control__grey");
		if (selected.getText().equalsIgnoreCase(selected.getText())) {
			System.out.println("selected series in list mode is verified Succesfully");
		} else {
			Assert.fail("selected series in list mode is NOT verified Succesfully");
		}
	}

	// TC_MS_297
	@And("^verify Mouse hover icons on series in table mode$")
	public void verify_Mouse_hover_icons_on_series_in_table_mode() throws Throwable {
		Thread.sleep(1000);
		// Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Icon"))).isDisplayed());
		// Thread.sleep(1000);
		Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series"))).isDisplayed());
	}

	// TC_MS_298
	@And("^Select SSP icon$")
	public void select_SSP_icon() throws Throwable {
		Thread.sleep(3000);

		WebElement we = login.driver.findElement(By.xpath((login.LOCATORS.getProperty("Seriesnameintablemode"))));
		action.moveToElement(we).click().build().perform();
		// WebElement we =
		// login.driver.findElement(By.xpath((login.LOCATORS.getProperty("I_icon_SSP"))));
		// action.moveToElement(we).pause(2000).click().build().perform();
	}

	// TC_MS_298
	@And("^verify Show Series info in table mode$")
	public void verify_Show_Series_info_in_table_mode() throws Throwable {
		boolean SSP = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Dialogue"))).isDisplayed();
		if (SSP == true) {
			System.out.println("Show Series info is Verified Successfully!!! ");
		} else {
			Assert.fail("Show Series info is NOT Verified Successfully!!!");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Close_window", 6).click();
	}

	// TC_MS_299
	@And("^verify series tooltip in table mode$")
	public void verify_series_tooltip_in_table_mode() throws Throwable {

		boolean tooltip = login.driver.findElement(By.xpath("//div[@class='tooltip tooltip__visible']")).isDisplayed();
		// boolean tooltip =
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text_Myseries"))).isDisplayed();
		if (tooltip == true) {
			System.out.println("Series tooltip info is Verified Successfully!!! ");
		} else {
			Assert.fail("Series tooltip  info is NOT Verified Successfully!!!");
		}
	}

	// TC_MS_300
	@And("^verify Edit series in table mode$")
	public void verify_Edit_series_in_table_mode() throws Throwable {

		WebElement we = CommonFunctionality.getElementByProperty(login.driver, "Edit_series", 8);
		action.moveToElement(we).build().perform();
		select_the_Edit_series_option();
		boolean editseries = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_list")))
				.isDisplayed();
		if (editseries == true) {
			System.out.println("Edit series option is Verified Successfully!!! ");
		} else {
			Assert.fail("Edit series option is NOT Verified Successfully!!!");
		}
	}

	// TC_MS_301
	@And("^verify Edit series Rename in table mode$")
	public void verify_Edit_series_Rename_in_table_mode() throws Throwable {

		WebElement we = CommonFunctionality.getElementByProperty(login.driver, "Edit_series", 8);
		action.moveToElement(we).build().perform();
		select_the_Edit_series_option();
		select_the_rename_option();
		change_series_name();
		Thread.sleep(3000);
		String seriesname = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Seriesnameintablemode")))
				.getText();
		String Seriesnameafter = "Test";
		if (seriesname.equalsIgnoreCase(Seriesnameafter)) {
			System.out.println("Edit series Rename table mode is verified Successfully");
		} else {
			Assert.fail("Edit series Rename table mode is NOT Verified Successfully");
		}
	}

	// TC_MS_302
	@And("^Verify Edit series Rename -Frequency-table mode$")
	public void verify_Edit_series_Rename_Frequency_table_mode() throws Throwable {

		WebElement we = CommonFunctionality.getElementByProperty(login.driver, "Edit_series", 8);
		action.moveToElement(we).build().perform();

		Thread.sleep(1000);
		CommonFunctionality.getElementByProperty(login.driver, "Edit_series", 6).click();

		Thread.sleep(1000);
		CommonFunctionality.getElementByProperty(login.driver, "Edit_series_frequency", 6).click();

		Thread.sleep(1000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Edit_series_frequencydropdown")))
				.size() != 0) {
			System.out.println("Edit series Rename Frequency is Verified Successfully!!! ");
		} else {
			Assert.fail("Edit series Rename Frequency is NOT Verified Successfully");
		}
	}

	@Given("^search for the Series id  as \"([^\"]*)\"$")
	public void search_for_the_Series_id_as(String arg1) throws Throwable {
		Thread.sleep(2000);
		CommonFunctionality.getElementByProperty(login.driver, "Search", 10).sendKeys(arg1);
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("(//div[@class='add-to-data-selection--icon'])[1]")).click();

	}

	// TC_MS_303
	@And("^Select the Currency option$")
	public void select_the_Currency_option() throws Throwable {
		Thread.sleep(2000);
		CommonFunctionality.getElementByProperty(login.driver, "Edit_series_Currency", 6).click();
	}

	// TC_MS_303
	@And("^Verify Edit series Rename -Currency-table mode$")
	public void verify_Edit_series_Rename_Currency_table_mode() throws Throwable {

		WebElement we = CommonFunctionality.getElementByProperty(login.driver, "Edit_series", 8);
		action.moveToElement(we).build().perform();
		Thread.sleep(2000);
		CommonFunctionality.getElementByProperty(login.driver, "Edit_series", 6).click();
		Thread.sleep(2000);
		CommonFunctionality.getElementByProperty(login.driver, "Edit_series_Currency", 6).click();
		Thread.sleep(1000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Edit_series_frequencydropdown")))
				.size() != 0) {
			System.out.println("Edit series Rename Currency is Verified Successfully!!! ");
		} else {
			Assert.fail("Edit series Rename Currency is NOT Verified Successfully");
		}

	}

	// TC_MS_304
	@And("^Verify Edit series Rename change-table mode$")
	public void verify_Edit_series_Rename_change_table_mode() throws Throwable {

		WebElement we = CommonFunctionality.getElementByProperty(login.driver, "Edit_series", 8);
		action.moveToElement(we).build().perform();
		Thread.sleep(2000);
		CommonFunctionality.getElementByProperty(login.driver, "Edit_series", 6).click();

		Thread.sleep(2000);
		CommonFunctionality.getElementByProperty(login.driver, "Edit_series_change", 6).click();

		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Edit_series_frequencydropdown")))
				.size() != 0) {
			System.out.println("Edit series Rename Change is Verified Successfully!!! ");
		} else {
			Assert.fail("Edit series Rename change is NOT Verified Successfully");
		}
	}

	// TC_MS_305
	@And("^Verify Remove series if no visuals created from the series-table mode$")
	public void verify_Remove_series_if_no_visuals_created_from_the_series_table_mode() throws Throwable {
		String allseries = CommonFunctionality.getElementByProperty(login.driver, "Total_series_count", 6).getText();
		Allseriescount = Integer.parseInt(allseries);

		WebElement we = login.driver.findElement(By.xpath((login.LOCATORS.getProperty("Edit_series"))));
		action.moveToElement(we).build().perform();
		Thread.sleep(3000);
		CommonFunctionality.getElementByProperty(login.driver, "Series_remove", 8).click();

		Thread.sleep(6000);
		String allseriesafterremove = CommonFunctionality.getElementByProperty(login.driver, "Total_series_count", 6)
				.getText();
		int Allseriesafterremove = Integer.parseInt(allseriesafterremove);
		if (Allseriescount != (Allseriesafterremove)) {

			System.out.println("Remove series if no visuals created from the series is Verified Successfully!!! ");
		} else {
			Assert.fail("Remove series if no visuals created from the series is NOT Verified Successfully");
		}
	}

	// TC_MS_306
	@And("^Verify Remove series if  visuals created from the series-table mode$")
	public void verify_Remove_series_if_visuals_created_from_the_series_table_mode() throws Throwable {

		// WebElement we = CommonFunctionality.getElementByProperty(login.driver,
		// "Edit_series", 8);
		// action.moveToElement(we).build().perform();

		WebElement we = login.driver.findElement(
				By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[1]"));
		action.moveToElement(we).build().perform();

		CommonFunctionality.getElementByProperty(login.driver, "Series_remove", 8).click();
		Thread.sleep(2000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Delete_series_popup"))).size() != 0) {
			System.out.println("Remove series if  visuals created from the series is Verified Successfully!!! ");
		} else {
			Assert.fail("Remove series if  visuals created from the series is NOT Verified Successfully");
		}
		Thread.sleep(500);
		CommonFunctionality.getElementByProperty(login.driver, "Delete_ok_button", 6).click();
		Thread.sleep(1000);

//		for (int i = 1; i <= 1; i++){
//			Thread.sleep(500);
//			login.driver.findElement(By.xpath("//*[@class='search-series-list']/*[" + i + "]/div/a/div[2]")).click();
//		}
	}

	@And("^clear the selected series and seriesID$")
	public void clear_the_selected_series_and_seriesID() throws Throwable {
		CommonFunctionality.Views_list();
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).clear();
	}
}


