package CDMNext.StepDefinations;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.AssertJUnit;

import CDMNext.util.CommonFunctionality;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class Histogram {
	DatabasesTab db = new DatabasesTab();
	SeriesTab St = new SeriesTab();
	String Applied_function, CurrencyFunction, MissingValueMethod;
	JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	Commentary commentary = new Commentary();
	String Expected_sname, DailyFrequency;
	String Visual_Title_txt, BeforeEditSeriesTitle;
	WebElement SeriesCount;
	String SearchKeyword, BeforeAddingFunction, BeforeEditingFunction;
	String ReplaceKeyword, SeriesName, EditSeriesName;
	String EditRegion, EditUnit, EditFrequency;
	String BeforeEditSeries, AddFunction, function, function1;
	String ChangeFunction, AggregateFunction, AccumulateFunction;
	Commentary comm = new Commentary();
	SeriesTab seriesTab = new SeriesTab();
	DatabasesTab database = new DatabasesTab();
	List<String> styles = new ArrayList<>();
	String SName, AutoTitle, SRegion,VisualTitle,EditSeries_function;
	List<String> ListOfalignmentValue = new ArrayList<>();
	String[] Sfrequency;
	int decimal_value;

	@And("^Drag and drop histogram visual to the page$")
	public void drag_and_drop_histogram_visual_to_the_page() throws Throwable {
		String histogram = null;
		String ViewContainer = null;
		CommonFunctionality.wait(1500);
		histogram = "//*[@data-instance='histogram']/*[1]";
		ViewContainer = "//*[@class='view-components-over--visuals']//*[@class='view-components-over--visual'][1]";
		commentary.DragAndDrop(histogram, ViewContainer);
	}

	@Then("^Histogram should be inserted$")
	public void histogram_should_be_inserted() throws Throwable {

		WebElement histogramVisual = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='insight-visual insight-visual__can-hover insight-visual__selected']", 5);
		if (histogramVisual.isDisplayed()) {
			login.Log4j.info("Histogram visual is created");
		} else {
			Assert.fail("Histogram visual is not created");
		}
		CommonFunctionality.DeleteVisual();
	}

	@SuppressWarnings("deprecation")
	@And("^Click on histogram visual icon$")
	public void click_on_histogram_visual_icon() throws Throwable {
		new Actions(login.driver).pause(2000)
				.moveToElement(login.driver
						.findElement(By.xpath("//*[@data-instance='histogram']//*[@class='icon--histogram']")))
				.click().perform();

	}

	@And("^Create a Histogram visual without selecting series$")
	public void create_a_Histogram_visual_without_selecting_series() throws Throwable {
		commentary.CreateViewTab();
		click_on_histogram_visual_icon();
	}

	@Then("^The Edit histogram should be disabled$")
	public void the_Edit_histogram_should_be_disabled() throws Throwable {
		CommonFunctionality.wait(1000);
		Boolean Edit_histogram = login.driver
				.findElement(By.xpath("//button[@class='button button__sm button__special']")).isEnabled();
		login.Log4j.info(Edit_histogram);
		if (!Edit_histogram == true) {
			login.Log4j.info("The Edit histogram is disabled");
		} else {
			Assert.fail("The Edit histogram is not disabled");
		}
		CommonFunctionality.DeleteVisual();
	}

	@And("^Click on Edit series option$")
	public void click_on_Edit_series_option() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Edit Series')]", 5).click();
	}

	@Then("^The Edit series panel should be opened$")
	public void the_Edit_series_panel_should_be_opened() throws Throwable {
		CommonFunctionality.wait(1000);
		WebElement series_panel = login.driver
				.findElement(By.xpath("//*[@class='sidebar-panel sidebar-panel__opened']"));
		if (series_panel.isDisplayed()) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='sidebar-panel--header-close']", 5).click();
			login.Log4j.info("Edit series panel is opened");
		} else {
			Assert.fail("Edit series panel is not opened");
		}
		CommonFunctionality.DeleteVisual();
	}

	@Then("^By deault user should redirect to \"([^\"]*)\" tab$")
	public void by_deault_user_should_redirect_to_tab(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		Boolean Add_from_MySeries = login.driver
				.findElement(By.xpath("//*[@class='sidebar-panel--tab sidebar-panel--tab__active']")).isDisplayed();
		if (Add_from_MySeries == true) {
			String StrExpected = login.driver
					.findElement(By.xpath(
							"//*[contains(@class,'sidebar-panel--tab__active')]//*[@class='sidebar-panel--tab-name']"))
					.getText();
			if (arg1.equals(StrExpected)) {
				login.Log4j.info("By default user is redirect to " + arg1);
				CommonFunctionality.getElementByXpath(login.driver, "//*[@class='sidebar-panel--header-close']", 5)
						.click();
			} else {
				Assert.fail("User is not redirect to " + arg1);
			}
			CommonFunctionality.DeleteVisual();
		}
	}

	@And("^Add some series to my series$")
	public void add_some_series_to_my_series() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Series", 5).click();
		CommonFunctionality.wait(2000);
		WebElement ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		AssertJUnit.assertNotNull(ul_element);
		List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
		List<WebElement> checkBox = login.driver
				.findElements(By.xpath("//li//div[@class='series-list-item--checkbox-wrapper']"));
		for (int i = 0; i < li_All.size(); i++) {
			CommonFunctionality.wait(300);
			checkBox.get(i).click();
			if (i == 2) {
				CommonFunctionality.wait(300);
				WebElement addIcon = login.driver
						.findElement(By.xpath("//li[ " + i + "]//*[@class ='add-to-data-selection--icon']"));
				addIcon.click();
				break;
			}
		}
	}

	@Then("^The \"([^\"]*)\" and \"([^\"]*)\" should be displayed$")
	public void the_and_should_be_displayed(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(1500);
		String str1 = login.driver.findElement(By.xpath("//*[@class ='empty-visual-overlay--title']")).getText();
		String str2 = login.driver.findElement(By.xpath("//*[@class ='empty-visual-overlay--text']")).getText();
		String str3 = login.driver.findElement(By.xpath("//*[@class ='empty-visual-overlay--sub-text']")).getText();
		if (arg1.equals(str1) && arg2.contains(str2) && arg2.contains(str3)) {
			login.Log4j.info(arg1 + "\n" + arg2 + " is displayed");
		} else {
			Assert.fail("Verification failed");
		}
		CommonFunctionality.Views_list();
	}

	@Then("^The \"([^\"]*)\" and \"([^\"]*)\" should be displayed for empty visual$")
	public void the_and_should_be_displayed_for_empty_visual(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(1500);
		String str1 = login.driver.findElement(By.xpath("//*[@class ='empty-visual-overlay--title']")).getText();
		String str2 = login.driver.findElement(By.xpath("//*[@class ='empty-visual-overlay--text']")).getText();

		if (arg1.equals(str1) && arg2.equals(str2)) {
			login.Log4j.info(arg1 + "\n" + arg2 + " is displayed");
		} else {
			Assert.fail("Verification failed");
		}
		CommonFunctionality.DeleteVisual();
	}

	@And("^Choose \"([^\"]*)\" tab$")
	public void choose_tab(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='sidebar-panel--tab-name-txt']", 5).click();
	}

	@Then("^Should redirect to \"([^\"]*)\" tab$")
	public void should_redirect_to_tab(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		String Expected = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='sidebar-panel--tab sidebar-panel--tab__active']", 5)
				.getText();
		if (arg1.contains(Expected)) {
			login.Log4j.info("Redirect to " + arg1 + " tab");
		} else {
			Assert.fail("Verification failed");
		}
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='sidebar-panel--header-close']", 5).click();
		CommonFunctionality.DeleteVisual();
	}

	@And("^Add series to the my series tab$")
	public void add_series_to_the_my_series_tab() throws Throwable {
		CommonFunctionality.ResetMethod();
		CommonFunctionality.getElementByProperty(login.driver, "Search", 5).sendKeys("210698402");
		CommonFunctionality.getElementByProperty(login.driver, "Series", 20).click();
		CommonFunctionality.wait(1000);
		SName = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-item--name']", 10).getText();
		SeriesCount = login.driver.findElement(By.xpath("//*[@class='series-series-count--number']"));
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='add-to-data-selection--icon']", 10).click();
	}

	@SuppressWarnings("deprecation")
	@And("^Apply function for a series$")
	public void apply_function_for_a_series() throws Throwable {
		String change_function = "%CHANGE()";
		WebElement ele = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='check-all-series']//*[@class='input-control--indicator']", 5);
		new Actions(login.driver).moveToElement(ele).pause(500).click().build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='functions-input-container']", 3).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='functions-input-container']//input", 3)
				.sendKeys(change_function);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@data-id='over_year']", 2).click();
		CommonFunctionality.wait(500);
		Applied_function = login.driver.findElement(By.xpath("//*[@class='series-function-item--body']")).getText();
		// Applied_function = function.replaceAll("\n", "");
		// login.Log4j.info(Applied_function);
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(@class,'series-functions-panel--icon__apply')]", 5)
				.click();

	}

	@SuppressWarnings("deprecation")
	@And("^Right click on series$")
	public void right_click_on_series() throws Throwable {
		CommonFunctionality.wait(700);
		WebElement sname = login.driver.findElement(By.xpath("//*[@class='series-name-field--series-name']"));
		new Actions(login.driver).pause(500).contextClick(sname).click().build().perform();
	}

	@And("^Select Histogram visual$")
	public void select_Histogram_visual() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@data-action='view_as']", 5).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Histogram']", 5).click();
	}

	@Then("^The functions should be applied to the series$")
	public void the_functions_should_be_applied_to_the_series() throws Throwable {
		CommonFunctionality.wait(1000);
		WebElement function_ele = login.driver
				.findElement(By.xpath("//*[@class='visual-series-list']//*[@title='Functions']"));
		jse.executeScript("arguments[0].scrollIntoView(true);", function_ele);
		String Function_txt = CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[@class='visual-series-panel--series']//*[@class='series-function-item--body']", 5)
				.getText();
		login.Log4j.info(Function_txt);

		if (Applied_function.equals(Function_txt)) {
			login.Log4j.info("The function is applied");
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='sidebar-panel--header-close']", 5).click();
			CommonFunctionality.Views_list();
			CommonFunctionality.ResetMethod();
		} else {
			Assert.fail("Function is not applied");
		}
	}

	@And("^Choose series from  \"([^\"]*)\"$")
	public void choose_series_from(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		Expected_sname = login.driver.findElement(By.xpath("//*[@class='series-name-field--series-name']")).getText();
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='check-all-series']//*[@class='input-control--indicator']", 6).click();
	}

	@Then("^The series should be added to histogram with its data$")
	public void the_series_should_be_added_to_histogram_with_its_data() throws Throwable {
		CommonFunctionality.wait(1000);
		Visual_Title_txt = login.driver.findElement(By.xpath("//*[@data-name='title']")).getText();
		if (Expected_sname.equals(Visual_Title_txt)) {
			login.Log4j.info("The selected series added to histogram visual from Add from My Series tab");
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='sidebar-panel--header-close']", 5).click();
			CommonFunctionality.Views_list();
		} else {
			Assert.fail("The selected series not added to histogram visual");
		}
	}

	@And("^Create histogram visual with series$")
	public void create_histogram_visual_with_series() throws Throwable {
		create_a_Histogram_visual_without_selecting_series();
		add_series_to_the_my_series_tab();
		CommonFunctionality.wait(1000);
		Visual_Title_txt = login.driver.findElement(By.xpath("//*[@data-name='title']")).getText();

	}

	@Then("^Edit series panel should be opened with \"([^\"]*)\" tab$")
	public void edit_series_panel_should_be_opened_with_tab(String arg1) throws Throwable {

		CommonFunctionality.wait(700);
		String ExpectedTxt = login.driver
				.findElement(By.xpath("//*[@class='sidebar-panel--tab sidebar-panel--tab__active']")).getText();
		if (arg1.equals(ExpectedTxt)) {
			login.Log4j.info("Edit seriespanel is opened with " + arg1 + " tab");
			CommonFunctionality.Views_list();
		} else {
			Assert.fail("Edit seriespanel is not opened with " + arg1 + " tab");
		}
	}

	@Then("^Associated series should be available$")
	public void associated_series_should_be_available() throws Throwable {
		CommonFunctionality.wait(700);
		Expected_sname = login.driver.findElement(By.xpath("//*[@class='series-name--title']")).getText();
		if (Visual_Title_txt.equals(Expected_sname)) {
			login.Log4j.info("PASS");
			CommonFunctionality.Views_list();
		} else {
			Assert.fail("Verification failed");
		}
	}

	@Then("^Number of selected series count should be shown on the rename popup header$")
	public void number_of_selected_series_count_should_be_shown_on_the_rename_popup_header() throws Throwable {
		CommonFunctionality.wait(1300);
		WebElement str = login.driver.findElement(By.xpath("//*[@class='find-and-replace--modal-title-info']"));
		if (str.getText().contains(SeriesCount.getText())) {
			login.Log4j.info("Number of selected series count is shown on the rename popup header");
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 6).click();
			CommonFunctionality.Views_list();
		} else {
			Assert.fail("Number of selected series count is not shown on the rename popup header");
		}
	}

	@And("^Search for the series you want to rename$")
	public void search_for_the_series_you_want_to_rename() throws Throwable {
		SearchKeyword = "Gross";
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='find-and-replace--panel-search-box']//input", 6)
				.sendKeys(SearchKeyword);
	}

	@Then("^Result should be loaded for searched keyword$")
	public void result_should_be_loaded_for_searched_keyword() throws Throwable {
		CommonFunctionality.wait(1000);
		WebElement SearchResult = login.driver
				.findElement(By.xpath("//*[@class='find-and-replace-item--name']//input"));
		if (SearchResult.isDisplayed()) {
			if (SearchResult.getAttribute("value").contains(SearchKeyword)) {
				login.Log4j.info("Result is loaded for searched keyword");
				CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 4).click();
				CommonFunctionality.Views_list();
			} else {

				Assert.fail("Result is not loaded for searched keyword");
			}
		}
	}

	@Then("^The total number of matches result should be displayed in below the find field$")
	public void the_total_number_of_matches_result_should_be_displayed_in_below_the_find_field() throws Throwable {
		WebElement NumOfMatches = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='find-and-replace--panel-matches']", 5);
		if (NumOfMatches.isDisplayed()) {
			login.Log4j.info(NumOfMatches.getText());
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 4).click();
			CommonFunctionality.Views_list();
		} else {
			Assert.fail("The total number of matches result is not displayedd");
		}
	}

	@And("^Enter keyword you want to replace with$")
	public void enter_keyword_you_want_to_replace_with() throws Throwable {
		ReplaceKeyword = "GDP";
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(@class,'find-and-replace--panel-replace-input')]", 5)
				.sendKeys(ReplaceKeyword);
	}

	@And("^Click on Replace$")
	public void click_on_Replace() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='find-and-replace--panel-buttons']/*[1]", 5)
				.click();
	}

	@Then("^The keyword should be replaced for selected series$")
	public void the_keyword_should_be_replaced_for_selected_series() throws Throwable {
		CommonFunctionality.wait(1000);
		String ReplacedSeries = login.driver.findElement(By.xpath("//*[@class='find-and-replace-item--name']//input"))
				.getAttribute("value");
		login.Log4j.info(ReplacedSeries);
		if (ReplacedSeries.contains(ReplaceKeyword)) {
			login.Log4j.info("PASS");
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 4).click();
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='sphere-modal-controls']//button[contains(text(),'Ok')]", 5).click();
			CommonFunctionality.Views_list();
		} else {
			Assert.fail("Verification is failed");
		}
	}

	@Then("^All the available series should be replaced with the keyword$")
	public void all_the_available_series_should_be_replaced_with_the_keyword() throws Throwable {
		the_keyword_should_be_replaced_for_selected_series();
	}

	@Then("^By default \"([^\"]*)\" should be selected in Edit series info dropdown$")
	public void by_default_should_be_selected_in_Edit_series_info_dropdown(String arg1) throws Throwable {
		String Expectedstr = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='find-and-replace--attribute-selector']//option[@value='name']", 6).getText();
		login.Log4j.info(Expectedstr.trim());
		if (arg1.equals(Expectedstr.trim())) {
			login.Log4j.info("By default " + arg1 + " is selected");
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 4).click();
			CommonFunctionality.Views_list();
		} else {
			Assert.fail("Verification is failed");
		}
	}

	@And("^Click on Edit series info dropdown$")
	public void click_on_Edit_series_info_dropdown() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='find-and-replace--attribute-selector']", 7)
				.click();
	}

	@Then("^Series should be displayed by name$")
	public void series_should_be_displayed_by_name() throws Throwable {
		ValidateEditSeriesFunctionality();

	}

	@Then("^The series should be displayed by function description$")
	public void the_series_should_be_displayed_by_function_description() throws Throwable {
		ValidateEditSeriesFunctionality();

	}

	@Then("^Empty row should be dispalyed$")
	public void empty_row_should_be_dispalyed() throws Throwable {
		CommonFunctionality.wait(1000);
		Boolean functionDescription = login.driver
				.findElement(By.xpath("//*[@class='find-and-replace-item--name']//input")).getAttribute("value")
				.isEmpty();
		login.Log4j.info(functionDescription);
		if (functionDescription == true) {
			login.Log4j.info("Empty result is displayed ");
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 4).click();
			CommonFunctionality.Views_list();
		} else {
			Assert.fail("Result is dispalyed for function description by without applying function");

		}
	}

	@And("^Add function description$")
	public void add_function_description() throws Throwable {
		AddFunction = "YTD";
		BeforeEditSeriesInfo(AddFunction);
		/*
		 * BeforeAddingFunction = CommonFunctionality.getElementByXpath(login.driver,
		 * "//*[@class='find-and-replace-item--name']//input", 5).getAttribute("value");
		 * CommonFunctionality.getElementByXpath(login.driver,
		 * "//*[@class='find-and-replace-item--name']//input", 5).clear();
		 * CommonFunctionality.getElementByXpath(login.driver,
		 * "//*[@class='find-and-replace-item--name']//input", 5).sendKeys("YTD");
		 */
	}

	@Then("^Should allowed to add function discription and should be updated in edit series panel$")
	public void should_allowed_to_add_function_discription_and_should_be_updated_in_edit_series_panel()
			throws Throwable {
		ValidateEditSeriesFunctionality();

	}

	@And("^Edit function description$")
	public void edit_function_description() throws Throwable {
		// BeforeEditingFunction = CommonFunctionality.getElementByXpath(login.driver,
		// "//*[@class='find-and-replace-item--name']//input", 5).getAttribute("value");
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='find-and-replace-item--name']//input", 5)
				.clear();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='find-and-replace-item--name']//input", 5)
				.sendKeys("%CHANGE");
	}

	@Then("^Should allowed to edit function discription and should be updated in edit series panel$")
	public void should_allowed_to_edit_function_discription_and_should_be_updated_in_edit_series_panel()
			throws Throwable {
		ValidateEditSeriesFunctionality();

	}

	@And("^Click on '>' icon$")
	public void click_on_icon() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Apply original title']/*[1]", 7).click();
	}

	@Then("^The SSP window should be displayed$")
	public void the_SSP_window_should_be_displayed() throws Throwable {
		WebElement SSP_window = CommonFunctionality.getElementByXpath(login.driver,
				"(//*[@class='movable-modal--window ui-resizable ui-draggable'])[2]", 5);

		if (SSP_window.isDisplayed()) {
			CommonFunctionality.getElementByXpath(login.driver,
					"(//div[@class='movable-modal--window ui-resizable ui-draggable'])[2]//*[@class='movable-modal--close']",
					5).click();
			login.Log4j.info("The SSP window is displayed");
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 4).click();
			CommonFunctionality.Views_list();
		} else {
			Assert.fail("The SSP window is not displayed");
		}
	}

	@And("^Edit series title$")
	public void edit_series_title() throws Throwable {
		EditSeriesName = "No of Passengers";
		BeforeEditSeriesInfo(EditSeriesName);

	}

	@Then("^Should able to edit the insight title and updated in visual series$")
	public void should_able_to_edit_the_insight_title_and_updated_in_visual_series() throws Throwable {
		SeriesByEditSeriesInfo(EditSeriesName);

	}

	@Then("^Series should be displayed by Region$")
	public void series_should_be_displayed_by_Region() throws Throwable {
		String ExpectedRegion = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='find-and-replace-item--name']//input", 5)
				.getAttribute("value");
		SeriesByEditSeriesInfo(ExpectedRegion);
	}

	@And("^Edit series region$")
	public void edit_series_region() throws Throwable {
		EditRegion = "Israel";
		BeforeEditSeriesInfo(EditRegion);
	}

	@And("^Click on '>' icon for original titles to all series$")
	public void click_on_icon_for_original_titles_to_all_series() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Apply original titles to all series']/*[1]", 4)
				.click();
	}

	@Then("^The region should be renamed for the series$")
	public void the_region_should_be_renamed_for_the_series() throws Throwable {
		SeriesByEditSeriesInfo(EditRegion);

	}

	@And("^Edit series unit$")
	public void edit_series_unit() throws Throwable {
		EditUnit = "Km";
		BeforeEditSeriesInfo(EditUnit);
	}

	@Then("^Should able to edit series unit and updated in visual series as per the changes$")
	public void should_able_to_edit_series_unit_and_updated_in_visual_series_as_per_the_changes() throws Throwable {
		SeriesByEditSeriesInfo(EditUnit);
	}

	@And("^Edit series frequency$")
	public void edit_series_frequency() throws Throwable {
		EditFrequency = "Monthly";
		BeforeEditSeriesInfo(EditFrequency);
	}

	@Then("^Should able to edit series frequency and updated in visual series as per the changes$")
	public void should_able_to_edit_series_frequency_and_updated_in_visual_series_as_per_the_changes()
			throws Throwable {
		ValidateEditSeriesFunctionality();
	}

	@Then("^The changes should be revert to original series \"([^\"]*)\"$")
	public void the_changes_should_be_revert_to_original_series(String arg1) throws Throwable {
		OriginalSeriesInfo(BeforeEditSeries);
	}

	@Then("^All the changes should be revert back with original \"([^\"]*)\"$")
	public void all_the_changes_should_be_revert_back_with_original(String arg1) throws Throwable {
		OriginalSeriesInfo(BeforeEditSeries);
	}

	@Then("^Check box should be checked by default for auto name$")
	public void check_box_should_be_checked_by_default_for_auto_name() throws Throwable {
		CommonFunctionality.wait(1000);
		Boolean AutoName_checkBox = login.driver
				.findElement(By.xpath("//*[text()='Auto name']/preceding-sibling::input")).isSelected();
		if (AutoName_checkBox == true) {
			login.Log4j.info("Auto name check box is selected by default");
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 6).click();
			CommonFunctionality.Views_list();
		} else {
			Assert.fail("Auto name check box is not selected by default");
		}
	}

	@And("^Select multiple attributes$")
	public void select_multiple_attributes() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='multi-select-config']//ul//li[@class='select2-search-field']", 5).click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//ul[@class='select2-results']//div[contains(text(),'Region')]", 4)
				.click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='multi-select-config']//ul//li[@class='select2-search-field']", 5).click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//ul[@class='select2-results']//div[contains(text(),'Unit')]", 4)
				.click();

	}

	@Then("^Selected attributes should be displayed as series name$")
	public void selected_attributes_should_be_displayed_as_series_name() throws Throwable {
		String RegionAttribute = CommonFunctionality
				.getElementByXpath(login.driver,
						"//div[@class='visual-series-panel--series']//div[@class='table']/*[6]/*[2]/*", 6)
				.getAttribute("title");
		String UnitAttribute = CommonFunctionality
				.getElementByXpath(login.driver,
						"//div[@class='visual-series-panel--series']//div[@class='table']/*[7]/*[2]/*", 6)
				.getAttribute("title");
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 6).click();
		String Series = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='visual-series-name']//*[@class='series-name--title']", 5)
				.getText();
		if (Series.contains(RegionAttribute) && Series.contains(UnitAttribute)) {
			login.Log4j.info(RegionAttribute + " AND " + UnitAttribute + " is displayed in seres name " + Series);
			CommonFunctionality.Views_list();
		} else {
			Assert.fail("Verification is failed");
		}
	}

	@Then("^The Popup should be minimized$")
	public void the_Popup_should_be_minimized() throws Throwable {
		String Maximize = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='movable-modal--header']/*[2]/*[1]", 5)
				.getAttribute("title");
		RenamePopup(DatabasesTab.MinimizeVar, Maximize);
	}

	@Then("^The popup should be maximized$")
	public void the_popup_should_be_maximized() throws Throwable {
		String Minimize = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='movable-modal--header']/*[2]/*[1]", 5)
				.getAttribute("title");
		RenamePopup(DatabasesTab.MaximizeVar, Minimize);
	}

	@Then("^The popup should be displayed in full screen$")
	public void the_popup_should_be_displayed_in_full_screen() throws Throwable {
		String Exit_full_screen = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='movable-modal--header']/*[2]/*[2]", 5)
				.getAttribute("title");
		RenamePopup(DatabasesTab.FullScreenVar, Exit_full_screen);
	}

	@Then("^The popup should be displayed in normal screen$")
	public void the_popup_should_be_displayed_in_normal_screen() throws Throwable {
		String full_screen = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='movable-modal--header']/*[2]/*[2]", 5)
				.getAttribute("title");
		RenamePopup(DatabasesTab.Exit_fullScreen, full_screen);
	}

	@And("^Click on Cancel button$")
	public void click_on_Cancel_button() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='movable-modal--window ui-resizable ui-draggable']//*[@class='movable-modal--close']", 6)
				.click();
	}

	@Then("^The rename popup should be closed$")
	public void the_rename_popup_should_be_closed() throws Throwable {
		CloseIconValidation();
		/*
		 * if(login.driver.findElements(By.
		 * xpath("//*[@class='movable-modal--window ui-resizable ui-draggable']")).size(
		 * ) == 0) { login.Log4j.info("The popup is closed");
		 * CommonFunctionality.Views_list(); } else {
		 * Assert.fail("The popup is not closed"); }
		 */
	}

	@And("^Press Ctrl\\+H on keyboard$")
	public void press_Ctrl_H_on_keyboard() throws Throwable {
		CommonFunctionality.wait(500);
		Actions action = new Actions(login.driver);
		action.keyDown(Keys.CONTROL).sendKeys("h").keyUp(Keys.CONTROL).perform();
	}

	@Then("^Rename popup should be displayed$")
	public void rename_popup_should_be_displayed() throws Throwable {
		CommonFunctionality.wait(1500);
		Boolean RenamePopUp = login.driver
				.findElement(By.xpath("//*[@class='movable-modal--window ui-resizable ui-draggable']")).isDisplayed();
		if (RenamePopUp == true) {
			login.Log4j.info("Rename popup is displayed");
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[@class='movable-modal--window ui-resizable ui-draggable']//*[@title='Close']", 6)
					.click();
			CommonFunctionality.Views_list();
		} else {
			Assert.fail("Rename popUp is not displayed");
		}
	}

	@And("^Create a histogram visual with series$")
	public void create_a_histogram_visual_with_series() throws Throwable {
		create_a_Histogram_visual_without_selecting_series();
		CommonFunctionality.ResetMethod();
		CommonFunctionality.getElementByProperty(login.driver, "Search", 5).sendKeys("390384757");
		CommonFunctionality.getElementByProperty(login.driver, "Series", 5).click();
		CommonFunctionality.wait(1000);
		SeriesCount = login.driver.findElement(By.xpath("//*[@class='series-series-count--number']"));
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='add-to-data-selection--icon']", 6).click();
	}

	@And("^Choose any function from Currency conversation$")
	public void choose_any_function_from_Currency_conversation() throws Throwable {
		CurrencyFunction = "CONVERTCUR";
		FunctionSelection(CurrencyFunction);
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='suggestions_list select-list']//li[@data-id='CURRCONV']", 6).click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='suggestions_list select-list']//li[@data-id='USD']", 6)
				.click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='suggestions_list select-list']//li[@data-id='TH']", 6)
				.click();
		getAppliedFunction();
	}

	@Then("^Selected currency should be applied to all series$")
	public void selected_currency_should_be_applied_to_all_series() throws Throwable {
		FunctionVerification(Applied_function);
	}

	@And("^Choose any function from Calculate change$")
	public void choose_any_function_from_Calculate_change() throws Throwable {
		ChangeFunction = "%CHANGE";
		FunctionSelection(ChangeFunction);
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='suggestions_list select-list']//li[@data-id='CHANGE']", 6)
				.click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='suggestions_list select-list']//li[@data-id='over_year']", 6).click();
		getAppliedFunction();
	}

	@Then("^Selected function should be applied to all series$")
	public void selected_function_should_be_applied_to_all_series() throws Throwable {
		FunctionVerification(Applied_function);
	}

	@And("^Click on Aggregate and choose any option$")
	public void click_on_Aggregate_and_choose_any_option() throws Throwable {
		AggregateFunction = "AGGREGATE";
		FunctionSelection(AggregateFunction);
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='suggestions_list select-list']//li[@data-id='AGGREGATE']", 6).click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='suggestions_list select-list']//li[@data-id='YEARLY']", 6)
				.click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='suggestions_list select-list']//li[@data-id='1']", 6)
				.click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='suggestions_list select-list']//li[@data-id='Sum']", 6)
				.click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='suggestions_list select-list']//li[@data-id='1']", 6)
				.click();
		getAppliedFunction();
	}

	@And("^Click on Accumulate and choose any option$")
	public void click_on_Accumulate_and_choose_any_option() throws Throwable {
		AccumulateFunction = "ACCUMULATE";
		FunctionSelection(AccumulateFunction);
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='suggestions_list select-list']//li[@data-id='ACCSER']", 6)
				.click();
		getAppliedFunction();
	}

	@And("^Click on FX More dropdown and Choose any function$")
	public void click_on_FX_More_dropdown_and_Choose_any_function() throws Throwable {
		CurrencyFunction = "RMB";
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@title='More']//*[contains(@class,'insight-action-panel--btn-popup')]", 8).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@data-id='" + CurrencyFunction + "']", 8).click();
	}

	@Then("^Selected function should display in series$")
	public void selected_function_should_display_in_series() throws Throwable {
		FunctionVerification(CurrencyFunction);
	}

	@And("^Click on FX icon$")
	public void click_on_FX_icon() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='visual-series-panel--function-editor']//*[@class='function-editor-window--icon']", 8)
				.click();
	}

	@And("^Click on x icon for a series$")
	public void click_on_x_icon_for_a_series() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='table']//*[contains(@class,'visual-series-list--remove-row')]//*[@title='Delete series']",
				8).click();
	}

	@Then("^The series should be removed from the visual and edit series panel$")
	public void the_series_should_be_removed_from_the_visual_and_edit_series_panel() throws Throwable {
		CommonFunctionality.wait(700);
		// series removed from edit series panel
		if (login.driver.findElements(By.xpath("//*[@class='series-name--title']")).size() == 0) {
			// series removed from the visual
			// Compare visual text before delete series and after delete series
			String AfterDeleteSeries = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='title']", 6)
					.getText();
			if (!Visual_Title_txt.equals(AfterDeleteSeries)) {
				login.Log4j.info("The series is removed from the visual and edit series panel");
				CommonFunctionality.Views_list();
			} else {
				Assert.fail("The series is not removed from the visual and edit series panel");
			}

		}
	}

	@Then("^SSP popup should be displayed$")
	public void ssp_popup_should_be_displayed() throws Throwable {
		CommonFunctionality.wait(1000);
		Boolean ssp_window = login.driver
				.findElement(By.xpath("//*[@class='movable-modal--window ui-resizable ui-draggable']")).isDisplayed();
		if (ssp_window == true) {
			login.Log4j.info("SSP popup is displayed");
			//Close SSP window
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'movable-modal__active')]//*[@class='movable-modal--close']", 8).click();
			try {
				//Close Edit Histogram window
				CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 8).click();
			} catch(Exception e) {
				
			}
			CommonFunctionality.Views_list();
		} else {
			Assert.fail("SSP window is not displayed");
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Click on rename series icon$")
	public void click_on_rename_series_icon() throws Throwable {
		WebElement sname = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-name--title']", 6);
		new Actions(login.driver).pause(500).moveToElement(sname).build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Rename series']", 6).click();
	}

	@Then("^Rename popup should be displayed for selected series$")
	public void rename_popup_should_be_displayed_for_selected_series() throws Throwable {
		String Rename_popup = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='movable-modal--window ui-resizable ui-draggable']//*[@class='find-and-replace--modal-title']",
				8).getText();
		if (Rename_popup.contains("Rename")) {
			login.Log4j.info("Rename popup is displayed");
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 8).click();
			CommonFunctionality.Views_list();

		} else {
			Assert.fail("Rename popup is not displayed");
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Click on edit series icon$")
	public void click_on_edit_series_icon() throws Throwable {
		WebElement sname = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-name--title']", 10);
		new Actions(login.driver).pause(500).moveToElement(sname).build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Edit series']", 8).click();
	}

	@And("^Select Frequency$")
	public void select_Frequency() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//ul//li//*[contains(text(),'Frequency')]", 6).click();
		function = CommonFunctionality
				.getElementByXpath(login.driver, "//ul[@class='dropdown-menu']//li//span[@title='Yearly (Sum)']", 6)
				.getText();
		CommonFunctionality
				.getElementByXpath(login.driver, "//ul[@class='dropdown-menu']//li//span[@title='Yearly (Sum)']", 6)
				.click();
	}

	@Then("^Selected function should be applied to the series$")
	public void selected_function_should_be_applied_to_the_series() throws Throwable {
		String[] expectedFunction = function.split("\\(");
		login.Log4j.info(expectedFunction[0].trim());
		login.Log4j.info(expectedFunction[1].replaceAll("\\)", ""));
		FunctionVerification(expectedFunction[0].trim(), expectedFunction[1].replaceAll("\\)", ""));

	}

	@Then("^Selected change function should be applied to the series$")
	public void selected_change_function_should_be_applied_to_the_series() throws Throwable {
		String str = "Over Year";
		try {
			FunctionVerification(db.Change.toUpperCase(), str);
		} catch (Exception e) {
			//TC_Histogram_187
			FunctionVerification(EditSeries_function.toUpperCase(), str);
		}

	}

	@Then("^Selected currency function should be applied to the series$")
	public void selected_currency_function_should_be_applied_to_the_series() throws Throwable {
		FunctionVerification(db.Applied_currency);

	}

	@And("^Select \"([^\"]*)\" frequency from drop down$")
	public void select_frequency_from_drop_down(String arg1) throws Throwable {
		DailyFrequency = arg1;
		CommonFunctionality.getElementByXpath(login.driver, "//*[@name='frequency']", 8).click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@name='frequency']//option[contains(text(),'" + arg1 + "')]", 8)
				.click();

	}

	@Then("^The selected frequency should be applied to available series$")
	public void the_selected_frequency_should_be_applied_to_available_series() throws Throwable {
		FunctionVerification(DailyFrequency);
	}

	@And("^Select \"([^\"]*)\" from Missing values method$")
	public void select_from_Missing_values_method(String arg1) throws Throwable {
		MissingValueMethod = arg1;
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[@class='series-data-conversion--function-item form--label']//*[@name='missing_values']", 8)
				.click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@name='missing_values']//option[contains(text(),'" + arg1 + "')]", 8).click();

	}

	@Then("^Missing values method should be applied with selected frequency$")
	public void missing_values_method_should_be_applied_with_selected_frequency() throws Throwable {

		FunctionVerification(MissingValueMethod, DailyFrequency);
	}

	@Then("^The popup should be closed for close icon$")
	public void the_popup_should_be_closed_for_close_icon() throws Throwable {
		CloseIconValidation();
	}

	@And("^Click on frequency dropdown in series level$")
	public void click_on_frequency_dropdown_in_series_level() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"(//*[contains(@class,'table--body-cell')]/child::*[@class='change-series-function']//following-sibling::*[@class='insight-action-panel--btn-title'])[1]/following::div[1]",
				12).click();
	}

	@And("^Select \"([^\"]*)\" from frequency dropdown$")
	public void select_from_frequency_dropdown(String arg1) throws Throwable {
		function = arg1;
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='items-wrapper']//li//span[contains(text(),'" + arg1 + "')]", 8).click();
	}

	@Then("^Selected frequency should be applied to ONLY selected series$")
	public void selected_frequency_should_be_applied_to_ONLY_selected_series() throws Throwable {
		String[] expectedFunction = function.split("\\(");
		String str1 = expectedFunction[0].trim();
		String str2 = expectedFunction[1].replaceAll("\\)", "");
		FunctionVerification(str1, str2);
	}

	@And("^Click on currency dropdown in series level$")
	public void click_on_currency_dropdown_in_series_level() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"(//*[contains(@class,'table--body-cell')]/child::*[@class='change-series-function']//following-sibling::*[@class='insight-action-panel--btn-title'])[2]/following::div[1]",
				10).click();
	}

	@And("^Select \"([^\"]*)\" from currency dropdown$")
	public void select_from_currency_dropdown(String arg1) throws Throwable {
		CurrencyFunction = arg1;
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='items-wrapper']//li//span[contains(text(),'" + arg1 + "')]", 8).click();
	}

	@Then("^Selected currency should be applied to ONLY selected series$")
	public void selected_currency_should_be_applied_to_ONLY_selected_series() throws Throwable {
		FunctionVerification(CurrencyFunction);
	}

	@And("^Click on \"([^\"]*)\" field in series level$")
	public void click_on_field_in_series_level(String arg1) throws Throwable {
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='table']//input[@placeholder='" + arg1 + "']", 10).click();
	}

	@And("^Select \"([^\"]*)\" function$")
	public void select_function(String arg1) throws Throwable {
		function = arg1;
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='suggestions_list select-list']//li[contains(text(),'" + arg1 + "')]", 8).click();
	}

	@Then("^Selected function should applied to the series$")
	public void selected_function_should_applied_to_the_series() throws Throwable {
		FunctionVerification(function);
	}

	@And("^Select multiple functions \"([^\"]*)\"  and \"([^\"]*)\"$")
	public void select_multiple_functions_and(String arg1, String arg2) throws Throwable {
		function = arg1;
		function1 = arg2;
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='suggestions_list select-list']//li[contains(text(),'" + arg1 + "')]", 8).click();
		click_on_field_in_series_level("Type a function");
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='suggestions_list select-list']//li[contains(text(),'" + arg2 + "')]", 8).click();

	}

	@Then("^The Selected functions should applied to the series$")
	public void the_Selected_functions_should_applied_to_the_series() throws Throwable {
		FunctionVerification(function, function1);

	}

	@And("^Click on x icon to remove the function$")
	public void click_on_x_icon_to_remove_the_function() throws Throwable {
		CommonFunctionality.wait(1000);
		WebElement ele = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='table']//*[@class='series-function-item--remove-icon']", 8);
		CommonFunctionality.wait(500);
		jse.executeScript("arguments[0].scrollIntoView(true);", ele);
		ele.click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='series-functions series-functions__has-functions-to-apply']//*[@class='series-functions-panel--icon series-functions-panel--icon__apply']",
				6).click();
	}

	@Then("^The function should be removed from the series$")
	public void the_function_should_be_removed_from_the_series() throws Throwable {
		CommonFunctionality.wait(1000);
		String Series = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='visual-series-name']//*[@class='series-name--title']", 8)
				.getText();
		if (!Series.contains(function)) {
			login.Log4j.info("The function is removed from the series");
			CommonFunctionality.Views_list();
		} else {
			Assert.fail("The funcion is not removed from the series");
		}

	}

	@Then("^The applied function should be displayed on the toolbar$")
	public void the_applied_function_should_be_displayed_on_the_toolbar() throws Throwable {
		String Function_toolbar = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='visual-series-panel--function-editor']//*[@class='functions-input-container']//*[@class='series-function-item--name']",
				8).getText();
		if (Function_toolbar.equals(function)) {
			login.Log4j.info("The applied function is displayed on the toolbar");
			CommonFunctionality.Views_list();
		} else {
			Assert.fail("The applied function is not displayed on the toolbar");
		}
	}

	@And("^Select an invalid function for the series$")
	public void select_an_invalid_function_for_the_series() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='suggestions_list select-list']//li[contains(text(),'WTD')]", 8).click();
		CommonFunctionality.getElementByXpath(login.driver, "//ul//li[@data-id='sum']", 8).click();
		CommonFunctionality.getElementByXpath(login.driver, "//ul//li[@data-id='1']", 8).click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='series-functions series-functions__has-functions-to-apply']//*[@class='series-functions-panel--icon series-functions-panel--icon__apply']",
				6).click();
	}

	@Then("^\"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\" fields should be available for respective series$")
	public void and_fields_should_be_available_for_respective_series(String arg1, String arg2, String arg3)
			throws Throwable {
		CommonFunctionality.wait(1500);
		Boolean Region = login.driver.findElement(By.xpath("(//*[contains(@class,'table--column__auto-width')])[5]"))
				.isDisplayed();
		Boolean Unit = login.driver.findElement(By.xpath("(//*[contains(@class,'table--column__auto-width')])[6]"))
				.isDisplayed();
		Boolean SeriesID = login.driver.findElement(By.xpath("(//*[contains(@class,'table--column__auto-width')])[7]"))
				.isDisplayed();
		if (Region == true && Unit == true && SeriesID == true) {
			login.Log4j.info(arg1 + "," + arg2 + " AND " + arg3 + " fields are available for respective series");
			CommonFunctionality.Views_list();
		} else {
			Assert.fail("Verification failed");
		}
	}

	@Then("^User should redirect to \"([^\"]*)\" tab$")
	public void user_should_redirect_to_tab(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		Boolean AddFromMySeries = login.driver
				.findElement(By.xpath("//*[@class='sidebar-panel--tab sidebar-panel--tab__active']")).isDisplayed();
		if (AddFromMySeries == true) {
			String str = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='sidebar-panel--tab sidebar-panel--tab__active']//*[@class='sidebar-panel--tab-name']",
					6).getText();
			if (arg1.contains(str)) {
				login.Log4j.info("Redirected to " + arg1 + " tab");
				CommonFunctionality.Views_list();
			} else {
				Assert.fail("Verification failed");
			}
		}

	}

	@And("^Mouse hover on visual title$")
	public void mouse_hover_on_visual_title() throws Throwable {
		CommonFunctionality.wait(1000);
		WebElement ele = login.driver.findElement(By.xpath("//*[@data-name='title']"));
		new Actions(login.driver).moveToElement(ele).build().perform();
	}

	@And("^Click on edit icon$")
	public void click_on_edit_icon() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Edit visual title']", 6).click();
	}
	@And("^Mouse hover on visual title for Edit visual popup$")
	public void mouse_hover_on_visual_title_for_Edit_visual_popup() throws Throwable {
		CommonFunctionality.wait(1000);
		WebElement ele = login.driver.findElement(By.xpath("(//*[@data-name='title'])[2]"));
		new Actions(login.driver).moveToElement(ele).build().perform();
	}

	@And("^Click on edit icon for Edit visual popup$")
	public void click_on_edit_icon_for_Edit_visual_popup() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "(//*[@title='Edit visual title'])[2]", 6).click();
	}

	@And("^Double click on the visual title$")
	public void double_click_on_the_visual_title() throws Throwable {
		WebElement title = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='title']", 4);
		new Actions(login.driver).pause(300).doubleClick(title).build().perform();
	}

	@Then("^Visual legend \"([^\"]*)\" and \"([^\"]*)\" should be displayed$")
	public void visual_legend_and_should_be_displayed(String arg1, String arg2) throws Throwable {
		String series = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='highcharts-legend']/*[2]/*/*[1]/*[3]/*", 6).getText();
		String histogram = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='highcharts-legend']/*[2]/*/*[2]/*/*", 6).getText();
		if (arg1.equalsIgnoreCase(series) && arg2.equalsIgnoreCase(histogram)) {
			login.Log4j.info("Visual legend " + arg1 + " AND " + arg2 + " is displayed");
			CommonFunctionality.Views_list();
		} else {
			Assert.fail(arg1 + " AND " + arg2 + " is not displayed");
		}
	}

	@And("^Click on series legend$")
	public void click_on_series_legend() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='highcharts-legend']/*[2]/*/*[1]/*[3]/*", 6)
				.click();
	}

	@Then("^Series data should be hidden from the visual$")
	public void series_data_should_be_hidden_from_the_visual() throws Throwable {
		WebElement SeriesEle = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='highcharts-legend']/*[2]/*/*[1]", 6);
		if (SeriesEle.getAttribute("class").contains("highcharts-legend-item-hidden")) {
			login.Log4j.info("Series data is hidden from the visual");
			CommonFunctionality.Views_list();
		} else {
			Assert.fail("Series data is not hidden");
		}
	}

	@And("^Click on Histogram legend$")
	public void click_on_Histogram_legend() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='highcharts-legend']/*[2]/*/*[2]/*/*", 6)
				.click();
	}

	@Then("^The Histogram data should be hidden from visual$")
	public void the_Histogram_data_should_be_hidden_from_visual() throws Throwable {
		WebElement HistogramEle = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='highcharts-legend']/*[2]/*/*[2]", 6);
		if (HistogramEle.getAttribute("class").contains("highcharts-legend-item-hidden")) {
			login.Log4j.info("The histogram data is hidden from the visual");
			CommonFunctionality.Views_list();
		} else {
			Assert.fail("The Histogram data is not hidden");
		}
	}

	@And("^Again click on the same$")
	public void again_click_on_the_same() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='highcharts-legend']/*[2]/*/*[1]/*[3]/*", 6)
				.click();
	}

	@Then("^The legend should be enabled$")
	public void the_legend_should_be_enabled() throws Throwable {
		CommonFunctionality.wait(800);
		Boolean legend = login.driver.findElement(By.xpath("//*[@class='highcharts-legend']/*[2]/*/*[1]/*[3]/*"))
				.isEnabled();
		if (legend == true) {
			login.Log4j.info("The legend is enabled");
			CommonFunctionality.Views_list();
		} else {
			Assert.fail("The legend is not enabled");
		}
	}

	@And("^Make any changes$")
	public void make_any_changes() throws Throwable {
		CommonFunctionality.wait(1000);
		// unselect check box for show option
		Boolean isChecked = login.driver
				.findElement(By.xpath(
						"//div[@class='base-config--row-control base-config--show-control']//input[@type='checkbox']"))
				.isSelected();
		if (isChecked == true) {
			new Actions(login.driver).moveToElement(login.driver.findElement(By.xpath(
					"//div[@class='base-config--row-control base-config--show-control']//span[@class='input-control--indicator']")))
					.click().perform();
		} else {
			Assert.fail("Show check box is not selected");
		}
	}

	@And("^Click on create template icon$")
	public void click_on_create_template_icon() throws Throwable {
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='add-style-template add-style-template__active']", 10)
				.click();
	}

	@And("^Enter new template name as \"([^\"]*)\"$")
	public void enter_new_template_name_as(String NewTemplate) throws Throwable {
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//input[@class='add-template-context--input form--control form--control__sm']", 10)
				.sendKeys(NewTemplate);

	}

	@And("^Click on green tick mark$")
	public void click_on_green_tick_mark() throws Throwable {
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(@class,'add-template-context--icon__apply')]", 10)
				.click();
	}

	@Then("^New template should be created with the name of \"([^\"]*)\"$")
	public void new_template_should_be_created_with_the_name_of(String CreatedTemplate) throws Throwable {
		String actualTemplateName = CommonFunctionality
				.getElementByXpath(login.driver,
						"//div[@class='style-templates-item--icon style-templates-item--icon__text']", 10)
				.getAttribute("title");
		Assert.assertEquals(actualTemplateName, CreatedTemplate);
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//button[@class='sphere-modal-control button button__primary']", 10)
				.click();
		CommonFunctionality.Views_list();
	}

	@And("^Click on x icon in the template popup$")
	public void click_on_x_icon_in_the_template_popup() throws Throwable {
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(@class,'add-template-context--icon__close')]", 10)
				.click();
	}

	@Then("^The template popup should closed$")
	public void the_template_popup_should_closed() throws Throwable {
		if (login.driver.findElements(By.xpath("//ul[contains(@class,'dropdown-menu context-menu')]")).size() == 0) {
			login.Log4j.info("The template popup is closed");
		} else {
			Assert.fail("The template popup is not closed");
		}
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//button[@class='sphere-modal-control button button__primary']", 10)
				.click();
		CommonFunctionality.Views_list();
	}

	@And("^Click on dropdown for template$")
	public void click_on_dropdown_for_template() throws Throwable {
		WebElement dropDown = CommonFunctionality.getElementByXpath(login.driver,
				"//div[contains(@class,'context-menu-control__clean context-menu-control__icon')]//div[@class='context-menu-control--icon']",
				10);
		new Actions(login.driver).moveToElement(dropDown).click().perform();
	}

	@Then("^The following templates should be available$")
	public void the_following_templates_should_be_available(List<String> list) throws Throwable {
		System.out.println(list);
		for (String styles : list) {
			if (styles.equals("CEIC Styles")) {
				if (login.driver.findElement(By.xpath(
						"//div[@class='style-templates-context--section-items style-templates-context--section-items__row']//img[@class='style-templates-item--icon']"))
						.isDisplayed()) {
					login.Log4j.info("CEIC style template is available");
				} else {
					Assert.fail("CEIC Style template is not available");
				}
			} else if (styles.equals("My Styles")) {
				if (login.driver.findElement(By.xpath(
						"//ul[@class='dropdown-menu context-menu ']//*[@class='style-templates-item--icon style-templates-item--icon__text']"))
						.isDisplayed()) {
					login.Log4j.info("My style template is available");
				} else {
					Assert.fail("My Style template is not available");
				}
			}
		}
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		CommonFunctionality.Views_list();
	}

	@Then("^The description should be \"([^\"]*)\" diaplayed$")
	public void the_description_should_be_diaplayed(String discription) throws Throwable {
		CommonFunctionality.wait(1000);
		Assert.assertEquals(login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']"))
				.getText().contains(discription), true);
		// Close confirmation popup
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 10).click();
		// Close Edit visual window
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		CommonFunctionality.Views_list();
	}

	@Then("^The template should be deleted from the list$")
	public void the_template_should_be_deleted_from_the_list() throws Throwable {
		if (login.driver
				.findElements(By.xpath("//div[@class='style-templates-item--icon style-templates-item--icon__text']"))
				.size() == 0) {
			login.Log4j.info("The template is deleted by clicking on OK button");
		} else {
			Assert.fail("The template is not deleted by clicking on OK button");
		}
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		CommonFunctionality.Views_list();

	}

	@Then("^The confirmation popup should be closed$")
	public void the_confirmation_popup_should_be_closed() throws Throwable {
		if (login.driver.findElements(By.xpath("//div[@class='modal-content sphere-modal__content']")).size() == 0) {
			login.Log4j.info("The confirmation popup is closed by clicking on Cancel button");
		} else {
			Assert.fail("The confirmation popup is not closed by clicking on Cancel button");
		}
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		CommonFunctionality.Views_list();
	}

	@And("^Click on Border drop down$")
	public void click_on_Border_drop_down() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='style-container--controls']//div[2]//div[2]//div[1]//div[2]", 8).click();
	}

	@And("^Check Histogram$")
	public void check_Histogram() throws Throwable {
		WebElement Histogram_checkbox = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='border-control']/*/*[1]//label//span[1]", 10);
		new Actions(login.driver).moveToElement(Histogram_checkbox).click().perform();
	}

	@And("^Select color for Histogram$")
	public void select_color_for_Histogram() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='color-picker-control']//div[@class='sp-preview-inner']", 6).click();
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath",
				"(//*[@class='sp-palette-container']//*[@title='#fda546'])[1]");
	}

	@Then("^Border should be displayed for histogram with selected color$")
	public void border_should_be_displayed_for_histogram_with_selected_color() throws Throwable {
		CommonFunctionality.wait(1000);
		String border_color = CommonFunctionality
				.getElementByXpath(login.driver, "(//*[@class='highcharts-plot-border'])[5]", 6).getCssValue("stroke");
		comm.ColorValidation(border_color);
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 6).click();
		CommonFunctionality.Views_list();
	}

	@And("^Select Width to (\\d+)$")
	public void select_Width_to(int width) throws Throwable {
		//String BorderWidth;
		String BorderWidth = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='spinner-control']//*[contains(@name,'border_width')]", 6)
				.getAttribute("aria-valuenow");
		/*try {
			// histogram width
			BorderWidth = CommonFunctionality.getElementByXpath(login.driver, "//*[@name='plot_area_border_width']", 6)
					.getAttribute("aria-valuenow");
		} catch (Exception e) {
			// visual width
//			BorderWidth = CommonFunctionality
//					.getElementByXpath(login.driver, "//*[@name='visual_area_border_width']", 6)
//					.getAttribute("aria-valuenow");
			BorderWidth = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='spinner-control']//*[contains(@name,'border_width')]", 6)
					.getAttribute("aria-valuenow");
		}*/
		int length = width - Integer.parseInt(BorderWidth);

		for (int i = 1; i <= length; i++) {
			Thread.sleep(500);
			login.driver.findElement(By.xpath(
					"(//*[@class='spinner-control']//*[contains(@class,'ui-spinner')]//button[contains(@class,'ui-spinner-up')])[1]"))
					.click();
		}
	}

	@Then("^The histogram border \"([^\"]*)\" should be updated to \"([^\"]*)\"$")
	public void the_histogram_border_should_be_updated_to(String arg1, String arg2) throws Throwable {
		Thread.sleep(2000);
		if (arg1.equals("Width")) {
			String ActualWidth;
			ActualWidth = login.driver
					.findElement(By.xpath("//*[@data-entity='histogram']//*[@class='highcharts-plot-border']"))
					.getCssValue("stroke-width");
			login.Log4j.info(ActualWidth);
			comm.FontSizeValidation(ActualWidth, arg2);
		}
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 6).click();
		CommonFunctionality.Views_list();
	}
	@Then("^The tooltp border width should be updated to \"([^\"]*)\"$")
	public void the_tooltp_border_width_should_be_updated_to(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		List<WebElement> timepoints = login.driver.findElements(By.xpath(
				"//*[contains(@class,'highcharts-markers highcharts-series-0 highcharts-scatter-series')]/*"));
		for (int i = 0; i <= timepoints.size(); i++) {
			new Actions(login.driver).moveToElement(timepoints.get(i)).pause(100).perform();
			String Tooltip_border_width = CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[@class='highcharts-label-box highcharts-tooltip-box']", 10)
					.getCssValue("stroke-width");
			login.Log4j.info(Tooltip_border_width);
			comm.FontSizeValidation(Tooltip_border_width, arg1);
			break;
		}
		CommonFunctionality.Views_list();
	}
		

	@And("^Uncheck Visual check box$")
	public void uncheck_Visual_check_box() throws Throwable {
		CommonFunctionality.wait(1000);
		Boolean checked = login.driver.findElement(By.xpath(
				"//ul[contains(@class,'dropdown-menu context-menu')]//div[2]//div[1]//div[1]//label[1]//span[1]"))
				.isSelected();
		if (checked == true) {
			// if it is checked then uncheck
			login.driver.findElement(By.xpath(
					"//ul[contains(@class,'dropdown-menu context-menu')]//div[2]//div[1]//div[1]//label[1]//span[1]"))
					.click();
		}
	}

	@Then("^Border should not be displayed for visual$")
	public void border_should_not_be_displayed_for_visual() throws Throwable {
		CommonFunctionality.wait(1000);
		if (!login.driver
				.findElement(By.xpath("//div[@class='visual-preview base-preview']//div[@class='visual-item-wrapper']"))
				.getAttribute("style").contains("border")) {
			login.Log4j.info("Visual border is not displayed by unchecking visual");
		} else {
			Assert.fail("Visual border is displayed by unchecking visual");
		}

		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		CommonFunctionality.Views_list();
	}

	@And("^Check Visual check box$")
	public void check_Visual_check_box() throws Throwable {
		CommonFunctionality.wait(1000);
		Boolean checked = login.driver.findElement(By.xpath(
				"//ul[contains(@class,'dropdown-menu context-menu')]//div[2]//div[1]//div[1]//label[1]//span[1]"))
				.isSelected();
		if (checked == false) {
			// if it is unchecked then check
			login.driver.findElement(By.xpath(
					"//ul[contains(@class,'dropdown-menu context-menu')]//div[2]//div[1]//div[1]//label[1]//span[1]"))
					.click();
		}
	}

	@Then("^Border should be displayed for visual$")
	public void border_should_be_displayed_for_visual() throws Throwable {
		CommonFunctionality.wait(1000);
		if (login.driver
				.findElement(By.xpath("//div[@class='visual-preview base-preview']//div[@class='visual-item-wrapper']"))
				.getAttribute("style").contains("border")) {
			login.Log4j.info("Visual border is displayed by checking visual");
		} else {
			Assert.fail("Visual border is not displayed by checking visual");
		}

		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 6).click();
		CommonFunctionality.Views_list();
	}

	@And("^Select color for Visual$")
	public void select_color_for_Visual() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='color-picker-control']//div[@class='sp-preview-inner']", 6).click();
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath",
				"(//*[@class='sp-palette-container']//*[@title='#fda546'])[2]");
	}

	@Then("^Border should be displayed for visual with selected color$")
	public void border_should_be_displayed_for_visual_with_selected_color() throws Throwable {
		CommonFunctionality.wait(2000);
		String border_color = CommonFunctionality
				.getElementByXpath(login.driver,
						"//div[@class='visual-preview base-preview']//div[@class='visual-item-wrapper']", 6)
				.getCssValue("border");
		login.Log4j.info(border_color);
		String[] str = border_color.split("solid");
		comm.ColorValidation(str[1].trim());
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 6).click();
		CommonFunctionality.Views_list();
	}

	@Then("^The visual border \"([^\"]*)\" should be updated to \"([^\"]*)\"$")
	public void the_visual_border_should_be_updated_to(String arg1, String arg2) throws Throwable {
		Thread.sleep(2000);
		if (arg1.equals("Width")) {
			String border = login.driver
					.findElement(
							By.xpath("//div[@class='visual-preview base-preview']//div[@class='visual-item-wrapper']"))
					.getCssValue("border");
			String[] str = border.split(" ");
			login.Log4j.info(str[0]);
			comm.FontSizeValidation(str[0], arg2);
		} else if (arg1.equals("Radius")) {
			String ActualRadius = login.driver
					.findElement(
							By.xpath("//div[@class='visual-preview base-preview']//div[@class='visual-item-wrapper']"))
					.getCssValue("border-radius");

			login.Log4j.info("Actual value is :" + ActualRadius);
			comm.FontSizeValidation(ActualRadius, arg2);
		}
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 6).click();
		CommonFunctionality.Views_list();
	}

	@And("^Select Radius to (\\d+)$")
	public void select_Radius_to(int radius) throws Throwable {
		comm.Radius(radius);
		CommonFunctionality.wait(1000);
	}

	@And("^Select below Styles for visual border$")
	public void select_below_Styles_for_visual_border(List<String> list) throws Throwable {
		styles = list;

	}
	
	@And("^Select visual border as \"([^\"]*)\"$")
	public void select_visual_border_as(List<String> arg1) throws Throwable {
	   styles = arg1;
	}

	@Then("^The selected border should be applied to the visual$")
	public void the_selected_border_should_be_applied_to_the_visual() throws Throwable {
		for (String style : styles) {
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='select-control']//span[@role='presentation']", 6)
					.click();
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='select2-results']//li//*[@title='" + style + "']", 6)
					.click();
			CommonFunctionality.wait(1000);
			String VisualBorder = login.driver
					.findElement(
							By.xpath("//div[@class='visual-preview base-preview']//div[@class='visual-item-wrapper']"))
					.getCssValue("border");
			login.Log4j.info(VisualBorder);
			if (VisualBorder.toUpperCase().contains(style.toUpperCase())) {
				login.Log4j.info("The selected border " + style + " is applied to the visual");
			} else {
				Assert.fail("The selected border " + style + " is not applied to the visual");
			}
		}
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 6).click();
		CommonFunctionality.Views_list();
	}

	@Then("^Visual popup should be opened$")
	public void visual_popup_should_be_opened() throws Throwable {
		CommonFunctionality.wait(1000);
		if (login.driver.findElement(By.xpath("//*[@class='popover-content']")).isDisplayed()) {
			login.Log4j.info("Visual/Titles popup is displayed");
		} else {
			Assert.fail("Visual popup is not displayed ");
		}
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		CommonFunctionality.Views_list();
	}

	@And("^Click on X icon$")
	public void click_on_X_icon() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='popover--close']", 6).click();
	}

	@Then("^The visual popup should be closed$")
	public void the_visual_popup_should_be_closed() throws Throwable {
		if (login.driver.findElements(By.xpath("//div[@class='popover-content']")).size() == 0) {
			login.Log4j.info("The visual popup is closed");
		} else {
			Assert.fail("The visual popup is not closed");
		}
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		CommonFunctionality.Views_list();
	}

	@And("^Click on Background drop down$")
	public void click_on_Background_drop_down() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='base-config--column base-config--column__style']//div[3]//div[2]//div[1]//div[2]", 8)
				.click();
	}

	@And("^Uncheck Histogram and Visual$")
	public void uncheck_histogram_and_Visual() throws Throwable {
		CommonFunctionality.wait(1000);
		WebElement ele = login.driver.findElement(
				By.xpath("//*[@class='background-control-container']/*[1]//span[@class='input-control--indicator']"));
		Boolean check_histogram = ele.isSelected();
		WebElement ele1 = login.driver.findElement(
				By.xpath("//*[@class='background-control-container']/*[2]//span[@class='input-control--indicator']"));
		Boolean check_visual = ele1.isSelected();
		if (check_histogram == true) {
			// uncheck histogram
			ele.click();
		}
		if (check_visual == true) {
			// uncheck visual
			ele1.click();
		}

	}

	@Then("^Background should not be seen for histogram and visual$")
	public void background_should_not_be_seen_for_histogram_and_visual() throws Throwable {
		CommonFunctionality.wait(1000);
		if (!(login.driver
				.findElement(By.xpath("//div[@class='visual-preview base-preview']//div[@class='visual-item-wrapper']"))
				.getAttribute("style")).contains("background-color")) {
			login.Log4j.info("Background color is not displayed");
		} else {
			Assert.fail("Background color is displayed by unchecking histogram and visual");
		}
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		CommonFunctionality.Views_list();
	}

	@And("^Check Histogram and Visual$")
	public void check_Histogram_and_Visual() throws Throwable {
		WebElement ele = login.driver.findElement(
				By.xpath("//*[@class='background-control-container']/*[1]//span[@class='input-control--indicator']"));

		Boolean check_histogram = ele.isSelected();
		if (check_histogram == false) {
			// check histogram
			ele.click();
		}
		CheckVisual();
	}

	@Then("^Background color should be displayed for histogram and visual$")
	public void background_color_should_be_displayed_for_histogram_and_visual() throws Throwable {
		CommonFunctionality.wait(1000);
		if ((login.driver
				.findElement(By.xpath("//div[@class='visual-preview base-preview']//div[@class='visual-item-wrapper']"))
				.getAttribute("style")).contains("background-color")) {
			login.Log4j.info("Background color is displayed");
		} else {
			Assert.fail("Background color is not displayed by checking histogram and visual");
		}
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 6).click();
		CommonFunctionality.Views_list();
	}

	@And("^Check Histogram for \"([^\"]*)\"$")
	public void check_Histogram_for(String arg1) throws Throwable {
		CheckHistogram(arg1);
	}

	@And("^Select background color$")
	public void select_background_color() throws Throwable {
		select_color_for_Histogram();
	}

	@Then("^Background should be displayed for histogram with selected color$")
	public void background_should_be_displayed_for_histogram_with_selected_color() throws Throwable {
		CommonFunctionality.wait(2000);
		String background_color = CommonFunctionality
				.getElementByXpath(login.driver, "(//*[@class='highcharts-plot-background'])[5]", 6)
				.getCssValue("fill");
		BackGroundColor_Validation(background_color);
	}

	@And("^click on Browse > upload image$")
	public void click_on_Browse_upload_image() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='background-image']//input[contains(@class,'form--control__xs background-image--input')]",
				6).click();
		comm.select_image();
	}

	@Then("^Uploaded image should be displayed in histogram background$")
	public void uploaded_image_should_be_displayed_in_histogram_background() throws Throwable {
		Boolean image = login.driver
				.findElement(By.xpath("//*[name()='image' and contains(@preserveAspectRatio,'none')]")).isDisplayed();
		BackGroundImageValidation(image);
	}

	@And("^click on Browse > try to upload PDF file$")
	public void click_on_Browse_try_to_upload_PDF_file() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='background-image']//input[contains(@class,'form--control__xs background-image--input')]",
				6).click();
		CommonFunctionality.wait(2000);
		CommonFunctionality.uploadTheFileusingAutoIT(login.driver,
				System.getProperty("user.dir") + "\\AutoIT\\UploadFile.exe",
				System.getProperty("user.dir") + "\\AutoIT\\Job_Vacancies_Total.pdf");
		CommonFunctionality.wait(5000);
	}

	@Then("^Background should be displayed for visual with selected color$")
	public void background_should_be_displayed_for_visual_with_selected_color() throws Throwable {
		CommonFunctionality.wait(2000);
		String background_color = CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[@class='visual-preview base-preview']//*[@class='visual-item-wrapper']", 6)
				.getCssValue("background-color");
		BackGroundColor_Validation(background_color);
	}

	@Then("^Uploaded image should be displayed in visual background$")
	public void uploaded_image_should_be_displayed_in_visual_background() throws Throwable {
		CommonFunctionality.wait(1000);
		Boolean VisualBackgroundImage = login.driver
				.findElement(By.xpath("//*[@class='visual-preview base-preview']//*[@class='visual-item-wrapper']"))
				.getAttribute("style").contains("background-image");
		BackGroundImageValidation(VisualBackgroundImage);
	}

	@And("^Check Show Series and Save$")
	public void check_Show_Series_and_Save() throws Throwable {
		CommonFunctionality.wait(1000);
		Boolean isChecked = login.driver
				.findElement(By.xpath(
						"//div[@class='base-config--row-control base-config--show-control']//input[@type='checkbox']"))
				.isSelected();
		if (isChecked == false) {
			new Actions(login.driver).moveToElement(login.driver.findElement(By.xpath(
					"//div[@class='base-config--row-control base-config--show-control']//span[@class='input-control--indicator']")))
					.click().perform();
		}
		// save the changes
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Save')]", 8).click();
	}

	@Then("^Data of series should be shown on the visual$")
	public void data_of_series_should_be_shown_on_the_visual() throws Throwable {
		Boolean Series = login.driver
				.findElement(By.xpath("(//*[@class='highcharts-axis-labels highcharts-xaxis-labels'])[1]"))
				.isDisplayed();
		if (Series == true) {
			login.Log4j.info("Data of series is shown on the visual");
		} else {
			Assert.fail("Data of series is not shown on the visual");
		}
		CommonFunctionality.Views_list();
	}

	@And("^UnCheck Show Series and Save$")
	public void uncheck_Show_Series_and_Save() throws Throwable {
		make_any_changes();
		// save the changes
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Save')]", 8).click();

	}

	@Then("^Data of series should be removed from the visual$")
	public void data_of_series_should_be_removed_from_the_visual() throws Throwable {
		CommonFunctionality.wait(1000);
		Boolean Series = login.driver
				.findElement(By.xpath("(//*[@class='highcharts-axis-labels highcharts-xaxis-labels'])[1]"))
				.isDisplayed();
		if (Series == false) {
			login.Log4j.info("Data of series is removed from the visual");
		} else {
			Assert.fail("Data of series is not removed from the visual");
		}
		CommonFunctionality.Views_list();
	}

	@And("^Click on Title drop down$")
	public void click_on_Title_drop_down() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='style-container--style-controls']//div[1]//div[2]//div[1]//div[2]", 10).click();
	}

	@And("^Check Title and Save$")
	public void check_Title_and_Save() throws Throwable {
		CommonFunctionality.wait(1000);
		Boolean titleCheckBox = login.driver
				.findElement(By.xpath("//*[@class='title-control--row'][1]//input[@type='checkbox']")).isSelected();
		if (titleCheckBox == false) {
			new Actions(login.driver)
					.moveToElement(login.driver
							.findElement(By.xpath("//*[@class='title-control--row'][1]//input[@type='checkbox']")))
					.click().perform();
		}
		// save the changes
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Save')]", 8).click();
	}

	@Then("^The title of the visual should be displayed$")
	public void the_title_of_the_visual_should_be_displayed() throws Throwable {
		CommonFunctionality.wait(1000);
		Boolean VisualTitle = login.driver.findElement(By.xpath("//*[@data-name='title']")).isDisplayed();
		if (VisualTitle == true) {
			login.Log4j.info("The title of the visual is displayed");
		} else {
			Assert.fail("The title of the visual is not displayed");
		}
		CommonFunctionality.Views_list();
	}

	@SuppressWarnings("deprecation")
	@And("^UnCheck Title and Save$")
	public void uncheck_Title_and_Save() throws Throwable {
		CommonFunctionality.wait(1000);
		Boolean titleCheckBox = login.driver
				.findElement(By.xpath("//*[@class='title-control--row'][1]//input[@type='checkbox']")).isSelected();
		// uncheck title
		if (titleCheckBox == true) {
			new Actions(login.driver).pause(500)
					.moveToElement(login.driver
							.findElement(By.xpath("//*[@class='title-control--row'][1]//input[@type='checkbox']")))
					.click().perform();
		}
		// save the changes
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Save')]", 8).click();
	}

	@Then("^The title of the visual should be removed from the visual$")
	public void the_title_of_the_visual_should_be_removed_from_the_visual() throws Throwable {
		CommonFunctionality.wait(1000);
		Boolean VisualTitle = login.driver.findElement(By.xpath("//*[@data-name='title']")).isDisplayed();
		if (VisualTitle == false) {
			login.Log4j.info("The title of the visual is removed");
		} else {
			Assert.fail("The title of the visual is not removed");
		}
		CommonFunctionality.Views_list();
	}

	@Then("^The title should be selected by default$")
	public void the_title_should_be_selected_by_default() throws Throwable {
		CommonFunctionality.wait(1000);
		Boolean titleCheckBox = login.driver
				.findElement(By.xpath("//*[@class='title-control--row'][1]//input[@type='checkbox']")).isSelected();
		// by default checkbox
		if (titleCheckBox == true) {
			login.Log4j.info("The title is selected by default");
		} else {
			Assert.fail("The title is not selected by default");
		}
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		// CommonFunctionality.getElementByXpath(login.driver,
		// "//button[contains(text(),'Ok')]", 6).click();
		CommonFunctionality.Views_list();
	}

	@SuppressWarnings("deprecation")
	@And("^Check title with empty title field and Save$")
	public void check_title_with_empty_title_field_and_Save() throws Throwable {
		CommonFunctionality.wait(1000);
		Boolean titleCheckBox = login.driver
				.findElement(By.xpath("//*[@class='title-control--row'][1]//input[@type='checkbox']")).isSelected();
		// by default checkbox
		if (titleCheckBox == true) {
			login.Log4j.info("The title is selected by default");
		} else if (titleCheckBox == false) {
			new Actions(login.driver).pause(500)
					.moveToElement(login.driver
							.findElement(By.xpath("//*[@class='title-control--row'][1]//input[@type='checkbox']")))
					.click().perform();
		}
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Save')]", 8).click();
	}

	@Then("^Auto title should be displayed as series name$")
	public void auto_title_should_be_displayed_as_series_name() throws Throwable {
		CommonFunctionality.wait(1000);
		String Actual_Title = login.driver.findElement(By.xpath("//*[@data-name='title']")).getText();
		if (SName.equals(Actual_Title)) {
			login.Log4j.info("Auto title is displayed as series name");
		} else {
			Assert.fail("Auto title verification is failed");
		}
		CommonFunctionality.Views_list();
	}

	@And("^Enter visual name and Save$")
	public void enter_visual_name_and_Save() throws Throwable {
		AutoTitle = "Histogram";
		CommonFunctionality.wait(1000);
		Boolean titleCheckBox = login.driver
				.findElement(By.xpath("//*[@class='title-control--row'][1]//input[@type='checkbox']")).isSelected();
		// by default checkbox
		if (titleCheckBox == true) {
			CommonFunctionality.getElementByXpath(login.driver, "//input[@name='title']", 20).sendKeys(AutoTitle);
		} else if (titleCheckBox == false) {
			new Actions(login.driver).pause(500)
					.moveToElement(login.driver
							.findElement(By.xpath("//*[@class='title-control--row'][1]//input[@type='checkbox']")))
					.click().perform();

			CommonFunctionality.getElementByXpath(login.driver, "//input[@name='title']", 20).sendKeys("Histogram");
		}
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Save')]", 20).click();
	}

	@Then("^The visual name should be changed$")
	public void the_visual_name_should_be_changed() throws Throwable {
		CommonFunctionality.wait(1000);
		String Actual_Title = login.driver.findElement(By.xpath("//*[@data-name='title']")).getText();
		if (AutoTitle.equals(Actual_Title)) {
			login.Log4j.info("Visual name is changed with " + Actual_Title);
		} else {
			Assert.fail("Visual name is not changed by changing Auto name");
		}
		CommonFunctionality.Views_list();
	}

	@Then("^The sub title check box should be unchecked by default$")
	public void the_sub_title_check_box_should_be_unchecked_by_default() throws Throwable {
		CommonFunctionality.wait(1000);
		Boolean isChecked = login.driver
				.findElement(By.xpath("//*[@class='title-control--row'][2]//input[@type='checkbox']")).isSelected();
		if (isChecked == false) {
			login.Log4j.info("The sub title check box is unchecked by default");
		} else {
			Assert.fail("The sub title check box is not selected by default");
		}
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		// CommonFunctionality.getElementByXpath(login.driver,
		// "//button[contains(text(),'Ok')]", 6).click();
		CommonFunctionality.Views_list();
	}

	@And("^Check Subtitle and Save$")
	public void check_Subtitle_and_Save() throws Throwable {
		CommonFunctionality.wait(1000);
		Boolean isChecked = login.driver.findElement(By.xpath(
				"//ul[contains(@class,'dropdown-menu context-menu')]//div[2]//div[1]//div[1]//div[1]//label[1]//span[1]"))
				.isSelected();
		if (isChecked == false) {
			login.driver.findElement(By.xpath(
					"//ul[contains(@class,'dropdown-menu context-menu')]//div[2]//div[1]//div[1]//div[1]//label[1]//span[1]"))
					.click();
		}
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Save')]", 20).click();
	}

	@Then("^Sub title should be displayed for the visual$")
	public void sub_title_should_be_displayed_for_the_visual() throws Throwable {
		CommonFunctionality.wait(1000);
		Boolean sub_title = login.driver.findElement(By.xpath("//*[@data-name='sub_title']")).isDisplayed();
		if (sub_title == true) {
			login.Log4j.info("The Sub title is displayed in the visual by checking sub title ");
		} else {
			Assert.fail("The Sub title is not displayed in the visual by checking sub title ");
		}
		CommonFunctionality.Views_list();
	}

	@And("^UnCheck Subtitle and Save$")
	public void uncheck_Subtitle_and_Save() throws Throwable {
		CommonFunctionality.wait(1000);
		Boolean isChecked = login.driver.findElement(By.xpath(
				"//ul[contains(@class,'dropdown-menu context-menu')]//div[2]//div[1]//div[1]//div[1]//label[1]//span[1]"))
				.isSelected();
		if (isChecked == true) {
			login.driver.findElement(By.xpath(
					"//ul[contains(@class,'dropdown-menu context-menu')]//div[2]//div[1]//div[1]//div[1]//label[1]//span[1]"))
					.click();
		}
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Save')]", 20).click();
	}

	@Then("^Sub title should not be displayed for the visual$")
	public void sub_title_should_not_be_displayed_for_the_visual() throws Throwable {
		CommonFunctionality.wait(1000);
		Boolean sub_title = login.driver.findElement(By.xpath("//*[@data-name='sub_title']")).isDisplayed();
		if (sub_title == false) {
			login.Log4j.info("The Sub title is not displayed for the visual by Unchecking sub title ");
		} else {
			Assert.fail("The Sub title is displayed for the visual by Unchecking sub title ");
		}
		CommonFunctionality.Views_list();
	}

	@Then("^Default sub title should be \"([^\"]*)\"$")
	public void default_sub_title_should_be(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		String sub_title = login.driver.findElement(By.xpath("//*[@data-name='sub_title']")).getText();
		if (sub_title.equals(arg1)) {
			login.Log4j.info("Default Sub title is " + arg1);
		} else {
			Assert.fail("Sub title verification is failed ");
		}
		CommonFunctionality.Views_list();
	}

	@And("^Click on cogwheel icon for title$")
	public void click_on_cogwheel_icon_for_title() throws Throwable {
		CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='style-container']//div[1]//div[3]//div[1]", 10).click();
	}

	@Then("^Titles popup should be displayed$")
	public void titles_popup_should_be_displayed() throws Throwable {
		visual_popup_should_be_opened();
	}

	@And("^Check \"([^\"]*)\"$")
	public void check(String arg1) throws Throwable {
		if (arg1.equals("Title")) {
			CommonFunctionality.wait(1000);
			Boolean isChecked = login.driver
					.findElement(By.xpath("//div[@class='accordion-config ']/*[3]/*[1]/*[1]//input[@type='checkbox']"))
					.isSelected();
			if (isChecked == false) {
				login.driver.findElement(By.xpath(
						"//div[@class='accordion-config ']/*[3]/*[1]/*[1]//span[@class='input-control--indicator']"))
						.click();
			}
		} else if (arg1.equalsIgnoreCase("sub-title")) {
			comm.ExpandSubTitle_CheckBox();
		} else if (arg1.equalsIgnoreCase("Copyright")) {
			CommonFunctionality.wait(1000);
			Boolean isChecked = login.driver
					.findElement(By.xpath(
							"//*[contains(@class,'histogram-config--column__settings')]/*[2]//input[@type='checkbox']"))
					.isSelected();
			if (isChecked == false) {
				login.driver.findElement(By.xpath(
						"//*[contains(@class,'histogram-config--column__settings')]/*[2]//span[@class='input-control--indicator']"))
						.click();
			}
		} else if (arg1.equalsIgnoreCase("Tooltips")) {
			CommonFunctionality.wait(1000);
			Boolean isChecked = login.driver
					.findElement(By.xpath(
							"//*[contains(@class,'histogram-config--column__settings')]/*[3]//input[@type='checkbox']"))
					.isSelected();
			if (isChecked == false) {
				login.driver.findElement(By.xpath(
						"//*[contains(@class,'histogram-config--column__settings')]/*[3]//span[@class='input-control--indicator']"))
						.click();
			}
		} else if (arg1.equalsIgnoreCase("Show tooltips")) {
			CommonFunctionality.wait(1000);
			Boolean isChecked = login.driver.findElement(By.xpath("//*[@class='tooltip-config']//*[@type='checkbox']"))
					.isSelected();
			if (isChecked == false) {
				login.driver
						.findElement(By.xpath("//*[@class='tooltip-config']//span[@class='input-control--indicator']"))
						.click();
			}
		}
	}

	@And("^UnCheck \"([^\"]*)\"$")
	public void uncheck(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		Boolean isChecked = login.driver.findElement(By.xpath("//*[@class='tooltip-config']//*[@type='checkbox']"))
				.isSelected();
		if (isChecked == true) {
			login.driver.findElement(By.xpath("//*[@class='tooltip-config']//span[@class='input-control--indicator']"))
					.click();
		}
	}

	@And("^Select color for \"([^\"]*)\"$")
	public void select_color_for(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		if (arg1.equalsIgnoreCase("Title")) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//div[@class='accordion-config ']//div[3]//div[1]//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]",
					10).click();

		} else if (arg1.equalsIgnoreCase("Sub title")) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//div[@class='accordion-config']//div[@class='popover-block-content']//div[1]//div[1]//div[1]//div[1]//div[1]",
					10).click();
		} else if (arg1.equalsIgnoreCase("Copyright")) {
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='popover--wrapper']//*[@class='sp-preview-inner']", 10)
					.click();
		} else if (arg1.equalsIgnoreCase("Items")) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='popover-block-content']/*[2]/*[1]//*[@class='sp-preview-inner']", 10).click();
		} else if (arg1.equalsIgnoreCase("tooltip border")) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='border-settings--container']//*[@class='sp-preview-inner']", 10).click();
		}
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath",
				"//div[@class='sp-container sp-light sp-buttons-disabled sp-palette-buttons-disabled sp-initial-disabled color-picker-selection']//*[@class='sp-palette-container']//span[@title='#fda546']");
	}

	@Then("^Visual \"([^\"]*)\" should be displayed in selected color$")
	public void visual_should_be_displayed_in_selected_color(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		if (arg1.equalsIgnoreCase("title") || arg1.equalsIgnoreCase("sub-title")) {
			String Title_color = CommonFunctionality
					.getElementByXpath(login.driver, "//*[@data-name='" + arg1 + "']", 6).getCssValue("color");
			comm.ColorValidation(Title_color);
		} else if (arg1.equalsIgnoreCase("Copyright")) {
			String copyright_color = CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='visual-item-wrapper--text ']", 10)
					.getCssValue("color");
			comm.ColorValidation(copyright_color);
		} else if (arg1.equalsIgnoreCase("tooltip text")) {
			CommonFunctionality.wait(2000);
			List<WebElement> timepoints = login.driver.findElements(By.xpath(
					"//*[contains(@class,'highcharts-markers highcharts-series-0 highcharts-scatter-series')]/*"));
			for (int i = 0; i <= timepoints.size(); i++) {
				new Actions(login.driver).moveToElement(timepoints.get(i)).pause(100).perform();
				String TooltipText_color = CommonFunctionality
						.getElementByXpath(login.driver,
								"//*[contains(@class,'highcharts-tooltip highcharts-color-undefined')]/span", 10)
						.getCssValue("color");
				comm.ColorValidation(TooltipText_color);
				break;
			}
		}
		CommonFunctionality.Views_list();
	}
	@Then("^Tooltip border should be displayed with selected color$")
	public void tooltip_border_should_be_displayed_with_selected_color() throws Throwable {
		CommonFunctionality.wait(2000);
		List<WebElement> timepoints = login.driver.findElements(By.xpath(
				"//*[contains(@class,'highcharts-markers highcharts-series-0 highcharts-scatter-series')]/*"));
		for (int i = 0; i <= timepoints.size(); i++) {
			new Actions(login.driver).moveToElement(timepoints.get(i)).pause(100).perform();
			String Tooltip_border_color = CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[@class='highcharts-label-box highcharts-tooltip-box']", 10)
					.getCssValue("stroke");
			comm.ColorValidation(Tooltip_border_color);
			break;
		}
		CommonFunctionality.Views_list();
	}
	@And("^Select color for \"([^\"]*)\" background highlight$")
	public void select_color_for_background_highlight(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		if (arg1.equalsIgnoreCase("title")) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//div[@class='accordion-config ']//div[3]//div[1]//div[2]//div[2]//div[1]//div[1]//div[1]//div[1]",
					10).click();

		} else if (arg1.equalsIgnoreCase("Sub title")) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//div[@class='accordion-config']//div[contains(@class,'row')]//div[2]//div[1]//div[1]//div[1]//div[1]",
					10).click();
		}
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath",
				"//div[@class='sp-container sp-light sp-buttons-disabled sp-palette-buttons-disabled sp-initial-disabled color-picker-selection']//*[@class='sp-palette-container']//span[@title='#fda546']");
	}

	@Then("^Visual \"([^\"]*)\" background should be displayed in selected color$")
	public void visual_background_should_be_displayed_in_selected_color(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		if (arg1.equalsIgnoreCase("title") || arg1.equalsIgnoreCase("sub_title")) {
			String Title_Background_color = CommonFunctionality
					.getElementByXpath(login.driver, "//*[@data-name='" + arg1 + "']", 6)
					.getCssValue("background-color");
			comm.ColorValidation(Title_Background_color);
		}
		CommonFunctionality.Views_list();
	}

	@And("^Select size for visual \"([^\"]*)\" as \"([^\"]*)\"$")
	public void select_size_for_visual_as(String arg1, String FontSize) throws Throwable {
		if (arg1.equalsIgnoreCase("title")) {
			comm.choose_from_the_drop_down_for_the_font_size(FontSize);
		} else if (arg1.equalsIgnoreCase("Sub title")) {
			comm.choose_from_the_drop_down_for_the_font_size_of_subtitle(FontSize);
		} else if (arg1.equalsIgnoreCase("Copyright")) {
			Thread.sleep(2000);
			String size = CommonFunctionality.getElementByXpath(login.driver, "//*[@name='credits_font_size']", 8)
					.getAttribute("value");
			int length = Integer.parseInt(FontSize) - Integer.parseInt(size);

			for (int i = 1; i <= length; i++) {
				Thread.sleep(500);
				login.driver.findElement(By.xpath("//button[contains(@class,'ui-spinner-up')]")).click();
			}
		}
	}

	@Then("^The \"([^\"]*)\" font size should be changed as \"([^\"]*)\"$")
	public void the_font_size_should_be_changed_as(String arg1, String FontSize) throws Throwable {
		if (arg1.equalsIgnoreCase("title") || arg1.equalsIgnoreCase("sub_title")) {
			comm.the_commentary_should_update_the_font_as(arg1, FontSize);
		} else if (arg1.equalsIgnoreCase("Copyright")) {
			CommonFunctionality.wait(2000);
			String Txtfont = login.driver.findElement(By.xpath("//*[@class='visual-item-wrapper--text ']"))
					.getCssValue("font-size");
			login.Log4j.info(Txtfont);
			comm.FontSizeValidation(Txtfont, FontSize);
			CommonFunctionality.Views_list();
		}
	}

	@Then("^The \"([^\"]*)\" should be displayed in Bold format$")
	public void the_title_should_be_displayed_in_Bold_format(String title) throws Throwable {
		comm.BoldFormatVerification(title);
		CommonFunctionality.Views_list();
	}

	@Then("^The \"([^\"]*)\" should be \"([^\"]*)\"$")
	public void the_should_be(String arg1, String format) throws Throwable {
		comm.StyleSelection(arg1, format);
		CommonFunctionality.Views_list();
	}

	@SuppressWarnings("deprecation")
	@And("^Select alignment for \"([^\"]*)\" and Save$")
	public void select_alignment_for_and_Save(String arg1, List<String> list) throws Throwable {
		String alignmentValue = null;
		for (int i = 0; i < list.size(); i++) {

			if (arg1.equalsIgnoreCase("title")) {
				CommonFunctionality.wait(300);
				login.driver.findElement(By.xpath("//*[@data-value='" + list.get(i) + "']")).click();
				CommonFunctionality.wait(300);
				CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Save')]", 10).click();
				CommonFunctionality.wait(1000);
				alignmentValue = login.driver
						.findElement(
								By.xpath("(//*[@class='visual-title visual-select-area visual-title--wrapper'])[1]"))
						.getAttribute("style");
			} else if (arg1.equalsIgnoreCase("Sub title")) {
				login.Log4j.info(list.get(i));
				CommonFunctionality.wait(500);
				login.driver.findElement(By.xpath("//*[@name='sub_title_align' and @data-value='" + list.get(i) + "']"))
						.click();
				CommonFunctionality.wait(300);
				CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Save')]", 20).click();
				CommonFunctionality.wait(800);
				alignmentValue = login.driver
						.findElement(
								By.xpath("(//*[@class='visual-title visual-select-area visual-title--wrapper'])[2]"))
						.getAttribute("style");
			} else if (arg1.equalsIgnoreCase("Horizontal align") || arg1.equalsIgnoreCase("Copyright")) {
				CommonFunctionality.wait(500);
				login.driver.findElement(By.xpath("//*[@data-value='" + list.get(i) + "']")).click();
				CommonFunctionality.wait(1000);
				CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Save')]", 10).click();
				alignmentValue = login.driver
						.findElement(By.xpath("//*[@class='visual-item-wrapper--credits-container ']"))
						.getAttribute("style");
			}

			ListOfalignmentValue.add(alignmentValue);
			if (!(i == 2)) {
				CommonFunctionality.wait(1000);
				seriesTab.click_on("Edit Histogram");
				if (arg1.equalsIgnoreCase("title")) {
					click_on_cogwheel_icon_for_title();
				} else if (arg1.equalsIgnoreCase("Sub title")) {
					click_on_cogwheel_icon_for_title();
					CommonFunctionality.wait(1000);
					WebElement expand = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand")));
					new Actions(login.driver).pause(300).moveToElement(expand).click().build().perform();
				} else if (arg1.equalsIgnoreCase("Horizontal align")) {
					open_drop_down_for("Copyright");
				} else if (arg1.equalsIgnoreCase("Copyright")) {
					database.click_on_icon("Open advanced settings popup");
					select_Text_radio_button();
				}
			}
		}
	}

	@Then("^The title should align to \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\" as per the user selection$")
	public void the_title_should_align_to_and_as_per_the_user_selection(String arg1, String arg2, String arg3)
			throws Throwable {
		comm.AlignmentValidation(arg1, arg2, arg3, ListOfalignmentValue);
		CommonFunctionality.Views_list();
	}

	@Then("^The Title popup should be closed$")
	public void the_Title_popup_should_be_closed() throws Throwable {
		comm.PopUp_validation("title");
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		CommonFunctionality.Views_list();
	}

	@Then("^The default Edit Visual popup height and width should be \"([^\"]*)\"$")
	public void the_default_Edit_Visual_popup_height_and_width_should_be(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		String width = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='movable-modal--window ui-draggable']", 10)
				.getCssValue("max-width");
		String height = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='movable-modal--window ui-draggable']", 10)
				.getCssValue("max-height");
		int Width = Integer.parseInt(width.replaceAll("%", ""));
		int Height = Integer.parseInt(height.replaceAll("%", ""));
		int size = Integer.parseInt(arg1.replaceAll("%", ""));

		if (Width == size && Height == size) {
			login.Log4j.info("The default Edit visual popup size is " + size);
		} else {
			login.Log4j.info("The default size is not mathched with " + size);
		}
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		CommonFunctionality.Views_list();
	}

	@And("^Open Size dropdown$")
	public void open_Size_dropdown() throws Throwable {
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='base-config--column base-config--column__as-table']/*[2]//div[@class='context-menu-control--icon']",
				10).click();
	}

	@And("^Reduce proportion to (\\d+)$")
	public void reduce_proportion_to(int arg1) throws Throwable {
		Thread.sleep(2000);
		String proportion = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@name='visual_area_proportion_x']", 8).getAttribute("value");

		int length = Integer.parseInt(proportion) - arg1;

		for (int i = 1; i <= length; i++) {
			Thread.sleep(500);
			login.driver
					.findElement(By.xpath(
							"//*[@class='size-control--toggler']//*[@class='ui-spinner-button ui-spinner-down']"))
					.click();
		}
	}

	@Then("^The visual should align to \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\" as per the user selection$")
	public void the_visual_should_align_to_and_as_per_the_user_selection(String arg1, String arg2, String arg3)
			throws Throwable {
		comm.AlignmentValidation(arg1, arg2, arg3, ListOfalignmentValue);
		CommonFunctionality.Views_list();
	}

	@Then("^The \"([^\"]*)\" should be disabled if proportion is \"([^\"]*)\"$")
	public void the_should_be_disabled_if_proportion_is(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(1000);
		String proportion = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@name='visual_area_proportion_x']", 10).getAttribute("value");
		int Proportion = Integer.parseInt(proportion.replaceAll("%", ""));
		int Expected_proportion = Integer.parseInt(arg2.replaceAll("%", ""));
		Boolean HorizontalAlign = login.driver.findElement(By.xpath("//*[@class='size-control--togglers disabled']"))
				.isDisplayed();
		if (Proportion == Expected_proportion && HorizontalAlign == true) {
			login.Log4j.info("The " + arg1 + " is disabled by default");
		} else {
			Assert.fail("The " + arg1 + " is not disabled by default");
		}
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		CommonFunctionality.Views_list();
	}

	@And("^Check Copyright and Save$")
	public void check_Copyright_and_Save() throws Throwable {
		check("Copyright");
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Save')]", 40).click();
	}
	/*
	 * @And("^Check Copyright$") public void check_Copyright() throws Throwable {
	 * CommonFunctionality.wait(1000); Boolean isChecked =
	 * login.driver.findElement(By.xpath(
	 * "//*[contains(@class,'histogram-config--column__settings')]/*[2]//input[@type='checkbox']"
	 * )).isSelected(); if(isChecked == false) { login.driver.findElement(By.xpath(
	 * "//*[contains(@class,'histogram-config--column__settings')]/*[2]//input[@type='checkbox']"
	 * )).click(); } }
	 */

	@Then("^The Copyright logo should be displayed for visual$")
	public void the_Copyright_logo_should_be_displayed_for_visual() throws Throwable {
		CommonFunctionality.wait(1000);
		Boolean Ceic_Logo = login.driver.findElement(By.xpath("//*[@class='visual-item-wrapper--credits-image']//img"))
				.isDisplayed();
		if (Ceic_Logo == true) {
			login.Log4j.info("CEIC logo is displayed");
		} else {
			Assert.fail("CEIC logo is not displayed");
		}
		CommonFunctionality.Views_list();
	}

	@And("^UnCheck Copyright$")
	public void uncheck_Copyright() throws Throwable {
		CommonFunctionality.wait(1000);
		Boolean isChecked = login.driver
				.findElement(By.xpath(
						"//*[contains(@class,'histogram-config--column__settings')]/*[2]//input[@type='checkbox']"))
				.isSelected();
		if (isChecked == true) {
			login.driver.findElement(By.xpath(
					"//*[contains(@class,'histogram-config--column__settings')]/*[2]//span[@class='input-control--indicator']"))
					.click();
		}
		// CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Save')]", 40).click();
	}

	@Then("^The Copyright logo should be removed for visual$")
	public void the_Copyright_logo_should_be_removed_for_visual() throws Throwable {
		CommonFunctionality.wait(1000);
		Boolean Ceic_Logo = login.driver.findElement(By.xpath("//*[@class='visual-item-wrapper--credits-image']//img"))
				.isDisplayed();
		if (Ceic_Logo == false) {
			login.Log4j.info("CEIC logo is not displayed for unchecking Copyright");
		} else {
			Assert.fail("CEIC logo is displayed for unchecking Copyright");
		}
		CommonFunctionality.Views_list();
	}

	@And("^Open drop down for \"([^\"]*)\"$")
	public void open_drop_down_for(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		if (arg1.equalsIgnoreCase("Copyright")) {
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(@class,'histogram-config--column__settings')]/*[2]/*[2]/*[1]/*[2]", 12)
					.click();
		} else if (arg1.equals("Tooltips")) {
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(@class,'histogram-config--column__settings')]/*[3]/*[2]/*[1]/*[2]", 12)
					.click();
		}
	}

	@Then("^The copyright should be dispalyed in \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\" as per the user selection$")
	public void the_copyright_should_be_dispalyed_in_and_as_per_the_user_selection(String arg1, String arg2,
			String arg3) throws Throwable {
		comm.AlignmentValidation(arg1, arg2, arg3, ListOfalignmentValue);
		CommonFunctionality.Views_list();
	}

	@And("^Select Text radio button from copyright popup and Save$")
	public void select_Text_radio_button_from_copyright_popup_and_Save() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='copyright-config']/*[5]/*[1]/*[2]/*[1]/*[2]//*[@class='input-control--indicator']", 40)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Save')]", 40).click();
	}

	@Then("^Copyright text \"([^\"]*)\" should be displayed on visual$")
	public void copyright_text_should_be_displayed_on_visual(String CopyrightText) throws Throwable {
		String Actual_CopyrightText = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='visual-item-wrapper--text ']", 20).getText();
		if (Actual_CopyrightText.equals(CopyrightText)) {
			login.Log4j.info("Copyright text is displayed on visual by selecting Text ");
		} else {
			Assert.fail("Copyright text is not displayed on visual by selecting Text ");
		}
		CommonFunctionality.Views_list();
	}

	@And("^Select Text radio button and Edit the text as \"([^\"]*)\" and Save$")
	public void select_Text_radio_button_and_Edit_the_text_as_and_Save(String Edit_text) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='copyright-config']/*[5]/*[1]/*[2]/*[1]/*[2]//*[@class='input-control--indicator']", 40)
				.click();
		WebElement TextField = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='copyright-config--block-content']/*[3]/*[2]/*", 10);
		TextField.clear();
		new Actions(login.driver).pause(500).sendKeys(TextField, Edit_text).perform();
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Save')]", 20).click();
		// CommonFunctionality.getElementByXpath(login.driver,
		// "//button[contains(text(),'Ok')]", 10).click();
	}

	@Then("^Updated copyright \"([^\"]*)\" should be displayed on visual$")
	public void updated_copyright_should_be_displayed_on_visual(String Updated_copyright_text) throws Throwable {
		CommonFunctionality.wait(1000);
		String Actual_CopyrightText = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='visual-item-wrapper--text ']", 20).getText();
		if (Actual_CopyrightText.equals(Updated_copyright_text)) {
			login.Log4j.info("Updated Copyright text is displayed on visual by editing text ");
		} else {
			Assert.fail("Updated Copyright text is not displayed on visual by editing Text field");
		}
		CommonFunctionality.Views_list();
	}

	@And("^Click on the Copyright$")
	public void click_on_the_Copyright() throws Throwable {
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='visual-item-wrapper--text ']", 10).click();
	}

	@Then("^The user should redirect to \"([^\"]*)\" link$")
	public void the_user_should_redirect_to_link(String ExpectedURL) throws Throwable {
		CommonFunctionality.wait(3000);
		ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
		// Navigate to New Tab
		login.driver.switchTo().window(tabs2.get(1));
		CommonFunctionality.wait(1000);
		String currentURL = login.driver.getCurrentUrl();
		login.Log4j.info("Current URL is " + currentURL);
		if (currentURL.equalsIgnoreCase(ExpectedURL)) {
			login.Log4j.info("Redirected to " + ExpectedURL + " link");
		} else {
			Assert.fail("Failed to redirect to " + ExpectedURL + " link");
		}
		login.driver.close();
		login.driver.switchTo().window(tabs2.get(0));
		CommonFunctionality.Views_list();
	}

	@And("^Select Text radio button$")
	public void select_Text_radio_button() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='copyright-config']/*[5]/*[1]/*[2]/*[1]/*[2]//*[@class='input-control--indicator']", 40)
				.click();
	}

	@And("^Click on Italic icon$")
	public void click_on_Italic_icon() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@name='credits_font_style']", 20).click();
	}

	@Then("^Tooltip should be displayed when mouse hover on visual data$")
	public void tooltip_should_be_displayed_when_mouse_hover_on_visual_data() throws Throwable {
		CommonFunctionality.wait(2000);
		List<WebElement> timepoints = login.driver.findElements(
				By.xpath("//*[contains(@class,'highcharts-markers highcharts-series-0 highcharts-scatter-series')]/*"));
		for (int i = 0; i <= timepoints.size(); i++) {
			new Actions(login.driver).moveToElement(timepoints.get(i)).pause(100).perform();
			WebElement tooltip = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'highcharts-tooltip highcharts-color-undefined')]/span", 8);
			String text = tooltip.getText();
			login.Log4j.info(text);

			if (tooltip.isDisplayed()) {
				login.Log4j.info("Tooltip is displayed when mouse hover on visual data");
			} else {
				Assert.fail("Tooltip is not displayed when mouse hover on visual data");
			}
			break;

		}
		CommonFunctionality.Views_list();
	}

	@And("^UnCheck Tooltips$")
	public void uncheck_Tooltips() throws Throwable {
		CommonFunctionality.wait(1000);
		Boolean isChecked = login.driver
				.findElement(By.xpath(
						"//*[contains(@class,'histogram-config--column__settings')]/*[3]//input[@type='checkbox']"))
				.isSelected();
		if (isChecked == true) {
			login.driver.findElement(By.xpath(
					"//*[contains(@class,'histogram-config--column__settings')]/*[3]//span[@class='input-control--indicator']"))
					.click();
		}
	}

	@Then("^No Tooltip should be displayed when mouse hover on visual data$")
	public void no_Tooltip_should_be_displayed_when_mouse_hover_on_visual_data() throws Throwable {
		CommonFunctionality.wait(2000);
		List<WebElement> timepoints = login.driver.findElements(
				By.xpath("//*[contains(@class,'highcharts-markers highcharts-series-0 highcharts-scatter-series')]/*"));
		login.Log4j.info(timepoints.size());
		for (int i = 0; i <= timepoints.size(); i++) {
			new Actions(login.driver).moveToElement(timepoints.get(i)).pause(100).perform();
			try {
				Boolean tooltip = login.driver
						.findElement(
								By.xpath("//*[contains(@class,'highcharts-tooltip highcharts-color-undefined')]/span"))
						.isEnabled();
			} catch (NoSuchElementException e) {
				login.Log4j.info("No Tooltip is displayed when mouse hover on visual data");
			}

			break;

		}
		CommonFunctionality.Views_list();
	}

	@And("^Create a histogram visual$")
	public void create_a_histogram_visual() throws Throwable {
		create_a_Histogram_visual_without_selecting_series();

	}

	@And("^Add a series to the visual$")
	public void add_a_series_to_the_visual() throws Throwable {
		CommonFunctionality.ResetMethod();
		CommonFunctionality.getElementByProperty(login.driver, "Search", 5).sendKeys("209570902");
		CommonFunctionality.getElementByProperty(login.driver, "Series", 20).click();
		CommonFunctionality.wait(1000);
		SRegion = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='series-item--country country-information']", 10)
				.getText();
		WebElement ele = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-item--name']", 10);
		SName = ele.getText();
		new Actions(login.driver).moveToElement(ele).perform();
		String tooltip_text = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text"))).getText();
		String[] lines = tooltip_text.split("\n");

		for (String Tooltip : lines) {
			// String str=null;
			if (Tooltip.contains("Frequency")) {
				String frequency = Tooltip;
				login.Log4j.info(frequency);
				Sfrequency = frequency.split(":");
			}
		}
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='add-to-data-selection--icon']", 10).click();
	}

	@And("^Select attributes$")
	public void select_attributes(List<String> list_attributes) throws Throwable {
		for (int i = 0; i < list_attributes.size(); i++) {
			CommonFunctionality.wait(500);
			login.driver
					.findElement(By.xpath("//*[@class='items-wrapper']//*[@title='" + list_attributes.get(i) + "']"))
					.click();
		}
	}

	@Then("^Selected attributes should be displayed in tooltip when mouse hover on visual data$")
	public void selected_attributes_should_be_displayed_in_tooltip_when_mouse_hover_on_visual_data() throws Throwable {
		CommonFunctionality.wait(2000);
		List<WebElement> timepoints = login.driver.findElements(
				By.xpath("//*[contains(@class,'highcharts-markers highcharts-series-0 highcharts-scatter-series')]/*"));
		for (int i = 0; i <= timepoints.size(); i++) {
			new Actions(login.driver).moveToElement(timepoints.get(i)).pause(100).perform();
			WebElement tooltip = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'highcharts-tooltip highcharts-color-undefined')]/span", 8);
			String text = tooltip.getText();
			login.Log4j.info(text);
			String[] Tooltip_txt = text.split(";");
			// login.Log4j.info(SName);
			// login.Log4j.info(SRegion);
			// login.Log4j.info(Sfrequency[1]);
			if (SName.equals(Tooltip_txt[1].trim()) && SRegion.equals(Tooltip_txt[2].trim())
					&& Sfrequency[1].trim().equals(Tooltip_txt[3].trim())) {
				login.Log4j.info("Selected attributes is displayed when mouse hover on visual data");
			} else {
				Assert.fail("Selected attributes not displayed when mouse hover on visual data");
			}
			break;

		}
		CommonFunctionality.Views_list();
	}

	@And("^Click on cogwheel for advance settings$")
	public void click_on_cogwheel_for_advance_settings() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'histogram-config--column__settings')]/*[3]//*[@title='Open advanced settings popup']",
				6).click();
	}
	@And("^Expand \"([^\"]*)\"$")
	public void expand(String arg1) throws Throwable {
	    if(arg1.equalsIgnoreCase("Items")) {
	    	CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='accordion-config collapsed'][1]//*[@class='icon-collapse']", 8).click();
	    } else if(arg1.equalsIgnoreCase("Border")) {
	    	//Expand Border
	    	CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='accordion-config collapsed'][2]//*[@class='icon-collapse']", 8).click();
	    	//select border checkbox
	    	CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='border-settings']//*[@class='input-control--indicator']", 10).click();
	    }
	}
	
	@And("^Select items as \"([^\"]*)\" from dropdown$")
	public void select_items_as_from_dropdown(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='add-item-attribute btn']", 8).click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='select2-results']//li//*[contains(text(),'Region')]", 8)
				.click();
	}

	@Then("^The selected items should be displayed in the tooltip  when mouse hover on visual data$")
	public void the_selected_items_should_be_displayed_in_the_tooltip_when_mouse_hover_on_visual_data()
			throws Throwable {
		CommonFunctionality.wait(2000);
		List<WebElement> timepoints = login.driver.findElements(
				By.xpath("//*[contains(@class,'highcharts-markers highcharts-series-0 highcharts-scatter-series')]/*"));
		for (int i = 0; i <= timepoints.size(); i++) {
			new Actions(login.driver).moveToElement(timepoints.get(i)).pause(100).perform();
			WebElement tooltip = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'highcharts-tooltip highcharts-color-undefined')]/span", 8);
			String Tooltip_text = tooltip.getText();
			login.Log4j.info(Tooltip_text);

			if (Tooltip_text.contains(SRegion)) {
				login.Log4j.info("Selected item region " + SRegion + " is displayed when mouse hover on visual data");
			} else {
				Assert.fail("Selected item region " + SRegion + " is not displayed when mouse hover on visual data");
			}
			break;

		}
		CommonFunctionality.Views_list();
	}

	@And("^Select multiple items from dropdown$")
	public void select_multiple_items_from_dropdown(List<String> Items_list) throws Throwable {

		for (int i = 0; i < Items_list.size(); i++) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='add-item-attribute btn']", 8).click();
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[@class='select2-results']//li//*[contains(text(),'" + Items_list.get(i) + "')]", 8)
					.click();

		}

	}

	@And("^Select font size as \"([^\"]*)\"$")
	public void select_font_size_as(String FontSize) throws Throwable {
		Thread.sleep(2000);
		String size = CommonFunctionality.getElementByXpath(login.driver, "//*[@name='tooltip_font_size']", 8)
				.getAttribute("value");
		int length = Integer.parseInt(FontSize) - Integer.parseInt(size);

		for (int i = 1; i <= length; i++) {
			Thread.sleep(500);
			login.driver
					.findElement(By.xpath(
							"//*[@class='popover-block-content']/*[2]/*[3]//button[contains(@class,'ui-spinner-up')]"))
					.click();
		}
	}

	@Then("^The font size in tooltip should be changed as \"([^\"]*)\"$")
	public void the_font_size_in_tooltip_should_be_changed_as(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		List<WebElement> timepoints = login.driver.findElements(
				By.xpath("//*[contains(@class,'highcharts-markers highcharts-series-0 highcharts-scatter-series')]/*"));
		for (int i = 0; i <= timepoints.size(); i++) {
			new Actions(login.driver).moveToElement(timepoints.get(i)).pause(100).perform();
			String Tooltip_font_size = CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(@class,'highcharts-tooltip highcharts-color-undefined')]/span", 10)
					.getCssValue("font-size");
			comm.FontSizeValidation(Tooltip_font_size, arg1);
			break;
		}
		CommonFunctionality.Views_list();
	}

	@And("^Click on \"([^\"]*)\" icon for items$")
	public void click_on_icon_for_items(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Italic")) {
			WebElement italic = CommonFunctionality.getElementByXpath(login.driver,
					"//button[@name='tooltip_font_style']", 20);
			italic.click();
		} else if (arg1.equalsIgnoreCase("Underline")) {
			WebElement underline = CommonFunctionality.getElementByXpath(login.driver,
					"//button[@name='tooltip_font_underline']", 20);
			underline.click();
		}
	}

	@Then("^The text in tooltip should be displayed in \"([^\"]*)\" format$")
	public void the_text_in_tooltip_should_be_displayed_in_format(String font_style) throws Throwable {

		CommonFunctionality.wait(2000);
		List<WebElement> timepoints = login.driver.findElements(
				By.xpath("//*[contains(@class,'highcharts-markers highcharts-series-0 highcharts-scatter-series')]/*"));
		for (int i = 0; i <= timepoints.size(); i++) {
			new Actions(login.driver).moveToElement(timepoints.get(i)).pause(500).perform();
			if (font_style.equals("Bold")) {
				String fontWeight = CommonFunctionality
						.getElementByXpath(login.driver,
								"//*[contains(@class,'highcharts-tooltip highcharts-color-undefined')]/span", 10)
						.getCssValue("font-weight");

				login.Log4j.info(fontWeight);
				Assert.assertTrue(Integer.parseInt(fontWeight) == 700);

			} else if (font_style.equals("Italic")) {
				String Actualformat = CommonFunctionality
						.getElementByXpath(login.driver,
								"//*[contains(@class,'highcharts-tooltip highcharts-color-undefined')]/span", 10)
						.getCssValue("font-style");
				login.Log4j.info(Actualformat);
				if (font_style.equalsIgnoreCase(Actualformat)) {
					login.Log4j.info("The text in tooltip is displayed in " + Actualformat + " format");
				} else {
					Assert.fail("The text in tooltip is not displayed in " + Actualformat + " format");
				}
			} else if (font_style.equalsIgnoreCase("underline")) {
				CommonFunctionality.wait(1000);
				String Actualformat = CommonFunctionality
						.getElementByXpath(login.driver,
								"//*[contains(@class,'highcharts-tooltip highcharts-color-undefined')]/span", 30)
						.getCssValue("text-decoration");
				login.Log4j.info(Actualformat);
				if (Actualformat.toUpperCase().contains(font_style.toUpperCase())) {
					login.Log4j.info("The text in tooltip is displayed in " + Actualformat + " format");
				} else {
					Assert.fail("The text in tooltip is not displayed in " + Actualformat + " format");
				}
			}
			break;
		}

		CommonFunctionality.Views_list();

	}

	@And("^Click on Number format dropdown$")
	public void click_on_Number_format_dropdown() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='base-config histogram-config']/*[2]/*[3]/*[2]/*[1]/*[1]/*[2]", 20).click();
	}

	@Then("^The Selected Decimal seperator and Grouping seperator should update with selected input$")
	public void the_Selected_Decimal_seperator_and_Grouping_seperator_should_update_with_selected_input()
			throws Throwable {
		CommonFunctionality.wait(2000);
		List<WebElement> timepoints = login.driver.findElements(
				By.xpath("//*[contains(@class,'highcharts-markers highcharts-series-0 highcharts-scatter-series')]/*"));
		for (int i = 1; i <= timepoints.size(); i++) {
			new Actions(login.driver).moveToElement(timepoints.get(i)).pause(100).perform();
			String tooltip_text = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'highcharts-tooltip highcharts-color-undefined')]/span", 10).getText();
			String lines[] = tooltip_text.split("[\\,\\.] ?");
			String split_by_comma[] = lines[0].split(",");
			if (ChartVisual.data_format_grouping_separator.equals("Space")
					&& ChartVisual.data_format_separator.equals(".")
					|| ChartVisual.data_format_grouping_separator.equals("Space")
							&& ChartVisual.data_format_separator.equals(",")) {
				if (!split_by_comma[0].matches(".*\\s.*")) {
					fail("Verification Failed");
				}
			} else {
				if (!tooltip_text.contains(ChartVisual.data_format_separator)
						&& !tooltip_text.contains(ChartVisual.data_format_grouping_separator)) {
					fail("Verification failed");
				}
			}
			break;
		}

		login.Log4j.info(
				"The Selected Decimal seperator and Grouping seperator has been updated in Histogram visual timepoints and verified successfully");
		CommonFunctionality.Views_list();
		
	
	}
	@And("^Set the Decimal places as (\\d+)$")
	public void set_the_Decimal_places_as(int arg1) throws Throwable {
		decimal_value = arg1;
		WebElement ele_decimal = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@name='y_axis_decimal_places']", 8);
		ele_decimal.sendKeys(Keys.chord(Keys.CONTROL, "a"), Integer.toString(arg1));
	}

	@Then("^Selected decimal places should be displayed with data$")
	public void selected_decimal_places_should_be_displayed_with_data() throws Throwable {
		CommonFunctionality.wait(2000);
		List<WebElement> timepoints = login.driver.findElements(
				By.xpath("//*[contains(@class,'highcharts-markers highcharts-series-0 highcharts-scatter-series')]/*"));
		for (int i = 1; i <= timepoints.size(); i++) {
			new Actions(login.driver).moveToElement(timepoints.get(i)).pause(100).perform();
			String Unit_value = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'highcharts-tooltip highcharts-color-undefined')]/span//b", 10).getText();
			login.Log4j.info(Unit_value);
			String[] arrValue = Unit_value.split("\\.");
			login.Log4j.info(arrValue[1]);
			int decimal_length = String.valueOf(arrValue[1]).length();

			login.Log4j.info(decimal_length);
			if(decimal_length == decimal_value) {
				login.Log4j.info("Selected decimal places is displayed in tooltip text");
			} else {
				Assert.fail("Selected decimal places not displayed in tool tip text");
			}
			break;
		}
		CommonFunctionality.Views_list();
	}
	
	@And("^Click on the visual title$")
	public void click_on_the_visual_title() throws Throwable {
		WebElement title = CommonFunctionality.getElementByXpath(login.driver, "(//*[@data-name='title'])[2]", 8);
		title.click();
	}
	@And("^Select any visual from visual panel$")
	public void select_any_visual_from_visual_panel() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='visual-types-panel']/*[2]/*[1]/*[2]", 8).click();
		VisualTitle = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='visual-types-panel']/*[2]/*[1]/*[2]/*[1]/*[1]", 8).getText();
	}

	@Then("^The visual should be converted as user selected$")
	public void the_visual_should_be_converted_as_user_selected() throws Throwable {
		if (VisualTitle.equalsIgnoreCase("Pie")) {
			VisualSelection(VisualTitle);
		} else {
			String[] title = VisualTitle.split(" ");
			VisualSelection(title[1]);
		}
		CommonFunctionality.Views_list();
	}
	@And("^Click on visual panel dropdown$")
	public void click_on_visual_panel_dropdown() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='visual-types-panel']//*[@class='type-select--icon']", 20).click();
	}

	@And("^Select \"([^\"]*)\" visual$")
	public void select_visual(String arg1) throws Throwable {
		VisualTitle = arg1;
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg1 + "']", 20).click();
	}
	@Then("^The series should be removed from visual and edit series panel$")
	public void the_series_should_be_removed_from_visual_and_edit_series_panel() throws Throwable {
	    if(login.driver.findElements(By.xpath("//*[@class='visual-series-name']")).size() == 0) {
	    	login.Log4j.info("Series removed from edit series panel");
	    	seriesTab.click_on("Save");
	    } else {
	    	Assert.fail("Series not removed from edit series panel");
	    }
	    CommonFunctionality.wait(1000);
	    if(login.driver.findElements(By.xpath("//*[@class='highcharts-container ']")).size() == 0) {
	    	login.Log4j.info("Series removed from the visual");
	    	
	    } else {
	    	Assert.fail("Series not removed from the visual");
	    }
	    CommonFunctionality.Views_list();
	}
	@And("^Click on Series name$")
	public void click_on_Series_name() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-name--title']", 20).click();
	}
	@Then("^\"([^\"]*)\" popup should be displayed for selected series$")
	public void popup_should_be_displayed_for_selected_series(String arg1) throws Throwable {
		CommonFunctionality.wait(1200);
		String Rename_popup = login.driver.findElement(By.xpath("//*[contains(@class,'movable-modal__active')]//*[@class='movable-modal--title-message']")).getText();
		if(Rename_popup.contains(Rename_popup)) {
			login.Log4j.info("Rename popup is displayed");
			//Close Rename pop up
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'movable-modal__active')]//*[@class='movable-modal--close']", 8).click();
			try {
				//Close Edit Histogram window
				CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 8).click();
			} catch(Exception e) {
				
			}
			CommonFunctionality.Views_list();
			
		} else {
			Assert.fail("Rename popup is not displayed");
		}
	}
	@And("^Select \"([^\"]*)\" as \"([^\"]*)\"$")
	public void select_as(String arg1, String arg2) throws Throwable {
		EditSeries_function = arg1;
		function = arg2;
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='items-wrapper']//*[contains(text(),'" + arg1 + "')]", 15)
				.click();
		if (arg2.equalsIgnoreCase("China") || arg2.equalsIgnoreCase("N America") || arg2.equalsIgnoreCase("World")) {
			CommonFunctionality
					.getElementByXpath(login.driver, "//ul[@class='dropdown-menu']//li//*[@title='" + arg2 + "']", 15)
					.click();

		} else {
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg2 + "')]", 15).click();
		}
	}
	@Then("^Selected currency should be applied to the series$")
	public void selected_currency_should_be_applied_to_the_series() throws Throwable {
		SeriesByEditSeriesInfo(function);
	}
	void VisualSelection(String Selected_visual) throws Exception {
		CommonFunctionality.wait(1200);
		String Edit_Visual_title = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='visual-top-panel--left-controls']/*[1]", 15)
				.getText();
		if (Edit_Visual_title.toUpperCase().contains(Selected_visual.trim().toUpperCase())) {
			login.Log4j.info("The selected visual is displayed");
		} else {
			Assert.fail("The selected visual is not displayed");
		}
	}
	void BackGroundImageValidation(Boolean image) throws Exception {
		if (image == true) {
			login.Log4j.info("Image is uploaded");
		} else {
			Assert.fail("Image is not uploaded");
		}
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 6).click();
		CommonFunctionality.Views_list();
	}

	@SuppressWarnings("deprecation")
	void CheckHistogram(String arg) throws Exception {
		WebElement ele = null;
		CommonFunctionality.wait(1500);
		if (arg.equalsIgnoreCase("Border")) {
			ele = login.driver
					.findElement(By.xpath("//div[@class='border-control']/*/*[1]//label//input[@type='checkbox']"));

		} else if (arg.equalsIgnoreCase("Background")) {
			ele = login.driver.findElement(
					By.xpath("//*[@class='background-control-container']/*[1]//label//input[@type='checkbox']"));
		}
		new Actions(login.driver).pause(500).moveToElement(ele).click().perform();
		Boolean check_histogram = ele.isSelected();
		if (check_histogram == false) {
			// check histogram
			ele.click();
		}
	}

	void CheckVisual() {
		WebElement ele1 = login.driver.findElement(
				By.xpath("//*[@class='background-control-container']/*[2]//span[@class='input-control--indicator']"));
		Boolean check_visual = ele1.isSelected();
		if (check_visual == false) {
			// check visual
			ele1.click();
		}
	}

	void BackGroundColor_Validation(String background_color) throws Exception {
		comm.ColorValidation(background_color);
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 6).click();
		CommonFunctionality.Views_list();
	}

	void FunctionSelection(String Function) throws Exception {
		CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='functions-input-container'])[1]", 3).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='current-function-input'])[1]//input", 4)
				.sendKeys(Function);
	}

	void getAppliedFunction() throws Exception {
		CommonFunctionality.wait(500);
		String function = login.driver.findElement(By.xpath("//*[@class='series-function-item--body']")).getText();
		Applied_function = function.replaceAll("\n", "");
		login.Log4j.info(Applied_function);
		CommonFunctionality
				.getElementByXpath(login.driver, "(//*[contains(@class,'series-functions-panel--icon__apply')])[1]", 5)
				.click();
	}

	void FunctionVerification(String SelectedFunction) throws Exception {
		CommonFunctionality.wait(1000);
		String Series = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='visual-series-name']//*[@class='series-name--title']", 5)
				.getText();
		login.Log4j.info(Series);
		if (Series.contains(SelectedFunction)) {
			login.Log4j.info(SelectedFunction + " is displayed in seres name");
			CommonFunctionality.Views_list();
		} else {
			Assert.fail(SelectedFunction + " Series is not displayed in series name");
		}
	}

	void FunctionVerification(String function1, String function2) throws Exception {
		CommonFunctionality.wait(1000);
		String Series = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='visual-series-name']//*[@class='series-name--title']", 10)
				.getText();
		login.Log4j.info(Series);
		if (Series.contains(function1) && Series.contains(function2)) {
			login.Log4j.info("Seleted function is displayed in seres name");
			try {
				//Close Edit Histogram window
				CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 8).click();
				CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 6).click();
			} catch(Exception e) {
				
			}
			CommonFunctionality.Views_list();
		} else {
			Assert.fail("Selected function is not displayed in series name");
		}
	}

	void RenamePopup(String Var, String movable_modal_action) throws Exception {
		login.Log4j.info(Var);
		if (!Var.equals(movable_modal_action)) {
			login.Log4j.info("The popup is " + Var);
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='movable-modal--header']/*[2]/*[@title='Close']", 5)
					.click();
			CommonFunctionality.Views_list();
		} else {
			Assert.fail("The popup is not " + Var);
		}
	}

	void ValidateEditSeriesFunctionality() throws Exception {
		String ExpectedValue = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='find-and-replace-item--name']//input", 5)
				.getAttribute("value");
		// close rename popup
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 4).click();
		String Series = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='visual-series-name']//*[@class='series-name--title']", 5)
				.getText();
		if (Series.contains(ExpectedValue)) {
			login.Log4j.info(ExpectedValue + " is displayed in seres name " + Series);
			CommonFunctionality.Views_list();
		} else {
			Assert.fail("Verification is failed");
		}
	}

	void SeriesByEditSeriesInfo(String ExpectedResult) throws Exception {
		try {
			CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'OK')]", 5).click();
		} catch (Exception e) {

		}
		String Series = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='visual-series-name']//*[@class='series-name--title']", 5)
				.getText();
		if (Series.contains(ExpectedResult)) {
			login.Log4j.info(ExpectedResult + " is displayed in seres name");
			try {
				//Close Edit Histogram window
				CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 8).click();
				CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 6).click();
			} catch(Exception e) {
				
			}
			CommonFunctionality.Views_list();
		} else {
			Assert.fail(ExpectedResult + " Series is not displayed in series name");
		}
	}

	void BeforeEditSeriesInfo(String EditSeriesInfo) throws Exception {
		BeforeEditSeries = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='find-and-replace-item--name']//input", 6)
				.getAttribute("value");
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='find-and-replace-item--name']//input", 5)
				.clear();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='find-and-replace-item--name']//input", 5)
				.sendKeys(EditSeriesInfo);
	}

	void CloseIconValidation() throws Throwable {
		CommonFunctionality.wait(1000);
		if (login.driver.findElements(By.xpath("//*[@class='movable-modal--window ui-resizable ui-draggable']"))
				.size() == 0) {
			login.Log4j.info("The popup is closed");
			CommonFunctionality.Views_list();
		} else {
			Assert.fail("The popup is not closed");
		}
	}

	void OriginalSeriesInfo(String BeforeEditSeriesInfo) throws Exception {
		String OriginalSeriesInfo = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='find-and-replace-item--name']//input", 5)
				.getAttribute("value");
		if (BeforeEditSeriesInfo.equals(OriginalSeriesInfo)) {
			login.Log4j.info("PASS");
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 6).click();
			try {
				// when some changes have not been saved popup appear
				CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 5).click();
			} catch (Exception e) {

			}
			CommonFunctionality.Views_list();
		} else {
			Assert.fail("Verification failed");
		}
	}

}