package CDMNext.StepDefinations;

import static org.testng.Assert.fail;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileFilter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.collect.Ordering;

import CDMNext.util.CommonFunctionality;
import Javaxlxs.Last_file_download;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class TableVisual {
	
	
	public static String FunctionApplied;
	//TC_TV_01
	@And("^create visual tab$")
	public void create_visual_tab() throws Throwable 
	{
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CreateViewTab"))).click();
	}
	//TC_TV_01
	@SuppressWarnings("deprecation")
	@And("^drag and drop the table visual$")
	public void drag_and_drop_the_table_visual() throws Throwable 
	{
		
		Actions action = new Actions(login.driver);
		WebDriverWait wait = new WebDriverWait(login.driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("TableVisual"))));
		WebElement sourceLocator = CommonFunctionality.getElementByProperty(login.driver, "TableVisual", 4);
        WebElement targetLocator = CommonFunctionality.getElementByProperty(login.driver, "DropTable", 4);
        action.clickAndHold(sourceLocator).pause(2000).dragAndDrop(sourceLocator, targetLocator).build().perform();
       

	}
	//TC_TV_01
	@And("^verify the Table visual creating from View panel by drag and drop$")
	public void verify_the_Table_visual_creating_from_View_panel_by_drag_and_drop() throws Throwable {
		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("ResultTableVisual"))).size() != 0) 
		{
			System.out.println("Table visual creating from View panel by drag and drop is working fine");
		} else 
		{
			Assert.fail("Table visual creating from View panel by drag and drop is Not working fine");
		}
		CommonFunctionality.Views_list();
	}
	
	//TC_TV_02
	@And("^select the table visual$")
	public void select_the_table_visual() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TableVisual"))).click();
	}
	//TC_TV_02
	@And("^verify the Table visual creating from View panel by clicking$")
	public void verify_the_Table_visual_creating_from_View_panel_by_clicking() throws Throwable {
		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("ResultTableVisual"))).size() != 0) 
		{
			System.out.println("Table visual creating from View panel by clicking is working fine");
		} else 
		{
			Assert.fail("Table visual creating from View panel by clicking is Not working fine");
		}
		CommonFunctionality.Views_list();
	}
	//TC_TV_03
	@And("^Applay function$")
	public void applay_function() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_select_all"))).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("function_applay"))).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("First_function_applay"))).click();
		Thread.sleep(5000);
		
		 Thread.sleep(1000);
		  Actions action = new Actions(login.driver);
			WebElement we = login.driver.findElement(By.xpath("//div[@class='webix_column list-series-name webix_last']/div[1]/div[1]/div[1]/div[1]/span[1]/span"));
			action.moveToElement(we).pause(5000).build().perform();
		String function_series_name = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ToolTip_Function"))).getText();
	
		FunctionApplied = function_series_name;
		
	}
	//TC_TV_03
	@And("^create table for applied function$")
	public void create_table_for_applied_function() throws Throwable {
		Thread.sleep(5000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_T);
		
	}
	//TC_TV_03
	@And("^verify Table visual creating with function applied series$")
	public void verify_Table_visual_creating_with_function_applied_series() throws Throwable {
		Thread.sleep(5000);
		
		 Actions action = new Actions(login.driver);
			WebElement we = login.driver.findElement(By.xpath("//*[@class='series-edit--title']"));
			action.moveToElement(we).pause(5000).build().perform();
		String Function_Tabel=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ToolTip_Function"))).getText();
		String s1 = Function_Tabel;
		System.out.println(s1 +":" + FunctionApplied );
		
		if(FunctionApplied.equalsIgnoreCase(s1)){
			System.out.println("Table visual creating with function applied series is working fine");
	} else 
	{
		Assert.fail("Table visual creating with function applied series is Not working fine");
	}
	
		CommonFunctionality.Views_list();
	}
	
	
	//TC_TV_04
	@And("^verify Edit Table button is disable$")
	public void verify_Edit_Table_button_is_disable() throws Throwable {
		Thread.sleep(5000);
		boolean editTable = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edittable"))).isEnabled();
	   if(editTable==false)
	   {
		   System.out.println("Edit Table button is disable");
	   }
	   else{
		   Assert.fail("Edit Table button is NOT disable");
	   }
	   Thread.sleep(2000);
		CommonFunctionality.Views_list();
	}
	//TC_TV_05
	@And("^verify Edit series button$")
	public void verify_Edit_series_button() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesopen"))).isDisplayed());
		  System.out.println("Edit series Opened");
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
		Thread.sleep(2000);
		CommonFunctionality.Views_list();
	}
	
	//TC_TV_06
	@And("^verify default tab for Edit series option$")
	public void verify_default_tab_for_Edit_series_option() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		Thread.sleep(2000);
		if(login.driver.getPageSource().contains("Add from My Series"));
		
		else
		
			Assert.fail();
		
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
		Thread.sleep(2000);
		CommonFunctionality.Views_list();
	}
	//TC_TV_07
	@And("^verify description message for empty visual if have series in My series$")
	public void verify_description_message_for_empty_visual_if_have_series_in_My_series() throws Throwable {
		select_the_table_visual();
		Thread.sleep(5000); 
		if(login.driver.getPageSource().contains("Add from My Series") && login.driver.getPageSource().contains("Drag series here")) ;
		
		else
		
			Assert.fail();
		
		Thread.sleep(2000);
		CommonFunctionality.Views_list();
	}
	
	//TC_TV_08
	@And("^verify description message for empty visual if have NO series in My series$")
	public void verify_description_message_for_empty_visual_if_have_NO_series_in_My_series() throws Throwable {
		select_the_table_visual();
		Thread.sleep(2000);
		if(login.driver.getPageSource().contains("Drag series here"));
		else
			Assert.fail();
	
	Thread.sleep(2000);
	CommonFunctionality.Views_list();
	}
	//TC_TV_09
	@And("^verify Add from my series option$")
	public void verify_Add_from_my_series_option() throws Throwable {
		select_the_table_visual();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("AddfromMySeries"))).click();
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Listandtable"))).isDisplayed());
		  System.out.println("Add from my series option is verified");
		  Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
			Thread.sleep(2000);
			CommonFunctionality.Views_list();
	}
	//TC_TV_10
	@And("^verify Table tab when no series added for visual$")
	public void verify_Table_tab_when_no_series_added_for_visual() throws Throwable {
		select_the_table_visual();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("AddfromMySeries"))).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TableinEditSeries"))).click();
		Thread.sleep(5000); 
		if(login.driver.getPageSource().contains("There are no series for selected visual. Please add series from"));
		else
			Assert.fail();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
		Thread.sleep(2000);
		CommonFunctionality.Views_list();
	}
	//TC_TV_11
	@And("^verify \\+ Add from My Series option in edit series panel$")
	public void verify_Add_from_My_Series_option_in_edit_series_panel() throws Throwable {
		select_the_table_visual();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("AddfromMySeries"))).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TableinEditSeries"))).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("AddfromMySeriesTable"))).click();
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Listandtable"))).isDisplayed());
		  System.out.println("Add from my series option is verified");
		  Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
			Thread.sleep(2000);
			CommonFunctionality.Views_list();
	}
	//Close_window
	
	//TC_TV_12
	@And("^verify Verify adding series to empty visual$")
	public void verify_Verify_adding_series_to_empty_visual() throws Throwable {
		select_the_table_visual();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("AddfromMySeries"))).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SelectAllinEditSeries"))).click();
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TableCreated"))).isDisplayed());
		 Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
			Thread.sleep(2000);
			CommonFunctionality.Views_list();
	}
	
	
	
	//TC_TV_13
	@And("^verify default attributes for Table visual$")
	public void verify_default_attributes_for_Table_visual() throws Throwable {
		//select_the_table_visual();
		CreateTable();
		Thread.sleep(2000);
		List<WebElement>  TableAtttribute = login.driver.findElements(By.xpath("//tr[@class=' heading']/th[1]"));
		for(WebElement VerifyTableAtttribute : TableAtttribute ){
			Thread.sleep(2000);
			String TableAtttributes = VerifyTableAtttribute.getText();
			System.out.println(TableAtttributes);
			if(TableAtttributes.contains("Name") || TableAtttributes.contains("Region") || TableAtttributes.contains("Frequency") || TableAtttributes.contains("Unit") || TableAtttributes.contains("Series ID" )|| TableAtttributes.contains("First Date") || TableAtttributes.contains("Last Date") || TableAtttributes.contains("Last Updated")){
				System.out.println( " TableAtttributes are Verified Successfully ");
			}
			else{
				Assert.fail();
				
			}
			
		}
		Thread.sleep(2000);
		CommonFunctionality.Views_list();
	}
	
	
	//TC_TV_14
	@And("^verify the attributes rows$")
	public void verify_the_attributes_rows() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		List<WebElement>  TableAtttribute = login.driver.findElements(By.xpath("//tr[@class=' heading']/th[2]"));
		if(TableAtttribute.size()==8){
			System.out.println( "Verified the attributes rows ");
		}
		else{
			Assert.fail();
		}
		Thread.sleep(2000);
		CommonFunctionality.Views_list();
	}
	
	
	
	//TC_TV_15
	@And("^verify removing attributes by clicking x icon$")
public void verify_removing_attributes_by_clicking_x_icon() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		Actions action = new Actions(login.driver);
		WebDriverWait wait = new WebDriverWait(login.driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='series-edit--title']")));
		//WebElement Sereiesnameintable =login.driver.findElement(By.xpath("//span[@class='series-edit--title']"));
		//action.moveToElement(Sereiesnameintable).build().perform();
		action.moveToElement(login.driver.findElement(By.xpath("//span[@class='series-edit--title']"))).build().perform();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RemoveIconseries"))).click();
		verify_the_Table_visual_creating_from_View_panel_by_drag_and_drop();
		Thread.sleep(2000);
		CommonFunctionality.Views_list();
}
	
	//TC_TV_16
	@And("^verify clicking on series name$")
	public void verify_clicking_on_series_name() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		Actions action = new Actions(login.driver);
		WebDriverWait wait = new WebDriverWait(login.driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='series-edit--title']")));
		WebElement Sereiesnameintable =login.driver.findElement(By.xpath("//span[@class='series-edit--title']"));
		action.moveToElement(Sereiesnameintable).click().build().perform();
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Dialogue"))).isDisplayed());
		  System.out.println("verified clicking on series name");
		  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Dialogue_X_Icon"))).click();
		  Thread.sleep(2000);
			CommonFunctionality.Views_list();
	}
	
	//TC_TV_17
	@And("^verify Edit series on visual$")
	public void verify_Edit_series_on_visual() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		Actions action = new Actions(login.driver);
		WebDriverWait wait = new WebDriverWait(login.driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='series-edit--title']")));
		WebElement Sereiesnameintable =login.driver.findElement(By.xpath("//span[@class='series-edit--title']"));
		action.moveToElement(Sereiesnameintable).build().perform();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditseriesTable"))).click();
		String[] exp = {"Rename","Frequency","Change"};
		 List<WebElement> options = login.driver.findElements(By.xpath("//ul[@class='dropdown-menu context-menu edit-series--context-menu']/div[3]/li"));
		 for(WebElement we:options)  
		 {  
		  boolean match = false;
		  for (int j=0; j<exp.length; j++)
		  {
			  String X= we.getText();
		      if (X.equals(exp[j])){
		    	  System.out.println(X + exp[j] );
		        match = true;
		        System.out.println("DropDown is verified successfully");
		      }
		    }
		  //Assert.assertTrue(match);
		  if(match = false){
			  Assert.fail();
		  }
		 }
		 Thread.sleep(2000);
		CommonFunctionality.Views_list();
		
	}
	
	
	
	//TC_TV_18
	@And("^Select the rename option in tabel visual$")
	public void select_the_rename_option_in_tabel_visual() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		Actions action = new Actions(login.driver);
		WebDriverWait wait = new WebDriverWait(login.driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='series-edit--title']")));
		WebElement Sereiesnameintable =login.driver.findElement(By.xpath("//span[@class='series-edit--title']"));
		action.moveToElement(Sereiesnameintable).build().perform();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditseriesTable"))).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Series_TV"))).click();
	}
	//TC_TV_18
	@And("^verify Rename option from cogwheel icon$")
	public void verify_Rename_option_from_cogwheel_icon() throws Throwable {
		Thread.sleep(2000);
		Actions action = new Actions(login.driver);
		WebElement RenameSeriesTV =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Search")));
		RenameSeriesTV.clear();
		String Renaming="Testing";
		RenameSeriesTV.sendKeys(Renaming);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Applay_Button"))).click();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OK_Button"))).click();
		Actions action1 = new Actions(login.driver);
		WebElement Sereiesnameintable =login.driver.findElement(By.xpath("//span[@class='series-edit--title']"));
		action1.moveToElement(Sereiesnameintable).build().perform();
		String AfterRenaming = login.driver.findElement(By.xpath("//span[@class='series-edit--title']")).getText();
		if(Renaming.equalsIgnoreCase(AfterRenaming)){
			System.out.println("Verified Successfully");
		}
	
	else{
		Assert.fail();
	    }
		 Thread.sleep(2000);
			CommonFunctionality.Views_list();
	}
	
	//TC_TV_19
	@And("^Select the Frequency option in tabel visual$")
	public void select_the_Frequency_option_in_tabel_visual() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		Actions action = new Actions(login.driver);
		WebDriverWait wait = new WebDriverWait(login.driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='series-edit--title']")));
		WebElement Sereiesnameintable =login.driver.findElement(By.xpath("//span[@class='series-edit--title']"));
		action.moveToElement(Sereiesnameintable).build().perform();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditseriesTable"))).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Frquency_Series_TV"))).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Frequency_replicate"))).click();
	}
	//TC_TV_19
	@And("^verify Frequency option from cogwheel icon$")
	public void verify_Frequency_option_from_cogwheel_icon() throws Throwable {
		Actions action = new Actions(login.driver);
		WebElement Sereiesnameintable =login.driver.findElement(By.xpath("//span[@class='series-edit--title']"));
		action.moveToElement(Sereiesnameintable).build().perform();
		Thread.sleep(2000);
		String FunctionApplied = login.driver.findElement(By.xpath("//span[@class='series-edit--title']")).getText();
		System.out.println(FunctionApplied);
		
		if(FunctionApplied.contains("DISAGGREGATE(Weekly; Sunday; Replicate)")){
			System.out.println("Verified Successfully");
		}
		else{
			Assert.fail();
		}
		Thread.sleep(2000);
		CommonFunctionality.Views_list();
	}
	
	//TC_TV_20
	@And("^Select the Currency option in tabel visual$")
	public void select_the_Currency_option_in_tabel_visual() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		Actions action = new Actions(login.driver);
		WebDriverWait wait = new WebDriverWait(login.driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='series-edit--title']")));
		WebElement Sereiesnameintable =login.driver.findElement(By.xpath("//span[@class='series-edit--title']"));
		action.moveToElement(Sereiesnameintable).build().perform();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditseriesTable"))).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Currency_Series_TV"))).click();
		Thread.sleep(5000);
		try
		{
		//Actions ac=new Actions(login.driver);
		WebElement rub =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Currency_RUB")));
		//ac.moveToElement(rub).click().build().perform();
		((JavascriptExecutor)login.driver).executeScript("arguments[0].click();", rub);
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex) {
			WebElement rub =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Currency_RUB")));
			//ac.moveToElement(rub).click().build().perform();
			((JavascriptExecutor)login.driver).executeScript("arguments[0].click();", rub);
		}
	}
	//TC_TV_20
	@And("^verify Currency option from cogwheel icon$")
	public void verify_Currency_option_from_cogwheel_icon() throws Throwable {
		Actions action = new Actions(login.driver);
		WebElement Sereiesnameintable =login.driver.findElement(By.xpath("//span[@class='series-edit--title']"));
		action.moveToElement(Sereiesnameintable).build().perform();
		Thread.sleep(2000);
		String FunctionApplied = login.driver.findElement(By.xpath("//span[@class='series-edit--title']")).getText();
		System.out.println(FunctionApplied);
		
		if(FunctionApplied.contains("(Russian Ruble; as reported)")){
			System.out.println("Verified Successfully");
		}
		else{
			Assert.fail();
		}
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Reset')]")).click();
		Thread.sleep(2000);
		CommonFunctionality.Views_list();
	}
	
	//TC_TV_21
	@And("^Select the Change option in tabel visual$")
	public void select_the_Change_option_in_tabel_visual() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		Actions action = new Actions(login.driver);
		WebDriverWait wait = new WebDriverWait(login.driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='series-edit--title']")));
		WebElement Sereiesnameintable =login.driver.findElement(By.xpath("//span[@class='series-edit--title']"));
		action.moveToElement(Sereiesnameintable).build().perform();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditseriesTable"))).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Change_Series_TV"))).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Change_pop"))).click();
	}
	//TC_TV_21
	@And("^verify Change option from cogwheel icon$")
	public void verify_Change_option_from_cogwheel_icon() throws Throwable {
		Actions action = new Actions(login.driver);
		WebElement Sereiesnameintable =login.driver.findElement(By.xpath("//span[@class='series-edit--title']"));
		action.moveToElement(Sereiesnameintable).build().perform();
		Thread.sleep(2000);
		String FunctionApplied = login.driver.findElement(By.xpath("//span[@class='series-edit--title']")).getText();
		System.out.println(FunctionApplied);
		
		if(FunctionApplied.contains("%CHANGE(Over Period; 1; Yes)")){
			System.out.println("Verified Successfully");
		}
		else{
			Assert.fail();
		}
		Thread.sleep(2000);
		CommonFunctionality.Views_list();
	}
	//TC_TV_22
	@And("^verify Remove series icon$")
	public void verify_Remove_series_icon() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		Actions action = new Actions(login.driver);
		WebElement Sereiesnameintable =login.driver.findElement(By.xpath("//span[@class='series-edit--title']"));
		action.moveToElement(Sereiesnameintable).build().perform();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RemoveIconseries"))).click();
		verify_the_Table_visual_creating_from_View_panel_by_drag_and_drop();
		Thread.sleep(2000);
		CommonFunctionality.Views_list();
	}
	
	
	
	
	
	
	//TC_TV_23
	@And("^verify tooltip for series$")
	public void verify_tooltip_for_series() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		Actions action = new Actions(login.driver);
		WebElement Sereiesnameintable =login.driver.findElement(By.xpath("//span[@class='series-edit--title']"));
		action.moveToElement(Sereiesnameintable).build().perform();
		Thread.sleep(1000);
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text"))).isDisplayed());
		Thread.sleep(2000);
		CommonFunctionality.Views_list();
	}
	
	//TC_TV_24
	@And("^verify scroll down till end of timepoints$")
	public void verify_scroll_down_till_end_of_timepoints() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) login.driver;
		WebElement element = login.driver.findElement(By.xpath("//div[contains(text(),'Source: CEIC Data')]"));
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(3000);
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEICData_Source"))).isDisplayed());
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Reset')] ")).click();
		Thread.sleep(2000);
		CommonFunctionality.Views_list();
	}
	
	//TC_TV_25
	@And("^verify Name field when scroll down$")
	public void verify_Name_field_when_scroll_down() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) login.driver;
		WebElement element = login.driver.findElement(By.xpath("//div[contains(text(),'Source: CEIC Data')]"));
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name"))).isDisplayed());
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Reset')] ")).click();
		Thread.sleep(2000);
		CommonFunctionality.Views_list();
	}
	
	//TC_TV_27
	@SuppressWarnings("deprecation")
	@And("^verify double click on title$")
	public void verify_double_click_on_title() throws Throwable {
		CreateTable();
		Thread.sleep(5000);
		Actions action = new Actions(login.driver);
		WebElement Sereiesnameintable =login.driver.findElement(By.xpath("(//div[@class='visual-title visual-select-area visual-title--wrapper']/span)[1]"));
		action.moveToElement(Sereiesnameintable).pause(3000).doubleClick().build().perform();
		Thread.sleep(1000);
		Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("POP_title"))).isDisplayed());
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("POP_title_close"))).click();
		Thread.sleep(2000);
		CommonFunctionality.Views_list();
		
	}
	
	//TC_TV_28
	@And("^verify clicking on edit icon for title$")
	public void verify_clicking_on_edit_icon_for_title() throws Throwable {

		CreateTable();
		Thread.sleep(2000);
		Actions action = new Actions(login.driver);
		WebElement Sereiesnameintable =login.driver.findElement(By.xpath("//i[@class='visual-title--icon visual-title--edit']"));
		action.moveToElement(Sereiesnameintable).click().build().perform();
		Thread.sleep(1000);
		Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("POP_title"))).isDisplayed());
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("POP_title_close"))).click();
		Thread.sleep(2000);
		CommonFunctionality.Views_list();
	}
	
	//TC_TV_29
	@And("^verify double click on attribute area$")
	public void verify_double_click_on_attribute_area() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		Actions action = new Actions(login.driver);
		WebElement Sereiesnameintable =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name")));
		action.moveToElement(Sereiesnameintable).doubleClick().build().perform();
		Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Attributrpopup"))).isDisplayed());
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Attributeclose"))).click();
		Thread.sleep(2000);
		CommonFunctionality.Views_list();
	}
	//TC_TV_30
	@And("^verify Attributes popup -select all$")
	public void verify_Attributes_popup_select_all() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		
		List<WebElement> attributes_list = login.driver.findElements(By.className("hor-vertical-header"));
		int attributes_table_count_before = attributes_list.size();
		
		Actions action = new Actions(login.driver);
		WebElement Sereiesnameintable =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name")));
		action.moveToElement(Sereiesnameintable).doubleClick().build().perform();
		
		WebElement title_checkbox_webElement = CommonFunctionality.getElementByXpath(login.driver,
				"//*[text()='Title']/following::*[contains(@class,'input-control__sm')][1]", 4);
		title_checkbox_webElement.click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Attributeclose"))).click();
		
		List<WebElement> attributes_list_after = login.driver.findElements(By.className("hor-vertical-header"));
		int attributes_table_count_after = attributes_list_after.size();
		
		if (attributes_table_count_after != attributes_table_count_before){
			System.out.println("Verified");
		}
		else{
			Assert.fail();
		}
		Thread.sleep(2000);
		CommonFunctionality.Views_list();
	}
	//TC_TV_31
	@And("^verify Attributes popup -unselect all$")
	public void verify_Attributes_popup_unselect_all() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		Actions action = new Actions(login.driver);
		WebElement Sereiesnameintable =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name")));
		action.moveToElement(Sereiesnameintable).doubleClick().build().perform();
		
		Actions action1 = new Actions(login.driver);
		WebElement title_checkbox_webElement = CommonFunctionality.getElementByXpath(login.driver,
				"//*[text()='Title']/following::*[contains(@class,'input-control__sm')][1]", 4);
		action1.moveToElement(title_checkbox_webElement).doubleClick().build().perform();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Attributeclose"))).click();
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Name"))).size() == 0) {
			System.out.println("Verified");
		}
		else{
			Assert.fail();
		}
		Thread.sleep(2000);
		CommonFunctionality.Views_list();
	}
	
	//TC_TV_32
	@SuppressWarnings("deprecation")
	@And("^verify drag and drop attributes to change their order$")
	public void verify_drag_and_drop_attributes_to_change_their_order() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		Actions action = new Actions(login.driver);
		WebElement Sereiesnameintable =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name")));
		action.moveToElement(Sereiesnameintable).doubleClick().build().perform();
		
		Actions action1 = new Actions(login.driver);
				WebElement sourceLocator = CommonFunctionality.getElementByProperty(login.driver, "Attributepopup_name", 4);
		        WebElement targetLocator = CommonFunctionality.getElementByProperty(login.driver, "Attributepopup_FD", 4);
		        action1.clickAndHold(sourceLocator).pause(2000).dragAndDrop(sourceLocator, targetLocator).build().perform();
		        Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Attributeclose"))).click();
		        Thread.sleep(2000);
				CommonFunctionality.Views_list();
	}
	
	
	//TC_TV_33
	@And("^verify Attributes popup - Statistics$")
	public void verify_Attributes_popup_Statistics() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		
		List<WebElement> attributes_list = login.driver.findElements(By.className("hor-vertical-header"));
		int attributes_table_count_before = attributes_list.size();
		
		Actions action = new Actions(login.driver);
		WebElement Sereiesnameintable =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name")));
		action.moveToElement(Sereiesnameintable).doubleClick().build().perform();
		
		 Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Statistics_attributr"))).click();
		WebElement title_checkbox_webElement = CommonFunctionality.getElementByXpath(login.driver,
				"//div[contains(text(),'Statistics')]//following :: div[11]/div/label/span", 4);
		title_checkbox_webElement.click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Attributeclose"))).click();
		
		List<WebElement> attributes_list_after = login.driver.findElements(By.className("hor-vertical-header"));
		int attributes_table_count_after = attributes_list_after.size();
		
		if (attributes_table_count_after != attributes_table_count_before){
			System.out.println("Verified");
		}
		else{
			Assert.fail();
		}
		Thread.sleep(2000);
		CommonFunctionality.Views_list();
		
		
	}
	
	
	
	//TC_TV_34
	@And("^verify Attributes popup - Statistics unselect all$")
	public void verify_Attributes_popup_Statistics_unselect_all() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		Actions action = new Actions(login.driver);
		WebElement Sereiesnameintable =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name")));
		action.moveToElement(Sereiesnameintable).doubleClick().build().perform();
		 Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Statistics_attributr"))).click();
		Actions action1 = new Actions(login.driver);
		WebElement title_checkbox_webElement = CommonFunctionality.getElementByXpath(login.driver,
				"//div[contains(text(),'Statistics')]//following :: div[11]/div/label/span", 4);
		action1.moveToElement(title_checkbox_webElement).click().build().perform();
		Thread.sleep(2000);
		action1.moveToElement(title_checkbox_webElement).click().build().perform();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Attributeclose"))).click();
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Statistics_mean"))).size() == 0) {
			System.out.println("Verified");
		}
		else{
			Assert.fail();
		}
		Thread.sleep(2000);
		CommonFunctionality.Views_list();
	}
	//TC_TV_35
	@And("^verify drag and drop Statistics attributes to change their order$")
	public void verify_drag_and_drop_Statistics_attributes_to_change_their_order() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		Actions action = new Actions(login.driver);
		WebElement Sereiesnameintable =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name")));
		action.moveToElement(Sereiesnameintable).doubleClick().build().perform();
		
		Actions action1 = new Actions(login.driver);
				WebElement sourceLocator = CommonFunctionality.getElementByProperty(login.driver, "Attributepopup_name", 4);
		        WebElement targetLocator = CommonFunctionality.getElementByProperty(login.driver, "Attributepopup_FD", 4);
		        action1.clickAndHold(sourceLocator).pause(2000).dragAndDrop(sourceLocator, targetLocator).build().perform();
		        Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Attributeclose"))).click();
		        Thread.sleep(2000);
				CommonFunctionality.Views_list();
	}
	//TC_TV_36
	@And("^verify default statistics selection for Table visual$")
	public void verify_default_statistics_selection_for_Table_visual() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		Actions action = new Actions(login.driver);
		WebElement Sereiesnameintable =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name")));
		action.moveToElement(Sereiesnameintable).doubleClick().build().perform();
		 Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Statistics_attributr"))).click();
		boolean statstitlecheckbox=login.driver.findElement(By.xpath("//div[contains(text(),'Statistics')]//following :: div[11]/div/label/span")).isSelected();       
		if(statstitlecheckbox==false){
                	 System.out.println("Verified");
                 }
                 else{
                	 Assert.fail();
                 }
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Attributeclose"))).click();
		  Thread.sleep(2000);
			CommonFunctionality.Views_list();
	}
	
	//TC_TV_37
	@And("^verify expand/collapse attribute and statistics sections$")
	public void verify_expand_collapse_attribute_and_statistics_sections() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		Actions action = new Actions(login.driver);
		WebElement Sereiesnameintable =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name")));
		action.moveToElement(Sereiesnameintable).doubleClick().build().perform();
		 Thread.sleep(2000);
		 if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Attribute_verification"))).size() != 0) {
				System.out.println("Verified");
				login.driver.findElement(By.xpath("(//div[@class='icon-collapse'])[2]")).click();
			}
		 if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Statistics_mean"))).size() != 0 )
		 {
			// (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Attribute_verification"))).size() == 0)
				System.out.println("Verified");
				login.driver.findElement(By.xpath("(//div[@class='icon-expand'])[2]")).click();
			}
		
		 else{
			 Assert.fail();
		 }
		 Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Attributeclose"))).click();
			  Thread.sleep(2000);
				CommonFunctionality.Views_list();
			
	}
	
	
	//TC_TV_36
	@And("^verify double clicking on date field$")
	public void verify_double_clicking_on_date_field() throws Throwable {
		CreateTable();
		Thread.sleep(6000);
		Actions action = new Actions(login.driver);
		WebElement Sereiesnameintable =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Date_visual")));
		action.moveToElement(Sereiesnameintable).doubleClick().build().perform();
		 Thread.sleep(2000);
		 Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Date_popup"))).isDisplayed());
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Date_Close"))).click();
		 Thread.sleep(2000);
			CommonFunctionality.Views_list();
	}
	
	//TC_TV_37
	@And("^verify double clicking on timepoints$")
	public void verify_double_clicking_on_timepoints() throws Throwable {
		CreateTable();
		Thread.sleep(6000);
		Actions action = new Actions(login.driver);
		WebElement Sereiesnameintable =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Timepoints_visual")));
		action.moveToElement(Sereiesnameintable).doubleClick().build().perform();
		 Thread.sleep(2000);
		 Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Date_popup"))).isDisplayed());
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Date_Close"))).click();
		 Thread.sleep(2000);
			CommonFunctionality.Views_list();
	}
	
	//TC_TV_38
	@And("^verify Edit series option for Table visual$")
	public void verify_Edit_series_option_for_Table_visual() throws Throwable {
		CreateTable();
		Thread.sleep(4000);
		Actions action = new Actions(login.driver);
		WebElement Sereiesnameintable =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Series")));
		action.moveToElement(Sereiesnameintable).doubleClick().build().perform();
		boolean Editseries=login.driver.findElement(By.xpath("//*[contains(text(),'Edit Series')]")).isEnabled();       
		if(Editseries==false){
                	 System.out.println("Verified");
                 }
                 else{
                	 Assert.fail();
                 }
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
		  Thread.sleep(2000);
			CommonFunctionality.Views_list();
	}
	
	
	
	//TC_TV_39
	@And("^verify series under Table tab$")
	public void verify_series_under_Table_tab() throws Throwable {
		Thread.sleep(4000);
		String BeforeSName = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Firstseries_getname"))).getText();
		CreateTable();
		Thread.sleep(4000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(4000);	
		 String AfterSName = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries"))).getText();
              if(BeforeSName.equalsIgnoreCase(AfterSName)){
            	  System.out.println("Verified");
              }
              else
              {
            	  Assert.fail();
              }
              Thread.sleep(2000);
      		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
      		  Thread.sleep(2000);
      			CommonFunctionality.Views_list();
	}
	
	
	
	//TC_TV_40
	@And("^verify Rename option$")
	public void verify_Rename_option() throws Throwable {
		CreateTable();
		Thread.sleep(4000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(4000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_popup"))).isDisplayed());
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_popup_close"))).click();
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
		 Thread.sleep(2000);
			CommonFunctionality.Views_list();
		
	}
	//TC_TV_41
	@And("^Select more than one series to my series tab$")
	public void select_more_than_one_series_to_my_series_tab() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
		for (int i = 1; i <= 3; i++) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//ul[@class='search-series-list']/li[" + i + "]/div/a/div[2]")).click();
		}
		Thread.sleep(5000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_T);
		Thread.sleep(500);   
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Applay_Button"))).click();
		if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Close_window"))).size()>0) {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		}
		else {
			System.out.println("No Pop up appeared....");
		}
	}
	
	
	
	//TC_TV_42
	@And("^verify number of selected series in Rename pop up$")
	public void verify_number_of_selected_series_in_Rename_pop_up() throws Throwable {
     
		Thread.sleep(24000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 List<WebElement> SName =  login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries")));
		 int TotalSname =SName.size();
		 Thread.sleep(4000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(2000);
		 String selectedseries =  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Selectedseries_Renamepopup"))).getText();
		 String numberOnly= selectedseries.replaceAll("[^0-9]", "");
		 int TotalSnamerenamepop=Integer.parseInt(numberOnly);
		 if(TotalSname ==  TotalSnamerenamepop){
			 System.out.println("Verified");
		 }
		  else
          {
        	  Assert.fail();
          }
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_popup_close"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
		 Thread.sleep(2000);
			CommonFunctionality.Views_list();
		 
	}
	//TC_TV_43
	@And("^verify number of available itmes in Rename pop Find field$")
	public void verify_number_of_available_itmes_in_Rename_pop_Find_field() throws Throwable {
		Thread.sleep(24000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 List<WebElement> SName =  login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries")));
		 int TotalSname =SName.size();
		 Thread.sleep(4000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(2000);
		 String selectedseries =  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_count_find"))).getText();
		 String numberOnly= selectedseries.replaceAll("[^0-9]", "");
		 int TotalSnamerenamepop=Integer.parseInt(numberOnly);
		 if(TotalSname ==  TotalSnamerenamepop){
			 System.out.println("Verified");
		 }
		  else
         {
       	  Assert.fail();
         }
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_popup_close"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
		 Thread.sleep(2000);
			CommonFunctionality.Views_list();
	}
	
	//TC_TV_44
	@And("^verify find field in Rename pop$")
	public void verify_find_field_in_Rename_pop() throws Throwable {
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 String Findseriesbefore =  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries_first"))).getText();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Find_search_box"))).sendKeys(Findseriesbefore);
				 Thread.sleep(2000);
				 String Findseriesafter =  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Find_Validation"))).getText();
				 if(Findseriesbefore.equalsIgnoreCase(Findseriesafter)){
					 System.out.println("Verified");
				 }
				 else{
					  Assert.fail();
				 }
				 
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_popup_close"))).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
				 Thread.sleep(2000);
					CommonFunctionality.Views_list();
	}
	
	//TC_TV_45
	@And("^verify find number of searched result$")
	public void verify_find_number_of_searched_result() throws Throwable {
		Thread.sleep(4000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 String Findseriesbefore =  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries_first"))).getText();	
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Find_search_box"))).sendKeys(Findseriesbefore);
				 List<WebElement> SName =  login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Find_Validation")));
				 int TotalSname =SName.size();
				 String selectedseries =  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_count_find"))).getText();
				 String numberOnly= selectedseries.replaceAll("[^0-9]", "");
				 int TotalSnamerenamepop=Integer.parseInt(numberOnly);
				 if(TotalSname ==  TotalSnamerenamepop){
					 System.out.println("Verified");
				 }
				  else
		         {
		       	  Assert.fail();
		         }
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_popup_close"))).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
				 Thread.sleep(2000);
				CommonFunctionality.Views_list();
				 
	}
	
	//TC_TV_46
	@And("^verify Replace field in Rename pop$")
	public void verify_Replace_field_in_Rename_pop() throws Throwable {
		Thread.sleep(4000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		Thread.sleep(2000);
		 String ReplaceFind = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Replace_first"))).getAttribute("value");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Find_search_box"))).sendKeys(ReplaceFind);
			Thread.sleep(2000);
			String Replaceafter = "Testing";
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Replace_search_box"))).sendKeys(Replaceafter);
		    Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Replace"))).click();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OK_Button"))).click();
			Thread.sleep(3000);
			String Editseriesafterreplace = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries_first"))).getText();
			if(Editseriesafterreplace.equalsIgnoreCase(Replaceafter)){
				 System.out.println("Verified");
			}
			else{
				 Assert.fail();
			}
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
			 Thread.sleep(2000);
			CommonFunctionality.Views_list();
			
	}
	
	//TC_TV_47
	@And("^verify Replace button in Rename pop$")
	public void verify_Replace_button_in_Rename_pop() throws Throwable {
		verify_Replace_field_in_Rename_pop();
	}
	//TC_TV_48
	@And("^verify Replace All button in Rename pop$")
	public void verify_Replace_All_button_in_Rename_pop() throws Throwable {
		Thread.sleep(4000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		Thread.sleep(2000);
		 String ReplaceFind = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Replace_first"))).getAttribute("value");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Find_search_box"))).sendKeys(ReplaceFind);
			Thread.sleep(2000);
			String Replaceafter = "Testing";
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Replace_search_box"))).sendKeys(Replaceafter);
		    Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Replace_All"))).click();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OK_Button"))).click();
			Thread.sleep(3000);
			String Editseriesafterreplace = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries_first"))).getText();
			if(Editseriesafterreplace.equalsIgnoreCase(Replaceafter)){
				 System.out.println("Verified");
			}
			else{
				 Assert.fail();
			}
			/*Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();*/
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
			 Thread.sleep(2000);
			CommonFunctionality.Views_list();
	}
	
	
	
	
	
	
	
	//TC_TV_48
	@And("^Select same series to my series tab$")
	public void select_same_series_to_my_series_tab() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MyInsight_Tab"))).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
		
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//ul[@class='search-series-list']/li[1]/div/a/div[2]")).click();
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_T);
			r.keyRelease(KeyEvent.VK_T);
			for (int i = 1; i <= 3; i++) 
			{
		Thread.sleep(4000);
		login.driver.findElement(By.xpath("(//div[@class='add-to-data-selection--title'])[1]")).click();
		}	
	}
	
	
	
	//TC_TV_49
	@And("^verify Replace for selected series in Rename pop$")
	public void verify_Replace_for_selected_series_in_Rename_pop() throws Throwable {
		verify_Replace_field_in_Rename_pop();
	}
	
	
	
	//TC_TV_50
	@And("^verify find next button in Rename pop$")
	public void verify_find_next_button_in_Rename_pop() throws Throwable {
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		Thread.sleep(2000);
		boolean findnextbutton = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Find_Next"))).isDisplayed();
		if(findnextbutton==true)
		{
			 System.out.println("Verified");
		}
		else{
			 Assert.fail();
		}
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
		 Thread.sleep(2000);
		CommonFunctionality.Views_list();
	}
	//TC_TV_51
	@And("^verify Replace, Replace All and find next buttons by default$")
	public void verify_Replace_Replace_All_and_find_next_buttons_by_default() throws Throwable {
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		Thread.sleep(2000);
		boolean findnextbutton = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("find_and_replace"))).isDisplayed();
		if(findnextbutton==true)
		{
			 System.out.println("Verified");
		}
		else{
			 Assert.fail();
		}
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
		 Thread.sleep(2000);
		CommonFunctionality.Views_list();
	}

	//TC_TV_52
	@And("^verify for invalid search$")
	public void verify_for_invalid_search() throws Throwable {
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Find_search_box"))).sendKeys("TESTING");
			String Nomatchesfound ="No matches found";
			String No_matches_found= login.driver.findElement(By.xpath(login.LOCATORS.getProperty("No_matches_found"))).getText();
			System.out.println(No_matches_found);
			if(No_matches_found.endsWith(Nomatchesfound))
			{
				System.out.println("verified");
			}else {
				Assert.fail();
			}
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
			 Thread.sleep(2000);
			CommonFunctionality.Views_list();
	}
	
	//TC_TV_53
	@And("^verify Edit series info dropdown$")
	public void verify_Edit_series_info_dropdown() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info"))).click();
		 String[] Dropdown = {"Name","Function description","Unit","Frequency"," Region"};
		 
		 List<WebElement> dropdownvaue =  login.driver.findElements(By.xpath("//select[@class='find-and-replace--attribute-selector']/option"));
		for(WebElement we :dropdownvaue){
			 boolean match =false;
			 for (int i=0; i<Dropdown.length; i++)
			 {
			      if (we.getText().equals(Dropdown[i]))
			      {
			        match = true;
			        System.out.println(we +":"+ Dropdown[i] );
			        
			        System.out.println("verified");
			      }
			 }
		 }
		 
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
			 Thread.sleep(2000);
			CommonFunctionality.Views_list();
		 
	}
	
	
	//TC_TV_54
	@And("^verify default selection for Edit series info dropdown$")
	public void verify_default_selection_for_Edit_series_info_dropdown() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(2000);
		 String y= "Name";
		 String Editinfodefault = login.driver.findElement(By.xpath("//select[@class='find-and-replace--attribute-selector']/option")).getText();
	      if(Editinfodefault.contains(y)) {
	    	  System.out.println("verified");
	      }
	      else {
	    	  Assert.fail();
	      }
	      
	      login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
			 Thread.sleep(2000);
			CommonFunctionality.Views_list();
	}
	
	
	
	
	//TC_TV_55
	@And("^verify Rename Name selection$")
	public void verify_Rename_Name_selection() throws Throwable {
		CreateTable();
		
		 
		String series_name = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Seriesnametable"))).getText();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(2000);
		 String Rename_series_name = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_first_series"))).getAttribute("value");
		 
			if(series_name.equalsIgnoreCase(Rename_series_name)){
				 System.out.println("Verified");
			}
			else{
				 Assert.fail();
			}
		 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
				 Thread.sleep(2000);
				CommonFunctionality.Views_list();
		 
		 
	}
	
	
	//TC_TV_56
	@And("^verify Rename Function description selection$")
	public void verify_Rename_Function_description_selection() throws Throwable {
	
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_dropdown"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_FD"))).click();
		 Thread.sleep(2000);
		 String Rename_fseries_name = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_first_series"))).getAttribute("value");
		if(FunctionApplied.equalsIgnoreCase(Rename_fseries_name)){
			System.out.println("Verified");
		}
		else{
			 Assert.fail();
		}
		
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
		 Thread.sleep(2000);
		CommonFunctionality.Views_list();
 
	}
	
	//TC_TV_57
	@And("^verify Rename function description selection without function apply$")
	public void verify_Rename_function_description_selection_without_function_apply() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_dropdown"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_FD"))).click();
		 String Rename_fseries_name = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_first_series"))).getAttribute("value");
		
		 if(Rename_fseries_name.isEmpty()){
				System.out.println("Verified");
			}
			else{
				 Assert.fail();
			}
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
			 Thread.sleep(2000);
			CommonFunctionality.Views_list();
	}

	//TC_TV_58
	@And("^verify editing function description$")
	public void verify_editing_function_description() throws Throwable {
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_dropdown"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_FD"))).click();
		 Thread.sleep(2000);
		 String x="Testing";
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_first_series"))).clear();
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_first_series"))).sendKeys(x);
		
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OKRename"))).click();
		 Thread.sleep(8000);
		 String Y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("series_name_title"))).getText();
		 String[] parts = Y.split(";");
		 String part2 = parts[1]; 
		 System.out.println("Verified" + x +  part2);
		 
		if(!x.contains(part2))
		{
			System.out.println("Verified");
		}
		else {
			 Assert.fail();
		}
		 
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
		 Thread.sleep(2000);
		CommonFunctionality.Views_list();
		 
	}
	//TC_TV_59
	@And("^verify adding function description$")
	public void verify_adding_function_description() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_dropdown"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_FD"))).click();
		 
		 Thread.sleep(2000);
		 String x="SUM";
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_first_series"))).sendKeys(x);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OKRename"))).click();
		 String Y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("series_name_title"))).getText();
		 String[] parts = Y.split(";");
		 String part2 = parts[1].replaceAll("\\s+",""); 
		 System.out.println("Verified" + x +  part2);
		 
		if(x.contains(part2))
		{
			System.out.println("Verified");
		}
		else {
			 Assert.fail();
		}
		 
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
		 Thread.sleep(2000);
		CommonFunctionality.Views_list();
	}
	
	
	//TC_TV_60
	@And("^verify Function discription apply original title icon$")
	public void verify_Function_discription_apply_original_title_icon() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_dropdown"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_FD"))).click();
		 
		 Thread.sleep(2000);
		 String x="SUM";
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_first_series"))).sendKeys(x);
		boolean Apply =  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Applay_Button"))).isEnabled();
				if(Apply==true) {
					System.out.println("Verified");
				}else {
					Assert.fail();
				}
		
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OKRename"))).click();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
				 Thread.sleep(2000);
				CommonFunctionality.Views_list();
	}
	
	
	
	
	//TC_TV_61
	@And("^verify Function discription Apply original title icon behavior$")
	public void verify_Function_discription_Apply_original_title_icon_behavior() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_dropdown"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_FD"))).click();
		 
		 Thread.sleep(2000);
		 String x="SUM";
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_first_series"))).sendKeys(x);
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Origional_icon_behaviour"))).click();
		 Thread.sleep(2000);
		 String Rename_fseries_name = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_first_series"))).getAttribute("value");
		 if(Rename_fseries_name.isEmpty()){
				System.out.println("Verified");
			}
			else{
				 Assert.fail();
			}
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
			 Thread.sleep(2000);
			CommonFunctionality.Views_list();
	}
	
	
	//TC_TV_62
	@And("^verify Function discription  Apply original title for all series icon$")
	public void verify_Function_discription_Apply_original_title_for_all_series_icon() throws Throwable {
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(1000);
		 ArrayList<String> ar = new ArrayList<String>();
		 String x= login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).getAttribute("value");
		 ar.add(x);
		 Thread.sleep(1000);
		 String y= login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_secondall_series"))).getAttribute("value");
		 ar.add(y);
		 Thread.sleep(1000);
		 String z= login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_thirdall_series"))).getAttribute("value");
		 ar.add(z);
		 System.out.println("Verified" + ar.toString());
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).clear();
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).sendKeys("Testing1");
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_secondall_series"))).clear();
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_secondall_series"))).sendKeys("Testing2");
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_thirdall_series"))).clear();
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_thirdall_series"))).sendKeys("Testing3");
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_Series_back"))).click();
		 Thread.sleep(1000);
		 ArrayList<String> ar1 = new ArrayList<String>();
		 String x1= login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).getAttribute("value");
		 ar1.add(x1);
		 Thread.sleep(1000);
		 String y1= login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_secondall_series"))).getAttribute("value");
		 ar1.add(y1);
		 Thread.sleep(1000);
		 String z1= login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_thirdall_series"))).getAttribute("value");
		 ar1.add(z1);
		 System.out.println("Verified123" + ar1.toString());
		 if(ar.equals(ar1)) {
			 System.out.println("Verified");
			}
			else{
				 Assert.fail();
			}
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
			 Thread.sleep(2000);
			CommonFunctionality.Views_list();
			
			
	}
	
	//TC_TV_63
	@And("^verify Function discription  clicking on series name$")
	public void verify_Function_discription_clicking_on_series_name() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_dropdown"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_FD"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Link_series"))).click();
		 Thread.sleep(2000);
		 if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("SSPtable"))).size() != 0) 
			{
				System.out.println("Verified");
			} else 
			{
				Assert.fail();
			}
		 Thread.sleep(2000);
		 Actions ac=new Actions(login.driver);
		WebElement Close = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSPtable_close_table")));
		ac.moveToElement(Close).click().build().perform();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
			 Thread.sleep(2000);
			CommonFunctionality.Views_list();
			
		 
	}
	
	//TC_TV_64
	@And("^verify Name Editing series name$")
	public void verify_Name_Editing_series_name() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).clear();
		 String x = "Testing";
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).sendKeys(x);
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OKRename"))).click();
		 Thread.sleep(2000);
		 String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_series_rename"))).getText().replaceAll("\\s+","");
		 if(x.equalsIgnoreCase(y)) {
			 System.out.println("Verified");
		 }
		 else {
			 Assert.fail();
		 }
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
		 Thread.sleep(2000);
		CommonFunctionality.Views_list();
	}
	
	
	//TC_TV_65
	@And("^verify Apply original title icon$")
	public void verify_Apply_original_title_icon() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(1000);
		 String x= login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).getAttribute("value");
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).clear();
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).sendKeys("Testing1");
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_Series_back"))).click();
		 Thread.sleep(1000);
		 String y= login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).getAttribute("value");
		 if(x.equalsIgnoreCase(y)) {
			 System.out.println("Verified");
		 }
		 else {
			 Assert.fail();
		 }
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
		 Thread.sleep(2000);
		CommonFunctionality.Views_list();
	}
	
	
	//TC_TV_66
	@And("^verify Apply original title for all series icon$")
	public void verify_Apply_original_title_for_all_series_icon() throws Throwable {
		verify_Function_discription_Apply_original_title_for_all_series_icon();
	}
	
	
	
	//TC_TV_67
	@And("^verify < icon if no changes in series attributes$")
	public void verify_icon_if_no_changes_in_series_attributes() throws Throwable {
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(1000);
		 
		 
			boolean icon =  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_Series_back"))).isEnabled();
			System.out.println("Verified" + icon);
			if(icon==true) {
				System.out.println("Verified");
			}else {
				Assert.fail();
			}
	
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
			 Thread.sleep(2000);
			CommonFunctionality.Views_list();
	}
	
	//TC_TV_68
	@And("^verify Region selection$")
	public void verify_Region_selection() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		String x =  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_Region"))).getText();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(1000);
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_dropdown"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Region"))).click();
		 String y= login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).getAttribute("value");
		 if(x.equalsIgnoreCase(y)) {
			 System.out.println("Verified");
		 }
		 else {
			 Assert.fail();
		 }
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
		 Thread.sleep(2000);
		CommonFunctionality.Views_list();
	}
		
	//TC_TV_69
	@And("^verify Editing series region$")
	public void verify_Editing_series_region() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		String x =  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_Region"))).getText();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Addbutton_rename"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Addbutton_region"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_dropdown"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Region"))).click();
		 Thread.sleep(2000);
		 String a= " TestingRegion";
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).clear();
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).sendKeys(a);
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OKRename"))).click();
		 Thread.sleep(2000);
		 
		 String Y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_series_rename"))).getText();
		 String[] parts = Y.split(";");
		 String part2 = parts[1]; 
		 System.out.println("Verified" + a +  part2);
		 
		if(a.matches(part2))
		{
			System.out.println("Verified");
		}
		else {
			 Assert.fail();
		}
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
		 Thread.sleep(2000);
		CommonFunctionality.Views_list();
	}
	//TC_TV_70
	@And("^verify Region Apply original region icon$")
	public void verify_Region_Apply_original_region_icon() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Addbutton_rename"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Addbutton_region"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_dropdown"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Region"))).click();
		 Thread.sleep(2000);
		 String a= " TestingRegion";
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).clear();
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).sendKeys(a);
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OKRename"))).click();
		
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_dropdown"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Region"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_Series_back"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OKRename"))).click();
		 Thread.sleep(2000);
		 String Y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_series_rename"))).getText();
		 String[] parts = Y.split(";");
		 String part2 = parts[1].replaceAll("\\s+",""); 
		 Thread.sleep(2000);
		String table_region = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_Region"))).getText();
		if(part2.equalsIgnoreCase(table_region)) {
			System.out.println("Verified");
		}
		else {
			 Assert.fail();
		}
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
		 Thread.sleep(2000);
		CommonFunctionality.Views_list();
	}

	
	//TC_TV_71
	@And("^verify Region Apply original region for all series icon$")
	public void verify_Region_Apply_original_region_for_all_series_icon() throws Throwable {
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Addbutton_rename"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Addbutton_region"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_dropdown"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Region"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).clear();
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).sendKeys("Testing1");
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_secondall_series"))).clear();
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_secondall_series"))).sendKeys("Testing2");
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_thirdall_series"))).clear();
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_thirdall_series"))).sendKeys("Testing3");
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OKRename"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_dropdown"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Region"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_Series_back"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OKRename"))).click();
		 Thread.sleep(2000);
		 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_second_rename_region_sname"))).getText();
		 String[] parts1 = x.split(";");
		 String Firstseries = parts1[1].replaceAll("\\s+","");
		 System.out.println(Firstseries);
		 
		 String Y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_Third_rename_region_sname"))).getText();
		 String[] parts2 = Y.split(";");
		 
		 String secondseries = parts2[1].replaceAll("\\s+",""); 
		 System.out.println(secondseries);
		 String z = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_fourth_rename_region_sname"))).getText();
		 String[] parts3 = z.split(";");
		 String thirdseries = parts3[1].replaceAll("\\s+","");
		 System.out.println(thirdseries);
		 Thread.sleep(2000);
		 String a = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_second_rename_region"))).getText().replaceAll("\\s+","");
		 String b = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_Third_rename_region"))).getText().replaceAll("\\s+","");
		 String c = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_fourth_rename_region"))).getText().replaceAll("\\s+","");
	
		 System.out.println("Verified region"     +Firstseries + a +  secondseries+b +   thirdseries+c       );
		 
		 Thread.sleep(2000);
		 if(Firstseries.equalsIgnoreCase(a) && secondseries.equalsIgnoreCase(b) &&  thirdseries.equalsIgnoreCase(c)) {
			 System.out.println("Verified");
			}
			else {
				 Assert.fail();
			}
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
			 Thread.sleep(2000);
			CommonFunctionality.Views_list();
		 
	}

	
	
	
	//TC_TV_72
	@And("^verify unit Editing series unit$")
	public void verify_unit_Editing_series_unit() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Addbutton_rename"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Addbutton_unit"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_dropdown"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_unit"))).click();
		 
		 Thread.sleep(2000);
		 String a= " Testingunit";
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).clear();
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).sendKeys(a);
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OKRename"))).click();
		 
		 Thread.sleep(5000);
		 String Y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_series_rename"))).getText();
		 String[] parts = Y.split(";");
		 String part2 = parts[1].replaceAll("\\s+",""); 
		 
		
		 if(a.contains(part2)) {
			 System.out.println("Verified");
		 }
		 else {
			 Assert.fail();
		 }
		
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
		 Thread.sleep(2000);
		CommonFunctionality.Views_list();
	}

	
	//TC_TV_73
	@And("^verify unit Apply original unit icon$")
	public void verify_unit_Apply_original_unit_icon() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Addbutton_rename"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Addbutton_unit"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_dropdown"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_unit"))).click();
		 
		 Thread.sleep(2000);
		 String a= " Testingunit";
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).clear();
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).sendKeys(a);
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OKRename"))).click();
		 
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_dropdown"))).click();
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_unit"))).click();
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_Series_back"))).click();
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OKRename"))).click();
			 
			 Thread.sleep(2000);
			 String Y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_series_rename"))).getText();
			 String[] parts = Y.split(";");
			 String part2 = parts[1].replaceAll("\\s+",""); 
			 Thread.sleep(2000);
			String table_unit = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_unit"))).getText().replaceAll("\\s+","");
			 System.out.println("123"+ table_unit+ part2);
			
			 if(part2.equalsIgnoreCase(table_unit)) {
				System.out.println("Verified");
			}
			else {
				 Assert.fail();
			}
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
			 Thread.sleep(2000);
			CommonFunctionality.Views_list();
	}

	
	
	
	
	//TC_TV_74
	@And("^verify unit Apply original unit for all series icon$")
	public void verify_unit_Apply_original_unit_for_all_series_icon() throws Throwable {
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Addbutton_rename"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Addbutton_unit"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_dropdown"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_unit"))).click();
		 Thread.sleep(2000);
		 
		 
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).clear();
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).sendKeys("Testing1");
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_secondall_series"))).clear();
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_secondall_series"))).sendKeys("Testing2");
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_thirdall_series"))).clear();
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_thirdall_series"))).sendKeys("Testing3");
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OKRename"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_dropdown"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_unit"))).click();
		 Thread.sleep(2000);
		 
		 
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_Series_back"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OKRename"))).click();
		 Thread.sleep(2000);
		 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_second_rename_region_sname"))).getText();
		 String[] parts1 = x.split(";");
		 String Firstseries = parts1[1].replaceAll("\\s+","");
		 System.out.println(Firstseries);
		 
		 String Y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_Third_rename_region_sname"))).getText();
		 String[] parts2 = Y.split(";");
		 
		 String secondseries = parts2[1].replaceAll("\\s+",""); 
		 System.out.println(secondseries);
		 String z = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_fourth_rename_region_sname"))).getText();
		 String[] parts3 = z.split(";");
		 String thirdseries = parts3[1].replaceAll("\\s+","");
		 System.out.println(thirdseries);
		 Thread.sleep(2000);
		 String a = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_second_rename_unit"))).getText().replaceAll("\\s+","");
		 String b = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_Third_rename_unit"))).getText().replaceAll("\\s+","");
		 String c = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_fourth_rename_unit"))).getText().replaceAll("\\s+","");
		 
		 System.out.println("Verified region"     +Firstseries + a +  secondseries+b +   thirdseries+c       );
		 
		 Thread.sleep(2000);
		 if(Firstseries.equalsIgnoreCase(a) && secondseries.equalsIgnoreCase(b) &&  thirdseries.equalsIgnoreCase(c)) {
			 System.out.println("Verified");
			}
			else {
				 Assert.fail();
			}
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
			 Thread.sleep(2000);
			CommonFunctionality.Views_list();
		 
		 
		 
		 
	}
	
	
	//TC_TV_75
	@And("^verify frequency Editing series frequency$")
	public void verify_frequency_Editing_series_frequency() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Addbutton_rename"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Addbutton_frequency"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_dropdown"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_frequency"))).click();
		 Thread.sleep(2000);
		 String a= " TestingRegion";
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).clear();
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).sendKeys(a);
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OKRename"))).click();
		 Thread.sleep(2000);
		 
		 String Y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_series_rename"))).getText();
		 String[] parts = Y.split(";");
		 String part2 = parts[1]; 
		 System.out.println("Verified" + a +  part2);
		 
		if(a.matches(part2))
		{
			System.out.println("Verified");
		}
		else {
			 Assert.fail();
		}
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
		 Thread.sleep(2000);
		CommonFunctionality.Views_list();
	}
	
	
	
	
	
	//TC_TV_76
	@And("^verify frequency Apply original frequency icon$")
	public void verify_frequency_Apply_original_frequency_icon() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Addbutton_rename"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Addbutton_frequency"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_dropdown"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_frequency"))).click();
		 
		 Thread.sleep(2000);
		 String a= " Testingunit";
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).clear();
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).sendKeys(a);
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OKRename"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_dropdown"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_frequency"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_Series_back"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OKRename"))).click();
		 
		 Thread.sleep(2000);
		 String Y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_series_rename"))).getText();
		 String[] parts = Y.split(";");
		 String part2 = parts[1].replaceAll("\\s+",""); 
		 Thread.sleep(2000);
		String table_frequency = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_frquency"))).getText().replaceAll("\\s+","");
		 System.out.println("123"+ table_frequency+ part2);
		
		 if(part2.equalsIgnoreCase(table_frequency)) {
				System.out.println("Verified");
			}
			else {
				 Assert.fail();
			}
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
			 Thread.sleep(2000);
			CommonFunctionality.Views_list();
		 
	}
	
	//TC_TV_77
	@And("^verify frequency Apply original frequency for all series icon$")
	public void verify_frequency_Apply_original_frequency_for_all_series_icon() throws Throwable {
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Addbutton_rename"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Addbutton_frequency"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_dropdown"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_frequency"))).click();
		 Thread.sleep(2000);
		 
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).clear();
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).sendKeys("Testing1");
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_secondall_series"))).clear();
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_secondall_series"))).sendKeys("Testing2");
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_thirdall_series"))).clear();
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_thirdall_series"))).sendKeys("Testing3");
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OKRename"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_dropdown"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_frequency"))).click();
		 Thread.sleep(2000);
		 
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_Series_back"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OKRename"))).click();
		 Thread.sleep(2000);
		 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_second_rename_region_sname"))).getText();
		 String[] parts1 = x.split(";");
		 String Firstseries = parts1[1].replaceAll("\\s+","");
		 System.out.println(Firstseries);
		 
		 String Y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_Third_rename_region_sname"))).getText();
		 String[] parts2 = Y.split(";");
		 
		 String secondseries = parts2[1].replaceAll("\\s+",""); 
		 System.out.println(secondseries);
		 String z = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_fourth_rename_region_sname"))).getText();
		 String[] parts3 = z.split(";");
		 String thirdseries = parts3[1].replaceAll("\\s+","");
		 System.out.println(thirdseries);
		 
		 
		 
		 
		 String a = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_second_rename_frequency"))).getText().replaceAll("\\s+","");
		 String b = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_third_rename_frequency"))).getText().replaceAll("\\s+","");
		 String c = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_fourth_rename_frequency"))).getText().replaceAll("\\s+","");
		 
		 System.out.println("Verified region"     +Firstseries + a +  secondseries+b +   thirdseries+c       );
		 
		 Thread.sleep(2000);
		 if(Firstseries.equalsIgnoreCase(a) && secondseries.equalsIgnoreCase(b) &&  thirdseries.equalsIgnoreCase(c)) {
			 System.out.println("Verified");
			}
			else {
				 Assert.fail();
			}
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
			 Thread.sleep(2000);
			CommonFunctionality.Views_list();
	
	}
	
	
	
	//TC_TV_78
	@And("^verify Rename Auto name check box$")
	public void verify_Rename_Auto_name_check_box() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(1000);
		 boolean checkbox = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Autoname_checkbox"))).isSelected();
		 System.out.println(checkbox);
		 if(checkbox==true) {
			 System.out.println("Verified");
		 }else {
			 Assert.fail();
		 }
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
		 Thread.sleep(2000);
		CommonFunctionality.Views_list();
	}
	
	
	//TC_TV_79
	@And("^verify Rename attributes dropdown$")
	public void verify_Rename_attributes_dropdown() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
	   if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Autoname_dropdown1"))).size() != 0) 
			{
				System.out.println("Verified");
			} else 
			{
				Assert.fail();
			}
	
		 
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
			 Thread.sleep(2000);
			CommonFunctionality.Views_list();
	}
	
	
	//TC_TV_80
	@And("^verify Rename selection of attributes$")
	public void verify_Rename_selection_of_attributes() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Addbutton_rename"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Addbutton_region"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_dropdown"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Region"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OKRename"))).click();
		 Thread.sleep(2000);
		 String a = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_second_rename_region"))).getText().replaceAll("\\s+","");
		 Thread.sleep(2000);
		 String Y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_series_rename"))).getText().replaceAll("\\s+","");
		 String[] parts = Y.split(";");
		 String part2 = parts[1]; 
		 System.out.println("Verified" + a +  part2);
		 
		if(a.matches(part2))
		{
			System.out.println("Verified");
		}
		else {
			 Assert.fail();
		}
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
		 Thread.sleep(2000);
		CommonFunctionality.Views_list();
		 
		 
	}
	
	//TC_TV_81
	@And("^verify Rename selecting multiple attributes for series name$")
	public void verify_Rename_selecting_multiple_attributes_for_series_name() throws Throwable {
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Addbutton_rename"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Addbutton_region"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OKRename"))).click();
		 Thread.sleep(2000);
		 String a = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_second_rename_region"))).getText().replaceAll("\\s+","");
		 String b = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_Third_rename_region"))).getText().replaceAll("\\s+","");
		 String c = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_fourth_rename_region"))).getText().replaceAll("\\s+","");
		 Thread.sleep(2000);
		 String Y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_second_rename_region_sname"))).getText().replaceAll("\\s+","");
		 String[] parts = Y.split(";");
		 String part2 = parts[1]; 
		 
		 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_Third_rename_region_sname"))).getText().replaceAll("\\s+","");
		 String[] parts1 = x.split(";");
		 String part3 = parts1[1]; 
		 
		 String z = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_fourth_rename_region_sname"))).getText().replaceAll("\\s+","");
		 String[] parts2 = z.split(";");
		 String part4 = parts2[1]; 
		 System.out.println("Verified region"     +part2 + a +  part3+b +   part4+c);
		 if(part2.equalsIgnoreCase(a) && part3.equalsIgnoreCase(b) &&  part4.equalsIgnoreCase(c)) {
			 System.out.println("Verified");
			}
			else {
				 Assert.fail();
			}
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
			 Thread.sleep(2000);
			CommonFunctionality.Views_list();
	
	}
	//TC_TV_82
	@And("^verify Rename series in My series after visual series renamed$")
	public void verify_Rename_series_in_My_series_after_visual_series_renamed() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Addbutton_rename"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Addbutton_region"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_dropdown"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Region"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).clear();
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).sendKeys("Testing1");
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OKRename"))).click();
		 
		 Thread.sleep(2000);
		 String Y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_second_rename_region_sname"))).getText().replaceAll("\\s+","");
		 String[] parts = Y.split(";");
		 String part2 = parts[1]; 
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Data_Tab"))).click();	
		 Actions a2=new Actions(login.driver);
		 WebElement series = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_Series_Name")));
		 a2.moveToElement(series).build().perform();
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_Series_Name"))).click();	
		 Thread.sleep(2000);
		 String a =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_SSP_Region"))).getText().replaceAll("//s+", "");
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSPtable_close_table"))).click();
		 
		 
		 if(!part2.equalsIgnoreCase(a) ) {
			 System.out.println("Verified");
			}
			else {
				 Assert.fail();
			}
			
			 Thread.sleep(2000);
			CommonFunctionality.Views_list();
	}
	
	
	//TC_TV_83
	@And("^verify Rename Apply button$")
	public void verify_Rename_Apply_button() throws Throwable {
		
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Addbutton_rename"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Addbutton_region"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_dropdown"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Region"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).clear();
		 String a ="Testing";
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).sendKeys(a);
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Applay_Button"))).click();
		 Thread.sleep(2000);
		 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries"))).getText().replaceAll("//s+", ""); 
		 String[] parts1 = x.split(";");
		 String part3 = parts1[1].replaceAll(" ","");
		 System.out.println("Verified123456"+ part3);
		 System.out.println("Verified" +a+part3);
		 
		 if(a.contains(part3) ) {
			 System.out.println("Verified");
			}
			else {
				 Assert.fail();
			}
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
			 Thread.sleep(2000);
			CommonFunctionality.Views_list();
		 
	}
	
	//TC_TV_84
	@And("^verify Rename OK button$")
	public void verify_Rename_OK_button() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Addbutton_rename"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Addbutton_region"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_series_info_dropdown"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Region"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).clear();
		 String a ="Testing";
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).sendKeys(a);
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OKRename"))).click();
		 Thread.sleep(2000);
		 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_second_rename_region_sname"))).getText().replaceAll("//s+", ""); 
		 String[] parts1 = x.split(";");
		 String part3 = parts1[1].replaceAll(" ","");
		 System.out.println("Verified" +a+part3);
		 
		 if(a.contains(part3) ) {
			 System.out.println("Verified");
			}
			else {
				 Assert.fail();
			}
			 Thread.sleep(2000);
			CommonFunctionality.Views_list();
		 
		 
	}
	
	//TC_TV_85
	@And("^verify Rename Minimize option$")
	public void verify_Rename_Minimize_option() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_rename"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Collapse_rename"))).click();
		 Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_rename"))).isDisplayed());
			  System.out.println("Verified");
			  Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
					 Thread.sleep(2000);
					CommonFunctionality.Views_list();
			  
	}
	//TC_TV_86
	@And("^verify Rename maximiz option$")
	public void verify_Rename_maximiz_option() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_rename"))).click();
		 Thread.sleep(1000);
		 Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Collapse_rename"))).isDisplayed());
			  System.out.println("Verified");
			  Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
					 Thread.sleep(2000);
					CommonFunctionality.Views_list();
	}
	
	//TC_TV_87
	@And("^verify Rename full screen$")
	public void verify_Rename_full_screen() throws Throwable {
		verify_Rename_maximiz_option();
	}
	//TC_TV_88
	@And("^verify Rename exit full screen$")
	public void verify_Rename_exit_full_screen() throws Throwable {
		verify_Rename_Minimize_option();
	}

	    //TC_TV_89
	@And("^verify Rename Cancel/x icon$")
		public void verify_Rename_Cancel_x_icon() throws Throwable {
			CreateTable();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).click();
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
			 
				Thread.sleep(3000);
				if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Close_window"))).size() == 0) 
				{
					System.out.println("Verified");
				} else 
				{
					Assert.fail();
				}
				CommonFunctionality.Views_list();
			 
			 
		}
			
	
	
	
	//TC_TV_90
	@And("^verify Rename opening rename popup by keyboard shortcut$")
		public void verify_Rename_opening_rename_popup_by_keyboard_shortcut() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_H);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_H);
		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).size() != 0) 
		{
			System.out.println("Verified");
		} else 
		{
			Assert.fail();
		}
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		 CommonFunctionality.Views_list();
		
		}
	
	//TC_TV_91
	@And("^verify Edit series appling Currency conversation function$")
	public void verify_Edit_series_appling_Currency_conversation_function() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
			Thread.sleep(3000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function"))).click();
			 Thread.sleep(3000);
			 String a =  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Currency_conversation_function"))).getText().replaceAll(" ", "");
			 Thread.sleep(3000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Currency_conversation_function"))).click();
			 Thread.sleep(2000);
			 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_second_rename_unit"))).getText().replaceAll(" ", "");
			 System.out.println("Verified" +a +x);
		  if(x.contains(a))
		  {
			  System.out.println("Verified");
		  }
		  else {
			  Assert.fail();
		  }
		
		  Thread.sleep(2000);
           CommonFunctionality.Views_list();
           Thread.sleep(2000);
 		  login.driver.findElement(By.xpath("//*[contains(text(),'Reset')]")).click();
	}
	
	
	
	//TC_TV_92
	@And("^verify Edit series appling Calculate change function$")
	public void verify_Edit_series_appling_Calculate_change_function() throws Throwable {
	  
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function"))).click();
			 Thread.sleep(2000);
			 String a = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries"))).getText().replaceAll(" ", "");
			 Thread.sleep(3000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Calculate_Change_function"))).click();
			 Thread.sleep(2000);
			 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries"))).getText().replaceAll(" ", "");
			 System.out.println("Verified" +a +x);
			  if(!x.equalsIgnoreCase(a))
			  {
				  System.out.println("Verified");
			  }
			  else {
				  Assert.fail();
			  }
			 
			  Thread.sleep(2000);
	           CommonFunctionality.Views_list();
	           Thread.sleep(2000);
				  login.driver.findElement(By.xpath("//*[contains(text(),'Reset')]")).click();
		
	}
	//TC_TV_93
	@And("^verify Edit series appling Aggregate function$")
	public void verify_Edit_series_appling_Aggregate_function() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function"))).click();
			 Thread.sleep(2000);
			 String a =  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Aggregate_function"))).getText().replaceAll(" ", "");
			 Thread.sleep(3000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Aggregate_function"))).click();
			 Thread.sleep(2000);
			 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries"))).getText().replaceAll(" ", "");
			 String[] parts1 = x.split(";");
			 String part3 = parts1[3].replaceAll(" ","");
			 String part4 = part3.substring(0, 3);
			 System.out.println("Verified" +a+part4);
			 
			 System.out.println("Verified" +a +x);
			 if(part4.equalsIgnoreCase(a)) {
				 System.out.println("Verified");
			  }
			  else {
				  Assert.fail();
			  }
			
			  Thread.sleep(2000);
	           CommonFunctionality.Views_list();
	           Thread.sleep(2000);
				  login.driver.findElement(By.xpath("//*[contains(text(),'Reset')]")).click();
	}

	
	//TC_TV_94
	@And("^verify Edit series appling Accumulate function$")
	public void verify_Edit_series_appling_Accumulate_function() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function"))).click();
			 Thread.sleep(2000);
			 String a =  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Accumulate_function"))).getText().replaceAll(" ", "");
			 Thread.sleep(3000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Accumulate_function"))).click();
			 Thread.sleep(2000);
			 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries"))).getText().replaceAll(" ", "");
			 String[] parts1 = x.split(";");
			 String part3 = parts1[1].replaceAll(" ","");
			 String part4 = part3.substring(0, 3);
			 System.out.println("Verified" +a+part4);
			 
			 System.out.println("Verified" +a +x);
			 if(part4.equalsIgnoreCase(a)) {
				 System.out.println("Verified");
			  }
			  else {
				  Assert.fail();
			  }
			
			  Thread.sleep(2000);
	           CommonFunctionality.Views_list();
	           Thread.sleep(2000);
				  login.driver.findElement(By.xpath("//*[contains(text(),'Reset')]")).click();
	}
	
	//TC_TV_95
	@And("^verify Edit series FX more drop down$")
	public void verify_Edit_series_FX_more_drop_down() throws Throwable {
		verify_Edit_series_appling_Accumulate_function();
	}
	
	
	//TC_TV_96
	@And("^verify Edit series FX more icon$")
	public void verify_Edit_series_FX_more_icon() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		Thread.sleep(2000);
	   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_functionWithoutseriesid"))).click();
	   Thread.sleep(1000);
	   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_link"))).click();
	   Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_popup"))).isDisplayed());
	   Thread.sleep(1000);
	   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		 Thread.sleep(2000);
		CommonFunctionality.Views_list();
	}
		
	//TC_TV_97
	@And("^verify Edit series appling function by clicking on function icon$")
	public void verify_Edit_series_appling_function_by_clicking_on_function_icon() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		Thread.sleep(2000);
	   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_functionWithoutseriesid"))).click();
	   Thread.sleep(1000);
	   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_link"))).click();
	   Thread.sleep(1000);
	   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Function_search_popup"))).sendKeys("Change");;
	   Actions functiondclick = new Actions(login.driver);
	   WebElement Fdoubleclick =  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_popup_Change")));
	   functiondclick.moveToElement(Fdoubleclick).doubleClick().build().perform();
	   Thread.sleep(1000);
	   String a = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_popup_Fname"))).getText().replaceAll(" ", "");
	   Thread.sleep(1000);
	   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Applay_Button"))).click();
	   Thread.sleep(1000);
	   String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_second_rename_region_sname"))).getText().replaceAll(" ", "");
	   System.out.println("Verified1" +x);
	   String[] parts1 = x.split(";");
	   System.out.println("Verified123" +parts1[1]);
	   	      String secondpart = parts1[1];
			   String q = secondpart.substring(0, 7);	   
	   System.out.println("Verified" +a +q);
	   if(q.equalsIgnoreCase(a)) {
			 System.out.println("Verified");
		  }
		  else {
			  Assert.fail();
		  }
		    CommonFunctionality.Views_list();
	}
	//TC_TV_98
	@And("^verify Edit series ahiding/showing function toolbar$")
	public void verify_Edit_series_ahiding_showing_function_toolbar() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_hiding_icon"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_open_icon"))).click();
		 Thread.sleep(2000);
		 if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar"))).size() != 0) 
			{
				System.out.println("Verified");
			} else 
			{
				Assert.fail();
			}
		 CommonFunctionality.Views_list();
	}
	//TC_TV_99
	@And("^verify Edit series Type a function field$")
	public void verify_Edit_series_Type_a_function_field() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).sendKeys("Change");
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_Apply"))).click();
		 Thread.sleep(2000);
		String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_searchbar"))).getText().replaceAll(" ", "");
		 Thread.sleep(2000);
			String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_second_rename_region_sname"))).getText().replaceAll(" ", "");
			   System.out.println("Verified1" +y);  
			String[] parts1 = x.split(";");
			  System.out.println("Verified2" +parts1[0]);  
			   	      String secondpart = parts1[0];
					   System.out.println("Verified4" +parts1[0] +secondpart );  
					   
					   if(secondpart.equalsIgnoreCase(x)) {
							 System.out.println("Verified");
						  }
						  else {
							  Assert.fail();
						  }
						    CommonFunctionality.Views_list();
	
	}
	
	//TC_TV_100
	@And("^verify Edit series FX icon$")
	public void verify_Edit_series_FX_icon() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_FX_icon"))).click();
		 Thread.sleep(1000);
		 if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Editseries_function_popup"))).size() != 0) 
			{
				System.out.println("Verified");
			} else 
			{
				Assert.fail();
			}
		 
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		 CommonFunctionality.Views_list();
	}
	
	
	//TC_TV_101
	@And("^verify Edit delete series icon$")
	public void verify_Edit_delete_series_icon() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_X_icon"))).click();
		 Thread.sleep(1000);
		 if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Editseries_X_icon_after"))).size() != 0) 
			{
				System.out.println("Verified");
			} else 
			{
				Assert.fail();
			}
		 
		
		 CommonFunctionality.Views_list();
	}
	//TC_TV_102
	@And("^verify Edit delete all series icon$")
	public void verify_Edit_delete_all_series_icon() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_X_icon"))).click();
		 Thread.sleep(1000);
		 if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Editseries_X_icon_after"))).size() != 0) 
			{
				System.out.println("Verified");
			} else 
			{
				Assert.fail();
			}
		 
		
		 CommonFunctionality.Views_list();
	}
	//TC_TV_103
	@And("^verify Edit SSP by clicking on series name$")
	public void verify_Edit_SSP_by_clicking_on_series_name() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries"))).click();
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Dialogue"))).isDisplayed());
			  System.out.println("verified clicking on series name");
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSPtable_close_table"))).click();
			  Thread.sleep(2000);
				CommonFunctionality.Views_list();
	
	}
	
	//TC_TV_104
	@And("^verify Edit Rename series icon$")
	public void verify_Edit_Rename_series_icon() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		   Actions action = new Actions(login.driver);
			WebElement we = login.driver.findElement(By.xpath("(//div[@class='series-name--icon'])[1]"));
			action.moveToElement(we).pause(5000).build().perform();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_icon_rename"))).click();
			 Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_rename_popup"))).isDisplayed());
				  System.out.println("verified clicking on series name");
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
				  Thread.sleep(2000);
					CommonFunctionality.Views_list();
		 
	}
	
	
	//TC_TV_105
	@And("^verify Edit edit series icon$")
	public void verify_Edit_edit_series_icon() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		   Actions action = new Actions(login.driver);
			WebElement we = login.driver.findElement(By.xpath("(//div[@class='series-name--icon'])[1]"));
			action.moveToElement(we).pause(5000).build().perform();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_icon_setting"))).click();
			 
			 Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_icon_setting_dropdown"))).isDisplayed());
				  System.out.println("verified clicking on series name");
				  Thread.sleep(2000);
					CommonFunctionality.Views_list();
 
	}
	
	
	//TC_TV_106
	@And("^verify Edit Rename option under edit series$")
	public void verify_Edit_Rename_option_under_edit_series() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		   Actions action = new Actions(login.driver);
			WebElement we = login.driver.findElement(By.xpath("(//div[@class='series-name--icon'])[1]"));
			action.moveToElement(we).pause(5000).build().perform();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_icon_setting"))).click();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_icon_setting_dropdown_rename"))).click();
				 Assert.assertTrue(
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_rename_popup"))).isDisplayed());
					  System.out.println("verified clicking on series name");
					  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
					  Thread.sleep(2000);
						CommonFunctionality.Views_list();
				 
				 
	}
	
	
	//TC_TV_107
	@And("^verify Edit Frequency option under edit series$")
	public void verify_Edit_Frequency_option_under_edit_series() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		   Actions action = new Actions(login.driver);
			WebElement we = login.driver.findElement(By.xpath("//div[@class='series-name--title']"));
			action.moveToElement(we).pause(5000).build().perform();
			String x=  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries"))).getText();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_icon_setting"))).click();
				Thread.sleep(2000);
				 Actions action1 = new Actions(login.driver);
					WebElement we1 = login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu edit-series--context-menu']//following ::div[3]/li[3]"));
					action1.moveToElement(we1).pause(5000).build().perform();
					Thread.sleep(1000);
					Actions action2 = new Actions(login.driver);
					WebElement we2 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_icon_setting_dropdown_frequency_SUM")));
					action2.moveToElement(we2).click().build().perform();
					 //login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_icon_setting_dropdown_frequency_SUM"))).click();
					 Thread.sleep(2000);
					 String y=  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries"))).getText();
					  System.out.println("Verified" + x+y );
					  if(!x.equalsIgnoreCase(y)) {
						  
						  
								System.out.println("Verified");
							} else 
							{
								Assert.fail();
							}
						 
						
						 CommonFunctionality.Views_list();
					
	}
	//TC_TV_108
	@And("^verify Edit Currency option under edit series$")
	public void verify_Edit_Currency_option_under_edit_series() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000); 
		 Actions action = new Actions(login.driver);
					WebElement we = login.driver.findElement(By.xpath("//div[@class='series-name--title']"));
					action.moveToElement(we).pause(5000).build().perform();
					String x=  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries"))).getText();
					Thread.sleep(2000);
					 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_icon_setting"))).click();
						Thread.sleep(2000);
						 Actions action1 = new Actions(login.driver);
							WebElement we1 = login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu edit-series--context-menu']//following ::div[3]/li[5]"));
							action1.moveToElement(we1).pause(5000).build().perform();
							Thread.sleep(2000);
							 Actions action2 = new Actions(login.driver);
								WebElement we2 = login.driver.findElement(By.xpath("//*[@title='% Period-over-Period Annualized (%PoP)']"));
								action2.moveToElement(we2).pause(5000).click().build().perform();
								Thread.sleep(1000);
							//login.driver.findElement(By.xpath(login.LOCATORS.getProperty("//*[@title='% Period-over-Period Annualized (%PoP)']"))).click();
							 Thread.sleep(2000);
							 String y=  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries"))).getText();
							  System.out.println("Verified" + x+y );
							  if(!x.equalsIgnoreCase(y)) {
								  
								  
										System.out.println("Verified");
									} else 
									{
										Assert.fail();
									}
								 
								
								 CommonFunctionality.Views_list();
	}
	
	
	
	//TC_TV_109
	@And("^verify Edit Change option under edit series$")
	public void verify_Edit_Change_option_under_edit_series() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000); 
		 Actions action = new Actions(login.driver);
			WebElement we = login.driver.findElement(By.xpath("//div[@class='series-name--title']"));
			action.moveToElement(we).pause(5000).build().perform();
			String x=  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries"))).getText();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_icon_setting"))).click();
				Thread.sleep(2000);
				 Actions action1 = new Actions(login.driver);
					WebElement we1 = login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu edit-series--context-menu']//following ::div[3]/li[4]"));
					action1.moveToElement(we1).pause(5000).build().perform();
					Thread.sleep(2000);
					 Actions action2 = new Actions(login.driver);
						WebElement we2 = login.driver.findElement(By.xpath("//*[@title='RUB']"));
						action2.moveToElement(we2).pause(5000).click().build().perform();	
					 Thread.sleep(2000);
					 String y=  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries"))).getText();
					  System.out.println("Verified" + x+y );
					  if(!x.equalsIgnoreCase(y)) {
						  
						  
								System.out.println("Verified");
							} else 
							{
								Assert.fail();
							}
					  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
					  Thread.sleep(2000);
					  login.driver.findElement(By.xpath("//*[contains(text(),'Reset')]")).click();
					  Thread.sleep(2000);
						 CommonFunctionality.Views_list();
	}
	
	//TC_TV_110
	@And("^verify Edit clicking on frequency or dropdown$")
	public void verify_Edit_clicking_on_frequency_or_dropdown() throws Throwable {
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000); 
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Frequency"))).click();
		 Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Frequency_Series_Harmonization"))).isDisplayed());
			  System.out.println("verified clicking on Frequency");
			  Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
				  Thread.sleep(2000);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
				  Thread.sleep(2000);
				  login.driver.findElement(By.xpath("//*[contains(text(),'Reset')]")).click();
				 Thread.sleep(2000);
				 CommonFunctionality.Views_list();
	}

	//TC_TV_110
	@And("^Select series to my series tab$")
	public void select_series_to_my_series_tab() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
		List<WebElement> Totallist = 	login.driver.findElements(By.xpath("//div[@class='series-item--name']"));
		System.out.println("Totallist size are" + Totallist.size());
		
		for (int i = 1; i <= Totallist.size(); i++) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//ul[@class='search-series-list']/li[" + i + "]/div/a/div[2]")).click();
		}
		Thread.sleep(5000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_T);
		Thread.sleep(500);   
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Applay_Button"))).click();
		if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Close_window"))).size()>0) {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		}
		else {
			System.out.println("No Pop up appeared....");
		}
	}
	
	//TC_TV_111
	@And("^verify Edit Series data conversion -applying frequency$")
	public void verify_Edit_Series_data_conversion_applying_frequency() throws Throwable {
		
		String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_Third_rename_region_sname"))).getText();
		
		
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
	     Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Frequency"))).click();
		 Thread.sleep(2000); 
	    login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Applay_Button"))).click();
	    Thread.sleep(2000); 
	    String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Frequency_Second_Series_Harmonization"))).getText();
	    
		 if(!x.equalsIgnoreCase(y)) {
			  
			  
				System.out.println("Verified");
			} else 
			{
				Assert.fail();
			}
		 
			  System.out.println("verified clicking on Frequency");
				  Thread.sleep(2000);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
				  Thread.sleep(2000);
				  login.driver.findElement(By.xpath("//*[contains(text(),'Reset')]")).click();
				 Thread.sleep(2000);
				 CommonFunctionality.Views_list();
	}

	
	
	
	
	//TC_TV_112
	@And("^verify Edit Series data conversion -applying Missing values method$")
	public void verify_Edit_Series_data_conversion_applying_Missing_values_method() throws Throwable {
		verify_Edit_Series_data_conversion_applying_frequency();
	}
	//TC_TV_113
	@And("^verify Edit Series data conversion -Apply button$")
	public void verify_Edit_Series_data_conversion_Apply_button() throws Throwable {
		verify_Edit_Series_data_conversion_applying_frequency();
	}
	//TC_TV_114
	@And("^verify Series data Minimize$")
	public void verify_Series_data_Minimize() throws Throwable {
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Frequency"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_rename"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Collapse_rename"))).click();
		 Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_rename"))).isDisplayed());
			  System.out.println("Verified");
			  Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
				 Thread.sleep(2000);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
				  Thread.sleep(2000);
				  login.driver.findElement(By.xpath("//*[contains(text(),'Reset')]")).click();
					 Thread.sleep(2000);
					CommonFunctionality.Views_list();
	}
	//TC_TV_115
	@And("^verify ESeries data Maximize$")
	public void verify_ESeries_data_Maximize() throws Throwable {
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Frequency"))).click();
		 Thread.sleep(1000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_rename"))).click();
		 Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Collapse_rename"))).isDisplayed());
			  System.out.println("Verified");
			  Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
				 Thread.sleep(2000);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
				  Thread.sleep(2000);
				  login.driver.findElement(By.xpath("//*[contains(text(),'Reset')]")).click();
					 Thread.sleep(2000);
					CommonFunctionality.Views_list();
	}

	
	
	//TC_TV_116
	@And("^verify Series data full screen$")
	public void verify_Series_data_full_screen() throws Throwable {
		verify_Series_data_Minimize();
	}
	//TC_TV_117
	@And("^verify Series data exit full screen$")
	public void verify_Series_data_exit_full_screen() throws Throwable {
		verify_ESeries_data_Maximize();
	}
	
	
	
	//TC_TV_118
	@And("^verify Series data Cancel/x icon$")
	public void verify_Series_data_Cancel_x_icon() throws Throwable {
		
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Frequency"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		 
			Thread.sleep(3000);
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Close_window"))).size() == 0) 
			{
				System.out.println("Verified");
			} else 
			{
				Assert.fail();
				
			}
			 Thread.sleep(2000);
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
			  Thread.sleep(2000);
			  login.driver.findElement(By.xpath("//*[contains(text(),'Reset')]")).click();
				 Thread.sleep(2000);
			CommonFunctionality.Views_list();
	}
	
	
	
	
	//TC_TV_119
	@And("^verify Series data dropdown for frequency in series level$")
	public void verify_Series_data_dropdown_for_frequency_in_series_level() throws Throwable {
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Frequency_dropdownicon"))).click();
		 Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Frequency_dropdownlist"))).isDisplayed());
			  System.out.println("Verified");
			  Thread.sleep(2000);
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
			  Thread.sleep(2000);
			  login.driver.findElement(By.xpath("//*[contains(text(),'Reset')]")).click();
				 Thread.sleep(2000);
			CommonFunctionality.Views_list();
			  
	}

	
	//TC_TV_120
	@And("^verify Series data appling frequency in series level$")
	public void verify_Series_data_appling_frequency_in_series_level() throws Throwable {
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries"))).getText();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Frequency_dropdownicon"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Frequency_dropdownlist_firstitem"))).click();
		 Thread.sleep(2000);
		 String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries"))).getText();
		 
		 
		 if(!x.equalsIgnoreCase(y)) {
			  
			  
				System.out.println("Verified");
			} else 
			{
				Assert.fail();
			}
		 
				  Thread.sleep(2000);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
				  Thread.sleep(2000);
				  login.driver.findElement(By.xpath("//*[contains(text(),'Reset')]")).click();
				 Thread.sleep(2000);
				 CommonFunctionality.Views_list();
	}
	//TC_TV_121
	@And("^verify Series data appling currency in series level$")
	public void verify_Series_data_appling_currency_in_series_level() throws Throwable {
		
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries"))).getText();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_currency_dropdownicon"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Frequency_dropdownlist_firstitem"))).click();
		 Thread.sleep(2000);
		 String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries"))).getText();
		 
		 
		 if(!x.equalsIgnoreCase(y)) {
			  
			  
				System.out.println("Verified");
			} else 
			{
				Assert.fail();
			}
		 
				  Thread.sleep(2000);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
				  Thread.sleep(2000);
				  login.driver.findElement(By.xpath("//*[contains(text(),'Reset')]")).click();
				 Thread.sleep(2000);
				 CommonFunctionality.Views_list();
	}
	
	
	
	//TC_TV_122
	@And("^verify Edit Series clicking on type a function field$")
	public void verify_Edit_Series_clicking_on_type_a_function_field() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).click();
		 Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list"))).isDisplayed());
			  System.out.println("Verified");
			  Thread.sleep(2000);
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
				 Thread.sleep(2000);
			CommonFunctionality.Views_list();
	}
	
	//TC_TV_123
	@And("^verify Edit Series appling function in series level$")
	public void verify_Edit_Series_appling_function_in_series_level() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).sendKeys("Change");
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_Apply"))).click();
		 Thread.sleep(2000);
		String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_searchbar"))).getText().replaceAll(" ", "");
		 Thread.sleep(2000);
			String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_second_rename_region_sname"))).getText().replaceAll(" ", "");
			   System.out.println("Verified1" +y);  
			String[] parts1 = x.split(";");
			  System.out.println("Verified2" +parts1[0]);  
			   	      String secondpart = parts1[0];
					   System.out.println("Verified4" +parts1[0] +secondpart );  
					   
					   if(secondpart.equalsIgnoreCase(x)) {
							 System.out.println("Verified");
						  }
						  else {
							  Assert.fail();
						  }
						    CommonFunctionality.Views_list();
	}
	
	
	
	//TC_TV_124
	@And("^verify Edit Series appling function  cancel icon for selected function$")
	public void verify_Edit_Series_appling_function_cancel_icon_for_selected_function() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries"))).getText();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).sendKeys("Change");
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_Apply"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_cancel"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_Apply"))).click();
		 Thread.sleep(2000);
		 String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries"))).getText();
		 Thread.sleep(1000);
		 if(y.equalsIgnoreCase(x)) {
			 System.out.println("Verified");
		  }
		  else {
			  Assert.fail();
		  }
		    CommonFunctionality.Views_list();
 
	}
	
	//TC_TV_125
	@And("^verify Edit Series multiple functions apply$")
	public void verify_Edit_Series_multiple_functions_apply() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).sendKeys("Change");
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).sendKeys("LOG");
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_Apply"))).click();
		 Thread.sleep(2000);
		 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries"))).getText().replaceAll(" ", "");
		 String[] parts1 = x.split(";");
		  String z = parts1[1];  
		 System.out.println("Verified123" + z );
		 if(z.contains("CHANGE") && z.contains("LOG"))
		 {
			 
			 System.out.println("Verified");
		  }
		  else {
			  Assert.fail();
		  }
		    CommonFunctionality.Views_list();
		 
		 
	}
	
	//TC_TV_126
	@And("^verify Edit Series search for functions$")
	public void verify_Edit_Series_search_for_functions() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).sendKeys("Change");
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
		 Thread.sleep(2000);
		 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_popup_Fname"))).getText().replaceAll(" ", "");
		 if(x.contains("CHANGE")) {
			 
			 System.out.println("Verified");
		 }
		 else {
			  Assert.fail();
		  }
		 CommonFunctionality.Views_list();
	}

	//TC_TV_127
	@And("^verify Edit Series removing applied functions$")
	public void verify_Edit_Series_removing_applied_functions() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries"))).getText().replaceAll(" ", "");
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).sendKeys("LOG");
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_Apply"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_cancel_serieslevel"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_Apply_serieslevel"))).click();
		 Thread.sleep(2000);
		 String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries"))).getText().replaceAll(" ", "");
		 
		 if(x.equalsIgnoreCase(y) ){
					 
					 System.out.println("Verified");
				 }
				 else {
					  Assert.fail();
				  }
				 CommonFunctionality.Views_list();
	}
	
	
	//TC_TV_128
	@And("^verify Edit Series applied funtion in function toolbar$")
	public void verify_Edit_Series_applied_funtion_in_function_toolbar() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).sendKeys("LOG");
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_Apply"))).click();
		 Thread.sleep(2000);
		 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_searchbar"))).getText().replaceAll(" ", "");
		 if(x.contains("LOG")) {
			 
			 System.out.println("Verified");
		 }
		 else {
			  Assert.fail();
		  }
		 CommonFunctionality.Views_list();
	}
	
	
	//TC_TV_129
	@And("^verify Edit Series appling invalid function for series$")
	public void verify_Edit_Series_appling_invalid_function_for_series() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).sendKeys("convertcur");
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_Apply"))).click();
		 Thread.sleep(2000);
		 Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Invalidfunction_popup"))).isDisplayed());
		 System.out.println("Verified Editseries_Invalidfunction_popup");
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_window"))).click();
		 Thread.sleep(2000);
		 CommonFunctionality.Views_list();
		
		 
	}
	//TC_TV_130
	@And("^verify Edit Series OK button on The function cannot be applied to selected series popup$")
	public void verify_Edit_Series_OK_button_on_The_function_cannot_be_applied_to_selected_series_popup() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).sendKeys("convertcur");
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_Apply"))).click();
		 Thread.sleep(2000);
		 Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).isDisplayed());
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).click();
		 Thread.sleep(2000);
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("ResultTableVisual"))).size() == 0) 
			{
				System.out.println("Verified");
			} else 
			{
				Assert.fail();
			}
			CommonFunctionality.Views_list();
		 
	}
	
	
	//TC_TV_131
	@And("^verify Edit Series Region, Unit and Series ID fields$")
	public void verify_Edit_Series_Region_Unit_and_Series_ID_fields() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 
		 JavascriptExecutor js = (JavascriptExecutor)login.driver; 
		 WebElement element = login.driver.findElement(By.xpath("//div[contains(text(),'Region')]"));
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			 WebElement element1 = login.driver.findElement(By.xpath("//div[@class='visual-series-panel--series']//following::div[contains(text(),'Unit')]"));
				js.executeScript("arguments[0].scrollIntoView(true);", element1);
		 WebElement element2 = login.driver.findElement(By.xpath("//div[contains(text(),'Series id')]"));
			js.executeScript("arguments[0].scrollIntoView(true);", element2);
			
			 Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_scrollSeriesid"))).isDisplayed());
			 Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_scrollunit"))).isDisplayed());
			 Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_scrollregion"))).isDisplayed());
			 Thread.sleep(2000);
			 CommonFunctionality.Views_list();
	}
	
	
	//TC_TV_132
	@And("^verify Edit Series Verify horizontal scroll bar for series$")
	public void verify_Edit_Series_Verify_horizontal_scroll_bar_for_series() throws Throwable {
		verify_Edit_Series_Region_Unit_and_Series_ID_fields();
	}
	
	//TC_TV_133
	@And("^verify Edit Series Verify Verify \\+Add from my series option$")
	public void verify_Edit_Series_Verify_Verify_Add_from_my_series_option() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("AddfromMySeries"))).click();
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Listandtable"))).isDisplayed());
			  System.out.println("Add from my series option is verified");
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
	}
	
	//TC_TV_134
	@And("^verify Edit Series Verify adding series from my series$")
	public void verify_Edit_Series_Verify_adding_series_from_my_series() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("AddfromMySeries"))).click();
			 Thread.sleep(2000);                                               
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_tablemode"))).click();
			 Thread.sleep(3000);
			  boolean Table_mode_view =  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_mode_view"))).isDisplayed();
			  if(Table_mode_view==true)	  
		 {
				  System.out.println("Verified");
				
			} else {
				Assert.fail();
				
			}
			  Thread.sleep(1000);
			  CommonFunctionality.Views_list();
	}
	
	
	
	//TC_TV_135
	@And("^verify Edit Series Verify max series for Table visual$")
	public void verify_Edit_Series_Verify_max_series_for_Table_visual() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
		List<WebElement> Totallist = 	login.driver.findElements(By.xpath("//div[@class='series-item--name']"));
		System.out.println("Totallist size are" + Totallist.size());
		
		for (int i = 1; i <= Totallist.size(); i++) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//ul[@class='search-series-list']/li[" + i + "]/div/a/div[2]")).click();
		}
		Thread.sleep(5000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_T);
		Thread.sleep(500);   
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Applay_Button"))).click();
		if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Close_window"))).size()>0) {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		}
		else {
			System.out.println("No Pop up appeared....");
		}
		Thread.sleep(500); 
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).isDisplayed());
		 System.out.println("Verified max series for Table visual");
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search_Top"))).click();
		Thread.sleep(500);
		 CommonFunctionality.Views_list();
	}
	
	//TC_TV_136
	@And("^verify Edit Series Verify message for selecting more than (\\d+) series$")
	public void verify_Edit_Series_Verify_message_for_selecting_more_than_series(int arg1) throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
		List<WebElement> Totallist = 	login.driver.findElements(By.xpath("//div[@class='series-item--name']"));
		System.out.println("Totallist size are" + Totallist.size());
		
		for (int i = 1; i <= Totallist.size(); i++) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//ul[@class='search-series-list']/li[" + i + "]/div/a/div[2]")).click();
		}
		
		Thread.sleep(5000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_T);
		Thread.sleep(500);   
		if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Close_window"))).size()>0) {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
		}
		else {
			System.out.println("No Pop up appeared....");
		}
		Thread.sleep(500); 
		Assert.assertTrue(
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).isDisplayed());
		 System.out.println("Verified max series for Table visual");
			
		Thread.sleep(500);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search_Top"))).click();
		
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//ul[@class='search-series-list']/li[1]/div/a/div[4]/div/div[1]")).click();
		Thread.sleep(500);
		if(login.driver.findElements(By.xpath("//div[@class='growl-message-text']")).size() != 0) {
			System.out.println("Validation message Verified Successfully!!! ");
		} else {
			Assert.fail();
		}
		 CommonFunctionality.Views_list();
	}
	
	//TC_TV_137
	@And("^verify Edit Series default sort by in add from my series tab$")
	public void verify_Edit_Series_default_sort_by_in_add_from_my_series_tab() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("AddfromMySeries"))).click();
			 Thread.sleep(3000);
			  boolean Table_mode_view =  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_checked_addseries"))).isDisplayed();
			  System.out.println("Table_mode_view"+ Table_mode_view);
			  if(Table_mode_view==true)	  
		 {
				  System.out.println("Verified");
				
			} else {
				Assert.fail();
				
			}
			  Thread.sleep(1000);
			  CommonFunctionality.Views_list();
	}
	//TC_TV_138
	@And("^verify Edit Series Edit series option on visual if edit series panle is opened$")
	public void verify_Edit_Series_Edit_series_option_on_visual_if_edit_series_panle_is_opened() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(3000);
		  boolean Table_mode_view =  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).isEnabled();
		  if(Table_mode_view==false)	  
	 {
			  System.out.println("Verified");
			
		} else {
			Assert.fail();
			
		}
		  Thread.sleep(1000);
		  CommonFunctionality.Views_list();
		 
		 
		 
	}
	//TC_TV_139
	@And("^verify Edit Series edit series panel close$")
	public void verify_Edit_Series_edit_series_panel_close() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).click();
		 Thread.sleep(3000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesClose"))).click();
		 Thread.sleep(3000);
		if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("AddfromMySeries"))).size()==0)
		{
			 System.out.println("Verified");
		}else {
			Assert.fail();
			
		}
		  Thread.sleep(1000);
		  CommonFunctionality.Views_list();
		
	}
	
	//TC_TV_140
	@And("^verify Edit Table$")
	public void verify_Edit_Table() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
		 Thread.sleep(500); 
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_popup"))).isDisplayed());
			 System.out.println("Verified");
			 Thread.sleep(500); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
			 Thread.sleep(1000);
			 CommonFunctionality.Views_list();
	}
	
	
	
	
	//TC_TV_141
	@SuppressWarnings("deprecation")
	@And("^verify Edit Table popup of creating template$")
	public void verify_Edit_Table_popup_of_creating_template() throws Throwable {
		CreateTable();
		Thread.sleep(2000);
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
		 Thread.sleep(500); 
		WebElement edittitlesetting = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
        Actions etseting = new Actions(login.driver);
        etseting.moveToElement(edittitlesetting).pause(5000).click().build().perform();
		 Thread.sleep(500); 
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting_checkbox"))).click();
		 Thread.sleep(500); 
		 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_template_icon"))).click();
		 Thread.sleep(500); 
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templateclose"))).isDisplayed());
			 System.out.println("Verified");
			 Thread.sleep(500); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templateclose"))).click();
			 Thread.sleep(500); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
			 Thread.sleep(500); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).click();
			 Thread.sleep(1000);
			 CommonFunctionality.Views_list();
	}
	
	
	
	
	
	//TC_TV_142
	    @And("^verify Edit Table auto naming for template$")
		public void verify_Edit_Table_auto_naming_for_template() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			 Thread.sleep(500); 
			WebElement edittitlesetting = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
	        Actions etseting = new Actions(login.driver);
	        etseting.moveToElement(edittitlesetting).pause(5000).click().build().perform();
			 Thread.sleep(500); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting_checkbox"))).click();
			 Thread.sleep(500); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_template_icon"))).click();
			 Thread.sleep(500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templatetick"))).click();
			 Thread.sleep(500);
			 String x =  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templatename"))).getAttribute("title");
			 if(x.contains("My template 1")) {
				 
				 System.out.println("Verified");
				}else {
					Assert.fail();
					
				}
				  Thread.sleep(1000);
				  
				  WebElement Deletetemplate = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templatename")));
			        Actions Deletetemplate1 = new Actions(login.driver);
			        Deletetemplate1.moveToElement(Deletetemplate).pause(5000).build().perform();
			        Thread.sleep(200);
					 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("DeleteTemplatename"))).click();
					 Thread.sleep(500); 
					 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).click();
					 Thread.sleep(500); 
					 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
					 Thread.sleep(500); 
					 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).click();
					 Thread.sleep(1000);
					 CommonFunctionality.Views_list();
		}
			
	
	
	
	  //TC_TV_143
	    @And("^verify Edit Table Verify template creating$")
	    public void verify_Edit_Table_Verify_template_creating() throws Throwable {
	    	verify_Edit_Table_auto_naming_for_template();
	    }
	
	

		  //TC_TV_144
	    @And("^verify Edit Table Cancel icon for template popup$")
	    public void verify_Edit_Table_Cancel_icon_for_template_popup() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			 Thread.sleep(500); 
			WebElement edittitlesetting = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
	        Actions etseting = new Actions(login.driver);
	        etseting.moveToElement(edittitlesetting).pause(5000).click().build().perform();
			 Thread.sleep(500); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting_checkbox"))).click();
			 Thread.sleep(500); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_template_icon"))).click();
			 Thread.sleep(500); 
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templateclose"))).isDisplayed());
				 System.out.println("Verified");
				 Thread.sleep(500); 
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templateclose"))).click();
				 Thread.sleep(500); 
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
				 Thread.sleep(500); 
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).click();
				 Thread.sleep(1000);
				 CommonFunctionality.Views_list();
	    }
	
	
	
	    //TC_TV_145
	    @And("^verify Edit Table selection of created template$")
	    public void verify_Edit_Table_selection_of_created_template() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			 Thread.sleep(500); 
			WebElement edittitlesetting = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
	        Actions etseting = new Actions(login.driver);
	        etseting.moveToElement(edittitlesetting).pause(5000).click().build().perform();
			 Thread.sleep(500); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting_checkbox"))).click();
			 Thread.sleep(500); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_template_icon"))).click();
			 Thread.sleep(500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templatetick"))).click();
			 Thread.sleep(1500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			 Thread.sleep(500);
			boolean tabletitle = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_title"))).isDisplayed();
			 System.out.println("tabletitle" + tabletitle);
			 if(tabletitle==false) {
				 System.out.println("Verified");
			 }
			 else {
				 Assert.fail();
			 }
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			 WebElement Deletetemplate = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templatename")));
		        Actions Deletetemplate1 = new Actions(login.driver);
		        Deletetemplate1.moveToElement(Deletetemplate).pause(5000).build().perform();
		        Thread.sleep(200);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("DeleteTemplatename"))).click();
				 Thread.sleep(500); 
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).click();
				 Thread.sleep(500); 
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
			 Thread.sleep(1000);
			 CommonFunctionality.Views_list();
	    }
	
	
	

	    //TC_TV_146
	    @And("^verify Edit Table dropdown for template$")
	    public void verify_Edit_Table_dropdown_for_template() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templatedropdown"))).click();
			 Thread.sleep(1000);
				boolean CEICStyles = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEICStyles"))).isDisplayed();
				boolean MyStyles= login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MyStyles"))).isDisplayed();
				 System.out.println("CEICStyles" + CEICStyles);
				 System.out.println("MyStyles" + MyStyles);
				 if(MyStyles==true && CEICStyles ==true){
					 System.out.println("Verified");
				 }
				 else {
					 Assert.fail();
				 }
			 
			 
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
			 Thread.sleep(2000);
			 CommonFunctionality.Views_list();
	    }
	    
	    //TC_TV_147
	    @And("^verify Edit Table Set as default for future Table visual is checked$")
	    public void verify_Edit_Table_Set_as_default_for_future_Table_visual_is_checked() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templatedropdown"))).click();
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SkyTemplate"))).click();
			 Thread.sleep(1500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			 Thread.sleep(2500);
			 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SkyTemplatemyseriestab"))).getCssValue("background-color");
			 if(x.contains("rgba(229, 238, 255, 1)")){
				 System.out.println("Verified");
			 }else {
				 Assert.fail();
			 }
			 
					 Thread.sleep(2000);
			 CommonFunctionality.Views_list();
	    }
	
	
	    //TC_TV_148
	    @And("^verify Edit Table Set as default for future Table visual is Unchecked$")
	    public void verify_Edit_Table_Set_as_default_for_future_Table_visual_is_Unchecked() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templatedropdown"))).click();
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SkyTemplate"))).click();
			 Thread.sleep(1500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			 Thread.sleep(2500);
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templatedropdown"))).click();
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("DefaultTemplate"))).click();
			 Thread.sleep(1500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			 
			 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SkyTemplatemyseriestab"))).getCssValue("background-color");
			  if(x.contains("rgba(133, 57, 142, 1)")){
				 System.out.println("Verified");
			 }else {
				 Assert.fail();
			 }
			 Thread.sleep(1500);
			 CommonFunctionality.Views_list();
	    }
	
	
	    
	    
	    
	  //TC_TV_149
	    @And("^verify Edit Table delete template icon$")
	    public void verify_Edit_Table_delete_template_icon() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			 Thread.sleep(500); 
			WebElement edittitlesetting = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
	        Actions etseting = new Actions(login.driver);
	        etseting.moveToElement(edittitlesetting).pause(5000).click().build().perform();
			 Thread.sleep(500); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting_checkbox"))).click();
			 Thread.sleep(500); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_template_icon"))).click();
			 Thread.sleep(500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templatetick"))).click();
			 Thread.sleep(1500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			 WebElement Deletetemplate = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templatename")));
		        Actions Deletetemplate1 = new Actions(login.driver);
		        Deletetemplate1.moveToElement(Deletetemplate).pause(5000).build().perform();
		        Thread.sleep(200);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("DeleteTemplatename"))).click();
			 boolean deletetemplateicon = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ConfirmationDeleteTemplate"))).isDisplayed();
			 System.out.println("tabletitle" + deletetemplateicon);
			 if(deletetemplateicon==true) {
				 System.out.println("Verified");
			 }
			 else {
				 Assert.fail();
			 }
			
				 Thread.sleep(500); 
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).click();
				 Thread.sleep(500); 
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
			 Thread.sleep(1000);
			 CommonFunctionality.Views_list();
			 
	    }
	    
	    
	    //TC_TV_150
	    @And("^verify Edit Table description for confirmation popup$")
	    public void verify_Edit_Table_description_for_confirmation_popup() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			 Thread.sleep(500); 
			WebElement edittitlesetting = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
	        Actions etseting = new Actions(login.driver);
	        etseting.moveToElement(edittitlesetting).pause(5000).click().build().perform();
			 Thread.sleep(500); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting_checkbox"))).click();
			 Thread.sleep(500); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_template_icon"))).click();
			 Thread.sleep(500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templatetick"))).click();
			 Thread.sleep(1500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			 WebElement Deletetemplate = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templatename")));
		        Actions Deletetemplate1 = new Actions(login.driver);
		        Deletetemplate1.moveToElement(Deletetemplate).pause(5000).build().perform();
		        Thread.sleep(200);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("DeleteTemplatename"))).click();
			 boolean deletetemplateicon = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("textDeleteTemplate"))).isDisplayed();
			 System.out.println("tabletitle" + deletetemplateicon);
			 if(deletetemplateicon==true) {
				 System.out.println("Verified");
			 }
			 else {
				 Assert.fail();
			 }
			
				 Thread.sleep(500); 
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).click();
				 Thread.sleep(500); 
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
			 Thread.sleep(1000);
			 CommonFunctionality.Views_list();
	    }
	    //TC_TV_151
	    @And("^verify Edit Table OK button on confirmation popup$")
	    public void verify_Edit_Table_OK_button_on_confirmation_popup() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			 
				
			 Thread.sleep(500); 
			WebElement edittitlesetting = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
	        Actions etseting = new Actions(login.driver);
	        etseting.moveToElement(edittitlesetting).pause(5000).click().build().perform();
			 Thread.sleep(500); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting_checkbox"))).click();
			 Thread.sleep(500); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_template_icon"))).click();
			 Thread.sleep(500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templatetick"))).click();
			 Thread.sleep(1500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			 WebElement Deletetemplate = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templatename")));
		        Actions Deletetemplate1 = new Actions(login.driver);
		        Deletetemplate1.moveToElement(Deletetemplate).pause(5000).build().perform();
		        Thread.sleep(200);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("DeleteTemplatename"))).click();
				 Thread.sleep(500); 
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).click();
				 
				List<WebElement> listtemplate = login.driver.findElements(By.xpath("//div[@class='style-templates-menu--items']/div"));
				 System.out.println("templatesize"+ listtemplate.size());
				 if(listtemplate.size() == 5) {
					 System.out.println("Verified");
				 }
				 else {
					 Assert.fail();
				 }
				 Thread.sleep(500); 
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
			 Thread.sleep(1000);
			 CommonFunctionality.Views_list();
	    }
	    //TC_TV_152
	    @And("^verify Edit Table cancel/x icon on confirmation popup$")
	    public void verify_Edit_Table_cancel_x_icon_on_confirmation_popup() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			 Thread.sleep(500); 
			WebElement edittitlesetting = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
	        Actions etseting = new Actions(login.driver);
	        etseting.moveToElement(edittitlesetting).pause(5000).click().build().perform();
			 Thread.sleep(500); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting_checkbox"))).click();
			 Thread.sleep(500); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_template_icon"))).click();
			 Thread.sleep(500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templatetick"))).click();
			 Thread.sleep(1500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			 WebElement Deletetemplate = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templatename")));
		        Actions Deletetemplate1 = new Actions(login.driver);
		        Deletetemplate1.moveToElement(Deletetemplate).pause(5000).build().perform();
		        Thread.sleep(200);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("DeleteTemplatename"))).click();
				 Thread.sleep(500); 
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ConfirmationDeleteTemplatecancel"))).click();
				 
				 if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("ConfirmationDeleteTemplate"))).size() == 0) 
				 
					 {
					 System.out.println("Verified");
				 }
				 else {
					 Assert.fail();
				 }
				 Thread.sleep(500); 
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
				 
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				 WebElement DeletetemplateX = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templatename")));
			        Actions DeletetemplateX1 = new Actions(login.driver);
			        DeletetemplateX1.moveToElement(DeletetemplateX).pause(5000).build().perform();
			        Thread.sleep(200);
					 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("DeleteTemplatename"))).click();
					 Thread.sleep(500); 
					 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).click();
					 Thread.sleep(500); 
					 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
			 Thread.sleep(1000);
			 CommonFunctionality.Views_list();
	    }
	    
	    
	    //TC_TV_153
	    @SuppressWarnings("deprecation")
		@And("^verify Edit Table Border - Verify Table color$")
	    public void verify_Edit_Table_Border_Verify_Table_color() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			 Thread.sleep(3000); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordersetting"))).click();
			 Thread.sleep(3000); 
			 WebElement x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordersetting_checkinput")));
			 
			 Actions border = new Actions(login.driver);
					 border.moveToElement(x).pause(5000).click().build().perform();
			 Thread.sleep(3000); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordersetting_borderlengthinput"))).sendKeys("5");
			 Thread.sleep(3000); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			 
			 Thread.sleep(3000); 
			 String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Blackbordertable"))).getCssValue("background-color");
			 System.out.println("Border colour" + y);
			 Thread.sleep(3000); 
			 
			  if(y.contains("rgba(0, 0, 0, 0)")){
				 System.out.println("Verified");
			 }else {
				 Assert.fail();
			 }
			  Thread.sleep(1000);
				 CommonFunctionality.Views_list();
	    }
	    
	    
	    //TC_TV_154 
	    @And("^verify Edit Table Border - Verify Table width$")
	    public void verify_Edit_Table_Border_Verify_Table_width() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			 Thread.sleep(3000); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordersetting"))).click();
			 Thread.sleep(3000); 
			 WebElement x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordersetting_checkinput")));
			 
			 Actions border = new Actions(login.driver);
					 border.moveToElement(x).pause(5000).click().build().perform();
			 Thread.sleep(3000); 
			 String width = "5";
			 int widthbefore = Integer.parseInt(width);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordersetting_borderlengthinput"))).sendKeys(width);
			 Thread.sleep(3000); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			 
			 Thread.sleep(3000); 
			 String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Blackbordertable"))).getCssValue("border-width");
			 String wafter = y.replaceAll("\\D", "");
			 int expectedwidth = Integer.parseInt(wafter);
			 System.out.println("Border width" + expectedwidth);
			 Thread.sleep(3000); 
			 
			  if(widthbefore == expectedwidth){
				 System.out.println("Verified");
			 }else {
				 Assert.fail();
			 }
			  Thread.sleep(1000);
				 CommonFunctionality.Views_list();
	    }
	    
	    
	    
	    
	    //TC_TV_155 
	    @And("^verify Edit Table Border - Verify Table style$")
	    public void verify_Edit_Table_Border_Verify_Table_style() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			 Thread.sleep(3000); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordersetting"))).click();
			 Thread.sleep(3000); 
			 WebElement x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordersetting_checkinput")));
			 Actions border = new Actions(login.driver);
					 border.moveToElement(x).pause(5000).click().build().perform();
			 Thread.sleep(3000); 
			 String width = "5";
			 int widthbefore = Integer.parseInt(width);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordersetting_borderlengthinput"))).sendKeys(width);
			 Thread.sleep(3000); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Borderstyledropdown"))).click();
			 Thread.sleep(3000); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("BorderstyledropdownDashed"))).click();
			 String m =  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("BorderstyledropdownDashed"))).getAttribute("title");		
			 Thread.sleep(3000); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			 Thread.sleep(3000); 
			 String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Blackbordertable"))).getCssValue("border-style");
			 Thread.sleep(3000); 
			  if(m.equalsIgnoreCase(y) ){
				 System.out.println("Verified");
			 }else {
				 Assert.fail();
			 }
			  Thread.sleep(1000);
				 CommonFunctionality.Views_list();
	    }
	    
	    
	    
	   
	    //TC_TV_156 
	    @And("^verify Edit Table Border - Verify Table type$")
	    public void verify_Edit_Table_Border_Verify_Table_type() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			 Thread.sleep(3000); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordersetting"))).click();		 
			 Thread.sleep(3000); 	 
		     WebElement x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordersetting_borderlengthinput_table")));
			 Actions border = new Actions(login.driver);
					 border.moveToElement(x).pause(5000).click().sendKeys("5").build().perform();
			 Thread.sleep(3000); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Bordertypedropdown"))).click();
			 Thread.sleep(3000); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("BordertypedropdownInner"))).click();
			 Thread.sleep(3000); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			 Thread.sleep(3000); 
			 String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Bordertableinner"))).getCssValue("border-style");
			 System.out.println("Verifiedtype" +y);
			 Thread.sleep(3000); 
			  if(y.contains("dotted") ){
				 System.out.println("Verified");
			 }else {
				 Assert.fail();
			 }
			  Thread.sleep(1000);
				 CommonFunctionality.Views_list();
	    }

	    
	    
	    
	    //TC_TV_157
	    @And("^verify Edit Table Border=NO for visual$")
	    public void verify_Edit_Table_Border_NO_for_visual() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			 Thread.sleep(3000); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordersetting"))).click();		 
			 
			 Thread.sleep(3000); 
			 WebElement x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordervisualsetting_checkinput")));
			 Actions border = new Actions(login.driver);
			 border.moveToElement(x).pause(5000).build().perform();
			boolean y = x.isSelected();
			 System.out.println("Boolean"+y);
			 if(y==false) {
				 System.out.println("Verified");
			 }else {
				 Assert.fail();
			 }
			  Thread.sleep(1000);
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
				 Thread.sleep(1000);
				 CommonFunctionality.Views_list();
	    }
	    
	    
	   
	    //TC_TV_158
	    @And("^verify Edit Table Border=Yes for visual$")
	    public void verify_Edit_Table_Border_Yes_for_visual() throws Throwable {
	    	verify_Edit_Table_Border_Verify_Table_width();
	    }
	    
	    
	    //TC_TV_159
	    @And("^verify Edit Table Border visual color$")
	    public void verify_Edit_Table_Border_visual_color() throws Throwable {
	    	verify_Edit_Table_Border_Verify_Table_color();
	    }
	    
	    
	    //TC_TV_160
	    @And("^verify Edit Table Border visual width$")
	    public void verify_Edit_Table_Border_visual_width() throws Throwable {
	    	verify_Edit_Table_Border_Verify_Table_width();
	    }
	    
	    
	    //TC_TV_161
	    @And("^verify Edit Table Border visual Radius$")
	    public void verify_Edit_Table_Border_visual_Radius() throws Throwable {
	    	
	    	CreateTable();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			 Thread.sleep(3000); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordersetting"))).click();
			 Thread.sleep(3000); 
			 WebElement x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordersetting_checkinput")));
			 
			 Actions border = new Actions(login.driver);
					 border.moveToElement(x).pause(5000).click().build().perform();
			 Thread.sleep(3000); 
			 String width = "10";
			 int widthbefore = Integer.parseInt(width);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("BorderRadius"))).sendKeys(width);
			 Thread.sleep(3000); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			 
			 Thread.sleep(3000); 
			 String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Blackbordertable"))).getCssValue("border-radius");
			 String wafter = y.replaceAll("\\D", "");
			 int expectedwidth = Integer.parseInt(wafter);
			 System.out.println("Border Radius" + expectedwidth);
			 Thread.sleep(3000); 
			 
			  if(widthbefore == expectedwidth){
				 System.out.println("Verified");
			 }else {
				 Assert.fail();
			 }
			  Thread.sleep(1000);
				 CommonFunctionality.Views_list();
	    }
	    //TC_TV_162
	    @And("^verify Edit Table Border visual style$")
	    public void verify_Edit_Table_Border_visual_style() throws Throwable {
	    	verify_Edit_Table_Border_Verify_Table_style();
	    }
	    
	    
	    //TC_TV_163
	    @And("^verify Edit Table Border advance settings$")
	    public void verify_Edit_Table_Border_advance_settings() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			 Thread.sleep(3000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("BorderAdvancesettingicon"))).click();
			 Thread.sleep(3000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("BorderAdvancesettingelement"))).click();
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("AdvancesettingelementVisualborder"))).isDisplayed());
				 System.out.println("Verified"); 
				Thread.sleep(1000);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
					 Thread.sleep(1000);
					 CommonFunctionality.Views_list();
	
	    }
	    
	  //TC_TV_164 
	    @And("^verify Edit Table Border advance settings cogwheel$")
	    public void verify_Edit_Table_Border_advance_settings_cogwheel() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			 Thread.sleep(3000); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordersetting"))).click();
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("AdvancesettingelementVisualborder"))).isDisplayed());
				 System.out.println("Verified"); 
				Thread.sleep(1000);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
					 Thread.sleep(1000);
					 CommonFunctionality.Views_list();
	    }
	    
	    
	    
	  //TC_TV_165 
	    @And("^verify Edit Table Border closing of visual popup$")
	    public void verify_Edit_Table_Border_closing_of_visual_popup() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			 Thread.sleep(3000); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordersetting"))).click();
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("POP_title_close"))).isDisplayed());
				 System.out.println("Verified"); 
				 Thread.sleep(1000);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("POP_title_close"))).click();
				  if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("POP_title_close"))).size() == 0) 
					{
						System.out.println("Verified");
					} else 
					{
						Assert.fail();
					}
				  Thread.sleep(1000);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
					 Thread.sleep(1000);
					 CommonFunctionality.Views_list();
	    }
	    
	    
	  //TC_TV_166
	    @And("^verify Edit Table Show Check for attribute$")
	    public void verify_Edit_Table_Show_Check_for_attribute() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			 Thread.sleep(2000);
			boolean x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EdittableShowcheckbox"))).isSelected();
			System.out.println("BooleanVerified" +x);
			if(x==true) {
				System.out.println("Verified");
			}else {
				Assert.fail();
			}
			Thread.sleep(1000);
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
				 Thread.sleep(1000);
				 CommonFunctionality.Views_list();
  
	    }
	    
	    
	    //TC_TV_167
	    @And("^verify Edit Table Show Unheck for attribute$")
	    public void verify_Edit_Table_Show_Unheck_for_attribute() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EdittableShowuncheckbox"))).click();
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			 Thread.sleep(3000); 
			 if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("NameAttributeshowuncheck"))).size() == 0) 
				{
					System.out.println("Verified");
				} else 
				{
					Assert.fail();
				}
	            Thread.sleep(1000);
				 CommonFunctionality.Views_list();
	    }
	    
	    
	    
	    
	    //TC_TV_168
	    @And("^verify Edit Table Show clicking on open advance settings popup$")
	    public void verify_Edit_Table_Show_clicking_on_open_advance_settings_popup() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("NameAttributeshowdropdown"))).click();
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("BorderAdvancesettingelement"))).click();
			 Thread.sleep(2000);
			 Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EdittableAttributepopup"))).isDisplayed());
				 System.out.println("Verified"); 
				 Thread.sleep(1000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("POP_title_close"))).click();
				  Thread.sleep(1000);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
					 Thread.sleep(1000);
					 CommonFunctionality.Views_list();
	    }
	    
	  //TC_TV_169
	    @And("^verify Edit Table Show Check for statistics$")
	    public void verify_Edit_Table_Show_Check_for_statistics() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);
			List<WebElement> attributes_list = login.driver.findElements(By.className("hor-vertical-header"));
			int attributes_table_count_before = attributes_list.size();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ShowStatiticscheckbox"))).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
				 
				 
					List<WebElement> attributes_list_after = login.driver.findElements(By.className("hor-vertical-header"));
					int attributes_table_count_after = attributes_list_after.size();
					
					if (attributes_table_count_after != attributes_table_count_before){
						System.out.println("Verified");
					}
					else{
						Assert.fail();
					}
					Thread.sleep(2000);
					CommonFunctionality.Views_list();
				 
	    }
	    
	  //TC_TV_170
	    @And("^verify Edit Table Show Unheck for statistics$")
	    public void verify_Edit_Table_Show_Unheck_for_statistics() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);
			List<WebElement> attributes_list = login.driver.findElements(By.className("hor-vertical-header"));
			int attributes_table_count_before = attributes_list.size();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ShowStatiticscheckbox"))).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();	 
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
					Thread.sleep(2000);
					 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ShowStatiticscheckbox"))).click();
					 Thread.sleep(2000);
					 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
					 Thread.sleep(2000);
						List<WebElement> attributes_list_after = login.driver.findElements(By.className("hor-vertical-header"));
						int attributes_table_count_after = attributes_list_after.size();
						if (attributes_table_count_after == attributes_table_count_before){
							System.out.println("Verified");
						}
						else{
							Assert.fail();
						}
						Thread.sleep(2000);
						CommonFunctionality.Views_list();
	    }
	    
	    
	    
	  //TC_TV_171
	    @And("^verify Edit Table Show clicking on open advance settings popup- statistics$")
	    public void verify_Edit_Table_Show_clicking_on_open_advance_settings_popup_statistics() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ShowStatiticscheckbox"))).click();
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ShowStatiticsdropdown"))).click();
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("BorderAdvancesettingelement"))).click();
			 Thread.sleep(2000);
			 Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EdittableAttributepopup"))).isDisplayed());
				 System.out.println("Verified"); 
				 Thread.sleep(1000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("POP_title_close"))).click();
				  Thread.sleep(1000);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
				  Thread.sleep(1000);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).click();
					 Thread.sleep(1000);
					 CommonFunctionality.Views_list();
	    }
	    
	    
	    
		  //TC_TV_172
	    @And("^verify Edit Table Title  as Title=Yes$")
	    public void verify_Edit_Table_Title_as_Title_Yes() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			 Thread.sleep(2000);
			 Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EdittableTitle"))).isDisplayed());
				 System.out.println("Verified"); 
				  Thread.sleep(1000);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
				 Thread.sleep(1000);
				 CommonFunctionality.Views_list();
	    }
	    
	    
	    //TC_TV_173
	    @And("^verify Edit Table Title  as Title=NO$")
	    public void verify_Edit_Table_Title_as_Title_NO() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				 Thread.sleep(500); 
				WebElement edittitlesetting = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
		        Actions etseting = new Actions(login.driver);
		        etseting.moveToElement(edittitlesetting).pause(5000).click().build().perform();
				 Thread.sleep(500); 
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting_checkbox"))).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
				 Thread.sleep(5000);
				 
				boolean x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_title"))).isDisplayed();
				 
				 if (x == false) 
					{
						System.out.println("Verified");
					} else 
					{
						Assert.fail();
					}
		            Thread.sleep(1000);
					 CommonFunctionality.Views_list();

	    }
	    
	    
	    
	    //TC_TV_174
	    @And("^verify Edit Table Title default selection for title$")
	    public void verify_Edit_Table_Title_default_selection_for_title() throws Throwable {
	    	verify_Edit_Table_Title_as_Title_Yes();
	    }
	    
	    //TC_TV_175
	    @And("^verify Edit Table Auto title$")
	    public void verify_Edit_Table_Auto_title() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);
			
	        String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_title"))).getText();
	        
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			 Thread.sleep(500); 
			WebElement edittitlesetting = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
	        Actions etseting = new Actions(login.driver);
	        etseting.moveToElement(edittitlesetting).pause(5000).click().build().perform();
			 Thread.sleep(500); 
			 boolean y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edittabeldefaulttitlecheckbox"))).isSelected();
			
			 if (y == true) 
				{
					System.out.println("Verified title check box is checked");
				} else 
				{
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting_checkbox"))).click();
				}
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			 Thread.sleep(5000); 
			 String z = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_title"))).getText();
			 if(x.equalsIgnoreCase(z)) {
				 System.out.println("Verified");
			 }else {
				 Assert.fail();
			 }
			 Thread.sleep(1000);
			 CommonFunctionality.Views_list();
	    }
	    
	    
	    //TC_TV_176
	    @And("^verify Edit Table renaming title$")
	    public void verify_Edit_Table_renaming_title() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	        Thread.sleep(500); 
			WebElement edittitlesetting = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
	        Actions etseting = new Actions(login.driver);
	        etseting.moveToElement(edittitlesetting).pause(5000).click().build().perform();
			 Thread.sleep(500); 
			 String input = "Testingseries";
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_tabel_defaulttitle_inputfield"))).sendKeys(input);
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			 Thread.sleep(5000); 
			 String z = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_title"))).getText();
			 if(input.equalsIgnoreCase(z)) {
				 System.out.println("Verified");
			 }else {
				 Assert.fail();
			 }
			 Thread.sleep(1000);
			 CommonFunctionality.Views_list();
	    }
	    
	    
	    //TC_TV_177
	    @And("^verify Edit Table sub title=Check$")
	    public void verify_Edit_Table_sub_title_Check() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	        Thread.sleep(2000);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_tabel_subtitle_dropdown"))).click();
	        Thread.sleep(2000);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_tabel_subtitle_checkbox"))).click();
	        Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			 Thread.sleep(2000);
			 Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("veiwtabel_subtitle"))).isDisplayed());
				 System.out.println("Verified"); 
				 Thread.sleep(1000);
				 CommonFunctionality.Views_list();
	    }
	    
	    
	    
	    
	    
	    //TC_TV_178
	    @And("^verify Edit Table sub title by default$")
	    public void verify_Edit_Table_sub_title_by_default() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	        Thread.sleep(2000);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_tabel_subtitle_dropdown"))).click();
	        
	        boolean x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_tabel_subtitle_checkbox"))).isSelected();
	        if(x==false) {
	        	 System.out.println("Verified"); 
	        }
	        else {
		    	Assert.fail();
		    }
	        Thread.sleep(1000);
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
			 Thread.sleep(1000);
			 CommonFunctionality.Views_list();
	    }
	    
	    //TC_TV_179
	    @And("^verify Edit Table sub title=UnCheck$")
	    public void verify_Edit_Table_sub_title_UnCheck() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	        Thread.sleep(2000);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_tabel_subtitle_dropdown"))).click();
	        
	        boolean x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_tabel_subtitle_checkbox"))).isSelected();
	        if(x==false) {
	        	 System.out.println("Verified that checkox is uncheck"); 
	        }
	        else {
	        	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_tabel_subtitle_checkbox"))).click();
		    }
	        Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			 
			 boolean y =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("veiwtabel_subtitle"))).isDisplayed();
			 if(y==false) {
	        	 System.out.println("Verified"); 
	        }
	        else {
	        	Assert.fail();
		    }
			 Thread.sleep(1000);
			 CommonFunctionality.Views_list();
	    }
	    
	    
	    
	    
	    
	    //TC_TV_180
	    @And("^verify Edit Table default title for sub title$")
	    public void verify_Edit_Table_default_title_for_sub_title() throws Throwable {
	    	verify_Edit_Table_sub_title_Check();
	    }
	    
	    
	    
	  //TC_TV_181
	    @And("^verify Edit Table advance settings-title$")
	    public void verify_Edit_Table_advance_settings_title() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	        Thread.sleep(2000);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_tabel_subtitle_dropdown"))).click();
	        Thread.sleep(2000);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("BorderAdvancesettingelement"))).click();
	        Thread.sleep(2000);  
	        Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Advancesettingtitlepopup"))).isDisplayed());
			 System.out.println("Verified"); 
			   Thread.sleep(2000);  
		        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("POP_title_close"))).click();
		        Thread.sleep(1000);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
				 Thread.sleep(1000);
				 CommonFunctionality.Views_list();
			 
	    }
	    
	  //TC_TV_182
	    @And("^verify Edit Table advance settings cogwheel icon-title$")
	    public void verify_Edit_Table_advance_settings_cogwheel_icon_title() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(1000);  
	        WebElement edittitlesetting = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
	        Actions etseting = new Actions(login.driver);
	        etseting.moveToElement(edittitlesetting).pause(5000).click().build().perform();
	        Thread.sleep(2000);  
	        Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Advancesettingtitlepopup"))).isDisplayed());
			 System.out.println("Verified"); 
			   Thread.sleep(2000);  
		        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("POP_title_close"))).click();
		        Thread.sleep(1000);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
				 Thread.sleep(1000);
				 CommonFunctionality.Views_list();
  
	    }
	    //TC_TV_183
	    @And("^verify Edit Table color for visual title$")
	    public void verify_Edit_Table_color_for_visual_title() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(1000);  
	        WebElement edittitlesetting = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
	        Actions etseting = new Actions(login.driver);
	        etseting.moveToElement(edittitlesetting).pause(5000).click().build().perform();
	        Thread.sleep(2000);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Visual_colour_title"))).click();
	        Thread.sleep(1000);
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Visual_colour_title_red"))).click();
			  Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
				  Thread.sleep(2000);
				 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_title"))).getCssValue("background-color");
				 System.out.println("Verified X as " + x);
				 if(x.contains("rgba(0, 0, 0, 0)")){
					 System.out.println("Verified");
				 }else {
					 Assert.fail();
				 }
				 
						 Thread.sleep(2000);
				 CommonFunctionality.Views_list();
				 
				 
	    }
	    
	  //TC_TV_184
	    @And("^verify Edit Table color for  visual title background$")
	    public void verify_Edit_Table_color_for_visual_title_background() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(1000);  
	        WebElement edittitlesetting = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
	        Actions etseting = new Actions(login.driver);
	        etseting.moveToElement(edittitlesetting).pause(5000).click().build().perform();
	        Thread.sleep(2000);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Visual_colour_background_title"))).click();
	        Thread.sleep(1000);
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Visual_colour_background_orange_title"))).click();
			  Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
				 Thread.sleep(2000);
				 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_title"))).getCssValue("background-color");
				 System.out.println("Verified X as " + x);
				 if(x.contains("rgba(253, 165, 70, 1)")){
					 System.out.println("Verified");
				 }else {
					 Assert.fail();
				 }
				 
						 Thread.sleep(2000);
				 CommonFunctionality.Views_list();
	    }
	    
	    
	    
	  //TC_TV_185
	    @And("^verify Edit Table font size for visual title$")
	    public void verify_Edit_Table_font_size_for_visual_title() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(1000);  
	        WebElement edittitlesetting = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
	        Actions etseting = new Actions(login.driver);
	        etseting.moveToElement(edittitlesetting).pause(5000).click().build().perform();
	        Thread.sleep(2000);  
	        String visualsize = "30";
	        int widthbefore = Integer.parseInt(visualsize);
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Visual_Size_title_input"))).clear();
	        Thread.sleep(500);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Visual_Size_title_input"))).sendKeys(visualsize);
	        Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			 Thread.sleep(3000); 
			 String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_title"))).getCssValue("font-size");
			 String wafter = y.replaceAll("\\D", "");
			 int expectedwidth = Integer.parseInt(wafter);
			 System.out.println("Border width" + expectedwidth);
			 Thread.sleep(3000); 
			  if(widthbefore == expectedwidth){
				 System.out.println("Verified");
			 }else {
				 Assert.fail();
			 }
			 
					 Thread.sleep(2000);
			 CommonFunctionality.Views_list();
	        
	        
	    }
	    
	    
	    
	    //TC_TV_186
	    @And("^verify Edit Table bold style for visual title$")
	    public void verify_Edit_Table_bold_style_for_visual_title() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(1000);  
	        WebElement edittitlesetting = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
	        Actions etseting = new Actions(login.driver);
	        etseting.moveToElement(edittitlesetting).pause(5000).click().build().perform();
	        Thread.sleep(2000);  
	        String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Visual_text_title_BOLD"))).getAttribute("class");
	        if(x.contains("selected")) {
	        	 System.out.println("Verified");
	        }else {
	        	Assert.fail();
	        }
	        
	        Thread.sleep(1000);
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
	        Thread.sleep(2000);
			 CommonFunctionality.Views_list();
	    }
	    
	    //TC_TV_187
	    @And("^verify Edit Table bold style default selection for visual title$")
	    public void verify_Edit_Table_bold_style_default_selection_for_visual_title() throws Throwable {
	    	verify_Edit_Table_bold_style_for_visual_title();
	    }
	    
	    
	    //TC_TV_188
	    @And("^verify Edit Table Italic style for visual title$")
	    public void verify_Edit_Table_Italic_style_for_visual_title() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(1000);  
	        WebElement edittitlesetting = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
	        Actions etseting = new Actions(login.driver);
	        etseting.moveToElement(edittitlesetting).pause(5000).click().build().perform();
	        Thread.sleep(1000);
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Visual_text_title_Italics"))).click();
			   Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
				 Thread.sleep(2000);
				 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_title"))).getCssValue("font-style");
				 System.out.println("Verified X as " + x);
				 if(x.contains("italic")){
					 System.out.println("Verified");
				 }else {
					 Assert.fail();
				 }
				 
						 Thread.sleep(2000);
				 CommonFunctionality.Views_list();
	    }
	    
	    
	    //TC_TV_189 
	    @And("^verify Edit Table Underline style for visual title$")
	    public void verify_Edit_Table_Underline_style_for_visual_title() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(1000);  
	        WebElement edittitlesetting = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
	        Actions etseting = new Actions(login.driver);
	        etseting.moveToElement(edittitlesetting).pause(5000).click().build().perform();
	        Thread.sleep(1000);
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Visual_text_title_underline"))).click();
			   Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
				 Thread.sleep(2000);
				 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_title"))).getCssValue("text-decoration");
				 System.out.println("Verified X as " + x);
				 if(x.contains("underline")){
					 System.out.println("Verified");
				 }else {
					 Assert.fail();
				 }
				 
						 Thread.sleep(2000);
				 CommonFunctionality.Views_list();
	    }
	    
	    
	    //TC_TV_190
	    @And("^verify Edit Table horizontal alignment \\(left, right, center\\)$")
	    public void verify_Edit_Table_horizontal_alignment_left_right_center() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(1000);  
	        WebElement edittitlesetting = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
	        Actions etseting = new Actions(login.driver);
	        etseting.moveToElement(edittitlesetting).pause(5000).click().build().perform();
	        Thread.sleep(1000);
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Visual_text_title_left"))).click();
			   Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
				 Thread.sleep(2000);
				 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_title"))).getCssValue("text-align");
				 System.out.println("Verified X as " + x);
				 if(x.contains("left")){
					 System.out.println("Verified");
				 }else {
					 Assert.fail();
				 }
	
						 Thread.sleep(2000);
				 CommonFunctionality.Views_list();
	    }
	    
	    //TC_TV_191
	    @And("^verify Edit Table color for visual sub title$")
	    public void verify_Edit_Table_color_for_visual_sub_title() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(1000);  
	        WebElement edittitlesetting = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
	        Actions etseting = new Actions(login.driver);
	        etseting.moveToElement(edittitlesetting).pause(5000).click().build().perform();
	        Thread.sleep(1000);
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_subtitle"))).click();
	        Thread.sleep(1000);
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_checkbox"))).click();
	        Thread.sleep(1000);
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_colour_dropdown"))).click();
	       
	        
	        Thread.sleep(3000);
	        CommonFunctionality.Hidden_Webelements_handling(login.driver,"xpath", "//span[@title='#a2c96a']");
	       /* try {
	        WebElement subtitlecolour = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_colour_green")));
	        Actions sub_titlecolour = new Actions(login.driver);
	        sub_titlecolour.moveToElement(subtitlecolour).pause(5000).click().build().perform();
	        } 
	        
	        catch(org.openqa.selenium.JavascriptException e) {
	        	 WebElement subtitlecolour = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_colour_green")));
	 	        Actions sub_titlecolour = new Actions(login.driver);
	 	        sub_titlecolour.moveToElement(subtitlecolour).pause(5000).click().build().perform();
	        }*/
	      
	        Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
		
	        
			 Thread.sleep(2000);
			 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("veiwtabel_subtitle"))).getCssValue("color");
			 System.out.println("Verified colour X as " + x);
			 if(x.contains("rgba(162, 201, 106, 1)")){
				 System.out.println("Verified");
			 }else {
				 Assert.fail();
			 }
			 
					 Thread.sleep(2000);
			 CommonFunctionality.Views_list();
	        
	        
	        
	        
	    }
	    
	    
	    //TC_TV_192
	    @And("^verify Edit Table color for visual sub title background$")
	    public void verify_Edit_Table_color_for_visual_sub_title_background() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(1000);  
	        WebElement edittitlesetting = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
	        Actions etseting = new Actions(login.driver);
	        etseting.moveToElement(edittitlesetting).pause(5000).click().build().perform();
	        Thread.sleep(1000);
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_subtitle"))).click();
	        Thread.sleep(1000);
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_checkbox"))).click();
	        Thread.sleep(1000);
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_backgroundcolour"))).click();
	       
	        
	        WebElement subtitlebackcolour = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_backgroundcolour_orange")));
	        Actions sub_titlebkcolour = new Actions(login.driver);
	        sub_titlebkcolour.moveToElement(subtitlebackcolour).pause(5000).click().build().perform();
	        
	        Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			 
		
	        
	        
			 Thread.sleep(2000);
			 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("veiwtabel_subtitle"))).getCssValue("background-color");
			 System.out.println("Verified background colour X as " + x);
			 if(x.contains("rgba(255, 91, 77, 1)")){
				 System.out.println("Verified");
			 }else { 
				 Assert.fail();
			 }
			 
					 Thread.sleep(2000);
			 CommonFunctionality.Views_list();
	    }
	    
	    
	    //TC_TV_193 
	    @And("^verify Edit Table font size for visual sub title$")
	    public void verify_Edit_Table_font_size_for_visual_sub_title() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(1000);  
	        WebElement edittitlesetting = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
	        Actions etseting = new Actions(login.driver);
	        etseting.moveToElement(edittitlesetting).pause(5000).click().build().perform();
	        Thread.sleep(1000);
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_subtitle"))).click();
	        Thread.sleep(1000);
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_checkbox"))).click();
	   	    String width = "30";
		    int widthbefore = Integer.parseInt(width);
		   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_size"))).sendKeys(width);
		   Thread.sleep(3000); 
		   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click(); 
			 Thread.sleep(2000);
			 String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("veiwtabel_subtitle"))).getCssValue("font-size");
			 System.out.println("Verified fontsize Y as " + y);
			 String wafter = y.replaceAll("\\D", "");
			 int expectedwidth = Integer.parseInt(wafter);
			 System.out.println("Border width" + expectedwidth);
			 Thread.sleep(3000); 
			 
			  if(widthbefore == expectedwidth){
				 System.out.println("Verified");
			 }else {
				 Assert.fail();
			 }
			 
			  Thread.sleep(1000);
			  CommonFunctionality.Views_list();

	    }
	    
	    //TC_TV_194
	    @And("^verify Edit Table bold style for visual sub title$")
	    public void verify_Edit_Table_bold_style_for_visual_sub_title() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(1000);  
	        WebElement edittitlesetting = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
	        Actions etseting = new Actions(login.driver);
	        etseting.moveToElement(edittitlesetting).pause(5000).click().build().perform();
	        Thread.sleep(1000);
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_subtitle"))).click();
	        Thread.sleep(1000);
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_checkbox"))).click();
	
	        Thread.sleep(1000);
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_bold"))).click();
	        
	        Thread.sleep(3000); 
			   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click(); 
				 Thread.sleep(2000);
				 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("veiwtabel_subtitle"))).getCssValue("font-style");
				 System.out.println("Verified bold X as " + x);
				 if(x.contains("normal")){
					 System.out.println("Verified");
				 }else { 
					 Assert.fail();
				 }
				 
						 Thread.sleep(2000);
				 CommonFunctionality.Views_list();
	    }
	    
	    
	    
	    //TC_TV_195
	    @And("^verify Edit Table Italic style for visual sub title$")
	    public void verify_Edit_Table_Italic_style_for_visual_sub_title() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(1000);  
	        WebElement edittitlesetting = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
	        Actions etseting = new Actions(login.driver);
	        etseting.moveToElement(edittitlesetting).pause(5000).click().build().perform();
	        Thread.sleep(1000);
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_subtitle"))).click();
	        Thread.sleep(1000);
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_checkbox"))).click();
	
	        Thread.sleep(1000);
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_italic"))).click();
	        
	        Thread.sleep(3000); 
			   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click(); 
				 Thread.sleep(2000);
				 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("veiwtabel_subtitle"))).getCssValue("font-style");
				
				 if(x.contains("italic")){
					 System.out.println("Verified");
				 }else { 
					 Assert.fail();
				 }
				 
						 Thread.sleep(2000);
				 CommonFunctionality.Views_list();
	    }
	    //TC_TV_196
	    @And("^verify Edit Table Underline style for visual sub title$")
	    public void verify_Edit_Table_Underline_style_for_visual_sub_title() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(1000);  
	        WebElement edittitlesetting = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
	        Actions etseting = new Actions(login.driver);
	        etseting.moveToElement(edittitlesetting).pause(5000).click().build().perform();
	        Thread.sleep(1000);
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_subtitle"))).click();
	        Thread.sleep(1000);
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_checkbox"))).click();
	
	        Thread.sleep(1000);
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_underline"))).click();
	        
	        Thread.sleep(3000); 
			   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click(); 
				 Thread.sleep(2000);
				 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("veiwtabel_subtitle"))).getCssValue("text-decoration");
				
				 if(x.contains("underline")){
					 System.out.println("Verified");
				 }else { 
					 Assert.fail();
				 }
				 
						 Thread.sleep(2000);
				 CommonFunctionality.Views_list();
	    }
	    
	    
	    
	    
	    
	    //TC_TV_197
	    @And("^verify Edit Table horizontal alignment \\(left, right, center\\) of sub title$")
	    public void verify_Edit_Table_horizontal_alignment_left_right_center_of_sub_title() throws Throwable {
	      
	    	CreateTable();
			Thread.sleep(2000);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(1000);  
	        WebElement edittitlesetting = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
	        Actions etseting = new Actions(login.driver);
	        etseting.moveToElement(edittitlesetting).pause(5000).click().build().perform();
	        Thread.sleep(1000);
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_subtitle"))).click();
	        Thread.sleep(1000);
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_checkbox"))).click();
	        Thread.sleep(1000);
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_left"))).click();
	        Thread.sleep(3000); 
			   login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click(); 
			   
			   Thread.sleep(2000);
				 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("veiwtabel_subtitle"))).getCssValue("text-align");
				
				 if(x.contains("left")){
					 System.out.println("Verified");
				 }else { 
					 Assert.fail();
				 }
				 
						 Thread.sleep(2000);
				 CommonFunctionality.Views_list();
	    }
	    
	    
	    
	    
	    
	    //TC_TV_198
	    @And("^verify Edit Table expanding and collapsing the title and subtitle sections$")
	    public void verify_Edit_Table_expanding_and_collapsing_the_title_and_subtitle_sections() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(1000);  
	        WebElement edittitlesetting = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
	        Actions etseting = new Actions(login.driver);
	        etseting.moveToElement(edittitlesetting).pause(5000).click().build().perform();
	        Thread.sleep(1000);
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_subtitle"))).click();
	   	 Thread.sleep(2000);
		 Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_checkbox"))).isDisplayed());
			 System.out.println("Verified"); 
			 Thread.sleep(500); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
			 Thread.sleep(1000);
			 CommonFunctionality.Views_list();
	    }
	    
	    
	    
	    //TC_TV_199
	    @And("^verify Edit Table closing of Titles popup$")
	    public void verify_Edit_Table_closing_of_Titles_popup() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(1000);  
	        WebElement edittitlesetting = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
	        Actions etseting = new Actions(login.driver);
	        etseting.moveToElement(edittitlesetting).pause(5000).click().build().perform();
	    	 Thread.sleep(2000);
			 Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("POP_title_close"))).isDisplayed());
			 Thread.sleep(1000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("POP_title_close"))).click();
			 Thread.sleep(3000);
				if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("POP_title_close"))).size() == 0) 
				{
					System.out.println("Verified");
				} else 
				{
					Assert.fail();
				}
				 Thread.sleep(500); 
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
				 Thread.sleep(1000);
				 CommonFunctionality.Views_list();
	    }

	    
	    //TC_TV_200
	    @And("^verify Edit Table Wrap text=checked$")
	    public void verify_Edit_Table_Wrap_text_checked() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(1000);  
	        WebElement Wraptextcheckbox = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_wrap_text")));
	        Actions etseting = new Actions(login.driver);
	        etseting.moveToElement(Wraptextcheckbox).pause(5000).build().perform();
	    	Thread.sleep(2000);
	        boolean y =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_wrap_text_checkbox"))).isSelected();
	      
			 if(y==true) {
	        	 System.out.println("Verified"); 
	        }
	        else {
	        	Assert.fail();
		    }
			 Thread.sleep(500); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
			 Thread.sleep(1000);
			 CommonFunctionality.Views_list();
	        
	        
	    }
	    //TC_TV_201
	    @And("^verify Edit Table Wrap text=unchecked$")
	    public void verify_Edit_Table_Wrap_text_unchecked() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(1000);  
	        WebElement Wraptextcheckbox = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_wrap_text")));
	        Actions etseting = new Actions(login.driver);
	        etseting.moveToElement(Wraptextcheckbox).pause(5000).click().build().perform();
	        Thread.sleep(2000);
	        boolean y =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_wrap_text_checkbox"))).isSelected();
	        System.out.println("Verified y as" + y); 
			 if(y==false) {
	        	 System.out.println("Verified"); 
	        }
	        else {
	        	Assert.fail();
		    }
			 Thread.sleep(500); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
			 Thread.sleep(500); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).click();
		 Thread.sleep(1000);
		 CommonFunctionality.Views_list();
	    }
	    
	    
	    
	    
	  //TC_TV_202
	    @And("^verify Edit Table Invert=checked$")
	    public void verify_Edit_Table_Invert_checked() throws Throwable {
	
			 CreateTable();
				Thread.sleep(2000);  
		        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
		        WebElement Inverttextcheckbox = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_invert_checkbox")));
		        Actions etseting = new Actions(login.driver);
		        etseting.moveToElement(Inverttextcheckbox).pause(5000).build().perform();
		    	Thread.sleep(2000);
		        boolean y =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_invert_checkbox"))).isSelected();
		      
				 if(y==true) {
		        	 System.out.println("Verified"); 
		        }
		        else {
		        	Assert.fail();
			    }
				 Thread.sleep(500); 
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
				 Thread.sleep(1000);
				 CommonFunctionality.Views_list();
	
	    }
	    
	    
	    
	    
	    //TC_TV_203
	    @And("^verify Edit Table Invert=unchecked$")
	    public void verify_Edit_Table_Invert_unchecked() throws Throwable {
	    	CreateTable();
			Thread.sleep(2000);  
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	        Thread.sleep(2000);
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_invert"))).click();
			 Thread.sleep(500); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			 Thread.sleep(2000);
			 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("table_invert_myseries"))).getAttribute("class");
			
			 if(x.contains("vertical")){
				 System.out.println("Verified");
			 }else { 
				 Assert.fail();
			 }
			 
					 Thread.sleep(2000);
			 CommonFunctionality.Views_list();
	    }
	    
	    //TC_TV_204
	    @And("^verify Edit Table Zebra=checked$")
	    public void verify_Edit_Table_Zebra_checked() throws Throwable {
	    	 CreateTable();
				Thread.sleep(2000);  
		        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
		        WebElement zebratextcheckbox = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_zebra_checkbox")));
		        Actions etseting = new Actions(login.driver);
		        etseting.moveToElement(zebratextcheckbox).pause(5000).build().perform();
		    	Thread.sleep(2000);
		        boolean y =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_zebra_checkbox"))).isSelected();
		        Thread.sleep(500); 
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
		        Thread.sleep(1000);
		        String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_zebra_backround"))).getCssValue("background-color");
		       
		 
		        if(y==true && x.contains("rgba(249, 246, 251, 1)")) {
		        	 System.out.println("Verified"); 
		        }
		        else {
		        	Assert.fail();
			    }
		
				 Thread.sleep(1000);
				 CommonFunctionality.Views_list();
	    }
	    
	    
	    
	    //TC_TV_205
	    @And("^verify Edit Table Zebra=unchecked$")
	    public void verify_Edit_Table_Zebra_unchecked() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(1000);  
	    	WebElement zebratextcheckbox = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_zebra")));
	    	Actions etseting = new Actions(login.driver);
	    	etseting.moveToElement(zebratextcheckbox).pause(5000).click().build().perform();
	    	Thread.sleep(3000); 
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click(); 
	    	Thread.sleep(2000);
	    	String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_zebra_backround"))).getCssValue("background-color");

	    	System.out.println("Verified x as" + x);
	    	Thread.sleep(2000);

	    	if(x.contains("rgba(255, 255, 255, 1)")){
	    		System.out.println("Verified");
	    	}else { 
	    		Assert.fail();
	    	}

	    	Thread.sleep(2000);
	    	CommonFunctionality.Views_list();
	    }
	    
	    
	    //TC_TV_206
	    @And("^verify Edit Table Alternating color for Rows$")
	    public void verify_Edit_Table_Alternating_color_for_Rows() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(1000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_zebra_colour_icon"))).click();
	    	Thread.sleep(1000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_zebra_colour_dropdown"))).click();
	    	Thread.sleep(1000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_zebra_colour_orange"))).click();
	    	Thread.sleep(500); 
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();	
	    	Thread.sleep(2000);
	    	String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_zebra_backround"))).getCssValue("background-color");
	    	System.out.println("Verified x as" + x);
	    	Thread.sleep(2000);

	    	if(x.contains("rgba(255, 91, 77, 1)")){
	    		System.out.println("Verified");
	    	}else { 
	    		Assert.fail();
	    	}

	    	Thread.sleep(2000);
	    	CommonFunctionality.Views_list();
	    	
	    	
	    	
	    }
	    
	    
	    //TC_TV_207
	    @And("^verify Edit Table Alternating color for  Column$")
	    public void verify_Edit_Table_Alternating_color_for_Column() throws Throwable {
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(1000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_zebra_colour_icon"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_zebra_coloumn"))).click();
	    	Thread.sleep(1000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_zebra_colour_dropdown"))).click();
	    	Thread.sleep(1000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_zebra_colour_orange"))).click();
	    	Thread.sleep(500); 
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();	
	    	Thread.sleep(2000);
	    	String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_zebra_backround"))).getCssValue("background-color");
	    	System.out.println("Verified x as" + x);
	    	Thread.sleep(2000);

	    	if(x.contains("rgba(255, 255, 255, 1)")){
	    		System.out.println("Verified");
	    	}else { 
	    		Assert.fail();
	    	}

	    	Thread.sleep(2000);
	    	CommonFunctionality.Views_list();
	    	
	    }
	    
	    
	    
	    //TC_TV_208
	    @And("^verify Edit Table Header=checked$")
	    public void verify_Edit_Table_Header_checked() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	
	    	Thread.sleep(2000);
	        boolean y =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_checkbox"))).isSelected();
	        Thread.sleep(500); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
	        Thread.sleep(1000);
	        boolean x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_title"))).isDisplayed();
	        if(y==true && x==true) {
	        	 System.out.println("Verified"); 
	        }
	        else {
	        	Assert.fail();
		    }
	
			 Thread.sleep(1000);
			 CommonFunctionality.Views_list();

	    }
	    
	   // Table_title
	    
	  //TC_TV_209
	    @And("^verify Edit Table Header=unchecked$")
	    public void verify_Edit_Table_Header_unchecked() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header"))).click();
	    	Thread.sleep(2000);
	        boolean y =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_checkbox"))).isSelected();
	        Thread.sleep(500); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	        Thread.sleep(1000);
	        boolean x = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Table_title"))).size()==0;
	        System.out.println("Verified x as" + x); 
	        System.out.println("Verified y as" + y); 
	        
	        if(y==false && x==false) 
	        {
	        	 System.out.println("Verified"); 
	        }
	        else {
	        	Assert.fail();
		    }
	
			 Thread.sleep(1000);
			 CommonFunctionality.Views_list();

	    }
	    
	    
	    
	  //TC_TV_210
	    @And("^verify Edit Table Header font color$")
	    public void verify_Edit_Table_Header_font_color() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_rowcoloumn_icon"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_font_colour"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_font_colour_orange"))).click();
	    	 Thread.sleep(500); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			 Thread.sleep(500); 
			 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_header_font_colour_Myseries"))).getCssValue("color");
		    	System.out.println("Verified x as" + x);
		    	Thread.sleep(2000);

		    	if(x.contains("rgba(255, 91, 77, 1)")){
		    		System.out.println("Verified");
		    	}else { 
		    		Assert.fail();
		    	}

		    	Thread.sleep(2000);
		    	CommonFunctionality.Views_list();
	    }
	    
	    
	    
	    //TC_TV_211 
	    @And("^verify Edit Table Header background color$")
	    public void verify_Edit_Table_Header_background_color() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_rowcoloumn_icon"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_background_colour"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_font_backcolour_orange"))).click();
	    	 Thread.sleep(500); 
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			 Thread.sleep(500); 
			 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_header_font_colour_Myseries"))).getCssValue("background-color");
		    	System.out.println("Verified x as" + x);
		    	Thread.sleep(2000);

		    	if(x.contains("rgba(255, 91, 77, 1)")){
		    		System.out.println("Verified");
		    	}else { 
		    		Assert.fail();
		    	}

		    	Thread.sleep(2000);
		    	CommonFunctionality.Views_list();
	    }
	    
	    //TC_TV_212
	    @And("^verify Edit Table Header font size$")
	    public void verify_Edit_Table_Header_font_size() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_rowcoloumn_icon"))).click();
	    	String headersize = "10";
	    	int widthbefore = Integer.parseInt(headersize);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_pixel"))).clear();
	    	Thread.sleep(5000); 
	    	Actions act = new Actions(login.driver);
	    	WebElement header = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_pixel")));
	    	act.moveToElement(header).pause(5000).sendKeys(headersize);
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(3000); 
	    	String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_header_font_colour_Myseries"))).getCssValue("font-size");
	    	String wafter = y.replaceAll("\\D", "");
	    	int expectedwidth = Integer.parseInt(wafter);
	    	System.out.println("Border width" + expectedwidth);
	    	Thread.sleep(3000); 
	    	if(widthbefore == expectedwidth){
	    		System.out.println("Verified");
	    	}else {
	    		Assert.fail();
	    	}

	    	Thread.sleep(2000);
	    	CommonFunctionality.Views_list();
		        
	    }
	    
	    //TC_TV_213 
	    @And("^verify Edit Table Header bold style$")
	    public void verify_Edit_Table_Header_bold_style() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_rowcoloumn_icon"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_bold_row"))).click();
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(2000);
	    	 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_header_font_colour_Myseries"))).getCssValue("font-weight");
		    	System.out.println("Verified x as" + x);
		    	Thread.sleep(2000);
		    	if(x.contains("700")){
		    		System.out.println("Verified");
		    	}else { 
		    		Assert.fail();
		    	}

		    	Thread.sleep(2000);
		    	CommonFunctionality.Views_list();
	    	
	    	
	    }
	    
	    //TC_TV_214 
	    @And("^verify Edit Table Header Italic style$")
	    public void verify_Edit_Table_Header_Italic_style() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_rowcoloumn_icon"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_Italic_row"))).click();
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(2000);
	    	 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_header_font_colour_Myseries"))).getCssValue("font-style");
		    	System.out.println("Verified x as" + x);
		    	Thread.sleep(2000);
		    	if(x.contains("italic")){
		    		System.out.println("Verified");
		    	}else { 
		    		Assert.fail();
		    	}

		    	Thread.sleep(2000);
		    	CommonFunctionality.Views_list();
	    }
	    
	    
	    
	  //TC_TV_215
	    @And("^verify Edit Table Header Italic Underline$")
	    public void verify_Edit_Table_Header_Italic_Underline() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_rowcoloumn_icon"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_Underline_row"))).click();
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(2000);
	    	 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_header_font_colour_Myseries"))).getCssValue("text-decoration");
		    	System.out.println("Verified x as" + x);
		    	Thread.sleep(2000);
		    	if(x.contains("underline")){
		    		System.out.println("Verified");
		    	}else { 
		    		Assert.fail();
		    	}

		    	Thread.sleep(2000);
		    	CommonFunctionality.Views_list();
	    }
	    
	    
	    //TC_TV_216 
	    @And("^verify Edit Table Header horizontal alignment \\(left, right, center\\)$")
	    public void verify_Edit_Table_Header_horizontal_alignment_left_right_center() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_rowcoloumn_icon"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_alignment_row"))).click();
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(2000);
	    	 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_header_font_colour_Myseries"))).getCssValue("text-align");
		    	System.out.println("Verified x as" + x);
		    	Thread.sleep(2000);
		    	if(x.contains("center")){
		    		System.out.println("Verified");
		    	}else { 
		    		Assert.fail();
		    	}

		    	Thread.sleep(2000);
		    	CommonFunctionality.Views_list();
	    }
	    
	    
	    
	  //TC_TV_217
	    @And("^verify Edit Table Header column font color$")
	    public void verify_Edit_Table_Header_column_font_color() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_rowcoloumn_icon"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_headder_row_checkbox"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_font_colour_coloumn"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_font_colour_orange_coloumn"))).click();
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(2000);
	    	 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_header_font_colour_Myseries_coloumn"))).getCssValue("color");
		    	System.out.println("Verified x as" + x);
		    	Thread.sleep(2000);
		    	if(x.contains("rgba(255, 91, 77, 1)")){
		    		System.out.println("Verified");
		    	}else { 
		    		Assert.fail();
		    	}

		    	Thread.sleep(2000);
		    	CommonFunctionality.Views_list();
	    }
	    
	    
	    
	    //TC_TV_218
	    @And("^verify Edit Table Header column background color$")
	    public void verify_Edit_Table_Header_column_background_color() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_rowcoloumn_icon"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_headder_row_checkbox"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_background_colour_coloumn"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_background_colourorange_coloumn"))).click();
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(2000);
	    	 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_header_font_colour_Myseries_coloumn"))).getCssValue("background-color");
		    	System.out.println("Verified x as" + x);
		    	Thread.sleep(2000);
		    	if(x.contains("rgba(255, 91, 77, 1)")){
		    		System.out.println("Verified");
		    	}else { 
		    		Assert.fail();
		    	}

		    	Thread.sleep(2000);
		    	CommonFunctionality.Views_list();
	    }
	    
	    
	    
	    
	    
	    //TC_TV_219
	    @And("^verify Edit Table Header column  font size$")
	    public void verify_Edit_Table_Header_column_font_size() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_rowcoloumn_icon"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_headder_row_checkbox"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_pixel_coloumn"))).clear();
	    	String headersize = "10";
	    	int widthbefore = Integer.parseInt(headersize);
	    	Thread.sleep(2000);  
	    	Actions act = new Actions(login.driver);
	    	WebElement header = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_pixel_coloumn")));
	    	act.moveToElement(header).pause(5000).sendKeys(headersize);
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(2000);
	    	 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_header_font_colour_Myseries_coloumn"))).getCssValue("font-size");
	    		String wafter = x.replaceAll("\\D", "");
		    	int expectedwidth = Integer.parseInt(wafter);
		    	System.out.println("Border width" + expectedwidth);
		    	Thread.sleep(3000); 
		    	if(widthbefore == expectedwidth){
		    		System.out.println("Verified");
		    	}else {
		    		Assert.fail();
		    	}

		    	Thread.sleep(2000);
		    	CommonFunctionality.Views_list();
	    }
	    
	    
	    //TC_TV_220
	    @And("^verify Edit Table Header column bold style$")
	    public void verify_Edit_Table_Header_column_bold_style() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_rowcoloumn_icon"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_headder_row_checkbox"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_bold_row_coloumn"))).click();
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(2000);
	    	 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_header_font_colour_Myseries_coloumn"))).getCssValue("font-weight");
		    	System.out.println("Verified x as" + x);
		    	Thread.sleep(2000);
		    	if(x.contains("700")){
		    		System.out.println("Verified");
		    	}else { 
		    		Assert.fail();
		    	}

		    	Thread.sleep(2000);
		    	CommonFunctionality.Views_list();
	    }
	    
	    
	  //TC_TV_221
	    @And("^verify Edit Table Header column Italic style$")
	    public void verify_Edit_Table_Header_column_Italic_style() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_rowcoloumn_icon"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_headder_row_checkbox"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_Italic_row_coloumn"))).click();
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(2000);
	    	 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_header_font_colour_Myseries_coloumn"))).getCssValue("font-style");
		    	System.out.println("Verified x as" + x);
		    	Thread.sleep(2000);
		    	if(x.contains("italic")){
		    		System.out.println("Verified");
		    	}else { 
		    		Assert.fail();
		    	}

		    	Thread.sleep(2000);
		    	CommonFunctionality.Views_list();
	    }
	  //TC_TV_222
	    @And("^verify Edit Table Header column underlined\\. style$")
	    public void verify_Edit_Table_Header_column_underlined_style() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_rowcoloumn_icon"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_headder_row_checkbox"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_Underline_row_coloumn"))).click();
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(2000);
	    	 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_header_font_colour_Myseries_coloumn"))).getCssValue("text-decoration");
		    	System.out.println("Verified x as" + x);
		    	Thread.sleep(2000);
		    	if(x.contains("underline")){
		    		System.out.println("Verified");
		    	}else { 
		    		Assert.fail();
		    	}

		    	Thread.sleep(2000);
		    	CommonFunctionality.Views_list();
	    }
	  //TC_TV_223
	    @And("^verify Edit Table Header column horizontal alignment \\(left, right, center\\)$")
	    public void verify_Edit_Table_Header_column_horizontal_alignment_left_right_center() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_rowcoloumn_icon"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_headder_row_checkbox"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_alignment_coloumn"))).click();
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(2000);
	    	 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_header_font_colour_Myseries_coloumn"))).getCssValue("text-align");
		    	System.out.println("Verified x as" + x);
		    	Thread.sleep(2000);
		    	if(x.contains("center")){
		    		System.out.println("Verified");
		    	}else { 
		    		Assert.fail();
		    	}

		    	Thread.sleep(2000);
		    	CommonFunctionality.Views_list();
	    }
	    
	    
	  //TC_TV_224
	    @And("^verify Edit Table Copyright=Check$")
	    public void verify_Edit_Table_Copyright_Check() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	 boolean y =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_checkbox"))).isSelected();
	    	 System.out.println("Verified y as" + y);
	    	 Thread.sleep(2000);
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
		    	Thread.sleep(2000);
		   	 boolean x =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_source_myseries"))).isDisplayed();
		   	 System.out.println("Verified x as" + x);
		        if(x && y == true) {
		        	System.out.println("Verified");
		        }else { 
		    		Assert.fail();
		    	}

		    	Thread.sleep(2000);
		    	CommonFunctionality.Views_list();
		        
	    }
	    
	    //TC_TV_225
	    @And("^verify Edit Table Copyright=UnCheck$")
	    public void verify_Edit_Table_Copyright_UnCheck() throws Throwable {
	      
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright"))).click();
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	 boolean y =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_checkbox"))).isSelected();
	    	 System.out.println("Verified y as" + y);
	    	 Thread.sleep(2000);
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
		    	Thread.sleep(8000);
	       boolean x =login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_none"))).size()==0;
	       System.out.println("Verified x as" + x);
	       if(x ==false && y == false) {
		        	System.out.println("Verified");
		        }else { 
		    		Assert.fail();
		    	}

		    	Thread.sleep(2000);
		    	CommonFunctionality.Views_list();
		    	Thread.sleep(2000);
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
	    
	    }
	    
	  //TC_TV_226
	    @And("^verify Edit Table Copyright Vertical align$")
	    public void verify_Edit_Table_Copyright_Vertical_align() throws Throwable {
	        
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright"))).click();
	    	
	    	
	    	boolean x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright"))).isSelected();
	    	if( x == true) 
	    	{
	    		System.out.println("copy right is selected....");
			}
			else {
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright"))).click();
			}
	    	
	    	Thread.sleep(2000); 
	    	 WebElement copyrightsetting = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_dropdown")));
		        Actions etseting = new Actions(login.driver);
		        etseting.moveToElement(copyrightsetting).pause(5000).click().build().perform();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_top"))).click();
	    	 Thread.sleep(2000);
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
		    	 Thread.sleep(2000);
		    boolean y =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_top_myseries"))).isDisplayed();
		    System.out.println("Verified x as" + y);
		    	
		    if(y==true) {
	        	System.out.println("Verified");
	        }else { 
	    		Assert.fail();
	    	}

	    	Thread.sleep(2000);
	    	CommonFunctionality.Views_list();
	
		    	
	    }
	    
	  //TC_TV_227
	    @And("^verify Edit Table Copyright Vertical align for middle$")
	    public void verify_Edit_Table_Copyright_Vertical_align_for_middle() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_dropdown"))).click();
	    	Thread.sleep(2000);  
	    	if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_middle"))).size() != 0) 
			{
				System.out.println("Verified");
			} else 
			{
				Assert.fail();
			}
	    	
	    	
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
		    	Thread.sleep(2000);
		    	CommonFunctionality.Views_list();
	    }
	    
	    
	  //TC_TV_228 
	    @And("^verify Edit Table Copyright Horizontal align$")
	    public void verify_Edit_Table_Copyright_Horizontal_align() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_dropdown"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_horizontal_left"))).click();
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(2000);
	    	 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_none"))).getCssValue("text-align");
		    	System.out.println("Verified x as" + x);
		    	Thread.sleep(2000);
		    	if(x.contains("left")){
		    		System.out.println("Verified");
		    	}else { 
		    		Assert.fail();
		    	}

		    	Thread.sleep(2000);
		    	CommonFunctionality.Views_list();
	    	
	    	
	    }
	    //TC_TV_229 
	    @And("^verify Edit Table Copyright advance settings$")
	    public void verify_Edit_Table_Copyright_advance_settings() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_dropdown"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting"))).click();
	    	
	     	 boolean x =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_source_myseries"))).isDisplayed();
		        if(x  == true) {
		        	System.out.println("Verified");
		        }else { 
		    		Assert.fail();
		    	}
		    	Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("POP_title_close"))).click();
		        Thread.sleep(2000);
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
		    	Thread.sleep(2000);
		    	CommonFunctionality.Views_list();
	    	
	    }
	    
	    
	    
	    //TC_TV_230
	    @And("^verify Edit Table Copyright advance settings cogwheel$")
	    public void verify_Edit_Table_Copyright_advance_settings_cogwheel() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting_cogwheel"))).click();
	    	
	     	 boolean x =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_popup"))).isDisplayed();
		        if(x  == true) {
		        	System.out.println("Verified");
		        }else { 
		    		Assert.fail();
		    	}
		    	Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("POP_title_close"))).click();
		        Thread.sleep(2000);
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
		    	Thread.sleep(2000);
		    	CommonFunctionality.Views_list();
	    }
	    
	    
	    //TC_TV_231
	    @And("^verify Edit Table Copyright popup text=check$")
	    public void verify_Edit_Table_Copyright_popup_text_check() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_dropdown"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting"))).click();
	    	/*Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting_cogwheel"))).click();*/
	    	Thread.sleep(2000); 
	    	 boolean x =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_popup_checkbox"))).isSelected();
	    	 Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("POP_title_close"))).click();
		        Thread.sleep(2000);
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
		    	  Thread.sleep(3000);
		    	 boolean y =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_none"))).isDisplayed();
		    	 System.out.println("Verified x as" + x);
		    	 System.out.println("Verified y as" + y);
			        if(x  && y == true) {
			        	System.out.println("Verified");
			        }else { 
			    		Assert.fail();
			    	}
			    	Thread.sleep(2000);
			    	CommonFunctionality.Views_list();
		    	
	    	 
	    }
	    
	    
	    
	    
	    
	    //TC_TV_232
	    @And("^verify Edit Table Copyright popup default text for copyright$")
	    public void verify_Edit_Table_Copyright_popup_default_text_for_copyright() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_dropdown"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting"))).click();
	    	/*Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting_cogwheel"))).click();*/
	    	Thread.sleep(2000); 
	    	String x = "Source: CEIC Data";
	    	Thread.sleep(2000); 
	    	String y =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_default_textforcopyright"))).getAttribute("value");
	    	Thread.sleep(1000); 
	    	if(x.equalsIgnoreCase(y)) {
	    		System.out.println("Verified");
	    	}
	    	else {
	    		Assert.fail();
	    	}
	    	 Thread.sleep(2000);
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(2000);
	    	CommonFunctionality.Views_list();
	    }
	    
	    
	    //TC_TV_233
	    @And("^verify Edit Table Copyright popup text change for copyright$")
	    public void verify_Edit_Table_Copyright_popup_text_change_for_copyright() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_dropdown"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting"))).click();
	    	/*Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting_cogwheel"))).click();*/
	    	Thread.sleep(2000);
	    	  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_default_textforcopyright"))).clear();
	    	String x = "Testingcopyright";
	    	Thread.sleep(2000); 
	        login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_default_textforcopyright"))).sendKeys(x);
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(2000);
	    	String y =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_Changename"))).getText();
	    	Thread.sleep(1000);
	    	if(x.equalsIgnoreCase(y)) {
	    		System.out.println("Verified");
	    	}
	    	else {
	    		Assert.fail();
	    	}
	    	 
	    	Thread.sleep(2000);
	    	CommonFunctionality.Views_list();
	    	
	    	
	    }
	    
	    
	    //TC_TV_234
	    @And("^verify Edit Table Copyright popup link for copyright$")
	    public void verify_Edit_Table_Copyright_popup_link_for_copyright() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_dropdown"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting"))).click();
	    	/*Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting_cogwheel"))).click();*/
	    	
	    	String x = "https://www.ceicdata.com/en";
	    	Thread.sleep(2000); 
	    	String y =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_default_textforcopyright_link"))).getAttribute("value");
	    	Thread.sleep(1000); 
	    	if(x.equalsIgnoreCase(y)) {
	    		System.out.println("Verified");
	    	}
	    	else {
	    		Assert.fail();
	    	}
	    	 Thread.sleep(2000);
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
		    	
		    	Thread.sleep(2000);
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_none"))).click();
		    	
		    	 ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
				    login.driver.switchTo().window(tabs2.get(1));
				    Thread.sleep(2000);
					Assert.assertTrue(
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("copyright_link"))).isDisplayed());
			    	
					 login.driver.close();
					    login.driver.switchTo().window(tabs2.get(0));

	    	Thread.sleep(2000);
	    	CommonFunctionality.Views_list();
	    }
	    
	    
	    
	    //TC_TV_235 
	    @And("^verify Edit Table Copyright popup link color$")
		public void verify_Edit_Table_Copyright_popup_link_color() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	/*Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting_cogwheel"))).click();*/
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_dropdown"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_default_link_color"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_default_link_color_orange"))).click();
	    	 Thread.sleep(2000);
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
		    	Thread.sleep(2000);
		    	 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_none"))).getCssValue("color");
			    	System.out.println("Verified x as" + x);
			    	
			    	Thread.sleep(2000);

			    	if(x.contains("rgba(255, 91, 77, 1)")){
			    		System.out.println("Verified");
			    	}else { 
			    		Assert.fail();
			    	}

			    	Thread.sleep(2000);
			    	CommonFunctionality.Views_list();
			    	
		}
	    
	    
	    
	    //TC_TV_236 
	    @And("^verify Edit Table Copyright popup link font size$")
	    public void verify_Edit_Table_Copyright_popup_link_font_size() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_dropdown"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting"))).click();
	    	/*Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting_cogwheel"))).click();*/
	    	Thread.sleep(2000);  
	    	
	    	
	    	for(int i=0;i<=7;i++) {
	    		String x =login.driver.findElement(By.xpath("//div[@class='popover--title' and contains(text(),'Copyright')]/following::div[28]/preceding::input[1]"))
		    			.getAttribute("value");
	    		int y=Integer.parseInt(x);
	    		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_default_link_pixel"))).click();
	    		if(y==20) {
	    			break;
	    		}
	    	}
	    	 Thread.sleep(8000);
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
		    	 Thread.sleep(5000);
		    	 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_none"))).getCssValue("font-size");
			    	System.out.println("Verified x as" + x);
			    	
			    	Thread.sleep(2000);

			    	if(x.contains("20")){
			    		System.out.println("Verified");
			    	}else { 
			    		Assert.fail();
			    	}

			    	Thread.sleep(2000);
			    	CommonFunctionality.Views_list();
		
	    }
	    
	  //TC_TV_237
	    @And("^verify Edit Table Copyright popup link bold style$")
	    public void verify_Edit_Table_Copyright_popup_link_bold_style() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_dropdown"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting"))).click();
	    	/*Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting_cogwheel"))).click();*/
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_default_link_bold"))).click();
	    	 Thread.sleep(8000);
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
		    	 Thread.sleep(8000);
		    	 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_none"))).getCssValue("font-weight");
			    	System.out.println("Verified x as" + x);
			    	Thread.sleep(2000);

			    	if(x.contains("700")){
			    		System.out.println("Verified");
			    	}else { 
			    		Assert.fail();
			    	}

			    	Thread.sleep(2000);
			    	CommonFunctionality.Views_list();
	    	
	    }
	    //TC_TV_238
	    @And("^verify Edit Table Copyright popup link Italic style$")
	    public void verify_Edit_Table_Copyright_popup_link_Italic_style() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_dropdown"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting"))).click();
	    	/*Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting_cogwheel"))).click();*/
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_default_link_italic"))).click();
	    	 Thread.sleep(8000);
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
		    	 Thread.sleep(8000);
		    	 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_none"))).getCssValue("font-style");
			    	System.out.println("Verified x as" + x);
			    	Thread.sleep(2000);

			    	if(x.contains("italic")){
			    		System.out.println("Verified");
			    	}else { 
			    		Assert.fail();
			    	}

			    	Thread.sleep(2000);
			    	CommonFunctionality.Views_list();
	    }
	    //TC_TV_239
	    @And("^verify Edit Table Copyright popup link Underline style$")
	    public void verify_Edit_Table_Copyright_popup_link_Underline_style() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_dropdown"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting"))).click();
	    /*	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting_cogwheel"))).click();*/
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_default_link_underline"))).click();
	    	 Thread.sleep(8000);
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
		    	 Thread.sleep(8000);
		    	 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_none"))).getCssValue("text-decoration");
			    	System.out.println("Verified x as" + x);
			    	Thread.sleep(2000);

			    	if(x.contains("underline")){
			    		System.out.println("Verified");
			    	}else { 
			    		Assert.fail();
			    	}

			    	Thread.sleep(2000);
			    	CommonFunctionality.Views_list();
	    }

	    //TC_TV_240 
	    @And("^verify Edit Table Copyright popup link horizontal alignment \\(left, right, center\\)$")
	    public void verify_Edit_Table_Copyright_popup_link_horizontal_alignment_left_right_center() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_dropdown"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting"))).click();
	    /*	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting_cogwheel"))).click();*/
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_default_link_left"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	 Thread.sleep(5000);
	    	 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_none"))).getCssValue("text-align");
		    	System.out.println("Verified x as" + x);
		    	Thread.sleep(2000);

		    	if(x.contains("left")){
		    		System.out.println("Verified");
		    	}else { 
		    		Assert.fail();
		    	}

		    	Thread.sleep(2000);
		    	CommonFunctionality.Views_list();
	    	
	    	
	    }
	    


	    
	    //TC_TV_241 
	    @And("^verify Edit Table Copyright popup link vertical alignment \\(Top and bottom\\)$")
			public void verify_Edit_Table_Copyright_popup_link_vertical_alignment_Top_and_bottom() throws Throwable {
				CreateTable();
		    	Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
		    	Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_dropdown"))).click();
		    	Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting"))).click();
		    	/*Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting_cogwheel"))).click();*/
		    	Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_default_link_top"))).click();
		    	Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
		    	 Thread.sleep(5000);
			    	 boolean y =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_top_myseries"))).isDisplayed();
					    System.out.println("Verified x as" + y);
					    	
					    if(y==true) {
				        	System.out.println("Verified");
				        }else { 
				    		Assert.fail();
				    	}

				    	Thread.sleep(2000);
				    	CommonFunctionality.Views_list();
		    	
			}
	    
	    
	    
	    
	    
	    
	    //TC_TV_242
	    
	    @And("^verify Edit Table Copyright popup closing$")
			public void verify_Edit_Table_Copyright_popup_closing() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	/*Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting_cogwheel"))).click();*/
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_dropdown"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("POP_title_close"))).click();
	    	
	    	if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("POP_title_close"))).size() == 0) 
			{
				System.out.println("Verified");
			} else 
			{
				Assert.fail();
			}
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(2000);
			CommonFunctionality.Views_list();
	    	
	    	
			}
	    
	    
	    //TC_TV_243 
	    @And("^verify Edit Table Copyright popup expanding and collapsing the copyright sections$")
			public void verify_Edit_Table_Copyright_popup_expanding_and_collapsing_the_copyright_sections() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	/*Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting_cogwheel"))).click();*/
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_dropdown"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_expand"))).click();
	    	Thread.sleep(2000);
	    	 String y =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_colapse"))).getAttribute("class");
			    System.out.println("Verified x as" + y);
			    	
			    if(y.contains("collapse")) {
		        	System.out.println("Verified");
		        }else { 
		    		Assert.fail();
		    	}

			    Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
		    	Thread.sleep(2000);
				CommonFunctionality.Views_list();
	    	
	    	
			}
	    
	    
	    
	    //TC_TV_244
	    @And("^verify Edit Table dates$")
	    public void verify_Edit_Table_dates() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_date_format"))).isDisplayed());
	    	String x=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_date_format"))).getText();
	    	
	    	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY");
	    	   LocalDateTime now = LocalDateTime.now();
	    	  
	    	   System.out.println(dtf.format(now));
	    	  
	    	   
	    	   if( x.equalsIgnoreCase(dtf.format(now))){
	    		   System.out.println("Verified");
	    	   }
	    	   else {
	    		   Assert.fail();
	    	   }
	    	
	    	 Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
		    	Thread.sleep(2000);
				CommonFunctionality.Views_list();
	    	
	    }
	    
	    
	    
	    //TC_TV_245
	    @And("^verify Edit Table the list of date formats$")
	    public void verify_Edit_Table_the_list_of_date_formats() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_date_dropdown"))).click();
	    	Thread.sleep(2000);  
	    	Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_date_list"))).isDisplayed());
	    	System.out.println("Verified");
	    	 Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
		    	Thread.sleep(2000);
				CommonFunctionality.Views_list();
	    }
	    
	    
	    
	    //TC_TV_246
	    @And("^verify Edit Table Dates ascending order$")
			public void verify_Edit_Table_Dates_ascending_order() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  

	    	boolean x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_date_Ascending_checkbox"))).isSelected();

	    	if(x==true) {
	    		System.out.println("Ascending checkbox is selected");
	    	}
	    	else {
	    		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_date_Ascending"))).click();
	    	}

	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(8000);
	    	List<WebElement> Dates = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Edit_table_date_Ascending_dates")));
	    	ArrayList<Integer> ar = new ArrayList<Integer>();
	    	for(int i=0;i<Dates.size();i++) { 
	    		String GotDates = Dates.get(i).getText();
	    	//	String[] x1 =GotDates.split("/");
	    		int q = Integer.parseInt(GotDates);
	    	
	    		ar.add(q);
	    	}
	    		System.out.println("Ascending order are" +ar);
	    	
	    		boolean sorted = Ordering.natural().isOrdered(ar);
	    		if(sorted == true) {
	    			System.out.println("Verified");
	    		} else {
	    			Assert.fail();
	    		}

	    	
	    	Thread.sleep(2000);
			CommonFunctionality.Views_list();
	    	 
			}
	    
	    
	    
	    //TC_TV_247
	    @And("^verify Edit Table Dates descending order$")
		public void verify_Edit_Table_Dates_descending_order() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	boolean x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_date_Descending_checkbox"))).isSelected();

	    	if(x==true) {
	    		System.out.println("Descending checkbox is selected");
	    	}
	    	else {
	    		Thread.sleep(2000);
	    		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_date_Descending"))).click();
	    	}
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(8000);  
	    	List<WebElement> Dates = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Edit_table_date_Ascending_dates")));
	    	ArrayList<Integer> ar = new ArrayList<Integer>();
	    	
	    	try {
	    	
	    	for(int i=0;i<Dates.size();i++) { 
	    		String GotDates = Dates.get(i).getText();
	    		//String[] x1 =GotDates.split("/");
	    		int q = Integer.parseInt(GotDates);
	    		
	    		ar.add(q);
	    		
	    	}
	    	System.out.println("Descending order are" +ar);
	    	boolean sorted = Ordering.natural().reverse().isOrdered(ar);
	    		if(sorted == true) {
	    			System.out.println("Verified");
	    		} else {
	    			Assert.fail();
	    		

	    	}
	    	Thread.sleep(2000);
			CommonFunctionality.Views_list();
	    	}
	    	
	    	
	    	
	    	
	    	
	    	catch(StaleElementReferenceException e) {
	    		
	    		
	    		for(int i=0;i<Dates.size();i++) 
	    	{ 
	    			
		    		String GotDates = Dates.get(i).getText();
		    		String[] x1 =GotDates.split("/");
		    		int q = Integer.parseInt(x1[1]);
		    	
		    		ar.add(q);
		    		System.out.println("Descending order are" +ar);
	    	}
	    		
		    		boolean sorted = Ordering.natural().reverse().isOrdered(ar);
		    		if(sorted == true) {
		    			System.out.println("Verified");
		    		} else {
		    			Assert.fail();
		    		}

		    	
		    	Thread.sleep(2000);
				CommonFunctionality.Views_list();
		    	}
	    	}
	    	
	    	
	    	
	    	
	    //TC_TV_248
	    @And("^verify Edit Table Dates selection of date format$")
	    public void verify_Edit_Table_Dates_selection_of_date_format() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_date_dropdown"))).click();
	    	Thread.sleep(2000);  
	    	WebElement Edit_table_custom_radio = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_custom_radio")));
			 Actions border = new Actions(login.driver);
					 border.moveToElement(Edit_table_custom_radio).pause(5000).click().build().perform();
			 Thread.sleep(3000); 
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(8000);  
	    	String x=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_date_Ascending_dates"))).getText();
	    	int sizedate =x.length();
	    	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/YYYY");
	    	   LocalDateTime now = LocalDateTime.now();
	    	   int sizepattern =(dtf.format(now)).length(); 
	    	   if( sizedate == sizepattern){
	    		   System.out.println("Verified");
	    	   }
	    	   else {
	    		   Assert.fail();
	    	   }
		    	Thread.sleep(2000);
				CommonFunctionality.Views_list();
	    }
	    	
	    	
	    	
	    //TC_TV_249	
	    @And("^verify Edit Table Dates search$")
	    public void verify_Edit_Table_Dates_search() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_date_dropdown"))).click();
	    	Thread.sleep(2000);  
	    	WebElement Edit_table_custom_radio = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_custom_radio")));
	    	Actions custom_radio = new Actions(login.driver);
	    	custom_radio.moveToElement(Edit_table_custom_radio).pause(5000).click().build().perform();
	    	Thread.sleep(3000); 
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_custom_search"))).clear();
	    	WebElement Edit_table_custom_search = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_custom_search")));
	    	Actions custom_search = new Actions(login.driver);
	    	String searchdate = "MMM";
	    	int  sizepattern =searchdate.length();
	    	custom_search.moveToElement(Edit_table_custom_search).pause(5000).click().sendKeys(searchdate).build().perform();
	    	Thread.sleep(3000); 
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(8000);  

	    	String x=login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_date_Ascending_dates"))).getText();
	    	int sizedate =x.length();

	    	if( sizedate == sizepattern){
	    		System.out.println("Verified");
	    	}
	    	else {
	    		Assert.fail();
	    	}
	    	Thread.sleep(2000);
	    	CommonFunctionality.Views_list();
				 
	    }
	    
	    
	    
	    //TC_TV_250
	    @And("^verify Edit Table Dates invalid search$")
	    public void verify_Edit_Table_Dates_invalid_search() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_date_dropdown"))).click();
	    	Thread.sleep(2000);  
	    	WebElement Edit_table_custom_radio = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_custom_radio")));
	    	Actions custom_radio = new Actions(login.driver);
	    	custom_radio.moveToElement(Edit_table_custom_radio).pause(5000).click().build().perform();
	    	Thread.sleep(3000); 
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_custom_search"))).clear();
	    	WebElement Edit_table_custom_search = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_custom_search")));
	    	Actions custom_search = new Actions(login.driver);
	    	String searchdate = "MMMD";
	    	int  sizepattern =searchdate.length();
	    	custom_search.moveToElement(Edit_table_custom_search).pause(5000).click().sendKeys(searchdate).build().perform();
	    	Thread.sleep(3000); 
	    	Assert.assertTrue(
	    			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_custom_search_invalid"))).isDisplayed());
	    	System.out.println("Verified");
	    	Thread.sleep(3000); 
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(2000);
	    	CommonFunctionality.Views_list();
				 
	    }
	
	    
	    //TC_TV_251
	    @And("^verify Edit Table last observation$")
	    public void verify_Edit_Table_last_observation() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();

          
	    	for(int i=0;i<=21;i++) {
	    		String x =login.driver.findElement(By.xpath("//input[@class='form--control form--control__xs ui-spinner-input']"))
	    				.getAttribute("aria-valuenow");
	    	    int y=Integer.parseInt(x);
	    	    System.out.println("Verified y as in if" + y);
	    		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Lastobservation_button"))).click();
	    		if(y==5) {
	    			
	    			break;
	    		}
	    	}

	    	Thread.sleep(8000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(5000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	String x =login.driver.findElement(By.xpath("//input[@class='form--control form--control__xs ui-spinner-input']"))
	    			.getAttribute("value");
	    	int z=Integer.parseInt(x);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(5000);
	    	List<WebElement> Lastobservation = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Edit_table_date_Ascending_dates")));
	    	System.out.println("Verified x as" + Lastobservation.size());
	    	System.out.println("Verified y as" + z);
	    	Thread.sleep(2000);
	    	if(z ==Lastobservation.size()){
	    		System.out.println("Verified");
	    	}else { 
	    		Assert.fail();
	    	}

	    	Thread.sleep(2000);
	    	CommonFunctionality.Views_list();
	    }
	    
	    
	    
	    //TC_TV_252
	    @And("^verify Edit Table last observation default=(\\d+)$")
	    public void verify_Edit_Table_last_observation_default(int arg1) throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000); 
	    	String x =login.driver.findElement(By.xpath("//input[@class='form--control form--control__xs ui-spinner-input']"))
	    			.getAttribute("value");
	    	int z=Integer.parseInt(x);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(5000);
	    	List<WebElement> Lastobservation = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Edit_table_date_Ascending_dates")));
	    	System.out.println("Verified x as" + Lastobservation.size());
	    	if(z ==Lastobservation.size()){
	    		System.out.println("Verified");
	    	}else { 
	    		Assert.fail();
	    	}

	    	Thread.sleep(2000);
	    	CommonFunctionality.Views_list();
	    }
	    
	    
	    
	    //TC_TV_253
	    @And("^verify Edit Table Dates with in date range$")
	    public void verify_Edit_Table_Dates_with_in_date_range() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_within_range"))).click();
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_within_range_from"))).clear();
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_within_range_from"))).sendKeys("1995");
	    	
	    	
	    	
	    	WebElement Edit_table_date_active = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_date_active_95")));
	    	Actions table_date_active = new Actions(login.driver);
	    	table_date_active.moveToElement(Edit_table_date_active).pause(5000).click().build().perform();
	    	
	    	
	    
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_within_range_to"))).clear();
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_within_range_to"))).sendKeys("2000");

	    	WebElement Edit_table_date_active1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_date_active_20")));
	    	Actions table_date_active1 = new Actions(login.driver);
	    	table_date_active1.moveToElement(Edit_table_date_active1).pause(5000).click().build().perform();
	    	
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(5000);
	    	
	    	List<WebElement> Dates = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Edit_table_date_Ascending_dates")));
	    	
	    	boolean lastnumber=false;
	    	ArrayList<Integer> ar = new ArrayList<Integer>();
	    	for(int i=0;i<Dates.size();i++) { 
	    		String GotDates = Dates.get(i).getText();
	    		
	    		int q = Integer.parseInt(GotDates);
	    		ar.add(q);
	    		
	    		if(q<=2000) {
	    			lastnumber=true;
	    			System.out.println("Verified");
	    		}
	    	}
	    	if(lastnumber==false) {
	    		Assert.fail();
	    	}
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
	    
	    	Thread.sleep(2000);
	    	CommonFunctionality.Views_list();
	    	
	    }

	    
	    
	    //TC_TV_254
	    @And("^verify Edit Table Dates All observations$")
	    public void verify_Edit_Table_Dates_All_observations() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);
	    	List<WebElement> Datesbefore = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Edit_table_date_Ascending_dates")));
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_All_observation"))).click();
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(5000);
	    	List<WebElement> Datesafter = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Edit_table_date_Ascending_dates")));
	    	if(Datesbefore.size() != Datesafter.size()) {
	    		System.out.println("Verified");
	    	}else {
	    		Assert.fail();
	    	}
	    	Thread.sleep(2000);
	    	CommonFunctionality.Views_list();
	    	
	    }
	    
	
	    
	    
	    //TC_TV_255
	    @And("^verify Edit Table the selection of observations$")
	    public void verify_Edit_Table_the_selection_of_observations() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	
	    	boolean Lastobservation= login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_last_observation_input"))).isSelected();
	    	boolean Allobservation= login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_All_observation_input"))).isSelected();
	    	
	    	if(Lastobservation ==true && Allobservation==false) {
	    		System.out.println("Verified");
	    	}else {
	    		Assert.fail();
	    	}
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(2000);
	    	CommonFunctionality.Views_list();
	    }
	    
	    
	    
	    //TC_TV_256
	    @And("^verify Edit Table Value font color$")
	    public void verify_Edit_Table_Value_font_color() throws Throwable {
	        
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	    	WebElement element = login.driver.findElement(By.xpath("//*[text()='Filter out blanks']"));
	    	jse.executeScript("arguments[0].scrollIntoView(true);", element);

	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Value"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Value_colour"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Value_colour_orange"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(6000);  

	    	String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_value_myseries"))).getCssValue("color");
	    	Thread.sleep(2000);

	    	if(x.contains("rgba(255, 91, 77, 1)")){
	    		System.out.println("Verified");
	    	}else { 
	    		Assert.fail();
	    	}

	    	Thread.sleep(2000);
	    	CommonFunctionality.Views_list();
	    	
	    	
	    	
	    }
	    
	  //TC_TV_257
	    @And("^verify Edit Table Value font size$")
	    public void verify_Edit_Table_Value_font_size() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	    	WebElement element = login.driver.findElement(By.xpath("//*[text()='Filter out blanks']"));
	    	jse.executeScript("arguments[0].scrollIntoView(true);", element);

	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Value"))).click();
	    	
	    	Thread.sleep(2000);  

	    	for(int i=0;i<=7;i++) {
	    		String x =login.driver.findElement(By.xpath("(//input[@class='form--control form--control__xs ui-spinner-input'])[2]"))
	    				.getAttribute("aria-valuenow");
	    	    int y=Integer.parseInt(x);
	    	    System.out.println("Verified y as in if" + y);
	    		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_value_font_size_button"))).click();
	    		if(y==20) {
	    			
	    			break;
	    		}
	    	}

	    	Thread.sleep(8000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(5000);
	    	
	    	String z = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_value_myseries"))).getCssValue("font-size");
	    	System.out.println("Verified z as" + z);
	    	Thread.sleep(2000);

	    	if(z.contains("20")){
	    		System.out.println("Verified");
	    	}else { 
	    		Assert.fail();
	    	}
	    	
	    	Thread.sleep(2000);
	    	CommonFunctionality.Views_list();
	    }
	    
	    
	  //TC_TV_258 :bold
	    @And("^verify Edit Table Value font bold$")
	    public void verify_Edit_Table_Value_font_bold() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	    	WebElement element = login.driver.findElement(By.xpath("//*[text()='Filter out blanks']"));
	    	jse.executeScript("arguments[0].scrollIntoView(true);", element);
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Value"))).click();
	    	Thread.sleep(2000); 
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_value_font_size__bold"))).click();
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(6000);
	    	String z = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_value_myseries"))).getCssValue("font-weight");
	    	System.out.println("Verified z as" + z);
	    	Thread.sleep(2000);

	    	if(z.contains("bold") ||  z.contains ("700") ){
	    		System.out.println("Verified");
	    	}else { 
	    		Assert.fail();
	    	}
	    	
	    	Thread.sleep(2000);
	    	CommonFunctionality.Views_list();
	    	
	    }
	  //TC_TV_259
	    @And("^verify Edit Table Value font Italic$")
	    public void verify_Edit_Table_Value_font_Italic() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	    	WebElement element = login.driver.findElement(By.xpath("//*[text()='Filter out blanks']"));
	    	jse.executeScript("arguments[0].scrollIntoView(true);", element);
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Value"))).click();
	    	Thread.sleep(2000); 
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_value_font_size__Italic"))).click();
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(6000);
	    	String z = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_value_myseries"))).getCssValue("font-style");
	    	System.out.println("Verified z as" + z);
	    	Thread.sleep(2000);
	    	if(z.contains("italic") ){
	    		System.out.println("Verified");  
	    	}else { 
	    		Assert.fail();
	    	}
	    	
	    	Thread.sleep(2000);
	    	CommonFunctionality.Views_list();
	
	    	
	    }
	    
	  //TC_TV_260 
	    @And("^verify Edit Table Value font Underline\\.$")
	    public void verify_Edit_Table_Value_font_Underline() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	    	WebElement element = login.driver.findElement(By.xpath("//*[text()='Filter out blanks']"));
	    	jse.executeScript("arguments[0].scrollIntoView(true);", element);
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Value"))).click();
	    	Thread.sleep(2000); 
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_value_font_size__Underline"))).click();
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(6000);
	    	String z = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_value_myseries"))).getCssValue("text-decoration");
	    	System.out.println("Verified z as" + z);
	    	Thread.sleep(2000);
	    	if(z.contains("underline") ){
	    		System.out.println("Verified");  
	    	}else { 
	    		Assert.fail();
	    	}
	    	
	    	Thread.sleep(2000);
	    	CommonFunctionality.Views_list();
	 
	    	
	    }
	    
	    //TC_TV_261
	    @And("^verify Edit Table Value font horizontal alignment \\(left, right, center\\)$")
	    public void verify_Edit_Table_Value_font_horizontal_alignment_left_right_center() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	    	WebElement element = login.driver.findElement(By.xpath("//*[text()='Filter out blanks']"));
	    	jse.executeScript("arguments[0].scrollIntoView(true);", element);
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Value"))).click();
	    	Thread.sleep(2000); 
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_value_font_right"))).click();
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(6000);
	    	
	    	String z = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_value_myseries"))).getCssValue("text-align");
	    	System.out.println("Verified z as" + z);
	    	Thread.sleep(2000);
	    	if(z.contains("right") ){
	    		System.out.println("Verified");  
	    	}else { 
	    		Assert.fail();
	    	}
	    	
	    	Thread.sleep(2000);
	    	CommonFunctionality.Views_list();
	    	
	    	
	    }
	    
	    
	    //TC_TV_262
	    @And("^verify Edit Table Value Blank observations -default selection as \"([^\"]*)\"$")
	    public void verify_Edit_Table_Value_Blank_observations_default_selection_as(String arg1) throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	    	WebElement element = login.driver.findElement(By.xpath("//*[text()='Filter out blanks']"));
	    	jse.executeScript("arguments[0].scrollIntoView(true);", element);
	    	Thread.sleep(2000);
	    	String x = login.driver.findElement(By.xpath("//*[text()='Filter out blanks']")).getText();
	    	if(x.equalsIgnoreCase(arg1)) {
	    		System.out.println("Verified");  
	    	}else { 
	    		Assert.fail();
	    	}

	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(2000);
	    	CommonFunctionality.Views_list();

	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	 
	    
	    //TC_TV_263
	    @And("^verify Edit Table Value Blank observations -Filter out blanks$")
	    public void verify_Edit_Table_Value_Blank_observations_Filter_out_blanks() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	    	WebElement element = login.driver.findElement(By.xpath("//*[text()='Filter out blanks']"));
	    	jse.executeScript("arguments[0].scrollIntoView(true);", element);
	    	Thread.sleep(2000);
	    	
	    	
	    	
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(6000);
	    	List<WebElement> Dates = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Edit_table_date_Ascending_dates")));
	    	
	    	Boolean lastnumber=true;
	    	ArrayList<Integer> ar = new ArrayList<Integer>();
	    	for(int i=0;i<Dates.size();i++) { 
	    		String GotDates = Dates.get(i).getText();
	    		
	    		int q = Integer.parseInt(GotDates);
	    		ar.add(q);
	    		if(q==1998) {
	    			lastnumber=false;
	    			Assert.fail();
	    			break;
	    			
	    			
	    		}
	    	}
	    	if(lastnumber.equals(true)) {
	    		System.out.println("Verified lastnumber as " + lastnumber);
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
	    
	    	Thread.sleep(2000);
	    	CommonFunctionality.Views_list();
	    	}
	    	
	    }
	    
	    
	  //TC_TV_264
	    @And("^verify Edit Table Value Blank observations -Leave as blanks$")
	    public void verify_Edit_Table_Value_Blank_observations_Leave_as_blanks() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	    	WebElement element = login.driver.findElement(By.xpath("//*[text()='Filter out blanks']"));
	    	jse.executeScript("arguments[0].scrollIntoView(true);", element);
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath("//*[text()='Filter out blanks']")).click();
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_lastobservation_leaveasblank"))).click();
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	
	    	Thread.sleep(6000);
	    	List<WebElement> Dates = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Edit_table_value_myseries")));
	    	
	    	Boolean lastnumber=false;
	    	ArrayList<Integer> ar = new ArrayList<Integer>();
	    	for(int i=0;i<Dates.size();i++) { 
	    		String GotDates = Dates.get(i).getText();
	    		System.out.println("Q will be as " + GotDates);
	    		if(GotDates.isEmpty()) {
	    			lastnumber=true;
	    			Thread.sleep(2000);
	    	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
	    	    	Thread.sleep(2000);
	    	    	CommonFunctionality.Views_list();
	                 break;
	    			
	    			
	    		}
	    	}
	    	if(lastnumber.equals(false)) {
	    		Assert.fail();
	    	}
	
	    }
	
	    
	    
	    
	    
	    //TC_TV_265 
	    @And("^verify Edit Table Value Blank observations -Fill with N/A$")
	    public void verify_Edit_Table_Value_Blank_observations_Fill_with_N_A() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	    	WebElement element = login.driver.findElement(By.xpath("//*[text()='Filter out blanks']"));
	    	jse.executeScript("arguments[0].scrollIntoView(true);", element);
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath("//*[text()='Filter out blanks']")).click();
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_lastobservation_FillwithN/A"))).click();
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	
	    	Thread.sleep(6000);
	    	List<WebElement> Dates = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Edit_table_value_myseries")));
	    	Boolean lastnumber=false;
	    	ArrayList<Integer> ar = new ArrayList<Integer>();
	    	for(int i=0;i<Dates.size();i++) { 
	    		String GotDates = Dates.get(i).getText();
	    		System.out.println("Q will be as " + GotDates);
	    		if(GotDates.contains("N/A")) {
	    			lastnumber=true;
	    			Thread.sleep(2000);
	    	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
	    	    	Thread.sleep(2000);
	    	    	CommonFunctionality.Views_list();
	                 break;
	    			
	    			
	    		}
	    	}
	    	if(lastnumber.equals(false)) {
	    		Assert.fail();
	    	}
	    }

	  
	    
	    
	    
	    
	    //TC_TV_266
	    @And("^verify Edit Table Value Blank observations -Fill with dot$")
	    public void verify_Edit_Table_Value_Blank_observations_Fill_with_dot() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	    	WebElement element = login.driver.findElement(By.xpath("//*[text()='Filter out blanks']"));
	    	jse.executeScript("arguments[0].scrollIntoView(true);", element);
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath("//*[text()='Filter out blanks']")).click();
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_lastobservation_Fillwithdot"))).click();
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	
	    	Thread.sleep(6000);
	    	List<WebElement> Dates = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Edit_table_value_myseries")));
	    	Boolean lastnumber=false;
	    	ArrayList<Integer> ar = new ArrayList<Integer>();
	    	for(int i=0;i<Dates.size();i++) { 
	    		String GotDates = Dates.get(i).getText();
	    		System.out.println("Q will be as " + GotDates);
	    		if(GotDates.contains(".")) {
	    			lastnumber=true;
	    			Thread.sleep(2000);
	    	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
	    	    	Thread.sleep(2000);
	    	    	CommonFunctionality.Views_list();
	                 break;
	    			
	    			
	    		}
	    	}
	    	if(lastnumber.equals(false)) {
	    		Assert.fail();
	    	}
	    }
	    //TC_TV_267
	    @And("^verify Edit Table Value Blank observations -Fill with hyphen$")
	    public void verify_Edit_Table_Value_Blank_observations_Fill_with_hyphen() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	    	WebElement element = login.driver.findElement(By.xpath("//*[text()='Filter out blanks']"));
	    	jse.executeScript("arguments[0].scrollIntoView(true);", element);
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath("//*[text()='Filter out blanks']")).click();
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_lastobservation_Fillwithhyphen"))).click();
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	
	    	Thread.sleep(6000);
	    	List<WebElement> Dates = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Edit_table_value_myseries")));
	    	Boolean lastnumber=false;
	    	ArrayList<Integer> ar = new ArrayList<Integer>();
	    	for(int i=0;i<Dates.size();i++) { 
	    		String GotDates = Dates.get(i).getText();
	    		System.out.println("Q will be as " + GotDates);
	    		if(GotDates.contains("-")) {
	    			lastnumber=true;
	    			Thread.sleep(2000);
	    	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
	    	    	Thread.sleep(2000);
	    	    	CommonFunctionality.Views_list();
	                 break;
	    			
	    			
	    		}
	    	}
	    	if(lastnumber.equals(false)) {
	    		Assert.fail();
	    	}
	    }
	    
	    
	    
	    //TC_TV_268 
	    @And("^verify Edit Table Number format Decimal places$")
	    public void verify_Edit_Table_Number_format_Decimal_places() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Numberformat_dropdown"))).click();
	    	int y=0;
	    	Thread.sleep(2000);  
	    	for(int i=0;i<=1;i++) {

	    		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Numberformat_button"))).click();
	    		String x =login.driver.findElement(By.xpath("(//input[@class='form--control form--control__xs ui-spinner-input'])[2]"))
	    				.getAttribute("aria-valuenow");
	    		y=Integer.parseInt(x);
	    		System.out.println("Verified y as in if" + y);
	    		if(y==4) {

	    			break;
	    		}
	    	}
	    	Thread.sleep(8000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(5000);
	    	String z = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_firstvalue_myseries"))).getText();
	    	int q =z.substring(z.lastIndexOf(".") + 1).length();
	    	Thread.sleep(2000);
	    	if(q==y){
	    		System.out.println("Verified");
	    	}else { 
	    		Assert.fail();
	    	}
	    	Thread.sleep(2000);
	    	CommonFunctionality.Views_list();

	    }
	    
	    
	    
	    //TC_TV_269
	    @And("^verify Edit Table Number default Decimal places as \"([^\"]*)\"$")
	    public void verify_Edit_Table_Number_default_Decimal_places_as(String arg1) throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Numberformat_dropdown"))).click();
	    
	    		String x =login.driver.findElement(By.xpath("(//input[@class='form--control form--control__xs ui-spinner-input'])[2]"))
	    				.getAttribute("value");
	    		Thread.sleep(2000);
	    		if(x.equalsIgnoreCase(arg1)) {
	    			System.out.println("Verified");
	    		}else { 
		    		Assert.fail();
		    	}
	    		Thread.sleep(8000);
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    		Thread.sleep(2000);
		    	CommonFunctionality.Views_list();

	    	
	    }
	    //TC_TV_270
	    @And("^verify Edit Table Number default Decimal separator as comma$")
	    public void verify_Edit_Table_Number_default_Decimal_separator_as_comma() throws Throwable {
	    	CreateTable();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Numberformat_dropdown"))).click();
	    	Thread.sleep(2000);  
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Numberformat_decimal_comma"))).click();
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	    	Thread.sleep(8000);
	    	String x =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_firstvalue_myseries"))).getText();
	    	char comma = x.charAt(5);
	    	String s = String.valueOf(comma);
	    	if(s.contains(",")) {
	    		System.out.println("Verified");
	    	}
	    	else {
	    		Assert.fail();
	    	}
	    
	    	
	    	Thread.sleep(2000);
	    	CommonFunctionality.Views_list();
	    	Thread.sleep(2000);
	    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
	    }
	    
	    
	    
	    //TC_TV_271
	    @And("^verify Edit Table Number default Decimal Grouping separator$")
			public void verify_Edit_Table_Number_default_Decimal_Grouping_separator() throws Throwable {
				CreateTable();
		    	Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
		    	Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Numberformat_dropdown"))).click();
		    	Thread.sleep(2000); 
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Numberformat_decimal_grouping"))).click();
		    	Thread.sleep(2000);
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
		    	Thread.sleep(8000);
		    	String x =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_firstvalue_myseries"))).getText();
		    	char comma = x.charAt(1);
		    	String s = String.valueOf(comma);
		    	if(s.contains("-")) {
		    		System.out.println("Verified");
		    	}
		    	else {
		    		Assert.fail();
		    	}
		    
		    	
		    	Thread.sleep(2000);
		    	CommonFunctionality.Views_list();
		    	Thread.sleep(2000);
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
			}
	    
	    
	    
	
			 //TC_TV_272
			@And("^verify Edit Table horizontal scroll bar for settings sections$")
			public void verify_Edit_Table_horizontal_scroll_bar_for_settings_sections() throws Throwable {
				CreateTable();
		    	Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
		       	JavascriptExecutor jse = (JavascriptExecutor) login.driver;
		    	WebElement element = login.driver.findElement(By.xpath("//*[text()='Filter out blanks']/following::span[1]"));
		    	jse.executeScript("arguments[0].scrollIntoView(true);", element);
		    	
		    	boolean x =login.driver.findElement(By.xpath("//*[text()='Filter out blanks']/following::span[1]")).isDisplayed();
			
		    	if(x==true) {
				System.out.println("Verified scrollBarPresent" + x);
		    	}else {
		    		Assert.fail();
		    	}
				Thread.sleep(2000);
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
		    	Thread.sleep(2000);
		    	CommonFunctionality.Views_list();
			
				
			}
	    
	    
	    
			 //TC_TV_273
			@And("^verify Edit Table the changes reflected in edit visual$")
			public void verify_Edit_Table_the_changes_reflected_in_edit_visual() throws Throwable {
				CreateTable();
		    	Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
		    	Thread.sleep(2000);  
		    	
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_cogwheel_title"))).click();
		    	Thread.sleep(2000); 
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_cogwheel_title_colour"))).click();
		    	Thread.sleep(2000); 
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_cogwheel_title_colour_orange"))).click();
		    	Thread.sleep(2000); 
		    	String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_changes_reflected_in_edit_visual"))).getCssValue("color");
		    	System.out.println("Verified " + x);
		    
		    	 if(x.contains("rgba(255, 91, 77, 1)")){
					 System.out.println("Verified");
				 }else { 
					 Assert.fail();
				 }
		    	
		    	Thread.sleep(2000);
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
		    	Thread.sleep(2000);
		    	CommonFunctionality.Views_list();
	
		    	
			}
	    
			 //TC_TV_274
			@And("^verify Edit Table title icon on visual$")
			public void verify_Edit_Table_title_icon_on_visual() throws Throwable {
				CreateTable();
		    	Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
		    	Thread.sleep(2000); 
		    	Actions action = new Actions(login.driver);
				WebElement EditTabletitleicon =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_changes_reflected_in_edit_visual")));
				action.moveToElement(EditTabletitleicon).build().perform();
				Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_title_edit_icon"))).click();
		    	Thread.sleep(2000); 
		    	Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_title_edit_icon_popup"))).isDisplayed());
				  System.out.println("Verified");
				  Thread.sleep(2000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
					Thread.sleep(2000);
					CommonFunctionality.Views_list();
			}
			
			 //TC_TV_275
			@And("^verify Edit Table titles popup open by double click on visual title$")
			public void verify_Edit_Table_titles_popup_open_by_double_click_on_visual_title() throws Throwable {
				CreateTable();
		    	Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
		    	Thread.sleep(2000); 
		    	Actions action = new Actions(login.driver);
				WebElement EditTabletitleicon =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_changes_reflected_in_edit_visual")));
				action.moveToElement(EditTabletitleicon).click().build().perform();
		    	Thread.sleep(2000); 
		    	Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_title_edit_icon_popup"))).isDisplayed());
				  System.out.println("Verified");
				  Thread.sleep(2000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
					Thread.sleep(2000);
					CommonFunctionality.Views_list();
			}
			
			 //TC_TV_276
			@And("^verify Edit Table double click on attribute area$")
			public void verify_Edit_Table_double_click_on_attribute_area() throws Throwable {
				CreateTable();
		    	Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				Actions action = new Actions(login.driver);
				WebElement Sereiesnameintable =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_Name_attribute_inside")));
				action.moveToElement(Sereiesnameintable).doubleClick().build().perform();
				Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_attribute_popup_inside"))).isDisplayed());
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			
			
			 //TC_TV_277
			@And("^verify Edit Table double click on date field$")
			public void verify_Edit_Table_double_click_on_date_field() throws Throwable {
				CreateTable();
		    	Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				Actions action = new Actions(login.driver);
				WebElement Sereiesnameintable =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_date_inside")));
				action.moveToElement(Sereiesnameintable).doubleClick().build().perform();
				Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_date_popup_inside"))).isDisplayed());
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			
			
			
			 //TC_TV_278
			@And("^verify Edit Table double click on timepoints$")
			public void verify_Edit_Table_double_click_on_timepoints() throws Throwable {
				CreateTable();
		    	Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				Actions action = new Actions(login.driver);
				WebElement Sereiesnameintable =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_number_inside")));
				action.moveToElement(Sereiesnameintable).doubleClick().build().perform();
				Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_number_popup_inside"))).isDisplayed());
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			
			 //TC_TV_279
			@And("^verify Edit Table removing attributes by clicking x icon$")
			public void verify_Edit_Table_removing_attributes_by_clicking_x_icon() throws Throwable {
				CreateTable();
		    	Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
		    	Thread.sleep(6000);
		    	List<WebElement> attribute = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_attribute_list_inside")));
		    	int attributebefore = attribute.size();
		    	Actions action = new Actions(login.driver);
				WebElement Sereiesnameintable =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_Name_attribute_inside")));
				action.moveToElement(Sereiesnameintable).build().perform();
		    	Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_Name_remove_attribute"))).click();
		    
		    	Thread.sleep(6000);
		    	List<WebElement> attributeafter = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_attribute_list_inside")));
		    	int attributeaftersize = attributeafter.size();
		    	 if (attributeaftersize != attributebefore) 
		 		{
		 			System.out.println("Verified");
		 		} else 
		 		{
		 			Assert.fail();
		 		}
		    	
		    	Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			
			
			
			 //TC_TV_280
			@And("^verify Edit Table clicking on series name$")
			public void verify_Edit_Table_clicking_on_series_name() throws Throwable {
				CreateTable();
		    	Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
		    	Thread.sleep(2000);
		    	
		    	Actions action = new Actions(login.driver);
				WebElement Sereiesnameintable =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_attribute_inside")));
				action.moveToElement(Sereiesnameintable).click().build().perform();
		    	Thread.sleep(2000);  
		    	Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Dialogue"))).isDisplayed());
				  System.out.println("verified clicking on series name");
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Dialogue_X_Icon"))).click();
				  Thread.sleep(2000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
		    	 Thread.sleep(2000);
					CommonFunctionality.Views_list();
			}
			
			 //TC_TV_281
			@And("^verify Edit Table series on visuale inside Edit tabel popup$")
			public void verify_Edit_Table_series_on_visuale_inside_Edit_tabel_popup() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				Actions action = new Actions(login.driver);
				WebDriverWait wait = new WebDriverWait(login.driver,30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='series-edit--title'])[2]")));
				WebElement Sereiesnameintable =login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[2]"));
				action.moveToElement(Sereiesnameintable).build().perform();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_cogwheel_inside"))).click();
				String[] exp = {"Rename","Frequency","Change"};
				 List<WebElement> options = login.driver.findElements(By.xpath("//ul[@class='dropdown-menu context-menu edit-series--context-menu']/div[3]/li"));
				 for(WebElement we:options)  
				 {  
				  boolean match = false;
				  for (int j=0; j<exp.length; j++)
				  {
					  String X= we.getText();
				      if (X.equals(exp[j])){
				    	  System.out.println(X + exp[j] );
				        match = true;
				        System.out.println("DropDown is verified successfully");
				      }
				    }
				  //Assert.assertTrue(match);
				  if(match = false){
					  Assert.fail();
				  }
				 }
				 Thread.sleep(2000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
				 Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			
			 //TC_TV_282
			@And("^verify Edit Table Rename option from cogwheel icon inside Edit tabel popup$")
			public void verify_Edit_Table_Rename_option_from_cogwheel_icon_inside_Edit_tabel_popup() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				Actions action = new Actions(login.driver);
				WebDriverWait wait = new WebDriverWait(login.driver,30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='series-edit--title'])[2]")));
				WebElement Sereiesnameintable =login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[2]"));
				action.moveToElement(Sereiesnameintable).build().perform();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_cogwheel_inside"))).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_cogwheel_inside_rename"))).click();
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_popup"))).isDisplayed());
				  System.out.println("verified clicking on series name");
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_cogwheel_inside_renameclose"))).click();
				  Thread.sleep(2000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
		    	 Thread.sleep(2000);
					CommonFunctionality.Views_list();
			}
			
			
			
			
			 //TC_TV_283
			@And("^verify Edit Table Frequency option from cogwheel icon inside Edit tabel popup$")
			public void verify_Edit_Table_Frequency_option_from_cogwheel_icon_inside_Edit_tabel_popup() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				Actions action = new Actions(login.driver);
				WebDriverWait wait = new WebDriverWait(login.driver,30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='series-edit--title'])[2]")));
				WebElement Sereiesnameintable =login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[2]"));
				action.moveToElement(Sereiesnameintable).build().perform();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_cogwheel_inside"))).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Frquency_Series_TV"))).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Frequency_replicate"))).click();
				
				
				
				
				Actions action1 = new Actions(login.driver);
				WebDriverWait wait1 = new WebDriverWait(login.driver,30);
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='series-edit--title'])[2]")));
				WebElement Sereiesnameintable1 =login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[2]"));
				action1.moveToElement(Sereiesnameintable1).build().perform();
				
				Thread.sleep(2000);
				String FunctionApplied = login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[2]")).getText();
				System.out.println(FunctionApplied);
				
				if(FunctionApplied.contains("DISAGGREGATE(Weekly; Sunday; Replicate)")){
					System.out.println("Verified Successfully");
				}
				else{
					Assert.fail();
				}
				  Thread.sleep(2000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
				
				
			}
			
			 //TC_TV_284
			@And("^verify Edit Table Currency option from cogwheel icon inside Edit tabel popup$")
			public void verify_Edit_Table_Currency_option_from_cogwheel_icon_inside_Edit_tabel_popup() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				Actions action = new Actions(login.driver);
				WebDriverWait wait = new WebDriverWait(login.driver,30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='series-edit--title'])[2]")));
				WebElement Sereiesnameintable =login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[2]"));
				action.moveToElement(Sereiesnameintable).build().perform();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_cogwheel_inside"))).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Currency_Series_TV"))).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Currency_RUB"))).click();
				
				
				
				
				Actions action1 = new Actions(login.driver);
				WebDriverWait wait1 = new WebDriverWait(login.driver,30);
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='series-edit--title'])[2]")));
				WebElement Sereiesnameintable1 =login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[2]"));
				action1.moveToElement(Sereiesnameintable1).build().perform();
				
				Thread.sleep(2000);
				String FunctionApplied = login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[2]")).getText();
				System.out.println(FunctionApplied);
				
				if(FunctionApplied.contains("(Russian Ruble; as reported)")){
					System.out.println("Verified Successfully");
				}
				else{
					Assert.fail();
				}
				  Thread.sleep(2000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
					Thread.sleep(2000);
			    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
			    
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
				
			}
			
			 //TC_TV_285
			@And("^verify Edit Table Change option from cogwheel icon inside Edit tabel popup$")
			public void verify_Edit_Table_Change_option_from_cogwheel_icon_inside_Edit_tabel_popup() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				Actions action = new Actions(login.driver);
				WebDriverWait wait = new WebDriverWait(login.driver,30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='series-edit--title'])[2]")));
				WebElement Sereiesnameintable =login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[2]"));
				action.moveToElement(Sereiesnameintable).build().perform();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_cogwheel_inside"))).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Change_Series_TV"))).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Change_pop"))).click();
				
				Actions action1 = new Actions(login.driver);
				WebDriverWait wait1 = new WebDriverWait(login.driver,30);
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='series-edit--title'])[2]")));
				WebElement Sereiesnameintable1 =login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[2]"));
				action1.moveToElement(Sereiesnameintable1).build().perform();
				
				Thread.sleep(2000);
				String FunctionApplied = login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[2]")).getText();
				System.out.println(FunctionApplied);

				if(FunctionApplied.contains("%CHANGE(Over Period; 1; Yes)")){
					System.out.println("Verified Successfully");
				}
				else{
					Assert.fail();
				}
				
				  Thread.sleep(2000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
					Thread.sleep(2000);
			    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
			    
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			
			 //TC_TV_286
			@And("^verify Edit Table tooltip for series inside Edit tabel popup$")
			public void verify_Edit_Table_tooltip_for_series_inside_Edit_tabel_popup() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				Actions action = new Actions(login.driver);
				WebDriverWait wait = new WebDriverWait(login.driver,30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='series-edit--title'])[2]")));
				WebElement Sereiesnameintable =login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[2]"));
				action.moveToElement(Sereiesnameintable).build().perform();
				Thread.sleep(500);
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text"))).isDisplayed());
				System.out.println("Verified Successfully");
				  Thread.sleep(2000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
				
			}
			
			
			//TC_TV_287
			@And("^verify Edit Table scroll down till end of timepoints inside Edit tabel popup$")
			public void verify_Edit_Table_scroll_down_till_end_of_timepoints_inside_Edit_tabel_popup() throws Throwable {
				
				CreateTable();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();	
				JavascriptExecutor js = (JavascriptExecutor)login.driver; 
				WebElement element = login.driver.findElement(By.xpath("(//div[@class='table-element visual-select-area']/div)[2]/table/tbody/tr[1]"));
				js.executeScript("arguments[0].scrollIntoView(true);", element);			
				JavascriptExecutor js1 = (JavascriptExecutor)login.driver; 
				WebElement element1 = login.driver.findElement(By.xpath("(//div[@class='table-element visual-select-area']/div)[2]/table/tbody/tr[5]"));
				js1.executeScript("arguments[0].scrollIntoView(true);", element1);
				JavascriptExecutor js2 = (JavascriptExecutor)login.driver; 
				WebElement element2 = login.driver.findElement(By.xpath("(//div[@class='table-element visual-select-area']/div)[2]/table/tbody/tr[10]"));
				js2.executeScript("arguments[0].scrollIntoView(true);", element1);
				JavascriptExecutor js3 = (JavascriptExecutor)login.driver; 
				WebElement element3 = login.driver.findElement(By.xpath("(//div[@class='table-element visual-select-area']/div)[2]/table/tbody/tr[15]"));
				js3.executeScript("arguments[0].scrollIntoView(true);", element3);
				JavascriptExecutor js4 = (JavascriptExecutor)login.driver; 
				WebElement element4 = login.driver.findElement(By.xpath("(//div[@class='table-element visual-select-area']/div)[2]/table/tbody/tr[20]"));
				js4.executeScript("arguments[0].scrollIntoView(true);", element4);
				JavascriptExecutor js5 = (JavascriptExecutor)login.driver; 
				WebElement element5 = login.driver.findElement(By.xpath("(//div[@class='table-element visual-select-area']/div)[2]/table/tbody/tr[23]"));
				js5.executeScript("arguments[0].scrollIntoView(true);", element5);
				Thread.sleep(500);
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_CEICImage_inside"))).isDisplayed());
				System.out.println("Verified Successfully");
				  Thread.sleep(2000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
					Thread.sleep(2000);
			    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
				
				
			}
			
			
			
			
			
			//TC_TV_288
			@And("^verify Edit Table  horizontal scroll inside Edit tabel popup$")
			public void verify_Edit_Table_horizontal_scroll_inside_Edit_tabel_popup() throws Throwable {
				verify_Edit_Table_scroll_down_till_end_of_timepoints_inside_Edit_tabel_popup ();
			}
			
			
			//TC_TV_289
			@And("^verify Edit Table selecting another visual from visual panel inside Edit tabel popup$")
			public void verify_Edit_Table_selecting_another_visual_from_visual_panel_inside_Edit_tabel_popup() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_anothervisual_inside"))).click();
				
				Thread.sleep(500);
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_anothervisualchart_inside"))).isDisplayed());
				System.out.println("Verified Successfully");
				  Thread.sleep(2000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
					 Thread.sleep(2000);
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).click();
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
				
				
				
				
			}
			//TC_TV_290
			@And("^verify Edit Table selecting another visual from visual dropdown inside Edit tabel popup$")
			public void verify_Edit_Table_selecting_another_visual_from_visual_dropdown_inside_Edit_tabel_popup() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_anothervisual_inside"))).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_anothervisualdropdown_inside"))).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_anothervisualdropdown_pie_inside"))).click();
				Thread.sleep(500);
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_anothervisual_pie_inside"))).isDisplayed());
				System.out.println("Verified Successfully");
				  Thread.sleep(2000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
					  Thread.sleep(2000);
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).click();
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			
			
			
			//TC_TV_291
			@And("^verify Edit Table delete series icon inside Edit tabel popup$")
			public void verify_Edit_Table_delete_series_icon_inside_Edit_tabel_popup() throws Throwable {
				CreateTable();
		    	Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
		    	Thread.sleep(6000);
		    	
		    	Actions action = new Actions(login.driver);
				WebDriverWait wait = new WebDriverWait(login.driver,30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='remove-item-control'])[1]")));
				WebElement Sereiesnameintable =login.driver.findElement(By.xpath("(//*[@class='remove-item-control'])[1]"));
				action.moveToElement(Sereiesnameintable).build().perform();
		    	Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_remove_inside_deleteseries"))).click();
		    	Thread.sleep(500);
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_table_removed_inside"))).isDisplayed());
				System.out.println("Verified Successfully");
				  Thread.sleep(2000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
					  Thread.sleep(2000);
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).click();
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			
			//TC_TV_292
			@And("^verify Edit Table delete all series icon inside Edit tabel popup$")
			public void verify_Edit_Table_delete_all_series_icon_inside_Edit_tabel_popup() throws Throwable {
				CreateTable();
		    	Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
		    	Thread.sleep(6000);
		    	
		    	Actions action = new Actions(login.driver);
				WebDriverWait wait = new WebDriverWait(login.driver,30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='remove-item-control'])[2]")));
				WebElement Sereiesnameintable =login.driver.findElement(By.xpath("(//*[@class='remove-item-control'])[2]"));
				action.moveToElement(Sereiesnameintable).build().perform();
		    	Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_remove_inside_deleteallseries"))).click();
		    	Thread.sleep(500);
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_table_removed_inside"))).isDisplayed());
				System.out.println("Verified Successfully");
				  Thread.sleep(2000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
					  Thread.sleep(2000);
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).click();
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			
			
			
			//TC_TV_293
			@And("^verify Edit Table SSP by clicking on series name inside Edit tabel popup$")
			public void verify_Edit_Table_SSP_by_clicking_on_series_name_inside_Edit_tabel_popup() throws Throwable {
				CreateTable();
				Thread.sleep(2000);  
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				Thread.sleep(2000);  
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_EditSeries_SSP"))).click();
				Thread.sleep(500);
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Dialogue"))).isDisplayed());
				System.out.println("Verified Successfully");
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_cogwheel_inside_renameclose"))).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
		    	
			}
			
			
			
			//TC_TV_294 
			@And("^verify Edit Table Rename series icon inside Edit tabel popup$")
			public void verify_Edit_Table_Rename_series_icon_inside_Edit_tabel_popup() throws Throwable {
				CreateTable();
		    	Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
		    	Thread.sleep(1000); 
		    	Actions action = new Actions(login.driver);
				WebElement Sereiesnameintable =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_remove_inside_deleteallseries")));
				action.moveToElement(Sereiesnameintable).build().perform();
		    	Thread.sleep(2000);  
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_EditSeries_renameicon"))).click();
				Thread.sleep(500);
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_popup"))).isDisplayed());
				System.out.println("Verified Successfully");
				Thread.sleep(2000);  
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_cogwheel_inside_renameclose"))).click();
				Thread.sleep(500);
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			
			
			//TC_TV_295
			@And("^verify Edit Table edit series icon inside Edit tabel popup$")
			public void verify_Edit_Table_edit_series_icon_inside_Edit_tabel_popup() throws Throwable {
				CreateTable();
		    	Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
		     	Thread.sleep(1000); 
		    	Actions action = new Actions(login.driver);
				WebElement Sereiesnameintable =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_remove_inside_deleteallseries")));
				action.moveToElement(Sereiesnameintable).build().perform();
		    	Thread.sleep(2000);  
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_EditSeries_rename_cogwheelicon"))).click();
				String[] exp = {"Rename","Frequency","Change"};
				 List<WebElement> options = login.driver.findElements(By.xpath("//ul[@class='dropdown-menu context-menu edit-series--context-menu']/div[3]/li"));
				 for(WebElement we:options)  
				 {  
				  boolean match = false;
				  for (int j=0; j<exp.length; j++)
				  {
					  String X= we.getText();
				      if (X.equals(exp[j])){
				    	  System.out.println(X + exp[j] );
				        match = true;
				        System.out.println("DropDown is verified successfully");
				      }
				    }
				  //Assert.assertTrue(match);
				  if(match = false){
					  Assert.fail();
				  }
				 }
				 Thread.sleep(2000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
				 Thread.sleep(2000);
				CommonFunctionality.Views_list();					
			}
			
			
			
			//TC_TV_296
			@And("^verify Edit Table Rename option under edit series  inside Edit tabel popup$")
			public void verify_Edit_Table_Rename_option_under_edit_series_inside_Edit_tabel_popup() throws Throwable {
				CreateTable();
		    	Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
		     	Thread.sleep(1000); 
		    	Actions action = new Actions(login.driver);
				WebElement Sereiesnameintable =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_remove_inside_deleteallseries")));
				action.moveToElement(Sereiesnameintable).build().perform();
		    	Thread.sleep(2000);  
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_EditSeries_rename_cogwheelicon"))).click();
				Thread.sleep(2000);  
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Series_TV"))).click();
				
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_popup"))).isDisplayed());
				  System.out.println("verified clicking on series name");
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_cogwheel_inside_renameclose"))).click();
				  Thread.sleep(2000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
		    	 Thread.sleep(2000);
					CommonFunctionality.Views_list();
			}	
			
			
			
			//TC_TV_297
			@And("^verify Edit Table Frequency option under edit series  inside Edit tabel popup$")
			public void verify_Edit_Table_Frequency_option_under_edit_series_inside_Edit_tabel_popup() throws Throwable {
				CreateTable();
		    	Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
		     	Thread.sleep(1000); 
		    	Actions action = new Actions(login.driver);
				WebElement Sereiesnameintable =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_remove_inside_deleteallseries")));
				action.moveToElement(Sereiesnameintable).build().perform();
		    	Thread.sleep(2000);  
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_EditSeries_rename_cogwheelicon"))).click();
				Thread.sleep(2000);  
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Frquency_Series_TV"))).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Frequency_replicate"))).click();
				Actions action1 = new Actions(login.driver);
				WebDriverWait wait1 = new WebDriverWait(login.driver,30);
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='series-edit--title'])[2]")));
				WebElement Sereiesnameintable1 =login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[2]"));
				action1.moveToElement(Sereiesnameintable1).build().perform();
				
				Thread.sleep(2000);
				String FunctionApplied = login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[2]")).getText();
				System.out.println(FunctionApplied);
				
				if(FunctionApplied.contains("DISAGGREGATE(Weekly; Sunday; Replicate)")){
					System.out.println("Verified Successfully");
				}
				else{
					Assert.fail();
				}
				  Thread.sleep(2000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			//TC_TV_298
			@And("^verify Edit Table Currency option under edit series  inside Edit tabel popup$")
			public void verify_Edit_Table_Currency_option_under_edit_series_inside_Edit_tabel_popup() throws Throwable {
				CreateTable();
		    	Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
		     	Thread.sleep(1000); 
		    	Actions action = new Actions(login.driver);
				WebElement Sereiesnameintable =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_remove_inside_deleteallseries")));
				action.moveToElement(Sereiesnameintable).build().perform();
		    	Thread.sleep(2000);  
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_EditSeries_rename_cogwheelicon"))).click();
				Thread.sleep(2000);  
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Currency_Series_TV"))).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Currency_RUB"))).click();
				Actions action1 = new Actions(login.driver);
				WebDriverWait wait1 = new WebDriverWait(login.driver,30);
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='series-edit--title'])[2]")));
				WebElement Sereiesnameintable1 =login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[2]"));
				action1.moveToElement(Sereiesnameintable1).build().perform();
				
				Thread.sleep(2000);
				String FunctionApplied = login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[2]")).getText();
				System.out.println(FunctionApplied);
				
				if(FunctionApplied.contains("(Russian Ruble; as reported)")){
					System.out.println("Verified Successfully");
				}
				else{
					Assert.fail();
				}
				  Thread.sleep(2000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
					Thread.sleep(2000);
			    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
			    
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			//TC_TV_299
			@And("^verify Edit Table Change option under edit series  inside Edit tabel popup$")
			public void verify_Edit_Table_Change_option_under_edit_series_inside_Edit_tabel_popup() throws Throwable {
				CreateTable();
		    	Thread.sleep(2000);  
		    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
		     	Thread.sleep(1000); 
		    	Actions action = new Actions(login.driver);
				WebElement Sereiesnameintable =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_remove_inside_deleteallseries")));
				action.moveToElement(Sereiesnameintable).build().perform();
		    	Thread.sleep(2000);  
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_EditSeries_rename_cogwheelicon"))).click();
				Thread.sleep(2000);  
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Change_Series_TV"))).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Change_pop"))).click();
				Actions action1 = new Actions(login.driver);
				WebDriverWait wait1 = new WebDriverWait(login.driver,30);
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='series-edit--title'])[2]")));
				WebElement Sereiesnameintable1 =login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[2]"));
				action1.moveToElement(Sereiesnameintable1).build().perform();	
				Thread.sleep(2000);
				String FunctionApplied = login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[2]")).getText();
				System.out.println(FunctionApplied);
				if(FunctionApplied.contains("%CHANGE(Over Period; 1; Yes)")){
					System.out.println("Verified Successfully");
				}
				else{
					Assert.fail();
				}
				
				  Thread.sleep(2000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
					Thread.sleep(2000);
			    	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			
			//TC_TV_300
			@And("^verify Edit Table clicking on frequency or dropdown inside Edit tabel popup$")
			public void verify_Edit_Table_clicking_on_frequency_or_dropdown_inside_Edit_tabel_popup() throws Throwable {
				CreateTable();
				Thread.sleep(2000);  
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				Thread.sleep(2000);  
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_EditSeries_frequency"))).click();
				Thread.sleep(500);
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Frequency_Series_Harmonization"))).isDisplayed());
				System.out.println("Verified Successfully");
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_cogwheel_inside_renameclose"))).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			
			//TC_TV_301
			@And("^verify Edit Table Series data conversion -Applay inside Edit tabel popup$")
			public void verify_Edit_Table_Series_data_conversion_Applay_inside_Edit_tabel_popup() throws Throwable {
				Thread.sleep(2000);  
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				Thread.sleep(2000);  
				String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_secondSeriesname_frequency"))).getText();
				Thread.sleep(2000);  
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_EditSeries_frequency"))).click();
				
				 Thread.sleep(2000); 
				    login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Applay_Button"))).click();
				    Thread.sleep(2000); 
				    String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_secondSeriesname_frequency"))).getText();
				    
					 if(!x.equalsIgnoreCase(y)) {
						  
						  
							System.out.println("Verified");
						} else 
						{
							Assert.fail();
						}
					 
						
							  Thread.sleep(2000);
							  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
							  Thread.sleep(2000);
							  login.driver.findElement(By.xpath("//*[contains(text(),'Reset')]")).click();
							 Thread.sleep(2000);
							 CommonFunctionality.Views_list();
				
				
			}
			
			
			
			
			//TC_TV_302
			@And("^verify Edit Table Series data conversion applying Missing values method inside Edit tabel popup$")
			public void verify_Edit_Table_Series_data_conversion_applying_Missing_values_method_inside_Edit_tabel_popup() throws Throwable {
				verify_Edit_Table_Series_data_conversion_Applay_inside_Edit_tabel_popup();
			}
			
			
			
			//TC_TV_303
			@And("^verify Edit Table Series data conversion Apply button inside Edit tabel popup$")
			public void verify_Edit_Table_Series_data_conversion_Apply_button_inside_Edit_tabel_popup() throws Throwable {
				verify_Edit_Table_Series_data_conversion_Applay_inside_Edit_tabel_popup();
			}
			
			
			
			
			//TC_TV_304
			@And("^verify Edit Table Series data conversion Minimize option inside Edit tabel popup$")
			public void verify_Edit_Table_Series_data_conversion_Minimize_option_inside_Edit_tabel_popup() throws Throwable {
				Thread.sleep(2000);  
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				Thread.sleep(2000);  
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_EditSeries_frequency"))).click();
				Thread.sleep(1000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_frequency_minimize"))).click();
				Thread.sleep(1000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_frequency_Maximize"))).click();
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_frequency_minimize"))).isDisplayed());
				System.out.println("Verified");
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_cogwheel_inside_renameclose"))).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath("//*[contains(text(),'Reset')]")).click();
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			
			//TC_TV_305
			@And("^verify Edit Table Series data conversion maximize option inside Edit tabel popup$")
			public void verify_Edit_Table_Series_data_conversion_maximize_option_inside_Edit_tabel_popup() throws Throwable {
				
				Thread.sleep(2000);  
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				Thread.sleep(2000);  
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_EditSeries_frequency"))).click();

				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_frequency_minimize"))).click();
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_frequency_Maximize"))).isDisplayed());
				System.out.println("Verified");
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_frequency_Maximize"))).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_cogwheel_inside_renameclose"))).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath("//*[contains(text(),'Reset')]")).click();
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			
			
			
			
			//TC_TV_306
			@And("^verify Edit Table Series data conversion maximize full screen inside Edit tabel popup$")
			public void verify_Edit_Table_Series_data_conversion_maximize_full_screen_inside_Edit_tabel_popup() throws Throwable {
				
				
				Thread.sleep(2000);  
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				Thread.sleep(2000);  
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_EditSeries_frequency"))).click();
				Thread.sleep(1000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_rename"))).click();
				Thread.sleep(1000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Collapse_rename"))).click();
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_rename"))).isDisplayed());
				System.out.println("Verified");
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_cogwheel_inside_renameclose"))).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath("//*[contains(text(),'Reset')]")).click();
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			//TC_TV_307
			@And("^verify Edit Table Series data conversion exit full screen option inside Edit tabel popup$")
			public void verify_Edit_Table_Series_data_conversion_exit_full_screen_option_inside_Edit_tabel_popup() throws Throwable {
				Thread.sleep(2000);  
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				Thread.sleep(2000);  
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_EditSeries_frequency"))).click();

				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_rename"))).click();
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Collapse_rename"))).isDisplayed());
				System.out.println("Verified");
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_cogwheel_inside_renameclose"))).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath("//*[contains(text(),'Reset')]")).click();
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			
			
			
			//TC_TV_308
			@And("^verify Edit Table Series data conversion Cancel/x icon option inside Edit tabel popup$")
			public void verify_Edit_Table_Series_data_conversion_Cancel_x_icon_option_inside_Edit_tabel_popup() throws Throwable {
				Thread.sleep(2000);  
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				Thread.sleep(2000);  
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_EditSeries_frequency"))).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_cogwheel_inside_renameclose"))).click();
				
				
				
				if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Editseries_Frequency_Series_Harmonization"))).size() == 0) 
				{
					System.out.println("Verified");
				} else 
				{
					Assert.fail();
				}
				
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
				
			}
			
			
			
			//TC_TV_309
			@And("^verify Edit Table dropdown for frequency in series level inside Edit tabel popup$")
			public void verify_Edit_Table_dropdown_for_frequency_in_series_level_inside_Edit_tabel_popup() throws Throwable {
				Thread.sleep(2000);  
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Frequency_dropdownicon"))).click();
				 Assert.assertTrue(
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Frequency_dropdownlist"))).isDisplayed());
					  System.out.println("Verified"); 
					  Thread.sleep(2000);
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
						Thread.sleep(2000);
						CommonFunctionality.Views_list();
					  login.driver.findElement(By.xpath("//*[contains(text(),'Reset')]")).click();
						 Thread.sleep(2000);
					CommonFunctionality.Views_list();
			}
			
			//TC_TV_310
			@And("^verify Edit Table appling frequency in series level inside Edit tabel popup$")
			public void verify_Edit_Table_appling_frequency_in_series_level_inside_Edit_tabel_popup() throws Throwable {
				Thread.sleep(2000);  
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				Thread.sleep(2000);  
				String Frquencyseriesbefore = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_firstSeriesname_frequency"))).getText();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Frequency_dropdownicon"))).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Frequency_dropdownlist_firstitem"))).click();
				Thread.sleep(2000);  
				String Frquencyseriesafter = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_firstSeriesname_frequency"))).getText();
				Thread.sleep(2000);  

				 if(!Frquencyseriesbefore.equalsIgnoreCase(Frquencyseriesafter)) {
					  
					  
						System.out.println("Verified");
					} else 
					{
						Assert.fail();
					}
				 
						  Thread.sleep(2000);
						  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
						  Thread.sleep(2000);
						  login.driver.findElement(By.xpath("//*[contains(text(),'Reset')]")).click();
						 Thread.sleep(2000);
						 CommonFunctionality.Views_list();
				
			}
			
			
			//TC_TV_311
			@And("^verify Edit Table appling currency in series level inside Edit tabel popup$")
			public void verify_Edit_Table_appling_currency_in_series_level_inside_Edit_tabel_popup() throws Throwable {
				Thread.sleep(2000);  
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				Thread.sleep(2000);  
				String Frquencyseriesbefore = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_secondSeriesname_frequency"))).getText();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_insidecurrencydropdown_frequency"))).click();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Frequency_dropdownlist_firstitem"))).click();
				Thread.sleep(2000);  
				String Frquencyseriesafter = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_secondSeriesname_frequency"))).getText();
				Thread.sleep(2000);  

				 if(!Frquencyseriesbefore.equalsIgnoreCase(Frquencyseriesafter)) {
					  
					  
						System.out.println("Verified");
					} else 
					{
						Assert.fail();
					}
				 
						  Thread.sleep(2000);
						  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
						  Thread.sleep(2000);
						  login.driver.findElement(By.xpath("//*[contains(text(),'Reset')]")).click();
						 Thread.sleep(2000);
						 CommonFunctionality.Views_list();
			}
			
			
			
			
			//TC_TV_312
			@And("^verify Edit Table clicking on type a function field inside Edit tabel popup$")
			public void verify_Edit_Table_clicking_on_type_a_function_field_inside_Edit_tabel_popup() throws Throwable {
				Thread.sleep(2000);  
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).click();
				 Assert.assertTrue(
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list"))).isDisplayed());
					  System.out.println("Verified");
					  Thread.sleep(2000);
					  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
					  Thread.sleep(2000);
					  login.driver.findElement(By.xpath("//*[contains(text(),'Reset')]")).click();
					 Thread.sleep(2000);
					 CommonFunctionality.Views_list();
			}
			
			//TC_TV_313
			@And("^verify Edit Table appling function in series level inside Edit tabel popup$")
			public void verify_Edit_Table_appling_function_in_series_level_inside_Edit_tabel_popup() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).sendKeys("Change");
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_Apply"))).click();
				 Thread.sleep(2000);
				String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_searchbar"))).getText().replaceAll(" ", "");
				 Thread.sleep(2000);
					String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_attribute_inside"))).getText().replaceAll(" ", "");
					   System.out.println("Verified1" +y);  
					String[] parts1 = x.split(";");
					  System.out.println("Verified2" +parts1[0]);  
					   	      String secondpart = parts1[0];
							   System.out.println("Verified4" +parts1[0] +secondpart );  
							   
							   if(secondpart.equalsIgnoreCase(x)) {
									 System.out.println("Verified");
								  }
								  else {
									  Assert.fail();
								  }
							   Thread.sleep(2000);
								  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
								  Thread.sleep(2000);
								    CommonFunctionality.Views_list();
			}
			
			//TC_TV_314
			@And("^verify Edit Table cancel icon for selected function inside Edit tabel popup$")
			public void verify_Edit_Table_cancel_icon_for_selected_function_inside_Edit_tabel_popup() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
					 Thread.sleep(2000);
					 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_attribute_inside"))).getText();
					 Thread.sleep(2000);
					 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).click();
					 Thread.sleep(2000);
					 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).sendKeys("Change");
					 Thread.sleep(2000);
					 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
					 Thread.sleep(2000);
					 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
					 Thread.sleep(2000);
					 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_Apply"))).click();
					 Thread.sleep(2000);
					 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_cancel"))).click();
					 Thread.sleep(2000);
					 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_Apply"))).click();
					 Thread.sleep(2000);
					 String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_attribute_inside"))).getText();
					 Thread.sleep(1000);
					 if(y.equalsIgnoreCase(x)) {
						 System.out.println("Verified");
					  }
					  else {
						  Assert.fail();
					  }
					 Thread.sleep(2000);
					  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
					  Thread.sleep(2000);
					    CommonFunctionality.Views_list();	 
			}
			
			//TC_TV_315
			@And("^verify Edit Table multiple functions apply inside Edit tabel popup$")
			public void verify_Edit_Table_multiple_functions_apply_inside_Edit_tabel_popup() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).sendKeys("Change");
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).sendKeys("LOG");
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
				 Thread.sleep(5000);
				 WebElement tick = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_Apply")));
				 Actions action = new Actions(login.driver);
					action.moveToElement(tick).click().build().perform();
				 Thread.sleep(2000);
				 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_attribute_inside"))).getText().replaceAll(" ", "");
				 String[] parts1 = x.split(";");
				  String z = parts1[1];  
				 System.out.println("Verified123" + z );
				 if(z.contains("CHANGE") && z.contains("LOG"))
				 {
					 
					 System.out.println("Verified");
				  }
				  else {
					  Assert.fail();
				  }
				 Thread.sleep(2000);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
				  Thread.sleep(2000);
				    CommonFunctionality.Views_list();
			}
			
			
			
			//TC_TV_316
			@And("^verify Edit Table search for functions inside Edit tabel popup$")
			public void verify_Edit_Table_search_for_functions_inside_Edit_tabel_popup() throws Throwable {
			CreateTable();
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).click();
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).sendKeys("Change");
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
			 Thread.sleep(2000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
			 
			 Thread.sleep(5000);
			 WebElement tick = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_Apply")));
			 Actions action = new Actions(login.driver);
				action.moveToElement(tick).click().build().perform();
			
			 Thread.sleep(2000);
			 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_attribute_inside"))).getText().replaceAll(" ", "");
			 if(x.contains("CHANGE")) {
				 
				 System.out.println("Verified");
			 }
			 else {
				  Assert.fail();
			  }
			 Thread.sleep(2000);
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			  Thread.sleep(2000);
			    CommonFunctionality.Views_list();
			}
			
			
			
			
			//TC_TV_317
			@And("^verify Edit Table removing applied functions inside Edit tabel popup$")
			public void verify_Edit_Table_removing_applied_functions_inside_Edit_tabel_popup() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
					 Thread.sleep(2000);
					 String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_attribute_inside"))).getText().replaceAll(" ", "");
					 Thread.sleep(2000);
					 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).click();
					 Thread.sleep(2000);
					 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).sendKeys("LOG");
					 Thread.sleep(2000);
					 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
					 Thread.sleep(5000);
					 WebElement tick = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_Apply")));
					 Actions action = new Actions(login.driver);
						action.moveToElement(tick).click().build().perform();
					 Thread.sleep(2000);
					 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_cancel_serieslevel"))).click();
					 Thread.sleep(2000);
					 WebElement tick2 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Applyfunctioninside")));
					 Actions action2 = new Actions(login.driver);
						action2.moveToElement(tick2).click().build().perform();
					 
					 
					 Thread.sleep(2000);
					
					 Thread.sleep(2000);
					 String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_attribute_inside"))).getText().replaceAll(" ", "");
					 
					 if(x.equalsIgnoreCase(y) ){
								 
								 System.out.println("Verified");
							 }
							 else {
								  Assert.fail();
							  }
					 Thread.sleep(2000);
					  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
					  Thread.sleep(2000);
					    CommonFunctionality.Views_list();
				 
			}
			
			
			
			//TC_TV_318
			@And("^verify Edit Table appling invalid function for series inside Edit tabel popup$")
			public void verify_Edit_Table_appling_invalid_function_for_series_inside_Edit_tabel_popup() throws Throwable {
				 Thread.sleep(2000); 
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).sendKeys("convertcur");
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
				 Thread.sleep(2000);
				 WebElement tick = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_Apply")));
				 Actions action = new Actions(login.driver);
					action.moveToElement(tick).click().build().perform();
					 Thread.sleep(2000);
				 Assert.assertTrue(
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Invalidfunction_popup"))).isDisplayed());
				 System.out.println("Verified Editseries_Invalidfunction_popup");
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_window"))).click();
				 Thread.sleep(2000);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
				  Thread.sleep(2000);
				    CommonFunctionality.Views_list();
			}
			
			
			
			//TC_TV_319
			@And("^verify Edit Table OK button on The function cannot be applied to selected series popup inside Edit tabel popup$")
			public void verify_Edit_Table_OK_button_on_The_function_cannot_be_applied_to_selected_series_popup_inside_Edit_tabel_popup() throws Throwable {
				Thread.sleep(2000); 
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).sendKeys("convertcur");
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_Apply"))).click();
				 Assert.assertTrue(
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).isDisplayed());
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).click();
				 Thread.sleep(2000);
					if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("ResultTableVisual"))).size() == 0) 
					{
						System.out.println("Verified");
					} else 
					{
						Assert.fail();
					}
					 Thread.sleep(2000);
					  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
					  Thread.sleep(2000);
					    CommonFunctionality.Views_list();
			}
			
			
			
			
			//TC_TV_320
			@And("^verify Edit Table Region, Unit and Series ID fields inside Edit tabel popup$")
			public void verify_Edit_Table_Region_Unit_and_Series_ID_fields_inside_Edit_tabel_popup() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				 
					 Assert.assertTrue(
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_scrollSeriesid"))).isDisplayed());
					 Assert.assertTrue(
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_scrollregion"))).isDisplayed());
					 Thread.sleep(2000);
					  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
					  Thread.sleep(2000);
					    CommonFunctionality.Views_list();
			}
			//TC_TV_321
			@And("^verify Edit Table horizontal scroll bar for series inside Edit tabel popup$")
			public void verify_Edit_Table_horizontal_scroll_bar_for_series_inside_Edit_tabel_popup() throws Throwable {
				verify_Edit_Table_Region_Unit_and_Series_ID_fields_inside_Edit_tabel_popup();
			}
			
			
			//TC_TV_322
			@And("^verify Edit Table feedback option$")
			public void verify_Edit_Table_feedback_option() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				 
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback"))).click();
				 Thread.sleep(2000);

				 Assert.assertTrue(
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback_popup"))).isDisplayed());
				 
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_window"))).click();
				 Thread.sleep(2000);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
				  Thread.sleep(2000);
				    CommonFunctionality.Views_list();
				 
			}
			
			
			
			//TC_TV_323
			@And("^verify Edit Table description for popup$")
			public void verify_Edit_Table_description_for_popup() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback"))).click();
				 Thread.sleep(2000);
				 Assert.assertTrue(
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback_Description"))).isDisplayed()); 
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_window"))).click();
				 Thread.sleep(2000);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
				  Thread.sleep(2000);
				    CommonFunctionality.Views_list();
			}
			
			
			
			//TC_TV_324
			@And("^verify Edit Table adding text in the field$")
			public void verify_Edit_Table_adding_text_in_the_field() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback"))).click();
				 Thread.sleep(2000);
				 String x ="Testing";
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback_textarea"))).sendKeys(x);
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback_Submit"))).click(); 
				 Thread.sleep(500);
				 Assert.assertTrue(
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback_ack"))).isDisplayed()); 
				 Thread.sleep(2000);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
				  Thread.sleep(2000);
				    CommonFunctionality.Views_list();
				 
			}
			
			
			

			//TC_TV_325
			@And("^verify Edit Table Submit and cancel buttons when description field is empty$")
			public void verify_Edit_Table_Submit_and_cancel_buttons_when_description_field_is_empty() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback"))).click();
				
				 Thread.sleep(2000);
				String feedbacksubmit = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback_Submit_disable"))).getAttribute("class"); 
				if(feedbacksubmit.contains("disabled")) {
					System.out.println("Verified");
				} else 
				{
					Assert.fail();
				
				}
				Thread.sleep(2000);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_window"))).click();
				 Thread.sleep(2000);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
				  Thread.sleep(2000);
				    CommonFunctionality.Views_list();
			}
			
			
			
			

			//TC_TV_326
			@And("^verify Edit Table cancel button$")
			public void verify_Edit_Table_cancel_button() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback"))).click();
				 String x ="Testing";
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback_textarea"))).sendKeys(x);
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback_Cancel"))).click(); 
				 
				 if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback_Cancel"))).size() == 0) 
					{
						System.out.println("Verified");
					} else 
					{
						Assert.fail();
					}
				 Thread.sleep(2000);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
				  Thread.sleep(2000);
				    CommonFunctionality.Views_list();
				 
			}

			
			
			//TC_TV_327
			@And("^verify Edit Table Submit button$")
			public void verify_Edit_Table_Submit_button() throws Throwable {
				verify_Edit_Table_adding_text_in_the_field();
			}
			
			//TC_TV_328
			@And("^verify Edit growl message after Submit button$")
			public void verify_Edit_growl_message_after_Submit_button() throws Throwable {
				verify_Edit_Table_adding_text_in_the_field();
			}
			//TC_TV_329
			@And("^verify Edit Table cancel/x button$")
			public void verify_Edit_Table_cancel_x_button() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Canceldown"))).click();
				 Thread.sleep(2000);
				 if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Edit_table_Canceldown"))).size() == 0) 
					{
						System.out.println("Verified");
					} else 
					{
						Assert.fail();
					}
				  Thread.sleep(2000);
				    CommonFunctionality.Views_list();
			}
			//TC_TV_330
			@And("^verify Edit Table save button$")
			public void verify_Edit_Table_save_button() throws Throwable {
				verify_Edit_Table_Header_bold_style();
			}
			
			
			//TC_TV_331
			@And("^verify Add related series option$")
			public void verify_Add_related_series_option() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_related_series"))).click();
				 Thread.sleep(2000);
				 Assert.assertTrue(
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_related_series_popup"))).isDisplayed()); 
				 Thread.sleep(2000);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_Harmonization"))).click();
				  Thread.sleep(2000);
				    CommonFunctionality.Views_list(); 
			}
			
			
			//TC_TV_332
			@And("^verify Add related option when the visual is empty$")
			public void verify_Add_related_option_when_the_visual_is_empty() throws Throwable {
				Thread.sleep(2000);
				 boolean relatedseries = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_related_series"))).isEnabled();
						if(relatedseries==false) {
							System.out.println("Verified");
						}else {
							Assert.fail();
						}
						Thread.sleep(2000);
					    CommonFunctionality.Views_list(); 
			}
			
			//TC_TV_333
			@And("^Verify adding series from Series suggestion manager popup$")
			public void verify_adding_series_from_Series_suggestion_manager_popup() throws Throwable {
				 Thread.sleep(2000); 
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_related_series"))).click();
				 Thread.sleep(2000);
				 String x =  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_related_series_firsttitle"))).getText();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_related_series_regiondropdown"))).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_related_series_region_albania"))).click();
				 Thread.sleep(2000);
				 String y =  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_related_series_firsttitle"))).getText();
				 System.out.println("Verified x as " + x);
				 System.out.println("Verified x as " + y);
				 Thread.sleep(2000);
				  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_Harmonization"))).click();
				 Thread.sleep(2000);
				 if(!x.equalsIgnoreCase(y)) {
					 System.out.println("Verified");
				 }else {
						Assert.fail();
					}
				 Thread.sleep(2000);
					login.driver.findElement(By.xpath("//span[contains(text(),'Reset')]")).click();
					Thread.sleep(2000);
				    CommonFunctionality.Views_list();
			}
			
			
			
			
			//TC_TV_334
			@And("^verify add to insight option$")
			public void verify_add_to_insight_option() throws Throwable {
				 Thread.sleep(2000); 
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_insight_dropdown"))).click();
					 Thread.sleep(2000);
					 Assert.assertTrue(
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_insight_dropdown_insight"))).isDisplayed()); 
					 Thread.sleep(500);
					 Assert.assertTrue(
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_insight_dropdown_add"))).isDisplayed()); 
					
					  Thread.sleep(2000);
					    CommonFunctionality.Views_list(); 
			}
			
			
			
			
			
			//TC_TV_335
			@And("^verify Add option under Add to insight$")
			public void verify_Add_option_under_Add_to_insight() throws Throwable {
				Thread.sleep(2000); 
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_insight_dropdown"))).click();
				Thread.sleep(2000); 
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_insight_dropdown_add"))).click();
				Thread.sleep(2000); 
				List<WebElement> views = login.driver
						.findElements(By.xpath("//*[contains(@class,'insight-page-view-tab') and contains(text(),'View')]"));
				if(views.size()>=2) {
					 System.out.println("Verified");
				}
				else {
					Assert.fail();
				}
				Thread.sleep(2000);
			    CommonFunctionality.Views_list();
			}
			
			//TC_TV_336
			@And("^verify confirmation message for adding visual to new insight$")
			public void verify_confirmation_message_for_adding_visual_to_new_insight() throws Throwable {
				Thread.sleep(2000); 
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_insight_dropdown"))).click();
				Thread.sleep(2000); 
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_insight_dropdown_insight"))).click();
				 Thread.sleep(2000);
				 Assert.assertTrue(
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback_ack"))).isDisplayed()); 
				 Thread.sleep(2000);
				    CommonFunctionality.Views_list();
			}
			
			//TC_TV_337
			@And("^verify Validate the added visual by opening new insight$")
			public void verify_Validate_the_added_visual_by_opening_new_insight() throws Throwable {
				Thread.sleep(2000); 
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_insight_dropdown"))).click();
				Thread.sleep(2000); 
				 String urlcurrenttab = login.driver.getCurrentUrl();
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_insight_dropdown_insight"))).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Createnew_insight"))).click();
				//a[@class='button growl-message-content--btns__fill']
				 
				 ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
				    login.driver.switchTo().window(tabs2.get(1));
				    Thread.sleep(2000);
				    
				    String urlnewtab = login.driver.getCurrentUrl();
					
					 login.driver.close();
					    login.driver.switchTo().window(tabs2.get(0));
				 if(!urlcurrenttab.equalsIgnoreCase(urlnewtab)) {
					 System.out.println("Verified");
				 }else {
					 Assert.fail();
				 }
				 Thread.sleep(2000);
				    CommonFunctionality.Views_list();
			}
			//TC_TV_338
			@And("^verify growl popup auto close$")
			public void verify_growl_popup_auto_close() throws Throwable {
				verify_confirmation_message_for_adding_visual_to_new_insight();
			}
			
			//TC_TV_339
			@And("^verify Copy option$")
			public void verify_Copy_option() throws Throwable {
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_icon_table"))).click();
				 Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				  Transferable contents = clipboard.getContents(null);
				  String x = (String) contents.getTransferData(DataFlavor.stringFlavor);
				  String y =x.replaceAll("\\s+","");
				  String Copy_link ="NameEmploymentRateRegionTunisiaFrequencyQuarterly,ending&quot;Mar,June,Sep,Dec&quot;Unit%SeriesID394611277FirstDate06/2010LastDate06/2017LastUpdated03/201906/201040.806/201138.512/201138.806/201259.909/20126012/201260.203/201360.206/201360.509/201360.712/201360.803/201460.806/201460.909/20146112/201460.903/201560.606/201560.309/201560.212/201560.103/20166006/20166009/201659.912/201659.803/201759.906/201759.8".replaceAll("\\s+","");
				  Thread.sleep(2000);
				  if(y.equalsIgnoreCase(Copy_link)){
					  System.out.println("Verified");
					} else {
						Assert.fail();
				  }
				  Thread.sleep(2000);
					login.driver.findElement(By.xpath("//span[contains(text(),'Reset')]")).click();
					Thread.sleep(2000);
				    CommonFunctionality.Views_list();
			}
			
			
			
			
			//TC_TV_340
			@And("^verify confirmation message for copy visual$")
			public void verify_confirmation_message_for_copy_visual() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_icon_table"))).click();
				 Thread.sleep(2000);
				 Assert.assertTrue(
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback_ack"))).isDisplayed()); 
				 Thread.sleep(2000);
				    CommonFunctionality.Views_list();
			}
			
			//TC_TV_341
			@And("^verify copy here in growl message$")
			public void verify_copy_here_in_growl_message() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_icon_table"))).click();
				 Thread.sleep(500);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_clickhere"))).click();
				 Thread.sleep(2000);
				 Assert.assertTrue(
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_download"))).isDisplayed()); 
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_window"))).click();
				 Thread.sleep(2000);
				    CommonFunctionality.Views_list();
			}
			
			
			//TC_TV_342
			@And("^verify copied visual by pasting with in the insight$")
			public void verify_copied_visual_by_pasting_with_in_the_insight() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_icon_table"))).click();
				 
				 Robot robot = new Robot();
				 robot.keyPress(KeyEvent.VK_CONTROL);
				  robot.keyPress(KeyEvent.VK_V);
				  robot.keyRelease(KeyEvent.VK_V);
				  robot.keyRelease(KeyEvent.VK_CONTROL);
				  Thread.sleep(8000);
				List<WebElement> attributes_list_after = login.driver.findElements(By.className("hor-vertical-header"));
					int attributes_table_count_after = attributes_list_after.size();
					 System.out.println("Verified number as "  + attributes_table_count_after);
					 if(attributes_table_count_after >= 16) {
						 System.out.println("Verified");
					 }
					 else {
							Assert.fail();
					  }
					 Thread.sleep(2000);
					    CommonFunctionality.Views_list();
			}
			
			
			//TC_TV_343
			@And("^verify copied visual by pasting to new insight$")
			public void verify_copied_visual_by_pasting_to_new_insight() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_icon_table"))).click();
				 Thread.sleep(3000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CreateViewTab"))).click();
					 Thread.sleep(3000);
					 Robot robot = new Robot();
					 robot.keyPress(KeyEvent.VK_CONTROL);
					  robot.keyPress(KeyEvent.VK_V);
					  robot.keyRelease(KeyEvent.VK_V);
					  robot.keyRelease(KeyEvent.VK_CONTROL);
					  Assert.assertTrue(
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback_ack"))).isDisplayed());
					  Thread.sleep(8000);
					  
					  List<WebElement> views = login.driver
								.findElements(By.xpath("//*[contains(@class,'insight-page-view-tab') and contains(text(),'View')]"));
						if (views.size() >= 2) 
						{
							List<WebElement> attributes_list_after = login.driver.findElements(By.className("hor-vertical-header"));
							int attributes_table_count_after = attributes_list_after.size();
							 if(attributes_table_count_after >= 8) {
								 System.out.println("Verified");
			
							 }
							 else {
									Assert.fail();
							  }
						}
						 Thread.sleep(2000);
						    CommonFunctionality.Views_list();
					  
			}
			
			
			
			
			
			//TC_TV_344
			@And("^verify confrimation message for pasting visual in insight$")
			public void verify_confrimation_message_for_pasting_visual_in_insight() throws Throwable {
				verify_copied_visual_by_pasting_to_new_insight();
			}
			
			
			
			
			//TC_TV_345
			@And("^verify Download option$")
			public void verify_Download_option() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_Download_icon"))).click();
				 Thread.sleep(3000);
				  Assert.assertTrue(
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Download_popup"))).isDisplayed());
				  Thread.sleep(2000);
					 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_window"))).click();
					 Thread.sleep(2000);
					    CommonFunctionality.Views_list();
			}
			
			
			//TC_TV_347
			@And("^verify Table visual download with \"([^\"]*)\" format$")
			public void verify_Table_visual_download_with_format(String arg1) throws Throwable {
				
				 
				 File theNewestFile = null;
				    File dir = new File(System.getProperty("user.home") + "\\Downloads");
				    String ext = arg1;
					FileFilter fileFilter = new WildcardFileFilter("*." + ext);
					File[] files = dir.listFiles(fileFilter);
						
					if (files.length > 0) {
				        /** The newest file comes first **/
				    	 //System.out.println("^^^^^^^^^^^^Entered");
				        Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
				        theNewestFile = files[0];
				        
				    //}
				    
				    System.out.println("The Successfully downloaded file is " + theNewestFile);
				    String E =getFileExtension(theNewestFile);
				    System.out.println("The Successfully extension file is " +  E);
				    //return theNewestFile;
				    if(E.equalsIgnoreCase(ext)){
				    	 System.out.println("Downloaded File Format Matched Successfully."  + "'"+ ext +  "' <> '" + E + "'");
				    }
				    else{
				    	
				    	 Assert.fail( "Downloaded File Format is NOT Matched."  +"'" +  E +  "' <> '" + ext + "'");
				    }
				    }
					Thread.sleep(2000);
				    CommonFunctionality.Views_list();
					
			}
			
			//TC_TV_347
			@And("^select PDF format$")
			public void select_PDF_format() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_Download_icon"))).click();
				 Thread.sleep(3000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_Download_PDF"))).click();
				 Thread.sleep(3000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_download"))).click();
				 
				 
				 
			}
			//TC_TV_348
			@And("^select PNG format$")
			public void select_PNG_format() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_Download_icon"))).click();
				 Thread.sleep(3000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_Download_png"))).click();
				 Thread.sleep(3000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_download"))).click();
			}
			//TC_TV_349
			@And("^select JPG format$")
			public void select_JPG_format() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_Download_icon"))).click();
				 Thread.sleep(3000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_Download_jpeg"))).click();
				 Thread.sleep(3000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_download"))).click();
			}
			
			//TC_TV_346
			@And("^select XLSX format$")
			public void select_XLSX_format() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_Download_icon"))).click();
				 Thread.sleep(3000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_Download_xlsx"))).click();
				 Thread.sleep(3000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_download"))).click();
			}
			
			
			
			//TC_TV_350
			@And("^verify Open option$")
			public void verify_Open_option() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_open_icon"))).click();
				 Thread.sleep(3000);
				 String x =login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_open_icon_copy"))).getText();
				 if(x.contains("Copy")) {
					 System.out.println("Verified");
				 }else {
					 Assert.fail();
				 }
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_window"))).click();
				 Thread.sleep(2000);
				    CommonFunctionality.Views_list();
				 
			}
			
			//TC_TV_351
			@And("^verify closing of maximized window$")
			public void verify_closing_of_maximized_window() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_open_icon"))).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_window"))).click();
				 Thread.sleep(2000);
				 if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("ResultTableVisual"))).size() == 0) 
					{
						System.out.println("Table visual creating from View panel by drag and drop is working fine");
					} else 
					{
						Assert.fail("Table visual creating from View panel by drag and drop is Not working fine");
					}
					CommonFunctionality.Views_list();
				 
			}
			
			
			//TC_TV_352
			@And("^verify Delete Table$")
			public void verify_Delete_Table() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_open_icon_delete"))).click();
				 Thread.sleep(2000);
				 Assert.assertTrue(
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_delete_popup"))).isDisplayed());
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Downloadwindowclose"))).click();
				 Thread.sleep(2000);
				 CommonFunctionality.Views_list();
			}
			
			
			//TC_TV_353
			@And("^verify description for delete confirmation popup$")
			public void verify_description_for_delete_confirmation_popup() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_open_icon_delete"))).click();
				 Thread.sleep(2000);
				 Assert.assertTrue(
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_delete_popup_inside"))).isDisplayed());
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Downloadwindowclose"))).click();
				 Thread.sleep(2000);
				 CommonFunctionality.Views_list();
			}
			
			
			//TC_TV_354  
			@And("^verify Delete OK button in delete confirmation popup$")
			public void verify_Delete_OK_button_in_delete_confirmation_popup() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_open_icon_delete"))).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).click();
				 Thread.sleep(2000);
				 Assert.assertTrue(
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_delete_ok_empty"))).isDisplayed());
				 Thread.sleep(2000);
				 CommonFunctionality.Views_list();
			}
			
			
			
			//TC_TV_355
			@And("^verify Delete Cancel/x icon in delete confirmation popup$")
			public void verify_Delete_Cancel_x_icon_in_delete_confirmation_popup() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_open_icon_delete"))).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_delete_cancel"))).click();
				 Thread.sleep(2000);
				 Assert.assertTrue(
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).isDisplayed());
				 Thread.sleep(2000);
				 CommonFunctionality.Views_list();
				 
				 
			}
			
			
			
		
			
			//TC_TV_356 
			@And("^verify right click options-Table visual$")
			public void verify_right_click_options_Table_visual() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 Actions action = new Actions(login.driver);
				  WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
					action.contextClick(ele).pause(6000).build().perform();
					Thread.sleep(2000);
					 Assert.assertTrue(
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_copy"))).isDisplayed());
				
					 Thread.sleep(2000);
					 CommonFunctionality.Views_list();
				
			}
			
			
			//TC_TV_357
			@And("^verify right click options-Copy Table$")
			public void verify_right_click_options_Copy_Table() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 Actions action = new Actions(login.driver);
				  WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
					action.contextClick(ele).pause(6000).build().perform();
					Thread.sleep(2000);
					 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_copy"))).click();
					 Thread.sleep(2000);
					 Assert.assertTrue(
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback_ack"))).isDisplayed());
					 Thread.sleep(2000);
					    CommonFunctionality.Views_list();
				
			}
			
			
			//TC_TV_358
			@And("^verify right click Validate copied Table$")
			public void verify_right_click_Validate_copied_Table() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 Actions action = new Actions(login.driver);
				  WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
					action.contextClick(ele).pause(6000).build().perform();
					Thread.sleep(2000);
					 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_copy"))).click();
					 Thread.sleep(2000);
					 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_Add_icon"))).click();
					 Thread.sleep(3000);
					 Robot robot = new Robot();
					 robot.keyPress(KeyEvent.VK_CONTROL);
					  robot.keyPress(KeyEvent.VK_V);
					  robot.keyRelease(KeyEvent.VK_V);
					  robot.keyRelease(KeyEvent.VK_CONTROL);
					  Thread.sleep(8000);
					  List<WebElement> views = login.driver
								.findElements(By.xpath("//*[contains(@class,'insight-page-view-tab') and contains(text(),'View')]"));
						if (views.size() >= 2) {
							 System.out.println("Verified");
							 Assert.assertTrue(
										login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name"))).isDisplayed());
						}
						else {
							Assert.fail();
						}
						 Thread.sleep(2000);
						    CommonFunctionality.Views_list();
			}
			
			
			//TC_TV_359
			@And("^verify right click options Cut Table$")
			public void verify_right_click_options_Cut_Table() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 Actions action = new Actions(login.driver);
				  WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
					action.contextClick(ele).pause(6000).build().perform();
					Thread.sleep(2000);
					 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_cut"))).click();
					 Thread.sleep(2000);
					 Assert.assertTrue(
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback_ack"))).isDisplayed());
					 Thread.sleep(2000);
					    CommonFunctionality.Views_list();
			}
			//TC_TV_360
			@And("^verify right click  Validate Cut Table$")
			public void verify_right_click_Validate_Cut_Table() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 Actions action = new Actions(login.driver);
				  WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
					action.contextClick(ele).pause(6000).build().perform();
					Thread.sleep(2000);
					 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_cut"))).click();
					 Thread.sleep(2000);
					 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_Add_icon"))).click();
					 Thread.sleep(3000);
					 Robot robot = new Robot();
					 robot.keyPress(KeyEvent.VK_CONTROL);
					  robot.keyPress(KeyEvent.VK_V);
					  robot.keyRelease(KeyEvent.VK_V);
					  robot.keyRelease(KeyEvent.VK_CONTROL);
					  Thread.sleep(8000);
					  List<WebElement> views = login.driver
								.findElements(By.xpath("//*[contains(@class,'insight-page-view-tab') and contains(text(),'View')]"));
						if (views.size() >= 2) {
							 System.out.println("Verified");
							 Assert.assertTrue(
										login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name"))).isDisplayed());
						}
						else {
							Assert.fail();
						}
						 Thread.sleep(2000);
						    CommonFunctionality.Views_list();
			}
			//TC_TV_361
			@And("^verify right click  options Delete Table$")
			public void verify_right_click_options_Delete_Table() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 Actions action = new Actions(login.driver);
				  WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
					action.contextClick(ele).pause(6000).build().perform();
					Thread.sleep(2000);
					 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_delete"))).click();
					 Thread.sleep(2000);
					 Thread.sleep(2000);
					 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).click();
					 Thread.sleep(2000);
					 Assert.assertTrue(
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_delete_ok_empty"))).isDisplayed());
					 Thread.sleep(2000);
					 CommonFunctionality.Views_list();
			}
			
			//TC_TV_362
			@And("^verify right click  options insert visual sub dropdown$")
			public void verify_right_click_options_insert_visual_sub_dropdown() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				Actions action = new Actions(login.driver);
				WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
				action.contextClick(ele).pause(6000).build().perform();
				Thread.sleep(2000);
				Actions action1 = new Actions(login.driver);
				WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual")));
				action1.moveToElement(ele1).pause(6000).build().perform();
				Thread.sleep(2000);
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual_chart"))).isDisplayed());
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			
			
			//TC_TV_363
			@And("^verify right click  chart under insert visual$")
			public void verify_right_click_chart_under_insert_visual() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				Actions action = new Actions(login.driver);
				WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
				action.contextClick(ele).pause(6000).build().perform();
				Thread.sleep(2000);
				Actions action1 = new Actions(login.driver);
				WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual")));
				action1.moveToElement(ele1).pause(6000).build().perform();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual_chart"))).click();
				 Thread.sleep(2000);
				 Assert.assertTrue(
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_chartvalid"))).isDisplayed());
				 Thread.sleep(2000);
					CommonFunctionality.Views_list();
				 
			}
			//TC_TV_364
			@And("^verify right click  Pie under insert visual$")
			public void verify_right_click_Pie_under_insert_visual() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				Actions action = new Actions(login.driver);
				WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
				action.contextClick(ele).pause(6000).build().perform();
				Thread.sleep(2000);
				Actions action1 = new Actions(login.driver);
				WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual")));
				action1.moveToElement(ele1).pause(6000).build().perform();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual_pie"))).click();
				 Thread.sleep(2000);
				 Assert.assertTrue(
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_pievalid"))).isDisplayed());
				 Thread.sleep(2000);
					CommonFunctionality.Views_list();
			}
			//TC_TV_365 
			@And("^verify right click  table under insert visual$")
			public void verify_right_click_table_under_insert_visual() throws Throwable {
				CreateTable();
				Thread.sleep(8000);
				Actions action = new Actions(login.driver);
				WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
				action.contextClick(ele).pause(6000).build().perform();
				Thread.sleep(2000);
				Actions action1 = new Actions(login.driver);
				WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual")));
				action1.moveToElement(ele1).pause(6000).build().perform();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual_table"))).click();
				 Thread.sleep(2000);
				 Assert.assertTrue(
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ResultTableVisual"))).isDisplayed());
				 Thread.sleep(2000);
					CommonFunctionality.Views_list();
			}
			
			//TC_TV_366
			@And("^verify right click  map under insert visual$")
			public void verify_right_click_map_under_insert_visual() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				Actions action = new Actions(login.driver);
				WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
				action.contextClick(ele).pause(6000).build().perform();
				Thread.sleep(2000);
				Actions action1 = new Actions(login.driver);
				WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual")));
				action1.moveToElement(ele1).pause(6000).build().perform();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual_map"))).click();
				 Thread.sleep(2000);
				 Assert.assertTrue(
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_mapvalid"))).isDisplayed());
				 Thread.sleep(2000);
					CommonFunctionality.Views_list();
			}
			//TC_TV_367
			@And("^verify right click  Heatmap under insert visual$")
			public void verify_right_click_Heatmap_under_insert_visual() throws Throwable {
				CreateTable();
				Thread.sleep(8000);
				Actions action = new Actions(login.driver);
				WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
				action.contextClick(ele).pause(6000).build().perform();
				Thread.sleep(2000);
				Actions action1 = new Actions(login.driver);
				WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual")));
				action1.moveToElement(ele1).pause(6000).build().perform();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual_heatmap"))).click();
				Thread.sleep(2000);
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_heatmapvalid"))).isDisplayed());
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			//TC_TV_368
			@And("^verify right click  Pyramid under insert visual$")
			public void verify_right_click_Pyramid_under_insert_visual() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				Actions action = new Actions(login.driver);
				WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
				action.contextClick(ele).pause(6000).build().perform();
				Thread.sleep(2000);
				Actions action1 = new Actions(login.driver);
				WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual")));
				action1.moveToElement(ele1).pause(6000).build().perform();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual_pyramid"))).click();
				Thread.sleep(2000);
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_pyramidvalid"))).isDisplayed());
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			
			
			
			//TC_TV_369
			@And("^verify right click  Commentary under insert visual$")
			public void verify_right_click_Commentary_under_insert_visual() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				Actions action = new Actions(login.driver);
				WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
				action.contextClick(ele).pause(6000).build().perform();
				Thread.sleep(2000);
				Actions action1 = new Actions(login.driver);
				WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual")));
				action1.moveToElement(ele1).pause(6000).build().perform();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual_commentary"))).click();
				Thread.sleep(2000);
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_commentaryvalid"))).isDisplayed());
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			//TC_TV_370
			@And("^verify right click  Attachment under insert visual$")
			public void verify_right_click_Attachment_under_insert_visual() throws Throwable {
				CreateTable();
				Thread.sleep(8000);
				Actions action = new Actions(login.driver);
				WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
				action.contextClick(ele).pause(6000).build().perform();
				Thread.sleep(2000);
				Actions action1 = new Actions(login.driver);
				WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual")));
				action1.moveToElement(ele1).pause(6000).build().perform();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual_attachments"))).click();
				Thread.sleep(2000);
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_Attachmentsvalid"))).isDisplayed());
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			//TC_TV_371
			@And("^verify right click  image under insert visual$")
			public void verify_right_click_image_under_insert_visual() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				Actions action = new Actions(login.driver);
				WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
				action.contextClick(ele).pause(6000).build().perform();
				Thread.sleep(2000);
				Actions action1 = new Actions(login.driver);
				WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual")));
				action1.moveToElement(ele1).pause(6000).build().perform();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual_Image"))).click();
				Thread.sleep(2000);
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_Imagevalid"))).isDisplayed());
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			//TC_TV_372
			@And("^verify right click  Filter under insert visual$")
			public void verify_right_click_Filter_under_insert_visual() throws Throwable {
				CreateTable();
				Thread.sleep(8000);
				Actions action = new Actions(login.driver);
				WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
				CommonFunctionality.action.contextClick(ele).pause(2000).build().perform();
				//action.moveToElement(ele).contextClick(ele).build().perform();
				//action.contextClick(ele).pause(6000).build().perform();
				Thread.sleep(2000);
				Actions action1 = new Actions(login.driver);
				WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual")));
				action1.moveToElement(ele1).pause(6000).build().perform();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual_filters"))).click();
				Thread.sleep(2000);
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_Filtervalid"))).isDisplayed());
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}

			
			
			
			//TC_TV_373
			@And("^verify right click Paste visual$")
			public void verify_right_click_Paste_visual() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				Actions action = new Actions(login.driver);
				WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
				action.contextClick(ele).pause(6000).build().perform();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_copy"))).click();
				Thread.sleep(2000);
				Actions action1 = new Actions(login.driver);
				WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name")));
				action1.contextClick(ele1).pause(6000).build().perform();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_paste"))).click();

				Thread.sleep(8000);
				List<WebElement> views = login.driver
						.findElements(By.xpath("(//div[@class='table-element visual-select-area']/div/table/thead/tr/th[1])"));
				if (views.size() >= 16) {
					System.out.println("Verified");

				}
				else {
					Assert.fail();
				}
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			
			
			
			
			//TC_TV_374
			@And("^verify right click View as sub dropdown$")
			public void verify_right_click_View_as_sub_dropdown() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				Actions action = new Actions(login.driver);
				WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
				action.contextClick(ele).pause(6000).build().perform();
				Actions action1 = new Actions(login.driver);
				WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas")));
				action1.moveToElement(ele1).pause(6000).build().perform();
				
				
				String[] exp = {"Chart","Map","Pie","Heat map","Histogram"};
				 List<WebElement> Viewasoptions = login.driver.findElements(By.xpath("(//span[@class='dropdown-submenu-icon'])[1]/following::ul[2]/li"));
				 for(WebElement we:Viewasoptions)  
				 {  
				  boolean match = false;
				  for (int j=0; j<exp.length; j++)
				  {
					  String X= we.getText();
				      if (X.equals(exp[j])){
				    	  System.out.println(X + exp[j] );
				        match = true;
				        System.out.println("DropDown is verified successfully");
				      }
				    }
				  //Assert.assertTrue(match);
				  if(match = false){
					  Assert.fail();
				  }
				 }
				 Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			
			//TC_TV_375
			@And("^verify right click View as Chart$")
			public void verify_right_click_View_as_Chart() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				Actions action = new Actions(login.driver);
				WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
				action.contextClick(ele).pause(6000).build().perform();
				Actions action1 = new Actions(login.driver);
				WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas")));
				action1.moveToElement(ele1).pause(6000).build().perform();
				Thread.sleep(2000);
				Actions action2 = new Actions(login.driver);
				WebElement ele2 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas_chart")));
				action2.moveToElement(ele2).pause(6000).click().build().perform();
				//login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas_chart"))).click();
				Thread.sleep(2000);
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas_chartvalid"))).isDisplayed());
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			//TC_TV_376
			@And("^verify right click View as Map$")
			public void verify_right_click_View_as_Map() throws Throwable {
				CreateTable();
				Thread.sleep(8000);
				Actions action = new Actions(login.driver);
				WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
				CommonFunctionality.action.contextClick(ele).pause(2000).build().perform();
				//action.moveToElement(ele).contextClick(ele).build().perform();
				Actions action1 = new Actions(login.driver);
				WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas")));
				action1.moveToElement(ele1).pause(6000).build().perform();
				Thread.sleep(2000);
				Actions action2 = new Actions(login.driver);
				WebElement ele2 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas_map")));
				action2.moveToElement(ele2).pause(6000).click().build().perform();
				//login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas_map"))).click();
				Thread.sleep(2000);
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas_maptvalid"))).isDisplayed());
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			//TC_TV_377
			@And("^verify right click View as Histogram$")
			public void verify_right_click_View_as_Histogram() throws Throwable {
				CreateTable();
				Thread.sleep(8000);
				Actions action = new Actions(login.driver);
				WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
				CommonFunctionality.action.contextClick(ele).pause(2000).build().perform();
				//action.moveToElement(ele).contextClick(ele).pause(6000).build().perform();
				Actions action1 = new Actions(login.driver);
				WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas")));
				action1.moveToElement(ele1).pause(6000).build().perform();
				Thread.sleep(2000);
				Actions action2 = new Actions(login.driver);
				WebElement ele2 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas_histogram")));
				action2.moveToElement(ele2).pause(6000).click().build().perform();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas_tspanhistogram"))).click();
				Thread.sleep(2000);
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas_histogramvalid"))).isDisplayed());
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			//TC_TV_378
			@And("^verify right click View as Pie$")
			public void verify_right_click_View_as_Pie() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				Actions action = new Actions(login.driver);
				WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
				action.contextClick(ele).pause(6000).build().perform();
				Actions action1 = new Actions(login.driver);
				WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas")));
				action1.moveToElement(ele1).pause(6000).build().perform();
				Thread.sleep(2000);
				Actions action2 = new Actions(login.driver);
				WebElement ele2 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas_pie")));
				action2.moveToElement(ele2).pause(6000).click().build().perform();
				//login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas_pie"))).click();
				Thread.sleep(2000);
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas_pievalid"))).isDisplayed());
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			//TC_TV_379
			@And("^verify right click View as Heatmap$")
			public void verify_right_click_View_as_Heatmap() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				Actions action = new Actions(login.driver);
				WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
				action.contextClick(ele).pause(6000).build().perform();
				Actions action1 = new Actions(login.driver);
				WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas")));
				action1.moveToElement(ele1).pause(6000).build().perform();
				Thread.sleep(2000);
				Actions action2 = new Actions(login.driver);
				WebElement ele2 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas_heatmap")));
				action2.moveToElement(ele2).pause(6000).click().build().perform();
				//login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas_heatmap"))).click();
				Thread.sleep(2000);
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas_heatmapvalid"))).isDisplayed());
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			
			
			
			
			//TC_TV_380
			@And("^verify right click Calculated series sub dropdown$")
			public void verify_right_click_Calculated_series_sub_dropdown() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				Actions action = new Actions(login.driver);
				WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
				action.contextClick(ele).pause(6000).build().perform();
				Actions action1 = new Actions(login.driver);
				WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_calculate_series")));
				action1.moveToElement(ele1).pause(6000).build().perform();
				Thread.sleep(2000);
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_calculate_series_valid"))).isDisplayed());
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			//TC_TV_381
			@And("^verify right click appling function from Calculated series$")
			public void verify_right_click_appling_function_from_Calculated_series() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				String beforeseriesname = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_calculateseries_changeYoYSeries"))).getText();
				Thread.sleep(2000);
				Actions action = new Actions(login.driver);
				WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
				action.contextClick(ele).pause(6000).build().perform();
				Actions action1 = new Actions(login.driver);
				WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_calculate_series")));
				action1.moveToElement(ele1).pause(6000).build().perform();
				Thread.sleep(2000);
				Actions action2 = new Actions(login.driver);
				WebElement ele2 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_calculateseries_changeYoY")));
				action2.moveToElement(ele2).pause(6000).doubleClick().build().perform();
				Thread.sleep(2000);
				String afterseriesname = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_calculateseries_changeYoYSeries"))).getText();
				Thread.sleep(2000);
				if(!beforeseriesname.equalsIgnoreCase(afterseriesname)) {
					System.out.println("Verified");

				}
				else {
					Assert.fail();
				}
				Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			
			
			
			
			//TC_TV_382
			@And("^verify right click  Edit series option$")
			public void verify_right_click_Edit_series_option() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				Actions action = new Actions(login.driver);
				WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
				action.contextClick(ele).pause(6000).build().perform();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_Editseries"))).click();
				 Thread.sleep(2000);
					Assert.assertTrue(
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_Editseriesvalid"))).isDisplayed());
					Thread.sleep(2000);
					CommonFunctionality.Views_list();
			}
			
			
			
			//TC_TV_383
			@And("^verify right click Clear contents$")
			public void verify_right_click_Clear_contents() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				Actions action = new Actions(login.driver);
				WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
				action.contextClick(ele).pause(6000).build().perform();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_clearcontent"))).click();
				 Thread.sleep(2000);
					Assert.assertTrue(
							login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ResultTableVisual"))).isDisplayed());
					Thread.sleep(2000);
					CommonFunctionality.Views_list();
			}
			
			
			
			//TC_TV_384 
			@And("^verify right click  reset format$")
			public void verify_right_click_reset_format() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EdittableShowuncheckbox"))).click();
				 Thread.sleep(2000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
					Thread.sleep(2000);
					Actions action = new Actions(login.driver);
					WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_resetdate")));
					action.contextClick(ele).pause(6000).build().perform();
					Thread.sleep(2000);
					boolean resetrightclick =  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_reset"))).isEnabled();
					Thread.sleep(2000);
					if(resetrightclick ==true) {
						System.out.println("Verified");
						Thread.sleep(2000);
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_reset"))).click();
						Thread.sleep(2000);
						Assert.assertTrue(
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_calculateseries_changeYoYSeries"))).isDisplayed());
					}
					else {
						Assert.fail();
					}
					Thread.sleep(2000);
					CommonFunctionality.Views_list();
			}
			
			
			//TC_TV_385
			@And("^verify right click  reset format option if have no changes in visual$")
			public void verify_right_click_reset_format_option_if_have_no_changes_in_visual() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
					Actions action = new Actions(login.driver);
					WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
					action.contextClick(ele).pause(6000).build().perform();
					Thread.sleep(2000);
				String ressetrightclick = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_reset_disable"))).getAttribute("class");
					Thread.sleep(2000);
					if(ressetrightclick.contains("disabled")) {
						System.out.println("Verified");
					}
					else {
						Assert.fail();
					}
					Thread.sleep(2000);
					CommonFunctionality.Views_list();
			}
			
			//TC_TV_386
			@And("^verify right click download sub dropdown$")
			public void verify_right_click_download_sub_dropdown() throws Throwable {
				CreateTable();
				Thread.sleep(2000);
				Actions action = new Actions(login.driver);
				WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
				action.contextClick(ele).pause(6000).build().perform();
				Actions action1 = new Actions(login.driver);
				WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_download")));
				action1.moveToElement(ele1).pause(6000).build().perform();
				
				
				String[] exp = {"Table","View"};
				 List<WebElement> Viewasoptions = login.driver.findElements(By.xpath("(//span[@class='dropdown-submenu-icon'])[1]/following::ul[4]/li"));
				 for(WebElement we:Viewasoptions)  
				 {  
				  boolean match = false;
				  for (int j=0; j<exp.length; j++)
				  {
					  String X= we.getText();
				      if (X.equals(exp[j])){
				    	  System.out.println(X + exp[j] );
				        match = true;
				        System.out.println("DropDown is verified successfully");
				      }
				    }
				  //Assert.assertTrue(match);
				  if(match = false){
					  Assert.fail();
				  }
				 }
				 Thread.sleep(2000);
				CommonFunctionality.Views_list();
			}
			//TC_TV_387
			@And("^verify right click download > Table$")
			public void verify_right_click_download_Table() throws Throwable {
				CreateTable();
				Thread.sleep(5000);
				Actions action = new Actions(login.driver);
				WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
				action.contextClick(ele).pause(6000).build().perform();
				Actions action1 = new Actions(login.driver);
				WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_download")));
				action1.moveToElement(ele1).pause(6000).build().perform();
				Actions action2 = new Actions(login.driver);
				WebElement ele2 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_download_table")));
				action2.moveToElement(ele2).pause(6000).click().build().perform();
				Thread.sleep(2000);
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_download_tablevalid"))).isDisplayed());
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Downloadwindowclose"))).click();
				 Thread.sleep(2000);
					CommonFunctionality.Views_list();
				
			}
			//TC_TV_388
			@And("^verify right click download > View$")
			public void verify_right_click_download_View() throws Throwable {
				CreateTable();
				Thread.sleep(8000);
				Actions action = new Actions(login.driver);
				WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
				CommonFunctionality.action.contextClick(ele).pause(2000).build().perform();
				//action.moveToElement(ele).contextClick(ele).pause(6000).build().perform();
				Actions action1 = new Actions(login.driver);
				WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_download")));
				action1.moveToElement(ele1).pause(6000).build().perform();
				Actions action2 = new Actions(login.driver);
				WebElement ele2 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_download_view")));
				action2.moveToElement(ele2).pause(6000).click().build().perform();
				Thread.sleep(2000);
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_download_viewvalid"))).isDisplayed());
				Thread.sleep(2000);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Downloadwindowclose"))).click();
				 Thread.sleep(2000);
					CommonFunctionality.Views_list();
			}
			
			
	//Create_Table
	public void CreateTable() throws Throwable {
		Thread.sleep(2000);
		for (int i = 1; i <= 1; i++) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//ul[@class='search-series-list']/li[" + i + "]/div/a/div[2]")).click();
		}
		Thread.sleep(5000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_T);
	}
	
	
	public static String getFileExtension(File file) {
	    String name = file.getName();
	    try {
	        return name.substring(name.lastIndexOf(".") + 1);
	       
	    } catch (Exception e) {
	        return "";
	    }
	}
	
	
	
}
 





