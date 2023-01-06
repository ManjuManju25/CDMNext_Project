package CDMNext.StepDefinations;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.*;

public class MySearch {

	@Given("^verify the My Searches drop down box should appear in Search panel$")
	public void verify_the_My_Searches_drop_down_box_should_appear_in_Search_panel() throws Throwable {

		Thread.sleep(2000);
		// click on Expand
		login.driver.findElement(By.xpath("(//*[@class='panel-expander--icon panel-expander--icon__right'])[1]"))
				.click();
		System.out.println("======================TC_01_Execute==========================");

	}

	@Given("^verify the Name your Search pop up should appear$")
	public void verify_the_Name_your_Search_pop_up_should_appear() throws Throwable {

		Thread.sleep(2000);
		// Enter a data in search bar
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys("GDP");
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(Keys.ENTER);

		// click on Expand
		login.driver.findElement(By.xpath("(//div[@class='panel-expander--icon panel-expander--icon__right'])[1]"))
				.click();
		Thread.sleep(3000);
		// click on source button
		login.driver.findElement(By.xpath("//span[contains(text(),'Source')]")).click();
		Thread.sleep(2000);
		// checked box checked
		login.driver.findElement(By.xpath("//span[contains(text(),'World Bank')]")).click();
		Thread.sleep(2000);
//click on Apply filter button
		login.driver.findElement(By.xpath("//div[contains(text(),'Apply filter')]")).click();
		Thread.sleep(2000);
		// click on status button
		login.driver.findElement(By.xpath("//span[contains(text(),'Status')]")).click();
		Thread.sleep(2000);
		// checked
		login.driver.findElement(By.xpath("//span[contains(text(),'Active')]")).click();
		login.driver.findElement(By.xpath("//div[contains(text(),'Apply filter')]")).click();
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//span[contains(text(),' Save')]")).click();

		System.out.println("===================TC_02_Execute=============================");
	}

	@Given("^Saved search results should be reloaded$")
	public void saved_search_results_should_be_reloaded() throws Throwable {

		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).clear();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys("Repo Rate");
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(Keys.ENTER);
		// Robot r = new Robot();
		// r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);

		// Thread.sleep(3000);
		// login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Frequency')]")).click();
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//span[contains(text(),'Monthly')]")).click();
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//div[contains(text(),'Apply filter')]")).click();
		Thread.sleep(2000);
		// expand

		login.driver.findElement(By.xpath("(//*[contains(text(),'Save')])[1]")).click();

		Thread.sleep(3000);

		// Thread.sleep(3000);
		login.driver.findElement(By.xpath("//input[@class='insight-search-input--search-field']"))
				.sendKeys("Repo Rate");
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Save new search')]")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Reset')]")).click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//*[@title='My searches']")).click();
		Thread.sleep(2000);

		System.out.println("===================TC_3_Executed=============================");
	}

	@Given("^verify the keywords and add some filters$")
	public void verify_the_keywords_and_add_some_filters() throws Throwable {

		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).clear();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys("FDI");
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(Keys.ENTER);

		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//span[contains(text(),'Source')]")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Eurostat')]")).click();
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//div[contains(text(),'Apply filter')]")).click();
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//span[contains(text(),'Frequency')]")).click();
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//span[contains(text(),'Yearly')]")).click();
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//div[contains(text(),'Apply filter')]")).click();

		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//span[contains(text(),' Save')]")).click();

		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//input[@class='insight-search-input--search-field']")).sendKeys("FDI");
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Save new search')]")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Reset')]")).click();
		Thread.sleep(3000);

		login.driver.findElement(By.xpath("//*[@class='select-search-title--folder']")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("(//span[@class='searches-item--title'])[1]")).click();

		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Reset')]")).click();
		System.out.println("===================TC_4_Executed=============================");

	}

	@Given("^verify the search keyword and filters$")
	public void verify_the_search_keyword_and_filters() throws Throwable {

		Thread.sleep(5000);

		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).clear();
		Thread.sleep(4000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys("oil and gas");
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(Keys.ENTER);
		// Robot r = new Robot();
		// r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'More')]")).click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//span[@class='filter-item--label']//span[contains(text(),'USD')]")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) login.driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);

		login.driver.findElement(By.xpath("//div[contains(text(),'Apply filter')]")).click();
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//span[contains(text(),'Status')]")).click();
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//span[contains(text(),'Discontinued')]")).click();
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//div[contains(text(),'Apply filter')]")).click();

		Thread.sleep(3000);

		login.driver.findElement(By.xpath("//span[contains(text(),' Save')]")).click();

		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//input[@class='insight-search-input--search-field']"))
				.sendKeys("oil and gas");
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Save new search')]")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Reset')]")).click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//*[@class='select-search-title--folder']")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("(//span[@class='searches-item--title'])[1]")).click();

		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Series')]")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Reset')]")).click();

		System.out.println("===================TC_5_Executed=============================");
	}
//TC_06
	@Given("^select keyword and some filters$")
	public void select_keyword_and_some_filters() throws Throwable {

		Thread.sleep(5000);

		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).clear();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys("百万美元");
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(Keys.ENTER);
		// Robot r = new Robot();
		// r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Source')]")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'U.S. Census Bureau')]")).click();
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//div[contains(text(),'Apply filter')]")).click();
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//span[contains(text(),'Frequency')]")).click();
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//span[contains(text(),'Monthly')]")).click();
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//div[contains(text(),'Apply filter')]")).click();

		Thread.sleep(2000);
		login.driver.findElement(By.xpath("(//div[@class='panel-expander--icon panel-expander--icon__right'])[1]")).click();
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//span[contains(text(),' Save')]")).click();

		
		
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//input[@class='insight-search-input--search-field']")).sendKeys("china");
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Save new search')]")).click();
		
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='growl-message-close']")).click();
		Thread.sleep(200);
		login.driver.findElement(By.xpath("(//div[@class='panel-expander--icon panel-expander--icon__left'])[4]")).click();
		Thread.sleep(4000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Reset')]")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//*[@class='select-search-title--folder']")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("(//span[@class='searches-item--title'])[1]")).click();

		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Reset')]")).click();
		
		System.out.println("===================TC_6_Executed=============================");

	}
//TC_07
	@Given("^search should be deleted from My searches drop down$")
	public void search_should_be_deleted_from_My_searches_drop_down() throws Throwable {
		Thread.sleep(2000);
		// login.driver.findElement(By.xpath("//span[contains(text(),'Reset')]")).click();

		// Thread.sleep(3000);
		login.driver.findElement(By.xpath("//*[@class='select-search-title--folder']")).click();
		Thread.sleep(1000);

		Actions action = new Actions(login.driver);

		WebElement menuOption = login.driver.findElement(By.xpath("//span[@class='searches-item--title']"));
		action.moveToElement(menuOption).perform();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[@class='searches-item--remove']")).click();
		System.out.println("===================TC_7_Executed=============================");
		System.out.println("Execution completed");

	}

}
