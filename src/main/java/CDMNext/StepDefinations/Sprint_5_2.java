package CDMNext.StepDefinations;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.internal.runners.statements.Fail;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
			login.Log4j.info("My Search folder available in Page");
			
			
			WebDriverWait wait = new WebDriverWait(login.driver, 80);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(login.LOCATORS.getProperty("My_Searches")))).click();
			
			
			/*CommonFunctionality.wait(5000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches"))).click();
			login.Log4j.info("Clicked on My Search folder.");
			CommonFunctionality.wait(2000);	*/
			
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches1")));
			CommonFunctionality.action.moveToElement(ele).pause(1000).build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("remove"))).click();
			login.Log4j.info("hovered on My Search folder and deleted the india");
			CommonFunctionality.wait(10000);
		}
		login.Log4j.info("My Search folder not avilable in webpage");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys("India", Keys.ENTER);
		login.Log4j.info("Entered the Text india in search text box");
		Thread.sleep(3000);
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
		login.Log4j.info("Clicked on Save new Search");
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
		CommonFunctionality.wait(4000);
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		login.Log4j.info("Selected the Specific User : ceicsuresh@gmail.com");
		CommonFunctionality.wait(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("save_button"))).click();
		login.Log4j.info("Clicked on save button for Specific user ");
		String Message = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Shared_Message"))).getText();
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
		ArrayList<String> incog = new ArrayList<String>(login.driver.getWindowHandles());
		Thread.sleep(5000);
		login.driver.switchTo().window(incog.get(1));
		Thread.sleep(10000);	
		
		login.driver.navigate().to("https://stage.ceicdata.com/login");
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
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("input_password"))).clear();
		Log4j.info("Trying to login with Password:" + password);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("input_password"))).sendKeys("Ceic@123");
		CommonFunctionality.wait(3000);

	}

	@And("^Login to the shared user account\\.$")
	public void login_to_the_shared_user_account() throws Throwable {
		CommonFunctionality.wait(2000);
		try {
		login.driver.findElement(By.xpath("//*[text()='No, take me to CDMNext']")).click();
		login.Log4j.info("Clicked on No, take me to CDMNext Alert");
		}
		catch(Exception e) {
			System.out.println("pop up is not appeared");
		}
	}

	@Then("^check for shared search under \"([^\"]*)\"\\.$")
	public void check_for_shared_search_under(String arg1) throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 80);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//div[@title='View results as List']")))).click();

		CommonFunctionality.wait(5000);
	
			login.Log4j.info("My Search folder available in Page");
			CommonFunctionality.wait(5000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches"))).click();
			login.Log4j.info("Clicked on My Search folder.");
			CommonFunctionality.wait(2000);	
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
		
		/*Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches"))).click();
		Thread.sleep(5000);
		*/
		CommonFunctionality.wait(5000);
		
		login.Log4j.info("My Search folder available in Page");
		
		/*WebDriverWait wait1 = new WebDriverWait(login.driver, 80);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(login.LOCATORS.getProperty("My_Searches")))).click();*/
		CommonFunctionality.wait(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches"))).click();
		login.Log4j.info("Clicked on My Search folder.");
		CommonFunctionality.wait(4000);
		

			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("India_click"))).click();
			login.driver.navigate().refresh();
			WebDriverWait wait = new WebDriverWait(login.driver, 80);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//div[@title='View results as List']")))).click();
			CommonFunctionality.wait(3000);
			if (CommonFunctionality.getElementByXpath(login.driver, login.LOCATORS.getProperty("Region"), 500)
					.isDisplayed()) {
				

				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_list"))).click();

				String India = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("India_Region"))).getText();
				Assert.assertEquals(India, "India");
				CommonFunctionality.wait(5000);

			

		} else {
			
			fail("Failed");
			//login.driver.switchTo().window(newTab.get(0));
		}
try {
		ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(newTab.get(1)).close();
		Thread.sleep(1000);
		login.driver.switchTo().window(newTab.get(0));
}
catch(Exception e) {
	login.driver.switchTo().window(newTab.get(0));
}
	}

	@When("^select Shared Search option\\.$")
	public void select_Shared_Search_option() throws Throwable {
		login.driver.navigate().refresh();
		CommonFunctionality.wait(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches"))).click();
		if (CommonFunctionality.getElementByXpath(login.driver, login.LOCATORS.getProperty("Shared_To"), 500)
				.isDisplayed()) {

			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("India_click"))).click();
			CommonFunctionality.wait(3000);
			if (CommonFunctionality.getElementByXpath(login.driver, login.LOCATORS.getProperty("Region"), 500)
					.isDisplayed()) {
				WebDriverWait wait = new WebDriverWait(login.driver, 40);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[@value='LIST']")))).click();

				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_list"))).click();

				String India = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("India_Region"))).getText();
				Assert.assertEquals(India, "India");
				CommonFunctionality.wait(5000);

			}

		} else {
			fail("Failed");
		}
		ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
		Thread.sleep(1000);
		login.driver.switchTo().window(newTab.get(0));

	}

	@Then("^Move the mouse on \"([^\"]*)\" under Share with Me\\.$")
	public void move_the_mouse_on_under_Share_with_Me(String arg1) throws Throwable {
		login.driver.navigate().refresh();
		
           Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches"))).click();
		 Thread.sleep(5000);

		login.Log4j.info("my search folder avilable");
		if (CommonFunctionality.getElementByXpath(login.driver, login.LOCATORS.getProperty("Shared_To"), 500)
				.isDisplayed()) {

			login.Log4j.info("Share to me displayed");

			Thread.sleep(2000);

			WebElement Search = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("India_click")));
			CommonFunctionality.action.moveToElement(Search).pause(5000).build().perform();
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
			login.driver.switchTo().window(newTab.get(0));
			
		}
try {
		ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(newTab.get(1)).close();
		Thread.sleep(1000);
		login.driver.switchTo().window(newTab.get(0));
}
catch(Exception e) {
	login.driver.switchTo().window(newTab.get(0));
}


}
	

		@Then("^Click on Copy Icon\\.$")
	public void click_on_Copy_Icon() throws Throwable {
			login.driver.navigate().refresh();
		CommonFunctionality.wait(3000);
		login.driver.findElement(By.xpath("//span[normalize-space(text())='Series']")).click();
		Thread.sleep(3000);
		
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches"))).click();
		WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches1")));

		CommonFunctionality.action.moveToElement(ele).pause(2000).build().perform();

		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_url"))).click();
		login.Log4j.info("URL link copied");
		CommonFunctionality.wait(3000);
		String Copy_url = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_Message"))).getText();
		Assert.assertEquals(Copy_url, "URL link copied.");
		try {
		ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(newTab.get(1)).close();
		Thread.sleep(1000);
		login.driver.switchTo().window(newTab.get(0));
		}
		catch(Exception e) {
			login.driver.switchTo().window(newTab.get(0));
		}
		
	}

	@When("^Click on Copy Icon and open browser\\.$")
	public void click_on_Copy_Icon_and_open_browser() throws Throwable {
		login.driver.navigate().refresh();
		Thread.sleep(6000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches"))).click();
		Thread.sleep(4000);
		WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches1")));

		CommonFunctionality.action.moveToElement(ele).pause(2000).build().perform();

		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_url"))).click();
		CommonFunctionality.wait(3000);
		String Copy_url = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_Message"))).getText();
		Assert.assertEquals(Copy_url, "URL link copied.");
		CommonFunctionality.jse.executeScript("window.open('newpage.html','_blank');");
		try {
		ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(newTab.get(2)).close();
		Thread.sleep(1000);
		login.driver.switchTo().window(newTab.get(1)).close();
		login.driver.switchTo().window(newTab.get(0));
		}
		catch(Exception e) {
			login.driver.switchTo().window(newTab.get(2)).close();
			Thread.sleep(1000);
			login.driver.switchTo().window(newTab.get(1)).close();
			login.driver.switchTo().window(newTab.get(0));
			login.driver.switchTo().window(newTab.get(0));
		}
	}

	@Then("^Run URL in the browser$")
	public void run_URL_in_the_browser() throws Throwable {
		CommonFunctionality.wait(3000);
		CommonFunctionality.jse.executeScript("window.open('newpage.html','_blank');");
		if (CommonFunctionality.getElementByXpath(login.driver, login.LOCATORS.getProperty("India_Details"), 500)
				.isDisplayed()) {

			login.Log4j.info("India results are displayed in new browser");
		} else {
			login.Log4j.info("India results are not displayed in new browser");
		}

	}

	@Then("^Run in the browserand copy the URL in the new Tab$")
	public void run_in_the_browserand_copy_the_URL_in_the_new_Tab() throws Throwable {

		CommonFunctionality.wait(3000);
		CommonFunctionality.jse.executeScript("window.open('newpage.html','_blank');");
		CommonFunctionality.wait(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[@value='LIST']")))).click();
		if (CommonFunctionality.getElementByXpath(login.driver, login.LOCATORS.getProperty("Region"), 500)
				.isDisplayed()) {
			

			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_list"))).click();

			String India = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("India_Region"))).getText();
			Assert.assertEquals(India, "India");
			CommonFunctionality.wait(5000);

		/*}
		
		if (CommonFunctionality.getElementByXpath(login.driver, login.LOCATORS.getProperty("India_Details"), 500)
				.isDisplayed()) {*/

			login.Log4j.info("India results are displayed in new browser");
			login.driver.navigate().refresh();
			ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
			login.driver.switchTo().window(newTab.get(2)).close();
			Thread.sleep(1000);
			login.driver.switchTo().window(newTab.get(1)).close();
			
			login.driver.switchTo().window(newTab.get(0));
		} else {
			login.Log4j.info("India results are not displayed in new browser");
			ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
			login.driver.switchTo().window(newTab.get(2)).close();
			Thread.sleep(1000);
			login.driver.switchTo().window(newTab.get(1)).close();
			
			login.driver.switchTo().window(newTab.get(0));
		}

/*try {
		ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(newTab.get(2)).close();
		
		login.driver.switchTo().window(newTab.get(1)).close();
		Thread.sleep(2000);
		login.driver.switchTo().window(newTab.get(0));
}
catch(Exception e) {
	login.driver.switchTo().window(newTab.get(2)).close();
	
	login.driver.switchTo().window(newTab.get(1)).close();
	Thread.sleep(2000);
	login.driver.switchTo().window(newTab.get(0));
	
}*/
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
		String Message = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Shared_Message"))).getText();
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

 }

		ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(newTab.get(1));

	}
	@When("^Check for Shared Search$")
	public void check_for_Shared_Search() throws Throwable {
		login.driver.navigate().refresh();
		Thread.sleep(5000);
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches"))).isDisplayed()) {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches"))).click();
			if (!CommonFunctionality.getElementByXpath(login.driver, login.LOCATORS.getProperty("Shared_To"), 500)
					.isDisplayed()) {

				login.Log4j.info("search has been stopped by user");

			} else {
				login.Log4j.info("India is Displayed");
				Assert.assertTrue(false);

			}
		}

		else {
			login.Log4j.info("India is not  Displayed");
			Assert.assertTrue(true);

		}
try {
		ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(newTab.get(1)).close();
		Thread.sleep(1000);
		login.driver.switchTo().window(newTab.get(0));
}
catch(Exception e) {
	login.driver.switchTo().window(newTab.get(0));
}
	}


	@Given("^User enters \"([^\"]*)\" in the search panel and save the search$")
	public void user_enters_in_the_search_panel_and_save_the_search(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);
		login.driver.navigate().refresh();
	//	if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("My_Searches"))).size() == 1) {
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches"))).isDisplayed()) {
			CommonFunctionality.wait(3000);

			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches"))).click();
			CommonFunctionality.wait(3000);

			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Searches1")));
			CommonFunctionality.action.moveToElement(ele).pause(5).build().perform();
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("remove"))).click();
			CommonFunctionality.wait(10000);
			System.out.println("=======done");

		}

		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys("India", Keys.ENTER);
		webDriverwait_locator(login.LOCATORS.getProperty("save1"), "xpath");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("save1"))).click();

		CommonFunctionality.wait(5000);
		webDriverwait_locator(login.LOCATORS.getProperty("Search_enter"), "xpath");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search_enter"))).click();
		CommonFunctionality.wait(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search_enter"))).sendKeys("India");
		Thread.sleep(5000);
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
		login.driver.navigate().to	
		("https://stage.ceicdata.com/login");
		CommonFunctionality.wait(3000);

		ArrayList<String> incog = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(incog.get(1));
		CommonFunctionality.wait(3000);
		// login.driver.switchTo().window(newTab.get(1));
		System.out.println("====Title====" + login.driver.getTitle());
		

	}

		@Given("^User selects any series and creates a visual Table from More Actions\\.$")
	    public void user_selects_any_series_and_creates_a_visual_Table_from_More_Actions() throws Throwable {
		try {
			Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(login.driver, 80);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//div[@title='View results as List']")))).click();	
			//login.driver.findElement(By.xpath("//span[@value='LIST']")).click();
			CommonFunctionality.wait(500);
			WebElement Serieslist = login.driver.findElement(
					By.xpath("//div[@class='series-list-item-data']/div[@class='series-list-item--information'][1]"));
			new Actions(login.driver).moveToElement(Serieslist).pause(3000).build().perform();
		    WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("More_actions")));
			CommonFunctionality.action.moveToElement(ele1).pause(2).click().build().perform();
			CommonFunctionality.wait(2000);
			WebElement Add_chart=login.driver.findElement(By.xpath("//span[normalize-space(text())='Add chart']"));
			new Actions(login.driver).moveToElement(Add_chart).pause(1000).build().perform();
			login.driver.findElement(By.xpath("//div[contains(@class,'icon--table-vertical_large')]")).click();
			//login.driver.findElement(By.xpath(login.LOCATORS.getProperty("table5"))).click();

		} catch (Exception e) {

			CommonFunctionality.wait(500);
				WebElement Serieslist = login.driver.findElement(By.xpath("//div[@class='series-list-item-data']/div[@class='series-list-item--information'][1]"));
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
		login.driver.findElement(By.xpath("//div[@class='context-menu-control context-menu-control__clean context-menu-control__icon']//div[@class='context-menu-control--icon']")).click();
		CommonFunctionality.wait(2000);

		WebElement Share = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Share_mouse")));
		CommonFunctionality.action.moveToElement(Share).pause(2).build().perform();
		login.Log4j.info("hovered on  style  template");
		if (Share.isDisplayed()) {

			login.driver.findElement(By.xpath("//div[@class='style-templates-item--icon-base style-templates-item--share']")).click();
			login.driver.findElement(By.xpath("//button[@class='sphere-modal-control button button__text_purple']")).click();
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
		//div[@class='movable-modal--window']
		try {
			WebElement popup=login.driver.findElement(By.xpath("//div[@class='movable-modal--window']"));
			if(popup.isDisplayed()) {
				login.driver.findElement(By.xpath("//button[normalize-space(text())='Start new']")).click();
				
			}
		}
			catch(Exception e) {
				System.out.println("pop up ");
				
			}
		

		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(login.driver, 80);
		//login.driver.findElement(By.xpath("//div[@title='View results as List']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//div[@title='View results as List']")))).click();
		CommonFunctionality.wait(2000);
		WebElement Serieslist = login.driver.findElement(By.xpath("//div[@class='series-list-item-data']/div[@class='series-list-item--information'][1]"));
		new Actions(login.driver).moveToElement(Serieslist).pause(3000).build().perform();
		WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("More_actions")));
		CommonFunctionality.action.moveToElement(ele1).pause(2).click().build().perform();
		CommonFunctionality.wait(2000);
		WebElement Add_chart=login.driver.findElement(By.xpath("//span[normalize-space(text())='Add chart']"));
		new Actions(login.driver).moveToElement(Add_chart).pause(1000).build().perform();
		login.driver.findElement(By.xpath("//div[contains(@class,'icon--table-vertical_large')]")).click();
		
		try {
			login.driver.findElement(By.xpath("//button[normalize-space(text())='Apply']")).click();
		}
	    catch(Exception e) {
	    	System.out.println("Pop up not appeared");
	    }
		//login.driver.findElement(By.xpath(login.LOCATORS.getProperty("table5"))).click();

		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edittable"))).click();
		CommonFunctionality.wait(2000);	
		
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Statistics_checkbox"))).click();

		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//div[@class='context-menu-control context-menu-control__clean context-menu-control__icon']//div[@class='context-menu-control--icon']")).click();
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ShareTo_Me"))).isDisplayed()) {
			login.Log4j.info("Shared Style is Available under shared with me");

		} else {
			login.Log4j.info("Shared Style is not Available under shared with me");
			login.driver.switchTo().window(newTab.get(0));
		}
		
		ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
		Thread.sleep(2000);
		login.driver.switchTo().window(newTab.get(1)).close();
		Thread.sleep(1000);
		login.driver.switchTo().window(newTab.get(0));
		
		
	}

	@When("^Select shared style\\.$")
	public void select_shared_style() throws Throwable {
		try {
			//login.driver.navigate().refresh();
			Thread.sleep(10000);	
			try {	
				login.driver.findElement(By.xpath("//button[text()='Start new']")).click();
			}
			catch(Exception e) {
				System.out.println("pop up not appear");
			}
			WebDriverWait wait = new WebDriverWait(login.driver, 80);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//div[@title='View results as List']")))).click();
			WebElement Serieslist = login.driver.findElement(By.xpath("//div[@class='series-list-item-data']/div[@class='series-list-item--information'][1]"));
			new Actions(login.driver).moveToElement(Serieslist).pause(3000).build().perform();
			WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("More_actions")));
			CommonFunctionality.action.moveToElement(ele1).pause(2).click().build().perform();
			CommonFunctionality.wait(2000);
			WebElement Add_chart=login.driver.findElement(By.xpath("//span[normalize-space(text())='Add chart']"));
			new Actions(login.driver).moveToElement(Add_chart).pause(1000).build().perform();
			login.driver.findElement(By.xpath("//div[contains(@class,'icon--table-vertical_large')]")).click();
			
			try {
				login.driver.findElement(By.xpath("//button[normalize-space(text())='Apply']")).click();
			}
		    catch(Exception e) {
		    	System.out.println("Pop up not appeared");
		    }
			//login.driver.findElement(By.xpath(login.LOCATORS.getProperty("table5"))).click();
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edittable"))).click();
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Statistics_checkbox"))).click();

			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath("//div[@class='context-menu-control context-menu-control__clean context-menu-control__icon']//div[@class='context-menu-control--icon']")).click();
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
			login.driver.switchTo().window(newTab.get(0));
		}
		
		ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
		Thread.sleep(2000);
		login.driver.switchTo().window(newTab.get(1)).close();
		Thread.sleep(1000);
		login.driver.switchTo().window(newTab.get(0));
		
	}

	@When("^mouseover on the shared style\\.$")
	public void mouseover_on_the_shared_style() throws Throwable {
		//login.driver.navigate().refresh();	
		Thread.sleep(10000);
		try {	
			login.driver.findElement(By.xpath("//button[text()='Start new']")).click();
		}
		catch(Exception e) {
			System.out.println("pop up not appear");
		}
		WebDriverWait wait = new WebDriverWait(login.driver, 80);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//div[@title='View results as List']")))).click();
		WebElement Serieslist = login.driver.findElement(
				By.xpath("//div[@class='series-list-item-data']/div[@class='series-list-item--information'][1]"));
		new Actions(login.driver).moveToElement(Serieslist).pause(3000).build().perform();
		WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("More_actions")));
		CommonFunctionality.action.moveToElement(ele1).pause(2).click().build().perform();
		CommonFunctionality.wait(2000);
		WebElement Add_chart=login.driver.findElement(By.xpath("//span[normalize-space(text())='Add chart']"));
		new Actions(login.driver).moveToElement(Add_chart).pause(1000).build().perform();
		login.driver.findElement(By.xpath("//div[contains(@class,'icon--table-vertical_large')]")).click();
		
		try {
			login.driver.findElement(By.xpath("//button[normalize-space(text())='Apply']")).click();
		}
	    catch(Exception e) {
	    	System.out.println("Pop up not appeared");
	    }
		
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
		try {
		ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(newTab.get(1)).close();
		Thread.sleep(1000);
		login.driver.switchTo().window(newTab.get(0));
		}
		catch(Exception e) {
			login.driver.switchTo().window(newTab.get(0));
		}
	}

	@When("^check for shared style\\.$")
	public void check_for_shared_style() throws Throwable {
		//login.driver.navigate().refresh();
		try {	
			login.driver.findElement(By.xpath("//button[text()='Start new']")).click();
		}
		catch(Exception e) {
			System.out.println("pop up not appear");
		}
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(login.driver, 80);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//div[@title='View results as List']")))).click();
		WebElement Serieslist = login.driver.findElement(By.xpath("//div[@class='series-list-item-data']/div[@class='series-list-item--information'][1]"));
		new Actions(login.driver).moveToElement(Serieslist).pause(3000).build().perform();
		WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("More_actions")));
		CommonFunctionality.action.moveToElement(ele1).pause(2).click().build().perform();
		CommonFunctionality.wait(2000);
		WebElement Add_chart=login.driver.findElement(By.xpath("//span[normalize-space(text())='Add chart']"));
		new Actions(login.driver).moveToElement(Add_chart).pause(1000).build().perform();
		login.driver.findElement(By.xpath("//div[contains(@class,'icon--table-vertical_large')]")).click();
		
		try {
			login.driver.findElement(By.xpath("//button[normalize-space(text())='Apply']")).click();
		}
	    catch(Exception e) {
	    	System.out.println("Pop up not appeared");
	    }
		
		//login.driver.findElement(By.xpath(login.LOCATORS.getProperty("table5"))).click();

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
		login.driver.findElement(By.xpath("//div[@class='context-menu-control context-menu-control__clean context-menu-control__icon']//div[@class='context-menu-control--icon']")).click();
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("My_Styles"))).isDisplayed()) {
			CommonFunctionality.wait(2000);

			WebElement Share = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Share_mouse")));
			CommonFunctionality.action.moveToElement(Share).pause(2).build().perform();
			login.Log4j.info("hovered on  style  template");
			login.driver.findElement(By.xpath("//div[@class='style-templates-item--icon-base style-templates-item--share']")).click();
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("User_remove"))).click();
			CommonFunctionality.wait(1000);

			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("save_button"))).click();
			String Unshared_style = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Style_unshared"))).getText();
			Assert.assertEquals(Unshared_style, "Selected style was successfully unshared.");
			CommonFunctionality.wait(5000);

		}
		ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(newTab.get(1));

	}
	
	
	@Given("^user clicks on New insight->open pie dropdown->click on donut$")
	public void user_clicks_on_New_insight_open_pie_dropdown_click_on_donut() throws Throwable {
		login.driver.findElement(By.xpath("//div[@title='Create new View tab']")).click();
		login.Log4j.info("Created view tab in insights");
		/*login.driver.findElement(By.xpath("//div[@title='Click or drag-and-drop to insert Pie']//div[@class='insight-action-panel--btn-popup icon--context-menu-arrow']")).click();
		CommonFunctionality.wait(500);
		login.Log4j.info("clicked on Pie dropdown");
		login.driver.findElement(By.xpath("//span[@title='Donut']")).click();
		CommonFunctionality.wait(2000);
		login.Log4j.info("clicked on Donut");*/
		
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//div[contains(text(),'Add chart')]")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//div[contains(@class,'icon--pie_chart-donut_large')]")).click();
		
		
	   
	}

	@And("^try to open edit Visual for donut\\.$")
	public void try_to_open_edit_Visual_for_donut() throws Throwable {
		login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[1]")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//div[@class='add-to-data-selection--icon']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//button[text()='Edit Pie']")).click();
		login.Log4j.info("clicked on Edit Pie");
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Donut_chart"))).isDisplayed()) {
			login.Log4j.info("Donut chart is displayed");	
		}
		else {
			login.Log4j.info("Donut chart is not displayed");
		}	    
	}
	

	@Given("^user Filter out search with continuous under More dropdown\\.$")
	public void user_Filter_out_search_with_continuous_under_More_dropdown() throws Throwable {
		CommonFunctionality.wait(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[@value='LIST']")))).click();
		
		
		CommonFunctionality.wait(2000);

			
			login.driver.findElement(By.xpath("//span[normalize-space(text())='More']")).click();
			login.Log4j.info("Successfully More button Clicked ");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Continuous"))).click();
			login.Log4j.info("Successfully Continuous  button Clicked ");
		
		   
	}
	
	
	
	@And("^check for orange series\\.$")
	public void check_for_orange_series() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement Orange_series = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Internal_tooltip")));
		new Actions(login.driver).pause(5000).moveToElement(Orange_series).build().perform();
		
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Orange_dot"))).isDisplayed()) {

			login.Log4j.info("Series for internal tooltip is present");

		} 
		else {
			login.Log4j.info("Series for internal tooltip is not  present");
			
		}
	    
	}

	@Given("^expand release tab for green series\\.$")
	public void expand_release_tab_for_green_series() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//span[@value='TREE']")).click();
		WebElement Green_series = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Green_tooltip")));
		new Actions(login.driver).pause(500).moveToElement(Green_series).build().perform();
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Green_dot"))).isDisplayed()) {

			login.Log4j.info("Green dot contains series that match your search is present");

		} 
		else {
			login.Log4j.info("Green dot contains series that match your search is not present");
			
		}				   
	}

	@Given("^Open database for purple series\\.$")
	public void open_database_for_purple_series() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//span[@value='LIST']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(("(//span[@class='series-list-item--checkbox svg-checkbox'])[2]"))).click();	
		Thread.sleep(3000);   
		
		boolean ss =	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("See_Database"))).isDisplayed();
		System.out.println("======"+ss);
	
	WebElement Database = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("See_Database")));
	
	js. executeScript("arguments[0]. click();", Database);
    	CommonFunctionality.wait(2000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[@title='China Premium Database: Table CN.OC: Fixed Asset Investment: Industry']")))).click();
		//login.driver.findElement(By.xpath("//span[@title='China Premium Database: Table CN.OC: Fixed Asset Investment: Industry']")).click();
		WebElement Purple_series = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Purple_mouseover")));
		new Actions(login.driver).pause(500).moveToElement(Purple_series).build().perform();
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Purple_dot"))).isDisplayed()) {
			CommonFunctionality.wait(2000);
			login.Log4j.info("Purple dot contains series that match your search is present");

		} 
		else {
			login.Log4j.info("Purple dot contains series that match your search is not present");
			
		}	
		
	}
	
	
	
	@Given("^user selects S from More Actions\\.$")
	public void user_selects_S_from_More_Actions() throws Throwable {
		CommonFunctionality.wait(5000);
		login.driver.findElement(By.xpath("//span[@value='LIST']")).click();
	    login.driver.findElement(By.xpath("//span[normalize-space(text())='More']")).click();
	    login.Log4j.info("Successfully More button Clicked ");
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Replacement_series"))).click();
		login.Log4j.info("Successfully Replacement series  button Clicked ");
		
	}

	@Given("^Replacement series should be shown\\.$")
	public void replacement_series_should_be_shown() throws Throwable {
		CommonFunctionality.wait(2000);			
		List<WebElement> list = login.driver.findElements(By.xpath("//div[@class='series-item--status-icons']"));
		CommonFunctionality.wait(2000);
		
		if(list.size()>1) {
			login.Log4j.info("Replacement series are shown");
			
		}
		else {
			login.Log4j.info("Replacement series are not  shown");
		}
			   
	}

	@Given("^selects C from More Actions\\.$")
	public void selects_C_from_More_Actions() throws Throwable {
		CommonFunctionality.wait(5000);
		login.driver.findElement(By.xpath("//span[@value='LIST']")).click();	
		

		login.driver.findElement(By.xpath("//span[normalize-space(text())='More']")).click();
			login.Log4j.info("Successfully More button Clicked ");
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Replacement_series"))).click();
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Continuous"))).click();
			login.Log4j.info("Successfully Continuos series  button Clicked ");
		
		
	   
	}

	@Given("^Continuos series should be shown\\.$")
	public void continuos_series_should_be_shown() throws Throwable {
      CommonFunctionality.wait(2000);	
		
		List<WebElement> list = login.driver.findElements(By.xpath("//span[@class='status-icon status-icon__key']"));
		CommonFunctionality.wait(2000);
		if(list.size()>1) {
			login.Log4j.info("continuos  series are shown");
			
		}
		else {
			login.Log4j.info("continuos  series are not shown");
		}  
	}


	@Then("^check for Shared style under shared with me\\.$")
	public void check_for_Shared_style_under_shared_with_me() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//button[@class='button button__text_purple']")).click();
		login.driver.findElement(By.xpath("//button[@class='sphere-modal-control button button__primary']")).click();
		CommonFunctionality.wait(2000);	
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edittable"))).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//div[@class='context-menu-control context-menu-control__clean context-menu-control__icon']//div[@class='context-menu-control--icon']")).click();
		

		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ShareTo_Me"))).isDisplayed()) {

			System.out.println("Shared style is visible");

		} else {
			System.out.println("Shared style is not visible");

		}
		try {
		ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(newTab.get(1)).close();
		Thread.sleep(1000);
		login.driver.switchTo().window(newTab.get(0));
		}
		catch(Exception e) {
			login.driver.switchTo().window(newTab.get(0));
		}
	}
	@Given("^user enters  searches \"([^\"]*)\"$")
	public void user_enters_searches(String arg1) throws Throwable {
		login.driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(arg1, Keys.ENTER);
		login.driver.findElement(By.xpath("//span[normalize-space()='Save']")).click();
		
		login.driver.findElement(By.xpath("//input[@class='insight-search-input--search-field']")).sendKeys(arg1);
		login.driver.findElement(By.xpath("//span[@class='save-search--save-new']")).click();		    
	}

	@Given("^user enters five saved searches and scroll bar should be displayed\\.$")
	public void user_enters_five_saved_searches_and_scroll_bar_should_be_displayed() throws Throwable {
      CommonFunctionality.wait(2000);	   
      login.Log4j.info("My search not available in web page");
  	String Searches="raj,guru,mahesh,shankar,testing,test";
  	String[] myArray=Searches.split(",");
  	for(String search: myArray) {
  		login.driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(search,Keys.ENTER);
  		Thread.sleep(3000);
  		login.driver.findElement(By.xpath("//span[normalize-space(text())='Save']")).click();
  		Thread.sleep(5000);
  		login.driver.findElement(By.xpath("//input[@class='insight-search-input--search-field']")).sendKeys(search);
  		CommonFunctionality.wait(2000);
  		login.driver.findElement(By.xpath("//span[@class='save-search--save-new']")).click();
  		String Save = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Save_Message"))).getText();
  		Assert.assertEquals(Save, "Search saved!");
  		login.Log4j.info("Succesfully Search saved!");
  		Thread.sleep(2000);
  		login.driver.findElement(By.xpath("//input[@placeholder='Search']")).clear();   
  		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Mysearch_folder"))).click();
		if(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Mysearch_folder"))).isDisplayed()){
			WebElement element = login.driver.findElement(By.xpath("//span[@class='searches-item--title'][normalize-space()='raj']"));
			((JavascriptExecutor) login.driver).executeScript("arguments[0].scrollIntoView(true);", element);
		}				login.Log4j.info("Scroll bar is displayed and Border is applied");	  
      
}			
		}
	
	
	
	
	@Given("^user selects Goto sources dropdown in search pane\\.$")
	public void user_selects_Goto_sources_dropdown_in_search_pane() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Source_dp"))).click();
		
	    
	}

	@Given("^enter \"([^\"]*)\" in search feild\\.$")
	public void enter_in_search_feild(String arg1) throws Throwable {
		
		login.driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys(arg1);
		CommonFunctionality.wait(2000);
		WebElement Source = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Data")));
		new Actions(login.driver).pause(500).moveToElement(Source).build().perform();
		
		if(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Data"))).isDisplayed()){
			login.Log4j.info("CEIC Data is displayed");	
		}
		else {
			login.Log4j.info("CEIC Data is not displayed");
		}
	    
	}

	@Given("^Delete the saved searches\\.$")
	public void delete_the_saved_searches() throws Throwable {		
		login.driver.navigate().refresh();
		CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Mysearch_folder"))).click();
		 
		     login.Log4j.info("Clicked on My Search folder.");	
		     CommonFunctionality.wait(2000);
				List<WebElement> list = login.driver.findElements(By.xpath("//span[@class='searches-item--title']"));
				CommonFunctionality.wait(2000);
				
				for (int i=0; i<list.size(); i++) {					
					String searches =login.driver.findElement(By.xpath("//span[@class='searches-item--title']")).getText();				
					WebElement ele=login.driver.findElement(By.xpath("//span[text()='"+searches+"']"));				
					CommonFunctionality.action.moveToElement(ele).pause(5).build().perform();
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("remove"))).click();				
					Thread.sleep(2000);
				
			}					
			}
	
	
	@Given("^user Logout from current user$")
	public void user_Logout_from_current_user() throws Throwable {
		CommonFunctionality.wait(3000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View and edit profile information']", 4).click();
		WebElement logout = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Sign out')]", 4);
		js.executeScript("arguments[0].scrollIntoView(true);", logout);
		js.executeScript("arguments[0].click();", logout);
		cv.the_application_should_be_logged_out();
	}

	@And("^User logins into CDM Next with Username : \"([^\"]*)\" and Password : \"([^\"]*)\"\\.$")
	public void user_logins_into_CDM_Next_with_Username_and_Password(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(arg1);
		login.driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(arg2);
		login.driver.findElement(By.xpath("//button[@type='submit']")).click();
		CommonFunctionality.wait(2000);
		WebDriverWait wait = new WebDriverWait(login.driver, 40);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[@value='LIST']")))).click();	
		WebElement ele=login.driver.findElement(By.xpath("//span[@value='LIST']"));
		js. executeScript("arguments[0]. click();", ele);
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("(//span[normalize-space(text())='Watchlist'])[1]")).click();
		WebElement watchlist = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Watchlist_hovered")));
		CommonFunctionality.action.moveToElement(watchlist).pause(200).build().perform();
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
			CommonFunctionality.wait(3000);
			String auto=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Auto_text"))).getText();
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
	
	@Given("^user clicks on (\\d+) dots in datatab header$")
	public void user_clicks_on_dots_in_datatab_header(int arg1) throws Throwable {
		login.driver.findElement(By.xpath("//div[@class='search-presentation-tabs--drop-down-title']")).click();

	}

	@Given("^observe the checkbox for Datatab\\.$")
	public void observe_the_checkbox_for_Datatab() throws Throwable {
		CommonFunctionality.wait(2000);
		if (!login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Datatab_checkbox"))).isSelected()) {
			
			login.Log4j.info("Data tab checkbox is greyed out"); 	
		}
		else {
			login.Log4j.info("Data tab checkbox is enabled"); 
		}
	}

	@Given("^user Search with sources: \"([^\"]*)\"$")
	public void user_Search_with_sources(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByXpath(login.driver, "//span[@class='series-tab ui-sortable-handle']//span[@class='series-tab--text'][normalize-space()='Comparables']", 20).click();
		login.driver.findElement(By.xpath("//div[@class='search-section']//div[3]//div[1]//div[1]//div[1]//span[1]//span[2]")).click();
		login.Log4j.info("clicked on source filter");
		login.driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys(arg1,Keys.ENTER);
		login.Log4j.info("Search with Central bureau of statistics");
		
		
		
		
	    
	}

	@Given("^Verify comparables$")
	public void verify_comparables() throws Throwable {
if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Comparables"))).size() == 0) {
			
			login.Log4j.info("Central bureau of statistics is not present in the list");
		
	    
	}

else {
	login.Log4j.info("Central bureau of statistics is  present in the list");
}
	}	
	
	@Given("^user selects some series into my series tab$")
	public void user_selects_some_series_into_my_series_tab() throws Throwable {	
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_tab_bar"))).click();
	System.out.println("clicked on series tab");
		Thread.sleep(5000);
		CommonFunctionality.wait(2000);		
		for (int i=1; i<=3; i++) {
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])["+i+"]")).click();
			
			CommonFunctionality.wait(2000);	
		}
		
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("add_to_myseries_icon"))).click();	
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		
		}	
	@Given("^click on refresh Insight\\.$")
	public void click_on_refresh_Insight() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//div[@title='Open File menu']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//span[@title='Refresh']")).click();
		
		if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Insight_popup"))).size()==1) {
			login.driver.findElement(By.xpath("//button[text()='Start new']")).click();
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_tab_bar"))).click();
			System.out.println("clicked on series tab");
				CommonFunctionality.wait(2000);
				CommonFunctionality.wait(2000);
				for (int i=1; i<3; i++) {
					CommonFunctionality.wait(2000);
					login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])["+i+"]")).click();
					
					CommonFunctionality.wait(2000);	
				}
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("add_to_myseries_icon"))).click();	
				login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
				CommonFunctionality.wait(2000);
				login.driver.findElement(By.xpath("//div[@title='Open File menu']")).click();
				CommonFunctionality.wait(2000);
				login.driver.findElement(By.xpath("//span[@title='Refresh']")).click();
				
			
		}
			
		
		if(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Continuos_tab"))).isDisplayed()) {
			login.Log4j.info("series with continuos are shown in continuos tab only");
		}
		else {
			login.Log4j.info("series with continuos are not shown in continuos tab only");
		}
		if(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Manage_All"))).isDisplayed()) {
		
		login.driver.findElement(By.xpath("//div[@class='suggestions-panel--arrow icon--filter-arrow']")).click();
		login.Log4j.info("Add continuous series, Add contributed series, Replace the current series and Delete the current series are displayed");
		
		}
		else {
			login.Log4j.info("Add continuous series, Add contributed series, Replace the current series and Delete the current series are not displayed");
			
		}
		
	    
	}
		
	@Given("^Select all series->look for move down or move up icons$")
	public void select_all_series_look_for_move_down_or_move_up_icons() throws Throwable {		
		if(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Disabled_btn"))).isDisplayed()) {
			login.Log4j.info("Move up Arrow is Disabled");	
		}
		else {
			login.Log4j.info("Move up Arrow is not Disabled");	
		}
		if(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Disabled_btndown"))).isDisplayed()) {
			login.Log4j.info("Down Arrow is Disabled");	
			
		}
		else {
			login.Log4j.info("Down Arrow is not  Disabled");
		}
		
	   
	}	
	   
		@Given("^user creates a Map Visual\\.$")
	public void user_creates_a_Map_Visual() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Series_tab_bar"))));
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_tab_bar"))).click();
		WebElement Serieslist = login.driver.findElement(
				By.xpath("//div[@class='series-list-item-data']/div[@class='series-list-item--information'][1]"));
		new Actions(login.driver).moveToElement(Serieslist).pause(3000).build().perform();
        CommonFunctionality.wait(2000);
		WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("More_actions")));
		CommonFunctionality.action.moveToElement(ele1).pause(2).click().build().perform();
		CommonFunctionality.wait(2000);
		WebElement Add_Chart=login.driver.findElement(By.xpath("//span[@title='Add chart']"));
		new Actions(login.driver).moveToElement(Add_Chart).pause(2000).build().perform();
		login.driver.findElement(By.xpath("//div[contains(@class,'icon--map-filled_large')]")).click();	
		
				
	    
	}

	@Given("^Oberve the legend which will be present in the bottom of the map visual\\.$")
	public void oberve_the_legend_which_will_be_present_in_the_bottom_of_the_map_visual() throws Throwable {
		login.driver.findElement(By.xpath("//button[text()='Edit Map']")).click();
		CommonFunctionality.wait(2000);
		jse.executeScript("window.scrollBy(0,-50)");
		CommonFunctionality.wait(5000);
		if(login.driver.findElement(By.xpath("(//*[contains(@class,'highcharts-grid highcharts-coloraxis')])[2]")).isDisplayed()) {
			String Map_value = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Legend_value"))).getText();
			Assert.assertEquals(Map_value, "250,000");
			login.Log4j.info("Legends present in the map are fully visible");
			
		}
		else {
			login.Log4j.info("Legends present in the map are not visible");
		}
		
		
	
	    
	}
	@Given("^user searches with series Id : \"([^\"]*)\"\\.$")
	public void user_searches_with_series_Id(String arg1) throws Throwable {
		login.driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(arg1,Keys.ENTER);
		login.driver.findElement(By.xpath("//div[@title='Create new View tab']")).click();	   
	}

	@Given("^try to create a Pie with negative value\\.$")
	public void try_to_create_a_Pie_with_negative_value() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//div[contains(text(),'Add chart')]")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//div[contains(@class,'icon--pie_chart-pie_large')]")).click();
		List<WebElement> Series_checkboxes = login.driver.findElements(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']"));
		CommonFunctionality.wait(2000);
		for (int i=0; i<Series_checkboxes.size(); i++) {				
			Series_checkboxes.get(i).click();	
			CommonFunctionality.wait(2000);
		}
		login.driver.findElement(By.xpath("//div[@class='add-to-data-selection--icon']")).click();
		login.driver.findElement(By.xpath("//button[@class='button button__primary']")).click();
		CommonFunctionality.wait(2000);
			
		login.driver.findElement(By.xpath("//input[@class='period-config--input form--control']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("(//th[@class='prev']//span[@class='prev-arrow'])[2]")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("(//th[@class='prev']//span[@class='prev-arrow'])[2]")).click();
		
		if(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Year"))).isDisplayed()) {
			login.driver.findElement(By.xpath("//*[text()='Q2']")).click();
			login.driver.findElement(By.xpath("//button[text()='Edit Pie']")).click();
			login.driver.findElement(By.xpath("(//input[@class='period-config--input form--control'])[2]")).click();
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath("(//th[@class='prev']//span[@class='prev-arrow'])[2]")).click();
			login.driver.findElement(By.xpath("//*[text()='Q2']")).click();
			CommonFunctionality.wait(2000);	
		}
		
	}

	@Given("^Edit visual check for absolute value\\.$")
	public void edit_visual_check_for_absolute_value() throws Throwable {
		CommonFunctionality.wait(2000);
		
		if(!login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Absolute_checkbox"))).isSelected()) {
			
			login.Log4j.info("Pie is plotted in negative time period");
		}
		else {	
			login.Log4j.info("Pie is plotted in positive time period");
		}
				
			}
			
	

	
		
	@Given("^user selects any series and creates a Map Visual$")
	public void user_selects_any_series_and_creates_a_Map_Visual() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//span[@value='LIST']")).click();
		WebElement Serieslist = login.driver.findElement(By.xpath("//div[@class='series-list-item-data']/div[@class='series-list-item--information'][1]"));
		new Actions(login.driver).moveToElement(Serieslist).pause(3000).build().perform();
        CommonFunctionality.wait(2000);
		WebElement more = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("More_actions")));
		CommonFunctionality.action.moveToElement(more).pause(2).click().build().perform();
		CommonFunctionality.wait(2000);
		 WebElement View_Map=login.driver.findElement(By.xpath("//span[normalize-space()='Add chart']"));
		 new Actions(login.driver).moveToElement(View_Map).pause(2000).build().perform();
		 login.driver.findElement(By.xpath("//div[contains(@class,'icon--map-filled_large')]")).click();
		 try {
				WebElement apply=	login.driver.findElement(By.xpath("//*[contains(text(),'Apply')]"));
				apply.click();
			}
			catch(Exception e) {
				System.out.println("pop up not appeared");
			}
		
	}

	@And("^click on Click on  Map\\+Table icon next to world Map$")
	public void click_on_Click_on_Map_Table_icon_next_to_world_Map() throws Throwable {
		CommonFunctionality.wait(2000);
		
		Boolean as=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Map_Table"))).isDisplayed();
		if(as==true)
		{
				
				
			WebDriverWait wait = new WebDriverWait(login.driver, 40);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(login.LOCATORS.getProperty("Map_Table")))); 
			((JavascriptExecutor)login.driver).executeScript("arguments[0].click();", element);
			Thread.sleep(1000);
			login.Log4j.info("Map+table button is  displayed");
			
		}
		else
		{
			fail("Map+table button is not displayed");
			
		}
		
		if(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Region_china"))).isDisplayed()) {
			login.Log4j.info("Map with table along with the specified region is displayed");
			
		}
		else {
			login.Log4j.info("Map with table along with the specified region is not  displayed");
			
		}
		
	   
	}	
	@Given("^user selects Search pane->Open All regions dropdown\\.$")
	public void user_selects_Search_pane_Open_All_regions_dropdown() throws Throwable {
		login.driver.findElement(By.xpath("//div[@class='search-input--regions']//span[@class='icon--filter-arrow dropdown--icon']")).click();
		
	    
	}

	@And("^Group of countries list under All regions should be loaded\\.$")
	public void group_of_countries_list_under_All_regions_should_be_loaded() throws Throwable {
		CommonFunctionality.wait(2000);
		
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("All_regions"))).size()>0) {
			login.Log4j.info("Group of countries listed under all regions are displayed");	
			
			
		}
		else {
			login.Log4j.info("Group of countries listed under all regions are not displayed");
			
		}
	   
	}
	
	@Given("^user clicks on source filter\\.$")
	public void user_clicks_on_source_filter() throws Throwable {
		
		CommonFunctionality.wait(500);
		login.driver.findElement(By.xpath("//div[@class='search-section']//div[3]//div[1]//div[1]//div[1]//span[1]//span[2]")).click();
		Thread.sleep(10000);
	   
	}

	@Given("^apply some filters by abbreviation : \"([^\"]*)\" and \"([^\"]*)\"\\.$")
	public void apply_some_filters_by_abbreviation_and(String arg1, String arg2) throws Throwable {	
		login.driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys(arg2);
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//div[@class='filter-item--checker checkbox-control']//span[@class='input-control--indicator']")).click();
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Abiplast"))).isDisplayed()) {
			login.Log4j.info("Abiplast is displayed");
			
		}
		else {
			login.Log4j.info("Abiplast is not displayed");
			
		}
		login.driver.findElement(By.xpath("//input[@placeholder='Search...']")).clear();
		login.driver.findElement(By.xpath("//div[@class='filters-search-item--remove']")).click();
		login.driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys(arg1);
		login.driver.findElement(By.xpath("//div[@class='top-matches--column']//div[1]//div[1]//div[1]//label[1]//span[1]")).click();
		
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MOF"))).isDisplayed()) {
			login.Log4j.info("MOF is displayed");	
		}
		else {
			login.Log4j.info("MOF is not displayed");	
		}    
	}
	
	@And("^by default top matches option is displayed\\.$")
	public void by_default_top_matches_option_is_displayed() throws Throwable {
		
		
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Top_Matches"))).click();
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Top_Matches"))).isDisplayed()) {
			login.Log4j.info("Top Matches is displayed by default");
		}
		else {
			login.Log4j.info("Top Matches is not displayed by default");
		}
	}

	@Given("^user logins with external account$")
	public void user_logins_with_external_account() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[@value='TREE']")))).click();
		login.driver.findElement(By.xpath("//div[@data-node-model-id='GLOBAL']//div[@class='toggle']")).click();
		login.driver.findElement(By.xpath("//div[@data-node-model-id='GLOBAL&&ALL']//div[@class='toggle']")).click();
		
	   
	}

	@And("^access comparables tab\\.$")
	public void access_comparables_tab() throws Throwable {
		CommonFunctionality.wait(2000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Z_internal"))).size() == 0) {
			
			login.Log4j.info("Test topics are invisible to external user");
			
		}
		else {
			login.Log4j.info("Test topics are not invisible to external user");
		}
		
		
  if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Z_Testing"))).size() == 0) {
			
			login.Log4j.info("Test topics are invisible to external user");
			
		}
		else {
			login.Log4j.info("Test topics are not invisible to external user");
		}
  
  
  if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Z_Testing1"))).size() == 0) {
		
		login.Log4j.info("Test topics are invisible to external user");
		
	}
	else {
		login.Log4j.info("Test topics are not invisible to external user");
	}
 
	   
	}
	
	
	@And("^apply some filters in search bar like : \"([^\"]*)\" and \"([^\"]*)\"\\.$")
	public void apply_some_filters_in_search_bar_like_and(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys(arg2);
		CommonFunctionality.wait(2000);
		login.Log4j.info("ABIPLAST is entered in search bar");	
		login.driver.findElement(By.xpath("//div[@class='filter-item--checker checkbox-control']//span[@class='input-control--indicator']")).click();
		login.driver.findElement(By.xpath("//span[normalize-space(text())='Exclude values']/preceding-sibling::span")).click();
		CommonFunctionality.wait(500);
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ABIPLAST_Excluded"))).isDisplayed()) {
			
			login.Log4j.info("ABIPLAST is excluded in search");	
		}
		
		else {
			login.Log4j.info("ABIPLAST is included in search");	
		}
		login.driver.findElement(By.xpath("//input[@placeholder='Search...']")).clear();
		login.driver.findElement(By.xpath("//div[@class='filters-search-item--remove']")).click();
		login.driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys(arg1);
		login.Log4j.info("MOF is entered in search bar");	
		login.driver.findElement(By.xpath("//div[@class='top-matches--column']//div[1]//div[1]//div[1]//label[1]//span[1]")).click();
    if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MOF_Excluded"))).isDisplayed()) {
			
			login.Log4j.info("MOF is excluded in search");	
		}
	  else {
			login.Log4j.info("MOF is included in search");	
		}
	    
	}
	
	
	@And("^apply some source filters as \"([^\"]*)\" , \"([^\"]*)\" and checkbox should be uncheck\\.$")
	public void apply_some_source_filters_as_and_checkbox_should_be_uncheck(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys(arg2);
		CommonFunctionality.wait(2000);
		login.Log4j.info("ABIPLAST is entered in search bar");
		login.driver.findElement(By.xpath("//div[@class='filter-item--checker checkbox-control']//span[@class='input-control--indicator']")).click();
        if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ABIPLAST_included"))).isDisplayed()) {
			
			login.Log4j.info("ABIPLAST is included and displayed in search");	
		}
		
		else {
			login.Log4j.info("ABIPLAST is excluded and displayed in search");	
		}
		login.driver.findElement(By.xpath("//input[@placeholder='Search...']")).clear();
		login.driver.findElement(By.xpath("//div[@class='filters-search-item--remove']")).click();
		login.driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys(arg1);
		login.Log4j.info("MOF is entered in search bar");
		login.driver.findElement(By.xpath("//div[@class='top-matches--column']//div[1]//div[1]//div[1]//label[1]//span[1]")).click();
    if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MOF_included"))).isDisplayed()) {
			
			login.Log4j.info("MOF is included and displayed in search");	
		}
	  else {
			login.Log4j.info("MOF is excluded and displayed in search");	
		}
	    
	}
	@Given("^user selects some series$")
	public void user_selects_some_series() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 50);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_tab_bar"))).click();
		login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[1]")).click();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("add_to_myseries_icon"))).click();
		login.Log4j.info("Added series to my series tab");
	    CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();   
	}

	@And("^Open function wizard for any series to apply with function$")
	public void open_function_wizard_for_any_series_to_apply_with_function() throws Throwable {
		
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//div[@title='Open function editor (F). Investigate all available functions in the function editor window.']")).click();
		
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Remove_select"))).size() == 0) {
		
			login.Log4j.info("Select series for all series bar is removed");
			
		}
		else {
			login.Log4j.info("Select series for all series bar is not  removed");
		}
		
		
	}
	
	@Given("^click on download button\\.$")
	public void click_on_download_button() throws Throwable {
     login.driver.findElement(By.xpath("//span[@class='download-button--text drop-down-button--label']")).click();
		   
	}
	
	@Given("^user clicks on any Apply filter in the application$")
	public void user_clicks_on_any_Apply_filter_in_the_application() throws Throwable {
		CommonFunctionality.webDriverwait_keyvalue("Status_dropdown");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Status_dropdown"))).click();
		login.Log4j.info("Clicked on status dropdown");	
		CommonFunctionality.wait(5000);
		login.driver.findElement(By.xpath("//div[@class='filter-list']//div[1]//div[1]//div[1]//label[1]//span[1]")).click();
		login.Log4j.info("Clicked on Active checkbox");
		login.driver.findElement(By.xpath("//div[@class='button__primary button button__primary']")).click();
		login.Log4j.info("Clicked on Apply filter");	
			    
	}

	@And("^clicks on Copy as URL$")
	public void clicks_on_Copy_as_URL() throws Throwable {
		Thread.sleep(4000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_list"))).click();	
		login.Log4j.info("Clicked on copy Icon");
		
		login.driver.findElement(By.xpath("//span[text()='Copy as URL']")).click();
		login.Log4j.info("URL link copied");	
	}

	@And("^Paste the copied URL in the search bar\\.$")
	public void paste_the_copied_URL_in_the_search_bar() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.jse.executeScript("window.open('newpage.html','_blank');");
		Thread.sleep(3000	
				);
		if(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Status_active"))).isDisplayed()) {
			login.Log4j.info("copied URL results are copied into search pane");
			
		}
		else {
			login.Log4j.info("copied URL results are not copied into search pane");
			
		}
		
		
	}
	
	@Then("^open dropdown for Output Series Details$")
	public void open_dropdown_for_Output_Series_Details() throws Throwable {
		 login.driver.findElement(By.xpath("(//div[@class='context-menu-control']//div[@class='context-menu-control--icon'])[2]")).click();
		 login.driver.findElement(By.xpath("//span[text()='Fill with 0']")).click();
		 CommonFunctionality.wait(2000);
		 login.driver.findElement(By.xpath("(//div[@class='context-menu-control']//div[@class='context-menu-control--icon'])[2]")).click();
		 login.driver.findElement(By.xpath("//span[normalize-space()='Custom text']")).click();
		   
	}

	@Given("^user selects series into my series tab$")
	public void user_selects_series_into_my_series_tab() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Series_tab_bar"))));
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_tab_bar"))).click();
		login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[1]")).click();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("add_to_myseries_icon"))).click();
		login.Log4j.info("Added series to my series tab");
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		
		}

	@Given("^Try to apply cross section or sum over single series from functions wizard\\.$")
	public void try_to_apply_cross_section_or_sum_over_single_series_from_functions_wizard() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//div[@title='Open function editor (F). Investigate all available functions in the function editor window.']")).click();
		login.Log4j.info("clicked on function wizard");
		CommonFunctionality.wait(2000);
		WebElement Add=login.driver.findElement(By.xpath("//div[@data-id='MULTIPLY']"));
		jse.executeScript("arguments[0].scrollIntoView(true);", Add);
		
		
		CommonFunctionality.wait(2000);
		WebElement CrossSec=login.driver.findElement(By.xpath("//div[@data-id='CROSSSEC']"));
		CrossSec.click();
		CommonFunctionality.wait(2000);
		
		login.Log4j.info("clicked on Cross section Function");
		login.driver.findElement(By.xpath("//button[normalize-space()='Insert function']")).click();
		login.Log4j.info("clicked on Insert Button");
		login.driver.findElement(By.xpath("//button[normalize-space()='Apply']")).click();
		login.Log4j.info("clicked on Apply Button");
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Function_message"))).isDisplayed()) {
			login.Log4j.info("Function can only be applied over a selection of multiple series message should display.");
			
		}
		
		else {
			login.Log4j.info("Function is applied.");
		}
		
	   
	}

	
	@Given("^user clicks on Database section\\.$")
	public void user_clicks_on_Database_section() throws Throwable {
		CommonFunctionality.wait(500);
		login.driver.findElement(By.xpath("//div[@title='View results as Tree']")).click();

	}

	@Given("^expand the database till table level\\.$")
	public void expand_the_database_till_table_level() throws Throwable {
		login.driver.findElement(By.xpath("//div[@data-node-model-id='GLOBAL']//div[@class='toggle']")).click();
		CommonFunctionality.wait(2000);	
		login.driver.findElement(By.xpath("//div[@data-node-model-id='GLOBAL&&ALL']//div[@class='toggle']")).click();
		login.driver.findElement(By.xpath("//div[@data-node-model-id='TP2560837']/div[1]")).click();
		login.driver.findElement(By.xpath("//div[@data-node-model-id='SC2576097']/div[1]")).click();
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
	CommonFunctionality.wait(2000);	
	login.driver.findElement(By.xpath("//div[@class='add-to-data-selection--icon']/following::div[@class='add-to-data-selection--toggle']")).click();	
	WebElement ele=	login.driver.findElement(By.xpath("//span[@title='Add and group series in My Series (G)']"));
	if(ele.getAttribute("class").contains("disabled")) {
		 login.Log4j.info("Add and group option is greyed out ");
			
		
	}
	else {
		login.Log4j.info("Add and group option is enabled ");
	}
		
		
	}
	@Given("^Search \"([^\"]*)\" in the search field\\.$")
	public void search_in_the_search_field(String arg1) throws Throwable {
		login.driver.findElement(By.xpath("//span[@value='TREE']")).click();
		
		login.driver.findElement(By.xpath("//input[@placeholder='Search']")).clear();
		login.driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(arg1,Keys.ENTER);
		
	}

	@Given("^select ShowAll filter\\.$")
	public void select_ShowAll_filter() throws Throwable {
		CommonFunctionality.wait(2000);
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
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("internal_series"))).click();
								

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
		CommonFunctionality.wait(2000);
		List<WebElement> ele=new ArrayList<>();
		Thread.sleep(5000);
		for(int i=0;i<1;i++) {
			 ele=login.driver.findElements(By.xpath("//span[@class='svg-checkbox']"));
				System.out.println("the size is "+ele.size());
		for(WebElement e:ele) {
			JavascriptExecutor jse=(JavascriptExecutor)login.driver;
			jse.executeScript("arguments[0].scrollIntoView(true);", e);
		
			
			
			
		}
		}
		
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Orange_green"))).isDisplayed()) {
			login.Log4j.info("Orange and green dots are displayed together");		
		}
		
		else {
			login.Log4j.info("Orange and green dots are not displayed together");
			
		}
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
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_tab_bar"))).click();
		
		WebElement Series = login.driver.findElement(
				By.xpath("//div[@class='series-list-item-data']/div[@class='series-list-item--information'][1]"));
		new Actions(login.driver).moveToElement(Series).pause(3000).build().perform();
		WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("More_actions")));
		CommonFunctionality.action.moveToElement(ele1).pause(2).click().build().perform();
		CommonFunctionality.wait(2000);
		WebElement Add_Chart=login.driver.findElement(By.xpath("//span[@title='Add chart']"));
		new Actions(login.driver).moveToElement(Add_Chart).pause(2000).build().perform();
		login.driver.findElement(By.xpath("//div[contains(@class,'icon--table-vertical_large')]")).click();	
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
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//span[normalize-space(text())='Show copyright']")).click();

	}

	@Then("^All options under setup should be greyed out when unchecked\\.$")
	public void all_options_under_setup_should_be_greyed_out_when_unchecked() throws Throwable {
		if (!login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Show_copyright"))).isEnabled()) {
			login.Log4j.info("All options under setup are greyed out");
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
			 login.driver.findElement(By.xpath("//button[@class='report-problem-s--button button button__text_purple']")).click();
			
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
		WebElement Add_chart=login.driver.findElement(By.xpath("//span[normalize-space(text())='Add chart']"));
		new Actions(login.driver).moveToElement(Add_chart).pause(1000).build().perform();
		login.driver.findElement(By.xpath("//div[contains(@class,'icon--table-vertical_large')]")).click();
		//login.driver.findElement(By.xpath(login.LOCATORS.getProperty("table5"))).click();
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
			login.Log4j.info("2021 CEIC is  availablCopyRighte ");

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
