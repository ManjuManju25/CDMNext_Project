package CDMNext.StepDefinations;

import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.validator.Var;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class Breakdown extends CommonFunctionality {
	List<String> listOfSelectedSeries = new ArrayList<>();
	String[] ExpectedStr;
	String ExpectedResult;

	@And("^Expand Global database till \"([^\"]*)\"$")
	public void expand_Global_database_till(String arg1) throws Throwable {
		wait(2000);
		getElementByProperty(login.driver, "Databases_Tab", 10).click();
		getElementByProperty(login.driver, "GlobalDb", 20).click();
		getElementByProperty(login.driver, "Global_AllRegions", 20).click();

		try {
		
			WebElement Belgium = getElementByXpath(login.driver, "//*[contains(text(),'Belgium')]", 20);
			jse.executeScript("arguments[0].scrollIntoView(true);", Belgium);
			wait(2000);
			WebElement Chad = getElementByXpath(login.driver, "//*[contains(text(),'Chad')]", 20);
			jse.executeScript("arguments[0].scrollIntoView(true);", Chad);
			wait(2000);
			WebElement Egypt = getElementByXpath(login.driver, "//*[contains(text(),'Egypt')]", 20);
			jse.executeScript("arguments[0].scrollIntoView(true);", Egypt);
			wait(2000);
			WebElement Greenland = getElementByXpath(login.driver, "//*[contains(text(),'Greenland')]", 20);
			jse.executeScript("arguments[0].scrollIntoView(true);", Greenland);
			wait(2000);
			WebElement Italy = getElementByXpath(login.driver, "//*[contains(text(),'Italy')]", 20);
			jse.executeScript("arguments[0].scrollIntoView(true);", Italy);
			wait(2000);
			WebElement Lithuania = getElementByXpath(login.driver, "//*[contains(text(),'Lithuania')]", 20);
			jse.executeScript("arguments[0].scrollIntoView(true);", Lithuania);
			wait(2000);
			WebElement Myanmar = getElementByXpath(login.driver, "//*[contains(text(),'Myanmar')]", 20);
			jse.executeScript("arguments[0].scrollIntoView(true);", Myanmar);
			wait(2000);
			WebElement Philippines = getElementByXpath(login.driver, "//*[contains(text(),'Philippines')]", 20);
			jse.executeScript("arguments[0].scrollIntoView(true);", Philippines);
			wait(2000);
			WebElement Slovakia = getElementByXpath(login.driver, "//*[contains(text(),'Slovakia')]", 20);
			jse.executeScript("arguments[0].scrollIntoView(true);", Slovakia);
			wait(2000);
			 WebElement country = getElementByXpath(login.driver,
			"//*[contains(text(),'" + arg1 + "')]/preceding::*[@class='toggle'][1]", 20);
			 country.click();
		} catch (Exception e) {

		}
		// WebElement country = getElementByXpath(login.driver,
		// "//*[contains(text(),'" + arg1 + "')]/preceding::*[@class='toggle'][1]", 20);
		  		//jse.executeScript("arguments[0].scrollIntoView(true);", country);
		//jse.executeScript("arguments[0].click();", country);
	}

	@And("^Expand \"([^\"]*)\" till first table level$")
	public void expand_till_first_table_level(String arg1) throws Throwable {
		getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]/preceding::*[@class='toggle'][1]", 20)
				.click();
		getElementByProperty(login.driver, "NationalAccounts_table_level", 20).click();

	}

	@Then("^The series should be grouped$")
	public void the_series_should_be_grouped() throws Throwable {
		wait(500);
		Boolean GroupCheckbox = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Group_checkbox")))
				.isSelected();
		Boolean Breakdown_control = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("Breakdown"))).isDisplayed();
		if (GroupCheckbox == true && Breakdown_control == true) {
			login.Log4j.info("The series are grouped");
		} else {
			fail("The series are not grouped");
		}
	}

	@Then("^The series grouped previously should be un-grouped$")
	public void the_series_grouped_previously_should_be_un_grouped() throws Throwable {
		wait(500);
		Boolean GroupCheckbox = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("Ungroup_checkbox")))
				.isSelected();

		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Breakdown"))).size() == 0
				&& GroupCheckbox == false) {
			login.Log4j.info("The series grouped previously get un-grouped");
		} else {
			fail("The series grouped previously not get un-grouped");
		}
	}

	@And("^Click on \"([^\"]*)\" option for the first group$")
	public void click_on_option_for_the_first_group(String arg1) throws Throwable {
		WebElement countryName_firstGroup = getElementByProperty(login.driver,"CountryName_firstGroup",	8);
		new Actions(login.driver).pause(200).moveToElement(countryName_firstGroup).build().perform();
		getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 8).click();
	}

	@Then("^All selected series should add to right pane-my series$")
	public void all_selected_series_should_add_to_right_pane_my_series() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("SeriesInRightPane"))).size() > 0) {
			login.Log4j.info("All selected series added to the right pane");
		} else {
			fail("All selected series not added to the right pane");
		}
	}

	@Then("^All selected series should get de-selected$")
	public void all_selected_series_should_get_de_selected() throws Throwable {
		Boolean selectAll = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SelectAll"))).isDisplayed();
		// check if first table is unselected
		wait(300);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("DeselectedSeries")))
				.size() == 0 && selectAll == true) {
			login.Log4j.info("All selected series get de-selected");
		} else {
			fail("All selected series doen't get de-selected");
		}
	}

	@And("^Add first series into right pane$")
	public void add_first_series_into_right_pane() throws Throwable {
		getElementByProperty(login.driver,
				"TableLeve_firstSeries",
				20).click();
	}

	@And("^Open Breakdown tab and select a few series$")
	public void open_Breakdown_tab_and_select_a_few_series() throws Throwable {
		getElementByProperty(login.driver, "BreakdownsTab", 20).click();

		List<WebElement> listOfElements = login.driver.findElements(By.xpath(login.LOCATORS.getProperty(
				"BreakdownTab_listOfSeries")));
		for (int i = 0; i < listOfElements.size(); i++) {
			int j = i + 1;
			new Actions(login.driver).pause(200).moveToElement(listOfElements.get(i)).click().build().perform();
			//listOfElements.get(i).click();
			WebElement ele = getElementByXpath(login.driver,
					"(//*[@class='breakdown-container breakdown-container__breakdown-visible'])[2]//ul/*[" + j
							+ "]//*[@class='series-item--name']",
					20);
//			new Actions(login.driver).pause(200).moveToElement(ele).build().perform();
//			String tooltipText = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text")))
//					.getText();
//			login.Log4j.info("Tooltip text is " + tooltipText);
			/*String[] lines = tooltipText.split("\n");
			String seriesName = null;
			for (String Tooltip : lines) {
				// String str=null;
				if (Tooltip.contains("Name:")) {
					seriesName = Tooltip;
					break;
				}
			}
			String[] str = seriesName.split("Name: ");

			listOfSelectedSeries.add(str[1]);*/
			listOfSelectedSeries.add(ele.getText());
			if (i == 2) {
				break;
			}
		}
	}

	@Then("^Selected series should be added into my series$")
	public void selected_series_should_be_added_into_my_series() throws Throwable {
		ArrayList<String> expectedArr = new ArrayList<>();
		wait(1000);
		List<WebElement> listOfElements = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("SelectedSeriesFromBreksDownTab")));
		for (int i = 0; i < listOfElements.size(); i++) {
			int j = i + 1;
			String Expectedstr = getElementByXpath(login.driver,
					"//*[@class='webix_cell new-series-item'][" + j + "]//*[@class='series-name-field--series-name']",
					20).getText();
			expectedArr.add(Expectedstr);

			/*if (!listOfSelectedSeries.contains(Expectedstr)) {
				fail("Selected series are not added into my series pane");
			}*/
		}
		int j = 0;
		for(String Actual: expectedArr) {
			for(int i = j ; i < listOfSelectedSeries.size(); ) {
				if(Actual.contains(listOfSelectedSeries.get(i))) {
					login.Log4j.info("Selected series are added into my series pane");
					
				} else {
					fail("Selected series are not added into my series pane");
				}
				j = i + 1;
				break;
			}
		}
		
	}

	@And("^Open Breakdown tab and click \"([^\"]*)\"$")
	public void open_Breakdown_tab_and_click(String arg1) throws Throwable {
		getElementByProperty(login.driver, "BreakdownsTab", 20).click();
		wait(500);
		WebElement ele = getElementByProperty(login.driver,
				"HoverOnSeriesName",
				8);
		new Actions(login.driver).pause(200).moveToElement(ele).build().perform();
		wait(200);
		getElementByProperty(login.driver, "SelectAll2ndLevel", 8).click();
		SelectAllSeries();
	}

	@Then("^All selected series should be added into my series$")
	public void all_selected_series_should_be_added_into_my_series() throws Throwable {
		selected_series_should_be_added_into_my_series();
	}

	@And("^Open Breakdown tab and select a series and click on chart icon$")
	public void open_Breakdown_tab_and_select_a_series_and_click_on_chart_icon() throws Throwable {
		getElementByXpath(login.driver, "//*[contains(text(),'Breakdowns')]", 20).click();
		WebElement ele1 = getElementByProperty(login.driver,
				"selectFirstSeries_breaksdownTab",
				6);
		new Actions(login.driver).moveToElement(ele1).build().perform();
		ele1.click();
		WebElement ele = getElementByProperty(login.driver,
				"firstSname_breaksdownTab",
				20);
		/*new Actions(login.driver).pause(200).moveToElement(ele).build().perform();
		String tooltipText = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text"))).getText();
		String[] lines = tooltipText.split("\n");
		String seriesName = null;
		for (String Tooltip : lines) {
			// String str=null;
			if (Tooltip.contains("Name:")) {
				seriesName = Tooltip;
				break;
			}
		}*/
	//	ExpectedStr = seriesName.split("Name: ");
		ExpectedResult = ele.getText();
		// Clicking Chart icon
		wait(200);
		WebElement ele2 = getElementByProperty(login.driver,
				"chartIcon",
				8);
		new Actions(login.driver).pause(200).moveToElement(ele2).click().build().perform();

	}

	@Then("^Respective chart should be created$")
	public void respective_chart_should_be_created() throws Throwable {
		wait(500);
		String ChartTitle = getElementByProperty(login.driver, "Visual_Title_Name", 8).getText();
	
		if (ChartTitle.contains(ExpectedResult)) {
			login.Log4j.info("Respective Chart is created");
		}  else {
			fail("Respective Chart is not created");
		}
	}

	@And("^Click to open SSP window$")
	public void click_to_open_SSP_window() throws Throwable {
		getElementByProperty(login.driver, "Series_Name", 8).click();
	}

	@Then("^Respective series has to be drilled down$")
	public void respective_series_has_to_be_drilled_down() throws Throwable {
		wait(1000);
		boolean backButton = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("BackButton"))).isDisplayed();
		wait(1000);
		boolean Drilldown_link = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("DrillDown_link")))
				.isDisplayed();
		if (backButton == true && Drilldown_link == true) {
			login.Log4j.info("Respective series has been drilled down");
		} else {
			fail("Respective series has not been drilled down");
		}

	}

	@Then("^Drilled down series should reset back to original series$")
	public void drilled_down_series_should_reset_back_to_original_series() throws Throwable {
		wait(1000);
		boolean backButton = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("BackButton"))).isDisplayed();
		wait(300);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("DrillDown_link"))).size() == 0
				&& !backButton == true) {
			login.Log4j.info("Drilled down series back to original series");
		} else {
			fail("Drilled down series doesn't back to original series");
		}
	}

	@And("^Expand \"([^\"]*)\" till second table level$")
	public void expand_till_second_table_level(String arg1) throws Throwable {
		getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]/preceding::*[@class='toggle'][1]", 20)
				.click();
		wait(500);
		getElementByProperty(login.driver, "secondTableLevel", 20).click();
	}

	void SelectAllSeries() throws Exception {
		List<WebElement> listOfElements = login.driver.findElements(By.xpath(login.LOCATORS.getProperty(
				"SelectAllSeries_BeakdownTab")));
		for (int i = 0; i < listOfElements.size(); i++) {
			// int j = i + 1;
			wait(200);
			String sname = listOfElements.get(i).getText();
			
	/*			new Actions(login.driver).pause(200).moveToElement(listOfElements.get(i)).build().perform();
			String tooltipText = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text")))
					.getText();
			String[] lines = tooltipText.split("\n");
			String seriesName = null;
			for (String Tooltip : lines) {
				// String str=null;
				if (Tooltip.contains("Name:")) {
					seriesName = Tooltip;
					break;
				}
			}
			String[] str = seriesName.split("Name: ");
			listOfSelectedSeries.add(str[1]);*/
			listOfSelectedSeries.add(sname);
			// Mouse hovor on Breakdowns element
			new Actions(login.driver).pause(100)
					.moveToElement(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("BreakdownsTab")))).build()
					.perform();

		}
		login.Log4j.info(listOfSelectedSeries);

	}
}
