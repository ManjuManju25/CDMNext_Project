package CDMNext.StepDefinations;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import Javaxlxs.Last_file_download;
import Javaxlxs.File_delete;
import Javaxlxs.Last_file_download;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Exceldatacompare {
	
	private static Boolean logged = false;
	public static String testcase_num;
	public static String format;
	WebElement element;
	//boolean isChecked;
	private String isChecked; 
	private WebElement e; 
	
	/*@And("^User has successful logged in$")
	public void user_has_successful_logged_in() throws Throwable {
		if (login.logged_in = false) {
			login.Invoke_browser();
			login.application_login();
		} 
		else if (login.logged_in = true && !Exceldatacompare.logged) {
			login.application_login();
			Exceldatacompare.logged = true;
		} else {
			System.out.println("Already Loggedin...Continue....!!!!");
		}
        
		// login.Invoke_browser();
		// login.application_login();
	}*/
	

	@And("^User Select Series ID  as \"([^\"]*)\"$")
	public void user_Select_Series_ID_as(String arg2) throws Throwable {
		Thread.sleep(2000);
		user_Refresh_the_page();
		Thread.sleep(6000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).clear();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(arg2);
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='add-to-data-selection--icon']")).click();
	}
	
	@And("^User  Download button$")
	public void user_Download_button() throws Throwable {
		Thread.sleep(6000);
		login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[1]/div[3]/div[2]/button")).click();
		Thread.sleep(5000);
		user_Select_Reset_button();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='download-fast-settings--section-content download-fast-settings--section-content__checkbox']/label/span[1]")).click();
	}
	
	@And("^Select Download button$")
	public void select_Download_button() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//span[@class='download-button--text']")).click();
		Thread.sleep(4000);
		user_Select_Reset_button();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='download-fast-settings--section-content download-fast-settings--section-content__checkbox']/label/span[1]")).click();
	}
	
	@And("^User(\\d+) Select the \"([^\"]*)\"$")
	public void user_Select_the(int arg1, String arg2) throws Throwable {
		 testcase_num=arg2;
	    System.out.println("test case is " +testcase_num);
	}

	@And("^Select Automic button$")
	public void Select_Automic_button() throws Throwable {
		Thread.sleep(2500);
		login.driver.findElement(By.xpath("//div[@class='insight-download-advanced-settings']/div/div[5]/div[2]/a/span[2]/b")).click();
		Thread.sleep(2500);
		login.driver.findElement(By.xpath("//ul[@class='select2-results']/li[1]/div/div")).click();
	}
	
	@And("^User1 Select pop up Download button$")
	public void user_Select_pop_up_Download_button() throws Throwable {
		WebElement element = login.driver.findElement(By.xpath("//div[@class='sphere-modal-controls']/button[4]/span"));
		Actions action = new Actions(login.driver);
		Thread.sleep(5000);
		action.moveToElement(element).click().perform();                                   
	}

	@And("^User1 Compare exel sheet$")
	public void user_Compare_exel_sheet() throws Throwable {
		Thread.sleep(10000);
		System.out.println("Comparing Data in Two Exel Sheets");
		CompareExcel.Excel();
	}
	
	@And("^Compare \"([^\"]*)\" exel sheet with Actual data$")
	public void user_Compare_exel_sheet_with_Actual_data(String arg2) throws Throwable {
		try{
		user_Select_pop_up_Download_button();
		Thread.sleep(9000);
		testcase_num=arg2;
		System.out.println("Comparing Data of " + testcase_num +  " with Actual data");
		CompareExcel.Excel();
		Thread.sleep(5000);
		File_delete.delete();
		Thread.sleep(5000);
		user_signout();
		}catch(Exception E){
			System.out.println("Entered to catch" + E.getMessage());
		}
	}
  
	@And("^Select Custom button$")
	public void Select_Custom_button() throws Throwable {
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("//div[@class='insight-download-advanced-settings']/div/div[5]/div[2]/a/span[2]/b")).click();
		Thread.sleep(6000);
		login.driver.findElement(By.xpath("//ul[@class='select2-results']/li[2]/div/div")).click();
	}
	
	@And("^User signout$")
	public void user_signout() throws Throwable {
		
				
		Thread.sleep(500);
		if(login.driver.findElements(By.xpath("//span[@class='series-name-field-title']")).size() != 0){
			login.driver.findElement(By.xpath("//div[@class='insight-series-container']/div/div/div/div/label/span")).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click();
		}
	}
	
	@And("^User(\\d+) Select date format$")
	public void user_Select_date_format(int arg1) throws Throwable {
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("//div/i[@class='format-example__edit-icon']")).click();
		
	}

	@And("^Select format input	\"([^\"]*)\"$")
	public void Select_format_input(String formatinput) throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div/input[@class='format-input']")).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div/input[@class='format-input']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div/input[@class='format-input']")).sendKeys(formatinput);
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div[2]/div[2]/button[2]")).click();
	}
	@And("^User Select Decimal drop down$")
	public void user_Select_Decimal_drop_down() throws Throwable {
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("//div[@class='insight-download-advanced-settings']/div/div[6]/div[2]/a/span[2]/b")).click();
	}
	
	@And("^User Select Reset button$")
	public void user_Select_Reset_button() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//button[@class='sphere-modal-control insight-download__modal-button'][1]")).click();
	}

	
	@Given("^Select Decimal input as \"([^\"]*)\"$")
	public void select_Decimal_input_as(String arg1) throws Throwable {
		Thread.sleep(1000);
		user_Select_Decimal_drop_down();
		Thread.sleep(1000);
     if(arg1.equalsIgnoreCase("0")){
			
			login.driver.findElement(By.xpath("//ul[@class='select2-results']/li[1]/div/div")).click();
		}else if(arg1.equalsIgnoreCase("8")){
			
		login.driver.findElement(By.xpath("//ul[@class='select2-results']/li[9]/div/div")).click();
		}
		
	}
		
	@And("^Select Orientation as  column$")
	public void Select_Orientation_as_column() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Columns')]")).click();
	}

	@And("^Select Data order as  Ascending$")
	public void Select_Data_order_as_Ascending() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Ascending')]")).click();
	}
	
	@And("^Select Orientation as  Rows$")
	public void Select_Orientation_as_Rows() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Rows')]")).click();
	}

	@And("^Select Data order as  Descending$")
	public void Select_Data_order_as_Descending() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Descending')]")).click();
	}

	@And("^Select on Range$")
	public void Select_on_Range() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Range')]")).click();
		
	}
	
	@And("^deSelect Series Attributes$")
	public void user_deSelect_Series_Attributes() throws Throwable {
		Thread.sleep(10000);
		login.driver.findElement(By.xpath( "//div[@class='choosable-selected-item__close']")).click();
	}
	@And("^Select Filter out dates with no observations$")
	public void Select_Filter_out_dates_with_no_observations() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//*[@class='select2-container form--control blank-input']/a/span[2]/b")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath( "//ul[@class='select2-results']/li[1]/div/div")).click();
		
	}

	@And("^Select the Selected Attributes$")
	public void Select_the_Selected_Attributes() throws Throwable {
		
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='choosable-selected-item choosable-selected-item--small-purple']")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='choosable-list']/div[1]/span[1]")).click();
         List<WebElement> objLinks = login.driver.findElements(By.xpath("//div[@class='choosable-list']/div"));
		 System.out.println("Total Size are- " + objLinks.size());
		
		for(int i=1;i<=12;i++){
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath("//div[@class='choosable-list']/div[" +i+ "]/span[1]")).click();
		}
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='cool-multi-select--input choosable-search-input']")).click();
		
	}
	
	@And("^Select Leave as Blank$")
	public void Select_Leave_as_Blank() throws Throwable {
		
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//*[@class='select2-container form--control blank-input']/a/span[2]/b")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath( "//ul[@class='select2-results']/li[2]/div/div")).click();
	}
	
	@And("^Select All button$")
	public void Select_All_button() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/div[2]/div[1]/label/span[2]")).click();
	}
	
	@And("^User(\\d+) Select Custom date format$")
	public void user_Select_Custom_date_format(int arg1) throws Throwable {
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("//div[@class='insight-download-advanced-settings']/div/div[5]/div[2]/a/span[2]/b")).click();
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("//ul[@class='select2-results']/li[2]/div/div")).click();
	}

	@And("^Select Custom date input as \"([^\"]*)\"$")
	public void Select_Custom_date_input_as(String arg2) throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div/input[@class='format-input']")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div/input[@class='format-input']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div/input[@class='format-input']")).sendKeys(arg2);
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div[2]/div[2]/button[2]")).click();
	}
	@And("^User(\\d+) Select All Attributes$")
	public void user_Select_All_Attributes(int arg1) throws Throwable {
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("//div[@class='cool-multi-select--input choosable-search-input']")).click();
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("//div[@class='cool-multi-select--select-all-btn']")).click();
	}
	@And("^Select the Function as \"([^\"]*)\"$")
	public void Select_the_Function_as(String arg2) throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='download-data-transformation']/div/div[5]")).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//input[@class='form--control search-functions-input']")).sendKeys(arg2);
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='function-item']")).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//button[contains (text(),'Insert function')]")).click();
		
	}

	
	@And("^select the Replace selected series option$")
	public void select_the_Replace_selected_series_option() throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div[2]/div/div/div[2]/div/div[2]/div[2]/div[1]/label/span[1]")).click();
	}
	
	@And("^Select the Start Date as \"([^\"]*)\" and End Date \"([^\"]*)\"$")
	public void Select_the_Start_Date_as_and_End_Date(String arg2, String arg3) throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Range')]")).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//input[@class='form--control input-date-start']")).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//input[@class='form--control input-date-start']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//input[@class='form--control input-date-start']")).sendKeys(arg2);
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//input[@class='form--control input-date-end']")).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//input[@class='form--control input-date-end']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//input[@class='form--control input-date-end']")).sendKeys(arg3);
		Thread.sleep(1000);
		System.out.println(arg3);
		
		if(arg3.equalsIgnoreCase("01-01-2001" )){
			login.driver.findElement(By.xpath("//td[@class='active day']")).click();
			
		}else if(arg3.equalsIgnoreCase("No end date")){
			
			login.driver.findElement(By.xpath("//button[@class='insight-download-datepicker-custom-button']")).click();
		}else if(arg3.equalsIgnoreCase("2004-01-01")){
			
			login.driver.findElement(By.xpath("//td[@class='active day']")).click();
		}
		else{
		login.driver.findElement(By.xpath("//td[contains(text(),'31')]")).click();
		}
	}
	
	@And("^Select the Parameters$")
	public void Select_the_Parameters() throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='function-data--description function-data--parameters']/div[1]//a/span/b")).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//ul[@class='select2-results']/li[2]")).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='function-data--description function-data--parameters']/div[3]//a/span/b")).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//ul[@class='select2-results']/li[2]")).click();
		
	}
	@And("^Select the Applay button$")
	public void Select_the_Applay_button() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//button[contains (text(),'Apply')]")).click();
	}
	@And("^Select the  Adjust columns as wrap text$")
	public void Select_the_Adjust_columns_as_wrap_text() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Wrap text')]")).click();
		
	}
	@And("^Select the Series name$")
	public void Select_the_Series_name() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='choosable-selected-item choosable-selected-item--small-purple']")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='choosable-list']/div[1]/span[1]")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='choosable-list']/div[1]/span[1]")).click();
	    Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='cool-multi-select--input choosable-search-input']")).click();
	}

	@And("^uncheck the Date column$")
	public void uncheck_the_Date_column() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Show date column')]")).click();
	}
	
	@And("^Select Fill with NA$")
	public void Select_Fill_with_NA() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//*[@class='select2-container form--control blank-input']/a/span[2]/b")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath( "//ul[@class='select2-results']/li[3]/div/div")).click();
	}
	@Given("^Deselect last observation date and time$")
	public void Deselect_last_observation_date_and_time() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='choosable-selected-item choosable-selected-item--small-purple']")).click();
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("//div[@class='choosable-list ps-container ps-theme-default']/div[11]/span[1]")).click();
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("//div[@class='choosable-list ps-container ps-theme-default']/div[12]/span[1]")).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='cool-multi-select--input choosable-search-input']")).click();
	}
	
	@And("^add Series$")
	public void add_Series() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='add-to-data-selection--icon']")).click();
		
	}

	@And("^Verify the Function as \"([^\"]*)\"$")
	public void Verify_the_Function_as(String arg2) throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='download-data-transformation']/div/div[5]")).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//input[@class='form--control search-functions-input']")).sendKeys(arg2);
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='series-functions-list noselect']/div[3]/div")).click();
		Thread.sleep(1000);
		if(arg2.equalsIgnoreCase("SUM")){
			login.driver.findElement(By.xpath("//div[@class='function-item selected']")).click();
		}else{	
		login.driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div[2]/div/div/div[2]/div/div[2]/div[1]/div/div/div[3]/div[2]/div[1]/div/div/div/label/span")).click();
		}
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//button[contains (text(),'Insert function')]")).click();
		
	}
	
	@And("^Select Date drop down$")
	public void select_Date_drop_down() throws Throwable {
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("//div[@class='insight-download-advanced-settings']/div/div[5]/div[2]/a/span[2]/b")).click();
		
	}

	@Then("^Automatic and Custom Date drop down should be available$")
	public void automatic_and_Custom_Date_drop_down_should_be_available() throws Throwable {
		WebElement Automaticdate = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Automaticdate")));
		  Assert.assertEquals(true,Automaticdate.isDisplayed());
		 WebElement Customdate = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Customdate")));
		  Assert.assertEquals(true,Customdate.isDisplayed());
	
		  Thread.sleep(5000);
			login.driver.findElement(By.xpath("//ul[@class='select2-results']/li[1]/div/div")).click();
			Thread.sleep(5000);
			login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			  user_signout();
	}
	
	@Then("^default decimal place to be as (\\d+)$")
	public void default_decimal_place_to_be_as(int arg1) throws Throwable {
		
		if(login.driver.findElements(By.xpath("//span/div[contains(text(),'3')]")).size() != 0){
			System.out.println("Default Decimal value is 3 .");
			}else{
				 Assert.fail( "Default Decimal value is NOT 3 and It's BUG.");
			     System.out.println("Element is Absent");
			}
	
			login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			  user_signout();
			  
	}
	
	@Given("^Select Decimal drop down$")
	public void select_Decimal_drop_down() throws Throwable {
		Thread.sleep(5000);
		user_Select_Decimal_drop_down();
	}

	@Then("^decimal range should be as (\\d+)-(\\d+)$")
	public void decimal_range_should_be_as(int arg1, int arg2) throws Throwable {
		Thread.sleep(5000);
		WebElement zerodecimal = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("zerodecimal")));
		  Assert.assertEquals(true,zerodecimal.isDisplayed());
		  WebElement onedecimal = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("onedecimal")));
		  Assert.assertEquals(true,onedecimal.isDisplayed());
		  WebElement twodecimal = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("twodecimal")));
		  Assert.assertEquals(true,twodecimal.isDisplayed());
		  WebElement threedecimal = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("threedecimal")));
		  Assert.assertEquals(true,threedecimal.isDisplayed());
		  WebElement fourdecimal = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("fourdecimal")));
		  Assert.assertEquals(true,fourdecimal.isDisplayed());
		  WebElement fivedecimal = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("fivedecimal")));
		  Assert.assertEquals(true,fivedecimal.isDisplayed());
		  WebElement sixdecimal = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("sixdecimal")));
		  Assert.assertEquals(true,sixdecimal.isDisplayed());
		  WebElement sevendecimal = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("sevendecimal")));
		  Assert.assertEquals(true,sevendecimal.isDisplayed());
		  WebElement eightdecimal = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("eightdecimal")));
		  Assert.assertEquals(true,eightdecimal.isDisplayed());
		  Thread.sleep(5000);
		  login.driver.findElement(By.xpath("//ul[@class='select2-results']/li[4]/div/div")).click();
			login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			  user_signout();
		  
	}
	
	@Then("^Adjust column and wrap text option should be present$")
	public void adjust_column_and_wrap_text_option_should_be_present() throws Throwable {
		 Thread.sleep(5000);
		WebElement Adjustcolumnno = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Adjustcolumnno")));
		  Assert.assertEquals(true,Adjustcolumnno.isDisplayed());
		  WebElement Adjustcolumnwrap = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Adjustcolumnwrap")));
		  Assert.assertEquals(true,Adjustcolumnwrap.isDisplayed());
		  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		  user_signout();
	}
	
	@Then("^Create a chart with series is available$")
	public void create_a_chart_with_series_is_available() throws Throwable {
		Thread.sleep(5000);
		WebElement Createchart = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Createchart")));
		  Assert.assertEquals(true,Createchart.isDisplayed());
		  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		  user_signout();
	}
	
	@Then("^Ascending and  Descending date order radio buttons should be present$")
	public void ascending_and_Descending_date_order_radio_buttons_should_be_present() throws Throwable {
		Thread.sleep(5000);
		WebElement Ascending = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ascending")));
		  Assert.assertEquals(true,Ascending.isDisplayed());
		  WebElement Descending = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Descending")));
		  Assert.assertEquals(true,Descending.isDisplayed());
		  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		  user_signout();
	}
	
	@Then("^Columns and Rows radio buttons should be present$")
	public void columns_and_Rows_radio_buttons_should_be_present() throws Throwable {
		Thread.sleep(5000);
		WebElement Columns = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Columns")));
		  Assert.assertEquals(true,Columns.isDisplayed());
		  WebElement Rows = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rows")));
		  Assert.assertEquals(true,Rows.isDisplayed());
		  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		  user_signout();
	}
	@Then("^ADD function  button should be present$")
	public void add_function_button_should_be_present() throws Throwable {
		Thread.sleep(5000);
		WebElement ADDfunc = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ADDfunc")));
		  Assert.assertEquals(true,ADDfunc.isDisplayed());
		  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		  user_signout();
	}
	
	
	@Then("^Blank Observations  with THREE options should be present$")
	public void blank_Observations_with_THREE_options_should_be_present() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//*[@class='select2-container form--control blank-input']/a/span[2]/b")).click();
		WebElement noobservations = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("noobservations")));
		  Assert.assertEquals(true,noobservations.isDisplayed());
		  WebElement Leaveasblank = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Leaveasblank")));
		  Assert.assertEquals(true,Leaveasblank.isDisplayed());
		  WebElement FillNA = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("FillNA")));
		  Assert.assertEquals(true,FillNA.isDisplayed());
		  Thread.sleep(2000);
		  login.driver.findElement(By.xpath( "//ul[@class='select2-results']/li[1]/div/div")).click();
		  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		  user_signout();
	}
	
	@Then("^Ask me about Export settings options should be present$")
	public void ask_me_about_Export_settings_options_should_be_present() throws Throwable {
		Thread.sleep(2000);
		WebElement Askmebtn = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Askmebtn")));
		Assert.assertEquals(true,Askmebtn.isDisplayed());
		 login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		  user_signout();
	}
	
	@Then("^A pop message with message as The excel file is being generated\\.your download will start in a few seconds\" should appear each time as default\\.$")
	public void a_pop_message_with_message_as_The_excel_file_is_being_generated_your_download_will_start_in_a_few_seconds_should_appear_each_time_as_default() throws Throwable {
		Thread.sleep(2000);
			login.driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div[2]/div[2]/button[4]/span")).click();
			 Thread.sleep(1000);
		WebElement Downloadpopup = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Downloadpopup")));
		Assert.assertEquals(true,Downloadpopup.isDisplayed());
		Thread.sleep(70000);
		File_delete.delete();
		 user_signout();
		 
	}
	
	
	@Then("^All attributes are selected and show date column is also selected by default$")
	public void all_attributes_are_selected_and_show_date_column_is_also_selected_by_default() throws Throwable {
		Thread.sleep(2000);
		WebElement Allattributes = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Allattributes")));
		Assert.assertEquals(true,Allattributes.isDisplayed());
		WebElement showdatecoloum = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("showdatecoloum")));
		Assert.assertEquals(true,showdatecoloum.isDisplayed());
		login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		 user_signout();
	}
	
	@Then("^ALL Timeframe options should be present$")
	public void all_Timeframe_options_should_be_present() throws Throwable {
		Thread.sleep(2000);
		WebElement Range = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Range")));
		Assert.assertEquals(true,Range.isDisplayed());
		WebElement Sample = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sample")));
		Assert.assertEquals(true,Sample.isDisplayed());
		login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		user_signout();
	}

	@Then("^Sample=(\\d+) should be the default timeframe option$")
	public void sample_should_be_the_default_timeframe_option(int arg1) throws Throwable {
		Thread.sleep(2000);
		WebElement Sample10 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sample10")));
		Assert.assertEquals(true,Sample10.isDisplayed());
		login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		user_signout();
	}
	
	@And("^Verify Data referesh option is checked by deault$")
	public void verify_Data_referesh_option_is_checked_by_deault() throws Throwable {
		
		element = login.driver.findElement(By.xpath("//div[@class='insight-download-formats']/div[7]/div[2]/label/input"));
		
		if(element.isSelected()){
			System.out.println("Data Refresh is checked");
			login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			user_signout();
		}
		else if(!element.isSelected()){
			 Assert.fail( "Data Refresh is NOT checked by default and It's BUG.");
			 login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
				user_signout();
		}
	}

	@And("^Select the Range$")
	public void select_the_Range() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Range')]")).click();
	}
	@And("^Select Decimal input-(\\d+)$")
	public void select_Decimal_input(int arg1) throws Throwable {
		user_Select_Decimal_drop_down();
		login.driver.findElement(By.xpath("//ul[@class='select2-results']/li[5]/div/div")).click();
		
	}
	
	@And("^Select Series Name and Series Statistics$")
	public void select_Series_Name_and_Series_Statistics() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='choosable-selected-item choosable-selected-item--small-purple']")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='choosable-list']/div[1]/span[1]")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='choosable-list']/div[1]/span[1]")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='choosable-list']/div[17]/span[1]")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='cool-multi-select--input choosable-search-input']")).click();
		
	}
	@And("^Select the Selected Attributes along with Series Statistics$")
	public void select_the_Selected_Attributes_along_with_Series_Statistics() throws Throwable {
		
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='choosable-selected-item choosable-selected-item--small-purple']")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='choosable-list']/div[1]/span[1]")).click();
         List<WebElement> objLinks = login.driver.findElements(By.xpath("//div[@class='choosable-list']/div"));
		 System.out.println("Total Size are- " + objLinks.size());
		
		for(int i=1;i<=12;i++){
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath("//div[@class='choosable-list']/div[" +i+ "]/span[1]")).click();
		}
		Thread.sleep(1000);
		 login.driver.findElement(By.xpath("//div[@class='choosable-list']/div[17]/span[1]")).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='cool-multi-select--input choosable-search-input']")).click();
		
	}
		
	
	@And("^Add to Right panel$")
	public void add_to_Right_panel() throws Throwable {
		
		
		List<WebElement> objLinks = login.driver.findElements(By.xpath("//a[@class='series-list-item--container series-list-item--container__with_actions']"));
		
		System.out.println("Total Size are- " + objLinks.size());
		
		for(int i=1;i<=objLinks.size();i++){
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath("//ul[@class='search-series-list scrollable']/li[" + i + "]/div/a/div[2]")).click();
		}
		 Thread.sleep(2000);
	     login.driver.findElement(By.xpath("//ul[@class='search-series-list scrollable']/li[1]/div/a/div[5]/div/div[1]")).click();
	}

	
	@Then("^download should be Sucess$")
	public void download_should_be_Sucess() throws Throwable {
		Thread.sleep(5000);
		user_Select_pop_up_Download_button();
		Thread.sleep(2000);
		user_signout();
		Last_file_download.getTheNewestFile();
	}
	
	@And("^User Select  Multiple Series ID  as \"([^\"]*)\"$")
	public void user_Select_Multiple_Series_ID_as(String arg1) throws Throwable {
		Thread.sleep(2000);
		user_Refresh_the_page();
		Thread.sleep(6000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).clear();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(arg1);
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
	}

	@And("^Create a Table$")
	public void create_a_Table() throws Throwable {
		
		List<WebElement> objLinks = login.driver.findElements(By.xpath("//a[@class='series-list-item--container series-list-item--container__with_actions']"));
		System.out.println("Total Size are- " + objLinks.size());
		
		for(int i=1;i<=objLinks.size();i++){
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath("//ul[@class='search-series-list scrollable']/li[" + i + "]/div/a/div[2]")).click();
		}
		
		 Robot r = new Robot();
		 r.keyPress(KeyEvent.VK_T);
		 r.keyRelease(KeyEvent.VK_T);
		
	}
	@And("^Select Download Button$")
	public void select_Download_Button() throws Throwable {
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("//span[@class='download-button--text']")).click();
	}
	
	@Then("^Tabel download should be Sucess$")
	public void tabel_download_should_be_Sucess() throws Throwable {
		Thread.sleep(2000);
		user_Select_pop_up_Download_button();
		Thread.sleep(2000);
		
		Actions action = new Actions(login.driver);
		WebElement we = login.driver.findElement(By.xpath("//div[@class='insight-page-menu-views-item insight-page-menu-item']/a/span[1]"));
		action.moveToElement(we).build().perform();
		login.driver.findElement(By.xpath("//i[@class='fa fa-times']")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div[2]/div/button[2]")).click();
		
		login.driver.findElement(By.xpath("//a[@class='insight-page-menu-item-link active']")).click();
		user_signout();
		Last_file_download.getTheNewestFile();
	}
	
	
	
	@And("^Create a Chart$")
	public void create_a_Chart() throws Throwable {
		Thread.sleep(2000);
		List<WebElement> objLinks = login.driver.findElements(By.xpath("//a[@class='series-list-item--container series-list-item--container__with_actions']"));
		System.out.println("Total Size are- " + objLinks.size());
		
		for(int i=1;i<=objLinks.size();i++){
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//ul[@class='search-series-list scrollable']/li[" + i + "]/div/a/div[2]")).click();
		}
		
		 Robot r = new Robot();
		 r.keyPress(KeyEvent.VK_C);
		 r.keyRelease(KeyEvent.VK_C);
	}
	
	
	@And("^Create a Map$")
	public void create_a_Map() throws Throwable {
     Thread.sleep(2000);
		
		List<WebElement> objLinks = login.driver.findElements(By.xpath("//a[@class='series-list-item--container series-list-item--container__with_actions']"));
		System.out.println("Total Size are- " + objLinks.size());
		
		for(int i=1;i<=objLinks.size();i++){
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath("//ul[@class='search-series-list scrollable']/li[" + i + "]/div/a/div[2]")).click();
			
		}
		 Robot r = new Robot();
		 r.keyPress(KeyEvent.VK_M);
		 r.keyRelease(KeyEvent.VK_M);
	}

	@Then("^Map download should be Sucess$")
	public void map_download_should_be_Sucess() throws Throwable {
		Thread.sleep(2000);
		user_Select_pop_up_Download_button();
		Thread.sleep(2000);
		
		Actions action = new Actions(login.driver);
		WebElement we = login.driver.findElement(By.xpath("//div[@class='insight-page-menu-views-item insight-page-menu-item']/a/span[1]"));
		action.moveToElement(we).build().perform();
		login.driver.findElement(By.xpath("//i[@class='fa fa-times']")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div[2]/div/button[2]")).click();
		
		login.driver.findElement(By.xpath("//a[@class='insight-page-menu-item-link active']")).click();
		user_signout();
		Last_file_download.getTheNewestFile();
	}
	
	@Given("^Create a HeatMap$")
	public void create_a_HeatMap() throws Throwable {
		 Thread.sleep(2000);
			
			List<WebElement> objLinks = login.driver.findElements(By.xpath("//a[@class='series-list-item--container series-list-item--container__with_actions']"));
			System.out.println("Total Size are- " + objLinks.size());
			
			for(int i=1;i<=objLinks.size();i++){
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath("//ul[@class='search-series-list scrollable']/li[" + i + "]/div/a/div[2]")).click();
			}
			 Robot r = new Robot();
			 r.keyPress(KeyEvent.VK_H);
			 r.keyRelease(KeyEvent.VK_H);
		}
	

	@Then("^HeatMap download should be Sucess$")
	public void heatmap_download_should_be_Sucess() throws Throwable {
		Thread.sleep(2000);
		user_Select_pop_up_Download_button();
		Thread.sleep(2000);
		
		Actions action = new Actions(login.driver);
		WebElement we = login.driver.findElement(By.xpath("//div[@class='insight-page-menu-views-item insight-page-menu-item']/a/span[1]"));
		action.moveToElement(we).build().perform();
		login.driver.findElement(By.xpath("//i[@class='fa fa-times']")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div[2]/div/button[2]")).click();
		
		login.driver.findElement(By.xpath("//a[@class='insight-page-menu-item-link active']")).click();
		user_signout();
		Last_file_download.getTheNewestFile();
	}
	
	@And("^Chart download should be Sucess$")
	public void chart_download_should_be_Sucess() throws Throwable {
		Thread.sleep(2000);
		user_Select_pop_up_Download_button();
		Thread.sleep(2000);
		
		Actions action = new Actions(login.driver);
		WebElement we = login.driver.findElement(By.xpath("//div[@class='insight-page-menu-views-item insight-page-menu-item']/a/span[1]"));
		action.moveToElement(we).build().perform();
		login.driver.findElement(By.xpath("//i[@class='fa fa-times']")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div[2]/div/button[2]")).click();
		
		login.driver.findElement(By.xpath("//a[@class='insight-page-menu-item-link active']")).click();
		user_signout();
			Last_file_download.getTheNewestFile();
	}
	
	
	@And("^select the \"([^\"]*)\" format$")
	public void select_the_format(String arg1) throws Throwable {
		format=arg1;
		 switch (arg1) {
		   case "png":
			login.driver.findElement(By.xpath("//label[@title='Download visual to PNG image']")).click();
		    break;
		   case "jpeg":
			   login.driver.findElement(By.xpath("//label[@title='Download visual to JPG image']")).click();
			   break;
		   case "csv":
			   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CSV_Format"))).click();
			   break;
		   case "xlsx":
			   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("XLS_Format"))).click();
			   break;
		   case "pdf":
			   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("PDF_Format"))).click();
			   break;
	}
	}
	
	@And("^User Add (\\d+) Series into Right panel$")
	public void user_Add_Series_into_Right_panel(int arg1) throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='search-input-field-wrap-inner--clear-button']")).click();                          
		Thread.sleep(2000);
		Actions action = new Actions(login.driver);
		action.moveToElement(login.driver.findElement(By.xpath("//div[@class='search-presentation-tabs--visible']/span[4]"))).doubleClick().perform();
		Thread.sleep(6000);
		login.driver.findElement(By.xpath("//*[@class='name-text'][contains (text(), '" + "Global Database" + "')]/../../../../div[@class='toggle']")).click();
		Thread.sleep(6000);
		login.driver.findElement(By.xpath("//*[@class='name-text'][contains (text(), '" + "All Countries" + "')]/../../../../div[@class='toggle']")).click();	   
        Thread.sleep(6000);
	   login.driver.findElement(By.xpath("//*[@class='name-text'][contains (text(), '" + "Albania" + "')]/../../../../div[@class='toggle']")).click();
	
	  Thread.sleep(6000);
	  login.driver.findElement(By.xpath("//*[@class='name-text'][contains (text(), '" + "Albania: Balance of Payments" + "')]/../../../../div[@class='toggle']")).click();
	
	
	JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	
	element = login.driver.findElement(
			By.xpath("//div[@class='tree-node open']/div/div/div/div[10]"));
	jse.executeScript("arguments[0].scrollIntoView(true);", element);
	
	Thread.sleep(2000);
	login.driver.findElement(By.xpath("//div[@class='tree-node open']/div/div/div/div[12]/div/span")).click();
	Thread.sleep(2000);
	login.driver.findElement(By.xpath("//div[@class='tree-node open']/div/div/div/div[14]/div/span")).click();
	Thread.sleep(2000);
	login.driver.findElement(By.xpath("//div[@class='tree-node open']/div/div/div/div[15]/div/span")).click();
	Thread.sleep(2000);
	login.driver.findElement(By.xpath("//div[@class='tree-node open']/div/div/div/div[16]/div/span")).click();
	Thread.sleep(2000);
	login.driver.findElement(By.xpath("//div[@class='tree-node open']/div/div/div/div[20]/div/span")).click();
	Thread.sleep(2000);
	login.driver.findElement(By.xpath("//div[@class='tree-node open']/div/div/div/div[22]/div/span")).click();
	Thread.sleep(2000);
	login.driver.findElement(By.xpath("//div[@class='tree-node open']/div/div/div/div[23]/div/span")).click();
	Thread.sleep(2000);
	login.driver.findElement(By.xpath("//div[@class='tree-node open']/div/div/div/div[24]/div/span")).click();
	
	 Robot r = new Robot();
	 r.keyPress(KeyEvent.VK_A);
	 r.keyRelease(KeyEvent.VK_A);

	}
	
	
	@And("^Successfully download (\\d+) series$")
	public void successfully_download_series(int arg1) throws Throwable {
		 Thread.sleep(2000);
		 WebElement ThreeThousandSeries = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ThreeThousandSeries")));
		  Assert.assertEquals(true,ThreeThousandSeries.isDisplayed());
		  Thread.sleep(50000);
			login.driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div[2]/div[2]/button[4]/span")).click();
			 Thread.sleep(30000);
			 File_delete.delete();
			 Thread.sleep(20000);
			user_signout();
	}
     
	@Given("^Compares \"([^\"]*)\" exel sheet with Actual data$")
	public void compares_exel_sheet_with_Actual_data(String arg1) throws Throwable {
		Thread.sleep(2000);
		user_Select_pop_up_Download_button();
		Thread.sleep(50000);
		testcase_num=arg1;
		System.out.println("Comparing Data of " + testcase_num +  " with Actual data");
		CompareExcel.Excel();
		Thread.sleep(50000);
		File_delete.delete();
		Thread.sleep(5000);
		user_signout();
	}
	
	@And("^Reset button should Successfully work$")
	public void reset_button_should_Successfully_work() throws Throwable {
		Thread.sleep(2000);
		user_Select_Reset_button();
		Thread.sleep(1000);
		WebElement Columns = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Columns")));
		  Assert.assertEquals(true,Columns.isDisplayed());
		Thread.sleep(1000);
		WebElement Adjustcolumnno = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Adjustcolumnno")));
		  Assert.assertEquals(true,Adjustcolumnno.isDisplayed());
		  Thread.sleep(1000);
		  WebElement Ascending = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ascending")));
		  Assert.assertEquals(true,Ascending.isDisplayed());
		  Thread.sleep(1000);
		  WebElement Sample = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sample")));
			Assert.assertEquals(true,Sample.isDisplayed());
		Thread.sleep(1000);
		WebElement Allattributes = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Allattributes")));
		Assert.assertEquals(true,Allattributes.isDisplayed());
		Thread.sleep(2500);
		login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		Thread.sleep(1500);
		user_signout();
		
	}
	
	@And("^select the \"([^\"]*)\"$")
	public void select_the(String arg1) throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[10]/div[2]")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Add separator')]")).click();
		Thread.sleep(1500);
		Actions action = new Actions(login.driver);
		action.moveToElement(login.driver.findElement(By.xpath("//div[@class='insight-series-container']/div/div/div/div/label/span"))).doubleClick().perform();
	}
	
	
	@And("^Sucessfully verify the Cancel button$")
	public void sucessfully_verify_the_Cancel_button() throws Throwable {
		Thread.sleep(5000);
		WebElement Downloadwindowclose = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Downloadwindowclose")));
		Assert.assertEquals(true,Downloadwindowclose.isDisplayed());
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Downloadwindowclose"))).click();
		Thread.sleep(1500);
		user_signout();
	}
	
	@And("^Sucessfully verify the Srcode exist or not$")
	public void sucessfully_verify_the_Srcode_exist_or_not() throws Throwable {
		Thread.sleep(2500);
		login.driver.findElement(By.xpath("//div[@class='choosable-selected-item choosable-selected-item--small-purple']")).click();
		Thread.sleep(2500);
		WebElement SRcode = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SRcode")));
		Assert.assertEquals(true,SRcode.isDisplayed());
		Thread.sleep(2500);
		login.driver.findElement(By.xpath("//div[@class='choosable-selected-item choosable-selected-item--small-purple']")).click();
		login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		user_signout();
	}
	
	@And("^Select Function button on my series panel$")
	public void select_Function_button_on_my_series_panel() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='insight-series-container']/div/div/div/div/label/span")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='function-editor-window--icon']")).click();
	}
	
	
	@And("^Apply Function as \"([^\"]*)\"$")
	public void apply_Function_as(String arg1) throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//input[@class='form--control search-functions-input']")).sendKeys(arg1);
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='function-item']")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//button[contains (text(),'Insert function')]")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//button[contains (text(),'Apply')]")).click();
	}
	
	@And("^Select series from Series and myseries$")
	public void select_series_from_Series_and_myseries() throws Throwable {
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']")).click();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath("//div[@class='insight-series-container']/div/div/div/div/label/span")).click();
	}
	
	@And("^series selection W\\.R\\.T both search and myseries must be Successfull$")
	public void series_selection_W_R_T_both_search_and_myseries_must_be_Successfull() throws Throwable {
		Thread.sleep(1000);
		WebElement search_series = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("search_series")));
		  Assert.assertEquals(true,search_series.isDisplayed());
		  Thread.sleep(1000);
		  WebElement myseries_series = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("myseries_series")));
		  Assert.assertEquals(true,myseries_series.isDisplayed());
		  Thread.sleep(1000);
		  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		  Thread.sleep(1000);
		  login.driver.findElement(By.xpath("//div[@class='insight-series-container']/div/div/div/div/label/span")).click();
		  Thread.sleep(1000);
		  login.driver.findElement(By.xpath("//ul[@class='search-series-list scrollable']/li[1]/div/a/div[2]")).click();
		  user_signout();
	}
	
	@And("^User verify state of download button when there are no series in myseries/no views$")
	public void user_verify_state_of_download_button_when_there_are_no_series_in_myseries_no_views() throws Throwable {
		
		Thread.sleep(1000);
		if(login.driver.findElements(By.xpath("//div[@class='download-button download-button__header download-button__algae download-button__disabled download-button__unavailable']")).size() != 0){
			System.out.println("Download Button is disabled.");
			}else{
				 Assert.fail( "Download Button is Enabled. Series or Views may Present.");
			     System.out.println("Element is Absent");
			}
	}
	
	@Given("^Verify label for different frequency series from \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\"$")
	public void verify_label_for_different_frequency_series_from_and(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
		Thread.sleep(1000);
		if(arg2.equals(arg2))
		{
			Actions action = new Actions(login.driver);
			WebElement element = login.driver.findElement(By.xpath("//div[@class='series-name-wrapper ']"));
			action.moveToElement(element).build().perform();
			String Text;
			Text = element.getAttribute("title");
			System.out.println(Text);
			String[]  array = Text.split("\n");
					int size=array.length;
					System.out.println(size);
					for(int i=1;i<array.length;i++){
					}
					System.out.println(array[3]);
		}
	}
	
	
	@And("^verify the available formats$")
	public void verify_the_available_formats() throws Throwable {
		Thread.sleep(1000);
		WebElement XLS_Format = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("XLS_Format")));
		Assert.assertEquals(true,XLS_Format.isDisplayed());
		Thread.sleep(1000);
		WebElement PDF_Format = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("PDF_Format")));
		Assert.assertEquals(true,PDF_Format.isDisplayed());
		Thread.sleep(1000);
		WebElement PNG_Format = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("PNG_Format")));
		Assert.assertEquals(true,PNG_Format.isDisplayed());
		Thread.sleep(1000);
		WebElement JPG_Format = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("JPG_Format")));
		Assert.assertEquals(true,JPG_Format.isDisplayed());
		Thread.sleep(10000);
		 login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		
		Thread.sleep(5000);
		
		Actions action = new Actions(login.driver);
		WebElement we = login.driver.findElement(By.xpath("//div[@class='insight-page-menu-views-item insight-page-menu-item']/a/span[1]"));
		action.moveToElement(we).build().perform();
		login.driver.findElement(By.xpath("//i[@class='fa fa-times']")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div[2]/div/button[2]")).click();
		
		login.driver.findElement(By.xpath("//a[@class='insight-page-menu-item-link active']")).click();
		
	}
	
	
	@And("^verify the formats available for views download$")
	public void verify_the_formats_available_for_views_download() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='tabs__tabs-box']/div[3]")).click();
		Thread.sleep(1000);
		WebElement XLS_Format = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("XLS_Format")));
		Assert.assertEquals(true,XLS_Format.isDisplayed());
		Thread.sleep(1000);
		WebElement PDF_Format = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("PDF_Format")));
		Assert.assertEquals(true,PDF_Format.isDisplayed());
		 Thread.sleep(9500);
		  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			Thread.sleep(5000);
			
			Actions action = new Actions(login.driver);
			WebElement we = login.driver.findElement(By.xpath("//div[@class='insight-page-menu-views-item insight-page-menu-item']/a/span[1]"));
			action.moveToElement(we).build().perform();
			login.driver.findElement(By.xpath("//i[@class='fa fa-times']")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div[2]/div/button[2]")).click();
			login.driver.findElement(By.xpath("//a[@class='insight-page-menu-item-link active']")).click();
			user_signout();
	}
	
	
	@And("^Expand the database tree$")
	public void expand_the_database_tree() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
		Thread.sleep(5000);
		
		Actions action = new Actions(login.driver);
		action.moveToElement
		(login.driver.findElement(By.xpath("//div[@class='search-presentation--header series-panel']/div[1]/div/div/span[4]/span"))).doubleClick().build().perform();
	
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='child-container']/div/div/div/div/div/div[3]/div/div[1]")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='child-container']/div/div/div/div/div/div[3]/div/div[3]/div/div[1]")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='child-container']/div/div/div/div/div/div[3]/div/div[3]/div/div[2]/span[1]")).click();
		Thread.sleep(2000);
		Robot r = new Robot();
		 r.keyPress(KeyEvent.VK_A);
		 r.keyRelease(KeyEvent.VK_A);
		 login.driver.findElement(By.xpath("//div[@class='insight-series-rename--button insight-series-rename--button__cancel']")).click();
		 Thread.sleep(5000);
			login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[10]/div[2]")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//span[contains(text(),'Ungroup')]")).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
	}
	
	@And("^User Search for Series ID  as \"([^\"]*)\"$")
	public void user_Search_for_Series_ID_as(String arg1) throws Throwable {
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).clear();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(arg1);
	}

	

	@And("^select the download by right click option from database tree$")
	public void select_the_download_by_right_click_option_from_database_tree() throws Throwable {
		Thread.sleep(2000);
		Actions action = new Actions(login.driver);
		WebElement searchdatabasetree = login.driver.findElement(By.xpath("//div[@class='series-item--main-info']"));
		action.contextClick(searchdatabasetree).perform();
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("//div[@class='items-wrapper']/li[9]")).click();
	}
	
	@And("^select the download by right click option from series tab$")
	public void select_the_download_by_right_click_option_from_series_tab() throws Throwable {
		Thread.sleep(2000);
		Actions action = new Actions(login.driver);
		WebElement searchdatabasetree = login.driver.findElement(By.xpath("//div[@class='series-item--main-info']"));
		action.contextClick(searchdatabasetree).perform();
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("//div[@class='items-wrapper']/li[9]")).click();
	}
	
	@And("^select the download by right click option from under more option$")
	public void select_the_download_by_right_click_option_from_under_more_option() throws Throwable {
		Actions action = new Actions(login.driver);
		WebElement we = login.driver.findElement(By.xpath("//div[@class='series-item--main-info']"));
		action.moveToElement(we).build().perform();
		login.driver.findElement(By.xpath("//div[@class='series-list-item--action-icons']/span[4]")).click();
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("//div[@class='items-wrapper']/li[9]")).click();
	}
	@And("^select the download present in the File menu option$")
	public void select_the_download_present_in_the_File_menu_option() throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("//div[@class='header-menu-item--dropdown']/div[11]")).click();
	}
	
	@And("^select the download present from SSP window$")
	public void select_the_download_present_from_SSP_window() throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='series-item--main-info']")).click();
		Thread.sleep(8000);
		login.driver.findElement(By.xpath("//div[@class='series-preview--header ui-draggable-handle']/div[2]/div[4]")).click();
	}
	
	@And("^select the download present from Footnotes window$")
	public void select_the_download_present_from_Footnotes_window() throws Throwable {
		Thread.sleep(1000);
		Actions action = new Actions(login.driver);
		WebElement we = login.driver.findElement(By.xpath("//div[@class='series-item--main-info']"));
		action.moveToElement(we).build().perform();
		login.driver.findElement(By.xpath("//div[@class='series-list-item--action-icons']/span[3]")).click();
	}
	@Then("^Download option from Footnotes window should be Sucess$")
	public void Download_option_from_Footnotes_window_should_be_Sucess() throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='download-button download-button__modal']")).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='movable-modal--close']")).click();
		Thread.sleep(3000);
		Latestfiledownload.lastFileModified();
		Thread.sleep(1000);
		user_signout();
	}
	
	@And("^select the download by right click option from Myseries Panal$")
	public void select_the_download_by_right_click_option_from_Myseries_Panal() throws Throwable {
		   Thread.sleep(1000);
		   Actions action = new Actions(login.driver);
			WebElement MyseriesPanal = login.driver.findElement(By.xpath("//span[@class='series-name-field--series-name']"));
			action.contextClick(MyseriesPanal).perform();
			Thread.sleep(10000);
			login.driver.findElement(By.xpath("//div[@class='items-wrapper']/li[9]/span")).click();
			 
	}
	
	@And("^select the download by right click option from Myseries Panal under more option$")
	public void select_the_download_by_right_click_option_from_Myseries_Panal_under_more_option() throws Throwable {
		    Thread.sleep(1000);
		    Actions action = new Actions(login.driver);
			WebElement we = login.driver.findElement(By.xpath("//span[@class='series-name-field--series-name']"));
			action.moveToElement(we).build().perform();
			login.driver.findElement(By.xpath("//div[@class='show-context menu-icon']")).click();
			Thread.sleep(10000);
			login.driver.findElement(By.xpath("//div[@class='items-wrapper']/li[9]/span")).click();
	}
	
	@And("^select the download by right click option from Myseries Panal under under file menu option$")
	public void select_the_download_by_right_click_option_from_Myseries_Panal_under_under_file_menu_option() throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("//div[@class='header-menu-item--dropdown']/div[11]")).click();
	}
	
	
	@And("^select the download from SSP window from Myseries Panal$")
	public void select_the_download_from_SSP_window_from_Myseries_Panal() throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='series-item--main-info']")).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("	//div[@class='series-preview--header ui-draggable-handle']/div[2]/div[4]")).click();
	
	}

	@And("^Compare \"([^\"]*)\" exel sheet of SSP window with Actual data$")
	public void compare_exel_sheet_of_SSP_window_with_Actual_data(String arg1) throws Throwable {
		Thread.sleep(1000);
		user_Select_pop_up_Download_button();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='movable-modal--close']")).click();
		testcase_num=arg1;
		System.out.println("Comparing Data of " + testcase_num +  " with Actual data");
		CompareExcel.Excel();
		Thread.sleep(5000);
		File_delete.delete();
		Thread.sleep(5000);
		user_signout();
	}
	
	
	@And("^Select with timeframe no of obs end date = \"([^\"]*)\"$")
	public void select_with_timeframe_no_of_obs_end_date(String arg1) throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='insight-download-timeframe']/div[3]/div[1]/input")).click();
		Thread.sleep(4000);
		login.driver.findElement(By.xpath("//div[@class='insight-download-timeframe']/div[3]/div[1]/input")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(4000);
		login.driver.findElement(By.xpath("//div[@class='insight-download-timeframe']/div[3]/div[1]/input")).sendKeys(arg1);
		
	}	
	
	
	@Given("^User Selects the Series ID  as \"([^\"]*)\"$")
	public void user_Selects_the_Series_ID_as(String arg1) throws Throwable {
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).clear();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(arg1);
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='search-presentation-tabs ui-sortable']/div/span[2]/span")).click();
	}

	@And("^Create a table$")
	public void create_a_table() throws Throwable {
		Thread.sleep(5000);
		//login.driver.findElement(By.xpath("//ul[@class='search-series-list scrollable']/li[1]/div/a/div[2]")).click();
		login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[1]/div/div[1]/div/div/div[2]/div/div[2]/div/div[3]/div/div[2]/div/div[2]/div[1]/ul/li/a/div[2]/span")).click();
		Thread.sleep(2000);
		Robot r = new Robot();
		 r.keyPress(KeyEvent.VK_T);
		 r.keyRelease(KeyEvent.VK_T);
	}

	

	@And("^User Refresh the page$")
	public void user_Refresh_the_page() throws Throwable {
		Thread.sleep(5000);
		login.driver.navigate().refresh();
	}
	
	
}





