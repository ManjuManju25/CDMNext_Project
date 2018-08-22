
package CDMNext.StepDefinations;

import org.testng.AssertJUnit;

import com.sun.mail.imap.protocol.Status;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//import java.text.SimpleDateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Date;
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

	@Given("^User has successful logged in$")
	public void user_has_successful_logged_in() throws Throwable {

		if (login.logged_in = false) {
			login.Invoke_browser();
			login.application_login();

		} else if (login.logged_in = true && !SearchTest.logged) {
			login.application_login();
			SearchTest.logged = true;

		} else {
			login.Log4j.info("If User has already logged in pelase continue....");

		}
	}

	@Given("^User enters keyword \"([^\"]*)\"$")
	public void user_enters_keyword(String keyword) throws Throwable {
		currentKeyword = keyword;
		Thread.sleep(3000);
		login.Log4j.info("Searching with " + currentKeyword);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).clear();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys(currentKeyword);

	}

	@Then("^User verify keyword search results$")
	public void user_verify_keyword_search_results() throws Throwable {

		WebElement element;
		WebElement checkbox;

		String text;
		String Content = "";
		Boolean SynomymSearch = false;
		Thread.sleep(10000);
		login.Log4j.info("Clicking on  Series tab ");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		// text file location where it contains synonyms
		FileReader file = new FileReader(
				System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\Resources\\synonyms.txt");
		Scanner txtscan = new Scanner(file);
		String[] listwords = null;
		while (txtscan.hasNextLine()) {
			Content = txtscan.nextLine();
			listwords = Content.trim().split("\\s*,\\s*");
			
			if (listwords[0].equalsIgnoreCase((currentKeyword))) {
				login.Log4j.info("Synonym text file contains " + currentKeyword);
				SynomymSearch = true;
				txtscan.close();
				file.close();
				break;

			} else {
				// move to next line
				// after first commit
			}
		}

		if (SynomymSearch == false) {
			txtscan.close();
			file.close();
			listwords = new String[1];
			listwords[0] = currentKeyword;
			login.Log4j.info(listwords[0]);

		}

		login.Log4j.info("Array size is " + listwords.length);
		// create instance of JavaScriptExecutor
		JavascriptExecutor jse = (JavascriptExecutor) login.driver;
		// create object of Actions class
		Actions mouseOver = new Actions(login.driver);

		WebElement ul_element = null;
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
							.findElement(By.xpath("//li[" + j + "]//span[@class='series-list-item--checkbox']"));
					mouseOver.moveToElement(checkbox).click().build().perform();

					element = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item-data']"));
					mouseOver.moveToElement(element).build().perform();

					// Until the element is not visible keep scrolling
					jse.executeScript("arguments[0].scrollIntoView(true);", element);
					text = element.getAttribute("title");
					// login.Log4j.info("Title information is \n" + text);
					
					 /*Boolean KeywordMatch = false;
					 for (String keyword : listwords) {
					   login.Log4j.info(keyword);
					 
					    if (text.toUpperCase().contains(keyword.toUpperCase()) == true) {
					      login.Log4j.info(keyword + " is exists in the" + "\n" + text); 
					      KeywordMatch = true; 
					      break;
					 
					     } else if (KeywordMatch == false) { 
					    	 WebElement ele =login.driver.findElement( By.xpath("//li[" + j + "]//div[@class='series-list-item-data--name']")); Thread.sleep(1000);
					      ele.click();
					 
					       if (login.driver.findElement(By.xpath("//div[contains(text(),'Datasets')]")).isDisplayed()) {
					    	   Thread.sleep(1000);
					           login.driver.findElement(By.xpath("//div[contains(text(),'Datasets')]")).click(); 
					           List<WebElement> datasets = login.driver.findElements(By.xpath("//div[@class='ps-container ps-theme-default']")); 
					           for(WebElement list : datasets) { 
					        	   Filters.showdata = list.getText();
					               login.Log4j.info(keyword);
					               if(Filters.showdata.toUpperCase().contains(keyword.toUpperCase()) == true) {
					               login.Log4j.info(keyword + " is exists in the" + "\n" + Filters.showdata);
					               Thread.sleep(1000);
					               login.driver.findElement(By.xpath("//div[@title='Close']")).click();
					               KeywordMatch = true;
					               break;
					               } else {
					            	 Thread.sleep(1000);
					                 login.driver.findElement(By.xpath("//div[@title='Close']")).click();
					                 status.add(keyword); } } } } }
					                 //login.Log4j.info(KeywordMatch); 
					                 if (KeywordMatch == false) {
					                	 for (String failure : status) { 
					                		 Assert.fail(failure + " keyword doesn't exists in " + text + " AND " + "\n" + Filters.showdata); } }
					*/
					Boolean KeywordMatch = false;

					switch (listwords.length) {
					case 1:
						if (text.toUpperCase().contains(listwords[0].toUpperCase()) == true) {
							login.Log4j.info(listwords[0] + " is exists in the" + "\n" + text);
							KeywordMatch = true;
						} else if (KeywordMatch == false) {
							WebElement ele = login.driver.findElement(
									By.xpath("//li[" + j + "]//div[@class='series-list-item-data--name']"));
							Thread.sleep(1000);
							ele.click();

							if (login.driver.findElement(By.xpath("//div[contains(text(),'Datasets')]"))
									.isDisplayed()) {
								Thread.sleep(1000);
								login.driver.findElement(By.xpath("//div[contains(text(),'Datasets')]")).click();
								List<WebElement> datasets = login.driver
										.findElements(By.xpath("//div[@class='ps-container ps-theme-default']"));
								for (WebElement list : datasets) {
									Filters.showdata = list.getText();
									if (Filters.showdata.toUpperCase().contains(listwords[0].toUpperCase()) == true) {
										login.Log4j.info(listwords[0] + " is exists in the" + "\n" + Filters.showdata);
										Thread.sleep(1000);
										login.driver.findElement(By.xpath("//div[@title='Close']")).click();

									} else {
										Thread.sleep(1000);
										login.driver.findElement(By.xpath("//div[@title='Close']")).click();
										Assert.fail(listwords[0] + " keyword doesn't exists in the " + text + " AND "
												+ "\n" + Filters.showdata);
									}
								}
							}
						}
						break;
					case 2:

						if (text.toUpperCase().contains(listwords[0].toUpperCase()) == true
								|| text.toUpperCase().contains(listwords[1].toUpperCase()) == true) {
							login.Log4j.info(listwords[0] + " OR " + listwords[1] + " exists in " + text);
							KeywordMatch = true;
						} else if (KeywordMatch == false) {
							WebElement ele = login.driver.findElement(
									By.xpath("//li[" + j + "]//div[@class='series-list-item-data--name']"));
							Thread.sleep(1000);
							ele.click();

							if (login.driver.findElement(By.xpath("//div[contains(text(),'Datasets')]"))
									.isDisplayed()) {
								Thread.sleep(1000);
								login.driver.findElement(By.xpath("//div[contains(text(),'Datasets')]")).click();
								List<WebElement> datasets = login.driver
										.findElements(By.xpath("//div[@class='ps-container ps-theme-default']"));
								for (WebElement list : datasets) {
									Filters.showdata = list.getText();
									if (Filters.showdata.toUpperCase().contains(listwords[0].toUpperCase()) == true
											|| Filters.showdata.toUpperCase()
													.contains(listwords[1].toUpperCase()) == true) {
										login.Log4j.info(listwords[0] + " OR " + listwords[1] + " is exists in the "
												+ "\n" + Filters.showdata);
										Thread.sleep(1000);
										login.driver.findElement(By.xpath("//div[@title='Close']")).click();

									} else {
										Thread.sleep(1000);
										login.driver.findElement(By.xpath("//div[@title='Close']")).click();
										Assert.fail(
												listwords[0] + " OR " + listwords[1] + " keyword doesn't exists in the "
														+ text + " AND " + "\n" + Filters.showdata);
									}
								}
							}
						}
						break;
					case 3:

						if (text.toUpperCase().contains(listwords[0].toUpperCase()) == true
								|| text.toUpperCase().contains(listwords[1].toUpperCase()) == true
								|| text.toUpperCase().contains(listwords[2].toUpperCase()) == true) {
							login.Log4j.info(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2]
									+ " exists in " + text);
							KeywordMatch = true;

						} else if (KeywordMatch == false) {
							WebElement ele = login.driver.findElement(
									By.xpath("//li[" + j + "]//div[@class='series-list-item-data--name']"));
							Thread.sleep(1000);
							ele.click();

							if (login.driver.findElement(By.xpath("//div[contains(text(),'Datasets')]"))
									.isDisplayed()) {
								Thread.sleep(1000);
								login.driver.findElement(By.xpath("//div[contains(text(),'Datasets')]")).click();
								List<WebElement> datasets = login.driver
										.findElements(By.xpath("//div[@class='ps-container ps-theme-default']"));
								for (WebElement list : datasets) {
									Filters.showdata = list.getText();
									if (Filters.showdata.toUpperCase().contains(listwords[0].toUpperCase()) == true
											|| Filters.showdata.toUpperCase()
													.contains(listwords[1].toUpperCase()) == true
											|| Filters.showdata.toUpperCase()
													.contains(listwords[2].toUpperCase()) == true) {
										login.Log4j.info(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2]
												+ " exists in the " + "\n" + Filters.showdata);
										Thread.sleep(1000);
										login.driver.findElement(By.xpath("//div[@title='Close']")).click();

									} else {
										Thread.sleep(1000);
										login.driver.findElement(By.xpath("//div[@title='Close']")).click();
										Assert.fail(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2]
												+ " keyword doesn't exists in the " + text + " AND " + "\n"
												+ Filters.showdata);
									}
								}
							}

						}

						break;
					case 4:

						if (text.toUpperCase().contains(listwords[0].toUpperCase()) == true
								|| text.toUpperCase().contains(listwords[1].toUpperCase()) == true
								|| text.toUpperCase().contains(listwords[2].toUpperCase()) == true
								|| text.toUpperCase().contains(listwords[3].toUpperCase()) == true) {
							login.Log4j.info(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
									+ listwords[3] + " exists in " + text);
							KeywordMatch = true;

						} else if (KeywordMatch == false) {
							WebElement ele = login.driver.findElement(
									By.xpath("//li[" + j + "]//div[@class='series-list-item-data--name']"));
							Thread.sleep(1000);
							ele.click();

							if (login.driver.findElement(By.xpath("//div[contains(text(),'Datasets')]"))
									.isDisplayed()) {
								Thread.sleep(1000);
								login.driver.findElement(By.xpath("//div[contains(text(),'Datasets')]")).click();
								List<WebElement> datasets = login.driver
										.findElements(By.xpath("//div[@class='ps-container ps-theme-default']"));
								for (WebElement list : datasets) {
									Filters.showdata = list.getText();
									if (Filters.showdata.toUpperCase().contains(listwords[0].toUpperCase()) == true
											|| Filters.showdata.toUpperCase()
													.contains(listwords[1].toUpperCase()) == true
											|| Filters.showdata.toUpperCase()
													.contains(listwords[2].toUpperCase()) == true
											|| Filters.showdata.toUpperCase()
													.contains(listwords[3].toUpperCase()) == true) {
										login.Log4j.info(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2]
												+ " OR " + listwords[3] + " exists in the " + "\n" + Filters.showdata);
										Thread.sleep(1000);
										login.driver.findElement(By.xpath("//div[@title='Close']")).click();

									} else {
										Thread.sleep(1000);
										login.driver.findElement(By.xpath("//div[@title='Close']")).click();
										Assert.fail(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2]
												+ " OR " + listwords[3] + " keyword doesn't exists in the " + text
												+ " AND " + "\n" + Filters.showdata);
									}
								}
							}

						}
						break;
					case 5:
						if (text.toUpperCase().contains(listwords[0].toUpperCase()) == true
								|| text.toUpperCase().contains(listwords[1].toUpperCase()) == true
								|| text.toUpperCase().contains(listwords[2].toUpperCase()) == true
								|| text.toUpperCase().contains(listwords[3].toUpperCase()) == true
								|| text.toUpperCase().contains(listwords[4].toUpperCase()) == true) {
							login.Log4j.info(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
									+ listwords[3] + " OR " + listwords[4] + " exists in " + text);
							KeywordMatch = true;

						} else if (KeywordMatch == false) {
							WebElement ele = login.driver.findElement(
									By.xpath("//li[" + j + "]//div[@class='series-list-item-data--name']"));
							Thread.sleep(1000);
							ele.click();

							if (login.driver.findElement(By.xpath("//div[contains(text(),'Datasets')]"))
									.isDisplayed()) {
								Thread.sleep(1000);
								login.driver.findElement(By.xpath("//div[contains(text(),'Datasets')]")).click();
								List<WebElement> datasets = login.driver
										.findElements(By.xpath("//div[@class='ps-container ps-theme-default']"));
								for (WebElement list : datasets) {
									Filters.showdata = list.getText();
									if (Filters.showdata.toUpperCase().contains(listwords[0].toUpperCase()) == true
											|| Filters.showdata.toUpperCase()
													.contains(listwords[1].toUpperCase()) == true
											|| Filters.showdata.toUpperCase()
													.contains(listwords[2].toUpperCase()) == true
											|| Filters.showdata.toUpperCase()
													.contains(listwords[3].toUpperCase()) == true
											|| Filters.showdata.toUpperCase()
													.contains(listwords[4].toUpperCase()) == true) {
										login.Log4j.info(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2]
												+ " OR " + listwords[3] + " OR " + listwords[4] + "exists in the " + "\n"
												+ Filters.showdata);
										Thread.sleep(1000);
										login.driver.findElement(By.xpath("//div[@title='Close']")).click();

									} else {
										Thread.sleep(1000);
										login.driver.findElement(By.xpath("//div[@title='Close']")).click();
										Assert.fail(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2]
												+ " OR " + listwords[3] + " OR " + listwords[4]
												+ " keyword doesn't exists in the " + text + " AND " + "\n"
												+ Filters.showdata);
									}
								}
							}

						}
						break;
					case 6:
						if (text.toUpperCase().contains(listwords[0].toUpperCase()) == true
								|| text.toUpperCase().contains(listwords[1].toUpperCase()) == true
								|| text.toUpperCase().contains(listwords[2].toUpperCase()) == true
								|| text.toUpperCase().contains(listwords[3].toUpperCase()) == true
								|| text.toUpperCase().contains(listwords[4].toUpperCase()) == true
								|| text.toUpperCase().contains(listwords[5].toUpperCase()) == true) {
							login.Log4j.info(
									listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR " + listwords[3]
											+ " OR " + listwords[4] + " OR " + listwords[5] + " exists in " + text);
							KeywordMatch = true;

						} else if (KeywordMatch == false) {
							WebElement ele = login.driver.findElement(
									By.xpath("//li[" + j + "]//div[@class='series-list-item-data--name']"));
							Thread.sleep(1000);
							ele.click();

							if (login.driver.findElement(By.xpath("//div[contains(text(),'Datasets')]"))
									.isDisplayed()) {
								Thread.sleep(1000);
								login.driver.findElement(By.xpath("//div[contains(text(),'Datasets')]")).click();
								List<WebElement> datasets = login.driver
										.findElements(By.xpath("//div[@class='ps-container ps-theme-default']"));
								for (WebElement list : datasets) {
									Filters.showdata = list.getText();
									if (Filters.showdata.toUpperCase().contains(listwords[0].toUpperCase()) == true
											|| Filters.showdata.toUpperCase()
													.contains(listwords[1].toUpperCase()) == true
											|| Filters.showdata.toUpperCase()
													.contains(listwords[2].toUpperCase()) == true
											|| Filters.showdata.toUpperCase()
													.contains(listwords[3].toUpperCase()) == true
											|| Filters.showdata.toUpperCase()
													.contains(listwords[4].toUpperCase()) == true
											|| Filters.showdata.toUpperCase()
													.contains(listwords[5].toUpperCase()) == true) {
										login.Log4j.info(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2]
												+ " OR " + listwords[3] + " OR " + listwords[4] + " OR " + listwords[5]
												+ " exists in the " + "\n" + Filters.showdata);
										Thread.sleep(1000);
										login.driver.findElement(By.xpath("//div[@title='Close']")).click();

									} else {
										Thread.sleep(1000);
										login.driver.findElement(By.xpath("//div[@title='Close']")).click();
										Assert.fail(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2]
												+ " OR " + listwords[3] + " OR " + listwords[4] + " OR " + listwords[5]
												+ " keyword doesn't exists in the " + text + " AND " + "\n"
												+ Filters.showdata);
									}
								}
							}

						}
						break;
					case 7:
						if (text.toUpperCase().contains(listwords[0].toUpperCase()) == true
								|| text.toUpperCase().contains(listwords[1].toUpperCase()) == true
								|| text.toUpperCase().contains(listwords[2].toUpperCase()) == true
								|| text.toUpperCase().contains(listwords[3].toUpperCase()) == true
								|| text.toUpperCase().contains(listwords[4].toUpperCase()) == true
								|| text.toUpperCase().contains(listwords[5].toUpperCase()) == true
								|| text.toUpperCase().contains(listwords[6].toUpperCase()) == true) {
							login.Log4j.info(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
									+ listwords[3] + " OR " + listwords[4] + " OR " + listwords[5] + " OR "
									+ listwords[6] + " exists in " + text);
							KeywordMatch = true;

						} else if (KeywordMatch == false) {
							WebElement ele = login.driver.findElement(
									By.xpath("//li[" + j + "]//div[@class='series-list-item-data--name']"));
							Thread.sleep(1000);
							ele.click();

							if (login.driver.findElement(By.xpath("//div[contains(text(),'Datasets')]"))
									.isDisplayed()) {
								Thread.sleep(1000);
								login.driver.findElement(By.xpath("//div[contains(text(),'Datasets')]")).click();
								List<WebElement> datasets = login.driver
										.findElements(By.xpath("//div[@class='ps-container ps-theme-default']"));
								for (WebElement list : datasets) {
									Filters.showdata = list.getText();
									login.Log4j.info(listwords[5]);
									if (Filters.showdata.toUpperCase().contains(listwords[0].toUpperCase()) == true
											|| Filters.showdata.toUpperCase()
													.contains(listwords[1].toUpperCase()) == true
											|| Filters.showdata.toUpperCase()
													.contains(listwords[2].toUpperCase()) == true
											|| Filters.showdata.toUpperCase()
													.contains(listwords[3].toUpperCase()) == true
											|| Filters.showdata.toUpperCase()
													.contains(listwords[4].toUpperCase()) == true
											|| Filters.showdata.toUpperCase()
													.contains(listwords[5].toUpperCase()) == true
											|| Filters.showdata.toUpperCase()
													.contains(listwords[6].toUpperCase()) == true) {
										login.Log4j.info(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2]
												+ " OR " + listwords[3] + " OR " + listwords[4] + " OR " + listwords[5]
												+ " OR " + listwords[6] + " exists in the " + "\n" + Filters.showdata);
										Thread.sleep(1000);
										login.driver.findElement(By.xpath("//div[@title='Close']")).click();

									} else {
										Thread.sleep(1000);
										login.driver.findElement(By.xpath("//div[@title='Close']")).click();
										Assert.fail(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2]
												+ " OR " + listwords[3] + " OR " + listwords[4] + " OR " + listwords[5]
												+ " OR " + listwords[6] + " keyword doesn't exists in the " + text
												+ " AND " + "\n" + Filters.showdata);
									}
								}
							}

						}
						break;
					case 8:
						if (text.toUpperCase().contains(listwords[0].toUpperCase()) == true
								|| text.toUpperCase().contains(listwords[1].toUpperCase()) == true
								|| text.toUpperCase().contains(listwords[2].toUpperCase()) == true
								|| text.toUpperCase().contains(listwords[3].toUpperCase()) == true
								|| text.toUpperCase().contains(listwords[4].toUpperCase()) == true
								|| text.toUpperCase().contains(listwords[5].toUpperCase()) == true
								|| text.toUpperCase().contains(listwords[6].toUpperCase()) == true
								|| text.toUpperCase().contains(listwords[7].toUpperCase()) == true) {
							login.Log4j.info(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
									+ listwords[3] + " OR " + listwords[4] + " OR " + listwords[5] + " OR "
									+ listwords[6] + " OR " + listwords[7] + " exists in " + text);
							KeywordMatch = true;

						} else if (KeywordMatch == false) {
							WebElement ele = login.driver.findElement(
									By.xpath("//li[" + j + "]//div[@class='series-list-item-data--name']"));
							Thread.sleep(1000);
							ele.click();

							if (login.driver.findElement(By.xpath("//div[contains(text(),'Datasets')]"))
									.isDisplayed()) {
								Thread.sleep(1000);
								login.driver.findElement(By.xpath("//div[contains(text(),'Datasets')]")).click();
								List<WebElement> datasets = login.driver
										.findElements(By.xpath("//div[@class='ps-container ps-theme-default']"));
								for (WebElement list : datasets) {
									Filters.showdata = list.getText();
									if (Filters.showdata.toUpperCase().contains(listwords[0].toUpperCase()) == true
											|| Filters.showdata.toUpperCase()
													.contains(listwords[1].toUpperCase()) == true
											|| Filters.showdata.toUpperCase()
													.contains(listwords[2].toUpperCase()) == true
											|| Filters.showdata.toUpperCase()
													.contains(listwords[3].toUpperCase()) == true
											|| Filters.showdata.toUpperCase()
													.contains(listwords[4].toUpperCase()) == true
											|| Filters.showdata.toUpperCase()
													.contains(listwords[5].toUpperCase()) == true
											|| Filters.showdata.toUpperCase()
													.contains(listwords[6].toUpperCase()) == true
											|| Filters.showdata.toUpperCase()
													.contains(listwords[7].toUpperCase()) == true) {
										login.Log4j.info(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2]
												+ " OR " + listwords[3] + " OR " + listwords[4] + " OR " + listwords[5]
												+ " OR " + listwords[6] + " OR " + listwords[7] + " exists in the "
												+ "\n" + Filters.showdata);
										Thread.sleep(1000);
										login.driver.findElement(By.xpath("//div[@title='Close']")).click();

									} else {
										Thread.sleep(1000);
										login.driver.findElement(By.xpath("//div[@title='Close']")).click();
										Assert.fail(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2]
												+ " OR " + listwords[3] + " OR " + listwords[4] + " OR " + listwords[5]
												+ " OR " + listwords[6] + " OR " + listwords[7]
												+ " keyword doesn't exists in the " + text + " AND " + "\n"
												+ Filters.showdata);
									}
								}
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

	public boolean search_validation(String searchText, String Keyword) throws Throwable {

		if (searchText.toUpperCase().contains(Keyword.toUpperCase()) == true) {
			return true;
		} else {
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
