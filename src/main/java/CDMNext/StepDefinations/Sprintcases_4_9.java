package CDMNext.StepDefinations;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;
import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.*;
import test.ant.AntSystemPropertySet;

public class Sprintcases_4_9 {
	String str;
	Sprintcases_4_6 s6= new Sprintcases_4_6();
	JavascriptExecutor js = (JavascriptExecutor) login.driver;
	String insightname;
	Actions action = new Actions(login.driver);
	WebDriverWait wait = new WebDriverWait(login.driver, 30);
	DatabasesTab db=new DatabasesTab();
	SprintCases_4_7 s7=new SprintCases_4_7();
	String s;
	String s1;
	@And("^click on first series name$")
	public void click_on_first_series_name() throws Throwable {

		Thread.sleep(5000);

		login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();

		Thread.sleep(5000);

		login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]")).click();

	}

	// TC_18940_01
	@And("^click on data under SSP window$")
	public void click_on_data_under_SSP_window() throws Throwable {

		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='tabs__tab-item'])[1]")))
				.click();

	}

	// TC_18940_01
	@Then("^forecast timepoints should be in green color$")
	public void forecast_timepoints_should_be_in_orange_color() throws Throwable {

		Thread.sleep(2000);

		String text_color = login.driver
				.findElement(By.xpath("(//*[@class='preview-series-time-points--point-value'])[1]"))
				.getCssValue("color");
		String actual = Color.fromString(text_color).asHex();
		System.out.println("forecast timepoints:" + actual);
		// verify with Actual value with Expected value
		String excepted = "#3498db";
		System.out.println("forecast timepoints:" + excepted);
		Assert.assertEquals(excepted, actual);
		login.driver.findElement(By.xpath("//*[@class='movable-modal--close']")).click();

	}

	// TC_18940_01
	@Then("^click on second series name$")
	public void click_on_second_series_name() throws Throwable {
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("(//*[@class='series-item--name'])[2]")).click();

	}

	@Then("^Negative timepoints should be red color$")
	public void negative_timepoints_should_be_red_color() throws Throwable {
		Thread.sleep(2000);

		String text_color = login.driver
				.findElement(By.xpath("(//*[@class='preview-series-time-points--point-value'])[2]"))
				.getCssValue("color");
		String actual = Color.fromString(text_color).asHex();
		System.out.println("Negative timepoints:" + actual);
		// verify with Actual value with Expected value
		String excepted = "#f39c12";
		System.out.println("Negative timepoints:" + excepted);
		Assert.assertEquals(excepted, actual);
		login.driver.findElement(By.xpath("//*[@class='movable-modal--close']")).click();

	}
	@And("^click '\\+' icon on monthly product updates$")
	public void click_icon_on_monthly_product_updates() throws Throwable {
		Thread.sleep(2000);

		// click + icon on monthly product updates

		login.driver.findElement(By.xpath("(//div[@class='toggle'])[20]")).click();
		Thread.sleep(1000);

	}

	// TC_18729_01
	@And("^click '\\+' icon on what's new$")
	public void click_icon_on_what_s_new() throws Throwable {
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("(//div[@class='toggle'])[11]")).click();

	}

	// TC_18729_01
	@Then("^Check 'CEIC monthly newsletter'under analysis$")
	public void check_CEIC_monthly_newsletter_under_analysis() throws Throwable {
		Thread.sleep(2000);

		String subdata = login.driver.findElement(By.xpath("(//div[@class='child-container'])[4]")).getText();
		subdata = subdata.replaceAll("[0-9]", "");
		subdata = subdata.trim();
		System.out.println(subdata);

		System.out.println("=====================================");

		ArrayList<String> value = new ArrayList<String>();
		value.add("API & Integrations");
		value.add("Brazil Premium Database");
		value.add("CDMNext");
		value.add("China Premium Database");
		value.add("Global Database");
		value.add("India Premium Database");
		value.add("Indonesia Premium Database");
		value.add("Russia Premium Database");
		value.add("World Trend Plus");
		System.out.println("Static value:" + value);

		int i = 0;
		for (String newdata : value) {

			if (subdata.contains(newdata)) {
				i++;

			}
		}

		if (value.size() == i) {
			System.out.println("satisfied");
		}

	}
	@Given("^click on Notification icon in right side panel top$")
	public void click_on_Notification_icon_in_right_side_panel_top() throws Throwable {
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//*[@class='user-notifications--icon']")).click();

	}

	// TC_18729_02
	@Given("^Scroll down and click on 'See all insights'$")
	public void scroll_down_and_click_on_See_all_insights() throws Throwable {
		Thread.sleep(2000);

		WebElement seeallinsights = login.driver.findElement(By.xpath("//a[@class='link link__arrowed']"));
		js.executeScript("arguments[0].scrollIntoView(true);", seeallinsights);
		Thread.sleep(500);
		seeallinsights.click();

	}

	// TC_18729_02
	@Then("^Should be open under Analysis tab Monthly product updates$")
	public void should_be_open_under_Analysis_tab_Monthly_product_updates() throws Throwable {
		Thread.sleep(4000);

		if (login.driver.findElements(By.xpath("//*[contains(text(),'Monthly Product Updates')]")).size() == 1) {

			System.out.println("Should be open under Analysis tab Monthly product updates");

		}

		else {
			Assert.fail();
		}

	}

	

// TC_19161_01


// TC_19161_01


// TC_19161_01
@Given("^add some test in commentary panel$")
public void add_some_test_in_commentary_panel() throws Throwable {
Thread.sleep(2000);
System.out.println("Enter into add some test");

login.driver.switchTo().frame(0);
//===========================================================================




login.driver.findElement(By.xpath("//*[@class='mce-content-body ']")).click();
login.driver.findElement(By.xpath("//*[@class='mce-content-body ']")).sendKeys("Welcome to shravas");

Thread.sleep(1000);
login.driver.switchTo().defaultContent();



}

// TC_19161_01
@Given("^click on visual dropdown and click on background$")
public void click_on_visual_dropdown_and_click_on_background() throws Throwable {
Thread.sleep(2000);
WebElement mouseover=login.driver.findElement(By.xpath("//span[contains(text(),'Visual')]"));

action.moveToElement(mouseover).pause(500).perform();
Thread.sleep(1000);
login.driver.findElement(By.xpath("//span[contains(text(),'Visual')]")).click();
Thread.sleep(2000);

login.driver.findElement(By.xpath("//div[contains(text(),'Background')]")).click();
}

// TC_19161_01
@Given("^visual check box checked and select color$")
public void visual_check_box_checked_and_select_color() throws Throwable {
Thread.sleep(2000);

login.driver.findElement(By.xpath("//*[contains(text(),'Visual')]/preceding-sibling::span")).click();

// click on color

login.driver.findElement(By.xpath("//div[@class='background-control--options']//button[@class='index-module_swatch_button__-pKGq color-picker-button ']")).click();


// select color
login.driver.findElement(By.xpath("//div[@class='index-module_wrapper__j2U4-']/div[@style='background-color: rgb(5, 153, 154);']")).click();
                                   //(//*[@class='sp-thumb-inner'])[13]

// click on cross mark
login.driver.findElement(By.xpath("//*[@class='popover--close']")).click();

}

// TC_19161_01
@Then("^The color should applied to whole visual area$")
public void the_color_should_applied_to_whole_visual_area() throws Throwable {
Thread.sleep(2000);

// click on top
login.driver.findElement(By.xpath("//*[@class='visual-top-panel--content']")).click();

// whole visual area
String color = login.driver
		.findElement(By.xpath("//*[@class='visual-item-template visual-select-area text-template']"))
		.getCssValue("background-color");

System.out.println("Background color:" + color);


		String actual = Color.fromString(color).asHex();
System.out.println(" Actual Back_color:" + actual);
// verify with Actual value with Expected value
String excepted = "#05999a";
System.out.println(" Excepted color:" + excepted);
Assert.assertEquals(excepted, actual);
//login.driver.findElement(By.xpath("//*[@class='movable-modal--close']")).click();


}

// TC_14534_01
@Given("^Add this series into my series \"([^\"]*)\"$")
public void add_this_series_into_my_series(String arg1) throws Throwable {
	Thread.sleep(5000);

	try {
		// click on series tab
		login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
		Thread.sleep(2000);
		// Enter series id in search bar
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(arg1);

		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		// click on +icon
		login.driver.findElement(By.xpath("//*[@class='add-to-data-selection--icon']")).click();
		System.out.println("Exit from try block");
	}

	catch (org.openqa.selenium.StaleElementReferenceException ex) {
		System.out.println("Enter into catch block");
		// click on series tab
		login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();

		// Enter series id in search bar
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(arg1);

		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(Keys.ENTER);

		// click on +icon
		login.driver.findElement(By.xpath("//*[@class='add-to-data-selection--icon']")).click();
	}

}

// TC_14534_01
@Given("^click on series name and SSP popup open$")
public void click_on_series_name_and_SSP_popup_open() throws Throwable {
	Thread.sleep(1000);

	WebElement we = login.driver.findElement(By.xpath("//span[contains(text(),'GDP: SNA 1993: 2000p')]"));
	action.moveToElement(we).pause(500).build().perform();

	login.driver.findElement(By.xpath("//span[contains(text(),'GDP: SNA 1993: 2000p')]")).click();

	if (login.driver.findElements(By.xpath("//div[contains(text(),'13132401')]")).size() == 1) {

		System.out.println("SSP popup Should be open");
	}

	else {
		Assert.fail();
	}
}

// TC_14534_01
@Given("^click on Manage button$")
public void click_on_Manage_button() throws Throwable {

	Thread.sleep(5000);
	login.driver.findElement(By.xpath("//span[contains(text(),'Manage')]")).click();
}

// TC_14534_01
@Then("^The Popup should be open$")
public void the_Popup_should_be_open() throws Throwable {

	Thread.sleep(1000);

	if (login.driver.findElements(By.xpath("//span[contains(text(),'Manage')]")).size() != 1) {
		System.out.println("Add Related series popup should be display");
	}

	else {
		Assert.fail();
	}
	System.out.println("======================>32");

}
@And("^'whats new' tab check under notification panel$")
public void whats_new_tab_check_under_notification_panel() throws Throwable {
	Thread.sleep(2000);

	if (login.driver.findElements(By.xpath("//*[@class='tabs__tab-item active']")).size() == 1) {
		System.out.println("whats new'tab should be displayed under notification panel");
	} else {
		Assert.fail();
	}

}
@And("^'webinars and events' tab check under notification panel$")
public void webinars_and_events_tab_check_under_notification_panel() throws Throwable {

	Thread.sleep(2000);

	if (login.driver.findElements(By.xpath("//div[contains(text(),'Webinars & Events')]")).size() == 1) {
		login.driver.findElement(By.xpath("//div[contains(text(),'Webinars & Events')]")).click();
	}

	else {
		Assert.fail();
	}

}
@Then("^verify 'webinars and events' tab should be displayed$")
public void verify_webinars_and_events_tab_should_be_displayed() throws Throwable {
	Thread.sleep(2000);

	if (login.driver.findElements(By.xpath("//div[contains(text(),'Webinars & Events')]")).size() == 1) {
		System.out.println("verify 'webinars and events' tab should be displayed");
	} else {
		Assert.fail();
	}

}


// TC_19215_01
@And("^Scroll down and click on 'See all Webinars'$")
public void scroll_down_and_click_on_See_all_Webinars() throws Throwable {

	Thread.sleep(2000);

	WebElement webinarslink = login.driver.findElement(By.xpath("//a[contains(text(),'See all webinars')]"));
	js.executeScript("arguments[0].scrollIntoView(true);", webinarslink);

	Thread.sleep(2000);
	webinarslink.click();
	

}

// TC_19215_01
@Then("^verify 'Webinars & Events' tab should be opened$")
public void verify_Webinars_Events_tab_should_be_opened() throws Throwable {

	Thread.sleep(2000);

	if (login.driver.findElements(By.xpath("//*[@class='webinars-list']")).size() == 1) {
		System.out.println("webinars and Events tab should be displayed");
	} else {
		Assert.fail();
	}

}
@And("^Select source \"([^\"]*)\"$")
public void Select_source(String str) throws InterruptedException 
{
	login.driver.findElement(By.xpath("//span[contains(text(),'Source')]")).click();
	login.driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys(str,Keys.ENTER);
	Thread.sleep(2000);
	login.driver.findElement(By.xpath("//div[contains(text(),'Apply filter')]")).click();
}
@And("^Navigate to World Trend >Forecast >Regional Forecast$")
public void Navigate_to_worldTrend_forecast_RegionalForecast()
{

	login.driver.findElement(By.xpath("//div[@data-node-model-id='WORLD']/div[@class='toggle']")).click();
	
	login.driver.findElement(By.xpath("//div[@data-node-model-id='WORLD&&WFOR']/div[@class='toggle']")).click();
	login.driver.findElement(By.xpath("//div[@data-node-model-id='TP73753']/div[@class='toggle']")).click();
	
}
@Then("^verify the comparable tab \"([^\"]*)\"$")
public void verify_the_comparable_tab(String str)
{
	login.driver.findElement(By.xpath("(//span[@data-id='COUNTRY_COMPARISON']/span[contains(text(),'Comparables')])[1]")).click();
	login.driver.findElement(By.xpath("//div[@data-node-model-id='National Accounts']/div[@class='toggle']")).click();
	List<WebElement>l1=login.driver.findElements(By.xpath("//span[@class='name']/span[@class='name-text'][contains(text(),'"+str+"')]"));
	for(WebElement l2:l1) {
		
		if(l2.getText().contains(str))
				{
			System.out.println(l2.getText());
				}
	}
		
}
@And("^Click show related data$")
public void Click_show_related_data() throws InterruptedException
{
	Thread.sleep(5000);
	if(login.driver.findElement(By.xpath("//span[@value='MISMATCHES_ONLY']")).isSelected())
	{
		System.out.println("selected");
	}
	else
		login.driver.findElement(By.xpath("//span[@value='MISMATCHES_ONLY']")).click();
		
}
@Then("^Check Replacement suggestions dataset$")
public void Check_Replacement_suggestions_dataset()
{

	login.driver.findElement(By.xpath("//span[@value='DATASETS']")).click();
	Boolean b=login.driver.findElement(By.xpath("//div[@class='series-data-set--node-link'][contains(text(),'China Premium Database')]")).isDisplayed();
   if(b.toString().equalsIgnoreCase("true"))
   {
	   System.out.println("present");
   }
}
@And("^Click on Indicator filter$")
public void Click_on_Indicator_filter()
{
	login.driver.findElement(By.xpath("//span[contains(text(),'Indicator')]")).click();
	
}
@Then("^Popular group has to be selected by default$")
public void Popular_group_has_to_be_selected_by_default() throws InterruptedException
{
	Thread.sleep(10000);
	if(login.driver.findElement(By.xpath("//span[contains(text(),'Popular')]")).isDisplayed())
	{
		List<WebElement>l=login.driver.findElements(By.xpath("//div[@class='indicator-group-filter--items']//span[@class='text-dots']"));
		for(WebElement l1:l)
		{
			System.out.println(l1.getText().toString());
		}
	}
}
@And("^Click on function toolbar$")
public void Click_on_function_toolbar() throws InterruptedException
{
	Thread.sleep(3000);
	action.sendKeys((Keys.chord("a"))).build().perform();
	action.moveToElement(login.driver.findElement(By.xpath("(//span[@class='series-name-field-title'])[1]"))).build().perform();
	login.driver.findElement(By.xpath("//div[@title='Apply Function']")).click();
}
@Then("^Select BVA function and go to the help section$")
public void Select_BVA_function_and_go_to_the_help_section()
{
	
login.driver.findElement(By.xpath("//span[@class='popular-functions-context--all-icon']")).click();
 login.driver.findElement(By.xpath("//div[contains(text(),'By function')]")).click();
 login.driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys("BASEVALADJ");
 login.driver.findElement(By.xpath("//div[contains(text(),' BASEVALADJ ')]")).click();
 login.driver.findElement(By.xpath("//div[contains(text(),'Help on this function')]")).click();
 List<WebElement>l=login.driver.findElements(By.xpath("//div[@class='function-data--description']"));
 for(WebElement l1:l)
 {
	 System.out.println(l1.getText().toString());
 }
 
	
}
@And("^Open Analysis tab$")
public void Open_Analysis_tab() throws InterruptedException
{
	Thread.sleep(5000);
	login.driver.findElement(By.xpath("(//span[contains(text(),'Analysis')])[1]")).click();
}
@And("^Rightclick any of the sections copy link should be available \"([^\"]*)\"$")
public void Rightclick_any_of_the_sections_copy_link_should_be_available(String sarg) throws Throwable
{
	login.driver.findElement(By.xpath("//div[@class='insights-view-modes--item insights-view-modes--item__table']")).click();
	List<WebElement>l=login.driver.findElements(By.xpath("//div[@class='insight-table-item']"));
	for(WebElement l1:l)
	{
		action.moveToElement(l1).contextClick().build().perform();

		WebElement copy=login.driver.findElement(By.xpath("//span[contains(text(),'Copy link')]"));
		//action.moveToElement(copy).build().perform();
		copy.click();
		db.paste_it_in_new_tab();
		break;
		
	     

}
}
@And ("^Select chart to right click and apply round function$")
public void select_chart_to_right_click_and_apply_round_function()
{
	action.moveToElement(login.driver.findElement(By.xpath("//div[@class='visual-top-panel']"))).contextClick().build().perform();
	action.moveToElement(login.driver.findElement(By.xpath("//span[contains(text(),'Calculate series')]"))).click().perform();
	login.driver.findElement(By.xpath("//span[@class='popular-functions-context--all-icon']")).click();
	 login.driver.findElement(By.xpath("//div[contains(text(),'By function')]")).click();
	 login.driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys("Round");
	 action.moveToElement(login.driver.findElement(By.xpath("//div[contains(text(),'ROUND')]"))).doubleClick().perform();
	 //login.driver.findElement(By.xpath("//span[contains(text(),'Replace selected series')]//parent::label/span[@class='input-control--indicator']")).click(); 
	 login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();

}
@Then("^Verify the transformed series in chart$")
public void verify_the_transformed_series_in_chart() throws InterruptedException
{
	Thread.sleep(2000);
	login.driver.findElement(By.xpath("//span[@data-z-index='2']")).click();
	login.driver.switchTo().activeElement();
	login.driver.findElement(By.xpath("//div[@data-tab='data']")).click();
	List<WebElement>l=login.driver.findElements(By.xpath("//span[@class='preview-series-time-points--point-date']"));
	//List<WebElement>m=login.driver.findElements(By.xpath("//span/following-sibling::span[@class='preview-series-time-points--point-value']"));
	for(WebElement l1:l)
	{
	   for(int i=1;i<=l.size();i++)
	   {
		 String str=login.driver.findElement(By.xpath("(//span[@class='preview-series-time-points--point-date']/following-sibling::span)["+i+"]")).getText().toString();
		   System.out.println(str);
		   if(str.contains(".00")){
			   System.out.println("rounded");
		   }
		  
	   }
	   break;
	}
}
@And("^Create SSP for series \"([^\"]*)\"$")

public void create_ssp_for_series(String str) throws InterruptedException
{
s7.Search_for_series_in_layout(str);
Thread.sleep(2000);
login.driver.findElement(By.xpath("//div[@title='View results as List']")).click();
Thread.sleep(4000);
action.moveToElement(login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"))).click().perform();
Thread.sleep(2000);
}
@And ("^Verify the Region \"([^\"]*)\"$")
public void verify_the_region(String str)
{

login.driver.switchTo().activeElement();
List<WebElement>l=login.driver.findElements(By.xpath("//div[@class='series-location-panel-item main-series-information--link']"));
String s = null;
String s1 = null;
for(WebElement l1:l)
{
	
	if(l1.getText().toString().equalsIgnoreCase(str))
	{
	 s=l1.getText().toString();
	}
	else
		s1=l1.getText().toString();
}
System.out.println(s+s1);
}

@And("^Open a chart visual \"([^\"]*)\"$")
public void open_a_chart_visual(String str) throws InterruptedException
{
	create_chart_visual_for_the_series(str);
	login.driver.findElement(By.xpath("//button[contains(text(),'Edit Chart')]")).click();
	
}
@And("^Create chart visual for series \"([^\"]*)\"$")
public void create_chart_visual_for_the_series(String str) throws InterruptedException
{
	s7.add_a_series_into_right_pane(str);
	action.sendKeys((Keys.chord("c"))).build().perform();
}
@And("^Click on title for editing$")
public void click_on_title_for_editing() throws InterruptedException
{
	
	action.moveToElement(login.driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]"))).click().perform();
	//a.moveToElement(login.driver.findElement(By.xpath("//i[@class='visual-title--icon visual-title--edit popover-target-active']"))).click().perform();
	// s=login.driver.findElement(By.xpath("(//span[@data-name='title'])[2]")).getText().toString();
	login.driver.switchTo().activeElement();
	//login.driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]")).
  s1 = login.driver.findElement(By.xpath("//input[@name='title']")).getAttribute("value");
 System.out.println("1st"+s1);
 login.driver.findElement(By.xpath("//div[@class='popover--close']")).click();
 Thread.sleep(2000);
	}
//input[@name='title']
@And("^Existing title to be displayed$")
public void existing_title_to_be_displayed()
{
 s = login.driver.findElement(By.xpath("(//span[@data-name='title'])[2]")).getText().toString();
	System.out.println("1st s"+s);
	
	System.out.println("2nd s1"+s1);
	if(s1.equalsIgnoreCase(s))
	{
		System.out.println(s);
		System.out.println(s1);
		
	}
}
@And("^Create new insight1$")
public void create_new_insight1()
{
	
	login.driver.findElement(By.xpath("//a[contains(text(),'My insights')]")).click();
	login.driver.findElement(By.xpath("//span[contains(text(),'Create insight')]")).click();
		login.driver.findElement(By.xpath("//input[@ui='$name']")).sendKeys(Keys.ENTER);
	
}
@And("^Add any series and Create a line chart with it$")
public void Add_any_series_and_create_a_line_chart_with_it() throws InterruptedException
{
	Thread.sleep(4000);
	login.driver.findElement(By.xpath("//div[@title='Create new View tab']")).click();
	login.driver.findElement(By.xpath("//span[contains(text(),'View 1')]")).click();
     login.driver.findElement(By.xpath("//div[contains(text(),'Line')]")).click();
     login.driver.findElement(By.xpath("//div[@title='View results as List']")).click();
    s7.Select_any_series1();
    action.sendKeys((Keys.chord("a"))).build().perform();
	
}
@And("^Open \"([^\"]*)\" popup$")
public void Open_popup(String str) throws InterruptedException
{
	Thread.sleep(3000);
	login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
	login.driver.findElement(By.xpath("//button[contains(text(),'"+str+"')]")).click();
}

@And("^Select \"([^\"]*)\" type on the left panel$")
public void select_type_on_the_left_panel(String str)
{
	login.driver.findElement(By.xpath("//div[contains(text(),'"+str+"')]")).click();
}
@And("^Set new timeframe by dragging timeframe bar on the chart$")
public void set_new_timeframe_by_dragging_timeframe_bar_on_the_chart() {
	
	action.dragAndDrop((login.driver.findElement(By.xpath("(//*[@class='highcharts-navigator-handle highcharts-navigator-handle-left'])[2]"))),(login.driver.findElement(By.xpath("//*[@class='movable-modal--body']//*[@class='highcharts-axis-labels highcharts-xaxis-labels highcharts-navigator-xaxis']/*")))).build().perform();
}
@And("^Select \"([^\"]*)\" type on the left panel1$")
public void select_type_on_the_left_panel1(String str)
{
	//login.driver.findElement(By.xpath("//div[@class='types-panel-expander types-panel-expander__right']")).click();
	login.driver.findElement(By.xpath("//div[contains(text(),'"+str+"')]")).click();
	login.driver.findElement(By.xpath("//button[@class='button button__primary']")).click();
}

@And("^Set Db language for WTP as chinese$")
public void set_Db_language_for_WTP_as_chinese() throws Throwable
{
	Thread.sleep(2000);
	
	//action.moveToElement(login.driver.findElement(By.xpath("(//span[@title-en='Translate'])[1]"))).click().perform();
	//action.moveToElement(login.driver.findElement(By.xpath("//span[contains(text(),'English')]"))).click().perform();
	action.moveToElement(login.driver.findElement(By.xpath("//span[contains(text(),'World Trend Plus')]"))).build().perform();
	action.moveToElement(login.driver.findElement(By.xpath("(//span[@title-en='Translate'])[1]"))).click().perform();
	action.moveToElement(login.driver.findElement(By.xpath("//span[contains(text(),'??')]"))).click().perform();
}
@And("^Search for series \"([^\"]*)\" and create SSP$")
public void Search_for_series_and_create_SSP(int i)
{
	login.driver.findElement(By.xpath("//div[@title='View results as List']")).click();
	action.moveToElement(login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"))).click().perform();
	
}
@And("^Create heatmap or table in an insight$")
public void create_heatmap_or_table_in_an_insight() throws InterruptedException
{Thread.sleep(2000);
login.driver.findElement(By.xpath("//div[@title='Create new View tab']")).click();
	login.driver.findElement(By.xpath("//span[contains(text(),'View 1')]")).click();
    login.driver.findElement(By.xpath("(//div[contains(text(),'Heat map')])[2]")).click();
    login.driver.findElement(By.xpath("//div[@title='View results as List']")).click();
    
    s7.Select_any_series1();
    action.sendKeys((Keys.chord("a"))).build().perform();
    
	
}
@And("^Change date for sorting heatmap or table \"([^\"]*)\" \"([^\"]*)\"$")
public void change_date_for_sorting_heatmap_or_table(String str1,String str2) throws InterruptedException
{
	login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
	Thread.sleep(2000);
	s7.click_on_the_timeframe_to_choose_custom_dates_from(str1,str2);
}
@And("^click on copy icon or Ctrl\\+C$")
public void click_on_copy_icon() throws InterruptedException
{
	Thread.sleep(2000);
	action.contextClick().build().perform();
	login.driver.findElement(By.xpath("//span[contains(text(),'Copy heat map')]")).click();
	login.driver.findElement(By.xpath("//button[contains(text(),'More options')]")).click();
}
@Then("^Paste it onto excel$")
public void paste_it_onto_excel()
{
	login.driver.findElement(By.xpath("//span[contains(text(),'Download')]")).click();
}
@And("^Click on function toolbar apply round function \"([^\"]*)\"$")
public void click_on_function_toolbar_apply_round_function(String str) throws InterruptedException
{
	action.sendKeys((Keys.chord("a"))).build().perform();
	Click_on_function_toolbar();
	login.driver.findElement(By.xpath("//span[@class='popular-functions-context--all-icon']")).click();
	 login.driver.findElement(By.xpath("//div[contains(text(),'By function')]")).click();
	 Thread.sleep(2000);
	 login.driver.findElement(By.xpath("//input[@class='form--control search-functions-input']")).click();
	 login.driver.findElement(By.xpath("//input[@class='form--control search-functions-input']")).sendKeys("Round");
	 action.moveToElement(login.driver.findElement(By.xpath("//div[contains(text(),'"+str+"')]"))).doubleClick().perform();
	 Thread.sleep(2000);
	 login.driver.findElement(By.xpath("//span[contains(text(),'Replace selected series')]//parent::label/span[@class='input-control--indicator']")).click(); 
	 login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
	 Thread.sleep(2000);
	 login.driver.findElement(By.xpath("//span[contains(text(),'Download')]")).click();
	 login.driver.switchTo().activeElement();
	 login.driver.findElement(By.xpath("(//span[contains(text(),'Download')])[3]")).click();
	
}
@Then("^Download to excel and verify the results \"([^\"]*)\"$")
public void download_to_excel_and_verify_the_result(String insightname) throws IOException, InterruptedException
{
	Thread.sleep(7000);
	
	String path2 = "C:\\Users\\tbemineni\\Downloads\\"+insightname+".xlsx";
	
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
        System.out.println();
    }
}
@And("^Click on function toolbar apply round function and choose replace original series$")
public void click_on_function_toolbar_apply_round_function_and_choose_replace_original_series() throws InterruptedException
{
	action.sendKeys((Keys.chord("a"))).build().perform();
	Click_on_function_toolbar();
	login.driver.findElement(By.xpath("//span[@class='popular-functions-context--all-icon']")).click();
	 login.driver.findElement(By.xpath("//div[contains(text(),'By function')]")).click();
	 login.driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys("Round");
	 action.moveToElement(login.driver.findElement(By.xpath("//div[contains(text(),'ROUND')]"))).doubleClick().perform();
	 login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
	 login.driver.findElement(By.xpath("//span[contains(text(),'Download')]")).click();
	 login.driver.switchTo().activeElement();
	 login.driver.findElement(By.xpath("(//span[contains(text(),'Download')])[3]")).click();
}
@And("^Select download button, select function window from data transformation section and  apply round function$")
public void select_download_button_select_function_window_from_data_transformation_section_and_apply_round_function() throws InterruptedException
{
	
	action.sendKeys((Keys.chord("a"))).build().perform();
   
	Thread.sleep(2000);
	login.driver.findElement(By.xpath("//span[contains(text(),'Download')]")).click();
	login.driver.switchTo().activeElement();
	login.driver.findElement(By.xpath("//div[@class='hot-functions-button hot-functions-button-download']")).click();
	login.driver.switchTo().activeElement();
	login.driver.findElement(By.xpath("//span[@class='popular-functions-context--all-icon']")).click();
	 login.driver.findElement(By.xpath("//div[contains(text(),'By function')]")).click();
	 Thread.sleep(2000);
	 login.driver.findElement(By.xpath("//input[@class='form--control search-functions-input']")).click();
	 login.driver.findElement(By.xpath("//input[@class='form--control search-functions-input']")).sendKeys("Round");
	 action.moveToElement(login.driver.findElement(By.xpath("//div[contains(text(),'ROUND')]"))).doubleClick().perform();
	 Thread.sleep(2000);
	 login.driver.findElement(By.xpath("//span[contains(text(),'Replace selected series')]//parent::label/span[@class='input-control--indicator']")).click(); 
	 login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
	 Thread.sleep(2000);
	 //login.driver.findElement(By.xpath("//span[contains(text(),'Download')]")).click();
	 login.driver.switchTo().activeElement();
	 login.driver.findElement(By.xpath("(//span[contains(text(),'Download')])[3]")).click();
}
@Given("^login with that username$")
public void login_with_that_username() throws Throwable
{
	s6.open_preference_dropdown1();
	Thread.sleep(2000);

	WebElement signout = login.driver.findElement(By.xpath("//span[contains(text(),'Sign out')]"));
	js.executeScript("arguments[0].scrollIntoView(true);", signout);
	Thread.sleep(1000);
	signout.click();
	
	login.driver.navigate().to("https://stage.ceicdata.com/node/WORLD__WORLD&&ALL__TP3200827");
	Thread.sleep(10000);
	login.driver.findElement(By.xpath("//input[@name='user_id']")).sendKeys("theju@gmail.com");
	login.driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Ceic@123");
	login.driver.findElement(By.xpath("//button[@class='btn']")).click();
	

}
@Then("^Try to access the ssp and footnotes for the unsubscribed series$")
public void try_to_access_the_ssp_and_footnotes_for_the_unsubscribed_series() throws InterruptedException
{
	Thread.sleep(5000);
	action.moveToElement(login.driver.findElement(By.xpath("(//span[contains(text(),'Geopolitical Risk Index')])[2]"))).build().perform();
	if(login.driver.findElements(By.xpath("(//div[@class='series-list-item-data'])[1]//span[@title='Open footnote']")).size()==0)
	{
		System.out.println("SubScribed series");
	}
	
	login.driver.findElement(By.xpath("(//span[contains(text(),'Geopolitical Risk Index')])[2]")).click();
	login.driver.switchTo().activeElement();
	String str=login.driver.findElement(By.xpath("//h4[@ui='$title']")).getText().toString();
	System.out.println(str);
	
}
@And("^In database tree expand global db Afghanistan Afghanistan National Accounts$")
public void in_database_tree_expand_globa_db_Afghanistan_Afghanistan_National_Accounts()
{
	login.driver.findElement(By.xpath("(//div[@data-node-model-id='GLOBAL']/div[@class='toggle'])[1]")).click();
	login.driver.findElement(By.xpath("(//div[@data-node-model-id='GLOBAL&&ALL']/div[@class='toggle'])[1]")).click();
	login.driver.findElement(By.xpath("(//div[@data-node-model-id='TP2560837']/div[@class='toggle'])[1]")).click();
	login.driver.findElement(By.xpath("(//div[@data-node-model-id='SC2576097']/div[@class='toggle'])[1]")).click();
}
@And("^Click cross-country for first table$")
public void click_cross_country_for_first_table()
{
	action.moveToElement(login.driver.findElement(By.xpath("(//span[@class='name-text'])[6]"))).build().perform();
	login.driver.findElement(By.xpath("(//span[@title='View table cross country'])[1]")).click();
}
@Then("^It navigates to comparables tab$")
public void it_navigates_to_comparable_tab() throws Throwable
{
	Thread.sleep(2000);
	if(login.driver.findElement(By.xpath("(//span[contains(text(),'Comparables')])[1]")).isSelected())
	{
		System.out.println("seleced");
	}
}




}
