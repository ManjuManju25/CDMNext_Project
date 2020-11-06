package CDMNext.StepDefinations;

import static org.junit.Assert.assertNull;
import static org.testng.Assert.fail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class replacement {
	WebDriverWait waitforwindow=new WebDriverWait(login.driver, 500);
	
	public void scroll_down() {
		JavascriptExecutor js = (JavascriptExecutor) login.driver;  
		js.executeScript("window.scrollBy(0,500)");
		   
	}
	public void clear_my_series() throws Exception {
		WebDriverWait wait=new WebDriverWait(login.driver, 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("delete_myeries"))));
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("delete_myeries"))).click();
		Thread.sleep(3000);
	}
	public void Open_replacement_window() throws Exception {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("related_series"))).click();
		waitforwindow.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("replace_window"))));
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("replacement_tab"))).click();
		Thread.sleep(1000);
	}
	public void Open_replacement_window_single_series() throws Exception {
		
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("related_series"))).click();
		waitforwindow.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("replace_window"))));
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("replacement_tab"))).click();
		Thread.sleep(1000);
	}
	public void verifypopupWindow() {
		try {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("start_new"))).click();
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("series_tab"))).click();
		}
		catch(Exception e) {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("series_tab"))).click();
		}
	}
public void addSeries() throws Exception {
	
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("search_area"))).clear();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("search_area"))).sendKeys("253736802");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("select_series"))).click();
		Actions action = new Actions(login.driver);
		
		Thread.sleep(2000);
		action.sendKeys("a").perform();
		
		
		
	
	
}

//TC_RS_01
@Given("^Verify window$")
public void verify_window() throws Throwable {
	verifypopupWindow();
}
	@Given("^Add rebased series to My series$")
	public void add_rebased_series_to_My_series() throws Throwable {
	  addSeries();
	}

	@Then("^Verify Series suggestion manager window is open$")
	public void verify_Series_suggestion_manager_window_is_open() throws Throwable {
		Open_replacement_window();
		if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("replacement_tab"))).size()!=0) {
			System.out.println("Replacement tab is shown");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("window_close"))).click();

		}
		else {
			String verifyAssertNull = null;
			assertNull(verifyAssertNull);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("window_close"))).click();

		}
		clear_my_series();
		
		
	}
	
	//TC_RS_02
	@Given("^Add rebased series to My series \"([^\"]*)\"$")
	public void add_rebased_series_to_My_series(String arg1) throws Throwable {
		
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("series_tab"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("search_area"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("search_area"))).clear();;
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("search_area"))).sendKeys(arg1);
			Thread.sleep(1000);
			List<WebElement> multiple_series = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("select_multiple_series")));
			System.out.println(multiple_series.size());
			for (int i = 1; i <= multiple_series.size(); i++) {
				Thread.sleep(1000);
				login.driver.findElement(By.xpath("//ul[@class='search-series-list']/li[" + i + "]/div/a/div[2]")).click();
				Thread.sleep(2000);
			}
			Actions action = new Actions(login.driver);
			
			Thread.sleep(2000);
			action.sendKeys("a").perform();
			Thread.sleep(2000);
		
		
		
		
		
	}
	@Then("^Verify manage all drop down$")
	public void verify_manage_all_drop_down() throws Throwable {
		Open_replacement_window();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("suggestion"))).click();
		Thread.sleep(5000);
		String[] expectedOptions= {"Add Suggestions","Keep Inactive Series","Replace Inactive Series","Delete Inactive Series"};
		System.out.println(expectedOptions.length);
		List<WebElement> suggestionDropdown = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("suggestion_drpdwn")));
		// Number of elements match
		if (expectedOptions.length != suggestionDropdown.size()) {
		    System.out.println("fail, wrong number of elements found");
		}
		//match every element
		for(int i=0;i<suggestionDropdown.size();i++) {
			 List<WebElement> drpdown = login.driver.findElements(By.xpath("(//span[@class='context-menu-item link   '])['"+i+"']"));
		String optionValue = drpdown.get(i).getAttribute("title");
		System.out.println(optionValue);
		Thread.sleep(1000);
		if(optionValue.equals(expectedOptions[i])) {
			System.out.println("Pass"+optionValue);
			//login.driver.findElement(By.xpath(login.LOCATORS.getProperty("window_close"))).click();

		}
		else {
			System.out.println("Fail"+optionValue);
			String verifyAssertNull = null;
			assertNull(verifyAssertNull);
			//login.driver.findElement(By.xpath(login.LOCATORS.getProperty("window_close"))).click();
			//login.driver.findElement(By.xpath(login.LOCATORS.getProperty("window_close"))).click();

		}
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("window_close"))).click();
		clear_my_series();
	}
	//TC_RS_03
	@Then("^Add suggestions for all series and Verify$")
	public void add_suggestions_for_all_series_and_Verify() throws Throwable {
	  //  add_rebased_series_to_My_series();
	    Open_replacement_window();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("suggestion"))).click();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("add_suggestion"))).click();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ok_btn"))).click();
		waitforwindow.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("series_panel"))));
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("group_series"))).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("apply"))).click();

		List<WebElement> seriesList = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("seriesList")));
		for(int i=1;i<=seriesList.size();i++){
			Thread.sleep(1000);
			WebElement series = login.driver.findElement(By.xpath("(//span[@class='series-name-field--series-name'])["+i+"]"));
			String series1 = login.driver.findElement(By.xpath("(//span[@class='series-name-field--series-name'])["+i+"]")).getText();
			System.out.println(series1);
			Actions act=new Actions(login.driver);
			Thread.sleep(2000);
			act.moveToElement(series).build().perform();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("i_icon"))).click();
			
			String seriesA="Active";
			String status = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("status"))).getText();
			Assert.assertEquals(seriesA, status);
			
			
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("window_close"))).click();

		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();
		clear_my_series();
		//System.out.println(i);cle
	}

	@Then("^Add suggestion for single series and Verify$")
	public void add_suggestion_for_single_series_and_Verify() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("single_series"))).click();
		Open_replacement_window_single_series();
		
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("add_sugg"))).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ok_btn"))).click();
		waitforwindow.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("series_panel"))));
		Thread.sleep(1000);
		WebElement series = login.driver.findElement(By.xpath("(//span[@class='series-name-field--series-name'])[2]"));
		String series1 = login.driver.findElement(By.xpath("(//span[@class='series-name-field--series-name'])[2]")).getText();
		System.out.println(series1);
		Actions act=new Actions(login.driver);
		Thread.sleep(2000);
		act.moveToElement(series).build().perform();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("(//span[@class='series-name-field--series-name'])[2]")).click();
		
		String seriesA="Active";
		String status = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("status"))).getText();
		Assert.assertEquals(seriesA, status);
		
		
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("window_close"))).click();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();

		clear_my_series();
	  
	}
	//TC_RS_04
	@Given("^Open Series Suggestion window$")
	public void open_Series_Suggestion_window() throws Throwable {
		Actions icon=new Actions(login.driver);
		WebElement series_hover = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("single_series")));
		icon.moveToElement(series_hover).build().perform();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ssp_win_icon"))).click();
		waitforwindow.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("sspwin"))));

	}

	@Given("^Verify full-screen for SS window$")
	public void verify_full_screen_for_SS_window() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("win_exp"))).click();
		Thread.sleep(1000);
		if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("win_coll"))).size()!=0) {
			System.out.println("SSP window in full screen");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("win_coll"))).click();
			Thread.sleep(1000);
			if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("win_exp"))).size()!=0) {
				System.out.println("SSP window in collapsed form");
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("window_close"))).click();
				Thread.sleep(1000);
				   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();
				   Thread.sleep(1000);
					 clear_my_series();
			}
			else {
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("window_close"))).click();
				   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();

					 clear_my_series();
				Assert.fail("SSP window is not in collapse screen");
			}
		}
		else {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("window_close"))).click();
			   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();
			   Thread.sleep(1000);
				 clear_my_series();
			Assert.fail("SSP window is not in full screen");
		}

	}
	//TC_RS_05
	@Given("^Verify Verify cross mark for SS window$")
	public void verify_Verify_cross_mark_for_SS_window() throws Throwable {
		if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("window_close"))).size()!=0) {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("window_close"))).click();
			System.out.println("SSP window closed");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();

			 clear_my_series();
		}
		
		else {
			System.out.println("SSP window not closed");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();

			 clear_my_series();
		}
	}
//TC_RS_06
	@Given("^Verify Verify SSP window from series suggestions manager$")
	public void verify_Verify_SSP_window_from_series_suggestions_manager() throws Throwable {
	   Open_replacement_window();
	   Actions icon=new Actions(login.driver);
		WebElement series_hover = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("rel_series_win")));
		icon.moveToElement(series_hover).build().perform();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("rel_series_win"))).click();
		waitforwindow.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("sspwin"))));
		Thread.sleep(1000);
		if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("status"))).size()!=0) {
			
			System.out.println("SSP window open");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("sugg_win_close"))).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("window_close"))).click();
			  // login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();

				 clear_my_series();
		}
		
		else {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("window_close"))).click();
			//   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();

				 clear_my_series();
			Assert.fail("SSP window not open");
		}
	}
//TC_RS_07
	@Given("^Verify read more in SS window$")
	public void verify_read_more_in_SS_window() throws Throwable {
	   open_Series_Suggestion_window();
	   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("read_more"))).click();
		waitforwindow.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("footnote_win"))));
		if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("read_more"))).size()!=0) {
			System.out.println("Footnotes window is displayed");
			   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("sugg_win_close"))).click();
			   
		}
		else {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("sugg_win_close"))).click();
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("window_close"))).click();
			   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();

				 clear_my_series();
			Assert.fail("Footnotes window not open");
		}
		   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("window_close"))).click();
		   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();

			 clear_my_series();

	}
//TC_RS_08
	@Given("^Verify keep inactive series$")
	public void verify_keep_inactive_series() throws Throwable {
		Open_replacement_window();
		if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Keep"))).size()!=0) {
			System.out.println("Keep is enabled");
			   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("sugg_win_close"))).click();
				//login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();

			   clear_my_series();

		}
		else {
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("sugg_win_close"))).click();
				//login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();

			 clear_my_series();
			Assert.fail("Footnotes window not open");
		}
		  

	}
//TC_RS_09
	@Given("^Verify replace inactive series$")
	public void verify_replace_inactive_series() throws Throwable {
		Open_replacement_window();
		
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Replace"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ok_btn"))).click();

			waitforwindow.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("series_panel"))));
			Thread.sleep(4000);
			WebElement series = login.driver.findElement(By.xpath("//span[@class='series-name-field--series-name']"));
			Actions act=new Actions(login.driver);
			Thread.sleep(2000);
			act.moveToElement(series).build().perform();
			login.driver.findElement(By.xpath("//span[@class='series-name-field--series-name']")).click();
			Thread.sleep(1000);
			String seriesA="Active";
			String status = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("status"))).getText();
			Assert.assertEquals(seriesA, status);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("sugg_win_close"))).click();
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();

			clear_my_series();

	}
	//TC_RS_10
	@Given("^Verify delete inactive series$")
	public void verify_delete_inactive_series() throws Throwable {
	   Open_replacement_window();
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("delete_series"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ok_btn"))).click();

			waitforwindow.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("series_panel"))));
			Thread.sleep(1000);
			if(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("series_panel_empty"))).size()!=0) {
				System.out.println("Series has been deleted");
			}
			else {
				Assert.fail("Failed to delete series");
			}

	}
//TC_RS_11
	@Given("^Verify preserve option for formula in SS window$")
	public void verify_preserve_option_for_formula_in_SS_window() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("parentseries"))).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("fx")))
				.click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("all_func")))
		.click();
		WebDriverWait wait = new WebDriverWait(login.driver, 150);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("byfunction"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("byfunction"))).click();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("addfunction"))).click();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("insertfunction"))).click();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("applyfunction"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("transformedseries"))));
		Open_replacement_window_single_series();
		Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("add_sugg"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ok_btn"))).click();
			waitforwindow.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("series_panel"))));
			
Thread.sleep(1000);
	List<WebElement> seriesList = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("seriesList")));
	System.out.println(seriesList.size());
	for(int i=2;i<=seriesList.size();i++) {
		System.out.println(i);
		WebElement seriesRow = login.driver.findElement(By.xpath("(//span[@class='series-name-field--series-name'])["+i+"]"));
		Actions series=new Actions(login.driver);
		Thread.sleep(4000);
		series.moveToElement(seriesRow).build().perform();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath("(//span[@class='series-name-field--series-name'])["+i+"]")).click();
			waitforwindow.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("func"))));
			Thread.sleep(1000);
			String fn="ADD(Constant; 1)";
			String expectedfn = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("func"))).getText();

			Assert.assertEquals(fn, expectedfn);
			System.out.println("PASS");
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("sugg_win_close"))).click();
			 

	}
	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();

	clear_my_series();
	}

	@Given("^Verify preserve option for name  in SS window$")
	public void verify_preserve_option_for_name_in_SS_window() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();

		Open_replacement_window_single_series();
		Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("preserve_name"))).click();
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("add_sugg"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ok_btn"))).click();
		 waitforwindow.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("series_panel"))));
			
		 Thread.sleep(1000);
		 List<WebElement> seriesList = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("seriesList")));
			System.out.println(seriesList.size());
			for(int i=1;i<=seriesList.size();i++) {
				String seriesRow = login.driver.findElement(By.xpath("(//span[@class='series-name-field--series-name'])["+i+"]")).getText();
				
				if(seriesRow.contains("GSDP: Delhi")) {
					System.out.println("Preserve with name hasbeen verified");
					 
				}
				else {
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();

					clear_my_series();
					Assert.fail("Preserve with name is not verified");
				}
			}
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();

			clear_my_series();


	  }
	//TC_RS_12
	@Given("^Verify chart icon in SS window$")
	public void verify_chart_icon_in_SS_window() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();

	   Open_replacement_window_single_series();
	   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("chart_icon"))).click();
	   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("chart_icon"))).click();
	   if(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("chart_icon"))).isDisplayed()) {
		   System.out.println("Chart displayed");
		   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("sugg_win_close"))).click();
		   clear_my_series();
	   }
	   else {
		   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("sugg_win_close"))).click();
		   clear_my_series();
		   Assert.fail("Chart not displayed");
	   }
	}
//TC_RS_13
	@Given("^Verify refresh for insight having inactive series$")
	public void verify_refresh_for_insight_having_inactive_series() throws Throwable {
		
	  login.driver.navigate().refresh();
	  try {
		  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("pop_up_continue"))).click();
			waitforwindow.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("pop_up_lastchange"))));
		  if( login.driver.findElement(By.xpath(login.LOCATORS.getProperty("series_sugg_sum"))).isDisplayed()) {
			  System.out.println("Series summary window displayed");

			   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("window_close"))).click();
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();

				clear_my_series();
		  }
		  else {
			   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("window_close"))).click();
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();

			   clear_my_series();
			   Assert.fail("Chart not displayed");
		   }
	  }catch(NoSuchElementException e) {
		  if( login.driver.findElement(By.xpath(login.LOCATORS.getProperty("series_sugg_sum"))).isDisplayed()) {
			  System.out.println("Series summary window displayed");

			   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("window_close"))).click();
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();

				clear_my_series();
		  }
		  else {
			   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("window_close"))).click();
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();

			   clear_my_series();
			   Assert.fail("Chart not displayed");
		   }
	  }
	  
	  
	}
	//TC_RS_14
	@Given("^Verify cancel button$")
	public void verify_cancel_button() throws Throwable {
		  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();

		Open_replacement_window_single_series();
		
		   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("cancel_btn"))).click();
		   try {
			   if( !login.driver.findElement(By.xpath(login.LOCATORS.getProperty("sspwin"))).isDisplayed()) {
				  
				   clear_my_series();
			   }
			  
		   }catch(org.openqa.selenium.NoSuchElementException e) {
			   System.out.println("Window closed");
			  

				   clear_my_series();

			   
		   }
		  

	}
	//TC_RS_15
	@Given("^Verify apply function in SS window$")
	public void verify_apply_function_in_SS_window() throws Throwable {
		  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();
		  Open_replacement_window_single_series();
		  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Replace"))).click();
			 Thread.sleep(1000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("apply_btn"))).click();
			 Thread.sleep(1000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("window_close"))).click();
				waitforwindow.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("series_panel"))));
				Thread.sleep(4000);
				WebElement series = login.driver.findElement(By.xpath("//span[@class='series-name-field--series-name']"));
				Actions act=new Actions(login.driver);
				Thread.sleep(2000);
				act.moveToElement(series).build().perform();
				login.driver.findElement(By.xpath("//span[@class='series-name-field--series-name']")).click();
				Thread.sleep(1000);
				String seriesA="Active";
				String status = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("status"))).getText();
				Assert.assertEquals(seriesA, status);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("window_close"))).click();
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();

				clear_my_series();
	}
	//TC_RS_16
	@Given("^Verify opening SS window from series search tab$")
	public void verify_opening_SS_window_from_series_search_tab() throws Throwable {
		WebElement seriesTab = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("seriesHover")));
		Actions action = new Actions(login.driver);
		
		Thread.sleep(2000);
		action.moveToElement(seriesTab).build().perform();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("seriesTabicon"))).click();
		waitforwindow.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("sspwin"))));
		if(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).isDisplayed()){
			System.out.println("Manage option is displayed");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("window_close"))).click();
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();

		   clear_my_series();
		  
			
		}
		else {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("window_close"))).click();
		  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();

	   clear_my_series();
	   Assert.fail("Manage option not displayed");
		}

	}
	//TC_RS_17
	@Given("^Verify Manage suggestions button$")
	public void verify_Manage_suggestions_button() throws Throwable {
		WebElement seriesTab = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("seriesHover")));
		Actions action = new Actions(login.driver);
		
		Thread.sleep(2000);
		action.moveToElement(seriesTab).build().perform();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("seriesTabicon"))).click();
		waitforwindow.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("sspwin"))));
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("manageBtn"))).click();
		waitforwindow.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("sspwin"))));
		if(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("replace_win"))).isDisplayed()){
			System.out.println("Replacement window is open");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("sugg_win_close"))).click();
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("window_close"))).click();

			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();


		   clear_my_series();
		  
		}
		else {
			
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("window_close"))).click();

			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();

		   clear_my_series();
			Assert.fail("Replacement window not  open");
		}
	}
	//TC_RS_18
	@Given("^Verify dropdown at replacement suggestions$")
	public void verify_dropdown_at_replacement_suggestions() throws Throwable {
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();
	   Open_replacement_window_single_series();
	   
	   if(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("replace_win"))).isDisplayed()) {
		   String series1 = login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[2]")).getText();
		   String series2 = login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[3]")).getText();
		   String chartseries1 = login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[2]")).getText();
		   String chartseries2 = login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[3]")).getText();
		   	Assert.assertEquals(series1,chartseries1);
		   	Assert.assertEquals(series2,chartseries2);
		   	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("window_close"))).click();
		    clear_my_series();
	   }
	   else {
		   System.out.println("Char not displayed");
		 	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("window_close"))).click();
		    clear_my_series();
	   }
	}
	//TC_RS_19
	@Then("^Verify adding on splice function on replacement series$")
	public void verify_adding_on_splice_function_on_replacement_series() throws Throwable {
		Open_replacement_window();
		waitforwindow.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("splice_input"))));
	   	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("splice_input"))).click();
	    Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ok_btn"))).click();
			waitforwindow.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("splice_func_Series"))));

		 if(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("splice_func_Series"))).getText().startsWith("[SPLICE")) {
			 System.out.println("PASS");
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();


			   clear_my_series();
			  
		 }
		 else {
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();


			   clear_my_series();
			  
			 Assert.fail("FAIL");
		 }

	}
	//TC_RS_20
	@Then("^Verify replacing of inactive series with splice functions$")
	public void verify_replacing_of_inactive_series_with_splice_functions() throws Throwable {
		Open_replacement_window();
		waitforwindow.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("splice_input"))));
	   	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("splice_input"))).click();
	    Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ok_btn"))).click();
			waitforwindow.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("splice_func_Series"))));

		 if(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("splice_func_Series"))).getText().startsWith("[SPLICE")) {
			 System.out.println("PASS");
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();


			   clear_my_series();
			  
		 }
		 else {
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();


			   clear_my_series();
			  
			 Assert.fail("FAIL");
		 }

	}
	//TC_RS_21
	@Then("^Verify last changes window popup for replacement series$")
	public void verify_last_changes_window_popup_for_replacement_series() throws Throwable {
	   login.driver.navigate().refresh();
	   try {
		   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("pop_up_continue"))).click();
			waitforwindow.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("pop_up_lastchange"))));

		   if(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("pop_up_lastchange"))).isDisplayed()) {
			   System.out.println("PASS");
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("pop_up_close"))).click();
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();


				   clear_my_series();

		   }
		   else {
			   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("pop_up_close"))).click();
			   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();


			   clear_my_series();
			   Assert.fail("FAIL");
		   }
	   }catch(Exception e) {
		     if(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("pop_up_lastchange"))).isDisplayed()) {
			   System.out.println("PASS");
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("pop_up_close"))).click();
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();


				   clear_my_series();

		   }
		   else {
			   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("pop_up_close"))).click();
			   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();


			   clear_my_series();
			   Assert.fail("FAIL");
		   }
	   }
	  
	}
	//TC_RS_22
	@Then("^Verify 's' icon for replacement series$")
	public void verify_s_icon_for_replacement_series() throws Throwable {
		 if(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("sicon"))).isDisplayed()) {
			   System.out.println("PASS");
				 
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();


				   clear_my_series();

		   }
		   else {
			   
			   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();


			   clear_my_series();
			   Assert.fail("FAIL");
		   }
	}
	//TC_RS_23
	@Then("^Click on the series name in the chart\\.$")
	public void click_on_the_series_name_in_the_chart() throws Throwable {
	 Open_replacement_window();
	   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("r_series"))).click();
		waitforwindow.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("r_series_ssp"))));
		


	}

	@Then("^Verify for ssp window for series in replacement window$")
	public void verify_for_ssp_window_for_series_in_replacement_window() throws Throwable {
		
			if(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("r_series_ssp"))).isDisplayed()) {
				   System.out.println("PASS");
					 login.driver.navigate().refresh();
					 try {
						 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("pop_up_continue"))).click();
							waitforwindow.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("pop_up_lastchange"))));
							 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("pop_up_close"))).click();
							 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();


							   clear_my_series();
					 }catch(Exception e) {
						 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("pop_up_close"))).click();
						 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();


						   clear_my_series();
					 }
					
			}
			   else {
				   login.driver.navigate().refresh();
				   
					 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("my_series_filter_checkbox"))).click();


					   clear_my_series();
				   Assert.fail("FAIL");
			   }
		}
		
		
		
		
}
