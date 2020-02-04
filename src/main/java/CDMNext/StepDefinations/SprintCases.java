package CDMNext.StepDefinations;

import org.testng.Assert;

import org.testng.AssertJUnit;

import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class SprintCases {
	String[] send = new String[] { "Shravas", "teplate1", "template2", "template3" };
	String minimize;
	String view1;
	WebDriverWait wait = new WebDriverWait(login.driver, 500);

	@Then("^Search without any filters link should be removed$")
	public void search_without_any_filters_link_should_be_removed() throws Throwable {
		Thread.sleep(2000);

		if (login.driver.findElements(By.xpath("//*[contains(text(),'Search without any filters')]")).size() != 1) {
			login.Log4j.info("Search without any filters link is removed");
		} else {
			Assert.fail("Verification failed");
		}
	}

	@And("^Create India map with indian cities supporting subnational attribute$")
	public void create_India_map_with_indian_cities_supporting_subnational_attribute() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Create new View tab']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-node-model-id='INDIA']//div[1]")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class,'tree-node')][3]//div[1]")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@class='tree-node open']//*[@class='tree-node'][1]//*[@class='toggle']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@class='tree-node open']//*[@class='tree-node']//*[@class='svg-checkbox']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//*[@title='Insert Map']//*[@class='insight-action-panel--btn-popup icon--context-menu-arrow']")))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='India']"))).click();
	}

	@SuppressWarnings("deprecation")
	@Then("^Andhra Pradesh subnational city should appear on India map$")
	public void andhra_Pradesh_subnational_city_should_appear_on_India_map() throws Throwable {
		Thread.sleep(2000);
		List<WebElement> list_of_states = login.driver
				.findElements(By.xpath("//div[@class='visual-item']/div/*/*[10]/*//*/*"));
		for (int i = 0; i < list_of_states.size(); i++) {
			// int j = i + 1;
			CommonFunctionality.wait(1000);
			String state = list_of_states.get(i).getText();
			login.Log4j.info(state);
			if (state.equals("Andhra Pradesh")) {
				// Thread.sleep(2000);
				WebElement ele = list_of_states.get(i);
				CommonFunctionality.action.moveToElement(ele).pause(2000).build().perform();
				String tooltip = login.driver.findElement(By.xpath(
						"//div[@class='highcharts-label highcharts-tooltip highcharts-color-0']//span//div[@class='table-tooltip']"))
						.getText();
				// login.Log4j.info(tooltip);
				String tooltipArr[] = tooltip.split("\n");
				for (int m = 0; m < tooltipArr.length; m++) {
					int n = m + 1;
					// login.Log4j.info(tooltipArr);

					if (tooltipArr[n].contains("Subnational") == true) {
						String[] arr = tooltipArr[n].split(":");
						String subnational = arr[1].trim();
						login.Log4j.info(subnational);
						if (subnational.equals(SearchTest.currentKeyword) == true) {
							login.Log4j.info("PASS");
							break;
						}

					}
				}
				break;
			}
		}
		CommonFunctionality.Views_list();

	}

	@And("^Open ssp window$")
	public void open_ssp_window() throws Throwable {
		login.Log4j.info("Clicking on  Series tab ");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Series"))))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='series-item--name']"))).click();
		Thread.sleep(2000);
		minimize = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Minimize']")))
				.getAttribute("title");
	}

	@And("^Minimize ssp window$")
	public void minimize_ssp_window() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Minimize']"))).click();
	}

	@Then("^The modal window should get collapsed into row$")
	public void the_modal_window_should_get_collapsed_into_row() throws Throwable {
		String maximize = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Maximize']")))
				.getAttribute("title");
		if (minimize.equals(maximize) != true) {
			login.Log4j.info("SSP window is minimized");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Close']"))).click();

		} else {
			Assert.fail("Verifivation failed");
		}

	}

	@And("^Select \"([^\"]*)\" filter$")
	public void select_filter(String arg1) throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + arg1 + "')]")))
				.click();
	}

	@Then("^For search results less than (\\d+), the system will display all the tables and on the first table – down to series level$")
	public void for_search_results_less_than_the_system_will_display_all_the_tables_and_on_the_first_table_down_to_series_level(
			int arg1) throws Throwable {
		Thread.sleep(5000);
		List<WebElement> seriesLevel_ULele = login.driver.findElements(By.xpath("//*[@class='search-series-list']"));
		login.Log4j.info("size : " + seriesLevel_ULele.size());
		if (seriesLevel_ULele.size() == 1) {
			login.Log4j.info(
					"All the tables are displayed and Series level is displayed for first table for less than " + arg1);
		} else {
			Assert.fail("Verification failed");
		}
	}

	@SuppressWarnings("deprecation")
	@Then("^For search results less than (\\d+), the system will expand all the levels$")
	public void for_search_results_less_than_the_system_will_expand_all_the_levels(int arg1) throws Throwable {
		Thread.sleep(5000);
		List<WebElement> seriesLevel = login.driver.findElements(By.xpath(
				"//*[@class='database-node tree-node open'][1]//*[@class='database-node tree-node open']//div[3]//div[1]//div[3]//div//div[3]//div[@class='tree-node open']"));
		login.Log4j.info("size : " + seriesLevel.size());
		for (int i = 0; i < seriesLevel.size(); i++) {
			Thread.sleep(1500);
			WebElement SeriesLevel = seriesLevel.get(i);
			CommonFunctionality.action.pause(2000).moveToElement(SeriesLevel).build().perform();
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Series"))))
				.click();
		WebElement seriesName = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='series-item--name']")));
		CommonFunctionality.action.pause(2000).moveToElement(seriesName).build().perform();
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
		Thread.sleep(1000);
		WebElement showDatabase = login.driver.findElement(By.xpath("//*[@title='Show Database']"));
		CommonFunctionality.action.pause(1000).moveToElement(showDatabase).build().perform();
		String showDb = showDatabase.getAttribute("title");
		if (!toolTip_txt.equals(showDb) == true) {
			login.Log4j.info("tooltip is not displayed for " + showDb);
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Create visual$")
	public void create_visual() throws Throwable {
		login.Log4j.info("Clicking on  Series tab ");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Series"))))
				.click();
		Thread.sleep(2000);

		List<WebElement> ListOfSeries = login.driver.findElements(By.xpath("//*[@class='series-item--name']"));

		for (int i = 0; i < ListOfSeries.size(); i++) {
			int j = i + 1;
			Thread.sleep(1000);
			WebElement seriesName = ListOfSeries.get(i);
			CommonFunctionality.action.pause(1000).moveToElement(seriesName).build().perform();
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//li[" + j + "]//*[@class='view-chart-icon menu-icon']")))
					.click();
		}
	}

	@Then("^\"([^\"]*)\" should be displayed in the summary popup$")
	public void should_be_displayed_in_the_summary_popup(String arg1) throws Throwable {
		Thread.sleep(2000);
		login.driver.navigate().refresh();
		WebElement eleChanges = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + arg1 + "')]")));

		if (eleChanges.isDisplayed()) {
			login.Log4j.info(arg1 + " is displayed");
		}
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//*[@title='Close']")).click();
	}

	@SuppressWarnings("deprecation")
	@And("^Right click on the View and select Copy View$")
	public void right_click_on_the_View_and_select_Copy_View() throws Throwable {
		WebElement eleView1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='View 1']")));
		CommonFunctionality.action.pause(2000).contextClick(eleView1).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Copy view')]")))
				.click();
		view1 = eleView1.getAttribute("title");
	}

	@SuppressWarnings("deprecation")
	@And("^Paste in the View section$")
	public void paste_in_the_View_section() throws Throwable {
		Thread.sleep(2000);
		WebElement CreateNewViewTab = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@class='insight-page-menu-views-container--add']")));
		CommonFunctionality.action.pause(2000).contextClick(CreateNewViewTab).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Paste view(s)')]")))
				.click();
	}

	@And("^Paste in the View section for new insight$")
	public void paste_in_the_View_section_for_new_insight() throws Throwable {
		if (login.driver.findElement(By.xpath("//*[@class='panel-expander panel-expander__left']")).isDisplayed()) {
			login.driver.findElement(By.xpath("//*[@class='panel-expander panel-expander__left']")).click();
		}
		paste_in_the_View_section();
	}

	@Then("^The copied View and its contents should be pasted in the same insight$")
	public void the_copied_View_and_its_contents_should_be_pasted_in_the_same_insight() throws Throwable {
		Thread.sleep(2000);
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
		CommonFunctionality.Views_list();
	}

	@Then("^The copied View and its contents should be pasted in other/new insight$")
	public void the_copied_View_and_its_contents_should_be_pasted_in_other_new_insight() throws Throwable {
		the_copied_View_and_its_contents_should_be_pasted_in_the_same_insight();

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
		Thread.sleep(2000);
		List<String> views = new ArrayList<>();
		List<WebElement> List_of_views = login.driver
				.findElements(By.xpath("//*[@class='insight-page-view-tab ui-sortable-handle']//a"));
		for (int i = 2; i < List_of_views.size(); i++) {
			Thread.sleep(2000);
			String ViewTxt = List_of_views.get(i).getAttribute("title");
			views.add(ViewTxt);
			login.Log4j.info(views);

		}
		if (views.contains("View 1 copy") == true && views.contains("View 2 copy") == true) {
			login.Log4j.info("All views pasted in the same insight");
		} else {
			Assert.fail("Verificaiton failed");
		}
		CommonFunctionality.Views_list();
	}

	@Then("^All Views and contents from the insight should be pasted in the new/other insight$")
	public void all_Views_and_contents_from_the_insight_should_be_pasted_in_the_new_other_insight() throws Throwable {
		all_Views_and_contents_from_the_insight_should_be_pasted_in_the_same_insight();
	}

	@And("^User enters series_id \"([^\"]*)\"$")
	public void user_enters_series_id(String arg1) throws Throwable {
		login.driver.navigate().refresh();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).clear();
		login.Log4j.info("searching with " + arg1);
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys(arg1);
	}

	@And("^Create a map visual$")
	public void create_a_map_visual() throws Throwable {
		login.Log4j.info("Clicking on  Series tab ");
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//li[1]//*[@class='series-list-item--checkbox-wrapper']")))
				.click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@class='insight-page-menu-views-container--add']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-action='world']"))).click();
	}

	@And("^Click on Edit Map$")
	public void click_on_Edit_Map() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Edit Map')]"))).click();
	}

	@And("^Select Gradient$")
	public void select_Gradient() throws Throwable {
		Thread.sleep(2000);
		WebElement Gradient = login.driver.findElement(By.xpath("//*[contains(text(),'Gradient')]"));
		if (Gradient.isSelected() == true) {
			login.Log4j.info("Gradient is selected");
		} else {
			Gradient.click();
		}
	}

	@Then("^Default value should be \"([^\"]*)\" and the steps range should be from \"([^\"]*)\"$")
	public void default_value_should_be_and_the_steps_range_should_be_from(String arg1, String arg2) throws Throwable {

		WebElement ele = login.driver.findElement(By.xpath("//*[@name='steps']//*[contains(text(),'0')]"));
		String GradientDefaultValue = ele.getText();
		List<WebElement> range_of_steps = login.driver.findElements(By.xpath("//*[@name='steps']//*"));
		login.Log4j.info(GradientDefaultValue);
		login.Log4j.info(arg1);
		if (GradientDefaultValue.equals(arg1)) {
			login.Log4j.info("Gradient default value is :" + GradientDefaultValue);
		} else {
			AssertJUnit.fail("Verification failed");
		}
		for (int i = 0; i < range_of_steps.size(); i++) {
			String str = range_of_steps.get(i).getAttribute("value");
			if (arg2.contains(str) == true) {
				login.Log4j.info(str);
			} else {
				AssertJUnit.fail("FAIL");
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
		WebElement ele = login.driver.findElement(By.xpath("//select[@class='solid-colors--color-stops-select']"));
		String SolidColorDefaultValue = ele.getAttribute("value");
		List<WebElement> range_of_colors = login.driver
				.findElements(By.xpath("//select[@class='solid-colors--color-stops-select']//*"));
		// login.Log4j.info(SolidColorDefaultValue);
		// login.Log4j.info(arg1);
		if (SolidColorDefaultValue.equals(arg1)) {
			login.Log4j.info("Gradient default value is :" + SolidColorDefaultValue);
		} else {
			AssertJUnit.fail("Verification failed");
		}
		for (int i = 0; i < range_of_colors.size(); i++) {
			String str = range_of_colors.get(i).getAttribute("value");
			if (arg2.contains(str) == true) {
				login.Log4j.info(str);
			} else {
				AssertJUnit.fail("FAIL");
			}
		}
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//*[@title='Close']")).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
		CommonFunctionality.Views_list();
	}

	@Then("^Clicking on the color box will open the color picker$")
	public void clicking_on_the_color_box_will_open_the_color_picker() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//*[@class='solid-colors--container']//*[@class='predefined-color'][1]"))
				.click();
		WebElement color_picker = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@class='sp-container sp-light sp-buttons-disabled sp-palette-buttons-disabled sp-initial-disabled color-picker-selection']")));
		if (color_picker.isDisplayed() == true) {
			login.Log4j.info("Color picker is displayed");
		} else {
			AssertJUnit.fail("Color picker is not displayed");
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
			AssertJUnit.fail("Verification failed");
		}
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//*[@title='Close']")).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
		CommonFunctionality.Views_list();
	}

	@And("^Create map with taiwan series$")
	public void create_map_with_taiwan_series() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Create new View tab']"))).click();
		login.Log4j.info("Clicking on  Series tab ");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(login.LOCATORS.getProperty("Series")))).click();
		CommonFunctionality.wait(1000);
		login.driver.findElement(By.xpath("//li[1]//*[@class='series-list-item--checkbox svg-checkbox']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//*[@data-type='world']//*[@class='insight-action-panel--btn-popup icon--context-menu-arrow']")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li//*[@data-action='china']"))).click();

	}

	@SuppressWarnings("deprecation")
	@Then("^The taiwan should be included in China map$")
	public void the_taiwan_should_be_included_in_China_map() throws Throwable {
		CommonFunctionality.wait(2000);
		List<WebElement> list_of_states = login.driver
				.findElements(By.xpath("//div[@class='visual-item']/div/*/*[10]/*//*/*"));
		for (int i = 0; i < list_of_states.size(); i++) {
			// int j = i + 1;
			CommonFunctionality.wait(1000);
			String state = list_of_states.get(i).getText();
			login.Log4j.info(state);
			if (state.equals("Taiwan")) {
				// Thread.sleep(2000);
				WebElement ele = list_of_states.get(i);
				CommonFunctionality.action.moveToElement(ele).pause(2000).build().perform();
				String tooltip = login.driver.findElement(By.xpath(
						"//div[@class='highcharts-label highcharts-tooltip highcharts-color-0']//span//div[@class='table-tooltip']"))
						.getText();
				// login.Log4j.info(tooltip);
				String tooltipArr[] = tooltip.split("\n");
				for (int m = 0; m < tooltipArr.length; m++) {
					int n = m + 1;
					// login.Log4j.info(tooltipArr);

					if (tooltipArr[n].contains("Subnational") == true) {
						String[] arr = tooltipArr[n].split(":");
						String subnational = arr[1].trim();
						login.Log4j.info(subnational);
						if (subnational.equals(state) == true) {
							login.Log4j.info("PASS");
							break;
						}

					}
				}
				break;
			}
		}
		CommonFunctionality.Views_list();
	}

	@And("^Uncheck the \"([^\"]*)\" option$")
	public void uncheck_the_option(String arg1) throws Throwable {
		UncheckORCheckLegendOption(arg1);

	}

	@SuppressWarnings("deprecation")
	@And("^Create a new template and \"([^\"]*)\"$")
	public void create_a_new_template_and(String arg1) throws Throwable {
		WebElement add_template = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'add-style-template')]", 4);
		if (arg1.equalsIgnoreCase("Template popup")) {
			if (add_template.getAttribute("class").contains("add-style-template__active")) {
				login.Log4j.info("Add Custom template icon is Enabled and Displayed");
				add_template.click();
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='add-template-context--wrapper']//*[contains(@class,'add-template-context--input')]",
						4).sendKeys(Cvision.send);
				new Actions(login.driver).pause(2000).sendKeys(Keys.ENTER).perform();
			}
		} else {
			fail("Add template popup is not enabled");
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Create multiple templates$")
	public void create_multiple_templates() throws Throwable {

		for (int i = 0; i <= 3; i++) {
			String arg = "Legend";

			WebElement add_template = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'add-style-template')]", 4);
			// String templateTxt=add_template.getAttribute("class");
			// login.Log4j.info(templateTxt);
			if (add_template.getAttribute("class").contains("add-style-template__active")) {
				login.Log4j.info("Add Custom template icon is Enabled and Displayed");
				add_template.click();
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='add-template-context--wrapper']//*[contains(@class,'add-template-context--input')]",
						4).sendKeys(send[i]);
				new Actions(login.driver).pause(2000).sendKeys(Keys.ENTER).perform();
				// WebElement add_template_icon =
				// CommonFunctionality.getElementByXpath(login.driver,
				// "//*[contains(@class,'add-template-context--icon__apply')]", 4);
				// new
				// Actions(login.driver).moveToElement(add_template_icon).click().build().perform();
				if (login.driver.findElements(By.className("sphere-modal__content")).size() > 0) {
					CommonFunctionality.getElementByXpath(login.driver,
							"//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']", 4).click();
				}

				UncheckORCheckLegendOption(arg);
			}
		}
	}

	@Then("^The new template should be created$")
	public void the_new_template_should_be_created() throws Throwable {
		String arg1 = "Delete template";
		String new_template = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[contains(@class,'style-templates-item__active')][1]")))
				.getAttribute("title");
		if (new_template.equals(Cvision.send)) {
			login.Log4j.info("The new template is created");
		}
		Cvision.the_newly_created_template(arg1);
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']"))
				.size() > 0) {
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(@class,'sphere-modal__content')]//*[text()='Ok']", 4)
					.click();
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
	
		/*	// data in ssp
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//div[@class='tabs__tabs-box']//div[2]")).click();
		Thread.sleep(5000);
		List<WebElement> time_points = login.driver.findElements(By.xpath(
				"//div[@class='preview-series-time-points']//div//span[@class='preview-series-time-points--point-value']"));
		login.Log4j.info("Size of timepoints " + time_points.size());
		for (int i = 0; i < time_points.size(); i++) {
			Thread.sleep(6000);
			int j = i + 1;
			System.out.println(i);
			System.out.println(time_points.size());
			WebElement element = login.driver.findElement(By.xpath("//div[@class='preview-series-time-points']//div["
					+ j + "]//span[@class='preview-series-time-points--point-value']"));
			String str = element.getText();
			login.Log4j.info("Time_point_value " + str);

		}*/
		   //chart visual in view pannel
		  
		  	
			Thread.sleep(5000);
			List<WebElement> time_points=login.driver.findElements(By.xpath("//*[@class='highcharts-point']"));
			   login.Log4j.info("Size of timepoints "+time_points.size() );
			   for(int i=0;i<time_points.size();i++) {
				   Thread.sleep(4000);
				   int j=i+1;
				   System.out.println(i);
				   System.out.println(time_points.size());
				   WebElement element=login.driver.findElement(By.xpath("//*[@class='highcharts-point'][" + j + "]"));
				  CommonFunctionality.action.moveToElement(element).build().perform();
				   Thread.sleep(2000);
				   String ele = login.driver.findElement(By.xpath("//*[@visibility='visible']")).getText();
				   CommonFunctionality.jse.executeScript(ele);
				   login.Log4j.info(ele);
			       element=login.driver.findElement(By.xpath("//*[@class='highcharts-label highcharts-tooltip highcharts-color-undefined']/span/b"));
			       String str1 =element.getText();
				   login.Log4j.info("Time_point_value " + str1);
				   	  
			   }
	}

	void UncheckORCheckLegendOption(String arg) {
		// login.Log4j.info(arg);
		WebElement legend = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title,'" + arg + "')]/*[1]")));
		login.Log4j.info("Unselecting " + arg + " option");
		wait.until(ExpectedConditions.elementToBeClickable(legend)).click();
	}
}
