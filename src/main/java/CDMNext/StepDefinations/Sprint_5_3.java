package CDMNext.StepDefinations;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class Sprint_5_3 {
	public String str;
	public String parentwindow;
	public String currentwindow;
	Actions action=new Actions(login.driver);
	SprintCases_4_7 s7=new SprintCases_4_7();
	public static WebDriverWait wait = new WebDriverWait(login.driver, 1000);
	Map c=new Map();
	WatchList l1=new WatchList();
	@And("^Open indicator popup$")
	public void open_indicator_popup() throws InterruptedException
	{
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Indicator')]")).click();
	
	}
	@And("^Navigate to All tab$")
	public void navigate_to_all_tab() throws InterruptedException
	{
		Thread.sleep(1000);
		login.driver.switchTo().activeElement();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[contains(text(),'All')]")).click();
	}
	@Then("^Mouse move on the indicator in right panel$")
	public void mouse_move_on_the_indicator_in_right_panel() throws InterruptedException
	{
		Thread.sleep(1000);
		action.moveToElement(login.driver.findElement(By.xpath("(//div[@class='filter-item--body']//span[@title='Gross Domestic Product'])"))).build().perform();
		if(login.driver.findElement(By.xpath("(//button[contains(text(),'Drilldown')])[1]")).isDisplayed())
		{
			System.out.println("displayed");
		}
	}
	@Then("^Click on Drilldown$")
	public void click_on_drilldown() throws InterruptedException
	{
		login.driver.findElement(By.xpath("(//button[contains(text(),'Drilldown')])[1]")).click();
		Thread.sleep(1000);
		if(login.driver.findElement(By.xpath("(//div[@class='tree-filter-item--close-icon'])[1]")).isDisplayed())
		{
			System.out.println("clicked");
		}
		
	}
	@Then("^Check the main indicator is selected$")
	public void check_the_main_indicator_is_selected()
	{
		String str=login.driver.findElement(By.xpath("//div[@class='category-item filter-item category-item__highlighted category-item__active']//span[@class='text-dots']")).getText().toString();
		System.out.println(str);
		List<WebElement> l1=login.driver.findElements(By.xpath("//div[@class='filter-list']//span[@class='text-dots']"));
	for(WebElement l:l1)
	{
		System.out.println(l.getText().toString());
	}
	
  }
	@Then("^Double click on the main indicator$")
	public void double_click_on_the_main_indicator()
	{
		String str=login.driver.findElement(By.xpath("//div[@class='category-item filter-item category-item__highlighted category-item__active']//span[@class='text-dots']")).getText().toString();
		action.doubleClick(login.driver.findElement(By.xpath("//div[@class='category-item filter-item category-item__highlighted category-item__active']//span[@class='text-dots']"))).build().perform();
		String str1=login.driver.findElement(By.xpath("//div[@class='category-item filter-item category-item__highlighted category-item__active']//span[@class='text-dots']")).getText().toString();
		if(str.equalsIgnoreCase(str1))
		{
			System.out.println("equal");
		}
	}
	@And("^Search with some keyword \"([^\"]*)\"$")
	public void search_with_some_keyword(String str) throws InterruptedException
	{
		Thread.sleep(1000);
		login.driver.switchTo().activeElement();
		login.driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys(str,Keys.ENTER);
	}
	@Then("^Check the result under \"([^\"]*)\" and \"([^\"]*)\" tab$")
	public void check_the_result_under_and_tab(String str,String str1) throws InterruptedException
	{
		Thread.sleep(2000);
		
			login.driver.findElement(By.xpath("//div[contains(text(),'"+str+"')]")).click();
			
			List<WebElement> l1=login.driver.findElements(By.xpath("//div[@class='filter-list']//span[@class='text-dots']"));
			for(WebElement l:l1)
			{
				System.out.println(l.getText().toString());
			}
		
			login.driver.findElement(By.xpath("//span[contains(text(),'"+str1+"')]")).click();
			List<WebElement> l2=login.driver.findElements(By.xpath("//div[@class='filter-list']//span[@class='text-dots']"));
			for(WebElement l:l2)
			{
				System.out.println(l.getText().toString());
			}
	}
	 @And("^Share an insight with User2$")
	 public void share_an_insight_with_user2() throws InterruptedException
	 {
		 login.driver.findElement(By.xpath("//a[contains(text(),'My insights')]")).click();
		 login.driver.findElement(By.xpath("//span[contains(text(),'Create insight')]")).click();
		 str= login.driver.findElement(By.xpath("//input[@ui='$name']")).getAttribute("value");
		 System.out.println(str);
		 login.driver.findElement(By.xpath("//button[contains(text(),'Create insight')]")).click();
		Thread.sleep(4000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
		for(int i=1;i<=5;i++)
		{
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])["+i+"]")).click();
	    }
	
		action.sendKeys((Keys.chord("a"))).build().perform();
		login.driver.findElement(By.xpath("//div[@title='Open File menu']")).click();	
		login.driver.findElement(By.xpath("//span[contains(text(),'Share')]")).click();
		login.driver.switchTo().activeElement();
		login.driver.findElement(By.xpath("//*[@class='share-specific-search-user--input form--control']")).click();
		Thread.sleep(1000);
		// Enter Email id

		login.driver.findElement(By.xpath("//*[@class='share-specific-search-user--input form--control']"))
				.sendKeys("venkat.test@gmail.com",Keys.ENTER);
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("(//span[contains(text(),'can view')]/following::span[@class='insight-share--choose-button-arrow'])[1]")).click();
		login.driver.findElement(By.xpath("(//span[contains(text(),'can edit')])")).click();
		login.driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();

		// confirmation
		login.driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
		//login.driver.quit();
		 parentwindow=login.driver.getWindowHandle();
		 System.out.println(parentwindow);
		}
	 @And("^login to User2 and Open the shared insight$")
	 public void login_to_user2_and_open_the_shared_insight() throws InterruptedException, AWTException
	 {
		 Robot robot = new Robot();
		 DesiredCapabilities capa = DesiredCapabilities.firefox();
			capa.setCapability("marionette", true);
			//WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\Resources\\geckodriver.exe");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"null");
			login.driver1 = new FirefoxDriver(capa);
			login.driver1.manage().window().maximize();
			login.driver1.get(login.CONFIG.getProperty("testsiteURL"));
			login.driver1.findElement(By.xpath(login.LOCATORS.getProperty("input_username"))).sendKeys("venkat.test@gmail.com");
			login.driver1.findElement(By.xpath(login.LOCATORS.getProperty("input_password"))).sendKeys("Ceic@123");
			login.driver1.findElement(By.xpath(login.LOCATORS.getProperty("btnlogin"))).click();
	        Thread.sleep(30000);
	        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'My insights')]"))).click();
			login.driver1.findElement(By.xpath("//a[contains(text(),'My insights')]")).click();
			Thread.sleep(2000);
			login.driver1.findElement(By.xpath("//div[@data-tab='shared']")).click();
			Thread.sleep(7000);
			login.driver1.findElement(By.xpath("//div[contains(text(),'"+str+"')]")).click();
			Thread.sleep(4000);
			login.driver1.switchTo().activeElement();
			login.driver1.findElement(By.xpath("//span[contains(text(),'Open')]")).click();
			Thread.sleep(2000);
			
			
			
	 }
	 @Then("^Make changes to the insight from User1$")
	 public void make_changes_to_the_insight_from_user1() throws InterruptedException
	 {
		 Thread.sleep(2000);
	     login.driver.switchTo().activeElement();
		 login.driver.findElement(By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[1]")).click();
		 login.driver.findElement(By.xpath("//div[@data-action='delete']")).click();
		 Thread.sleep(2000);
		 //login.driver.quit();
		 if(login.driver1.findElement(By.xpath("(//div[contains(text(),'Insight was changed')])[1]")).isDisplayed())
		 {
			 System.out.println("popup displayed");
			 login.driver1.quit();
		 }
	 }
	 @Then("^Make changes to the insight from User2$")
	 public void make_changes_to_the_insight_from_user2() throws InterruptedException
	 {
		 Thread.sleep(2000);
	     //login.driver1.switchTo().activeElement();
		 login.driver1.findElement(By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[1]")).click();
		 login.driver1.findElement(By.xpath("//div[@data-action='delete']")).click();
		 Thread.sleep(2000);
		 login.driver1.quit();
		 if(login.driver.findElement(By.xpath("(//div[contains(text(),'Insight was changed')])[1]")).isDisplayed())
		 {
			 System.out.println("popup displayed");
			// login.driver.quit();
		 }
	 }
	@And("^Add a data table to My series$")
	public void add_a_data_table_to_my_series() throws InterruptedException
	{
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("(//span[contains(text(),'Datasets')])")).click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//div[@data-node-model-id='TB85994']//span[@class='svg-checkbox']")).click();
		action.sendKeys((Keys.chord("a"))).build().perform();	
   }
	@And("^Expand the table$")
	public void expand_the_table() throws InterruptedException
	{
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//div[@class='webix_column list-series-name webix_first webix_last']//div[@class='webix_tree_close']")).click();
	}
	@Then("^Check the bold format for the Group title$")
	public void check_the_bold_format_for_the_group_title() throws InterruptedException
	{
		Thread.sleep(2000);
		if(login.driver.findElement(By.xpath("//div[@class='webix_cell new-series-item'][1]")).isDisplayed())
		{
			System.out.println("The Group name should be in bold when it's expanded.");
		}
	}
	@And("^Mouse move on the series in search and My series panels and Check for the i icon$")
	public void mouse_move_on_the_series_in_search_and_my_series_panels() throws InterruptedException
	{
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
		action.moveToElement(login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"))).build().perform();
		try {
		if(login.driver.findElements(By.xpath("(//div[@class='insights-notifications-item-avatar'])")).size()<1)
		{
			System.out.println("not found");
		}}
		catch(NoSuchElementException e)
		{
			System.out.println("not found");
		}
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[1]")).click();
		action.sendKeys((Keys.chord("a"))).build().perform();	
		action.moveToElement(login.driver.findElement(By.xpath("//span[@class='series-name-field--text']"))).build().perform();
		try {
			if(login.driver.findElements(By.xpath("(//div[@class='insights-notifications-item-avatar'])")).size()<1)
			{
				System.out.println("not found");
			}}
			catch(NoSuchElementException e)
			{
				System.out.println("not found");
			}
	}
	
	@And("^Select any indicator$")
	public void select_any_indicator() throws InterruptedException
	{
		login.driver.switchTo().activeElement();
		Thread.sleep(4000);
		login.driver.findElement(By.xpath("(//span[@class='input-control--indicator'])[13]")).click();
		//login.driver.findElement(By.xpath("//div[contains(text(),'Apply filter')]")).click();
	}
	@Then("Mouse move on the indicator in the pill box \"([^\"]*)\"$")
	public void mouse_move_on_the_indicator_in_the_pill_box(String str) throws InterruptedException
	{
		Thread.sleep(2000);
		action.moveToElement(login.driver.findElement(By.xpath("(//span[contains(text(),'"+str+"')])[2]"))).build().perform();
		System.out.println(login.driver.findElement(By.xpath("//div[@class='tooltip tooltip__visible']")).getText().toString());
		
		
	}
	@And("^Select any subnational \"([^\"]*)\"$")
	public void select_any_subnational(String str)
	{
		WebElement Subregion=login.driver.findElement(By.xpath("//div[@class='subnational--section subnational--section__first']//span[contains(text(),'"+str+"')]"));
		  Subregion.click();
		  
	}
	@And("^Create a visual \"([^\"]*)\"$")
	public void create_a_visual(int str) throws InterruptedException, AWTException
	{
		c.selectSeries(str);
		c.keyBoardmap();
	
	}
	@Then("^Click on CEIC logo1$")
	public void click_on_ceic_logo1() throws InterruptedException
	{
		c.click_on_EditMap();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("(//img[@ui='$credits'])[2]")).click();
		login.driver.switchTo().activeElement();
		str=login.driver.findElement(By.xpath("//div[@class='popover--title']")).getText().toString();
		if(str.equalsIgnoreCase("Copyright"))
		{
			System.out.println("The Copyright configuration popup should be displayed");
		}
		
	}
	@And("^Open the insight in view mode$")
	public void open_the_insight_in_view_mode() throws InterruptedException
	{
		Thread.sleep(4000);
		login.driver.findElement(By.xpath("//div[@title='Open File menu']")).click();	
		login.driver.findElement(By.xpath("(//span[contains(text(),'View')])[2]")).click();
		Thread.sleep(4000);
		
	}
	@Then("^Click on CEIC logo under a visual$")
	public void click_on_ceic_logo_under_a_visual()
	{
		login.driver.findElement(By.xpath("(//img[@ui='$credits'])[2]")).click();
		String parentwindow=login.driver.getWindowHandle();
		Set<String> l=login.driver.getWindowHandles();	
		Iterator<String> I1= l.iterator();

		while(I1.hasNext())
		{

		String child_window=I1.next();


		if(!parentwindow.equals(child_window))
		{
		login.driver.switchTo().window(child_window);

		System.out.println(login.driver.switchTo().window(child_window).getTitle());
		str=login.driver.getCurrentUrl();
		System.out.println(str);
		if(str.equalsIgnoreCase("https://www.ceicdata.com/en"))
		{
			System.out.println("equal");
			login.driver.close();
		}

		login.driver.switchTo().window(parentwindow);
		}
		}
		
	}
	@And("^Open Help \"([^\"]*)\" popup$")
	public void open_help_popup(String str) throws InterruptedException
	{
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='help-title--icon']")).click();
		login.driver.findElement(By.xpath("//div[contains(text(),'"+str+"')]")).click();
		Thread.sleep(4000);
		
		
	}
	@And("^Open dropdown for \"([^\"]*)\"$")
	public void open_dropdown_for(String str)
	{
		login.driver.switchTo().activeElement();
		login.driver.findElement(By.xpath("//div[contains(text(),'"+str+"')]/following::span[@class='select2-arrow'][1]")).click();
		
	}
	@Then("^Check for OS \"([^\"]*)\" in the dropdown$")
	public void check_for_os_in_the_dropdown(String str)
	{
		if(str.contains(";"))
		{
			String str1[]=str.split(";");
			
		if(login.driver.findElement(By.xpath("//div[contains(text(),'"+str1[0]+"')]")).isDisplayed() && login.driver.findElement(By.xpath("//div[contains(text(),'"+str1[1]+"')]")).isDisplayed() )
		{
			System.out.println("displayed");
		}
		}
		else
		{
			if(login.driver.findElement(By.xpath("//div[contains(text(),'"+str+"')]")).isDisplayed())
			{
				System.out.println("displayed");
			}
		}
	}
	@And("^Open any insights by having series$")
	public void ope_any_insights_by_having_series() throws InterruptedException
	{
		login.driver.findElement(By.xpath("//a[contains(text(),'My insights')]")).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//div[contains(text(),'Name your insight')]")).click();
		Thread.sleep(4000);
		login.driver.switchTo().activeElement();
		login.driver.findElement(By.xpath("//span[contains(text(),'Open')]")).click();
		Thread.sleep(4000);
		
	}
	@And("^Click on the Cogwheel icon$")
	public void click_the_cogwheel_icon() throws InterruptedException
	{
		login.driver.switchTo().activeElement();
		login.driver.findElement(By.xpath("//span[@class='series-panel--settings']")).click();
		
			//login.driver.findElement(By.xpath("//button[contains(text(),'Reset')]")).click();
		if(login.driver.findElements(By.xpath("//span[contains(text(),'Table mode')]/preceding::span[@class='input-control--indicator'][1]")).size()>1)
		{
			System.out.println("selected");
			login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			Thread.sleep(2000);
			
		}
		else {
		login.driver.findElement(By.xpath("//span[contains(text(),'Table mode')]/preceding::span[@class='input-control--indicator'][1]")).click();
		
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		}
		Thread.sleep(2000);
	}
	@Then("^Add some series1$")
	public void add_some_series1() throws InterruptedException
	{
	 login.driver.findElement(By.xpath("//div[@title='View results as List']")).click();
	    s7.Select_any_series1();
	    action.sendKeys((Keys.chord("a"))).build().perform();
	    if(login.driver.findElement(By.xpath("//span[contains(text(),'Table')]")).isSelected())
	    {
	    	System.out.println("tablemode is enabled");
	    }
	}
	@And("^Search for this series \"([^\"]*)\"$")
	public void search_for_this_series(String str) throws InterruptedException
	{
		s7.Search_for_series_in_layout(str);
		
	}
	@And("^Open the Data briefings$")
	public void open_the_data_briefing()
	{
		login.driver.findElement(By.xpath("//div[@title='Expand Briefings']")).click();
		login.driver.findElement(By.xpath("//div[@class='public-js-views-briefings-list-item-module__title']")).click();
	}
	@Then("^Click on See in Database$")
	public void click_on_see_in_database() throws InterruptedException
	{
		login.driver.findElement(By.xpath("//span[contains(text(),'See in Database')]")).click();
		List<WebElement> l1=login.driver.findElements(By.xpath("//span[@class='context-menu-item link   ']"));
		for(int i=0;i<=l1.size();i++)
		{
			l1.get(1).click();
			Thread.sleep(4000);
			break;
		}
		if(login.driver.findElement(By.xpath("//span[contains(text(),'Databases')]")).isSelected())
		{
			System.out.println("Redirected to corresponding database");
		}
		
	}
	@And("^Navigate to Series tab1$")
	public void navigate_to_series_tab() throws InterruptedException
	{
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
		action.moveToElement(login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"))).build().perform();
	}
	@Then("^Mouse move the See in database icon$")
	public void mouse_move_the_see_in_database_icon() throws InterruptedException
	{
		login.driver.findElement(By.xpath("(//span[@title='See in Database'])[1]")).click();
		List<WebElement> l1=login.driver.findElements(By.xpath("//span[@class='context-menu-item link   ']"));
		for(WebElement l:l1)
		{
			System.out.print(l.getAttribute("title"));
			
		}
	}
	@And("^Create a table visual2$")
	public void create_a_table_visual() throws Throwable
	{
		l1.select_a_few_series_from_left_and_right_pane();
		action.contextClick().build().perform();;
		action.moveToElement(login.driver.findElement(By.xpath("//span[contains(text(),'View as Table')]"))).click().perform();
		login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
	}
	@Then("^Right click on series1$")
	public void right_click_on_series() throws InterruptedException
	{
		Thread.sleep(3000);
		action.moveToElement(login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[1]"))).contextClick().build().perform();
		
			
	
			List<WebElement> l2=login.driver.findElements(By.xpath("//div[@class='items-wrapper']//span[@class='context-menu-item link']"));
			for(WebElement l3:l2)
			{
				System.out.println(l3.getAttribute("title"));
			}
			
		
	}
	@And("^Create a commentary visual$")
	public void create_a_commentary_visual() throws InterruptedException
	
	{
          login.driver.findElement(By.xpath("//div[@title='Create new View tab']")).click();
          Thread.sleep(2000);
          login.driver.findElement(By.xpath("//div[@title='Click or drag-and-drop to insert Commentary']")).click();
          
	}
	@Then("^Type this \"([^\"]*)\"$")
	public void type_this(String str) throws Throwable {
		Thread.sleep(2000);
		System.out.println("Enter into add some test");

		login.driver.switchTo().frame(login.driver.findElement(By.xpath("//*[@class='tox-edit-area__iframe']")));
	  //  login.driver.findElement(By.xpath("//*[@class='mce-content-body ']")).click();
		login.driver.findElement(By.xpath("//*[@class='mce-content-body ']")).sendKeys(str);
		login.driver.switchTo().defaultContent();

		Thread.sleep(1000);
		List<WebElement> l=login.driver.findElements(By.xpath("//div[@class='index-module_outer_text__zjDoF']"));
		for(WebElement l1:l)
		{
			System.out.println(l1.getText().toString());
		}
		
	}
	@Then("^select \"([^\"]*)\"$")
	public void select(String str)
	{
		login.driver.findElement(By.xpath("//div[contains(text(),'"+str+"')]")).click();
		login.driver.findElement(By.xpath("//div[@class='visual-top-panel--content']")).click();
		String str1=login.driver.findElement(By.xpath("//div[@class='text-block-editor']/p")).getText().toString();
		if(str1.equalsIgnoreCase(str))
		{
			System.out.println("equal");
		}
	}
	@Then("^select1 \"([^\"]*)\" \"([^\"]*)\"$")
	public void select1(String str,String str1)
	{
		login.driver.findElement(By.xpath("//div[contains(text(),'"+str+"')]")).click();
		login.driver.findElement(By.xpath("//div[contains(text(),'"+str1+"')]")).click();
	}
	@Then("^Unselect visual$")
	public void unselect_visual()
	{
		login.driver.findElement(By.xpath("//div[@class='visual-top-panel--content']")).click();
		String str1=login.driver.findElement(By.xpath("//div[@class='text-block-editor']/p")).getText().toString();
		System.out.println(str1);
	}
	@Then("^Select format \"([^\"]*)\"$")
	public void select_format(String str)
	{
		login.driver.findElement(By.xpath("//div[contains(text(),'DATE(format)')]")).click();
		
		login.driver.findElement(By.xpath("//div[contains(text(),'"+str+"')]")).click();
	}
	@And("^Right click on each series name on the visual \"([^\"]*)\"$")
	public void right_click_on_each_series_name_on_the_visual(String str) throws Throwable {
		login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		Thread.sleep(2000);
		String str1[]=str.split(";");
	List<WebElement> l1=login.driver.findElements(By.xpath("//span[@class='series-edit--title series-edit--title__editable']"));
	for(int i=1;i<=l1.size();i++)
	{
		Thread.sleep(2000);
		action.moveToElement(login.driver.findElement(By.xpath("(//span[@class='series-edit--title series-edit--title__editable'])["+i+"]"))).contextClick().build().perform();
		action.moveToElement(login.driver.findElement(By.xpath("//span[contains(text(),'Move to axis')]"))).build().perform();
		Thread.sleep(1000);
	    login.driver.findElement(By.xpath("//span[contains(text(),'"+str1[i-1]+"')]")).click();
		
	}
	
	}
	@Then("^Download1$")
    public void download1()
    {
		login.driver.findElement(By.xpath("(//span[contains(text(),'Download')])[1]")).click();
		List<WebElement>l1=login.driver.findElements(By.xpath("//div[@class='sc-bczRLJ bGLUfX']/p"));
		for(WebElement l:l1)
		{
			System.out.println(l.getText().toString());
		}
		
    }
	@Then("^Check the last value for all the series$")
	public void check_the_last_value_for_all_the_series() throws InterruptedException
	{



		login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		List<WebElement> l1=login.driver.findElements(By.xpath("//span[@class='series-edit--title series-edit--title__editable']"));
		for(int i=1;i<=l1.size();i++)
		{
			Thread.sleep(2000);
			action.moveToElement(login.driver.findElement(By.xpath("(//span[@class='series-edit--title series-edit--title__editable'])["+i+"]"))).build().perform();
			Thread.sleep(1000);
			String str=login.driver.findElement(By.xpath("(//td[contains(text(),'Last value')]/following::td/div)[1]")).getText().toString();
			System.out.println(str);
			Thread.sleep(2000);
		
		
			
		
	   }
		


	}
	
 }