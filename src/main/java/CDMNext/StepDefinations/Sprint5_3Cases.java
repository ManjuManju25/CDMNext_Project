package CDMNext.StepDefinations;

import static org.junit.Assert.fail;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xpath.operations.Bool;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class Sprint5_3Cases extends CommonFunctionality  {
	
	
	
	
	@Given("^user clicks on More Dropdown\\.$")
	public void user_clicks_on_More_Dropdown() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("More_dropdown"))).click();
		
		
		
	   
	}

	@Given("^searches with series S under More Dropdown\\.$")
	public void searches_with_series_S_under_More_Dropdown() throws Throwable {
		CommonFunctionality.wait(5000);
		login.driver.findElement(By.xpath("//span[@class='status-icon--sign'][normalize-space()='S']")).click();
		login.driver.findElement(By.xpath("//div[normalize-space(text())='Apply filter']")).click();
		List<WebElement> list = login.driver.findElements(By.xpath("//span[@class='status-icon--sign'][normalize-space()='S']"));
		CommonFunctionality.wait(2000);
		if(list.size()>1) {
			login.Log4j.info("Series with S Icon are shown");
			
		}
		else {
			login.Log4j.info("Series with S Icon are not shown");
		}  
		
		
		
		
	    
	}

	@Given("^searches with series C under More Dropdown\\.$")
	public void searches_with_series_C_under_More_Dropdown() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("More_dropdown"))).click();
		CommonFunctionality.wait(5000);
		login.driver.findElement(By.xpath("//span[@class='status-icon']//span[@class='status-icon--sign'][normalize-space()='C']")).click();
		login.driver.findElement(By.xpath("//div[@class='button__primary button button__primary']")).click();
		List<WebElement> list = login.driver.findElements(By.xpath("//span[@class='status-icon']//span[@class='status-icon--sign'][normalize-space()='C']"));
		CommonFunctionality.wait(2000);
		if(list.size()>1) {
			login.Log4j.info("Series with C Icon are shown");
			
		}
		else {
			login.Log4j.info("Series with C Icon are not shown");
		}  
		
		
	   
	}
	@Then("^Searches with S and c under More dropdown\\.$")
	public void searches_with_S_and_c_under_More_dropdown() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("More_dropdown"))).click();
		CommonFunctionality.wait(5000);
		try {
		WebElement rebased=login.driver.findElement(By.xpath("//span[@class='status-icon--sign'][normalize-space()='S']"));
		rebased.click();
		}
		catch(Exception e) {
			System.out.println("Already clicked on rebased series");
		}
		CommonFunctionality.wait(2000);
		try {
		WebElement continuos=login.driver.findElement(By.xpath("//span[@class='status-icon']//span[@class='status-icon--sign'][normalize-space()='C']"));
		continuos.click();
		}
		catch(Exception e) {
			System.out.println("Already clicked on continuos series");
		}
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//div[@class='button__primary button button__primary']")).click();
		
		List<WebElement> list =	login.driver.findElements(By.xpath("//p[@class='search-no-results--header']"));
		if(list.size()==1) {
			login.Log4j.info("results are found for S and c");
				
			
		}
		else {
			login.Log4j.info("results are not found for S and c");
		}	
	    
	}

	
	@Given("^user selects some series\\.$")
	public void user_selects_some_series() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Series')]", 8).click();
		for (int i = 1; i <= 3; i++) {
			CommonFunctionality.getElementByXpath(login.driver,
					"(//span[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]", 8).click();

		}
		// click on '+'icon
		//CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='add-to-data-selection--icon'])[1]", 8)
				//.click();
		
	    
	}

	@Given("^Mouse hover on series selects View as Map option\\.$")
	public void mouse_hover_on_series_selects_View_as_Map_option() throws Throwable {
		WebElement First_Series = login.driver.findElement(By.xpath("(//div[@class='series-list-item--information'])[1]"));
		action.moveToElement(First_Series).pause(2000).build().perform();
		WebElement More_Actions=login.driver.findElement(By.xpath("//span[@title='More actions']"));
		 jse. executeScript("arguments[0]. click();", More_Actions);
		WebElement View_Map = login.driver.findElement(By.xpath("//span[@title='Add chart']"));
		action.moveToElement(View_Map).pause(2000).build().perform();
		login.driver.findElement(By.xpath("//div[contains(@class,'icon--map-filled_large')]")).click();
		CommonFunctionality.wait(2000);
		try {
		WebDriverWait wait = new WebDriverWait(login.driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//button[normalize-space(text())='Apply']")))).click();
		//CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='add-to-data-selection--icon'])[1]", 8).click();

		
		}
		catch(Exception e) {
			System.out.println("pop up not appeared");
			
		}
		
		
		
	    
	}

	@Given("^clicks on Edit Map\\.$")
	public void clicks_on_Edit_Map() throws Throwable {
		
		WebDriverWait wait = new WebDriverWait(login.driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//button[normalize-space(text())='Edit Map']")))).click();
		//login.driver.findElement(By.xpath("//button[normalize-space(text())='Edit Map']")).click();
		
		//button[normalize-space(text())='Edit Map']
		
	   
	}

	@Given("^select gradient color with steps : \"([^\"]*)\"$")
	public void select_gradient_color_with_steps(String Gradsize) throws Throwable {
		login.driver.findElement(By.xpath("//span[normalize-space(text())='Gradient']")).click();
		login.driver.findElement(By.xpath("//select[@class='gradient-axis--steps-select']")).click();
		login.driver.findElement(By.xpath("//option[text()='" +Gradsize +"']")).click();
		
		
		
		
		
		
		List<WebElement> gradComponents=login.driver.findElements(By.xpath("//div[@class='gradient-line']"));
		int gradComponentsize=gradComponents.size();
		System.out.println("============="+gradComponentsize);
		
		Assert.assertEquals(gradComponentsize, 6);
		
		
	   
	}

	@Given("^select solid color with steps : \"([^\"]*)\"\\.$")
	public void select_solid_color_with_steps(String Solidsize) throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//span[normalize-space(text())='Solid color']")).click();
		login.driver.findElement(By.xpath("//select[@class='solid-colors--color-stops-select']")).click();
		login.driver.findElement(By.xpath("//option[text()='" +Solidsize +"']")).click();
		
		List<WebElement> SolidComponent=login.driver.findElements(By.xpath("//div[@class='color-picker-container']/ancestor::div[@class='predefined-color']"));
		int solidComponentsize=SolidComponent.size();
		System.out.println("============="+solidComponentsize);
		if(solidComponentsize==7) {
			login.Log4j.info("Set values and labels for color steps : 7 verified");
		}
		
		else {
			login.Log4j.info("Set values and labels for color steps : 7 not verified");
		}
		
	    
	}

	
	@Given("^Mouse hover on series selects View as HeatMap option\\.$")
	public void mouse_hover_on_series_selects_View_as_HeatMap_option() throws Throwable {
		WebElement First_Series = login.driver.findElement(By.xpath("(//div[@class='series-list-item--information'])[1]"));
		action.moveToElement(First_Series).pause(2000).build().perform();
		WebElement More_Actions=login.driver.findElement(By.xpath("//span[@title='More actions']"));
		 jse. executeScript("arguments[0]. click();", More_Actions);
		 WebElement View_Map = login.driver.findElement(By.xpath("//span[@title='Add chart']"));
			action.moveToElement(View_Map).pause(2000).build().perform();
		
			login.driver.findElement(By.xpath("//div[contains(@class,'icon--heatmap_large')]")).click();
			CommonFunctionality.wait(2000);
			//CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='add-to-data-selection--icon'])[1]", 8).click();
			try {
			WebDriverWait wait = new WebDriverWait(login.driver, 40);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//button[normalize-space(text())='Apply']")))).click();
			}
			catch(Exception e) {
				System.out.println("pop up not appeared");
			}
			//login.driver.findElement(By.xpath("//button[@class='button button__primary']")).click();
	    
	}

	@Given("^clicks on Edit HeatMap\\.$")
	public void clicks_on_Edit_HeatMap() throws Throwable {
		//WebDriverWait wait = new WebDriverWait(login.driver, 40);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//button[normalize-space(text())='Edit Heat map']")))).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//button[normalize-space(text())='Edit Heat map']")).click();
		
		
		
	    
	}

	
	@Given("^Validate maximum value for solid color : \"([^\"]*)\"\\.$")
	public void validate_maximum_value_for_solid_color(String Solidsize) throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//span[normalize-space(text())='Solid color']")).click();
		login.driver.findElement(By.xpath("//select[@class='solid-colors--color-stops-select']")).click();
		login.driver.findElement(By.xpath("//option[text()='" +Solidsize +"']")).click();
		
		List<WebElement> SolidComponent=login.driver.findElements(By.xpath("//div[@class='color-picker-container']/ancestor::div[@class='predefined-color']"));
		int solidComponentsize=SolidComponent.size();
		System.out.println("============="+solidComponentsize);
		if(solidComponentsize==7) {
			login.Log4j.info("The maximum value for solid color is 7");
		}
		
		else {
			login.Log4j.info("The maximum value for solid color is not 7");
		}
		
		
	    
	}
	
	@Given("^user enters series Id in search bar as : \"([^\"]*)\"$")
	public void user_enters_series_Id_in_search_bar_as(String arg1) throws Throwable {
		login.driver.findElement(By.xpath("//input[@placeholder='Search']")).click();
		login.driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(arg1,Keys.ENTER);
		
	    
	}

	@Given("^clicks on open SSP Window\\.$")
	public void clicks_on_open_SSP_Window() throws Throwable {
		WebElement First_Series = login.driver.findElement(By.xpath("(//div[@class='series-list-item--information'])[1]"));
		action.moveToElement(First_Series).pause(2000).build().perform();
		
		login.driver.findElement(By.xpath("//div[@class='series-item--name']")).click();
		
	   
	}

	@Given("^verify whether dates displayed in legend area are displayed correctly\\.$")
	public void verify_whether_dates_displayed_in_legend_area_are_displayed_correctly() throws Throwable {
		
	List<WebElement> Dates=login.driver.findElements(By.xpath("//*[@class='highcharts-axis-labels highcharts-xaxis-labels']"));
	   if(Dates.size()>1) {
		   
	  login.Log4j.info("Dates on legend are displayed correctly");
		   	
	}
	   else {
		   login.Log4j.info("Dates on legend are not displayed correctly");
		   
	   }
		
	    
	}

	@Given("^user selects View as Histogram\\.$")
	public void user_selects_View_as_Histogram() throws Throwable {
		
		WebElement First_Series = login.driver.findElement(By.xpath("(//div[@class='series-item--content'])[1]"));
		action.moveToElement(First_Series).pause(2000).build().perform();
		WebElement More_Actions=login.driver.findElement(By.xpath("//span[@title='More actions']"));
		 jse. executeScript("arguments[0]. click();", More_Actions);
		 /*WebElement View_Map = login.driver.findElement(By.xpath("//span[@title='View as ...']"));
			action.moveToElement(View_Map).pause(2000).build().perform();
		
			login.driver.findElement(By.xpath("//span[@title='Histogram']")).click();*/
		 WebElement View_Map = login.driver.findElement(By.xpath("//span[@title='Add chart']"));
			action.moveToElement(View_Map).pause(2000).build().perform();
			
			CommonFunctionality.wait(2000);
			login.driver.findElement(By.xpath("//div[contains(@class,'icon--histogram_large')]")).click();
	}

	@Given("^verify whether dates displayed in legend area of Histogram are displayed correctly\\.$")
	public void verify_whether_dates_displayed_in_legend_area_of_Histogram_are_displayed_correctly() throws Throwable {
		
		List<WebElement> Dates=login.driver.findElements(By.xpath("//*[@class='highcharts-axis-labels highcharts-xaxis-labels']"));
		   if(Dates.size()>1) {
			   
		  login.Log4j.info("Dates on Histogram legend area are  displayed correctly");
			   	
		}
		   else {
			   login.Log4j.info("Dates on Histogram legend area  are not displayed correctly");
			   
		   }
				
		
		
	    
	}

	
	@Given("^user enters series Id in search bar as : \"([^\"]*)\";\"([^\"]*)\"$")
	public void user_enters_series_Id_in_search_bar_as(String arg1, String arg2) throws Throwable {
		login.driver.findElement(By.xpath("//input[@placeholder='Search']")).click();
		login.driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(arg1,arg2,Keys.ENTER);
	   
	}

	@Given("^Select some series  View as HeatMap option\\.$")
	public void select_some_series_View_as_HeatMap_option() throws Throwable {
		//WebElement First_Series = login.driver.findElement(By.xpath("//div[@class='series-list-item--information']"));
		//action.moveToElement(First_Series).pause(2000).build().perform();
		for (int i = 1; i <= 2; i++) {
			CommonFunctionality.wait(2000);
			CommonFunctionality.getElementByXpath(login.driver,
					"(//span[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]", 8).click();
			CommonFunctionality.wait(2000);
		
		
		}
		WebElement More_Actions=login.driver.findElement(By.xpath("//span[@title='More actions']"));
		 jse. executeScript("arguments[0]. click();", More_Actions);
		/* WebElement View_Map = login.driver.findElement(By.xpath("//span[@title='View as ...']"));
			action.moveToElement(View_Map).pause(2000).build().perform();
		
			login.driver.findElement(By.xpath("//span[@title='Heat map']")).click();*/
		 WebElement View_Map = login.driver.findElement(By.xpath("//span[@title='Add chart']"));
			action.moveToElement(View_Map).pause(2000).build().perform();
		
			login.driver.findElement(By.xpath("//div[contains(@class,'icon--heatmap_large')]")).click();
	}

	@Given("^should not show blank observations for HeatMap\\.$")
	public void should_not_show_blank_observations_for_HeatMap() throws Throwable {
		List<String> values=new ArrayList<String>();
		List<WebElement> Blank_observations=login.driver.findElements(By.xpath("//div[@class='highcharts-axis-labels highcharts-xaxis-labels']//span//div[3]"));

		for(WebElement ele:Blank_observations) {
			String text1=ele.getText();
			System.out.println(text1);
			values.add(text1);		
		}
		Boolean boo=values.contains("1972");
		if(boo==false) {
			
			   login.Log4j.info("1972 has no blank observations");
			   
		}
		else {
			login.Log4j.info("1972 has blank observations");
		}
		
		
	   
	}
	
	@Given("^User selects Thirty series$")
	public void user_selects_Thirty_series() throws Throwable {
		
		WebElement ele=login.driver.findElement(By.xpath("//span[@value='LIST']"));
		jse. executeScript("arguments[0]. click();", ele);
		List<WebElement> list = login.driver.findElements(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']"));
		CommonFunctionality.wait(2000);
		
		
		for (int i=1; i<list.size()-10; i++) {
			CommonFunctionality.wait(2000);
			list.get(i).click();
			CommonFunctionality.wait(2000);	
		}
		
	    
	}

	@Given("^selects view as a HeatMap\\.$")
	public void selects_view_as_a_HeatMap() throws Throwable {
		WebElement First_Series = login.driver.findElement(By.xpath("(//div[@class='series-list-item--information'])[1]"));
		action.moveToElement(First_Series).pause(2000).build().perform();
		
		WebElement More_Actions=login.driver.findElement(By.xpath("//span[@title='More actions']"));
		 jse. executeScript("arguments[0]. click();", More_Actions);
		/* WebElement View_Map = login.driver.findElement(By.xpath("//span[@title='View as ...']"));
			action.moveToElement(View_Map).pause(2000).build().perform();
		
			login.driver.findElement(By.xpath("//span[@title='Heat map']")).click();*/
		 WebElement View_Map = login.driver.findElement(By.xpath("//span[@title='Add chart']"));
			action.moveToElement(View_Map).pause(2000).build().perform();
		
			login.driver.findElement(By.xpath("//div[contains(@class,'icon--heatmap_large')]")).click();
			try {
			WebElement ele=login.driver.findElement(By.xpath("//button[normalize-space(text())='Apply']"));
			 jse. executeScript("arguments[0]. click();", ele);
			}
			catch(Exception e) {
				System.out.println("pop up not appeared");
			}
	}

	@Given("^should generate HeatMap with Thirty series\\.$")
	public void should_generate_HeatMap_with_Thirty_series() throws Throwable {
		
		List<WebElement>Series= login.driver.findElements(By.xpath("//*[@class='legend-item']"));
		System.out.println("========"+Series.size());
		
		if(Series.size()>0) {
			login.Log4j.info("Heat Map is generated with 30 series");
			
		}
		else {
			login.Log4j.info("Heat Map is not  generated with 30 series");
			
		}
				
	    
	}


	@Given("^Double click on the legend bar below visual$")
	public void double_click_on_the_legend_bar_below_visual() throws Throwable {
		WebElement Legend=login.driver.findElement(By.xpath("//*[@class='highcharts-axis highcharts-coloraxis']"));
		action.moveToElement(Legend).pause(2000).doubleClick().build().perform();
		//login.driver.findElement(By.xpath("//div[normalize-space(text())='Color axes']/following-sibling::div[2]")).click();
		
		WebDriverWait wait = new WebDriverWait(login.driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//div[normalize-space(text())='Color axes']/following-sibling::div[2]")))).click();
	    
	}
	@Given("^user selects any four series\\.$")
	public void user_selects_any_four_series() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Series')]", 8).click();
		for (int i = 1; i <= 4; i++) {
			CommonFunctionality.getElementByXpath(login.driver,
					"(//span[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]", 8).click();

		}
	    
	}

	@Given("^Mouse hover on series selects View as Chart option\\.$")
	public void mouse_hover_on_series_selects_View_as_Chart_option() throws Throwable {
		WebElement First_Series = login.driver.findElement(By.xpath("(//div[@class='series-item--main-info'])[1]"));
		action.moveToElement(First_Series).pause(2000).build().perform();
		WebElement More_Actions=login.driver.findElement(By.xpath("//span[@title='More actions']"));
		 jse. executeScript("arguments[0]. click();", More_Actions);
		 WebElement View_Map = login.driver.findElement(By.xpath("//span[@title='Add chart']"));
			action.moveToElement(View_Map).pause(2000).build().perform();
			
			
		 
		login.driver.findElement(By.xpath("//div[contains(@class,'icon--chart-line_large')]")).click();
		/*login.driver.findElement(By.xpath("//button[normalize-space(text())='Edit Chart']")).click();
		CommonFunctionality.wait(2000);
		WebElement Arrow=login.driver.findElement(By.xpath("//div[@class='type-select--icon']"));
		Arrow.click();
		login.driver.findElement(By.xpath("//span[text()='Line']")).click();*/
		
		 try {
			WebDriverWait wait = new WebDriverWait(login.driver, 40);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//button[normalize-space(text())='Apply']")))).click();
		 }
		 catch(Exception e) {
			 System.out.println("Pop up not appeared");
		 }
		 
		 
		
	  
	}

	@Given("^Right Click on series below chart\\.$")
	public void right_Click_on_series_below_chart() throws Throwable {
		WebElement Series=login.driver.findElement(By.xpath("(//span[@class='series-edit--title series-edit--title__editable'])[1]"));
		action.moveToElement(Series).pause(2000).contextClick().build().perform();
		
		
		
	   
	}

	@Given("^click on to Move to axis Option\\.$")
	public void click_on_to_Move_to_axis_Option() throws Throwable {
		WebElement MoveTo_axis=login.driver.findElement(By.xpath("//span[normalize-space(text())='Move to axis']"));
		action.moveToElement( MoveTo_axis).pause(2000).build().perform();
		login.driver.findElement(By.xpath("//span[@title='L1 Axis']")).click();
		
		
		   
	}
	
	@Given("^user clicks on releases Tab$")
	public void user_clicks_on_releases_Tab() throws Throwable {
		login.driver.findElement(By.xpath("(//span[normalize-space(text())='Releases'])[1]")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Releases_Expand"))).click();
		
	    
	}

	@Given("^hovers on green dot$")
	public void hovers_on_green_dot() throws Throwable {
		WebElement Green_dot=login.driver.findElement(By.xpath("//*[@class='release-schedule--tree']//*[@class='series-item--name']"));
		CommonFunctionality.wait(2000);
		action.moveToElement(Green_dot).pause(2000).build().perform();
		if(Green_dot.isDisplayed()){
			
			login.Log4j.info("contains series that match your search is present");
		}
		
		else {
			login.Log4j.info("Green dot is not present");
		}
		
		
		
		
	}

	@Given("^click on series tab$")
	public void click_on_series_tab() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//span[normalize-space(text())='Data'])[1]")))).click();
		
		login.driver.findElement(By.xpath("//span[@value='LIST']")).click();
		
	    
	}

	@Given("^hover on any series=>See in database to find purple dot\\.$")
	public void hover_on_any_series_See_in_database_to_find_purple_dot() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[1]")).click();
		WebElement More_Actions=login.driver.findElement(By.xpath("//span[@title='More actions']"));
		 jse. executeScript("arguments[0]. click();", More_Actions);
		boolean ss =	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("See_in_DatabaseIcon"))).isDisplayed();
		
	
	WebElement Database = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("See_in_DatabaseIcon")));
	
	jse. executeScript("arguments[0]. click();", Database);
	//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[@title='Global Database: Table CN.JA001: Trade Balance']")))).click();
	if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Purple_color"))).isDisplayed()) {
		CommonFunctionality.wait(2000);
		login.Log4j.info("Purple dot contains series that match your search is present");
	}
	else {
		login.Log4j.info("Purple dot contains series that match your search is not present");
	}
	   
	}

	@Given("^user enters Series Id as : \"([^\"]*)\" to view orange dot\\.$")
	public void user_enters_Series_Id_as_to_view_orange_dot(String arg1) throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[@value='LIST']")))).click();
		//login.driver.findElement(By.xpath("//span[@value='LIST']")).click();
		login.driver.findElement(By.xpath("//input[@placeholder='Search']")).click();
		login.driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(arg1,Keys.ENTER);
		CommonFunctionality.wait(2000);
		WebElement Series=login.driver.findElement(By.xpath("//div[@class='series-list-item-data']"));
		action.moveToElement(Series).pause(3000).build().perform();
		if(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Orange_color"))).isDisplayed()) {
			login.Log4j.info("orange dot contains series that match your search is  present");
			
		}
		else {
			login.Log4j.info("orange dot contains series that match your search is not present");
			
		}
			   
	}

	@Given("^user clicks on all regions at left corner\\.$")
	public void user_clicks_on_all_regions_at_left_corner() throws Throwable {
		login.driver.findElement(By.xpath("//span[contains(text(),'All Regions')]")).click();
		WebDriverWait wait = new WebDriverWait(login.driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//div[normalize-space(text())='All']")))).click();
				
		
	    
	}

	@Given("^selects some Europe countries\\.$")
	public void selects_some_Europe_countries() throws Throwable {
		CommonFunctionality.wait(2000);
		for(int i=0;i<20;i++) {
			
			List<WebElement> regions=login.driver.findElements(By.xpath("//div[@class='filter-list regions-filter-list']//div//span[@class='text-dots']"));
			System.out.println("Size is "+regions.size());
			for(WebElement e:regions) {
				JavascriptExecutor jse=(JavascriptExecutor)login.driver;
				jse.executeScript("arguments[0].scrollIntoView(true);", e);
				
				
			}
		}
		
		WebElement ele=login.driver.findElement(By.xpath("//span[@title='Finland']"));
		WebElement ele1=login.driver.findElement(By.xpath("//span[@title='France']"));
		WebElement ele2=login.driver.findElement(By.xpath("//span[@title='Germany']"));
		WebElement ele3=login.driver.findElement(By.xpath("//span[@title='United Kingdom']"));
		ele.click();
		ele1.click();
		ele2.click();
		ele3.click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//div[normalize-space(text())='Apply filter']")).click();	    
	}

	@Given("^selects some series\\.$")
	public void selects_some_series() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Series')]", 8).click();
		for (int i = 1; i <= 3; i++) {
			CommonFunctionality.getElementByXpath(login.driver,
					"(//span[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]", 8).click();

		}
	   
	}

	@Given("^click View as Map=>and click on EU$")
	public void click_View_as_Map_and_click_on_EU() throws Throwable {
		WebElement First_Series = login.driver.findElement(By.xpath("(//div[@class='series-item-information'])[1]"));
		action.moveToElement(First_Series).pause(2000).build().perform();
		WebElement More_Actions=login.driver.findElement(By.xpath("//span[@title='More actions']"));
		 jse. executeScript("arguments[0]. click();", More_Actions);
		 WebElement View_Map = login.driver.findElement(By.xpath("//span[@title='Add chart']"));
			action.moveToElement(View_Map).pause(2000).build().perform();
		  login.driver.findElement(By.xpath("//div[contains(@class,'icon--map-filled_large')]")).click();
		//login.driver.findElement(By.xpath("//span[contains(text(),'EU')]")).click();
		  try {
			  login.driver.findElement(By.xpath("//button[normalize-space(text())='Apply']")).click();
		  }
		
	   catch(Exception e) {
		   System.out.println("Already clicked");
	   }
	}

	@Then("^verify UK should not show in EU Map\\.$")
	public void verify_UK_should_not_show_in_EU_Map() throws Throwable {
		WebElement DE=login.driver.findElement(By.xpath("(//*[normalize-space(text())='FR'])[2]"));
		if(DE.isDisplayed()) {
			login.Log4j.info("UK is not displayed in EU Map");
		}
		else {
			login.Log4j.info("UK is  displayed in EU Map");
		}
		
	    
	}

	@Given("^user clicks on indicator dropdown\\.$")
	public void user_clicks_on_indicator_dropdown() throws Throwable {
		login.driver.findElement(By.xpath("//span[contains(text(),'Indicator')]")).click();
		
		
		
	   
	}

	@Given("^click on All indicator tab$")
	public void click_on_All_indicator_tab() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[text()='All']")).click();	
		login.driver.findElement(By.xpath("(//div[@class='tree-filter-item--open-icon'])[1]")).click();
		login.driver.findElement(By.xpath("//span[@title='Gross Domestic Product by Industry/Gross Value Added']")).click();
		login.driver.findElement(By.xpath("//span[normalize-space(text())='Gross Value Added']")).click();
		
	    
	}

	@Given("^click on apply filter$")
	public void click_on_apply_filter() throws Throwable {
		login.driver.findElement(By.xpath("//div[normalize-space(text())='Apply filter']")).click();
	   
	}

	@Given("^hover the mouse on series$")
	public void hover_the_mouse_on_series() throws Throwable {
		WebElement Series=login.driver.findElement(By.xpath("//div[@class='series-item--name']"));
		action.moveToElement(Series).pause(2000).build().perform();
	    
	}

	@Then("^click on More should expand with All chains of classifications\\.$")
	public void click_on_More_should_expand_with_All_chains_of_classifications() throws Throwable {
		
	WebElement More_link=login.driver.findElement(By.xpath("//span[@class='link']"));
	if(More_link.isDisplayed()) {
		More_link.click();
		login.Log4j.info("More expands all chains of classifications");
	}
		
	else {
		login.Log4j.info("More do not  expands all chains of classifications");
	}
	}

	
	@Given("^click on Edit Chart option\\.$")
	public void click_on_Edit_Chart_option() throws Throwable {
		
	login.driver.findElement(By.xpath("//button[normalize-space(text())='Edit Chart']")).click();	
		
	   
	}

	@Given("^Click on the axis dropdown of series and choose the axis options\\.$")
	public void click_on_the_axis_dropdown_of_series_and_choose_the_axis_options() throws Throwable {
		WebElement Series=login.driver.findElement(By.xpath("(//div[@class='table--cell table--body-cell visual-series-list--series-row'])[4]"));
		action.moveToElement(Series).pause(4000).build().perform();
		
		WebElement Edit_series=login.driver.findElement(By.xpath("(//div[@title='Edit series'])[2]"));
		action.moveToElement(Edit_series).pause(3000).click().build().perform();
		WebElement MoveTo_axis=login.driver.findElement(By.xpath("//span[contains(text(),'Move to axis')]"));
		action.moveToElement( MoveTo_axis).pause(2000).build().perform();
		login.driver.findElement(By.xpath("//span[contains(text(),'Move to new Left axis')]")).click();
		List<WebElement> axis=login.driver.findElements(By.xpath("//div[@class='series-multi-axis--btn-title']"));
		
		for(int i=1;i<axis.size();i++) {
			axis.get(i).getText();
			
		}
		
		if(axis.size()>0) {
		login.Log4j.info("All four axis are present under axis dropdown");
		
	}
		else {
			login.Log4j.info("All four axis are not present under axis dropdown");
		}
	   
	}

	@Given("^user selects any Tab from China,India and Russian Federation\\.$")
	public void user_selects_any_Tab_from_China_India_and_Russian_Federation() throws Throwable {
		login.driver.findElement(By.xpath("//span[contains(text(),'All Regions')]")).click();
		WebDriverWait wait = new WebDriverWait(login.driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//div[@class='tabs__tab-item'][normalize-space()='India']")))).click();
		
		
		
	   
	}

	@Given("^selects some states=>Districts=>cities under them\\.$")
	public void selects_some_states_Districts_cities_under_them() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("(//span[@title='Andhra Pradesh'])[1]")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("(//span[normalize-space(text())='Anantapur'])[1]")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//span[@title='Dharmavaram']")).click();
		                                                                                                                               
		
	   
	}

	@Given("^clicks on Apply filter\\.$")
	public void clicks_on_Apply_filter() throws Throwable {
		login.driver.findElement(By.xpath("//div[normalize-space(text())='Apply filter']")).click();
		
	   
	}

	@Given("^select some series \\.$")
	public void select_some_series() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Series')]", 8).click();
		for (int i = 1; i <= 3; i++) {
			CommonFunctionality.getElementByXpath(login.driver,
					"(//span[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]", 8).click();

		}
	}

	@Given("^view on View on China/India/Russian Federation Map\\.$")
	public void view_on_View_on_China_India_Russian_Federation_Map() throws Throwable {
		WebElement First_Series = login.driver.findElement(By.xpath("(//div[@class='series-item-information'])[1]"));
		action.moveToElement(First_Series).pause(3000).build().perform();
		WebElement More_Actions=login.driver.findElement(By.xpath("//span[@title='More actions']"));
		 jse. executeScript("arguments[0]. click();", More_Actions);
		 WebElement View_Map = login.driver.findElement(By.xpath("//span[@title='Add chart']"));
			action.moveToElement(View_Map).pause(2000).build().perform();
		  login.driver.findElement(By.xpath("//div[contains(@class,'icon--map-filled_large')]")).click();
		CommonFunctionality.wait(2000);
	   WebElement ele=login.driver.findElement(By.xpath("//*[@class='highcharts-point highcharts-color-1']"));
	   if(ele.isDisplayed()) {
		   login.Log4j.info("Dharmavaram city is present in A.P");
	   }
	   else {
		   login.Log4j.info("Dharmavaram city is not present in A.P");
	   }
	}
	@Given("^Add into My series\\.$")
	public void add_into_My_series() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='add-to-data-selection--icon'])[1]", 8).click();
	   
	}

	@Given("^clicks on download button\\.$")
	public void clicks_on_download_button() throws Throwable {
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		login.driver.findElement(By.xpath("//div[@title='Download. Type `d`']")).click();
		login.driver.findElement(By.xpath("(//span[normalize-space(text())='Download'])[2]")).click();
		    
		
	   
	}

	@Given("^validate series Name\\.$")
	public void validate_series_Name() throws Throwable {
		String series="Gross Domestic Product: 2011-12p";
		ArrayList<String > excelHeadersdata= new ArrayList<String>();
		excelHeadersdata.add("Exports fob");
		excelHeadersdata.add("Imports cif");
		excelHeadersdata.add("GDP Index: PY=100");
		excelHeadersdata.add("VAI: YoY (Real): ytd");

		//String ss ="UPDATE(series ID:7935201, CN: (DC)Fixed Asset Inv: ytd: Real Estate, Public &amp; Consultancy Servi [UPDATE(series ID:7874301, CN: FAI: ytd: Tertiary Industry: Real Estate; No; Yes; none)]; No; Yes; none)";
	ArrayList<String > excelHeaders=valiadte_excel_headers("Name your insight");
	System.out.println("test data is"  +excelHeadersdata);
	System.out.println("Output is"  +excelHeaders);
	
	if(excelHeadersdata.equals(excelHeaders)) {
		
		System.out.println("valuea are present");
	}
	else {
		System.out.println("Not present");
	}

	

		
		
		
		
		
	}
	
	public static ArrayList<String> valiadte_excel_headers(String title)
			throws Throwable {
		ArrayList<String> excelHeaders=new ArrayList<>();
		CommonFunctionality.wait(1000);
		String path = System.getProperty("user.home") + "\\Downloads\\" + title + ".xlsx";
		File src = new File(path);
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
	
		for(int i=0;i<1;i++) {
			int noOfCOlums=sheet1.getRow(0).getPhysicalNumberOfCells();
			for(int j=0;j<noOfCOlums;j++) {
				if(i==0 && j==0) {
					
				}
				else {
				String headerVales=sheet1.getRow(i).getCell(j).getStringCellValue();
				excelHeaders.add(headerVales);
				}
				
			}
			
		}
		
	
		return excelHeaders;
	}
		
	
	public static void valiadte_excel_headers1(String title)throws Throwable {
		int obRowNo=0;
		ArrayList<String> excelHeaders=new ArrayList<>();
		CommonFunctionality.wait(1000);
		String path = System.getProperty("user.home") + "\\Downloads\\" + title + ".xlsx";
		File src = new File(path);
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		int noOfRows=sheet1.getPhysicalNumberOfRows();
		System.out.println("The number of rows are "+noOfRows);
		
		outerloop:
		for(int i=0;i<noOfRows;i++) {
			for(int j=0;j<1;j++) {
				String s1=sheet1.getRow(i).getCell(j).getStringCellValue();
				System.out.println("the value is "+s1);
				if(s1.equals("No. of Obs")) {
					System.out.println("the row num is " +i);
					obRowNo=i;
					break outerloop;
				}
			}
		}
		
		for(int k=obRowNo;k<=sheet1.getLastRowNum();k++) {
			int colno=sheet1.getRow(k).getPhysicalNumberOfCells();
			double s2=0.00;
			System.out.println("the col count is "+colno);
			for(int m=1;m<colno;m++) {
				
				 s2=sheet1.getRow(k).getCell(m).getNumericCellValue();
				
					assertFalse(s2==0.0);
				
				
				System.out.println("the nummeric values is "+s2);
			}
			
		}
	
		
		
					
	
			
			
			
	
	
	}
	
	@Given("^user searches for new series under more/sort with Dropdown\\.$")
	public void user_searches_for_new_series_under_more_sort_with_Dropdown() throws Throwable {
		
		WebElement ele = login.driver.findElement(By.xpath("(//span[@class='custom-select-title--reset-icon'])[2]"));
		if(ele.isDisplayed()) {
			ele.click();
			
		}
		
		login.driver.findElement(By.xpath("(//span[normalize-space(text())='Sort By'])[2]")).click();
		login.driver.findElement(By.xpath("//div[@class='custom-select-item--link text-dots'][normalize-space()='New Series']")).click();
		
	    
	}

	@Given("^should be able to fetch new tagged series in results\\.$")
	public void should_be_able_to_fetch_new_tagged_series_in_results() throws Throwable {
		List<WebElement> New=login.driver.findElements(By.xpath("//span[normalize-space(text())='new']")); 
		if(New.size()>0) {
			login.Log4j.info("All series are displayed with New tag");
			
		}
		
		else {
			login.Log4j.info("All series are not displayed with New tag");
		}
		
	   
	}

	
	
	@Given("^user selects more than (\\d+) series$")
	public void user_selects_more_than_series(int arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Series')]", 8).click();
		List<WebElement> ele=new ArrayList<>();
		Thread.sleep(5000);
		for(int i=0;i<5;i++) {
			 ele=login.driver.findElements(By.xpath("//div[@class='series-list-item--checkbox-wrapper']"));
				System.out.println("the size is "+ele.size());
		for(WebElement e:ele) {
			JavascriptExecutor jse=(JavascriptExecutor)login.driver;
			jse.executeScript("arguments[0].scrollIntoView(true);", e);
		e.click();
			
			
			
		}
		}
	}
	    
	

	@Given("^click on view as a chart option\\.$")
	public void click_on_view_as_a_chart_option() throws Throwable {
		WebElement First_Series = login.driver.findElement(By.xpath("(//div[@class='series-item--main-info'])[1]"));
		action.moveToElement(First_Series).pause(2000).contextClick().build().perform();
		//login.driver.findElement(By.xpath("//span[normalize-space()='View as Chart']")).click();
		 WebElement View_Map = login.driver.findElement(By.xpath("//span[@title='Add chart']"));
			action.moveToElement(View_Map).pause(2000).build().perform();
			
			
		 
		login.driver.findElement(By.xpath("//div[contains(@class,'icon--chart-area_large')]")).click();
		/*login.driver.findElement(By.xpath("//button[normalize-space(text())='Edit Chart']")).click();
		CommonFunctionality.wait(2000);
		WebElement Arrow=login.driver.findElement(By.xpath("//div[@class='type-select--icon']"));
		Arrow.click();
		login.driver.findElement(By.xpath("//span[text()='Line']")).click();
		*/
	   
	}

	@Then("^validation message should display\\.$")
	public void validation_message_should_display() throws Throwable {
		WebElement Confirmation_Popup=login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']"));
		if(Confirmation_Popup.isDisplayed()) {
			login.Log4j.info("Chart cannot be displayed with more than 30 series");
			
		}
		
		else {
			login.Log4j.info("Chart can be displayed with  30 series");
		}
	}
	@Given("^user clicks on All regions dropdown at left corner\\.$")
	public void user_clicks_on_All_regions_dropdown_at_left_corner() throws Throwable {
		login.driver.findElement(By.xpath("//span[normalize-space(text())='All Regions']")).click();
	   
	}

	@Given("^click on All Tab$")
	public void click_on_All_Tab() throws Throwable {
		CommonFunctionality.wait(5000);
		login.driver.findElement(By.xpath("//div[normalize-space(text())='All'] ")).click();
		WebElement Countries=login.driver.findElement(By.xpath("//div[@class='navigation-sidebar--navigation navigation-sidebar--navigation__show']"));
	   if(Countries.isDisplayed()) {
		   login.Log4j.info("countries are displayed");
		   
	   }
	   else {
		   login.Log4j.info("countries are not  displayed");
		   
	   }
	}
	@Given("^click on download Option\\.$")
	public void click_on_download_Option() throws Throwable {
		login.driver.findElement(By.xpath("(//span[normalize-space(text())='Download'])[1]")).click();
		login.driver.findElement(By.xpath("(//span[normalize-space(text())='Download'])[3]")).click();
		
		
		
		
		
		
	   
	}

	@Given("^should not show blank observations for Heat Map\\.$")
	public void should_not_show_blank_observations_for_Heat_Map() throws Throwable {
		valiadte_excel_headers1("Series");
	   
	}

	    
	}

	
	
