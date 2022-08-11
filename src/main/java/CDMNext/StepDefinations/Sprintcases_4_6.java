package CDMNext.StepDefinations;


import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Sprintcases_4_6 {
	public String Title;
	JavascriptExecutor js = (JavascriptExecutor) login.driver;
	Actions action = new Actions(login.driver);
	Actions a=new Actions(login.driver);
	WebDriverWait wait = new WebDriverWait(login.driver, 30);
	@And("^Open preference dropdown1$")
	public void open_preference_dropdown1() throws Throwable {
		CommonFunctionality.wait(12000);
		CommonFunctionality.DeleteSeries();
		WebElement preferences;
		try {
			preferences = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@title='View and edit profile information']", 8);
		} catch (Exception e) {
			preferences = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='account-avatar--container'] | //*[@class='account-avatar--image']", 8);
		}
		new Actions(login.driver).moveToElement(preferences).pause(3000).click().build().perform();
		System.out.println("==============>First line Execution================>");
	}

@And("^In database tab expand tree up section level where we multiple Tables present$")
public void in_database_tab_expand_tree_up_section_level_where_we_multiple_Tables_present() throws InterruptedException
{
	Thread.sleep(2000);
	login.driver.findElement(By.xpath("//span[contains(text(),'Databases')]")).click();
	login.driver.findElement(By.xpath("(//div[@data-node-model-id='WORLD']/div[@class='toggle'])[1]")).click();
	login.driver.findElement(By.xpath("(//div[@data-node-model-id='WORLD&&ALL']/div[@class='toggle'])[1]")).click();
	login.driver.findElement(By.xpath("(//div[@data-node-model-id='TP74383']/div[@class='toggle'])[1]")).click();
	login.driver.findElement(By.xpath("(//div[@data-node-model-id='SC74575']/div[@class='toggle'])[1]")).click();
	
}
@And("^Select any two Tables (\\d+)$")
public void select_any_two_tables(int size)
{
	List<WebElement> l=login.driver.findElements(By.xpath("//span[@class='svg-checkbox']"));
	for(int i=1;i<=l.size()-1;i++)
	{
		l.get(i).click();
		if(i==size)
		{
			break;
		}
	}
	a.contextClick().build().perform();
	
}
@Then("^Click on copy link icon and select Copy selected links$")
public void click_on_copy_link_icon_and_select_Copy_selected_links()
{
	
	a.moveToElement(login.driver.findElement(By.xpath("//span[contains(text(),'Copy selected links')]"))).click().perform();
	login.driver.findElement(By.xpath("//div[@class='growl-message growl-success']")).getText().toString();
}
	@Given("^Expand data table having more series$")
	public void expand_data_table_having_more_series() throws Throwable {

		Thread.sleep(5000);
		login.driver.get("https://stage.ceicdata.com/node/GLOBAL__GLOBAL&&ALL__TP40775__SC55316__TB155383");
		Thread.sleep(10000);
		String seriesname = wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Table AL.IMF.BOP: BPM6: Balance of Payments: Detailed Presentation')]")))
				.getText();
		System.out.println("seriesName:" + seriesname);

	}

	// TC_18480_01
	@Given("^Scroll down and verify auto loading series$")
	public void scroll_down_and_verify_auto_loading_series() throws Throwable {
		Thread.sleep(1000);

		//WebElement loadingicon = login.driver.findElement(By.xpath("//*[contains(text(),'loading')]"));
		// js.executeScript("arguments[0].scrollIntoview(true);",loadingicon);
		js.executeScript("arguments[0].scrollIntoView(true);", login.driver.findElement(By.xpath("//*[contains(text(),'loading')]")));
		Thread.sleep(2000);

		System.out.println("The series should be auto-loaded when scroll down");

	}
	@Given("^login to User (\\d+) account and click on notification panel$")
	public void login_to_User_account_and_click_on_notification_panel(int arg1) throws Throwable {
		Thread.sleep(2000);

		WebElement signout = login.driver.findElement(By.xpath("//span[contains(text(),'Sign out')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", signout);
		Thread.sleep(1000);
		signout.click();
		//Thread.sleep(2000);
		//login.driver.findElement(By.xpath("//button[contains(text(),'Save and sign out')]")).click();
		
		
	
			
			Thread.sleep(2000);
			login.driver.findElement(By.name("user_id")).clear();
			login.driver.findElement(By.name("user_id")).sendKeys("venkat.test@gmail.com");
			login.driver.findElement(By.name("password")).clear();
			login.driver.findElement(By.name("password")).sendKeys("Ceic@123");
			login.driver.findElement(By.xpath("//button[@class='btn']")).click();

			Thread.sleep(4000);
			WebElement notification = login.driver.findElement(By.xpath("//*[@class='user-notifications--icon']"));
			action.moveToElement(notification).perform();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//*[@class='user-notifications--icon']")).click();

		
			
	
		}
		@Given("^Share any insight to another user$")
		public void share_any_insight_to_another_user() throws Throwable {
			Thread.sleep(2000);
			WebElement signout = login.driver.findElement(By.xpath("//span[contains(text(),'Sign out')]"));
			js.executeScript("arguments[0].scrollIntoView(true);", signout);
			Thread.sleep(1000);
			signout.click();
	           Thread.sleep(2000);
			//login.driver.findElement(By.xpath("//button[contains(text(),'Delete and sign out')]")).click();

			Thread.sleep(1000);
			login.driver.findElement(By.name("user_id")).sendKeys("sudh.suresh@gmail.com");
			login.driver.findElement(By.name("password")).sendKeys("Ceic@123");
			login.driver.findElement(By.xpath("//button[@class='btn']")).click();
			Thread.sleep(8000);

			login.driver.findElement(By.xpath("//a[contains(text(),'My insights')]")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//span[contains(text(),'Create insight')]")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//button[contains(text(),'Create insight')]")).click();

			// click on cogwel icon
			login.driver.findElement(By.xpath("//*[@class='insight-context-menu--menu-icon']")).click();

			// click on share
			login.driver.findElement(By.xpath("//span[contains(text(),'Share')]")).click();

			// invite specfic
			login.driver.findElement(By.xpath("//*[@class='share-specific-search-user--input form--control']")).click();
			Thread.sleep(1000);
			// Enter Email id

			login.driver.findElement(By.xpath("//*[@class='share-specific-search-user--input form--control']"))
					.sendKeys("venkat.test@gmail.com");
			Thread.sleep(3000);
			login.driver.findElement(By.xpath("//div[@class='choosable-list']/div")).click();

			// click on save button
			login.driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();

			// confirmation
			login.driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();

		}
		@Given("^delete insight$")
		public void delete_insight() throws Throwable {
			Thread.sleep(3000);

			// click on cogwel icon
			login.driver.findElement(By.xpath("//*[@class='insight-context-menu--menu-icon']")).click();

			// click on delete button
			login.driver.findElement(By.xpath("//span[contains(text(),'Delete')]")).click();

			// delete forever
			login.driver.findElement(By.xpath("//button[contains(text(),'Delete forever')]")).click();

		}
		@Given("^Click on 'Customer service team'$")
		public void click_on_Customer_service_team() throws Throwable {
			Thread.sleep(2000);

			login.driver.findElement(By.xpath("(//*[contains(text(),'customer service team')])[1]")).click();

		}
		@Then("^\"([^\"]*)\" should be loaded in new browser tab$")
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

		@And("^Select series1$")
		public void Select_series1() throws InterruptedException
		{
			Thread.sleep(3000);	
			login.driver.findElement(By.xpath("//div[@title='View results as List']")).click();
			Thread.sleep(2000);
				
			
				
			
		}
		 @And("^click on footnotes$")
		 public void click_on_footnotes()
		 {
			 a.moveToElement(login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"))).contextClick().perform();
			 a.moveToElement(login.driver.findElement(By.xpath("//span[@title='Footnotes']"))).click().perform();
		 }
		 @Then("^verify the title of the footnotes$")
		 public void  verify_the_title_of_the_footnotes()
		 {
		 	login.driver.switchTo().activeElement();
		 	String footnotetitle=login.driver.findElement(By.xpath("//span[@class='footnotes-modal--name']/span")).getText().toString();
		 	login.driver.findElement(By.xpath("//div[@class='movable-modal--close']")).click();
		 	String series_title=login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]")).getText().toString();
		 	footnotetitle=footnotetitle.replace("(","");
		 	footnotetitle=footnotetitle.replace(")","");
		 System.out.println(footnotetitle);
		 System.out.println(series_title);
		 Assert.assertEquals(footnotetitle,series_title);
		 }


		

	
	



}
