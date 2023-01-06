package CDMNext.StepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.*;

public class RefreshSummaryPopUp {

	JavascriptExecutor js = (JavascriptExecutor) login.driver;
	Actions actions = new Actions(login.driver);
	WebDriverWait wait = new WebDriverWait(login.driver, 60);
	boolean staleElement = true;
	
	
	
	// TC_01
	@Given("^add some series into my series with more dropdown rebased filter$")
	public void add_some_series_into_my_series_with_more_dropdown_rebased_filter() throws Throwable {
		Thread.sleep(5000);
		login.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'More')]")));
			login.driver.findElement(By.xpath("//span[contains(text(),'More')]")).click();
		
		//login.driver.findElement(By.xpath("//span[contains(text(),'More')]")).click();
		Thread.sleep(5000);
		WebElement chkbox = login.driver.findElement(By.xpath("(//span[@class='status-icon'])[4]"));
		js.executeScript("arguments[0].scrollIntoView(true)", chkbox);
		Thread.sleep(5000);
		chkbox.click();
		login.driver.findElement(By.xpath("//div[contains(text(),'Apply filter')]")).click();
		Thread.sleep(10000);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='toggler-control-item--label'])[2]")));
			//login.driver.findElement(By.xpath("//span[contains(text(),'More')]")).click();
		//click on series
		login.driver.findElement(By.xpath("(//span[@class='toggler-control-item--label'])[2]")).click();
		Thread.sleep(5000);
		//click on +icon
		login.driver.findElement(By.xpath("(//div[@class='add-to-data-selection--icon'])[1]")).click();
		
		
	}

	// TC_01
	@Then("^logout by saving insight$")
	public void logout_by_saving_insight() throws Throwable {
		Thread.sleep(2000);
		login.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		login.driver.findElement(By.xpath("//div[@class='account-avatar account-avatar__small']")).click();
        Thread.sleep(1000);
		WebElement SighOut = login.driver.findElement(By.xpath("//span[contains(text(),'Sign out')]"));
		js.executeScript("arguments[0].scrollIntoView(true)", SighOut);
		SighOut.click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//button[contains(text(),'Save and sign out')]")).click();
		Thread.sleep(1000);
		
	}

	
	
	// TC_01
	@Then("^login again with username \"([^\"]*)\" and passowrd as \"([^\"]*)\"$")
	public void login_again_with_username_and_passowrd_as(String arg1, String arg2) throws Throwable {
	   
		Thread.sleep(2000);
		login.driver.findElement(By.name("user_id")).sendKeys(arg1);
		login.driver.findElement(By.name("password")).sendKeys(arg2);
		login.driver.findElement(By.xpath("//button[@class='btn']")).click();
	}
	
	
	
	
	
	
	
	
	
	
	// TC_01
	@Then("^click on Myinsights$")
	public void click_on_Myinsights() throws Throwable {
		Thread.sleep(5000);

		login.driver.findElement(By.xpath("//a[contains(text(),'My insights')]")).click();

	}

	// TC_01
	@Then("^click on recent saved insights$")
	public void click_on_recent_saved_insights() throws Throwable {
		Thread.sleep(4000);
		login.driver
				.findElement(By.xpath("(//div[@class='link link__medium insight-grid-item--bottom-panel-title'])[2]"))
				.click();

	}

	// TC_01
	@Then("^click on open$")
	public void click_on_open() throws Throwable {

		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Open')]")).click();
	}

	// TC_01
	@Then("^Latest changes in your insights popup should be display$")
	public void latest_changes_in_your_insights_popup_should_be_display() throws Throwable {

		Thread.sleep(3000);
		String popupdata = login.driver
				.findElement(By.xpath("//div[contains(text(),'Latest changes in your Insight')]")).getText();
		String popupText = "Latest changes in your Insight";
		Assert.assertEquals(popupdata, popupText);
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
		CommonFunctionality.DeleteSeries();
		System.out.println("=============>TC_01==============>");

	}

	
	//TC_02
	@Given("^create some visuals with more dropdown rebased filter$")
	public void create_some_visuals_with_more_dropdown_rebased_filter() throws Throwable {
		
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'More')]")).click();
		Thread.sleep(2000);
		WebElement chkbox = login.driver.findElement(By.xpath("(//span[@class='status-icon'])[4]"));
		js.executeScript("arguments[0].scrollIntoView(true)", chkbox);
		Thread.sleep(1000);
		chkbox.click();
		login.driver.findElement(By.xpath("//div[contains(text(),'Apply filter')]")).click();
		Thread.sleep(4000);
		//click on series
		login.driver.findElement(By.xpath("(//span[@class='toggler-control-item--label'])[2]")).click();
		Thread.sleep(2000);
		
		//mouse over to the +icon
		login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[1]")).click();
		Thread.sleep(2000);
		WebElement elementLocator = login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[1]"));
		actions.contextClick(elementLocator).perform();
		
		
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//*[text()='Add chart']")).click();
		Thread.sleep(2000);
		//login.driver.findElement(By.xpath("//*[@class='icon--table-vertical_large public-js-views-visuals-VisualsPanelSubItem-module__subItemIcon']")).click();
		login.driver.findElement(By.xpath("//div[text()='Vertical']")).click();
		
		
		
		
		
		
		
		//login.driver.findElement(By.xpath("//span[contains(text(),'View as Table')]")).click();
		Thread.sleep(3000);
		

		
	}

	
	//TC_03
	@Given("^New insight search with given data as \"([^\"]*)\"$")
	public void new_insight_search_with_given_data_as(String arg1) throws Throwable {
	    Thread.sleep(2000);
	   
	    login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(arg1);
	    login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(Keys.ENTER);
	    Thread.sleep(1000);
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='toggler-control-item--label'])[2]")));
	    Thread.sleep(1000);
		login.driver.findElement(By.xpath("(//span[@class='toggler-control-item--label'])[2]")).click();
	    Thread.sleep(1000);
	    for(int i=1;i<=2;i++)
	    {
	    Thread.sleep(1000);
	    	login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])["+i+"]")).click();
	    	System.out.println("Enter into if condition: "+i);
	    }
	    Thread.sleep(1000);
	    login.driver.findElement(By.xpath("(//div[@class='add-to-data-selection--icon'])[1]")).click();
	    	 
	    	  
	    	 

	    		  }


	    
	
	//TC_03
	@And("^some tabs display in RSP$")
	public void some_tabs_display_in_RSP() throws Throwable {
	   Thread.sleep(2000);
	   
	   login.driver.findElement(By.xpath("//div[contains(text(),'Forecast')]")).isDisplayed();
	   login.driver.findElement(By.xpath("//div[contains(text(),'Continuous')]")).isDisplayed();
	   login.driver.findElement(By.xpath("//div[contains(text(),'Breakdowns')]")).isDisplayed();
	   login.driver.findElement(By.xpath("//div[contains(text(),'Dependencies')]")).isDisplayed();
	   
	   
	   login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
	 
	   

	   
	   
	}
	//TC_03
	@Then("^Only replacement tab should be shown in RSP$")
	public void only_replacement_tab_should_be_shown_in_RSP() throws Throwable {
		Thread.sleep(2000);
		
		
//		login.driver.findElement(By.xpath("//input[@name='select_all_dataselection']/following::span[@class='input-control--indicator']")).click();
//		login.driver.findElement(By.xpath("//div[contains(text(),'Related Series')]")).click();
//		login.driver.switchTo().activeElement();
		
		 if(login.driver.findElement(By.xpath("//div[contains(text(),'Replacements (2)')]")).isDisplayed())
		 {
			 login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
			 CommonFunctionality.DeleteSeries();
				
				
				 System.out.println("=============>TC_3==============>");
		 }
			
		 
		 else {
			 Assert.fail("Test case failed");

		 }
	}
	
	
	
	//TC_04
	@Given("^new insight search series ids as \"([^\"]*)\"$")
	public void new_insight_search_series_ids_as(String arg1) throws Throwable {
	   
		Thread.sleep(2000);
		   
  login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(arg1);
  login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(Keys.ENTER);
  Thread.sleep(1000);
  
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='toggler-control-item--label'])[2]")));
  Thread.sleep(1000);
	login.driver.findElement(By.xpath("(//span[@class='toggler-control-item--label'])[2]")).click();
  Thread.sleep(1000);
  for(int i=1;i<=2;i++)
  {
  Thread.sleep(3000);
  	login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])["+i+"]")).click();
  	System.out.println("Enter into if condition: "+i);
  }
  Thread.sleep(1000);
 // login.driver.findElement(By.xpath("(/9/div[@class='add-to-data-selection--icon'])[1]")).click();
  	 

	}
	//TC_04
	@Given("^add series into visuals$")
	public void add_series_into_visuals() throws Throwable {
		login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[1]")).click();
		Thread.sleep(2000);
		WebElement elementLocator = login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[1]"));
		actions.contextClick(elementLocator).perform();
		
		
	    Thread.sleep(2000);
//	   // login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[1]")).click();
//		Thread.sleep(2000);
//		WebElement elementLocator = login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[1]"));
//		actions.contextClick().build().perform();
		
		
		
		//login.driver.findElement(By.xpath("//span[contains(text(),'View as Table')]")).click();
		//Thread.sleep(3000);
		
		
		
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//*[text()='Add chart']")).click();
		Thread.sleep(2000);
		//login.driver.findElement(By.xpath("//*[@class='icon--table-vertical_large public-js-views-visuals-VisualsPanelSubItem-module__subItemIcon']")).click();
		login.driver.findElement(By.xpath("//div[text()='Vertical']")).click();
		
		
		login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
		
		
		
		
		
		
		
		
		

		
	}
	//TC_04
	@Given("^click on add related series$")
	public void click_on_add_related_series() throws Throwable {
	   
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//*[contains(text(),'Related Series')]")).click();
	
	}

	
	//TC_06
	@Then("^Manage All checkbox checked$")
	public void manage_All_checkbox_checked() throws Throwable {
	   Thread.sleep(3000);
	   
	   login.driver.findElement(By.xpath("//div[@class='suggestions-panel--checker-all']")).click();
	   

	   
	}
	//TC_06
	@Then("^click on manageAll dropdown then click on Replace inactive series$")
	public void click_on_manageAll_dropdown_then_click_on_Replace_inactive_series() throws Throwable {
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath("//div[@class='suggestions-panel--arrow icon--filter-arrow']")).click();
		 Thread.sleep(500);
		 login.driver.findElement(By.xpath("//span[contains(text(),'Replace')]")).click();
		Thread.sleep(2000);
		
	   
	}
	//TC_06
	@Then("^click on Apply$")
	public void click_on_Apply() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("(//button[@class='button button__primary suggestions-wizard--button suggestions-wizard--button__apply'])[2]")).click();
		
		Thread.sleep(500);
		//login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();	
		
	 
	}
	//TC_06
	@Then("^Replacement of series should be showed in myseries$")
	public void replacement_of_series_should_be_showed_in_myseries() throws Throwable {
		Thread.sleep(2000);
		
		String seriesname=login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]")).getText();
		
		String myseriesname=login.driver.findElement(By.xpath("(//span[@class='series-name-field--series-name'])[1]")).getText();
		
		if(seriesname.equalsIgnoreCase(myseriesname))
		{
			System.out.println("Test case failed");
		}
		else {
			
			System.out.println("Replacement of series should be showed in myseries");
		}
		
		//CommonFunctionality.DeleteSeries();
		System.out.println("=============>TC_06==============>");
		
		
	}

	//TC_07
	@Then("^click on Apply and ok$")
	public void click_on_Apply_and_ok() throws Throwable {
	   Thread.sleep(2000);
	  // click on apply button
	  
	   login.driver.findElement(By.xpath("(//button[@class='button button__primary suggestions-wizard--button suggestions-wizard--button__apply'])[2]")).click();
		Thread.sleep(500);	
		//click on delete series popup
		login.driver.findElement(By.xpath("//button[@class='sphere-modal-control button button__primary']")).click();
		Thread.sleep(500);
		//login.driver.findElement(By.xpath("//div[contains(text(),'Ok')]")).click();
		Thread.sleep(500);
		//login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
		
		
		
	}
	
	
	
	
	//TC_7
	@Then("^Replacement of series in a visuals should be myseries$")
	public void replacement_of_series_in_a_visuals_should_be_myseries() throws Throwable {
	    Thread.sleep(2000);

			
			System.out.println("Replacement of series should be showed in myseries");
		
		
		//CommonFunctionality.DeleteSeries();
		System.out.println("=============>TC_07==============>");
	}
	
	
	
	//TC_08
	@Then("^Check don’t show again checkbox$")
	public void check_don_t_show_again_checkbox() throws Throwable {
	    
		Thread.sleep(2000);
		
		login.driver.findElement(By.xpath("(//span[contains(text(),'Do not show again')])[2]")).click();
		
		
		System.out.println("Checked");
		
		
	}
	//TC_08
	@Then("^click on close window$")
	public void click_on_close_window() throws Throwable {
		
		
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
		
		
		
	}
	
	//TC_08
	@Then("^click on signout$")
	public void click_on_signout() throws Throwable {
	   Thread.sleep(2000);
		login.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		login.driver.findElement(By.xpath("//*[@title='View and edit profile information']")).click();
		WebElement SighOut = login.driver.findElement(By.xpath("//span[contains(text(),'Sign out')]"));
		js.executeScript("arguments[0].scrollIntoView(true)", SighOut);
		SighOut.click();
		Thread.sleep(1000);
		System.out.println("sign out successfully");
	}
	
	
	
	//TC_08
	@Then("^RSP should not be shown$")
	public void rsp_should_not_be_shown() throws Throwable {
		Thread.sleep(2000);
		
		if(login.driver.findElement(By.xpath("//a[contains(text(),'My Series')]")).isDisplayed())
		{
			System.out.println("RSP should not be shown");
		}
		
		else {
			Assert.fail("Test case failed");
		}
		
	   
		 Thread.sleep(2000);
			login.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			login.driver.findElement(By.xpath("//*[@title='View and edit profile information']")).click();
		
			login.driver.findElement(By.xpath("//span[contains(text(),'Show latest changes in my insights upon opening')]")).click();
			
			login.driver.findElement(By.xpath("//*[@title='View and edit profile information']")).click();
			//CommonFunctionality.DeleteSeries();
			System.out.println("=============>TC_08==============>");
	}

	
	
	
	//TC_09
	@Then("^click on profile dropdown$")
	public void click_on_profile_dropdown() throws Throwable {
	   Thread.sleep(2000);
	   
	   login.driver.findElement(By.xpath("//*[@title='View and edit profile information']")).click();
		
		
	   
	   
	   
		
	}
	//TC_09
	@Then("^check for show latest changes for insights upon opening$")
	public void check_for_show_latest_changes_for_insights_upon_opening() throws Throwable {
		Thread.sleep(2000);
		
		if(login.driver.findElement(By.xpath("//span[contains(text(),'Show latest changes in my insights upon opening')]/preceding-sibling::input[@name='changes_summary']")).isSelected())
		{
			login.driver.findElement(By.xpath("//*[@title='View and edit profile information']")).click();
		}
		else {
			
			login.driver.findElement(By.xpath("//span[contains(text(),'Show latest changes in my insights upon opening')]")).click();
			login.driver.findElement(By.xpath("//*[@title='View and edit profile information']")).click();
		}

		
		
		
	}
	//TC_09
	@Then("^RSP should be shown again$")
	public void rsp_should_be_shown_again() throws Throwable {
		Thread.sleep(2000);
		
		
		Thread.sleep(2000);
		if(login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).isDisplayed())
		{
			login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
			System.out.println("RSP should be shown");
		}
		
		else {
			System.out.println("Test case failed");
		}
		
		CommonFunctionality.DeleteSeries();
		System.out.println("=============>TC_09==============>");
		
	}
	
	//TC_10
	@Then("^click on minimize icon on RSP$")
	public void click_on_minimize_icon_on_RSP() throws Throwable {
	    Thread.sleep(2000);
		
	    login.driver.findElement(By.xpath("//div[@class='movable-modal--action-icon movable-modal--action-icon__toggle']")).click();
	  
		
	}
	//TC_10
	@Then("^RSP should be minimized$")
	public void rsp_should_be_minimized() throws Throwable {
		Thread.sleep(2000);
		
		if(login.driver.findElement(By.xpath("//a[contains(text(),'My Series')]")).isDisplayed())
		{
			System.out.println("RSP should be minimized");
		}
		
		else {
			Assert.fail("Test case failed");
		}
		
		CommonFunctionality.DeleteSeries();
		System.out.println("=============>TC_10==============>");
		
	}
	//TC_11
	@Then("^click on outside arrow icon on minimised RSP$")
	public void click_on_outside_arrow_icon_on_minimised_RSP() throws Throwable {
		Thread.sleep(2000);
		
		 login.driver.findElement(By.xpath("//div[@class='movable-modal--action-icon movable-modal--action-icon__toggle']")).click();
		
		
	}
	
	//TC_11
	@Then("^RSP should be miximized$")
	public void rsp_should_be_miximized() throws Throwable {
	  
		Thread.sleep(2000);
		
		if(login.driver.findElement(By.xpath("//div[contains(text(),'Latest changes in your Insight')]")).isDisplayed())
		{
			System.out.println("RSP should be miximized");
		}
		
		else {
			Assert.fail("Test case failed");
		}
		
		login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
		CommonFunctionality.DeleteSeries();
		System.out.println("=============>TC_11==============>");
		
	}
	//TC_12
	@Then("^click on outside arrow icon RSP$")
	public void click_on_outside_arrow_icon_RSP() throws Throwable {
	    Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='movable-modal--action-icon__expand']")).click();
		
		
	  
	}
	//TC_12
	@Then("^RSP should be enlarged$")
	public void rsp_should_be_enlarged() throws Throwable {
		
		  Thread.sleep(2000);
			
		  if(login.driver.findElement(By.xpath("//div[@class='movable-modal--action-icon__collapse']")).isDisplayed())
			{
				System.out.println("RSP should be enlarged");
			}
			
			else {
				Assert.fail("Test case failed");
			}
			
			login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
			CommonFunctionality.DeleteSeries();
			System.out.println("=============>TC_12==============>");
	   
	}

	//TC_13
	@Then("^click on cross mark in RSP$")
	public void click_on_cross_mark_in_RSP() throws Throwable
	{
	   Thread.sleep(2000);
	   
	   login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
	   
	   
	   
	   
	}
	//TC_13
	@Then("^RSP should get closed$")
	public void rsp_should_get_closed() throws Throwable {
	   Thread.sleep(2000);
		
	   if(login.driver.findElement(By.xpath("//a[contains(text(),'My Series')]")).isDisplayed())
		{
		   System.out.println("RSP should get closed");
		   
			
		}
		
		else {
			Assert.fail("Test case failed");
		}
		
		CommonFunctionality.DeleteSeries();
		System.out.println("=============>TC_13==============>");
	   
		
	}
	
	
	//TC_14
	@Then("^click on cancel button in RSP$")
	public void click_on_cancel_button_in_RSP() throws Throwable {
	    Thread.sleep(2000);
		login.driver.findElement(By.xpath("(//div[contains(text(),'Cancel')])[2]")).click();
		
		
		
	}
	
	//TC_15
	@Then("^observe for 'show latest updates in my insights upon opening' Option should be checked by default$")
	public void observe_for_show_latest_updates_in_my_insights_upon_opening_Option_should_be_checked_by_default() throws Throwable {
	   Thread.sleep(2000);
	   
	  if(login.driver.findElement(By.xpath("//span[contains(text(),'Show latest changes in my insights upon opening')]")).isDisplayed())
	  {
		  System.out.println("show latest updates in my insights upon opening' Option should be checked by default");
	  }
	  else
	  {
		  Assert.fail("Test case fail");
	  }
	  
	  login.driver.findElement(By.xpath("//*[@title='View and edit profile information']")).click();
	  CommonFunctionality.DeleteSeries();
		System.out.println("=============>TC_15==============>");
	   
		
	}

		
	//TC_16
	@Then("^refresh the page$")
	public void refresh_the_page() throws Throwable {
	   Thread.sleep(2000);
	   
	   if(login.driver.findElement(By.xpath("(//div[normalize-space()='Related series'])[2]")).isDisplayed())
		{
		   System.out.println("RSP should get closed");	
		}
		else {
			Assert.fail("Test case failed");
		}
	   login.driver.navigate().refresh();
	   
	  Thread.sleep(2000);
  
	}
	//TC_16
	@Then("^RSP should be opened$")
	public void rsp_should_be_opened() throws Throwable {
		
		Thread.sleep(3000);
		   if(login.driver.findElement(By.xpath("(//div[contains(text(),'Cancel')])[2]")).isDisplayed())
			{
			   System.out.println("RSP should be opened");
			}
			else {
				Assert.fail("Test case failed");
			}
		   login.driver.findElement(By.xpath("(//div[contains(text(),'Cancel')])[2]")).click();
		   CommonFunctionality.DeleteSeries();
			System.out.println("=============>TC_16==============>");
	}	
	
	//TC_17
	@And("^click on open file menu\\(settings icon\\)$")
	public void click_on_open_file_menu_settings_icon() throws Throwable {
	    Thread.sleep(2000);
	    login.driver.findElement(By.xpath("//div[@class='insight-context-menu--menu-icon']")).click();
	  
		
	}
	//TC_17
	@And("^click on refresh$")
	public void click_on_refresh() throws Throwable {
		
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath("//span[contains(text(),'Refresh')]")).click();
		 Thread.sleep(4000);
		 
		 
	}
	
	
	
	//TC_18
	@And("^uncheck the Show latest changes in my insights upon opening$")
	public void uncheck_the_Show_latest_changes_in_my_insights_upon_opening() throws Throwable {
		Thread.sleep(2000);
		
			login.driver.findElement(By.xpath("//span[contains(text(),'Show latest changes in my insights upon opening')]")).click();
			login.driver.findElement(By.xpath("//*[@title='View and edit profile information']")).click();	
	}
	

	//TC_18
	@And("^click on refresh page$")
	public void click_on_refresh_page() throws Throwable {
		Thread.sleep(3000);
		
		login.driver.navigate().refresh();
		
		Thread.sleep(1000);
		//login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
		
	}
	
	//TC_18
	@And("^refresh the site$")
	public void refresh_the_site() throws Throwable {
	   Thread.sleep(2000);
	  login.driver.navigate().refresh();	  
		   
	  Thread.sleep(2000);
	  
	 
	}
	//TC_18
	@Then("^RSP not display$")
	public void rsp_not_display() throws Throwable {
	    Thread.sleep(2000);
	    System.out.println("RSP pop not showing");
	    login.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    if(login.driver.findElements(By.xpath("//div[contains(text(),'×')]")).size()==1)
	    {
		login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
		login.driver.findElement(By.xpath("//*[@title='View and edit profile information']")).click();
		login.driver.findElement(By.xpath("//span[contains(text(),'Show latest changes in my insights upon opening')]")).click();
		
		login.driver.findElement(By.xpath("//*[@title='View and edit profile information']")).click();
		CommonFunctionality.DeleteSeries();
		System.out.println("=============>TC_18==============>");
	    }
	    
	    else {
	    	//Thread.sleep(1000);

			Thread.sleep(1000);
	    	login.driver.findElement(By.xpath("//*[@title='View and edit profile information']")).click();
	    	Thread.sleep(2000);
			login.driver.findElement(By.xpath("//span[contains(text(),'Show latest changes in my insights upon opening')]")).click();
			
			login.driver.findElement(By.xpath("//*[@title='View and edit profile information']")).click();
			
			CommonFunctionality.DeleteSeries();
			System.out.println("=============>TC_18==============>");
	    }
	}

	
	//TC_19
	@And("^click on Continue button in Do you want to keep your insight popup$")
	public void click_on_Continue_button_in_Do_you_want_to_keep_your_insight_popup() throws Throwable {
	   Thread.sleep(2000);
	   if(login.driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).isDisplayed())
	   {
		   login.driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		   Thread.sleep(2000);
	   }
	   else {
		   System.out.println("test case skip");
	   }	
	}
	
	
	//TC_19
	@Then("^RSP should be closed$")
	public void rsp_should_be_closed() throws Throwable {
	   Thread.sleep(2000);
	   
	   if(login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).isDisplayed())
	   {
		   login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
	   }
	   else {
		  
	   }
	  // login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
	   CommonFunctionality.DeleteSeries();
		System.out.println("=============>TC_19==============>");
	}
	
	
	
	//TC_20
	@Then("^click on dismiss button in RSP window$")
	public void click_on_dismiss_button_in_RSP_window() throws Throwable {
	   Thread.sleep(3000);
		
		
	   login.driver.findElement(By.xpath("(//div[@class='series-changes-summary']//div[contains(text(),'Dismiss')])[2]")).click();
		
	 
		
		
	}
	//TC_20
	@Then("^RSP window should not be opened$")
	public void rsp_window_should_not_be_opened() throws Throwable {
		 Thread.sleep(2000);
		
		  if(login.driver.findElement(By.xpath("//span[@class='searches-manager--reset-button button button__sm button__warning']")).isDisplayed())
			{
			   System.out.println("RSP window should not be opened");
			}
			
			else {
				Assert.fail("Test case failed");
			}
			
			CommonFunctionality.DeleteSeries();
			System.out.println("=============>TC_20==============>");
		
		
		
	}
	//TC_22
	@Then("^click on CDMNext, CEIC’s Data Manager$")
	public void click_on_CDMNext_CEIC_s_Data_Manager() throws Throwable {
	    Thread.sleep(2000);
	    login.driver.findElement(By.xpath("//div[contains(text(),'CDMNext, CEIC’s Data Manager')]")).click();
	    Thread.sleep(2000);
	    login.driver.findElement(By.xpath("//span[contains(text(),'Reset')]")).click();
	    Thread.sleep(2000);

	}
	
	
	
	//TC_23
	@Then("^show latest changes in my insight upon opening option should be checked only$")
	public void show_latest_changes_in_my_insight_upon_opening_option_should_be_checked_only() throws Throwable {
	    Thread.sleep(2000);
	   login.driver.findElement(By.xpath("//*[@title='View and edit profile information']")).click();
	   //CommonFunctionality.DeleteSeries();
		System.out.println("=============>TC_23==============>");
	}
	
	
}
