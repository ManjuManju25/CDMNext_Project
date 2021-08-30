package CDMNext.StepDefinations;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.poi.util.SystemOutLogger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.*;

public class Indicators {
	
	
	Actions action=new Actions(login.driver);
	public String actualTooltip;
	WebDriverWait wait = new WebDriverWait(login.driver,30);
	
	

	// TC_01
	@And("^select all series check box checked$")
	public void select_all_series_check_box_checked() throws Throwable {
		Thread.sleep(2000);
		
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		// System.out.println("===============>select all series check box
		// checked=============>");
	}

	
	// TC_01
	@And("^click on related series tab$")
	public void click_on_related_series_tab() throws Throwable {
		Thread.sleep(2000);

		if (login.driver.findElement(By.xpath("//div[contains(text(),'Related Series')]")).isEnabled()) {

			login.driver.findElement(By.xpath("//div[contains(text(),'Related Series')]")).click();
		} else {
			Assert.fail("Test case failed");
		}
		// System.out.println("===============>click on related series
		// tab=============>");
	}

	// TC_01
	@Then("^Indicator tab in series suggestion manager window should be open$")
	public void indicator_tab_in_series_suggestion_manager_window_should_be_open() throws Throwable {
		Thread.sleep(2000);

		if (login.driver.findElement(By.xpath("//div[contains(text(),'Add related series')]")).isDisplayed()) {
			System.out.println("Test case pass");
		} else {
			Assert.fail("Test case failed");
		}
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
		CommonFunctionality.DeleteSeries();
		System.out.println("=============>TC_01==============>");

	}

	// TC_02
	@Given("^try selecting related series in my series$")
	public void try_selecting_related_series_in_my_series() throws Throwable {
		Thread.sleep(2000);

		if (login.driver.findElements(By.xpath("//div[contains(text(),'Related Series')]")).size() == 2)

		{
			Assert.fail("Test case failed");
		}

		else {
			System.out.println("Test case pass");
		}

		// System.out.println("============>Related series is not
		// selected=============>");
	}

//TC_02
	@Then("^Should not be enabled$")
	public void should_not_be_enabled() throws Throwable {

		System.out.println("Should not be enabled");
		// login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
		// login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
		Thread.sleep(2000);
		CommonFunctionality.DeleteSeries();
		System.out.println("==================>TC_02======================>");

	}

	// TC_03
	@And("^try click on selecting related series in my series$")
	public void try_click_on_selecting_related_series_in_my_series() throws Throwable {
		Thread.sleep(2000);

		if (login.driver.findElement(By.xpath("//div[contains(text(),'Related Series')]")).isEnabled()) {

			login.driver.findElement(By.xpath("//div[contains(text(),'Related Series')]")).click();
		} else {
			Assert.fail("Test case failed");
		}
	}

	// TC_03
	@Then("^related series button should be enabled$")
	public void related_series_button_should_be_enabled() throws Throwable {

		Thread.sleep(1000);
		if (login.driver.findElement(By.xpath("//div[@class='visual-indicators--body']")).isDisplayed()) {
			System.out.println("related series button should be enabled");
			login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
		} else {
			Assert.fail("==========>Test case failed===========>");
		}
		CommonFunctionality.DeleteSeries();
		System.out.println("==================>TC_03======================>");
	}
	
	// TC_04
	@And("^hover mouse on I icon of indicator tab$")
	public void hover_mouse_on_I_icon_of_indicator_tab() throws Throwable {
	    Thread.sleep(1000);
	   WebElement Icon=login.driver.findElement(By.xpath("//div[@class='visual-indicators-help--icon']"));
		action.pause(500).moveToElement(Icon).build().perform();
		Thread.sleep(2000);
		//get the value of the "title" attribute 
		String actualTooltip = Icon.getAttribute("title");
		//System.out.println("actualTooltip===============>"+actualTooltip);
		String data="These indicators are part of our Global Economic Monitor dataset. Subscription to World Trend Plus and Daily Databases is required.";
		System.out.println("actualTooltip==========:"+actualTooltip);
		//System.out.println("popup updata==========:"+data);
	  Thread.sleep(1000);
	 
		if(actualTooltip.equalsIgnoreCase(data))
		{
			System.out.println("Tooltip data should be displayed");
		}
		else
		{
			Assert.fail("Test case failed");
		}
	}
	// TC_04
	@Then("^Tooltip should be displayed$")
	public void tooltip_should_be_displayed() throws Throwable {
	   Thread.sleep(2000);
			System.out.println("Tooltip data should be displayed");
			
			
			 login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
			 CommonFunctionality.DeleteSeries();
			

			System.out.println("=============>TC_04==============>");
	}

	//TC_05
	@And("^Add indicators to my series by click on plus icon beside indicators of country selected$")
	public void add_indicators_to_my_series_by_click_on_plus_icon_beside_indicators_of_country_selected() throws Throwable {
	   Thread.sleep(3000);
	   // select 1st  country
	   login.driver.findElement(By.xpath("//span[@class='select2-chosen']")).click();
	   Thread.sleep(3000);
		login.driver.findElement(By.xpath("/html[1]/body[1]/div[9]/ul[1]/li[1]/div[1]")).click();
		Thread.sleep(5000);
		  WebElement plusicon= login.driver.findElement(By.xpath("//div[contains(text(),'CPI')]"));
		   action.moveToElement(plusicon).perform();
		   Thread.sleep(2000);
		   login.driver.findElement(By.xpath("(//div[@class='visual-indicator--icon'])[1]")).click();	
		   Thread.sleep(10000);
		   
		   //2nd country
		   login.driver.findElement(By.xpath("//span[@class='select2-chosen']")).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath("//div[contains(text(),'Albania')]")).click();
			Thread.sleep(5000);
			  WebElement plusicon1= login.driver.findElement(By.xpath("//div[contains(text(),'CPI')]"));
			   action.moveToElement(plusicon1).perform();
			   Thread.sleep(2000);
			   login.driver.findElement(By.xpath("(//div[@class='visual-indicator--icon'])[2]")).click();	
			   Thread.sleep(10000);
		   
			 //3rd country
			   login.driver.findElement(By.xpath("//span[@class='select2-chosen']")).click();
				 Thread.sleep(1000);
				 login.driver.findElement(By.xpath("//div[contains(text(),'Algeria')]")).click();
					Thread.sleep(5000);
					  WebElement plusicon11= login.driver.findElement(By.xpath("//div[contains(text(),'CPI')]"));
					   action.moveToElement(plusicon11).perform();
					   Thread.sleep(2000);
					   login.driver.findElement(By.xpath("(//div[@class='visual-indicator--icon'])[1]")).click();	
					   Thread.sleep(10000);
					   
		   
					   //4th country
					   login.driver.findElement(By.xpath("//span[@class='select2-chosen']")).click();
						 Thread.sleep(1000);
						 login.driver.findElement(By.xpath("//div[contains(text(),'Antigua and Barbuda')]")).click();
							Thread.sleep(5000);
							  WebElement plusicon111= login.driver.findElement(By.xpath("//div[contains(text(),'CPI')]"));
							   action.moveToElement(plusicon111).perform();
							   Thread.sleep(2000);
							   login.driver.findElement(By.xpath("(//div[@class='visual-indicator--icon'])[1]")).click();	
							   Thread.sleep(10000);
							   
							   
//							   
//							   //5th country
//							   login.driver.findElement(By.xpath("//span[@class='select2-chosen']")).click();
//							   Thread.sleep(2000);
//							   
//							   login.driver.findElement(By.xpath("//input[@id='s2id_autogen2_search']")).sendKeys("Armenia");
//							   
//							   login.driver.findElement(By.xpath("//input[@id='s2id_autogen2_search']")).sendKeys(Keys.ENTER);
//							   
//							   
//									Thread.sleep(5000);
//									  WebElement plusicon1111= login.driver.findElement(By.xpath("//div[contains(text(),'CPI')]"));
//									   action.moveToElement(plusicon1111).perform();
//									   Thread.sleep(2000);
//									   login.driver.findElement(By.xpath("(//div[@class='visual-indicator--icon'])[2]")).click();	
//									   Thread.sleep(10000);
//							   

	}

	//TC_05
	@Then("^Maximum of (\\d+) country/region tabs can be created$")
	public void maximum_of_country_region_tabs_can_be_created(int arg1) throws Throwable {
	   Thread.sleep(2000);
		
		String countrys=login.driver.findElement(By.xpath("//div[@class='visual-indicators--tabbar']")).getText();
		System.out.println("Maximum countrys selected:"+countrys);
		System.out.println("Maximum of 5 country/region tabs can be created");
	 login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
		
		 CommonFunctionality.DeleteSeries();
		System.out.println("=============>TC_05==============>");
	}

	

	//TC_06
	@And("^click on select a region text box dropdown$")
	public void click_on_select_a_region_text_box_dropdown() throws Throwable {
	    Thread.sleep(1000);
		login.driver.findElement(By.xpath("//span[@class='select2-chosen']")).click();
		
	}
	//TC_06
	@Then("^Regions list for selecting DB series should be opened$")
	public void regions_list_for_selecting_DB_series_should_be_opened() throws Throwable {
		// login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
		Thread.sleep(2000);
	   // login.driver.findElement(By.xpath("//ul[@id='select2-results-203']")).isDisplayed();
		System.out.println("Regions list for selecting DB series should be opened");
		Thread.sleep(2000);
		//login.driver.findElement(By.xpath("//div[@class='movable-modal--action-icon movable-modal--action-icon__toggle']")).click();
		
		
		// CommonFunctionality.DeleteSeries();
			System.out.println("=============>TC_06==============>");
	}


	
	//TC_07
	@And("^click on I icon of indicators tab$")
	public void click_on_I_icon_of_indicators_tab() throws Throwable {
	    Thread.sleep(2000);
	    login.driver.findElement(By.xpath("//div[@class='visual-indicators-help--icon']")).click();
	    Thread.sleep(1000);
	  //  System.out.println("=============>TC_07==============>");
	}

	//TC_07
	@Then("^Footnotes popup should be opened$")
	public void footnotes_popup_should_be_opened() throws Throwable {
		Thread.sleep(2000);
		
		String popup= login.driver.findElement(By.xpath("//span[@class='footnotes-modal--name']")).getText();
		
		System.out.println(popup);
		String s= "Footnotes";
	Assert.assertEquals(s,popup);
	
	 login.driver.findElement(By.xpath("(//div[@class='movable-modal--close'])[2]")).click();
	Thread.sleep(2000);
	 login.driver.findElement(By.xpath("(//div[@class='movable-modal--close'])[1]")).click();
	 CommonFunctionality.DeleteSeries();
		System.out.println("=============>TC_07==============>");
	}
	
	
	
	
	
	//TC_08
	@And("^click on plus icon in indicators tab$")
	public void click_on_plus_icon_in_indicators_tab() throws Throwable {
	   Thread.sleep(2000);
		
		
	  WebElement plusicon= login.driver.findElement(By.xpath("//div[contains(text(),'CPI')]"));
	   action.moveToElement(plusicon).perform();
	   Thread.sleep(3000);
	   
	   login.driver.findElement(By.xpath("(//div[@class='visual-indicator--icon'])[2]")).click();
	   
	   

	}
	//TC_08
	@Then("^should get reflected in my series tab as related series$")
	public void should_get_reflected_in_my_series_tab_as_related_series() throws Throwable {
		 Thread.sleep(4000);
		 login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
		 
		if(login.driver.findElement(By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[2]")).isDisplayed())
		{
			System.out.println("Test case pass");
		}
		else {
			Assert.fail("Test case failed");
		}
		 
		CommonFunctionality.DeleteSeries();
		System.out.println("=============>TC_08==============>");
		
	}
	//TC_09
	@And("^Create the visual like table$")
	public void create_the_visual_like_table() throws Throwable {
	   
		Thread.sleep(3000);
		//login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).sendKeys(Keys.CONTROL + "t");
		WebElement rightclick=login.driver.findElement(By.xpath("//span[@class='table-container--checkbox svg-checkbox input-control__grey']"));
		// contextClick() method to do right click on the element
		action.contextClick(rightclick).build().perform();
		login.driver.findElement(By.xpath("//span[contains(text(),'View as Table')]")).click();
		
		
		
		//Robot r = new Robot();
		//r.keyPress(KeyEvent.VK_T);
		Thread.sleep(3000);
	}
	//TC_09
	@And("^click on Add related series$")
	public void click_on_Add_related_series() throws Throwable {
		Thread.sleep(2000);
		
		login.driver.findElement(By.xpath("//button[contains(text(),'Add related series')]")).click();

	}
	//TC_09
	@And("^select any of the indicators for series being in visual selection pane$")
	public void select_any_of_the_indicators_for_series_being_in_visual_selection_pane() throws Throwable {
	    Thread.sleep(2000);
	    WebElement plusicon= login.driver.findElement(By.xpath("//div[contains(text(),'CPI')]"));
		   action.moveToElement(plusicon).perform();
		   Thread.sleep(2000);
		   login.driver.findElement(By.xpath("(//div[@class='visual-indicator--icon'])[2]")).click();
		   Thread.sleep(3000);

	}
	//TC_09
	@Then("^indicators tab should get reflected in visual selection pane as related series$")
	public void indicators_tab_should_get_reflected_in_visual_selection_pane_as_related_series() throws Throwable {
	   Thread.sleep(2000);
		
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Apply')]")));
	    login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		Thread.sleep(5000);
	  
		 login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
	  if(login.driver.findElement(By.xpath("//span[contains(text(),'Consumer Price Index:')]")).isDisplayed())
	  {
		  System.out.println("Test case pass");
	  }
	 
	  else
	  {
		  Assert.fail("Test case failed");
	  }	
	  
	  
	  login.driver.findElement(By.xpath("//a[contains(text(),'My Series')]")).click();
	  Thread.sleep(1000);
	  CommonFunctionality.DeleteSeries();
	  
	  login.driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
	  
	
	  
	  
		System.out.println("=============>TC_09==============>");
	}
	//TC_10
	@And("^series check box checked$")
	public void series_check_box_checked() throws Throwable {
	   Thread.sleep(1000);
	   
	   login.driver.findElement(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']")).click();
	   
	   
	}

	//TC_10
	@And("^adding indicators with different frequency/unit for visual selection pane$")
	public void adding_indicators_with_different_frequency_unit_for_visual_selection_pane() throws Throwable {
		Thread.sleep(7000);
		
		//login.driver.findElement(By.xpath("(//select[@class='series-data-conversion--param form--control'])[1]")).click();
		//Thread.sleep(1000);
		
		login.driver.findElement(By.xpath("(//select[@class='series-data-conversion--param form--control'])[1]")).click();
		Select frequency = new Select(login.driver.findElement(By.xpath("(//select[@class='series-data-conversion--param form--control'])[1]")));
		frequency.selectByVisibleText("Semiannual");
		Thread.sleep(1000);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Apply')]")));
		    login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
			Thread.sleep(7000);
		  
			 login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
	    
	}
	//TC_10
	@Then("^frequency conversion window to create visuals from indicators tab in series suggestion manager window$")
	public void frequency_conversion_window_to_create_visuals_from_indicators_tab_in_series_suggestion_manager_window() throws Throwable {
	  Thread.sleep(2000);
		

	 if(login.driver.findElement(By.xpath("//span[contains(text(),'Consumer Price Index:')]")).isDisplayed())
	 {
		 System.out.println("Test case pass");
	 }
	  
	 else {
		 Assert.fail("Test case failed");
	 }
	
	  
	 login.driver.findElement(By.xpath("//a[contains(text(),'My Series')]")).click();
	 Thread.sleep(2000);
	 CommonFunctionality.DeleteSeries();
	 login.driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
	  
		System.out.println("=============>TC_10==============>");
	  
	  
	  
	}

	
	
	
	
	//TC_11
	@And("^click on minimize icon at top right corner of window$")
	public void click_on_minimize_icon_at_top_right_corner_of_window() throws Throwable {
	    Thread.sleep(1000);
	    
	    login.driver.findElement(By.xpath("//div[@class='movable-modal--action-icon movable-modal--action-icon__toggle']")).click();
	  
	    
	}
	//TC_11
	@Then("^indicators tab opened should be minimized$")
	public void indicators_tab_opened_should_be_minimized() throws Throwable {
		
		Thread.sleep(1000);
		if(login.driver.findElement(By.xpath("//a[contains(text(),'My Series')]")).isDisplayed())
		{
			System.out.println("Test case pass");
		}
		
		else
		{
		Assert.fail("Test case failed");
		}
		
		CommonFunctionality.DeleteSeries();
		System.out.println("=============>TC_11==============>");
	}
	
	
	//TC_12
	@And("^select CPI of the indicators in first level  for chose of region clicking over plus icon$")
	public void select_CPI_of_the_indicators_in_first_level_for_chose_of_region_clicking_over_plus_icon() throws Throwable {
	    Thread.sleep(2000);
	    //click on Region
	    login.driver.findElement(By.xpath("//span[@id='select2-chosen-2']")).click();
	    //select country
	    login.driver.findElement(By.xpath("//div[@id='select2-result-label-3']")).click();
	    WebElement plusicon= login.driver.findElement(By.xpath("//div[contains(text(),'CPI')]"));
		   action.moveToElement(plusicon).perform();
		   Thread.sleep(2000);
		   login.driver.findElement(By.xpath("(//div[@class='visual-indicator--icon'])[1]")).click();	
		   Thread.sleep(5000);
	}
	//TC_12
	@Then("^Should be able to create regions tab for particular first level indicators$")
	public void should_be_able_to_create_regions_tab_for_particular_first_level_indicators() throws Throwable {
	   Thread.sleep(2000);
	  if(login.driver.findElement(By.xpath("//div[contains(text(),'Afghanistan')]")).isDisplayed())
	  {
		  System.out.println("Should be able to create regions tab for particular first level indicators");
	  }else
	  {
		  Assert.fail("Test case failed");
	  }
	   
	  login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
		CommonFunctionality.DeleteSeries();
		System.out.println("==============>TC_12=======================");	
	}
	
	
	
	//TC_13
	@And("^select FX Rate of the indicators in second level for chose of region$")
	public void select_FX_Rate_of_the_indicators_in_second_level_for_chose_of_region() throws Throwable {
	    Thread.sleep(2000);
	    
	  //click on Region
	    login.driver.findElement(By.xpath("//span[@id='select2-chosen-2']")).click();
	    //select country
	    login.driver.findElement(By.xpath("//div[@id='select2-result-label-4']")).click();
	    WebElement plusicon= login.driver.findElement(By.xpath("//div[contains(text(),'FX Rate')]"));
		   action.moveToElement(plusicon).perform();	
		   Thread.sleep(2000);
		   login.driver.findElement(By.cssSelector(".visual-indicators--category__financial-specific > .visual-indicator:nth-child(1) > .visual-indicator--icon")).click();	
		   Thread.sleep(5000);
		
		
		
	}

	//TC_13
	@Then("^Should be able to create region's/country's tab for particular second level indicators$")
	public void should_be_able_to_create_region_s_country_s_tab_for_particular_second_level_indicators() throws Throwable {
	    
		Thread.sleep(2000);
		 if(login.driver.findElement(By.xpath("//div[contains(text(),'Albania')]")).isDisplayed())
		  {
			  System.out.println("Should be able to create region's/country's tab for particular second level indicators");
		  }else
		  {
			  Assert.fail("Test case failed");
		  }
		   
		  login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
			CommonFunctionality.DeleteSeries();
			System.out.println("==============>TC_13=======================");	
		
		
		
		
		
	}

	
//TC_14
@And("^select any of the indicators in third level for chose of region$")
public void select_any_of_the_indicators_in_third_level_for_chose_of_region() throws Throwable {
    Thread.sleep(2000);
	
    //click on Region
    login.driver.findElement(By.xpath("//span[@id='select2-chosen-2']")).click();
    //select country
    login.driver.findElement(By.xpath("//div[@id='select2-result-label-3']")).click();
    WebElement plusicon= login.driver.findElement(By.xpath("//div[contains(text(),'Brent Oil Price')]"));
	   action.moveToElement(plusicon).perform();	
	   Thread.sleep(2000);
	                                            
	   login.driver.findElement(By.cssSelector(".visual-indicators--category__financial-global > .visual-indicator:nth-child(1) > .visual-indicator--icon")).click();	
	   Thread.sleep(5000);
	

}


//TC_14
@Then("^Should be able to create region tab for particular third level indicators$")
public void should_be_able_to_create_region_tab_for_particular_third_level_indicators() throws Throwable {
   
	  Thread.sleep(2000);
	  if(login.driver.findElement(By.xpath("//div[contains(text(),'United Kingdom')]")).isDisplayed())
	  {
		  System.out.println("Should be able to create regions tab for particular first level indicators");
	  }else
	  {
		  Assert.fail("Test case failed");
	  }
	   
	  login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
		CommonFunctionality.DeleteSeries();
		System.out.println("==============>TC_14=======================");	
}

	
	
//TC_15
	@And("^click on name of any of the indicators$")
	public void click_on_name_of_any_of_the_indicators() throws Throwable {
	  Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[contains(text(),'Business Confidence')]")).click();
	  
	  
	}
	//TC_15
	@Then("^SSP of that particular indicator's should be opened$")
	public void ssp_of_that_particular_indicator_s_should_be_opened() throws Throwable {
		 Thread.sleep(4000);
		
		if(login.driver.findElement(By.xpath("//div[contains(text(),'Active')]")).isDisplayed())
		{
			System.out.println("Test case Pass");
		}
		else
		{
			Assert.fail("Test case failed");
		}
		 
		//login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
		// login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
		//CommonFunctionality.DeleteSeries();
		System.out.println("=============>TC_15==============>");
		
		
	}

	
	//TC_16
	@And("^click on two arrow mark present in opp direction at right cornered window$")
	public void click_on_two_arrow_mark_present_in_opp_direction_at_right_cornered_window() throws Throwable {
	    Thread.sleep(2000);
	    
		login.driver.findElement(By.xpath("//div[@class='movable-modal--action-icon__expand']")).click();
		
		

	}
	//TC_16
	@Then("^Window with indicator's tab should be exandable$")
	public void window_with_indicator_s_tab_should_be_exandable() throws Throwable {
	  
		Thread.sleep(2000);
		if(login.driver.findElement(By.xpath("//div[@class='movable-modal--action-icon__collapse']")).isDisplayed())
		{
			System.out.println("Test case pass");
		}
		else
		{
			Assert.fail("Test case failed");
		}
		 login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
		CommonFunctionality.DeleteSeries();
		System.out.println("=============>TC_16==============>");
	}

	//TC_17
	@And("^click again on arrow mark directed towards$")
	public void click_again_on_arrow_mark_directed_towards() throws Throwable {
	    Thread.sleep(2000);
	    login.driver.findElement(By.xpath("//div[@class='movable-modal--action-icon__collapse']")).click();
	    
	    
	}
	//TC_17
	@Then("^Window with indicator's tab should be contrastable$")
	public void window_with_indicator_s_tab_should_be_contrastable() throws Throwable {
		Thread.sleep(2000);
		if(login.driver.findElement(By.xpath("//div[@class='movable-modal--action-icon__expand']")).isDisplayed())
		{
			System.out.println("Test case pass");
		}
		else
		{
			Assert.fail("Test case failed");
		}
		 login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
		CommonFunctionality.DeleteSeries();
		System.out.println("=============>TC_17==============>");
	}
	
	//TC_18
	@And("^click on cross mark at right cornered window$")
	public void click_on_cross_mark_at_right_cornered_window() throws Throwable {
	    Thread.sleep(2000);
	    
	    login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();

		
	}
	//TC_18
	@Then("^Window opened should be closed$")
	public void window_opened_should_be_closed() throws Throwable {
	   Thread.sleep(2000);
	   if(login.driver.findElement(By.xpath("//a[contains(text(),'My Series')]")).isDisplayed())
		{
			System.out.println("Test case pass");
		}
		
		else
		{
		Assert.fail("Test case failed");
		}
	   
	   CommonFunctionality.DeleteSeries();
		System.out.println("=============>TC_18==============>");  
	}

//TC_19
@And("^navigate from indicators to any other tab if present$")
public void navigate_from_indicators_to_any_other_tab_if_present() throws Throwable {
    Thread.sleep(2000);
    login.driver.findElement(By.xpath("//div[contains(text(),'Replacements')]")).click();

}
//TC_19
@Then("^indicator tab should not cause low loadness for indicator's tab & vice-versa$")
public void indicator_tab_should_not_cause_low_loadness_for_indicator_s_tab_vice_versa() throws Throwable {
    
	System.out.println("indicator tab should not cause low loadness for indicator's tab & vice-versa");
	login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
	
	  CommonFunctionality.DeleteSeries();
			System.out.println("=============>TC_19==============>");
	
}
	
//TC_20
@And("^hover mouse pointer over those icon's$")
public void hover_mouse_pointer_over_those_icon_s() throws Throwable {
	Thread.sleep(2000);
	
	login.driver.findElement(By.xpath("//div[@class='movable-modal--action-icon movable-modal--action-icon__toggle']")).isDisplayed();
	Thread.sleep(1000);
    
	login.driver.findElement(By.xpath("//div[@class='movable-modal--action-icon__expand']")).isDisplayed();
	Thread.sleep(1000);
	login.driver.findElement(By.xpath("//div[@class='movable-modal--action-icon__expand']")).click();
	Thread.sleep(1000);
	login.driver.findElement(By.xpath("//div[@class='movable-modal--action-icon__collapse']")).isDisplayed();
	Thread.sleep(1000);
    login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).isDisplayed();
	
    Thread.sleep(1000);

	 
	 }
	

//TC_20
@Then("^Minimize,full-screen/Exit full-scren,close tooltips should be seen$")
public void minimize_full_screen_Exit_full_scren_close_tooltips_should_be_seen() throws Throwable {
	
	Thread.sleep(1000);
	 login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();
	System.out.println("Minimize,full-screen/Exit full-scren,close tooltips should be seen");
	
	CommonFunctionality.DeleteSeries();
	System.out.println("=============>TC_20==============>");
	
	
	
	
	
	
	
}
	
	

}
