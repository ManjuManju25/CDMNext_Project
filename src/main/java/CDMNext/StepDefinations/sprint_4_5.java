package CDMNext.StepDefinations;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import CDMNext.util.CommonFunctionality;
import ch.qos.logback.core.joran.action.Action;
import cucumber.api.java.en.*;

public class sprint_4_5 {
	
	
	Actions action=new Actions(login.driver);
		
	
	//TC_1
		@Given("^Create a pie chart$")
		public void create_a_pie_chart() throws Throwable {
		    CommonFunctionality.wait(2000);
		    
		    for(int i=1;i<=3;i++)
		    {
		    login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])["+i+"]")).click();
		    }
		WebElement seriesname= login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"));
		action.moveToElement(seriesname).contextClick().build().perform();
		
		login.driver.findElement(By.xpath("//span[text()='Add chart']")).click();
		
		login.driver.findElement(By.xpath("//div[contains(@class,'icon--pie_chart-pie_large')]")).click();
		
		CommonFunctionality.wait(2000);
		    
		   
		}
		//TC_1
		@Given("^Click on edit visual$")
		public void click_on_edit_visual() throws Throwable {
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath("//button[text()='Edit Pie']")).click();
			
		    
		}
		//TC_1
		@Then("^Check for the number format option$")
		public void check_for_the_number_format_option() throws Throwable {
			
			CommonFunctionality.wait(2000);
			
			login.driver.findElement(By.xpath("(//div[text()='Number format:']//following::div[@class='context-menu-control--icon'])[1]")).click();
			
			login.driver.findElement(By.xpath("//div[@class='number-format-picker']")).click();
			
			
			if(login.driver.findElements(By.xpath("//div[@class='number-format-picker']//div[@class='number-format-picker--label']")).size()==3)
			{
				System.out.println("Number format drodpdown data displayed");
			}
			else {
				fail("Number format drodpdown data displayed");
			}
			login.driver.findElement(By.xpath("//button[text()='Save']")).click();
			
		   
		}
		//TC_03
		@Given("^Click on the bell icon on right top corner$")
		public void click_on_the_bell_icon_on_right_top_corner() throws Throwable {
			
			CommonFunctionality.wait(2000);
			
			login.driver.findElement(By.xpath("//div[@class='user-notifications--icon']")).click();
			
		   
		}
		//TC_03
		@Given("^Go to notifications tab$")
		public void go_to_notifications_tab() throws Throwable {
			
             CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath("//div[text()='Notifications']")).click();
			
		}
//TC_03
		@Then("^Check for watchlist notification$")
		public void check_for_watchlist_notification() throws Throwable 
		{
		    
			if(login.driver.findElements(By.xpath("(//div[@class='insights-notifications-item-avatar'])[1]")).size()==1)
			{
				System.out.println("watchlist notification should be displayed");
			}
			else {
				fail("watchlist notification not displayed");
			}
	
		}
		
		
//TC_04
@And("^Turn 'OFF' Notification under profile dropdow$")
public void turn_OFF_Notification_under_profile_dropdow() throws Throwable {
	CommonFunctionality.wait(2000);
	
	WebElement on=login.driver.findElement(By.xpath("(//span[@class='bootstrap-switch-handle-on bootstrap-switch-primary'])[2]"));
	
	action.moveToElement(on).click().build().perform();
	
    
}
//TC_04
@And("^click on Watchlist$")
public void click_on_Watchlist() throws Throwable {
	CommonFunctionality.wait(2000);
	
	for(int i=1;i<=3;i++)
	{
		login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])["+i+"]")).click();
	}
	
	WebElement series=login.driver.findElement(By.xpath("//div[@class='series-item--name'][1]"));
	action.moveToElement(series).contextClick().build().perform();
	
	
	login.driver.findElement(By.xpath("//*[text()='Add to Watchlist']")).click();
	
	CommonFunctionality.wait(3000);
	
	login.driver.findElement(By.xpath("(//div[@class='watchlist-control']//span[@class='input-control--indicator'])[1]")).click();
	CommonFunctionality.wait(3000);
	login.driver.findElement(By.xpath("//button[@class='button__primary button button__primary']")).click();
	CommonFunctionality.wait(3000);
	login.driver.findElement(By.xpath("(//span[@class='series-tab--icon'])[1]")).click();
	
  
}
//TC_04
@Then("^verify Enable all button should be turn 'OFF' and notifcaiton should not displayed$")
public void verify_Enable_all_button_should_be_turn_OFF_and_notifcaiton_should_not_displayed() throws Throwable {
	
	CommonFunctionality.wait(2000);
	if(login.driver.findElements(By.xpath("//div[@class='watchlist--switcher watchlist--switcher__disabled']")).size()==1)
	{
		System.out.println("Enable all button should be turn 'OFF'");
	}
	else {
		fail("Enable all button should be turn 'OFF'");
	}
	WebElement series=login.driver.findElement(By.xpath("//div[@class='button button__sm watchlist--remove']"));
	action.moveToElement(series).click().build().perform();
	
}

		
//TC_05
@And("^Turn 'ON' Notification under profile dropdow$")
public void turn_ON_Notification_under_profile_dropdow() throws Throwable {
	CommonFunctionality.wait(2000);
	
	
	String s=login.driver.findElement(By.xpath("(//div[@class='bootstrap-switch-container'])[2]")).getAttribute("style");
	
	
	if(s.equalsIgnoreCase("width: 94.575px; margin-left: 0px;"))
	{
		System.out.println("Enable all button should be turn 'ON'");
	}
	else {
		login.driver.findElement(By.xpath("(//div[@class='bootstrap-switch-container'])[2]")).click();
	}
	
	
}

//TC_05
@Then("^verify Enable all button should be turn 'ON' and notifcaiton should not displayed$")
public void verify_Enable_all_button_should_be_turn_ON_and_notifcaiton_should_not_displayed() throws Throwable {
	CommonFunctionality.wait(2000);
	
	
String s=login.driver.findElement(By.xpath("//div[@class='bootstrap-switch-container']")).getAttribute("style");
	
	System.out.println("==============>"+s);
	
	if(s.equalsIgnoreCase("margin-left: 0px; width: 94.575px;"))
	{
		System.out.println("Enable all button should be turn 'ON'");
	}
	else {
		fail("Enable all button should not be turn 'ON'");
	}
	

	WebElement series=login.driver.findElement(By.xpath("//div[@class='button button__sm watchlist--remove']"));
	action.moveToElement(series).click().build().perform();
	
	
}
		

		
	//TC_06	
@And("^Turn 'OFF'on  watchlist notification$")
public void turn_OFF_on_watchlist_notification() throws Throwable {
	CommonFunctionality.wait(2000);
	WebElement swich=login.driver.findElement(By.xpath("//span[@class='bootstrap-switch-handle-on bootstrap-switch-primary']"));
	action.moveToElement(swich).click().build().perform();
	CommonFunctionality.wait(2000);
	WebElement series=login.driver.findElement(By.xpath("//div[@class='button button__sm watchlist--remove']"));
	action.moveToElement(series).click().build().perform();
	
}
//TC_06
@Then("^verify notification turn 'ON' setting on profile should not sync with Turn ON/OFF watchlist notification$")
public void verify_notification_turn_ON_setting_on_profile_should_not_sync_with_Turn_ON_OFF_watchlist_notification() throws Throwable {
	
	if(login.driver.findElements(By.xpath("(//div[@class='bootstrap-switch bootstrap-switch-wrapper bootstrap-switch-on bootstrap-switch-mini bootstrap-switch-animate'])[2]")).size()==1)
	{                                    // (//div[@class='bootstrap-switch bootstrap-switch-wrapper bootstrap-switch-on bootstrap-switch-mini bootstrap-switch-animate'])[2]
		System.out.println("Enable all button should be turn 'ON'");
	}
	else {
		fail("Enable all button should turn 'OFF'");
	}
	
   
}
		
		
		
		
		
		
		
		
		
		

}
