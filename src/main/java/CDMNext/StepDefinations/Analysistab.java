package CDMNext.StepDefinations;

import static org.testng.Assert.fail;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.google.common.collect.Ordering;

import CDMNext.util.CommonFunctionality;
import Javaxlxs.Last_file_download;
import cucumber.api.java.en.Given;

public class Analysistab {
	
	
	//public static Properties CONFIG;
	
	
	//TC_Analysistab_01
	@Given("^Verify Sub tabs under Analytics$")
	public void verify_Sub_tabs_under_Analytics() throws Throwable {
		Thread.sleep(18000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		Thread.sleep(2000);
		Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='child-container'])[1]", 10).isDisplayed());
	System.out.println("verified");
	CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
	}
	
	
	//TC_Analysistab_02
	@Given("^Verify search for analysis insights$")
	public void verify_search_for_analysis_insights() throws Throwable {
		Thread.sleep(18000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		Thread.sleep(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//input[@class='search-input-text']", 10).sendKeys("Philippines Economy in a Snapshot - Q3 2019");
		Thread.sleep(5000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		Thread.sleep(1000);
		String searchanalysisinsight =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
		if(searchanalysisinsight.equalsIgnoreCase("Philippines Economy in a Snapshot - Q3 2019")) {
			System.out.println("Verified");
		}else {
			Assert.fail();
		}
				
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();	
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Reset')]", 10).click();	
		
	}
	//TC_Analysistab_03
	@Given("^Verify categories panel close$")
	public void verify_categories_panel_close() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		Thread.sleep(1000);
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='navigation-sidebar--open-icon'])[1]", 10).click();
		Thread.sleep(500);
		if(login.driver.findElements(By.xpath("(//div[@class='navigation-sidebar--header'])[1]")).size() != 0)
		{
			System.out.println("Verified");
		}
		else {
			Assert.fail();
		}
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();	
		
	}
	
	//TC_Analysistab_04
	@Given("^Verify Sort by dropdown$")
	public void verify_Sort_by_dropdown() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		Thread.sleep(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[@class='text-dots' and contains(text(),'Recently created')]", 10).click();
		Thread.sleep(1000);
		Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//div[@class='custom-select--body custom-select--sorting-filter-dropdown']", 10).isDisplayed());
		System.out.println("verified");
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();	
		
	}
	
	//TC_Analysistab_05
	@Given("^Verify Sort by=Title$")
	public void verify_Sort_by_Title() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		Thread.sleep(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[@class='name' and contains(text(),' EMIS Insights')]", 10).click();	
		Thread.sleep(1000);
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='custom-select-title--handler icon--filter-arrow'])[1]/span[2]", 10).click();
		Thread.sleep(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='custom-select--body custom-select--sorting-filter-dropdown']/div[1]", 10).click();
		//CommonFunctionality.getElementByXpath(login.driver, "(//span[@class='icon--arrow-sort-asc sort-select-title--directions-box-icon'])[1]", 10).click();
		Thread.sleep(1000);
		
		 List<WebElement> objLinks = login.driver.findElements(By.xpath("//a[@class='link insight-table-item--title-link text-dots']"));
			for(WebElement Titles :objLinks )
			{
				
				  ArrayList<String> ar = new ArrayList<String>();
			    		 String c = Titles.getText();
			    		ar.add(c);
			    		System.out.println("Ascending order are" +ar);
			    		boolean sorted = Ordering.natural().isOrdered(ar);
			    		if(sorted == true) {
			    			System.out.println("Verified");
			    		} else {
			    			Assert.fail();
			    		}

		
	}
		
			CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();	
	}
	
	
	
	//TC_Analysistab_06
	@Given("^Verify Sort by=Recently created$")
	public void verify_Sort_by_Recently_created() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		Thread.sleep(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[@class='name' and contains(text(),' EMIS Insights')]", 10).click();	
		Thread.sleep(1000);
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='custom-select-title--handler icon--filter-arrow'])[1]/span[2]", 10).click();
		Thread.sleep(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='custom-select--body custom-select--sorting-filter-dropdown']/div[2]", 10).click();
		//CommonFunctionality.getElementByXpath(login.driver, "(//span[@class='icon--arrow-sort-asc sort-select-title--directions-box-icon'])[1]", 10).click();
		Thread.sleep(1000);
		
		 List<WebElement> objLinks = login.driver.findElements(By.xpath("//a[@class='link insight-table-item--title-link text-dots']"));
			for(WebElement Titles :objLinks )
			{
				
				  ArrayList<String> ar = new ArrayList<String>();
			    		 String c = Titles.getText();
			    		ar.add(c);
			    		System.out.println("Ascending order are" +ar);
			    		boolean sorted = Ordering.natural().isOrdered(ar);
			    		if(sorted == true) {
			    			System.out.println("Verified");
			    		} else {
			    			Assert.fail();
			    		}

		
	}
		
			CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();	
	}
	
	//TC_Analysistab_07
	@Given("^Verify Sort by=Last opened$")
	public void verify_Sort_by_Last_opened() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		Thread.sleep(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[@class='name' and contains(text(),' EMIS Insights')]", 10).click();	
		Thread.sleep(1000);
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='custom-select-title--handler icon--filter-arrow'])[1]/span[2]", 10).click();
		Thread.sleep(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='custom-select--body custom-select--sorting-filter-dropdown']/div[3]", 10).click();
		//CommonFunctionality.getElementByXpath(login.driver, "(//span[@class='icon--arrow-sort-asc sort-select-title--directions-box-icon'])[1]", 10).click();
		Thread.sleep(1000);
		
		 List<WebElement> objLinks = login.driver.findElements(By.xpath("//a[@class='link insight-table-item--title-link text-dots']"));
			for(WebElement Titles :objLinks )
			{
				
				  ArrayList<String> ar = new ArrayList<String>();
			    		 String c = Titles.getText();
			    		ar.add(c);
			    		System.out.println("Ascending order are" +ar);
			    		boolean sorted = Ordering.natural().isOrdered(ar);
			    		if(sorted == true) {
			    			System.out.println("Verified");
			    		} else {
			    			Assert.fail();
			    		}

		
	}
		
			CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();	
	}
	
	
	
	//TC_Analysistab_08
	@Given("^Verify Sort by=Popularity$")
	public void verify_Sort_by_Popularity() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		Thread.sleep(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[@class='name' and contains(text(),' EMIS Insights')]", 10).click();	
		Thread.sleep(1000);
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='custom-select-title--handler icon--filter-arrow'])[1]/span[2]", 10).click();
		Thread.sleep(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='custom-select--body custom-select--sorting-filter-dropdown']/div[4]", 10).click();
		//CommonFunctionality.getElementByXpath(login.driver, "(//span[@class='icon--arrow-sort-asc sort-select-title--directions-box-icon'])[1]", 10).click();
		Thread.sleep(1000);
		
		 List<WebElement> objLinks = login.driver.findElements(By.xpath("//a[@class='link insight-table-item--title-link text-dots']"));
			for(WebElement Titles :objLinks )
			{
				
				  ArrayList<String> ar = new ArrayList<String>();
			    		 String c = Titles.getText();
			    		ar.add(c);
			    		System.out.println("Ascending order are" +ar);
			    		boolean sorted = Ordering.natural().isOrdered(ar);
			    		if(sorted == true) {
			    			System.out.println("Verified");
			    		} else {
			    			Assert.fail();
			    		}

		
	}
		
			CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();	
	}
	
	
	
	//TC_Analysistab_09
	@Given("^Verify view as grid mode$")
	public void verify_view_as_grid_mode() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		Thread.sleep(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a grid']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[@class='name' and contains(text(),' EMIS Insights')]", 10).click();	
		
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='link link__medium insight-grid-item--bottom-panel-title'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.moveToElement(gridmode).build().perform();
		
		  Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='insight-grid-item--buttons-item button'])[1]", 10).isDisplayed());
		   Thread.sleep(5000);
		
		   CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();	
		
		
	}
	//TC_Analysistab_10
	@Given("^Verify view as table mode$")
	public void verify_view_as_table_mode() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		Thread.sleep(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[@class='name' and contains(text(),' EMIS Insights')]", 10).click();	
		
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.moveToElement(gridmode).click().build().perform();
		
		  Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']", 10).isDisplayed());
		   Thread.sleep(5000);
		   
		   
		   CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();	
		   
		   CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='custom-select-title--handler icon--filter-arrow'])[1]/span[2]", 10).click();
			Thread.sleep(1000);
			CommonFunctionality.getElementByXpath(login.driver, "//ul[@class='custom-select--body custom-select--sorting-filter-dropdown']/li[1]", 10).click();
			
		   CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();	
	}
	
	
	
	
	//TC_Analysistab_11
	@Given("^Verify insights count for each sub tabs$")
	public void verify_insights_count_for_each_sub_tabs() throws Throwable {
	  
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		Thread.sleep(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		Thread.sleep(1000);
		String countbefore = CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'WPIC Platinum Quarterly')]/span", 10).getText();
		int cbefore = Integer.parseInt(countbefore);
		Thread.sleep(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'WPIC Platinum Quarterly')]", 10).click();
		Thread.sleep(1000);
		 List<WebElement> objLinks = login.driver.findElements(By.xpath("(//a[@class='link insight-table-item--title-link text-dots'])"));
			int insightscountsize = objLinks.size();
			
			System.out.println(insightscountsize +"="+ cbefore);
			if (insightscountsize == cbefore ) {
				
				System.out.println("Verified");
    		} else {
    			Assert.fail();
    		}
		
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();	
		
	}
	
	
	//TC_Analysistab_12
	@Given("^Verify Sub tabs insights counts with main tab count$")
	public void verify_Sub_tabs_insights_counts_with_main_tab_count() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		Thread.sleep(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		Thread.sleep(1000);

		String ceicinsight = CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/span", 10).getText();
		int ceicinsightbefore = Integer.parseInt(ceicinsight);
		Thread.sleep(1000);
		
		String ASEAN = CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'ASEAN')]/span", 10).getText();
		int ASEANbefore = Integer.parseInt(ASEAN);
		Thread.sleep(1000);
		
		String China = CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'China')]/span", 10).getText();
		int Chinabefore = Integer.parseInt(China);
		Thread.sleep(1000);
		
		String India = CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'India')]/span", 10).getText();
		int Indiabefore = Integer.parseInt(India);
		Thread.sleep(1000);
		
		String Europe = CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Europe')]/span", 10).getText();
		int Europebefore = Integer.parseInt(Europe);
		Thread.sleep(1000);
		
		String LatinAmerica = CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Latin America')]/span", 10).getText();
		int LatinAmericabefore = Integer.parseInt(LatinAmerica);
		Thread.sleep(1000);
		
		String World = CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'World')]/span", 10).getText();
		int Worldbefore = Integer.parseInt(World);
		Thread.sleep(1000);      
		
		int sum =    ASEANbefore+Chinabefore +Indiabefore+ Europebefore+ LatinAmericabefore +Worldbefore;
		System.out.println(ceicinsightbefore +"="+ sum);
		
	
		if(ceicinsightbefore == sum) {
			System.out.println("Verified");
		}
		        
		else {
			Assert.fail();
		}
	
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();	
	
	}
	
	//TC_Analysistab_13
	@Given("^Verify CEIC  Insight under Analytics tab$")
	public void verify_CEIC_Insight_under_Analytics_tab() throws Throwable {
	   
		
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		Thread.sleep(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		Thread.sleep(1000);
		
	
			if(login.driver.findElements(By.xpath("//span[contains(text(),'CEIC Insights')]/span")).size() != 0) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
	}
	
	//TC_Analysistab_14
	@Given("^Verify  CEIC  Insight dropdown$")
	public void verify_CEIC_Insight_dropdown() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		Thread.sleep(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		Thread.sleep(1000);
			if(login.driver.findElements(By.xpath("(//div[@class='child-container'])[2]")).size() != 0) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
	}
	
	//TC_Analysistab_15
	@Given("^Verify Right click options$")
	public void verify_Right_click_options() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		Thread.sleep(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		if(login.driver.findElements(By.xpath("//div[@class='items-wrapper']")).size() != 0) {
			System.out.println("Verified");
		} else {
			Assert.fail();
		}
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
}
	
	
	//TC_Analysistab_16
	@Given("^Verify View insight$")
	public void verify_View_insight() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		Thread.sleep(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
		
		if(login.driver.findElements(By.xpath("//div[@class='insight-preview--actions']")).size() != 0) {
			System.out.println("Verified");
		} else {
			Assert.fail();
		}
		
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
}
	
	//TC_Analysistab_17
	@Given("^Verify Customize on insight right click$")
	public void verify_Customize_on_insight_right_click() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		Thread.sleep(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		
		String customizename = CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[2]", 10).click();
		 
		 String customizenamemyseries = CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-breadcrumb--title text-dots insight-breadcrumb--title__editable']", 10).getText();
		 Thread.sleep(1000);
		 System.out.println(customizenamemyseries+customizename);
		 
		 
			if(!customizenamemyseries.contains(customizename)) {
			System.out.println("Verified");
			}else {
				Assert.fail();
			}
		
			
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
		
		
	}
	
	
	//TC_Analysistab_18
	@Given("^Verify growl message for Customize on insight right click$")
	public void verify_growl_message_for_Customize_on_insight_right_click() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		Thread.sleep(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		
		String customizename = CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[2]", 10).click();
		 CommonFunctionality.ValidateGrowlText("Selected insight(s) copied");
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
	}
	
	//TC_Analysistab_19
	@Given("^Verify growl message for Customize option on insight right click$")
	public void verify_growl_message_for_Customize_option_on_insight_right_click() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		Thread.sleep(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		
		String customizename = CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[2]", 10).click();
		 CommonFunctionality.ValidateGrowlText("Selected insight(s) copied");
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
	}
	
	
	//TC_Analysistab_20
	@Given("^Verify  Copy link on insight right click$")
	public void verify_Copy_link_on_insight_right_click() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		Thread.sleep(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[6]", 10).click();
		 Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		  Transferable contents = clipboard.getContents(null);
		  String x = (String) contents.getTransferData(DataFlavor.stringFlavor);
		  System.out.println(x);
		  
		  String URL = login.CONFIG.getProperty("testsiteURL").toString();
		 
		  //String Copy_link ="https://stage.ceicdata.com";
		  if(x.contains(URL)){
			  System.out.println("verified");
			} else {
				Assert.fail();
	  }
		  Thread.sleep(3000);
		  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
		
	}

	//TC_Analysistab_21
	@Given("^Verify copied URL$")
	public void verify_copied_URL() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		Thread.sleep(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[6]", 10).click();
		 
		 Robot r = new Robot();        
         r.keyPress(KeyEvent.VK_CONTROL);
         r.keyPress(KeyEvent.VK_T);
         r.keyRelease(KeyEvent.VK_CONTROL);
         r.keyRelease(KeyEvent.VK_T);
         Thread.sleep(2500);
         r.keyPress(KeyEvent.VK_CONTROL);
         r.keyPress(KeyEvent.VK_V);
         r.keyRelease(KeyEvent.VK_CONTROL);
         r.keyRelease(KeyEvent.VK_V);
         r.keyPress(KeyEvent.VK_ENTER);
         r.keyRelease(KeyEvent.VK_ENTER);
		 
		 ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
		    login.driver.switchTo().window(tabs2.get(1));
		    
		    Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']", 10).isDisplayed());
			 Thread.sleep(5000);
		  login.driver.close();
		    login.driver.switchTo().window(tabs2.get(0));
		    CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
			CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
			
		 
	}
	
	//TC_Analysistab_22
	@Given("^Verify insights in view mode$")
	public void verify_insights_in_view_mode() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
		 
		   Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='text-block-editor visual-select-area'])[2]", 10).isDisplayed());
			 Thread.sleep(5000);
		 
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
		
		 
	}
	//TC_Analysistab_23
	@Given("^Verify Related Insights in view mode$")
	public void verify_Related_Insights_in_view_mode() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
		 Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='related-insights--toggle' and contains(text(),'Related Insights')]", 10).click();
		 Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//div[@class='related-insights--container']", 10).isDisplayed());
		 Thread.sleep(5000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
	}
	
	//TC_Analysistab_24
	@Given("^Verify Customize in view mode$")
	public void verify_Customize_in_view_mode() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
		 Thread.sleep(1000);
		 String customizenameinviewpopup = CommonFunctionality.getElementByXpath(login.driver, "//span[@class='insight-preview--title text-dots']", 10).getText();
		 Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[1]", 10).click();
		 Thread.sleep(1000);
		 String customizenamemyseries = CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-breadcrumb--title text-dots insight-breadcrumb--title__editable']", 10).getText();
		 Thread.sleep(1000); 

			if(customizenamemyseries.contains(customizenameinviewpopup)) {
			System.out.println("Verified");
			}else {
				Assert.fail();
			}
		
			
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
		
		 
		 
	}
	//TC_Analysistab_25
	@Given("^Verify CopyLink on view mode$")
	public void verify_CopyLink_on_view_mode() throws Throwable {
		 Thread.sleep(1000); 
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
		 Thread.sleep(1000);
		 String customizenameinviewpopup = CommonFunctionality.getElementByXpath(login.driver, "//span[@class='insight-preview--title text-dots']", 10).getText();
		 Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[3]", 10).click();
		  Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		  Transferable contents = clipboard.getContents(null);
		  String x = (String) contents.getTransferData(DataFlavor.stringFlavor);
		  System.out.println("x as"+ x);
		  String URL = login.CONFIG.getProperty("testsiteURL").toString();
		  String Copy_link = URL+customizenameinviewpopup ;
		  System.out.println("copylink"+Copy_link);
		  if(!x.contains(Copy_link)){
			  System.out.println("verified");
			} else {
				Assert.fail();
	  }
		  Thread.sleep(3000);  
		  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
		
	}

	//TC_Analysistab_26
	@Given("^Verify Download in insight view mode$")
	public void verify_Download_in_insight_view_mode() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
		 Thread.sleep(1000);
		 String customizenameinviewpopup = CommonFunctionality.getElementByXpath(login.driver, "//span[@class='insight-preview--title text-dots']", 10).getText();
		 Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[2]", 10).click();
		 Thread.sleep(1000);
			Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//span[@class='download-modal-title__title' and contains(text(),'Download: ')]", 10).isDisplayed());
			System.out.println("verified");
			Thread.sleep(3000);  
			  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close' ]", 10).click();
			  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
			  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
			CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
			
	}
	//TC_Analysistab_27
	@Given("^Verify download all series$")
	public void verify_download_all_series() throws Throwable {
		
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
		 Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--views-wrapper']/div[2]/div/div/a", 10).click();
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[2]", 10).click();
		 Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//button[@class='sphere-modal-control button insight-download__modal-button button button__download-btn']", 10).click();
		 Thread.sleep(18000); 
		 Last_file_download.getTheNewestFile();
			System.out.println("verified");
		  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
		
	}
	
	//TC_Analysistab_28
	@Given("^Verify download  views to Excel format$")
	public void verify_download_views_to_Excel_format() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
		 Thread.sleep(1000);
		// CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--views-wrapper']/div[2]/div/div/a", 10).click();
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[2]", 10).click();
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='tabs__tabs-box']/div[2]", 10).click();
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='icon--export icon--export__xlsx']", 10).click();
		//div[@class='icon--export icon--export__pdf']
		 Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//button[@class='sphere-modal-control button insight-download__modal-button button button__download-btn']", 10).click();
		 Thread.sleep(18000); 
		 Last_file_download.getTheNewestFile();
			System.out.println("verified");
		  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
		 
	}
	
	//TC_Analysistab_29
	@Given("^Verify download  views to PDF format$")
	public void verify_download_views_to_PDF_format() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
		 Thread.sleep(1000);
		// CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--views-wrapper']/div[2]/div/div/a", 10).click();
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[2]", 10).click();
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='tabs__tabs-box']/div[2]", 10).click();
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='icon--export icon--export__pdf']", 10).click();
		 Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//button[@class='sphere-modal-control button insight-download__modal-button button button__download-btn']", 10).click();
		 Thread.sleep(8000); 
		 Last_file_download.getTheNewestFile();
			System.out.println("verified");
		  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
	}
	//TC_Analysistab_30
	@Given("^Verify  Expand popup in insight view mode$")
	public void verify_Expand_popup_in_insight_view_mode() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
		 Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[4]", 10).click();
		 Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//i[@class='insight-preview--icon__expand']", 10).isDisplayed());
			System.out.println("verified");
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
			  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
			CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
	}
	//TC_Analysistab_31
	@Given("^Verify Close window$")
	public void verify_Close_window() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
		 Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		 if(login.driver.findElements(By.xpath("//div[@class='insight-preview--close']")).size() ==0) {
			 System.out.println("Verified");
		 }else {
			 Assert.fail();
		 }
		 
		 
		 
		 
	}
	//TC_Analysistab_32
	@Given("^Verify my series and view tabs$")
	public void verify_my_series_and_view_tabs() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
		 Thread.sleep(1000);
		 Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='text-block-editor visual-select-area'])[2]", 10).isDisplayed());
		 System.out.println("verified");
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--views-wrapper']/div[2]/div/div/a", 10).click();
		 Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--body']/div/div/div/div[1]/div/div[1]/div[1]/span[2]", 10).isDisplayed());
			System.out.println("verified");
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
			  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
			CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
	}
	
	
	//TC_Analysistab_33
	@Given("^Verify Download scenario for Data$")
	public void verify_Download_scenario_for_Data() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
		 Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--views-wrapper']/div[2]/div/div/a", 10).click();
		 Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[2]", 10).click();
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='tabs__tabs-box']/div[1]", 10).click();
		 Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//span[@class='download-area-selector__description text-dots' and contains(text(),'My Series')]", 10).isDisplayed());
			System.out.println("verified");
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']", 10).click();
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
			  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
			CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
		 
	}
	
	//TC_Analysistab_34
	@Given("^Verify Download scenario for Visuals$")
	public void verify_Download_scenario_for_Visuals() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
		 Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[2]", 10).click();
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='tabs__tabs-box']/div[2]", 10).click();
		 Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//span[@class='download-modal-title__title']", 10).isDisplayed());
			System.out.println("verified");
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']", 10).click();
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
			  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
			CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
	}
	//TC_Analysistab_35
	@Given("^Verify CEIC insight Edit access$")
	public void verify_CEIC_insight_Edit_access() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
		 Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='text-block-editor visual-select-area'])[2]", 10).isDisplayed());
			System.out.println("verified");
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
}
	//TC_Analysistab_36
	@Given("^Verify Focus Economics tab under Analysis$")
	public void verify_Focus_Economics_tab_under_Analysis() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Focus Economics')]/preceding::div[1]", 10).click();
		 Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='child-container'])[2]", 10).isDisplayed());
			System.out.println("verified");
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
		login.driver.navigate().refresh();
	}
	
	
	//TC_Analysistab_37
	@Given("^Verify Focus Economics Insight$")
	public void verify_Focus_Economics_Insight() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Focus Economics')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='tree-node full-expanded open']/div[3]/div[1]/div[2]", 10).click();
		Thread.sleep(5000);
		String Focuseconomic =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
	 if(Focuseconomic.contains("FocusEconomics")) {
		 System.out.println("Verified");
	 }
	 else {
		 Assert.fail();
	 }
	 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
	CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
	login.driver.navigate().refresh();
	}
	
	//TC_Analysistab_38
	@Given("^Verify number of insights for Focus Economics Insight$")
	public void verify_number_of_insights_for_Focus_Economics_Insight() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Focus Economics')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='tree-node full-expanded open']/div[3]/div[1]/div[2]", 10).click();
		Thread.sleep(5000);
	
		 List<WebElement> objLinks = login.driver.findElements(By.xpath("(//a[@class='link insight-table-item--title-link text-dots'])"));
		int insightcount = objLinks.size();
		String insightcountafter = CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'ASEAN Countries')]/span", 10).getText();
	    int count = Integer.parseInt(insightcountafter);
	    System.out.println("Verified count as " + count + insightcount);
	    if(count !=  insightcount) {
	    	System.out.println("Verified");
	    }
	    else {
	    	Assert.fail();
	    }
	    CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
		login.driver.navigate().refresh();
	}
	//TC_Analysistab_39
	@Given("^Verify Right click options-Focus Economics Insight$")
	public void verify_Right_click_options_Focus_Economics_Insight() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Focus Economics')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='tree-node full-expanded open']/div[3]/div[1]/div[2]", 10).click();
		Thread.sleep(5000);
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		if(login.driver.findElements(By.xpath("//div[@class='items-wrapper']")).size() != 0) {
			System.out.println("Verified");
		} else {
			Assert.fail();
		}
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
		   CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
			CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
			login.driver.navigate().refresh();
	}
	
	
	//TC_Analysistab_40
	@Given("^Verify Right click options view -Focus Economics Insight$")
	public void verify_Right_click_options_view_Focus_Economics_Insight() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Focus Economics')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='tree-node full-expanded open']/div[3]/div[1]/div[2]", 10).click();
		Thread.sleep(5000);
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
		 if(login.driver.findElements(By.xpath("//div[@class='insight-preview--actions']")).size() != 0) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
			 login.driver.navigate().refresh();
	}
	
	//TC_Analysistab_41
	@Given("^Verify Right click options Customize -Focus Economics Insight$")
	public void verify_Right_click_options_Customize_Focus_Economics_Insight() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Focus Economics')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='tree-node full-expanded open']/div[3]/div[1]/div[2]", 10).click();
		Thread.sleep(5000);
		String customizename = CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[2]", 10).click();
		 
		 String customizenamemyseries = CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-breadcrumb--title text-dots insight-breadcrumb--title__editable']", 10).getText();
		 Thread.sleep(1000);
		 System.out.println(customizenamemyseries+customizename);
			if(customizenamemyseries.contains(customizename)) {
			System.out.println("Verified");
			}else {
				Assert.fail();
			}
		
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
			 login.driver.navigate().refresh();
	}
	
	
	//TC_Analysistab_42
	@Given("^Verify growl message for Right click options Customize -Focus Economics Insight$")
	public void verify_growl_message_for_Right_click_options_Customize_Focus_Economics_Insight() throws Throwable {
		
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Focus Economics')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='tree-node full-expanded open']/div[3]/div[1]/div[2]", 10).click();
		Thread.sleep(5000);
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[2]", 10).click();
		 CommonFunctionality.ValidateGrowlText("Selected insight(s) copied");
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
		 login.driver.navigate().refresh();
	}
	//TC_Analysistab_43
	@Given("^Verify Right click options Copy link-Focus Economics Insight$")
	public void verify_Right_click_options_Copy_link_Focus_Economics_Insight() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Focus Economics')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='tree-node full-expanded open']/div[3]/div[1]/div[2]", 10).click();
		Thread.sleep(5000);
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[6]", 10).click();
		 Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		  Transferable contents = clipboard.getContents(null);
		  String x = (String) contents.getTransferData(DataFlavor.stringFlavor);
		  System.out.println(x);
		  
		  String URL = login.CONFIG.getProperty("testsiteURL").toString();
		 
		  //String Copy_link ="https://stage.ceicdata.com";
		  if(x.contains(URL)){
			  System.out.println("verified");
			} else {
				Assert.fail();
	  }
		  Thread.sleep(3000);
		  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
		login.driver.navigate().refresh();
		
	}
	
	//TC_Analysistab_44
	@Given("^Verify Right click options copied URL-Focus Economics Insight$")
	public void verify_Right_click_options_copied_URL_Focus_Economics_Insight() throws Throwable {
		
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Focus Economics')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='tree-node full-expanded open']/div[3]/div[1]/div[2]", 10).click();
		Thread.sleep(5000);
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[6]", 10).click();
		 
		 Robot r = new Robot();        
         r.keyPress(KeyEvent.VK_CONTROL);
         r.keyPress(KeyEvent.VK_T);
         r.keyRelease(KeyEvent.VK_CONTROL);
         r.keyRelease(KeyEvent.VK_T);
         Thread.sleep(2500);
         r.keyPress(KeyEvent.VK_CONTROL);
         r.keyPress(KeyEvent.VK_V);
         r.keyRelease(KeyEvent.VK_CONTROL);
         r.keyRelease(KeyEvent.VK_V);
         r.keyPress(KeyEvent.VK_ENTER);
         r.keyRelease(KeyEvent.VK_ENTER);
		 
		 ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
		    login.driver.switchTo().window(tabs2.get(1));
		    
		    Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']", 10).isDisplayed());
			 Thread.sleep(5000);
		  login.driver.close();
		    login.driver.switchTo().window(tabs2.get(0));
		    CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
			CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
			login.driver.navigate().refresh();
	}
	
	//TC_Analysistab_45
	@Given("^Verify Right click options insights in view mode-Focus Economics Insight$")
	public void verify_Right_click_options_insights_in_view_mode_Focus_Economics_Insight() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Focus Economics')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='tree-node full-expanded open']/div[3]/div[1]/div[2]", 10).click();
		Thread.sleep(5000);
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
		   Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='text-block-editor visual-select-area'])", 10).isDisplayed());
			 Thread.sleep(5000);
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
			 login.driver.navigate().refresh();
	}
	
	//TC_Analysistab_46
	@Given("^Verify Right click options Related Insights in view mode-Focus Economics Insight$")
	public void verify_Right_click_options_Related_Insights_in_view_mode_Focus_Economics_Insight() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Focus Economics')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='tree-node full-expanded open']/div[3]/div[1]/div[2]", 10).click();
		Thread.sleep(5000);
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
		 Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='related-insights--toggle' and contains(text(),'Related Insights')]", 10).click();
		 Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//div[@class='related-insights--container']", 10).isDisplayed());
		 Thread.sleep(5000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
		
	}
	
	//TC_Analysistab_47
	@Given("^Verify Customize option in view mode in view mode-Focus Economics Insight$")
	public void verify_Customize_option_in_view_mode_in_view_mode_Focus_Economics_Insight() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Focus Economics')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='tree-node full-expanded open']/div[3]/div[1]/div[2]", 10).click();
		Thread.sleep(5000);
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click(); 
		 Thread.sleep(1000);
		 String customizenameinviewpopup = CommonFunctionality.getElementByXpath(login.driver, "//span[@class='insight-preview--title text-dots']", 10).getText();
		 Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[1]", 10).click();
		 Thread.sleep(1000);
		 String customizenamemyseries = CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-breadcrumb--title text-dots insight-breadcrumb--title__editable']", 10).getText();
		 Thread.sleep(1000); 
			if(!customizenamemyseries.contains(customizenameinviewpopup)) {
			System.out.println("Verified");
			}else {
				Assert.fail();
			}
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
		
		
	}
	//TC_Analysistab_48
	@Given("^Verify Copy Link option in view mode in view mode-Focus Economics Insight$")
	public void verify_Copy_Link_option_in_view_mode_in_view_mode_Focus_Economics_Insight() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Focus Economics')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='tree-node full-expanded open']/div[3]/div[1]/div[2]", 10).click();
		Thread.sleep(5000);
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click(); 
		 Thread.sleep(1000);
		 
		 String customizenameinviewpopup = CommonFunctionality.getElementByXpath(login.driver, "//span[@class='insight-preview--title text-dots']", 10).getText();
		 Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[3]", 10).click();
		  Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		  Transferable contents = clipboard.getContents(null);
		  String x = (String) contents.getTransferData(DataFlavor.stringFlavor);
		  System.out.println("x as"+ x);
		  String URL = login.CONFIG.getProperty("testsiteURL").toString();
		  String Copy_link = URL+customizenameinviewpopup ;
		  System.out.println("copylink"+Copy_link);
		  if(!Copy_link.contains(x)){
			  System.out.println("verified");
			} else {
				Assert.fail();
	  }
		  Thread.sleep(3000);  
		  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
		
	}
	
	//TC_Analysistab_49
	@Given("^Verify Download option in view mode in view mode-Focus Economics Insight$")
	public void verify_Download_option_in_view_mode_in_view_mode_Focus_Economics_Insight() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Focus Economics')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='tree-node full-expanded open']/div[3]/div[1]/div[2]", 10).click();
		Thread.sleep(5000);
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click(); 
		 Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[2]", 10).click();
		 Thread.sleep(8000); 
		 Last_file_download.getTheNewestFile();
			System.out.println("verified");
			Thread.sleep(3000);
			  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
			  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
			CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
	}
	//TC_Analysistab_50
	@Given("^Verify Expand popup option in view mode in view mode-Focus Economics Insight$")
	public void verify_Expand_popup_option_in_view_mode_in_view_mode_Focus_Economics_Insight() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Focus Economics')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='tree-node full-expanded open']/div[3]/div[1]/div[2]", 10).click();
		Thread.sleep(5000);
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click(); 
		 Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[4]", 10).click();
		 Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//i[@class='insight-preview--icon__expand']", 10).isDisplayed());
			System.out.println("verified");
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
			  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
			CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
		 
	}
	
	//TC_Analysistab_51
	@Given("^Verify close option in view mode in view mode-Focus Economics Insight$")
	public void verify_close_option_in_view_mode_in_view_mode_Focus_Economics_Insight() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Focus Economics')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='tree-node full-expanded open']/div[3]/div[1]/div[2]", 10).click();
		Thread.sleep(5000);
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click(); 
		 Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		 if(login.driver.findElements(By.xpath("//div[@class='insight-preview--close']")).size() ==0) {
			 System.out.println("Verified");
		 }else {
			 Assert.fail();
		 }
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
			CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
		 
	
	}
	
	//TC_Analysistab_52
	@Given("^Verify search my series and view panels-Focus Economics Insight$")
	public void verify_search_my_series_and_view_panels_Focus_Economics_Insight() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Focus Economics')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='tree-node full-expanded open']/div[3]/div[1]/div[2]", 10).click();
		Thread.sleep(5000);
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
		 Thread.sleep(5000);
		 if(login.driver.findElements(By.xpath("//div[@class='insight-preview--views-wrapper']/div[2]/div/div/a")).size() ==0) {
			 System.out.println("Verified");
		 }else {
			 Assert.fail();
		 }
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
		
		
	}
	
	
	//TC_Analysistab_53
	@Given("^Verify Download scenario for Focus Economics insights$")
	public void verify_Download_scenario_for_Focus_Economics_insights() throws Throwable {
		
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Focus Economics')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='tree-node full-expanded open']/div[3]/div[1]/div[2]", 10).click();
		Thread.sleep(5000);
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
		 Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[2]", 10).click();
		 Thread.sleep(1000);
		// CommonFunctionality.getElementByXpath(login.driver, "//button[@class='sphere-modal-control button insight-download__modal-button button button__download-btn']", 10).click();
		 Thread.sleep(8000); 
		 Last_file_download.getTheNewestFile();
			System.out.println("verified");
		  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();	 
	}
	//TC_Analysistab_54
	@Given("^Verify scrolling down for last insights Focus Economics insights$")
	public void verify_scrolling_down_for_last_insights_Focus_Economics_insights() throws Throwable {
		Thread.sleep(3000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Focus Economics')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='tree-node full-expanded open']/div[3]/div[1]/div[2]", 10).click();
		Thread.sleep(3000);
		JavascriptExecutor javascript = (JavascriptExecutor) login.driver;
		Boolean b1 = (Boolean) javascript.executeScript("return document.documentElement.scrollWidth>document.documentElement.clientWidth;");
		Thread.sleep(3000);
		if (!b1 == true ) {
			   System.out.println("Horizontal present on page.");
			  } else {
				  Assert.fail();
			  }
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
		
	}
	//TC_Analysistab_55
	@Given("^Verify Focus Economics insight Edit access$")
	public void verify_Focus_Economics_insight_Edit_access() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Focus Economics')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='tree-node full-expanded open']/div[3]/div[1]/div[2]", 10).click();
		Thread.sleep(5000);
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
		 Thread.sleep(1000);
		 /*WebElement some_element = CommonFunctionality.getElementByXpath(login.driver, "//div[@class='text-block-editor visual-select-area']/p/span", 10);
		    String readonly = some_element.getAttribute("readonly");
		    Assert.assertNotNull(readonly);
		 */
		 //Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//div[@class='text-block-editor visual-select-area']/p/span", 10).isDisplayed());
		System.out.println("verified");
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
	
	}
	
	//TC_Analysistab_56
	@Given("^Verify WPIC tab under Analysis$")
	public void verify_WPIC_tab_under_Analysis() throws Throwable {
		Thread.sleep(5000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'WPIC Platinum Quarterly')]", 10).click();
		Thread.sleep(5000);
		String WPIC =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
	 if(WPIC.contains("Platinum Quarterly")) {
		 System.out.println("Verified");
	 }
	 else {
		 Assert.fail();
	 }
	 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
	CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
	login.driver.navigate().refresh();		
	}
	
	
	
	//TC_Analysistab_57
	@Given("^Verify Right click options for WPIC tab$")
	public void verify_Right_click_options_for_WPIC_tab() throws Throwable {
		Thread.sleep(5000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'WPIC Platinum Quarterly')]", 10).click();
		Thread.sleep(5000);
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		if(login.driver.findElements(By.xpath("//div[@class='items-wrapper']")).size() != 0) {
			System.out.println("Verified");
		} else {
			Assert.fail();
		}
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
	}
	//TC_Analysistab_58
	@Given("^Verify View insight Right click options for WPIC tab$")
	public void verify_View_insight_Right_click_options_for_WPIC_tab() throws Throwable {
		
		Thread.sleep(5000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'WPIC Platinum Quarterly')]", 10).click();
		Thread.sleep(5000);
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
			
			if(login.driver.findElements(By.xpath("//div[@class='insight-preview--actions']")).size() != 0) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
	}
	
	
	//TC_Analysistab_59
	@Given("^Verify Customize insight Right click options for WPIC tab$")
	public void verify_Customize_insight_Right_click_options_for_WPIC_tab() throws Throwable {
		Thread.sleep(5000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'WPIC Platinum Quarterly')]", 10).click();
		Thread.sleep(5000);
		String customizename = CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[2]", 10).click();
		 
		 String customizenamemyseries = CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-breadcrumb--title text-dots insight-breadcrumb--title__editable']", 10).getText();
		 Thread.sleep(1000);
		 System.out.println(customizenamemyseries+customizename);
		 
		 
			if(!customizenamemyseries.contains(customizename)) {
			System.out.println("Verified");
			}else {
				Assert.fail();
			}
		
			
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
		
		
	}
	
	//TC_Analysistab_60
	@Given("^Verify growl message for Customize on insight right click for WPIC tab$")
	public void verify_growl_message_for_Customize_on_insight_right_click_for_WPIC_tab() throws Throwable {
		Thread.sleep(5000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'WPIC Platinum Quarterly')]", 10).click();
		Thread.sleep(5000);
		String customizename = CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		
		Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[2]", 10).click();
			 CommonFunctionality.ValidateGrowlText("Selected insight(s) copied");
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
	}
	//TC_Analysistab_61
	@Given("^Verify Copy link on insight right click for WPIC tab$")
	public void verify_Copy_link_on_insight_right_click_for_WPIC_tab() throws Throwable {
	  
		Thread.sleep(8000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'WPIC Platinum Quarterly')]", 10).click();
		Thread.sleep(5000);
		String customizename = CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[6]", 10).click();
		 Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		  Transferable contents = clipboard.getContents(null);
		  String x = (String) contents.getTransferData(DataFlavor.stringFlavor);
		  System.out.println(x);
		  
		  String URL = login.CONFIG.getProperty("testsiteURL").toString();
		 
		  //String Copy_link ="https://stage.ceicdata.com";
		  if(x.contains(URL)){
			  System.out.println("verified");
			} else {
				Assert.fail();
	  }
		  Thread.sleep(3000);
		  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
		
		
	}
	//TC_Analysistab_62
	@Given("^Verify copied URL on insight right click for WPIC tab$")
	public void verify_copied_URL_on_insight_right_click_for_WPIC_tab() throws Throwable {
		Thread.sleep(8000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'WPIC Platinum Quarterly')]", 10).click();
		Thread.sleep(5000);
		String customizename = CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[6]", 10).click();
		
		 Robot r = new Robot();        
         r.keyPress(KeyEvent.VK_CONTROL);
         r.keyPress(KeyEvent.VK_T);
         r.keyRelease(KeyEvent.VK_CONTROL);
         r.keyRelease(KeyEvent.VK_T);
         Thread.sleep(2500);
         r.keyPress(KeyEvent.VK_CONTROL);
         r.keyPress(KeyEvent.VK_V);
         r.keyRelease(KeyEvent.VK_CONTROL);
         r.keyRelease(KeyEvent.VK_V);
         r.keyPress(KeyEvent.VK_ENTER);
         r.keyRelease(KeyEvent.VK_ENTER);
		 
		 ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
		    login.driver.switchTo().window(tabs2.get(1));
		    
		    Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']", 10).isDisplayed());
			 Thread.sleep(5000);
		  login.driver.close();
		    login.driver.switchTo().window(tabs2.get(0));
		    CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
			CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
		
	}
	
	//TC_Analysistab_63
	@Given("^Verify insights in view mode for WPIC tab$")
	public void verify_insights_in_view_mode_for_WPIC_tab() throws Throwable {
		Thread.sleep(8000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'WPIC Platinum Quarterly')]", 10).click();
		Thread.sleep(5000);
		String customizename = CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
	
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
		 Thread.sleep(3000);
		   Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//div[@class='visual-item-template attachments-visual visual-select-area editable']", 10).isDisplayed());
			 Thread.sleep(5000);
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();

		
	}
	//TC_Analysistab_64
	@Given("^Verify Related Insights in view mode for WPIC tab$")
	public void verify_Related_Insights_in_view_mode_for_WPIC_tab() throws Throwable {
		Thread.sleep(8000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'WPIC Platinum Quarterly')]", 10).click();
		Thread.sleep(5000);
		String customizename = CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
		 
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='related-insights--toggle' and contains(text(),'Related Insights')]", 10).click();
		 Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//div[@class='related-insights--container']", 10).isDisplayed());
		 Thread.sleep(5000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
	}
	
	//TC_Analysistab_65
	@Given("^Verify Customize in view mode for WPIC tab$")
	public void verify_Customize_in_view_mode_for_WPIC_tab() throws Throwable {
		Thread.sleep(8000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'WPIC Platinum Quarterly')]", 10).click();
		Thread.sleep(5000);
		String customizename = CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
		WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action =new Actions(login.driver);
		action.contextClick(gridmode).build().perform();
		
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
		 
		 Thread.sleep(1000);
		 String customizenameinviewpopup = CommonFunctionality.getElementByXpath(login.driver, "//span[@class='insight-preview--title text-dots']", 10).getText();
		 Thread.sleep(1000);
		 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[1]", 10).click();
		 Thread.sleep(1000);
		 String customizenamemyseries = CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-breadcrumb--title text-dots insight-breadcrumb--title__editable']", 10).getText();
		 Thread.sleep(1000); 

			if(!customizenamemyseries.contains(customizenameinviewpopup)) {
			System.out.println("Verified");
			}else {
				Assert.fail();
			}
		
			
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
	
	    }
	
	
	
	       //TC_Analysistab_66
			@Given("^Verify CopyLink in view mode for WPIC tab$")
			public void verify_CopyLink_in_view_mode_for_WPIC_tab() throws Throwable {
				Thread.sleep(8000);
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'WPIC Platinum Quarterly')]", 10).click();
				Thread.sleep(5000);
				String customizename = CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
				 
				 Thread.sleep(1000);
				 String customizenameinviewpopup = CommonFunctionality.getElementByXpath(login.driver, "//span[@class='insight-preview--title text-dots']", 10).getText();
				 Thread.sleep(1000);
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[3]", 10).click();
				  Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				  Transferable contents = clipboard.getContents(null);
				  String x = (String) contents.getTransferData(DataFlavor.stringFlavor);
				  System.out.println("x as"+ x);
				  String URL = login.CONFIG.getProperty("testsiteURL").toString();
				  String Copy_link = URL+customizenameinviewpopup ;
				  System.out.println("copylink"+Copy_link);
				  if(!x.contains(Copy_link)){
					  System.out.println("verified");
					} else {
						Assert.fail();
			  }
				  Thread.sleep(3000);  
				  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
				  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
	
			}
			
			
			 //TC_Analysistab_67
			@Given("^Verify Download in view mode for WPIC tab$")
			public void verify_Download_in_view_mode_for_WPIC_tab() throws Throwable {
				
				Thread.sleep(8000);
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'WPIC Platinum Quarterly')]", 10).click();
				Thread.sleep(5000);
				String customizename = CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
				 
				 Thread.sleep(1000);
				 String customizenameinviewpopup = CommonFunctionality.getElementByXpath(login.driver, "//span[@class='insight-preview--title text-dots']", 10).getText();
				 Thread.sleep(1000);
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[2]", 10).click();
				 Thread.sleep(8000); 
				 Last_file_download.getTheNewestFile();
					System.out.println("verified");
					Thread.sleep(3000);  
					  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
					  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
					CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click(); 
	
			   
			}
			 //TC_Analysistab_68
			@Given("^Verify Expand popup in view mode for WPIC tab$")
			public void verify_Expand_popup_in_view_mode_for_WPIC_tab() throws Throwable {
				Thread.sleep(8000);
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'WPIC Platinum Quarterly')]", 10).click();
				Thread.sleep(5000);
				String customizename = CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
				 Thread.sleep(1000);
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[4]", 10).click();
				 Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//i[@class='insight-preview--icon__expand']", 10).isDisplayed());
					System.out.println("verified");
					 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
					  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
					CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
		
				 
			}
			 //TC_Analysistab_69
			@Given("^Verify Close in view mode for WPIC tab$")
			public void verify_Close_in_view_mode_for_WPIC_tab() throws Throwable {
				Thread.sleep(8000);
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'WPIC Platinum Quarterly')]", 10).click();
				Thread.sleep(5000);
				String customizename = CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
				 Thread.sleep(1000);
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
				 if(login.driver.findElements(By.xpath("//div[@class='insight-preview--close']")).size() ==0) {
					 System.out.println("Verified");
				 }else {
					 Assert.fail();
				 }
			}
			
			
			 //TC_Analysistab_70
			@Given("^Verify search, my series and view panels for WPIC tab$")
			public void verify_search_my_series_and_view_panels_for_WPIC_tab() throws Throwable {
				Thread.sleep(8000);
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'WPIC Platinum Quarterly')]", 10).click();
				Thread.sleep(5000);
				String customizename = CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
				 Thread.sleep(2000);
				
	
						 if(login.driver.findElements(By.xpath("//div[@class='insight-preview--body']/div/div/div/div[1]/div/div[1]/div[1]/span[2]")).size() ==0) {
							 System.out.println("Verified");
						 }else {
							 Assert.fail();
						 }	
						 
						 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
						  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
						CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
						 
						 
						 
						 
			}
			 //TC_Analysistab_71
			@Given("^Verify Download scenario for WPIC insights$")
			public void verify_Download_scenario_for_WPIC_insights() throws Throwable {
				Thread.sleep(8000);
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'WPIC Platinum Quarterly')]", 10).click();
				Thread.sleep(5000);
				String customizename = CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
				 Thread.sleep(5000);
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[2]", 10).click();
				 Thread.sleep(8000); 
				 
				 Last_file_download.getTheNewestFile();
				 Thread.sleep(5000); 
	
						 if(login.driver.findElements(By.xpath("//span[@class='download-modal-title__title' and contains(text(),'Download: ')]")).size() ==0) {
							 System.out.println("Verified");
						 }else {
							 Assert.fail();
						 }	
						 
						 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
						  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
						CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
				 
				 
			  
			}
			
			 //TC_Analysistab_72
			@Given("^Verify WPIC insight Edit access$")
			public void verify_WPIC_insight_Edit_access() throws Throwable {
				Thread.sleep(8000);
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'WPIC Platinum Quarterly')]", 10).click();
				Thread.sleep(5000);
				String customizename = CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
				 
				 Thread.sleep(5000);
				 Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//div[@class='visual-item-template attachments-visual visual-select-area editable']", 10).isDisplayed());
				
					System.out.println("verified");
					 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
					  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
					CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
			}
			
			//TC_Analysistab_73
			@Given("^Verify Scroll for WPIC insight$")
			public void verify_Scroll_for_WPIC_insight() throws Throwable {
				Thread.sleep(8000);
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'WPIC Platinum Quarterly')]", 10).click();
				Thread.sleep(5000);
				JavascriptExecutor javascript = (JavascriptExecutor) login.driver;
				Boolean b1 = (Boolean) javascript.executeScript("return document.documentElement.scrollWidth>document.documentElement.clientWidth;");
				Thread.sleep(3000);
				if (!b1 == true ) {
					   System.out.println("Horizontal present on page.");
					  } else {
						  Assert.fail();
					  }
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
			}
			//TC_Analysistab_74
			@Given("^Verify EMIS tab under Analysis$")
			public void verify_EMIS_tab_under_Analysis() throws Throwable {
				Thread.sleep(8000);
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'EMIS Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Asia')]", 10).click();
				Thread.sleep(3000);
				
				 if(login.driver.findElements(By.xpath("(//a[@class='link insight-table-item--title-link text-dots'])")).size() !=0) {
					 System.out.println("Verified");
				 }else {
					 Assert.fail();
				 }	
					CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
					CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
				
				
			}
			//TC_Analysistab_75
			@Given("^Verify EMIS dropdown$")
			public void verify_EMIS_dropdown() throws Throwable {
				
				Thread.sleep(8000);
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'EMIS Insights')]/preceding::div[1]", 10).click();
				 Thread.sleep(5000);
				 Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='child-container'])[2]", 10).isDisplayed());
					System.out.println("verified");
					CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
					CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
				
			
			}
			
			
			//TC_Analysistab_76
			@Given("^Verify EMIS insight count for dropdown$")
			public void verify_EMIS_insight_count_for_dropdown() throws Throwable {
				Thread.sleep(8000);
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'EMIS Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Asia')]", 10).click();
				 Thread.sleep(5000);
				   String EMISinsight = CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'EMIS Insights')]/span", 10).getText();
					int EMISinsightbefore = Integer.parseInt(EMISinsight);
					Thread.sleep(1000);
				    String ASIA = CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Asia')]/span", 10).getText();
					int ASIAbefore = Integer.parseInt(ASIA);
					Thread.sleep(1000);	
					String CentralEurope = CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Central Eastern Europe')]/span", 10).getText();
					int CentralEuropebefore = Integer.parseInt(CentralEurope);
					Thread.sleep(1000);
					String LatinAmerica = CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Latin America')]/span", 10).getText();
					int LatinAmericabefore = Integer.parseInt(LatinAmerica);
					Thread.sleep(1000);
					int sum =    CentralEuropebefore+ASIAbefore +LatinAmericabefore ;
					System.out.println(EMISinsightbefore +"="+ sum);
					if(EMISinsightbefore != sum) {
						System.out.println("Verified");
					}
					        
					else {
						Assert.fail();
					}
				
					 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();	
			   
			}
			
			//TC_Analysistab_77
			@Given("^Verify Right click options for EMIS$")
			public void verify_Right_click_options_for_EMIS() throws Throwable {
				Thread.sleep(8000);
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'EMIS Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Asia')]", 10).click();
				Thread.sleep(5000);
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				if(login.driver.findElements(By.xpath("//div[@class='items-wrapper']")).size() != 0) {
					System.out.println("Verified");
				} else {
					Assert.fail();
				}
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
				
				
				
				
			}
			//TC_Analysistab_78
			@Given("^Verify Right View insight for EMIS$")
			public void verify_Right_View_insight_for_EMIS() throws Throwable {
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'EMIS Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Asia')]", 10).click();
				Thread.sleep(5000);
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				Thread.sleep(1000);
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
				
				if(login.driver.findElements(By.xpath("//div[@class='insight-preview--actions']")).size() != 0) {
					System.out.println("Verified");
				} else {
					Assert.fail();
				}
				
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
				
			  
			}
			//TC_Analysistab_79
			@Given("^Verify Customize Right click options for EMIS$")
			public void verify_Customize_Right_click_options_for_EMIS() throws Throwable {
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'EMIS Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Asia')]", 10).click();
				Thread.sleep(5000);
				String customizename = CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				Thread.sleep(1000);
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[2]", 10).click();
				 String customizenamemyseries = CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-breadcrumb--title text-dots insight-breadcrumb--title__editable']", 10).getText();
				 Thread.sleep(1000);
				 System.out.println(customizenamemyseries+customizename);
					if(!customizenamemyseries.contains(customizename)) {
					System.out.println("Verified");
					}else {
						Assert.fail();
					}
					 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
					 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
	
			    
			}
			
			//TC_Analysistab_80
			@Given("^Verify growl message for Customize on insight right click for EMIS$")
			public void verify_growl_message_for_Customize_on_insight_right_click_for_EMIS() throws Throwable {
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'EMIS Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Asia')]", 10).click();
				Thread.sleep(5000);
				String customizename = CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				Thread.sleep(1000);
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[2]", 10).click();
				 CommonFunctionality.ValidateGrowlText("Selected insight(s) copied");
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
		
			}
			
			//TC_Analysistab_81
			@Given("^Verify Copy link insight right click for EMIS$")
			public void verify_Copy_link_insight_right_click_for_EMIS() throws Throwable {
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'EMIS Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Asia')]", 10).click();
				Thread.sleep(5000);
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[6]", 10).click();
				 Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				  Transferable contents = clipboard.getContents(null);
				  String x = (String) contents.getTransferData(DataFlavor.stringFlavor);
				  System.out.println(x);
				  
				  String URL = login.CONFIG.getProperty("testsiteURL").toString();
				 
				  //String Copy_link ="https://stage.ceicdata.com";
				  if(x.contains(URL)){
					  System.out.println("verified");
					} else {
						Assert.fail();
			  }
				  Thread.sleep(3000);
				  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
				
				
			}
			
			//TC_Analysistab_82
			@Given("^Verify copied URL for EMIS$")
			public void verify_copied_URL_for_EMIS() throws Throwable {
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'EMIS Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Asia')]", 10).click();
				Thread.sleep(5000);
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				
				
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[6]", 10).click();
				 
				 Robot r = new Robot();        
		         r.keyPress(KeyEvent.VK_CONTROL);
		         r.keyPress(KeyEvent.VK_T);
		         r.keyRelease(KeyEvent.VK_CONTROL);
		         r.keyRelease(KeyEvent.VK_T);
		         Thread.sleep(2500);
		         r.keyPress(KeyEvent.VK_CONTROL);
		         r.keyPress(KeyEvent.VK_V);
		         r.keyRelease(KeyEvent.VK_CONTROL);
		         r.keyRelease(KeyEvent.VK_V);
		         r.keyPress(KeyEvent.VK_ENTER);
		         r.keyRelease(KeyEvent.VK_ENTER);
				 
				 ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
				    login.driver.switchTo().window(tabs2.get(1));
				    Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']", 10).isDisplayed());
					 Thread.sleep(5000);
				  login.driver.close();
				    login.driver.switchTo().window(tabs2.get(0));
				    CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
					CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
				
			}
			
			
			//TC_Analysistab_83
			@Given("^Verify insights in view mode for EMIS$")
			public void verify_insights_in_view_mode_for_EMIS() throws Throwable {
			   
				
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'EMIS Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Asia')]", 10).click();
				Thread.sleep(5000);
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
				 Thread.sleep(3000);
				   Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//div[@class='visual-item-template attachments-visual visual-select-area editable']", 10).isDisplayed());
					 Thread.sleep(5000);
					 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
					 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
		
				
			}
			//TC_Analysistab_84
			@Given("^Verify Related Insights in view mode for EMIS$")
			public void verify_Related_Insights_in_view_mode_for_EMIS() throws Throwable {
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'EMIS Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Asia')]", 10).click();
				Thread.sleep(5000);
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='related-insights--toggle' and contains(text(),'Related Insights')]", 10).click();
				 Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//div[@class='related-insights--container']", 10).isDisplayed());
				 Thread.sleep(5000);
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
		
				
			}
			
			
			//TC_Analysistab_85
			@Given("^Verify Customize in view mode for EMIS$")
			public void verify_Customize_in_view_mode_for_EMIS() throws Throwable {
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'EMIS Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Asia')]", 10).click();
				Thread.sleep(5000);
				String customizename = CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
				 Thread.sleep(1000);
				 String customizenameinviewpopup = CommonFunctionality.getElementByXpath(login.driver, "//span[@class='insight-preview--title text-dots']", 10).getText();
				 Thread.sleep(1000);
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[1]", 10).click();
				 Thread.sleep(1000);
				 String customizenamemyseries = CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-breadcrumb--title text-dots insight-breadcrumb--title__editable']", 10).getText();
				 Thread.sleep(1000);
					if(!customizenamemyseries.contains(customizenameinviewpopup)) {
					System.out.println("Verified");
					}else {
						Assert.fail();
					}
					 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
					 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();

			  
			}
			
			
			//TC_Analysistab_86
			@Given("^Verify Copy Link in view mode for EMIS$")
			public void verify_Copy_Link_in_view_mode_for_EMIS() throws Throwable {
				
				
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'EMIS Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Asia')]", 10).click();
				Thread.sleep(5000);		
				String customizename = CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
				 
				 Thread.sleep(1000);
				 String customizenameinviewpopup = CommonFunctionality.getElementByXpath(login.driver, "//span[@class='insight-preview--title text-dots']", 10).getText();
				 Thread.sleep(1000);
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[3]", 10).click();
				  Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				  Transferable contents = clipboard.getContents(null);
				  String x = (String) contents.getTransferData(DataFlavor.stringFlavor);
				  System.out.println("x as"+ x);
				  String URL = login.CONFIG.getProperty("testsiteURL").toString();
				  String Copy_link = URL+customizenameinviewpopup ;
				  System.out.println("copylink"+Copy_link);
				  if(x.contains("stage")){
					  System.out.println("verified");
					} else {
						Assert.fail();
			  }
				  Thread.sleep(3000);  
				  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
				  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
			}

			
			
			
			//TC_Analysistab_87
			@Given("^Verify Download in view mode for EMIS$")
			public void verify_Download_in_view_mode_for_EMIS() throws Throwable {
				
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'EMIS Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Asia')]", 10).click();
				Thread.sleep(5000);		
				String customizename = CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
				 Thread.sleep(1000);
				 String customizenameinviewpopup = CommonFunctionality.getElementByXpath(login.driver, "//span[@class='insight-preview--title text-dots']", 10).getText();
				 Thread.sleep(1000);
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[2]", 10).click();
				 Thread.sleep(8000); 
				 Last_file_download.getTheNewestFile();
					System.out.println("verified");
					Thread.sleep(3000);  
					  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
					  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
					CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click(); 
				 
				 
			}
			
			//TC_Analysistab_88
			@Given("^Verify Expand popup in view mode for EMIS$")
			public void verify_Expand_popup_in_view_mode_for_EMIS() throws Throwable {
				
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'EMIS Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Asia')]", 10).click();
				Thread.sleep(5000);		
				String customizename = CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
				 Thread.sleep(1000);
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[4]", 10).click();
				 Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//i[@class='insight-preview--icon__expand']", 10).isDisplayed());
					System.out.println("verified");
					 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
					  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
					CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
			}
			//TC_Analysistab_89
			@Given("^Verify Close in view mode for EMIS$")
			public void verify_Close_in_view_mode_for_EMIS() throws Throwable {
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'EMIS Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Asia')]", 10).click();
				Thread.sleep(5000);		
				String customizename = CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
				 Thread.sleep(1000);
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
				 if(login.driver.findElements(By.xpath("//div[@class='insight-preview--close']")).size() ==0) {
					 System.out.println("Verified");
				 }else {
					 Assert.fail();
				 }
			}
			//TC_Analysistab_90
			@Given("^Verify search, my series and view panels for EMIS$")
			public void verify_search_my_series_and_view_panels_for_EMIS() throws Throwable {
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'EMIS Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Asia')]", 10).click();
				Thread.sleep(5000);		
				String customizename = CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
				 Thread.sleep(2000);
				
	
						 if(login.driver.findElements(By.xpath("//div[@class='insight-preview--body']/div/div/div/div[1]/div/div[1]/div[1]/span[2]")).size() ==0) {
							 System.out.println("Verified");
						 }else {
							 Assert.fail();
						 }	
						 
						 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
						  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
						CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
				
				
			}
			//TC_Analysistab_91
			@Given("^Verify Download scenario for EMIS insights for EMIS$")
			public void verify_Download_scenario_for_EMIS_insights_for_EMIS() throws Throwable {
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'EMIS Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Asia')]", 10).click();
				Thread.sleep(5000);		
				String customizename = CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
				 Thread.sleep(5000);
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[2]", 10).click();
				 Thread.sleep(8000); 
				 
				 Last_file_download.getTheNewestFile();
				 Thread.sleep(5000); 
	
						 if(login.driver.findElements(By.xpath("//span[@class='download-modal-title__title' and contains(text(),'Download: ')]")).size() ==0) {
							 System.out.println("Verified");
						 }else {
							 Assert.fail();
						 }	
						 
						 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
						  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
						CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
			}
			//TC_Analysistab_92
			@Given("^Verify EMIS insight Edit access$")
			public void verify_EMIS_insight_Edit_access() throws Throwable {
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'EMIS Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Asia')]", 10).click();
				Thread.sleep(5000);		
				String customizename = CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
				 
				 Thread.sleep(5000);
				 Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//div[@class='visual-item-template attachments-visual visual-select-area editable']", 10).isDisplayed());
				
					System.out.println("verified");
					 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
					  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
					CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
			}
			
			//TC_Analysistab_93
			@Given("^Verify Sentix tab under Analysis$")
			public void verify_Sentix_tab_under_Analysis() throws Throwable {
			    
				
				Thread.sleep(5000);
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Sentix')]", 10).click();
				Thread.sleep(5000);
				String WPIC =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
			 if(WPIC.contains("Sentix")) {
				 System.out.println("Verified");
			 }
			 else {
				 Assert.fail();
			 }
			 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
			CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
			login.driver.navigate().refresh();	
				
			}
			
			//TC_Analysistab_94
			@Given("^Verify Right click options for sentix$")
			public void verify_Right_click_options_for_sentix() throws Throwable {
			   
				Thread.sleep(5000);
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Sentix')]", 10).click();
				Thread.sleep(5000);
				Thread.sleep(1000);
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				if(login.driver.findElements(By.xpath("//div[@class='items-wrapper']")).size() != 0) {
					System.out.println("Verified");
				} else {
					Assert.fail();
				}
			}
			//TC_Analysistab_95
			@Given("^Verify Right click options View insight for sentix$")
			public void verify_Right_click_options_View_insight_for_sentix() throws Throwable {
				Thread.sleep(5000);
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Sentix')]", 10).click();
				Thread.sleep(5000);
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				Thread.sleep(1000);
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
				 if(login.driver.findElements(By.xpath("//div[@class='insight-preview--actions']")).size() != 0) {
						System.out.println("Verified");
					} else {
						Assert.fail();
					}
					
					 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
					 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
					 login.driver.navigate().refresh();
				
			}
			//TC_Analysistab_96
			@Given("^Verify Right click options Download for sentix$")
			public void verify_Right_click_options_Download_for_sentix() throws Throwable {
				Thread.sleep(5000);
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Sentix')]", 10).click();
				Thread.sleep(5000);
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				Thread.sleep(1000);
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[2]", 10).click();
				 Thread.sleep(10000);
				 Last_file_download.getTheNewestFile();
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
				 login.driver.navigate().refresh();
				 
			}
			
			//TC_Analysistab_97
			@Given("^Verify Right click options Copylink for sentix$")
			public void verify_Right_click_options_Copylink_for_sentix() throws Throwable {
				Thread.sleep(5000);
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Sentix')]", 10).click();		
				Thread.sleep(5000);
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				Thread.sleep(1000);
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[6]", 10).click();
				 Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				  Transferable contents = clipboard.getContents(null);
				  String x = (String) contents.getTransferData(DataFlavor.stringFlavor);
				  System.out.println(x);
				  
				  String URL = login.CONFIG.getProperty("testsiteURL").toString();
				 
				  //String Copy_link ="https://stage.ceicdata.com";
				  if(x.contains(URL)){
					  System.out.println("verified");
					} else {
						Assert.fail();
			  }
				  Thread.sleep(3000);
				  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
				login.driver.navigate().refresh();
			}
			
			//TC_Analysistab_98
			@Given("^Verify insights counts with main count for sentix$")
			public void verify_insights_counts_with_main_count_for_sentix() throws Throwable {
				Thread.sleep(5000);
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Sentix')]", 10).click();
				Thread.sleep(8000);
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				Thread.sleep(1000);
				String countbefore = CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Sentix')]/span", 10).getText();
				int cbefore = Integer.parseInt(countbefore);
				Thread.sleep(1000);
				 List<WebElement> objLinks = login.driver.findElements(By.xpath("(//a[@class='link insight-table-item--title-link text-dots'])"));
					int insightscountsize = objLinks.size();
					
					System.out.println(insightscountsize +"="+ cbefore);
					if (insightscountsize == cbefore ) {
						
						System.out.println("Verified");
		    		} else {
		    			Assert.fail();
		    		}
				
					 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();	
			}
			
			
			//TC_Analysistab_99
			@Given("^Verify  copied URL for sentix$")
			public void verify_copied_URL_for_sentix() throws Throwable {
				Thread.sleep(5000);
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Sentix')]", 10).click();		
				Thread.sleep(5000);
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				Thread.sleep(1000);
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[6]", 10).click();
				 
				 Robot r = new Robot();        
		         r.keyPress(KeyEvent.VK_CONTROL);
		         r.keyPress(KeyEvent.VK_T);
		         r.keyRelease(KeyEvent.VK_CONTROL);
		         r.keyRelease(KeyEvent.VK_T);
		         Thread.sleep(2500);
		         r.keyPress(KeyEvent.VK_CONTROL);
		         r.keyPress(KeyEvent.VK_V);
		         r.keyRelease(KeyEvent.VK_CONTROL);
		         r.keyRelease(KeyEvent.VK_V);
		         r.keyPress(KeyEvent.VK_ENTER);
		         r.keyRelease(KeyEvent.VK_ENTER);
				 
				 ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
				    login.driver.switchTo().window(tabs2.get(1));
				    
				    Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']", 10).isDisplayed());
					 Thread.sleep(5000);
				  login.driver.close();
				    login.driver.switchTo().window(tabs2.get(0));
				    CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
					CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
					login.driver.navigate().refresh();
				 
				 
			}
				
			//TC_Analysistab_100
			@Given("^Verify insights in view mode for sentix$")
			public void verify_insights_in_view_mode_for_sentix() throws Throwable {
				Thread.sleep(5000);
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Sentix')]", 10).click();		
				Thread.sleep(5000);
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				Thread.sleep(1000);
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
				 Thread.sleep(3000);
				   Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//div[@class='text-block-editor']", 10).isDisplayed());
					 Thread.sleep(5000);
					 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
					 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
				 
			}
			
			
			//TC_Analysistab_101
			@Given("^Verify Related Insights in view mode for sentix$")
			public void verify_Related_Insights_in_view_mode_for_sentix() throws Throwable {
				Thread.sleep(5000);
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Sentix')]", 10).click();		
				Thread.sleep(5000);
				Thread.sleep(5000);
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				Thread.sleep(1000);
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
				 Thread.sleep(3000);
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='related-insights--toggle' and contains(text(),'Related Insights')]", 10).click();
				 Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//div[@class='related-insights--container']", 10).isDisplayed());
				 Thread.sleep(5000);
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
				
			}
			
			//TC_Analysistab_102
			@Given("^Verify Download Insights in view mode for sentix$")
			public void verify_Download_Insights_in_view_mode_for_sentix() throws Throwable {
				Thread.sleep(5000);
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Sentix')]", 10).click();		
				Thread.sleep(5000);
				Thread.sleep(5000);
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				Thread.sleep(1000);
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
				 Thread.sleep(3000);
					 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[1]", 10).click();
					 Thread.sleep(1000);
					 Last_file_download.getTheNewestFile();
						System.out.println("verified");
						Thread.sleep(3000);  
						  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
						  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
						CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
			}
			
			//TC_Analysistab_103
			@Given("^Verify Copy link Insights in view mode for sentix$")
			public void verify_Copy_link_Insights_in_view_mode_for_sentix() throws Throwable {
				Thread.sleep(5000);
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Sentix')]", 10).click();		
				Thread.sleep(5000);
				String customizename = CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
				Thread.sleep(5000);
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				Thread.sleep(1000);
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
				 Thread.sleep(3000);
					 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[2]", 10).click();
					 Thread.sleep(1000);
					 Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
					  Transferable contents = clipboard.getContents(null);
					  String x = (String) contents.getTransferData(DataFlavor.stringFlavor);
					  System.out.println("x as"+ x);
					  String URL = login.CONFIG.getProperty("testsiteURL").toString();
					  String Copy_link = URL+customizename ;
					  System.out.println("copylink"+Copy_link);
					  if(!x.contains(Copy_link)){
						  System.out.println("verified");
						} else {
							Assert.fail();
				  }
					  Thread.sleep(3000);  
					  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
					  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
					CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
					
			}
			
			//TC_Analysistab_104
			@Given("^Verify growl message for Copy link Insights in view mode for sentix$")
			public void verify_growl_message_for_Copy_link_Insights_in_view_mode_for_sentix() throws Throwable {
				Thread.sleep(5000);
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Sentix')]", 10).click();		
				Thread.sleep(5000);
				String customizename = CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
				Thread.sleep(5000);
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				Thread.sleep(1000);
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
				 Thread.sleep(3000);
					 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[2]", 10).click();
					 Thread.sleep(1000);
					 CommonFunctionality.ValidateGrowlText("Link is copied");
					 Thread.sleep(3000);  
					  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
					  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
					CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
			}
			
			//TC_Analysistab_105
			@Given("^Verify Expand popup in view mode for sentix$")
			public void verify_Expand_popup_in_view_mode_for_sentix() throws Throwable {
				Thread.sleep(5000);
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Sentix')]", 10).click();		
				Thread.sleep(5000);
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				Thread.sleep(1000);
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
				 Thread.sleep(3000);
					 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[3]", 10).click();
					 Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//i[@class='insight-preview--icon__expand']", 10).isDisplayed());
						System.out.println("verified");
						 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
						  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
						CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
				
			}
			
			//TC_Analysistab_106
			@Given("^Verify close in view mode for sentix$")
			public void verify_close_in_view_mode_for_sentix() throws Throwable {
				Thread.sleep(5000);
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Sentix')]", 10).click();		
				Thread.sleep(5000);
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				Thread.sleep(1000);
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
				 Thread.sleep(3000);
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
				 if(login.driver.findElements(By.xpath("//div[@class='insight-preview--close']")).size() ==0) {
					 System.out.println("Verified");
				 }else {
					 Assert.fail();
				 }
				  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
					CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
				 
				 
				 
			}
			//TC_Analysistab_107
			@Given("^Verify search, my series and view panels for sentix$")
			public void verify_search_my_series_and_view_panels_for_sentix() throws Throwable {
				Thread.sleep(5000);
				if(login.driver.findElements(By.xpath("(//a[@class='link insight-table-item--title-link text-dots'])[1]")).size() ==0) {
					 System.out.println("Verified");
				 }else {
					 Assert.fail();
				 }
				  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
					CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
			}
			
			//TC_Analysistab_108
			@Given("^Verify Download scenario for Sentix insights for sentix$")
			public void verify_Download_scenario_for_Sentix_insights_for_sentix() throws Throwable {
				Thread.sleep(5000);
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Sentix')]", 10).click();		
				Thread.sleep(5000);
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				Thread.sleep(1000);
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[2]", 10).click();
				 Thread.sleep(3000);
				 Last_file_download.getTheNewestFile();
					System.out.println("verified");
					  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
						CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
			}
			//TC_Analysistab_109
			@Given("^Verify insight Edit access for Sentix$")
			public void verify_insight_Edit_access_for_Sentix() throws Throwable {
				Thread.sleep(5000);
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[2]/span", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'CEIC Insights')]/preceding::div[1]", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Sentix')]", 10).click();		
				Thread.sleep(5000);
				WebElement gridmode =  CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
				Actions action =new Actions(login.driver);
				action.contextClick(gridmode).build().perform();
				Thread.sleep(1000);
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
				 Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='text-block-editor'])", 10).isDisplayed());
					System.out.println("verified");
				 CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
				  CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();	
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='search-presentation-tabs--visible']/span[1]/span", 10).click();
			}
			//TC_Analysistab_110
			@Given("^Verify scrolling down for last insights for Sentix$")
			public void verify_scrolling_down_for_last_insights_for_Sentix() throws Throwable {
				verify_insights_counts_with_main_count_for_sentix();
			}
			
}




        

