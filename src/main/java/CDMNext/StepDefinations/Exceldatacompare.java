package CDMNext.StepDefinations;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import CDMNext.util.CommonFunctionality;
import Javaxlxs.Last_file_download;
import Javaxlxs.File_delete;
import Javaxlxs.Last_file_download;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Exceldatacompare {
	Actions action = new Actions(login.driver);
	private static Boolean logged = false;
	public static String testcase_num;
	public static String Seriesname;
	public static String r;
	public static String multipleseries;
	public static String format;
	WebElement element;
	// boolean isChecked;
	private String isChecked;
	private WebElement e;

	/*
	 * @And("^User has successful logged in$") public void
	 * user_has_successful_logged_in() throws Throwable { if (login.logged_in =
	 * false) { login.Invoke_browser(); login.application_login(); } else if
	 * (login.logged_in = true && !Exceldatacompare.logged) {
	 * login.application_login(); Exceldatacompare.logged = true; } else {
	 * System.out.println("Already Loggedin...Continue....!!!!"); }
	 * 
	 * login.Invoke_browser(); login.application_login(); }
	 */

	// TC_01
	@And("^User Select Series ID  as \"([^\"]*)\"$")
	public void user_Select_Series_ID_as(String arg2) throws Throwable {

		Thread.sleep(2000);
		// Myseries.delete_series();
		Thread.sleep(2000);
		// click on search bar
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).click();
		Thread.sleep(1000);
		// clear on search bar
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).clear();

		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(arg2);
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		Thread.sleep(5000);
		// click on series
		login.driver.findElement(By.xpath("(//*[@class='toggler-control-item--label'])[2]")).click();
		Thread.sleep(3000);

		// checked check box
		login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[1]")).click();
		Thread.sleep(3000);

		// click on + icon
		login.driver.findElement(By.xpath("(//div[@class='add-to-data-selection--icon'])[1]")).click();

		/*
		 * try { Thread.sleep(5000);
		 * 
		 * // click on series login.driver.findElement(By.xpath(
		 * "(//*[@class='toggler-control-item--label'])[2]")).click();
		 * 
		 * Thread.sleep(5000);
		 * 
		 * List<WebElement> series = login.driver .findElements(By.
		 * xpath("//*[@class='series-list-item--checkbox svg-checkbox']"));
		 * 
		 * for (WebElement seri : series) {
		 * 
		 * // checked check box login.driver.findElement(By.
		 * xpath("//*[@class='series-list-item--checkbox svg-checkbox']")).click();
		 * Thread.sleep(3000);
		 * 
		 * }
		 * 
		 * // checked check box login.driver.findElement(By.
		 * xpath("//*[@class='series-list-item--checkbox svg-checkbox']")).click();
		 * Thread.sleep(3000);
		 * 
		 * // click on + icon login.driver.findElement(By.xpath(
		 * "(//div[@class='add-to-data-selection--icon'])[1]")).click();
		 * 
		 * // login.driver.findElement(By.xpath(
		 * "//div[@class='add-to-data-selection--icon']")).click(); Thread.sleep(2000);
		 * get_the_Series_name(); System.out.println(
		 * "==========================>first line Execution completed=====================================>"
		 * );
		 * 
		 * } catch (org.openqa.selenium.StaleElementReferenceException ex) {
		 * 
		 * Thread.sleep(2000); // click on series login.driver.findElement(By.xpath(
		 * "(//*[@class='toggler-control-item--label'])[2]")).click(); //checked check
		 * box login.driver.findElement(By.
		 * xpath("//*[@class='series-list-item--checkbox svg-checkbox']")).click();
		 * Thread.sleep(3000);
		 * 
		 * //click on + icon login.driver.findElement(By.xpath(
		 * "(//div[@class='add-to-data-selection--icon'])[1]")).click();
		 * 
		 * // login.driver.findElement(By.xpath(
		 * "//div[@class='add-to-data-selection--icon']")).click(); Thread.sleep(2000);
		 * get_the_Series_name(); System.out.
		 * println("==========================>first line Execution completed=====================================>"
		 * );
		 * 
		 * }
		 */
	}

	@And("^User  Download button$")
	public void user_Download_button() throws Throwable {
		Thread.sleep(6000);
		login.driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[1]/div/div[4]/div/button[1]/span[2]"))
				.click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Range')]")).click();
		Thread.sleep(5000);
		user_Select_Reset_button();
		Thread.sleep(2000);
		// login.driver.findElement(By.xpath("//div[@class='download-fast-settings--section-content
		// download-fast-settings--section-content__checkbox']/label/span[1]")).click();
	}

	// TC_01
	@And("^Select Download button$")
	public void select_Download_button() throws Throwable {
		Thread.sleep(5000);

		login.driver.findElement(By.xpath("//span[@class='download-button--text drop-down-button--label']")).click();
		// span[@class='download-button--text drop-down-button--label']
		Thread.sleep(2000);

		// if(login.driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).isDisplayed())
		// {
		// login.driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
		// }
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//span[contains(text(),'Range')]")).click();
		Thread.sleep(4000);
		user_Select_Reset_button();
		// Thread.sleep(4000);
		// login.driver.findElement(By.xpath("//div[@class='download-fast-settings--section-content
		// download-fast-settings--section-content__checkbox']/label/span[1]")).click();
	}

	@Given("^get the Series name$")
	public void get_the_Series_name() throws Throwable {

		Seriesname = login.driver.findElement(By.xpath("//div[@class='series-item--name']")).getText();
		r = Seriesname.replace(":", "");
		System.out.println(r);
	}

	@And("^User(\\d+) Select the \"([^\"]*)\"$")
	public void user_Select_the(int arg1, String arg2) throws Throwable {
		testcase_num = arg2;
		System.out.println("test case is " + testcase_num);
	}

	@And("^Select Automic button$")
	public void Select_Automic_button() throws Throwable {
		Thread.sleep(2500);
		login.driver
				.findElement(By.xpath(
						"//div[@class='insight-download-advanced-settings']/div[1]/div[5]/div[2]/div/div[1]/div[2]"))
				.click();
		Thread.sleep(2500);
		login.driver.findElement(By.xpath("/html/body/ul/div[3]/li[1]/div/label/span[2]")).click();

	}

	@And("^User1 Select pop up Download button$")
	public void user_Select_pop_up_Download_button() throws Throwable {
		WebElement element = login.driver
				.findElement(By.xpath("//div[@class='sphere-modal-controls']/div[3]/button[4]/span"));
		Actions action = new Actions(login.driver);
		Thread.sleep(5000);
		action.moveToElement(element).click().perform();
	}

	@And("^User1 Compare exel sheet$")
	public void user_Compare_exel_sheet() throws Throwable {
		Thread.sleep(10000);
		System.out.println("Comparing Data in Two Exel Sheets");
		// CompareExcel.Excel();
	}

	@And("^Compare \"([^\"]*)\" exel sheet with Actual data$")
	public void user_Compare_exel_sheet_with_Actual_data(String arg2) throws Throwable {
		try {
			user_Select_pop_up_Download_button();
			Thread.sleep(15000);
			testcase_num = arg2;

			List<WebElement> totalseries = login.driver.findElements(By.xpath("//div[@class='series-item--name']"));
			System.out.println("Total Size are- " + totalseries.size());

			if (totalseries.size() == 1) {

				/*
				 * System.out.println("Comparing Data of " + testcase_num + " with Actual data"
				 * + Seriesname ); Thread.sleep(8000); CompareExcel.Excel();
				 * Thread.sleep(18000); File file = new File(System.getProperty("user.home") +
				 * "\\Downloads\\"+r+".xlsx"); if(file.delete()){
				 * System.out.println(file.getName() + " is deleted!"); }else{
				 * //System.out.println("Delete operation is failed."); }
				 */
				// Thread.sleep(8000);
				// user_signout();
			}

			else {

				System.out.println("Comparing Data of " + testcase_num + " with Actual data" + multipleseries);
				/*
				 * Thread.sleep(8000); multipleseriesExcelcompare(); Thread.sleep(18000);
				 * 
				 * File file = new File(System.getProperty("user.home") +
				 * "\\Downloads\\Name your insight.xlsx");
				 * 
				 * if(file.delete()){ System.out.println(file.getName() + " is deleted!");
				 * }else{ //System.out.println("Delete operation is failed."); }
				 */
				// Thread.sleep(8000);
				// user_signout();
			}
			Thread.sleep(8000);
			// user_signout();

		} catch (Exception E) {
			System.out.println("Entered to catch" + E.getMessage());
		}
	}

	@And("^Select Custom button$")
	public void Select_Custom_button() throws Throwable {
		Thread.sleep(2500);
		login.driver
				.findElement(By.xpath(
						"//div[@class='insight-download-advanced-settings']/div[1]/div[5]/div[2]/div/div[1]/div[2]"))
				.click();
		Thread.sleep(6000);
		login.driver.findElement(By.xpath("/html/body/ul/div[3]/li[2]/div/label/span[2]")).click();
	}

	@And("^User signout$")
	public void user_signout() throws Throwable {

		CommonFunctionality.DeleteSeries();
		// CommonFunctionality.Views_list();
		/*
		 * Thread.sleep(500); if(login.driver.findElements(By.xpath(
		 * "//span[@class='series-name-field-title']")).size() != 0){
		 * login.driver.findElement(By.xpath(
		 * "//div[@class='insight-series-container']/div/div/div/div/label/span")).click
		 * (); Thread.sleep(1000); login.driver.findElement(By.
		 * xpath("//div[@class='data-action-panel insight-action-panel']/div[7]")).click
		 * (); }
		 */
	}

	@And("^User(\\d+) Select date format$")
	public void user_Select_date_format(int arg1) throws Throwable {
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("//div/i[@class='format-example__edit-icon']")).click();

	}

	@And("^Select format input	\"([^\"]*)\"$")
	public void Select_format_input(String formatinput) throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(
				"//ul[@class='dropdown-menu context-menu date-format--context-menu']/div[3]/li[2]/div/div/div[1]/input"))
				.click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(
				"//ul[@class='dropdown-menu context-menu date-format--context-menu']/div[3]/li[2]/div/div/div[1]/input"))
				.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(
				"//ul[@class='dropdown-menu context-menu date-format--context-menu']/div[3]/li[2]/div/div/div[1]/input"))
				.sendKeys(formatinput);

	}

	@And("^User Select Decimal drop down$")
	public void user_Select_Decimal_drop_down() throws Throwable {
		Thread.sleep(10000);
		login.driver
				.findElement(
						By.xpath("//div[@class='insight-download-advanced-settings']/div/div[6]/div[2]/a/span[2]/b"))
				.click();
	}

	@And("^User Select Reset button$")
	public void user_Select_Reset_button() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//button[contains(text(),'Reset')]")).click();
	}

	@Given("^Select Decimal input as \"([^\"]*)\"$")
	public void select_Decimal_input_as(String arg1) throws Throwable {
		Thread.sleep(1000);
		user_Select_Decimal_drop_down();
		Thread.sleep(1000);
		if (arg1.equalsIgnoreCase("0")) {

			login.driver.findElement(By.xpath("//ul[@class='select2-results']/li[1]/div/div")).click();
		} else if (arg1.equalsIgnoreCase("8")) {

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
		login.driver.findElement(By.xpath("//div[@class='choosable-selected-item__close']")).click();
	}

	@And("^Select Filter out dates with no observations$")
	public void Select_Filter_out_dates_with_no_observations() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//*[@class='blank-observations']//*[@class='context-menu-control--icon']"))
				.click();
		Thread.sleep(2000);

		if (login.driver.findElements(By.xpath(
				"//*[@class='custom-select-item custom-select-item__selected']//*[contains(text(),'Filter out dates with no observations')]"))
				.size() == 1) {

			System.out.println("Alrady Filter out dates with no observations selected");
		} else {

			login.driver.findElement(By.xpath(
					"//*[@class='custom-select-item']//*[@class='custom-select-item--link text-dots']//*[contains(text(),'Filter out dates with no observations')]"))
					.click();

		}

		// login.driver.findElement(By.xpath(
		// "//div[@class='custom-select--body']/div[1]")).click();
		// login.driver.findElement(By.xpath("//div[@class='custom-select-title
		// custom-select-title__no-max-width']/div/span[2]")).click();
		Thread.sleep(2000);
	}

	@And("^Select the Selected Attributes$")
	public void Select_the_Selected_Attributes() throws Throwable {

		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//div[@class='cool-multi-select--input choosable-search-input']")).click();
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//div[@class='cool-multi-select--select-all-btn']")).click();
		Thread.sleep(2000);
		List<WebElement> objLinks = login.driver.findElements(By.xpath("//div[@class='choosable-list']/div"));
		System.out.println("Total Size are- " + objLinks.size());

		for (int i = 2; i <= 12; i++) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(
					"(//div[@class='choosable-list']//span[@class='cool-multi-select--list-item-label'])[" + i + "]"))
					.click();
		}
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='cool-multi-select--input choosable-search-input']")).click();

	}

	@And("^Select Leave as Blank$")
	public void Select_Leave_as_Blank() throws Throwable {

		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//*[@class='blank-observations']//*[@class='context-menu-control--icon']"))
				.click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(
				"//*[@class='custom-select-item']//*[@class='custom-select-item--link text-dots']//*[contains(text(),'Leave as blank')]"))
				.click();
	}

	@And("^Select All button$")
	public void Select_All_button() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_Timeframe"))).click();

	}

	@And("^User(\\d+) Select Custom date format$")
	public void user_Select_Custom_date_format(int arg1) throws Throwable {
		Thread.sleep(2500);
		login.driver
				.findElement(By.xpath(
						"//div[@class='insight-download-advanced-settings']/div[1]/div[5]/div[2]/div/div[1]/div[2]"))
				.click();
		Thread.sleep(6000);
		login.driver.findElement(By.xpath("/html/body/ul/div[3]/li[2]/div/label/span[2]")).click();
	}

	@And("^Select Custom date input as \"([^\"]*)\"$")
	public void Select_Custom_date_input_as(String arg2) throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(
				"//ul[@class='dropdown-menu context-menu date-format--context-menu']/div[3]/li[2]/div/div/div[1]/input"))
				.click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(
				"//ul[@class='dropdown-menu context-menu date-format--context-menu']/div[3]/li[2]/div/div/div[1]/input"))
				.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(
				"//ul[@class='dropdown-menu context-menu date-format--context-menu']/div[3]/li[2]/div/div/div[1]/input"))
				.sendKeys(arg2);
	}

	@And("^User(\\d+) Select All Attributes$")
	public void user_Select_All_Attributes(int arg1) throws Throwable {
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("//div[@class='cool-multi-select--input choosable-search-input']")).click();
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("//div[@class='cool-multi-select--select-all-btn']")).click();
	}

	@And("^Select the Function as YTD$")
	public void select_the_Function_as_YTD() throws Throwable {

		Thread.sleep(5000);
		// System.out.println("==================>Select function
		// as=================>"+arg2);
		login.driver.findElement(By.xpath("//div[@class='download-data-transformation']/div//div[4]")).click();
		// div[@class='download-data-transformation']/div/div[4]/div//div[2]
		// div[@class='download-data-transformation']/div/div[4]/div//div[2]
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//*[contains(text(),'All functions')]")).click();
		Thread.sleep(5000);
		// System.out.println("===========>Select function as=================>"+arg2);
		login.driver.findElement(By.xpath("//input[@class='form--control search-functions-input']")).sendKeys("YTD");
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='function-item']")).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//button[contains (text(),'Insert function')]")).click();
	}

	@And("^Select the Function as \"([^\"]*)\"$")
	public void Select_the_Function_as(String arg2) throws Throwable {
		Thread.sleep(5000);
		System.out.println("==================>Select function as=================>" + arg2);
		login.driver.findElement(By.xpath("//div[@title='More functions']")).click();

		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//*[contains(text(),'All functions')]")).click();
		Thread.sleep(5000);
		System.out.println("===========>Select function as=================>" + arg2);
		login.driver.findElement(By.xpath("//input[@class='form--control search-functions-input']")).sendKeys(arg2);
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='function-item']")).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//button[contains (text(),'Insert function')]")).click();

	}

	@And("^select the Replace selected series option$")
	public void select_the_Replace_selected_series_option() throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Replace selected series')]")).click();

	}

	@And("^Select the Start Date as \"([^\"]*)\" and End Date \"([^\"]*)\"$")
	public void Select_the_Start_Date_as_and_End_Date(String arg2, String arg3) throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Range')]")).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//input[@class='form--control input-date-start']")).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//input[@class='form--control input-date-start']"))
				.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//input[@class='form--control input-date-start']")).sendKeys(arg2);
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//input[@class='form--control input-date-end']")).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//input[@class='form--control input-date-end']"))
				.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//input[@class='form--control input-date-end']")).sendKeys(arg3);
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//td[text()='31']")).click();
		System.out.println(arg3);

//		if(arg3.equalsIgnoreCase("2001-01-01" )){
//			login.driver.findElement(By.xpath("//td[@class='active day']")).click();
//			
//		}else if(arg3.equalsIgnoreCase("No end date")){
//			
//			login.driver.findElement(By.xpath("//button[@class='insight-download-datepicker-custom-button']")).click();
//		}else if(arg3.equalsIgnoreCase("2004-01-01")){
//			
//			login.driver.findElement(By.xpath("(//td[contains(text(),'1')])[2]")).click();
//		}
//		else{
//		login.driver.findElement(By.xpath("//td[contains(text(),'31')]")).click();
//		}

	}

	@And("^Select the Parameters$")
	public void Select_the_Parameters() throws Throwable {
		System.out.println("=============>Enter into Select the parameters=========================>");
		Thread.sleep(1000);
		login.driver
				.findElement(By
						.xpath("//div[@class='function-data--description function-data--parameters']/div[1]//a/span/b"))
				.click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//ul[@class='select2-results']/li[2]")).click();
		Thread.sleep(1000);
		login.driver
				.findElement(By
						.xpath("//div[@class='function-data--description function-data--parameters']/div[3]//a/span/b"))
				.click();
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
		login.driver
				.findElement(By.xpath("//div[@class='choosable-selected-item choosable-selected-item--small-purple']"))
				.click();
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
		Thread.sleep(1000);
	}

	@And("^Select Fill with NA$")
	public void Select_Fill_with_NA() throws Throwable {

		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//*[@class='blank-observations']//*[@class='context-menu-control--icon']"))
				.click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(
				"//*[@class='custom-select-item']//*[@class='custom-select-item--link text-dots']//*[contains(text(),'Fill with #N/A')]"))
				.click();

		// Thread.sleep(2000);

		// login.driver.findElement(By.xpath("//div[@class='custom-select-title
		// custom-select-title__no-max-width']/div/span[2]")).click();
		// Thread.sleep(2000);
		// login.driver.findElement(By.xpath(
		// "//div[@class='custom-select--body']/div[3]")).click();
	}

	@Given("^Deselect last observation date and time$")
	public void Deselect_last_observation_date_and_time() throws Throwable {
		Thread.sleep(5000);
		login.driver
				.findElement(By.xpath("//div[@class='choosable-selected-item choosable-selected-item--small-purple']"))
				.click();
		Thread.sleep(10000);
		login.driver
				.findElement(By.xpath("//div[@class='choosable-list ps-container ps-theme-default']/div[11]/span[1]"))
				.click();
		Thread.sleep(10000);
		login.driver
				.findElement(By.xpath("//div[@class='choosable-list ps-container ps-theme-default']/div[12]/span[1]"))
				.click();
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
		if (arg2.equalsIgnoreCase("SUM")) {
			login.driver.findElement(By.xpath("//div[@class='function-item selected']")).click();
		} else {
			login.driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[4]/div[2]/div[2]/div/div/div[2]/div/div[2]/div[1]/div/div/div[3]/div[2]/div[1]/div/div/div/label/span"))
					.click();
		}
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//button[contains (text(),'Insert function')]")).click();

	}

	// TC_01
	@And("^Select Date drop down$")
	public void select_Date_drop_down() throws Throwable {
		Thread.sleep(3000);
		login.driver
				.findElement(By.xpath(
						"//div[@class='insight-download-advanced-settings']/div[1]/div[5]/div[2]/div/div[1]/div[2]"))
				.click();

	}

	// TC_01
	@Then("^Automatic and Custom Date drop down should be available$")
	public void automatic_and_Custom_Date_drop_down_should_be_available() throws Throwable {
		Thread.sleep(3000);
		WebElement Dateformatdropdown = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("Dateformatdropdown")));
		Assert.assertEquals(true, Dateformatdropdown.isDisplayed());
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		user_signout();
	}

	@Then("^default decimal place to be as (\\d+)$")
	public void default_decimal_place_to_be_as(int arg1) throws Throwable {

		if (login.driver.findElements(By.xpath("//span/div[contains(text(),'3')]")).size() != 0) {
			System.out.println("Default Decimal value is 3 .");
		} else {
			Assert.fail("Default Decimal value is NOT 3 and It's BUG.");
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
		Assert.assertEquals(true, zerodecimal.isDisplayed());
		WebElement onedecimal = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("onedecimal")));
		Assert.assertEquals(true, onedecimal.isDisplayed());
		WebElement twodecimal = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("twodecimal")));
		Assert.assertEquals(true, twodecimal.isDisplayed());
		WebElement threedecimal = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("threedecimal")));
		Assert.assertEquals(true, threedecimal.isDisplayed());
		WebElement fourdecimal = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("fourdecimal")));
		Assert.assertEquals(true, fourdecimal.isDisplayed());
		WebElement fivedecimal = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("fivedecimal")));
		Assert.assertEquals(true, fivedecimal.isDisplayed());
		WebElement sixdecimal = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("sixdecimal")));
		Assert.assertEquals(true, sixdecimal.isDisplayed());
		WebElement sevendecimal = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("sevendecimal")));
		Assert.assertEquals(true, sevendecimal.isDisplayed());
		WebElement eightdecimal = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("eightdecimal")));
		Assert.assertEquals(true, eightdecimal.isDisplayed());
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//ul[@class='select2-results']/li[4]/div/div")).click();
		login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		user_signout();

	}

	@Then("^Adjust column and wrap text option should be present$")
	public void adjust_column_and_wrap_text_option_should_be_present() throws Throwable {
		Thread.sleep(5000);
		WebElement Adjustcolumnno = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Adjustcolumnno")));
		Assert.assertEquals(true, Adjustcolumnno.isDisplayed());
		WebElement Adjustcolumnwrap = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("Adjustcolumnwrap")));
		Assert.assertEquals(true, Adjustcolumnwrap.isDisplayed());
		login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		user_signout();
	}

	@Then("^Create a chart with series is available$")
	public void create_a_chart_with_series_is_available() throws Throwable {
		Thread.sleep(5000);
		WebElement Createchart = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Createchart")));
		Assert.assertEquals(true, Createchart.isDisplayed());
		login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		user_signout();
	}

	@Then("^Ascending and  Descending date order radio buttons should be present$")
	public void ascending_and_Descending_date_order_radio_buttons_should_be_present() throws Throwable {
		Thread.sleep(5000);
		WebElement Ascending = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ascending")));
		Assert.assertEquals(true, Ascending.isDisplayed());
		WebElement Descending = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Descending")));
		Assert.assertEquals(true, Descending.isDisplayed());
		login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		user_signout();
	}

	@Then("^Columns and Rows radio buttons should be present$")
	public void columns_and_Rows_radio_buttons_should_be_present() throws Throwable {
		Thread.sleep(5000);
		WebElement Columns = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Columns")));
		Assert.assertEquals(true, Columns.isDisplayed());
		WebElement Rows = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rows")));
		Assert.assertEquals(true, Rows.isDisplayed());
		login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		user_signout();
	}

	@Then("^ADD function  button should be present$")
	public void add_function_button_should_be_present() throws Throwable {
		Thread.sleep(5000);
		WebElement ADDfunc = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ADDfunc")));
		Assert.assertEquals(true, ADDfunc.isDisplayed());
		login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		user_signout();
	}

	@Then("^Blank Observations  with THREE options should be present$")
	public void blank_Observations_with_THREE_options_should_be_present() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//*[@class='blank-observations']//*[@class='context-menu-control--icon']"))
				.click();
		Thread.sleep(5000);
		WebElement noobservations = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("noobservations")));
		Assert.assertEquals(true, noobservations.isDisplayed());
		WebElement Leaveasblank = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Leaveasblank")));
		Assert.assertEquals(true, Leaveasblank.isDisplayed());
		WebElement FillNA = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("FillNA")));
		Assert.assertEquals(true, FillNA.isDisplayed());
		Thread.sleep(2000);
		// login.driver.findElement(By.xpath("(//div[@class='dropdown--button
		// dropdown--button__bordered'])/div/div/span[2]")).click();
		login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		user_signout();
	}

	@Then("^Ask me about Export settings options should be present$")
	public void ask_me_about_Export_settings_options_should_be_present() throws Throwable {
		Thread.sleep(2000);
		WebElement Askmebtn = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Askmebtn")));
		Assert.assertEquals(true, Askmebtn.isDisplayed());
		login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		user_signout();
	}

	@Then("^A pop message with message as The excel file is being generated\\.your download will start in a few seconds\" should appear each time as default\\.$")
	public void a_pop_message_with_message_as_The_excel_file_is_being_generated_your_download_will_start_in_a_few_seconds_should_appear_each_time_as_default()
			throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div[2]/div[2]/button[4]/span"))
				.click();
		Thread.sleep(1000);
		WebElement Downloadpopup = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Downloadpopup")));
		Assert.assertEquals(true, Downloadpopup.isDisplayed());
		Thread.sleep(70000);
		File_delete.delete();
		user_signout();

	}

	@Then("^All attributes are selected and show date column is also selected by default$")
	public void all_attributes_are_selected_and_show_date_column_is_also_selected_by_default() throws Throwable {
		Thread.sleep(2000);
		WebElement Allattributes = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Allattributes")));
		Assert.assertEquals(true, Allattributes.isDisplayed());
		WebElement showdatecoloum = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("showdatecoloum")));
		Assert.assertEquals(true, showdatecoloum.isDisplayed());
		login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		user_signout();
	}

	@Then("^ALL Timeframe options should be present$")
	public void all_Timeframe_options_should_be_present() throws Throwable {
		Thread.sleep(2000);
		WebElement Range = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Range")));
		Assert.assertEquals(true, Range.isDisplayed());
		WebElement Sample = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sample")));
		Assert.assertEquals(true, Sample.isDisplayed());
		login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		user_signout();
	}

	@Then("^Sample=(\\d+) should be the default timeframe option$")
	public void sample_should_be_the_default_timeframe_option(int arg1) throws Throwable {
		Thread.sleep(2000);
		WebElement Sample10 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sample10")));
		Assert.assertEquals(true, Sample10.isDisplayed());
		login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		user_signout();
	}

	@And("^Verify Data referesh option is checked by deault$")
	public void verify_Data_referesh_option_is_checked_by_deault() throws Throwable {
		Thread.sleep(2000);
		boolean element = login.driver
				.findElement(By.xpath("//div[@class='insight-download-formats']/div[3]/div[2]/label/input"))
				.isSelected();
		Thread.sleep(2000);
		if (element == true) {
			System.out.println("Data Refresh is checked" + element);
			login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			user_signout();
		} else {
			Assert.fail("Data Refresh is NOT checked by default");
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
		login.driver
				.findElement(By.xpath("//div[@class='choosable-selected-item choosable-selected-item--small-purple']"))
				.click();
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
		login.driver
				.findElement(By.xpath("//div[@class='choosable-selected-item choosable-selected-item--small-purple']"))
				.click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='choosable-list']/div[1]/span[1]")).click();
		List<WebElement> objLinks = login.driver.findElements(By.xpath("//div[@class='choosable-list']/div"));
		System.out.println("Total Size are- " + objLinks.size());

		for (int i = 1; i <= 12; i++) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@class='choosable-list']/div[" + i + "]/span[1]")).click();
		}
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='choosable-list']/div[17]/span[1]")).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='cool-multi-select--input choosable-search-input']")).click();

	}

	@And("^Add to Right panel$")
	public void add_to_Right_panel() throws Throwable {
		Thread.sleep(2000);

		List<WebElement> objLinks = login.driver.findElements(By.xpath("//a[@class='series-list-item--container']"));

		System.out.println("Total Size are- " + objLinks.size());

		for (int i = 1; i <= objLinks.size(); i++) {
			Thread.sleep(2000);

			login.driver.findElement(By.xpath("(//*[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]"))
					.click();
			// login.driver.findElement(By.xpath("//ul[@class='search-series-list
			// scrollable']/li[" + i + "]/div/a/div[2]")).click();
		}
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("(//*[@class='add-to-data-selection--icon'])[1]")).click();
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
		Thread.sleep(8000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).clear();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(arg1);
		Thread.sleep(8000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(Keys.ENTER);

		Thread.sleep(5000);

		login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
	}

	@And("^Create a Table$")
	public void create_a_Table() throws Throwable {
		Thread.sleep(3000);
		List<WebElement> objLinks = login.driver.findElements(By.xpath("//a[@class='series-list-item--container']"));
		System.out.println("Total Size are--> " + objLinks.size());

		for (int i = 1; i <= objLinks.size(); i++) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("(//*[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]"))
					.click();
		}

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_T);

	}

	@And("^Select Download Button$")
	public void select_Download_Button() throws Throwable {
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("//span[@class='download-button--text drop-down-button--label']")).click();
	}

	@Then("^Tabel download should be Sucess$")
	public void tabel_download_should_be_Sucess() throws Throwable {
		Thread.sleep(2000);
		user_Select_pop_up_Download_button();
		Thread.sleep(2000);
		CommonFunctionality.DeleteVisual();
		user_signout();
		Last_file_download.getTheNewestFile();
	}

	@And("^Create a Chart$")
	public void create_a_Chart() throws Throwable {
		Thread.sleep(2000);
		List<WebElement> objLinks = login.driver.findElements(By.xpath("//a[@class='series-list-item--container']"));
		System.out.println("Total Size are- " + objLinks.size());

		for (int i = 1; i <= objLinks.size(); i++) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("(//*[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]"))
					.click();
		}

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_C);
	}

	@And("^Create a Map$")
	public void create_a_Map() throws Throwable {
		Thread.sleep(2000);

		List<WebElement> objLinks = login.driver.findElements(By.xpath("//a[@class='series-list-item--container']"));
		System.out.println("Total Size are- " + objLinks.size());

		for (int i = 1; i <= objLinks.size(); i++) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("(//*[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]"))
					.click();

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
		CommonFunctionality.DeleteVisual();
		user_signout();
		Last_file_download.getTheNewestFile();
	}

	@Given("^Create a HeatMap$")
	public void create_a_HeatMap() throws Throwable {
		Thread.sleep(2000);

		List<WebElement> objLinks = login.driver.findElements(By.xpath("//a[@class='series-list-item--container']"));
		System.out.println("Total Size are- " + objLinks.size());

		for (int i = 1; i <= objLinks.size(); i++) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//ul[@class='search-series-list']/li[" + i + "]/div/a/div[2]")).click();
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
		CommonFunctionality.DeleteVisual();
		user_signout();
		Last_file_download.getTheNewestFile();
	}

	@And("^Chart download should be Sucess$")
	public void chart_download_should_be_Sucess() throws Throwable {
		Thread.sleep(2000);
		user_Select_pop_up_Download_button();
		Thread.sleep(2000);
		CommonFunctionality.DeleteVisual();
		user_signout();
		Last_file_download.getTheNewestFile();
	}

	@And("^select the \"([^\"]*)\" format$")
	public void select_the_format(String arg1) throws Throwable {
		format = arg1;
		System.out.println("==================>Formate type==============>" + arg1);
		Thread.sleep(2000);
		switch (arg1) {
		case "png":
			Thread.sleep(3000);
			login.driver.findElement(By.xpath("//label[@title='Download visual to PNG image']")).click();
			break;

		case "jpeg":
			Thread.sleep(3000);
			login.driver.findElement(By.xpath("//label[@title='Download visual to JPG image']")).click();
			break;
		case "csv":
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CSV_Format"))).click();
			break;
		case "xlsx":
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("XLS_Format"))).click();
			break;
		case "pdf":
			Thread.sleep(2000);
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
		action.moveToElement(
				login.driver.findElement(By.xpath("//div[@class='search-presentation-tabs--visible']/span[4]")))
				.doubleClick().perform();
		Thread.sleep(6000);
		login.driver.findElement(By.xpath("//*[@class='name-text'][contains (text(), '" + "Global Database"
				+ "')]/../../../../div[@class='toggle']")).click();
		Thread.sleep(6000);
		login.driver.findElement(By.xpath("//*[@class='name-text'][contains (text(), '" + "All Countries"
				+ "')]/../../../../div[@class='toggle']")).click();
		Thread.sleep(6000);
		login.driver.findElement(By.xpath(
				"//*[@class='name-text'][contains (text(), '" + "Albania" + "')]/../../../../div[@class='toggle']"))
				.click();

		Thread.sleep(6000);
		login.driver.findElement(By.xpath("//*[@class='name-text'][contains (text(), '" + "Albania: Balance of Payments"
				+ "')]/../../../../div[@class='toggle']")).click();

		JavascriptExecutor jse = (JavascriptExecutor) login.driver;

		element = login.driver.findElement(By.xpath("//div[@class='tree-node open']/div/div/div/div[10]"));
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
		WebElement ThreeThousandSeries = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("ThreeThousandSeries")));
		Assert.assertEquals(true, ThreeThousandSeries.isDisplayed());
		Thread.sleep(50000);
		login.driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div[2]/div[2]/button[4]/span"))
				.click();
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
		testcase_num = arg1;
		System.out.println("Comparing Data of " + testcase_num + " with Actual data");
		CompareExcel.Excel();
		Thread.sleep(5000);
		File_delete.delete();
		Thread.sleep(5000);
		user_signout();
	}

	@And("^Reset button should Successfully work$")
	public void reset_button_should_Successfully_work() throws Throwable {

		Thread.sleep(2000);
		user_Select_Reset_button();
		Thread.sleep(2000);
		boolean Reset = login.driver
				.findElement(By.xpath("//div[@class='choosable-selected-item choosable-selected-item--small-purple']"))
				.isEnabled();
		System.out.println(Reset);
		Thread.sleep(3000);
		if (Reset == true) {
			System.out.println("Reset button is working Successfully");
		} else {
			Assert.fail("Reset button is NOT Working Successfully");

		}
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
		login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[9]/div[2]"))
				.click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Add separator')]")).click();
		Thread.sleep(1500);
		Actions action = new Actions(login.driver);
		action.moveToElement(login.driver
				.findElement(By.xpath("//div[@class='insight-series-container']/div/div/div/div/label/span")))
				.doubleClick().perform();
	}

	@And("^Sucessfully verify the Cancel button$")
	public void sucessfully_verify_the_Cancel_button() throws Throwable {
		Thread.sleep(5000);
		WebElement Downloadwindowclose = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("Downloadwindowclose")));
		Assert.assertEquals(true, Downloadwindowclose.isDisplayed());
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Downloadwindowclose"))).click();
		Thread.sleep(1500);
		user_signout();
	}

	@And("^Sucessfully verify the Srcode exist or not$")
	public void sucessfully_verify_the_Srcode_exist_or_not() throws Throwable {
		Thread.sleep(2500);
		login.driver
				.findElement(By.xpath("//div[@class='choosable-selected-item choosable-selected-item--small-purple']"))
				.click();
		Thread.sleep(2500);
		WebElement SRcode = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SRcode")));
		Assert.assertEquals(true, SRcode.isDisplayed());
		Thread.sleep(2500);
		login.driver
				.findElement(By.xpath("//div[@class='choosable-selected-item choosable-selected-item--small-purple']"))
				.click();
		login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		user_signout();
	}

	@And("^Select Function button on my series panel$")
	public void select_Function_button_on_my_series_panel() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='insight-series-container']/div/div/div/div/label/span"))
				.click();
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
		login.driver.findElement(By.xpath("//div[@class='insight-series-container']/div/div/div/div/label/span"))
				.click();
	}

	@And("^series selection W\\.R\\.T both search and myseries must be Successfull$")
	public void series_selection_W_R_T_both_search_and_myseries_must_be_Successfull() throws Throwable {
		Thread.sleep(1000);
		WebElement search_series = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("search_series")));
		Assert.assertEquals(true, search_series.isDisplayed());
		Thread.sleep(1000);
		WebElement myseries_series = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("myseries_series")));
		Assert.assertEquals(true, myseries_series.isDisplayed());
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='insight-series-container']/div/div/div/div/label/span"))
				.click();
		user_signout();
	}

	@And("^User verify state of download button when there are no series in myseries/no views$")
	public void user_verify_state_of_download_button_when_there_are_no_series_in_myseries_no_views() throws Throwable {

		Thread.sleep(1000);
		if (login.driver.findElements(By.xpath(
				"//div[@class='drop-down-button download-button download-button__header drop-down-button__small']"))
				.size() != 0) {
			System.out.println("Download Button is disabled.");
		} else {
			Assert.fail("Download Button is Enabled. Series or Views may Present.");
			System.out.println("Element is Absent");
		}
	}

	@Given("^Verify label for different frequency series from \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\"$")
	public void verify_label_for_different_frequency_series_from_and(String arg1, String arg2, String arg3, String arg4,
			String arg5) throws Throwable {
		Thread.sleep(1000);
		if (arg2.equals(arg2)) {
			Actions action = new Actions(login.driver);
			WebElement element = login.driver.findElement(By.xpath("//div[@class='series-name-wrapper ']"));
			action.moveToElement(element).build().perform();
			String Text;
			Text = element.getAttribute("title");
			System.out.println(Text);
			String[] array = Text.split("\n");
			int size = array.length;
			System.out.println(size);
			for (int i = 1; i < array.length; i++) {
			}
			System.out.println(array[3]);
		}
	}

	@And("^verify the available formats$")
	public void verify_the_available_formats() throws Throwable {
		Thread.sleep(1000);
		WebElement XLS_Format = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("XLS_Format")));
		Assert.assertEquals(true, XLS_Format.isDisplayed());
		Thread.sleep(1000);
		WebElement PDF_Format = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("PDF_Format")));
		Assert.assertEquals(true, PDF_Format.isDisplayed());
		Thread.sleep(1000);
		WebElement PNG_Format = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("PNG_Format")));
		Assert.assertEquals(true, PNG_Format.isDisplayed());
		Thread.sleep(1000);
		WebElement JPG_Format = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("JPG_Format")));
		Assert.assertEquals(true, JPG_Format.isDisplayed());
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();

		Thread.sleep(5000);

		CommonFunctionality.Views_list();
		/*
		 * Actions action = new Actions(login.driver); WebElement we =
		 * login.driver.findElement(By.
		 * xpath("//div[@class='insight-page-menu-views-item insight-page-menu-item']/a/span[1]"
		 * )); action.moveToElement(we).build().perform();
		 * login.driver.findElement(By.xpath("//i[@class='fa fa-times']")).click();
		 * Thread.sleep(2000); login.driver.findElement(By.xpath(
		 * "/html/body/div[1]/div/div[3]/div[2]/div/div[2]/div/button[2]")).click();
		 * 
		 * login.driver.findElement(By.
		 * xpath("//a[@class='insight-page-menu-item-link active']")).click();
		 */

	}

	@And("^verify the formats available for views download$")
	public void verify_the_formats_available_for_views_download() throws Throwable {
		Thread.sleep(5000);
		// login.driver.findElement(By.xpath("//div[@class='tabs__tabs-box']/div[3]")).click();
		// Thread.sleep(1000);
		WebElement XLS_Format = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("XLS_Format")));
		Assert.assertEquals(true, XLS_Format.isDisplayed());
		Thread.sleep(1000);
		WebElement PDF_Format = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("PDF_Format")));
		Assert.assertEquals(true, PDF_Format.isDisplayed());
		Thread.sleep(9500);
		login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		Thread.sleep(6000);

		CommonFunctionality.DeleteVisual();
		user_signout();
	}

	@And("^Expand the database tree$")
	public void expand_the_database_tree() throws Throwable {
		Thread.sleep(5000);
		// login.driver.findElement(By.xpath("//span[@value='TREE']")).click();

		Thread.sleep(2000);
		login.driver.findElement(By.xpath("(//div[@class='toggle'])[1]")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("(//div[@class='toggle'])[2]")).click();
		Thread.sleep(3000);
//		login.driver.findElement(By.xpath("(//div[@class='toggle'])[3]")).click();
//		Thread.sleep(2000);
//		login.driver.findElement(By.xpath("(//div[@class='toggle'])[4]")).click();
//		Thread.sleep(2000);
//		login.driver.findElement(By.xpath("(//div[@class='toggle'])[5]")).click();
		Thread.sleep(2000);
		// login.driver.findElement(By.xpath("(//div[@class='toggle'])[6]")).click();
		Thread.sleep(2000);

		// login.driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[3]/div[1]/div[3]/div[1]/div[3]/div[1]/div[1]")).click();
		// Thread.sleep(2000);

		// WebElement
		// seriesname=login.driver.findElement(By.xpath("//div[contains(text(),'Agriculture
		// Output Value: Other Crops: Misc: Assam')]"));

		// action.pause(500).moveToElement(seriesname).build().perform();
		// Thread.sleep(2000);
		// WebElement elementLocator11 = login.driver.findElement(By.xpath(""));
		// action.contextClick(elementLocator11).perform();
		Thread.sleep(1000);

		/*
		 * login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click
		 * (); Thread.sleep(5000); Actions action = new Actions(login.driver);
		 * action.moveToElement(login.driver.findElement(By.
		 * xpath("//div[@class='search-presentation--header series-panel']/div[1]/div/div/span[4]/span"
		 * ))).doubleClick().build().perform(); Thread.sleep(2000);
		 * login.driver.findElement(By.xpath(
		 * "//div[@class='child-container']/div/div/div/div/div/div[3]/div/div[1]")).
		 * click(); Thread.sleep(2000); login.driver.findElement(By.xpath(
		 * "//div[@class='child-container']/div/div/div/div/div/div[3]/div/div[3]/div/div[1]"
		 * )).click(); Thread.sleep(2000); login.driver.findElement(By.xpath(
		 * "//div[@class='child-container']/div/div/div/div/div/div[3]/div/div[3]/div/div[2]/span[1]"
		 * )).click(); Thread.sleep(2000); Robot r = new Robot();
		 * r.keyPress(KeyEvent.VK_A); r.keyRelease(KeyEvent.VK_A);
		 * login.driver.findElement(By.
		 * xpath("//div[@class='insight-series-rename--button insight-series-rename--button__cancel']"
		 * )).click(); Thread.sleep(5000);
		 * login.driver.findElement(By.xpath("//span[@class='input-control--indicator']"
		 * )).click(); Thread.sleep(2000); login.driver.findElement(By.
		 * xpath("//div[@class='data-action-panel insight-action-panel']/div[10]/div[2]"
		 * )).click(); Thread.sleep(2000);
		 * login.driver.findElement(By.xpath("//span[contains(text(),'Ungroup')]")).
		 * click(); Thread.sleep(1000);
		 * login.driver.findElement(By.xpath("//span[@class='input-control--indicator']"
		 * )).click();
		 */
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
		WebElement downloadbtn = login.driver
				.findElement(By.xpath("//ul[@class='dropdown-menu context-menu ']//span[text()='Download']"));
		action.moveToElement(downloadbtn).click().build().perform();
		// action.contextClick(downloadbtn)action.click().build().perform();
		// login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu
		// ']//span[text()='Download']")).click();
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
		login.driver.findElement(By.xpath("//div[@class='series-list-item--action-icons']/span[5]")).click();
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("//div[@class='items-wrapper']/li[9]")).click();
	}

	@And("^select the download present in the File menu option$")
	public void select_the_download_present_in_the_File_menu_option() throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='insight-context-menu--menu-icon']")).click();
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("//div[@class='items-wrapper']/li[10]")).click();
	}

	@And("^select the download present from SSP window$")
	public void select_the_download_present_from_SSP_window() throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='series-item--main-info']")).click();
		Thread.sleep(8000);
		login.driver.findElement(By.xpath("(//span[contains(text(),'Download')])[2]")).click();
	}

	@And("^select the download present from Footnotes window$")
	public void select_the_download_present_from_Footnotes_window() throws Throwable {
		Thread.sleep(1000);
		Actions action1 = new Actions(login.driver);
		WebElement we = login.driver.findElement(By.xpath("//span[@class='series-name-field--series-name']"));
		action1.moveToElement(we).build().perform();
		login.driver.findElement(By.xpath("//div[@class='open-footnote menu-icon']")).click();

	}

	@Then("^Download option from Footnotes window should be Sucess$")
	public void Download_option_from_Footnotes_window_should_be_Sucess() throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//header/div[2]/div[3]/button[1]/span[1]")).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='movable-modal--close']")).click();
		Thread.sleep(3000);
		Latestfiledownload.lastFileModified();
		user_signout();
	}

	@And("^select the download by right click option from Myseries Panal$")
	public void select_the_download_by_right_click_option_from_Myseries_Panal() throws Throwable {
		Thread.sleep(1000);
		Actions action = new Actions(login.driver);
		WebElement MyseriesPanal = login.driver
				.findElement(By.xpath("//span[@class='series-name-field--series-name']"));
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
	public void select_the_download_by_right_click_option_from_Myseries_Panal_under_under_file_menu_option()
			throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='insight-context-menu--menu-icon']")).click();
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("//div[@class='items-wrapper']/li[10]")).click();
	}

	@And("^select the download from SSP window from Myseries Panal$")
	public void select_the_download_from_SSP_window_from_Myseries_Panal() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='series-item--main-info']")).click();
		Thread.sleep(8000);
		login.driver.findElement(By.xpath("(//span[contains(text(),'Download')])[2]")).click();

	}

	@And("^Compare \"([^\"]*)\" exel sheet of SSP window with Actual data$")
	public void compare_exel_sheet_of_SSP_window_with_Actual_data(String arg1) throws Throwable {

		Thread.sleep(1000);
		user_Select_pop_up_Download_button();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='movable-modal--close']")).click();
		testcase_num = arg1;
		System.out.println("Comparing Data of " + testcase_num + " with Actual data");
		CompareExcel.Excel();
		Thread.sleep(5000);
		File file = new File(System.getProperty("user.home") + "\\Downloads\\Seriesname.xlsx");
		if (file.delete()) {
			System.out.println(file.getName() + " is deleted!");
		} else {
			// System.out.println("Delete operation is failed.");
		}
		Thread.sleep(5000);
		user_signout();
	}

	@And("^Select with timeframe no of obs end date = \"([^\"]*)\"$")
	public void select_with_timeframe_no_of_obs_end_date(String arg1) throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='insight-download-timeframe']/div[3]/div[1]/input")).click();
		Thread.sleep(4000);
		login.driver.findElement(By.xpath("//div[@class='insight-download-timeframe']/div[3]/div[1]/input"))
				.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(4000);
		login.driver.findElement(By.xpath("//div[@class='insight-download-timeframe']/div[3]/div[1]/input"))
				.sendKeys(arg1);

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
		login.driver.findElement(By.xpath("//div[@class='search-presentation-tabs ui-sortable']/div/span[2]/span"))
				.click();
	}

	@And("^Create a Table(\\d+)$")
	public void create_a_Table(int arg1) throws Throwable {

		Thread.sleep(5000);
		// login.driver.findElement(By.xpath("//ul[@class='search-series-list
		// scrollable']/li[1]/div/a/div[2]")).click();
		// login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[1]/div/div[1]/div/div/div[2]/div/div[2]/div/div[3]/div/div[2]/div/div[2]/div[1]/ul/li/a/div[2]/span")).click();
		// login.driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/div[1]/a[1]/div[2]/span[1]")).click();

		WebElement series3 = login.driver
				.findElement(By.xpath("//div[contains(text(),'Retail Sales of Consumer Goods: YoY Change')]"));
		action.pause(500).moveToElement(series3).build().perform();

		// Right click
		WebElement elementLocator = login.driver
				.findElement(By.xpath("//div[contains(text(),'Retail Sales of Consumer Goods: YoY Change')]"));
		action.contextClick(elementLocator).perform();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//span[contains(text(),'View as Table')]")).click();
		Thread.sleep(2000);

	}

//	@And("^Create a table$")
//	public void create_a_table() throws Throwable {
//		Thread.sleep(5000);
//		//login.driver.findElement(By.xpath("//ul[@class='search-series-list scrollable']/li[1]/div/a/div[2]")).click();
//		//login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[1]/div/div[1]/div/div/div[2]/div/div[2]/div/div[3]/div/div[2]/div/div[2]/div[1]/ul/li/a/div[2]/span")).click();
//		//login.driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/div[1]/a[1]/div[2]/span[1]")).click();
//		
//		//Right click
//		WebElement elementLocator = login.driver.findElement(By.xpath(
//				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[5]/div[1]/a[1]/div[2]/span[1]"));
//		action.contextClick(elementLocator).perform();
//		Thread.sleep(1000);
//		login.driver.findElement(By.xpath("//span[contains(text(),'View as Table')]")).click();
//		
//		
//		Thread.sleep(2000);
//		//Robot r = new Robot();
//		// r.keyPress(KeyEvent.VK_T);
//		// r.keyRelease(KeyEvent.VK_T);
//	}

	@And("^User Refresh the page$")
	public void user_Refresh_the_page() throws Throwable {
		Thread.sleep(5000);
		login.driver.navigate().refresh();
	}

	// Excel compare multiple series

	public static void multipleseriesExcelcompare() {
		try {
			// get input excel files
			// Exceldatacompare obj= new Exceldatacompare();
			String x = Exceldatacompare.testcase_num;
			// String y=Exceldatacompare.r;
			multipleseries = "Name your insight.xlsx";
			System.out.println(x);
			System.out.println(multipleseries);
			FileInputStream excellFile1 = new FileInputStream(
					// FileInputStream excellFile1 = new FileInputStream(
					// "C:\\Users\\Admin\\Documents\\Cucumber_Project\\Cucumber_Project\\securities-cucumber-3c396d71c6ca\\Testdata\\"
					// +x+ ".xlsx");
					System.getProperty("user.dir") + "\\Testdata\\" + x + ".xlsx");
			FileInputStream excellFile2 = new FileInputStream(
					// FileInputStream excellFile2 = new FileInputStream(
					// "C:\\Users\\Admin\\Downloads\\Untitled insight.xlsx");
					System.getProperty("user.home") + "\\Downloads\\Name your insight.xlsx");

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook TestData = new XSSFWorkbook(excellFile1);
			XSSFWorkbook ActualData = new XSSFWorkbook(excellFile2);

			// Get first/desired sheet from the workbook
			XSSFSheet Testdatasheet1 = TestData.getSheetAt(0);
			XSSFSheet ActualDatasheet1 = ActualData.getSheetAt(0);

			// Compare sheets
			if (compareTwoSheets(Testdatasheet1, ActualDatasheet1)) {
				System.out.println("\n\nThe two excel sheets are Equal");
			} else {
				System.out.println("\n\nThe two excel sheets are Not Equal");
			}

			// close files
			excellFile1.close();
			excellFile2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Compare Two Sheets
	public static boolean compareTwoSheets(XSSFSheet Testdatasheet1, XSSFSheet ActualDatasheet1)
			throws InterruptedException {

		int firstRow1 = Testdatasheet1.getFirstRowNum();
		int lastRow1 = ActualDatasheet1.getLastRowNum();
		boolean equalSheets = true;
		for (int i = firstRow1; i <= lastRow1; i++) {

			System.out.println("\n\nComparing Row " + i);

			XSSFRow Testdatarows = Testdatasheet1.getRow(i);
			XSSFRow Actualdatarows = ActualDatasheet1.getRow(i);
			if (!compareTwoRows(Testdatarows, Actualdatarows)) {
				equalSheets = false;
				System.out.println("Row " + i + " - Not Equal");
				break;
			} else {
				System.out.println("Row " + i + " - Equal");
			}
		}
		return equalSheets;
	}

	// Compare Two Rows
	public static boolean compareTwoRows(XSSFRow Testdatarows, XSSFRow Actualdatarows) throws InterruptedException {

		if ((Testdatarows == null) && (Actualdatarows == null)) {
			return true;
		} else if ((Testdatarows == null) || (Actualdatarows == null)) {
			return false;
		}

		int firstCell1 = Testdatarows.getFirstCellNum();
		int lastCell1 = Testdatarows.getLastCellNum();
		boolean equalRows = true;

		// Compare all cells in a row
		for (int i = firstCell1; i <= lastCell1 - 1; i++) {
			XSSFCell Testdata_cell = Testdatarows.getCell(i);
			XSSFCell Actual_cell = Actualdatarows.getCell(i);

			if (!compareTwoCells(Testdata_cell, Actual_cell)) {
				equalRows = false;
				File_delete.delete();
				// user_signoutmultilpeseries();
				Assert.fail("Data verification failed in Downloaded Excel:-" + Testdata_cell + "' <> '" + Actual_cell
						+ "'");
				// Assert.fail( "Cell "+i+" - Not Equal" +"; Value of Testdata_cell is \""
				// +Testdata_cell + "\" - Value of Actual_cell is \"" +Actual_cell + "\"");

				System.err.println("       Cell " + i + " - Not Equal" + "; Value of Testdata_cell is \""
						+ Testdata_cell + "\" - Value of Actual_cell is \"" + Actual_cell + "\"");
				// System.out.println(" Cell "+i+" - NOt Equal");
				// break;
			} else {
				// System.out.println(" Cell "+i+" - Equal");
				System.out.println("       Cell " + i + " - Equal" + "; Value of Testdata_cell is \"" + Testdata_cell
						+ "\" - Value of Actual_cell is \"" + Actual_cell + "\"");
				// System.out.println("Actual data"+Actual_cell.getStringCellvalue());
				// System.out.println("Actual data"+Actual_cell.getStringCellValue());
			}
		}
		return equalRows;

	}

	/*
	 * private static void user_signoutmultilpeseries() throws InterruptedException
	 * { // TODO Auto-generated method stub Thread.sleep(1000);
	 * login.driver.findElement(By.xpath(
	 * "//div[@class='insight-series-container']/div/div/div/div/label/span")).click
	 * (); Thread.sleep(1000); login.driver.findElement(By.
	 * xpath("//div[@class='data-action-panel insight-action-panel']/div[7]")).click
	 * ();
	 * 
	 * }
	 */
	// Compare Two Cells
	public static boolean compareTwoCells(XSSFCell Testdata_cell, XSSFCell Actual_cell) {
		if ((Testdata_cell == null) && (Actual_cell == null)) {
			return true;
		} else if ((Testdata_cell == null) || (Actual_cell == null)) {
			return false;
		}

		boolean equalCells = false;
		int type1 = Testdata_cell.getCellType();
		int type2 = Actual_cell.getCellType();
		if (type1 == type2) {
			if (Testdata_cell.getCellStyle().equals(Actual_cell.getCellStyle())) {

				// Compare cells based on its type
				switch (Testdata_cell.getCellType()) {
				case HSSFCell.CELL_TYPE_FORMULA:
					if (Testdata_cell.getCellFormula().equals(Actual_cell.getCellFormula())) {
						equalCells = true;
					}
					break;
				case HSSFCell.CELL_TYPE_NUMERIC:
					if (Testdata_cell.getNumericCellValue() == Actual_cell.getNumericCellValue()) {
						equalCells = true;
					}
					break;
				case HSSFCell.CELL_TYPE_STRING:

					if (Testdata_cell.getStringCellValue().equals(Actual_cell.getStringCellValue())) {
						equalCells = true;
					}
					break;
				case HSSFCell.CELL_TYPE_BLANK:
					if (Actual_cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
						equalCells = true;
					}
					break;
				case HSSFCell.CELL_TYPE_BOOLEAN:
					if (Testdata_cell.getBooleanCellValue() == Actual_cell.getBooleanCellValue()) {
						equalCells = true;
					}
					break;
				case HSSFCell.CELL_TYPE_ERROR:
					if (Testdata_cell.getErrorCellValue() == Actual_cell.getErrorCellValue()) {
						equalCells = true;
					}
					break;
				default:
					if (Testdata_cell.getStringCellValue().equals(Actual_cell.getStringCellValue())) {
						// System.out.println("Testdata"+ Testdata_cell.getStringCellValue());
						// System.out.println("Actual data"+Actual_cell.getStringCellValue());
						equalCells = true;
					}
					break;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
		return equalCells;
	}

	public static void delete() {
		try {

			// File file = new File("C:\\Users\\Admin\\Downloads\\Untitled insight.xlsx");
			File file = new File(System.getProperty("user.home") + "\\Downloads\\Untitled insight.xlsx");

			if (file.delete()) {
				// System.out.println(file.getName() + " is deleted!");
			} else {
				// System.out.println("Delete operation is failed.");
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	// }

}

//}
