package CDMNext.StepDefinations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SprintCases_4_10 {
	Actions action=new Actions(login.driver);
	Sprintcases_4_9 s9=new Sprintcases_4_9();
	SprintCases_4_7 s7=new SprintCases_4_7();
	WebDriverWait wait=new WebDriverWait(login.driver,100);
	String firstObsdate;
	String seriesids;
	String lastobsdate;
	String LastUpdateTime;
	String s;
	String s1;
	
	String indicatorname;
	@And("^set as default for future chart$")
	public void set_as_default_for_future_chart()
	{
		login.driver.findElement(By.xpath("(//img[@class='style-templates-item--icon'])[1]")).click();
		login.driver.findElement(By.xpath("(//div[@class='style-templates-item--tongue'])[1]")).click();
		if(login.driver.findElement(By.xpath("//span[contains(text(),'Set as default for future Chart visual')]//preceding-sibling::span")).isSelected())
		{
			System.out.println("selected");
		}
		else
			login.driver.findElement(By.xpath("//span[contains(text(),'Set as default for future Chart visual')]//preceding-sibling::span")).click();
	}
	@And("Save the settings$")
	public void save_the_settings()
	{
		login.driver.findElement(By.xpath("//button[@class='button button__text_purple']/following::button[contains(text(),'Save')]")).click();
	}
	
	
	@Given("^Click on series tab$")
	public void click_on_series_tab() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();

	}

	// TC_18834_01
	@Then("^User should land to series tab instead of database$")
	public void user_should_land_to_series_tab_instead_of_database() throws Throwable {

		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath("(//div[@class='series-item--main-info'])[1]")).size() == 1) {
			System.out.println("User should land to series tab instead of database");
		}

		else {
			Assert.fail();
		}

	}
	@And("^create group in same name in series$")
	public void create_group_in_same_name_in_series() throws Throwable {

		Thread.sleep(2000);

		WebElement sname = login.driver.findElement(By.xpath("//span[@class='series-name-field--series-name']"));
		action.moveToElement(sname).pause(500).build().perform();
		action.contextClick(sname).build().perform();

		// click on Group name
		login.driver.findElement(By.xpath("//span[@class='name-li'][contains(text(),'Group')]")).click();
		login.driver.findElement(By.xpath("//div[@class='insight-series-rename--button insight-series-rename--button__cancel']")).click();

		Thread.sleep(2000);
		

	}
	@And("^click on rename$")
	public void click_on_rename() throws Throwable {

		Thread.sleep(4000);
		login.driver.findElement(By.xpath("//div[@title='Rename']")).click();

	}
	@And("^Change name for Group and click on 'Ok' button$")
	public void change_name_for_Group_and_click_on_Ok_button() throws Throwable {
		Thread.sleep(2000);

		// click on group name
		login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.click();
		// clear the data in text box
		login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.clear();

		login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.sendKeys("Test");

		// click on Ok button
		login.driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();

	}
	@And("^Click on arrow icon for 'Original Name'$")
	public void click_on_arrow_icon_for_Original_Name() throws Throwable {
		Thread.sleep(2000);

		// click on original name Arrow

		login.driver.findElement(By.xpath("//*[@class='find-and-replace--body-header-action-icon']")).click();
		Thread.sleep(2000);
		String grouptextbox = login.driver
				.findElement(By.xpath(
						"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
				.getText();

		System.out.println("Group Textbox data" + grouptextbox);

		if (grouptextbox.equals("Test")) {
			System.out.println("Group text box title without Empty ");
		}

	}
	@Then("^verify the apply button disable under rename popup$")
	public void verify_the_apply_button_disable_under_rename_popup() throws Throwable {

		Thread.sleep(2000);

		Thread.sleep(2000);
		WebElement e = login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]"));

		boolean actualValue = e.isEnabled();

		if (actualValue)
			System.out.println("Button is enabled");
		else
			System.out.println("Button is disabled");

		Thread.sleep(2000);

	}
	@Given("^Click on indicator tab$")
	public void click_on_indicator_tab() throws Throwable {

		Thread.sleep(1000);

		login.driver.findElement(By.xpath("//*[contains(text(),'Indicator')]")).click();
		Thread.sleep(2000);

	}

	@Then("^Top indicators should be displayed in a panel$")
	public void top_indicators_should_be_displayed_in_a_panel() throws Throwable {

		Thread.sleep(2000);

		if (login.driver.findElements(By.xpath("//span[contains(text(),'Popular')]")).size() == 1) {

			System.out.println("Top indicators should be displayed in a panel");
		} else {
			Assert.fail();
		}

	}
	@Then("^'top indicators' selected by default and First category should always selected$")
	public void top_indicators_selected_by_default_and_First_category_should_always_selected() throws Throwable {

		Thread.sleep(1000);

		if (login.driver.findElements(By.xpath("//span[contains(text(),'Popular')]")).size() == 1) {

			System.out.println("Top indicators' selected by default and First category should always selected");
		} else {
			Assert.fail();
		}
	}
	@And("^Select any category in left panel$")
	public void select_any_category_in_left_panel() throws Throwable {

		Thread.sleep(2000);

		login.driver.findElement(By.xpath("(//*[@class='text-dots'])[7]")).click();

		indicatorname = login.driver.findElement(By.xpath("(//*[@class='text-dots'])[7]")).getText();
		System.out.println("Indicatorname:" + indicatorname);

	}

	// TC_19208_03
	@Then("^any category is selected on the left side, the header with associated indicators should be presented on the right side with the \"([^\"]*)\" control$")
	public void any_category_is_selected_on_the_left_side_the_header_with_associated_indicators_should_be_presented_on_the_right_side_with_the_control(
			String arg1) throws Throwable {
		Thread.sleep(2000);

		String rightsideind = login.driver.findElement(By.xpath("//*[@class='filter--title-label']")).getText();

		System.out.println("Right side Indicator name:" + rightsideind);

		// if(indicatorname==rightsideind)
		if (indicatorname.equals(rightsideind)) {
			System.out.println("selected Left side indicator == Right side indicator");
		} else {
			Assert.fail();
		}

		login.driver.findElement(By.xpath("//span[contains(text(),'Select All')]")).click();

		if (login.driver.findElements(By.xpath("//span[contains(text(),'Unselect All')]")).size() == 1) {
			System.out.println("All filters are selected");
		}

		else {
			System.out.println();
		}

	}
	@And("^click on insert Attachment$")
	public void click_on_insert_Attachment() throws Throwable {

		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='icon--attachments']")).click();

	}

	// TC_19383_01
	@Then("^order is 'Uploads and links' and default tab is Uploads$")
	public void order_is_Uploads_and_links_and_default_tab_is_Uploads() throws Throwable {
		Thread.sleep(2000);

		// First name
		String Firstname = login.driver.findElement(By.xpath("//div[@class='tabs__tab-item active']")).getText();
		Firstname.equals("uploads");

		// 2nd name

		String secondname = login.driver.findElement(By.xpath("//div[contains(text(),'Links')]")).getText();
		secondname.equals("Links");

		// default tab is Uploads

		if (login.driver.findElements(By.xpath("//div[contains(text(),'Drop files here to upload, or click')]"))
				.size() == 1) {

			System.out.println("default tab is Uploads");

		}

		else {
			Assert.fail();
		}

	}
	@Given("^Add series into my series as \"([^\"]*)\"$")
	public void add_series_into_my_series_as(String seriesid) throws Throwable {
		Thread.sleep(2000);
		CommonFunctionality.DeleteSeries();

		// click on search bar
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).click();

		// Enter data into search
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(seriesid);

		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		seriesids = login.driver.findElement(By.xpath("//input[@class='search-input-text']")).getText();
		System.out.println(seriesids);
		login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();

		Thread.sleep(1000);

		List<WebElement>l1=login.driver.findElements(By.xpath("//*[@class='series-list-item--checkbox svg-checkbox']"));
		for(int i=1;i<=l1.size();i++)
		{
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])["+i+"]")).click();
			                                  
		}

		// click on +icon
		login.driver.findElement(By.xpath("(//div[@class='add-to-data-selection--icon'])[1]")).click();

	}

	// TC_19277_01
	@Given("^Search series with series ID in my series filter$")
	public void search_series_with_series_ID_in_my_series_filter() throws Throwable {

		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//input[@class='form--control']")).click();

		login.driver.findElement(By.xpath("//input[@class='form--control']")).sendKeys("353687487;374827357");

		login.driver.findElement(By.xpath("//input[@class='form--control']")).sendKeys(Keys.ENTER);
		// login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();

	}

	// TC_19277_01
	@Then("^related series should be searched$")
	public void related_series_should_be_searched() throws Throwable {
		Thread.sleep(1000);
		// after search series display

		if (login.driver.findElements(By.xpath("//span[@class='series-name-field--series-name']")).size() == 2) {

			System.out.println("related series should be searched");

		} else {
			Assert.fail();
		}

	}
	@And("^attributes check on tables$")
	public void attributes_check_on_tables() throws Throwable {
		Thread.sleep(2000);
		
		WebElement element = login.driver.findElement(By.xpath("//span[@class='series-edit--title']"));
		action.moveToElement(element).perform();
		Thread.sleep(1000);
		//action.moveToElement(login.driver.findElement(By.xpath("//span[@class='series-edit--title']"))).build().perform();

		// First Obs. Date
		firstObsdate = login.driver.findElement(By.xpath("//td[contains(text(),'First obs. date')]")).getText();
		System.out.println("firstObsdate:" + firstObsdate);

		// Lastobsdate
		lastobsdate = login.driver.findElement(By.xpath("//td[contains(text(),'Last obs. date')]")).getText();
		System.out.println("lastobsdate:" + lastobsdate);

		// Last Update Time
		LastUpdateTime = login.driver.findElement(By.xpath("//td[contains(text(),'Last update time')]")).getText();
		System.out.println("LastUpdateTime:" + LastUpdateTime);

	}

	// TC_18708_01
	@Then("^verify First Obs\\. Date, Last Obs\\. Date and Last Update time$")
	public void verify_First_Obs_Date_Last_Obs_Date_and_Last_Update_time() throws Throwable {
		Thread.sleep(2000);

		if (firstObsdate.equals("First obs. date") && lastobsdate.equals("Last obs. date")
				&& LastUpdateTime.equals("Last update time"))

		{
			System.out.println("Attributes are verified");
		} else {
			Assert.fail();
		}

	}

	@And("^Open View tab$")
	public void Open_View_tab()
	{
		login.driver.findElement(By.xpath("//span[contains(text(),'View 1')]")).click();
		
	}
	@And("^Add bar chart in the view$")
	public void Add_bar_chart_in_the_view() throws InterruptedException
	{
		login.driver.findElement(By.xpath("//div[contains(text(),'Add chart')]")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[contains(@class,\"icon--chart-bar_large\")]")).click();
		
		
	}
	@Then("^Add series in it from My series panel or from the search section$")
	public void Add_series_in_it_from_My_series_panel_or_from_the_search_section() throws InterruptedException
	{
		int count = 0;
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//a[contains(text(),'My Series')]")).click();
		//login.driver.findElement(By.xpath("//div[@title='View results as List']")).click();
		s7.Select_any_series1();
		action.sendKeys((Keys.chord("a"))).build().perform();
		Open_View_tab();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//span[@class='empty-visual-overlay--link'][contains(text(),'Add from My Series')]")).click();
		Thread.sleep(5000);
		//login.driver.findElement(By.xpath("//a[contains(text(),'My Series')]")).click();
		login.driver.findElement(By.xpath("//span[@class='table-container--checkbox svg-checkbox input-control__grey']")).click();
		login.driver.findElement(By.xpath("//span[text()='No end date']")).click();
		List<WebElement> l=login.driver.findElements(By.xpath("//span[@class='input-control--description']"));
		for(WebElement l1:l)
		{
		 System.out.println(l1.getText().toString());
		count= count++;
		}
		System.out.println(count);
		
	}
	

	@And("^Select series with unit as person or unit \"([^\"]*)\"$")
	public void  select_series_with_unit_as_person_or_unit(String str) throws InterruptedException
	{
		
		s7.Search_for_series_in_layout(str);
		Thread.sleep(4000);
		login.driver.findElement(By.xpath("//div[@title='View results as List']")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("(//span[contains(text(),'Sort By')])")).click();
		login.driver.findElement(By.xpath("(//div[@class='custom-select-item--link text-dots'])[12]")).click();
		//login.driver.findElement(By.xpath("//div[@title='View results as List']")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[1]")).click();
		//a.sendKeys((Keys.chord("a"))).build().perform();
		}

	@Then("^Apply Unit manipulation function$")
	public void apply_Unit_manipulation_function() throws InterruptedException
	{
		s9.Click_on_function_toolbar();
		login.driver.findElement(By.xpath("//span[@class='popular-functions-context--all-icon']")).click();
		 //login.driver.findElement(By.xpath("//div[contains(text(),'By function')]")).click();
		 login.driver.findElement(By.xpath("//input[@placeholder='Find functions']")).sendKeys("Unit_multiplier",Keys.ENTER);
		 Thread.sleep(3000);
		 action.moveToElement(login.driver.findElement(By.xpath("//span[text()='Unit Manipulation']"))).doubleClick().perform();
		 Thread.sleep(4000);
		 login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		 login.driver.switchTo().activeElement();
		 Thread.sleep(2000);
		 login.driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
	}
	@And("^Open Region filter$")
	public void open_region_filter()
	{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'All Regions')]"))).click();
		//login.driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys("Palestine",Keys.ENTER);
	}
	@Then("^Enter Palestine and search$")
	public void enter_Palestine_and_search() throws InterruptedException
	{
		
		//login.driver.findElement(By.xpath("//input[@placeholder='Search...']")).clear();
		Thread.sleep(6000);
		login.driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys("Palestine",Keys.ENTER);
		String str=login.driver.findElement(By.xpath("(//span[contains(text(),'State of Palestine (West Bank and Gaza)')])[2]")).getText().toString();
		if(str.contains("State of Palestine"))
		{
			System.out.println("equal");
		}
	}
	@And("^Try to access a footnotes for table level$")
	public void try_to_access_a_footnotes_for_table_level()
	{
		
		login.driver.findElement(By.xpath("//span[text()='Databases']")).click();
		login.driver.findElement(By.xpath("(//div[@data-node-model-id='WORLD']/div[@class='toggle'])[1]")).click();
		login.driver.findElement(By.xpath("(//div[@data-node-model-id='WORLD&&ALL']/div[@class='toggle'])[1]")).click();
		login.driver.findElement(By.xpath("(//div[@data-node-model-id='TP74383']/div[@class='toggle'])[1]")).click();
		login.driver.findElement(By.xpath("(//div[@data-node-model-id='SC74575']/div[@class='toggle'])[1]")).click();
		action.moveToElement(login.driver.findElement(By.xpath("//div[@data-node-model-id='TB3168187']//span[@class='name-text']"))).build().perform();
		//a.moveToElement(login.driver.findElement(By.xpath("(//div[@data-node-model-id='TB3168187']/div[@class='toggle'])[1]"))).build().perform();
		 
		action.moveToElement(login.driver.findElement(By.xpath("//div[@data-node-model-id='TB3168187']//span[@title='Open footnote']"))).click().perform();
	}
	@And("^The table name is displayed on the footnotes header$")
	public void the_table_name_is_displayed_on_the_footnotes_header()
	{
		s1=login.driver.findElement(By.xpath("//span[@js-navigation-title='true']")).getText().toString();
		s1=s1.replace("(","");
		s1=s1.replace(")","");
		System.out.println(s1+","+s);
		
	}
	@Then("^Click \"([^\"]*)\"$")
	public void click(String str) throws InterruptedException
	{
		Thread.sleep(2000);
		
		login.driver.findElement(By.xpath("//div[@class='movable-modal--action-icon__expand']")).click();
		Thread.sleep(2000);
		//WebElement ask=login.driver.findElement(By.xpath("//div[contains(text(),'"+str+"')]"));
		WebElement ask=login.driver.findElement(By.xpath("//div[normalize-space(text())='Ask Question']"));
		
		action.moveToElement(ask).click().build().perform();
		login.driver.switchTo().activeElement();
		s=login.driver.findElement(By.xpath("//h4[@class='modal-title sphere-modal__title text-dots']")).getText().toString();
		System.out.println(s);
		if(s.contains(s1))
		{
			System.out.println("both are equal");
		}
	}

	@And("^Apply Accumulate function$")
	public void apply_Accumulate_function() throws InterruptedException
	{
		s9.Click_on_function_toolbar();
		login.driver.findElement(By.xpath("//span[@class='popular-functions-context--all-icon']")).click();
		 //login.driver.findElement(By.xpath("//div[contains(text(),'By function')]")).click();
		
		 login.driver.findElement(By.xpath("//input[@placeholder='Find functions']")).sendKeys("Accumulate",Keys.ENTER);
		 Thread.sleep(2000);
		 action.moveToElement(login.driver.findElement(By.xpath("//span[text()='Accumulate']"))).doubleClick().perform();
		 Thread.sleep(4000);
		 login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		 
	}
@Then("^Open Series Suggested Manager$")
public void open_Series_Suggested_Manager() throws Throwable
{
	Thread.sleep(2000);
 s=login.driver.findElement(By.xpath("//span[@class='series-functions-title']")).getText().toString();
 login.driver.findElement(By.xpath("//span[@class='series-name-field-title']")).click();
 s1=login.driver.findElement(By.xpath("//span[@class='series-functions--modal-title-label']")).getText().toString();
 if(s.contains(s1))
 {
	 System.out.println("same");
 }
 else
 {
	 System.out.println("not same");
 }
 
 
}
@And("^Click on edit series$")

	public void click_on_edit_series()
	{
		login.driver.findElement(By.xpath("//button[contains(text(),'Edit Series')]")).click();
		if(login.driver.findElement(By.xpath("//span[contains(text(),'Add from My Series')]")).isSelected())
		{
			System.out.println("present");
		}
	}
@Then("^click on Search series$")
public void click_on_Search_series()
{
	login.driver.findElement(By.xpath("//button[contains(text(),'Search Series')]")).click();
	if(login.driver.findElement(By.xpath("(//span[@data-id='DATA'])[1]")).isSelected())
	{
		System.out.println("present");
	}
	
}

}
