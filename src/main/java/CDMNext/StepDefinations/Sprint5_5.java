package CDMNext.StepDefinations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.AssertJUnit;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;


public class Sprint5_5 extends CommonFunctionality{
	public String Expected_Series;
	
	@Then("^The \"([^\"]*)\" checkbox should be checked by default$")
	public void the_checkbox_should_be_checked_by_default(String arg1) throws Throwable {
	  wait(500);
	  boolean alternative_data_checkbox = login.driver.findElement(By.xpath("//*[@title='" + arg1 + "']/ancestor::*[@class='filter-item--title']/*/*//input[@type='checkbox']")).isSelected();
	  if( alternative_data_checkbox == true) {
		  login.Log4j.info(arg1+ " checkbox is checked by default");
	  } else {
		  Assert.fail(arg1 + " checkbox is not checked by default");
	  }
	}
	
	@Then("^The \"([^\"]*)\" should be displayed on the top always$")
	public void the_should_be_displayed_on_the_top_always(String arg1) throws Throwable {
		  wait(500);
		  List<WebElement> alternative_dropdown_items = login.driver.findElements(By.xpath("//*[@class='filter-list']/*//*[@class='filter-item--title']//*[@class='text-dots']"));
		  for (int i = 0 ; i < alternative_dropdown_items.size();) {
			  if(alternative_dropdown_items.get(i).getText().equalsIgnoreCase(arg1)) {
				  login.Log4j.info(arg1+ " is displayed on the top always");
			  } else {
				  Assert.fail(arg1 + " is not displayed on the top of the list of items");
			  }
			  break;
		  }
		  
	}
	
	@Then("^The button name should be \"([^\"]*)\"$")
	public void the_button_name_should_be(String arg1) throws Throwable {
	    wait(500);
	    WebElement button_name = getElementByXpath(login.driver, "//*[@data-id='alternative']//*[@class='dropdown-search-filter-title--text']", 6);
	    if(button_name.getText().equalsIgnoreCase(arg1)) {
	    	 login.Log4j.info("The button name is: "+ arg1);
	    } else {
	    	Assert.fail("Verification failed");
	    }
	}
	@Then("^The \"([^\"]*)\" tag should be displayed for all series\\.$")
	public void the_tag_should_be_displayed_for_all_series(String arg1) throws Throwable {
		wait(3000);

		List<WebElement> li_All =  login.driver.findElements(By.xpath("//*[@class='series-representation']/*//*[@class='series-item--name']"));
		login.Log4j.info("List size is :" + li_All.size());
		String strLabel = null;
		if (li_All.size() > 0) {
			for (int i = 0; i < li_All.size(); i++) {
				int j = i + 1;
//				CommonFunctionality.wait(1000);
//				WebElement checkbox = login.driver
//						.findElement(By.xpath("//*[@class='series-representation']/*[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
//				checkbox.click();
				wait(600);
			
				WebElement element = login.driver.findElement(By.xpath("(//*[@class='series-representation--list']//*[@unselectable='on']//div[@class='series-item--status-icons']//*[@title='Alternative series'])[" + j +"]"));
				
				// Until the element is not visible keep scrolling
				jse.executeScript("arguments[0].scrollIntoView(true);", element);
				login.Log4j.info(strLabel);
				if (element.getText().equalsIgnoreCase(arg1)) {
					login.Log4j.info(arg1 + " is displayed for " + arg1);
				} else {
					Assert.fail(arg1 + " is not displayed for " + arg1);
				}
			}
		} else {
			Assert.fail("failed");
		}
	}
	
	@And("^Switch on \"([^\"]*)\" mode$")
	public void switch_on_mode(String arg1) throws Throwable {
		getElementByXpath(login.driver, "//*[@class='toggler-control-wrapper']/*/*[2]", 6).click();
	}

	@And("^Mouse hover on series$")
	public void mouse_hover_on_series() throws Throwable {
	   WebElement series = getElementByXpath(login.driver, "//*[@class='webix_column  webix_first']/*/*//*[@class='series-name-field--series-name']", 6);
	   new Actions(login.driver).moveToElement(series).build().perform();
	}

	@Then("^The series should be \"([^\"]*)\"$")
	public void the_series_should_be(String arg1) throws Throwable {
	   WebElement text_align = getElementByXpath(login.driver, "//*[@class='series-name-field--series-name']", 6);
	   String actual = text_align.getCssValue("text-decoration");
	   login.Log4j.info(actual);
	   if(actual.contains(arg1)) {
		   login.Log4j.info("The series is displayed in " + arg1 +" format" );
	   } else {
		   Assert.fail("The series is not displayed in " + arg1 +" format");
	   }
	   
	}
	@Then("^Check toolbar and the toolbar should be greyed out instead of hiding$")
	public void check_toolbar_and_the_toolbar_should_be_greyed_out_instead_of_hiding() throws Throwable {
	   WebElement greyedout =login.driver.findElement(By.xpath("//*[@class='panels-container disabled']"));
	   if(greyedout.isDisplayed() == true) {
		   login.Log4j.info("The toolbar is disabled/greyedout when none of the series are selected" );
	   } else {
		   Assert.fail("The toolbar is not disabled/greyedout when none of the series are selected");
	   }
	}
	@And("^Right-click on the series$")
	public void right_click_on_the_series() throws Throwable {
		
	   WebElement sname = getElementByXpath(login.driver, "//*[@class='series-name-field--series-name']", 6);
	   Expected_Series = sname.getText();
	   new Actions(login.driver).contextClick(sname).build().perform();
	   
	}
	@And("^Select \"([^\"]*)\" in series right click under my series$")
	public void select_in_series_right_click_under_my_series(String arg1) throws Throwable {
		wait(500);
		right_click_on_the_series();
		login.Log4j.info("Clicking on " + arg1);
		getElementByXpath(login.driver,"//div[@class='items-wrapper']//span[@title='" + arg1 + "']",8)
		.click();

	}

	@And("^The Paste option should be present and work$")
	public void the_Paste_option_should_be_present_and_work() throws Throwable {
		wait(1000);
		WebElement growltext = getElementByXpath(login.driver,"//div[@class='growl-message-text']",8);
		
		if (growltext.getText().contains("Data pasted from clipboard")) {
			login.Log4j.info("The paste option is present");
		} else {
			AssertJUnit.fail("The paste option is greyed out/ not present");
		} 
		wait(1000);
		List<WebElement> series_list = login.driver.findElements(By.xpath("//div[@class='webix_ss_center_scroll']/*[1]//*[@class='series-name-field--series-name']"));
		for(WebElement actualStr: series_list) {
			if(Expected_Series.equalsIgnoreCase(actualStr.getText())) {
				login.Log4j.info("The paste option does work");
			} else {
				Assert.fail("The paste option doesn't work");
			}
		}
	}


}
