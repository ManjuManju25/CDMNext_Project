package CDMNext.StepDefinations;

import static org.testng.Assert.fail;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Sprint_5_1 extends CommonFunctionality {

	@Given("^User selects Add continous series$")
	public void user_selects_Add_continous_series() throws Throwable {

		
			CommonFunctionality.wait(2000);

			login.driver.findElement(By.xpath("//span[normalize-space(text())='More']")).click();
			login.Log4j.info("Successfully More button Clicked ");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Continuous"))).click();
			login.Log4j.info("Successfully Continuous  button Clicked ");
		

	}

	@SuppressWarnings("deprecation")
	@Given("^Add Continuos Series into \"([^\"]*)\"$")
	public void add_Continuos_Series_into(String arg1) throws Throwable {

		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Series_click"))));
		//login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_click"))).click();
		CommonFunctionality.wait(2000);

		WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("mouseover")));
		CommonFunctionality.action.moveToElement(ele).pause(2).build().perform();
		WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("dp1")));
		CommonFunctionality.action.moveToElement(ele1).pause(2).click().build().perform();
		CommonFunctionality.wait(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add"))).click();
		String data1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("function"))).getText();
		
		

		

	}

	@Given("^\"([^\"]*)\" should display infront of series name$")
	public void should_display_infront_of_series_name(String arg1) throws Throwable {
		
		webDriverwait_locator(login.LOCATORS.getProperty("Continuos_Series1"), "xpath");
		String data = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Continuos_Series1"))).getText();
		Assert.assertEquals(data, "Continuous");

	}

	
	@Then("^Multiple continuos series with \"([^\"]*)\" but \"([^\"]*)\" should be added\\.$")
	public void multiple_continuos_series_with_but_should_be_added(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(3000);
		WebElement series = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("mouseover_series")));
		CommonFunctionality.action.moveToElement(series).pause(2).build().perform();
		WebElement dropdown = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("dropdown2")));
		CommonFunctionality.action.moveToElement(dropdown).pause(2).click().build().perform();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add"))).click();
		CommonFunctionality.wait(2000);
		if (CommonFunctionality.getElementByXpath(login.driver, login.LOCATORS.getProperty("function1"), 500)
				.isDisplayed()) {
		String data2 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("function1"))).getText(); 
		Assert.assertTrue(data2.contains("SPLICE"));
		login.Log4j.info("functions is displayed ");
		}
		else {
			login.Log4j.info("fail ");
		}
		
		
	}
	
	
	@Given("^User selects Notification tab\\.$")
	public void user_selects_Notification_tab() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("notification"))).click();
	}

	

	@Given("^Hide \"([^\"]*)\" from Demo users\\.$")
	public void hide_from_Demo_users(String arg1) throws Throwable {

		List<WebElement> WhatsNew = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("WhatsNew")));

		for (int i = 0; i < WhatsNew.size(); i++) {
			if (!WhatsNew.get(i).getText().contains("What's new")) {

				Assert.assertTrue(true);

			} else {

				Assert.assertTrue(false);

			}

		}

	}

	@Given("^user selects Data Briefings$")
	public void user_selects_Data_Briefings() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("DataBriefings"))).click();

	}

	@When("^user expands Data Briefings$")
	public void user_expands_Data_Briefings() throws Throwable {
		try {

			if ((login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Data_List"))).isDisplayed())) {

				login.Log4j.info("Data Briefings is already in open state");
			}

		} catch (Exception e) {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_DataBriefings"))).click();
			login.Log4j.info("Data Briefings gets expanded");
		}

	}

	@Then("^last editor name should be CEIC Insights for auto generated Data Briefings$")
	public void last_editor_name_should_be_CEIC_Insights_for_auto_generated_Data_Briefings() throws Throwable {

		try {
			CommonFunctionality.wait(3000);
			webDriverwait_locator(login.LOCATORS.getProperty("Data_List"), "xpath");
			String DataList = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Data_List"))).getText();
			CommonFunctionality.wait(3000);
			int sssss = DataList.length();
			if (DataList.length() > 0) {
				String ss = DataList.substring(18, DataList.length());
				System.out.println("=================" + ss);
				if (ss.contains("CEIC Insights")) {
					Assert.assertTrue(true, "CEIC Insights is available");
					login.Log4j.info(
							"last editor name should be CEIC Insights for auto generated Data Briefings -success");
				}

				else {
					Assert.assertTrue(false, "CEIC Insights is unavailable");
					login.Log4j
							.info("last editor name should be CEIC Insights for auto generated Data Briefings -Fail");
				}

			} else {
				fail("unable to fetch the data ");
				login.Log4j.info("last editor name should be CEIC Insights for auto generated Data Briefings -Fail");
			}

		} catch (Exception e) {
			if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Data_List"))).isDisplayed()) {
				String DataList = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Data_List"))).getText();
				CommonFunctionality.wait(3000);
				int sssss = DataList.length();
				if (DataList.length() > 0) {
					String ss = DataList.substring(18, DataList.length());
					if (ss.contains("CEIC Insights")) {
						Assert.assertTrue(true, "CEIC Insights is available");
						login.Log4j.info(
								"last editor name should be CEIC Insights for auto generated Data Briefings -success");
					}
				} else {
					Assert.assertTrue(false, "CEIC Insights is unavailable");
					login.Log4j
							.info("last editor name should be CEIC Insights for auto generated Data Briefings -Fail");
				}

			} else {
				fail("unable to fetch the data ");
				login.Log4j.info("last editor name should be CEIC Insights for auto generated Data Briefings -Fail");
			}

		}

	}

	

	

}
