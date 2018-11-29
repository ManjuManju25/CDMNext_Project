package CDMNext.StepDefinations;

import org.testng.Assert;

import org.testng.AssertJUnit;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Filters {

	public static String var;
	public String fltrStatus;
	String[] unitarr = null;
	List<String> filters = new ArrayList<>();
	String[] sourcearr = null;
	String[] datearr = null;
	String[] frequencyarr = null;
	String[] sid = null;
	public static String searchData;
	public String advancedfltr;
	public String topic;
	public int k;
	public int j;
	public static String showdata;
	static Boolean status = true;
	public String seriesId;
	public String seriesName;
	public String unit;
	public String frequency;
	String[] source = null;

	@Given("^User enters \"([^\"]*)\"$")
	public void user_enters(String arg1) throws Throwable {
		searchData = arg1;
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).clear();
		Thread.sleep(3000);
		login.Log4j.info("searching with " + searchData);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys(searchData);
		List<WebElement> reset = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Reset")));
		List<WebElement> clearIcon = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("Alldb_clearIcon")));
       
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TopButton"))).isDisplayed()) {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TopButton"))).click();
			login.Log4j.info("Clicking on Top button");
		}
		if(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unselect"))).isDisplayed()) {
	        	login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unselect"))).click();	
	     }
		if (clearIcon.size() > 0) {
			if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Alldb_clearIcon")))
					.isDisplayed()) {
              Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Alldb_clearIcon")))
						.click();
			}
		}
		if (reset.size() > 0) {
			if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).isDisplayed()) {
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
				login.Log4j.info("Clicking on Reset button");
			}
		} else {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Filters"))).click();
			login.Log4j.info("Clicking on filter...");
		}
//		login.Log4j.info("searching with " + searchData);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).clear();
//		Thread.sleep(3000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys(searchData);

	}

	@And("^User selects \"([^\"]*)\" as \"([^\"]*)\"$")
	public void user_selects_as(String arg1, String arg2) throws Throwable {
		k = 0;
		filters.add(arg1);
		login.Log4j.info(filters);
		Thread.sleep(2000);
		var = arg2;
		if (arg1.equals("Source")) {
			login.Log4j.info("clicking on " + arg1);
			login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();
			sourcearr = var.split(";");
			for (String list : sourcearr) {
				Thread.sleep(3000);
				login.Log4j.info("clicking on " + list);
				login.driver.findElement(By.xpath("//tr[@title='" + list + "']")).click();
			}
		}
		if (arg1.equals("Date")) {
			login.Log4j.info("clicking on " + arg1);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("DateFilter"))).click();
			datearr = var.split(";");
			for (String list : datearr) {
				Thread.sleep(2000);
				login.Log4j.info("clicking on " + list);
				login.driver.findElement(By.xpath("//label[@title='" + list + "']")).click();
			}
		}
		if (arg1.equals("Frequency")) {
			login.Log4j.info("clicking on " + arg1);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("FrequencyFilter"))).click();
			frequencyarr = var.split(";");
			for (String list : frequencyarr) {
				Thread.sleep(3000);
				login.Log4j.info("clicking on " + list);
				login.driver.findElement(By.xpath("//tr[@title='" + list + "']")).click();
			}
		}
		if (arg1.equals("Status")) {
			fltrStatus = arg2;
			login.Log4j.info("clicking on " + arg1);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("status_filter"))).click();
			login.Log4j.info("clicking on " + fltrStatus);
			Thread.sleep(3000);
			login.driver.findElement(By.xpath("//tr[@title='" + fltrStatus + "']")).click();
		}
		if (arg1.equals("Unit")) {
			login.Log4j.info("clicking on " + arg1);
			login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();
			if (arg2.equals("MUR")) {
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_option"))).click();
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unit_filter"))).clear();
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unit_filter"))).sendKeys(arg2);

			}

			unitarr = var.split(";");
			for (String list : unitarr) {
				Thread.sleep(3000);
				login.Log4j.info("clicking on " + list);
				login.driver.findElement(By.xpath("//tr[@title='" + list + "']")).click();
			}
		}
		if (arg1.equals("Region")) {
			login.Log4j.info("clicking on " + arg1);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("region_filter"))).click();
			Thread.sleep(4000);
			login.driver.findElement(By.xpath("//div[contains(text(),'By group')]")).click();

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
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("More_filter"))).click();
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//tr[@title='" + arg1 + "']")).click();

	}

	@And("^User selected \"([^\"]*)\" as \"([^\"]*)\"$")
	public void user_selected_as(String arg1, String arg2) throws Throwable {
		Thread.sleep(3000);
		login.Log4j.info("Clicking on " + arg1);
		login.driver.findElement(By.xpath("//span[contains(text(),'" + arg1 + "')]")).click();
		String[] database = arg2.split(",");
		for (String dblist : database) {
			Thread.sleep(2000);
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

	@Then("^User verify the search results$")
	public void user_verify_the_search_results() throws Throwable {
		WebElement element;
		WebElement checkbox;
		String text;
		//String str=null;

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
					j = i + 1;
					checkbox = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
					mouseOver.moveToElement(checkbox).click().build().perform();
					element = login.driver.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--content']"));
					mouseOver.moveToElement(element).build().perform();
					// Until the element is not visible keep scrolling
					jse.executeScript("arguments[0].scrollIntoView(true);", element);
					text = element.getAttribute("title");
					// login.Log4j.info("Title information is \n" + text);
					String[] lines = text.split("\n");
					// login.Log4j.info("filter is " + filters);
					for (String Tooltip : lines) {
						//String str=null;
						if (Tooltip.contains("Series id")) {
							seriesId = Tooltip;
						} else if (Tooltip.contains("Name")) {
							seriesName = Tooltip;
						} else if (Tooltip.contains("Unit")) {
							unit = Tooltip;
						} else if (Tooltip.contains("Frequency")) {
							frequency = Tooltip;
						} 
					}

					if (filters.isEmpty()) {
						Thread.sleep(2000);
						sid = searchData.split(";");

						switch (sid.length) {
						case 1:
							login.Log4j.info(advancedfltr);
							if (advancedfltr != null) {
								if (advancedfltr.equals("Subscribed series only")
										&& seriesId.contains(sid[0]) == true) {
									if (!checkbox.isSelected()) {
										checkbox.click();
										login.Log4j.info("Element is clickable");
									} else {
										Assert.fail("Element is not clickable");
									}
								} else if (advancedfltr.equals("Subscribed series only")) {
									if (!checkbox.isSelected()) {
										checkbox.click();
										login.Log4j.info("Element is clickable");
									} else {
										Assert.fail("Element is not clickable");
									}
								} else if (advancedfltr.equals("New only")) {

									if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Newonly")))
											.isDisplayed()) {
										login.Log4j.info(advancedfltr + " series are exists");
									} else {
										Assert.fail(advancedfltr + " series doesnot exists");
									}
								} else {

									if (advancedfltr.equals("Name only")
											&& seriesName.toUpperCase().contains(sid[0].toUpperCase()) == true) {
										login.Log4j.info(sid[0] + " is exists in  : " + seriesName);
									} else {
										Assert.fail(sid[0] + " doesn't exists in  : " + seriesName);

									}
								}
							} else if (seriesId.contains(sid[0]) == true) {
								login.Log4j.info(sid[0] + " is exists in " + "\n" + seriesId);
							} else {
								if (text.toUpperCase().contains(sid[0].toUpperCase()) == true) {
									login.Log4j.info(sid[0] + " is exists in the" + "\n" + text);
								} else {
									showRelatedData(sid[0], j);
									if (status == false) {
										Assert.fail(sid[0] + " keyword doesn't exists " + showdata);
									}
								}
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

							} else if (text.toUpperCase().contains(sid[0].toUpperCase()) == true
									|| text.toUpperCase().contains(sid[1].toUpperCase()) == true
									|| text.toUpperCase().contains(sid[2].toUpperCase()) == true) {
								login.Log4j.info(
										sid[0] + " OR " + sid[1] + " OR " + sid[2] + " is exists in the" + "\n" + text);
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
							} else if (text.toUpperCase().contains(sid[0].toUpperCase()) == true
									|| text.toUpperCase().contains(sid[1].toUpperCase()) == true
									|| text.toUpperCase().contains(sid[2].toUpperCase()) == true
									|| text.toUpperCase().contains(sid[3].toUpperCase()) == true) {
								login.Log4j.info(sid[0] + " OR " + sid[1] + " OR " + sid[2] + " OR " + sid[3]
										+ " is exists in the" + "\n" + text);
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
							} else if (text.toUpperCase().contains(sid[0].toUpperCase()) == true
									|| text.toUpperCase().contains(sid[1].toUpperCase()) == true
									|| text.toUpperCase().contains(sid[2].toUpperCase()) == true
									|| text.toUpperCase().contains(sid[3].toUpperCase()) == true
									|| text.toUpperCase().contains(sid[4].toUpperCase()) == true) {
								login.Log4j.info(sid[0] + " OR " + sid[1] + " OR " + sid[2] + " OR " + sid[3] + " OR "
										+ sid[4] + " is exists in the" + "\n" + text);
							} else {
								Assert.fail(sid[0] + " OR " + sid[1] + " OR " + sid[2] + " OR " + sid[3] + " OR "
										+ sid[4] + " doesnot exists in the" + "\n" + seriesId);
							}
							break;
						case 6:
							if (seriesId.contains(sid[0]) == true || seriesId.contains(sid[1]) == true
									|| seriesId.contains(sid[2]) == true || seriesId.contains(sid[3]) == true
									|| seriesId.contains(sid[4]) == true || seriesId.contains(sid[5]) == true) {
								login.Log4j.info(sid[0] + " OR " + sid[1] + " OR " + sid[2] + " OR " + sid[3] + " OR "
										+ sid[4] + " exists in the" + "\n" + seriesId);
							} else if (text.toUpperCase().contains(sid[0].toUpperCase()) == true
									|| text.toUpperCase().contains(sid[1].toUpperCase()) == true
									|| text.toUpperCase().contains(sid[2].toUpperCase()) == true
									|| text.toUpperCase().contains(sid[3].toUpperCase()) == true
									|| text.toUpperCase().contains(sid[4].toUpperCase()) == true
									|| text.toUpperCase().contains(sid[5].toUpperCase()) == true) {
								login.Log4j.info(sid[0] + " OR " + sid[1] + " OR " + sid[2] + " OR " + sid[3] + " OR "
										+ sid[4] + " OR " + sid[5] + " is exists in the" + "\n" + text);
							} else {
								Assert.fail(sid[0] + " OR " + sid[1] + " OR " + sid[2] + " OR " + sid[3] + " OR "
										+ sid[4] + "OR " + sid[5] + " doesnot exists in the" + "\n" + seriesId);
							}
							break;
						default:

							Assert.fail(searchData + " has more than size " + sid.length
									+ " which is not handled.  Please handle!");

						}

					} else {
						for (k = 0; k < filters.size(); k++) {
						  if (filters.get(k).equals("Source")) {
								login.Log4j.info(sourcearr.length);
								// String source = lines[10];
								// login.Log4j.info(source);
							  if((sourcearr.length == 1) && var.equalsIgnoreCase("International Organisation for Economic Co-operation and Development") == true) {
								login.Log4j.info(sourcearr[0] + " does exists as Organisation for Economic Co-operation and Development in \n"+text);
							  } else if ((sourcearr.length == 1)
										&& validation(text,sourcearr[0]) == true) {
									login.Log4j.info(sourcearr[0] + " is exists in the" + "\n" + text);

							  } else if ((sourcearr.length == 2) && validation(text,sourcearr[0]) == true
										|| validation(text,sourcearr[1]) == true) {
									login.Log4j.info(
											sourcearr[0] + " OR " + sourcearr[1] + " is exists in the" + "\n" + text);
							  } else {
									if (sourcearr.length == 1) {
										
										Assert.fail(sourcearr[0] + " doesn't exist in " + text);
									} else {
										Assert.fail(sourcearr[0] + " OR " + sourcearr[1] + " doesn't exist in " + text);
									}
								}
							}
							if (filters.get(k).equals("Date")) {
								for (int l = 0; l < datearr.length; l++) {
									SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
									Date date = new Date();

									if (datearr[l].equalsIgnoreCase("First observation before")) {
										datearr[l] = "First date";
									}
									if (datearr[l].equals("First date")) {
										for (String Tooltip : lines) {
											if (Tooltip.contains("First date")) {
												login.Log4j.info(Tooltip);
												String[] frstDate = Tooltip.split(": ");
												String first_obs_before = sdf.format(date);
												if (sdf.parse(frstDate[1])
														.before(sdf.parse(first_obs_before)) == true) {
													login.Log4j.info(frstDate[1] + " is less than " + first_obs_before
															+ "? " + sdf.parse(frstDate[1])
																	.before(sdf.parse(first_obs_before)));
												} else {
													Assert.fail(frstDate[1] + " is not less than " + first_obs_before);
												}
											}
										}
									}

									if (datearr[l].equalsIgnoreCase("Last observation after")) {
										datearr[l] = "Last date";
									}
									if (datearr[l].equals("Last date")) {
										for (String Tooltip : lines) {
											if (Tooltip.contains("Last date")) {
												login.Log4j.info(Tooltip);
												String[] lastDate = Tooltip.split(": ");
												String last_obs_after = sdf.format(date);
												if (sdf.parse(lastDate[1]).after(sdf.parse(last_obs_after)) == true) {
													login.Log4j.info(lastDate[1] + " is greater than " + last_obs_after
															+ "? "
															+ sdf.parse(lastDate[1]).after(sdf.parse(last_obs_after)));
												} else {
													Assert.fail(lastDate[1] + " is not greater than " + last_obs_after);
												}
											}
										}
									}
								}
							}
							if (filters.get(k).equals("Frequency")) {
								login.Log4j.info("filter  is : " + filters.get(k));
								login.Log4j.info(frequencyarr.length);

								// for (String Tooltip:lines) {
								// if(Tooltip.contains("Frequency")) {
								// String frequency = Tooltip;
								login.Log4j.info(frequency);
								if ((frequencyarr.length == 1)
										&& (frequency.toUpperCase().contains(frequencyarr[0].toUpperCase()) == true)) {
									login.Log4j.info(frequencyarr[0] + " is exists in the" + "\n" + frequency);

								} else if ((frequencyarr.length == 2) && (frequency.contains(frequencyarr[0]) == true
										|| frequency.contains(frequencyarr[1]) == true)) {
									login.Log4j.info(frequencyarr[0] + " OR " + frequencyarr[1] + " is exists in the"
											+ "\n" + frequency);
								} else {
									if (frequencyarr.length == 1) {
										Assert.fail(frequencyarr[0] + " doesn't exist in " + frequency);
									} else {
										Assert.fail(frequencyarr[0] + " OR " + frequencyarr[1] + " doesn't exist in "
												+ frequency);
									}

								}
							}

							if (filters.get(k).equals("Status")) {
								login.Log4j.info(advancedfltr);
								sid = searchData.split(";");
								try {
									if (advancedfltr != null) {

										if (advancedfltr.equals("Subscribed series only")) {
											Thread.sleep(1000);
											if (!checkbox.isSelected()) {
												checkbox.click();
												login.Log4j.info("Element is clickable");
											} else {
												Assert.fail("Element is not clickable");
											}
										} else {
											if (advancedfltr.equals("Name only") && seriesName.toUpperCase()
													.contains(sid[0].toUpperCase()) == true) {
												login.Log4j.info(sid[0] + " is exists in the  : " + seriesName);

											} else {
												Assert.fail(sid[0] + " doesn't exists in the  : " + seriesName);
											}
										}
									}
								} catch (NullPointerException e) {
									Assert.fail("Nullpointer Exception " + e.getMessage());
								}

								if (fltrStatus.equals("Active")) {
									Thread.sleep(2000);
									WebElement list = login.driver.findElement(
											By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
									mouseOver.moveToElement(list).click().build().perform();
									if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Active")))
											.isDisplayed()) {
										Thread.sleep(2000);
										login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
										login.Log4j.info(fltrStatus + " series exists");
									} else {
										Assert.fail(fltrStatus + " doesn't exists");
									}

								} else if (seriesId.contains(sid[0]) == true) {
									login.Log4j.info(sid[0] + " is exists in the" + "\n" + seriesId);
								} else {
									Assert.fail(sid[0] + " doesn't exist in " + seriesId);

								}
							}
							if (filters.get(k).equals("Unit")) {
								login.Log4j.info("filter  is : " + filters.get(k));
								for (int l = 0; l < unitarr.length; l++) {
									login.Log4j.info("filter option is : " + unitarr[l]);
									// String unit = lines[2];
									// for(String Tooltip:lines) {
									// if(Tooltip.contains("Unit")) {
									// String unit = Tooltip;
									if (unit.contains(unitarr[l]) == true) {
										login.Log4j.info(unitarr[l] + " is exists in the" + "\n" + unit);
									} else {
										Assert.fail(unitarr[l] + " doesn't exist in " + unit);

									}

								}
							}
						}
					}
				}

			} else {
				Assert.fail("Sorry,No results were found ");
			}

		} catch (NoSuchElementException e) {

			Assert.fail("WebElement is null " + e.getMessage());
		}
	}

	@When("^User get the topics as \"([^\"]*)\"$")
	public void user_get_the_topics_as(String arg1) throws Throwable {
		topic = arg1;
		login.Log4j.info("topic is " + topic);
		Thread.sleep(1000);
		login.Log4j.info("Clicking on Databases");
		WebElement db = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Databases")));
		db.click();

	}

	@Then("^User verify the results$")
	public void user_verify_the_results() throws Throwable {
		// create instance of JavaScriptExecutor
		JavascriptExecutor jse = (JavascriptExecutor) login.driver;
		Thread.sleep(2000);
		WebElement Topic = login.driver.findElement(By.xpath("//span[contains(text(),'" + topic + "')]"));
		// Until the element is not visible keep scrolling
		jse.executeScript("arguments[0].scrollIntoView(true);", Topic);
		login.Log4j.info("Is 'Topic' displayed? - True/False:: " + Topic.isDisplayed());

	}

	@Then("^User should get the search results$")
	public void user_should_get_the_search_results() throws Throwable {
		login.Log4j.info(var);
		if (login.driver.findElement(By.xpath("//tr[@title='" + var + "']")).isDisplayed()) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//tr[@title='" + var + "']")).click();
			login.Log4j.info(var + " is exists");
		} else {
			Assert.fail(var + " doesn't exists");
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("region_filter"))).click();
	}

	@Then("^User verifies Filter search results$")
	public void user_verifies_Filter_search_results() throws Throwable {
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
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
					mouseOver.moveToElement(checkbox).click().build().perform();
					element = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--content']"));
					mouseOver.moveToElement(element).build().perform();
					// Until the element is not visible keep scrolling
					jse.executeScript("arguments[0].scrollIntoView(true);", element);
					text = element.getAttribute("title");
					login.Log4j.info(text);
					if (searchData.contains("AND")) {
						String[] keyword1 = searchData.split(" AND ");
						for (String result : keyword1) {
							login.Log4j.info(result);
							Thread.sleep(1000);
							if (text.toUpperCase().contains(result.toUpperCase()) == true) {
								login.Log4j.info(result + " exists in " + text);
							} else {
								showRelatedData(result, j);
								if (status == false) {
									Assert.fail(result + " keyword doesn't exists " + showdata);
								}

							}

						}
					} else if (searchData.contains("OR")) {
						String[] keywords = searchData.split(" OR ");
						login.Log4j.info("Length is "+ keywords.length);
						if ((keywords.length == 2) && text.toUpperCase().contains(keywords[0].toUpperCase()) == true
								|| text.toUpperCase().contains(keywords[1].toUpperCase()) == true) {
							login.Log4j.info(keywords[0] + " OR " + keywords[1] + " exists in " + text);

						} else if ((keywords.length == 3)
								&& text.toUpperCase().contains(keywords[0].toUpperCase()) == true
								|| text.toUpperCase().contains(keywords[1].toUpperCase()) == true
								|| text.toUpperCase().contains(keywords[2].toUpperCase()) == true) {
							login.Log4j.info(
									keywords[0] + " OR " + keywords[1] + " OR " + keywords[2] + " exists in " + text);

						} else {

							for (String result : keywords) {
								showRelatedData(result, j);
								if (status == true) {
									break;
								} else if (status == false) {
									Assert.fail(result + " keyword doesn't exists " + showdata);
								}
							}

						}

					} else if (searchData.contains("*")) {
						String[] str = searchData.split("\\*");
						// login.Log4j.info(str.length);
						switch (str.length) {
						case 1:
							if (text.toUpperCase().contains(str[0].toUpperCase()) == true) {
								login.Log4j.info(str[0] + " exists in " + text);

							} else {
								showRelatedData(str[0], j);
								if (status == false) {
									Assert.fail(str[0] + " keyword doesn't exists " + showdata);
								}
							}
							break;

						case 2:
							login.Log4j.info(str[0]);
							login.Log4j.info(str[1]);
							if (text.toUpperCase().contains(str[0].toUpperCase()) == true
									&& text.toUpperCase().contains(str[1].toUpperCase()) == true) {
								login.Log4j.info(str[0] + " AND " + str[1] + " exists in " + text);
							} else {
								for (String list : str) {
									showRelatedData(list, j);
									if (status == false) {
										Assert.fail(list + " keyword doesn't exists " + showdata);
									}
								}
							}
							break;
						default:
							login.Log4j.error(searchData + " size is more than " + str.length);
						}
					} else {
						if (searchData.contains("?")) {
							String[] str1 = searchData.split("\\?");
							login.Log4j.info(str1.length);
							switch (str1.length) {
							case 1:
								if (text.toUpperCase().contains(str1[0].toUpperCase()) == true) {
									login.Log4j.info(str1[0] + " exists in " + text);

								} else {
									showRelatedData(str1[0], j);
									if (status == false) {
										Assert.fail(str1[0] + " keyword doesn't exists " + showdata);
									}

								}
								break;

							case 2:
								login.Log4j.info(str1[0]);
								login.Log4j.info(str1[1]);
								if (text.toUpperCase().contains(str1[0].toUpperCase()) == true
										&& text.toUpperCase().contains(str1[1].toUpperCase()) == true) {
									login.Log4j.info(str1[0] + " AND " + str1[1] + " exists in " + text);
								} else {
									for (String list : str1) {
										showRelatedData(list, j);
										if (status == false) {
											Assert.fail(list + " keyword doesn't exists " + showdata);
										}
									}
								}
								break;
							default:
								login.Log4j.error(searchData + " size is more than " + str1.length);
							}
						}

					}
				}

			} else {
				Assert.fail("List size is null");
			}
		} catch (NoSuchElementException e) {

			Assert.fail("WebElement is null " + e.getMessage());
		}
	}

	public static boolean showRelatedData(String keyword, int j) throws Throwable {

		WebElement ele = login.driver.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
		Thread.sleep(1000);
		ele.click();

		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Related_Data"))).isDisplayed()) {
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Related_Data"))).click();
			List<WebElement> datasets = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Related_Data_text")));
			for (WebElement list : datasets) {
				showdata = list.getText();
				// login.Log4j.info(showdata);
				// login.Log4j.info(keyword);
				if (showdata.toUpperCase().contains(keyword.toUpperCase()) == true) {
					login.Log4j.info(keyword + " is exists in the" + "\n" + showdata);
					Thread.sleep(1000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
					status = true;
				} else {
					Thread.sleep(1000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
					status = false;

				}

			}
		}

		return status;

	}
	public boolean validation(String searchText, String sourcearr2) throws Throwable {
		String[] keywords = null;
	if(sourcearr2.contains(",")) {
			keywords = sourcearr2.split(",");
		    String keyword=keywords[0]+keywords[1];
		    keywords = keyword.split(" ");
		   
	} else {
		    	keywords = sourcearr2.split(" ");
	}
		login.Log4j.info(keywords.length);
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
		case 6: 
			if (searchText.toUpperCase().contains(keywords[0].toUpperCase()) == true
			   && searchText.toUpperCase().contains(keywords[1].toUpperCase()) == true
			   && searchText.toUpperCase().contains(keywords[2].toUpperCase()) == true
			   && searchText.toUpperCase().contains(keywords[3].toUpperCase()) == true
			   && searchText.toUpperCase().contains(keywords[4].toUpperCase()) == true
			   && searchText.toUpperCase().contains(keywords[5].toUpperCase()) == true) {
		        return true;
	        } else {
		       return false;
	        }
		case 7:
			if (searchText.toUpperCase().contains(keywords[0].toUpperCase()) == true
			   && searchText.toUpperCase().contains(keywords[1].toUpperCase()) == true
			   && searchText.toUpperCase().contains(keywords[2].toUpperCase()) == true
			   && searchText.toUpperCase().contains(keywords[3].toUpperCase()) == true
			   && searchText.toUpperCase().contains(keywords[4].toUpperCase()) == true
			   && searchText.toUpperCase().contains(keywords[5].toUpperCase()) == true
			   && searchText.toUpperCase().contains(keywords[6].toUpperCase()) == true) {
		        return true;
	        } else {
		       return false;
	        }
		default:
			return false;

		}
 
	}
}
