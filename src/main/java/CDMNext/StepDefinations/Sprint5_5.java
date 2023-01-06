package CDMNext.StepDefinations;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.AssertJUnit;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class Sprint5_5 extends CommonFunctionality {
	public String Expected_Series;
	int No_of_visuals, selectedSteps;
	String red, orange, yellow;
	String first_selected_series_country_name;
	String existingCounty = "";
	String existingPrefecture = "";
	String existingProvince = "";
	Map map = new Map();

	@Then("^The \"([^\"]*)\" checkbox should be checked by default$")
	public void the_checkbox_should_be_checked_by_default(String arg1) throws Throwable {
		wait(500);
		boolean alternative_data_checkbox = login.driver.findElement(By.xpath(
				"//*[@title='" + arg1 + "']/ancestor::*[@class='filter-item--title']/*/*//input[@type='checkbox']"))
				.isSelected();
		if (alternative_data_checkbox == true) {
			login.Log4j.info(arg1 + " checkbox is checked by default");
		} else {
			Assert.fail(arg1 + " checkbox is not checked by default");
		}
	}

	@Then("^The \"([^\"]*)\" should be displayed on the top always$")
	public void the_should_be_displayed_on_the_top_always(String arg1) throws Throwable {
		wait(500);
		List<WebElement> alternative_dropdown_items = login.driver.findElements(
				By.xpath("//*[@class='filter-list']/*//*[@class='filter-item--title']//*[@class='text-dots']"));
		for (int i = 0; i < alternative_dropdown_items.size();) {
			if (alternative_dropdown_items.get(i).getText().equalsIgnoreCase(arg1)) {
				login.Log4j.info(arg1 + " is displayed on the top always");
			} else {
				Assert.fail(arg1 + " is not displayed on the top of the list of items");
			}
			break;
		}

	}

	@Then("^The button name should be \"([^\"]*)\"$")
	public void the_button_name_should_be(String arg1) throws Throwable {
		wait(500);
		WebElement button_name = getElementByXpath(login.driver,
				"//*[@data-id='alternative']//*[@class='dropdown-search-filter-title--text']", 6);
		if (button_name.getText().equalsIgnoreCase(arg1)) {
			login.Log4j.info("The button name is: " + arg1);
		} else {
			Assert.fail("Verification failed");
		}
	}

	@Then("^The \"([^\"]*)\" tag should be displayed for all series\\.$")
	public void the_tag_should_be_displayed_for_all_series(String arg1) throws Throwable {
		wait(3000);

		List<WebElement> li_All = login.driver
				.findElements(By.xpath("//*[@class='series-representation']/*//*[@class='series-item--name']"));
		login.Log4j.info("List size is :" + li_All.size());
		String strLabel = null;
		if (li_All.size() > 0) {
			for (int i = 0; i < li_All.size(); i++) {
				int j = i + 1;
				// CommonFunctionality.wait(1000);
				// WebElement checkbox = login.driver
				// .findElement(By.xpath("//*[@class='series-representation']/*[" + j +
				// "]//div[@class='series-list-item--checkbox-wrapper']"));
				// checkbox.click();
				wait(600);

				WebElement element = login.driver.findElement(By.xpath(
						"(//*[@class='series-representation--list']//*[@unselectable='on']//div[@class='series-item--status-icons']//*[@title='Alternative series'])["
								+ j + "]"));

				// Until the element is not visible keep scrolling
				jse.executeScript("arguments[0].scrollIntoView(true);", element);
				login.Log4j.info(strLabel);
				if (element.getText().equalsIgnoreCase(arg1)) {
					login.Log4j.info(arg1 + " is displayed for " + arg1);
				} else {
					Assert.fail(arg1 + " is not displayed for " + arg1);
				}
			}
		} else {
			Assert.fail("failed");
		}
	}

	@And("^Switch on \"([^\"]*)\" mode$")
	public void switch_on_mode(String arg1) throws Throwable {
		getElementByXpath(login.driver, "//*[@class='toggler-control-wrapper']/*/*[2]", 6).click();
	}

	@And("^Mouse hover on series$")
	public void mouse_hover_on_series() throws Throwable {
		WebElement series = getElementByXpath(login.driver,
				"//*[@class='webix_column  webix_first']/*/*//*[@class='series-name-field--series-name']", 6);
		new Actions(login.driver).moveToElement(series).build().perform();
	}

	@Then("^The series should be \"([^\"]*)\"$")
	public void the_series_should_be(String arg1) throws Throwable {
		WebElement text_align = getElementByXpath(login.driver, "//*[@class='series-name-field--series-name']", 6);
		String actual = text_align.getCssValue("text-decoration");
		login.Log4j.info(actual);
		if (actual.contains(arg1)) {
			login.Log4j.info("The series is displayed in " + arg1 + " format");
		} else {
			Assert.fail("The series is not displayed in " + arg1 + " format");
		}

	}

	@Then("^Check toolbar and the toolbar should be greyed out instead of hiding$")
	public void check_toolbar_and_the_toolbar_should_be_greyed_out_instead_of_hiding() throws Throwable {
		WebElement greyedout = login.driver.findElement(By.xpath("//*[@class='panels-container disabled']"));
		if (greyedout.isDisplayed() == true) {
			login.Log4j.info("The toolbar is disabled/greyedout when none of the series are selected");
		} else {
			Assert.fail("The toolbar is not disabled/greyedout when none of the series are selected");
		}
	}

	@And("^Right-click on the series$")
	public void right_click_on_the_series() throws Throwable {
		getElementByXpath(login.driver, "//*[@title='List mode']", 6).click();
		WebElement sname = getElementByXpath(login.driver, "//*[@class='series-name-field--series-name']", 6);
		Expected_Series = sname.getText();
		new Actions(login.driver).contextClick(sname).build().perform();

	}

	@And("^Select \"([^\"]*)\" in series right click under my series$")
	public void select_in_series_right_click_under_my_series(String arg1) throws Throwable {
		wait(500);
		right_click_on_the_series();
		login.Log4j.info("Clicking on " + arg1);
		getElementByXpath(login.driver, "//div[@class='items-wrapper']//span[@title='" + arg1 + "']", 8).click();

	}

	@And("^The Paste option should be present and work$")
	public void the_Paste_option_should_be_present_and_work() throws Throwable {
		wait(1000);
		WebElement growltext = getElementByXpath(login.driver, "//div[@class='growl-message-text']", 8);

		if (growltext.getText().contains("Data pasted from clipboard")) {
			login.Log4j.info("The paste option is present");
		} else {
			AssertJUnit.fail("The paste option is greyed out/ not present");
		}
		wait(1000);
		List<WebElement> series_list = login.driver.findElements(
				By.xpath("//div[@class='webix_ss_center_scroll']/*[1]//*[@class='series-name-field--series-name']"));
		for (WebElement actualStr : series_list) {
			if (Expected_Series.equalsIgnoreCase(actualStr.getText())) {
				login.Log4j.info("The paste option does work");
			} else {
				Assert.fail("The paste option doesn't work");
			}
		}
	}

	@And("^Add chart > Check the placement for vertical visual under Table$")
	public void add_chart_Check_the_placement_for_vertical_visual_under_Table() throws Throwable {
		getElementByProperty(login.driver, "Add_chart", 10).click();
	}

	@Then("^The Vertical visual should be displayed in first place under Table$")
	public void the_Vertical_visual_should_be_displayed_in_first_place_under_Table() throws Throwable {
		WebElement ele = getElementByXpath(login.driver,
				"//*[contains(text(),'Table')]/parent::*[@class='ugdPYMd0VxUFfjYkCLib']/following-sibling::*/*[1]/*[1]",
				10);
		String verticalEle = ele.getText();
		if (verticalEle.equalsIgnoreCase("Vertical")) {
			login.Log4j.info("The Vertical visual is displayed in first place under Table");
		} else {
			Assert.fail("The Vertical visual is not displayed in first place under Table");
		}
	}

	@And("^Open copyright under preference$")
	public void open_copyright_under_preference() throws Throwable {
		getElementByXpath(login.driver, "//*[@title='View and edit profile information']", 10).click();
	}

	@Then("^\"([^\"]*)\" should be displayed as prefix$")
	public void should_be_displayed_as_prefix(String arg1) throws Throwable {
		WebElement ele = getElementByXpath(login.driver, "//*[@class='visual-item-wrapper--text text-dots link']", 10);
		String actualSeriesSourceEle = ele.getText();
		if (actualSeriesSourceEle.contains(arg1)) {
			login.Log4j.info(arg1 + " is displayed as prefix");
		} else {
			Assert.fail(arg1 + " is not displayed as prefix");
		}
	}

	@Then("^The list of series sources should be displayed$")
	public void the_list_of_series_sources_should_be_displayed() throws Throwable {
		// if series hormnozation popup appears ,click on Apply button
		try {
			getElementByXpath(login.driver, "//button[contains(text(),'Apply')]", 10).click();
		} catch (Exception e) {

		}
		// Getting source value from ssp window for validation
		List<WebElement> list_of_items = login.driver
				.findElements(By.xpath("//*[@class='series-edit--title series-edit--title__editable']"));
		ArrayList<String> sourcesList = new ArrayList<>();
		for (int i = 0; i < list_of_items.size(); i++) {
			list_of_items.get(i).click();
			wait(300);
			WebElement ele = getElementByXpath(login.driver,
					"//*[contains(text(),'Source:')]/ancestor::td/following-sibling::*//td//*[contains(@class,'main-series-information--field-value')]",
					10);
			String sourceVar_ssp = ele.getText();
			sourcesList.add(sourceVar_ssp);
			// closing ssp window
			getElementByXpath(login.driver, "//*[@title='Close']", 10).click();

		}
		// reading sources from created visual
		WebElement ele = getElementByXpath(login.driver, "//*[@class='visual-item-wrapper--text text-dots link']", 10);
		String actualSeriesSourceEle = ele.getText();
		String[] sourcelist = actualSeriesSourceEle.split(", ");

		for (String expectedStr : sourcesList) {
			if (expectedStr.equals("National Bureau of Statistics")) {
				if (sourcelist[2].equalsIgnoreCase("NBS")) {
					login.Log4j.info("Series source is displayed");
				} else {
					Assert.fail();
				}
			} else if (expectedStr.equalsIgnoreCase(sourcelist[1])) {
				login.Log4j.info("Series source is displayed");
			} else {
				Assert.fail();
			}
		}

	}

	@And("^Change the UI language$")
	public void change_the_UI_language() throws Throwable {
		open_copyright_under_preference();
		// select Bahasa lanugage
		getElementByXpath(login.driver, "//*[@data-language='id']", 10).click();
	}

	@Then("^The \"([^\"]*)\" label should be translated$")
	public void the_label_should_be_translated(String arg1) throws Throwable {
		wait(2000);
		// reading sources from created visual after changing UI languge as Bahasa
		WebElement ele = getElementByXpath(login.driver, "//*[@class='visual-item-wrapper--text text-dots link']", 10);
		String actualSeriesSourceEle = ele.getText();
		String[] sourcelist = actualSeriesSourceEle.split(", ");
		String[] sourceStr = sourcelist[0].split(": ");
		if (!sourceStr[0].equals(arg1)) {
			login.Log4j.info("The " + arg1 + " label translated as " + sourceStr[0]);

			// change default lanugage as english
			wait(2000);
			getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 10).click();
			getElementByXpath(login.driver, "//*[@class='account-avatar--container']", 10).click();
			getElementByXpath(login.driver, "//*[@data-language='en']", 10).click();
		} else {
			// change default lanugage as english
			wait(2000);
			getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 10).click();
			getElementByXpath(login.driver, "//*[@class='account-avatar--container']", 10).click();
			getElementByXpath(login.driver, "//*[@data-language='en']", 10).click();
			Assert.fail();
		}
	}

	@And("^Create a view in right panel$")
	public void create_a_view_in_right_panel() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@title='Create new View tab']")).click();
	}

	@And("^Create (\\d+) visuals from search panel$")
	public void create_visuals_from_search_panel(int arg1) throws Throwable {
		WebElement rightClickElement;
		No_of_visuals = arg1;
		login.Log4j.info("Clicking on Series tab ");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Series_Tab"))));
		wait(4000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_Tab"))).click();

		try {
			wait(4000);
			List<WebElement> li_All = login.driver.findElements(
					By.xpath("//div[@class='series-representation--list']/*//*[@class='series-item--name']"));
			// No of visuals created in right panel

			if (li_All.size() > 0) {
				for (int i = 0; i < li_All.size(); i++) {
					wait(1000);
					rightClickElement = li_All.get(i);
					// contextClick() method to do right click on the element
					action.pause(500).contextClick(rightClickElement).build().perform();
					// click on Add chart and create table visual
					WebElement Addchart = login.driver
							.findElement(By.xpath(login.LOCATORS.getProperty("Dropdown_AddChart")));
					action.moveToElement(Addchart).click().build().perform();
					getElementByXpath(login.driver, "//*[@class='visuals-panel']//*[contains(text(),'Vertical')]", 4)
							.click();

					if (i == arg1 - 1) {

						break;
					}
				}
			} else {
				Assert.fail("Sorry,No results were found ");
			}

		} catch (NoSuchElementException e) {
			Assert.fail("WebElement is null " + e.getMessage());
		}
	}

	@Then("^The visuals should be created in same focused view$")
	public void the_visuals_should_be_created_in_same_focused_view() throws Throwable {
		wait(1000);
		WebElement viewTabEle = getElementByXpath(login.driver,
				"//*[@class='insight-page-view-tab--link insight-page-view-tab--link__active']", 10);
		String ViewTableText = viewTabEle.getAttribute("title");
		List<WebElement> list_of_views = login.driver.findElements(
				By.xpath("//*[@class='insight-page-menu-views-container']//*[@class='insight-page-view-tab--title']"));
		if (ViewTableText.equalsIgnoreCase("view 1") && list_of_views.size() == 1) {
			login.Log4j.info("The visuals created in same focused view");
		} else {
			Assert.fail("The visuals not created in same focused view");
		}
	}

	@And("^Create one more filter visual from search panel$")
	public void create_one_more_filter_visual_from_search_panel() throws Throwable {
		wait(1000);
		getElementByXpath(login.driver, "//*[@data-instance='filter']", 10).click();

	}

	@Then("^The visual should be created in new view$")
	public void the_visual_should_be_created_in_new_view() throws Throwable {
		wait(1000);
		WebElement view2Ele = getElementByXpath(login.driver,
				"//*[contains(@class,'insight-page-view-tab--link__active')]", 10);
		String actualStr = view2Ele.getAttribute("title");

		WebElement visualTitleEle = getElementByXpath(login.driver,
				"//*[contains(@class,'insight-visual__selected')]//*[@class='visual-title--text text-dots']", 10);
		String VisualTitle = visualTitleEle.getText();

		if (actualStr.equalsIgnoreCase("View 2") && VisualTitle.equalsIgnoreCase("Filter")) {
			login.Log4j.info("The filter visual is created in new view tab");
		} else {
			Assert.fail("The filter visual is not created in new view tab");
		}
	}

	@Then("^The \"([^\"]*)\" should be disabled by default$")
	public void the_should_be_disabled_by_default(String ExpectedStr) throws Throwable {
		WebElement TitleEle = getElementByXpath(login.driver, "//*[@data-name='title']", 10);

		if (TitleEle.getAttribute("class").contains("hide")) {
			login.Log4j.info("The Title is disabled by default");
		} else {
			Assert.fail("The Title is not disabled by default");
		}
	}

	@And("^Open My series panel in right panel$")
	public void open_My_series_panel_in_right_panel() throws Throwable {
		getElementByXpath(login.driver, "//*[@data-id='myseries']", 10).click();
	}

	@And("^Create a Visual from search panel$")
	public void create_a_Visual_from_search_panel() throws Throwable {
		WebElement rightClickElement = getElementByXpath(login.driver,
				"(//div[@class='series-representation--list']/*//*[@class='series-item--name'])[4]", 4);
		action.pause(500).contextClick(rightClickElement).build().perform();
		// click on Add chart and create table visual
		WebElement Addchart = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Dropdown_AddChart")));
		action.moveToElement(Addchart).click().build().perform();
		getElementByXpath(login.driver, "//*[@class='visuals-panel']//*[contains(text(),'Vertical')]", 4).click();

	}

	@Then("^Should create a visual in the last available view$")
	public void should_create_a_visual_in_the_last_available_view() throws Throwable {
		wait(5000);
		List<WebElement> listOfVisuals = login.driver.findElements(By.xpath("//*[@data-name='title']"));
		if (No_of_visuals < listOfVisuals.size()) {
			login.Log4j.info("Visual is created in the last available view");
		} else {
			Assert.fail("Fail");
		}
	}

	@And("^Select series and right click on any series$")
	public void select_series_and_right_click_on_any_series() throws Throwable {
		wait(6000);
		webDriverwait_keyvalue("Series_Tab");
		getElementByProperty(login.driver, "Series_Tab", 8).click();
		wait(5000);

		List<WebElement> list = login.driver.findElements(By
				.xpath("//*[@class='series-representation--list']//*[@class='series-list-item--checkbox-wrapper']/*"));
		List<WebElement> Sname = login.driver
				.findElements(By.xpath("//*[@class='series-representation--list']//*[@class='series-item--name']"));
		int j = 0;
		for (int i = 0; i < 3; i++) {
			j = i;
			new Actions(login.driver).moveToElement(list.get(i)).pause(500).click().build().perform();
		}
		new Actions(login.driver).contextClick(Sname.get(j)).pause(500).build().perform();
	}

	@And("^Add chart > select any visual$")
	public void add_chart_select_any_visual() throws Throwable {
		getElementByProperty(login.driver, "Add_chart", 10).click();
		// Create a pie visual
		getElementByXpath(login.driver, "//div[contains(@class,'icon--pie_chart-pie_large')]", 8).click();
	}

	@Then("^The selected visual should be created$")
	public void the_selected_visual_should_be_created() throws Throwable {
		wait(2000);
		WebElement ele = getElementByXpath(login.driver, "//*[@data-name='title']", 8);
		String visualTitle = ele.getText();
		if (visualTitle.equalsIgnoreCase("Pie")) {
			login.Log4j.info("Pie visual is created");
		} else {
			Assert.fail("Pie visual is nit created");
		}
	}

	@And("^Select color steps as (\\d+)$")
	public void select_color_steps_as(int arg1) throws Throwable {
		selectedSteps = arg1;
		WebElement Dropdown_ele = login.driver.findElement(By.name("steps"));
		Select select = new Select(Dropdown_ele);
		select.selectByValue(String.valueOf(arg1));
	}

	@And("^Click on below color steps created and change color as you wish for each step$")
	public void click_on_below_color_steps_created_and_change_color_as_you_wish_for_each_step() throws Throwable {
		List<WebElement> colorSteps = login.driver.findElements(By.xpath("//*[@class='predefined-colors-line']/*/*"));

		for (int i = 0; i < colorSteps.size(); i++) {
			colorSteps.get(i).click();

			if (i == 0) {
				// select red color
				getElementByXpath(login.driver, "//*[contains(@class,'index-module_box_colors_secondary')]/*/*[1]", 8)
						.click();
				WebElement redColor = getElementByXpath(login.driver, "(//*[@class='predefined-color'])[1]/*/*/*", 8);
				red = redColor.getCssValue("background-color");
			} else if (i == 1) {
				// select orange color
				getElementByXpath(login.driver, "//*[contains(@class,'index-module_box_colors_secondary')]/*/*[2]", 8)
						.click();
				WebElement OrangeColor = getElementByXpath(login.driver, "(//*[@class='predefined-color'])[2]/*/*/*",
						8);
				orange = OrangeColor.getCssValue("background-color");
			} else if (i == 2) {
				// select yellow color
				getElementByXpath(login.driver, "//*[contains(@class,'index-module_box_colors_secondary')]/*/*[3]", 8)
						.click();
				WebElement YellowColor = getElementByXpath(login.driver, "(//*[@class='predefined-color'])[3]/*/*/*",
						8);
				yellow = YellowColor.getCssValue("background-color");
			}
		}

	}

	@Then("^Should be able to Save template with selected no of steps & colors$")
	public void should_be_able_to_Save_template_with_selected_no_of_steps_colors() throws Throwable {
		wait(3000);
		String color1 = null, color2 = null, color3 = null;
		List<WebElement> highcharts_color_list = login.driver
				.findElements(By.xpath("//*[@class='highcharts-legend highcharts-no-tooltip']/*[2]/*/*/*[2]"));
		for (int i = 0; i < highcharts_color_list.size(); i++) {

			if (i == 0) {
				color1 = Color.fromString(highcharts_color_list.get(i).getCssValue("fill")).asHex();

			} else if (i == 1) {
				color2 = Color.fromString(highcharts_color_list.get(i).getCssValue("fill")).asHex();
			} else if (i == 2) {
				color3 = Color.fromString(highcharts_color_list.get(i).getCssValue("fill")).asHex();
			}
		}
		if (color1.equals(Color.fromString(red).asHex()) && color2.equals(Color.fromString(orange).asHex())
				&& color3.equals(Color.fromString(yellow).asHex())) {
			login.Log4j.info("Selected colors are displayed");

		} else {
			Assert.fail();
		}
	}

	@And("^Add chart > Heat map$")
	public void add_chart_Heat_map() throws Throwable {
		getElementByProperty(login.driver, "Add_chart", 10).click();
		// Create a pie visual
		getElementByXpath(login.driver, "//div[contains(@class,'icon--heatmap_large')]", 8).click();
	}

	@And("^Select the image$")
	public void select_the_image() throws Throwable {
		wait(2000);
		getElementByXpath(login.driver, "//body[@id='tinymce']//img", 8).click();
	}

	@Then("^The \"([^\"]*)\" option should be selected/enabled$")
	public void the_option_should_be_selected_enabled(String arg1) throws Throwable {
		wait(1000);
		WebElement fit_to_width = getElementByXpath(login.driver, "//*[@aria-label='" + arg1 + "']", 8);
		if (fit_to_width.getAttribute("aria-disabled").contains("false")
				&& fit_to_width.getAttribute("aria-pressed").contains("true")) {
			login.Log4j.info(arg1 + " option is enabled after selected the image");
		} else {
			Assert.fail(arg1 + " option is not enabled after selected the image");
		}
	}

	@And("^Navigate to \"([^\"]*)\" insights$")
	public void navigate_to_insights(String arg1) throws Throwable {
		getElementByXpath(login.driver,
				"//*[@class='search-presentation-tabs--visible']//*[contains(text(),'" + arg1 + "')]", 8).click();
	}

	@And("^Click on download for any insight$")
	public void click_on_download_for_any_insight() throws Throwable {
		// Mouse hover on first insight
		WebElement first_insight = getElementByXpath(login.driver,
				"//*[@class='insights-view--grid']/*[5]//*[@class='insight-grid-item--bottom-panel']", 8);
		new Actions(login.driver).moveToElement(first_insight).build().perform();
		// select view button
		getElementByXpath(login.driver,
				"//*[@class='insights-view--grid']/*[5]//*[@class='insight-grid-item--buttons']//*[contains(text(),'View')]",
				8).click();
		wait(2000);
		// click on download icon
		getElementByXpath(login.driver, "//*[@class='drop-down-button download-button']", 8).click();

	}

	@Then("^The PDF format should be selected to download the insight$")
	public void the_PDF_format_should_be_selected_to_download_the_insight() throws Throwable {
		wait(2000);
		WebElement pdf_format = login.driver.findElement(By.xpath(
				"//*[@class='insight-download-formats--type']//label[@title='Download visual to PDF file']//input"));
		login.Log4j.info(pdf_format.getAttribute("checked"));
		if (pdf_format.getAttribute("checked").contains("true")) {
			login.Log4j.info("The PDF format selected to download the insight");
		} else {
			Assert.fail("The PDF format not selected by default");
		}
	}

	@Then("^Bi-directional update checkbox should be hidden$")
	public void bi_directional_update_checkbox_should_be_hidden() throws Throwable {
		wait(2000);
		List<WebElement> birectional_ele_hide = login.driver.findElements(By.xpath(
				"//*[@class='modal-window insight-download modal-window__active']//*[contains(text(),'Bi-directional update ')]"));
		if (birectional_ele_hide.size() == 0) {
			login.Log4j.info("Bi-directional update checkbox is hidden");
		} else {
			Assert.fail("Bi-directional update checkbox is not hidden");
		}
	}

	@And("^Create a map visual with some country level series \\(excluding Hong Kong , Macau and Taiwan\\)$")
	public void create_a_map_visual_with_some_country_level_series_excluding_Hong_Kong_Macau_and_Taiwan()
			throws Throwable {
		PieVisual.SelectSeries("5724301;5823501;3640701");
		EmptyView.click_on_View_tab();
		map.click_on_Map_visual_icon();
	}

	@Then("^Should create World Map$")
	public void should_create_World_Map() throws Throwable {
		wait(2000);
		String is_world_map = getElementByXpath(login.driver, "//*[contains(@class,'custom-select-title--name')]", 8)
				.getText();
		if (is_world_map.equalsIgnoreCase("World")) {
			login.Log4j.info("World map is created");
		} else {
			Assert.fail("World map is not created");
		}
	}

	@And("^Select some series that has subnational data & create a Map$")
	public void select_some_series_that_has_subnational_data_create_a_Map() throws Throwable {
		// selecting series which has subnational data from Russia region ,Hence Russia
		// map should be created
		PieVisual.SelectSeries("460483537;460483547;460483557");
		EmptyView.click_on_View_tab();
		map.click_on_Map_visual_icon();
	}

	@Then("^Should create Map based on the country$")
	public void should_create_Map_based_on_the_country() throws Throwable {
		wait(2000);
		// check if Russia map is created
		String is_map_russia = getElementByXpath(login.driver, "//*[contains(@class,'custom-select-title--name')]", 8)
				.getText();
		if (is_map_russia.equalsIgnoreCase("Russia")) {
			login.Log4j.info("Russia map is created");
		} else {
			Assert.fail("Russia map is not created");
		}
	}

	@And("^Select some series that has mixed subnational data \\(eg\\.China, Russia & India\\) & create a Map$")
	public void select_some_series_that_has_mixed_subnational_data_eg_China_Russia_India_create_a_Map()
			throws Throwable {
		getElementByClassName(login.driver, "search-input-text", 4).sendKeys("248567502;460483537;241805401");
		getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		wait(6000);
		webDriverwait_keyvalue("Series_Tab");
		getElementByProperty(login.driver, "Series_Tab", 8).click();
		wait(5000);

		List<WebElement> list2 = login.driver.findElements(By
				.xpath("//*[@class='series-representation--list']//*[@class='series-list-item--checkbox-wrapper']/*"));
		for (int i = list2.size() - 1; i >= 0; i--) {

			new Actions(login.driver).moveToElement(list2.get(i)).pause(500).click().build().perform();
			try {
				String seclected_series_count = getElementByXpath(login.driver,
						"//*[@class='search-input--selected-count']", 8).getText();
				if (Integer.parseInt(seclected_series_count) == 1) {
					first_selected_series_country_name = getElementByXpath(login.driver,
							"//*[contains(@class,'series-list-item__selected series-search-list-item__active')]//*[@class='series-item--country country-information']",
							8).getText();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		EmptyView.click_on_View_tab();
		map.click_on_Map_visual_icon();
	}

	@Then("^Should create a subnational map based on the (\\d+)st detected country$")
	public void should_create_a_subnational_map_based_on_the_st_detected_country(int arg1) throws Throwable {
		wait(2000);

		String is_map_title = getElementByXpath(login.driver, "//*[contains(@class,'custom-select-title--name')]", 8)
				.getText();
		if (is_map_title.equalsIgnoreCase(first_selected_series_country_name)) {
			login.Log4j.info(first_selected_series_country_name + " map is created");
		} else {
			Assert.fail(first_selected_series_country_name + " map is not created");
		}
	}

	@And("^Select some series which series has same unit & create a Map$")
	public void select_some_series_which_series_has_same_unit_create_a_Map() throws Throwable {
		// select series which has unit kg
		PieVisual.SelectSeries("284562001;6241901");
		EmptyView.click_on_View_tab();
		map.click_on_Map_visual_icon();

	}

	@Then("^Should show unit in legend for Map visual,if all series are of same unit$")
	public void should_show_unit_in_legend_for_Map_visual_if_all_series_are_of_same_unit() throws Throwable {
		String expected_unit_var = Filters.var;
		wait(2000);
		// double click on visual legend
		WebElement legend = getElementByXpath(login.driver, "//*[contains(@class,'highcharts-legend-item')]/*[2]", 8);
		action.doubleClick(legend).build().perform();

		wait(1000);
		// select checkbox of show unit name
		getElementByXpath(login.driver, "//*[contains(text(),'Show unit name')]", 8).click();

		wait(1000);
		// close legend popup
		getElementByXpath(login.driver, "//*[@class = 'popover--close']", 8).click();

		List<WebElement> list_of_units = login.driver
				.findElements(By.xpath("//*[@class='highcharts-axis-labels highcharts-coloraxis-labels']/*"));

		boolean result = false;
		for (int i = 0; i < list_of_units.size(); i++) {
			String unit = list_of_units.get(i).getText();
			if (unit.contains(expected_unit_var)) {
				login.Log4j.info("selected unit is displayed in legend");
				result = true;
			}
		}
		if (result == false) {
			Assert.fail("Selected unit is not displayed in legend");
		}
	}

	@And("^In search field , type existing county as \"([^\"]*)\"$")
	public void in_search_field_type_existing_county_as(String arg1) throws Throwable {
		existingCounty = arg1;
		getElementByXpath(login.driver, "//*[@class='filters-search--search-field']", 8).sendKeys(arg1);
	}

	@And("^In search field , type existing prefecture as \"([^\"]*)\"$")
	public void in_search_field_type_existing_prefecture_as(String arg1) throws Throwable {
		existingPrefecture = arg1;
		getElementByXpath(login.driver, "//*[@class='filters-search--search-field']", 8).sendKeys(arg1);
	}

	@And("^In search field , type existing province as \"([^\"]*)\"$")
	public void in_search_field_type_existing_province_as(String arg1) throws Throwable {
		existingProvince = arg1;
		getElementByXpath(login.driver, "//*[@class='filters-search--search-field']", 8).sendKeys(arg1);
	}

	@Then("^Should display results for respective  province,prefecture & county tabs$")
	public void should_display_results_for_respective_province_prefecture_county_tabs() throws Throwable {
		wait(1000);

		if (existingCounty.equalsIgnoreCase("Huaining")) {
			String Expected_province = "Anhui";
			String Expected_prefecture = "Anqing";

			WebElement ActualCounty = getElementByXpath(login.driver,
					"//*[contains(text(),'Counties')]/ancestor::*[@class='filters-tree']//*[@title='" + existingCounty
							+ "']",
					8);
			String actual_county = ActualCounty.getText();

			if (actual_county.equalsIgnoreCase(existingCounty)) {
				String actual_county_province = getElementByXpath(login.driver,
						"//*[contains(text(),'Provinces')]/ancestor::*[@class='filters-tree']//*[@class='filter-item--label']",
						8).getText();
				String actual_county_prefecture = getElementByXpath(login.driver,
						"//*[contains(text(),'Prefectures')]/ancestor::*[@class='filters-tree']//*[@class='tree-filter-item--children']//*[@class='filter-item--label']",
						8).getText();
				if (actual_county_province.equalsIgnoreCase(Expected_province)
						&& actual_county_prefecture.equalsIgnoreCase(Expected_prefecture)) {
					login.Log4j.info("Results are displaying for respective province, prefecture and county tabs");
				} else {
					Assert.fail("Results are not displaying for respective province, prefecture and county tabs");
				}
			} else {
				Assert.fail("County name is not matched");
			}

		}

		if (existingPrefecture.equalsIgnoreCase("Hefei")) {
			String Expected_province = "Anhui";
			String Expected_counties = "Changfeng,Feidong,Feixi,Lujiang";

			WebElement ActualPrefecture = getElementByXpath(login.driver,
					"//*[contains(text(),'Prefectures')]/ancestor::*[@class='filters-tree']//*[@class='tree-filter-item--children']//*[@class='filter-item--label']",
					8);
			String actual_prefecture = ActualPrefecture.getAttribute("title");

			if (actual_prefecture.equalsIgnoreCase(existingPrefecture)) {
				// verify province
				String actual_county_province = getElementByXpath(login.driver,
						"//*[contains(text(),'Provinces')]/ancestor::*[@class='filters-tree']//*[@class='filter-item--label']",
						8).getText();
				if (actual_county_province.equalsIgnoreCase(Expected_province)) {
					login.Log4j.info("Province is matched");
				} else {
					Assert.fail("Province is not matched");
				}

				// verify counties
				List<WebElement> hefei_countie_list = login.driver.findElements(By.xpath(
						"//*[contains(text(),'Counties')]/ancestor::*[@class='filters-tree']//*[@class='tree-filter-item--children']/*[1]/*[1]/*[2]//*[@class='filter-item--label']"));
				String[] expected_countie_list = Expected_counties.split(",");
				ArrayList<String> list = new ArrayList<>();
				for (int i = 0; i < hefei_countie_list.size(); i++) {
					String actual_countie = hefei_countie_list.get(i).getText();
					list.add(actual_countie);

				}
				if (list.contains(expected_countie_list[0]) && list.contains(expected_countie_list[1])
						&& list.contains(expected_countie_list[2]) && list.contains(expected_countie_list[3])) {
					login.Log4j.info("Countie list is matched");
				} else {
					Assert.fail("Countie list is not matched");
				}

			} else {
				Assert.fail("Prefecture is not matched");
			}
		}

		if (existingProvince.equalsIgnoreCase("Tibet")) {
			String actual_province = getElementByXpath(login.driver,
					"//*[contains(text(),'Provinces')]/ancestor::*[@class='filters-tree']//*[@class='filter-item--label']",
					8).getText();
			if (existingProvince.equalsIgnoreCase(actual_province)) {
				login.Log4j.info("Existing Province is matched");

			} else {
				Assert.fail("Existing province is not matched");
			}

			String Expected_prefectures = "Lhasa,Lhokha,Narqu,Ngri,Nyingchi,Qamdu,Xigaze";
			String Expected_counties = "Dangxiong,Dazi,Duilongdeqing,Linzhou,Mozhugongka,Nimu,Qushui";
			ArrayList<String> prefectureList = new ArrayList<>();
			ArrayList<String> countieList = new ArrayList<>();

			// verify respective prectures
			String[] prefecture_title = Expected_prefectures.split(",");
			List<WebElement> prefecture_list = login.driver.findElements(By.xpath(
					"//*[contains(text(),'Prefectures')]/ancestor::*[@class='filters-tree']//*[@class='tree-filter-item--children']//*[@class='filter-item--label']"));
			for (int i = 0; i < prefecture_list.size(); i++) {
				String prefecture = prefecture_list.get(i).getText();
				prefectureList.add(prefecture);
			}
			if (prefectureList.contains(prefecture_title[0]) && prefectureList.contains(prefecture_title[1])
					&& prefectureList.contains(prefecture_title[2]) && prefectureList.contains(prefecture_title[3])
					&& prefectureList.contains(prefecture_title[4]) && prefectureList.contains(prefecture_title[5])
					&& prefectureList.contains(prefecture_title[6])) {
				login.Log4j.info("Corresponding prefectures are displayed for respective province" + existingProvince);
			} else {
				Assert.fail("Corresponding prefectures are not displayed for respective province");
			}

			// verify respective counties
			String[] county_title = Expected_counties.split(",");
			List<WebElement> countie_list = login.driver.findElements(By.xpath(
					"//*[contains(text(),'Counties')]/ancestor::*[@class='filters-tree']//*[@class='tree-filter-item--children']/*[1]/*[1]/*[2]//*[@class='filter-item--label']"));

			for (int i = 0; i < countie_list.size(); i++) {
				String actual_countie = countie_list.get(i).getText();
				countieList.add(actual_countie);

			}
			if (countieList.contains(county_title[0]) && countieList.contains(county_title[1])
					&& countieList.contains(county_title[2]) && countieList.contains(county_title[3])
					&& countieList.contains(county_title[4]) && countieList.contains(county_title[5])
					&& countieList.contains(county_title[6])) {
				login.Log4j.info("Countie list is matched for corresponding province " + existingProvince);
			} else {
				Assert.fail("Countie list is not matched");
			}
		}

	}

	@Then("^Should show \"([^\"]*)\" filter in Subnational group$")
	public void should_show_filter_in_Subnational_group(String arg1) throws Throwable {
		ArrayList<String> list_of_subnational = new ArrayList<>();
		List<WebElement> suubnational_list = login.driver.findElements(By.xpath(
				"//*[contains(text(),'Sub-national groups')]/ancestor::*[@class='navigation-sidebar navigation-sidebar__expanded']/*[2]//*[@class='tree-filter-item']"));
		for (int i = 1; i <= suubnational_list.size(); i++) {
			WebElement subnational_title = login.driver.findElement(By.xpath(
					"//*[contains(text(),'Sub-national groups')]/ancestor::*[@class='navigation-sidebar navigation-sidebar__expanded']/*[2]//*[@class='tree-filter-item']["
							+ i + "]/*[1]//*[@class='filter-item']"));
			list_of_subnational.add(subnational_title.getText());
		}
		// verify subnational list has Region filter
		if (list_of_subnational.contains(arg1)) {
			login.Log4j.info(arg1 + " filter is shown in subnational group");
		} else {
			Assert.fail(arg1 + " filter is not shown in subnational group");
		}
	}

	@Then("^By default, should display all groups as collapsed in Sub national groups tab$")
	public void by_default_should_display_all_groups_as_collapsed_in_Sub_national_groups_tab() throws Throwable {

		List<WebElement> suubnational_list = login.driver.findElements(By.xpath(
				"//*[contains(text(),'Sub-national groups')]/ancestor::*[@class='navigation-sidebar navigation-sidebar__expanded']/*[2]//*[@class='tree-filter-item']"));
		for (int i = 0; i < suubnational_list.size(); i++) {
			String subnational_title = suubnational_list.get(i).getAttribute("class");
			if (!subnational_title.contains("tree-filter-item__open")) {
				login.Log4j.info("subnational item is in collapsed state");

			} else {
				Assert.fail("Subnational item is not in collapsed state");
			}

		}
	}

	@And("^Type (\\d+) or more letters as keyword in the search field \\(eg\\. gui\\)$")
	public void type_or_more_letters_as_keyword_in_the_search_field_eg_gui(int arg1) throws Throwable {
		getElementByXpath(login.driver, "//*[@class='filters-search--search-field']", 8).sendKeys("gui");
	}

	@Then("^Should display Select All in the header$")
	public void should_display_Select_All_in_the_header() throws Throwable {
		wait(500);
		// before selecting select all on 2rd level
		WebElement select_all_2nd = getElementByXpath(login.driver,
				"//*[contains(text(),'Prefectures')]/parent::*//*[@class='filters-list--label']/following-sibling::*",
				8);
		String brfore_select_class_attribute_text = select_all_2nd.getAttribute("class");
		login.Log4j.info(brfore_select_class_attribute_text);
		select_all_2nd.click();

		wait(500);
		// After selecting select all on 2nd level
		String after_select_class_attribute_text = select_all_2nd.getAttribute("class");
		login.Log4j.info(after_select_class_attribute_text);
		// before selecting select all on 3rd level
		WebElement select_all_3rd = getElementByXpath(login.driver,
				"//*[contains(text(),'Counties')]/parent::*//*[@class='filters-list--label']/following-sibling::*", 8);
		String brfore_select_class = select_all_3rd.getAttribute("class");
		select_all_3rd.click();
		wait(500);
		// After selecting select all on 3rd level
		String after_select_class = select_all_3rd.getAttribute("class");

		if (!brfore_select_class_attribute_text.equals(after_select_class_attribute_text)
				&& !brfore_select_class.equals(after_select_class)) {
			login.Log4j.info("Select All option is displayed on 2nd & 3rd header level");
		} else {
			Assert.fail("Select All option is not displayed on 2nd & 3rd header level");
		}

	}

	@And("^Click on Insight cogwheel icon$")
	public void click_on_Insight_cogwheel_icon() throws Throwable {
		getElementByXpath(login.driver, "//*[@title = 'Open File menu']", 8).click();
	}

	@And("^Select settings,opens insights settings$")
	public void select_settings_opens_insights_settings() throws Throwable {
		getElementByXpath(login.driver, "//*[contains(text(),'Settings')]", 8).click();
	}

	@Then("^Should show switch/checkbox for EMIS Report$")
	public void should_show_switch_checkbox_for_EMIS_Report() throws Throwable {
		wait(1000);

		WebElement emis_switch = login.driver
				.findElement(By.xpath("//*[contains(text(),'Emis report')]/following-sibling::*[1]/*"));

		if (emis_switch.getAttribute("class").contains("bootstrap-switch-off")) {
			login.Log4j.info("EMIS switch is in OFF mode");
			emis_switch.click();
			if (emis_switch.getAttribute("class").contains("bootstrap-switch-on")) {
				login.Log4j.info("EMIS switch is ON mode and EMIS switch is working as expected");
			} else {
				Assert.fail("EMIS switch is not ON after turning it ON");
			}

		} else if (emis_switch.getAttribute("class").contains("bootstrap-switch-on")) {
			login.Log4j.info("EMIS switch is in ON mode");
			emis_switch.click();
			if (emis_switch.getAttribute("class").contains("bootstrap-switch-off")) {
				login.Log4j.info("EMIS switch is OFF mode and EMIS switch is working as expected");
			} else {
				Assert.fail("EMIS switch is not OFF after turning it as OFF");
			}
		}
	}

	@And("^Type some keyword in search field \"([^\"]*)\" for below (\\d+) results$")
	public void type_some_keyword_in_search_field_for_below_results(String arg1, int arg2) throws Throwable {
		getElementByXpath(login.driver, "//*[@class='filters-search--search-field']", 8).sendKeys(arg1);
	}

	@Then("^Should display Select All in the header if a number of values is smaller than (\\d+)$")
	public void should_display_Select_All_in_the_header_if_a_number_of_values_is_smaller_than(int arg1)
			throws Throwable {
		wait(1000);
		WebElement is_select_all_3rd_level = getElementByXpath(login.driver,
				"//*[contains(text(),'Counties')]/following-sibling::*", 8);
		List<WebElement> selected_filter_items;
		if (is_select_all_3rd_level.getAttribute("class").contains("tree-filter-select-control__visible")) {
			login.Log4j.info("Select All option is displayed for less than 1000 results");
			is_select_all_3rd_level.click();
			selected_filter_items = login.driver.findElements(
					By.xpath("//*[@class='filters-search-item']//*[@class='filters-search-item--title']//span"));
			for (int i = 1; i < selected_filter_items.size(); i++) {
				String filter_item_text = selected_filter_items.get(i).getText();
				login.Log4j.info(filter_item_text);

				if (filter_item_text.contains("more")) {
					String[] selected_list = filter_item_text.split(" ");
					login.Log4j.info(selected_list[2]);
					if (Integer.parseInt(selected_list[2]) < 1000) {
						login.Log4j.info("The results are showing less than 1000");
						break;
					} else {
						Assert.fail("The results are not showing less than 1000");
					}
				}

			}
		} else {
			Assert.fail("Select All option is displayed for less than 1000 results");
		}
	}

	@Then("^Type some keyword in search field \"([^\"]*)\" for above (\\d+) results$")
	public void type_some_keyword_in_search_field_for_above_results(String arg1, int arg2) throws Throwable {
		getElementByXpath(login.driver, "//*[@class='filters-search--clear']", 8).click();
		wait(200);
		getElementByXpath(login.driver, "//*[@class='filters-search--search-field']", 8).sendKeys(arg1);
	}

	@Then("^Should not display Select All in the header if a number of values is greater than (\\d+)$")
	public void should_not_display_Select_All_in_the_header_if_a_number_of_values_is_greater_than(int arg1)
			throws Throwable {
		wait(300);
		WebElement is_select_all_3rd_level = getElementByXpath(login.driver,
				"//*[contains(text(),'Counties')]/following-sibling::*", 8);

		if (!is_select_all_3rd_level.getAttribute("class").contains("tree-filter-select-control__visible")) {
			login.Log4j.info("Select All option is not displayed for above 1000 results");
		} else {
			Assert.fail("Select All option is displayed for above 1000 results");
		}
	}

}