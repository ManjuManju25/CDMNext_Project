package CDMNext.StepDefinations;

import static org.junit.Assert.fail;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class ForecastSeries {
	String Exp_seriesName, frequencyTxt_beforeCheckFrequency, frequencyTxt_forBasicSeries;
	List<WebElement> beforeCheck_forecastSeriesList;
	List<WebElement> afterCheck_forecastSeriesList;
	JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	public String Applied_function;
	String[] lines = null;

	@And("^Add series to the right pane$")
	public void add_series_to_the_right_pane() throws Throwable {
		CommonFunctionality.wait(6000);
		CommonFunctionality.getElementByProperty(login.driver, "Series_Tab", 20).click();
		CommonFunctionality.wait(4000);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='add-to-data-selection--icon']", 30).click();
	}

	@Then("^\"([^\"]*)\" tab should be seen in series suggestion manager window$")
	public void tab_should_be_seen_in_series_suggestion_manager_window(String arg1) throws Throwable {
		String sugg_manager_tab_text = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='suggestions-manager']/*/*[1]/*[2]", 10).getText();
		if (sugg_manager_tab_text.equals(arg1)) {
			login.Log4j.info(arg1 + " tab seen in series suggestion manager window");
		} else {
			Assert.fail(arg1 + " tab not seen in series suggestion manager window");
		}
	}

	@And("^Open SSP window for the series$")
	public void open_SSP_window_for_the_series() throws Throwable {
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-name-field-title']", 10).click();
	}

	@Then("^\"([^\"]*)\" suggestions flag bar should be shown$")
	public void suggestions_flag_bar_should_be_shown(String arg1) throws Throwable {
		CommonFunctionality.wait(300);
		String forecast_sugg_flagBar = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='input-control--description']", 10).getText();
		if (forecast_sugg_flagBar.equals(arg1)) {
			login.Log4j.info(arg1 + " suggestions flag bar is shown in ssp window");
		} else {
			Assert.fail(arg1 + " suggestions flag bar not shown in ssp window");
		}
	}

	@And("^Check the checkbox for forecast series$")
	public void check_the_checkbox_for_forecast_series() throws Throwable {
		boolean checkbox_forecast = login.driver.findElement(By.xpath(
				"//*[@class='single-series-preview--operations-container']/*[1]/*[3]/*[2]/*[@class='checkbox-control']//*[@type='checkbox']"))
				.isSelected();
		if (!checkbox_forecast == true) {
			new Actions(login.driver)
					.moveToElement(login.driver.findElement(By.xpath(
							"//*[@class='single-series-preview--operations-container']/*[1]/*[3]/*[2]/*[@class='checkbox-control']//*[@type='checkbox']")))
					.pause(2000).click().build().perform();
		}
	}

	@Then("^Chart with forecast suggestions legends should be displayed$")
	public void chart_with_forecast_suggestions_legends_should_be_displayed() throws Throwable {
		CommonFunctionality.wait(1000);
		boolean charts_legend = login.driver
				.findElement(By.xpath("//*[@class='visual-item']/*[1]/*[1]//*[@class='highcharts-legend highcharts-no-tooltip']"))
				.isDisplayed();
		if (charts_legend == true) {
			login.Log4j.info("Chart with forecast suggestions legends is displayed");
		} else {
			Assert.fail("Chart with forecast suggestions legends is not displayed");
		}
	}

	@And("^click on cross icon for any legends name$")
	public void click_on_cross_icon_for_any_legends_name() throws Throwable {
		WebElement first_legend_series =  CommonFunctionality.getElementByXpath(login.driver,"(//*[@class='legend-item'])[1]//*[@class='series-edit--title series-edit--title__editable']", 15);
		new Actions(login.driver).pause(200).moveToElement(first_legend_series).build().perform();	
		WebElement first_legend_item = CommonFunctionality.getElementByXpath(login.driver,"(//*[@class='legend-item'])[1]/*[1]", 15);
		//new Actions(login.driver).pause(200).moveToElement(first_legend_item).click().build().perform();
		jse.executeScript("arguments[0].click();", first_legend_item);


	}

	@Then("^Cross clicked legend of the chart in suggestion chart should be disabled$")
	public void cross_clicked_legend_of_the_chart_in_suggestion_chart_should_be_disabled() throws Throwable {
		//mouse hover on watch element for enabling remain chart lines which is not deselected
		WebElement watch_ele = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='movable-modal--body']//*[contains(text(),'Watch')]", 15);
		new Actions(login.driver).pause(200).moveToElement(watch_ele).build().perform();
		CommonFunctionality.wait(500);
		Boolean is_disabled = login.driver
				.findElement(By.xpath("//*[@class='highcharts-markers highcharts-series-0 highcharts-line-series highcharts-tracker']"))
				.getAttribute("visibility").contains("hidden");
		if (is_disabled == true) {
			login.Log4j.info("Cross clicked legend of the chart in suggestion chart is disabled");
		} else {
			Assert.fail("Cross clicked legend of the chart in suggestion chart is not disabled");
		}
	}

	@And("^Click on suggested series of forecast$")
	public void click_on_suggested_series_of_forecast() throws Throwable {
		Thread.sleep(7000);
		WebElement legend_item = CommonFunctionality.getElementByXpath(login.driver,"(//span[@class='series-edit--title series-edit--title__editable'])[1]", 15);
		Exp_seriesName = legend_item.getText();
		System.out.println("Exp_seriesName:"+Exp_seriesName);
		new Actions(login.driver).pause(200).moveToElement(legend_item).click().build().perform();
	}

	@Then("^Should be able to open respective ssp window$")
	public void should_be_able_to_open_respective_ssp_window() throws Throwable {
		String Actual_seriesName = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'movable-modal__draggable movable-modal__active')]//*[@class='series-preview-modal-header--link']",
				15).getText();
		if (Exp_seriesName.equalsIgnoreCase(Actual_seriesName)) {
			login.Log4j.info("SSP window is opened for suggested series of forecast");
		} else {
			Assert.fail("SSP window is not opened for suggested series of forecast");
		}
	}

	@And("^Click on minus sign checkbox$")
	public void click_on_minus_sign_checkbox() throws Throwable {
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='tabs__tabs-box']//*[contains(text(),'Forecast')]", 15)
				.click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'series-with-suggestions__open-suggestions')]/*[1]/*[1]/*[1]", 15).click();
	}

	@Then("^All opened forecast suggestions are collapsed$")
	public void all_opened_forecast_suggestions_are_collapsed() throws Throwable {
		Boolean collapsed = login.driver
				.findElement(By.xpath("//*[@class ='series-with-suggestions series-with-forecasts']")).isDisplayed();
		if (collapsed == true) {
			login.Log4j.info("All opened forecast suggestions are collapsed");
		} else {
			Assert.fail("All opened forecast suggestions are not collapsed");
		}
	}

	@And("^click again on plus sign checkbox$")
	public void click_again_on_plus_sign_checkbox() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class ='series-with-suggestions series-with-forecasts']/*[1]/*[1]/*[1]", 15).click();
	}

	@Then("^Closed forecast suggestions must be expanded$")
	public void closed_forecast_suggestions_must_be_expanded() throws Throwable {
		Boolean expanded = login.driver
				.findElement(By.xpath("//*[contains(@class,'series-with-suggestions__open-suggestions')]"))
				.isDisplayed();
		if (expanded == true) {
			login.Log4j.info("Closed forecast suggestions is expanded");
		} else {
			Assert.fail("Closed forecast suggestions is not expanded");
		}
	}

	@And("^Enter series id's\"([^\"]*)\"$")
	public void enter_series_id_s(String arg1) throws Throwable {
		login.Log4j.info("searching with forecast series" + arg1);
		CommonFunctionality.getElementByProperty(login.driver, "Search", 8).sendKeys(arg1);
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		CommonFunctionality.wait(2000);
	}

	@And("^Open forecast tab in series suggestion window$")
	public void open_forecast_tab_in_series_suggestion_window() throws Throwable {
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='tabs__tabs-box']//*[contains(text(),'Forecast')]", 15)
				.click();
	}

	@And("^Click on Manage All checkbox$")
	public void click_on_Manage_All_checkbox() throws Throwable {
		// before check manage all check box
		// forecast series suggestions list
		beforeCheck_forecastSeriesList = login.driver.findElements(By.xpath(
				"//*[@class='series-list-with-suggestions--wrapper']//div[@class='series-with-suggestions series-with-forecasts series-with-suggestions__open-suggestions']/*[1]/*[1]/*[2]/*[1]"));
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='suggestions-panel--selection-manage']/*[1]", 15).click();
	}

	@Then("^All the available forecast suggestions should get selected$")
	public void all_the_available_forecast_suggestions_should_get_selected() throws Throwable {
		// After check manage all check box
		// Forecast series suggestions list
		afterCheck_forecastSeriesList = login.driver.findElements(By.xpath(
				"//*[@class='series-list-with-suggestions--wrapper']//div[@class='series-with-suggestions series-with-forecasts series-with-suggestions__open-suggestions series-list-item__selected']"));
		if (beforeCheck_forecastSeriesList.size() == afterCheck_forecastSeriesList.size()) {
			login.Log4j.info("All the available forecast suggestions get selected");
		} else {
			Assert.fail("All the available forecast suggestions not get selected");
		}

	}

	@And("^Click again Manage All checkbox to deselect the suggestions$")
	public void click_again_Manage_All_checkbox_to_deselect_the_suggestions() throws Throwable {
		afterCheck_forecastSeriesList = login.driver.findElements(By.xpath(
				"//*[@class='series-list-with-suggestions--wrapper']//div[@class='series-with-suggestions series-with-forecasts series-with-suggestions__open-suggestions series-list-item__selected']"));
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='suggestions-panel--selection-manage']/*[1]", 15).click();
	}

	@Then("^Selected suggestions should get deselected$")
	public void selected_suggestions_should_get_deselected() throws Throwable {
		List<WebElement> beforeUncheck_forecastSeriesList = afterCheck_forecastSeriesList;
		List<WebElement> afterCheck_forecastSeriesList = login.driver
				.findElements(By.xpath("//*[@class='series-list-with-suggestions--wrapper']/*"));
		if (beforeUncheck_forecastSeriesList.size() == afterCheck_forecastSeriesList.size()) {
			for (int i = 0; i < afterCheck_forecastSeriesList.size(); i++) {
				login.Log4j.info(i);
				jse.executeScript("arguments[0].scrollIntoView(true);", afterCheck_forecastSeriesList.get(i));
				if (!afterCheck_forecastSeriesList.get(i).getAttribute("class")
						.contains("series-list-item__selected")) {
					login.Log4j.info("Selected suggestions get deselected");
				} else {
					Assert.fail("Verification failed");
				}
			}
		}
	}

	@And("^Select any particular suggestions by checking its checkbox$")
	public void select_any_particular_suggestions_by_checking_its_checkbox() throws Throwable {
		beforeCheck_forecastSeriesList = login.driver.findElements(By.xpath(
				"//*[@class='series-list-with-suggestions--wrapper']//div[@class='series-with-suggestions series-with-forecasts series-with-suggestions__open-suggestions']/*[1]/*[1]/*[2]/*[1]"));
		for (int i = 0; i < beforeCheck_forecastSeriesList.size();) {
			beforeCheck_forecastSeriesList.get(i).click();
			break;
		}
		CommonFunctionality.wait(500);
		WebElement forecast_tab = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='tabs__tabs-box']//*[contains(text(),'Forecast')]", 15);
		new Actions(login.driver).moveToElement(forecast_tab).pause(200).build().perform();
		
		/*WebElement Visual_info = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='compare-suggestions-visual--info']", 5);
		new Actions(login.driver).moveToElement(Visual_info).pause(200).build().perform();*/
		// Reading frequency for first basic series
		CommonFunctionality.wait(500);
		frequencyTxt_forBasicSeries = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'series-list-item__select')]/*[1]/*[1]//*[@class='series-item-information--additional-info']/*[3]//*[contains(@class,'series-item-information--frequency')]",
				5).getText();
		CommonFunctionality.wait(500);
		// Reading frequency for forecast series
		frequencyTxt_beforeCheckFrequency = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'series-list-item__select')]/*[1]/*[2]//*[@class='suggested-series-list--container']/*[2]//*[contains(@class,'series-item-information--frequency')]",
				5).getText();
	}

	@Then("^Should be able to select particular suggestion for series$")
	public void should_be_able_to_select_particular_suggestion_for_series() throws Throwable {
		List<WebElement> afterCheck_forecastSeriesList = login.driver
				.findElements(By.xpath("//*[@class='series-list-with-suggestions--wrapper']/*"));
		if (afterCheck_forecastSeriesList.size() > 0) {
			for (int i = 0; i < afterCheck_forecastSeriesList.size();) {
				login.Log4j.info(i);
				if (afterCheck_forecastSeriesList.get(i).getAttribute("class").contains("series-list-item__selected")) {
					login.Log4j.info("Selected suggestions get deselected");
				} else {
					Assert.fail("Verification failed");
				}
				break;
			}
		} else {
			Assert.fail("Forecast series suggestions series list is null");
		}

	}

	@And("^Click on Manage All dropdown$")
	public void click_on_Manage_All_dropdown() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='suggestions-panel--mode-manage']/*", 15)
				.click();
	}

	@Then("^Below options should be shown$")
	public void below_options_should_be_shown(List<String> list) throws Throwable {
		CommonFunctionality.wait(500);
		List<WebElement> manageAll_dropdown_options = login.driver
				.findElements(By.xpath("//*[@class='items-wrapper']//*[@class='name-li']"));
		int j = 0;

		for (String arg : list) {
			// login.Log4j.info(arg.trim());
			for (int i = j; i <= manageAll_dropdown_options.size();) {
				// CommonFunctionality.wait(500);
				// login.Log4j.info(generalTab_options.get(j).getText().trim());
				if (manageAll_dropdown_options.get(j).getText().trim().equalsIgnoreCase(arg.trim())) {
					login.Log4j.info(arg + " is displayed");
					j = j + 1;
					break;
				} else {
					Assert.fail("Verification failed");
				}
			}
		}
	}

	@Then("^All suggestions by default should get added with keep status$")
	public void all_suggestions_by_default_should_get_added_with_keep_status() throws Throwable {
		List<WebElement> list_of_suggestions = login.driver.findElements(By.xpath(
				"//*[@class='series-with-suggestions series-with-forecasts series-with-suggestions__open-suggestions']"));
		for (int i = 0; i < list_of_suggestions.size(); i++) {
			int k = i + 1;
			WebElement keep = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='series-with-suggestions series-with-forecasts series-with-suggestions__open-suggestions']["
							+ k
							+ "]//*[@class='series-with-suggestions-mode--button series-with-suggestions-mode--button__keep']",
					4);
			if (!keep.getText().contains("series-with-suggestions-mode--button__inactive")) {
				login.Log4j.info("Suggestion are in Keep status");
			} else {
				Assert.fail("FAIL");
			}
			List<WebElement> listOfButtons = login.driver.findElements(By.xpath(
					"//*[@class='series-with-suggestions series-with-forecasts series-with-suggestions__open-suggestions']["
							+ k + "]//*[@unselectable='on']//button"));
			for (int j = 0; j < listOfButtons.size(); j++) {
				int l = j + 1;
				WebElement Add = login.driver.findElement(By.xpath(
						"//*[@class='series-with-suggestions series-with-forecasts series-with-suggestions__open-suggestions']["
								+ k + "]//*[@unselectable='on'][" + l + "]//button"));
				if (Add.getAttribute("class").contains("button__active")) {
					login.Log4j.info("All suggestions get added with keep status");
				} else {
					Assert.fail("FAIL");
				}
			}
			jse.executeScript("arguments[0].scrollIntoView(true);", list_of_suggestions.get(i));
		}
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Close']", 6).click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='modal-window modal-window__active']//*[contains(text(),'Ok')]", 6).click();
	}

	@Then("^\"([^\"]*)\" icon in a box should be seen for suggestion series of forecast$")
	public void icon_in_a_box_should_be_seen_for_suggestion_series_of_forecast(String arg1) throws Throwable {
		List<WebElement> list_of_forecastSeries = login.driver.findElements(By.xpath(
				"//*[@class='series-list-with-suggestions--wrapper']//*[@class='series-with-suggestions--replacements-list']//*[@class='status-icon status-icon__has-forecast']/*"));
		for (int i = 0; i < list_of_forecastSeries.size(); i++) {
			new Actions(login.driver).moveToElement(list_of_forecastSeries.get(i)).build().perform();
			if (list_of_forecastSeries.get(i).getText().equalsIgnoreCase(arg1)) {
				login.Log4j.info(arg1 + " icon is displayed");
			} else {
				Assert.fail(arg1 + " icon is not displayed");
			}
			jse.executeScript("arguments[0].scrollIntoView(true);", list_of_forecastSeries.get(i));
		}
	}

	@And("^Chart should be displayed for suggestion series by default$")
	public void chart_should_be_displayed_for_suggestion_series_by_default() throws Throwable {
		boolean chart = login.driver.findElement(By.xpath(
				"//*[@class='compare-suggestions-visual compare-suggestions-visual__open-compare-visual']"))
				.isDisplayed();
		if (chart == true) {
			login.Log4j.info("Chart is displayed");
		} else {
			Assert.fail("Chart is not displayed");
		}
	}

	@And("^Click on Chart icon$")
	public void click_on_Chart_icon() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'series-with-suggestions series-with-forecasts')][1]//*[@class='series-with-suggestions-preview--open-visual']",
				4).click();
	}

	@Then("^Chart displayed should be hidden$")
	public void chart_displayed_should_be_hidden() throws Throwable {
		if (login.driver
				.findElements(By.xpath("//*[@class='compare-suggestions-visual']"))
				.size() == 1) {
			login.Log4j.info("Chart doesn't displayed by selecting chart icon");
		} else {
			Assert.fail("FAIL");
		}
	}

	@And("^Check \"([^\"]*)\" function$")
	public void check_function(String arg1) throws Throwable {
		CommonFunctionality.wait(50);
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='series-list-with-suggestions--wrapper']/*[1]//*[@class='splice-function-checker']//*[contains(text(),'"
						+ arg1 + "')]",
				4).click();
	}

	@Then("^\"([^\"]*)\" should be selected \"([^\"]*)\" by default$")
	public void should_be_selected_by_default(String arg1, String arg2) throws Throwable {
		String ExpectedStr = null;
		if (arg1.equalsIgnoreCase("Adj. factor formula:")) {
			ExpectedStr = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='splice-control splice-control__visible']//select/*[1]", 4).getText();
		} else if (arg1.equalsIgnoreCase("Adj. factor period:")) {
			ExpectedStr = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='splice-control splice-control__visible']/*[2]/*[2]//*[@class='input-control--description']",
					4).getText();
		}
		if (ExpectedStr.equalsIgnoreCase(arg2)) {
			login.Log4j.info(arg1 + " is selected as " + arg2 + " by default");
		} else {
			Assert.fail(arg1 + " is not selected " + arg2 + " by default");
		}
		try {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@title='Close']", 4).click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='modal-window modal-window__active']//*[contains(text(),'Ok')]", 4).click();
		}catch(Exception e) {
			
		}
	}

	@And("^Hover on forecast series and click on \"([^\"]*)\" icon$")
	public void hover_on_forecast_series_and_click_on_icon(String arg1) throws Throwable {
		List<WebElement> list_of_forecastSeries = login.driver.findElements(By.xpath(
				"//*[@class='series-list-with-suggestions--wrapper']//*[@class='series-with-suggestions--replacements-list']//li//*[@class='series-item--name']"));
		for (int i = 0; i < list_of_forecastSeries.size();) {
			new Actions(login.driver).moveToElement(list_of_forecastSeries.get(i)).build().perform();
			WebElement series_info_icon = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'series-with-suggestions__open-suggestions')][1]//li[1]//*[@class='series-list-item--info-icon-i']",
					4);
			new Actions(login.driver).moveToElement(series_info_icon).click().build().perform();
			;
			break;
		}
	}

	@And("^Check Preserve as \"([^\"]*)\"$")
	public void check_Preserve_as(String arg1) throws Throwable {
		CommonFunctionality.wait(200);
		if (arg1.equals("names")) {
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='suggestions-panel--settings']/*[2]/*[1]/*[2]", 4)
					.click();
		} else if (arg1.equalsIgnoreCase("frequency")) {
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='suggestions-panel--settings']/*[3]/*[1]/*[2]", 4)
					.click();
		} else if (arg1.equalsIgnoreCase("formula")) {
			boolean checkbox = login.driver
					.findElement(By.xpath("//*[@class='suggestions-panel--settings']/*[2]/*[1]/*[@type='checkbox']"))
					.isSelected();
			if (!checkbox == true) {
				CommonFunctionality
						.getElementByXpath(login.driver, "//*[@class='suggestions-panel--settings']/*[2]/*[1]/*[2]", 4)
						.click();
			}
		}
	}

	@Then("^Selected suggestions by default should get added with keep status$")
	public void selected_suggestions_by_default_should_get_added_with_keep_status() throws Throwable {
		// selecting/checking first series from forecast tab
		Boolean matched = false;
		String expected = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'series-list-item__selected')]//*[@class='suggested-series-item--sub-title']", 4)
				.getText();
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Apply')]", 4).click();
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 4).click();
		CommonFunctionality.wait(1000);
		List<WebElement> listOfSeries = login.driver
				.findElements(By.xpath("//*[@class='series-name-field--series-name']"));
		for (int i = 0; i < listOfSeries.size(); i++) {
			int j = i + 1;
			login.Log4j.info(listOfSeries.get(i).getText());
			if (expected.contains(" " + listOfSeries.get(i).getText())) {

				login.Log4j.info(
						login.driver.findElement(By.xpath("//*[@class='webix_column list-series-name webix_first webix_last']/*[ "
								+ j + "]//*[@class='series-name-wrapper ']/*[2]/*[1]/*[2]/*[1]")).getText());
				if (login.driver
						.findElement(By.xpath("//*[@class='webix_column list-series-name webix_first webix_last']/*[" + j
								+ "]//*[@class='series-name-wrapper ']/*[2]/*[1]/*[2]/*[1]"))
						.getText().equalsIgnoreCase("F")) {
					login.Log4j.info("Forecast series added to the my series tab");
					matched = true;
					break;
				}

			}

		}
		if (matched == false) {
			fail("preserve name is not matched");
		}
	}

	@Then("^Verify preserve frequency in my series tab$")
	public void verify_preserve_frequency_in_my_series_tab() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Apply')]", 4).click();
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 4).click();
		CommonFunctionality.wait(500);
		List<WebElement> listOfSeries = login.driver
				.findElements(By.xpath("//*[@class='series-name-field--series-name']"));
		boolean matched = false;
		for (int i = 0; i < listOfSeries.size(); i++) {
			int j = i + 1;
			CommonFunctionality.wait(200);
			if (login.driver
					.findElement(By.xpath("//*[@class='webix_column list-series-name webix_first webix_last']/*[" + j
							+ "]//*[@class='series-name-wrapper ']/*[2]/*[1]/*[2]/*[1]"))
					.getText().equalsIgnoreCase("F")) {

				String ActualFrequency_forecastSeries = login.driver
						.findElement(By.xpath("//*[@class='webix_column list-series-name webix_first webix_last']/*[" + j
								+ "]//*[@class='series-description-field']//*[@class='additional-info-item frequency']"))
						.getText();
				if (!ActualFrequency_forecastSeries.equals(frequencyTxt_beforeCheckFrequency)
						&& ActualFrequency_forecastSeries.equals(frequencyTxt_forBasicSeries)) {
					login.Log4j.info("Verification is PASS");
					matched = true;
					break;
				}

			}

		}
		if (matched == false) {
			fail("preserve frequency is not matched for forecast series");
		}
	}

	@Then("^Selected suggestion should get replaced with current series$")
	public void selected_suggestion_should_get_replaced_with_current_series() throws Throwable {
		Boolean matched = false;
		// selecting/checking first series from forecast tab
		String expected = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'series-list-item__selected')]//*[@class='suggested-series-item--sub-title']", 4)
				.getText();
		if (!CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'series-list-item__selected')]//*[@class='series-with-suggestions-mode series-with-forecasts-mode']/*[2]",
				4).getAttribute("class").contains("series-with-suggestions-mode--button__inactive")) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Apply')]", 4).click();
			CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 4).click();
			List<WebElement> listOfSeries = login.driver
					.findElements(By.xpath("//*[@class='series-name-field--series-name']"));
			for (int i = 0; i < listOfSeries.size(); i++) {
				int j = i + 1;
				login.Log4j.info(listOfSeries.get(i).getText());
				if (expected.contains(listOfSeries.get(i).getText())) {

					login.Log4j
							.info(login.driver
									.findElement(By.xpath("//*[@class='webix_column list-series-name webix_first webix_last']/*[ "
											+ j + "]//*[@class='series-name-wrapper ']/*[2]/*[1]/*[2]/*[1]"))
									.getText());
					if (login.driver
							.findElement(By.xpath("//*[@class='webix_column list-series-name webix_first webix_last']/*[" + j
									+ "]//*[@class='series-name-wrapper ']/*[2]/*[1]/*[2]/*[1]"))
							.getText().equalsIgnoreCase("F")) {
						login.Log4j.info("Selected suggestion is replaced with current series");
						matched = true;
						break;
					}

				}

			}
			if (matched == false) {
				fail("preserve name is not matched");
			}
		} else {
			fail("staus is not selected as Replace");
		}
	}

	@Then("^Verify preserve frequency for forecast series with replace the current series in my series tab$")
	public void verify_preserve_frequency_for_forecast_series_with_replace_the_current_series_in_my_series_tab()
			throws Throwable {
		Boolean matched = false;
		// selecting/checking forecast series from forecast tab
		String expected = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'series-list-item__selected')]//*[@class='suggested-series-item--sub-title']", 4)
				.getText();
		if (!CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'series-list-item__selected')]//*[@class='series-with-suggestions-mode series-with-forecasts-mode']/*[2]",
				4).getAttribute("class").contains("series-with-suggestions-mode--button__inactive")) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Apply')]", 4).click();
			CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 4).click();
			CommonFunctionality.wait(500);
			List<WebElement> listOfSeries = login.driver
					.findElements(By.xpath("//*[@class='series-name-field--series-name']"));
			for (int i = 0; i < listOfSeries.size(); i++) {
				int j = i + 1;
				login.Log4j.info(listOfSeries.get(i).getText());
				if (expected.contains(listOfSeries.get(i).getText())) {

					login.Log4j
							.info(login.driver
									.findElement(By.xpath("//*[@class='webix_column list-series-name webix_first webix_last']/*[ "
											+ j + "]//*[@class='series-name-wrapper ']/*[2]/*[1]/*[2]/*[1]"))
									.getText());
					if (login.driver
							.findElement(By.xpath("//*[@class='webix_column list-series-name webix_first webix_last']/*[" + j
									+ "]//*[@class='series-name-wrapper ']/*[2]/*[1]/*[2]/*[1]"))
							.getText().equalsIgnoreCase("F")) {
						String ActualFrequency_forecastSeries = login.driver
								.findElement(By.xpath("//*[@class='webix_column list-series-name webix_first webix_last']/*[" + j
										+ "]//*[@class='series-description-field']//*[@class='additional-info-item frequency']"))
								.getText();
						if (!ActualFrequency_forecastSeries.equals(frequencyTxt_beforeCheckFrequency)
								&& ActualFrequency_forecastSeries.equals(frequencyTxt_forBasicSeries)) {

							login.Log4j.info("Selected suggestion is replaced with current series");
							matched = true;
							break;
						}
					}

				}

			}
			if (matched == false) {
				fail("preserve frequency is not matched for forecast series");
			}
		} else {
			fail("staus is not selected as Replace");
		}
	}

	@And("^Apply any function to any of the added series$")
	public void apply_any_function_to_any_of_the_added_series() throws Throwable {
		// Select the first series
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='webix_column list-series-name webix_first webix_last']/*[1]//*[@class='series-name-wrapper ']/*[1]", 4)
				.click();

		try_to_apply_any_of_the_function_through_function_toolbar();

	}

	@Then("^Verify preserve formula with add forecasts in my series tab$")
	public void verify_preserve_formula_with_add_forecasts_in_my_series_tab() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Apply')]", 4).click();
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 4).click();
		CommonFunctionality.wait(200);
		List<WebElement> listOfSeries = login.driver
				.findElements(By.xpath("//*[@class='series-name-field--series-name']"));
		boolean matched = false;
		for (int i = 0; i < listOfSeries.size(); i++) {
			int j = i + 1;
			CommonFunctionality.wait(200);
			if (login.driver
					.findElement(By.xpath("//*[@class='webix_column list-series-name webix_first webix_last']/*[" + j
							+ "]//*[@class='series-name-wrapper ']/*[2]/*[1]/*[2]/*[1]"))
					.getText().equalsIgnoreCase("F")) {

				String ActualFunction_forecastSeries = login.driver
						.findElement(By.xpath("//*[@class='webix_column list-series-name webix_first webix_last']/*[" + j
								+ "]//*[@class='series-functions-title']"))
						.getText();
				if (ActualFunction_forecastSeries.contains(Applied_function)) {
					login.Log4j.info("Verification is PASS");
					matched = true;
					break;
				}

			}

		}
		if (matched == false) {
			fail("preserve formula is not matched for forecast series");
		}
	}

	@Then("^Verify preserve formula with replace the current series in my series tab$")
	public void verify_preserve_formula_with_replace_the_current_series_in_my_series_tab() throws Throwable {
		Boolean matched = false;
		// selecting/checking forecast series from forecast tab
		String expected = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'series-list-item__selected')]//*[@class='suggested-series-item--sub-title']", 4)
				.getText();
		if (!CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'series-list-item__selected')]//*[@class='series-with-suggestions-mode series-with-forecasts-mode']/*[2]",
				4).getAttribute("class").contains("series-with-suggestions-mode--button__inactive")) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Apply')]", 4).click();
			CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 4).click();
			List<WebElement> listOfSeries = login.driver
					.findElements(By.xpath("//*[@class='series-name-field--series-name']"));
			for (int i = 0; i < listOfSeries.size(); i++) {
				int j = i + 1;
				login.Log4j.info(listOfSeries.get(i).getText());
				if (expected.contains(listOfSeries.get(i).getText())) {

					if (login.driver
							.findElement(By.xpath("//*[@class='webix_column list-series-name webix_first webix_last']/*[" + j
									+ "]//*[@class='series-name-wrapper ']/*[2]/*[1]/*[2]/*[1]"))
							.getText().equalsIgnoreCase("F")) {
						String ActualFunction_forecastSeries = login.driver
								.findElement(By.xpath("//*[@class='webix_column list-series-name webix_first webix_last']/*[" + j
										+ "]//*[@class='series-functions-title']"))
								.getText();
						if (ActualFunction_forecastSeries.contains(Applied_function)) {
							login.Log4j.info("Verification is PASS");
							matched = true;
							break;
						}
					}

				}

			}
			if (matched == false) {
				fail("preserve formula is not matched for forecast series");
			}
		} else {
			fail("staus is not selected as Replace");
		}
	}

	@Then("^Series suggestion window should get closed$")
	public void series_suggestion_window_should_get_closed() throws Throwable {
		if (login.driver.findElements(By.xpath("//*[@class='tabs__tab-item'][contains(text(),'Forecast')]"))
				.size() == 0) {
			login.Log4j.info("Series suggestion popup is closed");
			try {
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'movable-modal__active')]//*[@title='Close']", 4).click();
				CommonFunctionality
						.getElementByXpath(login.driver,
								"//*[@class='modal-window modal-window__active']//*[contains(text(),'Ok')]", 15)
						.click();
			} catch (Exception e) {
				//
			}
		} else {
			fail("Series popup is not closed");
		}

	}

	@Then("^Apply button should be disabled$")
	public void apply_button_should_be_disabled() throws Throwable {
		if (login.driver.findElement(By.xpath("//*[@class='suggestions-apply-button']/*")).getAttribute("class")
				.contains("disabled")) {
			login.Log4j.info("Apply button is disabled by default");
		} else {
			fail("Apply button is not disabled");
		}
	}

	@Then("^All suggestions should get replaced with current series$")
	public void all_suggestions_should_get_replaced_with_current_series() throws Throwable {
		List<String> replacementSeries = new ArrayList<>();
		CommonFunctionality.wait(500);
		List<WebElement> SeriesList = login.driver.findElements(By.xpath("//*[@class='suggested-series-item--title']"));
		for (int i = 0; i < SeriesList.size(); i++) {
			replacementSeries.add(SeriesList.get(i).getText());
		}
		List<WebElement> status_replace = login.driver
				.findElements(By.xpath("//*[@class='series-with-suggestions-mode series-with-forecasts-mode']/*[2]"));
		for (int i = 0; i < status_replace.size(); i++) {
			int j = i + 1;

			if (!CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[@class='series-list-with-suggestions--wrapper']/*[" + j
									+ "]//*[@class='series-with-suggestions-mode series-with-forecasts-mode']/*[2]",
							4)
					.getAttribute("class").contains("series-with-suggestions-mode--button__inactive")) {
				login.Log4j.info("status is replace");

			}
		}
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Apply')]", 4).click();
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 4).click();
		List<WebElement> listOfSeries = login.driver
				.findElements(By.xpath("//*[@class='series-name-field--series-name']"));
		for (int i = 0; i < listOfSeries.size(); i++) {
			int j = i + 1;
			login.Log4j.info(listOfSeries.get(i).getText());
			for (String expected : replacementSeries) {
				if (expected.contains(listOfSeries.get(i).getText())) {

					login.Log4j
							.info(login.driver
									.findElement(By.xpath("//*[@class='webix_column list-series-name webix_first webix_last']/*[ "
											+ j + "]//*[@class='series-name-wrapper ']/*[2]/*[1]/*[2]/*[1]"))
									.getText());
					if (login.driver
							.findElement(By.xpath("//*[@class='webix_column list-series-name webix_first webix_last']/*[" + j
									+ "]//*[@class='series-name-wrapper ']/*[2]/*[1]/*[2]/*[1]"))
							.getText().equalsIgnoreCase("F")) {
						login.Log4j.info(i + " suggestion is replaced with current series");

					}

				}

			}

		}

	}

	@And("^Select forecast suggestion series$")
	public void select_forecast_suggestion_series() throws Throwable {
		Boolean matched = false;

		List<WebElement> listOfSeries = login.driver
				.findElements(By.xpath("//*[@class='series-name-field--series-name']"));
		for (int i = 0; i < listOfSeries.size(); i++) {
			int j = i + 1;

			if (login.driver
					.findElement(By.xpath("//*[@class='webix_column list-series-name webix_first webix_last']/*[" + j
							+ "]//*[@class='series-name-wrapper ']/*[2]/*[1]/*[2]/*[1]"))
					.getText().equalsIgnoreCase("F")) {
				new Actions(login.driver).moveToElement(listOfSeries.get(i)).pause(500).contextClick().perform();
				matched = true;
				break;
			}

		}

		if (matched == false) {
			fail("Forecast series are not available");
		}

	}

	@And("^Create TableVisual$")
	public void create_TableVisual() throws Throwable {
		
		CommonFunctionality.getElementByProperty(login.driver, "Dropdown_AddChart", 4).click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[contains(@class,'icon--table-vertical_large')]", 8).click();
		
	}

	@And("^Select forecast suggestion series from my series pane$")
	public void select_forecast_suggestion_series_from_my_series_pane() throws Throwable {
		Boolean matched = false;

		List<WebElement> listOfSeries = login.driver
				.findElements(By.xpath("//*[@class='series-name-field--series-name']"));
		for (int i = 0; i < listOfSeries.size(); i++) {
			int j = i + 1;

			if (login.driver
					.findElement(By.xpath("//*[@class='webix_column list-series-name webix_first webix_last']/*[" + j
							+ "]//*[@class='series-name-wrapper ']/*[2]/*[1]/*[2]/*[1]"))
					.getText().equalsIgnoreCase("F")) {
				CommonFunctionality
						.getElementByXpath(login.driver, "//*[@class='webix_column list-series-name webix_first webix_last']/*[" + j
								+ "]//*[@class='series-name-wrapper ']/*[1]", 4)
						.click();
				matched = true;
				break;
			}

		}

		if (matched == false) {
			fail("Forecast series are not available");
		}
	}

	@And("^try to apply any of the function through function wizard$")
	public void try_to_apply_any_of_the_function_through_function_wizard() throws Throwable {
		Applied_function = "ROUND()";
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='function-editor-window--icon']", 4).click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='function-editor-window']//*[@class='current-function-input']", 4).click();
		// Applying Round() function
		CommonFunctionality.getElementByXpath(login.driver, "//li[contains(text(),'ROUND')]", 4).click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='function-wizard--footer-buttons']//*[contains(text(),'Apply')]", 4).click();
	}

	@Then("^Function should be able to apply$")
	public void function_should_be_able_to_apply() throws Throwable {
		CommonFunctionality.wait(1000);
		WebElement Applied_function_series;
		try {
			Applied_function_series = login.driver.findElement(By.xpath(
					"//*[@class='webix_column list-series-name webix_first webix_last']//*[@class='webix_cell webix_row_select new-series-item']//*[@class='series-functions-title']"));
		} catch (Exception e) {
			Applied_function_series = login.driver.findElement(By.xpath(
					"//*[@class='webix_column list-series-name webix_first webix_last']//*[@class='webix_cell webix_row_select']/*[1]/*[2]/*[1]/*[1]"));
		}
	/*	new Actions(login.driver).moveToElement(Applied_function_series).build().perform();
		Thread.sleep(300);
		WebElement tooltip = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text")));
		String tooltip_text = tooltip.getText();*/
		
		// login.Log4j.info("Title information is \n" + text);
		// Until the element is not visible keep scrolling
		// CommonFunctionality.jse.executeScript("arguments[0].scrollIntoView(true);",
		// element);
		
		if (Applied_function_series.getText().contains(Applied_function)) {
			login.Log4j.info("Function is applied for forecast series");
		} else {

			fail("Function is not applied for forcast series");
		}
				
	}

	@And("^try to apply any of the function through function toolbar$")
	public void try_to_apply_any_of_the_function_through_function_toolbar() throws Throwable {
		Applied_function = "ROUND()";
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='current-function-input']", 4).click();
		// Applying Round() function
		CommonFunctionality.getElementByXpath(login.driver, "//li[contains(text(),'ROUND')]", 4).click();
//		CommonFunctionality.wait(500);
//		CommonFunctionality
//				.getElementByXpath(login.driver, "//*[contains(@class,'series-functions-panel--icon__apply')]", 4).click();

	}

	@And("^Right click on visual$")
	public void right_click_on_visual() throws Throwable {
		CommonFunctionality.wait(1500);
		WebElement ele = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='title']", 4);
		new Actions(login.driver).contextClick(ele).pause(200).perform();
	}

	@And("^Apply with any function$")
	public void apply_with_any_function() throws Throwable {
		Applied_function = "ROUND()";
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='function-editor-window']//*[@class='current-function-input']", 4).click();
		// Applying Round() function
		CommonFunctionality.getElementByXpath(login.driver, "//li[contains(text(),'ROUND')]", 4).click();
		try {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='function-wizard--footer-buttons']//*[contains(text(),'Apply')]", 4).click();
		}catch(Exception e){
			
		}
	}

	@Then("^Function should be applied to the visual$")
	public void function_should_be_applied_to_the_visual() throws Throwable {
		CommonFunctionality.wait(500);
		String Actual = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-edit--title']", 4)
				.getText();
		if (Actual.contains(Applied_function)) {
			login.Log4j.info("Function is applied");
		} else {

			fail("Function is not applied");
		}
	}

	@Then("^Series legends should disable when mouse hover/clicking on the cross mark on the series$")
	public void series_legends_should_disable_when_mouse_hover_clicking_on_the_cross_mark_on_the_series()
			throws Throwable {
		CommonFunctionality.wait(1000);
		// mouse hover on legend marker
		WebElement legend_item1 = CommonFunctionality.getElementByXpath(login.driver,
				"(//*[@class='legend-item']/*[1])[1]", 4);
		new Actions(login.driver).pause(200).moveToElement(legend_item1).build().perform();
		if (login.driver.findElements(By.xpath(
				"//*[@class='highcharts-series highcharts-series-1 highcharts-line-series highcharts-series-inactive']"))
				.size() == 1) {
			
				login.Log4j.info("Corresponding series is enabled and other series is disabled on the chart");
			
		} else {
			fail("Verification failed");
		}
		// clicking on cross icon of legend marker
		legend_item1.click();
//		WebElement Visual_info = CommonFunctionality.getElementByXpath(login.driver,
//				"//*[@class='compare-suggestions-visual--info']", 5);
//		new Actions(login.driver).moveToElement(Visual_info).pause(200).build().perform();
		if (login.driver.findElement(By.xpath("(//*[@class='highcharts-legend highcharts-no-tooltip'])[2]/*[1]/*[1]/*[1]"))
				.getAttribute("class").contains("highcharts-legend-item-hidden")) {
			login.Log4j.info("Legend item is disabled");
		} else {
			fail("Legend item is not disabled");
		}
	}

}
