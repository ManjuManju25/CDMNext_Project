package CDMNext.StepDefinations;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
//import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import CDMNext.util.CommonFunctionality;
//import CDMNext.util.Hooks;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class InsightGeneral {
	Actions action = new Actions(login.driver);
	JavascriptExecutor js = (JavascriptExecutor) login.driver;
	CDMNextSprintCases cv = new CDMNextSprintCases();
	CollabarationSharing cs = new CollabarationSharing();
	SoftAssert sa = new SoftAssert();
	Footnotes f = new Footnotes();
	Comparables com = new Comparables();
	static String random_text;
	static String link_copy;
	ArrayList<String> analysis_insight = new ArrayList<String>();
	ArrayList<String> notification_insight = new ArrayList<String>();
	static String myseries_name;

	public void click_ceic_logo() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 4).click();
	}

	public void switch_to_new_tab() throws Exception {
		ArrayList<String> tabs = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs.get(1));
	}

	public void close_new_tab() {
		ArrayList<String> tabs = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs.get(1)).close();
		login.driver.switchTo().window(tabs.get(0));
	}

	public static void DropFile(File filePath, WebElement target, int offsetX, int offsetY) {
		if (!filePath.exists())
			throw new WebDriverException("File not found: " + filePath.toString());
		// WebDriver driver = ((RemoteWebElement)target).getWrappedDriver();
		JavascriptExecutor jse = (JavascriptExecutor) login.driver;
		WebDriverWait wait = new WebDriverWait(login.driver, 30);

		String JS_DROP_FILE = "var target = arguments[0]," + "    offsetX = arguments[1],"
				+ "    offsetY = arguments[2]," + "    document = target.ownerDocument || document,"
				+ "    window = document.defaultView || window;" + "" + "var input = document.createElement('INPUT');"
				+ "input.type = 'file';" + "input.style.display = 'none';" + "input.onchange = function () {"
				+ "  var rect = target.getBoundingClientRect(),"
				+ "      x = rect.left + (offsetX || (rect.width >> 1)),"
				+ "      y = rect.top + (offsetY || (rect.height >> 1)),"
				+ "      dataTransfer = { files: this.files };" + ""
				+ "  ['dragenter', 'dragover', 'drop'].forEach(function (name) {"
				+ "    var evt = document.createEvent('MouseEvent');"
				+ "    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);"
				+ "    evt.dataTransfer = dataTransfer;" + "    target.dispatchEvent(evt);" + "  });" + ""
				+ "  setTimeout(function () { document.body.removeChild(input); }, 25);" + "};"
				+ "document.body.appendChild(input);" + "return input;";

		WebElement input = (WebElement) jse.executeScript(JS_DROP_FILE, target, offsetX, offsetY);
		input.sendKeys(filePath.getAbsoluteFile().toString());
		wait.until(ExpectedConditions.stalenessOf(input));
	}

	@SuppressWarnings("deprecation")
	public void delete_insight() throws Exception {
		WebElement ele = CommonFunctionality.getElementByProperty(login.driver, "Fav_Insight_Title", 4);
		new Actions(login.driver).moveToElement(ele).pause(500).build().perform();
		CommonFunctionality.getElementByProperty(login.driver, "Ig_del_in", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "Ig_Delete_ok", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "MYINSIGHTS_CLOSE", 4).click();
	}

	public void delete_series() throws Exception {
		CommonFunctionality.getElementByProperty(login.driver, "my_series_filter_checkbox", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "delete_myeries", 4).click();
	}

	public void clearing_search() throws Exception {
		CommonFunctionality.getElementByProperty(login.driver, "Footnote_Search_input", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "Footnote_Search_input", 4).clear();
		CommonFunctionality.getElementByProperty(login.driver, "Footnote_Search_input", 4).sendKeys(Keys.ENTER);
	}

	public void expanding_the_first_database() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "expand_database", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "expand_all", 4).click();
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByProperty(login.driver, "expand_topic", 4).click();
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByProperty(login.driver, "expand_section", 4).click();
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByProperty(login.driver, "expand_table", 4).click();
	}

	@SuppressWarnings("deprecation")
	public void add_Series() throws Throwable {
		clearing_search();
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByProperty(login.driver, "database_tab", 4).click();
		expanding_the_first_database();
		CommonFunctionality.wait(4000);
		CommonFunctionality.getElementByProperty(login.driver, "Ig_seriestoadd", 4).click();
		new Actions(login.driver).pause(500).sendKeys("a").perform();
		CommonFunctionality.getElementByProperty(login.driver, "Ig_secondseriestoadd", 4).click();
		new Actions(login.driver).pause(500).sendKeys("a").perform();
	}

	@SuppressWarnings("deprecation")
	public void delete_all_views() throws Throwable {
		WebElement visual1 = CommonFunctionality.getElementByXpath(login.driver,
				"//a[@class='insight-page-view-tab--link insight-page-view-tab--link__active']", 4);
		new Actions(login.driver).moveToElement(visual1).pause(500).contextClick().build().perform();
		CommonFunctionality.getElementByProperty(login.driver, "Ig_DeleteAllviews", 4).click();
		CommonFunctionality.getElementByXpath(login.driver,
				"/html/body/div[1]/div/div[3]/div[2]/div/div[2]/div/div[2]/button[2]", 4).click();
	}

	public void close_insight() throws Exception {
		CommonFunctionality.getElementByProperty(login.driver, "MYINSIGHTS_CLOSE", 4).click();
	}

	public void open_insight() throws Exception {
		CommonFunctionality.getElementByProperty(login.driver, "insights", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "MY_INSIGHTS", 4).click();
	}

	public void expander() throws Exception {
		CommonFunctionality.getElementByProperty(login.driver, "search_presentation", 4).click();
	}

	@Given("^Verify CEIC logo$")
	public void verify_CEIC_logo() throws Throwable {
		CommonFunctionality.wait(1000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("untitledInsight"))).size() != 0) {
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("applogo"))).size() != 0) {
				login.Log4j.info("CEIC logo is shown");
			} else {
				fail("CEIC logo is not shown");
			}
		} else {
			fail("CEIC logo is not shown");
		}
	}

	@Given("^Creating new insight$")
	public void creating_new_insight() throws Throwable {
		cv.click("File", "New");
		cs.create_a_fresh_insight();
	}

	@Then("^Click on CEIC logo to verify$")
	public void click_on_CEIC_logo_to_verify() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByProperty(login.driver, "applogo", 4).click();
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("untitledInsight"))).size() != 0) {
			System.out.println("User will redirect to landing page");
		} else {
			fail("User failed to  redirect to landing page");
		}
	}

	@Given("^Verify insight title$")
	public void verify_insight_title() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("untitledInsight"))).size() != 0) {
			System.out.println("Insight title is available");
		} else {
			fail("Insight title is not available");
		}
	}

	@SuppressWarnings("deprecation")
	@Given("^Click  insight title$")
	public void click_insight_title() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "untitledInsight", 4).click();
		new Actions(login.driver).sendKeys("test").pause(500).sendKeys(Keys.ENTER).pause(500).build().perform();

	}

	@Given("^Verify insight title change$")
	public void verify_insight_title_change() throws Throwable {
		String insightText = CommonFunctionality
				.getElementBycssSelector(login.driver, ".insight-breadcrumb--title.text-dots", 4).getText();
		assertEquals("test", insightText);
	}

	@And("^My Insights should be loaded$")
	public void my_Insights_should_be_loaded() throws Throwable {
		cv.click_on_my_insights();
		if (login.driver.findElements(By.className("insight-breadcrumb--separator")).size() == 0) {
			System.out.println("My Insights has been clicked successfully");
		} else {
			fail("Verification Failed");
		}
	}

	@SuppressWarnings("deprecation")
	@Given("^Change insight title and verify insight URL after changed insight title$")
	public void change_insight_title_and_verify_insight_URL_after_changed_insight_title() throws Throwable {
		String username = "SR" + new Random().nextInt(1000);
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByProperty(login.driver, "untitledInsight", 4).click();
		new Actions(login.driver).sendKeys(username).pause(500).sendKeys(Keys.ENTER).pause(500).build().perform();
		String actualURL = login.driver.getCurrentUrl();
		URL url = new URL(login.CONFIG.getProperty("testsiteURL"));
		String expectedURL1 = url.getProtocol() + "://" + url.getHost() + "/";
		String expectedURL2 = username;
		String expectedURL3 = "/myseries";
		String expectedURL = expectedURL1 + expectedURL2 + expectedURL3;
		assertEquals(actualURL, expectedURL);
		System.out.println("The insight URL has been verified successfully");
	}

	@SuppressWarnings("deprecation")
	@Given("^Verify insight URL after changed insight title with existing insight title$")
	public void verify_insight_URL_after_changed_insight_title_with_existing_insight_title() throws Throwable {
		WebElement ele = CommonFunctionality.getElementByProperty(login.driver, "untitledInsight", 4);
		String username = "SR" + new Random().nextInt(1000);
		CommonFunctionality.getElementByProperty(login.driver, "untitledInsight", 4).click();
		new Actions(login.driver).moveToElement(ele).pause(500).sendKeys(username).sendKeys(Keys.ENTER).build()
				.perform();
		String actual = login.driver.getCurrentUrl();
		CommonFunctionality.getElementByProperty(login.driver, "file", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "new_insight", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "Ig_InsightTitle", 4).sendKeys(username);
		CommonFunctionality.getElementByProperty(login.driver, "create_insight", 4).click();
		String expected = login.driver.getCurrentUrl();
		assertNotEquals(actual, expected);
		login.Log4j.info(
				"The insight URL after changed insight title with existing insight title has been verified successfully");
	}

	@SuppressWarnings("deprecation")
	@Given("^Verify tooltip for insight title$")
	public void verify_tooltip_for_insight_title() throws Throwable {
		WebElement untitledInsight = CommonFunctionality.getElementByProperty(login.driver, "untitledInsight", 4);
		new Actions(login.driver).moveToElement(untitledInsight).pause(1000).build().perform();
		String insightTitle = untitledInsight.getAttribute("title");
		assertEquals("Click to edit the Insight", insightTitle);
		login.Log4j.info("The tooltip is:" + insightTitle);
	}

	@Given("^Verify tooltip for favorite icon$")
	public void verify_tooltip_for_favorite_icon() throws Throwable {
		WebElement favicon = CommonFunctionality.getElementByProperty(login.driver, "addtofavorite", 4);
		new Actions(login.driver).moveToElement(favicon).build().perform();
		String expectedfavIconText = favicon.getAttribute("title");
		String actualfavIconText = "Add to favorite";
		assertEquals(actualfavIconText, expectedfavIconText);
	}

	@And("^Check for the \"([^\"]*)\" options$")
	public void check_for_the_options(String arg1) throws Throwable {
		String actual = CommonFunctionality
				.getElementBycssSelector(login.driver, ".items-wrapper span[title='" + arg1 + "']", 4)
				.getAttribute("title");
		assertEquals(actual, arg1);
		System.out.println(arg1 + " option is present and verfied successfully");
	}

	@And("^Check for the \"([^\"]*)\" options \"([^\"]*)\"$")
	public void check_for_the_options(String arg1, String arg2) throws Throwable {
		WebElement display = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='items-wrapper']//*[@title='" + arg1 + "']//*[name()='use' and contains(@*,'#actions__" + arg2 + "')]", 4);
		assertEquals(display.isDisplayed(), true);
		System.out.println(arg1 + " icon is displayed and verified successfully");
	}

	@Given("^Click on tag icon$")
	public void click_on_tag_icon() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "tagicon", 4).click();
	}

	@Given("^Verify tag popup is displayed$")
	public void verify_tag_popup_is_displayed() throws Throwable {
		CommonFunctionality.wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("add_tag_popup"))));
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("add_tag_popup"))).size() != 0) {
			System.out.println("Add tag pop up is shown");
			CommonFunctionality.getElementByProperty(login.driver, "TAG_POPUP_CLOSE", 4).click();
		} else {
			CommonFunctionality.getElementByProperty(login.driver, "TAG_POPUP_CLOSE", 4).click();
			fail("Add tag pop up is not shown");
		}
	}

	@Given("^Click on tag icon and enter the tags$")
	public void click_on_tag_icon_and_enter_the_tags() throws Throwable {
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByProperty(login.driver, "tagicon", 4).click();
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByProperty(login.driver, "input_tag_text", 4).sendKeys("Testing");
		CommonFunctionality.getElementByProperty(login.driver, "input_tag_text", 4).sendKeys(Keys.ENTER);
	}

	@SuppressWarnings("deprecation")
	@Given("^Verify tag in insight explorer$")
	public void verify_tag_in_insight_explorer() throws Throwable {
		CommonFunctionality.wait(1000);
		String tagEnter = CommonFunctionality.getElementByProperty(login.driver, "tagText", 4).getText();
		String tagEnter1 = tagEnter.replaceAll("[^a-zA-Z0-9]", "");
		CommonFunctionality.getElementByProperty(login.driver, "tag_save", 4).click();
		CommonFunctionality.getElementByXpath(login.driver, "//a[contains(text(),'My insights')]", 4).click();
		CommonFunctionality.getElementBycssSelector(login.driver, "div[title='View as a grid']", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "ALL_TAG_DROPDOWN", 4).click();
		CommonFunctionality.wait(2000);
		List<WebElement> tags = login.driver.findElements(
				By.xpath("//*[@class='dropdown--body dropdown--body__open']//*[contains(text(),'" + tagEnter1 + "')]"));
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='custom-select--body']//*[contains(text(),'" + tagEnter1 + "')]", 4).click();
		assertEquals(tags.size(), 1);
		System.out.println("Tag is shown in insight explorer");
		// CommonFunctionality.getElementBycssSelector(login.driver,
		// ".custom-select-title--reset-icon", 4).click();
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[@class='insights-control--right-bar']//*[@class='custom-select-title--reset-icon']", 4)
				.click();
		CommonFunctionality.getElementBycssSelector(login.driver,
				".insights-control--wrapper .custom-select-title__reset-hidden .dropdown--icon", 4).click();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(text(),'" + CollabarationSharing.new_insight_name + "')]", 4))
				.pause(1000).build().perform();
		WebElement insight = CommonFunctionality.getElementByXpath(login.driver, "//*[text()='"
				+ CollabarationSharing.new_insight_name + "']/following::*[contains(text(),'Customize')][1]", 4);
		new Actions(login.driver).moveToElement(insight).pause(500).build().perform();
		CommonFunctionality.getElementBycssSelector(login.driver, "div[title='Add Tag']", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "RemoveTag", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "tag_save", 4).click();
	}

	@Given("^Verify Cancel option in tag popup$")
	public void verify_Cancel_option_in_tag_popup() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("add_tag_popup"))).size() != 0) {
			CommonFunctionality.getElementByProperty(login.driver, "TAG_POPUP_CLOSE", 4).click();
			System.out.println("Add tag popup is closed");
		} else {
			fail("Add tag popup is not  closed");
		}
	}

	@Given("^Click on Share icon$")
	public void click_on_Share_icon() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "SHARE_ICON", 4).click();
	}

	@Given("^Verify share popup is shown$")
	public void verify_share_popup_is_shown() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("SHARE_POPUP"))).size() != 0) {
			System.out.println("Share pop up is shown");
			CommonFunctionality.getElementByProperty(login.driver, "Name_Insight_Close", 4).click();
		} else {
			fail("Share pop up is not shown");
		}
	}

	@And("^Save changes is shown$")
	public void save_changes_is_shown() throws Throwable {
		List<WebElement> growl = login.driver.findElements(By.className("growl-messages-container"));
		assertEquals(growl.size(), 1);
		System.out.println("Save option has been verified");
	}

	@And("^Save as changes is shown$")
	public void save_as_changes_is_shown() throws Throwable {
		List<WebElement> save_as = CommonFunctionality.getElementsByXpath(login.driver,
				"//*[contains(@class,'sphere-modal__content')]//*[text()='Copy the Insight']");
		assertEquals(save_as.size(), 1);
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		System.out.println("Save as option has been verified");
	}

	@And("^Verify default insight title on coping insight$")
	public void verify_default_insight_title_on_coping_insight() throws Throwable {
		List<WebElement> save_as = login.driver
				.findElements(By.xpath("//*[contains(@class,'sphere-modal__content')]//*[text()='Copy the Insight']"));
		assertEquals(save_as.size(), 1);
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		System.out.println("Save as option has been verified");
	}

	@SuppressWarnings("deprecation")
	@Given("^Click on Save as,Verify 'Save as' button for untitled insight\\.$")
	public void click_on_Save_as_Verify_Save_as_button_for_untitled_insight() throws Throwable {
		click_ceic_logo();
		String insight = CommonFunctionality.getElementByProperty(login.driver, "Untitled_insight", 4).getText();
		CommonFunctionality.getElementByProperty(login.driver, "SAVE_AS", 4).click();
		WebElement element = CommonFunctionality.getElementByProperty(login.driver, "Untitled_insight", 4);
		new Actions(login.driver).moveToElement(element).click().sendKeys("TEST").pause(500).build().perform();
		new Actions(login.driver).moveToElement(element).click().sendKeys(Keys.ENTER).pause(500).build().perform();
		String updatedInsight = CommonFunctionality.getElementByProperty(login.driver, "Untitled_insight", 4).getText();
		if (!insight.matches(updatedInsight)) {
			System.out.println("Untitled Insight has been updated");
		} else {
			fail("Failed to updated insight");
		}
	}

	@Given("^Click on Share icon for untitled insight$")
	public void click_on_Share_icon_for_untitled_insight() throws Throwable {
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementBycssSelector(login.driver, "div[title='Open File menu']", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "SHARE_ICON", 4).click();
	}

	@Given("^Verify Share for untitled insight\\.$")
	public void verify_Share_for_untitled_insight() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Name_Insight"))).size() != 0) {
			System.out.println("Name insight is shown");
			CommonFunctionality.getElementByProperty(login.driver, "Name_Insight_Close", 4).click();
		} else {
			fail("Name insight is not shown");
		}
	}

	@Given("^Update the untitled insight name$")
	public void update_the_untitled_insight_name() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Name_Insight_input_text", 4).clear();
		CommonFunctionality.getElementByProperty(login.driver, "Name_Insight_input_text", 4).sendKeys("Testing");
		CommonFunctionality.getElementByProperty(login.driver, "Name_Insight_Save", 4).click();
	}

	@Given("^Verify Share pop up is shown$")
	public void verify_Share_pop_up_is_shown() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("SHARE_POPUP"))).size() != 0) {
			System.out.println("Share pop up is shown");
			CommonFunctionality.getElementByProperty(login.driver, "Name_Insight_Close", 4).click();
		} else {
			CommonFunctionality.getElementByProperty(login.driver, "Name_Insight_Close", 4).click();
			fail("Share pop up is not shown");
		}

	}

	@Given("^Verify the insight saved with updated title\\.$")
	public void Verify_the_insight_saved_with_updated_title() throws Throwable {
		CommonFunctionality.getElementBycssSelector(login.driver, "div[title='Copy insight']", 4).click();
		WebElement input = CommonFunctionality.getElementBycssSelector(login.driver, ".insight-copy-text-input", 4);
		new Actions(login.driver).moveToElement(input).sendKeys(Keys.chord(Keys.CONTROL, Keys.BACK_SPACE))
				.sendKeys("Shravas").build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='Copy Insight']", 4).click();
		CommonFunctionality.wait(1000);
		String actual = CommonFunctionality
				.getElementBycssSelector(login.driver, ".insight-breadcrumb--title__editable", 4).getText();
		cs.click_option_from_the_title("Open File menu");
		cs.click_option_from_the_title("View");
		String expected = CommonFunctionality
				.getElementBycssSelector(login.driver, ".insight-preview--title.text-dots", 4).getText();
		CommonFunctionality.getElementByClassName(login.driver, "insight-preview--close", 4).click();
		assertEquals(actual, expected);
	}

	@Given("^Verify that the insight saved with updated title\\.$")
	public void verify_that_the_insight_saved_with_updated_title() throws Throwable {
		CommonFunctionality.getElementBycssSelector(login.driver, "div[title='Open File menu']", 4).click();
		CommonFunctionality.getElementBycssSelector(login.driver, ".items-wrapper span[title='Share']", 4).click();
		WebElement input = CommonFunctionality.getElementBycssSelector(login.driver, "input[class='input-share']", 4);
		input.click();
		input.clear();
		input.sendKeys("Shravas");
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementBycssSelector(login.driver, ".sphere-modal-control.button__primary", 4).click();
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		String actual = CommonFunctionality.getElementBycssSelector(login.driver, ".insight-breadcrumb--title", 4)
				.getText();
		assertEquals(actual, "Shravas");
		System.out.println("The insight title has been changed successfully");
	}

	@Given("^Verify the insight by clicking \"([^\"]*)\" button$")
	public void verify_the_insight_by_clicking_button(String arg1) throws Throwable {
		CommonFunctionality.getElementBycssSelector(login.driver, "div[title='Copy insight']", 4).click();
		boolean button = login.driver.findElement(By.xpath("//*[text()='" + arg1 + "']")).isEnabled();
		if (button == true) {
			login.driver.findElement(By.xpath("//*[text()='" + arg1 + "']")).click();
		}
		Thread.sleep(2000);
		List<WebElement> popup = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Copy_Insight_Pop_Up")));
		if (arg1.equalsIgnoreCase("Copy Insight")) {
			assertEquals(0, popup.size());
			List<WebElement> edit = login.driver.findElements(By.cssSelector("div[title='Click to edit the Insight']"));
			assertEquals(1, edit.size());
		}
		if (arg1.equalsIgnoreCase("Cancel")) {
			assertEquals(0, popup.size());
			List<WebElement> preview_page = login.driver.findElements(By.className("insight-preview--views-wrapper"));
			CommonFunctionality.getElementByClassName(login.driver, "insight-preview--close", 4).click();
			assertEquals(1, preview_page.size());
		}
		System.out.println(arg1 + " functionality has been verified successfully");
	}

	@Given("^Verify insight url updated after insight title changed$")
	public void verify_insight_url_updated_after_insight_title_changed() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Name_Insight_input_text", 4).clear();
		String insightId = "TC" + new Random().nextInt(1000);
		URL url = new URL(login.CONFIG.getProperty("testsiteURL"));
		String str = url.getProtocol() + "://" + url.getHost() + "/";
		String changedurl = str.concat(insightId);
		CommonFunctionality.getElementByProperty(login.driver, "Name_Insight_input_text", 4).sendKeys(insightId);
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByProperty(login.driver, "Name_Insight_Save", 4).click();
		if (CommonFunctionality.getElementsByXpath(login.driver, "//div[@class='sphere-modal__close']").size() > 0) {
			CommonFunctionality.getElementByProperty(login.driver, "Name_Insight_Close", 4).click();
		}
		String currentUrl = login.driver.getCurrentUrl();
		String URL = currentUrl.replaceAll("/myseries", "");
		assertEquals(URL, changedurl);
		System.out.println("The insight URL is updated as changing the insight title.");
	}

	@SuppressWarnings("deprecation")
	@Given("^Click on Edit icon on insight URL field and Verify$")
	public void click_on_Edit_icon_on_insight_URL_field_and_Verify() throws Throwable {
		String insightId1 = "SS" + new Random().nextInt(1000);
		new Actions(login.driver)
				.moveToElement(
						CommonFunctionality.getElementByClassName(login.driver, "friendly-url__input-editable", 4))
				.pause(500).build().perform();
		CommonFunctionality.getElementByClassName(login.driver, "friendly-url__input-icon", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "url", 4).clear();
		CommonFunctionality.getElementBycssSelector(login.driver, "input[class='input-share']", 4).clear();
		CommonFunctionality.getElementBycssSelector(login.driver, "input[class='input-share']", 4).sendKeys(insightId1);
		String actual = CommonFunctionality.getElementByClassName(login.driver, "friendly-url__uneditable", 4)
				.getText();
		String changedurl = actual.concat(insightId1);
		CommonFunctionality.getElementByProperty(login.driver, "Name_Insight_Save", 4).click();
		if (CommonFunctionality.getElementsByXpath(login.driver, "//div[@class='sphere-modal__close']").size() > 0) {
			CommonFunctionality.getElementByProperty(login.driver, "Name_Insight_Close", 4).click();
		}
		String currentUrl = login.driver.getCurrentUrl();
		String URL = currentUrl.replaceAll("/myseries", "");
		assertEquals(URL, changedurl);
		System.out.println("The insight URL updated as per the change.");
	}

	@SuppressWarnings("deprecation")
	@Given("^Verify the alert message while click on edit icon for insight URL change$")
	public void verify_the_alert_message_while_click_on_edit_icon_for_insight_URL_change() throws Throwable {
		WebElement editHover = CommonFunctionality.getElementByProperty(login.driver, "Edit_Hover", 4);
		new Actions(login.driver).moveToElement(editHover).pause(500).build().perform();
		CommonFunctionality.getElementByProperty(login.driver, "Edit_icon", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "url", 4).sendKeys("1");
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Alert_message"))).size() != 0) {
			System.out.println("The alert message is shown");
			CommonFunctionality.getElementByProperty(login.driver, "Name_Insight_Close", 4).click();
		} else {
			fail("The alert message is not shown");
		}
	}

	@Given("^Verify 'Copy' permanent link' option\\.$")
	public void verify_Copy_permanent_link_option() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Name_Insight_input_text", 4).clear();
		CommonFunctionality.getElementByProperty(login.driver, "Name_Insight_input_text", 4).sendKeys("Test");
		CommonFunctionality.getElementByProperty(login.driver, "Insight_Copy_Link", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "Name_Insight_Save", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "Name_Insight_Close", 4).click();
		String InsightCuurentTab = CommonFunctionality.getElementByProperty(login.driver, "Untitled_insight", 4)
				.getText();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		// Switch focus to new tab
		ArrayList<String> tabs = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs.get(1));
		// Launch URL in the new tab
		String InsightNewTab = CommonFunctionality.getElementByProperty(login.driver, "Untitled_insight", 4).getText();
		login.driver.switchTo().window(tabs.get(1)).close();
		login.driver.switchTo().window(tabs.get(0));
		assertEquals(InsightCuurentTab, InsightNewTab);
		System.out.println("Name your Insight loaded successfully");
	}

	@SuppressWarnings("deprecation")
	@Given("^Verify the tooltip for Copy permanent link\\.$")
	public void verify_the_tooltip_for_Copy_permanent_link() throws Throwable {
		WebElement toolTip = CommonFunctionality.getElementByProperty(login.driver, "copy_link_tooltip", 4);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Name_Insight"))).size() != 0) {
			new Actions(login.driver).moveToElement(toolTip).pause(500).build().perform();
			String copyLinkToolTip = toolTip.getAttribute("title");
			CommonFunctionality.getElementByProperty(login.driver, "Name_Insight_Close", 4).click();
			assertEquals("Permanent link is an insight URL that will never be changed.", copyLinkToolTip);
		} else {
			CommonFunctionality.getElementByProperty(login.driver, "Name_Insight_Close", 4).click();
			fail("Tooltip not shown");
		}
	}

	@Given("^Verify disabled save button\\.$")
	public void verify_disabled_save_button() throws Throwable {
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name_Insight_Save"))).isEnabled()) {
			fail("Save button is enabled");
			CommonFunctionality.getElementByProperty(login.driver, "Name_Insight_Close", 4).click();
		} else {
			System.out.println("Save is disabled");
			CommonFunctionality.getElementByProperty(login.driver, "Name_Insight_Close", 4).click();
		}
	}

	@And("^The popup should close$")
	public void the_popup_should_close() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Name_Insight"))).size() != 0) {
			CommonFunctionality.getElementByProperty(login.driver, "Name_Insight_Close", 4).click();
			System.out.println("The pop up is closed");
		} else {
			fail("Fail to close");
		}
	}

	@Given("^Verify Cancel/Dismiss\\(X\\) options for 'Name Insight' popup$")
	public void verify_Cancel_Dismiss_X_options_for_Name_Insight_popup() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Name_Insight"))).size() != 0) {
			CommonFunctionality.getElementByProperty(login.driver, "Name_Insight_Close", 4).click();
			System.out.println("The pop up is closed");
		} else {
			fail("Fail to close");
		}

	}

	@Given("^Click on File menu and Verify$")
	public void click_on_File_menu_and_Verify() throws Throwable {
		WebElement file = CommonFunctionality.getElementByProperty(login.driver, "file", 4);
		file.click();
		String[] file_list = { "View", "Add to favorite", "New", "Open", "Save", "Delete", "Save as", "Refresh",
				"Settings", "Protect", "Download", "Share" };
		List<WebElement> elements = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("file_drpdwn")));
		for (int i = 0; i < file_list.length; i++) {
			String optionValue = elements.get(i).getText();
			if (optionValue.equals(file_list[i])) {
				System.out.println("Passed on: " + optionValue);
			} else {
				fail("Failed on: " + optionValue);
			}
		}
	}

	@Given("^Verify icons for file menu$")
	public void verify_icons_for_file_menu() throws Throwable {
		WebElement file = CommonFunctionality.getElementByProperty(login.driver, "file", 4);
		file.click();
		boolean View_Icon = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("View_Icon"))).isDisplayed();
		boolean Add_To_Favorite_Icon = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("Add_To_Favorite_Icon"))).isDisplayed();
		boolean New_Icon = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("New_Icon"))).isDisplayed();
		boolean Open_Icon = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Open_Icon"))).isDisplayed();
		boolean Save_Icon = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Save_Icon"))).isDisplayed();
		boolean Delete_Icon = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Delete_Icon")))
				.isDisplayed();
		boolean Save_As_Icon = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Save_As_Icon")))
				.isDisplayed();
		boolean Refresh_Icon = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Refresh_Icon")))
				.isDisplayed();
		boolean Settings_Icon = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Settings_Icon")))
				.isDisplayed();
		boolean Protect_Icon = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Protect_Icon")))
				.isDisplayed();
		boolean Download_Icon = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Download_Icon")))
				.isDisplayed();
		boolean Share_Icon = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Share_Icon"))).isDisplayed();
		if (View_Icon == true && Add_To_Favorite_Icon == true && New_Icon == true && Open_Icon == true
				&& Save_Icon == true && Delete_Icon == true && Save_As_Icon == true && Refresh_Icon == true
				&& Settings_Icon == true && Protect_Icon == true && Download_Icon == true && Share_Icon == true) {
			System.out.println("Icons are displayed for all options");
			CommonFunctionality.getElementByProperty(login.driver, "file", 4).click();
		} else {
			fail("Icons not displayed for options");
		}
	}

	@And("^The Email template should be opened with auto filled email ID \"([^\"]*)\"$")
	public void the_Email_template_should_be_opened_with_auto_filled_email_ID(String arg1) throws Throwable {
		String text = CommonFunctionality
				.getElementByXpath(login.driver, "//a[contains(text(),'our help desk team')]", 4).getAttribute("href");
		String split[] = text.split("\\:");
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='sphere-modal__close']", 4).click();
		assertEquals(split[1], arg1);
		System.out.println("The email template is verified successfully");
	}

	@Given("^Click on File menu$")
	public void click_on_File_menu() throws Throwable {
		cs.click_option_from_the_title("Open File menu");
	}

	@And("^List of (\\d+) recent opened insights should be displayed$")
	public void list_of_recent_opened_insights_should_be_displayed(int arg1) throws Throwable {
		List<WebElement> insights = login.driver
				.findElements(By.xpath("//*[@class='recent-insight-sub-menu-item-view']"));
		if (arg1 == 1) {
			String expected = login.driver
					.findElement(By.xpath("(//*[@class='recent-insight-sub-menu-item-view'])[1]/div"))
					.getAttribute("title");
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("(//*[@class='recent-insight-sub-menu-item-view'])[1]")).click();
			Thread.sleep(500);
			String actual = login.driver.findElement(By.cssSelector(".insight-breadcrumb--title.text-dots")).getText();
			assertEquals(actual, expected);
			System.out.println("First insight is verified successfully");
		} else {
			assertEquals(insights.size(), arg1);
			System.out.println(arg1 + " insights are displayed");
		}
	}

	@And("^List of recent opened insights should be displayed$")
	public void list_of_recent_opened_insights_should_be_displayed() throws Throwable {
		List<WebElement> insights = login.driver
				.findElements(By.xpath("//*[@class='recent-insight-sub-menu-item-view']"));
		if (!(insights.size() > 0)) {
			fail("Verification Failed");
		}
	}

	@Given("^Click on View option and Verify$")
	public void click_on_View_option_and_Verify() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "View_Btn", 4).click();
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Preview"))).size() != 0) {
			System.out.println("Insight opened in Preview mode");
			CommonFunctionality.getElementByProperty(login.driver, "Ig_Preview_Close", 4).click();
		} else {
			CommonFunctionality.getElementByProperty(login.driver, "Ig_Preview_Close", 4).click();
			fail("Insight not opened in Preview mode");
		}
	}

	@Given("^Insight should not be editable$")
	public void insight_should_not_be_editable() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='insight-preview--body']//*[@data-name='title']", 4)
				.click();
		WebElement delete = login.driver
				.findElement(By.cssSelector(".insight-preview--views div[data-action='delete']"));
		if (delete.getAttribute("class").contains("hide")) {
			System.out.println("Insight is not editable");
		} else {
			fail("Verification Failed");
		}
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close"))).size() > 0) {
			CommonFunctionality.getElementByProperty(login.driver, "Ig_Preview_Close", 4).click();
		}
	}

	@Given("^Insight popup should close on clicking Open icon$")
	public void insight_popup_should_close_on_clicking_Open_icon() throws Throwable {
		if (login.driver.findElements(By.cssSelector("div[title='Customize insight']")).size() > 0) {
			CommonFunctionality.getElementBycssSelector(login.driver, "div[title='Customize insight']", 4).click();
		} else {
			fail("Unable to click");
		}
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close"))).size() == 0) {
			System.out.println("Insight Preview popup is auto closed");
		} else {
			fail("Verification Failed");
		}
	}

	@And("^Verify \"([^\"]*)\" to favorite option$")
	public void verify_to_favorite_option(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Add")) {
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='items-wrapper']//*[@title='Add to favorite']", 4)
					.click();
			String insight_title = CommonFunctionality
					.getElementBycssSelector(login.driver, ".insight-breadcrumb--title", 4).getText();
			cv.click_on_my_insights();
			CommonFunctionality.getElementBycssSelector(login.driver, "div[data-tab='favorite']", 4).click();
			CommonFunctionality.getElementBycssSelector(login.driver, "div[title='View as a grid']", 4).click();
			String fav_title = CommonFunctionality
					.getElementBycssSelector(login.driver, ".insight-grid-item--bottom-panel-title", 4).getText();
			assertEquals(insight_title, fav_title);
			System.out.println("Title matched");
			CommonFunctionality.getElementBycssSelector(login.driver, "div[data-tab='my']", 4).click();
		}
		if (arg1.equalsIgnoreCase("Remove")) {
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='items-wrapper']//*[@title='Add to favorite']", 4)
					.click();
			click_on_File_menu();
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='items-wrapper']//*[@title='Remove from favorite'] | //*[@class='items-wrapper']//*[@title='Add to favorite']",
					4).click();
			String insight_title = CommonFunctionality
					.getElementBycssSelector(login.driver, ".insight-breadcrumb--title", 4).getText();
			cv.click_on_my_insights();
			CommonFunctionality.getElementBycssSelector(login.driver, "div[data-tab='favorite']", 4).click();
			List<WebElement> insights = login.driver.findElements(By.xpath("//*[text()='" + insight_title + "']"));
			assertEquals(insights.size(), 0);
			System.out.println("Removed from favorites");
			CommonFunctionality.getElementBycssSelector(login.driver, "div[data-tab='my']", 4).click();
		}
	}

	@Given("^Click on Add to favorite option and Verify$")
	public void click_on_Add_to_favorite_option_and_Verify() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Add_To_Favorite_Icon", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "insights", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "Favorites", 4).click();
		String Fav_Insight_Title = CommonFunctionality.getElementByProperty(login.driver, "Fav_Insight_Title", 4)
				.getAttribute("title");
		String Insight_Title = CommonFunctionality.getElementByProperty(login.driver, "Untitled_insight", 4).getText();
		CommonFunctionality.getElementByProperty(login.driver, "MYINSIGHTS_CLOSE", 4).click();
		sa.assertEquals(Insight_Title, Fav_Insight_Title);
		System.out.println("The insight is shown in favorite list");
		click_on_File_menu();
		CommonFunctionality.getElementByProperty(login.driver, "Remove_Fav", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "insights", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "Favorites", 4).click();
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Fav_Insight_Empty"))).size() != 0) {
			System.out.println("The insight is removed from favorite list");
			CommonFunctionality.getElementByProperty(login.driver, "MYINSIGHTS_CLOSE", 4).click();
		} else {
			CommonFunctionality.getElementByProperty(login.driver, "MYINSIGHTS_CLOSE", 4).click();
			fail("The insight is still shown in favorite list");
		}
	}

	@Given("^Click on View option$")
	public void click_on_View_option() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "View_Btn", 4).click();
	}

	@Given("^Verify 'Open' option in insight preview$")
	public void verify_Open_option_in_insight_preview() throws Throwable {
		String InsightCurrentTab = CommonFunctionality.getElementByProperty(login.driver, "Untitled_insight", 4)
				.getText();
		CommonFunctionality.getElementByProperty(login.driver, "open_icon", 4).click();
		ArrayList<String> tabs = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs.get(1));
		String InsightNewTab = CommonFunctionality.getElementByProperty(login.driver, "Untitled_insight", 4).getText();
		login.driver.switchTo().window(tabs.get(1)).close();
		login.driver.switchTo().window(tabs.get(0));
		if (CommonFunctionality.getElementsByXpath(login.driver, "//div[@class='insight-context-menu--menu-icon']")
				.size() > 0) {
			CommonFunctionality.getElementByProperty(login.driver, "file", 4).click();
		}
		sa.assertEquals(InsightCurrentTab, InsightNewTab);
		System.out.println("The insight opened with new browser tab");
	}

	@Given("^Click on Copy button$")
	public void click_on_Copy_button() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Copy_Insight", 4).click();
	}

	@Given("^Verify 'Copy' option in insight preview\\.$")
	public void verify_Copy_option_in_insight_preview() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Copy_Insight_Pop_Up"))).size() != 0) {
			CommonFunctionality.getElementByProperty(login.driver, "fav_insight_close", 4).click();
			CommonFunctionality.getElementByProperty(login.driver, "Ig_Preview_Close", 4).click();
			System.out.println("Copy insight pop up is displayed");
		} else {
			CommonFunctionality.getElementByProperty(login.driver, "fav_insight_close", 4).click();
			CommonFunctionality.getElementByProperty(login.driver, "Ig_Preview_Close", 4).click();
			fail("Copy insight pop up is not displayed");
		}
	}

	@Given("^Create insight$")
	public void create_insight() throws Throwable {
		click_on_File_menu();
		CommonFunctionality.getElementByProperty(login.driver, "new_insight", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "Insight_Text_Enter", 4).clear();
		CommonFunctionality.getElementByProperty(login.driver, "Insight_Text_Enter", 4).sendKeys("TEST");
		CommonFunctionality.getElementByProperty(login.driver, "create_insight", 4).click();
	}

	@Given("^Verify default insight title while coping insight\\.$")
	public void verify_default_insight_title_while_coping_insight() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Copy_Insight_Button", 4).click();
		String strValidate = CollabarationSharing.new_insight_name + "_copy";
		CommonFunctionality.wait(1000);
		String copied_insight = CommonFunctionality.getElementByProperty(login.driver, "Untitled_insight", 4).getText();
		assertEquals(copied_insight, strValidate);
		login.Log4j.info("Default Insight title verified");
	}

	@And("^Verify Insight title update in Copy the insight popup$")
	public void verify_Insight_title_update_in_Copy_the_insight_popup() throws Throwable {
		CommonFunctionality.getElementBycssSelector(login.driver, ".insight-copy-text-input.block.form--control", 4)
				.clear();
		CommonFunctionality.getElementBycssSelector(login.driver, ".insight-copy-text-input.block.form--control", 4)
				.sendKeys("TEST");
		boolean copy_insight = login.driver.findElement(By.cssSelector(".sphere-modal-control.button__primary"))
				.isEnabled();
		if (copy_insight == true) {
			System.out.println("Insight title updated");
		} else {
			fail("Verification Failed");
		}
		CommonFunctionality.getElementBycssSelector(login.driver, ".sphere-modal-control.button__primary", 4).click();
	}

	@And("^Verify Copy insight button$")
	public void verify_Copy_insight_button() throws Throwable {
		String strValidate = CollabarationSharing.new_insight_name + "_copy";
		boolean copy_insight = login.driver.findElement(By.cssSelector(".sphere-modal-control.button__primary"))
				.isEnabled();
		if (copy_insight == false) {
			fail("Verification Failed");
		}
		login.driver.findElement(By.cssSelector(".sphere-modal-control.button__primary")).click();
		CommonFunctionality.wait(1000);
		String expected = CommonFunctionality
				.getElementBycssSelector(login.driver, ".insight-breadcrumb--title-block.text-dots", 4).getText();
		assertEquals(strValidate, expected);
		System.out.println("Copy button is verified");
	}

	@Given("^Verify changing title while coping insight\\.$")
	public void verify_changing_title_while_coping_insight() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Copy_Insight_Button", 4).click();
		CommonFunctionality.getElementBycssSelector(login.driver, ".insight-copy-text-input block", 4).clear();
		CommonFunctionality.getElementBycssSelector(login.driver, ".insight-copy-text-input block", 4)
				.sendKeys("Shravas");
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='Copy Insight']", 4).click();
		String copied_insight = CommonFunctionality.getElementByProperty(login.driver, "Untitled_insight", 4).getText();
		click_on_File_menu();
		cs.click_option_from_the_title("View");
		String expected = CommonFunctionality
				.getElementBycssSelector(login.driver, ".insight-preview--title.text-dots", 4).getText();
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close"))).size() > 0) {
			CommonFunctionality.getElementByProperty(login.driver, "Ig_Preview_Close", 4).click();
		}
		assertEquals(copied_insight, "Shravas");
		assertEquals(copied_insight, expected);
		System.out.println("Changing the insight title is reflecting next time on clicking view option");
	}

	@Given("^Verify 'Cancel' button for 'Copy the insight' popup\\.$")
	public void verify_Cancel_button_for_Copy_the_insight_popup() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Copy_Insight_Pop_Up"))).size() != 0) {
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Copy_Cancel"))).size() != 0) {
				CommonFunctionality.getElementByProperty(login.driver, "Ig_Copy_Cancel", 4).click();
				CommonFunctionality.getElementByProperty(login.driver, "Ig_Preview_Close", 4).click();
				System.out.println("The copy pop up will be closed");
			} else {
				CommonFunctionality.getElementByProperty(login.driver, "Ig_Copy_Cancel", 4).click();
				CommonFunctionality.getElementByProperty(login.driver, "Ig_Preview_Close", 4).click();
				fail("The copy pop up will not be closed");
			}
		}
	}

	@Given("^Verify 'Download' option in insight preview without visual$")
	public void verify_Download_option_in_insight_preview_without_visual() throws Throwable {
		CommonFunctionality.wait(2000);
		List<WebElement> download = login.driver
				.findElements(By.xpath("//div[@class='insight-preview--header']/div[2]/div[3]/button"));
		for (WebElement d : download) {
			if (d.getAttribute("class").contains("button__disabled")) {
				CommonFunctionality.getElementByProperty(login.driver, "Ig_Preview_Close", 4).click();
				System.out.println("Download option is disabled");
			} else {
				CommonFunctionality.getElementByProperty(login.driver, "Ig_Preview_Close", 4).click();
				fail("Download option is not disabled");
			}
		}
	}

	@SuppressWarnings("deprecation")
	@Given("^Create Visual$")
	public void create_Visual() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByProperty(login.driver, "Series_new", 4).click();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"(//*[contains(@class,'series-list-item--checkbox')])[1]//span", 4))
				.pause(500).click().build().perform();
		new Actions(login.driver).pause(500).sendKeys("c").build().perform();
		CommonFunctionality.wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector(".visual-top-panel--left-controls .button__primary")));
	}

	@SuppressWarnings("deprecation")
	@Given("^Search for related insight series$")
	public void search_for_related_insight_series() throws Throwable {
		CommonFunctionality.wait(1000);
		cv.search_for_the_series_with_SID("279629203");
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='search-series-list']/*[1]/div/a/div[2]/span", 4))
				.pause(500).click().sendKeys("c").build().perform();
		cv.click_on_my_insights();
		cv.click_option_from_empty_list("View as a table");
		new Actions(login.driver).keyDown(Keys.CONTROL)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"(//*[not(contains(@data-id,'Untitled-insight'))]/following::*[text()='"
								+ CollabarationSharing.new_insight_name
								+ "'])[1]//following::div[@class='insight-table-item--info'][1]",
						4))
				.pause(200).click().build().perform();
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
				"(//*[not(contains(@data-id,'Untitled-insight'))]/following::*[contains(@class,'insight-table-item--title-link')])[2]//following::div[@class='insight-table-item--info'][1]",
				4)).pause(200).click().keyUp(Keys.CONTROL).build().perform();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"(//*[contains(@class,'insight-table-item--options')])[2]", 4))
				.pause(200).contextClick().build().perform();
		CommonFunctionality
				.getElementBycssSelector(login.driver, "div[class='items-wrapper'] span[title='Add tags']", 4).click();
		CommonFunctionality.getElementBycssSelector(login.driver, "input[placeholder='Enter tags ...']", 4).click();
		CommonFunctionality.getElementBycssSelector(login.driver, "input[placeholder='Enter tags ...']", 4)
				.sendKeys("Related Insights");
		CommonFunctionality.getElementBycssSelector(login.driver, ".sphere-modal-control.button__primary", 4).click();
		cv.click_option_from_empty_list("View as a grid");
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(text(),'" + CollabarationSharing.new_insight_name + "')]", 4))
				.pause(1000).build().perform();
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[text()='" + CollabarationSharing.new_insight_name
						+ "']/following::*[contains(text(),'Customize')][1] | //*[text()='"
						+ CollabarationSharing.new_insight_name + "']/following::*[contains(text(),'Open')][1]",
				4).click();
	}

	@Given("^Click on View$")
	public void click_on_View() throws Throwable {
		click_on_File_menu();
		click_on_View_option();
	}

	@Given("^Click on Download$")
	public void click_on_Download() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Ig_Download", 4).click();
	}

	@SuppressWarnings("deprecation")
	@Given("^Verify 'Download' option in insight preview with visual$")
	public void verify_Download_option_in_insight_preview_with_visual() throws Throwable {
		CommonFunctionality.wait(3000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Downloadpopup"))).size() != 0) {
			System.out.println("Download pop up is shown");
			CommonFunctionality.getElementByProperty(login.driver, "MYINSIGHTS_CLOSE", 4).click();
			CommonFunctionality.getElementByProperty(login.driver, "Ig_Preview_Close", 4).click();
			new Actions(login.driver)
					.moveToElement(
							CommonFunctionality.getElementByClassName(login.driver, "insight-page-view-tab--title", 4))
					.contextClick().pause(500).build().perform();
			CommonFunctionality
					.getElementBycssSelector(login.driver, "div[class='items-wrapper'] span[title='Delete view']", 4)
					.click();
			CommonFunctionality.getElementByProperty(login.driver, "Ig_visual_confirm", 4).click();
		} else {
			CommonFunctionality.getElementByProperty(login.driver, "MYINSIGHTS_CLOSE", 4).click();
			CommonFunctionality.getElementByProperty(login.driver, "Ig_Preview_Close", 4).click();
			fail("Download pop up is not shown");
			CommonFunctionality.getElementByProperty(login.driver, "Ig_Delete_Visual", 4).click();
			CommonFunctionality.getElementByProperty(login.driver, "Ig_visual_confirm", 4).click();
		}
		CommonFunctionality.DeleteSeries();
	}

	@Given("^Click on Maximize button$")
	public void click_on_Maximize_button() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--action__toggle']", 4)
				.click();
	}

	@Given("^Verify 'Maximize' option in insight preview$")
	public void verify_Maximize_option_in_insight_preview() throws Throwable {
		WebElement maximize = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='insight-preview--action__toggle']/ancestor::div[5]", 4);
		if (!maximize.getAttribute("class").contains("insight-preview__expanded")) {
			System.out.println("The insight is maximized");
			CommonFunctionality.getElementByProperty(login.driver, "Ig_Preview_Close", 4).click();
		} else {
			CommonFunctionality.getElementByProperty(login.driver, "Ig_Preview_Close", 4).click();
			fail("The insight is not maximized");
		}
	}

	@Given("^Verify 'Restore down' option in insight preview\\.$")
	public void verify_Restore_down_option_in_insight_preview() throws Throwable {
		CommonFunctionality.getElementByClassName(login.driver, "insight-preview--action__toggle", 4).click();
		Thread.sleep(500);
		WebElement maximize = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='insight-preview--action__toggle']/ancestor::div[5]", 4);
		if (maximize.getAttribute("class").contains("insight-preview__expanded")) {
			System.out.println("The insight restored to previous size");
			CommonFunctionality.getElementByProperty(login.driver, "Ig_Preview_Close", 4).click();
		} else {
			CommonFunctionality.getElementByProperty(login.driver, "Ig_Preview_Close", 4).click();
			fail("The insight not restored to previous size");
		}
	}

	@Given("^Verify Cancel option for insight preview popup\\.$")
	public void verify_Cancel_option_for_insight_preview_popup() throws Throwable {
		CommonFunctionality.wait(1000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Preview"))).size() != 0) {
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Preview"))).size() != 0) {
				CommonFunctionality.getElementByProperty(login.driver, "Ig_Preview_Close", 4).click();
				List<WebElement> preview_page = login.driver
						.findElements(By.className("insight-preview--views-wrapper"));
				System.out.println("The preview is closed");
				CommonFunctionality.wait(1000);
				assertEquals(0, preview_page.size());
			} else {
				CommonFunctionality.getElementByProperty(login.driver, "Ig_Preview_Close", 4).click();
				Assert.fail("The preview is not closed");
			}
		}
	}

	@Given("^Click on Related Insights$")
	public void click_on_Related_Insights() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Ig_Relatedinsights", 4).click();
	}

	@Given("^Verify Related Insights in insight preview\\.$")
	public void verify_Related_Insights_in_insight_preview() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Related_Insight_pane"))).size() != 0) {
			CommonFunctionality.getElementByClassName(login.driver, "related-insights--toggle", 4).click();
			List<WebElement> related = login.driver.findElements(By.className("related-insight-item"));
			if (related.size() > 0) {
				System.out.println("Related insights are shown");
				CommonFunctionality.getElementByProperty(login.driver, "Ig_Preview_Close", 4).click();
			} else {
				fail("Related Insights failed");
			}
		} else {
			CommonFunctionality.getElementByProperty(login.driver, "Ig_Preview_Close", 4).click();
			fail("Related insights is not shown");
		}
	}

	@Given("^Click on New$")
	public void click_on_New() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "new_insight", 4).click();
	}

	@Given("^Verify New option\\.$")
	public void verify_New_option() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Create_Insight_popup"))).size() != 0) {
			CommonFunctionality.getElementByProperty(login.driver, "MYINSIGHTS_CLOSE", 4).click();
			System.out.println("'Create insight' popup is displayed");
		} else {
			CommonFunctionality.getElementByProperty(login.driver, "MYINSIGHTS_CLOSE", 4).click();
			fail("'Create insight' popup is not displayed");
		}
	}

	@Given("^Verify auto title for Create insight\\.$")
	public void verify_auto_title_for_Create_insight() throws Throwable {
		String insightTitle = CommonFunctionality.getElementByProperty(login.driver, "Ig_InsightTitle", 4)
				.getAttribute("value");
		if (insightTitle.contains("Insight")) {
			CommonFunctionality.getElementByProperty(login.driver, "MYINSIGHTS_CLOSE", 4).click();
			System.out.println("Autotitle is shown");
		} else {
			CommonFunctionality.getElementByProperty(login.driver, "MYINSIGHTS_CLOSE", 4).click();
			fail("Autotitle is not  shown");
		}
	}

	@Given("^Verify 'Create insight' button\\.$")
	public void verify_Create_insight_button() throws Throwable {
		CommonFunctionality.wait(500);
		String newInsight = CommonFunctionality.getElementByProperty(login.driver, "Ig_InsightTitle", 4)
				.getAttribute("value");
		CommonFunctionality.getElementByProperty(login.driver, "create_insight", 4).click();
		CommonFunctionality.wait(500);
		String insightTitle = CommonFunctionality
				.getElementBycssSelector(login.driver, ".insight-breadcrumb--title.text-dots", 4).getText();
		assertEquals(newInsight, insightTitle);
		System.out.println("Creating an insight has been verified");
	}

	@Given("^Verify 'Cancel' button for new insight popup\\.$")
	public void verify_Cancel_button_for_new_insight_popup() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Create_Insight_popup"))).size() != 0) {
			CommonFunctionality.getElementByProperty(login.driver, "MYINSIGHTS_CLOSE", 4).click();
			System.out.println("'Create insight' popup is closed");
		} else {
			CommonFunctionality.getElementByProperty(login.driver, "MYINSIGHTS_CLOSE", 4).click();
			fail("'Create insight' popup is not closed");
		}
	}

	@Given("^Click on Open$")
	public void click_on_Open() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Open_Icon", 4).click();
	}

	@Given("^Verify 'Open' option\\.$")
	public void verify_Open_option() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Insightexplorer_Win"))).size() != 0) {
			CommonFunctionality.getElementByProperty(login.driver, "MYINSIGHTS_CLOSE", 4).click();
			System.out.println("Insight explorer window is open");
		} else {
			CommonFunctionality.getElementByProperty(login.driver, "MYINSIGHTS_CLOSE", 4).click();
			fail("Insight explorer window is not open");
		}
	}

	@Given("^Click on My insights tab and close$")
	public void click_on_My_insights_tab_and_close() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Ig_Myinsights", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "MYINSIGHTS_CLOSE", 4).click();
	}

	@Given("^Verify default tab for open\\.$")
	public void verify_default_tab_for_open() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_my_insights_selected"))).size() != 0) {
			CommonFunctionality.getElementByProperty(login.driver, "MYINSIGHTS_CLOSE", 4).click();
			System.out.println("The last visited tab is open");
		} else {
			CommonFunctionality.getElementByProperty(login.driver, "MYINSIGHTS_CLOSE", 4).click();
			fail("The last visited tab is not open");
		}
	}

	@Given("^Verify Dismiss button for insight explorer modal popup\\.$")
	public void verify_Dismiss_button_for_insight_explorer_modal_popup() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Insightexplorer_Win"))).size() != 0) {
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).size() != 0) {
				CommonFunctionality.getElementByProperty(login.driver, "MYINSIGHTS_CLOSE", 4).click();
				System.out.println("The insight explorer window is closed");
			} else {
				CommonFunctionality.getElementByProperty(login.driver, "MYINSIGHTS_CLOSE", 4).click();
				fail("The insight explorer window is not closed");
			}
		}
	}

	@Given("^Click on Save$")
	public void click_on_Save() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Ig_Save_Changes", 4).click();
	}

	@Given("^Verify 'Save' option\\.$")
	public void verify_Save_option() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Save_Message_text"))).size() != 0) {
			System.out.println("'Changes saved' growl message is displayed.");
		} else {
			fail("'Changes saved' growl message is not displayed.");
		}
	}

	@Given("^Click on Delete$")
	public void click_on_Delete() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Ig_Delete_Btn", 4).click();
	}

	@Given("^Verify Delete option\\.$")
	public void verify_Delete_option() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Delete_insight_popup"))).size() != 0) {
			System.out.println("The Delete insight confirmation popup is shown");
			CommonFunctionality.getElementByProperty(login.driver, "MYINSIGHTS_CLOSE", 4).click();
		} else {
			fail("The Delete insight confirmation popup is not shown");
			CommonFunctionality.getElementByProperty(login.driver, "MYINSIGHTS_CLOSE", 4).click();
		}
	}

	@Given("^Verify Popup header for delete\\.$")
	public void verify_Popup_header_for_delete() throws Throwable {
		String deletePopup = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Delete_insight_popup")))
				.getText();
		String delete = "Delete insight?";
		if (deletePopup.equalsIgnoreCase(delete)) {

			System.out.println("The popup header 'Delete Insight?' is shown");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
		} else {

			Assert.fail("The popup header 'Delete Insight?' is not  shown");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
		}
	}

	// Tc_InsightGeneral_48
	@Given("^Verify description for delete confirmation popup\\.$")
	public void verify_description_for_delete_confirmation_popup() throws Throwable {
		
		String deleteMess = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Delete_conf_mess")))
				.getAttribute("innerHTML");
		String deletemessExpected = "Are you sure you want to delete the insight";
		String delMessage = deleteMess.replaceAll("//D", "").trim().replaceAll("\n", "").trim()
				.replaceAll("\\<.*?>", "").trim();
		login.Log4j.info(delMessage);
		login.Log4j.info(deletemessExpected);
		if (delMessage.contains(deletemessExpected)) {

			System.out.println("The Description message is shown");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
		} else {

			Assert.fail("The Description message is not shown");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
		}
	}

	@Given("^Verify Delete forever button\\.$")
	public void verify_Delete_forever_button() throws Throwable {
		creating_new_insight();
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementBycssSelector(login.driver, "div[title='Open File menu']", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "Ig_Delete_Btn", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "Ig_Delete_ok", 4).click();
		CommonFunctionality.webDriverwait_locator("growl-message-content", "classname");
		CommonFunctionality.wait(3000);
		String untitledinsight = CommonFunctionality.getElementByProperty(login.driver, "Untitled_insight", 4)
				.getText();
		assertEquals(untitledinsight, "Name your insight");
		System.out.println("The insight is deleted forever");
	}

	@SuppressWarnings("deprecation")
	@And("^The Edit icon should be displayed and URL should be selected when click on it$")
	public void the_Edit_icon_should_be_displayed_and_URL_should_be_selected_when_click_on_it() throws Throwable {
		if (login.driver
				.findElements(By.xpath("//*[@class='modal-header sphere-modal__header']//*[text()='Insight settings']"))
				.size() > 0) {
			String insight_name = CommonFunctionality
					.getElementByXpath(login.driver, "(//*[contains(@class,'insight-settings--input-field')])[1]", 4)
					.getAttribute("value");
			assertEquals(CollabarationSharing.new_insight_name, insight_name);
			new Actions(login.driver)
					.moveToElement(
							CommonFunctionality.getElementByClassName(login.driver, "friendly-url__input-editable", 4))
					.pause(1000).build().perform();
			WebElement edit = login.driver.findElement(By.className("friendly-url__input-icon"));
			if (edit.isDisplayed()) {
				System.out.println("Edit option is displayed");
				edit.click();
			} else {
				fail("Edit option not displayed");
			}
			WebElement friendlyURL = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='friendly-url__input-icon']/ancestor::div[3]", 4);
			if (friendlyURL.getAttribute("class").contains("edit")) {
				System.out.println("Edit allowed");
			} else {
				fail("Edit not allowed");
			}
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		} else {
			fail("Popup is not displayed");
		}
	}

	@SuppressWarnings("deprecation")
	@And("^The URL should be changed as per updated$")
	public void the_URL_should_be_changed_as_per_updated() throws Throwable {
		String text = "Shravas" + new Random().nextInt(1000);
		new Actions(login.driver)
				.moveToElement(
						CommonFunctionality.getElementByClassName(login.driver, "friendly-url__input-editable", 4))
				.pause(1000).build().perform();
		CommonFunctionality.getElementByClassName(login.driver, "friendly-url__input-icon", 4).click();
		Thread.sleep(500);
		new Actions(login.driver)
				.moveToElement(
						CommonFunctionality.getElementByClassName(login.driver, "friendly-url__input-editable", 4))
				.sendKeys(Keys.chord(Keys.CONTROL, "a")).sendKeys(Keys.BACK_SPACE).pause(500).sendKeys(text).pause(500)
				.build().perform();
		CommonFunctionality.getElementBycssSelector(login.driver, ".button__secondary_purple", 4).click();
		Thread.sleep(200);
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		click_on_File_menu();
		click_on_Settings();
		String expected = CommonFunctionality.getElementByClassName(login.driver, "friendly-url__input-editable", 4)
				.getAttribute("value");
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		assertEquals(text, expected);
		System.out.println("The URL has been changed as per updated");
	}

	@And("^The default landing page should be loaded as set in the preference$")
	public void the_default_landing_page_should_be_loaded_as_set_in_the_preference() throws Throwable {
		verify_Delete_forever_button();
		String expected = login.driver.getCurrentUrl();
		if (expected.contains("/Untitled-insight/myseries")) {
			System.out.println("The default landing page is loaded");
		} else {
			fail("Verification Failed");
		}
	}

	@Given("^Click on 'Save as'$")
	public void click_on_Save_as() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_save_as_btn"))).click();
		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Copy_Insight_Pop_Up"))).size() != 0) {

			System.out.println("'Copy the insight' popup is displayed");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
		} else {

			Assert.fail("'Copy the insight' popup is not displayed");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
		}

	}

	// Tc_InsightGeneral_51
	@Given("^Click on 'Save as' and Verify default insight title while coping insight$")
	public void click_on_Save_as_and_Verify_default_insight_title_while_coping_insight() throws Throwable {
		create_insight();
		click_on_File_menu();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_save_as_btn"))).click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_Insight_Button"))).click();
		Thread.sleep(6000);
		String strValidate = "TEST_copy";
		String copied_insight = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Untitled_insight")))
				.getText();
		if (copied_insight.contains(strValidate)) {
			System.out.println(copied_insight);

		} else {

			Assert.fail("Insight not copied");
		}

	}

	// Tc_InsightGeneral_52
	@Given("^Click on Save As$")
	public void click_on_Save_As() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_save_as_btn"))).click();
		Thread.sleep(3000);
	}

	@Given("^Verify 'Cancel/X' button for 'Copy the insight' popup\\.$")
	public void verify_Cancel_X_button_for_Copy_the_insight_popup() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Copy_Insight_Pop_Up"))).size() != 0) {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
			System.out.println("The pop up is closed");
		} else {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
			Assert.fail("Fail to close");
		}
	}

	@Given("^Click on Add views$")
	public void click_on_Add_views() throws Throwable {
		CommonFunctionality.wait(1000);
		// CommonFunctionality.getElementByXpath(login.driver,
		// "//*[@data-id='myseries']", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "Ig_addview_btn", 4).click();
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByProperty(login.driver, "Ig_addview_btn", 4).click();
		CommonFunctionality.wait(1000);
	}

	@Given("^Click on Refresh$")
	public void click_on_Refresh() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Ig_Refresh_btn", 4).click();
	}

	@SuppressWarnings("deprecation")
	@Given("^Verify Refresh option\\.$")
	public void verify_Refresh_option() throws Throwable {
		String Title = CommonFunctionality.getElementByProperty(login.driver, "Ig_viewtab_active", 4)
				.getAttribute("title");
		if (Title.equalsIgnoreCase("View 1")) {
			System.out.println("The panel is refreshed");
			WebElement visual = CommonFunctionality.getElementByProperty(login.driver, "Ig_Visual", 4);
			new Actions(login.driver).moveToElement(visual).pause(1000).contextClick().build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "Ig_DeleteAllviews", 4).click();
		} else {
			WebElement visual = CommonFunctionality.getElementByProperty(login.driver, "Ig_Visual", 4);
			new Actions(login.driver).moveToElement(visual).pause(1000).contextClick().build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "Ig_DeleteAllviews", 4).click();
			fail("The panel is not refreshed ");
		}
	}

	@Given("^Click on Settings$")
	public void click_on_Settings() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Ig_Settings", 4).click();
	}

	@Given("^Verify Settings option\\.$")
	public void verify_Settings_option() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_settings_popup"))).size() != 0) {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
			System.out.println("The settings pop up is shown");
		} else {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
			Assert.fail("The settings pop up is shown");
		}
	}

	// Tc_InsightGeneral_55
	@Given("^Verify the available tabs in the settings popup\\.$")
	public void verify_the_available_tabs_in_the_settings_popup() throws Throwable {
		// String text =
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_setting_tabs"))).getText();
		String text1 = "General";
		String text2 = "Information";
		String text3 = "Permissions";
		/*
		 * String text4 = "Subscription"; String text5 = "Keywords";
		 */
		String[] expected = { "General", "Information", "Permissions" };

		List<WebElement> allOptions = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("Ig_setting_tabs")));
		for (int i = 0; i < expected.length; i++) {
			try {

				String optionValue = allOptions.get(i).getText();
				if (optionValue.contains(text1)) {
					System.out.println("General tab is shown");
				} else {
					Assert.fail("General tab is not shown");
				}
				if (optionValue.contains(text2)) {
					System.out.println("Information tab is shown");
				} else {
					Assert.fail("Information tab is not  shown");
				}
				if (optionValue.contains(text3)) {
					System.out.println("Permissions tab is  shown");
				} else {
					Assert.fail("Permissions tab is not shown");
				}
				/*
				 * if (optionValue.contains(text4)) {
				 * System.out.println("Subscription tab is  shown"); } else {
				 * Assert.fail("Subscription tab is not shown"); } if
				 * (optionValue.contains(text5)) { System.out.println("Keywords tab is  shown");
				 * } else { Assert.fail("Keywords tab is not shown"); }
				 */
				close_insight();
			} catch (Exception indexoutofBoundException) {

			}
		}
	}

	// Tc_InsightGeneral_56
	@Given("^Click on Settings and Verify the available tabs in the settings popup$")
	public void click_on_Settings_and_Verify_the_available_tabs_in_the_settings_popup() throws Throwable {
		CommonFunctionality.wait(3000);
		String text = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(@class,'insight-breadcrumb--title text-dots')]", 4)
				.getText();
		click_on_File_menu();
		click_on_Settings();
		CommonFunctionality.webDriverwait_keyvalue("Ig_settings_iptext");
		String settingsText = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_settings_iptext")))
				.getAttribute("value");
		assertEquals(text, settingsText);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
	}

	// Tc_InsightGeneral_57
	@Given("^Update the name under Settings and Verify$")
	public void update_the_name_under_Settings_and_Verify() throws Throwable {
		create_insight();
		click_on_File_menu();
		click_on_Settings();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_settings_iptext"))).sendKeys("TESTING");
		String settingsText = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_settings_iptext")))
				.getAttribute("value");
		System.out.println(settingsText);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tag_save"))).click();
		Thread.sleep(3000);
		String Text = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Untitled_insight"))).getText();
		if (Text.equalsIgnoreCase(settingsText)) {
			System.out.println("Current insight name is displayed");

		} else {

			Assert.fail("Current insight name is not displayed");
		}
	}

	// Tc_InsightGeneral_58
	@Given("^Verify insight URL after insight title change\\.$")
	public void verify_insight_URL_after_insight_title_change() throws Throwable {
		String insightId = "TC" + new Random().nextInt(1000);
		WebElement element = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_settingurl")));
		action.moveToElement(element).build().perform();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_urlediticon"))).click();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_URL_edit"))).sendKeys(insightId);
		Thread.sleep(2000);
		String inURL = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_settingurl"))).getText();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tag_save"))).click();
		String url = login.driver.getCurrentUrl();
		if (url.contains(inURL)) {
			System.out.println("The insight URL is updated");
		} else {
			Assert.fail("The insight URL is not updated");
		}
	}

	// Tc_InsightGeneral_59
	@Given("^Verify the alert message while changing insight URL\\.$")
	public void verify_the_alert_message_while_changing_insight_URL() throws Throwable {
		String insightId = "RG" + new Random().nextInt(1000);
		WebElement element = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_settingurl")));
		action.moveToElement(element).build().perform();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_urlediticon"))).click();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_URL_edit"))).sendKeys(insightId);
		Thread.sleep(3000);
		String textSetting = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Urledit_mess")))
				.getText();
		String text = "Changing the url of the insight will break out the old url.";
		if (textSetting.matches(text)) {
			System.out.println("The alert message displayed");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
		} else {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
			Assert.fail("The alert message displayed");
		}
	}

	// Tc_InsightGeneral_60
	@Given("^Verify Change insight URL with existing insight name$")
	public void verify_Change_insight_URL_with_existing_insight_name() throws Throwable {
		String insightId = "S" + new Random().nextInt(1000);
		WebElement element = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_settingurl")));
		action.moveToElement(element).build().perform();
		action.moveToElement(CommonFunctionality.getElementByClassName(login.driver, "friendly-url__input", 4)).build()
				.perform();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_urlediticon"))).click();
		Thread.sleep(300);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_URL_edit"))).sendKeys(insightId);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tag_save"))).click();
		click_on_File_menu();
		click_on_Settings();
		Thread.sleep(1000);
		WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_settingurl")));
		action.moveToElement(ele).pause(500).build().perform();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_urlediticon"))).click();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_URL_edit"))).sendKeys("S");
		Thread.sleep(3000);
		String textSetting = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_urlmess_invalid")))
				.getText();
		String text = "Insight with this url already exists.";
		assertEquals(textSetting, text);
		System.out.println(textSetting + " message is displayed");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
	}

	@And("^Verify \"([^\"]*)\" for all options$")
	public void verify_for_all_options(String arg1) throws Throwable {
		WebElement edit = CommonFunctionality.getElementByXpath(login.driver, "//*[text()='Edit']/following::div[2]",
				4);
		WebElement copy = CommonFunctionality.getElementByXpath(login.driver, "//*[text()='Copy']/following::div[2]",
				4);
		if (arg1.equalsIgnoreCase("ON")) {
			if (edit.getAttribute("class").contains("bootstrap-switch-on")) {
				System.out.println("Edit option is already in ON state");
			} else {
				new Actions(login.driver)
						.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
								"//*[text()='Edit']/following::*[@class='bootstrap-switch-label'][1]", 4))
						.click().build().perform();
			}
			if (copy.getAttribute("class").contains("bootstrap-switch-on")) {
				System.out.println("Copy option is already in ON state");
			} else {
				new Actions(login.driver)
						.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
								"//*[text()='Copy']/following::*[@class='bootstrap-switch-label'][1]", 4))
						.click().build().perform();
			}
			WebElement apply = login.driver
					.findElement(By.xpath("//*[text()='Apply' and contains(@class,'button__secondary_purple')]"));
			if (apply.getAttribute("class").contains("button__disabled")) {
				System.out.println("Apply button is not enabled");
			} else {
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[text()='Apply' and contains(@class,'button__secondary_purple')]", 4).click();
			}
			if (edit.getAttribute("class").contains("bootstrap-switch-on")
					&& copy.getAttribute("class").contains("bootstrap-switch-on")) {
				System.out.println("Edit and Copy option is in ON state");
			}
		}
		if (arg1.equalsIgnoreCase("OFF")) {
			if (edit.getAttribute("class").contains("bootstrap-switch-off")) {
				System.out.println("Edit option is already in OFF state");
			} else {
				new Actions(login.driver)
						.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
								"//*[text()='Edit']/following::*[@class='bootstrap-switch-label'][1]", 4))
						.click().build().perform();
			}
			if (copy.getAttribute("class").contains("bootstrap-switch-off")) {
				System.out.println("Copy option is already in OFF state");
			} else {
				new Actions(login.driver)
						.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
								"//*[text()='Copy']/following::*[@class='bootstrap-switch-label'][1]", 4))
						.click().build().perform();
			}
			WebElement apply = login.driver
					.findElement(By.xpath("//*[text()='Apply' and contains(@class,'button__secondary_purple')]"));
			if (apply.getAttribute("class").contains("button__disabled")) {
				System.out.println("Apply button is not enabled");
			} else {
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[text()='Apply' and contains(@class,'button__secondary_purple')]", 4).click();
			}
			if (edit.getAttribute("class").contains("bootstrap-switch-off")
					&& copy.getAttribute("class").contains("bootstrap-switch-off")) {
				System.out.println("Edit and Copy option is in OFF state");
			}
		}
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
	}

	@And("^Should able to add insight descripiton$")
	public void should_able_to_add_insight_descripiton() throws Throwable {
		random_text = "Shravas" + new Random().nextInt(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@data-tab-id='general']", 4).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='insight-settings-control']/textarea", 4)
				.sendKeys(random_text);
		CommonFunctionality.getElementBycssSelector(login.driver, ".button__secondary_purple", 4).click();
		Thread.sleep(1000);
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		System.out.println("Able to enter data");
	}

	@SuppressWarnings("deprecation")
	@And("^The descripton should be visible to user$")
	public void the_descripton_should_be_visible_to_user() throws Throwable {
		should_able_to_add_insight_descripiton();
		cv.click_on_my_insights();
		CommonFunctionality.getElementBycssSelector(login.driver, "div[title='View as a grid']", 4).click();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//*[text()='" + CollabarationSharing.new_insight_name + "']", 4))
				.pause(1000).build().perform();
		String actual = CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[contains(text(),'" + CollabarationSharing.new_insight_name
								+ "')]//following::*[contains(@class,'insight-grid-item--description-text')]",
						4)
				.getText();
		assertEquals(actual, random_text);
		System.out.println("The description is visible to user");
		cs.navigate_insights();
	}

	@And("^By default the Save and Apply buttons should be disabled and enable after any changes made$")
	public void by_default_the_Save_and_Apply_buttons_should_be_disabled_and_enable_after_any_changes_made()
			throws Throwable {
		CommonFunctionality.wait(1000);
		WebElement apply = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'button__secondary_purple')]", 4);
		WebElement save = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='sphere-modal-controls--right']//*[contains(@class,'button__primary')]", 4);
		if (apply.getAttribute("class").contains("button__disabled")
				&& save.getAttribute("class").contains("button__disabled")) {
			System.out.println("The buttons are disabled by default");
		} else {
			fail("Verification Failed");
		}
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='insight-settings-control']/textarea", 4)
				.sendKeys("Shravas" + new Random().nextInt(1000));
		Thread.sleep(1000);
		if (!apply.getAttribute("class").contains("button__disabled")
				&& !save.getAttribute("class").contains("button__disabled")) {
			System.out.println("The buttons are enabled by modifying the insight");
		} else {
			fail("Verification Failed");
		}
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
	}

	@And("^The \"([^\"]*)\" button is clicked and popup size is (\\d+)$")
	public void the_button_is_clicked_and_popup_size_is(String arg1, int arg2) throws Throwable {
		WebElement apply = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'button__secondary_purple')]", 4);
		WebElement save = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='sphere-modal-controls--right']//*[contains(@class,'button__primary')]", 4);
		String actual = "Shravas" + new Random().nextInt(1000);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='insight-settings-control']/textarea", 4)
				.sendKeys(actual);
		Thread.sleep(1000);
		if (arg1.equalsIgnoreCase("Save")) {
			save.click();
			Thread.sleep(1000);
			List<WebElement> save_button = login.driver.findElements(By.cssSelector(".sphere-modal__content"));
			assertEquals(save_button.size(), arg2);
		}
		if (arg1.equalsIgnoreCase("Apply")) {
			apply.click();
			Thread.sleep(1000);
			if (!apply.getAttribute("class").contains("button__disabled")
					&& !save.getAttribute("class").contains("button__disabled")) {
				fail("Buttons are not disabled");
			}
			List<WebElement> apply_button = login.driver.findElements(By.cssSelector(".sphere-modal__content"));
			assertEquals(apply_button.size(), arg2);
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
			click_on_File_menu();
			click_on_Settings();
			String expected = CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='insight-settings-control']/textarea", 4).getText();
			assertEquals(actual, expected);
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		}

	}

	@And("^The original link of insight should be copied$")
	public void the_original_link_of_insight_should_be_copied() throws Throwable {
		login.driver.findElement(By.xpath("//*[@title='Permanent link is an insight URL that will never be changed.']"))
				.click();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		CommonFunctionality.wait(1000);
		link_copy = (String) clipboard.getData(DataFlavor.stringFlavor);
		login.Log4j.info(link_copy);
		CommonFunctionality.wait(1000);
		String host = CommonFunctionality.getElementByClassName(login.driver, "friendly-url__uneditable", 4).getText();
		CommonFunctionality.wait(1000);
		String url = CommonFunctionality.getElementByClassName(login.driver, "friendly-url__input-editable", 4)
				.getAttribute("value");
		String actual = host + url;
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
		assertEquals(link_copy, actual);
		System.out.println("The original link of insight is copied.");
	}

	@Given("^Validate the copied link\\.$")
	public void validate_the_copied_link() throws Throwable {
		CommonFunctionality.wait(1000);
		login.driver.findElement(By.xpath("//*[@title='Permanent link is an insight URL that will never be changed.']"))
				.click();
		CommonFunctionality.wait(2000);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		link_copy = (String) clipboard.getData(DataFlavor.stringFlavor);
		login.Log4j.info(link_copy);
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
		CommonFunctionality.wait(1000);
		String InsightCuurentTab = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Untitled_insight")))
				.getText();
		// Switch focus to new tab
		js.executeScript("window.open('" + link_copy + "')");
		ArrayList<String> tabs = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs.get(1));
		CommonFunctionality.wait(3000);
		String InsightNewTab = login.driver.findElement(By.cssSelector(".insight-preview--title")).getText();
		CommonFunctionality.getElementByClassName(login.driver, "insight-preview--close", 4).click();
		login.driver.switchTo().window(tabs.get(1)).close();
		login.driver.switchTo().window(tabs.get(0));
		assertEquals(InsightCuurentTab, InsightNewTab);
		System.out.println("The URL copied is verified");
	}

	@Then("^The \"([^\"]*)\" message should popup$")
	public void the_message_should_popup(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Cancel")) {
			CommonFunctionality.getElementBycssSelector(login.driver, "div[data-tab-id='general']", 4).click();
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
			List<WebElement> popup = login.driver.findElements(By.cssSelector(".sphere-modal__content"));
			assertEquals(popup.size(), 0);
		} else {
			String input = "Shravas" + new Random().nextInt(1000);
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='insight-settings-control']/textarea", 4)
					.sendKeys(input);
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'button__secondary_purple')]", 4)
					.click();
			String actual = CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[@class='insight-settings__changes-saved-message' and @style='display: inline;']", 4)
					.getText();
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
			assertEquals(actual, arg1);
			System.out.println("The " + arg1 + " message has been appeared and verified successfully");
		}
	}

	@Then("^The Apply and Save buttons remains enabled$")
	public void the_Apply_and_Save_buttons_remains_enabled() throws Throwable {
		WebElement apply = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'button__secondary_purple')]", 4);
		WebElement save = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='sphere-modal-controls--right']//*[contains(@class,'button__primary')]", 4);
		CommonFunctionality.getElementBycssSelector(login.driver, "div[data-tab-id='general']", 4).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='insight-settings-control']/textarea", 4)
				.sendKeys("Shravas" + new Random().nextInt(1000));
		CommonFunctionality.getElementBycssSelector(login.driver, "div[data-tab-id='info']", 4).click();
		if (!apply.getAttribute("class").contains("button__disabled")
				&& !save.getAttribute("class").contains("button__disabled")) {
			System.out.println("The buttons are disabled by default");
		} else {
			fail("Verification Failed");
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
	}

	// TC_InsightGeneral_62
	@Given("^Verify Category field\\.$")
	public void verify_Category_field() throws Throwable {
		try {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Cat_drpdn"))).click();
			Thread.sleep(4000);
			String[] file_list = { "None", "Hot Topics", "World Economy", "Emerging Markets", "Thematic Analysis",
					"Markets", "New Datasets" };
			List<WebElement> elements = login.driver
					.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Category_List")));
			for (int i = 0; i < file_list.length; i++) {
				String optionValue = elements.get(i).getText();
				System.out.println(optionValue);
				if (optionValue.equals(file_list[i])) {

					System.out.println("passed on: " + optionValue);
					// Thread.sleep(4000);

					//
				} else {

				}
			}
		}

		finally {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Cattopic"))).click();
			close_insight();
		}

	}

	// TC_InsightGeneral_63
	@Given("^Verify applied category for the insight\\.$")
	public void verify_applied_category_for_the_insight() throws Throwable {

		create_insight();
		String Text = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Untitled_insight"))).getText();
		click_on_File_menu();
		click_on_Settings();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Cat_drpdn"))).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Cattopic"))).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tag_save"))).click();
		open_insight();

		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Allcat"))).click();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Cattopic"))).click();
		Thread.sleep(3000);
		String inname = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Fav_Insight_Title"))).getText();
		Thread.sleep(3000);
		if (Text.equalsIgnoreCase(inname)) {
			System.out.println("Insight name matched");
			delete_insight();

		} else {
			close_insight();
			Assert.fail("Insight name not  matched");
		}

	}

	// TC_InsightGeneral_64
	@Given("^Verify added description under insight explorer\\.$")
	public void verify_added_description_under_insight_explorer() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_add_desc"))).sendKeys("TestData");
		String description = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_add_desc")))
				.getAttribute("value");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tag_save"))).click();
		open_insight();
		WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Fav_Insight_Title")));
		action.moveToElement(ele).build().perform();
		Thread.sleep(2000);
		String insightText = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_insight_desc_txt")))
				.getAttribute("title");
		Thread.sleep(4000);
		if (description.equalsIgnoreCase(insightText)) {
			System.out.println("The descripton is visible to user.");
			delete_insight();
		} else {
			close_insight();
			Assert.fail("The descripton is not visible to user.");
		}
	}

	// TC_InsightGeneral_65
	@Given("^Verify Save and Apply buttons disabled$")
	public void verify_Save_and_Apply_buttons_disabled() throws Throwable {
		List<WebElement> apply_disable = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("Ig_apply_disable")));
		List<WebElement> save_disable = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("Ig_save_disable")));
		if (apply_disable.size() != 0 && save_disable.size() != 0) {
			close_insight();
			System.out.println("Save and Apply are disabled");
		} else {
			close_insight();
			Assert.fail("Save and Apply are not disabled");
		}
	}

	@Given("^Verify Save and Apply buttons enabled$")
	public void verify_Save_and_Apply_buttons_enabled() throws Throwable {
		click_on_File_menu();
		click_on_Settings();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_add_desc"))).sendKeys("TestData");
		List<WebElement> apply_enable = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("Ig_apply_enable")));
		List<WebElement> save_enable = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("Ig_save_enable")));
		if (apply_enable.size() != 0 && save_enable.size() != 0) {
			System.out.println("Save and Apply are enabled");
			close_insight();
		} else {
			close_insight();
			Assert.fail("Save and Apply are  disabled");
		}
	}

	// TC_InsightGeneral_66
	@Given("^Verify Apply button\\.$")
	public void verify_Apply_button() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_add_desc"))).sendKeys("TestData");

		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Settings"))).size() != 0) {
			System.out.println("Settings pop up not closed");
			close_insight();
		} else {
			close_insight();
			Assert.fail("Settings pop up  closed");
		}
	}

	// TC_InsightGeneral_67
	@Given("^Enter Description and Click Apply button$")
	public void enter_Description_and_Click_Apply_button() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_add_desc"))).sendKeys("TestData");
	}

	@Given("^Verify confirmation message after click on Apply\\.$")
	public void verify_confirmation_message_after_click_on_Apply() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_apply_enable"))).click();
		Thread.sleep(2000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Apply_mess"))).size() != 0) {
			System.out.println("Changes are saved message is displayed ");
			close_insight();
		} else {
			close_insight();
			Assert.fail("Changes are saved message is not displayed");
		}
	}

	// TC_InsightGeneral_68
	@Given("^Click on Info Tab$")
	public void click_on_Info_Tab() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Info_tab"))).click();
		Thread.sleep(3000);
	}

	@Given("^Verify Apply and Save buttons when redirect to next tabs with changes\\.$")
	public void verify_Apply_and_Save_buttons_when_redirect_to_next_tabs_with_changes() throws Throwable {
		verify_Save_and_Apply_buttons_disabled();
	}

	// TC_InsightGeneral_69
	@Given("^Verify Cancel/X buttons\\.$")
	public void verify_Cancel_X_buttons() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_settings_popup"))).size() != 0) {
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).size() != 0) {
				close_insight();
				System.out.println("pop up is closed ");
			} else {
				close_insight();
				Assert.fail("Pop up is not closed");
			}

		}

	}

	// TC_InsightGeneral_70
	@Given("^Verify Created field under Information tab\\.$")
	public void verify_Created_field_under_Information_tab() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("dropdown_btn"))).click();
		CommonFunctionality.wait(2000);
		String userdetail = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_User_Account"))).getText();
		creating_new_insight();
		click_on_File_menu();
		click_on_Settings();
		click_on_Info_Tab();
		String infotabdetail = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Info_Detail")))
				.getText();
		if (infotabdetail.contains(userdetail)) {
			System.out.println("USername is displayed");
			close_insight();
		} else {
			close_insight();
			Assert.fail("USername is not displayed");
		}
		cs.delete_Insight();
	}

	// TC_InsightGeneral_71
	@Given("^Verify Last editor field\\.$")
	public void verify_Last_editor_field() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("dropdown_btn"))).click();
		Thread.sleep(2000);
		String userdetail = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_User_Account"))).getText();
		creating_new_insight();
		click_on_File_menu();
		click_on_Settings();
		click_on_Info_Tab();
		String infotabdetail = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Lasteditor_Detail")))
				.getText();
		if (infotabdetail.contains(userdetail)) {
			System.out.println("USername is displayed");
			close_insight();
		} else {
			close_insight();
			Assert.fail("USername is not displayed");
		}
		cs.delete_Insight();
	}

	// TC_InsightGeneral_72
	@Given("^Check sharing settings field\\.$")
	public void check_sharing_settings_field() throws Throwable {
		click_on_Info_Tab();
		String SharedDetail = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_shared_setting")))
				.getText();
		String shared = "not shared";
		if (SharedDetail.equalsIgnoreCase(shared)) {
			System.out.println("The insight is not shared");
		} else {
			Assert.fail("The insight is not shared");
		}
	}

	@Given("^Share insight and Check the sharing settings field$")
	public void share_insight_and_Check_the_sharing_settings_field() throws Throwable {
		if (login.CONFIG.getProperty("username").equalsIgnoreCase("psathishkgm@gmail.com")) {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_shared_change"))).click();
			cs.entering_mail_to_share_the_insight();
			CommonFunctionality
					.getElementByXpath(login.driver,
							"(//*[@class='sphere-modal-controls'])[2]//*[contains(@class,'button__primary')]", 4)
					.click();
			if (login.driver.findElements(By.xpath("//*[text()='OK']")).size() > 0) {
				CommonFunctionality.getElementByXpath(login.driver, "//*[text()='OK']", 4).click();
			}
			Thread.sleep(2000);
			String SharedDetail = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_shared_setting")))
					.getText();
			String shared = "shared";
			if (SharedDetail.equalsIgnoreCase(shared)) {
				System.out.println("The insight is shared");
				close_insight();
			} else {
				close_insight();
				Assert.fail("The insight is not shared");
			}
		} else {
			System.out.println("<============ Username is different so unable to perform share operation ===========>");
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		}
	}

	// TC_InsightGeneral_73
	@Given("^Verify 'Change' option for sharing settings\\.$")
	public void verify_Change_option_for_sharing_settings() throws Throwable {

		click_on_Info_Tab();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_shared_change"))).click();
		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("SHARE_POPUP"))).size() != 0) {
			System.out.println("The share popup  is displayed");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_sharepopup_cancel"))).click();
			close_insight();
		} else {
			close_insight();
			Assert.fail("The share popup  is not displayed");
		}

	}

	// TC_InsightGeneral_74
	@Given("^Add Views$")
	public void add_Views() throws Throwable {
		creating_new_insight();
		Thread.sleep(2000);
		// expander();
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_addview_btn"))).click();
		CommonFunctionality.Views_list();
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_addview_btn"))).click();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_addview_btn"))).click();
	}

	@Given("^Verify number of the view/s for the insight\\.$")
	public void verify_number_of_the_view_s_for_the_insight() throws Throwable {
		int viewcount = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_View_count"))).size();
		click_on_File_menu();
		click_on_Settings();
		click_on_Info_Tab();
		String view = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Setting_no_views"))).getText();
		int viewcnt = Integer.parseInt(view);
		if (viewcount == viewcnt) {
			System.out.println("The view count matched");
			close_insight();
			CommonFunctionality.Views_list();
		} else {
			close_insight();
			Assert.fail("Fail");
		}
	}

	// TC_InsightGeneral_75
	@Given("^Add series to myseries$")
	public void add_series_to_myseries() throws Throwable {
		creating_new_insight();
		add_Series();
	}

	@Given("^Verify Data series under info tab in settings$")
	public void verify_Data_series_under_info_tab_in_settings() throws Throwable {
		CommonFunctionality.wait(1000);
		int datacount = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_myseries_size"))).size();
		click_on_File_menu();
		click_on_Settings();
		click_on_Info_Tab();
		CommonFunctionality.wait(1000);
		String data = CommonFunctionality.getElementByProperty(login.driver, "Ig_data_count", 4).getText();
		int datacnt = Integer.parseInt(data);
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		CommonFunctionality.DeleteSeries();
		assertEquals(datacount, datacnt);
		System.out.println("The number of data series matched");
	}

	// TC_InsightGeneral_76
	@Given("^Click on Permissions tab$")
	public void click_on_Permissions_tab() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_permission_tab"))).click();
	}

	@Given("^Verify Permission tabs description\\.$")
	public void verify_Permission_tabs_description() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Permission_title"))).size() != 0) {
			System.out.println("The description  is displayed");

			close_insight();
		} else {
			close_insight();
			Assert.fail("The description is not displayed");
		}
	}

	// TC_InsightGeneral_77
	@Given("^Verify default selection for permission tab\\.$")
	public void verify_default_selection_for_permission_tab() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_permission_option"))).size() != 0) {
			System.out.println("PASS");

			close_insight();
		} else {
			close_insight();
			Assert.fail("FAIL");
		}
	}

	@Given("^Click on Subscription tab$")
	public void click_on_Subscription_tab() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Ig_subscription_tab", 4).click();
	}

	@Given("^Verify Select service code field\\.$")
	public void verify_Select_service_code_field() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Ig_select_servicecode_drpdwn", 4).click();
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_servicedrpdwn"))).size() != 0) {
			System.out.println("PASS");
			close_insight();
		} else {
			close_insight();
			fail("FAIL");
		}
	}

	@Given("^Verify search for service code\\.$")
	public void verify_search_for_service_code() throws Throwable {
		String servicecode = "CEIC Premium China";
		CommonFunctionality.getElementByProperty(login.driver, "Ig_select_servicecode_drpdwn", 4).sendKeys(servicecode);
		CommonFunctionality.wait(500);
		String code = CommonFunctionality.getElementByProperty(login.driver, "Ig_service_code", 4).getText();
		close_insight();
		assertEquals(servicecode, code);
		System.out.println("PASS");
	}

	@Given("^Verify message for invalid search\\.$")
	public void verify_message_for_invalid_search() throws Throwable {
		String servicecode = "12";
		String message = "Empty results";
		CommonFunctionality.getElementByProperty(login.driver, "Ig_select_servicecode_drpdwn", 4).sendKeys(servicecode);
		CommonFunctionality.wait(2000);
		String code = CommonFunctionality.getElementByProperty(login.driver, "Ig_empty_result", 4).getText();
		close_insight();
		assertEquals(message, code);
		System.out.println("Empty Results message is displayed");
	}

	@Then("^The Keywords tab is active$")
	public void the_Keywords_tab_is_active() throws Throwable {
		WebElement keywords = CommonFunctionality.getElementBycssSelector(login.driver, "div[data-tab='keywords']", 4);
		if (keywords.getAttribute("class").contains("active")) {
			System.out.println("The Keywords tab is active");
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		} else {
			fail("Verification Failed");
		}
	}

	@Given("^Verify Subscription tabs description\\.$")
	public void verify_Subscription_tabs_description() throws Throwable {
		String message = "Only users with all specified subscriptions are allowed to view this insight";
		String code = CommonFunctionality.getElementByProperty(login.driver, "Ig_subs_mess", 4).getText();
		close_insight();
		assertEquals(message, code);
		System.out.println("PASS");
	}

	@Given("^Verify remove icon for service code field\\.$")
	public void verify_remove_icon_for_service_code_field() throws Throwable {
		String servicecode = "CEIC Premium China";
		CommonFunctionality.getElementByProperty(login.driver, "Ig_select_servicecode_drpdwn", 4).sendKeys(servicecode);
		CommonFunctionality.getElementByProperty(login.driver, "Ig_select_servicecode_drpdwn", 4).clear();
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_servicedrpdwn"))).size() != 0) {
			System.out.println("PASS");
			close_insight();
		} else {
			close_insight();
			fail("FAIL");
		}
	}

	@SuppressWarnings("deprecation")
	@Given("^Verify service code selection\\.$")
	public void verify_service_code_selection() throws Throwable {
		String servicecode = "CEIC";
		CommonFunctionality.getElementByProperty(login.driver, "Ig_select_servicecode_drpdwn", 4).sendKeys(servicecode);
		WebElement ele = CommonFunctionality.getElementByProperty(login.driver, "Ig_select_servicecode", 4);
		new Actions(login.driver).moveToElement(ele).pause(500).build().perform();
		CommonFunctionality.getElementByProperty(login.driver, "Ig_select_servicecode", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "tag_save", 4).click();
		CommonFunctionality.wait(1500);
		click_on_File_menu();
		click_on_Settings();
		click_on_Subscription_tab();
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_servicecode_display"))).size() != 0) {
			System.out.println("PASS");
			close_insight();
		} else {
			close_insight();
			fail("FAIL");
		}
	}

	@SuppressWarnings("deprecation")
	@Given("^Verify remove icon for selected service code\\.$")
	public void verify_remove_icon_for_selected_service_code() throws Throwable {
		String servicecode = "CEIC";
		CommonFunctionality.getElementByProperty(login.driver, "Ig_select_servicecode_drpdwn", 4).sendKeys(servicecode);
		WebElement ele = CommonFunctionality.getElementByProperty(login.driver, "Ig_select_servicecode", 4);
		new Actions(login.driver).moveToElement(ele).pause(1000).build().perform();
		CommonFunctionality.getElementByProperty(login.driver, "Ig_select_servicecode", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "tag_save", 4).click();
		CommonFunctionality.wait(1000);
		click_on_File_menu();
		click_on_Settings();
		click_on_Subscription_tab();
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_servicecode_display"))).size() != 0) {
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_servicecode_display"))).size() != 0)
				CommonFunctionality.getElementByProperty(login.driver, "Ig_servicecode_delete", 4).click();
			System.out.println("PASS");
			close_insight();
		} else {
			close_insight();
			fail("FAIL");
		}
	}

	@SuppressWarnings("deprecation")
	@Given("^Verify product code field\\.$")
	public void verify_product_code_field() throws Throwable {
		String servicecode = "CEIC";
		CommonFunctionality.getElementByProperty(login.driver, "Ig_select_servicecode_drpdwn", 4).sendKeys(servicecode);
		WebElement ele = CommonFunctionality.getElementByProperty(login.driver, "Ig_Productcode", 4);
		new Actions(login.driver).moveToElement(ele).pause(1000).build().perform();
		CommonFunctionality.getElementByProperty(login.driver, "Ig_Productcode", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "Ig_Pcode", 4).click();
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_prodcode_drpdown"))).size() != 0) {
			System.out.println("PASS");
			close_insight();
		} else {
			close_insight();
			fail("FAIL");
		}
	}

	@SuppressWarnings("deprecation")
	@Given("^Verify default selection for product code field\\.$")
	public void verify_default_selection_for_product_code_field() throws Throwable {
		String servicecode = "CEIC";
		CommonFunctionality.getElementByProperty(login.driver, "Ig_select_servicecode_drpdwn", 4).sendKeys(servicecode);
		WebElement ele = CommonFunctionality.getElementByProperty(login.driver, "Ig_Productcode", 4);
		new Actions(login.driver).moveToElement(ele).pause(1000).build().perform();
		CommonFunctionality.getElementByProperty(login.driver, "Ig_Productcode", 4).click();
		String Pcode = "All product codes";
		String Productcode = CommonFunctionality.getElementByProperty(login.driver, "Ig_Pcode", 4).getText();
		close_insight();
		assertEquals(Pcode, Productcode);
		System.out.println("PASS");
	}

	@SuppressWarnings("deprecation")
	@Given("^Verify remove icon for selected product codes\\.$")
	public void verify_remove_icon_for_selected_product_codes() throws Throwable {
		String servicecode = "CEIC";
		CommonFunctionality.getElementByProperty(login.driver, "Ig_select_servicecode_drpdwn", 4).sendKeys(servicecode);
		WebElement ele = CommonFunctionality.getElementByProperty(login.driver, "Ig_Productcode", 4);
		new Actions(login.driver).moveToElement(ele).pause(500).build().perform();
		CommonFunctionality.getElementByProperty(login.driver, "Ig_Productcode", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "Ig_Pcode", 4).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='subscription-item-delete']", 4).click();
		if (login.driver.findElements(By.xpath("//*[@class='subscription-item-delete']")).size() == 0) {
			System.out.println("PASS");
			close_insight();
		} else {
			close_insight();
			fail("FAIL");
		}
	}

	@Given("^Click on Keywords tab$")
	public void click_on_Keywords_tab() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Ig_Keywordstab", 4).click();
	}

	@Given("^Verify keywords for the insights\\.$")
	public void verify_keywords_for_the_insights() throws Throwable {
		String keytext = "CEIC";
		CommonFunctionality.getElementByProperty(login.driver, "Ig_Keyword_desc", 4).sendKeys(keytext);
		CommonFunctionality.getElementByProperty(login.driver, "Ig_Keyword_desc", 4).sendKeys(Keys.ENTER);
		close_insight();
		click_on_File_menu();
		click_on_Settings();
		click_on_Keywords_tab();
		String Keyword = CommonFunctionality.getElementByProperty(login.driver, "Ig_keyword_text", 4).getText();
		if (Keyword.contains(keytext)) {
			System.out.println("PASS");
			close_insight();
		} else {
			close_insight();
			fail("FAIL");
		}

	}

	@Given("^Add Keywords$")
	public void add_Keywords() throws Throwable {
		String keytext = "CEIC DATA";
		CommonFunctionality.getElementByProperty(login.driver, "Ig_Keyword_desc", 4).sendKeys(keytext);
		CommonFunctionality.getElementByProperty(login.driver, "Ig_Keyword_desc", 4).sendKeys(Keys.ENTER);
		close_insight();
	}

	@Given("^Verify the insight for added keywords in insight explorer\\.$")
	public void verify_the_insight_for_added_keywords_in_insight_explorer() throws Throwable {
		String InsightTitle = CommonFunctionality.getElementByProperty(login.driver, "Ig_Insight_Title", 4).getText();
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'My insights')]", 4).click();
		// open_insight();
		CommonFunctionality.getElementByXpath(login.driver, "//input[@class='insights-search--input']", 4)
				.sendKeys("CEIC DATA");
		CommonFunctionality.getElementByXpath(login.driver, "//input[@class='insights-search--input']", 4)
				.sendKeys(Keys.ENTER);
		String Title = CommonFunctionality.getElementByProperty(login.driver, "Fav_Insight_Title", 4).getText();
		if (InsightTitle.equalsIgnoreCase(Title)) {
			System.out.println("PASS");
		} else {
			close_insight();
			fail("FAIL");
		}
	}

	@Given("^Add Multiple Keywords and Verify$")
	public void add_Multiple_Keywords_and_verify() throws Throwable {
		String S1 = "CEICDATA";
		String S2 = "ISIMARKETS";
		CommonFunctionality.getElementByProperty(login.driver, "Ig_Keyword_desc", 4).sendKeys(S1);
		CommonFunctionality.getElementByProperty(login.driver, "Ig_Keyword_desc", 4).sendKeys(Keys.ENTER);
		CommonFunctionality.getElementByProperty(login.driver, "Ig_Keyword_desc", 4).sendKeys(S2);
		CommonFunctionality.getElementByProperty(login.driver, "Ig_Keyword_desc", 4).sendKeys(Keys.ENTER);
		close_insight();
		click_on_File_menu();
		click_on_Settings();
		click_on_Keywords_tab();
		String Keyword = CommonFunctionality.getElementByProperty(login.driver, "Ig_allkeywords", 4).getText();
		if (Keyword.contains(S1) && Keyword.contains(S2)) {
			System.out.println("PASS");
			close_insight();
		} else {
			close_insight();
			fail("FAIL");
		}

	}

	@Given("^Remove keywords and Verify$")
	public void remove_keywords() throws Throwable {
		String S1 = "CEICDATA";
		String S2 = "ISIMARKETS";
		CommonFunctionality.getElementByProperty(login.driver, "Ig_Keyword_desc", 4).sendKeys(S1);
		CommonFunctionality.getElementByProperty(login.driver, "Ig_Keyword_desc", 4).sendKeys(Keys.ENTER);
		CommonFunctionality.getElementByProperty(login.driver, "Ig_Keyword_desc", 4).sendKeys(S2);
		CommonFunctionality.getElementByProperty(login.driver, "Ig_Keyword_desc", 4).sendKeys(Keys.ENTER);
		CommonFunctionality.wait(2000);
		if (login.driver.findElements(By.xpath("//ul[contains(@class,'ui-widget-content ui-corner-all')]"))
				.size() > 0) {
			CommonFunctionality.getElementByProperty(login.driver, "Ig_remove_keyword", 4).click();
			CommonFunctionality.wait(2000);
			CommonFunctionality.getElementByProperty(login.driver, "Ig_remove_keyword", 4).click();
			CommonFunctionality.wait(500);
			CommonFunctionality.getElementByProperty(login.driver, "tag_save", 4).click();
			System.out.println("Keywords removed and verified");
		} else {
			close_insight();
			fail("Verification Failed");
		}
	}

	@Given("^Click on Protect$")
	public void click_on_Protect() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Ig_Protect", 4).click();
	}

	@Given("^Verify Protect option\\.$")
	public void verify_Protect_option() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_permission_tab_open"))).size() != 0) {
			System.out.println("Protect option is present");
			close_insight();
		} else {
			close_insight();
			fail("Verification Failed");
		}
	}

	@SuppressWarnings("deprecation")
	@Given("^Click \"([^\"]*)\" -> \"([^\"]*)\"$")
	public void click(String arg1, String arg2) throws Throwable {
		CommonFunctionality.getElementByClassName(login.driver, "user-notifications", 4).click();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[text()=\"" + arg2 + "\"]", 4))
				.pause(500).click().build().perform();
	}

	@Then("^The latest (\\d+) insights should be displayed$")
	public void the_latest_insights_should_be_displayed(int arg1) throws Throwable {
		CommonFunctionality.wait(500);
		List<WebElement> total_insights = CommonFunctionality.getElementsByXpath(login.driver,
				"//*[@class='activity-page']/*[2]//*[@class='all-insights-list-item']");
		assertEquals(arg1, total_insights.size());
		System.out.println("Latest 10 insights are displayed");

	}

	@Given("^Click on Notifications icon$")
	public void click_on_Notifications_icon() throws Throwable {
		CommonFunctionality.getElementByClassName(login.driver, "user-notifications--icon", 4).click();
	}

	@Given("^Get text of \"([^\"]*)\" available for \"([^\"]*)\"$")
	public void get_text_of_available_for(String arg1, String arg2) throws Throwable {
		String notification_option = CommonFunctionality
				.getElementBycssSelector(login.driver, "div[data-tab='" + arg1 + "']", 4).getText();
		assertEquals(arg2, notification_option);
		System.out.println(arg2 + " tab is present");
	}

	@And("^Verify protect option is not present for Untitled insight$")
	public void verify_protect_option_is_not_present_for_Untitled_insight() throws Throwable {
		CommonFunctionality.wait(2000);
		List<WebElement> protects = login.driver.findElements(By.xpath("//span[@title='Protect']/parent::li"));
		for (WebElement protect : protects) {
			if (protect.getAttribute("class").equals("hide")) {
				System.out.println("Protect option is hidden for untitled Insight");
			} else {
				fail("Verification Failed");
			}
		}
	}

	// TC_InsightGeneral_93
	@Given("^Verify Download option for new insight\\.$")
	public void verify_Download_option_for_new_insight() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Download_disabled"))).size() != 0) {
			System.out.println("PASS");

		} else {
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_94
	@Given("^Add series to my series panel$")
	public void add_series_to_my_series_panel() throws Throwable {
		expander();
		Thread.sleep(2000);
		add_Series();
	}

	@Given("^Verify download option when series selected in search panel\\.$")
	public void verify_download_option_when_series_selected_in_search_panel() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Downlaod"))).click();
		Thread.sleep(5000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Downloadpopup"))).size() != 0) {
			System.out.println("PASS");
			close_insight();
			CommonFunctionality.Views_list();
		} else {
			close_insight();
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_95
	@Given("^Click on Insights on menu header\\.$")
	public void click_on_Insights_on_menu_header() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("insights"))).click();
		Thread.sleep(5000);
	}

	@Given("^Verify \"([^\"]*)\" dropdown is shown$")
	public void verify_dropdown_is_shown(String arg1) throws Throwable {
		Thread.sleep(2000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("insights_drpdwn"))).size() != 0) {
			System.out.println("PASS");
		} else {
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_96
	@Given("^Click on Favorites$")
	public void click_on_Favorites() throws Throwable {
		click_on_Insights_on_menu_header();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("favorites"))).click();
		Thread.sleep(9000);
	}

	@Given("^Verify 'Favorite' on Insight menu\\.$")
	public void verify_Favorite_on_Insight_menu() throws Throwable {
		Thread.sleep(5000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_my_insights_selected"))).size() != 0) {
			System.out.println("PASS");
			close_insight();
		} else {
			close_insight();
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_97
	@Given("^Click on My Insights$")
	public void click_on_My_Insights() throws Throwable {
		open_insight();
	}

	@Given("^Verify Insight explorer pop up is shown$")
	public void verify_Insight_explorer_pop_up_is_shown() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Insightexplorer_Win"))).size() != 0) {
			System.out.println("PASS");
			close_insight();
		} else {
			close_insight();
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_98
	@Given("^Click on Analytics$")
	public void click_on_Analytics() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("insights"))).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Analytictab"))).click();
		Thread.sleep(4000);
	}

	@Given("^Verify  CEIC Gallery tab is Open$")
	public void verify_CEIC_Gallery_tab_is_Open() throws Throwable {
		String SharedTitle = "Filter CEIC Gallery by category";
		String shared = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_ceicGal_text")))
				.getAttribute("title");
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_ceic_gallery"))).size() != 0) {
			if (shared.equalsIgnoreCase(SharedTitle)) {
				System.out.println("PASS");
				close_insight();
			} else {
				close_insight();
				Assert.fail("FAIL");
			}
		}
	}

	// TC_InsightGeneral_99
	@Given("^Click on Shared insights$")
	public void click_on_Shared_insights() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("insights"))).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_sharedinsights"))).click();
		Thread.sleep(4000);
	}

	@Given("^Verify 'Shared insights' tab is open$")
	public void verify_Shared_insights_tab_is_open() throws Throwable {
		String SharedTitle = "Insights that other users have shared with you";
		String shared = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_my_insights_selected")))
				.getAttribute("title");
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_my_insights_selected"))).size() != 0) {
			if (shared.equalsIgnoreCase(SharedTitle)) {
				System.out.println("PASS");
				close_insight();
			} else {
				close_insight();
				Assert.fail("FAIL");
			}
		}

	}

	// TC_InsightGeneral_100
	@Given("^Create a new insight$")
	public void create_a_new_insight() throws Throwable {
		Footnotes i = new Footnotes();
		i.create_an_insight();
	}

	@Given("^Verify Recent insights$")
	public void verify_Recent_insights() throws Throwable {

		click_ceic_logo();
		Thread.sleep(5000);
		String insight = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Untitled_insight"))).getText();
		System.out.println(insight);
		Thread.sleep(4000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("insights"))).click();
		Thread.sleep(2000);
		String recentinsight = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_recent_insight")))
				.getText();
		System.out.println(recentinsight);
		if (recentinsight.equalsIgnoreCase(insight)) {
			System.out.println("PASS");
		} else {
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_101

	@Given("^Verify displayed insights count for Recent insights\\.$")
	public void verify_displayed_insights_count_for_Recent_insights() throws Throwable {
		int expected = 8;
		click_on_File_menu();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("insights"))).click();
		Thread.sleep(2000);
		int size = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_recentinsight_count"))).size();
		if (size == expected) {
			System.out.println("PASS");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_More"))).click();
			Thread.sleep(5000);
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Insightexplorer_Win"))).size() != 0) {

				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
				System.out.println("Insight explorer window is open");
			} else {
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
				Assert.fail("Insight explorer window is not open");
			}
		} else {
			Assert.fail("FAIL");
		}

	}

	// TC_InsightGeneral_102
	@Given("^Click on recent insight$")
	public void click_on_recent_insight() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("insights"))).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_recent_insight"))).click();
		Thread.sleep(4000);
	}

	@Given("^Verify insight open in preview mode$")
	public void verify_insight_open_in_preview_mode() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_insight_preview"))).size() != 0) {

			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close"))).click();
			System.out.println("Insight open in preview mode");
		} else {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close"))).click();
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_103
	@Given("^Verify 'Latest CEIC Insights'$")
	public void verify_Latest_CEIC_Insights() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("insights"))).click();
		Thread.sleep(2000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_latest_insight"))).size() != 0) {

			System.out.println("Latest insight is shown");

		} else {

			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_104
	@Given("^Click on Insights$")
	public void click_on_Insights() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("insights"))).click();
		Thread.sleep(2000);

	}

	@Given("^Verify number of displayed insights for latest CEIC Insights\\.$")
	public void verify_number_of_displayed_insights_for_latest_CEIC_Insights() throws Throwable {
		int Latest_CEIC_INSIGHT_COUNT = 3;
		int insightcount = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_latest_insight"))).size();
		System.out.println(insightcount);
		if (insightcount == Latest_CEIC_INSIGHT_COUNT) {
			System.out.println("PASS");
		} else {
			Assert.fail("FAIL");
		}
	}

	@Given("^Verify More option$")
	public void verify_More_option() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_latest_ceic_more"))).click();
		Thread.sleep(5000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Insightexplorer_Win"))).size() != 0) {

			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
			System.out.println("Insight explorer window is open");
		} else {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
			Assert.fail("Insight explorer window is not open");
		}
	}

	// TC_InsightGeneral_105
	@Given("^Click on Latest insight$")
	public void click_on_Latest_insight() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_lat_ceic_in"))).click();
		Thread.sleep(9000);
	}

	// TC_InsightGeneral_106
	@Given("^Verify  'Latest EMIS Insights'\\.$")
	public void verify_Latest_EMIS_Insights() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_EMIS_Insight"))).size() != 0) {

			System.out.println("Latest EMIS insight is shown");
		} else {

			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_107
	@Given("^Verify number of displayed insights for Latest EMIS Insights\\.$")
	public void verify_number_of_displayed_insights_for_Latest_EMIS_Insights() throws Throwable {
		int Latest_EMIS_INSIGHT_COUNT = 3;
		int insightcount = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_latest_emis_insight")))
				.size();
		System.out.println(insightcount);
		if (insightcount == Latest_EMIS_INSIGHT_COUNT) {
			System.out.println("PASS");
		} else {
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_108
	@Given("^Open 'Latest EMIS Insights'$")
	public void open_Latest_EMIS_Insights() throws Throwable {

		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_lat_emis_in"))).click();
		Thread.sleep(9000);
	}

	// TC_InsightGeneral_109
	@Given("^Click on  More option under EMIS insight$")
	public void click_on_More_option_under_EMIS_insight() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_latest_emis_more"))).click();
		Thread.sleep(5000);
	}

	@Given("^Verify More option for Latest EMIS Insights$")
	public void verify_More_option_for_Latest_EMIS_Insights() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_my_insights_selected"))).size() != 0) {
			String text = "CEIC Analytics";
			String analytics = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_my_insights_selected")))
					.getAttribute("title");
			if (analytics.equalsIgnoreCase(text)) {
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
				System.out.println("Analytics tab  is open");

			} else {
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
				Assert.fail("Insight explorer window is not open");
			}
		}
	}

	// TC_InsightGeneral_110
	@Given("^Click on Open insight Explorer$")
	public void click_on_Open_insight_Explorer() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_open_inexplorer"))).click();
		Thread.sleep(5000);
	}

	@Given("^Verify default tab for open insight explorer\\.$")
	public void verify_default_tab_for_open_insight_explorer() throws Throwable {
		verify_More_option_for_Latest_EMIS_Insights();
	}

	// TC_InsightGeneral_111
	@Given("^Click on Products$")
	public void click_on_Products() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Prod_tab"))).click();
		Thread.sleep(4000);
	}

	@Given("^Verify \"([^\"]*)\" dropdown$")
	public void verify_dropdown(String arg1) throws Throwable {

		List<WebElement> elementsList = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("Ig_prod_dropdown")));
		for (int i = 0; i < elementsList.size(); ++i) {
			String checkBox1 = elementsList.get(0).getText();
			String checkBox2 = elementsList.get(1).getText();
			String checkBox3 = elementsList.get(2).getText();

			if (checkBox1.contains("What's new?") && checkBox2.contains("World Trend Plus")
					&& checkBox3.contains("Global Database")) {
				System.out.println("PASS");
			} else {
				Assert.fail("FAIL");
			}

		}
		String premiumtext = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_prod1_dropdown")))
				.getText();
		if (premiumtext.contains("Premium Databases")) {
			System.out.println("PASS");

		} else {

			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_112
	@Given("^Click on Explore data under What's New$")
	public void click_on_Explore_data_under_What_s_New() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Explore_data"))).click();
		Thread.sleep(3000);
	}

	@Given("^Verify for new announcement pop up$")
	public void verify_for_new_announcement_pop_up() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_announcement_popup"))).size() != 0) {
			System.out.println("Announcement pop up is shown");
			close_insight();
		} else {
			close_insight();
			fail("FAIL");
		}
	}

	@SuppressWarnings("deprecation")
	@Then("^The announcement popup should be displayed$")
	public void the_announcement_popup_should_be_displayed() throws Throwable {
		if (login.driver
				.findElements(
						By.xpath("//*[@class='ceic-highlight--title' and text()='There are no recent announcements']"))
				.size() == 1) {
			System.out.println(" <=========== Announcement popup is not displayed ===========>");
		}
		if (login.driver.findElements(By.xpath(
				"//*[@class='activity-block-header--title' and contains(text(),'Highlights')]/following-sibling::*[contains(@class,'activity-block-header--link')]"))
				.size() == 1) {
			String anno_text = CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='ceic-highlight--content']//div[2]/div[1]", 4)
					.getText();
			String split[] = anno_text.split(",\n");
			assertEquals(split[0], "Dear CEIC Subscriber");
			List<WebElement> databases = CommonFunctionality.getElementsByXpath(login.driver,
					"//*[@class='ceic-highlight--content']//a[contains(@class,'tinymce-plugin-link')]");
			for (int i = 1; i <= databases.size(); i++) {
				if (i != 1) {
					CommonFunctionality.getElementByClassName(login.driver, "user-notifications--icon", 4).click();
				}
				WebElement one_database = CommonFunctionality.getElementByXpath(login.driver,
						"(//*[@class='ceic-highlight--content']//a[contains(@class,'tinymce-plugin-link')])[" + i + "]",
						4);
				js.executeScript("arguments[0].scrollIntoView(true);", one_database);
				String data_text = CommonFunctionality.getElementByXpath(login.driver,
						"(//*[@class='ceic-highlight--content']//a[contains(@class,'tinymce-plugin-link')])[" + i + "]",
						4).getText();
				new Actions(login.driver).moveToElement(one_database).pause(1000).click().build().perform();
				CommonFunctionality.wait(5000);
				if (CommonFunctionality.getElementsByXpath(login.driver, "//*[@class='insight-preview--views-wrapper']")
						.size() == 0) {
					fail("Not opening in preview mode");
				} else {
					System.out.println(data_text + " is opened in preview mode");
				}
				CommonFunctionality.getElementByClassName(login.driver, "insight-preview--close", 4).click();
				if (i == databases.size()) {
					CommonFunctionality.getElementByClassName(login.driver, "user-notifications--icon", 4).click();
				}
			}
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//a[contains(@class,'activity-block-header--link') and text()='See all highlights']", 4))
					.pause(500).click().build().perform();
			if (login.driver
					.findElements(By.xpath("//*[contains(@class,'sphere-modal__content')]//*[text()='Announcements']"))
					.size() == 1) {
				System.out.println("The popup is shown");
			} else {
				fail("Not shown");
			}
			WebElement whats_new = CommonFunctionality.getElementBycssSelector(login.driver,
					".select2-container.form--control", 4);
			CommonFunctionality.getElementByClassName(login.driver, "select2-arrow", 4).click();
			List<WebElement> products = login.driver
					.findElements(By.xpath("//ul[@class='select2-results']/li/div/div[2]"));
			for (int i = 1; i <= products.size(); i++) {
				String product_text = CommonFunctionality
						.getElementByXpath(login.driver, "//ul[@class='select2-results']/li[" + i + "]/div/div[2]", 4)
						.getText();
				if (product_text.equalsIgnoreCase("World Trend Plus")
						|| product_text.equalsIgnoreCase("Global Database")
						|| product_text.equalsIgnoreCase("Brazil Premium Database")
						|| product_text.equalsIgnoreCase("China Premium Database")
						|| product_text.equalsIgnoreCase("India Premium Database")
						|| product_text.equalsIgnoreCase("Indonesia Premium Database")
						|| product_text.equalsIgnoreCase("Russia Premium Database")
						|| product_text.equalsIgnoreCase("CDMNext")
						|| product_text.equalsIgnoreCase("API & Integrations")) {
					System.out.println(product_text + " database is present");
				} else {
					fail("Failed");
				}
			}
			if (whats_new.getAttribute("class").contains("select2-dropdown-open")) {
				new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//ul[@class='select2-results']/li[1]/div", 4)).pause(500).click().build().perform();
			}
			List<WebElement> pdf_files = login.driver.findElements(By.className("announcements-files--file-name"));
			for (WebElement pdf_file : pdf_files) {
				String name = pdf_file.getText();
				pdf_file.click();
				ArrayList<String> tabs = new ArrayList<String>(login.driver.getWindowHandles());
				assertEquals(tabs.size(), 2);
				login.driver.switchTo().window(tabs.get(1));
				List<WebElement> app = login.driver.findElements(By.xpath("//embed[@type='application/pdf']"));
				assertEquals(app.size(), 1);
				Robot robot = new Robot();
				Thread.sleep(1000);
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_S);
				robot.keyRelease(KeyEvent.VK_S);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				Thread.sleep(2000);
				robot.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(2000);
				robot.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				robot.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(500);
				File actual_file = new File(System.getProperty("user.home") + "\\Downloads\\file.pdf");
				String runtime_file = System.getProperty("user.home") + "\\Downloads\\" + name;
				File expected_file = new File(runtime_file);
				String spliting[] = runtime_file.split("Downloads\\\\");
				sa.assertEquals(name, spliting[1]);
				FileUtils.copyFile(actual_file, expected_file);
				actual_file.delete();
				expected_file.delete();
				System.out.println("PDF file is downloaded and verified");
				login.driver.switchTo().window(tabs.get(1)).close();
				login.driver.switchTo().window(tabs.get(0));
			}
			CommonFunctionality.getElementByXpath(login.driver, "//span[@class='select2-arrow']", 4).click();
			System.out.println("<====== Insight inside 1 database is opened ====>");
			List<WebElement> products_name_list = CommonFunctionality.getElementsByXpath(login.driver,
					"//ul[@class='select2-results']/li");
			for (int i = 1; i <= products_name_list.size(); i++) {
				if (i != 1 && i != products_name_list.size()) {
					CommonFunctionality.getElementByXpath(login.driver, "//span[@class='select2-arrow']", 4).click();
				}
				System.out.println("<====== Insight inside " + i + " database is opened ====>");
				WebElement product = CommonFunctionality.getElementByXpath(login.driver,
						"//ul[@class='select2-results']/li[" + i + "]", 4);
				product.click();
				CommonFunctionality.wait(3000);
				/*
				 * WebElement loader = login.driver.findElement(By.
				 * cssSelector(".announcements-products-updates .announcements-container--body")
				 * ); if(!loader.getAttribute("class").contains("blocker-loading")) {
				 * fail("Loader not loading"); }
				 */
				List<WebElement> product_name = login.driver.findElements(By.cssSelector(".link.insight-ceic"));
				for (int j = 1; j <= product_name.size(); j++) {
					WebElement product1 = CommonFunctionality.getElementByXpath(login.driver,
							"//*[contains(@class,'insight-ceic')][" + j + "]", 4);
					js.executeScript("arguments[0].scrollIntoView(true);", product1);
					new Actions(login.driver).moveToElement(product1).pause(2000).click().build().perform();
					CommonFunctionality.wait(2000);
					if (login.driver.findElements(By.className("insight-preview--close")).size() == 1) {
						System.out.println(j + " Insight is opened in preview mode");
						CommonFunctionality.getElementByClassName(login.driver, "insight-preview--close", 4).click();
					} else {
						fail("Not opened in preview mode");
					}
				}
			}
			CommonFunctionality.getElementBycssSelector(login.driver, ".link__inverted.modal-icon-button--text", 4)
					.click();
			ArrayList<String> tabs = new ArrayList<String>(login.driver.getWindowHandles());
			assertEquals(tabs.size(), 2);
			login.driver.switchTo().window(tabs.get(1));
			String text = CommonFunctionality.getElementByClassName(login.driver, "landing-header--title", 4).getText();
			login.driver.switchTo().window(tabs.get(1)).close();
			login.driver.switchTo().window(tabs.get(0));
			assertEquals("Announcements", text);
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
			List<WebElement> close = login.driver.findElements(By.className("sphere-modal__close"));
			assertEquals(close.size(), 0);
			System.out.println("The announcement page is opened and the popup is closed successfully");
			System.out.println("<=========== Announcement popup is displayed ===========>");
		}
	}

	@SuppressWarnings("deprecation")
	@Then("^The \"([^\"]*)\" should open in preview mode with limit (\\d+)$")
	public void the_should_open_in_preview_mode_with_limit(String arg1, int arg2) throws Throwable {
		if (arg1.equalsIgnoreCase("Recent Insights")) {
			click("Notifications", "Insights");
			CommonFunctionality.wait(4000);
			// CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+arg1+"']/following::*[contains(@class,'insight-ceic')]")));
			// CommonFunctionality.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='"+arg1+"']/following::*[contains(@class,'insight-ceic')]")));
			List<WebElement> recent_insight = login.driver
					.findElements(By.xpath("//*[text()='" + arg1 + "']/following::*[contains(@class,'insight-ceic')]"));
			sa.assertEquals(recent_insight, arg2);
			System.out.println("The recent insight count is:" + arg2);
			for (int i = 1; i <= recent_insight.size(); i++) {
				new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//*[text()='" + arg1 + "']/following::*[contains(@class,'insight-ceic')][" + i + "]", 4))
						.pause(2000).click().build().perform();
				CommonFunctionality.wait(5000);
				// CommonFunctionality.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("insight-preview--close")));
				// CommonFunctionality.wait.until(ExpectedConditions.elementToBeClickable(By.className("insight-preview--close")));
				List<WebElement> preview = login.driver.findElements(By.className("insight-preview--close"));
				CommonFunctionality.getElementByClassName(login.driver, "insight-preview--close", 4).click();
				assertEquals(preview.size(), 1);
				System.out.println("The insight is opened in preview mode");
				if (i != recent_insight.size()) {
					click("Notifications", "Insights");
				}
			}
		}
		if (arg1.equalsIgnoreCase("Latest insights from our experts")) {
			click("Notifications", "Insights");
			CommonFunctionality.wait(3000);
			List<WebElement> recent_insight = login.driver.findElements(By.xpath("//*[text()='" + arg1
					+ "']/following::*[@class='activity-block--content'][1]//*[@class='all-insights-list-item--name-link']"));
			sa.assertEquals(recent_insight, arg2);
			System.out.println("The recent insight count is:" + arg2);
			for (int i = 1; i <= recent_insight.size(); i++) {
				new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"(//*[text()='" + arg1
								+ "']/following::*[@class='activity-block--content'][1]//*[@class='all-insights-list-item--name-link'])["
								+ i + "]",
						4)).pause(500).click().build().perform();
				CommonFunctionality.wait(3000);
				List<WebElement> preview = login.driver.findElements(By.className("insight-preview--close"));
				CommonFunctionality.wait(3000);
				CommonFunctionality.getElementByClassName(login.driver, "insight-preview--close", 4).click();
				assertEquals(preview.size(), 1);
				System.out.println("The insight is opened in preview mode");
				click("Notifications", "Insights");
				CommonFunctionality.wait(3000);

			}
			CommonFunctionality.getElementByXpath(login.driver, "//*[text()='See all expert insights']", 4).click();
			WebElement data = CommonFunctionality.getElementBycssSelector(login.driver, "span[data-id='ANALYSIS']", 4);
			if (data.getAttribute("class").contains("active")
					&& login.driver.findElements(By.className("insights-group--main-wrapper")).size() > 0) {
				System.out.println("The insights in See all expert insights is opened in Analytics tab");
			} else {
				fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("Most popular CEIC Insights")) {
			CommonFunctionality.wait(1000);
			WebElement analysis = CommonFunctionality.getElementByXpath(login.driver, "//span[@data-id='ANALYSIS']", 4);
			if (!analysis.getAttribute("class").contains("series-tab__hidden")) {
				analysis.click();
			}
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'CEIC Insights')]", 4).click();
			WebElement grid = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@title='View as a grid']/parent::div", 4);
			if (grid.getAttribute("class").contains("insights-view-modes__table-mode")) {
				CommonFunctionality.getElementByXpath(login.driver, "//*[@title='View as a grid']", 4).click();
			}
			CommonFunctionality
					.getElementBycssSelector(login.driver, ".custom-select-title--handler.icon--filter-arrow", 4)
					.click();
			CommonFunctionality.getElementBycssSelector(login.driver, "div[title='Popularity']", 4).click();
			CommonFunctionality.wait(4000);
			for (int i = 1; i <= 10; i++) {
				CommonFunctionality.wait(500);
				String analytic_text = CommonFunctionality
						.getElementByXpath(login.driver,
								"(//*[contains(@class,'insight-grid-item--bottom-panel-title')])[" + i + "]", 4)
						.getText();
				analysis_insight.add(analytic_text);
			}
			click("Notifications", "Insights");
			CommonFunctionality.wait(4000);
			List<WebElement> ceic_insight = login.driver.findElements(By.xpath("//*[text()='" + arg1
					+ "']/following::*[@class='activity-block--content'][1]//*[@class='all-insights-list-item--name-link']"));
			sa.assertEquals(ceic_insight, arg2);
			System.out.println("The insight count is " + arg2);
			for (int i = 1; i <= ceic_insight.size(); i++) {
				String ceic_text = CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='" + arg1
						+ "']/following::*[@class='activity-block--content'][1]//*[@class='all-insights-list-item--name-link'])["
						+ i + "]", 4).getText();
				notification_insight.add(ceic_text);
			}
			if (login.driver.findElements(By.xpath("//*[text()='" + arg1
					+ "']/following::*[@class='activity-block--content'][1]//*[@class='all-insights-list-item--name-link']"))
					.size() > 0) {
				for (int i = 1; i <= ceic_insight.size(); i++) {
					if (i != 1) {
						click("Notifications", "Insights");
					}
					CommonFunctionality.wait(3000);
					new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"(//*[text()='" + arg1
									+ "']/following::*[@class='activity-block--content'][1]//*[@class='all-insights-list-item--name-link'])["
									+ i + "]",
							4)).pause(2000).click().build().perform();
					CommonFunctionality.wait(10000);
					List<WebElement> preview = login.driver.findElements(By.className("insight-preview--close"));
					assertEquals(preview.size(), 1);
					System.out.println("The insight is opened in preview mode");
					CommonFunctionality.wait(8000);
					try {
						CommonFunctionality.getElementByXpath(login.driver, "//*[@class='insight-preview--close']", 4)
								.click();
					} catch (Exception e) {

					}

				}
			}
			boolean result = Arrays.equals(analysis_insight.toArray(), notification_insight.toArray());
			login.Log4j.info("Date Comparision is: \n" + result);
			assertEquals(analysis_insight.toArray(), notification_insight.toArray());
			login.Log4j.info("Both the insights are same and has been verified successfully");
		}
		if (arg1.equalsIgnoreCase("Latest EMIS Insights")) {
			WebElement analysis = CommonFunctionality.getElementByXpath(login.driver, "//span[@data-id='ANALYSIS']", 4);
			if (!analysis.getAttribute("class").contains("series-tab__hidden")) {
				analysis.click();
			}
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(@class,'navigation-sidebar')]//*[contains(text(),'EMIS Insights')]", 4)
					.click();
			WebElement grid = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@title='View as a grid']/parent::div", 4);
			if (grid.getAttribute("class").contains("insights-view-modes__table-mode")) {
				CommonFunctionality.getElementByXpath(login.driver, "//*[@title='View as a grid']", 4).click();
			}
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='insights-control']//*[@class='custom-select-title--handler icon--filter-arrow']", 4)
					.click();
			WebElement recent = CommonFunctionality.getElementByXpath(login.driver, "//div[@title='Recently created']",
					4);
			if (!recent.getAttribute("class").contains("custom-select-item__selected")) {
				CommonFunctionality.getElementBycssSelector(login.driver, "div[title='Recently created']", 4).click();
			} else {
				CommonFunctionality.getElementBycssSelector(login.driver,
						".custom-select-title--handler.icon--filter-arrow .icon--filter-arrow", 4).click();
			}
			CommonFunctionality.wait(5000);
			for (int i = 1; i <= 10; i++) {
				String analytic_text = CommonFunctionality
						.getElementByXpath(login.driver,
								"(//*[contains(@class,'insight-grid-item--bottom-panel-title')])[" + i + "]", 4)
						.getText();
				analysis_insight.add(analytic_text);
			}
			click("Notifications", "Insights");
			CommonFunctionality.wait(4000);
			List<WebElement> ceic_insight = login.driver.findElements(By.xpath("//*[text()='" + arg1
					+ "']/following::*[@class='activity-block--content'][1]//*[@class='all-insights-list-item--name-link']"));
			sa.assertEquals(ceic_insight, arg2);
			System.out.println("The insight count is " + arg2);
			for (int i = 1; i <= ceic_insight.size(); i++) {
				String ceic_text = CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='" + arg1
						+ "']/following::*[@class='activity-block--content'][1]//*[@class='all-insights-list-item--name-link'])["
						+ i + "]", 4).getText();
				notification_insight.add(ceic_text);
			}
			if (login.driver.findElements(By.xpath("//*[text()='" + arg1
					+ "']/following::*[@class='activity-block--content'][1]//*[@class='all-insights-list-item--name-link']"))
					.size() > 0) {
				for (int i = 1; i <= ceic_insight.size(); i++) {
					if (i != 1) {
						click("Notifications", "Insights");
					}
					new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"(//*[text()='" + arg1
									+ "']/following::*[@class='activity-block--content'][1]//*[@class='all-insights-list-item--name-link'])["
									+ i + "]",
							4)).pause(2000).click().build().perform();
					CommonFunctionality.wait(5000);
					List<WebElement> preview = login.driver.findElements(By.className("insight-preview--close"));
					assertEquals(preview.size(), 1);
					System.out.println("The insight is opened in preview mode");
					CommonFunctionality.wait(8000);
					try {
						CommonFunctionality.getElementByXpath(login.driver, "//*[@class='insight-preview--close']", 4)
								.click();
					} catch (Exception e) {

					}
				}
			}
			boolean result = Arrays.equals(analysis_insight.toArray(), notification_insight.toArray());
			login.Log4j.info("Date Comparision is: \n" + result);
			assertEquals(analysis_insight.toArray(), notification_insight.toArray());
			login.Log4j.info("Both the insights are same and has been verified successfully");
		}
	}

	@Given("^Click on Help$")
	public void click_on_Help() throws Throwable {
		// click_on_File_menu();
		CommonFunctionality.getElementByProperty(login.driver, "HELP", 4).click();
	}

	@SuppressWarnings("deprecation")
	@Given("^Click on Help dropdown$")
	public void click_on_Help_dropdown() throws Throwable {
		CommonFunctionality.wait(1000);
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[@class='help-title']", 4)).pause(500).click().build().perform();
	}

	@Given("^Click on contact us$")
	public void click_on_contact_us() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Contactus"))).click();
		Thread.sleep(10000);
	}

	@Given("^Verify redirection to contact page$")
	public void verify_redirection_to_contact_page() throws Throwable {
		switch_to_new_tab();
		String ExpectedURL = "https://www.ceicdata.com/en/contact_us.htm";
		String Actualurl = login.driver.getCurrentUrl();
		assertEquals(Actualurl, ExpectedURL);
		System.out.println("The contact us has been verified");
		close_new_tab();
	}

	@Given("^Click on Email us$")
	public void click_on_Email_us() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Email"))).click();
		Thread.sleep(3000);
	}

	@Given("^Verify Email us pop up is shown$")
	public void verify_Email_us_pop_up_is_shown() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Emailus_popup"))).size() != 0) {
			System.out.println("Email pop up is shown");
			close_insight();
		} else {
			close_insight();
			Assert.fail("FAIL");
		}
	}

	@Given("^Verify red color for mandatory fields$")
	public void verify_red_color_for_mandatory_fields() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_save_enable"))).click();
		Thread.sleep(3000);
		WebElement subjectinputbox = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_subject")));
		String colorCode = subjectinputbox.getCssValue("border-color");
		String expectedColorCodeInRGB = "rgb(228, 41, 39)";
		// Asserting actual and expected color codes
		assertEquals(colorCode, expectedColorCodeInRGB);
		WebElement Messageinputbox = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_message")));
		String colorCodeMessage = Messageinputbox.getCssValue("border-color");
		String expectedColorCodeInRGBMess = "rgb(228, 41, 39)";
		// Asserting actual and expected color codes
		Assert.assertEquals(colorCodeMessage, expectedColorCodeInRGBMess);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
	}

	@SuppressWarnings("deprecation")
	@Then("^The \"([^\"]*)\" field is adding the text$")
	public void the_field_is_adding_the_text(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Subject")) {
			WebElement sub = CommonFunctionality.getElementByXpath(login.driver, "//input[@name='subject']", 4);
			sub.sendKeys("Shravas");
			CommonFunctionality.getElementBycssSelector(login.driver, ".sphere-modal-control.button__primary", 4)
					.click();
			if (sub.getAttribute("class").contains("ecommerce-contact-us__not-valid")) {
				fail("Subject field not editable");
			} else {
				System.out.println("Subject field has been verified successfully");
			}
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		}
		if (arg1.equalsIgnoreCase("Invalid mail in CC")) {
			CommonFunctionality.getElementByXpath(login.driver, "//input[@name='subject']", 4).sendKeys("Shravas");
			WebElement cc = CommonFunctionality.getElementByXpath(login.driver, "//input[@name='cc']", 4);
			cc.sendKeys("12345");
			CommonFunctionality.getElementByXpath(login.driver, "//textarea[@name='message']", 4)
					.sendKeys("For testing purpose, Please ignore!");
			CommonFunctionality.getElementBycssSelector(login.driver, ".sphere-modal-control.button__primary", 4)
					.click();
			if (cc.getAttribute("class").contains("ecommerce-contact-us__not-valid")) {
				System.out.println("This field allow only email");
			} else {
				fail("Email field allows not only mails");
			}
			CommonFunctionality.getElementByXpath(login.driver, "//input[@name='subject']", 4).clear();
			CommonFunctionality.getElementByXpath(login.driver, "//input[@name='subject']", 4).sendKeys("Shravas");
			cc.clear();
			cc.sendKeys("ceicsuresh10@gmail.com");
			CommonFunctionality.getElementByXpath(login.driver, "//textarea[@name='message']", 4).clear();
			CommonFunctionality.getElementByXpath(login.driver, "//textarea[@name='message']", 4)
					.sendKeys("For testing purpose, Please ignore!");
			CommonFunctionality.getElementBycssSelector(login.driver, ".sphere-modal-control.button__primary", 4)
					.click();
			CommonFunctionality.wait(1000);
			if (login.driver.findElements(By.className("growl-message-content")).size() > 0) {
				System.out.println("Mail has been sent successfully");
			} else {
				fail("Email field verify failed");
			}
		}
		if (arg1.equalsIgnoreCase("Multiple mails in CC")) {
			CommonFunctionality.getElementByXpath(login.driver, "//input[@name='subject']", 4).sendKeys("Shravas");
			WebElement cc = CommonFunctionality.getElementByXpath(login.driver, "//input[@name='cc']", 4);
			cc.sendKeys("12345,ceicsuresh10@gmail.com");
			CommonFunctionality.getElementByXpath(login.driver, "//textarea[@name='message']", 4)
					.sendKeys("For testing purpose, Please ignore!");
			CommonFunctionality.getElementBycssSelector(login.driver, ".sphere-modal-control.button__primary", 4)
					.click();
			if (cc.getAttribute("class").contains("ecommerce-contact-us__not-valid")) {
				System.out.println("Multiple mail validation message occurs");
			} else {
				fail("Validation not appeared");
			}
			CommonFunctionality.getElementByXpath(login.driver, "//input[@name='subject']", 4).clear();
			CommonFunctionality.getElementByXpath(login.driver, "//input[@name='subject']", 4).sendKeys("Shravas");
			cc.clear();
			cc.sendKeys("ceicsuresh11@gmail.com,ceicsuresh10@gmail.com");
			CommonFunctionality.getElementByXpath(login.driver, "//textarea[@name='message']", 4).clear();
			CommonFunctionality.getElementByXpath(login.driver, "//textarea[@name='message']", 4)
					.sendKeys("For testing purpose, Please ignore!");
			CommonFunctionality.getElementBycssSelector(login.driver, ".sphere-modal-control.button__primary", 4)
					.click();
			if (login.driver.findElements(By.className("growl-message-content")).size() > 0) {
				System.out.println("Mail has been sent successfully");
			} else {
				fail("Email field verify failed");
			}
		}
		if (arg1.equalsIgnoreCase("No CC")) {
			// WebElement cc = CommonFunctionality.getElementByXpath(login.driver,
			// "//input[@name='cc']", 4);
			CommonFunctionality.getElementByXpath(login.driver, "//input[@name='subject']", 4).sendKeys("Shravas");
			// cc.sendKeys("ceicsuresh11@gmail.com,ceicsuresh10@gmail.com");
			CommonFunctionality.getElementByXpath(login.driver, "//textarea[@name='message']", 4)
					.sendKeys("For testing purpose, Please ignore!");
			CommonFunctionality.getElementBycssSelector(login.driver, ".sphere-modal-control.button__primary", 4)
					.click();
			if (login.driver.findElements(By.className("growl-message-content")).size() > 0) {
				System.out.println("Mail has been sent successfully without CC");
			} else {
				fail("Email field verify failed");
			}
		}
		if (arg1.equalsIgnoreCase("Message")) {
			WebElement message = CommonFunctionality.getElementByXpath(login.driver, "//textarea[@name='message']", 4);
			message.sendKeys("Test");
			CommonFunctionality.getElementBycssSelector(login.driver, ".sphere-modal-control.button__primary", 4)
					.click();
			if (message.getAttribute("class").contains("ecommerce-contact-us__not-valid")) {
				fail("Message field not editable");
			} else {
				System.out.println("Message field has been verified successfully");
			}
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		}
		if (arg1.equalsIgnoreCase("Your message was sent successfully")) {
			CommonFunctionality.getElementByXpath(login.driver, "//input[@name='subject']", 4).sendKeys("Shravas");
			CommonFunctionality.getElementByXpath(login.driver, "//textarea[@name='message']", 4)
					.sendKeys("For testing purpose, Please ignore!");
			CommonFunctionality.getElementBycssSelector(login.driver, ".sphere-modal-control.button__primary", 4)
					.click();
			CommonFunctionality.wait(250);
			String growl = login.driver.findElement(By.className("growl-message-text")).getText();
			assertEquals(arg1, growl);
			System.out.println("The growl message has been verified successfully");
		}
		if (arg1.equalsIgnoreCase("Growl autoclose")) {
			CommonFunctionality.getElementByXpath(login.driver, "//input[@name='subject']", 4).sendKeys("Shravas");
			CommonFunctionality.getElementByXpath(login.driver, "//textarea[@name='message']", 4)
					.sendKeys("For testing purpose, Please ignore!");
			CommonFunctionality.getElementBycssSelector(login.driver, ".sphere-modal-control.button__primary", 4)
					.click();
			CommonFunctionality.wait(7000);
			List<WebElement> growl_popup = login.driver.findElements(By.className("growl-message-content"));
			assertEquals(growl_popup.size(), 0);
			System.out.println("The growl message size has been verified successfully");
		}
		if (arg1.equalsIgnoreCase("Attachment upload")) {
			CommonFunctionality.getElementByXpath(login.driver, "//input[@name='subject']", 4).sendKeys("Shravas");
			CommonFunctionality.getElementByXpath(login.driver, "//textarea[@name='message']", 4)
					.sendKeys("For testing purpose, Please ignore!");
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByClassName(login.driver, "dz-message", 4)).pause(500)
					.click().build().perform();
			CommonFunctionality.uploadTheFileusingAutoIT(login.driver,
					System.getProperty("user.dir") + "\\AutoIT\\Shravas.exe",
					System.getProperty("user.dir") + "\\AutoIT\\Shravas.png");
			CommonFunctionality.wait(2000);
			if (login.driver.findElements(By.className("dz-image")).size() > 0) {
				System.out.println("The image has been uploaded and verified successfully");
			} else {
				fail("Image not uploaded");
			}
			CommonFunctionality.getElementBycssSelector(login.driver, ".sphere-modal-control.button__primary", 4)
					.click();
		}
		if (arg1.equalsIgnoreCase("Attachment remove")) {
			CommonFunctionality.getElementByXpath(login.driver, "//input[@name='subject']", 4).sendKeys("Shravas");
			CommonFunctionality.getElementByXpath(login.driver, "//textarea[@name='message']", 4)
					.sendKeys("For testing purpose, Please ignore!");
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByClassName(login.driver, "dz-message", 4)).pause(500)
					.click().build().perform();
			CommonFunctionality.uploadTheFileusingAutoIT(login.driver,
					System.getProperty("user.dir") + "\\AutoIT\\Shravas.exe",
					System.getProperty("user.dir") + "\\AutoIT\\Shravas.png");
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByClassName(login.driver, "dz-remove", 4)).pause(500)
					.click().build().perform();
			CommonFunctionality.wait(2000);
			WebElement remove = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='dz-message']/parent::div", 4);
			if (remove.getAttribute("class").contains("dz-max-files-reached")) {
				fail("Removing image failed");
			} else {
				System.out.println("The image has been removed and verified successfully");
			}
			CommonFunctionality.getElementBycssSelector(login.driver, ".sphere-modal-control.button__primary", 4)
					.click();
		}
	}

	@Given("^Enter all fields$")
	public void enter_all_fields() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_subject"))).sendKeys("Testing");
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_CC")))
				.sendKeys("bshilpa@isimarkets.com,bshilpa@shravas.com");
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_message"))).sendKeys("Testing please ignore");
		Thread.sleep(2000);

	}

	@Given("^Upload file using upload button$")
	public void upload_file_using_upload_button() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_uploadfile"))).click();
		Thread.sleep(2000);
		String downloadPath = System.getProperty("user.home") + "\\Downloads\\SampleImage.JPG";
		login.driver.switchTo().activeElement();
		StringSelection s = new StringSelection(downloadPath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		Robot robot = new Robot();
		robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
		robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
		robot.keyPress(java.awt.event.KeyEvent.VK_V);
		robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
		Thread.sleep(6000);
		robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		Thread.sleep(9000);
	}

	@Given("^Click on Send$")
	public void click_on_Send() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_save_enable"))).click();
		Thread.sleep(8000);
	}

	@Given("^Verify confirmation message is shown$")
	public void verify_confirmation_message_is_shown() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Save_Message_text"))).size() != 0) {
			System.out.println("Email sent message is shown");

		} else {

			Assert.fail("FAIL");
		}
		Thread.sleep(6000);
	}

	// TC_InsightGeneral_117

	@Given("^Enter all fields with no recipient$")
	public void enter_all_fields_with_no_recipient() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_subject"))).sendKeys("Testing");
		Thread.sleep(2000);

		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_message"))).sendKeys("Testing please ignore");
		Thread.sleep(2000);

	}

	@Given("^Upload file using drag and drop$")
	public void upload_file_using_drag_and_drop() throws Throwable {
		String downloadPath = System.getProperty("user.home") + "\\Downloads\\SampleImage.JPG";

		WebElement dropArea = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_droparea")));
		DropFile(new File(downloadPath), dropArea, 0, 0);
		Thread.sleep(4000);
	}

	// TC_InsightGeneral_118
	@Given("^Verify invalid  email under recipient$")
	public void verify_invalid_email_under_recipient() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_subject"))).sendKeys("Testing");
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_CC"))).sendKeys("AAA");
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_message"))).sendKeys("Testing please ignore");
		Thread.sleep(2000);
		click_on_Send();
		WebElement subjectinputbox = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_CC")));
		String colorCode = subjectinputbox.getCssValue("border-color");
		System.out.println("Color code in RGB" + colorCode);
		String expectedColorCodeInRGB = "rgb(228, 41, 39)";
		// Asserting actual and expected color codes
		Assert.assertEquals(colorCode, expectedColorCodeInRGB);
		Thread.sleep(2000);
		close_insight();
	}

	// TC_InsightGeneral_119
	@Given("^Verify remove option for attachments\\.$")
	public void verify_remove_option_for_attachments() throws Throwable {
		upload_file_using_upload_button();
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_attachment"))).size() != 0) {
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_attachment"))).size() != 0) {

				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Remove_attachment"))).click();
				Thread.sleep(3000);
				System.out.println("Attachment removed");
				close_insight();
			} else {
				close_insight();
				Assert.fail("FAIL");
			}

		}
	}

	// TC_InsightGeneral_120

	@Given("^Verify 'Cancel/Dismiss' button in Email popup\\.$")
	public void verify_Cancel_Dismiss_button_in_Email_popup() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Emailus_popup"))).size() != 0) {
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).size() != 0) {

				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
				Thread.sleep(3000);
				System.out.println("Pop up closed");
			} else {
				Assert.fail("FAIL");
			}

		}
	}

	// TC_InsightGeneral_121
	@Given("^Click on Knowledge base$")
	public void click_on_Knowledge_base() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Knowledgebase"))).click();
	}

	@Given("^Verify 'Knowledge base'$")
	public void verify_Knowledge_base() throws Throwable {
		switch_to_new_tab();
		CommonFunctionality.wait(4000);
		String ExpectedURL = "https://support.ceicdata.com/support/solutions";
		String Actualurl = login.driver.getCurrentUrl();
		assertEquals(Actualurl, ExpectedURL);
		close_new_tab();
		System.out.println("Knowledge base is verified");
	}

	// TC_InsightGeneral_122
	@Given("^Click on Diagnostics$")
	public void click_on_Diagnostics() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Diagnostic"))).click();
	}

	@Given("^Verify 'Diagnostics'\\.$")
	public void verify_Diagnostics() throws Throwable {
		switch_to_new_tab();
		String ExpectedURL = "https://stage.ceicdata.com/status";
		String Actualurl = login.driver.getCurrentUrl();
		Assert.assertEquals(Actualurl, ExpectedURL);
		close_new_tab();
	}

	// TC_InsightGeneral_123
	@Given("^Verify Diagnostics configurations options\\.$")
	public void verify_Diagnostics_configurations_options() throws Throwable {
		switch_to_new_tab();
		CommonFunctionality.wait(5000);
		String configStatus = "Success";
		String configcolor = "#53b582";
		String local_storage = CommonFunctionality
				.getElementByXpath(login.driver, "//*[text()='LocalStorage/SessionStorage']/following-sibling::div", 4)
				.getText();
		String local_storage_color = CommonFunctionality
				.getElementByXpath(login.driver, "//*[text()='LocalStorage/SessionStorage']/following-sibling::div", 4)
				.getCssValue("background-color");
		String websocket = CommonFunctionality
				.getElementByXpath(login.driver, "//*[text()='WebSocket']/following-sibling::div", 4).getText();
		String websocket_color = CommonFunctionality
				.getElementByXpath(login.driver, "//*[text()='WebSocket']/following-sibling::div", 4)
				.getCssValue("background-color");
		String cookies = CommonFunctionality
				.getElementByXpath(login.driver, "//*[text()='Cookies']/following-sibling::div", 4).getText();
		String cookies_color = CommonFunctionality
				.getElementByXpath(login.driver, "//*[text()='Cookies']/following-sibling::div", 4)
				.getCssValue("background-color");
		String authentication = CommonFunctionality
				.getElementByXpath(login.driver, "//*[text()='CEIC Authentication System']/following-sibling::div", 4)
				.getText();
		String authentication_color = CommonFunctionality
				.getElementByXpath(login.driver, "//*[text()='CEIC Authentication System']/following-sibling::div", 4)
				.getCssValue("background-color");
		String backend = CommonFunctionality
				.getElementByXpath(login.driver, "//*[text()='CDMNext Backend']/following-sibling::div", 4).getText();
		String backend_color = CommonFunctionality
				.getElementByXpath(login.driver, "//*[text()='CDMNext Backend']/following-sibling::div", 4)
				.getCssValue("background-color");
		String notification = CommonFunctionality
				.getElementByXpath(login.driver, "//*[text()='CDMNext Notification']/following-sibling::div", 4)
				.getText();
		String notification_color = CommonFunctionality
				.getElementByXpath(login.driver, "//*[text()='CDMNext Notification']/following-sibling::div", 4)
				.getCssValue("background-color");
		String solr = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'CDMNext Search Insights Service')]/following-sibling::div", 4).getText();
		String solr_color = CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[contains(text(),'CDMNext Search Insights Service')]/following-sibling::div", 4)
				.getCssValue("background-color");
		String java = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'CDMNext Search Series Service')]/following-sibling::div", 4).getText();
		String java_color = CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[contains(text(),'CDMNext Search Series Service')]/following-sibling::div", 4)
				.getCssValue("background-color");
		String mongoDB = CommonFunctionality
				.getElementByXpath(login.driver, "//*[text()='Content document']/following-sibling::div", 4).getText();
		String mongoDB_color = CommonFunctionality
				.getElementByXpath(login.driver, "//*[text()='Content document']/following-sibling::div", 4)
				.getCssValue("background-color");
		String amazon_s3 = CommonFunctionality
				.getElementByXpath(login.driver, "//*[text()='Objects resources']/following-sibling::div", 4).getText();
		String amazon_s3_color = CommonFunctionality
				.getElementByXpath(login.driver, "//*[text()='Objects resources']/following-sibling::div", 4)
				.getCssValue("background-color");
		String knowledge = CommonFunctionality
				.getElementByXpath(login.driver, "//*[text()='Knowledge Base']/following-sibling::div", 4).getText();
		String knowledge_color = CommonFunctionality
				.getElementByXpath(login.driver, "//*[text()='Knowledge Base']/following-sibling::div", 4)
				.getCssValue("background-color");
		String fd = CommonFunctionality
				.getElementByXpath(login.driver, "//*[text()='Freshchat']/following-sibling::div", 4).getText();
		String fd_color = CommonFunctionality
				.getElementByXpath(login.driver, "//*[text()='Freshchat']/following-sibling::div", 4)
				.getCssValue("background-color");
		assertEquals(local_storage, configStatus);
		assertEquals(Color.fromString(local_storage_color).asHex(), configcolor);
		assertEquals(websocket, configStatus);
		assertEquals(Color.fromString(websocket_color).asHex(), configcolor);
		assertEquals(cookies, configStatus);
		assertEquals(Color.fromString(cookies_color).asHex(), configcolor);
		assertEquals(authentication, configStatus);
		assertEquals(Color.fromString(authentication_color).asHex(), configcolor);
		assertEquals(backend, configStatus);
		assertEquals(Color.fromString(backend_color).asHex(), configcolor);
		assertEquals(notification, configStatus);
		assertEquals(Color.fromString(notification_color).asHex(), configcolor);
		assertEquals(solr, configStatus);
		assertEquals(Color.fromString(solr_color).asHex(), configcolor);
		assertEquals(java, configStatus);
		assertEquals(Color.fromString(java_color).asHex(), configcolor);
		assertEquals(mongoDB, configStatus);
		assertEquals(Color.fromString(mongoDB_color).asHex(), configcolor);
		assertEquals(amazon_s3, configStatus);
		assertEquals(Color.fromString(amazon_s3_color).asHex(), configcolor);
		assertEquals(knowledge, configStatus);
		assertEquals(Color.fromString(knowledge_color).asHex(), configcolor);
		assertEquals(fd, configStatus);
		assertEquals(Color.fromString(fd_color).asHex(), configcolor);
		System.out.println("The status page is verified");
		close_new_tab();
	}

	// TC_InsightGeneral_124
	@Given("^Verify 'Report a problem' in Diagnostics page\\.$")
	public void verify_Report_a_problem_in_Diagnostics_page() throws Throwable {
		switch_to_new_tab();
		WebElement Element = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Report_Prob")));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Report_Prob"))).click();
		Thread.sleep(5000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Report_popup"))).size() != 0) {
			System.out.println("Report pop up is shown");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_report_close"))).click();
			close_new_tab();
		} else {
			close_new_tab();
			Assert.fail("FAIL");
		}
	}

	@Given("^verify 'Send' button on Report a problem window\\.$")
	public void verify_Send_button_on_Report_a_problem_window() throws Throwable {
		switch_to_new_tab();
		CommonFunctionality.webDriverwait_keyvalue("Ig_Report_Prob");
		WebElement element = CommonFunctionality.getElementByProperty(login.driver, "Ig_Report_Prob", 4);
		js.executeScript("arguments[0].scrollIntoView();", element);
		element.click();
		CommonFunctionality.getElementByProperty(login.driver, "Ig_desc", 4)
				.sendKeys("For Testing purpose, please ignore!");
		CommonFunctionality.getElementByProperty(login.driver, "Ig_report_send", 4).click();
		String alertMessage = "Your issue has been successfully sent to our support team. We apologize for any inconvenience caused. Thank you for your patience.";
		CommonFunctionality.wait.until(ExpectedConditions.alertIsPresent());
		String alertText = login.driver.switchTo().alert().getText();
		login.driver.switchTo().alert().accept();
		assertEquals(alertMessage, alertText);
		System.out.println("Alert accepted and report window verified");
	}

	@Given("^Verify 'Attachments' on Report a problem$")
	public void verify_Attachments_on_Report_a_problem() throws Throwable {
		switch_to_new_tab();
		CommonFunctionality.webDriverwait_keyvalue("Ig_Report_Prob");
		WebElement element = CommonFunctionality.getElementByProperty(login.driver, "Ig_Report_Prob", 4);
		js.executeScript("arguments[0].scrollIntoView();", element);
		element.click();
		CommonFunctionality.getElementByXpath(login.driver, "//textarea[@class='report-problem-s--message']", 4)
				.sendKeys("For testing purpose, please ignore!");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_attach_screenshot"))).click();
		Thread.sleep(2000);
		CommonFunctionality.uploadTheFileusingAutoIT(login.driver,
				System.getProperty("user.dir") + "\\AutoIT\\Shravas.exe",
				System.getProperty("user.dir") + "\\AutoIT\\Shravas.png");
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_report_send"))).click();
		Thread.sleep(2000);
		CommonFunctionality.wait.until(ExpectedConditions.alertIsPresent());
		String alertMessage = "Your issue has been successfully sent to our support team. We apologize for any inconvenience caused. Thank you for your patience.";
		String alertText = login.driver.switchTo().alert().getText();
		if (alertMessage.equalsIgnoreCase(alertText)) {
			System.out.println("Report Sent");
			// System.out.println(alertText);
			login.driver.switchTo().alert().accept();
			close_new_tab();
		} else {
			close_new_tab();
			Assert.fail("FAIL");
		}
	}

	@Given("^Verify description and attach screenshot$")
	public void verify_description_and_attach_screenshot() throws Throwable {
		if (login.driver.findElements(By.className("report-problem-s--modal-content")).size() > 0) {
			CommonFunctionality.getElementByXpath(login.driver, "//textarea[@class='report-problem-s--message']", 4)
					.sendKeys("For testing purpose, please ignore!");
			String bgcolor = CommonFunctionality
					.getElementByXpath(login.driver, "//textarea[@class='report-problem-s--message']", 4)
					.getCssValue("border");
			String split[] = bgcolor.split("solid ");
			String actual = Color.fromString(split[1]).asHex();
			assertEquals(actual, "#732b7b");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_attach_screenshot"))).click();
			Thread.sleep(2000);
			CommonFunctionality.uploadTheFileusingAutoIT(login.driver,
					System.getProperty("user.dir") + "\\AutoIT\\Shravas.exe",
					System.getProperty("user.dir") + "\\AutoIT\\Shravas.png");
			Thread.sleep(2000);
			if (login.driver.findElements(By.xpath("//span[text()='Shravas.png']")).size() == 1) {
				System.out.println("Image uploaded and description field enabled");
				CommonFunctionality.getElementByClassName(login.driver, "report-problem-s--header-close", 4).click();
			} else {
				fail("Image not uploaded");
			}
		} else {
			fail("Report popup not opened");
		}
	}

	@And("^Verify the WPS addin$")
	public void verify_the_WPS_addin() throws Throwable {
		String text = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='installation__header']/span", 4)
				.getText();
		String split[] = text.split("Version ");
		System.out.println("The WPS addin version is: " + split[1]);
		String url = CommonFunctionality
				.getElementBycssSelector(login.driver, ".installation-download-button__button", 4).getAttribute("href");
		CommonFunctionality.getElementBycssSelector(login.driver, ".installation-download-button__button", 4).click();
		String split1[] = url.split("cdmplugin/");
		String version = CommonFunctionality
				.getElementByClassName(login.driver, "installation-download-description__text", 4).getText();
		String path = System.getProperty("user.dir") + "\\Downloads\\" + version;
		Files.deleteIfExists(Paths.get(path));
		String split2[] = version.split("\\(");
		String split3[] = split2[1].split("\\)");
		CommonFunctionality.wait(3000);
		CommonFunctionality.getElementBycssSelector(login.driver, ".installation-documentation--document-link", 4)
				.click();
		ArrayList<String> tabs = new ArrayList<String>(login.driver.getWindowHandles());
		assertEquals(tabs.size(), 2);
		login.driver.switchTo().window(tabs.get(1));
		System.out.println("The documentation is opening in new tab");
		login.driver.switchTo().window(tabs.get(1)).close();
		login.driver.switchTo().window(tabs.get(0));
		String description1 = "The CDMNext Addin for WPS mainly provides the option for CEIC users to refresh data with links downloaded from CDMNext application.";
		String description2 = "Installation requires .NET Framework 4.6.1 or higher to be installed prior to starting the installation program.";
		String description3 = ".NET Framework 4.6.1 is compatible with Windows 7, 8, 8.1 and 10. It is bundled in since Windows 10 Version 1511 from November 2015.";
		String expected = CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='installation__block'][1]", 4).getText();
		if (expected.contains(description1) && expected.contains(description2) && expected.contains(description3)) {
			System.out.println("The description is matching");
		} else {
			fail("Description mismatch");
		}
		assertEquals(split[1], split3[0]);
		assertEquals(version, split1[1]);
	}

	// TC_InsightGeneral_127
	@Given("^Verify 'Cancel and dismiss' buttons on the window\\.$")
	public void verify_Cancel_and_dismiss_buttons_on_the_window() throws Throwable {
		switch_to_new_tab();
		WebElement Element = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Report_Prob")));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Report_Prob"))).click();
		Thread.sleep(5000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Report_popup"))).size() != 0) {
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_report_close"))).size() != 0) {

				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_report_close"))).click();
				Thread.sleep(3000);
				System.out.println("Pop up closed");
			} else {
				Assert.fail("FAIL");
			}

		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Report_Prob"))).click();
		Thread.sleep(5000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Report_popup"))).size() != 0) {
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_report_close"))).size() != 0) {

				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Close"))).click();
				Thread.sleep(3000);
				System.out.println("Pop up closed");
				close_new_tab();
			} else {
				close_new_tab();
				Assert.fail("FAIL");
			}

		}
	}

	// TC_InsightGeneral_128
	@Given("^Click on Report button$")
	public void click_on_Report_button() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_ReportProblem_option"))).click();
		Thread.sleep(5000);
	}

	@Given("^Verify 'Report a problem' under Help menu\\.$")
	public void verify_Report_a_problem_under_Help_menu() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Report_popup"))).size() != 0) {
			System.out.println("Report pop up is shown");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_report_close"))).click();

		} else {

			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_129
	@Given("^Enter the description$")
	public void enter_the_description() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_desc"))).sendKeys("Testing please ignore");
		Thread.sleep(2000);
	}

	@Given("^Add the attachment$")
	public void add_the_attachment() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_attach_screenshot"))).click();
		Thread.sleep(2000);
		CommonFunctionality.uploadTheFileusingAutoIT(login.driver,
				System.getProperty("user.dir") + "\\AutoIT\\Shravas.exe",
				System.getProperty("user.dir") + "\\AutoIT\\Shravas.png");
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_report_send"))).click();
		Thread.sleep(10000);
	}

	@Given("^Verify Send Report$")
	public void verify_Send_Report() throws Throwable {
		CommonFunctionality.wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='growl-messages-container']")));
		if (login.driver.findElements(By.xpath("//*[@class='growl-messages-container']")).size() > 0) {
			System.out.println("Report pop up is shown");
		} else {
			fail("FAIL");
		}
	}

	@Given("^Verify Cancel/x buttons for report a problem under HElp dropdown\\.$")
	public void verify_Cancel_x_buttons_for_report_a_problem_under_HElp_dropdown() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Report_popup"))).size() != 0) {
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_report_close"))).size() != 0) {

				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_report_close"))).click();
				Thread.sleep(3000);
				System.out.println("Pop up closed");
			} else {
				Assert.fail("FAIL");
			}

		}

	}

	// TC_InsightGeneral_131
	@Given("^Click on Live chat$")
	public void click_on_Live_chat() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_livechat_off"))).click();
		Thread.sleep(2000);

	}

	@Given("^Verify Live Chat Option$")
	public void verify_Live_Chat_Option() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_livechat_on"))).click();
		Thread.sleep(2000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_live_chat"))).size() != 0) {
			System.out.println("live chat is shown");

		} else {
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_132
	@Given("^Click on Vedio tutorial$")
	public void click_on_Vedio_tutorial() throws Throwable {

		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_vedio_tutorial"))).click();
		Thread.sleep(3000);

	}

	public void sidebar() throws Exception {
		WebElement slidebar = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_slidebar")));
		Thread.sleep(7000);
		action.moveToElement(slidebar).build().perform();

	}

	public void playbtn() throws Exception {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_play_btn"))).click();

	}

	public void verify_remaining_time() throws Exception {
		WebElement progressBar1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_slidebar")));
		Thread.sleep(3000);
		action.moveToElement(progressBar1).build().perform();

		String remainingTime = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_remaining_time")))
				.getText();
		Thread.sleep(3000);
		System.out.println(remainingTime);
		String remainTime = "-0:00";
		if (!remainingTime.matches(remainTime)) {
			System.out.println("Vedio played ");
		} else {
			Assert.fail("Vedio did not play");
		}
	}

	public void pause() {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_pause"))).click();
	}

	@Given("^Verify 'Video tutorials'$")
	public void verify_Video_tutorials() throws Throwable {
		// Ig_CDMNextv3.0Overview
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_CDMNextv3.0Overview"))).click();
		Thread.sleep(10000);
		sidebar();
		playbtn();
		verify_remaining_time();
		Thread.sleep(3000);
		// Ig_CDMNext_Add-in_v3.0_Overview
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_CDMNext_Add-in_v3.0_Overview"))).click();
		Thread.sleep(10000);
		sidebar();
		verify_remaining_time();
		Thread.sleep(3000);
		// Ig_CDMNextv3.0Overview
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Overview_of_CDMNext_application"))).click();
		Thread.sleep(20000);
		sidebar();
		pause();
		verify_remaining_time();
		Thread.sleep(3000);
		WebElement ele1 = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("Ig_how_to_search_and_navigate")));
		((JavascriptExecutor) login.driver).executeScript("arguments[0].scrollIntoView();", ele1);
		// Ig_how_to_search_and_navigate
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_how_to_search_and_navigate"))).click();
		Thread.sleep(10000);
		sidebar();
		pause();
		verify_remaining_time();
		Thread.sleep(3000);
		WebElement ele2 = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("Ig_how_to_create_visuals_and_transform_se")));
		((JavascriptExecutor) login.driver).executeScript("arguments[0].scrollIntoView();", ele2);
		// Ig_how_to_create_visuals_and_transform_se
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_how_to_create_visuals_and_transform_se")))
				.click();
		Thread.sleep(10000);
		sidebar();
		pause();
		verify_remaining_time();
		Thread.sleep(3000);
		WebElement ele3 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Session_3")));
		((JavascriptExecutor) login.driver).executeScript("arguments[0].scrollIntoView();", ele3);
		// Ig_Session_3
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Session_3"))).click();
		Thread.sleep(10000);
		sidebar();
		pause();
		verify_remaining_time();
		Thread.sleep(3000);
		WebElement ele4 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Session_4")));
		((JavascriptExecutor) login.driver).executeScript("arguments[0].scrollIntoView();", ele4);
		// Ig_Session_4
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Session_4"))).click();
		Thread.sleep(10000);
		sidebar();
		pause();
		verify_remaining_time();
		Thread.sleep(3000);
		WebElement ele5 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Session_5")));
		((JavascriptExecutor) login.driver).executeScript("arguments[0].scrollIntoView();", ele5);
		// Ig_Session_5
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Session_5"))).click();
		Thread.sleep(10000);
		sidebar();
		pause();
		verify_remaining_time();
		WebElement ele6 = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Session_6_how_to_get_help")));
		((JavascriptExecutor) login.driver).executeScript("arguments[0].scrollIntoView();", ele6);
		// Ig_Session_6_how_to_get_help
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Session_6_how_to_get_help"))).click();
		Thread.sleep(10000);
		sidebar();
		pause();
		verify_remaining_time();
		Thread.sleep(3000);

		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Vedio_close"))).click();
	}

	// TC_InsightGeneral_133
	@Given("^Click on Quick Start Guide$")
	public void click_on_Quick_Start_Guide() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Quick_guide"))).click();
		Thread.sleep(10000);
	}

	@Given("^Verify 'Quick start Guide'$")
	public void verify_Quick_start_Guide() throws Throwable {
		switch_to_new_tab();
		String actualURL = "https://stage.ceicdata.com/file?path=/guides/pdfs/5ab597e0-ca6c-4d2e-92a7-ff5eeb7d4b3d";
		String expectedURL = login.driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL);
		close_new_tab();
	}

	// TC_InsightGeneral_134
	@Given("^Verify window dismiss button\\.$")
	public void verify_window_dismiss_button() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_vedio_popup"))).size() != 0) {
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Vedio_close"))).size() != 0) {
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Vedio_close"))).click();
				System.out.println("vedio pop up closed");
			} else {
				Assert.fail("FAIL");
			}

		}

	}

	// TC_InsightGeneral_135
	@Given("^Click on Tour$")
	public void click_on_Tour() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_tour_btn"))).click();
	}

	@Given("^Verify tours$")
	public void verify_tours() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Tour"))).size() != 0) {
			System.out.println("Tour is shown");
			login.driver.findElement(By.xpath("//*[@id='HintView']/div[1]")).click();
		} else {
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_136
	@Given("^Click on Help Menu$")
	public void click_on_Help_Menu() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("HELP"))).click();
		Thread.sleep(3000);
	}

	@Given("^Set preference to Insight Explorer$")
	public void set_preference_to_Insight_Explorer() throws Throwable {
		Footnotes f = new Footnotes();
		f.set_the_Preference_to_insight_explorer();
		f.click_on_CEIC_logo();
	}

	@Given("^Verify Tour to landing page$")
	public void verify_Tour_to_landing_page() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_landingpg_1"))).size() != 0) {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_tour_next_btn"))).click();
			Thread.sleep(3000);
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_landingpg_2"))).size() != 0) {
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_tour_next_btn"))).click();
				Thread.sleep(3000);
				if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_landingpg_3"))).size() != 0) {
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_tour_next_btn"))).click();
					Thread.sleep(3000);
					if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_landingpg_4"))).size() != 0) {
						System.out.println("Tour guide about landing page");
						Footnotes f = new Footnotes();
						f.set_the_Preference_to_new_insight();
						Thread.sleep(3000);
						f.click_on_CEIC_logo();
					}
				}
			}
		} else {
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_137
	@Given("^Verify Tour to Search Panel$")
	public void verify_Tour_to_Search_Panel() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Tour1"))).size() != 0) {
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_tour_next_btn"))).click();
			Thread.sleep(3000);
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Tour2"))).size() != 0) {
				System.out.println("Tour guide about Search Panel");

			} else {
				Assert.fail("FAIL");
			}
		}

	}

	// TC_InsightGeneral_138
	@Given("^Verify Tour to My series$")
	public void verify_Tour_to_My_series() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_tour_next_btn"))).click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_tour_next_btn"))).click();
		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Tour3"))).size() != 0) {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_tour_next_btn"))).click();
			Thread.sleep(3000);
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Tour4"))).size() != 0) {
				System.out.println("Tour guide about my series");
			} else {
				Assert.fail("FAIL");
			}
		}

	}

	// TC_InsightGeneral_139
	@Given("^Verify Tour to visuals$")
	public void verify_Tour_to_visuals() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_addview_btn"))).click();
		Thread.sleep(2000);
		click_on_Help();
		click_on_Tour();
		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Tour5"))).size() != 0) {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_tour_next_btn"))).click();
			Thread.sleep(3000);
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Tour6"))).size() != 0) {
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_tour_next_btn"))).click();
				Thread.sleep(3000);
				if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Tour7"))).size() != 0) {
					System.out.println("Tour guide about Visuals");
					delete_all_views();
				}
			}
		} else {
			Assert.fail("FAIL");
		}

	}

	// TC_InsightGeneral_140
	@Given("^Click on Next Tour$")
	public void click_on_Next_Tour() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_tour_next_btn"))).click();
		Thread.sleep(3000);
	}

	@Given("^Verify Previous button$")
	public void verify_Previous_button() throws Throwable {

		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Previous_Tour"))).click();
		Thread.sleep(3000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Tour1"))).size() != 0) {
			System.out.println("Previous tour should be displayed");
		} else {
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_141
	@Given("^Verify 'I'm Done' option\\.$")
	public void verify_I_m_Done_option() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_i_m_done"))).size() != 0) {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_i_m_done"))).click();
			System.out.println(" Tour is closed");
		} else {
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_142
	@Given("^Verify window 'dismiss\\(x\\)' option\\.$")
	public void verify_window_dismiss_x_option() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_tour_close"))).size() != 0) {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_tour_close"))).click();
			System.out.println(" Tour is closed");
		} else {
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_143
	@Given("^Click on Search Help$")
	public void click_on_Search_Help() throws Throwable {

		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Search_Help"))).click();
		Thread.sleep(3000);
	}

	@Given("^Verify 'search help'$")
	public void verify_search_help() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_keyword_tip"))).size() != 0) {

			System.out.println(" Keyword search tips opened");
			close_insight();
		} else {
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_144
	@Given("^Verify serarch help window close buttons\\.$")
	public void verify_serarch_help_window_close_buttons() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_keyword_close"))).size() != 0) {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_keyword_close"))).click();
			System.out.println(" Keyword search tips closed");

		} else {
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_145
	@Given("^Click on Keyboard shortcuts$")
	public void click_on_Keyboard_shortcuts() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_keyboard_shortcut"))).click();
		Thread.sleep(3000);
	}

	@Given("^Verify 'Keyboard shortcuts'$")
	public void verify_Keyboard_shortcuts() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_keyboard_shortcut_win"))).size() != 0) {
			System.out.println(" Keyword shortcut window open");
			close_insight();
		} else {
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_146
	@Given("^Click on Application Excel Addin$")
	public void click_on_Application_Excel_Addin() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Excel_addin"))).click();
		Thread.sleep(3000);
	}

	@Given("^Verify Excel Addin tab is open$")
	public void verify_Excel_Addin_tab_is_open() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Excel_addin_tab"))).size() != 0) {
			System.out.println("Excel addin tab is open");
			close_insight();
		} else {
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_147
	@Given("^Verify Excel add-in version in popup$")
	public void verify_Excel_add_in_version_in_popup() throws Throwable {
		String actual = "Download CDMNext Addin for Microsoft Excel® Version";
		String Expected_Excel_addin_ver = CommonFunctionality
				.getElementByProperty(login.driver, "Ig_excel_addin_ver", 4).getText();
		String split[] = Expected_Excel_addin_ver.split("Version ");
		String expected = split[0] + "Version";
		assertEquals(actual, expected);
		close_insight();
	}

	@SuppressWarnings("deprecation")
	@Given("^Verify 'OS and MS Office' selection on popup\\.$")
	public void verify_OS_and_MS_Office_selection_on_popup() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Ig_excel_win_drpdwn", 4).click();
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByProperty(login.driver, "Ig_64bit", 4))
				.pause(500).build().perform();
		CommonFunctionality.getElementByProperty(login.driver, "Ig_64bit", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "Ig_excel_win_drpdwn", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "Ig_select_win8", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "Ig_excel_office_drpdwn", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "Ig_office2013", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "Ig_excel_office_drpdwn", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "Ig_select_office", 4).click();
		String Actual_MS_win_version = "Windows 8";
		String Actual_MS_office_version = "Office 2010";
		String Ex_MS_win_version = CommonFunctionality.getElementByProperty(login.driver, "Ig_MS_win_ver", 4).getText();
		String Ex_MS_office_version = CommonFunctionality.getElementByProperty(login.driver, "Ig_Ms_Office_ver", 4)
				.getText();
		CommonFunctionality.getElementByProperty(login.driver, "MYINSIGHTS_CLOSE", 4).click();
		assertEquals(Ex_MS_win_version, Actual_MS_win_version);
		assertEquals(Ex_MS_office_version, Actual_MS_office_version);
		System.out.println("Office and excel version in Excel addin popup is verified");
	}

	@Given("^Verify 'Download' CDMNext add-in navigate to new tab$")
	public void verify_Download_CDMNext_add_in_navigate_to_new_tab() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Ig_download_addin_btn", 4).click();
		String Actual_URL = "https://www.ceicdata.com/client/cdmplugin/SetupCDMNext";
		String Ex_URL = CommonFunctionality
				.getElementBycssSelector(login.driver, ".installation-download-button__button", 4).getAttribute("href");
		if (Ex_URL.contains(Actual_URL)) {
			System.out.println("Navigating to new tab");
		} else {
			fail("Verification Failed");
		}
		close_insight();
	}

	// TC_InsightGeneral_150
	@Given("^Click on Document link$")
	public void click_on_Document_link() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Document_links"))).click();
	}

	@Given("^Verify available 'Documents' in add-in popup$")
	public void verify_available_Documents_in_add_in_popup() throws Throwable {
		switch_to_new_tab();
		String Actual_URL = "https://www.ceicdata.com/client/cdmplugin/CDMNext%20Addin%20Start%20Guide3.2.pdf";
		String Ex_URL = login.driver.getCurrentUrl();
		close_new_tab();
		assertEquals(Actual_URL, Ex_URL);
		close_insight();
	}

	// TC_InsightGeneral_151
	@Given("^Verify 'Open' the popup with new tab$")
	public void verify_Open_the_popup_with_new_tab() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "open_icon", 4).click();
		switch_to_new_tab();
		URL url = new URL(login.CONFIG.getProperty("testsiteURL"));
		String Actual_URL = url.getProtocol() + "://" + url.getHost() + "/Untitled-insight/myseries";
		String Ex_URL = login.driver.getCurrentUrl();
		close_new_tab();
		assertEquals(Actual_URL, Ex_URL);
		close_insight();
	}

	// TC_InsightGeneral_152
	@Given("^Verify Popup dismiss\\(x\\) option\\.$")
	public void verify_Popup_dismiss_x_option() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).size() != 0) {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
			System.out.println("Excel addin pop up is closed");

		} else {
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_153
	@Given("^Click on API tab and Verify$")
	public void click_on_API_tab_and_Verify() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Ig_API", 4).click();
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_API_view"))).size() != 0) {
			System.out.println("API tab is open");
		} else {
			close_insight();
			fail("API tab failed");
		}
	}

	@Given("^Click on R tab and Verify$")
	public void click_on_R_tab_and_Verify() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Ig_R", 4).click();
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_R_view"))).size() != 0) {
			System.out.println("R tab is open");
		} else {
			close_insight();
			fail("R tab Failed");
		}
	}

	@Given("^Click on Eviews tab and Verify$")
	public void click_on_Eviews_tab_and_Verify() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Views"))).click();
		Thread.sleep(10000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_E_View"))).size() != 0) {

			System.out.println("EViews tab is open");
			close_insight();
		} else {
			close_insight();
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_154
	@Given("^Click on API and Verify$")
	public void click_on_API_and_Verify() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Help_Api"))).click();
		Thread.sleep(2000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_API_tab"))).size() != 0) {

			System.out.println("API tab is active");
			close_insight();
		} else {
			close_insight();
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_155
	private File getLatestFilefromDir(String dirPath) {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}

	@Given("^Click on API$")
	public void click_on_API() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Help_Api"))).click();
		Thread.sleep(3000);
	}

	@Given("^Click on Python SDK and Verify 'API SDK' download$")
	public void click_on_Python_SDK_and_Verify_API_SDK_download() throws Throwable {
		String file = CommonFunctionality
				.getElementByClassName(login.driver, "installation-download-description__text", 4).getText();
		CommonFunctionality.getElementByProperty(login.driver, "Ig_SDK_dwnload", 4).click();
		CommonFunctionality.wait(5000);
		String path = System.getProperty("user.home") + "\\Downloads\\" + file;
		String downloadPath = System.getProperty("user.home") + "\\Downloads";
		File getLatestFile = getLatestFilefromDir(downloadPath);
		String fileName = getLatestFile.getName();
		String sdk = CommonFunctionality.getElementByProperty(login.driver, "sdk1", 4).getText();
		boolean text = fileName.equalsIgnoreCase(sdk);
		assertTrue(text, "Downloaded");
		Files.deleteIfExists(Paths.get(path));
		System.out.println("Python sdk download is verified");
		close_insight();
	}

	// TC_InsightGeneral_156
	@Given("^Verify 'API SDK' download through URL$")
	public void verify_API_SDK_download_through_URL() throws Throwable {
		String downloadURL = null;
		if (login.CONFIG.getProperty("testsiteURL").equalsIgnoreCase("https://stage.ceicdata.com/")) {
			downloadURL = "https://downloads-stage.ceicdata.com/php/";
		}
		if (login.CONFIG.getProperty("testsiteURL").equalsIgnoreCase("https://insights.ceicdata.com/")) {
			downloadURL = "https://downloads.ceicdata.com/php/";
		}
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_SDK_drpdwn"))).click();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_select_php"))).click();
		// String copiedText=
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_text"))).getText();
		String text = "require: {ceic/api: *}," + "repositories" + ":[{type: composer," + "url: " + downloadURL + ""
				+ " }]";
		String[] parts = text.split("url:");
		String part2 = parts[1];
		parts = part2.split("}]");
		part2 = parts[0];
		js.executeScript("window.open('" + part2 + "')");
		ArrayList<String> tabs = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs.get(1));
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_download_file"))).click();
		Thread.sleep(5000);
		String path = System.getProperty("user.home") + "\\Downloads\\ceic-api-1.1.0.2.zip";
		String downloadPath = System.getProperty("user.home") + "\\Downloads";
		File getLatestFile = getLatestFilefromDir(downloadPath);
		String fileName = getLatestFile.getName();
		boolean filedwnloaded = fileName.equalsIgnoreCase("ceic-api-1.1.0.2.zip");
		login.driver.switchTo().window(tabs.get(1)).close();
		login.driver.switchTo().window(tabs.get(0));
		Files.deleteIfExists(Paths.get(path));
		assertTrue(filedwnloaded, "Failed to download");
		close_insight();
	}

	@And("^Verify documents opening in new tab$")
	public void verify_documents_opening_in_new_tab() throws Throwable {
		List<WebElement> documents = CommonFunctionality.getElementsByXpath(login.driver,
				"//div[@class='installation-documentation--document']");
		for (int i = 1; i <= documents.size(); i++) {
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"(//*[contains(@class,'installation-documentation--document-link')])[" + i + "]", 4))
					.click().build().perform();
			ArrayList<String> tabs = new ArrayList<String>(login.driver.getWindowHandles());
			assertEquals(tabs.size(), 2);
			login.driver.switchTo().window(tabs.get(1));
			System.out.println("Document is opening in new tab");
			login.driver.switchTo().window(tabs.get(1)).close();
			login.driver.switchTo().window(tabs.get(0));
		}
		close_insight();
	}

	@Given("^Verify Popup dismiss option$")
	public void verify_Popup_dismiss_option() throws Throwable {
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		List<WebElement> dismiss = login.driver.findElements(By.cssSelector(".installations-modal-title"));
		assertEquals(dismiss.size(), 0);
		System.out.println("The popup is closed and verified");
	}

	@Given("^Click on R$")
	public void click_on_R() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_help_R"))).click();
		Thread.sleep(3000);
	}

	@Given("^Verify R tab is open$")
	public void verify_R_tab_is_open() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_R_tab"))).size() != 0) {

			System.out.println("R tab is active");
			close_insight();
		} else {
			close_insight();
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_158
	@Given("^Verify 'R' package download$")
	public void verify_R_package_download() throws Throwable {
		File file = new File(System.getProperty("user.home") + "\\Downloads\\ceic_1.1.0-5.tar.gz");
		file.delete();
		Thread.sleep(7000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_R_pck_dwnload"))).click();
		Thread.sleep(8000);
		String downloadPath = System.getProperty("user.home") + "\\Downloads";
		File getLatestFile = getLatestFilefromDir(downloadPath);
		String fileName = getLatestFile.getName();
		Thread.sleep(5000);
		System.out.println(fileName);
		boolean text = fileName.equalsIgnoreCase("ceic_1.1.0-5.tar.gz");
		Assert.assertTrue(text, "Failed to download");
		close_insight();
	}

	@SuppressWarnings("deprecation")
	@Given("^Click on \"([^\"]*)\" -> \"([^\"]*)\"$")
	public void click_on(String arg1, String arg2) throws Throwable {
		if (arg1.equalsIgnoreCase("Help")) {
			CommonFunctionality.wait(1000);
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByClassName(login.driver, "help-title", 4)).pause(500)
					.click().build().perform();
		}
		if (arg2.equalsIgnoreCase("Live chat")) {
			new Actions(login.driver)
					.moveToElement(
							CommonFunctionality.getElementByClassName(login.driver, "help-popup--live-chat-toggle", 4))
					.pause(500).click().build().perform();
		} else {
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//div[contains(@class,'help-popup--item') and contains(text(),'" + arg2 + "')]", 4))
					.pause(500).click().build().perform();
		}
	}

	// TC_InsightGeneral_160
	@Given("^Click on Document links and Verify$")
	public void click_on_Document_links_and_Verify() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_R_doc_link"))).click();
		switch_to_new_tab();
		String Actual_URL = "https://downloads-stage.ceicdata.com/R/documentation/CEIC%20R%20Package%20-%20Quick%20Start%20Guide.pdf";
		String Ex_URL = login.driver.getCurrentUrl();
		close_new_tab();
		Assert.assertEquals(Actual_URL, Ex_URL);
		close_insight();
	}

	// TC_InsightGeneral_161
	@Given("^Click on Eviews$")
	public void click_on_Eviews() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_help_eviews"))).click();
		Thread.sleep(3000);

	}

	@Given("^Verify 'EViews'$")
	public void verify_EViews() throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_eview_tab_open"))).size() != 0) {

			System.out.println("Eview tab is active");
			close_insight();
		} else {
			close_insight();
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_162
	@Given("^Click on Download CEIC EViews Module (\\d+)-Bit and Verify$")
	public void click_on_Download_CEIC_EViews_Module_Bit_and_Verify(int arg1) throws Throwable {

		File file = new File(System.getProperty("user.home") + "\\Downloads\\CEICData-Eviews_32_1.1.zip");
		file.delete();

		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_eview_32bit"))).click();
		Thread.sleep(5000);
		String downloadPath = System.getProperty("user.home") + "\\Downloads";
		File getLatestFile = getLatestFilefromDir(downloadPath);
		String fileName = getLatestFile.getName();
		Thread.sleep(5000);
		System.out.println(fileName);
		boolean text = fileName.equalsIgnoreCase("CEICData-Eviews_32_1.1.zip");
		Assert.assertTrue(text, "Failed to download");
	}

	@Then("^Verify the option for \"([^\"]*)\" with \"([^\"]*)\"$")
	public void verify_the_option_for_with(String arg1, String arg2) throws Throwable {
		List<WebElement> help = login.driver.findElements(By.xpath("//*[text()='" + arg1
				+ "']/following-sibling::*[@class='help-popup--items']//*[contains(text(),'" + arg2 + "')]"));
		assertEquals(help.size(), 1);
		String text = CommonFunctionality
				.getElementByXpath(login.driver, "//*[text()='" + arg1
						+ "']/following-sibling::*[@class='help-popup--items']//*[contains(text(),'" + arg2 + "')]", 4)
				.getText();
		assertEquals(text, arg2);
		System.out.println("The text present for " + arg1 + " is " + arg2);
	}

	@Then("^Verify the option for the \"([^\"]*)\" with \"([^\"]*)\"$")
	public void verify_the_option_for_the_with(String arg1, String arg2) throws Throwable {
		List<WebElement> help = login.driver
				.findElements(By.xpath("//*[text()='" + arg1 + "']/following::*[text()='" + arg2 + "']"));
		assertEquals(help.size(), 1);
		String text = CommonFunctionality
				.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']/following::*[text()='" + arg2 + "']", 4)
				.getText();
		assertEquals(text, arg2);
		System.out.println("The text present for " + arg1 + " is " + arg2);
	}

	@SuppressWarnings("deprecation")
	@Then("^The available videos should be played$")
	public void the_available_videos_should_be_played() throws Throwable {
		CommonFunctionality.wait(2000);
		List<WebElement> videos = CommonFunctionality.getElementsByXpath(login.driver,
				"//div[@class='learn-tutorials-item--title']/span");
		for (int i = 1; i <= videos.size(); i++) {
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"(//div[@class='learn-tutorials-item--title'])[" + i + "]/span", 4))
					.pause(500).click().build().perform();
			WebElement play = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'learn-tutorials-item learn-tutorials-item__selected')]", 4);
			if (i == 1) {
				new Actions(login.driver)
						.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
								"(//div[@class='learn-tutorials-item--title'])[" + i + "]/span", 4))
						.pause(500).click().build().perform();
				if (!(play.getAttribute("class").contains("learn-tutorials-item__playing"))) {
					fail("play button is not enabled");
				}
			}
			if (i != 1) {
				if (!(play.getAttribute("class").contains("learn-tutorials-item__playing"))) {
					fail("play button is not enabled");
				}
			}
			CommonFunctionality.wait(200);
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByClassName(login.driver, "vjs-control-bar", 4))
					.pause(500).perform();
			List<WebElement> maximize = login.driver.findElements(By.cssSelector("button[title='Fullscreen']"));
			assertEquals(maximize.size(), 1);
			CommonFunctionality.getElementBycssSelector(login.driver, "button[title='Fullscreen']", 4).click();
			List<WebElement> minimize = login.driver.findElements(By.cssSelector("button[title='Non-Fullscreen']"));
			assertEquals(minimize.size(), 1);
			CommonFunctionality.getElementBycssSelector(login.driver, "button[title='Non-Fullscreen']", 4).click();
		}
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		System.out.println("The video tutorials has been verified successfully");
	}

	@Then("^The \"([^\"]*)\" should open in new tab$")
	public void the_should_open_in_new_tab(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//a[text()='" + arg1 + "']", 4).click();
		ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
		assertEquals(newTab.size(), 2);
		login.driver.switchTo().window(newTab.get(1));
		System.out.println(arg1 + " is opening in new tab");
		login.driver.switchTo().window(newTab.get(1)).close();
		login.driver.switchTo().window(newTab.get(0));
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
	}

	@Then("^The popup window should be closed$")
	public void the_popup_window_should_be_closed() throws Throwable {
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		List<WebElement> close = login.driver.findElements(By.className("movable-modal--close"));
		assertEquals(close.size(), 0);
		System.out.println("The popup window is closed");
	}

	@Then("^The tour should be started$")
	public void the_tour_should_be_started() throws Throwable {
		CommonFunctionality.wait(1000);
		if (login.driver.findElements(By.id("HintView")).size() > 0) {
			for (int i = 1; i <= 11; i++) {
				boolean previous = login.driver.findElement(By.xpath("//button[contains(text(),'Previous')]"))
						.isEnabled();
				boolean next = login.driver.findElement(By.xpath("//button[contains(text(),'Next')]")).isEnabled();
				if (i == 1) {
					if (next == true) {
						login.driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
						System.out.println("The next button is clickable and navigating to next tour of count " + i);
					} else {
						fail("Not enabled");
					}
				}
				if (i == 2) {
					if (previous == true) {
						login.driver.findElement(By.xpath("//button[contains(text(),'Previous')]")).click();
						List<WebElement> previous_button = login.driver
								.findElements(By.xpath("//div[text()='How do I search?']"));
						assertEquals(previous_button.size(), 1);
						System.out.println(
								"The previous button is clickable and navigating to previous tour of count " + i);
						login.driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
					} else {
						fail("Not enabled");
					}
				}
				if (i > 2 & i < 11) {
					if (next == true) {
						login.driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
						System.out.println("Clicking on next button is navigating to next tour of count " + i);
					} else {
						fail("Not enabled");
					}
				}
				if (i == 11) {
					if (login.driver.findElements(By.xpath("//button[contains(text(),'Finish tour')]")).size() > 0) {
						login.driver.findElement(By.xpath("//button[contains(text(),'Finish tour')]")).click();
						List<WebElement> popup = login.driver.findElements(By.id("HintView"));
						assertEquals(popup.size(), 0);
						System.out.println("The tours has been verified and count is " + i);
					} else {
						fail("The size is not equal");
					}
				}
			}
		} else {
			fail("Tour popup not opened");
		}
	}

	@Then("^The tour should be closed$")
	public void the_tour_should_be_closed() throws Throwable {
		CommonFunctionality.getElementByClassName(login.driver, "help-bubble-close-icon", 4).click();
		List<WebElement> popup = login.driver.findElements(By.id("HintView"));
		assertEquals(popup.size(), 0);
		System.out.println("The tours has been verified as the tour popup closed");
	}

	@Then("^The Start guide is opening in new tab$")
	public void the_Start_guide_is_opening_in_new_tab() throws Throwable {
		CommonFunctionality.wait(2000);
		ArrayList<String> newTab = new ArrayList<String>(login.driver.getWindowHandles());
		assertEquals(newTab.size(), 2);
		login.driver.switchTo().window(newTab.get(1));
		System.out.println("The guide is opening in new tab");
		login.driver.switchTo().window(newTab.get(1)).close();
		login.driver.switchTo().window(newTab.get(0));
	}

	@Then("^The keyword search tips window should open$")
	public void the_keyword_search_tips_window_should_open() throws Throwable {
		List<WebElement> search = CommonFunctionality.getElementsByXpath(login.driver,
				"//*[contains(@class,'sphere-modal__title') and text()='Keyword search tips']");
		assertEquals(search.size(), 1);
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		List<WebElement> close = login.driver.findElements(By.cssSelector(".modal-title.sphere-modal__title"));
		assertEquals(close.size(), 0);
		System.out.println("The keyword search tips window has been verified");
	}

	@Then("^The keyboard shortcuts window should open$")
	public void the_keyboard_shortcuts_window_should_open() throws Throwable {
		List<WebElement> search = CommonFunctionality.getElementsByXpath(login.driver,
				"//*[contains(@class,'sphere-modal__title') and text()='Keyboard Shortcuts']");
		assertEquals(search.size(), 1);
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		System.out.println("The keyboard shortcuts window has been verified");
	}

	@Then("^The Footnotes window should open$")
	public void the_Footnotes_window_should_open() throws Throwable {
		List<WebElement> footnotes = CommonFunctionality.getElementsByXpath(login.driver,
				"//*[contains(@class,'footnotes-modal--name') and contains(text(),'Footnotes')]");
		assertEquals(footnotes.size(), 1);
		CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 4).click();
		System.out.println("The Footnotes window has been verified");
	}

	@Then("^The Live chat is \"([^\"]*)\"$")
	public void the_Live_chat_is(String arg1) throws Throwable {
		WebElement chat = CommonFunctionality.getElementByXpath(login.driver,
				"//div[contains(@class,'bootstrap-switch-animate')]", 4);
		if (arg1.equalsIgnoreCase("ON")) {
			if (chat.getAttribute("class").contains("bootstrap-switch-on")) {
				System.out.println("Already chat is on");
			} else {
				chat.click();
			}
			if (chat.getAttribute("class").contains("bootstrap-switch-on")) {
				System.out.println("Live chat is on and has been verified");
			} else {
				fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("OFF")) {
			if (chat.getAttribute("class").contains("bootstrap-switch-off")) {
				System.out.println("Already chat is off");
			} else {
				chat.click();
			}
			if (chat.getAttribute("class").contains("bootstrap-switch-off")) {
				System.out.println("Live chat is off and has been verified");
			} else {
				fail("Verification Failed");
			}
		}
	}

	@Given("^Click on Download CEIC EViews Module (\\d+)-Bit$")
	public void click_on_Download_CEIC_EViews_Module_Bit(int arg1) throws Throwable {

		File file = new File(System.getProperty("user.home") + "\\Downloads\\CEICData-Eviews_64_1.1.zip");
		file.delete();

		Thread.sleep(7000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_eview_64bit"))).click();
		Thread.sleep(5000);
		String downloadPath = System.getProperty("user.home") + "\\Downloads";
		File getLatestFile = getLatestFilefromDir(downloadPath);
		String fileName = getLatestFile.getName();
		Thread.sleep(5000);
		System.out.println(fileName);
		boolean text = fileName.equalsIgnoreCase("CEICData-Eviews_64_1.1.zip");
		Assert.assertTrue(text, "Failed to download");
		close_insight();
	}

	// TC_InsightGeneral_163
	@Given("^Click on  Eviews Document links and Verify$")
	public void click_on_Eviews_Document_links_and_Verify() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_R_doc_link"))).click();
		switch_to_new_tab();
		String Actual_URL = "https://downloads-stage.ceicdata.com/eviews/documentation/CEIC-EViews%20Module%20-%20Quick%20Start%20Guide.pdf";
		String Ex_URL = login.driver.getCurrentUrl();
		close_new_tab();
		Assert.assertEquals(Actual_URL, Ex_URL);
		close_insight();
	}

	// TC_InsightGeneral_164
	@Given("^Add Series to myseries$")
	public void add_Series_to_myseries() throws Throwable {
		adding_series_to_myseries();
	}

	@Given("^Verify Undo option enable\\.$")
	public void verify_Undo_option_enable() throws Throwable {
		boolean undo = login.driver.findElement(By.cssSelector("div[title='Undo (Ctrl+Z)']")).isEnabled();
		if (undo == true) {
			System.out.println("Undo icon is enabled");
			CommonFunctionality.DeleteSeries();
		} else {
			fail("Not enabled");
		}
	}

	// TC_InsightGeneral_165
	@SuppressWarnings("deprecation")
	@Given("^Click on Undo icon$")
	public void click_on_Undo_icon() throws Throwable {
		CommonFunctionality.webDriverwait_keyvalue("Ig_series_undo");
		WebElement undo = CommonFunctionality.getElementByProperty(login.driver, "Ig_series_undo", 4);
		new Actions(login.driver).moveToElement(undo).pause(500).click().build().perform();
	}

	@And("^Capture the myseries name$")
	public void capture_the_myseries_name() throws Throwable {
		CommonFunctionality.wait(500);
		myseries_name = CommonFunctionality.getElementByClassName(login.driver, "series-name-field--series-name", 4).getText();
	}

	@Given("^Verify Redo option enable$")
	public void verify_Redo_option_enable() throws Throwable {
		boolean redo = login.driver.findElement(By.cssSelector("div[title='Redo (Ctrl+Y)']")).isEnabled();
		if (redo == true) {
			CommonFunctionality.getElementByProperty(login.driver, "Series_tab", 4).click();
			CommonFunctionality.getElementByProperty(login.driver, "my_series_filter_checkbox", 4).click();
			CommonFunctionality.getElementByProperty(login.driver, "delete_myeries", 4).click();
			System.out.println("Redo icon is enabled");
		} else {
			fail("Not enabled");
		}
	}

	@Given("^Verify refresh behavior$")
	public void verify_refresh_behavior() throws Throwable {
		CommonFunctionality.DeleteSeries();
		login.driver.navigate().refresh();
		CommonFunctionality.wait(2000);
		WebElement undo = login.driver.findElement(By.cssSelector("div[title='Undo (Ctrl+Z)']"));
		WebElement redo = login.driver.findElement(By.cssSelector("div[title='Redo (Ctrl+Y)']"));
		if (undo.getAttribute("class").contains("button__disabled")
				&& redo.getAttribute("class").contains("button__disabled")) {
			System.out.println("Undo and Redo operations are in disabled state");
		} else {
			fail("Not in disabled state");
		}
	}

	@Given("^Verify edit visual behavior$")
	public void verify_edit_visual_behavior() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement undo = login.driver.findElement(By.cssSelector("div[title='Undo (Ctrl+Z)']"));
		WebElement redo = login.driver.findElement(By.cssSelector("div[title='Redo (Ctrl+Y)']"));
		if (undo.getAttribute("class").contains("button__disabled")
				&& redo.getAttribute("class").contains("button__disabled")) {
			System.out.println("Undo and Redo operations are in disabled state");
		} else {
			fail("Not in disabled state");
		}
		CommonFunctionality.Views_list();
	}

	// TC_InsightGeneral_166
	@Given("^Adding series to myseries$")
	public void adding_series_to_myseries() throws Throwable {
		Footnotes f = new Footnotes();
		f.goto_Db_Search_tab();
		f.expand_the_database();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_seriestoadd"))).click();
		Thread.sleep(2000);
		action.sendKeys("a").perform();
	}

	@Given("^Verify Undo option behavior for My series tab\\.$")
	public void verify_Undo_option_behavior_for_My_series_tab() throws Throwable {
		CommonFunctionality.wait(2000);
		List<WebElement> series = login.driver.findElements(By.className("series-name-field--series-name"));
		assertEquals(series.size(), 0);
		System.out.println("The undo operation behaviour is verified");
	}

	@Given("^Click on Redo icon$")
	public void click_on_Redo_icon() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByProperty(login.driver, "Ig_redo", 4).click();
	}

	@Given("^Verify Redo option behavior for my series tab\\.$")
	public void verify_Redo_option_behavior_for_my_series_tab() throws Throwable {
		String redo = CommonFunctionality.getElementByClassName(login.driver, "series-name-field--series-name", 4)
				.getText();
		assertEquals(redo, myseries_name);
		System.out.println("The redo operation is performed successfully");
		CommonFunctionality.DeleteSeries();
	}

	@Given("^Add Visual$")
	public void add_Visual() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Ig_addview_btn", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "Ig_addview_btn", 4).click();
	}

	@Given("^Add a Visual$")
	public void add_a_Visual() throws Throwable {
		CrossSection cs = new CrossSection();
		cs.search_for_the_series_with_SID_and_click_on_option("7892501", "C");
	}

	@Given("^Verify Undo option for views tab\\.$")
	public void verify_Undo_option_for_views_tab() throws Throwable {
		List<WebElement> undo = login.driver.findElements(By.cssSelector("span[data-name='title']"));
		assertEquals(undo.size(), 0);
		System.out.println("The undo operation for views tab is performed");
	}

	@Given("^Verify Redo option for views tab\\.$")
	public void verify_Redo_option_for_views_tab() throws Throwable {
		List<WebElement> redo = login.driver.findElements(By.cssSelector("span[data-name='title']"));
		assertEquals(redo.size(), 1);
		System.out.println("The redo operation for views tab is performed");
		CommonFunctionality.Views_list();
	}

	@Given("^Adding series to visual$")
	public void adding_series_to_visual() throws Throwable {
		Footnotes f = new Footnotes();
		f.goto_Db_Search_tab();
		f.expand_the_database();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_seriestoadd"))).click();
		Thread.sleep(2000);
		action.sendKeys("c").perform();
	}

	@Given("^Click on Undo and Verify$")
	public void click_on_Undo_and_Verify() throws Throwable {
		click_on_Undo_icon();
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_redo"))).size() != 0) {

			System.out.println("visual with series has been undo");
			// delete_all_views();

		} else {

			Assert.fail("FAIL");
		}
	}

	@Given("^Click on Redo and Verify$")
	public void click_on_Redo_and_Verify() throws Throwable {
		click_on_Redo_icon();
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_visual_series_redo"))).size() != 0) {

			System.out.println("visual with series has been redone");
			Thread.sleep(4000);
			delete_all_views();
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_save_enable"))).click();
		} else {

			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_171
	@Given("^Enter Keyword GDP in Search$")
	public void enter_Keyword_GDP_in_Search() throws Throwable {
		/*
		 * login.driver.findElement(
		 * By.xpath(login.LOCATORS.getProperty("Footnote_Search_input"))) .click();
		 * login.driver.findElement(
		 * By.xpath(login.LOCATORS.getProperty("Footnote_Search_input"))) .clear();
		 */
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Footnote_Search_input"))).sendKeys("GDP");
		Thread.sleep(9000);

	}

	@Given("^Click on Undo and Verify Undo for search tab\\.$")
	public void click_on_Undo_and_Verify_Undo_for_search_tab() throws Throwable {
		click_on_Undo_icon();
		Thread.sleep(4000);
		String ActualundoText = "What can we help you find?";
		String ExpectedText = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_search_undo")))
				.getAttribute("placeholder");
		Assert.assertEquals(ActualundoText, ExpectedText);
		Thread.sleep(2000);
	}

	@Given("^Click on Redo and Verify Redo for search tab\\.$")
	public void click_on_Redo_and_Verify_Redo_for_search_tab() throws Throwable {
		click_on_Redo_icon();
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Ig_Search_redo"))).size() != 0) {
			System.out.println("Redo has been done for search tab");
			click_on_Undo_icon();
			delete_series();
		} else {
			fail("FAIL");
		}
	}
}