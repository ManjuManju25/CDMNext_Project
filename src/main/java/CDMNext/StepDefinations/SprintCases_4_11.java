package CDMNext.StepDefinations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SprintCases_4_11 {
	SprintCases_4_7 s7=new SprintCases_4_7();
	Sprintcases_4_6 s6=new Sprintcases_4_6();
	Sprintcases_4_9 s9=new Sprintcases_4_9();
	Map c1=new Map();
	JavascriptExecutor js=(JavascriptExecutor)login.driver;
	Actions action =new Actions(login.driver);
	@And("^add a single quote in first name and last name$")
	public void add_a_single_quote_in_first_name_and_last_name() throws Throwable {
		Thread.sleep(2000);
		// click on first name
		login.driver.findElement(By.name("first_name")).click();
		Thread.sleep(1000);
		// enter first name
		login.driver.findElement(By.name("first_name")).sendKeys("'");

		// click on last name
		login.driver.findElement(By.name("last_name")).click();

		// enter last name
		login.driver.findElement(By.name("last_name")).sendKeys("'");
		login.driver.findElement(By.xpath("//input[@name='job_title']")).click();
		login.driver.findElement(By.xpath("//input[@name='job_title']")).clear();
		login.driver.findElement(By.xpath("//input[@name='job_title']")).sendKeys("ahsguas",Keys.ENTER);
		login.driver.findElement(By.xpath("(//span[@class='select2-arrow'])[1]")).click();
		login.driver.findElement(By.xpath("//div[contains(text(),'Business Planner / Advisor')]")).click();
		

	}
	@And("^double click on any one attribute on table$")
	public void double_click_on_any_one_attribute_on_table() throws Throwable {
		Thread.sleep(2000);
		try {
			WebElement attribute = login.driver.findElement(By.xpath("//th[contains(text(),'India')]"));
			action.doubleClick(attribute).build().perform();
		}

		catch (org.openqa.selenium.StaleElementReferenceException ex) {
			WebElement attribute = login.driver.findElement(By.xpath("//th[contains(text(),'India')]"));
			action.doubleClick(attribute).build().perform();
		}

	}
	@And("^'Series Remarks and Suggestions' check box checked$")
	public void series_Remarks_and_Suggestions_check_box_checked() throws Throwable {
		Thread.sleep(2000);
		//login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("(//*[@class='input-control--indicator'])[1]")).click();

		// close the popup
		login.driver.findElement(By.xpath("//*[@class='popover--close']")).click();

	}
	@And("^click on Download button in right side header$")
	public void click_on_Download_button_in_right_side_header() throws Throwable {

		Thread.sleep(2000);
		if (login.driver.findElements(By.xpath("//*[contains(text(),'Series Remarks')]")).size() == 1) {
			if (login.driver.findElements(By.xpath("//*[contains(text(),'Suggestions')]")).size() == 1) {
				System.out.println("Series Remarks and Suggestions' attribute should be display");
			}
		}

		else {
			Assert.fail();
		}

		login.driver.findElement(By.xpath("(//*[contains(text(),'Download')])[1]")).click();

		login.driver.findElement(By.xpath(
				"//*[@class='sphere-modal-control button insight-download__modal-button button button__download-btn']"))
				.click();

		Thread.sleep(10000);

	}
	@Then("^'Series Remarks and Suggestions' attributes should displayed to table visual and should displayed in download table$")
	public void series_Remarks_and_Suggestions_attributes_should_displayed_to_table_visual_and_should_displayed_in_download_table()
			throws Throwable {
		Thread.sleep(10000);
		WebElement table = login.driver.findElement(By.xpath("//th[contains(text(),'[COVID-19-IMPACT]')]"));

		WebElement table1 = login.driver.findElement(By.xpath("//th[contains(text(),'Series Remarks')]"));

		WebElement table2 = login.driver
				.findElement(By.xpath("//tr[@class=' heading']//*[contains(text(),'Suggestions')]"));

		WebElement table3 = login.driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div[1]/table[1]/thead[1]/tr[18]/th[2]"));

	System.out.println(table3.getText().toString());
		
		//System.getProperty("user.dir")  + "\\Testdata\\" +x+ ".xlsx");
		
		//String excelFilepath = ("user.dir")+"//Import of Goods and Services.xlsx";
		//String excelFilepath = ("user.home")+"//Downloads//Import of Goods and Services.xlsx";
		
		String excelFilepath = "C://Users//tbemineni//Downloads//Import of Goods and Services.xlsx";
		
		// File file = new File(System.getProperty("user.home") + "\\Downloads\\Seriesname.xlsx");
		//FileInputStream file = new FileInputStream(excelFilepath);
		
		FileInputStream file = new FileInputStream(excelFilepath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Table");

		int rows = sheet.getLastRowNum();
		System.out.println(rows);
		// int cols=sheet.getRow(1).getLastCellNum();

		/*for (int r = 1; r <= rows; r++) {

			//System.out.println("starting from for loop");
			XSSFComment tableval = sheet.getRow(r).getCell(1).getCellComment();
			if (tableval.toString().equalsIgnoreCase(table1.getText().toString())) {

				if (table.getText().toString().equalsIgnoreCase(sheet.getRow(r).getCell(1).getStringCellValue())) {

					System.out.println("Series Remarks attribute should displayed to Download Excel visual");

				}

			}

			else if (tableval.toString().equalsIgnoreCase(table2.getText().toString())) {

				if (table3.getText().toString().equalsIgnoreCase(sheet.getRow(r).getCell(0).getStringCellValue())) {

					System.out.println("Suggestions'attribute should displayed to Download Excel visual");

					break;

				}

			}

		}*/

	}
	@And("^Search \"([^\"]*)\" in search panel$")
	public void search_in_search_panel(String arg1) throws Throwable {

		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//*[@class='search-input-text']")).click();

		login.driver.findElement(By.xpath("//*[@class='search-input-text']")).sendKeys(arg1);
		Thread.sleep(500);
		login.driver.findElement(By.xpath("//div[@class='search-suggestions-key']")).click();

	}
	@Then("^Result should be displayed for EU search$")
	public void result_should_be_displayed_for_EU_search() throws Throwable {
		Thread.sleep(2000);

		try {
			login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
			Thread.sleep(2000);
			// 1st series in series list
			WebElement mouseover = login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"));
			action.moveToElement(mouseover).pause(500).build().perform();
			login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]")).click();

			String region = login.driver
					.findElement(By.xpath("//div[@class='series-location-panel-item main-series-information--link']"))
					.getText();

			System.out.println("Region:" + region);

			if (region.equals("European Union")) {
				System.out.println("Result should be displayed for EU search");
			} else {
				Assert.fail();
			}

		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
			// 1st series in series list
			WebElement mouseover = login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"));
			action.moveToElement(mouseover).pause(500).build().perform();
			login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]")).click();

			String region = login.driver
					.findElement(By.xpath("//div[@class='series-location-panel-item main-series-information--link']"))
					.getText();

			System.out.println("Region:" + region);

			if (region.equals("European Union")) {
				System.out.println("Result should be displayed for EU search");
			} else {
				Assert.fail();
			}

		}

	}
	
	@And("^Select a series and click on Group and mouse hover on group name$")
	public void select_a_series_and_click_on_Group_and_mouse_hover_on_group_name() throws Throwable {
		Thread.sleep(1000);

		// get the series name
		String seriesname = login.driver.findElement(By.xpath("//*[@class='group-name']")).getText();
		System.out.println("seriesname:" + seriesname);

		// right click on group series name
		WebElement sname = login.driver.findElement(By.xpath("//*[@class='group-name']"));
		action.moveToElement(sname).pause(500).build().perform();
		action.contextClick(sname).build().perform();

		// mouseover on the group
		WebElement group = login.driver.findElement(By.xpath("//span[@class='name-li'][contains(text(),'Group')]"));
		action.moveToElement(group).pause(500).build().perform();
		Thread.sleep(2000);

		// mouse over on the add to group popup
		
		// addto.click();

	}
	@Then("^Should be able to save first name and last name with single quote$")
	public void should_be_able_to_save_first_name_and_last_name_with_single_quote() throws Throwable {
		Thread.sleep(2000);

		String firstndLastname = login.driver.findElement(By.xpath("//div[@class='profile-menu--name text-dots']"))
				.getText();

		System.out.println("firstndLastname:" + firstndLastname);
		if (firstndLastname.contains("'")) {
			System.out.println("Should be able to save first name and last name with single quote");
		} else {
			Assert.fail();
		}

	}

	
	@And("^click on More button$")
	public void click_on_More_button() throws Throwable {
	    
		
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'More')]")).click();
		
	}

	@And("^checked \"([^\"]*)\" checkbox and click on apply filter$")
	public void checked_checkbox_and_click_on_apply_filter(String arg1) throws Throwable {
	    
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[@title='With historical extension of continuous series']")).click();
		
		
		login.driver.findElement(By.xpath("//div[@class='button__primary button button__primary']")).click();
		
		
		
		
		
		
	}

	@And("^Right click on series and mouse over the 'Add'$")
	public void right_click_on_series_and_mouse_over_the_Add() throws Throwable {
	    
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//div[@title='View results as List']")).click();

		WebElement rightclick = login.driver.findElement(By.xpath("(//*[@class='series-list-item--checkbox svg-checkbox'])[1]"));
		rightclick.click();
		action.contextClick(rightclick).perform();
		Thread.sleep(2000);;
		login.driver.findElement(By.xpath("//span[@title='Add']")).click();

		Thread.sleep(3000);
		
		
		
		
		
	}

	@Then("^should be able to see \"([^\"]*)\" menu$")
	public void should_be_able_to_see_menu(String arg1) throws Throwable {
	    
		 String text=login.driver.findElement(By.xpath("//span[@title='Add as continuous series']")).getText().toString();
		
		
		if(text.equalsIgnoreCase("Add as continuous series"))
		{
			
			System.out.println("Add as continuous series menu displayed");
		}
		else {
			System.out.println("Add as continuous series menu  NOT displayed");
		}
		

	}
	@And("^Open any series with C icon$")
	public void open_any_series_with_C_icon() throws Throwable {
	    
		Thread.sleep(4000);
		 login.driver.findElement(By.xpath("//div[@title='View results as List']")).click();
		 Thread.sleep(5000);
		
		action.moveToElement(login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"))).click().perform();
		
		
	}

	@And("^Check for continuous checkbox in SSP window$")
	public void check_for_continuous_checkbox_in_SSP_window() throws Throwable {
		
		Thread.sleep(6000);
		login.driver.findElement(By.xpath("//span[@class='input-control--description']")).click();
		
		Thread.sleep(2000);
		
	   
	}

	@Then("^Series should be shown with all contributed series for one continuous series to be made$")
	public void series_should_be_shown_with_all_contributed_series_for_one_continuous_series_to_be_made() throws Throwable {
		
		Thread.sleep(2000);
		List<WebElement>list=login.driver.findElements(By.xpath("//div[@class='legend-drilldown--prefix']"));
		
		for(WebElement data:list)
		{
			if(data.getText().contains("Continuous"))
			{
				System.out.println("Continuous series displayed");
			}
			else {
				System.out.println("Continuous series not dsplayed");
			}
		}
		
	
		
	}

	@Given("^Add (\\d+) series into an insight$")
	public void add_series_into_an_insight(int arg1) throws Throwable {
		Thread.sleep(4000);
		login.driver.findElement(By.xpath("//span[text()='Series']")).click();
		Thread.sleep(2000);
		
		for(int i=1;i<=2;i++)
		{
		login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])["+i+"]")).click();
		}
		Thread.sleep(1000);
		///WebElement series=
				login.driver.findElement(By.xpath("(//div[@class='add-to-data-selection--icon'])[1]")).click();
		
		//series.sendKeys(Keys.CONTROL);
		//series.sendKeys("A");
		Thread.sleep(2000);
		
		
		
		
		
		
	}
	@And("^Apply \"([^\"]*)\" function$")
	public void apply_function(String arg1) throws Throwable {
		Thread.sleep(3000);
		//checked check box
		login.driver.findElement(By.xpath("(//span[@class='input-control--indicator'])[11]")).click();
		Thread.sleep(2000);
		
		//click on function 
		login.driver.findElement(By.xpath("//div[@class='function-editor-window--icon']")).click();
		Thread.sleep(1000);
		
		
		//click on by function
		login.driver.findElement(By.xpath("//div[@class='function-mode-switcher--button']")).click();
		
		Thread.sleep(2000);
		//search i/p
		login.driver.findElement(By.xpath("//input[@class='form--control search-functions-input']")).sendKeys(arg1);
		Thread.sleep(2000);
	 WebElement doubleclick=login.driver.findElement(By.xpath("//div[@class='function-item']"));
		//Double Click the button
	 action.doubleClick(doubleclick).perform();
	 Thread.sleep(2000);
	}

	
	@Given("^Check the function description$")
	public void check_the_function_description() throws Throwable {
		
		Thread.sleep(2000);
		String data=login.driver.findElement(By.xpath("//span[@id='select2-chosen-4']")).getText();
		
		if(data.contains("series ID"))
		{
			System.out.println("series id and series name displayed in description");
			login.Log4j.info("series id and series name displayed in description");
		}
		else {
			System.out.println("series id and series name not displayed in description");
			login.Log4j.info("series id and series name not displayed in description");
		}

		
		
	}
	@Given("^Open more filter$")
	public void open_more_filter() throws Throwable {
	   
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'More')]")).click();
		
		
		
	}

	@Given("^Verify text for c series$")
	public void verify_text_for_c_series() throws Throwable {
	    Thread.sleep(2000);
		
	   String text= login.driver.findElement(By.xpath("(//span[@class='status-icon--sign'])[5]")).getText();
	    
	   if(text.equalsIgnoreCase("c"))
	   {
		   login.Log4j.info("Text series C displayed"); 
	   }
	   else {
		   login.Log4j.info("Text series C not displayed"); 
	   }
	    
		
	}
	@And("^Checked \"([^\"]*)\" check box and click on Apply filter$")
	public void checked_check_box_and_click_on_Apply_filter(String arg1) throws Throwable {
	   Thread.sleep(2000);
	   login.driver.findElement(By.xpath("//span[@title='With historical extension of continuous series']")).click();
	   Thread.sleep(2000);
	   login.driver.findElement(By.xpath("//div[@class='button__primary button button__primary']")).click();
	 
	   login.driver.findElement(By.xpath("//input[@class='search-input-text']")).clear();
	   
	   
	}
	@Then("^It should be \"([^\"]*)\"$")
	public void it_should_be(String arg1) throws Throwable {
	   
		Thread.sleep(2000);
		
		 String text= login.driver.findElement(By.xpath("(//span[@class='status-icon--sign'])[5]")).getText();
		    
		   if(text.equalsIgnoreCase("c"))
		   {
			   login.Log4j.info("Text series C displayed"); 
		   }
		   else {
			   login.Log4j.info("Text series C not displayed"); 
		   }
		
		
	}

	// TC_19487_01
	@Then("^verify Tooltip should displayed with full group name$")
	public void verify_Tooltip_should_displayed_with_full_group_name() throws Throwable {

		String fullsname = login.driver.findElement(By.xpath("(//span[@class='input-control--description'])[7]"))
				.getText();
		System.out.println("fullsname:" + fullsname);
		System.out.println("Enter into final scenario");

	}
	@And("^Select some series from different region \"([^\"]*)\"$")
	public void select_some_series_from_different_region(String str) throws InterruptedException
	{
		s7.Search_for_series_in_layout(str);
	}


	@And("^Create any visual1$")
	public void create_any_visual1() throws InterruptedException
	{
		Thread.sleep(6000);
		s6.Select_series1();
		
		for(int i=1;i<=4;i++)
		{
			Thread.sleep(4000);
	       login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])["+i+"]")).click();
		}
		Thread.sleep(1000);
		action.contextClick().build().perform();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//span[contains(text(),'View as Chart')]")).click();
		
	}
	@Given("^Search for random word like \"([^\"]*)\" Which yields no search results$")
	public void search_for_random_word_like_Which_yields_no_search_results(String arg1) throws Throwable {
	   
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).clear();
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(arg1);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	@Given("^Save button should not be shown$")
	public void save_button_should_not_be_shown() throws Throwable {
	   
		Thread.sleep(2000);
		
			
			if(login.driver.findElement(By.xpath("//div[@class='dropdown save-search-dropdown']")).isDisplayed())
			{
				System.out.println("FAIL");
				login.Log4j.info("Save button should be shown:FAIL"); 
			}
			else {
				System.out.println("PASS");
				login.Log4j.info("Save button should not be shown:PASS"); 
			}
		
		
		
	}

	
	
	@And("^check \"([^\"]*)\"should be shown$")
	public void check_should_be_shown(String arg1) throws Throwable {
	    
		Thread.sleep(2000);
		
		 String data=login.driver.findElement(By.xpath("//span[@title='With historical extension of continuous series']")).getText();
		if(data.equalsIgnoreCase(arg1))
		{
			login.Log4j.info("historical extension of series should be seen"); 
		}
		else {
			login.Log4j.info("historical extension of series should not be seen"); 
		}
		
		
	}

	

	
	
	@Then("^series which are continuous should be shown with C icon infront of series name$")
	public void series_which_are_continuous_should_be_shown_with_C_icon_infront_of_series_name() throws Throwable {
		Thread.sleep(2000);
		
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).clear();
		login.driver.findElement(By.xpath("//span[@class='searches-manager--reset-button button button__sm button__warning']")).click();
		
		Thread.sleep(4000);
		 String value=login.driver.findElement(By.xpath("(//span[@class='status-icon--sign'])[1]")).getText();
		
		if(value.equalsIgnoreCase("c"))
		{
			
			login.Log4j.info("C icon infront of series name shown"); 
			
		}
		else {
			login.Log4j.info("C icon infront of series name not shown");
			
		}
		
	}

	
	
	@Then("^Time period should change to All by default$")
	public void time_period_should_change_to_All_by_default() throws Throwable {
	   
		Thread.sleep(5000);
		
		if(login.driver.findElement(By.xpath("//button[@class='zoom-button button button__sm zoom-button__selected']")).isSelected())
		{
			login.Log4j.info("Time period should change to All:PASS"); 
		}
		
		else {
			login.Log4j.info("Time period should change to All:FAIL"); 
		}
		
		
	}

	
	


	

	@And("^click on any one continues series and click on continuous series details$")
	public void click_on_any_one_continues_series_and_click_on_continuous_series_details() throws Throwable {
	   
		Thread.sleep(2000);
		
		login.driver.findElement(By.xpath("(//div[@class='legend-drilldown--prefix']//following::span)[1]")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("(//div[@class='breakdown-preview--drilldown'])[2]")).click();
		
		Thread.sleep(2000);
		login.driver.switchTo().activeElement();
		Thread.sleep(2000);
		
		login.driver.findElement(By.xpath("(//span[@js-series-action='open_info'])[5]")).click();
		
	
//		List<WebElement>data=login.driver.findElements(By.xpath("//span[@js-series-action='open_info']"));
//		System.out.println(data.size());
//		
//		for(int i=1;i<data.size();i++)
//		{
//			System.out.println(data.get(i).getText());
//			
//			data.get(i).click();
//			
//		}
		
	}

	
	@Then("^check open ssp of continuous series present in SSP opened$")
	public void check_open_ssp_of_continuous_series_present_in_SSP_opened() throws Throwable {
	   Thread.sleep(6000);
		String text=login.driver.findElement(By.xpath("//div[@class='series-changes-time-line--status series-changes-time-line--status__discontinued']")).getText();
		
		if(text.equalsIgnoreCase("Discontinued"))
		{
			login.Log4j.info("SSP of continues series present in SSP opened:PASS"); 
		}
		else {
			
			login.Log4j.info("SSP of continues series not present in SSP opened:FAIL"); 
		}
		
		
	}
	

	
	

	
	
	

	
	
	
	@And("^Create country filter on same view$")
	public void create_country_filter_on_same_view() throws Throwable
	{
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='icon--filter']")).click();
	}
	@And("^Select any one region from country filter$")
	public void select_any_one_region_from_country_filter() throws InterruptedException
	{
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);",login.driver.findElement(By.xpath("//span[contains(text(),'All countries')]")));
		login.driver.findElement(By.xpath("//span[contains(text(),'All countries')]")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//input[@name='IN']/following::span[1]")).click();
		
	}
	@And("^Open insight in view mode$")
	public void open_insight_in_view_mode()
	{
		login.driver.findElement(By.xpath("//div[@class='insight-context-menu--menu-icon']")).click();
		login.driver.findElement(By.xpath("//span[@title='View']")).click();
	}
	@And("^Select or unselect region in country filter$")
	public void select_or_unselect_region_in_country_filter()
	{
		login.driver.switchTo().activeElement();
		login.driver.findElement(By.xpath("(//div[@class='custom-select-title--handler icon--filter-arrow'])[4]")).click();
		login.driver.findElement(By.xpath("//input[@name='CN']/following::span[1]")).click();
		
		login.driver.findElement(By.xpath("//div[@class='insight-preview--close']")).click();
		
		
	}
	@Then("Add as continuous to my series$")
	public void add_as_continuous_to_my_series()
	{
		List<WebElement>list=login.driver.findElements(By.xpath("//div[@class='legend-drilldown--prefix']"));
		for(WebElement l1:list)
		{
			String str=l1.getText().toString();
			login.driver.findElement(By.xpath("//div[contains(text(),'"+str+"')]/following::div[@class='legend-drilldown--link'][1]")).click();
			login.driver.findElement(By.xpath("//div[@title='Close']")).click();
			
		}
	}
	@And("^select series with applied function$")
	public void select_series_with_applied_function() throws InterruptedException
	{
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("(//span[@class='input-control--indicator'])[11]")).click();
		login.driver.findElement(By.xpath("//span[@class='table-container--checkbox svg-checkbox input-control__grey']")).click();
		//login.driver.findElement(By.xpath("//div[@title='Show the function bar']")).click();
		if(login.driver.findElement(By.xpath("//div[@class='toggle-favorite-control--icon']")).isDisplayed())
		{
			System.out.println("displayed");
		}
		
	}
	@And("Select a series with gap \"([^\"]*)\"$")
	public void select_a_series_with_gap(String str) throws InterruptedException
	{
		if(login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).isDisplayed())
		{
			login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		
		   login.driver.findElement(By.xpath("//div[@data-action='delete']")).click();
		}
		s7.Search_for_series_in_layout(str);
		Thread.sleep(4000);
		login.driver.findElement(By.xpath("//div[@title='View results as List']")).click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[1]")).click();
	}
	@Then("^Click on download button with fill observations as (\\d+) click ok$")
	public void click_on_download_button_with_fill_obeservations_as_click_ok(int z) throws InterruptedException, Throwable
	{
		Thread.sleep(2000);
		
		action.sendKeys((Keys.chord("c"))).build().perform();
		login.driver.findElement(By.xpath("//span[contains(text(),'Download')]")).click();
		login.driver.switchTo().activeElement();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//input[@name='observations_count']")).clear();
		login.driver.findElement(By.xpath("//input[@name='observations_count']")).sendKeys("4",Keys.ENTER);
		login.driver.findElement(By.xpath("(//div[@class='context-menu-control--icon'])[2]")).click();
		login.driver.findElement(By.xpath("//span[contains(text(),'Fill with "+z+"')]")).click();
		login.driver.findElement(By.xpath("(//span[contains(text(),'Download')])[3]")).click();
		Thread.sleep(4000);
		String path2 = "C:\\Users\\tbemineni\\Downloads\\DCInsurance Industry Long Term Investment The People Insurance of China.xlsx";
		 
	        XSSFWorkbook test = new XSSFWorkbook(path2); 
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
	            System.out.println();
	        }
	    }  
	@And("^Create any pie chart and set number of pie to seen as (\\d+),(\\d+),(\\d+)$")
	public void create_any_pie_chart_and_set_number_of_pie_to_seen_as(int a,int b,int c) throws Throwable
	{
		create_pie_chart();
		 login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		 
		
	}
	@And("^Switch from smaller to bigger number of pie will inherit time period as default pie$")
	public void switch_from_smaller_to_bigger_number_of_pie_will_inherit_time_period_as_default_pie() throws InterruptedException
	{
		 login.driver.findElement(By.xpath("(//button[contains(text(),'4')])")).click();
		 for(int i=1;i<=4;i++)
		 {
			 Thread.sleep(2000);
		 login.driver.findElement(By.xpath("(//div[@class='datepicker-input-wrapper--icon icon--calendar'])["+i+"]")).click();
			String str=login.driver.findElement(By.xpath("//span[@class='year active focused']")).getText().toString();
			System.out.println(str);
		 }
	}
	@And("^switch from bigger to smaller number of pie will keep the left top corner of pie as default \"([^\"]*)\" \"([^\"]*)\"$")
	public void switch_from_bigger_to_smaller_number_of_pie_wil_keep_the_left_top_corner_of_pie_as_default(String str,String str1) throws InterruptedException
	{
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("(//button[contains(text(),'2')])")).click();
		login.driver.findElement(By.xpath("(//div[@class='datepicker-input-wrapper--icon icon--calendar'])[2]")).click();
		 Thread.sleep(2000);
			login.driver.findElement(By.xpath("(//span[contains(text(),'Q2')])[1]")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("(//button[@title='Save period'])")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//button[contains(text(),'Edit Pie')]")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@class='style-container--palette']//div[@class='context-menu-control--icon']")).click();
			login.driver.findElement(By.xpath("//div[@class='color-palette-context']//div/span[@style='background-color:#59A839']")).click();
		Thread.sleep(4000);
		login.driver.findElement(By.xpath("(//button[contains(text(),'Save')])[2]")).click();
			
	}
	
	
	@And("^Add some series into my series$")
	public void add_some_deried_into_my_series() throws InterruptedException
	{
		s9.create_new_insight1();
		Thread.sleep(4000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
		Thread.sleep(2000);
		for(int i=1;i<=20;i++)
		{
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])["+i+"]")).click();
			
		}
		 action.sendKeys((Keys.chord("a"))).build().perform();
		
	}
	@And("^Apply them into different functions to make them as favorite by clicking on starred icon beside functions applied in function bar \"([^\"]*)\"$")
	public void apply_them_into_different_function(String str) throws InterruptedException
	{
		String data[]=str.split(";");
		for(int i=1;i<=10;i++)
		{
			Thread.sleep(3000);
		action.moveToElement(login.driver.findElement(By.xpath("(//span[@class='series-name-field-title'])["+i+"]"))).build().perform();
		Thread.sleep(4000);
		login.driver.findElement(By.xpath("(//div[@title='Apply Function'])["+i+"]")).click();
		login.driver.findElement(By.xpath("//span[@class='popular-functions-context--all-icon']")).click();
		 login.driver.findElement(By.xpath("//div[contains(text(),'By function')]")).click();
		 Thread.sleep(4000);
		 login.driver.findElement(By.xpath("//input[@class='form--control search-functions-input']")).click();
		 login.driver.findElement(By.xpath("//input[@class='form--control search-functions-input']")).sendKeys(data[i-1]);
		 action.moveToElement(login.driver.findElement(By.xpath("//div[contains(text(),'"+data[i-1]+"')]"))).doubleClick().perform();
		// login.driver.findElement(By.xpath("(//div[@class='toggle-favorite-control--icon'])[2]")).click();
		 login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		}
	}
	@Then("^click on fx symbol to go to favorited functions popup$")
	public void click_on_fx_symbol_to_go_to_favorited_functions_popup() throws InterruptedException
	{
		Thread.sleep(3000);
		action.moveToElement(login.driver.findElement(By.xpath("(//span[@class='series-name-field-title'])[1]"))).build().perform();
		login.driver.findElement(By.xpath("//div[@title='Apply Function']")).click();
		List<WebElement>l1=login.driver.findElements(By.xpath("(//div[@class='popular-functions-context--category-content'])[5]//span[@class='series-function-item--name']"));
		for(WebElement l:l1)
		{
			System.out.println(l.getText().toString());
		}
		List<WebElement>l2=login.driver.findElements(By.xpath("(//div[@class='popular-functions-context--category-content'])[6]//span[@class='series-function-item--name']"));
		for(WebElement l:l2)
		{
			System.out.println(l.getText().toString());
		}
		
	}
	 @And("^Create pie chart$")
	 public void create_pie_chart() throws Throwable
	 {
		 s9.create_new_insight1();
			Thread.sleep(4000);
			login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
			for(int i=1;i<=5;i++)
			{
				login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])["+i+"]")).click();
				
			}
			action.contextClick().build().perform();
			action.moveToElement(login.driver.findElement(By.xpath("//span[contains(text(),'View as ...')]"))).click().perform();
			action.moveToElement(login.driver.findElement(By.xpath("//span[contains(text(),'Pie')]"))).click().perform();
	 }
	 @And("^Update pie chart date picker controls for multiple pie in single pie according to frequency of series$")
	 public void update_pie_chart_date_picker_controls_for_multiple_pie_in_single_pie_according_to_frequency_of_series() throws InterruptedException
	 {
		 login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		 login.driver.findElement(By.xpath("(//button[contains(text(),'4')])")).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath("(//div[@class='datepicker-input-wrapper--icon icon--calendar'])[2]")).click();
		 Thread.sleep(2000);
			login.driver.findElement(By.xpath("(//span[contains(text(),'Q4')])[1]")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("(//button[@title='Save period'])")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("(//button[contains(text(),'2')])")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("(//div[@class='datepicker-input-wrapper--icon icon--calendar'])[2]")).click();
			String str=login.driver.findElement(By.xpath("//span[@class='month focused active']")).getText().toString();
			System.out.println(str);
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("(//button[contains(text(),'4')])")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("(//div[@class='datepicker-input-wrapper--icon icon--calendar'])[3]")).click();
			 str=login.driver.findElement(By.xpath("//span[@class='month focused active']")).getText().toString();
			System.out.println(str);
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("(//div[@class='datepicker-input-wrapper--icon icon--calendar'])[4]")).click();
			 str=login.driver.findElement(By.xpath("//span[@class='month focused active']")).getText().toString();
			System.out.println(str);
			
			
			
		 
		 
	 }
	 
	 @And("^Create multiple pie in single pie visual$")
	 public void create_multiple_pie_in_single_pie_visual() throws Throwable
	 {
		 create_pie_chart();
		
		 login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		 
	 }
	
	
	@And("^set different date pickers for each and download to excel \"([^\"]*)\"$")
	public void set_different_date_pickers_for_each_and_download_to_excel(String str) throws Throwable
	{
		String data[]=str.split(";");
		login.driver.findElement(By.xpath("(//button[contains(text(),'4')])")).click();
		for(int i=1;i<=4;i++)
		{
			Thread.sleep(2000);
		login.driver.findElement(By.xpath("(//div[@class='datepicker-input-wrapper--icon icon--calendar'])["+i+"]")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("(//span[contains(text(),'"+data[i-1]+"')])[1]")).click();
		
	   }
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("(//button[@title='Save period'])")).click();
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("(//span[contains(text(),'Download')])")).click();
		Thread.sleep(2000);
		login.driver.switchTo().activeElement();
		login.driver.findElement(By.xpath("(//span[contains(text(),'Download')])[5]")).click();
		Thread.sleep(40000);
		
	}
}
		
		
	

