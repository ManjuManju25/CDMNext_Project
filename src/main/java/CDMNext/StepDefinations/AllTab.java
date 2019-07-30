package CDMNext.StepDefinations;

import java.awt.Robot;

import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.openqa.selenium.support.Color;
import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class AllTab {
	static WebElement ele;
	List<WebElement> list_of_insights;
	String InsightsSwitch;
	String insightName;
	// public String sname;
	String db_name;
	WebElement element;

	@And("^Click on \"([^\"]*)\" tab$")
	public void click_on_tab(String arg1) throws Throwable {

		login.driver.navigate().refresh();
		// CommonFunctionality.TopMethod();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath("//div[@class='search-presentation-tabs--visible']//span[@title='All']"))
				.click();

	}

	@Then("^All tab should contain these sections \"([^\"]*)\"$")
	public void all_tab_should_contain_these_sections(String arg1) throws Throwable {

		String[] arr = arg1.split(";");
		Thread.sleep(5000);
		List<WebElement> list_of_tabs = login.driver.findElements(By.xpath("//div[@class='all-item--title']"));
		login.Log4j.info(list_of_tabs.size());
		for (int i = 1; i <= list_of_tabs.size(); i++) {
			int j = i + 1;
			Thread.sleep(3000);
			ele = login.driver.findElement(By.xpath("//div[@class='all-representation--content']//div[" + j
					+ "]//div[1]//div[@class='all-item--title']"));
			CommonFunctionality.jse.executeScript("arguments[0].scrollIntoView(true);", ele);
			String str = ele.getText();
			// login.Log4j.info(str);
			for (String arr1 : arr) {
				if (arr1.contains(str)) {
					login.Log4j.info(" All tab contain " + str);
				} else {
					Assert.fail("All tab doesn't contain " + str);
				}
			}
		}
	}

	@And("^Click on \"([^\"]*)\" Switch$")
	public void click_on_Switch(String arg1) throws Throwable {
		InsightsSwitch = arg1;
		Thread.sleep(3000);
		if (arg1.equals("All Insights")) {
			login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();
			login.Log4j.info(" Clicking on " + arg1);
		} else if (arg1.equals("EMIS Insights")) {
			login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();
			login.Log4j.info(" Clicking on " + arg1);
		}
	}

	@Then("^All Tab should show insights from All Insights in Top Insights section$")
	public void all_Tab_should_show_insights_from_All_Insights_in_Top_Insights_section() throws Throwable {
		Thread.sleep(3000);
		ele = login.driver.findElement(
				By.xpath("//div[@class='top-insights all-item']//div[@class='all-item--view-more-title']"));
		CommonFunctionality.jse.executeScript("arguments[0].scrollIntoView(true);", ele);
		Thread.sleep(1500);
		ele.click();
		AllInsightsValidation();
	}

	@Then("^All Tab should show insights from EMIS Insights in Top Insights section$")
	public void all_Tab_should_show_insights_from_EMIS_Insights_in_Top_Insights_section() throws Throwable {
		Thread.sleep(3000);
		ele = login.driver.findElement(
				By.xpath("//div[@class='top-insights all-item']//div[@class='all-item--view-more-title']"));
		CommonFunctionality.jse.executeScript("arguments[0].scrollIntoView(true);", ele);
		Thread.sleep(1500);
		ele.click();
		EMISInsightsValidation();
	}

	@And("^Observe the number of insights displayed by default$")
	public void observe_the_number_of_insights_displayed_by_default() throws Throwable {
		Thread.sleep(3000);
		list_of_insights = login.driver.findElements(By.xpath("//div[@class='all-insights-list-item']"));

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
		Thread.sleep(3000);
		login.driver
				.findElement(By.xpath("//div[@class='top-insights all-item']//div[@class='all-item--view-more-title']"))
				.click();
		login.Log4j.info("Clicking on " + arg1);
	}

	@Then("^User should be navigated to \"([^\"]*)\" page$")
	public void user_should_be_navigated_to_page(String arg1) throws Throwable {
		Thread.sleep(2000);
		if (InsightsSwitch.equals("All Insights")) {
			if (login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).isDisplayed()
					&& login.driver.findElement(By.xpath("//div[@data-type='gallery']")).isDisplayed()) {
				login.Log4j.info("Insight Explorer page is opened ");
				Thread.sleep(1000);
				login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			} else {
				AssertJUnit.fail("Insight Explorer page is not opened");
			}
		} else if (InsightsSwitch.equals("EMIS Insights")) {
			if (login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).isDisplayed()
					&& login.driver.findElement(By.xpath("//div[@data-type='emis']")).isDisplayed()) {
				login.Log4j.info("Insight Explorer page is opened ");
				Thread.sleep(1000);
				login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
			} else {
				AssertJUnit.fail("Insight Explorer page is not opened");
			}
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
		ele = login.driver.findElement(By.xpath("//span[@class='insight-preview--title text-dots']"));
		String previe_title = ele.getText();
		login.Log4j.info(previe_title);
		if (insightName.equals(previe_title)) {
			login.Log4j.info("PASS");
			Thread.sleep(1500);
			login.driver.findElement(By.xpath("//div[@class='insight-preview--close']")).click();
		} else {
			Thread.sleep(1500);
			login.driver.findElement(By.xpath("//div[@class='insight-preview--close']")).click();
			Assert.fail("Insight is not opened in view mode");
		}
	}

	@And("^\"([^\"]*)\" popular series should be displayed by default$")
	public void popular_series_should_be_displayed_by_default(String arg1) throws Throwable {
		int PopularSeriesCount = Integer.parseInt(arg1);
		PopularSeriesMethod();
		Thread.sleep(2000);
		List<WebElement> SeriesCount = login.driver.findElements(By.cssSelector(".series-item--name"));
		int list_of_series = SeriesCount.size();
		if (PopularSeriesCount == list_of_series) {
			login.Log4j.info("PASS");
		} else {
			Assert.fail("10 popular series not displayed By default");
		}
	}

	@And("^Hover the mouse on any series$")
	public void hover_the_mouse_on_any_series() throws Throwable {
		PopularSeriesMethod();
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath("//li[1]//div[@class='series-item--name']"));
		CommonFunctionality.action.moveToElement(ele).build().perform();
		CommonFunctionality.sname = ele.getText();
		login.Log4j.info(CommonFunctionality.sname);
	}

	@And("^Click on i icon in blue$")
	public void click_on_i_icon_in_blue() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//li[1]//div[@class='series-list-item--info-icon-i']")).click();
	}

	@Then("^SSP window should be poped up$")
	public void ssp_window_should_be_poped_up() throws Throwable {
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath("//div[@class='single-series-preview--title ']"));
		String ssp_title_txt = ele.getText();
		if (CommonFunctionality.sname.equals(ssp_title_txt)) {
			login.Log4j.info("PASS");
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//div[@title='Close']")).click();
		} else {
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//div[@title='Close']")).click();
			Assert.fail("SSP window is not displayed");
		}
	}

	@Then("^Series info as tooltip should get poped up$")
	public void series_info_as_tooltip_should_get_poped_up() throws Throwable {
		Thread.sleep(1500);
		ele = login.driver.findElement(By.xpath("//div[@class='tooltip tooltip__visible']//table"));
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
			Thread.sleep(1000);
			List<WebElement> li_element = login.driver
					.findElements(By.xpath("//ul[@class='dropdown-menu context-menu ']//li"));
			login.Log4j.info(li_element.size());

			for (int i = 0; i < li_element.size(); i++) {
				int j = i + 1;
				ele = login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu ']//li[" + j + "]"));
				element = login.driver.findElement(
						By.xpath("//ul[@class='dropdown-menu context-menu ']//li[" + j + "]//span//span//b"));
				db_name = element.getText();
				login.Log4j.info(db_name);
				ele.click();
				if (j == 1) {
					break;
				}
			}
			break;
		case "View as Chart. Type `c`":
			login.driver.findElement(By.xpath("//li[1]//div[@class='series-list-item--action-icons']//span[2]"))
					.click();
			Thread.sleep(2000);
			break;
		case "Open footnote":
			Thread.sleep(3000);
			login.driver.findElement(By.xpath("//li[1]//div[@class='series-list-item--action-icons']//span[3]"))
					.click();
			break;

		}
	}

	@Then("^Database should navigate to the particular database and highlight the series$")
	public void database_should_navigate_to_the_particular_database_and_highlight_the_series() throws Throwable {
		Thread.sleep(4000);
		WebElement db_ele = login.driver
				.findElement(By.xpath("//span[@class='name']//span[contains(text(),'" + db_name + "')]"));
		CommonFunctionality.jse.executeScript("arguments[0].scrollIntoView(true);", db_ele);
		Thread.sleep(3000);
		String dbase = db_ele.getText();
		login.Log4j.info(dbase);
		if (dbase.equals(db_name)) {
			login.Log4j.info("PASS");
		} else {
			Assert.fail("FAIL");
		}
	}

	@Then("^Chart should be created with the selected series$")
	public void chart_should_be_created_with_the_selected_series() throws Throwable {
		Thread.sleep(5000);
		ele = login.driver.findElement(By.xpath("//div[@class='text-dots']"));
		String chartTitle = ele.getText();
		login.Log4j.info(chartTitle);
		AssertJUnit.assertEquals(CommonFunctionality.sname, chartTitle);
		login.Log4j.info("chart is created for series level");
		CommonFunctionality.DeleteVisual();
		CommonFunctionality.DeleteSeries();
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
		if (login.driver.findElement(By.xpath("//div[@title='Download. Type `d`']")).isEnabled()) {
			login.Log4j.info("The download button is enabled");
		} else {
			Assert.fail("The download button is not enabled");
		}
	}

	@Then("^In search field,'x selected' should appear with edit icon$")
	public void in_search_field_x_selected_should_appear_with_edit_icon() throws Throwable {
		Thread.sleep(3000);
		if (login.driver.findElement(By.xpath("//span[@class='search-input--preview-selection']")).isDisplayed()) {
			login.Log4j.info("PASS");
		} else {
			Assert.fail("FAIL");
		}
	}

	@And("^Click on ' v ' icon to expand the series details$")
	public void click_on_v_icon_to_expand_the_series_details() throws Throwable {
		Thread.sleep(2000);
		ele = login.driver.findElement(By.xpath("//li[1]//div[@class='series-item--country country-information']"));
		CommonFunctionality.action.moveToElement(ele).click().build().perform();
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
		ele = login.driver.findElement(By.xpath(
				"//div[@class='related-series-data--body']//div[@class='related-series-information-portlet'][2]//div[@class='related-series-information-portlet--title']"));
		String str4 = ele.getText();
		if (arr[0].contains(str1) == true && arr[1].equalsIgnoreCase(str2) == true
				&& arr[2].equalsIgnoreCase(str3) == true && arr[3].equalsIgnoreCase(str4) == true) {
			login.Log4j.info("PASS");
		} else {
			Assert.fail("FAIL");
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

	@And("^Hover the mouse on any series click on dropdown icon$")
	public void hover_the_mouse_on_any_series_click_on_dropdown_icon() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//div[@class='search-presentation-tabs--visible']//span[@title='All']"))
				.click();
		hover_the_mouse_on_any_series();
		Thread.sleep(3000);
		ele = login.driver.findElement(By.xpath("//ul//li[1]//div[@class='add-to-data-selection--toggle']"));
		CommonFunctionality.action.moveToElement(ele).click().build().perform();
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
		int RecentlyUpdatedDatasetsCount = Integer.parseInt(arg1);
		RecentlyUpdatedDatasets();
		Thread.sleep(3000);
		List<WebElement> list = login.driver.findElements(
				By.xpath("//div[@class='data-sets all-item'][1]//div[2]//div[@class='tree-node data-set-node']"));
		int list_of_datasets = list.size();
		if (RecentlyUpdatedDatasetsCount == list_of_datasets) {
			login.Log4j.info("PASS");
		} else {
			Assert.fail("10 datasets are not displayed");
		}
	}

	@And("^Click on View More link for Recently updated datasets$")
	public void click_on_View_More_link_for_Recently_updated_datasets() throws Throwable {
		RecentlyUpdatedDatasets();
		Thread.sleep(2000);
		login.driver
				.findElement(By.xpath(
						"//div[@class='all-representation--content']//div[4]//div[contains(text(),'View more')]"))
				.click();
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
		ele = login.driver.findElement(By.xpath(
				"//div[@class='custom-select-title sort-select-title sort-select-title__asc-hidden sort-select-title__desc-hidden']//span[@class='text-dots']"));
		String actual = ele.getText();
		if (expected_hex.equals(hex) == true && expected.equals(actual) == true) {
			login.Log4j.info("PASS");
		} else {
			Assert.fail("FAIL");
		}

	}

	public void AllInsightsValidation() throws InterruptedException {
		Thread.sleep(3000);
		if (login.driver.findElement(By.xpath("//div[@data-type='gallery']")).isDisplayed()) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		} else {
			Assert.fail("All tab not shown insights from All Insights in Top Insights section");
		}
	}

	public void EMISInsightsValidation() throws InterruptedException {
		Thread.sleep(3000);
		if (login.driver.findElement(By.xpath("//div[@data-type='emis']")).isDisplayed()) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
		} else {
			Assert.fail("All tab not shown insights from EMIS Insights in Top Insights section");
		}
	}

	public static void PopularSeriesMethod() throws InterruptedException {
		Thread.sleep(3000);
		ele = login.driver.findElement(
				By.xpath("//div[@class='all-representation--content']//div[3]//div[1]//div[@class='all-item--title']"));
		CommonFunctionality.jse.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

	public static void TotalUsageValidation() throws InterruptedException {
		Thread.sleep(1500);
		login.driver.findElement(By.xpath(
				"//div[@class='all-representation--content']//div[@class='popular-series all-item']//div[contains(text(),'View more')]"))
				.click();
		Thread.sleep(5000);
		if (login.driver.findElement(By.xpath("//span[contains(text(),'Popularity')]")).isDisplayed()) {
			login.Log4j.info("PASS");
		} else {
			Assert.fail("Popularity is not displayed");
		}
	}

	public static void RecentlyUpdatedDatasets() throws InterruptedException {
		Thread.sleep(3000);
		ele = login.driver.findElement(
				By.xpath("//div[@class='all-representation--content']//div[4]//div[1]//div[@class='all-item--title']"));
		CommonFunctionality.jse.executeScript("arguments[0].scrollIntoView(true);", ele);
	}
}
