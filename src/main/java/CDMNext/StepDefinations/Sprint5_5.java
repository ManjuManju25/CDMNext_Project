package CDMNext.StepDefinations;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.AssertJUnit;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class Sprint5_5 extends CommonFunctionality {
	public String Expected_Series;

	@Then("^The \"([^\"]*)\" checkbox should be checked by default$")
	public void the_checkbox_should_be_checked_by_default(String arg1) throws Throwable {
		wait(500);
		boolean alternative_data_checkbox = login.driver.findElement(By.xpath(
				"//*[@title='" + arg1 + "']/ancestor::*[@class='filter-item--title']/*/*//input[@type='checkbox']"))
				.isSelected();
		if (alternative_data_checkbox == true) {
			login.Log4j.info(arg1 + " checkbox is checked by default");
		} else {
			Assert.fail(arg1 + " checkbox is not checked by default");
		}
	}

	@Then("^The \"([^\"]*)\" should be displayed on the top always$")
	public void the_should_be_displayed_on_the_top_always(String arg1) throws Throwable {
		wait(500);
		List<WebElement> alternative_dropdown_items = login.driver.findElements(
				By.xpath("//*[@class='filter-list']/*//*[@class='filter-item--title']//*[@class='text-dots']"));
		for (int i = 0; i < alternative_dropdown_items.size();) {
			if (alternative_dropdown_items.get(i).getText().equalsIgnoreCase(arg1)) {
				login.Log4j.info(arg1 + " is displayed on the top always");
			} else {
				Assert.fail(arg1 + " is not displayed on the top of the list of items");
			}
			break;
		}

	}

	@Then("^The button name should be \"([^\"]*)\"$")
	public void the_button_name_should_be(String arg1) throws Throwable {
		wait(500);
		WebElement button_name = getElementByXpath(login.driver,
				"//*[@data-id='alternative']//*[@class='dropdown-search-filter-title--text']", 6);
		if (button_name.getText().equalsIgnoreCase(arg1)) {
			login.Log4j.info("The button name is: " + arg1);
		} else {
			Assert.fail("Verification failed");
		}
	}

	@Then("^The \"([^\"]*)\" tag should be displayed for all series\\.$")
	public void the_tag_should_be_displayed_for_all_series(String arg1) throws Throwable {
		wait(3000);

		List<WebElement> li_All = login.driver
				.findElements(By.xpath("//*[@class='series-representation']/*//*[@class='series-item--name']"));
		login.Log4j.info("List size is :" + li_All.size());
		String strLabel = null;
		if (li_All.size() > 0) {
			for (int i = 0; i < li_All.size(); i++) {
				int j = i + 1;
				// CommonFunctionality.wait(1000);
				// WebElement checkbox = login.driver
				// .findElement(By.xpath("//*[@class='series-representation']/*[" + j +
				// "]//div[@class='series-list-item--checkbox-wrapper']"));
				// checkbox.click();
				wait(600);

				WebElement element = login.driver.findElement(By.xpath(
						"(//*[@class='series-representation--list']//*[@unselectable='on']//div[@class='series-item--status-icons']//*[@title='Alternative series'])["
								+ j + "]"));

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
		WebElement series = getElementByXpath(login.driver,
				"//*[@class='webix_column  webix_first']/*/*//*[@class='series-name-field--series-name']", 6);
		new Actions(login.driver).moveToElement(series).build().perform();
	}

	@Then("^The series should be \"([^\"]*)\"$")
	public void the_series_should_be(String arg1) throws Throwable {
		WebElement text_align = getElementByXpath(login.driver, "//*[@class='series-name-field--series-name']", 6);
		String actual = text_align.getCssValue("text-decoration");
		login.Log4j.info(actual);
		if (actual.contains(arg1)) {
			login.Log4j.info("The series is displayed in " + arg1 + " format");
		} else {
			Assert.fail("The series is not displayed in " + arg1 + " format");
		}

	}

	@Then("^Check toolbar and the toolbar should be greyed out instead of hiding$")
	public void check_toolbar_and_the_toolbar_should_be_greyed_out_instead_of_hiding() throws Throwable {
		WebElement greyedout = login.driver.findElement(By.xpath("//*[@class='panels-container disabled']"));
		if (greyedout.isDisplayed() == true) {
			login.Log4j.info("The toolbar is disabled/greyedout when none of the series are selected");
		} else {
			Assert.fail("The toolbar is not disabled/greyedout when none of the series are selected");
		}
	}

	@And("^Right-click on the series$")
	public void right_click_on_the_series() throws Throwable {
		getElementByXpath(login.driver, "//*[@title='List mode']", 6).click();
		WebElement sname = getElementByXpath(login.driver, "//*[@class='series-name-field--series-name']", 6);
		Expected_Series = sname.getText();
		new Actions(login.driver).contextClick(sname).build().perform();

	}

	@And("^Select \"([^\"]*)\" in series right click under my series$")
	public void select_in_series_right_click_under_my_series(String arg1) throws Throwable {
		wait(500);
		right_click_on_the_series();
		login.Log4j.info("Clicking on " + arg1);
		getElementByXpath(login.driver, "//div[@class='items-wrapper']//span[@title='" + arg1 + "']", 8).click();

	}

	@And("^The Paste option should be present and work$")
	public void the_Paste_option_should_be_present_and_work() throws Throwable {
		wait(1000);
		WebElement growltext = getElementByXpath(login.driver, "//div[@class='growl-message-text']", 8);

		if (growltext.getText().contains("Data pasted from clipboard")) {
			login.Log4j.info("The paste option is present");
		} else {
			AssertJUnit.fail("The paste option is greyed out/ not present");
		}
		wait(1000);
		List<WebElement> series_list = login.driver.findElements(
				By.xpath("//div[@class='webix_ss_center_scroll']/*[1]//*[@class='series-name-field--series-name']"));
		for (WebElement actualStr : series_list) {
			if (Expected_Series.equalsIgnoreCase(actualStr.getText())) {
				login.Log4j.info("The paste option does work");
			} else {
				Assert.fail("The paste option doesn't work");
			}
		}
	}

	@And("^Add chart > Check the placement for vertical visual under Table$")
	public void add_chart_Check_the_placement_for_vertical_visual_under_Table() throws Throwable {
		getElementByProperty(login.driver, "Add_chart", 10).click();
	}

	@Then("^The Vertical visual should be displayed in first place under Table$")
	public void the_Vertical_visual_should_be_displayed_in_first_place_under_Table() throws Throwable {
		WebElement ele = getElementByXpath(login.driver,
				"//*[contains(text(),'Table')]/parent::*[@class='ugdPYMd0VxUFfjYkCLib']/following-sibling::*/*[1]/*[1]",
				10);
		String verticalEle = ele.getText();
		if (verticalEle.equalsIgnoreCase("Vertical")) {
			login.Log4j.info("The Vertical visual is displayed in first place under Table");
		} else {
			Assert.fail("The Vertical visual is not displayed in first place under Table");
		}
	}

	@And("^Open copyright under preference$")
	public void open_copyright_under_preference() throws Throwable {
		getElementByXpath(login.driver, "//*[@title='View and edit profile information']", 10).click();
	}

	@Then("^\"([^\"]*)\" should be displayed as prefix$")
	public void should_be_displayed_as_prefix(String arg1) throws Throwable {
		WebElement ele = getElementByXpath(login.driver, "//*[@class='visual-item-wrapper--text text-dots link']", 10);
		String actualSeriesSourceEle = ele.getText();
		if (actualSeriesSourceEle.contains(arg1)) {
			login.Log4j.info(arg1 + " is displayed as prefix");
		} else {
			Assert.fail(arg1 + " is not displayed as prefix");
		}
	}

	@Then("^The list of series sources should be displayed$")
	public void the_list_of_series_sources_should_be_displayed() throws Throwable {
		//if series hormnozation popup appears ,click on Apply button
		try {
			getElementByXpath(login.driver, "//button[contains(text(),'Apply')]", 10).click();
		}catch(Exception e) {
			
		}
		// Getting source value from ssp window for validation
		List<WebElement> list_of_items = login.driver
				.findElements(By.xpath("//*[@class='series-edit--title series-edit--title__editable']"));
		ArrayList<String> sourcesList = new ArrayList<>();
		for (int i = 0; i < list_of_items.size(); i++) {
			list_of_items.get(i).click();
			wait(300);
			WebElement ele = getElementByXpath(login.driver,
					"//*[contains(text(),'Source:')]/ancestor::td/following-sibling::*//td//*[contains(@class,'main-series-information--field-value')]",
					10);
			String sourceVar_ssp = ele.getText();
			sourcesList.add(sourceVar_ssp);
			// closing ssp window
			getElementByXpath(login.driver, "//*[@title='Close']", 10).click();

		}
		// reading sources from created visual
		WebElement ele = getElementByXpath(login.driver, "//*[@class='visual-item-wrapper--text text-dots link']", 10);
		String actualSeriesSourceEle = ele.getText();
		String[] sourcelist = actualSeriesSourceEle.split(", ");

		for (String expectedStr : sourcesList) {
			if (expectedStr.equals("National Bureau of Statistics")) {
				if (sourcelist[2].equalsIgnoreCase("NBS")) {
					login.Log4j.info("Series source is displayed");
				} else {
					Assert.fail();
				}
			} else if (expectedStr.equalsIgnoreCase(sourcelist[1])) {
				login.Log4j.info("Series source is displayed");
			} else {
				Assert.fail();
			}
		}

	}
	@And("^Change the UI language$")
	public void change_the_UI_language() throws Throwable {
		open_copyright_under_preference();
		//select Bahasa lanugage
		getElementByXpath(login.driver, "//*[@data-language='id']", 10).click();
	}

	@Then("^The \"([^\"]*)\" label should be translated$")
	public void the_label_should_be_translated(String arg1) throws Throwable {
	   wait(2000);
	// reading sources from created visual after changing UI languge as Bahasa
			WebElement ele = getElementByXpath(login.driver, "//*[@class='visual-item-wrapper--text text-dots link']", 10);
			String actualSeriesSourceEle = ele.getText();
			String[] sourcelist = actualSeriesSourceEle.split(", ");
			String[] sourceStr = sourcelist[0].split(": ");
			if(!sourceStr[0].equals(arg1)) {
				login.Log4j.info("The " + arg1+ " label translated as "+ sourceStr[0]);
				
				//change default lanugage as english
				wait(2000);
				getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 10).click();
				getElementByXpath(login.driver, "//*[@class='account-avatar--container']", 10).click();
				getElementByXpath(login.driver, "//*[@data-language='en']", 10).click();
			} else {
				//change default lanugage as english
				wait(2000);
				getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 10).click();
				getElementByXpath(login.driver, "//*[@class='account-avatar--container']", 10).click();
				getElementByXpath(login.driver, "//*[@data-language='en']", 10).click();
				Assert.fail();
			}
	}
	
	@And("^Create a view in right panel$")
	public void create_a_view_in_right_panel() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@title='Create new View tab']")).click();
	}

	@And("^Create (\\d+) visuals from search panel$")
	public void create_visuals_from_search_panel(int arg1) throws Throwable {
		WebElement rightClickElement;
		
		login.Log4j.info("Clicking on Series tab ");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Series_Tab"))));
	     wait(4000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_Tab"))).click();
		
		try {
			wait(4000);
			List<WebElement> li_All =  login.driver.findElements(By.xpath("//div[@class='series-representation--list']/*//*[@class='series-item--name']"));
			
			if (li_All.size() > 0) {
				for (int i = 0; i < li_All.size(); i++) {
					wait(1000);
					rightClickElement = li_All.get(i);
					// contextClick() method to do right click on the element
					action.pause(500).contextClick(rightClickElement).build().perform();	
					// click on Add chart and create table visual
					WebElement Addchart = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Dropdown_AddChart")));
					action.moveToElement(Addchart).click().build().perform();
				   getElementByXpath(login.driver, "//*[@class='visuals-panel']//*[contains(text(),'Vertical')]", 4).click();
					
					 if(i == 2){
						break;
					 }
				}
			} else {
				Assert.fail("Sorry,No results were found ");
			}
			
		} catch (NoSuchElementException e) {
			Assert.fail("WebElement is null " + e.getMessage());
		}
	}

	@Then("^The visuals should be created in same focused view$")
	public void the_visuals_should_be_created_in_same_focused_view() throws Throwable {
	    WebElement viewTabEle =  getElementByXpath(login.driver, "//*[@class='insight-page-view-tab--link insight-page-view-tab--link__active']",10);
	    String ViewTableText = viewTabEle.getAttribute("title");
	    List<WebElement> list_of_views = login.driver.findElements(By.xpath("//*[@class='insight-page-menu-views-container']//*[@class='insight-page-view-tab--title']"));
	    if(ViewTableText.equalsIgnoreCase("view 1") && list_of_views.size() == 1) {
	    	login.Log4j.info("The visuals created in same focused view");
	    } else {
	    	Assert.fail("The visuals not created in same focused view");
	    }
	}

}
