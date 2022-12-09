package CDMNext.StepDefinations;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.testng.Assert;


import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class UserVisibilityCases extends CommonFunctionality {
	@Given("^user clicks on Data/Analysis/comparables/Releases/Watchlist$")
	public void user_clicks_on_Data_Analysis_comparables_Releases_Watchlist() throws Throwable {
		login.driver.findElement(By.xpath("//span[normalize-space(text())='Data']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//span[normalize-space(text())='Analysis']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//span[normalize-space(text())='Comparables']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//span[normalize-space(text())='Releases']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//span[normalize-space(text())='Watchlist']")).click();
		
		
		
	    
	}

	@Given("^should be able to switch to respective tabs\\.$")
	public void should_be_able_to_switch_to_respective_tabs() throws Throwable {
		String data=login.driver.findElement(By.xpath("//span[normalize-space(text())='Data']")).getText();
		System.out.println("==data======"+data);
		Assert.assertEquals(data, "Data");
		String analysis=login.driver.findElement(By.xpath("//span[normalize-space(text())='Analysis']")).getText();
		Assert.assertEquals(analysis, "Analysis");
		String comparables=login.driver.findElement(By.xpath("//span[normalize-space(text())='Comparables']")).getText();
		Assert.assertEquals(comparables, "Comparables");
		String releases=login.driver.findElement(By.xpath("//span[normalize-space(text())='Releases']")).getText();
		Assert.assertEquals(releases, "Releases");
		String watchlist=login.driver.findElement(By.xpath("//span[normalize-space(text())='Watchlist']")).getText();
		Assert.assertEquals(watchlist, "Watchlist");
		
		
	    
	}

	@Given("^user clicks on Data Tab$")
	public void user_clicks_on_Data_Tab() throws Throwable {
		WebElement DataTab=login.driver.findElement(By.xpath("//span[normalize-space(text())='Data']"));
		jse.executeScript("arguments[0].click();", DataTab);

	   
	}

	@Given("^switch to Database/Series/Datasets/User data$")
	public void switch_to_Database_Series_Datasets_User_data() throws Throwable {
		WebElement Databases=login.driver.findElement(By.xpath("//span[normalize-space(text())='Databases']"));
		if(Databases.isDisplayed()) {
			Databases.click();
			login.Log4j.info("The Databases is displayed and switched to respctive tab");
		}
		else {	
			login.Log4j.info("The Databases is not displayed");
		}
	   
		WebElement SeriesTab=login.driver.findElement(By.xpath("//span[normalize-space(text())='Series']"));
		
		if(SeriesTab.isDisplayed()) {
			SeriesTab.click();
			login.Log4j.info("The Series is displayed and switched to respctive tab");
		}
		else {	
			login.Log4j.info("The Series is not displayed");
		}
		WebElement DatasetsTab=login.driver.findElement(By.xpath("//span[normalize-space(text())='Datasets']"));
		
		if(DatasetsTab.isDisplayed()) {
			DatasetsTab.click();
			login.Log4j.info("The DatasetsTab is displayed and switched to respctive tab");
		}
		else {	
			login.Log4j.info("The DatasetsTab is not displayed");
		}
		WebElement User_DataTab=login.driver.findElement(By.xpath("//span[normalize-space(text())='Imported']"));
		
		if(User_DataTab.isDisplayed()) {
			User_DataTab.click();
			login.Log4j.info("The User_DataTab is displayed and switched to respctive tab");
		}
		else {	
			login.Log4j.info("The User_DataTab is not displayed");
		}
		
	}
	@Given("^user clicks on open and close icon for Databriefings Panel$")
	public void user_clicks_on_open_and_close_icon_for_Databriefings_Panel() throws Throwable {
		try {
		WebElement Expand_Databriefings=login.driver.findElement(By.xpath("//div[@title='Expand Briefings']"));
		if(Expand_Databriefings.isDisplayed()) {
			Expand_Databriefings.click();
			CommonFunctionality.wait(20000);
			login.Log4j.info("The Datariefings is moved to expanded state");
		}
		}catch (Exception e) {
			login.Log4j.info("The Datariefings is in closed  mode ");	
		}
	   
	}

	@Given("^Databriefings Panel should be open and closed\\.$")
	public void databriefings_Panel_should_be_open_and_closed() throws Throwable {
		
		WebElement Close_Databriefings=login.driver.findElement(By.xpath("//div[@title='Collapse Briefings']"));
		if(Close_Databriefings.isDisplayed()) {
			
			Close_Databriefings.click();
			CommonFunctionality.wait(20000);
			login.Log4j.info("The Datariefings is in closed state");
			
		}
		else {
			login.Log4j.info("The Datariefings is in open state");
		}
	}
	@Given("^user clicks on expand icon for search panel$")
	public void user_clicks_on_expand_icon_for_search_panel() throws Throwable {
	   
		WebElement Expand_SearchIcon=login.driver.findElement(By.xpath("(//div[@class='panel-expander--icon panel-expander--icon__right'])[1]"));
		if(Expand_SearchIcon.isDisplayed()) {
			CommonFunctionality.wait(2000);
			Expand_SearchIcon.click();
			login.Log4j.info("The Search Icon is expanded");
		}
		else {
			login.Log4j.info("The Search Icon is not expanded");
		}
	}

	@Given("^clicks on expand views\\.$")
	public void clicks_on_expand_views() throws Throwable {
		WebElement Expand_leftSearchIcon=login.driver.findElement(By.xpath("(//div[@class='panel-expander--icon panel-expander--icon__left'])[4]"));
		if(Expand_leftSearchIcon.isDisplayed()) {
			CommonFunctionality.wait(2000);
			Expand_leftSearchIcon.click();
			login.Log4j.info("The Search Icon is expanded to left");
			
		}
		else {
			login.Log4j.info("The Search Icon is not moved to normal state");
		}
	    
	}
	@Given("^user clicks on expand icon\\(<<\\) for view  panel$")
	public void user_clicks_on_expand_icon_for_view_panel() throws Throwable {
		WebElement Expand_views=login.driver.findElement(By.xpath("(//div[@class='panel-expander--icon panel-expander--icon__left'])[2]"));
		if(Expand_views.isDisplayed()) {
			CommonFunctionality.wait(2000);
			Expand_views.click();
			login.Log4j.info("The Expand view icon is expanded");
		}
		else {
			login.Log4j.info("The Expand view icon is not expanded");
		}
	}

	@Given("^clicks on expand search\\(>>\\)\\.$")
	public void clicks_on_expand_search() throws Throwable {
		WebElement collapse_views=login.driver.findElement(By.xpath("(//div[@class='panel-expander--icon panel-expander--icon__right'])[2]"));
		if(collapse_views.isDisplayed()) {
			CommonFunctionality.wait(2000);
			collapse_views.click();
			login.Log4j.info("The Expand view icon is changed to collapsed state");
		}
		else {
			login.Log4j.info("The Expand view icon is changed to collapsed state");
		}
	}
	@Given("^user clicks on any filter popup$")
	public void user_clicks_on_any_filter_popup() throws Throwable {
		login.driver.findElement(By.xpath("//span[normalize-space(text())='Indicator']")).click();
	  
	}

	@Given("^click on it somewhere in the application$")
	public void click_on_it_somewhere_in_the_application() throws Throwable {
		CommonFunctionality.wait(7000);
		login.driver.findElement(By.xpath("//span[@title='Real GDP Growth']/span")).click();
		
	   
	}

	@Then("^filter popup should be closed with applying selected functions\\.$")
	public void filter_popup_should_be_closed_with_applying_selected_functions() throws Throwable {
		login.driver.findElement(By.xpath("//div[normalize-space(text())='Apply filter']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//span[@value='LIST']")).click();
		List<WebElement> Series=login.driver.findElements(By.xpath("//div[@class='series-item--name']"));
		for(int i=0;i<Series.size();i++) {
			String Series_Name=Series.get(i).getText();
			if(Series_Name.contains("Real GDP") && Series.size()>0) {
				login.Log4j.info("The filter popup is closed with selected options");
		}
		
		
			
		
		else {
			login.Log4j.info("The filter popup is not closed with selected options");
		}
		}
	    
	}
	@Given("^user Drag and Drop on Chat icon anywhere in the screen$")
	public void user_Drag_and_Drop_on_Chat_icon_anywhere_in_the_screen() throws Throwable {
		try {
			WebElement Expand_Databriefings=login.driver.findElement(By.xpath("//div[@title='Expand Briefings']"));
			if(Expand_Databriefings.isDisplayed()) {
				Expand_Databriefings.click();
				CommonFunctionality.wait(20000);
				login.Log4j.info("The Datariefings is moved to expanded state");
			}	
		}
			catch (Exception e) {
				
					login.Log4j.info("The Datariefings is in already in open  mode ");	
				}
				
			
		//code commented need to remove
		/*WebElement source=login.driver.findElement(By.xpath("//div[@id='live-chat-bubble']"));
		
		WebElement target=login.driver.findElement(By.xpath("//div[@class='public-js-views-briefings-list-item-module__listItem public-js-views-briefings-list-item-module__top']"));
		
		new Actions(login.driver).moveToElement(source).pause(2000).dragAndDrop(source, target).build().perform();
		
*/		
		/*WebElement sorce1=login.driver.findElement(By.xpath("//div[@class='vsplitter']/div"));
		
		new Actions(login.driver).moveToElement(sorce1).pause(20000).build().perform();
		
		new Actions(login.driver).moveToElement(sorce1).pause(20000).dragAndDrop(sorce1, source).build().perform();*/
		
	}

	@Given("^user enters search with keyword \"([^\"]*)\"\\.$")
	public void user_enters_search_with_keyword(String arg1) throws Throwable {
		WebElement SeriesTab=login.driver.findElement(By.xpath("//span[@value='LIST']"));
		SeriesTab.click();
	    WebElement Search=login.driver.findElement(By.xpath("//input[@placeholder='Search']"));
	    Search.click();
	    Search.sendKeys(arg1,Keys.ENTER);
	}

	@Given("^user logout and relogins the application\\.$")
	public void user_logout_and_relogins_the_application() throws Throwable {
		WebElement logout= login.driver.findElement(By.xpath("//div[@class='account-avatar--container']"));
		logout.click();
		WebElement Sign_out=login.driver.findElement(By.xpath("//*[normalize-space(text())='Sign out']"));
		Sign_out.click();
		CommonFunctionality.wait(1000);
		/*URL url = new URL(login.driver.getCurrentUrl());
		login.driver.get(url.getProtocol() + "://" + url.getHost() + "/login");*/
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, "input[name='user_id']", 4))
				.pause(500).click().sendKeys(Keys.chord(Keys.CONTROL, Keys.BACK_SPACE))
				.sendKeys(login.CONFIG.getProperty("username")).build().perform();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, "input[name='password']", 4))
				.pause(500).click().sendKeys(Keys.chord(Keys.CONTROL, Keys.BACK_SPACE))
				.sendKeys(login.CONFIG.getProperty("password")).build().perform();
		WebElement submit = CommonFunctionality.getElementBycssSelector(login.driver, "button[type='submit']", 4);
		assertEquals(submit.isEnabled(), true);
		new Actions(login.driver).moveToElement(submit).pause(500).click().build().perform();
		System.out.println(" =======>> Logged in back to the default user successfully <<===========");
		CommonFunctionality.wait(5000);
		try {
		
		login.driver.findElement(By.xpath("//*[text()='No, take me to CDMNext']")).click();
		login.Log4j.info("Clicked on No, take me to CDMNext Alert");
		}
		catch(Exception e) {
			System.out.println("Pop up not appeared");
		}
		WebElement SeriesTab=login.driver.findElement(By.xpath("//span[@value='LIST']"));
		SeriesTab.click();
	    
	}

	@Given("^check the search status\\.$")
	public void check_the_search_status() throws Throwable {
		List<WebElement> SeriesList=login.driver.findElements(By.xpath("//div[@class='series-item--name']"));
		
		
		for(int i=0;i<SeriesList.size();i++) {
			String Series_Name=SeriesList.get(i).getText();
			System.out.println("=Series_Name=="+Series_Name);
			if(Series_Name.contains("GDP") && SeriesList.size()>0) {
				login.Log4j.info("Search status displays expected results");
		}
			else {
				login.Log4j.info("Search status doesn't displays expected results");
			}
	}

	}
	@Given("^User Expands DataTable in database/My series$")
	public void user_Expands_DataTable_in_database_My_series() throws Throwable {
		login.driver.findElement(By.xpath("//span[@value='TREE']")).click();
		WebElement Expand_database=login.driver.findElement(By.xpath("//*[@class='database-node tree-node']/div"));
		Expand_database.click();
		
		
	   
	}

	@Given("^switch to next tab$")
	public void switch_to_next_tab() throws Throwable {
		CommonFunctionality.wait(5000);
		WebElement Series=login.driver.findElement(By.xpath("//span[normalize-space(text())='Series']"));
		Series.click();
	   
	}

		@Given("^comeback to Database/My Series$")
	public void comeback_to_Database_My_Series() throws Throwable {
		CommonFunctionality.wait(5000);
		WebElement Databases=login.driver.findElement(By.xpath("//span[normalize-space(text())='Databases']"));
		Databases.click();
		WebElement Expand_database=login.driver.findElement(By.xpath("//*[@class='database-node tree-node']/div"));
		Expand_database.getText();
		if(Expand_database.isDisplayed()) {
			login.Log4j.info("Data Table is in expanded state");
		}
		else {
			login.Log4j.info("Data Table is not in expanded state");
		}
	   
	}

	@Given("^User opens series tab$")
	public void user_opens_series_tab() throws Throwable {
		WebElement Series=login.driver.findElement(By.xpath("//span[normalize-space(text())='Series']"));
		Series.click();
	}

	@Given("^scroll down for series$")
	public void scroll_down_for_series() throws Throwable {
		List<WebElement> ele=new ArrayList<>();
		Thread.sleep(5000);
		for(int i=0;i<5;i++) {
			 ele=login.driver.findElements(By.xpath("//div[@class='series-item--name']"));
				System.out.println("the size is "+ele.size());
		for(WebElement e:ele) {
			JavascriptExecutor jse=(JavascriptExecutor)login.driver;
			jse.executeScript("arguments[0].scrollIntoView(true);", e);
		
			
			
			
		}
		}
	   
	}

	@Given("^click on TOP option next to search feild$")
	public void click_on_TOP_option_next_to_search_feild() throws Throwable {
		CommonFunctionality.wait(4000);
		WebElement Top= login.driver.findElement(By.xpath("//*[normalize-space(text())='Top']"));
		if(Top.isDisplayed()) {
		Top.click();
		login.Log4j.info("Page is scrolled to top");
		}
		else {
			login.Log4j.info("Page is not scrolled to top");
		}
	}
	@Given("^User Selects a Separator and series$")
	public void user_Selects_a_Separator_and_series() throws Throwable {
		WebElement Database=login.driver.findElement(By.xpath("//span[normalize-space(text())='Databases']"));
		Database.click();
		WebElement Expand_Database=login.driver.findElement(By.xpath("//*[@data-node-model-id='INDONESIA']/div[@class='toggle']"));
		Expand_Database.click();
		CommonFunctionality.wait(3000);
		WebElement Expand_DatabaseTree=login.driver.findElement(By.xpath("//*[@class='tree-node']/div[@class='toggle']"));
		Expand_DatabaseTree.click();
		CommonFunctionality.wait(2000);
		WebElement Region_level=login.driver.findElement(By.xpath("(//*[@class='tree-node']/div[@class='toggle'])[1]"));
		
		Region_level.click();
		CommonFunctionality.wait(2000);
		WebElement Table_level=login.driver.findElement(By.xpath("(//*[@class='tree-node']/div[@class='toggle'])[1]"));
		Table_level.click();
		
	}

	@Given("^add series into My series$")
	public void add_series_into_My_series() throws Throwable {
		List<WebElement> ele=new ArrayList<>();
		Thread.sleep(5000);
		for(int i=0;i<5;i++) {
			 ele=login.driver.findElements(By.xpath("//div[@class='series-item--name']"));
				System.out.println("the size is "+ele.size());
		for(WebElement e:ele) {
			JavascriptExecutor jse=(JavascriptExecutor)login.driver;
			jse.executeScript("arguments[0].scrollIntoView(true);", e);
			
		
	   
	}
		}
		CommonFunctionality.wait(50000);
		
		login.driver.findElement(By.xpath("(//*[@class='series-list-item--checkbox svg-checkbox'])[5]")).click();
		CommonFunctionality.wait(2000);
		WebElement Seperator=login.driver.findElement(By.xpath("//*[@class='series-list-item--container series-list-item--separator']//preceding-sibling::span"));
		Seperator.click();
		
		login.driver.findElement(By.xpath("(//*[@class='add-to-data-selection--icon'])[5]")).click();
		WebElement Seperator_Row=login.driver.findElement(By.xpath("//*[@class='series-name-wrapper separator-row ']"));
		if(Seperator_Row.isDisplayed()) {
			login.Log4j.info("Seperator is added to my series");
		}
		else {
			login.Log4j.info("Seperator is not  added to my series");
		}
	}
	@Given("^User Selects a Separator and series=>Create any Visual$")
	public void user_Selects_a_Separator_and_series_Create_any_Visual() throws Throwable {
		WebElement Database=login.driver.findElement(By.xpath("//span[normalize-space(text())='Databases']"));
		Database.click();
		WebElement Expand_Database=login.driver.findElement(By.xpath("//*[@data-node-model-id='INDONESIA']/div[@class='toggle']"));
		Expand_Database.click();
		CommonFunctionality.wait(3000);
		WebElement Expand_DatabaseTree=login.driver.findElement(By.xpath("//*[@class='tree-node']/div[@class='toggle']"));
		Expand_DatabaseTree.click();
		CommonFunctionality.wait(2000);
		WebElement Region_level=login.driver.findElement(By.xpath("(//*[@class='tree-node']/div[@class='toggle'])[1]"));
		
		Region_level.click();
		CommonFunctionality.wait(2000);
		WebElement Table_level=login.driver.findElement(By.xpath("(//*[@class='tree-node']/div[@class='toggle'])[1]"));
		Table_level.click();
		List<WebElement> ele=new ArrayList<>();
		Thread.sleep(5000);
		for(int i=0;i<5;i++) {
			 ele=login.driver.findElements(By.xpath("//div[@class='series-item--name']"));
				System.out.println("the size is "+ele.size());
		for(WebElement e:ele) {
			JavascriptExecutor jse=(JavascriptExecutor)login.driver;
			jse.executeScript("arguments[0].scrollIntoView(true);", e);
			
		
	   
	}
		}
		login.driver.findElement(By.xpath("(//*[@class='series-list-item--checkbox svg-checkbox'])[5]")).click();
		CommonFunctionality.wait(2000);
		WebElement Seperator=login.driver.findElement(By.xpath("//*[@class='series-list-item--container series-list-item--separator']//preceding-sibling::span"));
		Seperator.click();
		WebElement Series=login.driver.findElement(By.xpath("(//div[@class='series-item--main-info'])[5]"));
		new Actions(login.driver).moveToElement(Series).pause(3000).build().perform();
		WebElement More_Actions=login.driver.findElement(By.xpath("//span[@title='More actions']"));
		CommonFunctionality.action.moveToElement(More_Actions).pause(500).click().build().perform();
		WebElement Add_Chart=login.driver.findElement(By.xpath("//span[@title='Add chart']"));
		new Actions(login.driver).moveToElement(Add_Chart).pause(2000).build().perform();
		login.driver.findElement(By.xpath("//div[contains(@class,'icon--table-vertical_large')]")).click();	
		//login.driver.findElement(By.xpath("//span[normalize-space(text())='View as Table']")).click();
	    
	}

	@Given("^seperator should be skipped\\.$")
	public void seperator_should_be_skipped() throws Throwable {
		if(login.driver.findElements(By.xpath("//*[@class='series-name-wrapper separator-row ']")).size()==0) {
			login.Log4j.info("Seperator is not  added along with table visual");
		}
		else {
			login.Log4j.info("Seperator is  added along with table visual");
		}
	}
	
	@Given("^User clicks on recent download=>Next to download button$")
	public void user_clicks_on_recent_download_Next_to_download_button() throws Throwable {
		WebElement Recent_Download=login.driver.findElement(By.xpath("//button[@class='drop-down-button--btn drop-down-button--btn__popup button button__download-btn history-download']"));
		Recent_Download.click();
	    
	}

	@Given("^click on redownload\\.$")
	public void click_on_redownload() throws Throwable {
		CommonFunctionality.wait(2000);
		/*WebElement Redownload=login.driver.findElement(By.xpath("(//a[contains(@class, 'downloads_history-history_item-module__download')])[1]"));
		WebElement name=login.driver.findElement(By.xpath("(//a[contains(@class, 'downloads_history-history_item-module__download')])[1]//preceding-sibling::div[1]/span"));
		String series_title=name.getText().substring(0,6);
		Redownload.click();
	
		DownloadFileVerify(series_title);*/
		
		
		
	    
	}
	
	
	
	
	
	

	public static boolean DownloadFileVerify(String series_title) throws Exception {
		// Verify the downloaded file as excel by comparing the filename title and
		// downloaded file name
		Thread.sleep(5000);
	

		String downloadPath = System.getProperty("user.home") + "\\Downloads\\" ;
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();
		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().contains(series_title)) {
				// File has been found, it can now be deleted:
				dirContents[i].delete();
				login.Log4j.info("File has been download to Excel and its verified");
				return true;
			}
		}
		Assert.fail("Download to Excel verification failed");
		return false;
	}


}

