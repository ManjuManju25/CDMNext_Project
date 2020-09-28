package CDMNext.StepDefinations;

import static org.junit.Assert.assertNotEquals;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

@SuppressWarnings("deprecation")
public class UnitManipulation {
	
	JavascriptExecutor js = (JavascriptExecutor) login.driver;
	SoftAssert sa = new SoftAssert();
	CDMNextSprintCases cv = new CDMNextSprintCases();
	ChartVisual chart = new ChartVisual();
	Comparables cmp = new Comparables();
	CrossSection cross = new CrossSection();
	public static String functions_second_item_id;
	public static String unit_manipulation_checkbox;
	public static String unit_manipulation_checkbox_text;
	public static String visual_tle;
	public int myseries_id_with_function;
	public int myseries_id;
	ArrayList<Integer> series_id_with_function = new ArrayList<Integer>();
	ArrayList<Integer> series_id = new ArrayList<Integer>();
	ArrayList<Integer> new_series_id = new ArrayList<Integer>();
	ArrayList<String> functions_list = new ArrayList<String>();
	ArrayList<String> myseries_list = new ArrayList<String>();
	
	public void myseries_series_list_without_functions(String arg1) throws Throwable {
	   List<WebElement> series_functions_list = login.driver.findElements(By.className("series-functions-title"));
	   for(int i=1; i<=series_functions_list.size(); i++) {
	   new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, "div[title='More']", 4)).perform();
   	   WebElement my_series = CommonFunctionality.getElementByXpath(login.driver, "(//span[@class='series-functions-title'])["+i+"]/preceding::*[@class='series-name-field-title'][1]", 4);
   	   new Actions(login.driver).moveToElement(my_series).pause(1000).build().perform();
   	   String text = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Series id:')]/following-sibling::*", 4).getText();
	   if(text.contains("(")) {
		  String split[] = text.split("\\(");
		  String myseries = split[0];
		  myseries_id = Integer.parseInt(myseries);
		} else {
		  String myseries = text;
		  myseries_id = Integer.parseInt(myseries);
		}
		series_id.add(myseries_id);
   	    }
	}
	
	public void myseries_new_series_list_with_functions() throws Throwable {
	   List<WebElement> series_functions_list = login.driver.findElements(By.xpath("//*[contains(@class,'new-series-item')]//span[contains(@class,'input-control__grey')]/following::span[@class='series-functions-title']"));
	   for(int i=1; i<=series_functions_list.size(); i++) {
	   new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, "div[title='More']", 4)).perform();
   	   WebElement my_series = CommonFunctionality.getElementByXpath(login.driver, "(//*[contains(@class,'new-series-item')]//span[contains(@class,'input-control__grey')]/following::span[@class='series-functions-title'])["+i+"]", 4);
   	   new Actions(login.driver).moveToElement(my_series).pause(1000).build().perform();
   	   String text = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Series id:')]/following-sibling::*", 4).getText();
	   if(text.contains("(")) {
		  String split[] = text.split("\\(");
		  String myseries = split[0];
		  myseries_id = Integer.parseInt(myseries);
		} else {
		  String myseries = text;
		  myseries_id = Integer.parseInt(myseries);
		}
		new_series_id.add(myseries_id);
   	    }
		}
	   
   public void myseries_series_list_with_functions(String arg1,String arg2, String arg3) throws Throwable {
	   List<WebElement> expected_list =login.driver.findElements(By.xpath("//*[@class='series-functions-title']"));
   	   for(WebElement expected: expected_list) {
   	   String expected_text = expected.getText();
   	   if(arg2.equalsIgnoreCase("Function wizard")) {
   	   String functions_text = expected_text.substring(1, expected_text.length()-1);
   	   assertEquals(functions_text, CrossSection.applied_function_in_fx);
   	   login.Log4j.info("The applied function is present in the series and has been verified successfully");
   	   } if(arg2.equalsIgnoreCase("Output Multiplier")) {
   	   String part[] = expected_text.split("\\(");
   	   String part1[] = part[1].split("\\;");
   	   assertEquals(CrossSection.method_name, part1[0]);
   	   }
   	   new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, "div[title='More']", 4)).perform();
   	   new Actions(login.driver).moveToElement(expected).pause(1000).build().perform();
   	   String text = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Series id:')]/following-sibling::*", 4).getText();
	   if(text.contains("(")) {
		  String split[] = text.split("\\(");
		  String myseries = split[0];
		  myseries_id_with_function = Integer.parseInt(myseries);
		} else {
		   String myseries = text;
		   myseries_id_with_function = Integer.parseInt(myseries);
		}
		   series_id_with_function.add(myseries_id_with_function);
   	    }
    }
   
   @And("^Check the checkbox for Unit manipulation as \"([^\"]*)\"$")
   public void check_the_checkbox_for_Unit_manipulation_as(String arg1) throws Throwable {
	   unit_manipulation_checkbox_text = arg1;
	   if(!arg1.equals("")) {
       boolean checkbox = login.driver.findElement(By.xpath("//*[text()='"+unit_manipulation_checkbox_text+"']/preceding-sibling::input")).isSelected();
       if(checkbox == false) {
    	   new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[text()='"+unit_manipulation_checkbox_text+"']/preceding-sibling::span", 4)).click().build().perform();
       }
	   } else {
		unit_manipulation_checkbox_text = "Convert all multipliers";
	   }
   }
   
    public void unit_manipulation_method_checkbox() throws Throwable {
    	List<WebElement> all_functions = login.driver.findElements(By.className("series-functions-title"));
    	for(WebElement functions: all_functions) {
    		String functions_text = functions.getText();
    		String split[] = functions_text.split("\\; ");
    		String split1[] = split[1].split("\\)");
    		assertEquals(split1[0],unit_manipulation_checkbox_text);
    		assertEquals(split1[0], unit_manipulation_checkbox);	
    	}
    }
          
    @And("^Copy the visual title$")
    public void copy_the_visual_title() throws Throwable {
    	String title = CommonFunctionality.getElementBycssSelector(login.driver, ".visual-title--text.text-dots", 4).getText();
    	if(title.contains("(") && title.contains(")")) {
    		String visualtitle = title.replace("(", "");
    	    String v_title = visualtitle.replace(")", "");
    	    visual_tle = v_title.replaceAll(":", "");
    	} else {
    		visual_tle = title;
    	}
    }
    
	public void rename_the_Insight_to(String arg1) throws Throwable {
		boolean checkbox = login.driver.findElement(By.xpath("//input[@name='select_all_dataselection']")).isSelected();
		if(checkbox == false) {
	   	new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[@name='select_all_dataselection']/following-sibling::span",4)).pause(2000).click().build().perform();
		}
	   	CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'insight-breadcrumb--title__editable')]", 4).click();
	   	WebElement name = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='insight-breadcrumb--title-input']", 4);
	   	new Actions(login.driver).moveToElement(name).sendKeys(Keys.CONTROL, Keys.chord("a")).sendKeys(Keys.BACK_SPACE).build().perform();
	   	new Actions(login.driver).moveToElement(name).pause(500).sendKeys("UnitManipulation"+arg1+"").build().perform();
	   	new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, "div[title='Click to edit the Insight']", 4)).click().build().perform();
	   	CrossSection.renamed_insight_name = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'insight-breadcrumb--title__editable')]", 4).getText();
	   	CommonFunctionality.getElementByXpath(login.driver, "//*[@class='page-main-header--buttons']//*[contains(@class,'small-download-btn')]", 4).click();
	   	CrossSection.Select_the_Start_Date_and_End_Date("2001-01-01", "2010-12-31");
	   	chart.uncheck_the_checkbox_for_sections("Data Refresh");
	   	CommonFunctionality.getElementByXpath(login.driver, "//*[@class='sphere-modal-controls']//*[contains(text(),'Download')]", 4).click();
    }
	
	@Then("^Rename the insight to \"([^\"]*)\" and able to apply unit manipualtion function with base series and transformed series present in \"([^\"]*)\" with \"([^\"]*)\" and \"([^\"]*)\" and the checkbox \"([^\"]*)\" and then verify \"([^\"]*)\"$")
 	public void rename_the_insight_to_and_able_to_apply_unit_manipualtion_function_with_base_series_and_transformed_series_present_in_with_and_and_the_checkbox_and_then_verify(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) throws Throwable {
		unit_manipulation_checkbox = arg5;
		if(arg1.equals("02")) {
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, ".series-functions-panel--icon__apply", 4)).keyUp(Keys.CONTROL).pause(200).click().keyDown(Keys.CONTROL).build().perform();
		CommonFunctionality.wait(4000);
		unit_manipulation_method_checkbox();
		} else {
		cv.click_button("Insert function");
    	String function = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'ui-resizable ui-draggable')]//*[@class='series-function-item--body']", 4).getText();
    	CrossSection.applied_function_in_fx = function.replaceAll("\n", "");
    	cv.click_button("Apply");
		}
    	cross.count_the_total_series();
    	myseries_series_list_with_functions(arg2,arg3,arg4);
    	myseries_series_list_without_functions(arg2);
    	new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, "div[title='More']", 4)).perform();
    	unit_manipulation_method_checkbox();
    	rename_the_Insight_to(arg1);
    	CommonFunctionality.wait(3000);
        CrossSection.Deleting_series();	
        boolean result = Arrays.equals(series_id.toArray(), series_id_with_function.toArray());
		login.Log4j.info("Series Comparision is: " +result);
		assertEquals(series_id.toArray(),series_id_with_function.toArray());
		login.Log4j.info("Both the series id are same and has been verified successfully");
		cross.enter_the_Testdata_as(arg6);
	}
	
	@Then("^Apply \"([^\"]*)\" on transformed series with renaming to \"([^\"]*)\" able to apply unit manipualtion function with base series and transformed series present in \"([^\"]*)\" with \"([^\"]*)\" and \"([^\"]*)\" and the checkbox \"([^\"]*)\" and then verify \"([^\"]*)\"$")
	public void apply_on_transformed_series_with_renaming_to_able_to_apply_unit_manipualtion_function_with_base_series_and_transformed_series_present_in_with_and_and_the_checkbox_and_then_verify(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {
		cv.click_button("Insert function");
		String function = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'ui-resizable ui-draggable')]//*[@class='series-function-item--body']", 4).getText();
    	CrossSection.applied_function_in_fx = function.replaceAll("\n", "");
    	cv.click_button("Apply");
    	CommonFunctionality.wait(2000);
    	cross.count_the_total_series();
    	myseries_series_list_with_functions(arg2,arg3,arg4);
    	myseries_series_list_without_functions(arg2);
    	new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, "div[title='More']", 4)).perform();
    	if(arg1.equalsIgnoreCase("UNIT_MULTIPLIER")) {
    	CommonFunctionality.getElementByClassName(login.driver, "function-editor-window--icon", 4).click();
    	cross.click_tab_and_enter_in_search_field("By function", "UNIT");
    	cv.click_button("Insert function");
		String function1 = CommonFunctionality.getElementByClassName(login.driver, "functions-input-container", 4).getText();
    	CrossSection.applied_function_in_fx = function1.replaceAll("\n", "");
    	cv.click_button("Apply");
    	CommonFunctionality.wait(2000);
    	} else {
    	WebElement series = CommonFunctionality.getElementByClassName(login.driver, "current-function-input--field", 4);
    	if(arg1.equalsIgnoreCase("Multiply")) {
		series.click();
		series.sendKeys(arg1);
    	series.sendKeys(Keys.ENTER);
    	CommonFunctionality.wait(500);
    	series.sendKeys("Constant");
    	series.sendKeys(Keys.ENTER);
    	CommonFunctionality.wait(500);
    	series.sendKeys("1");
    	series.sendKeys(Keys.ENTER);
    	CommonFunctionality.wait(500);
    	} else {
    	series.click();
        series.sendKeys(arg1);
        series.sendKeys(Keys.ENTER);
        CommonFunctionality.wait(1000);
    	}
    	new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, ".series-functions-panel--icon__apply", 4)).keyUp(Keys.CONTROL).pause(200).click().keyDown(Keys.CONTROL).build().perform();
    	CommonFunctionality.wait(1000);
    	}
    	myseries_new_series_list_with_functions();
    	String new_series = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'new-series-item')]//span[contains(@class,'input-control__grey')]/following::span[@class='series-functions-title']", 4).getText();
    	String split[]=new_series.split("\\> ");
    	String split1[] = split[1].split("\\(");
    	assertEquals(arg1, split1[0]);
    	rename_the_Insight_to(arg2);
    	CommonFunctionality.wait(3000);
        CrossSection.Deleting_series();	
        boolean result = Arrays.equals(series_id.toArray(), series_id_with_function.toArray());
		login.Log4j.info("Series Comparision is: " +result);
		assertEquals(series_id.toArray(),series_id_with_function.toArray());
		login.Log4j.info("Both the series id are same and has been verified successfully");
		boolean result1 = Arrays.equals(series_id.toArray(), new_series_id.toArray());
		login.Log4j.info("Series Comparision is: " +result1);
		assertEquals(series_id.toArray(),new_series_id.toArray());
		login.Log4j.info("Both the series id are same and has been verified successfully");
		cross.enter_the_Testdata_as(arg7);
	}
	
	@Then("^The transformed series is replaced and applied functions are present in new series$")
	public void the_transformed_series_is_replaced_and_applied_functions_are_present_in_new_series() throws Throwable {
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, ".series-functions-panel--icon__apply", 4)).pause(200).click().build().perform();
		CommonFunctionality.wait(2000);
		List<WebElement> series_all = login.driver.findElements(By.className("series-function-item--body"));
		for(WebElement series:series_all) {
			String series_text = series.getText();
			String replaced_text = series_text.replaceAll("\n", "");
			functions_list.add(replaced_text);
		}
		List<WebElement> series1 = login.driver.findElements(By.className("series-functions-title"));
		assertEquals(series1.size(), 1);
		for(int i=1; i<=series1.size(); i++) {
			new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='series-name-field--series-name'])["+i+"]", 4)).pause(500).perform();
			String functions = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Functions:')]/following-sibling::*", 4).getText();
			String split[] =functions.split("\\ > ");
			for(String functions_text:functions_list) {
				if(!functions_text.equals(split[0]) || !functions_text.equals(split[1])) {
					login.Log4j.info("The Transformed series has been replaced successfully and it has been verified");
			      } else {
			    	fail("Verification Failed");
			      }
		     }
		}
		CrossSection.Deleting_series();
	}
	
	@Then("^The help field is present for \"([^\"]*)\"$")
	public void the_help_field_is_present_for(String arg1) throws Throwable {
	    if(login.driver.findElements(By.className("function-data--subtitle")).size()>0) {
	    	String help_title = CommonFunctionality.getElementBycssSelector(login.driver, ".function-data--help .function-data--subtitle", 4).getText();
	    	String help_data_id = CommonFunctionality.getElementBycssSelector(login.driver, ".function-data--help .function-data--subtitle", 4).getAttribute("data-id");
	    	CommonFunctionality.getElementBycssSelector(login.driver, ".function-data--help .function-data--subtitle", 4).click();
	    	assertEquals(help_title, "Help on this function".toUpperCase());
	    	assertEquals(arg1, help_data_id);
	    	if(CommonFunctionality.getElementByClassName(login.driver, "function-help", 4).isDisplayed()) {
	    	String help_description = CommonFunctionality.getElementByClassName(login.driver, "function-help", 8).getText();
	    	CommonFunctionality.wait(1000);
	    	if(!help_description.contains("100 (Hundreds), TH (Thousands), MN (Millions), BN (Billions), TN (Trillions)")) {
	    		fail("Help function is placed mismatch");
	    	}
	    } else {
	    	fail("Verification Failed");
	    }
	    } else {
	    	fail("Verification Failed");
	    }
	    CommonFunctionality.Hidden_Webelements_handling(login.driver, "className", "movable-modal--close");
	    CrossSection.Deleting_series();
	}
	
	@Then("^The function should apply successfully in \"([^\"]*)\"$")
	public void the_function_should_apply_successfully(String arg1) throws Throwable {
		if(!(arg1.equalsIgnoreCase("Heat map"))) {
		cv.click_button("Insert function");
		String function = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-function-item--body']", 4).getText();
    	CrossSection.applied_function_in_fx = function.replaceAll("\n", "");
		cv.click_button("Apply");
		}
		CommonFunctionality.wait(1000);
		String series_name = null;
		if(arg1.equalsIgnoreCase("Pie") || arg1.equalsIgnoreCase("Heat map")) {
		series_name = CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='series-name--title'])[1]", 4).getText();
		} else {
		series_name = CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='series-item--name'])[1]", 4).getText();
		}
		if(arg1.equalsIgnoreCase("Pie")) {
		CommonFunctionality.wait(1000);
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'series-edit--title__editable') and contains(text(),'"+series_name+"')]", 4)).pause(1000).build().perform();	
		} if(arg1.equalsIgnoreCase("Heat map")) {
		CommonFunctionality.wait(1000);
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'legend-item')]/following::*[contains(text(),'"+series_name+"')]", 4)).pause(1000).build().perform();
		} if(arg1.equalsIgnoreCase("Chart")) {
		CommonFunctionality.wait(1000);
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'legend-item--marker')]//following-sibling::*[contains(text(),'"+series_name+"')]", 4)).pause(1000).build().perform();
		}
		String func = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Functions:')]/following-sibling::*", 4).getText(); 
		if(arg1.equalsIgnoreCase("Heat map")) {
		assertEquals(func, ChartVisual.applied_function);
		} else {
		assertEquals(func, CrossSection.applied_function_in_fx);
		}
		login.Log4j.info("The functions are applied to the series and has been verified successfully");
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, "span[data-name='title']", 4)).perform();	
		CommonFunctionality.Views_list();
   }
	
	@Then("^The \"([^\"]*)\" in Download window is to be present$")
	public void the_in_Download_window_has_to_be_present(String arg1) throws Throwable {
	cv.click_button("Insert function");
	String function = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'ui-resizable ui-draggable')]//*[@class='series-function-item--body']", 4).getText();
	CrossSection.applied_function_in_fx = function.replaceAll("\n", "");
	cv.click_button("Apply");
	CommonFunctionality.wait(500);
	String count = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'download-area-selector__description')]/following-sibling::span", 4).getText();
	String number;
	if(count.contains("(")) {
		number = count.substring(1,2);
	} else {
		number = count.substring(0,2);
	}
	int expected_series = Integer.parseInt(number);
	assertNotEquals(CrossSection.actual_series, expected_series);
	String expected = CommonFunctionality.getElementByClassName(login.driver, "series-functions--modal-title-label", 4).getText();
	if(arg1.equalsIgnoreCase("Download button")) {
	new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'sphere-modal__body')]//*[contains(@class,'button__download-btn')]", 4)).click().build().perform();
	CommonFunctionality.wait(3000);
	String path= System.getProperty("user.home") + "\\Downloads\\" +visual_tle+".xlsx";
	File src = new File(path);
	FileInputStream fis = new FileInputStream(src);
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	XSSFSheet sheet1 = wb.getSheetAt(0);
	String data = sheet1.getRow(10).getCell(2).getStringCellValue();
	Files.deleteIfExists(Paths.get(path));
	assertEquals(data, expected);
	fis.close();
	}if(arg1.equalsIgnoreCase("Views button")) {
	 String text = CommonFunctionality.getElementBycssSelector(login.driver, ".download-area-selector__description.text-dots", 4).getText();
	 String view = text.substring(0, 4);
	 String arg = arg1.substring(0, 4);
	 assertEquals(expected, CrossSection.applied_function_in_fx);
	 assertEquals(view, arg);
	 CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
	}
	login.Log4j.info("The "+arg1+" in Download window is present and has been verified Successfully");
	CommonFunctionality.Views_list();
	}
	
	@Then("^Apply both function and rename series as \"([^\"]*)\" then validate the Testdata as \"([^\"]*)\"$")
	public void apply_both_function_and_rename_series_as_then_validate_the_Testdata_as(String arg1, String arg2) throws Throwable {
		cv.click_button("Insert function");
		cv.click_button("Apply"); 
		CommonFunctionality.wait(2000);
		cv.select_all_series_from_myseries_and_click_on_option("Open function editor");
		cross.click_tab_and_enter_in_search_field("By function", "UNIT");
		cv.click_button("Insert function");
		String function = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'ui-resizable ui-draggable')]//*[@class='series-function-item--body']", 4).getText();
		CrossSection.applied_function_in_fx = function.replaceAll("\n", "");
		cv.click_button("Apply");
		CommonFunctionality.wait(2000);
		myseries_series_list_without_functions("");
		myseries_new_series_list_with_functions();
		List<WebElement> series_functions_list = login.driver.findElements(By.xpath("//*[contains(@class,'new-series-item')]//span[contains(@class,'input-control__grey')]/following::span[@class='series-functions-title']"));
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, "div[title='More']", 4)).perform();
	   	WebElement my_series = CommonFunctionality.getElementByXpath(login.driver, "(//*[contains(@class,'new-series-item')]//span[contains(@class,'input-control__grey')]/following::span[@class='series-functions-title'])["+series_functions_list.size()+"]", 4);
	   	new Actions(login.driver).moveToElement(my_series).pause(1000).build().perform();
	   	String text = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Functions:')]/following-sibling::*", 4).getText();
		String part[] = text.split("\\> ");
	   	assertEquals(part[1], CrossSection.applied_function_in_fx);
	   	rename_the_Insight_to(arg1);
        CrossSection.Deleting_series();	
        boolean result = Arrays.equals(series_id.toArray(), new_series_id.toArray());
		login.Log4j.info("Series Comparision is: " +result);
		assertEquals(series_id.toArray(),new_series_id.toArray());
		login.Log4j.info("Both the series id are same and has been verified successfully");
		cross.enter_the_Testdata_as(arg2);
	}
	
	@Then("^Apply function and rename series as \"([^\"]*)\" then validate the Testdata as \"([^\"]*)\"$")
	public void apply_function_and_rename_series_as_then_validate_the_Testdata_as(String arg1, String arg2) throws Throwable {
		cv.click_button("Insert function");
		String function = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'ui-resizable ui-draggable')]//*[@class='series-function-item--body']", 4).getText();
		CrossSection.applied_function_in_fx = function.replaceAll("\n", "");
		cv.click_button("Apply");
		CommonFunctionality.wait(2000);
		myseries_series_list_without_functions("");
		myseries_new_series_list_with_functions();
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, "div[title='More']", 4)).perform();
		List<WebElement> series_functions_list = login.driver.findElements(By.className("series-functions-title"));
		for(int i=1; i<=series_functions_list.size(); i++) {
	   	String text = CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='series-functions-title'])["+i+"]", 4).getText();
	   	String actual = text.substring(1, text.length()-1);
	   	assertEquals(actual, CrossSection.applied_function_in_fx);
		}
	   	rename_the_Insight_to(arg1);
        CrossSection.Deleting_series();	
        boolean result = Arrays.equals(series_id.toArray(), new_series_id.toArray());
		login.Log4j.info("Series Comparision is: " +result);
		assertEquals(series_id.toArray(),new_series_id.toArray());
		login.Log4j.info("Both the series id are same and has been verified successfully");
		cross.enter_the_Testdata_as(arg2);
	}
	
	@Then("^The function should not apply for selected series$")
	public void the_function_should_not_apply_for_selected_series() throws Throwable {
		cv.click_button("Insert function");
		cv.click_button("Apply");
		CommonFunctionality.wait(1000);
		if(login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal-dialog')]//*[contains(text(),'The function cannot be applied to all selected series')]")).size() == 1) {
		login.Log4j.info("The function is not applied for selected series and has been verified successfully");
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		} else {
			fail("Verification Failed");
		}
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		CrossSection.Deleting_series();
	}
}