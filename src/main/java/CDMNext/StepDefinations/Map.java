package CDMNext.StepDefinations;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import CDMNext.util.CommonFunctionality;
import Javaxlxs.File_delete;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Map extends CommonFunctionality {
	DatabasesTab db = new DatabasesTab();
	KeyboardShortcuts kb = new KeyboardShortcuts();
	Histogram hs = new Histogram();
	SeriesTab St = new SeriesTab();
	static WebElement SeriesCount;
	ArrayList<String> list_of_series = new ArrayList<>();
	EmptyView EV = new EmptyView();
	String Visual_Title_txt, ExpectedSname,expectedMap_type;
	List<WebElement> Series_list_EditSeriesPanel;
	CDMNextSprintCases cdmnextsprint = new CDMNextSprintCases();
	Commentary commentary = new Commentary();
	WebElement Dropdown_ele;

	@SuppressWarnings("deprecation")
	@And("^Right click on the series$")
	public void right_click_on_the_series() throws Throwable {
		WebElement rightClickEle = getElementByProperty(login.driver, "seriesName_tableLevel", 6);
		sname = rightClickEle.getText();
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
		String Visual_title_text = getElementByProperty(login.driver, "Map_visual_title", 6).getText();
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
		wait(2000);
		WebElement SourceEle = getElementByProperty(login.driver, "seriesName_tableLevel", 6);
		sname = SourceEle.getText();
		wait(1000);
		WebElement targetEle = getElementByProperty(login.driver, "map_icon", 6);
		action.clickAndHold(SourceEle).pause(500).dragAndDrop(SourceEle, targetEle).build().perform();

	}

	@SuppressWarnings("deprecation")
	@And("^Drag and drop Map visual to view$")
	public void drag_and_drop_Map_visual_to_view() throws Throwable {
		wait(2000);
		WebElement SourceEle = getElementByProperty(login.driver, "map_world", 6);
		wait(1000);
		WebElement targetEle = getElementByProperty(login.driver, "map_icon", 6);
		action.clickAndHold(SourceEle).pause(500).dragAndDrop(SourceEle, targetEle).build().perform();
	}

	@And("^Click on Map visual icon$")
	public void click_on_Map_visual_icon() throws Throwable {
		wait(1000);
		getElementByProperty(login.driver, "map_visual_icon", 6).click();
	}

	@Then("^Empty Map visual should be created$")
	public void empty_Map_visual_should_be_created() throws Throwable {
		wait(5000);
		if (getElementByProperty(login.driver, "Empty_visual", 6).getText().equalsIgnoreCase("Map")) {
			login.Log4j.info("Map visual is created");
		} else {
			fail("Map visual is not created");
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Select series and Press \"([^\"]*)\" on KB$")
	public void select_series_and_Press_on_KB(String arg1) throws Throwable {
		wait(3000);
		WebElement ele = getElementByProperty(login.driver, "Input_control_indicator", 4);
		action.moveToElement(ele).pause(1000).click().build().perform();
		kb.press_on_KB(arg1);
	}

	@And("^Apply function for a series in my series tab$")
	public void apply_function_for_a_series_in_my_series_tab() throws Throwable {
		// Adding series to my series tab
		Thread.sleep(3000);
		login.Log4j.info("Clicking on  Series tab ");
		getElementByProperty(login.driver, "Series", 6).click();
		wait(500);
		WebElement addIcon = getElementByProperty(login.driver, "AddIcon_seriesLevel", 6);
		wait(200);
		addIcon.click();

		// Select checkbox
		wait(500);
		WebElement checkBox = getElementByProperty(login.driver, "select_checkbox", 4);
		checkBox.click();
		// Click on Type a function
		getElementByProperty(login.driver, "Type_A_Function", 4).click();
		// Apply a function
		getElementByProperty(login.driver, "Round", 4).click();
		// Click on green tick mark for applying the function
		getElementByProperty(login.driver, "Apply_function", 4).click();
	}

	@SuppressWarnings("deprecation")
	@And("^Select series and Create Map$")
	public void select_series_and_Create_Map() throws Throwable {
		// Right click on series
		wait(3000);
		WebElement rightClickEle = getElementByProperty(login.driver, "list_of_series", 4);
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
		String VisualSeries = getElementByProperty(login.driver, "Visual_SName", 4).getText();
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
		WebElement edit_map_button_disabled = getElementByProperty(login.driver, "EditMap_disabled", 4);
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
		WebElement edit_series_button_enabled = getElementByProperty(login.driver, "EditSeries", 4);
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
		WebElement edit_series_panel = getElementByProperty(login.driver, "EditSeriesPanel", 6);
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
		String str1 = getElementByProperty(login.driver, "NoSeriesAdded", 6).getText();
		String str2 = getElementByProperty(login.driver, "SearchSeries", 6).getText();

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
		List<WebElement> checkBox = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Checkbox")));
		List<WebElement> sName = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Series_item_name")));
		for (int i = 0; i < checkBox.size(); i++) {
			action.moveToElement(checkBox.get(i)).click().build().perform();
			list_of_series.add(sName.get(i).getText());
			if (i == 2) {
				break;
			}
		}
		SeriesCount = getElementByProperty(login.driver, "SearchInputSelectedCount", 6);
		// click on '+'icon
		wait(2000);
		getElementByProperty(login.driver, "AddIcon", 8).click();
		// close if series harmonization popup opened
		try {
			getElementByProperty(login.driver, "Close_movable_window", 20).click();
		} catch (Exception e) {

		}

	}

	@And("^Click on visual region$")
	public void click_on_visual_region() throws Throwable {
		wait(1000);
		getElementByProperty(login.driver, "Region_china", 20).click();
	}

	@Then("^Associated series should be available in edit series popup$")
	public void associated_series_should_be_available_in_edit_series_popup() throws Throwable {
		ArrayList<String> Actual_list = new ArrayList<>();
		wait(2000);
		List<WebElement> series_list_editSeries_popup = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("Series_in_editSeriesPopup")));
		for (int i = 0; i < series_list_editSeries_popup.size(); i++) {
			Actual_list.add(series_list_editSeries_popup.get(i).getText());
		}
		if (list_of_series.equals(Actual_list)) {
			login.Log4j.info("PASS");
		} else {
			fail("Verification failed");
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Click on visual legend$")
	public void click_on_visual_legend() throws Throwable {
		WebElement legend = getElementByProperty(login.driver, "Visual_legend", 10);
		action.pause(300).doubleClick(legend).build().perform();
	}

	@And("^Create a map visual with series id's \"([^\"]*)\"$")
	public void create_a_map_visual_with_series_id_s(String arg1) throws Throwable {
		PieVisual.SelectSeries(arg1);
		wait(500);
		if (arg1.equalsIgnoreCase("16240301")) {
			sname = getElementByProperty(login.driver, "Title_of_the_series", 10).getText();
		}
		SeriesCount = getElementByProperty(login.driver, "SelectedSeriesCount", 6);
		login.Log4j.info(SeriesCount.getText());
		CommonFunctionality.getElementByProperty(login.driver, "AddChart", 4).click();
		wait(2000);
		getElementByProperty(login.driver, "map_world", 4).click();
		wait(2000);
		Visual_Title_txt = getElementByProperty(login.driver, "Map_visual_title", 8).getText();
	}

	@And("^Click on x icon before Name attribute$")
	public void click_on_x_icon_before_Name_attribute() throws Throwable {
		wait(1000);
		// List of series on edit series panel before click on Delete series icon
		Series_list_EditSeriesPanel = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("Series_in_editSeriesPopup")));
		getElementByProperty(login.driver, "x_icon_beforeNameAttribute", 6).click();
	}

	@Then("^All series should be removed from the visual and edit series panel$")
	public void all_series_should_be_removed_from_the_visual_and_edit_series_panel() throws Throwable {
		wait(1000);
		// List of series on edit series panel after click on Delete series icon
		List<WebElement> Expected_list1 = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("Series_in_editSeriesPopup")));
		wait(500);
		Boolean empty_visual = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("empty_visual_afterClickonDeleteSeries")))
				.isDisplayed();

		if (Expected_list1.size() == 0) {

			if (!(Series_list_EditSeriesPanel.size() == Expected_list1.size()) && empty_visual == true) {
				login.Log4j.info("All the series has been removed from the edit series panel and visual");
			} else {
				fail("All the series has not been removed from the edit series panel and visual");
			}
		} else {
			fail("Verification failed");
		}
	}

	@And("^Click on frequency$")
	public void click_on_frequency() throws Throwable {
		getElementByProperty(login.driver, "frequency_editSeries", 6).click();
	}

	@Then("^The selected \"([^\"]*)\" frequency should be applied to available series$")
	public void the_selected_frequency_should_be_applied_to_available_series(String arg1) throws Throwable {
		wait(500);
		List<WebElement> list = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("NameList_editSeries")));
		if (list.size() == 1) {
			wait(500);
			String Series = getElementByProperty(login.driver, "NameList_editSeries", 8).getText();
			if (Series.contains(arg1)) {
				login.Log4j.info("Seleted function is displayed in seres name");

			} else {
				Assert.fail("Selected function is not displayed in series name");
			}
		} else {
			fail("List size is more than 1");
		}
	}

	@And("^Create a empty Map visual$")
	public void create_a_empty_Map_visual() throws Throwable {
		EmptyView.click_on_View_tab();
		click_on_Map_visual_icon();
	}

	@And("^Redirect to MySeries tab > Select a series in edit series panel$")
	public void redirect_to_MySeries_tab_Select_a_series_in_edit_series_panel() throws Throwable {

		List<WebElement> series_list = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("checkbox_list")));
		for (int i = 0; i < series_list.size();) {
			int j = i + 1;
			wait(300);
			getElementByXpath(login.driver, "//*[@class='series-name-wrapper '][" + j + "]/*[1]", 6).click();
			ExpectedSname = getElementByXpath(login.driver,
					"//*[@class='series-name-wrapper '][" + j + "]//*[@class='series-name-field--series-name']", 6)
							.getText();
			break;
		}

	}

	@Then("^The selected series should be displayed in Map tab$")
	public void the_selected_series_should_be_displayed_in_Map_tab() throws Throwable {

		// select Map tab in edit series panel
		getElementByProperty(login.driver, "MapTab_editSeries", 6).click();
		String ActualSName = getElementByProperty(login.driver, "Visual_SName", 6).getText();
		if (ActualSName.equalsIgnoreCase(ExpectedSname)) {
			login.Log4j.info("The selected series displayed in Map tab");
		} else {
			fail("The selected series not displayed in Map tab");
		}

	}

	@And("^Select more than (\\d+) series and try to create Map visual$")
	public void select_more_than_series_and_try_to_create_Map_visual(int arg1) throws Throwable {
		cdmnextsprint.open_preference_dropdown();
		cdmnextsprint.clicking_on_option_under_user_preference_to_be("Show search results without pagination", "Check");
		WebElement SeriesTab = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(login.LOCATORS.getProperty("Series"))));
		SeriesTab.click();
		wait(2000);
		for (int i = 1; i <= 302; i++) {
			wait(50);
			WebElement checkBoxEle = getElementByXpath(login.driver,
					"(//*[@class='series-representation--list']//*[contains(@style,'position')]//*[@unselectable='on'])["
							+ i + "]//div[@class='series-list-item--checkbox-wrapper']",
					8);
			new Actions(login.driver).moveToElement(checkBoxEle).click().build().perform();
			// Until the element is not visible keep scrolling
			jse.executeScript("arguments[0].scrollIntoView(true);", checkBoxEle);
		}
		create_a_empty_Map_visual();
		try {
			// if series hormonization popup is opened
			getElementByProperty(login.driver, "Apply_button", 6).click();
		} catch (Exception e) {
			//
		}

	}

	@Then("^Map should allow max (\\d+) series$")
	public void map_should_allow_max_series(int arg1) throws Throwable {
		wait(400);
		Boolean confirmation_popup = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("Table_delete_popup"))).isDisplayed();
		if (confirmation_popup == true) {
			getElementByProperty(login.driver, "OK_button", 6).click();
			getElementByProperty(login.driver, "unexpected_popup_close", 6).click();
			login.Log4j.info("Confirmation popup displayed for allowing 300series to create a map visual");
		} else {
			fail("confirmation popup not displayed for selecting more than 300 series");
		}

		if (getElementByProperty(login.driver, "Map_visual_title", 6).getText().equalsIgnoreCase("Map")) {
			login.Log4j.info("Map visual created with max no.of series");
		} else {
			fail("Failed to create a map visual with max no.of series");
		}
	}

	@Then("^\"([^\"]*)\" growl message should be displayed$")
	public void growl_message_should_be_displayed(String arg1) throws Throwable {
		WebElement growl_text = getElementByProperty(login.driver, "cant_apply_function_msg", 8);
		String expected = growl_text.getText();
		login.Log4j.info(expected);
		if (expected.contains(arg1)) {
			login.Log4j.info(arg1 + " growl message is displayed");
			getElementByProperty(login.driver, "OK_button", 6).click();
			getElementByProperty(login.driver, "unexpected_popup_close", 6).click();

		} else {
			fail(arg1 + " growl message is not displayed");
		}

	}

	@Then("^The \"([^\"]*)\" option should be disabled if already opened$")
	public void the_option_should_be_disabled_if_already_opened(String arg1) throws Throwable {
		wait(500);
		Boolean editSeries = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).isEnabled();
		if (editSeries == false) {
			login.Log4j.info("Edit series option is disabled");
		} else {
			fail("Edit series option is not disabled");
		}
	}

	@Then("^Auto name should be available as \"([^\"]*)\"$")
	public void auto_name_should_be_available_as(String arg1) throws Throwable {
		String actualTemplateName = getElementByProperty(login.driver, "Templatename", 10).getAttribute("title");
		Assert.assertEquals(actualTemplateName, arg1);
		login.Log4j.info("Auto template is created as " + actualTemplateName);
		// Delete created auto template
		WebElement ele = getElementByXpath(login.driver,
				"//*[@class='style-templates-item--wrapper']//*[@title='" + arg1 + "']", 8);
		action.moveToElement(ele).pause(1000).perform();
		getElementByXpath(login.driver, "//*[@title='" + arg1 + "']//*[@title='Delete template']", 10).click();
		St.click_on("Ok");
		getElementByClassName(login.driver, "movable-modal--close", 10).click();
		getElementByProperty(login.driver, "save_button", 10).click();
	}

	@And("^Create a new map visual$")
	public void create_a_new_map_visual() throws Throwable {
		ResetMethod();
		create_a_map_visual_with_series_id_s("16240301");
	}

	@Then("^The Map should be created with the format of previous template selection$")
	public void the_Map_should_be_created_with_the_format_of_previous_template_selection() throws Throwable {
		// if Legend checkbox off
		wait(2000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("map_legend"))).size() == 0) {
			login.Log4j.info("Legend items has been removed from the visual");
		} else {
			Assert.fail("Legend items has not been removed from the visual");
		}
	}

	@Then("^The map should be created with default format template$")
	public void the_map_should_be_created_with_default_format_template() throws Throwable {
		wait(2000);
		if (!(login.driver.findElements(By.xpath(login.LOCATORS.getProperty("map_legend"))).size() == 0)) {
			login.Log4j.info("Legend items shown on the visual");
		} else {
			Assert.fail("Legend items not shown on the visual");
		}
	}

	@And("^Check Map for \"([^\"]*)\"$")
	public void check_Map_for(String arg1) throws Throwable {
		hs.CheckHistogram(arg1);
	}

	@Then("^The map border \"([^\"]*)\" should be updated to \"([^\"]*)\"$")
	public void the_map_border_should_be_updated_to(String arg1, String arg2) throws Throwable {
		wait(2000);
		getElementByProperty(login.driver, "save_btn", 6).click();
		if (arg1.equals("Width")) {
			String ActualWidth;
			wait(2000);
			ActualWidth = getElementByProperty(login.driver, "Border", 8).getCssValue("stroke-width");
			login.Log4j.info(ActualWidth);
			commentary.FontSizeValidation(ActualWidth, arg2);
		}
	}

	@Then("^Radius should be updated to (\\d+) on map$")
	public void radius_should_be_updated_to_on_map(int arg1) throws Throwable {
		wait(2000);
		getElementByProperty(login.driver, "save_btn", 6).click();
		wait(2000);
		String ActualRadius = getElementByProperty(login.driver, "Border", 8).getCssValue("rx");
		login.Log4j.info(ActualRadius);
		if (ActualRadius.contains(Integer.toString(arg1))) {
			login.Log4j.info("PASS");
		} else {
			Assert.fail("Verification is failed");
		}

	}

	@And("^Select image more than (\\d+) MB$")
	public void select_image_more_than_MB(int arg1) throws Throwable {
		getElementByProperty(login.driver, "BackgroundImage", 6).click();
		wait(2000);
		uploadTheFileusingAutoIT(login.driver, System.getProperty("user.dir") + "\\AutoIT\\UploadFile.exe",
				System.getProperty("user.dir") + "\\AutoIT\\Technology.jpg");
		wait(5000);
	}

	@Then("^\"([^\"]*)\" growl message is displayed and auto closed$")
	public void growl_message_is_displayed_and_auto_closed(String arg1) throws Throwable {
		WebElement growl_text = getElementByProperty(login.driver, "growl_popup", 8);
		String expected = growl_text.getText();
		login.Log4j.info(expected);
		if (expected.contains(arg1)) {
			login.Log4j.info(arg1 + " growl message is displayed");
			// getElementByXpath(login.driver, "//*[text()='Ok']", 6).click();
			// getElementByXpath(login.driver, "//*[@title='Close']", 6).click();

		} else {
			fail(arg1 + " growl message is not displayed");
		}
		wait(8000);

		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Growl_error_msg"))).size() == 0) {
			login.Log4j.info("Growl popup is auto closed");
		} else {
			fail("Growl popup is not auto closed");
		}
	}

	@Then("^\"([^\"]*)\" and \"([^\"]*)\" should be shown$")
	public void and_should_be_shown(String arg1, String arg2) throws Throwable {
		wait(4000);
		List<WebElement> size_dropdown_options = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("Size_dropdown")));
		for (WebElement str : size_dropdown_options) {
			if (str.getText().contains(arg1)) {
				login.Log4j.info(arg1 + " option is shown");
			} else if (str.getText().contains(arg2)) {
				login.Log4j.info(arg2 + " option is shown");
			} else {
				fail(arg1 + " AND " + arg2 + " options are not shown");
			}

		}
	}

	@Then("^\"([^\"]*)\" and \"([^\"]*)\" options should be available$")
	public void and_options_should_be_available(String arg1, String arg2) throws Throwable {
		wait(4000);
		List<WebElement> show_options = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Show_options")));
		for (WebElement str : show_options) {
			if (str.getText().contains(arg1)) {
				login.Log4j.info(arg1 + " option is available");
			} else if (str.getText().contains(arg2)) {
				login.Log4j.info(arg2 + " option is available");
			} else {
				fail(arg1 + " AND " + arg2 + " options are not shown");
			}

		}
		wait(1000);
		// Zoom check box option
		Boolean zoom_isChecked = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ZoomCheckbox")))
				.isSelected();
		// Play check box option
		Boolean play_isChecked = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("PlayCheckbox")))
				.isSelected();
		if (zoom_isChecked == true && play_isChecked == true) {
			login.Log4j.info("Zoom and Play options checked by default");
		} else {
			fail("Zoom and Play options not checked by default ");
		}
	}

	@And("^Check zoom control checkbox$")
	public void check_zoom_control_checkbox() throws Throwable {
		wait(1000);
		// select zoom control check box
		Boolean isChecked = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ZoomCheckbox"))).isSelected();
		if (isChecked == false) {
			new Actions(login.driver)
					.moveToElement(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ZoomCheckbox"))))
					.click().perform();
		}
	}

	@Then("^Zooming options will be displayed for the map visual$")
	public void zooming_options_will_be_displayed_for_the_map_visual() throws Throwable {
		wait(2000);

		Boolean zoomIn = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ZoomIn_icon"))).isDisplayed();
		Boolean zoomOut = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ZoomOut_Icon"))).isDisplayed();
		if (zoomIn == true && zoomOut == true) {
			login.Log4j.info("Zooming options are displayed for the map visual");
		} else {
			fail("Zooming options are not displayed for the map visual");
		}
	}

	@And("^UnCheck zoom control checkbox$")
	public void uncheck_zoom_control_checkbox() throws Throwable {
		wait(1000);
		// Unselect zoom control check box
		Boolean isChecked = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ZoomCheckbox"))).isSelected();
		if (isChecked == true) {
			new Actions(login.driver).moveToElement(getElementByProperty(login.driver, "ZoomCheckbox", 6)).click()
					.perform();
		} else {
			fail("Zoom option doesnt unchecked");
		}
	}

	@Then("^Zooming options will not be displayed for the map visual$")
	public void zooming_options_will_not_be_displayed_for_the_map_visual() throws Throwable {
		wait(2000);

		List<WebElement> zoomIn = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("ZoomIn_icon")));
		List<WebElement> zoomOut = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("ZoomOut_Icon")));
		if (zoomIn.size() == 0 && zoomOut.size() == 0) {
			login.Log4j.info("Zooming options are removed from the map visual");
		} else {
			fail("Zooming options are not removed for the map visual");
		}
	}

	@And("^Check play control  checkbox$")
	public void check_play_control_checkbox() throws Throwable {
		wait(1000);
		// select play control check box
		Boolean isChecked = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("PlayCheckbox"))).isSelected();
		if (isChecked == false) {
			new Actions(login.driver)
					.moveToElement(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("PlayCheckbox"))))
					.click().perform();
		}
	}

	@Then("^Date selection checkbox will be visible below map visual$")
	public void date_selection_checkbox_will_be_visible_below_map_visual() throws Throwable {
		wait(2000);
		WebElement date_selection = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("date_selection")));
		jse.executeScript("arguments[0].scrollIntoView(true)", date_selection);

		if (date_selection.isDisplayed() == true) {
			login.Log4j.info("Date selection is displayed below map visual");
		} else {
			fail("Date selection is not displayed below map visual");
		}
	}

	@And("^UnCheck play control checkbox$")
	public void uncheck_play_control_checkbox() throws Throwable {
		wait(1000);
		// Unselect play control check box
		Boolean isChecked = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("PlayCheckbox"))).isSelected();
		if (isChecked == true) {
			new Actions(login.driver)
					.moveToElement(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("PlayCheckbox"))))
					.click().perform();
		}
	}

	@Then("^Date selection checkbox will be not be visible below map visual$")
	public void date_selection_checkbox_will_be_not_be_visible_below_map_visual() throws Throwable {
		wait(2000);

		List<WebElement> date_selection = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("date_selection")));
		if (date_selection.size() == 0) {
			login.Log4j.info("Map Date selection is not dispalyed below map visual");
		} else {
			fail("Verification failed");
		}
	}

	@And("^Open \"([^\"]*)\" dropdown$")
	public void open_dropdown(String arg1) throws Throwable {
		wait(2000);
		getElementByProperty(login.driver, "NumberFormatDropdown", 8).click();
	}

	@Then("^(\\d+) decimals should be selected by default$")
	public void decimals_should_be_selected_by_default(int arg1) throws Throwable {
		String Decimal_var = getElementByProperty(login.driver, "DecimalPlaces", 8).getAttribute("value");
		int decimalValue = Integer.parseInt(Decimal_var);
		if (arg1 == decimalValue) {
			login.Log4j.info("Decimal number is " + arg1 + " is selected by default");
		} else {
			fail("Decimal num is " + arg1 + " not selected by default");
		}
	}

	@And("^Select decimal separator as \"([^\"]*)\"$")
	public void select_decimal_separator_as(String arg1) throws Throwable {
		getElementByXpath(login.driver, "//*[@class='number-format-picker']/*[2]/*[2]//*[@value='" + arg1 + "']", 8)
				.click();
	}

	@Then("^The selected decimal separator \"([^\"]*)\" should be displayed on Map value$")
	public void the_selected_decimal_separator_should_be_displayed_on_Map_value(String arg1) throws Throwable {
		wait(3000);
		WebElement ele = getElementByProperty(login.driver, "RegionName_onMap", 8);
		action.moveToElement(ele).pause(1000).build().perform();
		wait(500);
		String tooltipText = getElementByProperty(login.driver, "Map_tooltipText", 8).getText();
		login.Log4j.info(tooltipText);
		if (tooltipText.contains(arg1)) {
			login.Log4j.info("The selected decimal separator is displayed on map value");
		} else {
			fail("The selected decimal separator is not displayed");
		}

	}

	@Then("^Legend option should be checked by default$")
	public void legend_option_should_be_checked_by_default() throws Throwable {
		wait(2000);
		Boolean legend_checkBox = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("legend_checkbox")))
				.isSelected();
		if (legend_checkBox == true) {
			login.Log4j.info("Legend option is checked by default");
		} else {
			fail("Legend option is not checked by default");
		}
	}

	@Then("^\"([^\"]*)\" option should be displayed$")
	public void option_should_be_displayed(String arg1) throws Throwable {
		String ExpectedVar = getElementByProperty(login.driver, "BottomText", 8).getText();
		if (ExpectedVar.equalsIgnoreCase(arg1)) {
			login.Log4j.info(arg1 + " option is displayed");
		} else {
			fail(arg1 + " option is not displayed");
		}
	}

	@And("^Click on Advanced settings$")
	public void click_on_Advanced_settings() throws Throwable {
		getElementByProperty(login.driver, "AdvancedSettings", 8).click();
	}

	@Then("^Show legend option should be checked by default$")
	public void show_legend_option_should_be_checked_by_default() throws Throwable {
		wait(2000);
		Boolean Showlegend_checkBox = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("showLegend_checkbox"))).isSelected();
		if (Showlegend_checkBox == true) {
			login.Log4j.info("Show Legend option is checked by default");
		} else {
			fail("Show Legend option is not checked by default");
		}
	}

	@And("^Select Text radio button from copyright popup$")
	public void select_Text_radio_button_from_copyright_popup() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='copyright-config']/*[5]/*[1]/*[2]/*[1]/*[2]//*[@class='input-control--indicator']", 40)
				.click();
	}

	@Then("^The default text should be \"([^\"]*)\"$")
	public void the_default_text_should_be(String arg1) throws Throwable {
		String defaultText = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='copyright-config--text']/*", 10).getAttribute("value");
		if (defaultText.equals(arg1)) {
			login.Log4j.info("The default text is " + arg1);
		} else {
			fail("Verification failed");
		}
	}

	@And("^Choose Data label color is blue$")
	public void choose_Data_label_color_is_blue() throws Throwable {
		WebElement element = CommonFunctionality.getElementByProperty(login.driver, "BlueColor", 20);
		ActualColor = element.getCssValue("background-color");
		login.Log4j.info("Actual color is " + ActualColor);
		element.click();
		CommonFunctionality.wait(200);
	}

	@Then("^Should be able to display with selected \"([^\"]*)\"$")
	public void should_be_able_to_display_with_selected(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Color")) {
			List<WebElement> color = login.driver.findElements(By.cssSelector(
					"#highcharts-zcvptxg-2443 > svg > g.highcharts-data-labels.highcharts-series-0.highcharts-map-series.highcharts-color-0.highcharts-tracker > g:nth-child(1) > text"));
			if (color.size() > 0) {
				for (int i = 1; i <= color.size(); i++) {
					String color_text = color.get(i).getCssValue("fill");
					CommonFunctionality.wait(2000);
					String actual = Color.fromString(color_text).asHex();
					assertEquals(actual, ActualColor);
				}

				login.Log4j.info("The Selected " + arg1
						+ " has been updated in map visual timepoints and it's verified successfully");

			} else {
				Assert.fail("List size is zero");
			}
		} else if (arg1.equalsIgnoreCase("Outline color")) {
			List<WebElement> color = login.driver.findElements(By.cssSelector(
					".highcharts-data-labels.highcharts-series-0.highcharts-map-series.highcharts-color-0.highcharts-tracker > g:nth-child(1) > text > tspan"));
			if (color.size() > 0) {
				for (int i = 0; i < color.size(); i++) {
					String color_text = color.get(i).getCssValue("fill");
					CommonFunctionality.wait(2000);
					String actual = Color.fromString(color_text).asHex();
					login.Log4j.info(actual);
					String expected = Color.fromString(Commentary.ActualColor).asHex();
					login.Log4j.info(expected);
					assertEquals(actual, expected);
				}

				login.Log4j.info("The Selected " + arg1
						+ " has been updated in map visual timepoints and it's verified successfully");

			} else {
				Assert.fail("List size is zero");
			}
		}
	}

	@Then("^Default size should be \"([^\"]*)\"$")
	public void default_size_should_be(String arg1) throws Throwable {
		String defaultSize = CommonFunctionality.getElementByProperty(login.driver, "Labels_default_size", 8)
				.getAttribute("value");
		if (defaultSize.equals(arg1)) {
			login.Log4j.info("Default size is " + arg1);
		} else {
			Assert.fail("Verification failed");
		}
	}

	@Then("^The Selected font size should update with selected input$")
	public void the_Selected_font_size_should_update_with_selected_input() throws Throwable {
		CommonFunctionality.wait(500);
		List<WebElement> font_size = login.driver.findElements(By.cssSelector(
				".highcharts-data-labels.highcharts-series-0.highcharts-map-series.highcharts-color-0.highcharts-tracker > g:nth-child(1) > text"));
		if (font_size.size() > 0) {
			for (int i = 0; i < font_size.size(); i++) {
				String fontsize = font_size.get(i).getCssValue("font-size");
				String font_size_text[] = fontsize.split("px");
				Integer expected = Integer.valueOf(font_size_text[0]);
				Integer actual = Integer.valueOf(ChartVisual.data_labels_font_size);
				assertEquals(actual, expected);
				login.Log4j.info(
						"The Selected font size has been updated in map visual timepoints and it's verified successfully");
			}
		} else {
			Assert.fail("List size is zero");
		}

	}

	@Then("^The Selected font Styles should update with selected input$")
	public void the_Selected_font_Styles_should_update_with_selected_input() throws Throwable {
		CommonFunctionality.wait(1000);
		List<WebElement> font_style = login.driver.findElements(By.cssSelector(
				".highcharts-data-labels.highcharts-series-0.highcharts-map-series.highcharts-color-0.highcharts-tracker > g:nth-child(1) > text"));
		if (font_style.size() > 0) {
			for (int i = 0; i < font_style.size(); i++) {
				WebElement fontstyle = font_style.get(i);
				String font_bold = fontstyle.getCssValue("font-weight");
				String font_italic = fontstyle.getCssValue("font-style");
				String font_underline = fontstyle.getCssValue("text-decoration");
				assertTrue(font_bold.equals("bold") || font_bold.equals("700"));
				assertTrue(font_italic.equals("italic"));
				assertTrue(font_underline.contains("underline"));
				login.Log4j
						.info("The Selected font styles has been updated in map visual and it's verified successfully");

			}
		} else {
			Assert.fail("List size is zero");

		}
	}

	@Then("^By Default Highlight filter will grayed out$")
	public void by_Default_Highlight_filter_will_grayed_out() throws Throwable {
		WebElement HighlightFilter = CommonFunctionality.getElementByProperty(login.driver, "highlight_filter", 8);
		if (HighlightFilter.getAttribute("class").contains("disabled")) {
			login.Log4j.info("By Default Highlight filter is grayed out");
		} else {
			Assert.fail("By Default Highlight filter is not grayed out");
		}
	}

	@Then("^Highlight Filter will be displayed with value (\\d+)$")
	public void highlight_Filter_will_be_displayed_with_value(int arg1) throws Throwable {
		String defaultValue = CommonFunctionality.getElementByProperty(login.driver, "filterValue", 8)
				.getAttribute("value");
		int ExpectedValue = Integer.parseInt(defaultValue);
		if (ExpectedValue == arg1) {
			login.Log4j.info("Highlight Filter default value is 0");
		} else {
			Assert.fail("Verification failed");
		}
	}

	@Then("^Highlight Filter will be displayed with color Red$")
	public void highlight_Filter_will_be_displayed_with_color_Red() throws Throwable {
		String ExpectedColor = "rgb(239, 83, 80)";
		String Red = Color.fromString(ExpectedColor).asHex();
		String highlight_filter_color = CommonFunctionality
				.getElementByProperty(login.driver, "highlightFilterColor", 8).getCssValue("background-color");
		String actualColor = Color.fromString(highlight_filter_color).asHex();
		Assert.assertEquals(actualColor, Red);
		login.Log4j.info("Default color is Red");

	}
	@And("^Select \"([^\"]*)\" button$")
	public void select_button(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']", 8).click();
	}

	@And("^Click on \"([^\"]*)\" cogwheel$")
	public void click_on_cogwheel(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='color-axis--row']//*[@title='" + arg1 + "']", 8).click();
	}

	/*@And("^Expand common section$")
	public void expand_common_section() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver,"//*[@class='icon-collapse']",8).click();
	   
	}*/
	@When("^Expand \"([^\"]*)\" section$")
	public void expand_section(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver,"//*[text()='" + arg1 + "']/following::*[2]",8).click();
	}
	@And("^Click on Series name on map visual$")
	public void click_on_Series_name_on_map_visual() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "sname_on_mapVisual", 8).click();
	}


@And("^Create a empty map visual$")
public void create_a_empty_map_visual() throws Throwable {
	EmptyView.click_on_View_tab();
	click_on_Map_visual_icon();
}

@Then("^The Add related series option should be hidden if have no series associated with the visual$")
public void the_Add_related_series_option_should_be_hidden_if_have_no_series_associated_with_the_visual() throws Throwable {
	CommonFunctionality.wait(500);
	WebElement add_related_series_button = login.driver.findElement(By.xpath("//*[@class='visual-top-panel--left-controls']/*[3]"));
	   if(!add_related_series_button.isEnabled()) {
		   login.Log4j.info("PASS");
	   } else {
		   Assert.fail("Verification failed");
	   }
}
@Then("^The related series should be added to the map visual$")
public void the_related_series_should_be_added_to_the_map_visual() throws Throwable {
	WebElement ele = CommonFunctionality.getElementByXpath(login.driver,
			"//*[@class='visual-indicators--category visual-indicators--category__macro']/*[2]//*[@class='visual-indicator--title']",
			10);
	String indicator_title_text = ele.getText();
	new Actions(login.driver).pause(500).moveToElement(ele).perform();
	CommonFunctionality
			.getElementByXpath(login.driver,
					"//*[@class='visual-indicators--category visual-indicators--category__macro']/*[2]/*[2]", 10)
			.click();
	CommonFunctionality.getElementByXpath(login.driver,
			"//*[contains(@class,'movable-modal__active')]//*[@class='movable-modal--close']", 10).click();
	CommonFunctionality.wait(500);
	St.click_on("Edit Map");
	ArrayList<String> listOfLegendItems = new ArrayList<>();
	List<WebElement> list = login.driver
			.findElements(By.xpath("//*[@class='series-name--title']"));
	for (int i = 0; i < list.size(); i++) {
		listOfLegendItems.add(list.get(i).getText());
	}
	if (listOfLegendItems.contains(indicator_title_text)
			|| listOfLegendItems.contains("Consumer Price Index: YoY: Monthly: Albania")) {
		login.Log4j.info("The related series is displayed in the visual");
	} else {
		fail("The relatedd series not displayed in the visual");
	}
}
@When("^Click on world drop down button$")
public void click_on_world_drop_down_button() throws Throwable {
	CommonFunctionality.wait(500);
	CommonFunctionality.getElementByProperty(login.driver,"world_dropdown", 10).click();
}

@When("^Select \"([^\"]*)\" map$")
public void select_map(String arg1) throws Throwable {
	expectedMap_type = arg1;
	CommonFunctionality.wait(500);
	CommonFunctionality.getElementByXpath(login.driver,"//*[@title='" + arg1 + "']", 10).click();
}

@Then("^Respective map should be created$")
public void respective_map_should_be_created() throws Throwable {
   WebElement ele = CommonFunctionality.getElementByXpath(login.driver,
			"//*[@class='custom-select-title--name text-dots']", 10);
   String mapType = ele.getText();
   if(expectedMap_type.equalsIgnoreCase(mapType)) {
	   login.Log4j.info(expectedMap_type + " map is created");
   } else {
	   Assert.fail(expectedMap_type + " map is not cretaed");
   }
}
@Then("^The Map visual should be created in vew tab on current insight$")
public void the_Map_visual_should_be_created_in_vew_tab_on_current_insight() throws Throwable {
	List<WebElement> views = login.driver
			.findElements(By.xpath("//*[contains(@class,'insight-page-view-tab') and contains(text(),'View')]"));
	if (views.size() > 1) {
		CommonFunctionality.wait(1000);
		String titileTxt = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='main-page--insight-active-page']//*[@class='visual-title visual-title--wrapper'][1]//*[@data-name='title']",
				15).getText();
		if (Visual_Title_txt.equalsIgnoreCase(titileTxt)) {
			login.Log4j.info("The Map visual is created in view tab");
		} else {
			Assert.fail("The Map visual is not created in view tab");
		}
	}
}
@Then("^The new insight should be opened and added map visual should be available in My visual$")
public void the_new_insight_should_be_opened_and_added_map_visual_should_be_available_in_My_visual() throws Throwable {
	PieVisual.createdVisualInNewTab(Visual_Title_txt);
}
@Then("^The map visual should be pasted in the insight$")
public void the_map_visual_should_be_pasted_in_the_insight() throws Throwable {
	CommonFunctionality.wait(1000);
			String ActualText = CommonFunctionality.getElementByProperty(login.driver, "VisualTitle", 15)
				.getText();
		if (ActualText.equals(Visual_Title_txt) ) {
			login.Log4j.info("Mapvisual is created in the same insiaght");
		} else {
			Assert.fail("Map visual is not created in the same insight");
		}
	
}
@Then("^The map visual should be pasted to new insight$")
public void the_map_visual_should_be_pasted_to_new_insight() throws Throwable {
	the_map_visual_should_be_pasted_in_the_insight();
}
@And("^Click on More options$")
public void click_on_More_options() throws Throwable {
	CommonFunctionality.getElementByXpath(login.driver, "//*[@class='growl-message-nav--button']/*", 15)
	.click();
}

@Then("^Download window is displayed$")
public void download_window_is_displayed() throws Throwable {
	CommonFunctionality.wait(500);
   WebElement ele = CommonFunctionality.getElementByProperty(login.driver, "downloadPopup", 15);
   if(ele.getText().contains("Copy")) {
	   login.Log4j.info("Download window is displayed");
   } else {
	   Assert.fail("Download window is not displayed");
   }
			
}
@Then("^Map visual and related series should be downloaded in excel$")
public void map_visual_and_related_series_should_be_downloaded_in_excel() throws Throwable {
	CommonFunctionality.getTheNewestFile(Commentary.format);
	File_delete.delete();
}

@Then("^Map visual should be downloaded in PDF format$")
public void map_visual_should_be_downloaded_in_PDF_format() throws Throwable {
	CommonFunctionality.getTheNewestFile(Commentary.format);
	File_delete.delete();
}
@Then("^Map visual should be pasted$")
public void map_visual_should_be_pasted() throws Throwable {
	String ExpectedTitle = CommonFunctionality.getElementByProperty(login.driver, "VisualTitle", 10)
			.getText();
	if (Visual_Title_txt.equals(ExpectedTitle)) {
		login.Log4j.info("Map visual is pasted");
	} else {
		Assert.fail("Map visual is not pasted");
	}
}
@Then("^Map chart should be cut$")
public void map_chart_should_be_cut() throws Throwable {
	commentary.commentary_should_be_cut();
}
@Then("^Map chart should be deleted$")
public void map_chart_should_be_deleted() throws Throwable {
	commentary.commentary_should_be_deleted();
}
@And("^Click on My Series tab$")
public void click_on_My_Series_tab() throws Throwable {
	CommonFunctionality.getElementByProperty(login.driver, "Myseries", 10).click();
	
}
@Then("^The applied function should be applied to the series$")
public void the_applied_function_should_be_applied_to_the_series() throws Throwable {
	CommonFunctionality.wait(500);
	String Actualfunction = CommonFunctionality
			.getElementByXpath(login.driver, "//*[@class='series-functions-title']", 5)
			.getText();

	if (Actualfunction.contains("RMB")) {
		login.Log4j.info(Actualfunction + " is displayed in seres name");
		
	} else {
		Assert.fail(Actualfunction + " is not displayed in series name");
	}
}
@And("^Select Map$")
public void select_Map() throws Throwable {
	CommonFunctionality.getElementByXpath(login.driver, "//*[@data-action='download_visual']/*[1]", 30).click();
}

@Then("^Download popup should be displayed with Map tab selection$")
public void download_popup_should_be_displayed_with_Map_tab_selection() throws Throwable {
	CommonFunctionality.wait(2000);
	if (login.driver
			.findElement(By.xpath(
					"//*[@class='modal-window insight-download modal-window__active']//*[@data-tab='visual']"))
			.getText().contains("Map")) {
		login.Log4j.info("Verification is pass");
	} else {
		Assert.fail("Download popup not displayed with map tab selection");
	}
}
@And("^Click on cogwheel icon on series level$")
public void click_on_cogwheel_icon_on_series_level() throws Throwable {
	WebElement editseries = CommonFunctionality.getElementByProperty(login.driver, "EditSeriesIcon", 30);
	action.moveToElement(editseries).build().perform();
	editseries.click();
	
}
@And("^Click on color steps dropdown$")
public void click_on_color_steps_dropdown() throws Throwable {
	CommonFunctionality.wait(2000);
  Dropdown_ele = login.driver.findElement(By.name("steps"));

}

@Then("^Selected color steps will be created as per the selection$")
public void selected_color_steps_will_be_created_as_per_the_selection() throws Throwable {
  Select select = new Select(Dropdown_ele);
 List<WebElement> dropdown_list = select.getOptions();
 for(WebElement dropdownValue: dropdown_list) {
	 dropdownValue.click();
	String str =  dropdownValue.getAttribute("value");
	 List<WebElement> steps = login.driver.findElements(By.xpath("//*[@class='solid-colors--container']//*[@class='predefined-color']//button"));
	 if(Integer.parseInt(str) == steps.size()) {
		 login.Log4j.info("Selected color steps: "+ Integer.parseInt(str) + " is displayed");
	 } else {
		 Assert.fail("Selected color steps not displayed");
	 }
 }
  
}


	// ........................Implemented By Teju ....................//

	@And("^click_On_Dropdown \"([^\"]*)\"$")
	public void click_On_Dropdown(String arg1) throws Throwable {
		CommonFunctionality.DeleteSeries();
		login.Log4j.info("Clicking on All Regions filter");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'" + arg1 + "')]"))).click();

	}

	@And("^Select Download button1$")
	public void select_Download_button1() throws Throwable {
		Thread.sleep(5000);

		login.driver.findElement(By.xpath("//span[@class='download-button--text drop-down-button--label']")).click();
		// span[@class='download-button--text drop-down-button--label']
		Thread.sleep(4000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Apply"))).click();
	}

	@And("^select_subnational_as_region \"([^\"]*)\"$")
	public void select_subnational_as_region(String arg1) throws Throwable {
		login.Log4j.info("Selecting subnational " + arg1);
		Thread.sleep(10000);
		login.driver.findElement(By.xpath("//*[@class='tabs__tabs-box']//*[contains(text(),'" + arg1 + "')]")).click();
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='tabs__tabs-box']//*[contains(text(),'"
		// + arg1 + "')]"))).click();
	}

	@And("^select_Subregion \"([^\"]*)\"$")
	public void select_Subregion(List<String> str) throws InterruptedException {
		// wait.until(ExpectedConditions.elementToBeClickable(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unselect"))))).click();
		for (String str1 : str) {
			WebElement Subregion = login.driver.findElement(
					By.xpath("//div[@class='subnational--section subnational--section__first']//span[contains(text(),'"
							+ str1 + "')]"));
			Subregion.click();
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Apply_filter"))).click();
		Thread.sleep(4000);
	}

	@And("^view_As_map \"([^\"]*)\"$")
	public void view_As_map(String str) throws InterruptedException {

		Actions act = new Actions(login.driver);
		Thread.sleep(20000);
		act.contextClick().build().perform();
		act.moveToElement(
				login.driver.findElement(By.xpath("//div[@class='items-wrapper']//*[contains(text(),'" + str + "')]")))
				.click().perform();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Apply"))).click();
		Thread.sleep(2000);
	}

	@And("^select_Subregion_federal \"([^\"]*)\"$")
	public void select_Subregion_federal(List<String> str) {
		for (String str1 : str) {
			WebElement Subregion = login.driver.findElement(
					By.xpath("//div[@class='subnational--section subnational--section__second']//span[contains(text(),'"
							+ str1 + "')]"));
			Subregion.click();
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Apply_filter"))).click();
	}

	@And("^Downloadmap$")
	public void Downloadmap() throws InterruptedException {
		login.driver.switchTo().activeElement();
		login.driver.findElement(By.xpath(
				"//button[@class='sphere-modal-control button insight-download__modal-button button button__download-btn']"))
				.click();
		Thread.sleep(10000);
	}

	@And("^click_on_EditMap$")
	public void click_on_EditMap() throws InterruptedException {

		Thread.sleep(4000);
		login.driver.findElement(By.xpath("//button[contains(text(),'Edit Map')]")).click();
	}

	@And("^add_mySeriesName \"([^\"]*)\"$")
	public void add_mySeriesName(String str) throws InterruptedException {
		login.driver.findElement(By.xpath("//div[@class='style-templates-menu--add']")).click();
		login.driver
				.findElement(By.xpath("//input[@class='add-template-context--input form--control form--control__sm']"))
				.sendKeys(str, Keys.ENTER);
		Thread.sleep(5000);

	}

	@And("^selectColor \"([^\"]*)\" \"([^\"]*)\"$")
	public void selectColor(String str1, String str) throws InterruptedException {
		login.driver
				.findElement(
						By.xpath("//div[@class='style-container--palette']//div[@class='context-menu-control--icon']"))
				.click();
		WebElement color = login.driver.findElement(
				By.xpath("//div[@class='color-palette-context']//div/div[@style='background: linear-gradient(to right, "
						+ str1 + ", " + str + ")']"));
		color.click();
		Thread.sleep(5000);
	}

	@And("^checkForTitleBorderBackground \"([^\"]*)\"$")
	public void checkForTitleBorderBackground(String str) {

		login.driver
				.findElement(By.xpath(
						"//div[contains(text(),'" + str + "')]/following::div[@class='toggle-context-control'][1]"))
				.click();
	}

	@And("^titleDropDown \"([^\"]*)\",\"([^\"]*)\"$")
	public void titleDropDown(List<String> str, String value) throws InterruptedException {
		for (String str1 : str) {
			WebElement checkbox = login.driver.findElement(By.xpath(
					"//span[contains(text(),'" + str1 + "')]//parent::label//span[@class='input-control--indicator']"));
			if (checkbox.isSelected() && str1 == "Title") {

				login.driver.findElement(By.xpath("//input[@class='form--control form--control__xs']")).clear();
				login.driver.findElement(By.xpath("//input[@class='form--control form--control__xs']")).sendKeys(value);
			} else {
				checkbox.click();
				login.driver.findElement(By.xpath("//input[@class='form--control form--control__xs']")).clear();
				login.driver.findElement(By.xpath("//input[@class='form--control form--control__xs']")).sendKeys(value);
				Thread.sleep(2000);
			}
			/*
			 * if(checkbox.isSelected() && str1=="Sub title") { login.driver.findElement(By.
			 * xpath("//textarea[@class='form--control form--control__xs input-switchable-control--textarea']"
			 * )).clear(); login.driver.findElement(By.
			 * xpath("//textarea[@class='form--control form--control__xs input-switchable-control--textarea']"
			 * )).sendKeys(value); } else { checkbox.click(); login.driver.findElement(By.
			 * xpath("//textarea[@class='form--control form--control__xs input-switchable-control--textarea']"
			 * )).clear(); login.driver.findElement(By.
			 * xpath("//textarea[@class='form--control form--control__xs input-switchable-control--textarea']"
			 * )).sendKeys(value); }
			 */
		}
	}

	@And("^borderDropDown \"([^\"]*)\"$")
	public void borderDropDown(List<String> str) throws InterruptedException {
		try {

			for (String str1 : str) {
				WebElement checkbox = login.driver.findElement(By.xpath("//*[contains(text(),'" + str1
						+ "')]//parent::label//input/following::span[@class='input-control--indicator'][1]"));
				if (checkbox.isSelected()) {
					// login.driver.findElement(By.xpath("//div[@class='color-picker-control']//div[@class='sp-preview-inner']")).click();

				} else {
					checkbox.click();

				}
			}

		} catch (ElementNotInteractableException e) {

			for (String str1 : str) {
				if (str1.equalsIgnoreCase("Map")) {
					WebElement checkbox = login.driver.findElement(By.xpath(
							"//div[@ui='$plot_area_border_control']//div[@class='border-settings']//label//span"));

					checkbox.click();
					Thread.sleep(2000);
				}

				else {
					WebElement checkbox = login.driver.findElement(By.xpath(
							"//div[@ui='$visual_area_border_control']//div[@class='border-settings']//label//span"));
					if (checkbox.isSelected()) {
					} else {
						checkbox.click();

					}
				}

			}
		}
	}

	@And("^colorSelectionOfMap \"([^\"]*)\"$")
	public void colorSelectionOfMap(String Str) throws InterruptedException {
		Thread.sleep(2000);
		try {
			login.driver.findElement(By.xpath(
					"//div[@class='color-picker-control']/input[@name='plot_area_border_color']/following::div[@class='sp-preview']"))
					.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(
					"//div[@class='sp-container sp-light sp-buttons-disabled sp-palette-buttons-disabled sp-initial-disabled color-picker-selection']//span[@title='"
							+ Str + "']"))
					.click();
		} catch (WebDriverException e) {
			login.driver.findElement(By.xpath("//div[@class='color-picker-control']//div[@class='sp-preview-inner']"))
					.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(
					"//div[@class='sp-container sp-light sp-buttons-disabled sp-palette-buttons-disabled sp-initial-disabled color-picker-selection']//span[@title='"
							+ Str + "']"))
					.click();
		}

	}

	@And("^colorSelectionOfVisual \"([^\"]*)\"$")
	public void colorSelectionOfVisual(String Str) {

		try {
			login.driver.findElement(By.xpath(
					"//div[@class='color-picker-control']/input[@name='visual_area_border_color']/following::div[@class='sp-preview']"))
					.click();
			login.driver.findElement(By.xpath(
					"//div[@class='sp-container sp-light sp-buttons-disabled sp-palette-buttons-disabled sp-initial-disabled color-picker-selection']//span[@title='"
							+ Str + "']"))
					.click();
		} catch (WebDriverException e) {
			login.driver.findElement(By.xpath("//div[@class='color-picker-control']//div[@class='sp-preview-inner']"))
					.click();
			login.driver.findElement(By.xpath(
					"//div[@class='sp-container sp-light sp-buttons-disabled sp-palette-buttons-disabled sp-initial-disabled color-picker-selection']//span[@title='"
							+ Str + "']"))
					.click();
		}
	}

	@And("^colorSelectionOfHighLight \"([^\"]*)\"$")
	public void colorSelectionOfHighLight(String Str) {

		try {
			login.driver.findElement(By.xpath(
					"//div[@class='color-picker-control']/input[@name='highlight_filter_color']/following::div[@class='sp-preview']"))
					.click();
			login.driver.findElement(By.xpath(
					"//div[@class='sp-container sp-light sp-buttons-disabled sp-palette-buttons-disabled sp-initial-disabled color-picker-selection']//span[@title='"
							+ Str + "']"))
					.click();
		} catch (WebDriverException e) {
			login.driver.findElement(By.xpath("//div[@class='color-picker-control']//div[@class='sp-preview-inner']"))
					.click();
			login.driver.findElement(By.xpath(
					"//div[@class='sp-container sp-light sp-buttons-disabled sp-palette-buttons-disabled sp-initial-disabled color-picker-selection']//span[@title='"
							+ Str + "']"))
					.click();
		}
	}

	@And("^widthSelectionOfMap (\\d+)$")
	public void widthSelectionOfMap(Integer i) {
		if (i >= 0 && i <= 5) {
			login.driver.findElement(By.xpath(
					"//span[@class='ui-spinner ui-corner-all ui-widget ui-widget-content']//input[@name='plot_area_border_width']"))
					.clear();
			login.driver.findElement(By.xpath(
					"//span[@class='ui-spinner ui-corner-all ui-widget ui-widget-content']//input[@name='plot_area_border_width']"))
					.sendKeys(i.toString(), Keys.ENTER);

		}
	}

	@And("^widthSelectionOfVisual (\\d+)$")
	public void widthSelectionOfVisual(Integer i) {
		if (i >= 0 && i <= 5) {
			login.driver.findElement(By.xpath(
					"//span[@class='ui-spinner ui-corner-all ui-widget ui-widget-content']//input[@name='visual_area_border_width']"))
					.clear();
			login.driver.findElement(By.xpath(
					"//span[@class='ui-spinner ui-corner-all ui-widget ui-widget-content']//input[@name='visual_area_border_width']"))
					.sendKeys(i.toString(), Keys.ENTER);
		}
	}

	@And("^radiusOfMap (\\d+)$")
	public void radiusOfMap(Integer i) {

		if (i >= 0 && i <= 15) {
			login.driver.findElement(By.xpath(
					"//span[@class='ui-spinner ui-corner-all ui-widget ui-widget-content']//input[@name='plot_area_border_radius']"))
					.sendKeys(i.toString(), Keys.ENTER);
		}
	}

	@And("^radiusOfVisual (\\d+)$")
	public void radiusOfVisual(Integer i) {
		if (i >= 0 && i <= 15) {
			login.driver.findElement(By.xpath(
					"//span[@class='ui-spinner ui-corner-all ui-widget ui-widget-content']//input[@name='visual_area_border_radius']"))
					.sendKeys(i.toString(), Keys.ENTER);
		}
	}

	@And("^styleOfMap \"([^\"]*)\"$")
	public void styleOfMap(String str) throws InterruptedException {
		Thread.sleep(10000);
		login.driver.findElement(By.xpath(
				" //input[@name='plot_area_border_radius']/parent::span/parent::div//following-sibling::div[@class='select-control']//span[@class='select2-arrow']"))
				.click();

		login.driver.findElement(By.xpath("//div[@id='select2-drop']//ul//li//div[@title='" + str + "']")).click();

	}

	@And("^styleOfVisual \"([^\"]*)\"$")
	public void styleOfVisual(String str) throws InterruptedException {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(
				"//input[@name='visual_area_border_radius']/parent::span/parent::div//following-sibling::div[@class='select-control']//span[@class='select2-arrow']"))
				.click();
		login.driver.findElement(By.xpath("//div[@id='select2-drop']//ul//li//div[@title='" + str + "']")).click();
		Thread.sleep(1000);
	}

	@And("^backGroundDropDown \"([^\"]*)\"$")
	public void backGroundDropDown(List<String> str) throws InterruptedException {

		try {
			Thread.sleep(2000);
			WebElement checkbox = login.driver.findElement(By.xpath("//*[contains(text(),'" + str
					+ "')]//parent::label[1]//input/following::span[@class='input-control--indicator']"));
			for (String str1 : str) {
				if (checkbox.isSelected()) {
					System.out.println("ït is selected");
				} else if (!(checkbox.isSelected())) {
					System.out.println("ït is not selected");
					checkbox.click();

				}
			}
		} catch (Exception e) {
			for (String str1 : str) {
				if (str1.equalsIgnoreCase("Map")) {
					WebElement checkbox = login.driver.findElement(By.xpath(
							"//div[@ui='$plot_area_background_control']//div[@class='background-control plot-background-control']//label//span[@class='input-control--indicator']"));

					checkbox.click();
					Thread.sleep(2000);
				}

				else {
					WebElement checkbox = login.driver.findElement(By.xpath(
							"//div[@ui='$visual_area_background_control']//div[@class='background-control visual-background-control']//label//span[@class='input-control--indicator']"));
					if (checkbox.isSelected()) {
					} else {
						checkbox.click();

					}
				}

			}
		}

	}

	// body[1]/ul[1]/div[3]/li[1]/div[1]/div[2]/div[1]/div[1]/label[1]/span[1]
	// body[1]/div[20]/div[2]/div[1]/div[1]/div[2]/div[1]/div[4]/div[4]/div[1]/div[1]/div[1]/label[1]/span[1]

	@And("^colorSelectionOfMapOfBackground \"([^\"]*)\"$")
	public void colorSelectionOfMapOfBackground(String Str) {
		try {
			login.driver.findElement(By.xpath("//div[@class='color-picker-control']//div[@class='sp-preview-inner']"))
					.click();
			login.driver.findElement(By.xpath(
					"//div[@class='sp-container sp-light sp-buttons-disabled sp-palette-buttons-disabled sp-initial-disabled color-picker-selection']//span[@title='"
							+ Str + "']"))
					.click();

		} catch (Exception e) {
			login.driver.findElement(By.xpath(
					"//div[@class='background-control--options']//div[@class='color-picker-control']//div[@class='sp-preview-inner']"))
					.click();
			login.driver.findElement(By.xpath(
					"//div[@class='sp-container sp-light sp-buttons-disabled sp-palette-buttons-disabled sp-initial-disabled color-picker-selection']//span[@title='"
							+ Str + "']"))
					.click();
		}
	}

	@And("^uploadImageOfVisual$")
	public void uploadImageOfVisual() throws AWTException, InterruptedException {
		Robot robot = new Robot();
		try {
			login.driver.findElement(By.xpath(
					"//div[@class='background-control visual-background-control']//label[@class='form--control form--control__xs background-image--input']"))
					.click();

			robot.setAutoDelay(2000);

			StringSelection selection = new StringSelection("C:\\Users\\tbemineni\\Downloads\\tree.jfif");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (WebDriverException e) {
			login.driver.findElement(By.xpath(
					"//div[@class='background-control background-control__separate-toggler visual-background-control']//label[@class='form--control form--control__xs background-image--input']"))
					.click();

			robot.setAutoDelay(2000);

			StringSelection selection = new StringSelection("C:\\Users\\tbemineni\\Download\\tree.jfif");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}
		// login.driver.findElement(By.xpath("//div[@class='visual-types-panel--header']")).click();
	}

	@And("^uploadImageOfMap$")
	public void uploadImageOfMap() throws AWTException, InterruptedException {
		Robot robot = new Robot();
		try {
			login.driver.findElement(By.xpath(
					"//div[@class='background-control plot-background-control']//label[@class='form--control form--control__xs background-image--input']"))
					.click();

			robot.setAutoDelay(2000);

			StringSelection selection = new StringSelection("C:\\Users\\tbemineni\\Downloads\\tree.jfif");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (WebDriverException e) {

			login.driver.findElement(By.xpath(
					"//div[@class='background-control background-control__separate-toggler plot-background-control']//label[@class='form--control form--control__xs background-image--input']"))
					.click();
			robot.setAutoDelay(2000);

			StringSelection selection = new StringSelection("C:\\Users\\tbemineni\\Downloads\\tree.jfif");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}
		// login.driver.findElement(By.xpath("//div[@class='visual-types-panel--header']")).click();
	}

	@And("^opacity (\\d+)$")
	public void opacity(Integer i) throws InterruptedException {
		Thread.sleep(4000);
		wait.until(ExpectedConditions.elementToBeClickable(
				login.driver.findElement(By.xpath("//input[@name='plot_area_background_opacity']"))));
		login.driver.findElement(By.xpath("//input[@name='plot_area_background_opacity']")).clear();
		login.driver.findElement(By.xpath("//input[@name='plot_area_background_opacity']")).sendKeys(i.toString(),
				Keys.ENTER);
		login.driver.findElement(By.xpath("//div[@class='visual-types-panel--header']")).click();
	}

	@And("^opacityVisual (\\d+)$")
	public void opacityVisual(Integer i) throws InterruptedException {

		Thread.sleep(4000);
		wait.until(ExpectedConditions.elementToBeClickable(
				login.driver.findElement(By.xpath("//input[@name='visual_area_background_opacity']"))));
		login.driver.findElement(By.xpath("//input[@name='visual_area_background_opacity']")).clear();
		login.driver.findElement(By.xpath("//input[@name='visual_area_background_opacity']")).sendKeys(i.toString(),
				Keys.ENTER);
		login.driver.findElement(By.xpath("//div[@class='visual-types-panel--header']")).click();
	}

	@And("^sizeSelection (\\d+),\"([^\"]*)\"$")
	public void sizeSelection(Integer i, String str) throws InterruptedException {
		login.driver.findElement(By.xpath("//div[@class='size-control-context-title'][contains(text(),'100% x 100%')]"))
				.click();
		Thread.sleep(2000);
		if (i >= 30 && i <= 100) {
			login.driver.findElement(By.xpath("//li[1]//div[1]//div[2]/div[1]/div[1]/span[1]/input[1]")).clear();
			login.driver.findElement(By.xpath("//li[1]//div[1]//div[2]/div[1]/div[1]/span[1]/input[1]"))
					.sendKeys(i.toString(), Keys.ENTER);
		}
		login.driver.findElement(By.xpath(
				"//li//div[@class='alignment-control--togglers alignment-control--togglers__space_between']/div[@title='"
						+ str + "']"))
				.click();
		login.driver.findElement(By.xpath("//div[@class='visual-types-panel--header']")).click();
	}

	@And("^show \"([^\"]*)\"$")
	public void show(String str) throws InterruptedException {
		// login.driver.findElement(By.xpath("//div[@class='base-config--column']")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) login.driver;
		WebElement checkbox = login.driver.findElement(
				By.xpath("//*[contains(text(),'Zoom')]/parent::label//span[@class='input-control--indicator']"));
		WebElement checkbox1 = login.driver.findElement(
				By.xpath("//*[contains(text(),'Play')]/parent::label//span[@class='input-control--indicator']"));
		checkbox.click();
		checkbox1.click();
		if (str.equalsIgnoreCase("Zoom")) {
			checkbox.click();

		}
		if (str == "Play") {
			checkbox1.click();
		}

	}

	@And("^dateFormat \"([^\"]*)\",\"([^\"]*)\"$")
	public void dateFormat(String str, String str1) throws InterruptedException {
		login.driver.findElement(By.xpath("//div[@class='map-date-format']")).click();
		login.driver
				.findElement(By.xpath(
						"//*[contains(text(),'" + str + "')]/parent::label//span[@class='input-control--indicator']"))
				.click();
		if (str.equalsIgnoreCase("Custom")) {
			login.driver.findElement(By.xpath("//input[@ui='$custom_date']")).clear();
			login.driver.findElement(By.xpath("//input[@ui='$custom_date']")).click();
			login.driver.findElement(By.xpath("//input[@ui='$custom_date']")).sendKeys(str1, Keys.ENTER);
			Thread.sleep(3000);
			login.driver.findElement(By.xpath("//div[@class='visual-types-panel--header']")).click();
		}
		login.driver.findElement(By.xpath("//div[@class='visual-types-panel--header']")).click();
	}

	@And("^numberFormat (\\d+),\"([^\"]*)\",\"([^\"]*)\"$")
	public void numberFormat(Integer i, String str, String str1) throws InterruptedException {
		login.driver
				.findElement(
						By.xpath("//div[@class='number-format-control']//div[@class='context-menu-control--icon']"))
				.click();
		if (i >= 0 && i <= 8) {
			login.driver.findElement(By.xpath("//input[@name='data_labels_decimal_places']")).clear();
			login.driver.findElement(By.xpath("//input[@name='data_labels_decimal_places']")).sendKeys(i.toString(),
					Keys.ENTER);
		}
		WebElement sep = login.driver.findElement(By.xpath(
				"//*[contains(text(),'Decimal separator')]/following::div[@class='toggler-control-item']/span[contains(text(),'"
						+ str + "')]"));
		if (sep.isSelected()) {

		} else {
			sep.click();
			Thread.sleep(3000);
		}
		WebElement gropsep = login.driver.findElement(By.xpath(
				"//*[contains(text(),'Grouping separator')]/following::div[@class='toggler-control-item']/span[contains(text(),'"
						+ str1 + "')]"));
		if (gropsep.isSelected()) {

		} else {
			gropsep.click();
			Thread.sleep(3000);
		}
		login.driver.findElement(By.xpath("//div[@class='visual-types-panel--header']")).click();
	}

	@And("^markerType \"([^\"]*)\"$")
	public void markerType(String str) {
		WebElement marker = login.driver.findElement(By.xpath("//*[contains(text(),'" + str + "')]"));
		if (marker.isSelected()) {

		} else {
			marker.click();
		}
	}

	@And("^legend \"([^\"]*)\",\"([^\"]*)\"$")
	public void legend(String str, String str1) throws InterruptedException {
		// WebElement legend=
		// login.driver.findElement(By.xpath("//body/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/label[1]/span[1]"));

		login.driver.findElement(By.xpath(
				"//div[@title='Legend. Configure the settings of the map legend.']//div[@class='base-config--row-control']//div[@class='context-menu-control--icon']"))
				.click();
		login.driver
				.findElement(
						By.xpath("//*[contains(text(),'" + str + " align:')]/following::div[@title='" + str1 + "']"))
				.click();
		Thread.sleep(3000);

		login.driver.findElement(By.xpath("//div[@class='visual-types-panel--header']")).click();
	}

	@And("^copyRight \"([^\"]*)\",\"([^\"]*)\"$")
	public void copyRight(String str, String str1) throws InterruptedException {
		login.driver.findElement(By.xpath(
				"//div[@title='Source. Configure displaying of the source in the map.']//div[@class='base-config--row-control']//div[@class='context-menu-control--icon']"))
				.click();
		login.driver
				.findElement(
						By.xpath("//*[contains(text(),'" + str + " align:')]/following::div[@title='" + str1 + "']"))
				.click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//div[@class='visual-types-panel--header']")).click();
	}

	@And("^dataLabels \"([^\"]*)\"$")
	public void dataLabels(List<String> str) throws InterruptedException {
		login.driver.findElement(By.xpath(
				"//div[@title='Data labels. Configure displaying of the data labels in the map.']//div[@class='base-config--row-control']//div[@class='context-menu-control--icon']"))
				.click();
		login.driver.findElement(By.xpath("//*[contains(text(),'Region')]/parent::label/span")).click();
		Thread.sleep(1000);
		for (String str1 : str) {
			WebElement e = login.driver
					.findElement(By.xpath("//*[contains(text(),'" + str1 + "')]/parent::label/span"));
			if (e.isSelected()) {

			} else {
				e.click();
				Thread.sleep(1000);
			}
		}
	}

	@And("^highLightFilter \"([^\"]*)\",\"([^\"]*)\"$")
	public void highLightFilter(String str, String str2) throws InterruptedException {
		login.driver
				.findElement(
						By.xpath("//div[@class='highlight-filter-control']//span[@class='input-control--indicator']"))
				.click();
		colorSelectionOfHighLight(str);
		login.driver.findElement(By.name("highlight_filter_value")).sendKeys(str2);
	}

	@And("^colorDivision \"([^\"]*)\",(\\d+),(\\d+),\"([^\"]*)\"$")
	public void colorDivision(String str, Integer i, Integer j, String str1) throws InterruptedException {
		int count = 0;
		if (str.equalsIgnoreCase("Gradient")) {
			login.driver.findElement(By.xpath(
					"//div[@class='color-axes color-axis-control']//div[@class='color-axis--row'][1]//div/span[contains(text(),'"
							+ str + "')]"))
					.click();
			login.driver.findElement(By.xpath("//select[@name='steps']")).click();
			Select s = new Select(login.driver.findElement(By.name("steps")));
			s.selectByValue(i.toString());
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(
					"//div[@class='color-axes color-axis-control']//div[@class='gradient-axis']//span[@class='input-control--indicator']"))
					.click();
			List<WebElement> color = login.driver
					.findElements(By.xpath("//div[@class='color-picker-container']//div[@class='sp-preview-inner']"));
			for (WebElement e : color) {
				count++;
				if (count == i) {
					e.click();
					Thread.sleep(2000);
					login.driver.findElement(By.xpath(
							"//div[@class='sp-container sp-light sp-buttons-disabled sp-palette-buttons-disabled sp-initial-disabled color-picker-selection']//span[@title='"
									+ str1 + "']"))
							.click();
				}

			}
		}

	}

	@Then("^Save$")
	public void Save() throws InterruptedException {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("(//button[contains(text(),'Save')])[2]")).click();
	}

	@And("^titleSettings \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",(\\d+),\"([^\"]*)\",\"([^\"]*)\"$")
	public void titleSettings(String str, String str1, String str2, Integer i, String str3, String str4)
			throws InterruptedException {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(
				"//body[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]"))
				.click();
		WebElement checkbox = login.driver
				.findElement(By.xpath("//*[@name='" + str + "']//parent::div/parent::div//span"));
		if (str.equalsIgnoreCase("title")) {
			// WebElement
			// checkbox=login.driver.findElement(By.xpath("//*[@name='"+str+"']//parent::div/parent::div//span"));
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//*[@name='" + str + "']")).sendKeys("theju", Keys.ENTER);
			login.driver.findElement(By.xpath("//*[@name='" + str + "']/parent::div/following::div[contains(text(),'"
					+ str1 + "')]/parent::div//div[@class='sp-preview-inner']")).click();
			login.driver.findElement(By.xpath(
					"//div[@class='sp-container sp-light sp-buttons-disabled sp-palette-buttons-disabled sp-initial-disabled color-picker-selection']//span[@title='"
							+ str2 + "']"))
					.click();
			login.driver.findElement(By.xpath("//div[contains(text(),'Titles')]")).click();
			if (i > 0 && i <= 30) {
				login.driver.findElement(By.xpath("//input[@class='ui-spinner-input title_font_size']")).clear();
				login.driver.findElement(By.xpath("//input[@class='ui-spinner-input title_font_size']"))
						.sendKeys(i.toString(), Keys.ENTER);
			}
			login.driver.findElement(By.xpath("//button[@class='config-btn font-" + str3 + " ']")).click();
			login.driver.findElement(By.xpath("//button[@data-value='" + str4 + "']")).click();

			Thread.sleep(4000);
		}
		if (str.equalsIgnoreCase("sub_title")) {
			login.driver
					.findElement(By.xpath("//*[contains(text(),'Sub-title')]/following::div[@class='icon-collapse']"))
					.click();
			Thread.sleep(2000);
			checkbox.click();
			login.driver.findElement(By.xpath("//*[@name='" + str + "']")).sendKeys("theju", Keys.ENTER);
			login.driver.findElement(By.xpath("//*[@name='" + str + "']/parent::div/following::div[contains(text(),'"
					+ str1 + "')]/parent::div//div[@class='sp-preview-inner']")).click();
			login.driver.findElement(By.xpath(
					"//div[@class='sp-container sp-light sp-buttons-disabled sp-palette-buttons-disabled sp-initial-disabled color-picker-selection']//span[@title='"
							+ str2 + "']"))
					.click();
			// login.driver.findElement(By.xpath("//div[contains(text(),'Titles')]")).click();
			if (i > 0 && i <= 30) {
				login.driver.findElement(By.xpath("//input[@class='ui-spinner-input sub_title_font_size']")).clear();
				login.driver.findElement(By.xpath("//input[@class='ui-spinner-input sub_title_font_size']"))
						.sendKeys(i.toString(), Keys.ENTER);
			}

			login.driver.findElement(By.xpath(
					"//div[contains(text(),'Sub-title')]/following::div[@class='col']//button[@class='config-btn font-"
							+ str3 + " ']"))
					.click();

			login.driver.findElement(By.xpath("//button[@data-value='" + str4 + "']")).click();

			Thread.sleep(4000);
		}

	}

	public static void mapPosition(Integer i, String str) {

		if (i >= 30 && i <= 100) {
			login.driver
					.findElement(By.xpath("//div[@class='size-control--row']//input[@name='visual_area_proportion_x']"))
					.clear();
			login.driver
					.findElement(By.xpath("//div[@class='size-control--row']//input[@name='visual_area_proportion_x']"))
					.sendKeys(i.toString(), Keys.ENTER);
		}
		login.driver.findElement(By.xpath(
				"//div[@class='alignment-control--togglers alignment-control--togglers__space_between']/div[@title='"
						+ str + "']"))
				.click();
		login.driver.findElement(By.xpath("//div[@class='visual-types-panel--header']")).click();

	}

	public void mapBackground(List<String> str, Integer i) throws Exception, InterruptedException {
		backGroundDropDown(str);
		uploadImageOfMap();
		// opacity(i);

	}

	public void mapBorder(List<String> str, String str1, Integer i, Integer i1, String str2)
			throws InterruptedException {
		borderDropDown(str);
		colorSelectionOfMap(str1);
		widthSelectionOfMap(i);
		radiusOfMap(i1);
		styleOfMap(str2);

	}

	public void visualBackGround(List<String> str1, Integer i) throws AWTException, InterruptedException {
		backGroundDropDown(str1);
		uploadImageOfVisual();
		// opacityVisual(i);

	}

	public void visualBorder(List<String> str, String str1, Integer i, Integer i1, String str2)
			throws InterruptedException {
		borderDropDown(str);
		colorSelectionOfVisual(str1);
		widthSelectionOfVisual(i);
		radiusOfVisual(i1);
		styleOfVisual(str2);
	}

	@And("^borderSettings \"([^\"]*)\",\"([^\"]*)\",(\\d+),\"([^\"]*)\",(\\d+),(\\d+),\"([^\"]*)\",(\\d+),\"([^\"]*)\"$")
	public void borderSettings(String str, List<String> str1, Integer opacity, String color, Integer width,
			Integer radius, String style, Integer propotion, String align) throws InterruptedException, Exception {
		String str2;
		login.driver.findElement(By.xpath("//div[@class='visual-types-panel--header']//div[contains(text(),'Map')]"))
				.click();
		login.driver.findElement(By.xpath(
				"//div[@title='Map borders. Configure color, width, line type for displayed borders.']/following-sibling::div/div"))
				.click();
		// login.driver.findElement(By.xpath("//*[contains(text(),'"+str+"')]/following::div[2]")).click();
		str2 = str.replaceAll(" ", "");
		if (str2.equalsIgnoreCase("mapBackground")) {
			login.driver.findElement(By.xpath("//*[contains(text(),'" + str + "')]/following::div[2]")).click();
			mapBackground(str1, opacity);
		}
		if (str2.equalsIgnoreCase("mapBorder")) {
			mapBorder(str1, color, width, radius, style);
		}
		if (str2.equalsIgnoreCase("mapPosition")) {
			login.driver.findElement(By.xpath("//*[contains(text(),'" + str + "')]/following::div[2]")).click();
			mapPosition(propotion, align);
		}
		if (str2.equalsIgnoreCase("visualBackGround")) {
			login.driver.findElement(By.xpath("//*[contains(text(),'" + str + "')]/following::div[2]")).click();
			visualBackGround(str1, opacity);
		}
		if (str2.equalsIgnoreCase("visualBorder")) {

			visualBorder(str1, color, width, radius, style);
		}
	}

	@And("^backGroundSettings \"([^\"]*)\",\"([^\"]*)\",(\\d+),\"([^\"]*)\",(\\d+),(\\d+),\"([^\"]*)\",(\\d+),\"([^\"]*)\"$")
	public void backGroundSettings(String str, List<String> str1, Integer opacity, String color, Integer width,
			Integer radius, String style, Integer propotion, String align) throws InterruptedException, Exception {
		String str2;
		login.driver.findElement(By.xpath("//div[@class='visual-types-panel--header']//div[contains(text(),'Map')]"))
				.click();
		login.driver.findElement(By.xpath(
				"//div[@title='Map backgrounds. Configure the backgrounds in the visual.']/following-sibling::div/div"))
				.click();
		// login.driver.findElement(By.xpath("//*[contains(text(),'"+str+"')]/following::div[2]")).click();
		str2 = str.replaceAll(" ", "");
		if (str2.equalsIgnoreCase("mapBackground")) {

			mapBackground(str1, opacity);
		}
		if (str2.equalsIgnoreCase("mapBorder")) {
			login.driver.findElement(By.xpath("//*[contains(text(),'" + str + "')]/following::div[2]")).click();
			mapBorder(str1, color, width, radius, style);
		}
		if (str2.equalsIgnoreCase("mapPosition")) {
			login.driver.findElement(By.xpath("//*[contains(text(),'" + str + "')]/following::div[2]")).click();
			mapPosition(propotion, align);
		}
		if (str2.equalsIgnoreCase("visualBackGround")) {

			visualBackGround(str1, opacity);
		}
		if (str2.equalsIgnoreCase("visualBorder")) {
			login.driver.findElement(By.xpath("//*[contains(text(),'" + str + "')]/following::div[2]")).click();

			visualBorder(str1, color, width, radius, style);
		}
	}

	@And("^legendSettings \"([^\"]*)\",\"([^\"]*)\",(\\d+),\"([^\"]*)\",\"([^\"]*)\",\\\"([^\"]*)\",(\\d+),\"([^\"]*)\",\"([^\"]*)\",(\\d+),(\\d+),\"([^\"]*)\",(\\d+)$")
	public void legendSettings(List<String> str1, String str, Integer propotion, String align, String str2, String axis,
			Integer size, String color, String style, Integer width, Integer radius, String coloraxes, Integer step)
			throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(
				"//div[@title='Legend. Configure the settings of the map legend.']//div[@title='Open advanced settings popup']"))
				.click();
		for (String foreach : str1)
			if (foreach.equalsIgnoreCase("Common")) {
				login.driver.findElement(By.xpath("//*[contains(text(),'" + str + "')]/preceding-sibling::span"))
						.click();
			} else if (foreach.equalsIgnoreCase("Position")) {
				login.driver.findElement(By.xpath(
						"//div[contains(text(),'" + foreach + "')]/following-sibling::div[@class='icon-collapse']"))
						.click();
				login.driver
						.findElement(By.xpath(
								"//*[contains(text(),'" + axis + " align:')]/following::div[@title='" + align + "']"))
						.click();
				Thread.sleep(2000);
			} else if (foreach.equalsIgnoreCase("Title")) {
				Thread.sleep(2000);
				WebElement title = login.driver.findElement(By.xpath(
						"//div[contains(text(),'" + foreach + "')]/following-sibling::div[@class='icon-collapse']"));
				JavascriptExecutor js = (JavascriptExecutor) login.driver;
				js.executeScript("arguments[0].click();", title);
				WebElement checkbox = login.driver.findElement(By
						.xpath("//*[@name='legend_title_display']/following::span[@class='input-control--indicator']"));
				checkbox.click();
				login.driver.findElement(By.xpath("//*[@name='legend_title']")).sendKeys("theju", Keys.ENTER);
				login.driver.findElement(By.xpath("//*[@name='" + foreach
						+ "']/parent::div/following::div[contains(text(),'Color')]/parent::div//div[@class='sp-preview-inner']"))
						.click();
				login.driver.findElement(By.xpath(
						"//div[@class='sp-container sp-light sp-buttons-disabled sp-palette-buttons-disabled sp-initial-disabled color-picker-selection']//span[@title='"
								+ color + "']"))
						.click();
				// login.driver.findElement(By.xpath("//div[contains(text(),'Titles')]")).click();
				if (size > 0 && size <= 30) {
					login.driver.findElement(By.xpath("//input[@class='ui-spinner-input title_font_size']")).clear();
					login.driver.findElement(By.xpath("//input[@class='ui-spinner-input title_font_size']"))
							.sendKeys(size.toString(), Keys.ENTER);
				}
				login.driver.findElement(By.xpath("//button[@class='config-btn font-" + style + " ']")).click();

			} else if (foreach.equalsIgnoreCase("Background")) {
				login.driver.findElement(By.xpath(
						"//div[contains(text(),'" + foreach + "')]/following-sibling::div[@class='icon-collapse']"))
						.click();
				WebElement checkbox = login.driver.findElement(By.xpath(
						"//input[@name='legend_background_display']/following::span[@class='input-control--indicator']"));
				if (checkbox.isSelected()) {
					System.out.println("ït is selected");
				} else if (!(checkbox.isSelected())) {
					System.out.println("ït is not selected");
					checkbox.click();

				}
				try {
					login.driver.findElement(By.xpath(
							"//input[@name='legend_background_color']/following::div[@class='sp-preview-inner']"))
							.click();
					login.driver.findElement(By.xpath(
							"//div[@class='sp-container sp-light sp-buttons-disabled sp-palette-buttons-disabled sp-initial-disabled color-picker-selection']//span[@title='"
									+ color + "']"))
							.click();

				} catch (Exception e) {
					login.driver.findElement(By.xpath(
							"//div[@class='background-control--options']//div[@class='color-picker-control']//div[@class='sp-preview-inner']"))
							.click();
					login.driver.findElement(By.xpath(
							"//div[@class='sp-container sp-light sp-buttons-disabled sp-palette-buttons-disabled sp-initial-disabled color-picker-selection']//span[@title='"
									+ color + "']"))
							.click();
				}
				wait.until(ExpectedConditions.elementToBeClickable(
						login.driver.findElement(By.xpath("//input[@name='plot_area_background_opacity']"))));
				login.driver.findElement(By.xpath("//input[@name='legend_background_opacity']")).clear();
				login.driver.findElement(By.xpath("//input[@name='legend_background_opacity']"))
						.sendKeys(size.toString(), Keys.ENTER);
				// login.driver.findElement(By.xpath("//div[@class='visual-types-panel--header']")).click();
			} else if (foreach.equalsIgnoreCase("Border")) {
				login.driver.findElement(By.xpath(
						"//div[contains(text(),'" + foreach + "')]/following-sibling::div[@class='icon-collapse']"))
						.click();

				login.driver
						.findElement(By
								.xpath("//div[@ui='$legend_border_control']//span[@class='input-control--indicator']"))
						.click();
				login.driver
						.findElement(By.xpath(
								"//input[@name='legend_border_color']/following::div[@class='sp-preview-inner']"))
						.click();
				login.driver.findElement(By.xpath(
						"//div[@class='sp-container sp-light sp-buttons-disabled sp-palette-buttons-disabled sp-initial-disabled color-picker-selection']//span[@title='"
								+ color + "']"))
						.click();
				login.driver.findElement(By.name("legend_border_width")).sendKeys(width.toString(), Keys.ENTER);
				login.driver.findElement(By.name("legend_border_radius")).sendKeys(radius.toString(), Keys.ENTER);
				login.driver.findElement(By.xpath(
						"//input[@name='legend_border_radius']/parent::span/parent::div//following-sibling::div[@class='select-control']//span[@class='select2-arrow']"))
						.click();
				login.driver.findElement(By.xpath("//div[@id='select2-drop']//ul//li//div[@title='" + style + "']"))
						.click();
			} else if (foreach.equalsIgnoreCase("Color axes")) {
				login.driver.findElement(By.xpath(
						"//div[contains(text(),'" + foreach + "')]/following-sibling::div[@class='icon-collapse']"))
						.click();
				login.driver.findElement(By.xpath(
						"//div[@class='color-axes']//div[@class='color-axis--row'][1]//label/span[contains(text(),'"
								+ coloraxes + "')]"))
						.click();
				if (coloraxes.equalsIgnoreCase("Gradient")) {
					login.driver.findElement(By.xpath("//div[@ui='$color_axes']//select[@name='steps']")).click();
					if (step >= 0 && step <= 5) {
						int count = 0;
						Select s = new Select(login.driver.findElement(By.name("steps")));
						s.selectByValue(step.toString());
						List<WebElement> color1 = login.driver.findElements(By.xpath(
								"//div[@ui='$color_axes']//div[@class='gradient-selection']//div[@class='gradient-color']//div[@class='sp-preview-inner']"));
						for (WebElement e : color1) {
							count++;
							if (count == step) {
								e.click();
								login.driver.findElement(By.xpath(
										"//div[@class='sp-container sp-light sp-buttons-disabled sp-palette-buttons-disabled sp-initial-disabled color-picker-selection']//span[@title='"
												+ color + "']"))
										.click();
							}

						}
					}
				} else {
					login.driver.findElement(By.xpath("//div[@ui='$color_axes']//select[@name='steps']")).click();
					if (step >= 2 && step <= 10) {
						int count = 0;
						Select s = new Select(login.driver.findElement(By.name("steps")));
						s.selectByValue(step.toString());
						List<WebElement> color1 = login.driver.findElements(By.xpath(
								"//div[@ui='$color_axes']//div[@class='solid-color']//div[@class='sp-preview-inner']"));
						for (WebElement e : color1) {
							count++;
							if (count == step) {
								e.click();
								login.driver.findElement(By.xpath(
										"//div[@class='sp-container sp-light sp-buttons-disabled sp-palette-buttons-disabled sp-initial-disabled color-picker-selection']//span[@title='"
												+ color + "']"))
										.click();
							}

						}
					}
				}
			}
	}

	@And("^copyrightSettings \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",(\\d+),\"([^\"]*)\"$")
	public void copyrightSetting(String str, String str1, String str2, String str3, String align, String str4,
			String color, Integer size, String style) throws AWTException, Throwable {
		login.driver.findElement(By.xpath("//div[@class='visual-types-panel--header']//div[contains(text(),'Map')]"))
				.click();
		login.driver.findElement(By.xpath(
				"//div[@title='Source. Configure displaying of the source in the map.']//div[@title='Open advanced settings popup']"))
				.click();
		WebElement checkbox = login.driver.findElement(By
				.xpath("//*[contains(text(),'Show copyright')]/parent::label/span[@class='input-control--indicator']"));

		WebElement radio = login.driver.findElement(
				By.xpath("//*[contains(text(),'" + str + "')]/parent::label/span[@class='input-control--indicator']"));
		if (str.equalsIgnoreCase("image")) {

			Robot robot = new Robot();
			login.driver
					.findElement(By.xpath(
							"//*[contains(text(),'Text')]/parent::label/span[@class='input-control--indicator']"))
					.click();
			robot.setAutoDelay(2000);

			StringSelection selection = new StringSelection(str1);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			login.driver
					.findElement(By.xpath(
							"//*[contains(text(),'Link')]/following::input[@value='https://www.ceicdata.com/en']"))
					.clear();
			login.driver
					.findElement(By.xpath(
							"//*[contains(text(),'Link')]/following::input[@value='https://www.ceicdata.com/en']"))
					.sendKeys(str2, Keys.ENTER);
			login.driver.findElement(By.xpath("//button[@data-value='" + align + "']/div")).click();
		} else {

			radio.click();

			login.driver
					.findElement(By.xpath("//*[contains(text(),'Text')]/following::input[@value='Source: CEIC Data']"))
					.clear();
			login.driver
					.findElement(By.xpath("//*[contains(text(),'Text')]/following::input[@value='Source: CEIC Data']"))
					.sendKeys(str3, Keys.ENTER);
			login.driver.findElement(By.xpath("//*[contains(text(),'Link')]/following::input[@name='credits_link']"))
					.sendKeys(str4, Keys.ENTER);
			login.driver.findElement(By.xpath(
					"//div[@ui='$text_block']//div[@class='color-picker-container']//div[@class='sp-preview-inner']"))
					.click();
			login.driver.findElement(By.xpath(
					"//div[@class='sp-container sp-light sp-buttons-disabled sp-palette-buttons-disabled sp-initial-disabled color-picker-selection']//span[@title='"
							+ color + "']"))
					.click();
			login.driver.findElement(By.xpath("//div[@ui='$text_block']//input[@name='credits_font_size']")).clear();
			login.driver.findElement(By.xpath("//div[@ui='$text_block']//input[@name='credits_font_size']"))
					.sendKeys(size.toString(), Keys.ENTER);
			jse.executeScript("arguments[0].click();",
					login.driver.findElement(By.xpath("//button[@class='config-btn font-" + style + " widget ']")));
			jse.executeScript("arguments[0].click();",
					login.driver.findElement(By.xpath("//button[@data-value='" + align + "']/div")));
			Thread.sleep(2000);
		}
	}

	@And("^dataLabelsSettings \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",(\\d+),\"([^\"]*)\"$")
	public void dataLabelsSettings(List<String> str, ArrayList<String> str1, ArrayList<String> color,
			ArrayList<String> colorvalue, Integer size, String style) throws InterruptedException {
		login.driver.findElement(By.xpath("//div[@class='visual-types-panel--header']//div[contains(text(),'Map')]"))
				.click();
		login.driver.findElement(By.xpath(
				"//div[@title='Data labels. Configure displaying of the data labels in the map.']//div[@title='Open advanced settings popup']"))
				.click();
		for (String foreach : str) {
			if (foreach.equalsIgnoreCase("Common")) {
				WebElement showlabel = login.driver
						.findElement(By.xpath("//*[contains(text(),'Show labels')]/preceding-sibling::span"));

			} else {
				login.driver.findElement(By.xpath(
						"//div[contains(text(),'" + foreach + "')]/following-sibling::div[@class='icon-collapse']"))
						.click();
				for (String str2 : str1) {
					WebElement checkbox = login.driver.findElement(By.xpath("//*[contains(text(),'" + str2
							+ "')]/preceding-sibling::span[@class='input-control--indicator']"));
					if (checkbox.isSelected()) {
						System.out.println("selected");
					}

				}
				/*
				 * for(String str3:color) { login.driver.findElement(By.xpath(
				 * "//input[@name='data_labels_color']/following::div[contains(text(),'"+str3+
				 * "')]/parent::div//div[@class='sp-preview-inner']")).click(); for(String
				 * str4:colorvalue) { login.driver.findElement(By.
				 * xpath("//div[@class='sp-container sp-light sp-buttons-disabled sp-palette-buttons-disabled sp-initial-disabled color-picker-selection']//span[@title='"
				 * +colorvalue+"']")).click(); } }
				 */
				login.driver.findElement(By.xpath("//input[@name='data_labels_font_size']")).clear();
				login.driver.findElement(By.xpath("//input[@name='data_labels_font_size']")).sendKeys(size.toString(),
						Keys.ENTER);
				jse.executeScript("arguments[0].click();",
						login.driver.findElement(By.xpath("//button[@class='config-btn font-" + style + " widget ']")));
				Thread.sleep(2000);
			}
		}
	}

	@And("^colorAxes \"([^\"]*)\",\"([^\"]*)\",(\\d+),\"([^\"]*)\",\"([^\"]*)\",\\\"([^\"]*)\",(\\d+),\"([^\"]*)\",\"([^\"]*)\",(\\d+),(\\d+),\"([^\"]*)\",(\\d+)$")
	public void colorAxes(List<String> str1, String str, Integer propotion, String align, String str2, String axis,
			Integer size, String color, String style, Integer width, Integer radius, String coloraxes, Integer step)
			throws Throwable {
		login.driver.findElement(By.xpath(
				"//div[@class='base-config--column base-config--column__color-axis']//div[@title='Open advanced settings popup']"))
				.click();
		for (String foreach : str1)
			if (foreach.equalsIgnoreCase("Common")) {
				login.driver.findElement(By.xpath("//*[contains(text(),'" + str + "')]/preceding-sibling::span"))
						.click();
			} else if (foreach.equalsIgnoreCase("Position")) {
				login.driver.findElement(By.xpath(
						"//div[contains(text(),'" + foreach + "')]/following-sibling::div[@class='icon-collapse']"))
						.click();
				login.driver
						.findElement(By.xpath(
								"//*[contains(text(),'" + axis + " align:')]/following::div[@title='" + align + "']"))
						.click();
				Thread.sleep(2000);
			} else if (foreach.equalsIgnoreCase("Title")) {
				Thread.sleep(2000);
				WebElement title = login.driver.findElement(By.xpath(
						"//div[contains(text(),'" + foreach + "')]/following-sibling::div[@class='icon-collapse']"));
				JavascriptExecutor js = (JavascriptExecutor) login.driver;
				js.executeScript("arguments[0].click();", title);
				WebElement checkbox = login.driver.findElement(By
						.xpath("//*[@name='legend_title_display']/following::span[@class='input-control--indicator']"));
				checkbox.click();
				login.driver.findElement(By.xpath("//*[@name='legend_title']")).sendKeys("theju", Keys.ENTER);
				login.driver.findElement(By.xpath("//*[@name='" + foreach
						+ "']/parent::div/following::div[contains(text(),'Color')]/parent::div//div[@class='sp-preview-inner']"))
						.click();
				login.driver.findElement(By.xpath(
						"//div[@class='sp-container sp-light sp-buttons-disabled sp-palette-buttons-disabled sp-initial-disabled color-picker-selection']//span[@title='"
								+ color + "']"))
						.click();
				// login.driver.findElement(By.xpath("//div[contains(text(),'Titles')]")).click();
				if (size > 0 && size <= 30) {
					login.driver.findElement(By.xpath("//input[@class='ui-spinner-input title_font_size']")).clear();
					login.driver.findElement(By.xpath("//input[@class='ui-spinner-input title_font_size']"))
							.sendKeys(size.toString(), Keys.ENTER);
				}
				login.driver.findElement(By.xpath("//button[@class='config-btn font-" + style + " ']")).click();

			} else if (foreach.equalsIgnoreCase("Background")) {
				login.driver.findElement(By.xpath(
						"//div[contains(text(),'" + foreach + "')]/following-sibling::div[@class='icon-collapse']"))
						.click();
				WebElement checkbox = login.driver.findElement(By.xpath(
						"//input[@name='legend_background_display']/following::span[@class='input-control--indicator']"));
				if (checkbox.isSelected()) {
					System.out.println("ït is selected");
				} else if (!(checkbox.isSelected())) {
					System.out.println("ït is not selected");
					checkbox.click();

				}
				try {
					login.driver.findElement(By.xpath(
							"//input[@name='legend_background_color']/following::div[@class='sp-preview-inner']"))
							.click();
					login.driver.findElement(By.xpath(
							"//div[@class='sp-container sp-light sp-buttons-disabled sp-palette-buttons-disabled sp-initial-disabled color-picker-selection']//span[@title='"
									+ color + "']"))
							.click();

				} catch (Exception e) {
					login.driver.findElement(By.xpath(
							"//div[@class='background-control--options']//div[@class='color-picker-control']//div[@class='sp-preview-inner']"))
							.click();
					login.driver.findElement(By.xpath(
							"//div[@class='sp-container sp-light sp-buttons-disabled sp-palette-buttons-disabled sp-initial-disabled color-picker-selection']//span[@title='"
									+ color + "']"))
							.click();
				}
				wait.until(ExpectedConditions.elementToBeClickable(
						login.driver.findElement(By.xpath("//input[@name='plot_area_background_opacity']"))));
				login.driver.findElement(By.xpath("//input[@name='legend_background_opacity']")).clear();
				login.driver.findElement(By.xpath("//input[@name='legend_background_opacity']"))
						.sendKeys(size.toString(), Keys.ENTER);
				// login.driver.findElement(By.xpath("//div[@class='visual-types-panel--header']")).click();
			} else if (foreach.equalsIgnoreCase("Border")) {
				jse.executeScript("arguments[0].click();", login.driver.findElement(By.xpath(
						"//div[contains(text(),'" + foreach + "')]/following-sibling::div[@class='icon-collapse']")));

				jse.executeScript("arguments[0].click();", login.driver.findElement(
						By.xpath("//div[@ui='$legend_border_control']//span[@class='input-control--indicator']")));
				login.driver
						.findElement(By.xpath(
								"//input[@name='legend_border_color']/following::div[@class='sp-preview-inner']"))
						.click();
				login.driver.findElement(By.xpath(
						"//div[@class='sp-container sp-light sp-buttons-disabled sp-palette-buttons-disabled sp-initial-disabled color-picker-selection']//span[@title='"
								+ color + "']"))
						.click();
				login.driver.findElement(By.name("legend_border_width")).sendKeys(width.toString(), Keys.ENTER);
				login.driver.findElement(By.name("legend_border_radius")).sendKeys(radius.toString(), Keys.ENTER);
				login.driver.findElement(By.xpath(
						"//input[@name='legend_border_radius']/parent::span/parent::div//following-sibling::div[@class='select-control']//span[@class='select2-arrow']"))
						.click();
				login.driver.findElement(By.xpath("//div[@id='select2-drop']//ul//li//div[@title='" + style + "']"))
						.click();
			} else if (foreach.equalsIgnoreCase("Color axes")) {

				jse.executeScript("arguments[0].click();", login.driver.findElement(By.xpath(
						"//div[@class='color-axes']//div[@class='color-axis--row'][1]//div/span[contains(text(),'"
								+ coloraxes + "')]")));
				if (coloraxes.equalsIgnoreCase("Gradient")) {
					login.driver.findElement(By.xpath("//div[@ui='$color_axes']//select[@name='steps']")).click();
					if (step >= 0 && step <= 5) {
						int count = 0;
						Select s = new Select(login.driver.findElement(By.name("steps")));
						s.selectByValue(step.toString());
						List<WebElement> color1 = login.driver.findElements(By.xpath(
								"//div[@ui='$color_axes']//div[@class='gradient-selection']//div[@class='gradient-color']//div[@class='sp-preview-inner']"));
						for (WebElement e : color1) {
							count++;
							if (count == step) {
								e.click();
								login.driver.findElement(By.xpath(
										"//div[@class='sp-container sp-light sp-buttons-disabled sp-palette-buttons-disabled sp-initial-disabled color-picker-selection']//span[@title='"
												+ color + "']"))
										.click();
							}

						}
					}
				} else {
					jse.executeScript("arguments[0].click();",
							login.driver.findElement(By.xpath("//div[@ui='$color_axes']//select[@name='steps']")));
					if (step >= 2 && step <= 10) {
						int count = 0;
						Select s = new Select(login.driver.findElement(By.name("steps")));
						s.selectByValue(step.toString());
						List<WebElement> color1 = login.driver.findElements(By.xpath(
								"//div[@ui='$color_axes']//div[@class='solid-color']//div[@class='sp-preview-inner']"));
						for (WebElement e : color1) {
							count++;
							if (count == step) {
								jse.executeScript("arguments[0].click();", e);
								login.driver.findElement(By.xpath(
										"//div[@class='sp-container sp-light sp-buttons-disabled sp-palette-buttons-disabled sp-initial-disabled color-picker-selection']//span[@title='"
												+ color + "']"))
										.click();
							}

						}
					}
				}
			}

	}

	@Then("^selectSeries \"([^\"]*)\"$")
	public void selectSeries(int seriescount) throws InterruptedException {

		WebElement Series = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series")));
		Thread.sleep(2000);
		try {
			Series.click();
			int count = 1;
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("seriesdiv"))));
			List<WebElement> series = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("series")));

			for (WebElement seri : series) {
				seri.click();
				count++;
				if (count > seriescount) {
					break;
				}
			}
		} catch (WebDriverException e) {

			Series.click();
			int count = 1;
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("seriesdiv"))));
			List<WebElement> series = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("series")));

			for (WebElement seri : series) {
				seri.click();
				count++;
				if (count > seriescount) {
					break;
				}
			}
		}
	}

	@Then("^keyBoardmap$")
	public void keyBoardmap() throws InterruptedException, AWTException {

		Actions action = new Actions(login.driver);
		action.sendKeys((Keys.chord("m"))).build().perform();
		// wait.until(ExpectedConditions.visibilityOf(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Apply")))));
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Apply"))).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();

	}

}
