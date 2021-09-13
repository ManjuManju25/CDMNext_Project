package CDMNext.StepDefinations;

import org.testng.Assert;
import org.testng.AssertJUnit;

import CDMNext.util.CommonFunctionality;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SearchTest {
	public static String currentKeyword = "";
	public static Boolean logged = false;
	List<String> status = new ArrayList<>();
	public WebElement tooltip;
	public WebElement element;
	public WebElement checkbox;
	public WebElement ul_element;
	WebElement SeriesTab;
	public String TooltipInfo;
	String keyword,economic_zone;
	static String SeriesInfo;
	String[] listwords = null;
	List<String> ExpectedKeyword = new ArrayList<>();
	Boolean CreateInsight = false;
	WebDriverWait wait = new WebDriverWait(login.driver, 2000);
	Actions action = new Actions(login.driver);
	JavascriptExecutor jse = (JavascriptExecutor) login.driver;

	@Given("^User has successful logged in$")
	public static void user_has_successful_logged_in() throws Throwable {
		if (login.logged_in = false) {
			//login.Log4j.info("It is in If block");
			login.Invoke_browser();
			login.application_login();

		} else if (login.logged_in = true && !SearchTest.logged) {
			//login.Log4j.info("It is in else If block");
			login.application_login();
			SearchTest.logged = true;

		} else {
			//login.Log4j.info("If User has already logged in pelase continue....");
		}

	}

	@Given("^User enters keyword \"([^\"]*)\"$")
	public void user_enters_keyword(String keyword) throws Throwable {
		currentKeyword = keyword;
//		login.driver.navigate().refresh();
//		CommonFunctionality.ResetMethod();
		login.Log4j.info("Searching with " + currentKeyword);
		CommonFunctionality.getElementByProperty(login.driver,"Search",10).sendKeys(currentKeyword);
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		
	}

	@SuppressWarnings("deprecation")
	@Then("^User verify keyword search results$")
	public void user_verify_keyword_search_results() throws Throwable {
		String Content = "";
		Boolean SynomymSearch = false;
		login.Log4j.info("Clicking on  Series tab ");
		SeriesTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(login.LOCATORS.getProperty("Series"))));
		SeriesTab.click();
		// text file location where it contains synonyms
		FileReader file = new FileReader(
				System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\Resources\\LatestSynonymFile.txt");
		Scanner txtscan = new Scanner(file);
		
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
			CommonFunctionality.wait(2000);
			ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
			AssertJUnit.assertNotNull(ul_element);
//			List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
//			login.Log4j.info("List size is :" + li_All.size());
			List<WebElement> sName = login.driver.findElements(By.xpath("//*[@class='series-item--name']"));
			// List<WebElement> checkBox = login.driver
			// .findElements(By.xpath("//li//div[@class='series-list-item--checkbox-wrapper']"));
			if (sName.size() > 0) {
				for (int i = 0; i < sName.size(); i++) {
					login.Log4j.info(i);
					login.Log4j.info(sName.size());
					//Thread.sleep(500);
					int j = i + 1;
					// action.moveToElement(checkBox.get(i)).click().build().perform();
					action.pause(700).moveToElement(sName.get(i)).build().perform();
					CommonFunctionality.wait(800);
					tooltip = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text")));
					TooltipInfo = tooltip.getText();
					login.Log4j.info("Title information is \n" + TooltipInfo);
					// Until the element is not visible keep scrolling
					//jse.executeScript("arguments[0].scrollIntoView(true);", sName.get(i));

					Boolean KeywordMatch = false;
					for(String keyword : listwords) {
						if (search_validation(TooltipInfo, keyword) == true) {
							login.Log4j.info(keyword + " is exists in the" + "\n" + TooltipInfo);
							KeywordMatch = true;
							break;
						} else if (KeywordMatch == false) {
							sspValidation(j);
							
							if (search_validation(Filters.showdata, keyword) == true) {
								login.Log4j.info(keyword + " is exists in the" + "\n" + Filters.showdata);
								CommonFunctionality.getElementByProperty(login.driver, "closeAction", 10).click();
								KeywordMatch = true;
								break;
							} else if(search_validation(SeriesInfo, keyword) == true){
								login.Log4j.info(keyword + " is exists in the" + "\n" + SeriesInfo);
								CommonFunctionality.getElementByProperty(login.driver, "closeAction", 10).click();
								KeywordMatch = true;
								break;
							} else {
								ExpectedKeyword.add(keyword);
								CommonFunctionality.getElementByProperty(login.driver, "closeAction", 10).click();
								
							}
						}
					}
					 if (KeywordMatch == false) {
						 //login.Log4j.info(ExpectedKeyword);
						// CommonFunctionality.getElementByProperty(login.driver, "closeAction", 6).click();
							AssertJUnit.fail(ExpectedKeyword + " keywords doesn't exists in the " + TooltipInfo
									 + "\n\n" + Filters.showdata +"\n\n"+ SeriesInfo);
					 }
					
					jse.executeScript("arguments[0].scrollIntoView(true);", sName.get(i));
				}
			} else {
				Assert.fail("Sorry,No results were found ");
			}

		} catch (

		NoSuchElementException e) {

			Assert.fail(e.getMessage());

		} catch (StaleElementReferenceException | ElementNotVisibleException e) {

			Assert.fail("The WebElement is not visisble! " + e.getMessage());
		}

	}

	@Then("^User verifies keyword search results$")
	public void user_verifies_keyword_search_results() throws Throwable {
		login.Log4j.info("Clicking on  Series tab ");
		// Thread.sleep(2000);
		SeriesTab = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Series"))));
		SeriesTab.click();

		ul_element = null;
		try {
			CommonFunctionality.wait(2000);
			ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
			AssertJUnit.assertNotNull(ul_element);
//			List<WebElement> li_All = login.driver.findElements(By.xpath("//*[@class='series-item--name']"));
//			login.Log4j.info("List size is :" + li_All.size());
			List<WebElement> sName = login.driver.findElements(By.xpath("//ul[@class='search-series-list']/*//*[@class='series-item--name']"));
			if (sName.size() > 0) {
				for (int i = 0; i < sName.size(); i++) {
					int j = i + 1;
					login.Log4j.info(i);
					login.Log4j.info(sName.size());
					Thread.sleep(600);
					// checkbox = login.driver.findElement(By.xpath("//li[" + j +
					// "]//div[@class='series-list-item--checkbox-wrapper']"));
					// CommonFunctionality.action.moveToElement(checkbox).click().build().perform();
					// Thread.sleep(1000);
					action.moveToElement(sName.get(i)).build().perform();
					Thread.sleep(800);
					tooltip = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text")));
					TooltipInfo = tooltip.getText();
					// Until the element is not visible keep scrolling
					jse.executeScript("arguments[0].scrollIntoView(true);", sName.get(i));

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
									CommonFunctionality.getElementByProperty(login.driver, "closeAction", 4).click();
								} else if (TooltipInfo.toUpperCase().contains(keywords[0].toUpperCase()) == true
										&& Filters.showdata.toUpperCase().contains(keywords[1].toUpperCase()) == true
										|| TooltipInfo.toUpperCase().contains(keywords[2].toUpperCase()) == true) {
									login.Log4j.info(keywords[0] + " AND " + keywords[1] + " OR " + keywords[2]
											+ " is exists in the" + "\n" + Filters.showdata);
									CommonFunctionality.getElementByProperty(login.driver, "closeAction", 4).click();
								} else if(TooltipInfo.toUpperCase().contains(keywords[1].toUpperCase()) == true && Filters.showdata.toUpperCase().contains(keywords[0].toUpperCase()) == true){

									login.Log4j.info(keywords[0] + " AND " + keywords[1] + " is exists in the" + "\n"
											+ Filters.showdata);
									CommonFunctionality.getElementByProperty(login.driver, "closeAction", 4).click();
								}else {
									CommonFunctionality.getElementByProperty(login.driver, "closeAction", 4).click();
									AssertJUnit.fail(keywords[0] + " AND " + keywords[1] + " OR " + keywords[2]
											+ " keyword doesn't exists " + Filters.showdata);
								}
							} else if (currentKeyword.equalsIgnoreCase("fuel OR price AND albania")) {
								if (Filters.showdata.toUpperCase().contains(keywords[0]) == true
										|| (Filters.showdata.toUpperCase().contains(keywords[1]) == true
												&& Filters.showdata.toUpperCase().contains(keywords[2]) == true)) {
									login.Log4j.info(keywords[0] + " OR " + keywords[1] + " AND " + keywords[2]
											+ " is exists in the" + "\n" + Filters.showdata);
									CommonFunctionality.getElementByProperty(login.driver, "closeAction", 4).click();
								} else {
									CommonFunctionality.getElementByProperty(login.driver, "closeAction", 4).click();
									AssertJUnit.fail(keywords[0] + " OR " + keywords[1] + " AND " + keywords[2]
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
									CommonFunctionality.getElementByProperty(login.driver, "closeAction", 4).click();
								} else {
									CommonFunctionality.getElementByProperty(login.driver, "closeAction", 4).click();
									AssertJUnit.fail(keyword[0] + " OR " + keyword[1] + " keyword doesn't exists "
											+ Filters.showdata);
								}

							} else if (currentKeyword.equalsIgnoreCase("gas NOT India OR state")) {
								if (Filters.showdata.toUpperCase().contains(keyword[0]) == true
										&& Filters.showdata.toUpperCase().contains(keyword[1]) != true
										|| Filters.showdata.toUpperCase().contains(keyword[2]) == true) {
									login.Log4j.info(keyword[0] + " OR " + keyword[2] + " is exists in the" + "\n"
											+ Filters.showdata);
									CommonFunctionality.getElementByProperty(login.driver, "closeAction", 4).click();
								} else {
									CommonFunctionality.getElementByProperty(login.driver, "closeAction", 4).click();
									AssertJUnit.fail(keyword[0] + " OR " + keyword[2] + " keyword doesn't exists "
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
								CommonFunctionality.getElementByProperty(login.driver, "closeAction", 4).click();

							} else {
								CommonFunctionality.getElementByProperty(login.driver, "closeAction", 4).click();
								AssertJUnit.fail(keyword[0] + " AND " + keyword[2] + " keywords doesn't exists "
										+ Filters.showdata);
							}
						}

					} else if (currentKeyword.toUpperCase().contains("AND")) {
						String[] keyword1 = currentKeyword.toUpperCase().split(" AND ");
						for (String result : keyword1) {
							login.Log4j.info(result);
							Thread.sleep(500);
							if (TooltipInfo.toUpperCase().contains(result.toUpperCase()) == true) {
								login.Log4j.info(result + " exists in " + TooltipInfo);
							} else {
								Filters.showRelatedData(result, j);
								if (Filters.status == false) {
									AssertJUnit.fail(result + " keyword doesn't exists " + Filters.showdata);
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
								AssertJUnit.fail(currentKeyword + " keyword doesn't exists " + Filters.showdata);
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
									AssertJUnit.fail(result + " Keyword does not exists" + Filters.showdata);
								}
							}
						}
					} else if (Filters.searchData.contains("*")) {
						Thread.sleep(1000);
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
								AssertJUnit.fail(str[0] + " OR " + str[1] + " keyword doesn't exists " + Filters.showdata);
							}
						}
					}
				}
			} else {
				AssertJUnit.fail("No results were found");
			}
		} catch (NoSuchElementException e) {
			AssertJUnit.fail("WebElement is null " + e.getMessage());
		}

	}
	@And("^User selects economic zone \"([^\"]*)\"$")
	public void user_selects_economic_zone(String arg1) throws Throwable {
		economic_zone = arg1;
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='navigation-sidebar navigation-sidebar__expanded']//*[contains(text(),'" + arg1 + "')]", 15).click();
	}

	@SuppressWarnings("deprecation")
	@Then("^Search for corresponding regions$")
	public void search_for_corresponding_regions() throws Throwable {
		String Content = "";
		CommonFunctionality.wait(2000);
		SeriesTab = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Series"))));
		SeriesTab.click();
		// text file location where it contains synonyms
				FileReader file = new FileReader(
						System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\Resources\\LatestSynonymFile.txt");
				Scanner txtscan = new Scanner(file);
				// String[] listwords = null;
				while (txtscan.hasNextLine()) {
					Content = txtscan.nextLine();
					listwords = Content.trim().split("\\s*,\\s*");

					if (listwords[0].equals((economic_zone))) {
						login.Log4j.info("Synonym text file contains " + economic_zone);
						txtscan.close();
						file.close();
						break;

					} else {
						// move to next line

					}
				}

		ul_element = null;
		try {
			CommonFunctionality.wait(2000);
			ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
			AssertJUnit.assertNotNull(ul_element);
			List<WebElement> sName = login.driver.findElements(By.xpath("//ul[@class='search-series-list']/*//*[@class='series-item--name']"));
			login.Log4j.info("List size is :" + sName.size());
			
			for (int i = 0; i < sName.size(); i++) {
				login.Log4j.info(i);
				action.pause(700).moveToElement(sName.get(i)).build().perform();
				CommonFunctionality.wait(800);
				tooltip = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text")));
				TooltipInfo = tooltip.getText();
				login.Log4j.info("Title information is \n" + TooltipInfo);
				// Until the element is not visible keep scrolling
				jse.executeScript("arguments[0].scrollIntoView(true);", sName.get(i));
				String Region_text = null;
				String[] lines = TooltipInfo.split("\n");

				for (String Tooltip : lines) {
					if (Tooltip.contains("Subnational")) {
						Region_text = Tooltip;
						break;
					}
				}
				Boolean Result = false;
				String[] subnational =  Region_text.split(":");
				for(String ExpectedRegion : listwords) {
					if(subnational[1].trim().contains(ExpectedRegion)) {
						login.Log4j.info(subnational[1] + " series are shown ");
						Result = true;
						break;
					} 
				}
				if(Result == false) {
					Assert.fail(subnational[1] + " series are not shown");
				}
				
			}
		} catch (Exception e) {
			Assert.fail("No results were found");
		}

	}
	@SuppressWarnings("deprecation")
	@Then("^Verify the search results for given SerisTag$")
	public void verify_the_search_results_for_given_SerisTag() throws Throwable {
		
		SeriesTab = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Series"))));
		SeriesTab.click();
		ul_element = null;
		String[] lines = null;
		String sid = null;
		try {
			CommonFunctionality.wait(2000);
			ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
			List<WebElement> li_All = login.driver.findElements(By.xpath("//*[@class='series-item--name']"));
			login.Log4j.info("List size is :" + li_All.size());
			//List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
			//login.Log4j.info("List size is :" + li_All.size());
			
			if (li_All.size() == 1) {
				WebElement sName = CommonFunctionality.getElementByXpath(login.driver,"//*[@class='series-item--name']" , 4);
				action.pause(500).moveToElement(sName).build().perform();
				TooltipInfo = CommonFunctionality.getElementByProperty(login.driver, "tooltip_text", 4).getText();
				lines = TooltipInfo.split("\n");
				for (String TooltipTxt : lines) {
					if (TooltipTxt.contains("Series id")) {
						sid = TooltipTxt;
						break;
					}
				}
				if (sid.contains(currentKeyword)) {
					login.Log4j.info(currentKeyword + " exists in tooltip");
				} else {
					Assert.fail(currentKeyword + " doesn't exists in tooltip");
				}

			} else if (li_All.size() > 1) {
				Assert.fail("Number of search results :" + li_All.size());
			}
		} catch (Exception e) {
			Assert.fail("Sorry,No results found here.");
		}
	}
	public static void sspValidation(int j) throws InterruptedException {
		WebElement ele = login.driver.findElement(By.xpath("//ul[@class='search-series-list']/*[" + j + "]//*[@class='series-item--name']"));
		Thread.sleep(1000);
		ele.click();
		List<WebElement> series_Info = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("seriesInfo")));
		for (WebElement list : series_Info) {
			SeriesInfo = list.getText();
		}
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Related_Data"))).isDisplayed()) {
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Related_Data"))).click();
			List<WebElement> datasets = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("ssp_info")));
			for (WebElement list : datasets) {
				Filters.showdata = list.getText();
			}
		}
	}

	boolean search_validation(String searchText, String listwords) throws Throwable {
		
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

}
