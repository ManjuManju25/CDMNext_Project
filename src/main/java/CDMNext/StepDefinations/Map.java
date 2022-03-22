package CDMNext.StepDefinations;

import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class Map extends CommonFunctionality {
	DatabasesTab db = new DatabasesTab();
	KeyboardShortcuts kb = new KeyboardShortcuts();
	Histogram hs = new Histogram();
	static WebElement SeriesCount;
ArrayList<String> list_of_series = new ArrayList<>();
EmptyView EV = new EmptyView();
String Visual_Title_txt;

	@SuppressWarnings("deprecation")
	@And("^Right click on the series$")
	public void right_click_on_the_series() throws Throwable {
		WebElement rightClickEle = getElementByXpath(login.driver,
				"//ul[@class='search-series-list scrollable']/*[1]//div[@class='series-item--name']", 6);
		sname = getElementByXpath(login.driver,
				"//ul[@class='search-series-list scrollable']/*[1]//div[@class='series-item--name']", 6).getText();
		action.pause(200).contextClick(rightClickEle).build().perform();
	}

	@And("^Select \"([^\"]*)\" > \"([^\"]*)\"$")
	public void select(String arg1, String arg2) throws Throwable {
		getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 6).click();
		getElementByXpath(login.driver, "//ul[@class='dropdown-menu']//*[contains(text(),'" + arg2 + "')]", 6).click();
	}

	@Then("^Map visual should be created$")
	public void map_visual_should_be_created() throws Throwable {
		wait(2000);
		String Visual_title_text = getElementByXpath(login.driver, "//*[@data-name='title']", 6).getText();
		if (sname.contains(Visual_title_text)) {
			login.Log4j.info("Map visual is created");
		} else {
			fail("Map visual is not created");
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Drag and drop the series to view$")
	public void drag_and_drop_the_series_to_view() throws Throwable {
		EmptyView.click_on_View_tab();
		sname = getElementByXpath(login.driver,
				"//ul[@class='search-series-list scrollable']/*[1]//div[@class='series-item--name']", 6).getText();
		wait(2000);
		WebElement SourceEle = login.driver.findElement(
				By.xpath("//ul[@class='search-series-list scrollable']/*[1]//*[@class='series-item--name']"));
		wait(1000);
		WebElement targetEle = getElementByXpath(login.driver,
				"//*[@class='view-components-over--wrapper']//*[@class='icon--map-world']", 6);
		action.clickAndHold(SourceEle).pause(500).dragAndDrop(SourceEle, targetEle).build().perform();

	}

	@SuppressWarnings("deprecation")
	@And("^Drag and drop Map visual to view$")
	public void drag_and_drop_Map_visual_to_view() throws Throwable {
		wait(2000);
		WebElement SourceEle = login.driver.findElement(By.xpath("//*[@data-action='world']"));
		wait(1000);
		WebElement targetEle = getElementByXpath(login.driver,
				"//*[@class='view-components-over--wrapper']//*[@class='icon--map-world']", 6);
		action.clickAndHold(SourceEle).pause(500).dragAndDrop(SourceEle, targetEle).build().perform();
	}

	@And("^Click on Map visual icon$")
	public void click_on_Map_visual_icon() throws Throwable {
		wait(1000);
		getElementByXpath(login.driver, "//*[@data-type='world']//*[@class='icon--map-world']", 6).click();
	}

	@Then("^Empty Map visual should be created$")
	public void empty_Map_visual_should_be_created() throws Throwable {
		wait(5000);
		if (getElementByXpath(login.driver, "//*[@class='empty-visual-overlay--title']", 6).getText()
				.equalsIgnoreCase("Map")) {
			login.Log4j.info("Map visual is created");
		} else {
			fail("Map visual is not created");
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Select series and Press \"([^\"]*)\" on KB$")
	public void select_series_and_Press_on_KB(String arg1) throws Throwable {
		wait(3000);
		WebElement ele = getElementByXpath(login.driver,
				"//div[@class='check-all-series']//span[@class='input-control--indicator']", 4);
		action.moveToElement(ele).pause(1000).click().build().perform();
		kb.press_on_KB(arg1);
	}

	@And("^Apply function for a series in my series tab$")
	public void apply_function_for_a_series_in_my_series_tab() throws Throwable {
		// Adding series to my series tab
		Thread.sleep(3000);
		login.Log4j.info("Clicking on  Series tab ");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		wait(500);
		WebElement addIcon = login.driver.findElement(
				By.xpath("//div[@class='search-series-list']/*[1]//div[@class='add-to-data-selection--icon']"));
		wait(200);
		addIcon.click();

		// Select checkbox
		wait(500);
		WebElement checkBox = getElementByXpath(login.driver, "//*[@class='series-name-wrapper ']/*[1]", 4);
		checkBox.click();
		// Click on Type a function
		getElementByXpath(login.driver, "//*[@class='current-function-input--body']", 4).click();
		// Apply a function
		getElementByXpath(login.driver, "//*[@data-id='ROUND']", 4).click();
		// Click on green tick mark for applying the function
		getElementByXpath(login.driver, "//*[@title='Ctrl+click to create a new series']", 4).click();
	}

	@SuppressWarnings("deprecation")
	@And("^Select series and Create Map$")
	public void select_series_and_Create_Map() throws Throwable {
		// Right click on series
		wait(3000);
		WebElement rightClickEle = getElementByXpath(login.driver, "//*[@class='series-name-field--text']", 4);
		action.pause(500).contextClick(rightClickEle).build().perform();
		// create map visual
		select("View as Map", "World");

	}

	@And("^Verify applied function in edit series panel$")
	public void verify_applied_function_in_edit_series_panel() throws Throwable {
		// Click on Edit series
		hs.click_on_Edit_series_option();
	}

	@Then("^The functions should be applied to the visual series$")
	public void the_functions_should_be_applied_to_the_visual_series() throws Throwable {
		wait(1000);
		String VisualSeries = getElementByXpath(login.driver, "//*[@class='visual-series-name']", 4).getText();
		if (VisualSeries.contains("ROUND")) {
			login.Log4j.info("The function applied to the visual series");
		} else {
			fail("The function not applied to the visual series");
		}

	}

	@And("^Select \"([^\"]*)\" from Missing value method dropdown$")
	public void select_from_Missing_value_method_dropdown(String arg1) throws Throwable {
		wait(4000);
		Select select = new Select(login.driver.findElement(By.name("missing_values")));
		select.selectByVisibleText(arg1);
	}

	@Then("^By default (\\d+) value will be seen$")
	public void by_default_value_will_be_seen(int arg1) throws Throwable {
		wait(1500);
		String str = login.driver.findElement(By.name("specific_value")).getAttribute("value");
		int specific_value = Integer.parseInt(str);
		if (specific_value == arg1) {
			login.Log4j.info("Specific value is 1 By default");
		} else {
			fail("Specific value is not 1 by default");
		}

	}

	@Then("^Map visual should be created with \"([^\"]*)\" frequencies$")
	public void map_visual_should_be_created_with_frequencies(String arg1) throws Throwable {
		getElementByProperty(login.driver, "MyInsight_Tab", 10).click();
		wait(500);
		List<WebElement> functions_list = login.driver.findElements(By.xpath("//*[@class='series-functions-title']"));
		for (int i = 0; i < functions_list.size(); i++) {
			String frequency = functions_list.get(i).getText();
			if (frequency.contains(arg1)) {
				login.Log4j.info("Daily frequecy is dispalying");
			} else {
				fail("Daily frequency is not displaying");
			}
		}

	}

	@And("^Create a Map visual without selecting series$")
	public void create_a_Map_visual_without_selecting_series() throws Throwable {
		EmptyView.click_on_View_tab();
		click_on_Map_visual_icon();
	}

	@Then("^The \"([^\"]*)\" button should be disabled$")
	public void the_button_should_be_disabled(String arg1) throws Throwable {
		wait(500);
		WebElement edit_map_button_disabled = getElementByXpath(login.driver,
				"//*[@class='button button__sm button__primary']", 4);
		boolean button = edit_map_button_disabled.isEnabled();
		if (button == false) {
			login.Log4j.info(arg1 + " button is disabled");
		} else {
			fail(arg1 + " button is enabled");
		}
	}

	@Then("^The \"([^\"]*)\" button should be enabled$")
	public void the_button_should_be_enabled(String arg1) throws Throwable {
		wait(500);
		WebElement edit_series_button_enabled = getElementByXpath(login.driver, "//*[contains(text(),'Edit Series')]",
				4);
		boolean button = edit_series_button_enabled.isEnabled();
		if (button == true) {
			login.Log4j.info(arg1 + " button is enabled");
		} else {
			fail(arg1 + " button is disabled");
		}
	}

	@Then("^Edit series panel should be opened$")
	public void edit_series_panel_should_be_opened() throws Throwable {
		wait(500);
		WebElement edit_series_panel = getElementByXpath(login.driver,
				"//*[@class='sidebar-panel sidebar-panel__opened']", 6);
		boolean EditSeriesPanel = edit_series_panel.isDisplayed();
		if (EditSeriesPanel == true) {
			login.Log4j.info("Edit series panel is opened");
		} else {
			fail("Edit series panel is not opened");
		}
	}

	@Then("^The \"([^\"]*)\" and \"([^\"]*)\" button should be displayed for empty visual$")
	public void the_and_button_should_be_displayed_for_empty_visual(String arg1, String arg2) throws Throwable {
		wait(1500);
		String str1 = login.driver.findElement(By.xpath("//*[@class ='data-selection-series-overlay--title']"))
				.getText();
		String str2 = login.driver
				.findElement(By.xpath("//*[@class ='data-selection-series-overlay--btn button button__primary']"))
				.getText();

		if (arg1.equals(str1) && arg2.equals(str2)) {
			login.Log4j.info(arg1 + "\n" + arg2 + " is displayed");
		} else {
			Assert.fail("Verification failed");
		}

	}

	@And("^Create a map visual with series$")
	public void create_a_map_visual_with_series() throws Throwable {

		login.Log4j.info("Clicking on  Series tab ");
		WebElement SeriesTab = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(login.LOCATORS.getProperty("Series"))));
		SeriesTab.click();
		EmptyView.click_on_View_tab();
		click_on_Map_visual_icon();
		wait(4000);
		List<WebElement> checkBox = login.driver
				.findElements(By.xpath("//div[@class='series-list-item--checkbox-wrapper']"));
		List<WebElement> sName = login.driver.findElements(By.xpath("//*[@class='series-item--name']"));
		for (int i = 0; i < checkBox.size(); i++) {
			action.moveToElement(checkBox.get(i)).click().build().perform();
			list_of_series.add(sName.get(i).getText());
			if(i == 2) {
				break;
			}
		}
		SeriesCount = login.driver.findElement(By.xpath("//*[@class='search-input--selected-count']"));
		// click on '+'icon
		wait(2000);
		getElementByXpath(login.driver, "(//div[@class='add-to-data-selection--icon'])[1]", 8).click();
		//close if series harmonization popup opened
		try {
			getElementByXpath(login.driver, "//*[contains(@class,' movable-modal__active')]//*[@title='Close']", 20).click();
		} catch(Exception e) {
			
		}
		
	}
	@And("^Click on visual region$")
	public void click_on_visual_region() throws Throwable {
		wait(1000);
		getElementByXpath(login.driver, "(//*[contains(text(),'CN')])[1]", 20).click();
	}
	@Then("^Associated series should be available in edit series popup$")
	public void associated_series_should_be_available_in_edit_series_popup() throws Throwable {
		ArrayList<String> Actual_list = new ArrayList<>();
	    wait(2000);
	    List<WebElement> series_list_editSeries_popup = login.driver.findElements(By.xpath("//*[@class='series-name--title']"));
	    for(int i = 0; i < series_list_editSeries_popup.size(); i++) {
	    	Actual_list.add(series_list_editSeries_popup.get(i).getText());
	    }
	    if(list_of_series.equals(Actual_list)) {
	    	login.Log4j.info("PASS");
	    } else {
	    	fail("Verification failed");
	    }
	}

@SuppressWarnings("deprecation")
@And("^Click on visual legend$")
public void click_on_visual_legend() throws Throwable {
	WebElement legend = getElementByXpath(login.driver, "//*[@class='highcharts-legend-item highcharts-undefined-series highcharts-color-undefined']/*[1]",10);
	action.pause(300).doubleClick(legend).build().perform();
}
@And("^Create a map visual with series id's \"([^\"]*)\"$")
public void create_a_map_visual_with_series_id_s(String arg1) throws Throwable {
	PieVisual.SelectSeries(arg1);
	wait(1500);
	if (arg1.equalsIgnoreCase("16240301")) {
		sname = getElementByXpath(login.driver, "//*[@class='series-item--name']", 10)
				.getText();
	}
	SeriesCount = login.driver.findElement(By.xpath("//*[@class='series-series-count--number']"));
	login.Log4j.info(SeriesCount.getText());
	EmptyView.click_on_View_tab();
	wait(2000);
	getElementByXpath(login.driver, "//*[@data-action='world']", 4).click();
	wait(2000);
	Visual_Title_txt = login.driver.findElement(By.xpath("//*[@data-name='title']")).getText();
}

}
