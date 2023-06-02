package CDMNext.StepDefinations;


import static org.testng.Assert.assertNotEquals;
import org.testng.Assert;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

@SuppressWarnings("deprecation")
public class UnitManipulation {
	
	JavascriptExecutor js = (JavascriptExecutor) login.driver;
	SoftAssert sa = new SoftAssert();
	CDMNextSprintCases cv = new CDMNextSprintCases();
	ChartVisual chart = new ChartVisual();
	Comparables cmp = new Comparables();
	CrossSection cross = new CrossSection();
	Excel1 j=new Excel1();
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
	Actions action = new Actions(login.driver);
	
	WebDriverWait wait = new WebDriverWait(login.driver, 100);
	
	
	
	public void myseries_series_list_without_functions(String arg1) throws Throwable {
	   List<WebElement> series_functions_list = login.driver.findElements(By.className("series-functions-title"));
	   for(int i=1; i<=series_functions_list.size(); i++) {
	  // new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, "div[title='More']", 4)).perform();
   	   WebElement my_series = CommonFunctionality.getElementByXpath(login.driver, "(//span[@class='series-functions-title'])["+i+"]/parent::span", 4);
   	   new Actions(login.driver).moveToElement(my_series).pause(1000).build().perform();
   	   String text = CommonFunctionality.getElementByXpath(login.driver, "(//*[contains(text(),'Series id')]/following::td/div)[1]", 4).getText().toString();
	  
		  String myseries = text;
		  System.out.println(myseries);
		  if(text.contains("(") && text.contains(")"))
				  {
			  String split[] = text.split("\\(");
			         System.out.println(split[0]);
			       
			         myseries_id=Integer.parseInt(split[0]);
			         series_id.add(myseries_id);
				  }
		  else {
		  myseries_id = Integer.parseInt(myseries);
		  System.out.println(myseries_id);
				series_id.add(myseries_id);
				  	    }
	   }
	}
	
	public void myseries_new_series_list_with_functions() throws Throwable {
	   List<WebElement> series_functions_list = login.driver.findElements(By.xpath("//*[contains(@class,'new-series-item')]//span[contains(@class,'input-control__grey')]/following::span[@class='series-functions-title']"));
	   for(int i=1; i<=series_functions_list.size(); i++) {
	  // new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, "div[title='More']", 10)).perform();
   	   WebElement my_series = CommonFunctionality.getElementByXpath(login.driver, "(//*[contains(@class,'new-series-item')]//span[contains(@class,'input-control__grey')]/following::span[@class='series-functions-title'])["+i+"]", 4);
   	   new Actions(login.driver).moveToElement(my_series).pause(1000).build().perform();
   	   String text = CommonFunctionality.getElementByXpath(login.driver, "(//*[contains(text(),'Series id')]/following::td/div)[1]", 4).getText().toString();
	  
		  String myseries = text;
		  if(myseries.contains("(")&& myseries.contains(")"))
		  {
			  String str[]=myseries.split("\\(");
			  myseries_id=Integer.parseInt(str[0]);
			  System.out.println(myseries_id);
			  new_series_id.add(myseries_id);
		  }
		  else {
		  myseries_id = Integer.parseInt(myseries);
		  System.out.println(myseries_id);
				new_series_id.add(myseries_id);
		  }
				
   	    }
		}
	   
   public void myseries_series_list_with_functions(String arg1,String arg2, String arg3) throws Throwable {
	   List<WebElement> expected_list =login.driver.findElements(By.xpath("//*[@class='series-functions-title']"));
   	   for(WebElement expected: expected_list) {
   	   String expected_text = expected.getText().toString();
   	   if(arg2.equalsIgnoreCase("Function wizard")) {
   	   String functions_text = expected_text.substring(1, expected_text.length()-1);
   	   System.out.println(functions_text);
   	   System.out.println(CrossSection.applied_function_in_fx);
   	   AssertJUnit.assertEquals(functions_text, CrossSection.applied_function_in_fx);
   	   login.Log4j.info("The applied function is present in the series and has been verified successfully");
   	   } if(arg2.equalsIgnoreCase("Output Multiplier")) {
   	   String part[] = expected_text.split("\\(");
   	   String part1[] = part[1].split("\\;");
   	   AssertJUnit.assertEquals(CrossSection.method_name, part1[0]);
   	   }
   	   //new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, "div[title='More']", 4)).perform();
   	   new Actions(login.driver).moveToElement(expected).pause(1000).build().perform();
   	   String text = CommonFunctionality.getElementByXpath(login.driver, "(//*[contains(text(),'Series id')]/following::td/div)[1]", 4).getText();
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
   
   
   @Given("^Search for the series with ID \"([^\"]*)\" and click on \"([^\"]*)\" option$")
   public void search_for_the_series_with_ID_and_click_on_option(String arg1, String arg2) throws Throwable {
       
	   Thread.sleep(2000);
	     	   
	   CommonFunctionality.DeleteSeries();
	  Thread.sleep(2000);
	   CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View results as List']", 4).click();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).clear();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(arg1);
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
	   
		//Myseries.delete_series();
		 WebElement Series=login.driver.findElement(By.xpath("(//span[contains(text(),'Series')])[1]"));
		 Thread.sleep(2000);
		 
	   try {
		    
			
		     Thread.sleep(2000);
			List<WebElement> series=login.driver.findElements(By.xpath("//div[@class='series-list-item--checkbox-wrapper']//span"));
			
			for(WebElement seri:series)
			{
				seri.click();
				
			
			}
			
			Thread.sleep(2000);
			
			action.sendKeys((Keys.chord("a"))).build().perform();
			
			
		}
		catch(StaleElementReferenceException e)
		{
			
		  
		
		Thread.sleep(2000);
		List<WebElement> series=login.driver.findElements(By.xpath("//div[@class='series-list-item--checkbox-wrapper']//span"));
		
		for(WebElement seri:series)
		{
			seri.click();
			
		}
		Thread.sleep(2000);
		
		action.sendKeys((Keys.chord("a"))).build().perform();
		


		}
   
   
   
   
   }
   
     
   
   
   @And("^Check the checkbox for Unit manipulation as \"([^\"]*)\"$")
   public void check_the_checkbox_for_Unit_manipulation_as(String arg1) throws Throwable {
	   unit_manipulation_checkbox_text = arg1;
	   boolean checkbox=login.driver.findElement(By.xpath("(//span[@class='input-control--description'])[1]//parent ::label")).isSelected();
	   if(checkbox!=true)
	   {
		   new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "(//span[@class='input-control--description'])[1]//parent ::label", 4)).click().build().perform();
		   
       }
	   
	     
	   }
   
   
    public void unit_manipulation_method_checkbox() throws Throwable {
    	List<WebElement> all_functions = login.driver.findElements(By.className("series-functions-title"));
    	for(WebElement functions: all_functions) {
    		String functions_text = functions.getText().toString();
    		System.out.println(functions_text);
    		String split[] = functions_text.split("\\; ");
    		String split1[] = split[1].split("\\(");
    		AssertJUnit.assertEquals(split1[0],unit_manipulation_checkbox_text);
    		AssertJUnit.assertEquals(split1[0], unit_manipulation_checkbox);	
    	}
    }
          
    @And("^Click \"([^\"]*)\" tab and enter \"([^\"]*)\" in search field in function window$")
	public void click_tab_and_enter_in_search_field_in_function_window(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(5000);
	//	CommonFunctionality.getElementByXpath(login.driver, "//div[@title='Cross Section']", 20).click();

		CommonFunctionality.getElementByXpath(login.driver, "(//input[@placeholder='Search'])[3]", 15)
				.sendKeys(arg2);
		CommonFunctionality
				.getElementByXpath(login.driver,
						"(//span[@class='rBp4bp9QFdeCkIQxSLEE'])[1]", 15)
				.click();
	}
    @And("^Copy the visual title$")
    public void copy_the_visual_title() throws Throwable {
    	
    	Thread.sleep(2000);
    	
    	
		WebElement mouseover=login.driver.findElement(By.xpath("//span[@class='series-name-field--series-name']"));
	
		String title=login.driver.findElement(By.xpath("//span[@class='series-name-field--series-name']")).getText().toString();
		System.out.println(title);
		action.moveToElement(mouseover).pause(3000).contextClick().build().perform();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'View as Chart')]")).click();
    	   	
    	 	    	
    	
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
	   	CommonFunctionality.getElementByXpath(login.driver, "//*[@class='page-main-header--buttons']//span[contains(text(),'Download')]", 4).click();
	   	CrossSection.Select_the_Start_Date_and_End_Date("1983-04-01", "2012-12-31");
	   	chart.uncheck_the_checkbox_for_sections("Data Refresh");
	   	CommonFunctionality.getElementByXpath(login.driver, "//*[@class='sphere-modal-controls']//*[contains(text(),'Download')]", 4).click();
    }
	
	@Then("^Rename the insight to \"([^\"]*)\" and able to apply unit manipualtion function with base series and transformed series present in \"([^\"]*)\" with \"([^\"]*)\" and \"([^\"]*)\" and the checkbox \"([^\"]*)\" and then verify \"([^\"]*)\"$")
 	public void rename_the_insight_to_and_able_to_apply_unit_manipualtion_function_with_base_series_and_transformed_series_present_in_with_and_and_the_checkbox_and_then_verify(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) throws Throwable {
		unit_manipulation_checkbox = arg5;
		if(arg1.equals("02")) {
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//button[@type='button'][contains(text(),'Apply')]", 4)).keyUp(Keys.CONTROL).pause(200).click().keyDown(Keys.CONTROL).build().perform();
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
    	//new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, "div[title='More']", 4)).perform();
    	unit_manipulation_method_checkbox();
    	rename_the_Insight_to(arg1);
    	//login.driver.findElement(By.xpath("//span[contains(text(),'Data Refresh')]/parent::label/span[1]")).click();
    	//CommonFunctionality.getElementByXpath(login.driver,"//button[@class='sphere-modal-control button insight-download__modal-button button button__download-btn']",4).click();
    	CommonFunctionality.wait(3000);
        CrossSection.Deleting_series();	
        boolean result = Arrays.equals(series_id.toArray(), series_id_with_function.toArray());
		login.Log4j.info("Series Comparision is: " +result);
		assertEquals(series_id.toArray(),series_id_with_function.toArray());
		login.Log4j.info("Both the series id are same and has been verified successfully");
	     j.enter_the_Testdata_as(arg6,cross.renamed_insight_name);
	}
	
	@Then("^Apply \"([^\"]*)\" on transformed series with renaming to \"([^\"]*)\" able to apply unit manipualtion function with base series and transformed series present in \"([^\"]*)\" with \"([^\"]*)\" and \"([^\"]*)\" and the checkbox \"([^\"]*)\" and then verify \"([^\"]*)\"$")
	public void apply_on_transformed_series_with_renaming_to_able_to_apply_unit_manipualtion_function_with_base_series_and_transformed_series_present_in_with_and_and_the_checkbox_and_then_verify(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {
		cv.click_button("Insert function");
		String function = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'ui-resizable ui-draggable')]//*[@class='series-function-item--body']", 4).getText().toString();
    	CrossSection.applied_function_in_fx = function.replaceAll("\n", "");
    	cv.click_button("Apply");
    	CommonFunctionality.wait(2000);
    	cross.count_the_total_series();
    	myseries_series_list_with_functions(arg2,arg3,arg4);
    	myseries_series_list_without_functions(arg2);
    	//new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, "div[title='More']", 4)).perform();
    	if(arg1.equalsIgnoreCase("UNIT_MULTIPLIER")) {
    	CommonFunctionality.getElementByClassName(login.driver, "function-editor-window--icon", 4).click();
    	cross.click_tab_and_enter_in_search_field("By function", "UNIT");
    	cv.click_button("Insert function");
		String function1 = CommonFunctionality.getElementByClassName(login.driver, "functions-input-container", 4).getText().toString();
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
    	new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//button[@type='button'][contains(text(),'Apply')]", 4)).keyUp(Keys.CONTROL).pause(200).click().keyDown(Keys.CONTROL).build().perform();
    	CommonFunctionality.wait(1000);
    	}
    	myseries_new_series_list_with_functions();
    	String new_series = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'new-series-item')]//span[contains(@class,'input-control__grey')]/following::span[@class='series-functions-title']", 4).getText().toString();
    	String split[]=new_series.split("\\> ");
    	String split1[] = split[0].split("\\(");
    	AssertJUnit.assertEquals(arg1, split1[0]);
    	rename_the_Insight_to(arg2);
    	CommonFunctionality.wait(3000);
        CrossSection.Deleting_series();	
        boolean result = Arrays.equals(series_id.toArray(), series_id_with_function.toArray());
		login.Log4j.info("Series Comparision is: " +result);
		AssertJUnit.assertEquals(series_id,series_id_with_function);
		login.Log4j.info("Both the series id are same and has been verified successfully");
		boolean result1 = Arrays.equals(series_id.toArray(), new_series_id.toArray());
		login.Log4j.info("Series Comparision is: " +result1);
		AssertJUnit.assertEquals(series_id,new_series_id);
		login.Log4j.info("Both the series id are same and has been verified successfully");
		j.enter_the_Testdata_as(arg7,cross.renamed_insight_name);
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
		AssertJUnit.assertEquals(series1.size(), 1);
		for(int i=1; i<=series1.size(); i++) {
			new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='series-name-field--series-name'])["+i+"]", 4)).pause(500).perform();
			String functions = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Functions')]/following-sibling::*", 4).getText();
			String split[] =functions.split("\\ > ");
			for(String functions_text:functions_list) {
				if(!functions_text.equals(split[0]) || !functions_text.equals(split[1])) {
					login.Log4j.info("The Transformed series has been replaced successfully and it has been verified");
			      } else {
			    	Assert.fail("Verification Failed");
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
	    	AssertJUnit.assertEquals(help_title, "Help on this function".toUpperCase());
	    	AssertJUnit.assertEquals(arg1, help_data_id);
	    	if(CommonFunctionality.getElementByClassName(login.driver, "function-help", 4).isDisplayed()) {
	    	String help_description = CommonFunctionality.getElementByClassName(login.driver, "function-help", 8).getText();
	    	CommonFunctionality.wait(1000);
	    	if(!help_description.contains("100 (Hundreds), TH (Thousands), MN (Millions), BN (Billions), TN (Trillions)")) {
	    		Assert.fail("Help function is placed mismatch");
	    	}
	    } else {
	    	Assert.fail("Verification Failed");
	    }
	    } else {
	    	Assert.fail("Verification Failed");
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
		String func = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Functions')]/following-sibling::*", 4).getText(); 
		if(arg1.equalsIgnoreCase("Heat map")) {
		AssertJUnit.assertEquals(func, ChartVisual.applied_function);
		} else {
		AssertJUnit.assertEquals(func, CrossSection.applied_function_in_fx);
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
	System.out.println(expected_series+","+CrossSection.actual_series);
	assertNotEquals(CrossSection.actual_series, expected_series);
//	String expected = CommonFunctionality.getElementByClassName(login.driver, "series-functions--modal-title-label", 4).getText().toString();
	//System.out.println(expected);
	if(arg1.equalsIgnoreCase("Download button")) {
	new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'sphere-modal__body')]//*[contains(@class,'button__download-btn')]", 4)).click().build().perform();
	CommonFunctionality.wait(10000);
	System.out.println(visual_tle);
	String path= System.getProperty("user.home") + "\\Downloads\\"+visual_tle+".xlsx";
	Thread.sleep(20000);
	/*FileInputStream fis = new FileInputStream(path);

	System.out.println(path);
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	fis.read();
	Thread.sleep(4000);
	 String str=wb.getSheetName(0);
	 System.out.println(str);
	 XSSFSheet sheet1=wb.getSheetAt(0);
	String data = sheet1.getRow(10).getCell(1).getStringCellValue();
	System.out.println(data);*/
	
	FileInputStream fis=new FileInputStream(path); //initialize Workbook null  


	XSSFWorkbook wb=new XSSFWorkbook(fis);  
	 
	

	
	
	wb.setActiveSheet(0);
	Sheet sheet=wb.getSheetAt(0); 
	 String str=wb.getSheetName(0);
	 System.out.println(str);
	
       


    	System.out.println(sheet.getFirstRowNum()+","+sheet.getLastRowNum());
    	System.out.println(sheet.getRow(10).getCell(2).getStringCellValue().toString());
	        String value= sheet.getRow(10).getCell(2).getStringCellValue().toString() ;
	  
	
	
	Files.deleteIfExists(Paths.get(path));
	//AssertJUnit.assertEquals(value, expected);
	
	}if(arg1.equalsIgnoreCase("Views button")) {
	 String text = CommonFunctionality.getElementBycssSelector(login.driver, ".download-area-selector__description.text-dots", 4).getText();
	 String view = text.substring(0, 4);
	 String arg = arg1.substring(0, 4);
	// AssertJUnit.assertEquals(expected, CrossSection.applied_function_in_fx);
	 assertNotEquals(view, arg);
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
	//	new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, "div[title='More']", 4)).perform();
	   	WebElement my_series = CommonFunctionality.getElementByXpath(login.driver, "(//*[contains(@class,'new-series-item')]//span[contains(@class,'input-control__grey')]/following::span[@class='series-functions-title'])["+series_functions_list.size()+"]", 4);
	   	new Actions(login.driver).moveToElement(my_series).pause(1000).build().perform();
	   	String text = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Functions')]/following-sibling::*", 4).getText();
		String part[] = text.split("\\> ");
	   	AssertJUnit.assertEquals(part[1], CrossSection.applied_function_in_fx);
	   	rename_the_Insight_to(arg1);
        CrossSection.Deleting_series();	
        boolean result = Arrays.equals(series_id.toArray(), new_series_id.toArray());
		login.Log4j.info("Series Comparision is: " +result);
		AssertJUnit.assertEquals(series_id.toArray(),new_series_id.toArray());
		login.Log4j.info("Both the series id are same and has been verified successfully");
		j.enter_the_Testdata_as(arg2,cross.renamed_insight_name);
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
		//new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, "div[title='More']", 4)).perform();
		List<WebElement> series_functions_list = login.driver.findElements(By.className("series-functions-title"));
		for(int i=1; i<=series_functions_list.size(); i++) {
	   	String text = CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='series-functions-title'])["+i+"]", 4).getText();
	   	String actual = text.substring(1, text.length()-1);
	   	AssertJUnit.assertEquals(actual, CrossSection.applied_function_in_fx);
		}
	   	rename_the_Insight_to(arg1);
        CrossSection.Deleting_series();	
        boolean result = Arrays.equals(series_id.toArray(), new_series_id.toArray());
		login.Log4j.info("Series Comparision is: " +result);
		AssertJUnit.assertEquals(series_id.toArray(),new_series_id.toArray());
		login.Log4j.info("Both the series id are same and has been verified successfully");
		j.enter_the_Testdata_as(arg2,cross.renamed_insight_name);
	}
	
	@Then("^The function should not apply for selected series$")
	public void the_function_should_not_apply_for_selected_series() throws Throwable {
		Thread.sleep(2000);
		cv.click_button("Insert function");
		cv.click_button("Apply");
		CommonFunctionality.wait(1000);
		if(login.driver.findElements(By.xpath("//*[contains(text(),'The function cannot be applied to selected series')]")).size() == 1) {
		login.Log4j.info("The function is not applied for selected series and has been verified successfully");
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		} else {
			Assert.fail("Verification Failed");
		}
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		CrossSection.Deleting_series();
	}
	
}