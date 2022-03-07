package CDMNext.StepDefinations;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.*;
import org.testng.Assert;

public class Dependency {
	public static WebDriverWait wait = new WebDriverWait(login.driver, 100);
	// WebDriverWait wait = new WebDriverWait(login.driver, 50);
	Actions action = new Actions(login.driver);
	JavascriptExecutor js = (JavascriptExecutor) login.driver;
	public boolean checkbox;
	// public static String series1;
	public static String seriesname;
	

	// TC_01
	@Given("^User Select Series ID as \"([^\"]*)\"$")
	public void user_Select_Series_ID_as(String arg1) throws Throwable {
		CommonFunctionality.DeleteSeries();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).click();
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).clear();
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(arg1);
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(Keys.ENTER);
		Thread.sleep(10000);
	}

	// TC_01
	@And("^click on datasets$")
	public void click_on_datasets() throws Throwable {
		Thread.sleep(10000);

		// wait(3000);
		// WebElement datasets =
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Datasets')]")))
				.click();
		// datasets.click();
		// login.driver.findElement(By.xpath("//span[contains(text(),'Datasets')]")).click();

	}

	// TC_01
	@Given("^add some of series into my series tab$")
	public void add_some_of_series_into_my_series_tab() throws Throwable {
      Thread.sleep(3000);
		for (int i = 1; i <= 2; i++) {
		
			login.driver.findElement(By.xpath("(//div[@class='title']/span[@class='svg-checkbox'])["+i+"]")).click();

		}
		
		// mouse over to '+'icon
		//WebElement mouseover = login.driver.findElement(By.xpath("//div[@class='add-to-data-selection--icon']"));
		//action.pause(500).moveToElement(mouseover).build().perform();
		// login.driver.findElement(By.xpath(
		// "//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]"))
		// .click();
		Thread.sleep(1000);

		// click on '+' icon
		login.driver.findElement(By.xpath("(//div[@class='add-to-data-selection--icon'])[1]")).click();
		Thread.sleep(3000);
		//select all series check box checked
		login.driver.findElement(By.xpath("(//span[@class='input-control--indicator'])[1]")).click();
		
		//Thread.sleep(1000);
		//login.driver.findElement(By.xpath(
				//"//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]"))
				//.click();
		Thread.sleep(2000);
		// checked check box my series
	//	login.driver.findElement(By.xpath(
			//	"//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/label[1]/span[1]"))
				//.click();
	}

	// TC_01
	@Given("^click on related series$")
	public void click_on_related_series() throws Throwable {

		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[contains(text(),'Related Series')]")).click();
	}

	// TC_01
	@Given("^Navigate to dependencies tab$")
	public void navigate_to_dependencies_tab() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[contains(text(),'Dependencies')]")).click();
	}

	// TC_01
	@Then("^Dependencies tab should be seen$")
	public void dependencies_tab_should_be_seen() throws Throwable {
		Thread.sleep(2000);
		String dependency = login.driver.findElement(By.xpath("//div[contains(text(),'Dependencies')]")).getText();
		System.out.println("Dependencies tab data:" + dependency);
		String s = "Dependencies";
		assertEquals(dependency, s);
		Thread.sleep(3000);
		// CommonFunctionality.DeleteSeries();
		System.out.println("------------------------------------>1");
	}

	// TC_02
	@Then("^Chart of first dependencies only shown and all below are hidden$")
	public void chart_of_first_dependencies_only_shown_and_all_below_are_hidden() throws Throwable {
		Thread.sleep(8000);
		
		
		if(login.driver.findElements(By.xpath("//div[@class='series-with-suggestions-preview series-with-suggestions-preview__active']")).size()==1)
		{
			System.out.println("First dependencies chat shown");
		}
		else {
			Assert.fail();
		}
		
		
		WebElement scrolldown = login.driver.findElement(By.xpath("//div[@class='series-with-suggestions-preview']"));
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView();", scrolldown);
		
		
		
		//login.driver.findElements(By.xpath("//div[@class='series-with-suggestions-preview']")).size()==2
		
		
		
	/*	WebElement scrolldown1 = login.driver
				.findElement(By.xpath("//span[contains(text(),'FX Spot Rate: FRB: Finland Markkas')]"));
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView();", scrolldown1);
		String firstdependencies = login.driver
				.findElement(By.xpath("//span[contains(text(),'FX Spot Rate: FRB: Finland Markkas')]")).getText();
		System.out.println("firstdependencies data: " + firstdependencies);
		Assert.assertEquals(firstdependencies, (firstdependencies));
		WebElement scrolldown = login.driver
				.findElement(By.xpath("//div[contains(text(),'Gross DomesticProduct (GDP): 2015p: sa')]"));
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView();", scrolldown);*/

		System.out.println("Test case pass");
		// CommonFunctionality.DeleteSeries();
		System.out.println("------------------------------------>2");
	}

//TC_03
	@And("^click on manage all dropdown$")
	public void click_on_manage_all_dropdown() throws Throwable {
		Thread.sleep(3000);

		if (!login.driver.findElement(By.xpath("//div[@class='suggestions-panel--checker-all']")).isSelected())

		{
			login.driver.findElement(By.xpath("//div[@class='suggestions-panel--checker-all']")).click();
		}

		else {
			Assert.fail("Manage All dropdown not selected");

		}

	}

//TC_03
	@Then("^Select dependencies & Unselect dependencies options should be present$")
	public void select_dependencies_Unselect_dependencies_options_should_be_present() throws Throwable {
		Thread.sleep(3000);

		login.driver.findElement(By.xpath("//div[@class='suggestions-panel--arrow icon--filter-arrow']")).click();

		String drop = login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu ']")).getText();
		System.out.println("Manage all drop down data:" + drop);
		System.out.println(3000);
		System.out.println("------------------------------------>3");
	}

	// TC_04
	@And("^select 'Select dependencies'$")
	public void select_Select_dependencies() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='suggestions-panel--arrow icon--filter-arrow']")).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Select Dependencies')]")).click();

	}

	// TC_04
	@Then("^Add button should get colored by ticking as right with apply button enabled$")
	public void add_button_should_get_colored_by_ticking_as_right_with_apply_button_enabled() throws Throwable {
		Thread.sleep(3000);

		if (login.driver.findElements(By.xpath("(//button[@class='button button__sm button__secondary_purple suggested-series-control--add button__active'])[1]")).size()==1)
		{
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
			// Thread.sleep(2000);
			// if
			// (login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).isEnabled())
			// {
			// login.driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
			System.out.println("Test case pass");
			Thread.sleep(4000);
		} else {
			Assert.fail("test case failed");
		}

		// }
		// else {
		// Assert.fail("test case failed");

		// }
		System.out.println("------------------------------------>4");
	}

	// TC_05
	@And("^select 'unselect dependencies'$")
	public void select_unselect_dependencies() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='suggestions-panel--arrow icon--filter-arrow']")).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Unselect Dependencies')]")).click();

	}

	// TC_05
	@Then("^color turn to white with unticked Add button with disabling apply button$")
	public void color_turn_to_white_with_unticked_Add_button_with_disabling_apply_button() throws Throwable {

		Thread.sleep(3000);
		/*
		 * if (login.driver.findElement(By.xpath(
		 * "//body/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/li[1]/div[1]/a[1]/div[4]/button[1]/span[1]"
		 * )) .isDisplayed()) { Thread.sleep(2000);
		 * 
		 * Assert.fail("test case failed"); } else {
		 * System.out.println("unchecked add button");
		 */

		/*
		 * if (login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).
		 * isEnabled()) {
		 * 
		 * System.out.println("Test case pass"); } else {
		 * Assert.fail("test case failed"); }
		 */
		Thread.sleep(2000);
		WebElement e = login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]"));
		boolean actualValue = e.isEnabled();
		Thread.sleep(1000);
		if (actualValue == true) {
			System.out.println("disabling apply button");
		} else {
			System.out.println("Button is enabled");
			Assert.fail("test case failed");

		}

		System.out.println("------------------------------------>5");
	}

	// TC_06
	@Then("^Should be able to check all the series in dependencies$")
	public void should_be_able_to_check_all_the_series_in_dependencies() throws Throwable {
		Thread.sleep(3000);

		if (login.driver.findElements(By.xpath("//div[@class='series-with-suggestions "
				+ "series-with-dependencies series-with-suggestions__open-suggestions series-list-item__selected']"))
				.size() > 0) {
			System.out.println("Should be able to check all the series in dependencies");
		} else {
			Assert.fail("Test case failed");
		}
		System.out.println("------------------------------------>6");
	}

	// TC_07
	@Then("^Should be able to 'uncheck all the series' in dependencies$")
	public void should_be_able_to_uncheck_all_the_series_in_dependencies() throws Throwable {
		Thread.sleep(3000);

		if (login.driver.findElements(By.xpath("//div[@class='series-with-suggestions "
				+ "series-with-dependencies series-with-suggestions__open-suggestions series-list-item__selected']"))
				.size() > 0) {
			Assert.fail("Test case failed");
		} else {
			System.out.println("Should be able to 'uncheck all the series' in dependencies");

		}
		System.out.println("------------------------------------>7");
	}

	// TC_08
	@And("^click on any of the series add button$")
	public void click_on_any_of_the_series_add_button() throws Throwable {
		Thread.sleep(4000);

		login.driver.findElement(By.xpath("(//button[@class='button button__sm button__secondary_purple suggested-series-control--add'])[1]")).click();

	}

	// TC_08
	@Then("^Should be able to check that particular series and added to apply required changes$")
	public void should_be_able_to_check_that_particular_series_and_added_to_apply_required_changes() throws Throwable {

		Thread.sleep(4000);
		login.driver.findElement(By.xpath("//div[@class='suggestions-apply-button']")).click();

		if (login.driver.findElement(By.xpath("//span[@class='suggested-series-control--added-icon']")).isDisplayed())

		{
			System.out.println("Test case pass");
		}

		else {
			Assert.fail("Test case failed");
		}
		System.out.println("------------------------------------>8");

	}

//TC_09
	@And("^Click on 'chart icon' of first dependencies series$")
	public void click_on_chart_icon_of_first_dependencies_series() throws Throwable {
		Thread.sleep(3000);

		login.driver
				.findElement(By.xpath(
						"//div[@class='series-with-suggestions-preview series-with-suggestions-preview__active']"))
				.click();

	}

//TC_09
	@Then("^'Chart opened' should be closed$")
	public void chart_opened_should_be_closed() throws Throwable {
		Thread.sleep(3000);
		if (login.driver.findElement(By.xpath("//div[@class='legend-item--marker legend-item--hide-series']"))
				.isDisplayed()) {
			System.out.println("Test case failed");
			Assert.fail("Test case failed");
		} else {

			System.out.println("Chart opened' should be closed");
		}
		System.out.println("------------------------------------>9");
	}

//TC_10
	@And("^Click on chart icon of rest of the dependencies series except the first one$")
	public void click_on_chart_icon_of_rest_of_the_dependencies_series_except_the_first_one() throws Throwable {

		Thread.sleep(3000);
		WebElement scroll = login.driver.findElement(By.xpath("//div[@class='series-with-suggestions-preview']"));
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView();", scroll);
		System.out.println("Scroll down successfully");
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='series-with-suggestions-preview']")).click();
		Thread.sleep(2000);
		System.out.println("successfully click on chat icon except the first one");

	}

//TC_10
	@Then("^Should be able to shown chart for dependencies with its legends and as in SSP window$")
	public void should_be_able_to_shown_chart_for_dependencies_with_its_legends_and_as_in_SSP_window()
			throws Throwable {

		Thread.sleep(3000);
		login.driver.findElement(By.xpath("(//span[@class='series-edit--title series-edit--title__editable'])[1]")).click();
		
		Thread.sleep(2000);
		String SSP = login.driver.findElement(By.xpath("//span[@class='series-preview-modal-header--link']")).getText().toString();
		System.out.println("SSP popup should be open:" + SSP);
		System.out.println("------------------------------------>10");
	}

	// TC_11
	@And("^mouse Hover on any of the series present under dependencies tab$")
	public void mouse_Hover_on_any_of_the_series_present_under_dependencies_tab() throws Throwable {
		Thread.sleep(3000);

		WebElement we = login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"));
		action.moveToElement(we).build().perform();

	}

//TC_11
	@Then("^Should be shown with series tooltip$")
	public void should_be_shown_with_series_tooltip() throws Throwable {
		Thread.sleep(3000);
		WebElement tooltip = login.driver.findElement(By.xpath("//body/div[@class='tooltip tooltip__visible']"));
		System.out.println("tooltip data:" + tooltip);
		if (tooltip.isDisplayed()) {
			System.out.println("Tooltip displayed");

		}

		else {
			Assert.fail("Test case failed");
		}

		System.out.println("------------------------------------>11");

	}

//TC_12
	@And("^Click on any of the series under dependencies tab$")
	public void click_on_any_of_the_series_under_dependencies_tab() throws Throwable {
		Thread.sleep(2000);
		String seriesname = login.driver
				.findElement(By.xpath("(//div[@class='suggested-series-item--title'])[1]")).getText();
		System.out.println("series name:" + seriesname);
		login.driver.findElement(By.xpath("(//div[@class='suggested-series-item--title'])[1]")).click();
		Thread.sleep(2000);

	}

//TC_12
	@Then("^Should be open with SSP window for respective series$")
	public void should_be_open_with_SSP_window_for_respective_series() throws Throwable {

		Thread.sleep(2000);
		String Sname = login.driver
				.findElement(
						By.xpath("//span[@class='series-preview-modal-header--link']"))
				.getText();
		System.out.println("Sname:" + Sname);
		System.out.println("series name:" + seriesname);
		// Assert.assertEquals("FX Spot Rate: FRB: Finland Markkas",seriesname);
		// Assert.assertEquals(seriesname, "FX Spot Rate: FRB: Finland Markkas");
		System.out.println("------------------------------------>12");
	}

	// TC_13
	@And("^Click on Add button for dependencies present$")
	public void click_on_Add_button_for_dependencies_present() throws Throwable {
		Thread.sleep(3000);

		for (int i = 1; i <=3; i++) {
			// String
			// series1=login.driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/li[1]/div[1]/a[1]/div[3]/div[1]/div[2]/div[1]/div[1]")).getText();

			/// WebElement
			/// seires1=login.driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/li[1]/div[1]/a[1]/div[3]/div[1]/div[2]/div[1]/div[1]"));
			// System.out.println("series name in dependencetab:"+series1 );

			login.driver.findElement(By.xpath("(//button[@class='button button__sm button__secondary_purple suggested-series-control--add'])["+i+"]")).click();

		}

	}

//TC_13
	@Then("^Should be able to add series manual and apply button should be enabled$")
	public void should_be_able_to_add_series_manual_and_apply_button_should_be_enabled() throws Throwable {

		Thread.sleep(3000);
		if (login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).isEnabled()) {
			System.out.println("apply button should be enabled");
			login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		} 
		else {
			Assert.fail("Test case failed ");
		}
		System.out.println("------------------------------------>13");
		Thread.sleep(4000);
	}

	// TC_14
	@Then("^Should be able to close suggestion window without adding any of the dependencies in my series$")
	public void should_be_able_to_close_suggestion_window_without_adding_any_of_the_dependencies_in_my_series()
			throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();

		System.out.println(" close suggestion window without adding any of the dependencies in my series");
		System.out.println("------------------------------------>14");
	}

	// TC_15
	@And("^Click on apply and ok button$")
	public void click_on_apply_and_ok_button() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
	}

//TC_15
	@Then("^Should be able to add dependencies for selected series under dependencies tab$")
	public void should_be_able_to_add_dependencies_for_selected_series_under_dependencies_tab() throws Throwable {
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("(//div[@class='webix_tree_close'])[1]")).click();

		Thread.sleep(1000);
		String seriesname = login.driver.findElement(By.xpath("(//span[@class='series-name-field-title'])[2]")).getText();
		System.out.println("my series series name:" + seriesname);
		// System.out.println("series name in dependencetab:"+series1 );

		// Assert.assertEquals(seriesname, seires1);
		System.out.println("Should be able to add dependencies for selected series under dependencies tab");
		System.out.println("------------------------------------>15");
	}

	
	
	
	//TC_16
	@And("^swiching between dependence tab to forecast tab$")
	public void swiching_between_dependence_tab_to_forecast_tab() throws Throwable {
		Thread.sleep(3000);

		// Forecast
		login.driver.findElement(By.xpath("//div[contains(text(),'Forecast')]")).click();
		Thread.sleep(1000);
		if (login.driver.findElement(By.xpath("//span[contains(text(),'frequency')]")).isDisplayed()) {
			System.out.println("swiching between dependence tab to forecast tab");
			Thread.sleep(1000);
		} else {
			Assert.fail("Test case failed");
		}

	}

	//TC_16
	@And("^swiching between forecast tab to indicators tab$")
	public void swiching_between_forecast_tab_to_indicators_tab() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//div[contains(text(),'Indicators')]")).click();

		Thread.sleep(1000);
		if (login.driver.findElement(By.xpath("//div[contains(text(),'Business Confidence')]")).isDisplayed()) {
			System.out.println("swiching between dependence tab to forecast tab");
			Thread.sleep(1000);
		} else {
			Assert.fail("Test case failed");
		}

		System.out.println("------------------------------------>16");
	}

//TC_17
	@And("^Click on minimize icon for dependencies present in a tab$")
	public void click_on_minimize_icon_for_dependencies_present_in_a_tab() throws Throwable {
		Thread.sleep(3000);

		login.driver
				.findElement(By.xpath("//div[@class='movable-modal--action-icon movable-modal--action-icon__toggle']"))
				.click();
		Thread.sleep(1000);

	}

//TC_17
	@Then("^dependencies tab should be minimmized$")
	public void dependencies_tab_should_be_minimmized() throws Throwable {

		System.out.println("dependencies tab should be minimmized");

		System.out.println("------------------------------------>17");
	}

//TC_18
	@Then("^click on miximize icon for dependence contrasted$")
	public void click_on_miximize_icon_for_dependence_contrasted() throws Throwable {
		Thread.sleep(2000);
		login.driver
				.findElement(By.xpath("//div[@class='movable-modal--action-icon movable-modal--action-icon__toggle']"))
				.click();
		System.out.println("------------------------------------>18");
	}

//TC_19
	@Then("^click on the minimizing icon in SSP Window$")
	public void click_on_the_minimizing_icon_in_SSP_Window() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='movable-modal single-series-preview--modal movable-modal__draggable movable-modal__active']//div[@title='Minimize']")).click();
		System.out.println("minimizing the SSP window");

		System.out.println("------------------------------------>19");

	}

//TC_20
	@Then("^click on the maximizing icon in SSP window$")
	public void click_on_the_maximizing_icon_in_SSP_window() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//body/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]")).click();
		System.out.println("maximizing the SSP window");

		System.out.println("------------------------------------>20");

	}

//TC_21
	@And("^click on full-screen icon$")
	public void click_on_full_screen_icon() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='movable-modal--action-icon__expand']")).click();

	}

//TC_21
	@Then("^Should attain full-screen state with dependencies tab open$")
	public void should_attain_full_screen_state_with_dependencies_tab_open() throws Throwable {
		Thread.sleep(2000);

		if (login.driver.findElement(By.xpath("//div[@class='movable-modal--action-icon__collapse']")).isDisplayed()) {
			System.out.println("Test case pass");
		}

		else {
			Assert.fail("Test case failed");
		}
		System.out.println("------------------------------------>21");

	}

//TC_22
	@And("^Click on double arrow again facing inwards$")
	public void click_on_double_arrow_again_facing_inwards() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='movable-modal--action-icon__collapse']")).click();

	}

//TC_22
	@Then("^Window should attain normal/usual open state with dependencies tab open$")
	public void window_should_attain_normal_usual_open_state_with_dependencies_tab_open() throws Throwable {

		if (login.driver.findElement(By.xpath("//div[@class='movable-modal--action-icon__expand']")).isDisplayed()) {
			System.out.println("Test case pass");
		}

		else {
			Assert.fail("Test case failed");
		}
		System.out.println("------------------------------------>22");

	}

//TC_23
	@And("^click on cross mark\\(X\\) button of a suggestion window$")
	public void click_on_cross_mark_X_button_of_a_suggestion_window() throws Throwable {
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//div[contains(text(),'×')]")).click();

	}

//TC_23
	@Then("^Window should be able to be closed$")
	public void window_should_be_able_to_be_closed() throws Throwable {

		Thread.sleep(2000);

		if (login.driver.findElement(By.xpath("//span[contains(text(),'Reset')]")).isDisplayed()) {
			System.out.println("Test case pass");
		} else {
			Assert.fail("Test case failed");
		}
		System.out.println("------------------------------------>23");

	}

//TC_24
	@And("^create visuals of the my series like table$")
	public void create_visuals_of_the_my_series_like_table() throws Throwable {
		Thread.sleep(2000);

		
		//select all series check box checked
				login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();
				
				
				//click on Right click
				
				WebElement rightbutton = login.driver.findElement(By.xpath("(//span[@class='group-name'])[1]"));
				action.contextClick(rightbutton).perform();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath("//span[contains(text(),'View as Table')]")).click();
				Thread.sleep(2000);

				
				//series harmonization
				if(login.driver.findElements(By.xpath("//button[contains(text(),'Apply')]")).size()==1)
				{
					login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
				}
				
				
				
		
	
		
	}

//TC_24
	@Then("^Should be able to create selectedvisuals$")
	public void should_be_able_to_create_selectedvisuals() throws Throwable {
		Thread.sleep(2000);

		if (login.driver.findElement(By.xpath("//button[contains(text(),'Edit Table')]")).isDisplayed()) {
			System.out.println("Should be able to create selectedvisuals");
		}

		else {
			Assert.fail("Tes case failed");
		}

		/*
		 * String Tableseriename=
		 * login.driver.findElement(By.xpath("//span[contains(text(),'YTD')]")).getText(
		 * );
		 * 
		 * System.out.println("Table series name:"+Tableseriename);
		 * 
		 * System.out.println("dependences series name:"+seriesname);
		 * Assert.assertEquals(Tableseriename, seriesname);
		 * 
		 * System.out.println("Should be able to create selectedvisuals");
		 */
		System.out.println("------------------------------------>24");

	}

//TC_25
	@And("^click on series name in dependencies series$")
	public void click_on_series_name_in_dependencies_series() throws Throwable {
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("(//div[@class='suggested-series-item--title'])[1]")).click();

	}

//TC_25
	@Then("^SSP window for dependencies series should be opened$")
	public void ssp_window_for_dependencies_series_should_be_opened() throws Throwable {
Thread.sleep(3000);
		if (login.driver.findElements(By.xpath("//div[@class='main-series-information--series-id']")).size()==1) {
			System.out.println("SSP window should be open");
		}

		else {
			Assert.fail("Tes case failed");
		}

		System.out.println("------------------------------------>25");

	}

//TC_26
	@And("^closing SSP window using cross mark$")
	public void closing_SSP_window_using_cross_mark() throws Throwable {

		Thread.sleep(3000);
		login.driver.findElement(By.xpath("(//div[@class='movable-modal--close'])[2]")).click();

	}

//TC_26
	@Then("^SSP window for dependencies series should be closed$")
	public void ssp_window_for_dependencies_series_should_be_closed() throws Throwable {

		if (login.driver.findElements(By.xpath("(//div[@class='insight-action-panel--btn-title'])[1]")).size()==1) {
			System.out.println("SSP window should be close");
		}

		else {
			Assert.fail("Tes case failed");
		}
		System.out.println("------------------------------------>26");
	}

//TC_27
	@And("^click on legend series cross box option$")
	public void click_on_legend_series_cross_box_option() throws Throwable {

		Thread.sleep(3000);

		WebElement scrolldown = login.driver
				.findElement(By.xpath("//div[contains(text(),'Gross DomesticProduct (GDP): 2015p: sa')]"));
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView();", scrolldown);
		Thread.sleep(3000);
		// css selector--> // div.highcharts-series-6 .legend-item--marker
		//login.driver.findElement(By.xpath("//*[@class='legend-item--marker legend-item--hide-series' and contains(@style,'color:#FDA546')]")).click();
		login.driver.findElement(By.xpath("(//div[@class='legend-item--marker legend-item--hide-series'])[1]")).click();
		
		
		Thread.sleep(2000);
	}

//TC_27
	@Then("^Series present in a chart should be disabled$")
	public void series_present_in_a_chart_should_be_disabled() throws Throwable {

		System.out.println("Series present in a chart should be disabled");

		System.out.println("---------------------->27");
	}

//TC_28

	@Then("^Series in a chart should be enabled$")
	public void series_in_a_chart_should_be_enabled() throws Throwable {

		Thread.sleep(3000);
		System.out.println("Series present in a chart should be Enable");

		System.out.println("---------------------->28");
	}

//TC_29
	@Then("^Scrollbar should be movable \\(ups/downs\\)$")
	public void scrollbar_should_be_movable_ups_downs() throws Throwable {
		Thread.sleep(2000);

		WebElement scrolldown = login.driver
				.findElement(By.xpath("//div[contains(text(),'Gross DomesticProduct (GDP): 2015p: sa')]"));
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView();", scrolldown);
		Thread.sleep(3000);

		WebElement scrollup = login.driver
				.findElement(By.xpath("//div[contains(text(),'FX Spot Rate: FRB: Finland Markkas')]"));
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView();", scrollup);
		Thread.sleep(3000);
		System.out.println("------------------------------------>29");
	}

//TC_30
	@And("^mouse hover on the legend series$")
	public void mouse_hover_on_the_legend_series() throws Throwable {
		Thread.sleep(3000);
		WebElement scrolldown = login.driver
				.findElement(By.xpath("//div[contains(text(),'Gross DomesticProduct (GDP): 2015p: sa')]"));
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView();", scrolldown);
		Thread.sleep(3000);

		WebElement hovermouse = login.driver
				.findElement(By.xpath("//div[contains(text(),'Gross DomesticProduct (GDP): 2015p: sa')]"));

		action.pause(500).moveToElement(hovermouse).build().perform();
		Thread.sleep(2000);

	}

//TC_30
	@Then("^Timepoints & series info has to be shown in its tooltip$")
	public void timepoints_series_info_has_to_be_shown_in_its_tooltip() throws Throwable {
		Thread.sleep(3000);

		String tooltipdata = login.driver.findElement(By.xpath("//div[@class='tooltip tooltip__visible']")).getText();
		System.out.println("tooltipdata:" + tooltipdata);
		if (login.driver.findElement(By.xpath("//td[contains(text(),'Region')]")).isDisplayed()) {
			System.out.println("Tooltip popup should be displayed");
		} else {
			Assert.fail("Test case failed");
		}
System.out.println("------------------------------------>30");
	}

//TC_31
	@And("^click on OK button$")
	public void click_on_OK_button() throws Throwable {
		Thread.sleep(2000);
		login.driver
				.findElement(By.xpath("//button[@class='sphere-modal-control button button__primary']"))
				.click();

	}

//TC_31
	@Then("^should be able reflect changes made on dependency series in my series tab$")
	public void should_be_able_reflect_changes_made_on_dependency_series_in_my_series_tab() throws Throwable {

		Thread.sleep(3000);

		if (login.driver.findElement(By.xpath(
				"(//div[@class='suggested-series-item--title'])[1]"))
			//"//body/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/li[1]/div[1]/a[1]/div[4]/button[1]"))
				.isDisplayed()) {
			System.out.println("Test case pass");
			login.driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();
			Thread.sleep(3000);
		} else {
			Assert.fail("Test case failed");
		}
		System.out.println("------------------------------------>31");
Thread.sleep(3000);

	}

//TC_32
	@And("^click on cross mark in add related series window$")
	public void click_on_cross_mark_in_add_related_series_window() throws Throwable {
		Thread.sleep(2000);
		// click on 'X' button
		login.driver.findElement(By.xpath("//div[@class='movable-modal--close']")).click();

	}

//TC_32
	@Then("^should be able reflect changes made on dependency series but should not close add related series window$")
	public void should_be_able_reflect_changes_made_on_dependency_series_but_should_not_close_add_related_series_window()
			throws Throwable {

		
		
		
		
		
		
		
		// click on cancel button
		login.driver
				.findElement(By.xpath("//button[@class='sphere-modal-control button button__text_purple']"))
				.click();

		if (login.driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).isDisplayed()) {
			System.out.println("should not close add related series window");
		}

		else {
			System.out.println("Test case failed");
		}

		System.out.println("------------------------------------>32");
	}

}


//Author=venkata swami
//username=venkat.test@gmail.com
//password=Ceic@123










