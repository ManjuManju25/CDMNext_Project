package CDMNext.StepDefinations;

import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class Breakdown {
	JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	List<String> listOfSelectedSeries = new ArrayList<>();
	String[] ExpectedStr;
	@And("^Expand Global database till \"([^\"]*)\"$")
	public void expand_Global_database_till(String arg1) throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Databases_Tab",10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@data-node-model-id='GLOBAL']/*[1]", 20).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@data-node-model-id='GLOBAL']/*[3]/*[1]/*[1]", 20)
				.click();
		WebElement country = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'" + arg1 + "')]/preceding::*[@class='toggle'][1]", 20);
		jse.executeScript("arguments[0].scrollIntoView(true);", country);
		jse.executeScript("arguments[0].click();", country);
	}

	@And("^Expand \"([^\"]*)\" till first table level$")
	public void expand_till_first_table_level(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'" + arg1 + "')]/preceding::*[@class='toggle'][1]", 20).click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(@class,'open last-open-node')]/*[3]/*[1]/*[1]", 20)
				.click();

	}

	@Then("^The series should be grouped$")
	public void the_series_should_be_grouped() throws Throwable {
		CommonFunctionality.wait(500);
		Boolean GroupCheckbox = login.driver.findElement(By.xpath(
				"//*[@class='indented-tree-control indented-tree-control__visible indented-tree-control__selected']/*[1]/*[@type = 'checkbox']"))
				.isSelected();
		Boolean Breakdown_control = login.driver.findElement(By.xpath("//*[@class='breakdown-control']")).isDisplayed();
		if (GroupCheckbox == true && Breakdown_control == true) {
			login.Log4j.info("The series are grouped");
		} else {
			fail("The series are not grouped");
		}
	}

	@Then("^The series grouped previously should be un-grouped$")
	public void the_series_grouped_previously_should_be_un_grouped() throws Throwable {
		CommonFunctionality.wait(500);
		Boolean GroupCheckbox = login.driver.findElement(By
				.xpath("//*[@class='indented-tree-control indented-tree-control__visible']/*[1]/*[@type = 'checkbox']"))
				.isSelected();

		if (login.driver.findElements(By.xpath("//*[@class='breakdown-control']")).size() == 0
				&& GroupCheckbox == false) {
			login.Log4j.info("The series grouped previously get un-grouped");
		} else {
			fail("The series grouped previously not get un-grouped");
		}
	}

	@And("^Click on \"([^\"]*)\" option for the first group$")
	public void click_on_option_for_the_first_group(String arg1) throws Throwable {
		WebElement countryName_firstGroup = CommonFunctionality.getElementByXpath(login.driver,
				"//ul[@class='search-series-list scrollable']/*[1]//*[@class='series-item--country country-information']",
				8);
		new Actions(login.driver).pause(200).moveToElement(countryName_firstGroup).build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 8).click();
	}

	@Then("^All selected series should add to right pane-my series$")
	public void all_selected_series_should_add_to_right_pane_my_series() throws Throwable {
		if (login.driver.findElements(By.xpath("//*[@class='series-name-field']")).size() > 0) {
			login.Log4j.info("All selected series added to the right pane");
		} else {
			fail("All selected series not added to the right pane");
		}
	}

	@Then("^All selected series should get de-selected$")
	public void all_selected_series_should_get_de_selected() throws Throwable {
		Boolean selectAll = login.driver.findElement(By.xpath("//*[contains(text(),'Select All')]")).isDisplayed();
		// check if first table is unselected
		CommonFunctionality.wait(300);
		if (login.driver.findElements(By.xpath("//*[@class='svg-checkbox svg-checkbox__partially-selected']"))
				.size() == 0 && selectAll == true) {
			login.Log4j.info("All selected series get de-selected");
		} else {
			fail("All selected series doen't get de-selected");
		}
	}

	@And("^Add first series into right pane$")
	public void add_first_series_into_right_pane() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'full-expanded open')]/*[3]/*[1]//ul/*[1]//*[@class='add-to-data-selection--icon']",
				20).click();
	}

	@And("^Open Breakdown tab and select a few series$")
	public void open_Breakdown_tab_and_select_a_few_series() throws Throwable {
		CommonFunctionality
		.getElementByXpath(login.driver, "//*[contains(text(),'Breakdowns')]", 20)
		.click();
		
		List<WebElement> listOfElements = login.driver.findElements(By.xpath("(//*[@class='breakdown-container breakdown-container__breakdown-visible'])[2]//ul//div//span[contains(@class,'svg-checkbox')]"));
		for(int i = 0; i < listOfElements.size(); i++) {
			int j = i + 1;
			listOfElements.get(i).click();
			WebElement ele = CommonFunctionality
					.getElementByXpath(login.driver, "(//*[@class='breakdown-container breakdown-container__breakdown-visible'])[2]//ul/*[" + j + "]//*[@class='series-item--name']", 20);
			new Actions(login.driver).pause(200).moveToElement(ele).build().perform();
			String tooltipText = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text"))).getText();
			String[]  lines = tooltipText.split("\n");
			String seriesName = null;
			for (String Tooltip : lines) {
				// String str=null;
				 if (Tooltip.contains("Name:")) {
					seriesName = Tooltip;
					break;
				 }
			}
			String[] str = seriesName.split("Name: ");
			
			listOfSelectedSeries.add(str[1]);
			if(i == 2) {
				break;
			}
		}
	}

	@Then("^Selected series should be added into my series$")
	public void selected_series_should_be_added_into_my_series() throws Throwable {
		CommonFunctionality.wait(1000);
		List<WebElement> listOfElements = login.driver
				.findElements(By.xpath("//*[@class='webix_cell new-series-item']//*[@class='series-name-field']"));
		for (int i = 0; i < listOfElements.size(); i++) {
			int j = i + 1;
			String Expectedstr = CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[@class='webix_cell new-series-item'][" + j + "]//*[@class='series-name-field--series-name']", 20)
					.getText();

			if (!listOfSelectedSeries.contains(Expectedstr)) {
				fail("Selected series are not added into my series pane");
			}
		}
		login.Log4j.info("Selected series are added into my series pane");
	}
	@And("^Open Breakdown tab and click \"([^\"]*)\"$")
	public void open_Breakdown_tab_and_click(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Breakdowns')]", 20).click();
		CommonFunctionality.wait(500);
		WebElement ele = CommonFunctionality
				.getElementByXpath(login.driver, "(//*[@class='breakdown-control breakdown-control__open'])[2]", 8);
		new Actions(login.driver).pause(200).moveToElement(ele).build().perform();
		CommonFunctionality.wait(200);
		CommonFunctionality.getElementByXpath(login.driver, "(//*[contains(text(),'Select All')])[2]", 8).click();
		SelectAllSeries();
	}

	@Then("^All selected series should be added into my series$")
	public void all_selected_series_should_be_added_into_my_series() throws Throwable {
		selected_series_should_be_added_into_my_series();
	}
	@And("^Open Breakdown tab and select a series and click on chart icon$")
	public void open_Breakdown_tab_and_select_a_series_and_click_on_chart_icon() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Breakdowns')]", 20).click();
		CommonFunctionality.getElementByXpath(login.driver,"(//*[@class='breakdown-container breakdown-container__breakdown-visible'])[2]//ul/*[1]//span[contains(@class,'svg-checkbox')]",6).click();
		WebElement ele = CommonFunctionality
				.getElementByXpath(login.driver, "(//*[@class='breakdown-container breakdown-container__breakdown-visible'])[2]//ul/*[1]//*[@class='series-item--name']", 20);
		new Actions(login.driver).pause(200).moveToElement(ele).build().perform();
		String tooltipText = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text"))).getText();
		String[]  lines = tooltipText.split("\n");
		String seriesName = null;
		for (String Tooltip : lines) {
			// String str=null;
			 if (Tooltip.contains("Name:")) {
				seriesName = Tooltip;
				break;
			 }
		}
		ExpectedStr = seriesName.split("Name: ");
		//Clicking Chart icon
		CommonFunctionality.wait(200);
		WebElement ele1 = CommonFunctionality
				.getElementByXpath(login.driver,"(//*[@class='breakdown-container breakdown-container__breakdown-visible'])[2]//ul/*[1]//*[@class='view-chart-icon menu-icon']",8);
		new Actions(login.driver).pause(200).moveToElement(ele1).click().build().perform();
	
		
		
	}

	@Then("^Respective chart should be created$")
	public void respective_chart_should_be_created() throws Throwable {
		CommonFunctionality.wait(500);
		String ChartTitle = CommonFunctionality.getElementByXpath(login.driver,"//*[@data-name='title']",8).getText();
		if(ChartTitle.equalsIgnoreCase(ExpectedStr[1])) {
			login.Log4j.info("Respective Chart is created");
		} else {
			fail("Respective Chart is not created");
		}
	}
	@And("^Click to open SSP window$")
	public void click_to_open_SSP_window() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,"//*[@class='series-name-field--series-name']",8).click();
	}

	@Then("^Respective series has to be drilled down$")
	public void respective_series_has_to_be_drilled_down() throws Throwable {
		CommonFunctionality.wait(1000);
	   boolean backButton = login.driver.findElement(By.xpath("//*[@class='breakdown-preview--back']")).isDisplayed();
	   CommonFunctionality.wait(1000);
	   boolean Drilldown_link = login.driver.findElement(By.xpath("//*[@class='legend-drilldown--link']")).isDisplayed();
	   if(backButton == true && Drilldown_link == true) {
		   login.Log4j.info("Respective series has been drilled down");
	   } else {
		   fail("Respective series has not been drilled down");
	   }
	   
	}
	@Then("^Drilled down series should reset back to original series$")
	public void drilled_down_series_should_reset_back_to_original_series() throws Throwable {
		CommonFunctionality.wait(1000);
		   boolean backButton = login.driver.findElement(By.xpath("//*[@class='breakdown-preview--back']")).isDisplayed();
		   CommonFunctionality.wait(300);
		   if(login.driver.findElements(By.xpath("//*[@class='legend-drilldown--link']")).size() == 0 && !backButton == true){
		   	   login.Log4j.info("Drilled down series back to original series");
		   } else {
			   fail("Drilled down series doesn't back to original series");
		   }
	}
	@And("^Expand \"([^\"]*)\" till second table level$")
	public void expand_till_second_table_level(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'" + arg1 + "')]/preceding::*[@class='toggle'][1]", 20).click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(@class,'open last-open-node')]/*[3]/*[2]/*[1]", 20)
				.click();
	}
	void SelectAllSeries() throws Exception {
		List<WebElement> listOfElements = login.driver.findElements(By.xpath("(//*[@class='breakdown-container breakdown-container__breakdown-visible'])[2]//ul/*//*[@class='series-item--name']"));
		for(int i = 0; i < listOfElements.size(); i++) {
			//int j = i + 1;
			CommonFunctionality.wait(200);
			new Actions(login.driver).pause(200).moveToElement(listOfElements.get(i)).build().perform();
			String tooltipText = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text"))).getText();
			String[]  lines = tooltipText.split("\n");
			String seriesName = null;
			for (String Tooltip : lines) {
				// String str=null;
				 if (Tooltip.contains("Name:")) {
					seriesName = Tooltip;
					break;
				 }
			}
			String[] str = seriesName.split("Name: ");
			listOfSelectedSeries.add(str[1]);
			//Mouse hovor on Breakdowns element
			new Actions(login.driver).pause(100).moveToElement(login.driver.findElement(By.xpath("//*[contains(text(),'Breakdowns')]"))).build().perform();

			
		}
		login.Log4j.info(listOfSelectedSeries);
		
	}
}
