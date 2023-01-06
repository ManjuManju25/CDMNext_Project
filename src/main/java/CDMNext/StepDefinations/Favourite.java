package CDMNext.StepDefinations;

import static org.testng.Assert.fail;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Favourite extends CommonFunctionality {
	
	@Given("^user add some series into my series\\.$")
	public void user_add_some_series_into_my_series() throws Throwable {
		List<WebElement> checkboxes = login.driver
				.findElements(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']"));
		
		for(int i=0;i<2;i++) {
			CommonFunctionality.wait(3000);
			checkboxes.get(i).click();
			CommonFunctionality.wait(2000);
		}
		login.driver.findElement(By.xpath("(//div[@class='add-to-data-selection--icon'])[1]")).click();
	    
	}

	@Given("^clicks on fx icon\\.$")
	public void clicks_on_fx_icon() throws Throwable {
		WebElement Series_Name=login.driver.findElement(By.xpath("(//span[@class='series-name-field--series-name']/span)[1]"));
		new Actions(login.driver).moveToElement(Series_Name).pause(3000).build().perform();
		login.driver.findElement(By.xpath("(//div[@title='Apply Function'])[1]")).click();
		
		WebElement Recent=login.driver.findElement(By.xpath("//div[normalize-space(text())='Recent']"));
		WebElement Favourite=login.driver.findElement(By.xpath("//div[normalize-space(text())='Favorite']"));
		
		if(Recent.isDisplayed()) {
			System.out.println("Recent function is displayed");
		}
		else {
			fail("Recent function is not displayed");
		}
		
		if(Favourite.isDisplayed()) {
			System.out.println("Favourite function is displayed");
		}
		else {
			fail("Favourite function is not displayed");
		}
		
		
		
	}
	
	@Given("^Apply function on a series from function bar$")
	public void apply_function_on_a_series_from_function_bar() throws Throwable {
		WebElement Series_Name=login.driver.findElement(By.xpath("(//span[@class='series-name-field--series-name']/span)[1]"));
		new Actions(login.driver).moveToElement(Series_Name).pause(3000).build().perform();
		login.driver.findElement(By.xpath("(//div[@title='Apply Function'])[1]")).click();
		CommonFunctionality.wait(2000);
	WebElement Function_bar=login.driver.findElement(By.xpath("//div[normalize-space()='Average']"));
	Function_bar.click();
	CommonFunctionality.wait(2000);
	WebElement Starred_icon=login.driver.findElement(By.xpath("//div[@class='toggle-favorite-control--icon']"));
	if(Starred_icon.isDisplayed()) {
		System.out.println("Starred icon is displayed");
	}
	else {
		fail("Starred icon is not displayed");
	}
	
	login.driver.findElement(By.xpath("//span[@class='series-function-item--remove-icon']")).click();
	
	WebElement Series_Name1=login.driver.findElement(By.xpath("//div[@class='series-name-field']"));
	new Actions(login.driver).moveToElement(Series_Name1).pause(3000).build().perform();	
	login.driver.findElement(By.xpath("(//span[@title='Remove series'])[1]")).click();
	   
	}

	@Given("^Apply function on a series from function wizard\\.$")
	public void apply_function_on_a_series_from_function_wizard() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//div[@class='function-editor-window--icon']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//div[@data-id='ACCSER']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//button[normalize-space()='Insert function']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//button[normalize-space()='Apply']")).click();
		CommonFunctionality.wait(1000);
		WebElement Starred_icon=login.driver.findElement(By.xpath("//div[@class='toggle-favorite-control--icon']"));
		if(Starred_icon.isDisplayed()) {
			System.out.println("Starred icon is displayed");
		}
		else {
			fail("Starred icon is not displayed");
		}
	    
	}

	@Given("^Apply function on a series=>click on starred icon$")
	public void apply_function_on_a_series_click_on_starred_icon() throws Throwable {
		WebElement Series_Name=login.driver.findElement(By.xpath("(//span[@class='series-name-field--series-name']/span)[1]"));
		new Actions(login.driver).moveToElement(Series_Name).pause(3000).build().perform();
		login.driver.findElement(By.xpath("(//div[@title='Apply Function'])[1]")).click();
		CommonFunctionality.wait(2000);
	WebElement Function_bar=login.driver.findElement(By.xpath("//div[normalize-space()='Average']"));
	Function_bar.click();
	CommonFunctionality.wait(2000);
	WebElement Starred_icon=login.driver.findElement(By.xpath("//div[@class='toggle-favorite-control--icon']"));
	Starred_icon.click();
	}

	@Then("^starred icon should be filled\\.$")
	public void starred_icon_should_be_filled() throws Throwable {
		WebElement Starred_iconfilled=login.driver.findElement(By.xpath("//div[@class='toggle-favorite-control toggle-favorite-control__favorite']"));
		if(Starred_iconfilled.isDisplayed()) {
			System.out.println("Starred icon is filled with color");
		}
		else {
			fail("Starred icon is not filled with color");
		}
		
		
	    
	}
	@Then("^Applied function should be shown in favorite function feild\\.$")
	public void applied_function_should_be_shown_in_favorite_function_feild() throws Throwable {
		
	   
	}
	@Given("^user Creates any visual\\.$")
	public void user_Creates_any_visual() throws Throwable {
		List<WebElement> checkboxes = login.driver
				.findElements(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']"));
		
		for(int i=0;i<1;i++) {
			CommonFunctionality.wait(3000);
			checkboxes.get(i).click();
			CommonFunctionality.wait(2000);
		}
		WebElement FirstSeries=login.driver.findElement(By.xpath("(//div[@class='series-list-item-data'])[1]"));
		new Actions(login.driver).moveToElement(FirstSeries).pause(1000).build().perform();
		CommonFunctionality.wait(2000);
		WebElement ele=login.driver.findElement(By.xpath("//span[@title='More actions']"));
		jse.executeScript("arguments[0].click();", ele);
		WebElement Add_chart=login.driver.findElement(By.xpath("//span[normalize-space(text())='Add chart']"));
		new Actions(login.driver).moveToElement(Add_chart).pause(1000).build().perform();
		login.driver.findElement(By.xpath("//div[contains(@class,'icon--chart-line_large')]")).click();
		
		try {
			login.driver.findElement(By.xpath("//button[normalize-space(text())='Apply']")).click();
		}
	    catch(Exception e) {
	    	System.out.println("Pop up not appeared");
	    }

	    
	}

	

	@Given("^click on Edit series$")
	public void click_on_Edit_series() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement Edit_Series=login.driver.findElement(By.xpath("//button[text()='Edit Series']"));
		Edit_Series.click();
		
	    
	}

	@Then("^mark series as favourite\\.$")
	public void mark_series_as_favourite() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("(//div[@class='function-editor-window--icon'])[1]")).click();
		CommonFunctionality.wait(2000);
		WebElement Mul=login.driver.findElement(By.xpath("//div[@data-id='MULTIPLY']"));
		jse.executeScript("arguments[0].scrollIntoView(true);", Mul);
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//div[@data-id='AGGREGATE']")).click();
		login.driver.findElement(By.xpath("//button[text()='Insert function']")).click();
		login.driver.findElement(By.xpath("//button[text()='Apply']")).click();
		WebElement Starred_icon=login.driver.findElement(By.xpath("//div[@class='toggle-favorite-control--icon']"));
		Starred_icon.click();
		CommonFunctionality.wait(2000);
		WebElement Series=login.driver.findElement(By.xpath("//div[@class='series-name--title']"));
		Series.click();
		login.driver.findElement(By.xpath("(//*[normalize-space(text())='More functions'])[2]")).click();
		
		WebElement Favorite=login.driver.findElement(By.xpath("//div[normalize-space(text())='Favorite']/following::span[text()='AGGREGATE']"));
		if(Favorite.isDisplayed()) {
			System.out.println("Series are marked as favorite");
		}
		else {
			fail("Series are not marked as favorite");
		}
	}
	@Given("^navigate to my series\\.$")
	public void navigate_to_my_series() throws Throwable {
		WebElement My_Series=login.driver.findElement(By.xpath("//a[normalize-space()='My Series']"));
		My_Series.click();
		
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
	  
	}

	@Then("^should be made as favorite\\.$")
	public void should_be_made_as_favorite() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//div[@class='function-editor-window--icon']")).click();
		CommonFunctionality.wait(2000);
		
		WebElement Mul=login.driver.findElement(By.xpath("//div[@data-id='MULTIPLY']"));
		jse.executeScript("arguments[0].scrollIntoView(true);", Mul);
		
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//div[@data-id='AGGREGATE']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//button[text()='Insert function']")).click();
		login.driver.findElement(By.xpath("//button[text()='Apply']")).click();
		
		WebElement Starred_iconfilled=login.driver.findElement(By.xpath("//div[@class='toggle-favorite-control toggle-favorite-control__favorite']"));
		if(Starred_iconfilled.isDisplayed()) {
			System.out.println("Starred icon is filled with color");
		}
		else {
			fail("Starred icon is not filled with color");
		}		
	   
	}
	@Given("^Apply series with more than one function\\.$")
	public void apply_series_with_more_than_one_function() throws Throwable {
		login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
		CommonFunctionality.wait(2000);
		WebElement Fx=login.driver.findElement(By.xpath("//div[@class='function-editor-window--icon']"));
		Fx.click();
		WebElement Mul=login.driver.findElement(By.xpath("//div[@data-id='MULTIPLY']"));
		jse.executeScript("arguments[0].scrollIntoView(true);", Mul);
		WebDriverWait wait = new WebDriverWait(login.driver, 80);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//div[@data-id='AGGREGATE']")))).click();
		CommonFunctionality.wait(2000);
		//login.driver.findElement(By.xpath("//button[text()='Insert function']")).click();
		WebElement AGGR=login.driver.findElement(By.xpath("//div[@data-id='AGGREGATE']"));
		jse.executeScript("arguments[0].scrollIntoView(true);", AGGR);
		CommonFunctionality.wait(3000);
		login.driver.findElement(By.xpath("//div[@data-id='DISAGGREGATE']")).click();
		CommonFunctionality.wait(3000);
		login.driver.findElement(By.xpath("//button[text()='Insert function']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//button[text()='Apply']")).click();
		
		
		
	   
	}

	@Given("^click on starred icon\\.$")
	public void click_on_starred_icon() throws Throwable {
		try {
			Thread.sleep(4000);
			//login.driver.findElement(By.xpath("//div[@class='toggle-favorite-control--icon']")).click();
			CommonFunctionality.wait(2000);
			WebElement Favorite=login.driver.findElement(By.xpath("//div[@class='toggle-favorite-control toggle-favorite-control__favorite']"));
			if(Favorite.isDisplayed()) {
				System.out.println("Fav is disp and clicked already");
			}
			else {
				CommonFunctionality.wait(3000);
				System.out.println("Fav is not disp ");
			}
		}
	
		catch(Exception e) {
			login.driver.findElement(By.xpath("//div[@class='toggle-favorite-control--icon']")).click();
		
		System.out.println("Already clicked");
		}
	}
	
	@Given("^Apply first series with function\\.$")
	public void apply_first_series_with_function() throws Throwable {
		WebElement First_Series=login.driver.findElement(By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[1]"));
		First_Series.click();
		WebElement Fx=login.driver.findElement(By.xpath("//div[@class='function-editor-window--icon']"));
		Fx.click();
		WebElement Mul=login.driver.findElement(By.xpath("//div[@data-id='MULTIPLY']"));
		jse.executeScript("arguments[0].scrollIntoView(true);", Mul);
		WebDriverWait wait = new WebDriverWait(login.driver, 80);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//div[@data-id='AGGREGATE']")))).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//button[text()='Insert function']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//button[text()='Apply']")).click();
	   
	}
	
	@Given("^refresh the page\\.$")
	public void refresh_the_page() throws Throwable {
		login.driver.navigate().refresh();
	    
	}

	@Then("^should be able to see starred icon in both recent and favorite tabs$")
	public void should_be_able_to_see_starred_icon_in_both_recent_and_favorite_tabs() throws Throwable {
		WebElement Series_Name=login.driver.findElement(By.xpath("(//span[@class='series-name-field--series-name']/span)[3]"));
		new Actions(login.driver).moveToElement(Series_Name).pause(3000).build().perform();
		login.driver.findElement(By.xpath("(//div[@title='Apply Function'])[3]")).click();
		
		WebElement Favorite=login.driver.findElement(By.xpath("//div[normalize-space(text())='Favorite']/following::div[@class='toggle-favorite-control toggle-favorite-control__favorite']"));
		if(Favorite.isDisplayed()) {
			System.out.println("Already Marked as Favorite is shown for 2nd series");
		}
		else {
			fail("Favorite is not clicked");
		}
		
	    
	}

	
	
	
	
	
	

	@Given("^select second series=>click on previously Marked favorite marked function\\.$")
	public void select_second_series_click_on_previously_Marked_favorite_marked_function() throws Throwable {
		login.driver.findElement(By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[2]")).click();
		CommonFunctionality.wait(2000);
		WebElement Second_Series=login.driver.findElement(By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[3]"));
		Second_Series.click();
		CommonFunctionality.wait(2000);
		WebElement Fx=login.driver.findElement(By.xpath("//div[@class='function-editor-window--icon']"));
		Fx.click();
		WebElement Mul=login.driver.findElement(By.xpath("//div[@data-id='MULTIPLY']"));
		jse.executeScript("arguments[0].scrollIntoView(true);", Mul);
		
		WebDriverWait wait = new WebDriverWait(login.driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//div[@data-id='AGGREGATE']")))).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//button[text()='Insert function']")).click();
		CommonFunctionality.wait(3000);
		login.driver.findElement(By.xpath("//button[text()='Apply']")).click();
		CommonFunctionality.wait(3000);
	   
	}

	@Then("^second series must be applied with same as first series function\\.$")
	public void second_series_must_be_applied_with_same_as_first_series_function() throws Throwable {
		WebElement Starred_iconfilled=login.driver.findElement(By.xpath("//div[@class='toggle-favorite-control toggle-favorite-control__favorite']"));
		if(Starred_iconfilled.isDisplayed()) {
			System.out.println("Starred icon is filled with color");
		}
		else {
			fail("Starred icon is not filled with color");
		}
	   
	}

	
	
	
	
	

	@Then("^should be mark as favorite\\.$")
	public void should_be_mark_as_favorite() throws Throwable {
		WebElement Favorite=login.driver.findElement(By.xpath("//div[@class='toggle-favorite-control toggle-favorite-control__favorite']"));
		if(Favorite.isDisplayed()) {
			System.out.println("Marked as Favorite");
		}
		else {
			fail("Favorite is not clicked");
		}
		
	   
	}
	@Then("^remove the function applied\\.$")
	public void remove_the_function_applied() throws Throwable {
		/*WebElement Favorite=login.driver.findElement(By.xpath("//div[@class='toggle-favorite-control toggle-favorite-control__favorite']"));
		if(Favorite.isDisplayed()) {
			Favorite.click();
			System.out.println("Starred icon is removed");
		}
		else {
			fail("Starred icon is not  removed");
		}*/
		WebElement Remove_Function=login.driver.findElement(By.xpath("//span[@title='Transforms the frequency of a series to a higher one']//span[@class='series-function-item--remove-icon']"));
		Remove_Function.click();
		CommonFunctionality.wait(3000);
		//login.driver.findElement(By.xpath("//div[@title='Ctrl+click to create a new series']")).click();
		if(login.driver.findElements(By.xpath("//div[@data-id='DISAGGREGATE']")).size()==0) {
			System.out.println("Disaggregate function is removed");
		}
		else {
			System.out.println("Disaggregate function is not removed");
		}
	}
	
	@Then("^favorite should be marked as unfavorite\\.$")
	public void favorite_should_be_marked_as_unfavorite() throws Throwable {
		WebElement Favorite=login.driver.findElement(By.xpath("//div[@class='toggle-favorite-control toggle-favorite-control__favorite']"));
		if(Favorite.isDisplayed()) {
			Favorite.click();
			System.out.println("Starred icon is removed");
		}
		else {
			fail("Starred icon is not  removed");
		}
	    
	}

	@Given("^user add (\\d+) series into my series\\.$")
	public void user_add_series_into_my_series(int arg1) throws Throwable {
		List<WebElement> checkboxes = login.driver
				.findElements(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']"));
		
		for(int i=0;i<5;i++) {
			CommonFunctionality.wait(3000);
			checkboxes.get(i).click();
			CommonFunctionality.wait(2000);
		}
		login.driver.findElement(By.xpath("(//div[@class='add-to-data-selection--icon'])[1]")).click();
	   
	}

	@Given("^Apply each with different functions$")
	public void apply_each_with_different_functions() throws Throwable {
		WebElement First_Series=login.driver.findElement(By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[1]"));
		First_Series.click();
		WebElement Fx=login.driver.findElement(By.xpath("//div[@class='function-editor-window--icon']"));
		Fx.click();
		WebElement Mul=login.driver.findElement(By.xpath("//div[@data-id='MULTIPLY']"));
		jse.executeScript("arguments[0].scrollIntoView(true);", Mul);
		WebDriverWait wait = new WebDriverWait(login.driver, 80);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//div[@data-id='AGGREGATE']")))).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//button[text()='Insert function']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//button[text()='Apply']")).click();
		CommonFunctionality.wait(2000);
		
		login.driver.findElement(By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[2]")).click();
		
		WebElement Second_Series=login.driver.findElement(By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[3]"));
		Second_Series.click();
		CommonFunctionality.wait(2000);
		WebElement Fx1=login.driver.findElement(By.xpath("//div[@class='function-editor-window--icon']"));
		Fx1.click();
		WebElement AGGR=login.driver.findElement(By.xpath("//div[@data-id='AGGREGATE']"));
		jse.executeScript("arguments[0].scrollIntoView(true);", AGGR);
		WebDriverWait wait1 = new WebDriverWait(login.driver, 50);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(("//div[@data-id='DISAGGREGATE']")))).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//button[text()='Insert function']")).click();
		CommonFunctionality.wait(3000);
		login.driver.findElement(By.xpath("//button[text()='Apply']")).click();
	   
	}
	
	@Then("^should be able to unmark in favorite function pop up window$")
	public void should_be_able_to_unmark_in_favorite_function_pop_up_window() throws Throwable {
		WebElement Series_Name=login.driver.findElement(By.xpath("(//span[@class='series-name-field--series-name']/span)[1]"));
		new Actions(login.driver).moveToElement(Series_Name).pause(3000).build().perform();
		login.driver.findElement(By.xpath("(//div[@title='Apply Function'])[1]")).click();
		CommonFunctionality.wait(2000);
		WebElement AggregateFunction=login.driver.findElement(By.xpath("(//span[normalize-space(text())='AGGREGATE'])[1]"));
		WebElement DisaggregateFunction=login.driver.findElement(By.xpath("(//span[normalize-space(text())='DISAGGREGATE'])[1]"));
		if(AggregateFunction.isDisplayed()) {
			System.out.println("Aggregate function is displayed");
		}
		else {
			fail("Aggregate function is not displayed");
		}
		if(DisaggregateFunction.isDisplayed()) {
			System.out.println("Disaggregate function is displayed");
		}
		else {
			fail("Disaggregate function is not displayed");
		}
	

	}
	
	
	
	

	@Given("^click on fx\\.$")
	public void click_on_fx() throws Throwable {
		WebElement Series_Name=login.driver.findElement(By.xpath("(//span[@class='series-name-field--series-name']/span)[1]"));
		new Actions(login.driver).moveToElement(Series_Name).pause(3000).build().perform();
		login.driver.findElement(By.xpath("(//div[@title='Apply Function'])[1]")).click();
	    
	}

	@Then("^last applied function should be on top\\.$")
	public void last_applied_function_should_be_on_top() throws Throwable {
		WebElement Last_AppliedFunction=login.driver.findElement(By.xpath("(//span[normalize-space(text())='DISAGGREGATE'])[1]"));
		if(Last_AppliedFunction.isDisplayed()) {
			System.out.println("Last applied function is displayed at the top");
		}
		else {
			fail("Last applied function is not displayed at the top");
		}
	}

	
	
	
	
	@Given("^Apply first series with function round$")
	public void apply_first_series_with_function_round() throws Throwable {
		WebElement First_Series=login.driver.findElement(By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[1]"));
		First_Series.click();
		WebElement Fx=login.driver.findElement(By.xpath("//div[@class='function-editor-window--icon']"));
		Fx.click();
		WebElement Mul=login.driver.findElement(By.xpath("//div[@data-id='MULTIPLY']"));
		jse.executeScript("arguments[0].scrollIntoView(true);", Mul);
		CommonFunctionality.wait(2000);
		WebElement AGGR=login.driver.findElement(By.xpath("//div[@data-id='AGGREGATE']"));
		jse.executeScript("arguments[0].scrollIntoView(true);", AGGR);
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//span[normalize-space(text())='ROUND']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//button[text()='Insert function']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//button[text()='Apply']")).click();
	}

	@Then("^select second series and apply same function as round\\.$")
	public void select_second_series_and_apply_same_function_as_round() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("(//div[@title='Apply Function'])[3]")).click();
		
		WebElement Favorite=login.driver.findElement(By.xpath("//div[normalize-space(text())='Favorite']/following::div[@class='toggle-favorite-control toggle-favorite-control__favorite']"));
		if(Favorite.isDisplayed()) {
			System.out.println("Already Marked as Favorite is shown for 2nd series");
		}
		else {
			fail("Favorite is not clicked");
		}
	}

		@Given("^user creates a visual=>click on edit series$")
	      public void user_creates_a_visual_click_on_edit_series() throws Throwable {
			login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[1]")).click();		
		
		WebElement First_Series = login.driver.findElement(By.xpath("(//div[@class='series-list-item--information'])[1]"));
		action.moveToElement(First_Series).pause(2000).build().perform();
		
		WebElement More_Actions=login.driver.findElement(By.xpath("//span[@title='More actions']"));
		 jse. executeScript("arguments[0]. click();", More_Actions);
		 WebElement View_Chart=login.driver.findElement(By.xpath("//span[normalize-space()='Add chart']"));
		 action.moveToElement(View_Chart).pause(2000).build().perform();
		 login.driver.findElement(By.xpath("//div[contains(@class,'icon--chart-line_large')]")).click();
		 CommonFunctionality.wait(2000);
		 login.driver.findElement(By.xpath("//button[text()='Edit Series']")).click();
	   
	}
	
	@Given("^user add twenty one series to my series\\.$")
	public void user_add_twenty_one_series_to_my_series() throws Throwable {
		/*List<WebElement> checkboxes = login.driver
				.findElements(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']"));
		
		for(int i=0;i<20;i++) {
			//System.out.println("========="+i);
			//login.driver.findElement(By.xpath("(//*[@class='series-list-item--checkbox svg-checkbox'])["+i+"]")).click();
			
			CommonFunctionality.wait(3000);
			checkboxes.get(i).click();
			CommonFunctionality.wait(2000);
		}
		login.driver.findElement(By.xpath("(//div[@class='add-to-data-selection--icon'])[1]")).click();*/
		CommonFunctionality.wait(2000);
		
		for(int i=0;i<2;i++) {
			List<WebElement> regions=login.driver.findElements(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']"));
			
		
			System.out.println("Size is "+regions.size());
			for(WebElement e:regions) {
				JavascriptExecutor jse=(JavascriptExecutor)login.driver;
				jse.executeScript("arguments[0].scrollIntoView(true);", e);
				e.click();	
				
				
				
			}
			
			login.driver.findElement(By.xpath("(//div[@class='add-to-data-selection--icon'])[1]")).click();
		}
		}
		
		
	   
	

	@Given("^Apply each with different functions=>Mark as favorite\\.$")
	public void apply_each_with_different_functions_Mark_as_favorite() throws Throwable {
		CommonFunctionality.wait(3000);
		
		WebElement First_Series=login.driver.findElement(By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[1]"));
		//jse.executeScript("arguments[0].scrollIntoView(true);", First_Series);
		First_Series.click();
		WebElement Fx=login.driver.findElement(By.xpath("//div[@class='function-editor-window--icon']"));
		Fx.click();
		WebDriverWait wait = new WebDriverWait(login.driver, 80);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//div[@data-id='AGGREGATE']")))).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//button[text()='Insert function']")).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//button[text()='Apply']")).click();
		CommonFunctionality.wait(2000);
		try {
			if(login.driver.findElement(By.xpath("//div[@class='toggle-favorite-control toggle-favorite-control__favorite']")).isDisplayed()) {
				System.out.println("Starred icon clicked already");
			}
		}
		catch(Exception e) {
		WebElement Starred_icon=login.driver.findElement(By.xpath("//div[@class='toggle-favorite-control--icon']"));
		Starred_icon.click();
		}
		login.driver.findElement(By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[2]")).click();
		Robot robot=new Robot();
		for(int i=0;i<2;i++) {
		
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		}
		
		
		WebElement Second_Series=login.driver.findElement(By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[3]"));
		//jse.executeScript("arguments[0].scrollIntoView(true);", Second_Series);
		//jse.executeScript("window.scrollBy(0,2500)");
		Second_Series.click();
		CommonFunctionality.wait(2000);
		WebElement Fx1=login.driver.findElement(By.xpath("//div[@class='function-editor-window--icon']"));
		Fx1.click();
		WebDriverWait wait1 = new WebDriverWait(login.driver, 50);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(("//div[@data-id='DISAGGREGATE']")))).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//button[text()='Insert function']")).click();
		CommonFunctionality.wait(3000);
		login.driver.findElement(By.xpath("//button[text()='Apply']")).click();
		try {
			if(login.driver.findElement(By.xpath("//div[@class='toggle-favorite-control toggle-favorite-control__favorite']")).isDisplayed()) {
				System.out.println("Starred icon clicked already");
			}
		}
		catch(Exception e) {
			login.driver.findElement(By.xpath("//div[@class='toggle-favorite-control--icon']")).click();
		}
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[4]")).click();
		
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		
		WebElement Third_Series=login.driver.findElement(By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[5]"));
		//jse.executeScript("arguments[0].scrollIntoView(true);", Third_Series);
		//jse.executeScript("window.scrollBy(0,2500)");
		Third_Series.click();
		CommonFunctionality.wait(2000);
		WebElement Fx2=login.driver.findElement(By.xpath("//div[@class='function-editor-window--icon']"));
		Fx2.click();
		WebDriverWait wait2 = new WebDriverWait(login.driver, 50);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//div[@data-id='MATHNATLOG'])[1]")))).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//button[text()='Insert function']")).click();
		CommonFunctionality.wait(3000);
		login.driver.findElement(By.xpath("//button[text()='Apply']")).click();
		try {
			if(login.driver.findElement(By.xpath("//div[@class='toggle-favorite-control toggle-favorite-control__favorite']")).isDisplayed()) {
				System.out.println("Starred icon clicked already");
			}
		}
		catch(Exception e) {
		login.driver.findElement(By.xpath("//div[@class='toggle-favorite-control--icon']")).click();
		}
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[6]")).click();
		
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		
		
		WebElement Fourth_Series=login.driver.findElement(By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[7]"));
		//jse.executeScript("arguments[0].scrollIntoView(true);", Fourth_Series);
	//	jse.executeScript("window.scrollBy(0,2500)");
		Fourth_Series.click();
		CommonFunctionality.wait(2000);
		WebElement Fx3=login.driver.findElement(By.xpath("//div[@class='function-editor-window--icon']"));
		Fx3.click();
		WebDriverWait wait3 = new WebDriverWait(login.driver, 50);
		wait3.until(ExpectedConditions.elementToBeClickable(By.xpath(("//div[@data-id='MATHEXPONENTIAL']")))).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//button[text()='Insert function']")).click();
		CommonFunctionality.wait(3000);
		login.driver.findElement(By.xpath("//button[text()='Apply']")).click();
		try {
			if(login.driver.findElement(By.xpath("//div[@class='toggle-favorite-control toggle-favorite-control__favorite']")).isDisplayed()) {
				System.out.println("Starred icon clicked already");
			}
		}
		catch(Exception e) {
		login.driver.findElement(By.xpath("//div[@class='toggle-favorite-control--icon']")).click();
		}
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[8]")).click();
	
		
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		
		
		WebElement Fifth_Series=login.driver.findElement(By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[9]"));
		//jse.executeScript("arguments[0].scrollIntoView(true);", Fifth_Series);
	//	jse.executeScript("window.scrollBy(0,2500)");
		Fifth_Series.click();
		CommonFunctionality.wait(2000);
		WebElement Fx4=login.driver.findElement(By.xpath("//div[@class='function-editor-window--icon']"));
		Fx4.click();
		WebDriverWait wait4 = new WebDriverWait(login.driver, 50);
		wait4.until(ExpectedConditions.elementToBeClickable(By.xpath(("//div[@data-id='MATHSQROOT']")))).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//button[text()='Insert function']")).click();
		CommonFunctionality.wait(3000);
		login.driver.findElement(By.xpath("//button[text()='Apply']")).click();
		try {
			if(login.driver.findElement(By.xpath("//div[@class='toggle-favorite-control toggle-favorite-control__favorite']")).isDisplayed()) {
				System.out.println("Starred icon clicked already");
			}
		}
		catch(Exception e) {
		login.driver.findElement(By.xpath("//div[@class='toggle-favorite-control--icon']")).click();
		}
		CommonFunctionality.wait(2000);
		WebElement Remove=login.driver.findElement(By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[10]"));
		Remove.click();
		/*for(int i=0;i<3;i++) {
		jse.executeScript("window.scrollBy(0,500)");
		}*/
		/*try {
			jse.executeScript("arguments[0].scrollIntoView();", login.driver.findElement(By.xpath("//div[@class='webix_ss_vscroll webix_vscroll_y']")));
		}
		catch(Exception e) {
			System.out.println("Scroll not found");
		}*/
		
		
		/*for(int i=0;i<3;i++) {
			List<WebElement> regions=login.driver.findElements(By.xpath("//span[@class='table-container--checkbox svg-checkbox input-control__grey']"));
			
		
			System.out.println("Size is "+regions.size());
			for(WebElement e:regions) {
				JavascriptExecutor jse=(JavascriptExecutor)login.driver;
				jse.executeScript("arguments[0].scrollIntoView(true);", e);
				//jse.executeScript("window.scrollBy(0,4000)",e);
				//e.click();	
			}	
				
				
			}*/
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

		WebElement Sixth_Series=login.driver.findElement(By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[11]"));
		//jse.executeScript("arguments[0].scrollIntoView(true);", Sixth_Series);
	//	jse.executeScript("window.scrollBy(0,4000)",Sixth_Series);
		Sixth_Series.click();
		CommonFunctionality.wait(2000);
		WebElement Fx5=login.driver.findElement(By.xpath("//div[@class='function-editor-window--icon']"));
		Fx5.click();
		WebDriverWait wait5 = new WebDriverWait(login.driver, 50);
		wait5.until(ExpectedConditions.elementToBeClickable(By.xpath(("//div[@data-id='MATHLOGBASE10']")))).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//button[text()='Insert function']")).click();
		CommonFunctionality.wait(3000);
		login.driver.findElement(By.xpath("//button[text()='Apply']")).click();
		
		try {
			if(login.driver.findElement(By.xpath("//div[@class='toggle-favorite-control toggle-favorite-control__favorite']")).isDisplayed()) {
				System.out.println("Starred icon clicked already");
				
			}
		}
		catch(Exception e) {
		login.driver.findElement(By.xpath("//div[@class='toggle-favorite-control--icon']")).click();
		}
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		
		
		CommonFunctionality.wait(2000);
	  // login.driver.findElement(By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[12]")).click();
		for(int i=0;i<3;i++) {
			 //login.driver.findElement(By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[12]")).click();
			List<WebElement> regions=login.driver.findElements(By.xpath("//span[@class='table-container--checkbox svg-checkbox input-control__grey']"));
			//WebElement regions=login.driver.findElement(By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[11]"));
		
		
		
		
		
		
		
		
		
		
	    CommonFunctionality.wait(3000);
	    //login.driver.findElement(By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[12]")).click();
        WebElement Seventh_Series=login.driver.findElement(By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[13]"));
        //jse.executeScript("arguments[0].scrollIntoView(true);", Seventh_Series);
       // jse.executeScript("window.scrollBy(0,2500)");
        Seventh_Series.click();
		CommonFunctionality.wait(2000);
		WebElement Fx6=login.driver.findElement(By.xpath("//div[@class='function-editor-window--icon']"));
		Fx6.click();
		WebDriverWait wait6 = new WebDriverWait(login.driver, 50);
		wait6.until(ExpectedConditions.elementToBeClickable(By.xpath(("//div[@data-id='MATHRECPROCAL']")))).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//button[text()='Insert function']")).click();
		CommonFunctionality.wait(3000);
		login.driver.findElement(By.xpath("//button[text()='Apply']")).click();
		try {
			if(login.driver.findElement(By.xpath("//div[@class='toggle-favorite-control toggle-favorite-control__favorite']")).isDisplayed()) {
				System.out.println("Starred icon clicked already");
			}
		}
		catch(Exception e) {
		login.driver.findElement(By.xpath("//div[@class='toggle-favorite-control--icon']")).click();
		}
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	
		}	
	}
	@Given("^Apply with function=>Mark as favorite$")
	public void apply_with_function_Mark_as_favorite() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("(//*[@placeholder='Type a function'])[2]")).click();
		CommonFunctionality.wait(1000);
		login.driver.findElement(By.xpath("//li[@title='Calculates the cumulative sum-to-date of a selected series']")).click();
		CommonFunctionality.wait(2000);
		WebElement Favorite=login.driver.findElement(By.xpath("(//div[@class='toggle-favorite-control--icon'])[2]"));
		Favorite.click();
	   
	}

	@Then("^click on more function dropdown at same time=>Right click on visual$")
	public void click_on_more_function_dropdown_at_same_time_Right_click_on_visual() throws Throwable {
		CommonFunctionality.wait(3000);
		WebElement More_Functions_Dp=login.driver.findElement(By.xpath("//div[normalize-space(text())='More functions']"));
		More_Functions_Dp.click();
		WebElement Calculate_series=login.driver.findElement(By.xpath("//div[@class='visual-item-wrapper--credits-container']"));
		new Actions(login.driver).moveToElement(Calculate_series).pause(500).contextClick().build().perform();
		WebElement Hover_CalSeries=login.driver.findElement(By.xpath("//span[text()='Calculate series']"));
		new Actions(login.driver).moveToElement(Hover_CalSeries).pause(2000).build().perform();
		Thread.sleep(4000);
		WebElement Starred_icon=login.driver.findElement(By.xpath("(//span[text()='ACCUMULATE']/preceding::div[@class='toggle-favorite-control toggle-favorite-control__favorite'])[2]"));
		if(Starred_icon.isDisplayed()) {
			System.out.println("Starred icon is verified in calculate series");
		}
		else {
			fail("Starred icon is not present");
		}
		
		
	  
	}

	
	
	

}
