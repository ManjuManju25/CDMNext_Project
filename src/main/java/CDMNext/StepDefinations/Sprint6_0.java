package CDMNext.StepDefinations;


import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import com.itextpdf.text.log.SysoCounter;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class Sprint6_0 extends CommonFunctionality {
	JavascriptExecutor js = (JavascriptExecutor) login.driver;
	
	@Given("^User selects More dropdown$")
	public void user_selects_More_dropdown() throws Throwable {
		/*Thread.sleep(5000);
		CommonFunctionality.getElementByXpath(login.driver, "//span[normalize-space(text())='More']", 4).click();
		Thread.sleep(5000);
		*/
		Thread.sleep(5000);
		login.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'More')]")));
			login.driver.findElement(By.xpath("//span[contains(text(),'More')]")).click();
		
	    
	    
	}

	@And("^clicks on continuos series icon\\.$")
	public void clicks_on_continuos_series_icon() throws Throwable {
		if(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Continuous"))).isDisplayed()) {
			try {
		WebElement continuos=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Continuous")));
		continuos.click();
			}
			catch(Exception e) {
				System.out.println("=continuos button not clicked==");
				
			}
		login.Log4j.info("Successfully Continuous  button Clicked ");
		}
		else {
			login.Log4j.info("Continuous button is not Clicked ");
		}
	   
	}

	@And("^clicks on Apply filter button\\.$")
	public void clicks_on_Apply_filter_button() throws Throwable {
		
		//CommonFunctionality.getElementByXpath(login.driver, "//div[@class='button__primary button button__primary']", 4).click(); 
		//Thread.sleep(5000);
		//login.driver.findElement(By.xpath("//div[normalize-space(text())='Apply filter'])).click();
		//login.driver.findElement(By.xpath("//div[normalize-space(text())='Apply filter']")).click();
		/*WebDriverWait wait = new WebDriverWait(login.driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//div[normalize-space(text())='Apply filter")))).click();	*/
		/*Thread.sleep(5000);
		WebElement chkbox = login.driver.findElement(By.xpath("(//span[@class='status-icon'])[4]"));
		js.executeScript("arguments[0].scrollIntoView(true)", chkbox);
		Thread.sleep(5000);
		chkbox.click();*/
		login.driver.findElement(By.xpath("//div[contains(text(),'Apply filter')]")).click();
		
		
	}

	@Then("^Series with tag C  should be displayed infront of series\\.$")
	public void series_with_tag_C_should_be_displayed_infront_of_series() throws Throwable {
		CommonFunctionality.wait(500);
		login.driver.findElement(By.xpath("//span[@value='LIST']")).click();
		    
			List<WebElement> list = login.driver.findElements(By.xpath("//span[normalize-space(text())='c']"));
			System.out.println("========="+list.size());
			CommonFunctionality.wait(2000);
			
			if(list.size()>1) {
				login.Log4j.info("series with tag C is displayed infront of series");
				
			}
			else {
				login.Log4j.info("series with tag C is not  displayed infront of series");
			}
				
		}
	
	@And("^clicks on any continuos series\\.$")
	public void clicks_on_any_continuos_series() throws Throwable {
		CommonFunctionality.wait(2000);	
		
		/*List<WebElement> list = login.driver.findElements(By.xpath("//div[@class='series-list-item--information']/*"));
		System.out.println("=========="+list.size());
		for (int i = 1 ; i <= list.size(); i++) {
			WebElement series = login.driver.findElement(By.xpath("(//div[@class='series-item--name'])["+i+"]"));
			
			new Actions(login.driver).moveToElement(series).pause(1000).click().build().perform();
		*/
		
		login.driver.findElement(By.xpath("//div[@class='series-item--name']")).click();
		//WebElement ss =login.driver.findElement(By.xpath("//div[@class='series-list-item--information']/*"));
		//new Actions(login.driver).moveToElement(ss).pause(1000).click().build().perform();
		
		}
		
	
	@Then("^hover mouse on question mark of show continuos series\\.$")
	public void hover_mouse_on_question_mark_of_show_continuos_series() throws Throwable {
		WebElement QuestionMark=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("QuestionMark_hovered")));
		if(QuestionMark.isDisplayed()) {
		WebElement Continuos_questionMark = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("QuestionMark_hovered")));
		new Actions(login.driver).moveToElement(Continuos_questionMark).pause(2000).build().perform();
		login.Log4j.info("Description of continuos series is found");
		}
		else {
			login.Log4j.info("Description of continuos series is not  found");
			
			
		}
	}
	
	@SuppressWarnings("deprecation")
	@And("^continuos series must be showm with time Period \"([^\"]*)\"\\.$")
	public void continuos_series_must_be_showm_with_time_Period(String arg1) throws Throwable {
		WebElement All=CommonFunctionality.getElementByXpath(login.driver, "//span[text()='" + arg1 + "']", 4);
		String All_Observations=All.getText();	
		
		System.out.println("======"+All_Observations);		
		js.executeScript("arguments[0].click();", All);
		
           if(arg1.contains("All")) {
        	  
			login.Log4j.info("Continuos series with All observations are found");	
		}
           
           else {
        	   login.Log4j.info("Continuos series with All observations are not found");
           }
	    
	}
	
	
	@And("^select continuos checkbox\\.$")
	public void select_continuos_checkbox() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("(//*[@class='series-list-item--checkbox svg-checkbox'])[1]")).click();
	   
	}

	@And("^Open Add in SSP->click on Add as continuos series\\.$")
	public void open_Add_in_SSP_click_on_Add_as_continuos_series() throws Throwable {
		CommonFunctionality.wait(2000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(login.LOCATORS.getProperty("Add_SSP")))).click();
		
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_continuosseries"))).click();
		login.Log4j.info("clicked on Add as continuos series dropdown.");
		 
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='Close']", 4).click();
		String data = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Continuos_tag"))).getText();
		System.out.println("============"+data);
		Assert.assertEquals(data, "Continuous");
		
		
	   	}
	@And("^add as continuos series\\.$")
	public void add_as_continuos_series() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement ele=login.driver.findElement(By.xpath("//span[@value='LIST']"));
		js.executeScript("arguments[0].click();", ele);
		
		login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[5]")).click();
		CommonFunctionality.wait(2000);
		/*WebElement Series_list = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_hovered")));
		CommonFunctionality.action.moveToElement(Series_list).pause(2000).build().perform();
		*/
		CommonFunctionality.wait(2000);
		WebElement Series_dp1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_listdp1")));
		CommonFunctionality.action.moveToElement(Series_dp1).pause(3000).click().build().perform();
		
		CommonFunctionality.wait(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_ascontinuos"))).click();
		
		
		
	   
	}

	@And("^Continuous series must be shown with continuous tag\\.$")
	public void continuous_series_must_be_shown_with_continuous_tag() throws Throwable {
		String Continuos_label = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Continuos_tag"))).getText();
		System.out.println("============"+Continuos_label);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(login.LOCATORS.getProperty("Continuos_tag"))));
		if(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Continuos_tag"))).isDisplayed()) {
		Assert.assertEquals(Continuos_label, "Continuous");
		login.Log4j.info("Continuos tag is displayed infront of series");
		
		}
		else {
			login.Log4j.info("Continuos tag is not displayed infront of series");
		}
	}
	
	@And("^make series as Favourite\\.$")
	public void make_series_as_Favourite() throws Throwable {
		CommonFunctionality.wait(2000);
		//Favourite_icon_selected
		login.driver.findElement(By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[1]")).click();
		System.out.println("before if");
		if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Favourite_icon"))).size()==1) {
			System.out.println("under if");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Favourite_icon"))).click();
			System.out.println("clicked on favorite icon");
			    
			Thread.sleep(2000);
		    login.Log4j.info("Favourite icon is clicked.");
	}
		else {
			login.Log4j.info("Favourite icon is already seleted.");
			System.out.println("Favourite icon is already seleted.");
		}
		
		System.out.println("outside if");
	}
	
	@Given("^apply other function\\.$")
	public void apply_other_function() throws Throwable {
		login.driver.findElement(By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[1]")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Open_function"))).click();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_icon"))).click();
		int x =login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Function_bartab"))).size();
		int y=login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Function_wizard"))).size();
		if(y==1 && x==1) {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Function_wizard"))).click();
			login.driver.findElement(By.xpath("//li[@title='Round the values']")).click();
				//login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Function_bartab"))).click();
			    CommonFunctionality.wait(2000);
				WebElement Add=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_function")));
				Add.click();
				CommonFunctionality.wait(2000);
				login.driver.findElement(By.xpath("//button[normalize-space()='Insert function']")).click();
				
				login.driver.findElement(By.xpath("//button[normalize-space()='Apply']")).click();
				CommonFunctionality.wait(2000);
				if(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Additional_functions"))).isDisplayed()) {
					WebElement Functions_added = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Additional_functions")));
					new Actions(login.driver).moveToElement(Functions_added).pause(2000).build().perform();
					login.Log4j.info("Additional functions are added");
					
				}
				else {
					login.Log4j.info("Additional functions are not added");
				}
		}
		
		
			   
	}
	
	@And("^clicks on add icon\\.$")
	public void clicks_on_add_icon() throws Throwable {
		CommonFunctionality.wait(2000);
		
		
		login.driver.findElement(By.xpath("(//div[@class='add-to-data-selection--icon'])[1]")).click();
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='add-to-data-selection--title'])[1]"))).click();
		
		
	}
		

	@And("^select series=>click related series$")
	public void select_series_click_related_series() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//div[@title='View our suggestions for related series and replacements']//div[@class='insight-action-panel--btn-icon']")).click();
		
		
		
		
	    
	}

	@And("^check for continuos tab\\.$")
	public void check_for_continuos_tab() throws Throwable {
		CommonFunctionality.wait(2000);
		if(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Continuos_Tab"))).isDisplayed()) {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Continuos_Tab"))).click();
			login.Log4j.info("Continuos tab is displayed");
			
		}
		else {
			login.Log4j.info("Continuos tab is not  displayed");
			
		}
		
	   
	}

	@And("^select series=>refresh Insight\\.$")
	public void select_series_refresh_Insight() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		
		if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Insight_settings"))).size()==1) {
			
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Insight_settings"))).click();
			login.driver.findElement(By.xpath("//span[@title='Refresh']")).click();
			
		}
			
		else {
			login.Log4j.info("insight is not displayed");
		}
	   
	   
	}
	@And("^check for continuos tab in insight\\.$")
	public void check_for_continuos_tab_in_insight() throws Throwable {
		if(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Continuostab_insight"))).isDisplayed()) {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Continuostab_insight"))).click();
			login.Log4j.info("Continuos tab is displayed");
			
		}
		else {
			login.Log4j.info("Continuos tab is not displayed");
		}
	   
	}

	@And("^check for preserve Name\\.$")
	public void check_for_preserve_Name() throws Throwable {
		if(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Preserve_continuos"))).isDisplayed()) {
			login.Log4j.info("Name Preserve is Present");
		}
		
		else {
			login.Log4j.info("Name Preserve is not Present");
		}
	}
	@Given("^User enters Series Id in Search bar as :\"([^\"]*)\"\\.$")
	public void user_enters_Series_Id_in_Search_bar_as(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver,"//div[@title='View results as List']", 15).click(); 
		CommonFunctionality.getElementByXpath(login.driver,"//input[@placeholder='Search']", 15).sendKeys(arg1,Keys.ENTER);    
	}
	
	@And("^hovered mouse on series=>See in Database=>Select Global Key Series Database\\.$")
	public void hovered_mouse_on_series_See_in_Database_Select_Global_Key_Series_Database() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement Global_series = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Global_key_hovered")));
		new Actions(login.driver).moveToElement(Global_series).pause(2000).build().perform();
		if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("See_in_database"))).size()==1) {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("See_in_database"))).click();
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Global_key_Database"))).click();
			login.Log4j.info("Clicked on Global Key Database");
		}
		else {
			login.Log4j.info("Global Key Database is not clicked");
		}
	    
	}

	@Then("^selected DB should not be shown in continuos series\\.$")
	public void selected_DB_should_not_be_shown_in_continuos_series() throws Throwable {
		//WebElement Global_Keys = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Global_key_Serieshovered")));
		//new Actions(login.driver).moveToElement(Global_Keys).pause(2000).build().perform();
		
		if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("K_icon"))).size()==1) {
			System.out.println("==enter==");
			login.Log4j.info("The database is not showing continuos series");
		}
		else {
			login.Log4j.info("The database showing continuos series");
		}
		
	    
	}
	@And("^remove Pre-Applied function\\.$")
	public void remove_Pre_Applied_function() throws Throwable {
		//login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Additional_functions"))).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Open_function"))).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Remove_Prefunction"))).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Remove_Prefunction1"))).click();
		//login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Replace_series"))).click();
		login.driver.findElement(By.xpath("//*[normalize-space(text())='Replace selected series']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//button[normalize-space()='Apply']")).click();
		
		
		CommonFunctionality.wait(2000);
	
		if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Additional_functions"))).size()==0) {
				
			
			login.Log4j.info("Additional functions are removed");
			
		}
		else {
			
			login.Log4j.info("Additional functions are  added");
		}
		
	}
	@Given("^select some series into series tab\\.$")
	public void select_some_series_into_series_tab() throws Throwable {
		Thread.sleep(5000);
		List<WebElement> list = login.driver.findElements(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']"));
		
		CommonFunctionality.wait(2000);
		
		
		for (int i=0; i<list.size()-37; i++) {
			CommonFunctionality.wait(2000);
			list.get(i).click();
			CommonFunctionality.wait(2000);	
		}
		
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("add_to_myseries_icon"))).click();	
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		
		}	
		
	    
	

	@And("^click on related tab\\.$")
	public void click_on_related_tab() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//div[contains(text(),'Related series')]")).click();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Continuos_Tab"))).click();
		login.Log4j.info("Continuos tab is displayed");
		
		
	    
	}

	@And("^click on Manage all dropdown=>Add continuos series=>Apply ok$")
	public void click_on_Manage_all_dropdown_Add_continuos_series_Apply_ok() throws Throwable {
		CommonFunctionality.wait(2000);
		if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Manage_All"))).size()==1) {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Manage_All"))).click();
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_continuos_dd"))).click();
			login.Log4j.info("clicked on Add continuos series");
			login.driver.findElement(By.xpath("//*[contains(@class,'button suggestions-wizard--button__apply')]")).click();
			login.Log4j.info("clicked on Apply button");
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath("//*[@class='button button__special']")).click();
			login.Log4j.info("clicked on OK button");		
			
			
		}
	   
	}
	@Then("^all continuos series should be added into my series\\.$")
	public void all_continuos_series_should_be_added_into_my_series() throws Throwable {
		CommonFunctionality.wait(2000);
		List<WebElement>ele=login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Continuos_serieslist")));
		
		
		for(WebElement element : ele) {
			String Series=element.getText();
			System.out.println(Series);
			Assert.assertEquals(Series, "Continuous");
			
		}
		int Continuos_series=login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Continuos_serieslist"))).size();
		
		   if(Continuos_series>0) { 
			 login.Log4j.info("All continuos series are displayed");	 
		 }
		 
		 else {	
			 login.Log4j.info("continuos series are not displayed");	
			 
		 }
			
	   
	}
	
	
	@And("^click on Manage all dropdown=>Add contributed series=>Apply ok$")
	public void click_on_Manage_all_dropdown_Add_contributed_series_Apply_ok() throws Throwable {
		CommonFunctionality.wait(2000);
		if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Manage_All"))).size()==1) {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Manage_All"))).click();
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_contributed_dd"))).click();
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath("//*[contains(@class,'button suggestions-wizard--button__apply')]")).click();
			login.Log4j.info("clicked on Apply button");
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath("//*[@class='button button__special']")).click();
			login.Log4j.info("clicked on OK button");		
			
			
			
		}
	    
	}

	@And("^all contributed series should be added into my series\\.$")
	public void all_contributed_series_should_be_added_into_my_series() throws Throwable {
		CommonFunctionality.wait(2000);
		List<WebElement>ele=login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Contributed_serieslist")));
		
		
		for(WebElement element : ele) {
			String Contributed_Series=element.getText();
			System.out.println(Contributed_Series);
			Assert.assertEquals(Contributed_Series, "C");
			
		}
		int Contributed_series=login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Contributed_serieslist"))).size();
		
		   if(Contributed_series>0) { 
			 login.Log4j.info("All contributed series are displayed");	 
		 }
		 
		 else {	
			 login.Log4j.info("contributed series are not displayed");	
			 
		 }
		
		
	   
	}
	@And("^click on Manage all dropdown=>Add replace selected series=>Apply ok$")
	public void click_on_Manage_all_dropdown_Add_replace_selected_series_Apply_ok() throws Throwable {
		CommonFunctionality.wait(2000);
		if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Manage_All"))).size()==1) {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Manage_All"))).click();
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_replaced_dd"))).click();
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath("//*[contains(@class,'button suggestions-wizard--button__apply')]")).click();
			login.Log4j.info("clicked on Apply button");
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath("//*[@class='button button__special']")).click();
			login.Log4j.info("clicked on OK button");		
			
			
			
		}

	   
	}

	@Then("^selected series will be replaced by continuos series$")
	public void selected_series_will_be_replaced_by_continuos_series() throws Throwable {
		CommonFunctionality.wait(2000);
		List<WebElement>ele=login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Continuos_serieslist")));
		
		
		for(WebElement element : ele) {
			String Series=element.getText();
			System.out.println(Series);
			Assert.assertEquals(Series, "Continuous");
			
		}
		int Continuos_series=login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Continuos_serieslist"))).size();
		
		   if(Continuos_series>0) { 
			 login.Log4j.info("Selected series are replaced by continuos series");	 
		 }
		 
		 else {	
			 login.Log4j.info("Selected series are not replaced by continuos series");	
			 
		 }
	
			 
	   
	}
	@And("^click on Manage all dropdown=>Add delete selected series=>Apply ok$")
	public void click_on_Manage_all_dropdown_Add_delete_selected_series_Apply_ok() throws Throwable {
		CommonFunctionality.wait(2000);
		if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Manage_All"))).size()==1) {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Manage_All"))).click();
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_deleted_dd"))).click();
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath("//*[contains(@class,'button suggestions-wizard--button__apply')]")).click();
			login.Log4j.info("clicked on Apply button");
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath("//*[@class='button button__special']")).click();
			login.Log4j.info("clicked on OK button");
		}
	   
	}

	@Then("^selected series will be deleted from my series$")
	public void selected_series_will_be_deleted_from_my_series() throws Throwable {
		int Deleted_series=login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Deleted_series_list"))).size();
		System.out.println("======="+Deleted_series);
		if(Deleted_series==0) {
			login.Log4j.info("selected series are deleted from my series");
			
		}
		else {
			login.Log4j.info("selected series are not deleted from my series");
		}
	    
	}
	@And("^click on Manage all dropdown\\.$")
	public void click_on_Manage_all_dropdown() throws Throwable {
		CommonFunctionality.wait(2000);
		if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Manage_All"))).size()==1) {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Manage_All"))).click();
			login.Log4j.info("All series are displayed");
		}
		else {
			login.Log4j.info("All series are not displayed");
		}
	    
	}

	@Then("^validate the \"([^\"]*)\" Sheet and read the '(\\d+)' '(\\d+)' row and column and verify the Preapplied-function$")
	public void validate_the_Sheet_and_read_the_row_and_column_and_verify_the_Preapplied_function(String arg1, int arg2, int arg3) throws Throwable {
		Thread.sleep(2000);
		//String ss="SPLICE(series ID:18987001, Industrial Production Index: 1980-81=100 [SPLICE(series ID:18989701, Industrial Production Index: 1993-94=100; No; Average ratio; Range; 1994-04-01; 1994-04-01) > SPLICE(series ID:314398401, Industrial Production Index: 2004-05=100; No; Average ratio; Range; 2005-04-01; 2005-04-01) > SPLICE(series ID:386587797, Industrial Production Index (IPI); No; Average ratio; Range; 2012-04-01; 2012-04-01)]; No; Average ratio; Range; 2012-04-01; 2012-04-01)";
		String ss="UPDATE(series ID:8475101, CN: (DC)Automobile: Sales: Passenger Cars [UPDATE(series ID:56397101, Automobile: Sales: Passenger Car (PC); No; Yes; none)]; No; Yes; none)";
		login.Log4j.info("Pre-Applied functions are applied and validated");
		System.out.println("---------------"+arg1);
		System.out.println("---------------"+arg2);
		System.out.println("---------------"+arg3);
		System.out.println("---------------"+ss);
		
		CommonFunctionality.Download_to_Excel(arg1, arg2, arg3, ss);
	}
	
	@Given("^click on download button=>Download to excel\\.$")
	public void click_on_download_button_Download_to_excel() throws Throwable {
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		login.driver.findElement(By.xpath("//button[@class='drop-down-button--btn download-button--button button button__download-btn']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("(//span[normalize-space(text())='Download'])[2]")).click();
		
		
	    
	}
	
	
	@Given("^select favorite function on continuos series$")
	public void select_favorite_function_on_continuos_series() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[1]")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//input[@placeholder='Type a function']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//li[@title='Round the values']")).click();
		CommonFunctionality.wait(2000);
		WebElement ele=login.driver.findElement(By.xpath("//div[@class='toggle-favorite-control--icon']"));
		js.executeScript("arguments[0].click();", ele);
		CommonFunctionality.wait(2000);
		
		
		
	    
	}

	@Then("^favourite function should be applied with pre-applied function$")
	public void favourite_function_should_be_applied_with_pre_applied_function() throws Throwable {
		
		CommonFunctionality.wait(2000);
	
		WebElement Series_hovered = login.driver.findElement(By.xpath("//span[normalize-space(text())='Consumer Price Index (CPI)']"));
		CommonFunctionality.action.moveToElement(Series_hovered ).pause(2).build().perform();
		
		
	
		String data=login.driver.findElement(By.xpath("//div[contains(text(),'UPDATE(series ID:369704527, CN: GDP: 2010p: Primar')]")).getText();
		System.out.println("======="+data);
		
		if(data.contains("UPDATE") && data.contains("ROUND()")) {
			login.Log4j.info("Favourite function is applied with preapplied function ");	
		}
		else {
			login.Log4j.info("Favourite function is not applied with preapplied function ");
			
		}
		
		
			
		
	    	}


	 
	}


	
	  
	    
	



