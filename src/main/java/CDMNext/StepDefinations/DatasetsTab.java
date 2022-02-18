package CDMNext.StepDefinations;

import static org.junit.Assert.assertNotEquals;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class DatasetsTab {

	JavascriptExecutor js = (JavascriptExecutor) login.driver;
	List<WebElement> before_load_button;
	static String footnotes_dataset_title;
	static String series_name_in_dataset;
	static int series_inside_one_dataset;
	static String series_item_name;
	ArrayList<String> hovered_series = new ArrayList<String>();
	ArrayList<String> insight_series = new ArrayList<String>();
	ArrayList<String> series_name_inside_dataset = new ArrayList<String>();
	ArrayList<String> replaced_series_name = new ArrayList<String>();
	ArrayList<String> dataset_series_name = new ArrayList<String>();

	@SuppressWarnings("deprecation")
	@And("^Clicking \"([^\"]*)\" tab from menu$")
	public void clicking_tab_from_menu(String arg1) throws Throwable {
		// CommonFunctionality.webDriverwait_keyvalue("//*[contains(@class,'toggler-control__sm')]//*[@title='"+arg1+"']");
		CommonFunctionality.wait(3000);
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'toggler-control__light_purple')]//*[@title='" + arg1 + "']", 4))
				.pause(500).click().build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Hovor on icon$")
	public void hovor_on_icon() throws Throwable {
		WebElement first_series = login.driver
				.findElement(By.cssSelector(".series-item--main-info .series-item--country"));
		new Actions(login.driver).moveToElement(first_series).pause(200).build().perform();
		series_item_name = CommonFunctionality
				.getElementByXpath(login.driver, "(//div[@class='series-item--name'])[1]", 4).getText();
	}

	@SuppressWarnings("deprecation")
	@And("^The \"([^\"]*)\" option in dataset should present$")
	public void the_option_in_dataset_should_present(String arg1) throws Throwable {
		WebElement text;
		if (login.driver.findElements(By.xpath("//*[contains(text(),'Insights')]")).size() > 0) {
			text = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Insights')]", 4);
			js.executeScript("arguments[0].scrollIntoView(true);", text);
			if (!(text.isDisplayed())) {
				fail("Verification Failed");
			}
		} else {
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'My insights')]", 4).click();
			CommonFunctionality.getElementBycssSelector(login.driver, "button[title='New Insight']", 4).click();
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='modal-window modal-window__active']//*[text()='Create insight']", 4).click();
			WebElement source = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[@class='series-item--name'])[1]", 4);
			WebElement target = CommonFunctionality.getElementBycssSelector(login.driver,
					".data-selection-series-overlay.data-selection-series-overlay__data  ", 4);
			new Actions(login.driver).moveToElement(source).pause(2000).dragAndDrop(source, target).build().perform();
			login.driver.navigate().refresh();
			Comparables c = new Comparables();
			c.right_click_section_from_Comparables_tab("Dataset");
			verify_the_datasets_keyboard_shortcuts("Expand", "Without");
			hovor_on_icon();
			c.click_option_in_series("Show related data");
			text = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Insights')]", 4);
			js.executeScript("arguments[0].scrollIntoView(true);", text);
			if (!(text.isDisplayed())) {
				fail("Verification Failed");
			}
			CommonFunctionality.DeleteSeries();
		}
	}

	@And("^Click on the Sort by option$")
	public void click_on_the_Sort_by_option() throws Throwable {
		CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@class='data-sets--right']//div[@class='dropdown--button']/parent::div[contains(@class,'custom-select')]")));
		WebElement open = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='data-sets--right']//div[@class='dropdown--button']/parent::div[contains(@class,'custom-select')]",
				4);
		if (!open.getAttribute("class").contains("dropdown__open")) {
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//div[@class='data-sets--right']//span[contains(@class,'icon--filter-arrow')]", 4))
					.click().build().perform();
		} else {
			fail("Already dropdown is opened and hence failed");
		}
	}

	@And("^Select any checkbox for dataset$")
	public void select_any_checkbox_for_dataset() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement checkbox = login.driver.findElement(By.xpath("(//*[contains(@class,'svg-checkbox')])[1]"));
		if (checkbox.getAttribute("class").contains("svg-checkbox__selected")
				|| checkbox.getAttribute("class").contains("svg-checkbox__partially-selected")) {
			System.out.println("===> The Checkbox has been checked already <===");
		} else {
			new Actions(login.driver).pause(500).moveToElement(
					CommonFunctionality.getElementByXpath(login.driver, "(//*[contains(@class,'svg-checkbox')])[1]", 4))
					.click().build().perform();
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Right Click (\\d+) series$")
	public void right_Click_series(int arg1) throws Throwable {
		series_inside_one_dataset = arg1;
		for (int i = 1; i <= series_inside_one_dataset; i++) {
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"(//span[contains(@class,'series-list-item--checkbox')])[" + i + "]", 4))
					.pause(500).click().build().perform();
			if (i == arg1) {
				new Actions(login.driver)
						.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
								"(//div[@class='series-item--name'])[" + i + "]", 4))
						.pause(1000).contextClick().pause(1000).build().perform();
				break;
			}
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Search for the series to scroll down$")
	public void search_for_the_series_to_scroll_down() throws Throwable {
		WebElement scroll = CommonFunctionality.getElementByXpath(login.driver,
				"//div[contains(text(),'Industrial Sales Vol Index: NACE 2: DO: EM: Mfg: Transport Equipment')]", 4);
		js.executeScript("arguments[0].scrollIntoView(true);", scroll);
		CommonFunctionality.wait(1000);
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
				"//div[contains(text(),'Industrial Sales Vol Index: NACE 2: DO: EM: Mfg: Transport Equipment')]/preceding::div[contains(@class,'series-item--country')][1]",
				4)).pause(2000).build().perform();
		clicking_option_from_series_hovor("Show related data");
	}

	@And("^Clicking \"([^\"]*)\" option from series hovor$")
	public void clicking_option_from_series_hovor(String arg1) throws Throwable {
		WebElement icon = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='series-item--status-icons']/following-sibling::*[contains(@title,'" + arg1 + "')]", 4);
		new Actions(login.driver).moveToElement(icon).click().build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Collapse the dataset and perform right click operation$")
	public void collapse_the_dataset_and_perform_right_click_operation() throws Throwable {
		WebElement expand = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='nodes-list--tree-wrapper']//div[@class='title']/parent::div", 4);
		if (expand.getAttribute("class").contains("full-expanded")) {
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//*[@class='nodes-list--tree-wrapper']//div[@class='title']/child::div[1]", 4))
					.pause(200).click().build().perform();
		} else {
			System.out.println("===> The Dataset window has been closed already <===");
		}
		WebElement ele = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'" + Comparables.section_name + "')]", 4);
		new Actions(login.driver).moveToElement(ele).pause(2000).contextClick().build().perform();
	}

	@Then("^Verify the replaced series$")
	public void verify_the_replaced_series() throws Throwable {
		List<WebElement> series_name = login.driver
				.findElements(By.cssSelector(".series-item--main-info .series-item--name"));
		for (int i = series_name.size() - 1; i >= 0; i--) {
			String series_left = CommonFunctionality
					.getElementBycssSelector(login.driver, ".series-item--main-info .series-item--name", 4).getText();
			series_name_inside_dataset.add(series_left);
		}
		List<WebElement> visual_series = login.driver
				.findElements(By.xpath("//*[@class='legend-item']//*[contains(@class,'series-edit--title')]"));
		for (int j = 1; j <= visual_series.size(); j++) {
			String chart_series = CommonFunctionality
					.getElementByXpath(login.driver,
							"(//*[@class='legend-item']//*[contains(@class,'series-edit--title')])[" + j + "]", 4)
					.getText();
			replaced_series_name.add(chart_series);
		}
		boolean result = Arrays.equals(series_name_inside_dataset.toArray(), replaced_series_name.toArray());
		login.Log4j.info("Comparision is: \n" + result);
		assertNotEquals(series_name_inside_dataset.toArray(), replaced_series_name.toArray());
		login.Log4j.info("The Series has been successfully replaced and verified");
		CommonFunctionality.Views_list();
	}

	@And("^Select the series checkbox$")
	public void select_the_series_checkbox() throws Throwable {
		CommonFunctionality.wait(1000);
		boolean checkbox = login.driver
				.findElement(By.xpath("(//span[contains(@class,'series-list-item--checkbox')])[1]")).isSelected();
		if (checkbox == false) {
			new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
					"(//span[contains(@class,'series-list-item--checkbox')])[1]", 4)).click().build().perform();
		} else {
			System.out.println("The checkbox is checked already");
		}
	}

	@SuppressWarnings("unused")
	@And("^Paste in the clipboard and take url one by one$")
	public void paste_in_the_clipboard_and_take_url_one_by_one() throws Throwable {
		SessionId session = ((ChromeDriver) login.driver).getSessionId();
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Comparables.copied_link = (String) clipboard.getData(DataFlavor.stringFlavor);
		String[] textArea = Comparables.copied_link.split("\\n");
		assertEquals(textArea.length, series_inside_one_dataset);
		for (String line : textArea) {
			StringSelection stringSelection = new StringSelection(line);
			clipboard.setContents(stringSelection, null);
			String parent_window = login.driver.getWindowHandle();
			js.executeScript("window.open('" + line + "');");
			CommonFunctionality.wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			Set<String> allWindows_1 = login.driver.getWindowHandles();
			for (String hand1 : allWindows_1) {
				if (!parent_window.equals(hand1)) {
					CommonFunctionality.wait.until(ExpectedConditions.titleContains("CDMNext"));
					String first_child_window = login.driver.getWindowHandle();
					login.driver.switchTo().window(hand1);
					String code = CommonFunctionality.getElementByXpath(login.driver,
							"//div[@class='main-series-information--series-id']/div[2]", 4).getText();
					String split[] = code.split("\\: ");
					String expected = line.substring(line.length() - 8, line.length());
					login.driver.switchTo().window(hand1).close();
					assertEquals(split[1], expected);
				}
				login.driver.switchTo().window(parent_window);
			}
		}
		login.Log4j.info("The copy selected links for multiple series has been verified successfully");
	}

	@SuppressWarnings("deprecation")
	@And("^Clicking \"([^\"]*)\" option in Dataset$")
	public void clicking_option_in_Dataset(String arg1) throws Throwable {
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
				"(//*[@class='add-to-data-selection--title'])[2]", 4)).pause(500).build().perform();
		WebElement icon = CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='" + arg1 + "'])[2]", 4);
		new Actions(login.driver).moveToElement(icon).pause(1000).click().build().perform();
	}

	@Then("^Verify Checkbox is checked$")
	public void verify_Checkbox_is_checked() throws Throwable {
		WebElement checkbox = CommonFunctionality.getElementByXpath(login.driver,
				"(//*[contains(@class,'svg-checkbox')])[1]", 4);
		if (checkbox.getAttribute("class").contains("svg-checkbox__selected")) {
			login.Log4j.info("The checkbox has been verified successfully");
		} else {
			fail("Verification of checkbox failed");
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Click on \"([^\"]*)\" option shortcut$")
	public void click_on_option_shortcut(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("A")) {
			new Actions(login.driver).sendKeys("a").pause(1000).build().perform();
		}
		if (arg1.equalsIgnoreCase("Drag and Drop a Dataset")) {
			WebElement source = CommonFunctionality.getElementBycssSelector(login.driver,
					".series-data-set--table-name", 4);
			WebElement target = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='data-selection-series-overlay--content'] | //*[@class='empty-visual-overlay--content']",
					4);
			// select_any_checkbox_for_dataset();
			(new Actions(login.driver)).pause(500).clickAndHold(source).pause(1000).moveToElement(target).pause(500)
					.release(target).build().perform();
		}
		if (arg1.equalsIgnoreCase("Drag and Drop a Series")) {
			WebElement source = CommonFunctionality.getElementByXpath(login.driver,
					"(//div[@class='series-item--name'])[1]", 4);
			WebElement target = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='data-selection-series-overlay--content'] | //*[@class='empty-visual-overlay--content']",
					4);
			(new Actions(login.driver)).pause(500).clickAndHold(source).pause(1000).moveToElement(target).pause(500)
					.release(target).build().perform();
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Create an empty view and click on \"([^\"]*)\" option$")
	public void create_an_empty_view_and_click_on_option(String arg1) throws Throwable {
		CommonFunctionality.getElementBycssSelector(login.driver, "div[title='Create new View tab']", 4).click();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//div[@class='view-action-panel']//div[@data-title='" + arg1 + "']", 4))
				.pause(500).click().build().perform();
		CommonFunctionality.wait(2000);
	}

	@SuppressWarnings("deprecation")
	@And("^Search for the \"([^\"]*)\" with ID \"([^\"]*)\" and click on \"([^\"]*)\" option$")
	public void search_for_the_with_ID_and_click_on_option(String arg1, String arg2, String arg3) throws Throwable {
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementBycssSelector(login.driver, "div[title='" + arg1 + "']", 4).click();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).clear();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(arg2);
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		new Actions(login.driver).moveToElement(
				CommonFunctionality.getElementByXpath(login.driver, "//span[contains(@class,'svg-checkbox')]", 4))
				.pause(500).click().build().perform();
		if (arg3.equalsIgnoreCase("C")) {
			new Actions(login.driver).sendKeys("c").pause(1000).build().perform();
		}
		if (arg3.equalsIgnoreCase("T")) {
			new Actions(login.driver).sendKeys("t").pause(1000).build().perform();
		}
		if (arg3.equalsIgnoreCase("M")) {
			new Actions(login.driver).sendKeys("m").pause(1000).build().perform();
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Search for \"([^\"]*)\" with ID \"([^\"]*)\" and click on \"([^\"]*)\" option$")
	public void search_for_with_ID_and_click_on_option(String arg1, String arg2, String arg3) throws Throwable {
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementBycssSelector(login.driver, "*[title='" + arg1 + "']", 4).click();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).clear();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(arg2);
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'data-set-node')][1]//div[@class='toggle']", 4))
				.pause(500).click().build().perform();
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'series-list-item')]//span[contains(@class,'series-list-item--checkbox')]", 4))
				.pause(500).click().build().perform();
		if (arg3.equalsIgnoreCase("C")) {
			new Actions(login.driver).sendKeys("c").pause(1000).build().perform();
		}
		if (arg3.equalsIgnoreCase("T")) {
			new Actions(login.driver).sendKeys("t").pause(1000).build().perform();
		}
		if (arg3.equalsIgnoreCase("M")) {
			new Actions(login.driver).sendKeys("m").pause(1000).build().perform();
		}
	}

	@And("^Search for the \"([^\"]*)\" with ID \"([^\"]*)\"$")
	public void search_for_the_with_ID(String arg1, String arg2) throws Throwable {
		CommonFunctionality.getElementBycssSelector(login.driver, "*[title='" + arg1 + "']", 4).click();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).clear();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(arg2);
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		// new
		// Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
		// "//span[contains(@class,'svg-checkbox')]",
		// 4)).pause(500).click().build().perform();
	}

	@And("^Clicking Load more option$")
	public void clicking_Load_more_option() throws Throwable {
		if (login.driver.findElements(By.cssSelector(".nodes-list--footer .nodes-list--more-button")).size() > 0) {
			WebElement load = CommonFunctionality.getElementBycssSelector(login.driver,
					".nodes-list--footer .nodes-list--more-button", 4);
			js.executeScript("arguments[0].scrollIntoView(true);", load);
			CommonFunctionality.wait(500);
			before_load_button = login.driver.findElements(By.xpath("//*[@class='title']"));
			new Actions(login.driver).moveToElement(load).pause(500).click().build().perform();
		} else {
			fail("Load more button not present");
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Click the footnotes icon$")
	public void click_the_footnotes_icon() throws Throwable {
		WebElement hovor = CommonFunctionality.getElementByXpath(login.driver,
				"(//*[@class='series-data-set--table-name'])[1]", 4);
		footnotes_dataset_title = CommonFunctionality
				.getElementByXpath(login.driver, "(//*[@class='series-data-set--table-name'])[1]", 4).getText();
		new Actions(login.driver).moveToElement(hovor).pause(500).perform();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'"
						+ footnotes_dataset_title + "')]/following::*[@title='Open footnote'][1]", 4))
				.click().build().perform();
	}

	@Then("^Verify the footnotes option$")
	public void verify_the_footnotes_option() throws Throwable {
		String title = CommonFunctionality
				.getElementByXpath(login.driver, "//span[@class='footnotes-modal--name']//span", 4).getText();
		String footnotes = title.substring(1, title.length() - 1);
		String footnotes_title[] = footnotes.split("\\: ", 2);
		// assertEquals(footnotes_dataset_title, footnotes_title[1]);
		if (footnotes_title[1].contains(footnotes_dataset_title)) {
			login.Log4j.info("The footnotes window has been verified successfully");
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		} else {
			fail("Verification failed");
		}
	}

	@Then("^Verify the Load more button$")
	public void verify_the_Load_more_button() throws Throwable {
		CommonFunctionality.wait(10000);
		List<WebElement> after_load = login.driver.findElements(By.xpath("//*[@class='title']"));
		assertNotEquals(before_load_button.size(), after_load.size());
		login.Log4j.info("The load more button has been verified successfully");

	}

	@SuppressWarnings("deprecation")
	@And("^Search for the series of a \"([^\"]*)\" with ID \"([^\"]*)\"$")
	public void search_for_the_series_of_a_with_ID(String arg1, String arg2) throws Throwable {
		CommonFunctionality.getElementBycssSelector(login.driver, "*[title='" + arg1 + "']", 4).click();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).clear();
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(arg2);
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'data-set-node')][1]//div[@class='toggle']", 4))
				.pause(500).click().build().perform();
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'series-list-item__matched')]//span[contains(@class,'series-list-item--checkbox')]",
				4)).pause(500).click().build().perform();
	}

	@Then("^Verify the \"([^\"]*)\" and validate \"([^\"]*)\" option$")
	public void verify_the_and_validate_option(String arg1, String arg2) throws Throwable {
		if (arg1.equalsIgnoreCase("Chart")) {
			String actual = CommonFunctionality
					.getElementBycssSelector(login.driver, ".visual-top-panel--left-controls .button__primary", 4)
					.getText();
			boolean enable = login.driver
					.findElement(By.cssSelector(".visual-top-panel--left-controls .button__primary")).isEnabled();
			assertEquals(actual, arg2);
			assertEquals(enable, true);
			login.Log4j.info("The " + arg1 + " visual has been created and verified successfully");
		}
		if (arg1.equalsIgnoreCase("Table")) {
			String actual = CommonFunctionality
					.getElementBycssSelector(login.driver, ".visual-top-panel--left-controls .button__primary", 4)
					.getText();
			boolean enable = login.driver
					.findElement(By.cssSelector(".visual-top-panel--left-controls .button__primary")).isEnabled();
			assertEquals(actual, arg2);
			assertEquals(enable, true);
			login.Log4j.info("The " + arg1 + " visual has been created and verified successfully");
		}
		if (arg1.equalsIgnoreCase("Map")) {
			String actual = CommonFunctionality
					.getElementBycssSelector(login.driver, ".visual-top-panel--left-controls .button__primary", 4)
					.getText();
			boolean enable = login.driver
					.findElement(By.cssSelector(".visual-top-panel--left-controls .button__primary")).isEnabled();
			assertEquals(actual, arg2);
			assertEquals(enable, true);
			login.Log4j.info("The " + arg1 + " visual has been created and verified successfully");
		}
		CommonFunctionality.Views_list();
	}

	@Then("^Verify the \"([^\"]*)\" for series and validate \"([^\"]*)\" option$")
	public void verify_the_for_series_and_validate_option(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(1500);
		String text_left = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'series-list-item')]//div[@class='series-item--name']", 4).getText();
		String text_right = CommonFunctionality.getElementBycssSelector(login.driver, "span[data-name='title']", 4)
				.getText();
		if (arg1.equalsIgnoreCase("Chart")) {
			String actual = CommonFunctionality
					.getElementBycssSelector(login.driver, ".visual-top-panel--left-controls .button__primary", 4)
					.getText();
			boolean enable = login.driver
					.findElement(By.cssSelector(".visual-top-panel--left-controls .button__primary")).isEnabled();
			assertEquals(actual, arg2);
			assertEquals(enable, true);
			assertEquals(text_left, text_right);
			login.Log4j.info("The " + arg1 + " visual has been created and verified successfully");
		}
		if (arg1.equalsIgnoreCase("Table")) {
			String actual = CommonFunctionality
					.getElementBycssSelector(login.driver, ".visual-top-panel--left-controls .button__primary", 4)
					.getText();
			boolean enable = login.driver
					.findElement(By.cssSelector(".visual-top-panel--left-controls .button__primary")).isEnabled();
			assertEquals(actual, arg2);
			assertEquals(enable, true);
			assertEquals(text_left, text_right);
			login.Log4j.info("The " + arg1 + " visual has been created and verified successfully");
		}
		if (arg1.equalsIgnoreCase("Map")) {
			String actual = CommonFunctionality
					.getElementBycssSelector(login.driver, ".visual-top-panel--left-controls .button__primary", 4)
					.getText();
			boolean enable = login.driver
					.findElement(By.cssSelector(".visual-top-panel--left-controls .button__primary")).isEnabled();
			assertEquals(actual, arg2);
			assertEquals(enable, true);
			assertEquals(text_left, text_right);
			login.Log4j.info("The " + arg1 + " visual has been created and verified successfully");
		}
		CommonFunctionality.Views_list();
	}

	@Then("^Verify that the dataset is added in right pane$")
	public void verify_that_the_dataset_is_added_in_right_pane() throws Throwable {
		CommonFunctionality.wait(1000);
		select_any_checkbox_for_dataset();
		CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[contains(@class,'data-set-node')]//*[contains(@class,'svg-checkbox__selected')]/following::*[@class='series-data-set--table-name'][1]")));
		String name_left = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'data-set-node')]//*[contains(@class,'svg-checkbox__selected')]/following::*[@class='series-data-set--table-name'][1]",
				4).getText();
		String series_left = CommonFunctionality
				.getElementByClassName(login.driver, "search-input--preview-selection", 4).getText();
		String[] left_series_count = series_left.split("[^a-zA-Z0-9]");
		int left_count = Integer.parseInt(left_series_count[0]);
		String right_series_count = CommonFunctionality
				.getElementByXpath(login.driver, "//span[@class='series-panel--count']//*[@js-series-number='']", 4)
				.getText();
		int right_count = Integer.parseInt(right_series_count);
		String right = CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='series-name-wrapper']//span[@class='group-name'][1]", 4)
				.getText();
		String name_right[] = right.split(": ", 2);
		assertEquals(left_count, right_count);
		// assertEquals(name_left, name_right[1]);
		if (name_right[1].contains(name_left)) {
			login.Log4j.info("The dataset is successfully added to right pane and verified");
		} else {
			Assert.fail("The dataset is not added  successfully to the right pane");
		}
		CommonFunctionality.DeleteSeries();
	}

	@Then("^Clicking on go to insight name should open the new insight with the added series$")
	public void clicking_on_go_to_insight_name_should_open_the_new_insight_with_the_added_series() throws Throwable {
		login.driver.findElement(By.xpath(
				"//*[@class='growl-message growl-success']//*[@class='button growl-message-content--btns__fill']"))
				.click();
		CommonFunctionality.wait(2000);
		ArrayList<String> tabs = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs.get(1));
		String actual = null;
		List<WebElement> myseries = login.driver.findElements(By.className("series-name-field--series-name"));
		for (int i = 1; i <= myseries.size(); i++) {
			actual = login.driver.findElement(By.xpath("(//span[@class='series-name-field--series-name'])[" + i + "]"))
					.getText();
			insight_series.add(actual);
		}
		CommonFunctionality.Views_list();
		login.driver.switchTo().window(tabs.get(1)).close();
		login.Log4j.info("The Add to new insight feature has been verified successfully");
		login.driver.switchTo().window(tabs.get(0));
		assertEquals(hovered_series.toArray(), insight_series.toArray());
	}

	@Then("^Should be able to navigate to the existing insight$")
	public void should_be_able_to_navigate_to_the_existing_insight() throws Throwable {
		String existing_insight = CommonFunctionality
				.getElementByXpath(login.driver, "(//*[@class='input-control--description'])[1]", 4).getText();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"(//*[@class='input-control--description'])[1]/preceding-sibling::span", 4))
				.click().build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='Apply']", 4).click();
		String expected = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(@class,'growl-message--link')]", 4).getText();
		assertEquals(existing_insight, expected);
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'growl-message--link')]", 4).click();
		ArrayList<String> tabs = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs.get(1));
		CommonFunctionality.wait(2000);
		String actual = null;
		List<WebElement> myseries = login.driver.findElements(By.className("series-name-field--series-name"));
		for (int i = 1; i <= myseries.size(); i++) {
			actual = login.driver.findElement(By.xpath("(//span[@class='series-name-field--series-name'])[" + i + "]"))
					.getText();
			insight_series.add(actual);
		}
		CommonFunctionality.Views_list();
		login.Log4j.info("The Add to recent insight feature has been verified successfully");
		login.driver.switchTo().window(tabs.get(1)).close();
		login.driver.switchTo().window(tabs.get(0));
		assertEquals(hovered_series.toArray(), insight_series.toArray());
	}

	@And("^Hovor on to the series name$")
	public void hovor_on_to_the_series_name() throws Throwable {
		for (int i = 1; i <= Comparables.series_count_inside_table; i++) {
			String series_name = login.driver.findElement(By.xpath(
					"//*[contains(@class,'series-list-item__selected')][" + i + "]//*[@class='series-item--name']"))
					.getAttribute("innerHTML");
			String split[] = series_name.split("\n            ");
			String next_split[] = split[1].split("\n");
			series_name_in_dataset = next_split[0];
			if (Comparables.series_count_inside_table != 1) {
				hovered_series.add(series_name_in_dataset);
			}
		}
	}

	@Then("^Verify that the series is added in right pane$")
	public void verify_that_the_series_is_added_in_right_pane() throws Throwable {
		CommonFunctionality.wait(1000);
		select_the_series_checkbox();
		CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[contains(@class,'data-set-node')]//*[contains(@class,'series-list-item__selected')]//*[@class='series-item--name']")));
		String name_left = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'data-set-node')]//*[contains(@class,'series-list-item__selected')]//*[@class='series-item--name']",
				4).getText();
		String name_right = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='series-name-field--series-name']", 4).getText();
		assertEquals(name_left, name_right);
		login.Log4j.info("The series is successfully added to right pane and verified");
		CommonFunctionality.DeleteSeries();
	}

	@Then("^Verify that the series is added successfully in right pane with Group$")
	public void verify_that_the_series_is_added_successfuly_in_right_pane_with_Group() throws Throwable {
		String right_series_count = CommonFunctionality
				.getElementByXpath(login.driver, "//span[@class='series-panel--count']//*[@js-series-number='']", 4)
				.getText();
		int right_count = Integer.parseInt(right_series_count);
		String right = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='series-name-wrapper']//following-sibling::*[@class='group-name']", 4).getText();
		String expected = right.substring(0, 5);
		String actual = right.substring(7, right.length());
		assertEquals(Comparables.series_count_inside_table, right_count);
		assertEquals(actual, series_name_in_dataset);
		assertEquals(expected, "Group");
		login.Log4j.info("The series is successfully added to right pane and grouped");
		CommonFunctionality.DeleteSeries();
	}

	@Then("^Verify that the series is added successfully in right pane$")
	public void verify_that_the_series_is_added_successfuly_in_right_pane() throws Throwable {
		String right_series_count = CommonFunctionality
				.getElementByXpath(login.driver, "//span[@class='series-panel--count']//*[@js-series-number='']", 4)
				.getText();
		int right_count = Integer.parseInt(right_series_count);
		String right = CommonFunctionality.getElementByClassName(login.driver, "series-name-field--series-name", 4)
				.getText();
		assertEquals(Comparables.series_count_inside_table, right_count);
		assertEquals(right, series_name_in_dataset);
		login.Log4j.info("The series is successfully added to right pane");
		CommonFunctionality.DeleteSeries();
	}

	@Then("^Verify selected links are copied$")
	public void verify_selected_links_are_copied() throws Throwable {
		js.executeScript("window.open('" + Comparables.copied_link + "')");
		ArrayList<String> tabs = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs.get(1));
		String text = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'" + Comparables.section_name + "')]", 4)
				.getText();
		String dataset_name[] = text.split("\\: ", 2);
		String count = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(text(),'" + text + "')]/following-sibling::span", 4)
				.getText();
		String count1 = count.substring(1, 2);
		int dataset_count = Integer.parseInt(count1);
		List<WebElement> series = login.driver.findElements(
				By.xpath("//*[contains(text(),'" + text + "')]/following::div[@class='series-item--name']"));
		for (int i = 1; i <= series.size(); i++) {
			String series_name = login.driver.findElement(By.xpath(
					"//*[contains(text(),'" + text + "')]/following::div[@class='series-item--name'][" + i + "]"))
					.getText();
			dataset_series_name.add(series_name);
		}
		login.driver.switchTo().window(tabs.get(1)).close();
		login.driver.switchTo().window(tabs.get(0));
		assertEquals(Comparables.copied_link, Comparables.section_link);
		assertEquals(Comparables.section_name, dataset_name[1]);
		assertEquals(Comparables.series_count_inside_first_table, dataset_count);
		boolean result = Arrays.equals(Comparables.series_values_in_table.toArray(), dataset_series_name.toArray());
		login.Log4j.info("Date Comparision is: \n" + result);
		assertEquals(Comparables.series_values_in_table.toArray(), dataset_series_name.toArray());
		login.Log4j.info("The Copied URL is navigating to respective section and it has been verified successfully");
	}

	@Then("^The Footnotes window tab for Datasets should be opened$")
	public void the_Footnotes_window_tab_for_Datasets_should_be_opened() throws Throwable {
		CommonFunctionality.wait(2000);
		String text = CommonFunctionality
				.getElementBycssSelector(login.driver, "span[class='footnotes-modal--name'] span", 4).getText();
		String str1 = null;
		if (text.contains("Footnotes")) {
			text = text.replaceAll("Footnotes", "");
			str1 = text.substring(2, text.length() - 1);
		} else {
			str1 = text.substring(1, text.length() - 1);
		}
		String str2[] = str1.split("\\ ", 2);
		String str3[] = str2[1].split("\\ ", 2);
		String actual = str3[1].substring(0, str3[1].length());
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		assertEquals(actual, Comparables.section_name);
		login.Log4j.info("Footnotes window has been opened correctly and it has been verified successfully");
	}

	@SuppressWarnings("deprecation")
	@Then("^Verify Sort by option \"([^\"]*)\" for (\\d+)$")
	public void verify_Sort_by_option_for(String arg1, int arg2) throws Throwable {
		CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@class='data-sets--right']//div[@class='dropdown--button']/parent::div[contains(@class,'custom-select')]")));
		CommonFunctionality.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[@class='data-sets--right']//div[@class='dropdown--button']/parent::div[contains(@class,'custom-select')]")));
		WebElement open = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='data-sets--right']//div[@class='dropdown--button']/parent::div[contains(@class,'custom-select')]",
				4);
		if (!(open.getAttribute("class").contains("dropdown__open"))) {
			CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[@class='data-sets--right']//span[contains(@class,'icon--filter-arrow')]")));
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//div[@class='data-sets--right']//span[contains(@class,'icon--filter-arrow')]", 4))
					.pause(1000).click().build().perform();
		} else {

			fail("Already dropdown is opened and hence failed");
		}
		CommonFunctionality.wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@class='custom-select--body']//div[" + arg2 + "]/div")));
		String expected = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='custom-select--body']//div[" + arg2 + "]/div", 4)
				.getAttribute("title");
		assertEquals(arg1, expected);
		login.Log4j.info("The sort by options are available and the option is: " + expected);
		verify_closing_the_Sort_by_option();

	}

	@Then("^Verify the \"([^\"]*)\" with Sort by options for (\\d+)$")
	public void verify_the_with_Sort_by_options_for(String arg1, int arg2) throws Throwable {
		CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@class='data-sets--right']//div[@class='dropdown--button']/parent::div[contains(@class,'custom-select')]")));
		CommonFunctionality.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[@class='data-sets--right']//div[@class='dropdown--button']/parent::div[contains(@class,'custom-select')]")));
		WebElement open = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='data-sets--right']//div[@class='dropdown--button']/parent::div[contains(@class,'custom-select')]",
				4);
		if (!(open.getAttribute("class").contains("dropdown__open"))) {
			CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[@class='data-sets--right']//span[contains(@class,'icon--filter-arrow')]")));
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//div[@class='data-sets--right']//span[contains(@class,'icon--filter-arrow')]", 4))
					.click().build().perform();
		} else {
			fail("Already dropdown is opened and hence failed");
		}
		CommonFunctionality.wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@class='custom-select--body']//div[" + arg2 + "]/div")));
		String expected = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='custom-select--body']//div[" + arg2 + "]/div", 4)
				.getAttribute("title");
		assertEquals(arg1, expected);
		login.Log4j.info("The tooltips are available and the tooltip name is: " + expected);
		verify_closing_the_Sort_by_option();
	}

	@SuppressWarnings("deprecation")
	@Then("^The series in dataset getting unselected$")
	public void the_series_in_dataset_getting_unselected() throws Throwable {
		CommonFunctionality.wait(1000);
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"(//div[@class='series-item--name'])[1]", 4))
				.pause(1000).contextClick().pause(1000).build().perform();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
						".dropdown-menu.context-menu span[title='Unselect all']", 4))
				.pause(2000).click().build().perform();
		List<WebElement> selected = login.driver.findElements(By.xpath(
				"//*[@class='series-related-table']//ul[contains(@class,'search-series-list')]//li[not(contains(@class,'series-list-item__matched'))]"));
		for (int i = 1; i <= selected.size(); i++) {
			WebElement checked = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='series-related-table']//ul[contains(@class,'search-series-list')]//li[" + i
							+ "][not(contains(@class,'series-list-item__matched'))]",
					4);
			if (checked.getAttribute("class").contains("series-list-item__selected")) {
				fail("Verification Failed");
			}
		}
		CommonFunctionality.getElementByClassName(login.driver, "insight-discovery--popup-back-button", 4).click();
		if (CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + Comparables.section_name
				+ "') and not(@class='insight-discovery--popup-title')]", 4).isDisplayed()) {
			login.Log4j.info(
					"The series gets unselected and has been returned back to series level and verified successfully");
		} else {
			fail("Verification Failed");
		}
	}

	@Then("^Verify Sort by option \"([^\"]*)\" for the (\\d+)$")
	public void verify_Sort_by_option_for_the(String arg1, int arg2) throws Throwable {
		WebElement open = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='data-sets--right']//div[@class='dropdown--button']/parent::div[contains(@class,'custom-select')]",
				4);
		if (!(open.getAttribute("class").contains("dropdown__open"))) {
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//div[@class='data-sets--right']//span[contains(@class,'icon--filter-arrow')]", 4))
					.click().build().perform();
		}
		WebElement expected = CommonFunctionality.getElementByXpath(login.driver,
				"//ul[@class='custom-select--body']/li[" + arg2 + "]/div[text()='" + arg1 + "']", 4);
		new Actions(login.driver).moveToElement(expected).click().build().perform();
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'sort-select-title__asc-hidden')]//*[@class='custom-select-title--reset-icon']",
				4)).click().build().perform();
		CommonFunctionality.wait(500);
		WebElement reset = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'sort-select-title__asc-hidden')]", 4);
		if (reset.getAttribute("class").contains("custom-select-title__reset-hidden")) {
			System.out.println("The Reset button is clickable");
		} else {
			fail("Reset button is not clickable");
		}
	}

	@Then("^Verify closing the Sort by option$")
	public void verify_closing_the_Sort_by_option() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@class='data-sets--right']//div[@class='dropdown--button']/parent::div[contains(@class,'custom-select')]")));
		WebElement close = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='data-sets--right']//div[@class='dropdown--button']/parent::div[contains(@class,'custom-select')]",
				4);
		if (close.getAttribute("class").contains("dropdown__open")) {
			// CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='data-sets--right']//span[contains(@class,'icon--filter-arrow')]")));
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//div[@class='data-sets--right']//span[contains(@class,'icon--filter-arrow')]", 4))
					.click().build().perform();
		} else {
			fail("Already dropdown is closed and hence failed");
		}
	}

	@Then("^Verify the tooltips for different dataset$")
	public void verify_the_tooltips_for_different_dataset() throws Throwable {
		List<WebElement> datasets = login.driver.findElements(By.className("series-data-set--table-name"));
		for (int i = 1; i <= datasets.size(); i++) {
			WebElement text = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[@class='series-data-set--table-name'])[" + i + "]", 4);
			js.executeScript("arguments[0].scrollIntoView(true);", text);
			String actual = text.getText();
			String expected = text.getAttribute("title");
			assertEquals(actual, expected);
		}
		login.Log4j.info("The Tooltips in dataset has been verified successfully");
	}

	@SuppressWarnings("deprecation")
	@Then("^Verify \"([^\"]*)\" the datasets \"([^\"]*)\" keyboard shortcuts$")
	public void verify_the_datasets_keyboard_shortcuts(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//*[@class='nodes-list--tree-wrapper']//*[contains(@class,'data-set-node')])[1]")));
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"(//*[@class='nodes-list--tree-wrapper']//*[contains(@class,'data-set-node')])[1]", 4))
				.pause(500).build().perform();
		CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//*[@class='nodes-list--tree-wrapper']//*[contains(@class,'data-set-node')])[1]")));
		WebElement expand = CommonFunctionality.getElementByXpath(login.driver,
				"(//*[@class='nodes-list--tree-wrapper']//*[contains(@class,'data-set-node')])[1]", 4);
		if (arg1.equalsIgnoreCase("Expand") && arg2.equalsIgnoreCase("Without")) {
			CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[contains(@class,'data-set-node')][1]//div[@class='toggle']")));
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//*[contains(@class,'data-set-node')][1]//div[@class='toggle']", 4))
					.pause(500).click().build().perform();
			if (expand.getAttribute("class").contains("open")) {
				login.Log4j.info("The Dataset is opened");
			} else {
				fail("Not opened");
			}
		}
		if (arg1.equalsIgnoreCase("Expand") && arg2.equalsIgnoreCase("With")) {
			// CommonFunctionality.getElementByXpath(login.driver, "//*[@class='button
			// button__sm button__text_purple button__block nodes-list--more-button']",
			// 4).click();
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//*[contains(text(),'" + Comparables.section_name + "')]/preceding::div[2]", 4))
					.pause(500).perform();
			(new Actions(login.driver))
					.moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
							".nodes-list--tree-wrapper .svg-checkbox", 4))
					.pause(500).click().pause(500).sendKeys(Keys.chord(Keys.ARROW_RIGHT)).build().perform();
			if (expand.getAttribute("class").contains("open")) {
				login.Log4j.info("The Dataset is opened");
			} else {
				fail("Not opened");
			}
		}
		if (arg1.equalsIgnoreCase("Collapse") && arg2.equalsIgnoreCase("Without")) {
			CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[contains(@class,'data-set-node')][1]//div[@class='toggle']")));
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//*[contains(@class,'data-set-node')][1]//div[@class='toggle']", 4))
					.pause(500).click().build().perform();
			CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[contains(@class,'data-set-node')][1]//div[@class='toggle']")));
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//*[contains(@class,'data-set-node')][1]//div[@class='toggle']", 4))
					.pause(500).click().build().perform();
			if (!expand.getAttribute("class").contains("open")) {
				login.Log4j.info("The Dataset is closed");
			} else {
				fail("Not closed");
			}
		}
		if (arg1.equalsIgnoreCase("Collapse") && arg2.equalsIgnoreCase("With")) {
			// CommonFunctionality.getElementBycssSelector(login.driver,
			// ".nodes-list--more-button", 4).click();
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//*[contains(text(),'" + Comparables.section_name + "')]/preceding::div[2]", 4))
					.pause(500).click().build().perform();
			(new Actions(login.driver))
					.moveToElement(
							CommonFunctionality.getElementBycssSelector(login.driver, ".series-list-item--checkbox", 4))
					.pause(500).click().pause(500).sendKeys(Keys.chord(Keys.ARROW_LEFT)).build().perform();
			if (expand.getAttribute("class").contains("open")) {
				fail("Not closed");
			} else {
				login.Log4j.info("The Dataset is closed");
			}
		}
	}

	@Then("^Clicking on the insight name should open new insight$")
	public void clicking_on_the_insight_name_should_open_new_insight() throws Throwable {
		CommonFunctionality.wait(2000);
		String name_left = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'data-set-node')]//*[contains(@class,'svg-checkbox__selected')]/following::*[@class='series-data-set--table-name'][1]",
				4).getText();
		CommonFunctionality.wait(1000);
		// String series_left = CommonFunctionality.getElementByXpath(login.driver,
		// "//*[contains(@class,'data-set-node')]//*[contains(@class,'svg-checkbox__selected')]/following::*[@class='data-set-node--count'][1]",
		// 10).getText();
		// String[] left_series_count = series_left.split("[^a-zA-Z0-9]");
		String series_left = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='search-input--selected-count']", 4).getText();
		int left_count = Integer.parseInt(series_left);
		login.driver.findElement(By.xpath(
				"//*[@class='growl-message growl-success']//*[@class='button growl-message-content--btns__fill']"))
				.click();
		ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(newTab.get(1));
		String right_series_count = CommonFunctionality
				.getElementByXpath(login.driver, "//span[@class='series-panel--count']//*[@js-series-number='']", 4)
				.getText();
		int right_count = Integer.parseInt(right_series_count);
		String right = CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='series-name-wrapper']//span[@class='group-name'][1]", 4)
				.getText();
		String name_right[] = right.split("\\: ", 2);
		CommonFunctionality.DeleteSeries();
		login.driver.switchTo().window(newTab.get(1)).close();
		login.driver.switchTo().window(newTab.get(0));
		assertEquals(left_count, right_count);
		if (name_right[1].contains(name_left)) {
			System.out.println("New insight with the added series is opened and has been verified successfully");
		} else {
			fail("Verification failed");
		}
	}

	@Then("^The Footnotes window for Dataset should be open$")
	public void the_Footnotes_window_for_Dataset_should_be_open() throws Throwable {
		CommonFunctionality.wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("span[class='footnotes-modal--name'] span")));
		String text = CommonFunctionality
				.getElementBycssSelector(login.driver, "span[class='footnotes-modal--name'] span", 4).getText();
		String actual = text.substring(1, text.length() - 1);
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		assertEquals(actual, series_item_name);
		login.Log4j.info("Footnotes window has been opened correctly and it has been verified successfully");
	}

	@Then("^The related dataset option should present$")
	public void the_related_dataset_option_should_present() throws Throwable {
		List<WebElement> element = login.driver.findElements(By.xpath(
				"//*[@class='related-series-information-portlet--container']//*[@class='series-data-set--table-name']"));
		for (int i = 1; i <= element.size(); i++) {
			String title = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[@class='related-series-information-portlet--container']//*[@class='series-data-set--table-name'])["
							+ i + "]",
					4).getAttribute("title");
			CommonFunctionality.getElementByXpath(login.driver,
					"(//*[@class='related-series-information-portlet--container']//*[@class='series-data-set--table-name'])["
							+ i + "]",
					4).click();
			String text = CommonFunctionality.getElementByClassName(login.driver, "insight-discovery--popup-title", 4)
					.getText();
			String split[] = text.split("\\: ", 2);
			CommonFunctionality.getElementByClassName(login.driver, "insight-discovery--popup-back-button", 4).click();
			assertEquals(split[1], title);
			login.Log4j.info("The Related dataset option is present and it has been verified successfully");
		}
	}

	@Then("^Verify that the series is replaced successfully in right pane$")
	public void verify_that_the_series_is_replaced_successfully_in_right_pane() throws Throwable {
		CommonFunctionality.wait(1000);
		String title = CommonFunctionality.getElementBycssSelector(login.driver, ".visual-title--text.text-dots", 4)
				.getText();
		assertNotEquals(title, ChartVisual.visual_title);
		login.Log4j.info("The series is replaced successfully in right pane");
		CommonFunctionality.Views_list();
	}

	@Then("^The (\\d+) should present on tooltip \"([^\"]*)\"$")
	public void the_should_present_on_tooltip(int arg1, String arg2) throws Throwable {
		String split = CommonFunctionality
				.getElementByXpath(login.driver, "(//tr[@class='series-tooltip-table--row']//td[1])[" + arg1 + "]", 4)
				.getText();
		String[] text = split.split("\\:");
		assertEquals(text[0], arg2);
		login.Log4j.info("The tooltip named " + text[0] + " is present");
	}
}