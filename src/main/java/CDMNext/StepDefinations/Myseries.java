package CDMNext.StepDefinations;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class Myseries {
	public String Seriesnameforpreview;
	WebElement element;
	WebElement ulelement;
	public String Searchinserieslistfilter;
	public String FirstseriesName;
	public String firstFourChars;
	public String function_series_name;
	public String TEST;
	public String Seriesname;

	// TC_MS_01
	@And("^Select the Expand Icon$")
	public void select_the_Expand_Icon() throws Throwable {
		Thread.sleep(6000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_Icon_Left"))).click();
	}

	// TC_MS_01
	@And("^Verify View panel which should be Expanded$")
	public void verify_View_panel_which_should_be_Expanded() throws Throwable {
		Thread.sleep(6000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Expand_Icon_Right"))).size() != 0) {
			System.out.println("Expand icon is working");
		} else {
			Assert.fail("Expand icon is NOT working");
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_Icon_Right"))).click();
	}

	// TC_MS_02
	@And("^Verify for \"([^\"]*)\" series functionality under \"([^\"]*)\" tab$")
	public void verify_for_series_functionality_under_tab(String arg1, String arg2) throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MyInsight_Tab"))).click();
		Thread.sleep(3000);
		Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Related_Series"))).isEnabled());
		Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename"))).isEnabled());
		Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Preview"))).isEnabled());
	}

	// TC_MS_03
	@And("^Select some series to my series tab$")
	public void select_some_series_to_my_series_tab() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MyInsight_Tab"))).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
		for (int i = 1; i <= 1; i++) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//ul[@class='search-series-list']/li[" + i + "]/div/a/div[2]")).click();
		}
		Thread.sleep(5000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
	}

	// TC_MS_03
	@And("^Select all series$")
	public void select_all_series() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_select_all"))).click();
	}

	// TC_MS_03
	@And("^select the Related series option$")
	public void select_the_Related_series_option() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Related_Series"))).click();
	}

	// TC_MS_03
	@And("^Verify the Series suggestion manager popup$")
	public void verify_the_Series_suggestion_manager_popup() throws Throwable {
		Thread.sleep(5000);
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Related_Series_popup"))).isDisplayed());
		System.out.println("Pop up displayed");
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		Thread.sleep(3000);
		delete_series();
	}

	// TC_MS_04
	@And("^select the Rename series option$")
	public void select_the_Rename_series_option() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename"))).click();
	}

	// TC_MS_04
	@And("^Verify the Rename popup$")
	public void verify_the_Rename_popup() throws Throwable {
		Thread.sleep(5000);
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Related_Series_popup"))).isDisplayed());
		System.out.println("Pop up displayed");
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
	}

	// TC_MS_05
	@And("^Verify the Rename option if no series selected$")
	public void verify_the_Rename_option_if_no_series_selected() throws Throwable {
		Thread.sleep(4000);
		String Seriesinmyseries = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("UnSelected_series")))
				.getText();
		System.out.println(Seriesinmyseries);
		String Seriesinpopup = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("UnSelected_series_inpopup"))).getText();
		String str = Seriesinpopup;
		String Seriesinpopup_num = str.replaceAll("[^0-9]", "");
		System.out.println(Seriesinpopup_num);
		System.out.println(Seriesinpopup + ":" + Seriesinmyseries);
		if (Seriesinmyseries.equalsIgnoreCase(Seriesinpopup_num)) {

			System.out.println("Verified the Rename option if no series selected");
		} else {
			Assert.fail("The Rename option if no series selected is NOT Verified");
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		Thread.sleep(3000);
		delete_series();
	}

	// TC_MS_07
	@And("^get the series name$")
	public void get_the_series_name() throws Throwable {
		Thread.sleep(4000);
		FirstseriesName = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_series_Name"))).getText();
		System.out.println(FirstseriesName);
	}

	// TC_MS_07
	@And("^Verify the series order in Rename popup$")
	public void verify_the_series_order_in_Rename_popup() throws Throwable {
		Thread.sleep(4000);
		String FirstseriesNameinpopup = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("First_series_Name_in_popup"))).getAttribute("value");
		System.out.println(FirstseriesNameinpopup);
		System.out.println(FirstseriesName + ":" + FirstseriesNameinpopup);
		if (FirstseriesName.equalsIgnoreCase(FirstseriesNameinpopup)) {

			System.out.println("Verified the series order in Rename popup");
		} else {
			Assert.fail("The series order in Rename popup NOT Verified");
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		Thread.sleep(3000);
		delete_series();
	}

	// TC_MS_08
	@And("^Verify the Rename option if series selected$")
	public void verify_the_Rename_option_if_series_selected() throws Throwable {
		Thread.sleep(4000);
		String FirstseriesNameinpopup = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("First_series_Name_in_popup"))).getAttribute("value");
		System.out.println(FirstseriesNameinpopup);
		System.out.println(FirstseriesName + ":" + FirstseriesNameinpopup);
		if (FirstseriesName.equalsIgnoreCase(FirstseriesNameinpopup)) {

			System.out.println("Verified the series order in Rename popup");
		} else {
			Assert.fail("The series order in Rename popup NOT Verified");
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		Thread.sleep(3000);
		delete_series();
	}

	// TC_MS_08
	@And("^Select first series$")
	public void select_first_series() throws Throwable {
		Thread.sleep(4000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_series_check_box"))).click();
	}

	// TC_MS_09
	@And("^Verify the Rename option for number of available itmes$")
	public void verify_the_Rename_option_for_number_of_available_itmes() throws Throwable {
		Thread.sleep(4000);
		String Seriesinmyseries = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("UnSelected_series")))
				.getText();
		System.out.println(Seriesinmyseries);
		String Seriesinpopup = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("UnSelected_series_inpopup"))).getText();
		String str = Seriesinpopup;
		String Seriesinpopup_num = str.replaceAll("[^0-9]", "");
		System.out.println(Seriesinpopup_num);
		System.out.println(Seriesinpopup + ":" + Seriesinmyseries);
		if (Seriesinmyseries.equalsIgnoreCase(Seriesinpopup_num)) {

			System.out.println("Verified the Rename option if series selected");
		} else {
			Assert.fail("The Rename option if series selected is NOT Verified");
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		Thread.sleep(3000);
		delete_series();
	}

	// TC_MS_10
	@And("^Select random series to my series tab$")
	public void select_random_series_to_my_series_tab() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MyInsight_Tab"))).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
		for (int i = 1; i <= 3; i++) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//ul[@class='search-series-list']/li[" + i + "]/div/a/div[2]")).click();
		}
		Thread.sleep(5000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
	}

	// TC_MS_10
	@And("^Verify the Rename find field$")
	public void verify_the_Rename_find_field() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Find_search_box"))).sendKeys(FirstseriesName);
		Thread.sleep(5000);
		String Result_series_in_search_box = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("Result_series_in_search_box"))).getText();
		if (FirstseriesName.equalsIgnoreCase(Result_series_in_search_box)) {

			System.out.println("Verified the Rename find field");

		} else {
			Assert.fail("The Rename find field is NOT Verified");
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		Thread.sleep(3000);
		delete_series();
	}

	// TC_MS_11
	@And("^Verify the number of searched result$")
	public void verify_the_number_of_searched_result() throws Throwable {
		Thread.sleep(5000);
		List<WebElement> Serarch_result_count = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("Serarch_result_count")));
		System.out.println(Serarch_result_count.size());
		int Totalseries = Serarch_result_count.size();
		String seriescount = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("UnSelected_series_inpopup")))
				.getText();
		String str = seriescount;
		String Seriesinpopup_num = str.replaceAll("[^0-9]", "");
		int Seriesnumber = Integer.parseInt(Seriesinpopup_num);
		System.out.println(Seriesnumber);
		if (Seriesnumber == (Totalseries)) {
			System.out.println("Verified the number of searched result");
		} else {
			Assert.fail("The number of searched result is NOT Verified");
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		Thread.sleep(3000);
		delete_series();
	}

	// TC_MS_13
	@And("^select the series to be replace$")
	public void select_the_series_to_be_replace() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Find_search_box"))).sendKeys(FirstseriesName);

	}

	// TC_MS_13
	@And("^Verify the Replace field$")
	public void verify_the_Replace_field() throws Throwable {
		Thread.sleep(5000);
		String replaceseries = "Trade Balance";
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Replace_search_box"))).sendKeys(replaceseries);
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Replace"))).click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OK_Button"))).click();
		Thread.sleep(3000);
		FirstseriesName = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_series_Name"))).getText();
		System.out.println(FirstseriesName);

		if (replaceseries.equalsIgnoreCase(FirstseriesName)) {
			System.out.println("Verified the Replace field");
		} else {
			Assert.fail("The Replace field is NOT Verified");
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		Thread.sleep(3000);
		delete_series();
	}

	// TC_MS_14
	@And("^Verify the Replace All field$")
	public void verify_the_Replace_All_field() throws Throwable {
		Thread.sleep(5000);
		String replaceseries = FirstseriesName;
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Replace_search_box"))).sendKeys(replaceseries);
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Replace_All"))).click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OK_Button"))).click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Myseries_input"))).sendKeys(replaceseries);
		Thread.sleep(3000);
		String FirstSeriescount = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_Series_count")))
				.getText();
		System.out.println(FirstSeriescount);
		Thread.sleep(1000);
		String SecondSeriescount = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_Series_count")))
				.getText();
		System.out.println(SecondSeriescount);
		if (FirstSeriescount.equalsIgnoreCase(SecondSeriescount)) {

			System.out.println("Verified the Replace All field");
		} else {
			Assert.fail("The Replace All field is NOT Verified");
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		Thread.sleep(3000);
		delete_series();
	}

	// TC_MS_15
	@And("^Verify the Replace for selected series$")
	public void verify_the_Replace_for_selected_series() throws Throwable {
		Thread.sleep(3000);
		String TEST = "TEST";
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Replace_search_box"))).sendKeys(TEST);
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_series_in_rename"))).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Replace"))).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OK_Button"))).click();
		Thread.sleep(1000);
		String firstseriesname = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_series_Name")))
				.getText();
		System.out.println(TEST + ":" + firstseriesname);
		if (firstseriesname.equalsIgnoreCase(TEST)) {

			System.out.println("Verified the Replace for selected series");
		} else {
			Assert.fail("The Replace for selected series is NOT Verified");
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		Thread.sleep(3000);
		delete_series();
	}
	// TC_MS_16
	@And("^rename the series name as \"([^\"]*)\"$")
	public void rename_the_series_name_as(String arg1) throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Second_series_in_rename"))).clear();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Second_series_in_rename")))
				.sendKeys(FirstseriesName);
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_popup"))).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Find_search_box"))).sendKeys(FirstseriesName);

	}
	// TC_MS_16
	@And("^Verify Rename Find next button$")
	public void verify_Rename_Find_next_button() throws Throwable {
		Thread.sleep(3000);
		String TESTING = "TESTING";
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Replace_search_box"))).sendKeys(TESTING);
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Find_Next"))).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Replace"))).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OK_Button"))).click();
		Thread.sleep(1000);
		String secondseries = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Second_series_Name")))
				.getText();
		if (TESTING.equalsIgnoreCase(secondseries)) {

			System.out.println("Verified the Rename Find next button");
		} else {
			Assert.fail("The Rename Find next button is NOT Verified");
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		Thread.sleep(3000);
		delete_series();
	}

	
	//TC_MS_17
	@And("^send series name to find and replace field$")
	public void send_series_name_to_find_and_replace_field() throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Find_search_box"))).sendKeys(FirstseriesName);
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Replace_search_box"))).sendKeys(FirstseriesName);
	}
	//TC_MS_17
	@And("^Verify Rename Find next button is disable$")
	public void verify_Rename_Find_next_button_is_disable() throws Throwable {
		Thread.sleep(1000);
		boolean findnext = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Find_Next"))).isEnabled();
		
		if(findnext==true)
		{
			System.out.println("Rename Find next button is disable");
		} else {
			Assert.fail("Rename Find next button is NOT disable");
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		Thread.sleep(3000);
		delete_series();
	}
	//TC_MS_18
	@And("^Verify Rename- Replace, Replace All and Find next buttons$")
	public void verify_Rename_Replace_Replace_All_and_Find_next_buttons() throws Throwable {
		Thread.sleep(1000);
		verify_Rename_Find_next_button_is_disable();
		boolean replace = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Find_Next"))).isEnabled();
		if(replace==true)
		{
			System.out.println("Rename Find next button is disable");
		} else {
			Assert.fail("Rename Find next button is NOT disable");
		}
		boolean replaceall = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Find_Next"))).isEnabled();
		if(replaceall==true)
		{
			System.out.println("Rename Find next button is disable");
		} else {
			Assert.fail("Rename Find next button is NOT disable");
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		Thread.sleep(3000);
		delete_series();
	}
	
	
	//TC_MS_19
	@And("^Send invalid keyword$")
	public void send_invalid_keyword() throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Find_search_box"))).sendKeys("TESTING");
	}
	//TC_MS_19
	@And("^Verify Rename- for invalid search$")
	public void verify_Rename_for_invalid_search() throws Throwable {
		String Nomatchesfound ="No matches found";
		String No_matches_found= login.driver.findElement(By.xpath(login.LOCATORS.getProperty("No_matches_found"))).getText();
		System.out.println(No_matches_found);
		if(No_matches_found.endsWith(Nomatchesfound))
		{
			System.out.println("Rename for invalid search is verified");
		}else {
			Assert.fail("Rename for invalid search is NOT verified");
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		Thread.sleep(3000);
		delete_series();
	}
	
	
	//TC_MS_20
	@And("^select edit series dropdown$")
	public void select_edit_series_dropdown() throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info"))).click();
	}
	//TC_MS_20
	@And("^Verify edit series dropdown$")
	public void verify_edit_series_dropdown() throws Throwable {
		Thread.sleep(1000);
		boolean Editseriesinfoname=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_Name"))).isDisplayed();
		if(Editseriesinfoname==true)
		{
			System.out.println("Verified edit series dropdown");
		} else {
			Assert.fail("Edit series dropdown is not verified");
		}
		Thread.sleep(1000);
		boolean Editseriesinfofunction=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_Function"))).isDisplayed();
		if(Editseriesinfofunction==true)
		{
			System.out.println("Verified edit series dropdown");
		} else {
			Assert.fail("Edit series dropdown is not verified");
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		Thread.sleep(3000);
		delete_series();
	}
	//TC_MS_21
	@And("^Verify default selection for Edit series info dropdown$")
	public void verify_default_selection_for_Edit_series_info_dropdown() throws Throwable {
		Thread.sleep(5000);
		String Defaultnameineditseriesinfo ="Name";
		
		String Default_name_in_editseriesinfo= login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_Name"))).getText();
		System.out.println(Default_name_in_editseriesinfo);
		
		if(Default_name_in_editseriesinfo.contains(Defaultnameineditseriesinfo))
		{
			System.out.println("Verified default selection for Edit series info dropdown");
		}else {
			Assert.fail("Default selection for Edit series info dropdown is NOT verified ");
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		Thread.sleep(3000);
		delete_series();
	}
	//TC_MS_22
	@And("^Verify  Rename-Name selection$")
	public void verify_Rename_Name_selection() throws Throwable {
		Thread.sleep(5000);
		String Seriesfirstname= login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_series_Name_in_popup"))).getText();
		System.out.println(Seriesfirstname);
		Thread.sleep(5000);
		if(Seriesfirstname.equalsIgnoreCase(FirstseriesName)){
			System.out.println("Verified Rename-Name selection");
		}else {
			Assert.fail("Rename-Name selection is NOT verified ");
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		Thread.sleep(3000);
		delete_series();
		
	}
	//TC_MS_23
	@And("^Applay Function as \"([^\"]*)\"$")
	public void applay_Function_as(String arg1) throws Throwable {
		Thread.sleep(5000);
		select_all_series();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("function_applay"))).click();
		
	}
	//TC_MS_23
	@And("^get the Applayied function series name$")
	public void get_the_Applayied_function_series_name() throws Throwable {
		Thread.sleep(5000);
		function_series_name= login.driver.findElement(By.xpath(login.LOCATORS.getProperty("function_series_name"))).getText();
		System.out.println(function_series_name);
		
	}
	//TC_MS_23
	@And("^Verify  Function Description-Name selection$")
	public void verify_Function_Description_Name_selection() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info"))).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_Function"))).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info"))).click();
		Thread.sleep(5000);
		String Seriesfirstnameinpopup= login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_series_Name_in_popup"))).getText();
		System.out.println(Seriesfirstnameinpopup);
		System.out.println(Seriesfirstnameinpopup +":"+ function_series_name);
		Thread.sleep(5000);
		if(Seriesfirstnameinpopup.contains(function_series_name)){
			System.out.println("Verified Function Description-Name selection");
		}else {
			Assert.fail("Function Description-Name selection is NOT verified ");
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		Thread.sleep(3000);
		delete_series();
		
	}
	//TC_MS_24
	@And("^Verify Function Description selection without function apply$")
	public void verify_Function_Description_selection_without_function_apply() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info"))).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_Function"))).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info"))).click();
		Thread.sleep(5000);
		
	String Seriesfirstnameinpopup= login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_series_Name_in_popup"))).getAttribute("value");
	
	if (Seriesfirstnameinpopup.isEmpty() || Seriesfirstnameinpopup ==null) {
		System.out.println("Verified Function selection without function apply");
	}else{
		Assert.fail("Function selection without function apply is NOT verified ");
	}
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
	Thread.sleep(3000);
	delete_series();
	}

	
	//TC_MS_25
	@And("^select any series to applay function$")
	public void select_any_series_to_applay_function() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_Series_select"))).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("function_applay"))).click();
		Thread.sleep(5000);
		get_the_Applayied_function_series_name();
		
	}
	//TC_MS_25
	@And("^Verify Function description if series applied functions in My series$")
	public void verify_Function_description_if_series_applied_functions_in_My_series() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info"))).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_Function"))).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info"))).click();
		Thread.sleep(5000);
		String Seriesfirstnameinpopup= login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_series_Name_in_popup"))).getText();
		System.out.println(Seriesfirstnameinpopup);
		System.out.println(Seriesfirstnameinpopup +":"+ function_series_name);
		Thread.sleep(5000);
		if(Seriesfirstnameinpopup.contains(function_series_name)){
			System.out.println("Verified Function Description-Name selection");
		}else {
			Assert.fail("Function Description-Name selection is NOT verified ");
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		Thread.sleep(3000);
		delete_series();
	}
	
	
	//TC_MS_26
	@And("^rename the function applied series \"([^\"]*)\"$")
	public void rename_the_function_applied_series(String arg1) throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info"))).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_Function"))).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info"))).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_series_in_rename"))).clear();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_series_in_rename"))).sendKeys(arg1);
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OK_Button"))).click();
	}
	//TC_MS_26
	@And("^Verify Function description editing$")
	public void verify_Function_description_editing() throws Throwable {
		TEST = "TEST";
		Thread.sleep(5000);
		String Seriesfirstname= login.driver.findElement(By.xpath(login.LOCATORS.getProperty("function_series_name"))).getText();
		System.out.println(Seriesfirstname);
		String s1 = Seriesfirstname.substring(1, 5);
		System.out.println(s1 + ":" + TEST);
		Thread.sleep(5000);
		if(s1.equalsIgnoreCase(TEST)){
			System.out.println("Verified Function Description editing");
		}else {
			Assert.fail("Function Description editing is NOT verified ");
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		Thread.sleep(3000);
		delete_series();
	  
	}
	//TC_MS_28
	@And("^Verify Function description apply original title icon$")
	public void verify_Function_description_apply_original_title_icon() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info"))).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_Function"))).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info"))).click();
		Thread.sleep(10000);
		String Firsttextinrename=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_series_in_rename"))).getText();
		System.out.println("1 = " + Firsttextinrename);
		Thread.sleep(8000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_series_in_rename"))).clear();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_series_in_rename"))).sendKeys("TESTING");
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reverse_icon_rename"))).click();
		String Secondtextinrename=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_series_in_rename"))).getText();
		System.out.println(Secondtextinrename);
		Thread.sleep(5000);
		if(Secondtextinrename.equalsIgnoreCase(Firsttextinrename)){
			System.out.println("Verified Function Description apply original title icon");
			}
		else{
			Assert.fail("Function Description apply original title icon is NOT verified ");
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		Thread.sleep(3000);
		delete_series();
	}
	
	//TC_MS_30
	@And("^Verify Function description apply original title icon for more tha one series$")
	public void verify_Function_description_apply_original_title_icon_for_more_tha_one_series() throws Throwable {
		verify_Function_description_apply_original_title_icon() ;
	}

	//TC_MS_31
	@And("^Verify Rename Function discription clicking on series name$")
	public void verify_Rename_Function_discription_clicking_on_series_name() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info"))).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_Function"))).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info"))).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("series_name_inrename"))).click();
		Thread.sleep(5000);
		Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Dialogue"))).isDisplayed());
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Dialogue_X_Icon"))).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		Thread.sleep(3000);
		delete_series();
	}
	
	
	//TC_MS_32
	@And("^Change the series name as \"([^\"]*)\"$")
	public void change_the_series_name_as(String arg1) throws Throwable {
		//String arg1 = "TESTINGSERIES"
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_series_in_rename"))).clear();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_series_in_rename"))).sendKeys(arg1);
		Thread.sleep(5000);
	    Seriesname=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_series_in_rename"))).getAttribute("value");
		System.out.println(Seriesname);
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OK_Button"))).click();
		
		
	}
	//TC_MS_32
	@And("^Verify Rename Name Editing series name$")
	public void verify_Rename_Name_Editing_series_name() throws Throwable {
		Thread.sleep(5000);
		String Seriesnameinmyseries=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_series_Name"))).getText();
		System.out.println(Seriesnameinmyseries);
		Thread.sleep(5000);
		System.out.println(Seriesnameinmyseries +":"+ Seriesname);
		if(Seriesnameinmyseries.equalsIgnoreCase(Seriesname)){
			System.out.println("Verified Rename Name Editing series name");
		}
	else{
		Assert.fail("Rename Name Editing series name is NOT verified ");
		delete_series();
		}
		delete_series();
	}
	//TC_MS_33
	@And("^Name Series apply original title icon$")
	public void name_Series_apply_original_title_icon() throws Throwable {
		String Firsttextinrename=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_series_in_rename"))).getText();
		System.out.println(Firsttextinrename);
		Thread.sleep(8000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_series_in_rename"))).clear();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_series_in_rename"))).sendKeys("TESTING");
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reverse_icon_rename"))).click();
		String Secondtextinrename=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_series_in_rename"))).getText();
		System.out.println(Secondtextinrename);
		Thread.sleep(5000);
		if(Secondtextinrename.equalsIgnoreCase(Firsttextinrename)){
			System.out.println("Verified Series apply original title icon");
			}
		else{
			Assert.fail("Series apply original title icon is NOT verified ");
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		Thread.sleep(3000);
		delete_series();
	}
	
	
	//TC_MS_33
	@And("^Change the series name$")
	public void change_the_series_name() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_series_in_rename"))).clear();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_series_in_rename"))).sendKeys("TESTING");
		Thread.sleep(5000);
	    Seriesname=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_series_in_rename"))).getAttribute("value");
		System.out.println(Seriesname);
	}
	
	//TC_MS_34
	@And("^Name Series apply original title icon  for more than one series$")
	public void name_Series_apply_original_title_icon_for_more_than_one_series() throws Throwable {
		name_Series_apply_original_title_icon();
	}
	//TC_MS_35
	@And("^Verify > icon if no changes in series name and description$")
	public void verify_icon_if_no_changes_in_series_name_and_description() throws Throwable {
		Thread.sleep(5000);
		Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reverse_icon_rename"))).isDisplayed());
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		Thread.sleep(5000);
		delete_series();
	}
	//TC_MS_36
	@And("^Select Maximum series to my series tab$")
	public void select_Maximum_series_to_my_series_tab() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MyInsight_Tab"))).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
		for (int i = 1; i <= 8; i++) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//ul[@class='search-series-list']/li[" + i + "]/div/a/div[2]")).click();
		}
		Thread.sleep(5000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
	}
	
	//TC_MS_36
	@Given("^Verify Rename scroll bar for more series in the popup$")
	public void verify_Rename_scroll_bar_for_more_series_in_the_popup() throws Throwable {
		Thread.sleep(5000);
		List<WebElement> Totalseries = login.driver.findElements(By.xpath("//*[contains(text(),'Edit series info:')]//following::input"));
		System.out.println("Total Insights are : " + Totalseries.size());
		int Totalseries_count = Totalseries.size();
		int x=9;
		if(Totalseries_count ==x){
			System.out.println("Verified Rename scroll bar for more series in the popup");
		}
	else{
		Assert.fail("Rename scroll bar for more series in the popup is NOT verified ");
		}
		delete_series();
	}
	//TC_MS_37
	@And("^Verify Rename Apply button$")
	public void verify_Rename_Apply_button() throws Throwable {
		Thread.sleep(5000);
		Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Applay_Button"))).isDisplayed());
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Applay_Button"))).click();
		Thread.sleep(5000);
		Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Find_search_box"))).isDisplayed());
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		Thread.sleep(5000);
		delete_series();
	}
	
	
	//TC_MS_38
	@And("^Verify Rename OK button$")
	public void verify_Rename_OK_button() throws Throwable {
		Thread.sleep(5000);
		Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OK_Button"))).isDisplayed());
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OK_Button"))).click();
		Thread.sleep(5000);
		if((login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Rename_popup"))).size()==0)){
			System.out.println("Verified Rename ok button");
		}else{
			Assert.fail("Rename ok button is NOT verified ");
		}
		Thread.sleep(3000);
		delete_series();
	}
	
	//TC_MS_39
	@And("^select the Maximize option$")
	public void select_the_Maximize_option() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_rename"))).click();
	}
	//TC_MS_39
	@And("^Verify the Maximize option$")
	public void verify_the_Maximize_option() throws Throwable {
		Thread.sleep(5000);
		Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Collapse_rename"))).isDisplayed());
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Collapse_rename"))).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		Thread.sleep(3000);
		delete_series();
	}
	
	//TC_MS_40
	  @And("^select the Minimize option$")
		public void select_the_Minimize_option() throws Throwable {
			Thread.sleep(5000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_rename"))).click();
		}
	//TC_MS_40
	   @And("^Verify the Minimize option$")
		public void verify_the_Minimize_option() throws Throwable {
			Thread.sleep(5000);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Collapse_rename"))).isDisplayed());
			Thread.sleep(5000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Collapse_rename"))).click();
			Thread.sleep(5000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
			Thread.sleep(3000);
			delete_series();
		}
	
	 //TC_MS_41
	   @And("^select the Fullscreen option$")
		public void select_the_Fullscreen_option() throws Throwable {
		   Thread.sleep(5000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Mini_Max_mize_rename"))).click();
		}
	 //TC_MS_41
	   @And("^Verify the Fullscreen option$")
		public void verify_the_Fullscreen_option() throws Throwable {
		   String Maximize=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Mini_Max_mize_rename"))).getAttribute("title");
			System.out.println(Maximize);
			String MAX = "Maximize";
			
			if(Maximize.equalsIgnoreCase(MAX)){
				
				System.out.println("Verified Fullscreen option");
			}else{
				Assert.fail("Fullscreen option is NOT verified ");
			}
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
			Thread.sleep(3000);
			delete_series();
		}
	 //TC_MS_42
	   @And("^select the ExitFullscreen option$")
	   public void select_the_ExitFullscreen_option() throws Throwable {
		   Thread.sleep(5000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Mini_Max_mize_rename"))).click();
	   }
	 //TC_MS_42
	   @And("^Verify the ExitFullscreen option$")
	   public void verify_the_ExitFullscreen_option() throws Throwable {
		   select_the_ExitFullscreen_option();
		   String Minimize=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Mini_Max_mize_rename"))).getAttribute("title");
			System.out.println(Minimize);
			String MIN = "Minimize";
			
			if(Minimize.equalsIgnoreCase(MIN)){
				
				System.out.println("Verified EXITFullscreen option");
			}else{
				Assert.fail("EXITFullscreen option is NOT verified ");
			}
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
			Thread.sleep(3000);
			delete_series();
	   }
	 //TC_MS_43
	   @And("^select the Cancel option$")
	   public void select_the_Cancel_option() throws Throwable {
		   Thread.sleep(5000);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).isDisplayed());
			 Thread.sleep(5000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();	
	   }
	   //TC_MS_43
	   @And("^Verify the Cancel option$")
	   public void verify_the_Cancel_option() throws Throwable {
		   Thread.sleep(5000);
		   if((login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Rename_popup"))).size()==0)){
				System.out.println("Verified Cancel option");
			}else{
				Assert.fail("Cancel option is NOT verified ");
			}
			Thread.sleep(3000);
			delete_series();
	   }
	
	   //TC_MS_44
	   @And("^select the preview option$")
	   public void select_the_preview_option() throws Throwable {
		   Thread.sleep(3000);
		   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview"))).click();
	   }
	   //TC_MS_44
	   @And("^Verify the Preview pop up$")
	   public void verify_the_Preview_pop_up() throws Throwable {
		   if((login.driver.findElements(By.xpath(login.LOCATORS.getProperty("preview_popup"))).size()!=0)){
				System.out.println("Verified Preview pop up");
			}else{
				Assert.fail("Preview pop up is NOT verified ");
			}
		   Thread.sleep(3000);
		   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_popup_close"))).click();
		   Thread.sleep(3000);
			delete_series();
	   }
	   
	   //TC_MS_45
	   @And("^Verify the Preview-chart tab$")
	   public void verify_the_Preview_chart_tab() throws Throwable {
		   Thread.sleep(3000);
		   if((login.driver.findElements(By.xpath(login.LOCATORS.getProperty("preview_Chart"))).size()!=0)){
				System.out.println("Verified Preview-chart tab");
			}else{
				Assert.fail("Preview-chart tab is NOT verified ");
			}
		   Thread.sleep(3000);
		   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_popup_close"))).click();
		   Thread.sleep(3000);
			delete_series();
	   }
	   
	   
	   //TC_MS_46
	   @And("^Verify the Preview chart legend$")
	   public void verify_the_Preview_chart_legend() throws Throwable {
		   
		   try{
		   Actions action = new Actions(login.driver);
			WebElement chartlegend = login.driver.findElement(By.xpath("//*[@class='highcharts-container ']/div[1]/div/div/div[1]/span/div[1]/span[1]"));
					action.moveToElement(chartlegend).build().perform();				
					Thread.sleep(3000);
					 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_Chart_Legend"))).click();
					 Thread.sleep(5000);
						Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Dialogue"))).isDisplayed());
						Thread.sleep(5000);
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Dialogue_X_Icon"))).click();
						Thread.sleep(5000);
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_popup_close"))).click();
						Thread.sleep(3000);
						delete_series();
		   }
		   catch(org.openqa.selenium.StaleElementReferenceException ex){
			   Actions action = new Actions(login.driver);
				WebElement chartlegend = login.driver.findElement(By.xpath("//*[@class='highcharts-container ']/div[1]/div/div/div[1]/span/div[1]/span[1]"));
						action.moveToElement(chartlegend).build().perform();
						 Thread.sleep(3000);
						 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_Chart_Legend"))).click();
						 Thread.sleep(5000);
							Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Dialogue_preview"))).isDisplayed());
							Thread.sleep(5000);
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
							Thread.sleep(5000);
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_popup_close"))).click();
							Thread.sleep(3000);
							delete_series();
		   }
					
	   }

	   //TC_MS_48
	   @And("^Verify the Preview iding all series from chart$")
	   public void verify_the_Preview_iding_all_series_from_chart() throws Throwable {
		   try{
		   Actions action = new Actions(login.driver);
			WebElement chartlegend = login.driver.findElement(By.xpath("//*[@class='highcharts-container ']/div[1]/div/div/div[1]/span/div[1]/div"));
					action.moveToElement(chartlegend).build().perform();				
					Thread.sleep(3000);
					 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_Chart_Legend_X"))).click();
						Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_Chart_Legend_nodata"))).isDisplayed());
						Thread.sleep(5000);
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_popup_close"))).click();
						Thread.sleep(3000);
						delete_series();
		   }
		   catch(org.openqa.selenium.StaleElementReferenceException ex)
		   {
			   Actions action = new Actions(login.driver);
				WebElement chartlegend = login.driver.findElement(By.xpath("//*[@class='highcharts-container ']/div[1]/div/div/div[1]/span/div[1]/div"));
						action.moveToElement(chartlegend).build().perform();				
						Thread.sleep(3000);
						 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_Chart_Legend_X"))).click();
							Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_Chart_Legend_nodata"))).isDisplayed());
							Thread.sleep(5000);
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_popup_close"))).click();
							Thread.sleep(3000);
							delete_series();
		   }
		   
		   }
	   //TC_MS_49
	   @Given("^Verify the Preview chart Source$")
	   public void verify_the_Preview_chart_Source() throws Throwable {
		   try{
			   Actions action = new Actions(login.driver);
				WebElement chartlegend = login.driver.findElement(By.xpath("//*[contains(text(),'Source: CEIC Data')][1]"));
						action.moveToElement(chartlegend).build().perform();				
						Thread.sleep(3000);
						 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_Ceicdata"))).click();
						   ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
						    login.driver.switchTo().window(tabs2.get(1));
							Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_page"))).isDisplayed());
							 login.driver.close();
							    login.driver.switchTo().window(tabs2.get(0));
							Thread.sleep(5000);
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_popup_close"))).click();
							Thread.sleep(3000);
							delete_series();
			   }
			   catch(org.openqa.selenium.StaleElementReferenceException ex)
			   {
				   Actions action = new Actions(login.driver);
					WebElement chartlegend = login.driver.findElement(By.xpath("//*[contains(text(),'Source: CEIC Data')][1]"));
							action.moveToElement(chartlegend).build().perform();				
							Thread.sleep(3000);
							 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_Ceicdata"))).click();
							   ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
							    login.driver.switchTo().window(tabs2.get(1));
								Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_page"))).isDisplayed());
								 login.driver.close();
								    login.driver.switchTo().window(tabs2.get(0));
								Thread.sleep(5000);
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_popup_close"))).click();
								Thread.sleep(3000);
								delete_series();
			   }
	   }
	   
	 //TC_MS_50
	   @And("^Verify the Preview -Table tab$")
	   public void verify_the_Preview_Table_tab() throws Throwable {
		   Thread.sleep(5000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_table_mode"))).click();
		   Thread.sleep(3000);
		   String Firstseriesname= login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_series_Name"))).getText();
			Thread.sleep(6000);
			String Text2 = login.driver.findElement(By.xpath("//span[@class='series-edit--title']")).getText();
			System.out.println(Text2 + ":" + Firstseriesname);
			if (Text2.equalsIgnoreCase(Firstseriesname)) {

				System.out.println("Preview Series functionality in Table is Working Successfully");
			} else {
				Assert.fail("Preview Series functionality in Table is NOT Working Successfully");
			}
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_popup_close"))).click();
			Thread.sleep(3000);
			delete_series();
	   }
	   
		 //TC_MS_51
	   @And("^Verify the Preview -Table tab on clicking series name$")
	   public void verify_the_Preview_Table_tab_on_clicking_series_name() throws Throwable {
		   Thread.sleep(5000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_table_mode"))).click();
		   Thread.sleep(3000);
		   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_table_mode_series_name"))).click();
		   Thread.sleep(2000);
		   Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_table_mode_SSP"))).isDisplayed());
		   Thread.sleep(2000);
		   Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).isDisplayed());
		   Thread.sleep(2000);
		   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_popup_close"))).click();
	   }
		
		 //TC_MS_52
	   @And("^Verify the Preview table Source$")
	   public void verify_the_Preview_table_Source() throws Throwable {
		   
		   Thread.sleep(5000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_table_mode"))).click();
			 Thread.sleep(5000);
		   JavascriptExecutor jse = (JavascriptExecutor) login.driver;
			element = login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[3]/div/div[1]/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div[2]/div/div[4]/div/table/thead/tr[5]/th[1]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[3]/div/div[1]/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div[2]/div/div[4]/div/table/thead/tr[10]/th[1]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[3]/div/div[1]/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div[2]/div/div[4]/div/table/tbody/tr[6]/td[1]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[3]/div/div[1]/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div[2]/div/div[4]/div/table/tbody/tr[12]/td[1]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[3]/div/div[1]/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div[2]/div/div[4]/div/table/tbody/tr[18]/td[1]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[3]/div/div[1]/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div[2]/div/div[4]/div/table/tbody/tr[24]/td[1]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			   Thread.sleep(10000);
			   try{
				   Actions action = new Actions(login.driver);
					WebElement chartlegend = login.driver.findElement(By.xpath("//*[contains(text(),'Source: CEIC Data')][1]"));
							action.moveToElement(chartlegend).build().perform();				
							Thread.sleep(3000);
							 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_table_mode_Source"))).click();
							   ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
							    login.driver.switchTo().window(tabs2.get(1));
								Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_page"))).isDisplayed());
								 login.driver.close();
								    login.driver.switchTo().window(tabs2.get(0));
								Thread.sleep(5000);
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_popup_close"))).click();
								Thread.sleep(3000);
								delete_series();
				   }
				   catch(org.openqa.selenium.StaleElementReferenceException ex)
				   {
					   Actions action = new Actions(login.driver);
						WebElement chartlegend = login.driver.findElement(By.xpath("//*[contains(text(),'Source: CEIC Data')][1]"));
								action.moveToElement(chartlegend).build().perform();				
								Thread.sleep(3000);
								 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_table_mode_Source"))).click();
								   ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
								    login.driver.switchTo().window(tabs2.get(1));
									Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_page"))).isDisplayed());
									 login.driver.close();
									    login.driver.switchTo().window(tabs2.get(0));
									Thread.sleep(5000);
									login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_popup_close"))).click();
									Thread.sleep(3000);
									delete_series();
				   }
	   }
	   
		 //TC_MS_53
	   @And("^Verify the Preview Statistics tab$")
	   public void verify_the_Preview_Statistics_tab() throws Throwable {
		   Thread.sleep(5000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_table_staticsdata"))).click();
			 Thread.sleep(1000);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_table_Name"))).isDisplayed());
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_popup_close"))).click();
			Thread.sleep(3000);
			delete_series();
	   }
	   
	   //TC_MS_54
	   @And("^Verify the Preview Statistics tab clicking on series name$")
	   public void verify_the_Preview_Statistics_tab_clicking_on_series_name() throws Throwable {
		   Thread.sleep(5000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_table_staticsdata"))).click();
			 Thread.sleep(5000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_table_mode_series_name"))).click();
		 Thread.sleep(1000);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_table_mode_SSP"))).isDisplayed());
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_popup_close"))).click();
			Thread.sleep(3000);
			delete_series();
	   }
	   
	   //TC_MS_55
	   @And("^Verify the Preview Statistics tab Source$")
	   public void verify_the_Preview_Statistics_tab_Source() throws Throwable {
		   Thread.sleep(5000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_table_staticsdata"))).click();
					 Thread.sleep(5000);
				   JavascriptExecutor jse = (JavascriptExecutor) login.driver;
					element = login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[3]/div/div[1]/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div[2]/div/div[4]/div/table/thead/tr[5]/th[1]"));
					jse.executeScript("arguments[0].scrollIntoView(true);", element);
					element = login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[3]/div/div[1]/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div[2]/div/div[4]/div/table/thead/tr[10]/th[1]"));
					jse.executeScript("arguments[0].scrollIntoView(true);", element);
					element = login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[3]/div/div[1]/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div[2]/div/div[4]/div/table/tbody/tr[6]/td[1]"));
					jse.executeScript("arguments[0].scrollIntoView(true);", element);
					element = login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[3]/div/div[1]/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div[2]/div/div[4]/div/table/tbody/tr[12]/td[1]"));
					jse.executeScript("arguments[0].scrollIntoView(true);", element);
					element = login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[3]/div/div[1]/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div[2]/div/div[4]/div/table/tbody/tr[18]/td[1]"));
					jse.executeScript("arguments[0].scrollIntoView(true);", element);
					element = login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[3]/div/div[1]/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div[2]/div/div[4]/div/table/tbody/tr[24]/td[1]"));
					jse.executeScript("arguments[0].scrollIntoView(true);", element);
					element = login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[3]/div/div[1]/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div[2]/div/div[4]/div/table/tbody/tr[30]/td[1]"));
					jse.executeScript("arguments[0].scrollIntoView(true);", element);
					element = login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[3]/div/div[1]/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div[2]/div/div[4]/div/table/tbody/tr[36]/td[1]"));
					jse.executeScript("arguments[0].scrollIntoView(true);", element);
					element = login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[3]/div/div[1]/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div[2]/div/div[4]/div/table/tbody/tr[42]/td[1]"));
					jse.executeScript("arguments[0].scrollIntoView(true);", element);
					element = login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[3]/div/div[1]/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div[2]/div/div[4]/div/table/tbody/tr[48]/td[1]"));
					jse.executeScript("arguments[0].scrollIntoView(true);", element);
					element = login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[3]/div/div[1]/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div[2]/div/div[4]/div/table/tbody/tr[54]/td[1]"));
					jse.executeScript("arguments[0].scrollIntoView(true);", element);
					element = login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[3]/div/div[1]/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div[2]/div/div[4]/div/table/tbody/tr[60]/td[1]"));
					jse.executeScript("arguments[0].scrollIntoView(true);", element);
					element = login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[3]/div/div[1]/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div[2]/div/div[4]/div/table/tbody/tr[66]/td[1]"));
					jse.executeScript("arguments[0].scrollIntoView(true);", element);
					element = login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[3]/div/div[1]/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div[2]/div/div[4]/div/table/tbody/tr[72]/td[1]"));
					jse.executeScript("arguments[0].scrollIntoView(true);", element);
					
					 try{
						   Actions action = new Actions(login.driver);
							WebElement chartlegend = login.driver.findElement(By.xpath("//*[contains(text(),'Source: CEIC Data')][1]"));
									action.moveToElement(chartlegend).build().perform();				
									Thread.sleep(3000);
									 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_table_mode_Source"))).click();
									   ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
									    login.driver.switchTo().window(tabs2.get(1));
										Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_page"))).isDisplayed());
										 login.driver.close();
										    login.driver.switchTo().window(tabs2.get(0));
										Thread.sleep(5000);
										login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_popup_close"))).click();
										Thread.sleep(3000);
										delete_series();
						   }
						   catch(org.openqa.selenium.StaleElementReferenceException ex)
						   {
							   Actions action = new Actions(login.driver);
								WebElement chartlegend = login.driver.findElement(By.xpath("//*[contains(text(),'Source: CEIC Data')][1]"));
										action.moveToElement(chartlegend).build().perform();				
										Thread.sleep(3000);
										 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_table_mode_Source"))).click();
										   ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
										    login.driver.switchTo().window(tabs2.get(1));
											Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_page"))).isDisplayed());
											 login.driver.close();
											    login.driver.switchTo().window(tabs2.get(0));
											Thread.sleep(5000);
											login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_popup_close"))).click();
											Thread.sleep(3000);
											delete_series();
						   }
	   }

	   
	   //TC_MS_57
	   @And("^Verify the Preview Close icon$")
	   public void verify_the_Preview_Close_icon() throws Throwable {
		   Thread.sleep(3000);
		   Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_popup_close"))).isDisplayed());
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_popup_close"))).click();
			Thread.sleep(3000);
			delete_series();
	   }
	   
	   
	   //TC_MS_56
	   @And("^Add some series$")
	   public void add_some_series() throws Throwable {
		   select_some_series_to_my_series_tab() ;
	   }
	   //TC_MS_56
	   @And("^Verify the Preview refresh icon$")
	   public void verify_the_Preview_refresh_icon() throws Throwable {
		   Thread.sleep(3000);
		   select_all_series();
		   select_the_preview_option();
		   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_refresh"))).click();
		   Thread.sleep(3000);
		   List<WebElement> serieslist = login.driver.findElements(By.xpath("//span[@class='series-edit--title']"));
			System.out.println("Total Series are : " + serieslist.size());
			int serieslist_count = serieslist.size();
			if(serieslist_count > 1){
				System.out.println("Verified Preview refresh icon");
			}else{
				Assert.fail("Preview refresh icon is NOT verified ");
			
			}
	   }
	   
	   
	   
	   
	/*@And("^To right panel$")
	public void to_right_panel() throws Throwable {
		Thread.sleep(8000);

		Actions action = new Actions(login.driver);
		WebElement we = login.driver.findElement(By.xpath("//div[@class='name-block two-rows-item ']"));
		action.moveToElement(we).build().perform();
		Thread.sleep(8000);

		Seriesnameforpreview = login.driver.findElement(By.xpath("//span[@class='series-name-field--series-name']"))
				.getText();
		System.out.println(Seriesnameforpreview);
		Thread.sleep(6000);
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		Thread.sleep(6000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[5]")).click();

	}

	@And("^Verify for \"([^\"]*)\" in \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void verify_for_in(String arg1, String arg2, String arg3, String arg4) throws Throwable {
		Thread.sleep(6000);
		if (arg2.equalsIgnoreCase(arg2)) {
			Thread.sleep(6000);
			login.driver.findElement(By.xpath("//div[@class='series-preview-header']/div[2]/div/label[1]")).click();

			
			 * Actions action = new Actions(login.driver); WebElement we =
			 * login.driver.findElement(By.xpath(
			 * "//span[@class='series-edit--title']"));
			 * action.moveToElement(we).build().perform();
			 

			Thread.sleep(6000);
			String Text1 = login.driver.findElement(By.xpath("//span[@class='series-edit--title']")).getText();

			System.out.println(Text1);

			System.out.println(Text1 + ":" + Seriesnameforpreview);
			if (Text1.equalsIgnoreCase(Seriesnameforpreview)) {

				System.out.println("Preview Series functionality in Chart is Working Successfully");
			} else {
				Assert.fail("Preview Series functionality in Chart is NOT Working Successfully");
			}
		}
		if (arg3.equalsIgnoreCase(arg3)) {
			Thread.sleep(6000);
			login.driver.findElement(By.xpath("//div[@class='series-preview-header']/div[2]/div/label[2]")).click();
			
			 * Actions action = new Actions(login.driver); WebElement we =
			 * login.driver.findElement(By.xpath(
			 * "//span[@class='series-edit--title']"));
			 * action.moveToElement(we).build().perform();
			 
			Thread.sleep(6000);
			String Text2 = login.driver.findElement(By.xpath("//span[@class='series-edit--title']")).getText();

			System.out.println(Text2);

			System.out.println(Text2 + ":" + Seriesnameforpreview);
			if (Text2.equalsIgnoreCase(Seriesnameforpreview)) {

				System.out.println("Preview Series functionality in Table is Working Successfully");
			} else {
				Assert.fail("Preview Series functionality in Table is NOT Working Successfully");
			}
		}
		if (arg4.equalsIgnoreCase(arg4)) {
			Thread.sleep(6000);
			login.driver.findElement(By.xpath("//div[@class='series-preview-header']/div[2]/div/label[3]")).click();

			
			 * Actions action = new Actions(login.driver); WebElement we =
			 * login.driver.findElement(By.xpath(
			 * "//span[@class='series-edit--title']"));
			 * action.moveToElement(we).build().perform();
			 

			Thread.sleep(6000);
			String Text3 = login.driver.findElement(By.xpath("//span[@class='series-edit--title']")).getText();

			System.out.println(Text3);

			System.out.println(Text3 + ":" + Seriesnameforpreview);
			if (Text3.equalsIgnoreCase(Seriesnameforpreview)) {

				System.out.println("Preview Series functionality in Statistics is Working Successfully");
			} else {
				Assert.fail("Preview Series functionality in Statistics is NOT Working Successfully");
			}
		}
		Thread.sleep(6000);
		login.driver.findElement(By.xpath("//div[@class='series-preview-close']")).click();
		Thread.sleep(6000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click();
	}*/
	  //TC_MS_59
	@And("^Select (\\d+) series to my series tab$")
	public void select_series_to_my_series_tab(int arg1) throws Throwable {
		Thread.sleep(5000);
		login.driver.navigate().refresh();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();

		JavascriptExecutor jse = (JavascriptExecutor) login.driver;
		ulelement = login.driver.findElement(By.xpath("//ul[@class='search-series-list']"));

		List<WebElement> objLinks = ulelement.findElements(By.tagName("li"));

		System.out.println("Total Size are- " + objLinks.size());
		Thread.sleep(2000);
		for (int i = 0; i <= 19; i++) {
			Thread.sleep(2000);
			int j = i + 1;
			login.driver.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"))
					.click();

			element = login.driver.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
		}
		Robot r = new Robot();
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='search-input--move-top-title']")).click();

	}
	 //TC_MS_59
	@And("^Verify for \"([^\"]*)\" Maximum series for 'Preview option'$")
	public void verify_for_Maximum_series_for_Preview_option(String arg1) throws Throwable {
		Thread.sleep(8000);
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		Thread.sleep(8000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[5]")).click();
		Thread.sleep(8000);
		if (login.driver.findElements(By.xpath("//div[@class='series-preview-title']")).size() != 0) {
			System.out.println("Preview option is working fine !!! ");
		} else {
			Assert.fail("Preview option is NOT working fine"); // div[@class='header-menu-help__link'][3]
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_popup_close"))).click();
		Thread.sleep(3000);
		delete_series();

	}
	  //TC_MS_59
	@And("^Select \"([^\"]*)\" series to my series tab$")
	public void select_series_to_my_series_tab(String arg1) throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();

		JavascriptExecutor jse = (JavascriptExecutor) login.driver;
		ulelement = login.driver.findElement(By.xpath("//ul[@class='search-series-list']"));

		// System.out.println("Total Size are- " + element.getSize());

		List<WebElement> objLinks = ulelement.findElements(By.tagName("li"));

		System.out.println("Total Size are- " + objLinks.size());
		Thread.sleep(2000);

		for (int i = 0; i <= 20; i++) {
			Thread.sleep(2000);
			int j = i + 1;
			login.driver.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"))
					.click();

			element = login.driver.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
		}
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
	}
	  //TC_MS_58
	@And("^Verify 'Preview option' is disable for \"([^\"]*)\" series$")
	public void verify_Preview_option_is_disable_for_series(String arg1) throws Throwable {
		Thread.sleep(8000);
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();

		if (login.driver
				.findElements(By
						.xpath("//div[@title='Preview. View selected series as a chart and as a table and see series statistics.']"))
				.size() != 0) {
			System.out.println("Preview option is working fine for More than 20 Series!!! ");
		} else {
			Assert.fail("Preview option is NOT working fine for More than 20 Series!!!");
		}

		
		Thread.sleep(3000);
		delete_series();

	}

	/*@And("^Select preview option$")
	public void select_preview_option() throws Throwable {
		Thread.sleep(8000);
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		Thread.sleep(8000);
		login.driver.findElement(By.xpath("//div[@class='webix_column list-series-name webix_last']/div[1]/div/span"))
				.click();
		Thread.sleep(8000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[5]")).click();
		Thread.sleep(8000);
		login.driver.findElement(By.xpath("//div[@class='webix_column list-series-name webix_last']/div[1]/div/span"))
				.click();

	}*/
	//TC_MS_60
	@And("^Verify Validation message for more than (\\d+) series added to preview window\\.$")
	public void verify_Validation_message_for_more_than_series_added_to_preview_window(int arg1) throws Throwable {

		Thread.sleep(4000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_refresh"))).click();
		Thread.sleep(4000);
		if (login.driver.findElements(By.xpath("//div[@class='growl-message-text']")).size() != 0) {
			System.out.println("Validation message Verified Successfully!!! ");
		} else {
			Assert.fail("Validation message is NOT Verified Successfully!!!");
		}
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preview_popup_close"))).click();
		Thread.sleep(3000);
		delete_series();

	}

	/*@And("^Select the select all option$")
	public void select_the_select_all_option() throws Throwable {
		Thread.sleep(8000);
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		Thread.sleep(8000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[9]/div[2]"))
				.click();
		Thread.sleep(8000);
		login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu ']/div[3]/li[1]")).click();

	}

	@And("^Verify \"([^\"]*)\" option functionality\\.$")
	public void verify_option_functionality(String arg1) throws Throwable {
		Thread.sleep(8000);
		String Count1 = login.driver.findElement(By.xpath("//span[@class='series-panel--count']/span[1]/span[1]"))
				.getText();
		Thread.sleep(8000);
		String Count2 = login.driver.findElement(By.xpath("//span[@class='series-panel--count']/span[3]/span[2]"))
				.getText();
		System.out.println(Count1 + ":" + Count2);
		if (Count1.equalsIgnoreCase(Count2)) {

			System.out.println("Select all Functionality is working Successfully");
		} else {
			Assert.fail("Select all Functionality is NOT working Successfully:-(");
		}
		Thread.sleep(8000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click();
	}

	@And("^Select the Unselect all option$")
	public void select_the_Unselect_all_option() throws Throwable {
		Thread.sleep(8000);
		Thread.sleep(8000);
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		
		 * select_the_select_all_option(); Thread.sleep(8000);
		 
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[9]/div[2]"))
				.click();
		Thread.sleep(8000);
		login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu ']/div[3]/li[2]")).click();
	}

	@And("^Verify UnSelect all option functionality\\.$")
	public void verify_UnSelect_all_option_functionality() throws Throwable {
		Thread.sleep(8000);

		boolean deletebtn = login.driver.findElement(By.xpath("//span[@class='input-control--indicator']"))
				.isSelected();
		System.out.print(deletebtn);
		if (deletebtn == false) {
			System.out.println("UnSelect all option functionality is working Successfully");
		} else {
			Assert.fail("UnSelect all option functionality is NOT working Successfully :-(");
		}
	}

	@And("^Verify Clear All option for \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" functionality\\.$")
	public void verify_Clear_All_option_for_functionality(String arg1, String arg2, String arg3) throws Throwable {
		Thread.sleep(5000);

		if (arg2.equalsIgnoreCase(arg2)) {
			Thread.sleep(8000);
			String Countbeforeclear = login.driver
					.findElement(By.xpath("//span[@class='series-panel--count']/span[1]/span[1]")).getText();
			Thread.sleep(5000);
			login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[9]/div[2]"))
					.click();
			Thread.sleep(8000);
			login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu ']/div[3]/li[3]")).click();
			Thread.sleep(8000);
			login.driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();
			String Countafterclear = login.driver
					.findElement(By.xpath("//span[@class='series-panel--count']/span[1]/span[1]")).getText();
			System.out.println(Countbeforeclear + ":" + Countafterclear);
			if (Countbeforeclear.equalsIgnoreCase(Countafterclear)) {

				System.out.println("Clear all Functionality  for Cancel is working Successfully");
			} else {
				Assert.fail("Clear all Functionality  for Cancel is Not working Successfully:-(");
			}
		}

		if (arg3.equalsIgnoreCase(arg3)) {
			Thread.sleep(8000);
			String Countbeoreclear = login.driver
					.findElement(By.xpath("//span[@class='series-panel--count']/span[1]/span[1]")).getText();
			Thread.sleep(5000);
			login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[9]/div[2]"))
					.click();
			Thread.sleep(8000);
			login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu ']/div[3]/li[3]")).click();
			Thread.sleep(8000);
			login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			String Countafterclear = login.driver
					.findElement(By.xpath("//span[@class='series-panel--count']/span[1]/span[1]")).getText();
			System.out.println(Countbeoreclear + ":" + Countafterclear);
			if (Countbeoreclear.equalsIgnoreCase(Countafterclear)) {

				System.out.println("Clear all Functionality  for Dismiss is working Successfully");
			} else {
				Assert.fail("Clear all Functionality  for Dismiss is Not working Successfully:-(");
			}
		}
		if (arg1.equalsIgnoreCase(arg1)) {
			Thread.sleep(8000);
			String Countbeoreclear = login.driver
					.findElement(By.xpath("//span[@class='series-panel--count']/span[1]/span[1]")).getText();
			Thread.sleep(5000);
			login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[9]/div[2]"))
					.click();
			Thread.sleep(8000);
			login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu ']/div[3]/li[3]")).click();
			Thread.sleep(8000);
			login.driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
			Thread.sleep(5000);
			if (login.driver
					.findElements(
							By.xpath("//div[@class='insight-action-panel--btn insight-action-panel--btn__disabled'] "))
					.size() != 0) {
				System.out.println("Clear all Functionality  for Ok is working Successfully");
			} else {
				Assert.fail("Clear all Functionality  for Ok is Not working Successfully:-(");
			}
		}
	}*/
	
	//TC_MS_72
	@And("^Select the Delete option$")
	public void select_the_Delete_option() throws Throwable {
		Thread.sleep(8000);
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		Thread.sleep(8000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[7]")).click();
	}
	//TC_MS_72
	@And("^Verify Delete option functionality for Series$")
	public void verify_Delete_option_functionality_for_Series() throws Throwable {
		Thread.sleep(5000);
       String delete = login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[7]")).getAttribute("class");
		System.out.println(delete);
		if(delete.contains("disabled"))
				{
			System.out.println("Delete Functionality having Series is working Successfully");
		} else {
			Assert.fail("Delete Functionality having Series is Not working Successfully:-(");
		}
	}
	//TC_MS_74
	@And("^Create visuals as Chart$")
	public void create_visuals_as_Chart() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//ul[@class='search-series-list']/li[1]/div/a/div[2]")).click();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_C);

	}
	//TC_MS_74
	@And("^Verify Delete option functionality having pop head title$")
		public void verify_Delete_option_functionality_having_pop_head_title() throws Throwable {
			Thread.sleep(3000);
			String Insisepopup = login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']"))
					.getText();
			if (Insisepopup.contains(
					"The series are associated with visuals within the current insight and deleting them will affect the visuals. Are you sure you want to delete?")) {
				System.out.println("Mesage in Delete dialog window is  verified Successfully");
			} else {
				Assert.fail("Mesage in Delete dialog window is NOT verified Successfully:-(");
			}
			login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			delete_visual();
		}
		
	//TC_MS_74
	@And("^Select to myseries button and select the delete option$")
	public void select_to_myseries_button_and_select_the_delete_option() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='insight-page-menu']/div[2]")).click();
		select_the_Delete_option();
	}
	//TC_MS_75
	@And("^Verify Delete option functionality having ok button$")
	public void verify_Delete_option_functionality_having_ok_button() throws Throwable {
		Thread.sleep(3000);
		Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Delete_ok_button"))).isDisplayed());
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Delete_ok_button"))).click();
		Thread.sleep(5000);
		Thread.sleep(5000);
	       String delete = login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[7]")).getAttribute("class");
			System.out.println(delete);
			if(delete.contains("disabled"))
					{
				System.out.println("Delete ok Functionality  is working Successfully");
			} else {
				Assert.fail("Delete ok Functionality is Not working Successfully:-(");
			}
			delete_visual();
	}

	@And("^Verify Delete option functionality having \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" for Visuals$")
	public void verify_Delete_option_functionality_having_for_Visuals(String arg1, String arg2, String arg3,
			String arg4, String arg5) throws Throwable {
		Thread.sleep(5000);
		if (arg1.equalsIgnoreCase(arg1)) {
			if (login.driver.findElements(By.xpath("//h4[contains(text(),'Delete series')]")).size() != 0) {
				System.out.println("Delete Series pop up window appeared Successfully");
			} else {
				Assert.fail("Delete Series pop up window Does Not appeared Successfully:-(");
			}
			login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();

		}
		if (arg2.equalsIgnoreCase(arg2)) {

			Thread.sleep(8000);
			login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click();
			String Insisepopup = login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']"))
					.getText();

			if (Insisepopup.contains(
					"The series are associated with visuals within the current insight and deleting them will affect the visuals. Are you sure you want to delete?")) {
				System.out.println("Mesage in Delete dialog window is  verified Successfully");
			} else {
				Assert.fail("Mesage in Delete dialog window is NOT verified Successfully:-(");
			}
			login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		}
		if (arg3.equalsIgnoreCase(arg3)) {
			Thread.sleep(8000);
			String CountbeforeDelete = login.driver
					.findElement(By.xpath("//span[@class='series-panel--count']/span[1]/span[1]")).getText();
			login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();
			String CountafterDelete = login.driver
					.findElement(By.xpath("//span[@class='series-panel--count']/span[1]/span[1]")).getText();
			System.out.println(CountbeforeDelete + ":" + CountafterDelete);
			if (CountbeforeDelete.equalsIgnoreCase(CountafterDelete)) {

				System.out.println("Delete Functionality  for Cancel is working Successfully");
			} else {
				Assert.fail("Delete Functionality  for Cancel is Not working Successfully:-(");
			}
		}
		if (arg4.equalsIgnoreCase(arg4)) {
			Thread.sleep(8000);
			String CountbeforeDelete = login.driver
					.findElement(By.xpath("//span[@class='series-panel--count']/span[1]/span[1]")).getText();
			login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			String CountafterDelete = login.driver
					.findElement(By.xpath("//span[@class='series-panel--count']/span[1]/span[1]")).getText();
			System.out.println(CountbeforeDelete + ":" + CountafterDelete);
			if (CountbeforeDelete.equalsIgnoreCase(CountafterDelete)) {

				System.out.println("Delete Functionality  for Dismiss is working Successfully");
			} else {
				Assert.fail("Delete Functionality  for Dismiss is Not working Successfully:-(");
			}
		}
		if (arg4.equalsIgnoreCase(arg4)) {

			Thread.sleep(5000);
			login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click();
			Thread.sleep(8000);
			login.driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
			Thread.sleep(5000);
			if (login.driver
					.findElements(
							By.xpath("//div[@class='insight-action-panel--btn insight-action-panel--btn__disabled'] "))
					.size() != 0) {
				System.out.println("Delete Functionality for Ok is working Successfully");
			} else {
				Assert.fail("Delete Functionality for Ok is Not working Successfully:-(");
			}
		}
	}

	@Given("^Select the grouping function$")
	public void select_the_grouping_function() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[10]/div[2]"))
				.click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu ']/div[3]/li[1]/span")).click();
		Thread.sleep(5000);
		login.driver
				.findElement(
						By.xpath("//div[@class='insight-series-rename--button insight-series-rename--button__cancel']"))
				.click();

	}

	@Given("^Verify \"([^\"]*)\" functionality for Series$")
	public void verify_functionality_for_Series(String arg1) throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[10]/div[2]"))
				.click();
		Thread.sleep(5000);
		if (login.driver.findElements(By.xpath("//span[@class='context-menu-item link disabled']")).size() != 0) {
			System.out.println("Grouping Functionality  is working Successfully");
		} else {
			Assert.fail("Grouping Functionality is Not working Successfully:-(");
		}
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[10]/div[2]"))
				.click();
		Thread.sleep(5000);
		String GroupVerification = "Group";
		String Text = login.driver.findElement(By.xpath("//span[@class='group-name']")).getText();
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

	@Given("^Select the Group Rename option$")
	public void select_the_Group_Rename_option() throws Throwable {
		Thread.sleep(5000);
		Actions action = new Actions(login.driver);
		WebElement we = login.driver.findElement(By.xpath("//span[@class='group-name']"));
		action.moveToElement(we).build().perform();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//span[@class='series-item--icon series-item--icon__edit']")).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//span[@class='context-menu-item link']")).click();

	}

	@Given("^Verify \"([^\"]*)\" Rename functionality for Series$")
	public void verify_Rename_functionality_for_Series(String arg1) throws Throwable {
		Thread.sleep(5000);
		if (login.driver.findElements(By.xpath("//div[@class='popover-content']/div")).size() != 0) {
			System.out.println("Grouping Rename pop up appeared Successfully");
		} else {
			Assert.fail("Grouping Rename pop up Does not appeared Successfully:-(");
		}
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='popover-content']/div/input")).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='popover-content']/div/input")).clear();
		Thread.sleep(5000);
		String GroupingRenamed = "GroupingRenamed";
		login.driver.findElement(By.xpath("//div[@class='popover-content']/div/input")).sendKeys(GroupingRenamed);
		Thread.sleep(5000);
		login.driver
				.findElement(
						By.xpath("//div[@class='insight-series-rename--button insight-series-rename--button__apply']"))
				.click();
		Thread.sleep(5000);
		String Text = login.driver.findElement(By.xpath("//span[@class='group-name']")).getText();
		System.out.println(GroupingRenamed + ":" + Text);
		if (GroupingRenamed.equalsIgnoreCase(Text)) {

			System.out.println("Grouping Renamed Functionality  is working Successfully");
		} else {
			Assert.fail("Grouping Renamed Functionality is Not working Successfully:-(");
		}
	}

	@Given("^Select the UnGroup option$")
	public void select_the_UnGroup_option() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[10]/div[2]"))
				.click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu ']/div[3]/li[2]/span")).click();
	}

	@Given("^Verify UnGroup functionality for Series$")
	public void verify_UnGroup_functionality_for_Series() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[10]/div[2]"))
				.click();
		Thread.sleep(5000);
		if (login.driver.findElements(By.xpath("//span[@class='context-menu-item link disabled']")).size() != 0) {
			System.out.println("UnGrouping Functionality  is working Successfully");
		} else {
			Assert.fail("UnGrouping Functionality is Not working Successfully:-(");
		}
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[10]/div[2]"))
				.click();
	}

	@Given("^Verify UnGroup functionality disabled status when their is no Group$")
	public void verify_UnGroup_functionality_disabled_status_when_their_is_no_Group() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[10]/div[2]"))
				.click();
		Thread.sleep(5000);
		if (login.driver.findElements(By.xpath("//span[@class='context-menu-item link disabled']")).size() != 0) {
			System.out.println("UnGrouping Functionality  is in disabled status when their is no Group");
		} else {
			Assert.fail("UnGrouping Functionality  is NOT in disabled status when their is no Group:-(");
		}
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[10]/div[2]"))
				.click();

	}

	@Given("^Select the Seperator option$")
	public void select_the_Seperator_option() throws Throwable {
		select_some_series_to_my_series_tab();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[10]/div[2]"))
				.click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu ']/div[3]/li[3]/span")).click();

	}

	@Given("^Verify Seperator functionality for Series$")
	public void verify_Seperator_functionality_for_Series() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='series-name-wrapper separator-row ']/span[1] ")).click();

		Thread.sleep(5000);

		if (login.driver
				.findElements(By
						.xpath("//div[@class='download-button download-button__header download-button__algae download-button__disabled download-button__unavailable']"))
				.size() != 0) {
			System.out.println("Seperate functionality is working Successfully");
		} else {
			Assert.fail("Seperate  functionality is NOT working Successfully :-(");
		}
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click();
	}

	@Given("^Select Cut option$")
	public void select_Cut_option() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[14]")).click();
	}

	@Given("^verify the Cut option$")
	public void verify_the_Cut_option() throws Throwable {
		Thread.sleep(1000);
		if (login.driver.findElements(By.xpath("//div[@class='growl-message-text']")).size() != 0) {
			System.out.println("Validation message Verified Successfully for Cut Option!!! ");
		} else {
			Assert.fail("Validation message is NOT Verified Successfully for Cut Option!!!");
		}
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		Thread.sleep(4000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click();
	}

	@Given("^Select Copy option$")
	public void select_Copy_option() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[15]")).click();
	}

	@Given("^verify the Copy option$")
	public void verify_the_Copy_option() throws Throwable {
		Thread.sleep(1000);
		if (login.driver.findElements(By.xpath("//div[@class='growl-message-text']")).size() != 0) {
			System.out.println("Validation message Verified Successfully for Copy Option!!! ");
		} else {
			Assert.fail("Validation message is NOT Verified Successfully for Copy Option!!!");
		}
	}

	@Given("^Select Paste option$")
	public void select_Paste_option() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[16]")).click();
	}

	@Given("^verify the Paste option$")
	public void verify_the_Paste_option() throws Throwable {
		Thread.sleep(1000);
		if (login.driver.findElements(By.xpath("//div[@class='growl-message-text']")).size() != 0) {
			System.out.println("Validation message Verified Successfully for Paste Option!!! ");
		} else {
			Assert.fail("Validation message is NOT Verified Successfully for Paste Option!!!");
		}
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click();
	}

	@Given("^Select Currency Conversion$")
	public void select_Currency_Conversion() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		Thread.sleep(3000);
		login.driver
				.findElement(
						By.xpath("//div[@class='data-action-panel insight-action-panel']/div[19]/div[1]/div[1]/div[3]"))
				.click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//div[@class='items-wrapper']/li[1]")).click();
	}

	@Given("^verify the Currency Conversion is applied for a series$")
	public void verify_the_Currency_Conversion_is_applied_for_a_series() throws Throwable {
		Thread.sleep(3000);
		String Functionappliedintoolbar = login.driver
				.findElement(By.xpath("//span[@class='series-function-item--body']/span[1]")).getText();

		Thread.sleep(3000);
		String Functiondescriptioninseries = login.driver
				.findElement(By.xpath("//span[@class='series-name-field-title']/span[2]")).getText();
		String s1 = Functiondescriptioninseries.substring(1, 11);
		System.out.println(Functionappliedintoolbar + ":" + s1);

		if (Functionappliedintoolbar.equalsIgnoreCase(s1)) {

			System.out.println("Currency Conversion is applied Successfully");
		} else {
			Assert.fail("Currency Conversion functionality is Not working Successfully:-(");
		}
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click();
	}

	@Given("^Select Calculate Change$")
	public void select_Calculate_Change() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		Thread.sleep(3000);
		login.driver
				.findElement(
						By.xpath("//div[@class='data-action-panel insight-action-panel']/div[19]/div[2]/div[1]/div[3]"))
				.click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//div[@class='items-wrapper']/li[1]")).click();
	}

	@Given("^verify the Calculate Change is applied for a series$")
	public void verify_the_Calculate_Change_is_applied_for_a_series() throws Throwable {
		Thread.sleep(3000);
		String Functionappliedintoolbar = login.driver
				.findElement(By.xpath("//span[@class='series-function-item--body']/span[1]")).getText();

		Thread.sleep(3000);
		String Functiondescriptioninseries = login.driver
				.findElement(By.xpath("//span[@class='series-name-field-title']/span[2]")).getText();
		String s1 = Functiondescriptioninseries.substring(1, 5);
		System.out.println(Functionappliedintoolbar + ":" + s1);

		if (Functionappliedintoolbar.equalsIgnoreCase(s1)) {

			System.out.println("Calculate Change is applied Successfully");
		} else {
			Assert.fail("Calculate Change functionality is Not working Successfully:-(");
		}
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click();
	}

	@Given("^Select Aggregate$")
	public void select_Aggregate() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		Thread.sleep(3000);
		login.driver
				.findElement(
						By.xpath("//div[@class='data-action-panel insight-action-panel']/div[19]/div[3]/div[1]/div[3]"))
				.click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//div[@class='items-wrapper']/li[1]")).click();
	}

	@Given("^verify the Aggregate is applied for a series$")
	public void verify_the_Aggregate_is_applied_for_a_series() throws Throwable {
		Thread.sleep(3000);
		String Functionappliedintoolbar = login.driver
				.findElement(By.xpath("//span[@class='series-function-item--body']/span[1]")).getText();

		Thread.sleep(3000);
		String Functiondescriptioninseries = login.driver
				.findElement(By.xpath("//span[@class='series-name-field-title']/span[2]")).getText();
		String s1 = Functiondescriptioninseries.substring(1, 10);
		System.out.println(Functionappliedintoolbar + ":" + s1);

		if (Functionappliedintoolbar.equalsIgnoreCase(s1)) {

			System.out.println("Aggregate is applied Successfully");
		} else {
			Assert.fail("Aggregate functionality is Not working Successfully:-(");
		}
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click();
	}

	@Given("^Select Accumulate$")
	public void select_Accumulate() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		Thread.sleep(3000);
		login.driver
				.findElement(
						By.xpath("//div[@class='data-action-panel insight-action-panel']/div[19]/div[4]/div[1]/div[3]"))
				.click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//div[@class='items-wrapper']/li[1]")).click();
	}

	@Given("^verify the Accumulate is applied for a series$")
	public void verify_the_Accumulate_is_applied_for_a_series() throws Throwable {
		Thread.sleep(3000);
		String Functionappliedintoolbar = login.driver
				.findElement(By.xpath("//span[@class='series-function-item--body']/span[1]")).getText();

		Thread.sleep(3000);
		String Functiondescriptioninseries = login.driver
				.findElement(By.xpath("//span[@class='series-name-field-title']/span[2]")).getText();
		String s1 = Functiondescriptioninseries.substring(1, 4);
		System.out.println(Functionappliedintoolbar + ":" + s1);

		if (Functionappliedintoolbar.equalsIgnoreCase(s1)) {

			System.out.println("Accumulate is applied Successfully");
		} else {
			Assert.fail("Accumulate functionality is Not working Successfully:-(");
		}
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click();
	}

	@Given("^Select FX drop down$")
	public void select_FX_drop_down() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		Thread.sleep(3000);
		login.driver
				.findElement(
						By.xpath("//div[@class='data-action-panel insight-action-panel']/div[19]/div[5]/div[1]/div[3]"))
				.click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//div[contains(text(),'YTD')]")).click();

	}

	@Given("^verify the Function applied in FX drop down$")
	public void verify_the_Function_applied_in_FX_drop_down() throws Throwable {
		Thread.sleep(3000);
		String Functionappliedintoolbar = login.driver
				.findElement(By.xpath("//span[@class='series-function-item--body']/span[1]")).getText();

		Thread.sleep(3000);
		String Functiondescriptioninseries = login.driver
				.findElement(By.xpath("//span[@class='series-name-field-title']/span[2]")).getText();
		String s1 = Functiondescriptioninseries.substring(1, 4);
		System.out.println(Functionappliedintoolbar + ":" + s1);

		if (Functionappliedintoolbar.equalsIgnoreCase(s1)) {

			System.out.println("Function applied in FX drop down is Successfully");
		} else {
			Assert.fail("Function applied in FX drop down is Not working Successfully:-(");
		}
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click();
	}

	@Given("^Select FX Icon$")
	public void select_FX_Icon() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		Thread.sleep(3000);
		login.driver
				.findElement(
						By.xpath("//div[@class='data-action-panel insight-action-panel']/div[19]/div[5]/div[1]/div[1]"))
				.click();

	}

	@Given("^verify the FX Icon$")
	public void verify_the_FX_Icon() throws Throwable {

		if (login.driver.findElements(By.xpath("//div[@class='movable-modal--title ui-draggable-handle']"))
				.size() != 0) {
			System.out.println("FX Icon is Verified Successfully!!! ");
		} else {
			Assert.fail("FX Icon is NOT Verified Successfully!!!");
		}
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//div[@class='movable-modal--close']")).click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click();
	}

	@Given("^Select Type a function field$")
	public void select_Type_a_function_field() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//div[@class='current-function-input--body']/input")).click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//ul[@class='suggestions_list select-list']/li[1]")).click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//ul[@class='suggestions_list select-list']/li[1]")).click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//ul[@class='suggestions_list select-list']/li[1]")).click();
		Thread.sleep(3000);
		login.driver
				.findElement(
						By.xpath("//div[@class='series-functions-panel--icon series-functions-panel--icon__apply']"))
				.click();

	}

	@Given("^verify Type a function field$")
	public void verify_Type_a_function_field() throws Throwable {
		Thread.sleep(3000);
		String Functionappliedintoolbar = login.driver
				.findElement(By.xpath("//span[@class='series-function-item--body']/span[1]")).getText();

		Thread.sleep(3000);
		String Functiondescriptioninseries = login.driver
				.findElement(By.xpath("//span[@class='series-name-field-title']/span[2]")).getText();
		String s1 = Functiondescriptioninseries.substring(1, 11);
		System.out.println(Functionappliedintoolbar + ":" + s1);

		if (Functionappliedintoolbar.equalsIgnoreCase(s1)) {

			System.out.println("Type a function field is working Successfully");
		} else {
			Assert.fail("Type a function field is Not working Successfully:-(");
		}
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click();
	}

	@Given("^Select Checkbox field$")
	public void select_Checkbox_field() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
	}

	@Given("^verify Checkbox for select all Series$")
	public void verify_Checkbox_for_select_all_Series() throws Throwable {
		Thread.sleep(8000);
		String Countbeforechecked = login.driver
				.findElement(By.xpath("//span[@class='series-panel--count']/span[1]/span[1]")).getText();
		Thread.sleep(8000);
		String Countafterchecked = login.driver
				.findElement(By.xpath("//span[@class='series-panel--count']/span[3]/span[2]")).getText();
		System.out.println(Countbeforechecked + ":" + Countafterchecked);

		if (Countbeforechecked.equalsIgnoreCase(Countafterchecked)) {

			System.out.println("Checkbox for select all Series is working Successfully");
			HTML_Report.strTCResult = "PASS";
			HTML_Report.execRemarks = "Checkbox for select all Series is working Successfully ";
		} else {
			Assert.fail("Checkbox for select all Series is Not working Successfully:-(");
			HTML_Report.strTCResult = "FAIL";
			HTML_Report.execRemarks = "Checkbox for select all Series is Not working Successfully:-(";

		}
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click();
	}

	@Given("^UnSelect Checkbox field$")
	public void unselect_Checkbox_field() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
	}

	@Given("^verify Checkbox for Unselect all Series$")
	public void verify_Checkbox_for_Unselect_all_Series() throws Throwable {

		if (login.driver
				.findElements(By
						.xpath("//div[@class='insight-action-panel--btn insight-action-panel--btn__disabled']/div[2]"))
				.size() != 0) {
			System.out.println("Checkbox for Unselect all Series is Verified Successfully !!! ");
		} else {
			Assert.fail("Checkbox for Unselect all Series is NOT Verified Successfully!!!");
		}
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click();
	}

	@Given("^Select any five series to my series tab$")
	public void select_any_five_series_to_my_series_tab() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
		// List<WebElement> objLinks =
		// login.driver.findElements(By.xpath("//a[@class='series-list-item--container
		// internal-series series-list-item--container__with_actions']"));
		// System.out.println("Total Size are- " + objLinks.size());

		for (int i = 1; i <= 5; i++) {
			Thread.sleep(2000);
			login.driver
					.findElement(By.xpath("//ul[@class='search-series-list scrollable']/li[" + i + "]/div/a/div[2]"))
					.click();
		}
		Thread.sleep(6000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
	}

	@Given("^Search with series name or with series attribute$")
	public void search_with_series_name_or_with_series_attribute() throws Throwable {

		Thread.sleep(3000);
		Actions action = new Actions(login.driver);
		WebElement we = login.driver.findElement(By.xpath("//div[@class='webix_ss_center']/div/div[1]/div[1]/div"));
		action.moveToElement(we).build().perform();
		login.driver.findElement(By.xpath("//div[@class='webix_ss_center']/div/div[1]/div[1]/div")).click();
		Thread.sleep(3000);
		Searchinserieslistfilter = login.driver.findElement(By.xpath("//span[@class='table-cell '] ")).getText();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//div[@class='movable-modal--close']")).click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//div[@class='insight-series-list-filter']/input"))
				.sendKeys(Searchinserieslistfilter);

	}

	@Given("^Verify the Searched field functionality$")
	public void verify_the_Searched_field_functionality() throws Throwable {
		try {
			List<WebElement> Totalseries = login.driver.findElements(By.xpath("//div[@class='series-name-field']"));
			System.out.println("Total Series are : " + Totalseries.size());

			for (int i = 0; i < Totalseries.size(); i++) {
				Actions action = new Actions(login.driver);
				WebElement we = login.driver.findElement(By.xpath("//div[@class='name-block two-rows-item ']"));
				action.moveToElement(we).build().perform();

				String Text;
				Text = we.getAttribute("title");
				System.out.println(Text);
				String[] array = Text.split("\n");
				int size = array.length;
				System.out.println(size);
				System.out.println("Name of the Series = :- " + array[1]);
				String NameofSeries = array[1];
				String[] result = NameofSeries.split(" ", 2);
				// String first = result[0];
				String instatistics = result[1];
				// System.out.println("First Expected String : " + first);
				System.out.println("Expected String : " + instatistics);
				Thread.sleep(3000);
				if (Searchinserieslistfilter.equalsIgnoreCase(instatistics)) {

					System.out.println("Searched field functionality is working Successfully");

				} else {
					Assert.fail("Searched field functionality is Not working Successfully:-(");
				}
			}
			login.driver.findElement(By.xpath("//div[@class='insight-series-list-filter']/input")).clear();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
			Thread.sleep(5000);
			login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click();
		} catch (Exception e) {

		}
	}

	@Given("^Verify the series count under My series$")
	public void verify_the_series_count_under_My_series() throws Throwable {
		Thread.sleep(3000);
		List<WebElement> Totalseries = login.driver.findElements(By.xpath("//div[@class='series-name-field']"));
		System.out.println("Total Series are : " + Totalseries.size());
		int X = Totalseries.size();
		Thread.sleep(3000);
		String seriescount = login.driver.findElement(By.xpath("//span[@class='series-panel--count']/span[1]/span[1]"))
				.getText();
		int Y = Integer.parseInt(seriescount);
		System.out.println(X + ":" + Y);
		if (X == Y) {

			System.out.println("Searched field functionality is working Successfully");
			HTML_Report.strTCResult = "PASS";
			HTML_Report.execRemarks = "Searched field functionality is working Successfully ";

		} else {
			Assert.fail("Searched field functionality is Not working Successfully:-(");
			HTML_Report.strTCResult = "FAIL";
			HTML_Report.execRemarks = "Searched field functionality is Not working Successfully:-(";
		}

	}

	@Given("^Verify the Selected series count under My series$")
	public void verify_the_Selected_series_count_under_My_series() throws Throwable {
		verify_Checkbox_for_select_all_Series();
	}

	@Given("^Verify the Selected series in List Mode$")
	public void verify_the_Selected_series_in_List_Mode() throws Throwable {
		Thread.sleep(8000);
		Actions action = new Actions(login.driver);
		WebElement we = login.driver
				.findElement(By.xpath("//div[@class='webix_ss_body']/div[2]/div/div[2]/div[1]/div/div[2]/div[2]"));
		action.moveToElement(we).build().perform();

		if (login.driver
				.findElements(By.xpath("//div[@class='webix_ss_body']/div[2]/div/div[2]/div[1]/div/div[2]/div[2]"))
				.size() != 0) {
			System.out.println("series in List Mode is Verified Successfully!!! ");
			HTML_Report.strTCResult = "PASS";
			HTML_Report.execRemarks = "series in List Mode is Verified Successfully!!! ";
		} else {
			HTML_Report.strTCResult = "FAIL";
			HTML_Report.execRemarks = "series in List Mode is NOT Verified Successfully!!!";
			Assert.fail("series in List Mode is NOT Verified Successfully!!!");
		}
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click();
	}
	
	public static void  delete_series() throws InterruptedException{	
		boolean checkbox=login.driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected();
		if(checkbox==true)
		{
			login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[7]")).click();
		}else
		{
		login.driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[7]")).click();
		}
		
}
	public static void  delete_visual() throws InterruptedException{	
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("View_Tab"))).click();
		Thread.sleep(3000);
		Actions action = new Actions(login.driver);
		WebElement ele = login.driver.findElement(By.xpath(
				"//div[@class='insight-page-menu-views-container--view-tabs ui-sortable']//a[@class='insight-page-view-tab--link insight-page-view-tab--link__active']"));
		action.contextClick(ele).build().perform();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Delete all view')]")).click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
		
}
}
