package CDMNext.StepDefinations;

import static org.junit.Assert.assertNotEquals;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;
import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class Comparables {

	JavascriptExecutor js = (JavascriptExecutor) login.driver;
	SoftAssert sa = new SoftAssert();
	CDMNextSprintCases cv = new CDMNextSprintCases();
	ReleasesTab rt = new ReleasesTab();
	DatasetsTab dt = new DatasetsTab();
	public WebElement dropdown_open;
	public int count;
	public int comparables_count;
	public int series_count_in_first_table;
	public WebElement element;
	public static String series_name;
	public static String copied_link;
	public static String section_name;
	public static String section_link;
	public static String selected_series_id;
	public static String table_text;
	public static String filter_text;
	public static String filter_text1;
	public static String Series_item_id;
	public static String Series_item_id_without_click;
	public static String hovered_series_name;
	public static String related_data_text;
	public static String related_dataset_text;
	public static String insight_text;
	public int series_count;
	public int filterCount;
	public int filterCount1;
	public int filter_actual_count;
	public int sum;
	public static int series_count_inside_table;
	public int series_count_inside_table_deselect;
	public static int series_count_inside_first_table;
	ArrayList<Integer> fil_count = new ArrayList<Integer>();
	ArrayList<String> series_values = new ArrayList<String>();
	public static ArrayList<String> series_values_in_table = new ArrayList<String>();
	ArrayList<String> myseries_values = new ArrayList<String>();
	ArrayList<String> excel_values = new ArrayList<String>();
	ArrayList<String> table_excel_values = new ArrayList<String>();
	ArrayList<String> visualtitle = new ArrayList<String>();

	@SuppressWarnings("deprecation")
	@And("^Clicking \"([^\"]*)\" icon$")
	public void clicking_icon(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);
		WebElement show = CommonFunctionality.getElementBycssSelector(login.driver, ".series-tab.ui-sortable-handle",
				4);
		if (!(show.getAttribute("class").contains("series-tab__hidden"))) {
			if (arg1.equalsIgnoreCase("Data")) {
				new Actions(login.driver)
						.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
								"//*[contains(@class,'ui-sortable-handle')]//*[contains(text(),'" + arg1 + "')]", 4))
						.pause(1000).click().build().perform();
			} else {
				new Actions(login.driver).moveToElement(
						CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 4))
						.pause(1000).click().build().perform();
			}
		}
		CommonFunctionality.wait(4000);
	}

	@And("^Clicking Collapse tree$")
	public void clicking_Collapse_tree() throws Throwable {
		CommonFunctionality.CollapseTreeMethod();
	}

	@And("^Clicking Unselect method$")
	public void clicking_Unselect_method() throws Throwable {
		CommonFunctionality.UnselectMethod();
	}

	@And("^Count the number of texts in header$")
	public void count_the_number_of_texts_in_header() throws Throwable {
		WebElement show = CommonFunctionality.getElementBycssSelector(login.driver, ".series-tab.ui-sortable-handle",
				4);
		if (!(show.getAttribute("class").contains("series-tab__hidden"))) {
			List<WebElement> texts = login.driver.findElements(
					By.xpath("//*[@class='search-presentation-tabs--visible']//span[@class='series-tab--text']"));
			count = texts.size();
			System.out.println("Header count is: " + count);
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Click three dots in search pane$")
	public void click_three_dots_in_search_pane() throws Throwable {
		CommonFunctionality.wait(3000);
		WebElement dots = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='search-presentation-tabs--drop-down']", 4);
		new Actions(login.driver).moveToElement(dots).pause(2000).click().build().perform();
		CommonFunctionality.wait(2000);
	}

	@SuppressWarnings("deprecation")
	@And("^Clicking \"([^\"]*)\" section from Comparables tab$")
	public void clicking_section_from_Comparables_tab(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Table: Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia")) {
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(text(),'Global Economic Monitor')]/following::div[@class='toggle'][1]", 4)
					.click();
		} else {
			WebElement ele = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]",
					4);
			new Actions(login.driver).moveToElement(ele).pause(2000).click().build().perform();
		}
	}

	@And("^Select (\\d+) series inside table$")
	public void select_series_inside_table(int arg1) throws Throwable {
		series_count_inside_table = arg1;
		WebElement ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
		for (int i = 1; i <= li_All.size(); i++) {
			WebElement check = CommonFunctionality.getElementByXpath(login.driver,
					"//li[" + i + "]//span[contains(@class,'series-list-item--checkbox')]", 4);
			new Actions(login.driver).moveToElement(check).click().build().perform();
			if (i == series_count_inside_table) {
				break;
			}
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Unselect (\\d+) series inside table$")
	public void unselect_series_inside_table(int arg1) throws Throwable {
		series_count_inside_table = arg1;
		for (int i = 1; i <= series_count_inside_table; i++) {
			WebElement check = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(text(),'" + hovered_series_name + "')]/preceding::span[1]", 4);
			new Actions(login.driver).moveToElement(check).pause(1000).click().build().perform();
		}
	}

	@And("^Verify Subscribed series only filter under filters$")
	public void verify_Subscribed_series_only_filter_under_filters() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'search-filters-panel ps-container')]//*[text()='More']", 4).click();
		CommonFunctionality.wait(200);
		dropdown_open = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'dropdown--body__open')]", 4);
	}

	@And("^Deselect (\\d+) series inside table$")
	public void deselect_series_inside_table(int arg1) throws Throwable {
		series_count_inside_table_deselect = arg1;
		WebElement ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
		for (int i = 1; i <= li_All.size(); i++) {
			WebElement check = CommonFunctionality.getElementByXpath(login.driver,
					"//li[" + i + "]//span[contains(@class,'series-list-item--checkbox')]", 4);
			new Actions(login.driver).moveToElement(check).doubleClick().build().perform();
			if (i == series_count_inside_table_deselect) {
				break;
			}
		}
	}

	@And("^Click \"([^\"]*)\" option from top$")
	public void click_option_from_top(String arg1) throws Throwable {
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath", "//*[contains(@title,'" + arg1 + "')]");
	}

	@SuppressWarnings("deprecation")
	@And("^Clicking \"([^\"]*)\" option from Series list$")
	public void clicking_option_from_Series_list(String arg1) throws Throwable {
		hovor_on_to_i_icon_without_click();
		WebElement hovor = CommonFunctionality.getElementByXpath(login.driver,
				"//ul[contains(@class,'search-series-list')]//li[1]//*[@class='add-to-data-selection--title']", 4);
		new Actions(login.driver).moveToElement(hovor).pause(1000).build().perform();
		WebElement dropdown = CommonFunctionality.getElementByXpath(login.driver,
				"//ul[contains(@class,'search-series-list')]//li[1]//*[@class='add-to-data-selection--title']//*[contains(@class,'"
						+ arg1 + "')]",
				4);
		new Actions(login.driver).moveToElement(dropdown).pause(1000).click().build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Clicking \"([^\"]*)\" option from Table$")
	public void clicking_option_from_Table(String arg1) throws Throwable {
		new Actions(login.driver)
				.moveToElement(
						CommonFunctionality.getElementByClassName(login.driver, "add-to-data-selection--title", 4))
				.pause(500).build().perform();
		WebElement icon = CommonFunctionality.getElementByClassName(login.driver, "" + arg1 + "", 4);
		new Actions(login.driver).moveToElement(icon).pause(1000).click().build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Clicking \\+ option from series$")
	public void clicking_option_from_series() throws Throwable {
		WebElement hovor = CommonFunctionality.getElementBycssSelector(login.driver, ".series-item--country", 4);
		new Actions(login.driver).moveToElement(hovor).pause(500).build().perform();
		WebElement hovor1 = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='series-list-item--container']//*[@class='add-to-data-selection--toggle']", 4);
		new Actions(login.driver).moveToElement(hovor1).click().build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^The \"([^\"]*)\" option for series should present$")
	public void the_option_for_series_should_present(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("series-data-set--table-name")) {
			related_data_text = CommonFunctionality
					.getElementByXpath(login.driver, "(//*[@class='series-data-set--table-name'])[1]", 4).getText();
			CommonFunctionality.wait(2000);
			CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='series-data-set--table-name'])[1]", 4)
					.click();
		} else {
			WebElement click = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(text(),'" + arg1 + "')]", 4);
			CommonFunctionality.wait(2000);
			new Actions(login.driver).moveToElement(click).pause(1000).click().build().perform();
		}
	}

	@SuppressWarnings("deprecation")
	@And("^The \"([^\"]*)\" option in series should present$")
	public void the_option_in_series_should_present(String arg1) throws Throwable {
		WebElement text;
		CommonFunctionality.wait(2000);
		if (arg1.equalsIgnoreCase("Related Insights")) {
			if (login.driver.findElements(By.xpath("//*[contains(text(),'Insights')]")).size() > 0) {
				text = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Insights')]", 4);
				js.executeScript("arguments[0].scrollIntoView(true);", text);
				if (!(text.isDisplayed())) {
					sa.fail("Verification Failed");
				}
			} else {
				CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'My insights')]", 4).click();
				CommonFunctionality.getElementBycssSelector(login.driver, "button[title='New Insight']", 4).click();
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[text()='Create insight' and contains(@class,'button__primary')]", 4).click();
				WebElement source = CommonFunctionality.getElementByXpath(login.driver,
						"(//*[@class='series-item--name'])[1]", 4);
				WebElement target = CommonFunctionality.getElementBycssSelector(login.driver,
						".data-selection-series-overlay.data-selection-series-overlay__data  ", 4);
				new Actions(login.driver).moveToElement(source).pause(2000).dragAndDrop(source, target).build()
						.perform();
				login.driver.navigate().refresh();
				clicking_icon("Releases");
				rt.expand_first_dataset();
				hovor_on_to_i_icon_without_click();
				click_option_in_series("Show related data");
				text = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Insights')]", 4);
				js.executeScript("arguments[0].scrollIntoView(true);", text);
				if (!(text.isDisplayed())) {
					sa.fail("Verification Failed");
				}
				CommonFunctionality.DeleteSeries();
			}
		} else {
			text = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 4);
			js.executeScript("arguments[0].scrollIntoView(true);", text);
			if (!(text.isDisplayed())) {
				sa.fail("Verification Failed");
			}
		}
		login.Log4j.info("The " + arg1 + " block is present");
	}

	@And("^The \"([^\"]*)\" option in series should be present$")
	public void the_option_in_series_should_be_present(String arg1) throws Throwable {
		WebElement text;
		CommonFunctionality.wait(2000);
		if (arg1.equalsIgnoreCase("related-series-data--status")) {
			text = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'" + arg1 + "')]", 4);
			js.executeScript("arguments[0].scrollIntoView(true);", text);
			assertTrue(text.isDisplayed());
		}
		if (arg1.equalsIgnoreCase("related-series-data--remarks")) {
			text = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='" + arg1 + "']", 4);
			js.executeScript("arguments[0].scrollIntoView(true);", text);
			String remarks = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='" + arg1 + "']//span", 4)
					.getText();
			sa.assertEquals(remarks, "Remarks:");
		}
	}

	@And("^The \"([^\"]*)\" Insight should present$")
	public void the_Insight_should_present(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("First")) {
			insight_text = CommonFunctionality
					.getElementByXpath(login.driver, "(//*[contains(@class,'insight-table-item--title-link')])[1]", 4)
					.getText();
		} else {
			insight_text = arg1;
			WebElement text = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(text(),'" + insight_text + "')]", 4);
			js.executeScript("arguments[0].scrollIntoView(true);", text);
			if (!(text.isDisplayed())) {
				fail("Verification Failed");
			}
		}
	}

	@And("^Clicking favorite icon of related insight$")
	public void clicking_favorite_icon_of_related_insight() throws Throwable {
		String value = CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[contains(text(),'" + insight_text + "')]/preceding::*[contains(@title,'favorite')]", 4)
				.getAttribute("title");
		if (value.equalsIgnoreCase("Remove from favorite")) {
			CommonFunctionality.wait(2000);
			CommonFunctionality.getElementBycssSelector(login.driver, "div[title='" + value + "']", 12).click();
			CommonFunctionality.wait(7000);
			CommonFunctionality.getElementBycssSelector(login.driver, "div[title='Add to favorite']", 12).click();
		}
		if (value.equalsIgnoreCase("Add to favorite")) {
			CommonFunctionality.wait(2000);
			CommonFunctionality.getElementBycssSelector(login.driver, "div[title='" + value + "']", 12).click();
		}
	}

	@And("^Click on \"([^\"]*)\" option in insights page$")
	public void click_on_option_in_insights_page(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']", 4).click();
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[text()='Favorite']", 4).click();
		CommonFunctionality.wait(2000);
	}

	@SuppressWarnings("deprecation")
	@And("^Hovor on to i icon$")
	public void hovor_on_to_i_icon() throws Throwable {
		WebElement first_series = login.driver
				.findElement(By.xpath("//*[contains(@class,'series-list-item--info-icon')]"));
		new Actions(login.driver).moveToElement(first_series).pause(2000)
				.click(login.driver.findElement(By.xpath("//div[@title='Show Series Info']"))).build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Hovor on to i icon without click$")
	public void hovor_on_to_i_icon_without_click() throws Throwable {
		WebElement first_series = login.driver.findElement(By.xpath(" //*[contains(@class,'country-information')]"));
		new Actions(login.driver).moveToElement(first_series).pause(2000).build().perform();
		hovered_series_name = CommonFunctionality.getElementByClassName(login.driver, "series-item--name", 4).getText();
	}

	@SuppressWarnings("deprecation")
	@And("^Hovor on to series name without click$")
	public void hovor_on_to_series_name_without_click() throws Throwable {
		WebElement series = login.driver.findElement(By.xpath("//*[@class='series-item--name']"));
		new Actions(login.driver).moveToElement(series).pause(2000).build().perform();
		String text = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'Series id:')]/following-sibling::*", 4)
				.getText();
		if (text.contains("(")) {
			String split[] = text.split("\\(");
			Series_item_id_without_click = split[0];
		} else {
			Series_item_id_without_click = text;
		}
		hovor_on_to_i_icon_without_click();
	}

	@SuppressWarnings("deprecation")
	@And("^Hovor only series name$")
	public void hovor_only_series_name() throws Throwable {
		WebElement series = login.driver.findElement(By.xpath("//*[@class='series-item--name']"));
		new Actions(login.driver).moveToElement(series).pause(2000).build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Hovor on to series name$")
	public void hovor_on_to_series_name() throws Throwable {
		WebElement series = login.driver.findElement(By.xpath("//*[@class='series-item--name']"));
		new Actions(login.driver).moveToElement(series).pause(2000).build().perform();
		String text = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'Series id:')]/following-sibling::*", 4)
				.getText();
		series.click();
		if (text.contains("(")) {
			String split[] = text.split("\\(");
			Series_item_id = split[0];
		} else {
			Series_item_id = text;
		}
	}

	@And("^Get the name of series$")
	public void get_the_name_of_series() throws Throwable {
		for (int i = 1; i <= series_count_inside_table; i++) {
			String series_name_inside_table = login.driver
					.findElement(By.xpath("(//*[@class='series-item--name'])[" + i + "]")).getText();
			series_values.add(series_name_inside_table);
		}
	}

	@And("^Get the name of series inside table$")
	public void get_the_name_of_series_inside_table() throws Throwable {
		for (int i = 1; i <= series_count_inside_first_table; i++) {
			String series_name_inside_table = login.driver
					.findElement(By.xpath("(//*[@class='series-item--name'])[" + i + "]")).getText();
			series_values_in_table.add(series_name_inside_table);
		}
	}

	@And("^Clicking \"([^\"]*)\" button from Header portion$")
	public void clicking_button_from_Header_portion(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='page-main-header--buttons']//following::*[contains(@class,'button__download-btn')]", 4)
				.click();
		CommonFunctionality.wait(2000);
		if (login.driver
				.findElements(By.xpath(
						"//*[contains(@class,'sphere-modal-controls--right')]//*[contains(text(),'" + arg1 + "')]"))
				.size() > 0) {
			WebElement ele = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'sphere-modal-controls--right')]//*[contains(text(),'" + arg1 + "')]", 4);
			new Actions(login.driver).moveToElement(ele).click().build().perform();
		}
		CommonFunctionality.wait(2000);
	}

	@And("^Click \"([^\"]*)\" option in series$")
	public void click_option_in_series(String arg1) throws Throwable {
		WebElement icon = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='series-item--status-icons']/following-sibling::*[contains(@title,'" + arg1 + "')]", 4);
		// js.executeScript("arguments[0].scrollIntoView(true);",icon);
		new Actions(login.driver).moveToElement(icon).click().build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Perform Drag and Drop operation$")
	public void perform_Drag_and_Drop_operation() throws Throwable {
		WebElement source = CommonFunctionality.getElementByClassName(login.driver, "series-item--name", 4);
		WebElement target = CommonFunctionality.getElementByClassName(login.driver,
				"data-selection-series-overlay--content", 4);
		new Actions(login.driver).moveToElement(source).pause(500).clickAndHold(source).pause(1000)
				.dragAndDrop(source, target).pause(500).build().perform();
	}

	@And("^Check the checkbox \"([^\"]*)\"$")
	public void check_the_checkbox(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Table: Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia")) {
			new Actions(login.driver).moveToElement(login.driver.findElement(By.xpath(
					"//*[contains(text(),'Global Economic Monitor')]/following::span[@class='svg-checkbox'][1]")))
					.click().build().perform();
		} else {
			new Actions(login.driver)
					.moveToElement(login.driver
							.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]/preceding::span[1]")))
					.click().build().perform();
		}
	}

	@And("^Uncheck the checkbox \"([^\"]*)\"$")
	public void uncheck_the_checkbox(String arg1) throws Throwable {
		new Actions(login.driver)
				.moveToElement(
						login.driver.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]/preceding::span[1]")))
				.doubleClick().build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Expand the tree for key icons$")
	public void expand_the_tree_for_key_icons() throws Throwable {
		// CommonFunctionality.getElementByXpath(login.driver,
		// "//*[contains(text(),'Search without any filters')]", 4).click();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//div[@class='toggle']", 4))
				.pause(1000).click().build().perform();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='toggle'])[2]", 4))
				.pause(1000).click().build().perform();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='toggle'])[3]", 4))
				.pause(1000).click().build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Hovor on the series from table$")
	public void hovor_on_the_series_from_table() throws Throwable {
		WebElement hovor = CommonFunctionality.getElementBycssSelector(login.driver, ".series-item--name", 4);
		new Actions(login.driver).moveToElement(hovor).pause(1000).build().perform();
	}

	@And("^Select \"([^\"]*)\" checkbox from more section$")
	public void select_checkbox_from_more_section(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("new")) {
			filter_text = arg1;
			WebElement ele = login.driver.findElement(By.xpath(
					"//*[@class='more-filter-content--left']//*[contains(@class,'more-filter-content--section__other')]//*[contains(text(),'n') and @class='status-icon--sign']"));
			js.executeScript("arguments[0].scrollIntoView(true);", ele);
			boolean checked = login.driver.findElement(By.xpath(
					"//*[@class='more-filter-content--left']//*[contains(@class,'more-filter-content--section__other')]//*[contains(text(),'n') and @class='status-icon--sign']/preceding::input[1]"))
					.isSelected();
			if (checked == false) {
				new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='more-filter-content--left']//*[contains(@class,'more-filter-content--section__other')]//*[contains(text(),'n') and @class='status-icon--sign']/preceding::span[1]",
						4)).click().build().perform();
			}
		}
		if (arg1.equalsIgnoreCase("Key")) {
			filter_text1 = arg1;
			WebElement ele = login.driver.findElement(By.xpath(
					"//*[@class='more-filter-content--left']//*[contains(@class,'more-filter-content--section__other')]//*[contains(text(),'k') and @class='status-icon--sign']"));
			js.executeScript("arguments[0].scrollIntoView(true);", ele);
			boolean checked = login.driver.findElement(By.xpath(
					"//*[@class='more-filter-content--left']//*[contains(@class,'more-filter-content--section__other')]//*[contains(text(),'k') and @class='status-icon--sign']/preceding::input[1]"))
					.isSelected();
			if (checked == false) {
				new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='more-filter-content--left']//*[contains(@class,'more-filter-content--section__other')]//*[contains(text(),'k') and @class='status-icon--sign']/preceding::span[1]",
						4)).click().build().perform();
			}
		}
		if (arg1.equalsIgnoreCase("units")) {
			WebElement ele = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'" + arg1 + "-filter-container')]", 4);
			if (ele.isDisplayed()) {
				boolean checked = login.driver.findElement(By.xpath("//*[contains(@class,'" + arg1
						+ "-filter-container')]//*[contains(text(),'USD')]/preceding::input[1]")).isSelected();
				if (checked == false) {
					new Actions(login.driver)
							.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
									"//*[contains(@class,'" + arg1
											+ "-filter-container')]//*[contains(text(),'USD')]/preceding::span[1]",
									4))
							.click().build().perform();
				}
			} else {
				fail("Dropdwn not opened");
			}
		}
	}

	@And("^Get href of \"([^\"]*)\" section from Comparables tab$")
	public void get_href_of_section_from_Comparables_tab(String arg1) throws Throwable {
		String link = null;
		if (arg1.equalsIgnoreCase("First Dataset")) {
			link = CommonFunctionality
					.getElementByXpath(login.driver,
							"//div[@title='" + section_name + "']//ancestor::div[@class='data-set-node--body']", 4)
					.getAttribute("href");
		} else {
			link = CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]/ancestor::*[2]", 4)
					.getAttribute("href");
		}
		section_link = link.replaceAll("%7C", "|");
	}

	@And("^Search for \"([^\"]*)\"$")
	public void search_for(String arg1) throws Throwable {
		selected_series_id = arg1;
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).clear();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(selected_series_id);
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		CommonFunctionality.wait(500);
	}

	@And("^Count the series in selected Filter$")
	public void count_the_series_in_selected_Filter() throws Throwable {
		String filter_count = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='search-filter-container']//*[contains(text(),'" + Filters.var
						+ "')]//following::div[2])[2] | //div[@class='search-filter-container']//*[contains(text(),'"
						+ Filters.var + "')]//following::div[2]",
				4).getText();
		String filter = filter_count.substring(1, filter_count.length() - 1);
		String fcount = filter.replaceAll(",", "");
		filterCount = Integer.parseInt(fcount);
	}

	@And("^Count the series in multiple selected Filter$")
	public void count_the_series_in_multiple_selected_Filter() throws Throwable {
		String filters[] = Filters.var.split(";");
		int var_count = filters.length;
		for (int i = 0; i <= var_count - 1; i++) {
			String filter_count = CommonFunctionality.getElementByXpath(login.driver,
					"//div[@class='search-filter-container']//*[contains(text(),'" + filters[i]
							+ "')]//following::div[2] | (//div[@class='search-filter-container']//*[contains(text(),'"
							+ filters[i] + "')]//following::div[2])[2]",
					4).getText();
			String filter = filter_count.substring(1, filter_count.length() - 1);
			String fcount = filter.replaceAll(",", "");
			filterCount1 = Integer.parseInt(fcount);
			fil_count.add(filterCount1);
		}
	}

	@And("^Count the series in selected Filter1$")
	public void count_the_series_in_selected_Filter1() throws Throwable {
		String filter_count = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='search-filter-container']//*[contains(text(),'" + Filters.var
						+ "')]//following::div[2])[2] | //div[@class='search-filter-container']//*[contains(text(),'"
						+ Filters.var + "')]//following::div[2]",
				4).getText();
		String filter = filter_count.substring(1, filter_count.length() - 1);
		String fcount = filter.replaceAll(",", "");
		filterCount1 = Integer.parseInt(fcount);
	}

	@And("^Click on \"([^\"]*)\" for related series$")
	public void click_on_for_related_series(String arg1) throws Throwable {
		CommonFunctionality.wait(6000);
		WebElement database = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='related-series-information-portlet--container']//*[@class='series-data-set--node-link' and @js-open-"
						+ arg1 + "]",
				4);
		related_dataset_text = database.getText();
		database.click();
	}

	@And("^Click \"([^\"]*)\" to collapse$")
	public void click_to_collapse(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Table: Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia")) {
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(text(),'Global Economic Monitor')]/following::div[@class='toggle'][1]", 4)
					.click();
		} else {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(text(),'" + arg1 + "')]/preceding::div[@class='toggle'][1]", 4).click();
		}
	}

	@And("^Count the series inside \"([^\"]*)\"$")
	public void count_the_series_inside(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		List<WebElement> series_inside_table;
		if (arg1.equalsIgnoreCase("First Dataset")) {
			series_inside_table = login.driver.findElements(
					By.xpath("(//*[@class='release-scheduler-tree-node--title'])[1]/following::ul[1]/li"));
		} else if (arg1.equalsIgnoreCase("Selected Dataset")) {
			series_inside_table = login.driver.findElements(
					By.xpath("(//*[contains(@class,'tree-series-list list-view-component')])[1]//ul[1]/li"));
		} else {
			if (arg1.equalsIgnoreCase("Table: Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia")) {
				String series_count = CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(text(),'Global Economic Monitor')]/following::span[@class='name-text'][1]", 4)
						.getText();
				series_inside_table = login.driver
						.findElements(By.xpath("//*[contains(text(),'" + series_count + "')]//following::ul[1]/li"));
			} else {
				series_inside_table = login.driver
						.findElements(By.xpath("//*[contains(text(),'" + arg1 + "')]//following::ul[1]/li"));
			}
		}
		series_count_inside_first_table = series_inside_table.size();
	}

	@SuppressWarnings("deprecation")
	@And("^Right Click \"([^\"]*)\" section from Comparables tab$")
	public void right_click_section_from_Comparables_tab(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		if (arg1.equalsIgnoreCase("Table: Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia")) {
			section_name = CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(text(),'Global Economic Monitor')]/following::span[@class='name-text'][1]", 4)
					.getText();
			WebElement ele = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(text(),'" + section_name + "')]", 4);
			new Actions(login.driver).moveToElement(ele).pause(4000).contextClick().build().perform();
		} else if (arg1.equalsIgnoreCase("Real GDP: YoY: Quarterly: sa: Australia")) {
			section_name = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(text(),'Global Economic Monitor')]/following::div[@class='series-item--name'][1]", 4)
					.getText();
			WebElement ele = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(text(),'" + section_name + "')]", 4);
			new Actions(login.driver).moveToElement(ele).pause(4000).contextClick().build().perform();
		} else if (arg1.equalsIgnoreCase("Dataset")) {
			dt.search_for_the_with_ID("Datasets", "TB3840");
			section_name = CommonFunctionality
					.getElementByXpath(login.driver,
							"(//*[@class='nodes-list--tree-wrapper']//*[@class='series-data-set--table-name'])[1]", 4)
					.getText();
		} else if (arg1.equalsIgnoreCase("Top button")) {
			dt.search_for_the_with_ID("Datasets", "TB65349");
		} else {
			section_name = arg1;
			WebElement ele = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]",
					4);
			new Actions(login.driver).moveToElement(ele).pause(4000).contextClick().build().perform();
		}
		CommonFunctionality.wait(2000);
	}

	@SuppressWarnings("deprecation")
	@And("^Using keyboard shortcuts for \"([^\"]*)\" the section$")
	public void using_keyboard_shortcuts_for_the_section(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("expanding")) {
			WebElement ele = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(text(),'National Accounts')]", 4);
			new Actions(login.driver).moveToElement(ele).pause(1000).sendKeys(Keys.chord(Keys.ARROW_RIGHT)).build()
					.perform();
			CommonFunctionality.wait(2000);
			new Actions(login.driver).moveToElement(ele).pause(1000).sendKeys(Keys.chord(Keys.ARROW_RIGHT)).build()
					.perform();
			CommonFunctionality.wait(2000);
			new Actions(login.driver).moveToElement(ele).pause(1000).sendKeys(Keys.chord(Keys.ARROW_RIGHT)).build()
					.perform();
		}
		if (arg1.equalsIgnoreCase("collapsing")) {
			WebElement ele = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-node-model-id='TB2992367']",
					8);
			new Actions(login.driver).moveToElement(ele).pause(1000).sendKeys(Keys.chord(Keys.ARROW_LEFT)).build()
					.perform();
			CommonFunctionality.wait(2000);
			new Actions(login.driver).moveToElement(ele).pause(1000).sendKeys(Keys.chord(Keys.ARROW_LEFT)).build()
					.perform();
			CommonFunctionality.wait(2000);
			WebElement ele1 = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(text(),'Global Economic Monitor')]", 4);
			new Actions(login.driver).moveToElement(ele1).pause(1000).sendKeys(Keys.chord(Keys.ARROW_LEFT)).build()
					.perform();
		}
		if (arg1.equalsIgnoreCase("moving down")) {
			WebElement ele = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(text(),'National Accounts')]", 4);
			new Actions(login.driver).moveToElement(ele).pause(1000).sendKeys(Keys.chord(Keys.ARROW_DOWN)).build()
					.perform();
			CommonFunctionality.wait(2000);
			new Actions(login.driver).moveToElement(ele).pause(1000).sendKeys(Keys.chord(Keys.ARROW_DOWN)).build()
					.perform();
			CommonFunctionality.wait(2000);
			new Actions(login.driver).moveToElement(ele).pause(1000).sendKeys(Keys.chord(Keys.ARROW_DOWN)).build()
					.perform();
			CommonFunctionality.wait(2000);
			new Actions(login.driver).moveToElement(ele).pause(1000).sendKeys(Keys.chord(Keys.ARROW_DOWN)).build()
					.perform();
			CommonFunctionality.wait(2000);
			new Actions(login.driver).moveToElement(ele).pause(1000).sendKeys(Keys.chord(Keys.ARROW_DOWN)).build()
					.perform();
		}
		if (arg1.equalsIgnoreCase("moving up")) {
			WebElement ele = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(text(),'Government and Public Finance')]", 4);
			new Actions(login.driver).moveToElement(ele).pause(1000).sendKeys(Keys.chord(Keys.ARROW_UP)).build()
					.perform();
			CommonFunctionality.wait(2000);
			new Actions(login.driver).moveToElement(ele).pause(1000).sendKeys(Keys.chord(Keys.ARROW_UP)).build()
					.perform();
			CommonFunctionality.wait(2000);
			new Actions(login.driver).moveToElement(ele).pause(1000).sendKeys(Keys.chord(Keys.ARROW_UP)).build()
					.perform();
			CommonFunctionality.wait(2000);
			new Actions(login.driver).moveToElement(ele).pause(1000).sendKeys(Keys.chord(Keys.ARROW_UP)).build()
					.perform();
			CommonFunctionality.wait(2000);
			new Actions(login.driver).moveToElement(ele).pause(1000).sendKeys(Keys.chord(Keys.ARROW_UP)).build()
					.perform();
		}
	}

	@And("^\"([^\"]*)\"  \"([^\"]*)\" checkbox$")
	public void checkbox(String arg1, String arg2) throws Throwable {
		if (login.driver.findElements(By.cssSelector(".modal-content.sphere-modal__content")).size() == 1) {
			if (arg1.equalsIgnoreCase("Uncheck")) {
				boolean checkbox = login.driver
						.findElement(By.xpath("//*[contains(text(),'" + arg2 + "')]/preceding-sibling::input"))
						.isSelected();
				if (checkbox == true) {
					new Actions(login.driver)
							.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
									"//*[contains(text(),'" + arg2 + "')]/preceding-sibling::span", 4))
							.click().build().perform();
				}
			}
			if (arg1.equalsIgnoreCase("Check")) {
				boolean checkbox = login.driver
						.findElement(By.xpath("//*[contains(text(),'" + arg2 + "')]/preceding-sibling::input"))
						.isSelected();
				if (checkbox == false) {
					new Actions(login.driver)
							.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
									"//*[contains(text(),'" + arg2 + "')]/preceding-sibling::span", 4))
							.click().build().perform();
				}
			}
		} else {
			fail("Popup is not opened");
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Click on \"([^\"]*)\" option in series level$")
	public void click_on_option_in_series_level(String arg1) throws Throwable {
		WebElement country = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'country-information')]", 4);
		new Actions(login.driver).moveToElement(country).pause(1000).build().perform();
		series_name = login.driver.findElement(By.xpath("//li[1]//div[@class='series-item--name']")).getText();
		if (arg1.equals("Add to Watchlist")) {
			CommonFunctionality.wait(2000);
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//div[@class='items-wrapper']//span[@title='" + arg1 + "']", 4))
					.pause(3000).click().build().perform();
		} else {
			new Actions(login.driver)
					.moveToElement(
							CommonFunctionality.getElementByXpath(login.driver, "//li[1]//*[@title='" + arg1 + "']", 4))
					.pause(2000).click().build().perform();
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Click on \"([^\"]*)\" option in series level of Dataset$")
	public void click_on_option_in_series_level_of_Dataset(String arg1) throws Throwable {
		dt.hovor_on_icon();
		series_name = login.driver.findElement(By.xpath("//li[1]//div[@class='series-item--name']")).getText();
		if (arg1.equals("Add to Watchlist")) {
			CommonFunctionality.wait(2000);
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//div[@class='items-wrapper']//span[@title='" + arg1 + "']", 4))
					.pause(3000).click().build().perform();
		} else {
			new Actions(login.driver)
					.moveToElement(
							CommonFunctionality.getElementByXpath(login.driver, "//li[1]//*[@title='" + arg1 + "']", 4))
					.pause(2000).click().build().perform();
		}
	}

	@And("^Also Expand the \"([^\"]*)\"$")
	public void also_Expand_the(String arg1) throws Throwable {
		WebElement table = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'" + arg1 + "')]/preceding::*[@class='toggle'][1]", 4);
		js.executeScript("arguments[0].scrollIntoView(true);", table);
		js.executeScript("arguments[0].click();", table);
	}

	@And("^Select the \"([^\"]*)\" option$")
	public void select_the_option(String arg1) throws Throwable {
		login.driver.findElement(By.xpath("//div[@class='items-wrapper']//span[@title='" + arg1 + "']")).click();
		if (arg1.equalsIgnoreCase("Copy link(s)") || arg1.equalsIgnoreCase("Copy selected links")) {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Clipboard clipboard = toolkit.getSystemClipboard();
			copied_link = (String) clipboard.getData(DataFlavor.stringFlavor);
		}
	}

	@And("^Message should display$")
	public void message_should_display() throws Throwable {
		if (login.driver.findElements(By.xpath("//*[contains(@class,'growl-success')]")).size() == 1) {
			login.Log4j.info("Growl popup is displayed");
		} else {
			fail("Growl message is not displayed");
		}
	}

	@And("^Clicking \"([^\"]*)\" button in search popup$")
	public void clicking_button_in_search_popup(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		WebElement save = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='search-tabs-manager--footer']//*[contains(text(),'" + arg1 + "')]", 4);
		js.executeScript("arguments[0].click();", save);
	}

	@And("^Clicking \"([^\"]*)\" link$")
	public void clicking_link(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']", 4).click();
		CommonFunctionality.wait(2000);
	}

	@SuppressWarnings("deprecation")
	@And("^Click on \"([^\"]*)\" button in Comparables$")
	public void click_on_button_in_Comparables(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("More actions")) {
			new Actions(login.driver)
					.moveToElement(
							CommonFunctionality.getElementBycssSelector(login.driver, "*[title='" + arg1 + "']", 4))
					.pause(500).click().build().perform();
		} else if (arg1.equalsIgnoreCase("View as Map")) {
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
							".dropdown-menu.context-menu span[title='" + arg1 + "']", 4))
					.pause(2000).click().build().perform();
			CommonFunctionality.getElementBycssSelector(login.driver, ".dropdown-menu span[title='World']", 4).click();
		} else {
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
							".dropdown-menu.context-menu span[title='" + arg1 + "']", 4))
					.pause(2000).click().build().perform();
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Drag and Drop the Comparables text$")
	public void drag_and_Drop_the_Comparables_text() throws Throwable {
		WebElement source = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='search-presentation-tabs--visible']/span[3]", 4);
		WebElement target = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='search-presentation-tabs--visible']/span[2]", 4);
		new Actions(login.driver).moveToElement(source).pause(2000).clickAndHold(source).pause(4000)
				.dragAndDrop(source, target).pause(4000).release(target).build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Clicking \"([^\"]*)\" from dropdown list$")
	public void clicking_from_dropdown_list(String arg1) throws Throwable {
		WebElement dropdown = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'dropdown-menu')]//*[contains(@title,'" + arg1 + "')]", 4);
		new Actions(login.driver).moveToElement(dropdown).pause(2000).click().build().perform();
	}

	@And("^Get Text of Table$")
	public void get_Text_of_Table() throws Throwable {
		table_text = CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[contains(text(),'Global Economic Monitor')]/following::span[@class='name-text'][1]", 4)
				.getText();
	}

	@And("^Get the count of series inside table$")
	public void get_the_count_of_series_inside_table() throws Throwable {
		List<WebElement> series = login.driver.findElements(By.xpath(
				"(//*[contains(@class,'tree-series-list list-view-component series-table-list__all-shown')])[1]//li"));
		series_count = series.size();
	}

	@And("^Get the count of series inside first table$")
	public void get_the_count_of_series_inside_first_table() throws Throwable {
		List<WebElement> series = login.driver
				.findElements(By.xpath("//ul[@class='search-series-list scrollable'][1]/li"));
		series_count_in_first_table = series.size();
	}

	@Then("^\"([^\"]*)\" should not be displayed for flex users$")
	public void should_not_be_displayed_for_flex_users(String arg1) throws Throwable {
		if (dropdown_open.isDisplayed()) {
			if (CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='more-filter-content--left']//*[contains(@class,'more-filter-content--section__other')]",
					4).isDisplayed()) {
				List<WebElement> items = login.driver.findElements(By.xpath(
						"//*[contains(@class,'more-filter-content--section__other')]//*[@class='filter-list']//*[@class='filter-item--title']//following-sibling::*[@class='filter-item--label']"));
				for (WebElement item : items) {
					js.executeScript("arguments[0].scrollIntoView(true);", item);
					String flextext = item.getText();
					if (flextext.equalsIgnoreCase(arg1)) {
						fail(arg1 + " filter is displayed. Hence verification failed");
					}
				}
				login.Log4j
						.info("The " + arg1 + " is not displayed for flex user and it has been verified successfully");
			} else {
				fail("The Others block in More items field is not displaying");
			}
		} else {
			fail("The dialog/Modal box is not opened");
		}
	}

	@Then("^Clicking on the insight name should open the new insight$")
	public void clicking_on_the_insight_name_should_open_the_new_insight() throws Throwable {
		login.driver.findElement(By.xpath(
				"//*[@class='growl-message growl-success']//*[@class='button button__sm button__primary'] | //*[@class='growl-message growl-success']//*[@class='button growl-message-content--btns__fill']"))
				.click();
		ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(newTab.get(1));
		String expected = CommonFunctionality.getElementByClassName(login.driver, "group-name", 4).getText();
		CommonFunctionality.DeleteSeries();
		login.driver.switchTo().window(newTab.get(1)).close();
		Thread.sleep(1000);
		login.driver.switchTo().window(newTab.get(0));
		Thread.sleep(1000);
		System.out.println("New insight with the added series is opened and has been verified successfully");
		CommonFunctionality.DeleteSeries();
		assertEquals(table_text, expected);
	}

	@SuppressWarnings("deprecation")
	@Then("^Any insight could be selected for the table to add$")
	public void any_insight_could_be_selected_for_the_series_to_add() throws Throwable {
		List<WebElement> insights_all = login.driver.findElements(By.className("input-control--description"));
		String first_insight = null;
		for (WebElement insight : insights_all) {
			first_insight = insight.getText();
			new Actions(login.driver).moveToElement(insight).click().build().perform();
			break;
		}
		WebElement apply = CommonFunctionality.getElementByXpath(login.driver, "//*[text()='Apply']", 4);
		js.executeScript("arguments[0].scrollIntoView(true);", apply);
		new Actions(login.driver).moveToElement(apply).pause(500).click().build().perform();
		String expected = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(@class,'growl-message--link__highlighted')]", 4)
				.getText();
		login.Log4j.info("Add to existing insight has been verified");
		CommonFunctionality.DeleteSeries();
		assertEquals(first_insight, expected);
	}

	@Then("^The Section level results for series should be present$")
	public void the_Section_level_results_for_series_should_be_present() throws Throwable {
		if (CommonFunctionality.getElementBycssSelector(login.driver, ".search-input--series-indicators", 4)
				.isDisplayed()) {
			String series_count = CommonFunctionality
					.getElementByClassName(login.driver, "series-series-count--number", 4).getText();
			String seriescount = series_count.replaceAll(",", "");
			comparables_count = Integer.parseInt(seriescount);
			login.Log4j.info(
					"The Section level results for series is present and it has been verified and the total count is "
							+ comparables_count);
		} else {
			fail("Verification Failed");
		}
	}

	@Then("^Should open Insight Explorer window in same tab$")
	public void should_open_Insight_Explorer_window_in_same_tab() throws Throwable {
		ArrayList<String> tabs = new ArrayList<String>(login.driver.getWindowHandles());
		CommonFunctionality.wait(2000);
		if (tabs.size() == 1) {
			login.Log4j.info("Insight explorer window is opened in same tab and has been verified");
		} else {
			sa.fail("Verification Failed");
		}
		CollabarationSharing share = new CollabarationSharing();
		share.navigate_insights();
	}

	@Then("^Comparables tab \"([^\"]*)\" be visible in search pane$")
	public void comparables_tab_be_visible_in_search_pane(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("should not")) {
			if (login.driver
					.findElements(By.xpath(
							"//*[@class='search-presentation-tabs--visible']//*[contains(text(),'Comparables')]"))
					.size() == 0) {
				login.Log4j.info("Comparables tab is hidden in search pane and it has been verified successfully");
			} else {
				fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("should")) {
			if (login.driver
					.findElements(By.xpath(
							"//*[@class='search-presentation-tabs--visible']//*[contains(text(),'Comparables')]"))
					.size() == 1) {
				login.Log4j.info("Comparables tab is not hidden in search pane and it has been verified successfully");
			} else {
				fail("Verification Failed");
			}
		}
	}

	@Then("^Should be able to expand section levels results upto table level$")
	public void should_be_able_to_expand_section_levels_results_upto_table_level() throws Throwable {
		if (login.driver
				.findElements(By.cssSelector(".tree-series-list.list-view-component.series-table-list__all-shown"))
				.size() == 1) {
			login.Log4j.info(
					"Expanded section level results upto table level without any errors and it has been verified successfully");
		} else {
			fail("Verification Failed");
		}
		// CommonFunctionality.CollapseTreeMethod();
	}

	@Then("^Should be able to collapse section levels results$")
	public void should_be_able_to_collapse_section_levels_results() throws Throwable {
		if (login.driver
				.findElements(By.cssSelector(".tree-series-list.list-view-component.series-table-list__all-shown"))
				.size() == 0) {
			login.Log4j.info(
					"Collapsed till section level results without any errors and it has been verified successfully");
		} else {
			fail("Verification Failed");
		}
	}

	@Then("^Should be able to move down the section levels results$")
	public void should_be_able_to_move_down_the_section_levels_results_upto_table_level() throws Throwable {
		WebElement section = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'Government and Public Finance')]/ancestor::div[2]", 4);
		// WebElement section = CommonFunctionality.getElementByXpath(login.driver,
		// "//*[contains(text(),'Demographic and Labour Market')]/ancestor::div[2]", 4);
		if (section.getAttribute("class").contains("active")) {
			login.Log4j.info(
					"It is possible to Move down the section level results with keyboard actions and it has been Verified Successfully");
		} else {
			fail("Verification Failed");
		}
	}

	@Then("^Should be able to move up the section levels results$")
	public void should_be_able_to_move_up_the_section_levels_results_upto_table_level() throws Throwable {
		WebElement section = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'National Accounts')]/ancestor::div[2]", 4);
		if (section.getAttribute("class").contains("active")) {
			login.Log4j.info(
					"It is possible to Move up the section level results with keyboard actions and it has been Verified Successfully");
		} else {
			fail("Verification Failed");
		}
	}

	@Then("^The Series information popup should be opened for selected series$")
	public void the_Series_information_popup_should_be_opened_in_for_selected_series() throws Throwable {
		// To open a new tab to establish second connection
		js.executeScript("window.open('" + copied_link + "')");
		ArrayList<String> tabs = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs.get(1));
		CommonFunctionality.wait(2000);
		String actual = login.driver.findElement(By.xpath("//*[@class='series-preview-modal-header--link']")).getText();
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		login.driver.switchTo().window(tabs.get(1)).close();
		login.Log4j.info("The copy link feature has been verified successfully");
		login.driver.switchTo().window(tabs.get(0));
		assertEquals(actual, series_name);
		// CommonFunctionality.CollapseTreeMethod();
	}

	@Then("^The Footnotes window tab should be opened$")
	public void the_Footnotes_window_tab_should_be_opened() throws Throwable {
		CommonFunctionality.wait(2000);
		String text = CommonFunctionality
				.getElementBycssSelector(login.driver, "span[class='footnotes-modal--name'] span", 4).getText();
		String actual = text.substring(1, text.length() - 1);
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		assertEquals(actual, series_name);
		login.Log4j.info("Footnotes window has been opened correctly and it has been verified successfully");
		// CommonFunctionality.CollapseTreeMethod();
	}

	@Then("^The \"([^\"]*)\" and \"([^\"]*)\" option should present$")
	public void the_and_option_should_present(String arg1, String arg2) throws Throwable {
		if (login.driver.findElements(By.xpath("//*[@class='name-li' and text()='" + arg1 + "']")).size() == 1
				&& login.driver.findElements(By.xpath("//*[@class='name-li' and text()='" + arg2 + "']")).size() == 1) {
			login.Log4j.info(
					arg1 + " and " + arg2 + " options are present in right click and has been verified successfully");
			// login.driver.navigate().refresh();
		} else {
			fail("Verification failed");
		}
	}

	@Then("^The \"([^\"]*)\" and \"([^\"]*)\" option for section should present$")
	public void the_and_option_for_section_should_present(String arg1, String arg2) throws Throwable {
		List<WebElement> section_items = login.driver.findElements(
				By.xpath("//*[contains(@class,'items-wrapper')]//*[contains(@class,'context-menu-item')]"));
		for (WebElement section : section_items) {
			String text = section.getAttribute("title");
			if (text.equals(arg1) || text.equals(arg2)) {
				System.out.println(text + " option is present and verified successfully");
			} else {
				fail("Verification Failed");
			}
		}
	}

	@Then("^The \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\" option for series should present$")
	public void the_and_option_for_series_should_present(String arg1, String arg2, String arg3, String arg4)
			throws Throwable {
		List<WebElement> series_items = login.driver
				.findElements(By.xpath("//ul//li[1]//*[contains(@class,'series-list-item--action-icons')]//span"));
		for (WebElement series : series_items) {
			String text = series.getAttribute("title");
			if (text.equalsIgnoreCase(arg1) || text.equalsIgnoreCase(arg2) || text.equalsIgnoreCase(arg3)
					|| text.equalsIgnoreCase(arg4)) {
				System.out.println(text + " option is present and verified successfully");
			} else {
				fail("Verification Failed");
			}
		}
	}

	@Then("^Copied URL should navigate to home page$")
	public void copied_URL_should_navigate_to_home_page() throws Throwable {
		String currentURL = login.driver.getCurrentUrl();
		js.executeScript("window.open('" + copied_link + "')");
		ArrayList<String> tabs = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs.get(1));
		CommonFunctionality.wait(6000);
		String newURL = login.driver.getCurrentUrl();
		login.driver.switchTo().window(tabs.get(1)).close();
		login.Log4j.info("The Copied URL is navigating to home page and it has been verified successfully");
		login.driver.switchTo().window(tabs.get(0));
		assertEquals(currentURL, newURL);
	}

	@Then("^The Footnotes window should be opened$")
	public void the_Footnotes_window_should_be_opened() throws Throwable {
		CommonFunctionality.wait(2000);
		String text = CommonFunctionality
				.getElementBycssSelector(login.driver, "span[class='footnotes-modal--name'] span", 4).getText();
		String actual = text.substring(1, text.length() - 1);
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		assertEquals(actual, section_name);
		login.Log4j.info("Footnotes window has been opened correctly and it has been verified successfully");
	}

	@Then("^The Footnotes window should be open$")
	public void the_Footnotes_window_should_be_open() throws Throwable {
		CommonFunctionality.wait(2000);
		String text = CommonFunctionality
				.getElementBycssSelector(login.driver, "span[class='footnotes-modal--name'] span", 4).getText();
		String actual = text.substring(1, text.length() - 1);
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		assertEquals(actual, hovered_series_name);
		login.Log4j.info("Footnotes window has been opened correctly and it has been verified successfully");
	}

	@Then("^The \"([^\"]*)\" message should be popped up$")
	public void the_message_should_be_popped_up(String arg1) throws Throwable {
		String actual = CommonFunctionality.getElementByClassName(login.driver, "growl-message-text", 4).getText();
		assertEquals(actual, arg1);
		login.Log4j.info("The " + arg1 + " Message has been popped out");
		// login.driver.navigate().refresh();
	}

	@Then("^Copied URL should paste in a new tab as respective section$")
	public void copied_URL_should_paste_in_a_new_tab_as_respective_section() throws Throwable {
		js.executeScript("window.open('" + copied_link + "')");
		ArrayList<String> tabs = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs.get(1));
		CommonFunctionality.wait(2000);
		login.Log4j.info("The Copied URL is navigating to respective section and it has been verified successfully");
		login.driver.switchTo().window(tabs.get(1)).close();
		login.driver.switchTo().window(tabs.get(0));
		assertEquals(copied_link, section_link);
		// login.driver.navigate().refresh();
	}

	@Then("^The comparables count should match to applied filter count$")
	public void the_comparables_count_should_match_to_applied_filter_count() throws Throwable {
		String compare_count = CommonFunctionality.getElementByClassName(login.driver, "series-series-count--number", 4)
				.getText();
		String count = compare_count.replaceAll(",", "");
		filter_actual_count = Integer.parseInt(count);
		assertEquals(filter_actual_count, filterCount);
		login.Log4j.info(
				"The comparables count is matching to applied filter count and it has been verified successfully");
	}

	@SuppressWarnings("deprecation")
	@Then("^Related results should be shown in comparables$")
	public void related_results_should_be_shown_in_comparables() throws Throwable {
		WebElement series = CommonFunctionality.getElementByProperty(login.driver, "Series_item_name", 4);
		new Actions(login.driver).moveToElement(series).pause(1000).build().perform();
		String id = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'Series id:')]/following-sibling::*", 4)
				.getText();
		String split[] = id.split("\\(");
		int series_id = Integer.parseInt(split[0]);
		int actual = Integer.parseInt(selected_series_id);
		assertEquals(actual, series_id);
		login.Log4j.info("The related results are shown in comparables tab and it has been verified successfully");
	}

	@Then("^The comparables count after reset should match to applied filter count$")
	public void the_comparables_count_after_reset_should_match_to_applied_filter_count() throws Throwable {
		String compare_count = CommonFunctionality.getElementByClassName(login.driver, "series-series-count--number", 4)
				.getText();
		String count = compare_count.replaceAll(",", "");
		int all_count = Integer.parseInt(count);
		assertNotEquals(all_count, sum);
		assertEquals(all_count, comparables_count);
		login.Log4j.info(
				"The comparables count is matching to actual comparables count and it has been verified successfully");
	}

	@Then("^The comparables count should match to applied filters count$")
	public void the_comparables_count_should_match_to_applied_filters_count() throws Throwable {
		String compare_count = CommonFunctionality.getElementByClassName(login.driver, "series-series-count--number", 4)
				.getText();
		String count = compare_count.replaceAll(",", "");
		filter_actual_count = Integer.parseInt(count);
		sum = 0;
		for (int num : fil_count) {
			sum = sum + num;
		}
		assertEquals(filter_actual_count, sum);
		login.Log4j.info(
				"The comparables count is matching to applied filters count and it has been verified successfully");
	}

	@Then("^The comparables count should match to actual count$")
	public void the_comparables_count_should_match_to_actual_count() throws Throwable {
		String compare_count = CommonFunctionality.getElementByClassName(login.driver, "series-series-count--number", 4)
				.getText();
		String count = compare_count.replaceAll(",", "");
		int filter_all_count = Integer.parseInt(count);
		assertNotEquals(filter_all_count, filterCount);
		assertEquals(filter_all_count, comparables_count);
		login.Log4j.info("The comparables count is matching to all filter count and it has been verified successfully");
	}

	@Then("^\"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" Options should present$")
	public void options_should_present(String arg1, String arg2, String arg3, String arg4, String arg5)
			throws Throwable {
		if (CommonFunctionality.getElementBycssSelector(login.driver, ".dropdown-menu.context-menu", 4).isDisplayed()) {
			List<WebElement> options = login.driver
					.findElements(By.xpath("//*[contains(@class,'dropdown-menu')]//*[@class='name-li']"));
			for (WebElement option : options) {
				String text = option.getText();
				if (text.equals(arg1) || text.equals(arg2) || text.equals(arg3) || text.equals(arg4)
						|| text.equals(arg5)) {
					login.Log4j.info(text + " is present");
				} else {
					sa.fail("Verification Failed");
				}
			}
		} else {
			sa.fail("Dropdown is not Opened");
		}
		login.Log4j.info("The " + arg1 + " , " + arg2 + " , " + arg3 + " , " + arg4 + " , " + arg5
				+ " Options are present and has been verified successfully");
	}

	@Then("^The Table level series are added into my series panel$")
	public void the_Table_level_series_are_added_into_my_series_panel() throws Throwable {
		CommonFunctionality.wait(3000);
		String expected = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='series-name-wrapper']//following-sibling::*[@class='group-name']", 4).getText();
		String count = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='series-panel--count']/span/span", 4).getText();
		int actual = Integer.parseInt(count);
		CommonFunctionality.DeleteSeries();
		assertEquals(actual, series_count_in_first_table);
		assertEquals(expected, table_text);
		login.Log4j.info("The Table level series are added into my series panel and it has been verified successfully");
	}

	@Then("^The Selected series should get added into right pane with \"([^\"]*)\"$")
	public void the_Selected_series_should_get_added_into_right_pane_with(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		String text = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='series-name-wrapper']//following-sibling::*[@class='group-name']", 4).getText();
		String expected[] = text.split("\\:");
		String count = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='series-panel--count']/span/span", 4).getText();
		int actual = Integer.parseInt(count);
		CommonFunctionality.DeleteSeries();
		assertEquals(actual, series_count_inside_table);
		assertEquals(expected[0], arg1);
		login.Log4j.info(
				"The Selected series is getting added into right pane with Grouping and it has been verified successfully");
	}

	@Then("^The Applied \"([^\"]*)\" filter is displaying under Comparables$")
	public void the_Applied_filter_is_displaying_under_Comparables(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		String actual = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'More:')]/following-sibling::*", 4).getText();
		if (arg1.equalsIgnoreCase("Single")) {
			if (actual.contains(filter_text)) {
				login.Log4j.info("The Applied " + arg1 + " filter is displaying under Comparables");
			} else {
				sa.fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("Multiple")) {
			if (actual.contains(filter_text) && actual.contains(filter_text1)) {
				login.Log4j.info("The Applied " + arg1 + " filter is displaying under Comparables");
			} else {
				sa.fail("Verification Failed");
			}
		}
	}

	@Then("^The series present inside the Table should gets selected$")
	public void the_series_present_inside_the_Table_should_gets_selected() throws Throwable {
		WebElement ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		List<WebElement> li_All = ul_element.findElements(By.xpath("//ul[contains(@class,'search-series-list')]/li"));
		for (WebElement li : li_All) {
			if (!(li.getAttribute("class").contains("series-list-item__selected"))) {
				sa.fail("Verification Failed");
			}
		}
		login.Log4j.info("The Series present inside the Table are selected and has been verified successfully");
	}

	@Then("^The series present inside the Table should gets deselected$")
	public void the_series_present_inside_the_Table_should_gets_deselected() throws Throwable {
		WebElement ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		List<WebElement> li_All = ul_element.findElements(By.xpath("//ul[contains(@class,'search-series-list')]/li"));
		for (WebElement li : li_All) {
			if (li.getAttribute("class").contains("series-list-item__selected")) {
				sa.fail("Verification Failed");
			}
		}
		login.Log4j.info("The Series present inside the Table are deselected and has been verified successfully");
	}

	@Then("^The series should gets selected$")
	public void the_series_should_gets_selected() throws Throwable {
		for (int i = 1; i <= series_count_inside_table; i++) {
			WebElement ele = CommonFunctionality.getElementByXpath(login.driver,
					"//ul[contains(@class,'search-series-list')]/li[" + i + "]", 4);
			if (!(ele.getAttribute("class").contains("series-list-item__selected"))) {
				sa.fail("Verification Failed");
			}
		}
		login.Log4j.info("The Series present are selected and has been verified successfully");
	}

	@Then("^The series should gets deselected$")
	public void the_series_should_gets_deselected() throws Throwable {
		for (int i = 1; i <= series_count_inside_table_deselect; i++) {
			WebElement ele = CommonFunctionality.getElementByXpath(login.driver,
					"//ul[contains(@class,'search-series-list')]/li[" + i + "]", 4);
			if (ele.getAttribute("class").contains("series-list-item__selected")) {
				sa.fail("Verification Failed");
			}
		}
		login.Log4j.info("The Series present are deselected and has been verified successfully");
		CommonFunctionality.DeleteSeries();
	}

	@SuppressWarnings("deprecation")
	@Then("^SSP window for specific series should be opened$")
	public void SSP_window_for_specific_series_should_be_opened() throws Throwable {
		CommonFunctionality.wait(3000);
		WebElement ssp_window = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Window")));
		if (ssp_window.isDisplayed()) {
			WebElement ele = CommonFunctionality.getElementByClassName(login.driver,
					"series-preview-modal-header--link", 4);
			new Actions(login.driver).moveToElement(ele).pause(3000).build().perform();
			String text = CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(text(),'Series id:')]/following-sibling::*", 4)
					.getText();
			String act = null;
			if (text.contains("(")) {
				String split[] = text.split("\\(");
				act = split[0];
			} else {
				act = text;
			}
			int actual = Integer.parseInt(act);
			int expected = Integer.parseInt(Series_item_id);
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			assertEquals(actual, expected);
			login.Log4j.info("The SSP window for specific series has been opened and has been verified successfully");
		} else {
			sa.fail("SSP Window not opened");
		}
	}

	@Then("^Series should get added into myseries pane$")
	public void series_should_get_added_into_myseries_pane() throws Throwable {
		List<WebElement> myseries = login.driver.findElements(By.className("series-name-field--series-name"));
		for (int i = 1; i <= myseries.size(); i++) {
			String myseries_text = CommonFunctionality
					.getElementByXpath(login.driver, "(//*[@class='series-name-field--series-name'])[" + i + "]", 4)
					.getText();
			myseries_values.add(myseries_text);
		}
		CommonFunctionality.DeleteSeries();
		boolean result = Arrays.equals(series_values.toArray(), myseries_values.toArray());
		login.Log4j.info("Comparision is: \n" + result);
		assertEquals(series_values.toArray(), myseries_values.toArray());
		login.Log4j.info("The Series is getting added into myseries pane and has been verified successfully");
	}

	@Then("^The Series selected should gets downloaded to excel$")
	public void the_series_should_get_download_to_excel() throws Throwable {
		CommonFunctionality.wait(1000);
		String path = System.getProperty("user.home") + "\\Downloads\\Name your insight.xlsx";
		File src = new File(path);
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		for (int i = 1; i <= series_count_inside_table; i++) {
			String data = sheet1.getRow(0).getCell(i).getStringCellValue();
			excel_values.add(data);
		}
		fis.close();
		Files.deleteIfExists(Paths.get(path));
		boolean result = Arrays.equals(series_values.toArray(), excel_values.toArray());
		login.Log4j.info("Comparision is: \n" + result);
		assertEquals(series_values.toArray(), excel_values.toArray());
		login.Log4j.info("The Series is getting downloaded to excel and has been verified successfully");
	}

	@Then("^The Series selected should gets copied to excel$")
	public void the_series_should_get_copied_to_excel() throws Throwable {
		String path = System.getProperty("user.dir") + "\\Excel_Files\\Name your insight.xlsx";
		File src = new File(path);
		if (!src.exists()) {
			src.createNewFile();
		}
		FileInputStream fis = new FileInputStream(src);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet1 = wb.createSheet();
		Row row = sheet1.createRow(0);
		Cell cell = null;
		for (int i = 0; i <= series_count_inside_table; i++) {
			cell = row.createCell(i);
		}
		CommonFunctionality.wait(2000);
		cell.setCellValue(ChartVisual.copied_text);
		CommonFunctionality.wait(4000);
		FileOutputStream fos = new FileOutputStream(src);
		wb.write(fos);
		String data1 = null;
		for (int i = 1; i <= series_count_inside_table; i++) {
			String data = sheet1.getRow(0).getCell(i).getStringCellValue();
			if (data.contains("\n")) {
				String text[] = data.split("\n");
				data1 = text[0];
			}
			if (data1.contains("\t")) {
				data1 = data1.replaceAll("\t", "");
			}
			excel_values.add(data1);
		}
		fos.close();
		fis.close();
		boolean result = Arrays.equals(series_values.toArray(), excel_values.toArray());
		login.Log4j.info("Comparision is: \n" + result);
		assertEquals(series_values.toArray(), excel_values.toArray());
		login.Log4j.info("The Series is getting copied to excel and has been verified successfully");
	}

	@Then("^The \"([^\"]*)\" Option for the series should present$")
	public void the_Option_for_the_series_should_present(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Show related data")) {
			if (!(login.driver.findElements(By.className("related-series-data--content")).size() == 1
					&& arg1.equals("Show related data"))) {
				sa.fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("Hide related data")) {
			if (!(login.driver.findElements(By.className("related-series-data--content")).size() == 0
					&& arg1.equals("Hide related data"))) {
				sa.fail("Verification Failed");
			}
		}
		login.Log4j.info("The " + arg1 + " option has been present and it has been verified successfully");
	}

	@Then("^The \"([^\"]*)\" should create for the series$")
	public void the_should_create_for_the_series(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Selected Series Chart")) {
			visualtitle.add(ChartVisual.visual_title);
			CommonFunctionality.Views_list();
			boolean result = Arrays.equals(series_values.toArray(), visualtitle.toArray());
			login.Log4j.info("Comparision is: \n" + result);
			assertEquals(series_values.toArray(), visualtitle.toArray());
		}
		if (arg1.equalsIgnoreCase("Unselected Series Chart")) {
			CommonFunctionality.Views_list();
			assertEquals(ChartVisual.visual_title, hovered_series_name);
		}
		if (arg1.equalsIgnoreCase("Multiple Series Chart")) {
			List<WebElement> chart_series = login.driver
					.findElements(By.cssSelector(".series-edit--title.series-edit--title__editable"));
			int actual = chart_series.size();
			assertEquals(actual, series_count_inside_table);
			CommonFunctionality.Views_list();
		}
		login.Log4j.info("The " + arg1 + " option has been present and it has been verified successfully");
	}

	@Then("^The \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" options should available$")
	public void the_options_should_available(String arg1, String arg2, String arg3, String arg4, String arg5,
			String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13)
			throws Throwable {
		List<WebElement> items = login.driver.findElements(By.xpath(
				"//*[@class='items-wrapper']/li/span[not(contains(@class,'dropdown-submenu-icon')) and not(contains(@title,'View on Administrative Map'))]"));
		for (WebElement item : items) {
			String value = item.getAttribute("title");
			if (value.equals(arg1) || value.equals(arg2) || value.equals(arg3) || value.equals(arg4)
					|| value.equals(arg5) || value.equals(arg6) || value.equals(arg7) || value.equals(arg8)
					|| value.equals(arg9) || value.equals(arg10) || value.equals(arg11) || value.equals(arg12)
					|| value.equals(arg13)) {
				login.Log4j.info(value + " option is present inside More actions");
			} else {
				fail(item + " not present");
			}
		}
	}

	@Then("^The \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" options should available in table$")
	public void the_options_should_available_in_table(String arg1, String arg2, String arg3, String arg4, String arg5,
			String arg6, String arg7, String arg8, String arg9, String arg10) throws Throwable {
		List<WebElement> items = login.driver.findElements(By.xpath(
				"//*[@class='items-wrapper']/li/span[not(contains(@class,'dropdown-submenu-icon')) and not(contains(@title,'View on Administrative Map'))]"));
		for (WebElement item : items) {
			String value = item.getAttribute("title");
			if (value.equals(arg1) || value.equals(arg2) || value.equals(arg3) || value.equals(arg4)
					|| value.equals(arg5) || value.equals(arg6) || value.equals(arg7) || value.equals(arg8)
					|| value.equals(arg9) || value.equals(arg10)) {
				login.Log4j.info(value + " option is present inside Table");
			} else {
				sa.fail(item + " not present");
			}
		}
	}

	@Then("^The series should get selected by default$")
	public void the_series_should_get_selected_by_default() throws Throwable {
		WebElement checkbox = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'" + hovered_series_name + "')]/ancestor::li", 4);
		if (checkbox.getAttribute("class").contains("series-list-item__selected")) {
			login.Log4j.info("The Series gets selected by default and has been verified successfully");
		} else {
			sa.fail("Verification Failed");
		}
	}

	@Then("^The \"([^\"]*)\" option is displayed$")
	public void the_option_is_displayed(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		String expected = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='visual-top-panel--left-controls']//*[contains(@class,'button__special')] | //*[@class='visual-top-panel--left-controls']//*[contains(@class,'button__primary')]",
				4).getText();
		CommonFunctionality.Views_list();
		assertEquals(arg1, expected);
		login.Log4j.info("The " + arg1 + " option is displayed and verified successfully");
	}

	@Then("^The \"([^\"]*)\" option should present$")
	public void the_option_should_present(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Show Dataset")) {
			List<WebElement> dataset_all = login.driver.findElements(By.className("series-item--name"));
			for (WebElement dataset : dataset_all) {
				String text = dataset.getText();
				series_values.add(text);
			}
			CommonFunctionality.getElementByClassName(login.driver, "insight-discovery--popup-back-button", 4).click();
			boolean result = Arrays.equals(series_values_in_table.toArray(), series_values.toArray());
			login.Log4j.info("Comparision is: \n" + result);
			assertEquals(series_values_in_table.toArray(), series_values.toArray());

		}
		if (arg1.equalsIgnoreCase("Selected series in Dataset")) {
			List<WebElement> series_all = login.driver
					.findElements(By.xpath("//ul[contains(@class,'search-series-list')]/li"));
			for (int i = 1; i <= series_all.size(); i++) {
				WebElement series = CommonFunctionality.getElementByXpath(login.driver,
						"//ul[contains(@class,'search-series-list')]/li[" + i + "]", 4);
				if (!(series.getAttribute("class").contains("series-list-item__selected"))) {
					fail("Series is not selected");
				}
			}
			WebElement back_button = CommonFunctionality.getElementByClassName(login.driver,
					"insight-discovery--popup-back-button", 4);
			if (back_button.isDisplayed()) {
				back_button.click();
			} else {
				sa.fail("Back button is not present");
			}
		}
		if (arg1.equalsIgnoreCase("Back button in Dataset")) {
			WebElement back_button = CommonFunctionality.getElementByClassName(login.driver,
					"insight-discovery--popup-back-button", 4);
			if (back_button.isDisplayed()) {
				back_button.click();
			} else {
				sa.fail("Back button is not present");
			}
			if (CommonFunctionality.getElementByClassName(login.driver, "search-presentation-tabs--visible", 4)
					.isDisplayed()) {
				System.out.println("Back button functionality is working fine");
			} else {
				sa.fail("Back button is not clicked");
			}
		}
		login.Log4j.info("The " + arg1 + " is displayed and has been verified successfully");
	}

	@Then("^Selected series should get deselected$")
	public void selected_series_should_get_deselected() throws Throwable {
		for (int i = 1; i <= series_count_inside_table; i++) {
			WebElement checkbox = CommonFunctionality.getElementByXpath(login.driver,
					"//ul[contains(@class,'search-series-list')]//li[" + i + "]", 4);
			CommonFunctionality.wait(2000);
			if (checkbox.getAttribute("class").contains("series-list-item__selected")) {
				sa.fail("Verification Failed");
			}
		}
		login.Log4j.info("The Series gets deselected by default and has been verified successfully");
	}

	@Then("^The Data tab is active by default$")
	public void the_Data_tab_is_active_by_default() throws Throwable {
		WebElement data = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='search-presentation-tabs--visible']//*[@data-id='DATA']", 4);
		if (data.getAttribute("class").contains("active")) {
			if (login.driver.findElements(By.className("database-representation--tree")).size() > 0) {
				login.Log4j.info("The Data tab is active and has been verified successfully");
			}
		} else {
			sa.fail("Data tab is not active");
		}
	}

	@Then("^The \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" options are present$")
	public void the_options_are_present(String arg1, String arg2, String arg3) throws Throwable {
		List<WebElement> sub_options = login.driver.findElements(By.xpath(
				"//span[text()='View as ...']//following::*[@class='dropdown-menu']//li//span[contains(@class,'context-menu-item')]"));
		for (WebElement option : sub_options) {
			String text = option.getAttribute("title");
			if (text.equals(arg1) || text.equals(arg2) || text.equals(arg3)) {
				login.Log4j.info(text + " option is present");
			} else {
				fail("Option is not present");
			}
		}
	}

	@SuppressWarnings("deprecation")
	@Then("^The \"([^\"]*)\" option is shown$")
	public void the_option_is_shown(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Download")) {
			cv.open_preference_dropdown();
			cv.clicking_on_option_under_user_preference_to_be("Ask me to confirm the download settings", "Check");
			cv.open_preference_dropdown();
			String text = CommonFunctionality
					.getElementBycssSelector(login.driver, ".sphere-modal__content .download-modal-title__title", 4)
					.getText();
			String actual = text.substring(0, text.length() - 1);
			CommonFunctionality.Hidden_Webelements_handling(login.driver, "className", "sphere-modal__close");
			CommonFunctionality.wait(2000);
			sa.assertEquals(actual, arg1);
		}
		if (arg1.equalsIgnoreCase("Copy")) {
			sa.assertEquals(hovered_series_name, ChartVisual.copied_text);
		}
		if (arg1.equalsIgnoreCase("Copy data")) {
			String text = CommonFunctionality
					.getElementBycssSelector(login.driver, ".sphere-modal__content .download-modal-title__title", 4)
					.getText();
			String actual = text.substring(0, text.length() - 1);
			CommonFunctionality.Hidden_Webelements_handling(login.driver, "className", "sphere-modal__close");
			String expected = arg1.substring(0, 4);
			sa.assertEquals(actual, expected);
		}
		if (arg1.equalsIgnoreCase("Copy selected links")) {
			js.executeScript("window.open('" + copied_link + "')");
			ArrayList<String> tabs = new ArrayList<String>(login.driver.getWindowHandles());
			login.driver.switchTo().window(tabs.get(1));
			CommonFunctionality.wait(3000);
			WebElement ele = CommonFunctionality.getElementByClassName(login.driver,
					"series-preview-modal-header--link", 4);
			new Actions(login.driver).moveToElement(ele).pause(1000).build().perform();
			String text = CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(text(),'Series id:')]/following-sibling::*", 4)
					.getText();
			String act = null;
			if (text.contains("(")) {
				String split[] = text.split("\\(");
				act = split[0];
			} else {
				act = text;
			}
			int actual = Integer.parseInt(act);
			int expected = Integer.parseInt(Series_item_id_without_click);
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			login.driver.switchTo().window(tabs.get(1)).close();
			login.driver.switchTo().window(tabs.get(0));
			sa.assertEquals(actual, expected);
		}
		if (arg1.equalsIgnoreCase("Series Info")) {
			CommonFunctionality.wait(2000);
			String actual = login.driver.findElement(By.xpath("//*[@class='series-preview-modal-header--link']"))
					.getText();
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			assertEquals(actual, hovered_series_name);
		}
		if (arg1.equalsIgnoreCase("Footnotes")) {
			String text = CommonFunctionality
					.getElementBycssSelector(login.driver, "span[class='footnotes-modal--name'] span", 4).getText();
			String actual = text.substring(1, text.length() - 1);
			if (login.driver.findElements(By.className("footnotes--unavailable-message")).size() == 1) {
				CommonFunctionality.wait(2000);
				String breadcrumb;
				breadcrumb = CommonFunctionality.getElementBycssSelector(login.driver,
						"div.footnotes--breadcrumbs > div > div:last-child >div", 4).getText();
				if (breadcrumb.contains(":")) {
					String actual1[] = breadcrumb.split("\\: ");
					breadcrumb = actual1[1];
				}
				login.driver.switchTo().frame(login.driver.findElement(By.className("footnotes--frame")));
				String iframe_text = login.driver.findElement(By.tagName("body")).getAttribute("innerHTML");
				login.driver.switchTo().defaultContent();
				CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
				if (iframe_text.contains(breadcrumb)) {
					System.out.println("Related footnotes are displaying");
				} else {
					sa.fail("Related Footnotes verification failed");
				}
			}
			sa.assertEquals(actual, hovered_series_name);
		}
		if (arg1.equalsIgnoreCase("Show Dataset")) {
			CommonFunctionality.wait(300);
			WebElement series = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[@class='series-item--name']/ancestor::li)[1]", 4);
			CommonFunctionality.wait(500);
			if (series.getAttribute("class").contains("series-list-item__selected")
					&& series.getAttribute("class").contains("series-list-item__highlighted")) {
				CommonFunctionality.getElementByClassName(login.driver, "insight-discovery--popup-back-button", 4)
						.click();
			} else {
				fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("Back Button")) {
			WebElement series = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[contains(text(),'" + hovered_series_name + "')]/ancestor::li)[1]", 4);
			if (series.getAttribute("class").contains("series-list-item__selected")
					&& series.getAttribute("class").contains("series-list-item__highlighted")) {
				CommonFunctionality.getElementByClassName(login.driver, "insight-discovery--popup-back-button", 4)
						.click();
				if (CommonFunctionality
						.getElementByXpath(login.driver, "//*[contains(text(),'Global Economic Monitor')]", 4)
						.isDisplayed()) {
					login.Log4j
							.info("The application has been returned back to series level and verified successfully");
				} else {
					sa.fail("Verification Failed");
				}
			} else {
				sa.fail("Verification Failed");
			}
			login.driver.navigate().refresh();
		}
		if (arg1.equalsIgnoreCase("Back Button in Dataset")) {
			CommonFunctionality.wait(500);
			WebElement series = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[contains(text(),'" + hovered_series_name + "')]/ancestor::li)[1]", 4);
			CommonFunctionality.wait(300);
			if (series.getAttribute("class").contains("series-list-item__selected")
					&& series.getAttribute("class").contains("series-list-item__highlighted")) {
				CommonFunctionality.getElementByClassName(login.driver, "insight-discovery--popup-back-button", 4)
						.click();
				if (CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(text(),'" + section_name + "') and not(@class='insight-discovery--popup-title')]",
						4).isDisplayed()) {
					login.Log4j
							.info("The application has been returned back to series level and verified successfully");
				} else {
					fail("Verification Failed");
				}
			} else {
				fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("Back Button Click")) {
			if (login.driver.findElements(By.xpath("(//*[@js-show-more=''])[1]")).size() > 1) {
				WebElement load = CommonFunctionality.getElementByXpath(login.driver, "//*[@js-show-more='']", 4);
				js.executeScript("arguments[0].scrollIntoView(true);", load);
				if (load.isDisplayed()) {
					CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath", "//*[@js-show-more='']");
				}
				js.executeScript("arguments[0].scrollIntoView(true);", load);
				if (load.isDisplayed()) {
					CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath", "//*[@js-show-more='']");
				}
				CommonFunctionality.wait(2000);
			}
			WebElement series = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[contains(text(),'" + hovered_series_name + "')]/ancestor::li)[1]", 4);
			js.executeScript("arguments[0].scrollIntoView(true);", series);
			if (series.getAttribute("class").contains("series-list-item__selected")
					&& series.getAttribute("class").contains("series-list-item__highlighted")) {
				CommonFunctionality.getElementByClassName(login.driver, "insight-discovery--popup-back-button", 4)
						.click();
			} else {
				sa.fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("Table - Unselect all")) {
			WebElement check = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(text(),'" + section_name + "')]/preceding::span[1]", 4);
			List<WebElement> check1 = login.driver
					.findElements(By.xpath("//*[contains(text(),'" + section_name + "')]//following::ul[1]/li"));
			if (check.getAttribute("class").contains("svg-checkbox__selected")) {
				sa.fail("Verification Failed");
			}
			for (int i = 1; i <= check1.size(); i++) {
				WebElement checking = login.driver.findElement(
						By.xpath("//*[contains(text(),'" + section_name + "')]//following::ul[1]/li[" + i + "]"));
				CommonFunctionality.wait(1000);
				if (checking.getAttribute("class").contains("series-list-item__selected")) {
					sa.fail("Verification Failed");
				}
			}
			boolean section = login.driver
					.findElement(By.xpath("//*[contains(text(),'" + section_name + "')]/preceding::input[1]"))
					.isSelected();
			if (section == true) {
				sa.fail("Section Verification failed");
			}
		}
		if (arg1.equalsIgnoreCase("Table - Edit Chart")) {
			List<WebElement> chart_series = login.driver
					.findElements(By.cssSelector(".series-edit--title.series-edit--title__editable"));
			int actual = series_count_inside_first_table;
			int expected = chart_series.size();
			sa.assertEquals(actual, expected);
			String text = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='visual-top-panel--left-controls']//*[contains(@class,'button__special')] | //*[@class='visual-top-panel--left-controls']//*[contains(@class,'button__primary')]",
					4).getText();
			String value = arg1.substring(8, arg1.length());
			CommonFunctionality.Views_list();
			sa.assertEquals(text, value);
		}
		if (arg1.equalsIgnoreCase("Table - Edit Map")) {
			List<WebElement> map_series = login.driver.findElements(By.xpath(
					"//*[@class='highcharts-series-group']//following::*[contains(@class,'highcharts-data-label-color-1')]"));
			int actual = series_count_inside_first_table;
			int expected = map_series.size();
			String text = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='visual-top-panel--left-controls']//*[contains(@class,'button__special')] | //*[@class='visual-top-panel--left-controls']//*[contains(@class,'button__primary')]",
					4).getText();
			String value = arg1.substring(8, arg1.length());
			CommonFunctionality.Views_list();
			sa.assertEquals(actual, expected);
			sa.assertEquals(text, value);
		}
		if (arg1.equalsIgnoreCase("Table - Edit Table")) {
			List<WebElement> table_series = login.driver
					.findElements(By.xpath("//thead//tr[@class=' heading'][1]//th[@class='series-edit']"));
			int actual = series_count_inside_first_table;
			int expected = table_series.size();
			sa.assertEquals(actual, expected);
			String text = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='visual-top-panel--left-controls']//*[contains(@class,'button__special')] | //*[@class='visual-top-panel--left-controls']//*[contains(@class,'button__primary')]",
					4).getText();
			String value = arg1.substring(8, arg1.length());
			sa.assertEquals(text, value);
			CommonFunctionality.Views_list();
		}
		if (arg1.equalsIgnoreCase("Table - Edit Pie")) {
			if (login.driver.findElements(By.cssSelector(".sphere-modal-dialog")).size() > 0) {
				CommonFunctionality.getElementBycssSelector(login.driver, "button__primary", 4).click();
			}
			List<WebElement> pie_series = login.driver
					.findElements(By.cssSelector(".series-edit--title.series-edit--title__editable"));
			int actual = series_count_inside_first_table;
			int expected = pie_series.size();
			sa.assertEquals(actual, expected);
			String text = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='visual-top-panel--left-controls']//*[contains(@class,'button__special')] | //*[@class='visual-top-panel--left-controls']//*[contains(@class,'button__primary')]",
					4).getText();
			String value = arg1.substring(8, arg1.length());
			sa.assertEquals(text, value);
			if (login.driver.findElements(By.className("growl-message-close")).size() > 0) {
				CommonFunctionality.getElementByClassName(login.driver, "growl-message-close", 4).click();
			}
			CommonFunctionality.Views_list();
		}
		if (arg1.equalsIgnoreCase("Table - Edit Heat map")) {
			List<WebElement> heatmap_series = login.driver
					.findElements(By.cssSelector(".series-edit--title.series-edit--title__editable"));
			int actual = series_count_inside_first_table;
			int expected = heatmap_series.size();
			sa.assertEquals(actual, expected);
			String text = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='visual-top-panel--left-controls']//*[contains(@class,'button__special')] | //*[@class='visual-top-panel--left-controls']//*[contains(@class,'button__primary')]",
					4).getText();
			String value = arg1.substring(8, arg1.length());
			sa.assertEquals(text, value);
			CommonFunctionality.Views_list();
		}
		if (arg1.equalsIgnoreCase("Table - Edit Histogram")) {
			List<WebElement> heatmap_series = login.driver.findElements(By.xpath(
					"//*[contains(@class,'highcharts-legend-item')]//following-sibling::*[contains(@class,'highcharts-histogram-series')]"));
			int actual = series_count_inside_first_table;
			int expected = heatmap_series.size();
			if (actual != expected || actual == 1) {
				login.Log4j.info("The Histogram with one series is displayed");
			}
			String text = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='visual-top-panel--left-controls']//*[contains(@class,'button__special')] | //*[@class='visual-top-panel--left-controls']//*[contains(@class,'button__primary')]",
					4).getText();
			String value = arg1.substring(8, arg1.length());
			sa.assertEquals(text, value);
			CommonFunctionality.Views_list();
		}
		if (arg1.equalsIgnoreCase("Table - Download")) {
			CommonFunctionality.wait(3000);
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(@class,'sphere-modal-controls--right')]//*[contains(text(),'Download')]", 4)
					.click();
			CommonFunctionality.wait(20000);
			String path = System.getProperty("user.home") + "\\Downloads\\Name your insight.xlsx";
			File src = new File(path);
			FileInputStream fis = new FileInputStream(src);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet1 = wb.getSheetAt(0);
			for (int i = 1; i <= series_count_inside_first_table; i++) {
				String data = sheet1.getRow(0).getCell(i).getStringCellValue();
				table_excel_values.add(data);
			}
			fis.close();
			Files.deleteIfExists(Paths.get(path));
			boolean result = Arrays.equals(series_values_in_table.toArray(), table_excel_values.toArray());
			login.Log4j.info("Comparision is: \n" + result);
			sa.assertEquals(series_values_in_table.toArray(), table_excel_values.toArray());
			login.Log4j.info(
					"The Series is getting downloaded to excel and has been verified successfully and series count is "
							+ series_count_inside_first_table);
		}
		if (arg1.equalsIgnoreCase("Top button")) {
			if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TopButton"))).isDisplayed()) {
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TopButton"))).click();
				login.Log4j.info("Clicking on Top button");
			} else {
				sa.fail("Verification Failed");
			}
		}
		login.Log4j.info("The " + arg1 + " Option is present");
	}

	@Then("^The Comparables tab is \"([^\"]*)\"$")
	public void the_Comparables_tab_is(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		if (arg1.equalsIgnoreCase("Maximized")) {
			WebElement maximize = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[contains(@title,'Expand views')])[2]//div", 4);
			if (!(maximize.getAttribute("class").contains("panel-expander--icon__left"))) {
				sa.fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("Minimized")) {
			WebElement minimize = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[contains(@title,'Expand views')]//div)[1]", 4);
			if (!(minimize.getAttribute("class").contains("panel-expander--icon__left"))) {
				sa.fail("Verification Failed");
			}
		}
		login.Log4j.info("The Comparables tab is " + arg1 + " and has been verified successfully");
	}

	@Then("^The link is navigating to \"([^\"]*)\"$")
	public void the_link_is_navigating_to(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Single Series")) {
			String text = CommonFunctionality.getElementByClassName(login.driver, "insight-discovery--popup-title", 4)
					.getText();
			CommonFunctionality.getElementByClassName(login.driver, "insight-discovery--popup-back-button", 4).click();
			if (!(text.contains(related_data_text))) {
				sa.fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("Multiple Series")) {
			List<WebElement> datasets = login.driver.findElements(By.className("series-data-set--table-name"));
			for (int i = 1; i <= datasets.size(); i++) {
				CommonFunctionality.wait(2000);
				WebElement data = CommonFunctionality.getElementByXpath(login.driver,
						"(//*[@class='series-data-set--table-name'])[" + i + "]", 4);
				String actual = data.getText();
				data.click();
				String expected = CommonFunctionality
						.getElementByClassName(login.driver, "insight-discovery--popup-title", 4).getText();
				CommonFunctionality.getElementByClassName(login.driver, "insight-discovery--popup-back-button", 4)
						.click();
				if (expected.contains("Quarterly: ")) {
					expected = expected.replaceAll("Quarterly: ", "");
				}
				if (!(expected.contains(actual))) {
					sa.fail("Verification failed");
				}
			}
		}
		login.Log4j.info("The dataset link in " + arg1 + " has been verifed successfully");
	}

	@Then("^The related \"([^\"]*)\" for the series should shown$")
	public void the_related_for_the_series_should_shown(String arg1) throws Throwable {
		CommonFunctionality.wait(4000);
		if (arg1.equalsIgnoreCase("Database") || arg1.equalsIgnoreCase("Topic") || arg1.equalsIgnoreCase("Section")) {
			WebElement database = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(text(),'" + related_dataset_text + "')]/ancestor::div[2]", 4);
			js.executeScript("arguments[0].scrollIntoView(true);", database);
			if (!(database.getAttribute("class").contains("open"))) {
				sa.fail("Verification Failed");
			}
		}
		login.Log4j.info("The related " + arg1 + " for the series has been verified successfully");
	}

	@SuppressWarnings("deprecation")
	@Then("^The Sharing insight window should be opened$")
	public void the_Sharing_insight_window_should_be_opened() throws Throwable {
		if (login.driver.findElements(By.className("related-insights-preview")).size() > 0) {
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"(//*[contains(@class,'insight-share-button__gray')])[1]", 4))
					.pause(1000).click().build().perform();
			if (login.driver
					.findElements(By.xpath("//*[contains(@class,'sphere-modal__content')]//*[text()='Name insight']"))
					.size() > 0) {
				CommonFunctionality.getElementByClassName(login.driver, "input-share", 4).sendKeys(Keys.ENTER);
				CommonFunctionality.getElementByClassName(login.driver, "input-share", 4).sendKeys(Keys.BACK_SPACE);
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'button button__primary') and text()='Save']", 4).click();
				CommonFunctionality.wait(2000);
				if (CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'sphere-modal-dialog')]//*[contains(@class,'modal-title') and contains(text(),'Share')]",
						4).isDisplayed()) {
					login.Log4j.info("The Sharing insight window is opened and has been verified successfully");
					CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
				} else {
					sa.fail("Sharing window is not displayed");
				}
			} else {
				if (CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'sphere-modal-dialog')]//*[contains(@class,'modal-title') and contains(text(),'Share')]",
						4).isDisplayed()) {
					login.Log4j.info("The Sharing insight window is opened and has been verified successfully");
					CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
				} else {
					sa.fail("Sharing window is not displayed");
				}
			}
		} else {
			sa.fail("Insights are not there for the series");
		}
		// CommonFunctionality.CollapseTreeMethod();
		// login.driver.navigate().refresh();
	}

	@Then("^Clicking on go to the insight name should open the new insight with the added series$")
	public void clicking_on_go_to_the_insight_name_should_open_the_new_insight_with_the_added_series()
			throws Throwable {
		login.driver.findElement(By.xpath(
				"//*[@class='growl-message growl-success']//*[@class='button growl-message-content--btns__fill']"))
				.click();
		CommonFunctionality.wait(2000);
		ArrayList<String> tabs = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs.get(1));
		String actual = CommonFunctionality.getElementByProperty(login.driver, "One_series_from_myserieslist", 4)
				.getText();
		CommonFunctionality.Views_list();
		login.driver.switchTo().window(tabs.get(1)).close();
		login.Log4j.info("The Add to new insight feature has been verified successfully");
		login.driver.switchTo().window(tabs.get(0));
		sa.assertEquals(actual, hovered_series_name);
		// CommonFunctionality.CollapseTreeMethod();
		// CommonFunctionality.UnselectMethod();
	}

	@Then("^The options should present inside tooltip$")
	public void the_options_should_present_inside_tooltip() throws Throwable {
		String a = "Region";
		String b = "Name";
		String c = "Unit";
		String d = "Frequency";
		String e = "First obs. date";
		String f = "Last obs. date";
		String g = "Observations";
		String i = "Last value";
		String j = "Last update time";
		String k = "Source";
		String l = "Series id";
		String m = "Classification";
		String n = "More";
		String o = "Indicator";
		CommonFunctionality.wait(2000);
		List<WebElement> tooltips = login.driver
				.findElements(By.xpath("//tr[@class='series-tooltip-table--row']//td[1]"));
		for (int z = 1; z < tooltips.size(); z++) {
			WebElement tooltip = login.driver
					.findElement(By.xpath("(//tr[@class='series-tooltip-table--row']//td[1])[" + z + "]"));
			String split = tooltip.getText();
			String[] text = split.split("\\:");
			if (text[0].equals(a) || text[0].equals(b) || text[0].equals(c) || text[0].equals(d) || text[0].equals(e)
					|| text[0].equals(f) || text[0].equals(g) || text[0].equals(i) || text[0].equals(j)
					|| text[0].equals(k) || text[0].equals(l) || text[0].equals(n) || text[0].equals(m)
					|| text[0].equals(o)) {
				System.out.println("The tooltip value is: " + text[0]);
			} else {
				fail(text[0] + " is not present");
			}
		}
		// CommonFunctionality.CollapseTreeMethod();
	}

	@Then("^The Share icon should not present for non sharing related insight$")
	public void the_Share_icon_should_not_present_for_non_sharing_related_insight() throws Throwable {
		if (login.driver.findElements(By.xpath("//*[text()='" + insight_text
				+ "']/preceding::*[contains(@title,'favorite')][1]/following-sibling::div[@title='Share Insight']"))
				.size() == 0) {
			login.Log4j.info(
					"The Share icon is not present for non sharing related insight and has been verified successfully");
		} else {
			fail("The Share icon is present for non sharing related insight");
		}
		// CommonFunctionality.CollapseTreeMethod();
	}

	@Then("^The opened dropdown should not close$")
	public void the_opened_dropdown_should_not_close() throws Throwable {
		if (login.driver.findElements(By.xpath("//*[contains(text(),'" + hovered_series_name
				+ "')]//following-sibling::div[@title='Hide related data']")).size() > 0) {
			login.Log4j.info("The Opened drop down has not been closed and has been verified successfully");
		} else {
			fail("The Opened drop down has been closed");
		}
		// CommonFunctionality.CollapseTreeMethod();
	}

	@Then("^The tooltip as \"([^\"]*)\" and \"([^\"]*)\" should present$")
	public void the_tooltip_as_and_should_present(String arg1, String arg2) throws Throwable {
		String name = CommonFunctionality
				.getElementByXpath(login.driver, "(//*[contains(@class,'insight-table-item--title-link')])[1]", 4)
				.getText();
		String tooltip = CommonFunctionality
				.getElementByXpath(login.driver, "(//*[contains(@class,'insight-table-item--title-link')])[1]", 4)
				.getAttribute("title");
		// System.out.println(tooltip);
		String text[] = tooltip.split("\n");
		if (text[0].equals(name) && text[1].contains(arg2)) {
			login.Log4j.info("The tooltip is present and has been verified successfully");
		} else {
			fail("Verification Failed");
		}
		// login.driver.navigate().refresh();
	}

	@Then("^The creator tooltip should present$")
	public void the_creator_tooltip_should_present() throws Throwable {
		String name = CommonFunctionality.getElementByXpath(login.driver,
				"(//*[contains(@class,'insight-table-item--info')]//*[@class='text-dots'])[1]", 4).getText();
		String value = CommonFunctionality
				.getElementByXpath(login.driver, "(//*[contains(@class,'insight-table-item--info-date')])[1]/span", 4)
				.getText();
		String modify = value.substring(0, value.length() - 1);
		String tooltip = CommonFunctionality
				.getElementByXpath(login.driver, "(//*[contains(@class,'insight-table-item--info-date')])[1]", 4)
				.getAttribute("title");
		// System.out.println(tooltip);
		String text[] = tooltip.split("\n");
		String creator[] = text[0].split("Created by ");
		String modifier[] = text[1].split("Last modified by ");
		if (creator[1].equals(name) && modifier[1].contains(modify)) {
			login.Log4j.info("The tooltip is present and has been verified successfully");
		} else {
			fail("Verification Failed");
		}
		// login.driver.navigate().refresh();
	}

	@Then("^The Modified time tooltip should present$")
	public void the_Modified_time_tooltip_should_present() throws Throwable {
		String time = CommonFunctionality.getElementByXpath(login.driver,
				"(//*[contains(@class,'insight-table-item--info-date')])[1]/span[2]", 4).getText();
		String tooltip = CommonFunctionality
				.getElementByXpath(login.driver, "(//*[contains(@class,'insight-table-item--info-date')])[1]", 4)
				.getAttribute("title");
		// System.out.println(tooltip);
		String text[] = tooltip.split("\n");
		String split_time[] = text[1].split("Last modified by ");
		String[] tooltip_time = split_time[1].split("(?<=\\D)(?=\\d)");
		if (tooltip_time[0].contains(time) || tooltip_time[1].contains(time) || tooltip_time[2].contains(time)) {
			login.Log4j.info("The tooltip is present and has been verified successfully");
		} else {
			fail("Verification Failed");
		}
		// login.driver.navigate().refresh();
	}

	@SuppressWarnings("deprecation")
	@Then("^The Related insights should be added to favourite list in insight explorer window of favorite tab$")
	public void the_Related_insights_should_be_added_to_favourite_list_in_insight_explorer_window_of_favorite_tab()
			throws Throwable {
		WebElement grid_mode = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@title='View as a grid']/parent::div", 4);
		if (grid_mode.getAttribute("class").contains("insights-view-modes__grid-mode-teal")) {
			System.out.println("Already grid mode is clicked");
		} else {
			new Actions(login.driver)
					.moveToElement(
							CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a grid']", 4))
					.pause(500).click().build().perform();
		}
		WebElement title_name = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'bottom-panel-title') and @title='" + insight_text + "']", 4);
		js.executeScript("arguments[0].scrollIntoView(true);", title_name);
		if (title_name.isDisplayed()) {
			login.Log4j.info(
					"The Related insights is added to favourite list in insight explorer window of favorite tab and has been verified successfully");
		} else {
			fail("The Related insights is not added to favorites");
		}
		cv.navigating_back_and_refresh_button();
	}

	@Then("^Insight explorer window should be opened$")
	public void insight_explorer_window_should_be_opened() throws Throwable {
		if (CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='dropdown-menu']//h4[text()='Add to recent insight']", 4)
				.isDisplayed()) {
			login.Log4j.info("Insight explorer window has been opened and verified successfully");
		} else {
			fail("Insight explorer window not opened");
		}
		CommonFunctionality.DeleteSeries();
	}

	@Then("^Insight explorer window should be closed$")
	public void insight_explorer_window_should_be_closed() throws Throwable {
		if (login.driver.findElements(By.xpath("//*[@class='dropdown-menu']//h4[text()='Add to recent insight']"))
				.size() == 0) {
			login.Log4j.info("Insight explorer window has been closed and verified successfully");
		} else {
			sa.fail("Insight explorer window not closed");
		}
		CommonFunctionality.DeleteSeries();
	}

	@Then("^Should be able to navigate to existing insight$")
	public void should_be_able_to_navigate_to_existing_insight() throws Throwable {
		List<WebElement> insights_all = login.driver.findElements(By.className("input-control--description"));
		for (WebElement insight : insights_all) {
			SSPWindow.add_to_recent_insight = insight.getText();
			new Actions(login.driver).moveToElement(insight).click().build().perform();
			break;
		}
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='Apply']", 4).click();
		String expected = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(@class,'growl-message--link__highlighted')]", 4)
				.getText();
		if (expected.contains(SSPWindow.add_to_recent_insight)) {
			login.Log4j.info("Add to existing insight has been verified");
		} else {
			sa.fail("Add to exisiting insight verification failed");
		}
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'growl-message--link')]", 4).click();
		ArrayList<String> tabs = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs.get(1));
		CommonFunctionality.wait(2000);
		String actual = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(@class,'insight-breadcrumb--title-block')]", 4)
				.getText();
		login.driver.switchTo().window(tabs.get(1)).close();
		login.driver.switchTo().window(tabs.get(0));
		assertEquals(actual, SSPWindow.add_to_recent_insight);
		CommonFunctionality.DeleteSeries();
	}
}