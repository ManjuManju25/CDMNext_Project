package CDMNext.StepDefinations;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import CDMNext.util.CommonFunctionality;
import CDMNext.util.Hooks;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class SprintCases {
	String[] send = new String[] { "Shravas", "template1", "template2", "template3" };
	String minimize;
	String view1;
	static WebDriverWait wait = new WebDriverWait(login.driver, 1000);

	@Then("^Search without any filters link should be removed$")
	public void search_without_any_filters_link_should_be_removed() throws Throwable {
		Thread.sleep(2000);

		if (login.driver.findElements(By.xpath("//*[contains(text(),'Search without any filters')]")).size() != 1) {
			login.Log4j.info("Search without any filters link is removed");
		} else {
			Assert.fail("Verification failed");
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Create India map with indian cities supporting subnational attribute$")
	public void create_India_map_with_indian_cities_supporting_subnational_attribute() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Databases_Tab", 20).click();
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Matches only')]", 20).click();
		// Expand 1st db till series level
		CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='database-node tree-node'])[1]/*[1]", 200)
				.click();
		CommonFunctionality.wait(500);
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='database-node tree-node full-expanded open last-open-node']/*[3]/following::*[1]/*[1]/*[1]", 300)
				.click();
		CommonFunctionality.wait(500);
		CommonFunctionality
				.getElementByProperty(login.driver, "Expand3rdLevel", 300)
				.click();
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByProperty(login.driver,
				"Expand4thLevel", 300).click();
		CommonFunctionality.wait(500);
		CommonFunctionality
				.getElementByProperty(login.driver, "Expand5thLevel", 300)
				.click();
		WebElement sname = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-item--name']", 100);
		new Actions(login.driver).pause(500).contextClick(sname).perform();
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'View on India Map')]", 20).click();

	}

	@Then("^Andhra Pradesh subnational city should appear on India map$")
	public void andhra_Pradesh_subnational_city_should_appear_on_India_map() throws Throwable {
		Thread.sleep(5000);
		String subnational_attribute = null;
		try {
			subnational_attribute = login.driver
					.findElement(By.xpath("//*[contains(@class,'highcharts-map-series highcharts-color-0 highcharts-tracker')]/*[1]//*[@class='highcharts-text-outline']")).getText();
			login.Log4j.info("Subnational attribute is " + subnational_attribute);
			if (subnational_attribute.equals(SearchTest.currentKeyword)) {
				CommonFunctionality.Views_list();
				login.Log4j.info("Subnational attribute is plotted on an indian map");
			}
		} catch (Exception e) {
			CommonFunctionality.Views_list();
			Assert.fail("Subnational attribute is not plotted on an indian map");
		}

		// List<WebElement> list_of_states = login.driver
		// .findElements(By.xpath("//div[@class='visual-item']/div/*/*[10]/*//*/*"));
		/*
		 * if (list_of_states.size() > 0) { for (int i = 0; i < list_of_states.size();
		 * i++) { // int j = i + 1; CommonFunctionality.wait(1000); String state =
		 * list_of_states.get(i).getText(); login.Log4j.info(state); if
		 * (state.equals("Andhra Pradesh")) { // Thread.sleep(2000); WebElement ele =
		 * list_of_states.get(i);
		 * CommonFunctionality.action.moveToElement(ele).pause(2000).build().perform();
		 * String tooltip = login.driver.findElement(By.xpath(
		 * "//div[@class='highcharts-label highcharts-tooltip highcharts-color-0']//span//div[@class='table-tooltip']"
		 * )) .getText(); // login.Log4j.info(tooltip); String tooltipArr[] =
		 * tooltip.split("\n"); for (int m = 0; m < tooltipArr.length; m++) { int n = m
		 * + 1; // login.Log4j.info(tooltipArr);
		 * 
		 * if (tooltipArr[n].contains("Subnational") == true) { String[] arr =
		 * tooltipArr[n].split(":"); String subnational = arr[1].trim();
		 * login.Log4j.info(subnational); if
		 * (subnational.equals(SearchTest.currentKeyword) == true) {
		 * login.Log4j.info("PASS"); break; }
		 * 
		 * } } break; } } } else { CommonFunctionality.Views_list();
		 * Assert.fail("Subnational attribute is not plotted on an indian map"); }
		 */

	}

	@And("^Open ssp window$")
	public void open_ssp_window() throws Throwable {
		login.Log4j.info("Clicking on  Series tab ");
		Thread.sleep(5000);
		CommonFunctionality.getElementByProperty(login.driver, "Series", 20).click();
		CommonFunctionality.wait(7000);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-item--name']", 20).click();
		Thread.sleep(2000);
		minimize = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Minimize']")))
				.getAttribute("title");
	}

	@And("^Minimize ssp window$")
	public void minimize_ssp_window() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Minimize']", 20).click();
	}

	@Then("^The modal window should get collapsed into row$")
	public void the_modal_window_should_get_collapsed_into_row() throws Throwable {
		CommonFunctionality.wait(1000);
		String maximize = CommonFunctionality.getElementByXpath(login.driver,"//*[@title='Maximize']",8)
				.getAttribute("title");
		if (minimize.equals(maximize) != true) {
			login.Log4j.info("SSP window is minimized");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//*[contains(@class,'movable-modal__active movable-modal__collapsed')]//*[@title='Close']")))
					.click();

		} else {
			Assert.fail("Verifivation failed");
		}

	}

	@And("^Select \"([^\"]*)\" filter$")
	public void select_filter(String arg1) throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Databases_Tab", 20).click();
		CommonFunctionality.wait(10000);
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]",8)
				.click();
	}

	@Then("^For search results less than (\\d+), the system will display all the tables and on the first table – down to series level$")
	public void for_search_results_less_than_the_system_will_display_all_the_tables_and_on_the_first_table_down_to_series_level(
			int arg1) throws Throwable {
		Thread.sleep(5000);
		List<WebElement> seriesLevel_ULele = login.driver
				.findElements(By.xpath("//*[contains(@class,'series-search-list-item')]"));
		login.Log4j.info("size : " + seriesLevel_ULele.size());
		if (seriesLevel_ULele.size() == 1 || seriesLevel_ULele.size() > 1) {
			login.Log4j.info("Series level is displayed for less than " + arg1 + " search results");
		} else {
			Assert.fail("Verification failed");
		}
	}

	@Then("^For search results less than (\\d+), the system will expand all the levels$")
	public void for_search_results_less_than_the_system_will_expand_all_the_levels(int arg1) throws Throwable {
		Thread.sleep(5000);
		List<WebElement> seriesLevel = login.driver
				.findElements(By.xpath("//*[@class='database-node tree-node open full-expanded']"));
		login.Log4j.info("size : " + seriesLevel.size());
		for (int i = 0; i < seriesLevel.size(); i++) {
			Thread.sleep(1000);
			WebElement SeriesLevel = seriesLevel.get(i);
			// CommonFunctionality.action.pause(500).moveToElement(SeriesLevel).build().perform();
			if (SeriesLevel.isDisplayed()) {
				login.Log4j.info("series are expanded till series level for search results than " + arg1);
			} else {
				Assert.fail("FAIL");
			}
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Hover the mouse over series in Search panel or in My series tab$")
	public void hover_the_mouse_over_series_in_Search_panel_or_in_My_series_tab() throws Throwable {
		login.Log4j.info("Clicking on  Series tab ");
		CommonFunctionality.getElementByProperty(login.driver, "Series", 20).click();
		WebElement seriesName = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-item--name']",
				20);
		CommonFunctionality.action.pause(1000).moveToElement(seriesName).build().perform();
	}

	@SuppressWarnings("deprecation")
	@Then("^Series info tooltip should only be displayed when mouse hovered on the series name and not on the series row$")
	public void series_info_tooltip_should_only_be_displayed_when_mouse_hovered_on_the_series_name_and_not_on_the_series_row()
			throws Throwable {
		Thread.sleep(1000);
		WebElement tooltip = login.driver.findElement(By.xpath("//*[@class='tooltip tooltip__visible']//table"));
		String toolTip_txt = tooltip.getText();
		if (tooltip.isDisplayed() == true) {
			login.Log4j.info("tooltip is displayed for series name");
		}
		Thread.sleep(2000);
		WebElement showDatabase = login.driver.findElement(By.xpath("//*[@class='show-in-tree-icon menu-icon']"));
		CommonFunctionality.action.pause(1000).moveToElement(showDatabase).build().perform();
		String showDb = showDatabase.getAttribute("title");
		login.Log4j.info(showDb);
		if (!toolTip_txt.equals(showDb)) {
			login.Log4j.info("tooltip is not displayed for " + showDb);
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Create visual$")
	public void create_visual() throws Throwable {
		login.Log4j.info("Clicking on  Series tab ");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Series")))).click();
		Thread.sleep(2000);
		List<WebElement> ListOfSeries = login.driver.findElements(By.xpath("//*[@class='series-representation--list']/*//*[@class='series-item--name']"));
		for (int i = 0; i < ListOfSeries.size(); i++) {
			int j = i + 1;
			Thread.sleep(1000);
			WebElement seriesName = ListOfSeries.get(i);
			CommonFunctionality.action.pause(1000).moveToElement(seriesName).build().perform();
			CommonFunctionality.getElementByXpath(login.driver,"(//*[@class='series-representation--list']//*[@class='view-chart-icon menu-icon'])[" + j + "]",6).click();
		}
	}

	@Then("^\"([^\"]*)\" should be displayed in the summary popup$")
	public void should_be_displayed_in_the_summary_popup(String arg1) throws Throwable {
		Thread.sleep(2000);
		login.driver.navigate().refresh();
		Hooks.Handle_BrowserNotification_popup();
		CommonFunctionality.ContinueSameInsight();
		WebElement eleChanges = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'" + arg1 + "')]", 30);
		if (eleChanges.isDisplayed()) {
			login.Log4j.info(arg1 + " is displayed");
		}
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//*[@title='Close']")).click();
		if (arg1.equals("Replacements")) {
			CommonFunctionality.Views_list();
		}
	}

	@And("^Right click on the View and select Copy View$")
	public void right_click_on_the_View_and_select_Copy_View() throws Throwable {
		CommonFunctionality.wait(5000);
		WebElement eleView1 = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'insight-page-view-tab') and contains(text(),'View')]", 30);
		view1 = eleView1.getText();
		new Actions(login.driver).contextClick(eleView1).build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Copy view')]", 20).click();

	}

	@And("^Paste in the View section$")
	public void paste_in_the_View_section() throws Throwable {
		Thread.sleep(2000);
		WebElement eleView1 = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'insight-page-view-tab') and contains(text(),'View')]", 30);
		new Actions(login.driver).contextClick(eleView1).build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Paste view(s)')]", 20).click();
		// CommonFunctionality.ContinueSameInsight();
	}

	@And("^Paste in the View section for new insight$")
	public void paste_in_the_View_section_for_new_insight() throws Throwable {
		// paste_in_the_View_section();
		Thread.sleep(2000);
		WebElement eleView1 = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'insight-page-view-tab') and contains(text(),'View')]", 30);
		new Actions(login.driver).contextClick(eleView1).build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Paste view(s)')]", 20).click();
	}

	@And("^Create new insight$")
	public void create_new_insight() throws Throwable {
		CommonFunctionality.Create_New_Insight();
	}

	@Then("^The copied View and its contents should be pasted in the same insight$")
	public void the_copied_View_and_its_contents_should_be_pasted_in_the_same_insight() throws Throwable {
		CopyView_Sameinsight();
		//CommonFunctionality.ContinueSameInsight();
		//CommonFunctionality.Views_list();
	}

	@Then("^The copied View and its contents should be pasted in other/new insight$")
	public void the_copied_View_and_its_contents_should_be_pasted_in_other_new_insight() throws Throwable {
		// CommonFunctionality.ReplacementPopUpClose();
		CopyView_Sameinsight();
		// CommonFunctionality.Views_list();
		DeleteInsight();
	}

	@SuppressWarnings("deprecation")
	@And("^Right click on the View and select \"([^\"]*)\"$")
	public void right_click_on_the_View_and_select(String arg1) throws Throwable {
		Thread.sleep(2000);
		WebElement Active_ele = login.driver
				.findElement(By.xpath("//*[@class='insight-page-view-tab--link insight-page-view-tab--link__active']"));
		CommonFunctionality.action.pause(1000).contextClick(Active_ele).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + arg1 + "')]")))
				.click();

	}

	@Then("^All Views and contents from the insight should be pasted in the same insight$")
	public void all_Views_and_contents_from_the_insight_should_be_pasted_in_the_same_insight() throws Throwable {
		// CommonFunctionality.ReplacementPopUpClose();
		CopyView_Newinsight();
		CommonFunctionality.ContinueSameInsight();
		CommonFunctionality.Delete_AllViews();
	}

	@Then("^All Views and contents from the insight should be pasted in the new/other insight$")
	public void all_Views_and_contents_from_the_insight_should_be_pasted_in_the_new_other_insight() throws Throwable {
		CopyView_Newinsight();
		try {
			// delete insight
			CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Open File menu']", 20).click();
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Delete')]", 20).click();
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Delete forever')]", 20).click();
			CommonFunctionality.wait(20000);
			// CommonFunctionality.ContinueSameInsight();
			// CommonFunctionality.wait(5000);
			CommonFunctionality.Delete_AllViews();

		} catch (Exception e) {

		}
	}

	@And("^User enters series_id \"([^\"]*)\"$")
	public void user_enters_series_id(String arg1) throws Throwable {
//		login.driver.navigate().refresh();
		//login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).clear();
		login.Log4j.info("searching with " + arg1);
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys(arg1);
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		
	}

	@And("^Create a map visual$")
	public void create_a_map_visual() throws Throwable {
		login.Log4j.info("Clicking on  Series tab ");
		Thread.sleep(10000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		Thread.sleep(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-list-item--checkbox-wrapper']",4)
				.click();
		CommonFunctionality.getElementByXpath(login.driver,"//*[@class='insight-page-menu-views-container--add']",4).click();
		CommonFunctionality.getElementByXpath(login.driver,"//*[@data-action='world']",4).click();
	}

	@And("^Click on Edit Map$")
	public void click_on_Edit_Map() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Edit Map')]"))).click();
	}

	@And("^Select Gradient$")
	public void select_Gradient() throws Throwable {
		CommonFunctionality.wait(4000);
		WebElement Gradient = login.driver.findElement(By.xpath("//*[@class='color-axis-type-select']//*[contains(text(),'Gradient')]"));
		Gradient.click();

	}

	@Then("^Default value should be \"([^\"]*)\" and the steps range should be from \"([^\"]*)\"$")
	public void default_value_should_be_and_the_steps_range_should_be_from(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement ele = login.driver.findElement(By.xpath("//*[@name='steps']//*[contains(text(),'0')]"));
		String GradientDefaultValue = ele.getText();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='gradient-axis--steps-select']", 20).click();
		List<WebElement> range_of_steps = login.driver.findElements(By.xpath("//*[@name='steps']//*"));
		login.Log4j.info(GradientDefaultValue);
		login.Log4j.info(arg1);
		if (GradientDefaultValue.equals(arg1)) {
			login.Log4j.info("Gradient default value is :" + GradientDefaultValue);
		} else {
			Assert.fail("Verification failed");
		}
		for (int i = 0; i < range_of_steps.size(); i++) {
			String str = range_of_steps.get(i).getAttribute("value");
			if (arg2.contains(str) == true) {
				login.Log4j.info(str);
			} else {
				Assert.fail("FAIL");
			}
		}
	}

	@Then("^Select Solid color$")
	public void select_Solid_color() throws Throwable {
		Thread.sleep(2000);
		WebElement SolidColor = login.driver.findElement(By.xpath("//*[contains(text(),'Solid color')]"));
		SolidColor.click();
	}

	@Then("^Default value should be \"([^\"]*)\" and the colors range should be from \"([^\"]*)\"$")
	public void default_value_should_be_and_the_colors_range_should_be_from(String arg1, String arg2) throws Throwable {
		String SolidColorDefaultValue = null;
		CommonFunctionality.wait(2000);
		try {
			WebElement ele = login.driver.findElement(By.xpath("//select[@class='solid-colors--color-stops-select']"));
			SolidColorDefaultValue = ele.getAttribute("value");
		} catch (Exception e) {
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//*[@title='Close']")).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
			CommonFunctionality.Views_list();
			Assert.fail("Color steps not displayed for solid color");
		}
		List<WebElement> range_of_colors = login.driver
				.findElements(By.xpath("//select[@class='solid-colors--color-stops-select']//*"));
		// login.Log4j.info(SolidColorDefaultValue);
		// login.Log4j.info(arg1);
		if (SolidColorDefaultValue.equals(arg1)) {
			login.Log4j.info("Gradient default value is :" + SolidColorDefaultValue);
		} else {
			Assert.fail("Verification failed");
		}
		for (int i = 0; i < range_of_colors.size(); i++) {
			String str = range_of_colors.get(i).getAttribute("value");
			if (arg2.contains(str) == true) {
				login.Log4j.info(str);
			} else {
				Assert.fail("FAIL");
			}
		}
		try {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//*[@title='Close']")).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
		}catch(Exception e) {
			
		}
		//CommonFunctionality.Views_list();
	}

	@Then("^Clicking on the color box will open the color picker$")
	public void clicking_on_the_color_box_will_open_the_color_picker() throws Throwable {
		Thread.sleep(2000);
		try {
			login.driver.findElement(By.xpath("//*[@class='solid-colors--container']//*[@class='predefined-color'][1]"))
					.click();
		} catch (Exception e) {
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//*[@title='Close']")).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
			CommonFunctionality.Views_list();
			Assert.fail("Color picker is not displayed");
		}
		WebElement color_picker = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[contains(@class,'index-module_dropdown')]")));
		if (color_picker.isDisplayed() == true) {
			login.Log4j.info("Color picker is displayed");
		} else {
			// Thread.sleep(1000);
			// login.driver.findElement(By.xpath("//*[@title='Close']")).click();
			// Thread.sleep(1000);
			// login.driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
			// CommonFunctionality.Views_list();
			Assert.fail("Color picker is not displayed");
		}
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//*[@title='Close']")).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
		CommonFunctionality.Views_list();
	}

	@Then("^The options will look as steps and the steps values could be customized only when min and max values are set to fixed values$")
	public void the_options_will_look_as_steps_and_the_steps_values_could_be_customized_only_when_min_and_max_values_are_set_to_fixed_values()
			throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//*[@name='steps']")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//*[@name='steps']//*[@value='3']")).click();
		String customized_value = login.driver.findElement(By.xpath("//*[@name='steps']//*[@value='3']")).getText();
		List<WebElement> list_of_steps = login.driver.findElements(By.xpath("//*[@class='gradient-line']"));
		login.Log4j.info(customized_value);
		login.Log4j.info(list_of_steps.size());
		int value = Integer.parseInt(customized_value);
		if (list_of_steps.size() > value) {
			login.Log4j.info("PASS");
		} else {
			Assert.fail("Verification failed");
		}
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//*[@title='Close']")).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
		CommonFunctionality.Views_list();
	}

	@And("^Create map with taiwan series$")
	public void create_map_with_taiwan_series() throws Throwable {
		CommonFunctionality.wait(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Create new View tab']"))).click();
		login.Log4j.info("Clicking on  Series tab ");
		CommonFunctionality.wait(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(login.LOCATORS.getProperty("Series")))).click();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//*[@class='series-list-item--checkbox svg-checkbox']")).click();
		// CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Create new
		// View tab']", 20).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//*[@data-type='world']//*[@class='insight-action-panel--btn-popup icon--context-menu-arrow']")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-action='china']"))).click();

	}

	@Then("^The taiwan should be included in China map$")
	public void the_taiwan_should_be_included_in_China_map() throws Throwable {
		String Taiwan_attribute = null;
		try {
			CommonFunctionality.wait(5000);
			// Taiwan_attribute = login.driver
			// .findElement(By.xpath("//*[@class='highcharts-container
			// ']/*//*[contains(@class,'highcharts-data-labels
			// highcharts-series-2')]/*[1]/*[1]/*[@class='highcharts-text-outline']")).getText();
			/*Taiwan_attribute = login.driver.findElement(By.xpath(
					"(//*[contains(@class,'highcharts-color-0 highcharts-tracker')])[3]/*[1]/*[1]"))
					.getAttribute("innerHTML");*/
			Taiwan_attribute = login.driver.findElement(By.xpath(
					"(//*[contains(@class,'highcharts-color-0 highcharts-tracker')])[3]/*[1]/*[1]"))
					.getAttribute("innerHTML");
			login.Log4j.info(Taiwan_attribute);
			if (Taiwan_attribute.contains("Taiwan")) {
				login.Log4j.info("Taiwan is included in China map");
				CommonFunctionality.Views_list();
			}
		} catch (Exception e) {
			CommonFunctionality.Views_list();
			Assert.fail("Taiwan is not included in China map");
		}

	}

	@And("^Uncheck the \"([^\"]*)\" option$")
	public void uncheck_the_option(String arg1) throws Throwable {
		if(arg1.equalsIgnoreCase("Group")) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='indented-tree-control indented-tree-control__visible indented-tree-control__selected']//*[contains(text(),'" + arg1 + "')]", 10).click();
		} else if(arg1.equalsIgnoreCase("Show")){
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@title,'Attributes.')]/*[1]/*[1]/*", 10).click();
		}
		else {
			UncheckORCheckLegendOption(arg1);
		}

	}

	/*
	 * @SuppressWarnings("deprecation")
	 * 
	 * @And("^Create a new template and \"([^\"]*)\"$") public void
	 * create_a_new_template_and(String arg1) throws Throwable { WebElement
	 * add_template = CommonFunctionality.getElementByXpath(login.driver,
	 * "//*[contains(@class,'add-style-template')]", 4); if
	 * (arg1.equalsIgnoreCase("Template popup")) { if
	 * (add_template.getAttribute("class").contains("add-style-template__active")) {
	 * login.Log4j.info("Add Custom template icon is Enabled and Displayed");
	 * add_template.click(); CommonFunctionality.getElementByXpath(login.driver,
	 * "//*[@class='add-template-context--wrapper']//*[contains(@class,'add-template-context--input')]",
	 * 4).sendKeys(Cvision.send); new
	 * Actions(login.driver).pause(2000).sendKeys(Keys.ENTER).perform(); } } else {
	 * fail("Add template popup is not enabled"); } }
	 */

	@SuppressWarnings("deprecation")
	@And("^Create multiple templates$")
	public void create_multiple_templates() throws Throwable {

		for (int i = 0; i <= 3; i++) {
			String arg = "Legend";
			WebElement add_template = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'add-style-template')]", 20);
			// String templateTxt=add_template.getAttribute("class");
			// login.Log4j.info(templateTxt);
			if (add_template.getAttribute("class").contains("add-style-template__active")) {
				login.Log4j.info("Add Custom template icon is Enabled and Displayed");
				add_template.click();
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='add-template-context--wrapper']//*[contains(@class,'add-template-context--input')]",
						10).sendKeys(send[i]);
				new Actions(login.driver).pause(1000).sendKeys(Keys.ENTER).perform();
				try {
					// If confirmation popup is open...click on Ok
					CommonFunctionality.wait(500);
				login.driver.findElement(By.xpath("//*[@class='modal-content sphere-modal__content']//button[contains(text(),'Ok')]"))
							.click();
				} catch (Exception e) {
					// confirmation popup is not opened
				}

				UncheckORCheckLegendOption(arg);
			}
		}
	}

	@Then("^Selected template should be highlighted in the template Menu$")
	public void selected_template_should_be_highlighted_in_the_template_Menu() throws Throwable {
		String arg1 = "Delete template";
		CommonFunctionality.wait(3000);
		String style = login.driver.findElement(By
				.xpath("//*[@class='style-templates-menu--items']//*[contains(@class,'style-templates-item__active')]"))
				.getAttribute("title");
		assertEquals(CDMNextSprintCases.title_text, style);
		login.Log4j.info("Selected template is visible/highlighted in the template menu");

		for (String template : send) {
			CommonFunctionality.wait(2000);
			List<WebElement> deleting_template = login.driver
					.findElements(By.xpath("//*[@class='style-templates-menu--items']/*"));
			for (int i = 0; i < deleting_template.size(); i++) {
				String templateStr = deleting_template.get(i).getAttribute("title");
				if (template.equalsIgnoreCase(templateStr)) {
					CommonFunctionality.wait(300);
					login.driver.findElement(By.xpath("//*[@class='style-templates-menu--items']//*[@title='" + template
							+ "']//*[@title='" + arg1 + "']")).click();
					if (login.driver.findElements(By.xpath("//*[contains(@class,'modal-content')]//*[text()='Ok']"))
							.size() > 0) {
						CommonFunctionality.getElementByXpath(login.driver,
								"//*[contains(@class,'modal-content')]//*[text()='Ok']", 10).click();
						break;
					}

				}

			}
		}
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 20).click();
		if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']"))
				.size() > 0) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']", 20).click();
		}
		CommonFunctionality.Views_list();
	}

	@Then("^The new template should be created$")
	public static void the_new_template_should_be_created() throws Throwable {
		String arg1 = "Delete template";
		String new_template = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[contains(@class,'style-templates-item__active')][1]")))
				.getAttribute("title");
		if (new_template.equals(CDMNextSprintCases.send)) {
			login.Log4j.info("The new template is created");
		}
		CDMNextSprintCases.the_newly_created_template(arg1);
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
		if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']"))
				.size() > 0) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']", 10).click();
		}
		CommonFunctionality.Views_list();
	}

	@And("^Enter \"([^\"]*)\"$")
	public void enter(String arg1) throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).clear();
		login.Log4j.info("searching with " + arg1);
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys(arg1);
	}

	@And("^Verify the time points$")
	public void verify_the_time_points() throws Throwable {
		WebElement SeriesTab = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series")));
		SeriesTab.click();
		Thread.sleep(3000);
		WebElement sname = login.driver.findElement(By.xpath("//div[@class='series-item--name']"));
		CommonFunctionality.action.moveToElement(sname).build().perform();
		login.driver.findElement(By.xpath("//span[@class='view-chart-icon menu-icon']")).click();

		/*
		 * // data in ssp Thread.sleep(3000);
		 * login.driver.findElement(By.xpath("//div[@class='tabs__tabs-box']//div[2]")).
		 * click(); Thread.sleep(5000); List<WebElement> time_points =
		 * login.driver.findElements(By.xpath(
		 * "//div[@class='preview-series-time-points']//div//span[@class='preview-series-time-points--point-value']"
		 * )); login.Log4j.info("Size of timepoints " + time_points.size()); for (int i
		 * = 0; i < time_points.size(); i++) { Thread.sleep(6000); int j = i + 1;
		 * System.out.println(i); System.out.println(time_points.size()); WebElement
		 * element = login.driver.findElement(By.xpath(
		 * "//div[@class='preview-series-time-points']//div[" + j +
		 * "]//span[@class='preview-series-time-points--point-value']")); String str =
		 * element.getText(); login.Log4j.info("Time_point_value " + str);
		 * 
		 * }
		 */
		// chart visual in view pannel

		Thread.sleep(5000);
		List<WebElement> time_points = login.driver.findElements(By.xpath("//*[@class='highcharts-point']"));
		login.Log4j.info("Size of timepoints " + time_points.size());
		for (int i = 0; i < time_points.size(); i++) {
			Thread.sleep(4000);
			int j = i + 1;
			System.out.println(i);
			System.out.println(time_points.size());
			WebElement element = login.driver.findElement(By.xpath("//*[@class='highcharts-point'][" + j + "]"));
			CommonFunctionality.action.moveToElement(element).build().perform();
			Thread.sleep(2000);
			String ele = login.driver.findElement(By.xpath("//*[@visibility='visible']")).getText();
			CommonFunctionality.jse.executeScript(ele);
			login.Log4j.info(ele);
			element = login.driver.findElement(
					By.xpath("//*[@class='highcharts-label highcharts-tooltip highcharts-color-undefined']/span/b"));
			String str1 = element.getText();
			login.Log4j.info("Time_point_value " + str1);

		}
	}

	void CopyView_Sameinsight() throws Exception {
		Thread.sleep(5000);
		String CopyView = login.driver
				.findElement(By.xpath("//*[@class='insight-page-view-tab--link insight-page-view-tab--link__active']"))
				.getAttribute("title");
		login.Log4j.info(CopyView);
		login.Log4j.info(view1);
		if (CopyView.contains(view1) && CopyView.contains("copy")) {
			login.Log4j.info("View is copied");
		} else {
			Assert.fail("Verification is failed");
		}
	}

	void CopyView_Newinsight() throws Exception {
		Thread.sleep(2000);
		List<String> views = new ArrayList<>();
		List<WebElement> List_of_views = login.driver.findElements(
				By.xpath("//*[@class='insight-page-menu-views-container--view-tabs ui-sortable']//div//a"));
		login.Log4j.info(List_of_views.size());
		if (List_of_views.size() == 4) {
			for (int i = 2; i < List_of_views.size(); i++) {
				Thread.sleep(2000);
				String ViewTxt = List_of_views.get(i).getAttribute("title");
				views.add(ViewTxt);
				login.Log4j.info(views);

			}
		} else if (List_of_views.size() == 3) {

			for (int i = 1; i < List_of_views.size(); i++) {
				Thread.sleep(2000);
				String ViewTxt = List_of_views.get(i).getAttribute("title");
				views.add(ViewTxt);
				login.Log4j.info(views);

			}
		}
		if (views.contains("View 1 copy") == true && views.contains("View 2 copy") == true) {
			login.Log4j.info("All views pasted in the same/new insight");
		} else {
			Assert.fail("Verificaiton failed");
		}
	}

	void UncheckORCheckLegendOption(String arg) {
		// login.Log4j.info(arg);
		WebElement legend = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title,'" + arg + "')]/*[1]")));
		login.Log4j.info("Unselecting " + arg + " option");
		wait.until(ExpectedConditions.elementToBeClickable(legend)).click();
	}

	void DeleteInsight() {
		try {
			// delete insight
			CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Open File menu']", 20).click();
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Delete')]", 20).click();
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Delete forever')]", 20).click();
			CommonFunctionality.wait(7000);
			CommonFunctionality.ContinueSameInsight();
			login.driver
					.findElement(By.xpath("//*[contains(@class,'insight-page-view-tab') and contains(text(),'View')]"))
					.click();
			CommonFunctionality.DeleteVisual();
			CommonFunctionality.DeleteSeries();

		} catch (Exception e) {

		}
	}
}
