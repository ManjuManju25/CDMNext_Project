package CDMNext.StepDefinations;

import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class InsightGeneral {
	Actions action = new Actions(login.driver);
	JavascriptExecutor js = (JavascriptExecutor) login.driver;

	public void click_ceic_logo() {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("ceic_logo"))).click();
	}

	public void switch_to_new_tab() throws Exception {
		ArrayList<String> tabs = new ArrayList<String>(
				login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs.get(1));
		Thread.sleep(15000);
	}

	public void close_new_tab() {
		ArrayList<String> tabs = new ArrayList<String>(
				login.driver.getWindowHandles());
		login.driver.close();
		login.driver.switchTo().window(tabs.get(0));
	}

	public static void DropFile(File filePath, WebElement target, int offsetX,
			int offsetY) {
		if (!filePath.exists())
			throw new WebDriverException("File not found: "
					+ filePath.toString());

		// WebDriver driver = ((RemoteWebElement)target).getWrappedDriver();
		JavascriptExecutor jse = (JavascriptExecutor) login.driver;
		WebDriverWait wait = new WebDriverWait(login.driver, 30);

		String JS_DROP_FILE = "var target = arguments[0],"
				+ "    offsetX = arguments[1],"
				+ "    offsetY = arguments[2],"
				+ "    document = target.ownerDocument || document,"
				+ "    window = document.defaultView || window;"
				+ ""
				+ "var input = document.createElement('INPUT');"
				+ "input.type = 'file';"
				+ "input.style.display = 'none';"
				+ "input.onchange = function () {"
				+ "  var rect = target.getBoundingClientRect(),"
				+ "      x = rect.left + (offsetX || (rect.width >> 1)),"
				+ "      y = rect.top + (offsetY || (rect.height >> 1)),"
				+ "      dataTransfer = { files: this.files };"
				+ ""
				+ "  ['dragenter', 'dragover', 'drop'].forEach(function (name) {"
				+ "    var evt = document.createEvent('MouseEvent');"
				+ "    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);"
				+ "    evt.dataTransfer = dataTransfer;"
				+ "    target.dispatchEvent(evt);"
				+ "  });"
				+ ""
				+ "  setTimeout(function () { document.body.removeChild(input); }, 25);"
				+ "};" + "document.body.appendChild(input);" + "return input;";

		WebElement input = (WebElement) jse.executeScript(JS_DROP_FILE, target,
				offsetX, offsetY);
		input.sendKeys(filePath.getAbsoluteFile().toString());
		wait.until(ExpectedConditions.stalenessOf(input));
	}

	public void delete_insight() throws Exception {
		WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("Fav_Insight_Title")));
		action.moveToElement(ele).build().perform();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_del_in"))).click();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Delete_ok"))).click();
		Thread.sleep(10000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE")))
				.click();
	}

	public void delete_series() throws Exception {
		login.driver.findElement(
				By.xpath(login.LOCATORS
						.getProperty("my_series_filter_checkbox"))).click();
		Thread.sleep(8000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("delete_myeries"))).click();
	}

	public void add_Series() throws Throwable {
		Footnotes f = new Footnotes();
		f.goto_Db_Search_tab();
		f.expand_the_database();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_seriestoadd"))).click();
		Thread.sleep(2000);
		action.sendKeys("a").perform();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_secondseriestoadd")))
				.click();
		Thread.sleep(2000);
		action.sendKeys("a").perform();
	}

	public void delete_all_views() throws Throwable {
		//login.driver.findElement(By.xpath("//body/div[@class='main-content no-touch-device']/div[@class='custom-page-content']/div[@class='page-container']/div[@class='page-content']/div[@class='main-page']/div[@class='main-page--content splitter_panel']/div[@class='main-page--insight right_panel']/div[@class='insight-page']/div[@class='main-page--insight-expanded main-page--section insight-page--container']/div[@class='main-page--insight-active-page']/div[contains(@class,'insight-view')]/div[@class='insight-views-container']/div[@class='insight-view-item insight-view-item-empty insight-view-item-autofit']/div[@class='main-view-container droppable']/div[@class='view-components-over ui-droppable']/div[@class='view-components-over--content']/div[@class='view-components-over--visuals']/div[1]/div[1]")).click();
		WebElement visual1 = login.driver.findElement(By.xpath("//a[@class='insight-page-view-tab--link insight-page-view-tab--link__active']"));
		Thread.sleep(4000);
		action.contextClick(visual1).build().perform();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_DeleteAllviews")))
				.click();
		Thread.sleep(2000);
	
		
	}

	public void close_insight() {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE")))
				.click();
	}

	public void open_insight() throws Exception {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("insights"))).click();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("MY_INSIGHTS"))).click();
		Thread.sleep(4000);
	}

	public void expander() throws Exception {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("search_presentation")))
				.click();
		Thread.sleep(2000);
	}

	// Tc_InsightGeneral_01
	@Given("^Verify CEIC logo$")
	public void verify_CEIC_logo() throws Throwable {
		Thread.sleep(10000);
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("untitledInsight"))).size() != 0) {
			if (login.driver.findElements(
					By.xpath(login.LOCATORS.getProperty("applogo"))).size() != 0) {
				System.out.println("CEIC logo is shown");
			} else {
				Assert.fail("CEIC logo is not shown");
			}
		} else {
			Assert.fail("CEIC logo is not shown");
		}
	}
	// Tc_InsightGeneral_02
	@Given("^Create new insight$")
	public void create_new_insight() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("file")))
				.click();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("new_insight"))).click();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("create_insight"))).click();
		login.driver.manage().timeouts().implicitlyWait(1200, TimeUnit.SECONDS);
		Thread.sleep(9000);
	}
	@Then("^Click on CEIC logo to verify$")
	public void click_on_CEIC_logo_to_verify() throws Throwable {

		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("applogo"))).click();
		Thread.sleep(3000);
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("untitledInsight"))).size() != 0) {
			System.out.println("User will redirect to landing page");
		} else {
			Assert.fail("User failed to  redirect to landing page");
		}
	}

	// Tc_InsightGeneral_03
	@Given("^Verify insight title$")
	public void verify_insight_title() throws Throwable {
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("untitledInsight"))).size() != 0) {
			System.out.println("Insight title is available");
		} else {
			Assert.fail("Insight title is not available");
		}
	}

	// Tc_InsightGeneral_04
	@Given("^Click  insight title$")
	public void click_insight_title() throws Throwable {
		Thread.sleep(25000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("untitledInsight")))
				.click();
		Thread.sleep(2000);
		action.sendKeys("test").sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);

	}

	@Given("^Verify insight title change$")
	public void verify_insight_title_change() throws Throwable {
		String insightText = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("untitledInsight")))
				.getText();
		Assert.assertEquals("test", insightText);
	}

	// Tc_InsightGeneral_05
	@Given("^Change insight title and verify insight URL after changed insight title$")
	public void change_insight_title_and_verify_insight_URL_after_changed_insight_title()
			throws Throwable {

		String username = "SR" + new Random().nextInt(1000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("untitledInsight")))
				.click();
		Thread.sleep(7000);
		action.sendKeys(username).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(7000);
		String actualURL = login.driver.getCurrentUrl();
		String expectedURL1 = "https://stage.ceicdata.com/";
		String expectedURL2 = username;
		String expectedURL3 = "/myseries";
		String expectedURL = expectedURL1 + expectedURL2 + expectedURL3;
		System.out.println(expectedURL);
		Assert.assertEquals(actualURL, expectedURL);
	}

	// Tc_InsightGeneral_06
	@Given("^Verify insight URL after changed insight title with existing insight title$")
	public void verify_insight_URL_after_changed_insight_title_with_existing_insight_title()
			throws Throwable {

		Thread.sleep(10000);
		WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("untitledInsight")));

		String username = "SR" + new Random().nextInt(1000);
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("untitledInsight")))
				.click();
		Thread.sleep(2000);
		action.moveToElement(ele).sendKeys(username).sendKeys(Keys.ENTER)
				.build().perform();
		String actual = login.driver.getCurrentUrl();
		System.out.println(actual);
		// login.driver.navigate().refresh();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("file")))
				.click();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("new_insight"))).click();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_InsightTitle")))
				.sendKeys(username);

		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("create_insight"))).click();
		login.driver.manage().timeouts().implicitlyWait(1200, TimeUnit.SECONDS);
		Thread.sleep(9000);

		Thread.sleep(5000);
		String expectedURL = login.driver.getCurrentUrl();
		System.out.println(expectedURL);
		Assert.assertNotEquals(actual, expectedURL);
	}

	// Tc_InsightGeneral_07
	@Given("^Verify tooltip for insight title$")
	public void verify_tooltip_for_insight_title() throws Throwable {
		WebElement untitledInsight = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("untitledInsight")));
		Thread.sleep(4000);
		action.moveToElement(untitledInsight).build().perform();
		Thread.sleep(4000);
		String insightTitle = untitledInsight.getAttribute("title");
		System.out.println(insightTitle);
		Assert.assertEquals("Click to edit the Insight", insightTitle);

	}

	// Tc_InsightGeneral_08
	@Given("^Verify tooltip for favorite icon$")
	public void verify_tooltip_for_favorite_icon() throws Throwable {

		WebElement favicon = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("addtofavorite")));
		Thread.sleep(4000);
		action.moveToElement(favicon).build().perform();
		Thread.sleep(4000);
		String expectedfavIconText = favicon.getAttribute("title");
		String actualfavIconText = "Add to favorite";
		System.out.println(expectedfavIconText);
		System.out.println(actualfavIconText);
		Assert.assertEquals(actualfavIconText, expectedfavIconText);
	}

	// Tc_InsightGeneral_09
	@Given("^Click on tag icon$")
	public void click_on_tag_icon() throws Throwable {

		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("tagicon"))).click();

	}

	@Given("^Verify tag popup is displayed$")
	public void verify_tag_popup_is_displayed() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("add_tag_popup"))));
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("add_tag_popup"))).size() != 0) {
			System.out.println("Add tag pop up is shown");
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("TAG_POPUP_CLOSE")))
					.click();
		} else {
			Assert.fail("Add tag pop up is not shown");
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("TAG_POPUP_CLOSE")))
					.click();

		}

	}

	// Tc_InsightGeneral_10

	@Given("^Click on tag icon and enter the tags$")
	public void click_on_tag_icon_and_enter_the_tags() throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("tagicon"))).click();
		Thread.sleep(5000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("input_tag_text")))
				.sendKeys("Testing");
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("input_tag_text")))
				.sendKeys(Keys.ENTER);
	}

	@Given("^Verify tag in insight explorer$")
	public void verify_tag_in_insight_explorer() throws Throwable {

		String tagEnter = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("tagText"))).getText();
		String tagEnter1 = tagEnter.replaceAll("[^a-zA-Z0-9]", "");
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("tag_save"))).click();
		open_insight();
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("insights"))).click();
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MY_INSIGHTS"))).click();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("ALL_TAG_DROPDOWN")))
				.click();
		Thread.sleep(4000);
		String tagText = login.driver
				.findElement(
						By.xpath(login.LOCATORS
								.getProperty("ALL_TAG_DROPDOWN_CONTENT")))
				.getText();
		String tagText1 = tagText.replaceAll("[0-9]", "").replaceAll("\\W", "");
		System.out.println(tagText1);
		// String tagEnter =
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("input_tag_text"))).getText();
		System.out.println(tagEnter1);
		if (tagEnter1.equalsIgnoreCase(tagText1)) {
			System.out.println("Tag is shown in insight explorer");
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ALL_TAG_DROPDOWN"))).click();
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("ALL_TAG_DROPDOWN_CONTENT"))).click();
			WebElement insight = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("HOVER_INSIGHT")));
			action.moveToElement(insight).build().perform();
			Thread.sleep(2000);
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("TAG_ICON"))).click();
			Thread.sleep(4000);
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("RemoveTag"))).click();
			Thread.sleep(2000);
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("tag_save"))).click();
			Thread.sleep(2000);
			close_insight();
		} else {
			Assert.fail("Tag is not shown in insight explorer");
		}
	}

	// Tc_InsightGeneral_11
	@Given("^Verify Cancel option in tag popup$")
	public void verify_Cancel_option_in_tag_popup() throws Throwable {
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("add_tag_popup"))).size() != 0) {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("TAG_POPUP_CLOSE")))
					.click();
			System.out.println("Add tag popup is closed");
		} else {
			Assert.fail("Add tag popup is not  closed");
		}

	}

	// Tc_InsightGeneral_12
	@Given("^Click on Share icon$")
	public void click_on_Share_icon() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("SHARE_ICON"))).click();
	}

	@Given("^Verify share popup is shown$")
	public void verify_share_popup_is_shown() throws Throwable {
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("SHARE_POPUP"))).size() != 0) {

			System.out.println("Share pop up is shown");

			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Share_Popup_Close")))
					.click();
		} else {
			Assert.fail("Share pop up is not shown");
		}

	}

	// Tc_InsightGeneral_13
	@Given("^Click on Save as,Verify 'Save as' button for untitled insight\\.$")
	public void click_on_Save_as_Verify_Save_as_button_for_untitled_insight()
			throws Throwable {

		click_ceic_logo();
		String insight = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Untitled_insight")))
				.getText();
		System.out.println(insight);
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("SAVE_AS"))).click();
		Thread.sleep(4000);
		WebElement element = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("Untitled_insight")));
		action.moveToElement(element);
		action.click();
		action.sendKeys("TEST");
		Thread.sleep(3000);
		action.build().perform();

		// Thread.sleep(5000);
		action.moveToElement(element);
		action.click();
		action.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		action.build().perform();
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Untitled_insight"))).sendKeys(Keys.ENTER);
		String updatedInsight = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Untitled_insight")))
				.getText();
		System.out.println(updatedInsight);
		if (!insight.matches(updatedInsight)) {
			System.out.println("Untitled Insight has been updated");
		} else {
			Assert.fail("Failed to updated insight");
		}
	}

	// Tc_InsightGeneral_14
	@Given("^Click on Share icon for untitled insight$")
	public void click_on_Share_icon_for_untitled_insight() throws Throwable {
		click_ceic_logo();
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("SHARE_ICON"))).click();
		Thread.sleep(3000);
	}

	@Given("^Verify Share for untitled insight\\.$")
	public void verify_Share_for_untitled_insight() throws Throwable {
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Name_Insight"))).size() != 0) {

			System.out.println("Name insight  is shown");

			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Name_Insight_Close")))
					.click();
			Thread.sleep(5000);
		} else {
			Assert.fail("Name insight  is not shown");
		}
	}

	// Tc_InsightGeneral_15
	@Given("^Update the untitled insight name$")
	public void update_the_untitled_insight_name() throws Throwable {
		login.driver
				.findElement(
						By.xpath(login.LOCATORS
								.getProperty("Name_Insight_input_text")))
				.clear();
		login.driver
				.findElement(
						By.xpath(login.LOCATORS
								.getProperty("Name_Insight_input_text")))
				.sendKeys("Testing");
		Thread.sleep(4000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Name_Insight_Save")))
				.click();
		Thread.sleep(4000);
	}

	@Given("^Verify Share pop up is shown$")
	public void verify_Share_pop_up_is_shown() throws Throwable {
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("SHARE_POPUP"))).size() != 0) {

			System.out.println("Share pop up is shown");

			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Share_Popup_Close")))
					.click();
		} else {

			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Share_Popup_Close")))
					.click();
			Assert.fail("Share pop up is not shown");
		}

	}

	// Tc_InsightGeneral_16
	@Given("^Verify the the insight  saved with updated title\\.$")
	public void Verify_the_the_insight_saved_with_updated_title()
			throws Throwable {
		
		click_ceic_logo();
		Thread.sleep(10000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("SHARE_ICON"))).click();
		login.driver
				.findElement(
						By.xpath(login.LOCATORS
								.getProperty("Name_Insight_input_text")))
				.clear();
		login.driver
				.findElement(
						By.xpath(login.LOCATORS
								.getProperty("Name_Insight_input_text")))
				.sendKeys("hi");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("url")))
				.click();
		Thread.sleep(4000);
		WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("Name_Insight_input_text")));
		String nameInsightUpdated = ele.getAttribute("value");
		System.out.println(nameInsightUpdated);
		Thread.sleep(4000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Name_Insight_Save")))
				.click();
		Thread.sleep(4000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Share_Popup_Close")))
				.click();
		Thread.sleep(4000);
		String upInsight = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Untitled_insight")))
				.getText();
		System.out.println(upInsight);
		if (nameInsightUpdated.equalsIgnoreCase(upInsight)) {
			System.out.println("The Insight  saved with updated title");

		} else {
			Assert.fail("The Insight not saved with updated title");
		}
	}

	// Tc_InsightGeneral_17

	@Given("^Verify insight url updated after insight title changed$")
	public void verify_insight_url_updated_after_insight_title_changed()
			throws Throwable {
	
		login.driver
				.findElement(
						By.xpath(login.LOCATORS
								.getProperty("Name_Insight_input_text")))
				.clear();
		String insightId = "TC" + new Random().nextInt(1000);
		String str = "https://stage.ceicdata.com/";
		String changedurl = str.concat(insightId);
		System.out.println(changedurl);

		login.driver
				.findElement(
						By.xpath(login.LOCATORS
								.getProperty("Name_Insight_input_text")))
				.sendKeys(insightId);
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Name_Insight_Save")))
				.click();
		Thread.sleep(6000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Share_Popup_Close")))
				.click();
		Thread.sleep(4000);
		String currentUrl = login.driver.getCurrentUrl();
		String URL = currentUrl.replaceAll("/views", "");
		System.out.println(URL);
		if (URL.equalsIgnoreCase(changedurl)) {
			System.out
					.println("The insight URL  updated as changing the insight title.");

		} else {
			Assert.fail("The insight URL  not updated as changing the insight title.");
		}
	}

	// Tc_InsightGeneral_18
	@Given("^Click on Edit icon on insight URL field and Verify$")
	public void click_on_Edit_icon_on_insight_URL_field_and_Verify()
			throws Throwable {
		login.driver
				.findElement(
						By.xpath(login.LOCATORS
								.getProperty("Name_Insight_input_text")))
				.clear();

		String insightId = "SR" + new Random().nextInt(1000);
		String str = "https://stage.ceicdata.com/";
		String changedurl = str.concat(insightId);
		System.out.println(changedurl);
		Thread.sleep(3000);
		login.driver
				.findElement(
						By.xpath(login.LOCATORS
								.getProperty("Name_Insight_input_text")))
				.sendKeys(insightId);
		String insightId1 = "SS" + new Random().nextInt(1000);
		String str1 = "https://stage.ceicdata.com/";
		String changedurl1 = str1.concat(insightId).concat(insightId1);
		System.out.println(changedurl1);

		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("url")))
				.clear();
		Thread.sleep(6000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("url")))
				.sendKeys(insightId1);
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Name_Insight_Save")))
				.click();
		Thread.sleep(6000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Share_Popup_Close")))
				.click();
		Thread.sleep(4000);
		String currentUrl = login.driver.getCurrentUrl();
		String URL = currentUrl.replaceAll("/views", "");
		System.out.println(URL);
		if (URL.equalsIgnoreCase(changedurl1)) {
			System.out.println("The insight URL  updated as per the change.");

		} else {
			Assert.fail("The insight URL not updated as per the change.");
		}
	}

	// Tc_InsightGeneral_19
	@Given("^Verify the alert message while click on edit icon for insight URL change$")
	public void verify_the_alert_message_while_click_on_edit_icon_for_insight_URL_change()
			throws Throwable {
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("url"))).clear();
		// Thread.sleep(6000);
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("url"))).sendKeys("1");
		// Thread.sleep(3000);
		WebElement editHover = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("Edit_Hover")));
		action.moveToElement(editHover).build().perform();
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Edit_icon"))).click();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("url")))
				.sendKeys("1");

		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Alert_message"))).size() != 0) {
			System.out.println("The alert message is shown");

			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Name_Insight_Close")))
					.click();

		} else {
			Assert.fail("The alert message is not shown");
		}
	}

	// Tc_InsightGeneral_20
	@Given("^Verify 'Copy' permanent link' option\\.$")
	public void verify_Copy_permanent_link_option() throws Throwable {
		login.driver
				.findElement(
						By.xpath(login.LOCATORS
								.getProperty("Name_Insight_input_text")))
				.clear();
		login.driver
				.findElement(
						By.xpath(login.LOCATORS
								.getProperty("Name_Insight_input_text")))
				.sendKeys("Test");
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Insight_Copy_Link")))
				.click();
		Thread.sleep(4000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Name_Insight_Save")))
				.click();
		Thread.sleep(4000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Share_Popup_Close")))
				.click();

		String InsightCuurentTab = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Untitled_insight")))
				.getText();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		// Switch focus to new tab
		ArrayList<String> tabs = new ArrayList<String>(
				login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs.get(1));
		// Launch URL in the new tab
		// login.driver.get(copyURL);
		Thread.sleep(7000);
		String InsightNewTab = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Untitled_insight")))
				.getText();
		Thread.sleep(4000);
		if (InsightCuurentTab.equalsIgnoreCase(InsightNewTab)) {
			System.out.println("Insight loaded");
			login.driver.close();
			Thread.sleep(3000);
			login.driver.switchTo().window(tabs.get(0));
		} else {
			Assert.fail("Fail to load insight");
		}
	}

	// Tc_InsightGeneral_21

	@Given("^Verify the tooltip for Copy permanent link\\.$")
	public void verify_the_tooltip_for_Copy_permanent_link() throws Throwable {
		WebElement toolTip = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("copy_link_tooltip")));

		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Name_Insight"))).size() != 0) {
			action.moveToElement(toolTip).build().perform();
			String copyLinkToolTip = toolTip.getAttribute("title");
			System.out.println(copyLinkToolTip);
			Assert.assertEquals(
					"Permanent link is an insight URL that will never be changed.",
					copyLinkToolTip);
			Thread.sleep(4000);
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Name_Insight_Close")))
					.click();
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Name_Insight_Close")))
					.click();
			Assert.fail("Tooltip not shown");
		}
	}

	// Tc_InsightGeneral_22
	@Given("^Verify disabled save button\\.$")
	public void verify_disabled_save_button() throws Throwable {
		if (login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Name_Insight_Save")))
				.isEnabled()) {
			Assert.fail("Save button is enabled");
		} else {
			System.out.println("Save is disabled");
			Thread.sleep(3000);
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Name_Insight_Close")))
					.click();

		}
	}

	// Tc_InsightGeneral_23
	@Given("^Verify Cancel/Dismiss\\(X\\) options for 'Name Insight' popup$")
	public void verify_Cancel_Dismiss_X_options_for_Name_Insight_popup()
			throws Throwable {
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Name_Insight"))).size() != 0) {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Name_Insight_Close")))
					.click();
			System.out.println("The pop up is closed");
		} else {
			Assert.fail("Fail to close");
		}

	}

	// Tc_InsightGeneral_24
	@Given("^Click on File menu and Verify$")
	public void click_on_File_menu_and_Verify() throws Throwable {
		WebElement file = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("file")));
		file.click();
		Thread.sleep(4000);
		String[] file_list = { "View", "Add to favorite", "New", "Open",
				"Save", "Delete", "Save as", "Refresh", "Settings", "Protect",
				"Download", "Share" };
		List<WebElement> elements = login.driver.findElements(By
				.xpath(login.LOCATORS.getProperty("file_drpdwn")));
		for (int i = 0; i < file_list.length; i++) {
			String optionValue = elements.get(i).getText();
			if (optionValue.equals(file_list[i])) {
				System.out.println("passed on: " + optionValue);
			} else {
				Assert.fail("failed on: " + optionValue);
			}

		}
	}

	// Tc_InsightGeneral_25
	@Given("^Verify icons for file menu$")
	public void verify_icons_for_file_menu() throws Throwable {
		WebElement file = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("file")));
		file.click();
		Thread.sleep(8000);
		boolean View_Icon = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("View_Icon")))
				.isDisplayed();
		boolean Add_To_Favorite_Icon = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Add_To_Favorite_Icon")))
				.isDisplayed();
		boolean New_Icon = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("New_Icon"))).isDisplayed();
		boolean Open_Icon = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Open_Icon")))
				.isDisplayed();
		boolean Save_Icon = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Save_Icon")))
				.isDisplayed();
		boolean Delete_Icon = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Delete_Icon")))
				.isDisplayed();
		boolean Save_As_Icon = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Save_As_Icon")))
				.isDisplayed();
		boolean Refresh_Icon = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Refresh_Icon")))
				.isDisplayed();
		boolean Settings_Icon = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Settings_Icon")))
				.isDisplayed();
		boolean Protect_Icon = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Protect_Icon")))
				.isDisplayed();
		boolean Download_Icon = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Download_Icon")))
				.isDisplayed();
		boolean Share_Icon = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Share_Icon")))
				.isDisplayed();
		if (View_Icon == true && Add_To_Favorite_Icon == true
				&& New_Icon == true && Open_Icon == true && Save_Icon == true
				&& Delete_Icon == true && Save_As_Icon == true
				&& Refresh_Icon == true && Settings_Icon == true
				&& Protect_Icon == true && Download_Icon == true
				&& Share_Icon == true) {
			System.out.println("Icons are displayed for all options");
		} else {
			Assert.fail("Icons not displayed for  options");
		}
	}

	// Tc_InsightGeneral_26
	@Given("^Click on File menu$")
	public void click_on_File_menu() throws Throwable {
		WebElement file = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("file")));
		
		file.click();
		Thread.sleep(3000);
	}

	@Given("^Click on View option and Verify$")
	public void click_on_View_option_and_Verify() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("View_Btn"))).click();
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Preview"))).size() != 0) {
			System.out.println("Insight opened in Preview mode");
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close")))
					.click();
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close")))
					.click();
			Assert.fail("Insight not opened in Preview mode");
		}
	}

	// Tc_InsightGeneral_27
	@Given("^Click on Add to favorite option and Verify$")
	public void click_on_Add_to_favorite_option_and_Verify() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Add_To_Favorite_Icon")))
				.click();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("insights"))).click();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Favorites"))).click();
		Thread.sleep(2000);
		String Fav_Insight_Title = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Fav_Insight_Title")))
				.getAttribute("title");
		String Insight_Title = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Untitled_insight")))
				.getText();
		if (Insight_Title.equalsIgnoreCase(Fav_Insight_Title)) {
			System.out.println("The insight is shown in favorite list");
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE")))
					.click();
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE")))
					.click();
			Assert.fail("The insight is not shown in favorite list");
		}
		click_on_File_menu();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Remove_Fav"))).click();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("insights"))).click();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Favorites"))).click();
		Thread.sleep(2000);
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Fav_Insight_Empty")))
				.size() != 0) {
			System.out.println("The insight is removed from favorite list");
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE")))
					.click();
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE")))
					.click();
			Assert.fail("The insight is still shown in favorite list");
		}
	}

	// Tc_InsightGeneral_28
	@Given("^Click on View option$")
	public void click_on_View_option() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("View_Btn"))).click();
	}

	@Given("^Verify 'Open' option in insight preview$")
	public void verify_Open_option_in_insight_preview() throws Throwable {
		String InsightCurrentTab = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Untitled_insight")))
				.getText();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("open_icon"))).click();
		Thread.sleep(4000);
		ArrayList<String> tabs = new ArrayList<String>(
				login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs.get(1));
		Thread.sleep(8000);
		String InsightNewTab = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Untitled_insight")))
				.getText();
		if (InsightCurrentTab.equalsIgnoreCase(InsightNewTab)) {
			System.out.println("The insight  opened with new browser tab.");
			Thread.sleep(2000);
			login.driver.close();
			login.driver.switchTo().window(tabs.get(0));
		} else {
			login.driver.close();
			login.driver.switchTo().window(tabs.get(0));
			Assert.fail("The insight  fail to open in new browser tab.");
		}

	}

	// Tc_InsightGeneral_29
	@Given("^Click on Copy button$")
	public void click_on_Copy_button() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Copy_Insight"))).click();
		Thread.sleep(3000);
	}

	@Given("^Verify 'Copy' option in insight preview\\.$")
	public void verify_Copy_option_in_insight_preview() throws Throwable {
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Copy_Insight_Pop_Up")))
				.size() != 0) {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("fav_insight_close")))
					.click();
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close")))
					.click();
			System.out.println("Copy insight pop up is displayed");
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("fav_insight_close")))
					.click();
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close")))
					.click();
			Assert.fail("Copy insight pop up is not displayed");
		}
	}

	// Tc_InsightGeneral_30
	@Given("^Create insight$")
	public void create_insight() throws Throwable {
		click_on_Help();
		click_on_File_menu();
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("new_insight"))).click();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Insight_Text_Enter")))
				.clear();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Insight_Text_Enter")))
				.sendKeys("TEST");
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("create_insight"))).click();
		Thread.sleep(3000);

	}

	@Given("^Verify default insight title while coping insight\\.$")
	public void verify_default_insight_title_while_coping_insight()
			throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Copy_Insight_Button")))
				.click();
		Thread.sleep(6000);
		String strValidate = "TEST_copy";
		String copied_insight = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Untitled_insight")))
				.getText();
		if (copied_insight.contains(strValidate)) {
			System.out.println(copied_insight);
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close")))
					.click();
			

		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close")))
					.click();
			Assert.fail("Insight not copied");
		}

	}

	// Tc_InsightGeneral_31
	@Given("^Verify 'Cancel' button for 'Copy the insight' popup\\.$")
	public void verify_Cancel_button_for_Copy_the_insight_popup()
			throws Throwable {
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Copy_Insight_Pop_Up")))
				.size() != 0) {
			if (login.driver.findElements(
					By.xpath(login.LOCATORS.getProperty("Ig_Copy_Cancel")))
					.size() != 0) {
				login.driver.findElement(
						By.xpath(login.LOCATORS.getProperty("Ig_Copy_Cancel")))
						.click();
				login.driver
						.findElement(
								By.xpath(login.LOCATORS
										.getProperty("Ig_Preview_Close")))
						.click();
				System.out.println("The copy pop up will be closed");
			} else {
				login.driver.findElement(
						By.xpath(login.LOCATORS.getProperty("Ig_Copy_Cancel")))
						.click();
				login.driver
						.findElement(
								By.xpath(login.LOCATORS
										.getProperty("Ig_Preview_Close")))
						.click();
				Assert.fail("The copy pop up will not be closed");
			}
		}
	}

	// Tc_InsightGeneral_32
	@Given("^Verify 'Download' option in insight preview without visual$")
	public void verify_Download_option_in_insight_preview_without_visual()
			throws Throwable {

		if (login.driver
				.findElements(
						By.xpath(login.LOCATORS
								.getProperty("Download_option_Disabled")))
				.size() != 0) {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close")))
					.click();
			System.out.println("Download option is disabled");
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close")))
					.click();
			Assert.fail("Download option is not disabled");
		}
	}

	// Tc_InsightGeneral_33
	@Given("^Create Visual$")
	public void create_Visual() throws Throwable {
		Footnotes f = new Footnotes();
		f.goto_Db_Search_tab();
		f.expand_the_database();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_seriestoadd"))).click();
		Thread.sleep(2000);
		action.sendKeys("c").perform();
	}

	@Given("^Click on View$")
	public void click_on_View() throws Throwable {
		click_on_File_menu();
		click_on_View_option();
		Thread.sleep(2000);
	}

	@Given("^Click on Download$")
	public void click_on_Download() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Download"))).click();

	}

	@Given("^Verify 'Download' option in insight preview with visual$")
	public void verify_Download_option_in_insight_preview_with_visual()
			throws Throwable {
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_Downloadpopup")))
				.size() != 0) {
			System.out.println("Download pop up is shown");
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
			Thread.sleep(2000);
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close")))
					.click();
			Thread.sleep(2000);
			WebElement visual = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("Ig_Visual")));
			Thread.sleep(2000);
			action.moveToElement(visual).build().perform();
			Thread.sleep(2000);
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_Delete_Visual")))
					.click();
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_visual_confirm")))
					.click();
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
			Thread.sleep(2000);
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close")))
					.click();
			Thread.sleep(2000);
			Assert.fail("Download pop up is not shown");
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_Delete_Visual")))
					.click();
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_visual_confirm")))
					.click();
		}
	}

	// Tc_InsightGeneral_34
	@Given("^Click on Maximize button$")
	public void click_on_Maximize_button() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_visual_maximize")))
				.click();
		Thread.sleep(3000);
	}

	@Given("^Verify 'Maximize' option in insight preview$")
	public void verify_Maximize_option_in_insight_preview() throws Throwable {
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_visual_minimize")))
				.size() != 0) {
			System.out.println("The insight is maximized");
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close")))
					.click();
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close")))
					.click();
			Assert.fail("The insight is maximized");
		}
	}

	// Tc_InsightGeneral_35
	@Given("^Verify 'Restore down' option in insight preview\\.$")
	public void verify_Restore_down_option_in_insight_preview()
			throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_visual_minimize")))
				.click();
		Thread.sleep(3000);
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_visual_maximize")))
				.size() != 0) {
			System.out.println("The insight restored to previous size");
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close")))
					.click();
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close")))
					.click();
			Assert.fail("The insight not restored to previous size");
		}
	}

	// Tc_InsightGeneral_36
	@Given("^Verify Cancel option for insight preview popup\\.$")
	public void verify_Cancel_option_for_insight_preview_popup()
			throws Throwable {
		// Tc_InsightGeneral_41
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Preview"))).size() != 0) {
			if (login.driver.findElements(
					By.xpath(login.LOCATORS.getProperty("Preview"))).size() != 0) {

				login.driver
						.findElement(
								By.xpath(login.LOCATORS
										.getProperty("Ig_Preview_Close")))
						.click();
				System.out.println("The preview is closed");
			} else {
				login.driver
						.findElement(
								By.xpath(login.LOCATORS
										.getProperty("Ig_Preview_Close")))
						.click();
				Assert.fail("The preview is not closed");
			}
		}

	}

	// Tc_InsightGeneral_37
	@Given("^Click on Related Insights$")
	public void click_on_Related_Insights() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Relatedinsights")))
				.click();
	}

	@Given("^Verify Related Insights in insight preview\\.$")
	public void verify_Related_Insights_in_insight_preview() throws Throwable {
		if (login.driver
				.findElements(
						By.xpath(login.LOCATORS
								.getProperty("Ig_Related_Insight_pane")))
				.size() != 0) {

			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close")))
					.click();
			System.out.println("Related insights is shown");
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close")))
					.click();
			Assert.fail("Related insights is not shown");
		}
	}

	// Tc_InsightGeneral_38
	@Given("^Click on New$")
	public void click_on_New() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("new_insight"))).click();
		Thread.sleep(2000);
	}

	@Given("^Verify New option\\.$")
	public void verify_New_option() throws Throwable {
		if (login.driver
				.findElements(
						By.xpath(login.LOCATORS
								.getProperty("Ig_Create_Insight_popup")))
				.size() != 0) {

			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
			System.out.println("'Create insight' popup is displayed");
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
			Assert.fail("'Create insight' popup is not displayed");
		}
	}

	// Tc_InsightGeneral_39
	@Given("^Verify auto title for Create insight\\.$")
	public void verify_auto_title_for_Create_insight() throws Throwable {
		String insightTitle = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_InsightTitle")))
				.getAttribute("value");
		System.out.println(insightTitle);
		if (insightTitle.contains("Insight")) {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
			System.out.println("Autotitle is shown");
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
			Assert.fail("Autotitle is not  shown");
		}
	}

	// Tc_InsightGeneral_40
	@Given("^Verify 'Create insight' button\\.$")
	public void verify_Create_insight_button() throws Throwable {
		String newInsight = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_InsightTitle")))
				.getAttribute("value");
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("create_insight"))).click();
		Thread.sleep(2000);
		login.driver.manage().timeouts().implicitlyWait(1200, TimeUnit.SECONDS);
		String insightTitle = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Insight_Title")))
				.getText();
		Assert.assertEquals(newInsight, insightTitle);
	}

	// Tc_InsightGeneral_41
	@Given("^Verify 'Cancel' button for new insight popup\\.$")
	public void verify_Cancel_button_for_new_insight_popup() throws Throwable {
		if (login.driver
				.findElements(
						By.xpath(login.LOCATORS
								.getProperty("Ig_Create_Insight_popup")))
				.size() != 0) {

			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
			System.out.println("'Create insight' popup is closed");
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
			Assert.fail("'Create insight' popup is not closed");
		}
	}

	// Tc_InsightGeneral_42
	@Given("^Click on Open$")
	public void click_on_Open() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Open_Icon"))).click();
		Thread.sleep(3000);
	}

	@Given("^Verify 'Open' option\\.$")
	public void verify_Open_option() throws Throwable {
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_Insightexplorer_Win")))
				.size() != 0) {

			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
			System.out.println("Insight explorer window is open");
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
			Assert.fail("Insight explorer window is not open");
		}
	}

	// Tc_InsightGeneral_43
	@Given("^Click on My insights tab and close$")
	public void click_on_My_insights_tab_and_close() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Myinsights"))).click();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
		Thread.sleep(2000);
	}

	@Given("^Verify default tab for open\\.$")
	public void verify_default_tab_for_open() throws Throwable {
		if (login.driver
				.findElements(
						By.xpath(login.LOCATORS
								.getProperty("Ig_my_insights_selected")))
				.size() != 0) {

			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
			System.out.println("The last visited tab is open");
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
			Assert.fail("The last visited tab is not open");
		}
	}

	// Tc_InsightGeneral_44
	@Given("^Verify Dismiss button for insight explorer modal popup\\.$")
	public void verify_Dismiss_button_for_insight_explorer_modal_popup()
			throws Throwable {
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_Insightexplorer_Win")))
				.size() != 0) {

			if (login.driver.findElements(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).size() != 0) {

				login.driver.findElement(
						By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE")))
						.click();

				System.out.println("The insight explorer window is closed");
			} else {
				login.driver.findElement(
						By.xpath(login.LOCATORS.getProperty("")))
						.click();

				Assert.fail("The insight explorer window is not closed");
			}
		}
	}

	// Tc_InsightGeneral_45
	@Given("^Click on Save$")
	public void click_on_Save() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Save_Changes")))
				.click();

	}

	@Given("^Verify 'Save' option\\.$")
	public void verify_Save_option() throws Throwable {

		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_Save_Message_text")))
				.size() != 0) {

			System.out.println("'Changes saved' growl message is displayed.");
		} else {
			Assert.fail("'Changes saved' growl message is not displayed.");
		}
	}

	// Tc_InsightGeneral_46
	@Given("^Click on Delete$")
	public void click_on_Delete() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Delete_Btn"))).click();
		Thread.sleep(2000);
	}

	@Given("^Verify Delete option\\.$")
	public void verify_Delete_option() throws Throwable {
		if (login.driver
				.findElements(
						By.xpath(login.LOCATORS
								.getProperty("Ig_Delete_insight_popup")))
				.size() != 0) {

			System.out
					.println("The Delete insight confirmation popup is shown");
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
		} else {

			Assert.fail("The Delete insight confirmation popup is not shown");
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
		}
	}

	// Tc_InsightGeneral_47
	@Given("^Verify Popup header for delete\\.$")
	public void verify_Popup_header_for_delete() throws Throwable {
		String deletePopup = login.driver
				.findElement(
						By.xpath(login.LOCATORS
								.getProperty("Ig_Delete_insight_popup")))
				.getText();
		String delete = "Delete insight?";
		if (deletePopup.equalsIgnoreCase(delete)) {

			System.out.println("The popup header 'Delete Insight?' is shown");
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
		} else {

			Assert.fail("The popup header 'Delete Insight?' is not  shown");
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
		}
	}

	// Tc_InsightGeneral_48
	@Given("^Verify description for delete confirmation popup\\.$")
	public void verify_description_for_delete_confirmation_popup()
			throws Throwable {
		String deleteMess = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Delete_conf_mess")))
				.getAttribute("innerHTML");
		String deletemessExpected = "Are you sure you want to delete this insight?If this file is shared, collaborators won't access it anymore.    Warning: you cannot undo this action.But if you are the owner of the deleted insight, to recover it within the past 6 months, please contact our help desk team.";
		String delMessage = deleteMess.replaceAll("//D", "")
				.replaceAll("\n", "").replaceAll("\\<.*?>", "");
		if (delMessage.equalsIgnoreCase(deletemessExpected)) {

			System.out.println("The Description message is shown");
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
		} else {

			Assert.fail("The Description message is not shown");
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
		}
	}

	// Tc_InsightGeneral_49
	@Given("^Verify Delete forever button\\.$")
	public void verify_Delete_forever_button() throws Throwable {
		create_insight();
		String newinsight = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Untitled_insight")))
				.getText();
		WebElement file = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("file")));
		file.click();
		Thread.sleep(4000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Delete_Btn"))).click();
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Delete_ok"))).click();
		Thread.sleep(6000);
		String untitledinsight = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Untitled_insight")))
				.getText();
		if (untitledinsight.contains("Untitled insight")) {
			System.out.println("The insight is deleted.");
		} else {
			Assert.fail("The insight is not deleted.");
		}
	}

	// Tc_InsightGeneral_50
	@Given("^Click on 'Save as'$")
	public void click_on_Save_as() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_save_as_btn"))).click();
		Thread.sleep(3000);
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Copy_Insight_Pop_Up")))
				.size() != 0) {

			System.out.println("'Copy the insight' popup is displayed");
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
		} else {

			Assert.fail("'Copy the insight' popup is not displayed");
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
		}

	}

	// Tc_InsightGeneral_51
	@Given("^Click on 'Save as' and Verify default insight title while coping insight$")
	public void click_on_Save_as_and_Verify_default_insight_title_while_coping_insight()
			throws Throwable {
		create_insight();
		click_on_File_menu();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_save_as_btn"))).click();
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Copy_Insight_Button")))
				.click();
		Thread.sleep(6000);
		String strValidate = "TEST_copy";
		String copied_insight = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Untitled_insight")))
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
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_save_as_btn"))).click();
		Thread.sleep(3000);
	}

	@Given("^Verify 'Cancel/X' button for 'Copy the insight' popup\\.$")
	public void verify_Cancel_X_button_for_Copy_the_insight_popup()
			throws Throwable {
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Copy_Insight_Pop_Up")))
				.size() != 0) {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
			System.out.println("The pop up is closed");
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
			Assert.fail("Fail to close");
		}
	}

	// Tc_InsightGeneral_53
	@Given("^Click on Add views$")
	public void click_on_Add_views() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("search_presentation")))
				.click();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_addview_btn"))).click();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_addview_btn"))).click();
		Thread.sleep(2000);
	}

	@Given("^Click on Refresh$")
	public void click_on_Refresh() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Refresh_btn"))).click();
		Thread.sleep(5000);
	}

	@Given("^Verify Refresh option\\.$")
	public void verify_Refresh_option() throws Throwable {
		 String Title = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_viewtab_active"))).getAttribute("title");
		if (Title.equalsIgnoreCase("View 1")) {
			
			System.out.println("The panel is refreshed ");
			WebElement visual = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("Ig_Visual")));
			Thread.sleep(3000);
			action.contextClick(visual).build().perform();
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_DeleteAllviews")))
					.click();
			Thread.sleep(2000);
		} else {
			WebElement visual = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("Ig_Visual")));
			action.contextClick(visual).build().perform();
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_DeleteAllviews")))
					.click();
			Assert.fail("The panel is not refreshed ");
		}
	}

	// Tc_InsightGeneral_54

	@Given("^Click on Settings$")
	public void click_on_Settings() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Settings"))).click();
		Thread.sleep(5000);
	}

	@Given("^Verify Settings option\\.$")
	public void verify_Settings_option() throws Throwable {
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_settings_popup")))
				.size() != 0) {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
			System.out.println("The settings pop up is shown");
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
			Assert.fail("The settings pop up is shown");
		}
	}

	// Tc_InsightGeneral_55
	@Given("^Verify the available tabs in the settings popup\\.$")
	public void verify_the_available_tabs_in_the_settings_popup()
			throws Throwable {
		// String text =
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_setting_tabs"))).getText();
		String text1 = "General";
		String text2 = "Information";
		String text3 = "Permissions";
		String text4 = "Subscription";
		String text5 = "Keywords";
		String[] expected = { "General", "Information", "Permissions",
				"Subscription", "Keywords" };

		List<WebElement> allOptions = login.driver.findElements(By
				.xpath(login.LOCATORS.getProperty("Ig_setting_tabs")));
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
				if (optionValue.contains(text4)) {
					System.out.println("Subscription tab is  shown");
				} else {
					Assert.fail("Subscription tab is not shown");
				}
				if (optionValue.contains(text5)) {
					System.out.println("Keywords tab is  shown");
				} else {
					Assert.fail("Keywords tab is not shown");
				}
				close_insight();
			} catch (Exception indexoutofBoundException) {

			}
		}
	}

	// Tc_InsightGeneral_56
	@Given("^Click on Settings and Verify the available tabs in the settings popup$")
	public void click_on_Settings_and_Verify_the_available_tabs_in_the_settings_popup()
			throws Throwable {
		create_insight();
		String Text = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Untitled_insight")))
				.getText();
		System.out.println(Text);
		click_on_File_menu();
		click_on_Settings();
		String settingsText = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_settings_iptext")))
				.getAttribute("value");
		System.out.println(settingsText);
		Thread.sleep(3000);
		if (Text.equalsIgnoreCase(settingsText)) {
			System.out.println("Current insight name is displayed");
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
			Assert.fail("Current insight name is not displayed");
		}
	}

	// Tc_InsightGeneral_57
	@Given("^Update the name under Settings and Verify$")
	public void update_the_name_under_Settings_and_Verify() throws Throwable {
		create_insight();

		click_on_File_menu();
		click_on_Settings();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_settings_iptext")))
				.sendKeys("TESTING");
		String settingsText = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_settings_iptext")))
				.getAttribute("value");
		System.out.println(settingsText);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("tag_save"))).click();
		Thread.sleep(3000);
		String Text = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Untitled_insight")))
				.getText();
		if (Text.equalsIgnoreCase(settingsText)) {
			System.out.println("Current insight name is displayed");

		} else {

			Assert.fail("Current insight name is not displayed");
		}
	}

	// Tc_InsightGeneral_58
	@Given("^Verify insight URL after insight title change\\.$")
	public void verify_insight_URL_after_insight_title_change()
			throws Throwable {
		String insightId = "TC" + new Random().nextInt(1000);
		WebElement element = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("Ig_settingurl")));
		action.moveToElement(element).build().perform();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_urlediticon"))).click();

		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_URL_edit"))).sendKeys(
				insightId);
		Thread.sleep(2000);
		String inURL = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_settingurl")))
				.getText();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("tag_save"))).click();
		String url = login.driver.getCurrentUrl();
		if (url.contains(inURL)) {
			System.out.println("The insight URL is updated");
		} else {
			Assert.fail("The insight URL is not updated");
		}
	}

	// Tc_InsightGeneral_59
	@Given("^Verify the alert message while changing insight URL\\.$")
	public void verify_the_alert_message_while_changing_insight_URL()
			throws Throwable {
		String insightId = "RG" + new Random().nextInt(1000);
		WebElement element = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("Ig_settingurl")));
		action.moveToElement(element).build().perform();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_urlediticon"))).click();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_URL_edit"))).sendKeys(
				insightId);
		Thread.sleep(3000);
		String textSetting = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Urledit_mess")))
				.getText();
		String text = "Changing the url of the insight will break out the old url.";
		if (textSetting.matches(text)) {
			System.out.println("The alert message displayed");
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
			Assert.fail("The alert message displayed");
		}
	}

	// Tc_InsightGeneral_60
	@Given("^Verify Change insight URL with existing insight name$")
	public void verify_Change_insight_URL_with_existing_insight_name()
			throws Throwable {
		String insightId = "S" + new Random().nextInt(1000);
		WebElement element = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("Ig_settingurl")));
		action.moveToElement(element).build().perform();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_urlediticon"))).click();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_URL_edit"))).sendKeys(
				insightId);
		// String gettext =
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Urledit_mess"))).getText();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("tag_save"))).click();
		click_on_File_menu();
		click_on_Settings();
		WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("Ig_settingurl")));
		action.moveToElement(ele).build().perform();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_urlediticon"))).click();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_URL_edit"))).sendKeys(
				"S");
		Thread.sleep(3000);
		String textSetting = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_urlmess_invalid")))
				.getText();
		String text = "Insight with this url already exists.";
		if (textSetting.matches(text)) {
			System.out
					.println("Insight with this url already exists.message is displayed");
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
			Assert.fail("Fail to display message");
		}
	}

	// TC_InsightGeneral_61
	@Given("^Validate the copied link\\.$")
	public void validate_the_copied_link() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Insight_Copy_Link")))
				.click();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
		String InsightCuurentTab = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Untitled_insight")))
				.getText();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		// Switch focus to new tab
		ArrayList<String> tabs = new ArrayList<String>(
				login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs.get(1));

		// Launch URL in the new tab
		// login.driver.get(copyURL);
		Thread.sleep(8000);
		String InsightNewTab = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Untitled_insight")))
				.getText();
		Thread.sleep(7000);
		if (InsightCuurentTab.equalsIgnoreCase(InsightNewTab)) {
			System.out.println("Insight loaded");
			login.driver.close();
			Thread.sleep(3000);
			login.driver.switchTo().window(tabs.get(0));
		} else {
			Assert.fail("Fail to load insight");
		}
	}

	// TC_InsightGeneral_62
	@Given("^Verify Category field\\.$")
	public void verify_Category_field() throws Throwable {
		try {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_Cat_drpdn")))
					.click();
			Thread.sleep(4000);
			String[] file_list = { "None", "Hot Topics", "World Economy",
					"Emerging Markets", "Thematic Analysis", "Markets",
					"New Datasets" };
			List<WebElement> elements = login.driver.findElements(By
					.xpath(login.LOCATORS.getProperty("Ig_Category_List")));
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
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_Cattopic")))
					.click();
			close_insight();
		}

	}

	// TC_InsightGeneral_63
	@Given("^Verify applied category for the insight\\.$")
	public void verify_applied_category_for_the_insight() throws Throwable {

		create_insight();
		String Text = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Untitled_insight")))
				.getText();
		click_on_File_menu();
		click_on_Settings();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Cat_drpdn"))).click();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Cattopic"))).click();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("tag_save"))).click();
		open_insight();

		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Allcat"))).click();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Cattopic"))).click();
		Thread.sleep(3000);
		String inname = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Fav_Insight_Title")))
				.getText();
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
	public void verify_added_description_under_insight_explorer()
			throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_add_desc"))).sendKeys(
				"TestData");
		String description = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_add_desc")))
				.getAttribute("value");
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("tag_save"))).click();
		open_insight();
		WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("Fav_Insight_Title")));
		action.moveToElement(ele).build().perform();
		Thread.sleep(2000);
		String insightText = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_insight_desc_txt")))
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
		List<WebElement> apply_disable = login.driver.findElements(By
				.xpath(login.LOCATORS.getProperty("Ig_apply_disable")));
		List<WebElement> save_disable = login.driver.findElements(By
				.xpath(login.LOCATORS.getProperty("Ig_save_disable")));
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
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_add_desc"))).sendKeys(
				"TestData");
		List<WebElement> apply_enable = login.driver.findElements(By
				.xpath(login.LOCATORS.getProperty("Ig_apply_enable")));
		List<WebElement> save_enable = login.driver.findElements(By
				.xpath(login.LOCATORS.getProperty("Ig_save_enable")));
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
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_add_desc"))).sendKeys(
				"TestData");

		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_Settings"))).size() != 0) {
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
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_add_desc"))).sendKeys(
				"TestData");
	}

	@Given("^Verify confirmation message after click on Apply\\.$")
	public void verify_confirmation_message_after_click_on_Apply()
			throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_apply_enable")))
				.click();
		Thread.sleep(2000);
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_Apply_mess"))).size() != 0) {
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
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Info_tab"))).click();
		Thread.sleep(3000);
	}

	@Given("^Verify Apply and Save buttons when redirect to next tabs with changes\\.$")
	public void verify_Apply_and_Save_buttons_when_redirect_to_next_tabs_with_changes()
			throws Throwable {
		verify_Save_and_Apply_buttons_disabled();
	}

	// TC_InsightGeneral_69
	@Given("^Verify Cancel/X buttons\\.$")
	public void verify_Cancel_X_buttons() throws Throwable {
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_settings_popup")))
				.size() != 0) {
			if (login.driver.findElements(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE")))
					.size() != 0) {
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
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("dropdown_btn"))).click();
		Thread.sleep(2000);
		String userdetail = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_User_Account")))
				.getText();
		create_new_insight();
		click_on_File_menu();
		click_on_Settings();
		click_on_Info_Tab();
		String infotabdetail = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Info_Detail")))
				.getText();
		System.out.println(infotabdetail);
		System.out.println(userdetail);
		if (infotabdetail.contains(userdetail)) {
			System.out.println("USername is displayed");
			close_insight();
		} else {
			close_insight();
			Assert.fail("USername is not displayed");
		}
	}

	// TC_InsightGeneral_71
	@Given("^Verify Last editor field\\.$")
	public void verify_Last_editor_field() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("dropdown_btn"))).click();
		Thread.sleep(2000);
		String userdetail = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_User_Account")))
				.getText();
		create_new_insight();
		click_on_File_menu();
		click_on_Settings();
		click_on_Info_Tab();
		String infotabdetail = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Lasteditor_Detail")))
				.getText();
		if (infotabdetail.contains(userdetail)) {
			System.out.println("USername is displayed");
			close_insight();
		} else {
			close_insight();
			Assert.fail("USername is not displayed");
		}
	}

	// TC_InsightGeneral_72

	@Given("^Check sharing settings field\\.$")
	public void check_sharing_settings_field() throws Throwable {
		click_on_Info_Tab();
		String SharedDetail = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_shared_setting")))
				.getText();
		String shared = "not shared";
		if (SharedDetail.equalsIgnoreCase(shared)) {
			System.out.println("The insight is not shared");
		} else {
			Assert.fail("The insight is not shared");
		}
	}

	@Given("^Share insight and Check the sharing settings field$")
	public void share_insight_and_Check_the_sharing_settings_field()
			throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_shared_change")))
				.click();
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_invite_people")))
				.click();
		Thread.sleep(3000);
		WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("Ig_choose_people")));
		Thread.sleep(2000);
		action.moveToElement(ele).build().perform();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_choose_people")))
				.click();
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("tag_save"))).click();
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_save_enable"))).click();
		Thread.sleep(3000);
		String SharedDetail = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_shared_setting")))
				.getText();
		String shared = "shared";
		if (SharedDetail.equalsIgnoreCase(shared)) {
			System.out.println("The insight is  shared");
			close_insight();
		} else {
			close_insight();
			Assert.fail("The insight is not shared");
		}
	}

	// TC_InsightGeneral_73
	@Given("^Verify 'Change' option for sharing settings\\.$")
	public void verify_Change_option_for_sharing_settings() throws Throwable {

		click_on_Info_Tab();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_shared_change")))
				.click();
		Thread.sleep(3000);
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("SHARE_POPUP"))).size() != 0) {
			System.out.println("The share popup  is displayed");
			login.driver
					.findElement(
							By.xpath(login.LOCATORS
									.getProperty("Ig_sharepopup_cancel")))
					.click();
			close_insight();
		} else {
			close_insight();
			Assert.fail("The share popup  is not displayed");
		}

	}

	// TC_InsightGeneral_74
	@Given("^Add Views$")
	public void add_Views() throws Throwable {
		create_new_insight();
		Thread.sleep(4000);
		expander();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_addview_btn"))).click();
		delete_all_views();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_addview_btn"))).click();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_addview_btn"))).click();
	}

	@Given("^Verify number of the view/s for the insight\\.$")
	public void verify_number_of_the_view_s_for_the_insight() throws Throwable {

		int viewcount = login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_View_count"))).size();
		System.out.println(viewcount);
		click_on_File_menu();
		click_on_Settings();
		click_on_Info_Tab();
		String view = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Setting_no_views")))
				.getText();
		int viewcnt = Integer.parseInt(view);
		System.out.println(viewcnt);
		if (viewcount == viewcnt) {
			System.out.println("The view count matched");
			close_insight();
			delete_all_views();
		} else {
			close_insight();
			Assert.fail("Fail");
		}
	}

	// TC_InsightGeneral_75
	@Given("^Add series to myseries$")
	public void add_series_to_myseries() throws Throwable {
		create_insight();
		expander();
		add_Series();
	}

	@Given("^Verify Data series under info tab in settings$")
	public void verify_Data_series_under_info_tab_in_settings()
			throws Throwable {
		int datacount = login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_myseries_size")))
				.size();
		System.out.println(datacount);
		click_on_File_menu();
		click_on_Settings();
		click_on_Info_Tab();
		String data = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_data_count")))
				.getText();
		int datacnt = Integer.parseInt(data);
		System.out.println(datacnt);
		if (datacount == datacnt) {
			System.out.println("The number of data series matched");
			close_insight();
			delete_series();
		} else {
			close_insight();
			delete_series();
			Assert.fail("Fail");
		}
	}

	// TC_InsightGeneral_76
	@Given("^Click on Permissions tab$")
	public void click_on_Permissions_tab() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_permission_tab")))
				.click();
	}

	@Given("^Verify Permission tabs description\\.$")
	public void verify_Permission_tabs_description() throws Throwable {
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_Permission_title")))
				.size() != 0) {
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
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_permission_option")))
				.size() != 0) {
			System.out.println("PASS");

			close_insight();
		} else {
			close_insight();
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_78
	@Given("^Click on Subscription tab$")
	public void click_on_Subscription_tab() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_subscription_tab")))
				.click();
	}

	@Given("^Verify Select service code field\\.$")
	public void verify_Select_service_code_field() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS
						.getProperty("Ig_select_servicecode_drpdwn"))).click();
		Thread.sleep(2000);
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_servicedrpdwn")))
				.size() != 0) {
			System.out.println("PASS");
			close_insight();
		} else {
			close_insight();
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_79
	@Given("^Verify search for service code\\.$")
	public void verify_search_for_service_code() throws Throwable {
		String servicecode = "CEIC Premium China";
		login.driver.findElement(
				By.xpath(login.LOCATORS
						.getProperty("Ig_select_servicecode_drpdwn")))
				.sendKeys(servicecode);
		Thread.sleep(3000);
		String code = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_service_code")))
				.getText();
		if (code.equalsIgnoreCase(code)) {
			System.out.println("PASS");
			close_insight();
		} else {
			close_insight();
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_80
	@Given("^Verify message for invalid search\\.$")
	public void verify_message_for_invalid_search() throws Throwable {
		String servicecode = "12";
		String message = "Empty results";
		login.driver.findElement(
				By.xpath(login.LOCATORS
						.getProperty("Ig_select_servicecode_drpdwn")))
				.sendKeys(servicecode);
		Thread.sleep(3000);
		String code = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_empty_result")))
				.getText();
		if (message.equalsIgnoreCase(code)) {
			System.out.println("PASS");
			close_insight();
		} else {
			close_insight();
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_81
	@Given("^Verify Subscription tabs description\\.$")
	public void verify_Subscription_tabs_description() throws Throwable {
		String message = "Only users with all specified subscriptions are allowed to view this insight";
		String code = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_subs_mess"))).getText();
		if (message.equalsIgnoreCase(code)) {
			System.out.println("PASS");
			close_insight();
		} else {
			close_insight();
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_82
	@Given("^Verify remove icon for service code field\\.$")
	public void verify_remove_icon_for_service_code_field() throws Throwable {
		String servicecode = "CEIC Premium China";
		login.driver.findElement(
				By.xpath(login.LOCATORS
						.getProperty("Ig_select_servicecode_drpdwn")))
				.sendKeys(servicecode);
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS
						.getProperty("Ig_select_servicecode_drpdwn"))).clear();
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_servicedrpdwn")))
				.size() != 0) {
			System.out.println("PASS");

			close_insight();
		} else {
			close_insight();
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_83
	@Given("^Verify service code selection\\.$")
	public void verify_service_code_selection() throws Throwable {
		String servicecode = "CEIC";
		login.driver.findElement(
				By.xpath(login.LOCATORS
						.getProperty("Ig_select_servicecode_drpdwn")))
				.sendKeys(servicecode);
		Thread.sleep(3000);
		WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("Ig_select_servicecode")));
		action.moveToElement(ele).build().perform();
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_select_servicecode")))
				.click();
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("tag_save"))).click();
		Thread.sleep(3000);
		click_on_File_menu();
		click_on_Settings();
		click_on_Subscription_tab();

		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_servicecode_display")))
				.size() != 0) {
			System.out.println("PASS");

			close_insight();
		} else {
			close_insight();
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_84
	@Given("^Verify remove icon for selected service code\\.$")
	public void verify_remove_icon_for_selected_service_code() throws Throwable {
		String servicecode = "CEIC";
		login.driver.findElement(
				By.xpath(login.LOCATORS
						.getProperty("Ig_select_servicecode_drpdwn")))
				.sendKeys(servicecode);
		Thread.sleep(3000);
		WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("Ig_select_servicecode")));
		action.moveToElement(ele).build().perform();
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_select_servicecode")))
				.click();
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("tag_save"))).click();
		Thread.sleep(3000);
		click_on_File_menu();
		click_on_Settings();
		click_on_Subscription_tab();
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_servicecode_display")))
				.size() != 0) {
			if (login.driver.findElements(
					By.xpath(login.LOCATORS
							.getProperty("Ig_servicecode_display"))).size() != 0)
				login.driver.findElement(
						By.xpath(login.LOCATORS
								.getProperty("Ig_servicecode_delete"))).click();
			Thread.sleep(2000);
			System.out.println("PASS");

			close_insight();
		} else {
			close_insight();
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_85
	@Given("^Verify product code field\\.$")
	public void verify_product_code_field() throws Throwable {
		String servicecode = "CEIC";
		login.driver.findElement(
				By.xpath(login.LOCATORS
						.getProperty("Ig_select_servicecode_drpdwn")))
				.sendKeys(servicecode);
		Thread.sleep(3000);
		WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("Ig_Productcode")));
		action.moveToElement(ele).build().perform();
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Productcode"))).click();
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Pcode"))).click();
		Thread.sleep(2000);
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_prodcode_drpdown")))
				.size() != 0) {
			System.out.println("PASS");
			close_insight();
		} else {
			close_insight();
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_86
	@Given("^Verify default selection for product code field\\.$")
	public void verify_default_selection_for_product_code_field()
			throws Throwable {
		String servicecode = "CEIC";
		login.driver.findElement(
				By.xpath(login.LOCATORS
						.getProperty("Ig_select_servicecode_drpdwn")))
				.sendKeys(servicecode);
		Thread.sleep(3000);
		WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("Ig_Productcode")));
		action.moveToElement(ele).build().perform();
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Productcode"))).click();
		Thread.sleep(3000);
		String Pcode = "All product codes";
		String Productcode = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Pcode"))).getText();
		if (Pcode.equalsIgnoreCase(Productcode)) {
			System.out.println("PASS");
			close_insight();
		} else {
			close_insight();
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_87
	@Given("^Verify remove icon for selected product codes\\.$")
	public void verify_remove_icon_for_selected_product_codes()
			throws Throwable {
		String servicecode = "CEIC";
		login.driver.findElement(
				By.xpath(login.LOCATORS
						.getProperty("Ig_select_servicecode_drpdwn")))
				.sendKeys(servicecode);
		Thread.sleep(3000);
		WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("Ig_Productcode")));
		action.moveToElement(ele).build().perform();
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Productcode"))).click();
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Pcode"))).click();
		Thread.sleep(3000);
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Pcode_search"))).sendKeys("ch");
		// Thread.sleep(5000);
		// WebElement chinapcode =
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_chinadb")));
		// Thread.sleep(3000);
		// action.moveToElement(chinapcode).build().perform();
		// Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_chinadb"))).click();
		Thread.sleep(2000);
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_remove_pcode"))).size() != 0) {

			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_remove_pcode")))
					.click();
			Thread.sleep(2000);
			System.out.println("PASS");
			close_insight();
		} else {
			close_insight();
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_88
	@Given("^Click on Keywords tab$")
	public void click_on_Keywords_tab() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Keywordstab"))).click();
	}

	@Given("^Verify keywords for the insights\\.$")
	public void verify_keywords_for_the_insights() throws Throwable {
		String keytext = "CEIC";
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Keyword_desc")))
				.sendKeys(keytext);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Keyword_desc")))
				.sendKeys(Keys.ENTER);
		close_insight();
		click_on_File_menu();
		click_on_Settings();
		click_on_Keywords_tab();
		String Keyword = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_keyword_text")))
				.getText();
		Thread.sleep(3000);
		System.out.println(Keyword);
		if (Keyword.contains(keytext)) {
			System.out.println("PASS");
			close_insight();
		} else {
			close_insight();
			Assert.fail("FAIL");
		}

	}

	// TC_InsightGeneral_89
	@Given("^Add Keywords$")
	public void add_Keywords() throws Throwable {
		String keytext = "CEIC DATA";
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Keyword_desc")))
				.sendKeys(keytext);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Keyword_desc")))
				.sendKeys(Keys.ENTER);
		close_insight();
	}

	@Given("^Verify the insight for added keywords in insight explorer\\.$")
	public void verify_the_insight_for_added_keywords_in_insight_explorer()
			throws Throwable {
		String InsightTitle = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Insight_Title")))
				.getText();
		open_insight();
		Thread.sleep(4000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_insight_search")))
				.sendKeys("CEIC DATA");
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_insight_search")))
				.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		String Title = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Fav_Insight_Title")))
				.getText();
		if (InsightTitle.equalsIgnoreCase(Title)) {
			System.out.println("PASS");
			delete_insight();

		} else {
			close_insight();
			Assert.fail("FAIL");
		}

	}

	// TC_InsightGeneral_90
	@Given("^Add Multiple Keywords and Verify$")
	public void add_Multiple_Keywords_and_verify() throws Throwable {
		String S1 = "CEICDATA";
		String S2 = "ISIMARKETS";
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Keyword_desc")))
				.sendKeys(S1);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Keyword_desc")))
				.sendKeys(Keys.ENTER);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Keyword_desc")))
				.sendKeys(S2);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Keyword_desc")))
				.sendKeys(Keys.ENTER);
		close_insight();
		click_on_File_menu();
		click_on_Settings();
		click_on_Keywords_tab();
		String Keyword = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_allkeywords")))
				.getText();
		Thread.sleep(3000);
		System.out.println(Keyword);
		if (Keyword.contains(S1)) {
			if (Keyword.contains(S2)) {
				System.out.println("PASS");
				close_insight();
			}
		} else {
			close_insight();
			Assert.fail("FAIL");
		}

	}

	// TC_InsightGeneral_91
	@Given("^Remove keywords and Verify$")
	public void remove_keywords() throws Throwable {
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_remove_key_1")))
				.size() != 0) {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_remove_keyword")))
					.click();
			Thread.sleep(2000);
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_remove_keyword")))
					.click();
			Thread.sleep(2000);
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("tag_save"))).click();
			Thread.sleep(3000);

		} else {
			close_insight();
			Assert.fail("FAIL");
		}

	}

	// TC_InsightGeneral_92
	@Given("^Click on Protect$")
	public void click_on_Protect() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Protect"))).click();
	}

	@Given("^Verify Protect option\\.$")
	public void verify_Protect_option() throws Throwable {
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_permission_tab_open")))
				.size() != 0) {
			System.out.println("PASS");
			close_insight();
		} else {
			close_insight();
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_93
	@Given("^Verify Download option for new insight\\.$")
	public void verify_Download_option_for_new_insight() throws Throwable {
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_Download_disabled")))
				.size() != 0) {
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
	public void verify_download_option_when_series_selected_in_search_panel()
			throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Downlaod"))).click();
		Thread.sleep(5000);
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_Downloadpopup")))
				.size() != 0) {
			System.out.println("PASS");
			close_insight();

		} else {
			close_insight();
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_95
	@Given("^Click on Insights on menu header\\.$")
	public void click_on_Insights_on_menu_header() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("insights"))).click();
		Thread.sleep(5000);
	}

	@Given("^Verify \"([^\"]*)\" dropdown is shown$")
	public void verify_dropdown_is_shown(String arg1) throws Throwable {
		Thread.sleep(2000);
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("insights_drpdwn"))).size() != 0) {
			System.out.println("PASS");
		} else {
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_96
	@Given("^Click on Favorites$")
	public void click_on_Favorites() throws Throwable {
		click_on_Insights_on_menu_header();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("favorites"))).click();
		Thread.sleep(9000);
	}

	@Given("^Verify 'Favorite' on Insight menu\\.$")
	public void verify_Favorite_on_Insight_menu() throws Throwable {
		Thread.sleep(5000);
		if (login.driver
				.findElements(
						By.xpath(login.LOCATORS
								.getProperty("Ig_my_insights_selected")))
				.size() != 0) {
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
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_Insightexplorer_Win")))
				.size() != 0) {
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
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("insights"))).click();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Analytictab"))).click();
		Thread.sleep(4000);
	}

	@Given("^Verify  CEIC Gallery tab is Open$")
	public void verify_CEIC_Gallery_tab_is_Open() throws Throwable {
		String SharedTitle = "Filter CEIC Gallery by category";
		String shared = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_ceicGal_text")))
				.getAttribute("title");
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_ceic_gallery"))).size() != 0) {
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
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("insights"))).click();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_sharedinsights")))
				.click();
		Thread.sleep(4000);
	}

	@Given("^Verify 'Shared insights' tab is open$")
	public void verify_Shared_insights_tab_is_open() throws Throwable {
		String SharedTitle = "Insights that other users have shared with you";
		String shared = login.driver
				.findElement(
						By.xpath(login.LOCATORS
								.getProperty("Ig_my_insights_selected")))
				.getAttribute("title");
		if (login.driver
				.findElements(
						By.xpath(login.LOCATORS
								.getProperty("Ig_my_insights_selected")))
				.size() != 0) {
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
		String insight = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Untitled_insight")))
				.getText();
		System.out.println(insight);
		Thread.sleep(4000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("insights"))).click();
		Thread.sleep(2000);
		String recentinsight = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_recent_insight")))
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
	public void verify_displayed_insights_count_for_Recent_insights()
			throws Throwable {
		int expected = 8;
		click_on_File_menu();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("insights"))).click();
		Thread.sleep(2000);
		int size = login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_recentinsight_count")))
				.size();
		if (size == expected) {
			System.out.println("PASS");
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_More"))).click();
			Thread.sleep(5000);
			if (login.driver.findElements(
					By.xpath(login.LOCATORS.getProperty("Ig_Insightexplorer_Win")))
					.size() != 0) {

				login.driver.findElement(
						By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
				System.out.println("Insight explorer window is open");
			} else {
				login.driver.findElement(
						By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
				Assert.fail("Insight explorer window is not open");
			}
		} else {
			Assert.fail("FAIL");
		}
		
	}

	// TC_InsightGeneral_102
	@Given("^Click on recent insight$")
	public void click_on_recent_insight() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("insights"))).click();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_recent_insight")))
				.click();
		Thread.sleep(4000);
	}

	@Given("^Verify insight open in preview mode$")
	public void verify_insight_open_in_preview_mode() throws Throwable {
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_insight_preview")))
				.size() != 0) {

			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close")))
					.click();
			System.out.println("Insight open in preview mode");
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_Preview_Close")))
					.click();
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_103
	@Given("^Verify 'Latest CEIC Insights'$")
	public void verify_Latest_CEIC_Insights() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("insights"))).click();
		Thread.sleep(2000);
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_latest_insight")))
				.size() != 0) {

			System.out.println("Latest insight is shown");

		} else {

			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_104
	@Given("^Click on Insights$")
	public void click_on_Insights() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("insights"))).click();
		Thread.sleep(2000);

	}

	@Given("^Verify number of displayed insights for latest CEIC Insights\\.$")
	public void verify_number_of_displayed_insights_for_latest_CEIC_Insights()
			throws Throwable {
		int Latest_CEIC_INSIGHT_COUNT = 3;
		int insightcount = login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_latest_insight")))
				.size();
		System.out.println(insightcount);
		if (insightcount == Latest_CEIC_INSIGHT_COUNT) {
			System.out.println("PASS");
		} else {
			Assert.fail("FAIL");
		}
	}

	@Given("^Verify More option$")
	public void verify_More_option() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_latest_ceic_more")))
				.click();
		Thread.sleep(5000);
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_Insightexplorer_Win")))
				.size() != 0) {

			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
			System.out.println("Insight explorer window is open");
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
			Assert.fail("Insight explorer window is not open");
		}
	}

	// TC_InsightGeneral_105
	@Given("^Click on Latest insight$")
	public void click_on_Latest_insight() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_lat_ceic_in"))).click();
		Thread.sleep(9000);
	}

	// TC_InsightGeneral_106
	@Given("^Verify  'Latest EMIS Insights'\\.$")
	public void verify_Latest_EMIS_Insights() throws Throwable {
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_EMIS_Insight"))).size() != 0) {

			System.out.println("Latest EMIS insight is shown");
		} else {

			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_107
	@Given("^Verify number of displayed insights for Latest EMIS Insights\\.$")
	public void verify_number_of_displayed_insights_for_Latest_EMIS_Insights()
			throws Throwable {
		int Latest_EMIS_INSIGHT_COUNT = 3;
		int insightcount = login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_latest_emis_insight")))
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

		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_lat_emis_in"))).click();
		Thread.sleep(9000);
	}

	// TC_InsightGeneral_109
	@Given("^Click on  More option under EMIS insight$")
	public void click_on_More_option_under_EMIS_insight() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_latest_emis_more")))
				.click();
		Thread.sleep(5000);
	}

	@Given("^Verify More option for Latest EMIS Insights$")
	public void verify_More_option_for_Latest_EMIS_Insights() throws Throwable {
		if (login.driver
				.findElements(
						By.xpath(login.LOCATORS
								.getProperty("Ig_my_insights_selected")))
				.size() != 0) {
			String text = "CEIC Analytics";
			String analytics = login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("Ig_my_insights_selected")))
					.getAttribute("title");
			if (analytics.equalsIgnoreCase(text)) {
				login.driver.findElement(
						By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE")))
						.click();
				System.out.println("Analytics tab  is open");

			} else {
				login.driver.findElement(
						By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE")))
						.click();
				Assert.fail("Insight explorer window is not open");
			}
		}
	}

	// TC_InsightGeneral_110
	@Given("^Click on Open insight Explorer$")
	public void click_on_Open_insight_Explorer() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_open_inexplorer")))
				.click();
		Thread.sleep(5000);
	}

	@Given("^Verify default tab for open insight explorer\\.$")
	public void verify_default_tab_for_open_insight_explorer() throws Throwable {
		verify_More_option_for_Latest_EMIS_Insights();
	}

	// TC_InsightGeneral_111
	@Given("^Click on Products$")
	public void click_on_Products() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Prod_tab"))).click();
		Thread.sleep(4000);
	}

	@Given("^Verify \"([^\"]*)\" dropdown$")
	public void verify_dropdown(String arg1) throws Throwable {

		List<WebElement> elementsList = login.driver.findElements(By
				.xpath(login.LOCATORS.getProperty("Ig_prod_dropdown")));
		for (int i = 0; i < elementsList.size(); ++i) {
			String checkBox1 = elementsList.get(0).getText();
			String checkBox2 = elementsList.get(1).getText();
			String checkBox3 = elementsList.get(2).getText();

			if (checkBox1.contains("What's new?")
					&& checkBox2.contains("World Trend Plus")
					&& checkBox3.contains("Global Database")) {
				System.out.println("PASS");
			} else {
				Assert.fail("FAIL");
			}

		}
		String premiumtext = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_prod1_dropdown")))
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
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Explore_data")))
				.click();
		Thread.sleep(3000);
	}

	@Given("^Verify for new announcement pop up$")
	public void verify_for_new_announcement_pop_up() throws Throwable {
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_announcement_popup")))
				.size() != 0) {
			System.out.println("Announcement pop up is shown");
			close_insight();
		} else {
			close_insight();
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_113
	@Given("^Click on Help$")
	public void click_on_Help() throws Throwable {
		click_on_File_menu();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("HELP")))
				.click();
		Thread.sleep(3000);
//		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("HELP")))
//		.click();
	}

	@Given("^Click on contact us$")
	public void click_on_contact_us() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Contactus"))).click();
		Thread.sleep(10000);
	}

	@Given("^Verify redirection to contact page$")
	public void verify_redirection_to_contact_page() throws Throwable {
		switch_to_new_tab();
		String ExpectedURL = "https://www.ceicdata.com/en/contact_us.htm";
		String Actualurl = login.driver.getCurrentUrl();
		Assert.assertEquals(Actualurl, ExpectedURL);
		close_new_tab();
	}

	// TC_InsightGeneral_114
	@Given("^Click on Email us$")
	public void click_on_Email_us() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Email"))).click();
		Thread.sleep(3000);
	}

	@Given("^Verify Email us pop up is shown$")
	public void verify_Email_us_pop_up_is_shown() throws Throwable {
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_Emailus_popup")))
				.size() != 0) {
			System.out.println("Email pop up is shown");
			close_insight();
		} else {
			close_insight();
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_115
	@Given("^Verify red color for mandatory fields$")
	public void verify_red_color_for_mandatory_fields() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_save_enable"))).click();
		Thread.sleep(3000);
		WebElement subjectinputbox = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("Ig_subject")));
		String colorCode = subjectinputbox.getCssValue("border-color");
		System.out.println("Color code in RGB" + colorCode);
		String expectedColorCodeInRGB = "rgb(228, 41, 39)";
		// Asserting actual and expected color codes
		Assert.assertEquals(colorCode, expectedColorCodeInRGB);
		WebElement Messageinputbox = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("Ig_message")));
		String colorCodeMessage = Messageinputbox.getCssValue("border-color");
		System.out.println("Color code in RGB" + colorCodeMessage);
		String expectedColorCodeInRGBMess = "rgb(228, 41, 39)";
		// Asserting actual and expected color codes
		Assert.assertEquals(colorCode, expectedColorCodeInRGBMess);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE")))
				.click();
	}

	// TC_InsightGeneral_116
	@Given("^Enter all fields$")
	public void enter_all_fields() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_subject"))).sendKeys(
				"Testing");
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_CC")))
				.sendKeys("bshilpa@isimarkets.com,bshilpa@shravas.com");
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_message"))).sendKeys(
				"Testing please ignore");
		Thread.sleep(2000);

	}

	@Given("^Upload file using upload button$")
	public void upload_file_using_upload_button() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_uploadfile"))).click();
		Thread.sleep(2000);
		String downloadPath = System.getProperty("user.home")
				+ "\\Downloads\\SampleImage.JPG";
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
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_save_enable"))).click();
		Thread.sleep(8000);
	}

	@Given("^Verify confirmation message is shown$")
	public void verify_confirmation_message_is_shown() throws Throwable {
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_Save_Message_text")))
				.size() != 0) {
			System.out.println("Email sent message is shown");

		} else {

			Assert.fail("FAIL");
		}
		Thread.sleep(6000);
	}

	// TC_InsightGeneral_117

	@Given("^Enter all fields with no recipient$")
	public void enter_all_fields_with_no_recipient() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_subject"))).sendKeys(
				"Testing");
		Thread.sleep(2000);

		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_message"))).sendKeys(
				"Testing please ignore");
		Thread.sleep(2000);

	}

	@Given("^Upload file using drag and drop$")
	public void upload_file_using_drag_and_drop() throws Throwable {
		String downloadPath = System.getProperty("user.home")
				+ "\\Downloads\\SampleImage.JPG";

		WebElement dropArea = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("Ig_droparea")));
		DropFile(new File(downloadPath), dropArea, 0, 0);
		Thread.sleep(4000);
	}

	// TC_InsightGeneral_118
	@Given("^Verify invalid  email under recipient$")
	public void verify_invalid_email_under_recipient() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_subject"))).sendKeys(
				"Testing");
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_CC")))
				.sendKeys("AAA");
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_message"))).sendKeys(
				"Testing please ignore");
		Thread.sleep(2000);
		click_on_Send();
		WebElement subjectinputbox = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("Ig_CC")));
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
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_attachment"))).size() != 0) {
			if (login.driver.findElements(
					By.xpath(login.LOCATORS.getProperty("Ig_attachment")))
					.size() != 0) {

				login.driver.findElement(
						By.xpath(login.LOCATORS
								.getProperty("Ig_Remove_attachment"))).click();
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
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_Emailus_popup")))
				.size() != 0) {
			if (login.driver.findElements(
					By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).size() != 0) {

				login.driver.findElement(
						By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE")))
						.click();
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
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Knowledgebase")))
				.click();
	}

	@Given("^Verify 'Knowledge base'$")
	public void verify_Knowledge_base() throws Throwable {
		switch_to_new_tab();
		String ExpectedURL = "https://support.ceicdata.com/support/solutions";
		String Actualurl = login.driver.getCurrentUrl();
		Assert.assertEquals(Actualurl, ExpectedURL);
		close_new_tab();
	}

	// TC_InsightGeneral_122
	@Given("^Click on Diagnostics$")
	public void click_on_Diagnostics() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Diagnostic"))).click();
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
		String configStatus = "Success";
		String Ig_ip_address = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_ip_address")))
				.getText();
		String Ig_ceic_auth = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_ceic_auth"))).getText();
		String Ig_appln_services = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_appln_services")))
				.getText();
		String Ig_ammazon_cloud = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_ammazon_cloud")))
				.getText();
		String Ig_Amazon_S3 = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Amazon_S3"))).getText();
		String Ig_Know_Base = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Know_Base"))).getText();
		String Ig_Freshchat = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Freshchat"))).getText();
		if (configStatus.equalsIgnoreCase(Ig_ip_address)
				&& configStatus.equalsIgnoreCase(Ig_ceic_auth)
				&& configStatus.equalsIgnoreCase(Ig_appln_services)
				&& configStatus.equalsIgnoreCase(Ig_ammazon_cloud)
				&& configStatus.equalsIgnoreCase(Ig_Amazon_S3)
				&& configStatus.equalsIgnoreCase(Ig_Know_Base)
				&& configStatus.equalsIgnoreCase(Ig_Freshchat)) {
			System.out.println("PASS");
			close_new_tab();
		} else {
			close_new_tab();
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_124
	@Given("^Verify 'Report a problem' in Diagnostics page\\.$")
	public void verify_Report_a_problem_in_Diagnostics_page() throws Throwable {
		switch_to_new_tab();
		WebElement Element = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("Ig_Report_Prob")));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Report_Prob"))).click();
		Thread.sleep(5000);
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_Report_popup"))).size() != 0) {
			System.out.println("Report pop up is shown");
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_report_close")))
					.click();
			close_new_tab();
		} else {
			close_new_tab();
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_125
	@Given("^verify 'Send' button on Report a problem window\\.$")
	public void verify_Send_button_on_Report_a_problem_window()
			throws Throwable {
		switch_to_new_tab();
		WebElement Element = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("Ig_Report_Prob")));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Report_Prob"))).click();
		Thread.sleep(5000);
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_Email"))).sendKeys("bshilpa@isimarkets.com");
		// Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_desc"))).sendKeys(
				"Testing please ignore");
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_report_send"))).click();
		Thread.sleep(40000);
		String alertMessage = "Your issue has been successfully sent to our support team. We apologize for any inconvenience caused. Thank you for your patience.";
		String alertText = login.driver.switchTo().alert().getText();
		if (alertMessage.equalsIgnoreCase(alertText)) {
			System.out.println("Report Sent");
			System.out.println(alertText);
			login.driver.switchTo().alert().accept();
			close_new_tab();
		} else {
			close_new_tab();
			Assert.fail("FAIL");
		}

	}

	// TC_InsightGeneral_126
	@Given("^Verify 'Attachments' on Report a problem$")
	public void verify_Attachments_on_Report_a_problem() throws Throwable {
		switch_to_new_tab();
		WebElement Element = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("Ig_Report_Prob")));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Report_Prob"))).click();
		Thread.sleep(5000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_attach_screenshot")))
				.click();
		Thread.sleep(2000);
		String downloadPath = System.getProperty("user.home")
				+ "\\Downloads\\SampleImage.JPG";
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
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_report_send"))).click();
		Thread.sleep(35000);
		String alertMessage = "Your issue has been successfully sent to our support team. We apologize for any inconvenience caused. Thank you for your patience.";
		String alertText = login.driver.switchTo().alert().getText();
		if (alertMessage.equalsIgnoreCase(alertText)) {
			System.out.println("Report Sent");
			System.out.println(alertText);
			login.driver.switchTo().alert().accept();
			close_new_tab();
		} else {
			close_new_tab();
			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_127
	@Given("^Verify 'Cancel and dismiss' buttons on the window\\.$")
	public void verify_Cancel_and_dismiss_buttons_on_the_window()
			throws Throwable {
		switch_to_new_tab();
		WebElement Element = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("Ig_Report_Prob")));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Report_Prob"))).click();
		Thread.sleep(5000);
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_Report_popup"))).size() != 0) {
			if (login.driver.findElements(
					By.xpath(login.LOCATORS.getProperty("Ig_report_close")))
					.size() != 0) {

				login.driver
						.findElement(
								By.xpath(login.LOCATORS
										.getProperty("Ig_report_close")))
						.click();
				Thread.sleep(3000);
				System.out.println("Pop up closed");
			} else {
				Assert.fail("FAIL");
			}

		}
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Report_Prob"))).click();
		Thread.sleep(5000);
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_Report_popup"))).size() != 0) {
			if (login.driver.findElements(
					By.xpath(login.LOCATORS.getProperty("Ig_report_close"))).size() != 0) {

				login.driver.findElement(
						By.xpath(login.LOCATORS.getProperty("Ig_Close")))
						.click();
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
		login.driver
				.findElement(
						By.xpath(login.LOCATORS
								.getProperty("Ig_ReportProblem_option")))
				.click();
		Thread.sleep(5000);
	}

	@Given("^Verify 'Report a problem' under Help menu\\.$")
	public void verify_Report_a_problem_under_Help_menu() throws Throwable {
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_Report_popup"))).size() != 0) {
			System.out.println("Report pop up is shown");
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_report_close")))
					.click();

		} else {

			Assert.fail("FAIL");
		}
	}

	// TC_InsightGeneral_129
	@Given("^Enter the description$")
	public void enter_the_description() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_desc"))).sendKeys(
				"Testing please ignore");
		Thread.sleep(2000);
	}

	@Given("^Add the attachment$")
	public void add_the_attachment() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_attach_screenshot")))
				.click();
		Thread.sleep(2000);
		String downloadPath = System.getProperty("user.home")
				+ "\\Downloads\\SampleImage.JPG";
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
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_report_send"))).click();
		Thread.sleep(10000);
	}

	// TC_InsightGeneral_130
	@Given("^Verify Send Report$")
	public void verify_Send_Report() throws Throwable {

		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("growl_message_popup")))
				.size() != 0) {
			System.out.println("Report pop up is shown");

		} else {

			Assert.fail("FAIL");
		}
	}

	@Given("^Verify Cancel/x buttons for report a problem under HElp dropdown\\.$")
	public void verify_Cancel_x_buttons_for_report_a_problem_under_HElp_dropdown()
			throws Throwable {
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_Report_popup"))).size() != 0) {
			if (login.driver.findElements(
					By.xpath(login.LOCATORS.getProperty("Ig_report_close")))
					.size() != 0) {

				login.driver
						.findElement(
								By.xpath(login.LOCATORS
										.getProperty("Ig_report_close")))
						.click();
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
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_livechat_off")))
				.click();
		Thread.sleep(2000);

	}

	@Given("^Verify Live Chat Option$")
	public void verify_Live_Chat_Option() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_livechat_on"))).click();
		Thread.sleep(2000);
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_live_chat"))).size() != 0) {
			System.out.println("live chat is shown");

		} else {
			Assert.fail("FAIL");
		}
	}
	// TC_InsightGeneral_132
@Given("^Click on Vedio tutorial$")
public void click_on_Vedio_tutorial() throws Throwable {
	
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_vedio_tutorial"))).click();
	Thread.sleep(3000);
	
}
public void sidebar() throws Exception{
	WebElement slidebar = login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_slidebar")));
	Thread.sleep(7000);
	action.moveToElement(slidebar).build().perform();
	
}
public void playbtn() throws Exception{
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_play_btn"))).click();
	
}
public void verify_remaining_time() throws Exception{
	WebElement progressBar1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_slidebar")));
	Thread.sleep(3000);	
	action.moveToElement(progressBar1).build().perform();
		
		String remainingTime = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ig_remaining_time"))).getText();
	Thread.sleep(3000);
		System.out.println(remainingTime);
	String remainTime = "-0:00";
	if(!remainingTime.matches(remainTime))
	{
		System.out.println("Vedio played ");
	}
	else{
		Assert.fail("Vedio did not play");
	}
}
public void pause(){
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_pause"))).click();
}

@Given("^Verify 'Video tutorials'$")
public void verify_Video_tutorials() throws Throwable {
	//Ig_CDMNextv3.0Overview
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_CDMNextv3.0Overview"))).click();
	Thread.sleep(10000);
	sidebar();
	playbtn();
	verify_remaining_time();
	Thread.sleep(3000);
	//Ig_CDMNext_Add-in_v3.0_Overview
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_CDMNext_Add-in_v3.0_Overview"))).click();
	Thread.sleep(10000);
	sidebar();
			verify_remaining_time();
		Thread.sleep(3000);
//Ig_CDMNextv3.0Overview
login.driver.findElement(
	By.xpath(login.LOCATORS.getProperty("Ig_Overview_of_CDMNext_application"))).click();
Thread.sleep(20000);
sidebar();
pause();
verify_remaining_time();
Thread.sleep(3000);
WebElement ele1 = login.driver.findElement(
		By.xpath(login.LOCATORS.getProperty("Ig_how_to_search_and_navigate")));
((JavascriptExecutor)login.driver).executeScript("arguments[0].scrollIntoView();"
        ,ele1);
//Ig_how_to_search_and_navigate
login.driver.findElement(
		By.xpath(login.LOCATORS.getProperty("Ig_how_to_search_and_navigate"))).click();
Thread.sleep(10000);
sidebar();
pause();
		verify_remaining_time();
		Thread.sleep(3000);
		WebElement ele2 = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_how_to_create_visuals_and_transform_se")));
		((JavascriptExecutor)login.driver).executeScript("arguments[0].scrollIntoView();"
		        ,ele2);
//Ig_how_to_create_visuals_and_transform_se
login.driver.findElement(
		By.xpath(login.LOCATORS.getProperty("Ig_how_to_create_visuals_and_transform_se"))).click();
Thread.sleep(10000);
sidebar();
pause();
		verify_remaining_time();
		Thread.sleep(3000);
		WebElement ele3 = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Session_3")));
		((JavascriptExecutor)login.driver).executeScript("arguments[0].scrollIntoView();"
		        ,ele3);
//Ig_Session_3
login.driver.findElement(
		By.xpath(login.LOCATORS.getProperty("Ig_Session_3"))).click();
Thread.sleep(10000);
sidebar();
pause();
		verify_remaining_time();
		Thread.sleep(3000);
		WebElement ele4 = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_Session_4")));
		((JavascriptExecutor)login.driver).executeScript("arguments[0].scrollIntoView();"
		        ,ele4);
//Ig_Session_4
login.driver.findElement(
		By.xpath(login.LOCATORS.getProperty("Ig_Session_4"))).click();
Thread.sleep(10000);
sidebar();
pause();
	verify_remaining_time();
	Thread.sleep(3000);
	WebElement ele5 = login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_Session_5")));
	((JavascriptExecutor)login.driver).executeScript("arguments[0].scrollIntoView();"
	        ,ele5);
//Ig_Session_5
login.driver.findElement(
		By.xpath(login.LOCATORS.getProperty("Ig_Session_5"))).click();
Thread.sleep(10000);
sidebar();
pause();
verify_remaining_time();
WebElement ele6 = login.driver.findElement(
		By.xpath(login.LOCATORS.getProperty("Ig_Session_6_how_to_get_help")));
((JavascriptExecutor)login.driver).executeScript("arguments[0].scrollIntoView();"
        ,ele6);
//Ig_Session_6_how_to_get_help
login.driver.findElement(
		By.xpath(login.LOCATORS.getProperty("Ig_Session_6_how_to_get_help"))).click();
Thread.sleep(10000);
sidebar();
pause();
	verify_remaining_time();
	Thread.sleep(3000);
	
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Vedio_close"))).click();
}
// TC_InsightGeneral_133
@Given("^Click on Quick Start Guide$")
public void click_on_Quick_Start_Guide() throws Throwable {
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_Quick_guide"))).click();
	Thread.sleep(10000);
}

@Given("^Verify 'Quick start Guide'$")
public void verify_Quick_start_Guide() throws Throwable {
   switch_to_new_tab();
   String actualURL="https://stage.ceicdata.com/file?path=/guides/pdfs/5ab597e0-ca6c-4d2e-92a7-ff5eeb7d4b3d";
  String expectedURL= login.driver.getCurrentUrl();
  Assert.assertEquals(actualURL, expectedURL);
  close_new_tab();
}
//TC_InsightGeneral_134
@Given("^Verify window dismiss button\\.$")
public void verify_window_dismiss_button() throws Throwable {
	if (login.driver.findElements(
			By.xpath(login.LOCATORS.getProperty("Ig_vedio_popup"))).size() != 0) {
		if(login.driver.findElements(
			By.xpath(login.LOCATORS.getProperty("Vedio_close"))).size() != 0)
			{
				login.driver.findElement(
						By.xpath(login.LOCATORS.getProperty("Vedio_close"))).click();
				System.out.println("vedio pop up closed");
			}
			else {
				Assert.fail("FAIL");
			}

	} 
	
}
//TC_InsightGeneral_135
	@Given("^Click on Tour$")
	public void click_on_Tour() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_tour_btn"))).click();
	}
	@Given("^Verify tours$")
	public void verify_tours() throws Throwable {
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_Tour"))).size() != 0) {
			System.out.println("Tour is shown");
		}
		else{
			Assert.fail("FAIL");
		}
	}
	//TC_InsightGeneral_136
	@Given("^Click on Help Menu$")
	public void click_on_Help_Menu() throws Throwable {
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("HELP")))
		.click();
Thread.sleep(3000);
	}
@Given("^Set preference to Insight Explorer$")
public void set_preference_to_Insight_Explorer() throws Throwable {
    Footnotes f=new Footnotes();
    f.set_the_Preference_to_insight_explorer();
    f.click_on_CEIC_logo();
}

@Given("^Verify Tour to landing page$")
public void verify_Tour_to_landing_page() throws Throwable {
	if (login.driver.findElements(
			By.xpath(login.LOCATORS.getProperty("Ig_landingpg_1"))).size() != 0) {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_tour_next_btn"))).click();
		Thread.sleep(3000);
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_landingpg_2"))).size() != 0){
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_tour_next_btn"))).click();
			Thread.sleep(3000);
			if (login.driver.findElements(
					By.xpath(login.LOCATORS.getProperty("Ig_landingpg_3"))).size() != 0){
				login.driver.findElement(
						By.xpath(login.LOCATORS.getProperty("Ig_tour_next_btn"))).click();
				Thread.sleep(3000);
				if (login.driver.findElements(
						By.xpath(login.LOCATORS.getProperty("Ig_landingpg_4"))).size() != 0){
					System.out.println("Tour guide about landing page");
					Footnotes f=new Footnotes();
					f.set_the_Preference_to_new_insight();
					Thread.sleep(3000);
					f.click_on_CEIC_logo();
				}
			}
		}
	}
	else{
		Assert.fail("FAIL");
	}
}
//TC_InsightGeneral_137
@Given("^Verify Tour to Search Panel$")
public void verify_Tour_to_Search_Panel() throws Throwable {
	if (login.driver.findElements(
			By.xpath(login.LOCATORS.getProperty("Ig_Tour1"))).size() != 0){
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_tour_next_btn"))).click();
		Thread.sleep(3000);
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_Tour2"))).size() != 0){
			System.out.println("Tour guide about Search Panel");
			
		}
		else{
			Assert.fail("FAIL");
		}
	}
	
}
//TC_InsightGeneral_138
@Given("^Verify Tour to My series$")
public void verify_Tour_to_My_series() throws Throwable {
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_tour_next_btn"))).click();
	Thread.sleep(3000);
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_tour_next_btn"))).click();
	Thread.sleep(3000);
	if (login.driver.findElements(
			By.xpath(login.LOCATORS.getProperty("Ig_Tour3"))).size() != 0){
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_tour_next_btn"))).click();
		Thread.sleep(3000);
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_Tour4"))).size() != 0){
			System.out.println("Tour guide about my series");
		}
		else{
			Assert.fail("FAIL");
		}
		}
	
	}
//TC_InsightGeneral_139
@Given("^Verify Tour to visuals$")
public void verify_Tour_to_visuals() throws Throwable {
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_addview_btn"))).click();
	Thread.sleep(2000);
	click_on_Help();
	click_on_Tour();
	Thread.sleep(3000);
	if (login.driver.findElements(
			By.xpath(login.LOCATORS.getProperty("Ig_Tour5"))).size() != 0){
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_tour_next_btn"))).click();
		Thread.sleep(3000);
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("Ig_Tour6"))).size() != 0){
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_tour_next_btn"))).click();
			Thread.sleep(3000);
			if (login.driver.findElements(
					By.xpath(login.LOCATORS.getProperty("Ig_Tour7"))).size() != 0){
				System.out.println("Tour guide about Visuals");
				delete_all_views();
			}
		}
		}
	else{
		Assert.fail("FAIL");
	}
	
	}
//TC_InsightGeneral_140
@Given("^Click on Next Tour$")
public void click_on_Next_Tour() throws Throwable {
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_tour_next_btn"))).click();
	Thread.sleep(3000);
}

@Given("^Verify Previous button$")
public void verify_Previous_button() throws Throwable {
	
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_Previous_Tour"))).click();
	Thread.sleep(3000);
	if (login.driver.findElements(
			By.xpath(login.LOCATORS.getProperty("Ig_Tour1"))).size() != 0){
		System.out.println("Previous tour should be displayed");
	}
	else{
		Assert.fail("FAIL");
	}
}
//TC_InsightGeneral_141
@Given("^Verify 'I'm Done' option\\.$")
public void verify_I_m_Done_option() throws Throwable {
	if (login.driver.findElements(
			By.xpath(login.LOCATORS.getProperty("Ig_i_m_done"))).size() != 0){
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_i_m_done"))).click();
		System.out.println(" Tour is closed");
	}
	else{
		Assert.fail("FAIL");
	}
}
//TC_InsightGeneral_142
@Given("^Verify window 'dismiss\\(x\\)' option\\.$")
public void verify_window_dismiss_x_option() throws Throwable {
	if (login.driver.findElements(
			By.xpath(login.LOCATORS.getProperty("Ig_tour_close"))).size() != 0){
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_tour_close"))).click();
		System.out.println(" Tour is closed");
	}
	else{
		Assert.fail("FAIL");
	}
}
//TC_InsightGeneral_143
@Given("^Click on Search Help$")
public void click_on_Search_Help() throws Throwable {
	
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_Search_Help"))).click();
	Thread.sleep(3000);
}

@Given("^Verify 'search help'$")
public void verify_search_help() throws Throwable {
	if (login.driver.findElements(
			By.xpath(login.LOCATORS.getProperty("Ig_keyword_tip"))).size() != 0){
		
		System.out.println(" Keyword search tips opened");
		close_insight();
	}
	else{
		Assert.fail("FAIL");
	}
}
//TC_InsightGeneral_144
@Given("^Verify serarch help window close buttons\\.$")
public void verify_serarch_help_window_close_buttons() throws Throwable {
	if (login.driver.findElements(
			By.xpath(login.LOCATORS.getProperty("Ig_keyword_close"))).size() != 0){
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Ig_keyword_close"))).click();
		System.out.println(" Keyword search tips closed");
	
	}
	else{
		Assert.fail("FAIL");
	}
}
//TC_InsightGeneral_145
@Given("^Click on Keyboard shortcuts$")
public void click_on_Keyboard_shortcuts() throws Throwable {
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_keyboard_shortcut"))).click();
	Thread.sleep(3000);
}

@Given("^Verify 'Keyboard shortcuts'$")
public void verify_Keyboard_shortcuts() throws Throwable {
	if (login.driver.findElements(
			By.xpath(login.LOCATORS.getProperty("Ig_keyboard_shortcut_win"))).size() != 0){
				System.out.println(" Keyword shortcut window open");
				close_insight();
		}
	else{
		Assert.fail("FAIL");
	}
}
//TC_InsightGeneral_146
@Given("^Click on Application Excel Add-in$")
public void click_on_Application_Excel_Add_in() throws Throwable {
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_Excel_addin"))).click();
	Thread.sleep(3000);
}

@Given("^Verify Excel Add-in tab is open$")
public void verify_Excel_Add_in_tab_is_open() throws Throwable {
	if (login.driver.findElements(
			By.xpath(login.LOCATORS.getProperty("Ig_Excel_addin_tab"))).size() != 0){
				System.out.println("Excel addin tab is open");
				close_insight();
		}
	else{
		Assert.fail("FAIL");
	}
}
//TC_InsightGeneral_147
@Given("^Verify Excel add-in version in popup$")
public void verify_Excel_add_in_version_in_popup() throws Throwable {
    String Actual_Excel_addin_ver="Download CDMNext Add-in for Microsoft Excel® Version 3.0.1.4";
    String Expected_Excel_addin_ver=login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_excel_addin_ver"))).getText();
    Assert.assertEquals(Actual_Excel_addin_ver, Expected_Excel_addin_ver);
    close_insight();
}
//TC_InsightGeneral_148
@Given("^Verify 'OS and MS Office' selection on popup\\.$")
public void verify_OS_and_MS_Office_selection_on_popup() throws Throwable {
		//Select office version
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_excel_win_drpdwn"))).click();
	WebElement ele = login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_64bit")));
	
	action.moveToElement(ele).build().perform();
	
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_64bit"))).click();
	Thread.sleep(2000);
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_excel_win_drpdwn"))).click();
	
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_select_win8"))).click();
	Thread.sleep(4000);

	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_excel_office_drpdwn"))).click();
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_office2013"))).click();
	Thread.sleep(2000);
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_excel_office_drpdwn"))).click();
		login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_select_office"))).click();
	
	String Actual_MS_win_version="Windows 8";
	String Actual_MS_office_version="Office 2010";
	
	String Ex_MS_win_version=login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_MS_win_ver"))).getText();
	String Ex_MS_office_version=login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_Ms_Office_ver"))).getText();
	if(Ex_MS_win_version.equalsIgnoreCase(Actual_MS_win_version))
	{
		System.out.println("PASS");
	}
	else{
		
		Assert.fail("FAIL");
	}
	if(Ex_MS_office_version.equalsIgnoreCase(Actual_MS_office_version))
	{
		System.out.println("PASS");
		close_insight();
	}
	else{
		close_insight();
		Assert.fail("FAIL");
	}
}
//TC_InsightGeneral_149
@Given("^Verify 'Download' CDMNext add-in navigate to new tab$")
public void verify_Download_CDMNext_add_in_navigate_to_new_tab() throws Throwable {
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_download_addin_btn"))).click();
	Thread.sleep(5000);
	switch_to_new_tab();
	String Actual_URL="https://www.ceicdata.com/en/login?ref=https://www.ceicdata.com/client/fileDownloader.php?file=SetupCDMNext_x86(3.0.1.4).zip&h=5372322828";
	String Ex_URL=login.driver.getCurrentUrl();
	close_new_tab();
	Assert.assertEquals(Actual_URL, Ex_URL);
	close_insight();
	
}
//TC_InsightGeneral_150
@Given("^Click on Document link$")
public void click_on_Document_link() throws Throwable {
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_Document_links"))).click();
  }

@Given("^Verify available 'Documents' in add-in popup$")
public void verify_available_Documents_in_add_in_popup() throws Throwable {
	Thread.sleep(20000);
	switch_to_new_tab();
	String Actual_URL="https://www.ceicdata.com/en/login?ref=https://www.ceicdata.com/client/fileDownloader.php?file=CDMNext%20Addin%20Start%20Guide_3.0.1.pdf";
	String Ex_URL=login.driver.getCurrentUrl();
	close_new_tab();
	Assert.assertEquals(Actual_URL, Ex_URL);
	close_insight();
}
//TC_InsightGeneral_151
@Given("^Verify 'Open' the popup with new tab$")
public void verify_Open_the_popup_with_new_tab() throws Throwable {
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("open_icon"))).click();
	Thread.sleep(20000);
	switch_to_new_tab();
	String Actual_URL="https://stage.ceicdata.com/landing/insights?installations=addin";
	String Ex_URL=login.driver.getCurrentUrl();
	close_new_tab();
	Assert.assertEquals(Actual_URL, Ex_URL);
	close_insight();
}
//TC_InsightGeneral_152
@Given("^Verify Popup dismiss\\(x\\) option\\.$")
public void verify_Popup_dismiss_x_option() throws Throwable {
	if (login.driver.findElements(
			By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).size() != 0){
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("MYINSIGHTS_CLOSE"))).click();
				System.out.println("Excel addin pop up is closed");
				
		}
	else{
		Assert.fail("FAIL");
	}
}
//TC_InsightGeneral_153
@Given("^Click on API tab and Verify$")
public void click_on_API_tab_and_Verify() throws Throwable {
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_API"))).click();
	Thread.sleep(10000);
	if (login.driver.findElements(
			By.xpath(login.LOCATORS.getProperty("Ig_API_view"))).size() != 0){
		
				System.out.println("API tab is open");
				
		}
	else{
		close_insight();
		Assert.fail("FAIL");
	}
}

@Given("^Click on R tab and Verify$")
public void click_on_R_tab_and_Verify() throws Throwable {
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_R"))).click();
	Thread.sleep(10000);
	if (login.driver.findElements(
			By.xpath(login.LOCATORS.getProperty("Ig_R_view"))).size() != 0){
		
				System.out.println("R tab is open");
				
		}
	else{
		close_insight();
		Assert.fail("FAIL");
	}
}

@Given("^Click on Eviews tab and Verify$")
public void click_on_Eviews_tab_and_Verify() throws Throwable {
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_Views"))).click();
	Thread.sleep(10000);
	if (login.driver.findElements(
			By.xpath(login.LOCATORS.getProperty("Ig_E_View"))).size() != 0){
		
				System.out.println("EViews tab is open");
				close_insight();
		}
	else{
		close_insight();
		Assert.fail("FAIL");
	}
}
//TC_InsightGeneral_154
@Given("^Click on API and Verify$")
public void click_on_API_and_Verify() throws Throwable {
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_Help_Api"))).click();
	Thread.sleep(2000);
	if (login.driver.findElements(
			By.xpath(login.LOCATORS.getProperty("Ig_API_tab"))).size() != 0){
		
				System.out.println("API tab is active");
				close_insight();
		}
	else{
		close_insight();
		Assert.fail("FAIL");
	}
}
//TC_InsightGeneral_155
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
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_Help_Api"))).click();
	Thread.sleep(3000);
}

@Given("^Click on Python SDK and Verify 'API SDK' download$")
public void click_on_Python_SDK_and_Verify_API_SDK_download() throws Throwable {
	File file = new File(
			System.getProperty("user.home")
					+ "\\Downloads\\ceic_api_client-1.4.14.55.tar.gz");
	file.delete();

	Thread.sleep(7000);
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_SDK_dwnload"))).click();
Thread.sleep(10000);
String downloadPath = System.getProperty("user.home")
			+ "\\Downloads";
	File getLatestFile = getLatestFilefromDir(downloadPath);
	String fileName = getLatestFile.getName();
	System.out.println(fileName);
	String sdk = login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("sdk1"))).getText();
	boolean text = fileName
			.equalsIgnoreCase(sdk);
	Assert.assertTrue(text, "Failed to download");
	close_insight();
	}
//TC_InsightGeneral_156
@Given("^Verify 'API SDK' download through URL$")
public void verify_API_SDK_download_through_URL() throws Throwable {
   String downoladURL="https://downloads-stage.ceicdata.com/php/";
   login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_SDK_drpdwn"))).click();
   Thread.sleep(2000);
   /*WebElement PHPselect = login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_select_php")));
   Thread.sleep(3000);
   action.moveToElement(PHPselect).build().perform();
   Thread.sleep(3000);*/
   login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_select_php"))).click();
   Thread.sleep(3000);
   String copiedText=  login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_text"))).getText();
   System.out.println(copiedText);
   //Take url from text
   String text="require: {ceic/api: *},"+"repositories"+":[{type: composer,"+"url: https://downloads-stage.ceicdata.com/php/"+" }]";
   String[] parts = text.split("url: ");
   String part2 = parts[1]; 
   parts = part2.split("}]");
   part2 = parts[0]; 
   System.out.println(part2);
   Robot robot = new Robot();
   robot.keyPress(KeyEvent.VK_CONTROL); 
   robot.keyPress(KeyEvent.VK_T); 
   robot.keyRelease(KeyEvent.VK_CONTROL); 
   robot.keyRelease(KeyEvent.VK_T);
   switch_to_new_tab();
   Thread.sleep(3000);
   login.driver.navigate().to(part2);
   //Thread.sleep(10000);
   
   File file = new File(
			System.getProperty("user.home")
					+ "\\Downloads\\ceic-api-1.1.0.2.zip");
	file.delete();
	
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_download_file"))).click();
   Thread.sleep(15000);
//   login.driver.findElement(
//			By.xpath(login.LOCATORS.getProperty("Ig_download_file"))).click();
	String downloadPath = System.getProperty("user.home")
			+ "\\Downloads";
	File getLatestFile = getLatestFilefromDir(downloadPath);
	String fileName = getLatestFile.getName();
	System.out.println(fileName);
	boolean filedwnloaded = fileName
			.equalsIgnoreCase("ceic-api-1.1.0.2.zip");
	Assert.assertTrue(filedwnloaded, "Failed to download");
	close_new_tab();
	close_insight();
	
}
//TC_InsightGeneral_157
@Given("^Click on R$")
public void click_on_R() throws Throwable {
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_help_R"))).click();
	Thread.sleep(3000);
}

@Given("^Verify R tab is open$")
public void verify_R_tab_is_open() throws Throwable {
	if (login.driver.findElements(
			By.xpath(login.LOCATORS.getProperty("Ig_R_tab"))).size() != 0){
		
				System.out.println("R tab is active");
				close_insight();
		}
	else{
		close_insight();
		Assert.fail("FAIL");
	}
}
//TC_InsightGeneral_158
@Given("^Verify 'R' package download$")
public void verify_R_package_download() throws Throwable {
	File file = new File(
			System.getProperty("user.home")
					+ "\\Downloads\\ceic_1.1.0-5.tar.gz");
	file.delete();

	Thread.sleep(7000);
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_R_pck_dwnload"))).click();
Thread.sleep(8000);
String downloadPath = System.getProperty("user.home")
			+ "\\Downloads";
	File getLatestFile = getLatestFilefromDir(downloadPath);
	String fileName = getLatestFile.getName();
	Thread.sleep(5000);
	System.out.println(fileName);
	boolean text = fileName
			.equalsIgnoreCase("ceic_1.1.0-5.tar.gz");
	Assert.assertTrue(text, "Failed to download");
	close_insight();
}
//TC_InsightGeneral_160
@Given("^Click on Document links and Verify$")
public void click_on_Document_links_and_Verify() throws Throwable {
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_R_doc_link"))).click();
	switch_to_new_tab();
	String Actual_URL="https://downloads-stage.ceicdata.com/R/documentation/CEIC%20R%20Package%20-%20Quick%20Start%20Guide.pdf";
	String Ex_URL=login.driver.getCurrentUrl();
	close_new_tab();
	Assert.assertEquals(Actual_URL, Ex_URL);
	close_insight();
}
//TC_InsightGeneral_161
@Given("^Click on Eviews$")
public void click_on_Eviews() throws Throwable {
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_help_eviews"))).click();
	Thread.sleep(3000);
	
}

@Given("^Verify 'EViews'$")
public void verify_EViews() throws Throwable {
	if (login.driver.findElements(
			By.xpath(login.LOCATORS.getProperty("Ig_eview_tab_open"))).size() != 0){
		
				System.out.println("Eview tab is active");
				close_insight();
		}
	else{
		close_insight();
		Assert.fail("FAIL");
	}
}
//TC_InsightGeneral_162
@Given("^Click on Download CEIC EViews Module (\\d+)-Bit and Verify$")
public void click_on_Download_CEIC_EViews_Module_Bit_and_Verify(int arg1) throws Throwable {
	
	File file = new File(
			System.getProperty("user.home")
					+ "\\Downloads\\CEICData-Eviews_32_1.1.zip");
	file.delete();

	Thread.sleep(5000);
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_eview_32bit"))).click();
	Thread.sleep(5000);
String downloadPath = System.getProperty("user.home")
			+ "\\Downloads";
	File getLatestFile = getLatestFilefromDir(downloadPath);
	String fileName = getLatestFile.getName();
	Thread.sleep(5000);
	System.out.println(fileName);
	boolean text = fileName
			.equalsIgnoreCase("CEICData-Eviews_32_1.1.zip");
	Assert.assertTrue(text, "Failed to download");
}

@Given("^Click on Download CEIC EViews Module (\\d+)-Bit$")
public void click_on_Download_CEIC_EViews_Module_Bit(int arg1) throws Throwable {
	
	File file = new File(
			System.getProperty("user.home")
					+ "\\Downloads\\CEICData-Eviews_64_1.1.zip");
	file.delete();

	Thread.sleep(7000);
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_eview_64bit"))).click();
	Thread.sleep(5000);
	String downloadPath = System.getProperty("user.home")
			+ "\\Downloads";
	File getLatestFile = getLatestFilefromDir(downloadPath);
	String fileName = getLatestFile.getName();
	Thread.sleep(5000);
	System.out.println(fileName);
	boolean text = fileName
			.equalsIgnoreCase("CEICData-Eviews_64_1.1.zip");
	Assert.assertTrue(text, "Failed to download");
	close_insight();
}
//TC_InsightGeneral_163
@Given("^Click on  Eviews Document links and Verify$")
public void click_on_Eviews_Document_links_and_Verify() throws Throwable {
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_R_doc_link"))).click();
	switch_to_new_tab();
	String Actual_URL="https://downloads-stage.ceicdata.com/eviews/documentation/CEIC-EViews%20Module%20-%20Quick%20Start%20Guide.pdf";
	String Ex_URL=login.driver.getCurrentUrl();
	close_new_tab();
	Assert.assertEquals(Actual_URL, Ex_URL);
	close_insight();
}
//TC_InsightGeneral_164
@Given("^Add Series to myseries$")
public void add_Series_to_myseries() throws Throwable {
	adding_series_to_myseries();
}

@Given("^Verify Undo option enable\\.$")
public void verify_Undo_option_enable() throws Throwable {
	if (login.driver.findElements(
			By.xpath(login.LOCATORS.getProperty("Ig_series_undo"))).size() != 0){
					System.out.println("Undo option is enable");
		}
	else{
		
		Assert.fail("FAIL");
	}
}
//TC_InsightGeneral_165
@Given("^Click on Undo icon$")
public void click_on_Undo_icon() throws Throwable {
	WebElement undo = login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_series_undo")));
	Thread.sleep(5000);
	action.moveToElement(undo).build().perform();
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_series_undo"))).click();
	Thread.sleep(5000);
}

@Given("^Verify Redo option enable$")
public void verify_Redo_option_enable() throws Throwable {
	if (login.driver.findElements(
			By.xpath(login.LOCATORS.getProperty("Ig_redo"))).size() != 0){
		
				System.out.println("Redo option is enable");
				login.driver.findElement(
						By.xpath(login.LOCATORS.getProperty("Series_tab"))).click();
				login.driver.findElement(
						By.xpath(login.LOCATORS
								.getProperty("my_series_filter_checkbox"))).click();
				Thread.sleep(5000);
				
				login.driver.findElement(
						By.xpath(login.LOCATORS.getProperty("delete_myeries"))).click();
				Thread.sleep(5000);
								delete_all_views();
		}
	else{
		
		Assert.fail("FAIL");
	}
}
//TC_InsightGeneral_166
@Given("^Adding series to myseries$")
public void adding_series_to_myseries() throws Throwable {
	Footnotes f = new Footnotes();
	f.goto_Db_Search_tab();
	f.expand_the_database();
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_seriestoadd"))).click();
	Thread.sleep(2000);
	action.sendKeys("a").perform();
}

@Given("^Verify Undo option behavior for My series tab\\.$")
public void verify_Undo_option_behavior_for_My_series_tab() throws Throwable {
	if (login.driver.findElements(
			By.xpath(login.LOCATORS.getProperty("Ig_undo_changes"))).size() != 0){
		
				System.out.println("Undo is working");
				
		}
	else{
		
		Assert.fail("FAIL");
	}
}
//TC_InsightGeneral_167
@Given("^Click on Redo icon$")
public void click_on_Redo_icon() throws Throwable {
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_redo"))).click();
	Thread.sleep(4000);
}

@Given("^Verify Redo option behavior for my series tab\\.$")
public void verify_Redo_option_behavior_for_my_series_tab() throws Throwable {
	if (login.driver.findElements(
			By.xpath(login.LOCATORS.getProperty("Ig_Redo_changes"))).size() != 0){
		
				System.out.println("Undo is working");
				Thread.sleep(2000);
				login.driver.findElement(
						By.xpath(login.LOCATORS
								.getProperty("my_series_filter_checkbox"))).click();
				Thread.sleep(5000);
				login.driver.findElement(
						By.xpath(login.LOCATORS.getProperty("delete_myeries"))).click();
				Thread.sleep(5000);
		}
	else{
		
		Assert.fail("FAIL");
	}
}
//TC_InsightGeneral_168
@Given("^Add Visual$")
public void add_Visual() throws Throwable {
	login.driver.findElement(
			By.xpath(login.LOCATORS
					.getProperty("Ig_addview_btn"))).click();
	//delete_all_views();
	login.driver.findElement(
			By.xpath(login.LOCATORS
					.getProperty("Ig_addview_btn"))).click();
	
}

@Given("^Verify Undo option for views tab\\.$")
public void verify_Undo_option_for_views_tab() throws Throwable {
	
	if (login.driver.findElements(
			By.xpath(login.LOCATORS.getProperty("Ig_undo_changes"))).size() != 0){
		
				System.out.println("visual has been undo");
			
			
						}
	else{
		
		Assert.fail("FAIL");
	}
}
//TC_InsightGeneral_169
@Given("^Verify Redo option for views tab\\.$")
public void verify_Redo_option_for_views_tab() throws Throwable {
	if (login.driver.findElements(
			By.xpath(login.LOCATORS.getProperty("Ig_168_redo"))).size() != 0){
		
				System.out.println("visual has been undo");
				delete_all_views();
			
						}
	else{
		
		Assert.fail("FAIL");
	}
}
//TC_InsightGeneral_169
@Given("^Adding series to visual$")
public void adding_series_to_visual() throws Throwable {
	

	Footnotes f = new Footnotes();
	f.goto_Db_Search_tab();
	f.expand_the_database();
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_seriestoadd"))).click();
	Thread.sleep(2000);
	action.sendKeys("c").perform();
}

@Given("^Click on Undo and Verify$")
public void click_on_Undo_and_Verify() throws Throwable {
	click_on_Undo_icon();
	if (login.driver.findElements(
			By.xpath(login.LOCATORS.getProperty("Ig_redo"))).size() != 0){
		
				System.out.println("visual with series has been undo");
				//delete_all_views();
			
						}
	else{
		
		Assert.fail("FAIL");
	}
}

@Given("^Click on Redo and Verify$")
public void click_on_Redo_and_Verify() throws Throwable {
   click_on_Redo_icon();
   if (login.driver.findElements(
			By.xpath(login.LOCATORS.getProperty("Ig_visual_series_redo"))).size() != 0){
		
				System.out.println("visual with series has been redone");
			Thread.sleep(4000);
			delete_all_views();
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Ig_save_enable"))).click();
						}
	else{
		
		Assert.fail("FAIL");
	}
}
//TC_InsightGeneral_171
@Given("^Enter Keyword GDP in Search$")
public void enter_Keyword_GDP_in_Search() throws Throwable {
/*	
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Footnote_Search_input")))
			.click();
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Footnote_Search_input")))
			.clear();*/
	login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Footnote_Search_input")))
			.sendKeys("GDP");
	Thread.sleep(9000);
	
}
@Given("^Click on Undo and Verify Undo for search tab\\.$")
public void click_on_Undo_and_Verify_Undo_for_search_tab() throws Throwable {
    click_on_Undo_icon();
    Thread.sleep(4000);
    String ActualundoText="What can we help you find?";
    String ExpectedText=login.driver.findElement(
			By.xpath(login.LOCATORS.getProperty("Ig_search_undo"))).getAttribute("placeholder");
    Assert.assertEquals(ActualundoText, ExpectedText);
    Thread.sleep(2000);
}
@Given("^Click on Redo and Verify Redo for search tab\\.$")
public void click_on_Redo_and_Verify_Redo_for_search_tab() throws Throwable {
    click_on_Redo_icon();
    Thread.sleep(4000);
    if (login.driver.findElements(
			By.xpath(login.LOCATORS.getProperty("Ig_Search_redo"))).size() != 0){
						System.out.println("Redo has been done for search tab");
			click_on_Undo_icon();
			delete_series();
}
	else{
		
		Assert.fail("FAIL");
	}
  
}
}



