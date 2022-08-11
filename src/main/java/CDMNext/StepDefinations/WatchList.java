package CDMNext.StepDefinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class WatchList {
	Actions action=new Actions(login.driver);
	Sprintcases_4_9 s9=new Sprintcases_4_9();
	ArrayList<String> fileWrite=new ArrayList<String>() ;
	ArrayList<String> fileRead=new ArrayList<String>() ;
	ArrayList<String> compare=new ArrayList<String>();
	ArrayList<String> release=new ArrayList<String>();
	ArrayList<String> compareRead=new ArrayList<String>();
	ArrayList<String> releaseRead=new ArrayList<String>();
	Map map=new Map();

	@And("^Select a few series from left and right pane$")
	public void select_a_few_series_from_left_and_right_pane() throws Throwable
	{
		delete_watlist();
		
		Thread.sleep(4000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
		for(int i=1;i<=5;i++)
		{
			Thread.sleep(2000);
			String str=login.driver.findElement(By.xpath("(//div[@class='series-item--name'])["+i+"]")).getText().toString();
			fileWrite.add(str);
			  
			  	
			login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])["+i+"]")).click();
			System.out.println(fileWrite.get(i-1));
		}
		
	}
	@And("^Add to watchlist \"([^\"]*)\"$")
	public void add_to_watchlist(String str) throws InterruptedException
	{
		Thread.sleep(3000);
		action.contextClick().build().perform();
		action.moveToElement(login.driver.findElement(By.xpath("//span[contains(text(),'Add to Watchlist')]"))).build().perform();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//input[@name='"+str+"']/following::span[@class='input-control--indicator'][1]")).click();
        	login.driver.findElement(By.xpath("//div[contains(text(),'Apply')]")).click();
    }
	@Then("^Check if series are added in watchlist tab$")
	public void check_if_series_are_added_in_watchlist_tab() throws InterruptedException
	{
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("(//span[contains(text(),'Watchlist')])[1]")).click();
		List<WebElement> l=login.driver.findElements(By.xpath("//div[@class='series-item--name']"));
		for(WebElement l1:l)
		{
			String str=l1.getText().toString();
			fileRead.add(str);
		}
			
			 for(int i=0;i<=fileWrite.size()-1;i++)
			{
				for(int j=0;j<fileRead.size()-1;j++)
				{
				if(fileWrite.get(i).equalsIgnoreCase(fileRead.get(j)))
                    {
	                     System.out.println(fileRead.get(j).toString());
                    }
				}
			}
		
	}
	@And("^Select a few tables from left  pane$")
	public void select_a_few_tables_from_left_pane() throws Throwable
	{
		delete_watlist();
		s9.in_database_tree_expand_globa_db_Afghanistan_Afghanistan_National_Accounts();
		for(int i=6;i<=12;i++) {
			Thread.sleep(2000);
			String str=login.driver.findElement(By.xpath("(//span[@class='name-text'])["+i+"]")).getText().toString();
			  
			fileWrite.add(str);
			login.driver.findElement(By.xpath("(//span[@class='name-text'])["+i+"]/parent::span/parent::a/preceding-sibling::span")).click();
		}
		//System.out.println(fileWrite);
		
	}
@Then("^Check if tables are added in watchlist tab$")
public void check_if_tables_are_added_in_watchlist_tab() throws InterruptedException
{
	Thread.sleep(2000);
	login.driver.findElement(By.xpath("(//span[contains(text(),'Watchlist')])[1]")).click();
	List<WebElement> l=login.driver.findElements(By.xpath("//div[@class='series-data-set--table-name']"));
	for(int i=1;i<=l.size()-1;i++)
	{
		String str=l.get(i).getText().toString();
		fileRead.add(str);	
		}
	
		 for(int i=0;i<=fileWrite.size()-1;i++)
		{
			// System.out.println(fileWrite.get(i));
			for(int j=0;j<fileRead.size()-1;j++)
			{
				//System.out.println(fileRead.get(j));
			if(fileWrite.get(i).equalsIgnoreCase(fileRead.get(j)))
                {
                     System.out.println("equal");
                }
			}
		}
	}
public void delete_watlist() throws Throwable
{
	Thread.sleep(2000);
	login.driver.findElement(By.xpath("(//span[contains(text(),'Watchlist')])[1]")).click();
	Thread.sleep(4000);
	if(login.driver.findElement(By.xpath("(//span[@class='input-control--indicator'])[11]")).isDisplayed())
	{
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("(//span[@class='input-control--indicator'])[11]")).click();
		login.driver.findElement(By.xpath("//div[@class='button button__sm watchlist--remove']")).click();
	Thread.sleep(2000);
	login.driver.findElement(By.xpath("(//span[contains(text(),'Data')])[1]")).click();
    }
else
{
	Thread.sleep(2000);
	login.driver.findElement(By.xpath("(//span[contains(text(),'Data')])[1]")).click();
}
}
@And("^Select a few tables from all tabs \"([^\"]*)\" \"([^\\\"]*)\" \"([^\"]*)\"$")
public void select_a_few_tables_from_al_3_tabs(String str,String str1,String str2) throws Throwable
{
	
	
	Thread.sleep(2000);
	delete_watlist();
		
		if(str.equalsIgnoreCase("Data"))
		{
			Thread.sleep(2000);
			select_a_few_tables_from_left_pane();
			

	    }
		
		if(str1.equalsIgnoreCase("Comparables"))
		{
			login.driver.findElement(By.xpath("(//span[contains(text(),'Comparables')])[1]")).click();
			login.driver.findElement(By.xpath("//div[@data-node-model-id='National Accounts']/div[@class='toggle']")).click();
			login.driver.findElement(By.xpath("//div[@data-node-model-id='Global Economic Monitor National Accounts']/div[@class='toggle']")).click();
			login.driver.findElement(By.xpath("//div[@data-node-model-id='Real GDP: Q-o-Q Growth: Quarterly: Seasonally Adjusted: Asia|||Global Economic Monitor National Accounts']/div[@class='toggle']")).click();
			List<WebElement> l=login.driver.findElements(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])"));
			for(int i=1;i<=4;i++)
			{
				login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])["+i+"]")).click();
				String str4=login.driver.findElement(By.xpath("(//div[@class='series-item--name'])["+i+"]")).getText().toString();
				compare.add(str);
				System.out.println(str4);
				
			}
			
		 }
		 if(str2.equalsIgnoreCase("Releases"))
		{
			login.driver.findElement(By.xpath("(//span[contains(text(),'Releases')])[1]")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("(//div[@class='release-scheduler-tree-node--markers'])[1]/following::div[@class='toggle'][1]")).click();
			Thread.sleep(4000);
			//List<WebElement> l=login.driver.findElements(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])"));
			for(int i=1;i<=4;i++)
			{
				login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])["+i+"]")).click();
				String str5=login.driver.findElement(By.xpath("(//div[@class='series-item--name'])["+i+"]")).getText().toString();
				release.add(str);
				System.out.println(str5);
				
			}
			
	   }
 
}

@Then("^Check if selected series are added in watchlist tab$")
public void check_if_selected_series_are_added_in_watchlist_tab() throws Throwable
{
	Thread.sleep(2000);
	login.driver.findElement(By.xpath("(//span[contains(text(),'Watchlist')])[1]")).click();
	List<WebElement> l=login.driver.findElements(By.xpath("//div[@class='series-data-set--table-name']"));
	for(int i=0;i<=l.size()-1;i++)
	  {
		Thread.sleep(2000);
		String str=l.get(i).getText().toString();
		fileRead.add(str);	
		}
	
		 for(int i=0;i<=fileWrite.size()-1;i++)
		{
			// System.out.println(fileWrite.get(i));
			for(int j=0;j<=fileRead.size()-1;j++)
			{
				//System.out.println(fileRead.get(j));
			if(fileWrite.get(i).equalsIgnoreCase(fileRead.get(j)))
                {
                     System.out.println("equal");
                }
			}
		}
		 
				 List<WebElement> l3=login.driver.findElements(By.xpath("//div[@class='series-item--name']"));
				 for(int i=0;i<=l3.size()-1;i++)
					{
						Thread.sleep(2000);
						String str=l3.get(i).getText().toString();
						releaseRead.add(str);
						System.out.println(releaseRead.get(i).toString());
					}
						
				 for(int j=0;j<=3;j++)
						 {
					 for(int i=0;i<=3;i++)
					 {
							if(release.get(j).equalsIgnoreCase(releaseRead.get(i)))
			                    {
				                     System.out.println(release.get(j).toString());
			                    }
					 }
						 }
				 for(int j=0;j<=3;j++)
				 {
					 for(int i=4;i<=7;i++)
					 {
						 
						 if(compare.get(j).equalsIgnoreCase(releaseRead.get(i)))
					                    {
						                     System.out.println(compare.get(j).toString());
					                    }
					}
				 }
		 
}
@And("^Add a series to watchlist$")
public void add_a_series_to_watchlist() throws Throwable
{
	Thread.sleep(2000);
	delete_watlist();
	Thread.sleep(2000);
	select_a_few_series_from_left_and_right_pane();
	
}
@And("^^Choose Popup-notification \"([^\"]*)\"$")
public void choose_popup_notification(String str) throws InterruptedException
{
	add_to_watchlist(str);
}
@Then("^Highlight the series in watchlist and click bell-icon \"([^\"]*)\"$")
public void highlight_the_series_in_watchlist_and_click_bell_icon(String str) throws InterruptedException
{
	Thread.sleep(2000);
	login.driver.findElement(By.xpath("(//span[contains(text(),'Watchlist')])[1]")).click();
	
	Thread.sleep(2000);
	if(login.driver.findElements(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']")).size()>=1)
	{
		System.out.println("checkbox is clicked");
	
		List<WebElement> l3=login.driver.findElements(By.xpath("//div[@class='series-item--name']"));
		for(int i=1;i<=l3.size();i++)
		{
			action.moveToElement(login.driver.findElement(By.xpath("(//div[@class='series-item--name'])["+i+"]"))).build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("(//span[@title-en='Add to watchlist'])["+i+"]")).click();
			if(login.driver.findElements(By.xpath("//input[@name='"+str+"']/following::span[@class='input-control--indicator'][1]")).size()>=1)
			{
				System.out.println("popup notification is selected");
			}
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[contains(text(),'Apply')]")).click();
		}
	}
	
}
@And("^Check Email notifications \"([^\"]*)\" \"([^\"]*)\"$")
public void check_email_notifications(String str,String str1) throws Throwable
{
	Thread.sleep(3000);
	action.contextClick().build().perform();
	action.moveToElement(login.driver.findElement(By.xpath("//span[contains(text(),'Add to Watchlist')]"))).build().perform();
	Thread.sleep(2000);
	login.driver.findElement(By.xpath("//input[@name='"+str+"']/following::span[@class='input-control--indicator'][1]")).click();
	//login.driver.findElement(By.xpath("(//span[@class='input-control--indicator'])[13]")).click();
	login.driver.findElement(By.xpath("//span[contains(text(),'"+str1+"')]")).click();
	
    	login.driver.findElement(By.xpath("//div[contains(text(),'Apply')]")).click();
}	
@And("^Go to watchlist and select the series and click edit alert drop-down \"([^\"]*)\" \"([^\"]*)\"$")
public void go_to_watchlist_and_select_the_series_and_click_edit_alert_drop_down(String str,String str1) throws Throwable
{
	choose_popup_notification("popup_notifications");
	Thread.sleep(2000);
	login.driver.findElement(By.xpath("(//span[contains(text(),'Watchlist')])[1]")).click();
	login.driver.findElement(By.xpath("//span[contains(text(),'Edit alert')]")).click();
	login.driver.findElement(By.xpath("//input[@name='popup_notifications']/following::span[@class='input-control--indicator'][1]")).click();
	login.driver.findElement(By.xpath("//input[@name='"+str+"']/following::span[@class='input-control--indicator'][1]")).click();
	
	login.driver.findElement(By.xpath("//span[contains(text(),'"+str1+"')]")).click();
	login.driver.findElement(By.xpath("//div[contains(text(),'Apply')]")).click();
	Thread.sleep(2000);
}
@And("^Go to watchlist and select the series and click edit alert drop-down1 \"([^\"]*)\" \"([^\"]*)\"$")
public void go_to_watchlist_and_select_the_series_and_click_edit_alert_drop_down1(String str,String str1) throws Throwable
{
	choose_popup_notification("email_notifications");
	Thread.sleep(2000);
	login.driver.findElement(By.xpath("(//span[contains(text(),'Watchlist')])[1]")).click();
	login.driver.findElement(By.xpath("//span[contains(text(),'Edit alert')]")).click();
		login.driver.findElement(By.xpath("//input[@name='email_notifications']/following::span[@class='input-control--indicator'][1]")).click();
		if(str1.length()>0)
		{
			login.driver.findElement(By.xpath("//input[@name='"+str1+"']/following::span[@class='input-control--indicator'][1]")).click();

		}
	//login.driver.findElement(By.xpath("//input[@name='"+str1+"']/following::span[@class='input-control--indicator'][1]")).click();
	
	login.driver.findElement(By.xpath("//div[contains(text(),'Apply')]")).click();
	Thread.sleep(2000);
}
@And("^Select a series and table under watchlist \"([^\"]*)\"$")
public void select_a_series_and_table_under_watchlist(String str) throws Throwable
{
	delete_watlist();
	select_a_few_tables_from_left_pane();
	Thread.sleep(4000);
	login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
	for(int i=1;i<=5;i++)
	{
		Thread.sleep(2000);
		String str1=login.driver.findElement(By.xpath("(//div[@class='series-item--name'])["+i+"]")).getText().toString();
		fileWrite.add(str1);
		  
		  	
		login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])["+i+"]")).click();
		
	}
	System.out.println(fileWrite);
	add_to_watchlist(str);
}
@Then("^Click on delete$")
public void click_on_delete() throws Throwable {
	Thread.sleep(2000);
	login.driver.findElement(By.xpath("(//span[contains(text(),'Watchlist')])[1]")).click();
	login.driver.findElement(By.xpath("//div[@class='button button__sm watchlist--remove']")).click();
	System.out.println("deleted");
	}
@And("^Open Watchlist tab \"([^\"]*)\"$")
public void open_watchlist_tab(String str) throws Throwable
{
	delete_watlist();
	Thread.sleep(4000);
	login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
	for(int i=1;i<=4;i++)
	{
		Thread.sleep(2000);
		String str1=login.driver.findElement(By.xpath("(//div[@class='series-item--name'])["+i+"]")).getText().toString();
		fileWrite.add(str1);
		  
		  	
		login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])["+i+"]")).click();
		
	}
	System.out.println(fileWrite);
	add_to_watchlist(str);
	Thread.sleep(2000);
	login.driver.findElement(By.xpath("(//span[contains(text(),'Watchlist')])[1]")).click();
}
@Then("^Change the switch of Enable All to \"([^\"]*)\"$")
public void change_the_switch_of_enable_all_to(String str) throws InterruptedException
{
	login.driver.findElement(By.xpath("//span[contains(text(),'OFF')]")).click();
	Thread.sleep(2000);
	System.out.println("enabled");
}
@And("^Add series with different updated dates to watchlist \"([^\"]*)\"$")
public void add_series_with_different_updated_dates_to_watchlist(String str) throws Throwable
{
	open_watchlist_tab(str);
}
@Then("^Select recently updated option$")
public void select_recently_updated_option() throws InterruptedException
{
	Thread.sleep(2000);
	String str=login.driver.findElement(By.xpath("(//span[@class='text-dots'])[1]")).getText().toString();
	System.out.println(str);
	if(str.equalsIgnoreCase("Recently updated"))
	{
		System.out.println("equal");
	}
}
@And("^Add series to watchlist \"([^\"]*)\"$")
public void add_series_to_watchlist(String str) throws Throwable
{
	add_series_with_different_updated_dates_to_watchlist(str);
	
}
@Then("^select \"([^\"]*)\" option1$")
public void select_option(String str) throws InterruptedException
{
	Thread.sleep(2000);
	login.driver.findElement(By.xpath("(//span[@class='dropdown--icon icon--filter-arrow'])[2]")).click();
	login.driver.findElement(By.xpath("//div[@title='"+str+"']")).click();
	select_recently_updated_option();
	
}
@And("^Add series with different frequencies to watchlist \"([^\"]*)\"$")
public void add_series_with_different_frequencies_to_watchlist(String str) throws Throwable
{
	Thread.sleep(2000);
	login.driver.findElement(By.xpath("//span[contains(text(),'Frequency')]")).click();
	Thread.sleep(2000);
	login.driver.findElement(By.xpath("//span[@title='Weekly']/parent::div/preceding-sibling::div//span[@class='input-control--indicator']")).click();
	login.driver.findElement(By.xpath("//div[contains(text(),'Apply filter')]")).click();
	
	Thread.sleep(4000);
	login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
	for(int i=1;i<=4;i++)
	{
		Thread.sleep(2000);
		String str1=login.driver.findElement(By.xpath("(//div[@class='series-item--name'])["+i+"]")).getText().toString();
		fileWrite.add(str1);
		  
		  	
		login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])["+i+"]")).click();
		
	}
	System.out.println(fileWrite);
	add_to_watchlist(str);
	Thread.sleep(2000);
	login.driver.findElement(By.xpath("(//span[contains(text(),'Watchlist')])[1]")).click();
}
@And("^Add series with different Region to watchlist \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
public void add_series_with_different_region_to_watchlist(String arg1,String str,List<String> str2,String str3) throws Throwable
{
	delete_watlist();
	map.click_On_Dropdown(arg1);
	map.select_subnational_as_region(str);
	map.select_Subregion(str2);
	Thread.sleep(4000);
	login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
	for(int i=1;i<=4;i++)
	{
		Thread.sleep(2000);
		String str1=login.driver.findElement(By.xpath("(//div[@class='series-item--name'])["+i+"]")).getText().toString();
		fileWrite.add(str1);
		  
		  	
		login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])["+i+"]")).click();
		
	}
	System.out.println(fileWrite);
	add_to_watchlist(str3);
	Thread.sleep(2000);
	login.driver.findElement(By.xpath("(//span[contains(text(),'Watchlist')])[1]")).click();
}
@Then("^Change the orientation order$")
public void change_the_orientation_order()
{
	login.driver.findElement(By.xpath("(//span[@class='icon--arrow-sort-asc sort-select-title--directions-box-icon'])[1]")).click();
}
@And("^Add (\\d+) series into watchlist having series \"([^\"]*)\"$")
public void add_series_into_watchlist_having_series(int str,String j) throws Throwable
{
	delete_watlist();
	int i=1;
	Thread.sleep(4000);
	login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
	
	for( i=1;i<=str;i++)
	{
		Thread.sleep(500);
		String str1=login.driver.findElement(By.xpath("(//div[@class='series-item--name'])["+i+"]")).getText().toString();
		fileWrite.add(str1);
	  login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])["+i+"]")).click();
	  System.out.println(i);
	}
	

	System.out.println(fileWrite);
	add_to_watchlist(j);
	Thread.sleep(2000);
	login.driver.findElement(By.xpath("(//span[contains(text(),'Watchlist')])[1]")).click();
}
@And("^Add (\\d+) into watchlist having series \"([^\"]*)\"$")
public void add_into_watchlist_having_series(int str,String j) throws Throwable
{
	delete_watlist();
	int i=1;
	Thread.sleep(4000);
	login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();

	for( i=1;i<=str;i++)
	{
		
		String str1=login.driver.findElement(By.xpath("(//div[@class='series-item--name'])["+i+"]")).getText().toString();
		fileWrite.add(str1);
	  login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])["+i+"]")).click();
	  System.out.println(i);
	}
	
		 System.out.println(fileWrite);
			add_to_watchlist(j);
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("(//span[contains(text(),'Watchlist')])[1]")).click();
			Thread.sleep(2000);
}
}







