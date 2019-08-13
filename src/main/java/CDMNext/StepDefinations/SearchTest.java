package CDMNext.StepDefinations;
import org.testng.AssertJUnit;
import CDMNext.util.CommonFunctionality;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SearchTest {
	public static String currentKeyword = "";
	private static Boolean logged = false;
	List<String> status = new ArrayList<>();
	public WebElement tooltip;
	public WebElement element;
	public WebElement checkbox;
	public WebElement ul_element;
	WebElement SeriesTab;
	public String TooltipInfo;
	String keyword;
	String[] listwords = null;
	Boolean CreateInsight = false;
	
	@Given("^User has successful logged in$")
	public static void user_has_successful_logged_in() throws Throwable {
		if (login.logged_in = false) {
			login.Invoke_browser();
			login.application_login();
			login.Log4j.info("It is in If block");
		} else if (login.logged_in = true && !SearchTest.logged) {
			login.application_login();
			SearchTest.logged = true;
			login.Log4j.info("It is in else If block");

		} else {
			login.Log4j.info("If User has already logged in pelase continue....");
		}

	}

	@Given("^User enters keyword \"([^\"]*)\"$")
	public void user_enters_keyword(String keyword) throws Throwable {
		Thread.sleep(5000);
		currentKeyword = keyword;
//		login.driver.navigate().refresh();
		
		login.Log4j.info("Searching with " + currentKeyword);
		try {
			CommonFunctionality.ClearSelection();
		} catch (Exception e) {
			//
		} finally {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).clear();
			Thread.sleep(7000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys(currentKeyword);
		}
	}

	@Then("^User verify keyword search results$")
	public void user_verify_keyword_search_results() throws Throwable {
		String Content = "";
		Boolean SynomymSearch = false;
		Thread.sleep(10000);
		login.Log4j.info("Clicking on  Series tab ");
		SeriesTab = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series")));
		SeriesTab.click();
		// text file location where it contains synonyms
		FileReader file = new FileReader(
				System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\Resources\\synonyms.txt");
		Scanner txtscan = new Scanner(file);
		// String[] listwords = null;
		while (txtscan.hasNextLine()) {
			Content = txtscan.nextLine();
			listwords = Content.trim().split("\\s*,\\s*");

			if (listwords[0].equals((currentKeyword))) {
				login.Log4j.info("Synonym text file contains " + currentKeyword);
				SynomymSearch = true;
				txtscan.close();
				file.close();
				break;

			} else {
				// move to next line

			}
		}

		if (SynomymSearch == false) {
			txtscan.close();
			file.close();
			listwords = new String[1];
			listwords[0] = currentKeyword;
			login.Log4j.info(listwords[0]);
		}

		ul_element = null;
		try {
			ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
			AssertJUnit.assertNotNull(ul_element);
			List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
			login.Log4j.info("List size is :" + li_All.size());

			if (li_All.size() > 0) {
				for (int i = 0; i < li_All.size(); i++) {
					login.Log4j.info(i);
					login.Log4j.info(li_All.size());
					Thread.sleep(3000);
					int j = i + 1;
					checkbox = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
					CommonFunctionality.action.moveToElement(checkbox).click().build().perform();
					Thread.sleep(500);
					element = login.driver.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
					CommonFunctionality.action.moveToElement(element).build().perform();
					Thread.sleep(1000);
					tooltip = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text")));
					TooltipInfo = tooltip.getText();
					login.Log4j.info("Title information is \n" + TooltipInfo);
					// Until the element is not visible keep scrolling
					CommonFunctionality.jse.executeScript("arguments[0].scrollIntoView(true);", element);
					
					Boolean KeywordMatch = false;
					switch (listwords.length) {
					case 1:
						if (search_validation(TooltipInfo, listwords[0]) == true) {
							login.Log4j.info(listwords[0] + " is exists in the" + "\n" + TooltipInfo);
							KeywordMatch = true;

						} else if (KeywordMatch == false) {
							sspValidation(j);
							if (search_validation(Filters.showdata, listwords[0]) == true) {
								login.Log4j.info(listwords[0] + " is exists in the" + "\n" + Filters.showdata);
								Thread.sleep(1000);
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
							} else {
								Thread.sleep(1000);
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
								Assert.fail(listwords[0] + " keyword doesn't exists in the " + TooltipInfo + " AND "
										+ "\n" + Filters.showdata);
							}
						}

						break;
					case 2:

						if (search_validation(TooltipInfo, listwords[0]) == true
								|| search_validation(TooltipInfo, listwords[1]) == true) {
							login.Log4j.info(listwords[0] + " OR " + listwords[1] + " exists in " + TooltipInfo);
							KeywordMatch = true;
						} else if (KeywordMatch == false) {
							sspValidation(j);
							if (search_validation(Filters.showdata, listwords[0]) == true
									|| search_validation(Filters.showdata, listwords[1]) == true) {
								login.Log4j.info(listwords[0] + " OR " + listwords[1] + " is exists in the " + "\n"
										+ Filters.showdata);
								Thread.sleep(1000);
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
							} else {
								Thread.sleep(1000);
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
								Assert.fail(listwords[0] + " OR " + listwords[1] + " keyword doesn't exists in the "
										+ TooltipInfo + " AND " + "\n" + Filters.showdata);
							}
						}

						break;
					case 3:
						if (search_validation(TooltipInfo, listwords[0]) == true
								|| search_validation(TooltipInfo, listwords[1]) == true
								|| search_validation(TooltipInfo, listwords[2]) == true) {
							login.Log4j.info(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2]
									+ " exists in " + TooltipInfo);
							KeywordMatch = true;

						} else if (KeywordMatch == false) {
							sspValidation(j);

							if (search_validation(Filters.showdata, listwords[0]) == true
									|| search_validation(Filters.showdata, listwords[1]) == true
									|| search_validation(Filters.showdata, listwords[2]) == true) {
								login.Log4j.info(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2]
										+ " exists in the " + "\n" + Filters.showdata);
								Thread.sleep(1000);
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
							} else {
								Thread.sleep(1000);
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
								Assert.fail(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2]
										+ " keyword doesn't exists in the " + TooltipInfo + " AND " + "\n"
										+ Filters.showdata);
							}
						}

						break;
					case 4:

						if (search_validation(TooltipInfo, listwords[0]) == true
								|| search_validation(TooltipInfo, listwords[1]) == true
								|| search_validation(TooltipInfo, listwords[2]) == true
								|| search_validation(TooltipInfo, listwords[3]) == true) {
							login.Log4j.info(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
									+ listwords[3] + " exists in " + TooltipInfo);
							KeywordMatch = true;

						} else if (KeywordMatch == false) {
							sspValidation(j);
							if (search_validation(Filters.showdata, listwords[0]) == true
									|| search_validation(Filters.showdata, listwords[1]) == true
									|| search_validation(Filters.showdata, listwords[2]) == true
									|| search_validation(Filters.showdata, listwords[3]) == true) {
								login.Log4j.info(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
										+ listwords[3] + " exists in the " + "\n" + Filters.showdata);
								Thread.sleep(1000);
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
							} else {
								Thread.sleep(1000);
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
								Assert.fail(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
										+ listwords[3] + " keyword doesn't exists in the " + TooltipInfo + " AND "
										+ "\n" + Filters.showdata);
							}
						}

						break;
					case 5:
						if (search_validation(TooltipInfo, listwords[0]) == true
								|| search_validation(TooltipInfo, listwords[1]) == true
								|| search_validation(TooltipInfo, listwords[2]) == true
								|| search_validation(TooltipInfo, listwords[3]) == true
								|| search_validation(TooltipInfo, listwords[4]) == true) {
							login.Log4j.info(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
									+ listwords[3] + " OR " + listwords[4] + " exists in " + TooltipInfo);
							KeywordMatch = true;

						} else if (KeywordMatch == false) {
							sspValidation(j);
							if (search_validation(Filters.showdata, listwords[0]) == true
									|| search_validation(Filters.showdata, listwords[1]) == true
									|| search_validation(Filters.showdata, listwords[2]) == true
									|| search_validation(Filters.showdata, listwords[3]) == true
									|| search_validation(Filters.showdata, listwords[4]) == true) {
								login.Log4j.info(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
										+ listwords[3] + " OR " + listwords[4] + "exists in the " + "\n"
										+ Filters.showdata);
								Thread.sleep(1000);
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
							} else {
								Thread.sleep(1000);
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
								Assert.fail(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
										+ listwords[3] + " OR " + listwords[4] + " keyword doesn't exists in the "
										+ TooltipInfo + " AND " + "\n" + Filters.showdata);
							}
						}

						break;
					case 6:
						if (search_validation(TooltipInfo, listwords[0]) == true
								|| search_validation(TooltipInfo, listwords[1]) == true
								|| search_validation(TooltipInfo, listwords[2]) == true
								|| search_validation(TooltipInfo, listwords[3]) == true
								|| search_validation(TooltipInfo, listwords[4]) == true
								|| search_validation(TooltipInfo, listwords[5]) == true) {
							login.Log4j.info(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
									+ listwords[3] + " OR " + listwords[4] + " OR " + listwords[5] + " exists in "
									+ TooltipInfo);
							KeywordMatch = true;

						} else if (KeywordMatch == false) {
							sspValidation(j);
							if (search_validation(Filters.showdata, listwords[0]) == true
									|| search_validation(Filters.showdata, listwords[1]) == true
									|| search_validation(Filters.showdata, listwords[2]) == true
									|| search_validation(Filters.showdata, listwords[3]) == true
									|| search_validation(Filters.showdata, listwords[4]) == true
									|| search_validation(Filters.showdata, listwords[5]) == true) {
								login.Log4j.info(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
										+ listwords[3] + " OR " + listwords[4] + " OR " + listwords[5]
										+ " exists in the " + "\n" + Filters.showdata);
								Thread.sleep(1000);
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();

							} else {
								Thread.sleep(1000);
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
								Assert.fail(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
										+ listwords[3] + " OR " + listwords[4] + " OR " + listwords[5]
										+ " keyword doesn't exists in the " + TooltipInfo + " AND " + "\n"
										+ Filters.showdata);
							}
						}

						break;
					case 7:
						if (search_validation(TooltipInfo, listwords[0]) == true
								|| search_validation(TooltipInfo, listwords[1]) == true
								|| search_validation(TooltipInfo, listwords[2]) == true
								|| search_validation(TooltipInfo, listwords[3]) == true
								|| search_validation(TooltipInfo, listwords[4]) == true
								|| search_validation(TooltipInfo, listwords[5]) == true
								|| search_validation(TooltipInfo, listwords[6]) == true) {
							login.Log4j.info(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
									+ listwords[3] + " OR " + listwords[4] + " OR " + listwords[5] + " OR "
									+ listwords[6] + " exists in " + TooltipInfo);
							KeywordMatch = true;

						} else if (KeywordMatch == false) {
							sspValidation(j);
							if (search_validation(Filters.showdata, listwords[0]) == true
									|| search_validation(Filters.showdata, listwords[1]) == true
									|| search_validation(Filters.showdata, listwords[2]) == true
									|| search_validation(Filters.showdata, listwords[3]) == true
									|| search_validation(Filters.showdata, listwords[4]) == true
									|| search_validation(Filters.showdata, listwords[5]) == true
									|| search_validation(Filters.showdata, listwords[6]) == true) {
								login.Log4j.info(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
										+ listwords[3] + " OR " + listwords[4] + " OR " + listwords[5] + " OR "
										+ listwords[6] + " exists in the " + "\n" + Filters.showdata);
								Thread.sleep(1000);
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();

							} else {
								Thread.sleep(1000);
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
								Assert.fail(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
										+ listwords[3] + " OR " + listwords[4] + " OR " + listwords[5] + " OR "
										+ listwords[6] + " keyword doesn't exists in the " + TooltipInfo + " AND "
										+ "\n" + Filters.showdata);
							}
						}

						break;
					case 8:
						if (search_validation(TooltipInfo, listwords[0]) == true
								|| search_validation(TooltipInfo, listwords[1]) == true
								|| search_validation(TooltipInfo, listwords[2]) == true
								|| search_validation(TooltipInfo, listwords[3]) == true
								|| search_validation(TooltipInfo, listwords[4]) == true
								|| search_validation(TooltipInfo, listwords[5]) == true
								|| search_validation(TooltipInfo, listwords[6]) == true
								|| search_validation(TooltipInfo, listwords[7]) == true) {
							login.Log4j.info(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
									+ listwords[3] + " OR " + listwords[4] + " OR " + listwords[5] + " OR "
									+ listwords[6] + " OR " + listwords[7] + " exists in " + TooltipInfo);
							KeywordMatch = true;

						} else if (KeywordMatch == false) {
							sspValidation(j);
							if (search_validation(Filters.showdata, listwords[0]) == true
									|| search_validation(Filters.showdata, listwords[1]) == true
									|| search_validation(Filters.showdata, listwords[2]) == true
									|| search_validation(Filters.showdata, listwords[3]) == true
									|| search_validation(Filters.showdata, listwords[4]) == true
									|| search_validation(Filters.showdata, listwords[5]) == true
									|| search_validation(Filters.showdata, listwords[6]) == true
									|| search_validation(Filters.showdata, listwords[7]) == true) {
								login.Log4j.info(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
										+ listwords[3] + " OR " + listwords[4] + " OR " + listwords[5] + " OR "
										+ listwords[6] + " OR " + listwords[7] + " exists in the " + "\n"
										+ Filters.showdata);
								Thread.sleep(1000);
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();

							} else {
								Thread.sleep(1000);
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
								Assert.fail(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
										+ listwords[3] + " OR " + listwords[4] + " OR " + listwords[5] + " OR "
										+ listwords[6] + " OR " + listwords[7] + " keyword doesn't exists in the "
										+ TooltipInfo + " AND " + "\n" + Filters.showdata);
							}
						}

						break;

					default:

						login.Log4j.error(
								currentKeyword + " has more than 8 synonyms which is not handled.  Please handle!");
						AssertJUnit.fail(
								currentKeyword + " has more than 8 synonyms which is not handled.  Please handle!");
					}

				}
			} else {
				AssertJUnit.fail("Sorry,No results were found ");
			}

		} catch (

		NoSuchElementException e) {

			AssertJUnit.fail(e.getMessage());

		} catch (StaleElementReferenceException | ElementNotVisibleException e) {

			AssertJUnit.fail("The WebElement is not visisble! " + e.getMessage());
		}

	}

	@Then("^User verifies keyword search results$")
	public void user_verifies_keyword_search_results() throws Throwable {
		login.Log4j.info("Clicking on  Series tab ");
		Thread.sleep(2000);
		SeriesTab = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series")));
		SeriesTab.click();

		ul_element = null;
		try {
			ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
			AssertJUnit.assertNotNull(ul_element);
			List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
			login.Log4j.info("List size is :" + li_All.size());
			if (li_All.size() > 0) {
				for (int i = 0; i < li_All.size(); i++) {
					login.Log4j.info(i);
					login.Log4j.info(li_All.size());
					Thread.sleep(3000);
					int j = i + 1;
					checkbox = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
					CommonFunctionality.action.moveToElement(checkbox).click().build().perform();
					Thread.sleep(1000);
					element = login.driver.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
					CommonFunctionality.action.moveToElement(element).build().perform();
					Thread.sleep(1500);
					tooltip = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text")));
					TooltipInfo = tooltip.getText();
					// Until the element is not visible keep scrolling
					CommonFunctionality.jse.executeScript("arguments[0].scrollIntoView(true);", element);
					
					Boolean KeywordMatch = false;
					if (currentKeyword.toUpperCase().contains("AND") && currentKeyword.toUpperCase().contains("OR")) {
						String[] keywords = currentKeyword.toUpperCase().trim().split("\\s*AND\\s*|\\s*OR\\s* ");
						login.Log4j.info("length is " + keywords.length);
						// login.Log4j.info(keywords[0]);
						// login.Log4j.info(keywords[1]);
						// login.Log4j.info(keywords[2]);
						if (currentKeyword.equalsIgnoreCase("capital AND price OR algeria")
								&& ((TooltipInfo.toUpperCase().contains(keywords[0]) == true
										&& TooltipInfo.toUpperCase().contains(keywords[1]) == true)
										|| TooltipInfo.toUpperCase().contains(keywords[2]) == true)) {
							login.Log4j.info(keywords[0] + " AND " + keywords[1] + " OR " + keywords[2] + " exists in "
									+ TooltipInfo);
						} else if (currentKeyword.equalsIgnoreCase("fuel OR price AND albania")
								&& (TooltipInfo.toUpperCase().contains(keywords[0]) == true
										|| (TooltipInfo.toUpperCase().contains(keywords[1]) == true
												&& TooltipInfo.toUpperCase().contains(keywords[2]) == true))) {
							login.Log4j.info(keywords[0] + " OR " + keywords[1] + " AND " + keywords[2] + " exists in "
									+ TooltipInfo);
						} else {
							sspValidation(j);
							login.Log4j.info(Filters.showdata);
							if (currentKeyword.equalsIgnoreCase("capital AND price OR algeria")) {
								if (Filters.showdata.toUpperCase().contains(keywords[0]) == true
										&& Filters.showdata.toUpperCase().contains(keywords[1]) == true
										|| Filters.showdata.toUpperCase().contains(keywords[2]) == true) {
									login.Log4j.info(keywords[0] + " AND " + keywords[1] + " OR " + keywords[2]
											+ " is exists in the" + "\n" + Filters.showdata);
									Thread.sleep(1000);
									login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction")))
											.click();
								} else if (TooltipInfo.toUpperCase().contains(keywords[0].toUpperCase()) == true
										&& Filters.showdata.toUpperCase().contains(keywords[1].toUpperCase()) == true
										|| TooltipInfo.toUpperCase().contains(keywords[2].toUpperCase()) == true) {
									login.Log4j.info(keywords[0] + " AND " + keywords[1] + " OR " + keywords[2]
											+ " is exists in the" + "\n" + Filters.showdata);
									Thread.sleep(1000);
									login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction")))
											.click();
								} else {
									Thread.sleep(1000);
									login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction")))
											.click();
									Assert.fail(keywords[0] + " AND " + keywords[1] + " OR " + keywords[2]
											+ " keyword doesn't exists " + Filters.showdata);
								}
							} else if (currentKeyword.equalsIgnoreCase("fuel OR price AND albania")) {
								if (Filters.showdata.toUpperCase().contains(keywords[0]) == true
										|| (Filters.showdata.toUpperCase().contains(keywords[1]) == true
												&& Filters.showdata.toUpperCase().contains(keywords[2]) == true)) {
									login.Log4j.info(keywords[0] + " OR " + keywords[1] + " AND " + keywords[2]
											+ " is exists in the" + "\n" + Filters.showdata);
									Thread.sleep(1000);
									login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction")))
											.click();
								} else {
									Thread.sleep(1000);
									login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction")))
											.click();
									Assert.fail(keywords[0] + " OR " + keywords[1] + " AND " + keywords[2]
											+ " keyword doesn't exists " + Filters.showdata);
								}
							}
						}

					} else if (currentKeyword.toUpperCase().contains("OR")
							&& currentKeyword.toUpperCase().contains("NOT")) {
						String[] keyword = currentKeyword.toUpperCase().trim().split("\\s*OR\\s*|\\s*NOT\\s*");
						login.Log4j.info(keyword[0]);
						login.Log4j.info(keyword[1]);
						login.Log4j.info(keyword[2]);

						if (currentKeyword.equalsIgnoreCase("population OR India NOT average")
								&& (TooltipInfo.toUpperCase().contains(keyword[0]) == true
										|| TooltipInfo.toUpperCase().contains(keyword[1]) == true
												&& TooltipInfo.toUpperCase().contains(keyword[2]) != true)) {
							login.Log4j.info(keyword[0] + " OR " + keyword[1] + " exists in " + TooltipInfo);

						} else if (currentKeyword.equalsIgnoreCase("gas NOT India OR state")
								&& (TooltipInfo.toUpperCase().contains(keyword[0]) == true
										&& TooltipInfo.toUpperCase().contains(keyword[1]) != true
										|| TooltipInfo.toUpperCase().contains(keyword[2]) == true)) {
							login.Log4j.info(keyword[0] + " OR " + keyword[2] + " exists in " + TooltipInfo);

						} else {
							sspValidation(j);
							login.Log4j.info(Filters.showdata);
							if (currentKeyword.equalsIgnoreCase("population OR India NOT average")) {
								if (Filters.showdata.toUpperCase().contains(keyword[0]) == true
										|| Filters.showdata.toUpperCase().contains(keyword[1]) == true
												&& Filters.showdata.toUpperCase().contains(keyword[2]) != true) {
									login.Log4j.info(keyword[0] + " OR " + keyword[1] + " is exists in the" + "\n"
											+ Filters.showdata);
									Thread.sleep(1000);
									login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction")))
											.click();
								} else {
									Thread.sleep(1000);
									login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction")))
											.click();
									Assert.fail(keyword[0] + " OR " + keyword[1] + " keyword doesn't exists "
											+ Filters.showdata);
								}

							} else if (currentKeyword.equalsIgnoreCase("gas NOT India OR state")) {
								if (Filters.showdata.toUpperCase().contains(keyword[0]) == true
										&& Filters.showdata.toUpperCase().contains(keyword[1]) != true
										|| Filters.showdata.toUpperCase().contains(keyword[2]) == true) {
									login.Log4j.info(keyword[0] + " OR " + keyword[2] + " is exists in the" + "\n"
											+ Filters.showdata);
									Thread.sleep(1000);
									login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction")))
											.click();
								} else {
									Thread.sleep(1000);
									login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction")))
											.click();
									Assert.fail(keyword[0] + " OR " + keyword[2] + " keyword doesn't exists "
											+ Filters.showdata);
								}
							}
						}

					} else if (currentKeyword.toUpperCase().contains("NOT")
							&& currentKeyword.toUpperCase().contains("AND")) {
						String[] keyword = currentKeyword.toUpperCase().trim().split("\\s*NOT\\s*|\\s*AND\\s*");
						login.Log4j.info(keyword[0]);
						login.Log4j.info(keyword[1]);
						login.Log4j.info(keyword[2]);
						if (TooltipInfo.toUpperCase().contains(keyword[0]) == true
								&& TooltipInfo.toUpperCase().contains(keyword[1]) != true
								&& TooltipInfo.toUpperCase().contains(keyword[2]) == true) {
							login.Log4j.info(keyword[0] + " AND " + keyword[2] + " exists in " + TooltipInfo);
						} else {
							sspValidation(j);
							login.Log4j.info(Filters.showdata);
							if (Filters.showdata.toUpperCase().contains(keyword[0]) == true
									&& Filters.showdata.toUpperCase().contains(keyword[1]) != true
									&& Filters.showdata.toUpperCase().contains(keyword[2]) == true) {
								login.Log4j.info(keyword[0] + " AND " + keyword[2] + " is exists in the" + "\n"
										+ Filters.showdata);
								Thread.sleep(1000);
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();

							} else {
								Thread.sleep(1000);
								login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
								Assert.fail(keyword[0] + " AND " + keyword[2] + " keywords doesn't exists "
										+ Filters.showdata);
							}
						}

					} else if (currentKeyword.toUpperCase().contains("AND")) {
						String[] keyword1 = currentKeyword.toUpperCase().split(" AND ");
						for (String result : keyword1) {
							login.Log4j.info(result);
							Thread.sleep(1000);
							if (TooltipInfo.toUpperCase().contains(result.toUpperCase()) == true) {
								login.Log4j.info(result + " exists in " + TooltipInfo);
							} else {
								Filters.showRelatedData(result, j);
								if (Filters.status == false) {
									Assert.fail(result + " keyword doesn't exists " + Filters.showdata);
								}
							}
						}

					} else if (currentKeyword.toUpperCase().contains("OR")) {
						String[] keywords = currentKeyword.toUpperCase().split(" OR ");
						login.Log4j.info("length is " + keywords.length);
						if ((keywords.length == 2) && TooltipInfo.toUpperCase().contains(keywords[0]) == true
								|| TooltipInfo.toUpperCase().contains(keywords[1]) == true) {
							login.Log4j.info(keywords[0] + " OR " + keywords[1] + " exists in " + TooltipInfo);

						} else if ((keywords.length == 3) && TooltipInfo.toUpperCase().contains(keywords[0]) == true
								|| TooltipInfo.toUpperCase().contains(keywords[1]) == true
								|| TooltipInfo.toUpperCase().contains(keywords[2]) == true) {
							login.Log4j.info(keywords[0] + " OR " + keywords[1] + " OR " + keywords[2] + " exists in "
									+ TooltipInfo);

						} else {

							for (String result : keywords) {
								Filters.showRelatedData(result, j);
								if (Filters.status == true) {
									break;
								} else if (Filters.status == false) {
									login.Log4j.error(result + " keyword doesn't exists " + Filters.showdata);
								}
							}
							if (Filters.status == false) {
								Assert.fail(currentKeyword + " keyword doesn't exists " + Filters.showdata);
							}
						}

					} else if (currentKeyword.toUpperCase().contains("NOT")) {
						String[] keywrd = currentKeyword.toUpperCase().split(" NOT ");
						// login.Log4j.info("length is " + keyword.length);
						if ((keywrd.length == 2) && TooltipInfo.toUpperCase().contains(keywrd[0]) == true
								&& TooltipInfo.toUpperCase().contains(keywrd[1]) != true) {
							login.Log4j.info(keywrd[0] + " exists in " + TooltipInfo);

						} else if ((keywrd.length == 3) && TooltipInfo.toUpperCase().contains(keywrd[0]) == true
								&& TooltipInfo.toUpperCase().contains(keywrd[1]) != true
								&& TooltipInfo.toUpperCase().contains(keywrd[2]) != true) {
							login.Log4j.info(keywrd[0] + " exists in " + TooltipInfo);

						} else {
							for (String result : keywrd) {
								Filters.showRelatedData(result, j);
								if (Filters.status == true) {
									break;
								} else {
									Assert.fail(result + " Keyword does not exists" + Filters.showdata);
								}
							}
						}
					} else if (Filters.searchData.contains("*")) {
						Thread.sleep(2000);
						String[] currentLine = Filters.searchData.split(";");
						login.Log4j.info(currentLine[0]);
						login.Log4j.info(currentLine[1]);
						for (String pair : currentLine) {
							String[] str = pair.split("\\*");
							for (String keyword : str) {
								login.Log4j.info(KeywordMatch);
								if (TooltipInfo.toUpperCase().contains(keyword.toUpperCase()) == true) {
									login.Log4j.info(keyword + " keyword exists in " + TooltipInfo);
									KeywordMatch = true;
									break;
								} else if (KeywordMatch == false) {
									Filters.showRelatedData(keyword, j);
									if (Filters.status == true) {
										KeywordMatch = true;
										break;
									} else if (Filters.status == false) {
										login.Log4j.error(keyword + " keyword doesn't exists " + Filters.showdata);
									}

								}
							}
							if (Filters.status == false) {
								Assert.fail(str + " keyword doesn't exists " + Filters.showdata);
							}
						}
					}
				}
			} else {
				Assert.fail("No results were found");
			}
		} catch (NoSuchElementException e) {
			Assert.fail("WebElement is null " + e.getMessage());
		}
		
	}

	public static void sspValidation(int j) throws InterruptedException {
		WebElement ele = login.driver.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
		Thread.sleep(2000);
		ele.click();

		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Related_Data"))).isDisplayed()) {
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Related_Data"))).click();
			List<WebElement> datasets = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("ssp_info")));
			for (WebElement list : datasets) {
				Filters.showdata = list.getText();
			}
		}
	}

	public boolean search_validation(String searchText, String listwords) throws Throwable {

		/*
		 * if (searchText.toUpperCase().contains(Keyword.toUpperCase()) == true) {
		 * return true; } else { return false; }
		 */
		String[] keywords = null;
		keywords = listwords.split(" ");
		switch (keywords.length) {
		case 1:
			if (searchText.toUpperCase().contains(keywords[0].toUpperCase()) == true) {
				return true;
			} else {
				return false;
			}

		case 2:
			if (searchText.toUpperCase().contains(keywords[0].toUpperCase()) == true
					&& searchText.toUpperCase().contains(keywords[1].toUpperCase()) == true) {
				return true;
			} else if (listwords.equals("agricultural machinery")) {
				if (searchText.toUpperCase().contains(keywords[0].toUpperCase()) == true
						|| searchText.toUpperCase().contains(keywords[1].toUpperCase()) == true) {
					return true;
				}
			} else {
				return false;
			}

		case 3:
			if (searchText.toUpperCase().contains(keywords[0].toUpperCase()) == true
					&& searchText.toUpperCase().contains(keywords[1].toUpperCase()) == true
					&& searchText.toUpperCase().contains(keywords[2].toUpperCase()) == true) {
				return true;
			} else {
				return false;
			}

		case 4:
			if (searchText.toUpperCase().contains(keywords[0].toUpperCase()) == true
					&& searchText.toUpperCase().contains(keywords[1].toUpperCase()) == true
					&& searchText.toUpperCase().contains(keywords[2].toUpperCase()) == true
					&& searchText.toUpperCase().contains(keywords[3].toUpperCase()) == true) {
				return true;
			} else {
				return false;
			}
		case 5:
			if (searchText.toUpperCase().contains(keywords[0].toUpperCase()) == true
					&& searchText.toUpperCase().contains(keywords[1].toUpperCase()) == true
					&& searchText.toUpperCase().contains(keywords[2].toUpperCase()) == true
					&& searchText.toUpperCase().contains(keywords[3].toUpperCase()) == true
					&& searchText.toUpperCase().contains(keywords[4].toUpperCase()) == true) {
				return true;
			} else {
				return false;
			}
		default:
			return false;

		}

	}

	// It will execute after every test execution
	@After
	public void takeScreenshotOnFailure(Scenario scenario) throws IOException {
		// if test case is failing then only it will enter into if condition
		if (scenario.isFailed()) {
			File srcFile = ((TakesScreenshot) login.driver).getScreenshotAs(OutputType.FILE);
			// scenario.getName() will return name of test case
			String var = scenario.getName();
			String[] TC = var.split(":");
			// TC[0] will return test case number so that screenshot name will be same as
			// test case number
			String dest = System.getProperty("user.dir") + "/ErrorScreenshot/" + TC[0] + ".png";
			File destFile = new File(dest);
			try {
				// Copy files to specific location
				FileUtils.copyFile(srcFile, destFile);
				login.Log4j.info("Screenshot is taken successfully.");

			} catch (IOException e) {
				login.Log4j.error("Exception while taking screenshot\n " + e.getMessage());

			}

		}
	}
}
