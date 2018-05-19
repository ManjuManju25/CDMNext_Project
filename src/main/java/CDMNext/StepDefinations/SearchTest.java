
package CDMNext.StepDefinations;

import java.io.File;

import java.io.FileReader;
import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class SearchTest {
	public static String currentKeyword = "";
	private static Boolean logged = false;

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

		Thread.sleep(2000);
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
			listwords = Content.split(",");
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
			System.out.println(listwords[0]);

		}

		System.out.println("Array size is " + listwords.length);
		// create instance of JavaScriptExecutor
		JavascriptExecutor jse = (JavascriptExecutor) login.driver;
		// create object of Actions class
		Actions mouseOver = new Actions(login.driver);

		WebElement ul_element = null;
		try {
			ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
			Assert.assertNotNull(ul_element);
			List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
			// login.Log4j.info("List size is :" + li_All.size());
			System.out.println("List size is :" + li_All.size());
			if (li_All.size() > 0) {
				for (int i = 0; i < li_All.size(); i++) {
					System.out.println(i);
					System.out.println(li_All.size());
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
					System.out.println("Title information is \n" + text);

					switch (listwords.length) {
					case 1:
						if (search_validation(text, listwords[0]) == true) {
							// login.Log4j.info(listwords[0] + " is exists in the \n" + text);
							System.out.println(listwords[0] + " is exists in the \n" + text);
							System.out.println("\n");
						} else {
							login.Log4j.error(listwords[0] + "  doesnot exists in the  \n" + text);
							Assert.fail(listwords[0] + "  doesnot exists in the  " + text);
						}
						break;
					case 2:

						if (search_validation(text, listwords[0]) == true
								|| search_validation(text, listwords[1]) == true) {
							// login.Log4j.info(listwords[0] + " OR " + listwords[1] + " exists in the \n" +
							// text);
							System.out.println(listwords[0] + " OR " + listwords[1] + " exists in the \n" + text);
							System.out.println("\n");
						} else {
							login.Log4j.error(listwords[0] + " OR " + listwords[1] + " doesnot exists in the " + text);
							Assert.fail(listwords[0] + " OR " + listwords[1] + " doesnot exists in the " + text);
						}

						break;
					case 3:
						if (search_validation(text, listwords[0]) == true
								|| search_validation(text, listwords[1]) == true
								|| search_validation(text, listwords[2]) == true) {
							// login.Log4j.info(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2]
							// + " exists in the \n" + text);
							System.out.println(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2]
									+ " exists in the \n" + text);
							System.out.println("\n");
						} else {
							login.Log4j.error(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2]
									+ " doesnot exists in the \n" + text);
							Assert.fail(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2]
									+ " doesnot exists in the " + text);
						}
						break;
					case 4:
						if (search_validation(text, listwords[0]) == true
								|| search_validation(text, listwords[1]) == true
								|| search_validation(text, listwords[2]) == true
								|| search_validation(text, listwords[3]) == true) {
							login.Log4j.info(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
									+ listwords[3] + " exists in the \n" + text);
							System.out.println("\n");
						} else {
							login.Log4j.error(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
									+ listwords[3] + " doesnot exists in the \n" + text);
							Assert.fail(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
									+ listwords[3] + " doesnot exists in the " + text);
						}
						break;
					case 5:
						if (search_validation(text, listwords[0]) == true
								|| search_validation(text, listwords[1]) == true
								|| search_validation(text, listwords[2]) == true
								|| search_validation(text, listwords[3]) == true
								|| search_validation(text, listwords[4]) == true) {
							login.Log4j.info(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
									+ listwords[3] + " OR " + listwords[4] + " exists in the \n" + text);
							System.out.println("\n");
						} else {
							login.Log4j.error(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
									+ listwords[3] + " OR " + listwords[4] + " doesnot exists in the \n" + text);
							Assert.fail(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
									+ listwords[3] + " OR " + listwords[4] + " doesnot exists in the " + text);
						}
						break;
					case 6:
						if (search_validation(text, listwords[0]) == true
								|| search_validation(text, listwords[1]) == true
								|| search_validation(text, listwords[2]) == true
								|| search_validation(text, listwords[3]) == true
								|| search_validation(text, listwords[4]) == true
								|| search_validation(text, listwords[5]) == true) {
							login.Log4j.info(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
									+ listwords[3] + " OR " + listwords[4] + " OR " + listwords[5] + " exists in the \n"
									+ text);
							System.out.println("\n");
						} else {
							login.Log4j.error(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
									+ listwords[3] + " OR " + listwords[4] + " OR " + listwords[5]
									+ " doesnot exists in the \n" + text);
							Assert.fail(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
									+ listwords[3] + " OR " + listwords[4] + " OR " + listwords[5]
									+ "  doesnot exists in the " + text);
						}
						break;
					case 7:
						if (search_validation(text, listwords[0]) == true
								|| search_validation(text, listwords[1]) == true
								|| search_validation(text, listwords[2]) == true
								|| search_validation(text, listwords[3]) == true
								|| search_validation(text, listwords[4]) == true
								|| search_validation(text, listwords[5]) == true
								|| search_validation(text, listwords[6]) == true) {
							login.Log4j.info(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
									+ listwords[3] + " OR " + listwords[4] + " OR " + listwords[5] + " OR "
									+ listwords[6] + " exists in the \n" + text);
							System.out.println("\n");
						} else {
							login.Log4j.error(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
									+ listwords[3] + " OR " + listwords[4] + " OR " + listwords[5] + " OR "
									+ listwords[6] + " doesnot exists in the \n" + text);
							Assert.fail(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
									+ listwords[3] + " OR " + listwords[4] + " OR " + listwords[5] + " OR "
									+ listwords[6] + " doesnot exists in the " + text);
						}
						break;
					case 8:
						if (search_validation(text, listwords[0]) == true
								|| search_validation(text, listwords[1]) == true
								|| search_validation(text, listwords[2]) == true
								|| search_validation(text, listwords[3]) == true
								|| search_validation(text, listwords[4]) == true
								|| search_validation(text, listwords[5]) == true
								|| search_validation(text, listwords[6]) == true
								|| search_validation(text, listwords[7]) == true) {
							login.Log4j.info(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
									+ listwords[3] + " OR " + listwords[4] + " OR " + listwords[5] + " OR "
									+ listwords[6] + listwords[7] + " exists in the \n" + text);
							System.out.println("\n");
						} else {
							login.Log4j.error(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
									+ listwords[3] + " OR " + listwords[4] + " OR " + listwords[5] + " OR "
									+ listwords[6] + " doesnot exists in the \n" + text);
							Assert.fail(listwords[0] + " OR " + listwords[1] + " OR " + listwords[2] + " OR "
									+ listwords[3] + " OR " + listwords[4] + " OR " + listwords[5] + " OR "
									+ listwords[6] + listwords[7] + " doesnot exists in the " + text);
						}
						break;

					default:

						login.Log4j.error(
								currentKeyword + " has more than 8 synonyms which is not handled.  Please handle!");
						Assert.fail(currentKeyword + " has more than 8 synonyms which is not handled.  Please handle!");

					}
				}

			} else {
				Assert.fail("Sorry,No results were found ");
			}
			/*
			 * } catch (NoSuchElementException e) {
			 * 
			 * login.Log4j.error("Sorry,No results were found");
			 * Assert.fail("Sorry,No results were found " + e.getMessage());
			 */

		} catch (StaleElementReferenceException | ElementNotVisibleException e) {
			File screenshotFile = ((TakesScreenshot)login.driver).getScreenshotAs(OutputType.FILE);
		    FileUtils.copyFile(screenshotFile, new File("C:/Users/mnadiya/Screenshots/error.png"));
		 	Assert.fail("The WebElement is not visisble! " + e.getMessage());
		}
	}

	public boolean search_validation(String searchText, String Keyword) throws Throwable {

		if (searchText.toUpperCase().contains(Keyword.toUpperCase()) == true) {
			return true;
		} else {
			return false;
		}

		// String[] keywords = null;
		// keywords = Keyword.split(" ");
		//
		// switch (keywords.length) {
		// case 1:
		// if (searchText.toUpperCase().contains(keywords[0].toUpperCase()) == true) {
		// return true;
		// } else {
		// return false;
		// }
		//
		// case 2:
		// if (searchText.toUpperCase().contains(keywords[0].toUpperCase()) == true
		// && searchText.toUpperCase().contains(keywords[1].toUpperCase()) == true) {
		// return true;
		// } else {
		// return false;
		// }
		//
		// case 3:
		// if (searchText.toUpperCase().contains(keywords[0].toUpperCase()) == true
		// && searchText.toUpperCase().contains(keywords[1].toUpperCase()) == true
		// && searchText.toUpperCase().contains(keywords[2].toUpperCase()) == true) {
		// return true;
		// } else {
		// return false;
		// }
		//
		// case 4:
		// if (searchText.toUpperCase().contains(keywords[0].toUpperCase()) == true
		// && searchText.toUpperCase().contains(keywords[1].toUpperCase()) == true
		// && searchText.toUpperCase().contains(keywords[2].toUpperCase()) == true
		// && searchText.toUpperCase().contains(keywords[3].toUpperCase()) == true) {
		// return true;
		// } else {
		// return false;
		// }
		// case 5:
		// if (searchText.toUpperCase().contains(keywords[0].toUpperCase()) == true
		// && searchText.toUpperCase().contains(keywords[1].toUpperCase()) == true
		// && searchText.toUpperCase().contains(keywords[2].toUpperCase()) == true
		// && searchText.toUpperCase().contains(keywords[3].toUpperCase()) == true
		// && searchText.toUpperCase().contains(keywords[4].toUpperCase()) == true) {
		// return true;
		// } else {
		// return false;
		// }
		// case 6:
		// if (searchText.toUpperCase().contains(keywords[0].toUpperCase()) == true
		// && searchText.toUpperCase().contains(keywords[1].toUpperCase()) == true
		// && searchText.toUpperCase().contains(keywords[2].toUpperCase()) == true
		// && searchText.toUpperCase().contains(keywords[3].toUpperCase()) == true
		// && searchText.toUpperCase().contains(keywords[4].toUpperCase()) == true
		// && searchText.toUpperCase().contains(keywords[5].toUpperCase()) == true) {
		// return true;
		// } else {
		// return false;
		// }
		//
		// default:
		// return false;
		//
		// }
		//
	}
	 
}
