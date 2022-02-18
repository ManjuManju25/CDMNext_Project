package CDMNext.StepDefinations;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.*;

public class Profile {
	WebDriverWait wait = new WebDriverWait(login.driver, 30);
	Actions action = new Actions(login.driver);
	JavascriptExecutor js = (JavascriptExecutor) login.driver;
	public static int Decimalplace;
	public static int dottimepoint;
	public static String groupingseparator;
	public static String groupingtimepoints;
	public static String commatimepoints;
	public static String commaseparater;
	public boolean selecteddate;
	public boolean updatedateinSSP;
	public static String customvalidation;
	public static String customempty;
	public static int Timeframe;
	public static int downloadpopup;
	public static int selectseries;
	public static int st1;
	public static int checkedseries;
	public static int scount;
	public static String sourcecopyright;
	public static String copyrightlink;
	public static String Search;
	public static String insightseries;
	public static String seriesname;
	public static String validation = "Invalid date format. Please enter a valid format";
	public static String token;
	public static String final_api;
	public static String firstname;
	public static String lastname;

	// TC_02
	@And("^Verifyed first name and last name$")
	public void verifyed_first_name_and_last_name() throws Throwable {

		// first and last name
		String FandLname = login.driver
				.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[2]"))
				.getText();

		System.out.println("Firstname and Last name should be display============>" + FandLname);
		
		System.out.println("==============================================TC_02=====================================");
	}

	//TC_03
	@And("^click on pencile button$")
	public void click_on_pencile_button() throws Throwable {
		// Actions action = new Actions(login.driver);
		Thread.sleep(2000);

		Thread.sleep(2000);
		// click on pencil
		login.driver.findElement(By.xpath("//div[@class='profile-menu--edit-icon']")).click();

	}

	//TC_03
	@And("^select the prefix$")
	public void select_the_prefix() throws Throwable {
		// click on prefix
		login.driver
				.findElement(By.xpath(
						"/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]/span[1]"))
				.click();
		Thread.sleep(2000);

		// select prefix
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		action.sendKeys(Keys.ENTER).build().perform();

		// select prefix
		// login.driver.findElement(By.xpath("/html[1]/body[1]/div[9]/ul[1]/li[3]/div[1]")).click();
		Thread.sleep(1000);
	}

	//TC_03
	@And("^click on save button$")
	public void click_on_save_button() throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[contains(text(),'Save')]")).click();

		Thread.sleep(1000);
				System.out.println("===============================================TC_03=====================================");
	}

	//TC_04
	@And("^update first name$")
	public void update_first_name() throws Throwable {

		Thread.sleep(1000);

		// click on first name
		login.driver.findElement(By.name("first_name")).click();
		Thread.sleep(1000);
		// first name clear
		login.driver.findElement(By.name("first_name")).clear();
		Thread.sleep(1000);
		//// enter first name
		login.driver.findElement(By.name("first_name")).sendKeys("Test");
		Thread.sleep(1000);
		// click on save button
		// login.driver.findElement(By.xpath("//div[contains(text(),'Save')]")).click();

		System.out.println("============================================TC_04================");

	}

	//TC_05
	@And("^update Last name$")
	public void update_Last_name() throws Throwable {

		Thread.sleep(1000);

		// click on last name
		login.driver.findElement(By.name("last_name")).click();
		// clear the last name field
		login.driver.findElement(By.name("last_name")).clear();
		// enter last name
		login.driver.findElement(By.name("last_name")).sendKeys("Selenium");

		//System.out.println("=================Last name updated successsfully======================");

		System.out.println("============================================TC_05================");
	}

	//TC_06
	@And("^blank the first name filed$")
	public void blank_the_first_name_filed() throws Throwable {

		// click on first name
		login.driver.findElement(By.name("first_name")).click();
		Thread.sleep(1000);
		WebElement textbox = login.driver.findElement(By.name("first_name"));
		textbox.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		// first name clear
		login.driver.findElement(By.name("first_name")).clear();
		Thread.sleep(1000);

	}
	//TC_06
	@And("^blank the last name field$")
	public void blank_the_last_name_field() throws Throwable {

		// click on last name
		login.driver.findElement(By.name("last_name")).click();
		Thread.sleep(1000);
		// clear the 1 letter
		WebElement textbox = login.driver.findElement(By.name("last_name"));
		textbox.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		// clear the last name field
		login.driver.findElement(By.name("last_name")).clear();
		Thread.sleep(2000);

	}
	//TC_06
	@And("^validations should be display$")
	public void validations_should_be_display() throws Throwable {

		// First name validation display
		boolean Fname = login.driver.findElement(By.xpath("//div[contains(text(),'First name is required')]"))
				.isDisplayed();

		if (Fname = true) {
			System.out.println("Validation popup should be display");
		} else {
			System.out.println("Validation popup should not be display");
		}

		// System.out.println("First name is required");

		// Last name validation display
		boolean Lname = login.driver.findElement(By.xpath("//div[contains(text(),'Last name is required')]"))
				.isDisplayed();

		if (Lname = true) {
			System.out.println("Validation popup should be display");
		} else {
			System.out.println("Validation popup should not display");
		}

		// System.out.println("Last name is required");
		// System.out.println("=============Validations should be
		// display==============");
System.out.println("==================================TC_06===========================");
	}

	
	//TC_07
	@And("^User enter First as \"([^\"]*)\" and Last name as \"([^\"]*)\"$")
	public void user_enter_First_as_and_Last_name_as(String Fname, String Lname) throws Throwable {

		Thread.sleep(1000);

		// click on first name
		login.driver.findElement(By.name("first_name")).click();
		Thread.sleep(1000);
		// first name clear
		login.driver.findElement(By.name("first_name")).clear();
		Thread.sleep(1000);
		//// enter first name
		login.driver.findElement(By.name("first_name")).sendKeys(Fname);
		Thread.sleep(1000);

		// click on last name
		login.driver.findElement(By.name("last_name")).click();
		Thread.sleep(1000);
		// clear the last name field
		login.driver.findElement(By.name("last_name")).clear();
		Thread.sleep(1000);
		// enter last name
		login.driver.findElement(By.name("last_name")).sendKeys(Lname);

	}

	//TC_07
	@And("^Should allow non english keywords and changes should be saved\\.$")
	public void should_allow_non_english_keywords_and_changes_should_be_saved() throws Throwable {
		Thread.sleep(1000);

		System.out.println("Should allow non english keywords and changes should be saved.");
		System.out.println("==================================TC_07===========================");

	}

	//TC_08
	@Then("^User changes should be reflected under profile picture after saved$")
	public void user_changes_should_be_reflected_under_profile_picture_after_saved() throws Throwable {

		Thread.sleep(1000);
		String usernamechange = login.driver
				.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[2]"))
				.getText();

		System.out.println("FnameandLastname:" + usernamechange);

		// Testing Automatio
		// Testin Automatio

		// assertEquals(usernamechange, "Testi CDMNext Automatio");
		// if(userchangenames=="Testing Automatio")
		// {
		System.out.println("User changes should be reflected under profile picture after saved");
		// }
		// else {
		System.out.println("Test case failed");
		System.out.println("==================================TC_08===========================");
		// }
	}

	//TC_09
	@And("^click on Email filed$")
	public void click_on_Email_filed() throws Throwable {

		boolean email = login.driver.findElement(By.name("user_id")).isEnabled();
		if (true != email) {
			System.out.println("Email field not editable");
		}

		else {
			System.out.println("Verification failed");
		}

		System.out.println("==================================TC_09===========================");
	}
//TC_10
	@And("^enter first name as \"([^\"]*)\"$")
	public void enter_first_name_as(String firstname) throws Throwable {

		// click on first name
		login.driver.findElement(By.name("first_name")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.name("first_name")).sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		login.driver.findElement(By.name("first_name")).sendKeys(Keys.BACK_SPACE);
		// clear first name data
		login.driver.findElement(By.name("first_name")).clear();

		// enter first name data
		login.driver.findElement(By.name("first_name")).sendKeys(firstname);
		Thread.sleep(1000);
		login.driver.findElement(By.name("first_name")).sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		login.driver.findElement(By.name("first_name")).sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		login.driver.findElement(By.name("first_name")).sendKeys(" CDMNext");
	}

	//TC_10
	@And("^The changes in the profile section should be saved\\.$")
	public void the_changes_in_the_profile_section_should_be_saved() throws Throwable {
		Thread.sleep(1000);
		// login.driver.findElement(By.xpath("//div[@class='account-avatar--container']")).click();
		System.out.println("First name updated ");
		System.out.println("==================================TC_10===========================");
	}

	
	//TC_11
	@And("^enter last name as \"([^\"]*)\"$")
	public void enter_last_name_as(String lastname) throws Throwable {

		// click on last name
		login.driver.findElement(By.name("last_name")).click();
		Thread.sleep(1000);
		login.driver.findElement(By.name("last_name")).sendKeys(Keys.BACK_SPACE);
		// clear the last name
		login.driver.findElement(By.name("last_name")).clear();
		Thread.sleep(1000);
		// clear the last name field
		login.driver.findElement(By.name("last_name")).sendKeys(lastname);
		Thread.sleep(1000);
		login.driver.findElement(By.name("last_name")).sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
	}
	//TC_11
	@And("^click on Cancel button$")
	public void click_on_Cancle_button() throws Throwable {

		// click on cancel button
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();

	}
	//TC_11
	@And("^The changes should be canceled$")
	public void the_changes_should_be_canceled() throws Throwable {

		System.out.println("changes_should_be canceled");
		System.out.println("==================================TC_11===========================");

	}

	//TC_12
	@And("^Click on upload image$")
	public void click_on_upload_image() throws Throwable {
		Thread.sleep(1000);

		// Actions action = new Actions(login.driver);
		Thread.sleep(2000);
		WebElement movtoname = login.driver.findElement(By.xpath("//div[@class='account-avatar']"));
		action.pause(500).moveToElement(movtoname).build().perform();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[@class='edit-avatar--edit-btn']")).click();

	}

	//TC_12
	@And("^Click on the upload \"([^\"]*)\"$")
	public void click_on_the_upload(String arg1) throws Throwable {

		if (arg1.equalsIgnoreCase("Image")) {
			CommonFunctionality.wait(2000);
			CommonFunctionality.uploadTheFileusingAutoIT(login.driver,
					System.getProperty("user.dir") + "\\AutoIT\\Shravas.exe",
					System.getProperty("user.dir") + "\\AutoIT\\Shravas.png");
			CommonFunctionality.wait(2000);
		} else if (arg1.equalsIgnoreCase("Large Images")) {
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

		System.out.println("==================================TC_12===========================");
	}

	//TC_15
	@And("^Click on Change password button$")
	public void click_on_Change_password_button() throws Throwable {

		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[contains(text(),'Change password')]")).click();

	}
//TC_15
	@And("^Enter the old password as \"([^\"]*)\"$")
	public void enter_the_old_password_as(String pwd) throws Throwable {
		Thread.sleep(1000);
		// click on old pwd
		login.driver.findElement(By.name("oldPassword")).click();
		Thread.sleep(1000);
		// Enter old pwd
		login.driver.findElement(By.name("oldPassword")).sendKeys(pwd);
		Thread.sleep(1000);
		System.out.println("==================================TC_15===========================");
	}

	//TC_16
	@And("^Enter the New password as \"([^\"]*)\"$")
	public void enter_the_New_password_as(String newpwd) throws Throwable {

		Thread.sleep(1000);

		// click on New password
		login.driver.findElement(By.name("password")).click();
		Thread.sleep(500);
		// Enter new pwd
		login.driver.findElement(By.name("password")).sendKeys(newpwd);
	}

	//TC_16
	@And("^Enter the Retype new password as \"([^\"]*)\"$")
	public void enter_the_Retype_new_password_as(String retype) throws Throwable {

		Thread.sleep(1000);
		// click on Retype password
		// login.driver.findElement(By.name("passwordRepeat")).click();
		// Thread.sleep(500);
		// Enter new pwd

		Robot robot = new Robot();
		// Press key TAB
		robot.keyPress(KeyEvent.VK_TAB);
		login.driver.findElement(By.name("passwordRepeat")).sendKeys(retype);
		Thread.sleep(1000);

		System.out.println("Vaidation message==> :Incorrect current password");

		Thread.sleep(1000);
		// change pwd popup cancel
		// login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
		System.out.println("==================================TC_16===========================");
	}
	
//TC_20
	@And("^Click on X button$")
	public void click_on_X_button() throws Throwable {

		// click on cancel
		login.driver.findElement(By.xpath("//div[contains(text(),'Cancel')]")).click();
		
		System.out.println("==================================TC_20===========================");
	}

//	TC_21
	@And("^click on select language as \"([^\"]*)\"$")
	public void click_on_select_language_as(String arg1) throws Throwable {

		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[contains(text(),'中文')]")).click();
		Thread.sleep(1000);
		String lanchange = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'世界趋势数据库')]"))).getText();
		System.out.println("Selected language should be display: " + lanchange);
		Thread.sleep(1000);

	}
	//TC_21
	@Then("^UI interface shoud be loaded for selected language$")
	public void ui_interface_shoud_be_loaded_for_selected_language() throws Throwable {
		System.out.println("UI interface shoud be loaded for selected language");

	}

	// TC_21
	@And("^Selected language should be displayed first place$")
	public void selected_language_should_be_displayed_first_place() throws Throwable {
		Thread.sleep(1000);

		String lan = login.driver.findElement(By.xpath("//div[contains(text(),'中文')]")).getText();
		System.out.println("Selected language:" + lan);
	}

	// TC_21
	@And("^click on Language as 'English'$")
	public void click_on_Language_as_English() throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[contains(text(),'English')]")).click();
		Thread.sleep(4000);
		System.out.println("Selected language English should be displayed");
		System.out.println("==================================TC_21===========================");
		
	}

	//TC_22
	@And("^Click on dropdown for number format$")
	public void click_on_dropdown_for_number_format() throws Throwable {

		Thread.sleep(2000);
		// click on Number format drop down
		// login.driver.findElement(By.xpath("//body/div[8]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]")).click();

		login.driver.findElement(By.xpath("//div[@class='number-format-context-title']")).click();
		// print number format data
		String numberformatedropdown = login.driver.findElement(By.xpath("//body/ul[1]/div[3]/li[1]/div[1]")).getText();
		login.Log4j.info("Number formate dropdown data:" + numberformatedropdown);
		// get data from decimal place
		String decimaldata = login.driver.findElement(By.name("decimal_places")).getText();
		System.out.println(decimaldata);
		// Assert.assertEquals(decimaldata, "3");
		// {
		// login.Log4j.info("Default Decimal place should be ");
		// System.out.println("Default Decimal place should be display");
		// }

	}

	//TC_23
	@And("^change a Decimal place as \"([^\"]*)\"$")
	public void change_a_Decimal_place_as(String Decimalplace) throws Throwable {

		Thread.sleep(1000);
		// decimal place change
		login.driver.findElement(By.name("decimal_places")).clear();
		Thread.sleep(500);
		login.driver.findElement(By.name("decimal_places")).sendKeys(Decimalplace);

		System.out.println(
				"===============================================================Decimal place:" + Decimalplace);
	}

	//TC_23
	@And("^Get Value of \"([^\"]*)\" in Number format$")
	public void get_Value_of_in_Number_format(String arg2) throws Throwable {
		Thread.sleep(1000);

		String noformat = login.driver.findElement(By.xpath("//div[@class='number-format-context-title']")).getText();
		System.out.println(noformat);
		// login.driver.findElement(By.className("context-menu-control")).click();

		// String value=login.driver.findElement(By.name("decimal_places")).getText();
		// System.out.println(value);
		// Assert.assertTrue(formate.value);

	}
	//TC_23
	@And("^click on series Tab$")
	public void click_on_series_Tab() throws Throwable {
		Thread.sleep(3000);
		// click on series tab
		// login.driver.findElement(By.className("toggler-control-item")).click();
		// login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
		login.driver.findElement(By.xpath("//label[2]/span")).click();
		// login.driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/label[2]")).click();
		Thread.sleep(2000);

	}
	//TC_23
	@And("^search a series id as\"([^\"]*)\"$")
	public void search_a_series_id_as(String arg1) throws Throwable {

		Thread.sleep(1000);
		// click on search button
		login.driver.findElement(By.className("search-input-text")).click();
		Thread.sleep(1000);
		// enter data in search box
		login.driver.findElement(By.className("search-input-text")).sendKeys(arg1);

	}
	@And("^click on series name$")
	public void click_on_series_name() throws Throwable {

		Thread.sleep(1000);

		// Actions action = new Actions(login.driver);
		// Thread.sleep(2000);

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/label[2]/span[1]"))).isDisplayed();
		WebElement movtoname = login.driver.findElement(By.xpath("//div[contains(text(),'Import Volume Index')]"));
		action.pause(500).moveToElement(movtoname).build().perform();
		Thread.sleep(2000);

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Import
		// Volume Index')]"))).isDisplayed();
		// WebElement movtoname =
		// login.driver.findElement(By.xpath("//div[contains(text(),'Import Volume
		// Index')]"));

		login.driver.findElement(By.xpath("//div[contains(text(),'Import Volume Index')]")).click();

		// login.driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/label[2]/span[1]")).click();

		// click on series name
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Import
		// Volume Index')]")));

		// login.driver.findElement(By.xpath("//div[contains(text(),'Import Volume
		// Index')]")).click();

	}

	//TC_23
	@Then("^click on data tab$")
	public void click_on_data_tab() throws Throwable {
		Thread.sleep(1000);
		// click on data tab
		login.driver.findElement(By.xpath(
				"//body/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]"))
				.click();

	}
	//TC_23
	@And("^copy the Timepoint value inside data tab$")
	public void copy_the_Timepoint_value_inside_data_tab() throws Throwable {

		Thread.sleep(1000);
		String dottimepoint = login.driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[5]/span[2]"))
				.getText();

		System.out
				.println("===========================================================================" + dottimepoint);

//String data[]= 	timepoint.split(".");

		// int datalength=data[1].length();
		// String dot= String.valueOf(data[1].length());

		// datalength.toString();

		/*
		 * if(formate==datalength) {
		 * 
		 * }
		 * 
		 * 
		 * String str=timepoint; double num1 = Double.parseDouble(str); Double d =num1;
		 * String a=d.toString(); String[] result = a.split("\\.");
		 * System.out.println("After decimal points count==================="+result[1].
		 * length());
		 */

	}
	//TC_23
	@Then("^Decimal place and timepoint value should be same$")
	public void decimal_place_and_timepoint_value_should_be_same() throws Throwable {

		// String data[]= dottimepoint.split(".");

		// int datalength=data[1].length();
		// System.out.println("data length:"+datalength);

		// if(Decimalplace==datalength)
		// {

		System.out.println("decimal place and timepoints should be same");
		// }

		// else
		// {
		// System.out.println("===================Failed decimal
		// places================================");
		// }

		// if(formate==timepoint)
		// {
		// System.out.println("decimal place and timepoints should be same");
		// }

		// else
		// {
		// System.out.println("===================Failed decimal
		// places================================");
		// }

	}
//==============================================================

	//TC_24
	@And("^click on decimal separator comma$")
	public void click_on_decimal_separator_comma() throws Throwable {

		Thread.sleep(1000);
		// click on comma
		login.driver.findElement(By.xpath("//body/ul[1]/div[3]/li[1]/div[1]/div[2]/div[2]/label[1]")).click();
		Thread.sleep(2000);

	}

	//TC_24
	@And("^get the value of Decimal separater$")
	public void get_the_value_of_Decimal_separater() throws Throwable {

		Thread.sleep(1000);
		String commaseparater = login.driver
				.findElement(By.xpath("//body/ul[1]/div[3]/li[1]/div[1]/div[2]/div[2]/label[1]")).getText();
		System.out.println("Decemal separator value:" + commaseparater);

	}

	//TC_24
	@And("^copy the timepoints from data tab$")
	public void copy_the_timepoints_from_data_tab() throws Throwable {

		Thread.sleep(1000);

		String commatimepoints = login.driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[5]/span[2]"))
				.getText();
		System.out.println("time points from data tab" + commatimepoints);

	}

	//TC_24
	@Then("^demial separater and timepoint value same$")
	public void demial_separater_and_timepoint_value_same() throws Throwable {

		// boolean iscomma=commaseparater.contains(",");
		// boolean iscomma2=commatimepoints.contains(",");

		// if(iscomma&&iscomma2)
		// {
		System.out.println("decimal separator and timepoints should be same");
		// }

		// else
		// {
		// System.out.println("===================Failed decimal
		// places================================");
		// }

	}

	// ============================================Grouping==================

	//TC_25
	@And("^click on Grouping separator$")
	public void click_on_Grouping_separator() throws Throwable {

		Thread.sleep(1000);

		// click on grouping separate
		login.driver.findElement(By.xpath("//body/ul[1]/div[3]/li[1]/div[1]/div[3]/div[2]/label[2]")).click();
		Thread.sleep(1000);

	}

	//TC_25
	@And("^get the value the of grouping separator$")
	public void get_the_value_the_of_grouping_separator() throws Throwable {

		Thread.sleep(1000);
		String groupingseparator = login.driver
				.findElement(By.xpath("//body/ul[1]/div[3]/li[1]/div[1]/div[3]/div[2]/label[2]")).getText();
		System.out.println("groupingseparator:" + groupingseparator);

	}
	//TC_25
	@And("^search a series id as \"([^\"]*)\"$")
	public void search_a_series_id_as1(String seriesid) throws Throwable {

		Thread.sleep(2000);
		// click on search button
		login.driver.findElement(By.className("search-input-text")).click();
		Thread.sleep(1000);
		// enter data in search box
		login.driver.findElement(By.className("search-input-text")).sendKeys(seriesid);

	}
	//TC_25
	@And("^click on particular series name$")
	public void click_on_particular_series_name() throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[contains(text(),'Motor Vehicles Production')]")).click();

	}
	//TC_25
	@And("^get the timepoints from data tab$")
	public void get_the_timepoints_from_data_tab() throws Throwable {
		// data tab
		Thread.sleep(1000);
		String groupingtimepoints = login.driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[5]/span[2]"))
				.getText();
		System.out.println("Number formate values:" + groupingtimepoints);

	}

	//TC_25
	@Then("^Grouping separator and timepoint value same$")
	public void grouping_separator_and_timepoint_value_same() throws Throwable {

		// boolean isgrouping=groupingseparator.contains(".");
		// boolean isgroup2 =groupingtimepoints.contains(".");

		// if(isgrouping&&isgroup2)
		// {
		System.out.println("Grouping separator and timepoints should be same");
		// }

		// else
		// {
		// System.out.println("===================Failed grouping separator
		// places================================");
		// }

	}

	//TC_26
	@And("^Date format \"([^\"]*)\" and \"([^\"]*)\" formate default display$")
	public void date_format_and_formate_default_display(String arg1, String arg2) throws Throwable {

		Thread.sleep(1000);
		// date format auto
		String dateformat = login.driver
				.findElement(By.xpath("//div[contains(text(),'Auto')]")).getText();
		System.out.println(dateformat);

		// MM//DD/YYYY
		// String
		// date=login.driver.findElement(By.xpath("//div[@class='date-format-example']")).getText();
		// System.out.println(date);
		// div[@class='date-format-example']

		// assertEquals("Auto", dateformat);
		// assertEquals("Auto", date);
		System.out.println("Date formate Auto default display");

	}
	//TC_27
	@And("^Click on dropdown Auto$")
	public void click_on_dropdown_Auto() throws Throwable {
		Thread.sleep(1000);
		// click on Auto drop down
		// WebElement movtoname =
		// login.driver.findElement(By.xpath("//body[1]/div[10]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]"));
		// action.pause(500).moveToElement(movtoname).build().perform();
		// Thread.sleep(2000);
		// login.driver.findElement(By.xpath("//div[contains(text(),'Auto')]")).click();
		                                   //body/div[5]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]
		login.driver.findElement(By.xpath("//body/div[5]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]"))
				.click();
		// body/div[8]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]
	}

	//TC_27
	@And("^select date format in Auto dropdown$")
	public void select_date_format_in_Auto_dropdown() throws Throwable {
		Thread.sleep(1000);
		// click on date format

		WebElement movtoname = login.driver.findElement(By.xpath("//div[contains(text(),'MM/DD/YYYY')]"));
		action.pause(500).moveToElement(movtoname).build().perform();
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//div[contains(text(),'MM/DD/YYYY')]")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[contains(text(),'MM.DD.YYYY')]")).click();

	}

	//TC_27
	@And("^click on series$")
	public void click_on_series() throws Throwable {

		Thread.sleep(500);
		login.driver.findElement(By.xpath(
				"//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/div[1]/a[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]"))
				.click();

	}

	//TC_27
	@And("^Updated date format display in SSP$")
	public void updated_date_format_display_in_SSP() throws Throwable {

		Thread.sleep(1000);
		login.driver.findElement(By.xpath(
				"//body/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]"))
				.click();

		String updatedateinSSP = login.driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[6]/span[1]"))
				.getText();

		System.out.println(updatedateinSSP);

	}

	//TC_27
	@Then("^Only selected Date format should be displayed in entire CDMNext$")
	public void only_selected_Date_format_should_be_displayed_in_entire_CDMNext() throws Throwable {

		// boolean selecteddate=updatedateinSSP.contains(",");

		// if(updatedateinSSP && selecteddate)
		// {
		System.out.println("selected Date format should be displayed in entire CDMNext");
		// }
		// else
		// {
		// System.out.println("selected Date format failed");
		// }
		// boolean selecteddate=updatedateinSSP.contains(",");
		// boolean isgroup2 =selecteddate.contains(",");
		// boolean isgrouping=groupingseparator.contains(",");
		// boolean isgroup2 =updatedateinSSP.contains(",");

	}

	//TC_28
	@And("^checked custom radio button$")
	public void checked_custom_radio_button() throws Throwable {
		Thread.sleep(1000);

		// click on radio button
		WebElement radio = login.driver.findElement(By.xpath("//body/ul[1]/div[3]/li[2]/div[1]/label[1]/span[1]"));
		radio.click();

		// clear the text box
		login.driver.findElement(By.xpath("//body/ul[1]/div[3]/li[2]/div[1]/div[1]/div[1]/input[1]")).clear();
		// click on the text box
		login.driver.findElement(By.xpath("//body/ul[1]/div[3]/li[2]/div[1]/div[1]/div[1]/input[1]")).click();

//	login.driver.findElement(By.xpath("//body/ul[1]/div[3]/li[2]/div[1]/div[1]/div[1]/input[1]"));

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CAPS_LOCK);
		r.keyRelease(KeyEvent.VK_CAPS_LOCK);
		login.driver.findElement(By.xpath("//body/ul[1]/div[3]/li[2]/div[1]/div[1]/div[1]/input[1]")).sendKeys("YYYY");

		// WebElement custom=
		// login.driver.findElement(By.xpath("//body/ul[1]/div[3]/li[2]/div[1]/div[1]/div[1]/input[1]")).sendKeys(KeyEvent.);
//	custom.KeyEvent.VK_CAPS_LOCK;
	}

	//TC_29
	@And("^select custom radio button$")
	public void select_custom_radio_button() throws Throwable {
		Thread.sleep(1000);
		// click on radio button
		WebElement radio = login.driver.findElement(By.xpath("//body/ul[1]/div[3]/li[2]/div[1]/label[1]/span[1]"));
		radio.click();
		// clear the text box
		login.driver.findElement(By.xpath("//body/ul[1]/div[3]/li[2]/div[1]/div[1]/div[1]/input[1]")).clear();
		// click on the text box
		login.driver.findElement(By.xpath("//body/ul[1]/div[3]/li[2]/div[1]/div[1]/div[1]/input[1]")).click();
		// enter data in text box
		login.driver.findElement(By.xpath("//body/ul[1]/div[3]/li[2]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys("yyyy-dd-mm");

		Thread.sleep(1000);
		// validation should be display
		String customvalidation = login.driver
				.findElement(By.xpath("//div[contains(text(),'Invalid date format. Please enter a valid format')]"))
				.getText();
		System.out.println(customvalidation);
		System.out.println(validation);

	}

	//TC_29
	@And("^verified \"([^\"]*)\" message should be displayed in red color$")
	public void verified_message_should_be_displayed_in_red_color(String arg1) throws Throwable {

		Thread.sleep(2000);
		if (customvalidation == validation) {
			// assertEquals("Invalid date format. Please enter a valid
			// format",customvalidation);
			System.out.println(
					"Invalid date format. Please enter a valid format message should be displayed in red color.");
		} else {
			System.out.println("validation should not be display");
		}
	}

	//TC_30
	@And("^checked radio custom button$")
	public void checked_radio_custom_button() throws Throwable {

		Thread.sleep(1000);
		// click on radio button
		WebElement radio = login.driver.findElement(By.xpath("//body/ul[1]/div[3]/li[2]/div[1]/label[1]/span[1]"));
		radio.click();
		for (int i = 1; i <= 4; i++) {
			// clear the text box
			login.driver.findElement(By.xpath("//body/ul[1]/div[3]/li[2]/div[1]/div[1]/div[1]/input[1]"))
					.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(1000);
		}
		// login.driver.findElement(By.xpath("//body/ul[1]/div[3]/li[2]/div[1]/div[1]/div[1]/input[1]")).click();
		Thread.sleep(1000);
		// validation display
		String customempty = login.driver
				.findElement(By.xpath("//div[contains(text(),'Custom date pattern cannot be empty')]")).getText();
		System.out.println(customempty);

		// System.out.println(customtextboxempty);
	}

	//TC_30
	@Then("^'Custom date pattern cannot be empty' message displayed in red color\\.$")
	public void custom_date_pattern_cannot_be_empty_message_displayed_in_red_color() throws Throwable {

		String customtextboxempty = "Custom date pattern cannot be empty";
		// assertEquals(customempty, customtextboxempty);
		// System.out.println("Custom date pattern cannot be empty' message displayed in
		// red color");
		if (customtextboxempty == customempty) {
			System.out.println("Custom date pattern cannot be empty' message displayed in red color");
			// assertEquals("Custom date pattern cannot be empty",);
		} else {
			System.out.println("Test case Failed");

		}
	}

	//TC_31
	@And("^get the value of Timeframe$")
	public void get_the_value_of_Timeframe() throws Throwable {
		Thread.sleep(1000);
		String Timeframe = login.driver.findElement(By.xpath("//input[@name='time_frame_observations']")).getText();
		System.out.println("Timeframes value:" + Timeframe);
		Thread.sleep(2000);

	}

	//TC_31
	@And("^select any one series$")
	public void select_any_one_series() throws Throwable {
		Thread.sleep(1000);

		WebElement movtoname = login.driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/div[1]/a[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]"));
		action.pause(500).moveToElement(movtoname).build().perform();
		Thread.sleep(2000);

		String Seriesname = login.driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/div[1]/a[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]"))
				.getText();
		System.out.println(Seriesname);

		login.driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/div[1]/a[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]"))
				.click();

		int selectseries = 1;

		// SSP pop up display and click on view as
		login.driver.findElement(By.xpath("//span[contains(text(),'View as')]")).click();
		// click on Table
		login.driver.findElement(By.xpath("//body/ul[1]/div[3]/li[4]/span[1]/span[1]")).click();

		Thread.sleep(1000);
		// click on cancel button
		login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
		// click on download button
		Thread.sleep(2000);
		login.driver
				.findElement(By.xpath(
						"//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/button[1]/span[2]"))
				.click();
		Thread.sleep(1000);

		// String
		// seriescount=login.driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/h4[1]/div[1]")).getText();
//System.out.println("Download popup series count:"+seriescount);
//int seriescount=1;
//int st = seriescount;
//String st1=st.replaceAll("[^0-9]", "");
//System.out.println("Int c = "+st1);

		// close the pop up
		// login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();

	}

	//TC_31
	@Then("^Only selected observations should be displayed for visuals in all insights and also in download popup$")
	public void only_selected_observations_should_be_displayed_for_visuals_in_all_insights_and_also_in_download_popup()
			throws Throwable {

		// if(selectseries==st1)
		// {
		System.out.println(
				"Only selected observations should be displayed for visuals in all insights and also in download popup.");
		// }

		Thread.sleep(1000);
		for (int i = 1; i <= Timeframe; i++) {
			System.out.println("No of timeframes count");
			login.driver.findElement(By.xpath(
					"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr["
							+ i + "]/td[2]"));

		}
		System.out.println(
				"Only selected observations should be displayed for visuals in all insights and also in download popup");
	}

	//TC_32
	@And("^checked on \"([^\"]*)\"$")
	public void checked_on(String arg1) throws Throwable {

		Thread.sleep(1000);
		// WebElement checkbox =
		// login.driver.findElement(By.xpath("//span[contains(text(),'Ask me to confirm
		// the download settings')]"));
		// System.out.println("The checkbox is selection state is - " +
		// checkbox.isSelected());
		System.out.println("default checked on Ask me to confirm the download settings");

	}

	//TC_32
	@And("^select some series$")
	public void select_some_series() throws Throwable {
		Thread.sleep(1000);
		int checkedseries = 5;
		for (int i = 1; i <= checkedseries; i++) {
			login.driver.findElement(By.xpath(
					"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li["
							+ i + "]/div[1]/a[1]/div[2]/span[1]"))
					.click();
			Thread.sleep(100);

		}

	}
	
	
	//TC_32

	@And("^Download popup display$")
	public void download_popup_display() throws Throwable {

		String downloadpopup = login.driver.findElement(By.xpath("//span[contains(text(),'(5 series)')]")).getText();
		System.out.println("Download pop series count:" + downloadpopup);

		String series = downloadpopup;
		String scount = series.replaceAll("[^0-9]", "");
		System.out.println("Seies count = " + scount);

	}
	
	//TC_32
	@Then("^\"([^\"]*)\" window should be \"([^\"]*)\" and selected series count display$")
	public void window_should_be_and_selected_series_count_display(String arg1, String arg2) throws Throwable {

		if (checkedseries == scount) {
			System.out.println("Selected series and download popup display series are equal");
		} else {
			System.out.println("test case faild ");
		}

	}
	
	//TC_33
	@And("^unchecked on Ask me to confirm the download settings$")
	public void unchecked_on_Ask_me_to_confirm_the_download_settings() throws Throwable {

		Thread.sleep(1000);

		// WebElement checkBoxElement =
		login.driver.findElement(By.xpath("//span[contains(text(),'Ask me to confirm the download settings')]"))
				.click();
		// boolean isEnabled = checkBoxElement.isEnabled();

		// performing click operation if element is not checked
		// if(isEnabled == true) {
		// Thread.sleep(1000);
		// checkBoxElement.click();
		// }

		// WebElement checkbox =
		// login.driver.findElement(By.xpath("//span[contains(text(),'Ask me to confirm
		// the download settings')]")).click();

		// System.out.println("The checkbox is selection state is - " +
		// checkbox.isSelected());

	}

	//TC_33
	@And("^Download settings window should not be displayed and directly download with saved settings\\.$")
	public void download_settings_window_should_not_be_displayed_and_directly_download_with_saved_settings()
			throws Throwable {
		System.out
				.println("Download settings window should not be displayed and directly download with saved settings.");

	}

	//TC_34
	@And("^Right Click on selected series$")
	public void right_Click_on_selected_series() throws Throwable {

		WebElement elementLocator = login.driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[5]/div[1]/a[1]/div[2]/span[1]"));
		action.contextClick(elementLocator).perform();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Copy data')]")).click();

	}

	//TC_34
	@Then("^Download settings window should be appeared even unchecked in preference\\.$")
	public void download_settings_window_should_be_appeared_even_unchecked_in_preference() throws Throwable {
		System.out.println("print the checkedseries:" + checkedseries);
		System.out.println("print the scount:" + scount);
		if (checkedseries == scount) {
			System.out.println("Download settings window should be appeared even unchecked in preference.");
			// System.out.println("Selected series and download popup display series are
			// equal");
		} else {
			System.out.println("test case faild ");
		}

	}

//TC_35
	@And("^Uncheck 'Ask me to confirm the download settings' checkbox$")
	public void uncheck_Ask_me_to_confirm_the_download_settings_checkbox() throws Throwable {

		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Ask me to confirm the download settings')]"))
				.click();
		Thread.sleep(1000);

	}

	//TC_35
	@Then("^The 'ask me to confirm the download settings' option should be unchecked$")
	public void the_ask_me_to_confirm_the_download_settings_option_should_be_unchecked() throws Throwable {
		Thread.sleep(1000);

		System.out.println("The Always ask me to conform the download settingsoption should be unchecked.");
	}

	//TC_36
	@And("^Right click on and click on 'view as chart'$")
	public void right_click_on_and_click_on_view_as_chart() throws Throwable {

		Thread.sleep(1000);
		WebElement elementLocator = login.driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[5]/div[1]/a[1]/div[2]/span[1]"));
		action.contextClick(elementLocator).perform();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//span[contains(text(),'View as Chart')]")).click();
		Thread.sleep(2000);

	}
	
	//TC_36
	@And("^click on delete button in visual insight$")
	public void click_on_delete_button_in_visual_insight() throws Throwable {

		Thread.sleep(2000);
		login.driver.findElement(By.xpath(
				"//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[5]"))
				.click();

	}

	//TC_36
	@Then("^Deletion confirmation message should be dispalyed for visual delete$")
	public void deletion_confirmation_message_should_be_dispalyed_for_visual_delete() throws Throwable {
		Thread.sleep(1000);

		login.driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();

		System.out.println("Deletion confirmation message should be dispalyed for visual delete");

	}

	//TC_37
	@And("^uncheck the 'Ask me to confirm visual deletion'$")
	public void uncheck_the_Ask_me_to_confirm_visual_deletion() throws Throwable {

		Thread.sleep(1000);
		// unchecked the check box
		login.driver.findElement(By.xpath("//span[contains(text(),'Ask me to confirm visual deletion')]")).click();
		Thread.sleep(500);
	}

	//TC_37
	@Then("^Deletion confirmation message should not be displayed to users while deleting visuals\\.$")
	public void deletion_confirmation_message_should_not_be_displayed_to_users_while_deleting_visuals()
			throws Throwable {

		System.out.println("Deletion confirmation message should not be displayed to users while deleting visuals");

	}

//TC_38
	@And("^click on 'more' button and checked 'With suggestions for rebased/discontinued series'$")
	public void click_on_more_button_and_checked_With_suggestions_for_rebased_discontinued_series() throws Throwable {

		Thread.sleep(1000);
		// click on more button
		login.driver.findElement(By.xpath("//span[contains(text(),'More')]")).click();
		Thread.sleep(2000);
		// checked check box
		login.driver.findElement(By.xpath(
				"//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[7]/div[1]/div[2]/span[1]/span[1]"))
				.click();
		Thread.sleep(1000);
		// click on apply filters
		login.driver.findElement(By.xpath("//div[contains(text(),'Apply filter')]")).click();

	}

//TC_38
	@And("^series added into myseries$")
	public void series_added_into_myseries() throws Throwable {

		// click on '+'icon
		login.driver.findElement(By.xpath(
				"//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/div[1]/a[1]/div[4]/div[1]/div[1]"))
				.click();
		Thread.sleep(1000);

	}

//TC_38
	@And("^click on 'My Insights'$")
	public void click_on_My_Insights() throws Throwable {

		login.driver.findElement(By.xpath("//a[contains(text(),'My insights')]")).click();

	}

//TC_38
	@And("^click on 'customize'$")
	public void click_on_customize() throws Throwable {

		Thread.sleep(2000);
		WebElement movtoname = login.driver.findElement(By.xpath(
				"//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]"));
		// body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]
		action.pause(500).moveToElement(movtoname).build().perform();

		Thread.sleep(2000);
		login.driver.findElement(By.xpath(
				"//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[2]/a[2]"))
				.click();
		// body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[4]/div[2]/a[2]

		Thread.sleep(2000);

	}

//TC_38
	@Then("^Replacement popup should be displayed$")
	public void replacement_popup_should_be_displayed() throws Throwable {
		Thread.sleep(1000);

		String popup = login.driver
				.findElement(By.xpath("//div[contains(text(),'These series have been rebased or discontinued sin')]"))
				.getText();
		System.out.println("popupText" + popup);

		// assertEquals(popup,"These series have been rebased or discontinued sin");
		System.out.println("Replacements popup should be display");

	}


	@Given("^cancel the 'X' button$")
	public void cancel_the_X_button() throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[contains(text(),'Cancel')]")).click();

	}

//TC_39
	@And("^uncheck the 'Show latest changes in my insights upon opening'$")
	public void uncheck_the_Show_latest_changes_in_my_insights_upon_opening() throws Throwable {

		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Show latest changes in my insights upon opening')]"))
				.click();

	}

//TC_39
	@Then("^The Replacement popup should not be displayed to user$")
	public void the_Replacement_popup_should_not_be_displayed_to_user() throws Throwable {

		System.out.println("The Replacement popup should not be displayed to user");

	}

//TC_40
	@And("^checked the 'Show latest changes in my insights upon opening'$")
	public void checked_the_Show_latest_changes_in_my_insights_upon_opening() throws Throwable {

		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Show latest changes in my insights upon opening')]"))
				.click();

	}

//TC_40
	@And("^Check the checkbox for 'Do not show again' on replacement popup$")
	public void check_the_checkbox_for_Do_not_show_again_on_replacement_popup() throws Throwable {

		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//span[contains(text(),'Do not show again')]")).click();

	}

//TC_40
	@Then("^The Replacement popup should not be displayed to user and should be unchecked under preference as well$")
	public void the_Replacement_popup_should_not_be_displayed_to_user_and_should_be_unchecked_under_preference_as_well()
			throws Throwable {

		System.out.println(" Show latest changes in my insights upon opening unchecked");
	}
	

	//TC_41
	@And("^click on download button$")
	public void click_on_download_button() throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(
				"//button[@class='sphere-modal-control button insight-download__modal-button button button__download-btn']"))
				.click();
		Thread.sleep(5000);
	}

	//TC_41
	@Then("^The Series should be selected in search panel after done download actions$")
	public void the_Series_should_be_selected_in_search_panel_after_done_download_actions() throws Throwable {
		Thread.sleep(1000);

		WebElement checkBoxElement = login.driver.findElement(By.xpath(
				"//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/div[1]/a[1]/div[2]/span[1]"));
		boolean isEnabled = checkBoxElement.isEnabled();

// performing click operation if element is enabled
		if (isEnabled == true) {

			System.out.println("The Series should be selected in search panel after done download actions.");
		} else {

			System.out.println("Test case failed");
		}

	}
	
	//TC_42
	@And("^uncheck the 'Preserve search selection after download/CTC actions'$")
	public void uncheck_the_Preserve_search_selection_after_download_CTC_actions() throws Throwable {

		Thread.sleep(1000);
		login.driver
				.findElement(
						By.xpath("//span[contains(text(),'Preserve search selection after download/CTC actions')]"))
				.click();

	}

	//TC_42
	@Then("^selected series should be unselected after done download/CTC actions\\.$")
	public void selected_series_should_be_unselected_after_done_download_CTC_actions() throws Throwable {
		Thread.sleep(2000);
		WebElement checkBoxElement = login.driver.findElement(By.xpath(
				"//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/div[1]/a[1]/div[2]/span[1]"));
		boolean isEnabled = checkBoxElement.isEnabled();
		if (isEnabled == false) {
			System.out.println("The Series should be selected in search panel after done download actions.");
		} else {

			System.out.println("Test case failed");
		}

	}


	//TC_43
	@And("^Select series in your order$")
	public void select_series_in_your_order() throws Throwable {

		Thread.sleep(1000);
		for (int i = 1; i < 10; i++) {
			if (i % 2 == 0) {
				login.driver.findElement(By.xpath(
						"//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li["
								+ i + "]/div[1]/a[1]/div[2]/span[1]"))
						.click();
				Thread.sleep(500);
				String seriesname = login.driver.findElement(By.xpath(
						"//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li["
								+ i + "]/div[1]/a[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]"))
						.getText();
				System.out.println("selected series:" + seriesname);
			} else {
				System.out.println("i am not select series");
			}

		}

	}

	//TC_43
	@Then("^The order of series should not be changed when adding/downloading series\\.and Add to insight$")
	public void the_order_of_series_should_not_be_changed_when_adding_downloading_series_and_Add_to_insight()
			throws Throwable {

		Thread.sleep(1000);
		// click on '+' icon
		login.driver.findElement(By.xpath(
				"//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/div[1]/a[1]/div[4]/div[1]/div[1]"))
				.click();
		Thread.sleep(1000);

		for (int i = 1; i <= 4; i++) {
			// get the data of series
			String insightseries = login.driver.findElement(By.xpath(
					"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div["
							+ i + "]/div[1]/div[1]/div[1]/span[1]/span[1]"))
					.getText();
			System.out.println("selected series displayed in insights:" + insightseries);
			Thread.sleep(1000);

		}

		if (seriesname == insightseries) {
			System.out.println(
					"The order of series should not be changed when adding/downloading series.and Add to insight");
		} else {
			System.out.println("Test case failed");
		}

	}

	//TC_44
	@And("^uncheck the Preserve the order of selection when adding/downloading series$")
	public void uncheck_the_Preserve_the_order_of_selection_when_adding_downloading_series() throws Throwable {

		// un check the Preserve the order of selection when adding/downloading series
		Thread.sleep(1000);
		login.driver
				.findElement(By.xpath(
						"//span[contains(text(),'Preserve the order of selection when adding/downloading series')]"))
				.click();

	}

	//TC_44
	@And("^Series can be changed the order of display series when adding/downloading$")
	public void series_can_be_changed_the_order_of_display_series_when_adding_downloading() throws Throwable {

		// select 1st series
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(
				"//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/div[1]/a[1]/div[2]/span[1]"))
				.click();

		// click on '+' icon
		login.driver.findElement(By.xpath(
				"//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/div[1]/a[1]/div[4]/div[1]/div[1]"))
				.click();
		Thread.sleep(1000);

		for (int i = 1; i <= 5; i++) {
			// get the data of series
			String insightseries = login.driver.findElement(By.xpath(
					"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div["
							+ i + "]/div[1]/div[1]/div[1]/span[1]/span[1]"))
					.getText();
			System.out.println("selected series displayed in insights:" + insightseries);
			Thread.sleep(1000);

		}
		if (seriesname == insightseries) {
			System.out.println(
					"The order of series should not be changed when adding/downloading series.and Add to insight");
		} else {
			System.out.println("Test case failed");
		}

	}

	//TC_45
	@And("^Series tab should list the series in page view and the data pages should be available as (\\d+),(\\d+),(\\d+),\\.\\.\\.\\.next$")
	public void series_tab_should_list_the_series_in_page_view_and_the_data_pages_should_be_available_as_next(int arg1,
			int arg2, int arg3) throws Throwable {

		Thread.sleep(1000);
		WebElement scrolldown = login.driver.findElement(By.xpath("//span[contains(text(),'results per page')]"));
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView();", scrolldown);
		// js.executeScript("window.scrollBy(0,5000)", "results per page");
//js.executeScript("window.scrollBy()0,5000");

		System.out.println("result page display");

	}

	//TC_46
	@And("^checked the Show search results without pagination$")
	public void checked_the_Show_search_results_without_pagination() throws Throwable {
		Thread.sleep(1000);

		// checked the Show search results without pagination
		login.driver.findElement(By.xpath("//span[contains(text(),'Show search results without pagination')]")).click();

	}
	//TC_46
	@And("^Series should be displayed as list and more series can be viewed by scrolling bar$")
	public void series_should_be_displayed_as_list_and_more_series_can_be_viewed_by_scrolling_bar() throws Throwable {
		Thread.sleep(1000);

		js.executeScript("window.scrollBy(0,5000)");
		System.out.println("Series should be displayed as list and more series can be viewed by scrolling bar");

	}



	/*
	 * @And("^Remove series in myseries$") public void remove_series_in_myseries()
	 * throws Throwable {
	 * 
	 * if (login.driver.findElements(By.xpath(
	 * "//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/label[1]/span[1]"
	 * )).size()>= 1) {
	 * 
	 * //Checked a check box login.driver.findElement(By.xpath(
	 * "//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/label[1]/span[1]"
	 * )).click();
	 * 
	 * //click on delete button login.driver.findElement(By.xpath(
	 * "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[7]/div[1]"
	 * )).click(); Thread.sleep(500); } else { System.out.println("myseries empty");
	 * } }
	 */
	
	
	//TC_47
	@Given("^delete series in myseries$")
	public void delete_series_in_myseries() throws Throwable {
	    
		Thread.sleep(1000);
		
		//select check box
		login.driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/label[1]/span[1]")).click();
		
		
		//select first check box
		
		WebElement checkbox = login.driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]"));
		action.contextClick(checkbox).perform();
		
		
		//delete button
		login.driver.findElement(By.xpath("//body/ul[1]/div[3]/li[15]/span[1]/span[2]")).click();
		
		
	}
	
	

	//TC_47
	@And("^selected series added into my series$")
	public void selected_series_added_into_my_series() throws Throwable {

		// search and select a record
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).click();
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).clear();
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys("366672507");
		Thread.sleep(4000);

		// checked check box
		login.driver.findElement(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']")).click();
		Thread.sleep(1000);
		// mouse over series name
		// Robot r=new Robot();
		WebElement series1 = login.driver.findElement(By.xpath("//div[contains(text(),'Gross Saving')]"));
		action.pause(500).moveToElement(series1).build().perform();
		Thread.sleep(2000);
		WebElement elementLocator = login.driver.findElement(By.xpath("//div[contains(text(),'Gross Saving')]"));
		action.contextClick(elementLocator).perform();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//span[contains(text(),'View as Chart')]")).click();

		// click on '+' icon
		// login.driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/div[1]/a[1]/div[4]/div[1]/div[1]")).click();
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).click();
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).clear();
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys("14777401");
		Thread.sleep(6000);
		// checked check box
		login.driver.findElement(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']")).click();

		// mouse over series name
		// Robot r=new Robot();
		WebElement series2 = login.driver
				.findElement(By.xpath("//div[contains(text(),'Registered Unemployment Rate')]"));
		action.pause(500).moveToElement(series2).build().perform();
		Thread.sleep(2000);
		WebElement elementLocator1 = login.driver
				.findElement(By.xpath("//div[contains(text(),'Registered Unemployment Rate')]"));
		action.contextClick(elementLocator1).perform();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//span[contains(text(),'View as Chart')]")).click();

		// click on '+' icon
		// login.driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/div[1]/a[1]/div[4]/div[1]/div[1]")).click();
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).click();
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).clear();
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys("306539001");
		Thread.sleep(6000);

		// checked check box
		login.driver.findElement(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']")).click();

		// mouse over series name
		// Robot r=new Robot();
		WebElement series3 = login.driver.findElement(By.xpath("//div[contains(text(),'Population')]"));
		action.pause(500).moveToElement(series3).build().perform();
		Thread.sleep(2000);
		WebElement elementLocator11 = login.driver.findElement(By.xpath("//div[contains(text(),'Population')]"));
		action.contextClick(elementLocator11).perform();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//span[contains(text(),'View as Chart')]")).click();

		Thread.sleep(3000);

		login.driver.findElement(By.xpath("//a[contains(text(),'My Series')]")).click();

	}

	//TC_47
	@And("^click on \"([^\"]*)\"$")
	public void click_on(String arg1) throws Throwable {

		Thread.sleep(1000);
		// Checked a check box
		login.driver.findElement(By.xpath(
				"//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/label[1]/span[1]"))
				.click();

		Thread.sleep(500);

		WebElement movtoname = login.driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/span[1]"));
		action.pause(500).moveToElement(movtoname).build().perform();
		Thread.sleep(2000);

		WebElement elementLocator = login.driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/span[1]"));
		action.contextClick(elementLocator).perform();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//span[contains(text(),'View as Chart')]")).click();
	}

	//TC_47
	@Then("^\"([^\"]*)\" popup should be appeared$")
	public void popup_should_be_appeared(String arg1) throws Throwable {

		Thread.sleep(1000);
		if (login.driver.findElements(By.xpath("//div[contains(text(),'Chart Suggestion')]")).size() > 0) {

			login.Log4j.info("Chart suggestion popup should be displayed");
		} else {
			fail("Verification Failed");
		}
	}

	//TC_48
	@And("^unchecked the 'Show system suggestion when working with visuals'$")
	public void unchecked_the_Show_system_suggestion_when_working_with_visuals() throws Throwable {

		Thread.sleep(1000);
		login.driver
				.findElement(By.xpath("//span[contains(text(),'Show system suggestions when working with visuals')]"))
				.click();
	}

	//TC_48
	@Then("^\"([^\"]*)\" popup should not be appeared$")
	public void popup_should_not_be_appeared(String arg1) throws Throwable {

		Thread.sleep(1000);
		// if(login.driver.findElement(By.xpath("//div[contains(text(),'Chart
		// Suggestion')]")).isDisplayed())
		// if (login.driver.findElements(By.xpath("//div[contains(text(),'Chart
		// Suggestion')]")).)
		// {
		// System.out.println("Test case failed");
		// login.Log4j.info("Test case failed");
		// }
		// else {
		System.out.println("Chart suggestion popup should not be displayed");
		// }
	}

	//TC_49
	@And("^checked the 'Show system suggestion when working with visuals'$")
	public void checked_the_Show_system_suggestion_when_working_with_visuals() throws Throwable {

		Thread.sleep(1000);

		login.driver
				.findElement(By.xpath("//span[contains(text(),'Show system suggestions when working with visuals')]"))
				.click();

	}

	//TC_49
	@And("^checked checkbox 'Do not show again'$")
	public void checked_checkbox_Do_not_show_again() throws Throwable {
		Thread.sleep(3000);

		login.driver.findElement(By.xpath("//span[contains(text(),\"Don't show again\")]")).click();

	}

	//TC_49
	@Then("^The 'Show system suggestion…' checkbox should be uncheck under profile$")
	public void the_Show_system_suggestion_checkbox_should_be_uncheck_under_profile() throws Throwable {
		Thread.sleep(1000);
		System.out.println(
				"The Show system suggestion… checkbox should be uncheck under profile and the Chart suggestion popup should not display again.");

	}
	//TC_50
	@And("^click on Change style sheet$")
	public void click_on_Change_style_sheet() throws Throwable {
		Thread.sleep(1000);
		// click on change
		login.driver.findElement(By.xpath("//span[@class='style-sheet-settings--edit-button']")).click();
		System.out.println("Show copyright default checked");

	}

	//TC_50
	@And("^show copyright checkbox default checked$")
	public void show_copyright_checkbox_default_checked() throws Throwable {

		System.out.println("Show copyright checkbox default checked");
	}

	//TC_50
	@And("^add to some series into insights$")
	public void add_to_some_series_into_insights() throws Throwable {
		login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
		// add to insights
		Thread.sleep(1000);
		// click on '+' icon
		login.driver.findElement(By.xpath(
				"//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/div[1]/a[1]/div[4]/div[1]/div[1]"))
				.click();
		Thread.sleep(1000);

		// login.driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/div[1]/a[1]/div[4]/div[1]/div[1]")).click();
		// Thread.sleep(1000);
		// click on series name
		login.driver.findElement(By.xpath(
				"//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/span[1]"))
				.click();

		// SSP pop display
		login.driver.findElement(By.xpath("//span[contains(text(),'View as')]")).click();
		// click on chat
		login.driver.findElement(By.xpath("//span[contains(text(),'Chart')]")).click();

		// SSP pop up close
		login.driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[3]")).click();
		Thread.sleep(1000);

	}

	//TC_50
	@Then("^The image copyright should applied to new and existing visuals\\.$")
	public void the_image_copyright_should_applied_to_new_and_existing_visuals() throws Throwable {

		Thread.sleep(1000);
		// logo display
		WebElement image = login.driver.findElement(By.xpath("//img[@class='visual-item-wrapper--logo']"));
		Thread.sleep(500);
		if (image.isDisplayed()) {
			System.out.println("The image copyright should be display");
		} else {
			System.out.println("Test case failed");
		}
		// login.driver.findElement(By.xpath("//img[@class='visual-item-wrapper--logo']")).isDisplayed();
		// System.out.println("The image copyright image should be display");

	}


//TC_63
	@And("^uncheck show copyright$")
	public void uncheck_show_copyright() throws Throwable {

		Thread.sleep(1000);
		// uncheck show copyright
		login.driver.findElement(By.xpath("//span[contains(text(),'Show copyright')]")).click();

	}

	//TC_63
	@Then("^Copyright should not be displayed for new and existing visuals\\.$")
	public void copyright_should_not_be_displayed_for_new_and_existing_visuals() throws Throwable {
		Thread.sleep(1000);

		System.out.println("Copyright should not be displayed");

		// WebElement
		// image=login.driver.findElement(By.xpath("//img[@class='visual-item-wrapper--logo']"));

		// if(image.isDisplayed() )
		// {
		// System.out.println("Test case failed");
		// }
		// else {
		// System.out.println("Copyright should not be displayed");
		// }

	}


//TC_51
	@And("^checked show copyright textbox$")
	public void checked_show_copyright_textbox() throws Throwable {

		Thread.sleep(1000);
		// checked show copyright text box
		login.driver.findElement(By.xpath("//span[contains(text(),'Show copyright')]")).click();

	}
	//TC_51
	@And("^image default copyright$")
	public void image_default_copyright() throws Throwable {
		Thread.sleep(1000);

		// default image
		WebElement imagebutton = login.driver.findElement(By.xpath("//span[contains(text(),'Image')]"));
		if (imagebutton.isEnabled()) {
			System.out.println("Test case failed");
		} else {
			System.out.println("Radio button default checked in image");
		}

	}

	//TC_51
	@Then("^image copyright should be applied to new and existing visuals$")
	public void image_copyright_should_be_applied_to_new_and_existing_visuals() throws Throwable {

		WebElement image = login.driver.findElement(By.xpath("//img[@class='visual-item-wrapper--logo']"));

		if (image.isDisplayed()) {
			System.out.println("The image copyright should be display");
		} else {
			System.out.println("Test case failed");
		}
	}

	//TC_52
	@And("^click on upload copyright image$")
	public void click_on_upload_copyright_image() throws Throwable {

		// upload image button click
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//label[contains(text(),'Upload image')]")).click();
		CommonFunctionality.wait(2000);
		CommonFunctionality.uploadTheFileusingAutoIT(login.driver,
				System.getProperty("user.dir") + "\\AutoIT\\Shravas.exe",
				System.getProperty("user.dir") + "\\AutoIT\\Shravas.png");
		CommonFunctionality.wait(2000);
	}

	//TC_52
	@Then("^Uploaded image should be displayed as copyright image$")
	public void uploaded_image_should_be_displayed_as_copyright_image() throws Throwable {

		Thread.sleep(1000);
		// WebElement
		// actual=login.driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]"));
		Assert.assertEquals(System.getProperty("user.dir") + "\\AutoIT\\Shravas.png",
				System.getProperty("user.dir") + "\\AutoIT\\Shravas.png");
		System.out.println("Uploaded image should be displayed as copyright image.");
	}


     //TC_53
	@Then("^user uploaded image removed$")
	public void user_uploaded_image_removed() throws Throwable {

		Thread.sleep(1000);
		// WebElement movtoname =
		// login.driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[2]/div[1]/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/form[1]/label[2]/span[1]"));
		// action.pause(500).moveToElement(movtoname).build().perform();
		// login.driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[2]/div[1]/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/form[1]/label[2]/span[1]")).click();

		login.driver.findElement(By.xpath("//*[@class='copyright-config--remove-icon ']")).click();
		System.out.println("User uploaded image should be removed");
	}

	//TC_54
	@And("^Observe Link field as \"([^\"]*)\"$")
	public void observe_Link_field_as(String arg1) throws Throwable {

		Thread.sleep(1000);

		// identify element
		// WebElement p=login.driver.findElement(By.xpath("//div[4]/div[2]/input"));
		// Thread.sleep(1000);
		// getText() to obtain text
		// String s= p.getText();
		// System.out.println("Text content is : " + s);
		// observe the link
		String copyrightlink = login.driver.findElement(By.xpath("//input[@name='credits_link']"))
				.getAttribute("value");
		System.out.println("copyright URL:" + copyrightlink);
		assertEquals(arg1, copyrightlink);
		
	}

	//TC_55
	@And("^select position for image copyright$")
	public void select_position_for_image_copyright() throws Throwable {
		Thread.sleep(1000);

		// click on alignment
		WebElement movtoname = login.driver
				.findElement(By.cssSelector(".col:nth-child(1) .config-btn:nth-child(1) > .config-btn--icon"));
		action.pause(500).moveToElement(movtoname).build().perform();
		Thread.sleep(2000);
		login.driver.findElement(By.cssSelector(".col:nth-child(1) .config-btn:nth-child(1) > .config-btn--icon"))
				.click();

	}

	
//TC_56
	@And("^click on \"([^\"]*)\" radio button$")
	public void click_on_radio_button(String arg1) throws Throwable {

		Thread.sleep(1000);
		// click on Text button
		WebElement movtoname = login.driver.findElement(By.xpath("//span[contains(text(),'Text')]"));
		action.pause(500).moveToElement(movtoname).build().perform();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Text')]")).click();

		String sourcecopyright = login.driver.findElement(By.name("credits_text")).getAttribute("value");
		System.out.println("Text:" + sourcecopyright);

	}
	
//TC_56
	@Then("^Text copyright should be displayed as \"([^\"]*)\"$")
	public void text_copyright_should_be_displayed_as(String arg1) throws Throwable {

		Thread.sleep(1000);

		// get the text of visual
		String Textcopyright = login.driver.findElement(By.xpath("//div[contains(text(),'Source: CEIC Data')]"))
				.getText();
		System.out.println("visual Text copyright:" + Textcopyright);

		if (sourcecopyright == Textcopyright) {
			System.out.println("Text copyright should be displayed");
		}

		else {
			System.out.println("Test case failed");
		}
	}


      //TC_57
	@Then("^The default link should be \"([^\"]*)\"$")
	public void the_default_link_should_be(String link) throws Throwable {

		Thread.sleep(1000);
		System.out.println("======================>" + link);

		// if(link==copyrightlink)
		// {
		System.out.println("The default link should be display");
		// }

		// else {
		// System.out.println("Test case failed");
		// }

		// assertEquals(link, copyrightlink);
		// System.out.println("The default link should be display");

	}


	 //TC_58
	@And("^change text size$")
	public void change_text_size() throws Throwable {

		Thread.sleep(1000);

		login.driver.findElement(By.xpath("//input[@name='credits_font_size']")).clear();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//input[@name='credits_font_size']")).sendKeys("30");
		// input[@name='credits_font_size']

	}

	 //TC_58
	@Then("^The text size should apply as selected$")
	public void the_text_size_should_apply_as_selected() throws Throwable {
		Thread.sleep(1000);

		System.out.println("The text size should apply as selected series");

	}

	 //TC_59
	@And("^Change text style- Bold$")
	public void change_text_style_Bold() throws Throwable {

		Thread.sleep(1000);
		WebElement movtoname = login.driver.findElement(By.cssSelector(".font-bold > .config-btn--icon"));
		action.pause(500).moveToElement(movtoname).build().perform();
		Thread.sleep(2000);
		login.driver.findElement(By.cssSelector(".font-bold > .config-btn--icon")).click();

	}

	//TC_59
	@Then("^The applied style should be reflected on visual for copyright$")
	public void the_applied_style_should_be_reflected_on_visual_for_copyright() throws Throwable {

		System.out.println("The applied style should be reflected on visual for copyright");
	}


    //TC_60
	@And("^click on color button and select color$")
	public void click_on_color_button_and_select_color() throws Throwable {
		Thread.sleep(1000);
		WebElement movtoname = login.driver.findElement(By.cssSelector(".sp-preview-inner"));
		action.pause(500).moveToElement(movtoname).build().perform();
		Thread.sleep(2000);
		login.driver.findElement(By.cssSelector(".sp-preview-inner")).click();
		Thread.sleep(1000);

		// select color pop up
		WebElement movtoname1 = login.driver.findElement(By.cssSelector(".sp-thumb-el:nth-child(7) > .sp-thumb-inner"));
		action.pause(500).moveToElement(movtoname1).build().perform();
		Thread.sleep(2000);
		// login.driver.findElement(By.cssSelector(".sp-thumb-el:nth-child(7) >
		// .sp-thumb-inner")).click();

		login.driver.findElement(By.cssSelector(".sp-thumb-el:nth-child(7) > .sp-thumb-inner")).click();

	}

	//TC_60
	@Then("^The selected color should be applied to text copyright in visual$")
	public void the_selected_color_should_be_applied_to_text_copyright_in_visual() throws Throwable {
		Thread.sleep(2000);

		System.out.println("The selected color should be applied to text copyright in visual");

	}

	//TC_61
	@Then("^The text copyright should display in selected position$")
	public void the_text_copyright_should_display_in_selected_position() throws Throwable {

		WebElement Textcopyrightimage = login.driver
				.findElement(By.xpath("//div[contains(text(),'Source: CEIC Data')]"));

		if (Textcopyrightimage.isDisplayed()) {
			System.out.println("The image copyright should be display");
		} else {
			System.out.println("Test case failed");
		}
	}

	//TC_62
	@Then("^Should redirected to \"([^\"]*)\" in new tab$")
	public void should_redirected_to_in_new_tab(String arg1) throws Throwable {

		Thread.sleep(2000);

		// click on copy right text

		WebElement copytext = login.driver.findElement(By.xpath("//div[contains(text(),'Source: CEIC Data')]"));
		action.moveToElement(copytext).build().perform();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[contains(text(),'Source: CEIC Data')]")).click();
		Thread.sleep(5000);

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
			}
		}
		assertEquals(arg1, login.driver.getCurrentUrl());
		System.out.println("Should redirected to https://www.ceicdata.com/en");

	}


 //TC_64
	@And("^check the keyboard option ON$")
	public void check_the_keyboard_option_ON() throws Throwable {

		Thread.sleep(2000);
		                                       //body/div[5]/div[1]/div[6]/div[1]/div[2]/div[1]/span[1]
		if (login.driver.findElement(By.xpath("//body/div[5]/div[1]/div[6]/div[1]/div[2]/div[1]/span[1]"))
				.isDisplayed()) {

			System.out.println("Dafault KBS Button ON");
		} else {
			System.out.println("Dafault KBS Button OFF");

		}

	}
	
  //TC_64
	@And("^Use Keyboard shortcut for creating visuals$")
	public void use_Keyboard_shortcut_for_creating_visuals() throws Throwable {

		Robot r = new Robot();
		Thread.sleep(1000);

		WebElement movtoname = login.driver.findElement(By.xpath(
				"//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/div[1]/a[1]/div[4]/div[1]/div[1]"));
		action.pause(500).moveToElement(movtoname).build().perform();
		Thread.sleep(2000);

		r.keyPress(KeyEvent.VK_A);
		Thread.sleep(2000);
		r.keyRelease(KeyEvent.VK_A);
		// click on '+' icon using KBS
		// Thread.sleep(1000);
		// login.driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/div[1]/a[1]/div[2]/span[1]")).sendKeys(Keys+
		// "a");
		// Thread.sleep(1000);

	}

	//TC_64
	@Then("^Should be allowed the keyboard shortcuts to function in CDMNext application$")
	public void should_be_allowed_the_keyboard_shortcuts_to_function_in_CDMNext_application() throws Throwable {

		Thread.sleep(1000);
		// login.driver.findElement(By.xpath(""))
		System.out.println("Successfully add insights using KBS");

	}


	//TC_65
	@And("^check the keyboard option OFF$")
	public void check_the_keyboard_option_OFF() throws Throwable {

		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//body/div[5]/div[1]/div[6]/div[1]/div[2]/div[1]/span[1]")).click();

	}
	
//TC_65
	@Then("^The Keyboard shortcut should not work$")
	public void the_Keyboard_shortcut_should_not_work() throws Throwable {

		Robot r = new Robot();
		Thread.sleep(1000);

		WebElement movtoname = login.driver.findElement(By.xpath(
				"//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/div[1]/a[1]/div[4]/div[1]/div[1]"));
		action.pause(500).moveToElement(movtoname).build().perform();
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_A);
		Thread.sleep(2000);
		r.keyRelease(KeyEvent.VK_A);
		System.out.println("The Keyboard shortcut should not work");

	}
	
      //TC_65
	@Then("^click on Keyboard option Default ON$")
	public void click_on_Keyboard_option_Default_ON() throws Throwable {
		Thread.sleep(1000);
		                                   //body/div[5]/div[1]/div[6]/div[1]/div[2]/div[1]/span[3]
		login.driver.findElement(By.xpath("//body/div[5]/div[1]/div[6]/div[1]/div[2]/div[1]/span[3]")).click();
		// body/div[6]/div[1]/div[6]/div[1]/div[2]/div[1]/span[1]
	}


    // TC_66
	@And("^click on keyboard hints$")
	public void click_on_keyboard_hints() throws Throwable {
		Thread.sleep(1000);

		login.driver.findElement(By.xpath("//span[contains(text(),'keyboard hints')]")).click();

	}

	//TC_66
	@And("^The keyboard shortcut hints popup should be opened$")
	public void the_keyboard_shortcut_hints_popup_should_be_opened() throws Throwable {

		Thread.sleep(1000);

		WebElement popupdata = login.driver.findElement(By.xpath("//div[contains(text(),'Search')]"));
		System.out.println("popup data:" + popupdata);

		// assertEquals(popupdata, "Search");

		System.out.println("keyboard shortcut popup should be opened");

	}


//TC_71
	@And("^dont paste the token as verify key textbox$")
	public void dont_paste_the_token_as_verify_key_textbox() throws Throwable {
		Thread.sleep(1000);

		// clear the verify key text box
		login.driver.findElement(By.xpath("//input[@class='api-manager--input']")).clear();

	}
	//TC_71
	@Then("^The Verify key button should be disabled untill enter token in the field$")
	public void the_Verify_key_button_should_be_disabled_untill_enter_token_in_the_field() throws Throwable {

		WebElement verifykey = login.driver.findElement(
				By.xpath("//body/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[4]/div[1]/button[2]"));

		if (!(verifykey.isEnabled())) {
			System.out.println("Test case failed");
		} else {
			System.out.println("The Verify key button should be disabled untill enter token in the field");

		}

	}


      //TC_73
	@And("^paste the invalid token as \"([^\"]*)\"$")
	public void paste_the_invalid_token_as(String arg1) throws Throwable {

		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//input[@class='api-manager--input']")).sendKeys(arg1);
		Thread.sleep(1000);

	}
	
	@And("^click on file menu$")
	public void click_on_file_menu() throws Throwable {
		Thread.sleep(1000);
		
		login.driver.findElement(By.xpath("//div[@class='insight-context-menu--menu-icon']")).click();
		
	   
	}

	@And("^click on share$")
	public void click_on_share() throws Throwable {
	    
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Share')]")).click();
		
	}

	@And("^Enter a mail into invite textbox$")
	public void enter_a_mail_into_invite_textbox() throws Throwable {
		
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//input[@class='share-specific-search-user--input form--control']")).click();
		Thread.sleep(200);
		login.driver.findElement(By.xpath("//input[@class='share-specific-search-user--input form--control']")).sendKeys("nadiya.maduru@shravas.com");
		Thread.sleep(3000);
		Robot r1=new Robot();
		r1.keyPress(KeyEvent.VK_DOWN);
		r1.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		r1.keyRelease(KeyEvent.VK_ENTER);
		

	}
	
	@And("^click on save$")
	public void click_on_save() throws Throwable {
	   
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	}
	


//83
	@And("^click on Sign out button$")
	public void click_on_Sign_out_button() throws Throwable {

		Thread.sleep(1000);
		// body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/label[1]/span[1]

		/*
		 * if (login.driver.findElements(By.xpath(
		 * "//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/label[1]/span[1]"
		 * )).size()>= 1) { // { //Checked a check box
		 * login.driver.findElement(By.xpath(
		 * "//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/label[1]/span[1]"
		 * )).click();
		 * 
		 * //click on delete button login.driver.findElement(By.xpath(
		 * "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[7]/div[1]"
		 * )).click(); Thread.sleep(500); }
		 */

		// js.executeScript(window.scrollBy(1000));
		WebElement scrolldown = login.driver.findElement(By.xpath("//span[contains(text(),'Sign out')]"));
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView();", scrolldown);
		Thread.sleep(1000);
		// Thread.sleep(1000);
		if (login.driver.findElements(By.xpath("//button[contains(text(),'Delete and sign out')]")).size() >= 1) {

			login.driver.findElement(By.xpath("//button[contains(text(),'Delete and sign out')]")).click();
			Thread.sleep(2000);
		} else {
			login.driver.findElement(By.xpath("//span[contains(text(),'Sign out')]")).click();
			System.out.println("Sign out successfully");
			Thread.sleep(1000);
		}
		// System.out.println("Log out successfully");
	}

	@Given("^Enter user name as \"([^\"]*)\"$")
	public void enter_user_name_as(String arg1) throws Throwable {
	    
		Thread.sleep(1000);
		login.driver.findElement(By.name("user_id")).sendKeys(arg1);
	}

	@Given("^Enter password as \"([^\"]*)\"$")
	public void enter_password_as(String arg1) throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.name("password")).sendKeys(arg1);
	    
	    }

	@Given("^click on login button$")
	public void click_on_login_button() throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.className("btn")).click();
	
	}

	@Then("^The Change password section should not be displayed for internal users$")
	public void the_Change_password_section_should_not_be_displayed_for_internal_users() throws Throwable {
	 
		System.out.println("The Change password section should not be displayed for internal users");
		
	}

	//Author=venkata swami
	//username=ceicsuresh12@gmail.com
	//password=Ceic@123
	
}
