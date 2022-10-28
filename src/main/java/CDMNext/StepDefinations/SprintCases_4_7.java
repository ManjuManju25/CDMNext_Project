package CDMNext.StepDefinations;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SprintCases_4_7 {
	JavascriptExecutor js = (JavascriptExecutor) login.driver;
	Actions a=new Actions(login.driver);
	Sprintcases_4_6 s6 =new Sprintcases_4_6();
	public String NotificationText;
Map c=new Map();
	@Given("^click on Datasets tab$")
	public void click_on_Datasets_tab() throws Throwable {
		Thread.sleep(4000);

		login.driver.findElement(By.xpath("//span[contains(text(),'Datasets')]")).click();

	}
	@Given("^click on more button$")
	public void click_on_more_button() throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//span[contains(text(),'More')]")).click();
		Thread.sleep(3000);
	}
	@And("^Create two visuals in single view1$")
	public void create_two_visuals_in_single_view1() throws Throwable {
	    
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[text()='Series']")).click();
		
		
		
		Thread.sleep(3000);

		WebElement rightclick = login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"));
		a.contextClick(rightclick).build().perform();
		login.driver.findElement(By.xpath("//span[text()='View as Chart']")).click();

		Thread.sleep(3000); 	 	
		login.driver.findElement(By.xpath("(//div[@class='icon--map-world'])[1]")).click();
		Thread.sleep(3000);
		
		
		
		
		
		
	}

	@Then("^Mouse move on visual header1 \"([^\"]*)\"$")
	public void mouse_move_on_visual_header1(String arg1) throws Throwable {
	   
		Thread.sleep(2000);
		WebElement drag=login.driver.findElement(By.xpath("(//div[@title='Add to insight'])[1]"));
		
		JavascriptExecutor js = (JavascriptExecutor)login.driver ;
		js.executeScript("arguments[0].scrollIntoView();", drag);
		Thread.sleep(2000);
		
		WebElement dragfrom=login.driver.findElement(By.xpath("(//div[@class='visual-title ui-draggable ui-draggable-handle visual-drag__cursor'])[1]"));
		
		WebElement dropTo=login.driver.findElement(By.xpath("(//div[@class='empty-visual-overlay--content'])[1]"));
		
		Actions builder = new Actions(login.driver);
		
		
		builder.dragAndDrop(dragfrom, dropTo).perform();
		Thread.sleep(2000);
		
	}
	
	@Given("^checked \"([^\"]*)\" and click on Apply filter button$")
	public void checked_and_click_on_Apply_filter_button(String arg1) throws Throwable {
		Thread.sleep(2000);

		WebElement statusicon = login.driver.findElement(By.xpath("//*[@title='With suggestions for rebased/discontinued series']"));
		js.executeScript("arguments[0].scrollIntoView(true);", statusicon);
		login.driver.findElement(By.xpath("//*[@title='With suggestions for rebased/discontinued series']")).click();

		// click on apply filter
		login.driver.findElement(By.xpath("//div[contains(text(),'Apply filter')]")).click();

	}
	@And("^Create two visuals in single view$")
	public void create_two_visuals_in_single_view() throws Throwable {
	    
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[text()='Series']")).click();
		Thread.sleep(3000);
     WebElement rightclick = login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"));
		a.contextClick(rightclick).build().perform();
		login.driver.findElement(By.xpath("//span[text()='View as Chart']")).click();

		Thread.sleep(3000); 	 	
		login.driver.findElement(By.xpath("(//div[@class='icon--map-world'])[1]")).click();
		Thread.sleep(3000);
		}

	@Then("^Mouse move on visual header \"([^\"]*)\"$")
	public void mouse_move_on_visual_header(String arg1) throws Throwable {
	   
		Thread.sleep(2000);
		WebElement drag=login.driver.findElement(By.xpath("(//div[@title='Add to insight'])[1]"));
		
		JavascriptExecutor js = (JavascriptExecutor)login.driver ;
		js.executeScript("arguments[0].scrollIntoView();", drag);
		Thread.sleep(2000);
		
		WebElement dragfrom=login.driver.findElement(By.xpath("(//div[@class='visual-title ui-draggable ui-draggable-handle visual-drag__cursor'])[1]"));
		
		WebElement dropTo=login.driver.findElement(By.xpath("(//div[@class='empty-visual-overlay--content'])[1]"));
		
		Actions builder = new Actions(login.driver);
		
		
		builder.dragAndDrop(dragfrom, dropTo).perform();
		Thread.sleep(2000);
		
	}
	
	@Given("^Click \"([^\"]*)\" on the bottom of list$")
	public void click_on_the_bottom_of_list(String arg1) throws Throwable {

		Thread.sleep(2000);

		WebElement Loadmore = login.driver.findElement(
				By.xpath("//*[@class='button button__sm button__text_purple button__block nodes-list--more-button']"));
		js.executeScript("arguments[0].scrollIntoView(true);", Loadmore);

		login.driver
				.findElement(By.xpath(
						"//*[@class='button button__sm button__text_purple button__block nodes-list--more-button']"))
				.click();

	}
	@Then("^verify Load more button should work and load series$")
	public void verify_Load_more_button_should_work_and_load_series() throws Throwable {

		// if(Loadmore=="Loadmore")

		WebElement Loadmore = login.driver.findElement(
				By.xpath("//*[@class='button button__sm button__text_purple button__block nodes-list--more-button']"));
		js.executeScript("arguments[0].scrollIntoView(true);", Loadmore);
		Thread.sleep(2000);
		System.out.println("verifyed Load more button should work and load series");

	}
	// TC_18788_01
		@Given("^Click on notification icon$")
		public void click_on_notification_icon() throws Throwable {
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//div[@class='user-notifications--icon']")).click();
		}
		@Given("^Click on notification tab$")
		public void click_on_notification_tab() throws Throwable {
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//div[contains(text(),'Notifications')]")).click();

		}
		@Given("^Observe the text \"([^\"]*)\" on header of the notifications$")
		public void observe_the_text_on_header_of_the_notifications(String arg1) throws Throwable {
			Thread.sleep(1000);

			NotificationText = login.driver
					.findElement(By.xpath("//div[contains(text(),'Your notifications for the last 30 days')]")).getText();

			System.out.println("NotificationText:" + NotificationText);

			Assert.assertEquals(NotificationText, arg1);

		}
		@Then("^\"([^\"]*)\" should be present$")
		public void should_be_present(String NotificationData) throws Throwable {

			System.out.println("NotificationData:" + NotificationData);
			System.out.println("NotificationText:" + NotificationText);

			if (NotificationData.equals(NotificationText)) {
				System.out.println("Your notifications for the last 30 days should be present");

			} else {
				Assert.fail();

			}
		}
		@Given("^click on frequency dropdown$")
		public void click_on_frequency_dropdown() throws Throwable {
			Thread.sleep(1000);

			login.driver.findElement(By.xpath("//span[contains(text(),'Frequency')]")).click();

			Thread.sleep(1000);
		}
		@Then("^check the frequency order as \"([^\"]*)\"$")
		public void check_the_frequency_order_as(String arg1) throws Throwable {
			Thread.sleep(3000);

			List<String> sname = new ArrayList<>();

			for (int i = 2; i <= 9; i++) {

				String frequencyOrder = login.driver.findElement(By.xpath("(//span[@class='text-dots'])[" + i + "]"))
						.getText();
				System.out.println("frequencyOrder:" + frequencyOrder);
				sname.add(frequencyOrder);
				System.out.println("static values:" + arg1);
			}

			String ordername[] = arg1.split(",");

			int count = ordername.length;
			System.out.println(count);
			System.out.println(sname.size());

			int countvalue = 0;

			for (String dropdown : ordername) {
				if (sname.contains(dropdown)) {
					countvalue++;
				}

			}
		}
		@And("^Create table visual$")
		public void create_table_visual() throws Throwable {
			Thread.sleep(3000);

			// click on series tab
			login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();

		
				// checked 1st series
				Thread.sleep(4000);
				login.driver.findElement(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']")).click();

				// click on + icon Right side panel

				login.driver.findElement(By.xpath("//div[@class='insight-page-menu-views-container--add']")).click();

				// click on Table

				login.driver.findElement(By.xpath("(//div[@class='view-components-over--visual-title'])[3]")).click();
			
		}
		@Given("^Click on Edit table$")
		public void click_on_Edit_table() throws Throwable {

			Thread.sleep(2000);

			login.driver.findElement(By.xpath("//button[contains(text(),'Edit Table')]")).click();
		}
		@Given("^Uncheck the Invert and click on Save button$")
		public void uncheck_the_Invert_and_click_on_Save_button() throws Throwable {

			Thread.sleep(1000);

			login.driver.findElement(By.xpath("//span[contains(text(),'Invert')]")).click();
			// click on save button

			login.driver.findElement(By.xpath("//button[@class='button button__primary']")).click();
		}
		@Given("^Click on date stamp on header$")
		public void click_on_date_stamp_on_header() throws Throwable {

			Thread.sleep(1000);

			login.driver.findElement(By.xpath("//span[contains(text(),'1Y')]")).click();
		}

		// TC_18782_01
		@Given("^click on Save period button$")
		public void click_on_Save_period_button() throws Throwable {
			Thread.sleep(1000);

			login.driver.findElement(By.xpath("//button[contains(text(),'Save period')]")).click();
		}

		

		// TC_18782_01
		@Then("^sorting should be saved for table visuals$")
		public void sorting_should_be_saved_for_table_visuals() throws Throwable {
			Thread.sleep(1000);

			WebElement viewEle = login.driver.findElement(By.xpath("//thead/tr[1]/th[9]"));
			Thread.sleep(1000);
			js.executeScript("arguments[0].scrollIntoView(true);", viewEle);
			System.out.println("======================>15");

		}
		@Then("^color of the icon should take the color of the labels in the header$")
		public void color_of_the_icon_should_take_the_color_of_the_labels_in_the_header() throws Throwable {
			Thread.sleep(1000);

			String lableColor = login.driver.findElement(By.xpath("(//*[@class='zoom-button--text'])[2]"))
					.getCssValue("background-color");
			System.out.println(lableColor);

		}
		@And("^make changes to copyright parameters$")
		public void make_changes_to_copyright_parameters() throws Throwable {
			Thread.sleep(1000);

			if (login.driver.findElements(By.xpath("//div[@class='add-style-template add-style-template__active']"))
					.size() == 0) {

				// click on copyright
				login.driver.findElement(By.xpath("//div[@class='alignment-context-title--type']")).click();

				// click on Top
				login.driver.findElement(By.xpath("//div[@class='alignment-control--icon icon--align-y-top']")).click();

				// click on left

				login.driver.findElement(By.xpath("//div[@class='alignment-control--icon icon--align-x-left']")).click();
			}

			else {
				Assert.fail();
			}

		}
		@Then("^Save template icon should be enabled$")
		public void save_template_icon_should_be_enabled() throws Throwable {
			Thread.sleep(2000);

			if (login.driver.findElements(By.xpath("//div[@class='add-style-template add-style-template__active']"))
					.size() == 1) {

				System.out.println("Save template icon should be enabled");
			} else {
				Assert.fail();
			}

			login.driver.findElement(By.xpath("//button[@class='button button__primary']")).click();

		}
		@And("^Search for series \"([^\"]*)\" in layout$")
		public void Search_for_series_in_layout(String str) throws InterruptedException
		{
			login.driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(str,Keys.ENTER);
			Thread.sleep(3000);
			
		}
		
		@And("^Select any series1$")
		public void Select_any_series1() throws InterruptedException
		{
			Thread.sleep(2000);
			
			Thread.sleep(4000);
			login.driver.findElement(By.xpath("//div[@title='View results as List']")).click();
			for(int i=1;i<=5;i++)
			{
				Thread.sleep(5000);
				login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])["+i+"]")).click();
			}
			
		}
		@And("^Add a series \"([^\"]*)\" into right-pane$")
		public void add_a_series_into_right_pane(String str) throws InterruptedException
		{
			Thread.sleep(4000);
			login.driver.findElement(By.xpath("//div[@title='View results as List']")).click();
			
			if(login.driver.findElements(By.xpath("//span[@class='input-control--indicator']")).size()>=1)
			{
				login.driver.findElement(By.xpath("(//span[@class='input-control--indicator'])[11]")).click();
				
			      login.driver.findElement(By.xpath("//div[@data-action='delete']")).click();
			}
			Search_for_series_in_layout(str);
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[1]")).click();
			//action.sendKeys((Keys.chord("a"))).build().perform();
		}
		@And("^Create a chart for series \"([^\"]*)\"$")
		public void create_chart_for_series(String str) throws InterruptedException
		{
			add_a_series_into_right_pane(str);
			a.sendKeys((Keys.chord("c"))).build().perform();
		}
		@And("^Click on the timeframe to choose custom dates from \"([^\"]*)\" to \"([^\"]*)\"$")
		public void click_on_the_timeframe_to_choose_custom_dates_from(String str1,String str2) throws InterruptedException
		{
			Thread.sleep(3000);
			login.driver.findElement(By.xpath("//span[contains(text(),'No end date')]")).click();
			login.driver.findElement(By.xpath("//span[contains(text(),'Custom')]//parent::label/span[@class='input-control--indicator']")).click();
			login.driver.findElement(By.xpath("//input[@placeholder='From']")).clear();
			login.driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(str1,Keys.ENTER);
			login.driver.findElement(By.xpath("//input[@placeholder='To']")).clear();
			login.driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(str2);
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//button[contains(text(),'Save period')]")).click();
			
			
		}	
		@Then("^Check if zoom option is available$")
		public void check_if_zoom_option_is_available()
		{
			try {
			login.driver.findElement(By.xpath("//*[contains(text(),'Zoom')]")).click();
			}
			catch(NoSuchElementException Exception)
			{
				System.out.println("zoom is not present");
			}
		}
		@And("^Create a chart visual$")
		public void create_a_chart_visual() throws InterruptedException
		{
			Thread.sleep(4000);
			login.driver.findElement(By.xpath("//div[@title='View results as List']")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[1]")).click();
			a.contextClick().build().perform();
			a.moveToElement(login.driver.findElement(By.xpath("//span[contains(text(),'View as Chart')]"))).click().perform();
		}
		@And("^Open edit visual$")
		public void open_edit_visual() throws InterruptedException
		{
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//button[contains(text(),'Edit Chart')]")).click();
		}
		@And("^Apply a color palette and save \"([^\"]*)\"$")
		public void apply_a_color_palette_and_save(String str) throws InterruptedException
		{
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("(//div[@class='types-panel-expander types-panel-expander__left'])")).click();
			//c.selectColor(str,str1);
			
		}
		@And("^Check for the applied palette on the visual$")
		public void check_for_the_applied_palette_on_the_visual()
		{
			String s=login.driver.findElement(By.xpath("(//div[@class='visual-item-container'])[2]")).getCssValue("background-color");
			System.out.println(s);
			login.driver.findElement(By.xpath("//button[@class='button button__text_purple']/following::button[contains(text(),'Save')]")).click();
			
			
		}
		@And("^Search for keyword \"([^\"]*)\"$")
		public void search_for_keyword(String str) throws InterruptedException
		{
			Search_for_series_in_layout(str);
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@title='View results as List']")).click();
			 a.moveToElement(login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"))).build().perform();
			 Thread.sleep(2000);
			String s1=login.driver.findElement(By.xpath("(//td[contains(text(),'Name')]/following::td/div)[1]")).getText().toString();
			if(s1.contains(str))
			{
				System.out.println(s1);
			}
			String str1=login.driver.findElement(By.xpath("(//td[contains(text(),'Series id')]/following::td/div)[1]")).getText().toString();
			if(str.contains(str1)
					)
			{
				System.out.println("passed");
			}
			
		}
		@And("^Search for series \"([^\"]*)\"$")
		public void search_for_series(String str) throws InterruptedException
		{
			
			s6.Select_series1();
			 a.moveToElement(login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"))).build().perform();
			Thread.sleep(1000);
			String str1=login.driver.findElement(By.xpath("(//td[contains(text(),'Series id')]/following::td/div)[1]")).getText().toString();
			if(str.contains(str1)
					)
			{
				System.out.println("passed");
			}
		}
}
