package CDMNext.StepDefinations;

import org.testng.Assert;

import org.testng.AssertJUnit;

import CDMNext.util.CommonFunctionality;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
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
	// public String fltrStatus;
	String[] frequencyarr = null;
	String[] unitarr = null;
	List<String> filters = new ArrayList<>();
	String[] regionarr = null;
	String[] Datearr = null;
	String[] Sourcearr = null;
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
	public String region;
	public String unit;
	public String frequency;
	public String Last_value;
	public String country;
	String[] source = null;
	public WebElement tooltip;
	public WebElement element;
	public WebElement checkbox;
	public WebElement ul_element;
	public String text;
	String[] lines = null;
	int finalCount;
	String TooltipInfo;
	String Morefilter;
	WebElement SeriesTab;
	static String Alldb_db;
	 Actions action = new Actions(login.driver);
	 JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	 WebDriverWait wait = new WebDriverWait(login.driver, 2000);
	 
	@Given("^User enters \"([^\"]*)\"$")
	public void user_enters(String arg1) throws Throwable {
		searchData = arg1;
		//login.driver.navigate().refresh();
		CommonFunctionality.ExpandRight();
		//CommonFunctionality.TopMethod();
		//CommonFunctionality.ResetMethod();
		login.Log4j.info("searching with " + searchData);
		CommonFunctionality.getElementByProperty(login.driver, "Search" , 8).sendKeys(searchData);
		
	}

	@And("^User selects \"([^\"]*)\" as \"([^\"]*)\"$")
	public void user_selects_as(String arg1, String arg2) throws Throwable {
		k = 0;
		filters.add(arg1);
		login.Log4j.info(filters);
		var = arg2;
		login.Log4j.info("clicking on " + arg1);
		switch(arg1){
		case "All Regions":
			regionarr = var.split(";");
			Thread.sleep(1500);
			login.driver.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]")).click();
			try {
						
				if(regionarr.length == 1 && regionarr[0].equals(arg2) == true) {
					Thread.sleep(1500);
					login.driver.findElement(By.className("filters-search--search-field")).sendKeys(arg2);
					Thread.sleep(1000);
					login.driver.findElement(By.xpath("//span[contains(text(),'" + arg2 + "')]")).click();
					break;
				}
				/*if(regionarr[0].equals("Japan")) {
					Thread.sleep(1500);
					login.driver.findElement(By.className("filters-search--search-field")).sendKeys(arg2);
//					CommonFunctionality.action.pause(1000).sendKeys(Keys.ENTER).perform();
					Thread.sleep(1000);
					login.driver.findElement(By.xpath("//span[contains(text(),'" + arg2 + "')]")).click();
					break;
					
				} */
				else if (regionarr.length == 2) {
					for (String Regionlist : regionarr) {
						login.Log4j.info(Regionlist);
						Thread.sleep(2000);
						if (Regionlist.equals("Japan")) {
							login.driver.findElement(By.className("filters-search--search-field")).sendKeys(Regionlist);
							Thread.sleep(2000);
							login.driver.findElement(By.xpath("//*[@class= 'text-dots' and contains(text(),'" + Regionlist + "')]")).click();
						} else {
							Thread.sleep(1000);
							login.driver.findElement(By.xpath("//*[contains(text(),'" + Regionlist + "')]")).click();
						}
					}
				}

			} catch (Exception e) {
				
			}
			break;
		case "Frequency":
			login.driver.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]")).click();
				frequencyarr = var.split(";");
				for (String list : frequencyarr) {
					login.Log4j.info("clicking on " + list);
					Thread.sleep(1000);
					login.driver.findElement(By.xpath("//*[@class='text-dots' and contains(text(),'" + list + "')]")).click();
					
				}
				break;
		case "Unit":
			unitarr = var.split(";");
			List<WebElement> unitFilterList;
			for (String list : unitarr) {
				login.Log4j.info("clicking on " + list);
				Thread.sleep(2000);
				login.driver.findElement(By.className("filters-search--search-field")).sendKeys(list);
				try {
				  unitFilterList = login.driver.findElements(By.xpath("//*[contains(@class,'units-filter-container')]//*[@class='text-dots']"));
				  for(int i = 0 ; i < unitFilterList.size(); i++ ) {
					Thread.sleep(500);
					element = unitFilterList.get(i);
					String SearchTxt = element.getText();
					login.Log4j.info(list);
					login.Log4j.info(SearchTxt);
					if(list.equalsIgnoreCase(SearchTxt) == true) {
						Thread.sleep(500);
						element.click();
						login.driver.findElement(By.className("filters-search--search-field")).clear();
						break;
					}
					
				}
				}catch(Exception e) {
					
				}
			}
			break;
		case "Date":
			Datearr = var.split(";");
			for (String list : Datearr) {
				login.Log4j.info("clicking on " + list);
				Thread.sleep(1000);
				login.driver.findElement(By.xpath("//*[contains(text(),'" + list + "')]")).click();
				
			}
			break;
		case "Status":
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]")).click();
			login.Log4j.info("clicking on " + arg2);
		    CommonFunctionality.getElementByXpath(login.driver,"//*[@class='dropdown-search-filter-wrapper']//*[contains(text(),'" + arg2 + "')]",10).click();
			break;
		case "Source":
			Sourcearr = var.split(";");
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//*[@class='dropdown--title']//*[contains(text(),'" + arg1 + "')]")).click();
			for (String list : Sourcearr) {
				login.Log4j.info("clicking on " + list);
				Thread.sleep(1000);
				login.driver.findElement(By.xpath("//*[@class='dropdown-search-filter-wrapper--body']//*[contains(text(),'" + list + "')]")).click();
				
			}
			break;
		default:
		}
		/*List<WebElement> ListOfFilters = login.driver.findElements(
				By.xpath("//*[contains(@class,'dropdown-search-filter-title')]//*[@class='dropdown--title']"));

		for (int i = 0; i < ListOfFilters.size(); i++) {
			int j = i+1;
			Thread.sleep(5000);
			WebElement ele = ListOfFilters.get(j);
			String fltrTxt = ele.getText();
			login.Log4j.info(fltrTxt);
			try {
				if (arg1.equals("Unit") && fltrTxt.equals("Unit")) {
					login.Log4j.info("clicking on " + arg1);
					ele.click();
					if (arg2.equals("MUR")) {
						Thread.sleep(2000);
//						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_option"))).click();
//						Thread.sleep(1000);
//						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unit_filter"))).clear();
						//Thread.sleep(2000);
						//login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unit_filter"))).sendKeys(arg2);
						login.driver.findElement(By.className("filters-search--search-field")).sendKeys(arg2);
						Thread.sleep(1000);
						login.driver.findElement(By.xpath("//div[@class='top-matches--column']//div[1]//span[contains(text(),'" + arg2 + "')][1]")).click();
						break;
						
					
					} else if(arg2.equals("kg") || arg2.equals("%") ) {
						unitarr = var.split(";");
						login.Log4j.info("clicking on " + arg2);
						Thread.sleep(1000);
						login.driver.findElement(By.xpath("//div[@class='top-matches--column']//div[1]//span[contains(text(),'" + arg2 + "')][1]")).click();
						break;
					}
					else {
						unitarr = var.split(";");
						for (String list : unitarr) {
							login.Log4j.info("clicking on " + list);
							Thread.sleep(1000);
							element = login.driver.findElement(By.xpath("//*[contains(text(),'" + list + "')]"));
							CommonFunctionality.jse.executeScript("arguments[0].scrollIntoView(true);", element);
							Thread.sleep(1000);
							element.click();
						}
						break;
					}

				} else if (arg1.equals("Region") && fltrTxt.equals("Region")) {
					
					login.Log4j.info("clicking on " + arg1);
					ele.click();
					try {
						regionarr = var.split(";");
						login.Log4j.info(regionarr[0]);
						if(regionarr.length == 1 && regionarr[0].equals(arg2) == true) {
							Thread.sleep(1500);
							login.driver.findElement(By.className("filters-search--search-field")).sendKeys(arg2);
//							CommonFunctionality.action.pause(1000).sendKeys(Keys.ENTER).perform();
							Thread.sleep(1000);
							login.driver.findElement(By.xpath("//span[contains(text(),'" + arg2 + "')]")).click();
							break;
						}
						if(regionarr[0].equals("Japan")) {
							Thread.sleep(1500);
							login.driver.findElement(By.className("filters-search--search-field")).sendKeys(arg2);
//							CommonFunctionality.action.pause(1000).sendKeys(Keys.ENTER).perform();
							Thread.sleep(1000);
							login.driver.findElement(By.xpath("//span[contains(text(),'" + arg2 + "')]")).click();
							break;
							
						} else if (regionarr[0].equals("Albania") || regionarr[1].equals("Japan")) {
							for (String list : regionarr) {
								Thread.sleep(4000);
								if (list.equals("Japan")) {
									login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_option")))
											.click();
									Thread.sleep(1000);
									login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unit_filter")))
											.clear();
									Thread.sleep(1000);
									login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unit_filter")))
											.sendKeys(list);
									Thread.sleep(1000);
									login.driver.findElement(By.xpath("//*[contains(text(),'" + list + "')]")).click();
								} else {
									login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_option")))
											.click();
									Thread.sleep(1000);
									login.driver.findElement(By.xpath("//*[contains(text(),'" + list + "'])")).click();
								}
							}
						}

					} catch (Exception e) {
						Thread.sleep(1500);
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("region_By_group"))).click();
					}
				} else {
					if (arg1.equals(fltrTxt)) {
						login.Log4j.info("clicking on " + arg1);
						ele.click();
						Filterarr = var.split(";");
						for (String list : Filterarr) {
							login.Log4j.info("clicking on " + list);
							Thread.sleep(1000);
							login.driver.findElement(By.xpath("//*[@class='text-dots' and contains(text(),'" + list + "')]")).click();
							
						}
						break;
					}

				}
			} catch (

			NoSuchElementException e) {
				Assert.fail("Filter is null");
			}
		}*/
	}

	@And("^User has clicked on \"([^\"]*)\"$")
	public void user_has_clicked_on(String arg1) throws Throwable {
		login.Log4j.info("Clicking on " + arg1);
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//*[contains(text(),'" + arg1 + "')]")).click();
	}

	@And("^User selects \"([^\"]*)\"$")
	public void user_selects(String arg1) throws Throwable {
		advancedfltr = arg1;
		CommonFunctionality.wait(1000);
		List<WebElement> ele = login.driver.findElements(By.xpath("//*[@class='more-filter-content--left']//*[contains(@class,'section__other')]//*[@class='filter-item']//span[@class='text-dots']"));
		for(int i = 0; i < ele.size(); i++) {
			String fltrTxt = ele.get(i).getText();
			if(fltrTxt.contains(arg1)) {
				ele.get(i).click();
			}
		}
	}

	@And("^User selected \"([^\"]*)\" as \"([^\"]*)\"$")
	public void user_selected_as(String arg1, String arg2) throws Throwable {
		Alldb_db = arg2;
		String[] database = arg2.split(",");
		for (String dblist : database) {
			Thread.sleep(2000);
			login.Log4j.info("Selecting " + dblist);
			List<WebElement> checkbox = login.driver.findElements(By.xpath("//*[@class='more-filter-content']/div[2]/div[1]//span[@class='text-dots' and contains(text(),'" + dblist + "')]"));
			
			if (checkbox.size() > 0) {
				login.driver.findElement(By.xpath("//*[@class='more-filter-content']/div[2]/div[1]//span[@class='text-dots' and contains(text(),'" + dblist + "')]")).click();
			} else {
				login.driver.findElement(By.xpath("//*[contains(text(),'" + dblist + "')]")).click();
			}
		}
	}

	@Then("^User verify the search results$")
	public void user_verify_the_search_results() throws Throwable {

		login.Log4j.info("Clicking on  Series tab ");
		CommonFunctionality.wait(7000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Series"))));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(login.LOCATORS.getProperty("Series")))).click();
		ul_element = null;
		try {
			CommonFunctionality.wait(2000);
			ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
			AssertJUnit.assertNotNull(ul_element);
			List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
			login.Log4j.info("List size is :" + li_All.size());
			List<WebElement> sName = login.driver.findElements(By.xpath("//li//*[@class='series-item--name']"));
			if (li_All.size() > 0) {
				for (int i = 0; i < li_All.size(); i++) {
					login.Log4j.info(i);
					login.Log4j.info(li_All.size());
					Thread.sleep(1000);
					j = i + 1;
					checkbox = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']//span"));
					// action.moveToElement(checkbox).click().build().perform();
					// Thread.sleep(1000);
					action.moveToElement(sName.get(i)).build().perform();
					Thread.sleep(700);
					tooltip = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text")));
					text = tooltip.getText();
					// login.Log4j.info("Title information is \n" + text);
					// Until the element is not visible keep scrolling
					//CommonFunctionality.jse.executeScript("arguments[0].scrollIntoView(true);", element);
					lines = text.split("\n");
					login.Log4j.info("filter is " + filters);
					for (String Tooltip : lines) {
						// String str=null;
						if (Tooltip.contains("Series id")) {
							seriesId = Tooltip;
						} else if (Tooltip.contains("Name")) {
							seriesName = Tooltip;
						} else if (Tooltip.contains("Unit")) {
							unit = Tooltip;
						} else if (Tooltip.contains("Frequency")) {
							frequency = Tooltip;
						} else if (Tooltip.contains("Region")) {
							region = Tooltip;
						}
					}

					if (filters.isEmpty()) {
						sid = searchData.split(";");

						switch (sid.length) {
						case 1:
							login.Log4j.info(advancedfltr);
							if (advancedfltr != null) {
								if (advancedfltr.equals("Subscribed series only")
										&& seriesId.contains(sid[0]) == true) {
									if (!checkbox.isSelected()) {
										Thread.sleep(500);
										checkbox.click();
										login.Log4j.info("Element is clickable");
									} else {
										Assert.fail("Element is not clickable");
									}
									/*
									 * } else if (advancedfltr.equals("Subscribed series only")) { if
									 * (checkbox.getAttribute("class").
									 * contains("series-list-item--checkbox svg-checkbox")) { // Thread.sleep(1500);
									 * // mouseOver.moveToElement(checkbox).click().build().perform();
									 * login.Log4j.info("Subscribed series are clickable"); } else {
									 * Assert.fail("Subscribed series are not clickable"); }
									 */
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
								if (validation(text,sid[0]) == true || text.contains("Gross Domestic Product") == true) {
									login.Log4j.info(sid[0] + " is exists in the" + "\n" + text);
								} else {
									SearchTest.sspValidation(j);
									if (showdata.toUpperCase().contains(sid[0].toUpperCase()) == true) {
										login.Log4j.info(sid[0] + " is exists in the" + "\n" + showdata);
										Thread.sleep(1000);
										login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction")))
												.click();

									} else {
										Thread.sleep(1000);
										login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction")))
												.click();
										Assert.fail(sid[0] + " doesn't exists in the" + "\n" + showdata);
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
								showRelatedData(searchData, j);
								if (status == false) {
									Assert.fail(sid[0] + " OR " + sid[1] + " doesn't exists \n" + showdata);
								}
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
								login.Log4j.info(Sourcearr.length);
								login.Log4j.info(Sourcearr[0]);
								// String source = lines[10];
								// login.Log4j.info(source);
								if ((Sourcearr.length == 1) && text
										.contains("Organisation for Economic Co-operation and Development") == true) {
									login.Log4j.info(Sourcearr[0]
											+ " does exists as Organisation for Economic Co-operation and Development in \n"
											+ text);
								}  else if((Sourcearr.length == 1) && text.contains("International Monetary Fund") == true) {
									login.Log4j.info(Sourcearr[0]
											+ " does exists as Internationa Monetary Fund in \n"
											+ text);
								}
								else if((Sourcearr.length == 1)
										&& text.contains("Федеральная служба государственной статистики") == true) {
									login.Log4j.info(Sourcearr[0] + " is exists in the" + "\n" + text);
							    } else if ((Sourcearr.length == 1) && text.contains("AIA Group Limited") == true) {
									login.Log4j.info(Sourcearr[0] + " is exists in the" + "\n" + text);
								} else if ((Sourcearr.length == 1) && text.contains("中国汽车工业协会") == true) {
									login.Log4j.info(Sourcearr[0] + " is exists in the" + "\n" + text);
								} else if ((Sourcearr.length == 1) && validation(text, Sourcearr[0]) == true) {
									login.Log4j.info(Sourcearr[0] + " is exists in the" + "\n" + text);

									/*
									 * } else if ((sourcearr.length == 2) && validation(text, sourcearr[0]) == true
									 * || validation(text, sourcearr[1]) == true) { login.Log4j.info( sourcearr[0] +
									 * " OR " + sourcearr[1] + " is exists in the" + "\n" + text);
									 */
								} else {
									if (Sourcearr.length == 1) {
										Assert.fail(Sourcearr[0] + " doesn't exist in " + text);
									} else if ((Sourcearr.length == 2) && validation(text, Sourcearr[0]) == true
											|| validation(text, Sourcearr[1]) == true) {
										login.Log4j.info(Sourcearr[0] + " OR " + Sourcearr[1] + " is exists in the"
												+ "\n" + text);
									} else {
										Assert.fail(Sourcearr[0] + " OR " + Sourcearr[1] + " doesn't exist in " + text);
									}
								}
							}
							if (filters.get(k).equals("Date")) {
								for (int m = 0; m < Datearr.length; m++) {
									SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
									Date date = new Date();

									if (Datearr[m].equalsIgnoreCase("First observation before")) {
										Datearr[m] = "First date";
									}
									if (Datearr[m].equals("First date")) {
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

									if (Datearr[m].equalsIgnoreCase("Last observation after")) {
										Datearr[m] = "Last date";
									}
									if (Datearr[m].equals("Last date")) {
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
								login.Log4j.info(frequency);
								String str = "Half-yearly";
								String str1 = "Annual";
								if ((frequencyarr.length == 1)) {
									if (frequencyarr[0].equals("Semiannually")) {
										if (frequency.toUpperCase().contains(frequencyarr[0].toUpperCase()) == true
												|| frequency.toUpperCase().contains(str.toUpperCase()) == true) {
											login.Log4j.info(frequencyarr[0] + " OR " + str + " is exists in the" + "\n"
													+ frequency);
										}
									} else {
										if (frequency.toUpperCase().contains(frequencyarr[0].toUpperCase()) == true
												|| frequency.toUpperCase().contains(str1.toUpperCase()) == true) {
											login.Log4j.info(frequencyarr[0] + " OR " + str1 + " is exists in the" + "\n"
													+ frequency);
										}
									}

								} else if ((frequencyarr.length == 2)
										&& (frequency.toUpperCase().contains(frequencyarr[0].toUpperCase()) == true
												|| frequency.toUpperCase().contains(frequencyarr[1].toUpperCase()) == true
												|| frequency.toUpperCase().contains(str1.toUpperCase()) == true)) {
									login.Log4j.info(frequencyarr[0] + " OR " + frequencyarr[1] + " is exists in the" + "\n"
											+ frequency);
								} else if ((frequencyarr.length == 2)
										&& (frequency.toUpperCase().contains(frequencyarr[0].toUpperCase()) == true
												|| frequency.toUpperCase().contains(frequencyarr[1].toUpperCase()) == true
												|| frequency.toUpperCase().contains(str.toUpperCase()) == true)) {
									login.Log4j.info(frequencyarr[0] + " OR " + frequencyarr[1] + str + " is exists in the"
											+ "\n" + frequency);
								} else {
									if (frequencyarr.length == 1) {
										Assert.fail(frequencyarr[0] + " doesn't exist in " + frequency);
									} else {
										Assert.fail(frequencyarr[0] + " OR " +frequencyarr[1] + " doesn't exist in "
												+ frequency);
									}

								}
							}

							if (filters.get(k).equals("Status")) {
								login.Log4j.info(advancedfltr);
								Thread.sleep(2000);
								try {
									sid = searchData.split(";");
									if (advancedfltr != null) {

										if (advancedfltr.equals("Subscribed series only")) {
											Thread.sleep(1000);
											if (checkbox.isDisplayed()) {
												Thread.sleep(1000);
												action.moveToElement(checkbox).click().build()
														.perform();
												login.Log4j.info("Subscribed series are clickable");
											} else {
												Assert.fail("Subscribed series are not clickable");
											}
										} else {
											if (advancedfltr.equals("Name only") && seriesName.toUpperCase()
													.contains(sid[0].toUpperCase()) == true) {
												login.Log4j.info(sid[0] + " is exists in the  : " + seriesName);

											} else {
												login.Log4j.error(sid[0] + " doesn't exists in the  : " + seriesName);
												Assert.fail(sid[0] + " doesn't exists in the  : " + seriesName);
											}
										}
									} else if (seriesId.contains(sid[0]) == true) {
										login.Log4j.info(sid[0] + " is exists in the" + "\n" + seriesId);
									} else {
										Assert.fail(sid[0] + " doesn't exist in " + seriesId);
									}
								} catch (NullPointerException e) {
									// Assert.fail("Nullpointer Exception " + e.getMessage());
								}

								if (var.equals("Active")) {
									Thread.sleep(2000);
									WebElement list = login.driver
											.findElement(By.xpath("//li[" + j + "]//div[@class='series-item--name']"));
									action.moveToElement(list).click().build().perform();
									if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Active")))
											.isDisplayed()) {
										Thread.sleep(2000);
										login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction")))
												.click();
										login.Log4j.info(var + " series exists");
									} else {
										Assert.fail(var + " doesn't exists");
									}

								} else if (var.equals("Rebased")) {
									login.Log4j.info(var);
									//Thread.sleep(2000);
									//element.click();
									CommonFunctionality.getElementByXpath(login.driver,"//li[" + j + "]//div[@class='series-item--name']",5).click();
									if (login.driver.findElement(By.xpath(
											"//div[@class='series-changes-time-line--status series-changes-time-line--status__rebased']"))
											.isDisplayed()) {
										Thread.sleep(2000);
										login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction")))
												.click();
										login.Log4j.info(var + " series exists");
									} else {
										Assert.fail(var + " doesn't exists");
									}
								}
							}
							if (filters.get(k).equals("Unit")) {
								login.Log4j.info("filter is : " + filters.get(k));
								if (unitarr.length == 1) {
										if (unit.contains(unitarr[0]) == true) {
											login.Log4j.info(unitarr[0] + " is exists in the" + "\n" + unit);
										} else {
											Assert.fail(unitarr[0] + " doesn't exist in " + unit);

										}

								} else if (unitarr.length == 2) {
									if (unit.contains(unitarr[0]) == true || unit.contains(unitarr[1]) == true) {
										login.Log4j.info(
												unitarr[0] + " OR " + unitarr[1] + " is exists in the" + "\n" + unit);
									} else {
										Assert.fail(unitarr[0] + " OR " + unitarr[1] + " doesn't exist in " + unit);
									}
								}
							}
							if (filters.get(k).equals("Region")) {
								login.Log4j.info("filter  is : " + filters.get(k));

								if (region.contains(regionarr[0]) == true || region.contains(regionarr[1]) == true) {
									login.Log4j.info(
											regionarr[0] + " OR " + regionarr[1] + " is exists in the" + "\n" + region);
								} else {
									Assert.fail(regionarr[0] + " OR " + regionarr[1] + " doesn't exist in " + region);
								}
							}
						}
					}
					// Until the element is not visible keep scrolling
					jse.executeScript("arguments[0].scrollIntoView(true);", sName.get(i));
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
		Thread.sleep(4000);
		login.Log4j.info("Clicking on Databases");
		WebElement db = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Databases_Tab")));
		db.click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Matches only')]", 20).click();

	}

	@Then("^User verify the results$")
	public void user_verify_the_results() throws Throwable {
		Thread.sleep(2000);
		WebElement ele;
		if (topic.equals("Aggregate: North American Free Trade Agreement (NAFTA)") || topic.equals("Lending Rates")) {
			ele = login.driver.findElement(By.xpath("//*[@class='tree-node open full-expanded']/*[2]/*[2]/*[1]/*[1]"));
		} else {
//			ele = login.driver.findElement(
//					By.xpath("//*[@class='database-node tree-node open full-expanded']/*[3]/*[1]/*[2]/*[2]/*[1]/*[1]"));
			ele = login.driver.findElement(
					By.xpath("//*[@class='database-node tree-node open full-expanded']/*[3]/*[1]/*[2]/*[2]/*[1]/*[1]"));
		}
		String Actual_Topic = ele.getText();
		login.Log4j.info(Actual_Topic);
		Assert.assertEquals(Actual_Topic, topic);
		//login.Log4j.info("Is 'Topic' displayed? - True/False:: " + Topic.isDisplayed());

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
		login.Log4j.info("Clicking on  Series tab ");
		Thread.sleep(5000);
		SeriesTab = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series")));
		SeriesTab.click();

		ul_element = null;
		try {
			Thread.sleep(5000);
			ul_element = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.cssSelector(login.LOCATORS.getProperty("UL"))));
			AssertJUnit.assertNotNull(ul_element);
			List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
			login.Log4j.info("List size is :" + li_All.size());
			List<WebElement> sName = login.driver.findElements(By.xpath("//li//*[@class='series-item--name']"));
			if (li_All.size() > 0) {
				for (int i = 0; i < li_All.size(); i++) {

					login.Log4j.info(i);
					login.Log4j.info(li_All.size());
					Thread.sleep(500);
					int j = i + 1;
					// checkbox = login.driver.findElement(By.xpath("//li[" + j +
					// "]//div[@class='series-list-item--checkbox-wrapper']"));
					// CommonFunctionality.action.moveToElement(checkbox).click().build().perform();
					// Thread.sleep(1000);
					action.moveToElement(sName.get(i)).build().perform();
					Thread.sleep(700);
					tooltip = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text")));
					text = tooltip.getText();
					// login.Log4j.info(text);
					// Until the element is not visible keep scrolling
					//CommonFunctionality.jse.executeScript("arguments[0].scrollIntoView(true);", element);

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
						login.Log4j.info("Length is " + keywords.length);
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
								// login.Log4j.info(str1[0]);
								// login.Log4j.info(str1[1]);
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
					// Until the element is not visible keep scrolling
					jse.executeScript("arguments[0].scrollIntoView(true);", sName.get(i));
				}
			} else {
				Assert.fail("Sorry,No results were found ");
			}

		} catch (NoSuchElementException e) {

			Assert.fail("WebElement is null " + e.getMessage());
		}
	}

	public static boolean showRelatedData(String keyword, int j) throws Throwable {
		SearchTest.sspValidation(j);
		String[] strarr = keyword.split(";");
		
		switch (strarr.length) {
		case 1:
			if (showdata.toUpperCase().contains(strarr[0].toUpperCase()) == true) {
				login.Log4j.info(strarr[0] + " is exists in the" + "\n" + showdata);
				Thread.sleep(1000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
				status = true;
			} else {
				Thread.sleep(1000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
				status = false;
			}
			break;

		case 2:
						
			if (showdata.toUpperCase().contains(strarr[0].toUpperCase()) == true
					|| showdata.toUpperCase().contains(strarr[1].toUpperCase()) == true) {
				login.Log4j.info(strarr[0] + " OR" + strarr[1] + " is exists in the" + "\n" + showdata);
				Thread.sleep(1000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
				status = true;
			} else {
				Thread.sleep(1000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction"))).click();
				status = false;
			}
			break;
		default:
			break;

		}
		return status;
		/*
		 * if (showdata.toUpperCase().contains(keyword.toUpperCase()) == true) {
		 * login.Log4j.info(keyword + " is exists in the" + "\n" + showdata);
		 * Thread.sleep(1000);
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction")))
		 * .click(); status = true; } else { Thread.sleep(1000);
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closeAction")))
		 * .click(); status = false; } return status;
		 */
	}

	@And("^Select \"([^\"]*)\" from \"([^\"]*)\" filter$")
	public void select_from_filter(String arg1, String arg2) throws Throwable {
		Morefilter = arg1;
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).clear();
		// CommonFunctionality.TopMethod();
		CommonFunctionality.ResetMethod();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//*[contains(text(),'" + arg2 + "')]")).click();
		login.Log4j.info("Clicking on " + arg2);
		WebElement SeriesCount = null;
		try {
			Thread.sleep(3000);
			SeriesCount = login.driver.findElement(By.xpath("//tr[@title='" + arg1 + "']//td[2]"));
			String filter_count = SeriesCount.getText();
			login.Log4j.info(arg1 + " filter count is: " + filter_count);
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//tr[@title='" + arg1 + "']")).click();
			String replace = null;
			if (filter_count.contains(",")) {
				String FilterCount = filter_count.replaceAll(",", "");
				replace = FilterCount.replaceAll("\\(", "").replaceAll("\\)", "");
				login.Log4j.info(arg1 + " filter count is: " + replace);
				finalCount = Integer.parseInt(replace);

			} else {
				replace = filter_count.replaceAll("\\(", "").replaceAll("\\)", "");
				login.Log4j.info(arg1 + " filter count is: " + replace);
				finalCount = Integer.parseInt(replace);

			}

		} catch (NullPointerException | NumberFormatException e) {
			Assert.fail("Series count is null for More filter" + e.getMessage());
		}
	}

	@Then("^User verify the series count$")
	public void user_verify_the_series_count() throws Throwable {
		Thread.sleep(5000);
		DatabasesTab.AfterMethod();
		login.Log4j.info("After apply the filter count is: " + DatabasesTab.afterFilter);
		if (finalCount == DatabasesTab.afterFilter) {
			login.Log4j.info("The series count is shown correctly for " + Morefilter);
		} else {
			Assert.fail("The series count is shown incorrectly for " + Morefilter);
		}

		if (Morefilter.equalsIgnoreCase("With suggestions for rebased/discontinued series")) {
			Thread.sleep(3000);
			CommonFunctionality.ResetMethod();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_left"))).click();
		}
	}

	@Then("^User check for the scubscribed series$")
	public void user_check_for_the_scubscribed_series() throws Throwable {
		login.Log4j.info("Clicking on  Series tab ");
		 Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		ul_element = null;
		try {
			 Thread.sleep(3000);
			ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
			AssertJUnit.assertNotNull(ul_element);
			List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
			login.Log4j.info("List size is :" + li_All.size());

			if (li_All.size() > 0) {
				for (int i = 0; i < li_All.size(); i++) {
					Thread.sleep(2000);
					int j = i + 1;
					checkbox = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
					//CommonFunctionality.jse.executeScript("arguments[0].scrollIntoView(true);", checkbox);
					if (checkbox.isDisplayed()) {
						Thread.sleep(1000);
						action.moveToElement(checkbox).click().build().perform();
						login.Log4j.info("Subscribed series are clickable");
					} else {
						Assert.fail("Subscribed series are not clickable");
					}
					jse.executeScript("arguments[0].scrollIntoView(true);", checkbox);
				}
			}
		} catch (Exception e) {
			login.Log4j.info(e.getMessage());
		}
	}
	@Then("^Should get list of series$")
	public void should_get_list_of_series() throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		Thread.sleep(3000);
		List<WebElement> ListOfPages = login.driver
				.findElements(By.xpath("//*[@class='search-series-pagination-pages-wrapper']//span"));
		for (int m = 0; m < ListOfPages.size(); m++) {
			CommonFunctionality.wait(2000);
			ListOfPages.get(m).click();
			CommonFunctionality.wait(3000);
			ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
			List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
			List<WebElement> sName = login.driver.findElements(By.xpath("//li//*[@class='series-item--name']"));
			login.Log4j.info("List size is :" + sName.size());

			for (int i = 0; i < sName.size(); i++) {
				action.pause(1500).moveToElement(sName.get(i)).build().perform();
				CommonFunctionality.wait(800);
				tooltip = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text")));
				TooltipInfo = tooltip.getText();
				// Until the element is not visible keep scrolling
				jse.executeScript("arguments[0].scrollIntoView(true);", sName.get(i));
				//login.Log4j.info(TooltipInfo);
				lines = TooltipInfo.split("\n");
				CommonFunctionality.wait(200);
				for (String Tooltip : lines) {
					// String str=null;
					if (Tooltip.contains("Series id")) {
						seriesId = Tooltip;
					}
					if (Tooltip.contains("Region")) {
						country = Tooltip;
					}
					if (Tooltip.contains("Frequency")) {
						frequency = Tooltip;
					}
					if (Tooltip.contains("Last value")) {
						Last_value = Tooltip;
					}
				}
				login.Log4j.info(seriesId  + country +  frequency + Last_value);

			}
		}
	}
	boolean validation(String searchText, String sourcearr2) throws Throwable {
		String[] keywords = null;
		if (sourcearr2.contains(",")) {
			keywords = sourcearr2.split(",");
			String keyword = keywords[0] + keywords[1];
			keywords = keyword.split(" ");

		} else {
			keywords = sourcearr2.split(" ");
		}
		// login.Log4j.info(keywords.length);
		switch (keywords.length) {
		case 1:
			if (searchText.toUpperCase().contains(keywords[0].toUpperCase()) == true) {
				return true;
			} else {
				return false;
			}
		case 2:
			if (searchText.equals("household income") == true || searchText.equals("consumer expenditure") == true || searchText.equals("Exchange Rate") == true
					&& searchText.toUpperCase().contains(keywords[0].toUpperCase()) == true
					|| searchText.toUpperCase().contains(keywords[1].toUpperCase()) == true ) {
				return true;
			} 
			/*else if(searchText.equals(searchData) == true && searchText.toUpperCase().contains(keywords[0].toUpperCase()) == true
					|| searchText.toUpperCase().contains(keywords[1].toUpperCase()) == true) {
				return true;
			}*/ 
			else if (searchText.toUpperCase().contains(keywords[0].toUpperCase()) == true
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
		case 8:
			if (searchText.toUpperCase().contains(keywords[0].toUpperCase()) == true
					&& searchText.toUpperCase().contains(keywords[1].toUpperCase()) == true
					&& searchText.toUpperCase().contains(keywords[2].toUpperCase()) == true
					&& searchText.toUpperCase().contains(keywords[3].toUpperCase()) == true
					&& searchText.toUpperCase().contains(keywords[4].toUpperCase()) == true
					&& searchText.toUpperCase().contains(keywords[5].toUpperCase()) == true
					&& searchText.toUpperCase().contains(keywords[6].toUpperCase()) == true
					&& searchText.toUpperCase().contains(keywords[7].toUpperCase()) == true) {
				return true;
			} else {
				return false;
			}
		default:
			return false;

		}

	}
}
