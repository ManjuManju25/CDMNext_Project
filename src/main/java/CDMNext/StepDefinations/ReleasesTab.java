package CDMNext.StepDefinations;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class ReleasesTab {

	JavascriptExecutor js = (JavascriptExecutor) login.driver;
	public int count;
	public static String country_inside_dataset;
	public static String dropdown_title;
	public static String dataset_text;
	public static String watchlist_text;
	public static String new_insight_name;
	ArrayList<String> watchlist_dropdown_text = new ArrayList<String>();
	SoftAssert sa = new SoftAssert();
	
	@And("^The \"([^\"]*)\" should present$")
	public void the_should_present(String arg1) throws Throwable {
	    if(login.driver.findElements(By.xpath("//*[contains(@class,'time-frame-button')]")).size() == 12) {
	    	List<WebElement> timeframes = login.driver.findElements(By.xpath("//*[contains(@class,'time-frame-button')]"));
	    	for(int i=1; i<=timeframes.size();i++) {
	    		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'time-frame-button')]["+i+"]", 4)).click().build().perform();
	    		CommonFunctionality.wait(4000);
	    		if(login.driver.findElements(By.cssSelector(".tree-node.release-scheduler-tree-node")).size()>0) {
	    			System.out.println("Timeframe buttons are clickable");
	    		} else {
	    			sa.fail("Timeframe buttons are not clickable");
	    		}
	    	}
	    	login.Log4j.info("The "+arg1+" has been present and verified successfully");
	    } else {
	    	sa.fail(arg1+" failed");
	    }
	}
	
	@And("^Search for the series \"([^\"]*)\" in ReleasesTab$")
	public void search_for_the_series_in_ReleasesTab(String arg1) throws Throwable {
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).clear();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(arg1);
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
	}
	
	@SuppressWarnings("deprecation")
	@And("^Select \"([^\"]*)\" timeframe button$")
	public void select_timeframe_button(String arg1) throws Throwable {
		CommonFunctionality.wait(4000);
		try {
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'time-frame-button') and contains(text(),'"+arg1+"')]", 4)).pause(1000).click().build().perform();
		} catch (Exception e) {
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'time-frame-button') and contains(text(),'"+arg1+"')]", 4)).pause(1000).click().build().perform();
		}
		CommonFunctionality.wait(4000);
	}

	@And("^Hovor on to the \"([^\"]*)\" option$")
	public void hovor_on_to_the_option(String arg1) throws Throwable {
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[@title='"+arg1+"']", 4)).build().perform();
	}

	@And("^Release status \"([^\"]*)\" should present$")
	public void release_status_should_present(String arg1) throws Throwable {
		WebElement status = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='toggler-control-item--label' and contains(text(),'"+arg1+"')]", 4);
	    if(status.isDisplayed()) {
	    	login.Log4j.info(arg1+" Status is present and verified successfully");
	    } else {
	    	sa.fail(arg1+" Status is not present");
	    }
	}
	
	@And("^Hovoring \"([^\"]*)\" option from dropdown list$")
	public void hovoring_option_from_dropdown_list(String arg1) throws Throwable {
	      dropdown_title = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'dropdown-menu')]//*[text()='"+arg1+"']/parent::*", 4).getAttribute("title");
	}
	
	@And("^Growl message as \"([^\"]*)\" should display$")
	public void growl_message_as_should_display(String arg1) throws Throwable {
		String watchlist = login.driver.findElement(By.xpath("//div[@class='growl-message-text']")).getText();
		//System.out.println(watchlist);
		assertEquals(arg1, watchlist);
	}
	   
	@And("^Click on Growl popup$")
	public void click_on_Growl_popup() throws Exception {
		if(login.driver.findElements(By.className("growl-messages-container")).size()>0) {
			CommonFunctionality.getElementByClassName(login.driver, "growl-message-close", 4).click();
		}
		if(login.driver.findElements(By.xpath("//*[contains(@class,'movable-modal--window')]")).size()>0) {
		  CommonFunctionality.getElementByXpath(login.driver,"//*[@class='movable-modal--close']", 4).click(); 
		}
	}
	
	@And("^Hovoring \"([^\"]*)\" option and \"([^\"]*)\"$")
	public void hovoring_option_and(String arg1,String arg2) throws Throwable {
	      new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'"+arg1+"')]",4)).build().perform();
	      dropdown_title= CommonFunctionality.getElementByXpath(login.driver,"//span[contains(text(),'"+arg2+"')]/parent::*", 4).getAttribute("title");
	}
	
	@And("^Hovoring \"([^\"]*)\" option and get the text \"([^\"]*)\"$")
	public void hovoring_option_and_get_the_text(String arg1,String arg2) throws Throwable {
	      new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'"+arg1+"')]",4)).build().perform();
	      watchlist_text = CommonFunctionality.getElementByXpath(login.driver, "//*[@name='"+arg2+"']/following-sibling::span[2][not(contains(@class,'icon'))]", 4).getText();
	}
	
	@And("^Check the deselected option$")
	public void check_the_deselected_option() throws Throwable {
		List<WebElement> deselect_all = login.driver.findElements(By.xpath("//*[contains(@class,'toggler-control__light_purple')]//label[contains(@class,'toggler-control-item')]"));
		for(WebElement deselect:deselect_all) {
			if(deselect.getAttribute("class").contains("toggler-control-item__selected")) {
				sa.fail("Verification failed as status icon is selected");
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	@And("^Right Click the first dataset$")
	public void right_Click_the_first_dataset() throws Throwable {
		WebElement collapse = CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='release-scheduler-tree-node--title'])[1]/preceding::*[@class='toggle']/parent::div", 4);
		if(collapse.getAttribute("class").contains("full-expanded")) {
			CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='toggle'])[1]", 4).click();
		}
		CommonFunctionality.wait(2000);
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='release-scheduler-tree-node--title'])[1]", 4)).pause(500).contextClick().build().perform();
	}
	
	@And("^Get Text of Dataset$")
	public void get_Text_of_Dataset() throws Throwable {
	       dataset_text = CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='release-scheduler-tree-node--title'])[1]",4).getText();
	}
	
	@SuppressWarnings("deprecation")
	@And("^Expand first Dataset$")
	public void expand_first_dataset() throws Throwable {
		CommonFunctionality.wait(3000);
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='release-scheduler-tree-node--title'])[1]/preceding::*[@class='toggle']", 4)).pause(1000).click().build().perform();
		CommonFunctionality.wait(3000);
	}
	
	@SuppressWarnings("deprecation")
	@And("^Rename Insight to Download$")
	public void rename_Insight_to_Download() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'insight-breadcrumb--title__editable')]", 4).click();
    	WebElement name = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='insight-breadcrumb--title-input']", 4);
    	new Actions(login.driver).moveToElement(name).sendKeys(Keys.CONTROL, Keys.chord("a")).sendKeys(Keys.BACK_SPACE).build().perform();
    	new Actions(login.driver).moveToElement(name).pause(500).sendKeys("Name your insight").build().perform();
    	new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, "div[title='Click to edit the Insight']", 4)).click().build().perform();
	}
	
	@SuppressWarnings("deprecation")
	@And("^Hovor on to \"([^\"]*)\"$")
	public void hovor_on_to(String arg1) throws Throwable {
	    new Actions(login.driver).moveToElement(CommonFunctionality.getElementByClassName(login.driver, ""+arg1+"", 4)).pause(1000).build().perform();
	}
	
	@SuppressWarnings("deprecation")
	@And("^Click to \"([^\"]*)\"$")
	public void click_to(String arg1) throws Throwable {
	  CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'My insights')]", 4).click();
	  CommonFunctionality.getElementBycssSelector(login.driver, "button[title='New Insight']", 4).click();
	  new_insight_name = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'sphere-modal__content')]//input[@class='form--control']", 4).getAttribute("value");
	  CommonFunctionality.getElementByXpath(login.driver, "//*[text()='Create insight' and contains(@class,'button__primary')]", 4).click();
	  WebElement source = CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='series-item--name'])[1]", 4);
	  WebElement target = CommonFunctionality.getElementBycssSelector(login.driver, ".data-selection-series-overlay.data-selection-series-overlay__data  ", 4);
	  new Actions(login.driver).moveToElement(source).pause(2000).dragAndDrop(source, target).build().perform();
	  login.driver.navigate().refresh();
	  Comparables co = new Comparables();
	  co.clicking_icon("Releases");
	  expand_first_dataset();
	  co.hovor_on_to_i_icon_without_click();
	  co.click_option_in_series("Show related data");
	  WebElement text = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Insights')]", 4);
	  js.executeScript("arguments[0].scrollIntoView(true);",text);
	  if(!(text.isDisplayed())) {
  		   fail("Related Insights block is not displayed");
  	   }
	  if(login.driver.findElements(By.xpath("(//*[text()='"+new_insight_name+"']/preceding::*[contains(@title,'favorite')])[1]/following-sibling::div[@title='"+arg1+"']")).size()==0) {
		  fail("Shared insight icon is displayed while creating a new insight instead of Share insight icon");
	  }
	}
	
	@SuppressWarnings("deprecation")
	@And("^Right click the first series$")
	public void right_click_the_first_series() throws Throwable {
	    new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='series-item--name'])[1]", 4)).pause(1000).contextClick().build().perform();
	}
		
	@SuppressWarnings("deprecation")
	@And("^Select first Dataset$")
	public void select_first_dataset() throws Throwable {
		CommonFunctionality.wait(3000);
		WebElement dataset = CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='release-scheduler-tree-node--title']/preceding-sibling::span)[1]", 4);
		if(!dataset.getAttribute("class").contains("svg-checkbox__selected")) {
			new Actions(login.driver).moveToElement(dataset).pause(1000).click().build().perform();
		} else {
			fail("Dataset is already selected");
		}
	}
	
	@And("^Get the text of expanded Dataset$")
	public void get_the_text_of_expanded_dataset() throws Throwable {
		String dataset = CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='toggle'])[1]//following::span[@class='release-scheduler-tree-node--title'][1]", 4).getText();
		String split_text[] = dataset.split("\\:");
		country_inside_dataset = split_text[0];
	}
	
	@SuppressWarnings("deprecation")
	@And("^Clicking the release status as \"([^\"]*)\"$")
	public void clicking_the_release_status_as(String arg1) throws Throwable {
		CommonFunctionality.wait(4000);
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[@class='toggler-control-item--label' and contains(text(),'"+arg1+"')]", 4)).pause(1000).click().build().perform();
		CommonFunctionality.wait(4000);
	}
	
	@And("^The \"([^\"]*)\" buttton should present$")
	public void the_buttton_should_present(String arg1) throws Throwable {
	    WebElement load = CommonFunctionality.getElementBycssSelector(login.driver, ".nodes-list--more-button", 4);
	    js.executeScript("arguments[0].scrollIntoView(true);",load);
		   if(!(load.isDisplayed())) {
			   fail("Verification Failed");
		   }
     }
	
	@And("^Select released database$")
	public void select_related_database() throws Throwable {
	    new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,"(//*[contains(@class,'release-scheduler-tree-node--marker__released')])[1]/following::*[@class='toggle'][1]", 4)).click().build().perform();
     }
	
	@SuppressWarnings("deprecation")
	@And("^Select \"([^\"]*)\" option from watchlist$")
	public void select_option_from_watchlist(String arg1) throws Throwable {
		CommonFunctionality.wait(1500);
	    watchlist_dropdown_text.add(arg1);
	    boolean checkbox = login.driver.findElement(By.xpath("//*[@class='items-wrapper']//*[contains(text(),'"+arg1+"')]/preceding-sibling::input")).isSelected();
	    if(checkbox == false) {
	      new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[@class='items-wrapper']//*[contains(text(),'"+arg1+"')]/preceding-sibling::span", 4)).pause(1000).click().build().perform();
	    }
     }
	
	@Then("^By default (\\d+) datasets should present$")
	public void by_default_datasets_should_present(int arg1) throws Throwable {
		count = arg1;
	    if(login.driver.findElements(By.cssSelector(".tree-node.release-scheduler-tree-node")).size() == count) {
	    	login.Log4j.info("By default "+count+" datasets has been present and verified successfully");
	    } else {
	    	fail("Datasets mismatch");
	    }
	}
	
	@Then("^Verify no release status should select$")
	public void verify_no_release_status_should_select() throws Throwable {
	    WebElement no_release = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'toggler-control__light_purple')]//label[contains(@class,'toggler-control-item')]", 4);
	    if(!(no_release.getAttribute("class").contains("toggler-control-item__selected"))) {
	    	List<WebElement> releases = login.driver.findElements(By.xpath("//*[contains(@class,'release-scheduler-tree-node--markers')]"));
	    	if(!(releases.size() == count)) {
	    		fail(count+" is not equal as dataset count");
	    	}
	    	} else {
	    	    fail("Verification Failed");
	        }
	    login.Log4j.info("No release status is selected and has been verified successfully");
	}
	
	@Then("^Verify the \"([^\"]*)\" dataset$")
	public void verify_the_dataset(String arg1) throws Throwable {
	    if(arg1.equalsIgnoreCase("expanded")) {
	    	List<WebElement> all_country = login.driver.findElements(By.xpath("//*[contains(@class,'country-information')]"));
	    	for(WebElement country:all_country) {
	    		String country_name = country.getText();
	    		assertEquals(country_name, country_inside_dataset);
	    	}
	    } if(arg1.equalsIgnoreCase("collapsed")) {
	    	expand_first_dataset();
	    	WebElement collapse = CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='toggle'])[1]/parent::div", 4);
	    	if(collapse.getAttribute("class").contains("full-expanded")) {
	    		fail("Tree is not collapsed");
	    	}
	    }
	    login.Log4j.info("The dataset is "+arg1+" and has been verified successfully");
	}
	
	@Then("^Only \"([^\"]*)\" status icon should present$")
	public void only_status_icon_should_present(String arg1) throws Throwable {
	    if(arg1.equalsIgnoreCase("Released")) {
	    	if(login.driver.findElements(By.cssSelector("span[title='Released']")).size()>0) {
	    	   if(login.driver.findElements(By.xpath("//*[@class='release-scheduler-tree-node--markers']/span[not(contains(@title,'elease'))]")).size()>0 || login.driver.findElements(By.cssSelector("span[title='Delayed releases']")).size()>0) {
	    		   fail("Other icons are also present on clicking "+arg1+ " status icon");   
	    	   }
	    	} else {
	 	    	fail("No data is present on clicking "+arg1+" tab");
	 	    }
         } if(arg1.equalsIgnoreCase("Pending")) {
    	  if(login.driver.findElements(By.cssSelector(".release-scheduler-tree-node .release-scheduler-tree-node--markers")).size()>0) {
	    	   if(login.driver.findElements(By.cssSelector("span[title='Released']")).size()>0 || login.driver.findElements(By.cssSelector("span[title='Delayed releases']")).size()>0) {
	    		   fail("Other icons are also present on clicking "+arg1+ " status icon");   
	    	   }
	    	} else {
	 	    	fail("No data is present on clicking "+arg1+" tab");
	 	    }
         } if(arg1.equalsIgnoreCase("Delayed")) {
        	select_timeframe_button("-1Y");
    	    if(login.driver.findElements(By.cssSelector("span[title='Delayed releases']")).size()>0) {
	    	   if(login.driver.findElements(By.cssSelector("span[title='Released']")).size()>0 || login.driver.findElements(By.cssSelector("span[title='Delayed releases']")).size()>50) {
	    		   fail("Other icons are also present on clicking "+arg1+ " status icon");   
	    	   }
	    	} else {
	 	    	sa.fail("No data is present on clicking "+arg1+" tab");
	 	    }
	    } if(arg1.equalsIgnoreCase("All")) {
	    	select_timeframe_button("-1Y");
    	    if(!(login.driver.findElements(By.xpath("//*[contains(@class,'release-scheduler-tree-node--marker__released')]")).size()>0 || login.driver.findElements(By.cssSelector(".release-scheduler-tree-node--marker__delayed")).size()>0)) {
	    		   sa.fail("No data is present on clicking "+arg1+" tab");   
	    	   }
	    }
	    login.Log4j.info(arg1+" status icon is present and has been verified successfully");
	}
	
	@Then("^Download button should enable and x series selected should appear in search$")
	public void download_button_should_enable_and_x_series_selected_should_appear_in_search() throws Throwable {
	    WebElement download = CommonFunctionality.getElementBycssSelector(login.driver, ".download-button--button.button.button__download-btn", 4);
	    if(download.isEnabled()) {
	    	login.Log4j.info("Download button is enabled");
	    } else {
	    	sa.fail("Verification Failed");
	    }
	    String text = CommonFunctionality.getElementByClassName(login.driver, "search-input--selected-count", 4).getText();
	    int count = Integer.parseInt(text);
	    if(count != 0) {
	    	WebElement series_count = CommonFunctionality.getElementBycssSelector(login.driver,"span[title='Edit your result selection']", 4);
	    	if(series_count.isDisplayed()) {
	    		login.Log4j.info("The Series count is displaying in search box");
	    	} else {
	    		sa.fail("Series count is not displaying");
	    	}
	    } else {
	    	sa.fail("Count is equal to 0");
	    }
	}
	
	@Then("^\"([^\"]*)\" , \"([^\"]*)\" Options should present$")
	public void options_should_present(String arg1, String arg2) throws Throwable {
	    String title = CommonFunctionality.getElementByClassName(login.driver, "add-to-data-selection--title", 4).getAttribute("title");
	    String split[] = title.split("\n");
	    String actual = split[0];
	    String expected = split[1];
	    if(actual.contains(arg1) && expected.contains(arg2)) {
	    	login.Log4j.info("The title present is: "+arg1+" and "+arg2);
	    } else {
	    	sa.fail("Title is not present");
	    }
	}
	
	@Then("^The \"([^\"]*)\" tooltip should be displayed$")
	public void the_tooltip_should_be_displayed(String arg1) throws Throwable {
	    sa.assertEquals(arg1, dropdown_title);
	    login.Log4j.info("The "+arg1+" has been verified successfully");
	}
	
	@Then("^The \"([^\"]*)\" watchlist tooltip should be displayed$")
	public void the_watchlist_tooltip_should_be_displayed(String arg1) throws Throwable {
	    sa.assertEquals(arg1, watchlist_text);
	    login.Log4j.info("The "+arg1+" has been verified successfully");
	}
		
	@Then("^Check the download button and search box$")
	public void check_the_download_button_and_search_box() throws Throwable {
		CommonFunctionality.wait(6000);
		WebElement download = login.driver.findElement(By.xpath("//*[contains(@title,'Download')]"));
		CommonFunctionality.wait(4000);
		if(download.getAttribute("class").contains("download-button__unavailable")) {
	    	login.Log4j.info("Download button is disabled");
	    } else {
	    	sa.fail("Download button is not disabled");
	    }
	    String text = login.driver.findElement(By.className("series-series-count--number")).getText();
	    int count = Integer.parseInt(text);
	    if(count == 0) {
	    	WebElement series_count = login.driver.findElement(By.cssSelector("span[title='Edit your result selection']"));
	    	if(!series_count.isDisplayed()) {
	    		login.Log4j.info("The Series count is not displaying in search box");
	    	} else {
	    		sa.fail("Series count is displaying");
	    	}
	    } else {
	    	sa.fail("Count is equal to 0");
	    }
	}
	
	@Then("^The Dataset level series are added into my series panel$")
	public void the_Dataset_level_series_are_added_into_my_series_panel() throws Throwable {
		CommonFunctionality.wait(2000);
	    String expected = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-name-wrapper']//following-sibling::*[@class='group-name']", 4).getText();
	    CommonFunctionality.DeleteSeries();
	    sa.assertEquals(expected, dataset_text);
	    login.Log4j.info("The Dataset is added into my series panel and it has been verified successfully");
	}
	
	@Then("^Clicking on the insight name should open the new insight for Dataset$")
	public void clicking_on_the_insight_name_should_open_the_new_insight_for_Dataset() throws Throwable {
		login.driver.findElement(By.xpath("//*[@class='growl-message growl-success']//*[@class='button button__sm button__primary'] | //*[@class='growl-message growl-success']//*[@class='button growl-message-content--btns__fill']")).click();
		ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(newTab.get(1));
		String expected = CommonFunctionality.getElementByClassName(login.driver, "group-name", 4).getText();
		CommonFunctionality.DeleteSeries();
		login.driver.switchTo().window(newTab.get(1)).close();
		Thread.sleep(1000);
		login.driver.switchTo().window(newTab.get(0));
		Thread.sleep(1000);
		CommonFunctionality.DeleteSeries();
		assertEquals(dataset_text, expected);
		System.out.println("New insight with the added series is opened and has been verified successfully");
   }
	
	@SuppressWarnings("deprecation")
	@Then("^The \"([^\"]*)\" Option Should show$")
	public void the_Option_Should_show(String arg1) throws Throwable {
		if(arg1.equalsIgnoreCase("Multiple Footnotes")  || arg1.equalsIgnoreCase("Multiple Footnotes - More actions")) {
	 	   List<WebElement> footnotes = login.driver.findElements(By.xpath("//*[@title='Footnotes']//following-sibling::ul[@class='dropdown-menu']/li/span/span/b"));
	 	   for(int i=1;i<=footnotes.size();i++) {
	 		String footnotes_text = CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Footnotes']//following-sibling::ul[@class='dropdown-menu']/li["+i+"]/span/span/b", 4).getText();
			CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Footnotes']//following-sibling::ul[@class='dropdown-menu']/li["+i+"]", 4).click();
			CommonFunctionality.wait(2000);
			String breadcrumb = CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='footnotes-bread-crumb--title'])[1]", 4).getText();
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			assertEquals(footnotes_text, breadcrumb);
			if(i != footnotes.size()) {
			if(arg1.equalsIgnoreCase("Multiple Footnotes - More actions")) {
			new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'country-information')]", 4)).pause(1000).build().perform();
			new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[@title='More actions']", 4)).click().build().perform();
			} else {
			right_click_the_first_series();
			}
			hovor_on_to_the_option("Footnotes");
			}
	 	   }
	 	   } if(arg1.equalsIgnoreCase("Multiple Dataset") || arg1.equalsIgnoreCase("Multiple Dataset - More actions")) {
	 	   List<WebElement> datasets = login.driver.findElements(By.xpath("//*[@title='Show Dataset']//following-sibling::ul[@class='dropdown-menu']/li/span/span/b"));
		   for(int i=1;i<=datasets.size();i++) {
		   CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Show Dataset']//following-sibling::ul[@class='dropdown-menu']/li["+i+"]", 4).click();
    	   WebElement series = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'series-list-item__selected')]//*[contains(text(),'"+Comparables.hovered_series_name+"') and not(@style='')]/ancestor::li", 4);
    	   js.executeScript("arguments[0].scrollIntoView(true);",series);
    	   if(series.getAttribute("class").contains("series-list-item__selected") && series.getAttribute("class").contains("series-list-item__highlighted")) {
    		 CommonFunctionality.getElementByClassName(login.driver, "insight-discovery--popup-back-button", 4).click();
    	   } else {
    		   sa.fail("Verification Failed");
    	   }
    	   if(i != datasets.size()) {
   			Comparables co = new Comparables();
   			co.hovor_on_to_i_icon_without_click();
   			if(arg1.equalsIgnoreCase("Multiple Dataset - More actions")) {
   			new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'country-information')]", 4)).pause(1000).build().perform();
   			new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[@title='More actions']", 4)).click().build().perform();	
   			} else {
    		right_click_the_first_series();
   			}
   			hovor_on_to_the_option("Show Dataset");
	       }
		   }
	 	   }
		login.Log4j.info("The "+arg1+" option has been verified successfully");
		}
	
	@Then("^The \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" options should available$")
	   public void the_options_should_available(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) throws Throwable {
	       List<WebElement> items = login.driver.findElements(By.xpath("//*[@class='items-wrapper']/li/span[not(contains(@class,'dropdown-submenu-icon')) and not(contains(@title,'View on Administrative Map'))]"));
	       for(WebElement item:items) {
	    	   String value = item.getAttribute("title");
	    	   if(value.equals(arg1) || value.equals(arg2) || value.equals(arg3) || value.equals(arg4) || value.equals(arg5) || value.equals(arg6)) {
	    		  login.Log4j.info(value+" option is present on hovoring/right clicking the Datatable");
	    	   } else {
	    		   sa.fail(item+" not present");
	    	   }
	       }
	   }
	
	@Then("^The \"([^\"]*)\" button should present$")
	public void the_button_should_present(String arg1) throws Throwable {
	  WebElement load = login.driver.findElement(By.xpath("//*[@class='nodes-list--footer']//*[@js-more-indicators='' and contains(text(),'"+arg1+"')]"));
	  if(login.driver.findElements(By.xpath("//*[@class='nodes-list--footer']//*[@js-more-indicators='' and contains(text(),'"+arg1+"')]")).size()>0) { 
		CommonFunctionality.wait(2000);
		js.executeScript("arguments[0].scrollIntoView(true);",load);
		if(load.isDisplayed()) {
			 new Actions(login.driver).moveToElement(load).click().build().perform();
			 login.Log4j.info("The "+arg1+" button is present and verified successfully");
		} else {
			 sa.fail("Verification Failed");
		}
	  } else {
		select_timeframe_button("-1Y");
		CommonFunctionality.wait(2000);
		js.executeScript("arguments[0].scrollIntoView(true);",load);
		if(load.isDisplayed()) {
			 new Actions(login.driver).moveToElement(load).click().build().perform();
			 login.Log4j.info("The "+arg1+" button is present and verified successfully");
		} else {
			 sa.fail("Verification Failed");
		}
	  }
	}
	
	@Then("^Selected dataset should get deselected$")
	public void selected_dataset_should_get_deselected() throws Throwable {
	    WebElement deselect = CommonFunctionality.getElementByXpath(login.driver,"(//*[@class='release-scheduler-tree-node--title'])[1]/preceding-sibling::*", 4);
	    if(deselect.getAttribute("class").contains("svg-checkbox__selected")) {
 		   sa.fail("Verification Failed");
 	   }
	  login.Log4j.info("The Unselect all in Dataset has been verified successfully");
	}
	
	@Then("^The \"([^\"]*)\" option in dataset should get verified$")
	public void the_option_in_dataset_should_get_verified(String arg1) throws Throwable {
		if(arg1.equalsIgnoreCase("Edit Chart")) {
		if(login.driver.findElements(By.xpath("//*[text()='Confirmation']//following::*[contains(text(),'Proceed with 20 series?')]")).size()>0) {
		   CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']", 4).click();
		   CommonFunctionality.wait(3000);
		   click_on_Growl_popup();
		   List<WebElement> series = login.driver.findElements(By.cssSelector(".series-edit--title.series-edit--title__editable"));
		   sa.assertEquals(20, series.size());
		} else {
		   click_on_Growl_popup();
		   List<WebElement> chart_series = login.driver.findElements(By.cssSelector(".series-edit--title.series-edit--title__editable"));
 		   int actual = Comparables.series_count_inside_first_table;
 		   int expected = chart_series.size();
 		   assertEquals(actual, expected);
 		   String text = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='visual-top-panel--left-controls']//*[contains(@class,'button__special')]",4).getText();
 		   sa.assertEquals(text, arg1);
		}
		}if(arg1.equalsIgnoreCase("Edit Map")) {
  		   List<WebElement> map_series = login.driver.findElements(By.xpath("//*[@class='highcharts-series-group']//following::*[contains(@class,'highcharts-data-label-color-1')]"));
  		   int actual = Comparables.series_count_inside_first_table;
  		   int expected = map_series.size();
  		   sa.assertEquals(actual, expected);
  		   String text = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='visual-top-panel--left-controls']//*[contains(@class,'button__special')]",4).getText();
  		   assertEquals(text, arg1);
		}if(arg1.equalsIgnoreCase("Edit Table")) {
		if (login.driver.findElements(By.xpath("//*[text()='Confirmation']//following::*[contains(text(),'Proceed with')]")).size()>0) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']", 4).click();
			CommonFunctionality.wait(3000);
			List<WebElement> series = login.driver.findElements(By.className("series-edit"));
			sa.assertEquals(100, series.size());
		} else {
		   List<WebElement> table_series = login.driver.findElements(By.className("series-edit"));
 		   int actual = Comparables.series_count_inside_first_table;
 		   int expected = table_series.size();
 		   sa.assertEquals(actual, expected);
 		   String text = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='visual-top-panel--left-controls']//*[contains(@class,'button__special')]",4).getText();
 		   sa.assertEquals(text, arg1);
		}
		}if(arg1.equalsIgnoreCase("Edit Pie")) {
		if (login.driver.findElements(By.xpath("//*[text()='Confirmation']//following::*[contains(text(),'Proceed with')]")).size()>0) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']", 4).click();
			CommonFunctionality.wait(3000);
			List<WebElement> series = login.driver.findElements(By.cssSelector(".series-edit--title.series-edit--title__editable"));
			sa.assertEquals(20, series.size());
		} else {
		   List<WebElement> pie_series = login.driver.findElements(By.cssSelector(".series-edit--title.series-edit--title__editable"));
 		   int actual = Comparables.series_count_inside_first_table;
 		   int expected = pie_series.size();
 		   sa.assertEquals(actual, expected);
 		   String text = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='visual-top-panel--left-controls']//*[contains(@class,'button__special')]",4).getText();
 		   sa.assertEquals(text, arg1);
		}
		}if(arg1.equalsIgnoreCase("Edit Heat map")) {
		if (login.driver.findElements(By.xpath("//*[text()='Confirmation']//following::*[contains(text(),'Proceed with')]")).size()>0) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']", 4).click();
			CommonFunctionality.wait(3000);
			List<WebElement> series = login.driver.findElements(By.cssSelector(".series-edit--title.series-edit--title__editable"));
			sa.assertEquals(20, series.size());
		} else {
		   List<WebElement> heatmap_series = login.driver.findElements(By.cssSelector(".series-edit--title.series-edit--title__editable"));
 		   int actual = Comparables.series_count_inside_first_table;
 		   int expected = heatmap_series.size();
 		   sa.assertEquals(actual, expected);
 		   String text = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='visual-top-panel--left-controls']//*[contains(@class,'button__special')]",4).getText();
 		   sa.assertEquals(text, arg1);
		}
		} if(arg1.equalsIgnoreCase("Edit Histogram")) {
  		   List<WebElement> histogram_series = login.driver.findElements(By.xpath("//*[contains(@class,'highcharts-legend-item')]//following-sibling::*[contains(@class,'highcharts-histogram-series')]"));
  		   int actual = Comparables.series_count_inside_first_table;
  		   int expected = histogram_series.size();
  		   if(actual != expected || actual == 1) {
  			 String text = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='visual-top-panel--left-controls']//*[contains(@class,'button__special')]",4).getText();
  			 sa.assertEquals(arg1, text);
  		   }
		}
		CommonFunctionality.Views_list();
		login.Log4j.info("The "+arg1+" Option in Dataset has been verified successfully");
	}
		
	@Then("^The \"([^\"]*)\" link should display in \"([^\"]*)\" color$")
	public void the_link_should_display_in_color(String arg1, String arg2) throws Throwable {
	    String actual = CommonFunctionality.getElementByXpath(login.driver, "//div[@class='selection-control' and not(contains(@style,'display: none;'))]", 4).getText();
	    String unselect_color = CommonFunctionality.getElementByXpath(login.driver, "//div[@class='selection-control' and not(contains(@style,'display: none;'))]", 4).getCssValue("color");
	    String red = Color.fromString(unselect_color).asHex();
	    sa.assertEquals(actual, arg1);
	    sa.assertEquals(red, arg2);
	    login.Log4j.info("The "+arg1+" color has been verified successfully");
	}
	
	@Then("^The \"([^\"]*)\" link should be clicked$")
	public void the_link_should_be_clicked(String arg1) throws Throwable {
	   CommonFunctionality.getElementByXpath(login.driver, "//div[@class='selection-control' and not(contains(@style,'display: none;')) and text()='"+arg1+"']", 4).click();
	   for(int i=1; i<= Comparables.series_count_inside_table; i++) {
			WebElement ele = CommonFunctionality.getElementByXpath(login.driver, "//ul[contains(@class,'search-series-list')]/li["+i+"]", 4);
			if(ele.getAttribute("class").contains("series-list-item__selected")) {
			   	 sa.fail("Verification Failed");
			 }
		} 
	    String count = login.driver.findElement(By.className("search-input--selected-count")).getAttribute("innerHTML");
		String actual;
		if(count.contains("selected")) {
			String input[] = count.split("\\s+");
			actual = input[0];
		} else {
			actual = count;
		}
		int counting = Integer.parseInt(actual);
		Assert.assertNotEquals(Comparables.series_count_inside_table, counting);
	   login.Log4j.info("The "+arg1+" option has been clicked and verified successfully");
   }
	
	@SuppressWarnings("deprecation")
	@And("^The date \"([^\"]*)\" difference in timeframe buttons should match$")
	public void the_date_difference_in_timeframe_buttons_should_match(String arg1) throws Throwable {
		    CommonFunctionality.wait(500);
	    	String timeframe_date = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'"+arg1+"')]", 4).getText();
	    	new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'"+arg1+"')]", 4)).pause(1000).click().build().perform();
	    	CommonFunctionality.wait(2000);
	    	if(!timeframe_date.equals("TODAY")) {
	    	String date = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'"+arg1+"')]", 4).getAttribute("title");
	    	String start[] = date.split(" - ");
	    	String stDate = start[0];
	    	String enDate = start[1];
	    	Date startDate=new SimpleDateFormat("MM/dd/yyyy").parse(stDate);
	    	Date endDate=new SimpleDateFormat("MM/dd/yyyy").parse(enDate);
	    	Calendar sDate = Calendar.getInstance();
	    	Calendar eDate = Calendar.getInstance();
	    	sDate.setTime(startDate);
		    eDate.setTime(endDate);	
	    	if(timeframe_date.equals("-1Y")) {
	    		int diff = sDate.get(Calendar.YEAR) - eDate.get(Calendar.YEAR);
	    		String SubString = timeframe_date.substring(0, 2);
	    		String actual = String.valueOf(diff);
	    		sa.assertEquals(actual, SubString);
    		} if(timeframe_date.equals("-1M") || timeframe_date.equals("-3M")) {
    			int diff = sDate.get(Calendar.MONTH) - eDate.get(Calendar.MONTH);
    			String SubString = timeframe_date.substring(0, 2);
    			String actual = String.valueOf(diff);
    			sa.assertEquals(actual, SubString);
    		} if(timeframe_date.equals("-1W")) {
    			int diff = sDate.get(Calendar.WEEK_OF_YEAR) - eDate.get(Calendar.WEEK_OF_YEAR);
    			String SubString = timeframe_date.substring(0, 2);
    			String actual = String.valueOf(diff);
    			sa.assertEquals(actual, SubString);
    		} if(timeframe_date.equals("-1D")) {
    			int diff = sDate.get(Calendar.DAY_OF_MONTH) - eDate.get(Calendar.DAY_OF_MONTH);
    			String SubString = timeframe_date.substring(0, 2);
    			String actual = String.valueOf(diff);
    			sa.assertEquals(actual, SubString);
    		}  if(timeframe_date.equals("+1Y")) {
    			int diff = eDate.get(Calendar.YEAR) - sDate.get(Calendar.YEAR);
    			String SubString = timeframe_date.substring(1, 2);
    			String actual = String.valueOf(diff);
    			sa.assertEquals(actual, SubString);
    		} if(timeframe_date.equals("+1M") || timeframe_date.equals("+3M")) {
    			int diff = eDate.get(Calendar.MONTH) - sDate.get(Calendar.MONTH);
    			String SubString = timeframe_date.substring(1, 2);
    			String actual = String.valueOf(diff);
    			sa.assertEquals(actual, SubString);
    		} if(timeframe_date.equals("+1W")) {
    			int diff = eDate.get(Calendar.WEEK_OF_YEAR) - sDate.get(Calendar.WEEK_OF_YEAR);
    			String SubString = timeframe_date.substring(1, 2);
    			String actual = String.valueOf(diff);
    			sa.assertEquals(actual, SubString);
    		} if(timeframe_date.equals("+1D")) {
    			int diff = eDate.get(Calendar.DAY_OF_MONTH) - sDate.get(Calendar.DAY_OF_MONTH);
    			String SubString = timeframe_date.substring(1, 2);
    			String actual = String.valueOf(diff);
    			sa.assertEquals(actual, SubString);
    		}
	    		login.Log4j.info("The "+timeframe_date+" has been verified successfully");
	    	}
	}
	
	@Then("^The selected actions should reflect inside watchlist tab$")
	public void the_selected_actions_should_reflect_inside_watchlist_tab() throws Throwable {
	  new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,"//*[@class='search-presentation-tabs--visible']//*[contains(text(),'Watchlist')]", 4)).click().build().perform();
	  String actual;
	  if(Comparables.series_name.equalsIgnoreCase("Real GDP: YoY: Quarterly: sa: Australia")) {
		actual = "Real GDP: YoY: sa";  
	  } else {
	    actual = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'"+Comparables.series_name+"')]", 4).getText();
	  }
	  String text;
	  if(Comparables.series_name.equalsIgnoreCase("Real GDP: YoY: Quarterly: sa: Australia")) {
		text = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Real GDP: YoY: sa')]/following::*[@class='series-item-information--additional-text'][1]", 4).getText();
	  } else {
		text = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'"+Comparables.series_name+"')]/following::*[@class='series-item-information--additional-text'][1]", 4).getText();
	  }
	  String split[] = text.split("\\,");
	  String replace = split[0];
	  String expected;
	  if(replace.contains("Popup")) {
		expected = replace.replaceAll("Popup", "Pop-up notifications");  
	  } else {
		expected = replace;
	  }
	  String split1[] = split[1].split("\\ email");
	  String text1 = split1[0];
	  String expected12 = text1.substring(1, 2).toUpperCase();
	  String expected13 = text1.substring(2,text1.length());
	  String expected1 = expected12+expected13;
	  if(Comparables.series_name.equalsIgnoreCase("Real GDP: YoY: Quarterly: sa: Australia")) {
		  sa.assertEquals("Real GDP: YoY: sa", actual);
	  } else {
	     sa.assertEquals(Comparables.series_name, actual);
	  }
	  if(watchlist_dropdown_text.contains(expected) && watchlist_dropdown_text.contains(expected1)) {
		  login.Log4j.info("The Watchlist functionality has been verified successfully");
	  } else {
		  sa.fail("Watchlist verification failed");
	  }
	}
	
	@Then("^The \"([^\"]*)\" for series should present$")
	public void the_for_series_should_present(String arg1) throws Throwable {
	   String title = CommonFunctionality.getElementByXpath(login.driver, "//span[@title='"+arg1+"']", 4).getAttribute("title");
	   sa.assertEquals(title, arg1);
	   login.Log4j.info("The "+arg1+" icon is present and has been verified successfully");
	}
}