package CDMNext.StepDefinations;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class PieVisual {
	
	CDMNextSprintCases cv = new CDMNextSprintCases();
	WebElement insert_pie;
	WebElement destination;
	
	@SuppressWarnings("deprecation")
	@And("^Select different frequency series \"([^\"]*)\" and click on \"([^\"]*)\" icon$")
	public void select_different_frequency_series_and_click_on_icon(String arg1, String arg2) throws Throwable {
		CommonFunctionality.webDriverwait_keyvalue("Series_tab");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_tab"))).click();
		CommonFunctionality.webDriverwait_keyvalue("Series_new");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_new"))).click();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).clear();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(arg1);
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		CommonFunctionality.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("blocker--loader")));
        List<WebElement> total_count = login.driver.findElements(By.xpath("//ul[contains(@class,'search-series-list')]/li"));
		for(int i = 1; i <= total_count.size(); i++) {
		WebElement unselect_check = CommonFunctionality.getElementByXpath(login.driver, "//ul[contains(@class,'search-series-list')]/li["+i+"]", 4);
		WebElement series = CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='series-list-item--checkbox-wrapper']//*[contains(@class,'series-list-item--checkbox')])["+i+"]", 4);
		if(!(unselect_check.getAttribute("class").contains("series-list-item__selected"))) {
		new Actions(login.driver).moveToElement(series).pause(100).click().build().perform();
		}
		}
		if(arg2.equalsIgnoreCase("Pie")) {
		cv.click_on_more_actions();
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'View as ...')]", 4)).build().perform();
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, "span[title='"+arg2+"']", 4)).pause(1000).click().build().perform();
		}  
	}
	
	@And("^Hovor on Insert Pie$")
	public void hovor_on_Insert_Pie() throws Throwable {
		insert_pie = CommonFunctionality.getElementByXpath(login.driver, "//div[@data-title='Pie']", 4);
		destination = CommonFunctionality.getElementByXpath(login.driver,"//*[@class='view-components-over--visual-title' and text()='Pie']", 4);
	}

	@SuppressWarnings("deprecation")
	@And("^\"([^\"]*)\" the Insert pie option$")
	public void the_Insert_pie_option(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Drag and Drop")) {
			new Actions(login.driver).moveToElement(insert_pie).pause(100).clickAndHold(insert_pie).dragAndDrop(insert_pie, destination).build().perform();
		}
	}
	
	@And("^Make the changes in series harmonization popup$")
	public void make_the_changes_in_series_harmonization_popup() throws Throwable {
		CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Series Harmonization']")));
		Select select = new Select(CommonFunctionality.getElementByXpath(login.driver, "//select[@name='currency']", 4));
		select.selectByValue("USD");
		Select select1 = new Select(CommonFunctionality.getElementByXpath(login.driver, "//select[@name='unit']", 4));
		select1.selectByValue("NA");
		CommonFunctionality.getElementBycssSelector(login.driver, ".movable-modal--window .button__primary", 4).click();		
	}
	
	@And("^Make the changes in the series harmonization popup$")
	public void make_the_changes_in_the_series_harmonization_popup() throws Throwable {
		Select select = new Select(CommonFunctionality.getElementByXpath(login.driver, "//select[@name='currency']", 4));
		select.selectByValue("");
		Select select1 = new Select(CommonFunctionality.getElementByXpath(login.driver, "//select[@name='unit']", 4));
		select1.selectByValue("NA");
	}

	@Then("^The Window should be maximized$")
	public void the_Window_should_be_maximized() throws Throwable {
	    CommonFunctionality.getElementBycssSelector(login.driver, "div[title='Minimize']", 4).click();
	    CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[title='Maximize']")));
	    CommonFunctionality.getElementBycssSelector(login.driver, "div[title='Maximize']", 4).click();
	    String maximize = CommonFunctionality.getElementByXpath(login.driver, "//div[@class='movable-modal--actions']/div[1]", 4).getAttribute("title");
	    assertEquals(maximize, "Minimize");
	    CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
	    System.out.println("The window is maximized");
	    CommonFunctionality.Views_list();
	}

	@Then("^Verify viewing \"([^\"]*)\" of data currency conversion popup$")
	public void verify_viewing_of_data_currency_conversion_popup(String arg1) throws Throwable {
	    if(arg1.equalsIgnoreCase("Full-screen")) {
	    	CommonFunctionality.getElementByClassName(login.driver, "movable-modal--action-icon__expand", 4).click();
	    	String full_screen = CommonFunctionality.getElementByXpath(login.driver, "//div[@class='movable-modal--action-icon__expand']/ancestor::div[2]", 4).getAttribute("title");
	    	assertEquals(full_screen, "Exit full-screen");
	    	CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
	    } if(arg1.equalsIgnoreCase("Exit full-screen")) {
	    	CommonFunctionality.getElementByClassName(login.driver, "movable-modal--action-icon__expand", 4).click();
	    	CommonFunctionality.getElementBycssSelector(login.driver, ".movable-modal--action-icon__full-size", 4).click();
	    	String full_screen = CommonFunctionality.getElementByXpath(login.driver, "//div[@class='movable-modal--action-icon__expand']/ancestor::div[2]", 4).getAttribute("title");
	    	assertEquals(full_screen, "Full-screen");
	    	CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
	    } if(arg1.equalsIgnoreCase("Closing")) {
	    	CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
	    	List<WebElement> close = login.driver.findElements(By.cssSelector(".movable-modal--window"));
	    	assertEquals(close.size(), 0);
	    }
	    System.out.println("The "+arg1+" action is performed");
	    CommonFunctionality.Views_list();
	}
	
	@Then("^Verify default values of data currency conversion popup$")
	public void verify_default_values_of_data_currency_conversion_popup() throws Throwable {
		CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Series Harmonization']")));
		String select = CommonFunctionality.getElementByXpath(login.driver, "//select[@name='currency']/option[1]", 4).getText();
		assertEquals(select, "Keep as reported");
		String select1 = CommonFunctionality.getElementByXpath(login.driver, "//select[@name='unit']/option[1]", 4).getText();
		String b = select1.replaceAll(" ","");
		assertEquals(b, "asreported");
		CommonFunctionality.getElementBycssSelector(login.driver, ".movable-modal--window .button__primary", 4).click();
	    CommonFunctionality.Views_list();
	    System.out.println("The default values in data currency conversion popup has been verified successfully");
	}
	
	@Then("^Verify the function applied in frequency conversion popup$")
	public void verify_the_function_applied_in_frequency_conversion_popup() throws Throwable {
		CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Series Harmonization']")));
		Select select = new Select(CommonFunctionality.getElementByXpath(login.driver, "//select[@name='frequency']", 4));
		select.selectByValue("M");
		String disagg = CommonFunctionality.getElementByClassName(login.driver, "edit-series-function--description", 4).getText();
		String split[] = disagg.split(Pattern.quote("(")); 
		assertEquals(split[0], "DISAGGREGATE");
		select.selectByValue("Q");
		String agg = CommonFunctionality.getElementByClassName(login.driver, "edit-series-function--description", 4).getText();
		String split1[] = agg.split(Pattern.quote("(")); 
		assertEquals(split1[0], "AGGREGATE");
		CommonFunctionality.getElementBycssSelector(login.driver, ".movable-modal--window .button__primary", 4).click();
	    CommonFunctionality.Views_list();
	    System.out.println("The functions in frequency conversion popup has been verified successfully");
	}
	
	@Then("^The number of days should able to select in a functions End dropdown$")
	public void the_number_of_days_should_able_to_select_in_a_functions_End_dropdown() throws Throwable {
		CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Series Harmonization']")));
		CommonFunctionality.getElementByClassName(login.driver, "edit-series-function--icon", 4).click();
		String text = CommonFunctionality.getElementBycssSelector(login.driver, "div[argument='end'] .function-parameter--body .select2-chosen", 4).getText();
		assertEquals(text, "Last day of month");
		CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='function-data--info']//*[contains(text(),'Last day of month')]/following::span[1])[1]",4).click();
		List<WebElement> li_all = login.driver.findElements(By.xpath("//ul[@class='select2-results']/li"));
		if(li_all.size()!=0) {
			for(WebElement li:li_all) {
			String text1 = li.getText();
			System.out.println(text1);
			String split[] = text1.split(" ");
			if(!split[0].equals("Last")) {
			assertEquals(split[0], "Day");
			}
		}
		} else {
			fail("Failed");
		}
		login.Log4j.info("The number of days is selectable in frequency end dropdown");
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='function-data--info']//*[contains(text(),'Last day of month')]/following::span[1])[1]",4)).click().build().perform();
		CommonFunctionality.getElementBycssSelector(login.driver, ".edit-series-function--icon", 4).click();
		CommonFunctionality.getElementBycssSelector(login.driver, ".movable-modal--window .button__primary", 4).click();
	    CommonFunctionality.Views_list();
	}
	
	@Then("^The message should appear$")
	public void the_message_should_appear() throws Throwable {
		String actual = "1 of 1 series has a negative value or doesn't have a value in the selected period and it cannot be included in Pie";
		CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("growl-message-text")));
	    String text = CommonFunctionality.getElementByClassName(login.driver, "growl-message-text", 4).getText();
	    assertEquals(actual, text);
	    CommonFunctionality.Views_list();
	    System.out.println("The negative values has been verified");
	}
	
	@SuppressWarnings("deprecation")
	@Then("^Should be able to open frequency conversion popup with all the available options present$")
	public void should_be_able_to_open_frequency_conversion_popup_with_all_the_available_options_present() throws Throwable {
		CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Series Harmonization']")));
		CommonFunctionality.getElementBycssSelector(login.driver, ".series-data-conversion--buttons .button__text_purple", 4).click();
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, ".legend-item--attention", 4)).pause(500).build().perform();
		String tooltip = CommonFunctionality.getElementBycssSelector(login.driver, ".tooltip__visible", 4).getText();
		if(!tooltip.contains("Convert it to any other frequency to visualize.")) {
			fail("Verification Failed");
		}
		CommonFunctionality.getElementBycssSelector(login.driver, ".tooltip__visible .link", 4).click();
		List<WebElement> popup = login.driver.findElements(By.xpath("//*[text()='Series Harmonization']"));
		assertEquals(popup.size(), 1);
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
	    CommonFunctionality.Views_list();
	    System.out.println("Should able to open frequency conversion popup with all available options present");
	}
	
	@Then("^The Edit series panel should be opened with \"([^\"]*)\" tab$")
	public void the_Edit_series_panel_should_be_opened_with_tab(String arg1) throws Throwable {
		CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Series Harmonization']")));
		CommonFunctionality.getElementBycssSelector(login.driver, ".series-data-conversion--buttons .button__text_purple", 4).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='Edit Series']", 4).click();
		if(CommonFunctionality.getElementByXpath(login.driver, "//*[text()='Pie' and @class='sidebar-panel--tab-name-txt']", 4).isDisplayed()) {
			System.out.println("The "+arg1+" is displayed");
		} else {
			fail("Verification Failed");
		}
		ArrayList<String> right = new ArrayList<String>();
		List<WebElement> series_all = login.driver.findElements(By.cssSelector(".series-edit--title__editable"));
		for (int i= series_all.size(); i>=1; i--) {
			String series = CommonFunctionality.getElementByXpath(login.driver, "(//*[contains(@class,'series-edit--title__editable')])["+i+"]", 4).getText();
			right.add(series);
		}
		ArrayList<String> left = new ArrayList<String>();
		List<WebElement> series_all1 = login.driver.findElements(By.cssSelector(".series-name--title"));
		for (int i= 1; i<=series_all1.size(); i++) {
			String series1 = CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='series-name--title'])["+i+"]", 4).getText();
			left.add(series1);
		}
		assertEquals(right.toArray(), left.toArray());
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Rename')]", 4).click();
		List<WebElement> rename = login.driver.findElements(By.className("find-and-replace--modal-title"));
		assertEquals(1, rename.size());
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		CommonFunctionality.Views_list();
		System.out.println("The Edit series options are verified");
	}

	@SuppressWarnings("deprecation")
	@Then("^US currency should be applicable for series in visual pie$")
	public void us_currency_should_be_applicable_for_series_in_visual_pie() throws Throwable {
		CommonFunctionality.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()='Series Harmonization']")));
		List<WebElement> series = login.driver.findElements(By.cssSelector(".series-edit--title__editable"));
		for(int i=1; i<=series.size(); i++) {
			WebElement series_one = CommonFunctionality.getElementByXpath(login.driver, "(//*[contains(@class,'series-edit--title__editable')])["+i+"]", 4);
			new Actions(login.driver).moveToElement(series_one).pause(100).build().perform();
			String actual = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Functions:')]/following-sibling::*", 4).getText();
	    	String split[] = actual.split("\\(");
	    	String next_split = split[1];
	    	String final_split;
	    	if(next_split.contains(";")) {
	    		final_split = next_split.substring(0, 11);
	    	} else {
	    		final_split = next_split.substring(0, 9);
	    	}
	    	String expected = final_split.substring(0, final_split.length()-1);
	        if(!expected.contains("US Dollars")) {
	        	fail("Verification Failed");
	        }
	    }
		CommonFunctionality.Views_list();
		login.Log4j.info("US currency is applicable for series in visual pie");
	}

	@Then("^Pie visual should be created with frequency conversion window popped up$")
	public void pie_visual_should_be_created_with_frequency_conversion_window_popped_up() throws Throwable {
	    CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='movable-modal--header']//div[text()='Series Harmonization']")));
	    List<WebElement> model = login.driver.findElements(By.xpath("//*[@class='movable-modal--header']//div[text()='Series Harmonization']"));
	    assertEquals(model.size(), 1);
	    CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
	    CommonFunctionality.Views_list();
	    login.Log4j.info("The Pie visual is created with frequency conversion window popped up and verified successfully");
	}
	
	@Then("^Pie visual should add to view area by \"([^\"]*)\"$")
	public void chart_visual_should_add_to_view_area_by(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("DragandDrop")) {
			if (CommonFunctionality.getElementByXpath(login.driver,"//*[contains(@class,'empty-visual-overlay__empty-selection')]//*[text()='Pie']", 4).isDisplayed()) {
				login.Log4j.info("The Pie visual is added to view area by " + arg1);
			} else {
				fail(arg1 + " is not working");
			}
			CommonFunctionality.Views_list();
		}
	}
	
	@Then("^Frequency conversion window should be popped for selecting other than weekly frequency in same window$")
	public void frequency_conversion_window_should_be_popped_for_selecting_other_than_weekly_frequency_in_same_window() throws Throwable {
		CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='movable-modal--header']//div[text()='Series Harmonization']")));
		List<WebElement> frequency = login.driver.findElements(By.xpath("//select[@name='frequency']/option"));
	    assertEquals(6, frequency.size());
	    CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
	    CommonFunctionality.Views_list();
	    login.Log4j.info("The Pie visual is created with frequency conversion window popped up and the replacement frequency dropdown count is "+frequency.size()); 
	}

	@Then("^The Data conversion window should get closed$")
	public void the_Data_conversion_window_should_get_closed() throws Throwable {
	CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Series Harmonization']")));
	CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Cancel')]", 4).click();
	List<WebElement> close = login.driver.findElements(By.xpath("//*[text()='Series Harmonization']"));
	assertEquals(close.size(), 0);
	CommonFunctionality.Views_list();
    login.Log4j.info("The Data conversion window is getting closed"); 
	
	}
}
