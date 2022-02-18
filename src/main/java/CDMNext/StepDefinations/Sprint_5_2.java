package CDMNext.StepDefinations;

import static org.testng.Assert.fail;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.itextpdf.text.log.SysoCounter;

import CDMNext.util.CommonFunctionality;
import ch.qos.logback.core.net.SyslogOutputStream;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Sprint_5_2 extends CommonFunctionality {

	public static final Logger Log4j = Logger.getLogger("Log4j");
	public static Boolean logged_in = false;
	public static Robot robot;
	public String username = "";
	public String password = "";
	public static Properties LOCATORS;
	ArrayList<String> newTab;
	JavascriptExecutor js = (JavascriptExecutor) login.driver;
	CDMNextSprintCases cv = new CDMNextSprintCases();

	@Given("^User enters \"([^\"]*)\" in the search panel and save the search and click on the share icon$")
	public void user_enters_in_the_search_panel_and_save_the_search_and_click_on_the_share_icon(String arg1)
			throws Throwable {

		Thread.sleep(5000);

		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches"))).isDisplayed()) {
			login.Log4j.info("My Search folder avilable in Page");
			CommonFunctionality.wait(5000);
			// webDriverwait_locator(login.LOCATORS.getProperty("My_Searches"), "xpath");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches"))).click();
			login.Log4j.info("Clicked on My Search folder.");
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches1")));
			CommonFunctionality.action.moveToElement(ele).pause(5).build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("remove"))).click();
			login.Log4j.info("hovered on My Search folder and deleted the india");
			CommonFunctionality.wait(10000);
		}
		login.Log4j.info("My Search folder not avilable in webpage");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys("India", Keys.ENTER);
		login.Log4j.info("Entered the Text india in search text box");
		Thread.sleep(2000);
		WebElement element = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("save1")));
		jse.executeScript("arguments[0].click();", element);
	    login.Log4j.info("Clicked on Save Button");
	    CommonFunctionality.wait(3000);
		webDriverwait_locator(login.LOCATORS.getProperty("Search_enter"), "xpath");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search_enter"))).click();
		CommonFunctionality.wait(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search_enter"))).sendKeys("India");
		login.Log4j.info("Text india Entered in Saved searched Text Box");
		CommonFunctionality.wait(500);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Save_New"))).click();
		login.Log4j.info("Clicked on Sqave new Search");
		CommonFunctionality.wait(1000);
		String Save = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Save_Message"))).getText();
		Assert.assertEquals(Save, "Search saved!");
		login.Log4j.info("Succesfully Search saved!");
		CommonFunctionality.wait(3000);

		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches"))).click();
		login.Log4j.info("Clicked on My Search folder");
		WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches1")));
		CommonFunctionality.action.moveToElement(ele).pause(2).build().perform();
		login.Log4j.info("hovered on  Search folder");

	}

	@Given("^select a user and share\\.$")
	public void select_a_user_and_share() throws Throwable {

		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Share"))).click();
		login.Log4j.info("Clicked on Share icon");

		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Place_click"))).click();

		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Place_click"))).sendKeys("ceicsuresh@gmail.com");
		login.Log4j.info("Entered the Specific User : ceicsuresh@gmail.com");
		CommonFunctionality.wait(3000);
		action.sendKeys(Keys.ENTER).build().perform();
		CommonFunctionality.wait(3000);
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		login.Log4j.info("Selected the Specific User : ceicsuresh@gmail.com");
		CommonFunctionality.wait(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("save_button"))).click();
		login.Log4j.info("Clicked on save button for Specific user ");
		String Message = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Shared_Message"))).getText();
		System.out.println("=====================" + Message);
		Assert.assertEquals(Message, "Selected search was successfully shared.");
		login.Log4j.info("Selected search was successfully shared.");

		Thread.sleep(10000);
	}

	@And("^Launch the private window$")
	public void launch_the_private_window() throws Throwable {
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_N);
		//CommonFunctionality.wait(5000);
		ArrayList<String> incog = new ArrayList<String>(login.driver.getWindowHandles());
		Thread.sleep(5000);
		login.driver.switchTo().window(incog.get(1));
		Thread.sleep(10000);	
		
		login.driver.navigate().to("https://stage.ceicdata.com/login");
		System.out.println("====Title====" + login.driver.getTitle());
		login.Log4j.info("successfully Private window Opened");
	}

	@And("^Enters username username$")
	public void enters_username_username() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("input_username"))).clear();

		Log4j.info("Trying to login with Username:" + username);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("input_username"))).sendKeys("ceicsuresh@gmail.com");

	}


	@Given("^Enters password password$")
	public void enters_password_password() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("input_password"))).clear();
		Log4j.info("Trying to login with Password:" + password);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("input_password"))).sendKeys("Ceic@123");
		CommonFunctionality.wait(3000);

	}

	@And("^Login to the shared user account\\.$")
	public void login_to_the_shared_user_account() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//*[text()='No, take me to CDMNext']")).click();
		login.Log4j.info("Clicked on No, take me to CDMNext Alert");
	}

	@Then("^check for shared search under \"([^\"]*)\"\\.$")
	public void check_for_shared_search_under(String arg1) throws Throwable {

		try {

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(login.LOCATORS.getProperty("My_Searches"))));
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches"))).click();
			login.Log4j.info("Clicked on  Mysearch folder");

			if (CommonFunctionality.getElementByXpath(login.driver, login.LOCATORS.getProperty("Shared_To"), 500)
					.isDisplayed()) {

				login.Log4j.info("India is displayed under shared with me section");
			} else {
				fail("Failed");
			}

			ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
			login.driver.switchTo().window(newTab.get(1)).close();
			Thread.sleep(1000);
			login.driver.switchTo().window(newTab.get(0));

		} catch (Exception e) {
			ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
			login.driver.switchTo().window(newTab.get(1)).close();
			Thread.sleep(1000);
			login.driver.switchTo().window(newTab.get(0));
		}

	}

	@Given("^waittime$")
	public void waittime() throws Throwable {
		login.Log4j.info("Second test started ");
		Thread.sleep(10000);
		login.Log4j.info("India is displayed under shared with me section");

		login.Log4j.info("Second test time end ");
	}

	@Then("^select Shared Search\\.$")
	public void select_Shared_Search() throws Throwable {
		CommonFunctionality.wait(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches"))).click();
		if (CommonFunctionality.getElementByXpath(login.driver, login.LOCATORS.getProperty("Shared_To"), 500)
				.isDisplayed()) {

			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("India_click"))).click();
			CommonFunctionality.wait(3000);
			if (CommonFunctionality.getElementByXpath(login.driver, login.LOCATORS.getProperty("Region"), 500)
					.isDisplayed()) {

				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_list"))).click();

				String India = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("India_Region"))).getText();
				System.out.println("==============" + India);
				Assert.assertEquals(India, "India");
				CommonFunctionality.wait(5000);

			}

		} else {
			fail("Failed");
		}

		ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(newTab.get(1)).close();
		Thread.sleep(1000);
		login.driver.switchTo().window(newTab.get(0));

	}

	@When("^select Shared Search option\\.$")
	public void select_Shared_Search_option() throws Throwable {

		CommonFunctionality.wait(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches"))).click();
		if (CommonFunctionality.getElementByXpath(login.driver, login.LOCATORS.getProperty("Shared_To"), 500)
				.isDisplayed()) {

			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("India_click"))).click();
			CommonFunctionality.wait(3000);
			if (CommonFunctionality.getElementByXpath(login.driver, login.LOCATORS.getProperty("Region"), 500)
					.isDisplayed()) {

				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_list"))).click();

				String India = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("India_Region"))).getText();
				System.out.println("==============" + India);
				Assert.assertEquals(India, "India");
				CommonFunctionality.wait(5000);

				/*
				 * newTab = new ArrayList<String>(login.driver.getWindowHandles());
				 * login.driver.switchTo().window(newTab.get(0));
				 */

			}

		} else {
			fail("Failed");
		}
		ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
		// login.driver.switchTo().window(newTab.get(1)).close();
		Thread.sleep(1000);
		login.driver.switchTo().window(newTab.get(0));

	}

	@Then("^Move the mouse on \"([^\"]*)\" under Share with Me\\.$")
	public void move_the_mouse_on_under_Share_with_Me(String arg1) throws Throwable {

		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches"))).click();

		login.Log4j.info("my search folder avilable");
		if (CommonFunctionality.getElementByXpath(login.driver, login.LOCATORS.getProperty("Shared_To"), 500)
				.isDisplayed()) {

			login.Log4j.info("Share to me displayed");

			CommonFunctionality.wait(3000);

			WebElement Search = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("India_click")));
			CommonFunctionality.action.moveToElement(Search).pause(2).build().perform();
			login.Log4j.info("mouse paused on india");

			List<WebElement> ShareInv = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Share_inv")));
			for (int i = 0; i < ShareInv.size(); i++) {
				String value = ShareInv.get(i).getText();
				if (!ShareInv.get(i).getText().contains("Share")) {

					Assert.assertTrue(true);
					login.Log4j.info("Share Icon is invisible ");

				} else {

					login.Log4j.info("Share Icon is visible ");
					Assert.assertTrue(false);

					
				}

			}

		}

		else {
			fail("failed");
		}

		ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(newTab.get(1)).close();
		Thread.sleep(1000);
		login.driver.switchTo().window(newTab.get(0));
	}

	@Then("^Click on Copy Icon\\.$")
	public void click_on_Copy_Icon() throws Throwable {
		// CommonFunctionality.wait(3000);
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches"))).click();
		// CommonFunctionality.wait(3000);

		CommonFunctionality.wait(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches"))).click();
		WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches1")));

		CommonFunctionality.action.moveToElement(ele).pause(5).build().perform();

		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_url"))).click();
		CommonFunctionality.wait(3000);
		String Copy_url = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_Message"))).getText();
		System.out.println("=====================" + Copy_url);
		Assert.assertEquals(Copy_url, "URL link copied.");

		ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(newTab.get(1)).close();
		Thread.sleep(1000);
		login.driver.switchTo().window(newTab.get(0));

	}

	@When("^Click on Copy Icon and open browser\\.$")
	public void click_on_Copy_Icon_and_open_browser() throws Throwable {
		CommonFunctionality.wait(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches"))).click();
		WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches1")));

		CommonFunctionality.action.moveToElement(ele).pause(5).build().perform();

		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_url"))).click();
		CommonFunctionality.wait(3000);
		String Copy_url = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_Message"))).getText();
		System.out.println("=====================" + Copy_url);
		Assert.assertEquals(Copy_url, "URL link copied.");

	}

	@Then("^Run URL in the browser$")
	public void run_URL_in_the_browser() throws Throwable {
		CommonFunctionality.wait(3000);
		CommonFunctionality.jse.executeScript("window.open('newpage.html','_blank');");

	}

	@Then("^Run in the browserand copy the URL in the new Tab$")
	public void run_in_the_browserand_copy_the_URL_in_the_new_Tab() throws Throwable {

		CommonFunctionality.wait(3000);
		// action.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();

		CommonFunctionality.jse.executeScript("window.open('newpage.html','_blank');");
		CommonFunctionality.wait(3000);
		if (CommonFunctionality.getElementByXpath(login.driver, login.LOCATORS.getProperty("India_Details"), 500)
				.isDisplayed()) {

			login.Log4j.info("India results are displayed in new browser");
		} else {
			login.Log4j.info("India results are not displayed in new browser");
		}

		System.out.println("===enetered===");

		ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(newTab.get(2)).close();
		Thread.sleep(1000);
		login.driver.switchTo().window(newTab.get(1)).close();
		login.driver.switchTo().window(newTab.get(0));

	}

	@Given("^select a user and share and growl message should be displayed\\.$")
	public void select_a_user_and_share_and_growl_message_should_be_displayed() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Share"))).click();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Place_click"))).click();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Place_click"))).sendKeys("ceicsuresh@gmail.com");
		CommonFunctionality.wait(2000);
		action.sendKeys(Keys.ENTER).build().perform();
		CommonFunctionality.wait(1000);
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		CommonFunctionality.wait(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("save_button"))).click();
		// CommonFunctionality.wait(1000);

		String Message = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Shared_Message"))).getText();
		System.out.println("=====================" + Message);
		Assert.assertEquals(Message, "Selected search was successfully shared.");

	}

	@When("^stop sharing saved Search\\.$")
	public void stop_sharing_saved_Search() throws Throwable {

		CommonFunctionality.wait(3000);
		CommonFunctionality.wait(1000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("My_Searches"))).size() == 1) {
			CommonFunctionality.wait(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches"))).click();
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches1")));
			CommonFunctionality.action.moveToElement(ele).pause(2).build().perform();

			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Share"))).click();
			CommonFunctionality.wait(1000);

			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("User_remove"))).click();
			CommonFunctionality.wait(1000);

			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("save_button"))).click();
			Thread.sleep(5000);

			/*
			 * newTab = new ArrayList<String>(login.driver.getWindowHandles());
			 * login.driver.switchTo().window(newTab.get(1));
			 * login.driver.navigate().refresh(); Thread.sleep(5000);
			 * if(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches"
			 * ))).isDisplayed() ){
			 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches")))
			 * .click(); if (!CommonFunctionality. getElementByXpath(login.driver,
			 * login.LOCATORS.getProperty("Shared_To"), 500) .isDisplayed()) {
			 * 
			 * 
			 * 
			 * List<WebElement> MySearch =
			 * login.driver.findElements(By.xpath(login.LOCATORS.getProperty("My_Searches"))
			 * );
			 * 
			 * for (int i = 0; i < MySearch.size(); i++) { // String value =
			 * WhatsNew.get(i).getText(); //
			 * System.out.println("============================================"+value); //
			 * String replaceLine = value.replaceAll(",", ""); if
			 * (!MySearch.get(i).getText().contains("My searches")) {
			 * 
			 * Assert.assertTrue(true); login.Log4j.info("search has been stopped by user");
			 * 
			 * 
			 * } else {
			 * 
			 * Assert.assertTrue(false); login.Log4j.info("India is Displayed");
			 * 
			 * 
			 * }
			 * 
			 * } else { login.Log4j.info("My searches folder is not displayed");
			 * 
			 * }
			 */ }

		ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(newTab.get(1));

		/*
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches")))
		 * .click(); CommonFunctionality.wait(3000);
		 * 
		 * 
		 * 
		 * WebElement ele
		 * =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches1")
		 * )); CommonFunctionality.action.moveToElement(ele).pause(5).build().perform();
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty("remove"))).
		 * click(); CommonFunctionality.wait(10000);
		 */

	}

	@When("^Login to Shared User account$")

	public void login_to_Shared_User_account() throws Throwable {

	}

	@When("^Check for Shared Search$")
	public void check_for_Shared_Search() throws Throwable {
		login.driver.navigate().refresh();
		Thread.sleep(5000);
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches"))).isDisplayed()) {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches"))).click();
			if (!CommonFunctionality.getElementByXpath(login.driver, login.LOCATORS.getProperty("Shared_To"), 500)
					.isDisplayed()) {

								login.Log4j.info("--->search has been stopped by user<--------");

			} else {
				login.Log4j.info("India is Displayed");
				Assert.assertTrue(false);

			}
		}

		else {
			login.Log4j.info("India is not  Displayed");
			Assert.assertTrue(true);

		}

		ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(newTab.get(1)).close();
		Thread.sleep(1000);
		login.driver.switchTo().window(newTab.get(0));

	}


	@Given("^User enters \"([^\"]*)\" in the search panel and save the search$")
	public void user_enters_in_the_search_panel_and_save_the_search(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("My_Searches"))).size() == 1) {
			CommonFunctionality.wait(1000);

			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches"))).click();
			CommonFunctionality.wait(3000);

			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches1")));
			CommonFunctionality.action.moveToElement(ele).pause(5).build().perform();
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("remove"))).click();
			CommonFunctionality.wait(10000);

		}

		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys("India", Keys.ENTER);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("save1"))).click();

		CommonFunctionality.wait(3000);
		webDriverwait_locator(login.LOCATORS.getProperty("Search_enter"), "xpath");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search_enter"))).click();
		CommonFunctionality.wait(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search_enter"))).sendKeys("India");
		CommonFunctionality.wait(500);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Save_New"))).click();
		CommonFunctionality.wait(1000);
		String Save = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Save_Message"))).getText();
		Assert.assertEquals(Save, "Search saved!");

	}

	@Given("^move the mouse on the saved Search$")
	public void move_the_mouse_on_the_saved_Search() throws Throwable {

		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches"))).click();
		CommonFunctionality.wait(3000);

		WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches1")));
		CommonFunctionality.action.moveToElement(ele).pause(5).build().perform();

	}

	@Then("^click on copy Icon$")
	public void click_on_copy_Icon() throws Throwable {
		CommonFunctionality.wait(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_Url1"))).click();
		String Copy_url_link = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_Message"))).getText();
		System.out.println("=====================" + Copy_url_link);
		Assert.assertEquals(Copy_url_link, "URL link copied.");

		Log4j.info("URL link copied");

	}

	@Given("^select a user and Share Option\\.$")
	public void select_a_user_and_Share_Option() throws Throwable {

		CommonFunctionality.wait(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Share"))).click();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Place_click"))).click();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Place_click"))).sendKeys("ceicsuresh@gmail.com");
		CommonFunctionality.wait(3000);
		action.sendKeys(Keys.ENTER).build().perform();
		CommonFunctionality.wait(5000);
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		CommonFunctionality.wait(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("save_button"))).click();
		String Message = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Shared_Message"))).getText();
		Assert.assertEquals(Message, "Selected search was successfully shared.");

		Thread.sleep(10000);
		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_SHIFT);

		robot.keyPress(KeyEvent.VK_N);

		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyRelease(KeyEvent.VK_SHIFT);

		robot.keyRelease(KeyEvent.VK_N);

		Thread.sleep(10000);

		ArrayList<String> incog = new ArrayList<String>(login.driver.getWindowHandles());
		System.out.println("=================" + incog);
		login.driver.switchTo().window(incog.get(1));

		
		CommonFunctionality.wait(3000);

		login.driver.navigate().to("https://stage.ceicdata.com/login");
		

		CommonFunctionality.wait(3000);
		// login.driver.switchTo().window(newTab.get(1));
		System.out.println("====Title====" + login.driver.getTitle());
		

	}

	@Given("^User selects any series and creates a visual Table from More Actions\\.$")
	public void user_selects_any_series_and_creates_a_visual_Table_from_More_Actions() throws Throwable {
		try {
			CommonFunctionality.wait(500);
			WebElement Serieslist = login.driver.findElement(
					By.xpath("//div[@class='series-list-item-data']/div[@class='series-list-item--information'][1]"));
			new Actions(login.driver).moveToElement(Serieslist).pause(3000).build().perform();
		    WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("More_actions")));
			CommonFunctionality.action.moveToElement(ele1).pause(2).click().build().perform();
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("table5"))).click();

		} catch (Exception e) {

			CommonFunctionality.wait(500);
			WebElement Serieslist = login.driver.findElement(
					By.xpath("//div[@class='series-list-item-data']/div[@class='series-list-item--information'][1]"));
			new Actions(login.driver).moveToElement(Serieslist).pause(3000).build().perform();
			WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("More_actions")));
			CommonFunctionality.action.moveToElement(ele1).pause(2).click().build().perform();
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("table5"))).click();

		}

	}

	@And("^clicks on Edit Table which is under view Tab\\.$")
	public void clicks_on_Edit_Table_which_is_under_view_Tab() throws Throwable {
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edittable"))).click();

	}

	@And("^make changes in settings\\.$")
	public void make_changes_in_settings() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Statistics_checkbox"))).click();

	}

	@And("^click on the \\+ icon and enter the text as \"([^\"]*)\" and save the style\\.$")
	public void click_on_the_icon_and_enter_the_text_as_and_save_the_style(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//div[@class='context-menu-control context-menu-control__clean context-menu-control__icon']//div[@class='context-menu-control--icon']")).click();
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Styles"))).isDisplayed()) {
			login.Log4j.info("My Style  is available in Page");
			CommonFunctionality.wait(5000);
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Styles1")));
			CommonFunctionality.action.moveToElement(ele).pause(5).build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Style_removed1"))).click();
			Thread.sleep(4000);
			login.driver.findElement(By.xpath("//button[@class='sphere-modal-control button button__primary']")).click();
			login.Log4j.info("hovered on My Style  and deleted Suresh");

		}
		CommonFunctionality.wait(2000);

		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_template_icon"))).click();
		login.driver.findElement(By.xpath(
				"//div[@class='add-template-context--wrapper']//input[@class='add-template-context--input form--control form--control__sm']"))
				.clear();
		login.driver.findElement(By.xpath(
				"//div[@class='add-template-context']//input[@class='add-template-context--input form--control form--control__sm']"))
				.sendKeys(arg1);
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(
				"//div[@class='add-template-context']//div[@class='add-template-context--icon add-template-context--icon__apply']"))
				.click();

	}
	@Then("^Move the mouse on saved style and click on share icon\\.$")
	public void move_the_mouse_on_saved_style_and_click_on_share_icon() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(
				"//div[@class='context-menu-control context-menu-control__clean context-menu-control__icon']//div[@class='context-menu-control--icon']"))
				.click();
		CommonFunctionality.wait(2000);

		WebElement Share = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Share_mouse")));
		CommonFunctionality.action.moveToElement(Share).pause(2).build().perform();
		login.Log4j.info("hovered on  style  template");
		if (Share.isDisplayed()) {

			login.driver
					.findElement(
							By.xpath("//div[@class='style-templates-item--icon-base style-templates-item--share']"))
					.click();
			login.Log4j.info("Share Popup is displayed");

		} else {
			login.Log4j.info("Share Popup is not displayed");

		}
	}

	@Given("^Move the mouse on saved style and click on the share icon\\.$")
	public void move_the_mouse_on_saved_style_and_click_on_the_share_icon() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(
				"//div[@class='context-menu-control context-menu-control__clean context-menu-control__icon']//div[@class='context-menu-control--icon']"))
				.click();
		CommonFunctionality.wait(2000);

		WebElement Share = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Share_mouse")));
		CommonFunctionality.action.moveToElement(Share).pause(2).build().perform();
		login.Log4j.info("hovered on  style  template");
		login.driver
				.findElement(By.xpath("//div[@class='style-templates-item--icon-base style-templates-item--share']"))
				.click();

	}

	@Given("^select a user and share style\\.$")
	public void select_a_user_and_share_style() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Place_click"))).click();

		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Place_click"))).sendKeys("ceicsuresh@gmail.com");
		login.Log4j.info("Entered the Specific User : ceicsuresh@gmail.com");
		CommonFunctionality.wait(3000);
		action.sendKeys(Keys.ENTER).build().perform();
		CommonFunctionality.wait(3000);
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		login.Log4j.info("Selected the Specific User : ceicsuresh@gmail.com");
		CommonFunctionality.wait(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("save_button"))).click();
		login.Log4j.info("Clicked on save button for Specific user ");
		String Message = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Shared_Style"))).getText();
		Assert.assertEquals(Message, "Selected style was successfully shared.");

	}

	@When("^shared visual style should be available under 'Shared to me'\\.$")
	public void shared_visual_style_should_be_available_under_Shared_to_me() throws Throwable {

		CommonFunctionality.wait(2000);
		WebElement Serieslist = login.driver.findElement(
				By.xpath("//div[@class='series-list-item-data']/div[@class='series-list-item--information'][1]"));
		new Actions(login.driver).moveToElement(Serieslist).pause(3000).build().perform();
		WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("More_actions")));
		CommonFunctionality.action.moveToElement(ele1).pause(2).click().build().perform();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("table5"))).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edittable"))).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Statistics_checkbox"))).click();

		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(
				"//div[@class='context-menu-control context-menu-control__clean context-menu-control__icon']//div[@class='context-menu-control--icon']"))
				.click();
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ShareTo_Me"))).isDisplayed()) {
			login.Log4j.info("Shared Style is Available under shared with me");

		} else {
			login.Log4j.info("Shared Style is not Available under shared with me");
		}
		ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(newTab.get(1)).close();
		Thread.sleep(1000);
		login.driver.switchTo().window(newTab.get(0));

	}

	@When("^Select shared style\\.$")
	public void select_shared_style() throws Throwable {
		try {
			CommonFunctionality.wait(2000);
			WebElement Serieslist = login.driver.findElement(
					By.xpath("//div[@class='series-list-item-data']/div[@class='series-list-item--information'][1]"));
			new Actions(login.driver).moveToElement(Serieslist).pause(3000).build().perform();
			WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("More_actions")));
			CommonFunctionality.action.moveToElement(ele1).pause(2).click().build().perform();
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("table5"))).click();
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edittable"))).click();
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Statistics_checkbox"))).click();

			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath(
					"//div[@class='context-menu-control context-menu-control__clean context-menu-control__icon']//div[@class='context-menu-control--icon']"))
					.click();
			if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ShareTo_Me"))).isDisplayed()) {
				CommonFunctionality.wait(2000);
				Thread.sleep(5000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Save_popup"))).click();
				Thread.sleep(10000);

			}
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());

		}

	}

	@Then("^Validate Visual Style\\.$")
	public void validate_Visual_Style() throws Throwable {
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Mean"))).isDisplayed()) {
			 login.Log4j.info("Mean displayed");
		} else {
			 login.Log4j.info("Mean not displayed");
		}

		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Variance"))).isDisplayed()) {
			login.Log4j.info("Variance displayed");
		} else {
			login.Log4j.info("Variance not displayed");
		}

		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Standard_deviation"))).isDisplayed()) {
			login.Log4j.info("Standard deviation  displayed");
		} else {
			login.Log4j.info("Standard deviation not displayed");
		}
		ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(newTab.get(1)).close();
		Thread.sleep(1000);
		login.driver.switchTo().window(newTab.get(0));

	}

	@When("^mouseover on the shared style\\.$")
	public void mouseover_on_the_shared_style() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement Serieslist = login.driver.findElement(
				By.xpath("//div[@class='series-list-item-data']/div[@class='series-list-item--information'][1]"));
		new Actions(login.driver).moveToElement(Serieslist).pause(3000).build().perform();
		WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("More_actions")));
		CommonFunctionality.action.moveToElement(ele1).pause(2).click().build().perform();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("table5"))).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edittable"))).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Statistics_checkbox"))).click();

		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(
				"//div[@class='context-menu-control context-menu-control__clean context-menu-control__icon']//div[@class='context-menu-control--icon']"))
				.click();
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ShareTo_Me"))).isDisplayed()) {

			WebElement Share_style = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Sharestyle_mouseover")));
			CommonFunctionality.action.moveToElement(Share_style).pause(5).build().perform();

		}

	}

	@Then("^Validate Share and delete options\\.$")
	public void validate_Share_and_delete_options() throws Throwable {
		CommonFunctionality.wait(2000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Share_style_inv"))).size() == 0) {
			System.out.println("share icon is visible");

		} else {
			System.out.println("fail");
		}

		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Style_removed1"))).size() == 0) {
			System.out.println("delete icon invisible");

		} else {
			System.out.println("fail");

		}
		ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(newTab.get(1)).close();
		Thread.sleep(1000);
		login.driver.switchTo().window(newTab.get(0));

	}

	@When("^check for shared style\\.$")
	public void check_for_shared_style() throws Throwable {
		login.driver.navigate().refresh();
		CommonFunctionality.wait(2000);
		WebElement Serieslist = login.driver.findElement(
				By.xpath("//div[@class='series-list-item-data']/div[@class='series-list-item--information'][1]"));
		new Actions(login.driver).moveToElement(Serieslist).pause(3000).build().perform();
		WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("More_actions")));
		CommonFunctionality.action.moveToElement(ele1).pause(2).click().build().perform();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("table5"))).click();

		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edittable"))).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Statistics_checkbox"))).click();

		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(
				"//div[@class='context-menu-control context-menu-control__clean context-menu-control__icon']//div[@class='context-menu-control--icon']"))
				.click();
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ShareTo_Me"))).isDisplayed()) {
						login.Log4j.info("Shared Style is Available under shared with me");

		} else {
			login.Log4j.info("Shared Style is not Available under shared with me");
		}

		ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
		Thread.sleep(1000);
		login.driver.switchTo().window(newTab.get(0));

	}

	@When("^stop sharing saved Style\\.$")
	public void stop_sharing_saved_Style() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(
				"//div[@class='context-menu-control context-menu-control__clean context-menu-control__icon']//div[@class='context-menu-control--icon']"))
				.click();
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Styles"))).isDisplayed()) {
			CommonFunctionality.wait(2000);

			WebElement Share = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Share_mouse")));
			CommonFunctionality.action.moveToElement(Share).pause(2).build().perform();
			login.Log4j.info("hovered on  style  template");
			login.driver
					.findElement(
							By.xpath("//div[@class='style-templates-item--icon-base style-templates-item--share']"))
					.click();
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("User_remove"))).click();
			CommonFunctionality.wait(1000);

			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("save_button"))).click();
			Thread.sleep(5000);

		}
		ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(newTab.get(1));

	}

	@Then("^check for Shared style under shared with me\\.$")
	public void check_for_Shared_style_under_shared_with_me() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.navigate().refresh();
		
		login.driver.findElement(By.xpath(
				"//div[@class='context-menu-control context-menu-control__clean context-menu-control__icon']//div[@class='context-menu-control--icon']"))
				.click();

		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ShareTo_Me"))).isDisplayed()) {

			System.out.println("Test case failed");

		} else {
			System.out.println("Test case pass");

		}
		ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(newTab.get(1)).close();
		Thread.sleep(1000);
		login.driver.switchTo().window(newTab.get(0));

	}
	@Given("^user enters  searches \"([^\"]*)\"$")
	public void user_enters_searches(String arg1) throws Throwable {
		login.driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(arg1, Keys.ENTER);
		login.driver.findElement(By.xpath("//span[normalize-space()='Save']")).click();
		
		login.driver.findElement(By.xpath("//input[@class='insight-search-input--search-field']")).sendKeys(arg1);
		login.driver.findElement(By.xpath("//span[@class='save-search--save-new']")).click();
		
		
		
		
		
		
		
		
		
		
		
		
		
	    
	}

	
	
	

	@Given("^user enters  searches \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"\\.$")
	public void user_enters_searches(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6)
			throws Throwable {
		
			
			
		
		
		
		
		
		CommonFunctionality.wait(2000);	
		if(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Mysearch_folder"))).isDisplayed()){
			
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Mysearch_folder"))).click();
			login.Log4j.info("Clicked on My Search folder.");
		
		
			

				
				WebElement element = login.driver.findElement(By.xpath("//span[@class='searches-item--title'][normalize-space()='"+arg6+"']"));
				((JavascriptExecutor) login.driver).executeScript("arguments[0].scrollIntoView(true);", element);
				
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Mysearch_border"))).isDisplayed()) {
					List<WebElement> list = login.driver.findElements(By.xpath("//span[@class='searches-item--title']"));
					Thread.sleep(2000);
					
					for (int i=0; i<list.size(); i++) {				
						
						String ss =login.driver.findElement(By.xpath("//span[@class='searches-item--title']")).getText();
						
						
						
						
						WebElement ele=login.driver.findElement(By.xpath("//span[text()='"+ss+"']"));				
						CommonFunctionality.action.moveToElement(ele).pause(5).build().perform();
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("remove"))).click();
						
						Thread.sleep(2000);
					
				}
					
				}					
				
		}
		
		login.Log4j.info("My search not available in web page");
		String Searches="raj,guru1,test2,test,mahesh,shankar";
		String[] myArray=Searches.split(";");
		List<String> mySearches=new ArrayList<>();
		for(String search: myArray) {
			mySearches.add(search);
			
		}
	}
		
	@Given("^save the search\\.$")
	public void save_the_search() throws Throwable {

	}

	@Then("^scroll bar should be displayed and border should be applied for the popup after (\\d+) saved searchs created\\.$")
	public void scroll_bar_should_be_displayed_and_border_should_be_applied_for_the_popup_after_saved_searchs_created(
			int arg1) throws Throwable {

	}
	
	@Given("^user Logout from current user$")
	public void user_Logout_from_current_user() throws Throwable {
		CommonFunctionality.wait(3000);
		CommonFunctionality.getElementBycssSelector(login.driver, "div[title='View and edit profile information']", 4)
				.click();
		WebElement logout = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Sign out')]", 4);
		js.executeScript("arguments[0].scrollIntoView(true);", logout);
		js.executeScript("arguments[0].click();", logout);
		cv.the_application_should_be_logged_out();
	}

	@And("^User logins into CDM Next with Username : \"([^\"]*)\" and Password : \"([^\"]*)\"\\.$")
	public void user_logins_into_CDM_Next_with_Username_and_Password(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys(arg1);
		login.driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(arg2);
		login.driver.findElement(By.xpath("//button[@type='submit']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//*[text()='No, take me to CDMNext']")).click();
		login.Log4j.info("Clicked on No, take me to CDMNext Alert");
		login.driver.findElement(By.xpath("//span[@value='LIST']")).click();
		WebElement watchlist = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Watchlist_hovered")));
		CommonFunctionality.action.moveToElement(watchlist).pause(2).build().perform();
		login.driver.findElement(By.xpath("//span[@title='Add to watchlist'] ")).click();
		
		
		
		
		
		

	}

	@Then("^Check for Email Id field for watchlist across the application\\.$")
	public void check_for_Email_Id_field_for_watchlist_across_the_application() throws Throwable {
		CommonFunctionality.wait(2000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Email_notification"))).size()==0) {
			login.Log4j.info("Email notification Popup is not displayed");
			
		}
		else {
			login.Log4j.info("Email notification Popup is  displayed");
			
		}

	}
	
	
	@Given("^user selects View as a Histogram from More actions$")
	public void user_selects_View_as_a_Histogram_from_More_actions() throws Throwable {
		WebElement Serieslist = login.driver.findElement(By.xpath("//div[@class='series-list-item-data']/div[@class='series-list-item--information'][1]"));
		new Actions(login.driver).moveToElement(Serieslist).pause(3000).build().perform();

    WebElement Actions_dd = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("More_actions")));
		CommonFunctionality.action.moveToElement(Actions_dd).pause(2).click().build().perform();
		CommonFunctionality.wait(2000);
	WebElement view=	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("View_as")));
		CommonFunctionality.action.moveToElement(view).pause(2).click().build().perform();
		login.driver.findElement(By.xpath("//span[@title='Histogram']")).click();
		login.driver.findElement(By.xpath("//div[@class='visual-top-panel--left-controls']//button[text()='Edit Histogram']")).click();
		//login.driver.findElement(By.xpath("//div[@data-view-item-id='view3207']//div[@class='context-menu-control--icon']"));
		login.driver.findElement(By.xpath("//*[text()='Title:']//parent::div//following-sibling::div[@class='context-menu-control--icon']")).click();
		
		
		
	    
	}
	@And("^clicks on edit Histogram and enter title as \"([^\"]*)\"\\.$")
	public void clicks_on_edit_Histogram_and_enter_title_as(String arg1) throws Throwable {
		//login.driver.findElement(By.xpath("//input[@placeholder='auto']")).clear();
		login.driver.findElement(By.xpath("//input[@placeholder='auto']")).sendKeys(arg1);
		if(login.driver.findElement(By.xpath("//span[text()='"+arg1+"']")).isDisplayed()){
			login.Log4j.info("Shankar is displayed");
			
		
			
			
		}
		else{
			login.Log4j.info("Shankar is not displayed");
		}
		
		
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//input[@placeholder='auto']")).clear();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//button[@class='button button__primary']")).click();
		CommonFunctionality.wait(2000);
		
		login.driver.findElement(By.xpath("//div[@class='visual-top-panel--left-controls']//button[text()='Edit Histogram']")).click();
		login.driver.findElement(By.xpath("//*[text()='Title:']//parent::div//following-sibling::div[@class='context-menu-control--icon']")).click();
		login.driver.findElement(By.xpath("//input[@placeholder='auto']")).clear();
		if (!login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Title_checkbox"))).isSelected()) {
			System.out.println("====enter===");
			CommonFunctionality.wait(3000);
			String auto=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Auto_text"))).getText();
			System.out.println("=============="+auto);
			if(auto.contains("GDP Index: PY=100")) {
				login.Log4j.info("Auto series name is  displayed");
			}
			else {
				login.Log4j.info("Auto series name is not displayed");
				
			}
			
			
			
			
		}
		else {
			login.Log4j.info("Auto series name is not displayed");
		}

		

		
	    
	}
	
	@Given("^user clicks onOpen download window > Any tab$")
	public void user_clicks_onOpen_download_window_Any_tab() throws Throwable {
		
	    
	}

	@Given("^Move mouse on fx option\\.$")
	public void move_mouse_on_fx_option() throws Throwable {
	    
	}

	
	
	
	
	@Then("^Title > Add your title for the visual > displayed on visual$")
	public void title_Add_your_title_for_the_visual_displayed_on_visual() throws Throwable {
	   
	}

	@Then("^Removes the title\\.$")
	public void removes_the_title() throws Throwable {
	    
	}

	
	
	

	@Given("^user clicks on (\\d+) dots in datatab header$")
	public void user_clicks_on_dots_in_datatab_header(int arg1) throws Throwable {
		login.driver.findElement(By.xpath("//div[@class='search-presentation-tabs--drop-down-title']")).click();

	}

	@Given("^observe the checkbox for Datatab\\.$")
	public void observe_the_checkbox_for_Datatab() throws Throwable {
		CommonFunctionality.wait(2000);
		
		
		
		CommonFunctionality.wait(2000);
		
		
		CommonFunctionality.wait(2000);
		if (!login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Datatab_checkbox"))).isSelected()) {
			
			login.Log4j.info("Data tab checkbox is greyed out"); 	
		}
		else {
			login.Log4j.info("Data tab checkbox is enabled"); 
		}
	}

	

	@Given("^user clicks on Database section\\.$")
	public void user_clicks_on_Database_section() throws Throwable {
		login.driver
				.findElement(By.xpath(
						"//div[@class='toggler-control-item toggler-control-item__selected']/span[text()='Databases']"))
				.click();

	}

	@Given("^expand the database till table level\\.$")
	public void expand_the_database_till_table_level() throws Throwable {
		login.driver.findElement(By.xpath("//div[@data-node-model-id='GLOBAL']//div[@class='toggle']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//div[@data-node-model-id='GLOBAL&&ALL']//div[@class='toggle']")).click();
		login.driver.findElement(By.xpath("//div[@data-node-model-id='TP2560837']/div[1]")).click();
		login.driver.findElement(By.xpath("//div[@class='child-container']/div[@data-node-model-id='SC2576097']/div[1]")).click();
		CommonFunctionality.wait(2000);
		WebElement tt = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_mouse1")));
		CommonFunctionality.action.moveToElement(tt).pause(2).build().perform();

	}

	@Given("^click on dropdown for table\\.$")
	public void click_on_dropdown_for_table() throws Throwable {
		WebElement Table_dd = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_dd")));
		CommonFunctionality.action.moveToElement(Table_dd).pause(2).click().build().perform();
		CommonFunctionality.wait(2000);

	}

	@Then("^check for Add and group option\\.$")
	public void check_for_Add_and_group_option() throws Throwable {
		
		login.driver.findElement(By.xpath("//div[@class='add-to-data-selection--toggle']")).click();	
	WebElement ele=	login.driver.findElement(By.xpath("//span[@title='Add and group series in My Series (G)']"));
	System.out.println("*********************************"+ele.getAttribute("class"));
	if(ele.getAttribute("class").contains("disabled")) {
		 login.Log4j.info("Add and group option is greyed out ");
			
		
	}
	else {
		login.Log4j.info("Add and group option is enabled ");
	}
		
		
	}

	@Given("^user creates a table visual with (\\d+) series\\.$")
	public void user_creates_a_table_visual_with_series(int arg1) throws Throwable {
		login.driver.findElement(By.xpath("//span[@value='LIST']")).click();
		List<WebElement> list = login.driver.findElements(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']"));
		Thread.sleep(2000);
		
		for (int i=0; i<list.size(); i++) {	
			
		}
		
		

	}

	@Given("^scroll horizontal and verify the date column\\.$")
	public void scroll_horizontal_and_verify_the_date_column() throws Throwable {

	}

	
	@Given("^Search \"([^\"]*)\" in the search field\\.$")
	public void search_in_the_search_field(String arg1) throws Throwable {
		
		//span[@value='TREE']
		login.driver.findElement(By.xpath("//span[@value='TREE']")).click();
		login.driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(arg1,Keys.ENTER);
		
	}

	@Given("^select ShowAll filter\\.$")
	public void select_ShowAll_filter() throws Throwable {
		login.driver.findElement(By.xpath("//span[@value='ALL_NODES']")).click();
		
		
		

	}
	
	@And("^Logins with internal account with username : \"([^\"]*)\" and Password : \"([^\"]*)\"$")
	public void logins_with_internal_account_with_username_and_Password(String arg1, String arg2) throws Throwable {
		CommonFunctionality.login_as_internal_user(login.driver, "input[name='user_id']", "input[name='password']",
				"button[type='submit']", arg1, arg2);
	}

	@Given("^Open DB > Topic >Section>Table\\.$")
	public void open_DB_Topic_Section_Table() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//div[@class='database-node tree-node matched']//div[@class='toggle']")).click();
		login.driver.findElement(By.xpath("//div[@class='tree-node matched']//div[@class='toggle']")).click();
		login.driver.findElement(By.xpath("//div[@class='tree-node matched']//div[@class='toggle']")).click();
		
								

	}
	
	
	@Given("^Navigate to Analysis > FocusEconomics$")
	public void navigate_to_Analysis_FocusEconomics() throws Throwable {
		login.driver.findElement(By.xpath("(//span[@class='series-tab--text'][normalize-space()='Analysis'])[1]")).click();
		
	   	}

	@Then("^The folder name should be 'FocusEconomics'\\(oneword\\)\\.$")
	public void the_folder_name_should_be_FocusEconomics_oneword() throws Throwable {
		CommonFunctionality.wait(2000);
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Focus_economics"))).isDisplayed()) {
			login.Log4j.info("FocusEconomics is displayed as one word");	
			
		}
		else {
			login.Log4j.info("FocusEconomics is not displayed as one word");
			
		}
	    
	}

	@Then("^Orange and Green dots should display to indicate Orange as internal series and Green as Matched series\\.$")
	public void orange_and_Green_dots_should_display_to_indicate_Orange_as_internal_series_and_Green_as_Matched_series()
			throws Throwable {

	}
	
	
	
	@Given("^Share insight \"([^\"]*)\" from internal to external account\\.$")
	public void share_insight_from_internal_to_external_account(String arg1) throws Throwable {
		
		
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name_insight"))).isDisplayed()) {
			login.driver.findElement(By.xpath("//div[@class='insight-context-menu--menu-icon']")).click();
			login.driver.findElement(By.xpath("//span[contains(text(),'New')]")).click();
			login.driver.findElement(By.xpath("//input[@type='text' and @ui='$name']")).click();
			login.driver.findElement(By.xpath("//input[@type='text' and @ui='$name']")).clear();
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath("//input[@type='text' and @ui='$name']")).sendKeys(arg1);
			login.driver.findElement(By.xpath("//button[@class='sphere-modal-control button button__primary']")).click();
			CommonFunctionality.wait(2000);
			
			login.driver.findElement(By.xpath("//div[@class='insight-context-menu--menu-icon']")).click();
			login.driver.findElement(By.xpath("//span[contains(text(),'Share')]")).click();
			login.driver.findElement(By.xpath("//input[@placeholder='Type people/accounts/companies you want to invite']")).click();
			login.driver.findElement(By.xpath("//input[@placeholder='Type people/accounts/companies you want to invite']")).sendKeys("shankar.test@gmail.com",Keys.ENTER);
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath("//button[@class='sphere-modal-control button button__primary']")).click();
			login.driver.findElement(By.xpath("//button[normalize-space()=\"Don't email\"]")).click();	
			CommonFunctionality.getElementBycssSelector(login.driver, "div[title='View and edit profile information']", 4).click();
	    WebElement logout = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Sign out')]", 4);
	   js.executeScript("arguments[0].scrollIntoView(true);", logout);
	   js.executeScript("arguments[0].click();", logout);
	   cv.the_application_should_be_logged_out();
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
	    
	}
	@Given("^Login to shared user account\\.$")
	public void login_to_shared_user_account() throws Throwable {
		CommonFunctionality.wait(500);
		CommonFunctionality.login_as_ceic_user(login.driver, "input[name='user_id']", "input[name='password']",
				"button[type='submit']", "shankar.test@gmail.com");
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//*[text()='No, take me to CDMNext']")).click();
		login.Log4j.info("Clicked on No, take me to CDMNext Alert");
		
		
		
		
	    
	}

	@Then("^Notification > check for the shared user name\\.$")
	public void notification_check_for_the_shared_user_name() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//div[@class='user-notifications--icon']")).click();
			
			
		
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Notification_ceic"))).isDisplayed()) {
			 login.Log4j.info("CEIC insights is displayed under notifications");
			
			
		}
		else {
			login.Log4j.info("CEIC insights is not displayed under notifications");
			
		}
	   
	}

	
	

	@Given("^user clicks on Download window\\.$")
	public void user_clicks_on_Download_window() throws Throwable {
		
		CommonFunctionality.wait(500);
		WebElement Series = login.driver.findElement(
				By.xpath("//div[@class='series-list-item-data']/div[@class='series-list-item--information'][1]"));
		new Actions(login.driver).moveToElement(Series).pause(3000).build().perform();
		WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("More_actions")));
		CommonFunctionality.action.moveToElement(ele1).pause(2).click().build().perform();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("table5"))).click();
		login.driver.findElement(By.xpath("//div[@class='drop-down-button download-button download-button__header drop-down-button__small']//span[2]")).click();
		CommonFunctionality.wait(3000);
		CommonFunctionality.wait(3000);
		WebElement Fx_function = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("fx_mouse")));
		CommonFunctionality.action.moveToElement(Fx_function).pause(2).build().perform();
		
		

	}

	@Given("^move the mouse on fx options\\.$")
	public void move_the_mouse_on_fx_options() throws Throwable {
		CommonFunctionality.wait(2000);
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("fx_mouse"))).isDisplayed()) {
		
		
		login.Log4j.info("More Functions is displayed");
		

	}
		else {
			login.Log4j.info("More Functions is not displayed");
			
		}
	}
	

	@Given("^user clicks on view and edit profile information\\.$")
	public void user_clicks_on_view_and_edit_profile_information() throws Throwable {
		login.driver.findElement(By.xpath("//span[@class='account-avatar--letters']")).click();
		
		

	
	}

	@Given("^click on change for copyright\\.$")
	public void click_on_change_for_copyright() throws Throwable {
		login.driver.findElement(By.xpath("//span[@class='style-sheet-settings--edit-button']")).click();

	}

	@Given("^uncheck the checkbox for copyright\\.$")
	public void uncheck_the_checkbox_for_copyright() throws Throwable {

	}

	@Then("^All options under setup should be greyed out when unchecked\\.$")
	public void all_options_under_setup_should_be_greyed_out_when_unchecked() throws Throwable {
		if (!login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Show_copyright"))).isSelected()) {
			login.Log4j.info("All options under setup are greyed out  ");
		}
		else {
			login.Log4j.info("All options under setup are enabled");
			
		}
			
		}
	
	
	@Given("^user Clicks on Login to CDMNext with an external account$")
	public void user_Clicks_on_Login_to_CDMNext_with_an_external_account() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//span[@value='LIST']")).click();
		
	   
	}

	@Then("^Search for (\\d+) observation series : \"([^\"]*)\"\\.$")
	public void search_for_observation_series(int arg1, String arg2) throws Throwable {
		
		login.driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(arg2);
		action.sendKeys(Keys.ENTER).build().perform();
		
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Observation_series"))).isDisplayed()) {
			login.Log4j.info("0 Observation series are visible to external user");
			login.driver.findElement(By.xpath("//span[@class='account-avatar--letters']")).click();
			login.driver.findElement(By.xpath("//div[@class='account-popup--item account-popup--item__bold']//a[contains(@class,'account-popup--link')]")).click();
			
			
		}
		else {
			login.Log4j.info("0 Observation series are not visible to external user");
			
		}
		
		
		
	   
	}


	

	@Given("^user clicks on Help Title\\.$")
	public void user_clicks_on_Help_Title() throws Throwable {
		login.driver.findElement(By.xpath("//div[@class='help-title--icon']")).click();
		
	}

	@Given("^Open report a problem popup\\.$")
	public void open_report_a_problem_popup() throws Throwable {
		login.driver.findElement(By.xpath("//div[normalize-space()='Report a problem']")).click();
	}

	@Given("^Upload attachment \\.$")
	public void upload_attachment() throws Throwable {
		login.driver.findElement(By.xpath("//label[@for='report_problem_attachments']")).click();
		CommonFunctionality.uploadTheFileusingAutoIT(login.driver,
				System.getProperty("user.dir") + "\\AutoIT\\Shravas.exe",
				System.getProperty("user.dir") + "\\AutoIT\\Shravas.png");

	}

	@Then("^click on remove icon\\.$")
	public void click_on_remove_icon() throws Throwable {
		
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Delete_iconupload"))).isDisplayed()) {
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Delete_iconupload"))).click();
			 login.Log4j.info("Delete icon is removed");
			
		}
		else {
			 login.Log4j.info("Delete icon is not  removed");
			
		}

	}

	@Given("^user Click on the edit table\\.$")
	public void user_Click_on_the_edit_table() throws Throwable {
		CommonFunctionality.wait(500);
		WebElement Serieslist = login.driver.findElement(
				By.xpath("//div[@class='series-list-item-data']/div[@class='series-list-item--information'][1]"));
		new Actions(login.driver).moveToElement(Serieslist).pause(3000).build().perform();
        CommonFunctionality.wait(2000);
		WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("More_actions")));
		CommonFunctionality.action.moveToElement(ele1).pause(2).click().build().perform();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("table5"))).click();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edittable"))).click();

	}

	@Given("^Click on the visual type dropdown\\.$")
	public void click_on_the_visual_type_dropdown() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table"))).click();
	}

	@Then("^current visual\\(table\\) should not display under the visual dropdown\\.$")
	public void current_visual_table_should_not_display_under_the_visual_dropdown() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Table_dd"))).size() == 0) {
			
			login.Log4j.info("Table is not displayed under visual dropdown.");
			
			
		}
		else {
			login.Log4j.info("Table is  displayed under visual dropdown.");
			
		}
		

	}

	@Given("^user Click on Help Menu Popup\\.$")
	public void user_Click_on_Help_Menu_Popup() throws Throwable {
		login.driver.findElement(By.xpath("//div[@class='help-title--icon']")).click();

	}

	@Given("^Check for copyright information\\.$")
	public void check_for_copyright_information() throws Throwable {
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CopyRight"))).isDisplayed()) {

			String data = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CopyRight"))).getText();
			Assert.assertNotSame(data,
					"© 2021 CEIC Data, an ISI Emerging Markets Group Company.  All rights reserved. ");
			login.Log4j.info("2021 CEIC copyright  not available ");

		} else {
			login.Log4j.info("2021 CEIC is  available ");

		}

	}

	@And("^Check for copyright information for current year\\.$")
	public void check_for_copyright_information_for_current_year() throws Throwable {
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CopyRight"))).isDisplayed()) {

			String data = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CopyRight"))).getText();
			String Current_year = "2022";
			if (Current_year.equalsIgnoreCase("2022")) {
				login.Log4j.info("Current Year : 2022 is displayed ");

			} else {
				login.Log4j.info("Next Year : 2023 is displayed ");
			}
		}

	}

	@Given("^user Clicks on Open File Menu beside Insights$")
	public void user_Clicks_on_Open_File_Menu_beside_Insights() throws Throwable {
		
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name_insight"))).isDisplayed()) {
			login.driver.findElement(By.xpath("//div[@class='insight-context-menu--menu-icon']")).click();
			login.driver.findElement(By.xpath("//span[contains(text(),'New')]")).click();
			login.driver.findElement(By.xpath("//input[@type='text' and @ui='$name']")).click();
			login.driver.findElement(By.xpath("//input[@type='text' and @ui='$name']")).clear();		
													
		}
				

	}
	
	@Given("^Enters insight name as \"([^\"]*)\"$")
	public void enters_insight_name_as(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//input[@type='text' and @ui='$name']")).sendKeys(arg1);
		login.driver.findElement(By.xpath("//button[@class='sphere-modal-control button button__primary']")).click();
		
		
	}

	@And("^Try to delete an insight\\.$")
	public void try_to_delete_an_insight() throws Throwable {
		CommonFunctionality.wait(2000);
		
		login.driver.findElement(By.xpath("//div[@class='insight-context-menu--menu-icon']")).click();
		login.driver.findElement(By.xpath("//span[contains(text(),'Delete')]")).click();
		

		
	}

	@Then("^insight name should be displayed in the delete confirmation popup\\.$")
	public void insight_name_should_be_displayed_in_the_delete_confirmation_popup() throws Throwable {
		CommonFunctionality.wait(2000);
		if(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Insight_delete"))).isDisplayed()) {
			
			login.Log4j.info("Insight name displayed in delete confirmation Popup ");
		}
		else {
			login.Log4j.info("Insight name is not  displayed in delete confirmation Popup ");
		}
		
			}
}
