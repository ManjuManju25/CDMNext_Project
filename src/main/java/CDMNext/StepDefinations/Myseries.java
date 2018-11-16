package CDMNext.StepDefinations;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class Myseries {
	public String rest;
	WebElement element;
	WebElement ulelement;


	@And("^Select the Expand Icon$")
	public void select_the_Expand_Icon() throws Throwable {
		Thread.sleep(6000);
		login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[3]/div[2]/div[1]/div[1]/div")).click(); 
	}

	@And("^Verify View panel which should be Expanded$")
	public void verify_View_panel_which_should_be_Expanded() throws Throwable {
		Thread.sleep(6000);
		if(login.driver.findElements(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[3]/div[1]/div[1]/div")).size() != 0)
		{
			System.out.println("Expand icon is working Successfully");
			}else
			{
				 Assert.fail("Expand icon is NOT working Successfully");
			}
		login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[3]/div[1]/div[1]/div")).click();
	}
	
	@And("^deselect the series if the Series is present$")
	public void deselect_the_series_if_the_Series_is_present() throws Throwable {
		Thread.sleep(6000);
		login.driver.findElement(By.xpath("//a[contains(text(),'My Series')]")).click();
		Thread.sleep(6000);
		if  (!login.driver.findElements(By.xpath("//span[@class='input-control--indicator']")).isEmpty())
		{
			Thread.sleep(6000);
			login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
			Thread.sleep(6000);
			login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click();
		}else
		{
			System.out.println("No series found at the my series panel");
		}
			
	}
	
	@And("^Verify for \"([^\"]*)\" series functionality under \"([^\"]*)\" tab$")
	public void verify_for_series_functionality_under_tab(String arg1, String arg2) throws Throwable {
       Thread.sleep(6000);
		if  (login.driver.findElements(By.xpath("//div[@class='insight-data disabled']/div[1]/div[1]/div/div/div")).size() != 0)
		{
			System.out.println("Related Series option is Enabled");
		}
		if  (login.driver.findElements(By.xpath("//div[@class='insight-action-panel--btn insight-action-panel--btn__disabled'] ")).size() != 0)
		{
			System.out.println("Rename option is disabled");
		}
		if  (login.driver.findElements(By.xpath("//div[@class='insight-data disabled']/div/div[7]/div")).size() != 0)
		{
			System.out.println("Group the series option is disabled");
		}
		if  (login.driver.findElements(By.xpath("//div[@class='insight-data disabled']/div/div[8]")).size() != 0)
		{
			System.out.println("Rename option is disabled");
		}
		if  (login.driver.findElements(By.xpath("//div[@class='insight-data disabled']/div/div[14]")).size() != 0)
		{
			System.out.println("Cut option is disabled");
		}
		else{
			 Assert.fail("My series Option are Enadled even though Series are not present ");
		}
	}
	@And("^Select some series to my series tab$")
	public void select_some_series_to_my_series_tab() throws Throwable {
		
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
		//List<WebElement> objLinks = login.driver.findElements(By.xpath("//a[@class='series-list-item--container internal-series series-list-item--container__with_actions']"));
		//System.out.println("Total Size are- " + objLinks.size());
		
		for(int i=1;i<=1;i++){
			Thread.sleep(2000);
			 login.driver.findElement(By.xpath("//ul[@class='search-series-list scrollable']/li[" + i + "]/div/a/div[2]")).click();
		}
		Thread.sleep(6000);
		 Robot r = new Robot();
		 r.keyPress(KeyEvent.VK_A);
		 r.keyRelease(KeyEvent.VK_A);
	}

	@And("^To right panel$")
	public void to_right_panel() throws Throwable {
		Thread.sleep(6000);
		
		Actions action = new Actions(login.driver);
		WebElement we = login.driver.findElement(By.xpath("//div[@class='name-block two-rows-item ']"));
		action.moveToElement(we).build().perform();
		
		String Text;
		Text = we.getAttribute("title");
		System.out.println(Text);
		String[]  array = Text.split("\n");
		int size=array.length;
		System.out.println(size);
		for(int i=0;i<array.length;i++){
		}
		System.out.println("Name of the Series = :- "+ array[1]);
		 String NameofSeries = array[1];
		    String[] result = NameofSeries.split(" ", 2);
		    String first = result[0];
		   rest = result[1];
		   // System.out.println("First Expected String : " + first);
		    System.out.println("Expected String : " + rest);
		  Thread.sleep(6000);
			login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
			 Thread.sleep(6000);
				login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[5]")).click();	
			
			
			
	}

	@And("^Verify for \"([^\"]*)\" in \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void verify_for_in(String arg1, String arg2, String arg3, String arg4) throws Throwable {
		Thread.sleep(6000);
		 if(arg2.equalsIgnoreCase(arg2))
		 {
			 Thread.sleep(6000);
			 login.driver.findElement(By.xpath("//div[@class='series-preview--mode__chart']")).click();
			 
			 
			   Actions action = new Actions(login.driver);
				WebElement we = login.driver.findElement(By.xpath("//span[@class='series-edit--title']"));
				action.moveToElement(we).build().perform();
				
				String Text;
				Text = we.getAttribute("title");
				System.out.println(Text);
				String[]  array = Text.split("\n");
				int size=array.length;
				System.out.println(size);
				for(int i=0;i<array.length;i++){
				}
				System.out.println("Name of the Series = :- "+ array[1]);
				 String NameofSeries = array[1];
				    String[] result = NameofSeries.split(" ", 2);
				    //String first = result[0];
				    String inchart = result[1];
				   // System.out.println("First Expected String : " + first);
				    System.out.println("Expected String : " + inchart);
				    if(rest.equalsIgnoreCase(inchart)){
						System.out.println("Preview Series functionality in Chart is Working Successfully");
					}
					else{
						 Assert.fail("Preview Series functionality in Chart is NOT Working Successfully");
					}
		 }
		 if(arg3.equalsIgnoreCase(arg3))
		 {
			 Thread.sleep(6000);
			 login.driver.findElement(By.xpath("//div[@class='series-preview--mode__table']")).click();
			 
			 
			   Actions action = new Actions(login.driver);
				WebElement we = login.driver.findElement(By.xpath("//span[@class='series-edit--title']"));
				action.moveToElement(we).build().perform();
				
				String Text;
				Text = we.getAttribute("title");
				System.out.println(Text);
				String[]  array = Text.split("\n");
				int size=array.length;
				System.out.println(size);
				for(int i=0;i<array.length;i++){
				}
				System.out.println("Name of the Series = :- "+ array[1]);
				 String NameofSeries = array[1];
				    String[] result = NameofSeries.split(" ", 2);
				    //String first = result[0];
				    String intable = result[1];
				   // System.out.println("First Expected String : " + first);
				    System.out.println("Expected String : " + intable);
				    if(rest.equalsIgnoreCase(intable)){
						System.out.println("Preview Series functionality in Table is Working Successfully");
					}
					else{
						 Assert.fail("Preview Series functionality in Table is NOT Working Successfully");
					}
		 }
		 if(arg4.equalsIgnoreCase(arg4))
		 {
			 Thread.sleep(6000);
			 login.driver.findElement(By.xpath("//div[@class='series-preview--mode__statistics']")).click();
			 
			 
			   Actions action = new Actions(login.driver);
				WebElement we = login.driver.findElement(By.xpath("//span[@class='series-edit--title']"));
				action.moveToElement(we).build().perform();
				
				String Text;
				Text = we.getAttribute("title");
				System.out.println(Text);
				String[]  array = Text.split("\n");
				int size=array.length;
				System.out.println(size);
				for(int i=0;i<array.length;i++){
				}
				System.out.println("Name of the Series = :- "+ array[1]);
				 String NameofSeries = array[1];
				    String[] result = NameofSeries.split(" ", 2);
				    //String first = result[0];
				    String instatistics = result[1];
				   // System.out.println("First Expected String : " + first);
				    System.out.println("Expected String : " + instatistics);
				    if(rest.equalsIgnoreCase(instatistics)){
						System.out.println("Preview Series functionality in Statistics is Working Successfully");
					}
					else{
						 Assert.fail("Preview Series functionality in Statistics is NOT Working Successfully");
					}
		 }
		 Thread.sleep(6000);
		 login.driver.findElement(By.xpath("//div[@class='series-preview-close']")).click();
		 Thread.sleep(6000);
		 login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click();
		
		
	}
	

		@And("^Select (\\d+) series to my series tab$")
		public void select_series_to_my_series_tab(int arg1) throws Throwable {
			Thread.sleep(5000);
			login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
			
			JavascriptExecutor jse = (JavascriptExecutor) login.driver;
			ulelement = login.driver.findElement(By.xpath("//ul[@class='search-series-list scrollable']"));
			
			//System.out.println("Total Size are- " + element.getSize());
	       
			List<WebElement> objLinks = ulelement.findElements(By.tagName("li"));
			
			System.out.println("Total Size are- " + objLinks.size());
			 Thread.sleep(2000);
			 
			 
				
			for(int i=1;i<=20;i++){
				Thread.sleep(2000);
				int j=i+1;
				 login.driver.findElement(By.xpath("//li["+j+"]//div[@class='series-list-item--checkbox-wrapper']")).click();
				 
				 
					element = login.driver.findElement(By.xpath("//li["+j+"]//div[@class='series-item--name']"));
					jse.executeScript("arguments[0].scrollIntoView(true);", element);
			}
			 Robot r = new Robot();
			 r.keyPress(KeyEvent.VK_A);
			 r.keyRelease(KeyEvent.VK_A);
		}
		
	
		@And("^Verify for \"([^\"]*)\" Maximum series for 'Preview option'$")
		public void verify_for_Maximum_series_for_Preview_option(String arg1) throws Throwable {
			Thread.sleep(8000);
			login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
			Thread.sleep(8000);
			login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[5]")).click();
			Thread.sleep(8000);
			 if(login.driver.findElements(By.xpath("//div[@class='series-preview-title']")).size() != 0){
				  System.out.println("Preview option is working fine !!! ");
				  }else{
					  Assert.fail("Preview option is NOT working fine"); //div[@class='header-menu-help__link'][3]  
				  }
			 Thread.sleep(8000);
			 login.driver.findElement(By.xpath("//div[@class='series-preview-close']")).click();
			 Thread.sleep(8000);
			 login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click();
			 Thread.sleep(8000);
			 login.driver.findElement(By.xpath("//div[@class='search-input--move-top-title']")).click();
			
		}
		
		@And("^Select \"([^\"]*)\" series to my series tab$")
		public void select_series_to_my_series_tab(String arg1) throws Throwable {
			Thread.sleep(5000);
			login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
			
			JavascriptExecutor jse = (JavascriptExecutor) login.driver;
			ulelement = login.driver.findElement(By.xpath("//ul[@class='search-series-list scrollable']"));
			
			//System.out.println("Total Size are- " + element.getSize());
	       
			List<WebElement> objLinks = ulelement.findElements(By.tagName("li"));
			
			System.out.println("Total Size are- " + objLinks.size());
			 Thread.sleep(2000);
			 
			 
				
			for(int i=1;i<=21;i++){
				Thread.sleep(2000);
				int j=i+1;
				 login.driver.findElement(By.xpath("//li["+j+"]//div[@class='series-list-item--checkbox-wrapper']")).click();
				 
				 
					element = login.driver.findElement(By.xpath("//li["+j+"]//div[@class='series-item--name']"));
					jse.executeScript("arguments[0].scrollIntoView(true);", element);
			}
			 Robot r = new Robot();
			 r.keyPress(KeyEvent.VK_A);
			 r.keyRelease(KeyEvent.VK_A);
		}

		@And("^Verify 'Preview option' is disable for \"([^\"]*)\" series$")
		public void verify_Preview_option_is_disable_for_series(String arg1) throws Throwable {
			Thread.sleep(8000);
			login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
			
			 if(login.driver.findElements(By.xpath("//div[@title='Preview. View selected series as a chart and as a table and see series statistics.']")).size() != 0){
				  System.out.println("Preview option is working fine for More than 20 Series!!! ");
				  }else{
					  Assert.fail("Preview option is NOT working fine for More than 20 Series!!!"); 
				  }
			
			 Thread.sleep(8000);
			 login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click();
			 Thread.sleep(8000);
			 login.driver.findElement(By.xpath("//div[@class='search-input--move-top-title']")).click();
			
		}
		@And("^Select preview option$")
		public void select_preview_option() throws Throwable {
			Thread.sleep(8000);
			login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
			Thread.sleep(8000);
			login.driver.findElement(By.xpath("//div[@class='webix_column list-series-name webix_last']/div[1]/div/span")).click();
			Thread.sleep(8000);
			login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[5]")).click();
			Thread.sleep(8000);
			login.driver.findElement(By.xpath("//div[@class='webix_column list-series-name webix_last']/div[1]/div/span")).click();
			
		}

		@And("^Verify Validation message for more than (\\d+) series added to preview window\\.$")
		public void verify_Validation_message_for_more_than_series_added_to_preview_window(int arg1) throws Throwable {
			
			Thread.sleep(8000);
			login.driver.findElement(By.xpath("//button[@class='button button__action button__sm series-preview--refresh']")).click();
			Thread.sleep(4000);
			 if(login.driver.findElements(By.xpath("//div[@class='growl-message-text']")).size() != 0){
				  System.out.println("Validation message Verified Successfully!!! ");
				  }else{
					  Assert.fail("Validation message is NOT Verified Successfully!!!"); 
				  }
			 Thread.sleep(8000);
			 login.driver.findElement(By.xpath("//div[@class='series-preview-close']")).click();
			 Thread.sleep(8000);
			 login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click();
			 Thread.sleep(8000);
			 login.driver.findElement(By.xpath("//div[@class='search-input--move-top-title']")).click();
		}
		
		@And("^Select the select all option$")
		public void select_the_select_all_option() throws Throwable {
			 Thread.sleep(8000);
			 login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[7]/div[2]")).click();
			 Thread.sleep(8000);
			 login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu arrow-up']/div[3]/li[1]")).click();
			
		}

		@And("^Verify \"([^\"]*)\" option functionality\\.$")
		public void verify_option_functionality(String arg1) throws Throwable {
			 Thread.sleep(8000);
			 String Count1 = login.driver.findElement(By.xpath("//span[@class='series-panel--count']/span[1]/span[1]")).getText();
			 Thread.sleep(8000);
			 String Count2 = login.driver.findElement(By.xpath("//span[@class='series-panel--count']/span[3]/span[2]")).getText();
			 System.out.println( Count1 + ":" + Count2 );
			  if(Count1.equalsIgnoreCase(Count2)){
				   
			    	System.out.println("Select all Functionality is working Successfully");
			    }else{
			    	 Assert.fail("Select all Functionality is NOT working Successfully:-(");
			    }
			  Thread.sleep(8000);
				 login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click();
		}
		
		@And("^Select the Unselect all option$")
		public void select_the_Unselect_all_option() throws Throwable {
			Thread.sleep(8000);
			select_the_select_all_option();
			Thread.sleep(8000);
			 Thread.sleep(8000);
			 login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[7]/div[2]")).click();
			 Thread.sleep(8000);
			 login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu arrow-up']/div[3]/li[2]")).click();
		}

		@And("^Verify UnSelect all option functionality\\.$")
		public void verify_UnSelect_all_option_functionality() throws Throwable {
			  Thread.sleep(8000);

				 boolean deletebtn = login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).isSelected();
				 System.out.print(deletebtn);
				 if (deletebtn == false){
					 System.out.println("UnSelect all option functionality is working Successfully");
				 }else{
					 Assert.fail("UnSelect all option functionality is NOT working Successfully :-(");
				 }
		}
		@And("^Select the Clear All  option$")
		public void select_the_Clear_All_option() throws Throwable {
		  
		}

		@And("^Verify Clear All option for \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" functionality\\.$")
		public void verify_Clear_All_option_for_functionality(String arg1, String arg2, String arg3) throws Throwable {
			 Thread.sleep(5000);
			 
			 if(arg2.equalsIgnoreCase(arg2))
			 {
				 Thread.sleep(8000);
				 String Countbeoreclear = login.driver.findElement(By.xpath("//span[@class='series-panel--count']/span[1]/span[1]")).getText();
				 Thread.sleep(5000);
				 login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[7]/div[2]")).click();
				 Thread.sleep(8000);
				 login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu arrow-up']/div[3]/li[3]")).click();
				 Thread.sleep(8000);
				 login.driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();
				 String Countafterclear = login.driver.findElement(By.xpath("//span[@class='series-panel--count']/span[1]/span[1]")).getText();
				 System.out.println( Countbeoreclear + ":" + Countafterclear );
				  if(Countbeoreclear.equalsIgnoreCase(Countafterclear)){
					   
				    	System.out.println("Clear all Functionality  for Cancel is working Successfully");
				    }else{
				    	 Assert.fail("Clear all Functionality  for Cancel is Not working Successfully:-(");
				    }
			 }
			 
			 
			 if(arg3.equalsIgnoreCase(arg3))
			 {
				 Thread.sleep(8000);
				 String Countbeoreclear = login.driver.findElement(By.xpath("//span[@class='series-panel--count']/span[1]/span[1]")).getText();
				 Thread.sleep(5000);
				 login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[7]/div[2]")).click();
				 Thread.sleep(8000);
				 login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu arrow-up']/div[3]/li[3]")).click();
				 Thread.sleep(8000);
				 login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
				 String Countafterclear = login.driver.findElement(By.xpath("//span[@class='series-panel--count']/span[1]/span[1]")).getText();
				 System.out.println( Countbeoreclear + ":" + Countafterclear );
				  if(Countbeoreclear.equalsIgnoreCase(Countafterclear)){
					   
				    	System.out.println("Clear all Functionality  for Dismiss is working Successfully");
				    }else{
				    	 Assert.fail("Clear all Functionality  for Dismiss is Not working Successfully:-(");
				    }
			 }
			 if(arg1.equalsIgnoreCase(arg1))
			 {
				 Thread.sleep(8000);
				 String Countbeoreclear = login.driver.findElement(By.xpath("//span[@class='series-panel--count']/span[1]/span[1]")).getText();
				 Thread.sleep(5000);
				 login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[7]/div[2]")).click();
				 Thread.sleep(8000);
				 login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu arrow-up']/div[3]/li[3]")).click();
				 Thread.sleep(8000);
				 login.driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
				 Thread.sleep(5000);
				 if(login.driver.findElements(By.xpath("//div[@class='insight-action-panel--btn insight-action-panel--btn__disabled'] ")).size() != 0)
					{
						System.out.println("Clear all Functionality  for Ok is working Successfully");
					}
				 else
				 {
					 Assert.fail("Clear all Functionality  for Ok is Not working Successfully:-(");
				 }
			 }
		}
		
		
		@And("^Select the Delete option$")
		public void select_the_Delete_option() throws Throwable {
			Thread.sleep(8000);
			login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
			Thread.sleep(8000);
			 login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click();
		}

		@And("^Verify Delete option functionality for Series$")
		public void verify_Delete_option_functionality_for_Series() throws Throwable {
			Thread.sleep(5000);
			 if(login.driver.findElements(By.xpath("//div[@class='insight-action-panel--btn insight-action-panel--btn__disabled'] ")).size() != 0)
				{
					System.out.println("Delete Functionality having Series is working Successfully");
				}
			 else
			 {
				 Assert.fail("Delete Functionality having Series is Not working Successfully:-(");
			 }
		}
		@And("^Create visuals as Chart$")
		public void create_visuals_as_Chart() throws Throwable {
			Thread.sleep(5000);
			login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
			Thread.sleep(5000);
			 login.driver.findElement(By.xpath("//ul[@class='search-series-list scrollable']/li[1]/div/a/div[2]")).click();
			 Robot r = new Robot();
			 r.keyPress(KeyEvent.VK_C);
			 r.keyRelease(KeyEvent.VK_C);
		}

		@And("^Select to myseries button and select the delete option$")
		public void select_to_myseries_button_and_select_the_delete_option() throws Throwable {
			Thread.sleep(5000);
			login.driver.findElement(By.xpath("//a[@class='insight-page-menu-item-link']")).click();
			select_the_Delete_option();
		}

		@And("^Verify Delete option functionality having \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" for Visuals$")
		public void verify_Delete_option_functionality_having_for_Visuals(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
			Thread.sleep(5000);
			 if(arg1.equalsIgnoreCase(arg1))
			 {
				 if(login.driver.findElements(By.xpath("//h4[contains(text(),'Delete series')]")).size() != 0)
				 {
					 System.out.println("Delete Series pop up window appeared Successfully");
				 }else{
					 Assert.fail("Delete Series pop up window Does Not appeared Successfully:-(");
				 }
				 login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
				
			 }
			 if(arg2.equalsIgnoreCase(arg2))
			 {
				
				 Thread.sleep(8000);
				 login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click();
				 String Insisepopup = login.driver.findElement(By.xpath("//div[@class='modal-body sphere-modal__body']")).getText();

				 if(Insisepopup.contains("The series are associated with visuals within the current insight and deleting them will affect the visuals. Are you sure you want to delete?")) 
				 {
					 System.out.println("Mesage in Delete dialog window is  verified Successfully");
				 }
				 else{
					 Assert.fail("Mesage in Delete dialog window is NOT verified Successfully:-(");
				 }
				 login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			 }
			 if(arg3.equalsIgnoreCase(arg3))
			 {
				 Thread.sleep(8000);
				 String CountbeforeDelete = login.driver.findElement(By.xpath("//span[@class='series-panel--count']/span[1]/span[1]")).getText();
				 login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();
				 String CountafterDelete = login.driver.findElement(By.xpath("//span[@class='series-panel--count']/span[1]/span[1]")).getText();
				 System.out.println( CountbeforeDelete + ":" + CountafterDelete );
				  if(CountbeforeDelete.equalsIgnoreCase(CountafterDelete)){
					   
				    	System.out.println("Delete Functionality  for Cancel is working Successfully");
				    }else{
				    	 Assert.fail("Delete Functionality  for Cancel is Not working Successfully:-(");
				    }
			 }
			 if(arg4.equalsIgnoreCase(arg4))
			 {
				 Thread.sleep(8000);
				 String CountbeforeDelete = login.driver.findElement(By.xpath("//span[@class='series-panel--count']/span[1]/span[1]")).getText();
				 login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click();
				 Thread.sleep(2000);
				 login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
				 String CountafterDelete = login.driver.findElement(By.xpath("//span[@class='series-panel--count']/span[1]/span[1]")).getText();
				 System.out.println( CountbeforeDelete + ":" + CountafterDelete );
				  if(CountbeforeDelete.equalsIgnoreCase(CountafterDelete)){
					   
				    	System.out.println("Delete Functionality  for Dismiss is working Successfully");
				    }else{
				    	 Assert.fail("Delete Functionality  for Dismiss is Not working Successfully:-(");
				    }
			 }
			 if(arg4.equalsIgnoreCase(arg4))
			 {
				 
				 Thread.sleep(5000);
				 login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[8]")).click();
				 Thread.sleep(8000);
				 login.driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
				 Thread.sleep(5000);
				 if(login.driver.findElements(By.xpath("//div[@class='insight-action-panel--btn insight-action-panel--btn__disabled'] ")).size() != 0)
					{
						System.out.println("Delete Functionality for Ok is working Successfully");
					}
				 else
				 {
					 Assert.fail("Delete Functionality for Ok is Not working Successfully:-(");
				 }
			 }
		}
		
	
		@Given("^Select the grouping function$")
		public void select_the_grouping_function() throws Throwable {
			Thread.sleep(5000);
			login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
			Thread.sleep(5000);
			login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[10]/div[2]")).click();
			Thread.sleep(5000);
			login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu arrow-up']/div[3]/li[1]/span")).click();
			Thread.sleep(5000);
			login.driver.findElement(By.xpath("//div[@class='insight-series-rename--button insight-series-rename--button__cancel']")).click();
			
		}

		@Given("^Verify \"([^\"]*)\" functionality for Series$")
		public void verify_functionality_for_Series(String arg1) throws Throwable {
			Thread.sleep(5000);
			login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[10]/div[2]")).click();
			Thread.sleep(5000);
			 if(login.driver.findElements(By.xpath("//span[@class='context-menu-item link disabled']")).size() != 0)
				{
					System.out.println("Grouping Functionality  is working Successfully");
				}
			 else
			 {
				 Assert.fail("Grouping Functionality is Not working Successfully:-(");
			 }
			 Thread.sleep(5000);
				login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[10]/div[2]")).click();
				Thread.sleep(5000);
			    String GroupVerification = "Group";
				String Text = login.driver.findElement(By.xpath("//span[@class='group-name']")).getText();
				System.out.println("Text is" + Text);
				String mystring = Text;
				String arr[] = mystring.split(" ", 2);

				String firstWord = arr[0];   
				firstWord = firstWord.replaceAll("[^a-zA-Z0-9]", "");
				 System.out.println( GroupVerification + ":" + firstWord );
				  if(GroupVerification.equalsIgnoreCase(firstWord)){
					   
				    	System.out.println("Grouping Functionality  is working Successfully");
				    }else{
				    	 Assert.fail("Grouping Functionality is Not working Successfully:-(");
				    }
		}
		@Given("^Select the Group Rename option$")
		public void select_the_Group_Rename_option() throws Throwable {
			 Thread.sleep(5000);
			  Actions action = new Actions(login.driver);
				WebElement we = login.driver.findElement(By.xpath("//span[@class='group-name']"));
				action.moveToElement(we).build().perform();
				Thread.sleep(5000);
				login.driver.findElement(By.xpath("//span[@class='series-item--icon series-item--icon__edit']")).click();
				Thread.sleep(5000);
				login.driver.findElement(By.xpath("//span[@class='context-menu-item link']")).click();
			
		}

		@Given("^Verify \"([^\"]*)\" Rename functionality for Series$")
		public void verify_Rename_functionality_for_Series(String arg1) throws Throwable {
			Thread.sleep(5000);
			 if(login.driver.findElements(By.xpath("//div[@class='popover-content']/div")).size() != 0)
				{
					System.out.println("Grouping Rename pop up appeared Successfully");
				}
			 else
			 {
				 Assert.fail("Grouping Rename pop up Does not appeared Successfully:-(");
			 }
			 Thread.sleep(5000);
			 login.driver.findElement(By.xpath("//div[@class='popover-content']/div/input")).click();
			 Thread.sleep(5000);
			 login.driver.findElement(By.xpath("//div[@class='popover-content']/div/input")).clear();
			 Thread.sleep(5000);
			 String GroupingRenamed = "GroupingRenamed";
			 login.driver.findElement(By.xpath("//div[@class='popover-content']/div/input")).sendKeys(GroupingRenamed);
			 Thread.sleep(5000);
			 login.driver.findElement(By.xpath("//div[@class='insight-series-rename--button insight-series-rename--button__apply']")).click();
			 Thread.sleep(5000);
			 String Text = login.driver.findElement(By.xpath("//span[@class='group-name']")).getText();
			 System.out.println( GroupingRenamed + ":" + Text );
			 if(GroupingRenamed.equalsIgnoreCase(Text)){
				   
			    	System.out.println("Grouping Renamed Functionality  is working Successfully");
			    }else{
			    	 Assert.fail("Grouping Renamed Functionality is Not working Successfully:-(");
			    }
		}
		@Given("^Select the UnGroup option$")
		public void select_the_UnGroup_option() throws Throwable {
			Thread.sleep(5000);
			login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[10]/div[2]")).click();
			Thread.sleep(5000);
			login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu arrow-up']/div[3]/li[2]/span")).click();
		}

		@Given("^Verify UnGroup functionality for Series$")
		public void verify_UnGroup_functionality_for_Series() throws Throwable {
			Thread.sleep(5000);
			login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[10]/div[2]")).click();
			Thread.sleep(5000);
			 if(login.driver.findElements(By.xpath("//span[@class='context-menu-item link disabled']")).size() != 0)
				{
					System.out.println("UnGrouping Functionality  is working Successfully");
				}
			 else
			 {
				 Assert.fail("UnGrouping Functionality is Not working Successfully:-(");
			 }
			 Thread.sleep(5000);
				login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[10]/div[2]")).click();
		}
		@Given("^Verify UnGroup functionality disabled status when their is no Group$")
		public void verify_UnGroup_functionality_disabled_status_when_their_is_no_Group() throws Throwable {
			Thread.sleep(5000);
			login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[10]/div[2]")).click();
			Thread.sleep(5000);
			 if(login.driver.findElements(By.xpath("//span[@class='context-menu-item link disabled']")).size() != 0)
				{
					System.out.println("UnGrouping Functionality  is in disabled status when their is no Group");
				}
			 else
			 {
				 Assert.fail("UnGrouping Functionality  is NOT in disabled status when their is no Group:-(");
			 }
			 Thread.sleep(5000);
				login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[10]/div[2]")).click();
				
		}
		
		@Given("^Select the Seperator option$")
		public void select_the_Seperator_option() throws Throwable {
			select_some_series_to_my_series_tab();
			Thread.sleep(5000);
			login.driver.findElement(By.xpath("//div[@class='data-action-panel insight-action-panel']/div[10]/div[2]")).click();
			Thread.sleep(5000);
			login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu arrow-up']/div[3]/li[3]/span")).click();
			
		}

		@Given("^Verify Seperator functionality for Series$")
		public void verify_Seperator_functionality_for_Series() throws Throwable {
			Thread.sleep(5000);
			login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
			Thread.sleep(5000);
			login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
			//Thread.sleep(5000);
			//login.driver.findElement(By.xpath("//div[@class='webix_column list-series-name webix_last']/div[1]/div/span[1]")).click();
			Thread.sleep(5000);
			Actions action = new Actions(login.driver);
			WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='webix_column list-series-name webix_last']/div[2]/div/span[1]"));
			action.contextClick(RightclickonInsight).build().perform();
			Thread.sleep(5000);
			
			 if(login.driver.findElements(By.xpath("//span[contains(@class, 'context-menu-item link disabled') and contains(@title, 'Unselect all')]")).size() != 0)
				{
					System.out.println("Seperate functionality is working Successfully");
				}
			 else
			 {
				 Assert.fail("Seperate  functionality is NOT working Successfully :-(");
			 }
		}
}
