package CDMNext.StepDefinations;

import org.testng.Assert;

import org.testng.AssertJUnit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Filters {

	public static String var;
	public static String filter;
	String[] fltrOptions = null;
	String[] sid = null;
	public static String searchData;
	public static String advancedfltr;

	@Given("^User enters \"([^\"]*)\"$")
	public void user_enters(String arg1) throws Throwable {
		searchData = arg1;
		Thread.sleep(2000);
		login.Log4j.info("searching with " + searchData);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).clear();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys(searchData);
	}

	@And("^User clicks on Filters$")
	public void user_clicks_on_Filters() throws Throwable {
		Thread.sleep(5000);
		List<WebElement> reset = login.driver.findElements(By.xpath("//span[contains(text(),'Reset')]"));
		// List<WebElement> top =
		// login.driver.findElements(By.xpath("//div[contains(text(),'Top')]"));
		if (login.driver.findElement(By.xpath("//div[contains(text(),'Top')]")).isDisplayed()) {
			login.driver.findElement(By.xpath("//div[contains(text(),'Top')]")).click();
			login.Log4j.info("Clicking on Top button");
		}
		if (reset.size() > 0) {
			login.driver.findElement(By.xpath("//span[contains(text(),'Reset')]")).click();
			login.Log4j.info("Clicking on Reset button");

		} else {
			login.driver.findElement(By.xpath("//div//span[@class='search-input--toggle-filters-wrapper']")).click();
			login.Log4j.info("Clicking on filter...");
		}
		/*
		 * try { login.driver.findElement(By.xpath(
		 * "//span[@class='search-filters-panel--reset-button']")).isDisplayed();
		 * 
		 * login.driver.findElement(By.xpath(
		 * "//span[@class='search-filters-panel--reset-button']")).click();
		 * System.out.println("Reset object is not null");
		 * 
		 * } catch (NoSuchElementException | ElementNotVisibleException e) { try {
		 * login.driver .findElement(By.
		 * xpath("//i[@class='search-input--toggle-filters-icon search-input--up-icon']"
		 * )) .isDisplayed(); System.out.println("Upicon object is not null");
		 * 
		 * } catch (NoSuchElementException e1) { login.driver.findElement(By.xpath(
		 * "//span[@class='search-input--toggle-filters-wrapper']")).click(); //
		 * login.driver.findElement(By.xpath(
		 * "//div[@class='search-input--toggle-filters']")).click();
		 * System.out.println("Reset object is null and Upicon object is null"); } }
		 */
	}

	@And("^User selects \"([^\"]*)\" as \"([^\"]*)\"$")
	public void user_selects_as(String arg1, String arg2) throws Throwable {
		var = arg2;
		filter = arg1;
		Thread.sleep(2000);
		fltrOptions = var.split(";");

		if (filter.equals("Source")) {
			login.Log4j.info("clicking on " + filter);
			login.driver.findElement(By.xpath("//span[contains(text(),'" + filter + "')]")).click();
			for (String list : fltrOptions) {
				Thread.sleep(1000);
				login.Log4j.info("clicking on " + list);
				login.driver.findElement(By.xpath("//tr[@title='" + list + "']")).click();
			}
		}
		if (filter.equals("Date")) {
			login.Log4j.info("clicking on " + filter);
			login.driver.findElement(By.xpath("//span[@title='Filter series by observation date']")).click();
			for (String list : fltrOptions) {
				Thread.sleep(1000);
				login.driver.findElement(By.xpath("//label[@title='" + list + "']")).click();
			}
		}
		if (filter.equals("Frequency")) {
			login.Log4j.info("clicking on " + filter);
			login.driver.findElement(By.xpath("//span[@title='Filter series by frequency']")).click();
			for (String list : fltrOptions) {
				Thread.sleep(1000);
				login.driver.findElement(By.xpath("//tr[@title='" + list + "']")).click();
			}
		}
		if (filter.equals("Status")) {
			login.driver.findElement(By.xpath("//span[@title='Filter series by status']")).click();
			for (String list : fltrOptions) {
				Thread.sleep(1000);
				login.driver.findElement(By.xpath("//tr[@title='" + list + "']")).click();
			}

		}
	}

	@And("^User has clicked on \"([^\"]*)\"$")
	public void user_has_clicked_on(String arg1) throws Throwable {
		Thread.sleep(1000);
		login.Log4j.info("Clicking on " + arg1);
		login.driver.findElement(By.xpath("//div[contains(text(),'" + arg1 + "')]")).click();
	}

	@And("^User selects \"([^\"]*)\"$")
	public void user_selects(String arg1) throws Throwable {
		advancedfltr = arg1;
		login.driver.findElement(By.xpath("//div[@class='search-filters-panel--settings-toggler-icon']")).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();

	}

	@When("^User selected \"([^\"]*)\" as \"([^\"]*)\"$")
	public void user_selected_as(String arg1, String arg2) throws Throwable {

		// long timeoutInSeconds=30;
		Thread.sleep(5000);
		// WebDriverWait wait = new WebDriverWait(login.driver, timeoutInSeconds);
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'"
		// + arg1 + "')]")));
		// WebElement element =
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Ab_banco_M1T1_switch")));

		List<WebElement> alldb = login.driver.findElements(By.xpath("//span[contains(text(),'" + arg1 + "')]"));
		if (alldb.size() > 0) {
			login.Log4j.info("Clicking on " + arg1);
			login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();
		} else {
			login.driver.findElement(By.xpath("//span[@class='icon--red-cross database-selector--clear-icon']"))
					.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();
		}
		String[] database = arg2.split(",");
		for (String dblist : database) {
			Thread.sleep(1000);
			login.Log4j.info("Selecting " + dblist);
			List<WebElement> checkbox = login.driver.findElements(By.xpath("//div//span[contains(text(),'" + dblist
					+ "')]/preceding-sibling::label/span[@class='input-control--indicator']"));
			if (checkbox.size() > 0) {
				login.driver.findElement(By.xpath("//div//span[contains(text(),'" + dblist
						+ "')]/preceding-sibling::label/span[@class='input-control--indicator']")).click();
			} else {
				login.driver.findElement(By.xpath("//span[contains(text(),'" + dblist + "')]")).click();
			}

		}

	}

	@Then("^User verify Filter search results$")
	public void user_verify_Filter_search_results() throws Throwable {
		WebElement element;
		WebElement checkbox;
		String text;
		login.Log4j.info("Clicking on  Series tab ");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		Thread.sleep(5000);
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
					Thread.sleep(1500);
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
					String[] lines = text.split("\n");
					System.out.println("filter is " + filter);
					String seriesId = lines[11];
					String seriesName = lines[1];
					if (filter == null) {
						Thread.sleep(3000);
						sid = searchData.split(";");
						login.Log4j.info("search data is " + searchData);
						login.Log4j.info("series name is " + seriesName);
						login.Log4j.info("sid length is " + sid.length);
						switch (sid.length) {
						case 1:
							if (seriesId.contains(sid[0]) == true) {
								login.Log4j.info(sid[0] + " is exists in the" + "\n" + seriesId);

							} else if (seriesName.contains(sid[0]) == true) {
								login.Log4j.info(sid[0] + " is exists in the  : " + seriesName);

							} else if (text.toUpperCase().contains(sid[0].toUpperCase()) == true) {
								login.Log4j.info(sid[0] + " is exists in the" + "\n" + text);
							} else {
								Assert.fail(sid[0] + " doesn't exists ");
							}
							break;
						case 2:
							if (seriesId.contains(sid[0]) == true || seriesId.contains(sid[1]) == true) {
								login.Log4j.info(sid[0] + " OR " + sid[1] + " is exists in the" + "\n" + seriesId);
							} else if (text.toUpperCase().contains(sid[0].toUpperCase()) == true
									|| text.toUpperCase().contains(sid[1].toUpperCase()) == true) {
								login.Log4j.info(sid[0] + " OR " + sid[1] + " is exists in the" + "\n" + text);
							} else {
								Assert.fail(sid[0] + " OR " + sid[1] + " doesn't exists");
							}
							break;

						case 3:
							if (seriesId.contains(sid[0]) == true || seriesId.contains(sid[1]) == true
									|| seriesId.contains(sid[2]) == true) {
								login.Log4j.info(sid[0] + " OR " + sid[1] + " OR " + sid[2] + " is exists in the" + "\n"
										+ seriesId);

							} else {
								Assert.fail(sid[0] + " OR " + sid[1] + " OR " + sid[2] + " doesn't exists in the" + "\n"
										+ seriesId);
							}
							break;
						case 4:
							if (seriesId.contains(sid[0]) == true || seriesId.contains(sid[1]) == true
									|| seriesId.contains(sid[2]) == true || seriesId.contains(sid[3]) == true) {
								login.Log4j.info(sid[0] + " OR " + sid[1] + " OR " + sid[2] + " OR " + sid[3]
										+ " exists in the" + "\n" + seriesId);

							} else {

								Assert.fail(sid[0] + " OR " + sid[1] + " OR " + sid[2] + " OR " + sid[3]
										+ " doesnot exists in the" + "\n" + seriesId);
							}
							break;
						case 5:
							if (seriesId.contains(sid[0]) == true || seriesId.contains(sid[1]) == true
									|| seriesId.contains(sid[2]) == true || seriesId.contains(sid[3]) == true
									|| seriesId.contains(sid[4]) == true) {
								login.Log4j.info(sid[0] + " OR " + sid[1] + " OR " + sid[2] + " OR " + sid[3] + " OR "
										+ sid[4] + " exists in the" + "\n" + seriesId);

							} else {

								Assert.fail(sid[0] + " OR " + sid[1] + " OR " + sid[2] + " OR " + sid[3] + " OR "
										+ sid[4] + " doesnot exists in the" + "\n" + seriesId);
							}
							break;
						default:

							login.Log4j.error(
									searchData + " has more than 5 series Id's which is not handled.  Please handle!");
							Assert.fail(
									searchData + " has more than 5 series Id's which is not handled.  Please handle!");

						}

					} else {
						switch (filter) {
						case "Source":
							System.out.println(fltrOptions.length);

							String source = lines[10];
							System.out.println(source);
							if ((fltrOptions.length == 1)
									&& (source.toUpperCase().contains(fltrOptions[0].toUpperCase()) == true)) {
								login.Log4j.info(fltrOptions[0] + " is exists in the" + "\n" + source);

							} else if ((fltrOptions.length == 2) && (source.contains(fltrOptions[0]) == true
									|| source.contains(fltrOptions[1]) == true)) {
								login.Log4j.info(
										fltrOptions[0] + " OR " + fltrOptions[1] + " is exists in the" + "\n" + source);
							} else {
								if (fltrOptions.length == 1) {
									login.Log4j.error(fltrOptions[0] + " doesn't exist in " + source);
									Assert.fail(fltrOptions[0] + " doesn't exist in " + source);
								} else {
									login.Log4j.error(
											fltrOptions[0] + " OR " + fltrOptions[1] + " doesn't exist in " + source);
									Assert.fail(
											fltrOptions[0] + " OR " + fltrOptions[1] + " doesn't exist in " + source);
								}
							}
							break;
						case "Date":
							SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
							Date date = new Date();
							if (fltrOptions[0].equalsIgnoreCase("First observation before")) {
								fltrOptions[0] = "First date";
							}
							String[] frstDate = lines[4].split(": ");
							String first_obs_before = sdf.format(date);
							if (sdf.parse(frstDate[1]).before(sdf.parse(first_obs_before)) == true) {
								login.Log4j.info(frstDate[1] + " is less than " + first_obs_before + "? "
										+ sdf.parse(frstDate[1]).before(sdf.parse(first_obs_before)));
							} else {
								Assert.fail(frstDate[1] + " is not less than " + first_obs_before);
							}
							break;
						case "Frequency":
							String frequency = lines[3];
							if (frequency.contains(fltrOptions[0]) == true) {
								login.Log4j.info(fltrOptions[0] + " is exists in the" + "\n" + frequency);
							} else {
								login.Log4j.error("vxvchj");
								Assert.fail(fltrOptions[0] + " doesn't exist in " + frequency);

							}
							break;

						case "Status":
							System.out.println(advancedfltr);
							String fontColor = element.getCssValue("backgroud-color");
							System.out.println("Font Color -> " + fontColor);
							/*
							 * if (advancedfltr.equals("Subscribed only")) {
							 * if(fontColor.contains(##FFFFFF)) {
							 * 
							 * }
							 * 
							 * }
							 */
							if (advancedfltr.equals("Name only")
									&& seriesName.toUpperCase().contains(sid[0].toUpperCase()) == true) {
								login.Log4j.info(sid[0] + " is exists in the  : " + seriesName);
							}
							if (fltrOptions[0].equals("Active")) {
								Thread.sleep(1000);
								login.driver.findElement(By.xpath("//div[@title='Show related data']")).click();
								Thread.sleep(1000);
								List<WebElement> active = login.driver
										.findElements(By.xpath("//div[contains(text(),'Active')]"));
								if (active.size() > 0) {
									for (int l = 0; l < active.size(); l++) {

									}
									login.Log4j.info(fltrOptions[0] + " series exists");

								} else {
									login.Log4j.info(fltrOptions[0] + " doesn't exists");
								}

							} else if (seriesId.contains(sid[0]) == true) {
								login.Log4j.info(sid[0] + " is exists in the" + "\n" + seriesId);
							} else {
								Assert.fail(sid[0] + " doesn't exist in " + seriesId);

							}
							break;

						default:

							login.Log4j.info("Nothing to be matched with " + filter);
						}
					}
				}
			} else {
				Assert.fail("Sorry,No results were found ");
			}

		} catch (Exception e) {
			login.Log4j.error("m in catch");
			Assert.fail(e.getMessage());
		}
	}

}
