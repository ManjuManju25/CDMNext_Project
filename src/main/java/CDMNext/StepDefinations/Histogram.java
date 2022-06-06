package CDMNext.StepDefinations;

import static org.testng.Assert.fail;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
//import org.testng.AssertJUnit;

import CDMNext.util.CommonFunctionality;
import Javaxlxs.File_delete;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class Histogram {
	Actions action = new Actions(login.driver);
	DatabasesTab db = new DatabasesTab();
	SeriesTab St = new SeriesTab();
	Commentary comm = new Commentary();
	ChartVisual chart = new ChartVisual();
	String Applied_function, CurrencyFunction, MissingValueMethod,Applied_function1;
	JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	Commentary commentary = new Commentary();
	String Expected_sname, DailyFrequency,chnge_title;
	public static String Visual_Title_txt,ActualColor,TitleColor;
	public static String BeforeEditSeriesTitle,NewTemplate;
	WebElement SeriesCount;
	String SearchKeyword, BeforeAddingFunction, BeforeEditingFunction;
	String ReplaceKeyword, SeriesName, EditSeriesName;
	String EditRegion, EditUnit, EditFrequency,arg;
	String AddFunction, function, function1;
	String ChangeFunction, AggregateFunction, AccumulateFunction;
	List<String> BeforeEditSeries = new ArrayList<>();
	List<String> styles = new ArrayList<>();
	String SName, AutoTitle, SRegion,VisualTitle,EditSeries_function;
	List<String> ListOfalignmentValue = new ArrayList<>();
	String[] Sfrequency;
	String frequency;
	static int decimal_value;
	int histogramVisual_width;
	int size;
	public static String TooltiptextFormat;
	

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
	@And("^Create a empty visual$")
	public void create_a_empty_visual() throws Throwable {
		commentary.CreateViewTab();
		click_on_histogram_visual_icon();
	}
	@And("^Create a Histogram visual without selecting series$")
	public void create_a_Histogram_visual_without_selecting_series() throws Throwable {
		//CommonFunctionality.ResetMethod();
		CommonFunctionality.getElementByProperty(login.driver, "Search", 20).sendKeys("449520857");
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		commentary.CreateViewTab();
		click_on_histogram_visual_icon();
	}

	@Then("^The Edit histogram should be disabled$")
	public void the_Edit_histogram_should_be_disabled() throws Throwable {
		CommonFunctionality.wait(1000);
		Boolean Edit_histogram = login.driver
				.findElement(By.xpath("//button[@class='button button__sm button__primary']")).isEnabled();
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
		//close series harmonization popup if it is opened
		try {
			CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Close']", 20).click();
		} catch(Exception e) {
			
		}
		CommonFunctionality.wait(3000);
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Edit Series')]", 20).click();
	}

	@Then("^The Edit series panel should be opened$")
	public void the_Edit_series_panel_should_be_opened() throws Throwable {
		CommonFunctionality.wait(1000);
		WebElement series_panel = login.driver
				.findElement(By.xpath("//*[@class='sidebar-panel sidebar-panel__opened']"));
		if (series_panel.isDisplayed()) {
			login.Log4j.info("Edit series panel is opened");
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='sidebar-panel--header-close']", 5).click();
			
			if(login.driver.findElements(By.xpath("//*[@class='sidebar-panel sidebar-panel__opened']")).size() == 0) {
				login.Log4j.info("Edit series panel is closed");
			} else {
				Assert.fail("Edit seris panel is not closed");
			}
			
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
//				CommonFunctionality.getElementByXpath(login.driver, "//*[@class='sidebar-panel--header-close']", 5)
//						.click();
			} 
		} else {
			Assert.fail("User is not redirect to " + arg1);
		}
	}

	@And("^Add some series to my series$")
	public void add_some_series_to_my_series() throws Throwable {
		CommonFunctionality.wait(8000);
		CommonFunctionality.getElementByProperty(login.driver, "Series", 5).click();
		CommonFunctionality.wait(5000);
//		WebElement ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
//		AssertJUnit.assertNotNull(ul_element);
		List<WebElement> li_All = login.driver.findElements(By.xpath("//div[@class='series-representation--list']/*//*[@class='series-item--name']"));
		List<WebElement> checkBox = login.driver
				.findElements(By.xpath("//div[@class='series-representation--list']/*//div[@class='series-list-item--checkbox-wrapper']"));
		List<WebElement> li_AddIcon = login.driver.findElements(By.xpath("//div[@class='series-representation--list']/*//*[@class ='add-to-data-selection--icon']"));
		for (int i = 0; i < li_All.size(); i++) {
			CommonFunctionality.wait(300);
			checkBox.get(i).click();
			if (i == 2) {
				li_AddIcon.get(i).click();
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
		//CommonFunctionality.Views_list();
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
//		CommonFunctionality.ResetMethod();
		CommonFunctionality.getElementByProperty(login.driver, "Search", 20).sendKeys("210698402");
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 8).sendKeys(Keys.ENTER);
		CommonFunctionality.wait(10000);
		CommonFunctionality.getElementByProperty(login.driver, "Series", 20).click();
		CommonFunctionality.wait(6000);
		SName = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-item--name']", 10).getText();
		CommonFunctionality.wait(1500);
		SeriesCount = login.driver.findElement(By.xpath("//*[@class='series-series-count--number']"));
		CommonFunctionality.wait(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='add-to-data-selection--icon']", 30).click();
	}
	@And("^Click on Series name$")
	public void click_on_Series_name() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='preview-container']//*[@class='series-edit--title series-edit--title__editable']", 30).click();
	}
	@SuppressWarnings("deprecation")
	@And("^Apply function for a series$")
	public void apply_function_for_a_series() throws Throwable {
		String change_function = "%CHANGE()";
		CommonFunctionality.wait(3000);
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
		CommonFunctionality.wait(2000);
		WebElement sname = CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='series-name-field--series-name'])[1]",10);
		new Actions(login.driver).pause(1000).contextClick(sname).click().build().perform();
	}

	@And("^Select Histogram visual$")
	public void select_Histogram_visual() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@data-action='view_as']", 5).click();
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Histogram']", 5).click();
	}

	@Then("^The functions should be applied to the series$")
	public void the_functions_should_be_applied_to_the_series() throws Throwable {
		CommonFunctionality.wait(1000);
		WebElement function_ele = login.driver
				.findElement(By.xpath("//*[@class='visual-series-list']//*[@title='Functions']"));
		jse.executeScript("arguments[0].scrollIntoView(true);", function_ele);
		CommonFunctionality.wait(1000);
		String Function_txt = CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[@class='visual-series-panel--series']//*[@class='series-function-item--body']", 5)
				.getText();
		login.Log4j.info(Function_txt);

		if (Applied_function.equals(Function_txt)) {
			login.Log4j.info("The function is applied");
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='sidebar-panel--header-close']", 5).click();
			//CommonFunctionality.Views_list();
			//CommonFunctionality.ResetMethod();
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


@Then("^The series should be added to \"([^\"]*)\" with its data$")
public void the_series_should_be_added_to_with_its_data(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);
		Visual_Title_txt = login.driver.findElement(By.xpath("//*[@data-name='title']")).getText();
		if (Expected_sname.equals(Visual_Title_txt)) {
			login.Log4j.info("The selected series added to " + arg1 + "  visual from Add from My Series tab");
			//CommonFunctionality.getElementByXpath(login.driver, "//*[@class='sidebar-panel--header-close']", 5).click();
		//	CommonFunctionality.Views_list();
		} else {
			Assert.fail("The selected series not added to "+ arg1 + " visual");
		}
	}

	@And("^Create histogram visual with series$")
	public void create_histogram_visual_with_series() throws Throwable {
		commentary.CreateViewTab();
		click_on_histogram_visual_icon();
		CommonFunctionality.wait(4000);
		add_series_to_the_my_series_tab();
		CommonFunctionality.wait(6000);
		Visual_Title_txt = login.driver.findElement(By.xpath("//*[@data-name='title']")).getText();

	}

@And("^Create a new histogram visual$")
public void create_a_new_histogram_visual() throws Throwable {
	CommonFunctionality.wait(1000);
	CommonFunctionality.ResetMethod();
	create_a_Histogram_visual_without_selecting_series();
	CommonFunctionality.getElementByXpath(login.driver, "//*[@class='add-to-data-selection--icon']", 20).click();
}
	@Then("^Edit series panel should be opened with \"([^\"]*)\" tab$")
	public void edit_series_panel_should_be_opened_with_tab(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);
		String ExpectedTxt = login.driver
				.findElement(By.xpath("//*[@class='sidebar-panel--tab sidebar-panel--tab__active']")).getText();
		if (arg1.equals(ExpectedTxt)) {
			login.Log4j.info("Edit seriespanel is opened with " + arg1 + " tab");
		//	CommonFunctionality.Views_list();
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
			//CommonFunctionality.Views_list();
		} else {
			Assert.fail("Verification failed");
		}
	}

	@Then("^Number of selected series count should be shown on the rename popup header$")
	public void number_of_selected_series_count_should_be_shown_on_the_rename_popup_header() throws Throwable {
		CommonFunctionality.wait(1300);
		WebElement str = login.driver.findElement(By.xpath("//*[@class='find-and-replace--modal-title-info']"));
		login.Log4j.info(str.getText());
		
		try {
			login.Log4j.info(SeriesCount.getText());
		if (str.getText().contains(SeriesCount.getText())) {
			login.Log4j.info("Number of selected series count is shown on the rename popup header");
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 6).click();
			//CommonFunctionality.Views_list();
		} else {
			Assert.fail("Number of selected series count is not shown on the rename popup header");
		}
		}catch(Exception e) {
			login.Log4j.info(Map.SeriesCount.getText());
			if (str.getText().contains(Map.SeriesCount.getText())) {
				login.Log4j.info("Number of selected series count is shown on the rename popup header");
				CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 6).click();
				//CommonFunctionality.Views_list();
			} else {
				Assert.fail("Number of selected series count is not shown on the rename popup header");
			}
		}
	}

	@And("^Search for the series you want to rename$")
	public void search_for_the_series_you_want_to_rename() throws Throwable {
		SearchKeyword = "GROSS";
		CommonFunctionality.wait(200);
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='find-and-replace--panel-search-box']/*[1]", 6)
				.sendKeys(SearchKeyword);
	}

@And("^Search with invalid series name$")
public void search_with_invalid_series_name() throws Throwable {
	SearchKeyword = "XYZ";
	CommonFunctionality.wait(200);
	CommonFunctionality
			.getElementByXpath(login.driver, "//*[@class='find-and-replace--panel-search-box']/*[1]", 6)
			.sendKeys(SearchKeyword);
}

@Then("^\"([^\"]*)\" should be displayed under the find field$")
public void should_be_displayed_under_the_find_field(String arg1) throws Throwable {
	CommonFunctionality.wait(1000);
	WebElement No_matches_found = login.driver
			.findElement(By.xpath("//*[@class='find-and-replace--panel-no-matches']"));
	if(No_matches_found.isDisplayed()) {
		if(No_matches_found.getText().equalsIgnoreCase(arg1)) {
			login.Log4j.info(arg1+" is displayed");
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 4).click();
		} else {
			Assert.fail(arg1 + " is not displayed for invalid series name");
		}
	}
	
}

	@Then("^Result should be loaded for searched keyword$")
	public void result_should_be_loaded_for_searched_keyword() throws Throwable {
		CommonFunctionality.wait(1000);
		WebElement SearchResult = login.driver
				.findElement(By.xpath("//*[@class='find-and-replace-item--name']//input"));
		if (SearchResult.isDisplayed()) {
			if (SearchResult.getAttribute("value").toUpperCase().contains(SearchKeyword)) {
				login.Log4j.info("Result is loaded for searched keyword");
				CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 4).click();
				//CommonFunctionality.Views_list();
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
		//	CommonFunctionality.Views_list();
		} else {
			Assert.fail("The total number of matches result is not displayed");
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
//			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 4).click();
//			CommonFunctionality.getElementByXpath(login.driver,
//					"//*[@class='sphere-modal-controls']//button[contains(text(),'Ok')]", 5).click();
			//CommonFunctionality.Views_list();
		} else {
			Assert.fail("Verification is failed");
		}
	}

	/*@Then("^All the available series should be replaced with the keyword$")
	public void all_the_available_series_should_be_replaced_with_the_keyword() throws Throwable {
		//the_keyword_should_be_replaced_for_selected_series();
	}*/

	@Then("^By default \"([^\"]*)\" should be selected in Edit series info dropdown$")
	public void by_default_should_be_selected_in_Edit_series_info_dropdown(String arg1) throws Throwable {
		String Expectedstr = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='find-and-replace--attribute-selector']//option[@value='name']", 6).getText();
		login.Log4j.info(Expectedstr.trim());
		if (arg1.equals(Expectedstr.trim())) {
			login.Log4j.info("By default " + arg1 + " is selected");
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 4).click();
			//CommonFunctionality.Views_list();
		} else {
			Assert.fail("Verification is failed");
		}
	}

	@And("^Click on Edit series info dropdown$")
	public void click_on_Edit_series_info_dropdown() throws Throwable {
		CommonFunctionality.wait(500);
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
			//CommonFunctionality.Views_list();
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
				"//*[@class='movable-modal--window ui-resizable ui-draggable']", 5);

		if (SSP_window.isDisplayed()) {
			login.Log4j.info("The SSP window is displayed");
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 4).click();
			//CommonFunctionality.Views_list();
		} else {
			Assert.fail("The SSP window is not displayed");
		}
	}

	@And("^Edit series title$")
	public void edit_series_title() throws Throwable {
		EditSeriesName = "No of Passengers";
		CommonFunctionality.wait(500);
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
				.findElement(By.xpath("//*[contains(text(),'Auto name')]/preceding-sibling::input")).isSelected();
		if (AutoName_checkBox == true) {
			login.Log4j.info("Auto name check box is selected by default");
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 6).click();
			//CommonFunctionality.Views_list();
		} else {
			Assert.fail("Auto name check box is not selected by default");
		}
	}

	@And("^Select multiple attributes$")
	public void select_multiple_attributes() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='multi-select-config']//ul//li[@class='select2-search-field']", 5).click();
		CommonFunctionality.getElementByXpath(login.driver, "//ul[@class='select2-results']//div[contains(text(),'Region')]", 4)
				.click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='multi-select-config']//ul//li[@class='select2-search-field']", 5).click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//ul[@class='select2-results']//div[contains(text(),'Unit')]", 4)
				.click();

	}

	@Then("^Selected attributes should be displayed as series name$")
	public void selected_attributes_should_be_displayed_as_series_name() throws Throwable {
		String RegionAttribute = CommonFunctionality.getElementByXpath(login.driver,"//div[@class='visual-series-panel--series']//div[@class='table']/*[1]/*[2]/*[4]", 6).getAttribute("title");
		String UnitAttribute = CommonFunctionality
				.getElementByXpath(login.driver,
						"//div[@class='visual-series-panel--series']//div[@class='table']/*[1]/*[2]/*[8]/*[1]", 6)
				.getAttribute("title");
		
		String Series = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='visual-series-name']//*[@class='series-name--title']", 5)
				.getText();
		if (Series.contains(RegionAttribute) && Series.contains(UnitAttribute)) {
			login.Log4j.info(RegionAttribute + " AND " + UnitAttribute + " is displayed in seres name " + Series);
			//CommonFunctionality.Views_list();
		} else {
			Assert.fail("Verification is failed");
		}
	//	CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 6).click();
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
			//CommonFunctionality.Views_list();
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
		// FunctionVerification(Applied_function);
		CommonFunctionality.wait(2000);
		List<WebElement> snames = login.driver
				.findElements(By.xpath("//*[@class='visual-series-name']//*[@class='series-name--title']"));

		for (int i = 0; i < snames.size(); i++) {
			CommonFunctionality.wait(500);
			String Series = snames.get(i).getText();
			login.Log4j.info(Series);
			if (!Series.contains(Applied_function)) {
				Assert.fail(Applied_function + " Series is not displayed in series name");

			}
		}

		login.Log4j.info(Applied_function + " is displayed in all seres name");

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
		//FunctionVerification(Applied_function);
		CommonFunctionality.wait(3000);
		List<WebElement> snames = login.driver
				.findElements(By.xpath("//*[@class='visual-series-name']//*[@class='series-name--title']"));

		for (int i = 0; i < snames.size(); i++) {
			CommonFunctionality.wait(500);
			String Series = snames.get(i).getText();
			login.Log4j.info(Series);
			if (!Series.contains(Applied_function)) {
				Assert.fail(Applied_function + " Series is not displayed in series name");

			}
		}

		login.Log4j.info(Applied_function + " is displayed in all seres name");
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
				"//*[@title='More functions']//*[contains(@class,'insight-action-panel--btn-popup')]", 8).click();
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

	@SuppressWarnings("deprecation")
	@And("^Select a series from My series tab$")
	public void select_a_series_from_My_series_tab() throws Throwable {
	    CommonFunctionality.wait(2000);
	    try {
	    	WebElement series = login.driver.findElement(By.xpath("//*[@class='series-name-wrapper ']"));
	    	if(series.isDisplayed()) {
	    		SeriesName = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-name-wrapper ']//*[@class='series-name-field--series-name']", 20).getText();
	    		WebElement checkbox = login.driver.findElement(By.xpath("//*[@class='series-name-wrapper ']/*[1]"));
	    		new Actions(login.driver).pause(700).moveToElement(checkbox).click().perform();
	    	}
	    	
	    } catch(Exception e) {
	    	e.getMessage();
	    }
	}

	@Then("^The added series should be displayed in histogram tab$")
	public void the_added_series_should_be_displayed_in_histogram_tab() throws Throwable {
		CommonFunctionality.wait(1200);
		String Expected_SeriesName = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-name--title']", 20).getText();
		if(SeriesName.equalsIgnoreCase(Expected_SeriesName)) {
			login.Log4j.info("The added series is displayed in Histogram tab");
		} else {
			Assert.fail("The added series from My series tab is not displayed in Histogram tab");
		}
	}

	@Then("^The series should be removed from the visual and edit series panel$")
	public void the_series_should_be_removed_from_the_visual_and_edit_series_panel() throws Throwable {
		CommonFunctionality.wait(700);
		// series removed from edit series panel
		if (login.driver.findElements(By.xpath("//*[@class='series-name--title']")).size() == 0) {
			// if series removed from the visual, empty visual should be displayed
			if(login.driver.findElement(By.xpath("//*[@class='empty-visual-overlay--content']")).isDisplayed()) {
				login.Log4j.info("The series is removed from the visual and edit series panel");
			} else {
				Assert.fail("The series is not removed from the visual and edit series panel");
			}
			/*// Compare visual text before delete series and after delete series
			String AfterDeleteSeries = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='title']", 6)
					.getText();
			try {
			if (!Visual_Title_txt.equals(AfterDeleteSeries)) {
				login.Log4j.info("The series is removed from the visual and edit series panel");
			}
			}catch(Exception e) {
				if(!PieVisual.Visual_Title_txt.equals(AfterDeleteSeries)) {
				login.Log4j.info("The series is removed from the visual and edit series panel");
				}else {
				Assert.fail("The series is not removed from the visual and edit series panel");
				}
			}*/
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
			//CommonFunctionality.Views_list();
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
		//	CommonFunctionality.Views_list();

		} else {
			Assert.fail("Rename popup is not displayed");
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Click on edit series icon$")
	public void click_on_edit_series_icon() throws Throwable {
		CommonFunctionality.wait(3000);
		WebElement function = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='insight-series-settings']//*[@class='table']//*[@title='Edit series'] | //*[@class='movable-modal--body']//*[@class='table']//*[@title='Edit series']", 10);
		new Actions(login.driver).pause(1000).moveToElement(function).build().perform();
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
		String[] expectedFunction;
		try {
		 expectedFunction = function.split("\\(");
		}catch(NullPointerException e) {
			expectedFunction = DatabasesTab.function.split("\\(");
		}
		login.Log4j.info(expectedFunction[0].trim());
		login.Log4j.info(expectedFunction[1].replaceAll("\\)", ""));
		FunctionVerification(expectedFunction[0].trim(), expectedFunction[1].replaceAll("\\)", ""));

	}

	@SuppressWarnings("static-access")
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

	@SuppressWarnings("static-access")
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
		List<WebElement> listOfFrequencies = login.driver.findElements(By.xpath("//*[contains(@class,'change-series-function--menu')]//li"));
		if(listOfFrequencies.size() > 0) {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='items-wrapper']//li//span[contains(text(),'" + arg1 + "')]", 8).click();
		} else {
			fail("List of frequencies not shown in the frequency dropdown");
		}
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
		List<WebElement> table_columns = login.driver.findElements(By.xpath("//*[@class='table']/*/*[2]/*"));
		WebElement currency = null;
		if(table_columns.size() == 9) {
			currency =CommonFunctionality.getElementByXpath(login.driver, "//*[@class='table']/*[5]/*[2]/*[1]", 30);
		} else if(table_columns.size() == 8) {
			currency =CommonFunctionality.getElementByXpath(login.driver, "//*[@class='table']/*[4]/*[2]/*[1]", 30);
		}else if(table_columns.size() == 10) {
			currency = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='table']/*/*[2]/*[6]/*", 30);
		} else if(table_columns.size() == 11) {
			currency = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='table']/*/*[2]/*[7]/*", 30);
		}
		jse.executeScript("arguments[0].scrollIntoView(true);",currency);
		CommonFunctionality.wait(700);
		currency.click();

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
		CommonFunctionality.wait(1500);
		WebElement ele = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='table']/*[1]/*[2]/*//input[@placeholder='" + arg1 + "']", 10);
		jse.executeScript("arguments[0].scrollIntoView(true);", ele);
		ele.click();

	}

	@And("^Select \"([^\"]*)\" function$")
	public void select_function(String arg1) throws Throwable {
		function = arg1;

		CommonFunctionality.wait(300);
		List<WebElement> ListOfTypeFunctions = login.driver.findElements(By.xpath("//*[@class='suggestions_list select-list']//li"));
		if(ListOfTypeFunctions.size() > 0) {
			login.Log4j.info("List of function dropdown has been opened");
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='suggestions_list select-list']//li[contains(text(),'" + arg1 + "')]", 8).click();
		}else {
			fail("List of function dropdown has not been opened");
		}
		
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
		Boolean funciton_removed = login.driver.findElement(By.xpath("//*[@class='current-function-input--body' and not(@class='series-function-item--body')]")).isDisplayed();
				
		if (funciton_removed == true) {
			login.Log4j.info("Applied function is removed successfully");
			
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
		//	CommonFunctionality.Views_list();
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
		CommonFunctionality.wait(2000);
		Boolean Region = login.driver.findElement(By.xpath("//table//*[@class='table--row'][1]/*[2]/*"))
				.isDisplayed();
		Boolean Unit = login.driver.findElement(By.xpath("//table//*[@class='table--row'][1]/*[6]/*"))
				.isDisplayed();
		Boolean SeriesID = login.driver.findElement(By.xpath("//table//*[@class='table--row'][1]/*[7]/*"))
				.isDisplayed();
		if (Region == true && Unit == true && SeriesID == true) {
			login.Log4j.info(arg1 + "," + arg2 + " AND " + arg3 + " fields are available for respective series");
			try {
				//Close Edit Histogram window
				CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 8).click();
				CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 6).click();
			} catch(Exception e) {
			 
				
			}
		//	CommonFunctionality.Views_list();
		} else {
			Assert.fail("Verification failed");
		}
	}

@Then("^Submit and Cancel buttons should be disabled by default$")
public void submit_and_Cancel_buttons_should_be_disabled_by_default() throws Throwable {
	CommonFunctionality.wait(500);
	boolean cancel = login.driver.findElement(By.xpath("//*[@class='feedback--footer']/*[1]")).getAttribute("class").contains("disabled");
	boolean submit = login.driver.findElement(By.xpath("//*[@class='feedback--footer']/*[2]")).getAttribute("class").contains("disabled");
	if(cancel == true && submit == true) {
		login.Log4j.info("Cancel and Submit buttons are disabled by default");
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='modal-window modal-window__active']//*[@class='sphere-modal__close']", 6).click();
	} else {
		Assert.fail("Cancel and Submit buttons are not disabled by default");
	}
}

@Then("^Verify right click options for histogram visual$")
public void verify_right_click_options_for_histogram_visual() throws Throwable {
		String[] exp = { "Copy histogram", "Cut histogram", "Delete histogram", "Insert visual", "Paste visual",
				"View as", "Calculate series", "Edit series", "Clear contents", "Reset format", "Download" };
		List<WebElement> rightclickoptions = login.driver
				.findElements(By.xpath("//*[@class='items-wrapper']/li/span[not(contains(@class,'dropdown-submenu-icon'))]"));
		DropdownOptions(exp,rightclickoptions);
	
}

@Then("^Verify insert visual sub dropdown options for histogram visual$")
public void verify_insert_visual_sub_dropdown_options_for_histogram_visual() throws Throwable {
	CommonFunctionality.getElementByProperty(login.driver, "Table_rightclick_insertvisual",8).click();
	String[] exp = { "Chart", "Pie", "Scatter", "Table", "Map", "Heat map",
			"Histogram", "Commentary", "Attachments", "Image", "Filter"};
	List<WebElement> insertvisualoptions = login.driver
			.findElements(By.xpath("//li[@class='dropdown-submenu active-menu-item']/ul/li/span"));
	DropdownOptions(exp,insertvisualoptions);
}
@Then("^Verify View as sub dropdown options for histogram visual$")
public void verify_View_as_sub_dropdown_options_for_histogram_visual() throws Throwable {
	CommonFunctionality.getElementByProperty(login.driver, "Table_rightclick_viewas",8).click();
	String[] exp = { "Chart", "Map","Table", "Pie", "Heat map"};
	List<WebElement> viewas_options = login.driver
			.findElements(By.xpath("//li[@class='dropdown-submenu active-menu-item']/ul/li/span"));
	DropdownOptions(exp,viewas_options);
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
		//		CommonFunctionality.Views_list();
			} else {
				Assert.fail("Verification failed");
			}
		}

	}

	@And("^Mouse hover on visual title$")
	public void mouse_hover_on_visual_title() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement ele = login.driver.findElement(By.xpath("//*[@data-name='title']"));
		new Actions(login.driver).moveToElement(ele).build().perform();
	}

	@And("^Click on edit icon$")
	public void click_on_edit_icon() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Edit visual title']", 6).click();
	}
	@And("^Mouse hover on visual title for Edit visual popup$")
	public void mouse_hover_on_visual_title_for_Edit_visual_popup() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement ele = login.driver.findElement(By.xpath("//*[@class='visual-configuration']//*[@data-name='title']"));
		new Actions(login.driver).moveToElement(ele).build().perform();
	}

	@And("^Click on edit icon for Edit visual popup$")
	public void click_on_edit_icon_for_Edit_visual_popup() throws Throwable {
		
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--body']//*[@class='visual-title--text text-dots']//following-sibling::* ", 6).click();
	}

	@SuppressWarnings("deprecation")
	@And("^Double click on the visual title$")
	public void double_click_on_the_visual_title() throws Throwable {
		WebElement title = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='title']", 4);
		new Actions(login.driver).pause(300).doubleClick(title).build().perform();
	}

	@Then("^Visual legend \"([^\"]*)\" and \"([^\"]*)\" should be displayed$")
	public void visual_legend_and_should_be_displayed(String arg1, String arg2) throws Throwable {
		String series = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='highcharts-legend highcharts-no-tooltip']/*[2]/*[1]/*[1]/*[3]", 6).getText();
		String histogram = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='highcharts-legend highcharts-no-tooltip']/*/*[1]/*[2]/*[1]", 6).getText();
		if (arg1.equalsIgnoreCase(series) && arg2.equalsIgnoreCase(histogram)) {
			login.Log4j.info("Visual legend " + arg1 + " AND " + arg2 + " is displayed");
		//	CommonFunctionality.Views_list();
		} else {
			Assert.fail(arg1 + " AND " + arg2 + " is not displayed");
		}
	}

	@And("^Click on series legend$")
	public void click_on_series_legend() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='highcharts-legend highcharts-no-tooltip']/*[2]/*[1]/*[1]/*[3]", 6).click();
	}

	@Then("^Series data should be hidden from the visual$")
	public void series_data_should_be_hidden_from_the_visual() throws Throwable {
		WebElement SeriesEle = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='highcharts-legend highcharts-no-tooltip']/*[2]/*[1]/*[1]", 6);
		if (SeriesEle.getAttribute("class").contains("highcharts-legend-item-hidden")) {
			login.Log4j.info("Series data is hidden from the visual");
		//	CommonFunctionality.Views_list();
		} else {
			Assert.fail("Series data is not hidden");
		}
	}

	@And("^Click on Histogram legend$")
	public void click_on_Histogram_legend() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='highcharts-legend highcharts-no-tooltip']/*/*[1]/*[2]/*[1]", 6)
				.click();
	}

	@Then("^The Histogram data should be hidden from visual$")
	public void the_Histogram_data_should_be_hidden_from_visual() throws Throwable {
		WebElement HistogramEle = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='highcharts-legend highcharts-no-tooltip']/*/*[1]/*[2]", 6);
		if (HistogramEle.getAttribute("class").contains("highcharts-legend-item-hidden")) {
			login.Log4j.info("The histogram data is hidden from the visual");
		//	CommonFunctionality.Views_list();
		} else {
			Assert.fail("The Histogram data is not hidden");
		}
	}

	@And("^Again click on the same$")
	public void again_click_on_the_same() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='highcharts-legend highcharts-no-tooltip']/*[2]/*[1]/*[1]/*[3]", 6)
				.click();
	}

	@Then("^The legend should be enabled$")
	public void the_legend_should_be_enabled() throws Throwable {
		CommonFunctionality.wait(800);
		Boolean legend = login.driver.findElement(By.xpath("//*[@class='highcharts-legend highcharts-no-tooltip']/*[2]/*[1]/*[1]/*[3]"))
				.isEnabled();
		if (legend == true) {
			login.Log4j.info("The legend is enabled");
		//	CommonFunctionality.Views_list();
		} else {
			Assert.fail("The legend is not enabled");
		}
	}

@Then("^Should disable only \"([^\"]*)\" legend$")
public void should_disable_only_legend(String arg1) throws Throwable {
	WebElement legend_series = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='highcharts-legend highcharts-no-tooltip']/*[2]/*[1]/*[1]", 20);
	WebElement legend_histogram = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='highcharts-legend highcharts-no-tooltip']/*/*[1]/*[2]", 20);
    if(arg1.equalsIgnoreCase("Series")) {
    	CommonFunctionality.wait(800);
    	if(legend_series.getAttribute("class").contains("highcharts-legend-item-hidden") && !legend_histogram.getAttribute("class").contains("highcharts-legend-item-hidden")) {
    		login.Log4j.info("disable only "+ arg1+ " legend");
    	} else {
    		Assert.fail("Not enable histogram legend");
    	}
    } else if(arg1.equalsIgnoreCase("Histogram")) {
    	CommonFunctionality.wait(800);
    	if(!legend_series.getAttribute("class").contains("highcharts-legend-item-hidden") && legend_histogram.getAttribute("class").contains("highcharts-legend-item-hidden")) {
    		login.Log4j.info("disable only "+ arg1+ " legend");
    	} else {
    		Assert.fail("Not enable series legend");
    	}
    }
}
@SuppressWarnings("deprecation")
@And("^Mouse hover on existing visual templates$")
public void mouse_hover_on_existing_visual_templates() throws Throwable {
	 arg = "NewTemplate";
	 WebElement add_template = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'add-style-template')]", 8);
		
		try {
			//if add icon is active
			if (add_template.getAttribute("class").contains("add-style-template__active")) {
				add_template.click();
				enter_new_template_name_as(arg);
				click_on_green_tick_mark();
				//if template already exists with the same name
				try {
					CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 20).click();
				} catch(Exception e) {
					
				}
			
				make_any_changes();
				
			} else {
				make_any_changes();
				add_template.click();
				enter_new_template_name_as(arg);
				click_on_green_tick_mark();
				//if template already exists with the same name
				try {
					CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 20).click();
				} catch(Exception e) {
					
				}
				
			}
		} catch(Exception e) {
			
		}	
					
	WebElement template = CommonFunctionality.getElementByXpath(login.driver, "(//*[@title='" + arg + "'])[2]", 20);
	new Actions(login.driver).pause(500).moveToElement(template).build().perform();
}

@And("^Click on template dropdown$")
public void click_on_template_dropdown() throws Throwable {
	CommonFunctionality.getElementByXpath(login.driver, "//*[@title='NewTemplate']//*[@class='style-templates-item--tongue']", 10).click();
	
}

@SuppressWarnings("deprecation")
@And("^Check the box for \"([^\"]*)\"$")
public void check_the_box_for(String arg1) throws Throwable {
	WebElement set = CommonFunctionality.getElementByXpath(login.driver,"//*[contains(text(),'" + arg1 + "')]/preceding-sibling::span", 6);
	Boolean select = CommonFunctionality
			.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]/preceding-sibling::span", 4)
			.isSelected();
	if (select != true) {
		new Actions(login.driver).moveToElement(set).pause(2000).click().build().perform();
	
	} else {
		System.out.println("The checkbox is checked already");
	}
}

@Then("^The Histogram should be created with the format of previous template selection$")
public void the_Histogram_should_be_created_with_the_format_of_previous_template_selection() throws Throwable {
	//if show series checkbox off
	data_of_series_should_be_removed_from_the_visual();
}
@SuppressWarnings("deprecation")
@And("^Check the box for \"([^\"]*)\" should be unchecked$")
public void check_the_box_for_should_be_unchecked(String arg1) throws Throwable {
	WebElement set = CommonFunctionality.getElementByXpath(login.driver,
			"//*[contains(text(),'" + arg1 + "')]/preceding-sibling::span", 6);
//	boolean select = CommonFunctionality
//			.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']/preceding-sibling::span", 4)
//			.isSelected();
//	WebElement set = CommonFunctionality.getElementByXpath(login.driver,
//			"//*[@class='favorite-template-checkbox']//*[@class='input-control input-control__sm']//input[@type='checkbox']", 6);
	boolean select = login.driver.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]/preceding-sibling::input")).isSelected();
	if (select == true) {
		new Actions(login.driver).moveToElement(set).pause(1000).click().build().perform();
	
	} else {
		System.out.println("The checkbox is unchecked");
	}
}
@Then("^The bold icon should be selected by default$")
public void the_bold_icon_should_be_selected_by_default() throws Throwable {
	CommonFunctionality.wait(1000);
	if(login.driver.findElement(By.xpath("//*[@class='accordion-config ']//*[@class='font-style']/*[1]")).getAttribute("class").contains("font-bold selected")) {
		login.Log4j.info("The bold icon is selected by default");
	} else {
		Assert.fail("The bold icon is not selected by default");
	}
} 

@Then("^The Histogram should be created with default format template$")
public void the_Histogram_should_be_created_with_default_format_template() throws Throwable {
	data_of_series_should_be_shown_on_the_visual();
	St.click_on("Edit Histogram");
	db.click_on_icon("Delete template");
	CommonFunctionality.getElementByXpath(login.driver,"//*[@class='modal-window modal-window__active']//*[contains(text(),'Ok')]", 20).click();
	St.click_on("Save");
	
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
			//Assert.fail("Show check box is not selected");
		}
	}

	@And("^Check Show Series$")
	public void check_Show_Series() throws Throwable {
		CheckShowSeries();
	}

	@And("^Click on create template icon$")
	public void click_on_create_template_icon() throws Throwable {
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='style-templates-menu--add']", 10)
				.click();
		try {
			boolean templatePopup = login.driver.findElement(By.xpath("//*[@class='add-template-context']")).isDisplayed();
			if(templatePopup == true) {
				login.Log4j.info("Template popup is opened");
			} 
		} catch(NoSuchElementException e) {
		fail("Template popup is not opened");
		}
	}

	@And("^Enter new template name as \"([^\"]*)\"$")
	public void enter_new_template_name_as(String arg1) throws Throwable {
		NewTemplate = arg1;
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//input[@class='add-template-context--input form--control form--control__sm']", 10)
				.sendKeys(NewTemplate);

	}
	@And("^UnCheck Show Series$")
	public void uncheck_Show_Series() throws Throwable {
		make_any_changes();
	}

	@And("^Click on green tick mark$")
	public void click_on_green_tick_mark() throws Throwable {
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(@class,'add-template-context--icon__apply')]", 10)
			.click();
		try {
		//if already template exists click on ok in confirmation popup
		
		CommonFunctionality
		.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 10)
		.click();
		}catch(Exception e) {
			
		}
	
	}

	@Then("^New template should be created with the name of \"([^\"]*)\"$")
	public void new_template_should_be_created_with_the_name_of(String CreatedTemplate) throws Throwable {
		String actualTemplateName = CommonFunctionality
				.getElementByXpath(login.driver,
						"//div[@class='style-templates-item--icon style-templates-item--icon__text']", 10)
				.getAttribute("title");
		Assert.assertEquals(actualTemplateName, CreatedTemplate);
		login.Log4j.info("New template is created as "+ actualTemplateName);
		// save the changes
		CommonFunctionality.wait(2000);
		try {
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'movable-modal__active')]//button[contains(text(),'Save')]", 8).click();
		}catch(Exception e) {
			CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Save')]", 8).click();
		}
		//check series should not be displayed in the selected/created template of the visual
		CommonFunctionality.wait(1000);
		
		 if(login.driver.findElements(By.xpath("//*[@class='highcharts-legend-item highcharts-scatter-series highcharts-color-undefined highcharts-series-0']")).size() == 0) {
			 login.Log4j.info("Series is not displayed in the visual which is unchecked");
		 } else {
			 fail("Series is displayed");
		 }
		 try {
		 St.click_on("Edit Map");
		 }catch(Exception e) {
			 try {
				 St.click_on("Edit Pie");
			 } catch(Exception e1) {
				 St.click_on("Edit Histogram");
			 }
		 }
		db.click_on_icon("Delete template");
		St.click_on("Ok");
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
//		CommonFunctionality
//				.getElementByXpath(login.driver, "//button[@class='sphere-modal-control button button__primary']", 10)
//				.click();
//		CommonFunctionality.Views_list();
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
	//	CommonFunctionality.Views_list();
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
		CommonFunctionality.wait(500);
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
				CommonFunctionality.wait(300);
				if (login.driver.findElement(By.xpath(
						"//*[@class='style-templates-context']/*[2]//*[@class='style-templates-context--section-heading']"))
						.isDisplayed()) {
					login.Log4j.info("My style template is available");
				} else {
					Assert.fail("My Style template is not available");
				}
			}
		}
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
	//	CommonFunctionality.Views_list();
	}

	@Then("^The description should be \"([^\"]*)\" diaplayed$")
	public void the_description_should_be_diaplayed(String discription) throws Throwable {
		CommonFunctionality.wait(1000);
		Assert.assertEquals(login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']"))
				.getText().contains(discription), true);
		
		// Close confirmation popup
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 10).click();
		db.click_on_icon("Delete template");
		St.click_on("Ok");
//		// Close Edit visual window
//		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
//		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 10).click();
//		CommonFunctionality.Views_list();
	}

	@Then("^The template should be deleted from the list$")
	public void the_template_should_be_deleted_from_the_list() throws Throwable {
		
		if (login.driver
				.findElements(By.xpath("//div[@class='style-templates-item--icon style-templates-item--icon__text']"))
				.size() == 0) {
			login.Log4j.info("The template is deleted by clicking on OK button");
		} else if (login.driver
				.findElements(By.xpath("//div[@class='style-templates-item--icon style-templates-item--icon__text']"))
				.size() != 0) {
			if (!login.driver
					.findElement(
							By.xpath("//div[@class='style-templates-item--icon style-templates-item--icon__text']"))
					.getAttribute("title").contains(NewTemplate)) {
				login.Log4j.info("The template is deleted by clicking on OK button");
			} else {
				Assert.fail("The template is not deleted by clicking on OK button");
			}
		}
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		St.click_on("Ok");
		//CommonFunctionality.Views_list();

	}

	@Then("^The confirmation popup should be closed$")
	public void the_confirmation_popup_should_be_closed() throws Throwable {
		if (login.driver.findElements(By.xpath("//div[@class='modal-content sphere-modal__content']")).size() == 0) {
			login.Log4j.info("The confirmation popup is closed by clicking on Cancel button");
		} else {
			Assert.fail("The confirmation popup is not closed by clicking on Cancel button");
		}
		db.click_on_icon("Delete template");
		St.click_on("Ok");
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		St.click_on("Ok");
		//CommonFunctionality.Views_list();
	}

	@And("^Click on Border drop down$")
	public void click_on_Border_drop_down() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='style-container--controls']//div[2]//div[2]//div[1]//div[2]", 8).click();
	}

	@And("^Check Histogram$")
	public void check_Histogram() throws Throwable {

		WebElement Histogram_checkbox = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='background-control-container']//*[contains(@class,'plot-background-control')]//label//input",
				10);
		boolean checkbox = Histogram_checkbox.isSelected();
		if (checkbox == false) {
			new Actions(login.driver).moveToElement(Histogram_checkbox).click().perform();
		}
	}

	@And("^Select color$")
	public void select_color() throws Throwable {
	
		CommonFunctionality.getElementByProperty(login.driver,	"Border_colorPickerControl", 10).click();
		WebElement ColorEle = CommonFunctionality.getElementByProperty(login.driver, "BlueColor", 20);
		ActualColor = ColorEle.getCssValue("background-color");
		ColorEle.click();
		
	}

//	@Then("^Border should be displayed for histogram with selected color$")
//	public void border_should_be_displayed_for_histogram_with_selected_color() throws Throwable {
	@Then("^Border should be displayed for \"([^\"]*)\" with selected color$")
	public void border_should_be_displayed_for_with_selected_color(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		String border_color = CommonFunctionality
				.getElementByXpath(login.driver, "(//*[@class='highcharts-plot-border'])[5]", 6).getCssValue("stroke");
		
		Commentary.ColorValidation(border_color,ActualColor);
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 6).click();
//		CommonFunctionality.Views_list();
	}

	@And("^Select Width to (\\d+)$")
	public void select_Width_to(int width) throws Throwable {
		//String BorderWidth;
		CommonFunctionality.wait(500);
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
			Thread.sleep(300);

			login.driver.findElement(By.xpath(
					"(//*[@class='border-settings--container']//div[@class='spinner-control' and (not(@class='spinner-control disabled'))])[1]//button[contains(@class,'ui-spinner-up')]"))
					.click();

		}
	}

	@Then("^The histogram border \"([^\"]*)\" should be updated to \"([^\"]*)\"$")
	public void the_histogram_border_should_be_updated_to(String arg1, String arg2) throws Throwable {
	Thread.sleep(2000);
		if (arg1.equals("Width")) {
			String ActualWidth;
			ActualWidth = login.driver
					.findElement(By.xpath("//*[@class='visual-preview base-preview']//*[@class='highcharts-plot-border']"))
					.getCssValue("stroke-width");
			login.Log4j.info(ActualWidth);
			comm.FontSizeValidation(ActualWidth, arg2);
		}
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 6).click();
//		CommonFunctionality.Views_list();
	}
	
	@SuppressWarnings({ "deprecation", "unused" })
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
//		CommonFunctionality.Views_list();
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
//		CommonFunctionality.Views_list();
	}

	@And("^Check Visual check box$")
	public void check_Visual_check_box() throws Throwable {
		CommonFunctionality.wait(3000);
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
				.findElement(By.xpath("//div[@class='visual-preview base-preview']//div[@class='visual-item-container']"))
				.getAttribute("style").contains("border")) {
			login.Log4j.info("Visual border is displayed by checking visual");
		} else {
			Assert.fail("Visual border is not displayed by checking visual");
		}

		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 6).click();
//		CommonFunctionality.Views_list();
	}

	@And("^Select color for Visual$")
	public void select_color_for_Visual() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver,"Border_colorPickerControl", 6).click();
		WebElement ColorEle = CommonFunctionality.getElementByProperty(login.driver, "OrangeColor" , 8);
		ActualColor = ColorEle.getCssValue("background-color");
		ColorEle.click();
	}

	@Then("^Border should be displayed for visual with selected color$")
	public void border_should_be_displayed_for_visual_with_selected_color() throws Throwable {
		CommonFunctionality.wait(2000);
		String border_color = CommonFunctionality
				.getElementByXpath(login.driver,
						"//div[@class='visual-preview base-preview']//div[@class='visual-item-container']", 6)
				.getCssValue("border");
		login.Log4j.info(border_color);
		String[] str = border_color.split("solid");
		Commentary.ColorValidation(str[1].trim(),ActualColor);
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 6).click();
//		CommonFunctionality.Views_list();
	}

	@Then("^The visual border \"([^\"]*)\" should be updated to \"([^\"]*)\"$")
	public void the_visual_border_should_be_updated_to(String arg1, String arg2) throws Throwable {
		Thread.sleep(2000);
		if (arg1.equals("Width")) {
			String border = login.driver
					.findElement(
							By.xpath("//div[@class='visual-preview base-preview']//div[@class='visual-item-container']"))
					.getCssValue("border");
			String[] str = border.split(" ");
			login.Log4j.info(str[0]);
			comm.FontSizeValidation(str[0], arg2);
		} else if (arg1.equals("Radius")) {
			String ActualRadius = login.driver
					.findElement(
							By.xpath("//div[@class='visual-preview base-preview']//div[@class='visual-item-container']"))
					.getCssValue("border-radius");

			login.Log4j.info("Actual value is :" + ActualRadius);
			comm.FontSizeValidation(ActualRadius, arg2);
		}
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 6).click();
	//	CommonFunctionality.Views_list();
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
					.getElementByXpath(login.driver, "//*[@class='border-settings--container']//*[@class='select-control']//span[@role='presentation']", 6)
					.click();
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='select2-results']//li//*[@title='" + style + "']", 6)
					.click();
			CommonFunctionality.wait(1000);
			String VisualBorder = login.driver
					.findElement(
							By.xpath("//div[@class='visual-preview base-preview']//div[@class='visual-item-container']                                                                                                                                                                                                                 "))
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
//		CommonFunctionality.Views_list();
	}

	@Then("^Visual popup should be opened$")
	public void visual_popup_should_be_opened() throws Throwable {
		CommonFunctionality.wait(1000);
		if (login.driver.findElement(By.xpath("//*[@class='popover-content']")).isDisplayed()) {
			login.Log4j.info("Visual/Titles popup is displayed");
		} else {
			Assert.fail("Visual popup is not displayed ");
		}
		//CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
//		CommonFunctionality.Views_list();
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
//		CommonFunctionality.Views_list();
	}

	@And("^Click on Background drop down$")
	public void click_on_Background_drop_down() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='base-config--column base-config--column__style']//div[3]//div[2]//div[1]//div[2]", 8)
				.click();
	}

	@And("^Uncheck \"([^\"]*)\" and Visual$")
	public void uncheck_and_Visual(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		WebElement ele = login.driver.findElement(
				By.xpath("//*[@class='background-control-container']/*[1]//span[@class='input-control--indicator']"));
		Boolean histogramORmap = ele.isSelected();
		WebElement ele1 = login.driver.findElement(
				By.xpath("//*[@class='background-control-container']/*[2]//span[@class='input-control--indicator']"));
		Boolean check_visual = ele1.isSelected();
		if (histogramORmap == true) {
			// uncheck histogram or map
			ele.click();
		}
		if (check_visual == true) {
			// uncheck visual
			ele1.click();
		}

	}

	@Then("^Background should not be seen for \"([^\"]*)\" and visual$")
	public void background_should_not_be_seen_for_and_visual(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		if (!(login.driver
				.findElement(By.xpath("//div[@class='visual-preview base-preview']//div[@class='visual-item-wrapper']"))
				.getAttribute("style")).contains("background-color")) {
			login.Log4j.info("Background color is not displayed");
		} else {
			Assert.fail("Background color is displayed by unchecking " + arg1 + " and visual");
		}
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
//		CommonFunctionality.Views_list();
	}

	@And("^Check \"([^\"]*)\" and Visual$")
	public void check_and_Visual(String arg1) throws Throwable {
		WebElement ele = login.driver.findElement(
				By.xpath("//*[@class='background-control-container']/*[1]//span[@class='input-control--indicator']"));

		Boolean check_histogram_or_map = ele.isSelected();
		if (check_histogram_or_map == false) {
			// check histogram or map
			ele.click();
		}
		CheckVisual();
	}

	@Then("^Background should be displayed for \"([^\"]*)\" and visual$")
	public void background_should_be_displayed_for_and_visual(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		if ((login.driver
				.findElement(By.xpath("//div[@class='visual-preview base-preview']//div[@class='visual-item-container']"))
				.getAttribute("style")).contains("background-color")) {
			login.Log4j.info("Background color is displayed");
		} else {
			Assert.fail("Background color is not displayed by checking "+ arg1 + " and visual");
		}
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 6).click();
	//	CommonFunctionality.Views_list();
	}

	@And("^Check Histogram for \"([^\"]*)\"$")
	public void check_Histogram_for(String arg1) throws Throwable {
		CheckHistogram(arg1);
	}

	@And("^Select background color$")
	public void select_background_color() throws Throwable {
		select_color();
	}

	@Then("^Background should be displayed for \"([^\"]*)\" with selected color$")
	public void background_should_be_displayed_for_with_selected_color(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		String background_color = CommonFunctionality
				.getElementByXpath(login.driver, "(//*[@class='highcharts-plot-background'])[5]", 6)
				.getCssValue("fill");
		BackGroundColor_Validation(background_color);
	}

	@And("^click on Browse > upload image$")
	public void click_on_Browse_upload_image() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='background-image']//*[contains(@class,'form--control__xs background-image--input')]",
				6).click();
		comm.select_image();
	}

	@Then("^Uploaded image should be displayed in \"([^\"]*)\" background$")
	public void uploaded_image_should_be_displayed_in_background(String arg1) throws Throwable {
		Boolean image = login.driver
				.findElement(By.xpath("//*[name()='image' and contains(@preserveAspectRatio,'none')]")).isDisplayed();
		BackGroundImageValidation(image);
	}

	@And("^click on Browse > try to upload PDF file$")
	public void click_on_Browse_try_to_upload_PDF_file() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='background-image']//*[contains(@class,'form--control__xs background-image--input')]",
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
						"//*[@class='visual-preview base-preview']//*[@class='visual-item-container']", 6)
				.getCssValue("background-color");
		BackGroundColor_Validation(background_color);
	}

	@Then("^Uploaded image should be displayed in visual background$")
	public void uploaded_image_should_be_displayed_in_visual_background() throws Throwable {
		CommonFunctionality.wait(1000);
		Boolean VisualBackgroundImage = login.driver
				.findElement(By.xpath("//*[@class='visual-preview base-preview']//*[@class='visual-item-container']"))
				.getAttribute("style").contains("background-image");
		BackGroundImageValidation(VisualBackgroundImage);
	}

	@And("^Check Show Series and Save$")
	public void check_Show_Series_and_Save() throws Throwable {
		CheckShowSeries();
		// save the changes
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Save')]", 8).click();
	}

	@Then("^Data of series should be shown on the visual$")
	public void data_of_series_should_be_shown_on_the_visual() throws Throwable {
		CommonFunctionality.wait(500);
		Boolean Series = login.driver
				.findElement(By.xpath("(//*[@class='highcharts-axis-labels highcharts-xaxis-labels'])[1]"))
				.isDisplayed();
		if (Series == true) {
			login.Log4j.info("Data of series is shown on the visual");
		} else {
			Assert.fail("Data of series is not shown on the visual");
		}
		//CommonFunctionality.Views_list();
	}

	@And("^UnCheck Show Series and Save$")
	public void uncheck_Show_Series_and_Save() throws Throwable {
		make_any_changes();
		// save the changes
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Save')]", 8).click();

	}

	@Then("^Data of series should be removed from the visual$")
	public void data_of_series_should_be_removed_from_the_visual() throws Throwable {
		CommonFunctionality.wait(2000);
//		Boolean Series = login.driver
//				.findElement(By.xpath("(//*[@class='highcharts-axis-labels highcharts-xaxis-labels'])[1]"))
//				.isDisplayed();
		
		
		if (login.driver
				.findElements(By.xpath("//*[@class='highcharts-legend-item highcharts-scatter-series highcharts-color-undefined highcharts-series-0']")).size() == 0                          ) {
			login.Log4j.info("Data of series is removed from the visual");
		} else {
			Assert.fail("Data of series is not removed from the visual");
		}
		
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
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'movable-modal__active')]//button[contains(text(),'Save')]", 8).click();
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
		//CommonFunctionality.Views_list();
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
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'movable-modal__active')]//button[contains(text(),'Save')]", 8).click();
	}

	@Then("^The title of the visual should be removed from the visual$")
	public void the_title_of_the_visual_should_be_removed_from_the_visual() throws Throwable {
		CommonFunctionality.wait(1000);
		//boolean VisualTitle = login.driver.findElement(By.xpath("//*[@data-name='title']")).isEnabled();
		if (login.driver.findElements(By.xpath("//*[@class='visual-title--text text-dots']")).size() == 0) {
			login.Log4j.info("The title of the visual is removed");
		} else {
			Assert.fail("The title of the visual is not removed");
		}
		//CommonFunctionality.Views_list();
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
		//CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		// CommonFunctionality.getElementByXpath(login.driver,
		// "//button[contains(text(),'Ok')]", 6).click();
	//	CommonFunctionality.Views_list();
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
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'movable-modal__active')]//button[contains(text(),'Save')]", 8).click();
	}

	@Then("^Auto title should be displayed as series name$")
	public void auto_title_should_be_displayed_as_series_name() throws Throwable {
		CommonFunctionality.wait(1000);
		String Actual_Title = login.driver.findElement(By.xpath("//*[@class='visual-title--text text-dots']")).getText();
		try {
			if (SName.equals(Actual_Title)) {
				login.Log4j.info("Auto title is displayed as series name");
			}
		} catch (NullPointerException e) {
			try {
			if (PieVisual.sname.equals(Actual_Title)) {
				login.Log4j.info("Auto title is displayed as series name");
			} else {
				Assert.fail("Auto title verification is failed");
			}
			}catch(NullPointerException e1) {
				if (Map.sname.equals(Actual_Title)) {
					login.Log4j.info("Auto title is displayed as series name");
				} else {
					Assert.fail("Auto title verification is failed");
				}
			}

		}
		//CommonFunctionality.Views_list();
	}

	@SuppressWarnings("deprecation")
	@And("^Enter visual name and Save$")
	public void enter_visual_name_and_Save() throws Throwable {
		AutoTitle = "DefaultTitle";
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

			CommonFunctionality.getElementByXpath(login.driver, "//input[@name='title']", 20).sendKeys(AutoTitle);
		}
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'movable-modal__active')]//button[contains(text(),'Save')]", 20).click();
	}

	@Then("^The visual name should be changed$")
	public void the_visual_name_should_be_changed() throws Throwable {
		CommonFunctionality.wait(1000);
		String Actual_Title = login.driver.findElement(By.xpath("//*[@data-name='title']")).getText();
		if (AutoTitle.equals(Actual_Title)) {
			login.Log4j.info("Visual name is changed as " + Actual_Title);
		} else {
			Assert.fail("Visual name is not changed by changing Auto name");
		}
		//CommonFunctionality.Views_list();
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
	//	CommonFunctionality.Views_list();
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
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'movable-modal__active')]//button[contains(text(),'Save')]", 20).click();
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
		//CommonFunctionality.Views_list();
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
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'movable-modal__active')]//button[contains(text(),'Save')]", 20).click();
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
		//CommonFunctionality.Views_list();
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
		//CommonFunctionality.Views_list();
	}

	@And("^Click on cogwheel icon for title$")
	public void click_on_cogwheel_icon_for_title() throws Throwable {
		
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='style-container--controls']//div[1]//div[3]//div[1]", 20).click();
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
							"//*[contains(@title,'Source. Configure displaying of the source')]//input[@type='checkbox']"))
					.isSelected();
			if (isChecked == false) {
				login.driver.findElement(By.xpath(
						"//*[contains(@title,'Source. Configure displaying of the source')]//*[@class='input-control--indicator']"))
						.click();
			}
		} else if (arg1.equalsIgnoreCase("Tooltips")) {
			CommonFunctionality.wait(1000);
			Boolean isChecked = login.driver
					.findElement(By.xpath(
							"//*[contains(@title,'Tooltips.')]//input[@type='checkbox']"))
					.isSelected();
			if (isChecked == false) {
				login.driver.findElement(By.xpath(
						"//*[contains(@title,'Tooltips.')]//span[@class='input-control--indicator']"))
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
					.getElementByProperty(login.driver, "ColorPicker", 10)
					.click();
		} else if (arg1.equalsIgnoreCase("Items")) {
			CommonFunctionality.getElementByProperty(login.driver,
					"ColorPicker", 10).click();
		} else if (arg1.equalsIgnoreCase("tooltip border")) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='border-settings--container']//*[@class='sp-preview-inner']", 10).click();
		} else if(arg1.equalsIgnoreCase("Legend")) {
			CommonFunctionality.getElementByXpath(login.driver,
					"(//*[@class='popover-block-content legend-config'])[1]/*[2]//*[@class='color-picker--ui']/*[1]", 10).click();
		}
		WebElement ColorEle = CommonFunctionality.getElementByProperty(login.driver, "OrangeColor", 20);
		ActualColor = ColorEle.getCssValue("background-color");
		ColorEle.click();
		
	}

	@SuppressWarnings({ "deprecation", "unused" })
	@Then("^Visual \"([^\"]*)\" should be displayed in selected color$")
	public void visual_should_be_displayed_in_selected_color(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		if (arg1.equalsIgnoreCase("title") || arg1.equalsIgnoreCase("sub-title")) {
			String Title_color = CommonFunctionality
					.getElementByXpath(login.driver, "//*[@data-name='" + arg1 + "']", 6).getCssValue("color");
			Commentary.ColorValidation(Title_color,ActualColor);
		} else if (arg1.equalsIgnoreCase("Copyright")) {
			String copyright_color = CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='visual-item-wrapper--text ']", 10)
					.getCssValue("color");
			Commentary.ColorValidation(copyright_color,ActualColor);
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
				Commentary.ColorValidation(TooltipText_color,ActualColor);
				break;
			}
		}
		//CommonFunctionality.Views_list();
	}
	@SuppressWarnings({ "unused", "deprecation" })
	@Then("^Tooltip border should be displayed with selected color$")
	public void tooltip_border_should_be_displayed_with_selected_color() throws Throwable {
		CommonFunctionality.wait(2000);
		List<WebElement> timepoints = login.driver.findElements(By.xpath(
				"//*[contains(@class,'highcharts-series highcharts-series-1 highcharts-histogram-series')]/*"));
		for (int i = 0; i <= timepoints.size(); i++) {
			new Actions(login.driver).moveToElement(timepoints.get(i)).pause(100).perform();
			String Tooltip_border_color = CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[@class='highcharts-label-box highcharts-tooltip-box']", 10)
					.getCssValue("stroke");
			Commentary.ColorValidation(Tooltip_border_color,ActualColor);
			break;
		
		}
		//CommonFunctionality.Views_list();
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
		WebElement ColorEle = CommonFunctionality.getElementByProperty(login.driver, "OrangeColor", 20);
		ActualColor = ColorEle.getCssValue("background-color");
		ColorEle.click();
		
	}

	@Then("^Visual \"([^\"]*)\" background should be displayed in selected color$")
	public void visual_background_should_be_displayed_in_selected_color(String arg1) throws Throwable {
		login.driver.navigate().refresh();
		CommonFunctionality.wait(2000);
		if (arg1.equalsIgnoreCase("title") || arg1.equalsIgnoreCase("sub_title")) {
			String Title_Background_color = CommonFunctionality
					.getElementByXpath(login.driver, "//*[@data-name='" + arg1 + "']", 6)
					.getCssValue("background-color");
			Commentary.ColorValidation(Title_Background_color,ActualColor);
		}
		//CommonFunctionality.Views_list();
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
				login.driver.findElement(By.xpath("//*[@class='copyright-config--block-content ']//button[contains(@class,'ui-spinner-up')]")).click();
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
			//CommonFunctionality.Views_list();
		}
	}

	@Then("^The \"([^\"]*)\" should be displayed in Bold format$")
	public void the_title_should_be_displayed_in_Bold_format(String title) throws Throwable {
		
		comm.BoldFormatVerification(title);
		//CommonFunctionality.Views_list();
	}

	@Then("^The \"([^\"]*)\" should be \"([^\"]*)\"$")
	public void the_should_be(String arg1, String format) throws Throwable {
		//login.driver.navigate().refresh();
		comm.StyleSelection(arg1, format);
		//CommonFunctionality.Views_list();
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
			} else if (arg1.equalsIgnoreCase("Horizontal align") ) {
				CommonFunctionality.wait(500);
				login.driver.findElement(By.xpath("//*[@data-value='" + list.get(i) + "']")).click();
				CommonFunctionality.wait(1000);
				CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Save')]", 20).click();				CommonFunctionality.wait(1500);
				alignmentValue = login.driver
						.findElement(By.xpath("//*[@class='visual-item-wrapper']"))
						.getAttribute("style");
			} else if(arg1.equalsIgnoreCase("Copyright")) {
				
			}

			ListOfalignmentValue.add(alignmentValue);
			if (!(i == 2)) {
				CommonFunctionality.wait(1000);
				St.click_on("Edit Histogram");
				if (arg1.equalsIgnoreCase("title")) {
					click_on_cogwheel_icon_for_title();
				} else if (arg1.equalsIgnoreCase("Sub title")) {
					click_on_cogwheel_icon_for_title();
					CommonFunctionality.wait(1000);
					WebElement expand = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand")));
					new Actions(login.driver).pause(300).moveToElement(expand).click().build().perform();
				} else if (arg1.equalsIgnoreCase("Horizontal align")) {
//					open_drop_down_for("Copyright");
					open_Size_dropdown();
				} else if (arg1.equalsIgnoreCase("Copyright")) {
					db.click_on_icon("Open advanced settings popup");
					select_Text_radio_button();
				}
			}
		}
	}
	@And("^Select alignment of sub title to \"([^\"]*)\"$")
	public void select_alignment_of_sub_title_to(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		login.driver.findElement(By.xpath("//*[@name='sub_title_align' and @data-value='" + arg1 + "']"))
				.click();
	}
	@And("^Select alignment of title to \"([^\"]*)\"$")
	public void select_alignment_of_title_to(String arg1) throws Throwable {
		CommonFunctionality.wait(300);
		login.driver.findElement(By.xpath("//*[@data-value='" + arg1 + "']")).click();
	}
	
	@Then("^The title should align to \"([^\"]*)\"$")
	public void the_title_should_align_to(String arg1) throws Throwable {
		CommonFunctionality.wait(1500);
		String alignment = login.driver.findElement(By.xpath("(//*[@class='visual-title visual-title--wrapper'])[3]")).getAttribute("style");
		if (arg1.equalsIgnoreCase("Left")) {

			if (alignment.contains(" flex-start")) {
				login.Log4j.info("The title aligned to " + arg1);
			} else {
				fail("Verification Failed");
			}

		}
		if (arg1.equalsIgnoreCase("Center")) {

			if (alignment.contains(" center")) {
				login.Log4j.info("The title is aligned to " + arg1);
			} else {
				fail("Verification Failed");
			}

		}
		if (arg1.equalsIgnoreCase("Right")) {

			if (alignment.contains(" flex-end")) {
				login.Log4j.info("The title is aligned to " + arg1);
			} else {
				fail("Verification Failed");
			}
		}
	    
	}

@Then("^The subtitle should align to \"([^\"]*)\"$")
public void the_subtitle_should_align_to(String arg1) throws Throwable {
	CommonFunctionality.wait(2000);
	String alignment = login.driver
			.findElement(
					By.xpath("//*[@class='visual-preview base-preview']//*[@data-name='sub_title']//parent::div"))
			.getAttribute("style");
	if (arg1.equalsIgnoreCase("Left")) {

		if (alignment.contains(" flex-start")) {
			login.Log4j.info("The Sub_title aligned to " + arg1);
		} else {
			fail("Verification Failed");
		}

	}
	if (arg1.equalsIgnoreCase("Center")) {

		if (alignment.contains(" center")) {
			login.Log4j.info("The Sub_title is aligned to " + arg1);
		} else {
			fail("Verification Failed");
		}

	}
	if (arg1.equalsIgnoreCase("Right")) {

		if (alignment.contains(" flex-end")) {
			login.Log4j.info("The Sub_title is aligned to " + arg1);
		} else {
			fail("Verification Failed");
		}
	}
    
}

	/*@Then("^The title should align to \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\" as per the user selection$")
	public void the_title_should_align_to_and_as_per_the_user_selection(String arg1, String arg2, String arg3)
			throws Throwable {
		//comm.AlignmentValidation(arg1, arg2, arg3, ListOfalignmentValue);
		for(String alignment : ListOfalignmentValue) {
			if(alignment.equals("left")) {

				String left = login.driver.findElement(By.xpath(
						"//*[@data-entity='histogram']//*[@class='visual-item-wrapper']"))
						.getAttribute("style");
				if (!(left.contains("margin"))) {
					login.Log4j.info("The Visual area is aligned to " + alignment);
				} else {
					fail("Verification Failed");
				}
				
			} else if(alignment.equals("center")) {
				String center = login.driver.findElement(By.xpath(
						"//*[@data-entity='histogram']//*[@class='visual-item-wrapper']"))
						.getAttribute("style").split(";")[1];
				if (center.equalsIgnoreCase(" margin: 0px auto")) {
					login.Log4j.info("The Visual area is aligned to " + alignment);
				} else {
					fail("Verification Failed");
				}
			} else if(alignment.equals("right")) {
				String right = login.driver.findElement(By.xpath(
						"//*[@data-entity='histogram']//*[@class='visual-item-wrapper']"))
						.getAttribute("style").split(";")[1];
				if (right.equalsIgnoreCase(" margin-left: auto")) {
					login.Log4j.info("The Visual area is aligned to " + alignment);
				} else {
					fail("Verification Failed");
				}
			}
		}
		CommonFunctionality.Views_list();
	}*/

	@Then("^The Title popup should be closed$")
	public void the_Title_popup_should_be_closed() throws Throwable {
		comm.PopUp_validation("title");
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		//CommonFunctionality.Views_list();
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
		//CommonFunctionality.Views_list();
	}

	@And("^Open Size dropdown$")
	public void open_Size_dropdown() throws Throwable {
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='base-config--column base-config--column__as-table']//div[@class='size-control-context-title']",
				10).click();
	}

	@And("^Reduce proportion to (\\d+)$")
	public void reduce_proportion_to(int arg1) throws Throwable {
		size = arg1;
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

	/*@Then("^The visual should align to \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\" as per the user selection$")
	public void the_visual_should_align_to_and_as_per_the_user_selection(String arg1, String arg2, String arg3)
			throws Throwable {
		for(String alignment : list) {
			if(arg1.equals("left")) {
				
				if (!(alignment.contains("margin"))) {
					login.Log4j.info("The Visual area is aligned to " + arg1);
				} else {
					fail("Verification Failed");
				}
				
			} else if(arg2.equals("center")) {
				String[] center = alignment.split(";");

				if (alignment.contains(center[1])) {
					login.Log4j.info("The Visual area is aligned to " + alignment);
				} else {
					fail("Verification Failed");
				}
			} else if(arg3.equals("right")) {
				String[] right = alignment.split(";");

				if (alignment.contains(right[1])) {
					login.Log4j.info("The Visual area is aligned to " + alignment);
				} else {
					fail("Verification Failed");
				}
			}
		}
		CommonFunctionality.Views_list();
	}*/

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
		//CommonFunctionality.Views_list();
	}

	@And("^Check Copyright and Save$")
	public void check_Copyright_and_Save() throws Throwable {
		check("Copyright");
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'movable-modal__active')]//button[contains(text(),'Save')]", 40).click();
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
		//CommonFunctionality.Views_list();
	}

	@And("^UnCheck Copyright$")
	public void uncheck_Copyright() throws Throwable {
		Uncheck_Copyright();
		// CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'movable-modal__active')]//button[contains(text(),'Save')]", 40).click();
	}

	@Then("^The Copyright logo should be removed for visual$")
	public void the_Copyright_logo_should_be_removed_for_visual() throws Throwable {
		CommonFunctionality.wait(2000);
		if (login.driver.findElements(By.xpath("//*[@class='visual-item-wrapper--credits-image']//img")).size() == 0) {
			login.Log4j.info("CEIC logo is not displayed for unchecking Copyright");
		} else {
			Assert.fail("CEIC logo is displayed for unchecking Copyright");
		}
		//CommonFunctionality.Views_list();
	}

	@And("^Open drop down for \"([^\"]*)\"$")
	public void open_drop_down_for(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		if (arg1.equalsIgnoreCase("Copyright")) {
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(@title,'Source. Configure displaying of the source')]/*[2]/*[1]/*[2]", 12)
					.click();
		} else if (arg1.equals("Tooltips")) {
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(@class,'histogram-config--column__settings')]/*[3]/*[2]/*[1]/*[2]", 12)
					.click();
		}
	}

	/*@Then("^The copyright should be dispalyed in \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\" as per the user selection$")
	public void the_copyright_should_be_dispalyed_in_and_as_per_the_user_selection(String arg1, String arg2,
			String arg3) throws Throwable {
		comm.AlignmentValidation(arg1, arg2, arg3, ListOfalignmentValue);
		CommonFunctionality.Views_list();
	}
*/
	@Then("^The copyright image should align to \"([^\"]*)\"$")
	public void the_copyright_image_should_align_to(String arg1) throws Throwable {
		CommonFunctionality.wait(1500);
		String alignment = login.driver
				.findElement(
						By.xpath("//*[@class='preview-container']//*[@class='visual-item-wrapper--credits-container']"))
				.getAttribute("style");
		if (arg1.equalsIgnoreCase("Left")) {

			if (alignment.contains(" flex-start")) {
				login.Log4j.info("The copyright image is aligned to " + arg1);
			} else {
				fail("Verification Failed");
			}

		}
		if (arg1.equalsIgnoreCase("Center")) {

			if (alignment.contains(" center")) {
				login.Log4j.info("The copyright image is aligned to " + arg1);
			} else {
				fail("Verification Failed");
			}

		}
		if (arg1.equalsIgnoreCase("Right")) {

			if (alignment.contains(" flex-end")) {
				login.Log4j.info("The copyright image is aligned to " + arg1);
			} else {
				fail("Verification Failed");
			}
		}
	}
	@And("^Select Horizontal alignment of copyright to \"([^\"]*)\"$")
	public void select_Horizontal_alignment_of_copyright_to(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		login.driver.findElement(By.xpath("//*[@data-value='" + arg1 + "']")).click();
	}
	@And("^Select Text radio button from copyright popup and Save$")
	public void select_Text_radio_button_from_copyright_popup_and_Save() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='copyright-config']/*[5]/*[1]/*[2]/*[1]/*[2]//*[@class='input-control--indicator']", 40)
				.click();
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='visual-configuration']//button[contains(text(),'Save')]", 40).click();
	}

	@Then("^Copyright text \"([^\"]*)\" should be displayed on visual$")
	public void copyright_text_should_be_displayed_on_visual(String CopyrightText) throws Throwable {
		CommonFunctionality.wait(1000);
		String Actual_CopyrightText = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='visual-item-wrapper--text ']", 40).getText();
		if (Actual_CopyrightText.equals(CopyrightText)) {
			login.Log4j.info("Copyright text is displayed on visual by selecting Text ");
		} else {
			Assert.fail("Copyright text is not displayed on visual by selecting Text ");
		}
		//CommonFunctionality.Views_list();
	}
	@And("^Click on \\+ icon in the copyright popup$")
	public void click_on_icon_in_the_copyright_popup1() throws Throwable {
		CommonFunctionality.wait(500);
		//if copyright popup is collapsed then expand
		if(login.driver.findElement(By.xpath("//*[@class='popover--body']/*[1]/*[1]")).getAttribute("class").contains("collapsed")) {
			login.driver.findElement(By.xpath("//*[@class='popover--body']/*[1]/*[1]/*[1]/*[3]")).click();
				
		} else {
			if(!login.driver.findElement(By.xpath("//*[@class='popover--body']/*[1]/*[1]")).getAttribute("class").contains("collapsed")){
				login.driver.findElement(By.xpath("//*[@class='popover--body']/*[1]/*[1]/*[1]/*[2]")).click();
				login.driver.findElement(By.xpath("//*[@class='popover--body']/*[1]/*[1]/*[1]/*[3]")).click();
			} 
		}
	    
	}

	@Then("^The section should be expnaded$")
	public void the_section_should_be_expnaded() throws Throwable {
		CommonFunctionality.wait(500);
		if(!login.driver.findElement(By.xpath("//*[@class='popover--body']/*[1]/*[1]")).getAttribute("class").contains("collapsed")) {
			login.Log4j.info("The section is expandedd");
			
		} else {
			Assert.fail("The section is not expanded");
		}
	}
	
	@And("^Click on Date format dropdown$")
	public void click_on_Date_format_dropdown() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='config-panel']/*[1]/*[2]/*[4]//*[@class='context-menu-control--icon']", 20).click();
	}
	@SuppressWarnings("deprecation")
	@And("^Select custom Date format  as \"([^\"]*)\"$")
	public void select_custom_Date_format_as(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
//	    WebElement ele = CommonFunctionality.getElementByXpath(login.driver, "//label[@title='Custom']//input", 20);
	   boolean custom_radio_button = login.driver.findElement(By.xpath("//label[@title='Custom']//input")).isSelected();
	    if(custom_radio_button == false) {
	    	new Actions(login.driver).pause(500).moveToElement(login.driver.findElement(By.xpath("//label[@title='Custom']//input"))).click().perform();
	    	
	    }
	    CommonFunctionality.wait(500);
		CommonFunctionality.getElementByXpath(login.driver,
				"//input[contains(@class,'custom-date-format--input')] | //input[@class='form--control form--control__xs']",
				4).clear();
		CommonFunctionality.getElementByXpath(login.driver,
				"//input[contains(@class,'custom-date-format--input')] | //input[@class='form--control form--control__xs']",
				4).sendKeys(Keys.chord(Keys.CONTROL, "a"), arg1);
	}

	@Then("^Selected date format should be displayed in visual$")
	public void selected_date_format_should_be_displayed_in_visual() throws Throwable {
		String date_series = CommonFunctionality.getElementByXpath(login.driver,
				"(//*[@class='highcharts-axis-labels highcharts-xaxis-labels'])[1]/*[1]", 4).getText();
		if (date_series.matches("([0-9]{4})/([0-9]{2})/([0-9]{2})") ) {
			login.Log4j.info("Selected date format is reflected on the visual");
		} else {
			Assert.fail("Selected date format YYYY/MM/DD is not reflected on the visual");
		}
	}
	@Then("^\"([^\"]*)\" format should be selected by default$")
	public void format_should_be_selected_by_default(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		boolean AutoFormat = login.driver.findElement(By.xpath("//ul[contains(@class,'date-format--context-menu')]//li[1]//label[@title='" + arg1 + "']//input")).isSelected();
		if(AutoFormat == true) {
			login.Log4j.info(arg1+ " format is selected by default");
		} else {
			Assert.fail(arg1 + " is not selected by default");
		}
	}
	@Then("^Click on - icon in the copyright popup$")
	public void click_on_icon_in_the_copyright_popup() throws Throwable {
		CommonFunctionality.wait(500);
		//if copyright popup is expanded then collapse
		if(!login.driver.findElement(By.xpath("//*[@class='popover--body']/*[1]/*[1]")).getAttribute("class").contains("collapsed")) {
			login.driver.findElement(By.xpath("//*[@class='popover--body']/*[1]/*[1]/*[1]/*[2]")).click();
		} else {
			if(login.driver.findElement(By.xpath("//*[@class='popover--body']/*[1]/*[1]")).getAttribute("class").contains("collapsed")) {
				login.driver.findElement(By.xpath("//*[@class='popover--body']/*[1]/*[1]/*[1]/*[3]")).click();
				login.driver.findElement(By.xpath("//*[@class='popover--body']/*[1]/*[1]/*[1]/*[2]")).click();
				
			}
		}
	}

	@Then("^The section should be collapsed$")
	public void the_section_should_be_collapsed() throws Throwable {
		CommonFunctionality.wait(500);
		if(login.driver.findElement(By.xpath("//*[@class='popover--body']/*[1]/*[1]")).getAttribute("class").contains("collapsed")) {
			login.Log4j.info("The section is collapsed");
			
		} else {
			Assert.fail("The section is not collapsed");
		}
	}
	@SuppressWarnings("deprecation")
	@And("^Select Text radio button and Edit the text as \"([^\"]*)\" and Save$")
	public void select_Text_radio_button_and_Edit_the_text_as_and_Save(String Edit_text) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='copyright-config']/*[5]/*[1]/*[2]/*[1]/*[2]//*[@class='input-control--indicator']", 40)
				.click();
		WebElement TextField = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='copyright-config']/*[5]/*[3]/*[2]/*", 10);
		TextField.clear();
		new Actions(login.driver).pause(500).sendKeys(TextField, Edit_text).perform();
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='visual-configuration']//button[contains(text(),'Save')]", 20).click();
		// CommonFunctionality.getElementByXpath(login.driver,
		// "//button[contains(text(),'Ok')]", 10).click();
	}

	@Then("^Updated copyright \"([^\"]*)\" should be displayed on visual$")
	public void updated_copyright_should_be_displayed_on_visual(String Updated_copyright_text) throws Throwable {
		CommonFunctionality.wait(3000);
		String Actual_CopyrightText = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='visual-item-wrapper--text ']", 20).getText();
		if (Actual_CopyrightText.equals(Updated_copyright_text)) {
			login.Log4j.info("Updated Copyright text is displayed on visual by editing text ");
		} else {
			Assert.fail("Updated Copyright text is not displayed on visual by editing Text field");
		}
		//CommonFunctionality.Views_list();
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
		//CommonFunctionality.Views_list();
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

	@SuppressWarnings({ "deprecation", "unused" })
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
	//	CommonFunctionality.Views_list();
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

	@SuppressWarnings({ "unused", "deprecation" })
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
		//CommonFunctionality.Views_list();
	}

	@And("^Create a histogram visual$")
	public void create_a_histogram_visual() throws Throwable {
		create_a_Histogram_visual_without_selecting_series();

	}

	@And("^Add a series to the visual$")
	public void add_a_series_to_the_visual() throws Throwable {
		//CommonFunctionality.ResetMethod();
//		CommonFunctionality.getElementByProperty(login.driver, "Search", 5).sendKeys("209570902");
		CommonFunctionality.wait(3000);
		CommonFunctionality.getElementByProperty(login.driver, "Series", 20).click();
		CommonFunctionality.wait(5000);
		SRegion = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='series-item--country country-information']", 10)
				.getText();
		WebElement ele = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-item--name']", 10);
		SName = ele.getText();
		ele.click();
		CommonFunctionality.wait(1000);
		frequency = CommonFunctionality.getElementByXpath(login.driver, "//tbody/*[2]//*[@class='main-series-information--field-value']", 10).getText();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Close']", 10).click();
		/*new Actions(login.driver).moveToElement(ele).perform();
		String tooltip_text = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text"))).getText();
		String[] lines = tooltip_text.split("\n");

		for (String Tooltip : lines) {
			// String str=null;
			if (Tooltip.contains("Frequency")) {
				String frequency = Tooltip;
				login.Log4j.info(frequency);
				Sfrequency = frequency.split(":");
			}
		}*/
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='add-to-data-selection--icon']", 10).click();
	}
	@And("^Create a histogram visual with series id \"([^\"]*)\"$")
	public void create_a_histogram_visual_with_series_id(String arg1) throws Throwable {
		create_a_Histogram_visual_without_selecting_series();
		CommonFunctionality.ResetMethod();
		CommonFunctionality.getElementByProperty(login.driver, "Search", 5).sendKeys(arg1);
		CommonFunctionality.getElementByProperty(login.driver, "Series", 20).click();
		CommonFunctionality.wait(1000);
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

	@SuppressWarnings({ "deprecation", "unused" })
	@Then("^Selected attributes should be displayed in tooltip when mouse hover on visual data$")
	public void selected_attributes_should_be_displayed_in_tooltip_when_mouse_hover_on_visual_data() throws Throwable {
		CommonFunctionality.wait(4000);
		List<WebElement> timepoints = login.driver.findElements(
				By.xpath("//*[contains(@class,'highcharts-markers highcharts-series-0 highcharts-scatter-series')]/*"));
		for (int i = 0; i <= timepoints.size(); i++) {
			new Actions(login.driver).moveToElement(timepoints.get(i)).pause(100).perform();
			WebElement tooltip = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'highcharts-tooltip highcharts-color-undefined')]/span", 8);
			String text = tooltip.getText();
			login.Log4j.info(text);
			//String[] Tooltip_txt = text.split(";");
			 login.Log4j.info(SName);
			 login.Log4j.info(SRegion);
			 login.Log4j.info(frequency);
			/*if (SName.equals(Tooltip_txt[1].trim()) && SRegion.equals(Tooltip_txt[2].trim())
					&& Sfrequency[1].trim().equals(Tooltip_txt[3].trim())) {*/
				if (text.contains(SName) && text.contains(SRegion)
					&& text.contains(frequency.trim())) {
				
				login.Log4j.info("Selected attributes is displayed when mouse hover on visual data");
			} else {
				Assert.fail("Selected attributes not displayed when mouse hover on visual data");
			}
			break;

		}
		//CommonFunctionality.Views_list();
	}

	@And("^Click on cogwheel for advance settings$")
	public void click_on_cogwheel_for_advance_settings() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'histogram-config--column__settings')]/*[3]//*[@title='Open advanced settings popup']",
				6).click();
	}
	@And("^Expand \"([^\"]*)\"$")
	public void expand(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
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
	    } else if(arg1.equalsIgnoreCase("Title")) {
	    	CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'legend-config')]//*[contains(text(),'" + arg1 + "')]", 8).click();
	    }
	}
	
	@And("^Select items as \"([^\"]*)\" from dropdown$")
	public void select_items_as_from_dropdown(String arg1) throws Throwable {
		CommonFunctionality.wait(200);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='select2-choices']", 20).click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='select2-results']//li//*[contains(text(),'" +arg1+"')]", 8)
				.click();
	}

	@SuppressWarnings({ "deprecation", "unused" })
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
		//CommonFunctionality.Views_list();
	}

	@And("^Select multiple items from dropdown$")
	public void select_multiple_items_from_dropdown(List<String> Items_list) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='select2-choices']", 8).click();
		for (int i = 0; i < Items_list.size(); i++) {
			CommonFunctionality.wait(200);
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[@class='select2-results']//li//*[contains(text(),'" + Items_list.get(i) + "')]", 8)
					.click();
			if (i != 2) {
				CommonFunctionality.getElementByXpath(login.driver, "//*[@class='add-item-attribute btn']", 20).click();
			}

		}

	}

	@And("^Select font size as \"([^\"]*)\"$")
	public void select_font_size_as(String FontSize) throws Throwable {
		Thread.sleep(2000);
		String size = CommonFunctionality.getElementByXpath(login.driver, "//*[@name='tooltip_font_size'] | //*[@name='legend_item_font_size']", 8)
				.getAttribute("value");
		int length = Integer.parseInt(FontSize) - Integer.parseInt(size);

		for (int i = 1; i <= length; i++) {
			Thread.sleep(500);
			login.driver
					.findElement(By.xpath(
							"//*[@class='popover-block-content']/*[2]/*[3]//button[contains(@class,'ui-spinner-up')] | //*[@class='chart-legend-config']/*[2]//button[contains(@class,'ui-spinner-up')]"))
					.click();
		}
	}

	@SuppressWarnings({ "deprecation", "unused" })
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
	//	CommonFunctionality.Views_list();
	}

	@And("^Click on \"([^\"]*)\" icon for items$")
	public void click_on_icon_for_items(String arg1) throws Throwable {
		TooltiptextFormat = arg1;
		CommonFunctionality.wait(500);
		if (arg1.equalsIgnoreCase("Italic")) {
			WebElement italic = null;
			try {
			italic = login.driver.findElement(By.name("tooltip_font_style"));
			}catch(Exception e) {
				italic = login.driver.findElement(By.name("legend_item_font_style"));
			}
			
			italic.click();
		} else if (arg1.equalsIgnoreCase("Underline")) {
			WebElement underline = null;
			WebElement boldformat = login.driver.findElement(By.xpath("//*[@class='legend-config']//*[@class='font-style']/*[1]"));
			if(boldformat.getAttribute("class").contains("selected")) {
				boldformat.click();
			}
			try {
			underline = login.driver.findElement(By.name("tooltip_font_underline"));
			}catch(Exception e) {
				underline = login.driver.findElement(By.name("legend_item_font_underline"));
			}
			underline.click();
		} else if(arg1.equalsIgnoreCase("Bold")) {
			WebElement bold = login.driver.findElement(By.name("tooltip_font_weight"));
			bold.click();
		}
	} 

	@SuppressWarnings({ "deprecation", "unused" })
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

		//CommonFunctionality.Views_list();

	}

	@And("^Click on Number format dropdown$")
	public static void click_on_Number_format_dropdown() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,"//*[@class='number-format-control']", 20).click();
	}

	@SuppressWarnings({ "unused", "deprecation" })
	@Then("^The Selected Decimal seperator and Grouping seperator should update with selected input$")
	public void the_Selected_Decimal_seperator_and_Grouping_seperator_should_update_with_selected_input()
			throws Throwable {
		
		CommonFunctionality.wait(5000);
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
		//CommonFunctionality.Views_list();
		
	
	}
	@And("^Set the Decimal places as (\\d+)$")
	public void set_the_Decimal_places_as(int arg1) throws Throwable {
		decimal_value = arg1;
		WebElement ele_decimal = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@name='y_axis_decimal_places']", 8);
		ele_decimal.sendKeys(Keys.chord(Keys.CONTROL, "a"), Integer.toString(arg1));
	}

	@SuppressWarnings({ "deprecation", "unused" })
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
		//CommonFunctionality.Views_list();
	}
	
	@And("^Click on the visual title$")
	public void click_on_the_visual_title() throws Throwable {
		try {
		WebElement title = CommonFunctionality.getElementByXpath(login.driver, "(//*[@data-name='title'])[2]", 8);
		title.click();
		}catch(NoSuchElementException e) {
			WebElement title = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='title']", 8);
			title.click();
		}
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
		} else if(VisualTitle.equalsIgnoreCase("Histogram")){
			CommonFunctionality.wait(2000);
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='visual-item-wrapper']", 8).click();
			VisualSelection(VisualTitle);
		}else {
			String[] title = VisualTitle.split(" ");
			VisualSelection(title[1]);
		}
		//CommonFunctionality.Views_list();
	}
	@And("^Click on visual panel dropdown$")
	public void click_on_visual_panel_dropdown() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='visual-types-panel']//*[@class='type-select--icon']", 20).click();
	}

	@And("^Select \"([^\"]*)\" visual$")
	public void select_visual(String arg1) throws Throwable {
		VisualTitle = arg1;
		
		if(arg1.equals("Pie") || arg1.equals("Histogram")) {
			CommonFunctionality.wait(500);
			try {
			CommonFunctionality.getElementByXpath(login.driver, "//*[@data-action='view_as']", 5).click();
			}catch(Exception e) {
				
			}
			CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg1 + "']", 20).click();
		} else if(arg1.equals("View as Map")) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg1 + "']", 20).click();
			CommonFunctionality.getElementByXpath(login.driver, "//*[@data-action='world']", 5).click();
		}
		
	}
	@Then("^The series should be removed from visual and edit series panel$")
	public void the_series_should_be_removed_from_visual_and_edit_series_panel() throws Throwable {
	    if(login.driver.findElements(By.xpath("//*[@class='visual-series-name']")).size() == 0) {
	    	login.Log4j.info("Series removed from edit series panel");
	    	St.click_on("Save");
	    } else {
	    	Assert.fail("Series not removed from edit series panel");
	    }
	    CommonFunctionality.wait(1000);
	    if(login.driver.findElements(By.xpath("//*[@class='highcharts-container ']")).size() == 0) {
	    	login.Log4j.info("Series removed from the visual");
	    	
	    } else {
	    	Assert.fail("Series not removed from the visual");
	    }
	  //  CommonFunctionality.Views_list();
	}
	/*@And("^Click on Series name$")
	public void click_on_Series_name() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 20).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-name--title']", 20).click();
	}*/
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
			//CommonFunctionality.Views_list();
			
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

		} else if(arg1.equalsIgnoreCase("Color")) {
			
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Color')]", 8).click();
			WebElement ColorEle = CommonFunctionality.getElementByProperty(login.driver, "OrangeColor", 20);
			TitleColor = ColorEle.getCssValue("background-color");
			ColorEle.click();
		}
		else {
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg2 + "')]", 15).click();
		}	
		
	}
	@Then("^Selected currency should be applied to the series$")
	public void selected_currency_should_be_applied_to_the_series() throws Throwable {
		SeriesByEditSeriesInfo(function);
	}
	@Then("^\"([^\"]*)\" popup should be opened$")
	public void popup_should_be_opened(String arg1) throws Throwable {
		
		try {
			String SeriesData_conversion_popup = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'movable-modal__active')]//*[@class='movable-modal--title-message']", 30).getText();
			if(SeriesData_conversion_popup.equals(arg1)) {
				login.Log4j.info(arg1 + " popup is displayed");
				CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,' movable-modal__active')]//*[@title='Close']", 20).click();
			//	CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,' movable-modal__full-screen')]//*[@title='Close']", 20).click();
//				CommonFunctionality.Views_list();
			}
		}catch(Exception e) {
			Assert.fail(arg1 + " popup is not displayed");
		}
	}
	@And("^Search with function \"([^\"]*)\"$")
	public void search_with_function(String arg1) throws Throwable {
		function = arg1;
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='table']//input[@placeholder='Type a function']", 20).sendKeys(function);	
		}

	@Then("^Searched functions should be displayed$")
	public void searched_functions_should_be_displayed() throws Throwable {
		CommonFunctionality.wait(2000);
		String Result_function = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='suggestions_list select-list']", 30).getText();
		login.Log4j.info("Expected function " + Result_function);
		if (Result_function.replaceAll("\n", "").contains(function)) {
			login.Log4j.info(function + " is displayed");
			try {
				//Close Edit Histogram window
				CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 8).click();
				//CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 6).click();
			} catch(Exception e) {
			 CommonFunctionality.getElementByXpath(login.driver, "//*[@class='sidebar-panel--header-close']", 8).click();
				
			}
			//CommonFunctionality.Views_list();
		} else {
			Assert.fail(function + " is not displayed ");
		}
	}

@And("^Select \"([^\"]*)\" as \"([^\"]*)\" from dropdown$")
public void select_as_from_dropdown(String arg1, String arg2) throws Throwable {
		if (arg1.equalsIgnoreCase("Frequency")) {
			DailyFrequency = arg2;
			CommonFunctionality.getElementByXpath(login.driver, "//*[@name='frequency']", 20).click();
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg2 + "')]", 20).click();
		} else if (arg1.equalsIgnoreCase("Missing values method")) {
			MissingValueMethod = arg2;
			CommonFunctionality.getElementByXpath(login.driver, "//*[@name='missing_values']", 20).click();
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg2 + "')]", 20).click();
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--window ui-resizable ui-draggable']//*[contains(text(),'Apply')]", 20).click();
		}
	
}
@Then("^The Series Hormonization popup should be minimized$")
public void the_Series_Hormonization_popup_should_be_minimized() throws Throwable {
	String Maximize = CommonFunctionality
			.getElementByXpath(login.driver, "//*[@class='movable-modal--header']/*[2]/*[1]", 30)
			.getAttribute("title");
	EditSeries_SeriesHormonization_popup(DatabasesTab.MinimizeVar, Maximize);
	
}
@Then("^The Series Hormonization popup should be maximized$")
public void the_Series_Hormonization_popup_should_be_maximized() throws Throwable {
	String Minimize = CommonFunctionality
			.getElementByXpath(login.driver, "//*[@class='movable-modal--header']/*[2]/*[1]", 5)
			.getAttribute("title");
	EditSeries_SeriesHormonization_popup(DatabasesTab.MaximizeVar, Minimize);
	
}

@Then("^The Series Hormonization popup should be displayed in full screen$")
public void the_Series_Hormonization_popup_should_be_displayed_in_full_screen() throws Throwable {
	String Exit_full_screen = CommonFunctionality
			.getElementByXpath(login.driver, "//*[@class='movable-modal--header']/*[2]/*[2]", 15)
			.getAttribute("title");
	EditSeries_SeriesHormonization_popup(DatabasesTab.FullScreenVar, Exit_full_screen);
}
@Then("^The Series Hormonization popup should be displayed in normal screen$")
public void the_Series_Hormonization_popup_should_be_displayed_in_normal_screen() throws Throwable {
	String full_screen = CommonFunctionality
			.getElementByXpath(login.driver, "//*[@class='movable-modal--header']/*[2]/*[2]", 5)
			.getAttribute("title");
	EditSeries_SeriesHormonization_popup(DatabasesTab.Exit_fullScreen, full_screen);
}
@Then("^The Series Hormonization popup should be closed$")
public void the_Series_Hormonization_popup_should_be_closed() throws Throwable {
	CommonFunctionality.wait(1000);
	if (login.driver.findElements(By.xpath("//*[@class='movable-modal--window ui-resizable ui-draggable']"))
			.size() == 0) {
		login.Log4j.info("The popup is closed");
		try {
			//Close Edit Histogram window
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 30).click();
			CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 10).click();
		} catch(Exception e) {
			
		}
		//CommonFunctionality.Views_list();
	} else {
		Assert.fail("The popup is not closed");
	}
}

	@And("^Click on frequency dropdown$")
	public void click_on_frequency_dropdown() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,	"(//*[contains(@class,'table--body-cell')]/child::*[@class='change-series-function']//following-sibling::*[@class='insight-action-panel--btn-title'])[1]/following::div[1]", 30).click();

	}

@Then("^List of frequenceies should be available$")
public void list_of_frequenceies_should_be_available() throws Throwable {
	CommonFunctionality.wait(2000);
   Boolean list_of_freq_menu = login.driver.findElement(By.xpath("//ul[contains(@class,'change-series-function--menu')]")).isDisplayed();
   if(list_of_freq_menu == true) {
	   login.Log4j.info("verification is pass");
   } else {
	   Assert.fail("List of frequencies menu is not displayed");
   }
}

@And("^Select frequence as \"([^\"]*)\"$")
public void select_frequence_as(String arg1) throws Throwable {
	Sfrequency = arg1.split("\\(");
	CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg1 + "']", 30).click();
}

@Then("^Selected frequency should be displayed in the series$")
public void selected_frequency_should_be_displayed_in_the_series() throws Throwable {
	
	String[] arr = Sfrequency[1].split("\\)");
	String aplliedFunction = Sfrequency[0];
	String aplliedFunction1 = arr[0];
	FunctionVerification(aplliedFunction.trim(), aplliedFunction1.trim());
	
}

	@And("^Click on currency dropdown$")
	public void click_on_currency_dropdown() throws Throwable {
		try {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='table']/*/*[2]/*[6]//*[contains(@class,'icon--context-menu-arrow')]", 30)
					.click();
		} catch (NoSuchElementException e) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='visual-series-list']/*/*/*[1]/*[5]//*[contains(@class,'icon--context-menu-arrow')]", 30)
					.click();
		}

	}

@And("^Select currency as \"([^\"]*)\"$")
public void select_currency_as(String arg1) throws Throwable {
	CommonFunctionality.getElementByXpath(login.driver, "//li//*[@title='" + arg1 + "']", 30).click();
}


@Then("^Selected currency should be displayed in the series$")
public void selected_currency_should_be_displayed_in_the_series() throws Throwable {
	String currencyStr = "US Dollars";
	FunctionVerification(currencyStr);
}
@And("^Click on type a function field in series level$")
public void click_on_type_a_function_field_in_series_level() throws Throwable {
	try {
	CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='table']//*[@class='current-function-input'])[1]", 30).click();
	}catch(NoSuchElementException e) {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='visual-series-list']/*/*/*[2]//input[@placeholder='Type a function']", 30).click();
	}
}

@Then("^List of functions dropdown should be opened$")
public void list_of_functions_dropdown_should_be_opened() throws Throwable {
	CommonFunctionality.wait(2000);
	   Boolean suggestions_list = login.driver.findElement(By.xpath("//ul[@class='suggestions_list select-list']")).isDisplayed();
	   if(suggestions_list == true) {
		   login.Log4j.info("verification is pass");
	   } else {
		   Assert.fail("suggestions list is not displayed");
	   }
}

@And("^Select a function$")
public void select_a_function() throws Throwable {
	CommonFunctionality.getElementByXpath(login.driver, "//*[@class='suggestions_list select-list']//li[1]", 30).click();
	CommonFunctionality.getElementByXpath(login.driver, "//*[@class='suggestions_list select-list']//li[1]", 30).click();
	CommonFunctionality.getElementByXpath(login.driver, "//*[@class='suggestions_list select-list']//li[1]", 30).click();
	try {
	function = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='table']//*[@class='series-function-item--body']", 30).getText();
	}catch(NoSuchElementException e) {
		function = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='visual-series-list']/*/*[6]/*[2]//*[@class='series-function-item--body']", 30).getText();
	}
	Applied_function = function.replaceAll("\n", "");
	login.Log4j.info(Applied_function);
}
@And("^Select any function$")
public void select_any_function() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='suggestions_list select-list']//li[1]", 30).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='suggestions_list select-list']//li[1]", 30)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='suggestions_list select-list']//li[1]", 30)
				.click();
		try {
			function = CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[@class='function-wizard--header']//*[@class='series-function-item--body']", 30)
					.getText();
		} catch (Exception e) {
			function = CommonFunctionality
					.getElementByXpath(login.driver, "//*[@title='Converts a series to a target currency']", 30)
					.getText();
		}
		Applied_function = function.replaceAll("\n", "");
		login.Log4j.info(Applied_function);
}
@Then("^The selected function should be applied to the series$")
public void the_selected_function_should_be_applied_to_the_series() throws Throwable {
	FunctionVerification(Applied_function);
}

	@And("^Click on type a function field$")
	public void click_on_type_a_function_field() throws Throwable {
		try {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='function-wizard--header']//input[@placeholder='Type a function']", 30).click();
		} catch (Exception e) {
			//in rename popup
			CommonFunctionality.getElementByXpath(login.driver,
					"//input[@placeholder='Type a function']", 30).click();
		}
	}

	@Then("^The selected function should be displayed$")
	public void the_selected_function_should_be_displayed() throws Throwable {
		CommonFunctionality.wait(3000);
		List<WebElement> series = login.driver
				.findElements(By.xpath("//*[@class='table']//*[@class='series-function-item--body']"));
		for (int i = 0; i < series.size(); i++) {
			CommonFunctionality.wait(500);
			String Expected_function = series.get(i).getText();
			login.Log4j.info("Expected function " + Expected_function);
			if (!Expected_function.replaceAll("\n", "").contains(Applied_function)) {
				Assert.fail(Applied_function + " is not displayed in function field");
			}
		}
		login.Log4j.info(Applied_function + " is displayed");
		try {
			// Close Edit Histogram window
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 8).click();
			CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 6).click();
		} catch (Exception e) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='sidebar-panel--header-close']", 8).click();
		}
		//CommonFunctionality.Views_list();

	}

@Then("^The selected function should be cancelled$")
public void the_selected_function_should_be_cancelled() throws Throwable {
	CommonFunctionality.wait(1000);
	Boolean function_remove = login.driver.findElement(By.xpath("//*[@class='series-functions' and not (@class='series-functions series-functions__has-functions-to-apply')]")).isDisplayed();
	
	if (function_remove == true) {
		login.Log4j.info("Selected function is cancelled");
		
	} else {
		Assert.fail("Selected funcion is not removed");
	}
}
@And("^Click on cancel function icon$")
public void click_on_cancel_function_icon() throws Throwable {
	CommonFunctionality.wait(2000);
	CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-function-item--remove-icon']", 30).click();
}
@And("^Select multiple functions$")
public void select_multiple_functions() throws Throwable {
	select_a_function();
	click_on_type_a_function_field_in_series_level();
	CommonFunctionality.getElementByXpath(login.driver, "//*[@class='suggestions_list select-list']//li[2]", 30).click();
	CommonFunctionality.getElementByXpath(login.driver, "//*[@class='suggestions_list select-list']//li[1]", 30).click();
	CommonFunctionality.getElementByXpath(login.driver, "//*[@class='suggestions_list select-list']//li[1]", 30).click();
	try {
	function = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='visual-series-list']/*/*[5]/*[2]//*[@class='functions-input-container']/*[2]/*[1]", 30).getText();
	
	}catch(Exception e) {
		function = CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Unit Multiplier']", 30).getText();
	}
	Applied_function1 = function.replaceAll("\n", "");
	login.Log4j.info(Applied_function1);
	
}

@Then("^The selected functions should be applied to the series$")
public void the_selected_functions_should_be_applied_to_the_series() throws Throwable {
	FunctionVerification(Applied_function, Applied_function1);
    
}
@And("^Select an invalid function$")
public void select_an_invalid_function() throws Throwable {
	CommonFunctionality.getElementByXpath(login.driver, "//*[@class='suggestions_list select-list']//li[@data-id='YTD']", 30).click();
	CommonFunctionality.getElementByXpath(login.driver, "//*[@class='suggestions_list select-list']//li[@data-id='sum']", 30).click();
	CommonFunctionality.getElementByXpath(login.driver, "//*[@class='suggestions_list select-list']//li[@data-id='1']", 30).click();
}

@Then("^The function cannot be applied to selected series popup should be closed$")
public void the_function_cannot_be_applied_to_selected_series_popup_should_be_closed() throws Throwable {
	CommonFunctionality.wait(2000);
	if(login.driver.findElements(By.xpath("//*[@class='modal-content sphere-modal__content']")).size() == 0) {
		login.Log4j.info("The function cannot be applied to selected series popup is cloased");
	} else {
		Assert.fail("The function cannot be applied to selected series popup not closed");
	}
}
@And("^Enter text in description field$")
public void enter_text_in_description_field() throws Throwable {
	CommonFunctionality.wait(2000);
   login.driver.findElement(By.xpath("//*[@class='feedback']//textarea")).sendKeys("Testing....,please ignore");
}

@And("^Click on cancel button$")
public void click_on_cancel_button() throws Throwable {
	CommonFunctionality.getElementByXpath(login.driver, "//*[@class='feedback--footer']//*[contains(text(),'Cancel')]", 30).click();
}

@Then("^The feedback popup should be closed$")
public void the_feedback_popup_should_be_closed() throws Throwable {
  if(login.driver.findElements(By.xpath("//*[@class='modal-content sphere-modal__content']")).size() == 0) {
	  login.Log4j.info("Feedback popup is closed");
  } else {
	  Assert.fail("Feedback popup is not closed");
  }
}

@Then("^The visual should change its size to selected size$")
public void the_visual_should_change_its_size_to_selected_size() throws Throwable {
	CommonFunctionality.wait(2000);
	String str = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='visual-item-container']", 30).getAttribute("style");
	String[] expected_size = str.split(";");
	String[] selected_proportion = expected_size[0].split(":");
	login.Log4j.info(selected_proportion[1]);
	if(selected_proportion[1].contains(String.valueOf(size))){
		login.Log4j.info("The visual is displayed in selected proportion");
		
	} else {
		Assert.fail("The visual is not displayed in selected proportion");
	}
}
	
@And("^Click on submit button$")
public void click_on_submit_button() throws Throwable {
	CommonFunctionality.getElementByXpath(login.driver, "//*[@class='feedback--footer']//*[contains(text(),'Submit')]", 30).click();
}

@Then("^\"([^\"]*)\" message should be displayed in a growl popup$")
public void message_should_be_displayed_in_a_growl_popup(String arg1) throws Throwable {
	CommonFunctionality.wait(500);
	WebElement ele = login.driver.findElement(By.xpath("//div[@class='growl-message-text']"));
	String GrowlText = ele.getText();
	login.Log4j.info(GrowlText);
	if(GrowlText.equals(arg1)) {
		login.Log4j.info(GrowlText + " is displayed for growl popup "); 
	} else {
		Assert.fail(GrowlText+ " is not displayed for growl popup");
	}
}
@Then("^The edit visual popup should be closed$")
public void the_edit_visual_popup_should_be_closed() throws Throwable {
   if(login.driver.findElements(By.xpath("//*[contains(@class,'movable-modal__full-screen')]")).size() == 0) {
	   login.Log4j.info("The edit visual popup closed");
   } else {
	   Assert.fail("The Edit visual popup not closed");
   }
}
@And("^Change title in edit visual window$")
public void change_title_in_edit_visual_window() throws Throwable {
	chnge_title = "Nadiya";
	CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--body']//*[@data-name='title']", 30).click();
	CommonFunctionality.wait(2000);
	CommonFunctionality.getElementByXpath(login.driver, "//*[@class='title-config']//input[@name='title']", 30).sendKeys(chnge_title);
	CommonFunctionality.wait(2000);
}

@Then("^The changes should be reflected to histogram visual and Edit visual popup should be closed$")
public void the_changes_should_be_reflected_to_histogram_visual_and_Edit_visual_popup_should_be_closed() throws Throwable {
	CommonFunctionality.wait(2000);
	String visualTxt = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='title']", 30).getText();
	if(visualTxt.equalsIgnoreCase(chnge_title)) {
		login.Log4j.info("Verification pass");
	} else {
		Assert.fail("The tile name not reflected in Histogram visual");
	}
	the_edit_visual_popup_should_be_closed();
}

	@And("^Click on \\+ icon on header$")
	public void click_on_icon_on_header() throws Throwable {
		try {
			CommonFunctionality.wait(2000);
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='visual-top-panel']//*[@data-action='add-to-insight']", 30).click();
		} catch (Exception e) {
			//click on + icon in expanded image visual window
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='vis-elem-menu vis-elem-menu__modal']/*[1]", 30).click();
		}
	}

@Then("^Below options should be displayed$")
public void below_options_should_be_displayed(List<String> list ) throws Throwable {
		CommonFunctionality.wait(1200);
		List<WebElement> List_of_options = null;

		List_of_options = login.driver.findElements(By.xpath("//*[@class='dropdown-menu context-menu ']/*[3]//li"));

		if (List_of_options.size() > 0) {
			// If add to insight options
			for (int i = 0; i < List_of_options.size(); i++) {
				String str = List_of_options.get(i).getText();
				if (list.contains(str)) {
					login.Log4j.info(str + " is displayed");
				} else {
					Assert.fail(str + " is not displayed");
				}

			}
		} else {

			CommonFunctionality.wait(1200);
			List_of_options = login.driver
					.findElements(By.xpath("//*[@class='find-and-replace--attribute-selector']/*"));
			if (List_of_options.size() > 0) {
				// Edit series options
				for (int i = 0; i < List_of_options.size(); i++) {
					String str = List_of_options.get(i).getText();
					if (list.contains(str.trim())) {
						login.Log4j.info(str.trim() + " is displayed");
					} else {
						Assert.fail(str.trim() + " is not displayed");
					}

				}
			} else {
				Assert.fail("Verification failed");
			}
		} 
   
}

	@Then("^Below options should be available$")
	public void below_options_should_be_available(List<String> list) throws Throwable {
		List<WebElement> List_of_options = null;
		CommonFunctionality.wait(1000);
		try {
			List_of_options = login.driver.findElements(By.xpath("//*[@class='select2-results']//li"));
		}catch(Exception e) {
			
		}
		if (List_of_options.size() > 0) {
			// auto name drop down
			for (int i = 0; i < List_of_options.size(); i++) {
				String str = List_of_options.get(i).getText();
				if (list.contains(str.trim())) {
					login.Log4j.info(str.trim() + " is displayed");
				} else {
					Assert.fail(str.trim() + " is not displayed");
				}

			}
		} else {
			List_of_options = login.driver.findElements(By.xpath(
					"//div[@class='items-wrapper']/li[not(@class='divider')]/span[contains(@class,'context-menu-item')]"));
			// Edit series drop down in series level
			if (List_of_options.size() > 0) {
				for (int i = 0; i < List_of_options.size(); i++) {
					String str = List_of_options.get(i).getAttribute("title");
					if (list.contains(str.trim())) {
						login.Log4j.info(str.trim() + " is displayed");
					} else {
						Assert.fail(str.trim() + " is not displayed");
					}
				}
			} else {
				Assert.fail("Verification failed");

			}
		}
		
		CommonFunctionality.wait(500);
		try {
		CommonFunctionality.getElementByXpath(login.driver,"//ul[@class='select2-results']//li[1]", 30).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'movable-modal__active')]//*[@class='movable-modal--close']", 6).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='modal-window modal-window__active']//*[text()='Ok']", 6)
				.click();
		}catch(Exception e1) {
			
		}
		
	

	}
@And("^Open dropdown for auto name$")
public void open_dropdown_for_auto_name() throws Throwable {
	CommonFunctionality.wait(1200);
	List<WebElement> autonames_selected = login.driver
			.findElements(By.xpath("//*[@class='select2-search-choice-close custom select-behaviour--multi-select-item-delete icon--red-cross']"));
	if(autonames_selected.size() > 0) {
		for (int i = 0; i < autonames_selected.size(); i++) {
			autonames_selected.get(i).click();
		}
	}
	CommonFunctionality.getElementByXpath(login.driver, "//*[@class='add-item-attribute btn']", 30).click();
}
@Then("^The changes should be applied to only visual and its series in edit series panel NOT for my series$")
public void the_changes_should_be_applied_to_only_visual_and_its_series_in_edit_series_panel_NOT_for_my_series() throws Throwable {
	//Save changes
	CommonFunctionality.getElementByXpath(login.driver,"//*[@class='find-and-replace--footer']//button[contains(text(),'OK')]",6).click();
	//verify rename popup should be closed
	CommonFunctionality.wait(2000);
	if(login.driver.findElements(By.xpath("//*[@class='movable-modal--window ui-resizable ui-draggable']")).size() == 0) {
		login.Log4j.info("Rename popup is closed");
	} else {
		fail("The rename popup is not closed");
	}
		
	SeriesName = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-name--title']", 30).getText();
	login.driver.navigate().refresh();
	Visual_Title_txt = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='title']", 30).getText();
	//select My series tab
	CommonFunctionality.getElementByXpath(login.driver, "//*[@data-id='myseries']", 30).click();
	String sname_from_myseries_tab = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-name-field--series-name']", 30).getText();
	if(EditSeriesName.equalsIgnoreCase(SeriesName) && EditSeriesName.equalsIgnoreCase(Visual_Title_txt) && !EditSeriesName.equalsIgnoreCase(sname_from_myseries_tab)) {
		login.Log4j.info("Verification pass");
	} else {
		Assert.fail("Verification failed");
	}
	
}

@Then("^The Histogram visual should be created in vew tab on current insight$")
public void the_Histogram_visual_should_be_created_in_vew_tab_on_current_insight() throws Throwable {
		List<WebElement> views = login.driver.findElements(
			By.xpath("//*[contains(@class,'insight-page-view-tab') and contains(text(),'View')]"));
	if(views.size() > 1) {
		CommonFunctionality.wait(1000);
		String titileTxt = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='main-page--insight-active-page']//*[@class='visual-title visual-title--wrapper'][1]//*[@data-name='title']", 15)
				.getText();
		if(Visual_Title_txt.equalsIgnoreCase(titileTxt)) {
			login.Log4j.info("The Histogram visual is created in view tab");
		} else {
			Assert.fail("The Histogram visual is not created in view tab");
		}
		
	}
}

/*@Then("^Paste in Excel and the visual should be pasted in excel$")
public void paste_in_Excel_and_the_visual_should_be_pasted_in_excel() throws Throwable {
	PasteToExcel();
	CommonFunctionality.DeleteVisual();
}*/
@Then("^Histogram visual and related series should be downloaded in excel$")
public void histogram_visual_and_related_series_should_be_downloaded_in_excel() throws Throwable {
	CommonFunctionality.getTheNewestFile(Commentary.format);
	File_delete.delete();
	
	}
@Then("^Histogram visual should be downloaded in PDF format$")
public void histogram_visual_should_be_downloaded_in_PDF_format() throws Throwable {
	CommonFunctionality.getTheNewestFile(Commentary.format);
	File_delete.delete();
}
@Then("^Histogram visual should be downloaded in PNG format$")
public void histogram_visual_should_be_downloaded_in_PNG_format() throws Throwable {
	CommonFunctionality.getTheNewestFile(Commentary.format);
	File_delete.delete();
}
@Then("^Histogram visual should be downloaded in JPG format$")
public void histogram_visual_should_be_downloaded_in_JPG_format() throws Throwable {
	CommonFunctionality.getTheNewestFile(Commentary.format);
	File_delete.delete();
}

@And("^Select width size \"([^\"]*)\"$")
public void select_width_size(String arg1) throws Throwable {
	histogramVisual_width = Integer.parseInt(arg1);
	CommonFunctionality.wait(2000);
	CommonFunctionality.getElementByXpath(login.driver, "//*[@class='visual-image-download--width-options']/*[2]/*[2]", 30).click();
}

@Then("^The visual should be downloaded with selected size$")
public void the_visual_should_be_downloaded_with_selected_size() throws Throwable {
	CommonFunctionality.getTheNewestFile(Commentary.format);
	CommonFunctionality.wait(5000);
	if(CommonFunctionality.width == histogramVisual_width) {
		login.Log4j.info("The histogram/pie visual is downloaded in selected size");
	} else {
		Assert.fail("The histogram visual/pie not downloaded with selected size");
	}
	File_delete.delete();
}
@Then("^Histogram visual should be pasted$")
public void histogram_visual_should_be_pasted() throws Throwable {
	String ExpectedTitle = CommonFunctionality
			.getElementByXpath(login.driver, "//*[@data-name='title']", 10).getText();
	if (Visual_Title_txt.equals(ExpectedTitle)) {
		login.Log4j.info("Histogram visual is pasted");
	} else {
		Assert.fail("Histogram visual is not pasted");
	}
	
}
@Then("^Histogram should be cut$")
public void histogram_should_be_cut() throws Throwable {
	comm.commentary_should_be_cut();
}
@Then("^Histogram should be deleted$")
public void histogram_should_be_deleted() throws Throwable {
	comm.commentary_should_be_deleted();
}
@And("^Select View as > \"([^\"]*)\"$")
public void select_View_as(String arg1) throws Throwable {
	CommonFunctionality.getElementByXpath(login.driver, "//li//*[contains(text(),'View as')]", 30).click();
	
	if(arg1.equals("Pie")) {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@data-action='pie_chart']", 30).click();
	} else if(arg1.equals("Heat map")) {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@data-action='heatmap']", 30).click();
	} else {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@data-action='" + arg1.toLowerCase() + "']", 30).click();
	}
}

@Then("^The \"([^\"]*)\" visual should be converted as \"([^\"]*)\" visual$")
public void the_visual_should_be_converted_as_visual(String arg1, String arg2) throws Throwable {
	CommonFunctionality.wait(3000);
	WebElement EditVisual = login.driver
			.findElement(By.xpath("//*[@class='visual-top-panel--left-controls']//button[1]"));
	if (EditVisual.getText().contains(arg2)) {
		login.Log4j.info(arg2 + " visual is created");
	} else if(arg2.equalsIgnoreCase("Histogram")){
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='visual-item-template--header']", 30).click();
		CommonFunctionality.wait(1000);
		WebElement EditVisual1 = login.driver
				.findElement(By.xpath("//*[@class='visual-top-panel--left-controls']//button[1]"));
		if (EditVisual1.getText().contains(arg2)) {
			login.Log4j.info(arg2 + " visual is created");
		} else {
			Assert.fail(arg2 + " visual is not created");
		}
	} else {
		Assert.fail(arg2 + " visual is not created");
	}
}
@And("^Select function \"([^\"]*)\"$")
public void select_function1(String arg1) throws Throwable {
	function = arg1;
	CommonFunctionality.getElementByXpath(login.driver, "//*[@class='popular-functions-context']//*[@data-id='" + arg1 + "']", 30).click();
}
@Then("^The Selected function should be applied for the series$")
public void the_Selected_function_should_be_applied_for_the_series() throws Throwable {
	CommonFunctionality.getElementByProperty(login.driver, "MyInsight_Tab", 10).click();
	String series_title_text = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-name-field-title']", 30).getText();
	if(series_title_text.contains(function)) {
		login.Log4j.info("The selected function applied for the series");
	} else {
		Assert.fail("The selected function not applied for the series");
	}
}
@Then("^The function should be applied for the series$")
public void the_function_should_be_applied_for_the_series() throws Throwable {
		CommonFunctionality.wait(3000);
		List<WebElement> timepoints = login.driver.findElements(
				By.xpath("(//*[contains(@class,'highcharts-pie-series highcharts-tracker')])[1]"));
		for (int i = 0; i <= timepoints.size(); ) {
			new Actions(login.driver).moveToElement(timepoints.get(i)).pause(50).build().perform();
			WebElement element = login.driver.findElement(
					By.xpath("//*[@class='table-tooltip']/*[2]"));
			String TooltipTxt = element.getText();
			login.Log4j.info("Time_point_value " + TooltipTxt);
			if (TooltipTxt.contains(function)) {
				login.Log4j.info("The selected function applied for the series");
			} else {
				Assert.fail("The selected function not applied for the series");
			}

			break;
		}
}
@Then("^The edit series popup should be opened with \"([^\"]*)\" tab$")
public void the_edit_series_popup_should_be_opened_with_tab(String arg1) throws Throwable {
   	CommonFunctionality.wait(2000);
	if(login.driver.findElement(By.xpath("//*[@class='sidebar-panel--tab sidebar-panel--tab__active']/*[2]/*[1]")).getText().contains(arg1)) {
		login.Log4j.info("The edit series popup is opened with "+ arg1 + "tab");
	} else {
		Assert.fail("The edit series popup is not opened with "+ arg1 + "tab");
	}
}
@Then("^The content should be removed$")
public void the_content_should_be_removed() throws Throwable {
	CommonFunctionality.wait(2000);
	
	if (login.driver.findElements(By.xpath("//*[contains(@class,'empty-data')]")).size() == 1) {
		login.Log4j.info("All the contents has been removed");
	} else {
		Assert.fail("All the contents has not been removed");
	}
}

@Then("^All the changes should be revert back to default$")
public void all_the_changes_should_be_revert_back_to_default() throws Throwable {
	CommonFunctionality.wait(1000);
	Boolean Series = login.driver
			.findElement(By.xpath("//*[@class='highcharts-legend-item highcharts-scatter-series highcharts-color-undefined highcharts-series-0']"))
			.isDisplayed();
	
	if (Series == true) {
		login.Log4j.info("All the changes revert back to default");
	} else {
		Assert.fail("All the changes not revert back to default ");
	}
}
@Then("^The Reset format option should be disabled$")
public void the_Reset_format_option_should_be_disabled() throws Throwable {
    CommonFunctionality.wait(2000);
    if(login.driver.findElement(By.xpath("//*[@data-action='reset']")).getAttribute("class").contains("disabled")) {
    	login.Log4j.info("The Reset option is disabled");
    } else {
    	Assert.fail("The Reset option is not disabled");
    }
    	
}
@Then("^\"([^\"]*)\" and \"([^\"]*)\" options should be displayed$")
public void and_options_should_be_displayed(String arg1, String arg2) throws Throwable {
	CommonFunctionality.wait(2000);
	String histogram = login.driver.findElement(By.xpath("//*[@data-action='download_visual']/*[1]")).getText();
	String view = login.driver.findElement(By.xpath("//*[@data-action='download_view']/*[1]")).getText();
	if(arg1.equals(histogram) && arg2.equals(view)) {
		login.Log4j.info(arg1 + " AND "+ arg2 + " options are displayed"); 
	} else {
		Assert.fail(arg1 + " AND "+ arg2 + " options are not displayed");
	}
}
@And("^Select Histogram$")
public void select_Histogram() throws Throwable {
	CommonFunctionality.getElementByXpath(login.driver, "//*[@data-action='download_visual']/*[1]", 30).click();
}

@Then("^Download popup should be displayed with Histogram tab selection$")
public void download_popup_should_be_displayed_with_Histogram_tab_selection() throws Throwable {
	CommonFunctionality.wait(2000);
    if(login.driver.findElement(By.xpath("//*[@class='modal-window insight-download modal-window__active']//*[@data-tab='visual']")).getAttribute("class").contains("active")) {
    	login.Log4j.info("Verification is pass");
    } else {
    	Assert.fail("Download popup not displayed with histogram tab selection");
    }
}
@And("^Select View$")
public void select_View() throws Throwable {
	CommonFunctionality.getElementByXpath(login.driver, "//*[@data-action='download_view']/*[1]", 30).click();
}

@Then("^Download popup should be displayed with views tab selection$")
public void download_popup_should_be_displayed_with_views_tab_selection() throws Throwable {
	CommonFunctionality.wait(2000);
    if(login.driver.findElement(By.xpath("//*[@class='modal-window insight-download modal-window__active']//*[@data-tab='views']")).getAttribute("class").contains("active")) {
    	login.Log4j.info("Verification is pass");
    } else {
    	Assert.fail("Download popup not displayed with views tab selection");
    }
}
@And("^Unhighlight the visual$")
public void unhighlight_the_visual() throws Throwable {
	CommonFunctionality.getElementByXpath(login.driver, "//*[@class='visual-top-panel--content']", 30).click();
}

@Then("^The visual options should be hidden$")
public void the_visual_options_should_be_hidden() throws Throwable {
	if(login.driver.findElements(By.xpath("//*[@class='insight-visual insight-visual__can-hover']")) .size() == 1) {
		login.Log4j.info("The visual options is hidden");
	} else {
		Assert.fail("The visual options not hidden");
	}
    
}

@Then("^The changes should be saved and rename popup remains displayed$")
public void the_changes_should_be_saved_and_rename_popup_remains_displayed() throws Throwable {
	String ExpectedValue = CommonFunctionality
			.getElementByXpath(login.driver, "//*[@class='find-and-replace-item--name']//input", 5)
			.getAttribute("value");
	// Check if rename popup is appeared after selecting Apply
	String Rename_popup_txt = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='find-and-replace--modal-title']", 20).getText();
	if(Rename_popup_txt.contains("Rename")) {
		login.Log4j.info("Rename popup is displayed");
	} else {
		Assert.fail("Rename popup is not displayed after selecting Apply button");
	}
	String Series = CommonFunctionality
			.getElementByXpath(login.driver, "//*[@class='visual-series-name']//*[@class='series-name--title']", 5)
			.getText();
	if (Series.contains(ExpectedValue)) {
		login.Log4j.info(ExpectedValue + " is displayed in seres name " + Series);
		//CommonFunctionality.Views_list();
	} else {
		Assert.fail("Verification is failed");
	}
	// close rename popup
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 4).click();
}

void PasteToExcel() throws Throwable {
	CommonFunctionality.wait(3000);
	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	String Clipboard_data = (String) clipboard.getData(DataFlavor.stringFlavor);
	login.Log4j.info(Clipboard_data);
	XSSFSheet sheet;
	XSSFWorkbook wb = new XSSFWorkbook();
	File file = new File(System.getProperty("user.dir") + "\\" + "Histogram_copy.xlsx");
	FileOutputStream fileOut = new FileOutputStream(file);

	if (file.exists()) {
		try {
			wb = (XSSFWorkbook) WorkbookFactory.create(file);
		} catch (Exception e) {
			// e.printStackTrace();
		}
		sheet = wb.createSheet("Copy");
	} else {
		wb = new XSSFWorkbook();
		sheet = wb.createSheet("sheet1");
	}
	sheet = wb.getSheetAt(0);
	int rownum = 0;
	int columnCount = 0;
	Row row = sheet.createRow(rownum);
	Cell cell = row.createCell(columnCount);

	 //sheet.getRow(0).getCell(0);
//	CommonFunctionality.wait(2000);
//	Action seriesOfActions = action.keyDown(Keys.CONTROL).sendKeys(Clipboard_data).keyUp(Keys.CONTROL).build();
//	seriesOfActions.perform();
	// action.keyDown(Keys.CONTROL).sendKeys(Clipboard_data).keyUp(Keys.CONTROL).build().perform();
	 sheet.getRow(0).getCell(0);
//	 cell.getCellStyle();
	 cell.getRow();
	Robot robot = new Robot();
	  robot.keyPress(KeyEvent.VK_CONTROL); 
	  robot.keyPress(KeyEvent.VK_V);
	  CommonFunctionality.wait(1000); 
	  robot.keyRelease(KeyEvent.VK_V);
	  robot.keyRelease(KeyEvent.VK_CONTROL);
	  CommonFunctionality.wait(1000);
	  robot.keyPress(KeyEvent.VK_ENTER);
	  robot.keyRelease(KeyEvent.VK_ENTER);
	 
	// int rowcount = sheet.getLastRowNum();
	/*
	 * for (int i = 0; i <= rowcount; i++) { String ActualDes =
	 * sheet.getRow(i).getCell(0).getStringCellValue(); if
	 * (ExpectedDescription.equalsIgnoreCase(ActualDes)) {
	 * login.Log4j.info(ExpectedDescription + " copied to Excel"); } else {
	 * Assert.fail("Selected series are not copied to Excel"); } }
	 */
	wb.write(fileOut);
	fileOut.close();
}

void VisualSelection(String Selected_visual) throws Exception {
		CommonFunctionality.wait(3000);
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
		//CommonFunctionality.Views_list();
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
		Commentary.ColorValidation(background_color,ActualColor);
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 6).click();
		//CommonFunctionality.Views_list();
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
		CommonFunctionality.wait(2000);
		List<WebElement> snames = login.driver
				.findElements(By.xpath("//*[@class='visual-series-name']//*[@class='series-name--title']"));
		if (snames.size() == 1) {
			String Series = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='visual-series-name']//*[@class='series-name--title']", 8).getText();
			if (Series.contains(SelectedFunction)) {
				login.Log4j.info(SelectedFunction + " is displayed in seres name");

			} else {
				Assert.fail(SelectedFunction + " Series is not displayed in series name");
			}
		} else {
			for (int i = 0; i < snames.size(); i++) {
				String Series = snames.get(i).getText();
				login.Log4j.info(Series);
				if (i == 1) {
					if (!Series.contains(SelectedFunction)) {
						login.Log4j.info("Selected currency is applied only selected series");

					} else {
						Assert.fail("Selected currency is not applied only selected series");
					}
				} else {
					if (Series.contains(SelectedFunction)) {
						login.Log4j.info(SelectedFunction + " is displayed in seres name");

					} else {
						Assert.fail(SelectedFunction + " Series is not displayed in series name");
					}
				}

			}
		}

	}

	void FunctionVerification(String function1, String function2) throws Exception {
		CommonFunctionality.wait(2000);
		List<WebElement> list = login.driver
				.findElements(By.xpath("//*[@class='visual-series-name']//*[@class='series-name--title']"));
		if (list.size() == 1) {
			String Series = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='visual-series-name']//*[@class='series-name--title']", 8).getText();
			if (Series.contains(function1) && Series.contains(function2)) {
				login.Log4j.info("Seleted function is displayed in seres name");

			} else {
				Assert.fail("Selected function is not displayed in series name");
			}
		} else {
			for (int i = 0; i < list.size(); i++) {
				String Series = list.get(i).getText();
				login.Log4j.info(Series);

				if (i == 1) {
					if (!Series.contains(function1) && !Series.contains(function2)) {
						login.Log4j.info("Seleted function is applied only selected series");

					} else {
						Assert.fail("Seleted function is not applied only selected series");
					}
				} else {
					
					if (Series.contains(function1) && Series.contains(function2)) {
						login.Log4j.info("Seleted function is displayed in seres name");

					} else {
						Assert.fail("Selected function is not displayed in series name");
					}
				}

			}
		}

	}

	void RenamePopup(String Var, String movable_modal_action) throws Exception {
		login.Log4j.info(Var);
		if (!Var.equals(movable_modal_action)) {
			login.Log4j.info("The popup is " + Var);
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='movable-modal--header']/*[2]/*[@title='Close']", 5)
					.click();
			//CommonFunctionality.Views_list();
		} else {
			Assert.fail("The popup is not " + Var);
		}
	}
	void EditSeries_SeriesHormonization_popup(String Var, String movable_modal_action) throws Throwable {
		login.Log4j.info(Var);
		if (!Var.equals(movable_modal_action)) {
			login.Log4j.info("The popup is " + Var);
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='movable-modal--window ui-resizable ui-draggable']//*[@title='Close']", 20)
					.click();
			try {
				//Close Edit Histogram window
				CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 30).click();
				CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 10).click();
			} catch(Exception e) {
				
			}
			//CommonFunctionality.Views_list();
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
		//	CommonFunctionality.Views_list();
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
			//CommonFunctionality.Views_list();
		} else {
			Assert.fail(ExpectedResult + " Series is not displayed in series name");
		}
	}

	void BeforeEditSeriesInfo(String EditSeriesInfo) throws Exception {
		List<WebElement> list = 	
				CommonFunctionality.getElementsByXpath(login.driver,
				"//*[@class='find-and-replace-item--name']//input");
		for (int i = 0; i < list.size(); i++) {
			BeforeEditSeries.add(list.get(i).getAttribute("value"));
			list.get(i).clear();
			CommonFunctionality.wait(300);
			list.get(i).sendKeys(EditSeriesInfo);
		}
	}

	void CloseIconValidation() throws Throwable {
		CommonFunctionality.wait(1000);
		if (login.driver.findElements(By.xpath("//*[@class='movable-modal--window ui-resizable ui-draggable']"))
				.size() == 0) {
			login.Log4j.info("The popup is closed");
			//CommonFunctionality.Views_list();
		} else {
			Assert.fail("The popup is not closed");
		}
	}

	void OriginalSeriesInfo(List<String> BeforeEditSeriesInfo) throws Exception {
		CommonFunctionality.wait(500);
		List<WebElement> series_list = CommonFunctionality.getElementsByXpath(login.driver,
				"//*[@class='find-and-replace-item--name']//input");
		for (int i = 0; i < series_list.size(); i++) {
			String OriginalSeriesInfo = series_list.get(i).getAttribute("value");
			if (BeforeEditSeriesInfo.contains(OriginalSeriesInfo)) {
				login.Log4j.info("PASS");
				
			} else {
				Assert.fail("Verification failed");
			}
		}
			try {
				CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 6)
						.click();
				// when some changes have not been saved popup appear
				CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 5).click();
			} catch (Exception e) {

			}
		
	}
	void Uncheck_Copyright() {
		CommonFunctionality.wait(1000);
		Boolean isChecked = login.driver
				.findElement(By.xpath(
						"//*[contains(@title,'Source. Configure displaying of the source')]//input[@type='checkbox']"))
				.isSelected();
		if (isChecked == true) {
			login.driver.findElement(By.xpath(
					"//*[contains(@title,'Source. Configure displaying of the source')]//span[@class='input-control--indicator']"))
					.click();
		}
	}
	public static void DropdownOptions(String[] exp , List<WebElement> dropdown_options) {
		int i = 0;
		for (String str : exp) {
			boolean match = false;
			for (int j = i; j < dropdown_options.size();) {
				String X = dropdown_options.get(j).getAttribute("title");
				if (X.equals(str)) {
					match = true;
					System.out.println(str + " option is displayed");
					i = j + 1;
					break;
				}
			}
			
			if (match == false) {
				Assert.fail();
			}
		}
	}
	void CheckShowSeries() {
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
	}

}
