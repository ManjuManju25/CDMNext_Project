package CDMNext.StepDefinations;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.AssertJUnit;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class Bubble extends CommonFunctionality {
	EmptyView EV = new EmptyView();
	ArrayList<String> selected_series_list = new ArrayList<>();
	ArrayList<String> selected_different_country_list = new ArrayList<>();
	ArrayList<String> same_country_list = new ArrayList<>();
	ArrayList<String> unit_list = new ArrayList<>();
	Filters filters = new Filters();
	String Applied_color, Expected_color,data_labels_font_size;
	WebElement data_labels_bold,data_labels_italic,data_labels_underline;

	@And("^Create a bubble visual$")
	public void create_a_bubble_visual() throws Throwable {
		getElementByProperty(login.driver, "Dropdown_AddChart", 4).click();
		getElementByProperty(login.driver, "bubbbleIcon", 4).click();
		wait(500);
		// if series hormonization popup is opened
		try {
			getElementByXpath(login.driver,
					"//*[@class='series-data-conversion--buttons']//button[contains(text(),'Apply')]", 4).click();
		} catch (Exception e) {

		}

	}

	@And("^Create empty buble visual$")
	public void create_empty_buble_visual() throws Throwable {
		EmptyView.click_on_View_tab();
		getElementByProperty(login.driver, "AddChart", 4).click();
		getElementByProperty(login.driver, "bubbbleIcon", 4).click();
		wait(500);
	}

	@And("^Observe total number of series to create a group$")
	public void observe_total_number_of_series_to_create_a_group() throws Throwable {

		login.Log4j.info("Clicking on  Series tab ");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Series_Tab"))))
				.click();
		wait(2000);

		List<WebElement> series = login.driver.findElements(By.xpath(
				"//div[@class='series-representation--list']/*//div[@class='series-list-item--checkbox-wrapper']"));
		List<WebElement> sName = login.driver.findElements(By.xpath("//*[@class='series-item--name']"));
		if (series.size() > 0) {
			for (int i = 0; i < series.size(); i++) {
				login.Log4j.info(i);
				wait(600);
				action.moveToElement(series.get(i)).click().build().perform();
				selected_series_list.add(sName.get(i).getText());
				if (i == 2) {
					getElementByXpath(login.driver,
							"(//div[@class='series-representation--list']/*//*[@class='add-to-data-selection--icon'])["
									+ i + "]",
							6).click();
					break;
				}

			}
			// if series hormonization popup is opened
			try {
				getElementByXpath(login.driver,
						"//*[@class='series-data-conversion--buttons']//button[contains(text(),'Apply')]", 4).click();
			} catch (Exception e) {

			}
		}
	}

	@Then("^Total (\\d+) series should use to create a group in bubble$")
	public void total_series_should_use_to_create_a_group_in_bubble(int arg1) throws Throwable {
		wait(500);
		WebElement group_ele = getElementByProperty(login.driver, "group_bubble", 4);
		if (selected_series_list.size() == arg1) {
			if (group_ele.isDisplayed()) {
				login.Log4j.info("The selected " + arg1 + " series used to create a group in bubble");
			} else {
				AssertJUnit.fail("Verification failed");
			}
		} else {
			AssertJUnit.fail("Verification failed");
		}

	}

	@And("^Select any (\\d+) series and Create a bubble visual$")
	public void select_any_series_and_Create_a_bubble_visual(int arg1) throws Throwable {
		login.Log4j.info("Clicking on  Series tab ");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Series_Tab"))))
				.click();
		wait(2000);

		List<WebElement> series = login.driver.findElements(By.xpath(
				"//div[@class='series-representation--list']/*//div[@class='series-list-item--checkbox-wrapper']"));
		List<WebElement> sName = login.driver.findElements(By.xpath("//*[@class='series-item--name']"));

		for (int i = 0; i < arg1; i++) {
			login.Log4j.info(i);
			wait(600);
			action.moveToElement(series.get(i)).click().build().perform();
			selected_series_list.add(sName.get(i).getText());
			if (i == (arg1 - 1)) {
				action.contextClick(sName.get(i)).build().perform();
				break;
			}

		}
		getElementByProperty(login.driver, "Dropdown_AddChart", 4).click();
		getElementByProperty(login.driver, "bubbbleIcon", 4).click();
		wait(500);
		// if series hormonization popup is opened
		try {
			getElementByXpath(login.driver,
					"//*[@class='series-data-conversion--buttons']//button[contains(text(),'Apply')]", 4).click();
		} catch (Exception e) {

		}

	}

	@Then("^The title of the visual should be the name of the (\\d+) series selected and vs is shifted in the title bubble$")
	public void the_title_of_the_visual_should_be_the_name_of_the_series_selected_and_vs_is_shifted_in_the_title_bubble(
			int arg1) throws Throwable {
		wait(1000);
		List<WebElement> series_name_in_visual_title = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("series_name_list_in_title")));
		List<WebElement> versus_text = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("visual_title_versus_text")));
		String Actual_visual_title = getElementByProperty(login.driver, "Bubble_visual_title", 4).getText();

		int j = versus_text.size();
		String ExpectedVisualTitle = "";
		if (series_name_in_visual_title.size() == selected_series_list.size()) {
			for (String series : selected_series_list) {
				ExpectedVisualTitle = ExpectedVisualTitle + series;

				for (int i = 0; i < j;) {

					ExpectedVisualTitle = ExpectedVisualTitle + " " + versus_text.get(i).getText() + " ";
					j = j - 1;
					break;

				}
			}
		} else if (selected_series_list.size() > series_name_in_visual_title.size()) {

			for (int k = 0; k < selected_series_list.size(); k++) {
				if (k >= 3) {
					continue;
				}

				ExpectedVisualTitle = ExpectedVisualTitle + selected_series_list.get(k);

				for (int i = 0; i < j;) {

					ExpectedVisualTitle = ExpectedVisualTitle + " " + versus_text.get(i).getText() + " ";
					j = j - 1;
					break;
				}
			}

		}
		login.Log4j.info(ExpectedVisualTitle);
		login.Log4j.info(Actual_visual_title);
		if (ExpectedVisualTitle.equals(Actual_visual_title)) {
			login.Log4j.info(ExpectedVisualTitle);

		} else {
			AssertJUnit.fail("Verification failed");
		}
	}

	@And("^Select any series more than (\\d+) and Create a bubble visual$")
	public void select_any_series_more_than_and_Create_a_bubble_visual(int arg1) throws Throwable {
		// Select 7 series
		int seriesCount = arg1 + 1;
		select_any_series_and_Create_a_bubble_visual(seriesCount);
	}

	@Then("^The title should be displayed by the name of \"([^\"]*)\"$")
	public void the_title_should_be_displayed_by_the_name_of(String arg1) throws Throwable {
		wait(2000);
		String Actual_visual_title = getElementByProperty(login.driver, "Bubble_visual_title", 4).getText();
		if (Actual_visual_title.equalsIgnoreCase(arg1)) {
			login.Log4j.info("The title name is displayed by the name of " + arg1);
		} else {
			AssertJUnit.fail("The title name is not displayed by the name of " + arg1);
		}
	}

	@And("^Select any (\\d+) series from different countries and Create a bubble visual$")
	public void select_any_series_from_different_countries_and_Create_a_bubble_visual(int arg1) throws Throwable {
		// passing 3 series ids from 3 different countries
		filters.user_enters("269066202;269068302;269066502");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Series_Tab"))))
				.click();
		wait(2000);

		List<WebElement> different_country_names = login.driver.findElements(By.xpath(
				"//div[@class='series-representation--list']/*//div[@class='series-item--country country-information']"));

		for (int i = 0; i < different_country_names.size(); i++) {
			login.Log4j.info(i);
			wait(600);
			action.moveToElement(different_country_names.get(i)).click().build().perform();
			selected_different_country_list.add(different_country_names.get(i).getText());
			if (i == (arg1 - 1)) {
				action.contextClick(different_country_names.get(i)).build().perform();
				break;
			}

		}
		getElementByProperty(login.driver, "Dropdown_AddChart", 4).click();
		getElementByProperty(login.driver, "bubbbleIcon", 4).click();
		wait(500);
		// if series hormonization popup is opened
		try {
			getElementByXpath(login.driver,
					"//*[@class='series-data-conversion--buttons']//button[contains(text(),'Apply')]", 4).click();
		} catch (Exception e) {

		}
	}

	@Then("^Legend should display all (\\d+) country names$")
	public void legend_should_display_all_country_names(int arg1) throws Throwable {
		wait(2000);
		List<WebElement> actual_country_list = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("country_list_in_visual")));
		boolean flag = false;
		for (int i = 0; i < actual_country_list.size(); i++) {
			if (selected_different_country_list.contains(actual_country_list.get(i).getText())) {
				flag = true;
			}
		}
		if (flag == true) {
			login.Log4j.info("Legend is displayed all " + arg1 + " country names");
		} else {
			AssertJUnit.fail("Legend is not displayed all " + arg1 + " country names");
		}
	}

	@And("^Select any (\\d+) series from same country and Create a bubble visual$")
	public void select_any_series_from_same_country_and_Create_a_bubble_visual(int arg1) throws Throwable {
		// passing 3 series ids from 3 same country (china)
		filters.user_enters("5724301;3640701;5190101");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Series_Tab"))))
				.click();
		wait(2000);

		List<WebElement> same_country_name = login.driver.findElements(By.xpath(
				"//div[@class='series-representation--list']/*//div[@class='series-item--country country-information']"));

		for (int i = 0; i < same_country_name.size(); i++) {
			login.Log4j.info(i);
			wait(600);
			action.moveToElement(same_country_name.get(i)).click().build().perform();
			same_country_list.add(same_country_name.get(i).getText());
			if (i == (arg1 - 1)) {
				action.contextClick(same_country_name.get(i)).build().perform();
				break;
			}

		}
		getElementByProperty(login.driver, "Dropdown_AddChart", 4).click();
		getElementByProperty(login.driver, "bubbbleIcon", 4).click();
		wait(500);
		// if series hormonization popup is opened
		try {
			getElementByXpath(login.driver,
					"//*[@class='series-data-conversion--buttons']//button[contains(text(),'Apply')]", 4).click();
		} catch (Exception e) {

		}
	}

	@Then("^Legend should display only one country name$")
	public void legend_should_display_only_one_country_name() throws Throwable {
		wait(2000);
		List<WebElement> actual_country_list = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("country_name_for_selected_same_country_series")));
		if (actual_country_list.size() == 1) {
			for (int i = 0; i < actual_country_list.size(); i++) {
				if (same_country_list.contains(actual_country_list.get(i).getText())) {
					login.Log4j.info("Legend is displayed only one country name");
				} else {
					AssertJUnit.fail("Legend is not displayed  only one country names");
				}
			}
		}

	}

	@And("^Select any series less than (\\d+)  and Create a bubble visual$")
	public void select_any_series_less_than_and_Create_a_bubble_visual(int arg1) throws Throwable {
		// passing 3 series ids from 3 different countries
		filters.user_enters("269066202;269068302;269066502");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Series_Tab"))))
				.click();
		wait(2000);

		List<WebElement> different_country_names = login.driver.findElements(By.xpath(
				"//div[@class='series-representation--list']/*//div[@class='series-item--country country-information']"));

		for (int i = 0; i < different_country_names.size(); i++) {
			login.Log4j.info(i);
			wait(600);
			action.moveToElement(different_country_names.get(i)).click().build().perform();
			selected_different_country_list.add(different_country_names.get(i).getText());
			if (i == 2) {
				action.contextClick(different_country_names.get(i)).build().perform();
				break;
			}

		}
		getElementByProperty(login.driver, "Dropdown_AddChart", 4).click();
		getElementByProperty(login.driver, "bubbbleIcon", 4).click();
		wait(500);
		// if series hormonization popup is opened
		try {
			getElementByXpath(login.driver,
					"//*[@class='series-data-conversion--buttons']//button[contains(text(),'Apply')]", 4).click();
		} catch (Exception e) {

		}
	}

	@Then("^Series country should be display as a legend separated by comma$")
	public void series_country_should_be_display_as_a_legend_separated_by_comma() throws Throwable {
		wait(2000);
		List<WebElement> actual_legend_title = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("country_name_for_selected_same_country_series")));

		String ExpectedVisualTitle = "";
		int j = 2;
		int m = 2;
		String legend1 = "";
		String legend2 = "";
		if (selected_different_country_list.size() == 3) {
			for (String country : selected_different_country_list) {
				ExpectedVisualTitle = ExpectedVisualTitle + country;

				for (int i = 0; i < j;) {

					ExpectedVisualTitle = ExpectedVisualTitle + ", ";
					j = j - 1;
					break;

				}
			}
		} else if (selected_different_country_list.size() == 7) {

			for (int i = 0; i < selected_different_country_list.size(); i++) {
				int k = i;
				if (k == 6) {
					continue;
				}

				if (i >= 3) {

					legend2 = legend2 + selected_different_country_list.get(i).toString();
					for (int l = 0; l < m;) {

						legend2 = legend2 + ", ";
						m = m - 1;
						break;

					}

				} else {
					legend1 = legend1 + selected_different_country_list.get(i).toString();
					for (int l = 0; l < j;) {

						legend1 = legend1 + ", ";
						j = j - 1;
						break;

					}
				}

			}
		}

		// comparing actual legend title with expected title
		if (actual_legend_title.size() == 1) {
			for (int i = 0; i < actual_legend_title.size(); i++) {
				login.Log4j.info(ExpectedVisualTitle);
				login.Log4j.info(actual_legend_title.get(i).getText());

				if (ExpectedVisualTitle.equalsIgnoreCase(actual_legend_title.get(i).getText())) {
					login.Log4j.info("Series countries are displayed as a legend separated by comma ");
				} else {
					AssertJUnit.fail("Series countries are not displayed as a legend separated by comma");
				}
			}
		} else if (actual_legend_title.size() > 1) {
			boolean legend_title1 = false;
			boolean legend_title2 = false;
			for (int i = 0; i < actual_legend_title.size(); i++) {

				login.Log4j.info(actual_legend_title.get(i).getText());

				if (legend1.equalsIgnoreCase(actual_legend_title.get(i).getText())) {
					legend_title1 = true;

				} else if (legend2.equalsIgnoreCase(actual_legend_title.get(i).getText())) {
					legend_title2 = true;
				}
			}
			if (legend_title1 == true && legend_title2 == true) {
				login.Log4j.info("Series countries are displayed as a legend separated by comma ");
			} else {
				AssertJUnit.fail("Series countries are not displayed as a legend separated by comma");
			}
		}

	}

	@And("^Select any series more than (\\d+) from different countries and Create a bubble visual$")
	public void select_any_series_more_than_from_different_countries_and_Create_a_bubble_visual(int arg1)
			throws Throwable {
		// passing 7 series ids from 7 different countries
		filters.user_enters("5724301;269066202;269068302;269066502;269069202;269061202;269063902");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Series_Tab"))))
				.click();
		wait(2000);

		List<WebElement> different_country_names = login.driver.findElements(By.xpath(
				"//div[@class='series-representation--list']/*//div[@class='series-item--country country-information']"));

		for (int i = 0; i < different_country_names.size(); i++) {
			login.Log4j.info(i);
			wait(600);
			action.moveToElement(different_country_names.get(i)).click().build().perform();
			selected_different_country_list.add(different_country_names.get(i).getText());
			if (i == (different_country_names.size() - 1)) {
				action.contextClick(different_country_names.get(i)).build().perform();
				break;
			}

		}
		getElementByProperty(login.driver, "Dropdown_AddChart", 4).click();
		getElementByProperty(login.driver, "bubbbleIcon", 4).click();
		wait(500);
		// if series hormonization popup is opened
		try {
			getElementByXpath(login.driver,
					"//*[@class='series-data-conversion--buttons']//button[contains(text(),'Apply')]", 4).click();
		} catch (Exception e) {

		}
	}

	@And("^Select any series less than (\\d+)$")
	public void select_any_series_less_than(int arg1) throws Throwable {
		login.Log4j.info("Clicking on  Series tab ");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Series_Tab"))))
				.click();
		wait(2000);

		List<WebElement> series = login.driver.findElements(By.xpath(
				"//div[@class='series-representation--list']/*//div[@class='series-list-item--checkbox-wrapper']"));
		List<WebElement> sName = login.driver.findElements(By.xpath("//*[@class='series-item--name']"));

		for (int i = 0; i < arg1; i++) {
			login.Log4j.info(i);
			wait(600);
			action.moveToElement(series.get(i)).click().build().perform();
			selected_series_list.add(sName.get(i).getText());

			// Reading unit value in tooltip
			wait(600);
			action.moveToElement(sName.get(i)).build().perform();
			wait(2000);
			WebElement tooltip = getElementByProperty(login.driver, "tooltip_text", 10);
			String TooltipInfo = tooltip.getText();
			// login.Log4j.info("Title information is \n" + TooltipInfo);
			String[] tooltip_array = TooltipInfo.split("\n");

			int count = 0;
			for (String ele : tooltip_array) {
				if (ele.equalsIgnoreCase("Unit")) {
					count += 1;
					break;

				} else {
					count += 1;
				}

			}
			unit_list.add(tooltip_array[count]);

			if (i == 2) {
				action.contextClick(sName.get(i)).build().perform();
				break;
			}

		}

	}

	@Then("^X-axis should be displayed as series X,unit$")
	public void x_axis_should_be_displayed_as_series_X_unit() throws Throwable {
		wait(2000);
		WebElement x_axis_ele = getElementByProperty(login.driver, "xaxis_ele", 10);
		if (x_axis_ele.getText().contains(selected_series_list.get(0).toString())
				&& x_axis_ele.getText().contains(unit_list.get(0).toString())) {
			login.Log4j.info("X-axis is displayed as series " + selected_series_list.get(0).toString() + ", "
					+ unit_list.get(0).toString());
		} else {
			AssertJUnit.fail("X-axis is not displayed as series X,unit");
		}
	}

	@Then("^Y-axis should be displayed as series Y,unit$")
	public void y_axis_should_be_displayed_as_series_Y_unit() throws Throwable {
		wait(2000);
		WebElement y_axis_ele = getElementByProperty(login.driver, "yaxis_ele", 10);
		if (y_axis_ele.getText().contains(selected_series_list.get(1).toString())
				&& y_axis_ele.getText().contains(unit_list.get(1).toString())) {
			login.Log4j.info("Y-axis is displayed as series " + selected_series_list.get(1).toString() + ", "
					+ unit_list.get(1).toString());
		} else {
			AssertJUnit.fail("Y-axis is not displayed as series Y,unit");
		}
	}

	@And("^Select any series more than (\\d+)$")
	public void select_any_series_more_than(int arg1) throws Throwable {
		login.Log4j.info("Clicking on  Series tab ");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Series_Tab"))))
				.click();
		wait(2000);

		List<WebElement> series = login.driver.findElements(By.xpath(
				"//div[@class='series-representation--list']/*//div[@class='series-list-item--checkbox-wrapper']"));
		List<WebElement> sName = login.driver.findElements(By.xpath("//*[@class='series-item--name']"));

		for (int i = 0; i < arg1 + 1; i++) {
			login.Log4j.info(i);
			wait(600);
			action.moveToElement(series.get(i)).click().build().perform();

			if (i == arg1) {
				action.contextClick(sName.get(i)).build().perform();
				break;
			}
		}

	}

	@Then("^Axes should not be visible$")
	public void axes_should_not_be_visible() throws Throwable {
		wait(2000);
		List<WebElement> x_axis_ele = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("xaxis_ele")));
		List<WebElement> y_axis_ele = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("yaxis_ele")));
		if (x_axis_ele.size() == 0 && y_axis_ele.size() == 0) {
			login.Log4j.info("Axes are not visible when series are selected more than 6");
		} else {
			AssertJUnit.fail("Axes are visible when series are selected more than 6");
		}
	}

	@Then("^\"([^\"]*)\" should be unchecked by default and adavnced settings option should be present$")
	public void should_be_unchecked_by_default_and_adavnced_settings_option_should_be_present(String arg1)
			throws Throwable {
		wait(2000);
		WebElement advanced_settings_icon = getElementByProperty(login.driver, "advanced_settings_icon", 4);
		boolean dataLabel_checkbox = login.driver
				.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]/parent::*//*[@type='checkbox']"))
				.isSelected();

		if (dataLabel_checkbox == false && advanced_settings_icon.isDisplayed() == true) {
			login.Log4j.info(arg1 + " is unchecked by default and adavnced settings option is present");
		} else {
			AssertJUnit.fail(arg1 + " is not checked by default and adavnced settings option is not present");
		}
	}

	@Then("^Should be display \"([^\"]*)\" that is disabled$")
	public void should_be_display_that_is_disabled(String arg1) throws Throwable {
		wait(2000);
		WebElement date_ele = getElementByProperty(login.driver, "Date_option", 4);
		if (date_ele.isDisplayed() == true) {
			login.Log4j.info(arg1 + " is disabled");
		} else {
			AssertJUnit.fail(arg1 + " is not disabled");
		}
	}

	@Then("^Date should be displayed on each bubble of visual$")
	public void date_should_be_displayed_on_each_bubble_of_visual() throws Throwable {
		wait(2000);
		List<WebElement> date_labels = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("data_labels_list")));

		if (date_labels.size() > 0) {
			login.Log4j.info("Date is displayed on each bubble of visual");
		} else {
			AssertJUnit.fail("Date is not displayed on each bubble of visual");
		}
	}

	@And("^Check \"([^\"]*)\" radio button$")
	public void check_radio_button(String arg1) throws Throwable {
		getElementByXpath(login.driver, "//*[@class='context-menu-control--title']//*[contains(text(),'Date')]", 4)
				.click();

		boolean size_radio_button = login.driver
				.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]/parent::*//*[@type='radio']")).isSelected();

		if (size_radio_button == false) {
			getElementByXpath(login.driver,
					"//*[contains(text(),'" + arg1 + "')]/parent::*//*[@class='input-control--indicator']", 10).click();
		}

	}

	@Then("^Size should be displayed on each bubble of visual$")
	public void size_should_be_displayed_on_each_bubble_of_visual() throws Throwable {
		wait(2000);
		List<WebElement> size_list = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("data_labels_list")));

		if (size_list.size() > 0) {
			login.Log4j.info("Size is displayed on each bubble of visual");
		} else {
			AssertJUnit.fail("Size is not displayed on each bubble of visual");
		}
	}

	@Then("^Region should be displayed on each bubble of visual$")
	public void region_should_be_displayed_on_each_bubble_of_visual() throws Throwable {
		wait(2000);
		List<WebElement> regions_list = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("data_labels_list")));

		if (regions_list.size() > 0) {
			login.Log4j.info("Region is displayed on each bubble of visual");
		} else {
			AssertJUnit.fail("Region is not displayed on each bubble of visual");
		}
	}

	@And("^Click on advanced settings icon$")
	public void click_on_advanced_settings_icon() throws Throwable {
		getElementByProperty(login.driver, "advanced_settings_icon", 4).click();
	}

	@And("^Choose \"([^\"]*)\" for labels$")
	public void choose_for_labels(String arg1) throws Throwable {
		wait(1000);
		if (arg1.equalsIgnoreCase("Style")) {
			data_labels_bold = getElementByXpath(login.driver,"//*[@name='data_labels_font_weight']", 4);
			data_labels_italic = getElementByXpath(login.driver,"//*[@name='data_labels_font_style']", 4);
			data_labels_underline = getElementByXpath(login.driver,"//*[@name='data_labels_font_underline']", 4);
			if (!(data_labels_bold.getAttribute("class").contains("selected"))) {
				data_labels_bold.click();
			}
			if (!(data_labels_italic.getAttribute("class").contains("selected"))) {
				data_labels_italic.click();
			}
			if (!(data_labels_underline.getAttribute("class").contains("selected"))) {
				data_labels_underline.click();
			}	
		} else {
			WebElement color = getElementByXpath(login.driver, "//*[@class='data-labels-config']//*[text()='" + arg1
					+ "']/parent::*//*[@class='color-picker--ui']/*", 4);
			color.click();

			// select Red color
			WebElement selected_color = getElementByProperty(login.driver, "Red_color", 4);
			Applied_color = selected_color.getCssValue("background-color");
			selected_color.click();
			// Close labels popUp
			getElementByProperty(login.driver, "close_labels_popup", 4).click();
		}

	}

	@Then("^Selected color should be applied on labels of visual$")
	public void selected_color_should_be_applied_on_labels_of_visual() throws Throwable {
		wait(2000);
		List<WebElement> labels_list = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("data_labels_list")));

		if (labels_list.size() > 0) {
			for (int i = 0; i < labels_list.size(); i++) {
				Expected_color = labels_list.get(i).getCssValue("color");
				String ExpectedColor = Color.fromString(Expected_color).asHex();
				// login.Log4j.info(ExpectedColor);
				String AppliedColor = Color.fromString(Applied_color).asHex();
				// login.Log4j.info(AppliedColor);
				login.Log4j.info("Selected color is applied on labels of visuals");
				Assert.assertEquals(AppliedColor, ExpectedColor);

			}

		} else {
			AssertJUnit.fail("List size is zero");
		}
	}

	@Then("^Selected highlight should be applied on labels of visual$")
	public void selected_highlight_should_be_applied_on_labels_of_visual() throws Throwable {
		wait(2000);
		List<WebElement> labels_list = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("labels_list")));

		if (labels_list.size() > 0) {
			for (int i = 0; i < labels_list.size(); i++) {
				Expected_color = labels_list.get(i).getCssValue("background-color");
				String ExpectedColor = Color.fromString(Expected_color).asHex();
				// login.Log4j.info(ExpectedColor);
				String AppliedColor = Color.fromString(Applied_color).asHex();
				// login.Log4j.info(AppliedColor);
				login.Log4j.info("Selected highlight is applied on labels of visuals");
				Assert.assertEquals(AppliedColor, ExpectedColor);

			}

		} else {
			AssertJUnit.fail("List size is zero");
		}
	}

	@Then("^Selected size should be applied on labels of visual$")
	public void selected_size_should_be_applied_on_labels_of_visual() throws Throwable {
		// Close labels popUp
		getElementByProperty(login.driver, "close_labels_popup", 4).click();
		wait(2000);
		List<WebElement> labels_list = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("data_labels_list")));

		if (labels_list.size() > 0) {
			for (int i = 0; i < labels_list.size(); i++) {
				String font_size = labels_list.get(i).getCssValue("font-size");
				String font_size_text[] = font_size.split("px");
				Integer expected = Integer.valueOf(font_size_text[0]);
				Integer actual = Integer.valueOf(data_labels_font_size);
				Assert.assertEquals(actual, expected);
				login.Log4j.info("Selected size is applied on labels of visuals");

			}

		} else {
			AssertJUnit.fail("List size is zero");
		}
	}
	@And("^Choose \"([^\"]*)\" for labels to (\\d+)$")
	public void choose_for_labels_to(String arg1, int arg2) throws Throwable {
		data_labels_font_size = Integer.toString(arg2);
		WebElement size = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='popover--wrapper']//*[@name='data_labels_font_size']", 4);
		size.sendKeys(Keys.chord(Keys.CONTROL, "a"), data_labels_font_size);
	}

	
	@Then("^Selected style should be applied on labels of visual$")
	public void selected_style_should_be_applied_on_labels_of_visual() throws Throwable {
		CommonFunctionality.wait(1000);
		List<WebElement> font_style = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("data_labels_list")));
		if (font_style.size() > 0) {
			for (int i = 0; i < font_style.size(); i++) {
				WebElement fontstyle = font_style.get(i);
				String font_bold = fontstyle.getCssValue("font-weight");
				String font_italic = fontstyle.getCssValue("font-style");
				String font_underline = fontstyle.getCssValue("text-decoration");
				assertTrue(font_bold.equals("bold") || font_bold.equals("700"));
				assertTrue(font_italic.equals("italic"));
				assertTrue(font_underline.contains("underline"));
				login.Log4j
						.info("The Selected styles has been applied on labels of visual");

			}
		} else {
			Assert.fail("List size is zero");

		}
	}
}
