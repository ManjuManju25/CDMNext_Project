
package CDMNext.StepDefinations;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Landingpage {
    
	WebElement element;
	private static Boolean logged = false;
	public String MoveCreatefoldernamefirst; 
	public int n; 
	public int resultMyinsight;
	public int result1Analytics;
	public int result2Shared;
	public int Addition_of_three_insight;
	public String CopylinkRightclick;
	public String Text1insearch;
	public String TooltipName;
	public String SeriesIDforSeriesAttribute;
	
	public String Insightmouseovername;
	public String Seriesadded;
	
	public String NewInsightnameForInvalidKeyword;
	//public int Insightcountforfiltersearch;
	
	/*@Given("^User has successful logged in$")
	public void user_has_successful_logged_in() throws Throwable {
		
		if (login.logged_in = false) {
			login.Invoke_browser();
			login.application_login();
		} 
		else if (login.logged_in = true && !Landingpage.logged) {
			login.application_login();
			Landingpage.logged = true;
		} else {
			System.out.println("Already Loggedin...Continue....!!!!");
		}
        
		// login.Invoke_browser();
		// login.application_login();
	}*/
	
	@And("^Successfully Verify the Tabs present in Landing page$")
	public void successfully_Verify_the_Tabs_present_in_Landing_page() throws Throwable {
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("	//div[@class='user-avatar -default -small']")).click();
	
		Thread.sleep(6000);
	
		 login.driver.findElement(By.xpath("//div[@class='account-menu--dropdown dropdown--body']/div/div[3]")).click();
		 Thread.sleep(2500);
		login.driver.findElement(By.xpath("//span[contains(text(),'Insight explorer')]")).click();
		Thread.sleep(6000);
		
		JavascriptExecutor jse = (JavascriptExecutor) login.driver;
		
		
		element = login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[14]/div[1]"));
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
		
		login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[14]/div[1]")).click();
		Thread.sleep(500);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		Thread.sleep(1000);
		
		if(login.driver.findElements(By.xpath("//div[@title='Insights that you have created']")).size() != 0)
		{
		WebElement Favorite_Tab_inLandingPage = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Favorite_Tab_inLandingPage")));
		  Assert.assertEquals(true,Favorite_Tab_inLandingPage.isDisplayed());
		  Thread.sleep(500);
		 WebElement MyInsight_Tab_inLandingPage = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MyInsight_Tab_inLandingPage")));
		  Assert.assertEquals(true,MyInsight_Tab_inLandingPage.isDisplayed());
		  Thread.sleep(500);
		  WebElement Analytics_Tab_inLandingPage = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Analytics_Tab_inLandingPage")));
		  Assert.assertEquals(true,Analytics_Tab_inLandingPage.isDisplayed());
		  Thread.sleep(500);
		  WebElement SharedInsight_Tab_inLandingPage = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SharedInsight_Tab_inLandingPage")));
		  Assert.assertEquals(true,SharedInsight_Tab_inLandingPage.isDisplayed());
		  Thread.sleep(500);
		  WebElement Recent_Tab_inLandingPage = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Recent_Tab_inLandingPage")));
		  Assert.assertEquals(true,Recent_Tab_inLandingPage.isDisplayed());
		  Thread.sleep(500);
		  WebElement All_Tab_inLandingPage = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_Tab_inLandingPage")));
		  Assert.assertEquals(true,All_Tab_inLandingPage.isDisplayed());
		  HTML_Report.strTCResult="PASS";
		  HTML_Report.execRemarks="All Tabs present in Landing page is Verified Successfully!!! ";
		}
		else
		{
			HTML_Report.strTCResult="FAIL";
			  HTML_Report.execRemarks="All Tabs present in Landing page is NOT Verified Successfully!!!";
				  Assert.fail("All Tabs present in Landing page is NOT Verified Successfully!!!"); 
		}
	}
	
	@And("^Select the New insight option in Landing page$")
	public void select_the_New_insight_option_in_Landing_page() throws Throwable {
		
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='insights-create-new']/div")).click();
	}

	@Then("^verify the New insight has been created$")
	public void verify_the_New_insight_has_been_created() throws Throwable {
		Thread.sleep(4500);
		if(login.driver.findElements(By.xpath("//div[@class='page-main-header--buttons']/div[1]")).size() != 0){
			System.out.println("Successfully Verified the New insight Page");
			 HTML_Report.strTCResult="PASS";
			  HTML_Report.execRemarks="New insight has been created Successfully!!! ";
			}else
			{
				 Assert.fail( "New insight has NOT been created Successfully!!!.");
				 HTML_Report.strTCResult="FAIL";
				  HTML_Report.execRemarks="New insight has NOT been created Successfully!!!.";
			     System.out.println("Unable to open New insight Page");
			}
		Thread.sleep(500);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
	}

	@Then("^verify the New insight under My insights tab$")
	public void verify_the_New_insight_under_My_insights_tab() throws Throwable {
		String Text1 =login.driver.findElement(By.xpath("//div[@class='page-main-header--title-field-text text-dots']")).getText();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
		Thread.sleep(2000);
		String Text2 =login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
		Thread.sleep(2000);
		System.out.println( Text1      + ":" + Text2);
		if(Text1.equalsIgnoreCase(Text2))
		{
			System.out.println("New insight under My insights tab is verified Successfully");
			HTML_Report.strTCResult="PASS";
			  HTML_Report.execRemarks="New insight under My insights tab is verified Successfully ";
		}
		else{
			 Assert.fail( "New insight under My insights tab is NOT verified Successfully.");
			 HTML_Report.strTCResult="FAIL";
			  HTML_Report.execRemarks="New insight under My insights tab is NOT verified Successfully.";
		}
		
		
	}
	
	
	
	@And("^Select the New insight option$")
	public void select_the_New_insight_option() throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='insights-create-new']/div")).click();
	}

	@And("^verify the New insight Page$")
	public void verify_the_New_insight_Page() throws Throwable {
		Thread.sleep(4500);
		if(login.driver.findElements(By.xpath("//div[@class='page-main-header--buttons']/div[1]")).size() != 0){
			System.out.println("Successfully Verified the New insight Page");
			}else{
				 Assert.fail( "Unable to open New insight Page,Check the Issue.");
			     System.out.println("Unable to open New insight Page");
			}
		Thread.sleep(500);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		
		
	}
	
	@And("^Select the Shared option in Landing page$")
	public void select_the_Shared_option_in_Landing_page() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Shared Insights')] ")).click();
	
	}
	@Then("^verify the insights under Shared with me tab$")
	public void verify_the_insights_under_Shared_with_me_tab() throws Throwable {
			Thread.sleep(2500);
			login.driver.findElement(By.xpath("//div[@class='user-avatar -default -small']")).click();
			Thread.sleep(2000);
			 String Text1 = login.driver.findElement(By.xpath("//span[@class='account-popup--header-name']")).getText();
			 Thread.sleep(2500);
			 login.driver.findElement(By.xpath("//div[@class='user-avatar -default -small']")).click();
			 Thread.sleep(2500);
			 String Text2 = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[4]/div[1]")).getText();
			 System.out.println( Text1 + ":" + Text2);
			 if (!Text2.equals(Text1))
			 {
				 System.out.println("Insight were verified under Shared with me tab Successfully !!!");
					HTML_Report.strTCResult="PASS";
					  HTML_Report.execRemarks="Insight were verified under Shared with me tab Successfully !!! ";
			 }
			 else
			 {
				 Assert.fail( "Insight were NOT verified Successfully under Shared with me tab!!!");
				 HTML_Report.strTCResult="FAIL";
				  HTML_Report.execRemarks="Insight were NOT verified Successfully under Shared with me tab!!!";
			 }
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MyInsight_Tab_inLandingPage"))).click();
	}
	
	
	
	@Then("^verify the New insight under All tab as \"([^\"]*)\"$")
	public void verify_the_New_insight_under_All_tab_as(String arg1) throws Throwable {
		Thread.sleep(1500);
		login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
		Thread.sleep(2500);
		login.driver.findElement(By.xpath("//div[@title='All insights you have access to']")).click();
		Thread.sleep(5500);
		String AllInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
		
		System.out.println(  AllInsight +":"+ arg1);
		if(AllInsight.equalsIgnoreCase(arg1))
		{
			System.out.println("Recent Insight under All tab has been Verified Successfully");
			HTML_Report.strTCResult="PASS";
			  HTML_Report.execRemarks="Recent Insight under All tab has been Verified Successfully";
		  }else
		  {
			  Assert.fail("Recent Insight under All tab has not been Verified Successfully");  
				 HTML_Report.strTCResult="FAIL";
				  HTML_Report.execRemarks="Recent Insight under All tab has not been Verified Successfully!!!";
		}
	}
	
	@And("^get insight name and add  any five series to my series tab$")
	public void get_insight_name_and_add_any_five_series_to_my_series_tab() throws Throwable {
		Thread.sleep(4500);
		login.driver.findElement(By.xpath("//div[@title='Click to edit the Insight']")).click();
		Thread.sleep(8500);
		login.driver.findElement(By.xpath("//div[@class='page-main-header--title-field']/input")).sendKeys("Insightmouseover");
		
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
		
		for(int i=1;i<=5;i++){
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath("//ul[@class='search-series-list scrollable']/li[" + i + "]/div/a/div[2]")).click();
		}
		Thread.sleep(6000);
		 Robot r = new Robot();
		 r.keyPress(KeyEvent.VK_A);
		 r.keyRelease(KeyEvent.VK_A);
		 Thread.sleep(2000);
		 Insightmouseovername = login.driver.findElement(By.xpath("//div[@class='page-main-header--title-field-text text-dots']")).getText();
	     Seriesadded = login.driver.findElement(By.xpath("//span[@class='series-panel--count']/span[1]/span[1]")).getText();
	     Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
	}

	
	@And("^Mouse over on inisight title in Table mode\\.$")
	public void mouse_over_on_inisight_title_in_Table_mode() throws Throwable {
		
		Thread.sleep(1500);
		login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
		Actions action = new Actions(login.driver);
		WebElement InsightmouseoverinIEpage = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
		action.moveToElement(InsightmouseoverinIEpage).build().perform();
		TooltipName = InsightmouseoverinIEpage.getText();
	}

	@Then("^verify the insight name and number of series$")
	public void verify_the_insight_name_and_number_of_series() throws Throwable {
		Thread.sleep(1500);
		System.out.println( Insightmouseovername  + ":" + TooltipName);
		if(Insightmouseovername.equalsIgnoreCase(TooltipName) )
		{
			System.out.println("Mouse over on inisight title in Table mode is Verified Successfully");
			HTML_Report.strTCResult="PASS";
			  HTML_Report.execRemarks="Mouse over on inisight title in Table mode is Verified Successfully";
		  }else
		  {
			  Assert.fail("Mouse over on inisight title in Table mode is NOT Verified Successfully");  
				 HTML_Report.strTCResult="FAIL";
				  HTML_Report.execRemarks="Mouse over on inisight title in Table mode is NOT Verified Successfully";
		}
	}

	
	
	
	
	
	
	@And("^Select the option search by name$")
	public void select_the_option_search_by_name() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='insights-search-attributes dropdown dropdown__right']/div[1]/span/div")).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='dropdown--body insights-search-attributes--content']/label[2]/span[1]")).click();
	}
	
	
	@Given("^Search with tag name as \"([^\"]*)\"$")
	public void search_with_tag_name_as(String arg1) throws Throwable {
		Thread.sleep(500);
		login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).click();
		Thread.sleep(500);
		login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).clear();
		Thread.sleep(500);
		Text1insearch = arg1;
		login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).sendKeys(arg1);
	}

	
	
	@Given("^Verify the search with tag name as \"([^\"]*)\"$")
	public void verify_the_search_with_tag_name_as(String arg1) throws Throwable {
		Thread.sleep(5500);
		Actions action = new Actions(login.driver);
		WebElement AddTag = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
		action.contextClick(AddTag).build().perform();
		Thread.sleep(500);
		//selecting Add tag option
	
		login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[9]")).click();
		Thread.sleep(1000);
		WebElement AddedTag = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("AddedTag")));
		Assert.assertEquals(true,AddedTag.isDisplayed());
		String Text2 =login.driver.findElement(By.xpath("//span[@class='tagit-label']")).getText();
		System.out.println("Text2- " + Text2);	
		System.out.println( Text1insearch      + ":" + Text2);
		if(Text1insearch.equalsIgnoreCase(Text2))
		{
			System.out.println("Search Functionality is Verified with respect to TAG is done Successfully");
			HTML_Report.strTCResult="PASS";
			  HTML_Report.execRemarks="Search Functionality is Verified with respect to TAG is done Successfully";
		}
		else
		{
			 Assert.fail( "Search Verification Failed with respect to TAG.");
			 HTML_Report.strTCResult="FAIL";
			  HTML_Report.execRemarks="Search Verification Failed with respect to TAG.";
		}
		Thread.sleep(1500);
		login.driver.findElement(By.xpath("//span[@class='text-icon']")).click();
		Thread.sleep(1500);
		login.driver.findElement(By.xpath("//div[@class='sphere-modal-controls']/button[2]")).click();
		Thread.sleep(2500);
		login.driver.findElement(By.xpath("//button[@class='insights-search-filter--reset-icon icon--red-cross']")).click();
	}
	
	
	@And("^Add tags for insight$")
	public void add_tags_for_insight() throws Throwable {
		Thread.sleep(500);
		login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
		Thread.sleep(500);
		//Right click on insight
		Actions action = new Actions(login.driver);
		WebElement AddTag = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
		action.contextClick(AddTag).build().perform();
		Thread.sleep(500);
		//selecting Add tag option
		login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[9]")).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='form-group']")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//input[@class='ui-widget-content ui-autocomplete-input']")).sendKeys("AddedTag");
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='modal-header sphere-modal__header']")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='sphere-modal-controls']/button[2]")).click();
		
	}

	@And("^Select the All tag dropdown$")
	public void select_the_All_tag_dropdown() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='landing-content--filters-panel']/div[2]/div/div/div")).click();
	}
	
	@And("^Added tags should be available in dropdown and should display related insights$")
	public void added_tags_should_be_available_in_dropdown_and_should_display_related_insights() throws Throwable {
		Thread.sleep(4500);
		login.driver.findElement(By.xpath("//span[contains(text(),'AddedTag')]")).click();
		String Text1 =login.driver.findElement(By.xpath("//span[contains(text(),'AddedTag')]")).getText();
		System.out.println("Text1- " + Text1);
		Thread.sleep(4500);
		Actions action = new Actions(login.driver);
		WebElement AddTag = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
		action.contextClick(AddTag).build().perform();
		Thread.sleep(4500);
		//selecting Add tag option
		login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[9]")).click();
		Thread.sleep(4500);
		WebElement AddedTag = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("AddedTag")));
		Assert.assertEquals(true,AddedTag.isDisplayed());
		String Text2 =login.driver.findElement(By.xpath("//span[@class='tagit-label']")).getText();
		System.out.println("Text2- " + Text2);	
		
		if(Text1.equalsIgnoreCase(Text2))
		{
			System.out.println("All tags drop down is Verified Successfully");
			HTML_Report.strTCResult="PASS";
			  HTML_Report.execRemarks="All tags drop down is Verified Successfully";
		}
		else
		{
			 Assert.fail( "All tags drop down is NOT Verified Successfully");
			 HTML_Report.strTCResult="FAIL";
			  HTML_Report.execRemarks="All tags drop down is NOT Verified Successfully";
		}
		
		Thread.sleep(4500);
		login.driver.findElement(By.xpath("//span[@class='text-icon']")).click();
		Thread.sleep(4500);
		login.driver.findElement(By.xpath("//div[@class='sphere-modal-controls']/button[2]")).click();
		Thread.sleep(4500);
		login.driver.findElement(By.xpath("//div[@class='landing-content--filters-panel']/div[2]/div/div/div/div/span")).click();
	}
	
	
	
	
	@And("^Verify the Meassgae for the All tags drop down for no tags in insights$")
	public void verify_the_Meassgae_for_the_All_tags_drop_down_for_no_tags_in_insights() throws Throwable {
		Thread.sleep(4500);
		if(login.driver.findElements(By.xpath("//div[contains(text(),'There are no items to select')]")).size() != 0)
		{
			System.out.println("Meassgae for the All tags drop down for no tags in insights Appeared Successfully");
			 HTML_Report.strTCResult="PASS";
			  HTML_Report.execRemarks="Meassgae for the All tags drop down for no tags in insights Appeared Successfully";
			}else
			{
				 Assert.fail("Meassgae for the All tags drop down for no tags in insights Did'nt Appeared Successfully");
				 HTML_Report.strTCResult="FAIL";
				  HTML_Report.execRemarks="Meassgae for the All tags drop down for no tags in insights Did'nt Appeared Successfully";  
			}
		
		select_the_All_tag_dropdown();
		
	}
	

	@Given("^Verify that tag should be applied for all other tab$")
	public void verify_that_tag_should_be_applied_for_all_other_tab() throws Throwable {
		Thread.sleep(4500);
		login.driver.findElement(By.xpath("//span[contains(text(),'AddedTag')]")).click();
		Thread.sleep(4500);
		String AddedTagText = login.driver.findElement(By.xpath("//span[contains(text(),'AddedTag')]")).getText();
		
				Thread.sleep(4500);
	        	login.driver.findElement(By.xpath("//div[@class='insights-groups']/div[2]")).click();
	        	Thread.sleep(2500);
	        	
	        	String AddedTagTextinMyInsight =login.driver.findElement(By.xpath("//div[@class='landing-content--filters-panel']/div[2]/div/div/div/span/span[1]")).getText();
	        	
	        	
	        	if(AddedTagText.equalsIgnoreCase(AddedTagTextinMyInsight))
	        	{
	    			System.out.println("Successfully Verified Tag filter in My Insight Tab");
	    			}
	        	else{
	    				 Assert.fail( "Successfully NOT Verified Tag filter in My Insight Tab");
	    			     System.out.println("Successfully NOT Verified Tag filter in My Insight Tab");
	    			}
	           
	        	Thread.sleep(4500);
	     login.driver.findElement(By.xpath("//div[@class='insights-groups']/div[3]")).click();
        	Thread.sleep(2500);
        	Thread.sleep(2500);
        	
        	String AddedTagTextinAnalytics =login.driver.findElement(By.xpath("//div[@class='landing-content--filters-panel']/div[2]/div/div/div/span/span[1]")).getText();
        	
        	
        	if(AddedTagText.equalsIgnoreCase(AddedTagTextinAnalytics))
        	{
    			System.out.println("Successfully Verified Tag filter in Analytics Tab");
    			}
        	else{
    				 Assert.fail( "Successfully NOT Verified Tag filter in Analytics  Tab");
    			     System.out.println("Successfully NOT Verified Tag filter in Analytics  Tab");
    			}
	        
        	Thread.sleep(4500);
	         login.driver.findElement(By.xpath("//div[@class='insights-groups']/div[4]")).click();
        	Thread.sleep(2500);
        	Thread.sleep(2500);
        	
        	String AddedTagTextinShared =login.driver.findElement(By.xpath("//div[@class='landing-content--filters-panel']/div[2]/div/div/div/span/span[1]")).getText();
        	
        	
        	if(AddedTagText.equalsIgnoreCase(AddedTagTextinShared))
        	{
    			System.out.println("Successfully Verified Tag filter in Shared Tab");
    			}
        	else{
    				 Assert.fail( "Successfully NOT Verified Tag filter in Shared Tab");
    			     System.out.println("Successfully NOT Verified Tag filter in Shared Tab");
    			}
	          
        	Thread.sleep(4500);
	         login.driver.findElement(By.xpath("//div[@class='insights-groups']/div[5]")).click();
	         Thread.sleep(2500);
	        	
	        	String AddedTagTextinRecent =login.driver.findElement(By.xpath("//div[@class='landing-content--filters-panel']/div[2]/div/div/div/span/span[1]")).getText();
	        	
	        	
	        	if(AddedTagText.equalsIgnoreCase(AddedTagTextinRecent))
	        	{
	    			System.out.println("Successfully Verified Tag filter in Recent Tab");
	    			}
	        	else{
	    				 Assert.fail( "Successfully NOT Verified Tag filter in Recent Tab");
	    			     System.out.println("Successfully NOT Verified Tag filter in Recent Tab");
	    			}
	       
        	Thread.sleep(4500);
	        login.driver.findElement(By.xpath("//div[@class='insights-groups']/div[6]")).click();
	        Thread.sleep(2500);
        	
        	String AddedTagTextinAll =login.driver.findElement(By.xpath("//div[@class='landing-content--filters-panel']/div[2]/div/div/div/span/span[1]")).getText();
        	
        	
        	if(AddedTagText.equalsIgnoreCase(AddedTagTextinAll))
        	{
    			System.out.println("Successfully Verified Tag filter in All Tab");
    			HTML_Report.strTCResult="PASS";
  			   HTML_Report.execRemarks="Successfully Verified Tag filter in All FIVE Tab";
  			   
  			 Thread.sleep(4500);
	        	login.driver.findElement(By.xpath("//div[@class='insights-groups']/div[2]")).click();
	        	 Thread.sleep(4500);
  				Actions action = new Actions(login.driver);
  				WebElement AddTag = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
  				action.contextClick(AddTag).build().perform();
  				 Thread.sleep(4500);
  				login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[9]")).click();
  				Thread.sleep(4500);
  				login.driver.findElement(By.xpath("//span[@class='text-icon']")).click();
  				Thread.sleep(4500);
  				login.driver.findElement(By.xpath("//div[@class='sphere-modal-controls']/button[2]")).click();
  				Thread.sleep(4500);
  				login.driver.findElement(By.xpath("//div[@class='landing-content--filters-panel']/div[2]/div/div/div/div/span")).click();
        	}
        	else{
    				 Assert.fail( "Successfully NOT Verified Tag filter in All Tab");
    			     System.out.println("Successfully NOT Verified Tag filter in All Tab");
    			     HTML_Report.strTCResult="FAIL";
    				  HTML_Report.execRemarks="Successfully NOT Verified Tag filter in All FIVE Tab";
    			}
	     
	
	}
	
	@And("^Verify the landing page in left hand side$")
	public void verify_the_landing_page_in_left_hand_side() throws Throwable {
		Thread.sleep(2500);
		login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
		Thread.sleep(1500);
		 WebElement CEIC_Logo = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo")));
		 login.Log4j.info("Is 'CEIC logo' Displayed? - True/False:: " + CEIC_Logo.isDisplayed());
		  Assert.assertEquals(true,CEIC_Logo.isDisplayed());
	}
	
	@And("^Select Alert option$")
	public void select_Alert_option() throws Throwable {
		Thread.sleep(2500);
		login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
		Thread.sleep(2500);
		login.driver.findElement(By.xpath("//div[@class='header-menu']/div[1]")).click();
	}

	@And("^Alert dropdown should have See all notification option\\.$")
	public void alert_dropdown_should_have_See_all_notification_option() throws Throwable {
		Thread.sleep(2500);
		 WebElement See_All_notification = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("See_All_notification")));
		 login.Log4j.info("Is 'CEIC logo' Displayed? - True/False:: " + See_All_notification.isDisplayed());
		  Assert.assertEquals(true,See_All_notification.isDisplayed());
	}
	
	@And("^Select See all Notification option\\.$")
	public void select_See_all_Notification_option() throws Throwable {
		Thread.sleep(2500);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("See_All_notification"))).click();
		
	}

	@And("^Successfully redirect to Notification page$")
	public void successfully_redirect_to_Notification_page() throws Throwable {
		Thread.sleep(2500);
		 WebElement Notification_Page = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Notification_Page")));
		 login.Log4j.info("Is 'CEIC logo' Displayed? - True/False:: " + Notification_Page.isDisplayed());
		  Assert.assertEquals(true,Notification_Page.isDisplayed());
		  Thread.sleep(2500);
		  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
	}
	
	
	@And("^Select an insight$")
	public void select_an_insight() throws Throwable {
		Thread.sleep(1500);
		login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
		Thread.sleep(2500);
		Actions action = new Actions(login.driver);
		WebElement AddTag = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
		action.contextClick(AddTag).build().perform();
		Thread.sleep(1500);
		login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[1]")).click();
	}

	@And("^Successfully Verify View insight$")
	public void successfully_Verify_View_insight() throws Throwable {
		Thread.sleep(1500);
		 WebElement View_Close = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("View_Close")));
		 login.Log4j.info("Is 'View insight' Displayed? - True/False:: " + View_Close.isDisplayed());
		  Assert.assertEquals(true,View_Close.isDisplayed());
		  Thread.sleep(1500);
		  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("View_Close"))).click();
	}

	
	@And("^Select all category option$")
	public void select_all_category_option() throws Throwable {
		Thread.sleep(1500);
		login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
		Thread.sleep(2500);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_category"))).click();
		Thread.sleep(1500);
		login.driver.findElement(By.xpath("//div[contains(text(),'Hot Topics')]")).click();
		
	}

	@And("^Successfully Verify Remove icon for filters$")
	public void successfully_Verify_Remove_icon_for_filters() throws Throwable {
		Thread.sleep(1500);
		 WebElement Remove_icon_for_filters = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Remove_icon_for_filters")));
		 login.Log4j.info("Is 'Remove_icon_for_filters' Displayed? - True/False:: " + Remove_icon_for_filters.isDisplayed());
		  Assert.assertEquals(true,Remove_icon_for_filters.isDisplayed());
		  Thread.sleep(1500);
		  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Remove_icon_for_filters"))).click();
		  Thread.sleep(1500);
		  WebElement All_category = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_category")));
			 login.Log4j.info("Is 'All_category' Displayed? - True/False:: " + All_category.isDisplayed());
			  Assert.assertEquals(true,All_category.isDisplayed());
	}
	
	@And("^Successfully Verify View as a grid option$")
	public void successfully_Verify_View_as_a_grid_option() throws Throwable {
		Thread.sleep(1500);
		login.driver.findElement(By.xpath("//div[@title='View as a grid']")).click();
		Thread.sleep(1500);
		Actions action = new Actions(login.driver);
		WebElement we = login.driver.findElement(By.xpath("//*[@id='landing_page']/div[2]/div[2]/div/div[3]/div[2]/div[1]/div/div[2]"));
		action.moveToElement(we).build().perform();
		Thread.sleep(1500);
		 WebElement View_in_Grid = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("View_in_Grid")));
		 login.Log4j.info("Is 'View_in_Grid' Displayed? - True/False:: " + View_in_Grid.isDisplayed());
		  Assert.assertEquals(true,View_in_Grid.isDisplayed());
		  Thread.sleep(1500);
		  WebElement Open_in_Grid = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Open_in_Grid")));
			 login.Log4j.info("Is 'Open_in_Grid' Displayed? - True/False:: " + Open_in_Grid.isDisplayed());
			  Assert.assertEquals(true,Open_in_Grid.isDisplayed());
	}
	
	@And("^Successfully Verify View as a table option$")
	public void successfully_Verify_View_as_a_table_option() throws Throwable {
		Thread.sleep(500);
		login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
		Actions action = new Actions(login.driver);
		WebElement we = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
		action.contextClick(we).build().perform();
		  Thread.sleep(1500);
		  WebElement Table_open_with_new_tab = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_open_with_new_tab")));
			 login.Log4j.info("Is 'Table_open_with_new_tab' Displayed? - True/False:: " + Table_open_with_new_tab.isDisplayed());
			  Assert.assertEquals(true,Table_open_with_new_tab.isDisplayed());
			  Thread.sleep(1500);
			  WebElement Table_addtag = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_addtag")));
				 login.Log4j.info("Is 'Table_addtag' Displayed? - True/False:: " + Table_addtag.isDisplayed());
				  Assert.assertEquals(true,Table_addtag.isDisplayed());
				  Thread.sleep(1500); 
				  WebElement Table_copylink = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_copylink")));
					 login.Log4j.info("Is 'Table_copylink' Displayed? - True/False:: " + Table_copylink.isDisplayed());
					  Assert.assertEquals(true,Table_copylink.isDisplayed());
					  Thread.sleep(1500);
					  WebElement Table_createfolder = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_createfolder")));
						 login.Log4j.info("Is 'Table_createfolder' Displayed? - True/False:: " + Table_createfolder.isDisplayed());
						  Assert.assertEquals(true,Table_createfolder.isDisplayed());
						  Thread.sleep(1500);
						  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		 
		
	}
	
	
	@And("^Successfully Verify Categories dropdown$")
	public void successfully_Verify_Categories_dropdown() throws Throwable {
		Thread.sleep(2500);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_category"))).click();
		 Thread.sleep(1500);
		  WebElement Hot_tpoics = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Hot_tpoics")));
			 login.Log4j.info("Is 'Hot_tpoics' Displayed? - True/False:: " + Hot_tpoics.isDisplayed());
			  Assert.assertEquals(true,Hot_tpoics.isDisplayed());
			  Thread.sleep(1500);
			  WebElement World_Economy = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("World_Economy")));
				 login.Log4j.info("Is ' World_Economy' Displayed? - True/False:: " + World_Economy.isDisplayed());
				  Assert.assertEquals(true,World_Economy.isDisplayed());
				  Thread.sleep(1500); 
				  WebElement Thematic_Analysis = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Thematic_Analysis")));
					 login.Log4j.info("Is 'Thematic_Analysis' Displayed? - True/False:: " + Thematic_Analysis.isDisplayed());
					  Assert.assertEquals(true,Thematic_Analysis.isDisplayed());
					  Thread.sleep(1500);
					  WebElement New_Datasets = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("New_Datasets")));
						 login.Log4j.info("Is 'New_Datasets' Displayed? - True/False:: " + New_Datasets.isDisplayed());
						  Assert.assertEquals(true,New_Datasets.isDisplayed());
						  Thread.sleep(1500);
						  WebElement Emerging_markets = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Emerging_markets")));
							 login.Log4j.info("Is 'Emerging_markets' Displayed? - True/False:: " + Emerging_markets.isDisplayed());
							  Assert.assertEquals(true,Emerging_markets.isDisplayed());
							  Thread.sleep(1500);
							  WebElement Markets = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Markets")));
								 login.Log4j.info("Is 'Markets' Displayed? - True/False:: " + Markets.isDisplayed());
								  Assert.assertEquals(true,Markets.isDisplayed());
						  Thread.sleep(1500);
						  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		 
	}
	
	@And("^Select the Hot topics option$")
	public void select_the_Hot_topics_option() throws Throwable {
		Thread.sleep(500);
		login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
		
		 Thread.sleep(4500);
		 Actions action = new Actions(login.driver);
			WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
			action.contextClick(RightclickonInsight).build().perform();
			 Thread.sleep(2500);
			login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
			 Thread.sleep(3500);
				login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
		    Thread.sleep(3500);
		    login.driver.findElement(By.xpath("//div[@class='header-menu-item--dropdown']/div[10]")).click();
		    Thread.sleep(4500);
		  
		    login.driver.findElement(By.xpath("//div[@class='insight-settings-general']/div[4]/div/div/a/span[2]/b")).click();
		    Thread.sleep(4500);
		    login.driver.findElement(By.xpath("//ul[@class='select2-results']/li[2]/div/div[2]")).click();
		    Thread.sleep(4500);
		    login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		    Thread.sleep(2500);
			  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		    Thread.sleep(1500);
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			  
			  
		 Thread.sleep(1500);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_category"))).click();
		 Thread.sleep(1500);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Hot_tpoics"))).click();
	}

	@And("^verify the Hot topics category is available in the insight$")
	public void verify_the_Hot_topics_category_is_available_in_the_insight() throws Throwable {
		 Thread.sleep(4500);
		 Actions action = new Actions(login.driver);
			WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
			action.contextClick(RightclickonInsight).build().perform();
			 Thread.sleep(2500);
			login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
			 Thread.sleep(3500);
				login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
		    Thread.sleep(3500);
		    login.driver.findElement(By.xpath("	//div[@class='header-menu-item--dropdown']/div[10]")).click();
		    Thread.sleep(4500);
			  WebElement Hot_tpoics = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Hot_tpoics")));
				 login.Log4j.info("Is 'Hot_tpoics' Displayed? - True/False:: " + Hot_tpoics.isDisplayed());
				  Assert.assertEquals(true,Hot_tpoics.isDisplayed());
				  Thread.sleep(4500);
				    login.driver.findElement(By.xpath("//div[@class='insight-settings-general']/div[4]/div/div/a/span[2]/b")).click();
				    Thread.sleep(4500);
				    login.driver.findElement(By.xpath("//ul[@class='select2-results']/li[1]/div/div[2]")).click();
				    Thread.sleep(4500);
				    login.driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();  
				  Thread.sleep(2500);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
				  Thread.sleep(1500);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Remove_icon_for_filters"))).click();
	}
	
	@And("^Select the World Economy option$")
	public void select_the_World_Economy_option() throws Throwable {
		Thread.sleep(500);
		login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
		 Thread.sleep(4500);
		 Actions action = new Actions(login.driver);
			WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
			action.contextClick(RightclickonInsight).build().perform();
			 Thread.sleep(2500);
			login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
			 Thread.sleep(3500);
				login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
		    Thread.sleep(3500);
		    login.driver.findElement(By.xpath("//div[@class='header-menu-item--dropdown']/div[10]")).click();
		    Thread.sleep(4500);
		    login.driver.findElement(By.xpath("//div[@class='insight-settings-general']/div[4]/div/div/a/span[2]/b")).click();
		    Thread.sleep(4500);
		    login.driver.findElement(By.xpath("//ul[@class='select2-results']/li[3]/div/div[2]")).click();
		    Thread.sleep(4500);
		    login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		    Thread.sleep(2500);
			  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		    Thread.sleep(1500);
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		 Thread.sleep(1500);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_category"))).click();
		 Thread.sleep(1500);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("World_Economy"))).click();
	}

	@And("^verify the World Economy category is available in the insight$")
	public void verify_the_World_Economy_category_is_available_in_the_insight() throws Throwable {
		 Thread.sleep(4500);
		 Actions action = new Actions(login.driver);
			WebElement AddTag = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
			action.contextClick(AddTag).build().perform();
			 Thread.sleep(2500);
			login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
			 Thread.sleep(3500);
				login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
		    Thread.sleep(3500);
		    login.driver.findElement(By.xpath("	//div[@class='header-menu-item--dropdown']/div[10]")).click();
		    Thread.sleep(4500);
			  WebElement World_Economy = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("World_Economy")));
				 login.Log4j.info("Is 'World_Economy' Displayed? - True/False:: " + World_Economy.isDisplayed());
				  Assert.assertEquals(true,World_Economy.isDisplayed());
				  Thread.sleep(4500);
				    login.driver.findElement(By.xpath("//div[@class='insight-settings-general']/div[4]/div/div/a/span[2]/b")).click();
				    Thread.sleep(4500);
				    login.driver.findElement(By.xpath("//ul[@class='select2-results']/li[1]/div/div[2]")).click();
				    Thread.sleep(4500);
				    login.driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
				  Thread.sleep(2500);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
				  Thread.sleep(1500);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Remove_icon_for_filters"))).click();
	}
	
	
	
	@And("^Select the Emerging Markets option$")
	public void select_the_Emerging_Markets_option() throws Throwable {
		Thread.sleep(500);
		login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
		 Thread.sleep(4500);
		 Actions action = new Actions(login.driver);
			WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
			action.contextClick(RightclickonInsight).build().perform();
			 Thread.sleep(2500);
			login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
			 Thread.sleep(3500);
				login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
		    Thread.sleep(3500);
		    login.driver.findElement(By.xpath("//div[@class='header-menu-item--dropdown']/div[10]")).click();
		    Thread.sleep(4500);
		    login.driver.findElement(By.xpath("//div[@class='insight-settings-general']/div[4]/div/div/a/span[2]/b")).click();
		    Thread.sleep(4500);
		    login.driver.findElement(By.xpath("//ul[@class='select2-results']/li[4]/div/div[2]")).click();
		    Thread.sleep(4500);
		    login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		    Thread.sleep(2500);
			  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		    Thread.sleep(1500);
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		 Thread.sleep(1500);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_category"))).click();
		 Thread.sleep(1500);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Emerging_markets"))).click();
	}

	@And("^verify the Emerging Markets category is available in the insight$")
	public void verify_the_Emerging_Markets_category_is_available_in_the_insight() throws Throwable {
		 Thread.sleep(4500);
		 Actions action = new Actions(login.driver);
			WebElement AddTag = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
			action.contextClick(AddTag).build().perform();
			 Thread.sleep(2500);
			login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
			 Thread.sleep(3500);
				login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
		    Thread.sleep(3500);
		    login.driver.findElement(By.xpath("	//div[@class='header-menu-item--dropdown']/div[10]")).click();
		    Thread.sleep(4500);
			  WebElement Emerging_markets = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Emerging_markets")));
				 login.Log4j.info("Is 'Emerging_markets' Displayed? - True/False:: " + Emerging_markets.isDisplayed());
				  Assert.assertEquals(true,Emerging_markets.isDisplayed());
				  Thread.sleep(4500);
				    login.driver.findElement(By.xpath("//div[@class='insight-settings-general']/div[4]/div/div/a/span[2]/b")).click();
				    Thread.sleep(4500);
				    login.driver.findElement(By.xpath("//ul[@class='select2-results']/li[1]/div/div[2]")).click();
				    Thread.sleep(4500);
				    login.driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
				  Thread.sleep(2500);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
				  Thread.sleep(1500);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Remove_icon_for_filters"))).click();
	}
	@And("^Select the Thematic Analysis option$")
		public void select_the_Thematic_Analysis_option() throws Throwable {
			Thread.sleep(500);
			login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
			 Thread.sleep(4500);
			 Actions action = new Actions(login.driver);
				WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
				action.contextClick(RightclickonInsight).build().perform();
				 Thread.sleep(2500);
				login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
				 Thread.sleep(3500);
					login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
			    Thread.sleep(3500);
			    login.driver.findElement(By.xpath("//div[@class='header-menu-item--dropdown']/div[10]")).click();
			    Thread.sleep(4500);
			    login.driver.findElement(By.xpath("//div[@class='insight-settings-general']/div[4]/div/div/a/span[2]/b")).click();
			    Thread.sleep(4500);
			    login.driver.findElement(By.xpath("//ul[@class='select2-results']/li[5]/div/div[2]")).click();
			    Thread.sleep(4500);
			    login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
			    Thread.sleep(2500);
				  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			    Thread.sleep(1500);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 Thread.sleep(1500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_category"))).click();
			 Thread.sleep(1500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Thematic_Analysis"))).click();
		}

	@And("^verify the Thematic Analysis category is available in the insight$")
		public void verify_the_Thematic_Analysis_category_is_available_in_the_insight() throws Throwable {
			 Thread.sleep(4500);
			 Actions action = new Actions(login.driver);
				WebElement AddTag = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
				action.contextClick(AddTag).build().perform();
				 Thread.sleep(2500);
				login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
				 Thread.sleep(3500);
					login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
			    Thread.sleep(3500);
			    login.driver.findElement(By.xpath("	//div[@class='header-menu-item--dropdown']/div[10]")).click();
			    Thread.sleep(4500);
				  WebElement Thematic_Analysis = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Thematic_Analysis")));
					 login.Log4j.info("Is 'Thematic_Analysis' Displayed? - True/False:: " + Thematic_Analysis.isDisplayed());
					  Assert.assertEquals(true,Thematic_Analysis.isDisplayed());
					  Thread.sleep(4500);
					    login.driver.findElement(By.xpath("//div[@class='insight-settings-general']/div[4]/div/div/a/span[2]/b")).click();
					    Thread.sleep(4500);
					    login.driver.findElement(By.xpath("//ul[@class='select2-results']/li[1]/div/div[2]")).click();
					    Thread.sleep(4500);
					    login.driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
					  Thread.sleep(2500);
					  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
					  Thread.sleep(1500);
					  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Remove_icon_for_filters"))).click();
		}
	
	
	@And("^Select the  Markets option$")
			public void select_the_Markets_option() throws Throwable {
				Thread.sleep(500);
				login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
				 Thread.sleep(4500);
				 Actions action = new Actions(login.driver);
					WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
					action.contextClick(RightclickonInsight).build().perform();
					 Thread.sleep(2500);
					login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
					 Thread.sleep(3500);
						login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
				    Thread.sleep(3500);
				    login.driver.findElement(By.xpath("//div[@class='header-menu-item--dropdown']/div[10]")).click();
				    Thread.sleep(4500);
				    login.driver.findElement(By.xpath("//div[@class='insight-settings-general']/div[4]/div/div/a/span[2]/b")).click();
				    Thread.sleep(4500);
				    login.driver.findElement(By.xpath("//ul[@class='select2-results']/li[6]/div/div[2]")).click();
				    Thread.sleep(4500);
				    login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
				    Thread.sleep(2500);
					  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
				    Thread.sleep(1500);
					  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
				 Thread.sleep(1500);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_category"))).click();
				 Thread.sleep(1500);
				 login.driver.findElement(By.xpath("//ul[@class='custom-select--body dropdown--body']/li[5]")).click();
			}
			
	@And("^verify the  Markets category is available in the insight$")
			public void verify_the_Markets_category_is_available_in_the_insight() throws Throwable {
			Thread.sleep(4500);
				 Actions action = new Actions(login.driver);
					WebElement AddTag = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
					action.contextClick(AddTag).build().perform();
					 Thread.sleep(2500);
					login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
					 Thread.sleep(3500);
						login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
				    Thread.sleep(3500);
				    login.driver.findElement(By.xpath("	//div[@class='header-menu-item--dropdown']/div[10]")).click();
				    Thread.sleep(4500);
					  WebElement Markets = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Markets")));
						 login.Log4j.info("Is 'Markets' Displayed? - True/False:: " + Markets.isDisplayed());
						  Assert.assertEquals(true,Markets.isDisplayed());
						  Thread.sleep(4500);
						    login.driver.findElement(By.xpath("//div[@class='insight-settings-general']/div[4]/div/div/a/span[2]/b")).click();
						    Thread.sleep(4500);
						    login.driver.findElement(By.xpath("//ul[@class='select2-results']/li[1]/div/div[2]")).click();
						    Thread.sleep(4500);
						    login.driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
						  Thread.sleep(2500);
						  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
						  Thread.sleep(1500);
						  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Remove_icon_for_filters"))).click();
			}
			
	@And("^Select the  New Datasets option$")
			public void select_the_New_Datasets_option() throws Throwable {
				Thread.sleep(500);
				login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
				 Thread.sleep(4500);
				 Actions action = new Actions(login.driver);
					WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
					action.contextClick(RightclickonInsight).build().perform();
					 Thread.sleep(2500);
					login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
					 Thread.sleep(3500);
						login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
				    Thread.sleep(3500);
				    login.driver.findElement(By.xpath("//div[@class='header-menu-item--dropdown']/div[10]")).click();
				    Thread.sleep(4500);
				    login.driver.findElement(By.xpath("//div[@class='insight-settings-general']/div[4]/div/div/a/span[2]/b")).click();
				    Thread.sleep(4500);
				    login.driver.findElement(By.xpath("//ul[@class='select2-results']/li[7]/div/div[2]")).click();
				    Thread.sleep(4500);
				    login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
				    Thread.sleep(2500);
					  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
				    Thread.sleep(1500);
					  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
				 Thread.sleep(1500);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_category"))).click();
				 Thread.sleep(1500);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("New_Datasets"))).click();
			}

	@And("^verify the  New Datasets category is available in the insight$")
			public void verify_the_New_Datasets_category_is_available_in_the_insight() throws Throwable {
				Thread.sleep(4500);
				 Actions action = new Actions(login.driver);
					WebElement AddTag = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
					action.contextClick(AddTag).build().perform();
					 Thread.sleep(2500);
					login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
					 Thread.sleep(3500);
						login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
				    Thread.sleep(3500);
				    login.driver.findElement(By.xpath("	//div[@class='header-menu-item--dropdown']/div[10]")).click();
				    Thread.sleep(4500);
					  WebElement New_Datasets = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("New_Datasets")));
						 login.Log4j.info("Is 'New_Datasets' Displayed? - True/False:: " + New_Datasets.isDisplayed());
						  Assert.assertEquals(true,New_Datasets.isDisplayed());
						  Thread.sleep(4500);
						    login.driver.findElement(By.xpath("//div[@class='insight-settings-general']/div[4]/div/div/a/span[2]/b")).click();
						    Thread.sleep(4500);
						    login.driver.findElement(By.xpath("//ul[@class='select2-results']/li[1]/div/div[2]")).click();
						    Thread.sleep(4500);
						    login.driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
						  Thread.sleep(2500);
						  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
						  Thread.sleep(1500);
						  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Remove_icon_for_filters"))).click();
			}
			
	@And("^Select Product option$")
			public void select_Product_option() throws Throwable {
				Thread.sleep(1500);
				login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
				Thread.sleep(2500);
				login.driver.findElement(By.xpath("//span[contains(text(),'Products')]")).click();
				
				
			}

	@And("^Successfully Verify Product Dropdown$")
			public void successfully_Verify_Product_Dropdown() throws Throwable {
				 Thread.sleep(1500); 
				  WebElement Product_Global_Database = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Product_Global_Database")));
					 login.Log4j.info("Is 'Product_Global_Database' Displayed? - True/False:: " + Product_Global_Database.isDisplayed());
					  Assert.assertEquals(true,Product_Global_Database.isDisplayed());
					  Thread.sleep(1500);
					  WebElement Product_World_trend_plus = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Product_World_trend_plus")));
						 login.Log4j.info("Is 'Product_World_trend_plus' Displayed? - True/False:: " + Product_World_trend_plus.isDisplayed());
						  Assert.assertEquals(true,Product_World_trend_plus.isDisplayed());
						  Thread.sleep(1500);
						  WebElement Product_premium_Databases = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Product_premium_Databases")));
							 login.Log4j.info("Is 'Product_premium_Databases' Displayed? - True/False:: " + Product_premium_Databases.isDisplayed());
							  Assert.assertEquals(true,Product_premium_Databases.isDisplayed());
							  Thread.sleep(2500);
							  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			}
			
			
	@And("^Successfully Verify All databases like \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" under Product$")
			public void successfully_Verify_All_databases_like_under_Product(String arg1, String arg2, String arg3) throws Throwable {
			 
				 Thread.sleep(1500); 
				 String Y = login.driver.findElement(By.xpath("//div[contains(text(),'Global Database')]")).getText();
				    System.out.println(Y);
				    String s = Y;
				    String[] result = s.split(" ", 2);
				    String first = result[0];
				    String rest = result[1];
				    System.out.println("First: " + first);
				 if(arg1.equalsIgnoreCase(arg1)){
				  WebElement Global_Database_Explore_data = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Global_Database_Explore_data")));
					 login.Log4j.info("Is 'Global_Database_Explore_data' Displayed? - True/False:: " + Global_Database_Explore_data.isDisplayed());
					  Assert.assertEquals(true,Global_Database_Explore_data.isDisplayed());
					  Thread.sleep(4500); 
					  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Global_Database_Explore_data"))).click();
					  Thread.sleep(4500); 
					  ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
					    login.driver.switchTo().window(tabs2.get(1));
					    Thread.sleep(4500); 
					    WebElement Global_Database_global_in_Newinsight = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Global_Database_global_in_Newinsight")));
						 login.Log4j.info("Is 'Global_Database_global_in_Newinsight' Displayed? - True/False:: " + Global_Database_global_in_Newinsight.isDisplayed());
						  String X = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Global_Database_global_in_Newinsight"))).getText();
						  System.out.println(X);
						  Assert.assertEquals(true,Global_Database_global_in_Newinsight.isDisplayed());
					    login.driver.close();
					    login.driver.switchTo().window(tabs2.get(0));
					    if(X.equalsIgnoreCase(first)){
					    	System.out.println("GDB Mathched Successfully");
					    }else{
					    	 Assert.fail( "GlobalDatabase Didn't Match in the New insight:-(");
					    }
					
				 }
				 if(arg2.equalsIgnoreCase(arg2)){
					 Thread.sleep(2500);
						login.driver.findElement(By.xpath("//span[contains(text(),'Products')]")).click();
					  Thread.sleep(3500);
					  WebElement Global_Database_Footnotes = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Global_Database_Footnotes")));
						 login.Log4j.info("Is 'Global_Database_Footnotes' Displayed? - True/False:: " + Global_Database_Footnotes.isDisplayed());
						  Assert.assertEquals(true,Global_Database_Footnotes.isDisplayed());
						  Thread.sleep(3500);
						  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Global_Database_Footnotes"))).click();
						  Thread.sleep(2500); 
						  String X = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Global_Database_inside_footnotes"))).getText();
						  System.out.println(X);
						  Thread.sleep(4500); 
						    WebElement Global_Database_inside_footnotes = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Global_Database_inside_footnotes")));
							 login.Log4j.info("Is 'Global_Database_inside_footnotes' Displayed? - True/False:: " + Global_Database_inside_footnotes.isDisplayed());
							  Assert.assertEquals(true,Global_Database_inside_footnotes.isDisplayed());
							  Thread.sleep(4500); 
							  if(X.equalsIgnoreCase(Y)){
							    	System.out.println("GDB Mathched Successfully");
							    }else{
							    	 Assert.fail( "Global Database Didn't Match in the Open footnotes:-(");
							    }
							  login.driver.findElement(By.xpath("//div[@class='movable-modal--close']")).click();
								  
				 }
				 if(arg3.equalsIgnoreCase(arg3)){
					 Thread.sleep(2500);
						login.driver.findElement(By.xpath("//span[contains(text(),'Products')]")).click();
						  WebElement Global_Database_Watch_vedio = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Global_Database_Watch_vedio")));
							 login.Log4j.info("Is 'Global_Database_Watch_vedio' Displayed? - True/False:: " + Global_Database_Watch_vedio.isDisplayed());
							  Assert.assertEquals(true,Global_Database_Watch_vedio.isDisplayed());
							  Thread.sleep(2500);
							  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Global_Database_Watch_vedio"))).click();
							  Thread.sleep(2500);
							 
							  WebElement Element = login.driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div[2]/div[1]/iframe"));
							  login.driver.switchTo().frame(Element);
							  login.driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();
							  Thread.sleep(90000);
							  Actions action = new Actions(login.driver);
								WebElement we = login.driver.findElement(By.xpath("//div[@class='ytp-progress-bar-padding']"));
								action.moveToElement(we).build().perform();
									 login.driver.findElement(By.xpath("//span[@class='ytp-time-current']")).click();
									 String STime = login.driver.findElement(By.xpath("//span[@class='ytp-time-current']")).getText();
									 System.out.println("Duration of Vedio after Successful Play :-"+ STime);
									 Thread.sleep(1000);
									 login.driver.findElement(By.xpath("//span[@class='ytp-time-duration']")).click();
									 String ETime = login.driver.findElement(By.xpath("//span[@class='ytp-time-duration']")).getText();
									 System.out.println("Total duration of Vedio :-"+ ETime);
							
					       if(STime.equalsIgnoreCase(ETime)){
					    	   System.out.println("Vedio Played Succesfully :-)");
					       } else{
					    		   Assert.fail( "Vedio Did'nt Played Succesfully :-(");
					    	   }
					       Thread.sleep(10000);
					      login. driver.switchTo().defaultContent();
					       Actions action1 = new Actions(login.driver);
							WebElement we1 = login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']"));
							action1.moveToElement(we1).build().perform();
							  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
							  //login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			}
				
		     
			}
				
	@And("^Successfully verify the What's New option under Product$")
			public void successfully_verify_the_What_s_New_option_under_Product() throws Throwable {
				Thread.sleep(5000);
				login.driver.findElement(By.xpath("//div[@class='header-menu-products--footer-link']/div")).click();
				Thread.sleep(8000);
				 WebElement Whats_new_Announcement = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Whats_new_Announcement")));
				 login.Log4j.info("Is 'Whats_new_Announcement' Displayed? - True/False:: " + Whats_new_Announcement.isDisplayed());
				  Assert.assertEquals(true,Whats_new_Announcement.isDisplayed());
				  Thread.sleep(8000);
				  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			}
			
	@And("^Select the What's New and Take the servey option$")
			public void select_the_What_s_New_and_Take_the_servey_option() throws Throwable {
				Thread.sleep(5000);
				login.driver.findElement(By.xpath("//div[@class='header-menu-products--footer-link']/div")).click();
				Thread.sleep(12000);
				login.driver.findElement(By.xpath("//a[@class='announcements-container--button button button__primary']")).click();
			}

	@And("^Successfully verify the Take the servey option under what's new$")
			public void successfully_verify_the_Take_the_servey_option_under_what_s_new() throws Throwable {
				Thread.sleep(5000);
				 ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
				    login.driver.switchTo().window(tabs2.get(1));
				    String URL = login.driver.getCurrentUrl();
				    System.out.println(URL);
				    Assert.assertEquals(URL, "http://m.mail1.euromoneyplc.net/webApp/CDMNext" );
				    WebElement Whats_new_Ceic_Survey = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Whats_new_Ceic_Survey")));
					 login.Log4j.info("Is 'Whats_new_Ceic_Survey' Displayed? - True/False:: " + Whats_new_Ceic_Survey.isDisplayed());
					  Assert.assertEquals(true,Whats_new_Ceic_Survey.isDisplayed());
				    login.driver.close();
				    login.driver.switchTo().window(tabs2.get(0));
				    Thread.sleep(8000);
					  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			}
			
			
	@And("^Successfully Verify World Trend Plus databases like \"([^\"]*)\" \"([^\"]*)\" under Product$")
			public void successfully_Verify_World_Trend_Plus_databases_like_under_Product(String arg1, String arg2) throws Throwable {
		 Thread.sleep(1500); 
		 String Y = login.driver.findElement(By.xpath("//div[contains(text(),'World Trend Plus')]")).getText();
		    System.out.println(Y);
		 if(arg1.equalsIgnoreCase(arg1)){
		  WebElement World_Treand_Database_Explore_data = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("World_Treand_Database_Explore_data")));
			 login.Log4j.info("Is 'World_Treand_Database_Explore_data' Displayed? - True/False:: " + World_Treand_Database_Explore_data.isDisplayed());
			  Assert.assertEquals(true,World_Treand_Database_Explore_data.isDisplayed());
			  Thread.sleep(4500); 
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("World_Treand_Database_Explore_data"))).click();
			  Thread.sleep(4500); 
			  ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
			    login.driver.switchTo().window(tabs2.get(1));
			    Thread.sleep(4500); 
			    WebElement World_Treand_Database_WorldTreand_in_Newinsight = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("World_Treand_Database_WorldTreand_in_Newinsight")));
				 login.Log4j.info("Is 'World_Treand_Database_WorldTreand_in_Newinsight' Displayed? - True/False:: " + World_Treand_Database_WorldTreand_in_Newinsight.isDisplayed());
				  String X = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("World_Treand_Database_WorldTreand_in_Newinsight"))).getText();
				  System.out.println(X);
				  Assert.assertEquals(true,World_Treand_Database_WorldTreand_in_Newinsight.isDisplayed());
			    login.driver.close();
			    login.driver.switchTo().window(tabs2.get(0));
			    if(X.equalsIgnoreCase(Y)){
			    	System.out.println("WTP Mathched Successfully");
			    }else{
			    	 Assert.fail( "World Trend Database Didn't Match in the New insight:-(");
			    }
			  
		 }
		 if(arg2.equalsIgnoreCase(arg2)){
				 Thread.sleep(2500);
					login.driver.findElement(By.xpath("//span[contains(text(),'Products')]")).click();
				  Thread.sleep(3500);
				  WebElement World_Treand_Database_Footnotes = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("World_Treand_Database_Footnotes")));
					 login.Log4j.info("Is 'World_Treand_Database_Footnotes' Displayed? - True/False:: " + World_Treand_Database_Footnotes.isDisplayed());
					  Assert.assertEquals(true,World_Treand_Database_Footnotes.isDisplayed());
					  Thread.sleep(3500);
					  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("World_Treand_Database_Footnotes"))).click();
					  Thread.sleep(3500);
					  String X = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("World_Treand_inside_footnotes"))).getText();
					  System.out.println(X);
					//div[@class='footnotes-bread-crumbs']/div/div[1]
					  Thread.sleep(4500); 
					    WebElement World_Treand_inside_footnotes = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("World_Treand_inside_footnotes")));
						 login.Log4j.info("Is 'World_Treand_inside_footnotes' Displayed? - True/False:: " + World_Treand_inside_footnotes.isDisplayed());
						  Assert.assertEquals(true,World_Treand_inside_footnotes.isDisplayed());
						  Thread.sleep(4500); 
						  if(X.equalsIgnoreCase(Y)){
						    	System.out.println("WTP Mathched Successfully");
						    }else{
						    	 Assert.fail( "World Trend Database Didn't Match in the Open footnotes:-(");
						    }
						  login.driver.findElement(By.xpath("//div[@class='movable-modal--close']")).click();
				 
		 
		 }
			}
	
	@Given("^Successfully Verify China Premium databases like \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" under Product$")
	public void successfully_Verify_China_Premium_databases_like_under_Product(String arg1, String arg2, String arg3) throws Throwable {
		 Thread.sleep(1500); 
		 String Y = login.driver.findElement(By.xpath("//*[@id='landing_page']/div[1]/div/div[2]/div[2]/div/div[2]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]")).getText();
		    System.out.println(Y);
		    Thread.sleep(1500); 
		    if(arg1.equalsIgnoreCase(arg1)){
				  WebElement China_PremiumDatabase_Explore_data = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("World_Treand_Database_Explore_data")));
					 login.Log4j.info("Is 'China_PremiumDatabase_Explore_data' Displayed? - True/False:: " + China_PremiumDatabase_Explore_data.isDisplayed());
					  Assert.assertEquals(true,China_PremiumDatabase_Explore_data.isDisplayed());
					  Thread.sleep(4500); 
					  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("China_PremiumDatabase_Explore_data"))).click();
					//div[@class='database-representation--actions']/div/div[1]/div[2]/span[1]
					  ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
					    login.driver.switchTo().window(tabs2.get(1));
					    Thread.sleep(4500); 
					    WebElement China_PremiumDatabase_china_in_Newinsight = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("China_PremiumDatabase_china_in_Newinsight")));
						 login.Log4j.info("Is 'China_PremiumDatabase_china_in_Newinsight' Displayed? - True/False:: " + China_PremiumDatabase_china_in_Newinsight.isDisplayed());
						  String X = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("China_PremiumDatabase_china_in_Newinsight"))).getText();
						  System.out.println(X);
						  Assert.assertEquals(true,China_PremiumDatabase_china_in_Newinsight.isDisplayed());
					    login.driver.close();
					    login.driver.switchTo().window(tabs2.get(0));
					    String s = X;
					    String[] result = s.split(" ", 2);
					    String first = result[0];
					    String rest = result[1];
					    System.out.println("First: " + first);
					    if(first.equalsIgnoreCase(Y)){
					    	System.out.println("CPDB Mathched Successfully");
					   }else{
					    	 Assert.fail( "China Premium data base Didn't Match in the New insight:-(");
					    }
					
				 
	}
		    if(arg2.equalsIgnoreCase(arg2)){
		    	Thread.sleep(2500);
				login.driver.findElement(By.xpath("//span[contains(text(),'Products')]")).click();
			  Thread.sleep(3500);
			  WebElement China_PremiumDatabase_Footnotes = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("China_PremiumDatabase_Footnotes")));
				 login.Log4j.info("Is 'China_Database_Footnotes' Displayed? - True/False:: " + China_PremiumDatabase_Footnotes.isDisplayed());
				  Assert.assertEquals(true,China_PremiumDatabase_Footnotes.isDisplayed());
				  Thread.sleep(3500);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("China_PremiumDatabase_Footnotes"))).click();
				  Thread.sleep(2500); 
				  String X = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("China_PremiumDatabase_inside_footnotes"))).getText();
				  System.out.println(X);
				  Thread.sleep(4500); 
				    WebElement China_PremiumDatabase_inside_footnotes = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Global_Database_inside_footnotes")));
					 login.Log4j.info("Is 'China_PremiumDatabase_inside_footnotes' Displayed? - True/False:: " + China_PremiumDatabase_inside_footnotes.isDisplayed());
					  Assert.assertEquals(true,China_PremiumDatabase_inside_footnotes.isDisplayed());
					  Thread.sleep(4500); 
					   String s = X;
					    String[] result = s.split(" ", 2);
					    String first = result[0];
					    String rest = result[1];
					    System.out.println("First: " + first);
					  if(first.equalsIgnoreCase(Y)){
					    	System.out.println("CDB Mathched Successfully in Footnotes");
					    }else{
					    	 Assert.fail( "China Database Didn't Match in the Open footnotes:-(");
					    }
					  login.driver.findElement(By.xpath("//div[@class='movable-modal--close']")).click();
						  
		 }
		    
		    
		    if(arg3.equalsIgnoreCase(arg3)){
				 Thread.sleep(2500);
					login.driver.findElement(By.xpath("//span[contains(text(),'Products')]")).click();
					  WebElement China_PremiumDatabase_Watch_vedio = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("China_PremiumDatabase_Watch_vedio")));
						 login.Log4j.info("Is 'China_PremiumDatabase_Watch_vedio' Displayed? - True/False:: " + China_PremiumDatabase_Watch_vedio.isDisplayed());
						  Assert.assertEquals(true,China_PremiumDatabase_Watch_vedio.isDisplayed());
						  Thread.sleep(2500);
						  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("China_PremiumDatabase_Watch_vedio"))).click();
						  Thread.sleep(2500);
						 
						  WebElement Element = login.driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div[2]/div[1]/iframe"));
						  login.driver.switchTo().frame(Element);
						  login.driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();
						  Thread.sleep(120000);
						  Actions action = new Actions(login.driver);
							WebElement we = login.driver.findElement(By.xpath("//div[@class='ytp-progress-bar-padding']"));
							action.moveToElement(we).build().perform();
								 login.driver.findElement(By.xpath("//span[@class='ytp-time-current']")).click();
								 String STime = login.driver.findElement(By.xpath("//span[@class='ytp-time-current']")).getText();
								 System.out.println("Duration of Vedio after Successful Play :-"+ STime);
								 Thread.sleep(1000);
								 login.driver.findElement(By.xpath("//span[@class='ytp-time-duration']")).click();
								 String ETime = login.driver.findElement(By.xpath("//span[@class='ytp-time-duration']")).getText();
								 System.out.println("Total duration of Vedio :-"+ ETime);
						
				       if(STime.equalsIgnoreCase(ETime)){
				    	   System.out.println("Vedio Played Succesfully :-)");
				       } else{
				    		   Assert.fail( "Vedio Did'nt Played Succesfully :-(");
				    	   }
				       Thread.sleep(10000);
				      login. driver.switchTo().defaultContent();
				       Actions action1 = new Actions(login.driver);
						WebElement we1 = login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']"));
						action1.moveToElement(we1).build().perform();
						  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
						  //login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		}
		    
	}
	
	@Given("^Successfully Verify Brazil Premium databases like \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" under Product$")
	public void successfully_Verify_Brazil_Premium_databases_like_under_Product(String arg1, String arg2, String arg3) throws Throwable {
		
		Thread.sleep(1500); 
		 String Y = login.driver.findElement(By.xpath("//div[@class='header-menu-products--premium-body']/div/div[2]/div[1]")).getText();
		    System.out.println(Y);
		 if(arg1.equalsIgnoreCase(arg1)){
		  WebElement Brazil_PremiumDatabase_Explore_data = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Brazil_PremiumDatabase_Explore_data")));
			 login.Log4j.info("Is 'Brazil_PremiumDatabase_Explore_data_Explore_data' Displayed? - True/False:: " + Brazil_PremiumDatabase_Explore_data.isDisplayed());
			  Assert.assertEquals(true,Brazil_PremiumDatabase_Explore_data.isDisplayed());
			  Thread.sleep(4500); 
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Brazil_PremiumDatabase_Explore_data"))).click();
			  Thread.sleep(4500); 
			  ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
			    login.driver.switchTo().window(tabs2.get(1));
			    Thread.sleep(4500); 
			    WebElement Brazil_PremiumDatabase_brazil_in_Newinsight = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Brazil_PremiumDatabase_brazil_in_Newinsight")));
				 login.Log4j.info("Is 'Brazil_PremiumDatabase_brazil_in_Newinsight' Displayed? - True/False:: " + Brazil_PremiumDatabase_brazil_in_Newinsight.isDisplayed());
				  Assert.assertEquals(true,Brazil_PremiumDatabase_brazil_in_Newinsight.isDisplayed());
				  String X = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Brazil_PremiumDatabase_brazil_in_Newinsight"))).getText();
				  System.out.println(X);
			    login.driver.close();
			    login.driver.switchTo().window(tabs2.get(0));
			    String s = X;
			    String[] result = s.split(" ", 2);
			    String first = result[0];
			    String rest = result[1];
			    System.out.println("First: " + first);
			    if(first.equalsIgnoreCase(Y)){
			    	  System.out.println( first + ":" + Y );
			    	System.out.println("BPDB Mathched Successfully");
			    }else{
			    	 Assert.fail( "Brazil premium Database Didn't Match in the New insight:-(");
			    }
			  
		 }
		 if(arg2.equalsIgnoreCase(arg2)){
				 Thread.sleep(2500);
					login.driver.findElement(By.xpath("//span[contains(text(),'Products')]")).click();
				  Thread.sleep(3500);
				  WebElement Brazil_PremiumDatabase_Footnotes = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Brazil_PremiumDatabase_Footnotes")));
					 login.Log4j.info("Is 'Brazil_PremiumDatabase_Footnotes' Displayed? - True/False:: " + Brazil_PremiumDatabase_Footnotes.isDisplayed());
					  Assert.assertEquals(true,Brazil_PremiumDatabase_Footnotes.isDisplayed());
					  Thread.sleep(3500);
					  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Brazil_PremiumDatabase_Footnotes"))).click();
					  Thread.sleep(3500);
					  String X = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Brazil_PremiumDatabase_inside_footnotes"))).getText();
					  System.out.println(X);
					//div[@class='footnotes-bread-crumbs']/div/div[1]
					  Thread.sleep(4500); 
					    WebElement World_Treand_inside_footnotes = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("World_Treand_inside_footnotes")));
						 login.Log4j.info("Is 'World_Treand_inside_footnotes' Displayed? - True/False:: " + World_Treand_inside_footnotes.isDisplayed());
						  Assert.assertEquals(true,World_Treand_inside_footnotes.isDisplayed());
						  Thread.sleep(4500); 
						  String s = X;
						    String[] result = s.split(" ", 2);
						    String first = result[0];
						    String rest = result[1];
						    System.out.println("First: " + first);
						  if(first.equalsIgnoreCase(Y)){
							    System.out.println( first + ":" + Y );
						    	System.out.println("BPDB Mathched Successfully in footnotes");
						    }else{
						    	 Assert.fail( "Brazil Database Didn't Match in the Open footnotes:-(");
						    }
						  login.driver.findElement(By.xpath("//div[@class='movable-modal--close']")).click();
				 
		 
		 }
	}

		@Given("^Successfully Verify India Premium databases like \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" under Product$")
		public void successfully_Verify_India_Premium_databases_like_under_Product(String arg1, String arg2, String arg3) throws Throwable {
			Thread.sleep(1500); 
			 String Y = login.driver.findElement(By.xpath("//div[@class='header-menu-products--premium-body']/div/div[3]/div[1]")).getText();
			    System.out.println(Y);
			 if(arg1.equalsIgnoreCase(arg1)){
			  WebElement India_PremiumDatabase_Explore_data = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("India_PremiumDatabase_Explore_data")));
				 login.Log4j.info("Is 'India_PremiumDatabase_Explore_data' Displayed? - True/False:: " + India_PremiumDatabase_Explore_data.isDisplayed());
				  Assert.assertEquals(true,India_PremiumDatabase_Explore_data.isDisplayed());
				  Thread.sleep(4500); 
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("India_PremiumDatabase_Explore_data"))).click();
				  Thread.sleep(4500); 
				  ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
				    login.driver.switchTo().window(tabs2.get(1));
				    Thread.sleep(4500); 
				    WebElement India_PremiumDatabase_india_in_Newinsight = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("India_PremiumDatabase_india_in_Newinsight")));
					 login.Log4j.info("Is 'India_PremiumDatabase_india_in_Newinsight' Displayed? - True/False:: " + India_PremiumDatabase_india_in_Newinsight.isDisplayed());
					  Assert.assertEquals(true,India_PremiumDatabase_india_in_Newinsight.isDisplayed());
					  String X = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("India_PremiumDatabase_india_in_Newinsight"))).getText();
					  System.out.println(X);
				    login.driver.close();
				    login.driver.switchTo().window(tabs2.get(0));
				    String s = X;
				    String[] result = s.split(" ", 2);
				    String first = result[0];
				    String rest = result[1];
				    System.out.println("First: " + first);
				    if(first.equalsIgnoreCase(Y)){
				    	  System.out.println( first + ":" + Y );
				    	System.out.println("IPDB Mathched Successfully");
				    }else{
				    	 Assert.fail( "India premium Database Didn't Match in the New insight:-(");
				    }
				  
			 }
			 if(arg2.equalsIgnoreCase(arg2)){
					 Thread.sleep(2500);
						login.driver.findElement(By.xpath("//span[contains(text(),'Products')]")).click();
					  Thread.sleep(3500);
					  WebElement India_PremiumDatabase_Footnotes = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("India_PremiumDatabase_Footnotes")));
						 login.Log4j.info("Is 'India_PremiumDatabase_Footnotes' Displayed? - True/False:: " + India_PremiumDatabase_Footnotes.isDisplayed());
						  Assert.assertEquals(true,India_PremiumDatabase_Footnotes.isDisplayed());
						  Thread.sleep(3500);
						  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("India_PremiumDatabase_Footnotes"))).click();
						  Thread.sleep(3500);
						  String X = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("India_PremiumDatabase_inside_footnotes"))).getText();
						  System.out.println(X);
						//div[@class='footnotes-bread-crumbs']/div/div[1]
						  Thread.sleep(4500); 
						    WebElement India_PremiumDatabase_inside_footnotes = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("India_PremiumDatabase_inside_footnotes")));
							 login.Log4j.info("Is 'India_PremiumDatabase_inside_footnotes' Displayed? - True/False:: " + India_PremiumDatabase_inside_footnotes.isDisplayed());
							  Assert.assertEquals(true,India_PremiumDatabase_inside_footnotes.isDisplayed());
							  Thread.sleep(4500); 
							  String s = X;
							    String[] result = s.split(" ", 2);
							    String first = result[0];
							    String rest = result[1];
							    System.out.println("First: " + first);
							  if(first.equalsIgnoreCase(Y)){
								    System.out.println( first + ":" + Y );
							    	System.out.println("IPDB Mathched Successfully in footnotes");
							    }else{
							    	 Assert.fail( "India Database Didn't Match in the Open footnotes:-(");
							    }
							  login.driver.findElement(By.xpath("//div[@class='movable-modal--close']")).click();
					 
			 
			 }
		}
		
		@Given("^Successfully Verify Russia Premium databases like \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" under Product$")
		public void successfully_Verify_Russia_Premium_databases_like_under_Product(String arg1, String arg2, String arg3) throws Throwable {
			
			Thread.sleep(1500); 
			 String Y = login.driver.findElement(By.xpath("//div[@class='header-menu-products--premium-body']/div/div[4]/div[1]")).getText();
			    System.out.println(Y);
			 if(arg1.equalsIgnoreCase(arg1)){
			  WebElement Russia_PremiumDatabase_Explore_data = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Russia_PremiumDatabase_Explore_data")));
				 login.Log4j.info("Is 'Russia_PremiumDatabase_Explore_data' Displayed? - True/False:: " + Russia_PremiumDatabase_Explore_data.isDisplayed());
				  Assert.assertEquals(true,Russia_PremiumDatabase_Explore_data.isDisplayed());
				  Thread.sleep(4500); 
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Russia_PremiumDatabase_Explore_data"))).click();
				  Thread.sleep(4500); 
				  ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
				    login.driver.switchTo().window(tabs2.get(1));
				    Thread.sleep(4500); 
				    WebElement Russia_PremiumDatabase_russia_in_Newinsight = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Russia_PremiumDatabase_russia_in_Newinsight")));
					 login.Log4j.info("Is 'Russia_PremiumDatabase_russia_in_Newinsight' Displayed? - True/False:: " + Russia_PremiumDatabase_russia_in_Newinsight.isDisplayed());
					  Assert.assertEquals(true,Russia_PremiumDatabase_russia_in_Newinsight.isDisplayed());
					  String X = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Russia_PremiumDatabase_russia_in_Newinsight"))).getText();
					  System.out.println(X);
				    login.driver.close();
				    login.driver.switchTo().window(tabs2.get(0));
				    String s = X;
				    String[] result = s.split(" ", 2);
				    String first = result[0];
				    String rest = result[1];
				    System.out.println("First: " + first);
				    if(first.equalsIgnoreCase(Y)){
				    	  System.out.println( first + ":" + Y );
				    	System.out.println("RPDB Mathched Successfully");
				    }else{
				    	 Assert.fail( "Russia premium Database Didn't Match in the New insight:-(");
				    }
				  
			 }
			 if(arg2.equalsIgnoreCase(arg2)){
					 Thread.sleep(2500);
						login.driver.findElement(By.xpath("//span[contains(text(),'Products')]")).click();
					  Thread.sleep(3500);
					  WebElement Russia_PremiumDatabase_Footnotes = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Russia_PremiumDatabase_Footnotes")));
						 login.Log4j.info("Is 'Russia_PremiumDatabase_Footnotes' Displayed? - True/False:: " + Russia_PremiumDatabase_Footnotes.isDisplayed());
						  Assert.assertEquals(true,Russia_PremiumDatabase_Footnotes.isDisplayed());
						  Thread.sleep(3500);
						  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Russia_PremiumDatabase_Footnotes"))).click();
						  Thread.sleep(3500);
						  String X = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Russia_PremiumDatabase_inside_footnotes"))).getText();
						  System.out.println(X);
						//div[@class='footnotes-bread-crumbs']/div/div[1]
						  Thread.sleep(4500); 
						    WebElement Russia_PremiumDatabase_inside_footnotes = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Russia_PremiumDatabase_inside_footnotes")));
							 login.Log4j.info("Is 'Russia_PremiumDatabase_inside_footnotes' Displayed? - True/False:: " + Russia_PremiumDatabase_inside_footnotes.isDisplayed());
							  Assert.assertEquals(true,Russia_PremiumDatabase_inside_footnotes.isDisplayed());
							  Thread.sleep(4500); 
							  String s = X;
							    String[] result = s.split(" ", 2);
							    String first = result[0];
							    String rest = result[1];
							    System.out.println("First: " + first);
							  if(first.equalsIgnoreCase(Y)){
								    System.out.println( first + ":" + Y );
							    	System.out.println("RPDB Mathched Successfully in footnotes");
							    }else{
							    	 Assert.fail( "Russia Database Didn't Match in the Open footnotes:-(");
							    }
							  login.driver.findElement(By.xpath("//div[@class='movable-modal--close']")).click();
					 
			 
			 }
		}
		
		@Given("^Successfully Verify Indonesia Premium databases like \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" under Product$")
		public void successfully_Verify_Indonesia_Premium_databases_like_under_Product(String arg1, String arg2, String arg3) throws Throwable {
			
			Thread.sleep(1500); 
			 String Y = login.driver.findElement(By.xpath("//div[@class='header-menu-products--premium-body']/div/div[5]/div[1]")).getText();
			    System.out.println(Y);
			 if(arg1.equalsIgnoreCase(arg1)){
			  WebElement Indonesia_PremiumDatabase_Explore_data = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Indonesia_PremiumDatabase_Explore_data")));
				 login.Log4j.info("Is 'Indonesia_PremiumDatabase_Explore_data? - True/False:: " + Indonesia_PremiumDatabase_Explore_data.isDisplayed());
				  Assert.assertEquals(true,Indonesia_PremiumDatabase_Explore_data.isDisplayed());
				  Thread.sleep(4500); 
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Indonesia_PremiumDatabase_Explore_data"))).click();
				  Thread.sleep(4500); 
				  ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
				    login.driver.switchTo().window(tabs2.get(1));
				    Thread.sleep(4500); 
				    WebElement Indonesia_PremiumDatabase_indonesia_in_Newinsight = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Indonesia_PremiumDatabase_indonesia_in_Newinsight")));
					 login.Log4j.info("Is 'Indonesia_PremiumDatabase_indonesia_in_Newinsight' Displayed? - True/False:: " + Indonesia_PremiumDatabase_indonesia_in_Newinsight.isDisplayed());
					  Assert.assertEquals(true,Indonesia_PremiumDatabase_indonesia_in_Newinsight.isDisplayed());
					  String X = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Indonesia_PremiumDatabase_indonesia_in_Newinsight"))).getText();
					  System.out.println(X);
				    login.driver.close();
				    login.driver.switchTo().window(tabs2.get(0));
				    String s = X;
				    String[] result = s.split(" ", 2);
				    String first = result[0];
				    String rest = result[1];
				    System.out.println("First: " + first);
				    if(first.equalsIgnoreCase(Y)){
				    	  System.out.println( first + ":" + Y );
				    	System.out.println("RPDB Mathched Successfully");
				    }else{
				    	 Assert.fail( "Russia premium Database Didn't Match in the New insight:-(");
				    }
				  
			 }
			 if(arg2.equalsIgnoreCase(arg2)){
					 Thread.sleep(2500);
						login.driver.findElement(By.xpath("//span[contains(text(),'Products')]")).click();
					  Thread.sleep(3500);
					  WebElement Indonesia_PremiumDatabase_Footnotes = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Indonesia_PremiumDatabase_Footnotes")));
						 login.Log4j.info("Is 'Indonesia_PremiumDatabase_Footnotes' Displayed? - True/False:: " + Indonesia_PremiumDatabase_Footnotes.isDisplayed());
						  Assert.assertEquals(true,Indonesia_PremiumDatabase_Footnotes.isDisplayed());
						  Thread.sleep(3500);
						  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Indonesia_PremiumDatabase_Footnotes"))).click();
						  Thread.sleep(3500);
						  String X = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Indonesia_PremiumDatabase_inside_footnotes"))).getText();
						  System.out.println(X);
						//div[@class='footnotes-bread-crumbs']/div/div[1]
						  Thread.sleep(4500); 
						    WebElement Indonesia_PremiumDatabase_inside_footnotes = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Indonesia_PremiumDatabase_inside_footnotes")));
							 login.Log4j.info("Is 'Indonesia_PremiumDatabase_inside_footnotes' Displayed? - True/False:: " + Indonesia_PremiumDatabase_inside_footnotes.isDisplayed());
							  Assert.assertEquals(true,Indonesia_PremiumDatabase_inside_footnotes.isDisplayed());
							  Thread.sleep(4500); 
							  String s = X;
							    String[] result = s.split(" ", 2);
							    String first = result[0];
							    String rest = result[1];
							    System.out.println("First: " + first);
							  if(first.equalsIgnoreCase(Y)){
								    System.out.println( first + ":" + Y );
							    	System.out.println("RPDB Mathched Successfully in footnotes");
							    }else{
							    	 Assert.fail( "Russia Database Didn't Match in the Open footnotes:-(");
							    }
							  login.driver.findElement(By.xpath("//div[@class='movable-modal--close']")).click();
					 
			 
			 }
		}
		
		
	
		@Given("^Select Help option$")
		public void select_Help_option() throws Throwable {
			  Thread.sleep(1500); 
			  login.driver.findElement(By.xpath("//span[contains(text(),'Help')]")).click();
			  
		}
/*
		@Given("^Successfully verify the Help option$")
		public void successfully_verify_the_Help_option() throws Throwable {
		   
			//List<WebElement> objLinks = login.driver.findElements(By.xpath("//div[@class='header-menu-help--container']"));
			//System.out.println("Total Insights are : "+objLinks.size());
			//for(int i=0;i<=objLinks.size();i++)
			//System.out.println("Total Insights are : "+objLinks.get(i).getText());
			
			String[] expected = {"Contact Us", "Email Us", "Knowledge Base", "Diagnostics", "Report a problem", "Live Chat", "Video Tutorials","Tours","Quick Start Guide","Search Help","Keyboard Shortcuts","Excel Add-in","API","R","EViews"};
			System.out.println("Total ecpected length : "+expected.length);
			List<WebElement> allOptions = login.driver.findElements(By.xpath("//div[@class='header-menu-help--btn']"));
			System.out.println("Total allOption : "+allOptions.size());
			
			// make sure you found the right number of elements
			//if (expected.length != allOptions.size()) {
			    System.out.println("fail, wrong number of elements found");
		//	}
			// make sure that the value of every <option> element equals the expected value
			for (int i = 0; i < expected.length; i++) {
			    String optionValue = allOptions.get(i).getAttribute("value");
			    if (optionValue.equals(expected[i])) {
			        System.out.println("passed on: " + optionValue);
			    } else {
			        System.out.println("failed on: " + optionValue);
			    }
			}
		}
		*/
		@Given("^Successfully verify the Help option as \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
		public void successfully_verify_the_Help_option_as(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14, String arg15) throws Throwable {
			  Thread.sleep(1500); 
			  if(arg1.equalsIgnoreCase(arg1)){
			  
				  Thread.sleep(1500); 
				  login.driver.findElement(By.xpath("//div[contains(text(),'Contact Us')]")).click();
				  Thread.sleep(5500); 
				  ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
				    login.driver.switchTo().window(tabs2.get(1));
				  
				  if(login.driver.findElements(By.xpath("//div[@class='header-wrapper']/div/h1")).size() != 0){
					  System.out.println("Contact Us Element is Present");
					  }else{
						  Assert.fail("Contact Us Element is Absent");
					  }
				     login.driver.close();
				    login.driver.switchTo().window(tabs2.get(0));
			  }
			  
			  if(arg2.equalsIgnoreCase(arg2)){
				  Thread.sleep(1500); 
				  select_Help_option();
				  Thread.sleep(1500); 
				  login.driver.findElement(By.xpath("//div[contains(text(),'Email Us')]")).click();
				  Thread.sleep(1500); 
				  if(login.driver.findElements(By.xpath("//h4[@class='modal-title sphere-modal__title text-dots']")).size() != 0){
					  System.out.println("Email Us Element is Present");
					  }else{
						  Assert.fail("Email Us Element is Absent");
					  }
				  Thread.sleep(1500); 
				  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
				
			  }
			  if(arg3.equalsIgnoreCase(arg3)){
				  Thread.sleep(1500); 
				  select_Help_option();
				  Thread.sleep(1500); 
				  login.driver.findElement(By.xpath("//div[contains(text(),'Knowledge Base')]")).click();
				  Thread.sleep(5500); 
				  ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
				    login.driver.switchTo().window(tabs2.get(1));
				  if(login.driver.findElements(By.xpath("//h2[@class='heading']")).size() != 0){
					  System.out.println("Knowledge Base Element is Present");
					  }else{
						  Assert.fail("Knowledge Base Element is Absent");
					  }
				  login.driver.close();
				    login.driver.switchTo().window(tabs2.get(0));
			  }
			  if(arg4.equalsIgnoreCase(arg4)){
				  Thread.sleep(1500); 
				  select_Help_option();
				  Thread.sleep(1500); 
				  login.driver.findElement(By.xpath("//a[contains(text(),'Diagnostics')]")).click();
				  Thread.sleep(5500); 
				  ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
				    login.driver.switchTo().window(tabs2.get(1));
			
				  if(login.driver.findElements(By.xpath("//section[@class='header__label']")).size() != 0){
					  System.out.println("Diagnostics Element is Present");
					  }else{
						  Assert.fail("Diagnostics Element is Absent");
					  }
				  login.driver.close();
				    login.driver.switchTo().window(tabs2.get(0));
			  }
			  if(arg5.equalsIgnoreCase(arg5)){
				  Thread.sleep(1500); 
				  select_Help_option();
				  Thread.sleep(1500); 
				  login.driver.findElement(By.xpath("//div[contains(text(),'Report a problem')]")).click();
				  
				  Thread.sleep(1500); 
				  if(login.driver.findElements(By.xpath("//div[@class='report-problem-s--header-title']")).size() != 0){
					  System.out.println(" Report a problem Element is Present");
					  }else{
						  Assert.fail(" Report a problem Element is Absent");
					  }
				  Thread.sleep(1500); 
				  login.driver.findElement(By.xpath("//div[@class='report-problem-s--header-close']")).click();
			  }
			  if(arg6.equalsIgnoreCase(arg6)){
				  Thread.sleep(1500); 
				  select_Help_option();
				  if(login.driver.findElements(By.xpath("//div[contains(text(),'Live Chat')]")).size() != 0){
					  System.out.println(" Live Chat Element is Present");
					  }else{
						  Assert.fail(" Live Chat Element is Absent");
					  }
			  }
			  
			  if(arg7.equalsIgnoreCase(arg7)){
					
				  Thread.sleep(1500); 
				 // select_Help_option();
				  Thread.sleep(1500); 
				  login.driver.findElement(By.xpath("//div[contains(text(),'Video Tutorials')]")).click();
				  
				  Thread.sleep(1500);
				  if(login.driver.findElements(By.xpath("//h4[@class='modal-title sphere-modal__title text-dots']")).size() != 0){
					  System.out.println(" Video Tutorials Element is Present");
					  }else{
						  Assert.fail(" Video Tutorials Element is Absent");
					  }
				  Thread.sleep(1500); 
				  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			  }
			  if(arg8.equalsIgnoreCase(arg8)){
				  Thread.sleep(1500); 
				 // select_Help_option();
				  if(login.driver.findElements(By.xpath("//div[contains(text(),'Tours')]")).size() != 0){
					  System.out.println("Tours Element is Present");
					  }else{
						  Assert.fail("Tours Element is Absent");
					  }
			  }
			  if(arg9.equalsIgnoreCase(arg9)){
				  Thread.sleep(1500); 
				 // select_Help_option();
				  if(login.driver.findElements(By.xpath("//div[contains(text(),'Quick Start Guide')]")).size() != 0){
					  System.out.println("Quick Start Guide Element is Present");
					  }else{
						  Assert.fail("Quick Start Guide Element is Absent");
					  }
			  }
			  if(arg10.equalsIgnoreCase(arg10)){
				  Thread.sleep(1500); 
				  select_Help_option();
				  Thread.sleep(1500); 
				  login.driver.findElement(By.xpath("//div[contains(text(),'Search Help')]")).click();
				  Thread.sleep(1500); 
				  if(login.driver.findElements(By.xpath("//h4[@class='modal-title sphere-modal__title text-dots']")).size() != 0){
					  System.out.println("Search Help Element is Present");
					  }else{
						  Assert.fail("Search Help Element is Absent");
					  }
				  Thread.sleep(1500); 
				  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			  }
			  if(arg11.equalsIgnoreCase(arg11)){
				  Thread.sleep(1500); 
				  select_Help_option();
				  Thread.sleep(1500); 
				  login.driver.findElement(By.xpath("//div[contains(text(),'Keyboard Shortcuts')]")).click();
				  Thread.sleep(1500);
				  if(login.driver.findElements(By.xpath("//h4[@class='modal-title sphere-modal__title text-dots']")).size() != 0){
					  System.out.println("Keyboard Shortcuts Element is Present");
					  }else{
						  Assert.fail("Keyboard Shortcuts Element is Absent");
					  }
				  Thread.sleep(1500); 
				  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			  }
			  if(arg12.equalsIgnoreCase(arg12)){
				  Thread.sleep(1500); 
				  select_Help_option();
				  Thread.sleep(1500); 
				  login.driver.findElement(By.xpath("//div[contains(text(),'Excel Add-in')]")).click();
				  
				  Thread.sleep(1500); 
				  if(login.driver.findElements(By.xpath("//div[@class='tabs__tab-item active']")).size() != 0){
					  System.out.println("Excel Add-in Element is Present");
					  }else{
						  Assert.fail("Excel Add-in Element is Absent");
					  }
				  Thread.sleep(1500); 
				  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			  }
			  
			  if(arg13.equalsIgnoreCase(arg13)){
				  Thread.sleep(1500); 
				  select_Help_option();
				  Thread.sleep(1500); 
				  login.driver.findElement(By.xpath("//div[contains(text(),'API')]")).click();
					
				  if(login.driver.findElements(By.xpath("//div[@class='tabs__tab-item active']")).size() != 0){
					  System.out.println("API Element is Present");
					  }else{
						  Assert.fail("API Element is Absent"); //div[@class='header-menu-help__link'][3]  
					  }
				  Thread.sleep(1500); 
				  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			  }
			  if(arg14.equalsIgnoreCase(arg14)){
				  Thread.sleep(1500); 
				  select_Help_option();
				  Thread.sleep(1500); 
				  login.driver.findElement(By.xpath("//div[@class='header-menu-help--links']/div[3]")).click();
				  Thread.sleep(1500); 
				  if(login.driver.findElements(By.xpath("//div[@class='tabs__tab-item active']")).size() != 0){
					  System.out.println("R Element is Present");
					  }else{
						  Assert.fail("R Element is Absent"); 
					  }
				  Thread.sleep(1500); 
				  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			  }
			  if(arg15.equalsIgnoreCase(arg15)){
				  Thread.sleep(1500); 
				  select_Help_option();
				  Thread.sleep(1500); 
				  login.driver.findElement(By.xpath("//div[contains(text(),'EViews')]")).click();
				  Thread.sleep(1500); 
				  if(login.driver.findElements(By.xpath("//div[@class='tabs__tab-item active']")).size() != 0){
					  System.out.println(" EViews Element is Present");
					  }else{
						  Assert.fail(" EViews Element is Absent"); 
					  }
				  Thread.sleep(1500); 
				  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			  }
			  Thread.sleep(1500);
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}
		
		@Given("^Select the What's New option$")
		public void select_the_What_s_New_option() throws Throwable {
			 Thread.sleep(2500); 
				login.driver.findElement(By.xpath("//div[@class='header-menu-products--footer-link']/div")).click();
		}

		@Given("^Successfully verify the latest data option under what's new$")
		public void successfully_verify_the_latest_data_option_under_what_s_new() throws Throwable {
			 Thread.sleep(2500); 
			 login.driver.findElement(By.xpath("//a[@class='announcements-container--button button button__info button__sm ']")).click();
			 
			 //String Title = login.driver.getTitle();
			 //System.out.println(" Title is " + Title);
			 ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
			    login.driver.switchTo().window(tabs2.get(1));
			    String URL = login.driver.getCurrentUrl();
			    System.out.println(URL);
			    
			    Assert.assertEquals(URL, "https://stage.ceicdata.com/file?path=/custom_files/newsletters/e7d2dd41-172b-4505-90c8-880909647558" );
			    Thread.sleep(8000);
			    //WebElement Whats_new_Ceic_Survey = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Whats_new_Ceic_Survey")));
				// login.Log4j.info("Is 'Whats_new_Ceic_Survey' Displayed? - True/False:: " + Whats_new_Ceic_Survey.isDisplayed());
				 // Assert.assertEquals(true,Whats_new_Ceic_Survey.isDisplayed());
			    login.driver.close();
			    login.driver.switchTo().window(tabs2.get(0));
			    Thread.sleep(8000);
				  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		}
		//announcements-files--list
		
		@Given("^Successfully Verify Product Newsletters$")
		public void successfully_Verify_Product_Newsletters() throws Throwable {
			 Thread.sleep(1500);
			List<WebElement> objLinks = login.driver.findElements(By.xpath("//a[@class='announcements-files--file-link link']"));
			System.out.println("Total Insights are : "+objLinks.size());
			login.driver.findElements(By.xpath("//a[@class='announcements-files--file-link link']"));
			 Thread.sleep(3500);
			for(int i=0;i<=objLinks.size();i++){
				
				String ProductsNewsletter = objLinks.get(i).getText();
				System.out.println("ProductsNewsletter : "+ ProductsNewsletter);
				login.driver.findElement(By.linkText(ProductsNewsletter)).click();
				 ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
				    login.driver.switchTo().window(tabs2.get(1));
				   // String URL = login.driver.getCurrentUrl();
				    //System.out.println(URL);
				    
				   // Assert.assertEquals(URL, "https://stage.ceicdata.com/file?path=/custom_files/newsletters/e7d2dd41-172b-4505-90c8-880909647558" );
				    Thread.sleep(5000);
				    //WebElement Whats_new_Ceic_Survey = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Whats_new_Ceic_Survey")));
					// login.Log4j.info("Is 'Whats_new_Ceic_Survey' Displayed? - True/False:: " + Whats_new_Ceic_Survey.isDisplayed());
					 // Assert.assertEquals(true,Whats_new_Ceic_Survey.isDisplayed());
				    login.driver.close();
				    login.driver.switchTo().window(tabs2.get(0));
				    
			}
		}
		
		@Given("^Select Footnotes option$")
		public void select_Footnotes_option() throws Throwable {
			 Thread.sleep(3500);
			 login.driver.findElement(By.xpath("//div[@class='page-main-header--general-panel']/div[2]/div/div[3]/div/span")).click();
			
			
		}

		@Given("^Successfully Verify Footnotes dropdown$")
		public void successfully_Verify_Footnotes_dropdown() throws Throwable {
			
			Thread.sleep(3500);
			WebElement Footnotes_open = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Footnotes_open")));
			 login.Log4j.info("Is 'Footnotes_open' Displayed? - True/False:: " + Footnotes_open.isDisplayed());
			  Assert.assertEquals(true,Footnotes_open.isDisplayed());
			  Thread.sleep(3500);
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Footnotes_open"))).click();
			  Thread.sleep(3500);
			  
			  if(login.driver.findElements(By.xpath("//span[@class='footnotes-modal--name']")).size() != 0){
				  Thread.sleep(2500);
				  System.out.println("Footnotes opened in current tab Successfully");
				  }else{
					  Assert.fail("Footnotes Did'nt opened in current tab Successfully"); 
				  }
			  Thread.sleep(2500);
			  login.driver.findElement(By.xpath("//div[@class='movable-modal--close']")).click();
			  Thread.sleep(5500);
			  select_Footnotes_option();
			  WebElement Footnotes_open_Newtab = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Footnotes_open_Newtab")));
				 login.Log4j.info("Is 'Footnotes_open_Newtab' Displayed? - True/False:: " + Footnotes_open_Newtab.isDisplayed());
				  Assert.assertEquals(true,Footnotes_open_Newtab.isDisplayed());
				  Thread.sleep(3500);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Footnotes_open_Newtab"))).click();
		
				  ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
				    login.driver.switchTo().window(tabs2.get(1));
				    Thread.sleep(4500); 
				    if(login.driver.findElements(By.xpath("//div[@class='landing-header--title']")).size() != 0){
						  Thread.sleep(2500);
						  System.out.println("Footnotes opened in NEW tab Successfully");
						  }else{
							  Assert.fail("Footnotes Did'nt opened in NEW tab Successfully"); 
						  }
				    login.driver.close();
				    login.driver.switchTo().window(tabs2.get(0));
		}
		@Given("^Select any Insight$")
		public void select_any_Insight() throws Throwable {
			Thread.sleep(1500);
			login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
			 Thread.sleep(3000);
			    Actions action = new Actions(login.driver);
				WebElement we = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
				action.moveToElement(we).build().perform();
		}

		
		@Given("^Successfully Verify Insight title change as \"([^\"]*)\"$")
		public void successfully_Verify_Insight_title_change_as(String arg1) throws Throwable {
			Thread.sleep(1500);
			login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/div[2]")).click();
			Thread.sleep(1500);
			login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/div[1]")).click();
			Thread.sleep(1500);
			login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/div[1]/input")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(1500);
			login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/div[1]/input")).clear();
			Thread.sleep(1500);
			login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/div[1]/input")).sendKeys("TC_IE_32");
			Thread.sleep(1500);
			login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/div[3]")).click();
			Thread.sleep(1500);
			String ChangeInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
			System.out.println(  ChangeInsight +":"+ arg1);
			if (ChangeInsight.equalsIgnoreCase(arg1))
			{
				System.out.println("Changing of Insight title is done Successfully");
				HTML_Report.strTCResult="PASS";
				  HTML_Report.execRemarks="Changing of Insight title is done Successfully";
			  }else
			  {
				  Assert.fail("Changing of Insight title is NOT done Successfully");
				  HTML_Report.strTCResult="FAIL";
				  HTML_Report.execRemarks="Changing of Insight title is NOT done Successfully";
			}
		
		}
		
		@Given("^Select the Star icon$")
		public void select_the_Star_icon() throws Throwable {
			Thread.sleep(1500);
			login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
			Thread.sleep(1500);
			login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[1]/div[1]/div")).click();
			           
		}

		
		@Given("^Successfully Verify favorite icon behavior for insight \"([^\"]*)\"$")
		public void successfully_Verify_favorite_icon_behavior_for_insight(String arg1) throws Throwable {
			Thread.sleep(1500);
			login.driver.findElement(By.xpath("//div[@title='Insights marked by star as favourite']")).click();
			Thread.sleep(1500);
			String FavouriteInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
			System.out.println(  FavouriteInsight +":"+ arg1);
			if(FavouriteInsight.equalsIgnoreCase(arg1))
			{
				System.out.println("Favorite icon behavior is working Successfully");
				HTML_Report.strTCResult="PASS";
				  HTML_Report.execRemarks="Favorite icon behavior is working Successfully ";
			  }
			else
			  {
				  Assert.fail("Favorite icon behavior Did'nt work Successfully");  
					 HTML_Report.strTCResult="FAIL";
					  HTML_Report.execRemarks="Favorite icon behavior Did'nt work Successfully";
			}
			Thread.sleep(2500);
			login.driver.findElement(By.xpath("//div[@title='Insights that you have created']")).click();
			Thread.sleep(2500);
			 select_the_Star_icon();
		}
		
		
		@And("^Successfully Verify favorite icon behavior$")
		public void successfully_Verify_favorite_icon_behavior() throws Throwable {
			Thread.sleep(1500);
			 if(login.driver.findElements(By.xpath("//div[@class='insight-favorite insight-favorite__gray insight-favorite__active']")).size() != 0)
			 {
				  Thread.sleep(2500);
				  System.out.println("Favorite icon Enable Successfully");
					HTML_Report.strTCResult="PASS";
					  HTML_Report.execRemarks="Favorite icon Enable Successfully";
				  }else
				  {
					  Assert.fail("Favorite icon is NOT Enable Successfully"); 
						 HTML_Report.strTCResult="FAIL";
						  HTML_Report.execRemarks="Favorite icon is NOT Enable Successfully";
				  }
			 Thread.sleep(5500);
			 select_the_Star_icon();
			 Thread.sleep(1500);
			
			 if(login.driver.findElements(By.xpath("//div[@class='insights-grid-body']/div[1]/div[1]/div[1]/div")).size() != 0){
				  Thread.sleep(2500);
				  System.out.println("Favorite icon Disable Successfully");
					HTML_Report.strTCResult="PASS";
					  HTML_Report.execRemarks="Favorite icon Disable Successfully";
				  }
			 else
			 { 
					  Assert.fail("Favorite icon is NOT Disable Successfully"); 
						 HTML_Report.strTCResult="FAIL";
						  HTML_Report.execRemarks="Favorite icon is NOT Disable Successfully";
				  }
		}
		
		@Given("^create a insight as \"([^\"]*)\"$")
		public void create_a_insight_as(String arg1) throws Throwable {
			
			Thread.sleep(8500);
			login.driver.findElement(By.xpath("//div[@title='Click to edit the Insight']")).click();
			
			Thread.sleep(10500);
			login.driver.findElement(By.xpath("//div[@class='page-main-header--title-field']/input")).sendKeys(arg1);
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}

		@Given("^Successfully Verify insights under My insights tab as \"([^\"]*)\"$")
		public void successfully_Verify_insights_under_My_insights_tab_as(String arg1) throws Throwable {
			Thread.sleep(1500);
			login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
			Thread.sleep(5500);
			String MYInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
			System.out.println(  MYInsight +":"+ arg1);
			if(MYInsight.equalsIgnoreCase(arg1)){
				System.out.println("Insight had been Created Successfully");
			  }else{
				  Assert.fail("Insight had not been Created Successfully");  
			}
		}
		
		@Given("^create a Insight as \"([^\"]*)\"$")
		public void create_a_Insight_as(String arg1) throws Throwable {
			
			Thread.sleep(8500);
			login.driver.findElement(By.xpath("//div[@title='Click to edit the Insight']")).click();
			
			Thread.sleep(10500);
			login.driver.findElement(By.xpath("//div[@class='page-main-header--title-field']/input")).sendKeys(arg1);
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			
		}

		
		@Given("^Successfully Verify Insights under Recent tab as \"([^\"]*)\"$")
		public void successfully_Verify_Insights_under_Recent_tab_as(String arg1) throws Throwable {
			Thread.sleep(1500);
			login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
			Thread.sleep(2500);
			login.driver.findElement(By.xpath("//div[@title='Insights that you have worked with last time']")).click();
			Thread.sleep(5500);
			String RecentInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
			System.out.println(RecentInsight +":"+ arg1);
			if(RecentInsight.equalsIgnoreCase(arg1))
			{
				System.out.println("Recent Insight under Recent tab has been Verified Successfully");
				HTML_Report.strTCResult="PASS";
				  HTML_Report.execRemarks="Recent Insight under Recent tab has been Verified Successfully";
			  }else
			  {
				  Assert.fail("Recent Insight under Recent tab has not been Verified Successfully");  
					 HTML_Report.strTCResult="FAIL";
					  HTML_Report.execRemarks="Recent Insight under Recent tab has not been Verified Successfully!!!";
			}
		}
		
		@Given("^Select the View Comments option$")
		public void select_the_View_Comments_option() throws Throwable {
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MyInsight_Tab_inLandingPage"))).click();
			Thread.sleep(2500);
			login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
			Thread.sleep(2500);
			login.driver.findElement(By.xpath("//div[@class='comments-menu dropdown dropdown__right']")).click();
			Thread.sleep(2500);
			login.driver.findElement(By.xpath("//div[@class='comments-menu dropdown dropdown__right dropdown__open']/div/a")).click();
			
			
		}

		@Given("^Successfully Verify Comments option is working$")
		public void successfully_Verify_Comments_option_is_working() throws Throwable {
			Thread.sleep(4500);
			 if(login.driver.findElements(By.xpath("//div[contains(text(),'Comments')]")).size() != 0){
				  Thread.sleep(2500);
				  System.out.println("Comments Functionality is working Successfully");
				  }else{
					  Assert.fail("Comments Functionality is NOT working Successfully.ITS A BUG"); 
				  }
			    Thread.sleep(500);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}
		
		@Given("^Select the Notification  option$")
		public void select_the_Notification_option() throws Throwable {
			Thread.sleep(2500);
			login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
			Thread.sleep(2500);
			login.driver.findElement(By.xpath("//div[@class='notifications-menu dropdown dropdown__right']")).click();
			Thread.sleep(2500);
			login.driver.findElement(By.xpath("//div[@class='notifications-menu dropdown dropdown__right dropdown__open']/div/a")).click();
			
			
		}

		@Given("^Successfully Verify Notification option is working$")
		public void successfully_Verify_Notification_option_is_working() throws Throwable {
			Thread.sleep(4500);
			 if(login.driver.findElements(By.xpath("//div[contains (text(),'Notifications')]")).size() != 0){
				  Thread.sleep(2500);
				  System.out.println("Notifications Functionality is working Successfully");
				  }else{
					  Assert.fail("Notifications Functionality is NOT working Successfully.ITS A BUG"); 
				  }
			    Thread.sleep(500);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}
		@Given("^Select the profile dropdown$")
		public void select_the_profile_dropdown() throws Throwable {
			Thread.sleep(2500);
			login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
			Thread.sleep(2500);
			login.driver.findElement(By.xpath("//div[@class='user-avatar -default -small']")).click();
			
		}

		@Given("^Successfully Verify profile dropdown as \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
		public void successfully_Verify_profile_dropdown_as(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10) throws Throwable {
			Thread.sleep(2500);
			 if(arg1.equalsIgnoreCase(arg1)){
				 Thread.sleep(2500);
			String Uname = login.driver.findElement(By.xpath("//span[@class='account-popup--header-name']")).getText();
				 String Emailnameindrop = login.driver.findElement(By.xpath("//span[@class='account-popup--header-email']")).getText();
				  String Unameindrop = Uname;
				    String[] result = Unameindrop.split(" ", 2);
				    String first = result[0];
				  //  String rest = result[1];
				    //System.out.println("First: " + first);
				 login.driver.findElement(By.xpath("//span[@class='account-popup--header-name']")).click();
				 Thread.sleep(2500);
				 String Unameinprofile =  login.driver.findElement(By.xpath("//div[@class='profile-box']/div/div[2]/div[2]/input")).getAttribute("value");
			
				 System.out.println(  first +":"+ Unameinprofile);
					if(first.equalsIgnoreCase(Unameinprofile)){
						System.out.println("User Name is Verified Successfully");
					  }else{
						  Assert.fail("User Name Verification is  UnSuccessfull");  
					}
					 Thread.sleep(5500);
					 String Emailinprofile =  login.driver.findElement(By.xpath("//div[@class='profile-box']/div/div[4]/div[2]/input")).getAttribute("value");
					
					 System.out.println(  Emailnameindrop +":"+ Emailinprofile);
					 if(Emailnameindrop.equalsIgnoreCase(Emailinprofile)){
							System.out.println("Email is Verified Successfully");
						  }else{
							  Assert.fail("Email Verification is  UnSuccessfull");  
						}
					 Thread.sleep(500);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 }
			 
			 /*
			 if(arg2.equalsIgnoreCase(arg2)){
				 Thread.sleep(2500);
				 select_the_profile_dropdown();
				 Thread.sleep(2500);
				 String[] expected = {"中文", "日本語", "한국어", "Русский", "Bahasa"};
				 List<WebElement> allOptions = login.driver.findElements(By.xpath("//div[@class='languages-item -action']"));

				 // make sure you found the right number of elements
				 if (expected.length != allOptions.size()) {
				     System.out.println("fail, wrong number of elements found");
				 }
				 // make sure that the value of every <option> element equals the expected value
				 for (int i = 0; i < expected.length; i++) {
				     String optionValue = allOptions.get(i).getAttribute("value");
				     if (optionValue.equals(expected[i])) {
				         System.out.println("passed on: " + optionValue);
				     } else {
				         System.out.println("failed on: " + optionValue);
				     }
				 }
				 //languages-item -action 
			 }
			  */
			 if(arg3.equalsIgnoreCase(arg3)){
				 Thread.sleep(2500);
				 select_the_profile_dropdown();
				 Thread.sleep(2500);
				 login.driver.findElement(By.xpath("//div[@class='account-menu--dropdown dropdown--body']/div/div[2]")).click();
				 Thread.sleep(2500);
				 if(login.driver.findElements(By.xpath("//div[@class='user-profile-account']/div/div[1]/div[1]/div")).size() != 0){
					  Thread.sleep(2500);
					  System.out.println("Opening Profile is working Successfully");
					  }else{
						  Assert.fail("Opening Profile is NOT working Successfully.ITS A BUG"); 
					  }
				 Thread.sleep(500);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
				
			 }
			 if(arg4.equalsIgnoreCase(arg4)){
				 Thread.sleep(2500);
				 select_the_profile_dropdown();
				 Thread.sleep(2500);
				 login.driver.findElement(By.xpath("//div[@class='account-menu--dropdown dropdown--body']/div/div[3]")).click();
				 Thread.sleep(2500);
				 if(login.driver.findElements(By.xpath("//div[@class='user-profile-account']/div/div[2]/div[1]/div")).size() != 0){
					  Thread.sleep(2500);
					  System.out.println("Change Password is working Successfully");
					  }else{
						  Assert.fail("Change Password is NOT working Successfully.ITS A BUG"); 
					  }
				 
				 Thread.sleep(500);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 }
			 if(arg5.equalsIgnoreCase(arg5)){
				 Thread.sleep(2500);
				 select_the_profile_dropdown();
				 Thread.sleep(2500);
				 login.driver.findElement(By.xpath("//div[@class='account-menu--dropdown dropdown--body']/div/div[4]")).click();
				 Thread.sleep(2500);
				 if(login.driver.findElements(By.xpath("//div[@class='user-profile-account']/div/div[3]/div[1]/div")).size() != 0){
					  Thread.sleep(2500);
					  System.out.println("Preferences is working Successfully");
					  }else{
						  Assert.fail("Preferences is NOT working Successfully.ITS A BUG"); 
					  }
				 
				 Thread.sleep(500);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 }
			 
			 if(arg6.equalsIgnoreCase(arg6)){
				 Thread.sleep(2500);
				 select_the_profile_dropdown();
				 Thread.sleep(2500);
				 login.driver.findElement(By.xpath("//div[@class='account-menu--dropdown dropdown--body']/div/div[5]")).click();
				 Thread.sleep(2500);
				 if(login.driver.findElements(By.xpath("//div[@class='user-profile-account']/div/div[4]/div[1]/div")).size() != 0){
					  Thread.sleep(2500);
					  System.out.println("Regional Formats is working Successfully");
					  }else{
						  Assert.fail("RegionalFormats is NOT working Successfully.ITS A BUG"); 
					  }
				 
				 Thread.sleep(500);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 }
			 if(arg7.equalsIgnoreCase(arg7)){
				 Thread.sleep(2500);
				 select_the_profile_dropdown();
				 
				 Thread.sleep(2500);
				 if(login.driver.findElements(By.xpath("//div[@class='account-popup--shortcuts-title']")).size() != 0){
					  Thread.sleep(2500);
					  login.driver.findElement(By.xpath("//div[@class='account-popup--shortcuts-wrapper']/div[2]/span[2]")).click();
					  Thread.sleep(2500);
					
					  System.out.println("Keybord shortcuts is working Successfully");
					  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
					  }else{
						  Assert.fail("Keybord shortcuts is NOT working Successfully.ITS A BUG"); 
					  }
				 
				 Thread.sleep(500);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 }
			 if(arg8.equalsIgnoreCase(arg8)){
				 Thread.sleep(2500);
				 select_the_profile_dropdown();
				 Thread.sleep(2500);
				 login.driver.findElement(By.xpath("//span[contains(text(),'Excel Add-in')]")).click();
				 Thread.sleep(2500);
				 if(login.driver.findElements(By.xpath("//div[@class='tabs__tab-item active']")).size() != 0){
					 
					  System.out.println("Excel Addin is working Successfully");
					  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
					  }else{
						  Assert.fail("Excel Addin is NOT working Successfully.ITS A BUG"); 
					  }
				 
				 Thread.sleep(500);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 }
			 if(arg9.equalsIgnoreCase(arg9)){
				 Thread.sleep(2500);
				 select_the_profile_dropdown();
				 Thread.sleep(2500);
				 login.driver.findElement(By.xpath("//span[contains(text(),'CEIC API Access')]")).click();
				 Thread.sleep(2500);
				 if(login.driver.findElements(By.xpath("//h4[@class='modal-title sphere-modal__title text-dots']")).size() != 0){
					 
					  System.out.println("CEIC API Access is working Successfully");
					  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
					  }else{
						  Assert.fail("CEIC API Access is NOT working Successfully.ITS A BUG"); 
					  }
				 
				 Thread.sleep(500);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 }
			 if(arg10.equalsIgnoreCase(arg10)){
				 Thread.sleep(2500);
				 select_the_profile_dropdown();
				
				 Thread.sleep(2500);
				 WebElement logout = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("logout")));
				 login.Log4j.info("Is 'logout' Displayed? - True/False:: " + logout.isDisplayed());
				  Assert.assertEquals(true,logout.isDisplayed());
				 
				 Thread.sleep(500);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 }
			 
		}
		@Given("^Select Preferences option$")
		public void select_Preferences_option() throws Throwable {
			 Thread.sleep(2500);
			 select_the_profile_dropdown();
			 Thread.sleep(2500);
			 login.driver.findElement(By.xpath("//div[@class='account-menu--dropdown dropdown--body']/div/div[3]")).click();
		}

		@Given("^Successfully Verify Back button is working$")
		public void successfully_Verify_Back_button_is_working() throws Throwable {
			 Thread.sleep(2500);
			 
			//div[contains(text(),'User Profile')]
			 String TEXT1 = login.driver.findElement(By.xpath("//div[@class='profile-box']/div/div[2]/div[2]/input")).getText();
			
			 Thread.sleep(5000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
				Thread.sleep(4500);
				login.driver.findElement(By.xpath("	//div[@class='page-main-header--general-panel']/div/button/i")).click();
				Thread.sleep(4500);

				 String TEXT2 = login.driver.findElement(By.xpath("//div[@class='profile-box']/div/div[2]/div[2]/input")).getText();
				 System.out.println(  TEXT1 +":"+ TEXT2);
				 if(TEXT1.equalsIgnoreCase(TEXT2)){
					 
						  System.out.println("Back Button is working Successfully");
						 
						  }else{
							  Assert.fail("Back Button is NOT working Successfully.ITS A BUG"); 
						  }
					 
					 Thread.sleep(500);
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
				 }
			
		@Given("^Select Folder panel option$")
		public void select_Folder_panel_option() throws Throwable {
			Thread.sleep(2500);
			login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
			Thread.sleep(5500);
			login.driver.findElement(By.xpath("//div[@class='insights-tree-toggle-right fa fa-angle-right']")).click();
			
		}

		@Given("^Select Migrated Insight$")
		public void select_Migrated_Insight() throws Throwable {
			Thread.sleep(5500);
			login.driver.findElement(By.xpath("//*[@id='landing_page']/div[2]/div/div[3]/div[1]/div[5]/div[2]")).click();
			
		}

		@Given("^Successfully Verify Folders having Insights$")
		public void successfully_Verify_Folders_having_Insights() throws Throwable {
			Thread.sleep(5500);
			String InsightCount = login.driver.findElement(By.xpath("//div[@title='Insights that you have created']/span[4]/span")).getText();
			  System.out.println(InsightCount);
			  String myString = InsightCount;
			  int Result = Integer.parseInt(myString);
			  
			List<WebElement> objLinks = login.driver.findElements(By.xpath("//a[@class='link insights-grid-row--title-link']"));
			System.out.println(objLinks.size());
			 System.out.println(InsightCount +":"+ objLinks.size());
			  
			 if(Result == objLinks.size()){
				 
				  System.out.println("Back Button is working Successfully");
				 
				  }else{
					  Assert.fail("Back Button is NOT working Successfully.ITS A BUG"); 
				  }
			 
			 Thread.sleep(1500);
				login.driver.findElement(By.xpath("//div[@class='insights-breadcrumbs']/div[1]")).click();
				 Thread.sleep(3500);
					login.driver.findElement(By.xpath("//div[@class='insights-tree-toggle-left fa fa-angle-left']")).click();	
				
		 }
			
		@Given("^Select New Folder option$")
		public void select_New_Folder_option() throws Throwable {
			Thread.sleep(3500);
			login.driver.findElement(By.xpath("//div[@class='insights-tree-header']/div[1]")).click();
			Thread.sleep(3500);
			login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']/div[1]/input")).click();
		}

		@Given("^Successfully Verify New Folders is created As \"([^\"]*)\"$")
		public void successfully_Verify_New_Folders_is_created_As(String arg1) throws Throwable {
			Thread.sleep(3500);
			login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']/div[1]/input")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(3500);
			login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']/div[1]/input")).clear();
			Thread.sleep(3500);
			login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']/div[1]/input")).sendKeys(arg1);
			Thread.sleep(3500);
			login.driver.findElement(By.xpath("//button[contains(text(),'Create folder')]")).click();
			Thread.sleep(3500);
			String Foldername = login.driver.findElement(By.xpath("//div[@class='insights-tree-node-name']")).getText();
			 System.out.println(Foldername +":"+ arg1);
			 if(Foldername.equalsIgnoreCase(arg1)){
				 
				  System.out.println("Folder is created Successfully");
				 
				  }else{
					  Assert.fail("Folder is NOT created Successfully.ITS A BUG"); 
				  }
			 
		}
		@Given("^Successfully Verify Empty folder$")
		public void successfully_Verify_Empty_folder() throws Throwable {
			 Thread.sleep(2500);
			 if(login.driver.findElements(By.xpath("//div[contains(text(),'Insights created or owned by you')]")).size() != 0){
				 
				  System.out.println("Empty folder verified Successfully");
				  Thread.sleep(3500);
					login.driver.findElement(By.xpath("//span[contains(text(),'Create new Insight')]")).click();
					 Thread.sleep(3500);
						login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']/div/input")).click();
						Thread.sleep(3500);
						login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']/div[1]/input")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
						Thread.sleep(3500);
						login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']/div[1]/input")).clear();
						Thread.sleep(3500);
						String X = "TC_IE_43" ;
						login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']/div[1]/input")).sendKeys(X);
						Thread.sleep(3500);
						login.driver.findElement(By.xpath("//button[contains(text(),'Create insight')]")).click();
						 Thread.sleep(5000);
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
							Thread.sleep(3500);
							select_Folder_panel_option();
							Thread.sleep(3500);
							String Insightcreated = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
							
						Thread.sleep(3500);
						 System.out.println(Insightcreated +":"+ X);
						 if(Insightcreated.equalsIgnoreCase(X)){
							 
							  System.out.println("Insight had created Successfully");
							 
							  }else{
								  Assert.fail("Insight had not created Successfully.ITS A BUG"); 
							  }
				  }else{
					  Assert.fail("Empty folder Functionality is NOT verified Successfully.ITS A BUG"); 
				  }
			 
			
		}
		
		
		@Given("^Select Right click options on folder$")
		public void select_Right_click_options_on_folder() throws Throwable {
			Thread.sleep(3500);
			Actions action = new Actions(login.driver);
			WebElement Rightcliclfolder = login.driver.findElement(By.xpath("//div[@class='insights-tree-node-name']"));
			action.contextClick(Rightcliclfolder).build().perform();
		}

		@Given("^Successfully Verify  Right click options as \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" on folder$")
		public void successfully_Verify_Right_click_options_as_on_folder(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) throws Throwable {
			 Thread.sleep(1500); 
			  if(arg1.equalsIgnoreCase(arg1)){
			
				  if(login.driver.findElements(By.xpath("//span[contains(text(),'Rename')]")).size() != 0){
					  System.out.println("Rename Option is Present");
					  }else{
						  Assert.fail("Rename Option is Absent");
					  }
			  }
			  
			  if(arg2.equalsIgnoreCase(arg2)){
					
				  if(login.driver.findElements(By.xpath("//span[contains(text(),'New folder')]")).size() != 0){
					  System.out.println("New folder Option is Present");
					  }else{
						  Assert.fail("New folder Option is Absent");
					  }
			  }
			  if(arg3.equalsIgnoreCase(arg3)){
					
				  if(login.driver.findElements(By.xpath("//span[contains(text(),'New insight')]")).size() != 0){
					  System.out.println("New Insight Option is Present");
					  }else{
						  Assert.fail("New Insight Option is Absent");
					  }
			  }
			  if(arg4.equalsIgnoreCase(arg4)){
					
				  if(login.driver.findElements(By.xpath("//div[@class='items-wrapper']/li[4]")).size() != 0){
					  System.out.println("Share Option is Present");
					  }else{
						  Assert.fail("Share Option is Absent");
					  }
			  }
			  if(arg5.equalsIgnoreCase(arg5)){
					
				  if(login.driver.findElements(By.xpath("//span[contains(text(),'Add tags')]")).size() != 0){
					  System.out.println("Add tags Options is Present");
					  }else{
						  Assert.fail("Add tags Options is is Absent");
					  }
			  }
			  if(arg6.equalsIgnoreCase(arg6)){
					
				  if(login.driver.findElements(By.xpath("//span[contains(text(),'Delete folder')]")).size() != 0){
					  System.out.println("Delete folder Options is Present");
					  }else{
						  Assert.fail("Delete folder Options is Absent");
					  }
			  }
			  
			  
		}
		@Given("^Select Rename option$")
		public void select_Rename_option() throws Throwable {
			Thread.sleep(6500); 
			login.driver.findElement(By.xpath("//span[contains(text(),'Rename')]")).click();
		}
		
		@Given("^Rename folder name as \"([^\"]*)\"$")
		public void rename_folder_name_as(String arg1) throws Throwable {
			
			 Thread.sleep(3500);
				login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']/div/input")).click();
				Thread.sleep(3500);
				login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']/div[1]/input")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
				Thread.sleep(3500);
				login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']/div[1]/input")).clear();
				Thread.sleep(3500);
				login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']/div[1]/input")).sendKeys(arg1);
				Thread.sleep(3500);
				login.driver.findElement(By.xpath("//button[contains(text(),'Rename folder')]")).click();
		}

		@Given("^Successfully Verify Rename folder name as \"([^\"]*)\"$")
		public void successfully_Verify_Rename_folder_name_as(String arg1) throws Throwable {
			Thread.sleep(6500); 
			String Y = login.driver.findElement(By.xpath("//div[@class='insights-tree-node-name']")).getText();
			Thread.sleep(3500);
			 System.out.println(Y +":"+ arg1);
			 if(Y.equalsIgnoreCase(arg1)){
				 
				  System.out.println("Rename of folder is done Successfully");
				 
				  }else{
					  Assert.fail("Rename of folder is NOT done Successfully.ITS A BUG"); 
				  }
		}
		@Given("^Select New Folder option in right click$")
		public void select_New_Folder_option_in_right_click() throws Throwable {
			Thread.sleep(6500); 
			login.driver.findElement(By.xpath("//span[contains(text(),'New folder')]")).click();
			Thread.sleep(3500);
			login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']/div[1]/input")).click();
			Thread.sleep(3500);
			login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']/div[1]/input")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(3500);
			login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']/div[1]/input")).clear();
			
		}

		@Given("^Successfully Verify New Folders is created under Existing Folder As \"([^\"]*)\"$")
		public void successfully_Verify_New_Folders_is_created_under_Existing_Folder_As(String arg1) throws Throwable {
			Thread.sleep(3500);
			login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']/div[1]/input")).sendKeys(arg1);
			Thread.sleep(3500);
			login.driver.findElement(By.xpath("//button[contains(text(),'Create folder')]")).click();
			Thread.sleep(13500);
			login.driver.findElement(By.xpath("//*[@id='landing_page']/div[2]/div[2]/div/div[1]/div[3]/div[1]")).click();
			Thread.sleep(3500);
			String Y = login.driver.findElement(By.xpath(" //*[@id='landing_page']/div[2]/div[2]/div/div[1]/div[4]/div[2]")).getText();
			 System.out.println(Y +":"+ arg1);
			 if(Y.equalsIgnoreCase(arg1)){
				 
				  System.out.println("Folder is created under the existing Folder Successfully");
				 
				  }else{
					  Assert.fail("Folder is NOT created under the existing Folder Successfully.Check the Issue"); 
				  }
		}
		
		@Given("^Select New Insights option in right click$")
		public void select_New_Insights_option_in_right_click() throws Throwable {
			Thread.sleep(6500); 
			login.driver.findElement(By.xpath("//span[contains(text(),'New insight')]")).click();
		}

		@Given("^Successfully Verify New Insights is created As \"([^\"]*)\"$")
		public void successfully_Verify_New_Insights_is_created_As(String arg1) throws Throwable {
			 Thread.sleep(3500);
				login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']/div/input")).click();
				Thread.sleep(3500);
				login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']/div[1]/input")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
				Thread.sleep(3500);
				login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']/div[1]/input")).clear();
				Thread.sleep(3500);
				login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']/div[1]/input")).sendKeys(arg1);
				Thread.sleep(3500);
				login.driver.findElement(By.xpath("//button[contains(text(),'Create insight')]")).click();
				Thread.sleep(3500);
				String Insightcreated = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
				
			Thread.sleep(3500);
			 System.out.println(Insightcreated +":"+ arg1);
			 if(Insightcreated.equalsIgnoreCase(arg1)){
				 
				  System.out.println("Insight had created Successfully under Right click Option");
				 
				  }else{
					  Assert.fail("Insight had not created Successfully."); 
				  }
		}
		@Given("^Select Add tags option in right click$")
		public void select_Add_tags_option_in_right_click() throws Throwable {
			Thread.sleep(6500); 
			login.driver.findElement(By.xpath("//span[contains(text(),'Add tags')]")).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//div[@class='form-group']")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//input[@class='ui-widget-content ui-autocomplete-input']")).sendKeys("AddedTag");
			Thread.sleep(500);
			login.driver.findElement(By.xpath("//div[@class='modal-header sphere-modal__header']")).click();
			Thread.sleep(500);
			login.driver.findElement(By.xpath("//div[@class='sphere-modal-controls']/button[2]")).click();
			
		}

		@Given("^Successfully Verify Add tags option is working$")
		public void successfully_Verify_Add_tags_option_is_working() throws Throwable {
			Thread.sleep(5500);
			login.driver.findElement(By.xpath("//div[@class='insights-search-left-panel']/div[2]")).click();
			Thread.sleep(1500);
			login.driver.findElement(By.xpath("//span[contains(text(),'AddedTag')]")).click();
			String Text1 =login.driver.findElement(By.xpath("//span[contains(text(),'AddedTag')]")).getText();
			System.out.println("Text1- " + Text1);
			Thread.sleep(2500);
			Actions action = new Actions(login.driver);
			WebElement AddTag = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
			action.contextClick(AddTag).build().perform();
			login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu arrow-up']/div[3]/li[8]")).click();
			Thread.sleep(1500);
			WebElement AddedTag = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("AddedTag")));
			Assert.assertEquals(true,AddedTag.isDisplayed());
			String Text2 =login.driver.findElement(By.xpath("//span[@class='tagit-label']")).getText();
			System.out.println("Text2- " + Text2);	
			
			if(Text1.equalsIgnoreCase(Text2)){
				System.out.println("Adding of Tag is Verified Successfully");
			}
			else{
				 Assert.fail( "Adding of Tag is  UnSuccessfully and It's BUG.");
			}
			Thread.sleep(1500);
			login.driver.findElement(By.xpath("//span[@class='text-icon']")).click();
			Thread.sleep(1500);
			login.driver.findElement(By.xpath("//div[@class='sphere-modal-controls']/button[2]")).click();
			Thread.sleep(1500);
			login.driver.findElement(By.xpath("//div[@class='insights-search-left-panel']/div[2]/div/div/div/div/span")).click();
		}
		
		@Given("^Select Delete folder option in right click$")
		public void select_Delete_folder_option_in_right_click() throws Throwable {
			Thread.sleep(1500);
			select_Right_click_options_on_folder();
			Thread.sleep(10500);
			login.driver.findElement(By.xpath("//span[contains(text(),'Delete folder')]")).click();
		}

		@Given("^Successfully Verify Delete folder option is working$")
		public void successfully_Verify_Delete_folder_option_is_working() throws Throwable {
			
			List<WebElement> objLinks = login.driver.findElements(By.xpath("//div[@class='insights-tree-node-name']"));
			System.out.println("Total Folders are- " + objLinks.size());
			int X=objLinks.size();
			Thread.sleep(1500);
			//select_Delete_folder_option_in_right_click();
			Thread.sleep(15500);
			login.driver.findElement(By.xpath("//button[contains(text(),'Delete forever')]")).click();
			Thread.sleep(15500);
			List<WebElement> objLinks2 = login.driver.findElements(By.xpath("//div[@class='insights-tree-node-name']"));
			System.out.println("Total Folders are- " + objLinks2.size());
			int Y=objLinks2.size();
			if(X > Y){
				System.out.println("Deleation of Folder is done Successfully");
			}
			else{
				 Assert.fail("Deleation of Folder is NOT done Successfully and It's BUG.");
			}
			}
				
		@Given("^Select Right click options on Insight$")
		public void select_Right_click_options_on_Insight() throws Throwable {
			Thread.sleep(2500);
			login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
			Thread.sleep(3500);
			Actions action = new Actions(login.driver);
			WebElement AddTag = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
			action.contextClick(AddTag).build().perform();
		}

		@Given("^Successfully Verify  Right click options as \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
		public void successfully_Verify_Right_click_options_as(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8) throws Throwable {
			 Thread.sleep(1500); 
			  if(arg1.equalsIgnoreCase(arg1)){
			
				  if(login.driver.findElements(By.xpath("//span[contains(text(),'View')]")).size() != 0){
					  System.out.println("View Option is Present");
					  }else{
						  Assert.fail("View Option is Absent");
					  }
			  }
			  
			  if(arg2.equalsIgnoreCase(arg2)){  
				                                         
				  if(login.driver.findElements(By.xpath("//div[@class='items-wrapper']/li[2]")).size() != 0){
					  System.out.println("Open Option is Present");
					  }else{
						  Assert.fail("Open Option is Absent");
					  }
			  }
			  if(arg3.equalsIgnoreCase(arg3)){
					
				  if(login.driver.findElements(By.xpath("//div[@class='items-wrapper']/li[3]")).size() != 0){
					  System.out.println("Open in New Tab Option is Present");
					  }else{
						  Assert.fail("Open in New Tab Option is Absent");
					  }
			  }
			  if(arg4.equalsIgnoreCase(arg4)){
					
				  if(login.driver.findElements(By.xpath("//span[contains(text(),'Copy')]")).size() != 0){
					  System.out.println("Copy Option is Present");
					  }else{
						  Assert.fail("Copy Option is Absent");
					  }
			  }
			  if(arg5.equalsIgnoreCase(arg5)){
					
				  if(login.driver.findElements(By.xpath("//div[@class='items-wrapper']/li[7]")).size() != 0){
					  System.out.println("Share Options is Present");
					  }else{
						  Assert.fail("Share Options is is Absent");
					  }
			  }
			  if(arg6.equalsIgnoreCase(arg6)){
					
				  if(login.driver.findElements(By.xpath("//div[@class='items-wrapper']/li[8]")).size() != 0){
					  System.out.println("Move to Options is Present");
					  }else{
						  Assert.fail("Move to Options is Absent");
					  }
			  }
				  if(arg7.equalsIgnoreCase(arg7)){
						
					  if(login.driver.findElements(By.xpath("//div[@class='items-wrapper']/li[9]")).size() != 0){
						  System.out.println("Add Tag Options is Present");
						  }else{
							  Assert.fail("Add Tag Options is Absent");
						  }
			  }
				  if(arg8.equalsIgnoreCase(arg8)){
						
					  if(login.driver.findElements(By.xpath("//div[@class='items-wrapper']/li[10]")).size() != 0){
						  System.out.println("Delete Options is Present");
						  }else{
							  Assert.fail("Delete Options is Absent");
						  }
			  }
		}
		@Given("^Select View options$")
		public void select_View_options() throws Throwable {
			Thread.sleep(2500);
			login.driver.findElement(By.xpath("//span[contains(text(),'View')]")).click();
		}

		@Given("^Successfully Verify View insight option is working$")
		public void successfully_Verify_View_insight_option_is_working() throws Throwable {
			Thread.sleep(2500);
			successfully_Verify_View_insight();
		}
		@Given("^Select Open options$")
		public void select_Open_options() throws Throwable {
			Thread.sleep(2500);
			login.driver.findElement(By.xpath("//div[@class='items-wrapper']/li[2]")).click();
		}

		@Given("^Successfully Verify Open insight option is working$")
		public void successfully_Verify_Open_insight_option_is_working() throws Throwable {
			Thread.sleep(2500);
			  WebElement btnDownload = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("btnDownload")));
				 login.Log4j.info("Is 'btnDownload' Displayed? - True/False:: " + btnDownload.isDisplayed());
				  Assert.assertEquals(true,btnDownload.isDisplayed());
				  Thread.sleep(5500);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}
		@Given("^Select Open in new tab options$")
		public void select_Open_in_new_tab_options() throws Throwable {
			Thread.sleep(2500);
			login.driver.findElement(By.xpath("//div[@class='items-wrapper']/li[3]")).click();
		}

		@Given("^Successfully Verify Open in new tab insight option is working$")
		public void successfully_Verify_Open_in_new_tab_insight_option_is_working() throws Throwable {
			Thread.sleep(2500);
			  ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
			    login.driver.switchTo().window(tabs2.get(1));
			    Thread.sleep(4500); 
			    WebElement btnDownload = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("btnDownload")));
				 login.Log4j.info("Is 'btnDownload' Displayed? - True/False:: " + btnDownload.isDisplayed());
				  Assert.assertEquals(true,btnDownload.isDisplayed());
			    login.driver.close();
			    login.driver.switchTo().window(tabs2.get(0));
		}
		@Given("^Select Copy options$")
		public void select_Copy_options() throws Throwable {
			Thread.sleep(2500);
			login.driver.findElement(By.xpath("//span[contains(text(),'Copy')]")).click();
		}

		@Given("^Successfully Verify Copy insight option is working$")
		public void successfully_Verify_Copy_insight_option_is_working() throws Throwable {
			Thread.sleep(2500);
			login.driver.findElement(By.xpath("//button[contains(text(),'Copy Insight')]")).click();
			Thread.sleep(2500);
			String CopyInsight = login.driver.findElement(By.xpath("//div[@title='Click to edit the Insight']")).getText();
			  Thread.sleep(5500);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
				 Thread.sleep(5500);
				
				String IECopyInsight = 	login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
				
				 System.out.println(CopyInsight +":"+ IECopyInsight);
				 if(CopyInsight.equalsIgnoreCase(IECopyInsight)   ) {
					 System.out.println("Copying Functionality is working Succesfully");
				  }else{
					  Assert.fail("Copying Functionality is NOT working Succesfully");
				  }
				
				 }
		
		@Given("^Select Add Tag options$")
		public void select_Add_Tag_options() throws Throwable {
			Thread.sleep(2500);
			login.driver.findElement(By.xpath("//div[@class='items-wrapper']/li[9]")).click();
			
		}

		@Given("^Successfully Verify Add Tag pop is displayed$")
		public void successfully_Verify_Add_Tag_pop_is_displayed() throws Throwable {
			Thread.sleep(2500);
			 WebElement Popup_add_tag = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Popup_add_tag")));
			 login.Log4j.info("Is 'Popup_add_tag' Displayed? - True/False:: " + Popup_add_tag.isDisplayed());
			  Assert.assertEquals(true,Popup_add_tag.isDisplayed());
			  Thread.sleep(5500);
			  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			
		}
		@Given("^Successfully Verify Add Tag option is working for insight$")
		public void successfully_Verify_Add_Tag_option_is_working_for_insight() throws Throwable {
			
			Thread.sleep(2500);
		
			login.driver.findElement(By.xpath("//div[@class='form-group']")).click();
			Thread.sleep(4000);
			login.driver.findElement(By.xpath("//input[@class='ui-widget-content ui-autocomplete-input']")).sendKeys("AddedTag");
			Thread.sleep(3500);
			login.driver.findElement(By.xpath("//div[@class='modal-header sphere-modal__header']")).click();
			Thread.sleep(2500);
			login.driver.findElement(By.xpath("//div[@class='sphere-modal-controls']/button[2]")).click();
			Thread.sleep(4000);
			select_the_All_tag_dropdown();
			//successfully_Verify_Add_tags_option_is_working();
			Thread.sleep(4000);
			added_tags_should_be_available_in_dropdown_and_should_display_related_insights();
		}
		
		@Given("^Select Delete options$")
		public void select_Delete_options() throws Throwable {
			Thread.sleep(4000);
			login.driver.findElement(By.xpath("//div[@class='items-wrapper']/li[10]")).click();
			
		}

		@Given("^Successfully Verify Delete option is working for insight$")
		public void successfully_Verify_Delete_option_is_working_for_insight() throws Throwable {
			
			Thread.sleep(2500);
			
			String BeforeDelete = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
			 WebElement Delete_forever = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Delete_forever")));
			 login.Log4j.info("Is 'Delete_forever' Displayed? - True/False:: " + Delete_forever.isDisplayed());
			  Assert.assertEquals(true,Delete_forever.isDisplayed());
			  Thread.sleep(5500);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Delete_forever"))).click();
				  Thread.sleep(5500);
				String AfterDelete = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
				System.out.println(BeforeDelete +":"+ AfterDelete);
				if(BeforeDelete != AfterDelete){
					System.out.println("Deleating Functionality is working Succesfully,Deleated Insight is  :- "+ BeforeDelete);
				  }else{
					  Assert.fail("Deleating Functionality is NOT working Succesfully");
					 
				  }
				
		}
		
		@Given("^Select two or more Insights$")
		public void select_two_or_more_Insights() throws Throwable {
			
			Thread.sleep(2500);
			login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
			Thread.sleep(2500);
			Actions actions = new Actions(login.driver);
			 n=3;
			   for (int i=1;i<=n;i++)
			actions.keyDown(Keys.LEFT_CONTROL)
			
			    .click( login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div["+ i+"]")))
			   // .click( login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[2]")))
			   // .click( login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[3]")))
			   // .click( login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[4]")))
			    .keyUp(Keys.LEFT_CONTROL)
			    .build()
			    .perform();
			Thread.sleep(2500);
			Actions action = new Actions(login.driver);
			WebElement AddTag = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]"));
			action.contextClick(AddTag).build().perform();
		}
		
		@Given("^Select Add tag options$")
		public void select_Add_tag_options() throws Throwable {
			Thread.sleep(2500);
			login.driver.findElement(By.xpath("//div[@class='items-wrapper']/li[4]")).click();
			Thread.sleep(2500);
			login.driver.findElement(By.xpath("//div[@class='form-group']")).click();
			Thread.sleep(4000);
			login.driver.findElement(By.xpath("//input[@class='ui-widget-content ui-autocomplete-input']")).sendKeys("AddedTag");
			Thread.sleep(3500);
			login.driver.findElement(By.xpath("//div[@class='modal-header sphere-modal__header']")).click();
			Thread.sleep(2500);
			login.driver.findElement(By.xpath("//div[@class='sphere-modal-controls']/button[2]")).click();
		}

		@Given("^Successfully Verify Add Tag option is working for Multiple insight$")
		public void successfully_Verify_Add_Tag_option_is_working_for_Multiple_insight() throws Throwable {
			Thread.sleep(2500);
			Thread.sleep(4000);
			select_the_All_tag_dropdown();
			//successfully_Verify_Add_tags_option_is_working();
			Thread.sleep(4000);
			added_tags_should_be_available_in_dropdown_and_should_display_related_insights();
			//successfully_Verify_Add_tags_option_is_working();
		}
		
		
		@Given("^Successfully Verify Add Tag count in the pop up window$")
		public void successfully_Verify_Add_Tag_count_in_the_pop_up_window() throws Throwable {
			Thread.sleep(2500);
			login.driver.findElement(By.xpath("//div[@class='items-wrapper']/li[4]")).click();
			Thread.sleep(4000);
			 WebElement element  = login.driver.findElement(By.xpath("//h4[@class='modal-title sphere-modal__title text-dots']"));
			 String X = element.getText();
			 String numbers;
				numbers = X.replaceAll("[^0-9]", "");
				int result = Integer.parseInt(numbers);
				System.out.println(result);
				
				if(n ==  result ){
					System.out.println("Share insight count is working Succesfully");
				  }else{
					  Assert.fail("Share insight count is NOT working Succesfully");
					 
				  }
				 Thread.sleep(5500);
					login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		}
		
		
		@Given("^Select Sort down option$")
		public void select_Sort_down_option() throws Throwable {
			Thread.sleep(2500);
			login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
			Thread.sleep(2500);
			login.driver.findElement(By.xpath("//div[@class='landing-content--filters-panel']/div[3]/div/div/div")).click();
			
		}

		@Given("^Successfully Verify  Sort down option$")
		public void successfully_Verify_Sort_down_option() throws Throwable {
			Thread.sleep(2500);
			  WebElement Title = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Title")));
				 login.Log4j.info("Is 'Title' Displayed? - True/False:: " + Title.isDisplayed());
				  Assert.assertEquals(true,Title.isDisplayed());
				  Thread.sleep(3500);
				  WebElement Last_editor = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Last_editor")));
					 login.Log4j.info("Is 'Last_editor? - True/False:: " + Last_editor.isDisplayed());
					  Assert.assertEquals(true,Last_editor.isDisplayed());
					  WebElement Last_Opened = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Last_Opened")));
						 login.Log4j.info("Is 'Last_Opened' Displayed? - True/False:: " + Last_Opened.isDisplayed());
						  Assert.assertEquals(true,Last_Opened.isDisplayed());
		}
		@Given("^Select Some insigt to Verify Last Opened option$")
		public void select_Some_insigt_to_Verify_Last_Opened_option() throws Throwable {
			
			Thread.sleep(2500);
			select_the_New_insight_option();
			Thread.sleep(8500);
			login.driver.findElement(By.xpath("//div[@title='Click to edit the Insight']")).click();
			
		}

		@Given("^Successfully Verify  Last Opened Insights$")
		public void successfully_Verify_Last_Opened_Insights() throws Throwable {
			Thread.sleep(10500);
			String arg1 = "Lastopened";
			login.driver.findElement(By.xpath("//div[@class='page-main-header--title-field']/input")).sendKeys(arg1);
			 Thread.sleep(5500);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			Thread.sleep(2500);
			select_Sort_down_option();
			Thread.sleep(2500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Last_Opened"))).click();
			Thread.sleep(2500);
			String Last_Opened_Insights = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
			System.out.println(arg1 +":"+ Last_Opened_Insights);
			if(arg1.equalsIgnoreCase(Last_Opened_Insights)){
				System.out.println("Last Opened Functionality is working Succesfully");
			  }else{
				  Assert.fail("Last Opened Functionality is NOT working Succesfully");
				 
			  }
			
		}
		@Given("^Select Folder panel option and  create a New Folder$")
		public void select_Folder_panel_option_and_create_a_New_Folder() throws Throwable {
			Thread.sleep(2500);
			select_Folder_panel_option();
			Thread.sleep(2500);
			select_New_Folder_option();
			Thread.sleep(3500);
			login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']/div[1]/input")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(3500);
			login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']/div[1]/input")).clear();
			Thread.sleep(3500);
			login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']/div[1]/input")).sendKeys("TC_IE_62");
			Thread.sleep(3500);
			login.driver.findElement(By.xpath("//button[contains(text(),'Create folder')]")).click();
			Thread.sleep(2500);
			login.driver.findElement(By.xpath("//div[@class='insights-breadcrumbs-icon']")).click();
			Thread.sleep(2500);
			
		}
		
		@Given("^Insights should be moved to existing/new folder$")
		public void insights_should_be_moved_to_existing_new_folder() throws Throwable {
			String Movefoldernamefirst = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
			Actions action1 = new Actions(login.driver);
			WebElement we1 = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
			action1.contextClick(we1).build().perform();
			Thread.sleep(2500);
			Actions action2 = new Actions(login.driver);
			WebElement we2 = login.driver.findElement(By.xpath("//div[@class='items-wrapper']/li[8]"));
			action2.moveToElement(we2).build().perform();
			Thread.sleep(2500);
			                                    ///html/body/ul/div[3]/li[8]/ul/li/span/div/div[2]/div/div/div
			login.driver.findElement(By.xpath("/html/body/ul/div[3]/li[8]/ul/li/span/div/div[2]/div/div/div")).click();
			Thread.sleep(2500);
			login.driver.findElement(By.xpath("//*[@id='landing_page']/div[2]/div[2]/div/div[1]/div[4]/div[2]")).click();
			String MovefoldernameAfter = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
			System.out.println(Movefoldernamefirst +":"+ MovefoldernameAfter);
			if(Movefoldernamefirst.equalsIgnoreCase(MovefoldernameAfter)){
				System.out.println("Move to Functionality is working Succesfully");
			  }else{
				  Assert.fail("Move to Functionality is NOT working Succesfully");
				 
			  }
			
			Thread.sleep(2500);
			login.driver.findElement(By.xpath("//div[@class='insights-breadcrumbs-icon']")).click();
			Thread.sleep(4500);
			Actions action3 = new Actions(login.driver);
			WebElement we3 = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
			action3.contextClick(we3).build().perform();
			Actions action4 = new Actions(login.driver);
			WebElement we4 = login.driver.findElement(By.xpath("//div[@class='items-wrapper']/li[8]"));
			action4.moveToElement(we4).build().perform();
		}
		
		@Given("^Insights should be moved to existing folder$")
		public void insights_should_be_moved_to_existing_folder() throws Throwable {
			String Movefoldernamefirst = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
			System.out.println(Movefoldernamefirst);
			Actions action1 = new Actions(login.driver);
			WebElement we1 = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
			action1.contextClick(we1).build().perform();
			Thread.sleep(2500);
			 Actions action = new Actions(login.driver);
				WebElement we = login.driver.findElement(By.xpath("//div[@class='items-wrapper']/li[8]"));
				action.moveToElement(we).build().perform();
				Thread.sleep(2500);
				login.driver.findElement(By.xpath("/html/body/ul/div[3]/li[8]/ul/li/span/div/div[2]/div/div/div")).click();
				Thread.sleep(2500);
				login.driver.findElement(By.xpath("//*[@id='landing_page']/div[2]/div[2]/div/div[1]/div[3]/div[2]")).click();
				Thread.sleep(2500);
				String MovefoldernameAfter = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
				System.out.println(Movefoldernamefirst +":"+ MovefoldernameAfter);
				if(Movefoldernamefirst.equalsIgnoreCase(MovefoldernameAfter)){
					System.out.println("Move to Functionality is working Succesfully");
				  }else{
					  Assert.fail("Move to Functionality is NOT working Succesfully");
					 
				  }
				Thread.sleep(2500);
				login.driver.findElement(By.xpath("//div[@class='insights-breadcrumbs-icon']")).click();
				/*
				Thread.sleep(1500);
				select_Right_click_options_on_folder();
				Thread.sleep(1500);
				login.driver.findElement(By.xpath("//span[contains(text(),'Delete folder')]")).click();
				Thread.sleep(15500);
				login.driver.findElement(By.xpath("//button[contains(text(),'Delete forever')]")).click();
				*/
		}
		
		@Given("^Select the Insigt and create Folder$")
		public void select_the_Insigt_and_create_Folder() throws Throwable {
			
			Thread.sleep(2500);
			login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
			
			 MoveCreatefoldernamefirst = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
			
			Thread.sleep(2500);
			Actions action1 = new Actions(login.driver);
			WebElement we1 = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
			action1.contextClick(we1).build().perform();
			 Actions action = new Actions(login.driver);
				WebElement we = login.driver.findElement(By.xpath("//div[@class='items-wrapper']/li[8]"));
				action.moveToElement(we).build().perform();
				Thread.sleep(3500);
				login.driver.findElement(By.xpath("//button[contains(text(),'Create new folder')]")).click();
		}

		@Given("^Insights should be moved to created folder$")
		public void insights_should_be_moved_to_created_folder() throws Throwable {
			Thread.sleep(3500);
			login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']/div[1]/input")).click();
			Thread.sleep(3500);
			login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']/div[1]/input")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(3500);
			login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']/div[1]/input")).clear();
			Thread.sleep(3500);
			login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']/div[1]/input")).sendKeys("TC_IE_63");
			Thread.sleep(3500);
			login.driver.findElement(By.xpath("//button[contains(text(),'Create folder')]")).click();
		}
		@Given("^Successfully Verify  Insights moved to created folder$")
		public void successfully_Verify_Insights_moved_to_created_folder() throws Throwable {
			//String MoveCreatefoldernamefirst;
			Thread.sleep(2500);
			login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
			//Thread.sleep(5500);
			//login.driver.findElement(By.xpath("//div[@class='insights-tree-toggle-right fa fa-angle-right']")).click();
			Thread.sleep(5500);
			login.driver.findElement(By.xpath("//*[@id='landing_page']/div[2]/div[2]/div/div[1]/div[4]/div[2]")).click();
			Thread.sleep(5500);
			String MoveCreatefoldernameafter = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
			System.out.println(MoveCreatefoldernamefirst +":"+ MoveCreatefoldernameafter);
			if(MoveCreatefoldernamefirst.equalsIgnoreCase(MoveCreatefoldernameafter)){
				System.out.println("Move to Functionality by creating folder is working Succesfully");
			  }else{
				  Assert.fail("Move to Functionality by creating folder is NOT working Succesfully");
				 
			  }
			select_Right_click_options_on_folder();
			Thread.sleep(1500);
			login.driver.findElement(By.xpath("//span[contains(text(),'Delete folder')]")).click();
			Thread.sleep(15500);
			login.driver.findElement(By.xpath("//button[contains(text(),'Delete forever')]")).click();
		}
		
		

		@Given("^Select Share options$")
		public void select_Share_options() throws Throwable {
			Thread.sleep(5500);
			login.driver.findElement(By.xpath("//div[@class='items-wrapper']/li[4]")).click();
			
		}

		@Given("^Successfully Verify Share insight option is working$")
		public void successfully_Verify_Share_insight_option_is_working() throws Throwable {
			Thread.sleep(5500);
			  if(login.driver.findElements(By.xpath("//h4[@class='modal-title sphere-modal__title text-dots']")).size() != 0){
				  System.out.println("Share window Pop up to share the Insight");
				  }else{
					  Assert.fail("Share window Does'nt Pop up to share the Insight");
				  }
			  Thread.sleep(5500);
				login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		
		}
		
		@Given("^Selects Share options$")
		public void selects_Share_options() throws Throwable {
			Thread.sleep(5500);
			login.driver.findElement(By.xpath("//div[@class='items-wrapper']/li[2]")).click();
		}

		@Given("^Successfully Verify Share insight count is working$")
		public void successfully_Verify_Share_insight_count_is_working() throws Throwable {
			Thread.sleep(5500);
			String ShareInsightCount = login.driver.findElement(By.xpath("//h4[@class='modal-title sphere-modal__title text-dots']")).getText();
			String numbers;
			numbers = ShareInsightCount.replaceAll("[^0-9]", "");
			int result = Integer.parseInt(numbers);
			System.out.println(result);
			System.out.println(n +":"+ result);
			if(n ==  result ){
				System.out.println("Share insight count is working Succesfully");
			  }else{
				  Assert.fail("Share insight count is NOT working Succesfully");
				 
			  }
			 Thread.sleep(5500);
				login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		}
		
		
		
		@Given("^Select share option in right click$")
		public void select_share_option_in_right_click() throws Throwable {
			Thread.sleep(5500);
			select_Right_click_options_on_folder();
			//select_Folder_panel_option();
			Thread.sleep(5500);
			Thread.sleep(3500);
			login.driver.findElement(By.xpath("//div[@class='items-wrapper']/li[4]")).click();
			//select_Migrated_Insight();
			
		}

		@Given("^Successfully Verify share option is working$")
		public void successfully_Verify_share_option_is_working() throws Throwable {
			Thread.sleep(5500);
			//List<WebElement> objLinks = login.driver.findElements(By.xpath("//a[@class='link insights-grid-row--title-link']"));
			//System.out.println(objLinks.size());
			//Thread.sleep(3500);
			//Actions action = new Actions(login.driver);
			//WebElement Rightcliclfolder = login.driver.findElement(By.xpath("//div[@class='insights-tree ps-container ps-theme-default left_panel ui-sortable insights-tree--opened']/div[5]"));
			//action.contextClick(Rightcliclfolder).build().perform();
			 //System.out.println(InsightCount +":"+ objLinks.size());
			//Thread.sleep(3500);
			//login.driver.findElement(By.xpath("/html/body/ul[2]/div[3]/li[4]/span/span")).click();
			//Thread.sleep(3500);
			 WebElement element  = login.driver.findElement(By.xpath("//h4[@class='modal-title sphere-modal__title text-dots']"));
			 String X = element.getText();
			 String numbers;
				numbers = X.replaceAll("[^0-9]", "");
				int result = Integer.parseInt(numbers);
				System.out.println(result);
				
				 if(login.driver.findElements(By.xpath("//h4[@class='modal-title sphere-modal__title text-dots']")).size() != 0){
					  Thread.sleep(2500);
					  System.out.println("Share Functionality is working Successfully");
					  }else{
						  Assert.fail("Share Functionality is NOT working Successfully."); 
					  }
				
				
				 Thread.sleep(5500);
					login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
					// Thread.sleep(1500);
					//	login.driver.findElement(By.xpath("//div[@class='insights-breadcrumbs']/div[1]")).click();
					//	 Thread.sleep(3500);
					//		login.driver.findElement(By.xpath("//div[@class='insights-tree-toggle-left fa fa-angle-left']")).click();	
		}
		
		@Given("^Select Insights Counts for each tabs$")
		public void select_Insights_Counts_for_each_tabs() throws Throwable {
			Thread.sleep(5500);
			login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
			Thread.sleep(4500);
			 WebElement element  = login.driver.findElement(By.xpath("//div[@title='Insights that you have created']/span[3]/span"));
			 String Myinsight = element.getText();
			 String numbers;
				numbers = Myinsight.replaceAll("[^0-9]", "");
				int resultMyinsight = Integer.parseInt(numbers);
				System.out.println(resultMyinsight);
			 Thread.sleep(4500);
			 WebElement element1  = login.driver.findElement(By.xpath("//div[@title='CEIC Analytics']/span[3]/span"));
			 String Analytics = element1.getText();
			 String numbers1;
				numbers1 = Analytics.replaceAll("[^0-9]", "");
				int result1Analytics = Integer.parseInt(numbers1);
				System.out.println(result1Analytics);
			 Thread.sleep(4500);
			 WebElement element2  = login.driver.findElement(By.xpath("//div[@title='Insights that other users have shared with you']/span[3]/span"));
			 String Shared = element2.getText();
			 String numbers2;
				numbers2 = Shared.replaceAll("[^0-9]", "");
				int result2Shared = Integer.parseInt(numbers2);
				System.out.println(result2Shared);
				 Addition_of_three_insight = (resultMyinsight +result1Analytics +result2Shared);
				System.out.println(Addition_of_three_insight);
				
			 
			 
		}

		@Given("^Successfully Verify Insights Counts equal to ALl tab$")
		public void successfully_Verify_Insights_Counts_equal_to_ALl_tab() throws Throwable {
			 WebElement element  = login.driver.findElement(By.xpath("//div[@title='All insights you have access to']/span[3]/span"));
			 String Shared = element.getText();
			 String numbers;
				numbers = Shared.replaceAll("[^0-9]", "");
				int resultAll = Integer.parseInt(numbers);
				System.out.println(resultAll);
				
				
				System.out.println(Addition_of_three_insight + ":" + resultAll);
				if  (Addition_of_three_insight == resultAll){
					 System.out.println("Insight Count done Successfully");
				  }else{
					  Assert.fail("Insight Count Does not match!!!.Please Verify.");
				}
			 
		}
		
		@Given("^search  insight in \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" tab and and Successfully Verify the same insight in All tab$")
		public void search_insight_in_tab_and_and_Successfully_Verify_the_same_insight_in_All_tab(String arg1, String arg2, String arg3) throws Throwable {
			Thread.sleep(5500);
			login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
			Thread.sleep(5500);
			  if(arg1.equalsIgnoreCase(arg1)){
					
				  login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).click();
				  Thread.sleep(5500);
				  String X = "Perf_Testcase_01";
				  login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).sendKeys(X);
				  Thread.sleep(5500);
				  String Myinsightsearch = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
					System.out.println(X + ":" + Myinsightsearch);
					  Thread.sleep(5500);
					 login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).clear();
					 
					 Thread.sleep(5500);
					 login.driver.findElement(By.xpath("//div[@title='All insights you have access to']")).click();
					 Thread.sleep(5500);
					 login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).click();
					  Thread.sleep(5500);
					  login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).sendKeys(X);
					  Thread.sleep(5500);
					  String Myinsightsearch1 = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
						System.out.println(X + ":" + Myinsightsearch1);
						 Thread.sleep(5500);
						
						if (X.equalsIgnoreCase(Myinsightsearch1)){
							 System.out.println("All tab functionality is working Fine");
						  }else{
							  Assert.fail("All tab functionality is NOT working Fine");
						}
						 login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).clear();
			  }
			  
			  if(arg2.equalsIgnoreCase(arg2)){
			
				  login.driver.findElement(By.xpath("//div[@title='CEIC Analytics']")).click();
				  Thread.sleep(5500);
				  login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).click();
				  Thread.sleep(5500);
				  String X = "CIS Macro Overview";
				  login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).sendKeys(X);
				  Thread.sleep(5500);
				  String Analyticssearch = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
					System.out.println(X + ":" + Analyticssearch);
					  Thread.sleep(5500);
					 login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).clear();
					 
					 Thread.sleep(5500);
					 login.driver.findElement(By.xpath("//div[@title='All insights you have access to']")).click();
					 Thread.sleep(5500);
					 login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).click();
					  Thread.sleep(5500);
					  login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).sendKeys(X);
					  Thread.sleep(5500);
					  String Analyticssearch1 = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
						System.out.println(X + ":" + Analyticssearch1);
						 Thread.sleep(5500);
						 login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).clear();
						if (X.equalsIgnoreCase(Analyticssearch1)){
							 System.out.println("All tab functionality is working Fine");
						  }else{
							  Assert.fail("All tab functionality is NOT working Fine");
						}
						 login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).clear();
			  }
			  
			  if(arg3.equalsIgnoreCase(arg3)){
				  
				  login.driver.findElement(By.xpath("//div[@title='Insights that other users have shared with you']")).click();
				  Thread.sleep(5500);
				  login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).click();
				  Thread.sleep(5500);
				  String X = "China PMI";
				  login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).sendKeys(X);
				  Thread.sleep(5500);
				  String Sharedsearch = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
					System.out.println(X + ":" + Sharedsearch);
					  Thread.sleep(5500);
					 login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).clear();
					 
					 Thread.sleep(5500);
					 login.driver.findElement(By.xpath("//div[@title='All insights you have access to']")).click();
					 Thread.sleep(5500);
					 login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).click();
					  Thread.sleep(5500);
					  login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).sendKeys(X);
					  Thread.sleep(5500);
					  String Sharedsearch1 = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
						System.out.println(X + ":" + Sharedsearch1);
						 Thread.sleep(5500);
						 login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).clear();
						if (X.equalsIgnoreCase(Sharedsearch1)){
							 System.out.println("All tab functionality is working Fine");
						  }else{
							  Assert.fail("All tab functionality is NOT working Fine");
						}
						 login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).clear();
						 Thread.sleep(5500);
						 login.driver.findElement(By.xpath("//div[@title='Insights that you have created']")).click();
			  }
		}
		@Given("^Select the Analytics Tab$")
		public void select_the_Analytics_Tab() throws Throwable {
			 Thread.sleep(5500);
			login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
			  Thread.sleep(5500);
			 login.driver.findElement(By.xpath("//div[@title='CEIC Analytics']")).click();
			
		}
		@Given("^Select the Shared Tab$")
		public void select_the_Shared_Tab() throws Throwable {
			 Thread.sleep(5500);
			login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
			 Thread.sleep(5500);
			 login.driver.findElement(By.xpath("//div[@title='Insights that other users have shared with you']")).click();
			 
		}
		@Given("^Select the Recent Tab$")
		public void select_the_Recent_Tab() throws Throwable {
			 Thread.sleep(5500);
				login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
				 Thread.sleep(5500);
				 login.driver.findElement(By.xpath("//div[@title='Insights that you have worked with last time']")).click();
		}

		@Given("^Select the All Tab$")
		public void select_the_All_Tab() throws Throwable {
			 Thread.sleep(5500);
				login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
				 Thread.sleep(5500);
				 login.driver.findElement(By.xpath("//div[@title='All insights you have access to']")).click();
		}
		@Given("^Select the China Premium  Tab$")
		public void select_the_China_Premium_Tab() throws Throwable {
			 Thread.sleep(5500);
				login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
				  Thread.sleep(5500);
				 login.driver.findElement(By.xpath("//div[@title='View China Premium Data Talk publications']")).click();
		}

		@Given("^Select the Analytics-Focus Tab$")
		public void select_the_Analytics_Focus_Tab() throws Throwable {
			Thread.sleep(5500);
			login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
			  Thread.sleep(5500);
			 login.driver.findElement(By.xpath("//span[contains(text(),'Focus Economics')]")).click();
		}

		@Given("^Select the Analytics-Sentix Tab$")
		public void select_the_Analytics_Sentix_Tab() throws Throwable {
			Thread.sleep(5500);
			login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
			  Thread.sleep(5500);
			 login.driver.findElement(By.xpath("//div[@title='View Sentix Reports']")).click();
		}

		@Given("^Select the Analytics-EMIS Tab$")
		public void select_the_Analytics_EMIS_Tab() throws Throwable {
			Thread.sleep(5500);
			login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
			  Thread.sleep(5500);
			 login.driver.findElement(By.xpath("//span[contains(text(),'EMIS Insights (468)')]")).click();
		}
		
		@And("^Select the categories as Hot Topics for the insight$")
		public void select_the_categories_as_Hot_Topics_for_the_insight() throws Throwable {
			Thread.sleep(5500);
			login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
			
			 Thread.sleep(4500);
			 Actions action = new Actions(login.driver);
				WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
				action.contextClick(RightclickonInsight).build().perform();
				 Thread.sleep(2500);
				login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
				 Thread.sleep(3500);
					login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
			    Thread.sleep(3500);
			    login.driver.findElement(By.xpath("//div[@class='header-menu-item--dropdown']/div[10]")).click();
			    Thread.sleep(4500);
			    login.driver.findElement(By.xpath("//div[@class='insight-settings-general']/div[4]/div/div/a/span[2]/b")).click();
			    Thread.sleep(4500);
			    login.driver.findElement(By.xpath("//ul[@class='select2-results']/li[2]/div/div[2]")).click();
			    Thread.sleep(4500);
			    login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
			    Thread.sleep(2500);
				  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			    Thread.sleep(1500);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}

		@And("^Select the categories option as Hot topics option$")
		public void select_the_categories_option_as_Hot_topics_option() throws Throwable {
			 Thread.sleep(1500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_category"))).click();
			 Thread.sleep(1500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Hot_tpoics"))).click();
		}

		@And("^verify the Hot topics category in \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
		public void verify_the_Hot_topics_category_in(String arg1, String arg2, String arg3, String arg4) throws Throwable {
			 Thread.sleep(1500);
			 if(arg1.equalsIgnoreCase(arg1)){
				 Thread.sleep(2500);
				  login.driver.findElement(By.xpath("//div[@title='CEIC Analytics']")).click();
				  Thread.sleep(4500);
					 Actions action = new Actions(login.driver);
						WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
						action.contextClick(RightclickonInsight).build().perform();
						 Thread.sleep(2500);
						login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
						 Thread.sleep(3500);
							login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
					    Thread.sleep(3500);
					    login.driver.findElement(By.xpath("	//div[@class='header-menu-item--dropdown']/div[10]")).click();
					    Thread.sleep(4500);
						  WebElement Hot_tpoics = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Hot_tpoics")));
							 login.Log4j.info("Is 'Hot_tpoics' Displayed? - True/False:: " + Hot_tpoics.isDisplayed());
							  Assert.assertEquals(true,Hot_tpoics.isDisplayed());
							  Thread.sleep(2500);
							  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
						    Thread.sleep(1500);
							  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 }
			 if(arg2.equalsIgnoreCase(arg2)){
				
				 Thread.sleep(5500);
				 login.driver.findElement(By.xpath("//div[@title='Insights that other users have shared with you']")).click();
				 Thread.sleep(4500);
				 Actions action = new Actions(login.driver);
					WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
					action.contextClick(RightclickonInsight).build().perform();
					 Thread.sleep(2500);
					login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
					 Thread.sleep(3500);
						login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
				    Thread.sleep(3500);
				    login.driver.findElement(By.xpath("	//div[@class='header-menu-item--dropdown']/div[10]")).click();
				    Thread.sleep(4500);
					  WebElement Hot_tpoics = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Hot_tpoics")));
						 login.Log4j.info("Is 'Hot_tpoics' Displayed? - True/False:: " + Hot_tpoics.isDisplayed());
						  Assert.assertEquals(true,Hot_tpoics.isDisplayed());
						  Thread.sleep(2500);
						  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
					    Thread.sleep(1500);
						  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 }
			 if(arg3.equalsIgnoreCase(arg3)){
				 Thread.sleep(5500);
				 login.driver.findElement(By.xpath("//div[@title='Insights that you have worked with last time']")).click();
				 Thread.sleep(4500);
				 Actions action = new Actions(login.driver);
					WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
					action.contextClick(RightclickonInsight).build().perform();
					 Thread.sleep(2500);
					login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
					 Thread.sleep(3500);
						login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
				    Thread.sleep(3500);
				    login.driver.findElement(By.xpath("	//div[@class='header-menu-item--dropdown']/div[10]")).click();
				    Thread.sleep(4500);
					  WebElement Hot_tpoics = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Hot_tpoics")));
						 login.Log4j.info("Is 'Hot_tpoics' Displayed? - True/False:: " + Hot_tpoics.isDisplayed());
						  Assert.assertEquals(true,Hot_tpoics.isDisplayed());
						  Thread.sleep(2500);
						  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
					    Thread.sleep(1500);
						  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 }
			 if(arg4.equalsIgnoreCase(arg4)){
				 Thread.sleep(5500);
				 login.driver.findElement(By.xpath("//div[@title='All insights you have access to']")).click();
				 Thread.sleep(4500);
				 Actions action = new Actions(login.driver);
					WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
					action.contextClick(RightclickonInsight).build().perform();
					 Thread.sleep(2500);
					login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
					 Thread.sleep(3500);
						login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
				    Thread.sleep(3500);
				    login.driver.findElement(By.xpath("	//div[@class='header-menu-item--dropdown']/div[10]")).click();
				    Thread.sleep(4500);
					  WebElement Hot_tpoics = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Hot_tpoics")));
						 login.Log4j.info("Is 'Hot_tpoics' Displayed? - True/False:: " + Hot_tpoics.isDisplayed());
						  Assert.assertEquals(true,Hot_tpoics.isDisplayed());
						  Thread.sleep(2500);
						  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
					    Thread.sleep(1500);
						  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 }
			  Thread.sleep(1500);
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Remove_icon_for_filters"))).click();
		}
		@Given("^Select the categories as World Economy for the insight$")
		public void select_the_categories_as_World_Economy_for_the_insight() throws Throwable {
			Thread.sleep(5500);
			login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
			Thread.sleep(5500);
			login.driver.findElement(By.xpath("//div[@title='Insights that you have created']")).click();
			
			 Thread.sleep(4500);
			 Actions action = new Actions(login.driver);
				WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
				action.contextClick(RightclickonInsight).build().perform();
				 Thread.sleep(2500);
				login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
				 Thread.sleep(3500);
					login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
			    Thread.sleep(3500);
			    login.driver.findElement(By.xpath("//div[@class='header-menu-item--dropdown']/div[10]")).click();
			    Thread.sleep(4500);
			    login.driver.findElement(By.xpath("//div[@class='insight-settings-general']/div[4]/div/div/a/span[2]/b")).click();
			    Thread.sleep(4500);
			    login.driver.findElement(By.xpath("//ul[@class='select2-results']/li[3]/div/div[2]")).click();
			    Thread.sleep(4500);
			    login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
			    Thread.sleep(2500);
				  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			    Thread.sleep(1500);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}

		@Given("^Select the categories option as World Economy option$")
		public void select_the_categories_option_as_World_Economy_option() throws Throwable {
			 Thread.sleep(1500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_category"))).click();
			 Thread.sleep(1500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("World_Economy"))).click();
		}

		@Given("^verify the World Economy category in \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
		public void verify_the_World_Economy_category_in(String arg1, String arg2, String arg3, String arg4) throws Throwable {
			Thread.sleep(1500);
			 if(arg1.equalsIgnoreCase(arg1)){
				 Thread.sleep(2500);
				  login.driver.findElement(By.xpath("//div[@title='CEIC Analytics']")).click();
				  Thread.sleep(4500);
					 Actions action = new Actions(login.driver);
						WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
						action.contextClick(RightclickonInsight).build().perform();
						 Thread.sleep(2500);
						login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
						 Thread.sleep(3500);
							login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
					    Thread.sleep(3500);
					    login.driver.findElement(By.xpath("	//div[@class='header-menu-item--dropdown']/div[10]")).click();
					    Thread.sleep(4500);
					    Thread.sleep(1500);
						  WebElement World_Economy = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("World_Economy")));
							 login.Log4j.info("Is ' World_Economy' Displayed? - True/False:: " + World_Economy.isDisplayed());
							  Assert.assertEquals(true,World_Economy.isDisplayed());
							  Thread.sleep(2500);
							  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
						    Thread.sleep(1500);
							  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 }
			 if(arg2.equalsIgnoreCase(arg2)){
				
				 Thread.sleep(5500);
				 login.driver.findElement(By.xpath("//div[@title='Insights that other users have shared with you']")).click();
				 Thread.sleep(4500);
				 Actions action = new Actions(login.driver);
					WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
					action.contextClick(RightclickonInsight).build().perform();
					 Thread.sleep(2500);
					login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
					 Thread.sleep(3500);
						login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
				    Thread.sleep(3500);
				    login.driver.findElement(By.xpath("	//div[@class='header-menu-item--dropdown']/div[10]")).click();
				    Thread.sleep(4500);
				    Thread.sleep(1500);
					  WebElement World_Economy = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("World_Economy")));
						 login.Log4j.info("Is ' World_Economy' Displayed? - True/False:: " + World_Economy.isDisplayed());
						  Assert.assertEquals(true,World_Economy.isDisplayed());
						  Thread.sleep(2500);
						  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
					    Thread.sleep(1500);
						  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 }
			 if(arg3.equalsIgnoreCase(arg3)){
				 Thread.sleep(5500);
				 login.driver.findElement(By.xpath("//div[@title='Insights that you have worked with last time']")).click();
				 Thread.sleep(4500);
				 Actions action = new Actions(login.driver);
					WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
					action.contextClick(RightclickonInsight).build().perform();
					 Thread.sleep(2500);
					login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
					 Thread.sleep(3500);
						login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
				    Thread.sleep(3500);
				    login.driver.findElement(By.xpath("	//div[@class='header-menu-item--dropdown']/div[10]")).click();
				    Thread.sleep(4500);
				    Thread.sleep(1500);
					  WebElement World_Economy = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("World_Economy")));
						 login.Log4j.info("Is ' World_Economy' Displayed? - True/False:: " + World_Economy.isDisplayed());
						  Assert.assertEquals(true,World_Economy.isDisplayed());
						  Thread.sleep(2500);
						  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
					    Thread.sleep(1500);
						  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 }
			 if(arg4.equalsIgnoreCase(arg4)){
				 Thread.sleep(5500);
				 login.driver.findElement(By.xpath("//div[@title='All insights you have access to']")).click();
				 Thread.sleep(4500);
				 Actions action = new Actions(login.driver);
					WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
					action.contextClick(RightclickonInsight).build().perform();
					 Thread.sleep(2500);
					login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
					 Thread.sleep(3500);
						login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
				    Thread.sleep(3500);
				    login.driver.findElement(By.xpath("	//div[@class='header-menu-item--dropdown']/div[10]")).click();
				    Thread.sleep(4500);
				    Thread.sleep(1500);
					  WebElement World_Economy = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("World_Economy")));
						 login.Log4j.info("Is ' World_Economy' Displayed? - True/False:: " + World_Economy.isDisplayed());
						  Assert.assertEquals(true,World_Economy.isDisplayed());
						  Thread.sleep(2500);
						  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
					    Thread.sleep(1500);
						  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 }
			  Thread.sleep(1500);
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Remove_icon_for_filters"))).click();
		}
		
		@Given("^Select the categories as Emerging Markets for the insight$")
		public void select_the_categories_as_Emerging_Markets_for_the_insight() throws Throwable {
			Thread.sleep(5500);
			login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
			Thread.sleep(5500);
			login.driver.findElement(By.xpath("//div[@title='Insights that you have created']")).click();
			
			 Thread.sleep(4500);
			 Actions action = new Actions(login.driver);
				WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
				action.contextClick(RightclickonInsight).build().perform();
				 Thread.sleep(2500);
				login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
				 Thread.sleep(3500);
					login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
			    Thread.sleep(3500);
			    login.driver.findElement(By.xpath("//div[@class='header-menu-item--dropdown']/div[10]")).click();
			    Thread.sleep(4500);
			    login.driver.findElement(By.xpath("//div[@class='insight-settings-general']/div[4]/div/div/a/span[2]/b")).click();
			    Thread.sleep(4500);
			    login.driver.findElement(By.xpath("//ul[@class='select2-results']/li[4]/div/div[2]")).click();
			    Thread.sleep(4500);
			    login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
			    Thread.sleep(2500);
				  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			    Thread.sleep(1500);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}

		@Given("^Select the categories option as Emerging Markets option$")
		public void select_the_categories_option_as_Emerging_Markets_option() throws Throwable {
			 Thread.sleep(1500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_category"))).click();
			 Thread.sleep(1500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Emerging_markets"))).click();
		}

		@Given("^verify the Emerging Markets category in \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
		public void verify_the_Emerging_Markets_category_in(String arg1, String arg2, String arg3, String arg4) throws Throwable {
			Thread.sleep(1500);
			 if(arg1.equalsIgnoreCase(arg1)){
				 Thread.sleep(2500);
				  login.driver.findElement(By.xpath("//div[@title='CEIC Analytics']")).click();
				  Thread.sleep(4500);
					 Actions action = new Actions(login.driver);
						WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
						action.contextClick(RightclickonInsight).build().perform();
						 Thread.sleep(2500);
						login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
						 Thread.sleep(3500);
							login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
					    Thread.sleep(3500);
					    login.driver.findElement(By.xpath("	//div[@class='header-menu-item--dropdown']/div[10]")).click();
					    Thread.sleep(4500);
					    Thread.sleep(1500);
					    WebElement Emerging_markets = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Emerging_markets")));
						 login.Log4j.info("Is 'Emerging_markets' Displayed? - True/False:: " + Emerging_markets.isDisplayed());
						  Assert.assertEquals(true,Emerging_markets.isDisplayed());
							  Thread.sleep(2500);
							  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
						    Thread.sleep(1500);
							  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 }
			 if(arg2.equalsIgnoreCase(arg2)){
				
				 Thread.sleep(5500);
				 login.driver.findElement(By.xpath("//div[@title='Insights that other users have shared with you']")).click();
				 Thread.sleep(4500);
				 Actions action = new Actions(login.driver);
					WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
					action.contextClick(RightclickonInsight).build().perform();
					 Thread.sleep(2500);
					login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
					 Thread.sleep(3500);
						login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
				    Thread.sleep(3500);
				    login.driver.findElement(By.xpath("	//div[@class='header-menu-item--dropdown']/div[10]")).click();
				    Thread.sleep(4500);
				    Thread.sleep(1500);
				    WebElement Emerging_markets = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Emerging_markets")));
					 login.Log4j.info("Is 'Emerging_markets' Displayed? - True/False:: " + Emerging_markets.isDisplayed());
					  Assert.assertEquals(true,Emerging_markets.isDisplayed());
						  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
					    Thread.sleep(1500);
						  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 }
			 if(arg3.equalsIgnoreCase(arg3)){
				 Thread.sleep(5500);
				 login.driver.findElement(By.xpath("//div[@title='Insights that you have worked with last time']")).click();
				 Thread.sleep(4500);
				 Actions action = new Actions(login.driver);
					WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
					action.contextClick(RightclickonInsight).build().perform();
					 Thread.sleep(2500);
					login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
					 Thread.sleep(3500);
						login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
				    Thread.sleep(3500);
				    login.driver.findElement(By.xpath("	//div[@class='header-menu-item--dropdown']/div[10]")).click();
				    Thread.sleep(4500);
				    WebElement Emerging_markets = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Emerging_markets")));
					 login.Log4j.info("Is 'Emerging_markets' Displayed? - True/False:: " + Emerging_markets.isDisplayed());
					  Assert.assertEquals(true,Emerging_markets.isDisplayed());
						  Thread.sleep(2500);
						  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
					    Thread.sleep(1500);
						  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 }
			 if(arg4.equalsIgnoreCase(arg4)){
				 Thread.sleep(5500);
				 login.driver.findElement(By.xpath("//div[@title='All insights you have access to']")).click();
				 Thread.sleep(4500);
				 Actions action = new Actions(login.driver);
					WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
					action.contextClick(RightclickonInsight).build().perform();
					 Thread.sleep(2500);
					login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
					 Thread.sleep(3500);
						login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
				    Thread.sleep(3500);
				    login.driver.findElement(By.xpath("	//div[@class='header-menu-item--dropdown']/div[10]")).click();
				    Thread.sleep(4500);
				    WebElement Emerging_markets = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Emerging_markets")));
					 login.Log4j.info("Is 'Emerging_markets' Displayed? - True/False:: " + Emerging_markets.isDisplayed());
					  Assert.assertEquals(true,Emerging_markets.isDisplayed());
						  Thread.sleep(2500);
						  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
					    Thread.sleep(1500);
						  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 }
			  Thread.sleep(1500);
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Remove_icon_for_filters"))).click();
		}
		@Given("^Select the categories as Thematic Analysis for the insight$")
		public void select_the_categories_as_Thematic_Analysis_for_the_insight() throws Throwable {
			Thread.sleep(5500);
			login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
			Thread.sleep(5500);
			login.driver.findElement(By.xpath("//div[@title='Insights that you have created']")).click();
			
			 Thread.sleep(4500);
			 Actions action = new Actions(login.driver);
				WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
				action.contextClick(RightclickonInsight).build().perform();
				 Thread.sleep(2500);
				login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
				 Thread.sleep(3500);
					login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
			    Thread.sleep(3500);
			    login.driver.findElement(By.xpath("//div[@class='header-menu-item--dropdown']/div[10]")).click();
			    Thread.sleep(4500);
			    login.driver.findElement(By.xpath("//div[@class='insight-settings-general']/div[4]/div/div/a/span[2]/b")).click();
			    Thread.sleep(4500);
			    login.driver.findElement(By.xpath("//ul[@class='select2-results']/li[5]/div/div[2]")).click();
			    Thread.sleep(4500);
			    login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
			    Thread.sleep(2500);
				  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			    Thread.sleep(1500);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}

		@Given("^Select the categories option as Thematic Analysis option$")
		public void select_the_categories_option_as_Thematic_Analysis_option() throws Throwable {
			 Thread.sleep(1500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_category"))).click();
			 Thread.sleep(1500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Thematic_Analysis"))).click();
		}

		@Given("^verify the Thematic Analysis category in \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
		public void verify_the_Thematic_Analysis_category_in(String arg1, String arg2, String arg3, String arg4) throws Throwable {
			Thread.sleep(1500);
			 if(arg1.equalsIgnoreCase(arg1)){
				 Thread.sleep(2500);
				  login.driver.findElement(By.xpath("//div[@title='CEIC Analytics']")).click();
				  Thread.sleep(4500);
					 Actions action = new Actions(login.driver);
						WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
						action.contextClick(RightclickonInsight).build().perform();
						 Thread.sleep(2500);
						login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
						 Thread.sleep(3500);
							login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
					    Thread.sleep(3500);
					    login.driver.findElement(By.xpath("	//div[@class='header-menu-item--dropdown']/div[10]")).click();
					    Thread.sleep(4500);
					    WebElement Thematic_Analysis = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Thematic_Analysis")));
						 login.Log4j.info("Is 'Thematic_Analysis' Displayed? - True/False:: " + Thematic_Analysis.isDisplayed());
						  Assert.assertEquals(true,Thematic_Analysis.isDisplayed());
							  Thread.sleep(2500);
							  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
						    Thread.sleep(1500);
							  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 }
			 if(arg2.equalsIgnoreCase(arg2)){
				
				 Thread.sleep(5500);
				 login.driver.findElement(By.xpath("//div[@title='Insights that other users have shared with you']")).click();
				 Thread.sleep(4500);
				 Actions action = new Actions(login.driver);
					WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
					action.contextClick(RightclickonInsight).build().perform();
					 Thread.sleep(2500);
					login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
					 Thread.sleep(3500);
						login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
				    Thread.sleep(3500);
				    login.driver.findElement(By.xpath("	//div[@class='header-menu-item--dropdown']/div[10]")).click();
				    Thread.sleep(4500);
				    WebElement Thematic_Analysis = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Thematic_Analysis")));
					 login.Log4j.info("Is 'Thematic_Analysis' Displayed? - True/False:: " + Thematic_Analysis.isDisplayed());
					  Assert.assertEquals(true,Thematic_Analysis.isDisplayed());
						  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
					    Thread.sleep(1500);
						  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 }
			 if(arg3.equalsIgnoreCase(arg3)){
				 Thread.sleep(5500);
				 login.driver.findElement(By.xpath("//div[@title='Insights that you have worked with last time']")).click();
				 Thread.sleep(4500);
				 Actions action = new Actions(login.driver);
					WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
					action.contextClick(RightclickonInsight).build().perform();
					 Thread.sleep(2500);
					login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
					 Thread.sleep(3500);
						login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
				    Thread.sleep(3500);
				    login.driver.findElement(By.xpath("	//div[@class='header-menu-item--dropdown']/div[10]")).click();
				    Thread.sleep(4500);
				    WebElement Thematic_Analysis = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Thematic_Analysis")));
					 login.Log4j.info("Is 'Thematic_Analysis' Displayed? - True/False:: " + Thematic_Analysis.isDisplayed());
					  Assert.assertEquals(true,Thematic_Analysis.isDisplayed());
						  Thread.sleep(2500);
						  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
					    Thread.sleep(1500);
						  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 }
			 if(arg4.equalsIgnoreCase(arg4)){
				 Thread.sleep(5500);
				 login.driver.findElement(By.xpath("//div[@title='All insights you have access to']")).click();
				 Thread.sleep(4500);
				 Actions action = new Actions(login.driver);
					WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
					action.contextClick(RightclickonInsight).build().perform();
					 Thread.sleep(2500);
					login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
					 Thread.sleep(3500);
						login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
				    Thread.sleep(3500);
				    login.driver.findElement(By.xpath("	//div[@class='header-menu-item--dropdown']/div[10]")).click();
				    Thread.sleep(4500);
				    WebElement Thematic_Analysis = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Thematic_Analysis")));
					 login.Log4j.info("Is 'Thematic_Analysis' Displayed? - True/False:: " + Thematic_Analysis.isDisplayed());
					  Assert.assertEquals(true,Thematic_Analysis.isDisplayed());
						  Thread.sleep(2500);
						  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
					    Thread.sleep(1500);
						  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 }
			  Thread.sleep(1500);
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Remove_icon_for_filters"))).click();
		}
		@Given("^Select the categories as Markets for the insight$")
		public void select_the_categories_as_Markets_for_the_insight() throws Throwable {
			Thread.sleep(5500);
			login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
			Thread.sleep(5500);
			login.driver.findElement(By.xpath("//div[@title='Insights that you have created']")).click();
			
			 Thread.sleep(4500);
			 Actions action = new Actions(login.driver);
				WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
				action.contextClick(RightclickonInsight).build().perform();
				 Thread.sleep(2500);
				login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
				 Thread.sleep(3500);
					login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
			    Thread.sleep(3500);
			    login.driver.findElement(By.xpath("//div[@class='header-menu-item--dropdown']/div[10]")).click();
			    Thread.sleep(4500);
			    login.driver.findElement(By.xpath("//div[@class='insight-settings-general']/div[4]/div/div/a/span[2]/b")).click();
			    Thread.sleep(4500);
			    login.driver.findElement(By.xpath("//ul[@class='select2-results']/li[6]/div/div[2]")).click();
			    Thread.sleep(4500);
			    login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
			    Thread.sleep(2500);
				  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			    Thread.sleep(1500);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}

		@Given("^Select the categories option as Markets option$")
		public void select_the_categories_option_as_Markets_option() throws Throwable {
			Thread.sleep(1500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_category"))).click();
			 Thread.sleep(1500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Markets"))).click();
		}

		@Given("^verify the  Markets category in \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
		public void verify_the_Markets_category_in(String arg1, String arg2, String arg3, String arg4) throws Throwable {
			Thread.sleep(1500);
			 if(arg1.equalsIgnoreCase(arg1)){
				 Thread.sleep(2500);
				  login.driver.findElement(By.xpath("//div[@title='CEIC Analytics']")).click();
				  Thread.sleep(4500);
					 Actions action = new Actions(login.driver);
						WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
						action.contextClick(RightclickonInsight).build().perform();
						 Thread.sleep(2500);
						login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
						 Thread.sleep(3500);
							login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
					    Thread.sleep(3500);
					    login.driver.findElement(By.xpath("	//div[@class='header-menu-item--dropdown']/div[10]")).click();
					    Thread.sleep(4500);
					    WebElement Markets = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Markets")));
						 login.Log4j.info("Is 'Markets' Displayed? - True/False:: " + Markets.isDisplayed());
						  Assert.assertEquals(true,Markets.isDisplayed());
							  Thread.sleep(2500);
							  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
						    Thread.sleep(1500);
							  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 }
			 if(arg2.equalsIgnoreCase(arg2)){
				
				 Thread.sleep(5500);
				 login.driver.findElement(By.xpath("//div[@title='Insights that other users have shared with you']")).click();
				 Thread.sleep(4500);
				 Actions action = new Actions(login.driver);
					WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
					action.contextClick(RightclickonInsight).build().perform();
					 Thread.sleep(2500);
					login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
					 Thread.sleep(3500);
						login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
				    Thread.sleep(3500);
				    login.driver.findElement(By.xpath("	//div[@class='header-menu-item--dropdown']/div[10]")).click();
				    Thread.sleep(4500);
				    WebElement Markets = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Markets")));
					 login.Log4j.info("Is 'Markets' Displayed? - True/False:: " + Markets.isDisplayed());
					  Assert.assertEquals(true,Markets.isDisplayed());
						  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
					    Thread.sleep(1500);
						  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 }
			 if(arg3.equalsIgnoreCase(arg3)){
				 Thread.sleep(5500);
				 login.driver.findElement(By.xpath("//div[@title='Insights that you have worked with last time']")).click();
				 Thread.sleep(4500);
				 Actions action = new Actions(login.driver);
					WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
					action.contextClick(RightclickonInsight).build().perform();
					 Thread.sleep(2500);
					login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
					 Thread.sleep(3500);
						login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
				    Thread.sleep(3500);
				    login.driver.findElement(By.xpath("	//div[@class='header-menu-item--dropdown']/div[10]")).click();
				    Thread.sleep(4500);
				    WebElement Markets = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Markets")));
					 login.Log4j.info("Is 'Markets' Displayed? - True/False:: " + Markets.isDisplayed());
					  Assert.assertEquals(true,Markets.isDisplayed());
						  Thread.sleep(2500);
						  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
					    Thread.sleep(1500);
						  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 }
			 if(arg4.equalsIgnoreCase(arg4)){
				 Thread.sleep(5500);
				 login.driver.findElement(By.xpath("//div[@title='All insights you have access to']")).click();
				 Thread.sleep(4500);
				 Actions action = new Actions(login.driver);
					WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
					action.contextClick(RightclickonInsight).build().perform();
					 Thread.sleep(2500);
					login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
					 Thread.sleep(3500);
						login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
				    Thread.sleep(3500);
				    login.driver.findElement(By.xpath("	//div[@class='header-menu-item--dropdown']/div[10]")).click();
				    Thread.sleep(4500);
				    WebElement Markets = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Markets")));
					 login.Log4j.info("Is 'Markets' Displayed? - True/False:: " + Markets.isDisplayed());
					  Assert.assertEquals(true,Markets.isDisplayed());
						  Thread.sleep(2500);
						  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
					    Thread.sleep(1500);
						  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 }
			  Thread.sleep(1500);
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Remove_icon_for_filters"))).click();
		}
		@Given("^Select the categories as New Datasets for the insight$")
		public void select_the_categories_as_New_Datasets_for_the_insight() throws Throwable {
			Thread.sleep(5500);
			login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
			Thread.sleep(5500);
			login.driver.findElement(By.xpath("//div[@title='Insights that you have created']")).click();
			
			 Thread.sleep(4500);
			 Actions action = new Actions(login.driver);
				WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
				action.contextClick(RightclickonInsight).build().perform();
				 Thread.sleep(2500);
				login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
				 Thread.sleep(3500);
					login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
			    Thread.sleep(3500);
			    login.driver.findElement(By.xpath("//div[@class='header-menu-item--dropdown']/div[10]")).click();
			    Thread.sleep(4500);
			    login.driver.findElement(By.xpath("//div[@class='insight-settings-general']/div[4]/div/div/a/span[2]/b")).click();
			    Thread.sleep(4500);
			    login.driver.findElement(By.xpath("//ul[@class='select2-results']/li[6]/div/div[2]")).click();
			    Thread.sleep(4500);
			    login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
			    Thread.sleep(2500);
				  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			    Thread.sleep(1500);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}

		@Given("^Select the categories option as New Datasets$")
		public void select_the_categories_option_as_New_Datasets() throws Throwable {
			 Thread.sleep(1500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_category"))).click();
			 Thread.sleep(1500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("New_Datasets"))).click();
		}

		@Given("^verify the New Datasets category in \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
		public void verify_the_New_Datasets_category_in(String arg1, String arg2, String arg3, String arg4) throws Throwable {
			Thread.sleep(1500);
			 if(arg1.equalsIgnoreCase(arg1)){
				 Thread.sleep(2500);
				  login.driver.findElement(By.xpath("//div[@title='CEIC Analytics']")).click();
				  Thread.sleep(4500);
					 Actions action = new Actions(login.driver);
						WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
						action.contextClick(RightclickonInsight).build().perform();
						 Thread.sleep(2500);
						login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
						 Thread.sleep(3500);
							login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
					    Thread.sleep(3500);
					    login.driver.findElement(By.xpath("	//div[@class='header-menu-item--dropdown']/div[10]")).click();
					    Thread.sleep(4500);
					    WebElement New_Datasets = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("New_Datasets")));
						 login.Log4j.info("Is 'New_Datasets' Displayed? - True/False:: " + New_Datasets.isDisplayed());
						  Assert.assertEquals(true,New_Datasets.isDisplayed());
							  Thread.sleep(2500);
							  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
						    Thread.sleep(1500);
							  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 }
			 if(arg2.equalsIgnoreCase(arg2)){
				
				 Thread.sleep(5500);
				 login.driver.findElement(By.xpath("//div[@title='Insights that other users have shared with you']")).click();
				 Thread.sleep(4500);
				 Actions action = new Actions(login.driver);
					WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
					action.contextClick(RightclickonInsight).build().perform();
					 Thread.sleep(2500);
					login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
					 Thread.sleep(3500);
						login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
				    Thread.sleep(3500);
				    login.driver.findElement(By.xpath("	//div[@class='header-menu-item--dropdown']/div[10]")).click();
				    Thread.sleep(4500);
				    WebElement New_Datasets = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("New_Datasets")));
					 login.Log4j.info("Is 'New_Datasets' Displayed? - True/False:: " + New_Datasets.isDisplayed());
					  Assert.assertEquals(true,New_Datasets.isDisplayed());
						  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
					    Thread.sleep(1500);
						  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 }
			 if(arg3.equalsIgnoreCase(arg3)){
				 Thread.sleep(5500);
				 login.driver.findElement(By.xpath("//div[@title='Insights that you have worked with last time']")).click();
				 Thread.sleep(4500);
				 Actions action = new Actions(login.driver);
					WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
					action.contextClick(RightclickonInsight).build().perform();
					 Thread.sleep(2500);
					login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
					 Thread.sleep(3500);
						login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
				    Thread.sleep(3500);
				    login.driver.findElement(By.xpath("	//div[@class='header-menu-item--dropdown']/div[10]")).click();
				    Thread.sleep(4500);
				    WebElement New_Datasets = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("New_Datasets")));
					 login.Log4j.info("Is 'New_Datasets' Displayed? - True/False:: " + New_Datasets.isDisplayed());
					  Assert.assertEquals(true,New_Datasets.isDisplayed());
						  Thread.sleep(2500);
						  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
					    Thread.sleep(1500);
						  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 }
			 if(arg4.equalsIgnoreCase(arg4)){
				 Thread.sleep(5500);
				 login.driver.findElement(By.xpath("//div[@title='All insights you have access to']")).click();
				 Thread.sleep(4500);
				 Actions action = new Actions(login.driver);
					WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
					action.contextClick(RightclickonInsight).build().perform();
					 Thread.sleep(2500);
					login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
					 Thread.sleep(3500);
						login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
				    Thread.sleep(3500);
				    login.driver.findElement(By.xpath("	//div[@class='header-menu-item--dropdown']/div[10]")).click();
				    Thread.sleep(4500);
				    WebElement New_Datasets = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("New_Datasets")));
					 login.Log4j.info("Is 'New_Datasets' Displayed? - True/False:: " + New_Datasets.isDisplayed());
					  Assert.assertEquals(true,New_Datasets.isDisplayed());
						  Thread.sleep(2500);
						  login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
					    Thread.sleep(1500);
						  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 }
			  Thread.sleep(1500);
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Remove_icon_for_filters"))).click();
		
		}
		@Given("^Select CopyLink options$")
		public void select_CopyLink_options() throws Throwable {
			 Thread.sleep(2500);
			  login.driver.findElement(By.xpath("//div[@class='items-wrapper']/li[6]")).click();
			  Thread.sleep(2500);
			  CopylinkRightclick = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
		}

		@Given("^Successfully Verify CopyLink insight option is working$")
		public void successfully_Verify_CopyLink_insight_option_is_working() throws Throwable {
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
	          ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
			    login.driver.switchTo().window(tabs2.get(1));
			    
			    
			    String Copylinkinsightname = login.driver.findElement(By.xpath("//div[@class='page-main-header--title-field-text']")).getText();
			    
				System.out.println(  CopylinkRightclick +":"+ Copylinkinsightname);
				if(CopylinkRightclick.equalsIgnoreCase(Copylinkinsightname)){
				  System.out.println("Copy link Option is working Successfully");
				  }else{
					  Assert.fail("Copy link Option is NOT working Successfully");
				  }
			  login.driver.close();
			    login.driver.switchTo().window(tabs2.get(0));
		}
		
		@Given("^Change the insight name as \"([^\"]*)\"$")
		public void change_the_insight_name_as(String arg1) throws Throwable {
			Thread.sleep(5500);
			login.driver.findElement(By.xpath("//div[@title='Click to edit the Insight']")).click();
			Thread.sleep(5500);
			login.driver.findElement(By.xpath("//div[@class='page-main-header--title-field']/input")).sendKeys(arg1);
			
			
		}

		@Given("^Search for the ID \"([^\"]*)\"$")
		public void search_for_the_ID(String arg1) throws Throwable {
			
			Thread.sleep(6000);
			login.driver.findElement(By.xpath("//input[@class='search-input-text']")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//input[@class='search-input-text']")).clear();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(arg1);
			Thread.sleep(5000);
			login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
			Thread.sleep(5000);
			login.driver.findElement(By.xpath("//div[@class='add-to-data-selection--icon']")).click();
			Thread.sleep(8500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}

		@Given("^Verify the insight name as \"([^\"]*)\" for Successful landing page search with Series ID as \"([^\"]*)\"$")
		public void verify_the_insight_name_as_for_Successful_landing_page_search_with_Series_ID_as(String arg1, String arg2) throws Throwable {
			Thread.sleep(5000);
			login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
			Thread.sleep(5000);
			 login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).click();
			 Thread.sleep(5000);
			 login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).sendKeys(arg2);
			 Thread.sleep(5000);
			 String Myinsightsearch = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
				System.out.println(arg1 + ":" + Myinsightsearch);
				if(arg1.equalsIgnoreCase(Myinsightsearch))
				{
					  System.out.println("Landing page Search with Series ID is working Successfully");
					  HTML_Report.strTCResult="PASS";
					  HTML_Report.execRemarks="Landing page Search with Series ID is working Successfully";
					  login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).clear();
					  }else
					  {
						  Assert.fail("Landing page Search with Series ID NOT working Successfully");
						  HTML_Report.strTCResult="FAIL";
						  HTML_Report.execRemarks="Landing page Search with Series ID NOT working Successfully";
					  }
				 login.driver.findElement(By.xpath("//button[@class='insights-search-filter--reset-icon icon--red-cross']")).click();
				
		}
		@Given("^Select the insight to be search$")
		public void select_the_insight_to_be_search() throws Throwable {
			Thread.sleep(1500);
			login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
			 Thread.sleep(3000);
			    Actions action = new Actions(login.driver);
				WebElement we = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
				action.moveToElement(we).build().perform();
		}

		@Given("^Change the insight name as \"([^\"]*)\" in IE page$")
		public void change_the_insight_name_as_in_IE_page(String arg1) throws Throwable {
			Thread.sleep(1500);
			login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/div[2]")).click();
			Thread.sleep(1500);
			login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/div[1]")).click();
			Thread.sleep(1500);
			login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/div[1]/input")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(1500);
			login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/div[1]/input")).clear();
			Thread.sleep(1500);
			login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/div[1]/input")).sendKeys(arg1);
			Thread.sleep(1500);
			login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/div[3]")).click();
			
		}

		@Given("^Search for the insight name as  \"([^\"]*)\"$")
		public void search_for_the_insight_name_as(String arg1) throws Throwable {
			Thread.sleep(8000);
			 login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).click();
			 Thread.sleep(5000);
			 login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).clear();
			 Thread.sleep(8000);
			 login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).sendKeys(arg1);
		}

		@Given("^Verify the insight name as \"([^\"]*)\" for Successful landing page search by Name$")
		public void verify_the_insight_name_as_for_Successful_landing_page_search_by_Name(String arg1) throws Throwable {
			Thread.sleep(10000);
			String searchInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
			System.out.println(arg1 + ":" + searchInsight);
			Thread.sleep(5000);
			if(arg1.equalsIgnoreCase(searchInsight)){
				  System.out.println("Landing page Search with Name is working Successfully");
				  HTML_Report.strTCResult="PASS";
				  HTML_Report.execRemarks="Landing page Search with Name is working Successfully ";
				  login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).clear();
				  }else{
					  Assert.fail("Landing page Search with Name is NOT working Successfully");
					  HTML_Report.strTCResult="FAIL";
					  HTML_Report.execRemarks="Landing page Search with Name is NOT working Successfully";
				  }
			 login.driver.findElement(By.xpath("//button[@class='insights-search-filter--reset-icon icon--red-cross']")).click();
		}
		
		@Given("^Select search by name drop down$")
		public void select_search_by_name_drop_down() throws Throwable {
			Thread.sleep(500);
			login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//div[@class='insights-search-attributes dropdown dropdown__right']/div[1]/span/div")).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//div[@class='dropdown--body insights-search-attributes--content']/label[2]/span[1]")).click();
		}
		@Given("^Verify that insight should not display for Series ID when search by Name is selected$")
		public void verify_that_insight_should_not_display_for_Series_ID_when_search_by_Name_is_selected() throws Throwable {
			
			if(login.driver.findElements(By.xpath("//div[@class='search-create-item search-create-item__create-blank insight-list-empty--wrapper']")).size() != 0)
			{
				System.out.println("Landing page Search when  Name drop down is selected is working Successfully");
				 HTML_Report.strTCResult="PASS";
				  HTML_Report.execRemarks="Landing page Search when  Name drop down is selected is working Successfully ";
				  Thread.sleep(6000);
				  login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).clear();
				  Thread.sleep(6000);
					login.driver.findElement(By.xpath("//div[@class='insights-search-attributes dropdown dropdown__right']/div[1]/span/div")).click();
					Thread.sleep(6000);
					login.driver.findElement(By.xpath("//div[@class='dropdown--body insights-search-attributes--content']/label[1]")).click();
				  
				}else
				{
					 Assert.fail( "Landing page Search when  Name drop down is selected is NOT working Successfully");
					 HTML_Report.strTCResult="FAIL";
					  HTML_Report.execRemarks="Landing page Search when  Name drop down is selected is NOT working Successfully";
				   
				}
			
		}
		
		@Given("^Gives a Description as \"([^\"]*)\"$")
		public void gives_a_Description_as(String arg1) throws Throwable {
			 Thread.sleep(2500);
				login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
		    Thread.sleep(2500);
		    login.driver.findElement(By.xpath("//div[@class='header-menu-item--dropdown']/div[10]")).click();
		    Thread.sleep(2500);
		    login.driver.findElement(By.xpath("//div[@class='insight-settings-general']/div[5]/div/textarea")).sendKeys(arg1);
		    Thread.sleep(4500);
		    login.driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		  Thread.sleep(2500);
		  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}

		@Given("^Select Insight attributes drop down$")
		public void select_Insight_attributes_drop_down() throws Throwable {
			Thread.sleep(6000);
			login.driver.findElement(By.xpath("//div[@class='insights-search-attributes dropdown dropdown__right']/div[1]/span/div")).click();
			Thread.sleep(6000);
			login.driver.findElement(By.xpath("//div[@class='dropdown--body insights-search-attributes--content']/label[1]")).click();
			
			Thread.sleep(1000);
			
			if(login.driver.findElement(By.xpath("//div[@class='dropdown--body insights-search-attributes--content']/div/div[2]/label/span[1]")).isEnabled());
			{
				Thread.sleep(1000);
				login.driver.findElement(By.xpath("//div[@class='dropdown--body insights-search-attributes--content']/div/div[2]/label/span[1]")).click();
			
			}
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//div[@class='dropdown--button insights-search-attributes--button']")).click();
		}

		@Given("^Search with Description as \"([^\"]*)\" for search by all content - Insight attributes$")
		public void search_with_Description_as_for_search_by_all_content_Insight_attributes(String arg1) throws Throwable {
			Thread.sleep(500);
			login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
			Thread.sleep(5000);
			 login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).click();
			 Thread.sleep(5000);
			 login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).clear();
			 Thread.sleep(5000);
			 login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).sendKeys(arg1);
		}

		@Given("^Verify the insight as \"([^\"]*)\" with Description \"([^\"]*)\" for search by all content - Insight attributes$")
		public void verify_the_insight_as_with_Description_for_search_by_all_content_Insight_attributes(String arg1, String arg2) throws Throwable {
			Thread.sleep(5000);
			String searchInsightwithInsightattributes = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
			System.out.println(arg1 + ":" + searchInsightwithInsightattributes);
			
			if(arg1.equalsIgnoreCase(searchInsightwithInsightattributes))
			{
				  System.out.println("Landing page Search for search by all content - Insight attributes is Verified Successfully");
				
				  }else
				  {
					  Assert.fail("Landing page Search for search by all content - Insight attributes is NOT Verified Successfully");
			
				  }
			 Actions action = new Actions(login.driver);
				WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
				action.contextClick(RightclickonInsight).build().perform();
				Thread.sleep(5000);
				 login.driver.findElement(By.xpath("//div[@class='items-wrapper']/li[2]")).click();
				 Thread.sleep(2500);
					login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
			    Thread.sleep(2500);
			    login.driver.findElement(By.xpath("//div[@class='header-menu-item--dropdown']/div[10]")).click();
			    Thread.sleep(2500);
			    String searchInsightwithInsightattributesDescription =login.driver.findElement(By.xpath("//div[@class='insight-settings-general']/div[5]/div/textarea")).getText();
			    System.out.println(arg2 + ":" + searchInsightwithInsightattributesDescription);
			    Thread.sleep(2500);
				if(arg2.equalsIgnoreCase(searchInsightwithInsightattributesDescription))
				{
					  System.out.println("Landing page Search for search by all content - Insight attributes is Verified Successfully");
					  HTML_Report.strTCResult="PASS";
					  HTML_Report.execRemarks="Landing page Search for search by all content - Insight attributes is Verified Successfully ";
					 
					  }else
					  {
						  Assert.fail("Landing page Search for search by all content - Insight attributes is NOT Verified Successfully");
						  HTML_Report.strTCResult="FAIL";
						  HTML_Report.execRemarks="Landing page Search for search by all content - Insight attributes is NOT Verified Successfully";
					  }
				  Thread.sleep(2500);
				login.driver.findElement(By.xpath("//div[@class='insight-settings-general']/div[5]/div/textarea")).clear();
				 Thread.sleep(2500);
					login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
					Thread.sleep(2500);
					  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
				
		}
		

	@Given("^Take a copy of the series ID$")
	public void take_a_copy_of_the_series_ID() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();	
		for(int i=1;i<=1;i++){
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath("//ul[@class='search-series-list scrollable']/li[" + i + "]/div/a/div[2]")).click();
		}
		Thread.sleep(6000);
		 Robot r = new Robot();
		 r.keyPress(KeyEvent.VK_A);
		 r.keyRelease(KeyEvent.VK_A);
		 Thread.sleep(2000);
			Actions action = new Actions(login.driver);
			WebElement SeriesSSPWindow = login.driver.findElement(By.xpath("//ul[@class='search-series-list scrollable']/li[1]/div/a[1]/div[1]"));
			action.moveToElement(SeriesSSPWindow).build().perform();
			 Thread.sleep(2000);
			login.driver.findElement(By.xpath("//ul[@class='search-series-list scrollable']/li[1]/div/a[1]/div[1]")).click();
			 Thread.sleep(2000);
			 String SeriesIDforSeriesAttributes = login.driver.findElement(By.xpath("//div[@class='main-series-information--data']/div[2]/div[1]/div[1]")).getText();
			  String SeriesIDforSeriesAttribute = SeriesIDforSeriesAttributes.substring(4,13); 
				System.out.println(SeriesIDforSeriesAttribute);
				Thread.sleep(3000);
				login.driver.findElement(By.xpath("//div[@class='movable-modal--close']")).click();	
				Thread.sleep(2500);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
	}
	
	@Given("^Select Insight attributes drop down as Series attributes$")
	public void select_Insight_attributes_drop_down_as_Series_attributes() throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='insights-search-attributes dropdown dropdown__right']/div[1]/span/div")).click();
		Thread.sleep(6000);
		login.driver.findElement(By.xpath("//div[@class='dropdown--body insights-search-attributes--content']/label[1]")).click();
		
		Thread.sleep(1000);
		
		if(login.driver.findElement(By.xpath("//div[@class='dropdown--body insights-search-attributes--content']/div/div[1]/label/span[1]")).isEnabled());
		{
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@class='dropdown--body insights-search-attributes--content']/div/div[1]/label/span[1]")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@class='dropdown--body insights-search-attributes--content']/div/div[2]/label/span[1]")).click();
		
		}
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='dropdown--button insights-search-attributes--button']")).click();
	}
	
	@Given("^Search for the Series ID in IE Page as \"([^\"]*)\"$")
	public void search_for_the_Series_ID_in_IE_Page_as(String arg1) throws Throwable {
		Thread.sleep(500);
		login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
		 Thread.sleep(5000);
		 login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).clear();
		Thread.sleep(5000);
		 login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).click();
		 Thread.sleep(5000);
		 //System.out.println("******"+SeriesIDforSeriesAttribute);
		 login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).sendKeys(arg1);
		 //(SeriesIDforSeriesAttribute)369703417,String.valueOf(SeriesIDforSeriesAttribute);
	}
	
	
	@Given("^Verify the insight as \"([^\"]*)\" with Series ID as \"([^\"]*)\" for search as by all content - Series attributes$")
	public void verify_the_insight_as_with_Series_ID_as_for_search_as_by_all_content_Series_attributes(String arg1, String arg2) throws Throwable {
		Thread.sleep(8000);
		String InsightnameforSeriesattributessearch =login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
		Thread.sleep(1000);
		System.out.println( arg1 + ":" + InsightnameforSeriesattributessearch);
		if(arg1.equalsIgnoreCase(InsightnameforSeriesattributessearch))
		{
			System.out.println("Series ID search as by all content - Series attributes is verified Successfully");
			
		}
		else{
			 Assert.fail( "Series ID search as by all content - Series attributes is NOT verified Successfully.");
			
		}
		Thread.sleep(5000);
		 Actions action = new Actions(login.driver);
			WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
			action.contextClick(RightclickonInsight).build().perform();
			 Thread.sleep(8000);
			 login.driver.findElement(By.xpath("//div[@class='items-wrapper']/li[2]")).click();
			 Thread.sleep(6000);
			 login.driver.findElement(By.xpath("//div[@class='view-selection--btn-icon view-selection--btn-icon__my-series']")).click();
			 Thread.sleep(8000);
			 Actions action1 = new Actions(login.driver);
				WebElement we = login.driver.findElement(By.xpath("	//div[@title='Show Series Info']"));
				action1.moveToElement(we).build().perform();
			 login.driver.findElement(By.xpath("	//div[@title='Show Series Info']")).click();

			 String VerifyingSeriesIDforSeriesAttributes = login.driver.findElement(By.xpath("//div[@class='main-series-information--data']/div[2]/div[1]/div[1]")).getText();
			  String SeriesIDforSeriesAttribute = VerifyingSeriesIDforSeriesAttributes.substring(4,13); 
				System.out.println(SeriesIDforSeriesAttribute);
				Thread.sleep(3000);
				System.out.println( arg2 + ":" + SeriesIDforSeriesAttribute);
				if(arg2.equalsIgnoreCase(SeriesIDforSeriesAttribute))
				{
					System.out.println("Series ID search as by all content - Series attributes is verified Successfully");
					HTML_Report.strTCResult="PASS";
					  HTML_Report.execRemarks="Series ID search as by all content - Series attributes is verified Successfully ";
					
				}
				else{
					 Assert.fail( "Series ID search as by all content - Series attributes is NOT verified Successfully.");
					 HTML_Report.strTCResult="FAIL";
					  HTML_Report.execRemarks="Series ID search as by all content - Series attributes is NOT verified Successfully.";
				}
				login.driver.findElement(By.xpath("//div[@class='movable-modal--close']")).click();	
				Thread.sleep(2500);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
	}
	@Given("^unSelect Insight attributes drop down$")
	public void unselect_Insight_attributes_drop_down() throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='insights-search-attributes dropdown dropdown__right']/div[1]/span/div")).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='dropdown--body insights-search-attributes--content']/label[1]")).click();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath("//div[@class='dropdown--body insights-search-attributes--content']/div/div[1]/label/span[1]")).click();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath("//div[@class='dropdown--body insights-search-attributes--content']/div/div[2]/label/span[1]")).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='dropdown--button insights-search-attributes--button']")).click();
	}
	
	@Given("^Verify that insight should not display for Series ID when all checkboxes unselected$")
	public void verify_that_insight_should_not_display_for_Series_ID_when_all_checkboxes_unselected() throws Throwable {
		Thread.sleep(500);
		login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
		Thread.sleep(5000);
		if(login.driver.findElements(By.xpath("//div[@class='search-create-item search-create-item__create-blank insight-list-empty--wrapper']")).size() != 0)
		{
			System.out.println("Search by all content with all checkboxes Unselected is working Successfully");
			 HTML_Report.strTCResult="PASS";
			  HTML_Report.execRemarks="Search by all content with all checkboxes Unselected is working Successfully";
			  login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).clear();
			}else
			{
				 Assert.fail( "Search by all content with all checkboxes Unselected is NOT working Successfully");
				 HTML_Report.strTCResult="FAIL";
				  HTML_Report.execRemarks="Search by all content with all checkboxes Unselected is NOT working Successfully";
			   
			}
		
	}
	@Given("^Verify that insight should not display for Invalid keyword$")
	public void verify_that_insight_should_not_display_for_Invalid_keyword() throws Throwable {
		Thread.sleep(500);
		login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
		Thread.sleep(5000);
		if(login.driver.findElements(By.xpath("//div[@class='search-create-item search-create-item__create-blank insight-list-empty--wrapper']")).size() != 0)
		{
			System.out.println("Search for Invalid keyword is Verified Successfully");
			 HTML_Report.strTCResult="PASS";
			  HTML_Report.execRemarks="Search for Invalid keyword is Verified Successfully";
			  login.driver.findElement(By.xpath("//input[@class='insights-search-filter--input']")).clear();
			}else
			{
				 Assert.fail( "Search for Invalid keyword is Not Verified Successfully");
				 HTML_Report.strTCResult="FAIL";
				  HTML_Report.execRemarks="Search for Invalid keyword is Not Verified Successfully";
			}
		

	}
	@And("^Select the Create insight button$")
	public void select_the_Create_insight_button() throws Throwable {
		Thread.sleep(500);
		login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
		Thread.sleep(500);
		login.driver.findElement(By.xpath("//div[@class='button button__primary btn-block link__upper']")).click();
		
	}

	@And("^Verify that Create insight pop up Appear$")
	public void verify_that_Create_insight_pop_up_Appear() throws Throwable {
		Thread.sleep(5000);
		if(login.driver.findElements(By.xpath("//h4[@class='modal-title sphere-modal__title text-dots']")).size() != 0)
		{
			System.out.println("Create insight pop up Appeared Successfully");
			 HTML_Report.strTCResult="PASS";
			  HTML_Report.execRemarks="Create insight pop up Appeared Successfully";
			}else
			{
				 Assert.fail( "Create insight pop up Did'nt Appeared Successfully");
				 HTML_Report.strTCResult="FAIL";
				  HTML_Report.execRemarks="Search for Invalid keyword is Not Verified Successfully";  
			}
		Thread.sleep(500);
		login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		
	}
	
	@Given("^Create a insight name as \"([^\"]*)\"$")
	public void create_a_insight_name_as(String arg1) throws Throwable {
		Thread.sleep(3500);
		login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']/div/input")).click();
		Thread.sleep(3500);
		login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']/div[1]/input")).clear();
		Thread.sleep(3500);
		login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']/div[1]/input")).sendKeys(arg1);
		Thread.sleep(8500);
		login.driver.findElement(By.xpath("//div[@class='sphere-modal-controls']/button[2]")).click();
		Thread.sleep(3500);
		 NewInsightnameForInvalidKeyword = login.driver.findElement(By.xpath("//div[@title='Click to edit the Insight']")).getText();
		  System.out.println( arg1 + ":" + NewInsightnameForInvalidKeyword);
			if(arg1.equalsIgnoreCase(NewInsightnameForInvalidKeyword))
			{
				System.out.println("Insight Had been created Successfully !!");
			}
			else{
				 Assert.fail( "Insight Had been NOT been created Successfully !! ");
			}
			Thread.sleep(2500);
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
	}

	@Given("^Verify that Create insight Functionality is working by creating Insight$")
	public void verify_that_Create_insight_Functionality_is_working_by_creating_Insight() throws Throwable {
		 Thread.sleep(5000);
		 login.driver.findElement(By.xpath("//button[@class='insights-search-filter--reset-icon icon--red-cross']")).click();
		 Thread.sleep(5000);
		 String Insightnamecreatedatinvalidkeyword =login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
			Thread.sleep(5000);
			System.out.println( NewInsightnameForInvalidKeyword + ":" + Insightnamecreatedatinvalidkeyword);
			if(NewInsightnameForInvalidKeyword.equalsIgnoreCase(Insightnamecreatedatinvalidkeyword))
			{
				System.out.println("Insight Had been created Successfully !!");
				HTML_Report.strTCResult="PASS";
				  HTML_Report.execRemarks="Insight Had been created Successfully !! ";
				
			}
			else{
				 Assert.fail( "Insight Had been NOT been created Successfully !! ");
				 HTML_Report.strTCResult="FAIL";
				  HTML_Report.execRemarks="Insight Had been NOT been created Successfully !! " ;
	}
	}
	@And("^Select the Search Dropdown$")
	public void select_the_Search_Dropdown() throws Throwable {
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("//div[@class='insights-search-attributes dropdown dropdown__right']/div[1]/span/div")).click();
		
	}

	@And("^Select Search by name$")
	public void select_Search_by_name() throws Throwable {
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("//div[@class='dropdown--body insights-search-attributes--content']/label[2]")).click();
	}

	@And("^Verify that Insight attributes and Series attributes in search drop down is disabled$")
	public void verify_that_Insight_attributes_and_Series_attributes_in_search_drop_down_is_disabled() throws Throwable {
		select_the_Search_Dropdown();
		Thread.sleep(9000);
		boolean CheckboxDefaultStatus = login.driver.findElement(By.xpath("//div[@class='dropdown--body insights-search-attributes--content']/label[1]")).isSelected();
		
			if (CheckboxDefaultStatus == true)
			{
				
				  Assert.fail( "Insight attributes and Series attributes in search drop down is NOT disabled Successfully !! ");
					 HTML_Report.strTCResult="FAIL";
					  HTML_Report.execRemarks="Insight attributes and Series attributes in search drop down is NOT disabled Successfully !! " ;
			}
			else{
				System.out.println("Insight attributes and Series attributes in search drop down is disabled Successfully !!");
				HTML_Report.strTCResult="PASS";
				  HTML_Report.execRemarks="Insight attributes and Series attributes in search drop down is disabled Successfully !! ";
	
			}
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[@class='dropdown--button insights-search-attributes--button']")).click();
		
		}
	@And("^Applay Tag for the insight \"([^\"]*)\"$")
	public void applay_Tag_for_the_insight(String arg1) throws Throwable {
		Thread.sleep(500);
		login.driver.findElement(By.xpath("//div[@title='View as a table']")).click();
		 Actions action = new Actions(login.driver);
			WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[2]/div[2]/div/a"));
			action.contextClick(RightclickonInsight).build().perform();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//div[@class='items-wrapper']/li[9]")).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//div[@class='form-group']")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//input[@class='ui-widget-content ui-autocomplete-input']")).sendKeys("ApplayFilterSearch");
			Thread.sleep(500);
			login.driver.findElement(By.xpath("//div[@class='modal-header sphere-modal__header']")).click();
			Thread.sleep(500);
			login.driver.findElement(By.xpath("//div[@class='sphere-modal-controls']/button[2]")).click();
			
	}
	
	@And("^Applay tag filter on the Landing page$")
	public void applay_tag_filter_on_the_Landing_page() throws Throwable {
		select_the_All_tag_dropdown();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//span[contains(text(),'ApplayFilterSearch')] ")).click();
		
	}
	@And("^Take the count of the insight$")
	public void take_the_count_of_the_insight() throws Throwable {
		
	}
	@Given("^Verify the search with in available insights and work with respect to the applied filters\\.$")
	public void verify_the_search_with_in_available_insights_and_work_with_respect_to_the_applied_filters() throws Throwable {
		
		Thread.sleep(10000);
		List<WebElement> objLinks = login.driver.findElements(By.xpath("//div[@class='insights-grid-body']/div"));
		System.out.println("Total Insights are- " + objLinks.size());
		int Insightcountforfiltersearch = objLinks.size();
		
		select_the_All_tag_dropdown();
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("//span[contains(text(),'ApplayFilterSearch')] ")).click();
		
		Thread.sleep(10000);
		List<WebElement> objLinks1 = login.driver.findElements(By.xpath("//div[@class='insights-grid-body']/div"));
		System.out.println("Total Insights are- " + objLinks1.size());
		int Insightcountafterforfiltersearch = objLinks1.size();
		System.out.println( Insightcountafterforfiltersearch + ":" + Insightcountforfiltersearch);
		if(Insightcountafterforfiltersearch < Insightcountforfiltersearch)
		{
			System.out.println("Landing page Search when any filter is applied is Verified Successfully !!");
			HTML_Report.strTCResult="PASS";
			  HTML_Report.execRemarks="Landing page Search when any filter is applied is Verified Successfully !!";
			  Thread.sleep(6000);
				login.driver.findElement(By.xpath("//button[@class='insights-search-filter--reset-icon icon--red-cross']")).click();
				 Thread.sleep(6000);
				login.driver.findElement(By.xpath("//div[@class='landing-content--filters-panel']/div[2]/div/div/div/div/span")).click();
		}
		else{
			 Assert.fail( "Landing page Search when any filter is applied is NOT Verified Successfully !! ");
			 HTML_Report.strTCResult="FAIL";
			  HTML_Report.execRemarks="Landing page Search when any filter is applied is NOT Verified Successfully !!" ;
}
	}
	@Given("^navigate to Analytics tab$")
	public void navigate_to_Analytics_tab() throws Throwable {
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("//div[@class='insights-groups']/div[3]")).click();
		
	}

	@Given("^Verify message for no insights search in current tab$")
	public void verify_message_for_no_insights_search_in_current_tab() throws Throwable {
		
		if(login.driver.findElements(By.xpath("//span[contains(text(),'No insights were found in this group. But there are some in the other one - ')] ")).size() != 0)
		{
			System.out.println("Message for No insights search in Other tab is Verified Successfully");
			 HTML_Report.strTCResult="PASS";
			  HTML_Report.execRemarks="Message for No insights search in Other tab is Verified Successfully";
			  Thread.sleep(6000);
				login.driver.findElement(By.xpath("//button[@class='insights-search-filter--reset-icon icon--red-cross']")).click();
				Thread.sleep(8000);
				login.driver.findElement(By.xpath("//div[@class='insights-groups']/div[2]")).click();
			}else
			{
				 Assert.fail( "Message for No insights search in Other tab is Not Verified Successfully");
				 HTML_Report.strTCResult="FAIL";
				  HTML_Report.execRemarks="Message for No insights search in Other tab is Not Verified Successfully";
			}
		
		
	}

	@And("^Change the Insight name as \"([^\"]*)\"$")
	public void change_the_Insight_name_as(String arg1) throws Throwable {
		Thread.sleep(5500);
		login.driver.findElement(By.xpath("//div[@title='Click to edit the Insight']")).click();
		Thread.sleep(5500);
		login.driver.findElement(By.xpath("//div[@class='page-main-header--title-field']/input")).sendKeys(arg1);
		Thread.sleep(2500);
		  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
	}
	
	@Given("^Verify All available hyperlink functionality is working$")
	public void verify_All_available_hyperlink_functionality_is_working() throws Throwable {
		Thread.sleep(5500);
		login.driver.findElement(By.xpath("//span[contains(text(),'All available')]")).click();
		Thread.sleep(5500);
		if(login.driver.findElements(By.xpath("//div[@class='insights-groups']/div[6]/span[3]/span")).size() != 0)
		{
			System.out.println("Create insight pop up Appeared Successfully");
			 
			}else
			{
				 Assert.fail( "Create insight pop up Did'nt Appeared Successfully");
				
			}
		Thread.sleep(5500);
		String Insightcountforallhyperlinkinalltabs = login.driver.findElement(By.xpath("//div[@class='insights-groups']/div[6]/span[3]/span")).getText();
		int Insightcountforallhyperlinkinalltab = Integer.parseInt(Insightcountforallhyperlinkinalltabs);
		System.out.println(Insightcountforallhyperlinkinalltab);
		Thread.sleep(5500);
		List<WebElement> objLinks = login.driver.findElements(By.xpath("//div[@class='insights-grid-body']/div"));
		System.out.println("Total Insights are- " + objLinks.size());
		Thread.sleep(5500);
		int Insightcountforallhyperlink = objLinks.size();
		Thread.sleep(5500);
		System.out.println( Insightcountforallhyperlinkinalltab + ":" + Insightcountforallhyperlink);
		if(Insightcountforallhyperlinkinalltab == (Insightcountforallhyperlink))
		{
			System.out.println("All available hyperlink for no insights search in Other tab than Myinsight is verified Successfully");
			 HTML_Report.strTCResult="PASS";
			  HTML_Report.execRemarks="All available hyperlink for no insights search in Other tab than Myinsight is verified Successfully";
				Thread.sleep(6000);
				login.driver.findElement(By.xpath("//button[@class='insights-search-filter--reset-icon icon--red-cross']")).click();
				Thread.sleep(8000);
				login.driver.findElement(By.xpath("//div[@class='insights-groups']/div[2]")).click();
		}else
			{
				 Assert.fail( "All available hyperlink for no insights search in Other tab than Myinsight is verified Successfully");
				 HTML_Report.strTCResult="FAIL";
				  HTML_Report.execRemarks="All available hyperlink for no insights search in Other tab than Myinsight is NOT verified Successfully";  
			}
		
	}
	@And("^Verify the number of insight count with search$")
	public void verify_the_number_of_insight_count_with_search() throws Throwable {
		Thread.sleep(5500);
		String InsightcountforallhyperlinkinMyinsighttabs = login.driver.findElement(By.xpath("//div[@class='insights-groups']/div[6]/span[3]/span")).getText();
		int InsightcountforallhyperlinkinMyinsighttab = Integer.parseInt(InsightcountforallhyperlinkinMyinsighttabs);
		System.out.println(InsightcountforallhyperlinkinMyinsighttab);
		
		
		Thread.sleep(5500);
		List<WebElement> objLinks = login.driver.findElements(By.xpath("//div[@class='insights-grid-body']/div"));
		System.out.println("Total Insights are- " + objLinks.size());
		int Insightcountforinmysight = objLinks.size();
		System.out.println( InsightcountforallhyperlinkinMyinsighttab + ":" + Insightcountforinmysight);
		Thread.sleep(5500);
		if(InsightcountforallhyperlinkinMyinsighttab == (Insightcountforinmysight))
		{
			System.out.println("The number of insight count with search is verified Successfully");
			 HTML_Report.strTCResult="PASS";
			  HTML_Report.execRemarks="The number of insight count with search is verified Successfully";
				Thread.sleep(6000);
				login.driver.findElement(By.xpath("//button[@class='insights-search-filter--reset-icon icon--red-cross']")).click();
		}else
			{
				 Assert.fail( "The number of insight count with search is NOT verified Successfully");
				 HTML_Report.strTCResult="FAIL";
				  HTML_Report.execRemarks="The number of insight count with search is NOT verified Successfully";  
			}
		
		
		
	
	}

}


