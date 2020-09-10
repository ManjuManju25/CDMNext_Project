package CDMNext.StepDefinations;

import java.awt.Robot;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class AllTab {
	static WebElement ele;
	List<WebElement> list_of_insights;
	String InsightsSwitch;
	String insightName;
	String str;
	// public String sname;
	// String db_name;
	WebElement element;
	List<WebElement> list_of_series;
	static List<String> sname = new ArrayList<>();
	static List<String> Add_replce = new ArrayList<>();
	static WebElement checkbox;
	SoftAssert softAssert = new SoftAssert();
	static WebElement unselect;
	int MaxDatasetsCount;

	/*@And("^Click on \"([^\"]*)\" tab$")
	public void click_on_tab(String arg1) throws Throwable {
		// CommonFunctionality.wait
		// .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Search"))))
		// .clear();
		CommonFunctionality.TabSelection(arg1);
	}*/

	@Then("^All tab should contain these sections \"([^\"]*)\"$")
	public void all_tab_should_contain_these_sections(String arg1) throws Throwable {
		CommonFunctionality.wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Search"))))
				.clear();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys(Keys.ENTER);
		String[] arr = arg1.split(",");
		List<WebElement> list_of_tabs = login.driver.findElements(By.xpath("//*[@class='all-item--title']"));
		login.Log4j.info(list_of_tabs.size());
		for (int i = 0; i < list_of_tabs.size(); i++) {
			Thread.sleep(2000);
			if (arg1.contains("Top Insights")) {
				int j = i + 1;
				ele = login.driver.findElement(By.xpath(
						"//*[@class='all-representation--content']//*[" + j + "]//*//*[@class='all-item--title']"));
			} else {
				int j = i + 1;
				ele = login.driver.findElement(By.xpath("//div[@class='all-representation--content']//div[" + j
						+ "]//div[1]//div[@class='all-item--title']"));
			}
			CommonFunctionality.jse.executeScript("arguments[0].scrollIntoView(true);", ele);
			String str = ele.getText();
			// login.Log4j.info(str);
			boolean KeywordMatch = false;
			for (String arr1 : arr) {
				if (arr1.contains(str)) {
					login.Log4j.info(" All tab contain " + str);
					KeywordMatch = true;
				}
			}
			if (KeywordMatch == false) {
				Assert.fail("All tab doesn't contain " + str);
			}
		}
	}

	@And("^Click on \"([^\"]*)\" Switch$")
	public void click_on_Switch(String arg1) throws Throwable {
		InsightsSwitch = arg1;
		Thread.sleep(3000);
		if (arg1.equals("All Insights")) {
			login.driver.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]")).click();
			login.Log4j.info(" Clicking on " + arg1);
		} else if (arg1.equals("EMIS Insights")) {
			login.driver.findElement(By.xpath("//label//*[contains(text(),'" + arg1 + "')]")).click();
			login.Log4j.info(" Clicking on " + arg1);
		}
	}
	/*
	 * @Then("^All Tab should show insights from All Insights in Top Insights section$"
	 * ) public void
	 * all_Tab_should_show_insights_from_All_Insights_in_Top_Insights_section()
	 * throws Throwable { Thread.sleep(3000); ele = login.driver.findElement( By.
	 * xpath("//div[@class='top-insights all-item']//div[@class='all-item--view-more-title']"
	 * ));
	 * CommonFunctionality.jse.executeScript("arguments[0].scrollIntoView(true);",
	 * ele); Thread.sleep(1500); ele.click(); AllInsightsValidation(); }
	 * 
	 * @Then("^All Tab should show insights from EMIS Insights in Top Insights section$"
	 * ) public void
	 * all_Tab_should_show_insights_from_EMIS_Insights_in_Top_Insights_section()
	 * throws Throwable { Thread.sleep(3000); ele = login.driver.findElement( By.
	 * xpath("//div[@class='top-insights all-item']//div[@class='all-item--view-more-title']"
	 * ));
	 * CommonFunctionality.jse.executeScript("arguments[0].scrollIntoView(true);",
	 * ele); Thread.sleep(1500); ele.click(); EMISInsightsValidation(); }
	 */

	@And("^Observe the number of insights displayed by default$")
	public void observe_the_number_of_insights_displayed_by_default() throws Throwable {
		Thread.sleep(3000);
		list_of_insights = login.driver.findElements(By.xpath("//*[@class='all-insights-list-item']"));

	}

	@Then("^\"([^\"]*)\" insights should be displayed by default$")
	public void insights_should_be_displayed_by_default(String arg1) throws Throwable {
		Thread.sleep(2000);
		int number_of_insights = Integer.parseInt(arg1);
		if (number_of_insights == list_of_insights.size()) {
			login.Log4j.info(number_of_insights + " insights displayed by default");
		} else {
			Assert.fail(number_of_insights + " insights not displayed by default");
		}
	}

	@And("^Click on \"([^\"]*)\" link$")
	public void click_on_link(String arg1) throws Throwable {
		CommonFunctionality.VerifyLink(arg1);
	}

	@Then("^User should be navigated to \"([^\"]*)\" page$")
	public void user_should_be_navigated_to_page(String arg1) throws Throwable {
		Thread.sleep(2000);
		if (InsightsSwitch.equals("All Insights")) {
			AllInsightsValidation();
		} else if (InsightsSwitch.equals("EMIS Insights")) {
			EMISInsightsValidation();
		}
	}

	@And("^Click on the insight title$")
	public void click_on_the_insight_title() throws Throwable {
		Thread.sleep(3000);
		ele = login.driver.findElement(
				By.xpath("//div[@class='all-insights-list-item'][1]//div[@class='all-insights-list-item--name']"));
		insightName = ele.getText();
		login.Log4j.info(insightName);
		login.driver.findElement(By.xpath("//div[@class='all-insights-list-item'][1]")).click();

	}

	@Then("^The particular insight should get opened in View mode$")
	public void the_particular_insight_should_get_opened_in_View_mode() throws Throwable {
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath("//*[@class='insight-preview--title text-dots']"));
		String previe_title = ele.getText();
		login.Log4j.info(previe_title);
		if (insightName.equals(previe_title)) {
			login.Log4j.info("PASS");
			Thread.sleep(1500);
			login.driver.findElement(By.xpath("//*[@class='insight-preview--close']")).click();
		} else {
			Thread.sleep(1500);
			login.driver.findElement(By.xpath("//*[@class='insight-preview--close']")).click();
			Assert.fail("Insight is not opened in view mode");
		}
	}

	@And("^\"([^\"]*)\" popular series should be displayed by default$")
	public void popular_series_should_be_displayed_by_default(String arg1) throws Throwable {
		int PopularSeriesCount = Integer.parseInt(arg1);
		PopularSeriesMethod();
		DefaultSeries(PopularSeriesCount);
	}

	@And("^Hover the mouse on any series$")
	public void hover_the_mouse_on_any_series() throws Throwable {
		PopularSeriesMethod();
		mouseHoverOnseries();
	}

	@And("^Click on i icon in blue$")
	public void click_on_i_icon_in_blue() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//li[1]//*[@class='series-list-item--info-icon-i']")).click();
	}

	@Then("^SSP window should be poped up$")
	public void ssp_window_should_be_poped_up() throws Throwable {
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath("//*[@class='single-series-preview--title ']"));
		String ssp_title_txt = ele.getText();
		if (CommonFunctionality.sname.equals(ssp_title_txt)) {
			login.Log4j.info("PASS");
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//*[@title='Close']")).click();
		} else {
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//*[@title='Close']")).click();
			Assert.fail("SSP window is not displayed");
		}
	}

	@Then("^Series info as tooltip should get poped up$")
	public void series_info_as_tooltip_should_get_poped_up() throws Throwable {
		Thread.sleep(1500);
		ele = login.driver.findElement(By.xpath("//*[@class='tooltip tooltip__visible']//table"));
		String tooltip = ele.getText();
		login.Log4j.info(tooltip);
		if (tooltip.contains(CommonFunctionality.sname)) {
			login.Log4j.info("PASS");
		} else {
			Assert.fail("tooltip is not displayed");
		}
	}

	@Then("^\"([^\"]*)\" should get displayed$")
	public void should_get_displayed(String arg1) throws Throwable {
		Thread.sleep(1500);
		List<WebElement> mouseHover_options = login.driver
				.findElements(By.xpath("//li[1]//div[@class='series-list-item--action-icons']//span"));
		for (int i = 0; i < mouseHover_options.size(); i++) {

			String mouseHover_text = mouseHover_options.get(i).getAttribute("title");
			if (arg1.contains(mouseHover_text)) {
				login.Log4j.info(mouseHover_text);
				// login.Log4j.info("PASS");
			} else {
				Assert.fail(mouseHover_text + " not available");
			}
		}
	}

	@And("^Click on \"([^\"]*)\" mouse hover icon$")
	public void click_on_mouse_hover_icon(String arg1) throws Throwable {
		Thread.sleep(1500);
		switch (arg1) {
		case "Show Database":
			login.driver.findElement(By.xpath("//li[1]//div[@class='series-list-item--action-icons']//span[1]"))
					.click();
			// when show database have multiple db's
			Thread.sleep(1000);
			List<WebElement> li_element = login.driver
					.findElements(By.xpath("//ul[@class='dropdown-menu context-menu ']//li"));
			// login.Log4j.info(li_element.size());
			if (li_element.size() > 0) {
				for (int i = 0; i < li_element.size(); i++) {
					int j = i + 1;
					ele = login.driver
							.findElement(By.xpath("//ul[@class='dropdown-menu context-menu ']//li[" + j + "]"));
					element = login.driver.findElement(
							By.xpath("//ul[@class='dropdown-menu context-menu ']//li[" + j + "]//span//span//b"));
					CommonFunctionality.db_name = element.getText();
					login.Log4j.info(CommonFunctionality.db_name);
					ele.click();
					if (j == 1) {
						break;
					}
				}
			}
			break;
		case "View as Chart. Type `c`":
			login.driver.findElement(By.xpath("//li[1]//*[@class='series-list-item--action-icons']//span[2]")).click();
			Thread.sleep(2000);
			break;
		case "Open footnote":
			Thread.sleep(3000);
			login.driver.findElement(By.xpath("//li[1]//*[@class='series-list-item--action-icons']//span[3]")).click();
			break;

		}
	}

	@Then("^Database should navigate to the particular database and highlight the series$")
	public void database_should_navigate_to_the_particular_database_and_highlight_the_series() throws Throwable {

		try {
			// it will execute when show db has mutiple db's
			WebElement db_ele = login.driver.findElement(
					By.xpath("//*[@class='name']//*[contains(text(),'" + CommonFunctionality.db_name + "')]"));
			CommonFunctionality.jse.executeScript("arguments[0].scrollIntoView(true);", db_ele);
			Thread.sleep(3000);
			String dbase = db_ele.getText();
			login.Log4j.info(dbase);
			if (dbase.equals(CommonFunctionality.db_name)) {
				login.Log4j.info("PASS");
			} else {
				Assert.fail("FAIL");
			}
		} catch (Exception e) {
			CommonFunctionality.TopMethod();
			DatabasesTab.should_redirect_to_database_tab();
		}

	}

	@Then("^Chart should be created with the selected series$")
	public void chart_should_be_created_with_the_selected_series() throws Throwable {
		CommonFunctionality.wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@class='visual-title--wrapper']//*[@class='text-dots']")));
		ele = login.driver.findElement(By.xpath("//*[@class='visual-title--wrapper']//*[@class='text-dots']"));
		String chartTitle = ele.getText();
		login.Log4j.info(chartTitle);
		AssertJUnit.assertEquals(CommonFunctionality.sname, chartTitle);
		login.Log4j.info("chart is created for series level");
		CommonFunctionality.Views_list();
	}

	@Then("^Footnote window should be opened for the selected series$")
	public void footnote_window_should_be_opened_for_the_selected_series() throws Throwable {
		Thread.sleep(3000);
		ele = login.driver.findElement(By.className("footnotes-modal--title"));
		String footnote_title = ele.getText();
		if (footnote_title.contains(CommonFunctionality.sname)) {
			login.Log4j.info("Footnote is opened");
			Thread.sleep(2000);
			login.driver.findElement(By.className("movable-modal--close")).click();
		} else {
			AssertJUnit.fail("Footnote is not opened");
		}
	}

	@Then("^Context menu should be poped up$")
	public void context_menu_should_be_poped_up() throws Throwable {
		CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("items-wrapper")));
		if (login.driver.findElement(By.className("items-wrapper")).isDisplayed()) {
			login.Log4j.info("PASS");
		} else {
			Assert.fail("FAIL");
		}
	}

	@And("^Hover the mouse on any series level$")
	public void hover_the_mouse_on_any_series_level() throws Throwable {
		CommonFunctionality.UnselectMethod();
		PopularSeriesMethod();
		Thread.sleep(2000);
		List<WebElement> series_list = login.driver.findElements(
				By.xpath("//ul[@class='search-series-list']//li//div[@class='series-list-item--checkbox-wrapper']"));
		for (int i = 0; i < series_list.size(); i++) {
			Thread.sleep(1000);
			series_list.get(i).click();
			if (i == 4) {
				break;
			}
		}
	}

	@Then("^Footnotes window should be opened$")
	public void footnotes_window_should_be_opened() throws Throwable {
		Thread.sleep(2000);
		CommonFunctionality.footnoteDb = login.driver.findElement(By.className("footnotes-modal--name"));
		Thread.sleep(2000);
		String str = CommonFunctionality.footnoteDb.getText();
		if (str.contains(CommonFunctionality.sname) == true) {
			login.Log4j.info("Footnotes is displayed ");
			Thread.sleep(1500);
			login.driver.findElement(By.className("movable-modal--close")).click();
		} else {
			Thread.sleep(1000);
			login.driver.findElement(By.className("movable-modal--close")).click();
			Assert.fail("Footnotes is not displayed ");
		}
	}

	@Then("^Download button should get enabled$")
	public void download_button_should_get_enabled() throws Throwable {
		Thread.sleep(2000);
		if (login.driver.findElement(By.xpath("//*[@title='Download. Type `d`']")).isEnabled()) {
			login.Log4j.info("The download button is enabled");
		} else {
			Assert.fail("The download button is not enabled");
		}
	}

	@Then("^In search field,'x selected' should appear with edit icon$")
	public void in_search_field_x_selected_should_appear_with_edit_icon() throws Throwable {
		Thread.sleep(3000);
		if (login.driver.findElement(By.xpath("//*[@class='search-input--preview-selection']")).isDisplayed()) {
			login.Log4j.info("PASS");
		} else {
			Assert.fail("FAIL");
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Click on ' v ' icon to expand the series details$")
	public void click_on_v_icon_to_expand_the_series_details() throws Throwable {
		ele = login.driver.findElement(By.xpath("//li[1]//div[@class='series-item--country country-information']"));
		CommonFunctionality.action.moveToElement(ele).pause(2000).click().build().perform();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//li[1]//div[@title='Show related data']")).click();
		login.Log4j.info("Clicking on Show related data icon");
	}

	@Then("^Should display \"([^\"]*)\"$")
	public void should_display(String arg1) throws Throwable {

		String[] arr = arg1.split(",");
		Thread.sleep(3000);
		ele = login.driver.findElement(
				By.xpath("//div[@class='related-series-data--status related-series-data--status__active ']"));
		String str1 = ele.getText();
		ele = login.driver.findElement(By.xpath("//span[@class='related-series-data--link']"));
		String str2 = ele.getText();
		ele = login.driver.findElement(By.xpath(
				"//div[@class='related-series-data--body']//div[@class='related-series-information-portlet'][1]//div[@class='related-series-information-portlet--title']"));
		String str3 = ele.getText();
		try {
			ele = login.driver.findElement(By.xpath(
					"//div[@class='related-series-data--body']//div[@class='related-series-information-portlet'][2]//div[@class='related-series-information-portlet--title']"));
			String str4 = ele.getText();
			if (arr[0].contains(str1) == true && arr[1].equalsIgnoreCase(str2) == true
					&& arr[2].equalsIgnoreCase(str3) == true && arr[3].equalsIgnoreCase(str4) == true) {
				login.Log4j.info("PASS");
			} else {
				Assert.fail("FAIL");
			}
		} catch (Exception e) {
			if (arr[0].contains(str1) == true && arr[1].equalsIgnoreCase(str2) == true
					&& arr[2].equalsIgnoreCase(str3) == true) {
				login.Log4j.info("PASS");
			} else {
				Assert.fail("FAIL");
			}
		}
	}

	@And("^Click on the 'v' icon to expand the dropdown$")
	public void click_on_the_v_icon_to_expand_the_dropdown() throws Throwable {
		Robot robot;
		Thread.sleep(2000);
		login.driver
				.findElement(By.xpath(
						"//ul[@class='search-series-list']//li[1]//div[@class='series-list-item--checkbox-wrapper']"))
				.click();
		Thread.sleep(2000);
		robot = new Robot(); // creating table
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_T);

		Thread.sleep(10000);
		login.driver
				.findElement(By
						.xpath("//ul[@class='search-series-list']//li[1]//div[@class='add-to-data-selection--toggle']"))
				.click();
	}

	@SuppressWarnings("deprecation")
	@And("^Hover the mouse on any series click on dropdown icon$")
	public void hover_the_mouse_on_any_series_click_on_dropdown_icon() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//div[@class='search-presentation-tabs--visible']//span[@title='All']"))
				.click();
		hover_the_mouse_on_any_series();
		ele = login.driver.findElement(By.xpath("//ul//li[1]//div[@class='add-to-data-selection--toggle']"));
		CommonFunctionality.action.moveToElement(ele).pause(2000).click().build().perform();
	}

	@And("^Right click on any series level$")
	public void right_click_on_any_series_level() throws Throwable {
		PopularSeriesMethod();
		CommonFunctionality.RightClickOnAnySeries();
	}

	@And("^Right click on any of the series level$")
	public void right_click_on_any_of_the_series_level() throws Throwable {
		PopularSeriesMethod();
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath("//li[2]//div[@class='series-item--name']"));
		CommonFunctionality.sname = ele.getText();
		CommonFunctionality.action.contextClick(ele).build().perform();
		login.Log4j.info(CommonFunctionality.sname);
	}

	@And("^Click in View More link$")
	public void click_in_View_More_link() throws Throwable {
		PopularSeriesMethod();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='popular-series all-item']//div[contains(text(),'View more')]"))
				.click();
	}

	@Then("^Should be navigated to Series Tab$")
	public void should_be_navigated_to_Series_Tab() throws Throwable {
		Thread.sleep(3000);
		ele = login.driver.findElement(
				By.xpath("//div[@class='search-presentation-tabs--visible']//span[contains(text(),'Series')]"));
		String color = ele.getCssValue("color");
		// login.Log4j.info("Text color is "+color);
		String hex = Color.fromString(color).asHex();
		System.out.println(hex);
		String expected_hex = "#069a9a";
		if (expected_hex.equals(hex)) {
			login.Log4j.info("PASS");
		} else {
			Assert.fail("FAIL");
		}
	}

	@And("^Recently updated datasets should contain max \"([^\"]*)\" datasets$")
	public void recently_updated_datasets_should_contain_max_datasets(String arg1) throws Throwable {
		MaxDatasetsCount = Integer.parseInt(arg1);
		RecentlyUpdatedDatasets();
		VerifyMaxDatasets();
	}

	@And("^Click on View More link for Recently updated datasets$")
	public void click_on_View_More_link_for_Recently_updated_datasets() throws Throwable {
		RecentlyUpdatedDatasets();
		Thread.sleep(3000);
		ele = login.driver.findElement(
				By.xpath("//div[@class='all-representation--content']//div[4]//div[contains(text(),'View more')]"));
		CommonFunctionality.jse.executeScript("arguments[0].scrollIntoView(true);", ele);
		Thread.sleep(2000);
		ele.click();
	}

	@Then("^Should be navigated to Datasets tab$")
	public void should_be_navigated_to_Datasets_tab() throws Throwable {
		Thread.sleep(3000);
		ele = login.driver.findElement(
				By.xpath("//div[@class='search-presentation-tabs--visible']//span[contains(text(),'Datasets')]"));
		String color = ele.getCssValue("color");
		// login.Log4j.info("Text color is "+color);
		String hex = Color.fromString(color).asHex();
		System.out.println(hex);
		String expected_hex = "#069a9a";
		String expected = "Recently Updated";
		String expected1 = "New Series";
		ele = login.driver.findElement(By.xpath(
				"//div[@class='custom-select-title sort-select-title sort-select-title__asc-hidden sort-select-title__desc-hidden']//span[@class='text-dots']"));
		String actual = ele.getText();
		if (expected_hex.equals(hex) == true && expected.equals(actual) == true) {
			login.Log4j.info("PASS");
		} else if (expected_hex.equals(hex) == true && expected1.equals(actual) == true) {
			login.Log4j.info("Navigated to datasets tab");
		} else {
			Assert.fail("FAIL");
		}
	}

	@And("^Click on \\+ box$")
	public void click_on_box() throws Throwable {
		RecentlyUpdatedDatasets();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(
				"//*[@class='data-sets all-item'][1]//*[@class='tree-node data-set-node'][3]//*[@class='toggle']"))
				.click();
	}

	@Then("^The dataset should get expanded$")
	public void the_dataset_should_get_expanded() throws Throwable {
		Thread.sleep(2000);
		list_of_series = login.driver.findElements(
				By.xpath("//ul[@class='search-series-list scrollable']//li//div[@class='series-item--name']"));
		if (list_of_series.size() > 0) {
			login.Log4j.info("The dataset is expanded");
		} else {
			Assert.fail("The dataset is not expanded");
		}
	}

	@And("^Click on - icon$")
	public void click_on_icon() throws Throwable {
		click_on_box();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='tree-node data-set-node open']//div[@class='toggle']"))
				.click();
		Thread.sleep(2000);

	}

	@Then("^The dataset should get collapsed$")
	public void the_dataset_should_get_collapsed() throws Throwable {
		list_of_series = login.driver.findElements(
				By.xpath("//ul[@class='search-series-list scrollable']//li//div[@class='series-item--name']"));
		if (list_of_series.size() == 0) {
			login.Log4j.info("The dataset is collapsed");
		} else {
			Assert.fail("The dataset is not collapsed");
		}
	}

	@And("^Hover the mouse on any of the Datasets$")
	public void hover_the_mouse_on_any_of_the_Datasets() throws Throwable {
		RecentlyUpdatedDatasets();
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath(
				"//div[@class='all-representation--content']//div[1]//div[@class='tree-node data-set-node'][1]//div[@class='series-data-set--table-name']"));
		CommonFunctionality.sname = ele.getText();
		// login.Log4j.info(CommonFunctionality.sname);
		CommonFunctionality.action.moveToElement(ele).build().perform();

	}

	@Then("^\"([^\"]*)\" icons should get displayed$")
	public void icons_should_get_displayed(String arg1) throws Throwable {
		WebElement dropdown;
		String str;
		String[] mouseHoverOptions = arg1.split(",");
		String[] arr = mouseHoverOptions[1].split(" or ");
		Thread.sleep(2000);
		try {
			// with out search
			ele = login.driver.findElement(By.xpath(
					"//div[@class='all-representation--content']//div[4]//div[@class='tree-node data-set-node'][1]//span[@class='actions']//i[@class='actions-item--icon']"));
			str = ele.getAttribute("title");
			dropdown = login.driver.findElement(By.xpath(
					"//div[@class='all-representation--content']//div[4]//div[@class='tree-node data-set-node'][1]//div[@class='add-to-data-selection--title']"));
		} catch (Exception e) {
			// with search[keyword]
			ele = login.driver.findElement(By.xpath(
					"//*[@class='tree-node data-set-node matched'][1]//*[@class='actions']//i[@class='actions-item--icon']"));
			str = ele.getAttribute("title");
			dropdown = login.driver.findElement(By.xpath(
					"//*[@class='tree-node data-set-node matched'][1]//*[@class='add-to-data-selection--title']"));
		}

		String str1 = dropdown.getAttribute("title");
		Thread.sleep(2000);
		if (mouseHoverOptions[0].equalsIgnoreCase(str) == true && str1.contains(arr[0]) == true
				&& str1.contains(arr[1]) == true) {
			login.Log4j.info(mouseHoverOptions[0] + " And " + mouseHoverOptions[1] + " are displayed");
		} else {
			Assert.fail("FAIL");
		}
	}

	@And("^Click on Open footnote icon$")
	public void click_on_Open_footnote_icon() throws Throwable {
		try {
			// RecentlyUpdatedSeries
			Thread.sleep(2000);
			ele = login.driver.findElement(By.xpath(
					"//div[@class='data-sets all-item'][1]//div[@class='tree-node data-set-node'][1]//span[@class='actions']//i[@class='actions-item--icon']"));
			ele.click();
		} catch (Exception e) {
			// New Datasets
			Thread.sleep(2000);
			ele = login.driver.findElement(By.xpath(
					"//div[@class='data-sets all-item'][2]//div[@class='tree-node data-set-node'][1]//span[@class='actions']//i[@class='actions-item--icon']"));
			ele.click();
		}
	}

	@Then("^Footnote window should be opened for the selected datasets$")
	public void footnote_window_should_be_opened_for_the_selected_datasets() throws Throwable {
		footnote_window_should_be_opened_for_the_selected_series();

	}

	@And("^Select any of the datasets$")
	public void select_any_of_the_datasets() throws Throwable {
		RecentlyUpdatedDatasets();
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath(
				"//div[@class='all-representation--content']//div[1]//div[@class='tree-node data-set-node'][1]//span[@class='svg-checkbox']"));
		ele.click();
	}

	@And("^Expand the dataset$")
	public void expand_the_dataset() throws Throwable {
		click_on_box();
	}

	@And("^Click on 'v' icon for a series to display details$")
	public void click_on_v_icon_for_a_series_to_display_details() throws Throwable {
		Thread.sleep(2000);

		ele = login.driver.findElement(By.xpath(
				"//ul[@class='search-series-list scrollable']//li[1]//div[@class='series-item--country country-information']"));
		CommonFunctionality.action.moveToElement(ele).build().perform();
		Thread.sleep(2000);
		login.driver
				.findElement(By
						.xpath("//ul[@class='search-series-list scrollable']//li[1]//div[@title='Show related data']"))
				.click();
		login.Log4j.info("Clicking on Show related data icon");

	}

	@And("^Click on '\\+' icon$")
	public void click_on_icon1() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@title='Create new View tab']")).click();
		Thread.sleep(2000);
		List<WebElement> list = login.driver
				.findElements(By.xpath("//ul[contains(@class,'search-series-list scrollable')]//li"));
		for (int i = 0; i < list.size(); i++) {
			int j = i + 2;
			Thread.sleep(2000);
			WebElement checkbox = login.driver
					.findElement(By.xpath("//ul[contains(@class,'search-series-list scrollable')]//li[" + j
							+ "]//div[@class='series-list-item--checkbox-wrapper']"));
			checkbox.click();
			ele = login.driver.findElement(By.xpath("//ul[contains(@class,'search-series-list scrollable')]//li[" + j
					+ "]//div[@class='series-item--name']"));
			String str = ele.getText();
			sname.add(str);
			login.Log4j.info(sname);
			if (i == 1) {
				Thread.sleep(1000);
				login.driver.findElement(By.xpath(
						"//ul[contains(@class,'search-series-list scrollable')]//li[3]//div[@class='add-to-data-selection--icon']"))
						.click();
				break;
			}
		}
	}

	@And("^Click on '\\+' icon for series level$")
	public void click_on_icon_for_series_level() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@title='Create new View tab']")).click();
		Thread.sleep(2000);
		List<WebElement> list = login.driver.findElements(By.xpath("//ul[contains(@class,'search-series-list')]//li"));
		for (int i = 0; i < list.size(); i++) {
			int j = i + 2;
			Thread.sleep(2000);
			WebElement checkbox = login.driver.findElement(By.xpath("//ul[contains(@class,'search-series-list')]//li["
					+ j + "]//div[@class='series-list-item--checkbox-wrapper']"));
			checkbox.click();
			ele = login.driver.findElement(By.xpath(
					"//ul[contains(@class,'search-series-list')]//li[" + j + "]//div[@class='series-item--name']"));
			String str = ele.getText();
			sname.add(str);
			login.Log4j.info(sname);
			if (i == 1) {
				Thread.sleep(1000);
				login.driver.findElement(By.xpath(
						"//ul[contains(@class,'search-series-list')]//li[3]//div[@class='add-to-data-selection--icon']"))
						.click();
				break;
			}
		}
	}

	@Then("^The selected series should get added to the visual in focus$")
	public void the_selected_series_should_get_added_to_the_visual_in_focus() throws Throwable {
		Thread.sleep(2000);
		List<WebElement> legend_list = login.driver.findElements(By.xpath(
				"//div[@class='highcharts-legend']//div[1]//div[1]//div//div//span[@class='series-edit--title']"));
		login.Log4j.info(legend_list.size());
		for (int i = 0; i < legend_list.size(); i++) {
			int j = i + 1;
			Thread.sleep(2000);
			ele = login.driver.findElement(By.xpath("//div[@class='highcharts-legend']//div[1]//div[1]//div[" + j
					+ "]//div//span[@class='series-edit--title']"));
			CommonFunctionality.action.moveToElement(ele).build().perform();
			Tooltip_split();
			// login.Log4j.info(str);
			ele = login.driver.findElement(By.xpath("//div[@class='text-dots']"));
			CommonFunctionality.action.moveToElement(ele).build().perform();
			if (sname.contains(str) == true) {
				login.Log4j.info(str + " added to visual");

			} else if (CommonFunctionality.sname.contains(str) == true) {
				login.Log4j.info(str + " added to visual");
			} else {
				Assert.fail("FAIL");
			}
		}
		sname.clear();
		// login.Log4j.info(sname);
		CommonFunctionality.Views_list();
	}

	@And("^Click on the v to expand the dropdown$")
	public void click_on_the_v_to_expand_the_dropdown() throws Throwable {
		Robot robot;
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(
				"//ul[@class='search-series-list scrollable']//li[1]//div[@class='series-list-item--checkbox-wrapper']"))
				.click();
		Thread.sleep(2000);
		robot = new Robot(); // creating table
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_T);

		Thread.sleep(10000);
		login.driver.findElement(By.xpath(
				"//ul[@class='search-series-list scrollable']//li[1]//div[@class='add-to-data-selection--toggle']"))
				.click();
	}

	@And("^Create a visual$")
	public void create_a_visual() throws Throwable {
		Thread.sleep(2000);
		List<WebElement> list = login.driver.findElements(By.xpath("//ul[@class='search-series-list scrollable']//li"));
		for (int i = 0; i < list.size(); i++) {
			int j = i + 1;
			Thread.sleep(2000);
			checkbox = login.driver.findElement(By.xpath("//ul[@class='search-series-list scrollable']//li[" + j
					+ "]//div[@class='series-list-item--checkbox-wrapper']"));
			checkbox.click();
			ele = login.driver.findElement(By.xpath(
					"//ul[@class='search-series-list scrollable']//li[" + j + "]//div[@class='series-item--name']"));
			String str = ele.getText();
			Add_replce.add(str);

			if (i == 1) {
				// CommonFunctionality.action.moveToElement(checkbox).build().perform();
				// Thread.sleep(2000);
				login.driver.findElement(By.xpath("//ul[@class='search-series-list scrollable']//li[" + j
						+ "]//span[@title='View as Chart. Type `c`']")).click();
				break;
			}
		}
	}

	@And("^Expand the dataset and select \"([^\"]*)\" option$")
	public void expand_the_dataset_and_select_option(String arg1) throws Throwable {
		click_on_box();
		SelectAddtoExistingInsight();
	}

	@And("^Click on \"([^\"]*)\" option from dropdown$")
	public void click_on_option_from_dropdown(String arg1) throws Throwable {
		Thread.sleep(1000);
		List<WebElement> list = login.driver
				.findElements(By.xpath("//ul[contains(@class,'search-series-list scrollable')]//li"));
		for (int i = 0; i < list.size(); i++) {
			int j = i + 3;
			Thread.sleep(2000);
			checkbox = login.driver.findElement(By.xpath("//ul[contains(@class,'search-series-list scrollable')]//li["
					+ j + "]//div[@class='series-list-item--checkbox-wrapper']"));
			checkbox.click();
			ele = login.driver.findElement(By.xpath("//ul[contains(@class,'search-series-list scrollable')]//li[" + j
					+ "]//div[@class='series-item--name']"));
			CommonFunctionality.sname = ele.getText();
			sname.add(CommonFunctionality.sname);

			if (i == 1) {
				CommonFunctionality.action.moveToElement(checkbox).build().perform();
				Thread.sleep(2000);
				login.driver.findElement(By.xpath("//ul[contains(@class,'search-series-list scrollable')]//li[" + j
						+ "]//div[@class='add-to-data-selection--toggle']")).click();
				Thread.sleep(1000);
				if (arg1.equals("Add")) {
					login.driver.findElement(By.xpath("//div[@class='items-wrapper']//li[1]//span[2]")).click();
				} else if (arg1.equals("Add and replace")) {
					login.driver.findElement(By.xpath("//div[@class='items-wrapper']//li[2]//span[2]")).click();
				} else if (arg1.equals("Add and group")) {
					login.driver.findElement(By.xpath("//div[@class='items-wrapper']//li[3]//span[2]")).click();
				} else if (arg1.equals("Add to new insight")) {
					login.driver.findElement(By.xpath("//div[@class='items-wrapper']//li[5]//span//span")).click();
				}

				break;
			}
		}
	}

	@Then("^The selected series should replace the series in the visual in the focus$")
	public void the_selected_series_should_replace_the_series_in_the_visual_in_the_focus() throws Throwable {
		Thread.sleep(2000);
		List<WebElement> legend_list = login.driver.findElements(By.xpath(
				"//div[@class='highcharts-legend']//div[1]//div[1]//div//div//span[@class='series-edit--title']"));
		for (int i = 0; i < legend_list.size(); i++) {
			int j = i + 1;
			Thread.sleep(2000);
			ele = login.driver.findElement(By.xpath("//div[@class='highcharts-legend']//div[1]//div[1]//div[" + j
					+ "]//div//span[@class='series-edit--title']"));
			CommonFunctionality.action.moveToElement(ele).build().perform();
			Tooltip_split();
			// login.Log4j.info(sname);
			ele = login.driver.findElement(By.xpath("//div[@class='text-dots']"));
			CommonFunctionality.action.moveToElement(ele).build().perform();
			if (Add_replce.contains(str) != true) {
				login.Log4j.info("Replaced with the series : " + str);
			} else {
				CommonFunctionality.Views_list();
				Assert.fail("FAIL");
			}
		}
		sname.clear();
		CommonFunctionality.Views_list();

	}

	@Then("^The selected series should get grouped in My Series$")
	public void the_selected_series_should_get_grouped_in_My_Series() throws Throwable {
		Thread.sleep(3000);
		if (login.driver.findElement(By.className("group-name")).isDisplayed()) {
			login.Log4j.info("PASS");
		} else {
			Assert.fail("The selected series doesn't grouped in My Series");
		}
		CommonFunctionality.DeleteSeries();
	}

	@Then("^The selected series should get added to the new insight$")
	public void the_selected_series_should_get_added_to_the_new_insight() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("confirm_popup_new_insight"))).click();
		login.robot = new Robot();
		// Store all currently open tabs in tabs
		ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
		// Navigate to New Tab
		login.driver.switchTo().window(tabs2.get(1));
		Thread.sleep(3000);
		AddtoNewInsight();
		login.driver.close();
		login.driver.switchTo().window(tabs2.get(0));

	}

	@And("^Expand the dataset and right click on any series$")
	public void expand_the_dataset_and_right_click_on_any_series() throws Throwable {
		click_on_box();
		VerifyRightClickOnAnySeries();
	}

	@And("^Observe column for no of series for each Dataset$")
	public void observe_column_for_no_of_series_for_each_Dataset() throws Throwable {
		CommonFunctionality.ExpandRight();
		RecentlyUpdatedDatasets();
		VerifySeriesColumn();
	}

	@And("^Observe column for updated Date for each Dataset$")
	public void observe_column_for_updated_Date_for_each_Dataset() throws Throwable {
		CommonFunctionality.ExpandRight();
		RecentlyUpdatedDatasets();
		VerifyDateColumn();
	}

	@And("^Click on View tab$")
	public void click_on_View_tab() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@title='Create new View tab']")).click();
	}

	@And("^Observe the contents of the New Datasets section$")
	public void observe_the_contents_of_the_New_Datasets_section() throws Throwable {
		NewDatasets();

	}

	@Then("^There should be \"([^\"]*)\" new datasets displayed by default at max$")
	public void there_should_be_new_datasets_displayed_by_default_at_max(String arg1) throws Throwable {
		Thread.sleep(2000);
		int NewDatasetsCount = Integer.parseInt(arg1);
		List<WebElement> list = login.driver
				.findElements(By.xpath("//div[@class='data-sets all-item'][2]//div[@class='tree-node data-set-node']"));
		int list_of_datasets = list.size();
		if (NewDatasetsCount == list_of_datasets) {
			login.Log4j.info("PASS");
		} else {
			Assert.fail("10 new datasets are not displayed");
		}
	}

	@And("^Click on View more link$")
	public void click_on_View_more_link() throws Throwable {
		NewDatasets();
		Thread.sleep(2000);
		ele = login.driver.findElement(
				By.xpath("//div[@class='data-sets all-item'][2]//div[@class='all-item--view-more-title']"));
		CommonFunctionality.jse.executeScript("arguments[0].scrollIntoView(true);", ele);
		Thread.sleep(2000);
		ele.click();
	}

	@And("^Click on \\+ box for New datasets$")
	public void click_on_box_for_New_datasets() throws Throwable {
		NewDatasets();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(
				"//div[@class='data-sets all-item'][2]//div[@class='tree-node data-set-node'][1]//div[@class='toggle']"))
				.click();
	}

	@And("^Click on - icon for New datasets$")
	public void click_on_icon_for_New_datasets() throws Throwable {
		click_on_box_for_New_datasets();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='tree-node data-set-node open']//div[@class='toggle']"))
				.click();

	}

	@And("^Hover the mouse on any of the Datasets for New datasets$")
	public void hover_the_mouse_on_any_of_the_Datasets_for_New_datasets() throws Throwable {
		NewDatasets();
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath(
				"//div[@class='data-sets all-item'][2]//div[@class='tree-node data-set-node'][1]//div[@class='series-data-set--table-name']"));
		CommonFunctionality.sname = ele.getText();
		// login.Log4j.info(CommonFunctionality.sname);
		CommonFunctionality.action.moveToElement(ele).build().perform();
	}

	@And("^Select any of the datasets for New datasets$")
	public void select_any_of_the_datasets_for_New_datasets() throws Throwable {
		NewDatasets();
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath(
				"//div[@class='data-sets all-item'][2]//div[@class='tree-node data-set-node'][1]//span[@class='svg-checkbox']"));
		ele.click();
	}

	@And("^Expand the dataset for New datasets$")
	public void expand_the_dataset_for_New_datasets() throws Throwable {
		click_on_box_for_New_datasets();
	}

	@And("^Expand the dataset for New datasets and select \"([^\"]*)\" option$")
	public void expand_the_dataset_for_New_datasets_and_select_option(String arg1) throws Throwable {
		click_on_box_for_New_datasets();
		SelectAddtoExistingInsight();
	}

	@And("^Expand the dataset for New datasets and right click on any series$")
	public void expand_the_dataset_for_New_datasets_and_right_click_on_any_series() throws Throwable {
		click_on_box_for_New_datasets();
		VerifyRightClickOnAnySeries();
	}

	@And("^Observe column for no of series for each Dataset under NewDatasets$")
	public void observe_column_for_no_of_series_for_each_Dataset_under_NewDatasets() throws Throwable {
		CommonFunctionality.ExpandRight();
		NewDatasets();
		VerifySeriesColumn();
	}

	@And("^Observe column for updated Date for each Dataset under NewDatasets$")
	public void observe_column_for_updated_Date_for_each_Dataset_under_NewDatasets() throws Throwable {
		CommonFunctionality.ExpandRight();
		NewDatasets();
		VerifyDateColumn();
	}

	@And("^Select few series in any of the sections$")
	public void select_few_series_in_any_of_the_sections() throws Throwable {
		click_on_box_for_New_datasets();
		CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//ul[@class='search-series-list scrollable']//li[1]//div[@class='series-list-item--checkbox-wrapper']")))
				.click();
	}

	@Then("^Unselect link should be displayed at the top with red color font$")
	public void unselect_link_should_be_displayed_at_the_top_with_red_color_font() throws Throwable {
		UnselectLink();
		if (unselect.isDisplayed()) {
			login.Log4j.info("Unselect link is displayed");
		} else {
			Assert.fail("Unselect link is not displayed");
		}
	}

	@And("^Click in the Unselect link$")
	public void click_in_the_Unselect_link() throws Throwable {
		select_few_series_in_any_of_the_sections();
		CommonFunctionality.TopMethod();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unselect"))).click();
	}

	@Then("^The series / datasets selection should get cleared off$")
	public void the_series_datasets_selection_should_get_cleared_off() throws Throwable {
		CommonFunctionality.SelectedSeriesClear();
	}

	@And("^Explore Datasets should contain max \"([^\"]*)\" datasets$")
	public void explore_Datasets_should_contain_max_datasets(String arg1) throws Throwable {
		MaxDatasetsCount = Integer.parseInt(arg1);
		ExploreDatasets();
		VerifyMaxDatasets();
	}

	@And("^Search keyword with \"([^\"]*)\"$")
	public void search_keyword_with(String arg1) throws Throwable {
		CommonFunctionality.wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Search"))));
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).clear();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys(arg1);

	}

	@And("^Click on View More link for Explore datasets$")
	public void click_on_View_More_link_for_Explore_datasets() throws Throwable {
		ExploreDatasets();
		Thread.sleep(3000);
		ele = login.driver.findElement(
				By.xpath("//div[@class='all-representation--content']//div[3]//div[contains(text(),'View more')]"));
		CommonFunctionality.jse.executeScript("arguments[0].scrollIntoView(true);", ele);
		Thread.sleep(2000);
		ele.click();
	}

	@Then("^User Should be navigated to Datasets tab$")
	public void user_Should_be_navigated_to_Datasets_tab() throws Throwable {
		WebElement datasets = CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='search-presentation-tabs--visible']//span[contains(text(),'Datasets')]")));
		if (datasets.isDisplayed()) {
			login.Log4j.info("Navigated to Datasets tab");
		} else {
			Assert.fail("it's not navigated to Datasets tab");
		}
	}

	@And("^Click on \\+ box for Explore datasets$")
	public void click_on_box_for_Explore_datasets() throws Throwable {
		ExploreDatasets();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//*[@class='tree-node data-set-node matched'][1]//*[@class='toggle']"))
				.click();
	}

	@And("^Click on - icon for Explore datasets$")
	public void click_on_icon_for_Explore_datasets() throws Throwable {
		click_on_box_for_Explore_datasets();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//*[@class='tree-node data-set-node matched open']//*[@class='toggle']"))
				.click();
		Thread.sleep(2000);
	}

	@And("^Hover the mouse on any of the Datasets under Explore datasets$")
	public void hover_the_mouse_on_any_of_the_Datasets_under_Explore_datasets() throws Throwable {
		ExploreDatasets();
		Thread.sleep(2000);
		ele = login.driver.findElement(
				By.xpath("//*[@class='tree-node data-set-node matched'][1]//*[@class='series-data-set--table-name']"));
		CommonFunctionality.sname = ele.getText();
		// login.Log4j.info(CommonFunctionality.sname);
		CommonFunctionality.action.moveToElement(ele).build().perform();
	}

	@And("^Click on Open footnote icon for Explore datasets$")
	public void click_on_Open_footnote_icon_for_Explore_datasets() throws Throwable {
		try {
			// ExploreDatasets
			Thread.sleep(2000);
			ele = login.driver.findElement(By.xpath(
					"//*[@class='tree-node data-set-node matched'][1]//*[@class='actions']//i[@class='actions-item--icon']"));
			ele.click();
		} catch (Exception e) {
			// Explore Series
			Thread.sleep(2000);
			ele = login.driver.findElement(By.xpath(
					"//div[@class='all-representation--content']//div[5]//div[@class='tree-node data-set-node'][1]//span[@class='actions']//i[@class='actions-item--icon']"));
			ele.click();
		}

	}

	@And("^Select any of the Explore datasets$")
	public void select_any_of_the_Explore_datasets() throws Throwable {
		ExploreDatasets();
		Thread.sleep(2000);
		ele = login.driver
				.findElement(By.xpath("//*[@class='tree-node data-set-node matched'][1]//*[@class='svg-checkbox']"));
		ele.click();
	}

	@And("^Expand the dataset from Explore datasets$")
	public void expand_the_dataset_from_Explore_datasets() throws Throwable {
		click_on_box_for_Explore_datasets();
	}

	@And("^Expand the dataset from Explore datasets and select \"([^\"]*)\" option$")
	public void expand_the_dataset_from_Explore_datasets_and_select_option(String arg1) throws Throwable {
		click_on_box_for_Explore_datasets();
		SelectAddtoExistingInsight();
	}

	@And("^Expand the dataset from Explore datasets and right click on any series$")
	public void expand_the_dataset_from_Explore_datasets_and_right_click_on_any_series() throws Throwable {
		click_on_box_for_Explore_datasets();
		VerifyRightClickOnAnySeries();
	}

	@And("^Observe column for no of series for each Dataset under Explore dataset$")
	public void observe_column_for_no_of_series_for_each_Dataset_under_Explore_dataset() throws Throwable {
		CommonFunctionality.ExpandRight();
		ExploreDatasets();
		VerifySeriesColumn_ExploreDatasets();
	}

	@And("^Observe column for updated Date for each Dataset under Explore dataset$")
	public void observe_column_for_updated_Date_for_each_Dataset_under_Explore_dataset() throws Throwable {
		CommonFunctionality.ExpandRight();
		ExploreDatasets();
		VerifyDateColumn_Exploredataset();
	}

	@And("^\"([^\"]*)\" explore series should be displayed by default$")
	public void explore_series_should_be_displayed_by_default(String arg1) throws Throwable {

		int exploreSeriesCount = Integer.parseInt(arg1);
		ExploreSeries();
		DefaultSeries(exploreSeriesCount);
	}

	@And("^Hover the mouse on any series under explore series$")
	public void hover_the_mouse_on_any_series_under_explore_series() throws Throwable {
		ExploreSeries();
		mouseHoverOnseries();
	}

	@And("^Hover the mouse on any series level under explore series$")
	public void hover_the_mouse_on_any_series_level_under_explore_series() throws Throwable {
		CommonFunctionality.UnselectMethod();
		ExploreSeries();
		Thread.sleep(2000);
		List<WebElement> series_list = login.driver.findElements(
				By.xpath("//ul[@class='search-series-list']//li//div[@class='series-list-item--checkbox-wrapper']"));
		for (int i = 0; i < series_list.size(); i++) {
			Thread.sleep(1000);
			series_list.get(i).click();
			if (i == 4) {
				break;
			}
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Hover the mouse on any series under explore series and click on dropdown icon$")
	public void hover_the_mouse_on_any_series_under_explore_series_and_click_on_dropdown_icon() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//div[@class='search-presentation-tabs--visible']//span[@title='All']"))
				.click();
		hover_the_mouse_on_any_series_under_explore_series();
		ele = login.driver.findElement(By.xpath("//ul//li[1]//div[@class='add-to-data-selection--toggle']"));
		CommonFunctionality.action.moveToElement(ele).pause(2000).click().build().perform();
	}

	@And("^Right click on any Explore series$")
	public void right_click_on_any_Explore_series() throws Throwable {
		ExploreSeries();
		CommonFunctionality.RightClickOnAnySeries();
	}

	@And("^Click in View More link for Explore series$")
	public void click_in_View_More_link_for_Explore_series() throws Throwable {
		ExploreSeries();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//*[@class='explore-series all-item']//div[contains(text(),'View more')]"))
				.click();
	}

	@And("^Explore Releases section should contain max \"([^\"]*)\" datasets$")
	public void explore_Releases_section_should_contain_max_datasets(String arg1) throws Throwable {
		MaxDatasetsCount = Integer.parseInt(arg1);
		ExploreReleases();
		VerifyMaxDatasets();
	}

	@And("^Click on \\+ box under Explore releases$")
	public void click_on_box_under_Explore_releases() throws Throwable {
		ExploreReleases();
		ele = CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@class='explore-releases--content']//*[@class='tree-node release-scheduler-tree-node'][1]//*[@class='toggle']")));
		Thread.sleep(2000);
		ele.click();
	}

	@And("^Click on - icon under Explore releases$")
	public void click_on_icon_under_Explore_releases() throws Throwable {

		click_on_box_under_Explore_releases();
		Thread.sleep(2000);
		login.driver
				.findElement(By.xpath("//*[@class='tree-node release-scheduler-tree-node open']//*[@class='toggle']"))
				.click();

	}

	@And("^Hover the mouse on any of the Datasets unser Explore releases$")
	public void hover_the_mouse_on_any_of_the_Datasets_unser_Explore_releases() throws Throwable {
		ExploreReleases();
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath(
				"//*[@class='explore-releases--content']//*[@class='tree-node release-scheduler-tree-node'][1]//*[@class='release-scheduler-tree-node--title']"));
		CommonFunctionality.sname = ele.getText();
		// login.Log4j.info(CommonFunctionality.sname);
		CommonFunctionality.action.moveToElement(ele).build().perform();
	}

	@Then("^\"([^\"]*)\" icon should get displayed$")
	public void icon_should_get_displayed(String arg1) throws Throwable {
		WebElement dropdown = login.driver.findElement(
				By.xpath("//*[@class='tree-node data-set-node matched'][1]//*[@class='add-to-data-selection--title']"));
		String str1 = dropdown.getAttribute("title");
		Thread.sleep(2000);
		if (str1.contains(arg1) == true) {
			login.Log4j.info(arg1 + " is displayed");
		} else {
			Assert.fail("FAIL");
		}
	}

	@And("^Select any of the datasets under Explore releases$")
	public void select_any_of_the_datasets_under_Explore_releases() throws Throwable {
		ExploreReleases();
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath(
				"//*[@class='tree-node release-scheduler-tree-node'][1]//*[@class='release-scheduler-tree-node--checker svg-checkbox']"));
		ele.click();
	}

	@And("^Expand any dataset under Explore releases$")
	public void expand_any_dataset_under_Explore_releases() throws Throwable {
		click_on_box_under_Explore_releases();
	}

	@And("^Expand any dataset under Explore releases and select \"([^\"]*)\" option$")
	public void expand_any_dataset_under_Explore_releases_and_select_option(String arg1) throws Throwable {
		click_on_box_under_Explore_releases();
		SelectAddtoExistingInsight();
	}

	@And("^Expand any dataset under Explore releases and right click on any series$")
	public void expand_any_dataset_under_Explore_releases_and_right_click_on_any_series() throws Throwable {
		click_on_box_under_Explore_releases();
		VerifyRightClickOnAnySeries();
	}

	/*
	 * @And("^Observe column for no of series for each Dataset under Explore releases$"
	 * ) public void
	 * observe_column_for_no_of_series_for_each_Dataset_under_Explore_releases()
	 * throws Throwable { CommonFunctionality.ExpandRight(); ExploreReleases();
	 * VerifySeriesColumn_ExploreDatasets();
	 * 
	 * }
	 * 
	 * @And("^Observe column for updated Date for each Dataset under Explore releases$"
	 * ) public void
	 * observe_column_for_updated_Date_for_each_Dataset_under_Explore_releases()
	 * throws Throwable { CommonFunctionality.ExpandRight(); ExploreReleases();
	 * VerifyDateColumn_Exploredataset(); }
	 */
	@And("^Select few series in any of the sections for releases$")
	public void select_few_series_in_any_of_the_sections_for_releases() throws Throwable {
		click_on_box_under_Explore_releases();
		CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//ul[@class='search-series-list scrollable']//li[1]//div[@class='series-list-item--checkbox-wrapper']")))
				.click();
	}

	@And("^Observe columns for release date and observation date$")
	public void observe_columns_for_release_date_and_observation_date() throws Throwable {
		CommonFunctionality.ExpandRight();
		ExploreReleases();
		VerifyReleaseDate();
		VerifyObservationDate();
	}

	void DefaultSeries(int Count) throws Exception {
		List<WebElement> SeriesCount = CommonFunctionality.wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".series-item--name")));
		int list_of_series = SeriesCount.size();
		if (Count == list_of_series) {
			login.Log4j.info("PASS");
		} else {
			Assert.fail("10 series are not displayed By default");
		}
	}

	void AllInsightsValidation() throws InterruptedException {
		WebElement Gallery = CommonFunctionality.wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-type='gallery']")));
		if (Gallery.isDisplayed()) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//*[@class='sphere-modal__close']")).click();
		} else {
			Assert.fail("Insight Explorer page is not navigated");
		}
	}

	void EMISInsightsValidation() throws InterruptedException {
		WebElement emis = CommonFunctionality.wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-type='emis']")));
		if (emis.isDisplayed()) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//*[@class='sphere-modal__close']")).click();
		} else {
			Assert.fail("Insight Explorer page is not navigated");
		}
	}

	static void PopularSeriesMethod() throws InterruptedException {

		ele = CommonFunctionality.wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Popular Series')]")));
		CommonFunctionality.jse.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

	static void TotalUsageValidation() throws InterruptedException {
		Thread.sleep(1500);
		login.driver.findElement(By.xpath(
				"//div[@class='all-representation--content']//div[@class='popular-series all-item']//div[contains(text(),'View more')]"))
				.click();
		WebElement popularity = CommonFunctionality.wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Popularity')]")));
		if (popularity.isDisplayed()) {
			login.Log4j.info("PASS");
		} else {
			Assert.fail("Popularity is not displayed");
		}
	}

	static void RecentlyUpdatedDatasets() throws InterruptedException {
		ele = CommonFunctionality.wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Recently Updated Datasets')]")));
		CommonFunctionality.jse.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

	static void NewDatasets() throws InterruptedException {
		ele = CommonFunctionality.wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'New Datasets')]")));
		CommonFunctionality.jse.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

	void ExploreDatasets() throws Exception {
		ele = CommonFunctionality.wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Explore Datasets')]")));
		CommonFunctionality.jse.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

	void ExploreSeries() {
		ele = CommonFunctionality.wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(("//*[contains(text(),'Explore Series')]"))));
		CommonFunctionality.jse.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

	void ExploreReleases() {
		ele = CommonFunctionality.wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Explore Releases')]")));
		CommonFunctionality.jse.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

	void VerifyMaxDatasets() throws Exception {
		List<WebElement> list = CommonFunctionality.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//*[@class='data-sets all-item'][1]//*[@class='tree-node data-set-node']")));
		int list_of_datasets = list.size();
		if (MaxDatasetsCount == list_of_datasets || list_of_datasets < MaxDatasetsCount) {
			login.Log4j.info("MaxDatasets count is " + list_of_datasets);
		} else {
			Assert.fail("Max datasets are not displayed");
		}
	}

	static void AddtoNewInsight() throws InterruptedException {
		List<WebElement> Serieslist = CommonFunctionality.wait.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='series-name-field']")));
		login.Log4j.info(Serieslist.size());
		for (int i = 0; i < Serieslist.size(); i++) {
			int j = i + 1;
			Thread.sleep(1000);
			ele = login.driver.findElement(
					By.xpath("//*[@class='webix_column list-series-name webix_last']//*[contains(@class,'webix_cell')]["
							+ j + "]//*[@class='series-name-field--series-name']"));
			CommonFunctionality.sname = ele.getText();
			login.Log4j.info(sname);
			login.Log4j.info(CommonFunctionality.sname);
			if (sname.contains(CommonFunctionality.sname) == true) {
				login.Log4j.info(CommonFunctionality.sname + " exists in " + sname);
			} else {
				Assert.fail("FAIL");
			}
		}
		CommonFunctionality.DeleteSeries();
	}

	static void VerifyRightClickOnAnySeries() throws Exception {

		List<WebElement> list = CommonFunctionality.wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='search-series-list scrollable']//li")));
		for (int i = 0; i < list.size(); i++) {
			int j = i + 1;
			Thread.sleep(2000);
			checkbox = login.driver.findElement(By.xpath("//ul[@class='search-series-list scrollable']//li[" + j
					+ "]//div[@class='series-list-item--checkbox-wrapper']"));
			checkbox.click();
			ele = login.driver.findElement(By.xpath(
					"//ul[@class='search-series-list scrollable']//li[" + j + "]//div[@class='series-item--name']"));
			CommonFunctionality.sname = ele.getText();
			sname.add(CommonFunctionality.sname);
			if (i == 1) {
				CommonFunctionality.action.contextClick(ele).build().perform();
				break;
			}
		}
	}

	static void VerifySeriesColumn() throws Exception {

		List<WebElement> list_of_datasets = CommonFunctionality.wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
						"//div[@class='data-sets all-item'][1]//div[2]//div[@class='tree-node data-set-node']")));
		for (int i = 0; i < list_of_datasets.size(); i++) {
			int j = i + 1;
			Thread.sleep(1000);
			ele = login.driver.findElement(
					By.xpath("//div[@class='data-sets all-item'][1]//div[2]//div[@class='tree-node data-set-node'][" + j
							+ "]//div[@class='data-set-node--count']"));
			CommonFunctionality.action.moveToElement(ele).build().perform();
			if (ele.isDisplayed()) {
				login.Log4j.info("no.of series column is displayed for each dataset");
			} else {
				Assert.fail("FAIL");
			}
		}
	}

	void VerifySeriesColumn_ExploreDatasets() throws Exception {

		List<WebElement> list_of_datasets = CommonFunctionality.wait.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='data-set-node--count']")));
		for (int i = 0; i < list_of_datasets.size(); i++) {
			int j = i + 1;
			Thread.sleep(1000);
			ele = login.driver.findElement(By.xpath(
					"//*[@class='tree-node data-set-node matched'][" + j + "]//*[@class='data-set-node--count']"));
			CommonFunctionality.action.moveToElement(ele).build().perform();
			if (ele.isDisplayed()) {
				login.Log4j.info("no.of series column is displayed for each dataset");
			} else {
				Assert.fail("FAIL");
			}
		}
	}

	void VerifyDateColumn_Exploredataset() throws Exception {

		List<WebElement> list_of_datasets = CommonFunctionality.wait.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='data-set-node--updated']")));
		for (int i = 0; i < list_of_datasets.size(); i++) {
			int j = i + 1;
			Thread.sleep(1000);
			ele = login.driver.findElement(By.xpath(
					"//*[@class='tree-node data-set-node matched'][" + j + "]//*[@class='data-set-node--updated']"));
			CommonFunctionality.action.moveToElement(ele).build().perform();
			if (ele.isDisplayed()) {
				login.Log4j.info("Updated column is displayed for each dataset");
			} else {
				Assert.fail("FAIL");
			}
		}
	}

	void VerifyReleaseDate() throws Exception {
		List<WebElement> list_of_datasets = CommonFunctionality.wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='release-scheduler-tree-node--release-date']")));
		for (int i = 0; i < list_of_datasets.size(); i++) {
			int j = i + 1;
			Thread.sleep(1000);
			ele = login.driver.findElement(By
					.xpath("//*[@class='explore-releases--content']//*[@class='tree-node release-scheduler-tree-node']["
							+ j + "]//*[@class='release-scheduler-tree-node--release-date']"));
			CommonFunctionality.action.moveToElement(ele).build().perform();
			if (ele.isDisplayed()) {
				System.out.print("\nReleased date column is displayed for each dataset");
			} else {
				Assert.fail("Verification is failed");
			}
		}
	}

	void VerifyObservationDate() throws Exception {
		List<WebElement> list_of_datasets = CommonFunctionality.wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='release-scheduler-tree-node--last-obs']")));
		for (int i = 0; i < list_of_datasets.size(); i++) {
			int j = i + 1;
			Thread.sleep(1000);
			ele = login.driver.findElement(By
					.xpath("//*[@class='explore-releases--content']//*[@class='tree-node release-scheduler-tree-node']["
							+ j + "]//*[@class='release-scheduler-tree-node--last-obs']"));
			CommonFunctionality.action.moveToElement(ele).build().perform();
			if (ele.isDisplayed()) {
				login.Log4j.info("Observation date column is displayed for each dataset");
			} else {
				Assert.fail("Verification is failed");
			}
		}
	}

	static void VerifyDateColumn() throws Exception {

		List<WebElement> list_of_datasets = CommonFunctionality.wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
						"//div[@class='data-sets all-item'][1]//div[2]//div[@class='tree-node data-set-node']")));
		for (int i = 0; i < list_of_datasets.size(); i++) {
			int j = i + 1;
			Thread.sleep(1000);
			ele = login.driver.findElement(
					By.xpath("//div[@class='data-sets all-item'][1]//div[2]//div[@class='tree-node data-set-node'][" + j
							+ "]//div[@class='data-set-node--updated']"));
			CommonFunctionality.action.moveToElement(ele).build().perform();
			if (ele.isDisplayed()) {
				login.Log4j.info("Updated column is displayed for each dataset");
			} else {
				Assert.fail("FAIL");
			}
		}
	}

	static void UnselectLink() {
		unselect = CommonFunctionality.wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("unselect"))));
		CommonFunctionality.jse.executeScript("arguments[0].scrollIntoView(true);", unselect);
	}

	void SelectAddtoExistingInsight() throws Exception {
		checkbox = login.driver.findElement(By.xpath(
				"//ul[@class='search-series-list scrollable']//li[3]//div[@class='series-list-item--checkbox-wrapper']"));
		checkbox.click();
		ele = login.driver.findElement(
				By.xpath("//ul[@class='search-series-list scrollable']//li[3]//div[@class='series-item--name']"));
		CommonFunctionality.sname = ele.getText();
		Thread.sleep(1000);
		CommonFunctionality.action.moveToElement(checkbox).build().perform();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(
				"//ul[@class='search-series-list scrollable']//li[3]//div[@class='add-to-data-selection--toggle']"))
				.click();
		login.driver.findElement(By.xpath("//div[@class='items-wrapper']//li[6]//span//span")).click();
	}

	void mouseHoverOnseries() throws Exception {
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath("//li[1]//*[@class='series-item--name']"));
		CommonFunctionality.action.moveToElement(ele).build().perform();
		CommonFunctionality.sname = ele.getText();
		// login.Log4j.info(CommonFunctionality.sname);
	}

	void Tooltip_split() throws Exception {
		String[] arr;
		Thread.sleep(1000);
		WebElement tooltip = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text")));
		String text = tooltip.getText();
		String[] lines = text.split("\n");
		for (String Tooltip : lines) {
			if (Tooltip.contains("Name")) {
				arr = Tooltip.split("Name:");
				str = arr[1].trim();
				break;
			}
		}
	}
}
