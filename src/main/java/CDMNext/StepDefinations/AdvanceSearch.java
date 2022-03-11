package CDMNext.StepDefinations;

import static org.testng.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class AdvanceSearch {
	WebDriverWait wait = new WebDriverWait(login.driver, 30);
	JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	String AllWords, AnyWords, ExactKeyword,Any_of_the_sid;
	String ExcludeKeyword;
	Actions action = new Actions(login.driver);
	SearchTest search = new SearchTest();

	@And("^Enter All of these words as \"([^\"]*)\"$")
	public void enter_All_of_these_words_as(String arg1) throws Throwable {
		AllWords = arg1;
		CommonFunctionality.getElementByXpath(login.driver, "//*[@name='all_words']", 10).sendKeys(arg1);
	}

	@Then("^All of the words should display in the result pane$")
	public void all_of_the_words_should_display_in_the_result_pane() throws Throwable {
		method_commonSteps();
		String[] keywords = AllWords.split(";");
		CommonFunctionality.wait(5000);
		List<WebElement> country_list = login.driver
				.findElements(By.xpath("//*[@class='series-item--country country-information']"));
		for (int i = 0; i < country_list.size(); i++) {
			if (country_list.get(i).getText().contains(keywords[0])
					|| country_list.get(i).getText().contains(keywords[1])
					|| country_list.get(i).getText().contains(keywords[2])
					|| country_list.get(i).getText().contains(keywords[3])) {
				login.Log4j.info(country_list.get(i).getText());
			} else {
				fail(country_list.get(i).getText() + " keyword not displayed");
			}
		}

	}

	@And("^Enter Any of these words as \"([^\"]*)\"$")
	public void enter_Any_of_these_words_as(String arg1) throws Throwable {
		AnyWords = arg1;
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@name='any_words']", 10).sendKeys(arg1);
	}

	@Then("^Any of the words should display in the result pane$")
	public void any_of_the_words_should_display_in_the_result_pane() throws Throwable {
		method_commonSteps();
		String[] listwords = AnyWords.split(";");
		CommonFunctionality.wait(5000);
		List<WebElement> sName = login.driver
				.findElements(By.xpath("//*[@class='search-series-list']/*//*[@class='series-item--name']"));
		for (int i = 0; i < sName.size(); i++) {
			login.Log4j.info(i);
			login.Log4j.info(sName.size());
			Thread.sleep(600);
			action.moveToElement(sName.get(i)).build().perform();
			Thread.sleep(800);
			WebElement tooltip = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text")));
			String TooltipInfo = tooltip.getText();

			boolean KeywordMatch = false;
			if (TooltipInfo.contains(listwords[0]) || TooltipInfo.contains(listwords[1])) {
				login.Log4j.info(listwords[0] + " OR " + listwords[1] + " is exists in the" + "\n" + TooltipInfo);
				KeywordMatch = true;

			} else if (KeywordMatch == false) {
				sName.get(i).click();
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Related_Data"))).isDisplayed()) {
					Thread.sleep(1000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Related_Data"))).click();
					List<WebElement> datasets = login.driver
							.findElements(By.xpath(login.LOCATORS.getProperty("ssp_info")));
					for (WebElement list : datasets) {
						Filters.showdata = list.getText();
					}
				}

				if (Filters.showdata.contains(listwords[0]) || Filters.showdata.contains(listwords[1])) {
					login.Log4j
							.info(listwords[0] + " OR " + listwords[1] + " is exists in the" + "\n" + Filters.showdata);
					CommonFunctionality.getElementByProperty(login.driver, "closeAction", 10).click();
					KeywordMatch = true;

				} else {
					CommonFunctionality.getElementByProperty(login.driver, "closeAction", 10).click();
					AssertJUnit.fail(listwords[0] + " OR " + listwords[1] + " keywords doesn't exists in the "
							+ TooltipInfo + "\n\n" + Filters.showdata + "\n\n");
				}
			}

			jse.executeScript("arguments[0].scrollIntoView(true);", sName.get(i));
		}

	}

	@And("^Enter Exact phrase as \"([^\"]*)\"$")
	public void enter_Exact_phrase_as(String arg1) throws Throwable {
		ExactKeyword = arg1;
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@name='exact_phrase']", 10).sendKeys(arg1);
	}

	@Then("^Exact keyword should display in the result pane$")
	public void exact_keyword_should_display_in_the_result_pane() throws Throwable {
		method_commonSteps();
		CommonFunctionality.wait(2000);
		List<WebElement> sName = login.driver
				.findElements(By.xpath("//*[@class='search-series-list']/*//*[@class='series-item--name']"));
		for (int i = 0; i < sName.size(); i++) {
			login.Log4j.info(i);
			login.Log4j.info(sName.size());
			Thread.sleep(600);
			action.moveToElement(sName.get(i)).build().perform();
			Thread.sleep(800);
			WebElement tooltip = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text")));
			String TooltipInfo = tooltip.getText();

			boolean KeywordMatch = false;
			if (TooltipInfo.contains(ExactKeyword)) {
				login.Log4j.info(ExactKeyword + " is exists in the" + "\n" + TooltipInfo);
				KeywordMatch = true;

			} else if (KeywordMatch == false) {
				sName.get(i).click();
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Related_Data"))).isDisplayed()) {
					Thread.sleep(1000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Related_Data"))).click();
					List<WebElement> datasets = login.driver
							.findElements(By.xpath(login.LOCATORS.getProperty("ssp_info")));
					for (WebElement list : datasets) {
						Filters.showdata = list.getText();
					}
				}

				if (Filters.showdata.contains(ExactKeyword)) {
					login.Log4j.info(ExactKeyword + " is exists in the" + "\n" + Filters.showdata);
					CommonFunctionality.getElementByProperty(login.driver, "closeAction", 10).click();
					KeywordMatch = true;

				} else {
					CommonFunctionality.getElementByProperty(login.driver, "closeAction", 10).click();
					AssertJUnit.fail(ExactKeyword + " keywords doesn't exists in the " + TooltipInfo + "\n\n"
							+ Filters.showdata + "\n\n");
				}
			}

			jse.executeScript("arguments[0].scrollIntoView(true);", sName.get(i));
		}
	}

@And("^Enter Any of these series IDs as \"([^\"]*)\"$")
public void enter_Any_of_these_series_IDs_as(String arg1) throws Throwable {
	Any_of_the_sid = arg1;
	CommonFunctionality.wait(1000);
	login.driver.findElement(By.name("series_ids")).sendKeys(arg1);
	//CommonFunctionality.getElementByXpath(login.driver, "//*[@name='series_ids']", 10).sendKeys(arg1);
}

	@Then("^Verify the Search results$")
	public void verify_the_Search_results() throws Throwable {
		String[] Expected_SID = Any_of_the_sid.split(";");
		CommonFunctionality.wait(2000);
		List<WebElement> sName = login.driver
				.findElements(By.xpath("//*[@class='search-series-list']/*//*[@class='series-item--name']"));
		for (int i = 0; i < sName.size(); i++) {
			login.Log4j.info(i);
			login.Log4j.info(sName.size());
			Thread.sleep(600);
			action.moveToElement(sName.get(i)).build().perform();
			Thread.sleep(800);
			WebElement tooltip = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text")));
			String TooltipInfo = tooltip.getText();

			if (TooltipInfo.contains(Expected_SID[0]) || TooltipInfo.contains(Expected_SID[1])) {
				login.Log4j.info(Expected_SID[0] + " OR " + Expected_SID[1] + " is exists in the" + "\n" + TooltipInfo);
			} else {

				AssertJUnit
						.fail(Expected_SID[0] + " OR " + Expected_SID[1] + " series ID  exists in the " + TooltipInfo);
			}

		}
	}

	@And("^Enter Exclude words as \"([^\"]*)\"$")
	public void enter_Exclude_words_as(String arg1) throws Throwable {
		ExcludeKeyword = arg1;
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@name='exclude_words']", 10).sendKeys(arg1);
	}

	@Then("^Search results should dispaly with out searching keywords$")
	public void search_results_should_dispaly_with_out_searching_keywords() throws Throwable {
		method_commonSteps();
		String[] ExcludeWords = ExcludeKeyword.split(";");
		CommonFunctionality.wait(5000);
		List<WebElement> sName = login.driver
				.findElements(By.xpath("//*[@class='search-series-list']//*[@class='series-item--name']"));
		for (int i = 0; i < sName.size(); i++) {
			login.Log4j.info(i);
			login.Log4j.info(sName.size());
			Thread.sleep(600);
			action.moveToElement(sName.get(i)).build().perform();
			Thread.sleep(800);
			WebElement tooltip = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text")));
			String TooltipInfo = tooltip.getText();

			if (!TooltipInfo.contains(ExcludeWords[0]) && !TooltipInfo.contains(ExcludeWords[1])) {
				login.Log4j.info(ExcludeWords[0] + " AND " + ExcludeWords[1] + " keywords does not exists in the" + "\n"
						+ TooltipInfo);

			} else {
				fail("Verification failed");
			}
			jse.executeScript("arguments[0].scrollIntoView(true);", sName.get(i));
		}

	}

	void method_commonSteps() throws InterruptedException {
		login.Log4j.info("Clicking on Series tab ");
		CommonFunctionality.wait(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Series"))));
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		CommonFunctionality.wait(5000);
			WebElement search_page_ele = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='search-series-pagination-count']", 10);
		jse.executeScript("arguments[0].scrollIntoView(true);", search_page_ele);
		CommonFunctionality.getElementByXpath(login.driver, "//select//option[@value='100']", 10).click();
		CommonFunctionality.TopMethod();
		CommonFunctionality.wait(5000);
		
	}
}
