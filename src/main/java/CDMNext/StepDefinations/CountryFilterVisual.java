package CDMNext.StepDefinations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.AssertJUnit;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class CountryFilterVisual extends CommonFunctionality {
	Histogram hs = new Histogram();
	EmptyView emptyView = new EmptyView();
	Commentary commentary = new Commentary();
	String chnge_title;
	JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	String Visual2_filter_title_text;
	String Visual1_hs_title_text;
	

	@And("^Click on insert Filter visual icon$")
	public void click_on_insert_Filter_visual_icon() throws Throwable {
		getElementByXpath(login.driver, "//*[@data-instance='filter']", 20).click();
		try {
			Boolean Filtervisual = login.driver.findElement(By.xpath("//*[@data-name='title']")).isDisplayed();
			if (Filtervisual == true) {
				login.Log4j.info("Filter visual is created");
			}
		} catch (Exception e) {
			getElementByXpath(login.driver, "//*[@data-instance='filter']", 20).click();
		}
	}

	@Then("^\"([^\"]*)\" visual should be created$")
	public void visual_should_be_created(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Image")) {
			WebElement ImageVisual = CommonFunctionality.getElementByProperty(login.driver, "Image_Visual", 4);
			if (ImageVisual.isDisplayed()) {
				login.Log4j.info(arg1 + " visual is created");
			} else {
				Assert.fail(arg1 + " visual is not created");
			}

		} else {
			String Visuale_Title = getElementByXpath(login.driver, "//*[@data-name='title']", 20).getText();
			if (Visuale_Title.equals(arg1)) {
				login.Log4j.info(arg1 + " visual is created");
			} else {
				Assert.fail(arg1 + " visual is not created");
			}
		}
	}

	@Then("^Below optins should be displayed$")
	public void below_optins_should_be_displayed(List<String> list) throws Throwable {
		String arg2, arg6 = null;
		String arg1 = getElementByXpath(login.driver, "//*[@data-popup='title']/span", 20)
				.getText();
		try {
			// filter visual
			arg2 = getElementByXpath(login.driver, "//*[@data-popup='visual']/span", 20).getText();
		} catch (Exception e) {
			// image visual
			arg2 = getElementByXpath(login.driver, "//*[@data-action='add-to-insight']", 20)
					.getAttribute("title");
			arg6 = getElementByXpath(login.driver, "//*[@data-action='copy-elem']", 20)
					.getAttribute("title");
		}
		String arg3 =getElementByXpath(login.driver, "//*[contains(@class,'download-button__icon')]", 20)
				.getAttribute("title");
		String arg4 =getElementByXpath(login.driver, "//*[@data-action='open-visual']", 20)
				.getAttribute("title");
		String arg5 = getElementByXpath(login.driver, "//*[@data-action='delete']", 20)
				.getAttribute("title");
		if (list.size() == 5) {
			if (list.contains(arg1) && list.contains(arg2) && list.contains(arg3) && list.contains(arg4)
					&& list.contains(arg5)) {
				login.Log4j.info(arg1 + " AND " + arg2 + " AND " + arg3 + " AND " + arg4 + " AND " + arg5
						+ " options are displayed");
			} else {
				Assert.fail("Verification failed");
			}
		} else if (list.size() == 6) {
			if (list.contains(arg1) && list.contains(arg2) && list.contains(arg3) && list.contains(arg4)
					&& list.contains(arg5) || list.contains(arg6)) {
				login.Log4j.info(arg1 + " AND " + arg2 + " AND " + arg3 + " AND " + arg4 + " AND " + arg5
						+ " AND "+ arg6 + " options are displayed");
			} else {
				Assert.fail("Verification failed");
			}
		}

	}

	@And("^Edit the name of the title$")
	public void edit_the_name_of_the_title() throws Throwable {
		chnge_title = "Nadiya";
		getElementByXpath(login.driver, "//*[@class='title-config']//input[@name='title']", 30)
				.clear();
		getElementByXpath(login.driver, "//*[@class='title-config']//input[@name='title']", 30)
				.sendKeys(chnge_title);
		wait(2000);
	}

	@Then("^The changes should be reflected to filter visual$")
	public void the_changes_should_be_reflected_to_filter_visual() throws Throwable {
		wait(2000);
		String visualTxt =getElementByXpath(login.driver, "//*[@data-name='title']", 30).getText();
		if (visualTxt.equalsIgnoreCase(chnge_title)) {
			login.Log4j.info("Verification pass");
		} else {
			Assert.fail("The tile name not reflected in filter visual");
		}
	}

	@And("^Click on title dropdown of the filter visual$")
	public void click_on_title_dropdown_of_the_filter_visual() throws Throwable {
		getElementByXpath(login.driver, "//*[@data-popup='title']", 30).click();
	}

	@Then("^The filter visual should update the \"([^\"]*)\" name to \"([^\"]*)\"$")
	public void the_filter_visual_should_update_the_name_to(String arg1, String arg2) throws Throwable {
		commentary.TitleAndSubTitleValidation(arg1, arg2);
	}

	@Then("^The filter visual should update the \"([^\"]*)\" highlight color as Orange$")
	public void the_filter_visual_should_update_the_highlight_color_as_Orange(String arg1) throws Throwable {
		commentary.the_commentary_should_update_the_highlight_color_as_Orange(arg1);
	}

	@Then("^The filter visual should update the \"([^\"]*)\" font as \"([^\"]*)\"$")
	public void the_filter_visual_should_update_the_font_as(String arg1, String arg2) throws Throwable {
		commentary.the_commentary_should_update_the_font_as(arg1, arg2);
	}

	@Then("^The filter visual should update the \"([^\"]*)\" text color as blue$")
	public void the_filter_visual_should_update_the_text_color_as_blue(String arg1) throws Throwable {
		commentary.the_commentary_should_update_the_text_color_as_blue(arg1);
	}

	@Then("^Select Proportion value to (\\d+)$")
	public void select_Proportion_value_to(int arg1) throws Throwable {
		commentary.click_on_option_on_visual_header("Visual");
		String Proportiovalue = Integer.toString(arg1);
		WebElement proportion = getElementByXpath(login.driver,
				"//*[text()='Proportion:']//following::input[1]", 4);
		proportion.sendKeys(Keys.chord(Keys.CONTROL, "a"), Proportiovalue);
		proportion.sendKeys(Keys.TAB);
	}

	@Then("^The Filter position should be align to \"([^\"]*)\"$")
	public void the_Filter_position_should_be_align_to(String arg1) throws Throwable {
		WebElement visual_align = null;

		// Filter visual align
		visual_align = getElementByXpath(login.driver,
				"//*[@class='filter-template--content']", 20);

		if (arg1.equalsIgnoreCase("flex-start")) {
			String left = visual_align.getAttribute("style");
			if (left.contains(arg1)) {
				login.Log4j.info("The Visual area is aligned to " + arg1);

			} else {
				Assert.fail("Verification Failed");
			}
			// highlighting visual
			visual_align.click();
			// click on visual header
			getElementByXpath(login.driver, "//*[contains(text(),'Visual')]", 20).click();

		}
		if (arg1.equalsIgnoreCase("Center")) {
			String center = visual_align.getAttribute("style");
			if (center.contains(arg1)) {
				login.Log4j.info("The Visual area is aligned to " + arg1);

			} else {
				Assert.fail("Verification Failed");
			}
			// highlighting visual
			visual_align.click();
			// click on visual header
			getElementByXpath(login.driver, "//*[contains(text(),'Visual')]", 20).click();
		}
		if (arg1.equalsIgnoreCase("flex-end")) {
			String right = visual_align.getAttribute("style");
			if (right.contains(arg1)) {
				login.Log4j.info("The Visual area is aligned to " + arg1);

			} else {
				Assert.fail("Verification Failed");
			}
			// highlighting visual
			visual_align.click();

		}
	}

	@And("^Check for Filter Border$")
	public void check_for_Filter_Border() throws Throwable {
		getElementByProperty(login.driver, "ExpandFilterBorder", 30).click();
	}

	@Then("^The Filter border should be changed as per the selection$")
	public void the_Filter_border_should_be_changed_as_per_the_selection() throws Throwable {
		//commentary.UnselectVisual();
		String border_color = getElementByProperty(login.driver, "BorderColor", 20)
				.getCssValue("border-color");
		Commentary.ColorValidation(border_color,Commentary.ActualColor);
		//DeleteVisual();
	}

	@Then("^Popup should be opened with editing options$")
	public void popup_should_be_opened_with_editing_options() throws Throwable {
		wait(2000);
		boolean popup = login.driver.findElement(By.xpath("//*[@class='dropdown-menu context-menu ']/*[3]"))
				.isDisplayed();
		if (popup == true) {
			login.Log4j.info("Verification is PASS");
		} else {
			Assert.fail("Popup is not opened with editing options");
		}
	}

	@Then("^Filter visual should be deleted$")
	public void filter_visual_should_be_deleted() throws Throwable {
		if (login.driver.findElements(By.xpath("//*[@data-name='title']")).size() == 0) {
			login.Log4j.info("Filter visual is deleted");
		} else {
			Assert.fail("Filter visual is not deleted");
		}
	}

	@Then("^Verify insert visual sub dropdown options for filter visual$")
	public void verify_insert_visual_sub_dropdown_options_for_filter_visual() throws Throwable {
		hs.verify_insert_visual_sub_dropdown_options_for_histogram_visual();
	}

	@And("^Create any other visuals in a view$")
	public void create_any_other_visuals_in_a_view() throws Throwable {
	
		emptyView.create_Histogram_and_Map_visuals();
	}

	@And("^Create filter visual$")
	public void create_filter_visual() throws Throwable {
		getElementByXpath(login.driver, "//*[@class='icon--filter']", 20).click();
	}

	@And("^Click inside filter visual$")
	public void click_inside_filter_visual() throws Throwable {
		getElementByProperty(login.driver, "AllCountries", 20).click();
	}

	@Then("^Countries name which are included in the other all visual should be listed and displayed$")
	public void countries_name_which_are_included_in_the_other_all_visual_should_be_listed_and_displayed()
			throws Throwable {
		List<WebElement> list_of_countries = login.driver
				.findElements(By.xpath("//*[@class='custom-select--body']//*[@class='custom-select-item']/*"));
		for (int i = 0; i < list_of_countries.size(); i++) {
			if (list_of_countries.get(i).getAttribute("title").equalsIgnoreCase(emptyView.region1)) {
				login.Log4j.info("Region " + emptyView.region1 + " is displayed");
			} else if (list_of_countries.get(i).getAttribute("title").equalsIgnoreCase(emptyView.region2)) {
				login.Log4j.info("Region " + emptyView.region2 + " is displayed");
			} else {
				Assert.fail("Verification failed");
			}
		}
	}

	@And("^Create one visual with countryfilter$")
	public void create_one_visual_with_countryfilter() throws Throwable {
		getElementByProperty(login.driver, "Search", 20).sendKeys("292514701;34709201");
		getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		commentary.CreateViewTab();
		getElementByClassName(login.driver, "icon--heatmap", 10).click();
		getElementByProperty(login.driver, "Series", 20).click();
		wait(1500);
		//WebElement ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		//List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
		List<WebElement> li_All =  login.driver.findElements(By.xpath("//div[@class='series-representation--list']/*//*[@class='series-item--name']"));
		login.Log4j.info("List size is :" + li_All.size());
		List<WebElement> checkBox = login.driver
				.findElements(By.xpath("//div[@class='series-representation--list']/*//div[@class='series-list-item--checkbox-wrapper']"));
		for (int i = 0; i < li_All.size(); i++) {
			new Actions(login.driver).moveToElement(checkBox.get(i)).click().build().perform();
		}
		getElementByXpath(login.driver, "(//div[@class='series-representation--list']//*[@class='add-to-data-selection--icon'])[2]", 10)
				.click();
		try {
		getElementByXpath(login.driver, "//*[contains(text(),'Keep different frequencies')]", 8)
				.click();
		}catch(Exception e) {
			
		}
		getElementByXpath(login.driver, "//*[@class='icon--filter']", 20).click();
	}

	@And("^click on filter and modify visual with specific countries$")
	public void click_on_filter_and_modify_visual_with_specific_countries() throws Throwable {
		click_inside_filter_visual();
		wait(5000);
		List<WebElement> list_of_countries = login.driver
				.findElements(By.xpath("//*[@class='custom-select--body']//*[@class='custom-select-item']/*"));
		for (int i = 0; i < list_of_countries.size();) {
			list_of_countries.get(i).click();
			break;
		}

	}

	@And("^create another visual in the same view$")
	public void create_another_visual_in_the_same_view() throws Throwable {
		// create map visual
		CommonFunctionality.getElementByProperty(login.driver, "AddChart", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "AddChart_map", 6).click();
//		new Actions(login.driver).pause(2000)
//				.moveToElement(
//						login.driver.findElement(By.xpath("//*[@class='view-components-over--visuals']//*[@class='icon--map-world']")))
//				.click().perform();
		getElementByXpath(login.driver, "//*[contains(text(),'Add from My Series')]", 20).click();
		wait(1000);
		WebElement ele =getElementByXpath(login.driver,
				"//div[@class='check-all-series']//span[@class='input-control--indicator']", 4);
		new Actions(login.driver).pause(1000).moveToElement(ele).click().build().perform();
		try {
		getElementByXpath(login.driver, "//*[contains(text(),'Keep different frequencies')]", 8)
				.click();
		}catch(Exception e) {
			
		}

	}

	@Then("^Reset country filter notification should be popped$")
	public void reset_country_filter_notification_should_be_popped() throws Throwable {
		Boolean resetCountryFilter = login.driver.findElement(By.xpath("//*[contains(text(),'Reset country filter')]"))
				.isDisplayed();
		if (resetCountryFilter == true) {
			login.Log4j.info("Reset country filter notification popped up");
		} else {
			Assert.fail("Reset country filter is not shown");
		}
	}

	@Then("^filter visual should get reset with \"([^\"]*)\" name present in all visuals in view$")
	public void filter_visual_should_get_reset_with_name_present_in_all_visuals_in_view(String arg1) throws Throwable {
		Boolean Allcountry_filter = login.driver.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]"))
				.isDisplayed();
		if (Allcountry_filter == true) {
			login.Log4j.info("Filter visual get reset with " + arg1);
		} else {
			Assert.fail("Filter visual not get reset with " + arg1);
		}
	}

	@And("^Hover the cursor on the title and try to move with in the view$")
	public void hover_the_cursor_on_the_title_and_try_to_move_with_in_the_view() throws Throwable {
		wait(2000);
		// Visuals position before drag and drop
		WebElement sourecEle = login.driver.findElement(
				By.xpath("(//*[contains(@class,'filter-template')]//*[@class='visual-title--text text-dots'])[1]"));
		Visual2_filter_title_text = sourecEle.getText();
		wait(2000);
		WebElement targetEle = login.driver.findElement(
				By.xpath("//*[@class='view-components']/*[2]//*[@class='visual-title--text text-dots']"));
		wait(500);
		Visual1_hs_title_text = targetEle.getText();
		wait(1000);
		jse.executeScript("arguments[0].scrollIntoView(true);", targetEle);
		new Actions(login.driver).pause(2000).dragAndDrop(sourecEle, targetEle).perform();

	}

	@Then("^Country filter visual should move$")
	public void country_filter_visual_should_move() throws Throwable {
		// Visuals after drag and drop
		wait(1000);
		String visual2_text = login.driver.findElement(By.xpath("(//*[@data-name='title'])[1]")).getText();
		String visual1_text = login.driver.findElement(By.xpath("(//*[@data-name='title'])[2]")).getText();
		if (!visual2_text.equals(Visual1_hs_title_text) && !visual1_text.equals(Visual2_filter_title_text)) {
			login.Log4j.info("Visuals interchanged by drag and drop");
		} else {
			Assert.fail("Verification failed");
		}
	}

	@And("^Click on crossmark when all countries are selected$")
	public void click_on_crossmark_when_all_countries_are_selected() throws Throwable {
		getElementByProperty(login.driver, "Search", 20).sendKeys("292514701;34709201");
		commentary.CreateViewTab();
		getElementByXpath(login.driver, "//*[@class='view-components-over--visual']//*[@class='icon--heatmap']", 10).click();
		getElementByProperty(login.driver, "Series", 20).click();
		wait(1500);
		//WebElement ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		//List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
		List<WebElement> li_All =  login.driver.findElements(By.xpath("//div[@class='series-representation--list']/*//*[@class='series-item--name']"));
		List<WebElement> checkBox = login.driver
				.findElements(By.xpath("//div[@class='series-representation--list']/*//div[@class='series-list-item--checkbox-wrapper']"));
		for (int i = 0; i < li_All.size(); i++) {
			new Actions(login.driver).moveToElement(checkBox.get(i)).click().build().perform();
		}
		getElementByXpath(login.driver, "(//div[@class='series-representation--list']//*[@class='add-to-data-selection--icon'])[2]", 10)
				.click();
		try {
		getElementByXpath(login.driver, "//*[contains(text(),'Keep different frequencies')]", 8)
				.click();
		}catch(Exception e) {
			
		}
		create_filter_visual();
		click_inside_filter_visual();
		List<WebElement> list_of_countries = login.driver
				.findElements(By.xpath("//*[@class='custom-select--body']//*[@class='custom-select-item']/*"));
		for (int i = 0; i < list_of_countries.size();) {
			list_of_countries.get(i).click();
			break;

		}

	}

	@Then("^Should unselect all countries$")
	public void should_unselect_all_countries() throws Throwable {
		getElementByXpath(login.driver,"//*[@class='filter-template--content']//*[@class='custom-select-title--reset-icon']", 8).click();
		filter_visual_should_get_reset_with_name_present_in_all_visuals_in_view("All countries");

	}
}
