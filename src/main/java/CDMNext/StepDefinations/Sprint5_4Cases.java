package CDMNext.StepDefinations;

import static org.testng.Assert.fail;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.internal.runners.statements.Fail;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.gargoylesoftware.htmlunit.javascript.host.canvas.WebGLRenderbuffer;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.AssertionFailedError;
import test.junit.BaseTest;



public class Sprint5_4Cases extends CommonFunctionality{
	CDMNextSprintCases cv = new CDMNextSprintCases();
	
	
public static 	String parent_window;
		@Given("^user creates a commentary visual\\.$")
	public void user_creates_a_commentary_visual() throws Throwable {
		try {
			login.driver.findElement(By.xpath("//div[@class='insight-page-menu-views-container--add']")).click();
			WebDriverWait wait = new WebDriverWait(login.driver, 40);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[@class='insight-page-view-tab--title']")))).click();
			CommonFunctionality.wait(3000);
			WebElement commentary=login.driver.findElement(By.xpath("(//div[@class='icon--text'])[1]"));
			jse.executeScript("arguments[0].click();", commentary);
			
			
		}
		
	catch(Exception e) {
		
		WebElement view=login.driver.findElement(By.xpath("//span[@class='insight-page-view-tab--title']"));
		if(view.isDisplayed()) {
		view.click();
		
		CommonFunctionality.wait(3000);
		WebElement commentary=login.driver.findElement(By.xpath("(//div[@class='icon--text'])[1]"));
		jse.executeScript("arguments[0].click();", commentary);
		}
	}
		
		
		
		
		
		
		
	   
	}
	
	@Given("^Select any two series id \"([^\"]*)\" and create Chart in view (\\d+)$")
	public void select_any_two_series_id_and_create_Chart_in_view(String arg1, int arg2) throws Throwable {
		WebElement View2=login.driver.findElement(By.xpath("//div[@title='Create new View tab']"));
		View2.click();
		select_any_series_id(arg1);
		List<WebElement> series=login.driver.findElements(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']"));
		Thread.sleep(2000);
		for(WebElement serieslist:series)
		{
			serieslist.click();
		}
		WebElement First_Series = login.driver.findElement(By.xpath("(//div[@class='series-list-item--information'])[1]"));
		action.moveToElement(First_Series).pause(2000).build().perform();
		
		WebElement More_Actions=login.driver.findElement(By.xpath("//span[@title='More actions']"));
		 jse. executeScript("arguments[0]. click();", More_Actions);
		 WebElement View_Chart=login.driver.findElement(By.xpath("//span[normalize-space()='Add chart']"));
		 action.moveToElement(View_Chart).pause(2000).build().perform();
		WebElement Line= login.driver.findElement(By.xpath("//div[contains(@class,'icon--chart-line_large')]"));
		 new Actions(login.driver).moveToElement(Line).doubleClick().build().perform();
		//a.sendKeys((Keys.chord("c"))).build().perform();
		Thread.sleep(2000);
		try {
			WebElement Series_Harmonization=login.driver.findElement(By.xpath("//button[normalize-space(text())='Apply']"));
			Series_Harmonization.click();
	
		
		}
		catch(Exception e) {
			System.out.println("Pop up not appeared");
		}

	    
	}
	
	

	@Given("^check for visual title\\.$")
	public void check_for_visual_title() throws Throwable {
		WebElement title=login.driver.findElement(By.xpath("//*[@class='visual-configuration-menu--btn']"));
		title.click();
		WebElement Checkbox=login.driver.findElement(By.xpath("(//*[@class='input-control input-control__sm'])[1]"));
		if(!Checkbox.isSelected()) {
			System.out.println("Commentary visual title is hidden by default");
			
		}
		else {
			System.out.println("Commentary visual title is not hidden by default");
			
		}
		
	   
	}


	@Given("^user Navigates to status page \"([^\"]*)\"\\.$")
	public void user_Navigates_to_status_page(String arg1) throws Throwable {
		 parent_window=login.driver.getWindowHandle();
		CommonFunctionality.jse.executeScript("window.open('https://stage.ceicdata.com/status','_blank');");
		
	}

		@Given("^check HTTP Methods PUT, PATCH, DELETE\\.$")
	public void check_HTTP_Methods_PUT_PATCH_DELETE() throws Throwable {
			Set<String> child_window=login.driver.getWindowHandles();
			
			for(String s:child_window) {
				System.out.println("===parent==="+parent_window);
				System.out.println("===s==="+s);
				if(!parent_window.equalsIgnoreCase(s)) {
					
					login.driver.switchTo().window(s);
					
				}
				
				
			}
			System.out.println("child window" +child_window.size());	
            validate_headers("HTTP PUT Method");
            validate_headers("HTTP PATCH Method");
            validate_headers("HTTP DELETE Method");         	
	}
		
		public void validate_headers(String value) {
			
			WebElement ele=login.driver.findElement(By.xpath("//div[normalize-space(text())='"+value+"']"));
			if(ele.isDisplayed()) {
				System.out.println(value+"is displayed");
			}
			else {
				System.out.println(value+"is  not displayed");
			}
			login.driver.navigate().refresh();
			CommonFunctionality.wait(5000);
			WebElement ele1=login.driver.findElement(By.xpath("//div[text()='"+value+"']/following-sibling::div"));
			String  text=ele1.getText();
			System.out.println("======text===="+text);
			if(text.equalsIgnoreCase("Success")) {
				
				System.out.println("Success is populated");
			}
			else {
				System.out.println("Success  not is populated");
			}
			
			
			
			
		}
		
	
	@Then("^Status should be available and the status should be success always\\.$")
	public void status_should_be_available_and_the_status_should_be_success_always() throws Throwable {
		
		Thread.sleep(5000);
		for(int i=0;i<5;i++) {
			JavascriptExecutor jse=(JavascriptExecutor)login.driver;
			jse.executeScript("window.scrollBy(0,250)");
			try {
		WebElement ele=login.driver.findElement(By.xpath("//div[text()='HTTP PUT Method']"));
	
			
			}
			catch (Exception e) {
				System.out.println("not found");
			}
	
		
		
		}
		
	   
	}
	
	@Given("^user Navigates to Analysis insights$")
	public void user_Navigates_to_Analysis_insights() throws Throwable {
		WebElement Analysis=login.driver.findElement(By.xpath("//span[normalize-space(text())='Analysis']"));
		Analysis.click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//span[normalize-space(text())='Latin America']")).click();
		
	   
	}

	@Given("^switch to table mode\\.$")
	public void switch_to_table_mode() throws Throwable {
		CommonFunctionality.wait(1000);
		WebElement Table_Mode=login.driver.findElement(By.xpath("//div[@title='View as a table']"));
		Table_Mode.click();
		
	    
	}

	@Then("^check featured insights are displayed on top of the list\\.$")
	public void check_featured_insights_are_displayed_on_top_of_the_list() throws Throwable {
		WebElement Featured=login.driver.findElement(By.xpath("//div[normalize-space(text())='FEATURED']"));
		if(Featured.isDisplayed()) {
			System.out.println("Featured Tab is displayed");
		}
		else {
			System.out.println("Featured Tab is not displayed");
		}
	   
	}

	@Given("^user creates a table visual with (\\d+) series$")
	public void user_creates_a_table_visual_with_series(int arg1) throws Throwable {
		List<WebElement> checkboxes = login.driver
				.findElements(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']"));
		
		for(int i=0;i<3;i++) {
			CommonFunctionality.wait(3000);
			checkboxes.get(i).click();
			CommonFunctionality.wait(2000);
		}
		WebElement FirstSeries=login.driver.findElement(By.xpath("(//div[@class='series-item--main-info'])[1]"));
		new Actions(login.driver).moveToElement(FirstSeries).pause(1000).build().perform();
		CommonFunctionality.wait(2000);
		WebElement ele=login.driver.findElement(By.xpath("//span[@title='More actions']"));
		jse.executeScript("arguments[0].click();", ele);
		WebElement Add_chart=login.driver.findElement(By.xpath("//span[normalize-space(text())='Add chart']"));
		new Actions(login.driver).moveToElement(Add_chart).pause(1000).build().perform();
		login.driver.findElement(By.xpath("//div[contains(@class,'icon--table-vertical_large')]")).click();
		
		try {
			login.driver.findElement(By.xpath("//button[normalize-space(text())='Apply']")).click();
		}
	    catch(Exception e) {
	    	System.out.println("Pop up not appeared");
	    }
	}

	@Given("^download series base and transformed to excel$")
	public void download_series_base_and_transformed_to_excel() throws Throwable {
		CommonFunctionality.wait(2000);
		
		String  DOWNLOAD_DEFAULT_LOCAL_DIRECTORY =  "C:\\Users\\ShankarVenkatRaju\\Downloads";
		 String  DOWNLOAD_DEFAULT_Remote_DIRECTORY ="D:\\Raju\\CDMNextAutomation\\Cucumber_project\\Testdata";
		 String name = getTitleOfInsight();
		 String  fileCDM="Apply_Avg";
		 
		ArrayList<String> arrayTimepointsSerieExcel = getTimePointToExcel(1,DOWNLOAD_DEFAULT_LOCAL_DIRECTORY,name);
		  System.out.println("=====arrayTimepointsSerieExcel========"+arrayTimepointsSerieExcel);
		  ArrayList<String> arrayTimepointsSerieExcelCDM = getTimePointToExcel1(1, DOWNLOAD_DEFAULT_Remote_DIRECTORY,fileCDM);
		  System.out.println("=====arrayTimepointsSerieExcelCDM========"+arrayTimepointsSerieExcelCDM);
		 System.out.println("===arrayTimepointsSerieExcel1==="+arrayTimepointsSerieExcel);
		 System.out.println("===arrayTimepointsSerieExcelCDM1==="+arrayTimepointsSerieExcelCDM);
	Assert.assertTrue(arrayTimepointsSerieExcel.equals(arrayTimepointsSerieExcelCDM));
	   
	}
	@Given("^change the table visual to invert mode from edit visual\\.$")
	public void change_the_table_visual_to_invert_mode_from_edit_visual() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//button[normalize-space(text())='Edit Table']")).click();
		WebElement Invert=login.driver.findElement(By.xpath("//span[normalize-space(text())='Invert']/preceding-sibling::span"));
		Invert.click();
		
	    
	}

	@Given("^series selector is displayed=>select (\\d+) series\\.$")
	public void series_selector_is_displayed_select_series(int arg1) throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[@class='index-module_text__GTkop']")))).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//input[@class='index-module_text__GTkop']")).sendKeys(Keys.BACK_SPACE);
		login.driver.findElement(By.xpath("//input[@class='index-module_text__GTkop']")).click();
		login.driver.findElement(By.xpath("//input[@class='index-module_text__GTkop']")).sendKeys(Keys.BACK_SPACE);
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//input[@class='index-module_text__GTkop']")).sendKeys("3");
		
	    
	}

	@Then("^only top (\\d+) selected  series should be visible on the table visual\\.$")
	public void only_top_selected_series_should_be_visible_on_the_table_visual(int arg1) throws Throwable {
		CommonFunctionality.wait(2000);
	WebElement TopFour=login.driver.findElement(By.xpath("//input[@value='3']"));
	if(TopFour.isDisplayed()) {
		System.out.println("The top 4 selected series should be visible on the table visual");
	}
	
	else {
		System.out.println("The top 4 selected series is not  be visible on the table visual");
	}
			
		
	   
	}
	@Given("^series selector is displayed\\.$")
	public void series_selector_is_displayed() throws Throwable {
		WebElement Series_selector=login.driver.findElement(By.xpath("//label[normalize-space(text())='Series']"));
		if(Series_selector.isDisplayed()) {
			System.out.println("Series selector is displayed");
		}
		else {
			System.out.println("Series selector is not  displayed");
		}
	}
	
	@Given("^series selector is displayed with default value\\.$")
	public void series_selector_is_displayed_with_default_value() throws Throwable {
		WebElement Series_selector=login.driver.findElement(By.xpath("//label[normalize-space(text())='Series']"));
		if(Series_selector.isDisplayed()) {
			
			System.out.println("Series selector is displayed with default value");
		}
		else {
			System.out.println("Series selector is not  displayed");
		}
	    
	}

	@Given("^select (\\d+) series\\.$")
	public void select_series(int arg1) throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[@class='index-module_text__GTkop']")))).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//input[@class='index-module_text__GTkop']")).sendKeys(Keys.BACK_SPACE);
		login.driver.findElement(By.xpath("//input[@class='index-module_text__GTkop']")).click();
		login.driver.findElement(By.xpath("//input[@class='index-module_text__GTkop']")).sendKeys(Keys.BACK_SPACE);
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//input[@class='index-module_text__GTkop']")).sendKeys("3");
	}
	@Given("^click on Date Header\\.$")
	public void click_on_Date_Header() throws Throwable {
		login.driver.findElement(By.xpath("(//span[text()='No end date'])[2]")).click();
		CommonFunctionality.wait(2000);
		
	   
	}
	@Then("^The number of series entere in the series field should be displayed on the table visual\\.$")
	public void the_number_of_series_entere_in_the_series_field_should_be_displayed_on_the_table_visual() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement TopThree=login.driver.findElement(By.xpath("//input[@value='3']"));
		if(TopThree.isDisplayed()) {
			System.out.println("The top 3 selected series should be visible on the table visual");
		}
		
		else {
			System.out.println("The top 3 selected series is not  be visible on the table visual");
		}
	   
		
		
		
		
	}

	@Given("^check the number of series displayed on the top\\.$")
	public void check_the_number_of_series_displayed_on_the_top() throws Throwable {
		WebElement NoOfSeries=login.driver.findElement(By.xpath("//input[@placeholder='10']"));
		if(NoOfSeries.isDisplayed()) {
			System.out.println("By default 10 number of series are displayed");
		}
		else {
			System.out.println("No of series by default are not displayed");
		}
	}
	
	@Given("^type something\\.$")
	public void type_something() throws Throwable {
		WebElement Edit_Area=login.driver.findElement(By.xpath("//div[@class='tox-edit-area']/iframe"));
		jse.executeScript("arguments[0].click();", Edit_Area);
        CommonFunctionality.wait(3000);

		Edit_Area.sendKeys("shankar");
	   
	}

	@Then("^click on Full Screen\\.$")
	public void click_on_Full_Screen() throws Throwable {
		WebElement Full_Screen=login.driver.findElement(By.xpath("//*[text()='Full screen']/../span[1]"));
		if(Full_Screen.isDisplayed()) {
			CommonFunctionality.wait(2000);
			Full_Screen.click();
			System.out.println("commentary visual is displayed in Full screen mode");
		}
		else {
			System.out.println("commentary visual is not  displayed in Full screen mode");
		}
	    
	}

	@Given("^remove full screen\\.$")
	public void remove_full_screen() throws Throwable {
		WebElement Full_Screen=login.driver.findElement(By.xpath("//*[text()='Full screen']/../span[1]"));
		if(Full_Screen.isDisplayed()) {
			CommonFunctionality.wait(2000);
			Full_Screen.click();
			System.out.println("commentary visual is displayed in Full screen mode");
		}
		else {
			System.out.println("commentary visual is not  displayed in Full screen mode");
		}
		CommonFunctionality.wait(2000);
		WebElement Remove_Screen=login.driver.findElement(By.xpath("//*[text()='Full screen']/../span[1]"));
		if(Remove_Screen.isDisplayed()) {
			CommonFunctionality.wait(2000);
			Full_Screen.click();
			System.out.println("commentary visual is displayed in not Full screen mode");
		}
		else {
			System.out.println("commentary visual is not  displayed in Full screen mode");
		}
		
	}
	
	@Given("^click on more icon\\.$")
	public void click_on_more_icon() throws Throwable {
		WebElement More =login.driver.findElement(By.xpath("//button[@title='More...']"));
		More.click();
	   
	}

	@Given("^click on Insert/Edit link icon\\.$")
	public void click_on_Insert_Edit_link_icon() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement Insert_link =login.driver.findElement(By.xpath("//button[@title='Insert/edit link']"));
		System.out.println("Insert link opened");
		Insert_link.click();
	    
	}

	@Then("^The Insert/Edit link popup should be opened\\.$")
	public void the_Insert_Edit_link_popup_should_be_opened() throws Throwable {
		WebElement Edit_linkPopup=login.driver.findElement(By.xpath("//div[normalize-space(text())='Insert/Edit Link']"));
		if(Edit_linkPopup.isDisplayed()) {
			System.out.println("Insert/Edit link pop up is displayed");
		}
		else {
			System.out.println("Insert/Edit link pop up is not displayed");
		}
	   
	}
	@Given("^click on Special character symbol\\.$")
	public void click_on_Special_character_symbol() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement Special_Character_link =login.driver.findElement(By.xpath("//button[@title='Special character']"));
		System.out.println("Insert link opened");
		Special_Character_link.click();
	   
	}

	@Then("^the special character popup should be opened\\.$")
	public void the_special_character_popup_should_be_opened() throws Throwable {
		WebElement Special_CharacterPopup=login.driver.findElement(By.xpath("//div[normalize-space(text())='Special Character']"));
		if(Special_CharacterPopup.isDisplayed()) {
			System.out.println("Special Character Popup  pop up is displayed");
		}
		else {
			System.out.println("Special Character pop up is not displayed");
		}
		
		
	   
	}
	@Given("^search for a Special Character as \\$\\.$")
	public void search_for_a_Special_Character_as_$() throws Throwable {
		WebElement Search=login.driver.findElement(By.xpath("//input[@class='tox-textfield']"));
		Search.click();
		Search.sendKeys("$");
		
		
	   
	}

	@Then("^searched special character should display\\.$")
	public void searched_special_character_should_display() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement Special_character=login.driver.findElement(By.xpath("//div[@title='dollar sign']"));
		if(Special_character.isDisplayed()) {
			System.out.println("The searched special character is displayed");
		}
		else {
			System.out.println("The searched special character is not displayed");
		}
	}

	@Given("^Popup is opened > Click on Close button/icon\\.$")
	public void popup_is_opened_Click_on_Close_button_icon() throws Throwable {
		WebElement Close=login.driver.findElement(By.xpath("(//button[@title='Close'])[2]"));
		if(Close.isDisplayed()) {
			Close.click();
			System.out.println("The special character pop up is closed");
		}
		else {
			System.out.println("The special character pop up is not  closed");
		}
		
	}
	@Given("^click on BlockQuote icon=>Type something$")
	public void click_on_BlockQuote_icon_Type_something() throws Throwable {
		WebElement Edit_Area=login.driver.findElement(By.xpath("//div[@class='tox-edit-area']/iframe"));
		jse.executeScript("arguments[0].click();", Edit_Area);
        CommonFunctionality.wait(3000);

		Edit_Area.sendKeys("shankar");
	}

	@Then("^the blockquote should be applied\\.$")
	public void the_blockquote_should_be_applied() throws Throwable {
		
		login.driver.findElement(By.xpath("//button[@title='More...']")).click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//button[@title='More...']")).click();
		
		login.driver.findElement(By.xpath("//*[@title='Blockquote']")).click();
		List<WebElement> Blockquote=login.driver.findElements(By.xpath("//*[@id='tinymce']//blockquote"));
		if(Blockquote.size()==1) {
			System.out.println("Blockquote is applied to visual");
		}
		else {
			System.out.println("Blockquote is not applied to visual");
		}
	   
	}
	@Given("^user double clicks on view Tab$")
	public void user_double_clicks_on_view_Tab() throws Throwable {
		login.driver.findElement(By.xpath("//div[@class='insight-page-menu-views-container--add']")).click();
		CommonFunctionality.wait(2000);
		WebElement View_Tab=login.driver.findElement(By.xpath("//span[@class='insight-page-view-tab--title']"));
		new Actions(login.driver).moveToElement(View_Tab).doubleClick().build().perform();
	    
	}

	@Given("^rename popup should be displayed for view\\.$")
	public void rename_popup_should_be_displayed_for_view() throws Throwable {
		WebElement Rename=login.driver.findElement(By.xpath("//div[@class='insight-view-rename']"));
		if(Rename.isDisplayed()) {
			System.out.println("Rename Popup is displayed");
		}
		else {
			System.out.println("Rename Popup is not displayed");
		}
	}
	@Given("^user creates a Table visual\\.$")
	public void user_creates_a_Table_visual() throws Throwable {
		
		WebDriverWait wait = new WebDriverWait(login.driver, 80);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//div[@title='View results as List']")))).click();	
		
		CommonFunctionality.wait(500);
		WebElement Serieslist = login.driver.findElement(
				By.xpath("//div[@class='series-list-item-data']/div[@class='series-list-item--information'][1]"));
		new Actions(login.driver).moveToElement(Serieslist).pause(3000).build().perform();
	    WebElement ele1 = login.driver.findElement(By.xpath("//div[@class='series-list-item--action-icons']/span[@title='More actions']//*[name()='svg']//*[local-name()='use'][1]"));
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

		
	}

	

	@And("^check the  default attributes  'Name, Region, Unit, Series ID, Frequency' should be present\\.$")
	public void check_the_default_attributes_Name_Region_Unit_Series_ID_Frequency_should_be_present() throws Throwable {
		List<WebElement> ele=login.driver.findElements(By.xpath("//table//tr/th"));
		List<String> attributes=new ArrayList();
		for(WebElement e :ele) {
			
			String value=e.getText();
			
			System.out.println(value);
			attributes.add(value);
			
		}
		if(attributes.contains("Name")  && attributes.contains("Region") && attributes.contains("Unit")  && attributes.contains("Series ID")) {
			System.out.println("values are found");
		}
		
	    
	}
	@Given("^user Adds some series into my series$")
	public void user_Adds_some_series_into_my_series() throws Throwable {
List<WebElement> list = login.driver.findElements(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']"));
		
		CommonFunctionality.wait(2000);
		
		
		for (int i=0; i<3; i++) {
			CommonFunctionality.wait(2000);
			list.get(i).click();
			CommonFunctionality.wait(2000);	
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("add_to_myseries_icon"))).click();	
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
	  
	}

	@Given("^sort by any option\\.$")
	public void sort_by_any_option() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement Series_hover=login.driver.findElement(By.xpath("(//div[@class='series-name-field'])[1]"));
		CommonFunctionality.action.moveToElement(Series_hover).pause(3000).build().perform();
		login.driver.findElement(By.xpath("(//span[@class='series-item--icon series-item--icon__edit'])[1]")).click();
		CommonFunctionality.wait(2000);
		WebElement Change=login.driver.findElement(By.xpath("//span[@title='Change']"));
		CommonFunctionality.action.moveToElement(Change).pause(3000).click().build().perform();
		login.driver.findElement(By.xpath("//span[@title='% Period-over-Period (%PoP)']")).click();
		
		
	   
	}

	@Given("^switch to any tab and select myseries again\\.$")
	public void switch_to_any_tab_and_select_myseries_again() throws Throwable {
		login.driver.findElement(By.xpath("//div[@class='insight-page-menu-views-container--add']")).click();
		CommonFunctionality.wait(2000);
		WebElement View_Tab=login.driver.findElement(By.xpath("//span[@class='insight-page-view-tab--title']"));
		View_Tab.click();
		CommonFunctionality.wait(1000);
		WebElement MySeries=login.driver.findElement(By.xpath("//*[normalize-space(text())='My Series']"));
		MySeries.click();
		
	   
	}

	@Then("^the user saved status should saved even refresh the insight\\.$")
	public void the_user_saved_status_should_saved_even_refresh_the_insight() throws Throwable {
		WebElement Checked=login.driver.findElement(By.xpath("//*[normalize-space(text())='Checked']"));
		if(Checked.isDisplayed()) {
			System.out.println("User saved status is saved even after refresh");
		}
				
		else {
			System.out.println("User saved status is not  saved even after refresh");
			
		}
	   
	}

	@Given("^user creates a Histogram visual$")
	public void user_creates_a_Histogram_visual() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 80);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//div[@title='View results as List']")))).click();	
		
		CommonFunctionality.wait(500);
		WebElement Serieslist = login.driver.findElement(
				By.xpath("//div[@class='series-list-item-data']/div[@class='series-list-item--information'][1]"));
		new Actions(login.driver).moveToElement(Serieslist).pause(3000).build().perform();
	    WebElement ele1 = login.driver.findElement(By.xpath("//div[@class='series-list-item--action-icons']/span[@title='More actions']//*[name()='svg']//*[local-name()='use'][1]"));
		CommonFunctionality.action.moveToElement(ele1).pause(2).click().build().perform();
		CommonFunctionality.wait(2000);
		WebElement Add_chart=login.driver.findElement(By.xpath("//span[normalize-space(text())='Add chart']"));
		new Actions(login.driver).moveToElement(Add_chart).pause(1000).build().perform();
		login.driver.findElement(By.xpath("//div[contains(@class,'icon--histogram_large')]")).click();
		
		try {
			login.driver.findElement(By.xpath("//button[normalize-space(text())='Apply']")).click();
		}
	    catch(Exception e) {
	    	System.out.println("Pop up not appeared");
	    }

	}

	@Given("^clicks on Date Picker\\.$")
	public void clicks_on_Date_Picker() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement Date_picker=login.driver.findElement(By.xpath("//span[text()='No end date']"));
		Date_picker.click();
	   
	}

	@Then("^Calendar should be opened\\.$")
	public void calendar_should_be_opened() throws Throwable {
		
		WebElement Calendar_popup=login.driver.findElement(By.xpath("//div[contains(@class,'dropdown--body__open')]"));
		if(Calendar_popup.isDisplayed()) {
			System.out.println("Calendar popup is displayed");
			
		}
		else {
			System.out.println("Calendar popup is nor displayed");
		}
	}

	

	@Then("^selected period should be applied to histogram visual\\.$")
	public void selected_period_should_be_applied_to_histogram_visual() throws Throwable {
		WebElement Edit_Histogram=login.driver.findElement(By.xpath("//button[text()='Edit Histogram']"));
		Edit_Histogram.click();
	    List<WebElement> Dates=login.driver.findElements(By.xpath("(//*[@class='highcharts-axis-labels highcharts-xaxis-labels'])[5]"));
	    for(WebElement element : Dates) {
	    	String dates=element.getText();
			System.out.println(dates);
			
	    	if(dates.contains("01/01/1985")) {
	    		System.out.println("1985 date is displayed");
	    	}
	    	else {
	    		System.out.println("1985 date is not displayed");
	    	}
	    	if(dates.contains("01/01/1990")) {
	    		System.out.println("1990 date is displayed");
	    	}
	    	else {
	    		System.out.println("1990 date is not displayed");
	    	}
	    	if(dates.contains("01/01/1995")) {
	    		System.out.println("1995 date is displayed");
	    	}
	    	else {
	    		System.out.println("1995 date is not displayed");
	    	}
	    	if(dates.contains("01/01/2000")) {
	    		System.out.println("2000 date is displayed");
	    	}
	    	else {
	    		System.out.println("2000 date is not displayed");
	    	}	
	    	if(dates.contains("01/01/2005")) {
	    		System.out.println("2005 date is displayed");
	    	}
	    	else {
	    		System.out.println("2005 date is not displayed");
	    	}
	    	if(dates.contains("01/01/2010")) {
	    		System.out.println("2010 date is displayed");
	    	}
	    	else {
	    		System.out.println("2010 date is not displayed");
	    	}
	    	if(dates.contains("01/01/2015")) {
	    		System.out.println("2015 date is displayed");
	    	}
	    	else {
	    		System.out.println("2015 date is not displayed");
	    	}	
	    	if(dates.contains("01/01/2020")) {
	    		System.out.println("2020 date is displayed");
	    	}
	    	else {
	    		System.out.println("2020 date is not displayed");
	    	}
	    }
	}
	@Given("^user clicks on Open Indicator filter\\.$")
	public void user_clicks_on_Open_Indicator_filter() throws Throwable {
		WebElement Indicator=login.driver.findElement(By.xpath("//span[text()='Indicator']"));
		Indicator.click();
		
	   
	}

	@Given("^select Real GDP=>Apply$")
	public void select_Real_GDP_Apply() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//span[normalize-space(text())='Real GDP']")).click();
		try {
			login.driver.findElement(By.xpath("//div[normalize-space(text())='Apply filter']")).click();
		}
		catch(Exception e) {
			System.out.println("Apply filter alraedy clicked");
		}
		/*WebElement Apply_filter=login.driver.findElement(By.xpath("//div[normalize-space(text())='Apply filter']"));
		Apply_filter.click();*/
		
	   
	}

	@Given("^hover the mouse on the selected indicator=>full path should display\\.$")
	public void hover_the_mouse_on_the_selected_indicator_full_path_should_display() throws Throwable {
		/*WebElement RealGDP_indicator=login.driver.findElement(By.xpath("//span[normalize-space(text())='Real GDP']"));
		CommonFunctionality.action.moveToElement(RealGDP_indicator).pause(2).click().build().perform();*/
		
		//WebElement Real_GDP=login.driver.findElement(By.xpath("//span[text()='Real GDP']"));
		WebElement RealGDP_indicator=login.driver.findElement(By.xpath("//span[text()='Real GDP']"));
		action.moveToElement(RealGDP_indicator).pause(000).build().perform();
		//CommonFunctionality.wait(2000);
		
		WebElement Flowof_Funds=login.driver.findElement(By.xpath("//div[normalize-space(text())='National Accounts and Flow of Funds > Real GDP']"));
		if(Flowof_Funds.isDisplayed()) {
			System.out.println("Full Path is displayed");
		}
		else {
			System.out.println("Full Path is not displayed");
		}
	   
	}
	@And("^Search for on demand series '(\\d+)'$")
	public void search_for_on_demand_series(int arg1) throws Throwable {
		WebElement Search=login.driver.findElement(By.xpath("//input[@placeholder='Search']"));
		Search.click();
		Search.clear();
		Search.sendKeys("377135117",Keys.ENTER);
		try {
			WebElement Start_New=login.driver.findElement(By.xpath("//button[text()='Start new']"));
			Start_New.click();
		}
		catch(Exception e) {
			System.out.println("pop up not appeared");
		}
	   
	}

	@And("^Open SSP window\\.$")
	public void open_SSP_window() throws Throwable {
		WebElement SSP_Window=login.driver.findElement(By.xpath("//div[@class='series-item--name']"));
		SSP_Window.click();
	   
	}

	@Then("^On Demand status should be available for such series\\.$")
	public void on_Demand_status_should_be_available_for_such_series() throws Throwable {
		WebElement OnDemand=login.driver.findElement(By.xpath("(//div[normalize-space(text())='On Demand'])[2]"));
		if(OnDemand.isDisplayed()) {
			System.out.println("On Demand status is displayed");
		}
		else {
			System.out.println("On Demand status is not displayed");
		}
	}
	@And("^Download series to excel$")
	public void download_series_to_excel() throws Throwable {
		login.driver.findElement(By.xpath("//*[@class='series-list-item--checkbox svg-checkbox']")).click();
		login.driver.findElement(By.xpath("//div[@class='add-to-data-selection--icon']")).click();
		
		CommonFunctionality.wait(3000);
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		login.driver.findElement(By.xpath("//button[@class='drop-down-button--btn download-button--button button button__download-btn']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("(//span[normalize-space(text())='Download'])[2]")).click();
	    
	}
	
	@Given("^user selects any series and create a chart visual$")
	public void user_selects_any_series_and_create_a_chart_visual() throws Throwable {
		for(int i=1;i<=2;i++) {
			login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])["+i+"]")).click();		
		}
		WebElement First_Series = login.driver.findElement(By.xpath("(//div[@class='series-list-item--information'])[1]"));
		action.moveToElement(First_Series).pause(2000).build().perform();
		
		WebElement More_Actions=login.driver.findElement(By.xpath("//span[@title='More actions']"));
		 jse. executeScript("arguments[0]. click();", More_Actions);
		 WebElement View_Chart=login.driver.findElement(By.xpath("//span[normalize-space()='Add chart']"));
		 action.moveToElement(View_Chart).pause(2000).build().perform();
		 login.driver.findElement(By.xpath("//div[contains(@class,'icon--chart-line_large')]")).click();
	    
	}
	
	@Given("^to other account  with user \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void to_other_account_with_user_and_password(String arg1, String arg2) throws Throwable {
		//logout_from_current_user();
		CommonFunctionality.wait(3000);
		CommonFunctionality.getElementBycssSelector(login.driver, "div[title='View and edit profile information']", 4)
				.click();
		WebElement logout = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Sign out')]", 4);
		jse.executeScript("arguments[0].scrollIntoView(true);", logout);
		jse.executeScript("arguments[0].click();", logout);
		cv.the_application_should_be_logged_out();
		CommonFunctionality.login_as_internal_user(login.driver, "input[name='user_id']", "input[name='password']",
				"button[type='submit']", arg1, arg2);
		try {
			WebElement Start_New=login.driver.findElement(By.xpath("//button[text()='Start new']"));
			Start_New.click();
		}
		catch(Exception e) {
			System.out.println("Pop up not appeared");
		}
	    
	}

	@Given("^hover the mouse on imported series from user(\\d+)$")
	public void hover_the_mouse_on_imported_series_from_user(int arg1) throws Throwable {
		WebElement Imported =login.driver.findElement(By.xpath("//span[text()='Imported']"));
		Imported.click();
		WebElement ImportedSeries3=login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"));
		if(ImportedSeries3.isDisplayed()) {
		 action.moveToElement(ImportedSeries3).pause(2000).build().perform();
		 System.out.println("Hovered on series in imported tab");
		}
		else {
			System.out.println("Hovered option on  series in imported tab is not done");
		}
		 List <WebElement>Remove_Series3=login.driver.findElements(By.xpath("//span[@title='Remove series']"));
		 if(Remove_Series3.size()==0) {
			 System.out.println("Remove series icon is not present");
			 
		 }
		 else {
			 System.out.println("Remove series icon is  present");
		 }
		
	}
	@Given("^The growl popup should display as series imported\\.$")
	public void the_growl_popup_should_display_as_series_imported() throws Throwable {
		WebElement Upload_File=login.driver.findElement(By.xpath("//div[text()='Drag a file here']"));
		Upload_File.click();
		CommonFunctionality.wait(2000);
		//System.out.println(System.getProperty("user.dir") + "\\AutoIT\\CEIC defined template.exe");
		CommonFunctionality.uploadTheFileusingAutoIT(login.driver,
				System.getProperty("user.dir") + "\\AutoIT\\CEIC.exe",
				System.getProperty("user.dir") + "\\AutoIT\\CEIC.xlsx");
		Thread.sleep(8000);
		WebElement Growl_Message=login.driver.findElement(By.xpath("//div[@class='growl-message-text']"));
		if(Growl_Message.isDisplayed()) {
			System.out.println("File imported successfully message is displayed");
		}
		else {
			System.out.println("File imported successfully message is not displayed");
		}
	}
	
	

	@Given("^click on Edit series\\.$")
	public void click_on_Edit_series() throws Throwable {
		CommonFunctionality.wait(3000);
		 WebElement Edit_Series=login.driver.findElement(By.xpath("//button[text()='Edit Series']"));
		 Edit_Series.click();
	   
	}

	@Then("^cross mark icon should be fixed\\.$")
	public void cross_mark_icon_should_be_fixed() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement Cross_Mark=login.driver.findElement(By.xpath("(//div[@class='remove-item-control'])[1]"));
		if(Cross_Mark.isDisplayed()) {
			System.out.println("Cross mark icon is fixed");
		}
		else {
			System.out.println("Cross mark icon is not fixed");
		}
	}

	
	
	

	@Then("^On Demand status should be shown on the Excel\\.$")
	public void on_Demand_status_should_be_shown_on_the_Excel() throws Throwable {
		
	   CommonFunctionality.Download_to_Excel("Employment Index",6,1,"On Demand");
	}
	@Given("^download to excel\\.$")
	public void download_to_excel() throws Throwable {
	   
	}

	@Then("^the visual and date should download with selected time period\\.$")
	public void the_visual_and_date_should_download_with_selected_time_period() throws Throwable {
	    
	}
	@Given("^user clicks on Open Region Filter\\.$")
	public void user_clicks_on_Open_Region_Filter() throws Throwable {
		login.driver.findElement(By.xpath("//span[normalize-space(text())='All Regions']")).click();
		CommonFunctionality.wait(5000);
		WebElement India=login.driver.findElement(By.xpath("//div[normalize-space(text())='India']"));
		India.click();
		login.driver.findElement(By.xpath("(//div[@class='tree-filter-item--open-icon'])[4]")).click();
		
		
	   
	}

	@Given("^select any Subnational=>Banglore as a city=>Apply$")
	public void select_any_Subnational_Banglore_as_a_city_Apply() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement Banglore =login.driver.findElement(By.xpath("(//span[@class='input-control--indicator'])[11]"));
		Banglore.click();
		WebElement Apply_Filter=login.driver.findElement(By.xpath("//div[normalize-space(text())='Apply filter']"));
		Apply_Filter.click();
	  
	}

	@Given("^Move the mouse on selected region=>full path of the region should display\\.$")
	public void move_the_mouse_on_selected_region_full_path_of_the_region_should_display() throws Throwable {
		
	   
	}
	@Given("^user Hovers the mouse on Help Icon\\.$")
	public void user_Hovers_the_mouse_on_Help_Icon() throws Throwable {
		WebElement Help=login.driver.findElement(By.xpath("//div[@title='Help']"));
		new Actions(login.driver).moveToElement(Help).pause(1000).build().perform();
		if(Help.isDisplayed()) {
			System.out.println("Help tooltip is displayed");
		}
		else {
			System.out.println("Help tooltip is not  displayed");
		}
	   
	}

	@Given("^user clicks on open import series popup$")
	public void user_clicks_on_open_import_series_popup() throws Throwable {
		WebElement Import_Series=login.driver.findElement(By.xpath("//button[normalize-space(text())='Import Series']"));
		Import_Series.click();
		
		
		
	   
	}

	@Then("^check Description\\.$")
	public void check_Description() throws Throwable {
		WebElement Import_Header=login.driver.findElement(By.xpath("//div[text()='Import Series']"));
		if(Import_Header.isDisplayed()) {
			System.out.println("Header is displayed");
		}
		else {
			System.out.println("Header is not displayed");
		}
	  
	}
	@Then("^check Note  Description\\.$")
	public void check_Note_Description() throws Throwable {
		WebElement Note=login.driver.findElement(By.xpath("//*[text()='Note']"));
		if(Note.isDisplayed()) {
			System.out.println("Note text is displayed");
		}
		else {
			System.out.println("Note text is not displayed");
			
		}
	}
		@Given("^user import a UDD series\\.$")
	public void user_import_a_UDD_series() throws Throwable {
		/*WebElement Imported_Tab=login.driver.findElement(By.xpath("//span[text()='Imported']"));
		Imported_Tab.click();
		WebElement ImportedSeries1=login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"));
		 action.moveToElement(ImportedSeries1).pause(2000).build().perform();
		 WebElement Remove_Series=login.driver.findElement(By.xpath("//span[@title='Remove series']"));
		 if(Remove_Series.isDisplayed()) {
			 Remove_Series.click();
			 CommonFunctionality.wait(1000);
			 login.driver.findElement(By.xpath("//button[text()='Delete forever']")).click();
			 System.out.println("Remove series button is clicked");
		 }
		 else {
			 System.out.println("Remove series button is not clicked"); 
		 }
		 WebElement ImportedSeries2=login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"));
		 action.moveToElement(ImportedSeries2).pause(2000).build().perform();
		 WebElement Remove_Series1=login.driver.findElement(By.xpath("//span[@title='Remove series']"));
		 if(Remove_Series1.isDisplayed()) {
			 Remove_Series1.click();
			 CommonFunctionality.wait(1000);
			 login.driver.findElement(By.xpath("//button[text()='Delete forever']")).click();
			 System.out.println("Remove series button is clicked");
		 }
		 else {
			 System.out.println("Remove series button is not clicked"); 
		 }
		
*/		WebElement Import_Series=login.driver.findElement(By.xpath("//button[normalize-space(text())='Import Series']"));
		Import_Series.click();
	   
	}
	
	
	@Given("^The series should be imported successfully and should available under Imported tab\\.$")
	public void the_series_should_be_imported_successfully_and_should_available_under_Imported_tab() throws Throwable {
		WebElement Upload_File=login.driver.findElement(By.xpath("//div[text()='Drag a file here']"));
		Upload_File.click();
		CommonFunctionality.wait(2000);
		//System.out.println(System.getProperty("user.dir") + "\\AutoIT\\CEIC defined template.exe");
		CommonFunctionality.uploadTheFileusingAutoIT(login.driver,
				System.getProperty("user.dir") + "\\AutoIT\\CEIC.exe",
				System.getProperty("user.dir") + "\\AutoIT\\CEIC.xlsx");
		Thread.sleep(8000);
		WebElement ImportedSeries3=login.driver.findElement(By.xpath("//div[normalize-space()='Price']"));
		if(ImportedSeries3.isDisplayed()) {
		 action.moveToElement(ImportedSeries3).pause(2000).build().perform();
		 System.out.println("UDD Series are imported in imported tab");
		}
		else {
			System.out.println("UDD Series are not imported in imported tab");
		}
		 WebElement Remove_Series3=login.driver.findElement(By.xpath("//span[@title='Remove series']"));
		 if(Remove_Series3.isDisplayed()) {
			 Remove_Series3.click();
			 CommonFunctionality.wait(1000);
			 login.driver.findElement(By.xpath("//button[text()='Delete forever']")).click();
			 CommonFunctionality.wait(3000);
			 System.out.println("Remove series button is clicked");
		 }
		 else {
			 System.out.println("Remove series button is not clicked"); 
		 }
		 WebElement ImportedSeries4=login.driver.findElement(By.xpath("//div[normalize-space()='Price1']"));
		 if(ImportedSeries4.isDisplayed()) {
			 action.moveToElement(ImportedSeries4).pause(2000).build().perform();
			 System.out.println("UDD Series are imported in imported tab");
			}
			else {
				System.out.println("UDD Series are not imported in imported tab");
			}
		
		 WebElement Remove_Series4=login.driver.findElement(By.xpath("//span[@title='Remove series']"));
		 if(Remove_Series4.isDisplayed()) {
			 Remove_Series4.click();
			 CommonFunctionality.wait(1000);
			 login.driver.findElement(By.xpath("//button[text()='Delete forever']")).click();
			 System.out.println("Remove series button is clicked");
		 }
		 else {
			 System.out.println("Remove series button is not clicked"); 
		 }
	
	   
	}
	@Given("^Import from CDM Next and Import File again\\.$")
	public void import_from_CDM_Next_and_Import_File_again() throws Throwable {
		
		
		
	WebElement Upload_File=login.driver.findElement(By.xpath("//div[text()='Drag a file here']"));
		Upload_File.click();
		CommonFunctionality.wait(2000);
		//System.out.println(System.getProperty("user.dir") + "\\AutoIT\\CEIC defined template.exe");
		CommonFunctionality.uploadTheFileusingAutoIT(login.driver,
				System.getProperty("user.dir") + "\\AutoIT\\CEIC.exe",
				System.getProperty("user.dir") + "\\AutoIT\\CEIC.xlsx");
		Thread.sleep(20000);
		WebElement Import_Series=login.driver.findElement(By.xpath("//button[normalize-space(text())='Import Series']"));
		Import_Series.click();
		WebElement Upload_File1=login.driver.findElement(By.xpath("//div[text()='Drag a file here']"));
		Upload_File1.click();
		CommonFunctionality.wait(2000);
		//System.out.println(System.getProperty("user.dir") + "\\AutoIT\\CEIC defined template.exe");
		CommonFunctionality.uploadTheFileusingAutoIT(login.driver,
				System.getProperty("user.dir") + "\\AutoIT\\CEIC.exe",
				System.getProperty("user.dir") + "\\AutoIT\\CEIC.xlsx");
		Thread.sleep(8000);
		WebElement Data_CantUpload=login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']"));
		if(Data_CantUpload.isDisplayed()) {
			System.out.println("Multiple data cant be uploaded");
		}
		else {
			System.out.println("Multiple data can be uploaded");
		}
	    
	}

	@Given("^check the imported series is displayed on the top of all UDD series\\.$")
	public void check_the_imported_series_is_displayed_on_the_top_of_all_UDD_series() throws Throwable {
		WebElement Upload_File=login.driver.findElement(By.xpath("//div[text()='Drag a file here']"));
		Upload_File.click();
		CommonFunctionality.wait(2000);
		//System.out.println(System.getProperty("user.dir") + "\\AutoIT\\CEIC defined template.exe");
		CommonFunctionality.uploadTheFileusingAutoIT(login.driver,
				System.getProperty("user.dir") + "\\AutoIT\\CEIC.exe",
				System.getProperty("user.dir") + "\\AutoIT\\CEIC.xlsx");
		Thread.sleep(10000);
		WebElement ImportedSeries3=login.driver.findElement(By.xpath("//div[normalize-space()='Price']"));
		 action.moveToElement(ImportedSeries3).pause(3000).build().perform();
		 System.out.println("UDD Series are imported in imported tab");
		 WebElement Remove_Series3=login.driver.findElement(By.xpath("//span[@title='Remove series']"));
		 if(Remove_Series3.isDisplayed()) {
			 Remove_Series3.click();
			 CommonFunctionality.wait(1000);
			 login.driver.findElement(By.xpath("//button[text()='Delete forever']")).click();
			 System.out.println("Remove series button is clicked");
		 }
		 else {
			 System.out.println("Remove series button is not clicked"); 
		 }
		 CommonFunctionality.wait(3000);
		 WebElement ImportedSeries4=login.driver.findElement(By.xpath("//div[normalize-space()='Price1']"));
		 action.moveToElement(ImportedSeries4).pause(2000).build().perform();
		 System.out.println("UDD Series are imported in imported tab");
		 WebElement Remove_Series4=login.driver.findElement(By.xpath("//span[@title='Remove series']"));
		 if(Remove_Series4.isDisplayed()) {
			 Remove_Series4.click();
			 CommonFunctionality.wait(1000);
			 login.driver.findElement(By.xpath("//button[text()='Delete forever']")).click();
			 System.out.println("Remove series button is clicked");
		 }
		 else {
			 System.out.println("Remove series button is not clicked"); 
		 }
		 
	}
	
	@Given("^Download attributes to excel$")
	public void download_attributes_to_excel() throws Throwable {
		WebElement Upload_File=login.driver.findElement(By.xpath("//div[text()='Drag a file here']"));
		Upload_File.click();
		CommonFunctionality.wait(2000);
		//System.out.println(System.getProperty("user.dir") + "\\AutoIT\\CEIC defined template.exe");
		CommonFunctionality.uploadTheFileusingAutoIT(login.driver,
				System.getProperty("user.dir") + "\\AutoIT\\CEIC.exe",
				System.getProperty("user.dir") + "\\AutoIT\\CEIC.xlsx");
		Thread.sleep(10000);
		WebElement Checkbox=login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox']//*[name()='svg']//*[local-name()='use'][1])[1]"));
		 action.moveToElement(Checkbox).pause(2000).click().build().perform();
		CommonFunctionality.wait(2000);
		WebElement Checkbox1=login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[2]"));
		Checkbox1.click();
			CommonFunctionality.wait(3000);	
			WebElement Download=login.driver.findElement(By.xpath("//span[text()='Download']"));
			Download.click();
			CommonFunctionality.wait(2000);
			WebElement Download_Button=login.driver.findElement(By.xpath("//button[@class='sphere-modal-control button insight-download__modal-button button button__download-btn']//span[contains(text(),'Download')]"));
			Download_Button.click();
			WebElement ImportedSeries3=login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"));
			 action.moveToElement(ImportedSeries3).pause(2000).build().perform();
			 System.out.println("UDD Series are imported in imported tab");
			 WebElement Remove_Series3=login.driver.findElement(By.xpath("//span[@title='Remove series']"));
			 if(Remove_Series3.isDisplayed()) {
				 Remove_Series3.click();
				 CommonFunctionality.wait(1000);
				 login.driver.findElement(By.xpath("//button[text()='Delete forever']")).click();
				 System.out.println("Remove series button is clicked");
			 }
			 else {
				 System.out.println("Remove series button is not clicked"); 
			 }
			 WebElement ImportedSeries4=login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"));
			 action.moveToElement(ImportedSeries4).pause(2000).build().perform();
			 System.out.println("UDD Series are imported in imported tab");
			 WebElement Remove_Series4=login.driver.findElement(By.xpath("//span[@title='Remove series']"));
			 if(Remove_Series4.isDisplayed()) {
				 Remove_Series4.click();
				 CommonFunctionality.wait(1000);
				 login.driver.findElement(By.xpath("//button[text()='Delete forever']")).click();
				 System.out.println("Remove series button is clicked");
			 }
			 else {
				 System.out.println("Remove series button is not clicked"); 
			 }
		
			
		}
	
	
	@Given("^Click on any (\\d+) series$")
	public void click_on_any_series(int arg1) throws Throwable {
	   
	}

	@Then("^Both continuous and replacement checkboxes,Manage tab should be displayed in SSP$")
	public void both_continuous_and_replacement_checkboxes_Manage_tab_should_be_displayed_in_SSP() throws Throwable {
	   
	}


@Given("^search UDD Series with attributes like UserId and Category\\.$")
public void search_UDD_Series_with_attributes_like_UserId_and_Category() throws Throwable {
	WebElement Upload_File=login.driver.findElement(By.xpath("//div[text()='Drag a file here']"));
	Upload_File.click();
	CommonFunctionality.wait(2000);
	CommonFunctionality.uploadTheFileusingAutoIT(login.driver,
			System.getProperty("user.dir") + "\\AutoIT\\CEIC.exe",
			System.getProperty("user.dir") + "\\AutoIT\\CEIC.xlsx");
	CommonFunctionality.wait(6000);
	
	WebElement ImportedSeries3=login.driver.findElement(By.xpath("//div[normalize-space()='Price']"));
	//jse. executeScript("arguments[0]. click();", ImportedSeries3);
	action.moveToElement(ImportedSeries3).pause(2000).click().build().perform();
	CommonFunctionality.wait(2000);
	
	 
	 WebElement Category=login.driver.findElement(By.xpath("//div[normalize-space(text())='Category:']"));
	 WebElement Series_Id=login.driver.findElement(By.xpath("//div[contains(text(),'ID:')]"));
	 if(Category.isDisplayed()) {
		 System.out.println("Category is displayed");
	 }
	 else {
		 System.out.println("Category is not displayed");
	 }
	 
	 
	 
	 if(Series_Id.isDisplayed()) {
		 System.out.println("SeriesId is displayed");
	 }
	 else {
		 System.out.println("SeriesId is not displayed");
	 }
	 WebElement Close=login.driver.findElement(By.xpath("//div[@title='Close']"));
	 Close.click();
	 WebElement ImportedSeries1=login.driver.findElement(By.xpath("//div[normalize-space()='Price']"));
	 action.moveToElement(ImportedSeries1).pause(2000).build().perform();
	 WebElement Remove_Series=login.driver.findElement(By.xpath("//span[@title='Remove series']"));
	 if(Remove_Series.isDisplayed()) {
		 Remove_Series.click();
		 CommonFunctionality.wait(1000);
		 login.driver.findElement(By.xpath("//button[text()='Delete forever']")).click();
		 System.out.println("Remove series button is clicked");
	 }
	 else {
		 System.out.println("Remove series button is not clicked"); 
	 }
	 CommonFunctionality.wait(2000);
	 WebElement ImportedSeries2=login.driver.findElement(By.xpath("//div[normalize-space()='Price1']"));
	 action.moveToElement(ImportedSeries2).pause(2000).build().perform();
	 WebElement Remove_Series1=login.driver.findElement(By.xpath("//span[@title='Remove series']"));
	 if(Remove_Series1.isDisplayed()) {
		 Remove_Series1.click();
		 CommonFunctionality.wait(1000);
		 login.driver.findElement(By.xpath("//button[text()='Delete forever']")).click();
		 System.out.println("Remove series button is clicked");
	 }
	 else {
		 System.out.println("Remove series button is not clicked"); 
	 }
	 
	 
	 
	 
	
	
	
}


	@Given("^type some lines with incorrect words\\.$")
	public void type_some_lines_with_incorrect_words() throws Throwable {
		WebElement Commentary_Area=login.driver.findElement(By.xpath("//div[@class='tox-edit-area']/iframe"));
		Commentary_Area.click();
		Commentary_Area.sendKeys("This is not a ceic app");
	    
	}

	@Then("^the  spell checker should be detect incorrect words in the Commentary visual\\.$")
	public void the_spell_checker_should_be_detect_incorrect_words_in_the_Commentary_visual() throws Throwable {
		CommonFunctionality.wait(2000);
		List<WebElement> IncorrectWord=login.driver.findElements(By.xpath("//*[@class='mce-content-body ']//p[contains(text(),'ceic')]"));
		
		if(IncorrectWord.size()==0) {
			System.out.println("Spell checker have detected the incorrect words in commentary visual");
		}
		else {
			System.out.println("Spell checker have not  detected the incorrect words in commentary visual");	
		}
		
		
		
		
	   
	}
	
	@Given("^user Add some series and Table to My Series$")
	public void user_Add_some_series_and_Table_to_My_Series() throws Throwable {
		WebElement ele=login.driver.findElement(By.xpath("//span[@value='LIST']"));
		jse. executeScript("arguments[0]. click();", ele);
		//List<WebElement> list = login.driver.findElements(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']"));
		
		for (int i = 1; i <= 2; i++) {

			login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]"))
					.click();
		}
		
		/*for (int i=1; i<=2; i++) {
			List<WebElement> list =	login.driver.findElements(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])["+i+"]"));
			
			WebElement list1=list.get(i);
			System.out.println(list1.getSize());
			list1.click();
			
		*/	
			//WebElement First_Series = login.driver.findElement(By.xpath("(//div[@class='series-list-item--information'])[1]"));
			//action.moveToElement(First_Series).pause(2000).build().perform();
			
			WebElement Add_group=login.driver.findElement(By.xpath("(//div[@class='add-to-data-selection--icon'])[1]"));
			action.moveToElement(Add_group).pause(2000).build().perform();
			login.driver.findElement(By.xpath("(//div[@class='add-to-data-selection--icon']/following::div[@class='add-to-data-selection--toggle'])[1]")).click();;
			//Add_group.click();
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath("//span[text()='Add and group']")).click();
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath("//div[@class='webix_tree_close']")).click();
			
			
		}
		
	    
	

	@Given("^Expand Table$")
	public void expand_Table() throws Throwable {
		for (int i = 1; i <= 2; i++) {

			login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]"))
					.click();
			
		}
		WebElement Serieslist = login.driver.findElement(
				By.xpath("//div[@class='series-list-item-data']/div[@class='series-list-item--information'][1]"));
		new Actions(login.driver).moveToElement(Serieslist).pause(3000).build().perform();
	    WebElement ele1 = login.driver.findElement(By.xpath("//div[@class='series-list-item--action-icons']/span[@title='More actions']//*[name()='svg']//*[local-name()='use'][1]"));
		CommonFunctionality.action.moveToElement(ele1).pause(2).click().build().perform();
		CommonFunctionality.wait(2000);
		 WebElement View_Table=login.driver.findElement(By.xpath("//span[normalize-space()='Add chart']"));
		 action.moveToElement(View_Table).pause(2000).build().perform();
		 login.driver.findElement(By.xpath("//div[contains(@class,'icon--table-vertical_large')]")).click();
	   
	}

	@Then("^switch to view and come back to my series=>changes shouuld be preserved\\.$")
	public void switch_to_view_and_come_back_to_my_series_changes_shouuld_be_preserved() throws Throwable {
		WebElement My_Series=login.driver.findElement(By.xpath("//a[normalize-space(text())='My Series']"));
		My_Series.click();
		WebElement Preserved=login.driver.findElement(By.xpath("//div[@class='webix_tree_open']"));
		if(Preserved.isDisplayed()) {
			System.out.println("It is in preserved state");
		}
		else {
			System.out.println("It is not in preserved state");
		}
	}

	
	
	@Given("^user clicks on Open Region filter\\.$")
	public void user_clicks_on_Open_Region_filter() throws Throwable {
		WebElement Region=login.driver.findElement(By.xpath("//span[text()='All Regions']"));
		Region.click();
		Thread.sleep(6000);
		login.driver.findElement(By.xpath("//div[text()='India']")).click();
		WebElement Search_Panel=login.driver.findElement(By.xpath("//input[@placeholder='Search...']"));
		Search_Panel.click();
		Search_Panel.sendKeys("bang");
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("(//div[normalize-space(text())='Cities/Towns']/following::div[@class='tree-filter-list']/following::span[normalize-space(text())='Karnataka']/preceding::div[@class='tree-filter-item--open-icon'])[11]")).click();
		CommonFunctionality.wait(2000);
		//login.driver.findElement(By.xpath("(//div[normalize-space(text())='Cities/Towns']/following::div[@class='tree-filter-list']/following::span[normalize-space(text())='Bengaluru Urban']/preceding::div[@class='tree-filter-item--open-icon'])[12]")).click();
		//CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//span[@title='Bangalore']//span[@class='text-dots']")).click();
		
				
	    
	}
	
	@Given("^user Navigates to Analysis Tab\\.$")
	public void user_Navigates_to_Analysis_Tab() throws Throwable {
		WebElement Analysis=login.driver.findElement(By.xpath("//span[normalize-space(text())='Analysis']"));
		Analysis.click();    
	}
	

	
	

	@Given("^Open any Insight having series$")
	public void open_any_Insight_having_series() throws Throwable {
		
		WebElement Image=login.driver.findElement(By.xpath("(//div[@class='insight-grid-item--thumbnail'])[1]"));
		 action.moveToElement(Image).pause(2000).build().perform();
		
		
		WebElement View =login.driver.findElement(By.xpath("(//*[@class='insight-grid-item--buttons-item button'])[1]"));
		 action.moveToElement(View).pause(2000).click().build().perform();
		 CommonFunctionality.wait(2000);
		 WebElement Series=login.driver.findElement(By.xpath("//a[normalize-space()='Series']"));
		 Series.click();
	   
	}

	@Given("^copy SR code=>Search Insight with SR code$")
	public void copy_SR_code_Search_Insight_with_SR_code() throws Throwable {
		//WebElement Search_Series=login.driver.findElement(By.xpath("//div[@class='list-view-wrapper']//input[@placeholder='Filter by name, region, unit, frequency']"));
		
		WebElement Search_Series=login.driver.findElement(By.xpath("//div[@class='insight-data']//input[@placeholder='Search']"));
		Search_Series.click();
		Search_Series.sendKeys("SR6795379",Keys.ENTER);
		WebElement SR_code=login.driver.findElement(By.xpath("//span[@class='series-name-field--text']"));
		if(SR_code.isDisplayed()) {
			System.out.println("SR code is displayed");
		}
		else {
			System.out.println("SR code is not  displayed");
		}
		WebElement Close=login.driver.findElement(By.xpath("//div[@class='insight-preview--close']"));
		Close.click();
		CommonFunctionality.wait(3000);
		WebElement Search_Panel=login.driver.findElement(By.xpath("//input[@placeholder='Search']"));
		Search_Panel.click();
		Search_Panel.sendKeys("SR6795379",Keys.ENTER);
		CommonFunctionality.wait(2000);
		
		WebElement Image=login.driver.findElement(By.xpath("(//div[@class='insight-grid-item--thumbnail'])[1]"));
		 action.moveToElement(Image).pause(2000).build().perform();
		
		
		WebElement View =login.driver.findElement(By.xpath("(//*[@class='insight-grid-item--buttons-item button'])[1]"));
		 action.moveToElement(View).pause(2000).click().build().perform();
		 CommonFunctionality.wait(2000);
		 WebElement Series=login.driver.findElement(By.xpath("//a[normalize-space()='Series']"));
		 Series.click();
		
		// WebElement Search_Series1=login.driver.findElement(By.xpath("//div[@class='list-view-wrapper']//input[@placeholder='Filter by name, region, unit, frequency']"));
			
		 WebElement Search_Series1=login.driver.findElement(By.xpath("//div[@class='insight-data']//input[@placeholder='Search']"));
		 
		 Search_Series1.click();
			Search_Series1.clear();
			CommonFunctionality.wait(3000);
			Search_Series1.sendKeys("SR6795379",Keys.ENTER);
			
			WebElement SR_code1=login.driver.findElement(By.xpath("//span[@class='series-name-field--text']"));
			if(SR_code1.isDisplayed()) {
				System.out.println("SR code is displayed on search insight");
			}
			else {
				System.out.println("SR code is not  displayed on search insight");
			}
	    
	}

	
	@And("^create a visual \\.$")
	public void create_a_visual() throws Throwable {
		login.driver.findElement(By.xpath("//*[@class='series-list-item--checkbox svg-checkbox']")).click();
		//WebElement First_Series = login.driver.findElement(By.xpath("(//div[@class='series-list-item--information'])[1]"));
		WebElement First_Series = login.driver.findElement(By.xpath("(//div[@class='series-list-item-data'])[1]"));
		action.moveToElement(First_Series).pause(2000).build().perform();
		
		WebElement More_Actions=login.driver.findElement(By.xpath("//span[@title='More actions']"));
		 jse. executeScript("arguments[0]. click();", More_Actions);
		 WebElement View_Table=login.driver.findElement(By.xpath("//span[normalize-space()='Add chart']"));
		 action.moveToElement(View_Table).pause(2000).build().perform();
		 login.driver.findElement(By.xpath("//div[contains(@class,'icon--table-vertical_large')]")).click();
		 
	    
	}

	@Then("^check for On Demand Status\\.$")
	public void check_for_On_Demand_Status() throws Throwable {
		WebElement Series_title=login.driver.findElement(By.xpath("//span[@class='series-edit--title']"));
		Series_title.click();
		CommonFunctionality.wait(2000);
		WebElement On_Demand=login.driver.findElement(By.xpath("(//div[normalize-space(text())='On Demand'])[2]"));
		if(On_Demand.isDisplayed()) {
			System.out.println("On Demand status is displayed");
		}
		else {
			System.out.println("On Demand status is not displayed");
		}
	}

	
	

	@Given("^select Subnational=>Banglore as a city$")
	public void select_Subnational_Banglore_as_a_city() throws Throwable {
		WebElement ApplyFilter=login.driver.findElement(By.xpath("//div[normalize-space(text())='Apply filter']"));
		ApplyFilter.click();
	   
	}

	@Given("^hover the mouse on the selected Region=>full path should display\\.$")
	public void hover_the_mouse_on_the_selected_Region_full_path_should_display() throws Throwable {
	   CommonFunctionality.wait(2000);
	   WebElement Full_Path =login.driver.findElement(By.xpath("//span[text()='Bangalore']"));
	   new Actions(login.driver).moveToElement(Full_Path).pause(3000).build().perform();
	   WebElement Tootltip=login.driver.findElement(By.xpath("//div[@class='tooltip tooltip__visible']"));
	   if(Tootltip.isDisplayed()) {
		   System.out.println("Full Path of the region is displayed");
	   }
	   else {
		   System.out.println("Full Path of the region is not displayed"); 
	   }
	   
	}

	
	
	
	
	
	
	@Given("^user creates multiple visuals in single views\\.$")
	public void user_creates_multiple_visuals_in_single_views() throws Throwable {
		login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[1]")).click();
		
		
		WebElement More_Actions=login.driver.findElement(By.xpath("//span[@title='More actions']"));
		 jse. executeScript("arguments[0]. click();", More_Actions);
		 WebElement Add_Chart=login.driver.findElement(By.xpath("//span[@title='Add chart']"));
		 action.moveToElement(Add_Chart).pause(2000).build().perform();
		 login.driver.findElement(By.xpath("//div[contains(@class,'icon--table-vertical_large')]")).click();
		 CommonFunctionality.wait(3000);
		 WebElement Visual_Title=login.driver.findElement(By.xpath("//div[@class='visual-title--group']//span[@class='visual-title--text text-dots']"));
		 Visual_Title.click();
		 login.driver.findElement(By.xpath("(//span[@class='input-control--indicator'])[1]")).click();
		 login.driver.findElement(By.xpath("//div[@class='popover--close']")).click();
		 
		/*CommonFunctionality.wait(2000);
		WebElement Add_chart=login.driver.findElement(By.xpath("//div[contains(text(),'Add chart')]"));
		Add_chart.click();
		login.driver.findElement(By.xpath("//div[@class='icon--table-vertical_large public-js-views-visuals-VisualsPanelSubItem-module__subItemIcon']")).click();*/
		
		CommonFunctionality.wait(2000);
login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[2]")).click();
		
		
		WebElement More_Actions1=login.driver.findElement(By.xpath("//span[@title='More actions']"));
		 jse. executeScript("arguments[0]. click();", More_Actions1);
		 WebElement Add_Chart1=login.driver.findElement(By.xpath("//span[@title='Add chart']"));
		 action.moveToElement(Add_Chart1).pause(2000).build().perform();
		 login.driver.findElement(By.xpath("//div[contains(@class,'icon--table-vertical_large')]")).click();
		 CommonFunctionality.wait(3000);
		 WebElement Visual_Title1=login.driver.findElement(By.xpath("(//div[@class='visual-title--group']//span[@class='visual-title--text text-dots'])[1]"));
		 Visual_Title1.click();
		 login.driver.findElement(By.xpath("(//span[@class='input-control--indicator'])[1]")).click();
		 login.driver.findElement(By.xpath("//div[@class='popover--close']")).click();
		
	  
	}

	

	@Then("^should be able to move the visual\\.$")
	public void should_be_able_to_move_the_visual() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement Hover=login.driver.findElement(By.xpath("(//div[@class='visual-title ui-draggable ui-draggable-handle visual-drag__cursor'])[2]"));
		 action.moveToElement(Hover).pause(2000).build().perform();
		 WebElement source = login.driver.findElement(By.xpath("(//div[@class='visual-title--move visual-title--icon'])[2]"));
			// action.moveToElement(source).pause(2000).doubleClick().build().perform();
			 WebElement target = login.driver.findElement(By.xpath("//div[@class='new-visual-panel insight-action-panel']"));
				CommonFunctionality.wait(2000);
				new Actions(login.driver).moveToElement(source).pause(2000).dragAndDrop(source, target).clickAndHold().build().perform();	
				CommonFunctionality.wait(5000);
		WebElement Visual2=login.driver.findElement(By.xpath("(//div[@class='insight-visual-container insight-visual-container__column-2'])[2]"));
		if(Visual2.isDisplayed()) {
			System.out.println("visual is moved");
		}
		else {
			System.out.println("visual is not moved");
		}
	}
	@Given("^user creates a visual with some series\\.$")
	public void user_creates_a_visual_with_some_series() throws Throwable {
		WebElement ele=login.driver.findElement(By.xpath("//span[@value='LIST']"));
		jse. executeScript("arguments[0]. click();", ele);
		List<WebElement> list = login.driver.findElements(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']"));
		CommonFunctionality.wait(2000);
		for (int i=0; i<2; i++) {
			CommonFunctionality.wait(2000);
			list.get(i).click();
			CommonFunctionality.wait(2000);	
		}
		
	    
	}

	@Given("^user Add this series into right pane: (\\d+)$")
	public void user_Add_this_series_into_right_pane(int arg1) throws Throwable {
		
		 
		WebElement Search=login.driver.findElement(By.xpath("//input[@placeholder='Search']"));
		Search.click();
		Search.clear();
		Search.sendKeys(Integer.toString(arg1),Keys.ENTER);
		try {
			WebElement Start_New=login.driver.findElement(By.xpath("//button[text()='Start new']"));
			Start_New.click();
		}
		catch(Exception e) {
			System.out.println("pop up not appeared");
		}
		CommonFunctionality.wait(2000);
		CommonFunctionality.wait(5000);
		
		//need to uncomment
		/*login.driver.findElement(By.xpath("//*[contains(@class,'series-list-item series-list-item--container')]//*[@class='series-list-item--checkbox svg-checkbox']")).click();
		login.driver.findElement(By.xpath("//*[contains(@class,'series-list-item series-list-item--container')]//div[@class='add-to-data-selection--icon']")).click();
	     CommonFunctionality.wait(3000);
	     login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
	     CommonFunctionality.wait(3000);
		openFunctionEditor();
		selectFunctionInFunctionEditor("AGGREGATE");
		selectArgumetsInFunctionsEditor("Yearly", "1");
		selectArgumetsInFunctionsEditor("December", "2");
        selectArgumetsInFunctionsEditor("Sum", "3");
        insertFunctionInFunctionREditor();
        setApplyFunctionOptions();
        
        
        CommonFunctionality.wait(3000);
	     login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
	     
	     login.driver.findElement(By.xpath("//button[@class='drop-down-button--btn download-button--button button button__download-btn']")).click();
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath("(//span[normalize-space(text())='Download'])[2]")).click();
	*/		
		    
	}
    public String getTitleOfInsight() {
        return login.driver.findElement(By.cssSelector("[js-insight-title]")).getText();
    }
	
	
	  public static Workbook readExcel(String fileName) {
		  
		  String DOWNLOAD_DEFAULT_LOCAL_DIRECTORY =  "";
		   
		  
	        Workbook workbookResult = null;
	        try {
	        	System.out.println(DOWNLOAD_DEFAULT_LOCAL_DIRECTORY + "/" + fileName);
	         FileInputStream fileInputStream = new FileInputStream(new File(DOWNLOAD_DEFAULT_LOCAL_DIRECTORY + "/" + fileName));
	            workbookResult = WorkbookFactory.create(fileInputStream);
	        } catch (IOException e) {
	            System.out.println("IOException");
	        } catch (InvalidFormatException e) {
	            System.out.println("InvalidFormatException");
	        }
	        return workbookResult;
	    }
	  
public static Workbook readExcel(String fileName,String path) {
		  
	        Workbook workbookResult = null;
	        try {
	        	System.out.println(path);
	        	System.out.println(fileName);
	        	System.out.println(path + "/" + fileName);
	         FileInputStream fileInputStream = new FileInputStream(new File(path + "/" + fileName));
	            workbookResult = WorkbookFactory.create(fileInputStream);
	        } catch (IOException e) {
	            System.out.println("IOException");
	        } catch (InvalidFormatException e) {
	            System.out.println("InvalidFormatException");
	        }
	        return workbookResult;
	    }
	  public int getCountAttributesExcelFile(String nameFile,String path) {
	        String name = nameFile + ".xlsx";
	        Workbook workbookResult = readExcel(name,path);
	        // int j = count < 10 ? count : 10;
	        int countAttributes = 0;
	        int numberOfRows = workbookResult.getSheetAt(0).getPhysicalNumberOfRows();
	        // int numberTimepoints = getCountAttributesExcelFile(nameFile);

	        for (int i = 0; i < numberOfRows; i++) {
	            XSSFCell row = (XSSFCell) workbookResult.getSheetAt(0).getRow(i).getCell(0);
	            if (row.getCellType() != XSSFCell.CELL_TYPE_STRING) {
	                continue;
	            } else {
	                countAttributes++;
	            }
	        }
	        return countAttributes;
	    }
	  public ArrayList<String> getTimePointToExcel(Integer numberOfCell, String path,String nameFile) {
		
	        int count;
	        int key = 0;
	        String name = nameFile + ".xlsx";
	        Workbook workbookResult = readExcel(name,path);
	        ArrayList<String> array = new ArrayList<String>();
	      
	        int numberOfRows = workbookResult.getSheetAt(0).getPhysicalNumberOfRows();
	        System.out.println("=no of rows=="+numberOfRows);
	        int numberAttributes = getCountAttributesExcelFile(nameFile,path);
	        System.out.println("====Attributes=="+numberAttributes);
	        count = numberOfRows - numberAttributes;

	        numberAttributes = numberAttributes + 1;

	        for (int i = numberOfRows-1 ; i >= numberAttributes; i--) {
	            System.out.println("i varibale" + i);
	            if (count == 0) {
	                break;
	            }
	            XSSFCell row = (XSSFCell) workbookResult.getSheetAt(0).getRow(i).getCell(numberOfCell);
	           
	            if (row != null) {
	                if (row.getCellType() != XSSFCell.CELL_TYPE_NUMERIC) {
	                    continue;
	                }

	                Double s = workbookResult.getSheetAt(0).getRow(i).getCell(numberOfCell).getNumericCellValue();
	                if (s < 0) {
	                    key = 1;
	                }
	                if (i == 1300) {
	                    double test = workbookResult.getSheetAt(0).getRow(i).getCell(numberOfCell).getNumericCellValue();
	                }

	         

	                
	                s = Math.abs(s);
	                String numberString = String.format("%.4f", s);
	                numberString = numberString.replace(',', '.');
	                s = Double.parseDouble(numberString);
	           

	                double stest = BigDecimal.valueOf(s).setScale(3, BigDecimal.ROUND_HALF_DOWN).doubleValue();
	                String s2 = String.valueOf(stest);
	                array.add(s2);


	     
	                count--;


	            }
	        }
	        System.out.println(array);
	        return array;
	    }
	  
	  
	  public ArrayList<String> getTimePointToExcel1(Integer numberOfCell, String path,String nameFile) {  
		  int count;
	        int key = 0;
	        String name = nameFile + ".xlsx";
	        Workbook workbookResult = readExcel(name,path);
	      //  Workbook workbookResult = ExcelTool.readExcelCDM(name);
	        ArrayList<String> array = new ArrayList<String>();
	        //int j = count < 10 ? count : 10;
	        // count = 10 + count;
	        int numberOfRows = workbookResult.getSheetAt(0).getPhysicalNumberOfRows();
	        int numberAttributes = getCountAttributesExcelFile(nameFile,path);
	      //  int numberAttributes = getCountAttributesExcelFileCDM(nameFile);
	        count = numberOfRows - numberAttributes;
	        // int numberOfRows = workbookResult.getSheetAt(0).getPhysicalNumberOfRows();

	        for (int i = numberOfRows - 1; i >= numberAttributes; i--) {
	            if (count == 0) {
	                break;
	            }
	            XSSFCell row = (XSSFCell) workbookResult.getSheetAt(0).getRow(i).getCell(numberOfCell);
	            if (row.getCellType() != XSSFCell.CELL_TYPE_NUMERIC) {
	                continue;
	            }
	            Double s = workbookResult.getSheetAt(0).getRow(i).getCell(numberOfCell).getNumericCellValue();
	            if (s < 0) {
	                key = 1;
	            }
	            if (i == 1300) {
	                double test = workbookResult.getSheetAt(0).getRow(i).getCell(numberOfCell).getNumericCellValue();
	            }

	            s = Math.abs(s);
	            String numberString = String.format("%.4f", s);
	            numberString = numberString.replace(',', '.');
	            s = Double.parseDouble(numberString);
	            double stest = BigDecimal.valueOf(s).setScale(3, BigDecimal.ROUND_HALF_DOWN).doubleValue();
	            String s2 = String.valueOf(stest);
	            array.add(s2);
	            count--;


	        }
	        System.out.println(array);
	        return array;
		  
		  
		  
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	
	 public void openFunctionEditor() {
	      CommonFunctionality.wait(1000);
	        By functionEditor = By.cssSelector("[js-open-function-editor]");
	        openEditSeriesPanel();
	        CommonFunctionality.wait(3000);
			
	       // WebElement ele1=login.driver.findElement(functionEditor);
	     //   jse.executeScript("arguments[0].click();", ele1);
	       login.driver.findElement(functionEditor).click();
	       CommonFunctionality.wait(1000);
	/*        findElementClick(By.cssSelector(".insert-function-button"));
	        timeout(1000);*/
	    }
	 
	 public void openEditSeriesPanel() {
	        if (login.driver.findElement(By.cssSelector(".fx-panel-toggle__is-open")).isDisplayed()==true)
	        {
	        	CommonFunctionality.wait(1000);
	        } else {
	        	CommonFunctionality.wait(1000);
	            login.driver.findElement(By.xpath("//*[@class='visual-top-panel']/*/button[contains(text(),'Edit Series')]"));
	            CommonFunctionality.wait(1000);
	        }
	    }
	 
	 
	 
	   public void selectFunctionInFunctionEditor(String dataIdFunction) {
	        String dataID = "$(\"div[data-id='" + dataIdFunction + "']\").mouseover().click()";

	        ((JavascriptExecutor) login.driver).executeScript(dataID);
	        CommonFunctionality.wait(2000);
	    }
	   
	   
	   public void selectArgumetsInFunctionsEditor(String argument, String numberOfArgument) {
	        String setArgument = "$(\"[js-regular-parameters]>div:nth-child(" + numberOfArgument + ") .select2-container.function-parameter--select a\").trigger('mousedown')";
	       
	        System.out.println("arguement is"+setArgument);
	        ((JavascriptExecutor) login.driver).executeScript(setArgument);
	      
	        String serie = "$(\"#select2-drop .select2-results div:contains('" + argument + "')\").mouseup()";
	        System.out.println("the series is "+serie);
	        ((JavascriptExecutor) login.driver).executeScript(serie);
	        CommonFunctionality.wait(2000);
	    }
	   
	   
	   public void insertFunctionInFunctionREditor() {
		   CommonFunctionality.wait(2000);
	   
	     WebElement ele= login.driver.findElement(By.xpath("//button[@class='button button__secondary_purple']"));
	        JavascriptExecutor executor = (JavascriptExecutor)login.driver; executor. executeScript("arguments[0]. click();", ele);
	        CommonFunctionality.wait(2000);
	    }
	   public void setApplyFunctionOptions() {
	        
	        login.driver.findElement(By.cssSelector("[js-apply-functions]")).click();
	        checkSphereLoading();
	    }
	   
	   
	   public void checkSphereLoading() {
	        int count = 0, i = 0;
	        do{
	            count = getCountElement(By.cssSelector(".loader-spinner"));
	            CommonFunctionality.wait(2000);
	            i += 100;
	        }while(count != 0 && i <= 5000);
	    }
	   
	    public int getCountElement(By element) {
	        try {
	            List<WebElement> list = login.driver.findElements(element);
	            return list.size();
	        } catch (AssertionFailedError e) {
	            return 0;
	        }
	    }
	    

	/*@Given("^Apply Aggregate Sum, yearly, december$")
	public void apply_Aggregate_Sum_yearly_december() throws Throwable {
	   
	}*/

	/*@Then("^Download base and transformed series into excel$")
	public void download_base_and_transformed_series_into_excel() throws Throwable {
	    
	}*/

	
	
	
	
	
	
	@Given("^open edit visual=>EditSeries Panel\\.$")
	public void open_edit_visual_EditSeries_Panel() throws Throwable {
		WebElement First_Series = login.driver.findElement(By.xpath("(//div[@class='series-list-item--information'])[1]"));
		action.moveToElement(First_Series).pause(2000).build().perform();
		
		WebElement More_Actions=login.driver.findElement(By.xpath("//span[@title='More actions']"));
		 jse. executeScript("arguments[0]. click();", More_Actions);
		 WebElement Add_Chart=login.driver.findElement(By.xpath("//span[@title='Add chart']"));
		 action.moveToElement(Add_Chart).pause(2000).build().perform();
		 login.driver.findElement(By.xpath("//div[@class='public-js-views-visuals-VisualsPanelSubItem-module__subItemTitle'][normalize-space()='Line']")).click();
		/* WebElement Add_Chart=login.driver.findElement(By.xpath("//span[@title='Add chart']"));
		 action.moveToElement(Add_Chart).pause(2000).build().perform();
		 login.driver.findElement(By.xpath("//div[@class='icon--table-vertical_large public-js-views-visuals-VisualsPanelSubItem-module__subItemIcon']")).click();
		 WebElement Edit_Table=login.driver.findElement(By.xpath("//button[normalize-space(text())='Edit Table']"));
		 Edit_Table.click();*/
		 
	    
	}
	
	@Given("^user opens fx window\\.$")
	public void user_opens_fx_window() throws Throwable {
		WebElement Search=login.driver.findElement(By.xpath("//input[@placeholder='Search']"));
		Search.click();
		Search.clear();
		Search.sendKeys("3675901",Keys.ENTER);
		try {
			WebElement Start_New=login.driver.findElement(By.xpath("//button[text()='Start new']"));
			Start_New.click();
		}
		catch(Exception e) {
			System.out.println("pop up not appeared");
		}
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//*[contains(@class,'series-list-item series-list-item--container')]//*[@class='series-list-item--checkbox svg-checkbox']")).click();
		login.driver.findElement(By.xpath("//*[contains(@class,'series-list-item series-list-item--container')]//div[@class='add-to-data-selection--icon']")).click();
	     CommonFunctionality.wait(3000);
	     login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
	     CommonFunctionality.wait(2000);
	     login.driver.findElement(By.xpath("//div[@title='Open function editor (F). Investigate all available functions in the function editor window.']")).click();
	     
	     
	    
	}

	@Given("^Navigate to Aggregate function$")
	public void navigate_to_Aggregate_function() throws Throwable {
		Thread.sleep(3000);
		Thread.sleep(4000);
		
		login.driver.findElement(By.xpath("//div[@data-id='AGGREGATE']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//button[normalize-space()='Insert function']")).click();
		login.driver.findElement(By.xpath("(//span[@class='input-control--indicator'])[2]")).click();
		login.driver.findElement(By.xpath("//button[normalize-space()='Apply']")).click();
		
	    
	}

	@Then("^verify the content\\.$")
	public void verify_the_content() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("(//span[@class='series-name-field--text'])[2]")).click();
		login.driver.findElement(By.xpath("//div[normalize-space()='Data']")).click();
		List<String> values=new ArrayList<String>();
		List<WebElement> Data=login.driver.findElements(By.xpath("//div[@class='preview-series-time-points--container']"));
		for(WebElement Data1: Data) {
			String text1=Data1.getText();
			System.out.println(text1);
			values.add(text1);	
			
			Boolean boo=values.contains(2022);
			if(boo==true) {
				
				   login.Log4j.info("2022 date is displayed");
				   
			}
			else {
				login.Log4j.info("2022 date is not displayed");
			}
		}
		
		
	
	   
	}

	
	
	
	
	
	
	

	@Given("^Drag and Drop Series\\.$")
	public void drag_and_Drop_Series() throws Throwable {
		CommonFunctionality.wait(2000);
		//WebElement Hover=login.driver.findElement(By.xpath("(//div[@class='table--cell table--body-cell visual-series-list--series-row'])[15]"));
		 //action.moveToElement(Hover).pause(2000).build().perform();
		// WebElement source = login.driver.findElement(By.xpath("//div[@class='table']//table/div[3]/div[1]/div"));
		 WebElement source = login.driver.findElement(By.xpath("(//div[@class='series-name'])[2]"));
		 
		 action.moveToElement(source).build().perform();
		 WebElement target = login.driver.findElement(By.xpath("(//div[@class='series-name'])[1]"));
		
		// WebElement target = login.driver.findElement(By.xpath("(//div[@class='series-name--title'])[1]"));
		// WebElement target = login.driver.findElement(By.xpath("(//div[@class='visual-series-name'])[3]"));
		 
			Thread.sleep(5000);
			action.dragAndDrop(source, target).build().perform();
			//new Actions(login.driver).moveToElement(source).pause(2000).dragAndDrop(source, target).build().perform();	
			CommonFunctionality.wait(5000);
			System.out.println("skhkj");
			if(login.driver.findElement(By.xpath("(//div[@class='series-name'])[1]")).getText().equalsIgnoreCase("Consumer Price Index")) {
				System.out.println("pass");
			}
			else {
				fail("Test case fail");
			}
	}
	
	@Given("^open edit Series$")
	public void open_edit_Series() throws Throwable {
		WebElement First_Series = login.driver.findElement(By.xpath("(//div[@class='series-list-item--information'])[1]"));
		action.moveToElement(First_Series).pause(2000).build().perform();
		
		WebElement More_Actions=login.driver.findElement(By.xpath("//span[@title='More actions']"));
		 jse. executeScript("arguments[0]. click();", More_Actions);
		 WebElement Add_Chart=login.driver.findElement(By.xpath("//span[@title='Add chart']"));
		 action.moveToElement(Add_Chart).pause(2000).build().perform();
		 login.driver.findElement(By.xpath("//div[@class='public-js-views-visuals-VisualsPanelSubItem-module__subItemTitle'][normalize-space()='Line']")).click();
		 CommonFunctionality.wait(2000);
		 WebElement Edit_Series=login.driver.findElement(By.xpath("//button[text()='Edit Series']"));
		 Edit_Series.click();
		 
	    
	}


	@Then("^series should be placed where drag and droped\\.$")
	public void series_should_be_placed_where_drag_and_droped() throws Throwable {
	   
	}

	@Given("^user selects imported tab$")
	public void user_selects_imported_tab() throws Throwable {
		WebElement Imported=login.driver.findElement(By.xpath("//span[text()='Imported']"));
		Imported.click();
	   
	}

	@Given("^check whether filters are disabled\\.$")
	public void check_whether_filters_are_disabled() throws Throwable {
		WebElement Indicator=login.driver.findElement(By.xpath("//div[@data-id='indicator']"));
		WebElement Source=login.driver.findElement(By.xpath("//div[@data-id='source']"));
		WebElement Status=login.driver.findElement(By.xpath("//div[@data-id='status']"));
		if(Indicator.isDisplayed()) {
			System.out.println("Indicator is hidden");
		}
		else {
			System.out.println("Indicator is not hidden");
		}
		if(Source.isDisplayed()) {
			System.out.println("Source is hidden");
		}
		else {
			System.out.println("Source is not hidden");
		}
		if(Status.isDisplayed()) {
			System.out.println("Status is hidden");
		}
		else {
			System.out.println("Status is not hidden");
		}
		
	    
	}
	@Given("^check whether filters are enabled\\.$")
	public void check_whether_filters_are_enabled() throws Throwable {
		WebElement Region=login.driver.findElement(By.xpath("//span[normalize-space(text())='All Regions']"));
		WebElement Frequency=login.driver.findElement(By.xpath("//span[normalize-space(text())='Frequency']"));
		WebElement More=login.driver.findElement(By.xpath("//span[normalize-space(text())='More']"));
		More.click();
		CommonFunctionality.wait(2000);
		WebElement Unit=login.driver.findElement(By.xpath("//div[normalize-space(text())='Unit']"));
		if(Region.isDisplayed()) {
			System.out.println("Region is enabled");
		}
		else {
			System.out.println("Region is not enabled");
		}
		if(Frequency.isDisplayed()) {
			System.out.println("Frequency is enabled");
		}
		else {
			System.out.println("Frequency is not enabled");
		}
		if(Unit.isDisplayed()) {
			System.out.println("Unit is enabled");
		}
		else {
			System.out.println("Unit is not enabled");
		}
		
		
	    
	}
	@Given("^click on Hyperlink CEIC Data Template\\.$")
	public void click_on_Hyperlink_CEIC_Data_Template() throws Throwable {
		WebElement CEIC_DataTemplate=login.driver.findElement(By.xpath("//a[normalize-space()='CEIC defined template']"));
		CEIC_DataTemplate.click();
		//CommonFunctionality.Download_to_Excel("CEIC defined template",1,1,"Series Name");
		//CommonFunctionality.DownloadFileVerify();
		CommonFunctionality.wait(1000);
		System.out.println(System.getProperty("user.home") + "\\Downloads\\" + "CEIC defined template" + ".xlsx");
		String path = System.getProperty("user.home") + "\\Downloads\\" + "CEIC defined template" + ".xlsx";
		File src = new File(path);
		System.out.println(src.exists());
		if(src.exists()) {
			
			System.out.println("");
		}
		else {
			
		}
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		System.out.println(sheet1.getSheetName());
		
	   
	}
	
	
	RecentDownloads recent=new RecentDownloads();
	Actions a=new Actions(login.driver);
	@And("^Search for series with id \"([^\"]*)\"$")
	public void search_for_series_with_id(String arg1) throws Throwable {
	   login.driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(arg1,Keys.ENTER);
	   Thread.sleep(3000);
	}

	@And("^Click on More actions and Series Info$")
	public void click_on_More_actions_and_Series_Info() throws Throwable {
	    login.driver.findElement(By.xpath("//span[@value='LIST']")).click();
	  // a.contextClick().build().perform();
	    WebElement FirstSeries=login.driver.findElement(By.xpath("(//div[@class='series-list-item-data'])[1]"));
		new Actions(login.driver).moveToElement(FirstSeries).pause(1000).build().perform();
	    WebElement ele1 = login.driver.findElement(By.xpath("//div[@class='series-list-item--action-icons']/span[@title='More actions']//*[name()='svg']//*[local-name()='use'][1]"));
		CommonFunctionality.action.moveToElement(ele1).pause(2).click().build().perform();
	   login.driver.findElement(By.xpath("//*[contains(text(),'Series Info')]")).click();
	   Thread.sleep(2000);
	   
	   
	}

	@Then("^Click on Statistics tab$")
	public void click_on_Statistics_tab() throws Throwable {
       login.driver.switchTo().activeElement();
       login.driver.findElement(By.xpath("//*[contains(text(),'Statistics')]")).click();
       List<WebElement> date=login.driver.findElements(By.xpath("//div[@class='series-changes-time-line--date']"));
       for(WebElement dateoverlapped:date)
       {
    	  
    		   Assert.assertEquals(dateoverlapped.isDisplayed(),true);
    	  System.out.println( dateoverlapped.getText().toString());
           
	   }
	}
	@Given("^Select (\\d+) series id$")
	public void select_series_id(int arg1) throws Throwable {
		 Thread.sleep(3000);
		 login.driver.findElement(By.xpath("//span[@value='LIST']")).click();
		 List<WebElement> series=login.driver.findElements(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']"));
		 for(int i=1;i<=arg1;i++)
		 {
			 login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])["+i+"]")).click();
		 }
	}

	@Given("^Right click and click on View as Chart$")
	public void right_click_and_click_on_View_as_Chart() throws Throwable {
		
		 a.contextClick().build().perform();
		 WebElement View_Chart=login.driver.findElement(By.xpath("//span[normalize-space()='Add chart']"));
		 action.moveToElement(View_Chart).pause(2000).build().perform();
		 login.driver.findElement(By.xpath("//div[contains(@class,'icon--chart-line_large')]")).click();
		// login.driver.findElement(By.xpath("//*[contains(text(),'View as Chart')]")).click();
		 login.driver.switchTo().activeElement();
	String str= login.driver.findElement(By.xpath("//div[@class='modal-content sphere-modal__content']")).getText().toString();
		Assert.assertEquals(str,"You cannot create a chart with more than 30 series. Proceed with 30 series?");
	}
	@Given("^Select any series id \"([^\"]*)\"$")
	public void select_any_series_id(String arg1) throws Throwable {
		login.driver.findElement(By.xpath("//span[@value='LIST']")).click();
		search_for_series_with_id(arg1);
	}

	@And("^Add to My series$")
	public void add_to_My_series() throws Throwable {
		
		login.driver.findElement(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']")).click();
		 a.sendKeys((Keys.chord("a"))).build().perform();
	    Thread.sleep(2000);
	}

	@Then("^Check the series id and click on Open Function editior$")
	public void check_the_series_id_and_click_on_Open_Function_editior() throws Throwable {
	    
		a.moveToElement(login.driver.findElement(By.className("series-name-field--text"))).build().perform();
		String str=login.driver.findElement(By.xpath("//td[contains(text(),'Series id')]/following::td[1]")).getText();
		System.out.println(str);
		login.driver.findElement(By.xpath("//span[@class='table-container--checkbox svg-checkbox input-control__grey']")).click();
		login.driver.findElement(By.className("function-editor-window--icon")).click();
		WebElement Add=login.driver.findElement(By.xpath("//div[@data-id='MULTIPLY']"));
		jse.executeScript("arguments[0].scrollIntoView(true);", Add);
		CommonFunctionality.wait(2000);
		WebElement frequency=login.driver.findElement(By.xpath("//span[text()='Frequency Transformation']"));
		Assert.assertEquals(frequency.isDisplayed(),true);
	}
	@And("^Check the series id checkbox and click on the fx icon in toolbar$")
	public void check_the_series_id_checkbox_and_click_on_the_fx_icon_in_toolbar() throws Throwable {
		//login.driver.findElement(By.xpath("//span[@class='table-container--checkbox svg-checkbox input-control__grey']")).click();
		a.moveToElement(login.driver.findElement(By.xpath("//span[@class='series-name-field--text']"))).build().perform();
		login.driver.findElement(By.xpath("//div[@title='Apply Function']")).click();
	}

	@Then("^select any unit multiplier \"([^\"]*)\"$")
	public void select_any_unit_multiplier(String arg1) throws Throwable {
		WebElement quickfun=login.driver.findElement(By.xpath("//div[contains(text(),' Unit multiplier')]/following::div[@data-id='UNIT_"+arg1+"']"));
		Assert.assertEquals(quickfun.isDisplayed(),true);
	    
	}
	@Given("^Add any series to My series \"([^\"]*)\"$")
	public void add_any_series_to_My_series(String arg1) throws Throwable {
		select_any_series_id(arg1);
		add_to_My_series();
	}

	@Given("^Click on fx icon from the toolbar$")
	public void click_on_fx_icon_from_the_toolbar() throws Throwable {
		check_the_series_id_checkbox_and_click_on_the_fx_icon_in_toolbar();
	}

	@Given("^Hover on the %PoP function$")
	public void hover_on_the_PoP_function() throws Throwable {
	    a.moveToElement(login.driver.findElement(By.xpath("//div[contains(text(),' Calculate change')]/following::div[contains(text(),'%PoP')]"))).build().perform();
	    
	}

	@Then("^it should display as follows$")
	public void it_should_display_as_follows() throws Throwable {
		String str =" ";
     List<WebElement> hover= login.driver.findElements(By.xpath("//div[@class='tooltip tooltip__visible']/div/div"));
     for(WebElement mouse:hover)
     {
    	 str=str+mouse.getText();
     }
       System.out.println(str);
       Assert.assertEquals(str," % Period-over-Period (%PoP)Syntax: %CHANGE(Over Period; 1; No)Description: Gets the percentage change over time");
       
    	   System.out.println("equal");
       
     }
	
	@Given("^Refresh and clear search$")
	public void refresh_and_clear_search() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//input[@placeholder='Search']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//input[@placeholder='Search']")).clear();
		
		
	   
	}

	
	@Given("^Select any two series id \"([^\"]*)\" and create Chart$")
	public void select_any_two_series_id_and_create_Chart(String arg1) throws Throwable {
		
		select_any_series_id(arg1);
		List<WebElement> series=login.driver.findElements(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']"));
		Thread.sleep(2000);
		for(WebElement serieslist:series)
		{
			CommonFunctionality.wait(2000);
			serieslist.click();
			CommonFunctionality.wait(2000);
		}
		WebElement First_Series = login.driver.findElement(By.xpath("(//div[@class='series-list-item--information'])[1]"));
		action.moveToElement(First_Series).pause(2000).build().perform();
		
		WebElement More_Actions=login.driver.findElement(By.xpath("//span[@title='More actions']"));
		 jse. executeScript("arguments[0]. click();", More_Actions);
		 WebElement View_Chart=login.driver.findElement(By.xpath("//span[normalize-space()='Add chart']"));
		 action.moveToElement(View_Chart).pause(2000).build().perform();
		 WebElement Line_chart=login.driver.findElement(By.xpath("//div[contains(@class,'icon--chart-line_large')]"));
		 jse.executeScript("arguments[0].click();", Line_chart);
		//a.sendKeys((Keys.chord("c"))).build().perform();
		Thread.sleep(2000);
		try {
			WebElement Series_Harmonization=login.driver.findElement(By.xpath("//button[normalize-space(text())='Apply']"));
			Series_Harmonization.click();
	
		
		}
		catch(Exception e) {
			System.out.println("Pop up not appeared");
		}
		
	}

	

	@And("^Click on view1$")
	public void click_on_view() throws Throwable {
login.driver.findElement(By.xpath("//div[@class='page-main-header--spacer']")).click();
         Thread.sleep(4000);
         login.driver.findElement(By.xpath("//a[@title='View 1']/span")).click();
	}

	@Then("^Click on Edit Views$")
	public void click_on_Edit_Views() throws Throwable {
		login.driver.findElement(By.xpath("//*[contains(text(),'Edit Views')]")).click();
		Thread.sleep(2000);
		Assert.assertEquals(login.driver.findElement(By.xpath("//div[contains(text(),'View 2')]/following::div[@title='Chart']")).isEnabled(),true);


	}
	
	@Given("^chart is created$")
	public void chart_is_created() throws Throwable {
		login.driver.findElement(By.xpath("//div[@class='page-main-header--spacer']")).click();
        Thread.sleep(4000);
	}

	@Then("^Drag the view(\\d+) and drop in view(\\d+)$")
	public void drag_the_view_and_drop_in_view(int arg1, int arg2) throws Throwable {
      
     a.dragAndDrop(login.driver.findElement(By.xpath("//div[contains(text(),'View 2')]/following::div[@title='Chart']"))
    		 ,login.driver.findElement(By.xpath("//div[contains(text(),'View 1')]/following::div[@title='Chart'][1]"))).build().perform();
     Thread.sleep(2000);
     Assert.assertEquals(login.driver.findElement(By.xpath("//div[contains(text(),'View 1')]/following::div[@title='Chart'][2]")).isDisplayed(), true);
	}
	@And("^Double click on the legend$")
	public void double_click_on_the_legend() throws Throwable {
		//login.driver.findElement(By.xpath("*//button[contains(text(),'Apply')]")).click();
	   
		a.moveToElement(login.driver.findElement(By.xpath("(//span[@class='series-edit--title series-edit--title__editable'])[1]"))).doubleClick().perform();
		Thread.sleep(2000);
	}

	@Then("^The configuration menu should be displayed$")
	public void the_configuration_menu_should_be_displayed() throws Throwable {
	  Assert.assertEquals(login.driver.findElement(By.xpath("//div[@class='popover--header ui-draggable-handle']")).isDisplayed(),true);
	}
	@Given("^Open the function editor window \"([^\"]*)\"$")
	public void open_the_function_editor_window(String arg) throws Throwable {
		add_any_series_to_My_series(arg);
		login.driver.findElement(By.xpath("//span[@class='table-container--checkbox svg-checkbox input-control__grey']")).click();
		login.driver.findElement(By.className("function-editor-window--icon")).click();
	    
	}
	@Then("^Check if the following function description are same as follows:\"([^\"]*)\",\"([^\"]*)\"\"$")
	
	public void check_if_the_following_function_description_are_same_as_follows(String arg1,String arg2) throws Throwable {
            login.driver.findElement(By.xpath("//*[contains(text(),'By Category')]")).click();
       String arg3[]=arg1.split(";");
       String arg4[]=arg2.split(";");
       for(int i=0,j=0;i<=arg3.length-1;i++)
       {
    	   Thread.sleep(1000);
    	   login.driver.findElement(By.xpath("(//input[@placeholder='Search'])[3]")).clear();
    	   Thread.sleep(1000);
    	   login.driver.findElement(By.xpath("(//input[@placeholder='Search'])[3]")).sendKeys(arg3[i],Keys.ENTER);
    	 login.driver.findElement(By.xpath("//div[@class='function-item'][1]")).click();
    	 Thread.sleep(2000);
    	
    	
    	System.out.println(arg4[j]);
    	Assert.assertEquals(login.driver.findElement(By.xpath("(//div[@class='function-data--description'])[2]")).getText(),arg4[j]);
    	j++;
       }
	}

@Then("^Check if the icons C and S are displayed infront of the series$")
public void check_if_the_icons_C_and_S_are_displayed_infront_of_the_series() throws Throwable {
    List<WebElement> series=login.driver.findElements(By.className("series-item--name"));
    for(int i=1;i<=series.size();i++)
    {
    	if(login.driver.findElement(By.xpath("(//span[@class='status-icon status-icon__key'])["+i+"]")).isDisplayed()){
    		System.out.println("C icons are present");
    		
    	}
    	else {
    		System.out.println("C icons are not  present");
    	}
    	
    	
    }
}
@And("^Refresh the page$")
public void refresh_the_page() throws Throwable {
	Thread.sleep(2000);
	login.driver.navigate().refresh();
    
}

@Then("^The continuous tab and replacements tab both should be present$")
public void the_continuous_tab_and_replacements_tab_both_should_be_present() throws Throwable {
	Thread.sleep(1000);
	check_if_the_icons_C_and_S_are_displayed_infront_of_the_series();
}
/*@And("^Click on Edit Chart$")
public void click_on_Edit_Chart() throws Throwable {
   Thread.sleep(1000);
   login.driver.findElement(By.xpath("//button[contains(text(),'Edit Chart')]")).click();
}*/

@And("^Check if Under left axis Step option is present$")
public void check_if_Under_left_axis_Step_option_is_present() throws Throwable {
    Thread.sleep(1000);
    Assert.assertEquals(login.driver.findElement(By.xpath("//div[@class='tabs__tab-item active']/following::div[contains(text(),'Step')][1]")).isDisplayed(),true);
}

@And("^Check if the Number format is at the first place$")
public void check_if_the_Number_format_is_at_the_first_place() throws Throwable {
   Thread.sleep(1000);
   Assert.assertEquals(login.driver.findElement(By.xpath("//div[@class='tabs__tab-item active']/following::div[contains(text(),'Number format:')]")).isDisplayed(),true);
}

@Then("^Check if the Min/MAX value tab has only input No up and down arrows$")
public void check_if_the_Min_MAX_value_tab_has_only_input_No_up_and_down_arrows() throws Throwable {
   
	Assert.assertEquals(login.driver.findElement(By.xpath("//div[@class='tabs__tab-item active']/following::div[contains(text(),'Min/Max value')]/following::input[@name='interval_min']")).isDisplayed(),true);
	Assert.assertEquals(login.driver.findElement(By.xpath("//div[@class='tabs__tab-item active']/following::div[contains(text(),'Min/Max value')]/following::input[@name='interval_max']")).isDisplayed(),true);
}
@And("^In Tooltip open Advanced setting popup$")
public void in_Tooltip_open_Advanced_setting_popup() throws Throwable {
    login.driver.findElement(By.xpath("//div[@title='Tooltips. Configure the tooltips in the chart.']//div[@title='Open advanced settings popup']")).click();
    
}

@And("^Expand Items$")
public void expand_Items() throws Throwable {
  login.driver.findElement(By.xpath("(//div[contains(text(),'Items')]/following::div[@class='icon-collapse'])[1]")).click();

}

@Then("^Check if the Name and Region are displayed by default$")
public void check_if_the_Name_and_Region_are_displayed_by_default() throws Throwable {
	List<WebElement>tooltip=login.driver.findElements(By.xpath("//div[@class='select-behaviour--multi-select-item']/span"));
	for(WebElement tip:tooltip)
	{
		String str=tip.getText();
		if(str.equalsIgnoreCase("name")||str.equalsIgnoreCase("region")||str.equalsIgnoreCase("frequency"))
		{
			System.out.println(str);
		}
	}


}
@And("^In tooltip click on dropdown beside Date$")
public void in_tooltip_click_on_dropdown_beside_Date() throws Throwable {
   login.driver.findElement(By.xpath("//div[@title='Tooltips. Configure the tooltips in the chart.']//div[@class='context-menu-control--icon']")).click();
   

}

@And("^Select Frequency Checkbox$")
public void select_Frequency_Checkbox() throws Throwable {
    login.driver.findElement(By.xpath("//span[contains(text(),'Frequency')]/parent::label/span[@class='input-control--indicator']")).click();
}

@And("^Hover on the tooltips on the chart visual$")
public void hover_on_the_tooltips_on_the_chart_visual() throws Throwable {
	in_Tooltip_open_Advanced_setting_popup();
	expand_Items();
	}

@Then("^Check if the Frequency is displayed on the new line$")
public void check_if_the_Frequency_is_displayed_on_the_new_line() throws Throwable {
	check_if_the_Name_and_Region_are_displayed_by_default();
}
@Given("^Select any udd series$")
public void select_any_udd_series() throws Throwable {
    login.driver.findElement(By.xpath("//button[contains(text(),'Import Series')]")).click();
    login.driver.findElement(By.xpath("//div[contains(text(),'or click to select a file from your computer')]")).click();
    Robot robot = new Robot();
	 robot.setAutoDelay(2000);
	   
      StringSelection selection = new StringSelection("C:\\Users\\tbemineni\\Desktop\\New folder\\Cucumber_project\\AutoIT\\udd_template.xlsx");
      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);

      robot.setAutoDelay(1000);

      robot.keyPress(KeyEvent.VK_CONTROL);
      robot.keyPress(KeyEvent.VK_V);

      robot.keyRelease(KeyEvent.VK_CONTROL);
      robot.keyRelease(KeyEvent.VK_V);

      robot.setAutoDelay(1000);

      robot.keyPress(KeyEvent.VK_ENTER);
      robot.keyRelease(KeyEvent.VK_ENTER);
}

@Then("^Open SSP$")
public void open_SSP() throws Throwable {
Thread.sleep(2000);
a.moveToElement(login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"))).click().perform();
login.driver.switchTo().activeElement();
int faq=login.driver.findElements(By.xpath("//div[@class='main-series-information--link main-series-information--ask'][1]")).size();
int ask_question=login.driver.findElements(By.xpath("//div[@class='main-series-information--link main-series-information--ask'][2]")).size();
int watch=login.driver.findElements(By.xpath("(//span[@class='preview-series-data-actions--label'])[2]")).size();
if(faq==0)
{
	System.out.println("equal");
}
if(ask_question==0)
{
	System.out.println("equal");
}
if(watch==0)
{
	System.out.println("equal");
}
}
@Given("^Click on the imported tab$")
public void click_on_the_imported_tab() throws Throwable {
    Thread.sleep(2000);
    //login.driver.findElement(By.xpath("//span[contains(text(),'Imported')]")).click();
    WebElement Import_Series=login.driver.findElement(By.xpath("//button[normalize-space(text())='Import Series']"));
	Import_Series.click();
	WebElement Upload_File1=login.driver.findElement(By.xpath("//div[text()='Drag a file here']"));
	Upload_File1.click();
	CommonFunctionality.wait(2000);
	//System.out.println(System.getProperty("user.dir") + "\\AutoIT\\CEIC defined template.exe");
	CommonFunctionality.uploadTheFileusingAutoIT(login.driver,
			System.getProperty("user.dir") + "\\AutoIT\\CEIC.exe",
			System.getProperty("user.dir") + "\\AutoIT\\CEIC.xlsx");
	Thread.sleep(8000);
}

@And("^Click on the sort dropdown$")
public void click_on_the_sort_dropdown() throws Throwable {
	if(login.driver.findElement(By.xpath("(//span[@class='custom-select-title--reset-icon'])[2]")).isDisplayed())
{
	login.driver.findElement(By.xpath("(//span[@class='custom-select-title--reset-icon'])[2]")).click();
}
	CommonFunctionality.wait(2000);
	WebElement SortBy=login.driver.findElement(By.xpath("(//span[contains(text(),'Sort By')])[2]"));
	jse.executeScript("arguments[0].click();", SortBy);
}

@Then("^Select the \"([^\"]*)\" options$")
public void select_the_options(String str) throws Throwable {
   
    
    	login.driver.findElement(By.xpath("//div[@data-id='"+str+"']")).click();
    	if(str.equalsIgnoreCase("series_name"))
    	{
    		int series=login.driver.findElements(By.className("series-item--name")).size();
    		if(series>0)
    		{
    			System.out.println("present");
    		}
    	}
    	if(str.equalsIgnoreCase("SERIESCOUNTRY"))
    	{
    		int series=login.driver.findElements(By.className("series-item--name")).size();
    		if(series>0)
    		{
    			System.out.println("present");
    		}
    	}
    	if(str.equalsIgnoreCase("FREQUENCY"))
    	{
    		int series=login.driver.findElements(By.className("series-item--name")).size();
    		if(series>0)
    		{
    			System.out.println("present");
    		}
    	}
    
	 if(str.equalsIgnoreCase("SOURCENAME"))
	{
		int series=login.driver.findElements(By.className("series-item--name")).size();
		if(series>0)
		{
			System.out.println("present");
		}
	}
}
    @Given("^In Search tab enter any \"([^\"]*)\" and click on search icon$")
   public void in_Search_tab_enter_any_and_click_on_search_icon(String arg1) throws Throwable {
		 click_on_the_imported_tab();
		 login.driver.findElement(By.xpath("//input[@placeholder='Search']")).clear();
		 login.driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(arg1,Keys.ENTER);		 
	 }

	 @Then("^The results should be displayed$")
	 public void the_results_should_be_displayed() throws Throwable {
		 int series=login.driver.findElements(By.className("series-item--name")).size();
			if(series>0)
			{
				System.out.println("present");
			}
        
	 }
	 @Given("^Click on Imported tab available under Data on left of the Window$")
	 public void click_on_Imported_tab_available_under_Data_on_left_of_the_Window() throws Throwable {

		 click_on_the_imported_tab();
	 }

	 @Then("^Dont select any series from imported tab$")
	 public void dont_select_any_series_from_imported_tab() throws Throwable {

           Assert.assertEquals(login.driver.findElement(By.xpath("//button[@class='index-module_button__xs646 index-module_small__6GGgk']")).isEnabled(),false);
	 }

	 @And("^Select some series from imported tab$")
	 public void select_some_series_from_imported_tab() throws Throwable {

            List<WebElement> series= login.driver.findElements(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']"));
            for(WebElement series1:series)
            {
            	series1.click();
            }
	 }

	 @And("^Click on Edit series in Excel button$")
	 public void click_on_Edit_series_in_Excel_button() throws Throwable {

		 login.driver.findElement(By.xpath("//button[@class='index-module_button__xs646 index-module_small__6GGgk']")).click();
	 }

	 @Then("^Download the Excel file with settings as below \"([^\"]*)\"$")
	 public void download_the_Excel_file_with_settings_as_below(String arg1) throws Throwable {
		
         
         String arg2[]=arg1.split(";");
         Thread.sleep(3000);
         String path2 = "C:\\Users\\ShankarVenkatRaju\\Downloads\\Series.xlsx";
     	
         FileInputStream s1=new FileInputStream(path2);
         XSSFWorkbook test = new XSSFWorkbook(s1); 
         XSSFSheet sheet = test.getSheetAt(0);
         XSSFRow row; 
         XSSFCell cell;
         Iterator rows = sheet.rowIterator();
         while (rows.hasNext())
         {
             row=(XSSFRow) rows.next();
             Iterator cells = row.cellIterator();
             while (cells.hasNext())
             {
                 cell=(XSSFCell) cells.next(); 
                 if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
                 {
                     System.out.print(cell.getStringCellValue()+" ");
                 }
                 else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
                 {
                     System.out.print(cell.getNumericCellValue()+" ");
                 }
                 else 
                 {
                 	DataFormatter dataFormatter = new DataFormatter();
                 	String cellStringValue = dataFormatter.formatCellValue(row.getCell(1));
                 	System.out.println ("Is shows data as show in Excel file" + cellStringValue);
                 }
             }
        		 
           }
            
                    	




	 }
	 @Then("^The downloaded file should reflect under recent downloads$")
	 public void the_downloaded_file_should_reflect_under_recent_downloads() throws Throwable {
		 
			recent.click_on_history_download_button1("Series.xlsx");
	 }
	 @And("^Create empty Views$")
	 public void create_empty_Views() throws Throwable {
         for(int i=1;i<=2;i++)
         {
        	 
         
        login.driver.findElement(By.xpath("//div[@title='Create new View tab']")).click();
         }
	 }

	 @Then("^DND Visual from View(\\d+) to Empty View(\\d+)$")
	 public void dnd_Visual_from_View_to_Empty_View(int arg1,int arg2) throws Throwable {
		 
		 login.driver.findElement(By.xpath("//*[contains(text(),'Edit Views')]")).click();
			Thread.sleep(2000);
			a.dragAndDrop(login.driver.findElement(By.xpath("//div[contains(text(),'View 1')]/following::div[@title='Chart']"))
		    		 ,login.driver.findElement(By.xpath("//div[contains(text(),'View 2')]"))).build().perform();
		     Thread.sleep(4000);
		     Assert.assertEquals(login.driver.findElement(By.xpath("//div[contains(text(),'View 1')]/following::div[@title='Chart'][1]")).isDisplayed(), true);

	 }
	 @Given("^Click on edit series on view tab$")
	 public void click_on_edit_series_on_view_tab() throws Throwable {
		 Thread.sleep(2000);
          login.driver.findElement(By.xpath("//button[contains(text(),'Edit Series')]")).click();
          
          
          

	 }

	 @Given("^Hover the mouse on the series name$")
	 public void hover_the_mouse_on_the_series_name() throws Throwable {
		 Thread.sleep(2000);
         a.moveToElement(login.driver.findElement(By.xpath("(//div[@class='series-name--title'])[1]"))).build().perform();

	 }

	 @Then("^Check the background selection color of a series$")
	 public void check_the_background_selection_color_of_a_series() throws Throwable {

          String str=login.driver.findElement(By.xpath("//div[@class='index-module_swatch_button_item_color__gAHg1']")).getAttribute("style");
          System.out.println(str);
	 }
	 @Then("^Click on the cross icon besides the series name$")
	 public void click_on_the_cross_icon_besides_the_series_name() throws Throwable {
	    Thread.sleep(2000);
	    a.moveToElement(login.driver.findElement(By.xpath("(//span[@title='Remove series'])[1]"))).click().build().perform();
	    login.driver.switchTo().activeElement();
	   String str= login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']")).getText();
	   System.out.println(str);
	   Assert.assertEquals(str, "Are you sure you want to delete the series \"Suresh\"?\r\n"+"Other users from your account won't access it anymore.\r\n"+"\r\n"+"Warning: you cannot undo this action.\r\n"+"CancelDelete forever");
	 }
	 @Given("^Hover the mouse on the imported series name$")
	 public void hover_the_mouse_on_the_imported_series_name() throws Throwable {
		 Thread.sleep(2000);
         a.moveToElement(login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"))).pause(2000).build().perform();

	 }
	 @And("^Click on the cross icon$")
	 public void click_on_the_cross_icon() throws Throwable {

		 Thread.sleep(2000);
		    a.moveToElement(login.driver.findElement(By.xpath("(//span[@title='Remove series'])[1]"))).click().build().perform();
		    login.driver.switchTo().activeElement();
	 }
	 @Then("^select \"([^\"]*)\" opti$")
	 public void select_opti(String str)
	 {
		 login.driver.findElement(By.xpath("//button[contains(text(),'"+str+"')]")).click();
	 }
	 @Given("^login from User2 account$")
	 public void login_from_User_account() throws Throwable {
		 
	     
	 }

	 @Given("^Hover the mouse of the imported series by User1$")
	 public void hover_the_mouse_of_the_imported_series_by_User() throws Throwable {
	     
	 }

	 @Then("^Check the remove series icon from User2$")
	 public void check_the_remove_series_icon_from_User() throws Throwable {
	     
	 }
	 

	 @Then("^Check the user data tab or imported option on search panel$")
	 public void check_the_user_data_tab_or_imported_option_on_search_panel() throws Throwable {
		 Assert.assertEquals(login.driver.findElement(By.xpath("//span[contains(text(),'Imported')]")).isDisplayed(),true);

	 }
	 @Then("Try to import  same imported file again$")
	 public void try_to_import_same_imported_file_again() throws Throwable
	 {
		 select_any_udd_series();
		 login.driver.switchTo().activeElement();
		String str= login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']")).getText();
		Assert.assertEquals(str,"Invalid value in the cell C8-SssT005. A series with the same user series ID has been used already by you or your account member. Please specify a different ID.\r\n" + 
				"\r\n" + 
				"Invalid value in the cell B8-Sss006. A series with the same user series ID has been used already by you or your account member. Please specify a different ID.\r\n" + 
				"Ok");
	 }
	 @And("^Open ssp windows$")
		public void open_ssp_windows() throws Throwable {
			login.Log4j.info("Clicking on  Series tab ");
			//CommonFunctionality.getElementByProperty(login.driver, "Series", 30).click();
			login.driver.findElement(By.xpath("//span[@value='LIST']")).click();
			CommonFunctionality.wait(2000);
			a.moveToElement(login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"))).pause(2000).click().perform();
			login.driver.switchTo().activeElement();
			String str=login.driver.findElement(By.xpath("//span[@class='main-series-information--link']/span")).getText();
			System.out.println(str);
		}
	 @And("^Add these series into my series panel$")
	 public void add_these_series_into_my_series_panel() throws Throwable {
		 List<WebElement> series=login.driver.findElements(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']"));
			Thread.sleep(2000);
			for(WebElement serieslist:series)
			{
				serieslist.click();
			}
			a.sendKeys((Keys.chord("a"))).build().perform();
			Thread.sleep(2000);
	 }

	 @Then("^Apply currency conversion function on above series$")
	 public void apply_currency_conversion_function_on_above_series() throws Throwable {
		 login.driver.findElement(By.xpath("//input[@name='select_all_dataselection']/following::span[@class='input-control--indicator']")).click();
		 Thread.sleep(2000);
			login.driver.findElement(By.className("function-editor-window--icon")).click();
		 login.driver.findElement(By.xpath("//div[contains(text(),'By function')]")).click();
		 login.driver.findElement(By.xpath("//input[@placeholder='Search...']")).clear();
  	   Thread.sleep(1000);
  	   login.driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys("CONVERTCUR",Keys.ENTER);
  	 a.moveToElement(login.driver.findElement(By.xpath("//div[@class='function-item'][1]"))).doubleClick().build().perform();
  	 Thread.sleep(2000);
  	 login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
  	   login.driver.switchTo().activeElement();
  	   String str=login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']")).getText();
  	   System.out.println("Str22"+str);
  	 Assert.assertEquals(str,"The function cannot be applied to \"Policy Rate: Month End: Main Refinancing Operations\" series.\r\n" + 
  	 		"Continue operation with other function(s)?\r\n" + 
  	 		"CancelOk");
	 }
		 @And("^Apply Aggregate Sum,yearly,december$")
	 public void apply_Aggregate_Sum_yearly_december() throws Throwable {
		 check_the_series_id_checkbox_and_click_on_the_fx_icon_in_toolbar();
		 login.driver.findElement(By.xpath("//div[@data-id='SUM']")).click();
	 }

	 @Then("^Download base and transformed series into excel$")
	 public void download_base_and_transformed_series_into_excel() throws Throwable {
		login.driver.findElement(By.xpath("//span[contains(text(),'Download')]")).click();
		login.driver.switchTo().activeElement();
		login.driver.findElement(By.xpath("(//span[contains(text(),'Download')])[3]")).click();
		Thread.sleep(2000);
		String path2 = "C:\\Users\\tbemineni\\Downloads\\Industrial Production Civil Steel Ships.xlsx";
		 
         FileInputStream s1=new FileInputStream(path2);
         XSSFWorkbook test = new XSSFWorkbook(s1); 
         XSSFSheet sheet = test.getSheetAt(0);
         XSSFRow row; 
         XSSFCell cell;
         Iterator rows = sheet.rowIterator();
         while (rows.hasNext())
         {
             row=(XSSFRow) rows.next();
             Iterator cells = row.cellIterator();
             while (cells.hasNext())
             {
                 cell=(XSSFCell) cells.next(); 
                 if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
                 {
                     System.out.print(cell.getStringCellValue()+" ");
                 }
                 else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
                 {
                     System.out.print(cell.getNumericCellValue()+" ");
                 }
                 else 
                 {
                 	DataFormatter dataFormatter = new DataFormatter();
                 	String cellStringValue = dataFormatter.formatCellValue(row.getCell(1));
                 	System.out.println ("Is shows data as show in Excel file" + cellStringValue);
                 }
             }
        		 
           }
		
	 }
	 @Given("^Verify the footnotes of series \"([^\"]*)\"$")
	 public void verify_the_footnotes_of_series(String arg1) throws Throwable {
		 select_any_series_id(arg1);
		 a.moveToElement(login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"))).contextClick().perform();
		 a.moveToElement(login.driver.findElement(By.xpath("//span[@title='Footnotes']"))).click().perform();
	 }

	 @Then("^Check for the characters language$")
	 public boolean check_for_the_characters_language() throws Throwable {
	     login.driver.switchTo().activeElement();
	     String str=login.driver.findElement(By.xpath("//div[@class='empty-selection--description']")).getText();
	     for(int i=0; i < str.length(); i++) {
	         Boolean flag = Character.isDigit(str.charAt(i));
	         if(flag) {
	            System.out.println("'"+ str.charAt(i)+"' is a number");
	         }
	         else {
	            System.out.println("'"+ str.charAt(i)+"' is a letter");
	         }
	      }
	     Pattern letter = Pattern.compile("[a-zA-z]");
	        Pattern digit = Pattern.compile("[0-9]");
	        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
	        //Pattern eight = Pattern.compile (".{8}");


	           Matcher hasLetter = letter.matcher(str);
	           Matcher hasDigit = digit.matcher(str);
	           Matcher hasSpecial = special.matcher(str);

	           return hasLetter.find() && hasDigit.find() && hasSpecial.find();
	 }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}


  
