package CDMNext.StepDefinations;

import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class InsightGeneral {
	Actions action=new Actions(login.driver);
	public void click_ceic_logo(){
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ceic_logo"))).click();
	}
	public void delete_insight() throws Exception{
		 WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Fav_Insight_Title")));
		 action.moveToElement(ele).build().perform();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_del_in"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Delete_ok"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
	}
	public void delete_series() throws Exception{
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();
		Thread.sleep(8000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("delete_myeries"))).click();
	}
	public void add_Series() throws Throwable{
		   Footnotes f=new Footnotes();
		   f.goto_Db_Search_tab();
		   f.expand_the_database();
		   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_seriestoadd"))).click();
		   Thread.sleep(2000);
		   action.sendKeys("a").perform();
		   Thread.sleep(2000);
		   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_secondseriestoadd"))).click();
		   Thread.sleep(2000);
		   action.sendKeys("a").perform();
	}
	public void delete_all_views() throws Throwable{
		WebElement visual = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Visual")));
		 action.contextClick(visual).build().perform();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_DeleteAllviews"))).click();
		Thread.sleep(2000);
	}
	public void close_insight(){
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
	}
	public void open_insight() throws Exception{
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("insights"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MY_INSIGHTS"))).click();
		 Thread.sleep(4000);
	}
	public void expander() throws Exception{
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("search_presentation"))).click();
		Thread.sleep(2000);
	}
	//Tc_InsightGeneral_01
	@Given("^Verify CEIC logo$")
	public void verify_CEIC_logo() throws Throwable {
		Thread.sleep(10000);
		if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("untitledInsight"))).size()!=0)
		{
			if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("applogo"))).size()!=0){
		    	System.out.println("CEIC logo is shown");
		    }
		    else{
		    	Assert.fail("CEIC logo is not shown");
		    }
		}
		else{
			Assert.fail("CEIC logo is not shown");
		}
	}
	/*public void new_insight() throws Throwable{
		 Footnotes f1;
		    f1=new Footnotes();
		    login.driver.navigate().refresh();
		    f1.create_an_insight();
		    Thread.sleep(7000);
	}*/
	//Tc_InsightGeneral_02
	@Given("^Create new insight$")
	public void create_new_insight() throws Throwable {
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("file"))).click();
		   Thread.sleep(2000);
		   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("new_insight"))).click();
		   Thread.sleep(2000);
		   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("create_insight"))).click();
		    login.driver.manage().timeouts().implicitlyWait(1200, TimeUnit.SECONDS);
		   Thread.sleep(9000);
	}
	/*@Given("^Create new insight$")
	public void create_new_insight() throws Throwable {
	    Footnotes f1;
	    f1=new Footnotes();
	    login.driver.navigate().refresh();
	    f1.create_an_insight();
	    Thread.sleep(7000);
	}
*/
	@Then("^Click on CEIC logo to verify$")
	public void click_on_CEIC_logo_to_verify() throws Throwable {
		
	   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("applogo"))).click();
	   Thread.sleep(3000);
		if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("untitledInsight"))).size()!=0)
		{
			System.out.println("User will redirect to landing page");
		}
		else{
			Assert.fail("User failed to  redirect to landing page");
		}
	}
	//Tc_InsightGeneral_03
	@Given("^Verify insight title$")
	public void verify_insight_title() throws Throwable {
		if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("untitledInsight"))).size()!=0)
		{
			System.out.println("Insight title is available");
		}
		else
		{
			Assert.fail("Insight title is not available");
		}
	}
	//Tc_InsightGeneral_04
	@Given("^Click  insight title$")
	public void click_insight_title() throws Throwable {
		Thread.sleep(25000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("untitledInsight"))).click();
		Thread.sleep(2000);
		action.sendKeys("test").sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		
	}

	@Given("^Verify insight title change$")
	public void verify_insight_title_change() throws Throwable {
		String insightText = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("untitledInsight"))).getText();
		Assert.assertEquals("test", insightText);
	}
	//Tc_InsightGeneral_05
	@Given("^Change insight title and verify insight URL after changed insight title$")
	public void change_insight_title_and_verify_insight_URL_after_changed_insight_title() throws Throwable {
		
		String username = "SR" + new Random().nextInt(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("untitledInsight"))).click();
		Thread.sleep(7000);
		action.sendKeys(username).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(7000);
		 String actualURL = login.driver.getCurrentUrl();
		    String expectedURL1 = "https://stage.ceicdata.com/";
		    String expectedURL2 = username;
		    String expectedURL3 = "/myseries";
		    String expectedURL=expectedURL1+expectedURL2+expectedURL3;
		    System.out.println(expectedURL);
		    Assert.assertEquals(actualURL, expectedURL);
	}
	//Tc_InsightGeneral_06
	@Given("^Verify insight URL after changed insight title with existing insight title$")
	public void verify_insight_URL_after_changed_insight_title_with_existing_insight_title() throws Throwable {
		
		Thread.sleep(10000);
		 WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("untitledInsight")));
		
		String username = "SR" + new Random().nextInt(1000);
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("untitledInsight"))).click();
		 Thread.sleep(2000);
		 action.moveToElement(ele).sendKeys(username).sendKeys(Keys.ENTER).build().perform();
		//login.driver.findElement(By.xpath(login.LOCATORS.getProperty("untitledInsight"))).sendKeys(username);
//		Robot robot = new Robot();                          
//		
//		robot.keyPress(KeyEvent.VK_CONTROL); 
//		robot.keyPress(KeyEvent.VK_ENTER); 
		
		String actual = login.driver.getCurrentUrl();
		System.out.println(actual);
		//login.driver.navigate().refresh();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("file"))).click();
		   Thread.sleep(2000);
		   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("new_insight"))).click();
		   Thread.sleep(2000);
		   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_InsightTitle"))).sendKeys(username);
			
		   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("create_insight"))).click();
		    login.driver.manage().timeouts().implicitlyWait(1200, TimeUnit.SECONDS);
		   Thread.sleep(9000);
	
				Thread.sleep(5000);
		String expectedURL = login.driver.getCurrentUrl();
		System.out.println(expectedURL);
		Assert.assertNotEquals(actual, expectedURL);
	}
// Tc_InsightGeneral_07
	@Given("^Verify tooltip for insight title$")
	public void verify_tooltip_for_insight_title() throws Throwable {
		WebElement untitledInsight = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("untitledInsight")));
		Thread.sleep(4000);
		action.moveToElement(untitledInsight).build().perform();
		Thread.sleep(4000);
		String insightTitle = untitledInsight.getAttribute("title");
		System.out.println(insightTitle);
		Assert.assertEquals("Click to edit the Insight", insightTitle);
		
	}
	
	//Tc_InsightGeneral_08
	@Given("^Verify tooltip for favorite icon$")
	public void verify_tooltip_for_favorite_icon() throws Throwable {
		
		WebElement favicon = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("addtofavorite")));
		Thread.sleep(4000);
		action.moveToElement(favicon).build().perform();
		Thread.sleep(4000);
		String expectedfavIconText = favicon.getAttribute("title");
		String actualfavIconText ="Add to favorite";
		System.out.println(expectedfavIconText);
		System.out.println(actualfavIconText);
		Assert.assertEquals(actualfavIconText, expectedfavIconText);
		}
	//Tc_InsightGeneral_09
	@Given("^Click on tag icon$")
	public void click_on_tag_icon() throws Throwable {
	
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tagicon"))).click();
	
	}

	@Given("^Verify tag popup is displayed$")
	public void verify_tag_popup_is_displayed() throws Throwable {
	   WebDriverWait wait=new WebDriverWait(login.driver, 200);
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("add_tag_popup"))));
	   if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("add_tag_popup"))).size()!=0){
		   System.out.println("Add tag pop up is shown");
		   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TAG_POPUP_CLOSE"))).click();
	   }
	   else{
		   Assert.fail("Add tag pop up is not shown");
		   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TAG_POPUP_CLOSE"))).click();

	   }
	   
	}
	//Tc_InsightGeneral_10

	@Given("^Click on tag icon and enter the tags$")
	public void click_on_tag_icon_and_enter_the_tags() throws Throwable {
		Thread.sleep(5000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tagicon"))).click();
		 Thread.sleep(5000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("input_tag_text"))).sendKeys("Testing");
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("input_tag_text"))).sendKeys(Keys.ENTER);
	}

	
	@Given("^Verify tag in insight explorer$")
	public void verify_tag_in_insight_explorer() throws Throwable {
		
		String tagEnter = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tagText"))).getText();
		String tagEnter1 = tagEnter.replaceAll("[^a-zA-Z0-9]", "");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tag_save"))).click();
		open_insight();
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("insights"))).click();
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MY_INSIGHTS"))).click();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ALL_TAG_DROPDOWN"))).click();
		Thread.sleep(4000);
		String tagText = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ALL_TAG_DROPDOWN_CONTENT"))).getText();
		String tagText1 = tagText.replaceAll("[0-9]", "").replaceAll("\\W", "");
		System.out.println(tagText1); 
		//String tagEnter = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("input_tag_text"))).getText();
		System.out.println(tagEnter1);
		if(tagEnter1.equalsIgnoreCase(tagText1))
		{
			System.out.println("Tag is shown in insight explorer");
			//login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ALL_TAG_DROPDOWN"))).click();
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ALL_TAG_DROPDOWN_CONTENT"))).click();
			WebElement insight = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("HOVER_INSIGHT")));
			action.moveToElement(insight).build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TAG_ICON"))).click();
			Thread.sleep(4000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RemoveTag"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tag_save"))).click();
			Thread.sleep(2000);
			close_insight();
		}
		else{
			Assert.fail("Tag is not shown in insight explorer");
		}
	}
	//Tc_InsightGeneral_11
	@Given("^Verify Cancel option in tag popup$")
	public void verify_Cancel_option_in_tag_popup() throws Throwable {
		if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("add_tag_popup"))).size()!=0)
		{
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TAG_POPUP_CLOSE"))).click();
			System.out.println("Add tag popup is closed");
		}
		else{
			Assert.fail("Add tag popup is not  closed");
		}
		
	}
	//Tc_InsightGeneral_12
	@Given("^Click on Share icon$")
	public void click_on_Share_icon() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SHARE_ICON"))).click();
	}

	@Given("^Verify share popup is shown$")
	public void verify_share_popup_is_shown() throws Throwable {
	 if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("SHARE_POPUP"))).size()!=0)
	 {

		 System.out.println("Share pop up is shown");

		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Share_Popup_Close"))).click();
	 }
	 else{
		 Assert.fail("Share pop up is not shown");
	 }
	 
	}
	//Tc_InsightGeneral_13
	@Given("^Click on Save as,Verify 'Save as' button for untitled insight\\.$")
	public void click_on_Save_as_Verify_Save_as_button_for_untitled_insight() throws Throwable {
		
		click_ceic_logo();
		String insight = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Untitled_insight"))).getText();
		System.out.println(insight);
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SAVE_AS"))).click();
		Thread.sleep(4000);
		WebElement element = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Untitled_insight")));
		action.moveToElement(element);
		action.click();
		action.sendKeys("TEST");
		Thread.sleep(3000);
		action.build().perform();
	
		//Thread.sleep(5000);
		action.moveToElement(element);
		action.click();
		action.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		action.build().perform();
		//login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Untitled_insight"))).sendKeys(Keys.ENTER);
		String updatedInsight = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Untitled_insight"))).getText();
		System.out.println(updatedInsight);
		if(!insight.matches(updatedInsight))
		{
			System.out.println("Untitled Insight has been updated");
		}
		else{
			Assert.fail("Failed to updated insight");
		}
	}
	//Tc_InsightGeneral_14
	@Given("^Click on Share icon for untitled insight$")
	public void click_on_Share_icon_for_untitled_insight() throws Throwable {
		click_ceic_logo();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SHARE_ICON"))).click();
		Thread.sleep(3000);
	}

	@Given("^Verify Share for untitled insight\\.$")
	public void verify_Share_for_untitled_insight() throws Throwable {
		 if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Name_Insight"))).size()!=0)
		 {

			 System.out.println("Name insight  is shown");

			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name_Insight_Close"))).click();
			Thread.sleep(5000);
		 }
		 else{
			 Assert.fail("Name insight  is not shown");
		 }
	}
	//Tc_InsightGeneral_15
	@Given("^Update the untitled insight name$")
	public void update_the_untitled_insight_name() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name_Insight_input_text"))).clear();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name_Insight_input_text"))).sendKeys("Testing");
		Thread.sleep(4000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name_Insight_Save"))).click();
		Thread.sleep(4000);
	}

	@Given("^Verify Share pop up is shown$")
	public void verify_Share_pop_up_is_shown() throws Throwable {
		 if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("SHARE_POPUP"))).size()!=0)
		 {

			 System.out.println("Share pop up is shown");
			
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Share_Popup_Close"))).click();
		 }
		 else{
		
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Share_Popup_Close"))).click();
			 Assert.fail("Share pop up is not shown");
		 }
		 
	}
	//Tc_InsightGeneral_16
	@Given("^Verify the the insight  saved with updated title\\.$")
	public void verify_the_the_insight_saved_with_updated_title() throws Throwable {
		click_ceic_logo();
		Thread.sleep(4000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SHARE_ICON"))).click();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name_Insight_input_text"))).clear();
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name_Insight_input_text"))).sendKeys("hi");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("url"))).click();
		Thread.sleep(4000);
		WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name_Insight_input_text")));
		String nameInsightUpdated = ele.getAttribute("value");
		System.out.println(nameInsightUpdated);
		Thread.sleep(4000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name_Insight_Save"))).click();
		Thread.sleep(4000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Share_Popup_Close"))).click();
		Thread.sleep(4000);
		String upInsight = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Untitled_insight"))).getText();
		System.out.println(upInsight);
		if(nameInsightUpdated.equalsIgnoreCase(upInsight))
		{
			System.out.println("The Insight  saved with updated title");
			 
		}
		else{
			Assert.fail("The Insight not saved with updated title");
		}
	}
	//Tc_InsightGeneral_17
	
	@Given("^Verify insight url updated after insight title changed$")
	public void verify_insight_url_updated_after_insight_title_changed() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name_Insight_input_text"))).clear();
		String insightId = "TC" + new Random().nextInt(1000);
		String str="https://stage.ceicdata.com/";
		String changedurl=str.concat(insightId);
		System.out.println(changedurl);

		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name_Insight_input_text"))).sendKeys(insightId);
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name_Insight_Save"))).click();
		Thread.sleep(6000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Share_Popup_Close"))).click();
		Thread.sleep(4000);
		String currentUrl = login.driver.getCurrentUrl();
		String URL = currentUrl.replaceAll("/views", "");
		System.out.println(URL);
		if(URL.equalsIgnoreCase(changedurl))
		{
			System.out.println("The insight URL  updated as changing the insight title.");
			 
		}
		else{
			Assert.fail("The insight URL  not updated as changing the insight title.");
		}
	}
	//Tc_InsightGeneral_18
	@Given("^Click on Edit icon on insight URL field and Verify$")
	public void click_on_Edit_icon_on_insight_URL_field_and_Verify() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name_Insight_input_text"))).clear();
		
		String insightId = "SR" + new Random().nextInt(1000);
		String str="https://stage.ceicdata.com/";
		String changedurl=str.concat(insightId);
		System.out.println(changedurl);
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name_Insight_input_text"))).sendKeys(insightId);
		String insightId1 = "SS" + new Random().nextInt(1000);
		String str1="https://stage.ceicdata.com/";
		String changedurl1=str1.concat(insightId).concat(insightId1);
		System.out.println(changedurl1);
		
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("url"))).clear();
		Thread.sleep(6000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("url"))).sendKeys(insightId1);
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name_Insight_Save"))).click();
		Thread.sleep(6000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Share_Popup_Close"))).click();
		Thread.sleep(4000);
		String currentUrl = login.driver.getCurrentUrl();
		String URL = currentUrl.replaceAll("/views", "");
		System.out.println(URL);
		if(URL.equalsIgnoreCase(changedurl1))
		{
			System.out.println("The insight URL  updated as per the change.");
			 
		}
		else{
			Assert.fail("The insight URL not updated as per the change.");
		}
	}
	//Tc_InsightGeneral_19
	@Given("^Verify the alert message while click on edit icon for insight URL change$")
	public void verify_the_alert_message_while_click_on_edit_icon_for_insight_URL_change() throws Throwable {
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("url"))).clear();
//		Thread.sleep(6000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("url"))).sendKeys("1");
//		Thread.sleep(3000);
		WebElement editHover = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Hover")));
		action.moveToElement(editHover).build().perform();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_icon"))).click();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("url"))).sendKeys("1");
		
		if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Alert_message"))).size()!=0)
		{
			System.out.println("The alert message is shown");
		
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name_Insight_Close"))).click();
			
		}
		else{
			Assert.fail("The alert message is not shown");
		}
	}
	//Tc_InsightGeneral_20
	@Given("^Verify 'Copy' permanent link' option\\.$")
	public void verify_Copy_permanent_link_option() throws Throwable {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name_Insight_input_text"))).clear();
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name_Insight_input_text"))).sendKeys("Test");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Insight_Copy_Link"))).click();
		Thread.sleep(4000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name_Insight_Save"))).click();
		Thread.sleep(4000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Share_Popup_Close"))).click();
		
		String InsightCuurentTab=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Untitled_insight"))).getText();
		Robot robot = new Robot();                          
		robot.keyPress(KeyEvent.VK_CONTROL); 
		robot.keyPress(KeyEvent.VK_T); 
		robot.keyPress(KeyEvent.VK_CONTROL); 
		robot.keyPress(KeyEvent.VK_V); 
		robot.keyPress(KeyEvent.VK_CONTROL); 
		robot.keyPress(KeyEvent.VK_ENTER); 
		//Switch focus to new tab
		ArrayList<String> tabs = new ArrayList<String> (login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs.get(1));
		//Launch URL in the new tab
		//login.driver.get(copyURL);
		Thread.sleep(7000);
		String InsightNewTab=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Untitled_insight"))).getText();
		Thread.sleep(4000);
		if(InsightCuurentTab.equalsIgnoreCase(InsightNewTab))
		{
			System.out.println("Insight loaded");
			login.driver.close();
			Thread.sleep(3000);
			login.driver.switchTo().window(tabs.get(0));
		}
		else{
			Assert.fail("Fail to load insight");
		}
	}
//Tc_InsightGeneral_21

@Given("^Verify the tooltip for Copy permanent link\\.$")
public void verify_the_tooltip_for_Copy_permanent_link() throws Throwable {
	WebElement toolTip = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("copy_link_tooltip")));
	
	if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Name_Insight"))).size()!=0)
	{
		action.moveToElement(toolTip).build().perform();
		String copyLinkToolTip = toolTip.getAttribute("title");
		System.out.println(copyLinkToolTip);
		Assert.assertEquals("Permanent link is an insight URL that will never be changed.", copyLinkToolTip);
		Thread.sleep(4000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name_Insight_Close"))).click();
	}
	else{
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name_Insight_Close"))).click();
		Assert.fail("Tooltip not shown");
	}
}
//Tc_InsightGeneral_22
@Given("^Verify disabled save button\\.$")
public void verify_disabled_save_button() throws Throwable {
	if(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name_Insight_Save"))).isEnabled())
	{
		Assert.fail("Save button is enabled");
	}
	else{
		System.out.println("Save is disabled");
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name_Insight_Close"))).click();
		
	}
}
//Tc_InsightGeneral_23
@Given("^Verify Cancel/Dismiss\\(X\\) options for 'Name Insight' popup$")
public void verify_Cancel_Dismiss_X_options_for_Name_Insight_popup() throws Throwable {
   if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Name_Insight"))).size()!=0)
   {
	   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name_Insight_Close"))).click();
	   System.out.println("The pop up is closed");
   }
   else
   {
	   Assert.fail("Fail to close");
   }
 
}

	//Tc_InsightGeneral_24
	@Given("^Click on File menu and Verify$")
	public void click_on_File_menu_and_Verify() throws Throwable {
		WebElement file = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("file")));
		file.click();
		Thread.sleep(4000);
		String[] file_list={"View","Add to favorite","New","Open","Save","Delete","Save as","Refresh","Settings","Protect","Download","Share"};
		  List<WebElement> elements = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("file_drpdwn")));
		  for (int i = 0; i < file_list.length; i++) {
			    String optionValue = elements.get(i).getText();
			    if (optionValue.equals(file_list[i])) {
			        System.out.println("passed on: " + optionValue);
			    } else {
			    	Assert.fail("failed on: " + optionValue);
			    }
			   
			}
	}
	//Tc_InsightGeneral_25
	@Given("^Verify icons for file menu$")
	public void verify_icons_for_file_menu() throws Throwable {
		WebElement file = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("file")));
		file.click();
		Thread.sleep(8000);
		boolean View_Icon = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("View_Icon"))).isDisplayed();
		boolean Add_To_Favorite_Icon = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_To_Favorite_Icon"))).isDisplayed();
		boolean New_Icon = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("New_Icon"))).isDisplayed();
		boolean Open_Icon = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Open_Icon"))).isDisplayed();
		boolean Save_Icon = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Save_Icon"))).isDisplayed();
		boolean Delete_Icon = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Delete_Icon"))).isDisplayed();
		boolean Save_As_Icon = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Save_As_Icon"))).isDisplayed();
		boolean Refresh_Icon = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Refresh_Icon"))).isDisplayed();
		boolean Settings_Icon = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Settings_Icon"))).isDisplayed();
		boolean Protect_Icon = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Protect_Icon"))).isDisplayed();
		boolean Download_Icon = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Download_Icon"))).isDisplayed();
		boolean Share_Icon = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Share_Icon"))).isDisplayed();
		if(View_Icon==true && Add_To_Favorite_Icon==true && New_Icon==true && Open_Icon==true &&Save_Icon==true && Delete_Icon==true&&Save_As_Icon==true&&Refresh_Icon==true&&
				Settings_Icon==true&&Protect_Icon==true&&Download_Icon==true&&Share_Icon==true)
		{
			System.out.println("Icons are displayed for all options");
		}
		else
		{
			Assert.fail("Icons not displayed for  options");
		}
	}
//Tc_InsightGeneral_26
	@Given("^Click on File menu$")
	public void click_on_File_menu() throws Throwable {
		WebElement file = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("file")));
		file.click();
		Thread.sleep(3000);
	}

	@Given("^Click on View option and Verify$")
	public void click_on_View_option_and_Verify() throws Throwable {
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("View_Btn"))).click();
		 if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Preview"))).size()!=0)
		 {
			 System.out.println("Insight opened in Preview mode");
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close"))).click();
		 }
		 else{
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close"))).click();
			 Assert.fail("Insight not opened in Preview mode");
		 }
	}
	//Tc_InsightGeneral_27
	@Given("^Click on Add to favorite option and Verify$")
	public void click_on_Add_to_favorite_option_and_Verify() throws Throwable {
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_To_Favorite_Icon"))).click();
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("insights"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Favorites"))).click();
		 Thread.sleep(2000);
		 String Fav_Insight_Title = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Fav_Insight_Title"))).getAttribute("title");
		 String Insight_Title=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Untitled_insight"))).getText();
		 if(Insight_Title.equalsIgnoreCase(Fav_Insight_Title))
		 {
			 System.out.println("The insight is shown in favorite list");
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
		 }
		 else{
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
			 Assert.fail("The insight is not shown in favorite list");
		 }
		 click_on_File_menu();
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Remove_Fav"))).click();
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("insights"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Favorites"))).click();
		 Thread.sleep(2000);
		 if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Fav_Insight_Empty"))).size()!=0)
		 {
			 System.out.println("The insight is removed from favorite list");
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
		 }
		 else{
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
			 Assert.fail("The insight is still shown in favorite list");
		 }
	}
	//Tc_InsightGeneral_28
	@Given("^Click on View option$")
	public void click_on_View_option() throws Throwable {
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("View_Btn"))).click();
	}

	@Given("^Verify 'Open' option in insight preview$")
	public void verify_Open_option_in_insight_preview() throws Throwable {
		 String InsightCurrentTab = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Untitled_insight"))).getText();
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("open_icon"))).click();
		 Thread.sleep(4000);
		 ArrayList<String> tabs = new ArrayList<String> (login.driver.getWindowHandles());
			login.driver.switchTo().window(tabs.get(1));
			Thread.sleep(8000);
			String InsightNewTab = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Untitled_insight"))).getText();
		if(InsightCurrentTab.equalsIgnoreCase(InsightNewTab))
		{
			System.out.println("The insight  opened with new browser tab.");
			Thread.sleep(2000);
			login.driver.close();
			login.driver.switchTo().window(tabs.get(0));
		}
		else{
			login.driver.close();
			login.driver.switchTo().window(tabs.get(0));
			Assert.fail("The insight  fail to open in new browser tab.");
		}
		
	}
	//Tc_InsightGeneral_29
	@Given("^Click on Copy button$")
	public void click_on_Copy_button() throws Throwable {
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_Insight"))).click();
		 Thread.sleep(3000);
	}

	@Given("^Verify 'Copy' option in insight preview\\.$")
	public void verify_Copy_option_in_insight_preview() throws Throwable {
	  if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Copy_Insight_Pop_Up"))).size()!=0)
	  {
		  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("fav_insight_close"))).click();
		  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close"))).click();
		  System.out.println("Copy insight pop up is displayed");
	  }
	  else
	  {
		  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("fav_insight_close"))).click();
		  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close"))).click();
		  Assert.fail("Copy insight pop up is not displayed");
	  }
	}
	//Tc_InsightGeneral_30
	@Given("^Create insight$")
	public void create_insight() throws Throwable {
		click_on_File_menu();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("new_insight"))).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Insight_Text_Enter"))).clear();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Insight_Text_Enter"))).sendKeys("TEST");
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("create_insight"))).click();
		Thread.sleep(3000);
		
	}
	
	@Given("^Verify default insight title while coping insight\\.$")
	public void verify_default_insight_title_while_coping_insight() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_Insight_Button"))).click();
	    Thread.sleep(6000);
	    String strValidate="TEST_copy";
	    String copied_insight = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Untitled_insight"))).getText();
		if(copied_insight.contains(strValidate))
		{
			System.out.println(copied_insight);
			
		}
		else
		{
		
			Assert.fail("Insight not copied");
		}

	}	
	//Tc_InsightGeneral_31
	@Given("^Verify 'Cancel' button for 'Copy the insight' popup\\.$")
	public void verify_Cancel_button_for_Copy_the_insight_popup() throws Throwable {
	    if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Copy_Insight_Pop_Up"))).size()!=0)
	    {
	    	if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Copy_Cancel"))).size()!=0)
	    	{
	    		   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Copy_Cancel"))).click();
	    		  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close"))).click();
	    		System.out.println("The copy pop up will be closed");
	    	}
	    	else{
	    		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Copy_Cancel"))).click();
	    		  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close"))).click();
	    		Assert.fail("The copy pop up will not be closed");
	    	}
	    }
	}
	//Tc_InsightGeneral_32
	@Given("^Verify 'Download' option in insight preview without visual$")
	public void verify_Download_option_in_insight_preview_without_visual() throws Throwable {
		
		
		  if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Download_option_Disabled"))).size()!=0)
		  {
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close"))).click();
			  System.out.println("Download option is disabled");
		  }else
		  {
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close"))).click();
			  Assert.fail("Download option is not disabled");
		  }
	}
	//Tc_InsightGeneral_33
	@Given("^Create Visual$")
	public void create_Visual() throws Throwable {
	   Footnotes f=new Footnotes();
	   f.goto_Db_Search_tab();
	   f.expand_the_database();
	   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_seriestoadd"))).click();
	   Thread.sleep(2000);
	   action.sendKeys("c").perform();
	}

	@Given("^Click on View$")
	public void click_on_View() throws Throwable {
		click_on_File_menu();
		click_on_View_option();
		Thread.sleep(2000);
	}

	@Given("^Click on Download$")
	public void click_on_Download() throws Throwable {
		   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Download"))).click();
		  
	}
	@Given("^Verify 'Download' option in insight preview with visual$")
	public void verify_Download_option_in_insight_preview_with_visual() throws Throwable {
		 if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Downloadpopup"))).size()!=0)
		  {
			  System.out.println("Download pop up is shown");
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
			  Thread.sleep(2000);
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close"))).click();
			  Thread.sleep(2000);
			  WebElement visual = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Visual")));
			  Thread.sleep(2000);
			  action.moveToElement(visual).build().perform();
			  Thread.sleep(2000);
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Delete_Visual"))).click();
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_visual_confirm"))).click();
		  }else
		  {
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
			  Thread.sleep(2000);
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close"))).click();
			  Thread.sleep(2000);
			  Assert.fail("Download pop up is not shown");
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Delete_Visual"))).click();
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_visual_confirm"))).click();
		  }
	}
	//Tc_InsightGeneral_34
	@Given("^Click on Maximize button$")
	public void click_on_Maximize_button() throws Throwable {
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_visual_maximize"))).click();
		 Thread.sleep(3000);
	}

	@Given("^Verify 'Maximize' option in insight preview$")
	public void verify_Maximize_option_in_insight_preview() throws Throwable {
		 if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_visual_minimize"))).size()!=0)
		 {
			  System.out.println("The insight is maximized");
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close"))).click();
		 }
		 else
		 {
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close"))).click();
			 Assert.fail("The insight is maximized");
		 }
	}
	

//Tc_InsightGeneral_35
	@Given("^Verify 'Restore down' option in insight preview\\.$")
	public void verify_Restore_down_option_in_insight_preview() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_visual_minimize"))).click();
		 Thread.sleep(3000);
		 if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_visual_maximize"))).size()!=0)
		 {
			  System.out.println("The insight restored to previous size");
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close"))).click();
		 }
		 else
		 {
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close"))).click();
			 Assert.fail("The insight not restored to previous size");
		 }
	}
	//Tc_InsightGeneral_36
	@Given("^Verify Cancel option for insight preview popup\\.$")
	public void verify_Cancel_option_for_insight_preview_popup() throws Throwable {
		//Tc_InsightGeneral_41
		if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Preview"))).size()!=0)
		 {
			if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Preview"))).size()!=0)
			 {
				 
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close"))).click();
				  System.out.println("The preview is closed");
			 }
			else{
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close"))).click();
				 Assert.fail("The preview is not closed");
			}
		 }
		
	}
	//Tc_InsightGeneral_37
	@Given("^Click on Related Insights$")
	public void click_on_Related_Insights() throws Throwable {
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Relatedinsights"))).click();
	}

	@Given("^Verify Related Insights in insight preview\\.$")
	public void verify_Related_Insights_in_insight_preview() throws Throwable {
		if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Related_Insight_pane"))).size()!=0)
		 {
			 
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close"))).click();
			  System.out.println("Related insights is shown");
		 }
		else{
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close"))).click();
			 Assert.fail("Related insights is not shown");
		}
	}
	//Tc_InsightGeneral_38
	@Given("^Click on New$")
	public void click_on_New() throws Throwable {
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("new_insight"))).click();
		   Thread.sleep(2000);
	}

	@Given("^Verify New option\\.$")
	public void verify_New_option() throws Throwable {
		if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Create_Insight_popup"))).size()!=0)
		 {
			 
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
			  System.out.println("'Create insight' popup is displayed");
		 }
		else{
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
			 Assert.fail("'Create insight' popup is not displayed");
		}
	}
	//Tc_InsightGeneral_39
	@Given("^Verify auto title for Create insight\\.$")
	public void verify_auto_title_for_Create_insight() throws Throwable {
		String insightTitle = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_InsightTitle"))).getAttribute("value");
		System.out.println(insightTitle);
		if(insightTitle.contains("Insight"))
		{
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
			System.out.println("Autotitle is shown");
		}
		else{
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
			Assert.fail("Autotitle is not  shown");
		}
	}
	//Tc_InsightGeneral_40
	@Given("^Verify 'Create insight' button\\.$")
	public void verify_Create_insight_button() throws Throwable {
		String newInsight = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_InsightTitle"))).getAttribute("value");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("create_insight"))).click();
		Thread.sleep(2000);
	    login.driver.manage().timeouts().implicitlyWait(1200, TimeUnit.SECONDS);
	   String insightTitle = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Insight_Title"))).getText();
	  Assert.assertEquals(newInsight, insightTitle);
	}
	//Tc_InsightGeneral_41
	@Given("^Verify 'Cancel' button for new insight popup\\.$")
	public void verify_Cancel_button_for_new_insight_popup() throws Throwable {
		if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Create_Insight_popup"))).size()!=0)
		 {
			 
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
			  System.out.println("'Create insight' popup is closed");
		 }
		else{
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
			 Assert.fail("'Create insight' popup is not closed");
		}
	}
	//Tc_InsightGeneral_42
	@Given("^Click on Open$")
	public void click_on_Open() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Open_Icon"))).click();
		Thread.sleep(3000);
	}

	@Given("^Verify 'Open' option\\.$")
	public void verify_Open_option() throws Throwable {
		if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Insightexplorer_Win"))).size()!=0)
		 {
			 
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
			  System.out.println("Insight explorer window is open");
		 }
		else{
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
			 Assert.fail("Insight explorer window is not open");
		}
	}
	//Tc_InsightGeneral_43
	@Given("^Click on My insights tab and close$")
	public void click_on_My_insights_tab_and_close() throws Throwable {
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Myinsights"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
		 Thread.sleep(2000);
	}

	@Given("^Verify default tab for open\\.$")
	public void verify_default_tab_for_open() throws Throwable {
		if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_my_insights_selected"))).size()!=0)
		 {
			 
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
			  System.out.println("The last visited tab is open");
		 }
		else{
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
			 Assert.fail("The last visited tab is not open");
		}
	}
	//Tc_InsightGeneral_44
	@Given("^Verify Dismiss button for insight explorer modal popup\\.$")
	public void verify_Dismiss_button_for_insight_explorer_modal_popup() throws Throwable {
		if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Insightexplorer_Win"))).size()!=0)
		 {
			 
			if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).size()!=0)
			 {
				 
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
				  
				  System.out.println("The insight explorer window is closed");
			 }
			else{
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
				
				 Assert.fail("The insight explorer window is not closed");
			}
		}
	}
	//Tc_InsightGeneral_45
	@Given("^Click on Save$")
	public void click_on_Save() throws Throwable {
		Thread.sleep(3000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Save_Changes"))).click();
		 
	}

	@Given("^Verify 'Save' option\\.$")
	public void verify_Save_option() throws Throwable {
		
		if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Save_Message_text"))).size()!=0)
		 {
			 
			 System.out.println("'Changes saved' growl message is displayed.");
		 }
		else{
			 Assert.fail("'Changes saved' growl message is not displayed.");
		}
	}
	//Tc_InsightGeneral_46
	@Given("^Click on Delete$")
	public void click_on_Delete() throws Throwable {
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Delete_Btn"))).click();
		 Thread.sleep(2000);
	}

	@Given("^Verify Delete option\\.$")
	public void verify_Delete_option() throws Throwable {
		if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Delete_insight_popup"))).size()!=0)
		 {
			 
			 System.out.println("The Delete insight confirmation popup is shown");
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
		 }
		else{
			
			 Assert.fail("The Delete insight confirmation popup is not shown");
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
		}
	}
	//Tc_InsightGeneral_47
	@Given("^Verify Popup header for delete\\.$")
	public void verify_Popup_header_for_delete() throws Throwable {
		 String deletePopup = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Delete_insight_popup"))).getText();
		 String delete="Delete insight?";
		 if(deletePopup.equalsIgnoreCase(delete))
		 {
			 
			 System.out.println("The popup header 'Delete Insight?' is shown");
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
		 }
		else{
			
			 Assert.fail("The popup header 'Delete Insight?' is not  shown");
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
		}
	}
	//Tc_InsightGeneral_48
	@Given("^Verify description for delete confirmation popup\\.$")
	public void verify_description_for_delete_confirmation_popup() throws Throwable {
	   String deleteMess = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Delete_conf_mess"))).getAttribute("innerHTML");
	   String deletemessExpected = "Are you sure you want to delete this insight?If this file is shared, collaborators won't access it anymore.    Warning: you cannot undo this action.But if you are the owner of the deleted insight, to recover it within the past 6 months, please contact our help desk team.";
String delMessage = deleteMess.replaceAll("//D", "").replaceAll("\n", "").replaceAll("\\<.*?>","");
if(delMessage.equalsIgnoreCase(deletemessExpected))
{
	 
	 System.out.println("The Description message is shown");
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
}
else{
	
	 Assert.fail("The Description message is not shown");
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
}
	}
	//Tc_InsightGeneral_49
	@Given("^Verify Delete forever button\\.$")
	public void verify_Delete_forever_button() throws Throwable {
		create_insight();
		 String newinsight = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Untitled_insight"))).getText();
		 WebElement file = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("file")));
		 file.click();
		 Thread.sleep(4000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Delete_Btn"))).click();
		 Thread.sleep(3000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Delete_ok"))).click();
		 Thread.sleep(6000);
		 String untitledinsight = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Untitled_insight"))).getText();
		 if(untitledinsight.contains("Untitled insight"))
		 {
			 System.out.println("The insight is deleted.");
		 }
		 else{
			 Assert.fail("The insight is not deleted.");
		 }
	}
	//Tc_InsightGeneral_50
	@Given("^Click on 'Save as'$")
	public void click_on_Save_as() throws Throwable {
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_save_as_btn"))).click();
		 Thread.sleep(3000);
		 if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Copy_Insight_Pop_Up"))).size()!=0)
		 {
			 
			 System.out.println("'Copy the insight' popup is displayed");
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
		 }
		else{
			
			 Assert.fail("'Copy the insight' popup is not displayed");
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
		}
			
	}
	//Tc_InsightGeneral_51
	 @Given("^Click on 'Save as' and Verify default insight title while coping insight$")
	 public void click_on_Save_as_and_Verify_default_insight_title_while_coping_insight() throws Throwable {
		 create_insight();
		 click_on_File_menu();
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_save_as_btn"))).click();
		 Thread.sleep(3000);
		 verify_default_insight_title_while_coping_insight();
	 }
		//Tc_InsightGeneral_52
	 @Given("^Click on Save As$")
	 public void click_on_Save_As() throws Throwable {
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_save_as_btn"))).click();
		 Thread.sleep(3000);
	 }

	 @Given("^Verify 'Cancel/X' button for 'Copy the insight' popup\\.$")
	 public void verify_Cancel_X_button_for_Copy_the_insight_popup() throws Throwable {
		 if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Copy_Insight_Pop_Up"))).size()!=0)
		   {
			   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
			   System.out.println("The pop up is closed");
		   }
		   else
		   {
			   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
			   Assert.fail("Fail to close");
		   }
	 }
	//Tc_InsightGeneral_53
	 @Given("^Click on Add views$")
	 public void click_on_Add_views() throws Throwable {
		  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_addview_btn"))).click();
		  Thread.sleep(2000);
		  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_addview_btn"))).click();
		  Thread.sleep(2000);
	 }

	 @Given("^Click on Refresh$")
	 public void click_on_Refresh() throws Throwable {
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Refresh_btn"))).click();
		 Thread.sleep(3000);
	 }

	 @Given("^Verify Refresh option\\.$")
	 public void verify_Refresh_option() throws Throwable {
		 if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_viewtab_active"))).size()!=0)
		   {
			 WebElement visual = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Visual")));
			 action.contextClick(visual).build().perform();
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_DeleteAllviews"))).click();
			Thread.sleep(2000);
			   System.out.println("The panel is refreshed ");
		   }
		   else
		   {
			   WebElement visual = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Visual")));
				 action.contextClick(visual).build().perform();
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_DeleteAllviews"))).click();
			   Assert.fail("The panel is not refreshed ");
		   }
	 }

	//Tc_InsightGeneral_54

@Given("^Click on Settings$")
public void click_on_Settings() throws Throwable {
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Settings"))).click();
	 Thread.sleep(5000);
}

@Given("^Verify Settings option\\.$")
public void verify_Settings_option() throws Throwable {
	if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_settings_popup"))).size()!=0)
	   {
		   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
		   System.out.println("The settings pop up is shown");
	   }
	   else
	   {
		   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
		   Assert.fail("The settings pop up is shown");
	   }
}
//Tc_InsightGeneral_55
@Given("^Verify the available tabs in the settings popup\\.$")
public void verify_the_available_tabs_in_the_settings_popup() throws Throwable {
	// String text = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_setting_tabs"))).getText();
	String text1="General";
	String text2="Information";
	String text3="Permissions";
	String text4="Subscription";
	String text5="Keywords";
	String[] expected={"General","Information","Permissions","Subscription","Keywords"};
	
	   List<WebElement> allOptions = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_setting_tabs")));
	   for (int i = 0; i<expected.length; i++) {
		   try{
			   
	
		    String optionValue = allOptions.get(i).getText();
		  if(optionValue.contains(text1))
		    {
		    	  System.out.println("General tab is shown");
		    }
		    else{
		    	Assert.fail("General tab is not shown");
		    }
		    if(optionValue.contains(text2))
		    {
		    	  System.out.println("Information tab is shown");
		    }
		    else{
		    	Assert.fail("Information tab is not  shown");
		    }
		    if(optionValue.contains(text3))
		    {
		    	  System.out.println("Permissions tab is  shown");
		    }
		    else{
		    	Assert.fail("Permissions tab is not shown");
		    }
		    if(optionValue.contains(text4))
		    {
		    	  System.out.println("Subscription tab is  shown");
		    }
		    else{
		    	Assert.fail("Subscription tab is not shown");
		    }
		    if(optionValue.contains(text5))
		    {
		    	  System.out.println("Keywords tab is  shown");
		    }
		    else{
		    	Assert.fail("Keywords tab is not shown");
		    }
		    close_insight();
		   }
		   catch(Exception indexoutofBoundException)
		   {
			   
		   }
	  }
 }
//Tc_InsightGeneral_56
@Given("^Click on Settings and Verify the available tabs in the settings popup$")
public void click_on_Settings_and_Verify_the_available_tabs_in_the_settings_popup() throws Throwable {
	create_insight();
	String Text = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Untitled_insight"))).getText();
	System.out.println(Text);
	click_on_File_menu();
	click_on_Settings();
	String settingsText = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_settings_iptext"))).getAttribute("value");
	System.out.println(settingsText);
	Thread.sleep(3000);
	if(Text.equalsIgnoreCase(settingsText))
	{
		System.out.println("Current insight name is displayed");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
	}
	else{
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
		Assert.fail("Current insight name is not displayed");
	}
}
//Tc_InsightGeneral_57
@Given("^Update the name under Settings and Verify$")
public void update_the_name_under_Settings_and_Verify() throws Throwable {
	create_insight();
	
	
	click_on_File_menu();
	click_on_Settings();
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_settings_iptext"))).sendKeys("TESTING");
	String settingsText = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_settings_iptext"))).getAttribute("value");
	System.out.println(settingsText);
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tag_save"))).click();
	Thread.sleep(3000);
	String Text = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Untitled_insight"))).getText();
	if(Text.equalsIgnoreCase(settingsText))
	{
		System.out.println("Current insight name is displayed");
		
	}
	else{
		
		Assert.fail("Current insight name is not displayed");
	}
}
//Tc_InsightGeneral_58
@Given("^Verify insight URL after insight title change\\.$")
public void verify_insight_URL_after_insight_title_change() throws Throwable {
	String insightId = "TC" + new Random().nextInt(1000);
	WebElement element = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_settingurl")));
	action.moveToElement(element).build().perform();
	Thread.sleep(2000);
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_urlediticon"))).click();
	
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_URL_edit"))).sendKeys(insightId);
	Thread.sleep(2000);
	String inURL = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_settingurl"))).getText();
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tag_save"))).click();
	String url = login.driver.getCurrentUrl();
	if(url.contains(inURL))
	{
		System.out.println("The insight URL is updated");
	}
	else{
		Assert.fail("The insight URL is not updated");
	}
}
//Tc_InsightGeneral_59
@Given("^Verify the alert message while changing insight URL\\.$")
public void verify_the_alert_message_while_changing_insight_URL() throws Throwable {
	String insightId = "RG" + new Random().nextInt(1000);
	WebElement element = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_settingurl")));
	action.moveToElement(element).build().perform();
	Thread.sleep(2000);
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_urlediticon"))).click();
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_URL_edit"))).sendKeys(insightId);
	Thread.sleep(3000);
	String textSetting = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Urledit_mess"))).getText();
	String text="Changing the url of the insight will break out the old url.";
	if(textSetting.matches(text))
	{
		System.out.println("The alert message displayed");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
	}
	else{
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
		Assert.fail("The alert message displayed");
	}
}
//Tc_InsightGeneral_60
@Given("^Verify Change insight URL with existing insight name$")
public void verify_Change_insight_URL_with_existing_insight_name() throws Throwable {
	String insightId = "S" + new Random().nextInt(1000);
	WebElement element = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_settingurl")));
	action.moveToElement(element).build().perform();
	Thread.sleep(2000);
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_urlediticon"))).click();
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_URL_edit"))).sendKeys(insightId);
	//String gettext = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Urledit_mess"))).getText();
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tag_save"))).click();
	click_on_File_menu();
	click_on_Settings();
	WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_settingurl")));
	action.moveToElement(ele).build().perform();
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_urlediticon"))).click();
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_URL_edit"))).sendKeys("S");
	Thread.sleep(3000);
	String textSetting = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_urlmess_invalid"))).getText();
	String text="Insight with this url already exists.";
	if(textSetting.matches(text))
	{
		System.out.println("Insight with this url already exists.message is displayed");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
	}
	else{
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
		Assert.fail("Fail to display message");
	}
}
//TC_InsightGeneral_61
@Given("^Validate the copied link\\.$")
public void validate_the_copied_link() throws Throwable {
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Insight_Copy_Link"))).click();
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
	String InsightCuurentTab=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Untitled_insight"))).getText();
	Robot robot = new Robot();                          
	robot.keyPress(KeyEvent.VK_CONTROL); 
	robot.keyPress(KeyEvent.VK_T); 
	robot.keyPress(KeyEvent.VK_CONTROL); 
	robot.keyPress(KeyEvent.VK_V); 
	robot.keyPress(KeyEvent.VK_CONTROL); 
	robot.keyPress(KeyEvent.VK_ENTER); 
	//Switch focus to new tab
	ArrayList<String> tabs = new ArrayList<String> (login.driver.getWindowHandles());
	login.driver.switchTo().window(tabs.get(1));
	
	

	//Launch URL in the new tab
	//login.driver.get(copyURL);
	Thread.sleep(8000);
	String InsightNewTab=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Untitled_insight"))).getText();
	Thread.sleep(7000);
	if(InsightCuurentTab.equalsIgnoreCase(InsightNewTab))
	{
		System.out.println("Insight loaded");
		login.driver.close();
		Thread.sleep(3000);
		login.driver.switchTo().window(tabs.get(0));
	}
	else{
		Assert.fail("Fail to load insight");
	}
}
//TC_InsightGeneral_62
@Given("^Verify Category field\\.$")
public void verify_Category_field() throws Throwable {
	try{
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Cat_drpdn"))).click();
		Thread.sleep(4000);
		String[] file_list={"None","Hot Topics","World Economy","Emerging Markets","Thematic Analysis","Markets","New Datasets"};
		  List<WebElement> elements = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Category_List")));
		  for (int i = 0; i < file_list.length; i++) {
			    String optionValue = elements.get(i).getText();
			    System.out.println(optionValue);
			    if (optionValue.equals(file_list[i])) {
			    	 
			        System.out.println("passed on: " + optionValue);
//			        Thread.sleep(4000);
 
//			      
			    } else {
			    	
			    }
		  }
	}
		  
			finally
			{
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Cattopic"))).click();
				close_insight();
			}
	
	}
	
	  

//TC_InsightGeneral_63
@Given("^Verify applied category for the insight\\.$")
public void verify_applied_category_for_the_insight() throws Throwable {
	
	create_insight();
	String Text = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Untitled_insight"))).getText();
	click_on_File_menu();
	click_on_Settings();
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Cat_drpdn"))).click();
	Thread.sleep(2000);
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Cattopic"))).click();
	 Thread.sleep(2000);
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tag_save"))).click();
	open_insight();
	
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Allcat"))).click();
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Cattopic"))).click();
	 Thread.sleep(3000);
	  String inname = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Fav_Insight_Title"))).getText();
	  Thread.sleep(3000);
	  if(Text.equalsIgnoreCase(inname))
	  {
		  System.out.println("Insight name matched");
		  delete_insight();
		  
	  }
	  else{
		  close_insight();
		  Assert.fail("Insight name not  matched");
	  }
	 
}
//TC_InsightGeneral_64
@Given("^Verify added description under insight explorer\\.$")
public void verify_added_description_under_insight_explorer() throws Throwable {
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_add_desc"))).sendKeys("TestData");
	String description = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_add_desc"))).getAttribute("value");
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tag_save"))).click();
	open_insight();
	 WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Fav_Insight_Title")));
	 action.moveToElement(ele).build().perform();
	 Thread.sleep(2000);
	 String insightText = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_insight_desc_txt"))).getAttribute("title");
	 Thread.sleep(4000);
	 if(description.equalsIgnoreCase(insightText))
	 {
		 System.out.println("The descripton is visible to user.");
		 delete_insight();
	 }
	 else{
		 close_insight();
		 Assert.fail("The descripton is not visible to user.");
	 }
}
//TC_InsightGeneral_65
@Given("^Verify Save and Apply buttons disabled$")
public void verify_Save_and_Apply_buttons_disabled() throws Throwable {
	List<WebElement> apply_disable = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_apply_disable")));
	List<WebElement> save_disable = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_save_disable")));
	if(apply_disable.size()!=0 && save_disable.size()!=0)
	{
		close_insight();
		System.out.println("Save and Apply are disabled");
	}
	else{
		close_insight();
		Assert.fail("Save and Apply are not disabled");
	}
}

@Given("^Verify Save and Apply buttons enabled$")
public void verify_Save_and_Apply_buttons_enabled() throws Throwable {
	click_on_File_menu();
	click_on_Settings();
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_add_desc"))).sendKeys("TestData");
	List<WebElement> apply_enable = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_apply_enable")));
	List<WebElement> save_enable = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_save_enable")));
	if(apply_enable.size()!=0 && save_enable.size()!=0)
	{
		System.out.println("Save and Apply are enabled");
		close_insight();
	}
	else{
		close_insight();
		Assert.fail("Save and Apply are  disabled");
	}
}
//TC_InsightGeneral_66
@Given("^Verify Apply button\\.$")
public void verify_Apply_button() throws Throwable {
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_add_desc"))).sendKeys("TestData");
	
	if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Settings"))).size()!=0)
	{
		System.out.println("Settings pop up not closed");
		close_insight();
	}
	else{
		close_insight();
		Assert.fail("Settings pop up  closed");
	}
}
//TC_InsightGeneral_67
@Given("^Enter Description and Click Apply button$")
public void enter_Description_and_Click_Apply_button() throws Throwable {
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_add_desc"))).sendKeys("TestData");
}

@Given("^Verify confirmation message after click on Apply\\.$")
public void verify_confirmation_message_after_click_on_Apply() throws Throwable {
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_apply_enable"))).click();
	Thread.sleep(2000);
	if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Apply_mess"))).size()!=0)
	{
		System.out.println("Changes are saved message is displayed ");
		close_insight();
	}
	else{
		close_insight();
		Assert.fail("Changes are saved message is not displayed");
	}
}
//TC_InsightGeneral_68
@Given("^Click on Info Tab$")
public void click_on_Info_Tab() throws Throwable {
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Info_tab"))).click();
	Thread.sleep(3000);
}

@Given("^Verify Apply and Save buttons when redirect to next tabs with changes\\.$")
public void verify_Apply_and_Save_buttons_when_redirect_to_next_tabs_with_changes() throws Throwable {
	verify_Save_and_Apply_buttons_disabled();
}
//TC_InsightGeneral_69
@Given("^Verify Cancel/X buttons\\.$")
public void verify_Cancel_X_buttons() throws Throwable {
	if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_settings_popup"))).size()!=0)
	{
		if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).size()!=0)
		{
			close_insight();
		System.out.println("pop up is closed ");
		}
		else{
			close_insight();
			Assert.fail("Pop up is not closed");
		}
		
	}
	
}
//TC_InsightGeneral_70
@Given("^Verify Created field under Information tab\\.$")
public void verify_Created_field_under_Information_tab() throws Throwable {
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("dropdown_btn"))).click();
	String userdetail = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_User_Account"))).getText();
	create_new_insight();
	click_on_File_menu();
	click_on_Settings();
	click_on_Info_Tab();
	String infotabdetail = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Info_Detail"))).getText();
	System.out.println(infotabdetail);
	System.out.println(userdetail);
	if(infotabdetail.contains(userdetail))
	{
		System.out.println("USername is displayed");
		close_insight();
	}
	else{
		close_insight();
		Assert.fail("USername is not displayed");
	}
}
//TC_InsightGeneral_71
@Given("^Verify Last editor field\\.$")
public void verify_Last_editor_field() throws Throwable {
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("dropdown_btn"))).click();
	String userdetail = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_User_Account"))).getText();
	create_new_insight();
	click_on_File_menu();
	click_on_Settings();
	click_on_Info_Tab();
	String infotabdetail = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Lasteditor_Detail"))).getText();
	if(infotabdetail.contains(userdetail))
	{
		System.out.println("USername is displayed");
		close_insight();
	}
	else{
		close_insight();
		Assert.fail("USername is not displayed");
	}
}
//TC_InsightGeneral_72

@Given("^Check sharing settings field\\.$")
public void check_sharing_settings_field() throws Throwable {
	click_on_Info_Tab();
	String SharedDetail = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_shared_setting"))).getText();
	String shared="not shared";
			if(SharedDetail.equalsIgnoreCase(shared))
			{
				System.out.println("The insight is not shared");
			}
			else
			{
				Assert.fail("The insight is not shared");
			}
}

@Given("^Share insight and Check the sharing settings field$")
public void share_insight_and_Check_the_sharing_settings_field() throws Throwable {
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_shared_change"))).click();
	Thread.sleep(3000);
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_invite_people"))).click();
	Thread.sleep(3000);
	WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_choose_people")));
	Thread.sleep(2000);
	action.moveToElement(ele).build().perform();
	Thread.sleep(2000);
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_choose_people"))).click();
	Thread.sleep(3000);
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tag_save"))).click();
	Thread.sleep(3000);
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_save_enable"))).click();
	Thread.sleep(3000);
	String SharedDetail = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_shared_setting"))).getText();
	String shared="shared";
			if(SharedDetail.equalsIgnoreCase(shared))
			{
				System.out.println("The insight is  shared");
				close_insight();
			}
			else
			{
				close_insight();
				Assert.fail("The insight is not shared");
			}
}
//TC_InsightGeneral_73
@Given("^Verify 'Change' option for sharing settings\\.$")
public void verify_Change_option_for_sharing_settings() throws Throwable {

	click_on_Info_Tab();
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_shared_change"))).click();
	Thread.sleep(3000);
	if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("SHARE_POPUP"))).size()!=0)
	{
		System.out.println("The share popup  is displayed");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_sharepopup_cancel"))).click();
		close_insight();
	}
	else{
		close_insight();
		Assert.fail("The share popup  is not displayed");
	}
	
	
}
//TC_InsightGeneral_74
@Given("^Add Views$")
public void add_Views() throws Throwable {
	create_new_insight();
	Thread.sleep(4000);
	expander();
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_add_views"))).click();
	delete_all_views();
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_add_views"))).click();
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_add_views"))).click();
}

@Given("^Verify number of the view/s for the insight\\.$")
public void verify_number_of_the_view_s_for_the_insight() throws Throwable {
	
	int viewcount = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_View_count"))).size();
	System.out.println(viewcount);
	click_on_File_menu();
	click_on_Settings();
	click_on_Info_Tab();
	 String view=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Setting_no_views"))).getText();
	 int viewcnt = Integer.parseInt(view);
	 System.out.println(viewcnt);
	 if(viewcount==viewcnt){
		 System.out.println("The view count matched");
		 close_insight();
		 delete_all_views();
	 }
	 else{
		 close_insight();
		 Assert.fail("Fail");
	 }
}
//TC_InsightGeneral_75
@Given("^Add series to myseries$")
public void add_series_to_myseries() throws Throwable {
	create_insight();
	expander();
   add_Series();
}

@Given("^Verify Data series under info tab in settings$")
public void verify_Data_series_under_info_tab_in_settings() throws Throwable {
	int datacount = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_myseries_size"))).size();
	System.out.println(datacount);
	click_on_File_menu();
	click_on_Settings();
	click_on_Info_Tab();
	 String data=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_data_count"))).getText();
	 int datacnt = Integer.parseInt(data);
	 System.out.println(datacnt);
	 if(datacount==datacnt){
		 System.out.println("The number of data series matched");
		 close_insight();
		delete_series();
	 }
	 else{
		 close_insight();
			delete_series();
		 Assert.fail("Fail");
	 }
}
//TC_InsightGeneral_76
@Given("^Click on Permissions tab$")
public void click_on_Permissions_tab() throws Throwable {
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_permission_tab"))).click();
}

@Given("^Verify Permission tabs description\\.$")
public void verify_Permission_tabs_description() throws Throwable {
	if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Permission_title"))).size()!=0)
	{
		System.out.println("The description  is displayed");
		
		close_insight();
	}
	else{
		close_insight();
		Assert.fail("The description is not displayed");
	}
}
//TC_InsightGeneral_77
@Given("^Verify default selection for permission tab\\.$")
public void verify_default_selection_for_permission_tab() throws Throwable {
	if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_permission_option"))).size()!=0)
	{
		System.out.println("PASS");
		
		close_insight();
	}
	else{
		close_insight();
		Assert.fail("FAIL");
	}
}
//TC_InsightGeneral_78
@Given("^Click on Subscription tab$")
public void click_on_Subscription_tab() throws Throwable {
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_subscription_tab"))).click();
}

@Given("^Verify Select service code field\\.$")
public void verify_Select_service_code_field() throws Throwable {
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_select_servicecode_drpdwn"))).click();
	Thread.sleep(2000);
	if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_servicedrpdwn"))).size()!=0)
	{
		System.out.println("PASS");
		close_insight();
	}
	else{
		close_insight();
		Assert.fail("FAIL");
	}
}
//TC_InsightGeneral_79
@Given("^Verify search for service code\\.$")
public void verify_search_for_service_code() throws Throwable {
   String servicecode="CEIC Premium China";
   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_select_servicecode_drpdwn"))).sendKeys(servicecode);
   Thread.sleep(3000);
   String code = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_service_code"))).getText();
   if(code.equalsIgnoreCase(code))
   {
	   System.out.println("PASS");
	   close_insight();
   }
   else{
	   close_insight();
	   Assert.fail("FAIL");
   }
}
//TC_InsightGeneral_80
@Given("^Verify message for invalid search\\.$")
public void verify_message_for_invalid_search() throws Throwable {
	  String servicecode="12";
	  String message="Empty results";
	  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_select_servicecode_drpdwn"))).sendKeys(servicecode);
	   Thread.sleep(3000);
	   String code = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_empty_result"))).getText();
	   if(message.equalsIgnoreCase(code))
	   {
		   System.out.println("PASS");
		   close_insight();
	   }
	   else{
		   close_insight();
		   Assert.fail("FAIL");
	   }
}
//TC_InsightGeneral_81
@Given("^Verify Subscription tabs description\\.$")
public void verify_Subscription_tabs_description() throws Throwable {
	  String message="Only users with all specified subscriptions are allowed to view this insight";
	  String code = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_subs_mess"))).getText();
	  if(message.equalsIgnoreCase(code))
	   {
		   System.out.println("PASS");
		   close_insight();
	   }
	   else{
		   close_insight();
		   Assert.fail("FAIL");
	   }
}
//TC_InsightGeneral_82
@Given("^Verify remove icon for service code field\\.$")
public void verify_remove_icon_for_service_code_field() throws Throwable {
	   String servicecode="CEIC Premium China";
	   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_select_servicecode_drpdwn"))).sendKeys(servicecode);
	   Thread.sleep(3000);
	   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_select_servicecode_drpdwn"))).clear();
	   if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_servicedrpdwn"))).size()!=0)
		{
			System.out.println("PASS");
			
			close_insight();
		}
		else{
			close_insight();
			Assert.fail("FAIL");
		}
}
//TC_InsightGeneral_83
@Given("^Verify service code selection\\.$")
public void verify_service_code_selection() throws Throwable {
	 String servicecode="CEIC";
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_select_servicecode_drpdwn"))).sendKeys(servicecode);
	 Thread.sleep(3000);
	 WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_select_servicecode")));
	 action.moveToElement(ele).build().perform();
	 Thread.sleep(3000);
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_select_servicecode"))).click();
	 Thread.sleep(3000);
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tag_save"))).click();
	Thread.sleep(3000);
		click_on_File_menu();
		click_on_Settings();
		click_on_Subscription_tab();
		
	 if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_servicecode_display"))).size()!=0)
		{
			System.out.println("PASS");
			
			close_insight();
		}
		else{
			close_insight();
			Assert.fail("FAIL");
		}
}
//TC_InsightGeneral_84
@Given("^Verify remove icon for selected service code\\.$")
public void verify_remove_icon_for_selected_service_code() throws Throwable {
	 String servicecode="CEIC";
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_select_servicecode_drpdwn"))).sendKeys(servicecode);
	 Thread.sleep(3000);
	 WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_select_servicecode")));
	 action.moveToElement(ele).build().perform();
	 Thread.sleep(3000);
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_select_servicecode"))).click();
	 Thread.sleep(3000);
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tag_save"))).click();
	Thread.sleep(3000);
		click_on_File_menu();
		click_on_Settings();
		click_on_Subscription_tab();
		 if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_servicecode_display"))).size()!=0)
			{
			 if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_servicecode_display"))).size()!=0)
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_servicecode_delete"))).click();
			 Thread.sleep(2000);
			 System.out.println("PASS");
				
				close_insight();
			}
			else{
				close_insight();
				Assert.fail("FAIL");
			}
}
//TC_InsightGeneral_85
@Given("^Verify product code field\\.$")
public void verify_product_code_field() throws Throwable {
	 String servicecode="CEIC";
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_select_servicecode_drpdwn"))).sendKeys(servicecode);
	 Thread.sleep(3000);
	 WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Productcode")));
	 action.moveToElement(ele).build().perform();
	 Thread.sleep(3000);
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Productcode"))).click();
	 Thread.sleep(3000);
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Pcode"))).click();
	 Thread.sleep(2000);
	 if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_prodcode_drpdown"))).size()!=0)
		{
			System.out.println("PASS");
			close_insight();
		}
		else{
			close_insight();
			Assert.fail("FAIL");
		}
}
//TC_InsightGeneral_86
@Given("^Verify default selection for product code field\\.$")
public void verify_default_selection_for_product_code_field() throws Throwable {
	 String servicecode="CEIC";
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_select_servicecode_drpdwn"))).sendKeys(servicecode);
	 Thread.sleep(3000);
	 WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Productcode")));
	 action.moveToElement(ele).build().perform();
	 Thread.sleep(3000);
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Productcode"))).click();
	 Thread.sleep(3000);
	 String Pcode="All product codes";
	 String Productcode=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Pcode"))).getText();
	 if(Pcode.equalsIgnoreCase(Productcode)){
		 System.out.println("PASS");
		 close_insight();
	 }
	 else{
			close_insight();
			Assert.fail("FAIL");
		}
}
//TC_InsightGeneral_87
@Given("^Verify remove icon for selected product codes\\.$")
public void verify_remove_icon_for_selected_product_codes() throws Throwable {
	 String servicecode="CEIC";
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_select_servicecode_drpdwn"))).sendKeys(servicecode);
	 Thread.sleep(3000);
	 WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Productcode")));
	 action.moveToElement(ele).build().perform();
	 Thread.sleep(3000);
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Productcode"))).click();
	 Thread.sleep(3000);
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Pcode"))).click();
	 Thread.sleep(3000);
//	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Pcode_search"))).sendKeys("ch");
//	 Thread.sleep(5000);
//	 WebElement chinapcode = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_chinadb")));
//	 Thread.sleep(3000);
//	 action.moveToElement(chinapcode).build().perform();
//	 Thread.sleep(3000);
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_chinadb"))).click();
	 Thread.sleep(2000);
	 if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_remove_pcode"))).size()!=0)
		{
		 
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_remove_pcode"))).click();
		 Thread.sleep(2000);
			System.out.println("PASS");
			close_insight();
		}
		else{
			close_insight();
			Assert.fail("FAIL");
		}
}
//TC_InsightGeneral_88
@Given("^Click on Keywords tab$")
public void click_on_Keywords_tab() throws Throwable {
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Keywordstab"))).click();
}

@Given("^Verify keywords for the insights\\.$")
public void verify_keywords_for_the_insights() throws Throwable {
	 String keytext="CEIC";
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Keyword_desc"))).sendKeys(keytext);
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Keyword_desc"))).sendKeys(Keys.ENTER);
	 close_insight();
	click_on_File_menu();
	 click_on_Settings();
	 click_on_Keywords_tab();
	 String Keyword=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_keyword_text"))).getText();
	 Thread.sleep(3000);
	 System.out.println(Keyword);
	 if(Keyword.contains(keytext))
	 {
		 System.out.println("PASS");
			close_insight(); 
	 }
	 else{
		 close_insight();
			Assert.fail("FAIL");
	 }
		
}
//TC_InsightGeneral_89
@Given("^Add Keywords$")
public void add_Keywords() throws Throwable {
	 String keytext="CEIC DATA";
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Keyword_desc"))).sendKeys(keytext);
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Keyword_desc"))).sendKeys(Keys.ENTER);
	 close_insight();
}
@Given("^Verify the insight for added keywords in insight explorer\\.$")
public void verify_the_insight_for_added_keywords_in_insight_explorer() throws Throwable {
	 String InsightTitle=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Insight_Title"))).getText();
	 open_insight();
	 Thread.sleep(4000);
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_insight_search"))).sendKeys("CEIC DATA");
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_insight_search"))).sendKeys(Keys.ENTER);
	 Thread.sleep(5000);
	 String Title=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Fav_Insight_Title"))).getText();
	 if(InsightTitle.equalsIgnoreCase(Title))
	 {
		 System.out.println("PASS");
		 delete_insight();

		 
	 }
	 else{
		 close_insight();
		 Assert.fail("FAIL");
	 }
	
}
//TC_InsightGeneral_90
@Given("^Add Multiple Keywords and Verify$")
public void add_Multiple_Keywords_and_verify() throws Throwable {
	String S1="CEICDATA";
	String S2="ISIMARKETS";
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Keyword_desc"))).sendKeys(S1);
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Keyword_desc"))).sendKeys(Keys.ENTER);
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Keyword_desc"))).sendKeys(S2);
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Keyword_desc"))).sendKeys(Keys.ENTER);
	 close_insight();
	 click_on_File_menu();
	 click_on_Settings();
	 click_on_Keywords_tab();
	 String Keyword=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_allkeywords"))).getText();
	 Thread.sleep(3000);
	 System.out.println(Keyword);
	 if(Keyword.contains(S1))
	 {
		 if(Keyword.contains(S2))
		 {
		 System.out.println("PASS");
			close_insight(); 
		 }
	 }
	 else{
		 close_insight();
			Assert.fail("FAIL");
	 }
	 
}
//TC_InsightGeneral_91
@Given("^Remove keywords and Verify$")
public void remove_keywords() throws Throwable {
	if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_remove_keyword"))).size()!=0){
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_remove_keyword"))).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_remove_keyword"))).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tag_save"))).click();
		Thread.sleep(3000);

	}
	else{
		close_insight();
		Assert.fail("FAIL");
	}
		
}
//TC_InsightGeneral_92
@Given("^Click on Protect$")
public void click_on_Protect() throws Throwable {
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Protect"))).click();
}

@Given("^Verify Protect option\\.$")
public void verify_Protect_option() throws Throwable {
	 if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_permission_tab_open"))).size()!=0)
		{
		 	System.out.println("PASS");
			close_insight();
		}
		else{
			close_insight();
			Assert.fail("FAIL");
		}
}
//TC_InsightGeneral_93
@Given("^Verify Download option for new insight\\.$")
public void verify_Download_option_for_new_insight() throws Throwable {
	 if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Download_disabled"))).size()!=0)
		{
		 	System.out.println("PASS");
			
		}
		else{
			
			Assert.fail("FAIL");
		}
}
//TC_InsightGeneral_94
@Given("^Add series to my series panel$")
public void add_series_to_my_series_panel() throws Throwable {
	expander();
	Thread.sleep(2000);
	add_Series();
}

@Given("^Verify download option when series selected in search panel\\.$")
public void verify_download_option_when_series_selected_in_search_panel() throws Throwable {
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Downlaod"))).click();
	 Thread.sleep(5000);
	 if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Downloadpopup"))).size()!=0)
		{
		 	System.out.println("PASS");
		 	close_insight();
			
		}
		else{
			close_insight();
			Assert.fail("FAIL");
		}
}
//TC_InsightGeneral_95
@Given("^Click on Insights on menu header\\.$")
public void click_on_Insights_on_menu_header() throws Throwable {
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("insights"))).click();
}

@Given("^Verify \"([^\"]*)\" dropdown is shown$")
public void verify_dropdown_is_shown(String arg1) throws Throwable {
	 Thread.sleep(2000);
	 if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("insights_drpdwn"))).size()!=0)
		{
		 	System.out.println("PASS"); 				
		}
		else{
			Assert.fail("FAIL");
		}
}
//TC_InsightGeneral_96
@Given("^Click on Favorites$")
public void click_on_Favorites() throws Throwable {
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("favorites"))).click();
	 Thread.sleep(4000);
}

@Given("^Verify 'Favorite' on Insight menu\\.$")
public void verify_Favorite_on_Insight_menu() throws Throwable {
	Thread.sleep(5000);
	 if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_my_insights_selected"))).size()!=0)
		{
		 	System.out.println("PASS"); 
		 	close_insight();
		}
		else{
			close_insight();
			Assert.fail("FAIL");
		}
}
//TC_InsightGeneral_97
@Given("^Click on My Insights$")
public void click_on_My_Insights() throws Throwable {
   open_insight();
}

@Given("^Verify Insight explorer pop up is shown$")
public void verify_Insight_explorer_pop_up_is_shown() throws Throwable {
	 if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Insightexplorer_Win"))).size()!=0)
		{
		 	System.out.println("PASS"); 
		 	close_insight();
		}
		else{
			close_insight();
			Assert.fail("FAIL");
		}
}
//TC_InsightGeneral_98
@Given("^Click on Analytics$")
public void click_on_Analytics() throws Throwable {
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("insights"))).click();
	 Thread.sleep(2000);
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Analytictab"))).click();
	 Thread.sleep(4000);
}

@Given("^Verify  CEIC Gallery tab is Open$")
public void verify_CEIC_Gallery_tab_is_Open() throws Throwable {
	String SharedTitle="Filter CEIC Gallery by category";
	String shared = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_ceicGal_text"))).getAttribute("title");
	if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_ceic_gallery"))).size()!=0)
		{
		 if(shared.equalsIgnoreCase(SharedTitle)){
			 System.out.println("PASS"); 
			 	close_insight();
		 }
		 else{
				close_insight();
				Assert.fail("FAIL");
			}
		}
}
//TC_InsightGeneral_99
@Given("^Click on Shared insights$")
public void click_on_Shared_insights() throws Throwable {
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("insights"))).click();
	 Thread.sleep(2000);
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_sharedinsights"))).click();
	 Thread.sleep(4000);
}

@Given("^Verify 'Shared insights' tab is open$")
public void verify_Shared_insights_tab_is_open() throws Throwable {
	String SharedTitle="Insights that other users have shared with you";
	String shared = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_my_insights_selected"))).getAttribute("title");
	 if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_my_insights_selected"))).size()!=0)
		{
		 if(shared.equalsIgnoreCase(SharedTitle)){
			 System.out.println("PASS"); 
			 	close_insight();
		 }
		 else{
				close_insight();
				Assert.fail("FAIL");
			}
		}
		
}
//TC_InsightGeneral_100
@Given("^Create a new insight$")
public void create_a_new_insight() throws Throwable {
    Footnotes i=new Footnotes();
    i.create_an_insight();
}
@Given("^Verify Recent insights$")
public void verify_Recent_insights() throws Throwable {
	String insight = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Untitled_insight"))).getText();
    click_ceic_logo();
    Thread.sleep(4000);
    login.driver.findElement(By.xpath(login.LOCATORS.getProperty("insights"))).click();
	 Thread.sleep(2000);
	 String recentinsight = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_recent_insight"))).getText();
	 System.out.println(recentinsight);
	 if(recentinsight.equalsIgnoreCase(insight))
	 {
		 System.out.println("PASS"); 
	}
	 else{
		 Assert.fail("FAIL");
	 }
}
//TC_InsightGeneral_101

@Given("^Verify displayed insights count for Recent insights\\.$")
public void verify_displayed_insights_count_for_Recent_insights() throws Throwable {
	int expected=8;
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("insights"))).click();
	Thread.sleep(2000);
	int size = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_recentinsight_count"))).size();
	if(size==expected)
	{
		System.out.println("PASS");
	}
	else{
		Assert.fail("FAIL");
	}
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_More"))).click();
	Thread.sleep(5000);
	if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Insightexplorer_Win"))).size()!=0)
	 {
		 
		  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
		  System.out.println("Insight explorer window is open");
	 }
	else{
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
		 Assert.fail("Insight explorer window is not open");
	}
}
//TC_InsightGeneral_102
@Given("^Click on recent insight$")
public void click_on_recent_insight() throws Throwable {
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("insights"))).click();
	Thread.sleep(2000);
	 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_recent_insight"))).click();
	 Thread.sleep(4000);
}
@Given("^Verify insight open in preview mode$")
public void verify_insight_open_in_preview_mode() throws Throwable {
	if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_insight_preview"))).size()!=0)
	 {
		 
		  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close"))).click();
		  System.out.println("Insight open in preview mode");
	 }
	else{
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close"))).click();
		 Assert.fail("FAIL");
	}
}
//TC_InsightGeneral_103
@Given("^Verify 'Latest CEIC Insights'$")
public void verify_Latest_CEIC_Insights() throws Throwable {
   
}

}

