package CDMNext.StepDefinations;

import static org.junit.Assert.assertNotEquals;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.fail;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class CrossSection {

	Actions action = new Actions(login.driver);
	JavascriptExecutor js = (JavascriptExecutor) login.driver;
	SoftAssert sa = new SoftAssert();
	CDMNextSprintCases cv = new CDMNextSprintCases();
	ChartVisual chart = new ChartVisual();
	Comparables cmp = new Comparables();
	public static String functions_item_id;
	public static String functions_item_id_last_series;
	public static String functions_item_id_next_series;
	public static String applied_function_in_fx;
	public static String renamed_insight_name;
	public boolean functions_checkbox;
	public boolean replace_checkbox;
	public static String method_name;
	public static int actual_series;

	@And("^Clicking \"([^\"]*)\" filter$")
	public void clicking_filter(String arg1) throws Throwable {
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[contains(@class,'search-filters-panel ps-container')]//*[text()='" + arg1 + "']", 10)
				.click();
	}

	@SuppressWarnings("deprecation")
	public static void Deleting_series() throws Throwable {
		CommonFunctionality.wait(1000);
		WebElement series = CommonFunctionality.getElementByXpath(login.driver,
				"//input[@name='select_all_dataselection']/ancestor::div[3]", 10);
		if (!(series.getAttribute("class").contains("list-view-wrapper__empty-selection"))) {
			boolean select_all = login.driver.findElement(By.xpath("//input[@name='select_all_dataselection']"))
					.isSelected();
			if (select_all == false) {
				new Actions(login.driver)
						.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
								"//input[@name='select_all_dataselection']/following-sibling::span", 10))
						.pause(200).click().build().perform();
				CommonFunctionality
						.getElementByXpath(login.driver,
								"//div[@title='Delete (Delete). Delete selected series from the `My series`.']/div", 15)
						.click();
			} else {
				CommonFunctionality
						.getElementByXpath(login.driver,
								"//div[@title='Delete (Delete). Delete selected series from the `My series`.']/div", 15)
						.click();
			}
		} else {
			System.out.println("No Series is found in myseries pane to delete");
		}
		CommonFunctionality.wait(3000);
	}

	@And("^Remove series from myseries pane$")
	public static void remove_series_from_myseries_pane() throws Throwable {
		WebElement selected = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='input-control--indicator']//*[@class='icon']//following::*[contains(@class,'list-container')]",
				15);
		if (selected.getAttribute("class").contains("without-data")) {
			login.Log4j.info("No Series is added in myseries list to delete");
		} else if (selected.getAttribute("class").contains("all-selected")) {
			CommonFunctionality.getElementByXpath(login.driver, "//div[@data-action='delete']", 15).click();
		} else {
			Deleting_series();
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Select all series from myseries and click on fx option$")
	public void select_all_series_from_myseries_and_click_on_fx_option() throws Throwable {
		boolean select_all = login.driver.findElement(By.xpath("//input[@name='select_all_dataselection']"))
				.isSelected();
		if (select_all == false) {
			login.driver.findElement(By.xpath("//*[@class='input-control--indicator']")).click();
			// new Actions(login.driver)
			// .moveToElement(login.driver.findElement(By.xpath("//*[@class='input-control--indicator']"))).pause(500).click().build().perform();
		}
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@title,'More') and @class='insight-action-panel--btn']", 15))
				.pause(500).click().build().perform();
	}

	@And("^Count the total series$")
	public void count_the_total_series() throws Throwable {
		System.out.println("count the total series");
		CommonFunctionality.wait(15000);
		List<WebElement> series = login.driver.findElements(By.className("series-name-field--series-name"));
		CommonFunctionality.wait(2000);
		System.out.println("count the total series:" + series.size());
		System.out.println("ChartVisual.myseries_before:" + ChartVisual.myseries_before);
		assertNotEquals(ChartVisual.myseries_before, series.size());

	}

	@And("^Select \"([^\"]*)\" tab in left pan$")
	public void select_tab_in_left_pan(String arg1) throws Throwable {
		WebElement left = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'toggler-control__sm')]//*[contains(text(),'" + arg1 + "')]/parent::label", 15);
		if (!(left.getAttribute("class").contains("toggler-control-item__selected"))) {
			left.click();
		}
	}

	@And("^Clicking \"([^\"]*)\" option from myseries$")
	public void clicking_option_from_myseries(String arg1) throws Throwable {
		CommonFunctionality
				.getElementByXpath(login.driver, "//button[@title='List mode']", 15)
				.click();
	}

	@And("^Clicking the \"([^\"]*)\" option from myseries$")
	public void clicking_the_option_from_myseries(String arg1) throws Throwable {
		CommonFunctionality
				.getElementByXpath(login.driver, "//button[@title='Table mode']", 15)
				.click();
	}

	@SuppressWarnings("deprecation")
	@And("^Search for the series with SID \"([^\"]*)\" and click on \"([^\"]*)\" option$")
	public void search_for_the_series_with_SID_and_click_on_option(String arg1, String arg2) throws Throwable {

		CommonFunctionality.getElementBycssSelector(login.driver, "a[data-id='myseries']", 15).click();
		WebElement data = CommonFunctionality.getElementBycssSelector(login.driver, "span[data-id='DATA']", 15);
		if (!data.getAttribute("class").contains("series-tab__hidden")) {
			new Actions(login.driver).moveToElement(data).pause(500).click().build().perform();
		}
		CommonFunctionality.getElementBycssSelector(login.driver, "div[title='View results as List']", 15).click();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 15).clear();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 15).sendKeys(arg1, Keys.ENTER);

		Thread.sleep(3000);

		// List<WebElement> list =
		// login.driver.findElements(By.xpath("//div[@class='series-list-item--content']"));

		List<WebElement> list = login.driver.findElements(By.xpath("//div[@class='series-item--name']"));

		if (arg1.equals("310902301;310902401") || arg1.equals("2106981502;2069515202") || arg1.equals("310901701")
				|| arg1.equals("20515215302")) {
			for (int i = 1; i <= list.size(); i++) {
				System.out.println("Total series========>:" + list.size());
//				WebElement series_unselected = CommonFunctionality.getElementByXpath(login.driver, "(//span[@class='series-list-item--checkbox svg-checkbox'])["+i+"]", 15);
//				WebElement series = CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='series-item--name'])["+i+"]", 15); 
//
//				System.out.println(series_unselected.getAttribute("class"));
//				System.out.println("series-list-item__selected");
//				

				login.driver
						.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]"))
						.click();
				Thread.sleep(2000);

//				if(!series_unselected.getAttribute("class").contains("series-list-item__selected")) {
//				new Actions(login.driver).moveToElement(series).pause(3000).click().build().perform();
//				}
			}

		}
		if (arg1.equals("310901701;310901801") || arg1.equals("9380901;9385301")) {
			System.out.println("===========>Enter into if condition");
			WebDriverWait wait = new WebDriverWait(login.driver, 7);
			WebElement Series = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series")));
			Thread.sleep(2000);
			try {

				Series.click();
				int count = 1;
				// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("seriesdiv"))));
				List<WebElement> series = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("series")));

				for (int i = 1; i <= series.size(); i++) {
					System.out.println(series.size());
					login.driver
							.findElement(
									By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]"))
							.click();
					Thread.sleep(2000);
				}

			} catch (StaleElementReferenceException e) {

				Series.click();
				int count = 1;
				// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("seriesdiv"))));
				List<WebElement> series = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("series")));

				for (int i = 1; i <= series.size(); i++) {
					System.out.println(series.size());
					login.driver
							.findElement(
									By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]"))
							.click();
					Thread.sleep(2000);
					count++;

				}

			}
		}
		if (arg1.equals("2015883202;202916302;29252150015;77161701")) {
			CommonFunctionality.getElementBycssSelector(login.driver, "label[title='View results as List']", 15)
					.click();
			CommonFunctionality.wait(2000);
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//*[@class='series-representation--sort']//*[@class='dropdown--button']", 15))
					.pause(500).click().build().perform();
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[text()='Unit']", 15))
					.pause(500).click().build().perform();
			CommonFunctionality.wait(3000);
			for (int i = list.size(); i >= 1; i--) {
				WebElement series_unselected = CommonFunctionality.getElementByXpath(login.driver,
						"(//span[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]", 15);
				WebElement series = CommonFunctionality.getElementByXpath(login.driver,
						"(//div[@class='series-item--name'])[" + i + "]", 15);
				if (!series_unselected.getAttribute("class").contains("series-list-item__selected")) {
					new Actions(login.driver).moveToElement(series).pause(3000).click().build().perform();
				}
			}
		}

		if (arg2.equalsIgnoreCase("A")) {
			Thread.sleep(2000);

			System.out.println("===========================>A");

//			 List<WebElement>checkbox=login.driver.findElements(By.xpath("//span[@class='series-list-item--checkbox svg-checkbox']"));
//			 for(int i=1;i<=checkbox.size();i++)
//			 {
//				 System.out.println(checkbox.size());
//				 login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])["+i+"]")).click();
//				 Thread.sleep(2000);
//			 }

			login.driver.findElement(By.xpath("//div[@class='add-to-data-selection--title']")).click();

			// action.sendKeys((Keys.chord("a"))).build().perform();
			System.out.println("click on A ");
		}
		if (arg2.equalsIgnoreCase("C")) {
			try {
				action.sendKeys((Keys.chord("c"))).build().perform();
			} catch (Exception e) {
				cv.click_on_more_actions_to_create("View as Chart");
			}

		}
		if (arg2.equalsIgnoreCase("Download")) {
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"(//span[@class='download-button--icon drop-down-button--icon'])[1]", 15))
					.pause(1000).click().build().perform();
		}
		if (arg2.equalsIgnoreCase("Heat map")) {
			cv.click_on_more_actions();
			new Actions(login.driver).moveToElement(
					CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'View as ...')]", 15))
					.build().perform();
			CommonFunctionality.wait(1000);
			new Actions(login.driver)
					.moveToElement(
							CommonFunctionality.getElementBycssSelector(login.driver, "span[title='" + arg2 + "']", 15))
					.pause(1000).click().build().perform();

		}
		if (arg2.equalsIgnoreCase("Pie")) {
			cv.click_on_more_actions();

			new Actions(login.driver).moveToElement(
					CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'View as ...')]", 15))
					.build().perform();
			CommonFunctionality.wait(1000);
			new Actions(login.driver)
					.moveToElement(
							CommonFunctionality.getElementBycssSelector(login.driver, "span[title='" + arg2 + "']", 15))
					.pause(1000).click().build().perform();
		}
	}
	
	@And("^Select all series from myseries$")
	public void select_all_series_from_myseries() throws Throwable {
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByProperty(login.driver, "Series_select_all", 10).click();
	}

	@And("^Click on \"([^\"]*)\" icon as function editor window$")
	public void click_on_icon_as_function_editor_window(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		CommonFunctionality
		.getElementByXpath(login.driver, "//div[@class='function-editor-window--icon']", 15)
		.click();
	}

	@SuppressWarnings("deprecation")
	@And("^Rename the Insight to \"([^\"]*)\" and click Download option from \"([^\"]*)\"$")
	public void rename_the_Insight_to_and_click_Download_option_from(String arg1, String arg2) throws Throwable {

		CommonFunctionality.wait(5000);
		CommonFunctionality.wait(5000);
		if (arg2.equalsIgnoreCase("Download Window")) {
			cv.click_button("Insert function");
			String function = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'ui-resizable ui-draggable')]//*[@class='series-function-item--body']", 15)
					.getText();
			applied_function_in_fx = function.replaceAll("\n", "");
			cv.click_button("Apply");

			// login.driver.findElement(By.xpath("//span[@class='input-control--indicator']")).click();

			new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
					"//span[@class='input-control--indicator']", 15)).pause(2000).click().build().perform();

			CommonFunctionality.wait(5000);

			CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(@class,'insight-breadcrumb--title__editable')]", 15)
					.click();
			WebElement name = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='insight-breadcrumb--title-input']", 15);
			// WebElement name =
			// CommonFunctionality.getElementByXpath(login.driver,"//*[@class='insight-breadcrumb--title
			// text-dots insight-breadcrumb--title__editable
			// insight-breadcrumb__is-explore']", 15);

			new Actions(login.driver).moveToElement(name).sendKeys(Keys.CONTROL, Keys.chord("a"))
					.sendKeys(Keys.BACK_SPACE).build().perform();
			new Actions(login.driver).moveToElement(name).pause(500).sendKeys("Crosssection" + arg1 + "").build()
					.perform();
			new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
					"div[title='Click to edit the Insight']", 10)).click().build().perform();
			renamed_insight_name = CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(@class,'insight-breadcrumb--title__editable')]", 10)
					.getText().toString();
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='page-main-header--buttons']//*[@class='download-button--text drop-down-button--label']",
					10).click();
			if (arg1.equals("11")) {
				new Actions(login.driver)
						.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
								"//input[@name='observations']/following-sibling::span/child::span[text()='All']", 15))
						.pause(500).click().build().perform();
			} else {
				Select_the_Start_Date_and_End_Date("2001-01-01", "2010-12-31");
			}

			/*
			 * //login.driver.findElement(By.
			 * xpath("//*[contains(text(),'Data Refresh')]/preceding-sibling::span")).click(
			 * );
			 * 
			 * Boolean resetbtn=
			 * login.driver.findElement(By.xpath("//button[text()='Reset']")).isEnabled();
			 * 
			 * if(resetbtn==true)
			 * 
			 * {
			 * 
			 * System.out.println("come to if condition"); CommonFunctionality.wait(2000);
			 * login.driver.findElement(By.xpath("//*[contains(text(),'Data Refresh')]")).
			 * click(); CommonFunctionality.wait(1000);
			 * CommonFunctionality.getElementByXpath(login.driver,
			 * "//*[@class='sphere-modal-controls']//*[contains(text(),'Download')]",
			 * 15).click();
			 * 
			 * 
			 * 
			 * CommonFunctionality.wait(10000);
			 * 
			 * 
			 * } else {
			 * 
			 * System.out.println("come to else condition");
			 * 
			 * login.driver.findElement(By.
			 * xpath("//*[contains(text(),'Data Refresh')]/preceding-sibling::span")).click(
			 * ); CommonFunctionality.getElementByXpath(login.driver,
			 * "//*[@class='sphere-modal-controls']//*[contains(text(),'Download')]",
			 * 15).click();
			 * 
			 * 
			 * 
			 * CommonFunctionality.wait(10000); }
			 */
			
			//chart.uncheck_the_checkbox_for_sections("Data Refresh");

			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='sphere-modal-controls']//*[contains(text(),'Download')]", 15).click();

			CommonFunctionality.wait(10000);

		}
		if (arg2.equalsIgnoreCase("My Series")) {
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//*[@name='select_all_dataselection']/following::span[1]", 15))
					.pause(2000).click().build().perform();
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(@class,'insight-breadcrumb--title__editable')]", 15)
					.click();
			WebElement name = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='insight-breadcrumb--title-input']", 15);
			new Actions(login.driver).moveToElement(name).sendKeys(Keys.CONTROL, Keys.chord("a"))
					.sendKeys(Keys.BACK_SPACE).build().perform();
			new Actions(login.driver).moveToElement(name).pause(500).sendKeys("Crosssection" + arg1 + "").build()
					.perform();
			new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
					"div[title='Click to edit the Insight']", 15)).click().build().perform();
			renamed_insight_name = CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(@class,'insight-breadcrumb--title__editable')]", 15)
					.getText().toString();
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='page-main-header--buttons']//*[@class='download-button--text drop-down-button--label']",
					10).click();

//			
//			boolean reset = login.driver
//					.findElement(By.xpath("//*[@class='sphere-modal-controls']//*[contains(text(),'Reset')]"))
//					.isEnabled();
//			if (reset == true) {
//				CommonFunctionality.getElementByXpath(login.driver,
//						"//*[@class='sphere-modal-controls']//*[contains(text(),'Reset')]", 15).click();
//			}
			Select_the_Start_Date_and_End_Date("2001-01-01", "2010-12-31");
			// chart.uncheck_the_checkbox_for_sections("Data Refresh");
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='sphere-modal-controls']//*[contains(text(),'Download')]", 15).click();
		}
		if (arg2.equalsIgnoreCase("Download Popup")) {
			cv.select_all_series_from_myseries_and_click_on_option("Copy the series");
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(@class,'insight-breadcrumb--title__editable')]", 15)
					.click();
			WebElement name = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='insight-breadcrumb--title-input']", 15);
			new Actions(login.driver).moveToElement(name).sendKeys(Keys.CONTROL, Keys.chord("a"))
					.sendKeys(Keys.BACK_SPACE).build().perform();
			new Actions(login.driver).moveToElement(name).pause(500).sendKeys("Crosssection" + arg1 + "").build()
					.perform();
			new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
					"div[title='Click to edit the Insight']", 15)).click().build().perform();
			renamed_insight_name = CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(@class,'insight-breadcrumb--title__editable')]", 10)
					.getText().toString();
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='page-main-header--buttons']//*[@class='download-button--text drop-down-button--label']",
					15).click();
//			boolean reset = login.driver
//					.findElement(By.xpath("//*[@class='sphere-modal-controls']//*[contains(text(),'Reset')]"))
//					.isEnabled();
//			if (reset == true) {
//				CommonFunctionality.getElementByXpath(login.driver,
//						"//*[@class='sphere-modal-controls']//*[contains(text(),'Reset')]", 15).click();
//			}
			Select_the_Start_Date_and_End_Date("2001-01-01", "2010-12-31");
			// chart.uncheck_the_checkbox_for_sections("Data Refresh");
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							" //*[@class='download-data-transformation']//*[@title='More functions']", 15))
					.pause(500).click().build().perform();
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//*[@class='popular-functions-context']//span[contains(text(),'All functions')]", 15))
					.pause(500).click().build().perform();
			click_tab_and_enter_in_search_field("By function", "CROSSSEC");
			cv.click_button("Insert function");
			cv.click_button("Apply");
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='sphere-modal-controls']//*[contains(text(),'Download')]", 15).click();
		}
		CommonFunctionality.wait(15000);
	}

	@SuppressWarnings("deprecation")
	@And("^Type \"([^\"]*)\" in functions input box$")
	public void type_in_functions_input_box(String arg1) throws Throwable {
		WebElement element;
		try {
			element = CommonFunctionality.getElementByXpath(login.driver,
					"//input[@class='current-function-input--field']", 15);
		} catch (Exception e) {
			element = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'movable-modal--window')]//input[@class='current-function-input--field']", 10);
		}
		if (arg1.equalsIgnoreCase("CROSSSEC")) {
			element.click();
			element.sendKeys("CROSS");
			CommonFunctionality.wait(500);
			element.sendKeys(Keys.ENTER);
			CommonFunctionality.wait(500);
			element.sendKeys(Keys.ENTER);
			CommonFunctionality.wait(500);
			element.sendKeys(Keys.ENTER);
			CommonFunctionality.wait(500);
			element.sendKeys(Keys.ENTER);
			CommonFunctionality.wait(2000);
		}
		if (arg1.equalsIgnoreCase("UNIT")) {
			element.click();
			element.sendKeys("UNIT");
			CommonFunctionality.wait(500);
			element.sendKeys(Keys.ENTER);
			CommonFunctionality.wait(500);
			element.sendKeys(Keys.ENTER);
			CommonFunctionality.wait(500);
			element.sendKeys(Keys.ENTER);
			CommonFunctionality.wait(2000);
		}
		if (arg1.equalsIgnoreCase("AGGREGATE")) {
			element.click();
			element.sendKeys("AGGREGATE");
			CommonFunctionality.wait(500);
			element.sendKeys(Keys.ENTER);
			CommonFunctionality.wait(500);
			element.sendKeys(Keys.ENTER);
			CommonFunctionality.wait(500);
			element.sendKeys(Keys.ENTER);
			CommonFunctionality.wait(500);
			element.sendKeys(Keys.ENTER);
			CommonFunctionality.wait(500);
			element.sendKeys(Keys.ENTER);
			CommonFunctionality.wait(500);
		//	new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
		//			".series-functions-panel--icon__apply", 15)).pause(200).click().build().perform();
			
			new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
					"//button[@type='button'][contains(text(),'Apply')]" , 15)).click().build().perform();
							
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Enter the function \"([^\"]*)\" with method \"([^\"]*)\" with extend to longest as \"([^\"]*)\" and ignore missed as \"([^\"]*)\"$")
	public void enter_the_function_with_method_with_extend_to_longest_as_and_ignore_missed_as(String arg1, String arg2,
			String arg3, String arg15) throws Throwable {

		WebElement element = CommonFunctionality.getElementByXpath(login.driver,
				"//input[@class='current-function-input--field']", 10);
		element.click();

		element.sendKeys(arg1);
		CommonFunctionality.wait(200);
		element.sendKeys(Keys.ENTER);
		CommonFunctionality.wait(200);
		element.sendKeys(arg2);
		CommonFunctionality.wait(200);
		element.sendKeys(Keys.ENTER);
		CommonFunctionality.wait(200);
		element.sendKeys(arg3);
		CommonFunctionality.wait(200);
		element.sendKeys(Keys.ENTER);
		CommonFunctionality.wait(200);
		element.sendKeys(arg15);
		CommonFunctionality.wait(200);
		element.sendKeys(Keys.ENTER);
		CommonFunctionality.wait(200);
		WebElement tick = CommonFunctionality.getElementBycssSelector(login.driver,
				".series-functions-panel--icon__apply", 15);
		new Actions(login.driver).moveToElement(tick).keyUp(Keys.CONTROL).pause(200).click().keyDown(Keys.CONTROL)
				.build().perform();
		CommonFunctionality.wait(3000);
	}

	public static void Select_the_Start_Date_and_End_Date(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Range')]")).click();
		login.driver.findElement(By.xpath("//input[@class='form--control input-date-start']")).click();
		login.driver.findElement(By.xpath("//input[@class='form--control input-date-start']")).clear();
		login.driver.findElement(By.xpath("//input[@class='form--control input-date-start']")).sendKeys(arg1);

		// login.driver.findElement(By.xpath("//input[@class='form--control
		// input-date-start']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		// login.driver.findElement(By.xpath("//input[@class='form--control
		// input-date-start']")).sendKeys(arg1);
		login.driver.findElement(By.xpath("//input[@class='form--control input-date-end']")).click();
		login.driver.findElement(By.xpath("//input[@class='form--control input-date-end']")).clear();
		// login.driver.findElement(By.xpath("//input[@class='form--control
		// input-date-end']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		login.driver.findElement(By.xpath("//input[@class='form--control input-date-end']")).sendKeys(arg2);
		login.driver.findElement(By.xpath("//input[@class='form--control input-date-end']")).sendKeys(Keys.ENTER);
	}

	@And("^Change the result count per page to (\\d+)$")
	public void change_the_result_count_per_page_to(int arg1) throws Throwable {
		cv.resetting_the_filters();
		CommonFunctionality.getElementBycssSelector(login.driver, "label[title='View results as List']", 15).click();
		Select result_count = new Select(
				CommonFunctionality.getElementByXpath(login.driver, "//*[@js-pre-page='']", 15));
		String value = Integer.toString(arg1);
		result_count.selectByValue(value);
	}

	@SuppressWarnings("deprecation")
	public static void renaming_insight(String arg1) throws Throwable {
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//*[@name='select_all_dataselection']/following::span[1]", 15))
				.pause(2000).click().build().perform();
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(@class,'insight-breadcrumb--title__editable')]", 15)
				.click();
		WebElement name = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='insight-breadcrumb--title-input']", 15);
		new Actions(login.driver).moveToElement(name).sendKeys(Keys.CONTROL, Keys.chord("a")).sendKeys(Keys.BACK_SPACE)
				.build().perform();
		new Actions(login.driver).moveToElement(name).pause(500).sendKeys("Crosssection" + arg1 + "").build().perform();
		new Actions(login.driver).moveToElement(
				CommonFunctionality.getElementBycssSelector(login.driver, "div[title='Click to edit the Insight']", 15))
				.click().build().perform();
		renamed_insight_name = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(@class,'insight-breadcrumb--title__editable')]", 15)
				.getText();
	}

	@And("^Click on \"([^\"]*)\" in frequency conversion popup$")
	public void click_on_in_frequency_conversion_popup(String arg1) throws Throwable {
		WebElement frequency = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'movable-modal--window')]//*[text()='Series Harmonization']", 15);
		if (frequency.isDisplayed()) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 15).click();
			login.Log4j.info("Frequency Conversion Popup is displayed");
		} else {
			fail("Frequency Conversion Popup is not displayed");
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Click \"([^\"]*)\" option from insight action panel$")
	public void click_option_from_insight_action_panel(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);

//		login.driver.findElement(By.xpath("//a[@data-id='myseries']")).click();
//		
//		
//		
//		Thread.sleep(2000);
//		WebElement mouseover=login.driver.findElement(By.xpath("//span[@class='series-name-field--series-name']"));
//	//	mouseover.
//		action.moveToElement(mouseover).pause(3000).contextClick().build().perform();
//		Thread.sleep(2000);
//		login.driver.findElement(By.xpath("//span[contains(text(),'View as ...')]")).click();
//		
//		Thread.sleep(2000);
//		login.driver.findElement(By.xpath("//span[contains(text(),'Pie')]")).click();

		CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'left-controls')]//button[text()='Edit Series']", 15).click();
		CommonFunctionality.wait(2000);
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
				"(//*[contains(@class,'insight-action-panel')]//div[@class='insight-action-panel--btn-icon'])[6]", 15))
				.pause(1000).click().build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Sort the series in left pane$")
	public void sort_the_series_in_left_pane() throws Throwable {

		Thread.sleep(5000);

		// div[@class='custom-select-title sort-select-title
		// sort-select-title__desc-hidden']//div[@class='custom-select-title--reset
		// icon--red-cross']

		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View results as List']", 10).click();

		try {

			CommonFunctionality.getElementByXpath(login.driver,
					"//div[@class='custom-select-title sort-select-title sort-select-title__desc-hidden']//div[@class='custom-select-title--reset icon--red-cross']",
					10).click();

			Thread.sleep(5000);

			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='series-representation--sort']//*[@class='dropdown--button']", 10).click();
			new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
					"(//div[@class='custom-select-item--link text-dots'])[4]", 10)).click().perform();
			CommonFunctionality.wait(1000);
		} catch (Exception e) {

			// CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View
			// results as List']", 10).click();
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='series-representation--sort']//*[@class='dropdown--button']", 10).click();
			new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
					"(//div[@class='custom-select-item--link text-dots'])[4]", 10)).click().perform();
			CommonFunctionality.wait(1000);

		}
	}

	@SuppressWarnings("deprecation")
	@And("^Sort the default series in left pane$")
	public void sort_the_default_series_in_left_pane() throws Throwable {
		Thread.sleep(2000);

		CommonFunctionality.getElementBycssSelector(login.driver, "div[title='View results as List']", 15).click();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='series-representation--sort']//*[@class='dropdown--button']", 15))
				.pause(500).click().build().perform();
		// new
		// Actions(login.driver).moveToElement(CommonFunctionality.getElementByClassName(login.driver,
		// "custom-select-title--reset-icon", 15)).pause(500).click().build().perform();
		CommonFunctionality.wait(1000);
	}

	@And("^Close the Growl popup$")
	public void close_the_Growl_popup() throws Throwable {
		if (login.driver.findElements(By.cssSelector(".growl-message.growl-message__wide.growl-warning")).size() > 0) {
			CommonFunctionality.getElementByClassName(login.driver, "growl-message-close", 15).click();
		}
	}

	@And("^Click \"([^\"]*)\" tab and enter \"([^\"]*)\" in search field$")
	public void click_tab_and_enter_in_search_field(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(5000);
	//	CommonFunctionality.getElementByXpath(login.driver, "//div[@title='Cross Section']", 20).click();

		CommonFunctionality.getElementByXpath(login.driver, "(//input[@placeholder='Search'])[3]", 15)
				.sendKeys(arg2);
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//span[@class='rBp4bp9QFdeCkIQxSLEE'][contains(text(),'" + arg2+ "')]", 15)
				.click();
	}

	@And("^Click \"([^\"]*)\" text and \"([^\"]*)\" the checkbox$")
	public void click_text_and_the_checkbox(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(5000);

		if (arg2.equalsIgnoreCase("Uncheck") && arg1.equalsIgnoreCase("Extend to longest")) {

			if (login.driver.findElement(By.xpath(
					"//*[@argument = 'extend_to_longest']//input[@type='checkbox']"))
					.isSelected()) {
				login.driver.findElement(By.xpath(
						"(//div[@class='function-data--description function-data--parameters']//*[@class='input-control--indicator'])[1]"))
						.click();

			} else {

				fail("Extend to longest unchecked:FAIL");

			}

		}

		else if (arg2.equalsIgnoreCase("Uncheck") && arg1.equalsIgnoreCase("Ignore missed")) {
			CommonFunctionality.wait(5000);
			if (login.driver.findElement(By.xpath(
					"//*[@argument = 'ignore_missed']//input[@type='checkbox']"))
					.isSelected()) {

				login.driver.findElement(By.xpath(
						"(//div[@class='function-data--description function-data--parameters']//*[@class='input-control--indicator'])[2]"))
						.click();

			} else {

				fail("Ignore missed unchecked:FAIL");

			}

		}

		if (arg2.equalsIgnoreCase("Check") && arg1.equalsIgnoreCase("Extend to longest")) {
			CommonFunctionality.wait(5000);
			if (login.driver.findElement(By.xpath(
					"//*[@argument = 'extend_to_longest']//input[@type='checkbox']"))
					.isSelected()) {

			} 
			
			else {

				login.driver.findElement(By.xpath(
						"(//div[@class='function-data--description function-data--parameters']//*[@class='input-control--indicator'])[1]"))
						.click();

			}

		}

		else if (arg2.equalsIgnoreCase("Check") && arg1.equalsIgnoreCase("Ignore missed")) {
			CommonFunctionality.wait(5000);
	/*		if (login.driver.findElement(By.xpath(
					"(//*[contains(text(),'Ignore missed')]//following::input[@class='input-control--input'])[1]"))
					.isSelected()) {

			}  */
			
			if(login.driver.findElement(By.xpath(
					"//*[@argument = 'ignore_missed']//input[@type='checkbox']")).isSelected())
			{
				
			}
			 else {

				login.driver.findElement(By.xpath(
						"(//div[@class='function-data--description function-data--parameters']//*[@class='input-control--indicator'])[2]"))
						.click();

			}
			{

			}

			if (arg1.equalsIgnoreCase("Replace selected series") && arg2.equalsIgnoreCase("Checked")) {
				CommonFunctionality.wait(5000);
				if (login.driver
						.findElement(
								By.xpath("//*[contains(text(),'Replace selected series')]//preceding-sibling::*"))
						.isSelected()) {

				} else {

					login.driver
							.findElement(By.xpath(
									"//div[@class='function-wizard--footer']//*[contains(text(),'Replace selected series')]"))
							.click();
				}

			}

			if (arg1.equalsIgnoreCase("Replace selected series") && arg2.equalsIgnoreCase("Unchecked")) {
				CommonFunctionality.wait(5000);

				if (login.driver
						.findElement(
								By.xpath("//*[contains(text(),'Replace selected series')]//preceding-sibling::*"))
						.isSelected()) {
					login.driver
							.findElement(By.xpath(
									"//div[@class='function-wizard--footer']//*[contains(text(),'Replace selected series')]"))
							.click();

				}
			}

		}
	}

	@SuppressWarnings("deprecation")
	@And("^Select all series from table in myseries and click on \"([^\"]*)\" option$")
	public void select_all_series_from_table_in_myseries_and_click_on_option(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='webix_hcell']//*[@js-select-item]", 15)).pause(500).click().build().perform();
		WebElement functions = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'" + arg1 + "')] | //*[contains(@title,'" + arg1 + "')]", 15);
		if (functions.isEnabled()) {
			js.executeScript("arguments[0].click();", functions);
		} else {
			fail("Not enabled");
		}
	}

	@And("^click on download button on chat visual$")
	public void click_on_download_button_on_chat_visual() throws Throwable {
		Thread.sleep(2000);

		Thread.sleep(2000);
		WebElement mouseover = login.driver.findElement(By.xpath("//span[@class='series-name-field--series-name']"));
//	mouseover.
		action.moveToElement(mouseover).pause(3000).contextClick().build().perform();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//span[contains(text(),'View as Chart')]")).click();

		// click on download button

		login.driver.findElement(By.xpath("(//span[@class='download-button--icon drop-down-button--icon'])[2]"))
				.click();

	}

	@SuppressWarnings("deprecation")
	@And("^Select \"([^\"]*)\" tab in download popup and click on \"([^\"]*)\" option and pass as \"([^\"]*)\"$")
	public void select_tab_in_download_popup_and_click_on_option_and_pass_as(String arg1, String arg2, String arg3)
			throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@data-tab='" + arg1 + "']", 15).click();
		String count = CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[contains(@class,'download-area-selector__description')]/following-sibling::span", 15)
				.getText();
		String number;
		if (count.contains("(")) {
			number = count.substring(1, 2);
		} else {
			number = count.substring(0, 2);
		}
		actual_series = Integer.parseInt(number);
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='download-data-transformation']//*[@class='insight-action-panel--btn' and @title='More functions']",
				15)).pause(500).click().build().perform();
		CommonFunctionality.wait(2000);
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='popular-functions-context']//span[contains(text(),'All functions')]", 15))
				.pause(500).click().build().perform();
		click_tab_and_enter_in_search_field("By function", arg3);
	}

	@And("^Select \"([^\"]*)\" as \"([^\"]*)\" in frequency popup$")
	public void select_as_in_frequency_popup(String arg1, String arg2) throws Throwable {
		WebElement frequency = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'movable-modal--window')]//*[text()='Series Harmonization']", 15);
		if (frequency.isDisplayed()) {
			Select value = new Select(
					CommonFunctionality.getElementByXpath(login.driver, "//*[@name='" + arg1 + "']", 15));
			value.selectByValue(arg2);
		} else {
			fail("Frequency popup is not displayed");
		}
	}

	@Then("^Enter the Testdata as \"([^\"]*)\"$")
	public void enter_the_Testdata_as(String arg1) throws Throwable {

		CommonFunctionality.wait(2000);
		System.out.println(renamed_insight_name);
		System.out.println("arg1:" + arg1);

		CommonFunctionality.Crosssection_Excelverify(login.driver, arg1, renamed_insight_name);

	}

	@SuppressWarnings("deprecation")
	@And("^Hovor on to first myseries name$")
	public void hovor_on_to_first_myseries_name() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement series = login.driver.findElement(By.xpath("(//*[@class='series-name-field--series-name'])[1]"));
		new Actions(login.driver).moveToElement(series).pause(2000).build().perform();
		String text = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'Series id')]/following-sibling::*", 15)
				.getText();
		if (text.contains("(")) {
			String split[] = text.split("\\(");
			functions_item_id = split[0];
			System.out.println("functions_item_id:" + functions_item_id);
		} else {
			functions_item_id = text;
			System.out.println("functions_item_id:" + functions_item_id);
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Hovor on to next myseries name$")
	public void hovor_on_to_next_myseries_name() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement series = login.driver.findElement(By.xpath("(//*[@class='series-name-field--series-name'])[2]"));
		new Actions(login.driver).moveToElement(series).pause(2000).build().perform();
		String text = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'Series id')]/following-sibling::*", 15)
				.getText();
		if (text.contains("(")) {
			String split[] = text.split("\\(");
			functions_item_id_next_series = split[0];
		} else {
			functions_item_id_next_series = text;
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Hovor on to last myseries name$")
	public void hovor_on_to_last_myseries_name() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement series = login.driver.findElement(By.xpath("(//*[@class='series-name-field--series-name'])[3]"));
		new Actions(login.driver).moveToElement(series).pause(2000).build().perform();
		String text = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'Series id')]/following-sibling::*", 15)
				.getText();
		if (text.contains("(")) {
			String split[] = text.split("\\(");
			functions_item_id_last_series = split[0];
		} else {
			functions_item_id_last_series = text;
		}
	}

	@SuppressWarnings("deprecation")
	public void hovor_on_to_first_visual_title() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement series = login.driver
				.findElement(By.xpath("(//*[contains(@class,'series-edit--title__editable')])[3]"));
		new Actions(login.driver).moveToElement(series).pause(2000).build().perform();
		String text = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'Series id')]/following-sibling::*", 15)
				.getText();
		if (text.contains("(")) {
			String split[] = text.split("\\(");
			functions_item_id = split[0];
		} else {
			functions_item_id = text;
		}
	}

	@SuppressWarnings("deprecation")
	public void hovor_on_to_next_visual_title() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement series = login.driver
				.findElement(By.xpath("(//*[contains(@class,'series-edit--title__editable')])[2]"));
		new Actions(login.driver).moveToElement(series).pause(2000).build().perform();
		String text = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'Series id')]/following-sibling::*", 15)
				.getText();
		if (text.contains("(")) {
			String split[] = text.split("\\(");
			functions_item_id_next_series = split[0];
		} else {
			functions_item_id_next_series = text;
		}
	}

	@And("^Select \"([^\"]*)\" method from dropdown$")
	public void select_method_from_dropdown(String arg1) throws Throwable {

		CommonFunctionality.wait(4000);

		method_name = arg1;
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='select2-choice']", 15).click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='select2-results']//*[contains(text(),'" + method_name + "')]", 15).click();
		// WebElement open =
		// CommonFunctionality.getElementByXpath(login.driver,"//*[@id='s2id_autogen11']",
		// 15);
		/*
		 * 
		 * if (open.getAttribute("class").contains("select2-dropdown-open") &&
		 * arg1.equalsIgnoreCase("Sum")) {
		 * CommonFunctionality.getElementByXpath(login.driver,
		 * "(//*[@class='select2-search']/following-sibling::ul[@class='select2-results'])[2]//li[1]",
		 * 15) .click(); }
		 * 
		 * else if (open.getAttribute("class").contains("select2-dropdown-open") &&
		 * arg1.equalsIgnoreCase("Median")) {
		 * CommonFunctionality.getElementByXpath(login.driver,
		 * "(//*[@class='select2-search']/following-sibling::ul[@class='select2-results'])[2]//li[2]",
		 * 15) .click(); } else if
		 * (open.getAttribute("class").contains("select2-dropdown-open") &&
		 * arg1.equalsIgnoreCase("Avg")) {
		 * CommonFunctionality.getElementByXpath(login.driver,
		 * "(//*[@class='select2-search']/following-sibling::ul[@class='select2-results'])[2]//li[3]",
		 * 15) .click(); }
		 * 
		 * else if (open.getAttribute("class").contains("select2-dropdown-open") &&
		 * arg1.equalsIgnoreCase("Product")) {
		 * CommonFunctionality.getElementByXpath(login.driver,
		 * "(//*[@class='select2-search']/following-sibling::ul[@class='select2-results'])[2]//li[4]",
		 * 15) .click(); } {
		 * 
		 * 
		 * 
		 * }
		 */

	}

	@Then("^The \"([^\"]*)\" method is default and series should be applied with crosssec func with first series name as output$")
	public void the_method_is_default_and_series_should_be_applied_with_crosssec_func_with_first_series_name_as_output(
			String arg1) throws Throwable {
		WebElement sum = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'Method')]//following::*[contains(text(),'" + arg1 + "')][1]", 15);
		if (sum.isDisplayed()) {
			cv.click_button("Insert function");
			String function = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'ui-resizable ui-draggable')]//*[@class='series-function-item--body']", 15)
					.getText();
			System.out.println("====Cross==="+function);
			applied_function_in_fx = function.replaceAll("\n", "");
			System.out.println("====Applied func==="+applied_function_in_fx);
			cv.click_button("Apply");
			hovor_on_to_first_myseries_name();

			Actions actionProvider = new Actions(login.driver);
			WebElement icon = login.driver.findElement(By.xpath("(//div[@class='series-name-wrapper '])[1]"));
			// Performs mouse move action onto the element
			actionProvider.moveToElement(icon).build().perform();
			Thread.sleep(2000);

			// new
			// Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
			// "//span[@title='Customize your selection']", 15)).perform();
			hovor_on_to_last_myseries_name();
					
		//	WebElement icon1 = login.driver.findElement(By.xpath("(//div[@class='series-name-wrapper '])[2]"));
			actionProvider.moveToElement(icon).build().perform();
			Thread.sleep(2000);
			// new
			// Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
			// "//span[@title='Customize your selection']", 15)).perform();
			String expected = CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='series-functions-title']", 15).getText();
			System.out.println("===expecteddd=="+expected);
			
			String substring = expected.substring(1,expected.length()-1);
			System.out.println("=====Substring val======="+substring);
		//	if (expected.contains(applied_function_in_fx)) {
			System.out.println("===expected1==="+substring.contains(applied_function_in_fx));
			
			if (substring.contains(applied_function_in_fx)) {
				login.Log4j.info("The applied function is present and has been verified successfully");
			} else {
				fail("Verification Failed");
			}
			String[] part = expected.split("(?<=\\D)(?=\\d)");
			String first[] = part[1].split("\\+");
			String second[] = part[2].split("\\)");
			assertEquals(functions_item_id, first[0]);
			assertEquals(functions_item_id_last_series, second[0]);
		} else {
			fail(arg1 + " method is not default");
		}
		Deleting_series();
	}

	@SuppressWarnings("deprecation")
	@And("^The output series has to be present inbetween the base series$")
	public void the_output_series_has_to_be_present_inbetween_the_base_series() throws Throwable {
		hovor_on_to_first_myseries_name();

		WebElement icon = login.driver.findElement(By.xpath("(//span[@class='table-container--checkbox svg-checkbox input-control__grey'])[2]"));
		action.moveToElement(icon).build().perform();
		Thread.sleep(2000);
		
		// new
		// Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
		// "div[title='More']", 15)).perform();
		hovor_on_to_last_myseries_name();

	//	WebElement icon1 = login.driver.findElement(By.xpath("(//div[@class='series-name-wrapper '])[2]"));
		action.moveToElement(icon).build().perform();
		Thread.sleep(2000);

		// new
		// Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
		// "div[title='More']", 15)).perform();
		String expected = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='series-functions-title']", 15).getText();
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
				"(//*[@class='series-name-field--series-name'])[2]", 15)).pause(500).build().perform();
		String tooltip_functions = CommonFunctionality
				.getElementByXpath(login.driver, "(//*[@class='ZWIWBTEmdUe4e_gnuHOw nfnBRpaJ0CSBYW8UqGWU'])[3]", 15)
				.getText();
		String substring = expected.substring(1, expected.length() - 1);
		assertEquals(tooltip_functions, substring);
		if (expected.contains(applied_function_in_fx)) {
			login.Log4j.info("The applied function is present and has been verified successfully");
		} else {
			fail("Verification Failed");
		}
		String[] part = expected.split("(?<=\\D)(?=\\d)");
		String first[] = part[1].split("\\+");
		String second[] = part[2].split("\\)");
		assertEquals(functions_item_id, first[0]);
		assertEquals(functions_item_id_last_series, second[0]);
		Deleting_series();
	}

	@SuppressWarnings("deprecation")
	@Then("^The output series has to be present inbetween the base series and the \"([^\"]*)\" method is selected$")
	public void the_output_series_has_to_be_present_inbetween_the_base_series_and_the_method_is_selected(String arg1)
			throws Throwable {
		if (arg1.equalsIgnoreCase("List")) {
			cv.click_button("Insert function");
			String function = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'ui-resizable ui-draggable')]//*[@class='series-function-item--body']", 15)
					.getText();
			applied_function_in_fx = function.replaceAll("\n", "");
			cv.click_button("Apply");
			CommonFunctionality.wait(2000);
			WebElement list = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='series-tab--text' and text()='" + arg1 + "']/parent::span", 15);
			if (list.getAttribute("class").contains("active")) {

				hovor_on_to_first_myseries_name();
				WebElement icon = login.driver.findElement(By.xpath("(//div[@class='series-name-wrapper '])[1]"));
				action.moveToElement(icon).build().perform();
				Thread.sleep(2000);

				// new
				// Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
				// "div[title='More']", 15)).perform();
				hovor_on_to_last_myseries_name();

				// Performs mouse move action onto the element
				action.moveToElement(icon).build().perform();
				Thread.sleep(2000);
				// new
				// Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
				// "div[title='More']", 15)).perform();
				String expected = CommonFunctionality
						.getElementByXpath(login.driver, "//*[@class='series-functions-title']", 15).getText();
				System.out.println("Expected:" + expected);
				new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"(//*[@class='series-name-field--series-name'])[2]", 15)).pause(500).build().perform();
				String tooltip_functions = CommonFunctionality
						.getElementByXpath(login.driver, "//*[contains(text(),'Functions')]/following-sibling::*", 15)
						.getText();

				System.out.println("tooltip_functions:" + tooltip_functions);

				// assertEquals(expected, tooltip_functions);
				if (expected.contains(applied_function_in_fx)) {
					login.Log4j.info("The applied function is present and has been verified successfully and " + arg1
							+ " is active");
				} else {
					fail("Verification Failed");
				}
				String[] part = expected.split("(?<=\\D)(?=\\d)");
				String first[] = part[1].split("\\+");
				String second[] = part[2].split("\\)");
				assertEquals(functions_item_id, first[0]);
				assertEquals(functions_item_id_last_series, second[0]);
				Deleting_series();
			} else {
				fail(arg1 + " is not active");
			}
		}
		if (arg1.equalsIgnoreCase("Table")) {
			cv.click_button("Insert function");
			String function = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'ui-resizable ui-draggable')]//*[@class='series-function-item--body']", 15)
					.getText();
			applied_function_in_fx = function.replaceAll("\n", "");
			cv.click_button("Apply");
			CommonFunctionality.wait(2000);
			WebElement table = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='series-tab--text' and text()='" + arg1 + "']/parent::span", 15);
			if (table.getAttribute("class").contains("active")) {
				hovor_on_to_first_myseries_name();
				WebElement icon = login.driver.findElement(By.xpath("(//div[@class='series-name-wrapper '])[1]"));
				// Performs mouse move action onto the element
				action.moveToElement(icon).build().perform();
				Thread.sleep(2000);

				// new
				// Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
				// "div[title='More']", 15)).perform();
				hovor_on_to_last_myseries_name();
				// new
				// Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
				// "div[title='More']", 15)).perform();
				action.moveToElement(icon).build().perform();
				Thread.sleep(2000);

				String expected = CommonFunctionality.getElementByXpath(login.driver,
						"(//div[@class='webix_cell webix_row_select new-series-item'])[2]", 15).getText();
				System.out.println("Expected series:" + expected);

				new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"(//*[@class='series-name-field--series-name'])[2]", 15)).pause(500).build().perform();
				String tooltip_functions = CommonFunctionality
						.getElementByXpath(login.driver, "//*[contains(text(),'Functions')]/following-sibling::*", 15)
						.getText();
				System.out.println("Expected tool function:" + tooltip_functions);

				// String substring = expected.substring(1, expected.length()-1);
				// System.out.println("Sub String"+substring);

				assertEquals(tooltip_functions, expected);

				if (expected.contains(applied_function_in_fx)) {
					login.Log4j.info("The applied function is present and has been verified successfully and " + arg1
							+ " is active");
				} else {
					fail("Verification Failed");
				}
				String[] part = expected.split("(?<=\\D)(?=\\d)");
				String first[] = part[1].split("\\+");
				String second[] = part[2].split("\\)");
				assertEquals(functions_item_id, first[0]);
				assertEquals(functions_item_id_last_series, second[0]);
			} else {
				fail(arg1 + " is not active");
			}
			list_option_should_select();
			Deleting_series();
		}
	}

	@SuppressWarnings("deprecation")
	@Then("^The output series has to be present inbetween the base series and should be able to move up or down$")
	public void the_output_series_has_to_be_present_inbetween_the_base_series_and_should_be_able_to_move_up_or_down()
			throws Throwable {

		cv.click_button("Insert function");
		cv.click_button("Apply");

		if (!(login.driver.findElements(By.xpath(
				"(//*[@class='series-name-field--series-name'])[2]/following-sibling::*[@class='series-functions-title']"))
				.size() == 1)) {
			fail("Verification Failed");
		}
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[@data-action='move_up']", 15))
				.pause(500).click().build().perform();
		if (login.driver.findElements(By.xpath(
				"(//*[@class='series-name-field--series-name'])[2]/following-sibling::*[@class='series-functions-title']"))
				.size() == 0) {
			login.Log4j.info("The output series is possible to move up/down and it has been verified successfully");
		} else {
			fail("Verification Failed");
		}
		CommonFunctionality.DeleteSeries();
	}

	@Then("^The \"([^\"]*)\" message should display$")
	public void the_message_should_display(String arg1) throws Throwable {
		cv.click_button("Insert function");
		cv.click_button("Apply");
		String expected = null;
		if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal__body')]")).size() == 1) {
			expected = CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(@class,'sphere-modal__body')]", 15).getText();
			login.Log4j.info("The validation message popup is displayed");
		} else {
			fail("Verification Failed");
		}
		String text[] = expected.split("\n");
		String actual = text[0].substring(0, text[0].length() - 1);
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 15).click();
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 15).click();
		Deleting_series();
		assertEquals(actual, arg1);
		login.Log4j.info("The message has been validated for single series");
	}

	@And("^List option should select$")
	public void list_option_should_select() throws Throwable {
	//	boolean list = login.driver.findElement(By.cssSelector("span[title='View as List']")).isEnabled();
		
		boolean list = login.driver.findElement(By.xpath("//button[@title='List mode']")).isEnabled();
		if (list == true) {
			new Actions(login.driver)
					.moveToElement(
							CommonFunctionality.getElementByXpath(login.driver, "//button[@title='List mode']", 15)).click().build().perform();
						}
	}

	@Then("^Clicking on sort by options$")
	public void clicking_on_sort_by_options() throws Throwable {
		cv.click_button("Insert function");
		cv.click_button("Apply");

		WebElement sort = login.driver.findElement(By.xpath("//div[@class='series-panel--right']"));
		action.moveToElement(sort).build().perform();

		// WebElement sort = CommonFunctionality.getElementByClassName(login.driver,
		// "sort-series", 15);
		// sort.click();
		List<WebElement> sort_all = login.driver
				.findElements(By.xpath("//div[@class='custom-select-item--link text-dots']"));
		for (int i = 1; i <= sort_all.size(); i++) {
			if (i == 1) {
				CommonFunctionality
						.getElementByXpath(login.driver, "//div[@class='custom-select--body']//div[" + i + "]", 15)
						.click();
				CommonFunctionality.wait(2000);
			} else {
				action.moveToElement(sort).build().perform();
				// sort.click();
				CommonFunctionality
						.getElementByXpath(login.driver, "//div[@class='custom-select--body']//div[" + i + "]", 15)
						.click();
			}
		}
		CommonFunctionality.DeleteSeries();
	}

	@SuppressWarnings("deprecation")
	@Then("^The base series has not been replaced with output series$")
	public void the_base_series_has_not_been_replaced_with_output_series() throws Throwable {
		CommonFunctionality.wait(5000);
		WebElement tick = CommonFunctionality.getElementBycssSelector(login.driver,
				".series-functions-panel--icon__apply", 15);
		new Actions(login.driver).moveToElement(tick).keyUp(Keys.CONTROL).pause(200).click().keyDown(Keys.CONTROL)
				.build().perform();
		String function = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='series-function-item--body']", 15).getText();
		applied_function_in_fx = function.replaceAll("\n", "");
		System.out.println("applied_function_in_fx:" + applied_function_in_fx);
		hovor_on_to_first_myseries_name();

		WebElement mouse = login.driver.findElement(By.xpath("//input[@class='current-function-input--field']"));
		action.moveToElement(mouse).build().perform();

		// new
		// Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
		// "div[title='More']", 15)).perform();
		hovor_on_to_next_myseries_name();
		// new
		// Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
		// "div[title='More']", 15)).perform();
		String expected = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='series-functions-title']", 15).getText();
		System.out.println("expected:" + expected);
		if (expected.contains(applied_function_in_fx)) {
			login.Log4j.info("The applied function is present and has been verified successfully");
		} else {
			fail("Verification Failed");
		}
		String[] part = expected.split("(?<=\\D)(?=\\d)");
		String first[] = part[1].split("\\+");
		String second[] = part[2].split("\\)");
		System.out.println("functions_item_id:------------->" + functions_item_id);
		System.out.println("first[0]:------------->" + first[0]);

		System.out.println("functions_item_id_next_series:------------->" + functions_item_id_next_series);
		System.out.println("second[0]:------------->" + second[0]);

		assertEquals(functions_item_id, first[0]);
		// assertEquals(functions_item_id_next_series, second[0]);
		List<WebElement> myseries_after = login.driver.findElements(By.className("series-name-field--series-name"));
		int count = myseries_after.size();
		assertNotEquals(ChartVisual.myseries_before, count);
		login.Log4j.info("The output series has been replaced the base series and has been verified successfully");

		rename_the_Insight_to_and_click_Download_option_from("08", "My Series");
		Deleting_series();
		enter_the_Testdata_as("TC_Crosssection_08");
	}

	@Then("^The Crosssec functions can validate through functions wizard$")
	public void the_Crosssec_functions_can_validate_through_functions_wizard() throws Throwable {
		rename_the_Insight_to_and_click_Download_option_from("09", "Download Popup");
		Deleting_series();
		enter_the_Testdata_as("TC_Crosssection_09");
	}

	@SuppressWarnings("deprecation")
	@Then("^The Crosssec functions for \"([^\"]*)\" can validate and rename as \"([^\"]*)\" and verify the testdata as \"([^\"]*)\"$")
	public void the_Crosssec_functions_for_can_validate_and_verify_the_testdata_as(String arg1, String arg2,
			String arg3) throws Throwable {
		cv.click_button("Insert function");
		String functions_title = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'movable-modal--window')]//*[@class='series-function-item--arguments-list']", 15)
				.getAttribute("title");
		cv.click_button("Apply");
		if (arg2.equals("17") || arg2.equals("22")) {
			count_the_total_series();
		}
		hovor_on_to_first_myseries_name();

		WebElement icon = login.driver.findElement(By.xpath("//span[@class='series-name-field-title']"));
		action.moveToElement(icon).build().perform();
		Thread.sleep(2000);

		// new
		// Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
		// "div[title='More']", 15)).perform();
		hovor_on_to_next_myseries_name();
		action.moveToElement(icon).build().perform();
		Thread.sleep(2000);
		// new
		// Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
		// "div[title='More']", 15)).perform();

		String function = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='series-function-item--body']", 15).getText();
		String title[] = functions_title.split("\n");
		String method_title[] = title[1].split("Method: ");
		assertEquals(arg1, method_title[1]);
		String part_title[] = title[2].split("Extend to longest: ");
		String actual = part_title[1].substring(0, 3);
		String expect[] = title[3].split("Ignore missed: ");
		assertEquals(actual, "Yes");
		assertEquals(expect[1], "Yes");
		System.out.println(functions_checkbox);

		// assertEquals(functions_checkbox, true);
		login.Log4j.info("The crosssec fuctions has been validated");
		applied_function_in_fx = function.replaceAll("\n", "");
		String expected = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='series-functions-title']", 15).getText();
		if (expected.contains(applied_function_in_fx)) {
			login.Log4j.info("The applied function is present and has been verified successfully");
		} else {
			fail("Verification Failed");
		}
		String[] part = expected.split("(?<=\\D)(?=\\d)");
		String first[] = part[1].split("\\+");
		String second[] = part[2].split("\\)");
		assertEquals(functions_item_id, first[0]);
		assertEquals(functions_item_id_last_series, second[0]);
		renaming_insight(arg2);
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='download-button--text drop-down-button--label']", 15)
				.click();

		if (arg2.equals("10")) {
			Select_the_Start_Date_and_End_Date("2001-01-01", "2010-12-31");
		} else {
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//input[@name='observations']/following-sibling::span/child::span[text()='All']", 15))
					.pause(500).click().build().perform();
		}

		// chart.uncheck_the_checkbox_for_sections("Data Refresh");
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='sphere-modal-controls']//*[contains(text(),'Download')]", 15).click();
		CommonFunctionality.wait(2000);
		Deleting_series();
		enter_the_Testdata_as(arg3);
	}

	@Then("^The \"([^\"]*)\" button is clicked and the functions wizard is closed$")
	public void the_button_is_clicked_and_the_functions_wizard_is_closed(String arg1) throws Throwable {
		cv.click_button("Insert function");
		boolean enable = login.driver.findElement(By.xpath("//*[text()='" + arg1 + "']")).isEnabled();
		if (enable == true) {
			login.driver.findElement(By.xpath("//*[text()='" + arg1 + "']")).click();
			if (login.driver.findElements(By.cssSelector(".movable-modal--window.ui-resizable.ui-draggable"))
					.size() == 0) {
				login.Log4j.info("The " + arg1
						+ " button is clicked and functions wizard is closed which has been verified successfully");
			} else {
				fail("Modal window is not closed");
			}
		} else {
			fail(arg1 + " button is not enabled");
		}
		Deleting_series();
	}

	@And("^Check for popup$")
	public void check_for_popup() throws Throwable {
		if (login.driver
				.findElements(
						By.xpath("//*[@class='movable-modal--window']//*[text()='Do you want to keep your insight?']"))
				.size() > 0) {
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='movable-modal--window']//*[text()='Start new']", 15)
					.click();
			System.out.println("Start new option is selected in unsaved insight work pop-up display");
		}
	}

	@SuppressWarnings("deprecation")
	@Then("^The \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" methods should present$")
	public void the_methods_should_present(String arg1, String arg2, String arg3, String arg15) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[contains(@class,'function-parameter--select')]", 15)
				.click();
		List<WebElement> methods = login.driver.findElements(
				By.xpath("(//*[@class='select2-search']/following-sibling::ul[@class='select2-results'])[2]//li//div"));
		for (WebElement method : methods) {
			String text = method.getText();
			if (!(text.equals(arg1) || text.equals(arg2) || text.equals(arg3) || text.equals(arg15))) {
				CommonFunctionality.Hidden_Webelements_handling(login.driver, "className", "movable-modal--close");
				fail("Verification Failed");
			}
			login.Log4j.info(text + " method is present");
		}
		try {
			CommonFunctionality.wait(2000);
			new Actions(login.driver).pause(500)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//div[contains(@class,'function-parameter--select')]", 15))
					.pause(500).click().build().perform();
		} catch (Exception e) {
			CommonFunctionality.getElementByXpath(login.driver,
					"(//*[@class='select2-search']/following-sibling::ul[@class='select2-results'])[2]//li[1]", 15)
					.click();
		}
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "className", "movable-modal--close");
		Deleting_series();
	}

	@SuppressWarnings("deprecation")
	@Then("^The Output series must get replaced with first \"([^\"]*)\" base series$")
	public void the_output_series_must_get_replaced_with_first_selected_base_series(String arg1) throws Throwable {

		cv.click_button("Insert function");
		String functions_title = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'movable-modal--window')]//*[@class='series-function-item--arguments-list']", 15)
				.getAttribute("title");
		String function = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='series-function-item--body']", 15).getText();
		applied_function_in_fx = function.replaceAll("\n", "");
		cv.click_button("Apply");
		hovor_on_to_first_myseries_name();

		WebElement icon = login.driver.findElement(By.xpath("(//div[@class='series-name-wrapper '])[1]"));
		action.moveToElement(icon).build().perform();
		Thread.sleep(2000);

		// new
		// Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
		// "div[title='More']", 15)).perform();
		hovor_on_to_last_myseries_name();
		// --------------->
//		CommonFunctionality.wait(2000);
//		WebElement series = login.driver.findElement(By.xpath("(//*[@class='series-name-field--series-name'])[2]"));
//		new Actions(login.driver).moveToElement(series).pause(2000).build().perform();
//		String text = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Series id')]/following-sibling::*", 15).getText();
//		
//		if (text.contains("(")) {
//			String split[] = text.split("\\(");
//			functions_item_id_last_series = split[0];
//		} else {
//			functions_item_id_last_series = text;
//		action.moveToElement(icon).build().perform();
//		Thread.sleep(2000);

		// new
		// Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
		// "div[title='More']", 15)).perform();
		String expected = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='series-functions-title']", 15).getText();
		if (expected.contains(applied_function_in_fx)) {
			login.Log4j.info("The applied function is present and has been verified successfully");
		} else {
			fail("Verification Failed");
		}
		System.out.println("expected:" + expected);
		String[] part = expected.split("(?<=\\D)(?=\\d)");
		String first[] = part[1].split("\\+");
		String second[] = part[2].split("\\)");

		System.out.println(first[0]);
		System.out.println(functions_item_id);

		System.out.println(second[0]);
		System.out.println(functions_item_id_last_series);

		assertEquals(functions_item_id, first[0]);
		assertEquals(functions_item_id_last_series, second[0]);
		List<WebElement> myseries_after = login.driver.findElements(By.className("series-name-field--series-name"));
		int count = myseries_after.size();
		System.out.println("============>" + ChartVisual.myseries_before);
		System.out.println("============>" + count);

		// assertNotEquals(ChartVisual.myseries_before, count);
		System.out.println("PASS");

		assertEquals(replace_checkbox, false);
		System.out.println("PASS");
		if (arg1.equalsIgnoreCase("")) {

			assertEquals(replace_checkbox, true);
			assertEquals(functions_checkbox, true);
			System.out.println("PASS");
		}
		if (arg1.equalsIgnoreCase("Uncheck Longest")) {
			String title[] = functions_title.split("\n");
			String part1[] = title[2].split("Extend to longest: ");
			String actual = part1[1].substring(0, 2);
			assertEquals(actual, "No");
			assertEquals(functions_checkbox, false);
			System.out.println("PASS");
		}
		if (arg1.equalsIgnoreCase("Ignore missed Uncheck")) {
			String title[] = functions_title.split("\n");
			String expected3[] = title[1].split("Method: ");
			String expected2[] = title[2].split("Extend to longest: ");
			String expected1[] = title[3].split("Ignore missed: ");
			assertEquals(expected3[1], "Sum");
			assertEquals(expected2[1], "Yes");
			assertEquals(expected1[1], "No");
			assertEquals(replace_checkbox, false);
			renaming_insight("20");
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='page-main-header--buttons']//*[@class='drop-down-button download-button download-button__header drop-down-button__small']",
					15).click();
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//input[@name='observations']/following-sibling::span/child::span[text()='All']", 15))
					.pause(500).click().build().perform();
			Select_the_Start_Date_and_End_Date("2001-01-01", "2010-12-31");
			chart.uncheck_the_checkbox_for_sections("Data Refresh");
			CommonFunctionality.wait(1000);
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='sphere-modal-controls']//*[contains(text(),'Download')]", 15).click();
			CommonFunctionality.wait(2000);
			Deleting_series();
			enter_the_Testdata_as("TC_Crosssection_20");
		}
		if (arg1.equalsIgnoreCase("Both Uncheck")) {
			String title[] = functions_title.split("\n");
			String expected3[] = title[1].split("Method: ");
			String expected2[] = title[2].split("Extend to longest: ");
			String expected1[] = title[3].split("Ignore missed: ");
			assertEquals(expected3[1], "Sum");
			assertEquals(expected2[1], "No");
			assertEquals(expected1[1], "No");
			assertEquals(functions_checkbox, false);
			assertEquals(replace_checkbox, false);
			renaming_insight("21");
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='download-button--text drop-down-button--label']", 15)
					.click();
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//input[@name='observations']/following-sibling::span/child::span[text()='All']", 15))
					.pause(500).click().build().perform();
			Select_the_Start_Date_and_End_Date("2001-01-01", "2010-12-31");
			chart.uncheck_the_checkbox_for_sections("Data Refresh");
			CommonFunctionality.wait(1000);
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='sphere-modal-controls']//*[contains(text(),'Download')]", 15).click();
			CommonFunctionality.wait(2000);
			Deleting_series();
			enter_the_Testdata_as("TC_Crosssection_21");
		}
		login.Log4j
				.info("The output series has been replaced the first base series and has been verified successfully");
		Deleting_series();
	}

	@Then("^The Output series should not replace any series$")
	public void the_output_series_should_not_replace_any_series() throws Throwable {
		click_text_and_the_checkbox("Extend to longest", "Check");
		click_text_and_the_checkbox("Ignore missed", "Check");
		cv.click_button("Insert function");
		String functions_title = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'movable-modal--window')]//*[@class='series-function-item--arguments-list']", 15)
				.getAttribute("title");
		cv.click_button("Apply");
		hovor_on_to_first_myseries_name();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, "div[title='More']", 15))
				.perform();
		hovor_on_to_last_myseries_name();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, "div[title='More']", 15))
				.perform();
		String function = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='series-function-item--body']", 15).getText();
		String title[] = functions_title.split("\n");
		String part_title[] = title[2].split("Extend to longest: ");
		String actual = part_title[1].substring(0, 3);
		String expect[] = title[3].split("Ignore missed: ");
		assertEquals(actual, "Yes");
		assertEquals(expect[1], "Yes");
		assertEquals(functions_checkbox, true);
		login.Log4j.info("The crosssec fuctions has been validated");
		applied_function_in_fx = function.replaceAll("\n", "");
		String expected = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='series-functions-title']", 15).getText();
		if (expected.contains(applied_function_in_fx)) {
			login.Log4j.info("The applied function is present and has been verified successfully");
		} else {
			fail("Verification Failed");
		}
		String[] part = expected.split("(?<=\\D)(?=\\d)");
		String first[] = part[1].split("\\+");
		String second[] = part[2].split("\\)");
		assertEquals(functions_item_id, first[0]);
		assertEquals(functions_item_id_last_series, second[0]);
		renaming_insight("10");
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[@class='page-main-header--buttons']//*[contains(@class,'small-download-btn')]", 15)
				.click();
		boolean reset = login.driver
				.findElement(By.xpath("//*[@class='sphere-modal-controls']//*[contains(text(),'Reset')]")).isEnabled();
		if (reset == true) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='sphere-modal-controls']//*[contains(text(),'Reset')]", 15).click();
		}
		Select_the_Start_Date_and_End_Date("2001-01-01", "2010-12-31");
		// chart.uncheck_the_checkbox_for_sections("Data Refresh");
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='sphere-modal-controls']//*[contains(text(),'Download')]", 15).click();
		CommonFunctionality.wait(2000);
		Deleting_series();
		enter_the_Testdata_as("TC_Crosssection_10");
	}

	@Then("^The Series should be of same \"([^\"]*)\" Validation message should appear$")
	public void the_Series_should_be_of_same_Validation_message_should_appear(String arg1) throws Throwable {

		cv.click_button("Insert function");
		cv.click_button("Apply");
		System.out.println("click on apply");
		if (login.driver.findElements(By.xpath(
				"//div[@class='modal-body sphere-modal__body' and contains(text(),'This function can only be applied over a selection of multiple series.')]"))
				.size() > 0) {
			String expected = CommonFunctionality
					.getElementBycssSelector(login.driver, ".modal-body.sphere-modal__body", 15).getText();
			String[] part = expected.split("same ");
			System.out.println(part[0]);
			String[] part1 = part[0].split("\n");

			login.Log4j.info("The Validation message appears for different " + arg1 + " series");
			System.out.println("==============>click on apply====================>");

			if (arg1.equalsIgnoreCase("frequency & unit")) {
				System.out.println(arg1);
				System.out.println(part1[0]);
				if (arg1.contains(part1[0])) {
					System.out.println("Frequency & unit appears");
				}
			} else {
				assertEquals(arg1, part1[0]);
			}
		} else {
			fail("Verification Failed");
		}
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 15).click();
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 15).click();
		if (arg1.equalsIgnoreCase("frequency & unit")) {
			CommonFunctionality.DeleteVisual();
		} else {
			Deleting_series();
		}
	}

	@Then("^The Series should be of Same \"([^\"]*)\" validation message appear$")
	public void the_Series_should_be_of_Same_validation_message_appear(String arg1) throws Throwable {
		cv.click_button("Insert function");
		cv.click_button("Apply");
		if (login.driver.findElements(By.xpath("//*[text()='The function cannot be applied to selected series']"))
				.size() > 0) {
			String expected = CommonFunctionality
					.getElementBycssSelector(login.driver, ".modal-body.sphere-modal__body", 15).getText();
			String[] part = expected.split("same ");
			String[] part1 = part[1].split("\n");
			login.Log4j.info("The Validation message appears for different " + arg1 + " series");
			assertEquals(arg1, part1[0]);
		} else {
			fail("Verification Failed");
		}
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 15).click();
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 15).click();
		CommonFunctionality.Views_list();
	}

	@SuppressWarnings("deprecation")
	@Then("^The Function should apply successfully in \"([^\"]*)\"$")
	public void the_Function_should_apply_successfully(String arg1) throws Throwable {
		cv.click_button("Insert function");
		String function = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='series-function-item--body']", 15).getText();
		applied_function_in_fx = function.replaceAll("\n", "");
		cv.click_button("Apply");
		if (login.driver.findElements(By.xpath(
				"//*[contains(@class,'sphere-modal__title') and text()='The function cannot be applied to selected series']"))
				.size() == 0) {
			login.Log4j.info("The function has been applied successfully");
		} else {
			fail("Popup is displayed and function is not applied. Hence verification Failed");
		}
		if (login.driver
				.findElements(By.xpath("//*[@class='movable-modal--title-message' and text()='Series Harmonization']"))
				.size() > 0) {
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 15).click();
		}
		String series_name = null;
		if (arg1.equalsIgnoreCase("Pie")) {
			CommonFunctionality.wait(1000);
			series_name = CommonFunctionality
					.getElementByXpath(login.driver, "(//*[@class='series-name--title'])[1]", 15).getText();
		} else {
			CommonFunctionality.wait(1000);
			series_name = CommonFunctionality
					.getElementByXpath(login.driver, "(//*[@class='series-item--name'])[1]", 15).getText();
		}
		if (arg1.equalsIgnoreCase("Pie")) {
			CommonFunctionality.wait(1000);
			new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'series-edit--title__editable') and contains(text(),'" + series_name + "')]",
					15)).pause(1000).build().perform();
		}
		if (arg1.equalsIgnoreCase("Heat map")) {
			CommonFunctionality.wait(1000);
			new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
					"(//*[contains(@class,'legend-item')]/following::*[contains(text(),'" + series_name + "')])[2]",
					15)).pause(1000).build().perform();
		}
		if (arg1.equalsIgnoreCase("Chart")) {
			CommonFunctionality.wait(1000);
			new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'legend-item--marker')]//following-sibling::*[contains(text(),'" + series_name
							+ "')]",
					15)).pause(1000).build().perform();
		}
		String functions = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'Functions')]/following-sibling::*", 15)
				.getText();
		if (functions.contains(applied_function_in_fx)) {
			login.Log4j.info("The functions are applied to the series and has been verified successfully");
		} else {
			fail("Functions not applied to series");
		}
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, "span[data-name='title']", 15))
				.perform();
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
				"(//*[contains(@class,'series-edit--title')])[1]", 15)).perform();
		String first_unit = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'Unit:')]/following-sibling::*", 15).getText();
		String first_frequency = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'Frequency:')]/following-sibling::*", 15)
				.getText();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, "span[data-name='title']", 15))
				.perform();
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
				"(//*[contains(@class,'series-edit--title')])[2]", 15)).perform();
		String second_unit = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'Unit:')]/following-sibling::*", 15).getText();
		String second_frequency = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'Frequency:')]/following-sibling::*", 15)
				.getText();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, "span[data-name='title']", 15))
				.perform();
		// new
		// Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
		// "(//*[contains(@class,'series-edit--title')])[3]", 15)).perform();
		// String third_unit = CommonFunctionality.getElementByXpath(login.driver,
		// "//*[contains(text(),'Unit:')]/following-sibling::*", 15).getText();
		// String third_frequency = CommonFunctionality.getElementByXpath(login.driver,
		// "//*[contains(text(),'Frequency:')]/following-sibling::*", 15).getText();
		// new
		// Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
		// "span[data-name='title']", 15)).perform();
		assertEquals(first_unit, second_unit);
		// assertEquals(first_unit, third_unit);
		assertEquals(first_frequency, second_frequency);
		// assertEquals(first_frequency, third_frequency);
		login.Log4j.info("Both Series has been converted into Currency/Unit as <-- " + first_unit
				+ " --> and Frequency as <-- " + first_frequency + " -->");

		CommonFunctionality.Views_list();
	}

	@SuppressWarnings("deprecation")
	@Then("^The Function \"([^\"]*)\" apply on the created visual$")
	public void the_Function_apply_on_the_created_visual(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Should")) {
			cv.click_button("Insert function");
			String function = CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='series-function-item--body']", 15).getText();
			applied_function_in_fx = function.replaceAll("\n", "");
			cv.click_button("Apply");
			CommonFunctionality.wait(2000);
			hovor_on_to_first_visual_title();
			new Actions(login.driver)
					.moveToElement(
							CommonFunctionality.getElementBycssSelector(login.driver, "span[data-name='title']", 15))
					.pause(500).build().perform();
			hovor_on_to_next_visual_title();
			new Actions(login.driver)
					.moveToElement(
							CommonFunctionality.getElementBycssSelector(login.driver, "span[data-name='title']", 15))
					.pause(500).build().perform();
			WebElement series = login.driver
					.findElement(By.xpath("(//*[contains(@class,'series-edit--title__editable')])[1]"));
			new Actions(login.driver).moveToElement(series).pause(2000).build().perform();
			String expected = CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(text(),'Functions')]/following-sibling::*", 15)
					.getText();
			if (expected.contains(applied_function_in_fx)) {
				login.Log4j.info("The applied function is present and has been verified successfully");
			} else {
				fail("Verification Failed");
			}
			String[] part = expected.split("(?<=\\D)(?=\\d)");
			String first[] = part[1].split("\\+");
			String second[] = part[2].split("\\)");
			assertEquals(functions_item_id, first[0]);
			assertEquals(functions_item_id_next_series, second[0]);
			if (login.driver.findElements(By.xpath("//*[contains(@class,'growl-warning')]//*[text()='Ok']"))
					.size() > 0) {
				CommonFunctionality
						.getElementByXpath(login.driver, "//*[contains(@class,'growl-warning')]//*[text()='Ok']", 15)
						.click();
			}
			CommonFunctionality.Views_list();
		} else {
			the_Series_should_be_of_same_Validation_message_should_appear("frequency & unit");
		}
	}

	@Then("^The Cancel applying crosssec in functions toolbar should verify$")
	public void the_Cancel_applying_crosssec_in_functions_toolbar_should_verify() throws Throwable {
		List<WebElement> myseries_after = login.driver.findElements(By.className("series-name-field--series-name"));
		int count = myseries_after.size();
		if (login.driver.findElements(By.xpath("//*[@class='series-functions-title']")).size() == 0
				&& ChartVisual.myseries_before == count) {
			login.Log4j.info("The Cancel applying crosssec function toolbar has been verified successfully");
		} else {
			fail("The cancel button verification Failed");
		}
		Deleting_series();
	}

	@SuppressWarnings("deprecation")
	@Then("^The Output series \"([^\"]*)\" the first base series for \"([^\"]*)\"$")
	public void the_Output_series_the_first_base_series_for(String arg1, String arg2) throws Throwable {
		cv.click_button("Insert function");
		String function = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='series-function-item--body']", 15).getText();
		applied_function_in_fx = function.replaceAll("\n", "");
		cv.click_button("Apply");
		CommonFunctionality.wait(2000);
		if (arg1.equalsIgnoreCase("should not replace") && arg2.equalsIgnoreCase("Median")) {
			List<WebElement> myseries_after = login.driver.findElements(By.className("series-name-field--series-name"));
			assertNotEquals(ChartVisual.myseries_before, myseries_after.size());
			assertEquals(functions_checkbox, true);
			assertEquals(replace_checkbox, false);
		}
		if (arg1.equalsIgnoreCase("should replace") && arg2.equalsIgnoreCase("Median")) {
			List<WebElement> myseries_after = login.driver.findElements(By.className("series-name-field--series-name"));
			assertEquals(ChartVisual.myseries_before, myseries_after.size());
			assertEquals(functions_checkbox, true);
			assertEquals(replace_checkbox, true);
		}
		if (arg1.equalsIgnoreCase("should replaced") && arg2.equalsIgnoreCase("Median")
				|| arg1.equalsIgnoreCase("will replace") && arg2.equalsIgnoreCase("Median")) {
			List<WebElement> myseries_after = login.driver.findElements(By.className("series-name-field--series-name"));
			assertEquals(ChartVisual.myseries_before, myseries_after.size());
			assertEquals(functions_checkbox, false);
			assertEquals(functions_checkbox, true);
			assertEquals(replace_checkbox, true);
		}
		if (arg1.equalsIgnoreCase("can replace") && arg2.equalsIgnoreCase("Median")) {
			List<WebElement> myseries_after = login.driver.findElements(By.className("series-name-field--series-name"));
			assertEquals(ChartVisual.myseries_before, myseries_after.size());
			assertEquals(functions_checkbox, false);
			assertEquals(functions_checkbox, false);
			assertEquals(replace_checkbox, true);
		}
		hovor_on_to_first_myseries_name();
		new Actions(login.driver)
				.moveToElement(
						CommonFunctionality.getElementBycssSelector(login.driver, "div[data-action='group']", 15))
				.pause(500).build().perform();
		hovor_on_to_next_myseries_name();
		new Actions(login.driver)
				.moveToElement(
						CommonFunctionality.getElementBycssSelector(login.driver, "div[data-action='group']", 15))
				.pause(500).build().perform();
		String expected = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='series-functions-title']", 15).getText();
		if (expected.contains(applied_function_in_fx)) {
			login.Log4j.info("The applied function is present and has been verified successfully");
		} else {
			fail("Verification Failed");
		}
		String[] part = expected.split("(?<=\\D)(?=\\d)");
		String first[] = part[1].split("\\+");
		String second[] = part[2].split("\\)");
		assertEquals(functions_item_id, first[0]);
		assertEquals(functions_item_id_next_series, second[0]);
		String method[] = applied_function_in_fx.split("\\(");
		String actual[] = method[1].split("\\;");
		assertEquals(actual[0], arg2);
		CommonFunctionality.DeleteSeries();
	}

	@SuppressWarnings("deprecation")
	@Then("^The Crosssec functions for Extend to longest is \"([^\"]*)\" and Ignore missed is \"([^\"]*)\" and Replace selected series is \"([^\"]*)\" and rename as \"([^\"]*)\" and verify the testdata as \"([^\"]*)\"$")
	public void the_Crosssec_functions_for_Extend_to_longest_is_and_Ignore_missed_is_and_Replace_selected_series_is_and_rename_as_and_verify_the_testdata_as(
			String arg1, String arg2, String arg3, String arg15, String arg5) throws Throwable {
		cv.click_button("Insert function");
		String functions_title = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'movable-modal--window')]//*[@class='series-function-item--arguments-list']", 15)
				.getAttribute("title");

		System.out.println("functions_title:" + functions_title);

		cv.click_button("Apply");
		if (arg3.equals("No")) {
			count_the_total_series();
		}
		hovor_on_to_first_myseries_name();

		Actions actionProvider = new Actions(login.driver);
		WebElement icon = login.driver.findElement(By.xpath("(//div[@class='series-name-wrapper '])[1]"));
		// Performs mouse move action onto the element
		actionProvider.moveToElement(icon).build().perform();
		Thread.sleep(2000);

		// new
		// Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
		// "div[title='More']", 15)).perform();
		hovor_on_to_last_myseries_name();
		
		actionProvider.moveToElement(icon).build().perform();
		Thread.sleep(2000);
		// new
		// Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
		// "div[title='More']", 15)).perform();

		String function = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='series-function-item--body']", 15).getText();
		String title[] = functions_title.split("\n");
		String method_title[] = title[1].split("Method: ");
		assertEquals(method_name, method_title[1]);
		String part_title[] = title[2].split("Extend to longest: ");
		String expect[] = title[3].split("Ignore missed: ");
		System.out.println("part_title[1]:" + part_title[1]);
		System.out.println("arg1:" + arg1);

		System.out.println("arg2:" + arg2);
		System.out.println("expect[1]:" + expect[1]);

		assertEquals(part_title[1], arg1);
		assertEquals(expect[1], arg2);
		if (arg3.equals("No")) {
			assertEquals(replace_checkbox, false);
		} else {
			assertEquals(replace_checkbox, true);
		}
		login.Log4j.info("The crosssec fuctions has been validated");
		applied_function_in_fx = function.replaceAll("\n", "");
		String expected = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='series-functions-title']", 15).getText();
		if (expected.contains(applied_function_in_fx)) {
			login.Log4j.info("The applied function is present and has been verified successfully");
		} else {
			fail("Verification Failed");
		}
		String[] part = expected.split("(?<=\\D)(?=\\d)");
		String first[] = part[1].split("\\+");
		String second[] = part[2].split("\\)");
		assertEquals(functions_item_id, first[0]);
		assertEquals(functions_item_id_last_series, second[0]);
		renaming_insight(arg15);
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='download-button--text drop-down-button--label']", 15)
				.click();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//input[@name='observations']/following-sibling::span/child::span[text()='All']", 15))
				.pause(500).click().build().perform();
		Select_the_Start_Date_and_End_Date("2001-01-01", "2010-12-31");
		// chart.uncheck_the_checkbox_for_sections("Data Refresh");
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='sphere-modal-controls']//*[contains(text(),'Download')]", 15).click();
		CommonFunctionality.wait(2000);
		Deleting_series();
		enter_the_Testdata_as(arg5);
	}

	@SuppressWarnings("deprecation")
	@Then("^The Crosssec functions for method \"([^\"]*)\" with Extend to longest is \"([^\"]*)\" and Ignore missed is \"([^\"]*)\" and Replace selected series is \"([^\"]*)\" and rename as \"([^\"]*)\" and verify the testdata as \"([^\"]*)\"$")
	public void the_Crosssec_functions_for_method_with_Extend_to_longest_is_and_Ignore_missed_is_and_Replace_selected_series_is_and_rename_as_and_verify_the_testdata_as(
			String arg1, String arg2, String arg3, String arg15, String arg5, String arg6) throws Throwable {
		count_the_total_series();
		hovor_on_to_first_myseries_name();
		// new
		// Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
		// "div[title='More']", 15)).perform();
		WebElement icon = login.driver.findElement(By.xpath("(//div[@class='series-name-wrapper '])[1]"));
		// Performs mouse move action onto the element
		action.moveToElement(icon).build().perform();
		Thread.sleep(2000);

		hovor_on_to_last_myseries_name();

		action.moveToElement(icon).build().perform();
		Thread.sleep(2000);
		// new
		// Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
		// "div[title='More']", 15)).perform();
		String function = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='series-function-item--body']", 15).getText();
		String fun_title = CommonFunctionality
				.getElementByClassName(login.driver, "series-function-item--arguments-list", 15).getAttribute("title");
		String title[] = fun_title.split("\n");
		String method_title[] = title[1].split("Method: ");
		assertEquals(arg1, method_title[1]);
		String part_title[] = title[2].split("Extend to longest:");
		String expect[] = title[3].split("Ignore missed: ");
		assertEquals(part_title[1], arg2);
		assertEquals(expect[1], arg3);
		if (arg15.equals("No")) {
			assertEquals(replace_checkbox, false);
		} else {
			assertEquals(replace_checkbox, true);
		}
		login.Log4j.info("The crosssec fuctions has been validated");
		applied_function_in_fx = function.replaceAll("\n", "");
		String expected = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='series-functions-title']", 15).getText();
		if (expected.contains(applied_function_in_fx)) {
			login.Log4j.info("The applied function is present and has been verified successfully");
		} else {
			fail("Verification Failed");
		}
		String[] part = expected.split("(?<=\\D)(?=\\d)");
		String first[] = part[1].split("\\+");
		String second[] = part[2].split("\\)");
		assertEquals(functions_item_id, first[0]);
		assertEquals(functions_item_id_last_series, second[0]);
		renaming_insight(arg5);
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='page-main-header--buttons']//*[contains(@class,'download-button--text drop-down-button--label')]",
				15).click();

		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//input[@name='observations']/following-sibling::span/child::span[text()='All']", 15))
				.pause(500).click().build().perform();
		chart.uncheck_the_checkbox_for_sections("Data Refresh");
		CommonFunctionality.wait(200);
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='sphere-modal-controls']//*[contains(text(),'Download')]", 15).click();
		CommonFunctionality.wait(2000);
		Deleting_series();
		enter_the_Testdata_as(arg6);
	}

	@Then("^The \"([^\"]*)\" in Download window has to be present$")
	public void the_in_Download_window_has_to_be_present(String arg1) throws Throwable {
		cv.click_button("Insert function");
		cv.click_button("Apply");
		String count = CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[contains(@class,'download-area-selector__description')]/following-sibling::span", 15)
				.getText();
		String number;
		if (count.contains("(")) {
			number = count.substring(1, 2);
		} else {
			number = count.substring(0, 2);
		}
		int expected_series = Integer.parseInt(number);
		assertNotEquals(actual_series, expected_series);
		String expected = CommonFunctionality
				.getElementByClassName(login.driver, "series-functions--modal-title-label", 15).getText();
		if (arg1.equalsIgnoreCase("Download button")) {
			new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'sphere-modal__body')]//*[contains(@class,'button__download-btn')]", 15))
					.click().build().perform();
			CommonFunctionality.wait(3000);
			String path = System.getProperty("user.home") + "\\Downloads\\" + "Name your insight.xlsx";
			File src = new File(path);
			FileInputStream fis = new FileInputStream(src);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet1 = wb.getSheetAt(0);
			String data = sheet1.getRow(10).getCell(3).getStringCellValue();
			Files.deleteIfExists(Paths.get(path));
			assertEquals(data, expected);
			fis.close();
		}
		if (arg1.equalsIgnoreCase("Cancel button")) {
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//*[contains(@class,'sphere-modal-dialog ')]//*[contains(text(),'Cancel')]", 15))
					.click().build().perform();
			if (!(login.driver
					.findElements(
							By.xpath("//*[contains(@class,'sphere-modal-dialog ')]//*[contains(text(),'Download:')]"))
					.size() == 0)) {
				fail("Download Window is not closed");
			}
		}
		login.Log4j.info("The " + arg1 + " in download window is present and has been verified successfully");
	}

	public void main(String[] args) throws Throwable

	{
		enter_the_Testdata_as("TC_UnitManipulation_01");
	}
}