package CDMNext.StepDefinations;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Sprintcases_5_4 {
	RecentDownloads recent=new RecentDownloads();
	Actions a=new Actions(login.driver);
	@And("^Search for series with id \"([^\"]*)\"$")
	public void search_for_series_with_id(String arg1) throws Throwable {
	   login.driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(arg1,Keys.ENTER);
	   Thread.sleep(3000);
	}

	@And("^Click on More actions and Series Info$")
	public void click_on_More_actions_and_Series_Info() throws Throwable {
	    login.driver.findElement(By.xpath("//span[@value='LIST']")).click();
	   a.contextClick().build().perform();
	   login.driver.findElement(By.xpath("//*[contains(text(),'Series Info')]")).click();
	   Thread.sleep(2000);
	   
	   
	}

	@Then("^Click on Statistics tab$")
	public void click_on_Statistics_tab() throws Throwable {
       login.driver.switchTo().activeElement();
       login.driver.findElement(By.xpath("//*[contains(text(),'Statistics')]")).click();
       List<WebElement> date=login.driver.findElements(By.xpath("//div[@class='series-changes-time-line--date']"));
       for(WebElement dateoverlapped:date)
       {
    	  
    		   Assert.assertEquals(dateoverlapped.isDisplayed(),true);
    	  System.out.println( dateoverlapped.getText().toString());
           
	   }
	}
	@Given("^Select (\\d+) series id$")
	public void select_series_id(int arg1) throws Throwable {
		 Thread.sleep(3000);
		 login.driver.findElement(By.xpath("//span[@value='LIST']")).click();
		 List<WebElement> series=login.driver.findElements(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']"));
		 for(int i=1;i<=arg1;i++)
		 {
			 login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])["+i+"]")).click();
		 }
	}

	@Given("^Right click and click on View as Chart$")
	public void right_click_and_click_on_View_as_Chart() throws Throwable {
		
		 a.contextClick().build().perform();
		 login.driver.findElement(By.xpath("//*[contains(text(),'View as Chart')]")).click();
		 login.driver.switchTo().activeElement();
	String str= login.driver.findElement(By.xpath("//div[@class='modal-content sphere-modal__content']")).getText().toString();
		Assert.assertEquals(str,"You cannot create a chart with more than 30 series. Proceed with 30 series?");
	}
	@Given("^Select any series id \"([^\"]*)\"$")
	public void select_any_series_id(String arg1) throws Throwable {
		login.driver.findElement(By.xpath("//span[@value='LIST']")).click();
		search_for_series_with_id(arg1);
	}

	@And("^Add to My series$")
	public void add_to_My_series() throws Throwable {
		
		login.driver.findElement(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']")).click();
		 a.sendKeys((Keys.chord("a"))).build().perform();
	    Thread.sleep(2000);
	}

	@Then("^Check the series id and click on Open Function editior$")
	public void check_the_series_id_and_click_on_Open_Function_editior() throws Throwable {
	    
		a.moveToElement(login.driver.findElement(By.className("series-name-field--text"))).build().perform();
		String str=login.driver.findElement(By.xpath("//td[contains(text(),'Series id')]/following::td[1]")).getText();
		System.out.println(str);
		login.driver.findElement(By.xpath("//span[@class='table-container--checkbox svg-checkbox input-control__grey']")).click();
		login.driver.findElement(By.className("function-editor-window--icon")).click();
		WebElement frequency=login.driver.findElement(By.xpath("//div[contains(text(),'Frequency Transformation')]"));
		Assert.assertEquals(frequency.isDisplayed(),true);
	}
	@And("^Check the series id checkbox and click on the fx icon in toolbar$")
	public void check_the_series_id_checkbox_and_click_on_the_fx_icon_in_toolbar() throws Throwable {
		//login.driver.findElement(By.xpath("//span[@class='table-container--checkbox svg-checkbox input-control__grey']")).click();
		a.moveToElement(login.driver.findElement(By.xpath("//span[@class='series-name-field--text']"))).build().perform();
		login.driver.findElement(By.xpath("//div[@title='Apply Function']")).click();
	}

	@Then("^select any unit multiplier \"([^\"]*)\"$")
	public void select_any_unit_multiplier(String arg1) throws Throwable {
		WebElement quickfun=login.driver.findElement(By.xpath("//div[contains(text(),' Unit multiplier')]/following::div[@data-id='UNIT_"+arg1+"']"));
		Assert.assertEquals(quickfun.isDisplayed(),true);
	    
	}
	@Given("^Add any series to My series \"([^\"]*)\"$")
	public void add_any_series_to_My_series(String arg1) throws Throwable {
		select_any_series_id(arg1);
		add_to_My_series();
	}

	@Given("^Click on fx icon from the toolbar$")
	public void click_on_fx_icon_from_the_toolbar() throws Throwable {
		check_the_series_id_checkbox_and_click_on_the_fx_icon_in_toolbar();
	}

	@Given("^Hover on the %PoP function$")
	public void hover_on_the_PoP_function() throws Throwable {
	    a.moveToElement(login.driver.findElement(By.xpath("//div[contains(text(),' Calculate change')]/following::div[contains(text(),'%PoP')]"))).build().perform();
	    
	}

	@Then("^it should display as follows$")
	public void it_should_display_as_follows() throws Throwable {
		String str =" ";
     List<WebElement> hover= login.driver.findElements(By.xpath("//div[@class='tooltip tooltip__visible']/div/div"));
     for(WebElement mouse:hover)
     {
    	 str=str+mouse.getText();
     }
       System.out.println(str);
       Assert.assertEquals(str," % Period-over-Period (%PoP)Syntax: %CHANGE(Over Period; 1; No)Description: Gets the percentage change over time");
       
    	   System.out.println("equal");
       
     }
	@Given("^Select any two series id \"([^\"]*)\" and create Chart$")
	public void select_any_two_series_id_and_create_Chart(String arg1) throws Throwable {
		select_any_series_id(arg1);
		List<WebElement> series=login.driver.findElements(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']"));
		Thread.sleep(2000);
		for(WebElement serieslist:series)
		{
			serieslist.click();
		}
		a.sendKeys((Keys.chord("c"))).build().perform();
		Thread.sleep(2000);
	}

	

	@And("^Click on view1$")
	public void click_on_view() throws Throwable {

         Thread.sleep(2000);
         login.driver.findElement(By.xpath("//a[@title='View 1']/span")).click();
	}

	@Then("^Click on Edit Views$")
	public void click_on_Edit_Views() throws Throwable {
		login.driver.findElement(By.xpath("//*[contains(text(),'Edit Views')]")).click();
		Thread.sleep(2000);
		Assert.assertEquals(login.driver.findElement(By.xpath("//div[contains(text(),'View 2')]/following::div[@title='Chart']")).isEnabled(),true);


	}
	@Then("^Drag the view(\\d+) and drop in view(\\d+)$")
	public void drag_the_view_and_drop_in_view(int arg1, int arg2) throws Throwable {
      
     a.dragAndDrop(login.driver.findElement(By.xpath("//div[contains(text(),'View 2')]/following::div[@title='Chart']"))
    		 ,login.driver.findElement(By.xpath("//div[contains(text(),'View 1')]/following::div[@title='Chart'][1]"))).build().perform();
     Thread.sleep(2000);
     Assert.assertEquals(login.driver.findElement(By.xpath("//div[contains(text(),'View 1')]/following::div[@title='Chart'][2]")).isDisplayed(), true);
	}
	@And("^Double click on the legend$")
	public void double_click_on_the_legend() throws Throwable {
		login.driver.findElement(By.xpath("*//button[contains(text(),'Apply')]")).click();
	   
		a.moveToElement(login.driver.findElement(By.xpath("(//span[@class='series-edit--title series-edit--title__editable'])[1]"))).doubleClick().perform();
		Thread.sleep(2000);
	}

	@Then("^The configuration menu should be displayed$")
	public void the_configuration_menu_should_be_displayed() throws Throwable {
	  Assert.assertEquals(login.driver.findElement(By.xpath("//div[@class='popover--header ui-draggable-handle']")).isDisplayed(),true);
	}
	@Given("^Open the function editor window \"([^\"]*)\"$")
	public void open_the_function_editor_window(String arg) throws Throwable {
		add_any_series_to_My_series(arg);
		login.driver.findElement(By.xpath("//span[@class='table-container--checkbox svg-checkbox input-control__grey']")).click();
		login.driver.findElement(By.className("function-editor-window--icon")).click();
	    
	}
	@Then("^Check if the following function description are same as follows:\"([^\"]*)\",\"([^\"]*)\"\"$")
	
	public void check_if_the_following_function_description_are_same_as_follows(String arg1,String arg2) throws Throwable {
            login.driver.findElement(By.xpath("//div[contains(text(),'By function')]")).click();
       String arg3[]=arg1.split(";");
       String arg4[]=arg2.split(";");
       for(int i=0,j=0;i<=arg3.length-1;i++)
       {
    	   Thread.sleep(1000);
    	   login.driver.findElement(By.xpath("//input[@placeholder='Search...']")).clear();
    	   Thread.sleep(1000);
    	   login.driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys(arg3[i],Keys.ENTER);
    	 login.driver.findElement(By.xpath("//div[@class='function-item'][1]")).click();
    	 Thread.sleep(2000);
    	
    	
    	System.out.println(arg4[j]);
    	Assert.assertEquals(login.driver.findElement(By.xpath("(//div[@class='function-data--description'])[2]")).getText(),arg4[j]);
    	j++;
       }
	}

@Then("^Check if the icons C and S are displayed infront of the series$")
public void check_if_the_icons_C_and_S_are_displayed_infront_of_the_series() throws Throwable {
    List<WebElement> series=login.driver.findElements(By.className("series-item--name"));
    for(int i=1;i<=series.size();i++)
    {
    	Assert.assertEquals(login.driver.findElement(By.xpath("(//span[@class='status-icon status-icon__key'])["+i+"]")).isDisplayed(),true);
    	Assert.assertEquals(login.driver.findElement(By.xpath("(//span[@class='status-icon status-icon__has-replacements'])["+i+"]")).isDisplayed(),true);
    	   
    }
}
@And("^Refresh the page$")
public void refresh_the_page() throws Throwable {
	Thread.sleep(2000);
	login.driver.navigate().refresh();
    
}

@Then("^The continuous tab and replacements tab both should be present$")
public void the_continuous_tab_and_replacements_tab_both_should_be_present() throws Throwable {
	Thread.sleep(1000);
	check_if_the_icons_C_and_S_are_displayed_infront_of_the_series();
}
/*@And("^Click on Edit Chart$")
public void click_on_Edit_Chart() throws Throwable {
   Thread.sleep(1000);
   login.driver.findElement(By.xpath("//button[contains(text(),'Edit Chart')]")).click();
}*/

@And("^Check if Under left axis Step option is present$")
public void check_if_Under_left_axis_Step_option_is_present() throws Throwable {
    Thread.sleep(1000);
    Assert.assertEquals(login.driver.findElement(By.xpath("//div[@class='tabs__tab-item active']/following::div[contains(text(),'Step')][1]")).isDisplayed(),true);
}

@And("^Check if the Number format is at the first place$")
public void check_if_the_Number_format_is_at_the_first_place() throws Throwable {
   Thread.sleep(1000);
   Assert.assertEquals(login.driver.findElement(By.xpath("//div[@class='tabs__tab-item active']/following::div[contains(text(),'Number format:')]")).isDisplayed(),true);
}

@Then("^Check if the Min/MAX value tab has only input No up and down arrows$")
public void check_if_the_Min_MAX_value_tab_has_only_input_No_up_and_down_arrows() throws Throwable {
   
	Assert.assertEquals(login.driver.findElement(By.xpath("//div[@class='tabs__tab-item active']/following::div[contains(text(),'Min/Max value')]/following::input[@name='interval_min']")).isDisplayed(),true);
	Assert.assertEquals(login.driver.findElement(By.xpath("//div[@class='tabs__tab-item active']/following::div[contains(text(),'Min/Max value')]/following::input[@name='interval_max']")).isDisplayed(),true);
}
@And("^In Tooltip open Advanced setting popup$")
public void in_Tooltip_open_Advanced_setting_popup() throws Throwable {
    login.driver.findElement(By.xpath("//div[@title='Tooltips. Configure the tooltips in the chart.']//div[@title='Open advanced settings popup']")).click();
    
}

@And("^Expand Items$")
public void expand_Items() throws Throwable {
  login.driver.findElement(By.xpath("(//div[contains(text(),'Items')]/following::div[@class='icon-collapse'])[1]")).click();

}

@Then("^Check if the Name and Region are displayed by default$")
public void check_if_the_Name_and_Region_are_displayed_by_default() throws Throwable {
	List<WebElement>tooltip=login.driver.findElements(By.xpath("//div[@class='select-behaviour--multi-select-item']/span"));
	for(WebElement tip:tooltip)
	{
		String str=tip.getText();
		if(str.equalsIgnoreCase("name")||str.equalsIgnoreCase("region")||str.equalsIgnoreCase("frequency"))
		{
			System.out.println(str);
		}
	}


}
@And("^In tooltip click on dropdown beside Date$")
public void in_tooltip_click_on_dropdown_beside_Date() throws Throwable {
   login.driver.findElement(By.xpath("//div[@title='Tooltips. Configure the tooltips in the chart.']//div[@class='context-menu-control--icon']")).click();
   

}

@And("^Select Frequency Checkbox$")
public void select_Frequency_Checkbox() throws Throwable {
    login.driver.findElement(By.xpath("//span[contains(text(),'Frequency')]/parent::label/span[@class='input-control--indicator']")).click();
}

@And("^Hover on the tooltips on the chart visual$")
public void hover_on_the_tooltips_on_the_chart_visual() throws Throwable {
	in_Tooltip_open_Advanced_setting_popup();
	expand_Items();
	}

@Then("^Check if the Frequency is displayed on the new line$")
public void check_if_the_Frequency_is_displayed_on_the_new_line() throws Throwable {
	check_if_the_Name_and_Region_are_displayed_by_default();
}
@Given("^Select any udd series$")
public void select_any_udd_series() throws Throwable {
    login.driver.findElement(By.xpath("//button[contains(text(),'Import Series')]")).click();
    login.driver.findElement(By.xpath("//div[contains(text(),'or click to select a file from your computer')]")).click();
    Robot robot = new Robot();
	 robot.setAutoDelay(2000);
	   
      StringSelection selection = new StringSelection("C:\\Users\\tbemineni\\Desktop\\New folder\\Cucumber_project\\AutoIT\\udd_template.xlsx");
      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);

      robot.setAutoDelay(1000);

      robot.keyPress(KeyEvent.VK_CONTROL);
      robot.keyPress(KeyEvent.VK_V);

      robot.keyRelease(KeyEvent.VK_CONTROL);
      robot.keyRelease(KeyEvent.VK_V);

      robot.setAutoDelay(1000);

      robot.keyPress(KeyEvent.VK_ENTER);
      robot.keyRelease(KeyEvent.VK_ENTER);
}

@Then("^Open SSP$")
public void open_SSP() throws Throwable {
Thread.sleep(2000);
a.moveToElement(login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"))).click().perform();
login.driver.switchTo().activeElement();
int faq=login.driver.findElements(By.xpath("//div[@class='main-series-information--link main-series-information--ask'][1]")).size();
int ask_question=login.driver.findElements(By.xpath("//div[@class='main-series-information--link main-series-information--ask'][2]")).size();
int watch=login.driver.findElements(By.xpath("(//span[@class='preview-series-data-actions--label'])[2]")).size();
if(faq==0)
{
	System.out.println("equal");
}
if(ask_question==0)
{
	System.out.println("equal");
}
if(watch==0)
{
	System.out.println("equal");
}
}
@Given("^Click on the imported tab$")
public void click_on_the_imported_tab() throws Throwable {
    Thread.sleep(2000);
    login.driver.findElement(By.xpath("//span[contains(text(),'Imported')]")).click();
}

@And("^Click on the sort dropdown$")
public void click_on_the_sort_dropdown() throws Throwable {
	if(login.driver.findElement(By.xpath("(//span[@class='custom-select-title--reset-icon'])[2]")).isDisplayed())
{
	login.driver.findElement(By.xpath("(//span[@class='custom-select-title--reset-icon'])[2]")).click();
}
	login.driver.findElement(By.xpath("(//span[contains(text(),'Sort By')])[2]")).click();
}

@Then("^Select the \"([^\"]*)\" options$")
public void select_the_options(String str) throws Throwable {
   
    
    	login.driver.findElement(By.xpath("//div[@data-id='"+str+"']")).click();
    	if(str.equalsIgnoreCase("series_name"))
    	{
    		int series=login.driver.findElements(By.className("series-item--name")).size();
    		if(series>0)
    		{
    			System.out.println("present");
    		}
    	}
    	if(str.equalsIgnoreCase("SERIESCOUNTRY"))
    	{
    		int series=login.driver.findElements(By.className("series-item--name")).size();
    		if(series>0)
    		{
    			System.out.println("present");
    		}
    	}
    	if(str.equalsIgnoreCase("FREQUENCY"))
    	{
    		int series=login.driver.findElements(By.className("series-item--name")).size();
    		if(series>0)
    		{
    			System.out.println("present");
    		}
    	}
    
	 if(str.equalsIgnoreCase("SOURCENAME"))
	{
		int series=login.driver.findElements(By.className("series-item--name")).size();
		if(series>0)
		{
			System.out.println("present");
		}
	}
}
    @Given("^In Search tab enter any \"([^\"]*)\" and click on search icon$")
   public void in_Search_tab_enter_any_and_click_on_search_icon(String arg1) throws Throwable {
		 click_on_the_imported_tab();
		 login.driver.findElement(By.xpath("//input[@placeholder='Search']")).clear();
		 login.driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(arg1,Keys.ENTER);		 
	 }

	 @Then("^The results should be displayed$")
	 public void the_results_should_be_displayed() throws Throwable {
		 int series=login.driver.findElements(By.className("series-item--name")).size();
			if(series>0)
			{
				System.out.println("present");
			}
        
	 }
	 @Given("^Click on Imported tab available under Data on left of the Window$")
	 public void click_on_Imported_tab_available_under_Data_on_left_of_the_Window() throws Throwable {

		 click_on_the_imported_tab();
	 }

	 @Then("^Dont select any series from imported tab$")
	 public void dont_select_any_series_from_imported_tab() throws Throwable {

           Assert.assertEquals(login.driver.findElement(By.xpath("//button[@class='index-module_button__xs646 index-module_small__6GGgk']")).isEnabled(),false);
	 }

	 @And("^Select some series from imported tab$")
	 public void select_some_series_from_imported_tab() throws Throwable {

            List<WebElement> series= login.driver.findElements(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']"));
            for(WebElement series1:series)
            {
            	series1.click();
            }
	 }

	 @And("^Click on Edit series in Excel button$")
	 public void click_on_Edit_series_in_Excel_button() throws Throwable {

		 login.driver.findElement(By.xpath("//button[@class='index-module_button__xs646 index-module_small__6GGgk']")).click();
	 }

	 @Then("^Download the Excel file with settings as below \"([^\"]*)\"$")
	 public void download_the_Excel_file_with_settings_as_below(String arg1) throws Throwable {
		
         
         String arg2[]=arg1.split(";");
         Thread.sleep(3000);
         String path2 = "C:\\Users\\tbemineni\\Downloads\\Series.xlsx";
     	
         FileInputStream s1=new FileInputStream(path2);
         XSSFWorkbook test = new XSSFWorkbook(s1); 
         XSSFSheet sheet = test.getSheetAt(0);
         XSSFRow row; 
         XSSFCell cell;
         Iterator rows = sheet.rowIterator();
         while (rows.hasNext())
         {
             row=(XSSFRow) rows.next();
             Iterator cells = row.cellIterator();
             while (cells.hasNext())
             {
                 cell=(XSSFCell) cells.next(); 
                 if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
                 {
                     System.out.print(cell.getStringCellValue()+" ");
                 }
                 else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
                 {
                     System.out.print(cell.getNumericCellValue()+" ");
                 }
                 else 
                 {
                 	DataFormatter dataFormatter = new DataFormatter();
                 	String cellStringValue = dataFormatter.formatCellValue(row.getCell(1));
                 	System.out.println ("Is shows data as show in Excel file" + cellStringValue);
                 }
             }
        		 
           }
            
                    	




	 }
	 @Then("^The downloaded file should reflect under recent downloads$")
	 public void the_downloaded_file_should_reflect_under_recent_downloads() throws Throwable {
		 
			recent.click_on_history_download_button1("Series.xlsx");
	 }
	 @And("^Create empty Views$")
	 public void create_empty_Views() throws Throwable {
         for(int i=1;i<=2;i++)
         {
        	 
         
        login.driver.findElement(By.xpath("//div[@title='Create new View tab']")).click();
         }
	 }

	 @Then("^DND Visual from View(\\d+) to Empty View(\\d+)$")
	 public void dnd_Visual_from_View_to_Empty_View(int arg1,int arg2) throws Throwable {
		 
		 login.driver.findElement(By.xpath("//*[contains(text(),'Edit Views')]")).click();
			Thread.sleep(2000);
			a.dragAndDrop(login.driver.findElement(By.xpath("//div[contains(text(),'View 1')]/following::div[@title='Chart']"))
		    		 ,login.driver.findElement(By.xpath("//div[contains(text(),'View 2')]"))).build().perform();
		     Thread.sleep(4000);
		     Assert.assertEquals(login.driver.findElement(By.xpath("//div[contains(text(),'View 1')]/following::div[@title='Chart'][1]")).isDisplayed(), true);

	 }
	 @Given("^Click on edit series on view tab$")
	 public void click_on_edit_series_on_view_tab() throws Throwable {
		 Thread.sleep(2000);
          login.driver.findElement(By.xpath("//button[contains(text(),'Edit Series')]")).click();
          
          
          

	 }

	 @Given("^Hover the mouse on the series name$")
	 public void hover_the_mouse_on_the_series_name() throws Throwable {
		 Thread.sleep(2000);
         a.moveToElement(login.driver.findElement(By.xpath("(//div[@class='series-name--title'])[1]"))).build().perform();

	 }

	 @Then("^Check the background selection color of a series$")
	 public void check_the_background_selection_color_of_a_series() throws Throwable {

          String str=login.driver.findElement(By.xpath("//div[@class='index-module_swatch_button_item_color__gAHg1']")).getAttribute("style");
          System.out.println(str);
	 }
	 @Then("^Click on the cross icon besides the series name$")
	 public void click_on_the_cross_icon_besides_the_series_name() throws Throwable {
	    Thread.sleep(2000);
	    a.moveToElement(login.driver.findElement(By.xpath("(//span[@title='Remove series'])[1]"))).click().build().perform();
	    login.driver.switchTo().activeElement();
	   String str= login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']")).getText();
	   System.out.println(str);
	   Assert.assertEquals(str, "Are you sure you want to delete the series \"Suresh\"?\r\n"+"Other users from your account won't access it anymore.\r\n"+"\r\n"+"Warning: you cannot undo this action.\r\n"+"CancelDelete forever");
	 }
	 @Given("^Hover the mouse on the imported series name$")
	 public void hover_the_mouse_on_the_imported_series_name() throws Throwable {
		 Thread.sleep(2000);
         a.moveToElement(login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"))).build().perform();

	 }
	 @And("^Click on the cross icon$")
	 public void click_on_the_cross_icon() throws Throwable {

		 Thread.sleep(2000);
		    a.moveToElement(login.driver.findElement(By.xpath("(//span[@title='Remove series'])[1]"))).click().build().perform();
		    login.driver.switchTo().activeElement();
	 }
	 @Then("^select \"([^\"]*)\" opti$")
	 public void select_opti(String str)
	 {
		 login.driver.findElement(By.xpath("//button[contains(text(),'"+str+"')]")).click();
	 }
	 @Given("^login from User2 account$")
	 public void login_from_User_account() throws Throwable {
		 
	     
	 }

	 @Given("^Hover the mouse of the imported series by User1$")
	 public void hover_the_mouse_of_the_imported_series_by_User() throws Throwable {
	     
	 }

	 @Then("^Check the remove series icon from User2$")
	 public void check_the_remove_series_icon_from_User() throws Throwable {
	     
	 }
	 

	 @Then("^Check the user data tab or imported option on search panel$")
	 public void check_the_user_data_tab_or_imported_option_on_search_panel() throws Throwable {
		 Assert.assertEquals(login.driver.findElement(By.xpath("//span[contains(text(),'Imported')]")).isDisplayed(),false);

	 }
	 @Then("Try to import  same imported file again$")
	 public void try_to_import_same_imported_file_again() throws Throwable
	 {
		 select_any_udd_series();
		 login.driver.switchTo().activeElement();
		String str= login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']")).getText();
		Assert.assertEquals(str,"Invalid value in the cell C8-SssT005. A series with the same user series ID has been used already by you or your account member. Please specify a different ID.\r\n" + 
				"\r\n" + 
				"Invalid value in the cell B8-Sss006. A series with the same user series ID has been used already by you or your account member. Please specify a different ID.\r\n" + 
				"Ok");
	 }
	 @And("^Open ssp windows$")
		public void open_ssp_windows() throws Throwable {
			login.Log4j.info("Clicking on  Series tab ");
			CommonFunctionality.getElementByProperty(login.driver, "Series", 30).click();
			a.moveToElement(login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"))).click().perform();
			login.driver.switchTo().activeElement();
			String str=login.driver.findElement(By.xpath("//span[@class='main-series-information--link']/span")).getText();
			System.out.println(str);
		}
	 @And("^Add these series into my series panel$")
	 public void add_these_series_into_my_series_panel() throws Throwable {
		 List<WebElement> series=login.driver.findElements(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']"));
			Thread.sleep(2000);
			for(WebElement serieslist:series)
			{
				serieslist.click();
			}
			a.sendKeys((Keys.chord("a"))).build().perform();
			Thread.sleep(2000);
	 }

	 @Then("^Apply currency conversion function on above series$")
	 public void apply_currency_conversion_function_on_above_series() throws Throwable {
		 login.driver.findElement(By.xpath("//input[@name='select_all_dataselection']/following::span[@class='input-control--indicator']")).click();
		 Thread.sleep(2000);
			login.driver.findElement(By.className("function-editor-window--icon")).click();
		 login.driver.findElement(By.xpath("//div[contains(text(),'By function')]")).click();
		 login.driver.findElement(By.xpath("//input[@placeholder='Search...']")).clear();
  	   Thread.sleep(1000);
  	   login.driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys("CONVERTCUR",Keys.ENTER);
  	 a.moveToElement(login.driver.findElement(By.xpath("//div[@class='function-item'][1]"))).doubleClick().build().perform();
  	 Thread.sleep(2000);
  	 login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
  	   login.driver.switchTo().activeElement();
  	   String str=login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']")).getText();
  	   Assert.assertEquals(str,"The function cannot be applied to \"Policy Rate: Month End: Main Refinancing Operations\" series.\r\n" + 
  	   		"Continue operation with other function(s)?\r\n" + 
  	   		"CancelOk]");
	 }
	 @And("^Apply Aggregate Sum,yearly,december$")
	 public void apply_Aggregate_Sum_yearly_december() throws Throwable {
		 check_the_series_id_checkbox_and_click_on_the_fx_icon_in_toolbar();
		 login.driver.findElement(By.xpath("//div[@data-id='SUM']")).click();
	 }

	 @Then("^Download base and transformed series into excel$")
	 public void download_base_and_transformed_series_into_excel() throws Throwable {
		login.driver.findElement(By.xpath("//span[contains(text(),'Download')]")).click();
		login.driver.switchTo().activeElement();
		login.driver.findElement(By.xpath("(//span[contains(text(),'Download')])[3]")).click();
		Thread.sleep(2000);
		 String path2 = "C:\\Users\\tbemineni\\Downloads\\Industrial Production Civil Steel Ships.xlsx";
	     	
         FileInputStream s1=new FileInputStream(path2);
         XSSFWorkbook test = new XSSFWorkbook(s1); 
         XSSFSheet sheet = test.getSheetAt(0);
         XSSFRow row; 
         XSSFCell cell;
         Iterator rows = sheet.rowIterator();
         while (rows.hasNext())
         {
             row=(XSSFRow) rows.next();
             Iterator cells = row.cellIterator();
             while (cells.hasNext())
             {
                 cell=(XSSFCell) cells.next(); 
                 if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
                 {
                     System.out.print(cell.getStringCellValue()+" ");
                 }
                 else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
                 {
                     System.out.print(cell.getNumericCellValue()+" ");
                 }
                 else 
                 {
                 	DataFormatter dataFormatter = new DataFormatter();
                 	String cellStringValue = dataFormatter.formatCellValue(row.getCell(1));
                 	System.out.println ("Is shows data as show in Excel file" + cellStringValue);
                 }
             }
        		 
           }
		
	 }
	 @Given("^Verify the footnotes of series \"([^\"]*)\"$")
	 public void verify_the_footnotes_of_series(String arg1) throws Throwable {
		 select_any_series_id(arg1);
		 a.moveToElement(login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"))).contextClick().perform();
		 a.moveToElement(login.driver.findElement(By.xpath("//span[@title='Footnotes']"))).click().perform();
	 }

	 @Then("^Check for the characters language$")
	 public boolean check_for_the_characters_language() throws Throwable {
	     login.driver.switchTo().activeElement();
	     String str=login.driver.findElement(By.xpath("//div[@class='empty-selection--description']")).getText();
	     for(int i=0; i < str.length(); i++) {
	         Boolean flag = Character.isDigit(str.charAt(i));
	         if(flag) {
	            System.out.println("'"+ str.charAt(i)+"' is a number");
	         }
	         else {
	            System.out.println("'"+ str.charAt(i)+"' is a letter");
	         }
	      }
	     Pattern letter = Pattern.compile("[a-zA-z]");
	        Pattern digit = Pattern.compile("[0-9]");
	        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
	        //Pattern eight = Pattern.compile (".{8}");


	           Matcher hasLetter = letter.matcher(str);
	           Matcher hasDigit = digit.matcher(str);
	           Matcher hasSpecial = special.matcher(str);

	           return hasLetter.find() && hasDigit.find() && hasSpecial.find();
	 }







}
