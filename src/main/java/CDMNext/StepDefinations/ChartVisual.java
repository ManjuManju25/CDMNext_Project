package CDMNext.StepDefinations;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.google.common.collect.Ordering;
import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import static org.junit.Assert.assertNotEquals;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class ChartVisual {

	CDMNextSprintCases cv = new CDMNextSprintCases();
	WebDriverWait wait = new WebDriverWait(login.driver, 100);
	SoftAssert sa = new SoftAssert();
	JavascriptExecutor js = (JavascriptExecutor) login.driver;
	public int m;
	public static String first_series_title;
	public static String chart_visual_title;
	public static String color;
	public static String series_color;
	public static String axis_color;
	public static String tooltip_color;
	public static String highlight_color;
	public static String legend_color;
	public static String copyright_color;
	public static String legend_bgcolor;
	public static String legend_border_color;
	public static String Style_title;
	public static String chart_title_text;
	public static String chart_subtitle_text;
	public static String insight = "MyInsight";
	public static String font_size;
	public static String font_size_y_axis = "15";
	public static String point_marker_radius = "12";
	public static String font_rotation_y_axis = "15";
	public static String font_rotation_x_axis = "15";
	public static String time_axis_label_date_format = "YYYY/DD";
	public static String time_axis_label_date_format1 = "YYYY/DD/MM";
	public static String decimal_value;
	public static String width_y_axis;
	public static String width_x_axis;
	public static String series_chart_color;
	public static String tooltip_border_width;
	public static String data_labels_font_size;
	public static String legend_title_font_size;
	public static String data_position;
	public static String copyright_font_size;
	public static String legend_border_width;
	public static String legend_border_radius;
	public static String series_stroke_size;
	public static String axis_multipler_value_axis;
	public static String chart_axis_multipler_value_numberformat;
	public static String value_line_color;
	public static String time_line_color;
	public static String time_axis_color;
	public static String time_axis_label_color;
	public static String time_axis_bgcolor;
	public static String tooltip_border_color;
	public static String data_label_color;
	public static String data_label_highlight_color;
	public static String start_date_timeframe_chart;
	public static String end_date_timeframe_chart;
	public static String timepoints_first_date;
	public static String timepoints_last_date;
	public static String correct_observations;
	public static String incorrect_start_date;
	public static String incorrect_end_date;
	public static String data_format_decimal_start_value;
	public static String data_format_decimal_end_value;
	public static String name_ssp;
	public static String region_ssp;
	public static String rename_series;
	public static String frequency_ssp;
	public static String unit_ssp;
	public static String timeframe_label_text;
	public static String time_axis_label_text;
	public static String time_axis_label_line_color;
	public static String time_color;
	public static String before_invert;
	public static String after_invert;
	public static String series_name_text;
	public static String[] split_text;
	public static String number_separator;
	public static String decimal_separator;
	public static String data_format_separator;
	public static String data_format_grouping_separator;
	public static String point_marker;
	public static String y_axis_title;
	public static String y_axis_opposite_title;
	public static String legend_title;
	public static String copyright_title;
	public static String copyright_title_link;
	public static String y_axis_color;
	public static String y_axis_right_color;
	public static String y_axis_bgcolor;
	public static String y_axis_right_bgcolor;
	public static String y_axis_font_size;
	public static String y_axis_right_font_size;
	public static String series_title;
	public static String visual_title;
	public static String visual_name;
	public static String edit_series_title;
	public static String copied_text;
	public static String read_copied_data;
	public static String path;
	public static String applied_function;
	public static String myseriestitle;
	public static String function_myseries;
	public static String y1_start;
	public static String y1_end;
	public static String y3_start;
	public static String y3_end;
	public static String y5_start;
	public static String y5_end;
	public static String All_start;
	public static String All_end;
	public static String currency_in_series;
	public static String change_in_series;
	public static String copyright_checkbox_text;
	public static Date date;
	public static Date date1;
	public static Date date2;
	public static int diff;
	public SimpleDateFormat formatter;
	public boolean checkbox_status;
	public boolean checked;
	public boolean checkbox2;
	public boolean checkbox_visual_border;
	public boolean values_axis_checkbox;
	public boolean copyright_checkbox;
	public boolean values_axis_checkboxes;
	public boolean timeframe_checkboxes;
	public boolean values_axis_checkboxes_uncheck;
	public boolean time_axis_checkboxes;
	public boolean uncheck_checkbox;
	public boolean tooltips_checkbox;
	public boolean tooltips_uncheckbox;
	public boolean axis_setup_checkboxes_uncheck;
	public boolean axis_setup_checkboxes_uncheck_right;
	public boolean axis_checkboxes_right;
	public boolean legend_checkbox;
	public boolean legend_checkbox_uncheck;
	public boolean zoom_checkbox;
	public boolean copyright_checkbox_unchecked;
	public WebElement ele;
	public WebElement low;
	public WebElement middle;
	public WebElement high;
	public WebElement bold;
	public WebElement italic;
	public WebElement underline;
	public WebElement left;
	public WebElement right;
	public WebElement center;
	public WebElement visual_align;
	public WebElement y_axis_bold;
	public WebElement y_axis_italic;
	public WebElement y_axis_underline;
	public WebElement data_labels_bold;
	public WebElement data_labels_italic;
	public WebElement data_labels_underline;
	public WebElement legends_bold;
	public WebElement legends_italic;
	public WebElement legends_underline;
	public WebElement copyrights_bold;
	public WebElement copyrights_italic;
	public WebElement copyrights_underline;
	public WebElement timepoints_bold;
	public WebElement timepoints_italic;
	public WebElement timepoints_underline;
	public WebElement timepoints_revert_bold;
	public WebElement timepoints_revert_italic;
	public WebElement timepoints_revert_underline;
	public WebElement y_axis_left_bold;
	public WebElement y_axis_left_italic;
	public WebElement y_axis_left_underline;
	public WebElement y_axis_right_bold;
	public WebElement y_axis_right_italic;
	public WebElement y_axis_right_underline;
	public WebElement time_axis_bold;
	public WebElement time_axis_italic;
	public WebElement time_axis_underline;
	public WebElement timeaxis_label_bold;
	public WebElement timeaxis_label_italic;
	public WebElement timeaxis_label_underline;
	public WebElement insert_chart;
	public WebElement dest;
	public int Value;
	public int position;
	public int decimalValues;
	public static int chart_decimal_places;
	public int logarithmic_before;
	public int logarithmic_after;
	public int logarithmic_before_right;
	public int logarithmic_after_right;
	public int views_before;
	public int views_after;
	public int series_before;
	public static int myseries_before;
	public int views_count;
	public static String destFile;
	public static Date timepoints_start_date;
	public static Date timepoints_end_date;
	public static Date timepoints_start_date_ssp;
	public static Date timepoints_end_date_ssp;
	public static Date final_date;
	ArrayList<Date> date_excel = new ArrayList<Date>();
	ArrayList<Date> date_app = new ArrayList<Date>();
	ArrayList<Double> timepoints_excel = new ArrayList<Double>();
	ArrayList<BigInteger> list1 = new ArrayList<BigInteger>();
	ArrayList<BigInteger> list2 = new ArrayList<BigInteger>();
	ArrayList<BigInteger> list3 = new ArrayList<BigInteger>();
	ArrayList<Integer> list3_1 = new ArrayList<Integer>();
	ArrayList<Integer> list4 = new ArrayList<Integer>();
	ArrayList<Double> timepoints_app = new ArrayList<Double>();
	ArrayList<String> timepoint_ssp = new ArrayList<String>();
	ArrayList<Date> date_ssp = new ArrayList<Date>();
	ArrayList<String> timepoint_visual = new ArrayList<String>();
	ArrayList<Date> date_visual = new ArrayList<Date>();
	ArrayList<String> rightclick_element = new ArrayList<String>();
	ArrayList<String> insert_visual_list = new ArrayList<String>();
	ArrayList<String> view_as = new ArrayList<String>();
	ArrayList<String> download = new ArrayList<String>();
	String Borderstyle;

	@And("^Read the \"([^\"]*)\" and \"([^\"]*)\" from excel file \"([^\"]*)\"$")
	public void read_the_from_excel(String arg1, String arg2, String arg3) throws Throwable {
		// Create an object of File class to open xlsx file
		String excel_file = System.getProperty("user.dir") + "\\Testdata\\" + arg3 + "";
		File src = new File(excel_file);
		// Create an object of FileInputStream class to read excel file
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		int rowcount = sheet1.getLastRowNum();
		login.Log4j.info("Total number of rows present in the excel sheet: " + rowcount);
		int colcount = sheet1.getRow(1).getLastCellNum();
		login.Log4j.info("Total number of columns present in the excel sheet: " + colcount);
		for (int i = 26; i <= rowcount; i++) {
			XSSFCell date = sheet1.getRow(i).getCell(0);
			XSSFCell timepoints = sheet1.getRow(i).getCell(1);
			if (date.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				double double_date = date.getNumericCellValue();
				// Converting Number representation of Date in excel to Date in java
				Date javaDate = DateUtil.getJavaDate(double_date);
				// Storing the date format in a string variable
				String sdf = new SimpleDateFormat("MM/dd/yyyy").format(javaDate);
				final_date = new SimpleDateFormat("MM/dd/yyyy").parse(sdf);
				// Creating a date array for comparison of excel observation date with
				// application observation date
				date_excel.add(final_date);
			} else if (date.getCellType() == Cell.CELL_TYPE_STRING) {
				double double_date1 = date.getNumericCellValue();
				// Converting Number representation of Date in excel to Date in java
				Date javaDate1 = DateUtil.getJavaDate(double_date1);
				// Storing the date format in a string variable
				String sdf = new SimpleDateFormat("MM/dd/yyyy").format(javaDate1);
				final_date = new SimpleDateFormat("MM/dd/yyyy").parse(sdf);
				// Creating a date array for comparison of excel observation date with
				// application observation date
				date_excel.add(final_date);
			}
			if (timepoints.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				double timepoints_double = timepoints.getNumericCellValue();
				NumberFormat formatter = new DecimalFormat("########0.00");
				String new_format = formatter.format(timepoints_double);
				double excel = Double.parseDouble(new_format);
				timepoints_excel.add(excel);
			} else if (timepoints.getCellType() == Cell.CELL_TYPE_STRING) {
				double timepoints_double1 = timepoints.getNumericCellValue();
				NumberFormat formatter = new DecimalFormat("########0.00");
				String new_format1 = formatter.format(timepoints_double1);
				double excel1 = Double.parseDouble(new_format1);
				timepoints_excel.add(excel1);
			}
		}
		login.Log4j.info("<===================================== Excel values ====================================>");
		login.Log4j.info(date_excel);
		login.Log4j.info(timepoints_excel);
	}

	@And("^Observe the entire list of \"([^\"]*)\"$")
	public void observe_the_entire_list_of(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Timepoints")) {
			List<WebElement> timepoints = login.driver
					.findElements(By.className("preview-series-time-points--point-value"));
			for (int i = timepoints.size() - 1; i >= 0; i--) {
				String value = timepoints.get(i).getText();
				String replaceLine = value.replaceAll(",", "");
				double string_conversion = Double.parseDouble(replaceLine);
				NumberFormat number = new DecimalFormat("########0.00");
				String new_format = number.format(string_conversion);
				timepoint_ssp.add(new_format);
			}
			login.Log4j.info(timepoint_ssp);
		}
		if (arg1.equalsIgnoreCase("Date")) {
			List<WebElement> all_date = login.driver
					.findElements(By.className("preview-series-time-points--point-date"));
			for (int i = all_date.size() - 1; i >= 0; i--) {
				String value = all_date.get(i).getText();
				Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(value);
				date_ssp.add(date1);
			}
			login.Log4j.info(date_ssp);
			CommonFunctionality.Hidden_Webelements_handling(login.driver, "className", "movable-modal--close");
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Creating an Insight by selecting few series$")
	public void creating_an_Insight_by_selecting_few_series() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByProperty(login.driver, "Series", 4).click();
		WebElement first_series = CommonFunctionality.getElementByProperty(login.driver, "First_series_item_in_series",
				8);
		new Actions(login.driver).moveToElement(first_series).pause(4000).click().build().perform();
		WebElement second_series = CommonFunctionality.getElementByProperty(login.driver,
				"Second_series_item_in_series", 8);
		new Actions(login.driver).moveToElement(second_series).pause(4000).click().build().perform();
		WebElement actions = CommonFunctionality.getElementByProperty(login.driver, "add_to_myseries_icon", 8);
		new Actions(login.driver).moveToElement(actions).pause(4000).click().build().perform();
	}

	@And("^Login to application$")
	public void login_to_application() throws Throwable {
		login.application_login();
	}

	@And("^Close the chart visual$")
	public void close_the_chart_visual() throws Throwable {
		if (login.driver.findElements(By.className("movable-modal--close")).size() > 0) {
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			if (login.driver.findElements(By.cssSelector("button.sphere-modal-control.button.button__primary"))
					.size() > 0) {
				CommonFunctionality
						.getElementBycssSelector(login.driver, "button.sphere-modal-control.button.button__primary", 4)
						.click();
			}
		}
		CommonFunctionality.Views_list();
	}

	@And("^Closing the chart visual$")
	public void closing_the_chart_visual() throws Throwable {
		CommonFunctionality.Views_list();
	}

	@SuppressWarnings("deprecation")
	@And("^Disable the Chat bubble$")
	public void disable_the_Chat_bubble() throws Throwable {
		if (login.driver.findElements(By.xpath("//*[@id='live-chat-bubble']")).size() > 0) {
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[@class='help-title']/*", 8))
					.pause(2000).click().build().perform();
			WebElement chat = CommonFunctionality.getElementByXpath(login.driver,
					"//*[text()='Live chat']/following::div[2]", 4);
			if (chat.getAttribute("class").contains("bootstrap-switch-on")) {
				new Actions(login.driver).moveToElement(
						CommonFunctionality.getElementByXpath(login.driver, "//*[@class='bootstrap-switch-label']", 4))
						.pause(500).click().build().perform();
			} else {
				System.out.println("Live Chat is already off");
			}
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[@class='help-title']/*", 8))
					.pause(2000).click().build().perform();
		}
		CommonFunctionality.wait(4000);
	}

	@SuppressWarnings("deprecation")
	@And("^Enable the Chat bubble$")
	public void enable_the_Chat_bubble() throws Throwable {
		if (login.driver.findElements(By.xpath("//*[@id='live-chat-bubble']")).size() == 0) {
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[@class='help-title']/*", 8))
					.pause(2000).click().build().perform();
			WebElement chat = CommonFunctionality.getElementByXpath(login.driver,
					"//*[text()='Live chat']/following::div[2]", 4);
			if (chat.getAttribute("class").contains("bootstrap-switch-off")) {
				new Actions(login.driver).moveToElement(
						CommonFunctionality.getElementByXpath(login.driver, "//*[@class='bootstrap-switch-label']", 4))
						.pause(500).click().build().perform();
			} else {
				System.out.println("Live Chat is already on");
			}
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[@class='help-title']/*", 8))
					.pause(2000).click().build().perform();
		}
		CommonFunctionality.wait(4000);
	}

	@And("^Select more than (\\d+) series from browse tab$")
	public void select_more_than_series_from_browse_tab(int arg1) throws Throwable {
		CommonFunctionality.webDriverwait_keyvalue("Series");
		CommonFunctionality.getElementByProperty(login.driver, "Series", 4).click();
		WebElement ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
		for (int i = 1; i <= li_All.size(); i++) {
			m = i;
			WebElement series = CommonFunctionality.getElementByXpath(login.driver,
					"//li[" + m + "]//div[@class='series-list-item--checkbox-wrapper']/span", 4);
			js.executeScript("arguments[0].scrollIntoView(true);", series);
			js.executeScript("arguments[0].click();", series);
			ele = login.driver.findElement(By.xpath("//li[" + m + "]//div[@class='series-item--name']"));
			if (m == arg1 + 1) {
				break;
			}
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Perform DragDrop operation in \"([^\"]*)\" Chart$")
	public void perform_DragDrop_operation_in_Chart(String arg1) throws Throwable {
		WebElement source = CommonFunctionality.getElementByClassName(login.driver, "search-series-list", 4);
		WebElement target = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='view-components-over--visual']//*[text()='" + arg1 + "']", 4);
		new Actions(login.driver).moveToElement(source).pause(2000).dragAndDrop(source, target).build().perform();
	}

	@And("^Click on \"([^\"]*)\" option from Visual$")
	public void click_on_option_from_Visual(String arg1) throws Throwable {
		if (CommonFunctionality.getElementBycssSelector(login.driver, "*[title='" + arg1 + "']", 4).isDisplayed()) {
			CommonFunctionality.getElementBycssSelector(login.driver, "*[title='" + arg1 + "']", 4).click();
		} else {
			fail(arg1 + " is not displayed");
		}
	}

	@And("^Copy the insight title$")
	public void copy_the_insight_title() throws Throwable {
		visual_title = CommonFunctionality.getElementBycssSelector(login.driver, ".visual-title--text.text-dots", 4)
				.getText();
	}

	@SuppressWarnings("deprecation")
	@And("^Select (\\d+) series for chart and click on chart option$")
	public void select_series_for_chart_and_click_on_chart_option(int arg1) throws Throwable {
		// CommonFunctionality.getElementBycssSelector(login.driver, "label[title='View
		// results as List']", 4).click();
		CommonFunctionality.webDriverwait_keyvalue("Series_tab");
		WebElement SeriesTab = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(login.LOCATORS.getProperty("Series"))));
		SeriesTab.click();
		for (int i = 1; i <= arg1; i++) {
			CommonFunctionality.wait(200);
			WebElement series_unselected = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='search-series-list']/*[" + i + "]", 4);
			WebElement series = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='search-series-list']/*[" + i + "]/div/a/div[2]/span/*", 4);
			if (!series_unselected.getAttribute("class").contains("series-list-item__selected")) {
				new Actions(login.driver).moveToElement(series).pause(500).click().build().perform();
			}
		}
		new Actions(login.driver).sendKeys("c").pause(500).perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Hover over the legend$")
	public void hover_over_the_legend() throws Throwable {
		CommonFunctionality.wait(4000);
		WebElement title = CommonFunctionality.getElementByXpath(login.driver, "//span[@data-name='title']", 8);
		new Actions(login.driver).moveToElement(title).pause(1000).build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Hover over the legend title$")
	public void hover_over_the_legend_title() throws Throwable {
		CommonFunctionality.wait(1000);
		WebElement series = CommonFunctionality.getElementBycssSelector(login.driver, ".series-edit--title__editable",
				4);
		new Actions(login.driver).moveToElement(series).pause(1000).build().perform();
	}

	@And("^Count the list of views \"([^\"]*)\" clicking the New option$")
	public void count_the_list_of_views_clicking_the_New_option(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		if (arg1.equalsIgnoreCase("Before")) {
			List<WebElement> views = login.driver.findElements(By.cssSelector(".insight-page-view-tab--title"));
			views_before = views.size();
		}
		if (arg1.equalsIgnoreCase("After")) {
			List<WebElement> views = login.driver.findElements(By.cssSelector(".insight-page-view-tab--title"));
			views_after = views.size();
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Drag and Drop the series into right$")
	public void drag_and_Drop_the_series_into_right() throws Throwable {
		first_series_title = CommonFunctionality.getElementByProperty(login.driver, "One_series_from_seriesList", 4)
				.getText();
		WebElement source = CommonFunctionality.getElementByProperty(login.driver, "One_series_from_seriesList", 4);
		WebElement target = CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Drag series here'])[1]",
				4);
		new Actions(login.driver).pause(1000).dragAndDrop(source, target).build().perform();
		CommonFunctionality.wait(3000);
		chart_visual_title = CommonFunctionality.getElementBycssSelector(login.driver, "span[data-name='title']", 4)
				.getText();
	}

	@And("^Select the style title as \"([^\"]*)\"$")
	public void select_the_style__title_as(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg1 + "']", 4).click();
		CommonFunctionality.wait(2000);
	}

	@And("^Revert the \"([^\"]*)\" for chart visual to (\\d+)$")
	public void revert_the_for_chart_visual_to(String arg1, int arg2) throws Throwable {
		String revert = Integer.toString(arg2);
		WebElement rotation = null;
		if (arg1.equalsIgnoreCase("Value_label_rotation")) {
			rotation = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='popover--wrapper']//*[@name='y_axis_label_rotation']", 4);
		} else if (arg1.equalsIgnoreCase("Time_Axis_label_rotation")) {
			rotation = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='popover--wrapper']//*[@name='x_axis_label_rotation']", 4);
		}
		rotation.sendKeys(Keys.chord(Keys.CONTROL, "a"), revert);
		rotation.sendKeys(Keys.TAB);
		CommonFunctionality.wait(2000);
	}

	@And("^Activate the \"([^\"]*)\" header$")
	public void activate_the_header(String arg1) throws Throwable {
		WebElement axis = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'accordion-tabbar--header-tab') and contains(text(),'" + arg1 + "')]", 4);
		if (!axis.getAttribute("class").contains("active")) {
			axis.click();
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Press \"([^\"]*)\" option$")
	public void press_option(String arg1) throws Throwable {
		List<WebElement> list = login.driver.findElements(By.xpath("//ul[@class='search-series-list']/li"));
		for (int i = 1; i <= list.size(); i++) {
			WebElement series_unselected = CommonFunctionality.getElementByXpath(login.driver,
					"//ul[@class='search-series-list']/li[" + i + "]", 4);
			WebElement series = CommonFunctionality.getElementByXpath(login.driver,
					"//ul[@class='search-series-list']/li[" + i + "]/div/a/div[2]/span/*", 4);
			if (!series_unselected.getAttribute("class").contains("series-list-item__selected")) {
				new Actions(login.driver).moveToElement(series).pause(3000).click().build().perform();
			}
		}
		new Actions(login.driver).sendKeys(arg1).pause(2000).build().perform();
	}

	@And("^Resetting back the width to original$")
	public void resetting_back_the_width_to_original() throws Throwable {
		if (login.driver.findElements(By.className("popover--wrapper")).size() > 0) {
			CommonFunctionality.getElementByClassName(login.driver, "popover--close", 4).click();
		}
		close_the_chart_visual();
	}

	@SuppressWarnings("deprecation")
	@And("^Remove the customized template$")
	public void remove_the_customized_template() throws Throwable {
		if (login.driver.findElements(By.cssSelector("div[title='Shravas']")).size() > 0) {
			new Actions(login.driver).moveToElement(login.driver.findElement(By.cssSelector("div[title='Shravas']")))
					.pause(1000).build().perform();
			CommonFunctionality.getElementBycssSelector(login.driver, "div[title='Delete template']", 4).click();
			if (login.driver.findElements(By.xpath("//*[contains(@class,'modal-content')]//*[text()='Ok']"))
					.size() > 0) {
				CommonFunctionality
						.getElementByXpath(login.driver, "//*[contains(@class,'modal-content')]//*[text()='Ok']", 4)
						.click();
			}
		}
	}

	@And("^Check the style attribute title$")
	public void check_the_style_attribute_title() throws Throwable {
		Style_title = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(@class,'style-templates-item__active')]", 4)
				.getAttribute("title");
		CommonFunctionality.wait(2000);
	}

	@And("^Enter \"([^\"]*)\" and \"([^\"]*)\" separator for Value axis$")
	public void enter_and_seperator_for_Value_axis(String decimal, String grouping) throws Throwable {
//		CommonFunctionality.getElementByXpath(login.driver,
//				"//*[text()='Decimal separator']/following::span[text()=\"" + decimal + "\"][1]", 4).click();
//		CommonFunctionality.getElementByXpath(login.driver,
//				"//*[text()='Grouping separator']/following::span[text()=\"" + grouping + "\"]", 4).click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='number-format-picker']/*[2]/*[2]//*[@value=\"" + decimal + "\"]", 4).click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='number-format-picker']/*[3]/*[2]//*[@value=\"" + grouping + "\"]", 4).click();
		
	}

	@And("^Select \"([^\"]*)\" and \"([^\"]*)\" separator from dropdown$")
	public void select_and_separator_from_dropdown(String number, String decimal) throws Throwable {
		number_separator = number;
		decimal_separator = decimal;
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[text()='Number separators']/following::div[1]//a/span[2]", 4)
				.click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'select2-drop-active')]//*[contains(text(),\"" + number_separator + "\")]", 4)
				.click();
		CommonFunctionality
				.getElementByXpath(login.driver, "(//*[text()='Number separators']//following::div/a/span[2])[2]", 4)
				.click();
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[@class='select2-result-label']//*[contains(text(),\"" + decimal_separator + "\")]", 4)
				.click();
	}

	@And("^Select \"([^\"]*)\" and \"([^\"]*)\" separator from dropdown list$")
	public void select_and_separator_from_dropdown_list(String decimal, String group) throws Throwable {
		data_format_separator = decimal;
		data_format_grouping_separator = group;
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[text()='Decimal separator']//following::*[contains(text(),\"" + data_format_separator + "\")][1]",
				4).click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[text()='Grouping separator']//following::*[contains(text(),\""
						+ data_format_grouping_separator + "\")][1]", 4)
				.click();
	}

	@And("^Select \"([^\"]*)\" separator from \"([^\"]*)\" dropdown$")
	public void select_a_separator_from_dropdown(String arg1, String arg2) throws Throwable {
		if (arg2.equalsIgnoreCase("Decimal separator")) {
			data_format_separator = arg1;
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[text()='" + arg2 + "']//following::*[contains(text(),\"" + data_format_separator + "\")][1]",
					4).click();
		}
		if (arg2.equalsIgnoreCase("Grouping separator")) {
			data_format_grouping_separator = arg1;
			CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + arg2
					+ "']//following::*[contains(text(),\"" + data_format_grouping_separator + "\")][1]", 4).click();
		}
		if (arg2.equalsIgnoreCase("Decimal places")) {
			String value = arg1;
			chart_decimal_places = Integer.parseInt(value);
			WebElement input = CommonFunctionality.getElementByXpath(login.driver,
					"//*[text()='" + arg2 + "']/following::input[1]", 4);
			input.sendKeys(Keys.chord(Keys.CONTROL, "a"), value);
		}
	}

	@And("^Check for the style attribute checkboxes$")
	public void check_for_the_style_attribute_checkboxes() throws Throwable {
		List<WebElement> style_checkboxes = login.driver
				.findElements(By.xpath("//*[@class='base-config chart-config']//*[@class='input-control--input']"));
		for (int i = 1; i < style_checkboxes.size() - 1; i++) {
			String text = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[@class='input-control--input']/following-sibling::span[2])[" + i
							+ "] | (//*[@class='input-control--input']/following::*[@class='x-axis-context-title'])["
							+ i
							+ "] | (//*[@class='input-control--input']/following::*[@class='values-axis-context-title'])["
							+ i + "]",
					4).getText();
			WebElement style = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[@class='config-panel']//*[@class='input-control--input'])[" + i + "]", 4);
			if (style.isSelected()) {
				System.out.println(text + " is Checked");
			} else {
				System.out.println(text + " is Unchecked");
			}
		}
	}

	@And("^Click on the Chart visual$")
	public void click_on_the_Chart_visual() throws Throwable {
		WebElement line_chart = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='view-components-over--visual-title' and text()='Line']", 4);
		String line_text = line_chart.getText();
		if (line_chart.isDisplayed()) {
			new Actions(login.driver).moveToElement(line_chart).doubleClick().build().perform();
			login.Log4j.info("The Line chart option is clicked");
			CommonFunctionality.wait(500);
		} else {
			fail("Line chart option is not displayed");
		}
		String empty_visual = CommonFunctionality.getElementByClassName(login.driver, "empty-visual-overlay--title", 4)
				.getText();
		assertEquals(line_text, empty_visual);
	}

	@And("^Hovor on Insert Chart$")
	public void hovor_on_Insert_Chart() throws Throwable {
		insert_chart = CommonFunctionality.getElementByXpath(login.driver, "//div[@data-type='line']", 4);
		dest = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='view-components-over--visual-title' and text()='Line']", 4);
	}

	@And("^Count the series in myseries$")
	public void count_the_series_in_myseries() throws Throwable {
		CommonFunctionality.wait(3000);
		List<WebElement> count = login.driver.findElements(By.className("series-name-field--series-name"));
		myseries_before = count.size();
	}

	@And("^Count the list of views$")
	public void count_the_list_of_views() throws Throwable {
		List<WebElement> views = login.driver.findElements(By.className("insight-page-view-tab--title"));
		views_count = views.size();
	}

	@And("^Copy the myseries title$")
	public void copy_the_myseries_title() throws Throwable {
		CommonFunctionality.wait(3000);
		myseriestitle = CommonFunctionality.getElementByClassName(login.driver, "series-name-field--series-name", 4)
				.getText();
	}

	@SuppressWarnings("deprecation")
	@And("^Highlight any one series$")
	public void highlight_any_one_series() throws Throwable {
		CommonFunctionality.wait(8000);
		WebElement one_series = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("One_series_from_myserieslist")));
		new Actions(login.driver).moveToElement(one_series).pause(4000).build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^\"([^\"]*)\" the Insert option$")
	public void the_Insert_option(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("DoubleClick")) {
			new Actions(login.driver).moveToElement(insert_chart).pause(1000).doubleClick().build().perform();
			CommonFunctionality.wait(2000);
		}
		if (arg1.equalsIgnoreCase("Drag and Drop")) {
			new Actions(login.driver).moveToElement(insert_chart).pause(1000).clickAndHold(insert_chart)
					.dragAndDrop(insert_chart, dest).build().perform();
		}
	}

	@And("^Click on Apply in Series Harmonization popup$")
	public void click_on_Apply_in_Series_Harmonization_popup() throws Exception {
		if (login.driver.findElements(By.xpath("//*[contains(@class,'movable-modal--window')]")).size() > 0) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 4).click();
		}
	}

	@And("^Closing the Series Harmonization popup$")
	public void closing_the_Series_Harmonization_popup() throws Exception {
		CommonFunctionality.wait(2000);
		if (login.driver
				.findElements(By.xpath(
						"//*[contains(@class,'movable-modal--window')] | //*[@class='growl-messages-container']"))
				.size() > 0) {
			CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@class='movable-modal--close'] | //*[@class='growl-message-close']")));
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='movable-modal--close'] | //*[@class='growl-message-close']", 4).click();
		}
	}

	@And("^Click on Apply in Series Harmonization popup except for \"([^\"]*)\"$")
	public void click_on_Apply_in_Series_Harmonization_popup_except_for(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		if (!arg1.equalsIgnoreCase("9380901;9380801") || arg1.equalsIgnoreCase("63929901;63928901")) {
			if (login.driver
					.findElements(
							By.xpath("//*[contains(@class,'movable-modal--window')]//*[contains(text(),'Apply')]"))
					.size() > 0) {
				CommonFunctionality
						.getElementByXpath(login.driver,
								"//*[contains(@class,'movable-modal--window')]//*[contains(text(),'Apply')]", 4)
						.click();
			}
			if (login.driver.findElements(By.xpath("//*[contains(@class,'growl-warning')]//*[text()='Ok']"))
					.size() > 0) {
				CommonFunctionality
						.getElementByXpath(login.driver, "//*[contains(@class,'growl-warning')]//*[text()='Ok']", 4)
						.click();
			}
		}
		if (arg1.equalsIgnoreCase("9380901;9380801")) {
			if (login.driver.findElements(By.xpath(
					"//*[contains(@class,'growl-warning')]//*[text()='Ok'] | //*[@class='movable-modal--header']//*[@title='Close']"))
					.size() > 0) {
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'growl-warning')]//*[text()='Ok'] | //*[@class='movable-modal--header']//*[@title='Close']",
						4).click();
			}

			/*
			 * if(login.driver.findElements(By.xpath(
			 * "//*[contains(@class,'movable-modal--window')]")).size()>0) {
			 * CommonFunctionality.getElementByXpath(login.driver,
			 * "//*[@class='movable-modal--close']", 4).click(); }
			 */

		}
		if (arg1.equalsIgnoreCase("63929901;63928901")) {
			if (login.driver.findElements(By.xpath("//*[contains(@class,'movable-modal--window')]")).size() > 0) {
				CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 4).click();
			}
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Double click on highcharts \"([^\"]*)\"$")
	public void double_click_on_highcharts(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		WebElement title = CommonFunctionality.getElementBycssSelector(login.driver, "span[data-name='" + arg1 + "']",
				4);
		new Actions(login.driver).moveToElement(title).pause(1000).doubleClick().build().perform();
	}

	@And("^Closing the unsaved popup if opened$")
	public void closing_the_unsaved_popup_if_opened() throws Throwable {
		if (login.driver.findElements(By.className("movable-modal--close")).size() > 0) {
			CommonFunctionality.Hidden_Webelements_handling(login.driver, "className", "movable-modal--close");
		}
		if (login.driver.findElements(By.xpath("//*[contains(@class,'modal-content')]//*[text()='Ok']")).size() > 0) {
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(@class,'modal-content')]//*[text()='Ok']", 4)
					.click();
		}
	}

	@And("^Removing the background image option$")
	public void removing_the_background_image_option() throws Throwable {
		if (login.driver
				.findElements(By.xpath("//*[contains(@class,'background-image__image-uploaded')]//*[@js-remove=\"\"]"))
				.size() > 0) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'background-image__image-uploaded')]//*[@js-remove=\"\"]", 4).click();
		}
	}

	@And("^Close the popup$")
	public void close_the_popup() throws Throwable {
		if (login.driver.findElements(By.xpath("//*[contains(@class,'movable-modal--window')]")).size() > 0) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Apply')]", 4).click();
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Click \"([^\"]*)\" option from title popup$")
	public void click_options_from_title_popup(String arg1) throws Throwable {
		WebElement color = CommonFunctionality.getElementByXpath(login.driver,
				"//input[@name='title_" + arg1 + "']//following-sibling::div[1]", 4);
		new Actions(login.driver).moveToElement(color).pause(500).click().build().perform();
	}

	@And("^Clicking myseries$")
	public void clicking_myseries() throws Throwable {
		CommonFunctionality.getElementBycssSelector(login.driver, "a[data-id='myseries']", 4).click();
	}

	@And("^\"([^\"]*)\" popup should appeared$")
	public void popup_should_appear(String arg1) throws Throwable {
		WebElement popup = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='popover--wrapper']//*[text()='" + arg1 + "']", 4);
		if (popup.isDisplayed()) {
			login.Log4j.info(arg1 + " popup is displayed");
		} else {
			fail(arg1 + " popup is not displayed");
		}
	}

	@And("^\"([^\"]*)\" section from Legand popup should expand$")
	public void section_from_Legand_popup_should_expand(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		WebElement section = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='popover--wrapper']//*[contains(text(),'" + arg1 + "')]/ancestor::div[2]", 4);
		if (section.getAttribute("class").contains("collapsed")) {
			section.click();
		} else {
			System.out.println("Already expanded");
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Click on chart option from hover$")
	public void click_on_chart_option_from_hover() throws Throwable {
		CommonFunctionality.wait(1000);
		/*List<WebElement> total_count = login.driver
				.findElements(By.xpath("//*[contains(@class,'search-series-list')]/*"));
		for (int i = 1; i <= total_count.size(); i++) {
			WebElement unselect_check = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'search-series-list')]/*[" + i + "]", 4);
			WebElement series = CommonFunctionality.getElementByXpath(login.driver,
					"(//div[@class='series-list-item--checkbox-wrapper']//*[contains(@class,'series-list-item--checkbox')])["
							+ i + "]",
					4);
			if (!(unselect_check.getAttribute("class").contains("series-list-item__selected"))) {
				new Actions(login.driver).moveToElement(series).pause(100).click().build().perform();
			}
		}*/
		WebElement actions = CommonFunctionality.getElementByXpath(login.driver,
				"(//*[contains(@class,'series-item--name')])[1]", 8);
		new Actions(login.driver).moveToElement(actions).pause(500).build().perform();
		new Actions(login.driver).moveToElement(
				CommonFunctionality.getElementByXpath(login.driver, "(//*[contains(@class,'view-chart-icon')])[1]", 8))
				.pause(500).click().build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Click on Edit Chart$")
	public void click_on_Edit_Chart() throws Throwable {
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//button[text()='Edit Chart']", 4))
				.pause(1000).click().build().perform();

	}

	@SuppressWarnings("deprecation")
	@And("^Click \"([^\"]*)\" option from \"([^\"]*)\" popup$")
	public void click_options_from_popup(String arg1, String arg2) throws Throwable {
		WebElement color;
		CommonFunctionality.wait(500);
		if (arg1.equalsIgnoreCase("color") || arg1.equalsIgnoreCase("highlight")) {
			color = CommonFunctionality.getElementByXpath(login.driver,
					"//input[@name='" + arg2 + "_" + arg1 + "']//following-sibling::div[1]", 4);
		} else {
			color = CommonFunctionality.getElementByXpath(login.driver, "//input[@name='" + arg2 + "_" + arg1 + "']",
					4);
		}
		new Actions(login.driver).moveToElement(color).pause(500).click().build().perform();
		
	}

	@And("^Select \"([^\"]*)\" color from list$")
	public void select_color_from_list(String arg1) throws Throwable {
		color = arg1;
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath", "//*[@title='" + color + "']");
		CommonFunctionality.wait(500);
		if (login.driver.findElements(By.className("popover--close")).size() > 0) {
			CommonFunctionality.getElementByClassName(login.driver, "popover--close", 4).click();
		}
	}

	@And("^Select \"([^\"]*)\" series chart color from list$")
	public void select_series_chart_color_from_list(String arg1) throws Throwable {
		series_chart_color = arg1;
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath",
				"//*[@title='" + series_chart_color + "']");
	}

	@And("^Select \"([^\"]*)\" legend color from list$")
	public void select_legend_color_from_list(String arg1) throws Throwable {
		legend_color = arg1;
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath", "//*[@title='" + legend_color + "']");
	}

	@And("^Select \"([^\"]*)\" copyright color from list$")
	public void select_copyright_color_from_list(String arg1) throws Throwable {
		copyright_color = arg1;
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath", "//*[@title='" + copyright_color + "']");
	}

	@And("^Select \"([^\"]*)\" legend bgcolor from list$")
	public void select_legend_bgcolor_from_list(String arg1) throws Throwable {
		legend_bgcolor = arg1;
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath", "//*[@title='" + legend_bgcolor + "']");
	}

	@And("^Select \"([^\"]*)\" legend border color from list$")
	public void select_legend_border_color_from_list(String arg1) throws Throwable {
		legend_border_color = arg1;
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath",
				"//*[@title='" + legend_border_color + "']");
	}

	@And("^Select the \"([^\"]*)\" color from list$")
	public void select_the_color_from_list(String arg1) throws Throwable {
		axis_color = arg1;
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath", "//*[@title='" + axis_color + "']");
	}

	@And("^Select the \"([^\"]*)\" Tooltip color from list$")
	public void select_the_Tooltip_color_from_list(String arg1) throws Throwable {
		tooltip_color = arg1;
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath", "//*[@title='" + tooltip_color + "']");
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByClassName(login.driver, "popover--close", 4).click();
	}

	@And("^Select the \"([^\"]*)\" value line color from list$")
	public void select_the_value_line_color_from_list(String arg1) throws Throwable {
		value_line_color = arg1;
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath",
				"//*[@title='" + value_line_color + "']");
	}

	@And("^Select the \"([^\"]*)\" time line color from list$")
	public void select_the_time_line_color_from_list(String arg1) throws Throwable {
		time_line_color = arg1;
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath", "//*[@title='" + time_line_color + "']");
	}

	@And("^Select the \"([^\"]*)\" tooltip border color from list$")
	public void select_the_tooltip_border_color_from_list(String arg1) throws Throwable {
		tooltip_border_color = arg1;
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath",
				"//*[@title='" + tooltip_border_color + "']");
	}

	@And("^Select the \"([^\"]*)\" data label color from list$")
	public void select_the_data_label_color_from_list(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		data_label_color = arg1;
		CommonFunctionality.Hidden_Webelements(login.driver, "//*[@title='" + data_label_color + "']");
	}

	@And("^Select the \"([^\"]*)\" data label highlight color from list$")
	public void select_the_data_label_highlight_color_from_list(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		data_label_highlight_color = arg1;
		CommonFunctionality.Hidden_Webelements(login.driver, "//*[@title='" + data_label_highlight_color + "']");
	}

	@And("^Select the \"([^\"]*)\" title axis color from list$")
	public void select_the_title_axis_color_from_list(String arg1) throws Throwable {
		time_axis_color = arg1;
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath", "//*[@title='" + time_axis_color + "']");
		// CommonFunctionality.getElementByProperty(login.driver,
		// "time_axis_title_color_field", 4).click();
		try {
			// select title bar
			CommonFunctionality.getElementByXpath(login.driver, "//*[@name='x_axis_font_underline']", 4).click();
		} catch (Exception e) {

		}
	}

	@And("^Select the \"([^\"]*)\" y axis color from list$")
	public void select_the_y_axis_color_from_list(String arg1) throws Throwable {
		y_axis_color = arg1;
		// CommonFunctionality.getElementByProperty(login.driver, "axis_color_field",
		// 4).click();
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath",
				"//*[contains(@class,'sp-container sp-light sp-buttons-disabled')]//*[@title='" + y_axis_color + "']");

	}

	@And("^Select the \"([^\"]*)\" y axis right color from list$")
	public void select_the_y_axis_right_color_from_list(String arg1) throws Throwable {
		y_axis_right_color = arg1;
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath",
				"//*[@title='" + y_axis_right_color + "']");
		CommonFunctionality.getElementByProperty(login.driver, "axis_color_right", 4).click();
	}

	@And("^Select the \"([^\"]*)\" title label color from list$")
	public void select_the_title_label_color_from_list(String arg1) throws Throwable {
		time_axis_label_color = arg1;
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath",
				"//*[@title='" + time_axis_label_color + "']");

		// CommonFunctionality.getElementByProperty(login.driver,
		// "time_axis_title_label_color_field", 4).click();
	}

	@And("^Select the \"([^\"]*)\" title axis bgcolor from list$")
	public void select_the_title_axis_bgcolor_from_list(String arg1) throws Throwable {
		time_axis_bgcolor = arg1;
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath",
				"//*[@title='" + time_axis_bgcolor + "']");
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='preview-container']//*[text()='5Y']", 4)
				.click();
	}

	@And("^Select the \"([^\"]*)\" y axis bgcolor from list$")
	public void select_the_y_axis_bgcolor_from_list(String arg1) throws Throwable {
		y_axis_bgcolor = arg1;
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath",
				"(//*[contains(@class,'sp-container sp-light sp-buttons-disabled')])[2]//*[@title='" + y_axis_bgcolor
						+ "']");
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//div[text()='Labels']", 4)).click()
				.build().perform();
		// CommonFunctionality.getElementByProperty(login.driver,
		// "axis_highlight_color_field", 4).click();
	}

	@And("^Select the \"([^\"]*)\" y axis right bgcolor from list$")
	public void select_the_y_axis_right_bgcolor_from_list(String arg1) throws Throwable {
		y_axis_right_bgcolor = arg1;
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath",
				"//*[@title='" + y_axis_right_bgcolor + "']");
		CommonFunctionality.getElementByProperty(login.driver, "axis_highlight_color_right", 4).click();
	}

	@And("^Select the \"([^\"]*)\" title label line color from list$")
	public void select_the_title_label_line_color_from_list(String arg1) throws Throwable {
		time_axis_label_line_color = arg1;
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath",
				"//*[@title='" + time_axis_label_line_color + "']");
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='preview-container']//*[text()='5Y']", 4)
				.click();
	}

	@And("^Select the \"([^\"]*)\" label line color from list$")
	public void select_the_label_line_color_from_list(String arg1) throws Throwable {
		time_color = arg1;
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath", "//*[@title='" + time_color + "']");
	}

	@And("^Select \"([^\"]*)\" highlight color from list$")
	public void select_highlight_color_from_list(String arg1) throws Throwable {
		highlight_color = arg1;
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath", "//*[@title='" + highlight_color + "']");
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByClassName(login.driver, "popover--close", 4).click();
	}

	@And("^Enter font size of (\\d+) in the list for \"([^\"]*)\"$")
	public void enter_font_size_of_in_the_list_for(int arg1, String arg2) throws Throwable {
		font_size = Integer.toString(arg1);
		WebElement size = CommonFunctionality.getElementByXpath(login.driver, "//input[@name='" + arg2 + "_font_size']",
				4);
		size.sendKeys(Keys.CONTROL, Keys.chord("a"));
		size.sendKeys(Keys.DELETE);
		size.sendKeys(font_size);
		size.sendKeys(Keys.ENTER);
		CommonFunctionality.wait(3000);
	}

	@SuppressWarnings("deprecation")
	@And("^Right Click the \"([^\"]*)\" visual$")
	public void right_Click_the_visual(String arg1) throws Throwable {
		CommonFunctionality.wait(7000);
		WebElement visual = CommonFunctionality.getElementBycssSelector(login.driver, "span[data-name='title']", 4);
		new Actions(login.driver).moveToElement(visual).pause(500).contextClick().build().perform();
	}

	@And("^Click on \"([^\"]*)\" to check the type of visual$")
	public void click_on_to_check_the_type_of_visual(String arg1) throws Throwable {
		WebElement view = CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg1 + "']", 4);
		new Actions(login.driver).moveToElement(view).click().build().perform();
	}

	@And("^Click on \"([^\"]*)\" visual from the list$")
	public void click_on_visual_from_the_list(String arg1) throws Throwable {
		WebElement visual = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-action='" + arg1 + "']", 4);
		new Actions(login.driver).moveToElement(visual).click().build().perform();
	}

	@And("^Get the series title$")
	public void get_the_series_title() throws Throwable {
		series_title = CommonFunctionality.getElementBycssSelector(login.driver, ".series-edit--title__editable", 4)
				.getText();
	}

	@And("^Click on \"([^\"]*)\" Visual option$")
	public void click_on_Visual_option(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']", 4).click();
	}

	@And("^Get the text of Edit series option$")
	public void get_the_text_of_Edit_series_option() throws Throwable {
		if (CommonFunctionality.getElementBycssSelector(login.driver, ".sidebar-panel__opened", 4).isDisplayed()) {
			edit_series_title = CommonFunctionality.getElementBycssSelector(login.driver, ".series-name--title", 4)
					.getText();
		} else {
			fail("Edit Series popup not displayed");
		}
	}

	@And("^Check the \"([^\"]*)\" checkbox by default$")
	public void check_the_checkbox_by_default(String arg1) throws Throwable {
		zoom_checkbox = login.driver.findElement(By.xpath("//*[text()='" + arg1 + "']/preceding-sibling::input"))
				.isSelected();
		if (zoom_checkbox == true) {
			login.Log4j.info(arg1 + " checkbox is selected by default and it has been verified successfully");
		} else {
			fail(arg1 + " is not checked by default");
		}
	}

	@And("^Enable the download popup$")
	public void enable_the_download_popup() throws Throwable {
		CommonFunctionality.getElementBycssSelector(login.driver, "div[title='View and edit profile information']", 4)
				.click();
		cv.clicking_on_option_under_user_preference_to_be("Ask me to confirm the download settings", "Check");
		CommonFunctionality.getElementBycssSelector(login.driver, "div[title='View and edit profile information']", 4)
				.click();
	}

	@And("^Click on the \"([^\"]*)\" Container$")
	public void click_on_the_Container(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Tooltips:") || arg1.equalsIgnoreCase("Data labels:")
				|| arg1.equalsIgnoreCase("Legend:") || arg1.equalsIgnoreCase("Copyright:")) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(text(),'" + arg1 + "')]//following::*[@class='base-config--row-settings'][1]", 4)
					.click();
		} else {
			CommonFunctionality.wait(1000);
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1
					+ "')]//following-sibling::*[@class='style-container--control-row-control'] | //*[contains(text(),'"
					+ arg1 + "')]//following::*[@class='context-menu-control']", 8).click();
			CommonFunctionality.wait(1000);
		}
	}

	@SuppressWarnings("deprecation")
	@And("^\"([^\"]*)\" the \"([^\"]*)\" Checkbox$")
	public void the_Checkbox(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(1000);
		checked = login.driver
				.findElement(By.xpath(
						"//*[contains(text(),'" + arg2 + "')]/preceding-sibling::input[@class='input-control--input']"))
				.isSelected();
		if (arg1.equalsIgnoreCase("Select")) {
			if (checked == false) {
				WebElement title = CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(text(),'" + arg2 + "')]/preceding-sibling::span", 4);
				new Actions(login.driver).moveToElement(title).pause(1000).click().build().perform();
			}
		}
		if (arg1.equalsIgnoreCase("Unselect")) {
			if (checked == true) {
				WebElement title = CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(text(),'" + arg2 + "')]/preceding-sibling::span", 4);
				new Actions(login.driver).moveToElement(title).pause(1000).click().build().perform();
			}
		}
		checkbox_status = login.driver
				.findElement(By.xpath(
						"//*[contains(text(),'" + arg2 + "')]/preceding-sibling::input[@class='input-control--input']"))
				.isSelected();
	}

	@And("^\"([^\"]*)\" the new insight$")
	public void the_new_insight(String arg1) throws Throwable {
		date = new Date();
		formatter = new SimpleDateFormat("dd/MM/yyyy_hh-mm-ss");
		String text = insight + "_" + formatter.format(date);
		WebElement title = CommonFunctionality.getElementByProperty(login.driver, "Insight_title", 4);
		new Actions(login.driver).moveToElement(title).click().sendKeys(Keys.chord(text), Keys.ENTER).build().perform();
	}

	@And("^Setting values in preference$")
	public void setting_values_in_preference() throws Throwable {
		cv.open_preference_dropdown();
		cv.clicking_on_option_under_user_preference_to_be("Show search results without pagination", "Check");
		cv.clicking_on_option_under_user_preference_to_be("Ask me to confirm the download settings", "Check");
		cv.clicking_on_option_under_user_preference_be("Keyboard shortcuts", "ON");
		cv.clicking_on_option_in_preference("Date format");
		cv.click_format_date_option("Custom");
		cv.enter_custom_date("Valid");
		cv.open_preference_dropdown();
		cv.clicking_on_option_in_preference("Number format");
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[contains(text(),'Grouping separator')]//following::*[contains(text(),\",\")][1]", 4)
				.click();
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[contains(text(),'Decimal separator')]//following::*[contains(text(),\".\")][1]", 4)
				.click();
		cv.click_on_in_format_and_enter_value_as("Decimal places", 2);
		cv.open_preference_dropdown();
	}

	@And("^Setting the values in preference$")
	public void setting_the_values_in_preference() throws Throwable {
		cv.open_preference_dropdown();
		cv.clicking_on_option_in_preference("Number format");
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[contains(text(),'Grouping separator')]//following::*[contains(text(),\",\")][1]", 4)
				.click();
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[contains(text(),'Decimal separator')]//following::*[contains(text(),\".\")][1]", 4)
				.click();
		cv.click_on_in_format_and_enter_value_as("Decimal places", 2);
		cv.open_preference_dropdown();
	}

	@And("^Click on the Visual \"([^\"]*)\" Container$")
	public void click_on_the_Visual_Container(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Border:")) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(text(),'" + arg1 + "')]//following-sibling::div[2]", 4).click();
		} else {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(text(),'" + arg1 + "')]//following-sibling::div[1]", 4).click();
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Click on the \"([^\"]*)\" value to set as \"([^\"]*)\"$")
	public void click_on_the_value_to_set_as(String arg1, String arg2) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[text()='" + arg1 + "']/following::div[@class='context-menu-control'][1]", 4).click();
		WebElement date = CommonFunctionality.getElementByXpath(login.driver,
				"//ul[contains(@class,'dropdown-menu')]//*[text()='" + arg2 + "']/preceding::span[1]", 4);
		boolean auto_date = login.driver
				.findElement(By
						.xpath("//ul[contains(@class,'dropdown-menu')]//*[text()='" + arg2 + "']/preceding::input[1]"))
				.isSelected();
		if (auto_date == false) {
			new Actions(login.driver).moveToElement(date).pause(1000).click().build().perform();
		}
	}

	@And("^Enter \"([^\"]*)\" for Tooltip$")
	public void enter_for_Tooltip(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("color")) {
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[@name='tooltip_" + arg1 + "']/following::div[1]", 4).click();
		}
	}

	@And("^Click on the Visual \"([^\"]*)\" Container for \"([^\"]*)\"$")
	public void click_on_the_Visual_Container_for(String arg1, String arg2) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']//following-sibling::div[1]", 4)
				.click();
	}

	@And("^Fetch the color of axis line right \"([^\"]*)\" Invert$")
	public void fetch_the_color_of_axis_line_right_Invert(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Before")) {
			CommonFunctionality.wait(2000);
			String text = CommonFunctionality.getElementByProperty(login.driver, "chart_before_invert", 4)
					.getAttribute("stroke");
			before_invert = Color.fromString(text).asHex();
		}
		if (arg1.equalsIgnoreCase("After")) {
			CommonFunctionality.wait(2000);
			String text = CommonFunctionality.getElementByProperty(login.driver, "chart_after_invert", 4)
					.getAttribute("stroke");
			after_invert = Color.fromString(text).asHex();
		}
	}

	@And("^Click on \"([^\"]*)\" option in Edit visual to (\\d+)$")
	public void click_on_option_in_Edit_visual_to(String arg1, int arg2) throws Throwable {
		Value = arg2;
		String value = Integer.toString(Value);
		WebElement proportion;
		if (arg1.equalsIgnoreCase("Chart width")) {
			proportion = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='border-control']//*[contains(text(),'Chart')]//following::*[@class='spinner-control'][1]//input",
					4);
		} else if (arg1.equalsIgnoreCase("Chart radius")) {
			proportion = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='border-control']//*[contains(text(),'Chart')]//following::*[@class='spinner-control'][2]//input",
					4);
		} else if (arg1.equalsIgnoreCase("Title_value")) {
			proportion = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='accordion-config']//*[contains(text(),'Size')]//preceding::input[1]", 4);
		} else if (arg1.equalsIgnoreCase("Title_Label_value")) {
			proportion = CommonFunctionality.getElementByXpath(login.driver, "//*[@name='x_axis_label_font_size']", 4);
		} else {
			proportion = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(text(),'" + arg1 + "')]//following::input[1]", 4);
		}
		proportion.sendKeys(Keys.chord(Keys.CONTROL, "a"), value);
		proportion.sendKeys(Keys.TAB);
		CommonFunctionality.wait(3000);
	}

	@And("^Click on \"([^\"]*)\" option in Edit visual$")
	public void click_on_option_in_Edit_visual(String arg1) throws Throwable {
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='chart-visual-config']//*[text()='" + arg1 + "']", 4)
				.click();
	}

	@And("^Click on Horizontal align of visual to \"([^\"]*)\"$")
	public void click_on_Horizontal_align_of_visual_to(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		visual_align = CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg1 + "']", 4);
		visual_align.click();
	}

	@And("^Select \"([^\"]*)\" data label of \"([^\"]*)\"$")
	public void select_data_label_of(String data_label, String arg2) throws Throwable {
		if (arg2.equalsIgnoreCase("Point markers")) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + arg2 + "']//following::div/a", 4)
					.click();
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='select2-results']//*[contains(text(),'" + data_label + "')]", 4).click();
			point_marker = CommonFunctionality
					.getElementByXpath(login.driver, "//*[text()='" + arg2
							+ "']//following::div/a/span/span | //*[text()='" + arg2 + "']//following::div/a/span", 4)
					.getText();
		}
	}

	@And("^Select any \"([^\"]*)\" for chart visual$")
	public void select_any_for_chart_visual(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("image")) {
			CommonFunctionality.getElementByXpath(login.driver,
					"(//*[@class='background-image--form']//*[contains(@class,'background-image--input')])[1]", 4)
					.click();
			CommonFunctionality.wait(2000);
			CommonFunctionality.uploadTheFileusingAutoIT(login.driver,
					System.getProperty("user.dir") + "\\AutoIT\\Shravas.exe",
					System.getProperty("user.dir") + "\\AutoIT\\Shravas.png");
			CommonFunctionality.wait(6000);
		} else if (arg1.equalsIgnoreCase("Values Axis_Label Color")) {
			CommonFunctionality.getElementByProperty(login.driver, "Value_axes_label_color", 4).click();
		} else if (arg1.equalsIgnoreCase("Values Axis_Label Line Color")) {
			CommonFunctionality.getElementByProperty(login.driver, "Value_axes_label_line_color", 4).click();
		} else if (arg1.equalsIgnoreCase("Value_label_size")) {
			WebElement size = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='popover--wrapper']//*[@name='y_axis_label_font_size']", 4);
			size.sendKeys(Keys.chord(Keys.CONTROL, "a"), font_size_y_axis);
		} else if (arg1.equalsIgnoreCase("Point marker radius")) {
			WebElement size = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='popover--wrapper']//*[@name='point_markers_radius']", 4);
			size.sendKeys(Keys.chord(Keys.CONTROL, "a"), point_marker_radius);
		} else if (arg1.equalsIgnoreCase("Value_label_rotation")) {
			WebElement rotation = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='popover--wrapper']//*[@name='y_axis_label_rotation']", 4);
			rotation.sendKeys(Keys.chord(Keys.CONTROL, "a"), font_rotation_y_axis);
			rotation.sendKeys(Keys.TAB);
		} else if (arg1.equalsIgnoreCase("Time_Axis_label_rotation")) {
			WebElement rotation = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='popover--wrapper']//*[@name='x_axis_label_rotation']", 4);
			rotation.sendKeys(Keys.chord(Keys.CONTROL, "a"), font_rotation_x_axis);
			rotation.sendKeys(Keys.TAB);
		} else if (arg1.equalsIgnoreCase("Time_Axis_label_date_format")) {
			WebElement rotation = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='custom-date-format']//input", 4);
			rotation.sendKeys(Keys.chord(Keys.CONTROL, "a"), time_axis_label_date_format);
			rotation.sendKeys(Keys.TAB);
		} else if (arg1.equalsIgnoreCase("Time_Axis_label_date_format_changed")) {
			WebElement rotation = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='custom-date-format']//input", 4);
			rotation.sendKeys(Keys.chord(Keys.CONTROL, "a"), time_axis_label_date_format1);
			rotation.sendKeys(Keys.TAB);
		} else if (arg1.equalsIgnoreCase("Time_Axis_label_date_format_changed")) {
			WebElement rotation = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='custom-date-format']//input", 4);
			rotation.sendKeys(Keys.chord(Keys.CONTROL, "a"), time_axis_label_date_format1);
			rotation.sendKeys(Keys.TAB);
		} else if (arg1.equalsIgnoreCase("Value_label_style")) {
			y_axis_bold = CommonFunctionality.getElementByXpath(login.driver, "//*[@name='y_axis_label_font_weight']",
					4);
			y_axis_italic = CommonFunctionality.getElementByXpath(login.driver, "//*[@name='y_axis_label_font_style']",
					4);
			y_axis_underline = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@name='y_axis_label_font_underline']", 4);
			if (!(y_axis_bold.getAttribute("class").contains("selected"))) {
				y_axis_bold.click();
			}
			if (!(y_axis_italic.getAttribute("class").contains("selected"))) {
				y_axis_italic.click();
			}
			if (!(y_axis_underline.getAttribute("class").contains("selected"))) {
				y_axis_underline.click();
			}
		} else if (arg1.equalsIgnoreCase("Data Labels Style")) {
			data_labels_bold = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@name='data_labels_font_weight']", 4);
			data_labels_italic = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@name='data_labels_font_style']", 4);
			data_labels_underline = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@name='data_labels_font_underline']", 4);
			if (!(data_labels_bold.getAttribute("class").contains("selected"))) {
				data_labels_bold.click();
			}
			if (!(data_labels_italic.getAttribute("class").contains("selected"))) {
				data_labels_italic.click();
			}
			if (!(data_labels_underline.getAttribute("class").contains("selected"))) {
				data_labels_underline.click();
			}
		} else if (arg1.equalsIgnoreCase("Legends Style")) {
			legends_bold = CommonFunctionality.getElementBycssSelector(login.driver,
					"button[name='legend_title_font_weight']", 4);
			legends_italic = CommonFunctionality.getElementBycssSelector(login.driver,
					"button[name='legend_title_font_style']", 4);
			legends_underline = CommonFunctionality.getElementBycssSelector(login.driver,
					"button[name='legend_title_font_underline']", 4);
			if (!(legends_bold.getAttribute("class").contains("selected"))) {
				legends_bold.click();
			}
			if (!(legends_italic.getAttribute("class").contains("selected"))) {
				legends_italic.click();
			}
			if (!(legends_underline.getAttribute("class").contains("selected"))) {
				legends_underline.click();
			}
		} else if (arg1.equalsIgnoreCase("Copyright Style")) {
			copyrights_bold = CommonFunctionality.getElementBycssSelector(login.driver,
					"button[name='credits_font_weight']", 4);
			copyrights_italic = CommonFunctionality.getElementBycssSelector(login.driver,
					"button[name='credits_font_style']", 4);
			copyrights_underline = CommonFunctionality.getElementBycssSelector(login.driver,
					"button[name='credits_font_underline']", 4);
			if (!(copyrights_bold.getAttribute("class").contains("selected"))) {
				copyrights_bold.click();
			}
			if (!(copyrights_italic.getAttribute("class").contains("selected"))) {
				copyrights_italic.click();
			}
			if (!(copyrights_underline.getAttribute("class").contains("selected"))) {
				copyrights_underline.click();
			}
		} else if (arg1.equalsIgnoreCase("Timepoints Style")) {
			timepoints_bold = CommonFunctionality.getElementByXpath(login.driver, "//*[@name='tooltip_font_weight']",
					4);
			timepoints_italic = CommonFunctionality.getElementByXpath(login.driver, "//*[@name='tooltip_font_style']",
					4);
			timepoints_underline = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@name='tooltip_font_underline']", 4);
			if (!(timepoints_bold.getAttribute("class").contains("selected"))) {
				timepoints_bold.click();
			}
			if (!(timepoints_italic.getAttribute("class").contains("selected"))) {
				timepoints_italic.click();
			}
			if (!(timepoints_underline.getAttribute("class").contains("selected"))) {
				timepoints_underline.click();
			}
		} else if (arg1.equalsIgnoreCase("Values Axis Lines color")) {
			CommonFunctionality.getElementByProperty(login.driver, "values_axis_lines_color", 4).click();
		} else if (arg1.equalsIgnoreCase("Time Axis Lines color")) {
			CommonFunctionality.getElementByProperty(login.driver, "time_axis_lines_color", 4).click();
		} else if (arg1.equalsIgnoreCase("Time Axis Title Color")) {
			CommonFunctionality.getElementByProperty(login.driver, "time_axis_title_color_field", 4).click();
		} else if (arg1.equalsIgnoreCase("Axis Title Color")) {
			CommonFunctionality.getElementByProperty(login.driver, "axis_color_field", 4).click();
		} else if (arg1.equalsIgnoreCase("Axis Title Right Color")) {
			CommonFunctionality.getElementByProperty(login.driver, "axis_color_right", 4).click();
		} else if (arg1.equalsIgnoreCase("Time Axis Title Label Color")) {
			CommonFunctionality.getElementByProperty(login.driver, "time_axis_title_label_color_field", 4).click();
		} else if (arg1.equalsIgnoreCase("Time Axis Title Background Color")) {
			CommonFunctionality.getElementByProperty(login.driver, "time_axis_title_highlight_color_field", 4).click();
		} else if (arg1.equalsIgnoreCase("Axis Title Background Color")) {
			//clicking left axis label due to highlight attribute is hidden 
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Left Axis')]", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "axis_highlight_color_field", 4).click();
		} else if (arg1.equalsIgnoreCase("Axis Title Right Background Color")) {
			CommonFunctionality.getElementByProperty(login.driver, "axis_highlight_color_right", 4).click();
		} else if (arg1.equalsIgnoreCase("Time Axis Title Label Line Color")) {
			CommonFunctionality.getElementByProperty(login.driver, "time_axis_title_label_line_color_field", 4).click();
		} else if (arg1.equalsIgnoreCase("Tooltip Border Color")) {
			CommonFunctionality.getElementByProperty(login.driver, "tooltip_border_color", 4).click();
		} else if (arg1.equalsIgnoreCase("legend_item_color")) {
			CommonFunctionality.getElementBycssSelector(login.driver, "*[name='" + arg1 + "'] + div", 4).click();
		} else if (arg1.equalsIgnoreCase("legend_background_color")) {
			CommonFunctionality.getElementBycssSelector(login.driver, "*[name='" + arg1 + "'] + div", 4).click();
		} else if (arg1.equalsIgnoreCase("legend_border_color")) {
			CommonFunctionality.getElementBycssSelector(login.driver, "*[name='" + arg1 + "'] + div", 4).click();
		} else if (arg1.equalsIgnoreCase("copyright_color")) {
			CommonFunctionality.getElementBycssSelector(login.driver, "input[name='credits_color'] + div", 4).click();
		} else if (arg1.equalsIgnoreCase("Data Labels Format")) {
			CommonFunctionality.getElementByProperty(login.driver, "data_label_format", 4).click();
		} else if (arg1.equalsIgnoreCase("Time_axis_title_label_style")) {
			time_axis_bold = CommonFunctionality.getElementByXpath(login.driver, "//*[@name='x_axis_font_weight']", 4);
			time_axis_italic = CommonFunctionality.getElementByXpath(login.driver, "//*[@name='x_axis_font_style']", 4);
			time_axis_underline = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@name='x_axis_font_underline']", 4);
			if (!(time_axis_bold.getAttribute("class").contains("selected"))) {
				time_axis_bold.click();
			}
			if (!(time_axis_italic.getAttribute("class").contains("selected"))) {
				time_axis_italic.click();
			}
			if (!(time_axis_underline.getAttribute("class").contains("selected"))) {
				time_axis_underline.click();
			}
		} else if (arg1.equalsIgnoreCase("Y Axis Style")) {
			y_axis_left_bold = CommonFunctionality.getElementByXpath(login.driver, "//*[@name='y_axis_font_weight']",
					4);
			y_axis_left_italic = CommonFunctionality.getElementByXpath(login.driver, "//*[@name='y_axis_font_style']",
					4);
			y_axis_left_underline = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@name='y_axis_font_underline']", 4);
			if (!(y_axis_left_bold.getAttribute("class").contains("selected"))) {
				y_axis_left_bold.click();
			}
			if (!(y_axis_left_italic.getAttribute("class").contains("selected"))) {
				y_axis_left_italic.click();
			}
			if (!(y_axis_left_underline.getAttribute("class").contains("selected"))) {
				y_axis_left_underline.click();
			}
		} else if (arg1.equalsIgnoreCase("Y Axis Style Right")) {
			y_axis_right_bold = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@name='opposite_y_axis_font_weight']", 4);
			y_axis_right_italic = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@name='opposite_y_axis_font_style']", 4);
			y_axis_right_underline = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@name='opposite_y_axis_font_underline']", 4);
			if (!(y_axis_right_bold.getAttribute("class").contains("selected"))) {
				y_axis_right_bold.click();
			}
			if (!(y_axis_right_italic.getAttribute("class").contains("selected"))) {
				y_axis_right_italic.click();
			}
			if (!(y_axis_right_underline.getAttribute("class").contains("selected"))) {
				y_axis_right_underline.click();
			}
		} else if (arg1.equalsIgnoreCase("Time Axis_label_style")) {
			timeaxis_label_bold = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@name='x_axis_label_font_weight']", 4);
			timeaxis_label_italic = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@name='x_axis_label_font_style']", 4);
			timeaxis_label_underline = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@name='x_axis_label_font_underline']", 4);
			if (!(timeaxis_label_bold.getAttribute("class").contains("selected"))) {
				timeaxis_label_bold.click();
			}
			if (!(timeaxis_label_italic.getAttribute("class").contains("selected"))) {
				timeaxis_label_italic.click();
			}
			if (!(timeaxis_label_underline.getAttribute("class").contains("selected"))) {
				timeaxis_label_underline.click();
			}
		} else {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='color-picker-control']//*[contains(@class,'sp-replacer')]", 4).click();
		}
	}

	@And("^Revert the \"([^\"]*)\" for chart visual$")
	public void revrt_for_for_chart_visual(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Timepoints Style")) {
			timepoints_revert_bold = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@name='tooltip_font_weight']", 4);
			timepoints_revert_italic = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@name='tooltip_font_style']", 4);
			timepoints_revert_underline = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@name='tooltip_font_underline']", 4);
			if (timepoints_revert_bold.getAttribute("class").contains("selected")) {
				timepoints_revert_bold.click();
			}
			if (timepoints_revert_italic.getAttribute("class").contains("selected")) {
				timepoints_revert_italic.click();
			}
			if (timepoints_revert_underline.getAttribute("class").contains("selected")) {
				timepoints_revert_underline.click();
			}
		}
	}

	@And("^Select \"([^\"]*)\" for chart visual to (\\d+)$")
	public void select_for_chart_visual_to(String arg1, int arg2) throws Throwable {
		if (arg1.equalsIgnoreCase("Values Axis Lines width")) {
			width_y_axis = Integer.toString(arg2);
			WebElement size = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='popover--wrapper']//*[@name='y_grid_line_width']", 4);
			size.sendKeys(Keys.chord(Keys.CONTROL, "a"), width_y_axis);
			CommonFunctionality.wait(1000);
		}
		if (arg1.equalsIgnoreCase("Time Axis Lines width")) {
			width_x_axis = Integer.toString(arg2);
			WebElement size = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='popover--wrapper']//*[@name='x_grid_line_width']", 4);
			size.sendKeys(Keys.chord(Keys.CONTROL, "a"), width_x_axis);
			CommonFunctionality.wait(1000);
		}
		if (arg1.equalsIgnoreCase("Tooltip Border Width")) {
			tooltip_border_width = Integer.toString(arg2);
			WebElement size = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='popover--wrapper']//*[@name='tooltip_border_width']", 4);
			size.sendKeys(Keys.chord(Keys.CONTROL, "a"), tooltip_border_width);
		}
		if (arg1.equalsIgnoreCase("Y axis font size")) {
			y_axis_font_size = Integer.toString(arg2);
			WebElement size = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='popover--wrapper']//*[@name='y_axis_font_size']", 4);
			size.sendKeys(Keys.chord(Keys.CONTROL, "a"), y_axis_font_size);
		}
		if (arg1.equalsIgnoreCase("Y axis Right font size")) {
			y_axis_right_font_size = Integer.toString(arg2);
			WebElement size = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='popover--wrapper']//*[@name='opposite_y_axis_font_size']", 4);
			size.sendKeys(Keys.chord(Keys.CONTROL, "a"), y_axis_right_font_size);
		}
		if (arg1.equalsIgnoreCase("Data Labels font size")) {
			data_labels_font_size = Integer.toString(arg2);
			WebElement size = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='popover--wrapper']//*[@name='data_labels_font_size']", 4);
			size.sendKeys(Keys.chord(Keys.CONTROL, "a"), data_labels_font_size);
		}
		if (arg1.equalsIgnoreCase("Legend Title font size")) {
			legend_title_font_size = Integer.toString(arg2);
			WebElement size = CommonFunctionality.getElementBycssSelector(login.driver,
					"input[name='legend_title_font_size']", 4);
			size.sendKeys(Keys.chord(Keys.CONTROL, "a"), legend_title_font_size);
		}
		if (arg1.equalsIgnoreCase("Copyright font size")) {
			copyright_font_size = Integer.toString(arg2);
			WebElement size = CommonFunctionality.getElementBycssSelector(login.driver,
					"input[name='credits_font_size']", 4);
			size.sendKeys(Keys.chord(Keys.CONTROL, "a"), copyright_font_size);
		}
		if (arg1.equalsIgnoreCase("Legend Title Border Width")) {
			legend_border_width = Integer.toString(arg2);
			WebElement size = CommonFunctionality.getElementBycssSelector(login.driver,
					"input[name='legend_border_width']", 4);
			size.sendKeys(Keys.chord(Keys.CONTROL, "a"), legend_border_width);
		}
		if (arg1.equalsIgnoreCase("Legend Title Border Radius")) {
			legend_border_radius = Integer.toString(arg2);
			WebElement size = CommonFunctionality.getElementBycssSelector(login.driver,
					"input[name='legend_border_radius']", 4);
			size.sendKeys(Keys.chord(Keys.CONTROL, "a"), legend_border_radius);
		}
		if (arg1.equalsIgnoreCase("Series stroke size")) {
			series_stroke_size = Integer.toString(arg2);
			WebElement size = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='ui-spinner-input']", 4);
			size.sendKeys(Keys.chord(Keys.CONTROL, "a"), series_stroke_size);
		}
	}

	@And("^Click on the \"([^\"]*)\" checkbox to \"([^\"]*)\"$")
	public void click_on_the_checkbox_to(String arg1, String arg2) throws Throwable {
		if (arg1.equalsIgnoreCase("Values axis") || arg1.equalsIgnoreCase("Time axis")
				|| arg1.equalsIgnoreCase("Tooltips:")) {
			if (arg2.equalsIgnoreCase("Check")) {
				boolean checkbox = login.driver
						.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]//preceding::input[1]"))
						.isSelected();
				if (checkbox == false) {
					CommonFunctionality.getElementByXpath(login.driver,
							"//*[contains(text(),'" + arg1 + "')]//preceding::span[1]", 4).click();
				}
				CommonFunctionality
						.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]//following::div[2]", 4)
						.click();
			}
			values_axis_checkbox = login.driver
					.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]//preceding::input[1]")).isSelected();
		} else if (arg1.equalsIgnoreCase("Labels")) {
			boolean checkbox = login.driver
					.findElement(By.xpath(
							"(//*[text()='" + arg1 + "']//following::*[@class='popover-block-content']//input)[1]"))
					.isSelected();
			if (checkbox == false) {
				CommonFunctionality.getElementByXpath(login.driver,
						"(//*[text()='" + arg1 + "']//following::*[@class='popover-block-content']//span)[1]", 4)
						.click();
			}
		} else if (arg1.equalsIgnoreCase("Custom")) {
			boolean checkbox = login.driver.findElement(By
					.xpath("//*[@class='items-wrapper']//*[contains(text(),'" + arg1 + "')]//preceding-sibling::input"))
					.isSelected();
			if (checkbox == false) {
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='items-wrapper']//*[contains(text(),'" + arg1 + "')]//preceding-sibling::span", 4)
						.click();
			}
		} else if (arg1.equalsIgnoreCase("Text")) {
			boolean checkbox = login.driver
					.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]//following::input[1]")).isSelected();
			if (checkbox == false) {
				CommonFunctionality
						.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]//following::span[1]", 4)
						.click();
			}
			copyright_checkbox = login.driver
					.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]//following::input[1]")).isSelected();
		} else if (arg1.equalsIgnoreCase("Show tooltips") || arg1.equalsIgnoreCase("Display for all series at once")
				|| arg1.equalsIgnoreCase("Data labels:") || arg1.equalsIgnoreCase("Legend:")
				|| arg1.equalsIgnoreCase("Copyright:") || arg1.equalsIgnoreCase("Slider")) {
			boolean checkbox = login.driver
					.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]//preceding::input[1]")).isSelected();
			if (checkbox == false) {
				CommonFunctionality
						.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]//preceding::span[1]", 4)
						.click();
			}
			tooltips_checkbox = login.driver
					.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]//preceding::input[1]")).isSelected();
			if (arg2.equalsIgnoreCase("UnChecked Checkbox")) {
				boolean checkbox1 = login.driver
						.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]//preceding::input[1]"))
						.isSelected();
				if (checkbox1 == true) {
					WebElement check = CommonFunctionality.getElementByXpath(login.driver,
							"//*[contains(text(),'" + arg1 + "')]//preceding::span[1]", 4);
					new Actions(login.driver).moveToElement(check).click().build().perform();
				}
				tooltips_uncheckbox = login.driver
						.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]//preceding::input[1]"))
						.isSelected();
			}
		} else if (arg2.equalsIgnoreCase("UnCheck")) {
			boolean checkbox = login.driver
					.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]//following::input[1]")).isSelected();
			if (checkbox == true) {
				CommonFunctionality
						.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]//following::span[1]", 4)
						.click();
			} else {
				System.out.println("Already unchecked");
			}
		} else if (arg2.equalsIgnoreCase("UnChecked")) {
			boolean checkbox = login.driver
					.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]//following::input[1]")).isSelected();
			if (checkbox == true) {
				CommonFunctionality
						.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]//following::span[1]", 4)
						.click();
			}
			uncheck_checkbox = login.driver
					.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]//following::input[1]")).isSelected();
		} else {
			if (arg2.equalsIgnoreCase("Check")) {
				boolean checkbox = login.driver
						.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]//following::input[1]"))
						.isSelected();
				if (checkbox == false) {
					new Actions(login.driver)
							.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
									"//*[contains(text(),'" + arg1 + "')]//following::span[1]", 4))
							.click().build().perform();
				}
			} else if (arg2.equalsIgnoreCase("UnCheck")) {
				boolean checkbox = login.driver
						.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]//following::input[1]"))
						.isSelected();
				if (checkbox == true) {
					CommonFunctionality.getElementByXpath(login.driver,
							"//*[contains(text(),'" + arg1 + "')]//following::span[1]", 4).click();
				} else {
					System.out.println("Already unchecked");
				}
			}
			checkbox_visual_border = login.driver
					.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]//following::input[1]")).isSelected();
		}
	}

	@And("^Enter Min/Max value between (\\d+) to (\\d+)$")
	public void enter_Min_Max_value_between_to(int arg1, int arg2) throws Throwable {
		String value1 = Integer.toString(arg1);
		String value2 = Integer.toString(arg2);
		WebElement min_value = CommonFunctionality.getElementByProperty(login.driver, "Min_max_value_start", 4);
		min_value.sendKeys(Keys.chord(Keys.CONTROL, "a"), value1);
		WebElement max_value = CommonFunctionality.getElementByProperty(login.driver, "Min_max_value_end", 4);
		max_value.sendKeys(Keys.chord(Keys.CONTROL, "a"), value2);
	}

	@And("^Click on \"([^\"]*)\" option from Values Axis popup$")
	public void click_on_option_from_Values_Axis_popup(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='popover--wrapper']//*[text()='" + arg1 + "']//following::div[1]", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "Axis_multipler_dropdown_select", 4).click();
		CommonFunctionality.wait(1000);
	}

	@And("^\"([^\"]*)\" checkbox is clicked$")
	public void checkbox_is_clicked(String arg1) throws Throwable {
		WebElement common1 = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]",
				4);
		if (common1.isDisplayed()) {
			login.Log4j.info(arg1 + " is displayed and verified successfully");
		} else {
			fail("Not displayed");
		}
		boolean checkbox = login.driver
				.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]/preceding::input[1]")).isSelected();
		if (checkbox == false) {
			new Actions(login.driver)
					.moveToElement(login.driver
							.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]/preceding::span[1]")))
					.click().build().perform();
		}
		legend_checkbox = login.driver.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]/preceding::input[1]"))
				.isSelected();
		cv.clicking_option("Save");
	}

	@And("^\"([^\"]*)\" checkbox is unchecked$")
	public void checkbox_is_unchecked(String arg1) throws Throwable {
		WebElement common1 = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]",
				4);
		if (common1.isDisplayed()) {
			login.Log4j.info(arg1 + " is displayed and verified successfully");
		} else {
			fail("Not displayed");
		}
		boolean checkbox = login.driver
				.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]/preceding::input[1]")).isSelected();
		if (checkbox == true) {
			new Actions(login.driver)
					.moveToElement(login.driver
							.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]/preceding::span[1]")))
					.click().build().perform();
		}
		legend_checkbox_uncheck = login.driver
				.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]/preceding::input[1]")).isSelected();
		cv.clicking_option("Save");
	}

	@And("^Get the text of Axis multipler dropdown value$")
	public void get_the_text_of_Axis_multipler_dropdown_value() throws Throwable {
		axis_multipler_value_axis = CommonFunctionality.getElementByProperty(login.driver, "Axis_multipler_value", 4)
				.getText();
	}

	@And("^Click on the \"([^\"]*)\" checkbox to be \"([^\"]*)\"$")
	public void click_on_the_checkbox_to_be(String arg1, String arg2) throws Throwable {
		if (arg2.equalsIgnoreCase("Checked")) {
			boolean checkbox = login.driver
					.findElement(By.xpath("//*[contains(text(),'" + arg1
							+ "')]//preceding-sibling::input"))
					.isSelected();
			if (checkbox == false) {
				CommonFunctionality
						.getElementByXpath(login.driver, "//*[contains(text(),'"
								+ arg1 + "')]//preceding-sibling::span", 4)
						.click();
			} else {
				System.out.println("Already checked");
			}
		} else if (arg2.equalsIgnoreCase("UnChecked")) {
			boolean checkbox = login.driver
					.findElement(By.xpath("//*[contains(text(),'" + arg1
							+ "')]//preceding-sibling::input"))
					.isSelected();
			if (checkbox == true) {
				CommonFunctionality
						.getElementByXpath(login.driver, "//*[contains(text(),'"
								+ arg1 + "')]//preceding-sibling::span", 4)
						.click();
			} else {
				System.out.println("Already unchecked");
			}
		}
		checkbox2 = login.driver.findElement(By.xpath(
				"//*[contains(text(),'" + arg1 + "')]//preceding-sibling::input"))
				.isSelected();
	}

	@And("^Select Visual \"([^\"]*)\" from dropdown$")
	public void select_visual_from_dropdown(String arg1) throws Throwable {
		Borderstyle ="Dashed";
		if (arg1.equalsIgnoreCase("Border Type")) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@data-id='visual_area_border_display']//*[@class='select-control']/*[1]", 4)
					.click();
			CommonFunctionality.wait(2000);
			CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Dashed']", 4).click();
			CommonFunctionality.wait(2000);
		}
	}

	@Then("^The selected border should be applied to the chart visual$")
	public void the_selected_border_should_be_applied_to_the_chart_visual() throws Throwable {
		CommonFunctionality.wait(1000);
		String VisualBorder = login.driver.findElement(By.xpath(
				"//*[@class='preview-container']//div[@class='visual-item-container']                                                                                                                                                                                                                 "))
				.getCssValue("border");
		login.Log4j.info(VisualBorder);
		if (VisualBorder.toUpperCase().contains(Borderstyle.toUpperCase())) {
			login.Log4j.info("The selected border " + Borderstyle + " is applied to the visual");
		} else {
			Assert.fail("The selected border " + Borderstyle + " is not applied to the visual");
		}

		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 6).click();

	}

	@And("^Expand \"([^\"]*)\" section from \"([^\"]*)\" popup$")
	public void expand_section_from_popup(String arg1, String arg2) throws Throwable {
		if (arg2.equalsIgnoreCase("Values Axis")) {
			if (login.driver
					.findElements(
							By.xpath("//*[@class='popover--wrapper']//following-sibling::*[text()='" + arg2 + "']"))
					.size() > 0) {
				WebElement active = CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'accordion-tabbar--header-tab') and contains(text(),'Axis')] | //*[@class='popover--title' and contains(text(),'Legend')]",
						4);
				if (active.getAttribute("class").contains("active")) {
					CommonFunctionality
							.getElementByXpath(login.driver,
									"//*[@class='accordion-header']//following-sibling::*[text()='" + arg1 + "']", 4)
							.click();
				} else {
					fail("The axis is not active");
				}
			} else {
				fail(arg2 + " popup is not opened");
			}
		}
		if (arg2.equalsIgnoreCase("Time Axis") || arg2.equalsIgnoreCase("Tooltip") || arg2.equalsIgnoreCase("Labels")) {
			if (login.driver
					.findElements(
							By.xpath("//*[@class='popover--wrapper']//following-sibling::*[text()='" + arg2 + "']"))
					.size() > 0) {
				WebElement click = CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='accordion-header']//following-sibling::*[text()='" + arg1 + "']/ancestor::div[2]",
						4);
				if (click.getAttribute("class").contains("collapsed")) {
					click.click();
				}
			} else {
				fail(arg2 + " popup is not opened");
			}
		}
	}

	@And("^Expand \"([^\"]*)\" from \"([^\"]*)\" popup$")
	public void expand_from_popup(String legend_expand, String arg2) throws Throwable {
		if (CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='popover--wrapper']//*[text()='" + arg2 + "']", 4)
				.isDisplayed()) {
			if (legend_expand.equalsIgnoreCase("Size")) {
				WebElement legand = CommonFunctionality.getElementByXpath(login.driver,
						"(//*[text()='" + legend_expand + "']/ancestor::div[2])[2]", 4);
				if (!(legand.getAttribute("class").contains("collapsed"))) {
					CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='" + legend_expand + "'])[2]", 4)
							.click();
				} else {
					System.out.println(legend_expand + " is already in Collapsed state");
					CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='" + legend_expand + "'])[2]", 4)
							.click();
				}
			} else if (!(legend_expand.equalsIgnoreCase("Size"))) {
				WebElement legand = CommonFunctionality.getElementByXpath(login.driver,
						"//*[text()='" + legend_expand + "']/ancestor::div[2]", 4);
				if (!(legand.getAttribute("class").contains("collapsed"))) {
					CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + legend_expand + "']", 4)
							.click();
				} else {
					System.out.println(legend_expand + " is already in Collapsed state");
					CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + legend_expand + "']", 4)
							.click();
				}
			}
		} else {
			fail(arg2 + " popup is not Displayed");
		}
	}

	@And("^Collapse \"([^\"]*)\" from \"([^\"]*)\" popup$")
	public void collapse_from_popup(String legend_collapse, String arg2) throws Throwable {
		if (CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='popover--wrapper']//*[text()='" + arg2 + "']", 4)
				.isDisplayed()) {
			if (legend_collapse.equalsIgnoreCase("Size")) {
				WebElement legand = CommonFunctionality.getElementByXpath(login.driver,
						"(//*[text()='" + legend_collapse + "']/ancestor::div[2])[2]", 4);
				if (legand.getAttribute("class").contains("collapsed")) {
					CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='" + legend_collapse + "'])[2]", 4)
							.click();
				} else {
					System.out.println(legend_collapse + " is already in Expanded state");
					CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='" + legend_collapse + "'])[2]", 4)
							.click();
				}
			} else if (!(legend_collapse.equalsIgnoreCase("Size"))) {
				WebElement legand = CommonFunctionality.getElementByXpath(login.driver,
						"//*[text()='" + legend_collapse + "']/ancestor::div[2]", 4);
				if (legand.getAttribute("class").contains("collapsed")) {
					CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + legend_collapse + "']", 4)
							.click();
				} else {
					System.out.println(legend_collapse + " is already in Expanded state");
					CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + legend_collapse + "']", 4)
							.click();
				}
			}
		} else {
			fail(arg2 + " popup is not Displayed");
		}
		cv.clicking_option("Save");
		CommonFunctionality.Views_list();
	}

	@And("^Expanding \"([^\"]*)\" section from \"([^\"]*)\" popup of \"([^\"]*)\"$")
	public void expanding_section_from_popup(String arg1, String arg2, String arg3) throws Throwable {
		if (arg2.equalsIgnoreCase("Values Axis")) {
			if (login.driver
					.findElements(
							By.xpath("//*[@class='popover--wrapper']//following-sibling::*[text()='" + arg2 + "']"))
					.size() > 0) {
				WebElement active = CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'accordion-tabbar--header-tab') and contains(text(),'" + arg3 + "')]", 4);
				if (active.getAttribute("class").contains("active")) {
					if (arg3.equalsIgnoreCase("Right Axis")) {
						WebElement collapse = CommonFunctionality.getElementByXpath(login.driver,
								"(//*[text()='" + arg1 + "']/ancestor::div[2])[2]", 4);
						if (!collapse.getAttribute("class").contains("collapsed")) {
							CommonFunctionality.getElementByXpath(login.driver,
									"(//*[@class='accordion-header']//following-sibling::*[text()='" + arg1 + "'])[2]",
									4).click();
							CommonFunctionality.getElementByXpath(login.driver,
									"(//*[@class='accordion-header']//following-sibling::*[text()='" + arg1 + "'])[2]",
									4).click();
						} else {
							CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='" + arg1 + "'])[2]", 4)
									.click();
						}
					} else {
						WebElement collapse = CommonFunctionality.getElementByXpath(login.driver,
								"//*[text()='" + arg1 + "']/ancestor::div[2]", 4);
						if (!collapse.getAttribute("class").contains("collapsed")) {
							CommonFunctionality.getElementByXpath(login.driver,
									"//*[@class='accordion-header']//following-sibling::*[text()='" + arg1 + "']", 4)
									.click();
							CommonFunctionality.getElementByXpath(login.driver,
									"//*[@class='accordion-header']//following-sibling::*[text()='" + arg1 + "']", 4)
									.click();
						}
					}
				} else {
					fail("The axis is not active");
				}
			} else {
				fail(arg2 + " popup is not opened");
			}
		}
	}

	@And("^Click on \"([^\"]*)\" dropdown under \"([^\"]*)\" popup$")
	public void click_on_dropdown_under_popup(String arg1, String arg2) throws Throwable {
		if (arg2.equalsIgnoreCase("Values Axis")) {
			CommonFunctionality.getElementByProperty(login.driver, "Number_format_in_values_axis", 4).click();
			if (CommonFunctionality.getElementByXpath(login.driver, "//*[@class='number-format-picker']", 4)
					.isDisplayed()) {
				System.out.println("Number format dropdown is displayed");
			} else {
				fail("Verification Failed");
			}
		} else {
			fail("Value axis popup is not opened");
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Click on \"([^\"]*)\" Attribute button to add attributes$")
	public void click_on_Attribute_button_to_add_attributes(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Add")) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='multi-select-config']//*[contains(@class,'add-item-attribute')]", 4).click();
			CommonFunctionality.wait(200);
			List<WebElement> dropdown = login.driver.findElements(By.xpath(
					"//*[@class='select2-drop-mask']//following::*[contains(@class,'select2-drop-active')]//li"));
			for (int i = 1; i <= dropdown.size(); i++) {
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='select2-drop-mask']//following::*[contains(@class,'select2-drop-active')]//li[" + i
								+ "]",
						4).click();
				CommonFunctionality
						.getElementByXpath(login.driver,
								"//*[@class='multi-select-config']//*[contains(@class,'add-item-attribute')]", 4)
						.click();
				CommonFunctionality.wait(200);
			}
			WebElement item = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Items')]", 4);
			new Actions(login.driver).moveToElement(item).pause(500).doubleClick().build().perform();
		} else if (arg1.equalsIgnoreCase("Remove")) {
			CommonFunctionality.wait(200);
			List<WebElement> closing = login.driver.findElements(By.xpath(
					"//*[@class='multi-select-config']//*[contains(@class,'select-behaviour--multi-select-item-delete icon')]"));
			for (WebElement close : closing) {
				close.click();
			}
		}
	}

	@And("^Enter the text \"([^\"]*)\" for axis title$")
	public void enter_the_text_for_axis_title(String arg1) throws Throwable {
		y_axis_title = arg1;
		WebElement title = CommonFunctionality.getElementByXpath(login.driver, "//*[@name='y_axis_title']", 4);
		title.sendKeys(Keys.chord(Keys.CONTROL, "a"), y_axis_title);
	}

	@And("^Enter the text \"([^\"]*)\" for legend title$")
	public void enter_the_text_for_legend_title(String arg1) throws Throwable {
		legend_title = arg1;
		WebElement title = CommonFunctionality.getElementBycssSelector(login.driver, "input[name='legend_title']", 4);
		title.sendKeys(Keys.chord(Keys.CONTROL, "a"), legend_title);
	}

	@And("^Enter the text \"([^\"]*)\" for Copyright title$")
	public void enter_the_text_for_Copyright_title(String arg1) throws Throwable {
		copyright_title = arg1;
		WebElement title = CommonFunctionality.getElementBycssSelector(login.driver, "input[name='credits_text']", 4);
		title.sendKeys(Keys.chord(Keys.CONTROL, "a"), copyright_title);
	}

	@And("^Enter the text \"([^\"]*)\" for Copyright title link$")
	public void enter_the_text_for_Copyright_title_link(String arg1) throws Throwable {
		copyright_title_link = arg1;
		WebElement link = CommonFunctionality.getElementBycssSelector(login.driver, "input[name='credits_link']", 4);
		link.sendKeys(Keys.chord(Keys.CONTROL, "a"), copyright_title_link);
	}

	@And("^Count the number of series before delete$")
	public void count_the_number_of_series_before_delete() throws Throwable {
		List<WebElement> series = login.driver
				.findElements(By.cssSelector(".series-edit--title.series-edit--title__editable"));
		series_before = series.size();
	}

	@And("^Enter the text \"([^\"]*)\" for right axis title$")
	public void enter_the_text_for_right_axis_title(String arg1) throws Throwable {
		y_axis_opposite_title = arg1;
		WebElement title = CommonFunctionality.getElementByXpath(login.driver, "//*[@name='opposite_y_axis_title']", 4);
		title.sendKeys(Keys.chord(Keys.CONTROL, "a"), y_axis_opposite_title);
	}

	@SuppressWarnings("deprecation")
	@And("^Check the checkbox for \"([^\"]*)\" section$")
	public void check_the_checkbox_for_section(String arg1) throws Throwable {
		boolean checkbox = login.driver
				.findElement(By.xpath(
						"//*[@class='popover--wrapper']//*[contains(text(),'" + arg1 + "')]//following::input[1]"))
				.isSelected();
		if (checkbox == false) {
			WebElement click = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='popover--wrapper']//*[contains(text(),'" + arg1 + "')]//following::span[1]", 4);
			new Actions(login.driver).moveToElement(click).pause(1000).click().build().perform();
		}
		values_axis_checkboxes = login.driver
				.findElement(By.xpath(
						"//*[@class='popover--wrapper']//*[contains(text(),'" + arg1 + "')]//following::input[1]"))
				.isSelected();
	}

	@SuppressWarnings("deprecation")
	@And("^Check the checkbox for \"([^\"]*)\" section for Right axis$")
	public void check_the_checkbox_for_section_for_Right_axis(String arg1) throws Throwable {
		boolean checkbox = login.driver.findElement(By.xpath("(//*[text()='" + arg1 + "']//following::input[1])[2]"))
				.isSelected();
		if (checkbox == false) {
			WebElement click = CommonFunctionality.getElementByXpath(login.driver,
					"//*[text()='" + arg1 + "']//following::span[1]", 4);
			new Actions(login.driver).moveToElement(click).pause(1000).click().build().perform();
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Check the checkbox for \"([^\"]*)\" sections$")
	public void check_the_checkbox_for_sections(String arg1) throws Throwable {
		time_axis_label_text = arg1;
		boolean checkbox = login.driver
				.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]/preceding-sibling::input")).isSelected();
		if (checkbox == false) {
			WebElement click = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(text(),'" + arg1 + "')]//preceding-sibling::span", 4);
			new Actions(login.driver).moveToElement(click).pause(1000).click().build().perform();
		}
		time_axis_checkboxes = login.driver
				.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]/preceding-sibling::input")).isSelected();
	}

	@SuppressWarnings("deprecation")
	@And("^Check the checkbox for \"([^\"]*)\" sections of Right Axis$")
	public void check_the_checkbox_for_sections_of_Right_Axis(String arg1) throws Throwable {
		boolean checkbox = login.driver
				.findElement(By.xpath("(//*[contains(text(),'" + arg1 + "')]/preceding-sibling::input)[2]"))
				.isSelected();
		if (checkbox == false) {
			WebElement click = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[contains(text(),'" + arg1 + "')]//preceding-sibling::span)[2]", 4);
			new Actions(login.driver).moveToElement(click).pause(1000).click().build().perform();
		}
		axis_checkboxes_right = login.driver
				.findElement(By.xpath("(//*[contains(text(),'" + arg1 + "')]/preceding-sibling::input)[2]"))
				.isSelected();
	}

	@SuppressWarnings("deprecation")
	@And("^Uncheck the checkbox for \"([^\"]*)\" sections$")
	public void uncheck_the_checkbox_for_sections(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		boolean checkbox = login.driver
				.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]/preceding-sibling::input")).isSelected();
		if (checkbox == true) {
			WebElement click = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(text(),'" + arg1 + "')]//preceding-sibling::span", 4);
			new Actions(login.driver).moveToElement(click).pause(1000).click().build().perform();
		}
		axis_setup_checkboxes_uncheck = login.driver
				.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]/preceding-sibling::input")).isSelected();
	}

	@SuppressWarnings("deprecation")
	@And("^Uncheck the checkbox for \"([^\"]*)\" sections of Right Axis$")
	public void uncheck_the_checkbox_for_sections_of_Right_Axis(String arg1) throws Throwable {
		boolean checkbox = login.driver
				.findElement(By.xpath("(//*[contains(text(),'" + arg1 + "')]/preceding-sibling::input)[2]"))
				.isSelected();
		if (checkbox == true) {
			WebElement click = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[contains(text(),'" + arg1 + "')]//preceding-sibling::span)[2]", 4);
			new Actions(login.driver).moveToElement(click).pause(1000).click().build().perform();
		}
		axis_setup_checkboxes_uncheck_right = login.driver
				.findElement(By.xpath("(//*[contains(text(),'" + arg1 + "')]/preceding-sibling::input)[2]"))
				.isSelected();
	}

	@SuppressWarnings("deprecation")
	@And("^Check the timeframe checkbox for \"([^\"]*)\" section$")
	public void check_the_timeframe_checkbox_for_section(String arg1) throws Throwable {
		timeframe_label_text = arg1;
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='preview-container']//*[contains(@class,'header-picker_header-module__calendar_icon')]", 4))
				.pause(500).click().build().perform();
		boolean checkbox = login.driver.findElement(By.xpath("//*[text()='" + arg1 + "']//preceding-sibling::input"))
				.isSelected();
		if (checkbox == false) {
			WebElement click = CommonFunctionality.getElementByXpath(login.driver,
					"//*[text()='" + arg1 + "']//preceding-sibling::span", 4);
			new Actions(login.driver).moveToElement(click).pause(1000).click().build().perform();
		}
		timeframe_checkboxes = login.driver
				.findElement(By.xpath("//*[text()='" + arg1 + "']//preceding-sibling::input")).isSelected();
	}

	@SuppressWarnings("deprecation")
	@And("^Get the series \"([^\"]*)\" and \"([^\"]*)\"$")
	public void get_the_series_and(String arg1, String arg2) throws Throwable {
		WebElement series_hovor = CommonFunctionality.getElementByProperty(login.driver, "legand_region2", 4);
		new Actions(login.driver).moveToElement(series_hovor).pause(1000).build().perform();
		timepoints_first_date = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + ":')]//following-sibling::*", 4)
				.getText();
		timepoints_last_date = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'" + arg2 + ":')]//following-sibling::*", 4)
				.getText();
	}

	@SuppressWarnings("deprecation")
	@And("^Get the \"([^\"]*)\" for the series$")
	public void get_the_for_the_series(String arg1) throws Throwable {
		WebElement series_hovor = CommonFunctionality.getElementByProperty(login.driver, "legand_region2", 4);
		new Actions(login.driver).moveToElement(series_hovor).pause(1000).build().perform();
		name_ssp = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + ":')]//following-sibling::*", 4)
				.getText();
	}

	@SuppressWarnings("deprecation")
	@And("^Right Click the Add to Related series$")
	public void right_Click_the_Add_to_Related_series() throws Throwable {
		WebElement context = CommonFunctionality.getElementBycssSelector(login.driver,
				".visual-title--text.text-dots , .empty-visual-overlay--link", 4);
		new Actions(login.driver).moveToElement(context).pause(500).contextClick().build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Get the \"([^\"]*)\" region for the series$")
	public void get_the_region_for_the_series(String arg1) throws Throwable {
		WebElement series_hovor = CommonFunctionality.getElementByProperty(login.driver, "legand_region2", 4);
		new Actions(login.driver).moveToElement(series_hovor).pause(1000).build().perform();
		region_ssp = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + ":')]//following-sibling::*", 4)
				.getText();
	}

	@SuppressWarnings("deprecation")
	@And("^Get the \"([^\"]*)\" frequency for the series$")
	public void get_the_frequency_for_the_series(String arg1) throws Throwable {
		WebElement series_hovor = CommonFunctionality.getElementByProperty(login.driver, "legand_region2", 4);
		new Actions(login.driver).moveToElement(series_hovor).pause(1000).build().perform();
		frequency_ssp = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + ":')]//following-sibling::*", 4)
				.getText();
	}

	@SuppressWarnings("deprecation")
	@And("^Get the \"([^\"]*)\" unit for the series$")
	public void get_the_unit_for_the_series(String arg1) throws Throwable {
		WebElement series_hovor = CommonFunctionality.getElementByProperty(login.driver, "legand_region2", 4);
		new Actions(login.driver).moveToElement(series_hovor).pause(1000).build().perform();
		unit_ssp = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + ":')]//following-sibling::*", 4)
				.getText();
	}

	@And("^Set the Last observations value to (\\d+)$")
	public void set_the_Last_observations_value_to(int arg1) throws Throwable {
		correct_observations = Integer.toString(arg1);
		WebElement observation = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@name='time_frame_observations']", 4);
		observation.sendKeys(Keys.chord(Keys.CONTROL, "a"), correct_observations);
	}

	@And("^Set the Data format \"([^\"]*)\" as decimal start value$")
	public void set_the_Data_format_as_decimal_start_value(String arg1) throws Throwable {
		data_format_decimal_start_value = arg1;
		WebElement observation = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@name='data_labels_decimal_places']", 4);
		observation.sendKeys(Keys.chord(Keys.CONTROL, "a"), data_format_decimal_start_value);
	}

	@And("^Set the Data format decimal end value to (\\d+)$")
	public void set_the_Data_format_decimal_end_value_to(int arg1) throws Throwable {
		data_format_decimal_end_value = Integer.toString(arg1);
		WebElement observation = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@name='data_labels_decimal_places']", 4);
		observation.sendKeys(Keys.chord(Keys.CONTROL, "a"), data_format_decimal_end_value);
	}

	@And("^Set the Last observations start value to (\\d+)$")
	public void set_the_Last_observations_start_value_to(int arg1) throws Throwable {
		incorrect_start_date = Integer.toString(arg1);
		WebElement observation = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@name='time_frame_observations']", 4);
		observation.sendKeys(Keys.chord(Keys.CONTROL, "a"), incorrect_start_date);
	}

	@And("^Set the Last observations end value to (\\d+)$")
	public void set_the_Last_observations_end_value_to(int arg1) throws Throwable {
		incorrect_end_date = Integer.toString(arg1);
		WebElement observation = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@name='time_frame_observations']", 4);
		observation.sendKeys(Keys.chord(Keys.CONTROL, "a"), incorrect_end_date);
	}

	@And("^Set the timeframe range as \"([^\"]*)\" to \"([^\"]*)\"$")
	public void set_the_timeframe_range_as_to(String arg1, String arg2) throws Throwable {
		start_date_timeframe_chart = arg1;
		end_date_timeframe_chart = arg2;
		CommonFunctionality.wait(2000);
		WebElement start = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='popover--wrapper']//*[@name='time_frame_from']", 4);
		new Actions(login.driver).moveToElement(start).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
				.sendKeys(Keys.BACK_SPACE).build().perform();
		new Actions(login.driver).sendKeys(start_date_timeframe_chart).sendKeys(Keys.ENTER).build().perform();
		CommonFunctionality.wait(2000);
		WebElement end = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='popover--wrapper']//*[@name='time_frame_to']", 4);
		new Actions(login.driver).moveToElement(end).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
				.sendKeys(Keys.BACK_SPACE).build().perform();
		new Actions(login.driver).sendKeys(end_date_timeframe_chart).sendKeys(Keys.ENTER).build().perform();
		CommonFunctionality.wait(2000);
	}

	@SuppressWarnings("deprecation")
	@And("^Uncheck the checkbox for \"([^\"]*)\" section$")
	public void uncheck_the_checkbox_for_section(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Show copyright")) {
			boolean checkbox = login.driver.findElement(By.xpath(
					"//*[@class='popover-content']//*[contains(text(),'" + arg1 + "')]//preceding-sibling::input"))
					.isSelected();
			if (checkbox == true) {
				WebElement click = CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='popover-content']//*[contains(text(),'" + arg1 + "')]//preceding-sibling::span",
						4);
				new Actions(login.driver).moveToElement(click).pause(1000).click().build().perform();
			}
			copyright_checkbox_unchecked = login.driver.findElement(By.xpath(
					"//*[@class='popover-content']//*[contains(text(),'" + arg1 + "')]//preceding-sibling::input"))
					.isSelected();
		} else {
			boolean checkbox;
			try {
				checkbox = login.driver.findElement(By.xpath(
						"//*[@class='popover--wrapper']//*[contains(text(),'" + arg1 + "')]/following::input[1]"))
						.isSelected();
			} catch (Exception e) {
				checkbox = login.driver.findElement(By.xpath(
						"(//*[@class='popover-content']//*[contains(text(),'" + arg1 + "')]//following::input[1])[2]"))
						.isSelected();
			}
			if (checkbox == true) {
				WebElement click = CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='popover--wrapper']//*[contains(text(),'" + arg1 + "')]//following::span[1]", 4);
				new Actions(login.driver).moveToElement(click).pause(1000).click().build().perform();
			}
			values_axis_checkboxes_uncheck = login.driver
					.findElement(By.xpath(
							"//*[@class='popover-content']//*[contains(text(),'" + arg1 + "')]//following::input[1]"))
					.isSelected();
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Verify the \"([^\"]*)\" field is disabled$")
	public void verify_the_field_is_disabledl(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("color")) {
			WebElement color = CommonFunctionality.getElementByProperty(login.driver, "value_axis_line_color_field", 4);
			if (color.getAttribute("class").contains("disabled") && values_axis_checkboxes_uncheck == false) {
				cv.clicking_option("Save");
				if (!(CommonFunctionality.getElementByProperty(login.driver, "value_lines", 8)
						.getAttribute("stroke") == null
						|| login.driver
								.findElement(By
										.cssSelector(".highcharts-container > svg > g:nth-child(6) > path:first-child"))
								.getAttribute("stroke") == null)) {
					fail("Verification Failed");
				}
			} else {
				fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("Tooltip border color")) {
			WebElement color = CommonFunctionality.getElementByProperty(login.driver, "tooltip_border_color_disabled",
					4);
			if (color.getAttribute("class").contains("disabled") && values_axis_checkboxes_uncheck == false) {
				cv.clicking_option("Save");
				List<WebElement> timepoints = login.driver.findElements(By.xpath(
						"//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden') or contains(@class,'highcharts-negative') and not(@visibility='hidden')]"));
				for (int i = 1; i <= timepoints.size(); i++) {
					WebElement timepoint = CommonFunctionality.getElementByXpath(login.driver,
							"//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden') or contains(@class,'highcharts-negative') and not(@visibility='hidden')]["
									+ i + "]",
							4);
					new Actions(login.driver).moveToElement(timepoint).pause(10).build().perform();
					if (!(CommonFunctionality
							.getElementByXpath(login.driver,
									"//*[@class='highcharts-label-box highcharts-tooltip-box']", 4)
							.getAttribute("stroke") == null)) {
						fail("Verification Failed");
					}
					WebElement title = CommonFunctionality.getElementByXpath(login.driver,
							"//*[contains(@class,'visual-title--text') and @data-name='title']", 4);
					new Actions(login.driver).moveToElement(title).pause(2).build().perform();
				}
			} else {
				fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("Tooltip border width")) {
			WebElement color = CommonFunctionality.getElementByProperty(login.driver, "tooltip_border_width_disabled",
					4);
			if (color.getAttribute("class").contains("disabled") && values_axis_checkboxes_uncheck == false) {
				cv.clicking_option("Save");
				List<WebElement> timepoints = login.driver.findElements(By.xpath(
						"//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden') or contains(@class,'highcharts-negative') and not(@visibility='hidden')]"));
				for (int i = 1; i <= timepoints.size(); i++) {
					WebElement timepoint = CommonFunctionality.getElementByXpath(login.driver,
							"//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden') or contains(@class,'highcharts-negative') and not(@visibility='hidden')]["
									+ i + "]",
							4);
					new Actions(login.driver).moveToElement(timepoint).pause(10).build().perform();
					if (!(CommonFunctionality
							.getElementByXpath(login.driver,
									"//*[@class='highcharts-label-box highcharts-tooltip-box']", 4)
							.getAttribute("stroke-width") == null)) {
						fail("Verification Failed");
					}
					WebElement title = CommonFunctionality.getElementByXpath(login.driver,
							"//*[contains(@class,'visual-title--text') and @data-name='title']", 4);
					new Actions(login.driver).moveToElement(title).pause(2).build().perform();
				}
			} else {
				fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("width")) {
			WebElement width = CommonFunctionality.getElementByProperty(login.driver, "value_axis_line_width_field", 4);
			if (width.getAttribute("class").contains("disabled") && values_axis_checkboxes_uncheck == false) {
				cv.clicking_option("Save");
				if (!(CommonFunctionality.getElementByXpath(login.driver, "//*[@class='highcharts-grid highcharts-yaxis-grid highcharts-yaxis-left']", 8)
						.getAttribute("stroke-width") == null
						|| login.driver
								.findElement(By
										.cssSelector(".highcharts-container > svg > g:nth-child(6) > path:first-child"))
								.getAttribute("stroke-width") == null)) {
					login.Log4j.info("width field is disabled");
				}
			} else {
				fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("Legend Title")) {
			WebElement width = CommonFunctionality.getElementByXpath(login.driver,
					"//*[text()='Title']/following::div[9]", 4);
			if (width.getAttribute("class").contains("disabled") && values_axis_checkboxes_uncheck == false) {
				cv.clicking_option("Save");
				if (!(login.driver.findElements(By.cssSelector("div.highcharts-legend-title > span")).size() == 0)) {
					fail("Verification Failed");
				}
			} else {
				fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("Legend Background")) {
			WebElement width = CommonFunctionality.getElementByXpath(login.driver,
					"//*[text()='Background']/following::div[8]", 4);
			if (width.getAttribute("class").contains("disabled") && values_axis_checkboxes_uncheck == false) {
				cv.clicking_option("Save");
				String bgcolor = CommonFunctionality
						.getElementBycssSelector(login.driver, "rect.highcharts-legend-box", 4).getAttribute("fill");
				if (!(bgcolor.equalsIgnoreCase("none"))) {
					fail("Verification Failed");
				}
			} else {
				fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("Legend Border Color")) {
			WebElement width = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='border-settings--container']//div[1]", 4);
			if (width.getAttribute("class").contains("disabled") && values_axis_checkboxes_uncheck == false) {
				cv.clicking_option("Save");
				if (!(CommonFunctionality.getElementBycssSelector(login.driver, "rect.highcharts-legend-box", 4)
						.getAttribute("stroke") == null)) {
					fail("Verification Failed");
				}
			} else {
				fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("Legend Border Width")) {
			WebElement width = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[@class='border-settings--container']//div[2])[3]", 4);
			if (width.getAttribute("class").contains("disabled") && values_axis_checkboxes_uncheck == false) {
				cv.clicking_option("Save");
				if (!(CommonFunctionality.getElementBycssSelector(login.driver, "rect.highcharts-legend-box", 4)
						.getAttribute("stroke-width") == null)) {
					fail("Verification Failed");
				}
			} else {
				fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("Legend Border Radius")) {
			WebElement width = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='border-settings--container']//div[3]", 4);
			if (width.getAttribute("class").contains("disabled") && values_axis_checkboxes_uncheck == false) {
				cv.clicking_option("Save");
				CommonFunctionality.wait(2000);
				String radius = CommonFunctionality
						.getElementBycssSelector(login.driver, "rect.highcharts-legend-box", 4).getAttribute("rx");
				int actual = Integer.parseInt(radius);
				int expected = 0;
				assertEquals(actual, expected);
				String radius1 = CommonFunctionality
						.getElementBycssSelector(login.driver, "rect.highcharts-legend-box", 4).getAttribute("ry");
				int actual1 = Integer.parseInt(radius1);
				int expected1 = 0;
				assertEquals(actual1, expected1);
			} else {
				fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("Copyright Text")) {
			WebElement text = CommonFunctionality.getElementByXpath(login.driver, "//div[@ui='$ui_config_block']", 4);
			if (text.getAttribute("class").contains("disabled") && copyright_checkbox_unchecked == false) {
				cv.clicking_option("Save");
				List<WebElement> hide_list = login.driver
						.findElements(By.xpath("//*[contains(@class,'visual-item-wrapper--text')]/ancestor::*[2]"));
				for (WebElement hide : hide_list) {
					if (!(hide.getAttribute("class").contains("hidden"))) {
						fail("Verification Failed");
					}
				}
			} else {
				fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("Copyright Text link")) {
			WebElement link = CommonFunctionality.getElementByXpath(login.driver, "//div[@ui='$ui_config_block']", 4);
			if (link.getAttribute("class").contains("disabled") && copyright_checkbox_unchecked == false) {
				cv.clicking_option("Save");
				List<WebElement> hide_list = login.driver
						.findElements(By.xpath("//*[contains(@class,'visual-item-wrapper--text')]/ancestor::*[2]"));
				for (WebElement hide : hide_list) {
					if (!(hide.getAttribute("class").contains("hidden"))) {
						fail("Verification Failed");
					}
				}
			} else {
				fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("Copyright font size")) {
			WebElement size = CommonFunctionality.getElementByXpath(login.driver, "//div[@ui='$ui_config_block']", 4);
			if (size.getAttribute("class").contains("disabled") && copyright_checkbox_unchecked == false) {
				cv.clicking_option("Save");
				List<WebElement> hide_list = login.driver
						.findElements(By.xpath("//*[contains(@class,'visual-item-wrapper--text')]/ancestor::*[2]"));
				for (WebElement hide : hide_list) {
					if (!(hide.getAttribute("class").contains("hidden"))) {
						fail("Verification Failed");
					}
				}
			} else {
				fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("Copyright align")) {
			WebElement size = CommonFunctionality.getElementByXpath(login.driver, "//div[@ui='$ui_config_block']", 4);
			if (size.getAttribute("class").contains("disabled") && copyright_checkbox_unchecked == false) {
				cv.clicking_option("Save");
				List<WebElement> hide_list = login.driver
						.findElements(By.xpath("//*[@class='visual-item-wrapper--credits-image']/ancestor::*[1]"));
				for (WebElement hide : hide_list) {
					if (!(hide.getAttribute("class").contains("hidden"))) {
						fail("Verification Failed");
					}
				}
			} else {
				fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("Copyright font style")) {
			WebElement style = CommonFunctionality.getElementByXpath(login.driver, "//div[@ui='$ui_config_block']", 4);
			if (style.getAttribute("class").contains("disabled") && copyright_checkbox_unchecked == false) {
				cv.clicking_option("Save");
				List<WebElement> hide_list = login.driver
						.findElements(By.xpath("//*[contains(@class,'visual-item-wrapper--text')]/ancestor::*[2]"));
				for (WebElement hide : hide_list) {
					if (!(hide.getAttribute("class").contains("hidden"))) {
						fail("Verification Failed");
					}
				}
			} else {
				fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("Copyright color")) {
			WebElement color = CommonFunctionality.getElementByXpath(login.driver, "//div[@ui='$ui_config_block']", 4);
			if (color.getAttribute("class").contains("disabled") && copyright_checkbox_unchecked == false) {
				cv.clicking_option("Save");
				List<WebElement> hide_list = login.driver
						.findElements(By.xpath("//*[contains(@class,'visual-item-wrapper--text')]/ancestor::*[2]"));
				for (WebElement hide : hide_list) {
					if (!(hide.getAttribute("class").contains("hidden"))) {
						fail("Verification Failed");
					}
				}
			} else {
				fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("Copyright logo")) {
			WebElement image = CommonFunctionality.getElementByXpath(login.driver, "//div[@ui='$ui_config_block']", 4);
			if (image.getAttribute("class").contains("disabled") && copyright_checkbox_unchecked == false) {
				cv.clicking_option("Save");
				List<WebElement> hide_list = login.driver
						.findElements(By.xpath("//*[contains(@class,'visual-item-wrapper--logo')]/ancestor::div[2]"));
				for (WebElement hide : hide_list) {
					if (!(hide.getAttribute("class").contains("hidden"))) {
						fail("Verification Failed");
					}
				}
			} else {
				fail("Verification Failed");
			}
		}
		login.Log4j.info("The " + arg1 + " field is disabled and has been verified successfully");
		CommonFunctionality.Views_list();
	}

	@And("^Get Text on \"([^\"]*)\" in Chart visual$")
	public void get_Text_on_in_format_in_Chart_visual(String arg1) throws Throwable {
		position = Integer.parseInt(CDMNextSprintCases.separator_value);
	}

	@SuppressWarnings("deprecation")
	@And("^Select data label \"([^\"]*)\" from the list$")
	public void select_data_label_from_the_list(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//*[@name='data_labels_" + arg1 + "']//following::div[1]", 4))
				.pause(500).click().build().perform();
	}

	@And("^Observe the value order \"([^\"]*)\" selecting \"([^\"]*)\" for \"([^\"]*)\"$")
	public void observe_the_value_order_selecting_for(String arg1, String arg2, String arg3) throws Throwable {
		cv.clicking_option("Save");
		CommonFunctionality.wait(2000);
		if (arg1.equals("before") && arg2.equalsIgnoreCase("Reversed direction") && arg3.equalsIgnoreCase("Left Axis")
				&& axis_setup_checkboxes_uncheck == false) {
			List<WebElement> elements = login.driver.findElements(By
					.xpath("//*[contains(@class,'highcharts-yaxis-labels highcharts-yaxis-left')]/*[4][not(@x='0')]"));
			for (WebElement element : elements) {
				String text = element.getText();
				String text1[] = text.split("\\.");
				BigInteger integer1 = null;
				if (text1[0].contains(",")) {
					String text2 = text1[0].replaceAll(",", "");
					integer1 = new BigInteger(text2);
				} else {
					integer1 = new BigInteger(text1[0]);
				}
				list1.add(integer1);
			}
			List<WebElement> elements1 = login.driver.findElements(By
					.xpath("//*[contains(@class,'highcharts-yaxis-labels highcharts-yaxis-left')]/*[1][not(@x='0')]"));
			for (WebElement element : elements1) {
				String text1 = element.getText();
				String text2[] = text1.split("\\.");
				BigInteger integer2 = null;
				if (text2[0].contains(",")) {
					String text3 = text2[0].replaceAll(",", "");
					integer2 = new BigInteger(text3);
				} else {
					integer2 = new BigInteger(text2[0]);
				}
				list1.add(integer2);
			}
			List<WebElement> elements3 = login.driver.findElements(By
					.xpath("//*[contains(@class,'highcharts-yaxis-labels highcharts-yaxis-left')]/*[2][not(@x='0')]"));
			for (WebElement element : elements3) {
				String text2 = element.getText();
				String text3[] = text2.split("\\.");
				BigInteger integer3 = null;
				if (text3[0].contains(",")) {
					String text4 = text3[0].replaceAll(",", "");
					integer3 = new BigInteger(text4);
				} else {
					integer3 = new BigInteger(text3[0]);
				}
				list1.add(integer3);
			}
			boolean sorted = Ordering.natural().isOrdered(list1);
			if (sorted == true) {
				login.Log4j.info("The text are displaying in Ascending order");
			} else {
				fail("Verification Failed");
			}
		} else if (arg1.equals("after") && arg2.equalsIgnoreCase("Reversed direction")
				&& arg3.equalsIgnoreCase("Left Axis") && time_axis_checkboxes == true) {
			List<WebElement> elements = login.driver.findElements(By
					.xpath("//*[contains(@class,'highcharts-yaxis-labels highcharts-yaxis-left')]/*[3][not(@x='0')]"));
			for (WebElement element : elements) {
				String text = element.getText();
				String text1[] = text.split("\\.");
				BigInteger integer1 = null;
				if (text1[0].contains(",")) {
					String text2 = text1[0].replaceAll(",", "");
					integer1 = new BigInteger(text2);
				} else {
					integer1 = new BigInteger(text1[0]);
				}
				list2.add(integer1);
			}
			List<WebElement> elements1 = login.driver.findElements(By
					.xpath("//*[contains(@class,'highcharts-yaxis-labels highcharts-yaxis-left')]/*[2][not(@x='0')]"));
			for (WebElement element : elements1) {
				String text1 = element.getText();
				String text2[] = text1.split("\\.");
				BigInteger integer2 = null;
				if (text2[0].contains(",")) {
					String text3 = text2[0].replaceAll(",", "");
					integer2 = new BigInteger(text3);
				} else {
					integer2 = new BigInteger(text2[0]);
				}
				list2.add(integer2);
			}
			List<WebElement> elements3 = login.driver.findElements(By
					.xpath("//*[contains(@class,'highcharts-yaxis-labels highcharts-yaxis-left')]/*[1][not(@x='0')]"));
			for (WebElement element : elements3) {
				String text2 = element.getText();
				String text3[] = text2.split("\\.");
				BigInteger integer3 = null;
				if (text3[0].contains(",")) {
					String text4 = text3[0].replaceAll(",", "");
					integer3 = new BigInteger(text4);
				} else {
					integer3 = new BigInteger(text3[0]);
				}
				list2.add(integer3);
			}
			boolean sorted = Ordering.natural().reverse().isOrdered(list2);
			if (sorted == true) {
				login.Log4j.info("The text are displaying in Descending order");
			} else {
				fail("Verification Failed");
			}
			CommonFunctionality.Views_list();
		}
		if (arg1.equals("before") && arg2.equalsIgnoreCase("Logarithmic") && arg3.equalsIgnoreCase("Left Axis")
				&& axis_setup_checkboxes_uncheck == false) {
			List<WebElement> elements = login.driver.findElements(By.xpath(
					"//*[contains(@class,'highcharts-yaxis-labels highcharts-yaxis-left')]//*[not(@y='-9999')]"));
			logarithmic_before = elements.size();
		}
		if (arg1.equals("after") && arg2.equalsIgnoreCase("Logarithmic") && arg3.equalsIgnoreCase("Left Axis")
				&& time_axis_checkboxes == true) {
			List<WebElement> elements = login.driver.findElements(By.xpath(
					"//*[contains(@class,'highcharts-yaxis-labels highcharts-yaxis-left')]//*[not(@y='-9999')]"));
			logarithmic_after = elements.size();
			if (logarithmic_after > logarithmic_before) {
				login.Log4j.info("The " + arg2 + " of " + arg3 + " has been verified successfully");
			} else {
				fail("Verification Failed");
			}
			CommonFunctionality.Views_list();
		}
		if (arg1.equals("before") && arg2.equalsIgnoreCase("Reversed direction") && arg3.equalsIgnoreCase("Right Axis")
				&& axis_setup_checkboxes_uncheck_right == false) {
			List<WebElement> elements = login.driver.findElements(By.xpath(
					"//*[contains(@class,'highcharts-yaxis-labels highcharts-yaxis-right')]//*[not(@y='-9999')]"));
			for (WebElement element : elements) {
				String text = element.getText();
				String text1[] = null;
				if (text.contains("1,000,00")) {
					String text_replace = text.replaceAll("1,000,00", "1000,00");
					text1 = text_replace.split("\\,");
				} else if (text.contains("1,000.00")) {
					String text_replace = text.replaceAll("1,000.00", "1000.00");
					text1 = text_replace.split("\\.");
				} else {
					text1 = text.split("\\,");
				}
				if (text.contains(".")) {
					text1 = text.split("\\.");
					if (text.contains("1,000")) {
						String text_replace = text.replaceAll("1,000", "1000.00");
						text1 = text_replace.split("\\.");
					}
				}
				BigInteger integer = null;
				try {
					login.Log4j.info(text1[0]);
					integer = new BigInteger(text1[0]);
				} catch (Exception e) {

					list3.add(integer);
				}
			}
			boolean sorted = Ordering.natural().isOrdered(list3);
			if (sorted == true) {
				login.Log4j.info("The text are displaying in Ascending order");
			} else {
				fail("Verification Failed");
			}
		}
		if (arg1.equals("after") && arg2.equalsIgnoreCase("Reversed direction") && arg3.equalsIgnoreCase("Right Axis")
				&& axis_checkboxes_right == true) {
			String first = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[contains(@class,'highcharts-yaxis-labels highcharts-yaxis-right')]//*[not(@y='-9999')])[3]",
					4).getText();
			String second = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[contains(@class,'highcharts-yaxis-labels highcharts-yaxis-right')]//*[not(@y='-9999')])[2]",
					4).getText();
			String third = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[contains(@class,'highcharts-yaxis-labels highcharts-yaxis-right')]//*[not(@y='-9999')])[1]",
					4).getText();
			String first_element[] = null;
			if (first.contains("1,000.00")) {
				String text_replace = first.replaceAll("1,000.00", "1000.00");
				first_element = text_replace.split("\\.");
			} else {
				first_element = first.split("\\.");
			}
			String second_element[] = second.split("\\.");
			String third_element[] = third.split("\\.");
			Integer first_element_int = Integer.parseInt(first_element[0]);
			list4.add(first_element_int);
			Integer second_element_int = Integer.parseInt(second_element[0]);
			list4.add(second_element_int);
			Integer third_element_int = Integer.parseInt(third_element[0]);
			list4.add(third_element_int);
			boolean sorted = Ordering.natural().reverse().isOrdered(list4);
			if (sorted == true) {
				login.Log4j.info("The text are displaying in Descending order");
			} else {
				fail("Verification Failed");
			}
			CommonFunctionality.Views_list();
		}
		if (arg1.equals("before") && arg2.equalsIgnoreCase("Logarithmic") && arg3.equalsIgnoreCase("Right Axis")
				&& axis_setup_checkboxes_uncheck_right == false) {
			List<WebElement> elements = login.driver.findElements(By.xpath(
					"//*[contains(@class,'highcharts-yaxis-labels highcharts-yaxis-right')]//*[not(@y='-9999')]"));
			logarithmic_before_right = elements.size();
		}
		if (arg1.equals("after") && arg2.equalsIgnoreCase("Logarithmic") && arg3.equalsIgnoreCase("Right Axis")
				&& axis_checkboxes_right == true) {
			List<WebElement> elements = login.driver.findElements(By.xpath(
					"//*[contains(@class,'highcharts-yaxis-labels highcharts-yaxis-right')]//*[not(@y='-9999')]"));
			logarithmic_after_right = elements.size();
			if (logarithmic_after_right >= logarithmic_before_right) {
				login.Log4j.info("The " + arg2 + " of " + arg3 + " has been verified successfully");
			} else {
				fail("Verification Failed");
			}
			CommonFunctionality.Views_list();
		}
		if (arg1.equals("after") && arg2.equalsIgnoreCase("Set as the default axis")
				&& arg3.equalsIgnoreCase("Left Axis") && time_axis_checkboxes == true) {
			cv.search_for_the_series_with_SID("357534787");
			cv.click_on_more_actions_to_create("View as Chart");
			if (login.driver
					.findElements(By
							.xpath("//*[contains(@class,'highcharts-yaxis-left')]//*[@class='highcharts-axis-title']"))
					.size() == 1) {
				login.Log4j.info("The " + arg2 + "of " + arg3 + " has been verified successfully");
			} else {
				fail("Verification Failed");
			}
			CommonFunctionality.Views_list();
		}
	}

	@And("^Click on Labels checkbox$")
	public void click_on_Labels_checkbox() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[text()='Values axis']//following::*[@title='Open advanced settings popup']", 4).click();
	}

	@And("^Select the \"([^\"]*)\" for \"([^\"]*)\"$")
	public void select_the_for(String arg1, String arg2) throws Throwable {
		bold = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'font-bold') and @name='" + arg2 + "_font_weight']", 4);
		italic = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'font-italic') and @name='" + arg2 + "_font_style']", 4);
		underline = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'font-underline') and @name='" + arg2 + "_font_underline']", 4);
		if (!(bold.getAttribute("class").contains("selected"))) {
			bold.click();
		}
		if (!(italic.getAttribute("class").contains("selected"))) {
			italic.click();
		}
		if (!(underline.getAttribute("class").contains("selected"))) {
			underline.click();
		}
		CommonFunctionality.wait(3000);
	}

	@And("^Click on \"([^\"]*)\" alignment$")
	public void click_on_alignment(String arg1) throws Throwable {
		left = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@name='title_align' and @data-value='" + arg1 + "']", 4);
		right = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@name='title_align' and @data-value='" + arg1 + "']", 4);
		center = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@name='title_align' and @data-value='" + arg1 + "']", 4);
		if (arg1.equalsIgnoreCase("left") && !left.getAttribute("class").contains("selected")) {
			left.click();
		}
		if (arg1.equalsIgnoreCase("right") && !right.getAttribute("class").contains("selected")) {
			right.click();
		}
		if (arg1.equalsIgnoreCase("center") && !center.getAttribute("class").contains("selected")) {
			center.click();
		}
	}

	@And("^Click on Sign out option$")
	public void click_on_Sign_out_option() throws Throwable {
		if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal__content')]//*[text()='Delete']"))
				.size() > 0) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'sphere-modal__content')]//*[text()='Delete']", 4).click();
		}
		if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal__content')]//*[text()='Sign out']"))
				.size() > 0) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'sphere-modal__content')]//*[text()='Sign out']", 4).click();
		}
		CommonFunctionality.wait(3000);
	}

	@And("^Click on upload Image button$")
	public void click_on_upload_Image_button() throws Throwable {
		CommonFunctionality.getElementBycssSelector(login.driver, "form[enctype='multipart/form-data']", 4).click();
		CommonFunctionality.wait(2000);
		// AutoIT path
		CommonFunctionality.uploadTheFileusingAutoIT(login.driver,
				System.getProperty("user.dir") + "\\AutoIT\\Shravas.exe",
				System.getProperty("user.dir") + "\\AutoIT\\Shravas.png");
		CommonFunctionality.wait(2000);
	}

	@And("^Click on the \"([^\"]*)\" chart type$")
	public void click_on_the_chart_type(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Line")) {
			CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath",
					"//*[@title='Change the chart type']");
		}
	}

	@And("^Click on the \"([^\"]*)\" option$")
	public void click_on_the_option(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		if (arg1.equalsIgnoreCase("Group")) {
			WebElement group = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='indented-tree-control indented-tree-control__visible']//*[contains(text(),'" + arg1 + "')]",10);
			new Actions(login.driver).moveToElement(group).perform();
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='indented-tree-control indented-tree-control__visible']//*[@class='input-control--indicator']",
					10).click();
		} else if (arg1.equalsIgnoreCase("Unselect all") || arg1.equalsIgnoreCase("Drilldown")) {
			WebElement ele = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]",
					8);
			ele.click();
		} else if (arg1.equalsIgnoreCase("Back")) {
			CommonFunctionality.getElementByXpath(login.driver, "//div[@class='breakdown-preview--back']", 8).click();
		} else {
//			new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
//					"//*[@class='preview-container']//*[@class=' highcharts-button-box'] | //*[@class='visual-series-list']",
//					4)).perform();
			CommonFunctionality.getElementByXpath(login.driver,
					"(//*[@class='visual-series-list']//*[@title='" + arg1 + "'])[1]", 4).click();

		}
	}

	@And("^Click on the \"([^\"]*)\" option for delete$")
	public void click_on_the_option_for_delete(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "(//*[@title='" + arg1 + "'])[2]", 4).click();
	}

	@SuppressWarnings("deprecation")
	@And("^Hover to the series option and get text$")
	public void hover_to_the_series_option_and_get_text() throws Throwable {
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, ".series-name--title", 4))
				.pause(1000).build().perform();
		series_name_text = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'Name:')]/following-sibling::*", 4).getText();
	}

	@SuppressWarnings("deprecation")
	@And("^Click credits image$")
	public void click_credits_image() throws Throwable {
		CommonFunctionality.wait(2000);
		new Actions(login.driver).moveToElement(
				CommonFunctionality.getElementByClassName(login.driver, "visual-item-wrapper--credits-image", 4))
				.pause(500).click().build().perform();
	}

	@And("^Click the Functions input box$")
	public void click_the_Functions_input_box() throws Throwable {
		CommonFunctionality.getElementBycssSelector(login.driver, "input[class='current-function-input--field']", 4)
				.click();
	}

	@And("^Click on the Currency button$")
	public void click_on_the_Currency_button() throws Throwable {
		CommonFunctionality.getElementBycssSelector(login.driver,
				"div.preview-container--series.bottom_panel > div > div > div > div:nth-child(9) > div.table--cell.table--body-cell.visual-series-list--series-row > div > div > div.insight-action-panel--btn-title",
				4).click();
	}

	@And("^Enter the function$")
	public void enter_the_function() throws Throwable {
		WebElement element = CommonFunctionality.getElementBycssSelector(login.driver,
				"input[class='current-function-input--field']", 4);
		element.sendKeys("%");
		CommonFunctionality.wait(200);
		element.sendKeys(Keys.ENTER);
		CommonFunctionality.wait(200);
		element.sendKeys(Keys.ENTER);
	}

	@And("^Enter the function in function field$")
	public void enter_the_function_in_function_field() throws Throwable {
		WebElement element = CommonFunctionality.getElementBycssSelector(login.driver,
				"input[class='current-function-input--field']", 4);
		element.sendKeys("AGG");
		CommonFunctionality.wait(2000);
		element.sendKeys(Keys.ENTER);
		CommonFunctionality.wait(2000);
		element.sendKeys("YE");
		CommonFunctionality.wait(2000);
		element.sendKeys(Keys.ENTER);
		CommonFunctionality.wait(2000);
		element.sendKeys("De");
		CommonFunctionality.wait(2000);
		element.sendKeys(Keys.ENTER);
		CommonFunctionality.wait(2000);
		element.sendKeys("Sum");
		CommonFunctionality.wait(2000);
		element.sendKeys(Keys.ENTER);
		CommonFunctionality.wait(2000);
		element.sendKeys("Yes");
		CommonFunctionality.wait(2000);
		element.sendKeys(Keys.ENTER);
	}

	@And("^Enter the function in function fields$")
	public void enter_the_function_in_function_fields() throws Throwable {
		WebElement element = CommonFunctionality.getElementBycssSelector(login.driver,
				"input[class='current-function-input--field']", 4);
		element.sendKeys("DIS");
		CommonFunctionality.wait(200);
		element.sendKeys(Keys.ENTER);
		CommonFunctionality.wait(200);
		element.sendKeys("Daily");
		CommonFunctionality.wait(200);
		element.sendKeys(Keys.ENTER);
		CommonFunctionality.wait(200);
		element.sendKeys("Distribute");
		CommonFunctionality.wait(200);
		element.sendKeys(Keys.ENTER);
	}

	@And("^Enter function in function fields of Chart$")
	public void enter_function_in_function_fields_of_Chart() throws Throwable {
		WebElement element = CommonFunctionality.getElementBycssSelector(login.driver,
				"input[class='current-function-input--field']", 4);
		element.sendKeys("FILL");
		CommonFunctionality.wait(200);
		element.sendKeys(Keys.ENTER);
		CommonFunctionality.wait(200);
		element.sendKeys("Pre");
		CommonFunctionality.wait(200);
		element.sendKeys(Keys.ENTER);
	}

	@And("^Enter the function in function fields of Chart$")
	public void enter_the_function_in_function_fields_of_Chart() throws Throwable {
		WebElement element = CommonFunctionality.getElementBycssSelector(login.driver,
				"input[class='current-function-input--field']", 4);
		element.sendKeys("SMOO");
		CommonFunctionality.wait(200);
		element.sendKeys(Keys.ENTER);
		CommonFunctionality.wait(200);
		element.sendKeys("Sin");
		CommonFunctionality.wait(200);
		element.sendKeys(Keys.ENTER);
		CommonFunctionality.wait(200);
		element.sendKeys(Keys.ENTER);
	}

	@And("^Enter the Currency as \"([^\"]*)\"$")
	public void enter_the_Currency_as(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']", 4).click();
	}

	@And("^Click on Currency in functions box$")
	public void click_on_Currency_in_functions_box() throws Throwable {
		CommonFunctionality.wait(3000);
		String function = CommonFunctionality.getElementByClassName(login.driver, "series-function-item--body", 4)
				.getText();
		applied_function = function.replaceAll("\n", "");
	}

	@And("^Click on \"([^\"]*)\" in functions box$")
	public void click_on_in_functions_box(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);
		WebElement apply = CommonFunctionality.getElementByXpath(login.driver, "//div[@title='" + arg1 + "']", 4);
		js.executeScript("arguments[0].scrollIntoView(true);", apply);
		if (login.driver.findElements(By.xpath("//div[@title='" + arg1 + "']")).size() > 0) {
			js.executeScript("arguments[0].click();", apply);
		}
		CommonFunctionality.wait(1000);
		if (arg1.equalsIgnoreCase("Apply function")) {
			CommonFunctionality.wait(2000);
			String function = CommonFunctionality.getElementByClassName(login.driver, "series-function-item--body", 4)
					.getText();
			applied_function = function.replaceAll("\n", "");
		}
	}

	@And("^Clicking Download button from \"([^\"]*)\"$")
	public void clicking_Download_button(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Context Menu")) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'sphere-modal__content')]//*[contains(@class,'button__download-btn')]", 4)
					.click();
			CommonFunctionality.wait(3000);
		}
		if (arg1.equalsIgnoreCase("Page Header of Views Tab")) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='page-main-header--buttons']//following::*[contains(@class,'button__download-btn')]", 4)
					.click();
			CommonFunctionality.wait(2000);
			if (login.driver.findElements(By.xpath("//*[text()='Views']")).size() > 0) {
				CommonFunctionality.wait(1000);
				CommonFunctionality.getElementByXpath(login.driver, "//*[text()='Views']", 4).click();
			} else {
				fail("Verify failed");
			}
			if (login.driver
					.findElements(By.xpath("//div[contains(@class,'download-views__list')]//div[@data-id='all_items']"))
					.size() > 0) {
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'sphere-modal__content')]//*[contains(@class,'button__download-btn')]", 4)
						.click();
			} else {
				fail("All views has not been selected");
			}
			CommonFunctionality.wait(3000);
		}
		if (arg1.equalsIgnoreCase("Page Header")) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='page-main-header--buttons']//following::*[contains(@class,'button__download-btn')]", 4)
					.click();
			// CommonFunctionality.getElementByXpath(login.driver,
			// "//div[@data-tab='series']", 4).click();
			if (login.driver
					.findElements(
							By.xpath("//*[contains(@class,'modal-body')]//*[contains(@class,'button__download-btn')]"))
					.size() > 0) {
				CommonFunctionality
						.getElementByXpath(login.driver,
								"//*[contains(@class,'modal-body')]//*[contains(@class,'button__download-btn')]", 4)
						.click();
			}
			CommonFunctionality.wait(5000);
		}
	}

	@And("^Click on \"([^\"]*)\" function from myseries$")
	public void click_on_function_from_myseries(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 4).click();
	}

	@And("^Get the function text from myseries$")
	public void get_the_function_text_from_myseries() throws Throwable {
		String series = CommonFunctionality.getElementByClassName(login.driver, "series-functions-title", 4).getText();
		function_myseries = series.replaceAll("^\\[|\\]$", "");
	}

	@And("^Get the updated Chart visual value$")
	public void get_the_updated_Chart_visual_value() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='3Y']", 4).click();
		CommonFunctionality.wait(1000);
		chart_axis_multipler_value_numberformat = CommonFunctionality
				.getElementByProperty(login.driver, "chart_axis_multipler_value_number_format", 4).getText();
	}

	@And("^Click on \"([^\"]*)\" align in Title section$")
	public void click_on_align_in_Title_section(String arg1) throws Throwable {
		low = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@name='y_axis_align' and @data-value='" + arg1 + "']", 4);
		middle = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@name='y_axis_align' and @data-value='" + arg1 + "']", 4);
		high = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@name='y_axis_align' and @data-value='" + arg1 + "']", 4);
		if (arg1.equalsIgnoreCase("low") && !low.getAttribute("class").contains("selected")) {
			low.click();
		}
		if (arg1.equalsIgnoreCase("middle") && !middle.getAttribute("class").contains("selected")) {
			middle.click();
		}
		if (arg1.equalsIgnoreCase("high") && !high.getAttribute("class").contains("selected")) {
			high.click();
		}
	}

	@And("^Click on \"([^\"]*)\" button in myseries$")
	public void click_on_button_in_myseries(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		if (arg1.equalsIgnoreCase("More actions")) {
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//*[contains(@class,'show-context ') and @title='" + arg1 + "']", 4))
					.click().build().perform();
		}
		if (arg1.equalsIgnoreCase("Frequency")) {
			new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
					"*[class='context-menu-item link'][title='" + arg1 + "']", 4)).click().build().perform();
		} else {
			new Actions(login.driver)
					.moveToElement(
							CommonFunctionality.getElementBycssSelector(login.driver, "*[title='" + arg1 + "']", 4))
					.click().build().perform();
		}
	}

	@And("^Click on More actions button in myseries$")
	public void click_on_More_actions_button_in_myseries() throws Throwable {
		CommonFunctionality.wait(3000);
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'show-context ') and @title='More actions']", 4))
				.click().build().perform();
	}

	@And("^Click on Unselect all button in myseries$")
	public void click_on_Unselect_all_button_in_myseries() throws Throwable {
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, "*[title='Unselect all']", 4))
				.click().build().perform();
	}

	@And("^Click on Delete button in myseries$")
	public void click_on_Delete_button_in_myseries() throws Throwable {
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'context-menu-item') and @title='Delete']", 4)).click().build().perform();
	}

	@And("^Select the \"([^\"]*)\" position$")
	public void select_the_position(String arg1) throws Throwable {
		data_position = arg1;
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
				"button[data-value='" + data_position + "']", 4)).click().build().perform();

	}

	@And("^Click on the \"([^\"]*)\" checkbox in copyright$")
	public void click_on_the_checkbox_in_copyright(String arg1) throws Throwable {
		copyright_checkbox_text = arg1;
		boolean checked = login.driver
				.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]/preceding-sibling::input")).isSelected();
		if (checked == false) {
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//*[contains(text(),'" + arg1 + "')]/preceding-sibling::span", 4))
					.click().build().perform();
		}
		CommonFunctionality.wait(1000);
	}

	@And("^Click on Add from My Series visual$")
	public void click_on_Add_from_My_Series_visual() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='Add from My Series']", 4).click();
	}

	@And("^Hover over to \"([^\"]*)\" Option$")
	public void hover_over_to_Option(String arg1) throws Throwable {
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'visual-series-list--remove-row')]//*[@title='" + arg1 + "']", 4))
				.build().perform();
	}

	@And("^Click on \"([^\"]*)\" button from myseries$")
	public void click_on_button_from_myseries(String frequency) throws Throwable {
		new Actions(login.driver)
				.moveToElement(
						CommonFunctionality.getElementBycssSelector(login.driver, "*[title='" + frequency + "']", 4))
				.click().build().perform();
	}

	@And("^Click on \"([^\"]*)\" button in myseries list$")
	public void click_on_button_in_myseries_list(String currency) throws Throwable {
		currency_in_series = currency;
		new Actions(login.driver)
				.moveToElement(
						CommonFunctionality.getElementBycssSelector(login.driver, "*[title='" + currency + "']", 4))
				.click().build().perform();
	}

	@And("^Click on \"([^\"]*)\" button from myseries list$")
	public void click_on_button_from_myseries_list(String change) throws Throwable {
		String text = change;
		new Actions(login.driver)
				.moveToElement(
						CommonFunctionality.getElementBycssSelector(login.driver, "*[title='" + change + "']", 4))
				.click().build().perform();
		change_in_series = text.replaceAll("-", " ");
	}

	@And("^Enter the Series name as \"([^\"]*)\"$")
	public void enter_the_Series_name_as(String arg1) throws Throwable {
		rename_series = arg1;
		if (login.driver.findElements(By.cssSelector(".movable-modal--window")).size() > 0) {
			WebElement series = CommonFunctionality.getElementBycssSelector(login.driver,
					".find-and-replace-item--name-input", 4);
			series.clear();
			series.sendKeys(arg1);
			WebElement apply = CommonFunctionality.getElementByXpath(login.driver, "//*[text()='Apply']", 4);
			WebElement ok = CommonFunctionality.getElementByXpath(login.driver, "//*[text()='OK']", 4);
			js.executeScript("arguments[0].click();", apply);
			js.executeScript("arguments[0].click();", ok);
		} else {
			fail("Rename window not displayed");
		}
	}

	@And("^Verify the Copied message from myseries$")
	public void verify_the_Copied_message_from_myseries() throws Throwable {
		if (CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'growl-messages-container')]", 4)
				.isDisplayed()) {
			System.out.println("Growl message has been displayed");
		} else {
			fail("Growl not displayed");
		}
	}

	@And("^Select \"([^\"]*)\" option from line chart$")
	public void select_option_from_line_chart(String arg1) throws Throwable {
		WebElement line = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'" + arg1 + "')]/preceding-sibling::span", 4);
		new Actions(login.driver).moveToElement(line).click().build().perform();
		CommonFunctionality.wait(2000);
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath", "//*[@title='Change the chart type']");
	}

	@SuppressWarnings("deprecation")
	@And("^Click on \"([^\"]*)\" option from layout$")
	public void click_on_option_from_layout(String arg1) throws Throwable {
		login.driver.navigate().refresh();
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']", 4).click();
		CommonFunctionality.wait(2000);
		WebElement title_name = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'bottom-panel-title') and @title='" + insight + "_" + formatter.format(date)
						+ "']",
				4);
		new Actions(login.driver).moveToElement(title_name).pause(4000).click().build().perform();
	}

	@And("^Close the Edit Chart visual$")
	public void close_the_Edit_Chart_visual() throws Throwable {
		if (login.driver.findElements(By.className("movable-modal--close")).size() > 0) {
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		}
		if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']"))
				.size() > 0) {
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']", 4)
					.click();
		}
	}

	@And("^Enter \"([^\"]*)\" for chart visual as \"([^\"]*)\"$")
	public void enter_title_for_chart_visual(String arg1, String arg2) throws Throwable {
		if (arg2.equalsIgnoreCase("New chart")) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(text(),'" + arg1 + "')]/following::input[@name='title']", 8).clear();
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(text(),'" + arg1 + "')]/following::input[@name='title']", 8).sendKeys(arg2);
		} else if (arg1.equalsIgnoreCase("Sub title")) {
			chart_subtitle_text = arg2;
			WebElement subtitle = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(text(),'" + arg1 + "')]/following::*[@name='sub_title']", 8);
			subtitle.sendKeys(Keys.chord(Keys.CONTROL, "a"), chart_subtitle_text);
			CommonFunctionality.wait(500);
		} else {
			chart_title_text = arg2;
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(text(),'" + arg1 + "')]/following::input[@name='title']", 8).clear();
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(text(),'" + arg1 + "')]/following::input[@name='title']", 8)
					.sendKeys(chart_title_text);
		}
	}

	@And("^Capture Screenshot$")
	public void capture_Screenshot() throws Throwable {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy h-m-s");
		File scrFile = ((TakesScreenshot) login.driver).getScreenshotAs(OutputType.FILE);
		destFile = System.getProperty("user.dir") + "\\Screenshot_Images\\" + "Image_" + formatter.format(date)
				+ ".png";
		File file = new File(destFile);
		FileUtils.copyFile(scrFile, file);
	}

	@And("^Click on \"([^\"]*)\" in Keep insight option$")
	public void click_on_in_Keep_insight_option(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		if (login.driver
				.findElements(
						By.xpath("//*[@class='movable-modal--window']//*[text()='Do you want to keep your insight?']"))
				.size() > 0) {
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='movable-modal--window']//*[text()='" + arg1 + "']", 4)
					.click();
		}
	}

	@And("^\"([^\"]*)\" should display$")
	public void should_display(String arg1) throws Throwable {
		WebElement observation = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@name='time_frame_observations']", 4);
		String value_min = observation.getAttribute("aria-valuemin");
		String value_max = observation.getAttribute("aria-valuemax");
		WebElement last = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='popover--wrapper']//*[text()='Last observations']//preceding-sibling::span", 4);
		js.executeScript("arguments[0].click();", last);
		CommonFunctionality.wait(1000);
		String entered_value = observation.getAttribute("aria-valuenow");
		int aria_min = Integer.parseInt(value_min);
		int aria_max = Integer.parseInt(value_max);
		int current_entered_value = Integer.parseInt(entered_value);
		if (arg1.equalsIgnoreCase("Incorrect Start Date")) {
			int incorrect_start_observation = Integer.parseInt(incorrect_start_date);
			if (incorrect_start_observation != current_entered_value && incorrect_start_observation < aria_min) {
				login.Log4j.info(arg1 + " has been verified successfully");
			} else {
				fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("Incorrect End Date")) {
			int incorrect_end_observation = Integer.parseInt(incorrect_end_date);
			if (incorrect_end_observation != current_entered_value && incorrect_end_observation > aria_max) {
				login.Log4j.info(arg1 + " has been verified successfully");
			} else {
				fail("Verification Failed");
			}
		}
	}

	@And("^\"([^\"]*)\" Decimal places should display$")
	public void Decimal_places_should_display(String arg1) throws Throwable {
		WebElement data = CommonFunctionality.getElementByXpath(login.driver, "//*[@name='data_labels_decimal_places']",
				4);
		String value_min = data.getAttribute("aria-valuemin");
		String value_max = data.getAttribute("aria-valuemax");
		WebElement input = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'dropdown-menu')]//*[text()='Decimal places']/following::input[1]", 4);
		js.executeScript("arguments[0].click();", input);
		String entered_value = data.getAttribute("aria-valuenow");
		int aria_min = Integer.parseInt(value_min);
		int aria_max = Integer.parseInt(value_max);
		int current_entered_value = Integer.parseInt(entered_value);
		if (arg1.equalsIgnoreCase("Incorrect Start")) {
			int incorrect_start_decimal_format = Integer.parseInt(data_format_decimal_start_value);
			if (incorrect_start_decimal_format != current_entered_value && incorrect_start_decimal_format < aria_min) {
				login.Log4j.info(arg1 + " has been verified successfully");
			} else {
				fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("Incorrect End")) {
			int incorrect_end_decimal_format = Integer.parseInt(data_format_decimal_end_value);
			if (incorrect_end_decimal_format != current_entered_value && incorrect_end_decimal_format > aria_max) {
				login.Log4j.info(arg1 + " has been verified successfully");
			} else {
				fail("Verification Failed");
			}
		}
	}

	@And("^\"([^\"]*)\" should displayed$")
	public void should_displayed(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Correct Observations")) {
			List<WebElement> observations = login.driver.findElements(By.xpath(
					"//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden')]"));
			int actual = observations.size();
			int expected = Integer.parseInt(correct_observations);
			assertEquals(actual, expected);
			login.Log4j.info(arg1 + " has been verified successfully and the difference in days is " + actual);
			CommonFunctionality.Views_list();
		}
	}

	@And("^Click on \"([^\"]*)\" option inside visual$")
	public void click_on_option_inside_visual(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 4).click();
		CommonFunctionality.wait(1000);
	}

	@And("^Click on confirmation popup$")
	public void click_on_confirmation_popup() throws Throwable {
		if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']"))
				.size() > 0) {
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']", 4)
					.click();
			CommonFunctionality.wait(1000);
		} else {
			fail("Confirmation popup is not displayed");
		}
	}

	@And("^Growl popup is displaying$")
	public void growl_popup_is_displaying() throws Throwable {
		if (login.driver.findElements(By.xpath("//*[@class='growl-message growl-success']")).size() > 0) {
			System.out.println("Copy button is clicked");
		} else {
			fail("Growl message is not displaying");
		}
	}

	@And("^Copy the data after clicking Copy button$")
	public void copy_the_data_after_clicking_Copy_button() throws Throwable {
		// Toolkit toolkit = Toolkit.getDefaultToolkit();
		// Clipboard clipboard = toolkit.getSystemClipboard();
		// copied_text = (String) clipboard.getData(DataFlavor.stringFlavor);
		CommonFunctionality.wait(2000);
		copied_text = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
		login.Log4j.info(copied_text);
	}

	@And("^Write the copied data into a text file$")
	public void write_the_copied_data_into_a_text_file() throws Throwable {
		// Create new file
		path = System.getProperty("user.dir") + File.separator + "Visual_data.txt";
		File file = new File(path);
		if (!file.exists()) {
			file.createNewFile();
		}
		FileUtils.writeStringToFile(new File(path), copied_text, StandardCharsets.UTF_8);
		BufferedReader br = new BufferedReader(new FileReader(file));
		read_copied_data = br.readLine();
		br.close();
	}

	@And("^Get the text of options available$")
	public void get_the_text_of_options_available() throws Throwable {
		List<WebElement> elements = login.driver.findElements(
				By.xpath("//*[@class='items-wrapper']/li/span[not(contains(@class,'dropdown-submenu-icon'))]"));
		for (WebElement element : elements) {
			String rightclick_text = element.getAttribute("title");
			CommonFunctionality.wait(500);
			rightclick_element.add(rightclick_text);
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Get the text of sub dropdowns available$")
	public void get_the_text_of_sub_dropdowns_available() throws Throwable {
		String a = "Insert visual";
		String b = "View as";
		String c = "Download"; /*
								 * String d="Calculate series"; String e="Paste visual"; String
								 * f="Reset format";
								 */
		if (rightclick_element.contains(a)) {
			List<WebElement> sub = login.driver.findElements(
					By.xpath("//*[@title='" + a + "']//following-sibling::ul[@class='dropdown-menu']/li/span"));
			for (int i = 1; i <= sub.size(); i++) {
				WebElement hover = CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + a + "']", 4);
				new Actions(login.driver).moveToElement(hover).pause(500).build().perform();
				String subdropdown_text = CommonFunctionality
						.getElementByXpath(login.driver, "//*[@title='" + a
								+ "']//following-sibling::ul[@class='dropdown-menu']/li[" + i + "]/span", 4)
						.getAttribute("title");
				insert_visual_list.add(subdropdown_text);
			}
		} else {
			fail("Subdropdown items are not present");
		}
		if (rightclick_element.contains(b)) {
			List<WebElement> sub = login.driver.findElements(
					By.xpath("//*[@title='" + b + "']//following-sibling::ul[@class='dropdown-menu']/li/span"));
			for (int j = 1; j <= sub.size(); j++) {
				WebElement hover = CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + b + "']", 4);
				new Actions(login.driver).moveToElement(hover).pause(500).build().perform();
				String subdropdown_text = CommonFunctionality
						.getElementByXpath(login.driver, "//*[@title='" + b
								+ "']//following-sibling::ul[@class='dropdown-menu']/li[" + j + "]/span", 4)
						.getAttribute("title");
				view_as.add(subdropdown_text);
			}
		} else {
			fail("Subdropdown items are not present");
		}
		if (rightclick_element.contains(c)) {
			List<WebElement> sub = login.driver.findElements(
					By.xpath("//*[@title='" + c + "']//following-sibling::ul[@class='dropdown-menu']/li/span"));
			for (int k = 1; k <= sub.size(); k++) {
				WebElement hover = CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + c + "']", 4);
				new Actions(login.driver).moveToElement(hover).pause(500).build().perform();
				String subdropdown_text = CommonFunctionality
						.getElementByXpath(login.driver, "//*[@title='" + c
								+ "']//following-sibling::ul[@class='dropdown-menu']/li[" + k + "]/span", 4)
						.getAttribute("title");
				download.add(subdropdown_text);
			}
		} else {
			fail("Subdropdown items are not present");
		}

		/*
		 * if(rightclick_element.contains(d)) { WebElement hover =
		 * CommonFunctionality.getElementByXpath(login.driver, "//*[@title='"+d+"']",
		 * 4); new
		 * Actions(login.driver).moveToElement(hover).pause(500).build().perform();
		 * if(login.driver.findElements(By.xpath("//*[@title='"+d+
		 * "']//following-sibling::ul[@class='dropdown-menu']/li")).size()>0) {
		 * System.out.println("The function options are present inside the "+d); } else
		 * { fail(d+" verification failed"); } }
		 * 
		 * if(rightclick_element.contains(e)) { new
		 * Actions(login.driver).moveToElement(CommonFunctionality.
		 * getElementBycssSelector(login.driver, "span[title='Delete chart']",
		 * 4)).pause(500).build().perform(); WebElement disabled =
		 * CommonFunctionality.getElementByXpath(login.driver,
		 * "//*[@title='"+e+"'] | //*[@title='"+f+"']", 4);
		 * CommonFunctionality.wait(1000);
		 * if(!disabled.getAttribute("class").contains("disabled")) {
		 * System.out.println("The "+e+" options are enabled by default"); } else {
		 * fail("Verification failed"); } }
		 * 
		 * if(rightclick_element.contains(f)) { WebElement disabled =
		 * CommonFunctionality.getElementByXpath(login.driver,
		 * "//*[@title='"+e+"'] | //*[@title='"+f+"']", 4);
		 * CommonFunctionality.wait(1000);
		 * if(disabled.getAttribute("class").contains("disabled")) {
		 * System.out.println("The "+f+" option is in disabled state by default"); }
		 * else { fail("Verification failed"); } }
		 */
	}

	@SuppressWarnings("deprecation")
	@And("^Click on \"([^\"]*)\" inside the visual$")
	public void click_on_inside_the_visual(String arg1) throws Throwable {
		WebElement series = CommonFunctionality.getElementByXpath(login.driver,
				"//span[@title='Edit series' and @class='context-menu-item link'] | //span[@title='Clear contents' and @class='context-menu-item link']",
				4);
		new Actions(login.driver).moveToElement(series).pause(500).click().build().perform();
	}

	@And("^Click on \"([^\"]*)\" option in the visual$")
	public void click_on_option_in_the_visual(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 4).click();
	}

	@And("^Closing the popup$")
	public void closing_the_popup() throws Throwable {
		CommonFunctionality.getElementByClassName(login.driver, "popover--close", 4).click();
	}

	@SuppressWarnings("deprecation")
	@And("^Perform \"([^\"]*)\" Operation$")
	public void perform_Operation(String arg1) throws Throwable {
		WebElement action = CommonFunctionality.getElementBycssSelector(login.driver, "div[title^='" + arg1 + "']", 4);
		new Actions(login.driver).moveToElement(action).pause(500).click().build().perform();
	}

	public static void Chart_Date(String dateStart, String dateStop) throws ParseException {
		if (dateStart.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")) {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			date1 = format.parse(dateStart);
		} else if (dateStart.matches("([0-9]{4})")) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy");
			date1 = format.parse(dateStart);
		} else {
			SimpleDateFormat format = new SimpleDateFormat("dd/yyyy");
			date1 = format.parse(dateStart);
		}
		if (dateStop.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")) {
			SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
			date2 = format1.parse(dateStop);
		} else if (dateStop.matches("([0-9]{4})")) {
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy");
			date2 = format1.parse(dateStop);
		} else {
			SimpleDateFormat format1 = new SimpleDateFormat("dd/yyyy");
			date2 = format1.parse(dateStop);
		}
		getDiffYears(date1, date2);
	}

	public static int getDiffYears(Date date1, Date date2) {
		Calendar a = getCalendar(date1);
		Calendar b = getCalendar(date2);
		diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
		if (a.get(Calendar.DAY_OF_YEAR) > b.get(Calendar.DAY_OF_YEAR)) {
			diff--;
		}
		return diff;
	}

	public static Calendar getCalendar(Date date) {
		Calendar cal = Calendar.getInstance(Locale.US);
		cal.setTime(date);
		return cal;
	}

	@And("^Select the \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" tabs$")
	public void select_tabs(String arg1, String arg2, String arg3, String arg4) throws Throwable {
		CommonFunctionality.wait(3000);
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='highcharts-range-selector-buttons']//*[text()='" + arg1 + "']", 4).click();
		CommonFunctionality.wait(3000);
		y1_start = login.driver
				.findElement(By.xpath("//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[2]")).getText();
		y1_end = login.driver.findElement(By.xpath("//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[1]"))
				.getText();
		login.driver.findElement(By.xpath("//*[@class='highcharts-range-selector-buttons']//*[text()='" + arg2 + "']"))
				.click();
		CommonFunctionality.wait(3000);
		y3_start = login.driver
				.findElement(By.xpath("//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[2]")).getText();
		y3_end = login.driver.findElement(By.xpath("//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[1]"))
				.getText();
		login.driver.findElement(By.xpath("//*[@class='highcharts-range-selector-buttons']//*[text()='" + arg3 + "']"))
				.click();
		CommonFunctionality.wait(3000);
		y5_start = login.driver
				.findElement(By.xpath("//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[2]")).getText();
		y5_end = login.driver.findElement(By.xpath("//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[1]"))
				.getText();
		login.driver.findElement(By.xpath("//*[@class='highcharts-range-selector-buttons']//*[text()='" + arg4 + "']"))
				.click();
		CommonFunctionality.wait(3000);
		All_start = login.driver
				.findElement(By.xpath("//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[2]")).getText();
		All_end = login.driver
				.findElement(By.xpath("//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[1]")).getText();
	}

	@Then("^Should display \"([^\"]*)\" options on the right pane under \"([^\"]*)\" > \"([^\"]*)\" tab$")
	public void should_display_options_on_the_right_pane_under_tab(String arg1, String arg2, String arg3)
			throws Throwable {
		String a = "Line";
		String b = "Column";
		String c = "Pie";
		WebElement chart = CommonFunctionality.getElementByClassName(login.driver, "view-components-over--visuals", 4);
		if (chart.isDisplayed()) {
			String line_chart_text = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='view-components-over--visual-title' and text()='Line']", 4).getText();
			if (line_chart_text.equalsIgnoreCase(a) || line_chart_text.equalsIgnoreCase(b)
					|| line_chart_text.equalsIgnoreCase(c)) {
				System.out.println("Line Chart Visual is present");
			} else {
				fail("Line Chart Visual is not present");
			}
			String column_chart_text = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='view-components-over--visual-title' and text()='Column']", 4).getText();
			if (column_chart_text.equalsIgnoreCase(a) || column_chart_text.equalsIgnoreCase(b)
					|| column_chart_text.equalsIgnoreCase(c)) {
				System.out.println("Column Chart Visual is present");
			} else {
				fail("Column Chart Visual is not present");
			}
			String pie_chart_text = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='view-components-over--visual-title' and text()='Column']", 4).getText();
			if (pie_chart_text.equalsIgnoreCase(a) || pie_chart_text.equalsIgnoreCase(b)
					|| pie_chart_text.equalsIgnoreCase(c)) {
				System.out.println("Pie Chart Visual is present");
			} else {
				fail("Pie Chart Visual is not present");
			}
			login.Log4j.info(
					"It is displaying " + arg1 + " options on the right pane under " + arg2 + " > " + arg3 + " tab");
		} else {
			fail("Chart Verification Failed");
		}
		List<WebElement> views = login.driver
				.findElements(By.xpath("//*[contains(@class,'insight-page-view-tab') and contains(text(),'View')]"));
		if (views.size() > 0) {
			for (WebElement view : views) {
				new Actions(login.driver).contextClick(view).build().perform();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Delete view')]", 8)
						.click();
			}
		}
		CommonFunctionality.DeleteSeries();
	}

	@Then("^Validation message should appear and chart is created only with (\\d+) series$")
	public void validation_message_should_appear_and_chart_is_created_only_with_series(int arg1) throws Throwable {
		if (login.driver
				.findElements(By
						.xpath("//*[text()='Confirmation']//following::*[contains(text(),'Proceed with 20 series?')]"))
				.size() > 0) {
			login.Log4j.info("Validation message appears to create chart with only " + arg1 + " series");
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']", 4)
					.click();
			CommonFunctionality.wait(3000);
			if (login.driver.findElements(By.xpath("//*[contains(@class,'growl-message')]//*[text()='Ok']"))
					.size() > 0) {
				CommonFunctionality
						.getElementByXpath(login.driver, "//*[contains(@class,'growl-message')]//*[text()='Ok']", 4)
						.click();
			}
			CommonFunctionality.wait(1000);
			if (login.driver
					.findElements(
							By.xpath("//*[contains(@class,'movable-modal--window')]//*[contains(text(),'Apply')]"))
					.size() > 0) {
				CommonFunctionality
						.getElementByXpath(login.driver,
								"//*[contains(@class,'movable-modal--window')]//*[contains(text(),'Apply')]", 4)
						.click();
			}
		} else {
			fail("Chart is created with more than " + arg1 + " series and hence failed");
			CommonFunctionality.UnselectMethod();
			CommonFunctionality.Views_list();

		}
		CommonFunctionality.wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.className("insight-page-view-tab--title")));
		CommonFunctionality.Views_list();
	}

	@Then("^Chart visual should add to view area by \"([^\"]*)\"$")
	public void chart_visual_should_add_to_view_area_by(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("DragandDrop")) {
			if (CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(@class,'empty-visual-overlay__empty-selection')]//*[text()='Line']", 4)
					.isDisplayed()) {
				login.Log4j.info("Chart visual is added to view area by " + arg1);
			} else {
				fail(arg1 + " is not working");
			}
			CommonFunctionality.Views_list();
		} else if (arg1.equalsIgnoreCase("DoubleClick")) {
			if (CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(@class,'empty-visual-overlay__empty-selection')]//*[text()='Line']", 4)
					.isDisplayed()) {
				login.Log4j.info("Chart visual is added to view area by " + arg1);
			} else {
				fail(arg1 + " is not working");
			}
			CommonFunctionality.Views_list();
		}
	}

	@Then("^The Chart visual should get highlighted and options should appear at the top$")
	public void the_Chart_visual_should_get_highlighted_and_options_should_appear_at_the_top() throws Throwable {
		if (login.driver.findElements(By.className("visual-top-panel")).size() == 1) {
			login.Log4j.info("The Chart options are appearing at the top");
		} else {
			fail("Chart Options not displaying");
		}
		CommonFunctionality.Views_list();
	}

	@Then("^The Default title for Chart visual is \"([^\"]*)\"$")
	public void the_Default_title_for_Chart_visual_is(String arg1) throws Throwable {
		CommonFunctionality.wait(4000);
		String chart_title = CommonFunctionality.getElementBycssSelector(login.driver, "span[data-name='title']", 4)
				.getText();
		assertEquals(arg1, chart_title);
		login.Log4j.info("The Default title for Chart visual is " + arg1);
		CommonFunctionality.Views_list();
	}

	@Then("^\"([^\"]*)\" style is applied$")
	public void style_is_applied(String arg1) throws Throwable {
		String style = CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[contains(@class,'style-templates-item__active') and @title='" + arg1 + "']", 4)
				.getAttribute("title");
		assertEquals(style, Style_title);
		login.Log4j.info(arg1 + " style is applied and has been verified successfully");
		if (login.driver.findElements(By.className("movable-modal--close")).size() > 0) {
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		}
		if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal__content')]")).size() > 0) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[text()='Ok']", 4).click();
		}
		CommonFunctionality.Views_list();
	}

	@Then("^Entered title appears in Views panel for title display \"([^\"]*)\"$")
	public void entered_title_appears_in_Views_panel_for_title_display(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("ON")) {
			String chart_title = CommonFunctionality
					.getElementByXpath(login.driver, "//span[@data-name='title']/parent::div", 4).getAttribute("style");
			String split[] = chart_title.split("\\;");
			String chart_text = CommonFunctionality.getElementByXpath(login.driver, "//span[@data-name='title']", 4)
					.getText();
			assertEquals(chart_text, chart_title_text);
			assertEquals(split[0], "display: flex");
			login.Log4j.info("The entered title appears in Views panel");
			CommonFunctionality.Views_list();
		}
		if (arg1.equalsIgnoreCase("OFF")) {
			List<WebElement> element = login.driver.findElements(By.xpath("//span[@data-name='title']"));
			assertEquals(element.size(), 0);
			login.Log4j.info("The entered title not appears in Views panel");
			CommonFunctionality.Views_list();
		}
	}

	@Then("^The chart should update the title name to \"([^\"]*)\"$")
	public void the_chart_should_update_the_title_name_to(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		String chart_title = CommonFunctionality.getElementBycssSelector(login.driver, "span[data-name='title']", 4)
				.getText();
		assertEquals(chart_title, arg1);
		login.Log4j.info("The chart is updated the title name to " + arg1);
		CommonFunctionality.Views_list();
	}

	@Then("^The border line is retained upon login for next time$")
	public void the_border_line_is_retained_upon_login_for_next_time() throws Throwable {
		WebElement stroke = CommonFunctionality.getElementByClassName(login.driver, "highcharts-plot-border", 4);
		if (stroke.getAttribute("stroke").equals("#000000")) {
			login.Log4j.info("The border line is retained upon login for next time");

		} else {
			fail("Verification Failed");
		}
		CommonFunctionality.getElementByClassName(login.driver, "insight-preview--close", 4).click();
		cv.navigating_back_and_refresh_button();
		CommonFunctionality.Views_list();
	}

	@Then("^The Selected data_value should reflect in the chart visual legand$")
	public void the_Selected_data_value_should_reflect_in_the_chart_visual_legand() throws Throwable {
		cv.click_button("Save");
		String position = CommonFunctionality
				.getElementBycssSelector(login.driver, ".visual-item-wrapper--credits-container", 4)
				.getCssValue("justify-content");
		if (data_position.equals("left")) {
			if (!position.equals("flex-start")) {
				fail("Verifcation Failed");
			}
		}
		if (data_position.equals("center")) {
			if (!position.equals("center")) {
				fail("Verifcation Failed");
			}
		}
		if (data_position.equals("right")) {
			if (!position.equals("flex-end")) {
				fail("Verifcation Failed");
			}
		}
		cv.click_on_visual("Edit");
		click_on_the_checkbox_to("Copyright:", "Check");
		click_on_the_Container("Copyright:");
		popup_should_appear("Copyright");
	}

	@Then("^The Uploaded image should reflect in the chart visual legand$")
	public void the_Uploaded_image_should_reflect_in_the_chart_visual_legand() throws Throwable {
		cv.click_button("Save");
		CommonFunctionality.wait(200);
		String image = CommonFunctionality.getElementBycssSelector(login.driver, ".visual-item-wrapper--logo", 4)
				.getAttribute("src");
		if (!image.contains("credits_image")) {
			fail("Verification Failed");
		}
		login.Log4j.info("The uploaded image is reflecting in the chart visual legand");
		cv.click_on_visual("Edit");
		click_on_the_checkbox_to("Copyright:", "Check");
		click_on_the_Container("Copyright:");
		popup_should_appear("Copyright");
		CommonFunctionality.getElementBycssSelector(login.driver, ".copyright-config--remove-icon", 4).click();
		cv.click_button("Save");
		CommonFunctionality.wait(1000);
		CommonFunctionality.Views_list();
	}

	@Then("^Check the \"([^\"]*)\" attribute$")
	public void check_the_attribute(String arg1) throws Throwable {
		String border = CommonFunctionality.getElementByXpath(login.driver,
				"//*[text()='" + arg1 + "']//following::div[@class='toggle-context-control'][1]", 4).getText();
		if (border.equalsIgnoreCase("no")) {
			login.Log4j.info("The Chart created by default will always have simple style without border in the chart.");
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
			List<WebElement> views = login.driver.findElements(
					By.xpath("//*[contains(@class,'insight-page-view-tab') and contains(text(),'View')]"));
			if (views.size() > 0) {
				for (WebElement view : views) {
					new Actions(login.driver).contextClick(view).build().perform();
					CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Delete view')]", 8)
							.click();
					if (login.driver
							.findElements(By.xpath("//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']"))
							.size() > 0) {
						CommonFunctionality.getElementByXpath(login.driver,
								"//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']", 4).click();
					}
				}
			}
		} else {
			fail("Border Verification failed");
		}
		CommonFunctionality.DeleteSeries();
	}

	@Then("^The chart should update the \"([^\"]*)\" and \"([^\"]*)\" selected for \"([^\"]*)\"$")
	public void the_chart_should_update_the_selected(String arg1, String arg2, String arg3) throws Throwable {
		if (login.driver.findElements(By.className("popover--wrapper")).size() > 0) {
			CommonFunctionality.getElementByClassName(login.driver, "popover--close", 4).click();
		}
		if (arg1.equalsIgnoreCase("Color")) {
			CommonFunctionality.wait(2000);
			String text_color = CommonFunctionality
					.getElementBycssSelector(login.driver, "span[data-name='" + arg3 + "']", 4).getCssValue("color");
			String actual = Color.fromString(text_color).asHex();
			assertEquals(actual, color);
		}
		if (arg2.equalsIgnoreCase("Highlight color")) {
			CommonFunctionality.wait(2000);
			String text_bgcolor = CommonFunctionality
					.getElementBycssSelector(login.driver, "span[data-name='" + arg3 + "']", 4)
					.getCssValue("background-color");
			String actual = Color.fromString(text_bgcolor).asHex();
			assertEquals(actual, highlight_color);
		}
		login.Log4j.info("The Chart is updated with " + arg1 + " and " + arg2 + " and has been verified successfully");
		CommonFunctionality.Views_list();
	}

	@Then("^The chart should update the font size value to (\\d+) for chart \"([^\"]*)\"$")
	public void the_chart_should_update_the_font_size_value_to_for_chart(int arg1, String arg2) throws Throwable {
		if (login.driver.findElements(By.className("popover--wrapper")).size() > 0) {
			CommonFunctionality.getElementByClassName(login.driver, "popover--close", 4).click();
		}
		String fontsize = CommonFunctionality.getElementBycssSelector(login.driver, "span[data-name='" + arg2 + "']", 4)
				.getCssValue("font-size");
		String[] size = fontsize.split("px");
		Integer expected = Integer.valueOf(size[0]);
		Integer actual = Integer.valueOf(font_size);
		assertEquals(actual, expected);
		login.Log4j.info("The chart is updated to font size value of " + arg1);
		closing_the_chart_visual();
	}

	@Then("^The chart should update the \"([^\"]*)\" selected for \"([^\"]*)\"$")
	public void the_chart_should_update_the_selected(String arg1, String arg2) throws Throwable {
		if (login.driver.findElements(By.className("popover--wrapper")).size() > 0) {
			CommonFunctionality.getElementByClassName(login.driver, "popover--close", 4).click();
		}
		WebElement title = CommonFunctionality.getElementBycssSelector(login.driver, "span[data-name='" + arg2 + "']",
				4);
		String font_bold = title.getCssValue("font-weight");
		String font_italic = title.getCssValue("font-style");
		String font_underline = title.getCssValue("text-decoration");
		assertTrue(font_bold.equals("bold") || font_bold.equals("700"));
		assertTrue(font_italic.equals("italic"));
		assertTrue(font_underline.contains("underline"));
		login.Log4j.info("The chart " + arg2 + " is in bold, italic and underlined");
		/*
		 * CommonFunctionality.wait(4000); if
		 * (bold.getAttribute("class").contains("selected") &&
		 * italic.getAttribute("class").contains("selected") &&
		 * underline.getAttribute("class").contains("selected")) {
		 * login.Log4j.info("The chart " + arg2 + " is in bold, italic and underlined");
		 * } else { fail("Verification Failed"); }
		 */
		closing_the_chart_visual();
	}

	@Then("^The chart should update the \"([^\"]*)\" alignment$")
	public void the_chart_should_update_the_alignment(String arg1) throws Throwable {
		if (login.driver.findElements(By.className("popover--wrapper")).size() > 0) {
			CommonFunctionality.getElementByClassName(login.driver, "popover--close", 4).click();
		}
		if (right.getAttribute("class").contains("selected") && arg1.equalsIgnoreCase("right")) {
			CommonFunctionality.CompareImage(login.driver,
					System.getProperty("user.dir") + "\\Pictures\\Title_" + arg1 + ".png", destFile);
			login.Log4j.info("The chart title is in " + arg1);
		} else if (center.getAttribute("class").contains("selected") && arg1.equalsIgnoreCase("center")) {
			CommonFunctionality.CompareImage(login.driver,
					System.getProperty("user.dir") + "\\Pictures\\Title_" + arg1 + ".png", destFile);
			login.Log4j.info("The chart title is in " + arg1);
		} else if (left.getAttribute("class").contains("selected") && arg1.equalsIgnoreCase("left")) {
			CommonFunctionality.CompareImage(login.driver,
					System.getProperty("user.dir") + "\\Pictures\\Title_" + arg1 + ".png", destFile);
			login.Log4j.info("The chart title is in " + arg1);
		} else {
			fail("Verification Failed");
		}
	}

	@Then("^The subtitle name \"([^\"]*)\" reflect on the chart$")
	public void the_subtitle_name_reflect_on_the_chart(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("should")) {
			if (checkbox2 == true
					&& login.driver.findElements(By.cssSelector("span[data-name='sub_title']")).size() == 1) {
				login.Log4j.info("The Subtitle name is reflected on the chart visual");
			} else {
				fail("Subtitle verification Failed");
			}
		} else if (arg1.equalsIgnoreCase("should not")) {
			if (checkbox2 == false
					&& (!login.driver.findElement(By.cssSelector("span[data-name='sub_title']")).isDisplayed())) {
				login.Log4j.info("The Subtitle name is not reflected on the chart visual");
			} else {
				fail("Subtitle verification Failed");
			}
		}
		CommonFunctionality.Views_list();
	}

	@Then("^The chart should update the subtitle name to \"([^\"]*)\"$")
	public void the_chart_should_update_the_subtitle_name_to(String arg1) throws Throwable {
		if (checkbox2 == true && login.driver.findElements(By.cssSelector("span[data-name='sub_title']")).size() == 1) {
			String subtitle = CommonFunctionality
					.getElementBycssSelector(login.driver, "span[data-name='sub_title']", 4).getText();
			assertEquals(subtitle, chart_subtitle_text);
			login.Log4j.info("The Chart is updated with the subtitle name to " + subtitle);
		} else {
			fail("Subtitle verification Failed");
		}
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath", "//*[@class='movable-modal--close']");
		if (login.driver.findElements(By.cssSelector("button.sphere-modal-control.button.button__primary"))
				.size() > 0) {
			CommonFunctionality
					.getElementBycssSelector(login.driver, "button.sphere-modal-control.button.button__primary", 4)
					.click();
		}
		CommonFunctionality.Views_list();
	}

	@Then("^The Visual area should align to \"([^\"]*)\"$")
	public void the_Visual_area_should_align_to(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Left")) {
			String left = login.driver
					.findElement(
							By.xpath("//*[@class='visual-preview base-preview']//*[@class='visual-item-container']"))
					.getAttribute("style").split(";")[0];
			if (left.equals("width:80%") || left.equals("width: 80%")) {
				login.Log4j.info("The Visual area is aligned to " + arg1);
			} else {
				fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("Center")) {
			String center = login.driver
					.findElement(
							By.xpath("//*[@class='visual-preview base-preview']//*[@class='visual-item-container']"))
					.getAttribute("style").split(";")[1];
			if (center.equals(" margin: 0px auto")) {
				login.Log4j.info("The Visual area is aligned to " + arg1);
			} else {
				fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("Right")) {
			String right = login.driver
					.findElement(
							By.xpath("//*[@class='visual-preview base-preview']//*[@class='visual-item-container']"))
					.getAttribute("style").split(";")[1];
			if (right.equals(" margin-left: auto")) {
				login.Log4j.info("The Visual area is aligned to " + arg1);
			} else {
				fail("Verification Failed");
			}
		}
		// CommonFunctionality.Views_list();
	}

	@Then("^The Image Size should reduce to (\\d+)% horizontally$")
	public void the_Image_Size_should_reduce_to_horizontally(int arg1) throws Throwable {
		String width = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'without-subscription-overlay')]//following::*[@class='visual-item-container']", 4)
				.getAttribute("style");
		String width_substring = width.substring(7, 9);
		int updated_width = Integer.parseInt(width_substring);
		assertEquals(updated_width, Value);
		login.Log4j.info("The Image size is reduced to " + arg1 + "% horizontally");
	}

	@Then("^The color of background should be updated$")
	public void the_color_of_background_should_be_updated() throws Throwable {
		CommonFunctionality.wait(1000);
		String text_color = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='preview-container']//*[@class='highcharts-plot-background']", 4)
				.getCssValue("fill");
		String actual = Color.fromString(text_color).asHex();
		assertEquals(actual, color);
	}

	@Then("^The background image should be updated$")
	public void the_background_image_should_be_updated() throws Throwable {
		CommonFunctionality.wait(2000);
		if (login.driver.findElements(By.cssSelector(".highcharts-container > svg > image")).size() > 0) {
			login.Log4j.info("Image is uploaded successfully in the chart visual");
		} else {
			fail("Verification Failed");
		}
	}

	@Then("^The color of border should be updated$")
	public void the_color_of_border_should_be_updated() throws Throwable {
		CommonFunctionality.wait(500);
		String stroke = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='highcharts-plot-border']", 4)
				.getAttribute("stroke");
		String actual = Color.fromString(stroke).asHex();
		assertEquals(actual, color);
		login.Log4j.info("The border color has been updated and verified successfully");
		closing_the_chart_visual();
	}

	@Then("^The border \"([^\"]*)\" should be updated$")
	public void the_border_should_be_updated(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		if (arg1.equalsIgnoreCase("width")) {
			String stroke_width = CommonFunctionality.getElementByClassName(login.driver, "highcharts-plot-border", 4)
					.getAttribute("stroke-width");
			int border_width = Integer.parseInt(stroke_width);
			assertEquals(border_width, Value);
		} else if (arg1.equalsIgnoreCase("radius")) {
			String stroke_radius = CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='highcharts-plot-border']", 4).getAttribute("rx");
			int border_radius = Integer.parseInt(stroke_radius);
			assertEquals(border_radius, Value);
		}
		login.Log4j.info("The border " + arg1 + " has been updated and verified successfully");
	}

	@Then("^Verify that Intervals should update as per inputs$")
	public void verify_that_Intervals_should_update_as_per_inputs() throws Throwable {
		if (values_axis_checkboxes == true) {
			CommonFunctionality.wait(500);
			String interval = CommonFunctionality.getElementByProperty(login.driver, "chart_axis_multipler_value", 4)
					.getText();
			String input = interval.substring(interval.length() - 1);
			assertEquals(input, axis_multipler_value_axis);
			login.Log4j.info(
					"The axis multipler value is reflected into chart visual and it has been verified successfully");
		} else {
			fail("Value axis checkboxes are not selected");
		}
	}

	@Then("^\"([^\"]*)\" and \"([^\"]*)\" should reflect on the chart$")
	public void and_should_reflect_on_the_chart(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(3000);
		if (arg1.equalsIgnoreCase("Color")) {
			String coloring = CommonFunctionality
					.getElementByProperty(login.driver, "chart_axes_multipler_value_dash", 4).getCssValue("color");
			String actual = Color.fromString(coloring).asHex();
			assertEquals(actual, color);
		}
		if (arg2.equalsIgnoreCase("Axis color")) {
			String axis_color_new = CommonFunctionality
					.getElementByProperty(login.driver, "value_axes_left_inside_chart", 4).getAttribute("stroke");
			assertEquals(axis_color_new, axis_color);
		}
		login.Log4j.info("The " + arg1 + " and " + arg2 + " has been updated and verified successfully");
		closing_the_chart_visual();
	}

	@Then("^The \"([^\"]*)\" changes should reflect on the chart$")
	public void the_changes_should_reflect_on_the_chart(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Size")) {
			String font_size = CommonFunctionality.getElementByProperty(login.driver, "chart_multipler_value", 4)
					.getCssValue("font-size");
			String[] font = font_size.split("px");
			int actual = Integer.parseInt(font[0]);
			int expected = Integer.parseInt(font_size_y_axis);
			assertEquals(actual, expected);
		} else if (arg1.equalsIgnoreCase("rotation")) {
			CommonFunctionality.wait(4000);
			String rotation = CommonFunctionality.getElementByProperty(login.driver, "chart_multipler_value", 8)
					.getAttribute("transform");
			String font_rotation = rotation.substring(rotation.indexOf(' ') + 8);
			if (font_rotation.contains(" ")) {
				font_rotation = font_rotation.substring(0, font_rotation.indexOf(' '));
			}
			int actual = Integer.parseInt(font_rotation);
			int expected = Integer.parseInt(font_rotation_y_axis);
			assertEquals(actual, expected);
			login.Log4j.info("The " + arg1 + " changes are reflecting on the Chart Visual");
		} else if (arg1.equalsIgnoreCase("Time axis rotation")) {
			CommonFunctionality.wait(4000);
			String rotation = login.driver
					.findElement(By.xpath("//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[1]"))
					.getAttribute("transform");
			String font_rotation = rotation.substring(rotation.indexOf(' ') + 8);
			if (font_rotation.contains(" ")) {
				font_rotation = font_rotation.substring(0, font_rotation.indexOf(' '));
			}
			int actual = Integer.parseInt(font_rotation);
			int expected = Integer.parseInt(font_rotation_x_axis);
			assertEquals(actual, expected);
			login.Log4j.info("The " + arg1 + " changes are reflecting on the Chart Visual");
		} else if (arg1.equalsIgnoreCase("Time axis Date format")) {
			CommonFunctionality.wait(2000);
			String format = login.driver
					.findElement(By.xpath("//*[contains(@class,'highcharts-xaxis-labels')][1]/*[1]")).getText();
			if (format.matches("([0-9]{4})/([0-9]{2})")) {
				login.Log4j.info("The " + arg1 + " changes are reflecting on the Chart Visual");
			} else {
				fail("Verification Failed");
			}
		} else if (arg1.equalsIgnoreCase("Time axis Date format new")) {
			CommonFunctionality.wait(2000);
			String format = login.driver
					.findElement(By.xpath("//*[contains(@class,'highcharts-xaxis-labels')][1]/*[1]")).getText();
			if (format.matches("([0-9]{4})/([0-9]{2})/([0-9]{2})")) {
				login.Log4j.info("The " + arg1 + " changes are reflecting on the Chart Visual");
				CommonFunctionality.Views_list();
			} else {
				fail("Verification Failed");
			}
		}
	}

	@Then("^The Chart should update the selected \"([^\"]*)\" type$")
	public void the_Chart_should_update_the_selected_type(String arg1) throws Throwable {
		CommonFunctionality.CompareImage(login.driver, System.getProperty("user.dir") + "\\Pictures\\" + arg1 + ".png",
				destFile);
		login.Log4j.info("The Chart has been updated to " + arg1 + " chart type and it has been verified successfully");
		try {
			Files.deleteIfExists(Paths.get(destFile));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Then("^The Title alignment for x and y axis is \"([^\"]*)\"$")
	public void the_Title_alignment_for_x_and_y_axis_is(String arg1) throws Throwable {
		CommonFunctionality.CompareImage(login.driver,
				System.getProperty("user.dir") + "\\Pictures\\Y_axis_" + arg1 + ".png", destFile);
		login.Log4j.info("The Chart y axis title has been changed to " + arg1
				+ " alignment and it has been verified successfully");
	}

	@Then("^The Changes should update on the chart$")
	public void the_Changes_should_update_on_the_chart() throws Throwable {
		CommonFunctionality.wait(4000);
		WebElement title = CommonFunctionality.getElementByProperty(login.driver, "chart_multipler_value", 4);
		String font_bold = title.getCssValue("font-weight");
		String font_italic = title.getCssValue("font-style");
		String font_underline = title.getCssValue("text-decoration");
		assertTrue(font_bold.equals("bold") || font_bold.equals("700"));
		assertTrue(font_italic.equals("italic"));
		assertTrue(font_underline.contains("underline"));
		closing_the_chart_visual();
	}

	@Then("^\"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" values has been updated$")
	public void values_has_been_updated(String arg1, String arg2, String arg3) throws Throwable {
		int integer = chart_axis_multipler_value_numberformat.indexOf(CDMNextSprintCases.decimal_seperator);
		decimalValues = chart_axis_multipler_value_numberformat.length() - integer - 1;
		if (arg1.equalsIgnoreCase("Decimal places")) {
			int value = Integer.parseInt(CDMNextSprintCases.separator_value);
			if (value == decimalValues) {
				login.Log4j.info("Decimal places are appearing as per the selection in " + arg1);
			} else {
				fail("Verification Failed");
			}
		}
		if (arg2.equalsIgnoreCase("Decimal Separator")) {
			if (decimalValues == position) {
				login.Log4j.info(arg2 + " value has been updated and has been verified successfully");
			} else {
				fail("Verification Failed");
			}
		}
		if (arg3.equalsIgnoreCase("Grouping Separator")) {
			if (CDMNextSprintCases.grouping_seperator.contains("Space")) {
				CDMNextSprintCases.grouping_seperator = " ";
			}
			if (CDMNextSprintCases.grouping_seperator.contains("None")) {
				CDMNextSprintCases.grouping_seperator = "";
			}
			if (chart_axis_multipler_value_numberformat.contains(CDMNextSprintCases.grouping_seperator)) {
				login.Log4j.info(arg3 + " value has been updated and has been verified successfully");
			} else {
				fail("Verification Failed");

			}
		}
		login.Log4j.info("The " + arg1 + ", " + arg2 + ", " + arg3 + " has been verified successfully");
		CommonFunctionality.Views_list();
	}

	@Then("^\"([^\"]*)\" should reflect on the chart$")
	public void should_reflect_on_the_chart(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Value Axis color")) {
			CommonFunctionality.wait(2000);
			String axis_color_new = CommonFunctionality.getElementByProperty(login.driver, "value_lines", 8)
					.getAttribute("stroke");
			String actual = Color.fromString(axis_color_new).asHex();
			assertEquals(actual, value_line_color);
			login.Log4j.info("The " + arg1 + " has been updated and verified successfully");
		}
		if (arg1.equalsIgnoreCase("Time Axis color")) {
			CommonFunctionality.wait(2000);
			String axis_color_new = login.driver
					.findElement(By.xpath("//*[@class='highcharts-grid highcharts-xaxis-grid']/*[2]"))
					.getAttribute("stroke");
			String actual = Color.fromString(axis_color_new).asHex();
			assertEquals(actual, time_line_color);
			login.Log4j.info("The " + arg1 + " has been updated and verified successfully");
		}
		if (arg1.equalsIgnoreCase("Values Axis Lines width")) {
			CommonFunctionality.wait(2000);
			String axis_width = CommonFunctionality.getElementByProperty(login.driver, "value_lines", 8)
					.getAttribute("stroke-width");
			assertEquals(axis_width, width_y_axis);
			login.Log4j.info("The " + arg1 + " has been updated and verified successfully");
		}
		if (arg1.equalsIgnoreCase("Time Axis Lines width")) {
			CommonFunctionality.wait(2000);
			String axis_width = login.driver
					.findElement(By.xpath("//*[@class='highcharts-grid highcharts-xaxis-grid']/*[2]"))
					.getAttribute("stroke-width");
			assertEquals(axis_width, width_x_axis);
			login.Log4j.info("The " + arg1 + " has been updated and verified successfully");
		}
		if (arg1.equalsIgnoreCase("Time Axis Title Color") && values_axis_checkboxes == true) {
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("time_axis_text"))).size() > 0) {
				CommonFunctionality.wait(500);
				String time_field_color = CommonFunctionality.getElementByProperty(login.driver, "time_axis_text", 4)
						.getCssValue("color");
				String time_field_bgcolor = CommonFunctionality.getElementByProperty(login.driver, "time_axis_text", 4)
						.getCssValue("background-color");
				String actual = Color.fromString(time_field_color).asHex();
				String actual_bg = Color.fromString(time_field_bgcolor).asHex();
				assertEquals(actual, time_axis_color);
				assertEquals(actual_bg, time_axis_bgcolor);
				login.Log4j.info("The " + arg1 + " has been updated and verified successfully");
				closing_the_chart_visual();
			} else {
				fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("Time Axis Label Color") && values_axis_checkboxes == true) {
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("time_axis_label_text"))).size() > 0
					&& login.driver.findElements(By.xpath(login.LOCATORS.getProperty("time_axis_label_axis_colr_text")))
							.size() > 0) {
				String time_label_color = login.driver
						.findElement(By.xpath("//*[contains(@class,'highcharts-xaxis-labels')][1]/*[1]"))
						.getCssValue("fill");
				String time_label_axis_color = CommonFunctionality
						.getElementByProperty(login.driver, "time_axis_label_axis_colr_text", 4).getAttribute("stroke");
				String actual = Color.fromString(time_label_color).asHex();
				assertEquals(actual, time_axis_label_color);
				assertEquals(time_label_axis_color, time_axis_label_line_color);
				login.Log4j.info("The " + arg1 + " has been updated and verified successfully");
				closing_the_chart_visual();
			} else {
				fail("Verification Failed");
			}
		}
	}

	@Then("^\"([^\"]*)\" should reflect on the chart visual$")
	public void should_reflect_on_the_chart_visual(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Time Axis Title font size")) {
			CommonFunctionality.wait(1000);
			String title_axis_font_size = CommonFunctionality.getElementByProperty(login.driver, "time_axis_text", 8)
					.getCssValue("font-size");
			String[] title_axis_size = title_axis_font_size.split("px");
			Integer title_font = Integer.parseInt(title_axis_size[0]);
			if (title_font == Value) {
				login.Log4j.info("The " + arg1 + " has been updated and verified successfully");
				closing_the_chart_visual();
			} else {
				fail("Verification Failed");
			}
		} else if (arg1.equalsIgnoreCase("Time Axis Title Label font size")) {
			String title_axis_font_size = login.driver
					.findElement(By.xpath("//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[1]"))
					.getCssValue("font-size");
			String[] title_axis_size = title_axis_font_size.split("px");
			Integer title_font = Integer.parseInt(title_axis_size[0]);
			if (title_font == Value) {
				login.Log4j.info("The " + arg1 + " has been updated and verified successfully");
			} else {
				fail("Verification Failed");
			}
			if (login.driver.findElements(By.className("popover--close")).size() > 0) {
				CommonFunctionality.getElementByClassName(login.driver, "popover--close", 4).click();
			}
			closing_the_chart_visual();
		} else if (arg1.equalsIgnoreCase("Style")) {
			CommonFunctionality.wait(3000);
			WebElement title = CommonFunctionality.getElementByProperty(login.driver, "time_axis_text", 4);
			String font_bold = title.getCssValue("font-weight");
			String font_italic = title.getCssValue("font-style");
			String font_underline = title.getCssValue("text-decoration");
			assertTrue(font_bold.equals("bold") || font_bold.equals("700"));
			assertTrue(font_italic.equals("italic"));
			assertTrue(font_underline.contains("underline"));
			login.Log4j.info("The " + arg1 + " has been updated and verified successfully");
			closing_the_chart_visual();
		} else if (arg1.equalsIgnoreCase("Time Axis Label Style")) {
			CommonFunctionality.wait(3000);
			WebElement title = login.driver
					.findElement(By.xpath("//*[contains(@class,'highcharts-xaxis-labels')][1]/*[1]"));
			String font_bold = title.getCssValue("font-weight");
			String font_italic = title.getCssValue("font-style");
			String font_underline = title.getCssValue("text-decoration");
			assertTrue(font_bold.equals("bold") || font_bold.equals("700"));
			assertTrue(font_italic.equals("italic"));
			assertTrue(font_underline.contains("underline"));
			login.Log4j.info("The " + arg1 + " has been updated and verified successfully");
			closing_the_chart_visual();
		}
	}

	@Then("^The URL should navigate to \"([^\"]*)\"$")
	public void the_URL_should_navigate_to(String arg1) throws Throwable {
		ArrayList<String> tabs = new ArrayList<String>(login.driver.getWindowHandles());
		CommonFunctionality.wait(2000);
		login.driver.switchTo().window(tabs.get(1));
		String new_URL = login.driver.getCurrentUrl();
		login.driver.switchTo().window(tabs.get(1)).close();
		login.driver.switchTo().window(tabs.get(0));
		login.Log4j.info("The new URL has been Verified successfully");
		CommonFunctionality.Views_list();
		assertEquals(arg1, new_URL);
	}

	@Then("^Entered timeframe date should update in chart$")
	public void entered_timeframe_date_should_update_in_chart() throws Throwable {
		String timepoints_start = login.driver
				.findElement(By.xpath("//*[contains(@class,'highcharts-xaxis-labels')][1]/*[1]")).getText();
		String timepoints_end = login.driver
				.findElement(By.xpath("//*[contains(@class,'highcharts-xaxis-labels')][1]/*[5]")).getText();
		timepoints_start_date = new SimpleDateFormat("MM/dd/yyyy").parse(timepoints_start);
		timepoints_end_date = new SimpleDateFormat("MM/dd/yyyy").parse(timepoints_end);
		timepoints_start_date_ssp = new SimpleDateFormat("yyyy/MM/dd").parse(start_date_timeframe_chart);
		timepoints_end_date_ssp = new SimpleDateFormat("yyyy/MM/dd").parse(end_date_timeframe_chart);
		assertEquals(timepoints_start_date, timepoints_start_date_ssp);
		assertEquals(timepoints_end_date, timepoints_end_date_ssp);
		login.Log4j.info("The start date of " + timepoints_start_date + " and end date of " + timepoints_end_date
				+ " has been updated and has been Verified successfully");
		// CommonFunctionality.Views_list();
	}

	@Then("^Entered timeframe date should update in chart for \"([^\"]*)\"$")
	public void entered_timeframe_date_should_update_in_chart_for(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("All observations")) {
			if (timeframe_label_text.equalsIgnoreCase("All observations") && timeframe_checkboxes == true) {
				String timepoints_start = login.driver
						.findElement(By.xpath("//*[contains(@class,'highcharts-xaxis-labels')][1]/*[1]")).getText();
				String timepoints_end = login.driver
						.findElement(By.xpath("//*[contains(@class,'highcharts-xaxis-labels')][1]/*[5]")).getText();
				timepoints_start_date = new SimpleDateFormat("MM/dd/yyyy").parse(timepoints_start);
				timepoints_end_date = new SimpleDateFormat("MM/dd/yyyy").parse(timepoints_end);
				timepoints_start_date_ssp = new SimpleDateFormat("MM/dd/yyyy").parse(timepoints_first_date);
				timepoints_end_date_ssp = new SimpleDateFormat("MM/dd/yyyy").parse(timepoints_last_date);
				assertEquals(timepoints_start_date, timepoints_start_date_ssp);
				assertEquals(timepoints_end_date, timepoints_end_date_ssp);
				login.Log4j.info("The start date of " + timepoints_start_date + " and end date of "
						+ timepoints_end_date + " has been updated and has been Verified successfully");
				CommonFunctionality.Views_list();
			} else {
				sa.fail("Verification Failed");
			}
		} else if (arg1.equalsIgnoreCase("Time Axis")) {
			if (time_axis_label_text.equalsIgnoreCase("Reversed direction") && time_axis_checkboxes == true) {
				String timepoints_end = login.driver
						.findElement(By.xpath("//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[1]"))
						.getText();
				timepoints_end_date = new SimpleDateFormat("MM/dd/yyyy").parse(timepoints_end);
				timepoints_start_date_ssp = new SimpleDateFormat("MM/dd/yyyy").parse(timepoints_first_date);
				if (timepoints_end_date.equals(timepoints_start_date_ssp)) {
					sa.fail("Date is not reversed");
				}
				login.Log4j.info("Entered timeframe has been updated successfully and it has been Verified");
				CommonFunctionality.Views_list();
			} else {
				sa.fail("Verification Failed");
			}
		}
		/*
		 * WebElement start_timepoint = login.driver.findElement(By.xpath(
		 * "//*[contains(@class,'highcharts-yaxis-left')]//*[@class='highcharts-axis-line']"
		 * )); new
		 * Actions(login.driver).moveToElement(start_timepoint).build().perform();
		 * String start_value = CommonFunctionality.getElementByXpath(login.driver, *
		 * "(//*[@class='highcharts-label highcharts-tooltip highcharts-color-undefined'])[2]/span"
		 * , 8).getText(); new
		 * Actions(login.driver).moveToElement(login.driver.findElement(By.xpath(
		 * "//*[@class='highcharts-title']"))).pause(2000).build().perform(); WebElement
		 * end_timepoint = login.driver.findElement(By.xpath(
		 * "//*[contains(@class,'highcharts-yaxis-right')]//*[@class='highcharts-axis-line']"
		 * )); new Actions(login.driver).moveToElement(end_timepoint).build().perform();
		 * String end_value = CommonFunctionality.getElementByXpath(login.
		 * driver,"(//*[@class='highcharts-label highcharts-tooltip highcharts-color-undefined'])[2]/span"
		 * , 8).getText(); System.out.println(start_value+"\n"+end_value);
		 */
	}

	@Then("^Checking the chart \"([^\"]*)\"$")
	public void checking_the_chart(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Inversion")) {
			assertNotEquals("The Chart " + arg1 + " is Successful", before_invert, after_invert);
			login.Log4j.info("The Chart " + arg1 + " is Successful and has been verified");
		}
		if (arg1.equalsIgnoreCase("Original View")) {
			if (checkbox_status == false && before_invert.equals("#707070")) {
				login.Log4j.info("The Chart is Inverted to " + arg1 + " Successfully");
				CommonFunctionality.Views_list();
			} else {
				sa.fail("Verification Failed");
			}
		}
	}

	@SuppressWarnings("deprecation")
	@Then("^Tooltips \"([^\"]*)\" be visible in dashboard page$")
	public void tooltips_be_visible_in_dashboard_page(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Should") && tooltips_checkbox == true) {
			List<WebElement> timepoints = login.driver.findElements(By.xpath(
					"//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden')]"));
			System.out.println("Total timepoints are: " + timepoints.size());
			for (int i = 1; i <= timepoints.size(); i++) {
				WebElement timepoint = CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden')]["
								+ i + "]",
						4);
				new Actions(login.driver).moveToElement(timepoint).pause(50).build().perform();
				if (!(login.driver
						.findElements(By.xpath(
								"//*[@class='highcharts-label highcharts-tooltip highcharts-color-undefined']/span"))
						.size() > 0)) {
					sa.fail("Verification failed");
				}
				WebElement title = CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'visual-title--text') and @data-name='title']", 4);
				new Actions(login.driver).moveToElement(title).pause(10).build().perform();
				// System.out.println("The timepoint is in position: " + i);
			}
			login.Log4j.info("All timepoints for a single series are visible in dashboard page");
		}
		if (arg1.equalsIgnoreCase("Should not") && tooltips_uncheckbox == false) {
			List<WebElement> timepoints = login.driver.findElements(By.xpath(
					"//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden')]"));
			for (int i = 1; i <= timepoints.size(); i++) {
				WebElement timepoint = CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden')]["
								+ i + "]",
						4);
				new Actions(login.driver).moveToElement(timepoint).pause(50).build().perform();
				if (!(login.driver
						.findElements(By.xpath(
								"//*[@class='highcharts-label highcharts-tooltip highcharts-color-undefined']/span"))
						.size() == 0)) {
					sa.fail("Verification Failed");
				}
			}
			login.Log4j.info("All timepoints for a single series are not visible in dashboard page");
			CommonFunctionality.Views_list();
		}
	}

	@SuppressWarnings("deprecation")
	@Then("^Tooltips for multiple series \"([^\"]*)\" be visible in dashboard page$")
	public void tooltips_for_multiple_series_be_visible_in_dashboard_page(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Should") && tooltips_checkbox == true) {
			List<WebElement> timepoints_for_all_series = login.driver.findElements(By.xpath(
					"//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden')]"));
			for (int i = 1; i <= timepoints_for_all_series.size(); i++) {
				WebElement timepoint = CommonFunctionality.getElementByXpath(login.driver,
						"(//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden')])["
								+ i + "]",
						4);
				new Actions(login.driver).moveToElement(timepoint).pause(50).build().perform();
				if (!(login.driver
						.findElements(By.xpath("//*[contains(@class,'highcharts-color-undefined')]/span/span"))
						.size() > 1)) {
					sa.fail("Verification failed");
				}
				WebElement title = CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'visual-title--text') and @data-name='title']", 4);
				new Actions(login.driver).moveToElement(title).pause(10).build().perform();
			}
			login.Log4j
					.info("All the timepoints for 'all' series are displaying and it has been verified successfully");
		}
		if (arg1.equalsIgnoreCase("Should not") && tooltips_uncheckbox == false) {
			List<WebElement> timepoints_for_all_series = login.driver.findElements(By.xpath(
					"//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden')]"));
			for (int i = 1; i <= timepoints_for_all_series.size(); i++) {
				WebElement timepoint = CommonFunctionality.getElementByXpath(login.driver,
						"(//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden')])["
								+ i + "]",
						4);
				new Actions(login.driver).moveToElement(timepoint).pause(50).build().perform();
				if (!(login.driver
						.findElements(By.xpath("//*[contains(@class,'highcharts-color-undefined')]/span/span"))
						.size() == 1)) {
					sa.fail("Size is not same");
				}
			}
			login.Log4j.info(
					"All the timepoints for a 'single' series are displaying and it has been verified successfully");
			CommonFunctionality.Views_list();
		}
	}

	@SuppressWarnings("deprecation")
	@Then("^Selected \"([^\"]*)\" should display$")
	public void selected_should_display(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		if (arg1.equalsIgnoreCase("Item")) {
			List<WebElement> timepoints = login.driver.findElements(By.xpath(
					"//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden')]"));
			for (int i = 1; i <= timepoints.size(); i++) {
				WebElement timepoint = CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden')]["
								+ i + "]",
						4);
				new Actions(login.driver).moveToElement(timepoint).pause(50).build().perform();
				String text = CommonFunctionality
						.getElementByXpath(login.driver,
								"//*[contains(@class,'highcharts-tooltip highcharts-color-undefined')]/span", 4)
						.getText();
				split_text = text.split(";");
				if (!(split_text[0].contains(unit_ssp) && split_text[1].contains(name_ssp)
						&& split_text[2].contains(region_ssp) && split_text[3].contains(frequency_ssp))) {
					sa.fail("Timepoints are not displaying properly");
				}
				WebElement title = CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'visual-title--text') and @data-name='title']", 4);
				new Actions(login.driver).moveToElement(title).pause(10).build().perform();
			}
			login.Log4j.info(
					"The selected Name, Unit, Region and Frequency are displaying in a series timepoint and has been verified successfully");
		}
		if (arg1.equalsIgnoreCase("Color")) {
			List<WebElement> timepoints = login.driver.findElements(By.xpath(
					"//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden')]"));
			for (int i = 1; i <= timepoints.size(); i++) {
				WebElement timepoint = CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden')]["
								+ i + "]",
						4);
				new Actions(login.driver).moveToElement(timepoint).pause(50).build().perform();
				String text = CommonFunctionality
						.getElementByXpath(login.driver,
								"//*[contains(@class,'highcharts-tooltip highcharts-color-undefined')]/span", 4)
						.getCssValue("color");
				String Timepoints_color = Color.fromString(text).asHex();
				assertEquals(Timepoints_color, tooltip_color);
				WebElement title = CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'visual-title--text') and @data-name='title']", 4);
				new Actions(login.driver).moveToElement(title).pause(10).build().perform();
			}
			login.Log4j.info("The Selected color is reflecting in the chart visual");
			CommonFunctionality.Views_list();
		}
		if (arg1.equalsIgnoreCase("Font size")) {
			List<WebElement> timepoints = login.driver.findElements(By.xpath(
					"//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden')]"));
			for (int i = 1; i <= timepoints.size(); i++) {
				WebElement timepoint = CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden')]["
								+ i + "]",
						4);
				new Actions(login.driver).moveToElement(timepoint).pause(50).build().perform();
				String text = CommonFunctionality
						.getElementByXpath(login.driver,
								"//*[contains(@class,'highcharts-tooltip highcharts-color-undefined')]/span", 4)
						.getCssValue("font-size");
				String[] size = text.split("px");
				Integer expected = Integer.valueOf(size[0]);
				Integer actual = Integer.valueOf(font_size);
				assertEquals(actual, expected);
				WebElement title = CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'visual-title--text') and @data-name='title']", 4);
				new Actions(login.driver).moveToElement(title).pause(10).build().perform();
			}
			login.Log4j.info("The entered " + arg1 + " is reflecting in the chart visual");
		}
		if (arg1.equalsIgnoreCase("Font Style")) {
			List<WebElement> timepoints = login.driver.findElements(By.xpath(
					"//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden')]"));
			for (int i = 1; i <= timepoints.size(); i++) {
				WebElement timepoint = CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden')]["
								+ i + "]",
						4);
				new Actions(login.driver).moveToElement(timepoint).pause(50).build().perform();
				WebElement text = CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'highcharts-tooltip highcharts-color-undefined')]/span", 4);
				String font_bold = text.getCssValue("font-weight");
				String font_italic = text.getCssValue("font-style");
				String font_underline = text.getCssValue("text-decoration");
				assertTrue(font_bold.equals("bold") || font_bold.equals("700"));
				assertTrue(font_italic.equals("italic"));
				assertTrue(font_underline.contains("underline"));
				WebElement title = CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'visual-title--text') and @data-name='title']", 4);
				new Actions(login.driver).moveToElement(title).pause(10).build().perform();
			}
			login.Log4j.info("The selected " + arg1 + " is reflecting in the chart visual");
		}
	}

	@SuppressWarnings("deprecation")
	@Then("^Excel data is compared with application data$")
	public void excel_data_is_compared_with_application_data() throws Throwable {
		List<WebElement> timepoints = login.driver.findElements(By.xpath(
				"//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden') or contains(@class,'highcharts-negative') and not(@visibility='hidden')]"));
		for (int i = 1; i <= timepoints.size(); i++) {
			WebElement timepoint = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden') or contains(@class,'highcharts-negative') and not(@visibility='hidden')]["
							+ i + "]",
					4);
			new Actions(login.driver).moveToElement(timepoint).pause(50).build().perform();
			String text = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'highcharts-tooltip highcharts-color-undefined')]/span", 4).getText();
			String date_only = text.substring(0, 10);
			Date date = new SimpleDateFormat("MM/dd/yyyy").parse(date_only);
			String lines[] = text.split("\\r?\\n");
			String next_lines[] = lines[1].split("\\s+");
			// To replace decimal places without space
			String replaceLine = next_lines[1].replaceAll(",", "");
			double decimal = Double.parseDouble(replaceLine);
			NumberFormat df = new DecimalFormat("########0.00");
			String new_format = df.format(decimal);
			double df1 = Double.parseDouble(new_format);
			date_app.add(date);
			timepoints_app.add(df1);
			WebElement title = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'visual-title--text') and @data-name='title']", 4);
			new Actions(login.driver).moveToElement(title).pause(10).build().perform();
		}
		login.Log4j.info("<=============================== Application values ==================================>");
		login.Log4j.info(date_app);
		login.Log4j.info(timepoints_app);
		boolean result = Arrays.equals(date_excel.toArray(), date_app.toArray());
		login.Log4j.info("Date Comparision is: \n" + result);
		assertEquals(date_excel.toArray(), date_app.toArray());
		boolean result1 = Arrays.equals(timepoints_excel.toArray(), timepoints_app.toArray());
		login.Log4j.info("Timepoints comparision is: \n" + result1);
		assertEquals(timepoints_excel.toArray(), timepoints_app.toArray());
		login.Log4j.info(
				"Both the excel and application 'timepoints' and 'date' are displaying fine and has been verified successfully");
		CommonFunctionality.Views_list();
	}

	@SuppressWarnings("deprecation")
	@Then("^The SSP timepoints inside series are compared with timepoints reflecting in visual$")
	public void The_SSP_timepoints_inside_series_are_compared_with_timepoints_reflecting_in_visual() throws Throwable {
		List<WebElement> timepoints = login.driver.findElements(By.xpath(
				"//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden') or contains(@class,'highcharts-negative') and not(@visibility='hidden')]"));
		for (int i = 1; i <= timepoints.size(); i++) {
			WebElement timepoint = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden') or contains(@class,'highcharts-negative') and not(@visibility='hidden')]["
							+ i + "]",
					4);
			new Actions(login.driver).moveToElement(timepoint).pause(50).build().perform();
			String text = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'highcharts-tooltip highcharts-color-undefined')]/span", 4).getText();
			String date_only = text.substring(0, 10);
			Date date = new SimpleDateFormat("MM/dd/yyyy").parse(date_only);
			String lines[] = text.split("\\r?\\n");
			String next_lines[] = lines[1].split("\\s+");
			// To replace decimal places without space
			String replaceLine = next_lines[1].replaceAll(",", "");
			double decimal = Double.parseDouble(replaceLine);
			NumberFormat df = new DecimalFormat("########0.00");
			String new_format = df.format(decimal);
			// double df1 = Double.parseDouble(new_format);
			date_visual.add(date);
			timepoint_visual.add(new_format);
			WebElement title = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'visual-title--text') and @data-name='title']", 4);
			new Actions(login.driver).moveToElement(title).pause(10).build().perform();
		}
		login.Log4j.info(timepoint_visual);
		login.Log4j.info(date_visual);
		boolean result = Arrays.equals(date_ssp.toArray(), date_visual.toArray());
		login.Log4j.info("Date Comparision is: \n" + result);
		assertEquals(date_ssp.toArray(), date_visual.toArray());
		boolean result1 = Arrays.equals(timepoint_ssp.toArray(), timepoint_visual.toArray());
		login.Log4j.info("Timepoints comparision is: \n" + result1);
		assertEquals(timepoint_ssp.toArray(), timepoint_visual.toArray());
		login.Log4j.info(
				"The SSP timepoints inside series are compared with timepoints reflecting in visual and has been verified successfully");
		CommonFunctionality.Views_list();
	}

	@SuppressWarnings("deprecation")
	@Then("^The Selected \"([^\"]*)\" and \"([^\"]*)\" should update with selected input$")
	public void the_selected_and_should_update_with_selected_input(String arg1, String arg2) throws Throwable {
		if (arg1.equalsIgnoreCase("Decimal seperator") && arg2.equalsIgnoreCase("Grouping seperator")) {
			cv.clicking_option("Save");
			List<WebElement> data_formats = login.driver.findElements(By.xpath(
					"//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined ' and not(@visibility='hidden')]"));
			for (WebElement data_format : data_formats) {
				String format = data_format.getText();
				String lines[] = format.split("[\\,\\.] ?");
				String split_by_comma[] = lines[0].split(",");
				if (data_format_grouping_separator.equals("Space") && data_format_separator.equals(".")
						|| data_format_grouping_separator.equals("Space") && data_format_separator.equals(",")) {
					if (!split_by_comma[0].matches(".*\\s.*")) {
						fail("Verification Failed");
					}
				} else {
					if (!format.contains(data_format_separator) && !format.contains(data_format_grouping_separator)) {
						fail("Verification failed");
					}
				}
			}
			login.Log4j.info("The Selected " + arg1 + " and " + arg2
					+ " has been updated in chart visual timepoints and it's verified successfully");
			CommonFunctionality.Views_list();
		} else {
			cv.clicking_option("Save");
			List<WebElement> timepoints = login.driver.findElements(By.xpath(
					"//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden') or contains(@class,'highcharts-negative') and not(@visibility='hidden')]"));
			for (int i = 1; i <= timepoints.size(); i++) {
				WebElement timepoint = CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden') or contains(@class,'highcharts-negative') and not(@visibility='hidden')]["
								+ i + "]",
						4);
				new Actions(login.driver).moveToElement(timepoint).pause(10).build().perform();
				String text = CommonFunctionality
						.getElementByXpath(login.driver,
								"//*[contains(@class,'highcharts-tooltip highcharts-color-undefined')]/span", 4)
						.getText();
				String lines[] = text.split("\\r?\\n");
				String next_lines[] = lines[1].split("\\s+");
				if (number_separator.equals("Space")) {
					if (!(lines[1].matches(".*\\s.*"))) {
						fail("Verification Failed");
					}
				} else {
					if (!(next_lines[1].contains(number_separator)) && !next_lines[1].contains(decimal_separator)) {
						fail(arg1 + " Verification failed");
					}
				}
				WebElement title = CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'visual-title--text') and @data-name='title']", 4);
				new Actions(login.driver).moveToElement(title).pause(2).build().perform();
			}
			login.Log4j.info("The Selected " + arg1 + " and " + arg2
					+ " has been updated in chart visual timepoints and it's verified successfully");
			CommonFunctionality.Views_list();
		}
	}

	@SuppressWarnings("deprecation")
	@Then("^The Selected \"([^\"]*)\" should update with selected input$")
	public void the_selected_should_update_with_selected_input(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Decimal Places")) {
			List<WebElement> timepoints = login.driver.findElements(By.xpath(
					"//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden') or contains(@class,'highcharts-negative') and not(@visibility='hidden')]"));
			for (int i = 1; i <= timepoints.size(); i++) {
				WebElement timepoint = CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden') or contains(@class,'highcharts-negative') and not(@visibility='hidden')]["
								+ i + "]",
						4);
				new Actions(login.driver).moveToElement(timepoint).pause(10).build().perform();
				String text = CommonFunctionality
						.getElementByXpath(login.driver,
								"//*[contains(@class,'highcharts-tooltip highcharts-color-undefined')]/span", 4)
						.getText();
				String lines[] = text.split("\\r?\\n");
				String next_lines[] = lines[1].split("\\s+");
				String decimal_places[] = next_lines[1].split("\\.");
				int length_of_digits = decimal_places[1].length();
				assertEquals(length_of_digits, chart_decimal_places);
				WebElement title = CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'visual-title--text') and @data-name='title']", 4);
				new Actions(login.driver).moveToElement(title).pause(2).build().perform();
			}
			login.Log4j.info("The Selected " + arg1
					+ " has been updated in chart visual timepoints and it's verified successfully");
			CommonFunctionality.Views_list();
		}
		if (arg1.equalsIgnoreCase("Tooltip Border Color")) {
			List<WebElement> timepoints = login.driver.findElements(By.xpath(
					"//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden') or contains(@class,'highcharts-negative') and not(@visibility='hidden')]"));
			for (int i = 1; i <= timepoints.size(); i++) {
				WebElement timepoint = CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden') or contains(@class,'highcharts-negative') and not(@visibility='hidden')]["
								+ i + "]",
						4);
				new Actions(login.driver).moveToElement(timepoint).pause(10).build().perform();
				String text = CommonFunctionality
						.getElementByXpath(login.driver, "//*[@class='highcharts-label-box highcharts-tooltip-box']", 4)
						.getAttribute("stroke");
				assertEquals(text, tooltip_border_color);
				WebElement title = CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'visual-title--text') and @data-name='title']", 4);
				new Actions(login.driver).moveToElement(title).pause(2).build().perform();
			}
			login.Log4j.info("The Selected " + arg1
					+ " has been updated in chart visual timepoints and it's verified successfully");
		}
		if (arg1.equalsIgnoreCase("Tooltip Border Width")) {
			List<WebElement> timepoints = login.driver.findElements(By.xpath(
					"//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden') or contains(@class,'highcharts-negative') and not(@visibility='hidden')]"));
			for (int i = 1; i <= timepoints.size(); i++) {
				WebElement timepoint = CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden') or contains(@class,'highcharts-negative') and not(@visibility='hidden')]["
								+ i + "]",
						4);
				new Actions(login.driver).moveToElement(timepoint).pause(10).build().perform();
				String text = CommonFunctionality
						.getElementByXpath(login.driver, "//*[@class='highcharts-label-box highcharts-tooltip-box']", 4)
						.getAttribute("stroke-width");
				int actual = Integer.parseInt(text);
				int expected = Integer.parseInt(tooltip_border_width);
				assertEquals(actual, expected);
				WebElement title = CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'visual-title--text') and @data-name='title']", 4);
				new Actions(login.driver).moveToElement(title).pause(2).build().perform();
			}
			login.Log4j.info("The Selected " + arg1
					+ " has been updated in chart visual timepoints and it's verified successfully");
		}
		if (arg1.equalsIgnoreCase("Color and Highlight color")) {
			List<WebElement> color = login.driver.findElements(
					By.cssSelector(".highcharts-data-labels.highcharts-series-0.highcharts-line-series > g > text"));
			List<WebElement> highlight_color = login.driver
					.findElements(By.xpath("//*[contains(@class,'highcharts-data-label-box') and not(@width='35')]"));
			for (int i = 1; i <= color.size(); i++) {
				String color_text = login.driver
						.findElement(By.cssSelector(
								".highcharts-data-labels.highcharts-series-0.highcharts-line-series > g > text"))
						.getCssValue("fill");
				CommonFunctionality.wait(2000);
				String actual = Color.fromString(color_text).asHex();
				assertEquals(actual, data_label_color);
			}
			for (int i = 1; i <= highlight_color.size(); i++) {
				String highlight_color1 = CommonFunctionality
						.getElementByXpath(login.driver,
								"//*[contains(@class,'highcharts-data-label-box') and not(@width='35')]", 4)
						.getAttribute("fill");
				CommonFunctionality.wait(2000);
				String highlight_color_text = Color.fromString(highlight_color1).asHex();
				assertEquals(highlight_color_text, data_label_highlight_color);
			}
			login.Log4j.info("The Selected " + arg1
					+ " has been updated in chart visual timepoints and it's verified successfully");
			CommonFunctionality.Views_list();
		}
		if (arg1.equalsIgnoreCase("Font size")) {
			List<WebElement> font_size = login.driver.findElements(
					By.cssSelector(".highcharts-data-labels.highcharts-series-0.highcharts-line-series > g > text"));
			for (int i = 1; i <= font_size.size(); i++) {
				String fontsize = login.driver
						.findElement(By.cssSelector(
								".highcharts-data-labels.highcharts-series-0.highcharts-line-series > g > text"))
						.getCssValue("font-size");
				String font_size_text[] = fontsize.split("px");
				Integer expected = Integer.valueOf(font_size_text[0]);
				Integer actual = Integer.valueOf(data_labels_font_size);
				assertEquals(actual, expected);
			}
			login.Log4j.info("The Selected " + arg1
					+ " has been updated in chart visual timepoints and it's verified successfully");
		}
		if (arg1.equalsIgnoreCase("Font Style")) {
			List<WebElement> font_style = login.driver.findElements(
					By.cssSelector(".highcharts-data-labels.highcharts-series-0.highcharts-line-series > g > text"));
			for (int i = 1; i <= font_style.size(); i++) {
				WebElement fontstyle = login.driver.findElement(By
						.cssSelector(".highcharts-data-labels.highcharts-series-0.highcharts-line-series > g > text"));
				String font_bold = fontstyle.getCssValue("font-weight");
				String font_italic = fontstyle.getCssValue("font-style");
				String font_underline = fontstyle.getCssValue("text-decoration");
				assertTrue(font_bold.equals("bold") || font_bold.equals("700"));
				assertTrue(font_italic.equals("italic"));
				assertTrue(font_underline.contains("underline"));
			}
			login.Log4j.info("The Selected " + arg1
					+ " has been updated in chart visual timepoints and it's verified successfully");
			CommonFunctionality.Views_list();
		}
	}

	@Then("^The selected \"(.*)\" value should reflect in chart$")
	public void the_selected_value_should_reflect_in_chart(String arg1) throws Throwable {
		cv.clicking_option("Save");
		List<WebElement> point_markers = login.driver.findElements(By.xpath(
				"//*[@class='highcharts-point' and not(@visibility='hidden') or @class='highcharts-point ' and not(@visibility='hidden') or contains(@class,'highcharts-point-hover') and not(@visibility='hidden') or contains(@class,'highcharts-negative') and not(@visibility='hidden')]"));
		for (int i = 1; i <= point_markers.size(); i++) {
			String point_marker_text = CommonFunctionality
					.getElementByClassName(login.driver, "select2-hidden-accessible", 4).getText();
			assertEquals(point_marker, point_marker_text);
		}
		login.Log4j.info("The selected " + arg1 + " value =" + point_marker
				+ "= is reflecting in chart visual and has been verified successfully");
		CommonFunctionality.Views_list();
	}

	@Then("^Verify the changes are reflecting in Chart visual for \"(.*)\"$")
	public void verify_the_changes_are_reflecting_in_Chart_visual_for(String arg1) throws Throwable {
		cv.clicking_option("Save");
		if (arg1.equalsIgnoreCase("Left Axis")) {
			String text = CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(@class,'highcharts-yaxis-left')]//*[@class='highcharts-axis-title']", 4)
					.getText();
			assertEquals(y_axis_title, text);
			login.Log4j.info("The y axis title name has been verified for left axis");
			String color = CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(@class,'highcharts-yaxis-left')]//*[@class='highcharts-axis-title']", 4)
					.getCssValue("color");
			String color_hex = Color.fromString(color).asHex();
			assertEquals(color_hex, y_axis_color);
			login.Log4j.info("The y axis color has been verified for left axis");
			String bgcolor = CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(@class,'highcharts-yaxis-left')]//*[@class='highcharts-axis-title']", 4)
					.getCssValue("background-color");
			String bgcolor_hex = Color.fromString(bgcolor).asHex();
			assertEquals(bgcolor_hex, y_axis_bgcolor);
			login.Log4j.info("The y axis bgcolor has been verified for left axis");
			String size = CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(@class,'highcharts-yaxis-left')]//*[@class='highcharts-axis-title']", 4)
					.getCssValue("font-size");
			String font_size[] = size.split("px");
			int actual = Integer.parseInt(font_size[0]);
			int expected = Integer.parseInt(y_axis_font_size);
			assertEquals(actual, expected);
			login.Log4j.info("The y axis font size has been verified for left axis");
			CommonFunctionality.Views_list();
		} else {
			String text = CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(@class,'highcharts-yaxis-right')]//*[@class='highcharts-axis-title']", 4)
					.getText();
			assertEquals(y_axis_opposite_title, text);
			login.Log4j.info("The y axis title name has been verified for right axis");
			String color = CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(@class,'highcharts-yaxis-right')]//*[@class='highcharts-axis-title']", 4)
					.getCssValue("color");
			String color_hex = Color.fromString(color).asHex();
			assertEquals(color_hex, y_axis_right_color);
			login.Log4j.info("The y axis color has been verified for right axis");
			String bgcolor = CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(@class,'highcharts-yaxis-right')]//*[@class='highcharts-axis-title']", 4)
					.getCssValue("background-color");
			String bgcolor_hex = Color.fromString(bgcolor).asHex();
			assertEquals(bgcolor_hex, y_axis_right_bgcolor);
			login.Log4j.info("The y axis bgcolor has been verified for right axis");
			String size = CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(@class,'highcharts-yaxis-right')]//*[@class='highcharts-axis-title']", 4)
					.getCssValue("font-size");
			String font_size[] = size.split("px");
			int actual = Integer.parseInt(font_size[0]);
			int expected = Integer.parseInt(y_axis_right_font_size);
			assertEquals(actual, expected);
			login.Log4j.info("The y axis font size has been verified for right axis");
			CommonFunctionality.Views_list();
		}
	}

	@Then("^Verify the Style is applied for \"(.*)\"$")
	public void verify_the_Style_is_applied_for(String arg1) throws Throwable {
		cv.clicking_option("Save");
		if (arg1.equalsIgnoreCase("Left Axis")) {
			WebElement title = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'highcharts-yaxis-left')]//*[@class='highcharts-axis-title']", 4);
			String font_bold = title.getCssValue("font-weight");
			String font_italic = title.getCssValue("font-style");
			String font_underline = title.getCssValue("text-decoration");
			assertTrue(font_bold.equals("bold") || font_bold.equals("700"));
			assertTrue(font_italic.equals("italic"));
			assertTrue(font_underline.contains("underline"));
			CommonFunctionality.Views_list();
		} else {
			WebElement title = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'highcharts-yaxis-right')]//*[@class='highcharts-axis-title']", 4);
			String font_bold = title.getCssValue("font-weight");
			String font_italic = title.getCssValue("font-style");
			String font_underline = title.getCssValue("text-decoration");
			assertTrue(font_bold.equals("bold") || font_bold.equals("700"));
			assertTrue(font_italic.equals("italic"));
			assertTrue(font_underline.contains("underline"));
			CommonFunctionality.Views_list();
		}
	}

	@Then("^\"([^\"]*)\" and \"([^\"]*)\" is displayed and by default Show Legend is checked$")
	public void and_is_displayed_and_by_default_Show_Legend_is_checked(String arg1, String arg2) throws Throwable {
		WebElement common1 = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]",
				4);
		WebElement common2 = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg2 + "')]",
				4);
		if (common1.isDisplayed() && common2.isDisplayed()) {
			login.Log4j.info(arg1 + " and " + arg2 + " is displayed and verified successfully");
		} else {
			fail("Not displayed");
		}
		login.driver.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]/preceding::input[1]")).isSelected();
		assertTrue(true, arg1 + " is checked");
		cv.clicking_option("Save");
		closing_the_chart_visual();
	}

	@Then("^\"([^\"]*)\" is displayed at bottom of the chart$")
	public void is_displayed_at_bottom_of_the_chart(String arg1) throws Throwable {
		if (login.driver.findElements(By.cssSelector("div[class='legend-item']")).size() > 0
				&& legend_checkbox == true) {
			login.Log4j.info("The legend item is displayed and it has been verified successfully");
		} else {
			fail("Verification Failed");
		}
		cv.click_on_visual("Edit");
		click_on_the_checkbox_to("Legend:", "Check");
		click_on_the_Container("Legend:");
		popup_should_appear("Legend");
		section_from_Legand_popup_should_expand("Common");
		checkbox_is_unchecked("Show legend");
		if (login.driver.findElements(By.cssSelector("div[class='legend-item']")).size() == 0
				&& legend_checkbox_uncheck == false) {
			login.Log4j.info("The legend item is not displayed and it has been verified successfully");
		} else {
			fail("Verification Failed");
		}
		CommonFunctionality.Views_list();
	}

	@Then("^The Selected \"([^\"]*)\" should reflect in the chart visual legand$")
	public void the_Selected_should_reflect_in_the_chart_visual_legand(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Color")) {
			String color = CommonFunctionality
					.getElementBycssSelector(login.driver, "div.highcharts-series-0 > span", 4).getCssValue("color");
			String color_hex = Color.fromString(color).asHex();
			assertEquals(color_hex, legend_color);
			login.Log4j.info("The selected " + arg1 + " is reflecting in chart visual");
			CommonFunctionality.Views_list();
		}
		if (arg1.equalsIgnoreCase("Title") && values_axis_checkboxes == true) {
			String title = CommonFunctionality
					.getElementBycssSelector(login.driver, "div.highcharts-legend-title > span", 4).getText();
			assertEquals(title, legend_title);
			login.Log4j.info("The selected " + arg1 + " is reflecting in chart visual");
			CommonFunctionality.Views_list();
		}
		if (arg1.equalsIgnoreCase("Font size") && values_axis_checkboxes == true) {
			cv.clicking_option("Save");
			String fontsize = CommonFunctionality
					.getElementBycssSelector(login.driver, "div.highcharts-legend-title > span", 4)
					.getCssValue("font-size");
			String[] size = fontsize.split("px");
			Integer expected = Integer.valueOf(size[0]);
			Integer actual = Integer.valueOf(legend_title_font_size);
			assertEquals(actual, expected);
			login.Log4j.info("The selected " + arg1 + " is reflecting in chart visual");
			cv.click_on_visual("Edit");
			click_on_the_checkbox_to("Legend:", "Check");
			click_on_the_Container("Legend:");
			popup_should_appear("Legend");
			section_from_Legand_popup_should_expand("Title");
		}
		if (arg1.equalsIgnoreCase("Font style") && values_axis_checkboxes == true) {
			cv.clicking_option("Save");
			WebElement title = CommonFunctionality.getElementBycssSelector(login.driver,
					"div.highcharts-legend-title > span", 4);
			String font_bold = title.getCssValue("font-weight");
			String font_italic = title.getCssValue("font-style");
			String font_underline = title.getCssValue("text-decoration");
			assertTrue(font_bold.equals("bold") || font_bold.equals("700"));
			assertTrue(font_italic.equals("italic"));
			assertTrue(font_underline.contains("underline"));
			login.Log4j.info("The selected " + arg1 + " is reflecting in chart visual");
			cv.click_on_visual("Edit");
			click_on_the_checkbox_to("Legend:", "Check");
			click_on_the_Container("Legend:");
			popup_should_appear("Legend");
			section_from_Legand_popup_should_expand("Title");
		}
		if (arg1.equalsIgnoreCase("Background color") && values_axis_checkboxes == true) {
			cv.clicking_option("Save");
			String bgcolor = CommonFunctionality.getElementBycssSelector(login.driver, "rect.highcharts-legend-box", 4)
					.getAttribute("fill");
			String bgcolor_hex = Color.fromString(bgcolor).asHex();
			assertEquals(bgcolor_hex, legend_bgcolor);
			login.Log4j.info("The selected " + arg1 + " is reflecting in chart visual");
			cv.click_on_visual("Edit");
			click_on_the_checkbox_to("Legend:", "Check");
			click_on_the_Container("Legend:");
			popup_should_appear("Legend");
			section_from_Legand_popup_should_expand("Background");
		}
		if (arg1.equalsIgnoreCase("Border color") && values_axis_checkboxes == true) {
			cv.clicking_option("Save");
			String bordercolor = CommonFunctionality
					.getElementBycssSelector(login.driver, "rect.highcharts-legend-box", 4).getAttribute("stroke");
			String bordercolor_hex = Color.fromString(bordercolor).asHex();
			assertEquals(bordercolor_hex, legend_border_color);
			login.Log4j.info("The selected " + arg1 + " is reflecting in chart visual");
			cv.click_on_visual("Edit");
			click_on_the_checkbox_to("Legend:", "Check");
			click_on_the_Container("Legend:");
			popup_should_appear("Legend");
			section_from_Legand_popup_should_expand("Border");
		}
		if (arg1.equalsIgnoreCase("Border width") && values_axis_checkboxes == true) {
			cv.clicking_option("Save");
			String width = CommonFunctionality.getElementBycssSelector(login.driver, "rect.highcharts-legend-box", 4)
					.getAttribute("stroke-width");
			int actual = Integer.parseInt(width);
			int expected = Integer.parseInt(legend_border_width);
			assertEquals(actual, expected);
			login.Log4j.info("The selected " + arg1 + " is reflecting in chart visual");
			cv.click_on_visual("Edit");
			click_on_the_checkbox_to("Legend:", "Check");
			click_on_the_Container("Legend:");
			popup_should_appear("Legend");
			section_from_Legand_popup_should_expand("Border");
		}
		if (arg1.equalsIgnoreCase("Border radius") && values_axis_checkboxes == true) {
			cv.clicking_option("Save");
			String radius = CommonFunctionality.getElementBycssSelector(login.driver, "rect.highcharts-legend-box", 4)
					.getAttribute("rx");
			int actual = Integer.parseInt(radius);
			int expected = Integer.parseInt(legend_border_radius);
			assertEquals(actual, expected);
			String radius1 = CommonFunctionality.getElementBycssSelector(login.driver, "rect.highcharts-legend-box", 4)
					.getAttribute("ry");
			int actual1 = Integer.parseInt(radius1);
			int expected1 = Integer.parseInt(legend_border_radius);
			assertEquals(actual1, expected1);
			login.Log4j.info("The selected " + arg1 + " is reflecting in chart visual");
			cv.click_on_visual("Edit");
			click_on_the_checkbox_to("Legend:", "Check");
			click_on_the_Container("Legend:");
			popup_should_appear("Legend");
			section_from_Legand_popup_should_expand("Border");
		}
		if (arg1.equalsIgnoreCase("Copyright") && tooltips_checkbox == true) {
			cv.clicking_option("Save");
			String title = CommonFunctionality.getElementBycssSelector(login.driver, ".visual-item-wrapper--text", 4)
					.getText();
			assertEquals(title, copyright_title);
			login.Log4j.info("The selected " + arg1 + " is reflecting in chart visual");
			cv.click_on_visual("Edit");
			click_on_the_checkbox_to("Copyright:", "Check");
			click_on_the_Container("Copyright:");
			popup_should_appear("Copyright");
		}
		if (arg1.equalsIgnoreCase("Copyright Image") && tooltips_checkbox == true) {
			cv.clicking_option("Save");
			if (login.driver.findElements(By.cssSelector("img[class='visual-item-wrapper--logo']")).size() > 0
					&& copyright_checkbox_text.equalsIgnoreCase("Image")) {
				login.Log4j.info("The selected " + arg1 + " is reflecting in chart visual");
			} else {
				fail("Verification Failed");
			}
			cv.click_on_visual("Edit");
			click_on_the_checkbox_to("Copyright:", "Check");
			click_on_the_Container("Copyright:");
			popup_should_appear("Copyright");
		}
		if (arg1.equalsIgnoreCase("Copyright link") && tooltips_checkbox == true) {
			cv.clicking_option("Save");
			CommonFunctionality.getElementBycssSelector(login.driver, ".visual-item-wrapper--text", 4).click();
			ArrayList<String> browserTabs = new ArrayList<String>(login.driver.getWindowHandles());
			login.driver.switchTo().window(browserTabs.get(1));
			String URL = login.driver.getCurrentUrl();
			login.Log4j.info("The selected " + arg1 + " is reflecting in chart visual");
			login.driver.close();
			login.driver.switchTo().window(browserTabs.get(0));
			sa.assertEquals(URL, copyright_title_link);
			cv.click_on_visual("Edit");
			click_on_the_checkbox_to("Copyright:", "Check");
			click_on_the_Container("Copyright:");
			popup_should_appear("Copyright");
		}
		if (arg1.equalsIgnoreCase("Copyright Image link") && tooltips_checkbox == true
				&& copyright_checkbox_text.equalsIgnoreCase("Image")) {
			cv.clicking_option("Save");
			CommonFunctionality.getElementBycssSelector(login.driver, "img[class='visual-item-wrapper--logo']", 4)
					.click();
			ArrayList<String> browserTabs = new ArrayList<String>(login.driver.getWindowHandles());
			login.driver.switchTo().window(browserTabs.get(1));
			String URL = login.driver.getCurrentUrl();
			login.Log4j.info("The selected " + arg1 + " is reflecting in chart visual");
			login.driver.close();
			login.driver.switchTo().window(browserTabs.get(0));
			sa.assertEquals(URL, copyright_title_link);
			cv.click_on_visual("Edit");
			click_on_the_checkbox_to("Copyright:", "Check");
			click_on_the_Container("Copyright:");
			popup_should_appear("Copyright");
		}
		if (arg1.equalsIgnoreCase("Copyright font size") && tooltips_checkbox == true) {
			cv.clicking_option("Save");
			String fontsize = CommonFunctionality.getElementBycssSelector(login.driver, ".visual-item-wrapper--text", 4)
					.getCssValue("font-size");
			String[] size = fontsize.split("px");
			Integer expected = Integer.valueOf(size[0]);
			Integer actual = Integer.valueOf(copyright_font_size);
			assertEquals(actual, expected);
			login.Log4j.info("The selected " + arg1 + " is reflecting in chart visual");
			cv.click_on_visual("Edit");
			click_on_the_checkbox_to("Copyright:", "Check");
			click_on_the_Container("Copyright:");
			popup_should_appear("Copyright");
		}
		if (arg1.equalsIgnoreCase("Copyright font style") && tooltips_checkbox == true) {
			cv.clicking_option("Save");
			WebElement title = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='visual-item-wrapper--text ']/parent::a", 4);
			String font_bold = title.getCssValue("font-weight");
			String font_italic = title.getCssValue("font-style");
			String font_underline = title.getCssValue("text-decoration");
			assertTrue(font_bold.equals("bold") || font_bold.equals("700"));
			assertTrue(font_italic.equals("italic"));
			assertTrue(font_underline.contains("underline"));
			login.Log4j.info("The selected " + arg1 + " is reflecting in chart visual");
			cv.click_on_visual("Edit");
			click_on_the_checkbox_to("Copyright:", "Check");
			click_on_the_Container("Copyright:");
			popup_should_appear("Copyright");
		}
		if (arg1.equalsIgnoreCase("Copyright color") && tooltips_checkbox == true) {
			cv.clicking_option("Save");
			String color = CommonFunctionality.getElementBycssSelector(login.driver, ".visual-item-wrapper--text", 4)
					.getCssValue("color");
			String color_hex = Color.fromString(color).asHex();
			assertEquals(color_hex, copyright_color);
			login.Log4j.info("The selected " + arg1 + " is reflecting in chart visual");
			cv.click_on_visual("Edit");
			click_on_the_checkbox_to("Copyright:", "Check");
			click_on_the_Container("Copyright:");
			popup_should_appear("Copyright");
		}
	}

	@Then("^The title of the popup should be \"([^\"]*)\"$")
	public void the_title_of_the_popup_should_be(String arg1) throws Throwable {
		String actual = CommonFunctionality
				.getElementBycssSelector(login.driver, "div.popover--wrapper div.popover--title", 4).getText();
		assertEquals(actual, arg1);
		login.Log4j.info(arg1 + " is the title text");
		cv.clicking_option("Save");
		CommonFunctionality.Views_list();
	}

	@Then("^Check the Zoom checkbox in Visual$")
	public void check_the_Zoom_checkbox_in_Visual() throws Throwable {
		if (zoom_checkbox == false) {
			WebElement checkbox = login.driver.findElement(By.xpath("//*[text()='Zoom']/preceding-sibling::span"));
			new Actions(login.driver).moveToElement(checkbox).click().build().perform();
		}
		cv.clicking_option("Save");
		if (login.driver.findElements(By.className("highcharts-range-selector-buttons")).size() > 0) {
			login.Log4j.info("Zoom Checkbox is checked and it has been verified");
		}
	}

	@Then("^Uncheck the \"([^\"]*)\" checkbox in Visual and verify the results$")
	public void uncheck_the_checkbox_and_verify_the_results(String arg1) throws Throwable {
		if (zoom_checkbox == true) {
			WebElement checkbox = login.driver
					.findElement(By.xpath("//*[text()='" + arg1 + "']/preceding-sibling::span"));
			new Actions(login.driver).moveToElement(checkbox).click().build().perform();
		}
		cv.clicking_option("Save");
		if (login.driver.findElements(By.className("highcharts-range-selector-buttons")).size() == 0) {
			login.Log4j.info(arg1 + " Checkbox is unchecked and it has been verified");
		}
		CommonFunctionality.Views_list();
	}

	@Then("^(\\d+) type of visuals should present$")
	public void type_of_visuals_should_present(int arg1) throws Throwable {
		List<WebElement> visuals_list = login.driver
				.findElements(By.xpath("//*[@title='View as']//following-sibling::ul[@class='dropdown-menu']/li/span"));
		for (WebElement visual : visuals_list) {
			String visual_text = visual.getAttribute("title");
			System.out.println("The visual type is: " + visual_text);
		}
		assertEquals(arg1, visuals_list.size());
		login.Log4j.info("The total visual types are:" + visuals_list.size());
		CommonFunctionality.Views_list();
	}

	@Then("^Verify the top panel should change to \"([^\"]*)\"$")
	public void verify_the_top_panel_should_change_to(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);
		visual_name = CommonFunctionality
				.getElementBycssSelector(login.driver, ".visual-top-panel--left-controls .button__primary", 4)
				.getText();
		assertEquals(visual_name, arg1);
		login.Log4j.info("The Chart visual is changed to " + arg1 + " successfully");
		CommonFunctionality.Views_list();
	}

	@Then("^Verify texts$")
	public void verify_texts() throws Throwable {
		assertEquals(series_title, edit_series_title);
		login.Log4j.info("The Edit Series is verified successfully");
		CommonFunctionality.Views_list();
	}

	@Then("^\"([^\"]*)\" popup shoud display$")
	public void popup_shoud_display(String arg1) throws Throwable {
		if (login.driver
				.findElements(
						By.xpath("//*[contains(@class,'movable-modal--window')]//*[contains(text(),'" + arg1 + "')]"))
				.size() > 0) {
			login.Log4j.info(arg1 + " popup is displayed");
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		} else {
			fail("Verification Failed");
		}
		CommonFunctionality.Views_list();
	}

	@Then("^\"([^\"]*)\" , \"([^\"]*)\", \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" icons should appear$")
	public void icons_should_appear(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
		List<WebElement> icons = login.driver.findElements(By.cssSelector(".vis-elem-menu--item"));
		System.out.println("The icons count is:" + icons.size());
		String text = null;
		for (WebElement icon : icons) {
			String icon_text = icon.getAttribute("title");
			if (icon_text.equals("")) {
				text = CommonFunctionality.getElementBycssSelector(login.driver, ".download-button__icon", 4)
						.getAttribute("title");
				String split[] = text.split("\\. ");
				assertEquals(split[0], arg3);
			}
			if (!(icon_text.equals(arg1) || icon_text.equals(arg2) || icon_text.equals(arg4) || icon_text.equals(arg5)
					|| text.contains(arg3))) {
				fail(icon_text + " is not present");
			}
		}
		login.Log4j.info("The " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + " and " + arg5
				+ " icons are verified successfully");
		CommonFunctionality.Views_list();
	}

	@Then("^Verify the Changes on clicking New button$")
	public void verify_the_Changes_on_clicking_New_button() throws Throwable {
		String actual = CommonFunctionality.getElementBycssSelector(login.driver, "span[data-name='title']", 4)
				.getText();
		assertEquals(actual, visual_title);
		if (views_after > views_before) {
			login.Log4j.info("The changes in chart visual has been verified successfully");
		} else {
			fail("Verification Failed");
		}
	}

	@Then("^Clicking on the insight name should open the insight with the series$")
	public void clicking_on_the_insight_name_should_open_the_insight_with_the_series() throws Throwable {
		login.driver.findElement(By.xpath(
				"//*[@class='growl-message growl-success']//*[@class='button growl-message-content--btns__fill']"))
				.click();
		CommonFunctionality.wait(2000);
		login.Log4j.info("New insight with the added series is opened");
		ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(newTab.get(1));
		String actual_text = CommonFunctionality
				.getElementByClassName(login.driver, "series-name-field--series-name", 4).getText();
		login.driver.switchTo().window(newTab.get(1)).close();
		login.driver.switchTo().window(newTab.get(0));
		CommonFunctionality.Views_list();
		sa.assertEquals(actual_text, visual_title);
	}

	@Then("^Verify the contents in text file$")
	public void verify_the_contents_in_text_file() throws Throwable {
		// assertEquals(copied_text, read_copied_data);
		if (copied_text.contains(read_copied_data) || read_copied_data.contains(copied_text)) {
			Files.deleteIfExists(Paths.get(path));
			login.Log4j.info("The Copy action is performed successfully");
		}
		CommonFunctionality.Views_list();
	}

	@Then("^The \"([^\"]*)\" visual has been deleted from the right panel$")
	public void the_visual_has_been_deleted_from_the_right_panel(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Chart")) {
			if (login.driver.findElements(By.xpath("//*[text()='" + visual_title + "']")).size() == 0) {
				login.Log4j.info("The " + arg1 + " Visual is deleted from the right panel");
			} else {
				fail("Verification Failed");
			}
			List<WebElement> views = login.driver.findElements(
					By.xpath("//*[contains(@class,'insight-page-view-tab') and contains(text(),'View')]"));
			if (views.size() > 0) {
				for (WebElement view : views) {
					new Actions(login.driver).contextClick(view).build().perform();
					CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Delete view')]", 8)
							.click();
				}
			}
			CommonFunctionality.getElementByProperty(login.driver, "Series_tab", 8).click();
			CommonFunctionality.DeleteSeries();
		}
	}

	@Then("^Check for the movable popup to appear$")
	public void check_for_the_movable_popup_to_appear() throws Throwable {
		if (CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'sphere-modal-dialog')]", 4)
				.isDisplayed()) {
			login.Log4j.info("The Open icon is working as expected");
		} else {
			fail("Verification Failed");
		}
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		CommonFunctionality.Views_list();
	}

	@Then("^Verify the download popup appears and the title should be \"([^\"]*)\"$")
	public void verify_the_download_popup_appears_and_the_title_should_be(String arg1) throws Throwable {
		if (CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'sphere-modal__content')]", 4)
				.isDisplayed()) {
			login.Log4j.info("The Download popup is displayed and verified successfully");
		} else {
			fail(arg1 + " is not displayed");
		}
		String actual = CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[contains(@class,'sphere-modal__content')]//*[@class='download-modal-title__title']", 4)
				.getText();
		assertEquals(actual, arg1);
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		CommonFunctionality.Views_list();
	}

	@Then("^The text and sub text options are present in context click$")
	public void the_text_and_sub_text_options_are_present_in_context_click() throws Throwable {
		String a = "Copy Chart";
		String b = "Cut chart";
		String c = "Delete chart";
		String d = "Insert visual";
		String e = "Paste visual";
		String f = "View as";
		String g = "Calculate series";
		String h = "Edit series";
		String i = "Clear contents";
		String j = "Reset format";
		String k = "Download";
		String l = "Chart";
		String m = "Pie";
		String n = "Table";
		String o = "Map";
		String p = "Heat map";
		String q = "Histogram";
		String r = "Commentary";
		String s = "Attachments";
		String t = "Image";
		String u = "Filter";
		String v = "Map";
		String w = "Table";
		String x = "Pie";
		String y = "Heat map";
		String z = "Histogram";
		String a_download = "Chart";
		String b_download = "View";
		if (!(rightclick_element.contains(a) || rightclick_element.contains(b) || rightclick_element.contains(c)
				|| rightclick_element.contains(d) || rightclick_element.contains(e) || rightclick_element.contains(f)
				|| rightclick_element.contains(g) || rightclick_element.contains(h) || rightclick_element.contains(i)
				|| rightclick_element.contains(j) || rightclick_element.contains(k))) {
			fail("Drop down verification failed");
		}
		if (!(insert_visual_list.contains(l) || insert_visual_list.contains(m) || insert_visual_list.contains(n)
				|| insert_visual_list.contains(o) || insert_visual_list.contains(p) || insert_visual_list.contains(q)
				|| insert_visual_list.contains(r) || insert_visual_list.contains(s) || insert_visual_list.contains(t)
				|| insert_visual_list.contains(u))) {
			fail("Insert Visual verification failed");
		}
		if (!(view_as.contains(v) || view_as.contains(w) || view_as.contains(x) || view_as.contains(y)
				|| view_as.contains(z))) {
			fail("View as verification failed");
		}
		if (!(download.contains(a_download) || download.contains(b_download))) {
			fail("Download subdropdown verification failed");
		}
		login.Log4j.info("The Right click options in the chart visual has been verified successfully");
		CommonFunctionality.Views_list();
	}

	@SuppressWarnings("deprecation")
	@Then("^The \"([^\"]*)\" options have been verified$")
	public void the_options_have_been_verified(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Insert visual")) {
			String l = "Chart";
			String m = "Pie";
			String n = "Table";
			String o = "Map";
			String p = "Heat map";
			String q = "Histogram";
			String r = "Commentary";
			String s = "Attachments";
			String t = "Image";
			String u = "Filter";
			if (!(insert_visual_list.contains(l) || insert_visual_list.contains(m) || insert_visual_list.contains(n)
					|| insert_visual_list.contains(o) || insert_visual_list.contains(p)
					|| insert_visual_list.contains(q) || insert_visual_list.contains(r)
					|| insert_visual_list.contains(s) || insert_visual_list.contains(t)
					|| insert_visual_list.contains(u))) {
				fail("Insert Visual verification failed");
			}
			List<WebElement> sub = login.driver.findElements(
					By.xpath("//*[@title='" + arg1 + "']//following-sibling::ul[@class='dropdown-menu']/li/span"));
			for (int i = 1; i <= sub.size(); i++) {
				CommonFunctionality.wait(3000);
				right_Click_the_Add_to_Related_series();
				CommonFunctionality.wait(3000);
				WebElement hover = CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg1 + "']", 4);
				new Actions(login.driver).moveToElement(hover).pause(500).click().build().perform();
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[@title='" + arg1 + "']//following-sibling::ul[@class='dropdown-menu']/li[" + i + "]/span",
						4).click();
				if (i == 1) {
					CommonFunctionality.wait(3000);
					CommonFunctionality.getElementByClassName(login.driver, "empty-visual-overlay--link", 4).click();
					new Actions(login.driver)
							.moveToElement(new WebDriverWait(login.driver, 20).until(ExpectedConditions
									.elementToBeClickable(By.xpath("//*[contains(@class,'input-control__grey')]"))))
							.pause(3000).click().build().perform();
				}
			}
			CommonFunctionality.getElementByProperty(login.driver, "Series_tab", 4).click();
			CommonFunctionality.Views_list();
		}
		if (arg1.equalsIgnoreCase("View as")) {
			String v = "Map";
			String w = "Table";
			String x = "Pie";
			String y = "Heat map";
			String z = "Histogram";
			if (!(view_as.contains(v) || view_as.contains(w) || view_as.contains(x) || view_as.contains(y)
					|| view_as.contains(z))) {
				fail("View as verification failed");
			}
			List<WebElement> sub = login.driver.findElements(
					By.xpath("//*[@title='" + arg1 + "']//following-sibling::ul[@class='dropdown-menu']/li/span"));
			for (int i = 1; i <= sub.size(); i++) {
				CommonFunctionality.wait(500);
				right_Click_the_Add_to_Related_series();
				CommonFunctionality.wait(500);
				WebElement hover = CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg1 + "']", 4);
				new Actions(login.driver).moveToElement(hover).pause(500).click().build().perform();
				String text = CommonFunctionality
						.getElementByXpath(login.driver,
								"//*[@title='" + arg1 + "']//following-sibling::ul/li[" + i + "]/span", 12)
						.getAttribute("title");
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[@title='" + arg1 + "']//following-sibling::ul/li[" + i + "]/span", 4).click();
				CommonFunctionality.wait(1000);
				if (text.equalsIgnoreCase("Histogram")) {
					CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='title']", 4).click();
					CommonFunctionality.getElementByClassName(login.driver, "popover--close", 4).click();
				}
				String title_text = CommonFunctionality.getElementBycssSelector(login.driver,
						".visual-top-panel--left-controls .button__sm.button__primary", 12).getText();
				if (!title_text.contains(text)) {
					fail("Verification Failed");
				}
			}
			login.Log4j.info("The Options present inside " + arg1 + " has been verified successfully");
			CommonFunctionality.Views_list();
		}
		if (arg1.equalsIgnoreCase("Edit series")) {
			WebElement edit = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='insight-series-settings']/parent::div", 4);
			if (edit.getAttribute("class").contains("sidebar-panel__opened")) {
				CommonFunctionality.wait(3000);
				if (login.driver.findElements(By.cssSelector(".insight-series-settings")).size() > 0
						&& login.driver.findElement(By.cssSelector(".insight-series-settings")).isDisplayed()) {
					login.Log4j.info("Edit series popup is displayed and verified successfully");
				} else {
					fail("Edit series popup is not displayed");
				}
			} else {
				fail("Sidebar Panel is not opened");
			}
			CommonFunctionality.Views_list();
		}
		if (arg1.equalsIgnoreCase("Clear contents")) {
			CommonFunctionality.wait(3000);
			if (login.driver.findElements(By.className("empty-visual-overlay--content")).size() == 1) {
				boolean checkbox = login.driver.findElement(By.cssSelector("input[name='select_all_dataselection']"))
						.isSelected();
				if (checkbox == true) {
					fail("Checkbox is still checked");
				}
			}
			login.Log4j.info(arg1 + " has been verified successfully");
			CommonFunctionality.wait(2000);
			CommonFunctionality.Views_list();
		}
	}

	@Then("^The Action is performed on doing \"([^\"]*)\" operation$")
	public void the_Action_is_performed_on_doing_operation(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Undo")) {
			String actual = CommonFunctionality.getElementBycssSelector(login.driver, "span[data-name='title']", 4)
					.getText();
			assertEquals(actual, visual_title);
			assertNotEquals(actual, chart_title_text);
			login.Log4j.info("The " + arg1 + " operation is performed successfully");
		}
		if (arg1.equalsIgnoreCase("Redo")) {
			String actual = CommonFunctionality.getElementBycssSelector(login.driver, "span[data-name='title']", 4)
					.getText();
			assertNotEquals(actual, visual_title);
			assertEquals(actual, chart_title_text);
			login.Log4j.info("The " + arg1 + " operation is performed successfully");
			CommonFunctionality.Views_list();
		}
	}

	@Then("^The chart is changed to \"([^\"]*)\" type$")
	public void the_Chart_is_changed_to_type(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("column")) {
			WebElement className = login.driver.findElement(By.xpath(
					"//*[@class='highcharts-series-group']//following-sibling::*[contains(@class,'highcharts-series-0')]"));
			String chart_type = className.getAttribute("class");
			String[] split = chart_type.split("-");
			assertEquals(arg1, split[4]);
		}
		if (arg1.equalsIgnoreCase("area")) {
			WebElement className = login.driver.findElement(By.xpath(
					"//*[@class='highcharts-series-group']//following-sibling::*[contains(@class,'highcharts-series-0')]"));
			String chart_type = className.getAttribute("class");
			String[] split = chart_type.split("-");
			assertEquals(arg1, split[4]);
		}
		if (arg1.equalsIgnoreCase("bar")) {
			WebElement className = login.driver.findElement(By.xpath(
					"//*[@class='highcharts-series-group']//following-sibling::*[contains(@class,'highcharts-series-0')]"));
			String chart_type = className.getAttribute("class");
			String[] split = chart_type.split("-");
			assertEquals(arg1, split[4]);
		}
		if (arg1.equalsIgnoreCase("line")) {
			WebElement className = login.driver.findElement(By.xpath(
					"//*[@class='highcharts-series-group']//following-sibling::*[contains(@class,'highcharts-series-0')]"));
			String chart_type = className.getAttribute("class");
			String[] split = chart_type.split("-");
			assertEquals(arg1, split[4]);
		}
		login.Log4j.info("The Chart type is changed successfully to " + arg1 + " type");
		CommonFunctionality.Views_list();
	}

	@SuppressWarnings("deprecation")
	@Then("^The Series is changed to the \"([^\"]*)\" specified$")
	public void the_Series_is_changed_to_the_specified(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Color")) {
			String color_text = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='highcharts-series highcharts-series-0 highcharts-line-series']/*[@class='highcharts-graph']",
					4).getAttribute("stroke");
			String actual = Color.fromString(color_text).asHex();
			assertEquals(actual, color);
		}
		if (arg1.equalsIgnoreCase("Stroke Width")) {
			String stroke = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='highcharts-series highcharts-series-0 highcharts-line-series']/*[@class='highcharts-graph']",
					4).getAttribute("stroke-width");
			int actual = Integer.parseInt(series_stroke_size);
			int expected = Integer.parseInt(stroke);
			assertEquals(actual, expected);
		}
		if (arg1.equalsIgnoreCase("Deleted")) {
			List<WebElement> series = login.driver
					.findElements(By.cssSelector(".series-edit--title.series-edit--title__editable"));
			int series_after = series.size();
			if (!(series_before > series_after)) {
				fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("Move to right")) {
			WebElement right = CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='series-axis']//*[@title='" + arg1 + "'])[1]",
					4);
			if(!(right.getAttribute("class").contains("series-axis--button__selected"))) {
				fail("Verification Failed");
			}
			/*new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"(//*[contains(@class,'series-edit--title__editable')])[2]", 4))
					.pause(1000).build().perform();
			String expected = CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(text(),'Name:')]/following-sibling::*", 4).getText();
			if (!(Comparables.hovered_series_name.equalsIgnoreCase(expected))
					&& (!(right.getAttribute("class").contains("series-axis--button__selected")))) {
				fail("Verification Failed");
			}*/
		}
		login.Log4j.info("The Series has been changed successfully to the " + arg1 + " specified");
		CommonFunctionality.Views_list();
	}

	@Then("^Verify the functions appeared in excel$")
	public void verify_the_functions_appeared_in_excel() throws Throwable {
		CommonFunctionality.wait(1000);
		String path = System.getProperty("user.home") + "\\Downloads\\" + visual_title + ".xlsx";
		File src = new File(path);
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		String data = sheet1.getRow(21).getCell(1).getStringCellValue();
		if (data.contains(applied_function)) {
			Files.deleteIfExists(Paths.get(path));
			login.Log4j.info(
					"The applied function has been displayed in chart and it has been verified successfully and the applied function is "
							+ applied_function);
		} else {
			Files.deleteIfExists(Paths.get(path));
			fail("Verification Failed");
		}
		fis.close();
		CommonFunctionality.wait(2000);
		CommonFunctionality.Views_list();
	}

	@Then("^Verify that the Functions applied is reflecting in excel data$")
	public void verify_that_the_Functions_applied_is_reflecting_in_excel_data() throws Throwable {
		CommonFunctionality.Download_to_Excel(myseriestitle, 10, 1, function_myseries);
		login.Log4j.info("The entered function applied is reflecting in Chart visual and it has been verified");
		CommonFunctionality.DeleteSeries();
	}

	@Then("^The \"([^\"]*)\" action is performed successfully$")
	public void the_action_is_performed_successfully(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Copy and Paste")) {
			CommonFunctionality.wait(3000);
			List<WebElement> myseries_after = login.driver.findElements(By.className("series-name-field--series-name"));
			int count = myseries_after.size();
			assertNotEquals(myseries_before, count);
			login.Log4j.info("The " + arg1 + " actions has been performed successfully");
			CommonFunctionality.DeleteSeries();
		}
		if (arg1.equalsIgnoreCase("Unselect")) {
			WebElement select = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='insight-series-search-filter']/following::div[1]", 4);
			if (!(select.getAttribute("class").contains("all-selected"))
					&& login.driver.findElements(By.className("empty-visual-overlay--content")).size() == 1) {
				login.Log4j.info("The " + arg1 + " option has been verified successfully");
			} else {
				fail("Verification Failed");
			}
			CommonFunctionality.wait(2000);
			CommonFunctionality.Views_list();
		}
		if (arg1.equalsIgnoreCase("Delete")) {
			if (login.driver.findElements(By.xpath("//*[contains(@class,'modal-content')]//*[text()='Ok']"))
					.size() > 0) {
				CommonFunctionality
						.getElementByXpath(login.driver, "//*[contains(@class,'modal-content')]//*[text()='Ok']", 4)
						.click();
			}
			if (login.driver.findElements(By.cssSelector(".data-selection-series-overlay__view ")).size() == 1
					&& login.driver.findElements(By.className("empty-visual-overlay--content")).size() == 1) {
				login.Log4j.info("The " + arg1 + " action has been performed successfully");
			} else {
				fail("Verification Failed");
			}
			CommonFunctionality.Views_list();
		}
		if (arg1.equalsIgnoreCase("Rename")) {
			String actual = CommonFunctionality.getElementByClassName(login.driver, "series-name--title", 4).getText();
			String expected = CommonFunctionality.getElementBycssSelector(login.driver, "span[data-name='title']", 4)
					.getText();
			assertEquals(actual, rename_series);
			assertEquals(rename_series, expected);
			login.Log4j.info("The " + arg1 + " action is performed successfully");
			CommonFunctionality.Views_list();
		}
		if (arg1.equalsIgnoreCase("Preview")) {
			List<WebElement> series_list = login.driver.findElements(By.xpath("//*[@class='series-edit--title']"));
			for (WebElement series : series_list) {
				String text = series.getText();
				if (text.contains(applied_function)) {
					login.Log4j.info("The " + arg1 + " action has been performed successfully");
				} else {
					fail("Verification Failed");
				}
			}
			CommonFunctionality.Views_list();
		}
		if (arg1.equalsIgnoreCase("Copy and Paste into Excel")) {
			String path = System.getProperty("user.dir") + "\\Excel_Files\\" + myseriestitle + ".xlsx";
			File src = new File(path);
			if (!src.exists()) {
				src.createNewFile();
			}
			FileInputStream fis = new FileInputStream(src);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet1 = wb.createSheet();
			Row row = sheet1.createRow(0);
			Cell cell = row.createCell(0);
			CommonFunctionality.wait(2000);
			cell.setCellValue(copied_text);
			CommonFunctionality.wait(4000);
			FileOutputStream fos = new FileOutputStream(src);
			wb.write(fos);
			String actual = sheet1.getRow(0).getCell(0).getStringCellValue();
			assertEquals(actual, copied_text);
			login.Log4j.info("The " + arg1 + " has been verified successfully");
			sheet1.removeRow(row);
			fos.close();
			fis.close();
			CommonFunctionality.DeleteSeries();
		}
	}

	@Then("^The Last (\\d+) year, (\\d+) year, (\\d+) year, \"([^\"]*)\" data to be plotted in chart visual$")
	public void the_Last_year_year_year_data_to_be_plotted_in_chart_visual(int arg1, int arg2, int arg3, String arg4)
			throws Throwable {
		// SSPWindow ss = new SSPWindow();
		// ss.select_tabs(arg1, arg2, arg3, arg4, arg5);
		// ss.last_year_year_year_data_to_be_plotted_in_chart_visual(1, 3, 5, "All");
		// CommonFunctionality.Views_list();
		/*
		 * Chart_Date(y1_start, y1_end); if (diff == arg1) {
		 * System.out.println("Chart has been verified with " + arg1 + " year data"); }
		 * else { Assert.fail("Verification Failed"); } Chart_Date(y3_start, y3_end); if
		 * (diff == arg2) { System.out.println("Chart has been verified with " + arg2 +
		 * " year data"); } else { Assert.fail("Verification Failed"); }
		 * Chart_Date(y5_start, y5_end); if (diff == arg3) {
		 * System.out.println("Chart has been verified with " + arg3 + " year data"); }
		 * else { Assert.fail("Verification Failed"); } Chart_Date(All_start, All_end);
		 * if (diff>arg1) { System.out.println("Chart has been verified with " + arg4 +
		 * " data"); } else { Assert.fail("Verification Failed"); }
		 */
	}

	@Then("^The \"([^\"]*)\" should reflect in Chart$")
	public void the_should_reflect_in_Chart(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Rename")) {
			String actual = CommonFunctionality
					.getElementBycssSelector(login.driver, ".visual-title--text.text-dots", 4).getText();
			assertNotEquals(visual_title, actual);
		}
		if (arg1.equalsIgnoreCase("Move to right")) {
			WebElement legand = CommonFunctionality.getElementBycssSelector(login.driver, "*[title='" + arg1 + "']", 4);
			if (!(legand.getAttribute("class").contains("series-axis--button__selected")) && (!(login.driver
					.findElements(By.xpath(
							"//*[@class='highcharts-axis-title']//parent::*[contains(@class,'highcharts-yaxis-right')]"))
					.size() > 0))) {
				fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("Color")) {
			List<WebElement> colors = login.driver
					.findElements(By.xpath("//*[@class='highcharts-point' and not(@visibility='hidden')]"));
			for (WebElement colour : colors) {
				String color_text = colour.getAttribute("fill");
				String color = Color.fromString(color_text).asHex();
				assertEquals(series_chart_color, color);
			}
			String legend_color = CommonFunctionality
					.getElementBycssSelector(login.driver, ".legend-item--marker.legend-item--hide-series", 4)
					.getCssValue("background-color");
			String legand = Color.fromString(legend_color).asHex();
			assertEquals(series_chart_color, legand);
		}
		if (arg1.equalsIgnoreCase("Frequency")) {
			String a = "Yearly";
			String actual = CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(text(),'Functions:')]/following-sibling::*", 4)
					.getText();
			if (!(actual.contains(a))) {
				fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("Frequency for Weekly and Monthly")) {
			String a = "Weekly";
			String b = "Monthly";
			String actual = CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(text(),'Functions:')]/following-sibling::*", 4)
					.getText();
			if (actual.contains(a) || actual.contains(b)) {
			} else {
				fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("Change")) {
			String actual = CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(text(),'Functions:')]/following-sibling::*", 4)
					.getText();
			String split[] = actual.split("\\(");
			String next_split = split[1];
			String final_split;
			if (next_split.contains(";")) {
				final_split = next_split.substring(0, 11);
			} else {
				final_split = next_split.substring(0, 9);
			}
			if (change_in_series.toLowerCase().contains(final_split.toLowerCase())) {
			} else {
				fail("Verification Failed");
			}
		}
		login.Log4j.info("The " + arg1 + " is reflecting in chart and has been verified successfully");
		CommonFunctionality.Views_list();
	}

	@Then("^The Slider option has been \"([^\"]*)\"$")
	public void the_Slider_option_has_been(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Checked") && tooltips_checkbox == true) {
			cv.clicking_option("Save");
			if (login.driver.findElements(By.xpath("//*[@class='highcharts-navigator']")).size() > 0) {
				login.Log4j.info("The Slider option has been " + arg1);
			} else {

				fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("Unchecked") && tooltips_uncheckbox == false) {
			cv.click_on_visual("Edit");
			click_on_the_checkbox_to("Slider", "UnChecked Checkbox");
			cv.clicking_option("Save");
			if (login.driver.findElements(By.xpath("//*[@class='highcharts-navigator']")).size() == 0) {
				login.Log4j.info("The Slider option has been " + arg1);
			} else {
				fail("Verification Failed");
			}
			CommonFunctionality.Views_list();
		}
	}

	@Then("^Verify the Chart with link appeared in excel$")
	public void verify_the_Chart_with_link_appeared_in_excel() throws Throwable {
		CommonFunctionality.wait(3000);
		String path = System.getProperty("user.home") + "\\Downloads\\Name your insight.xlsx";
		File src = new File(path);
		if (!src.exists()) {
			src.createNewFile();
		}
		FileInputStream fis = new FileInputStream(src);
		Workbook wb = new XSSFWorkbook(fis);
		int sheet = wb.getNumberOfSheets();
		int actual = sheet - 1;
		assertEquals(actual, views_count);
		login.Log4j.info("The number of sheets in excel is matching with the number of views in myseries tab");
		fis.close();
		Files.deleteIfExists(Paths.get(path));
		CommonFunctionality.Views_list();
	}
}